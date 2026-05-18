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
/*    */ 
/*    */ public class HerobrineMobData
/*    */   extends SavedData
/*    */ {
/*    */   public static final String ID = "av_singleton_herobrine";
/* 16 */   private UUID activeId = null;
/* 17 */   private long claimTick = 0L;
/*    */   private static final long COOLDOWN_TICKS = 12000L;
/*    */   
/*    */   public static HerobrineMobData get(ServerLevel serverLevel) {
/* 21 */     return (HerobrineMobData)serverLevel.m_8895_().m_164861_(HerobrineMobData::load, HerobrineMobData::new, "av_singleton_herobrine");
/*    */   }
/*    */   
/*    */   public static HerobrineMobData load(CompoundTag compoundTag) {
/* 25 */     HerobrineMobData herobrineData = new HerobrineMobData();
/* 26 */     if (compoundTag.m_128403_("activeId")) {
/* 27 */       herobrineData.activeId = compoundTag.m_128342_("activeId");
/*    */     }
/* 29 */     if (compoundTag.m_128425_("claimTick", 4)) {
/* 30 */       herobrineData.claimTick = compoundTag.m_128454_("claimTick");
/*    */     }
/* 32 */     return herobrineData;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public CompoundTag m_7176_(@NotNull CompoundTag compoundTag) {
/* 37 */     if (this.activeId != null) {
/* 38 */       compoundTag.m_128362_("activeId", this.activeId);
/*    */     }
/* 40 */     compoundTag.m_128356_("claimTick", this.claimTick);
/* 41 */     return compoundTag;
/*    */   }
/*    */   
/*    */   private static long now(ServerLevel level) {
/* 45 */     return level.m_46467_();
/*    */   }
/*    */   
/*    */   public boolean isOccupied(ServerLevel serverLevel) {
/* 49 */     if (this.activeId != null) {
/* 50 */       Entity entity = serverLevel.m_8791_(this.activeId);
/* 51 */       if ((entity instanceof com.pla.annoyingvillagers.clazz.HerobrineMob || entity instanceof com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity) && entity.m_6084_()) {
/* 52 */         return true;
/*    */       }
/* 54 */       this.activeId = null;
/* 55 */       m_77762_();
/* 56 */       return false;
/*    */     } 
/*    */     
/* 59 */     if (this.claimTick <= 0L) return false; 
/* 60 */     long elapsed = now(serverLevel) - this.claimTick;
/* 61 */     return (elapsed < 12000L);
/*    */   }
/*    */   
/*    */   public boolean tryClaim(ServerLevel serverLevel, UUID id) {
/* 65 */     if (isOccupied(serverLevel)) {
/* 66 */       return false;
/*    */     }
/* 68 */     this.activeId = id;
/* 69 */     this.claimTick = now(serverLevel);
/* 70 */     m_77762_();
/* 71 */     return true;
/*    */   }
/*    */   public void releaseIfMatches(ServerLevel serverLevel, UUID id) {
/* 74 */     if (this.activeId != null && this.activeId.equals(id)) {
/* 75 */       this.activeId = null;
/* 76 */       this.claimTick = now(serverLevel);
/* 77 */       m_77762_();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\spawnhandler\HerobrineMobData.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */