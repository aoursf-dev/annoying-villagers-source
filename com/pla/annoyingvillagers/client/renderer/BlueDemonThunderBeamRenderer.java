/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import com.pla.annoyingvillagers.client.engine.ThunderRender;
/*    */ import com.pla.annoyingvillagers.entity.BlueDemonThunderBeamEntity;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.joml.Matrix3f;
/*    */ import org.joml.Matrix4f;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class BlueDemonThunderBeamRenderer extends EntityRenderer<BlueDemonThunderBeamEntity> {
/* 22 */   private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/dragon_beam.png");
/* 23 */   private final ThunderRender thunderRender = new ThunderRender();
/*    */   
/*    */   public BlueDemonThunderBeamRenderer(EntityRendererProvider.Context pContext) {
/* 26 */     super(pContext);
/*    */   }
/*    */   @NotNull
/*    */   public Vec3 getRenderOffset(BlueDemonThunderBeamEntity dragonBeam, float p_114484_) {
/* 30 */     return new Vec3((dragonBeam.m_9236_()).f_46441_.m_188583_() * 0.03D, (dragonBeam.m_9236_()).f_46441_.m_188583_() * 0.03D, (dragonBeam.m_9236_()).f_46441_.m_188583_() * 0.03D);
/*    */   }
/*    */   
/*    */   public void render(@NotNull BlueDemonThunderBeamEntity blueDemonThunderBeamEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
/* 34 */     super.m_7392_((Entity)blueDemonThunderBeamEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
/* 35 */     if (blueDemonThunderBeamEntity.isSetUseNoVfxThunder()) {
/* 36 */       poseStack.m_85836_();
/* 37 */       Vec3 from = blueDemonThunderBeamEntity.getStartPos();
/* 38 */       Vec3 to = blueDemonThunderBeamEntity.getEndPos();
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 43 */       ThunderRender.ThunderData bolt = (new ThunderRender.ThunderData(ThunderRender.ThunderData.ThunderRenderInfo.BLUE_DEMON_THUNDER, from, to, 15)).size(0.1F).lifespan(4).spawn(ThunderRender.ThunderData.SpawnFunction.delay(1.0F));
/* 44 */       this.thunderRender.update(null, bolt, partialTicks);
/* 45 */       poseStack.m_85837_(-blueDemonThunderBeamEntity.m_20185_(), -blueDemonThunderBeamEntity.m_20186_(), -blueDemonThunderBeamEntity.m_20189_());
/* 46 */       this.thunderRender.render(partialTicks, poseStack, buffer);
/* 47 */       poseStack.m_85849_();
/*    */     } 
/*    */   }
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull BlueDemonThunderBeamEntity dragonBeam) {
/* 52 */     return TEXTURE;
/*    */   }
/*    */   
/*    */   public void drawVertex(Matrix4f matrix, Matrix3f normals, VertexConsumer vertexBuilder, float offsetX, float offsetY, float offsetZ, float textureX, float textureY, float alpha, int packedLightIn) {
/* 56 */     vertexBuilder.m_252986_(matrix, offsetX, offsetY, offsetZ).m_85950_(1.0F, 1.0F, 1.0F, alpha).m_7421_(textureX, textureY).m_86008_(OverlayTexture.f_118083_).m_85969_(packedLightIn).m_252939_(normals, 0.0F, 1.0F, 0.0F).m_5752_();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\BlueDemonThunderBeamRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */