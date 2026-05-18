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
/*     */ @OnlyIn(Dist.CLIENT)
/*     */ public class RenderShadowObsidianPillar
/*     */   extends RenderItemBase
/*     */ {
/*     */   public RenderShadowObsidianPillar(JsonElement json) {
/*  33 */     super(json);
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
/*  45 */     if (livingEntityPatch != null && (
/*  46 */       (LivingEntity)livingEntityPatch.getOriginal()).m_21205_().m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get())) {
/*  47 */       OpenMatrix4f openmatrix4fmainHand = new OpenMatrix4f(getCorrectionMatrix(livingEntityPatch, InteractionHand.MAIN_HAND, poses));
/*  48 */       OpenMatrix4f openmatrix4foffHand = new OpenMatrix4f(getCorrectionMatrix(livingEntityPatch, InteractionHand.OFF_HAND, poses));
/*  49 */       AnimationPlayer animationPlayer = Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null));
/*  50 */       AssetAccessor<? extends StaticAnimation> dynamicAnimation = animationPlayer.getRealAnimation();
/*  51 */       float elapsedTimeFloat = animationPlayer.getElapsedTime();
/*  52 */       EntityState entityState = ((StaticAnimation)dynamicAnimation.get()).getState(livingEntityPatch, elapsedTimeFloat);
/*     */ 
/*     */       
/*  55 */       if (dynamicAnimation == AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL || dynamicAnimation == AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3 || dynamicAnimation == AVAnimations.OBSIDIAN_FIST_AUTO3 || dynamicAnimation == AVAnimations.OBSIDIAN_FIST_AUTO1 || dynamicAnimation == AVAnimations.OBSIDIAN_BIPED_LANDING) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  60 */         ItemStack itemstack = ItemStack.f_41583_;
/*  61 */         poseStack.m_85836_();
/*  62 */         MathUtils.mulStack(poseStack, openmatrix4fmainHand);
/*  63 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/*  64 */         poseStack.m_85849_();
/*  65 */       } else if (((dynamicAnimation == AVAnimations.OBSIDIAN_FIST_AIR_SLASH || dynamicAnimation == AVAnimations.OBSIDIAN_INFERNAL_AUTO_2 || dynamicAnimation
/*     */         
/*  67 */         .get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation) && entityState.getLevel() > 1) || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE_PILLAR) {
/*     */ 
/*     */         
/*  70 */         ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_BURST.get());
/*  71 */         if (itemstack.m_41783_() != null) {
/*  72 */           itemstack.m_41783_().m_128379_("foil", ((LivingEntity)livingEntityPatch.getOriginal()).m_21205_().m_41793_());
/*     */         }
/*  74 */         poseStack.m_85836_();
/*  75 */         MathUtils.mulStack(poseStack, openmatrix4fmainHand);
/*  76 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/*  77 */         poseStack.m_85849_();
/*  78 */       } else if ((dynamicAnimation == AVAnimations.OBSIDIAN_INFERNAL_AUTO_1 || dynamicAnimation == AVAnimations.OBSIDIAN_STRONG_PUNCH || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1 || dynamicAnimation == AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3) && entityState
/*     */ 
/*     */ 
/*     */         
/*  82 */         .getLevel() > 1) {
/*  83 */         ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get());
/*  84 */         poseStack.m_85836_();
/*  85 */         MathUtils.mulStack(poseStack, openmatrix4fmainHand);
/*  86 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/*  87 */         poseStack.m_85849_();
/*     */         
/*  89 */         if (((LivingEntity)livingEntityPatch.getOriginal()).m_21206_().m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get())) {
/*  90 */           itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_STRAIGHT.get());
/*  91 */           if (itemstack.m_41783_() != null) {
/*  92 */             itemstack.m_41783_().m_128379_("foil", ((LivingEntity)livingEntityPatch.getOriginal()).m_21206_().m_41793_());
/*     */           }
/*  94 */           poseStack.m_85836_();
/*  95 */           MathUtils.mulStack(poseStack, openmatrix4foffHand);
/*  96 */           Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/*  97 */           poseStack.m_85849_();
/*     */         } 
/*     */       } else {
/* 100 */         ItemStack itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get());
/* 101 */         poseStack.m_85836_();
/* 102 */         MathUtils.mulStack(poseStack, openmatrix4fmainHand);
/* 103 */         Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 104 */         poseStack.m_85849_();
/*     */         
/* 106 */         if (((LivingEntity)livingEntityPatch.getOriginal()).m_21206_().m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get())) {
/* 107 */           itemstack = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 108 */           poseStack.m_85836_();
/* 109 */           MathUtils.mulStack(poseStack, openmatrix4foffHand);
/* 110 */           poseStack.m_252781_(Axis.f_252436_.m_252977_(45.0F));
/* 111 */           Minecraft.m_91087_().m_91291_().m_269128_(itemstack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, packedLight, OverlayTexture.f_118083_, poseStack, buffer, ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), 0);
/* 112 */           poseStack.m_85849_();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\RenderShadowObsidianPillar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */