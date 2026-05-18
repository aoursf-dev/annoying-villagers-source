/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends Goal
/*     */ {
/*     */   public boolean m_8036_() {
/* 132 */     return (NullSkeletonEntity.this.player != null && NullSkeletonEntity.this.player.m_6084_() && NullSkeletonEntity.this.m_20270_((Entity)NullSkeletonEntity.this.player) > 18.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/* 137 */     if (NullSkeletonEntity.this.player != null && NullSkeletonEntity.this.player.m_6084_()) {
/* 138 */       NullSkeletonEntity.this.m_21573_().m_5624_((Entity)NullSkeletonEntity.this.player, 2.0D);
/* 139 */       NullSkeletonEntity.this.m_21563_().m_24960_((Entity)NullSkeletonEntity.this.player, 30.0F, 30.0F);
/* 140 */       if (NullSkeletonEntity.this.m_20280_((Entity)NullSkeletonEntity.this.player) > 20.0D) {
/* 141 */         if (NullSkeletonEntity.this.m_21573_().m_26571_()) {
/* 142 */           NullSkeletonEntity.this.m_21573_().m_5624_((Entity)NullSkeletonEntity.this.player, 2.0D);
/*     */         }
/*     */       } else {
/* 145 */         NullSkeletonEntity.this.m_21573_().m_26573_();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 152 */     return (NullSkeletonEntity.this.player != null && NullSkeletonEntity.this.player.m_6084_() && NullSkeletonEntity.this.m_20270_((Entity)NullSkeletonEntity.this.player) > 50.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\NullSkeletonEntity$2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */