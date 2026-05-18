/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.pla.annoyingvillagers.clazz.NullWeapon;
/*    */ import net.minecraft.client.model.HumanoidModel;
/*    */ import net.minecraft.client.model.geom.ModelLayers;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class NullWeaponRenderer extends HumanoidMobRenderer<NullWeapon, HumanoidModel<NullWeapon>> {
/*    */   public NullWeaponRenderer(EntityRendererProvider.Context context) {
/* 16 */     super(context, new HumanoidModel(context.m_174023_(ModelLayers.f_171162_)), 0.5F);
/* 17 */     m_115326_((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(context
/*    */             
/* 19 */             .m_174023_(ModelLayers.f_171164_)), new HumanoidModel(context
/* 20 */             .m_174023_(ModelLayers.f_171165_)), context
/* 21 */           .m_266367_()));
/*    */   }
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull NullWeapon nullWeapon) {
/* 25 */     return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/empty.png");
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\NullWeaponRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */