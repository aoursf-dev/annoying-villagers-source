/*    */ package com.pla.annoyingvillagers.mixin.client;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.pla.annoyingvillagers.accessors.ModelPartAccess;
/*    */ import net.minecraft.client.model.geom.ModelPart;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({ModelPart.class})
/*    */ public class ModelPartMixin implements ModelPartAccess {
/*    */   @Unique
/* 15 */   public float dm_xScale = 1.0F; @Unique
/* 16 */   public float dm_yScale = 1.0F; @Unique
/* 17 */   public float dm_zScale = 1.0F;
/*    */ 
/*    */   
/*    */   @Inject(method = {"translateAndRotate(Lcom/mojang/blaze3d/vertex/PoseStack;)V"}, at = {@At("TAIL")})
/*    */   public void dragonmounts_scalePoseStack(PoseStack pPoseStack, CallbackInfo cbi) {
/* 22 */     pPoseStack.m_85841_(this.dm_xScale, this.dm_yScale, this.dm_zScale);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getXScale() {
/* 28 */     return this.dm_xScale;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getYScale() {
/* 34 */     return this.dm_yScale;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getZScale() {
/* 40 */     return this.dm_zScale;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setXScale(float x) {
/* 46 */     this.dm_xScale = x;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setYScale(float y) {
/* 52 */     this.dm_yScale = y;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setZScale(float z) {
/* 58 */     this.dm_zScale = z;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\client\ModelPartMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */