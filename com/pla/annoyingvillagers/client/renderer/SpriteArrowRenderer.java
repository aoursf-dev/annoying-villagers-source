/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.math.Axis;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.ItemRenderer;
/*    */ import net.minecraft.client.renderer.entity.TippableArrowRenderer;
/*    */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*    */ import net.minecraft.world.entity.projectile.Arrow;
/*    */ import net.minecraft.world.item.ItemDisplayContext;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpriteArrowRenderer
/*    */   extends EntityRenderer<AbstractArrow>
/*    */ {
/*    */   private final ItemRenderer renderer;
/*    */   
/*    */   public SpriteArrowRenderer(EntityRendererProvider.Context context) {
/* 44 */     super(context);
/* 45 */     this.renderer = context.m_174025_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(AbstractArrow abstractArrow, float pEntityYaw, float pPartialTicks, PoseStack poseStack, MultiBufferSource buffer, int pPackedLight) {
/* 50 */     poseStack.m_85836_();
/* 51 */     poseStack.m_252781_(Axis.f_252436_.m_252977_(Mth.m_14179_(pPartialTicks, abstractArrow.f_19859_, abstractArrow.m_146908_()) - 90.0F));
/* 52 */     poseStack.m_252781_(Axis.f_252403_.m_252977_(Mth.m_14179_(pPartialTicks, abstractArrow.f_19860_, abstractArrow.m_146909_())));
/* 53 */     poseStack.m_85837_(-0.2D, 0.0D, 0.0D);
/* 54 */     poseStack.m_252781_(Axis.f_252403_.m_252977_(-45.0F));
/* 55 */     poseStack.m_85841_(1.5F, 1.5F, 1.5F);
/* 56 */     ItemStack pickupItem = abstractArrow.m_7941_();
/* 57 */     if (pickupItem.m_150930_(Items.f_42412_) && abstractArrow instanceof Arrow) { Arrow arrow = (Arrow)abstractArrow;
/* 58 */       int color = arrow.m_36889_();
/* 59 */       if (color != -1) {
/* 60 */         pickupItem = Items.f_42738_.m_7968_();
/* 61 */         pickupItem.m_41784_().m_128405_("CustomPotionColor", color);
/*    */       }  }
/*    */     
/* 64 */     this.renderer.m_269128_(pickupItem, ItemDisplayContext.GROUND, pPackedLight, OverlayTexture.f_118083_, poseStack, buffer, abstractArrow.m_9236_(), abstractArrow.m_19879_());
/* 65 */     poseStack.m_85849_();
/* 66 */     super.m_7392_((Entity)abstractArrow, pEntityYaw, pPartialTicks, poseStack, buffer, pPackedLight);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull AbstractArrow entity) {
/* 71 */     return TippableArrowRenderer.f_116132_;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\SpriteArrowRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */