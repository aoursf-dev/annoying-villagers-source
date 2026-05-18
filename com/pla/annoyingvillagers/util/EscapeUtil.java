/*     */ package com.pla.annoyingvillagers.util;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.entity.AngrySteveEntity;
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import reascer.wom.animation.attacks.BasicMultipleAttackAnimation;
/*     */ import reascer.wom.animation.attacks.SpecialAttackAnimation;
/*     */ import reascer.wom.animation.attacks.UltimateAttackAnimation;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsHerrscher;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsMoonless;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsNapoleon;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.ActionAnimation;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ public class EscapeUtil {
/*  31 */   private static final Set<String> DANGEROUS_ANIMATIONS = new HashSet<>();
/*     */   
/*     */   static {
/*  34 */     DANGEROUS_ANIMATIONS.addAll(Set.of((Object[])new String[] { ((BasicMultipleAttackAnimation)AVAnimations.ENDER_AEGIS_BULL_CHARGE
/*  35 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3
/*  36 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AVAnimations.ENDER_GLAIVE_NAPOLEON_SHOOT_3
/*  37 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)AVAnimations.ENDER_GLAIVE_AGONY_AUTO_1
/*  38 */             .get()).getRegistryName().toString(), ((ActionAnimation)AVAnimations.AEGIS_SHIELD_SHOOT
/*  39 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT
/*  40 */             .get()).getRegistryName().toString(), ((ActionAnimation)AVAnimations.TRIDENT_ATTACK
/*  41 */             .get()).getRegistryName().toString(), ((StaticAnimation)AVAnimations.BLUE_DEMON_STATE_TRANSFORM
/*  42 */             .get()).getRegistryName().toString(), ((ActionAnimation)AVAnimations.ELECTRIC_FIELD
/*  43 */             .get()).getRegistryName().toString(), ((StaticAnimation)AVAnimations.SNAKE_BLADE_GUARD
/*  44 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AnimsAgony.AGONY_SKY_DIVE_X
/*  45 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AnimsAgony.AGONY_SKY_DIVE
/*  46 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)WOMAnimations.TORMENT_CHARGED_ATTACK_2
/*  47 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)WOMAnimations.TORMENT_CHARGED_ATTACK_3
/*  48 */             .get()).getRegistryName().toString(), ((StaticAnimation)AnimsRuine.RUINE_PLUNDER
/*  49 */             .get()).getRegistryName().toString(), ((UltimateAttackAnimation)WOMAnimations.ANTITHEUS_LAPSE
/*  50 */             .get()).getRegistryName().toString(), ((UltimateAttackAnimation)WOMAnimations.ANTITHEUS_ASCENSION
/*  51 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)WOMAnimations.ANTITHEUS_ASCENDED_BLACKHOLE
/*  52 */             .get()).getRegistryName().toString(), ((UltimateAttackAnimation)WOMAnimations.TORMENT_BERSERK_CONVERT
/*  53 */             .get()).getRegistryName().toString(), ((UltimateAttackAnimation)AnimsSatsujin.SATSUJIN_GESSHOKU
/*  54 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)AnimsHerrscher.GESETZ_AUTO_3
/*  55 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)AnimsHerrscher.GESETZ_SPRENGKOPF
/*  56 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)AnimsHerrscher.GESETZ_WIDERSTAND
/*  57 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AnimsMoonless.MOONLESS_LUNAR_ECHO
/*  58 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AnimsMoonless.MOONLESS_LUNAR_ECLIPSE
/*  59 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AnimsMoonless.MOONLESS_LUNAR_FULLMOON
/*  60 */             .get()).getRegistryName().toString(), ((BasicMultipleAttackAnimation)AnimsSolar.SOLAR_BRASERO
/*  61 */             .get()).getRegistryName().toString(), ((UltimateAttackAnimation)AnimsSolar.SOLAR_BRASERO_OBSCURIDAD
/*  62 */             .get()).getRegistryName().toString(), ((UltimateAttackAnimation)AnimsSolar.SOLAR_BRASERO_CREMATORIO
/*  63 */             .get()).getRegistryName().toString(), ((UltimateAttackAnimation)AnimsSolar.SOLAR_BRASERO_INFIERNO
/*  64 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AnimsNapoleon.NAPOLEON_AUSTERLITZ_SHOOT
/*  65 */             .get()).getRegistryName().toString(), ((SpecialAttackAnimation)AnimsNapoleon.NAPOLEON_WATERLOW_SHOOT
/*  66 */             .get()).getRegistryName().toString(), ((ActionAnimation)AnimsOrbit.ORBIT_LIGHT_BEAM
/*  67 */             .get()).getRegistryName().toString() }));
/*     */ 
/*     */     
/*  70 */     if (ModList.get().isLoaded("efn")) {
/*     */       try {
/*  72 */         DANGEROUS_ANIMATIONS.addAll(EpicFightNightFall.getDangerousAnimations());
/*  73 */       } catch (Exception e) {
/*  74 */         e.fillInStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*  78 */     if (ModList.get().isLoaded("sword_soaring")) {
/*     */       try {
/*  80 */         DANGEROUS_ANIMATIONS.addAll(EpicFightSwordSoaring.getDangerousAnimations());
/*  81 */       } catch (Exception e) {
/*  82 */         e.fillInStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*  86 */     if (ModList.get().isLoaded("cdmoveset")) {
/*     */       try {
/*  88 */         DANGEROUS_ANIMATIONS.addAll(EpicFightResurrection.getDangerousAnimations());
/*  89 */       } catch (Exception e) {
/*  90 */         e.fillInStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean isAnimationDangerous(AssetAccessor<? extends StaticAnimation> targetDynamicAnimation) {
/*  96 */     if (targetDynamicAnimation != null && ((StaticAnimation)targetDynamicAnimation.get()).getRegistryName() != null) {
/*  97 */       String animation = ((StaticAnimation)targetDynamicAnimation.get()).getRegistryName().toString();
/*  98 */       return DANGEROUS_ANIMATIONS.contains(animation);
/*     */     } 
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean checkEscape(Mob mob) {
/* 104 */     LivingEntity target = mob.m_5448_();
/* 105 */     LivingEntityPatch<?> targetLivingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)target, LivingEntityPatch.class);
/* 106 */     if (target == null || targetLivingEntityPatch == null) return false; 
/* 107 */     AssetAccessor<? extends StaticAnimation> targetDynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(targetLivingEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 108 */     return (isAnimationDangerous(targetDynamicAnimation) || targetDynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation);
/*     */   }
/*     */   public static void stepLeftRightOnHurtByDangerousAnimation(DamageSource damageSource, MobPatch<?> mobPatch) {
/*     */     LivingEntity livingEntity;
/* 112 */     Entity target = damageSource.m_7639_();
/* 113 */     if (target instanceof LivingEntity) { livingEntity = (LivingEntity)target; } else { return; }
/* 114 */      LivingEntityPatch<?> targetEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)livingEntity, LivingEntityPatch.class);
/* 115 */     if (targetEntityPatch != null) {
/* 116 */       AssetAccessor<? extends StaticAnimation> targetDynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(targetEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 117 */       AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(mobPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 118 */       if (isAnimationDangerous(targetDynamicAnimation) && 
/* 119 */         !EpicfightUtil.isLongHitAnimation(dynamicAnimation, (LivingEntityPatch<?>)mobPatch)) {
/* 120 */         Entity entity = mobPatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity; if (herobrineMob
/* 121 */             .getStunEscapeCooldown() == 0) {
/* 122 */             herobrineMob.setStunEscapeCooldown(60);
/* 123 */             if ((new Random()).nextBoolean()) {
/* 124 */               mobPatch.playAnimationSynchronized((AssetAccessor)WOMAnimations.ENDERSTEP_LEFT, 0.0F);
/*     */             } else {
/* 126 */               mobPatch.playAnimationSynchronized((AssetAccessor)WOMAnimations.ENDERSTEP_RIGHT, 0.0F);
/*     */             } 
/*     */           }  }
/*     */         
/* 130 */         entity = mobPatch.getOriginal(); if (entity instanceof AngrySteveEntity) { AngrySteveEntity angrySteveEntity = (AngrySteveEntity)entity; if (angrySteveEntity
/* 131 */             .getStunEscapeCooldown() == 0) {
/* 132 */             angrySteveEntity.setStunEscapeCooldown(60);
/* 133 */             if ((new Random()).nextBoolean()) {
/* 134 */               mobPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_STEP_LEFT, 0.0F);
/*     */             } else {
/* 136 */               mobPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_STEP_RIGHT, 0.0F);
/*     */             } 
/*     */           }  }
/*     */         
/* 140 */         entity = mobPatch.getOriginal(); if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity; if (blueDemonEntity
/* 141 */             .getStunEscapeCooldown() == 0) {
/* 142 */             blueDemonEntity.setStunEscapeCooldown(60);
/* 143 */             if ((new Random()).nextBoolean()) {
/* 144 */               mobPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_STEP_LEFT, 0.0F);
/*     */             } else {
/* 146 */               mobPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_STEP_RIGHT, 0.0F);
/*     */             } 
/*     */           }  }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\EscapeUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */