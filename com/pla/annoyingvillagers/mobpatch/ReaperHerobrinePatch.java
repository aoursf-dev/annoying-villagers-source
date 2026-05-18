/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineEnderSlayerScythe;
/*     */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.EscapeUtil;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
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
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
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
/*     */ import yesman.epicfight.world.damagesource.EpicFightDamageSource;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class ReaperHerobrinePatch
/*     */   extends CEHumanoidPatch
/*     */   implements CustomExecuteEntity {
/*     */   public ReaperHerobrinePatch() {
/*  53 */     super(Factions.UNDEAD);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  57 */     super.initAnimator(animator);
/*  58 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  59 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  60 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  61 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  62 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  63 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  67 */     this.weaponLivingMotions
/*  68 */       .put(CapabilityItem.WeaponCategories.SPEAR, 
/*  69 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*     */           
/*  71 */           Set.of(
/*  72 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/*  73 */             Pair.of(LivingMotions.IDLE, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE), 
/*  74 */             Pair.of(LivingMotions.WALK, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE), 
/*  75 */             Pair.of(LivingMotions.RUN, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE), 
/*  76 */             Pair.of(LivingMotions.CHASE, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE), 
/*  77 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH)), CapabilityItem.Styles.MOUNT, 
/*     */ 
/*     */           
/*  80 */           Set.of(
/*  81 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/*  82 */             Pair.of(LivingMotions.IDLE, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE), 
/*  83 */             Pair.of(LivingMotions.WALK, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE), 
/*  84 */             Pair.of(LivingMotions.RUN, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE), 
/*  85 */             Pair.of(LivingMotions.CHASE, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE), 
/*  86 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/*  89 */     this.weaponAttackMotions
/*  90 */       .put(CapabilityItem.WeaponCategories.SPEAR, 
/*  91 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, HerobrineEnderSlayerScythe.ENDER_SLAYER_SCYTHE, CapabilityItem.Styles.MOUNT, HerobrineEnderSlayerScythe.ENDER_SLAYER_SCYTHE));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SPEAR, 
/*  97 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/*  98 */           List.of(Animations.SPEAR_GUARD_HIT), CapabilityItem.Styles.MOUNT, 
/*     */ 
/*     */           
/* 101 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardHitAnimation(DamageSource damageSource, boolean canCounter) {
/* 110 */     if (ModList.get().isLoaded("efn")) { Entity entity = getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity; if (herobrineMob.getLivingEntityPatch() != null)
/* 111 */         { EpicFightNightFall.playEfnGuardHit(herobrineMob.getLivingEntityPatch(), herobrineMob.getEfnGuardHitState(), damageSource);
/* 112 */           herobrineMob.postPlayEfnGuardHit(); return; }  }
/*     */        }
/* 114 */      super.playGuardHitAnimation(damageSource, canCounter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void playGuardHitSound() {
/* 120 */     if (!ModList.get().isLoaded("efn"))
/*     */     {
/* 122 */       super.playGuardHitSound();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean dealStaminaDamage(DamageSource damageSource, float amount) {
/* 128 */     if (ModList.get().isLoaded("efn") && EpicFightNightFall.isPlayingEfnGuardHit(this)) {
/* 129 */       return false;
/*     */     }
/* 131 */     return super.dealStaminaDamage(damageSource, amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AttackResult tryHurt(DamageSource damageSource, float amount) {
/* 137 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getAnimator().getPlayerFor(null))).getRealAnimation();
/* 138 */     if (!getOriginal().m_20159_() && 
/* 139 */       !EpicfightUtil.isLongHitAnimation(dynamicAnimation, (LivingEntityPatch)this) && 
/* 140 */       getOriginal().m_9236_() instanceof ServerLevel && dynamicAnimation == Animations.EMPTY_ANIMATION) {
/* 141 */       if ((new Random()).nextFloat() <= 0.3F) {
/* 142 */         float chance = (new Random()).nextFloat();
/* 143 */         if (chance <= 0.25F) {
/* 144 */           playAnimationSynchronized((AssetAccessor)WOMAnimations.ENDERSTEP_BACKWARD, 0.0F);
/* 145 */         } else if (chance <= 0.5F) {
/* 146 */           playAnimationSynchronized((AssetAccessor)WOMAnimations.ENDERSTEP_FORWARD, 0.0F);
/* 147 */         } else if (chance <= 0.75F) {
/* 148 */           playAnimationSynchronized((AssetAccessor)WOMAnimations.ENDERSTEP_RIGHT, 0.0F);
/*     */         } else {
/* 150 */           playAnimationSynchronized((AssetAccessor)WOMAnimations.ENDERSTEP_RIGHT, 0.0F);
/*     */         } 
/*     */       } else {
/* 153 */         EscapeUtil.stepLeftRightOnHurtByDangerousAnimation(damageSource, (MobPatch)this);
/*     */       } 
/*     */     } else {
/* 156 */       EscapeUtil.stepLeftRightOnHurtByDangerousAnimation(damageSource, (MobPatch)this);
/*     */     } 
/* 158 */     return super.tryHurt(damageSource, amount);
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 162 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 166 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 168 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 172 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 176 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 180 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 185 */     super.onGuardHit(damageSource);
/* 186 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 187 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */     
/* 189 */     EpicfightUtil.breakWeaponOnParryOpAttack(damageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBlockableSource(DamageSource damageSource) {
/* 194 */     return true;
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 198 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 203 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 204 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 206 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 212 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 222 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\ReaperHerobrinePatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */