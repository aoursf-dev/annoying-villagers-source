/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.gameasset.Animations;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ import yesman.epicfight.world.damagesource.StunType;
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class KnockdownEvent
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onEntityAttacked(LivingHurtEvent livingHurtEvent) {
/* 24 */     if (livingHurtEvent != null && livingHurtEvent.getEntity() != null) {
/* 25 */       LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)livingHurtEvent.getEntity(), LivingEntityPatch.class);
/* 26 */       if (livingEntityPatch != null && livingHurtEvent.getEntity().m_9236_() instanceof net.minecraft.server.level.ServerLevel) {
/* 27 */         AnimationPlayer animationPlayer = Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null));
/* 28 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = animationPlayer.getRealAnimation();
/* 29 */         if (dynamicAnimation == Animations.BIPED_HIT_LONG) {
/* 30 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.HIT_BACKWARD, 0.0F);
/* 31 */         } else if (dynamicAnimation == AVAnimations.HIT_BACKWARD) {
/* 32 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.HIT_LEFT, 0.0F);
/* 33 */         } else if (dynamicAnimation == AVAnimations.HIT_LEFT) {
/* 34 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.HIT_RIGHT, 0.0F);
/* 35 */         } else if (dynamicAnimation == AVAnimations.HIT_RIGHT) {
/* 36 */           float chance = (new Random()).nextFloat();
/* 37 */           if (chance <= 0.25F) {
/* 38 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.KNOCKDOWN_LEFT, 0.0F);
/* 39 */           } else if (chance <= 0.5F) {
/* 40 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.KNOCKDOWN_RIGHT, 0.0F);
/* 41 */           } else if (chance <= 0.75F) {
/* 42 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.KNOCKDOWN_FORWARD, 0.0F);
/*    */           } else {
/* 44 */             livingEntityPatch.applyStun(StunType.KNOCKDOWN, 40.0F);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\KnockdownEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */