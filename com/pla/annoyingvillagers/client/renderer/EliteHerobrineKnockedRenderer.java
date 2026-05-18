/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.pla.annoyingvillagers.entity.EliteHerobrineKnockedEntity;
/*    */ import net.minecraft.client.model.HumanoidModel;
/*    */ import net.minecraft.client.model.PlayerModel;
/*    */ import net.minecraft.client.model.geom.ModelLayers;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
/*    */ import net.minecraft.client.renderer.entity.LivingEntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.layers.ArrowLayer;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class EliteHerobrineKnockedRenderer extends HumanoidMobRenderer<EliteHerobrineKnockedEntity, PlayerModel<EliteHerobrineKnockedEntity>> {
/*    */   public EliteHerobrineKnockedRenderer(EntityRendererProvider.Context context) {
/* 17 */     super(context, (HumanoidModel)new PlayerModel(context.m_174023_(ModelLayers.f_171162_), false), 0.5F);
/* 18 */     m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(context
/*    */             
/* 20 */             .m_174023_(ModelLayers.f_171164_)), new HumanoidModel(context
/* 21 */             .m_174023_(ModelLayers.f_171165_)), context
/* 22 */           .m_266367_()));
/* 23 */     ArrowLayer<EliteHerobrineKnockedEntity, PlayerModel<EliteHerobrineKnockedEntity>> arrowLayer = new ArrowLayer(context, (LivingEntityRenderer)this);
/* 24 */     m_115326_((RenderLayer)arrowLayer);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity) {
/* 29 */     if (eliteHerobrineKnockedEntity.m_21224_()) {
/* 30 */       return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/elite_herobrine_dead.png");
/*    */     }
/* 32 */     return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/elite_herobrine.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\EliteHerobrineKnockedRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */