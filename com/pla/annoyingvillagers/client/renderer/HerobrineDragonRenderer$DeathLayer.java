/*     */ package com.pla.annoyingvillagers.client.renderer;
/*     */ 
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.pla.annoyingvillagers.client.model.ModelHerobrineDragon;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import net.minecraft.client.renderer.MultiBufferSource;
/*     */ import net.minecraft.client.renderer.RenderType;
/*     */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*     */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*     */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import org.jetbrains.annotations.NotNull;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class DeathLayer
/*     */   extends RenderLayer<HerobrineDragonEntity, ModelHerobrineDragon>
/*     */ {
/*     */   public DeathLayer(HerobrineDragonRenderer parent) {
/* 111 */     super((RenderLayerParent)parent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(@NotNull PoseStack ps, @NotNull MultiBufferSource buffer, int light, @NotNull HerobrineDragonEntity dragon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
/* 119 */     if (dragon.f_20919_ <= 0)
/*     */       return; 
/* 121 */     float delta = dragon.f_20919_ / dragon.getMaxDeathTime();
/* 122 */     ((ModelHerobrineDragon)m_117386_()).m_7695_(ps, buffer.m_6299_(HerobrineDragonRenderer.DISSOLVE_TYPE), light, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, delta);
/*     */ 
/*     */     
/* 125 */     ((ModelHerobrineDragon)m_117386_()).m_7695_(ps, buffer.m_6299_(RenderType.m_110479_(HerobrineDragonRenderer.BODY_TEXTURE)), light, 
/* 126 */         OverlayTexture.m_118090_(0.0F, true), 1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\HerobrineDragonRenderer$DeathLayer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */