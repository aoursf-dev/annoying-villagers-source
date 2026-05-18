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
/*     */ 
/*     */ public class PlayerNpcLadder
/*     */ {
/*  15 */   public static CECombatBehaviors.Builder<MobPatch<?>> LADDER = CECombatBehaviors.builder()
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
/*  36 */         .custom(CombatCommon::canEscape)
/*  37 */         .withinDistance(0.0D, 8.0D)
/*  38 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  39 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*     */       
/*  41 */       .addFirstBehavior(
/*  42 */         CECombatBehaviors.Behavior.builder()
/*  43 */         .custom(CombatCommon::canEscape)
/*  44 */         .withinDistance(0.0D, 48.0D)
/*  45 */         .guard(40)))
/*     */ 
/*     */     
/*  48 */     .newBehaviorRoot(
/*  49 */       CECombatBehaviors.BehaviorRoot.builder()
/*  50 */       .priority(2.0D)
/*  51 */       .weight(70.0D)
/*  52 */       .maxCooldown(0)
/*  53 */       .addFirstBehavior(
/*  54 */         CECombatBehaviors.Behavior.builder()
/*  55 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  56 */         .custom(CombatCommon::canPerformEating)
/*  57 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  58 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  61 */     .newBehaviorRoot(
/*  62 */       CECombatBehaviors.BehaviorRoot.builder()
/*  63 */       .priority(2.0D)
/*  64 */       .weight(100.0D)
/*  65 */       .maxCooldown(120)
/*  66 */       .addFirstBehavior(
/*  67 */         CECombatBehaviors.Behavior.builder()
/*  68 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  69 */         .custom(CombatCommon::canSwapToBow)
/*  70 */         .withinDistance(7.0D, 14.0D)
/*  71 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  72 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  74 */       .addFirstBehavior(
/*  75 */         CECombatBehaviors.Behavior.builder()
/*  76 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  77 */         .custom(CombatCommon::canSwapToBow)
/*  78 */         .withinDistance(7.0D, 14.0D)
/*  79 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  80 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/*  83 */     .newBehaviorRoot(
/*  84 */       CECombatBehaviors.BehaviorRoot.builder()
/*  85 */       .priority(2.0D)
/*  86 */       .weight(80.0D)
/*  87 */       .maxCooldown(120)
/*  88 */       .addFirstBehavior(
/*  89 */         CECombatBehaviors.Behavior.builder()
/*  90 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  91 */         .custom(CombatCommon::canThrowEnderPearl)
/*  92 */         .withinDistance(7.0D, 48.0D)
/*  93 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  94 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/*  97 */     .newBehaviorRoot(
/*  98 */       CECombatBehaviors.BehaviorRoot.builder()
/*  99 */       .priority(1.0D)
/* 100 */       .weight(40.0D)
/* 101 */       .maxCooldown(20)
/* 102 */       .addFirstBehavior(
/* 103 */         CECombatBehaviors.Behavior.builder()
/* 104 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 105 */         .withinDistance(0.0D, 3.0D)
/* 106 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 107 */         .addNextBehavior(
/* 108 */           CECombatBehaviors.Behavior.builder()
/* 109 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 110 */           .withinDistance(0.0D, 3.0D)
/* 111 */           .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 112 */           .addNextBehavior(
/* 113 */             CECombatBehaviors.Behavior.builder()
/* 114 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 115 */             .withinDistance(0.0D, 3.0D)
/* 116 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 117 */             .addNextBehavior(
/* 118 */               CECombatBehaviors.Behavior.builder()
/* 119 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 120 */               .withinDistance(0.0D, 3.0D)
/* 121 */               .animationBehavior(Animations.TACHI_AUTO3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 126 */       .addFirstBehavior(
/* 127 */         CECombatBehaviors.Behavior.builder()
/* 128 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 129 */         .withinDistance(0.0D, 3.0D)
/* 130 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 131 */         .addNextBehavior(
/* 132 */           CECombatBehaviors.Behavior.builder()
/* 133 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 134 */           .withinDistance(0.0D, 3.0D)
/* 135 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 136 */           .addNextBehavior(
/* 137 */             CECombatBehaviors.Behavior.builder()
/* 138 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 139 */             .withinDistance(0.0D, 4.0D)
/* 140 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 141 */             .addNextBehavior(
/* 142 */               CECombatBehaviors.Behavior.builder()
/* 143 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 144 */               .withinDistance(0.0D, 4.0D)
/* 145 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 146 */               .addNextBehavior(
/* 147 */                 CECombatBehaviors.Behavior.builder()
/* 148 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 149 */                 .withinDistance(0.0D, 5.0D)
/* 150 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       .addFirstBehavior(
/* 158 */         CECombatBehaviors.Behavior.builder()
/* 159 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 160 */         .withinDistance(0.0D, 3.0D)
/* 161 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 162 */         .addNextBehavior(
/* 163 */           CECombatBehaviors.Behavior.builder()
/* 164 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 165 */           .withinDistance(0.0D, 3.0D)
/* 166 */           .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 167 */           .addNextBehavior(
/* 168 */             CECombatBehaviors.Behavior.builder()
/* 169 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 170 */             .withinDistance(0.0D, 4.0D)
/* 171 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 172 */             .addNextBehavior(
/* 173 */               CECombatBehaviors.Behavior.builder()
/* 174 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 175 */               .withinDistance(0.0D, 4.0D)
/* 176 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 177 */               .addNextBehavior(
/* 178 */                 CECombatBehaviors.Behavior.builder()
/* 179 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 180 */                 .withinDistance(0.0D, 5.0D)
/* 181 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 188 */       .addFirstBehavior(
/* 189 */         CECombatBehaviors.Behavior.builder()
/* 190 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 191 */         .withinDistance(0.0D, 3.0D)
/* 192 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 193 */         .addNextBehavior(
/* 194 */           CECombatBehaviors.Behavior.builder()
/* 195 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 196 */           .withinDistance(0.0D, 3.0D)
/* 197 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 198 */           .addNextBehavior(
/* 199 */             CECombatBehaviors.Behavior.builder()
/* 200 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 201 */             .withinDistance(0.0D, 4.0D)
/* 202 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 203 */             .addNextBehavior(
/* 204 */               CECombatBehaviors.Behavior.builder()
/* 205 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 206 */               .withinDistance(0.0D, 4.0D)
/* 207 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 208 */               .addNextBehavior(
/* 209 */                 CECombatBehaviors.Behavior.builder()
/* 210 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 211 */                 .withinDistance(0.0D, 5.0D)
/* 212 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 219 */       .addFirstBehavior(
/* 220 */         CECombatBehaviors.Behavior.builder()
/* 221 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 222 */         .withinDistance(0.0D, 3.0D)
/* 223 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 224 */         .addNextBehavior(
/* 225 */           CECombatBehaviors.Behavior.builder()
/* 226 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 227 */           .withinDistance(0.0D, 3.0D)
/* 228 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 229 */           .addNextBehavior(
/* 230 */             CECombatBehaviors.Behavior.builder()
/* 231 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 232 */             .withinDistance(0.0D, 4.0D)
/* 233 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 234 */             .addNextBehavior(
/* 235 */               CECombatBehaviors.Behavior.builder()
/* 236 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 237 */               .withinDistance(0.0D, 4.0D)
/* 238 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 239 */               .addNextBehavior(
/* 240 */                 CECombatBehaviors.Behavior.builder()
/* 241 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 242 */                 .withinDistance(0.0D, 5.0D)
/* 243 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 250 */       .addFirstBehavior(
/* 251 */         CECombatBehaviors.Behavior.builder()
/* 252 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 253 */         .withinDistance(0.0D, 3.0D)
/* 254 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 255 */         .addNextBehavior(
/* 256 */           CECombatBehaviors.Behavior.builder()
/* 257 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 258 */           .withinDistance(0.0D, 3.0D)
/* 259 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 260 */           .addNextBehavior(
/* 261 */             CECombatBehaviors.Behavior.builder()
/* 262 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 263 */             .withinDistance(0.0D, 4.0D)
/* 264 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 265 */             .addNextBehavior(
/* 266 */               CECombatBehaviors.Behavior.builder()
/* 267 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 268 */               .withinDistance(0.0D, 4.0D)
/* 269 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 270 */               .addNextBehavior(
/* 271 */                 CECombatBehaviors.Behavior.builder()
/* 272 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 273 */                 .withinDistance(0.0D, 5.0D)
/* 274 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 275 */                 .addNextBehavior(
/* 276 */                   CECombatBehaviors.Behavior.builder()
/* 277 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 278 */                   .withinDistance(0.0D, 5.0D)
/* 279 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 287 */       .addFirstBehavior(
/* 288 */         CECombatBehaviors.Behavior.builder()
/* 289 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 290 */         .withinDistance(0.0D, 3.0D)
/* 291 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 292 */         .addNextBehavior(
/* 293 */           CECombatBehaviors.Behavior.builder()
/* 294 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 295 */           .withinDistance(0.0D, 3.0D)
/* 296 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 297 */           .addNextBehavior(
/* 298 */             CECombatBehaviors.Behavior.builder()
/* 299 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 300 */             .withinDistance(0.0D, 4.0D)
/* 301 */             .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 302 */             .addNextBehavior(
/* 303 */               CECombatBehaviors.Behavior.builder()
/* 304 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 305 */               .withinDistance(0.0D, 4.0D)
/* 306 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 307 */               .addNextBehavior(
/* 308 */                 CECombatBehaviors.Behavior.builder()
/* 309 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 310 */                 .withinDistance(0.0D, 5.0D)
/* 311 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 318 */       .addFirstBehavior(
/* 319 */         CECombatBehaviors.Behavior.builder()
/* 320 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 321 */         .withinDistance(0.0D, 3.0D)
/* 322 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 323 */         .addNextBehavior(
/* 324 */           CECombatBehaviors.Behavior.builder()
/* 325 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 326 */           .withinDistance(0.0D, 3.0D)
/* 327 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 328 */           .addNextBehavior(
/* 329 */             CECombatBehaviors.Behavior.builder()
/* 330 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 331 */             .withinDistance(0.0D, 4.0D)
/* 332 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 333 */             .addNextBehavior(
/* 334 */               CECombatBehaviors.Behavior.builder()
/* 335 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 336 */               .withinDistance(0.0D, 4.0D)
/* 337 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 338 */               .addNextBehavior(
/* 339 */                 CECombatBehaviors.Behavior.builder()
/* 340 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 341 */                 .withinDistance(0.0D, 5.0D)
/* 342 */                 .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 343 */                 .addNextBehavior(
/* 344 */                   CECombatBehaviors.Behavior.builder()
/* 345 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 346 */                   .withinDistance(0.0D, 5.0D)
/* 347 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 355 */       .addFirstBehavior(
/* 356 */         CECombatBehaviors.Behavior.builder()
/* 357 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 358 */         .withinDistance(0.0D, 3.0D)
/* 359 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 360 */         .addNextBehavior(
/* 361 */           CECombatBehaviors.Behavior.builder()
/* 362 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 363 */           .withinDistance(0.0D, 3.0D)
/* 364 */           .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 365 */           .addNextBehavior(
/* 366 */             CECombatBehaviors.Behavior.builder()
/* 367 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 368 */             .withinDistance(0.0D, 4.0D)
/* 369 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 370 */             .addNextBehavior(
/* 371 */               CECombatBehaviors.Behavior.builder()
/* 372 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 373 */               .withinDistance(0.0D, 4.0D)
/* 374 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 375 */               .addNextBehavior(
/* 376 */                 CECombatBehaviors.Behavior.builder()
/* 377 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 378 */                 .withinDistance(0.0D, 5.0D)
/* 379 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 380 */                 .addNextBehavior(
/* 381 */                   CECombatBehaviors.Behavior.builder()
/* 382 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 383 */                   .withinDistance(0.0D, 5.0D)
/* 384 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 392 */       .addFirstBehavior(
/* 393 */         CECombatBehaviors.Behavior.builder()
/* 394 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 395 */         .withinDistance(0.0D, 3.0D)
/* 396 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 397 */         .addNextBehavior(
/* 398 */           CECombatBehaviors.Behavior.builder()
/* 399 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 400 */           .withinDistance(0.0D, 3.0D)
/* 401 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 402 */           .addNextBehavior(
/* 403 */             CECombatBehaviors.Behavior.builder()
/* 404 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 405 */             .withinDistance(0.0D, 4.0D)
/* 406 */             .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 407 */             .addNextBehavior(
/* 408 */               CECombatBehaviors.Behavior.builder()
/* 409 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 410 */               .withinDistance(0.0D, 4.0D)
/* 411 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 412 */               .addNextBehavior(
/* 413 */                 CECombatBehaviors.Behavior.builder()
/* 414 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 415 */                 .withinDistance(0.0D, 5.0D)
/* 416 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 423 */       .addFirstBehavior(
/* 424 */         CECombatBehaviors.Behavior.builder()
/* 425 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 426 */         .withinDistance(0.0D, 3.0D)
/* 427 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 428 */         .addNextBehavior(
/* 429 */           CECombatBehaviors.Behavior.builder()
/* 430 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 431 */           .withinDistance(0.0D, 3.0D)
/* 432 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 433 */           .addNextBehavior(
/* 434 */             CECombatBehaviors.Behavior.builder()
/* 435 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 436 */             .withinDistance(0.0D, 4.0D)
/* 437 */             .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 438 */             .addNextBehavior(
/* 439 */               CECombatBehaviors.Behavior.builder()
/* 440 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 441 */               .withinDistance(0.0D, 4.0D)
/* 442 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 443 */               .addNextBehavior(
/* 444 */                 CECombatBehaviors.Behavior.builder()
/* 445 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 446 */                 .withinDistance(0.0D, 5.0D)
/* 447 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 454 */       .addFirstBehavior(
/* 455 */         CECombatBehaviors.Behavior.builder()
/* 456 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 457 */         .withinDistance(0.0D, 3.0D)
/* 458 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 459 */         .addNextBehavior(
/* 460 */           CECombatBehaviors.Behavior.builder()
/* 461 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 462 */           .withinDistance(0.0D, 3.0D)
/* 463 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 464 */           .addNextBehavior(
/* 465 */             CECombatBehaviors.Behavior.builder()
/* 466 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 467 */             .withinDistance(0.0D, 4.0D)
/* 468 */             .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 469 */             .addNextBehavior(
/* 470 */               CECombatBehaviors.Behavior.builder()
/* 471 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 472 */               .withinDistance(0.0D, 4.0D)
/* 473 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 474 */               .addNextBehavior(
/* 475 */                 CECombatBehaviors.Behavior.builder()
/* 476 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 477 */                 .withinDistance(0.0D, 5.0D)
/* 478 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/* 489 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 490 */         .addNextBehavior(
/* 491 */           CECombatBehaviors.Behavior.builder()
/* 492 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 493 */           .withinDistance(0.0D, 3.0D)
/* 494 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 495 */           .addNextBehavior(
/* 496 */             CECombatBehaviors.Behavior.builder()
/* 497 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 498 */             .withinDistance(0.0D, 4.0D)
/* 499 */             .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 500 */             .addNextBehavior(
/* 501 */               CECombatBehaviors.Behavior.builder()
/* 502 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 503 */               .withinDistance(0.0D, 4.0D)
/* 504 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 505 */               .addNextBehavior(
/* 506 */                 CECombatBehaviors.Behavior.builder()
/* 507 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 508 */                 .withinDistance(0.0D, 5.0D)
/* 509 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/* 520 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 521 */         .addNextBehavior(
/* 522 */           CECombatBehaviors.Behavior.builder()
/* 523 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 524 */           .withinDistance(0.0D, 3.0D)
/* 525 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 526 */           .addNextBehavior(
/* 527 */             CECombatBehaviors.Behavior.builder()
/* 528 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 529 */             .withinDistance(0.0D, 4.0D)
/* 530 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 531 */             .addNextBehavior(
/* 532 */               CECombatBehaviors.Behavior.builder()
/* 533 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 534 */               .withinDistance(0.0D, 4.0D)
/* 535 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 536 */               .addNextBehavior(
/* 537 */                 CECombatBehaviors.Behavior.builder()
/* 538 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 539 */                 .withinDistance(0.0D, 5.0D)
/* 540 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 541 */                 .addNextBehavior(
/* 542 */                   CECombatBehaviors.Behavior.builder()
/* 543 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 544 */                   .withinDistance(0.0D, 5.0D)
/* 545 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 546 */                   .addNextBehavior(
/* 547 */                     CECombatBehaviors.Behavior.builder()
/* 548 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 549 */                     .withinDistance(0.0D, 5.0D)
/* 550 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 559 */       .addFirstBehavior(
/* 560 */         CECombatBehaviors.Behavior.builder()
/* 561 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 562 */         .withinDistance(0.0D, 3.0D)
/* 563 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 564 */         .addNextBehavior(
/* 565 */           CECombatBehaviors.Behavior.builder()
/* 566 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 567 */           .withinDistance(0.0D, 3.0D)
/* 568 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 569 */           .addNextBehavior(
/* 570 */             CECombatBehaviors.Behavior.builder()
/* 571 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 572 */             .withinDistance(0.0D, 4.0D)
/* 573 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 574 */             .addNextBehavior(
/* 575 */               CECombatBehaviors.Behavior.builder()
/* 576 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 577 */               .withinDistance(0.0D, 4.0D)
/* 578 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 579 */               .addNextBehavior(
/* 580 */                 CECombatBehaviors.Behavior.builder()
/* 581 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 582 */                 .withinDistance(0.0D, 5.0D)
/* 583 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 584 */                 .addNextBehavior(
/* 585 */                   CECombatBehaviors.Behavior.builder()
/* 586 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 587 */                   .withinDistance(0.0D, 5.0D)
/* 588 */                   .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 589 */                   .addNextBehavior(
/* 590 */                     CECombatBehaviors.Behavior.builder()
/* 591 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 592 */                     .withinDistance(0.0D, 5.0D)
/* 593 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 602 */       .addFirstBehavior(
/* 603 */         CECombatBehaviors.Behavior.builder()
/* 604 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 605 */         .withinDistance(0.0D, 3.0D)
/* 606 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 607 */         .addNextBehavior(
/* 608 */           CECombatBehaviors.Behavior.builder()
/* 609 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 610 */           .withinDistance(0.0D, 3.0D)
/* 611 */           .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)
/* 612 */           .addNextBehavior(
/* 613 */             CECombatBehaviors.Behavior.builder()
/* 614 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 615 */             .withinDistance(0.0D, 4.0D)
/* 616 */             .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 617 */             .addNextBehavior(
/* 618 */               CECombatBehaviors.Behavior.builder()
/* 619 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 620 */               .withinDistance(0.0D, 4.0D)
/* 621 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 622 */               .addNextBehavior(
/* 623 */                 CECombatBehaviors.Behavior.builder()
/* 624 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 625 */                 .withinDistance(0.0D, 5.0D)
/* 626 */                 .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 627 */                 .addNextBehavior(
/* 628 */                   CECombatBehaviors.Behavior.builder()
/* 629 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 630 */                   .withinDistance(0.0D, 5.0D)
/* 631 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 640 */     .newBehaviorRoot(
/* 641 */       CECombatBehaviors.BehaviorRoot.builder()
/* 642 */       .priority(1.0D)
/* 643 */       .weight(20.0D)
/* 644 */       .maxCooldown(100)
/* 645 */       .addFirstBehavior(
/* 646 */         CECombatBehaviors.Behavior.builder()
/* 647 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 648 */         .withinDistance(0.0D, 3.0D)
/* 649 */         .animationBehavior(Animations.VINDICATOR_SWING_AXE3, 0.0F)))
/*     */ 
/*     */     
/* 652 */     .newBehaviorRoot(
/* 653 */       CECombatBehaviors.BehaviorRoot.builder()
/* 654 */       .priority(1.0D)
/* 655 */       .weight(10.0D)
/* 656 */       .maxCooldown(100)
/* 657 */       .addFirstBehavior(
/* 658 */         CECombatBehaviors.Behavior.builder()
/* 659 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 660 */         .withinDistance(0.0D, 3.0D)
/* 661 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*     */       
/* 663 */       .addFirstBehavior(
/* 664 */         CECombatBehaviors.Behavior.builder()
/* 665 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 666 */         .withinDistance(0.0D, 3.0D)
/* 667 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*     */       
/* 669 */       .addFirstBehavior(
/* 670 */         CECombatBehaviors.Behavior.builder()
/* 671 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 672 */         .withinDistance(0.0D, 3.0D)
/* 673 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))
/*     */ 
/*     */     
/* 676 */     .newBehaviorRoot(
/* 677 */       CECombatBehaviors.BehaviorRoot.builder()
/* 678 */       .priority(1.0D)
/* 679 */       .weight(10.0D)
/* 680 */       .maxCooldown(40)
/* 681 */       .addFirstBehavior(
/* 682 */         CECombatBehaviors.Behavior.builder()
/* 683 */         .withinDistance(0.0D, 3.0D)
/* 684 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 685 */         .custom(CombatCommon::canThrowEnderPearl)
/* 686 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 687 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 688 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 691 */     .newBehaviorRoot(
/* 692 */       CECombatBehaviors.BehaviorRoot.builder()
/* 693 */       .priority(1.0D)
/* 694 */       .weight(2.0D)
/* 695 */       .maxCooldown(100)
/* 696 */       .addFirstBehavior(
/* 697 */         CECombatBehaviors.Behavior.builder()
/* 698 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 699 */         .withinDistance(0.0D, 3.0D)
/* 700 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 702 */       .addFirstBehavior(
/* 703 */         CECombatBehaviors.Behavior.builder()
/* 704 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 705 */         .withinDistance(0.0D, 3.0D)
/* 706 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 708 */       .addFirstBehavior(
/* 709 */         CECombatBehaviors.Behavior.builder()
/* 710 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 711 */         .withinDistance(0.0D, 3.0D)
/* 712 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 714 */       .addFirstBehavior(
/* 715 */         CECombatBehaviors.Behavior.builder()
/* 716 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 717 */         .withinDistance(0.0D, 3.0D)
/* 718 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 720 */       .addFirstBehavior(
/* 721 */         CECombatBehaviors.Behavior.builder()
/* 722 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 723 */         .withinDistance(0.0D, 3.0D)
/* 724 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 726 */       .addFirstBehavior(
/* 727 */         CECombatBehaviors.Behavior.builder()
/* 728 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 729 */         .withinDistance(0.0D, 3.0D)
/* 730 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 732 */       .addFirstBehavior(
/* 733 */         CECombatBehaviors.Behavior.builder()
/* 734 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 735 */         .withinDistance(0.0D, 3.0D)
/* 736 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 739 */     .newBehaviorRoot(
/* 740 */       CECombatBehaviors.BehaviorRoot.builder()
/* 741 */       .priority(1.0D)
/* 742 */       .weight(15.0D)
/* 743 */       .addFirstBehavior(
/* 744 */         CECombatBehaviors.Behavior.builder()
/* 745 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 746 */         .withinDistance(0.0D, 3.0D)
/* 747 */         .custom(CombatCommon::canPerformGuarding)
/* 748 */         .guard(40)))
/*     */ 
/*     */     
/* 751 */     .newBehaviorRoot(
/* 752 */       CECombatBehaviors.BehaviorRoot.builder()
/* 753 */       .priority(1.0D)
/* 754 */       .weight(10.0D)
/* 755 */       .addFirstBehavior(
/* 756 */         CECombatBehaviors.Behavior.builder()
/* 757 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 758 */         .withinDistance(0.0D, 3.0D)
/* 759 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 761 */       .addFirstBehavior(
/* 762 */         CECombatBehaviors.Behavior.builder()
/* 763 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 764 */         .withinDistance(0.0D, 3.0D)
/* 765 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))
/*     */ 
/*     */     
/* 768 */     .newBehaviorRoot(
/* 769 */       CECombatBehaviors.BehaviorRoot.builder()
/* 770 */       .priority(1.0D)
/* 771 */       .weight(40.0D)
/* 772 */       .maxCooldown(160)
/* 773 */       .addFirstBehavior(
/* 774 */         CECombatBehaviors.Behavior.builder()
/* 775 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 776 */         .custom(CombatCommon::canJump)
/* 777 */         .withinDistance(5.0D, 14.0D)
/* 778 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 779 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcLadder.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */