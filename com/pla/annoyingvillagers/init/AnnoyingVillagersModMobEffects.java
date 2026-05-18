/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ public class AnnoyingVillagersModMobEffects
/*    */ {
/* 12 */   public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "annoyingvillagers");
/* 13 */   public static final RegistryObject<MobEffect> ENCHANT_BED_EFFECT = REGISTRY.register("enchant_bed_effect", com.pla.annoyingvillagers.potion.EnchantBedEffectMobEffect::new);
/* 14 */   public static final RegistryObject<MobEffect> ELECTRIFY = REGISTRY.register("electrify", com.pla.annoyingvillagers.potion.ElectrifyMobEffect::new);
/* 15 */   public static final RegistryObject<MobEffect> CAPTIVE = REGISTRY.register("captive", com.pla.annoyingvillagers.potion.CaptiveMobEffect::new);
/* 16 */   public static final RegistryObject<MobEffect> HEROBRINE = REGISTRY.register("herobrine", com.pla.annoyingvillagers.potion.HerobrineMobEffect::new);
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModMobEffects.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */