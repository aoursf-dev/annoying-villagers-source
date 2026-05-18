/*     */ package com.pla.annoyingvillagers.clazz;
/*     */ 
/*     */ import java.util.EnumSet;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null() {
/* 222 */     m_7021_(EnumSet.of(Goal.Flag.MOVE));
/*     */   }
/*     */   
/*     */   public boolean m_8036_() {
/* 226 */     return (NullWeapon.this.m_5448_() != null && !NullWeapon.this.m_21566_().m_24995_());
/*     */   }
/*     */   
/*     */   public boolean m_8045_() {
/* 230 */     return (NullWeapon.this.m_21566_().m_24995_() && NullWeapon.this.m_5448_() != null && NullWeapon.this.m_5448_().m_6084_());
/*     */   }
/*     */   
/*     */   public void m_8056_() {
/* 234 */     LivingEntity livingentity = NullWeapon.this.m_5448_();
/* 235 */     if (livingentity == null)
/* 236 */       return;  Vec3 vec3 = livingentity.m_20299_(1.0F);
/*     */     
/* 238 */     NullWeapon.access$000(NullWeapon.this).m_6849_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, 2.0D);
/*     */   }
/*     */   
/*     */   public void m_8037_() {
/* 242 */     LivingEntity livingentity = NullWeapon.this.m_5448_();
/* 243 */     if (livingentity == null)
/* 244 */       return;  if (NullWeapon.this.m_20191_().m_82381_(livingentity.m_20191_())) {
/* 245 */       NullWeapon.this.m_7327_((Entity)livingentity);
/*     */     } else {
/* 247 */       double d0 = NullWeapon.this.m_20280_((Entity)livingentity);
/*     */       
/* 249 */       if (d0 < 16.0D) {
/* 250 */         Vec3 vec3 = livingentity.m_20299_(1.0F);
/*     */         
/* 252 */         NullWeapon.access$100(NullWeapon.this).m_6849_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, 2.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\NullWeapon$3.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */