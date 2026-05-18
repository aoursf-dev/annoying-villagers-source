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
/*    */ public class GregData
/*    */   extends SavedData
/*    */ {
/*    */   public static final String ID = "av_singleton_greg";
/* 15 */   private UUID activeId = null;
/* 16 */   private long claimTick = 0L;
/*    */   private static final long COOLDOWN_TICKS = 12000L;
/*    */   
/*    */   public UUID getActiveId() {
/* 20 */     return this.activeId;
/*    */   }
/*    */   
/*    */   public static GregData get(ServerLevel serverLevel) {
/* 24 */     return (GregData)serverLevel.m_8895_().m_164861_(GregData::load, GregData::new, "av_singleton_greg");
/*    */   }
/*    */   
/*    */   public static GregData load(CompoundTag compoundTag) {
/* 28 */     GregData gregData = new GregData();
/* 29 */     if (compoundTag.m_128403_("activeId")) {
/* 30 */       gregData.activeId = compoundTag.m_128342_("activeId");
/*    */     }
/* 32 */     if (compoundTag.m_128425_("claimTick", 4)) {
/* 33 */       gregData.claimTick = compoundTag.m_128454_("claimTick");
/*    */     }
/* 35 */     return gregData;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public CompoundTag m_7176_(@NotNull CompoundTag compoundTag) {
/* 40 */     if (this.activeId != null) {
/* 41 */       compoundTag.m_128362_("activeId", this.activeId);
/*    */     }
/* 43 */     compoundTag.m_128356_("claimTick", this.claimTick);
/* 44 */     return compoundTag;
/*    */   }
/*    */   
/*    */   private static long now(ServerLevel level) {
/* 48 */     return level.m_46467_();
/*    */   }
/*    */   
/*    */   public boolean isOccupied(ServerLevel serverLevel) {
/* 52 */     if (this.activeId != null) {
/* 53 */       Entity entity = serverLevel.m_8791_(this.activeId);
/* 54 */       if (entity instanceof com.pla.annoyingvillagers.entity.HerobrineGregEntity && entity.m_6084_()) {
/* 55 */         return true;
/*    */       }
/* 57 */       this.activeId = null;
/* 58 */       m_77762_();
/* 59 */       return false;
/*    */     } 
/*    */     
/* 62 */     if (this.claimTick <= 0L) return false; 
/* 63 */     long elapsed = now(serverLevel) - this.claimTick;
/* 64 */     return (elapsed < 12000L);
/*    */   }
/*    */   
/*    */   public boolean tryClaim(ServerLevel serverLevel, UUID id) {
/* 68 */     if (isOccupied(serverLevel)) {
/* 69 */       return false;
/*    */     }
/* 71 */     this.activeId = id;
/* 72 */     this.claimTick = now(serverLevel);
/* 73 */     m_77762_();
/* 74 */     return true;
/*    */   }
/*    */   public void releaseIfMatches(ServerLevel serverLevel, UUID id) {
/* 77 */     if (this.activeId != null && this.activeId.equals(id)) {
/* 78 */       this.activeId = null;
/* 79 */       this.claimTick = now(serverLevel);
/* 80 */       m_77762_();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\spawnhandler\GregData.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */