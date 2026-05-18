/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.NullWeaponSword;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
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
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.damagesource.EpicFightDamageSource;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class NullWeaponPatch
/*     */   extends CEHumanoidPatch
/*     */   implements CustomExecuteEntity {
/*     */   public NullWeaponPatch() {
/*  43 */     super(Factions.NEUTRAL);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  47 */     super.initAnimator(animator);
/*  48 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  49 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  50 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  51 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  52 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  53 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  57 */     this.weaponLivingMotions
/*  58 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  59 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/*  61 */           Set.of(
/*  62 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/*  63 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  64 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  65 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/*  66 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/*  67 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/*  70 */     this.weaponAttackMotions
/*  71 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  72 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NullWeaponSword.SWORD));
/*     */ 
/*     */ 
/*     */     
/*  76 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/*  77 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  78 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     this.weaponLivingMotions
/*  87 */       .put(CapabilityItem.WeaponCategories.AXE, 
/*  88 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/*  90 */           Set.of(
/*  91 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/*  92 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  93 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  94 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/*  95 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/*  96 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/*  99 */     this.weaponAttackMotions
/* 100 */       .put(CapabilityItem.WeaponCategories.AXE, 
/* 101 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NullWeaponSword.SWORD));
/*     */ 
/*     */ 
/*     */     
/* 105 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.AXE, 
/* 106 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 107 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.weaponLivingMotions
/* 116 */       .put(CapabilityItem.WeaponCategories.PICKAXE, 
/* 117 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/* 119 */           Set.of(
/* 120 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/* 121 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 122 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 123 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/* 124 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/* 125 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 128 */     this.weaponAttackMotions
/* 129 */       .put(CapabilityItem.WeaponCategories.PICKAXE, 
/* 130 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NullWeaponSword.SWORD));
/*     */ 
/*     */ 
/*     */     
/* 134 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.PICKAXE, 
/* 135 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 136 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     this.weaponLivingMotions
/* 145 */       .put(CapabilityItem.WeaponCategories.SHOVEL, 
/* 146 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/* 148 */           Set.of(
/* 149 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/* 150 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 151 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 152 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/* 153 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/* 154 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 157 */     this.weaponAttackMotions
/* 158 */       .put(CapabilityItem.WeaponCategories.SHOVEL, 
/* 159 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NullWeaponSword.SWORD));
/*     */ 
/*     */ 
/*     */     
/* 163 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SHOVEL, 
/* 164 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 165 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     this.weaponLivingMotions
/* 174 */       .put(CapabilityItem.WeaponCategories.HOE, 
/* 175 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/* 177 */           Set.of(
/* 178 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/* 179 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 180 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 181 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/* 182 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/* 183 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 186 */     this.weaponAttackMotions
/* 187 */       .put(CapabilityItem.WeaponCategories.HOE, 
/* 188 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, NullWeaponSword.SWORD));
/*     */ 
/*     */ 
/*     */     
/* 192 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.HOE, 
/* 193 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 194 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardBreakSound() {
/* 204 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 208 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 210 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 214 */     return attackresult;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBlockableSource(DamageSource damageSource) {
/* 219 */     return true;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 223 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 227 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 232 */     super.onGuardHit(damageSource);
/* 233 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 234 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 236 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 240 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 245 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 246 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 248 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 254 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 259 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 264 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\NullWeaponPatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */