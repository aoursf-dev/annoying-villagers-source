/*    */ package com.pla.annoyingvillagers.event;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.geom.EntityModelSet;
/*    */ import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
/*    */ import net.minecraft.client.renderer.entity.ItemRenderer;
/*    */ import net.minecraft.client.resources.model.Material;
/*    */ import net.minecraft.client.resources.model.ModelBakery;
/*    */ import net.minecraft.server.packs.resources.PreparableReloadListener;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemDisplayContext;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @EventBusSubscriber(value = {Dist.CLIENT}, modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.MOD)
/*    */ public class ShieldRendererEvent extends BlockEntityWithoutLevelRenderer {
/*    */   public ShieldRendererEvent(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
/* 27 */     super(blockEntityRenderDispatcher, entityModelSet);
/*    */   }
/*    */   public static ShieldRendererEvent instance;
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onRegisterReloadListener(RegisterClientReloadListenersEvent event) {
/* 33 */     instance = new ShieldRendererEvent(Minecraft.m_91087_().m_167982_(), Minecraft.m_91087_().m_167973_());
/* 34 */     event.registerReloadListener((PreparableReloadListener)instance);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_108829_(ItemStack stack, @NotNull ItemDisplayContext itemDisplayContext, PoseStack matrixStack, @NotNull MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
/* 39 */     matrixStack.m_85836_();
/* 40 */     matrixStack.m_85841_(1.0F, -1.0F, -1.0F);
/* 41 */     Material renderMaterial = ModelBakery.f_119226_;
/*    */     
/* 43 */     Item shield = stack.m_41720_();
/* 44 */     if (shield == AnnoyingVillagersModItems.JESSICA_THE_DARK_SHIELD.get()) {
/* 45 */       renderMaterial = ModModelPredicateProvider.LOCATION_JESSICA_THE_DARK_SHIELD;
/* 46 */     } else if (shield == AnnoyingVillagersModItems.HEATER_SHIELD.get()) {
/* 47 */       renderMaterial = ModModelPredicateProvider.LOCATION_HEATER_SHIELD;
/* 48 */     } else if (shield == AnnoyingVillagersModItems.GEM_SHIELD.get()) {
/* 49 */       renderMaterial = ModModelPredicateProvider.LOCATION_GEM_SHIELD;
/* 50 */     } else if (shield == AnnoyingVillagersModItems.NETHERITE_SHIELD.get()) {
/* 51 */       renderMaterial = ModModelPredicateProvider.LOCATION_NETHERITE_SHIELD;
/*    */     } 
/* 53 */     VertexConsumer ivertexBuilder = renderMaterial.m_119204_().m_118381_(ItemRenderer.m_115222_(buffer, this.f_108823_.m_103119_(renderMaterial.m_119193_()), true, stack.m_41790_()));
/* 54 */     this.f_108823_.m_103711_().m_104306_(matrixStack, ivertexBuilder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
/* 55 */     this.f_108823_.m_103701_().m_104306_(matrixStack, ivertexBuilder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
/* 56 */     matrixStack.m_85849_();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\ShieldRendererEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */