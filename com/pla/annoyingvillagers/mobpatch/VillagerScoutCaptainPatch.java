/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcFist;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcSword;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
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
/*     */ public class VillagerScoutCaptainPatch
/*     */   extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public VillagerScoutCaptainPatch() {
/*  45 */     super(Factions.NEUTRAL);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  49 */     super.initAnimator(animator);
/*  50 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  51 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  52 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  53 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  54 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  55 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  59 */     this.weaponLivingMotions
/*  60 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  61 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  62 */           Set.of(
/*  63 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  64 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  65 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  66 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  67 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  69 */     this.weaponAttackMotions
/*  70 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  71 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcFist.FIST));
/*     */     
/*  73 */     this.weaponLivingMotions
/*  74 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  75 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  76 */           Set.of(
/*  77 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  78 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  79 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  80 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  81 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  83 */     this.weaponAttackMotions
/*  84 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  85 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcFist.FIST));
/*     */     
/*  87 */     this.weaponLivingMotions
/*  88 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  89 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/*  91 */           Set.of(
/*  92 */             Pair.of(LivingMotions.BLOCK, Animations.SWORD_GUARD), 
/*  93 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  94 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  95 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/*  96 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/*  97 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH)), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/* 100 */           Set.of(
/* 101 */             Pair.of(LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD), 
/* 102 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON), 
/* 103 */             Pair.of(LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON), 
/* 104 */             Pair.of(LivingMotions.RUN, AVAnimations.RUN_HOLD), 
/* 105 */             Pair.of(LivingMotions.CHASE, AVAnimations.RUN_HOLD), 
/* 106 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 109 */     this.weaponAttackMotions
/* 110 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/* 111 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcSword.AV_SWORD, CapabilityItem.Styles.TWO_HAND, NpcSword.AV_DUAL_SWORD));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/* 117 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 118 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 123 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CECombatBehaviors.Builder<MobPatch<?>> getCustomWeaponMotionBuilder() {
/* 132 */     CapabilityItem mainHandCap = getHoldingItemCapability(InteractionHand.MAIN_HAND);
/* 133 */     CECombatBehaviors.Builder<MobPatch<?>> customOverride = MobPatchCommon.overideBowMotionBuilderForNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this));
/* 134 */     return (customOverride != null) ? customOverride : super.getCustomWeaponMotionBuilder();
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 138 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 142 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 144 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 148 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 152 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 156 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 161 */     super.onGuardHit(damageSource);
/* 162 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 163 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */   
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 168 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 173 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 174 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 176 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 182 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 187 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 192 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\VillagerScoutCaptainPatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */