/*    */ package com.pla.annoyingvillagers.mixin.client;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.pla.annoyingvillagers.client.renderer.ColoredGlintRenderTypes;
/*    */ import com.pla.annoyingvillagers.client.renderer.ColoredGlintState;
/*    */ import net.minecraft.client.model.HumanoidModel;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({HumanoidArmorLayer.class})
/*    */ public abstract class HumanoidArmorLayerMixin<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>>
/*    */ {
/*    */   @Inject(method = {"renderArmorPiece(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;ILnet/minecraft/client/model/HumanoidModel;)V"}, at = {@At("HEAD")})
/*    */   private void av$setArmorTarget(PoseStack poseStack, MultiBufferSource bufferSource, T entity, EquipmentSlot slot, int packedLight, A model, CallbackInfo ci) {
/* 30 */     ColoredGlintState.setTargetStack(entity.m_6844_(slot));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"renderArmorPiece(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;ILnet/minecraft/client/model/HumanoidModel;)V"}, at = {@At("RETURN")})
/*    */   private void av$clearArmorTarget(PoseStack poseStack, MultiBufferSource bufferSource, T entity, EquipmentSlot slot, int packedLight, A model, CallbackInfo ci) {
/* 39 */     ColoredGlintState.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @ModifyExpressionValue(method = {"renderGlint(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/model/Model;)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderType;armorEntityGlint()Lnet/minecraft/client/renderer/RenderType;")})
/*    */   private RenderType av$replaceArmorGlint(RenderType original) {
/* 50 */     return (ColoredGlintState.getMode() == 2) ? 
/* 51 */       ColoredGlintRenderTypes.ARMOR_ENTITY_GLINT_CYAN : 
/* 52 */       original;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\client\HumanoidArmorLayerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */