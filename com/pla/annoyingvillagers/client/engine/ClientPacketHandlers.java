/*     */ package com.pla.annoyingvillagers.client.engine;
/*     */ import com.pla.annoyingvillagers.event.NoVfxPortalEvent;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.network.ClientboundGlaiveExplosionFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundHerobrinePortalFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundLitePortalFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundMuteExplosionAtPos;
/*     */ import com.pla.annoyingvillagers.network.ClientboundWoopieSwordWindFx;
/*     */ import com.pla.annoyingvillagers.util.AAAParticlesUtil;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ 
/*     */ @OnlyIn(Dist.CLIENT)
/*     */ public final class ClientPacketHandlers {
/*     */   private static void spawnOmniRings(Level level, RandomSource rand, Vec3 center) {
/*  25 */     int ringPlanes = 6;
/*  26 */     for (int p = 0; p < ringPlanes; p++) {
/*  27 */       Vec3 normal = randomUnit(rand);
/*     */       
/*  29 */       spawnRing3d(level, rand, center, normal, 52, 2.0D, 0.1D, 0.12D, 0.035D);
/*  30 */       spawnRing3d(level, rand, center, normal, 60, 2.8D, 0.14D, 0.11D, 0.03D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void spawnRing3d(Level level, RandomSource rand, Vec3 center, Vec3 n, int points, double radius, double thickness, double tangentialSpeed, double outwardSpeed) {
/*  38 */     Vec3 normal = n.m_82541_();
/*  39 */     Vec3 u = normal.m_82537_(new Vec3(0.0D, 1.0D, 0.0D));
/*  40 */     if (u.m_82556_() < 1.0E-6D) u = normal.m_82537_(new Vec3(1.0D, 0.0D, 0.0D)); 
/*  41 */     u = u.m_82541_();
/*  42 */     Vec3 v = normal.m_82537_(u).m_82541_();
/*     */     
/*  44 */     for (int i = 0; i < points; i++) {
/*  45 */       double a = i / points * 6.283185307179586D + rand.m_188500_() * 0.1D;
/*  46 */       double cos = Math.cos(a);
/*  47 */       double sin = Math.sin(a);
/*     */       
/*  49 */       Vec3 radialDir = u.m_82490_(cos).m_82549_(v.m_82490_(sin));
/*  50 */       Vec3 tangentDir = normal.m_82537_(radialDir).m_82541_();
/*     */       
/*  52 */       double layer = (rand.m_188500_() - 0.5D) * 2.0D * thickness;
/*  53 */       Vec3 pos = center.m_82549_(radialDir.m_82490_(radius)).m_82549_(normal.m_82490_(layer));
/*     */ 
/*     */ 
/*     */       
/*  57 */       Vec3 vel = tangentDir.m_82490_(tangentialSpeed).m_82549_(radialDir.m_82490_(outwardSpeed)).m_82520_((rand.m_188500_() - 0.5D) * 0.02D, (rand.m_188500_() - 0.5D) * 0.02D, (rand.m_188500_() - 0.5D) * 0.02D);
/*     */       
/*  59 */       level.m_6493_((ParticleOptions)AnnoyingVillagersModParticleTypes.ENDER.get(), true, pos.f_82479_, pos.f_82480_, pos.f_82481_, vel.f_82479_, vel.f_82480_, vel.f_82481_);
/*     */ 
/*     */       
/*  62 */       if ((i & 0x3) == 0) {
/*  63 */         level.m_6493_((ParticleOptions)ParticleTypes.f_123789_, true, pos.f_82479_, pos.f_82480_, pos.f_82481_, vel.f_82479_ * 0.35D, vel.f_82480_ * 0.2D, vel.f_82481_ * 0.35D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Vec3 randomUnit(RandomSource rand) {
/*  70 */     double z = rand.m_188500_() * 2.0D - 1.0D;
/*  71 */     double a = rand.m_188500_() * Math.PI * 2.0D;
/*  72 */     double r = Math.sqrt(Math.max(0.0D, 1.0D - z * z));
/*  73 */     return new Vec3(r * Math.cos(a), z, r * Math.sin(a));
/*     */   }
/*     */   
/*     */   public static void handleGlaiveExplosion(ClientboundGlaiveExplosionFx msg) {
/*  77 */     ClientLevel clientLevel = (Minecraft.m_91087_()).f_91073_;
/*  78 */     if (clientLevel == null)
/*     */       return; 
/*  80 */     if (ModList.get().isLoaded("aaa_particles")) {
/*  81 */       AAAParticlesUtil.sendEnderGlaiveExplosion(msg.from(), msg.to(), (Level)clientLevel);
/*     */     } else {
/*  83 */       Vec3 center = msg.to();
/*  84 */       RandomSource rand = clientLevel.m_213780_();
/*     */       
/*  86 */       clientLevel.m_6493_((ParticleOptions)AnnoyingVillagersModParticleTypes.FIREBALL
/*  87 */           .get(), true, center.f_82479_, center.f_82480_, center.f_82481_, 5.0D, 1.0D, 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  92 */       spawnOmniRings((Level)clientLevel, rand, center);
/*     */     } 
/*     */     
/*  95 */     clientLevel.m_7785_((msg.from()).f_82479_, (msg.from()).f_82480_, (msg.from()).f_82481_, (SoundEvent)AnnoyingVillagersModSounds.ENDER_SHOT.get(), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void handleMuteExplosionAtPos(ClientboundMuteExplosionAtPos msg) {
/* 100 */     ClientLevel clientLevel = (Minecraft.m_91087_()).f_91073_;
/* 101 */     if (clientLevel == null)
/* 102 */       return;  ExplosionFxMute.mark(msg.pos().m_121878_(), clientLevel.m_46467_() + msg.lifetimeTicks());
/*     */   }
/*     */   
/*     */   public static void handleHerobrinePortalFx(ClientboundHerobrinePortalFx msg) {
/* 106 */     ClientLevel clientLevel = (Minecraft.m_91087_()).f_91073_;
/* 107 */     if (clientLevel == null)
/*     */       return; 
/* 109 */     if (ModList.get().isLoaded("aaa_particles")) {
/* 110 */       AAAParticlesUtil.sendHerobrinePortal((Level)clientLevel, (msg.from()).f_82479_, (msg.from()).f_82480_, (msg.from()).f_82481_);
/*     */     } else {
/* 112 */       NoVfxPortalEvent.spawn(msg.from(), 60);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void handleLitePortalFx(ClientboundLitePortalFx msg) {
/* 117 */     ClientLevel clientLevel = (Minecraft.m_91087_()).f_91073_;
/* 118 */     if (clientLevel == null)
/*     */       return; 
/* 120 */     if (ModList.get().isLoaded("aaa_particles")) {
/* 121 */       AAAParticlesUtil.sendLitePortal((Level)clientLevel, (msg.from()).f_82479_, (msg.from()).f_82480_, (msg.from()).f_82481_);
/*     */     } else {
/* 123 */       NoVfxPortalEvent.spawn(msg.from(), 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void handleWoopieSwordWind(ClientboundWoopieSwordWindFx msg) {
/* 128 */     ClientLevel clientLevel = (Minecraft.m_91087_()).f_91073_;
/* 129 */     if (clientLevel == null)
/*     */       return; 
/* 131 */     if (ModList.get().isLoaded("aaa_particles")) {
/* 132 */       AAAParticlesUtil.sendWoopieWind((Level)clientLevel, (msg.from()).f_82479_, (msg.from()).f_82480_, (msg.from()).f_82481_);
/*     */     } else {
/* 134 */       RandomSource rand = clientLevel.m_213780_();
/*     */       
/* 136 */       int rings = 3;
/* 137 */       int pointsPerRing = 36;
/* 138 */       double baseRadius = 0.9D;
/* 139 */       double radiusStep = 0.35D;
/* 140 */       double baseY = 0.15D;
/* 141 */       double yStep = 0.18D;
/*     */       
/* 143 */       double tangentialSpeed = 0.14D;
/* 144 */       double outwardSpeed = 0.03D;
/*     */       
/* 146 */       for (int r = 0; r < rings; r++) {
/* 147 */         double radius = baseRadius + r * radiusStep;
/* 148 */         double yOff = baseY + r * yStep;
/*     */         
/* 150 */         for (int j = 0; j < pointsPerRing; j++) {
/* 151 */           double a = j / pointsPerRing * Math.PI * 2.0D + rand.m_188500_() * 0.12D;
/* 152 */           double cos = Math.cos(a);
/* 153 */           double sin = Math.sin(a);
/*     */           
/* 155 */           double px = (msg.from()).f_82479_ + cos * radius;
/* 156 */           double py = (msg.from()).f_82480_ + yOff + (rand.m_188500_() - 0.5D) * 0.06D;
/* 157 */           double pz = (msg.from()).f_82481_ + sin * radius;
/* 158 */           double vx = -sin * tangentialSpeed + cos * outwardSpeed;
/* 159 */           double vy = 0.01D + rand.m_188500_() * 0.02D;
/* 160 */           double vz = cos * tangentialSpeed + sin * outwardSpeed;
/*     */           
/* 162 */           clientLevel.m_6493_((ParticleOptions)ParticleTypes.f_123796_, true, px, py, pz, vx, vy, vz);
/* 163 */           if ((j & 0x3) == 0) {
/* 164 */             clientLevel.m_6493_((ParticleOptions)ParticleTypes.f_123762_, true, px, py, pz, vx * 0.35D, vy * 0.2D, vz * 0.35D);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 169 */       for (int i = 0; i < 14; i++) {
/* 170 */         double vx = (rand.m_188500_() - 0.5D) * 0.25D;
/* 171 */         double vy = 0.03D + rand.m_188500_() * 0.18D;
/* 172 */         double vz = (rand.m_188500_() - 0.5D) * 0.25D;
/* 173 */         clientLevel.m_6493_((ParticleOptions)ParticleTypes.f_123759_, true, (msg.from()).f_82479_, (msg.from()).f_82480_ + 0.25D, (msg.from()).f_82481_, vx, vy, vz);
/*     */       } 
/*     */       
/* 176 */       clientLevel.m_6493_((ParticleOptions)ParticleTypes.f_123813_, true, (msg.from()).f_82479_, (msg.from()).f_82480_ + 0.35D, (msg.from()).f_82481_, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */     
/* 179 */     clientLevel.m_7785_((msg.from()).f_82479_, (msg.from()).f_82480_, (msg.from()).f_82481_, (SoundEvent)AnnoyingVillagersModSounds.WOOPIE_WIND.get(), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\ClientPacketHandlers.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */