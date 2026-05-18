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
/*     */ public class LowHerobrineClonePatch extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public LowHerobrineClonePatch() {
/*  47 */     super(Factions.UNDEAD);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  51 */     super.initAnimator(animator);
/*  52 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  53 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.ZOMBIE_IDLE);
/*  54 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.ZOMBIE_WALK);
/*  55 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.ZOMBIE_CHASE);
/*  56 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.ZOMBIE_CHASE);
/*  57 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  61 */     this.weaponLivingMotions
/*  62 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  63 */         ImmutableMap.of(CapabilityItem.Styles.COMMON, 
/*  64 */           Set.of(
/*  65 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  66 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  67 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  68 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  69 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  71 */     this.weaponAttackMotions
/*  72 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  73 */         ImmutableMap.of(CapabilityItem.Styles.COMMON, PlayerNpcFist.FIST));
/*     */     
/*  75 */     this.weaponLivingMotions
/*  76 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  77 */         ImmutableMap.of(CapabilityItem.Styles.COMMON, 
/*  78 */           Set.of(
/*  79 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  80 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  81 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  82 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  83 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  85 */     if (!ModList.get().isLoaded("annoyingvillagers_epicfightx")) {
/*  86 */       this.weaponAttackMotions
/*  87 */         .put(CapabilityItem.WeaponCategories.FIST, 
/*  88 */           ImmutableMap.of(CapabilityItem.Styles.COMMON, PlayerNpcFist.FIST));
/*  89 */       this.weaponAttackMotions
/*  90 */         .put(CapabilityItem.WeaponCategories.SWORD, 
/*  91 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcSword.SWORD, CapabilityItem.Styles.TWO_HAND, PlayerNpcSword.DUAL_SWORD));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       this.weaponAttackMotions
/*  97 */         .put(CapabilityItem.WeaponCategories.DAGGER, 
/*  98 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcDagger.DAGGER, CapabilityItem.Styles.TWO_HAND, PlayerNpcDagger.DUAL_DAGGER));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 103 */       this.weaponAttackMotions
/* 104 */         .put(CapabilityItem.WeaponCategories.UCHIGATANA, 
/* 105 */           ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcUchigatana.UCHIGATANA));
/*     */ 
/*     */       
/* 108 */       this.weaponAttackMotions
/* 109 */         .put(CapabilityItem.WeaponCategories.SPEAR, 
/* 110 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcSpear.SPEAR_SHIELD, CapabilityItem.Styles.TWO_HAND, PlayerNpcSpear.SPEAR));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 115 */       this.weaponAttackMotions
/* 116 */         .put(CapabilityItem.WeaponCategories.LONGSWORD, 
/* 117 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcLongsword.LONGSWORD_SHIELD, CapabilityItem.Styles.TWO_HAND, PlayerNpcLongsword.LONGSWORD));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 122 */       this.weaponAttackMotions
/* 123 */         .put(CapabilityItem.WeaponCategories.TACHI, 
/* 124 */           ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcTachi.TACHI));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 129 */     if (!ModList.get().isLoaded("annoyingvillagers_moredual") && !ModList.get().isLoaded("annoyingvillagers_epicfightx")) {
/* 130 */       this.weaponAttackMotions
/* 131 */         .put(CapabilityItem.WeaponCategories.AXE, 
/* 132 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcAxe.AXE));
/*     */     }
/*     */     
/* 135 */     if (!ModList.get().isLoaded("annoyingvillagers_moredual") && !ModList.get().isLoaded("annoyingvillagers_epicfightx")) {
/* 136 */       this.weaponAttackMotions
/* 137 */         .put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 138 */           ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcGreatsword.GREATSWORD));
/*     */     }
/*     */     
/* 141 */     this.weaponLivingMotions
/* 142 */       .put(WOMWeaponCategories.ENDERBLASTER, 
/* 143 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 144 */           Set.of(
/* 145 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 146 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 147 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/* 148 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/* 149 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH)), CapabilityItem.Styles.TWO_HAND, 
/*     */           
/* 151 */           Set.of(
/* 152 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/* 153 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 154 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/* 155 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/* 156 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/* 158 */     this.weaponAttackMotions
/* 159 */       .put(WOMWeaponCategories.ENDERBLASTER, 
/* 160 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, PlayerNpcFist.FIST, CapabilityItem.Styles.TWO_HAND, PlayerNpcFist.FIST));
/*     */     
/* 162 */     this.weaponAttackMotions
/* 163 */       .put(WOMWeaponCategories.TORMENT, 
/* 164 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcGreatsword.AV_GREATSWORD));
/* 165 */     this.weaponLivingMotions
/* 166 */       .put(WOMWeaponCategories.TORMENT, 
/* 167 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 168 */           Set.of(
/* 169 */             Pair.of(LivingMotions.BLOCK, Animations.BIPED_BLOCK), 
/* 170 */             Pair.of(LivingMotions.IDLE, WOMAnimations.TORMENT_IDLE), 
/* 171 */             Pair.of(LivingMotions.WALK, WOMAnimations.TORMENT_WALK), 
/* 172 */             Pair.of(LivingMotions.RUN, WOMAnimations.TORMENT_RUN), 
/* 173 */             Pair.of(LivingMotions.CHASE, WOMAnimations.TORMENT_RUN), 
/* 174 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 177 */     this.weaponAttackMotions
/* 178 */       .put(WOMWeaponCategories.ANTITHEUS, 
/* 179 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcSpear.AV_SPEAR));
/*     */ 
/*     */     
/* 182 */     this.weaponLivingMotions
/* 183 */       .put(WOMWeaponCategories.ANTITHEUS, 
/* 184 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 185 */           Set.of(
/* 186 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/* 187 */             Pair.of(LivingMotions.IDLE, AnimsAgony.AGONY_IDLE), 
/* 188 */             Pair.of(LivingMotions.WALK, AnimsAgony.AGONY_WALK), 
/* 189 */             Pair.of(LivingMotions.RUN, AnimsAgony.AGONY_RUN), 
/* 190 */             Pair.of(LivingMotions.CHASE, AnimsAgony.AGONY_RUN), 
/* 191 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 194 */     this.weaponAttackMotions
/* 195 */       .put(WOMWeaponCategories.NAPOLEON, 
/* 196 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, PlayerNpcSpear.AV_SPEAR));
/*     */ 
/*     */ 
/*     */     
/* 200 */     this.weaponLivingMotions
/* 201 */       .put(WOMWeaponCategories.NAPOLEON, 
/* 202 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 203 */           Set.of(
/* 204 */             Pair.of(LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD), 
/* 205 */             Pair.of(LivingMotions.IDLE, AnimsAgony.AGONY_IDLE), 
/* 206 */             Pair.of(LivingMotions.WALK, AnimsAgony.AGONY_WALK), 
/* 207 */             Pair.of(LivingMotions.RUN, AnimsAgony.AGONY_RUN), 
/* 208 */             Pair.of(LivingMotions.CHASE, AnimsAgony.AGONY_RUN), 
/* 209 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */ 
/*     */     
/* 213 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/* 214 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 215 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 220 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.LONGSWORD, 
/* 226 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 227 */           List.of(Animations.LONGSWORD_GUARD_ACTIVE_HIT1, Animations.LONGSWORD_GUARD_ACTIVE_HIT2), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */           
/* 231 */           List.of(Animations.LONGSWORD_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 236 */     if (!ModList.get().isLoaded("annoyingvillagers_moredual")) {
/* 237 */       this.guardHitMotions.put(CapabilityItem.WeaponCategories.AXE, 
/* 238 */           ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 239 */             List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     this.guardHitMotions.put(WOMWeaponCategories.TORMENT, 
/* 248 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 249 */           List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     if (!ModList.get().isLoaded("annoyingvillagers_moredual")) {
/* 255 */       this.guardHitMotions.put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 256 */           ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 257 */             List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 263 */     this.guardHitMotions.put(WOMWeaponCategories.ANTITHEUS, 
/* 264 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 265 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 270 */     this.guardHitMotions.put(WOMWeaponCategories.NAPOLEON, 
/* 271 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 272 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SPEAR, 
/* 278 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 279 */           List.of(Animations.SPEAR_GUARD_HIT), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/* 282 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 287 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.TRIDENT, 
/* 288 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 289 */           List.of(Animations.SPEAR_GUARD_HIT), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/* 292 */           List.of(Animations.SPEAR_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 297 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.UCHIGATANA, 
/* 298 */         ImmutableMap.of(CapabilityItem.Styles.OCHS, 
/* 299 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 304 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.DAGGER, 
/* 310 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 311 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 316 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 321 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.TACHI, 
/* 322 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 323 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 328 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CECombatBehaviors.Builder<MobPatch<?>> getCustomWeaponMotionBuilder() {
/* 337 */     CapabilityItem mainHandCap = getHoldingItemCapability(InteractionHand.MAIN_HAND);
/* 338 */     CECombatBehaviors.Builder<MobPatch<?>> customOverride = MobPatchCommon.overideCustomWeaponMotionBuilderForPlayerNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this));
/* 339 */     if (customOverride == null) customOverride = MobPatchCommon.overideBowMotionBuilderForPlayerNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this)); 
/* 340 */     return (customOverride != null) ? customOverride : super.getCustomWeaponMotionBuilder();
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 344 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 348 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 350 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 354 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 358 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 362 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 367 */     super.onGuardHit(damageSource);
/* 368 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 369 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */   
/*     */   }
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 374 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 379 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 380 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 382 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 388 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 393 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 398 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\LowHerobrineClonePatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */