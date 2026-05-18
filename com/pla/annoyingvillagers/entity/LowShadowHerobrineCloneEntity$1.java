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
/*     */ class null
/*     */   extends Goal
/*     */ {
/*     */   public boolean m_8036_() {
/* 165 */     return (LowShadowHerobrineCloneEntity.this.protectEntity != null && LowShadowHerobrineCloneEntity.this.protectEntity.m_6084_() && LowShadowHerobrineCloneEntity.this.m_20270_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity) > 9.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/* 170 */     if (LowShadowHerobrineCloneEntity.this.protectEntity != null && LowShadowHerobrineCloneEntity.this.protectEntity.m_6084_()) {
/* 171 */       LowShadowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity, 2.0D);
/* 172 */       LowShadowHerobrineCloneEntity.this.m_21563_().m_24960_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity, 30.0F, 30.0F);
/* 173 */       if (LowShadowHerobrineCloneEntity.this.m_20280_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity) > 10.0D) {
/* 174 */         if (LowShadowHerobrineCloneEntity.this.m_21573_().m_26571_()) {
/* 175 */           LowShadowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity, 2.0D);
/*     */         }
/*     */       } else {
/* 178 */         LowShadowHerobrineCloneEntity.this.m_21573_().m_26573_();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 185 */     return (LowShadowHerobrineCloneEntity.this.protectEntity != null && LowShadowHerobrineCloneEntity.this.protectEntity.m_6084_() && LowShadowHerobrineCloneEntity.this.m_20270_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity) > 50.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\LowShadowHerobrineCloneEntity$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */