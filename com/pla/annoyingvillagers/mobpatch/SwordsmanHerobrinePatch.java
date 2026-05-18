/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineDemoniacVoltageReaver;
/*     */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
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
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.shelmarow.combat_evolution.ai.CEHumanoidPatch;
/*     */ import net.shelmarow.combat_evolution.ai.iml.CustomExecuteEntity;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
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
/*     */ public class SwordsmanHerobrinePatch extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public SwordsmanHerobrinePatch() {
/*  47 */     super(Factions.UNDEAD);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  51 */     super.initAnimator(animator);
/*  52 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  53 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  54 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  55 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  56 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  57 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  61 */     this.weaponLivingMotions
/*  62 */       .put(CapabilityItem.WeaponCategories.GREATSWORD, 
/*  63 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/*  65 */           Set.of(
/*  66 */             Pair.of(LivingMotions.BLOCK, AnimsSolar.SOLAR_GUARD), 
/*  67 */             Pair.of(LivingMotions.IDLE, AVAnimations.VALOUR_HOLD_GREATSWORD), 
/*  68 */             Pair.of(LivingMotions.WALK, AVAnimations.VALOUR_WALK_GREATSWORD), 
/*  69 */             Pair.of(LivingMotions.RUN, AVAnimations.VALOUR_RUN_GREATSWORD), 
/*  70 */             Pair.of(LivingMotions.CHASE, AVAnimations.VALOUR_RUN_GREATSWORD), 
/*  71 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/*  74 */     this.weaponAttackMotions
/*  75 */       .put(CapabilityItem.WeaponCategories.GREATSWORD, 
/*  76 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, HerobrineDemoniacVoltageReaver.DEMONIAC_VOLTAGE_REAVER));
/*     */ 
/*     */ 
/*     */     
/*  80 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.GREATSWORD, 
/*  81 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*  82 */           List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBlockableSource(DamageSource damageSource) {
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AttackResult tryHurt(DamageSource damageSource, float amount) {
/*  96 */     EscapeUtil.stepLeftRightOnHurtByDangerousAnimation(damageSource, (MobPatch)this);
/*  97 */     return super.tryHurt(damageSource, amount);
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 101 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 105 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 107 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 111 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 115 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 119 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void playGuardHitAnimation(DamageSource damageSource, boolean canCounter) {
/* 124 */     if (ModList.get().isLoaded("efn")) { Entity entity = getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity; if (herobrineMob.getLivingEntityPatch() != null)
/* 125 */         { EpicFightNightFall.playEfnGuardHit(herobrineMob.getLivingEntityPatch(), herobrineMob.getEfnGuardHitState(), damageSource);
/* 126 */           herobrineMob.postPlayEfnGuardHit(); return; }  }
/*     */        }
/* 128 */      super.playGuardHitAnimation(damageSource, canCounter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardHitSound() {
/* 134 */     if (!ModList.get().isLoaded("efn"))
/*     */     {
/* 136 */       super.playGuardHitSound();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean dealStaminaDamage(DamageSource damageSource, float amount) {
/* 142 */     if (ModList.get().isLoaded("efn") && EpicFightNightFall.isPlayingEfnGuardHit(this)) {
/* 143 */       return false;
/*     */     }
/* 145 */     return super.dealStaminaDamage(damageSource, amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 151 */     super.onGuardHit(damageSource);
/* 152 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 153 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 155 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 159 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 164 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 165 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 167 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 173 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 183 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\SwordsmanHerobrinePatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */