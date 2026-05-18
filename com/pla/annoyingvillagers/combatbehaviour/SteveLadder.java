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
/*     */ public class SteveLadder
/*     */ {
/*  14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> LADDER = CECombatBehaviors.builder()
/*  15 */     .newBehaviorRoot(
/*  16 */       CECombatBehaviors.BehaviorRoot.builder()
/*  17 */       .priority(5.0D)
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
/*  30 */       .priority(4.0D)
/*  31 */       .weight(1000.0D)
/*  32 */       .maxCooldown(0)
/*  33 */       .addFirstBehavior(
/*  34 */         CECombatBehaviors.Behavior.builder()
/*  35 */         .custom(CombatCommon::canEscape)
/*  36 */         .withinDistance(0.0D, 8.0D)
/*  37 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  38 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*     */       
/*  40 */       .addFirstBehavior(
/*  41 */         CECombatBehaviors.Behavior.builder()
/*  42 */         .custom(CombatCommon::canEscape)
/*  43 */         .withinDistance(0.0D, 48.0D)
/*  44 */         .guard(40)))
/*     */ 
/*     */     
/*  47 */     .newBehaviorRoot(
/*  48 */       CECombatBehaviors.BehaviorRoot.builder()
/*  49 */       .priority(3.0D)
/*  50 */       .weight(100.0D)
/*  51 */       .maxCooldown(120)
/*  52 */       .addFirstBehavior(
/*  53 */         CECombatBehaviors.Behavior.builder()
/*  54 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  55 */         .custom(CombatCommon::canSwitchWeapon)
/*  56 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  57 */         .addExBehavior(CombatCommon::switchWeapon))
/*     */       
/*  59 */       .addFirstBehavior(
/*  60 */         CECombatBehaviors.Behavior.builder()
/*  61 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  62 */         .custom(CombatCommon::canSwitchWeapon)
/*  63 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  64 */         .addExBehavior(CombatCommon::switchWeapon)))
/*     */ 
/*     */     
/*  67 */     .newBehaviorRoot(
/*  68 */       CECombatBehaviors.BehaviorRoot.builder()
/*  69 */       .priority(2.0D)
/*  70 */       .weight(70.0D)
/*  71 */       .maxCooldown(0)
/*  72 */       .addFirstBehavior(
/*  73 */         CECombatBehaviors.Behavior.builder()
/*  74 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  75 */         .custom(CombatCommon::canPerformEating)
/*  76 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  77 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  80 */     .newBehaviorRoot(
/*  81 */       CECombatBehaviors.BehaviorRoot.builder()
/*  82 */       .priority(2.0D)
/*  83 */       .weight(100.0D)
/*  84 */       .maxCooldown(120)
/*  85 */       .addFirstBehavior(
/*  86 */         CECombatBehaviors.Behavior.builder()
/*  87 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  88 */         .custom(CombatCommon::canSwapToBow)
/*  89 */         .withinDistance(7.0D, 14.0D)
/*  90 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  91 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  93 */       .addFirstBehavior(
/*  94 */         CECombatBehaviors.Behavior.builder()
/*  95 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  96 */         .custom(CombatCommon::canSwapToBow)
/*  97 */         .withinDistance(7.0D, 14.0D)
/*  98 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  99 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/* 102 */     .newBehaviorRoot(
/* 103 */       CECombatBehaviors.BehaviorRoot.builder()
/* 104 */       .priority(2.0D)
/* 105 */       .weight(80.0D)
/* 106 */       .maxCooldown(120)
/* 107 */       .addFirstBehavior(
/* 108 */         CECombatBehaviors.Behavior.builder()
/* 109 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 110 */         .custom(CombatCommon::canThrowEnderPearl)
/* 111 */         .withinDistance(7.0D, 48.0D)
/* 112 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 113 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/* 116 */     .newBehaviorRoot(
/* 117 */       CECombatBehaviors.BehaviorRoot.builder()
/* 118 */       .priority(1.0D)
/* 119 */       .weight(40.0D)
/* 120 */       .maxCooldown(20)
/* 121 */       .addFirstBehavior(
/* 122 */         CECombatBehaviors.Behavior.builder()
/* 123 */         .withinDistance(0.0D, 3.0D)
/* 124 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 125 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 126 */         .addNextBehavior(
/* 127 */           CECombatBehaviors.Behavior.builder()
/* 128 */           .withinDistance(0.0D, 3.0D)
/* 129 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 130 */           .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 131 */           .addNextBehavior(
/* 132 */             CECombatBehaviors.Behavior.builder()
/* 133 */             .withinDistance(0.0D, 3.0D)
/* 134 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 136 */             .addNextBehavior(
/* 137 */               CECombatBehaviors.Behavior.builder()
/* 138 */               .withinDistance(0.0D, 3.0D)
/* 139 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 140 */               .animationBehavior(Animations.TACHI_AUTO3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 145 */       .addFirstBehavior(
/* 146 */         CECombatBehaviors.Behavior.builder()
/* 147 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 148 */         .withinDistance(0.0D, 3.0D)
/* 149 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 150 */         .addNextBehavior(
/* 151 */           CECombatBehaviors.Behavior.builder()
/* 152 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 153 */           .withinDistance(0.0D, 3.0D)
/* 154 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 155 */           .addNextBehavior(
/* 156 */             CECombatBehaviors.Behavior.builder()
/* 157 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 158 */             .withinDistance(0.0D, 4.0D)
/* 159 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 160 */             .addNextBehavior(
/* 161 */               CECombatBehaviors.Behavior.builder()
/* 162 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 163 */               .withinDistance(0.0D, 4.0D)
/* 164 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 165 */               .addNextBehavior(
/* 166 */                 CECombatBehaviors.Behavior.builder()
/* 167 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 168 */                 .withinDistance(0.0D, 5.0D)
/* 169 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       .addFirstBehavior(
/* 177 */         CECombatBehaviors.Behavior.builder()
/* 178 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 179 */         .withinDistance(0.0D, 3.0D)
/* 180 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 181 */         .addNextBehavior(
/* 182 */           CECombatBehaviors.Behavior.builder()
/* 183 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 184 */           .withinDistance(0.0D, 3.0D)
/* 185 */           .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 186 */           .addNextBehavior(
/* 187 */             CECombatBehaviors.Behavior.builder()
/* 188 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 189 */             .withinDistance(0.0D, 4.0D)
/* 190 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 191 */             .addNextBehavior(
/* 192 */               CECombatBehaviors.Behavior.builder()
/* 193 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 194 */               .withinDistance(0.0D, 4.0D)
/* 195 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 196 */               .addNextBehavior(
/* 197 */                 CECombatBehaviors.Behavior.builder()
/* 198 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 199 */                 .withinDistance(0.0D, 5.0D)
/* 200 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       .addFirstBehavior(
/* 208 */         CECombatBehaviors.Behavior.builder()
/* 209 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 210 */         .withinDistance(0.0D, 3.0D)
/* 211 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 212 */         .addNextBehavior(
/* 213 */           CECombatBehaviors.Behavior.builder()
/* 214 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 215 */           .withinDistance(0.0D, 3.0D)
/* 216 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 217 */           .addNextBehavior(
/* 218 */             CECombatBehaviors.Behavior.builder()
/* 219 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 220 */             .withinDistance(0.0D, 4.0D)
/* 221 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 222 */             .addNextBehavior(
/* 223 */               CECombatBehaviors.Behavior.builder()
/* 224 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 225 */               .withinDistance(0.0D, 4.0D)
/* 226 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 227 */               .addNextBehavior(
/* 228 */                 CECombatBehaviors.Behavior.builder()
/* 229 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 230 */                 .withinDistance(0.0D, 5.0D)
/* 231 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 238 */       .addFirstBehavior(
/* 239 */         CECombatBehaviors.Behavior.builder()
/* 240 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 241 */         .withinDistance(0.0D, 3.0D)
/* 242 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 243 */         .addNextBehavior(
/* 244 */           CECombatBehaviors.Behavior.builder()
/* 245 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 246 */           .withinDistance(0.0D, 3.0D)
/* 247 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 248 */           .addNextBehavior(
/* 249 */             CECombatBehaviors.Behavior.builder()
/* 250 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 251 */             .withinDistance(0.0D, 4.0D)
/* 252 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 253 */             .addNextBehavior(
/* 254 */               CECombatBehaviors.Behavior.builder()
/* 255 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 256 */               .withinDistance(0.0D, 4.0D)
/* 257 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 258 */               .addNextBehavior(
/* 259 */                 CECombatBehaviors.Behavior.builder()
/* 260 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 261 */                 .withinDistance(0.0D, 5.0D)
/* 262 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 269 */       .addFirstBehavior(
/* 270 */         CECombatBehaviors.Behavior.builder()
/* 271 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 272 */         .withinDistance(0.0D, 3.0D)
/* 273 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 274 */         .addNextBehavior(
/* 275 */           CECombatBehaviors.Behavior.builder()
/* 276 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 277 */           .withinDistance(0.0D, 3.0D)
/* 278 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 279 */           .addNextBehavior(
/* 280 */             CECombatBehaviors.Behavior.builder()
/* 281 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 282 */             .withinDistance(0.0D, 4.0D)
/* 283 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 284 */             .addNextBehavior(
/* 285 */               CECombatBehaviors.Behavior.builder()
/* 286 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 287 */               .withinDistance(0.0D, 4.0D)
/* 288 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 289 */               .addNextBehavior(
/* 290 */                 CECombatBehaviors.Behavior.builder()
/* 291 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 292 */                 .withinDistance(0.0D, 5.0D)
/* 293 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 294 */                 .addNextBehavior(
/* 295 */                   CECombatBehaviors.Behavior.builder()
/* 296 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 297 */                   .withinDistance(0.0D, 5.0D)
/* 298 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 306 */       .addFirstBehavior(
/* 307 */         CECombatBehaviors.Behavior.builder()
/* 308 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 309 */         .withinDistance(0.0D, 3.0D)
/* 310 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 311 */         .addNextBehavior(
/* 312 */           CECombatBehaviors.Behavior.builder()
/* 313 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 314 */           .withinDistance(0.0D, 3.0D)
/* 315 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 316 */           .addNextBehavior(
/* 317 */             CECombatBehaviors.Behavior.builder()
/* 318 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 319 */             .withinDistance(0.0D, 4.0D)
/* 320 */             .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 321 */             .addNextBehavior(
/* 322 */               CECombatBehaviors.Behavior.builder()
/* 323 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 324 */               .withinDistance(0.0D, 4.0D)
/* 325 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 326 */               .addNextBehavior(
/* 327 */                 CECombatBehaviors.Behavior.builder()
/* 328 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 329 */                 .withinDistance(0.0D, 5.0D)
/* 330 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/* 341 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 342 */         .addNextBehavior(
/* 343 */           CECombatBehaviors.Behavior.builder()
/* 344 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 345 */           .withinDistance(0.0D, 3.0D)
/* 346 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 347 */           .addNextBehavior(
/* 348 */             CECombatBehaviors.Behavior.builder()
/* 349 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 350 */             .withinDistance(0.0D, 4.0D)
/* 351 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 352 */             .addNextBehavior(
/* 353 */               CECombatBehaviors.Behavior.builder()
/* 354 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 355 */               .withinDistance(0.0D, 4.0D)
/* 356 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 357 */               .addNextBehavior(
/* 358 */                 CECombatBehaviors.Behavior.builder()
/* 359 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 360 */                 .withinDistance(0.0D, 5.0D)
/* 361 */                 .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
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
/* 378 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 379 */         .addNextBehavior(
/* 380 */           CECombatBehaviors.Behavior.builder()
/* 381 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 382 */           .withinDistance(0.0D, 3.0D)
/* 383 */           .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 384 */           .addNextBehavior(
/* 385 */             CECombatBehaviors.Behavior.builder()
/* 386 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 387 */             .withinDistance(0.0D, 4.0D)
/* 388 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 389 */             .addNextBehavior(
/* 390 */               CECombatBehaviors.Behavior.builder()
/* 391 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 392 */               .withinDistance(0.0D, 4.0D)
/* 393 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 394 */               .addNextBehavior(
/* 395 */                 CECombatBehaviors.Behavior.builder()
/* 396 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 397 */                 .withinDistance(0.0D, 5.0D)
/* 398 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 399 */                 .addNextBehavior(
/* 400 */                   CECombatBehaviors.Behavior.builder()
/* 401 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 402 */                   .withinDistance(0.0D, 5.0D)
/* 403 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 411 */       .addFirstBehavior(
/* 412 */         CECombatBehaviors.Behavior.builder()
/* 413 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 414 */         .withinDistance(0.0D, 3.0D)
/* 415 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 416 */         .addNextBehavior(
/* 417 */           CECombatBehaviors.Behavior.builder()
/* 418 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 419 */           .withinDistance(0.0D, 3.0D)
/* 420 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 421 */           .addNextBehavior(
/* 422 */             CECombatBehaviors.Behavior.builder()
/* 423 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 424 */             .withinDistance(0.0D, 4.0D)
/* 425 */             .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 426 */             .addNextBehavior(
/* 427 */               CECombatBehaviors.Behavior.builder()
/* 428 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 429 */               .withinDistance(0.0D, 4.0D)
/* 430 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 431 */               .addNextBehavior(
/* 432 */                 CECombatBehaviors.Behavior.builder()
/* 433 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 434 */                 .withinDistance(0.0D, 5.0D)
/* 435 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/* 446 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 447 */         .addNextBehavior(
/* 448 */           CECombatBehaviors.Behavior.builder()
/* 449 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 450 */           .withinDistance(0.0D, 3.0D)
/* 451 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 452 */           .addNextBehavior(
/* 453 */             CECombatBehaviors.Behavior.builder()
/* 454 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 455 */             .withinDistance(0.0D, 4.0D)
/* 456 */             .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 457 */             .addNextBehavior(
/* 458 */               CECombatBehaviors.Behavior.builder()
/* 459 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 460 */               .withinDistance(0.0D, 4.0D)
/* 461 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 462 */               .addNextBehavior(
/* 463 */                 CECombatBehaviors.Behavior.builder()
/* 464 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 465 */                 .withinDistance(0.0D, 5.0D)
/* 466 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 473 */       .addFirstBehavior(
/* 474 */         CECombatBehaviors.Behavior.builder()
/* 475 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 476 */         .withinDistance(0.0D, 3.0D)
/* 477 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 478 */         .addNextBehavior(
/* 479 */           CECombatBehaviors.Behavior.builder()
/* 480 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 481 */           .withinDistance(0.0D, 3.0D)
/* 482 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 483 */           .addNextBehavior(
/* 484 */             CECombatBehaviors.Behavior.builder()
/* 485 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 486 */             .withinDistance(0.0D, 4.0D)
/* 487 */             .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 488 */             .addNextBehavior(
/* 489 */               CECombatBehaviors.Behavior.builder()
/* 490 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 491 */               .withinDistance(0.0D, 4.0D)
/* 492 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 493 */               .addNextBehavior(
/* 494 */                 CECombatBehaviors.Behavior.builder()
/* 495 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 496 */                 .withinDistance(0.0D, 5.0D)
/* 497 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 504 */       .addFirstBehavior(
/* 505 */         CECombatBehaviors.Behavior.builder()
/* 506 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 507 */         .withinDistance(0.0D, 3.0D)
/* 508 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 509 */         .addNextBehavior(
/* 510 */           CECombatBehaviors.Behavior.builder()
/* 511 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 512 */           .withinDistance(0.0D, 3.0D)
/* 513 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 514 */           .addNextBehavior(
/* 515 */             CECombatBehaviors.Behavior.builder()
/* 516 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 517 */             .withinDistance(0.0D, 4.0D)
/* 518 */             .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 519 */             .addNextBehavior(
/* 520 */               CECombatBehaviors.Behavior.builder()
/* 521 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 522 */               .withinDistance(0.0D, 4.0D)
/* 523 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 524 */               .addNextBehavior(
/* 525 */                 CECombatBehaviors.Behavior.builder()
/* 526 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 527 */                 .withinDistance(0.0D, 5.0D)
/* 528 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 535 */       .addFirstBehavior(
/* 536 */         CECombatBehaviors.Behavior.builder()
/* 537 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 538 */         .withinDistance(0.0D, 3.0D)
/* 539 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 540 */         .addNextBehavior(
/* 541 */           CECombatBehaviors.Behavior.builder()
/* 542 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 543 */           .withinDistance(0.0D, 3.0D)
/* 544 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 545 */           .addNextBehavior(
/* 546 */             CECombatBehaviors.Behavior.builder()
/* 547 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 548 */             .withinDistance(0.0D, 4.0D)
/* 549 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 550 */             .addNextBehavior(
/* 551 */               CECombatBehaviors.Behavior.builder()
/* 552 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 553 */               .withinDistance(0.0D, 4.0D)
/* 554 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 555 */               .addNextBehavior(
/* 556 */                 CECombatBehaviors.Behavior.builder()
/* 557 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 558 */                 .withinDistance(0.0D, 5.0D)
/* 559 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 560 */                 .addNextBehavior(
/* 561 */                   CECombatBehaviors.Behavior.builder()
/* 562 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 563 */                   .withinDistance(0.0D, 5.0D)
/* 564 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 565 */                   .addNextBehavior(
/* 566 */                     CECombatBehaviors.Behavior.builder()
/* 567 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 568 */                     .withinDistance(0.0D, 5.0D)
/* 569 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 578 */       .addFirstBehavior(
/* 579 */         CECombatBehaviors.Behavior.builder()
/* 580 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 581 */         .withinDistance(0.0D, 3.0D)
/* 582 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 583 */         .addNextBehavior(
/* 584 */           CECombatBehaviors.Behavior.builder()
/* 585 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 586 */           .withinDistance(0.0D, 3.0D)
/* 587 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 588 */           .addNextBehavior(
/* 589 */             CECombatBehaviors.Behavior.builder()
/* 590 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 591 */             .withinDistance(0.0D, 4.0D)
/* 592 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 593 */             .addNextBehavior(
/* 594 */               CECombatBehaviors.Behavior.builder()
/* 595 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 596 */               .withinDistance(0.0D, 4.0D)
/* 597 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 598 */               .addNextBehavior(
/* 599 */                 CECombatBehaviors.Behavior.builder()
/* 600 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 601 */                 .withinDistance(0.0D, 5.0D)
/* 602 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 603 */                 .addNextBehavior(
/* 604 */                   CECombatBehaviors.Behavior.builder()
/* 605 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 606 */                   .withinDistance(0.0D, 5.0D)
/* 607 */                   .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 608 */                   .addNextBehavior(
/* 609 */                     CECombatBehaviors.Behavior.builder()
/* 610 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 611 */                     .withinDistance(0.0D, 5.0D)
/* 612 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 621 */       .addFirstBehavior(
/* 622 */         CECombatBehaviors.Behavior.builder()
/* 623 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 624 */         .withinDistance(0.0D, 3.0D)
/* 625 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 626 */         .addNextBehavior(
/* 627 */           CECombatBehaviors.Behavior.builder()
/* 628 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 629 */           .withinDistance(0.0D, 3.0D)
/* 630 */           .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 631 */           .addNextBehavior(
/* 632 */             CECombatBehaviors.Behavior.builder()
/* 633 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 634 */             .withinDistance(0.0D, 4.0D)
/* 635 */             .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 636 */             .addNextBehavior(
/* 637 */               CECombatBehaviors.Behavior.builder()
/* 638 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 639 */               .withinDistance(0.0D, 4.0D)
/* 640 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 641 */               .addNextBehavior(
/* 642 */                 CECombatBehaviors.Behavior.builder()
/* 643 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 644 */                 .withinDistance(0.0D, 5.0D)
/* 645 */                 .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 646 */                 .addNextBehavior(
/* 647 */                   CECombatBehaviors.Behavior.builder()
/* 648 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 649 */                   .withinDistance(0.0D, 5.0D)
/* 650 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 659 */     .newBehaviorRoot(
/* 660 */       CECombatBehaviors.BehaviorRoot.builder()
/* 661 */       .priority(1.0D)
/* 662 */       .weight(20.0D)
/* 663 */       .maxCooldown(100)
/* 664 */       .addFirstBehavior(
/* 665 */         CECombatBehaviors.Behavior.builder()
/* 666 */         .withinDistance(0.0D, 3.0D)
/* 667 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 668 */         .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)))
/*     */ 
/*     */     
/* 671 */     .newBehaviorRoot(
/* 672 */       CECombatBehaviors.BehaviorRoot.builder()
/* 673 */       .priority(1.0D)
/* 674 */       .weight(10.0D)
/* 675 */       .maxCooldown(100)
/* 676 */       .addFirstBehavior(
/* 677 */         CECombatBehaviors.Behavior.builder()
/* 678 */         .withinDistance(0.0D, 3.0D)
/* 679 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 680 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*     */       
/* 682 */       .addFirstBehavior(
/* 683 */         CECombatBehaviors.Behavior.builder()
/* 684 */         .withinDistance(0.0D, 3.0D)
/* 685 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 686 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*     */       
/* 688 */       .addFirstBehavior(
/* 689 */         CECombatBehaviors.Behavior.builder()
/* 690 */         .withinDistance(0.0D, 3.0D)
/* 691 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 692 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))
/*     */ 
/*     */     
/* 695 */     .newBehaviorRoot(
/* 696 */       CECombatBehaviors.BehaviorRoot.builder()
/* 697 */       .priority(1.0D)
/* 698 */       .weight(10.0D)
/* 699 */       .maxCooldown(40)
/* 700 */       .addFirstBehavior(
/* 701 */         CECombatBehaviors.Behavior.builder()
/* 702 */         .withinDistance(0.0D, 3.0D)
/* 703 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 704 */         .custom(CombatCommon::canThrowEnderPearl)
/* 705 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 706 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 707 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 710 */     .newBehaviorRoot(
/* 711 */       CECombatBehaviors.BehaviorRoot.builder()
/* 712 */       .priority(1.0D)
/* 713 */       .weight(2.0D)
/* 714 */       .maxCooldown(100)
/* 715 */       .addFirstBehavior(
/* 716 */         CECombatBehaviors.Behavior.builder()
/* 717 */         .withinDistance(0.0D, 3.0D)
/* 718 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 719 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 721 */       .addFirstBehavior(
/* 722 */         CECombatBehaviors.Behavior.builder()
/* 723 */         .withinDistance(0.0D, 3.0D)
/* 724 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 725 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 727 */       .addFirstBehavior(
/* 728 */         CECombatBehaviors.Behavior.builder()
/* 729 */         .withinDistance(0.0D, 3.0D)
/* 730 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 731 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 733 */       .addFirstBehavior(
/* 734 */         CECombatBehaviors.Behavior.builder()
/* 735 */         .withinDistance(0.0D, 3.0D)
/* 736 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 737 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 739 */       .addFirstBehavior(
/* 740 */         CECombatBehaviors.Behavior.builder()
/* 741 */         .withinDistance(0.0D, 3.0D)
/* 742 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 743 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 745 */       .addFirstBehavior(
/* 746 */         CECombatBehaviors.Behavior.builder()
/* 747 */         .withinDistance(0.0D, 3.0D)
/* 748 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 749 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 751 */       .addFirstBehavior(
/* 752 */         CECombatBehaviors.Behavior.builder()
/* 753 */         .withinDistance(0.0D, 3.0D)
/* 754 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 755 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 758 */     .newBehaviorRoot(
/* 759 */       CECombatBehaviors.BehaviorRoot.builder()
/* 760 */       .priority(1.0D)
/* 761 */       .weight(15.0D)
/* 762 */       .addFirstBehavior(
/* 763 */         CECombatBehaviors.Behavior.builder()
/* 764 */         .withinDistance(0.0D, 3.0D)
/* 765 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 766 */         .custom(CombatCommon::canPerformGuarding)
/* 767 */         .guard(40)))
/*     */ 
/*     */     
/* 770 */     .newBehaviorRoot(
/* 771 */       CECombatBehaviors.BehaviorRoot.builder()
/* 772 */       .priority(1.0D)
/* 773 */       .weight(10.0D)
/* 774 */       .addFirstBehavior(
/* 775 */         CECombatBehaviors.Behavior.builder()
/* 776 */         .withinDistance(0.0D, 3.0D)
/* 777 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 778 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 780 */       .addFirstBehavior(
/* 781 */         CECombatBehaviors.Behavior.builder()
/* 782 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 783 */         .withinDistance(0.0D, 3.0D)
/* 784 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))
/*     */ 
/*     */     
/* 787 */     .newBehaviorRoot(
/* 788 */       CECombatBehaviors.BehaviorRoot.builder()
/* 789 */       .priority(1.0D)
/* 790 */       .weight(40.0D)
/* 791 */       .maxCooldown(160)
/* 792 */       .addFirstBehavior(
/* 793 */         CECombatBehaviors.Behavior.builder()
/* 794 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 795 */         .custom(CombatCommon::canJump)
/* 796 */         .withinDistance(5.0D, 14.0D)
/* 797 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 798 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveLadder.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */