/*     */ package com.pla.annoyingvillagers.util;
/*     */ 
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.LivingEntity;
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
/*     */ public final class LocalSpace
/*     */ {
/* 154 */   private static final Vec3 UP = new Vec3(0.0D, 1.0D, 0.0D);
/*     */   
/*     */   public static Vec3 forward(LivingEntity e) {
/* 157 */     float yawRad = e.f_20883_ * 0.017453292F;
/* 158 */     return (new Vec3(-Mth.m_14031_(yawRad), 0.0D, Mth.m_14089_(yawRad))).m_82541_();
/*     */   }
/*     */   
/*     */   public static Vec3 right(LivingEntity e) {
/* 162 */     Vec3 f = forward(e);
/* 163 */     return UP.m_82537_(f).m_82541_();
/*     */   }
/*     */   
/*     */   public static Vec3 left(LivingEntity e) {
/* 167 */     return right(e).m_82490_(-1.0D);
/*     */   }
/*     */   
/*     */   public static Vec3 back(LivingEntity e) {
/* 171 */     return forward(e).m_82490_(-1.0D);
/*     */   }
/*     */   
/*     */   public static Vec3 localOffsetPos(LivingEntity e, double leftU, double upU, double forwardU) {
/* 175 */     Vec3 base = e.m_20182_();
/*     */ 
/*     */     
/* 178 */     Vec3 off = left(e).m_82490_(leftU).m_82549_(UP.m_82490_(upU)).m_82549_(forward(e).m_82490_(forwardU));
/* 179 */     return base.m_82549_(off);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\SnakeBladeHit$LocalSpace.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */