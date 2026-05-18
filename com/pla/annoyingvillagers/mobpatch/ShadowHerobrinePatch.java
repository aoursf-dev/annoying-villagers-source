/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineEnderEye;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineShadowObsidianPillar;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.EscapeUtil;
/*     */ import com.pla.annoyingvillagers.util.MobPatchCommon;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
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
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class ShadowHerobrinePatch extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public ShadowHerobrinePatch() {
/*  42 */     super(Factions.NEUTRAL);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  46 */     super.initAnimator(animator);
/*  47 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  48 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  49 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  50 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  51 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  52 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  56 */     this.weaponLivingMotions
/*  57 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  58 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  59 */           Set.of(
/*  60 */             Pair.of(LivingMotions.BLOCK, AVAnimations.FIST_GUARD), 
/*  61 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  62 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  63 */             Pair.of(LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN), 
/*  64 */             Pair.of(LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN), 
/*  65 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  67 */     this.weaponAttackMotions
/*  68 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  69 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, HerobrineEnderEye.ENDER_EYE));
/*     */     
/*  71 */     this.weaponLivingMotions
/*  72 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  73 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  74 */           Set.of(
/*  75 */             Pair.of(LivingMotions.BLOCK, AVAnimations.FIST_GUARD), 
/*  76 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  77 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  78 */             Pair.of(LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN), 
/*  79 */             Pair.of(LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN), 
/*  80 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  82 */     this.weaponAttackMotions
/*  83 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  84 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, HerobrineEnderEye.ENDER_EYE));
/*  85 */     this.weaponLivingMotions
/*  86 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  87 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/*  89 */           Set.of(
/*  90 */             Pair.of(LivingMotions.BLOCK, AVAnimations.FIST_GUARD), 
/*  91 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  92 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  93 */             Pair.of(LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN), 
/*  94 */             Pair.of(LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN), 
/*  95 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/*  98 */     this.weaponAttackMotions
/*  99 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/* 100 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, HerobrineShadowObsidianPillar.SHADOW_OBSIDIAN_PILLAR_WEAPON));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CECombatBehaviors.Builder<MobPatch<?>> getCustomWeaponMotionBuilder() {
/* 107 */     CapabilityItem mainHandCap = getHoldingItemCapability(InteractionHand.MAIN_HAND);
/* 108 */     CECombatBehaviors.Builder<MobPatch<?>> customOverride = MobPatchCommon.overideCustomWeaponMotionBuilderForShadowHerobrine(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this));
/* 109 */     return (customOverride != null) ? customOverride : super.getCustomWeaponMotionBuilder();
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 113 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 117 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 121 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 126 */     super.onGuardHit(damageSource);
/* 127 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 128 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 130 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBlockableSource(DamageSource damageSource) {
/* 135 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AttackResult tryHurt(DamageSource damageSource, float amount) {
/* 140 */     EscapeUtil.stepLeftRightOnHurtByDangerousAnimation(damageSource, (MobPatch)this);
/* 141 */     return super.tryHurt(damageSource, amount);
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 145 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 150 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 151 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 153 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 159 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 164 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 169 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\ShadowHerobrinePatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */