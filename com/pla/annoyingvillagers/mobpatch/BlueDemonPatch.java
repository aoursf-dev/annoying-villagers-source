/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.BlueDemonLegendarySword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.BlueDemonTrident;
/*     */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
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
/*     */ 
/*     */ 
/*     */ public class BlueDemonPatch
/*     */   extends CEHumanoidPatch
/*     */   implements CustomExecuteEntity
/*     */ {
/*     */   public BlueDemonPatch() {
/*  52 */     super(Factions.NEUTRAL);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  56 */     super.initAnimator(animator);
/*  57 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  58 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  59 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  60 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  61 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  62 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  66 */     this.weaponLivingMotions
/*  67 */       .put(CapabilityItem.WeaponCategories.SPEAR, 
/*  68 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/*  70 */           Set.of(
/*  71 */             Pair.of(LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD), 
/*  72 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON), 
/*  73 */             Pair.of(LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON), 
/*  74 */             Pair.of(LivingMotions.RUN, AVAnimations.TRIDENT_TWO_HAND_RUN), 
/*  75 */             Pair.of(LivingMotions.CHASE, AVAnimations.TRIDENT_TWO_HAND_RUN), 
/*  76 */             Pair.of(LivingMotions.DEATH, AVAnimations.BLUE_DEMON_STATE_TRANSFORM))));
/*     */ 
/*     */ 
/*     */     
/*  80 */     this.weaponAttackMotions
/*  81 */       .put(CapabilityItem.WeaponCategories.SPEAR, 
/*  82 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, BlueDemonTrident.TRIDENT));
/*     */ 
/*     */ 
/*     */     
/*  86 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SPEAR, 
/*  87 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*  88 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     this.weaponLivingMotions
/*  95 */       .put(CapabilityItem.WeaponCategories.GREATSWORD, 
/*  96 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/*  98 */           Set.of(
/*  99 */             Pair.of(LivingMotions.BLOCK, AVAnimations.LEGENDARY_SWORD_GUARD), 
/* 100 */             Pair.of(LivingMotions.IDLE, AVAnimations.LEGENDARY_SWORD_IDLE), 
/* 101 */             Pair.of(LivingMotions.WALK, AVAnimations.TORMENT_BERSERK_WALK), 
/* 102 */             Pair.of(LivingMotions.RUN, AVAnimations.RUN_DUAL_BIG), 
/* 103 */             Pair.of(LivingMotions.CHASE, AVAnimations.RUN_DUAL_BIG), 
/* 104 */             Pair.of(LivingMotions.DEATH, AVAnimations.BLUE_DEMON_DIE_LEGENDARY_SWORD_TICK))));
/*     */ 
/*     */     
/* 107 */     this.weaponAttackMotions
/* 108 */       .put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 109 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, BlueDemonLegendarySword.LEGENDARY_SWORD));
/*     */ 
/*     */ 
/*     */     
/* 113 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 114 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 115 */           List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardBreakSound() {
/* 123 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 127 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 131 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 136 */     super.onGuardHit(damageSource);
/* 137 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 138 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 140 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBlockableSource(DamageSource damageSource) {
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AttackResult tryHurt(DamageSource damageSource, float amount) {
/* 150 */     EscapeUtil.stepLeftRightOnHurtByDangerousAnimation(damageSource, (MobPatch)this);
/* 151 */     return super.tryHurt(damageSource, amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void playGuardHitAnimation(DamageSource damageSource, boolean canCounter) {
/* 156 */     if (ModList.get().isLoaded("efn")) { Entity entity = getOriginal(); if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemon = (BlueDemonEntity)entity; if (blueDemon.getLivingEntityPatch() != null)
/* 157 */         { EpicFightNightFall.playEfnGuardHit(blueDemon.getLivingEntityPatch(), blueDemon.getEfnGuardHitState(), damageSource);
/* 158 */           blueDemon.postPlayEfnGuardHit(); return; }  }
/*     */        }
/* 160 */      super.playGuardHitAnimation(damageSource, canCounter);
/*     */   }
/*     */ 
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


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\BlueDemonPatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */