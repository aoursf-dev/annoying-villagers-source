/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.efkick.gameasset.EFKickAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerNpcFist
/*     */ {
/*  14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> FIST = CECombatBehaviors.builder()
/*  15 */     .newBehaviorRoot(
/*  16 */       CECombatBehaviors.BehaviorRoot.builder()
/*  17 */       .priority(4.0D)
/*  18 */       .weight(1000.0D)
/*  19 */       .maxCooldown(0)
/*  20 */       .addFirstBehavior(
/*  21 */         CECombatBehaviors.Behavior.builder()
/*  22 */         .custom(CombatCommon::canExecute)
/*  23 */         .withinDistance(0.0D, 5.0D)
/*  24 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  25 */         .addExBehavior(CombatCommon::performExecute)))
/*     */ 
/*     */     
/*  28 */     .newBehaviorRoot(
/*  29 */       CECombatBehaviors.BehaviorRoot.builder()
/*  30 */       .priority(3.0D)
/*  31 */       .weight(1000.0D)
/*  32 */       .maxCooldown(0)
/*  33 */       .addFirstBehavior(
/*  34 */         CECombatBehaviors.Behavior.builder()
/*  35 */         .custom(CombatCommon::canEscape)
/*  36 */         .withinDistance(0.0D, 8.0D)
/*  37 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  38 */         .addExBehavior(CombatCommon::performEscapeRunAway))
/*     */       
/*  40 */       .addFirstBehavior(
/*  41 */         CECombatBehaviors.Behavior.builder()
/*  42 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  43 */         .custom(CombatCommon::canEscape)
/*  44 */         .withinDistance(0.0D, 48.0D)
/*  45 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  46 */         .addExBehavior(CombatCommon::swapToMelee)))
/*     */ 
/*     */     
/*  49 */     .newBehaviorRoot(
/*  50 */       CECombatBehaviors.BehaviorRoot.builder()
/*  51 */       .priority(3.0D)
/*  52 */       .weight(1000.0D)
/*  53 */       .maxCooldown(0)
/*  54 */       .addFirstBehavior(
/*  55 */         CECombatBehaviors.Behavior.builder()
/*  56 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  57 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  58 */         .custom(CombatCommon::isWrongWeapon)
/*  59 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  60 */         .addExBehavior(CombatCommon::swapToMelee)))
/*     */ 
/*     */     
/*  63 */     .newBehaviorRoot(
/*  64 */       CECombatBehaviors.BehaviorRoot.builder()
/*  65 */       .priority(2.0D)
/*  66 */       .weight(70.0D)
/*  67 */       .maxCooldown(0)
/*  68 */       .addFirstBehavior(
/*  69 */         CECombatBehaviors.Behavior.builder()
/*  70 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  71 */         .custom(CombatCommon::canPerformEating)
/*  72 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  73 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  76 */     .newBehaviorRoot(
/*  77 */       CECombatBehaviors.BehaviorRoot.builder()
/*  78 */       .priority(2.0D)
/*  79 */       .weight(100.0D)
/*  80 */       .maxCooldown(120)
/*  81 */       .addFirstBehavior(
/*  82 */         CECombatBehaviors.Behavior.builder()
/*  83 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  84 */         .custom(CombatCommon::canSwapToBow)
/*  85 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  86 */         .withinDistance(7.0D, 14.0D)
/*  87 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  88 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  90 */       .addFirstBehavior(
/*  91 */         CECombatBehaviors.Behavior.builder()
/*  92 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  93 */         .custom(CombatCommon::canSwapToBow)
/*  94 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  95 */         .withinDistance(7.0D, 14.0D)
/*  96 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  97 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/* 100 */     .newBehaviorRoot(
/* 101 */       CECombatBehaviors.BehaviorRoot.builder()
/* 102 */       .priority(2.0D)
/* 103 */       .weight(80.0D)
/* 104 */       .maxCooldown(120)
/* 105 */       .addFirstBehavior(
/* 106 */         CECombatBehaviors.Behavior.builder()
/* 107 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 108 */         .custom(CombatCommon::canThrowEnderPearl)
/* 109 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 110 */         .withinDistance(7.0D, 48.0D)
/* 111 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 112 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/* 115 */     .newBehaviorRoot(
/* 116 */       CECombatBehaviors.BehaviorRoot.builder()
/* 117 */       .priority(1.0D)
/* 118 */       .weight(40.0D)
/* 119 */       .maxCooldown(20)
/* 120 */       .addFirstBehavior(
/* 121 */         CECombatBehaviors.Behavior.builder()
/* 122 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 123 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 124 */         .withinDistance(0.0D, 3.0D)
/* 125 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 126 */         .addNextBehavior(
/* 127 */           CECombatBehaviors.Behavior.builder()
/* 128 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 129 */           .custom(CombatCommon::canAttackWhileNotHealing)
/* 130 */           .withinDistance(0.0D, 3.0D)
/* 131 */           .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 132 */           .addNextBehavior(
/* 133 */             CECombatBehaviors.Behavior.builder()
/* 134 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */             .custom(CombatCommon::canAttackWhileNotHealing)
/* 136 */             .withinDistance(0.0D, 3.0D)
/* 137 */             .animationBehavior(Animations.FIST_AUTO3, 0.0F))))
/*     */ 
/*     */ 
/*     */       
/* 141 */       .addFirstBehavior(
/* 142 */         CECombatBehaviors.Behavior.builder()
/* 143 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 144 */         .withinDistance(0.0D, 3.0D)
/* 145 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 146 */         .addNextBehavior(
/* 147 */           CECombatBehaviors.Behavior.builder()
/* 148 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 149 */           .withinDistance(0.0D, 3.0D)
/* 150 */           .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 151 */           .addNextBehavior(
/* 152 */             CECombatBehaviors.Behavior.builder()
/* 153 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 154 */             .withinDistance(0.0D, 4.0D)
/* 155 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 156 */             .addNextBehavior(
/* 157 */               CECombatBehaviors.Behavior.builder()
/* 158 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 159 */               .withinDistance(0.0D, 4.0D)
/* 160 */               .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 161 */               .addNextBehavior(
/* 162 */                 CECombatBehaviors.Behavior.builder()
/* 163 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 164 */                 .withinDistance(0.0D, 5.0D)
/* 165 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 166 */                 .addNextBehavior(
/* 167 */                   CECombatBehaviors.Behavior.builder()
/* 168 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 169 */                   .withinDistance(0.0D, 5.0D)
/* 170 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 171 */                   .addNextBehavior(
/* 172 */                     CECombatBehaviors.Behavior.builder()
/* 173 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 174 */                     .withinDistance(0.0D, 5.0D)
/* 175 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       .addFirstBehavior(
/* 185 */         CECombatBehaviors.Behavior.builder()
/* 186 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 187 */         .withinDistance(0.0D, 3.0D)
/* 188 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 189 */         .addNextBehavior(
/* 190 */           CECombatBehaviors.Behavior.builder()
/* 191 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 192 */           .withinDistance(0.0D, 3.0D)
/* 193 */           .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 194 */           .addNextBehavior(
/* 195 */             CECombatBehaviors.Behavior.builder()
/* 196 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 197 */             .withinDistance(0.0D, 4.0D)
/* 198 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 199 */             .addNextBehavior(
/* 200 */               CECombatBehaviors.Behavior.builder()
/* 201 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 202 */               .withinDistance(0.0D, 4.0D)
/* 203 */               .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 204 */               .addNextBehavior(
/* 205 */                 CECombatBehaviors.Behavior.builder()
/* 206 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 207 */                 .withinDistance(0.0D, 5.0D)
/* 208 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 209 */                 .addNextBehavior(
/* 210 */                   CECombatBehaviors.Behavior.builder()
/* 211 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 212 */                   .withinDistance(0.0D, 5.0D)
/* 213 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 221 */       .addFirstBehavior(
/* 222 */         CECombatBehaviors.Behavior.builder()
/* 223 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 224 */         .withinDistance(0.0D, 3.0D)
/* 225 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 226 */         .addNextBehavior(
/* 227 */           CECombatBehaviors.Behavior.builder()
/* 228 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 229 */           .withinDistance(0.0D, 3.0D)
/* 230 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 231 */           .addNextBehavior(
/* 232 */             CECombatBehaviors.Behavior.builder()
/* 233 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 234 */             .withinDistance(0.0D, 4.0D)
/* 235 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 236 */             .addNextBehavior(
/* 237 */               CECombatBehaviors.Behavior.builder()
/* 238 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 239 */               .withinDistance(0.0D, 4.0D)
/* 240 */               .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 241 */               .addNextBehavior(
/* 242 */                 CECombatBehaviors.Behavior.builder()
/* 243 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 244 */                 .withinDistance(0.0D, 5.0D)
/* 245 */                 .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 246 */                 .addNextBehavior(
/* 247 */                   CECombatBehaviors.Behavior.builder()
/* 248 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 249 */                   .withinDistance(0.0D, 5.0D)
/* 250 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 258 */       .addFirstBehavior(
/* 259 */         CECombatBehaviors.Behavior.builder()
/* 260 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 261 */         .withinDistance(0.0D, 3.0D)
/* 262 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 263 */         .addNextBehavior(
/* 264 */           CECombatBehaviors.Behavior.builder()
/* 265 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 266 */           .withinDistance(0.0D, 3.0D)
/* 267 */           .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 268 */           .addNextBehavior(
/* 269 */             CECombatBehaviors.Behavior.builder()
/* 270 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 271 */             .withinDistance(0.0D, 4.0D)
/* 272 */             .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 273 */             .addNextBehavior(
/* 274 */               CECombatBehaviors.Behavior.builder()
/* 275 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 276 */               .withinDistance(0.0D, 4.0D)
/* 277 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 278 */               .addNextBehavior(
/* 279 */                 CECombatBehaviors.Behavior.builder()
/* 280 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 281 */                 .withinDistance(0.0D, 5.0D)
/* 282 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 283 */                 .addNextBehavior(
/* 284 */                   CECombatBehaviors.Behavior.builder()
/* 285 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 286 */                   .withinDistance(0.0D, 5.0D)
/* 287 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 295 */       .addFirstBehavior(
/* 296 */         CECombatBehaviors.Behavior.builder()
/* 297 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 298 */         .withinDistance(0.0D, 3.0D)
/* 299 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 300 */         .addNextBehavior(
/* 301 */           CECombatBehaviors.Behavior.builder()
/* 302 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 303 */           .withinDistance(0.0D, 3.0D)
/* 304 */           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 305 */           .addNextBehavior(
/* 306 */             CECombatBehaviors.Behavior.builder()
/* 307 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 308 */             .withinDistance(0.0D, 4.0D)
/* 309 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 310 */             .addNextBehavior(
/* 311 */               CECombatBehaviors.Behavior.builder()
/* 312 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 313 */               .withinDistance(0.0D, 4.0D)
/* 314 */               .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F)
/* 315 */               .addNextBehavior(
/* 316 */                 CECombatBehaviors.Behavior.builder()
/* 317 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 318 */                 .withinDistance(0.0D, 5.0D)
/* 319 */                 .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 320 */                 .addNextBehavior(
/* 321 */                   CECombatBehaviors.Behavior.builder()
/* 322 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 323 */                   .withinDistance(0.0D, 5.0D)
/* 324 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 325 */                   .addNextBehavior(
/* 326 */                     CECombatBehaviors.Behavior.builder()
/* 327 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 328 */                     .withinDistance(0.0D, 5.0D)
/* 329 */                     .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 338 */       .addFirstBehavior(
/* 339 */         CECombatBehaviors.Behavior.builder()
/* 340 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 341 */         .withinDistance(0.0D, 3.0D)
/* 342 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 343 */         .addNextBehavior(
/* 344 */           CECombatBehaviors.Behavior.builder()
/* 345 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 346 */           .withinDistance(0.0D, 3.0D)
/* 347 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 348 */           .addNextBehavior(
/* 349 */             CECombatBehaviors.Behavior.builder()
/* 350 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 351 */             .withinDistance(0.0D, 4.0D)
/* 352 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 353 */             .addNextBehavior(
/* 354 */               CECombatBehaviors.Behavior.builder()
/* 355 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 356 */               .withinDistance(0.0D, 4.0D)
/* 357 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 358 */               .addNextBehavior(
/* 359 */                 CECombatBehaviors.Behavior.builder()
/* 360 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 361 */                 .withinDistance(0.0D, 5.0D)
/* 362 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 363 */                 .addNextBehavior(
/* 364 */                   CECombatBehaviors.Behavior.builder()
/* 365 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 366 */                   .withinDistance(0.0D, 5.0D)
/* 367 */                   .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 368 */                   .addNextBehavior(
/* 369 */                     CECombatBehaviors.Behavior.builder()
/* 370 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 371 */                     .withinDistance(0.0D, 5.0D)
/* 372 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 381 */       .addFirstBehavior(
/* 382 */         CECombatBehaviors.Behavior.builder()
/* 383 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 384 */         .withinDistance(0.0D, 3.0D)
/* 385 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 386 */         .addNextBehavior(
/* 387 */           CECombatBehaviors.Behavior.builder()
/* 388 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 389 */           .withinDistance(0.0D, 3.0D)
/* 390 */           .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 391 */           .addNextBehavior(
/* 392 */             CECombatBehaviors.Behavior.builder()
/* 393 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 394 */             .withinDistance(0.0D, 4.0D)
/* 395 */             .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 396 */             .addNextBehavior(
/* 397 */               CECombatBehaviors.Behavior.builder()
/* 398 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 399 */               .withinDistance(0.0D, 4.0D)
/* 400 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 401 */               .addNextBehavior(
/* 402 */                 CECombatBehaviors.Behavior.builder()
/* 403 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 404 */                 .withinDistance(0.0D, 5.0D)
/* 405 */                 .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)
/* 406 */                 .addNextBehavior(
/* 407 */                   CECombatBehaviors.Behavior.builder()
/* 408 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 409 */                   .withinDistance(0.0D, 5.0D)
/* 410 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 418 */       .addFirstBehavior(
/* 419 */         CECombatBehaviors.Behavior.builder()
/* 420 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 421 */         .withinDistance(0.0D, 3.0D)
/* 422 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 423 */         .addNextBehavior(
/* 424 */           CECombatBehaviors.Behavior.builder()
/* 425 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 426 */           .withinDistance(0.0D, 3.0D)
/* 427 */           .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 428 */           .addNextBehavior(
/* 429 */             CECombatBehaviors.Behavior.builder()
/* 430 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 431 */             .withinDistance(0.0D, 4.0D)
/* 432 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 433 */             .addNextBehavior(
/* 434 */               CECombatBehaviors.Behavior.builder()
/* 435 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 436 */               .withinDistance(0.0D, 4.0D)
/* 437 */               .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 438 */               .addNextBehavior(
/* 439 */                 CECombatBehaviors.Behavior.builder()
/* 440 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 441 */                 .withinDistance(0.0D, 5.0D)
/* 442 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 443 */                 .addNextBehavior(
/* 444 */                   CECombatBehaviors.Behavior.builder()
/* 445 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 446 */                   .withinDistance(0.0D, 5.0D)
/* 447 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 448 */                   .addNextBehavior(
/* 449 */                     CECombatBehaviors.Behavior.builder()
/* 450 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 451 */                     .withinDistance(0.0D, 5.0D)
/* 452 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 461 */       .addFirstBehavior(
/* 462 */         CECombatBehaviors.Behavior.builder()
/* 463 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 464 */         .withinDistance(0.0D, 3.0D)
/* 465 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 466 */         .addNextBehavior(
/* 467 */           CECombatBehaviors.Behavior.builder()
/* 468 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 469 */           .withinDistance(0.0D, 3.0D)
/* 470 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 471 */           .addNextBehavior(
/* 472 */             CECombatBehaviors.Behavior.builder()
/* 473 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 474 */             .withinDistance(0.0D, 4.0D)
/* 475 */             .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 476 */             .addNextBehavior(
/* 477 */               CECombatBehaviors.Behavior.builder()
/* 478 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 479 */               .withinDistance(0.0D, 4.0D)
/* 480 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 481 */               .addNextBehavior(
/* 482 */                 CECombatBehaviors.Behavior.builder()
/* 483 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 484 */                 .withinDistance(0.0D, 5.0D)
/* 485 */                 .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 486 */                 .addNextBehavior(
/* 487 */                   CECombatBehaviors.Behavior.builder()
/* 488 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 489 */                   .withinDistance(0.0D, 5.0D)
/* 490 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 498 */       .addFirstBehavior(
/* 499 */         CECombatBehaviors.Behavior.builder()
/* 500 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 501 */         .withinDistance(0.0D, 3.0D)
/* 502 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 503 */         .addNextBehavior(
/* 504 */           CECombatBehaviors.Behavior.builder()
/* 505 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 506 */           .withinDistance(0.0D, 3.0D)
/* 507 */           .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F)
/* 508 */           .addNextBehavior(
/* 509 */             CECombatBehaviors.Behavior.builder()
/* 510 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 511 */             .withinDistance(0.0D, 4.0D)
/* 512 */             .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 513 */             .addNextBehavior(
/* 514 */               CECombatBehaviors.Behavior.builder()
/* 515 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 516 */               .withinDistance(0.0D, 4.0D)
/* 517 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 518 */               .addNextBehavior(
/* 519 */                 CECombatBehaviors.Behavior.builder()
/* 520 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 521 */                 .withinDistance(0.0D, 5.0D)
/* 522 */                 .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 523 */                 .addNextBehavior(
/* 524 */                   CECombatBehaviors.Behavior.builder()
/* 525 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 526 */                   .withinDistance(0.0D, 5.0D)
/* 527 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 528 */                   .addNextBehavior(
/* 529 */                     CECombatBehaviors.Behavior.builder()
/* 530 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 531 */                     .withinDistance(0.0D, 5.0D)
/* 532 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 541 */       .addFirstBehavior(
/* 542 */         CECombatBehaviors.Behavior.builder()
/* 543 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 544 */         .withinDistance(0.0D, 3.0D)
/* 545 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 546 */         .addNextBehavior(
/* 547 */           CECombatBehaviors.Behavior.builder()
/* 548 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 549 */           .withinDistance(0.0D, 3.0D)
/* 550 */           .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 551 */           .addNextBehavior(
/* 552 */             CECombatBehaviors.Behavior.builder()
/* 553 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 554 */             .withinDistance(0.0D, 4.0D)
/* 555 */             .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 556 */             .addNextBehavior(
/* 557 */               CECombatBehaviors.Behavior.builder()
/* 558 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 559 */               .withinDistance(0.0D, 4.0D)
/* 560 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 561 */               .addNextBehavior(
/* 562 */                 CECombatBehaviors.Behavior.builder()
/* 563 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 564 */                 .withinDistance(0.0D, 5.0D)
/* 565 */                 .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 566 */                 .addNextBehavior(
/* 567 */                   CECombatBehaviors.Behavior.builder()
/* 568 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 569 */                   .withinDistance(0.0D, 5.0D)
/* 570 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 571 */                   .addNextBehavior(
/* 572 */                     CECombatBehaviors.Behavior.builder()
/* 573 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 574 */                     .withinDistance(0.0D, 5.0D)
/* 575 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 584 */       .addFirstBehavior(
/* 585 */         CECombatBehaviors.Behavior.builder()
/* 586 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 587 */         .withinDistance(0.0D, 3.0D)
/* 588 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 589 */         .addNextBehavior(
/* 590 */           CECombatBehaviors.Behavior.builder()
/* 591 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 592 */           .withinDistance(0.0D, 3.0D)
/* 593 */           .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 594 */           .addNextBehavior(
/* 595 */             CECombatBehaviors.Behavior.builder()
/* 596 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 597 */             .withinDistance(0.0D, 4.0D)
/* 598 */             .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 599 */             .addNextBehavior(
/* 600 */               CECombatBehaviors.Behavior.builder()
/* 601 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 602 */               .withinDistance(0.0D, 4.0D)
/* 603 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 604 */               .addNextBehavior(
/* 605 */                 CECombatBehaviors.Behavior.builder()
/* 606 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 607 */                 .withinDistance(0.0D, 5.0D)
/* 608 */                 .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 609 */                 .addNextBehavior(
/* 610 */                   CECombatBehaviors.Behavior.builder()
/* 611 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 612 */                   .withinDistance(0.0D, 5.0D)
/* 613 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 614 */                   .addNextBehavior(
/* 615 */                     CECombatBehaviors.Behavior.builder()
/* 616 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 617 */                     .withinDistance(0.0D, 5.0D)
/* 618 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 627 */       .addFirstBehavior(
/* 628 */         CECombatBehaviors.Behavior.builder()
/* 629 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 630 */         .withinDistance(0.0D, 3.0D)
/* 631 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 632 */         .addNextBehavior(
/* 633 */           CECombatBehaviors.Behavior.builder()
/* 634 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 635 */           .withinDistance(0.0D, 3.0D)
/* 636 */           .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)
/* 637 */           .addNextBehavior(
/* 638 */             CECombatBehaviors.Behavior.builder()
/* 639 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 640 */             .withinDistance(0.0D, 4.0D)
/* 641 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 642 */             .addNextBehavior(
/* 643 */               CECombatBehaviors.Behavior.builder()
/* 644 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 645 */               .withinDistance(0.0D, 4.0D)
/* 646 */               .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 647 */               .addNextBehavior(
/* 648 */                 CECombatBehaviors.Behavior.builder()
/* 649 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 650 */                 .withinDistance(0.0D, 5.0D)
/* 651 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 652 */                 .addNextBehavior(
/* 653 */                   CECombatBehaviors.Behavior.builder()
/* 654 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 655 */                   .withinDistance(0.0D, 5.0D)
/* 656 */                   .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 657 */                   .addNextBehavior(
/* 658 */                     CECombatBehaviors.Behavior.builder()
/* 659 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 660 */                     .withinDistance(0.0D, 5.0D)
/* 661 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 670 */       .addFirstBehavior(
/* 671 */         CECombatBehaviors.Behavior.builder()
/* 672 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 673 */         .withinDistance(0.0D, 3.0D)
/* 674 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 675 */         .addNextBehavior(
/* 676 */           CECombatBehaviors.Behavior.builder()
/* 677 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 678 */           .withinDistance(0.0D, 3.0D)
/* 679 */           .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 680 */           .addNextBehavior(
/* 681 */             CECombatBehaviors.Behavior.builder()
/* 682 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 683 */             .withinDistance(0.0D, 4.0D)
/* 684 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 685 */             .addNextBehavior(
/* 686 */               CECombatBehaviors.Behavior.builder()
/* 687 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 688 */               .withinDistance(0.0D, 4.0D)
/* 689 */               .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 690 */               .addNextBehavior(
/* 691 */                 CECombatBehaviors.Behavior.builder()
/* 692 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 693 */                 .withinDistance(0.0D, 5.0D)
/* 694 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 695 */                 .addNextBehavior(
/* 696 */                   CECombatBehaviors.Behavior.builder()
/* 697 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 698 */                   .withinDistance(0.0D, 5.0D)
/* 699 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 707 */       .addFirstBehavior(
/* 708 */         CECombatBehaviors.Behavior.builder()
/* 709 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 710 */         .withinDistance(0.0D, 3.0D)
/* 711 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 712 */         .addNextBehavior(
/* 713 */           CECombatBehaviors.Behavior.builder()
/* 714 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 715 */           .withinDistance(0.0D, 3.0D)
/* 716 */           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 717 */           .addNextBehavior(
/* 718 */             CECombatBehaviors.Behavior.builder()
/* 719 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 720 */             .withinDistance(0.0D, 4.0D)
/* 721 */             .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 722 */             .addNextBehavior(
/* 723 */               CECombatBehaviors.Behavior.builder()
/* 724 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 725 */               .withinDistance(0.0D, 4.0D)
/* 726 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 727 */               .addNextBehavior(
/* 728 */                 CECombatBehaviors.Behavior.builder()
/* 729 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 730 */                 .withinDistance(0.0D, 5.0D)
/* 731 */                 .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 732 */                 .addNextBehavior(
/* 733 */                   CECombatBehaviors.Behavior.builder()
/* 734 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 735 */                   .withinDistance(0.0D, 5.0D)
/* 736 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 737 */                   .addNextBehavior(
/* 738 */                     CECombatBehaviors.Behavior.builder()
/* 739 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 740 */                     .withinDistance(0.0D, 5.0D)
/* 741 */                     .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 750 */     .newBehaviorRoot(
/* 751 */       CECombatBehaviors.BehaviorRoot.builder()
/* 752 */       .priority(1.0D)
/* 753 */       .weight(20.0D)
/* 754 */       .maxCooldown(100)
/* 755 */       .addFirstBehavior(
/* 756 */         CECombatBehaviors.Behavior.builder()
/* 757 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 758 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 759 */         .withinDistance(0.0D, 3.0D)
/* 760 */         .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 761 */         .addNextBehavior(
/* 762 */           CECombatBehaviors.Behavior.builder()
/* 763 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 764 */           .custom(CombatCommon::canAttackWhileNotHealing)
/* 765 */           .withinDistance(0.0D, 3.0D)
/* 766 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 767 */           .addNextBehavior(
/* 768 */             CECombatBehaviors.Behavior.builder()
/* 769 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 770 */             .custom(CombatCommon::canAttackWhileNotHealing)
/* 771 */             .withinDistance(0.0D, 3.0D)
/* 772 */             .animationBehavior(AVAnimations.FIST_DASH, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 777 */     .newBehaviorRoot(
/* 778 */       CECombatBehaviors.BehaviorRoot.builder()
/* 779 */       .priority(1.0D)
/* 780 */       .weight(10.0D)
/* 781 */       .maxCooldown(100)
/* 782 */       .addFirstBehavior(
/* 783 */         CECombatBehaviors.Behavior.builder()
/* 784 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 785 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 786 */         .withinDistance(0.0D, 3.0D)
/* 787 */         .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F))
/*     */       
/* 789 */       .addFirstBehavior(
/* 790 */         CECombatBehaviors.Behavior.builder()
/* 791 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 792 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 793 */         .withinDistance(0.0D, 3.0D)
/* 794 */         .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F))
/*     */       
/* 796 */       .addFirstBehavior(
/* 797 */         CECombatBehaviors.Behavior.builder()
/* 798 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 799 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 800 */         .withinDistance(0.0D, 3.0D)
/* 801 */         .animationBehavior(Animations.FIST_DASH, 0.0F))
/*     */       
/* 803 */       .addFirstBehavior(
/* 804 */         CECombatBehaviors.Behavior.builder()
/* 805 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 806 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 807 */         .withinDistance(0.0D, 3.0D)
/* 808 */         .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F))
/*     */       
/* 810 */       .addFirstBehavior(
/* 811 */         CECombatBehaviors.Behavior.builder()
/* 812 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 813 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 814 */         .withinDistance(0.0D, 3.0D)
/* 815 */         .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)))
/*     */ 
/*     */     
/* 818 */     .newBehaviorRoot(
/* 819 */       CECombatBehaviors.BehaviorRoot.builder()
/* 820 */       .priority(1.0D)
/* 821 */       .weight(10.0D)
/* 822 */       .maxCooldown(40)
/* 823 */       .addFirstBehavior(
/* 824 */         CECombatBehaviors.Behavior.builder()
/* 825 */         .withinDistance(0.0D, 3.0D)
/* 826 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 827 */         .custom(CombatCommon::canThrowEnderPearl)
/* 828 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 829 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 830 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 833 */     .newBehaviorRoot(
/* 834 */       CECombatBehaviors.BehaviorRoot.builder()
/* 835 */       .priority(1.0D)
/* 836 */       .weight(2.0D)
/* 837 */       .maxCooldown(100)
/* 838 */       .addFirstBehavior(
/* 839 */         CECombatBehaviors.Behavior.builder()
/* 840 */         .withinDistance(0.0D, 3.0D)
/* 841 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 842 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 843 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 845 */       .addFirstBehavior(
/* 846 */         CECombatBehaviors.Behavior.builder()
/* 847 */         .withinDistance(0.0D, 3.0D)
/* 848 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 849 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 850 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 852 */       .addFirstBehavior(
/* 853 */         CECombatBehaviors.Behavior.builder()
/* 854 */         .withinDistance(0.0D, 3.0D)
/* 855 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 856 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 857 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 859 */       .addFirstBehavior(
/* 860 */         CECombatBehaviors.Behavior.builder()
/* 861 */         .withinDistance(0.0D, 3.0D)
/* 862 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 863 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 864 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 866 */       .addFirstBehavior(
/* 867 */         CECombatBehaviors.Behavior.builder()
/* 868 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 869 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 870 */         .withinDistance(0.0D, 3.0D)
/* 871 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 873 */       .addFirstBehavior(
/* 874 */         CECombatBehaviors.Behavior.builder()
/* 875 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 876 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 877 */         .withinDistance(0.0D, 3.0D)
/* 878 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 880 */       .addFirstBehavior(
/* 881 */         CECombatBehaviors.Behavior.builder()
/* 882 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 883 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 884 */         .withinDistance(0.0D, 3.0D)
/* 885 */         .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)))
/*     */ 
/*     */     
/* 888 */     .newBehaviorRoot(
/* 889 */       CECombatBehaviors.BehaviorRoot.builder()
/* 890 */       .priority(1.0D)
/* 891 */       .weight(10.0D)
/* 892 */       .addFirstBehavior(
/* 893 */         CECombatBehaviors.Behavior.builder()
/* 894 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 895 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 896 */         .withinDistance(0.0D, 3.0D)
/* 897 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 899 */       .addFirstBehavior(
/* 900 */         CECombatBehaviors.Behavior.builder()
/* 901 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 902 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 903 */         .withinDistance(0.0D, 3.0D)
/* 904 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*     */ 
/*     */     
/* 907 */     .newBehaviorRoot(
/* 908 */       CECombatBehaviors.BehaviorRoot.builder()
/* 909 */       .priority(1.0D)
/* 910 */       .weight(40.0D)
/* 911 */       .maxCooldown(160)
/* 912 */       .addFirstBehavior(
/* 913 */         CECombatBehaviors.Behavior.builder()
/* 914 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 915 */         .custom(CombatCommon::canJump)
/* 916 */         .withinDistance(5.0D, 14.0D)
/* 917 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 918 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcFist.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */