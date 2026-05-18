/*     */ package com.pla.annoyingvillagers.client.emitterinfo;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import mod.chloeprime.aaaparticles.api.client.effekseer.ParticleEmitter;
/*     */ import mod.chloeprime.aaaparticles.api.common.DynamicParameter;
/*     */ import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
/*     */ import mod.chloeprime.aaaparticles.client.installer.NativePlatform;
/*     */ import mod.chloeprime.aaaparticles.client.registry.EffectDefinition;
/*     */ import mod.chloeprime.aaaparticles.client.registry.EffectRegistry;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.boss.EnderDragonPart;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ public class DragonBeamParticleEmitterInfo extends ParticleEmitterInfo {
/*     */   public enum ForwardAxis {
/*  22 */     PLUS_Z, PLUS_Y;
/*     */   }
/*  24 */   private WeakReference<HerobrineDragonEntity> casterRef = new WeakReference<>(null);
/*  25 */   private WeakReference<LivingEntity> targetRef = new WeakReference<>(null);
/*  26 */   private int durationTicks = 0;
/*  27 */   private ForwardAxis axis = ForwardAxis.PLUS_Z;
/*  28 */   private float roll = 0.0F;
/*  29 */   private Vec3 lastTargetPos = null;
/*     */   
/*     */   public DragonBeamParticleEmitterInfo(ResourceLocation effek) {
/*  32 */     super(effek);
/*     */   }
/*     */   public DragonBeamParticleEmitterInfo fromTo(Vec3 from, Vec3 to, ForwardAxis axis, float extraRollRad) {
/*     */     float yaw, pitch;
/*  36 */     position(from.f_82479_, from.f_82480_, from.f_82481_);
/*  37 */     this.axis = axis;
/*  38 */     this.roll = extraRollRad;
/*  39 */     this.lastTargetPos = to;
/*     */     
/*  41 */     Vec3 d = to.m_82546_(from);
/*  42 */     double xz = Math.sqrt(d.f_82479_ * d.f_82479_ + d.f_82481_ * d.f_82481_);
/*  43 */     switch (axis) {
/*     */       case PLUS_Z:
/*  45 */         yaw = (float)Math.atan2(d.f_82479_, d.f_82481_);
/*  46 */         pitch = (float)-Math.atan2(d.f_82480_, xz);
/*  47 */         rotation(pitch, yaw, extraRollRad);
/*     */         break;
/*     */       case PLUS_Y:
/*  50 */         yaw = (float)Math.atan2(d.f_82481_, d.f_82479_) + 1.5707964F;
/*  51 */         pitch = (float)Math.atan2(xz, d.f_82480_) - 1.5707964F;
/*  52 */         rotation(pitch, yaw, extraRollRad);
/*     */         break;
/*     */     } 
/*  55 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public DragonBeamParticleEmitterInfo follow(HerobrineDragonEntity caster, LivingEntity target, int durationTicks, ForwardAxis axis, float extraRollRad) {
/*  60 */     this.casterRef = new WeakReference<>(caster);
/*  61 */     this.targetRef = new WeakReference<>(target);
/*  62 */     this.durationTicks = durationTicks;
/*  63 */     this.axis = axis;
/*  64 */     this.roll = extraRollRad;
/*  65 */     return this;
/*     */   }
/*     */   
/*     */   private static Vec3 eyeLerped(EnderDragonPart e, float partial) {
/*  69 */     double x = Mth.m_14139_(partial, e.f_19790_, e.m_20185_());
/*  70 */     double y = Mth.m_14139_(partial, e.f_19791_, e.m_20186_()) + e.m_20192_();
/*  71 */     double z = Mth.m_14139_(partial, e.f_19792_, e.m_20189_());
/*  72 */     return new Vec3(x, y, z);
/*     */   }
/*     */   
/*     */   private static Vec3 eyeLerped(LivingEntity e, float partial) {
/*  76 */     double x = Mth.m_14139_(partial, e.f_19790_, e.m_20185_());
/*  77 */     double y = Mth.m_14139_(partial, e.f_19791_, e.m_20186_()) + e.m_20192_();
/*  78 */     double z = Mth.m_14139_(partial, e.f_19792_, e.m_20189_());
/*  79 */     return new Vec3(x, y, z);
/*     */   }
/*     */   private static void aim(ParticleEmitter em, Vec3 from, Vec3 to, ForwardAxis axis, float roll) {
/*     */     float yaw, pitch;
/*  83 */     Vec3 d = to.m_82546_(from);
/*  84 */     double len = d.m_82553_();
/*  85 */     if (len < 1.0E-6D) len = 1.0E-6D; 
/*  86 */     double xz = Math.sqrt(d.f_82479_ * d.f_82479_ + d.f_82481_ * d.f_82481_);
/*     */     
/*  88 */     switch (axis) {
/*     */       case PLUS_Z:
/*  90 */         yaw = (float)Math.atan2(d.f_82479_, d.f_82481_);
/*  91 */         pitch = (float)-Math.atan2(d.f_82480_, xz);
/*  92 */         em.setRotation(pitch, yaw, roll);
/*     */         break;
/*     */       case PLUS_Y:
/*  95 */         yaw = (float)Math.atan2(d.f_82481_, d.f_82479_) + 1.5707964F;
/*  96 */         pitch = (float)Math.atan2(xz, d.f_82480_) - 1.5707964F;
/*  97 */         em.setRotation(pitch, yaw, roll);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Vec3 mouthLerped(HerobrineDragonEntity herobrineDragonEntity, float partial) {
/* 103 */     return herobrineDragonEntity.beamMouthPos(partial);
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnInWorld(Level level, Player player) {
/* 108 */     if (NativePlatform.isRunningOnUnsupportedPlatform())
/*     */       return; 
/* 110 */     Optional.<EffectDefinition>ofNullable(EffectRegistry.get(this.effek)).ifPresent(eff -> {
/*     */           ParticleEmitter em = hasEmitter() ? eff.play(this.emitter) : eff.play(); if (hasParameters())
/*     */             for (DynamicParameter p : this.parameters)
/*     */               em.setDynamicInput(p.index(), p.value());   if (hasTriggers()) {
/*     */             Objects.requireNonNull(em); this.triggers.forEach(em::sendTrigger);
/*     */           }  HerobrineDragonEntity caster0 = this.casterRef.get();
/*     */           if (caster0 == null || !caster0.m_6084_()) {
/*     */             em.stop();
/*     */             return;
/*     */           } 
/*     */           int startTick = caster0.f_19797_;
/*     */           Vec3 from0 = mouthLerped(caster0, 1.0F);
/*     */           LivingEntity t0 = this.targetRef.get();
/* 123 */           Vec3 to0 = (t0 != null && t0.m_6084_()) ? new Vec3(t0.m_20185_(), t0.m_20188_(), t0.m_20189_()) : ((this.lastTargetPos != null) ? this.lastTargetPos : from0.m_82549_(caster0.m_20154_()));
/*     */           this.lastTargetPos = to0;
/*     */           em.setPosition((float)from0.f_82479_, (float)from0.f_82480_, (float)from0.f_82481_);
/*     */           aim(em, from0, to0, this.axis, this.roll);
/*     */           em.addPreDrawCallback(());
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\emitterinfo\DragonBeamParticleEmitterInfo.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */