/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineCommon;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineObsidianWeapon;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.EscapeUtil;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
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
/*     */ import yesman.epicfight.api.animation.AnimationManager;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
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
/*     */ public class HerobrineClonePatch
/*     */   extends CEHumanoidPatch
/*     */   implements CustomExecuteEntity
/*     */ {
/*     */   public HerobrineClonePatch() {
/*  48 */     super(Factions.NEUTRAL);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  52 */     super.initAnimator(animator);
/*  53 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  54 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  55 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  56 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  57 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  58 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  62 */     this.weaponLivingMotions
/*  63 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  64 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/*  66 */           Set.of(
/*  67 */             Pair.of(LivingMotions.BLOCK, AVAnimations.FIST_GUARD), 
/*  68 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  69 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  70 */             Pair.of(LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN), 
/*  71 */             Pair.of(LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN), 
/*  72 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/*  75 */     this.weaponAttackMotions
/*  76 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  77 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, HerobrineObsidianWeapon.OBSIDIAN_WEAPON));
/*     */ 
/*     */ 
/*     */     
/*  81 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/*  82 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*  83 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttackResult tryHurt(DamageSource damageSource, float amount) {
/*  94 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getAnimator().getPlayerFor(null))).getRealAnimation();
/*  95 */     if (HerobrineCommon.canPlaySecondFormAnimation((MobPatch)this) && 
/*  96 */       !EpicfightUtil.isLongHitAnimation(dynamicAnimation, (LivingEntityPatch)this) && 
/*  97 */       getOriginal().m_9236_() instanceof ServerLevel && dynamicAnimation == Animations.EMPTY_ANIMATION) {
/*  98 */       return AttackResult.blocked(amount);
/*     */     }
/* 100 */     EscapeUtil.stepLeftRightOnHurtByDangerousAnimation(damageSource, (MobPatch)this);
/* 101 */     return super.tryHurt(damageSource, amount);
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 105 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 109 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 113 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBlockableSource(DamageSource damageSource) {
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 123 */     super.onGuardHit(damageSource);
/* 124 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 125 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 127 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 131 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 136 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 137 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 139 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 145 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 155 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\HerobrineClonePatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */