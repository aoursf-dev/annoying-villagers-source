/*     */ package com.pla.annoyingvillagers.util;
/*     */ 
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.CombatCommon;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
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
/*     */ class null
/*     */   extends DelayedTask
/*     */ {
/*     */   null(int waitTicks) {
/* 332 */     super(waitTicks);
/*     */   }
/*     */   public void run() {
/* 335 */     if (!entity.m_6084_())
/*     */       return; 
/* 337 */     LivingEntityPatch<?> patch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 338 */     if (patch == null)
/* 339 */       return;  AssetAccessor<? extends StaticAnimation> currentAnim = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 340 */     if (currentAnim.get() instanceof yesman.epicfight.api.animation.types.AttackAnimation || 
/* 341 */       EpicfightUtil.isLongHitAnimation(currentAnim, patch) || 
/* 342 */       CombatCommon.canEscape((MobPatch)livingEntityPatch)) {
/* 343 */       CombatBehaviour.recoverItemDueToFailure(entity);
/*     */       return;
/*     */     } 
/* 346 */     final Runnable bite = () -> CombatBehaviour.performDrinkingHealingPotionActionMainhand(entity, levelaccessor, patch);
/* 347 */     int biteDelay = 4;
/* 348 */     int totalBites = 7;
/*     */     
/* 350 */     for (int i = 0; i < totalBites; i++) {
/* 351 */       int delay = 4 + i * biteDelay;
/* 352 */       new DelayedTask(delay)
/*     */         {
/*     */           public void run() {
/* 355 */             if (entity.m_6084_()) {
/* 356 */               bite.run();
/*     */             }
/*     */           }
/*     */         };
/*     */     } 
/*     */     
/* 362 */     new DelayedTask(4 + totalBites * biteDelay - 1)
/*     */       {
/*     */         public void run() {
/* 365 */           if (!entity.m_6084_())
/* 366 */             return;  if (levelaccessor instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)levelaccessor;
/* 367 */             serverLevel.m_5594_(null, entity
/* 368 */                 .m_20183_(), SoundEvents.f_12321_, SoundSource.NEUTRAL, 1.5F, 1.0F); }
/*     */         
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 375 */     new DelayedTask(4 + totalBites * biteDelay)
/*     */       {
/*     */         public void run() {
/* 378 */           if (!entity.m_6084_())
/*     */             return; 
/* 380 */           LivingEntityPatch<?> livingEntityPatch1 = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 381 */           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && livingEntityPatch1 != null) {
/* 382 */             livingEntityPatch1.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F);
/*     */           }
/*     */           
/* 385 */           if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 386 */             livingEntity.m_21008_(InteractionHand.MAIN_HAND, playerNpcEntity.getMainWeaponItem()); }
/*     */           
/* 388 */           if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity; if (livingEntityPatch1 != null) {
/* 389 */               if (AVNpc instanceof com.pla.annoyingvillagers.entity.SteveEntity && CombatCommon.canSwitchWeapon((MobPatch)livingEntityPatch1)) {
/* 390 */                 CombatCommon.switchWeapon((MobPatch)livingEntityPatch1);
/*     */               } else {
/* 392 */                 livingEntity.m_21008_(InteractionHand.MAIN_HAND, AVNpc.getMainWeaponItem());
/*     */               } 
/*     */             } }
/*     */           
/* 396 */           if (!livingEntity.m_9236_().m_5776_()) {
/* 397 */             if (isHostile) {
/* 398 */               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19602_, 40, 0));
/*     */             } else {
/* 400 */               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 200, 1));
/*     */             } 
/*     */           }
/*     */           
/* 404 */           if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 405 */             playerNpcEntity.setHealing(false); }
/*     */           
/* 407 */           if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 408 */             AVNpc.setHealing(false); }
/*     */         
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\CombatBehaviour$3.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */