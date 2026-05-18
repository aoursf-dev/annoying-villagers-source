/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcDagger;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcFist;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcGreatsword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcLongsword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcSpear;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcSword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcUchigatana;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.util.MobPatchCommon;
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
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.CEHumanoidPatch;
/*     */ import net.shelmarow.combat_evolution.ai.iml.CustomExecuteEntity;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*     */ import reascer.wom.world.capabilities.item.WOMWeaponCategories;
/*     */ import yesman.epicfight.api.animation.Animator;
/*     */ import yesman.epicfight.api.animation.LivingMotion;
/*     */ import yesman.epicfight.api.animation.LivingMotions;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.Factions;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.damagesource.EpicFightDamageSource;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class PlayerNpcPatch extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public PlayerNpcPatch() {
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
/*  63 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  64 */         ImmutableMap.of(CapabilityItem.Styles.COMMON, 
/*  65 */           Set.of(
/*  66 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  67 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  68 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  69 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  70 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  72 */     this.weaponAttackMotions
/*  73 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  74 */         ImmutableMap.of(CapabilityItem.Styles.COMMON, PlayerNpcFist.FIST));
/*     */     
/*  76 */     this.weaponLivingMotions
/*  77 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  78 */         ImmutableMap.of(CapabilityItem.Styles.COMMON, 
/*  79 */           Set.of(
/*  80 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  81 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  82 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  83 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  84 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  86 */     if (!ModList.get().isLoaded("annoyingvillagers_epicfightx")) {
/*  87 */       this.weaponAttackMotions
/*  88 */         .put(CapabilityItem.WeaponCategories.FIST, 
/*  89 */           ImmutableMap.of(CapabilityItem.Styles.COMMON, PlayerNpcFist.FIST));
/*  90 */       this.weaponAttackMotions
/*  91 */         .put(CapabilityItem.WeaponCategories.SWORD, 
/*  92 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcSword.SWORD, CapabilityItem.Styles.TWO_HAND, PlayerNpcSword.DUAL_SWORD));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  97 */       this.weaponAttackMotions
/*  98 */         .put(CapabilityItem.WeaponCategories.DAGGER, 
/*  99 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcDagger.DAGGER, CapabilityItem.Styles.TWO_HAND, PlayerNpcDagger.DUAL_DAGGER));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 104 */       this.weaponAttackMotions
/* 105 */         .put(CapabilityItem.WeaponCategories.UCHIGATANA, 
/* 106 */           ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcUchigatana.UCHIGATANA));
/*     */ 
/*     */       
/* 109 */       this.weaponAttackMotions
/* 110 */         .put(CapabilityItem.WeaponCategories.SPEAR, 
/* 111 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcSpear.SPEAR_SHIELD, CapabilityItem.Styles.TWO_HAND, PlayerNpcSpear.SPEAR));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 116 */       this.weaponAttackMotions
/* 117 */         .put(CapabilityItem.WeaponCategories.LONGSWORD, 
/* 118 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcLongsword.LONGSWORD_SHIELD, CapabilityItem.Styles.TWO_HAND, PlayerNpcLongsword.LONGSWORD));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 123 */       this.weaponAttackMotions
/* 124 */         .put(CapabilityItem.WeaponCategories.TACHI, 
/* 125 */           ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcTachi.TACHI));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 130 */     if (!ModList.get().isLoaded("annoyingvillagers_moredual") && !ModList.get().isLoaded("annoyingvillagers_epicfightx")) {
/* 131 */       this.weaponAttackMotions
/* 132 */         .put(CapabilityItem.WeaponCategories.AXE, 
/* 133 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcAxe.AXE));
/*     */     }
/*     */     
/* 136 */     if (!ModList.get().isLoaded("annoyingvillagers_moredual") && !ModList.get().isLoaded("annoyingvillagers_epicfightx")) {
/* 137 */       this.weaponAttackMotions
/* 138 */         .put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 139 */           ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcGreatsword.GREATSWORD));
/*     */     }
/*     */     
/* 142 */     this.weaponLivingMotions
/* 143 */       .put(WOMWeaponCategories.ENDERBLASTER, 
/* 144 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 145 */           Set.of(
/* 146 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 147 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 148 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/* 149 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/* 150 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH)), CapabilityItem.Styles.TWO_HAND, 
/*     */           
/* 152 */           Set.of(
/* 153 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 154 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 155 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/* 156 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/* 157 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/* 159 */     this.weaponAttackMotions
/* 160 */       .put(WOMWeaponCategories.ENDERBLASTER, 
/* 161 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcFist.FIST, CapabilityItem.Styles.TWO_HAND, PlayerNpcFist.FIST));
/*     */     
/* 163 */     this.weaponAttackMotions
/* 164 */       .put(WOMWeaponCategories.TORMENT, 
/* 165 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcGreatsword.AV_GREATSWORD));
/* 166 */     this.weaponLivingMotions
/* 167 */       .put(WOMWeaponCategories.TORMENT, 
/* 168 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 169 */           Set.of(
/* 170 */             Pair.of(LivingMotions.BLOCK, Animations.BIPED_BLOCK), 
/* 171 */             Pair.of(LivingMotions.IDLE, WOMAnimations.TORMENT_IDLE), 
/* 172 */             Pair.of(LivingMotions.WALK, WOMAnimations.TORMENT_WALK), 
/* 173 */             Pair.of(LivingMotions.RUN, WOMAnimations.TORMENT_RUN), 
/* 174 */             Pair.of(LivingMotions.CHASE, WOMAnimations.TORMENT_RUN), 
/* 175 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 178 */     this.weaponAttackMotions
/* 179 */       .put(WOMWeaponCategories.ANTITHEUS, 
/* 180 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcSpear.AV_SPEAR));
/*     */ 
/*     */     
/* 183 */     this.weaponLivingMotions
/* 184 */       .put(WOMWeaponCategories.ANTITHEUS, 
/* 185 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 186 */           Set.of(
/* 187 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/* 188 */             Pair.of(LivingMotions.IDLE, AnimsAgony.AGONY_IDLE), 
/* 189 */             Pair.of(LivingMotions.WALK, AnimsAgony.AGONY_WALK), 
/* 190 */             Pair.of(LivingMotions.RUN, AnimsAgony.AGONY_RUN), 
/* 191 */             Pair.of(LivingMotions.CHASE, AnimsAgony.AGONY_RUN), 
/* 192 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 195 */     this.weaponAttackMotions
/* 196 */       .put(WOMWeaponCategories.NAPOLEON, 
/* 197 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcSpear.AV_SPEAR));
/*     */ 
/*     */ 
/*     */     
/* 201 */     this.weaponLivingMotions
/* 202 */       .put(WOMWeaponCategories.NAPOLEON, 
/* 203 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 204 */           Set.of(
/* 205 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/* 206 */             Pair.of(LivingMotions.IDLE, AnimsAgony.AGONY_IDLE), 
/* 207 */             Pair.of(LivingMotions.WALK, AnimsAgony.AGONY_WALK), 
/* 208 */             Pair.of(LivingMotions.RUN, AnimsAgony.AGONY_RUN), 
/* 209 */             Pair.of(LivingMotions.CHASE, AnimsAgony.AGONY_RUN), 
/* 210 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */ 
/*     */     
/* 214 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/* 215 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 216 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 221 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.LONGSWORD, 
/* 227 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 228 */           List.of(Animations.LONGSWORD_GUARD_ACTIVE_HIT1, Animations.LONGSWORD_GUARD_ACTIVE_HIT2), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */           
/* 232 */           List.of(Animations.LONGSWORD_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 237 */     if (!ModList.get().isLoaded("annoyingvillagers_moredual")) {
/* 238 */       this.guardHitMotions.put(CapabilityItem.WeaponCategories.AXE, 
/* 239 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 240 */             List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 248 */     this.guardHitMotions.put(WOMWeaponCategories.TORMENT, 
/* 249 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 250 */           List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     if (!ModList.get().isLoaded("annoyingvillagers_moredual")) {
/* 256 */       this.guardHitMotions.put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 257 */           ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 258 */             List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     this.guardHitMotions.put(WOMWeaponCategories.ANTITHEUS, 
/* 265 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 266 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     this.guardHitMotions.put(WOMWeaponCategories.NAPOLEON, 
/* 272 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 273 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SPEAR, 
/* 279 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 280 */           List.of(Animations.SPEAR_GUARD_HIT), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/* 283 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 288 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.TRIDENT, 
/* 289 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 290 */           List.of(Animations.SPEAR_GUARD_HIT), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/* 293 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 298 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.UCHIGATANA, 
/* 299 */         ImmutableMap.of(CapabilityItem.Styles.OCHS, 
/* 300 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 305 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 310 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.DAGGER, 
/* 311 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 312 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 317 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 322 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.TACHI, 
/* 323 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 324 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 329 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CECombatBehaviors.Builder<MobPatch<?>> getCustomWeaponMotionBuilder() {
/* 338 */     CapabilityItem mainHandCap = getHoldingItemCapability(InteractionHand.MAIN_HAND);
/* 339 */     CECombatBehaviors.Builder<MobPatch<?>> customOverride = MobPatchCommon.overideCustomWeaponMotionBuilderForPlayerNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this));
/* 340 */     if (customOverride == null) customOverride = MobPatchCommon.overideBowMotionBuilderForPlayerNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this)); 
/* 341 */     return (customOverride != null) ? customOverride : super.getCustomWeaponMotionBuilder();
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 345 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 349 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 351 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 355 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 359 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 363 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 368 */     super.onGuardHit(damageSource);
/* 369 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 370 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */   
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 375 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 380 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 381 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 383 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 389 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 394 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 399 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\PlayerNpcPatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */