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
/*     */ class null
/*     */   extends DelayedTask
/*     */ {
/*     */   null(int waitTicks) {
/* 216 */     super(waitTicks);
/*     */   }
/*     */   public void run() {
/* 219 */     if (!entity.m_6084_())
/*     */       return; 
/* 221 */     LivingEntityPatch<?> patch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 222 */     if (patch == null)
/* 223 */       return;  AssetAccessor<? extends StaticAnimation> currentAnim = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 224 */     if (currentAnim.get() instanceof yesman.epicfight.api.animation.types.AttackAnimation || 
/* 225 */       EpicfightUtil.isLongHitAnimation(currentAnim, patch) || 
/* 226 */       CombatCommon.canEscape((MobPatch)livingEntityPatch)) {
/* 227 */       CombatBehaviour.recoverItemDueToFailure(entity);
/*     */       return;
/*     */     } 
/* 230 */     final Runnable bite = () -> CombatBehaviour.performEatingGoldenAppleActionMainHand(entity, levelaccessor, patch);
/* 231 */     int biteDelay = 4;
/* 232 */     int totalBites = 7;
/*     */     
/* 234 */     for (int i = 0; i < totalBites; i++) {
/* 235 */       int delay = 4 + i * biteDelay;
/* 236 */       new DelayedTask(delay)
/*     */         {
/*     */           public void run() {
/* 239 */             if (entity.m_6084_()) {
/* 240 */               bite.run();
/*     */             }
/*     */           }
/*     */         };
/*     */     } 
/*     */     
/* 246 */     new DelayedTask(4 + totalBites * biteDelay - 1)
/*     */       {
/*     */         public void run() {
/* 249 */           if (!entity.m_6084_())
/* 250 */             return;  if (levelaccessor instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)levelaccessor;
/* 251 */             serverLevel.m_5594_(null, entity
/* 252 */                 .m_20183_(), SoundEvents.f_12321_, SoundSource.NEUTRAL, 1.5F, 1.0F); }
/*     */         
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 259 */     new DelayedTask(4 + totalBites * biteDelay)
/*     */       {
/*     */         public void run() {
/* 262 */           if (!entity.m_6084_())
/*     */             return; 
/* 264 */           LivingEntityPatch<?> livingEntityPatch1 = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 265 */           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && livingEntityPatch1 != null) {
/* 266 */             livingEntityPatch1.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F);
/*     */           }
/*     */           
/* 269 */           if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 270 */             livingEntity.m_21008_(InteractionHand.MAIN_HAND, playerNpcEntity.getMainWeaponItem()); }
/*     */           
/* 272 */           if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity; if (livingEntityPatch1 != null) {
/* 273 */               if (AVNpc instanceof com.pla.annoyingvillagers.entity.SteveEntity && CombatCommon.canSwitchWeapon((MobPatch)livingEntityPatch1)) {
/* 274 */                 CombatCommon.switchWeapon((MobPatch)livingEntityPatch1);
/*     */               } else {
/* 276 */                 livingEntity.m_21008_(InteractionHand.MAIN_HAND, AVNpc.getMainWeaponItem());
/*     */               } 
/*     */             } }
/*     */           
/* 280 */           if (!livingEntity.m_9236_().m_5776_()) {
/* 281 */             if (isEnchanted) {
/* 282 */               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19617_, 2400, 3));
/* 283 */               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 400, 1));
/* 284 */               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 6000, 0));
/* 285 */               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19607_, 6000, 0));
/*     */             } else {
/* 287 */               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19617_, 2400, 0));
/* 288 */               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 100, 1));
/*     */             } 
/*     */           }
/*     */           
/* 292 */           if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 293 */             playerNpcEntity.setHealing(false); }
/*     */           
/* 295 */           if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 296 */             AVNpc.setHealing(false); }
/*     */         
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\CombatBehaviour$2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */