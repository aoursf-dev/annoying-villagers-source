/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcFist;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcSword;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
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
/*     */ public class VillagerScoutPatch extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public VillagerScoutPatch() {
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
/*  60 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  61 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  62 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  63 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  64 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  66 */     this.weaponAttackMotions
/*  67 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  68 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcFist.FIST));
/*     */     
/*  70 */     this.weaponLivingMotions
/*  71 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  72 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  73 */           Set.of(
/*  74 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  75 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  76 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  77 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  78 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  80 */     this.weaponAttackMotions
/*  81 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  82 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcFist.FIST));
/*     */     
/*  84 */     this.weaponLivingMotions
/*  85 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  86 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/*  88 */           Set.of(
/*  89 */             Pair.of(LivingMotions.BLOCK, Animations.SWORD_GUARD), 
/*  90 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  91 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  92 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  93 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  94 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH)), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/*  97 */           Set.of(
/*  98 */             Pair.of(LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD), 
/*  99 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON), 
/* 100 */             Pair.of(LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON), 
/* 101 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN_DUAL), 
/* 102 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN_DUAL), 
/* 103 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 106 */     this.weaponAttackMotions
/* 107 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/* 108 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcSword.SWORD, CapabilityItem.Styles.TWO_HAND, NpcSword.DUAL_SWORD));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/* 114 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 115 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 120 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardBreakSound() {
/* 128 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CECombatBehaviors.Builder<MobPatch<?>> getCustomWeaponMotionBuilder() {
/* 133 */     CapabilityItem mainHandCap = getHoldingItemCapability(InteractionHand.MAIN_HAND);
/* 134 */     CECombatBehaviors.Builder<MobPatch<?>> customOverride = MobPatchCommon.overideBowMotionBuilderForNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this));
/* 135 */     return (customOverride != null) ? customOverride : super.getCustomWeaponMotionBuilder();
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 139 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 141 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 145 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 149 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 153 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 158 */     super.onGuardHit(damageSource);
/* 159 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 160 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */   
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 165 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 170 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 171 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 173 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 179 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 184 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 189 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\VillagerScoutPatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */