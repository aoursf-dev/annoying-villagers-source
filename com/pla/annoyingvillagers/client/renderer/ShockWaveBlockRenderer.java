/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.pla.annoyingvillagers.entity.ShockWaveBlockEntity;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.client.renderer.block.BlockRenderDispatcher;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*    */ import net.minecraft.client.renderer.texture.TextureAtlas;
/*    */ import net.minecraft.client.resources.model.BakedModel;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.level.BlockAndTintGetter;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.RenderShape;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.client.model.data.ModelData;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class ShockWaveBlockRenderer extends EntityRenderer<ShockWaveBlockEntity> {
/*    */   public ShockWaveBlockRenderer(EntityRendererProvider.Context context) {
/* 27 */     super(context);
/* 28 */     this.blockRenderDispatcher = context.m_234597_();
/* 29 */     this.f_114477_ = 0.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final BlockRenderDispatcher blockRenderDispatcher;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ShockWaveBlockEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
/* 41 */     BlockState blockState = entity.getBlockState();
/* 42 */     if (blockState.m_60799_() != RenderShape.MODEL || blockState.m_60799_() == RenderShape.INVISIBLE) {
/*    */       return;
/*    */     }
/*    */     
/* 46 */     Level level = entity.m_9236_();
/*    */     
/* 48 */     poseStack.m_85836_();
/* 49 */     poseStack.m_85837_(-0.5D, 0.0D, -0.5D);
/*    */     
/* 51 */     BlockPos renderPos = BlockPos.m_274561_(entity.m_20185_(), (entity.m_20191_()).f_82292_, entity.m_20189_());
/*    */     
/* 53 */     BakedModel model = this.blockRenderDispatcher.m_110910_(blockState);
/*    */     
/* 55 */     BlockPos seedPos = entity.getSourceBlockPos();
/* 56 */     long seed = blockState.m_60726_(seedPos);
/* 57 */     RandomSource seededRandom = RandomSource.m_216335_(seed);
/*    */     
/* 59 */     for (RenderType renderType : model.getRenderTypes(blockState, seededRandom, ModelData.EMPTY)) {
/* 60 */       this.blockRenderDispatcher.m_110937_().tesselateBlock((BlockAndTintGetter)level, model, blockState, renderPos, poseStack, bufferSource
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 66 */           .m_6299_(renderType), false, 
/*    */           
/* 68 */           RandomSource.m_216327_(), seed, OverlayTexture.f_118083_, ModelData.EMPTY, renderType);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 76 */     poseStack.m_85849_();
/* 77 */     super.m_7392_((Entity)entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull ShockWaveBlockEntity entity) {
/* 82 */     return TextureAtlas.f_118259_;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\ShockWaveBlockRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */