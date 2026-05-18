/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import com.pla.annoyingvillagers.client.emitterinfo.BlueDemonThunderBeamParticleEmitterInfo;
/*    */ import com.pla.annoyingvillagers.client.emitterinfo.DragonBeamParticleEmitterInfo;
/*    */ import com.pla.annoyingvillagers.client.emitterinfo.EnderGlaiveExplosionParticleEmitterInfo;
/*    */ import com.pla.annoyingvillagers.entity.BlueDemonThunderBeamEntity;
/*    */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*    */ import mod.chloeprime.aaaparticles.api.common.AAALevel;
/*    */ import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ public class AAAParticlesUtil
/*    */ {
/*    */   public static void sendEnderGlaiveExplosion(Vec3 from, Vec3 to, Level level) {
/* 19 */     (new EnderGlaiveExplosionParticleEmitterInfo(
/* 20 */         ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "ender_glaive_explosion")))
/* 21 */       .fromTo(from, to, EnderGlaiveExplosionParticleEmitterInfo.ForwardAxis.PLUS_Z, 0.0F, true)
/*    */       
/* 23 */       .spawnInWorld(level, null);
/*    */   }
/*    */   
/*    */   public static void sendDragonBeam(Vec3 from, Vec3 to, Level level, HerobrineDragonEntity caster, LivingEntity target) {
/* 27 */     (new DragonBeamParticleEmitterInfo(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "dragon_beam")))
/* 28 */       .fromTo(from, to, DragonBeamParticleEmitterInfo.ForwardAxis.PLUS_Z, 0.0F)
/* 29 */       .follow(caster, target, 120, DragonBeamParticleEmitterInfo.ForwardAxis.PLUS_Z, 0.0F)
/* 30 */       .spawnInWorld(level, null);
/*    */   }
/*    */   
/*    */   public static void sendDragonBeamHit(Level level, BlockPos hitBlock) {
/* 34 */     AAALevel.addParticle(level, false, (new ParticleEmitterInfo(
/* 35 */           ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "dragon_beam_hit")))
/* 36 */         .clone()
/* 37 */         .position(hitBlock.m_123341_(), hitBlock.m_123342_(), hitBlock.m_123343_()));
/*    */   }
/*    */   
/*    */   public static void sendBlueDemonThunderBeam(Level level, BlueDemonThunderBeamEntity blueDemonThunderBeamEntity) {
/* 41 */     (new BlueDemonThunderBeamParticleEmitterInfo(
/* 42 */         ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "blue_demon_thunder_beam")))
/* 43 */       .followBeam(blueDemonThunderBeamEntity, blueDemonThunderBeamEntity.getDuration(), BlueDemonThunderBeamParticleEmitterInfo.ForwardAxis.PLUS_Z, 0.0F)
/* 44 */       .spawnInWorld(level, null);
/*    */   }
/*    */   
/*    */   public static void sendHerobrinePortal(Level level, double x, double y, double z) {
/* 48 */     AAALevel.addParticle(level, false, (new ParticleEmitterInfo(
/* 49 */           ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "herobrine_portal")))
/* 50 */         .clone()
/* 51 */         .position(x, y, z));
/*    */   }
/*    */   
/*    */   public static void sendLitePortal(Level level, double x, double y, double z) {
/* 55 */     AAALevel.addParticle(level, false, (new ParticleEmitterInfo(
/* 56 */           ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "lite_portal")))
/* 57 */         .clone()
/* 58 */         .position(x, y, z));
/*    */   }
/*    */   
/*    */   public static void sendWoopieWind(Level level, double x, double y, double z) {
/* 62 */     AAALevel.addParticle(level, false, (new ParticleEmitterInfo(
/* 63 */           ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "woopie_sword_wind")))
/* 64 */         .clone()
/* 65 */         .position(x, y, z));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\AAAParticlesUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */