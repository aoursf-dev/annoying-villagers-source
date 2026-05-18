/*     */ package com.pla.annoyingvillagers.client.emitterinfo;
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonThunderBeamEntity;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Objects;
/*     */ import mod.chloeprime.aaaparticles.api.client.effekseer.ParticleEmitter;
/*     */ import mod.chloeprime.aaaparticles.api.common.DynamicParameter;
/*     */ import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
/*     */ import mod.chloeprime.aaaparticles.client.installer.NativePlatform;
/*     */ import mod.chloeprime.aaaparticles.client.registry.EffectDefinition;
/*     */ import mod.chloeprime.aaaparticles.client.registry.EffectRegistry;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ public class BlueDemonThunderBeamParticleEmitterInfo extends ParticleEmitterInfo {
/*     */   public enum ForwardAxis {
/*  18 */     PLUS_Z, PLUS_Y;
/*     */   }
/*  20 */   private WeakReference<BlueDemonThunderBeamEntity> beamRef = new WeakReference<>(null);
/*  21 */   private int durationTicks = 0;
/*  22 */   private ForwardAxis axis = ForwardAxis.PLUS_Z;
/*  23 */   private float roll = 0.0F;
/*  24 */   private Vec3 lastStartPos = null;
/*  25 */   private Vec3 lastEndPos = null;
/*     */   
/*     */   public BlueDemonThunderBeamParticleEmitterInfo(ResourceLocation effek) {
/*  28 */     super(effek);
/*     */   }
/*     */   
/*     */   public BlueDemonThunderBeamParticleEmitterInfo fromTo(Vec3 from, Vec3 to, ForwardAxis axis, float extraRollRad) {
/*  32 */     position(from.f_82479_, from.f_82480_, from.f_82481_);
/*  33 */     this.axis = axis;
/*  34 */     this.roll = extraRollRad;
/*  35 */     this.lastStartPos = from;
/*  36 */     this.lastEndPos = to;
/*  37 */     applyRotation(this, from, to, axis, extraRollRad);
/*  38 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlueDemonThunderBeamParticleEmitterInfo followBeam(BlueDemonThunderBeamEntity beam, int durationTicks, ForwardAxis axis, float extraRollRad) {
/*  45 */     this.beamRef = new WeakReference<>(beam);
/*  46 */     this.durationTicks = durationTicks;
/*  47 */     this.axis = axis;
/*  48 */     this.roll = extraRollRad;
/*  49 */     return this;
/*     */   }
/*     */   private static void applyRotation(ParticleEmitterInfo info, Vec3 from, Vec3 to, ForwardAxis axis, float roll) {
/*     */     float yaw, pitch;
/*  53 */     Vec3 d = to.m_82546_(from);
/*  54 */     double xz = Math.sqrt(d.f_82479_ * d.f_82479_ + d.f_82481_ * d.f_82481_);
/*     */     
/*  56 */     switch (axis) {
/*     */       case PLUS_Z:
/*  58 */         yaw = (float)Math.atan2(d.f_82479_, d.f_82481_);
/*  59 */         pitch = (float)-Math.atan2(d.f_82480_, xz);
/*  60 */         info.rotation(pitch, yaw, roll);
/*     */         break;
/*     */       case PLUS_Y:
/*  63 */         yaw = (float)Math.atan2(d.f_82481_, d.f_82479_) + 1.5707964F;
/*  64 */         pitch = (float)Math.atan2(xz, d.f_82480_) - 1.5707964F;
/*  65 */         info.rotation(pitch, yaw, roll);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   private static void aim(ParticleEmitter em, Vec3 from, Vec3 to, ForwardAxis axis, float roll) {
/*     */     float yaw, pitch;
/*  71 */     Vec3 d = to.m_82546_(from);
/*  72 */     double xz = Math.sqrt(d.f_82479_ * d.f_82479_ + d.f_82481_ * d.f_82481_);
/*     */     
/*  74 */     switch (axis) {
/*     */       case PLUS_Z:
/*  76 */         yaw = (float)Math.atan2(d.f_82479_, d.f_82481_);
/*  77 */         pitch = (float)-Math.atan2(d.f_82480_, xz);
/*  78 */         em.setRotation(pitch, yaw, roll);
/*     */         break;
/*     */       case PLUS_Y:
/*  81 */         yaw = (float)Math.atan2(d.f_82481_, d.f_82479_) + 1.5707964F;
/*  82 */         pitch = (float)Math.atan2(xz, d.f_82480_) - 1.5707964F;
/*  83 */         em.setRotation(pitch, yaw, roll);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnInWorld(Level level, Player player) {
/*  90 */     if (NativePlatform.isRunningOnUnsupportedPlatform())
/*     */       return; 
/*  92 */     Optional.<EffectDefinition>ofNullable(EffectRegistry.get(this.effek)).ifPresent(eff -> {
/*     */           ParticleEmitter em = hasEmitter() ? eff.play(this.emitter) : eff.play();
/*     */           if (hasParameters())
/*     */             for (DynamicParameter p : this.parameters)
/*     */               em.setDynamicInput(p.index(), p.value());  
/*     */           if (hasTriggers()) {
/*     */             Objects.requireNonNull(em);
/*     */             this.triggers.forEach(em::sendTrigger);
/*     */           } 
/*     */           BlueDemonThunderBeamEntity beam = this.beamRef.get();
/*     */           if (beam == null || !beam.m_6084_()) {
/*     */             em.stop();
/*     */             return;
/*     */           } 
/*     */           int startTick = beam.f_19797_;
/*     */           Vec3 from0 = beam.getStartPos();
/*     */           Vec3 to0 = beam.getEndPos();
/*     */           this.lastStartPos = from0;
/*     */           this.lastEndPos = to0;
/*     */           em.setPosition((float)from0.f_82479_, (float)from0.f_82480_, (float)from0.f_82481_);
/*     */           aim(em, from0, to0, this.axis, this.roll);
/*     */           em.addPreDrawCallback(());
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\emitterinfo\BlueDemonThunderBeamParticleEmitterInfo.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */