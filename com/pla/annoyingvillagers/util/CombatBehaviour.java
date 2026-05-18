/*     */ package com.pla.annoyingvillagers.util;
/*     */ 
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.CombatCommon;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.particles.ItemParticleOption;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.projectile.ThrownEnderpearl;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.alchemy.PotionUtils;
/*     */ import net.minecraft.world.item.alchemy.Potions;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CombatBehaviour
/*     */ {
/*  49 */   public static final ItemStack HOSTILE_HEALING_POTION = PotionUtils.m_43549_(new ItemStack((ItemLike)Items.f_42589_), Potions.f_43582_); static {
/*  50 */     HOSTILE_HEALING_POTION.m_41764_(1);
/*  51 */   } public static final ItemStack HEALING_POTION = PotionUtils.m_43549_(new ItemStack((ItemLike)Items.f_42589_), Potions.f_43581_); static {
/*  52 */     HEALING_POTION.m_41764_(1);
/*     */   }
/*     */   
/*     */   private static Vec3 getFrontLeftPos(Entity entity) {
/*  56 */     LivingEntity le = (LivingEntity)entity;
/*     */     
/*  58 */     Vec3 base = (entity instanceof LivingEntity) ? le.m_20299_(1.0F) : entity.m_20182_().m_82520_(0.0D, entity.m_20206_() * 0.85D, 0.0D);
/*     */     
/*  60 */     base = base.m_82520_(0.0D, -0.1D, 0.0D);
/*     */     
/*  62 */     Vec3 forward = entity.m_20154_();
/*  63 */     Vec3 forwardH = new Vec3(forward.f_82479_, 0.0D, forward.f_82481_);
/*  64 */     if (forwardH.m_82556_() < 1.0E-6D) {
/*  65 */       forwardH = entity.m_20156_();
/*  66 */       forwardH = new Vec3(forwardH.f_82479_, 0.0D, forwardH.f_82481_);
/*     */     } 
/*  68 */     forwardH = forwardH.m_82541_();
/*     */     
/*  70 */     Vec3 left = (new Vec3(0.0D, 1.0D, 0.0D)).m_82537_(forwardH);
/*  71 */     if (left.m_82556_() < 1.0E-6D) {
/*  72 */       left = new Vec3(1.0D, 0.0D, 0.0D);
/*     */     } else {
/*  74 */       left = left.m_82541_();
/*     */     } 
/*     */     
/*  77 */     return base.m_82549_(forwardH.m_82490_(0.35D)).m_82549_(left.m_82490_(0.25D));
/*     */   }
/*     */   
/*     */   public static void throwEnderPearl(final Entity entity, float xRot) {
/*  81 */     if (xRot != 0.0F) {
/*  82 */       entity.m_146922_(0.0F);
/*  83 */       entity.m_146926_(xRot);
/*  84 */       entity.m_5618_(entity.m_146908_());
/*  85 */       entity.m_5616_(entity.m_146908_());
/*  86 */       entity.f_19859_ = entity.m_146908_();
/*  87 */       entity.f_19860_ = entity.m_146909_();
/*  88 */       LivingEntity livingEntity = (LivingEntity)entity;
/*  89 */       livingEntity.f_20884_ = livingEntity.m_146908_();
/*  90 */       livingEntity.f_20886_ = livingEntity.m_146908_();
/*     */     } 
/*     */     
/*  93 */     Level level = entity.m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/*  94 */       new DelayedTask(5)
/*     */         {
/*     */           public void run() {
/*  97 */             Vec3 handPos = CombatBehaviour.getFrontLeftPos(entity);
/*  98 */             ThrownEnderpearl thrownEnderpearl = new ThrownEnderpearl(EntityType.f_20484_, (Level)serverLevel);
/*  99 */             thrownEnderpearl.m_5602_(entity);
/* 100 */             thrownEnderpearl.m_6034_(handPos.f_82479_, handPos.f_82480_, handPos.f_82481_);
/* 101 */             thrownEnderpearl.m_6686_((entity.m_20154_()).f_82479_, (entity.m_20154_()).f_82480_, (entity.m_20154_()).f_82481_, (new Random()).nextBoolean() ? 1.0F : 2.0F, 0.0F);
/* 102 */             serverLevel.m_7967_((Entity)thrownEnderpearl);
/* 103 */             entity.m_9236_().m_6263_(null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_11857_, SoundSource.NEUTRAL, 0.5F, 0.4F / (entity.m_9236_().m_213780_().m_188501_() * 0.4F + 0.8F));
/*     */           }
/*     */         }; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private static void recoverItemDueToFailure(Entity entity) {
/* 111 */     if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 112 */       playerNpcEntity.m_21008_(InteractionHand.MAIN_HAND, playerNpcEntity.getMainWeaponItem());
/* 113 */       playerNpcEntity.setHealing(false);
/* 114 */       playerNpcEntity.resetGapCooldown(); }
/*     */     
/* 116 */     if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 117 */       AVNpc.m_21008_(InteractionHand.MAIN_HAND, AVNpc.getMainWeaponItem());
/* 118 */       AVNpc.setHealing(false);
/* 119 */       AVNpc.resetGapCooldown(); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void performEatingGoldenAppleActionMainHand(Entity entity, LevelAccessor levelaccessor, LivingEntityPatch<?> livingEntityPatch) {
/* 126 */     AssetAccessor<? extends StaticAnimation> currentAnim = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 127 */     if (currentAnim.get() instanceof yesman.epicfight.api.animation.types.AttackAnimation || 
/* 128 */       EpicfightUtil.isLongHitAnimation(currentAnim, livingEntityPatch) || 
/* 129 */       CombatCommon.canEscape((MobPatch)livingEntityPatch)) {
/* 130 */       recoverItemDueToFailure(entity);
/*     */       
/*     */       return;
/*     */     } 
/* 134 */     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity;
/* 135 */       livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_EAT, 0.0F); }
/*     */ 
/*     */     
/* 138 */     if (levelaccessor instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)levelaccessor;
/* 139 */       serverLevel.m_5594_(null, entity
/* 140 */           .m_20183_(), SoundEvents.f_11912_, SoundSource.NEUTRAL, 1.0F, 1.0F); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     Level level = entity.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 147 */       Vec3 forward = entity.m_20252_(1.0F);
/* 148 */       Vec3 up = entity.m_20289_(1.0F);
/* 149 */       Vec3 left = up.m_82537_(forward).m_82541_();
/*     */ 
/*     */ 
/*     */       
/* 153 */       Vec3 spawnPos = entity.m_20182_().m_82549_(left.m_82490_(0.0D)).m_82549_(up.m_82490_(1.5D)).m_82549_(forward.m_82490_(0.5D));
/*     */       
/* 155 */       serverLevel.m_8767_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, new ItemStack((ItemLike)Items.f_42436_)), spawnPos.f_82479_, spawnPos.f_82480_, spawnPos.f_82481_, 10, 0.0D, 0.0D, 0.0D, 0.01D); }
/*     */   
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
/*     */   private static void performDrinkingHealingPotionActionMainhand(Entity entity, LevelAccessor levelaccessor, LivingEntityPatch<?> livingEntityPatch) {
/* 168 */     AssetAccessor<? extends StaticAnimation> currentAnim = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 169 */     if (currentAnim.get() instanceof yesman.epicfight.api.animation.types.AttackAnimation || 
/* 170 */       EpicfightUtil.isLongHitAnimation(currentAnim, livingEntityPatch) || 
/* 171 */       CombatCommon.canEscape((MobPatch)livingEntityPatch)) {
/* 172 */       recoverItemDueToFailure(entity);
/*     */       
/*     */       return;
/*     */     } 
/* 176 */     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity;
/* 177 */       livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_DRINK, 0.0F); }
/*     */ 
/*     */     
/* 180 */     if (levelaccessor instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)levelaccessor;
/* 181 */       serverLevel.m_5594_(null, entity
/* 182 */           .m_20183_(), SoundEvents.f_11911_, SoundSource.NEUTRAL, 1.0F, 1.0F); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void eatingGoldenApple(final Entity entity, final LevelAccessor levelaccessor, double amount, final boolean isEnchanted) {
/* 190 */     final LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/*     */     
/* 192 */     if (livingEntityPatch != null && entity instanceof LivingEntity) { final LivingEntity livingEntity = (LivingEntity)entity;
/* 193 */       if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity; if (playerNpcEntity.isHealing())
/*     */           return;  }
/*     */       
/* 196 */       if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity; if (AVNpc.isHealing())
/*     */           return;  }
/*     */       
/* 199 */       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)(amount * 2.0D), 2, false, false));
/*     */ 
/*     */       
/* 202 */       if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 203 */         if (playerNpcEntity.isHealing()) {
/*     */           return;
/*     */         }
/* 206 */         playerNpcEntity.setHealing(true); }
/*     */ 
/*     */       
/* 209 */       if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 210 */         if (AVNpc.isHealing()) {
/*     */           return;
/*     */         }
/* 213 */         AVNpc.setHealing(true); }
/*     */ 
/*     */       
/* 216 */       new DelayedTask(20)
/*     */         {
/*     */           public void run() {
/* 219 */             if (!entity.m_6084_())
/*     */               return; 
/* 221 */             LivingEntityPatch<?> patch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 222 */             if (patch == null)
/* 223 */               return;  AssetAccessor<? extends StaticAnimation> currentAnim = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 224 */             if (currentAnim.get() instanceof yesman.epicfight.api.animation.types.AttackAnimation || 
/* 225 */               EpicfightUtil.isLongHitAnimation(currentAnim, patch) || 
/* 226 */               CombatCommon.canEscape((MobPatch)livingEntityPatch)) {
/* 227 */               CombatBehaviour.recoverItemDueToFailure(entity);
/*     */               return;
/*     */             } 
/* 230 */             final Runnable bite = () -> CombatBehaviour.performEatingGoldenAppleActionMainHand(entity, levelaccessor, patch);
/* 231 */             int biteDelay = 4;
/* 232 */             int totalBites = 7;
/*     */             
/* 234 */             for (int i = 0; i < totalBites; i++) {
/* 235 */               int delay = 4 + i * biteDelay;
/* 236 */               new DelayedTask(delay)
/*     */                 {
/*     */                   public void run() {
/* 239 */                     if (entity.m_6084_()) {
/* 240 */                       bite.run();
/*     */                     }
/*     */                   }
/*     */                 };
/*     */             } 
/*     */             
/* 246 */             new DelayedTask(4 + totalBites * biteDelay - 1)
/*     */               {
/*     */                 public void run() {
/* 249 */                   if (!entity.m_6084_())
/* 250 */                     return;  if (levelaccessor instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)levelaccessor;
/* 251 */                     serverLevel.m_5594_(null, entity
/* 252 */                         .m_20183_(), SoundEvents.f_12321_, SoundSource.NEUTRAL, 1.5F, 1.0F); }
/*     */                 
/*     */                 }
/*     */               };
/*     */ 
/*     */ 
/*     */             
/* 259 */             new DelayedTask(4 + totalBites * biteDelay)
/*     */               {
/*     */                 public void run() {
/* 262 */                   if (!entity.m_6084_())
/*     */                     return; 
/* 264 */                   LivingEntityPatch<?> livingEntityPatch1 = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 265 */                   if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && livingEntityPatch1 != null) {
/* 266 */                     livingEntityPatch1.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F);
/*     */                   }
/*     */                   
/* 269 */                   if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 270 */                     livingEntity.m_21008_(InteractionHand.MAIN_HAND, playerNpcEntity.getMainWeaponItem()); }
/*     */                   
/* 272 */                   if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity; if (livingEntityPatch1 != null) {
/* 273 */                       if (AVNpc instanceof com.pla.annoyingvillagers.entity.SteveEntity && CombatCommon.canSwitchWeapon((MobPatch)livingEntityPatch1)) {
/* 274 */                         CombatCommon.switchWeapon((MobPatch)livingEntityPatch1);
/*     */                       } else {
/* 276 */                         livingEntity.m_21008_(InteractionHand.MAIN_HAND, AVNpc.getMainWeaponItem());
/*     */                       } 
/*     */                     } }
/*     */                   
/* 280 */                   if (!livingEntity.m_9236_().m_5776_()) {
/* 281 */                     if (isEnchanted) {
/* 282 */                       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19617_, 2400, 3));
/* 283 */                       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 400, 1));
/* 284 */                       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 6000, 0));
/* 285 */                       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19607_, 6000, 0));
/*     */                     } else {
/* 287 */                       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19617_, 2400, 0));
/* 288 */                       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 100, 1));
/*     */                     } 
/*     */                   }
/*     */                   
/* 292 */                   if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 293 */                     playerNpcEntity.setHealing(false); }
/*     */                   
/* 295 */                   if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 296 */                     AVNpc.setHealing(false); }
/*     */                 
/*     */                 }
/*     */               };
/*     */           }
/*     */         }; }
/*     */   
/*     */   }
/*     */   
/*     */   public static void drinkingHealingPotion(final Entity entity, final LevelAccessor levelaccessor, final boolean isHostile, double amount) {
/* 306 */     final LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/*     */     
/* 308 */     if (livingEntityPatch != null && entity instanceof LivingEntity) { final LivingEntity livingEntity = (LivingEntity)entity;
/* 309 */       if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity; if (playerNpcEntity.isHealing())
/*     */           return;  }
/*     */       
/* 312 */       if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity; if (AVNpc.isHealing())
/*     */           return;  }
/*     */       
/* 315 */       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (int)(amount * 2.0D), 2, false, false));
/*     */ 
/*     */       
/* 318 */       if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 319 */         if (playerNpcEntity.isHealing()) {
/*     */           return;
/*     */         }
/* 322 */         playerNpcEntity.setHealing(true); }
/*     */ 
/*     */       
/* 325 */       if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 326 */         if (AVNpc.isHealing()) {
/*     */           return;
/*     */         }
/* 329 */         AVNpc.setHealing(true); }
/*     */ 
/*     */       
/* 332 */       new DelayedTask(20)
/*     */         {
/*     */           public void run() {
/* 335 */             if (!entity.m_6084_())
/*     */               return; 
/* 337 */             LivingEntityPatch<?> patch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 338 */             if (patch == null)
/* 339 */               return;  AssetAccessor<? extends StaticAnimation> currentAnim = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 340 */             if (currentAnim.get() instanceof yesman.epicfight.api.animation.types.AttackAnimation || 
/* 341 */               EpicfightUtil.isLongHitAnimation(currentAnim, patch) || 
/* 342 */               CombatCommon.canEscape((MobPatch)livingEntityPatch)) {
/* 343 */               CombatBehaviour.recoverItemDueToFailure(entity);
/*     */               return;
/*     */             } 
/* 346 */             final Runnable bite = () -> CombatBehaviour.performDrinkingHealingPotionActionMainhand(entity, levelaccessor, patch);
/* 347 */             int biteDelay = 4;
/* 348 */             int totalBites = 7;
/*     */             
/* 350 */             for (int i = 0; i < totalBites; i++) {
/* 351 */               int delay = 4 + i * biteDelay;
/* 352 */               new DelayedTask(delay)
/*     */                 {
/*     */                   public void run() {
/* 355 */                     if (entity.m_6084_()) {
/* 356 */                       bite.run();
/*     */                     }
/*     */                   }
/*     */                 };
/*     */             } 
/*     */             
/* 362 */             new DelayedTask(4 + totalBites * biteDelay - 1)
/*     */               {
/*     */                 public void run() {
/* 365 */                   if (!entity.m_6084_())
/* 366 */                     return;  if (levelaccessor instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)levelaccessor;
/* 367 */                     serverLevel.m_5594_(null, entity
/* 368 */                         .m_20183_(), SoundEvents.f_12321_, SoundSource.NEUTRAL, 1.5F, 1.0F); }
/*     */                 
/*     */                 }
/*     */               };
/*     */ 
/*     */ 
/*     */             
/* 375 */             new DelayedTask(4 + totalBites * biteDelay)
/*     */               {
/*     */                 public void run() {
/* 378 */                   if (!entity.m_6084_())
/*     */                     return; 
/* 380 */                   LivingEntityPatch<?> livingEntityPatch1 = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 381 */                   if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && livingEntityPatch1 != null) {
/* 382 */                     livingEntityPatch1.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F);
/*     */                   }
/*     */                   
/* 385 */                   if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 386 */                     livingEntity.m_21008_(InteractionHand.MAIN_HAND, playerNpcEntity.getMainWeaponItem()); }
/*     */                   
/* 388 */                   if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity; if (livingEntityPatch1 != null) {
/* 389 */                       if (AVNpc instanceof com.pla.annoyingvillagers.entity.SteveEntity && CombatCommon.canSwitchWeapon((MobPatch)livingEntityPatch1)) {
/* 390 */                         CombatCommon.switchWeapon((MobPatch)livingEntityPatch1);
/*     */                       } else {
/* 392 */                         livingEntity.m_21008_(InteractionHand.MAIN_HAND, AVNpc.getMainWeaponItem());
/*     */                       } 
/*     */                     } }
/*     */                   
/* 396 */                   if (!livingEntity.m_9236_().m_5776_()) {
/* 397 */                     if (isHostile) {
/* 398 */                       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19602_, 40, 0));
/*     */                     } else {
/* 400 */                       livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 200, 1));
/*     */                     } 
/*     */                   }
/*     */                   
/* 404 */                   if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 405 */                     playerNpcEntity.setHealing(false); }
/*     */                   
/* 407 */                   if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 408 */                     AVNpc.setHealing(false); }
/*     */                 
/*     */                 }
/*     */               };
/*     */           }
/*     */         }; }
/*     */   
/*     */   }
/*     */   
/*     */   public static void forceLookAt(Entity self, Entity target, float maxYawChange, float maxPitchChange) {
/* 418 */     if (target == null)
/*     */       return; 
/* 420 */     Vec3 eye = self.m_146892_();
/* 421 */     Vec3 to = target.m_146892_().m_82546_(eye);
/*     */     
/* 423 */     double dx = to.f_82479_;
/* 424 */     double dy = to.f_82480_;
/* 425 */     double dz = to.f_82481_;
/*     */     
/* 427 */     double flat = Math.sqrt(dx * dx + dz * dz);
/* 428 */     float targetYaw = (float)(Mth.m_14136_(dz, dx) * 57.29577951308232D) - 90.0F;
/* 429 */     float targetPitch = (float)-(Mth.m_14136_(dy, flat) * 57.29577951308232D);
/*     */     
/* 431 */     float yaw = Mth.m_14148_(self.m_146908_(), targetYaw, maxYawChange);
/* 432 */     float pitch = Mth.m_14036_(Mth.m_14148_(self.m_146909_(), targetPitch, maxPitchChange), -90.0F, 90.0F);
/*     */     
/* 434 */     self.m_146922_(yaw);
/* 435 */     self.m_146926_(pitch);
/* 436 */     self.f_19859_ = yaw;
/* 437 */     self.f_19860_ = pitch;
/*     */     
/* 439 */     if (self instanceof Mob) { Mob mob = (Mob)self;
/* 440 */       mob.f_20883_ = yaw;
/* 441 */       mob.f_20884_ = yaw;
/* 442 */       mob.f_20885_ = yaw;
/* 443 */       mob.f_20886_ = yaw; }
/*     */   
/*     */   }
/*     */   public static double calculateGuardBreakWakeUpChance(LivingEntity entity) {
/*     */     double chance;
/* 448 */     float hpPct = entity.m_21223_() / entity.m_21233_();
/*     */     
/* 450 */     double min = ((Double)AnnoyingVillagersConfig.MOB_GUARD_BREAK_WAKE_UP_MIN_CHANCE.get()).doubleValue();
/* 451 */     double max = ((Double)AnnoyingVillagersConfig.MOB_GUARD_BREAK_WAKE_UP_MAX_CHANCE.get()).doubleValue();
/*     */     
/* 453 */     if (max < min) {
/* 454 */       double tmp = max;
/* 455 */       max = min;
/* 456 */       min = tmp;
/*     */     } 
/*     */ 
/*     */     
/* 460 */     if (max == min) {
/* 461 */       chance = max;
/*     */     } else {
/* 463 */       double t = (1.0D - hpPct) / 0.5D;
/* 464 */       t = Mth.m_14008_(t, 0.0D, 1.0D);
/* 465 */       chance = max - t * (max - min);
/*     */     } 
/*     */     
/* 468 */     return chance;
/*     */   }
/*     */   
/*     */   public static void postGuardBreakWakeUp(LivingEntity entity, LivingEntityPatch<?> livingEntityPatch, ServerLevel serverLevel) {
/* 472 */     serverLevel.m_8767_((ParticleOptions)EpicFightParticles.WHITE_AFTERIMAGE
/* 473 */         .get(), entity
/* 474 */         .m_20185_(), entity.m_20186_(), entity.m_20189_(), 1, 0.0D, 0.0D, 0.0D, 
/* 475 */         Double.longBitsToDouble(entity.m_19879_()));
/*     */     
/* 477 */     entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 60, 1, false, false));
/* 478 */     entity.m_7292_(new MobEffectInstance(MobEffects.f_19599_, 60, 1, false, false));
/* 479 */     entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 1, false, false));
/*     */     
/* 481 */     double chooseAnimation = (new Random()).nextDouble(0.0D, 1.0D);
/* 482 */     if (chooseAnimation <= 0.4D) {
/* 483 */       livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_KNOCKDOWN_WAKEUP_LEFT, 0.0F);
/* 484 */     } else if (chooseAnimation <= 0.8D) {
/* 485 */       livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_KNOCKDOWN_WAKEUP_RIGHT, 0.0F);
/*     */     } else {
/* 487 */       livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_ROLL_BACKWARD, 0.0F);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\CombatBehaviour.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */