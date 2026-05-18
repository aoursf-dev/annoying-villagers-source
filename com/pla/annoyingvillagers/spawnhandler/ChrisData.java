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
/*    */ public class ChrisData
/*    */   extends SavedData
/*    */ {
/*    */   public static final String ID = "av_singleton_chris";
/* 15 */   private UUID activeId = null;
/* 16 */   private long claimTick = 0L;
/*    */   private static final long COOLDOWN_TICKS = 12000L;
/*    */   
/*    */   public static ChrisData get(ServerLevel serverLevel) {
/* 20 */     return (ChrisData)serverLevel.m_8895_().m_164861_(ChrisData::load, ChrisData::new, "av_singleton_chris");
/*    */   }
/*    */   
/*    */   public static ChrisData load(CompoundTag compoundTag) {
/* 24 */     ChrisData chrisData = new ChrisData();
/* 25 */     if (compoundTag.m_128403_("activeId")) {
/* 26 */       chrisData.activeId = compoundTag.m_128342_("activeId");
/*    */     }
/* 28 */     if (compoundTag.m_128425_("claimTick", 4)) {
/* 29 */       chrisData.claimTick = compoundTag.m_128454_("claimTick");
/*    */     }
/* 31 */     return chrisData;
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
/* 50 */       if (entity instanceof com.pla.annoyingvillagers.entity.ChrisEntity && entity.m_6084_()) {
/* 51 */         return true;
/*    */       }
/* 53 */       this.activeId = null;
/* 54 */       m_77762_();
/*    */     } 
/* 56 */     if (this.claimTick <= 0L) return false; 
/* 57 */     long elapsed = now(serverLevel) - this.claimTick;
/* 58 */     return (elapsed < 12000L);
/*    */   }
/*    */   
/*    */   public boolean tryClaim(ServerLevel serverLevel, UUID id) {
/* 62 */     if (isOccupied(serverLevel)) {
/* 63 */       return false;
/*    */     }
/* 65 */     this.activeId = id;
/* 66 */     this.claimTick = now(serverLevel);
/* 67 */     m_77762_();
/* 68 */     return true;
/*    */   }
/*    */   
/*    */   public void releaseIfMatches(ServerLevel serverLevel, UUID id) {
/* 72 */     if (this.activeId != null && this.activeId.equals(id)) {
/* 73 */       this.activeId = null;
/* 74 */       this.claimTick = now(serverLevel);
/* 75 */       m_77762_();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\spawnhandler\ChrisData.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */