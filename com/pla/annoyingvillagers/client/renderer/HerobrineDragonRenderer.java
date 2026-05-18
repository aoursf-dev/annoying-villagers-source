/*     */ package com.pla.annoyingvillagers.client.renderer;
/*     */ 
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.math.Axis;
/*     */ import com.pla.annoyingvillagers.client.animation.DragonAnimator;
/*     */ import com.pla.annoyingvillagers.client.model.ModelHerobrineDragon;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import net.minecraft.client.model.EntityModel;
/*     */ import net.minecraft.client.renderer.MultiBufferSource;
/*     */ import net.minecraft.client.renderer.RenderType;
/*     */ import net.minecraft.client.renderer.culling.Frustum;
/*     */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*     */ import net.minecraft.client.renderer.entity.MobRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*     */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*     */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HerobrineDragonRenderer
/*     */   extends MobRenderer<HerobrineDragonEntity, ModelHerobrineDragon>
/*     */ {
/*  39 */   private static final ResourceLocation BODY_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_dragon/body.png");
/*     */   
/*  41 */   private static final ResourceLocation GLOW_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_dragon/glow.png");
/*     */   
/*  43 */   private static final ResourceLocation DISSOLVE_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_dragon/dissolve.png");
/*     */   
/*  45 */   private static final RenderType DISSOLVE_TYPE = RenderType.m_173235_(DISSOLVE_TEXTURE);
/*     */   
/*     */   public HerobrineDragonRenderer(EntityRendererProvider.Context ctx) {
/*  48 */     super(ctx, (EntityModel)new ModelHerobrineDragon(ctx.m_174023_(ModelHerobrineDragon.LAYER_LOCATION)), 2.0F);
/*  49 */     m_115326_(new GlowLayer(this));
/*  50 */     m_115326_(new DeathLayer(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender(@NotNull HerobrineDragonEntity dragon, @NotNull Frustum frustum, double camX, double camY, double camZ) {
/*  56 */     return super.m_5523_((Mob)dragon, frustum, camX, camY, camZ);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public ResourceLocation getTextureLocation(@NotNull HerobrineDragonEntity dragon) {
/*  61 */     return BODY_TEXTURE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   protected RenderType getRenderType(HerobrineDragonEntity entity, boolean visible, boolean invisToClient, boolean glowing) {
/*  68 */     return (entity.f_20919_ > 0) ? null : super.m_7225_((LivingEntity)entity, visible, invisToClient, glowing);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setupRotations(@NotNull HerobrineDragonEntity dragon, @NotNull PoseStack ps, float ageInTicks, float yaw, float partialTicks) {
/*  74 */     super.m_7523_((LivingEntity)dragon, ps, ageInTicks, yaw, partialTicks);
/*     */     
/*  76 */     DragonAnimator animator = dragon.getAnimator();
/*  77 */     if (animator != null) {
/*  78 */       ps.m_252880_(animator.getModelOffsetX(), animator.getModelOffsetY(), animator.getModelOffsetZ());
/*  79 */       ps.m_85837_(0.0D, 1.5D, 0.5D);
/*  80 */       ps.m_252781_(Axis.f_252529_.m_252977_(animator.getModelPitch(partialTicks)));
/*  81 */       ps.m_85837_(0.0D, -1.5D, -0.5D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected float getFlipDegrees(@NotNull HerobrineDragonEntity entity) {
/*  87 */     return 0.0F;
/*     */   }
/*     */   
/*     */   private static class GlowLayer extends RenderLayer<HerobrineDragonEntity, ModelHerobrineDragon> {
/*     */     public GlowLayer(HerobrineDragonRenderer parent) {
/*  92 */       super((RenderLayerParent)parent);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(@NotNull PoseStack ps, @NotNull MultiBufferSource buffer, int light, @NotNull HerobrineDragonEntity dragon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
/* 100 */       if (dragon.f_20919_ > 0) {
/*     */         return;
/*     */       }
/* 103 */       RenderType type = RenderType.m_110488_(HerobrineDragonRenderer.GLOW_TEXTURE);
/* 104 */       ((ModelHerobrineDragon)m_117386_()).m_7695_(ps, buffer.m_6299_(type), light, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class DeathLayer
/*     */     extends RenderLayer<HerobrineDragonEntity, ModelHerobrineDragon> {
/*     */     public DeathLayer(HerobrineDragonRenderer parent) {
/* 111 */       super((RenderLayerParent)parent);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(@NotNull PoseStack ps, @NotNull MultiBufferSource buffer, int light, @NotNull HerobrineDragonEntity dragon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
/* 119 */       if (dragon.f_20919_ <= 0)
/*     */         return; 
/* 121 */       float delta = dragon.f_20919_ / dragon.getMaxDeathTime();
/* 122 */       ((ModelHerobrineDragon)m_117386_()).m_7695_(ps, buffer.m_6299_(HerobrineDragonRenderer.DISSOLVE_TYPE), light, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, delta);
/*     */ 
/*     */       
/* 125 */       ((ModelHerobrineDragon)m_117386_()).m_7695_(ps, buffer.m_6299_(RenderType.m_110479_(HerobrineDragonRenderer.BODY_TEXTURE)), light, 
/* 126 */           OverlayTexture.m_118090_(0.0F, true), 1.0F, 1.0F, 1.0F, 1.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\HerobrineDragonRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */