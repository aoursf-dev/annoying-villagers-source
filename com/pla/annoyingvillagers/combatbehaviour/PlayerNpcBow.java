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
/*     */ public class PlayerNpcBow
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
/*  23 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  24 */         .addExBehavior(CombatCommon::swapToMelee))
/*     */       
/*  26 */       .addFirstBehavior(
/*  27 */         CECombatBehaviors.Behavior.builder()
/*  28 */         .custom(CombatCommon::isNotRiding)
/*  29 */         .withinDistance(0.0D, 5.0D)
/*  30 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
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
/*  63 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  64 */         .addExBehavior(CombatCommon::performEatingAnimation))
/*     */       
/*  66 */       .addFirstBehavior(
/*  67 */         CECombatBehaviors.Behavior.builder()
/*  68 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  69 */         .custom(CombatCommon::canPerformEating)
/*  70 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
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
/* 127 */       .weight(10.0D)
/* 128 */       .maxCooldown(100)
/* 129 */       .addFirstBehavior(
/* 130 */         CECombatBehaviors.Behavior.builder()
/* 131 */         .custom(CombatCommon::isNotRiding)
/* 132 */         .withinDistance(7.0D, 14.0D)
/* 133 */         .animationBehavior(AVAnimations.BOW_AUTO_3, 0.0F))
/*     */       
/* 135 */       .addFirstBehavior(
/* 136 */         CECombatBehaviors.Behavior.builder()
/* 137 */         .custom(CombatCommon::isNotRiding)
/* 138 */         .withinDistance(7.0D, 14.0D)
/* 139 */         .animationBehavior(AVAnimations.BOW_AUTO_5, 0.0F)))
/*     */ 
/*     */     
/* 142 */     .newBehaviorRoot(
/* 143 */       CECombatBehaviors.BehaviorRoot.builder()
/* 144 */       .priority(1.0D)
/* 145 */       .weight(40.0D)
/* 146 */       .addFirstBehavior(
/* 147 */         CECombatBehaviors.Behavior.builder()
/* 148 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 149 */         .withinDistance(7.0D, 80.0D)
/* 150 */         .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)
/* 151 */         .addNextBehavior(
/* 152 */           CECombatBehaviors.Behavior.builder()
/* 153 */           .custom(CombatCommon::isTargetingHerobrineDragon)
/* 154 */           .withinDistance(7.0D, 80.0D)
/* 155 */           .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)
/* 156 */           .addNextBehavior(
/* 157 */             CECombatBehaviors.Behavior.builder()
/* 158 */             .custom(CombatCommon::isTargetingHerobrineDragon)
/* 159 */             .withinDistance(7.0D, 80.0D)
/* 160 */             .animationBehavior(AVAnimations.BOW_AUTO_1, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     .newBehaviorRoot(
/* 166 */       CECombatBehaviors.BehaviorRoot.builder()
/* 167 */       .priority(1.0D)
/* 168 */       .weight(20.0D)
/* 169 */       .maxCooldown(100)
/* 170 */       .addFirstBehavior(
/* 171 */         CECombatBehaviors.Behavior.builder()
/* 172 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 173 */         .custom(CombatCommon::isNotRiding)
/* 174 */         .withinDistance(7.0D, 80.0D)
/* 175 */         .animationBehavior(AVAnimations.BOW_AUTO_2, 0.0F)))
/*     */ 
/*     */     
/* 178 */     .newBehaviorRoot(
/* 179 */       CECombatBehaviors.BehaviorRoot.builder()
/* 180 */       .priority(1.0D)
/* 181 */       .weight(10.0D)
/* 182 */       .maxCooldown(100)
/* 183 */       .addFirstBehavior(
/* 184 */         CECombatBehaviors.Behavior.builder()
/* 185 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 186 */         .custom(CombatCommon::isNotRiding)
/* 187 */         .withinDistance(7.0D, 80.0D)
/* 188 */         .animationBehavior(AVAnimations.BOW_AUTO_3, 0.0F))
/*     */       
/* 190 */       .addFirstBehavior(
/* 191 */         CECombatBehaviors.Behavior.builder()
/* 192 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 193 */         .custom(CombatCommon::isNotRiding)
/* 194 */         .withinDistance(7.0D, 80.0D)
/* 195 */         .animationBehavior(AVAnimations.BOW_AUTO_5, 0.0F)))
/*     */ 
/*     */     
/* 198 */     .newBehaviorRoot(
/* 199 */       CECombatBehaviors.BehaviorRoot.builder()
/* 200 */       .priority(1.0D)
/* 201 */       .weight(10.0D)
/* 202 */       .addFirstBehavior(
/* 203 */         CECombatBehaviors.Behavior.builder()
/* 204 */         .custom(CombatCommon::isNotRiding)
/* 205 */         .withinDistance(7.0D, 14.0D)
/* 206 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 208 */       .addFirstBehavior(
/* 209 */         CECombatBehaviors.Behavior.builder()
/* 210 */         .custom(CombatCommon::isNotRiding)
/* 211 */         .withinDistance(7.0D, 14.0D)
/* 212 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*     */ 
/*     */     
/* 215 */     .newBehaviorRoot(
/* 216 */       CECombatBehaviors.BehaviorRoot.builder()
/* 217 */       .priority(1.0D)
/* 218 */       .weight(60.0D)
/* 219 */       .maxCooldown(120)
/* 220 */       .addFirstBehavior(
/* 221 */         CECombatBehaviors.Behavior.builder()
/* 222 */         .custom(CombatCommon::isNotRiding)
/* 223 */         .custom(CombatCommon::canThrowEnderPearl)
/* 224 */         .withinDistance(7.0D, 14.0D)
/* 225 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 226 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcBow.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */