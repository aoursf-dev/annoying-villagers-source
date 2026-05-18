/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.efkick.gameasset.EFKickAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerNpcWoodenDoor
/*     */ {
/*  15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> WOODEN_DOOR = CECombatBehaviors.builder()
/*  16 */     .newBehaviorRoot(
/*  17 */       CECombatBehaviors.BehaviorRoot.builder()
/*  18 */       .priority(4.0D)
/*  19 */       .weight(1000.0D)
/*  20 */       .maxCooldown(0)
/*  21 */       .addFirstBehavior(
/*  22 */         CECombatBehaviors.Behavior.builder()
/*  23 */         .custom(CombatCommon::canExecute)
/*  24 */         .withinDistance(0.0D, 5.0D)
/*  25 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  26 */         .addExBehavior(CombatCommon::performExecute)))
/*     */ 
/*     */     
/*  29 */     .newBehaviorRoot(
/*  30 */       CECombatBehaviors.BehaviorRoot.builder()
/*  31 */       .priority(3.0D)
/*  32 */       .weight(1000.0D)
/*  33 */       .maxCooldown(0)
/*  34 */       .addFirstBehavior(
/*  35 */         CECombatBehaviors.Behavior.builder()
/*  36 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  37 */         .custom(CombatCommon::canEscape)
/*  38 */         .withinDistance(0.0D, 8.0D)
/*  39 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  40 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*     */       
/*  42 */       .addFirstBehavior(
/*  43 */         CECombatBehaviors.Behavior.builder()
/*  44 */         .custom(CombatCommon::canEscape)
/*  45 */         .withinDistance(0.0D, 48.0D)
/*  46 */         .guard(40)))
/*     */ 
/*     */     
/*  49 */     .newBehaviorRoot(
/*  50 */       CECombatBehaviors.BehaviorRoot.builder()
/*  51 */       .priority(2.0D)
/*  52 */       .weight(70.0D)
/*  53 */       .maxCooldown(0)
/*  54 */       .addFirstBehavior(
/*  55 */         CECombatBehaviors.Behavior.builder()
/*  56 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  57 */         .custom(CombatCommon::canPerformEating)
/*  58 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  59 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  62 */     .newBehaviorRoot(
/*  63 */       CECombatBehaviors.BehaviorRoot.builder()
/*  64 */       .priority(2.0D)
/*  65 */       .weight(100.0D)
/*  66 */       .maxCooldown(120)
/*  67 */       .addFirstBehavior(
/*  68 */         CECombatBehaviors.Behavior.builder()
/*  69 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  70 */         .custom(CombatCommon::canSwapToBow)
/*  71 */         .withinDistance(7.0D, 14.0D)
/*  72 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  73 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  75 */       .addFirstBehavior(
/*  76 */         CECombatBehaviors.Behavior.builder()
/*  77 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  78 */         .custom(CombatCommon::canSwapToBow)
/*  79 */         .withinDistance(7.0D, 14.0D)
/*  80 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  81 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/*  84 */     .newBehaviorRoot(
/*  85 */       CECombatBehaviors.BehaviorRoot.builder()
/*  86 */       .priority(2.0D)
/*  87 */       .weight(80.0D)
/*  88 */       .maxCooldown(120)
/*  89 */       .addFirstBehavior(
/*  90 */         CECombatBehaviors.Behavior.builder()
/*  91 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  92 */         .custom(CombatCommon::canThrowEnderPearl)
/*  93 */         .withinDistance(7.0D, 48.0D)
/*  94 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  95 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/*  98 */     .newBehaviorRoot(
/*  99 */       CECombatBehaviors.BehaviorRoot.builder()
/* 100 */       .priority(1.0D)
/* 101 */       .weight(40.0D)
/* 102 */       .maxCooldown(20)
/* 103 */       .addFirstBehavior(
/* 104 */         CECombatBehaviors.Behavior.builder()
/* 105 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 106 */         .withinDistance(0.0D, 3.0D)
/* 107 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 108 */         .addNextBehavior(
/* 109 */           CECombatBehaviors.Behavior.builder()
/* 110 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 111 */           .withinDistance(0.0D, 3.0D)
/* 112 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 113 */           .addNextBehavior(
/* 114 */             CECombatBehaviors.Behavior.builder()
/* 115 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 116 */             .withinDistance(0.0D, 3.0D)
/* 117 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 118 */             .addNextBehavior(
/* 119 */               CECombatBehaviors.Behavior.builder()
/* 120 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 121 */               .withinDistance(0.0D, 3.0D)
/* 122 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 127 */       .addFirstBehavior(
/* 128 */         CECombatBehaviors.Behavior.builder()
/* 129 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 130 */         .withinDistance(0.0D, 3.0D)
/* 131 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 132 */         .addNextBehavior(
/* 133 */           CECombatBehaviors.Behavior.builder()
/* 134 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */           .withinDistance(0.0D, 3.0D)
/* 136 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 137 */           .addNextBehavior(
/* 138 */             CECombatBehaviors.Behavior.builder()
/* 139 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 140 */             .withinDistance(0.0D, 4.0D)
/* 141 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 142 */             .addNextBehavior(
/* 143 */               CECombatBehaviors.Behavior.builder()
/* 144 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 145 */               .withinDistance(0.0D, 4.0D)
/* 146 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 147 */               .addNextBehavior(
/* 148 */                 CECombatBehaviors.Behavior.builder()
/* 149 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 150 */                 .withinDistance(0.0D, 5.0D)
/* 151 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       .addFirstBehavior(
/* 159 */         CECombatBehaviors.Behavior.builder()
/* 160 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 161 */         .withinDistance(0.0D, 3.0D)
/* 162 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 163 */         .addNextBehavior(
/* 164 */           CECombatBehaviors.Behavior.builder()
/* 165 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 166 */           .withinDistance(0.0D, 3.0D)
/* 167 */           .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 168 */           .addNextBehavior(
/* 169 */             CECombatBehaviors.Behavior.builder()
/* 170 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 171 */             .withinDistance(0.0D, 4.0D)
/* 172 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 173 */             .addNextBehavior(
/* 174 */               CECombatBehaviors.Behavior.builder()
/* 175 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 176 */               .withinDistance(0.0D, 4.0D)
/* 177 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 178 */               .addNextBehavior(
/* 179 */                 CECombatBehaviors.Behavior.builder()
/* 180 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 181 */                 .withinDistance(0.0D, 5.0D)
/* 182 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 189 */       .addFirstBehavior(
/* 190 */         CECombatBehaviors.Behavior.builder()
/* 191 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 192 */         .withinDistance(0.0D, 3.0D)
/* 193 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 194 */         .addNextBehavior(
/* 195 */           CECombatBehaviors.Behavior.builder()
/* 196 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 197 */           .withinDistance(0.0D, 3.0D)
/* 198 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 199 */           .addNextBehavior(
/* 200 */             CECombatBehaviors.Behavior.builder()
/* 201 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 202 */             .withinDistance(0.0D, 4.0D)
/* 203 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 204 */             .addNextBehavior(
/* 205 */               CECombatBehaviors.Behavior.builder()
/* 206 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 207 */               .withinDistance(0.0D, 4.0D)
/* 208 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 209 */               .addNextBehavior(
/* 210 */                 CECombatBehaviors.Behavior.builder()
/* 211 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 212 */                 .withinDistance(0.0D, 5.0D)
/* 213 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 214 */                 .addNextBehavior(
/* 215 */                   CECombatBehaviors.Behavior.builder()
/* 216 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 217 */                   .withinDistance(0.0D, 5.0D)
/* 218 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 226 */       .addFirstBehavior(
/* 227 */         CECombatBehaviors.Behavior.builder()
/* 228 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 229 */         .withinDistance(0.0D, 3.0D)
/* 230 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 231 */         .addNextBehavior(
/* 232 */           CECombatBehaviors.Behavior.builder()
/* 233 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 234 */           .withinDistance(0.0D, 3.0D)
/* 235 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 236 */           .addNextBehavior(
/* 237 */             CECombatBehaviors.Behavior.builder()
/* 238 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 239 */             .withinDistance(0.0D, 4.0D)
/* 240 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 241 */             .addNextBehavior(
/* 242 */               CECombatBehaviors.Behavior.builder()
/* 243 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 244 */               .withinDistance(0.0D, 4.0D)
/* 245 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 246 */               .addNextBehavior(
/* 247 */                 CECombatBehaviors.Behavior.builder()
/* 248 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 249 */                 .withinDistance(0.0D, 5.0D)
/* 250 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 251 */                 .addNextBehavior(
/* 252 */                   CECombatBehaviors.Behavior.builder()
/* 253 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 254 */                   .withinDistance(0.0D, 5.0D)
/* 255 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 263 */       .addFirstBehavior(
/* 264 */         CECombatBehaviors.Behavior.builder()
/* 265 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 266 */         .withinDistance(0.0D, 3.0D)
/* 267 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 268 */         .addNextBehavior(
/* 269 */           CECombatBehaviors.Behavior.builder()
/* 270 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 271 */           .withinDistance(0.0D, 3.0D)
/* 272 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 273 */           .addNextBehavior(
/* 274 */             CECombatBehaviors.Behavior.builder()
/* 275 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 276 */             .withinDistance(0.0D, 4.0D)
/* 277 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 278 */             .addNextBehavior(
/* 279 */               CECombatBehaviors.Behavior.builder()
/* 280 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 281 */               .withinDistance(0.0D, 4.0D)
/* 282 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 283 */               .addNextBehavior(
/* 284 */                 CECombatBehaviors.Behavior.builder()
/* 285 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 286 */                 .withinDistance(0.0D, 5.0D)
/* 287 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 294 */       .addFirstBehavior(
/* 295 */         CECombatBehaviors.Behavior.builder()
/* 296 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 297 */         .withinDistance(0.0D, 3.0D)
/* 298 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 299 */         .addNextBehavior(
/* 300 */           CECombatBehaviors.Behavior.builder()
/* 301 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 302 */           .withinDistance(0.0D, 3.0D)
/* 303 */           .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 304 */           .addNextBehavior(
/* 305 */             CECombatBehaviors.Behavior.builder()
/* 306 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 307 */             .withinDistance(0.0D, 4.0D)
/* 308 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 309 */             .addNextBehavior(
/* 310 */               CECombatBehaviors.Behavior.builder()
/* 311 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 312 */               .withinDistance(0.0D, 4.0D)
/* 313 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 314 */               .addNextBehavior(
/* 315 */                 CECombatBehaviors.Behavior.builder()
/* 316 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 317 */                 .withinDistance(0.0D, 5.0D)
/* 318 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 319 */                 .addNextBehavior(
/* 320 */                   CECombatBehaviors.Behavior.builder()
/* 321 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 322 */                   .withinDistance(0.0D, 5.0D)
/* 323 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 324 */                   .addNextBehavior(
/* 325 */                     CECombatBehaviors.Behavior.builder()
/* 326 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 327 */                     .withinDistance(0.0D, 5.0D)
/* 328 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 337 */       .addFirstBehavior(
/* 338 */         CECombatBehaviors.Behavior.builder()
/* 339 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 340 */         .withinDistance(0.0D, 3.0D)
/* 341 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 342 */         .addNextBehavior(
/* 343 */           CECombatBehaviors.Behavior.builder()
/* 344 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 345 */           .withinDistance(0.0D, 3.0D)
/* 346 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 347 */           .addNextBehavior(
/* 348 */             CECombatBehaviors.Behavior.builder()
/* 349 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 350 */             .withinDistance(0.0D, 4.0D)
/* 351 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 352 */             .addNextBehavior(
/* 353 */               CECombatBehaviors.Behavior.builder()
/* 354 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 355 */               .withinDistance(0.0D, 4.0D)
/* 356 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 357 */               .addNextBehavior(
/* 358 */                 CECombatBehaviors.Behavior.builder()
/* 359 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 360 */                 .withinDistance(0.0D, 5.0D)
/* 361 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 362 */                 .addNextBehavior(
/* 363 */                   CECombatBehaviors.Behavior.builder()
/* 364 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 365 */                   .withinDistance(0.0D, 5.0D)
/* 366 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 374 */       .addFirstBehavior(
/* 375 */         CECombatBehaviors.Behavior.builder()
/* 376 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 377 */         .withinDistance(0.0D, 3.0D)
/* 378 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 379 */         .addNextBehavior(
/* 380 */           CECombatBehaviors.Behavior.builder()
/* 381 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 382 */           .withinDistance(0.0D, 3.0D)
/* 383 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 384 */           .addNextBehavior(
/* 385 */             CECombatBehaviors.Behavior.builder()
/* 386 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 387 */             .withinDistance(0.0D, 4.0D)
/* 388 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 389 */             .addNextBehavior(
/* 390 */               CECombatBehaviors.Behavior.builder()
/* 391 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 392 */               .withinDistance(0.0D, 4.0D)
/* 393 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 394 */               .addNextBehavior(
/* 395 */                 CECombatBehaviors.Behavior.builder()
/* 396 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 397 */                 .withinDistance(0.0D, 5.0D)
/* 398 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 405 */       .addFirstBehavior(
/* 406 */         CECombatBehaviors.Behavior.builder()
/* 407 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 408 */         .withinDistance(0.0D, 3.0D)
/* 409 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 410 */         .addNextBehavior(
/* 411 */           CECombatBehaviors.Behavior.builder()
/* 412 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 413 */           .withinDistance(0.0D, 3.0D)
/* 414 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 415 */           .addNextBehavior(
/* 416 */             CECombatBehaviors.Behavior.builder()
/* 417 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 418 */             .withinDistance(0.0D, 4.0D)
/* 419 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 420 */             .addNextBehavior(
/* 421 */               CECombatBehaviors.Behavior.builder()
/* 422 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 423 */               .withinDistance(0.0D, 4.0D)
/* 424 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 425 */               .addNextBehavior(
/* 426 */                 CECombatBehaviors.Behavior.builder()
/* 427 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 428 */                 .withinDistance(0.0D, 5.0D)
/* 429 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 430 */                 .addNextBehavior(
/* 431 */                   CECombatBehaviors.Behavior.builder()
/* 432 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 433 */                   .withinDistance(0.0D, 5.0D)
/* 434 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 442 */       .addFirstBehavior(
/* 443 */         CECombatBehaviors.Behavior.builder()
/* 444 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 445 */         .withinDistance(0.0D, 3.0D)
/* 446 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 447 */         .addNextBehavior(
/* 448 */           CECombatBehaviors.Behavior.builder()
/* 449 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 450 */           .withinDistance(0.0D, 3.0D)
/* 451 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 452 */           .addNextBehavior(
/* 453 */             CECombatBehaviors.Behavior.builder()
/* 454 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 455 */             .withinDistance(0.0D, 4.0D)
/* 456 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 457 */             .addNextBehavior(
/* 458 */               CECombatBehaviors.Behavior.builder()
/* 459 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 460 */               .withinDistance(0.0D, 4.0D)
/* 461 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 462 */               .addNextBehavior(
/* 463 */                 CECombatBehaviors.Behavior.builder()
/* 464 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 465 */                 .withinDistance(0.0D, 5.0D)
/* 466 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 467 */                 .addNextBehavior(
/* 468 */                   CECombatBehaviors.Behavior.builder()
/* 469 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 470 */                   .withinDistance(0.0D, 5.0D)
/* 471 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 472 */                   .addNextBehavior(
/* 473 */                     CECombatBehaviors.Behavior.builder()
/* 474 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 475 */                     .withinDistance(0.0D, 5.0D)
/* 476 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 485 */       .addFirstBehavior(
/* 486 */         CECombatBehaviors.Behavior.builder()
/* 487 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 488 */         .withinDistance(0.0D, 3.0D)
/* 489 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 490 */         .addNextBehavior(
/* 491 */           CECombatBehaviors.Behavior.builder()
/* 492 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 493 */           .withinDistance(0.0D, 3.0D)
/* 494 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 495 */           .addNextBehavior(
/* 496 */             CECombatBehaviors.Behavior.builder()
/* 497 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 498 */             .withinDistance(0.0D, 4.0D)
/* 499 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 500 */             .addNextBehavior(
/* 501 */               CECombatBehaviors.Behavior.builder()
/* 502 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 503 */               .withinDistance(0.0D, 4.0D)
/* 504 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 505 */               .addNextBehavior(
/* 506 */                 CECombatBehaviors.Behavior.builder()
/* 507 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 508 */                 .withinDistance(0.0D, 5.0D)
/* 509 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 516 */       .addFirstBehavior(
/* 517 */         CECombatBehaviors.Behavior.builder()
/* 518 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 519 */         .withinDistance(0.0D, 3.0D)
/* 520 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 521 */         .addNextBehavior(
/* 522 */           CECombatBehaviors.Behavior.builder()
/* 523 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 524 */           .withinDistance(0.0D, 3.0D)
/* 525 */           .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 526 */           .addNextBehavior(
/* 527 */             CECombatBehaviors.Behavior.builder()
/* 528 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 529 */             .withinDistance(0.0D, 4.0D)
/* 530 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 531 */             .addNextBehavior(
/* 532 */               CECombatBehaviors.Behavior.builder()
/* 533 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 534 */               .withinDistance(0.0D, 4.0D)
/* 535 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 536 */               .addNextBehavior(
/* 537 */                 CECombatBehaviors.Behavior.builder()
/* 538 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 539 */                 .withinDistance(0.0D, 5.0D)
/* 540 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 541 */                 .addNextBehavior(
/* 542 */                   CECombatBehaviors.Behavior.builder()
/* 543 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 544 */                   .withinDistance(0.0D, 5.0D)
/* 545 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 553 */       .addFirstBehavior(
/* 554 */         CECombatBehaviors.Behavior.builder()
/* 555 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 556 */         .withinDistance(0.0D, 3.0D)
/* 557 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 558 */         .addNextBehavior(
/* 559 */           CECombatBehaviors.Behavior.builder()
/* 560 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 561 */           .withinDistance(0.0D, 3.0D)
/* 562 */           .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 563 */           .addNextBehavior(
/* 564 */             CECombatBehaviors.Behavior.builder()
/* 565 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 566 */             .withinDistance(0.0D, 4.0D)
/* 567 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 568 */             .addNextBehavior(
/* 569 */               CECombatBehaviors.Behavior.builder()
/* 570 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 571 */               .withinDistance(0.0D, 4.0D)
/* 572 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 573 */               .addNextBehavior(
/* 574 */                 CECombatBehaviors.Behavior.builder()
/* 575 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 576 */                 .withinDistance(0.0D, 5.0D)
/* 577 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 578 */                 .addNextBehavior(
/* 579 */                   CECombatBehaviors.Behavior.builder()
/* 580 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 581 */                   .withinDistance(0.0D, 5.0D)
/* 582 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 590 */       .addFirstBehavior(
/* 591 */         CECombatBehaviors.Behavior.builder()
/* 592 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 593 */         .withinDistance(0.0D, 3.0D)
/* 594 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 595 */         .addNextBehavior(
/* 596 */           CECombatBehaviors.Behavior.builder()
/* 597 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 598 */           .withinDistance(0.0D, 3.0D)
/* 599 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 600 */           .addNextBehavior(
/* 601 */             CECombatBehaviors.Behavior.builder()
/* 602 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 603 */             .withinDistance(0.0D, 4.0D)
/* 604 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 605 */             .addNextBehavior(
/* 606 */               CECombatBehaviors.Behavior.builder()
/* 607 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 608 */               .withinDistance(0.0D, 4.0D)
/* 609 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 610 */               .addNextBehavior(
/* 611 */                 CECombatBehaviors.Behavior.builder()
/* 612 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 613 */                 .withinDistance(0.0D, 5.0D)
/* 614 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 615 */                 .addNextBehavior(
/* 616 */                   CECombatBehaviors.Behavior.builder()
/* 617 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 618 */                   .withinDistance(0.0D, 5.0D)
/* 619 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 620 */                   .addNextBehavior(
/* 621 */                     CECombatBehaviors.Behavior.builder()
/* 622 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 623 */                     .withinDistance(0.0D, 5.0D)
/* 624 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 633 */       .addFirstBehavior(
/* 634 */         CECombatBehaviors.Behavior.builder()
/* 635 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 636 */         .withinDistance(0.0D, 3.0D)
/* 637 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 638 */         .addNextBehavior(
/* 639 */           CECombatBehaviors.Behavior.builder()
/* 640 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 641 */           .withinDistance(0.0D, 3.0D)
/* 642 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 643 */           .addNextBehavior(
/* 644 */             CECombatBehaviors.Behavior.builder()
/* 645 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 646 */             .withinDistance(0.0D, 4.0D)
/* 647 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 648 */             .addNextBehavior(
/* 649 */               CECombatBehaviors.Behavior.builder()
/* 650 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 651 */               .withinDistance(0.0D, 4.0D)
/* 652 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 653 */               .addNextBehavior(
/* 654 */                 CECombatBehaviors.Behavior.builder()
/* 655 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 656 */                 .withinDistance(0.0D, 5.0D)
/* 657 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 658 */                 .addNextBehavior(
/* 659 */                   CECombatBehaviors.Behavior.builder()
/* 660 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 661 */                   .withinDistance(0.0D, 5.0D)
/* 662 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 671 */     .newBehaviorRoot(
/* 672 */       CECombatBehaviors.BehaviorRoot.builder()
/* 673 */       .priority(1.0D)
/* 674 */       .weight(20.0D)
/* 675 */       .maxCooldown(100)
/* 676 */       .addFirstBehavior(
/* 677 */         CECombatBehaviors.Behavior.builder()
/* 678 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 679 */         .withinDistance(0.0D, 3.0D)
/* 680 */         .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)))
/*     */ 
/*     */     
/* 683 */     .newBehaviorRoot(
/* 684 */       CECombatBehaviors.BehaviorRoot.builder()
/* 685 */       .priority(1.0D)
/* 686 */       .weight(10.0D)
/* 687 */       .maxCooldown(100)
/* 688 */       .addFirstBehavior(
/* 689 */         CECombatBehaviors.Behavior.builder()
/* 690 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 691 */         .withinDistance(0.0D, 3.0D)
/* 692 */         .animationBehavior(Animations.GREATSWORD_DASH, 0.0F))
/*     */       
/* 694 */       .addFirstBehavior(
/* 695 */         CECombatBehaviors.Behavior.builder()
/* 696 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 697 */         .withinDistance(0.0D, 3.0D)
/* 698 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F))
/*     */       
/* 700 */       .addFirstBehavior(
/* 701 */         CECombatBehaviors.Behavior.builder()
/* 702 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 703 */         .withinDistance(0.0D, 3.0D)
/* 704 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)))
/*     */ 
/*     */     
/* 707 */     .newBehaviorRoot(
/* 708 */       CECombatBehaviors.BehaviorRoot.builder()
/* 709 */       .priority(1.0D)
/* 710 */       .weight(10.0D)
/* 711 */       .maxCooldown(40)
/* 712 */       .addFirstBehavior(
/* 713 */         CECombatBehaviors.Behavior.builder()
/* 714 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 715 */         .withinDistance(0.0D, 3.0D)
/* 716 */         .custom(CombatCommon::canThrowEnderPearl)
/* 717 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 718 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 719 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 722 */     .newBehaviorRoot(
/* 723 */       CECombatBehaviors.BehaviorRoot.builder()
/* 724 */       .priority(1.0D)
/* 725 */       .weight(2.0D)
/* 726 */       .maxCooldown(100)
/* 727 */       .addFirstBehavior(
/* 728 */         CECombatBehaviors.Behavior.builder()
/* 729 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 730 */         .withinDistance(0.0D, 3.0D)
/* 731 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 733 */       .addFirstBehavior(
/* 734 */         CECombatBehaviors.Behavior.builder()
/* 735 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 736 */         .withinDistance(0.0D, 3.0D)
/* 737 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 739 */       .addFirstBehavior(
/* 740 */         CECombatBehaviors.Behavior.builder()
/* 741 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 742 */         .withinDistance(0.0D, 3.0D)
/* 743 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 745 */       .addFirstBehavior(
/* 746 */         CECombatBehaviors.Behavior.builder()
/* 747 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 748 */         .withinDistance(0.0D, 3.0D)
/* 749 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 751 */       .addFirstBehavior(
/* 752 */         CECombatBehaviors.Behavior.builder()
/* 753 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 754 */         .withinDistance(0.0D, 3.0D)
/* 755 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 757 */       .addFirstBehavior(
/* 758 */         CECombatBehaviors.Behavior.builder()
/* 759 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 760 */         .withinDistance(0.0D, 3.0D)
/* 761 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 763 */       .addFirstBehavior(
/* 764 */         CECombatBehaviors.Behavior.builder()
/* 765 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 766 */         .withinDistance(0.0D, 3.0D)
/* 767 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 770 */     .newBehaviorRoot(
/* 771 */       CECombatBehaviors.BehaviorRoot.builder()
/* 772 */       .priority(1.0D)
/* 773 */       .weight(15.0D)
/* 774 */       .addFirstBehavior(
/* 775 */         CECombatBehaviors.Behavior.builder()
/* 776 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 777 */         .withinDistance(0.0D, 3.0D)
/* 778 */         .custom(CombatCommon::canPerformGuarding)
/* 779 */         .guard(40)))
/*     */ 
/*     */     
/* 782 */     .newBehaviorRoot(
/* 783 */       CECombatBehaviors.BehaviorRoot.builder()
/* 784 */       .priority(1.0D)
/* 785 */       .weight(10.0D)
/* 786 */       .addFirstBehavior(
/* 787 */         CECombatBehaviors.Behavior.builder()
/* 788 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 789 */         .withinDistance(0.0D, 3.0D)
/* 790 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 792 */       .addFirstBehavior(
/* 793 */         CECombatBehaviors.Behavior.builder()
/* 794 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 795 */         .withinDistance(0.0D, 3.0D)
/* 796 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))
/*     */ 
/*     */     
/* 799 */     .newBehaviorRoot(
/* 800 */       CECombatBehaviors.BehaviorRoot.builder()
/* 801 */       .priority(1.0D)
/* 802 */       .weight(40.0D)
/* 803 */       .maxCooldown(160)
/* 804 */       .addFirstBehavior(
/* 805 */         CECombatBehaviors.Behavior.builder()
/* 806 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 807 */         .custom(CombatCommon::canJump)
/* 808 */         .withinDistance(5.0D, 14.0D)
/* 809 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 810 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcWoodenDoor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */