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
/*     */ class null
/*     */   extends Goal
/*     */ {
/*     */   public boolean m_8036_() {
/*  95 */     return (NullSkeletonEntity.this.nullEntity != null && NullSkeletonEntity.this.nullEntity.m_6084_() && NullSkeletonEntity.this.m_20270_((Entity)NullSkeletonEntity.this.nullEntity) > 18.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/* 100 */     if (NullSkeletonEntity.this.nullEntity != null && NullSkeletonEntity.this.nullEntity.m_6084_()) {
/* 101 */       NullSkeletonEntity.this.m_21573_().m_5624_((Entity)NullSkeletonEntity.this.nullEntity, 2.0D);
/* 102 */       NullSkeletonEntity.this.m_21563_().m_24960_((Entity)NullSkeletonEntity.this.nullEntity, 30.0F, 30.0F);
/* 103 */       if (NullSkeletonEntity.this.m_20280_((Entity)NullSkeletonEntity.this.nullEntity) > 20.0D) {
/* 104 */         if (NullSkeletonEntity.this.m_21573_().m_26571_()) {
/* 105 */           NullSkeletonEntity.this.m_21573_().m_5624_((Entity)NullSkeletonEntity.this.nullEntity, 2.0D);
/*     */         }
/*     */       } else {
/* 108 */         NullSkeletonEntity.this.m_21573_().m_26573_();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 115 */     return (NullSkeletonEntity.this.nullEntity != null && NullSkeletonEntity.this.nullEntity.m_6084_() && NullSkeletonEntity.this.m_20270_((Entity)NullSkeletonEntity.this.nullEntity) > 50.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\NullSkeletonEntity$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */