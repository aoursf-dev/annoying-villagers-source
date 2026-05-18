/*    */ package com.pla.annoyingvillagers.init;
/*    */ import com.pla.annoyingvillagers.client.particle.BlueSparkParticle;
/*    */ import com.pla.annoyingvillagers.client.particle.ElectricSpark2Particle;
/*    */ import com.pla.annoyingvillagers.client.particle.GlowingEyesParticle;
/*    */ import com.pla.annoyingvillagers.client.particle.GreenSparkParticle;
/*    */ import com.pla.annoyingvillagers.client.particle.RedSparkParticle;
/*    */ import com.pla.annoyingvillagers.client.particle.SparkParticle;
/*    */ import net.minecraft.core.particles.ParticleType;
/*    */ import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ 
/*    */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*    */ public class AnnoyingVillagersModParticles {
/*    */   @SubscribeEvent
/*    */   public static void registerParticles(RegisterParticleProvidersEvent event) {
/* 16 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.RED_SPARK.get(), RedSparkParticle::provider);
/* 17 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK.get(), ElectricSparkParticle::provider);
/* 18 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.DRAGON_SPARK.get(), DragonSparkParticle::provider);
/* 19 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK_2.get(), ElectricSpark2Particle::provider);
/* 20 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.SPARK.get(), SparkParticle::provider);
/* 21 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.PE.get(), PeParticle::provider);
/* 22 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.GLOWINGEYES.get(), GlowingEyesParticle::provider);
/* 23 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.LIGHT.get(), LightParticle::provider);
/* 24 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.BLUESPARK.get(), BlueSparkParticle::provider);
/* 25 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.GREENSPARK.get(), GreenSparkParticle::provider);
/* 26 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.ENDER.get(), EnderParticle::provider);
/* 27 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.NULL.get(), net.minecraft.client.particle.SmokeParticle.Provider::new);
/* 28 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.FULL_COWL.get(), FullCowlParticle::provider);
/* 29 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.METEORITE_TRAIL.get(), MeteoriteTrailParticle::provider);
/* 30 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.BIG_SPLASH.get(), BigSplashParticle::provider);
/* 31 */     event.registerSpriteSet((ParticleType)AnnoyingVillagersModParticleTypes.FIREBALL.get(), FireballParticle::provider);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModParticles.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */