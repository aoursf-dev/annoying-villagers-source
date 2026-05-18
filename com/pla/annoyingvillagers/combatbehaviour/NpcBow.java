/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NpcBow
/*     */ {
/*  13 */   public static final CECombatBehaviors.Builder<MobPatch<?>> BOW = CECombatBehaviors.builder()
/*  14 */     .newBehaviorRoot(
/*  15 */       CECombatBehaviors.BehaviorRoot.builder()
/*  16 */       .priority(2.0D)
/*  17 */       .weight(100.0D)
/*  18 */       .maxCooldown(0)
/*  19 */       .addFirstBehavior(
/*  20 */         CECombatBehaviors.Behavior.builder()
/*  21 */         .custom(CombatCommon::isNotRiding)
/*  22 */         .withinDistance(0.0D, 5.0D)
/*  23 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  24 */         .addExBehavior(CombatCommon::swapToMelee))
/*     */       
/*  26 */       .addFirstBehavior(
/*  27 */         CECombatBehaviors.Behavior.builder()
/*  28 */         .custom(CombatCommon::isNotRiding)
/*  29 */         .withinDistance(0.0D, 5.0D)
/*  30 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  31 */         .addExBehavior(CombatCommon::swapToMelee)))
/*     */ 
/*     */     
/*  34 */     .newBehaviorRoot(
/*  35 */       CECombatBehaviors.BehaviorRoot.builder()
/*  36 */       .priority(2.0D)
/*  37 */       .weight(100.0D)
/*  38 */       .maxCooldown(0)
/*  39 */       .addFirstBehavior(
/*  40 */         CECombatBehaviors.Behavior.builder()
/*  41 */         .custom(CombatCommon::isRiding)
/*  42 */         .withinDistance(0.0D, 5.0D)
/*  43 */         .animationBehavior(AVAnimations.KNIFE_CHECK, 0.0F)
/*  44 */         .addExBehavior(CombatCommon::swapToMelee))
/*     */       
/*  46 */       .addFirstBehavior(
/*  47 */         CECombatBehaviors.Behavior.builder()
/*  48 */         .custom(CombatCommon::isRiding)
/*  49 */         .withinDistance(0.0D, 5.0D)
/*  50 */         .animationBehavior(AVAnimations.KNIFE_CHECK, 0.0F)
/*  51 */         .addExBehavior(CombatCommon::swapToMelee)))
/*     */ 
/*     */     
/*  54 */     .newBehaviorRoot(
/*  55 */       CECombatBehaviors.BehaviorRoot.builder()
/*  56 */       .priority(2.0D)
/*  57 */       .weight(70.0D)
/*  58 */       .maxCooldown(0)
/*  59 */       .addFirstBehavior(
/*  60 */         CECombatBehaviors.Behavior.builder()
/*  61 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  62 */         .custom(CombatCommon::canPerformEating)
/*  63 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  64 */         .addExBehavior(CombatCommon::performEatingAnimation))
/*     */       
/*  66 */       .addFirstBehavior(
/*  67 */         CECombatBehaviors.Behavior.builder()
/*  68 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  69 */         .custom(CombatCommon::canPerformEating)
/*  70 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  71 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  74 */     .newBehaviorRoot(
/*  75 */       CECombatBehaviors.BehaviorRoot.builder()
/*  76 */       .priority(1.0D)
/*  77 */       .weight(40.0D)
/*  78 */       .addFirstBehavior(
/*  79 */         CECombatBehaviors.Behavior.builder()
/*  80 */         .withinDistance(7.0D, 14.0D)
/*  81 */         .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)
/*  82 */         .addNextBehavior(
/*  83 */           CECombatBehaviors.Behavior.builder()
/*  84 */           .withinDistance(7.0D, 14.0D)
/*  85 */           .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)
/*  86 */           .addNextBehavior(
/*  87 */             CECombatBehaviors.Behavior.builder()
/*  88 */             .withinDistance(7.0D, 14.0D)
/*  89 */             .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     .newBehaviorRoot(
/*  95 */       CECombatBehaviors.BehaviorRoot.builder()
/*  96 */       .priority(1.0D)
/*  97 */       .weight(20.0D)
/*  98 */       .maxCooldown(100)
/*  99 */       .addFirstBehavior(
/* 100 */         CECombatBehaviors.Behavior.builder()
/* 101 */         .custom(CombatCommon::isNotRiding)
/* 102 */         .withinDistance(7.0D, 14.0D)
/* 103 */         .animationBehavior(AVAnimations.BOW_AUTO_2, 0.0F)))
/*     */ 
/*     */     
/* 106 */     .newBehaviorRoot(
/* 107 */       CECombatBehaviors.BehaviorRoot.builder()
/* 108 */       .priority(1.0D)
/* 109 */       .weight(10.0D)
/* 110 */       .maxCooldown(100)
/* 111 */       .addFirstBehavior(
/* 112 */         CECombatBehaviors.Behavior.builder()
/* 113 */         .custom(CombatCommon::isNotRiding)
/* 114 */         .withinDistance(7.0D, 14.0D)
/* 115 */         .animationBehavior(AVAnimations.BOW_AUTO_3, 0.0F))
/*     */       
/* 117 */       .addFirstBehavior(
/* 118 */         CECombatBehaviors.Behavior.builder()
/* 119 */         .custom(CombatCommon::isNotRiding)
/* 120 */         .withinDistance(7.0D, 14.0D)
/* 121 */         .animationBehavior(AVAnimations.BOW_AUTO_5, 0.0F)))
/*     */ 
/*     */     
/* 124 */     .newBehaviorRoot(
/* 125 */       CECombatBehaviors.BehaviorRoot.builder()
/* 126 */       .priority(1.0D)
/* 127 */       .weight(40.0D)
/* 128 */       .addFirstBehavior(
/* 129 */         CECombatBehaviors.Behavior.builder()
/* 130 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 131 */         .withinDistance(7.0D, 80.0D)
/* 132 */         .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)
/* 133 */         .addNextBehavior(
/* 134 */           CECombatBehaviors.Behavior.builder()
/* 135 */           .custom(CombatCommon::isTargetingHerobrineDragon)
/* 136 */           .withinDistance(7.0D, 80.0D)
/* 137 */           .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)
/* 138 */           .addNextBehavior(
/* 139 */             CECombatBehaviors.Behavior.builder()
/* 140 */             .custom(CombatCommon::isTargetingHerobrineDragon)
/* 141 */             .withinDistance(7.0D, 80.0D)
/* 142 */             .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     .newBehaviorRoot(
/* 148 */       CECombatBehaviors.BehaviorRoot.builder()
/* 149 */       .priority(1.0D)
/* 150 */       .weight(20.0D)
/* 151 */       .maxCooldown(100)
/* 152 */       .addFirstBehavior(
/* 153 */         CECombatBehaviors.Behavior.builder()
/* 154 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 155 */         .custom(CombatCommon::isNotRiding)
/* 156 */         .withinDistance(7.0D, 80.0D)
/* 157 */         .animationBehavior(AVAnimations.BOW_AUTO_2, 0.0F)))
/*     */ 
/*     */     
/* 160 */     .newBehaviorRoot(
/* 161 */       CECombatBehaviors.BehaviorRoot.builder()
/* 162 */       .priority(1.0D)
/* 163 */       .weight(10.0D)
/* 164 */       .maxCooldown(100)
/* 165 */       .addFirstBehavior(
/* 166 */         CECombatBehaviors.Behavior.builder()
/* 167 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 168 */         .custom(CombatCommon::isNotRiding)
/* 169 */         .withinDistance(7.0D, 80.0D)
/* 170 */         .animationBehavior(AVAnimations.BOW_AUTO_3, 0.0F))
/*     */       
/* 172 */       .addFirstBehavior(
/* 173 */         CECombatBehaviors.Behavior.builder()
/* 174 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 175 */         .custom(CombatCommon::isNotRiding)
/* 176 */         .withinDistance(7.0D, 80.0D)
/* 177 */         .animationBehavior(AVAnimations.BOW_AUTO_5, 0.0F)))
/*     */ 
/*     */     
/* 180 */     .newBehaviorRoot(
/* 181 */       CECombatBehaviors.BehaviorRoot.builder()
/* 182 */       .priority(1.0D)
/* 183 */       .weight(10.0D)
/* 184 */       .addFirstBehavior(
/* 185 */         CECombatBehaviors.Behavior.builder()
/* 186 */         .custom(CombatCommon::isNotRiding)
/* 187 */         .withinDistance(7.0D, 14.0D)
/* 188 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*     */       
/* 190 */       .addFirstBehavior(
/* 191 */         CECombatBehaviors.Behavior.builder()
/* 192 */         .custom(CombatCommon::isNotRiding)
/* 193 */         .withinDistance(7.0D, 14.0D)
/* 194 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))
/*     */ 
/*     */     
/* 197 */     .newBehaviorRoot(
/* 198 */       CECombatBehaviors.BehaviorRoot.builder()
/* 199 */       .priority(1.0D)
/* 200 */       .weight(60.0D)
/* 201 */       .maxCooldown(120)
/* 202 */       .addFirstBehavior(
/* 203 */         CECombatBehaviors.Behavior.builder()
/* 204 */         .custom(CombatCommon::isNotRiding)
/* 205 */         .custom(CombatCommon::canThrowEnderPearl)
/* 206 */         .withinDistance(7.0D, 14.0D)
/* 207 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 208 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\NpcBow.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */