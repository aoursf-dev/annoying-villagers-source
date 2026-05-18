/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcDagger;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcFist;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcSword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NpcTachi;
/*     */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.entity.GreenVillagerGeneralEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.MobPatchCommon;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.level.ServerLevel;
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
/*     */ public class VillagerGeneralPatch extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public VillagerGeneralPatch() {
/*  47 */     super(Factions.NEUTRAL);
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
/*  62 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  63 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  64 */           Set.of(
/*  65 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  66 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  67 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  68 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  69 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  71 */     this.weaponAttackMotions
/*  72 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  73 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcFist.FIST));
/*     */     
/*  75 */     this.weaponLivingMotions
/*  76 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  77 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  78 */           Set.of(
/*  79 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  80 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  81 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  82 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  83 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  85 */     this.weaponAttackMotions
/*  86 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  87 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcFist.FIST));
/*     */     
/*  89 */     this.weaponLivingMotions
/*  90 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  91 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/*  93 */           Set.of(
/*  94 */             Pair.of(LivingMotions.BLOCK, Animations.SWORD_GUARD), 
/*  95 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  96 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  97 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/*  98 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/*  99 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 102 */     this.weaponAttackMotions
/* 103 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/* 104 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcSword.AV_SWORD));
/*     */ 
/*     */ 
/*     */     
/* 108 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/* 109 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 110 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     this.weaponLivingMotions
/* 119 */       .put(CapabilityItem.WeaponCategories.TACHI, 
/* 120 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/* 122 */           Set.of(
/* 123 */             Pair.of(LivingMotions.BLOCK, Animations.LONGSWORD_GUARD), 
/* 124 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_HOLD_TACHI), 
/* 125 */             Pair.of(LivingMotions.WALK, Animations.BIPED_HOLD_TACHI), 
/* 126 */             Pair.of(LivingMotions.RUN, Animations.BIPED_HOLD_TACHI), 
/* 127 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_HOLD_TACHI), 
/* 128 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 131 */     this.weaponAttackMotions
/* 132 */       .put(CapabilityItem.WeaponCategories.TACHI, 
/* 133 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, NpcTachi.AV_DUAL_TACHI));
/*     */ 
/*     */ 
/*     */     
/* 137 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.TACHI, 
/* 138 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 139 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     this.weaponLivingMotions
/* 148 */       .put(CapabilityItem.WeaponCategories.DAGGER, 
/* 149 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/* 151 */           Set.of(
/* 152 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 153 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 154 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/* 155 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/* 156 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH)), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/* 159 */           Set.of(
/* 160 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 161 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 162 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/* 163 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/* 164 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 167 */     this.weaponAttackMotions
/* 168 */       .put(CapabilityItem.WeaponCategories.DAGGER, 
/* 169 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NpcDagger.DAGGER, CapabilityItem.Styles.TWO_HAND, NpcDagger.DUAL_DAGGER));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.DAGGER, 
/* 175 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 176 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 181 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CECombatBehaviors.Builder<MobPatch<?>> getCustomWeaponMotionBuilder() {
/* 192 */     CapabilityItem mainHandCap = getHoldingItemCapability(InteractionHand.MAIN_HAND);
/* 193 */     CECombatBehaviors.Builder<MobPatch<?>> customOverride = MobPatchCommon.overideBowMotionBuilderForNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this));
/* 194 */     return (customOverride != null) ? customOverride : super.getCustomWeaponMotionBuilder();
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 198 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 202 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 204 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 208 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 212 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 216 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void playGuardHitAnimation(DamageSource damageSource, boolean canCounter) {
/* 221 */     if (ModList.get().isLoaded("efn")) { Entity entity = getOriginal(); if (entity instanceof GreenVillagerGeneralEntity) { GreenVillagerGeneralEntity greenVillagerGeneralEntity = (GreenVillagerGeneralEntity)entity; if (greenVillagerGeneralEntity.getLivingEntityPatch() != null)
/* 222 */         { EpicFightNightFall.playEfnGuardHit(greenVillagerGeneralEntity.getLivingEntityPatch(), greenVillagerGeneralEntity.getEfnGuardHitState(), damageSource);
/* 223 */           greenVillagerGeneralEntity.postPlayEfnGuardHit(); return; }  }
/*     */        }
/* 225 */      super.playGuardHitAnimation(damageSource, canCounter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardHitSound() {
/* 231 */     if (!ModList.get().isLoaded("efn") || !(getOriginal() instanceof GreenVillagerGeneralEntity))
/*     */     {
/* 233 */       super.playGuardHitSound();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean dealStaminaDamage(DamageSource damageSource, float amount) {
/* 239 */     if (ModList.get().isLoaded("efn") && EpicFightNightFall.isPlayingEfnGuardHit(this)) {
/* 240 */       return false;
/*     */     }
/* 242 */     return super.dealStaminaDamage(damageSource, amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 248 */     super.onGuardHit(damageSource);
/* 249 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 250 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */   
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 255 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 260 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 261 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 263 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 269 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 274 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 279 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\VillagerGeneralPatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */