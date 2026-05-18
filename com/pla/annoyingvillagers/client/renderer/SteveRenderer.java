/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.pla.annoyingvillagers.entity.SteveEntity;
/*    */ import net.minecraft.client.model.HumanoidModel;
/*    */ import net.minecraft.client.model.PlayerModel;
/*    */ import net.minecraft.client.model.geom.ModelLayers;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
/*    */ import net.minecraft.client.renderer.entity.LivingEntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.layers.ArrowLayer;
/*    */ import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class SteveRenderer extends HumanoidMobRenderer<SteveEntity, PlayerModel<SteveEntity>> {
/*    */   public SteveRenderer(EntityRendererProvider.Context context) {
/* 18 */     super(context, (HumanoidModel)new PlayerModel(context.m_174023_(ModelLayers.f_171162_), false), 0.5F);
/*    */     
/* 20 */     m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(context
/*    */             
/* 22 */             .m_174023_(ModelLayers.f_171164_)), new HumanoidModel(context
/* 23 */             .m_174023_(ModelLayers.f_171165_)), context
/* 24 */           .m_266367_()));
/* 25 */     ArrowLayer<SteveEntity, PlayerModel<SteveEntity>> arrowLayer = new ArrowLayer(context, (LivingEntityRenderer)this);
/* 26 */     m_115326_((RenderLayer)arrowLayer);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull SteveEntity steveEntity) {
/* 31 */     return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/steve.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\SteveRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */