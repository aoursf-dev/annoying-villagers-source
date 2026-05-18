/*     */ package com.pla.annoyingvillagers.mixin;
/*     */ 
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.CombatCommon;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
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
/*     */ class null
/*     */   extends DelayedTask
/*     */ {
/*     */   null(int waitTicks) {
/* 475 */     super(waitTicks);
/*     */   }
/*     */   public void run() {
/* 478 */     boolean rollAndSwap = false;
/* 479 */     if (defender instanceof AVNpc) { AVNpc AVNpc = (AVNpc)defender; if (AVNpc
/* 480 */         .getBlockDamage() != null) {
/* 481 */         AVNpc.setBlockDamage(null);
/* 482 */         rollAndSwap = true;
/*     */       }  }
/*     */     
/* 485 */     if (defender instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)defender; if (playerNpcEntity
/* 486 */         .getBlockDamage() != null) {
/* 487 */         playerNpcEntity.setBlockDamage(null);
/* 488 */         rollAndSwap = true;
/*     */       }  }
/*     */     
/* 491 */     if (rollAndSwap)
/* 492 */       if (CombatCommon.canSwapToBow((MobPatch)defenderLivingEntityPatch)) {
/* 493 */         double chance = (new Random()).nextDouble(0.0D, 1.0D);
/* 494 */         if (chance <= 0.25D) {
/* 495 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_KNOCKDOWN_WAKEUP_RIGHT, 0.0F);
/* 496 */           CombatCommon.swapToBow((MobPatch)defenderLivingEntityPatch);
/* 497 */         } else if (chance <= 0.5D) {
/* 498 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_KNOCKDOWN_WAKEUP_LEFT, 0.0F);
/* 499 */           CombatCommon.swapToBow((MobPatch)defenderLivingEntityPatch);
/* 500 */         } else if (chance <= 0.7D) {
/* 501 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_ROLL_BACKWARD, 0.0F);
/* 502 */           CombatCommon.swapToBow((MobPatch)defenderLivingEntityPatch);
/* 503 */         } else if (chance <= 0.8D) {
/* 504 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_KNOCKDOWN_WAKEUP_RIGHT, 0.0F);
/* 505 */           CombatCommon.swapToMelee((MobPatch)defenderLivingEntityPatch);
/* 506 */         } else if (chance <= 0.9D) {
/* 507 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_KNOCKDOWN_WAKEUP_LEFT, 0.0F);
/* 508 */           CombatCommon.swapToMelee((MobPatch)defenderLivingEntityPatch);
/*     */         } else {
/* 510 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_ROLL_BACKWARD, 0.0F);
/* 511 */           CombatCommon.swapToMelee((MobPatch)defenderLivingEntityPatch);
/*     */         } 
/*     */       } else {
/* 514 */         double chance = (new Random()).nextDouble(0.0D, 1.0D);
/* 515 */         if (chance <= 0.4D) {
/* 516 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_KNOCKDOWN_WAKEUP_RIGHT, 0.0F);
/* 517 */           CombatCommon.swapToMelee((MobPatch)defenderLivingEntityPatch);
/* 518 */         } else if (chance <= 0.5D) {
/* 519 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_KNOCKDOWN_WAKEUP_LEFT, 0.0F);
/* 520 */           CombatCommon.swapToMelee((MobPatch)defenderLivingEntityPatch);
/*     */         } else {
/* 522 */           defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_ROLL_BACKWARD, 0.0F);
/* 523 */           CombatCommon.swapToMelee((MobPatch)defenderLivingEntityPatch);
/*     */         } 
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\MobClashBladeMixin$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */