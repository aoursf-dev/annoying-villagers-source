/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineShadowObsidianSword;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.EscapeUtil;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.shelmarow.combat_evolution.ai.CEHumanoidPatch;
/*     */ import net.shelmarow.combat_evolution.ai.iml.CustomExecuteEntity;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsMoonless;
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
/*     */ 
/*     */ public class ArmoredHerobrinePatch
/*     */   extends CEHumanoidPatch
/*     */   implements CustomExecuteEntity
/*     */ {
/*     */   public ArmoredHerobrinePatch() {
/*  46 */     super(Factions.NEUTRAL);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  50 */     super.initAnimator(animator);
/*  51 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  52 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  53 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  54 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  55 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  56 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  60 */     this.weaponLivingMotions
/*  61 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  62 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/*  64 */           Set.of(
/*  65 */             Pair.of(LivingMotions.BLOCK, AnimsMoonless.MOONLESS_GUARD), 
/*  66 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  67 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  68 */             Pair.of(LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN), 
/*  69 */             Pair.of(LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN), 
/*  70 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH)), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/*  73 */           Set.of(
/*  74 */             Pair.of(LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD), 
/*  75 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  76 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  77 */             Pair.of(LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN), 
/*  78 */             Pair.of(LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN), 
/*  79 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/*  82 */     this.weaponAttackMotions
/*  83 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  84 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, HerobrineShadowObsidianSword.SHADOW_OBSIDIAN_SWORD, CapabilityItem.Styles.TWO_HAND, HerobrineShadowObsidianSword.SHADOW_OBSIDIAN_DUAL_SWORD));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/*  90 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  91 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  96 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardBreakSound() {
/* 104 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 108 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 112 */     super.onDeath(livingDeathEvent);
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
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 128 */     super.onGuardHit(damageSource);
/* 129 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 130 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 132 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 136 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 141 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 142 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 144 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 150 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 160 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\ArmoredHerobrinePatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */