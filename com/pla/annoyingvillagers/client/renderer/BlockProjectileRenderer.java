/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.math.Axis;
/*    */ import com.pla.annoyingvillagers.entity.BlockProjectileEntity;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*    */ import net.minecraft.client.renderer.texture.TextureAtlas;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class BlockProjectileRenderer extends EntityRenderer<BlockProjectileEntity> {
/*    */   public BlockProjectileRenderer(EntityRendererProvider.Context ctx) {
/* 18 */     super(ctx);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(BlockProjectileEntity entity, float yaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
/* 24 */     BlockState block = entity.getCarriedBlock();
/*    */     
/* 26 */     poseStack.m_85836_();
/* 27 */     poseStack.m_85841_(1.0F, 1.0F, 1.0F);
/* 28 */     poseStack.m_85837_(-0.5D, -0.5D, -0.5D);
/*    */     
/* 30 */     float age = entity.f_19797_ + partialTicks;
/* 31 */     poseStack.m_252781_(Axis.f_252529_.m_252977_(entity.getRotX() * age));
/* 32 */     poseStack.m_252781_(Axis.f_252436_.m_252977_(entity.getRotY() * age));
/* 33 */     poseStack.m_252781_(Axis.f_252403_.m_252977_(entity.getRotZ() * age));
/*    */     
/* 35 */     Minecraft.m_91087_().m_91289_().m_110912_(block, poseStack, buffer, packedLight, OverlayTexture.f_118083_);
/*    */ 
/*    */     
/* 38 */     poseStack.m_85849_();
/* 39 */     super.m_7392_((Entity)entity, yaw, partialTicks, poseStack, buffer, packedLight);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull BlockProjectileEntity blockProjectileEntity) {
/* 44 */     return TextureAtlas.f_118259_;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\BlockProjectileRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */