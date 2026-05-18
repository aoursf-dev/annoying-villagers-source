/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.pla.annoyingvillagers.client.model.ModelHerobrineWarden;
/*    */ import com.pla.annoyingvillagers.entity.HerobrineWardenEntity;
/*    */ import net.minecraft.client.model.WardenModel;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.client.renderer.entity.layers.WardenEmissiveLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class HerobrineWardenRenderer extends MobRenderer<HerobrineWardenEntity, ModelHerobrineWarden> {
/* 15 */   private static final ResourceLocation BASE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_warden.png");
/*    */   
/* 17 */   private static final ResourceLocation BIOLUM = ResourceLocation.fromNamespaceAndPath("minecraft", "textures/entity/warden/warden_bioluminescent_layer.png");
/*    */   
/* 19 */   private static final ResourceLocation HEART = ResourceLocation.fromNamespaceAndPath("minecraft", "textures/entity/warden/warden_heart.png");
/*    */   
/* 21 */   private static final ResourceLocation SPOTS1 = ResourceLocation.fromNamespaceAndPath("minecraft", "textures/entity/warden/warden_pulsating_spots_1.png");
/*    */   
/* 23 */   private static final ResourceLocation SPOTS2 = ResourceLocation.fromNamespaceAndPath("minecraft", "textures/entity/warden/warden_pulsating_spots_2.png");
/*    */   
/*    */   public HerobrineWardenRenderer(EntityRendererProvider.Context ctx) {
/* 26 */     super(ctx, (EntityModel)new ModelHerobrineWarden(ctx.m_174023_(ModelHerobrineWarden.LAYER_LOCATION)), 0.9F);
/* 27 */     m_115326_((RenderLayer)new WardenEmissiveLayer((RenderLayerParent)this, BIOLUM, (e, partial, age) -> 1.0F, WardenModel::m_233543_));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 32 */     m_115326_((RenderLayer)new WardenEmissiveLayer((RenderLayerParent)this, SPOTS1, (e, partial, age) -> Math.max(0.0F, Mth.m_14089_(age * 0.045F) * 0.25F), WardenModel::m_233544_));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 37 */     m_115326_((RenderLayer)new WardenEmissiveLayer((RenderLayerParent)this, SPOTS2, (e, partial, age) -> Math.max(0.0F, Mth.m_14089_(age * 0.045F + 3.1415927F) * 0.25F), WardenModel::m_233544_));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 42 */     m_115326_((RenderLayer)new WardenEmissiveLayer((RenderLayerParent)this, BASE, (e, partial, age) -> e.m_219467_(partial), WardenModel::m_233541_));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     m_115326_((RenderLayer)new WardenEmissiveLayer((RenderLayerParent)this, HEART, (e, partial, age) -> e.m_219469_(partial), WardenModel::m_233542_));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull HerobrineWardenEntity herobrineWardenEntity) {
/* 56 */     return BASE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\HerobrineWardenRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */