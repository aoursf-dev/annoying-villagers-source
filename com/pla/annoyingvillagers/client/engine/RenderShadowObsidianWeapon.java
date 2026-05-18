/*    */ package com.pla.annoyingvillagers.client.engine;
/*    */ 
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
/*    */ import yesman.epicfight.api.animation.types.EntityState;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.api.utils.math.MathUtils;
/*    */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*    */ import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class RenderShadowObsidianWeapon
/*    */   extends RenderItemBase
/*    */ {
/*    */   public RenderShadowObsidianWeapon(JsonElement json) {
/* 32 */     super(json);
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
/* 44 */     if (livingEntityPatch != null) {
/* 45 */       OpenMatrix4f openmatrix4f = new OpenMatrix4f(getCorrectionMatrix(livingEntityPatch, InteractionHand.MAIN_HAND, poses));
/* 46 */       AnimationPlayer animationPlayer = Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null));
/* 47 */       AssetAccessor<? extends StaticAnimation> dynamicAnimation = animationPlayer.getRealAnimation();
/* 48 */       float elapsedTimeFloat = animationPlayer.getElapsedTime();
/* 49 */       EntityState entityState = ((StaticAnimation)dynamicAnimation.get()).getState(livingEntityPatch, elapsedTimeFloat);
/*    */ 
/*    */       
/* 52 */       if (dynamicAnimation == AVAnimations.OLD_MOONLESS_RUN || dynamicAnimation == AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL || dynamicAnimation == AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3 || dynamicAnimation == AVAnimations.OBSIDIAN_FIST_AUTO3 || dynamicAnimation == AVAnimations.OBSIDIAN_FIST_AUTO1 || dynamicAnimation == AVAnimations.OBSIDIAN_BIPED_LANDING || dynamicAnimation == AVAnimations.OBSIDIAN_STRONG_PUNCH || dynamicAnimation
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 59 */         .get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation) {
/* 60 */         ItemStack itemstack = ItemStack.f_41583_;
/* 61 */         poseStack.m_85836_();
/* 62 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 63 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 64 */         poseStack.m_85849_();
/* 65 */       } else if (dynamicAnimation == AVAnimations.OBSIDIAN_FIST_DASH && entityState.getLevel() > 1) {
/* 66 */         ItemStack itemstack = ItemStack.f_41583_;
/* 67 */         poseStack.m_85836_();
/* 68 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 69 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 70 */         poseStack.m_85849_();
/*    */       } else {
/* 72 */         ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_WEAPON.get());
/* 73 */         poseStack.m_85836_();
/* 74 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 75 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 76 */         poseStack.m_85849_();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\RenderShadowObsidianWeapon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */