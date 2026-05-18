/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.math.Axis;
/*    */ import com.pla.annoyingvillagers.client.model.ModelBbq;
/*    */ import net.minecraft.client.model.ChickenModel;
/*    */ import net.minecraft.client.model.EntityModel;
/*    */ import net.minecraft.client.renderer.ItemInHandRenderer;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.animal.Chicken;
/*    */ import net.minecraft.world.item.ItemDisplayContext;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class BbqHeldItemLayer extends RenderLayer<Chicken, ChickenModel<Chicken>> {
/*    */   public BbqHeldItemLayer(RenderLayerParent<Chicken, ChickenModel<Chicken>> parent, ItemInHandRenderer itemInHandRenderer) {
/* 21 */     super(parent);
/* 22 */     this.itemInHandRenderer = itemInHandRenderer;
/*    */   }
/*    */ 
/*    */   
/*    */   private final ItemInHandRenderer itemInHandRenderer;
/*    */   
/*    */   public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, @NotNull Chicken entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
/* 29 */     ItemStack mainHandItem = entity.m_21205_();
/* 30 */     if (!mainHandItem.m_41619_()) {
/* 31 */       EntityModel entityModel = m_117386_(); if (entityModel instanceof ModelBbq) { ModelBbq<?> bbqModel = (ModelBbq)entityModel;
/* 32 */         poseStack.m_85836_();
/* 33 */         bbqModel.getBeak().m_104299_(poseStack);
/* 34 */         poseStack.m_85837_(-0.8D, -0.1875D, -0.1875D);
/* 35 */         poseStack.m_252781_(Axis.f_252436_.m_252977_(90.0F));
/* 36 */         poseStack.m_252781_(Axis.f_252529_.m_252977_(90.0F));
/*    */         
/* 38 */         this.itemInHandRenderer.m_269530_((LivingEntity)entity, mainHandItem, ItemDisplayContext.GROUND, false, poseStack, buffer, packedLight);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 48 */         poseStack.m_85849_(); }
/*    */     
/*    */     } 
/*    */     
/* 52 */     ItemStack offHandItem = entity.m_21206_();
/* 53 */     if (!offHandItem.m_41619_()) {
/* 54 */       EntityModel entityModel = m_117386_(); if (entityModel instanceof ModelBbq) { ModelBbq<?> bbqModel = (ModelBbq)entityModel;
/* 55 */         poseStack.m_85836_();
/* 56 */         bbqModel.getBeak().m_104299_(poseStack);
/* 57 */         poseStack.m_85837_(0.0D, -0.1875D, -0.1875D);
/* 58 */         poseStack.m_252781_(Axis.f_252436_.m_252977_(90.0F));
/* 59 */         poseStack.m_252781_(Axis.f_252529_.m_252977_(90.0F));
/*    */         
/* 61 */         this.itemInHandRenderer.m_269530_((LivingEntity)entity, offHandItem, ItemDisplayContext.GROUND, false, poseStack, buffer, packedLight);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 71 */         poseStack.m_85849_(); }
/*    */     
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\BbqHeldItemLayer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */