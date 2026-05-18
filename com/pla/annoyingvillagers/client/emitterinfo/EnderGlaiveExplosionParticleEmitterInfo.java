/*    */ package com.pla.annoyingvillagers.client.emitterinfo;
/*    */ import java.util.Objects;
/*    */ import mod.chloeprime.aaaparticles.api.client.effekseer.ParticleEmitter;
/*    */ import mod.chloeprime.aaaparticles.api.common.DynamicParameter;
/*    */ import mod.chloeprime.aaaparticles.client.installer.NativePlatform;
/*    */ import mod.chloeprime.aaaparticles.client.registry.EffectDefinition;
/*    */ import mod.chloeprime.aaaparticles.client.registry.EffectRegistry;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ public class EnderGlaiveExplosionParticleEmitterInfo extends ParticleEmitterInfo {
/*    */   public enum ForwardAxis {
/* 15 */     PLUS_Z, PLUS_Y;
/*    */   }
/* 17 */   private ForwardAxis axis = ForwardAxis.PLUS_Z;
/* 18 */   private float roll = 0.0F;
/* 19 */   private Vec3 from = null;
/* 20 */   private Vec3 to = null;
/*    */   
/*    */   public EnderGlaiveExplosionParticleEmitterInfo(ResourceLocation resourceLocation) {
/* 23 */     super(resourceLocation);
/*    */   }
/*    */   
/*    */   public EnderGlaiveExplosionParticleEmitterInfo fromTo(Vec3 from, Vec3 to, ForwardAxis axis, float extraRollRad, boolean flip) {
/* 27 */     this.from = from;
/* 28 */     this.to = to;
/* 29 */     this.axis = axis;
/* 30 */     this.roll = extraRollRad;
/* 31 */     return this;
/*    */   }
/*    */   private static void aim(ParticleEmitter em, Vec3 from, Vec3 to, ForwardAxis axis, float roll, boolean flip) {
/*    */     float yaw, pitch;
/* 35 */     Vec3 d = to.m_82546_(from);
/* 36 */     if (flip) d = d.m_82490_(-1.0D); 
/* 37 */     double xz = Math.sqrt(d.f_82479_ * d.f_82479_ + d.f_82481_ * d.f_82481_);
/*    */     
/* 39 */     switch (axis) {
/*    */       case PLUS_Z:
/* 41 */         yaw = (float)Math.atan2(d.f_82479_, d.f_82481_);
/* 42 */         pitch = (float)-Math.atan2(d.f_82480_, xz);
/* 43 */         em.setRotation(pitch, yaw, roll);
/*    */         break;
/*    */       case PLUS_Y:
/* 46 */         yaw = (float)Math.atan2(d.f_82481_, d.f_82479_) + 1.5707964F;
/* 47 */         pitch = (float)Math.atan2(xz, d.f_82480_) - 1.5707964F;
/* 48 */         em.setRotation(pitch, yaw, roll);
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void spawnInWorld(Level level, Player player) {
/* 55 */     if (NativePlatform.isRunningOnUnsupportedPlatform())
/* 56 */       return;  if (this.from == null || this.to == null)
/*    */       return; 
/* 58 */     Optional.<EffectDefinition>ofNullable(EffectRegistry.get(this.effek)).ifPresent(eff -> {
/*    */           ParticleEmitter em = hasEmitter() ? eff.play(this.emitter) : eff.play();
/*    */           if (hasParameters())
/*    */             for (DynamicParameter p : this.parameters)
/*    */               em.setDynamicInput(p.index(), p.value());  
/*    */           if (hasTriggers()) {
/*    */             Objects.requireNonNull(em);
/*    */             this.triggers.forEach(em::sendTrigger);
/*    */           } 
/*    */           em.setPosition((float)this.from.f_82479_, (float)this.from.f_82480_, (float)this.from.f_82481_);
/*    */           aim(em, this.from, this.to, this.axis, this.roll);
/*    */         }); } private static void aim(ParticleEmitter em, Vec3 from, Vec3 to, ForwardAxis axis, float roll) { float yaw, pitch;
/* 70 */     Vec3 d = to.m_82546_(from);
/* 71 */     double xz = Math.sqrt(d.f_82479_ * d.f_82479_ + d.f_82481_ * d.f_82481_);
/*    */     
/* 73 */     switch (axis) {
/*    */       case PLUS_Z:
/* 75 */         yaw = (float)Math.atan2(d.f_82479_, d.f_82481_);
/* 76 */         pitch = (float)-Math.atan2(d.f_82480_, xz);
/* 77 */         em.setRotation(pitch, yaw, roll);
/*    */         break;
/*    */       case PLUS_Y:
/* 80 */         yaw = (float)Math.atan2(d.f_82481_, d.f_82479_) + 1.5707964F;
/* 81 */         pitch = (float)Math.atan2(xz, d.f_82480_) - 1.5707964F;
/* 82 */         em.setRotation(pitch, yaw, roll);
/*    */         break;
/*    */     }  }
/*    */ 
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\emitterinfo\EnderGlaiveExplosionParticleEmitterInfo.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */