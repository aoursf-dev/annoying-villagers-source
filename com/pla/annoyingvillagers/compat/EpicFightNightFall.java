/*     */ package com.pla.annoyingvillagers.compat;
/*     */ import com.hm.efn.animations.types.murasama.MurasamaAttackAnimation;
/*     */ import com.hm.efn.animations.types.yamato.YamatoAttackAnimation;
/*     */ import com.hm.efn.gameasset.animations.EFNGreatSwordAnimations;
/*     */ import com.hm.efn.gameasset.animations.EFNLanceAnimations;
/*     */ import com.hm.efn.gameasset.animations.EFNMurasamaAnimations;
/*     */ import com.hm.efn.gameasset.animations.EFNScytheAnimations;
/*     */ import com.hm.efn.gameasset.animations.EFNSekiroAnimations;
/*     */ import com.hm.efn.gameasset.animations.EFNSkillAnimations;
/*     */ import com.hm.efn.gameasset.animations.EFNThornWheelAnimations;
/*     */ import com.hm.efn.gameasset.animations.EFNYamatoAnimations;
/*     */ import com.merlin204.avalon.epicfight.animations.AvalonAttackAnimation;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.joml.Vector3d;
/*     */ import yesman.epicfight.api.animation.AnimationManager;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.AttackAnimation;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class EpicFightNightFall {
/*  29 */   private static final Set<String> DANGEROUS_ANIMATIONS = new HashSet<>();
/*     */   public static final int MULTIPLIER_DAMAGE_VALUE = 5;
/*     */   
/*     */   static {
/*  33 */     DANGEROUS_ANIMATIONS.addAll(Set.of((Object[])new String[] { ((ActionAnimation)EFNGreatSwordAnimations.NG_GREATSWORD_CHARGING
/*  34 */             .get()).getRegistryName().toString(), ((AvalonAttackAnimation)EFNGreatSwordAnimations.NG_GREATSWORD_CHARG1MAX_FIRST
/*  35 */             .get()).getRegistryName().toString(), ((AvalonAttackAnimation)EFNGreatSwordAnimations.NG_GREATSWORD_CHARG1MAX_SECOND
/*  36 */             .get()).getRegistryName().toString(), ((ActionAnimation)EFNGreatSwordAnimations.NG_GREATSWORD_CHARGING_MOB
/*  37 */             .get()).getRegistryName().toString(), ((AttackAnimation)EFNGreatSwordAnimations.NG_GREATSWORD_AIRSLASH
/*  38 */             .get()).getRegistryName().toString(), ((AvalonAttackAnimation)EFNLanceAnimations.NF_MEEN_DASH
/*  39 */             .get()).getRegistryName().toString(), ((AttackAnimation)EFNLanceAnimations.NF_MEEN_CHARGING
/*  40 */             .get()).getRegistryName().toString(), ((AttackAnimation)EFNLanceAnimations.NF_MEEN_CHARGING_MOB
/*  41 */             .get()).getRegistryName().toString(), ((AvalonAttackAnimation)EFNLanceAnimations.NF_MEEN_CHARGE1
/*  42 */             .get()).getRegistryName().toString(), ((AvalonAttackAnimation)EFNLanceAnimations.NF_MEEN_CHARGE2
/*  43 */             .get()).getRegistryName().toString(), ((AvalonAttackAnimation)EFNLanceAnimations.NF_MEEN_CHARGE3
/*  44 */             .get()).getRegistryName().toString(), ((AvalonAttackAnimation)EFNLanceAnimations.NF_MEEN_FINISHER
/*  45 */             .get()).getRegistryName().toString(), ((YamatoAttackAnimation)EFNYamatoAnimations.YAMATO_JUDEMENCUT_ALL
/*  46 */             .get()).getRegistryName().toString(), ((YamatoAttackAnimation)EFNYamatoAnimations.YAMATO_JUDEMENCUT
/*  47 */             .get()).getRegistryName().toString(), ((YamatoAttackAnimation)EFNYamatoAnimations.YAMATO_JUDEMENCUT_CHARGE
/*  48 */             .get()).getRegistryName().toString(), ((YamatoAttackAnimation)EFNYamatoAnimations.YAMATO_JUDEMENCUT_JUST
/*  49 */             .get()).getRegistryName().toString(), ((YamatoAttackAnimation)EFNYamatoAnimations.YAMATO_VOLCANOL_ALL
/*  50 */             .get()).getRegistryName().toString(), ((YamatoAttackAnimation)EFNYamatoAnimations.YAMATO_VOLCANOL
/*  51 */             .get()).getRegistryName().toString(), ((YamatoAttackAnimation)EFNYamatoAnimations.YAMATO_VOLCANOL_CHARGE
/*  52 */             .get()).getRegistryName().toString(), ((DeferredDamageAttackAnimation)EFNAnimations.DMC5_V_JC
/*  53 */             .get()).getRegistryName().toString(), ((AvalonAttackAnimation)EFNSkillAnimations.EXECUTION
/*  54 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_ZANDATSU
/*  55 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_ZANDATSU_AIR
/*  56 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_DASH_Y
/*  57 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_DASH_Y_SP
/*  58 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_KICK_Y
/*  59 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_Y
/*  60 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_Y_CHARGE
/*  61 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_Y_CHARGE_THROUGH
/*  62 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_Y_AIR
/*  63 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_Y_CHARGE_AIR
/*  64 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_XY
/*  65 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_XY_CHARGE
/*  66 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_XXY
/*  67 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_XXY_CHARGE
/*  68 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_XXX
/*  69 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_XXXY
/*  70 */             .get()).getRegistryName().toString(), ((MurasamaAttackAnimation)EFNMurasamaAnimations.HF_MURASAMA_XXXY_CHARGE
/*  71 */             .get()).getRegistryName().toString(), ((SekiroAttackAnimation)EFNSekiroAnimations.DRAGON_FLASH
/*  72 */             .get()).getRegistryName().toString(), ((SekiroArtsAnimation)EFNSekiroAnimations.MORTAL_BLADE_1
/*  73 */             .get()).getRegistryName().toString(), ((SekiroArtsAnimation)EFNSekiroAnimations.MORTAL_BLADE_2
/*  74 */             .get()).getRegistryName().toString(), ((AttackAnimation)EFNThornWheelAnimations.THORNWHEEL_SKILL_START
/*  75 */             .get()).getRegistryName().toString(), ((MoveAttackAnimation)EFNThornWheelAnimations.THORNWHEEL_SKILL_LOOP
/*  76 */             .get()).getRegistryName().toString(), ((AttackAnimation)EFNThornWheelAnimations.THORNWHEEL_SKILL_START_N
/*  77 */             .get()).getRegistryName().toString(), ((MoveAttackAnimation)EFNThornWheelAnimations.THORNWHEEL_SKILL_LOOP_N
/*  78 */             .get()).getRegistryName().toString(), ((AttackAnimation)EFNScytheAnimations.SCYTHE_HARVEST
/*  79 */             .get()).getRegistryName().toString(), ((AirSlashAnimation)EFNScytheAnimations.SCYTHE_AIR_SLASH
/*  80 */             .get()).getRegistryName().toString(), ((AttackAnimation)EFNScytheAnimations.SCYTHE_SCARLET_END
/*  81 */             .get()).getRegistryName().toString() }));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Set<String> getDangerousAnimations() {
/*  86 */     return DANGEROUS_ANIMATIONS;
/*     */   }
/*     */   
/*     */   public static boolean isEFNStun(AssetAccessor<? extends StaticAnimation> assetAccessor) {
/*  90 */     return assetAccessor.get() instanceof com.hm.efn.animations.types.stun.EFNStunAnimation;
/*     */   }
/*     */   
/*     */   private static Vector3d getParticleArgumentsForAnimation(AnimationManager.AnimationAccessor<? extends StaticAnimation> animation) {
/*  94 */     if (animation.get() == EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1)
/*  95 */       return new Vector3d(1.0D, -0.6D, 0.0D); 
/*  96 */     if (animation.get() == EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2) {
/*  97 */       return new Vector3d(1.0D, 0.6D, 0.0D);
/*     */     }
/*  99 */     return (animation.get() == EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT3) ? new Vector3d(1.2D, 0.7D, 0.0D) : new Vector3d(1.0D, 0.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Vector3d getParticlePositionForAnimation(Entity owner, Entity target, AnimationManager.AnimationAccessor<? extends StaticAnimation> animation) {
/* 104 */     Vec3 limitedMiddlePos, lookVec = owner.m_20154_();
/* 105 */     Vec3 playerPos = owner.m_20182_().m_82520_(0.0D, owner.m_20206_() * 0.6D, 0.0D);
/* 106 */     Vec3 targetPos = target.m_20182_().m_82520_(0.0D, target.m_20206_() * 0.6D, 0.0D);
/* 107 */     Vec3 middlePos = playerPos.m_82549_(targetPos.m_82546_(playerPos).m_82490_(0.5D));
/* 108 */     Vec3 toMiddle = middlePos.m_82546_(playerPos);
/* 109 */     double distanceToMiddle = toMiddle.m_82553_();
/* 110 */     double maxDistance = 1.0D;
/*     */     
/* 112 */     if (distanceToMiddle > maxDistance) {
/* 113 */       Vec3 direction = toMiddle.m_82541_();
/* 114 */       limitedMiddlePos = playerPos.m_82549_(direction.m_82490_(maxDistance));
/*     */     } else {
/* 116 */       limitedMiddlePos = middlePos;
/*     */     } 
/*     */     
/* 119 */     Vector3d basePosition = new Vector3d(limitedMiddlePos.f_82479_, limitedMiddlePos.f_82480_, limitedMiddlePos.f_82481_);
/* 120 */     if (animation.get() == EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1) {
/* 121 */       Vec3 leftOffset = lookVec.m_82524_((float)Math.toRadians(-90.0D)).m_82490_(0.2D);
/* 122 */       Vector3d finalPos = new Vector3d(basePosition.x + leftOffset.f_82479_, basePosition.y, basePosition.z + leftOffset.f_82481_);
/* 123 */       return limitDistanceFromOwner(playerPos, finalPos, maxDistance);
/* 124 */     }  if (animation.get() == EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2) {
/* 125 */       Vec3 rightOffset = lookVec.m_82524_((float)Math.toRadians(90.0D)).m_82490_(0.2D);
/* 126 */       Vector3d finalPos = new Vector3d(basePosition.x + rightOffset.f_82479_, basePosition.y, basePosition.z + rightOffset.f_82481_);
/* 127 */       return limitDistanceFromOwner(playerPos, finalPos, maxDistance);
/*     */     } 
/* 129 */     return basePosition;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Vector3d limitDistanceFromOwner(Vec3 playerPos, Vector3d particlePos, double maxDistance) {
/* 134 */     Vec3 toParticle = (new Vec3(particlePos.x, particlePos.y, particlePos.z)).m_82546_(playerPos);
/* 135 */     double distance = toParticle.m_82553_();
/* 136 */     if (distance > maxDistance) {
/* 137 */       Vec3 direction = toParticle.m_82541_();
/* 138 */       Vec3 limitedPos = playerPos.m_82549_(direction.m_82490_(maxDistance));
/* 139 */       return new Vector3d(limitedPos.f_82479_, limitedPos.f_82480_, limitedPos.f_82481_);
/*     */     } 
/* 141 */     return particlePos;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void spawnParryFlashParticle(Entity owner, Entity target, AnimationManager.AnimationAccessor<? extends StaticAnimation> animation, ServerLevel serverLevel) {
/* 146 */     Vector3d particleArgs = getParticleArgumentsForAnimation(animation);
/* 147 */     ((HitParticleType)EFNParticles.EFN_PARRY_FLASH_MAIN.get()).spawnParticleWithArgument(serverLevel, (player, entity) -> getParticlePositionForAnimation(player, entity, animation), (player, entity) -> particleArgs, owner, target);
/* 148 */     ((HitParticleType)EFNParticles.ALL_SPARK.get()).spawnParticleWithArgument(serverLevel, (player, entity) -> getParticlePositionForAnimation(player, entity, animation), HitParticleType.ZERO, owner, target);
/*     */   }
/*     */   
/*     */   public static void playEfnGuardHit(LivingEntityPatch<?> livingEntityPatch, int index, DamageSource damageSource) {
/* 152 */     Level level = ((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(); if (level instanceof ServerLevel) { AnimationManager.AnimationAccessor<? extends StaticAnimation> animation; ServerLevel serverLevel = (ServerLevel)level;
/*     */       
/* 154 */       if (index == 0) {
/* 155 */         animation = EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1;
/* 156 */       } else if (index == 1) {
/* 157 */         animation = EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2;
/*     */       } else {
/* 159 */         animation = EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT3;
/*     */       } 
/* 161 */       livingEntityPatch.playAnimationSynchronized((AssetAccessor)animation, 0.0F);
/* 162 */       spawnParryFlashParticle(livingEntityPatch.getOriginal(), damageSource.m_7640_(), animation, serverLevel);
/* 163 */       livingEntityPatch.playSound((SoundEvent)EFNSounds.PARRY.get(), 0.5F, 0.0F, 0.0F); }
/*     */   
/*     */   }
/*     */   
/*     */   public static boolean isPlayingEfnGuardHit(CEHumanoidPatch<?> ceHumanoidPatch) {
/* 168 */     AnimationPlayer animationPlayer = ceHumanoidPatch.getAnimator().getPlayerFor(null);
/* 169 */     if (animationPlayer != null) {
/* 170 */       AssetAccessor<? extends StaticAnimation> dynamicAnimation = animationPlayer.getRealAnimation();
/* 171 */       return (dynamicAnimation == EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1 || dynamicAnimation == EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2 || dynamicAnimation == EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT3);
/*     */     } 
/* 173 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isEfnWeapons(ItemStack itemStack) {
/* 177 */     return (itemStack.m_41720_() instanceof com.hm.efn.item.custom.RuinsgreatswordItem || itemStack
/* 178 */       .m_41720_() instanceof com.hm.efn.item.custom.ThornWheelItem || itemStack
/* 179 */       .m_41720_() instanceof com.hm.efn.item.custom.AetherialDuskDualSword_MainHandItem || itemStack
/* 180 */       .m_41720_() instanceof com.hm.efn.item.custom.Meen_SpearItem || itemStack
/* 181 */       .m_41720_() instanceof com.hm.efn.item.custom.PioneerItem || itemStack
/* 182 */       .m_41720_() instanceof com.hm.efn.item.custom.NFShortSwordItem || itemStack
/* 183 */       .m_41720_() instanceof com.hm.efn.item.custom.NFShortSwordTwoItem || itemStack
/* 184 */       .m_41720_() instanceof com.hm.efn.item.custom.ExsiliumgladiusItem || itemStack
/* 185 */       .m_41720_() instanceof com.hm.efn.item.custom.FireExsiliumgladiusItem || itemStack
/* 186 */       .m_41720_() instanceof com.hm.efn.item.custom.AirTachiItem || itemStack
/* 187 */       .m_41720_() instanceof com.hm.efn.item.custom.CoTachiItem || itemStack
/* 188 */       .m_41720_() instanceof com.hm.efn.item.custom.KusabimaruItem || itemStack
/* 189 */       .m_41720_() instanceof com.hm.efn.item.custom.BroadBladeItem || itemStack
/* 190 */       .m_41720_() instanceof com.hm.efn.item.custom.ScytheItem || itemStack
/* 191 */       .m_41720_() instanceof com.hm.efn.item.custom.NfClawItem || itemStack
/* 192 */       .m_41720_() instanceof com.hm.efn.item.custom.YamatoItem || itemStack
/* 193 */       .m_41720_() instanceof com.hm.efn.item.custom.HfMurasamaItem || itemStack
/* 194 */       .m_41720_() instanceof com.hm.efn.item.custom.CrescentMoonItem || itemStack
/* 195 */       .m_41720_() instanceof com.hm.efn.item.geo.ExcaliburItem);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\compat\EpicFightNightFall.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */