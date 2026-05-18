/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*    */ import net.minecraft.client.model.HumanoidModel;
/*    */ import net.minecraft.client.model.PlayerModel;
/*    */ import net.minecraft.client.model.geom.ModelLayers;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
/*    */ import net.minecraft.client.renderer.entity.LivingEntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.ArrowLayer;
/*    */ import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class ShadowHerobrineRenderer extends HumanoidMobRenderer<HerobrineMob, PlayerModel<HerobrineMob>> {
/*    */   public ShadowHerobrineRenderer(EntityRendererProvider.Context context) {
/* 19 */     super(context, (HumanoidModel)new PlayerModel(context.m_174023_(ModelLayers.f_171162_), false), 0.5F);
/* 20 */     m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(context
/*    */             
/* 22 */             .m_174023_(ModelLayers.f_171164_)), new HumanoidModel(context
/* 23 */             .m_174023_(ModelLayers.f_171165_)), context
/* 24 */           .m_266367_()));
/* 25 */     ArrowLayer<HerobrineMob, PlayerModel<HerobrineMob>> arrowLayer = new ArrowLayer(context, (LivingEntityRenderer)this);
/* 26 */     m_115326_((RenderLayer)arrowLayer);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull HerobrineMob herobrineMob) {
/* 31 */     if (herobrineMob instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineEntity) {
/* 32 */       return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/dark_shadow_herobrine.png");
/*    */     }
/* 34 */     return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/shadow_herobrine.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\ShadowHerobrineRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */