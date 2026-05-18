/*    */ package com.pla.annoyingvillagers.spawnhandler;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.saveddata.SavedData;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class BluedemonData
/*    */   extends SavedData
/*    */ {
/*    */   public static final String ID = "av_singleton_blue_demon";
/* 15 */   private UUID activeId = null;
/* 16 */   private long claimTick = 0L;
/*    */   private static final long COOLDOWN_TICKS = 12000L;
/*    */   
/*    */   public static BluedemonData get(ServerLevel serverLevel) {
/* 20 */     return (BluedemonData)serverLevel.m_8895_().m_164861_(BluedemonData::load, BluedemonData::new, "av_singleton_blue_demon");
/*    */   }
/*    */   
/*    */   public static BluedemonData load(CompoundTag compoundTag) {
/* 24 */     BluedemonData bluedemonData = new BluedemonData();
/* 25 */     if (compoundTag.m_128403_("activeId")) {
/* 26 */       bluedemonData.activeId = compoundTag.m_128342_("activeId");
/*    */     }
/* 28 */     if (compoundTag.m_128425_("claimTick", 4)) {
/* 29 */       bluedemonData.claimTick = compoundTag.m_128454_("claimTick");
/*    */     }
/* 31 */     return bluedemonData;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public CompoundTag m_7176_(@NotNull CompoundTag compoundTag) {
/* 36 */     if (this.activeId != null) {
/* 37 */       compoundTag.m_128362_("activeId", this.activeId);
/*    */     }
/* 39 */     compoundTag.m_128356_("claimTick", this.claimTick);
/* 40 */     return compoundTag;
/*    */   }
/*    */   
/*    */   private static long now(ServerLevel level) {
/* 44 */     return level.m_46467_();
/*    */   }
/*    */   
/*    */   public boolean isOccupied(ServerLevel serverLevel) {
/* 48 */     if (this.activeId != null) {
/* 49 */       Entity entity = serverLevel.m_8791_(this.activeId);
/* 50 */       if (entity instanceof com.pla.annoyingvillagers.entity.BlueDemonEntity && entity.m_6084_()) {
/* 51 */         return true;
/*    */       }
/* 53 */       this.activeId = null;
/* 54 */       m_77762_();
/* 55 */       return false;
/*    */     } 
/*    */     
/* 58 */     if (this.claimTick <= 0L) return false; 
/* 59 */     long elapsed = now(serverLevel) - this.claimTick;
/* 60 */     return (elapsed < 12000L);
/*    */   }
/*    */   
/*    */   public boolean tryClaim(ServerLevel serverLevel, UUID id) {
/* 64 */     if (isOccupied(serverLevel)) {
/* 65 */       return false;
/*    */     }
/* 67 */     this.activeId = id;
/* 68 */     this.claimTick = now(serverLevel);
/* 69 */     m_77762_();
/* 70 */     return true;
/*    */   }
/*    */   
/*    */   public void forceClaim(ServerLevel serverLevel, UUID id) {
/* 74 */     this.activeId = id;
/* 75 */     this.claimTick = now(serverLevel);
/* 76 */     m_77762_();
/*    */   }
/*    */   
/*    */   public void releaseIfMatches(ServerLevel serverLevel, UUID id) {
/* 80 */     if (this.activeId != null && this.activeId.equals(id)) {
/* 81 */       this.activeId = null;
/* 82 */       this.claimTick = now(serverLevel);
/* 83 */       m_77762_();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\spawnhandler\BluedemonData.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */