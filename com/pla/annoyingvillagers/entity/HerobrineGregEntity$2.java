/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 238 */     return (HerobrineGregEntity.this.secondSummonedHerobrine != null && HerobrineGregEntity.this.secondSummonedHerobrine.m_6084_() && HerobrineGregEntity.this.m_20270_(HerobrineGregEntity.this.secondSummonedHerobrine) > 18.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/* 243 */     if (HerobrineGregEntity.this.secondSummonedHerobrine != null && HerobrineGregEntity.this.secondSummonedHerobrine.m_6084_()) {
/* 244 */       HerobrineGregEntity.this.m_21573_().m_5624_(HerobrineGregEntity.this.secondSummonedHerobrine, 2.0D);
/* 245 */       HerobrineGregEntity.this.m_21563_().m_24960_(HerobrineGregEntity.this.secondSummonedHerobrine, 30.0F, 30.0F);
/* 246 */       if (HerobrineGregEntity.this.m_20280_(HerobrineGregEntity.this.secondSummonedHerobrine) > 20.0D) {
/* 247 */         if (HerobrineGregEntity.this.m_21573_().m_26571_()) {
/* 248 */           HerobrineGregEntity.this.m_21573_().m_5624_(HerobrineGregEntity.this.secondSummonedHerobrine, 2.0D);
/*     */         }
/*     */       } else {
/* 251 */         HerobrineGregEntity.this.m_21573_().m_26573_();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 258 */     return (HerobrineGregEntity.this.secondSummonedHerobrine != null && HerobrineGregEntity.this.secondSummonedHerobrine.m_6084_() && HerobrineGregEntity.this.m_20270_(HerobrineGregEntity.this.secondSummonedHerobrine) > 50.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\HerobrineGregEntity$2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */