/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineNullWeapon;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.EscapeUtil;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.shelmarow.combat_evolution.ai.CEHumanoidPatch;
/*     */ import net.shelmarow.combat_evolution.ai.iml.CustomExecuteEntity;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*     */ import reascer.wom.gameasset.WOMAnimations;
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
/*     */ public class NullPatch extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public NullPatch() {
/*  42 */     super(Factions.UNDEAD);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  46 */     super.initAnimator(animator);
/*  47 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)AVAnimations.FIST_GUARD);
/*  48 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_CREATIVE_IDLE);
/*  49 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_CREATIVE_IDLE);
/*  50 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_CREATIVE_IDLE);
/*  51 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_CREATIVE_IDLE);
/*  52 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  56 */     this.weaponLivingMotions
/*  57 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  58 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/*  60 */           Set.of(
/*  61 */             Pair.of(LivingMotions.BLOCK, AVAnimations.FIST_GUARD), 
/*  62 */             Pair.of(LivingMotions.IDLE, AVAnimations.CLONE_ANTITHEUS_ASCENDED_IDLE), 
/*  63 */             Pair.of(LivingMotions.WALK, WOMAnimations.ANTITHEUS_ASCENDED_WALK), 
/*  64 */             Pair.of(LivingMotions.RUN, WOMAnimations.ANTITHEUS_ASCENDED_RUN), 
/*  65 */             Pair.of(LivingMotions.CHASE, WOMAnimations.ANTITHEUS_ASCENDED_RUN), 
/*  66 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/*  69 */     this.weaponAttackMotions
/*  70 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  71 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, HerobrineNullWeapon.NULL_WEAPON));
/*     */ 
/*     */ 
/*     */     
/*  75 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/*  76 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*  77 */           List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardBreakSound() {
/*  85 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/*  89 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/*  91 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/*  95 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/*  99 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 103 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 108 */     super.onGuardHit(damageSource);
/* 109 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 110 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 112 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBlockableSource(DamageSource damageSource) {
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AttackResult tryHurt(DamageSource damageSource, float amount) {
/* 122 */     EscapeUtil.stepLeftRightOnHurtByDangerousAnimation(damageSource, (MobPatch)this);
/* 123 */     return super.tryHurt(damageSource, amount);
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 127 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 132 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 133 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 135 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 141 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 151 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\NullPatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */