/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.pla.annoyingvillagers.client.model.ModelBbq;
/*    */ import net.minecraft.client.model.geom.ModelLayers;
/*    */ import net.minecraft.client.renderer.entity.ChickenRenderer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.animal.Chicken;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class BbqRenderer extends ChickenRenderer {
/*    */   public BbqRenderer(EntityRendererProvider.Context context) {
/* 14 */     super(context);
/*    */     
/* 16 */     this.f_115290_ = (EntityModel)new ModelBbq(context.m_174023_(ModelLayers.f_171277_));
/* 17 */     m_115326_(new BbqHeldItemLayer((RenderLayerParent<Chicken, ChickenModel<Chicken>>)this, context.m_234598_()));
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation m_5478_(@NotNull Chicken entity) {
/* 22 */     return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/chicken.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\BbqRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */