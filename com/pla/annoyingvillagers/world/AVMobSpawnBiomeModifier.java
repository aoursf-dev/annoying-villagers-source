/*    */ package com.pla.annoyingvillagers.world;
/*    */ 
/*    */ import com.mojang.serialization.Codec;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.tags.BiomeTags;
/*    */ import net.minecraft.world.level.biome.Biome;
/*    */ import net.minecraftforge.common.world.BiomeModifier;
/*    */ import net.minecraftforge.common.world.ModifiableBiomeInfo;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ public final class AVMobSpawnBiomeModifier
/*    */   implements BiomeModifier
/*    */ {
/* 17 */   private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "av_mob_spawns"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, "annoyingvillagers");
/*    */ 
/*    */ 
/*    */   
/*    */   public void modify(Holder<Biome> biomeHolder, BiomeModifier.Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
/* 22 */     if (phase != BiomeModifier.Phase.ADD) {
/*    */       return;
/*    */     }
/* 25 */     if (!biomeHolder.m_203656_(BiomeTags.f_215817_))
/* 26 */       return;  AVWorldSpawns.addBiomeSpawns(builder);
/*    */   }
/*    */   
/*    */   public Codec<? extends BiomeModifier> codec() {
/* 30 */     return (Codec<? extends BiomeModifier>)SERIALIZER.get();
/*    */   }
/*    */   public static Codec<AVMobSpawnBiomeModifier> makeCodec() {
/* 33 */     return Codec.unit(AVMobSpawnBiomeModifier::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\world\AVMobSpawnBiomeModifier.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */