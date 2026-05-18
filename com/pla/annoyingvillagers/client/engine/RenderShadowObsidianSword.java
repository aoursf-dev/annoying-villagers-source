/*     */ package com.pla.annoyingvillagers.client.engine;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.math.Axis;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.MultiBufferSource;
/*     */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.ItemDisplayContext;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.EntityState;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.math.MathUtils;
/*     */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*     */ import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ 
/*     */ @OnlyIn(Dist.CLIENT)
/*     */ public class RenderShadowObsidianSword
/*     */   extends RenderItemBase
/*     */ {
/*     */   public RenderShadowObsidianSword(JsonElement json) {
/*  34 */     super(json);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderItemInHand(ItemStack stack, LivingEntityPatch<?> livingEntityPatch, InteractionHand hand, OpenMatrix4f[] poses, MultiBufferSource buffer, PoseStack poseStack, int packedLight, float partialTicks) {
/*  46 */     if (livingEntityPatch != null) {
/*  47 */       if (hand == InteractionHand.MAIN_HAND && ((LivingEntity)livingEntityPatch
/*  48 */         .getOriginal()).m_21205_().m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get())) {
/*  49 */         OpenMatrix4f openmatrix4f = new OpenMatrix4f(getCorrectionMatrix(livingEntityPatch, InteractionHand.MAIN_HAND, poses));
/*  50 */         AnimationPlayer animationPlayer = Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null));
/*  51 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = animationPlayer.getRealAnimation();
/*  52 */         float elapsedTimeFloat = animationPlayer.getElapsedTime();
/*  53 */         EntityState entityState = ((StaticAnimation)dynamicAnimation.get()).getState(livingEntityPatch, elapsedTimeFloat);
/*     */ 
/*     */         
/*  56 */         if (dynamicAnimation == AVAnimations.OBSIDIAN_FIST_DASH && entityState.getLevel() > 1) {
/*  57 */           ItemStack itemstack = ItemStack.f_41583_;
/*  58 */           poseStack.m_85836_();
/*  59 */           MathUtils.mulStack(poseStack, openmatrix4f);
/*  60 */           Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/*  61 */           poseStack.m_85849_();
/*  62 */         } else if (((dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4 || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5 || dynamicAnimation
/*     */ 
/*     */ 
/*     */           
/*  66 */           .get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation) && entityState.getLevel() > 1) || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE_PILLAR) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  72 */           ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_STRAIGHT.get());
/*  73 */           if (itemstack.m_41783_() != null) {
/*  74 */             itemstack.m_41783_().m_128379_("foil", ((LivingEntity)livingEntityPatch.getOriginal()).m_21205_().m_41793_());
/*     */           }
/*  76 */           poseStack.m_85836_();
/*  77 */           MathUtils.mulStack(poseStack, openmatrix4f);
/*  78 */           Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/*  79 */           poseStack.m_85849_();
/*     */         } else {
/*  81 */           ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/*  82 */           poseStack.m_85836_();
/*  83 */           MathUtils.mulStack(poseStack, openmatrix4f);
/*  84 */           Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/*  85 */           poseStack.m_85849_();
/*     */         } 
/*     */       } 
/*  88 */       if (hand == InteractionHand.OFF_HAND && ((LivingEntity)livingEntityPatch
/*  89 */         .getOriginal()).m_21206_().m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get())) {
/*  90 */         OpenMatrix4f openmatrix4f = new OpenMatrix4f(getCorrectionMatrix(livingEntityPatch, InteractionHand.OFF_HAND, poses));
/*  91 */         AnimationPlayer animationPlayer = Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null));
/*  92 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = animationPlayer.getRealAnimation();
/*  93 */         float elapsedTimeFloat = animationPlayer.getElapsedTime();
/*  94 */         EntityState entityState = ((StaticAnimation)dynamicAnimation.get()).getState(livingEntityPatch, elapsedTimeFloat);
/*     */         
/*  96 */         if (((dynamicAnimation == AVAnimations.OBSIDIAN_INFERNAL_AUTO_1 || dynamicAnimation == AVAnimations.OBSIDIAN_STRONG_PUNCH || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1 || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3) && entityState
/*     */ 
/*     */           
/*  99 */           .getLevel() > 1) || (dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3 && entityState
/* 100 */           .getLevel() > 2)) {
/* 101 */           ItemStack itemstack = ItemStack.f_41583_;
/* 102 */           poseStack.m_85836_();
/* 103 */           MathUtils.mulStack(poseStack, openmatrix4f);
/* 104 */           Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 105 */           poseStack.m_85849_();
/* 106 */         } else if (((dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4 || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5 || dynamicAnimation
/*     */           
/* 108 */           .get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation) && entityState.getLevel() > 1) || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3 || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE_PILLAR) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 113 */           ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_STRAIGHT.get());
/* 114 */           if (itemstack.m_41783_() != null) {
/* 115 */             itemstack.m_41783_().m_128379_("foil", ((LivingEntity)livingEntityPatch.getOriginal()).m_21206_().m_41793_());
/*     */           }
/* 117 */           poseStack.m_85836_();
/* 118 */           MathUtils.mulStack(poseStack, openmatrix4f);
/* 119 */           Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 120 */           poseStack.m_85849_();
/*     */         } else {
/* 122 */           ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 123 */           poseStack.m_85836_();
/* 124 */           MathUtils.mulStack(poseStack, openmatrix4f);
/* 125 */           poseStack.m_252781_(Axis.f_252436_.m_252977_(45.0F));
/* 126 */           Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 127 */           poseStack.m_85849_();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\RenderShadowObsidianSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */