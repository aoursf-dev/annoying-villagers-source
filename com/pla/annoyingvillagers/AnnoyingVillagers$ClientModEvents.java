/*     */ package com.pla.annoyingvillagers;
/*     */ 
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.client.renderer.item.ItemProperties;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*     */ public class ClientModEvents
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onClientSetup(FMLClientSetupEvent event) {
/* 188 */     event.enqueueWork(() -> {
/*     */           ItemProperties.register((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get(), ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "second_form"), ());
/*     */           ItemProperties.register((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get(), ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "snake_animation"), ());
/*     */           ItemProperties.register((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get(), ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "snake_animation_ready"), ());
/*     */           ItemProperties.register((Item)AnnoyingVillagersModItems.ENDER_AEGIS.get(), ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "second_form"), ());
/*     */           for (Item item : ForgeRegistries.ITEMS.getValues()) {
/*     */             if (item instanceof net.minecraft.world.item.BowItem) {
/*     */               ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath("minecraft", "pulling"), ());
/*     */               ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath("minecraft", "pull"), ());
/*     */             } 
/*     */           } 
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\AnnoyingVillagers$ClientModEvents.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */