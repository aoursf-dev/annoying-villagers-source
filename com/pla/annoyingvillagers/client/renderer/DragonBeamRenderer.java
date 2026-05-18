/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.pla.annoyingvillagers.client.engine.ThunderRender;
/*    */ import com.pla.annoyingvillagers.entity.DragonBeamEntity;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class DragonBeamRenderer extends EntityRenderer<DragonBeamEntity> {
/* 18 */   private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/dragon_beam.png");
/* 19 */   private final ThunderRender thunderRender = new ThunderRender();
/*    */   
/*    */   public DragonBeamRenderer(EntityRendererProvider.Context pContext) {
/* 22 */     super(pContext);
/*    */   }
/*    */   @NotNull
/*    */   public Vec3 getRenderOffset(DragonBeamEntity dragonBeam, float p_114484_) {
/* 26 */     return new Vec3((dragonBeam.m_9236_()).f_46441_.m_188583_() * 0.03D, (dragonBeam.m_9236_()).f_46441_.m_188583_() * 0.03D, (dragonBeam.m_9236_()).f_46441_.m_188583_() * 0.03D);
/*    */   }
/*    */   
/*    */   public void render(@NotNull DragonBeamEntity dragonBeamEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
/* 30 */     super.m_7392_((Entity)dragonBeamEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
/* 31 */     if (dragonBeamEntity.isSetUseNoVfxThunder()) {
/* 32 */       poseStack.m_85836_();
/* 33 */       Vec3 from = dragonBeamEntity.getThunderStartVec3();
/* 34 */       Vec3 to = dragonBeamEntity.getThunderStopVec3();
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 39 */       ThunderRender.ThunderData bolt = (new ThunderRender.ThunderData(ThunderRender.ThunderData.ThunderRenderInfo.DRAGON_THUNDER, from, to, 15)).size(0.2F).lifespan(4).spawn(ThunderRender.ThunderData.SpawnFunction.delay(1.0F));
/* 40 */       this.thunderRender.update(null, bolt, partialTicks);
/* 41 */       poseStack.m_85837_(-dragonBeamEntity.m_20185_(), -dragonBeamEntity.m_20186_(), -dragonBeamEntity.m_20189_());
/* 42 */       this.thunderRender.render(partialTicks, poseStack, buffer);
/* 43 */       poseStack.m_85849_();
/*    */     } 
/*    */   }
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull DragonBeamEntity dragonBeam) {
/* 48 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\DragonBeamRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */