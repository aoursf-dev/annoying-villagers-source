/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.AngrySteveLegendarySword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcFist;
/*     */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.EscapeUtil;
/*     */ import com.pla.annoyingvillagers.util.MobPatchCommon;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.CEHumanoidPatch;
/*     */ import net.shelmarow.combat_evolution.ai.iml.CustomExecuteEntity;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*     */ import yesman.epicfight.api.animation.AnimationManager;
/*     */ import yesman.epicfight.api.animation.Animator;
/*     */ import yesman.epicfight.api.animation.LivingMotion;
/*     */ import yesman.epicfight.api.animation.LivingMotions;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.gameasset.EpicFightSounds;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.Factions;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.damagesource.EpicFightDamageSource;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class AngryStevePatch
/*     */   extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public AngryStevePatch() {
/*  50 */     super(Factions.NEUTRAL);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  54 */     super.initAnimator(animator);
/*  55 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  56 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  57 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  58 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  59 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  60 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  64 */     this.weaponLivingMotions
/*  65 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  66 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  67 */           Set.of(
/*  68 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  69 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  70 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  71 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  72 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  74 */     this.weaponAttackMotions
/*  75 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  76 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcFist.FIST));
/*     */     
/*  78 */     this.weaponLivingMotions
/*  79 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  80 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  81 */           Set.of(
/*  82 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  83 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  84 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  85 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  86 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  88 */     this.weaponAttackMotions
/*  89 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  90 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcFist.FIST));
/*     */     
/*  92 */     this.weaponLivingMotions
/*  93 */       .put(CapabilityItem.WeaponCategories.GREATSWORD, 
/*  94 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/*  96 */           Set.of(
/*  97 */             Pair.of(LivingMotions.BLOCK, AVAnimations.LEGENDARY_SWORD_GUARD), 
/*  98 */             Pair.of(LivingMotions.IDLE, AVAnimations.LEGENDARY_SWORD_IDLE), 
/*  99 */             Pair.of(LivingMotions.WALK, AVAnimations.TORMENT_BERSERK_WALK), 
/* 100 */             Pair.of(LivingMotions.RUN, AVAnimations.RUN_DUAL_BIG), 
/* 101 */             Pair.of(LivingMotions.CHASE, AVAnimations.RUN_DUAL_BIG), 
/* 102 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 105 */     this.weaponAttackMotions
/* 106 */       .put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 107 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, AngrySteveLegendarySword.LEGENDARY_SWORD));
/*     */ 
/*     */ 
/*     */     
/* 111 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 112 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 113 */           List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CECombatBehaviors.Builder<MobPatch<?>> getCustomWeaponMotionBuilder() {
/* 122 */     CapabilityItem mainHandCap = getHoldingItemCapability(InteractionHand.MAIN_HAND);
/* 123 */     CECombatBehaviors.Builder<MobPatch<?>> customOverride = MobPatchCommon.overideBowMotionBuilderForNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this));
/* 124 */     return (customOverride != null) ? customOverride : super.getCustomWeaponMotionBuilder();
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 128 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 132 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 134 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 138 */     return attackresult;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBlockableSource(DamageSource damageSource) {
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AttackResult tryHurt(DamageSource damageSource, float amount) {
/* 148 */     EscapeUtil.stepLeftRightOnHurtByDangerousAnimation(damageSource, (MobPatch)this);
/* 149 */     return super.tryHurt(damageSource, amount);
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 153 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 157 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void playGuardHitAnimation(DamageSource damageSource, boolean canCounter) {
/* 162 */     if (ModList.get().isLoaded("efn")) { Entity entity = getOriginal(); if (entity instanceof AVNpc) { AVNpc avNpc = (AVNpc)entity; if (avNpc.getLivingEntityPatch() != null)
/* 163 */         { EpicFightNightFall.playEfnGuardHit(avNpc.getLivingEntityPatch(), avNpc.getEfnGuardHitState(), damageSource);
/* 164 */           avNpc.postPlayEfnGuardHit(); return; }  }
/*     */        }
/* 166 */      super.playGuardHitAnimation(damageSource, canCounter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dealStaminaDamage(DamageSource damageSource, float amount) {
/* 172 */     if (ModList.get().isLoaded("efn") && EpicFightNightFall.isPlayingEfnGuardHit(this)) {
/* 173 */       return false;
/*     */     }
/* 175 */     return super.dealStaminaDamage(damageSource, amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 181 */     super.onGuardHit(damageSource);
/* 182 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 183 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 185 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public void playGuardHitSound() {
/* 190 */     if (!ModList.get().isLoaded("efn"))
/*     */     {
/* 192 */       super.playGuardHitSound();
/*     */     }
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 197 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 202 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 203 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 205 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 211 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 216 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 221 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\AngryStevePatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */