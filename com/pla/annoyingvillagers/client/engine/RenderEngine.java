/*    */ package com.pla.annoyingvillagers.client.engine;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
/*    */ 
/*    */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*    */ public class RenderEngine {
/*    */   @SubscribeEvent
/*    */   public static void registerRenderer(PatchedRenderersEvent.RegisterItemRenderer add) {
/* 14 */     add.addItemRenderer(ResourceLocation.m_214293_("annoyingvillagers", "legendary_sword"), RenderLegendarySword::new);
/* 15 */     add.addItemRenderer(ResourceLocation.m_214293_("annoyingvillagers", "great_sword"), RenderGreatSword::new);
/* 16 */     add.addItemRenderer(ResourceLocation.m_214293_("annoyingvillagers", "obsidian_weapon"), RenderObsidianWeapon::new);
/* 17 */     add.addItemRenderer(ResourceLocation.m_214293_("annoyingvillagers", "shadow_obsidian_weapon"), RenderShadowObsidianWeapon::new);
/* 18 */     add.addItemRenderer(ResourceLocation.m_214293_("annoyingvillagers", "shadow_obsidian_pillar"), RenderShadowObsidianPillar::new);
/* 19 */     add.addItemRenderer(ResourceLocation.m_214293_("annoyingvillagers", "shadow_obsidian_sword"), RenderShadowObsidianSword::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\RenderEngine.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */