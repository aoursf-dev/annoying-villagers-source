/*      */ package com.pla.annoyingvillagers.entity;
/*      */ import com.pla.annoyingvillagers.clazz.BbqCombatMode;
/*      */ import com.pla.annoyingvillagers.clazz.BurstProtectEntity;
/*      */ import com.pla.annoyingvillagers.clazz.CombatVoiceLineEntity;
/*      */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*      */ import com.pla.annoyingvillagers.clazz.SauceType;
/*      */ import com.pla.annoyingvillagers.combatbehaviour.CombatCommon;
/*      */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*      */ import com.pla.annoyingvillagers.entity.goal.KeepPositionGoal;
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*      */ import com.pla.annoyingvillagers.item.BlueDemonChestplateItem;
/*      */ import com.pla.annoyingvillagers.item.BlueDemonTridentItem;
/*      */ import com.pla.annoyingvillagers.spawnhandler.BluedemonData;
/*      */ import com.pla.annoyingvillagers.task.DelayedTask;
/*      */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*      */ import com.pla.annoyingvillagers.util.CommonGoals;
/*      */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*      */ import com.pla.annoyingvillagers.util.TeamUtil;
/*      */ import java.util.List;
/*      */ import java.util.Objects;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import javax.annotation.Nullable;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.core.particles.ParticleOptions;
/*      */ import net.minecraft.nbt.CompoundTag;
/*      */ import net.minecraft.network.chat.Component;
/*      */ import net.minecraft.network.syncher.EntityDataSerializers;
/*      */ import net.minecraft.network.syncher.SynchedEntityData;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.sounds.SoundEvent;
/*      */ import net.minecraft.sounds.SoundEvents;
/*      */ import net.minecraft.sounds.SoundSource;
/*      */ import net.minecraft.util.Mth;
/*      */ import net.minecraft.util.RandomSource;
/*      */ import net.minecraft.world.DifficultyInstance;
/*      */ import net.minecraft.world.InteractionHand;
/*      */ import net.minecraft.world.damagesource.DamageSource;
/*      */ import net.minecraft.world.damagesource.DamageTypes;
/*      */ import net.minecraft.world.effect.MobEffectCategory;
/*      */ import net.minecraft.world.effect.MobEffectInstance;
/*      */ import net.minecraft.world.effect.MobEffects;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.entity.EntityType;
/*      */ import net.minecraft.world.entity.EquipmentSlot;
/*      */ import net.minecraft.world.entity.LightningBolt;
/*      */ import net.minecraft.world.entity.LivingEntity;
/*      */ import net.minecraft.world.entity.Mob;
/*      */ import net.minecraft.world.entity.MobSpawnType;
/*      */ import net.minecraft.world.entity.MoverType;
/*      */ import net.minecraft.world.entity.SpawnGroupData;
/*      */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*      */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*      */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*      */ import net.minecraft.world.entity.ai.goal.Goal;
/*      */ import net.minecraft.world.entity.monster.Monster;
/*      */ import net.minecraft.world.entity.player.Player;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.item.enchantment.Enchantments;
/*      */ import net.minecraft.world.level.ItemLike;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.level.LevelAccessor;
/*      */ import net.minecraft.world.level.ServerLevelAccessor;
/*      */ import net.minecraft.world.level.gameevent.GameEvent;
/*      */ import net.minecraft.world.level.levelgen.Heightmap;
/*      */ import net.minecraft.world.phys.AABB;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import net.minecraftforge.common.ForgeHooks;
/*      */ import net.minecraftforge.network.PlayMessages;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ import yesman.epicfight.api.animation.AnimationPlayer;
/*      */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*      */ import yesman.epicfight.api.asset.AssetAccessor;
/*      */ import yesman.epicfight.particle.EpicFightParticles;
/*      */ import yesman.epicfight.particle.HitParticleType;
/*      */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*      */ 
/*      */ public class BlueDemonEntity extends Monster implements BurstProtectEntity, CombatVoiceLineEntity {
/*      */   @Nullable
/*      */   private BbqEntity bbqSauce;
/*      */   @Nullable
/*      */   private UUID bbqSauceUUID;
/*      */   @Nullable
/*      */   private BbqEntity honeyMustardSauce;
/*      */   @Nullable
/*      */   private UUID honeyMustardSauceUUID;
/*      */   @Nullable
/*      */   private BbqEntity soySauce;
/*      */   @Nullable
/*      */   private UUID soySauceUUID;
/*   99 */   private int healingTick = 0; @Nullable private BbqEntity sweetOnionSauce; @Nullable
/*  100 */   private UUID sweetOnionSauceUUID; private int bbqResolveCooldown; private int bbqOrderCooldown; private int bbqHeadAttackCooldown; private int bbqModeCooldown; private int healingCooldown = 0;
/*  101 */   private int stunEscapeCooldown = 0;
/*  102 */   private Entity blockDamage = null;
/*      */   private int swapWeaponCooldown;
/*  104 */   private int efnGuardHitState = 0;
/*  105 */   private int efnGuardHitCooldown = 0;
/*      */   
/*  107 */   private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.m_135353_(BlueDemonEntity.class, EntityDataSerializers.f_135028_);
/*  108 */   private int stateTransformCooldown = -1;
/*      */   
/*      */   @Nullable
/*      */   private UUID savedTargetUUID;
/*  112 */   private int squadArrivalTicks = -1;
/*  113 */   private float sauceSquadAngle = 0.0F;
/*      */   private boolean spawnedBbqSauce = false;
/*  115 */   private int dieTick = -1;
/*      */   @Nullable
/*      */   private UUID savedKillerUUID;
/*      */   private boolean neverLeave = false;
/*  119 */   private int leaveTicks = 0;
/*  120 */   private Vec3 leaveDirection = Vec3.f_82478_;
/*  121 */   private int voiceCooldown = 0;
/*      */ 
/*      */   
/*      */   public int getVoiceCooldown() {
/*  125 */     return this.voiceCooldown;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setVoiceCooldown(int cooldown) {
/*  130 */     this.voiceCooldown = cooldown;
/*      */   }
/*      */   
/*  133 */   protected float recentDamageTaken = 0.0F;
/*  134 */   protected int recentHitCounter = 0;
/*      */   
/*      */   public float getRecentDamageTaken() {
/*  137 */     return this.recentDamageTaken;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRecentDamageTaken(float value) {
/*  142 */     this.recentDamageTaken = value;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getRecentHitCounter() {
/*  147 */     return this.recentHitCounter;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRecentHitCounter(int value) {
/*  152 */     this.recentHitCounter = value;
/*      */   }
/*      */   
/*      */   public void setLeaveTicks(int leaveTicks) {
/*  156 */     this.leaveTicks = leaveTicks;
/*      */   }
/*      */   
/*      */   public int getLeaveTicks() {
/*  160 */     return this.leaveTicks;
/*      */   }
/*      */   
/*      */   public void setNeverLeave(boolean neverLeave) {
/*  164 */     this.neverLeave = neverLeave;
/*      */   }
/*      */   
/*      */   public void setStateTransformCooldown(int stateTransformCooldown) {
/*  168 */     this.stateTransformCooldown = stateTransformCooldown;
/*      */     
/*  170 */     if (stateTransformCooldown > 0) {
/*  171 */       this.sauceSquadAngle = this.f_19796_.m_188501_() * 6.2831855F;
/*      */     }
/*      */   }
/*      */   
/*      */   private double getSauceLaneOffset(SauceType sauceType) {
/*  176 */     switch (sauceType) { default: throw new IncompatibleClassChangeError();case PARALLEL: case GROUND_ORBIT: case ORBIT: case null: break; }  return 
/*      */ 
/*      */ 
/*      */       
/*  180 */       2.25D;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getSauceSquadAngle() {
/*  185 */     return this.sauceSquadAngle;
/*      */   }
/*      */   
/*      */   public int getEfnGuardHitState() {
/*  189 */     return this.efnGuardHitState;
/*      */   }
/*      */   
/*      */   public void postPlayEfnGuardHit() {
/*  193 */     if (this.efnGuardHitState == 2) {
/*  194 */       this.efnGuardHitState = 0;
/*      */     } else {
/*  196 */       this.efnGuardHitState++;
/*      */     } 
/*  198 */     this.efnGuardHitCooldown = 100;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void m_8097_() {
/*  203 */     super.m_8097_();
/*  204 */     this.f_19804_.m_135372_(STATE, Integer.valueOf(0));
/*      */   }
/*      */   
/*      */   public int getStunEscapeCooldown() {
/*  208 */     return this.stunEscapeCooldown;
/*      */   }
/*      */   
/*      */   public void setStunEscapeCooldown(int stunEscapeCooldown) {
/*  212 */     this.stunEscapeCooldown = stunEscapeCooldown;
/*      */   }
/*      */   
/*      */   public void setBlockDamage(Entity blockDamage) {
/*  216 */     this.blockDamage = blockDamage;
/*      */   }
/*      */   
/*      */   public Entity getBlockDamage() {
/*  220 */     return this.blockDamage;
/*      */   }
/*      */   
/*      */   public int getSwapWeaponCooldown() {
/*  224 */     return this.swapWeaponCooldown;
/*      */   }
/*      */   
/*      */   public void setSwapWeaponCooldown(int swapWeaponCooldown) {
/*  228 */     this.swapWeaponCooldown = swapWeaponCooldown;
/*      */   }
/*      */   
/*      */   public int getHealingTick() {
/*  232 */     return this.healingTick;
/*      */   }
/*      */   
/*      */   public void setHealingTick(int healingTick) {
/*  236 */     this.healingTick = healingTick;
/*      */   }
/*      */   
/*      */   public void setHealingCooldown() {
/*  240 */     this.healingCooldown = this.f_19796_.m_216339_(900, 1500);
/*      */   }
/*      */   
/*      */   public int getHealingCooldown() {
/*  244 */     return this.healingCooldown;
/*      */   }
/*      */   
/*      */   public boolean isSauceArrivalPending() {
/*  248 */     return (this.squadArrivalTicks > 0);
/*      */   }
/*      */   
/*      */   private void backupCurrentTarget() {
/*  252 */     LivingEntity target = m_5448_();
/*  253 */     this.savedTargetUUID = (target != null && target.m_6084_()) ? target.m_20148_() : null;
/*      */   }
/*      */   
/*      */   private void restoreBackedUpTarget() {
/*  257 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (this.savedTargetUUID != null) {
/*      */ 
/*      */ 
/*      */         
/*  261 */         Entity entity = serverLevel.m_8791_(this.savedTargetUUID);
/*  262 */         if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_()) {
/*  263 */             m_6710_(living);
/*      */           } }
/*      */         
/*  266 */         this.savedTargetUUID = null;
/*      */         return;
/*      */       }  }
/*      */      } private boolean isLeavingNow() {
/*  270 */     return (!this.neverLeave && this.leaveTicks > 0 && this.leaveTicks <= 40);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void updateLeaveDirectionFromThreat() {
/*  276 */     LivingEntity target = m_5448_();
/*  277 */     if (target != null && target.m_6084_()) {
/*  278 */       away = m_20182_().m_82546_(target.m_20182_());
/*  279 */     } else if (m_21188_() != null && m_21188_().m_6084_()) {
/*  280 */       away = m_20182_().m_82546_(m_21188_().m_20182_());
/*      */     } else {
/*  282 */       away = new Vec3(-(m_20154_()).f_82479_, 0.0D, -(m_20154_()).f_82481_);
/*      */     } 
/*      */     
/*  285 */     Vec3 away = new Vec3(away.f_82479_, 0.0D, away.f_82481_);
/*  286 */     if (away.m_82556_() < 1.0E-4D) {
/*  287 */       away = new Vec3(this.f_19796_.m_188500_() - 0.5D, 0.0D, this.f_19796_.m_188500_() - 0.5D);
/*      */     }
/*      */     
/*  290 */     this.leaveDirection = away.m_82541_();
/*      */   }
/*      */   
/*      */   private void tickLeaveRetreat() {
/*  294 */     if (this.leaveDirection.m_82556_() < 1.0E-4D) {
/*  295 */       updateLeaveDirectionFromThreat();
/*      */     }
/*      */     
/*  298 */     m_6710_((LivingEntity)null);
/*      */     
/*  300 */     double x = m_20185_() + this.leaveDirection.f_82479_ * 12.0D;
/*  301 */     double z = m_20189_() + this.leaveDirection.f_82481_ * 12.0D;
/*      */     
/*  303 */     m_21573_().m_26519_(x, m_20186_(), z, 1.45D);
/*  304 */     m_21563_().m_24946_(x, m_20188_(), z);
/*      */   }
/*      */   
/*      */   private void discardAllSauces(ServerLevel serverLevel) {
/*  308 */     BbqEntity bbq = resolveAliveSauce(serverLevel, SauceType.BBQ_SAUCE);
/*  309 */     BbqEntity honey = resolveAliveSauce(serverLevel, SauceType.HONEY_MUSTARD_SAUCE);
/*  310 */     BbqEntity soy = resolveAliveSauce(serverLevel, SauceType.SOY_SAUCE);
/*  311 */     BbqEntity sweet = resolveAliveSauce(serverLevel, SauceType.SWEET_ONION_SAUCE);
/*      */     
/*  313 */     if (bbq != null) bbq.m_146870_(); 
/*  314 */     if (honey != null) honey.m_146870_(); 
/*  315 */     if (soy != null) soy.m_146870_(); 
/*  316 */     if (sweet != null) sweet.m_146870_();
/*      */     
/*  318 */     setSauce(SauceType.BBQ_SAUCE, (BbqEntity)null);
/*  319 */     setSauce(SauceType.HONEY_MUSTARD_SAUCE, (BbqEntity)null);
/*  320 */     setSauce(SauceType.SOY_SAUCE, (BbqEntity)null);
/*  321 */     setSauce(SauceType.SWEET_ONION_SAUCE, (BbqEntity)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_6710_(@Nullable LivingEntity pTarget) {
/*  326 */     if (isLeavingNow()) {
/*  327 */       super.m_6710_(null);
/*      */       return;
/*      */     } 
/*  330 */     super.m_6710_(pTarget);
/*      */   }
/*      */   
/*      */   private void startSauceRetreat(SauceType sauceType) {
/*  334 */     BbqEntity sauce = getSauce(sauceType);
/*  335 */     if (sauce != null && sauce.m_6084_()) {
/*  336 */       sauce.startRetreat();
/*      */     }
/*      */     
/*  339 */     setSauce(sauceType, (BbqEntity)null);
/*      */   }
/*      */   
/*      */   private void retreatAllSauces() {
/*  343 */     startSauceRetreat(SauceType.BBQ_SAUCE);
/*  344 */     startSauceRetreat(SauceType.HONEY_MUSTARD_SAUCE);
/*  345 */     startSauceRetreat(SauceType.SOY_SAUCE);
/*  346 */     startSauceRetreat(SauceType.SWEET_ONION_SAUCE);
/*      */   }
/*      */   
/*      */   public void beginStateTwoTransform() {
/*  350 */     backupCurrentTarget();
/*  351 */     retreatAllSauces();
/*      */     
/*  353 */     m_21557_(true);
/*  354 */     setHealingTick(0);
/*  355 */     setState(2);
/*  356 */     setStateTransformCooldown(600);
/*      */   }
/*      */   
/*      */   private void finishStateTwoTransform(ServerLevel serverLevel) {
/*  360 */     setHealingTick(-1);
/*  361 */     m_21557_(false);
/*  362 */     setState(3);
/*  363 */     restoreBackedUpTarget();
/*      */     
/*  365 */     this.squadArrivalTicks = 400;
/*      */     
/*  367 */     ItemStack armorStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_CHESTPLATE.get());
/*  368 */     armorStack.m_41663_(Enchantments.f_44965_, 5);
/*  369 */     armorStack.m_41663_(Enchantments.f_44969_, 5);
/*  370 */     armorStack.m_41663_(Enchantments.f_44966_, 5);
/*  371 */     armorStack.m_41663_(Enchantments.f_44968_, 5);
/*  372 */     m_8061_(EquipmentSlot.CHEST, armorStack);
/*      */     
/*  374 */     setSwapWeaponCooldown((new Random()).nextInt(200, 600));
/*      */     
/*  376 */     ensureStateSauces();
/*  377 */     serverLevel.m_7654_().m_6846_().m_240416_(
/*  378 */         (Component)Component.m_237113_("<" + Component.m_237115_(SauceType.BBQ_SAUCE.getTranslationKey()).getString() + "> " + Component.m_237115_("subtitles.bbq_sauce_squad_arrived").getString()), false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void tickSquadArrival(ServerLevel serverLevel) {
/*  384 */     if (this.squadArrivalTicks <= 0) {
/*      */       return;
/*      */     }
/*      */     
/*  388 */     this.squadArrivalTicks--;
/*  389 */     if (this.squadArrivalTicks > 0) {
/*      */       return;
/*      */     }
/*      */     
/*  393 */     BbqEntity bbq = getSauce(SauceType.BBQ_SAUCE);
/*  394 */     BbqEntity honey = getSauce(SauceType.HONEY_MUSTARD_SAUCE);
/*  395 */     BbqEntity soy = getSauce(SauceType.SOY_SAUCE);
/*  396 */     BbqEntity onion = getSauce(SauceType.SWEET_ONION_SAUCE);
/*      */     
/*  398 */     if (bbq != null) bbq.teleportNearLeaderIfTooFar(); 
/*  399 */     if (honey != null) honey.teleportNearLeaderIfTooFar(); 
/*  400 */     if (soy != null) soy.teleportNearLeaderIfTooFar(); 
/*  401 */     if (onion != null) onion.teleportNearLeaderIfTooFar(); 
/*      */   }
/*      */   
/*      */   public int getState() {
/*  405 */     return ((Integer)this.f_19804_.m_135370_(STATE)).intValue();
/*      */   }
/*      */   
/*      */   public void setState(int state) {
/*  409 */     this.f_19804_.m_135381_(STATE, Integer.valueOf(state));
/*      */   }
/*      */   @Nullable
/*      */   private BbqEntity getSauce(SauceType sauceType) {
/*  413 */     switch (sauceType) { default: throw new IncompatibleClassChangeError();case PARALLEL: case GROUND_ORBIT: case ORBIT: case null: break; }  return 
/*      */ 
/*      */ 
/*      */       
/*  417 */       this.sweetOnionSauce;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   private UUID getSauceUUID(SauceType sauceType) {
/*  422 */     switch (sauceType) { default: throw new IncompatibleClassChangeError();case PARALLEL: case GROUND_ORBIT: case ORBIT: case null: break; }  return 
/*      */ 
/*      */ 
/*      */       
/*  426 */       this.sweetOnionSauceUUID;
/*      */   }
/*      */ 
/*      */   
/*      */   private void setSauce(SauceType sauceType, @Nullable BbqEntity sauce) {
/*  431 */     UUID uuid = (sauce == null) ? null : sauce.m_20148_();
/*      */     
/*  433 */     switch (sauceType) {
/*      */       case PARALLEL:
/*  435 */         this.bbqSauce = sauce;
/*  436 */         this.bbqSauceUUID = uuid;
/*      */         break;
/*      */       case GROUND_ORBIT:
/*  439 */         this.honeyMustardSauce = sauce;
/*  440 */         this.honeyMustardSauceUUID = uuid;
/*      */         break;
/*      */       case ORBIT:
/*  443 */         this.soySauce = sauce;
/*  444 */         this.soySauceUUID = uuid;
/*      */         break;
/*      */       case null:
/*  447 */         this.sweetOnionSauce = sauce;
/*  448 */         this.sweetOnionSauceUUID = uuid;
/*      */         break;
/*      */     } 
/*      */   } private void ensureSauceExists(SauceType sauceType) {
/*      */     ServerLevel serverLevel;
/*      */     double spawnX, spawnZ;
/*  454 */     BbqEntity current = getSauce(sauceType);
/*  455 */     if (current != null && current.m_6084_()) {
/*      */       return;
/*      */     }
/*      */     
/*  459 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*      */     else
/*      */     { return; }
/*      */     
/*  463 */     UUID uuid = getSauceUUID(sauceType);
/*  464 */     if (uuid != null) {
/*  465 */       Entity entity = serverLevel.m_8791_(uuid);
/*  466 */       if (entity instanceof BbqEntity) { BbqEntity bbqEntity = (BbqEntity)entity; if (bbqEntity.m_6084_()) {
/*  467 */           setSauce(sauceType, bbqEntity);
/*      */           return;
/*      */         }  }
/*      */     
/*      */     } 
/*  472 */     BbqEntity sauce = new BbqEntity((EntityType<? extends BbqEntity>)AnnoyingVillagersModEntities.BBQ.get(), (Level)serverLevel);
/*      */     
/*  474 */     switch (sauceType) { default: throw new IncompatibleClassChangeError();
/*      */       case PARALLEL: 
/*      */       case GROUND_ORBIT: 
/*      */       case ORBIT: 
/*  478 */       case null: break; }  double baseAngle = 4.71238898038469D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  484 */     if (getState() == 3) {
/*  485 */       float angle = getSauceSquadAngle();
/*  486 */       double distance = 18.0D + this.f_19796_.m_188500_() * 4.0D;
/*  487 */       double laneOffset = getSauceLaneOffset(sauceType);
/*      */       
/*  489 */       double forwardX = Mth.m_14089_(angle);
/*  490 */       double forwardZ = Mth.m_14031_(angle);
/*  491 */       double sideX = -forwardZ;
/*  492 */       double sideZ = forwardX;
/*      */       
/*  494 */       spawnX = m_20185_() + forwardX * distance + sideX * laneOffset;
/*  495 */       spawnZ = m_20189_() + forwardZ * distance + sideZ * laneOffset;
/*      */     } else {
/*  497 */       double angle = this.f_19796_.m_188500_() * 6.283185307179586D;
/*  498 */       double radius = 2.5D + this.f_19796_.m_188500_() * 1.5D;
/*  499 */       spawnX = m_20185_() + Math.cos(angle) * radius;
/*  500 */       spawnZ = m_20189_() + Math.sin(angle) * radius;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  506 */     int spawnY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlockPos.m_274561_(spawnX, m_20186_(), spawnZ)).m_123342_();
/*      */     
/*  508 */     sauce.m_7678_(spawnX, spawnY, spawnZ, this.f_19796_.m_188501_() * 360.0F, 0.0F);
/*  509 */     sauce.setLeader(this);
/*  510 */     sauce.setSauceType(sauceType);
/*  511 */     sauce.m_6518_((ServerLevelAccessor)serverLevel, serverLevel
/*      */         
/*  513 */         .m_6436_(sauce.m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  519 */     serverLevel.m_7967_((Entity)sauce);
/*  520 */     setSauce(sauceType, sauce);
/*      */   }
/*      */   
/*      */   private void ensureStateSauces() {
/*  524 */     if (getState() == 0 || getState() == 1) {
/*  525 */       ensureSauceExists(SauceType.BBQ_SAUCE);
/*      */       
/*      */       return;
/*      */     } 
/*  529 */     if (getState() == 3) {
/*  530 */       ensureSauceExists(SauceType.BBQ_SAUCE);
/*  531 */       ensureSauceExists(SauceType.HONEY_MUSTARD_SAUCE);
/*  532 */       ensureSauceExists(SauceType.SOY_SAUCE);
/*  533 */       ensureSauceExists(SauceType.SWEET_ONION_SAUCE);
/*      */     } 
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   private LivingEntity resolveSauceTarget(@Nullable LivingEntity target) {
/*  539 */     if (target == null || !target.m_6084_()) {
/*  540 */       return null;
/*      */     }
/*      */     
/*  543 */     if (target instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)target; if (herobrineMob
/*  544 */         .isSacrificing() || herobrineMob.isHealing()) {
/*  545 */         Entity entity = herobrineMob.getFirstPossessedHerobrine(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_())
/*  546 */             return living;  }
/*      */         
/*  548 */         entity = herobrineMob.getSecondPossessedHerobrine(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_())
/*  549 */             return living;  }
/*      */         
/*  551 */         entity = herobrineMob.getThirdPossessedHerobrine(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_())
/*  552 */             return living;  }
/*      */         
/*  554 */         entity = herobrineMob.getFourthPossessedHerobrine(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_())
/*  555 */             return living;  }
/*      */       
/*      */       }  }
/*      */     
/*  559 */     if (target instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)target; if (lowHerobrineCloneEntity
/*  560 */         .isHealing() && lowHerobrineCloneEntity
/*  561 */         .getPossessedByEntity() != null && lowHerobrineCloneEntity
/*  562 */         .getPossessedByEntity().m_6084_()) {
/*  563 */         return (LivingEntity)lowHerobrineCloneEntity.getPossessedByEntity();
/*      */       } }
/*      */     
/*  566 */     if (target instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)target; if ((lowShadowHerobrineCloneEntity
/*  567 */         .isSacrificing() || lowShadowHerobrineCloneEntity.isHealing()) && lowShadowHerobrineCloneEntity
/*  568 */         .getPossessedByEntity() != null && lowShadowHerobrineCloneEntity
/*  569 */         .getPossessedByEntity().m_6084_()) {
/*  570 */         return (LivingEntity)lowShadowHerobrineCloneEntity.getPossessedByEntity();
/*      */       } }
/*      */     
/*  573 */     return target;
/*      */   } @Nullable
/*      */   public BlueDemonThrownTridentEntity getNearestGroundedOwnedTrident(double radius) {
/*      */     ServerLevel serverLevel;
/*  577 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*  578 */     else { return null; }
/*      */ 
/*      */     
/*  581 */     AABB box = m_20191_().m_82400_(radius);
/*      */     
/*  583 */     List<BlueDemonThrownTridentEntity> tridents = serverLevel.m_6443_(BlueDemonThrownTridentEntity.class, box, trident -> 
/*      */ 
/*      */         
/*  586 */         (trident.m_6084_() && trident.isGroundedTrident() && trident.belongsToOwner((LivingEntity)this) && !trident.isAbsorbingToWearer() && trident.m_20280_((Entity)this) > 9.0D));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  593 */     BlueDemonThrownTridentEntity best = null;
/*  594 */     double bestDistance = Double.MAX_VALUE;
/*      */     
/*  596 */     for (BlueDemonThrownTridentEntity trident : tridents) {
/*  597 */       double distance = m_20280_((Entity)trident);
/*  598 */       if (distance < bestDistance) {
/*  599 */         bestDistance = distance;
/*  600 */         best = trident;
/*      */       } 
/*      */     } 
/*      */     
/*  604 */     return best;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public LivingEntityPatch<?> getLivingEntityPatch() {
/*  609 */     return (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*      */   }
/*      */   
/*      */   public BlueDemonEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  613 */     this((EntityType<? extends BlueDemonEntity>)AnnoyingVillagersModEntities.BLUE_DEMON.get(), level);
/*      */   }
/*      */   
/*      */   public BlueDemonEntity(EntityType<? extends BlueDemonEntity> type, Level level) {
/*  617 */     super(type, level);
/*  618 */     m_274367_(3.0F);
/*  619 */     this.f_21364_ = 0;
/*  620 */     m_21557_(false);
/*  621 */     m_6593_(m_5446_());
/*  622 */     m_20340_(true);
/*  623 */     m_21530_();
/*  624 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get()));
/*  625 */     m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get()));
/*  626 */     m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_CHESTPLATE.get()));
/*  627 */     m_21409_(EquipmentSlot.MAINHAND, 0.0F);
/*  628 */     m_21409_(EquipmentSlot.CHEST, 0.0F);
/*  629 */     m_21409_(EquipmentSlot.OFFHAND, 0.0F);
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   protected SoundEvent m_7975_(@NotNull DamageSource pDamageSource) {
/*  634 */     return m_20069_() ? SoundEvents.f_11820_ : SoundEvents.f_11819_;
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   protected SoundEvent m_5592_() {
/*  639 */     return m_20069_() ? SoundEvents.f_11818_ : SoundEvents.f_11817_;
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   protected SoundEvent m_5501_() {
/*  644 */     return SoundEvents.f_11876_;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void m_8099_() {
/*  649 */     this.f_21345_.m_25352_(1, (Goal)new KeepPositionGoal((Mob)this));
/*  650 */     CommonGoals.registerGoalForBlueDemonNpc(this);
/*      */   }
/*      */   
/*      */   public boolean m_7301_(MobEffectInstance mobeffectinstance) {
/*  654 */     return ((mobeffectinstance.m_19544_().m_19483_() == MobEffectCategory.BENEFICIAL || mobeffectinstance.m_19544_() == MobEffects.f_19619_) && super.m_7301_(mobeffectinstance));
/*      */   }
/*      */   
/*      */   private boolean isAliveSauce(@Nullable BbqEntity sauce) {
/*  658 */     return (sauce != null && sauce.m_6084_());
/*      */   }
/*      */   
/*      */   private void clearSweetTemporaryCarriedTrident(@Nullable BbqEntity sweet) {
/*  662 */     if (!isAliveSauce(sweet)) {
/*      */       return;
/*      */     }
/*      */     
/*  666 */     ItemStack stack = sweet.m_21205_();
/*  667 */     if (!stack.m_150930_((Item)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get())) {
/*      */       return;
/*      */     }
/*      */     
/*  671 */     CompoundTag tag = stack.m_41783_();
/*  672 */     if (tag != null && tag.m_128441_("CarriedTridentMode")) {
/*  673 */       sweet.m_21008_(InteractionHand.MAIN_HAND, ItemStack.f_41583_);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isInFinalDeathSequence() {
/*  678 */     return (this.dieTick > 0);
/*      */   }
/*      */   
/*      */   private void startFinalDeathSequence(ServerLevel serverLevel, DamageSource damageSource) {
/*  682 */     if (this.dieTick > 0) {
/*      */       return;
/*      */     }
/*      */     
/*  686 */     this.dieTick = 200;
/*  687 */     m_21153_(1.0F);
/*  688 */     m_21557_(true);
/*  689 */     m_6710_((LivingEntity)null);
/*  690 */     m_20334_(0.0D, 0.0D, 0.0D);
/*      */     
/*  692 */     if (damageSource.m_7639_() != null) {
/*  693 */       this.savedKillerUUID = damageSource.m_7639_().m_20148_();
/*      */     } else {
/*  695 */       this.savedKillerUUID = null;
/*      */     } 
/*      */     
/*  698 */     if (getLivingEntityPatch() != null) {
/*  699 */       if (m_21205_().m_41720_() instanceof BlueDemonTridentItem) {
/*  700 */         getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.BLUE_DEMON_DIE, 0.0F);
/*      */       } else {
/*  702 */         getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.BLUE_DEMON_DIE_LEGENDARY_SWORD_START, 0.0F);
/*      */       } 
/*      */     }
/*      */     
/*  706 */     startSauceDeathWatch(serverLevel);
/*      */   }
/*      */   
/*      */   private void startSauceDeathWatch(ServerLevel serverLevel) {
/*  710 */     BbqEntity bbq = resolveAliveSauce(serverLevel, SauceType.BBQ_SAUCE);
/*  711 */     BbqEntity honey = resolveAliveSauce(serverLevel, SauceType.HONEY_MUSTARD_SAUCE);
/*  712 */     BbqEntity soy = resolveAliveSauce(serverLevel, SauceType.SOY_SAUCE);
/*  713 */     BbqEntity sweet = resolveAliveSauce(serverLevel, SauceType.SWEET_ONION_SAUCE);
/*      */     
/*  715 */     if (bbq != null) {
/*  716 */       bbq.startLeaderDeathWatch(this);
/*      */     }
/*  718 */     if (honey != null) {
/*  719 */       honey.startLeaderDeathWatch(this);
/*      */     }
/*  721 */     if (soy != null) {
/*  722 */       soy.startLeaderDeathWatch(this);
/*      */     }
/*  724 */     if (sweet != null) {
/*  725 */       sweet.startLeaderDeathWatch(this);
/*      */     }
/*      */   }
/*      */   
/*      */   private void tickFinalDeathSequence(ServerLevel serverLevel) {
/*  730 */     m_21557_(true);
/*  731 */     m_6710_((LivingEntity)null);
/*  732 */     m_20334_(0.0D, 0.0D, 0.0D);
/*      */     
/*  734 */     if (getLivingEntityPatch() != null && this.dieTick <= 180 && this.dieTick % 10 == 0) {
/*  735 */       if (m_21205_().m_41720_() instanceof BlueDemonTridentItem) {
/*  736 */         getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.BLUE_DEMON_STATE_TRANSFORM, 0.0F);
/*      */       } else {
/*  738 */         getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.BLUE_DEMON_DIE_LEGENDARY_SWORD_TICK, 0.0F);
/*      */       } 
/*      */     }
/*      */     
/*  742 */     if (this.dieTick % 5 == 0 && (new Random()).nextBoolean()) {
/*  743 */       strikeDeathLightning(serverLevel);
/*      */     }
/*      */     
/*  746 */     this.dieTick--;
/*  747 */     if (this.dieTick <= 0) {
/*  748 */       finishFinalDeathSequence(serverLevel);
/*      */     }
/*      */   }
/*      */   
/*      */   private void strikeDeathLightning(ServerLevel serverLevel) {
/*  753 */     TridentLightningBolt tridentLightningBolt = new TridentLightningBolt((EntityType<? extends LightningBolt>)AnnoyingVillagersModEntities.TRIDENT_LIGHTNING_BOLT.get(), (Level)serverLevel);
/*  754 */     tridentLightningBolt.setOwner((LivingEntity)this);
/*  755 */     tridentLightningBolt.m_6027_(
/*  756 */         m_20185_(), 
/*  757 */         m_20186_(), 
/*  758 */         m_20189_());
/*      */     
/*  760 */     serverLevel.m_7967_((Entity)tridentLightningBolt);
/*      */   }
/*      */   
/*      */   private DamageSource buildSavedKillerDamageSource(ServerLevel serverLevel) {
/*  764 */     if (this.savedKillerUUID != null) {
/*  765 */       Entity entity = serverLevel.m_8791_(this.savedKillerUUID);
/*      */       
/*  767 */       if (entity instanceof Player) { Player player = (Player)entity;
/*  768 */         return m_269291_().m_269075_(player); }
/*      */ 
/*      */       
/*  771 */       if (entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity;
/*  772 */         return m_269291_().m_269333_(livingEntity); }
/*      */     
/*      */     } 
/*      */     
/*  776 */     return m_269291_().m_269264_();
/*      */   }
/*      */   
/*      */   private void finishFinalDeathSequence(ServerLevel serverLevel) {
/*  780 */     DamageSource finalSource = buildSavedKillerDamageSource(serverLevel);
/*  781 */     m_21153_(0.0F);
/*  782 */     handleSaucesWhenBlueDemonDies(serverLevel);
/*  783 */     this.dieTick = -1;
/*  784 */     m_6667_(finalSource);
/*  785 */     m_142687_(Entity.RemovalReason.KILLED);
/*      */   }
/*      */   
/*      */   private void handleSaucesWhenBlueDemonDies(ServerLevel serverLevel) {
/*  789 */     BbqEntity bbq = resolveAliveSauce(serverLevel, SauceType.BBQ_SAUCE);
/*  790 */     BbqEntity honey = resolveAliveSauce(serverLevel, SauceType.HONEY_MUSTARD_SAUCE);
/*  791 */     BbqEntity soy = resolveAliveSauce(serverLevel, SauceType.SOY_SAUCE);
/*  792 */     BbqEntity sweet = resolveAliveSauce(serverLevel, SauceType.SWEET_ONION_SAUCE);
/*      */     
/*  794 */     clearSweetTemporaryCarriedTrident(sweet);
/*      */     
/*  796 */     boolean bbqAlive = isAliveSauce(bbq);
/*  797 */     boolean honeyAlive = isAliveSauce(honey);
/*  798 */     boolean soyAlive = isAliveSauce(soy);
/*  799 */     boolean sweetAlive = isAliveSauce(sweet);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  805 */     int aliveCount = (bbqAlive ? 1 : 0) + (honeyAlive ? 1 : 0) + (soyAlive ? 1 : 0) + (sweetAlive ? 1 : 0);
/*      */     
/*  807 */     int existingTridents = (honeyAlive ? 1 : 0) + (soyAlive ? 1 : 0);
/*  808 */     int missingTridents = Math.max(0, 2 - existingTridents);
/*      */     
/*  810 */     boolean giveBbqMainTrident = false;
/*  811 */     boolean giveSweetMainTrident = false;
/*  812 */     boolean giveBbqOffhandChestplate = false;
/*  813 */     boolean giveSweetOffhandChestplate = false;
/*      */     
/*  815 */     int rawTridentDrops = 0;
/*  816 */     boolean rawChestplateDrop = false;
/*      */     
/*  818 */     if (aliveCount == 4) {
/*  819 */       giveSweetOffhandChestplate = true;
/*  820 */     } else if (aliveCount == 3) {
/*  821 */       if (sweetAlive) {
/*  822 */         giveSweetOffhandChestplate = true;
/*  823 */       } else if (bbqAlive) {
/*  824 */         giveBbqOffhandChestplate = true;
/*      */       } else {
/*  826 */         rawChestplateDrop = true;
/*      */       } 
/*      */     } else {
/*  829 */       rawChestplateDrop = true;
/*      */     } 
/*      */     
/*  832 */     while (missingTridents > 0) {
/*  833 */       if (sweetAlive && !giveSweetMainTrident) {
/*  834 */         giveSweetMainTrident = true;
/*  835 */       } else if (bbqAlive && !giveBbqMainTrident) {
/*  836 */         giveBbqMainTrident = true;
/*      */       } else {
/*  838 */         rawTridentDrops++;
/*      */       } 
/*  840 */       missingTridents--;
/*      */     } 
/*      */     
/*  843 */     double deathX = m_20185_();
/*  844 */     double deathY = m_20186_();
/*  845 */     double deathZ = m_20189_();
/*      */     
/*  847 */     if (bbqAlive) {
/*  848 */       bbq.startDeathAssembly(deathX, deathY, deathZ, giveBbqMainTrident, giveBbqOffhandChestplate, (BbqEntity)null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  856 */     if (honeyAlive) {
/*  857 */       honey.startDeathAssembly(deathX, deathY, deathZ, false, false, 
/*      */ 
/*      */ 
/*      */           
/*  861 */           bbqAlive ? bbq : null);
/*      */     }
/*      */ 
/*      */     
/*  865 */     if (soyAlive) {
/*  866 */       soy.startDeathAssembly(deathX, deathY, deathZ, false, false, 
/*      */ 
/*      */ 
/*      */           
/*  870 */           bbqAlive ? bbq : null);
/*      */     }
/*      */ 
/*      */     
/*  874 */     if (sweetAlive) {
/*  875 */       sweet.startDeathAssembly(deathX, deathY, deathZ, giveSweetMainTrident, giveSweetOffhandChestplate, 
/*      */ 
/*      */ 
/*      */           
/*  879 */           bbqAlive ? bbq : null);
/*      */     }
/*      */ 
/*      */     
/*  883 */     if (rawChestplateDrop) {
/*  884 */       m_19983_(new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_CHESTPLATE.get()));
/*      */     }
/*      */     
/*  887 */     for (int i = 0; i < rawTridentDrops; i++) {
/*  888 */       m_19983_(new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get()));
/*      */     }
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   private BbqEntity resolveAliveSauce(ServerLevel serverLevel, SauceType sauceType) {
/*  894 */     BbqEntity current = getSauce(sauceType);
/*  895 */     if (current != null && current.m_6084_()) {
/*  896 */       return current;
/*      */     }
/*      */     
/*  899 */     UUID uuid = getSauceUUID(sauceType);
/*  900 */     if (uuid == null) {
/*  901 */       return null;
/*      */     }
/*      */     
/*  904 */     Entity entity = serverLevel.m_8791_(uuid);
/*  905 */     if (entity instanceof BbqEntity) { BbqEntity sauce = (BbqEntity)entity; if (sauce.m_6084_()) {
/*  906 */         setSauce(sauceType, sauce);
/*  907 */         return sauce;
/*      */       }  }
/*      */     
/*  910 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getBurstProtectCapRatio() {
/*  915 */     return 0.05F;
/*      */   }
/*      */   
/*      */   public boolean m_6469_(DamageSource damagesource, float f) {
/*  919 */     if (damagesource.m_276093_(DamageTypes.f_268671_)) return false; 
/*  920 */     if (damagesource.m_276093_(DamageTypes.f_268585_)) return false; 
/*  921 */     if (damagesource.m_276093_(DamageTypes.f_268722_)) return false; 
/*  922 */     if (damagesource.m_276093_(DamageTypes.f_268450_)) return false; 
/*  923 */     if (damagesource.m_276093_(DamageTypes.f_268493_)) return false; 
/*  924 */     if (damagesource.m_276093_(DamageTypes.f_268714_)) return false; 
/*  925 */     if (damagesource.m_276093_(DamageTypes.f_268641_)) return false; 
/*  926 */     if (damagesource.m_7640_() instanceof ThrownPoisonEggEntity) return false; 
/*  927 */     if (damagesource.m_276093_(DamageTypes.f_268724_) || damagesource
/*  928 */       .m_276093_(DamageTypes.f_286979_)) {
/*  929 */       boolean bool = super.m_6469_(damagesource, f);
/*  930 */       if (bool) {
/*  931 */         sayHurtSound((Mob)this, damagesource);
/*      */       }
/*  933 */       return bool;
/*      */     } 
/*  935 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (getState() == 2 || getState() == 1) {
/*  936 */         EpicfightUtil.damageBlocked(damagesource, (Entity)this, serverLevel);
/*  937 */         return false;
/*      */       }  }
/*      */     
/*  940 */     if (this.dieTick > 0) {
/*  941 */       level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  942 */         ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, (Entity)this, damagesource
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  947 */             .m_7639_()); }
/*      */ 
/*      */       
/*  950 */       return false;
/*      */     } 
/*  952 */     level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (getLivingEntityPatch() != null && this.dieTick <= 0) {
/*  953 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getLivingEntityPatch().getAnimator().getPlayerFor(null))).getRealAnimation();
/*  954 */         if (dynamicAnimation == AVAnimations.CUT_ANTITHEUS_ASCENSION || dynamicAnimation == AVAnimations.TRIDENT_ATTACK || dynamicAnimation == AVAnimations.ELECTRIC_FIELD || dynamicAnimation == AVAnimations.TRIDENT_FESTIVAL || dynamicAnimation == AVAnimations.BLUE_DEMON_STATE_TRANSFORM || dynamicAnimation == AVAnimations.BLUE_DEMON_STATE_TRANSFORM_END) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  960 */           ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, (Entity)this, damagesource
/*  961 */               .m_7639_());
/*  962 */           return false;
/*      */         } 
/*      */       }  }
/*  965 */      boolean result = super.m_6469_(damagesource, f);
/*  966 */     if (result) {
/*  967 */       sayHurtSound((Mob)this, damagesource);
/*      */     }
/*  969 */     return result;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public BbqEntity getBbqEntity() {
/*  974 */     if (this.bbqSauce != null && this.bbqSauce.m_6084_()) {
/*  975 */       return this.bbqSauce;
/*      */     }
/*      */     
/*  978 */     if (this.bbqResolveCooldown > 0) {
/*  979 */       this.bbqResolveCooldown--;
/*  980 */       return null;
/*      */     } 
/*      */     
/*  983 */     this.bbqResolveCooldown = 20;
/*      */     
/*  985 */     if (!(m_9236_()).f_46443_ && this.bbqSauceUUID != null) {
/*  986 */       Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.bbqSauceUUID);
/*  987 */       if (entity instanceof BbqEntity) { BbqEntity bbqEntity = (BbqEntity)entity; if (bbqEntity.m_6084_()) {
/*  988 */           this.bbqSauce = bbqEntity;
/*  989 */           return bbqEntity;
/*      */         }  }
/*      */     
/*      */     } 
/*  993 */     return null;
/*      */   }
/*      */   
/*      */   public void setBbqEntity(@Nullable BbqEntity bbqEntity) {
/*  997 */     this.bbqSauce = bbqEntity;
/*  998 */     this.bbqSauceUUID = (bbqEntity == null) ? null : bbqEntity.m_20148_();
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   private LivingEntity resolveBbqTarget(@Nullable LivingEntity target) {
/* 1003 */     if (target == null || !target.m_6084_()) {
/* 1004 */       return null;
/*      */     }
/*      */     
/* 1007 */     if (target instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)target; if (herobrineMob
/* 1008 */         .isSacrificing() || herobrineMob.isHealing()) {
/* 1009 */         Entity entity = herobrineMob.getFirstPossessedHerobrine(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_())
/* 1010 */             return living;  }
/*      */         
/* 1012 */         entity = herobrineMob.getSecondPossessedHerobrine(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_())
/* 1013 */             return living;  }
/*      */         
/* 1015 */         entity = herobrineMob.getThirdPossessedHerobrine(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_())
/* 1016 */             return living;  }
/*      */         
/* 1018 */         entity = herobrineMob.getFourthPossessedHerobrine(); if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_())
/* 1019 */             return living;  }
/*      */       
/*      */       }  }
/*      */     
/* 1023 */     if (target instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)target; if (lowHerobrineCloneEntity
/* 1024 */         .isHealing() && lowHerobrineCloneEntity
/* 1025 */         .getPossessedByEntity() != null && 
/* 1026 */         !lowHerobrineCloneEntity.m_6084_()) {
/* 1027 */         return (LivingEntity)lowHerobrineCloneEntity.getPossessedByEntity();
/*      */       } }
/*      */ 
/*      */     
/* 1031 */     if (target instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)target; if ((lowShadowHerobrineCloneEntity
/* 1032 */         .isSacrificing() || lowShadowHerobrineCloneEntity.isHealing()) && lowShadowHerobrineCloneEntity
/* 1033 */         .getPossessedByEntity() != null && 
/* 1034 */         !lowShadowHerobrineCloneEntity.m_6084_()) {
/* 1035 */         return (LivingEntity)lowShadowHerobrineCloneEntity.getPossessedByEntity();
/*      */       } }
/*      */ 
/*      */     
/* 1039 */     return target;
/*      */   }
/*      */   
/*      */   private void tickBbqOrders(@Nullable BbqEntity bbqEntity) {
/* 1043 */     if (bbqEntity == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1047 */     if (isSauceArrivalPending()) {
/* 1048 */       bbqEntity.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1052 */     LivingEntity blueDemonTarget = m_5448_();
/* 1053 */     if (blueDemonTarget == null || !blueDemonTarget.m_6084_()) {
/* 1054 */       bbqEntity.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1058 */     LivingEntity bbqTarget = resolveSauceTarget(blueDemonTarget);
/* 1059 */     if (bbqTarget == null || !bbqTarget.m_6084_()) {
/* 1060 */       bbqEntity.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1064 */     bbqEntity.setCombatTarget(bbqTarget);
/*      */     
/* 1066 */     if (this.bbqHeadAttackCooldown > 0) {
/* 1067 */       this.bbqHeadAttackCooldown--;
/*      */     }
/*      */     
/* 1070 */     if (this.bbqOrderCooldown > 0) {
/* 1071 */       this.bbqOrderCooldown--;
/*      */     }
/*      */     
/* 1074 */     if (this.bbqModeCooldown > 0) {
/* 1075 */       this.bbqModeCooldown--;
/*      */     }
/*      */     
/* 1078 */     double blueDistance = m_20270_((Entity)blueDemonTarget);
/* 1079 */     double bbqDistance = bbqEntity.m_20270_((Entity)bbqTarget);
/*      */     
/* 1081 */     if (blueDistance > 10.0D) {
/* 1082 */       bbqEntity.startParallelPursuit(bbqTarget, 25);
/*      */       
/* 1084 */       if (this.bbqOrderCooldown <= 0) {
/* 1085 */         bbqEntity.shootChain(bbqTarget, 3, 10);
/* 1086 */         this.bbqOrderCooldown = 40;
/*      */       } 
/*      */       
/*      */       return;
/*      */     } 
/* 1091 */     if (this.bbqHeadAttackCooldown <= 0 && blueDistance < 4.5D && bbqDistance < 6.5D && !bbqEntity.isHeadAttacking()) {
/* 1092 */       bbqEntity.startHeadAttack(bbqTarget, 35);
/* 1093 */       this.bbqHeadAttackCooldown = 110;
/* 1094 */       this.bbqModeCooldown = 20;
/* 1095 */       this.bbqOrderCooldown = 16;
/*      */       
/*      */       return;
/*      */     } 
/* 1099 */     if (!bbqEntity.isHeadAttacking() && this.bbqModeCooldown <= 0) {
/* 1100 */       int roll = this.f_19796_.m_188503_(100);
/*      */       
/* 1102 */       if (roll < 25) {
/* 1103 */         bbqEntity.startParallelPursuit(bbqTarget, 28);
/* 1104 */         this.bbqModeCooldown = 40;
/* 1105 */       } else if (roll < 60) {
/* 1106 */         bbqEntity.startGroundOrbit(bbqTarget, 36);
/* 1107 */         this.bbqModeCooldown = 42;
/*      */       } else {
/* 1109 */         bbqEntity.startOrbit(bbqTarget, 28);
/* 1110 */         this.bbqModeCooldown = 38;
/*      */       } 
/*      */     } 
/*      */     
/* 1114 */     if (bbqEntity.isHeadAttacking() || this.bbqOrderCooldown > 0) {
/*      */       return;
/*      */     }
/*      */     
/* 1118 */     switch (bbqEntity.getCombatMode()) {
/*      */       case PARALLEL:
/* 1120 */         bbqEntity.shootChain(bbqTarget, 3, 10);
/* 1121 */         this.bbqOrderCooldown = 40;
/*      */         break;
/*      */       case GROUND_ORBIT:
/* 1124 */         if (bbqDistance > 7.0D) {
/* 1125 */           bbqEntity.shootChain(bbqTarget, 3, 9);
/* 1126 */           this.bbqOrderCooldown = 36; break;
/*      */         } 
/* 1128 */         bbqEntity.shootCluster(bbqTarget, 3, 1.05F, 10.0F);
/* 1129 */         this.bbqOrderCooldown = 48;
/*      */         break;
/*      */       
/*      */       case ORBIT:
/* 1133 */         if (bbqDistance > 7.0D) {
/* 1134 */           bbqEntity.shootChain(bbqTarget, 4, 8);
/* 1135 */           this.bbqOrderCooldown = 38; break;
/*      */         } 
/* 1137 */         bbqEntity.shootCluster(bbqTarget, 4, 1.1F, 10.0F);
/* 1138 */         this.bbqOrderCooldown = 52;
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void tickShockSauceOrders(@Nullable BbqEntity sauce) {
/* 1147 */     if (sauce == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1151 */     if (isSauceArrivalPending()) {
/* 1152 */       sauce.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1156 */     LivingEntity blueDemonTarget = m_5448_();
/* 1157 */     if (blueDemonTarget == null || !blueDemonTarget.m_6084_()) {
/* 1158 */       sauce.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1162 */     LivingEntity sauceTarget = resolveSauceTarget(blueDemonTarget);
/* 1163 */     if (sauceTarget == null || !sauceTarget.m_6084_()) {
/* 1164 */       sauce.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1168 */     sauce.setCombatTarget(sauceTarget);
/*      */     
/* 1170 */     double blueDistance = m_20270_((Entity)blueDemonTarget);
/* 1171 */     double sauceDistance = sauce.m_20270_((Entity)sauceTarget);
/*      */     
/* 1173 */     if (blueDistance > 10.0D) {
/* 1174 */       sauce.startParallelPursuit(sauceTarget, 25);
/*      */       
/*      */       return;
/*      */     } 
/* 1178 */     if (!sauce.isHeadAttacking() && this.f_19797_ % 60 == 0 && blueDistance < 4.5D && sauceDistance < 6.5D && this.f_19796_.m_188503_(4) == 0) {
/* 1179 */       sauce.startHeadAttack(sauceTarget, 28);
/*      */       
/*      */       return;
/*      */     } 
/* 1183 */     if (!sauce.isHeadAttacking() && this.f_19797_ % 40 == 0) {
/* 1184 */       if (this.f_19796_.m_188499_()) {
/* 1185 */         sauce.startGroundOrbit(sauceTarget, 34);
/*      */       } else {
/* 1187 */         sauce.startOrbit(sauceTarget, 28);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void tickSweetOnionOrders(@Nullable BbqEntity sauce) {
/* 1193 */     if (sauce == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1197 */     if (isSauceArrivalPending()) {
/* 1198 */       sauce.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1202 */     LivingEntity blueDemonTarget = m_5448_();
/* 1203 */     if (blueDemonTarget == null || !blueDemonTarget.m_6084_()) {
/* 1204 */       sauce.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1208 */     LivingEntity sauceTarget = resolveSauceTarget(blueDemonTarget);
/* 1209 */     if (sauceTarget == null || !sauceTarget.m_6084_()) {
/* 1210 */       sauce.clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/* 1214 */     sauce.setCombatTarget(sauceTarget);
/*      */   }
/*      */   
/*      */   private void tickArmorBuff(ServerLevel serverLevel) {
/* 1218 */     m_7292_(new MobEffectInstance(MobEffects.f_19596_, 1, 1, false, false, false));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1227 */     m_7292_(new MobEffectInstance(MobEffects.f_19603_, 1, 1, false, false, false));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1236 */     m_7292_(new MobEffectInstance(MobEffects.f_19606_, 1, 2, false, false, false));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1245 */     if (serverLevel.f_46441_.m_188500_() <= 0.1D) {
/* 1246 */       serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/* 1247 */           .get(), 
/* 1248 */           m_20185_(), m_20186_(), m_20189_(), 1, 0.3D, 1.2D, 0.3D, 0.0D);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1254 */       if (serverLevel.f_46441_.m_188500_() <= 0.8D) {
/* 1255 */         float volume = (float)Mth.m_216263_(serverLevel.f_46441_, 0.05D, 0.5D);
/* 1256 */         float pitch = (float)Mth.m_216263_(serverLevel.f_46441_, 0.8D, 1.1D);
/*      */         
/* 1258 */         serverLevel.m_5594_(null, 
/*      */             
/* 1260 */             BlockPos.m_274561_(m_20185_(), m_20186_(), m_20189_()), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY
/* 1261 */             .get(), SoundSource.NEUTRAL, volume, pitch);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1269 */     if (this.f_19797_ % 2 == 0 && getLivingEntityPatch() != null) {
/* 1270 */       AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getLivingEntityPatch().getAnimator().getPlayerFor(null))).getRealAnimation();
/* 1271 */       if (dynamicAnimation != AVAnimations.TRIDENT_ATTACK && dynamicAnimation != AVAnimations.TRIDENT_FESTIVAL) {
/* 1272 */         absorbNearbyGroundedOwnerTridents(serverLevel);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void absorbNearbyGroundedOwnerTridents(ServerLevel serverLevel) {
/* 1284 */     AABB box = new AABB(m_20185_() - 2.5D, m_20186_() - 2.5D, m_20189_() - 2.5D, m_20185_() + 2.5D, m_20186_() + 2.5D, m_20189_() + 2.5D);
/*      */ 
/*      */     
/* 1287 */     List<BlueDemonThrownTridentEntity> tridents = serverLevel.m_6443_(BlueDemonThrownTridentEntity.class, box, trident -> 
/*      */ 
/*      */         
/* 1290 */         (trident.m_6084_() && trident.isGroundedTrident() && trident.belongsToOwner((LivingEntity)this) && !trident.isAbsorbingToWearer()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1296 */     for (BlueDemonThrownTridentEntity trident : tridents) {
/* 1297 */       trident.beginAbsorbToWearer((LivingEntity)this);
/*      */     }
/*      */   }
/*      */   
/*      */   private void tickStateTwoPhysics() {
/* 1302 */     m_20242_(false);
/*      */     
/* 1304 */     Vec3 motion = m_20184_();
/* 1305 */     motion = new Vec3(0.0D, motion.f_82480_, 0.0D);
/*      */     
/* 1307 */     if (!m_20096_() && !m_20069_() && !m_20077_()) {
/* 1308 */       motion = motion.m_82520_(0.0D, -0.08D, 0.0D);
/*      */     }
/*      */     
/* 1311 */     motion = new Vec3(motion.f_82479_ * 0.91D, motion.f_82480_ * 0.98D, motion.f_82481_ * 0.91D);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1317 */     m_20256_(motion);
/* 1318 */     m_6478_(MoverType.SELF, motion);
/*      */     
/* 1320 */     if (m_20096_() && (m_20184_()).f_82480_ < 0.0D) {
/* 1321 */       m_20334_((m_20184_()).f_82479_, 0.0D, (m_20184_()).f_82481_);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_8119_() {
/* 1327 */     super.m_8119_();
/*      */     
/* 1329 */     if (getState() == 2 || this.dieTick > 0) {
/* 1330 */       tickStateTwoPhysics();
/*      */     }
/*      */     
/* 1333 */     Level level = m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/* 1334 */       tickVoiceCooldown();
/* 1335 */       tickBurstProtectionDecay((LivingEntity)this);
/*      */       
/* 1337 */       if (!this.spawnedBbqSauce) {
/* 1338 */         ensureSauceExists(SauceType.BBQ_SAUCE);
/* 1339 */         this.spawnedBbqSauce = true;
/*      */       } 
/* 1341 */       if (this.stunEscapeCooldown > 0) this.stunEscapeCooldown--; 
/* 1342 */       if (this.swapWeaponCooldown > 0) this.swapWeaponCooldown--; 
/* 1343 */       if (this.efnGuardHitCooldown > 0) this.efnGuardHitCooldown--; 
/* 1344 */       if (this.healingCooldown > 0) this.healingCooldown--; 
/* 1345 */       if (this.stateTransformCooldown > 0) {
/* 1346 */         if (getLivingEntityPatch() != null) {
/* 1347 */           if (this.stateTransformCooldown > 20) {
/* 1348 */             getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.BLUE_DEMON_STATE_TRANSFORM, 0.0F);
/* 1349 */           } else if (this.stateTransformCooldown == 20) {
/* 1350 */             m_5496_((SoundEvent)AnnoyingVillagersModSounds.BLUE_DEMON_SAY_PHASE_2_RELEASE.get(), 1.0F, 1.0F);
/* 1351 */             getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.BLUE_DEMON_STATE_TRANSFORM_END, 0.0F);
/* 1352 */           } else if (this.stateTransformCooldown == 10) {
/* 1353 */             ItemStack legendaryStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.LEGENDARY_SWORD.get());
/* 1354 */             legendaryStack.m_41663_(Enchantments.f_44977_, 5);
/* 1355 */             legendaryStack.m_41663_(Enchantments.f_44978_, 5);
/* 1356 */             legendaryStack.m_41663_(Enchantments.f_44983_, 5);
/*      */             
/* 1358 */             m_21008_(InteractionHand.MAIN_HAND, legendaryStack);
/* 1359 */             m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/* 1360 */             m_7292_(new MobEffectInstance(MobEffects.f_19606_, 4, 300));
/*      */           } 
/*      */         }
/* 1363 */         if (this.stateTransformCooldown % 2 == 0) {
/* 1364 */           m_5634_(1.0F);
/*      */         }
/*      */         
/* 1367 */         if (this.stateTransformCooldown <= 200 && this.stateTransformCooldown % 50 == 0) {
/* 1368 */           BlueDemonTridentItem.spawnDamageZones(serverLevel, (LivingEntity)this);
/*      */         }
/*      */         
/* 1371 */         this.stateTransformCooldown--;
/* 1372 */         if (this.stateTransformCooldown == 0) {
/* 1373 */           finishStateTwoTransform(serverLevel);
/*      */         }
/*      */       } 
/* 1376 */       if (this.dieTick > 0) {
/* 1377 */         tickFinalDeathSequence(serverLevel);
/*      */         
/*      */         return;
/*      */       } 
/* 1381 */       if (!this.neverLeave) {
/*      */         
/* 1383 */         int remaining = --this.leaveTicks;
/*      */         
/* 1385 */         if (remaining == 40) {
/* 1386 */           m_6710_((LivingEntity)null);
/* 1387 */           updateLeaveDirectionFromThreat();
/* 1388 */           retreatAllSauces();
/*      */         } 
/*      */         
/* 1391 */         if (remaining <= 0) {
/* 1392 */           m_5496_((SoundEvent)AnnoyingVillagersModSounds.BLUE_DEMON_SAY_WHEN_RETREAT.get(), 1.0F, 1.0F);
/* 1393 */           serverLevel.m_7654_().m_6846_().m_240416_(
/* 1394 */               (Component)Component.m_237113_("<" + m_7755_().getString() + "> " + Component.m_237115_("subtitles.blue_demon_retreat").getString()), false);
/*      */ 
/*      */ 
/*      */           
/* 1398 */           discardAllSauces(serverLevel);
/* 1399 */           m_146870_();
/*      */           
/*      */           return;
/*      */         } 
/* 1403 */         if (isLeavingNow()) {
/* 1404 */           tickLeaveRetreat();
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/* 1409 */       tickSquadArrival(serverLevel);
/* 1410 */       if (this.healingTick != 0) {
/* 1411 */         if (this.healingTick > 0) {
/* 1412 */           this.healingTick--;
/*      */         }
/* 1414 */         tickArmorBuff(serverLevel);
/*      */       } 
/*      */       
/* 1417 */       syncChestplateHealingFoil();
/*      */       
/* 1419 */       if (this.efnGuardHitCooldown == 0 && this.efnGuardHitState != 0) {
/* 1420 */         this.efnGuardHitState = 0;
/*      */       }
/*      */       
/* 1423 */       if (this.stunEscapeCooldown == 0 && m_9236_() instanceof ServerLevel && 
/* 1424 */         getLivingEntityPatch() != null) {
/* 1425 */         final AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getLivingEntityPatch().getAnimator().getPlayerFor(null))).getRealAnimation();
/* 1426 */         if (EpicfightUtil.isLongHitAnimationNotExecutedAnimation(dynamicAnimation, getLivingEntityPatch()) && m_6084_() && 
/* 1427 */           m_217043_().m_188501_() < CombatBehaviour.calculateGuardBreakWakeUpChance((LivingEntity)this)) {
/* 1428 */           this.stunEscapeCooldown = 60;
/* 1429 */           final BlueDemonEntity entity = this;
/* 1430 */           new DelayedTask((new Random()).nextInt(5, 10))
/*      */             {
/*      */               public void run() {
/* 1433 */                 if (BlueDemonEntity.this.getLivingEntityPatch() != null && EpicfightUtil.isLongHitAnimationNotExecutedAnimation(dynamicAnimation, BlueDemonEntity.this.getLivingEntityPatch()) && entity.m_6084_()) {
/* 1434 */                   CombatBehaviour.postGuardBreakWakeUp((LivingEntity)entity, BlueDemonEntity.this.getLivingEntityPatch(), serverLevel);
/*      */                 } else {
/* 1436 */                   entity.stunEscapeCooldown = 1;
/*      */                 } 
/*      */               }
/*      */             };
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1445 */       if (getLivingEntityPatch() != null && CombatCommon.canEscape((MobPatch)getLivingEntityPatch())) {
/* 1446 */         this.f_21345_.m_25355_(Goal.Flag.MOVE);
/* 1447 */         m_21573_().m_26573_();
/*      */         
/* 1449 */         LivingEntity target = m_5448_();
/* 1450 */         if (target != null) {
/* 1451 */           m_21563_().m_24960_((Entity)target, 30.0F, 30.0F);
/*      */         }
/*      */       } else {
/* 1454 */         this.f_21345_.m_25374_(Goal.Flag.MOVE);
/*      */       } 
/*      */       
/* 1457 */       if (getState() == 3) {
/* 1458 */         tickShockSauceOrders(getSauce(SauceType.HONEY_MUSTARD_SAUCE));
/* 1459 */         tickShockSauceOrders(getSauce(SauceType.SOY_SAUCE));
/* 1460 */         tickSweetOnionOrders(getSauce(SauceType.SWEET_ONION_SAUCE));
/*      */       } 
/*      */       
/* 1463 */       tickBbqOrders(getSauce(SauceType.BBQ_SAUCE)); }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public SoundEvent getAttackVoiceSound() {
/* 1469 */     return (SoundEvent)AnnoyingVillagersModSounds.BLUE_DEMON_SAY.get();
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7380_(@NotNull CompoundTag tag) {
/* 1474 */     super.m_7380_(tag);
/*      */     
/* 1476 */     if (this.bbqSauceUUID != null) {
/* 1477 */       tag.m_128362_("BbqSauceUUID", this.bbqSauceUUID);
/*      */     }
/* 1479 */     if (this.honeyMustardSauceUUID != null) {
/* 1480 */       tag.m_128362_("HoneyMustardSauceUUID", this.honeyMustardSauceUUID);
/*      */     }
/* 1482 */     if (this.soySauceUUID != null) {
/* 1483 */       tag.m_128362_("SoySauceUUID", this.soySauceUUID);
/*      */     }
/* 1485 */     if (this.sweetOnionSauceUUID != null) {
/* 1486 */       tag.m_128362_("SweetOnionSauceUUID", this.sweetOnionSauceUUID);
/*      */     }
/*      */     
/* 1489 */     tag.m_128405_("HealingCooldown", this.healingCooldown);
/* 1490 */     tag.m_128405_("HealingTick", this.healingTick);
/* 1491 */     tag.m_128405_("StateTransformCooldown", this.stateTransformCooldown);
/* 1492 */     tag.m_128405_("State", getState());
/*      */     
/* 1494 */     if (this.savedTargetUUID != null) {
/* 1495 */       tag.m_128362_("SavedTargetUUID", this.savedTargetUUID);
/*      */     }
/* 1497 */     if (this.savedKillerUUID != null) {
/* 1498 */       tag.m_128362_("SavedKillerUUID", this.savedKillerUUID);
/*      */     }
/*      */     
/* 1501 */     tag.m_128405_("SquadArrivalTicks", this.squadArrivalTicks);
/* 1502 */     tag.m_128379_("SpawnedBbqSauce", this.spawnedBbqSauce);
/* 1503 */     tag.m_128405_("DieTick", this.dieTick);
/* 1504 */     tag.m_128405_("LeaveTicks", this.leaveTicks);
/* 1505 */     tag.m_128379_("NeverLeave", this.neverLeave);
/* 1506 */     tag.m_128405_("VoiceCooldown", this.voiceCooldown);
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7378_(@NotNull CompoundTag tag) {
/* 1511 */     super.m_7378_(tag);
/*      */     
/* 1513 */     if (tag.m_128403_("BbqSauceUUID")) {
/* 1514 */       this.bbqSauceUUID = tag.m_128342_("BbqSauceUUID");
/*      */     }
/* 1516 */     if (tag.m_128403_("HoneyMustardSauceUUID")) {
/* 1517 */       this.honeyMustardSauceUUID = tag.m_128342_("HoneyMustardSauceUUID");
/*      */     }
/* 1519 */     if (tag.m_128403_("SoySauceUUID")) {
/* 1520 */       this.soySauceUUID = tag.m_128342_("SoySauceUUID");
/*      */     }
/* 1522 */     if (tag.m_128403_("SweetOnionSauceUUID")) {
/* 1523 */       this.sweetOnionSauceUUID = tag.m_128342_("SweetOnionSauceUUID");
/*      */     }
/*      */     
/* 1526 */     this.healingCooldown = tag.m_128451_("HealingCooldown");
/* 1527 */     this.healingTick = tag.m_128451_("HealingTick");
/* 1528 */     this.stateTransformCooldown = tag.m_128451_("StateTransformCooldown");
/* 1529 */     setState(tag.m_128441_("State") ? tag.m_128451_("State") : 0);
/*      */     
/* 1531 */     if (tag.m_128403_("SavedTargetUUID")) {
/* 1532 */       this.savedTargetUUID = tag.m_128342_("SavedTargetUUID");
/*      */     } else {
/* 1534 */       this.savedTargetUUID = null;
/*      */     } 
/*      */     
/* 1537 */     if (tag.m_128403_("SavedKillerUUID")) {
/* 1538 */       this.savedKillerUUID = tag.m_128342_("SavedKillerUUID");
/*      */     } else {
/* 1540 */       this.savedKillerUUID = null;
/*      */     } 
/*      */     
/* 1543 */     this.squadArrivalTicks = tag.m_128441_("SquadArrivalTicks") ? tag.m_128451_("SquadArrivalTicks") : -1;
/* 1544 */     this.spawnedBbqSauce = tag.m_128471_("SpawnedBbqSauce");
/* 1545 */     this.dieTick = tag.m_128451_("DieTick");
/* 1546 */     this.leaveTicks = tag.m_128451_("LeaveTicks");
/* 1547 */     this.neverLeave = tag.m_128471_("NeverLeave");
/* 1548 */     this.voiceCooldown = tag.m_128451_("VoiceCooldown");
/*      */   }
/*      */   
/*      */   public void rollItem() {
/* 1552 */     ItemStack legendaryStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.LEGENDARY_SWORD.get());
/* 1553 */     legendaryStack.m_41663_(Enchantments.f_44977_, 5);
/* 1554 */     legendaryStack.m_41663_(Enchantments.f_44978_, 5);
/* 1555 */     legendaryStack.m_41663_(Enchantments.f_44983_, 5);
/*      */     
/* 1557 */     ItemStack tridentStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get());
/* 1558 */     tridentStack.m_41663_(Enchantments.f_44977_, 5);
/* 1559 */     tridentStack.m_41663_(Enchantments.f_44978_, 5);
/* 1560 */     tridentStack.m_41663_(Enchantments.f_44983_, 5);
/* 1561 */     if (m_21205_().m_41720_() instanceof BlueDemonTridentItem) {
/* 1562 */       m_21008_(InteractionHand.MAIN_HAND, legendaryStack);
/* 1563 */       m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/*      */     } else {
/* 1565 */       m_21008_(InteractionHand.MAIN_HAND, tridentStack);
/* 1566 */       m_21008_(InteractionHand.OFF_HAND, tridentStack);
/*      */     } 
/* 1568 */     this.swapWeaponCooldown = (new Random()).nextInt(600, 900);
/*      */   }
/*      */   
/*      */   private void syncChestplateHealingFoil() {
/* 1572 */     ItemStack chest = m_6844_(EquipmentSlot.CHEST);
/* 1573 */     if (BlueDemonChestplateItem.isBlueDemonChestplate(chest))
/* 1574 */       BlueDemonChestplateItem.setBlueDemonHealingFoil(chest, (this.healingTick != 0)); 
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverlevelaccessor, @NotNull DifficultyInstance difficultyinstance, @NotNull MobSpawnType mobspawntype, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 1579 */     SpawnGroupData data = super.m_6518_(serverlevelaccessor, difficultyinstance, mobspawntype, spawngroupdata, compoundtag);
/* 1580 */     if (!m_9236_().m_5776_()) {
/* 1581 */       TeamUtil.addOrJoinTeam((Entity)this, "blue_demon");
/*      */     }
/* 1583 */     if (mobspawntype == MobSpawnType.NATURAL || mobspawntype == MobSpawnType.CHUNK_GENERATION) {
/* 1584 */       ServerLevel serverLevel = serverlevelaccessor.m_6018_();
/* 1585 */       BluedemonData bluedemonData = BluedemonData.get(serverLevel);
/*      */       
/* 1587 */       if (!bluedemonData.tryClaim(serverLevel, m_20148_())) {
/* 1588 */         m_146870_();
/* 1589 */         return data;
/*      */       } 
/*      */       
/* 1592 */       BlockPos blockPos = m_20097_();
/* 1593 */       int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, blockPos).m_123342_();
/* 1594 */       BlockPos spawnPos = new BlockPos(blockPos.m_123341_(), surfaceY, blockPos.m_123343_());
/* 1595 */       m_20035_(spawnPos, m_146908_(), m_146909_());
/*      */     } 
/* 1597 */     int min = ((Integer)AnnoyingVillagersConfig.BLUE_DEMON_LEAVE_MIN_TIME.get()).intValue();
/* 1598 */     int max = ((Integer)AnnoyingVillagersConfig.BLUE_DEMON_LEAVE_MAX_TIME.get()).intValue();
/* 1599 */     int randomMin = Math.min(min, max);
/* 1600 */     int randomMax = Math.max(min, max);
/* 1601 */     this.leaveTicks = (randomMin + (new Random()).nextInt(randomMax - randomMin + 1)) * 60 * 20;
/* 1602 */     return data;
/*      */   }
/*      */   
/*      */   public static boolean canSpawn(EntityType<BlueDemonEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 1606 */     ServerLevel serverLevel = level.m_6018_();
/* 1607 */     if (!serverLevel.m_46470_()) return false; 
/* 1608 */     if (serverLevel.m_46462_()) {
/* 1609 */       return false;
/*      */     }
/* 1611 */     if (BluedemonData.get(serverLevel).isOccupied(serverLevel)) {
/* 1612 */       return false;
/*      */     }
/* 1614 */     return Monster.m_219019_(entityType, (LevelAccessor)level, spawnType, position, random);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void m_6475_(@NotNull DamageSource pDamageSource, float pDamageAmount) {
/* 1619 */     if (pDamageSource.m_276093_(DamageTypes.f_268724_)) {
/* 1620 */       super.m_6475_(pDamageSource, pDamageAmount);
/*      */       
/*      */       return;
/*      */     } 
/* 1624 */     if (m_6673_(pDamageSource)) {
/*      */       return;
/*      */     }
/*      */     
/* 1628 */     pDamageAmount = ForgeHooks.onLivingHurt((LivingEntity)this, pDamageSource, pDamageAmount);
/* 1629 */     if (pDamageAmount <= 0.0F) {
/*      */       return;
/*      */     }
/*      */     
/* 1633 */     pDamageAmount = m_21161_(pDamageSource, pDamageAmount);
/* 1634 */     pDamageAmount = m_6515_(pDamageSource, pDamageAmount);
/*      */     
/* 1636 */     float f1 = Math.max(pDamageAmount - m_6103_(), 0.0F);
/* 1637 */     float absorbed = pDamageAmount - f1;
/* 1638 */     if (absorbed > 0.0F) {
/* 1639 */       m_7911_(m_6103_() - absorbed);
/* 1640 */       if (m_6103_() < 0.0F) m_7911_(0.0F); 
/*      */     } 
/* 1642 */     f1 = ForgeHooks.onLivingDamage((LivingEntity)this, pDamageSource, f1);
/* 1643 */     f1 = applyBurstProtection((LivingEntity)this, pDamageSource, f1);
/* 1644 */     if (m_9236_() instanceof ServerLevel && 
/* 1645 */       getState() == 0 && m_21223_() - f1 <= 1.0F) {
/* 1646 */       m_21153_(1.0F);
/* 1647 */       BlueDemonTridentItem.addStormEnergy(m_21205_(), 100);
/* 1648 */       BlueDemonTridentItem.addStormEnergy(m_21206_(), 100);
/* 1649 */       if (getLivingEntityPatch() != null) {
/* 1650 */         getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_FESTIVAL, 0.0F);
/*      */       }
/*      */       return;
/*      */     } 
/* 1654 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 1655 */       if (getState() == 3 && 
/* 1656 */         m_21223_() - f1 <= 1.0F) {
/* 1657 */         startFinalDeathSequence(serverLevel, pDamageSource); return;
/*      */       }  }
/*      */     
/* 1660 */     if (f1 <= 0.0F) {
/*      */       return;
/*      */     }
/* 1663 */     m_21231_().m_289194_(pDamageSource, f1);
/* 1664 */     m_21153_(m_21223_() - f1);
/* 1665 */     m_146850_(GameEvent.f_223706_);
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 1670 */     super.m_142687_(reason);
/* 1671 */     if (!(m_9236_()).f_46443_) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (reason == Entity.RemovalReason.KILLED || reason == Entity.RemovalReason.DISCARDED)
/*      */         {
/* 1673 */           BluedemonData.get(serverLevel).releaseIfMatches(serverLevel, m_20148_()); }  }
/*      */        }
/*      */   
/*      */   }
/*      */   public static AttributeSupplier.Builder createAttributes() {
/* 1678 */     return Mob.m_21552_()
/* 1679 */       .m_22268_(Attributes.f_22276_, 300.0D)
/* 1680 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 1681 */       .m_22268_(Attributes.f_22281_, 10.0D)
/* 1682 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 1683 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 1684 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 1685 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 1686 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 1687 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 1688 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 1689 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 1690 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 1691 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*      */   }
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\BlueDemonEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */