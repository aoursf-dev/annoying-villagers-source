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
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
/*    */ import reascer.wom.gameasset.animations.weapons.AnimsMoonless;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.EntityState;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.api.utils.math.MathUtils;
/*    */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*    */ import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class RenderObsidianWeapon
/*    */   extends RenderItemBase
/*    */ {
/*    */   public RenderObsidianWeapon(JsonElement json) {
/* 36 */     super(json);
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
/* 48 */     if (livingEntityPatch != null) {
/* 49 */       OpenMatrix4f openmatrix4f = new OpenMatrix4f(getCorrectionMatrix(livingEntityPatch, InteractionHand.MAIN_HAND, poses));
/* 50 */       AnimationPlayer animationPlayer = Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null));
/* 51 */       AssetAccessor<? extends StaticAnimation> dynamicAnimation = animationPlayer.getRealAnimation();
/* 52 */       float elapsedTimeFloat = animationPlayer.getElapsedTime();
/* 53 */       EntityState entityState = ((StaticAnimation)dynamicAnimation.get()).getState(livingEntityPatch, elapsedTimeFloat);
/*    */ 
/*    */       
/* 56 */       if (dynamicAnimation == AVAnimations.OLD_MOONLESS_RUN || dynamicAnimation == AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL || dynamicAnimation == AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3 || dynamicAnimation == AVAnimations.OBSIDIAN_FIST_AUTO3 || dynamicAnimation == AVAnimations.OBSIDIAN_FIST_AUTO1 || dynamicAnimation == AVAnimations.OBSIDIAN_BIPED_LANDING || dynamicAnimation == AVAnimations.OBSIDIAN_STRONG_PUNCH || dynamicAnimation
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 63 */         .get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation) {
/* 64 */         ItemStack itemstack = ItemStack.f_41583_;
/* 65 */         poseStack.m_85836_();
/* 66 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 67 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 68 */         poseStack.m_85849_();
/* 69 */       } else if (dynamicAnimation == AVAnimations.OBSIDIAN_FIST_DASH && entityState.getLevel() > 1) {
/* 70 */         ItemStack itemstack = ItemStack.f_41583_;
/* 71 */         poseStack.m_85836_();
/* 72 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 73 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 74 */         poseStack.m_85849_();
/* 75 */       } else if (dynamicAnimation == AnimsEnderblaster.ENDERBLASTER_ONEHAND_RELOAD || dynamicAnimation == AnimsMoonless.MOONLESS_GUARD_HIT_1) {
/* 76 */         ItemStack itemstack = new ItemStack((ItemLike)Items.f_41829_);
/* 77 */         poseStack.m_85836_();
/* 78 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 79 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 80 */         poseStack.m_85849_();
/*    */       } else {
/* 82 */         ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.OBSIDIAN_WEAPON.get());
/* 83 */         poseStack.m_85836_();
/* 84 */         MathUtils.mulStack(poseStack, openmatrix4f);
/* 85 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 86 */         poseStack.m_85849_();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\RenderObsidianWeapon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */