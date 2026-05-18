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
/* 191 */     return (LowShadowHerobrineCloneEntity.this.possessedByEntity != null && LowShadowHerobrineCloneEntity.this.possessedByEntity.m_6084_() && LowShadowHerobrineCloneEntity.this.m_20270_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity) > 18.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/* 196 */     if (LowShadowHerobrineCloneEntity.this.possessedByEntity != null && LowShadowHerobrineCloneEntity.this.possessedByEntity.m_6084_()) {
/* 197 */       LowShadowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity, 2.0D);
/* 198 */       LowShadowHerobrineCloneEntity.this.m_21563_().m_24960_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity, 30.0F, 30.0F);
/* 199 */       if (LowShadowHerobrineCloneEntity.this.m_20280_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity) > 20.0D) {
/* 200 */         if (LowShadowHerobrineCloneEntity.this.m_21573_().m_26571_()) {
/* 201 */           LowShadowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity, 2.0D);
/*     */         }
/*     */       } else {
/* 204 */         LowShadowHerobrineCloneEntity.this.m_21573_().m_26573_();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 211 */     return (LowShadowHerobrineCloneEntity.this.possessedByEntity != null && LowShadowHerobrineCloneEntity.this.possessedByEntity.m_6084_() && LowShadowHerobrineCloneEntity.this.m_20270_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity) > 50.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\LowShadowHerobrineCloneEntity$2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */