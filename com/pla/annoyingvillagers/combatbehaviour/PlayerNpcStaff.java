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
/*     */ 
/*     */ 
/*     */ public class PlayerNpcStaff
/*     */ {
/*  17 */   public static final CECombatBehaviors.Builder<MobPatch<?>> STAFF = CECombatBehaviors.builder()
/*  18 */     .newBehaviorRoot(
/*  19 */       CECombatBehaviors.BehaviorRoot.builder()
/*  20 */       .priority(4.0D)
/*  21 */       .weight(1000.0D)
/*  22 */       .maxCooldown(0)
/*  23 */       .addFirstBehavior(
/*  24 */         CECombatBehaviors.Behavior.builder()
/*  25 */         .custom(CombatCommon::canExecute)
/*  26 */         .withinDistance(0.0D, 5.0D)
/*  27 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  28 */         .addExBehavior(CombatCommon::performExecute)))
/*     */ 
/*     */     
/*  31 */     .newBehaviorRoot(
/*  32 */       CECombatBehaviors.BehaviorRoot.builder()
/*  33 */       .priority(3.0D)
/*  34 */       .weight(1000.0D)
/*  35 */       .maxCooldown(0)
/*  36 */       .addFirstBehavior(
/*  37 */         CECombatBehaviors.Behavior.builder()
/*  38 */         .custom(CombatCommon::canEscape)
/*  39 */         .withinDistance(0.0D, 8.0D)
/*  40 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  41 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*     */       
/*  43 */       .addFirstBehavior(
/*  44 */         CECombatBehaviors.Behavior.builder()
/*  45 */         .custom(CombatCommon::canEscape)
/*  46 */         .withinDistance(0.0D, 48.0D)
/*  47 */         .guard(40)))
/*     */ 
/*     */     
/*  50 */     .newBehaviorRoot(
/*  51 */       CECombatBehaviors.BehaviorRoot.builder()
/*  52 */       .priority(2.0D)
/*  53 */       .weight(70.0D)
/*  54 */       .maxCooldown(0)
/*  55 */       .addFirstBehavior(
/*  56 */         CECombatBehaviors.Behavior.builder()
/*  57 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  58 */         .custom(CombatCommon::canPerformEating)
/*  59 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  60 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  63 */     .newBehaviorRoot(
/*  64 */       CECombatBehaviors.BehaviorRoot.builder()
/*  65 */       .priority(2.0D)
/*  66 */       .weight(100.0D)
/*  67 */       .maxCooldown(120)
/*  68 */       .addFirstBehavior(
/*  69 */         CECombatBehaviors.Behavior.builder()
/*  70 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  71 */         .custom(CombatCommon::canSwapToBow)
/*  72 */         .withinDistance(7.0D, 14.0D)
/*  73 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  74 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  76 */       .addFirstBehavior(
/*  77 */         CECombatBehaviors.Behavior.builder()
/*  78 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  79 */         .custom(CombatCommon::canSwapToBow)
/*  80 */         .withinDistance(7.0D, 14.0D)
/*  81 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  82 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/*  85 */     .newBehaviorRoot(
/*  86 */       CECombatBehaviors.BehaviorRoot.builder()
/*  87 */       .priority(2.0D)
/*  88 */       .weight(80.0D)
/*  89 */       .maxCooldown(120)
/*  90 */       .addFirstBehavior(
/*  91 */         CECombatBehaviors.Behavior.builder()
/*  92 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  93 */         .custom(CombatCommon::canThrowEnderPearl)
/*  94 */         .withinDistance(7.0D, 48.0D)
/*  95 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  96 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/*  99 */     .newBehaviorRoot(
/* 100 */       CECombatBehaviors.BehaviorRoot.builder()
/* 101 */       .priority(1.0D)
/* 102 */       .weight(40.0D)
/* 103 */       .maxCooldown(20)
/* 104 */       .addFirstBehavior(
/* 105 */         CECombatBehaviors.Behavior.builder()
/* 106 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 107 */         .withinDistance(0.0D, 3.0D)
/* 108 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 109 */         .addNextBehavior(
/* 110 */           CECombatBehaviors.Behavior.builder()
/* 111 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 112 */           .withinDistance(0.0D, 3.0D)
/* 113 */           .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 114 */           .addNextBehavior(
/* 115 */             CECombatBehaviors.Behavior.builder()
/* 116 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 117 */             .withinDistance(0.0D, 3.0D)
/* 118 */             .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F))))
/*     */ 
/*     */ 
/*     */       
/* 122 */       .addFirstBehavior(
/* 123 */         CECombatBehaviors.Behavior.builder()
/* 124 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 125 */         .withinDistance(0.0D, 3.0D)
/* 126 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 127 */         .addNextBehavior(
/* 128 */           CECombatBehaviors.Behavior.builder()
/* 129 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 130 */           .withinDistance(0.0D, 3.0D)
/* 131 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 132 */           .addNextBehavior(
/* 133 */             CECombatBehaviors.Behavior.builder()
/* 134 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */             .withinDistance(0.0D, 4.0D)
/* 136 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 137 */             .addNextBehavior(
/* 138 */               CECombatBehaviors.Behavior.builder()
/* 139 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 140 */               .withinDistance(0.0D, 4.0D)
/* 141 */               .animationBehavior(WOMAnimations.STAFF_SQUALL, 0.0F)
/* 142 */               .addNextBehavior(
/* 143 */                 CECombatBehaviors.Behavior.builder()
/* 144 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 145 */                 .withinDistance(0.0D, 5.0D)
/* 146 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 147 */                 .addNextBehavior(
/* 148 */                   CECombatBehaviors.Behavior.builder()
/* 149 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 150 */                   .withinDistance(0.0D, 5.0D)
/* 151 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       .addFirstBehavior(
/* 160 */         CECombatBehaviors.Behavior.builder()
/* 161 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 162 */         .withinDistance(0.0D, 3.0D)
/* 163 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 164 */         .addNextBehavior(
/* 165 */           CECombatBehaviors.Behavior.builder()
/* 166 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 167 */           .withinDistance(0.0D, 3.0D)
/* 168 */           .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 169 */           .addNextBehavior(
/* 170 */             CECombatBehaviors.Behavior.builder()
/* 171 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 172 */             .withinDistance(0.0D, 4.0D)
/* 173 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 174 */             .addNextBehavior(
/* 175 */               CECombatBehaviors.Behavior.builder()
/* 176 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 177 */               .withinDistance(0.0D, 4.0D)
/* 178 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 179 */               .addNextBehavior(
/* 180 */                 CECombatBehaviors.Behavior.builder()
/* 181 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 182 */                 .withinDistance(0.0D, 5.0D)
/* 183 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 184 */                 .addNextBehavior(
/* 185 */                   CECombatBehaviors.Behavior.builder()
/* 186 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 187 */                   .withinDistance(0.0D, 5.0D)
/* 188 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 196 */       .addFirstBehavior(
/* 197 */         CECombatBehaviors.Behavior.builder()
/* 198 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 199 */         .withinDistance(0.0D, 3.0D)
/* 200 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 201 */         .addNextBehavior(
/* 202 */           CECombatBehaviors.Behavior.builder()
/* 203 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 204 */           .withinDistance(0.0D, 3.0D)
/* 205 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 206 */           .addNextBehavior(
/* 207 */             CECombatBehaviors.Behavior.builder()
/* 208 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 209 */             .withinDistance(0.0D, 4.0D)
/* 210 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 211 */             .addNextBehavior(
/* 212 */               CECombatBehaviors.Behavior.builder()
/* 213 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 214 */               .withinDistance(0.0D, 4.0D)
/* 215 */               .animationBehavior(WOMAnimations.STAFF_CHARYBDIS, 0.0F)
/* 216 */               .addNextBehavior(
/* 217 */                 CECombatBehaviors.Behavior.builder()
/* 218 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 219 */                 .withinDistance(0.0D, 5.0D)
/* 220 */                 .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 221 */                 .addNextBehavior(
/* 222 */                   CECombatBehaviors.Behavior.builder()
/* 223 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 224 */                   .withinDistance(0.0D, 5.0D)
/* 225 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 233 */       .addFirstBehavior(
/* 234 */         CECombatBehaviors.Behavior.builder()
/* 235 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 236 */         .withinDistance(0.0D, 3.0D)
/* 237 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 238 */         .addNextBehavior(
/* 239 */           CECombatBehaviors.Behavior.builder()
/* 240 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 241 */           .withinDistance(0.0D, 3.0D)
/* 242 */           .animationBehavior(WOMAnimations.STAFF_SQUALL, 0.0F)
/* 243 */           .addNextBehavior(
/* 244 */             CECombatBehaviors.Behavior.builder()
/* 245 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 246 */             .withinDistance(0.0D, 4.0D)
/* 247 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 248 */             .addNextBehavior(
/* 249 */               CECombatBehaviors.Behavior.builder()
/* 250 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 251 */               .withinDistance(0.0D, 4.0D)
/* 252 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 253 */               .addNextBehavior(
/* 254 */                 CECombatBehaviors.Behavior.builder()
/* 255 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 256 */                 .withinDistance(0.0D, 5.0D)
/* 257 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 258 */                 .addNextBehavior(
/* 259 */                   CECombatBehaviors.Behavior.builder()
/* 260 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 261 */                   .withinDistance(0.0D, 5.0D)
/* 262 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 270 */       .addFirstBehavior(
/* 271 */         CECombatBehaviors.Behavior.builder()
/* 272 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 273 */         .withinDistance(0.0D, 3.0D)
/* 274 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 275 */         .addNextBehavior(
/* 276 */           CECombatBehaviors.Behavior.builder()
/* 277 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 278 */           .withinDistance(0.0D, 3.0D)
/* 279 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 280 */           .addNextBehavior(
/* 281 */             CECombatBehaviors.Behavior.builder()
/* 282 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 283 */             .withinDistance(0.0D, 4.0D)
/* 284 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 285 */             .addNextBehavior(
/* 286 */               CECombatBehaviors.Behavior.builder()
/* 287 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 288 */               .withinDistance(0.0D, 4.0D)
/* 289 */               .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 290 */               .addNextBehavior(
/* 291 */                 CECombatBehaviors.Behavior.builder()
/* 292 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 293 */                 .withinDistance(0.0D, 5.0D)
/* 294 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 295 */                 .addNextBehavior(
/* 296 */                   CECombatBehaviors.Behavior.builder()
/* 297 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 298 */                   .withinDistance(0.0D, 5.0D)
/* 299 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 309 */       .addFirstBehavior(
/* 310 */         CECombatBehaviors.Behavior.builder()
/* 311 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 312 */         .withinDistance(0.0D, 3.0D)
/* 313 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 314 */         .addNextBehavior(
/* 315 */           CECombatBehaviors.Behavior.builder()
/* 316 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 317 */           .withinDistance(0.0D, 3.0D)
/* 318 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 319 */           .addNextBehavior(
/* 320 */             CECombatBehaviors.Behavior.builder()
/* 321 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 322 */             .withinDistance(0.0D, 4.0D)
/* 323 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 324 */             .addNextBehavior(
/* 325 */               CECombatBehaviors.Behavior.builder()
/* 326 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 327 */               .withinDistance(0.0D, 4.0D)
/* 328 */               .animationBehavior(WOMAnimations.STAFF_CHARYBDIS, 0.0F)
/* 329 */               .addNextBehavior(
/* 330 */                 CECombatBehaviors.Behavior.builder()
/* 331 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 332 */                 .withinDistance(0.0D, 5.0D)
/* 333 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 334 */                 .addNextBehavior(
/* 335 */                   CECombatBehaviors.Behavior.builder()
/* 336 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 337 */                   .withinDistance(0.0D, 5.0D)
/* 338 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 346 */       .addFirstBehavior(
/* 347 */         CECombatBehaviors.Behavior.builder()
/* 348 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 349 */         .withinDistance(0.0D, 3.0D)
/* 350 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 351 */         .addNextBehavior(
/* 352 */           CECombatBehaviors.Behavior.builder()
/* 353 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 354 */           .withinDistance(0.0D, 3.0D)
/* 355 */           .animationBehavior(WOMAnimations.STAFF_SQUALL, 0.0F)
/* 356 */           .addNextBehavior(
/* 357 */             CECombatBehaviors.Behavior.builder()
/* 358 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 359 */             .withinDistance(0.0D, 4.0D)
/* 360 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 361 */             .addNextBehavior(
/* 362 */               CECombatBehaviors.Behavior.builder()
/* 363 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 364 */               .withinDistance(0.0D, 4.0D)
/* 365 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 366 */               .addNextBehavior(
/* 367 */                 CECombatBehaviors.Behavior.builder()
/* 368 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 369 */                 .withinDistance(0.0D, 5.0D)
/* 370 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 371 */                 .addNextBehavior(
/* 372 */                   CECombatBehaviors.Behavior.builder()
/* 373 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 374 */                   .withinDistance(0.0D, 5.0D)
/* 375 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 383 */       .addFirstBehavior(
/* 384 */         CECombatBehaviors.Behavior.builder()
/* 385 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 386 */         .withinDistance(0.0D, 3.0D)
/* 387 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 388 */         .addNextBehavior(
/* 389 */           CECombatBehaviors.Behavior.builder()
/* 390 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 391 */           .withinDistance(0.0D, 3.0D)
/* 392 */           .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 393 */           .addNextBehavior(
/* 394 */             CECombatBehaviors.Behavior.builder()
/* 395 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 396 */             .withinDistance(0.0D, 4.0D)
/* 397 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 398 */             .addNextBehavior(
/* 399 */               CECombatBehaviors.Behavior.builder()
/* 400 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 401 */               .withinDistance(0.0D, 4.0D)
/* 402 */               .animationBehavior(WOMAnimations.STAFF_SQUALL, 0.0F)
/* 403 */               .addNextBehavior(
/* 404 */                 CECombatBehaviors.Behavior.builder()
/* 405 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 406 */                 .withinDistance(0.0D, 5.0D)
/* 407 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 408 */                 .addNextBehavior(
/* 409 */                   CECombatBehaviors.Behavior.builder()
/* 410 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 411 */                   .withinDistance(0.0D, 5.0D)
/* 412 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 420 */       .addFirstBehavior(
/* 421 */         CECombatBehaviors.Behavior.builder()
/* 422 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 423 */         .withinDistance(0.0D, 3.0D)
/* 424 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 425 */         .addNextBehavior(
/* 426 */           CECombatBehaviors.Behavior.builder()
/* 427 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 428 */           .withinDistance(0.0D, 3.0D)
/* 429 */           .animationBehavior(WOMAnimations.STAFF_CHARYBDIS, 0.0F)
/* 430 */           .addNextBehavior(
/* 431 */             CECombatBehaviors.Behavior.builder()
/* 432 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 433 */             .withinDistance(0.0D, 4.0D)
/* 434 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 435 */             .addNextBehavior(
/* 436 */               CECombatBehaviors.Behavior.builder()
/* 437 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 438 */               .withinDistance(0.0D, 4.0D)
/* 439 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 440 */               .addNextBehavior(
/* 441 */                 CECombatBehaviors.Behavior.builder()
/* 442 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 443 */                 .withinDistance(0.0D, 5.0D)
/* 444 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 445 */                 .addNextBehavior(
/* 446 */                   CECombatBehaviors.Behavior.builder()
/* 447 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 448 */                   .withinDistance(0.0D, 5.0D)
/* 449 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 459 */       .addFirstBehavior(
/* 460 */         CECombatBehaviors.Behavior.builder()
/* 461 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 462 */         .withinDistance(0.0D, 3.0D)
/* 463 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 464 */         .addNextBehavior(
/* 465 */           CECombatBehaviors.Behavior.builder()
/* 466 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 467 */           .withinDistance(0.0D, 3.0D)
/* 468 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 469 */           .addNextBehavior(
/* 470 */             CECombatBehaviors.Behavior.builder()
/* 471 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 472 */             .withinDistance(0.0D, 4.0D)
/* 473 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 474 */             .addNextBehavior(
/* 475 */               CECombatBehaviors.Behavior.builder()
/* 476 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 477 */               .withinDistance(0.0D, 4.0D)
/* 478 */               .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 479 */               .addNextBehavior(
/* 480 */                 CECombatBehaviors.Behavior.builder()
/* 481 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 482 */                 .withinDistance(0.0D, 5.0D)
/* 483 */                 .animationBehavior(WOMAnimations.STAFF_SQUALL, 0.0F)
/* 484 */                 .addNextBehavior(
/* 485 */                   CECombatBehaviors.Behavior.builder()
/* 486 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 487 */                   .withinDistance(0.0D, 5.0D)
/* 488 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 489 */                   .addNextBehavior(
/* 490 */                     CECombatBehaviors.Behavior.builder()
/* 491 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 492 */                     .withinDistance(0.0D, 5.0D)
/* 493 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 502 */       .addFirstBehavior(
/* 503 */         CECombatBehaviors.Behavior.builder()
/* 504 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 505 */         .withinDistance(0.0D, 3.0D)
/* 506 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 507 */         .addNextBehavior(
/* 508 */           CECombatBehaviors.Behavior.builder()
/* 509 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 510 */           .withinDistance(0.0D, 3.0D)
/* 511 */           .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 512 */           .addNextBehavior(
/* 513 */             CECombatBehaviors.Behavior.builder()
/* 514 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 515 */             .withinDistance(0.0D, 4.0D)
/* 516 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 517 */             .addNextBehavior(
/* 518 */               CECombatBehaviors.Behavior.builder()
/* 519 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 520 */               .withinDistance(0.0D, 4.0D)
/* 521 */               .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 522 */               .addNextBehavior(
/* 523 */                 CECombatBehaviors.Behavior.builder()
/* 524 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 525 */                 .withinDistance(0.0D, 5.0D)
/* 526 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 527 */                 .addNextBehavior(
/* 528 */                   CECombatBehaviors.Behavior.builder()
/* 529 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 530 */                   .withinDistance(0.0D, 5.0D)
/* 531 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 532 */                   .addNextBehavior(
/* 533 */                     CECombatBehaviors.Behavior.builder()
/* 534 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 535 */                     .withinDistance(0.0D, 5.0D)
/* 536 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 545 */       .addFirstBehavior(
/* 546 */         CECombatBehaviors.Behavior.builder()
/* 547 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 548 */         .withinDistance(0.0D, 3.0D)
/* 549 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 550 */         .addNextBehavior(
/* 551 */           CECombatBehaviors.Behavior.builder()
/* 552 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 553 */           .withinDistance(0.0D, 3.0D)
/* 554 */           .animationBehavior(WOMAnimations.STAFF_CHARYBDIS, 0.0F)
/* 555 */           .addNextBehavior(
/* 556 */             CECombatBehaviors.Behavior.builder()
/* 557 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 558 */             .withinDistance(0.0D, 4.0D)
/* 559 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 560 */             .addNextBehavior(
/* 561 */               CECombatBehaviors.Behavior.builder()
/* 562 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 563 */               .withinDistance(0.0D, 4.0D)
/* 564 */               .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 565 */               .addNextBehavior(
/* 566 */                 CECombatBehaviors.Behavior.builder()
/* 567 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 568 */                 .withinDistance(0.0D, 5.0D)
/* 569 */                 .animationBehavior(WOMAnimations.STAFF_SQUALL, 0.0F)
/* 570 */                 .addNextBehavior(
/* 571 */                   CECombatBehaviors.Behavior.builder()
/* 572 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 573 */                   .withinDistance(0.0D, 5.0D)
/* 574 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 575 */                   .addNextBehavior(
/* 576 */                     CECombatBehaviors.Behavior.builder()
/* 577 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 578 */                     .withinDistance(0.0D, 5.0D)
/* 579 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 588 */       .addFirstBehavior(
/* 589 */         CECombatBehaviors.Behavior.builder()
/* 590 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 591 */         .withinDistance(0.0D, 3.0D)
/* 592 */         .animationBehavior(WOMAnimations.STAFF_AUTO_1, 0.0F)
/* 593 */         .addNextBehavior(
/* 594 */           CECombatBehaviors.Behavior.builder()
/* 595 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 596 */           .withinDistance(0.0D, 3.0D)
/* 597 */           .animationBehavior(WOMAnimations.STAFF_SQUALL, 0.0F)
/* 598 */           .addNextBehavior(
/* 599 */             CECombatBehaviors.Behavior.builder()
/* 600 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 601 */             .withinDistance(0.0D, 4.0D)
/* 602 */             .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 603 */             .addNextBehavior(
/* 604 */               CECombatBehaviors.Behavior.builder()
/* 605 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 606 */               .withinDistance(0.0D, 4.0D)
/* 607 */               .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 608 */               .addNextBehavior(
/* 609 */                 CECombatBehaviors.Behavior.builder()
/* 610 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 611 */                 .withinDistance(0.0D, 5.0D)
/* 612 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 613 */                 .addNextBehavior(
/* 614 */                   CECombatBehaviors.Behavior.builder()
/* 615 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 616 */                   .withinDistance(0.0D, 5.0D)
/* 617 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 618 */                   .addNextBehavior(
/* 619 */                     CECombatBehaviors.Behavior.builder()
/* 620 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 621 */                     .withinDistance(0.0D, 5.0D)
/* 622 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 631 */     .newBehaviorRoot(
/* 632 */       CECombatBehaviors.BehaviorRoot.builder()
/* 633 */       .priority(1.0D)
/* 634 */       .weight(20.0D)
/* 635 */       .maxCooldown(80)
/* 636 */       .addFirstBehavior(
/* 637 */         CECombatBehaviors.Behavior.builder()
/* 638 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 639 */         .withinDistance(0.0D, 3.0D)
/* 640 */         .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 641 */         .addNextBehavior(
/* 642 */           CECombatBehaviors.Behavior.builder()
/* 643 */           .withinDistance(0.0D, 3.0D)
/* 644 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 645 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 646 */           .addNextBehavior(
/* 647 */             CECombatBehaviors.Behavior.builder()
/* 648 */             .withinDistance(0.0D, 3.0D)
/* 649 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 650 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 655 */     .newBehaviorRoot(
/* 656 */       CECombatBehaviors.BehaviorRoot.builder()
/* 657 */       .priority(1.0D)
/* 658 */       .weight(10.0D)
/* 659 */       .maxCooldown(80)
/* 660 */       .addFirstBehavior(
/* 661 */         CECombatBehaviors.Behavior.builder()
/* 662 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 663 */         .withinDistance(0.0D, 3.0D)
/* 664 */         .animationBehavior(WOMAnimations.STAFF_SQUALL, 0.0F))
/*     */       
/* 666 */       .addFirstBehavior(
/* 667 */         CECombatBehaviors.Behavior.builder()
/* 668 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 669 */         .withinDistance(0.0D, 3.0D)
/* 670 */         .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F))
/*     */       
/* 672 */       .addFirstBehavior(
/* 673 */         CECombatBehaviors.Behavior.builder()
/* 674 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 675 */         .withinDistance(0.0D, 3.0D)
/* 676 */         .animationBehavior(WOMAnimations.STAFF_CHARYBDIS, 0.0F)))
/*     */ 
/*     */     
/* 679 */     .newBehaviorRoot(
/* 680 */       CECombatBehaviors.BehaviorRoot.builder()
/* 681 */       .priority(1.0D)
/* 682 */       .weight(10.0D)
/* 683 */       .maxCooldown(40)
/* 684 */       .addFirstBehavior(
/* 685 */         CECombatBehaviors.Behavior.builder()
/* 686 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 687 */         .withinDistance(0.0D, 3.0D)
/* 688 */         .custom(CombatCommon::canThrowEnderPearl)
/* 689 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 690 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 691 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 694 */     .newBehaviorRoot(
/* 695 */       CECombatBehaviors.BehaviorRoot.builder()
/* 696 */       .priority(1.0D)
/* 697 */       .weight(2.0D)
/* 698 */       .maxCooldown(100)
/* 699 */       .addFirstBehavior(
/* 700 */         CECombatBehaviors.Behavior.builder()
/* 701 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 702 */         .withinDistance(0.0D, 3.0D)
/* 703 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 705 */       .addFirstBehavior(
/* 706 */         CECombatBehaviors.Behavior.builder()
/* 707 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 708 */         .withinDistance(0.0D, 3.0D)
/* 709 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 711 */       .addFirstBehavior(
/* 712 */         CECombatBehaviors.Behavior.builder()
/* 713 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 714 */         .withinDistance(0.0D, 3.0D)
/* 715 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 717 */       .addFirstBehavior(
/* 718 */         CECombatBehaviors.Behavior.builder()
/* 719 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 720 */         .withinDistance(0.0D, 3.0D)
/* 721 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 723 */       .addFirstBehavior(
/* 724 */         CECombatBehaviors.Behavior.builder()
/* 725 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 726 */         .withinDistance(0.0D, 3.0D)
/* 727 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 729 */       .addFirstBehavior(
/* 730 */         CECombatBehaviors.Behavior.builder()
/* 731 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 732 */         .withinDistance(0.0D, 3.0D)
/* 733 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 735 */       .addFirstBehavior(
/* 736 */         CECombatBehaviors.Behavior.builder()
/* 737 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 738 */         .withinDistance(0.0D, 3.0D)
/* 739 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 742 */     .newBehaviorRoot(
/* 743 */       CECombatBehaviors.BehaviorRoot.builder()
/* 744 */       .priority(1.0D)
/* 745 */       .weight(15.0D)
/* 746 */       .addFirstBehavior(
/* 747 */         CECombatBehaviors.Behavior.builder()
/* 748 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 749 */         .withinDistance(0.5D, 3.0D)
/* 750 */         .custom(CombatCommon::canPerformGuarding)
/* 751 */         .guard(40)))
/*     */ 
/*     */     
/* 754 */     .newBehaviorRoot(
/* 755 */       CECombatBehaviors.BehaviorRoot.builder()
/* 756 */       .priority(1.0D)
/* 757 */       .weight(10.0D)
/* 758 */       .addFirstBehavior(
/* 759 */         CECombatBehaviors.Behavior.builder()
/* 760 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 761 */         .withinDistance(0.0D, 3.0D)
/* 762 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 764 */       .addFirstBehavior(
/* 765 */         CECombatBehaviors.Behavior.builder()
/* 766 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 767 */         .withinDistance(0.0D, 3.0D)
/* 768 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*     */ 
/*     */     
/* 771 */     .newBehaviorRoot(
/* 772 */       CECombatBehaviors.BehaviorRoot.builder()
/* 773 */       .priority(1.0D)
/* 774 */       .weight(40.0D)
/* 775 */       .maxCooldown(160)
/* 776 */       .addFirstBehavior(
/* 777 */         CECombatBehaviors.Behavior.builder()
/* 778 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 779 */         .custom(CombatCommon::canJump)
/* 780 */         .withinDistance(5.0D, 14.0D)
/* 781 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 782 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcStaff.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */