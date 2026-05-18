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
/*     */ class null
/*     */   extends Goal
/*     */ {
/*     */   public boolean m_8036_() {
/* 189 */     return (LowHerobrineCloneEntity.this.protectEntity != null && LowHerobrineCloneEntity.this.protectEntity.m_6084_() && LowHerobrineCloneEntity.this.m_20270_((Entity)LowHerobrineCloneEntity.this.protectEntity) > 9.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/* 194 */     if (LowHerobrineCloneEntity.this.protectEntity != null && LowHerobrineCloneEntity.this.protectEntity.m_6084_()) {
/* 195 */       LowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowHerobrineCloneEntity.this.protectEntity, 2.0D);
/* 196 */       LowHerobrineCloneEntity.this.m_21563_().m_24960_((Entity)LowHerobrineCloneEntity.this.protectEntity, 30.0F, 30.0F);
/* 197 */       if (LowHerobrineCloneEntity.this.m_20280_((Entity)LowHerobrineCloneEntity.this.protectEntity) > 10.0D) {
/* 198 */         if (LowHerobrineCloneEntity.this.m_21573_().m_26571_()) {
/* 199 */           LowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowHerobrineCloneEntity.this.protectEntity, 2.0D);
/*     */         }
/*     */       } else {
/* 202 */         LowHerobrineCloneEntity.this.m_21573_().m_26573_();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 209 */     return (LowHerobrineCloneEntity.this.protectEntity != null && LowHerobrineCloneEntity.this.protectEntity.m_6084_() && LowHerobrineCloneEntity.this.m_20270_((Entity)LowHerobrineCloneEntity.this.protectEntity) > 50.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\LowHerobrineCloneEntity$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */