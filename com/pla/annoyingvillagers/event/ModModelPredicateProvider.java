/*    */ package com.pla.annoyingvillagers.event;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
/*    */ import net.minecraft.client.renderer.item.ItemProperties;
/*    */ import net.minecraft.client.renderer.item.ItemPropertyFunction;
/*    */ import net.minecraft.client.renderer.texture.TextureAtlas;
/*    */ import net.minecraft.client.resources.model.Material;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*    */ import org.jetbrains.annotations.ApiStatus.Internal;
/*    */ 
/*    */ @EventBusSubscriber(value = {Dist.CLIENT}, modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.MOD)
/*    */ public class ModModelPredicateProvider {
/*    */   @SubscribeEvent
/*    */   public static void init(FMLClientSetupEvent event) {
/* 25 */     event.enqueueWork(() -> {
/*    */           addShieldPropertyOverrides(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "blocking"), (), new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.JESSICA_THE_DARK_SHIELD.get() });
/*    */           addShieldPropertyOverrides(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "blocking"), (), new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.HEATER_SHIELD.get() });
/*    */           addShieldPropertyOverrides(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "blocking"), (), new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.GEM_SHIELD.get() });
/*    */           addShieldPropertyOverrides(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "blocking"), (), new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.NETHERITE_SHIELD.get() });
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static void addShieldPropertyOverrides(ResourceLocation override, ClampedItemPropertyFunction propertyGetter, ItemLike... shields) {
/* 46 */     for (ItemLike shield : shields) {
/* 47 */       ItemProperties.register(shield.m_5456_(), override, (ItemPropertyFunction)propertyGetter);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onStitch(Pre event) {
/* 54 */     if (event.getAtlas().m_118330_().equals(TextureAtlas.f_118259_))
/* 55 */       for (Material textures : new Material[] { LOCATION_JESSICA_THE_DARK_SHIELD, LOCATION_HEATER_SHIELD, LOCATION_GEM_SHIELD, LOCATION_NETHERITE_SHIELD
/*    */ 
/*    */ 
/*    */         
/*    */         })
/*    */       {
/* 61 */         event.addSprite(textures.m_119203_());
/*    */       } 
/*    */   }
/*    */   
/*    */   public static class Pre
/*    */     extends TextureStitchEvent {
/*    */     private final Set<ResourceLocation> sprites;
/*    */     
/*    */     @Internal
/*    */     public Pre(TextureAtlas map, Set<ResourceLocation> sprites) {
/* 71 */       super(map);
/* 72 */       this.sprites = sprites;
/*    */     }
/*    */     
/*    */     public boolean addSprite(ResourceLocation sprite) {
/* 76 */       return this.sprites.add(sprite);
/*    */     }
/*    */   }
/*    */   
/* 80 */   public static final Material LOCATION_JESSICA_THE_DARK_SHIELD = material("item/jessica_the_dark_shield");
/* 81 */   public static final Material LOCATION_HEATER_SHIELD = material("item/heater_shield");
/* 82 */   public static final Material LOCATION_GEM_SHIELD = material("item/gem_shield");
/* 83 */   public static final Material LOCATION_NETHERITE_SHIELD = material("item/netherite_shield");
/*    */ 
/*    */   
/*    */   private static Material material(String path) {
/* 87 */     return new Material(TextureAtlas.f_118259_, 
/* 88 */         ResourceLocation.fromNamespaceAndPath("annoyingvillagers", path));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\ModModelPredicateProvider.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */