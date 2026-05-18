/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.pla.annoyingvillagers.entity.JevEntity;
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
/*    */ public class JevRenderer extends HumanoidMobRenderer<JevEntity, PlayerModel<JevEntity>> {
/*    */   public JevRenderer(EntityRendererProvider.Context context) {
/* 18 */     super(context, (HumanoidModel)new PlayerModel(context.m_174023_(ModelLayers.f_171162_), false), 0.5F);
/* 19 */     m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(context
/*    */             
/* 21 */             .m_174023_(ModelLayers.f_171164_)), new HumanoidModel(context
/* 22 */             .m_174023_(ModelLayers.f_171165_)), context
/* 23 */           .m_266367_()));
/* 24 */     ArrowLayer<JevEntity, PlayerModel<JevEntity>> arrowLayer = new ArrowLayer(context, (LivingEntityRenderer)this);
/* 25 */     m_115326_((RenderLayer)arrowLayer);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull JevEntity jevEntity) {
/* 30 */     if (jevEntity.m_21224_()) {
/* 31 */       return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/jev_dead.png");
/*    */     }
/* 33 */     return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/jev.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\JevRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */