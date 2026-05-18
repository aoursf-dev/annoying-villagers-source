/*     */ package com.pla.annoyingvillagers.util;
/*     */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.shelmarow.combat_evolution.ai.CEHumanoidPatch;
/*     */ import net.shelmarow.combat_evolution.ai.util.CEPatchUtils;
/*     */ import net.shelmarow.combat_evolution.effect.CEMobEffects;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionHandler;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.Joint;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*     */ import yesman.epicfight.api.utils.math.Vec3f;
/*     */ import yesman.epicfight.gameasset.EpicFightSounds;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.damagesource.EpicFightDamageSource;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class EpicfightUtil {
/*     */   public static Vec3 getJointWithTranslation(Entity entity, Vec3f translation, Joint joint, float handToTip, double yOffset) {
/*  41 */     LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/*  42 */     if (livingEntityPatch == null) return null;
/*     */     
/*  44 */     float interpolation = 0.0F;
/*     */     
/*  46 */     OpenMatrix4f m = livingEntityPatch.getArmature().getBoundTransformFor(livingEntityPatch.getAnimator().getPose(interpolation), joint);
/*     */     
/*  48 */     if (translation != null) {
/*  49 */       OpenMatrix4f tLocal = (new OpenMatrix4f()).translate(translation);
/*  50 */       OpenMatrix4f.mul(m, tLocal, m);
/*     */     } 
/*     */     
/*  53 */     if (handToTip != 0.0F) {
/*  54 */       OpenMatrix4f tipOffset = (new OpenMatrix4f()).translate(new Vec3f(0.0F, 0.0F, -handToTip));
/*  55 */       OpenMatrix4f.mul(m, tipOffset, m);
/*     */     } 
/*     */     
/*  58 */     float yawRad = (float)-Math.toRadians((((LivingEntity)livingEntityPatch.getOriginal()).f_20884_ + 180.0F));
/*  59 */     OpenMatrix4f worldYaw = (new OpenMatrix4f()).rotate(yawRad, new Vec3f(0.0F, 1.0F, 0.0F));
/*  60 */     OpenMatrix4f.mul(worldYaw, m, m);
/*     */     
/*  62 */     LivingEntity base = (LivingEntity)livingEntityPatch.getOriginal();
/*  63 */     return new Vec3(m.m30 + base
/*  64 */         .m_20185_(), m.m31 + base
/*  65 */         .m_20186_() + entity.m_20206_() / 1.8D - 1.0D + yOffset, m.m32 + base
/*  66 */         .m_20189_());
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isLongHitAnimationNotExecutedAnimation(AssetAccessor<? extends StaticAnimation> dynamicAnimation, LivingEntityPatch<?> livingEntityPatch) {
/*  71 */     return (!(dynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionHitAnimation) && (dynamicAnimation
/*  72 */       .get() instanceof yesman.epicfight.api.animation.types.KnockdownAnimation || (
/*  73 */       ModList.get().isLoaded("efn") && EpicFightNightFall.isEFNStun(dynamicAnimation)) || 
/*  74 */       ExecutionHandler.isTargetGuardBreak(dynamicAnimation, livingEntityPatch)));
/*     */   }
/*     */   
/*     */   public static boolean isLongHitAnimation(AssetAccessor<? extends StaticAnimation> dynamicAnimation, LivingEntityPatch<?> livingEntityPatch) {
/*  78 */     return (dynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionHitAnimation || dynamicAnimation
/*  79 */       .get() instanceof yesman.epicfight.api.animation.types.KnockdownAnimation || (
/*  80 */       ModList.get().isLoaded("efn") && EpicFightNightFall.isEFNStun(dynamicAnimation)) || 
/*  81 */       ExecutionHandler.isTargetGuardBreak(dynamicAnimation, livingEntityPatch));
/*     */   }
/*     */   
/*     */   public static boolean isDamagableHitAnimation(AssetAccessor<? extends StaticAnimation> dynamicAnimation, LivingEntityPatch<?> livingEntityPatch) {
/*  85 */     return (dynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionHitAnimation || dynamicAnimation
/*  86 */       .get() instanceof yesman.epicfight.api.animation.types.KnockdownAnimation || 
/*  87 */       ExecutionHandler.isTargetGuardBreak(dynamicAnimation, livingEntityPatch));
/*     */   }
/*     */   
/*     */   public static void dealStaminaDamageByPercentage(DamageSource damageSource, LivingEntityPatch<?> livingEntityPatch, double percentage, boolean playStunAnimation) {
/*  91 */     float decrease = 0.0F;
/*  92 */     if (livingEntityPatch instanceof CEHumanoidPatch)
/*  93 */     { float currentStamina = CEPatchUtils.getStamina(livingEntityPatch);
/*  94 */       float maxStamina = CEPatchUtils.getMaxStamina(livingEntityPatch);
/*  95 */       float staminaToDecrease = (float)(maxStamina * percentage);
/*  96 */       decrease = Math.min(staminaToDecrease, currentStamina); }
/*  97 */     else if (livingEntityPatch instanceof PlayerPatch) { PlayerPatch<?> playerPatch = (PlayerPatch)livingEntityPatch;
/*  98 */       float currentStamina = playerPatch.getStamina();
/*  99 */       float maxStamina = playerPatch.getMaxStamina();
/* 100 */       float staminaToDecrease = (float)(maxStamina * percentage);
/* 101 */       decrease = Math.min(staminaToDecrease, currentStamina); }
/*     */     
/* 103 */     dealStaminaDamage(damageSource, decrease, livingEntityPatch, playStunAnimation);
/*     */   }
/*     */   
/*     */   public static void dealStaminaDamage(DamageSource damageSource, float amount, LivingEntityPatch<?> livingEntityPatch, boolean playStunAnimation) {
/* 107 */     if (livingEntityPatch instanceof CEHumanoidPatch) { CEHumanoidPatch<?> ceHumanoidPatch = (CEHumanoidPatch)livingEntityPatch;
/* 108 */       if (!ceHumanoidPatch.dealStaminaDamage(damageSource, amount) && playStunAnimation) {
/* 109 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.GUARD_BREAK_ATTACK, 0.0F);
/*     */       } }
/* 111 */     else if (livingEntityPatch instanceof PlayerPatch) { PlayerPatch<?> playerPatch = (PlayerPatch)livingEntityPatch;
/* 112 */       float stamina = playerPatch.getStamina();
/* 113 */       playerPatch.setStamina(stamina - amount);
/* 114 */       if (amount >= stamina) {
/* 115 */         EpicFightDamageSource efSource = (damageSource instanceof EpicFightDamageSource) ? (EpicFightDamageSource)damageSource : null;
/* 116 */         if (efSource != null) {
/* 117 */           efSource.setStunType(StunType.NONE);
/* 118 */           Vec3 sourcePosition = efSource.getInitialPosition();
/* 119 */           if (sourcePosition != null) {
/* 120 */             ((Player)playerPatch.getOriginal()).m_7618_(EntityAnchorArgument.Anchor.FEET, sourcePosition);
/*     */           }
/*     */         } 
/*     */         
/* 124 */         if (playerPatch.applyStun(StunType.NEUTRALIZE, 0.0F)) {
/* 125 */           ((Player)playerPatch.getOriginal()).m_147215_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 100), playerPatch.getOriginal());
/* 126 */           Vec3 eyePosition = ((Player)playerPatch.getOriginal()).m_146892_();
/* 127 */           Vec3 viewVec = ((Player)playerPatch.getOriginal()).m_20154_().m_82490_(2.0D);
/* 128 */           Vec3 pos = new Vec3(eyePosition.f_82479_ + viewVec.f_82479_, eyePosition.f_82480_ + viewVec.f_82480_, eyePosition.f_82481_ + viewVec.f_82481_);
/* 129 */           ((Player)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)EpicFightParticles.NEUTRALIZE.get(), pos.f_82479_, pos.f_82480_, pos.f_82481_, 0.0D, 0.0D, 0.0D);
/* 130 */           playerPatch.playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 1.0F, 1.0F);
/*     */         } 
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public static void breakWeaponOnParryOpAttack(DamageSource damageSource) {
/* 137 */     Entity attacker = damageSource.m_7639_();
/* 138 */     if (attacker instanceof Player) { Player player = (Player)attacker;
/* 139 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 140 */       if (playerPatch != null) {
/* 141 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 142 */         if (EscapeUtil.isAnimationDangerous(dynamicAnimation)) {
/* 143 */           int breakValue = ((Integer)AnnoyingVillagersConfig.WEAPON_BREAKING_MECHANISM_VALUE.get()).intValue();
/* 144 */           if (ModList.get().isLoaded("efn") && 
/* 145 */             EpicFightNightFall.isEfnWeapons(player.m_21205_())) {
/* 146 */             breakValue = ((Integer)AnnoyingVillagersConfig.WEAPON_BREAKING_MECHANISM_VALUE.get()).intValue() * 5;
/*     */           }
/*     */           
/* 149 */           player.m_21205_().m_41622_(breakValue, (LivingEntity)player, livingEntity -> livingEntity.m_21166_(EquipmentSlot.MAINHAND));
/*     */         } 
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void damageBlocked(DamageSource damagesource, Entity livingentity, ServerLevel level) {
/* 158 */     if (livingentity == null)
/* 159 */       return;  if (!damagesource.m_276093_(DamageTypes.f_268612_) && !damagesource.m_276093_(DamageTypes.f_268631_) && !damagesource.m_276093_(DamageTypes.f_268468_)) {
/* 160 */       livingentity.m_5496_((SoundEvent)EpicFightSounds.CLASH.get(), 1.0F, 1.0F);
/*     */     }
/* 162 */     ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(level, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, livingentity, damagesource
/* 163 */         .m_7639_());
/* 164 */     Entity entity = damagesource.m_7639_(); if (entity instanceof Player) { Player player = (Player)entity;
/* 165 */       ScreenShakeUtil.applyScreenShake(level, player.m_20097_().m_252807_(), 1.0D, 20, 4); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void damageBlockedForce(Entity defender, Entity attacker, ServerLevel level) {
/* 170 */     defender.m_5496_((SoundEvent)EpicFightSounds.CLASH.get(), 1.0F, 1.0F);
/* 171 */     ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(level, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, defender, attacker);
/*     */     
/* 173 */     if (attacker instanceof Player) { Player player = (Player)attacker;
/* 174 */       ScreenShakeUtil.applyScreenShake(level, player.m_20097_().m_252807_(), 1.0D, 20, 4); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\EpicfightUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */