/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import net.minecraft.core.particles.ParticleType;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnnoyingVillagersModParticleTypes
/*    */ {
/* 13 */   public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "annoyingvillagers");
/* 14 */   public static final RegistryObject<SimpleParticleType> RED_SPARK = REGISTRY
/* 15 */     .register("red_spark", () -> new SimpleParticleType(true));
/* 16 */   public static final RegistryObject<SimpleParticleType> DRAGON_SPARK = REGISTRY
/* 17 */     .register("dragon_spark", () -> new SimpleParticleType(true));
/* 18 */   public static final RegistryObject<SimpleParticleType> ELECTRIC_SPARK = REGISTRY
/* 19 */     .register("electric_spark", () -> new SimpleParticleType(true));
/* 20 */   public static final RegistryObject<SimpleParticleType> ELECTRIC_SPARK_2 = REGISTRY
/* 21 */     .register("electric_spark_2", () -> new SimpleParticleType(true));
/* 22 */   public static final RegistryObject<SimpleParticleType> SPARK = REGISTRY
/* 23 */     .register("spark", () -> new SimpleParticleType(true));
/* 24 */   public static final RegistryObject<SimpleParticleType> PE = REGISTRY
/* 25 */     .register("pe", () -> new SimpleParticleType(true));
/* 26 */   public static final RegistryObject<SimpleParticleType> GLOWINGEYES = REGISTRY
/* 27 */     .register("glowing_eyes", () -> new SimpleParticleType(true));
/* 28 */   public static final RegistryObject<SimpleParticleType> LIGHT = REGISTRY
/* 29 */     .register("light", () -> new SimpleParticleType(true));
/* 30 */   public static final RegistryObject<SimpleParticleType> BLUESPARK = REGISTRY
/* 31 */     .register("blue_spark", () -> new SimpleParticleType(true));
/* 32 */   public static final RegistryObject<SimpleParticleType> GREENSPARK = REGISTRY
/* 33 */     .register("green_spark", () -> new SimpleParticleType(true));
/* 34 */   public static final RegistryObject<SimpleParticleType> ENDER = REGISTRY
/* 35 */     .register("ender", () -> new SimpleParticleType(true));
/* 36 */   public static final RegistryObject<SimpleParticleType> NULL = REGISTRY
/* 37 */     .register("null", () -> new SimpleParticleType(true));
/* 38 */   public static final RegistryObject<SimpleParticleType> FULL_COWL = REGISTRY
/* 39 */     .register("full_cowl", () -> new SimpleParticleType(true));
/* 40 */   public static final RegistryObject<SimpleParticleType> METEORITE_TRAIL = REGISTRY
/* 41 */     .register("meteorite_trail", () -> new SimpleParticleType(true));
/* 42 */   public static final RegistryObject<SimpleParticleType> BIG_SPLASH = REGISTRY
/* 43 */     .register("big_splash", () -> new SimpleParticleType(true));
/* 44 */   public static final RegistryObject<SimpleParticleType> FIREBALL = REGISTRY
/* 45 */     .register("fireball", () -> new SimpleParticleType(true));
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModParticleTypes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */