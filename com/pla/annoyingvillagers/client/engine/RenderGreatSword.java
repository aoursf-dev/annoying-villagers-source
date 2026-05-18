/*    */ package com.pla.annoyingvillagers.client.engine;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemDisplayContext;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.api.utils.math.MathUtils;
/*    */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*    */ import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class RenderGreatSword extends RenderItemBase {
/*    */   public RenderGreatSword(JsonElement json) {
/* 28 */     super(json);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderItemInHand(ItemStack stack, LivingEntityPatch<?> livingEntityPatch, InteractionHand hand, OpenMatrix4f[] poses, MultiBufferSource buffer, PoseStack poseStack, int packedLight, float partialTicks) {
/* 40 */     if (livingEntityPatch != null) {
/* 41 */       OpenMatrix4f openmatrix4f = new OpenMatrix4f(getCorrectionMatrix(livingEntityPatch, InteractionHand.MAIN_HAND, poses));
/* 42 */       AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*    */ 
/*    */       
/* 45 */       if (dynamicAnimation != AVAnimations.HARD_GREATSWORD_GUARD_SKILL && !dynamicAnimation.equals(AVAnimations.HARD_GREATSWORD_GUARD)) {
/* 46 */         ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.GREAT_SWORD.get());
/* 47 */         poseStack.m_85836_();
/* 48 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 49 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 50 */         poseStack.m_85849_();
/*    */       } else {
/* 52 */         ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.GREAT_SWORD_SKILL.get());
/* 53 */         poseStack.m_85836_();
/* 54 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 55 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 56 */         poseStack.m_85849_();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\RenderGreatSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */