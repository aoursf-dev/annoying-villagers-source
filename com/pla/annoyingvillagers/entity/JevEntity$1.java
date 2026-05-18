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
/*     */ class null
/*     */   extends Goal
/*     */ {
/*     */   public boolean m_8036_() {
/*  80 */     return (JevEntity.this.followTarget != null && JevEntity.this.followTarget.m_6084_() && JevEntity.this.m_20270_((Entity)JevEntity.this.followTarget) > 18.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/*  85 */     if (JevEntity.this.followTarget != null && JevEntity.this.followTarget.m_6084_()) {
/*  86 */       JevEntity.this.m_21573_().m_5624_((Entity)JevEntity.this.followTarget, 2.0D);
/*  87 */       JevEntity.this.m_21563_().m_24960_((Entity)JevEntity.this.followTarget, 30.0F, 30.0F);
/*  88 */       if (JevEntity.this.m_20280_((Entity)JevEntity.this.followTarget) > 20.0D) {
/*  89 */         if (JevEntity.this.m_21573_().m_26571_()) {
/*  90 */           JevEntity.this.m_21573_().m_5624_((Entity)JevEntity.this.followTarget, 2.0D);
/*     */         }
/*     */       } else {
/*  93 */         JevEntity.this.m_21573_().m_26573_();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 100 */     return (JevEntity.this.followTarget != null && JevEntity.this.followTarget.m_6084_() && JevEntity.this.m_20270_((Entity)JevEntity.this.followTarget) > 50.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\JevEntity$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */