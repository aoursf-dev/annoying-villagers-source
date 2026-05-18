/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.efkick.gameasset.EFKickAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsHerrscher;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SteveTrapdoor
/*     */ {
/*  15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> TRAPDOOR = CECombatBehaviors.builder()
/*  16 */     .newBehaviorRoot(
/*  17 */       CECombatBehaviors.BehaviorRoot.builder()
/*  18 */       .priority(5.0D)
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
/*  31 */       .priority(4.0D)
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
/*  50 */       .priority(3.0D)
/*  51 */       .weight(100.0D)
/*  52 */       .maxCooldown(120)
/*  53 */       .addFirstBehavior(
/*  54 */         CECombatBehaviors.Behavior.builder()
/*  55 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  56 */         .custom(CombatCommon::canSwitchWeapon)
/*  57 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  58 */         .addExBehavior(CombatCommon::switchWeapon))
/*     */       
/*  60 */       .addFirstBehavior(
/*  61 */         CECombatBehaviors.Behavior.builder()
/*  62 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  63 */         .custom(CombatCommon::canSwitchWeapon)
/*  64 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  65 */         .addExBehavior(CombatCommon::switchWeapon)))
/*     */ 
/*     */     
/*  68 */     .newBehaviorRoot(
/*  69 */       CECombatBehaviors.BehaviorRoot.builder()
/*  70 */       .priority(2.0D)
/*  71 */       .weight(70.0D)
/*  72 */       .maxCooldown(0)
/*  73 */       .addFirstBehavior(
/*  74 */         CECombatBehaviors.Behavior.builder()
/*  75 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  76 */         .custom(CombatCommon::canPerformEating)
/*  77 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  78 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  81 */     .newBehaviorRoot(
/*  82 */       CECombatBehaviors.BehaviorRoot.builder()
/*  83 */       .priority(2.0D)
/*  84 */       .weight(100.0D)
/*  85 */       .maxCooldown(120)
/*  86 */       .addFirstBehavior(
/*  87 */         CECombatBehaviors.Behavior.builder()
/*  88 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  89 */         .custom(CombatCommon::canSwapToBow)
/*  90 */         .withinDistance(7.0D, 14.0D)
/*  91 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  92 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  94 */       .addFirstBehavior(
/*  95 */         CECombatBehaviors.Behavior.builder()
/*  96 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  97 */         .custom(CombatCommon::canSwapToBow)
/*  98 */         .withinDistance(7.0D, 14.0D)
/*  99 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 100 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/* 103 */     .newBehaviorRoot(
/* 104 */       CECombatBehaviors.BehaviorRoot.builder()
/* 105 */       .priority(2.0D)
/* 106 */       .weight(80.0D)
/* 107 */       .maxCooldown(120)
/* 108 */       .addFirstBehavior(
/* 109 */         CECombatBehaviors.Behavior.builder()
/* 110 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 111 */         .custom(CombatCommon::canThrowEnderPearl)
/* 112 */         .withinDistance(7.0D, 48.0D)
/* 113 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 114 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/* 117 */     .newBehaviorRoot(
/* 118 */       CECombatBehaviors.BehaviorRoot.builder()
/* 119 */       .priority(1.0D)
/* 120 */       .weight(40.0D)
/* 121 */       .maxCooldown(20)
/* 122 */       .addFirstBehavior(
/* 123 */         CECombatBehaviors.Behavior.builder()
/* 124 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 125 */         .withinDistance(0.0D, 3.0D)
/* 126 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 127 */         .addNextBehavior(
/* 128 */           CECombatBehaviors.Behavior.builder()
/* 129 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 130 */           .withinDistance(0.0D, 3.0D)
/* 131 */           .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 132 */           .addNextBehavior(
/* 133 */             CECombatBehaviors.Behavior.builder()
/* 134 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */             .withinDistance(0.0D, 3.0D)
/* 136 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 137 */             .addNextBehavior(
/* 138 */               CECombatBehaviors.Behavior.builder()
/* 139 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 140 */               .withinDistance(0.0D, 3.0D)
/* 141 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       .addFirstBehavior(
/* 147 */         CECombatBehaviors.Behavior.builder()
/* 148 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 149 */         .withinDistance(0.0D, 3.0D)
/* 150 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 151 */         .addNextBehavior(
/* 152 */           CECombatBehaviors.Behavior.builder()
/* 153 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 154 */           .withinDistance(0.0D, 3.0D)
/* 155 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 156 */           .addNextBehavior(
/* 157 */             CECombatBehaviors.Behavior.builder()
/* 158 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 159 */             .withinDistance(0.0D, 4.0D)
/* 160 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 161 */             .addNextBehavior(
/* 162 */               CECombatBehaviors.Behavior.builder()
/* 163 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 164 */               .withinDistance(0.0D, 4.0D)
/* 165 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 166 */               .addNextBehavior(
/* 167 */                 CECombatBehaviors.Behavior.builder()
/* 168 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 169 */                 .withinDistance(0.0D, 5.0D)
/* 170 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 171 */                 .addNextBehavior(
/* 172 */                   CECombatBehaviors.Behavior.builder()
/* 173 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 174 */                   .withinDistance(0.0D, 5.0D)
/* 175 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       .addFirstBehavior(
/* 183 */         CECombatBehaviors.Behavior.builder()
/* 184 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 185 */         .withinDistance(0.0D, 3.0D)
/* 186 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 187 */         .addNextBehavior(
/* 188 */           CECombatBehaviors.Behavior.builder()
/* 189 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 190 */           .withinDistance(0.0D, 3.0D)
/* 191 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 192 */           .addNextBehavior(
/* 193 */             CECombatBehaviors.Behavior.builder()
/* 194 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 195 */             .withinDistance(0.0D, 4.0D)
/* 196 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 197 */             .addNextBehavior(
/* 198 */               CECombatBehaviors.Behavior.builder()
/* 199 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 200 */               .withinDistance(0.0D, 4.0D)
/* 201 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 202 */               .addNextBehavior(
/* 203 */                 CECombatBehaviors.Behavior.builder()
/* 204 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 205 */                 .withinDistance(0.0D, 5.0D)
/* 206 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 213 */       .addFirstBehavior(
/* 214 */         CECombatBehaviors.Behavior.builder()
/* 215 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 216 */         .withinDistance(0.0D, 3.0D)
/* 217 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 218 */         .addNextBehavior(
/* 219 */           CECombatBehaviors.Behavior.builder()
/* 220 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 221 */           .withinDistance(0.0D, 3.0D)
/* 222 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 223 */           .addNextBehavior(
/* 224 */             CECombatBehaviors.Behavior.builder()
/* 225 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 226 */             .withinDistance(0.0D, 4.0D)
/* 227 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 228 */             .addNextBehavior(
/* 229 */               CECombatBehaviors.Behavior.builder()
/* 230 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 231 */               .withinDistance(0.0D, 4.0D)
/* 232 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 233 */               .addNextBehavior(
/* 234 */                 CECombatBehaviors.Behavior.builder()
/* 235 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 236 */                 .withinDistance(0.0D, 5.0D)
/* 237 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 244 */       .addFirstBehavior(
/* 245 */         CECombatBehaviors.Behavior.builder()
/* 246 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 247 */         .withinDistance(0.0D, 3.0D)
/* 248 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 249 */         .addNextBehavior(
/* 250 */           CECombatBehaviors.Behavior.builder()
/* 251 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 252 */           .withinDistance(0.0D, 3.0D)
/* 253 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 254 */           .addNextBehavior(
/* 255 */             CECombatBehaviors.Behavior.builder()
/* 256 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 257 */             .withinDistance(0.0D, 4.0D)
/* 258 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 259 */             .addNextBehavior(
/* 260 */               CECombatBehaviors.Behavior.builder()
/* 261 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 262 */               .withinDistance(0.0D, 4.0D)
/* 263 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 264 */               .addNextBehavior(
/* 265 */                 CECombatBehaviors.Behavior.builder()
/* 266 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 267 */                 .withinDistance(0.0D, 5.0D)
/* 268 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 275 */       .addFirstBehavior(
/* 276 */         CECombatBehaviors.Behavior.builder()
/* 277 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 278 */         .withinDistance(0.0D, 3.0D)
/* 279 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 280 */         .addNextBehavior(
/* 281 */           CECombatBehaviors.Behavior.builder()
/* 282 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 283 */           .withinDistance(0.0D, 3.0D)
/* 284 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 285 */           .addNextBehavior(
/* 286 */             CECombatBehaviors.Behavior.builder()
/* 287 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 288 */             .withinDistance(0.0D, 4.0D)
/* 289 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 290 */             .addNextBehavior(
/* 291 */               CECombatBehaviors.Behavior.builder()
/* 292 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 293 */               .withinDistance(0.0D, 4.0D)
/* 294 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 295 */               .addNextBehavior(
/* 296 */                 CECombatBehaviors.Behavior.builder()
/* 297 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 298 */                 .withinDistance(0.0D, 5.0D)
/* 299 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/* 310 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 311 */         .addNextBehavior(
/* 312 */           CECombatBehaviors.Behavior.builder()
/* 313 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 314 */           .withinDistance(0.0D, 3.0D)
/* 315 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 316 */           .addNextBehavior(
/* 317 */             CECombatBehaviors.Behavior.builder()
/* 318 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 319 */             .withinDistance(0.0D, 4.0D)
/* 320 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 321 */             .addNextBehavior(
/* 322 */               CECombatBehaviors.Behavior.builder()
/* 323 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 324 */               .withinDistance(0.0D, 4.0D)
/* 325 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 326 */               .addNextBehavior(
/* 327 */                 CECombatBehaviors.Behavior.builder()
/* 328 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 329 */                 .withinDistance(0.0D, 5.0D)
/* 330 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/* 341 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 342 */         .addNextBehavior(
/* 343 */           CECombatBehaviors.Behavior.builder()
/* 344 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 345 */           .withinDistance(0.0D, 3.0D)
/* 346 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 347 */           .addNextBehavior(
/* 348 */             CECombatBehaviors.Behavior.builder()
/* 349 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 350 */             .withinDistance(0.0D, 4.0D)
/* 351 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 352 */             .addNextBehavior(
/* 353 */               CECombatBehaviors.Behavior.builder()
/* 354 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 355 */               .withinDistance(0.0D, 4.0D)
/* 356 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 357 */               .addNextBehavior(
/* 358 */                 CECombatBehaviors.Behavior.builder()
/* 359 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 360 */                 .withinDistance(0.0D, 5.0D)
/* 361 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 368 */       .addFirstBehavior(
/* 369 */         CECombatBehaviors.Behavior.builder()
/* 370 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 371 */         .withinDistance(0.0D, 3.0D)
/* 372 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 373 */         .addNextBehavior(
/* 374 */           CECombatBehaviors.Behavior.builder()
/* 375 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 376 */           .withinDistance(0.0D, 3.0D)
/* 377 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 378 */           .addNextBehavior(
/* 379 */             CECombatBehaviors.Behavior.builder()
/* 380 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 381 */             .withinDistance(0.0D, 4.0D)
/* 382 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 383 */             .addNextBehavior(
/* 384 */               CECombatBehaviors.Behavior.builder()
/* 385 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 386 */               .withinDistance(0.0D, 4.0D)
/* 387 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 388 */               .addNextBehavior(
/* 389 */                 CECombatBehaviors.Behavior.builder()
/* 390 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 391 */                 .withinDistance(0.0D, 5.0D)
/* 392 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 393 */                 .addNextBehavior(
/* 394 */                   CECombatBehaviors.Behavior.builder()
/* 395 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 396 */                   .withinDistance(0.0D, 5.0D)
/* 397 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
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
/* 409 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 410 */         .addNextBehavior(
/* 411 */           CECombatBehaviors.Behavior.builder()
/* 412 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 413 */           .withinDistance(0.0D, 3.0D)
/* 414 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 415 */           .addNextBehavior(
/* 416 */             CECombatBehaviors.Behavior.builder()
/* 417 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 418 */             .withinDistance(0.0D, 4.0D)
/* 419 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 420 */             .addNextBehavior(
/* 421 */               CECombatBehaviors.Behavior.builder()
/* 422 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 423 */               .withinDistance(0.0D, 4.0D)
/* 424 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 425 */               .addNextBehavior(
/* 426 */                 CECombatBehaviors.Behavior.builder()
/* 427 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 428 */                 .withinDistance(0.0D, 5.0D)
/* 429 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 430 */                 .addNextBehavior(
/* 431 */                   CECombatBehaviors.Behavior.builder()
/* 432 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 433 */                   .withinDistance(0.0D, 5.0D)
/* 434 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
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
/* 446 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 447 */         .addNextBehavior(
/* 448 */           CECombatBehaviors.Behavior.builder()
/* 449 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 450 */           .withinDistance(0.0D, 3.0D)
/* 451 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 452 */           .addNextBehavior(
/* 453 */             CECombatBehaviors.Behavior.builder()
/* 454 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 455 */             .withinDistance(0.0D, 4.0D)
/* 456 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 457 */             .addNextBehavior(
/* 458 */               CECombatBehaviors.Behavior.builder()
/* 459 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 460 */               .withinDistance(0.0D, 4.0D)
/* 461 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 462 */               .addNextBehavior(
/* 463 */                 CECombatBehaviors.Behavior.builder()
/* 464 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 465 */                 .withinDistance(0.0D, 5.0D)
/* 466 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 467 */                 .addNextBehavior(
/* 468 */                   CECombatBehaviors.Behavior.builder()
/* 469 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 470 */                   .withinDistance(0.0D, 5.0D)
/* 471 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 479 */       .addFirstBehavior(
/* 480 */         CECombatBehaviors.Behavior.builder()
/* 481 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 482 */         .withinDistance(0.0D, 3.0D)
/* 483 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 484 */         .addNextBehavior(
/* 485 */           CECombatBehaviors.Behavior.builder()
/* 486 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 487 */           .withinDistance(0.0D, 3.0D)
/* 488 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 489 */           .addNextBehavior(
/* 490 */             CECombatBehaviors.Behavior.builder()
/* 491 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 492 */             .withinDistance(0.0D, 4.0D)
/* 493 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 494 */             .addNextBehavior(
/* 495 */               CECombatBehaviors.Behavior.builder()
/* 496 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 497 */               .withinDistance(0.0D, 4.0D)
/* 498 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 499 */               .addNextBehavior(
/* 500 */                 CECombatBehaviors.Behavior.builder()
/* 501 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 502 */                 .withinDistance(0.0D, 5.0D)
/* 503 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 504 */                 .addNextBehavior(
/* 505 */                   CECombatBehaviors.Behavior.builder()
/* 506 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 507 */                   .withinDistance(0.0D, 5.0D)
/* 508 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
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
/* 525 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 526 */           .addNextBehavior(
/* 527 */             CECombatBehaviors.Behavior.builder()
/* 528 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 529 */             .withinDistance(0.0D, 4.0D)
/* 530 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 531 */             .addNextBehavior(
/* 532 */               CECombatBehaviors.Behavior.builder()
/* 533 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 534 */               .withinDistance(0.0D, 4.0D)
/* 535 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 536 */               .addNextBehavior(
/* 537 */                 CECombatBehaviors.Behavior.builder()
/* 538 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 539 */                 .withinDistance(0.0D, 5.0D)
/* 540 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 547 */       .addFirstBehavior(
/* 548 */         CECombatBehaviors.Behavior.builder()
/* 549 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 550 */         .withinDistance(0.0D, 3.0D)
/* 551 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 552 */         .addNextBehavior(
/* 553 */           CECombatBehaviors.Behavior.builder()
/* 554 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 555 */           .withinDistance(0.0D, 3.0D)
/* 556 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 557 */           .addNextBehavior(
/* 558 */             CECombatBehaviors.Behavior.builder()
/* 559 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 560 */             .withinDistance(0.0D, 4.0D)
/* 561 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 562 */             .addNextBehavior(
/* 563 */               CECombatBehaviors.Behavior.builder()
/* 564 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 565 */               .withinDistance(0.0D, 4.0D)
/* 566 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 567 */               .addNextBehavior(
/* 568 */                 CECombatBehaviors.Behavior.builder()
/* 569 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 570 */                 .withinDistance(0.0D, 5.0D)
/* 571 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/* 587 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 588 */           .addNextBehavior(
/* 589 */             CECombatBehaviors.Behavior.builder()
/* 590 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 591 */             .withinDistance(0.0D, 4.0D)
/* 592 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 593 */             .addNextBehavior(
/* 594 */               CECombatBehaviors.Behavior.builder()
/* 595 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 596 */               .withinDistance(0.0D, 4.0D)
/* 597 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 598 */               .addNextBehavior(
/* 599 */                 CECombatBehaviors.Behavior.builder()
/* 600 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 601 */                 .withinDistance(0.0D, 5.0D)
/* 602 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 609 */       .addFirstBehavior(
/* 610 */         CECombatBehaviors.Behavior.builder()
/* 611 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 612 */         .withinDistance(0.0D, 3.0D)
/* 613 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 614 */         .addNextBehavior(
/* 615 */           CECombatBehaviors.Behavior.builder()
/* 616 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 617 */           .withinDistance(0.0D, 3.0D)
/* 618 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 619 */           .addNextBehavior(
/* 620 */             CECombatBehaviors.Behavior.builder()
/* 621 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 622 */             .withinDistance(0.0D, 4.0D)
/* 623 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 624 */             .addNextBehavior(
/* 625 */               CECombatBehaviors.Behavior.builder()
/* 626 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 627 */               .withinDistance(0.0D, 4.0D)
/* 628 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 629 */               .addNextBehavior(
/* 630 */                 CECombatBehaviors.Behavior.builder()
/* 631 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 632 */                 .withinDistance(0.0D, 5.0D)
/* 633 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 634 */                 .addNextBehavior(
/* 635 */                   CECombatBehaviors.Behavior.builder()
/* 636 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 637 */                   .withinDistance(0.0D, 5.0D)
/* 638 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 646 */       .addFirstBehavior(
/* 647 */         CECombatBehaviors.Behavior.builder()
/* 648 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 649 */         .withinDistance(0.0D, 3.0D)
/* 650 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 651 */         .addNextBehavior(
/* 652 */           CECombatBehaviors.Behavior.builder()
/* 653 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 654 */           .withinDistance(0.0D, 3.0D)
/* 655 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 656 */           .addNextBehavior(
/* 657 */             CECombatBehaviors.Behavior.builder()
/* 658 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 659 */             .withinDistance(0.0D, 4.0D)
/* 660 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 661 */             .addNextBehavior(
/* 662 */               CECombatBehaviors.Behavior.builder()
/* 663 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 664 */               .withinDistance(0.0D, 4.0D)
/* 665 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 666 */               .addNextBehavior(
/* 667 */                 CECombatBehaviors.Behavior.builder()
/* 668 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 669 */                 .withinDistance(0.0D, 5.0D)
/* 670 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 678 */     .newBehaviorRoot(
/* 679 */       CECombatBehaviors.BehaviorRoot.builder()
/* 680 */       .priority(1.0D)
/* 681 */       .weight(20.0D)
/* 682 */       .maxCooldown(100)
/* 683 */       .addFirstBehavior(
/* 684 */         CECombatBehaviors.Behavior.builder()
/* 685 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 686 */         .withinDistance(0.0D, 3.0D)
/* 687 */         .animationBehavior(Animations.VINDICATOR_SWING_AXE2, 0.0F)))
/*     */ 
/*     */     
/* 690 */     .newBehaviorRoot(
/* 691 */       CECombatBehaviors.BehaviorRoot.builder()
/* 692 */       .priority(1.0D)
/* 693 */       .weight(10.0D)
/* 694 */       .maxCooldown(100)
/* 695 */       .addFirstBehavior(
/* 696 */         CECombatBehaviors.Behavior.builder()
/* 697 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 698 */         .withinDistance(0.0D, 3.0D)
/* 699 */         .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F))
/*     */       
/* 701 */       .addFirstBehavior(
/* 702 */         CECombatBehaviors.Behavior.builder()
/* 703 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 704 */         .withinDistance(0.0D, 3.0D)
/* 705 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*     */       
/* 707 */       .addFirstBehavior(
/* 708 */         CECombatBehaviors.Behavior.builder()
/* 709 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 710 */         .withinDistance(0.0D, 3.0D)
/* 711 */         .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)))
/*     */ 
/*     */     
/* 714 */     .newBehaviorRoot(
/* 715 */       CECombatBehaviors.BehaviorRoot.builder()
/* 716 */       .priority(1.0D)
/* 717 */       .weight(10.0D)
/* 718 */       .maxCooldown(40)
/* 719 */       .addFirstBehavior(
/* 720 */         CECombatBehaviors.Behavior.builder()
/* 721 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 722 */         .withinDistance(0.0D, 3.0D)
/* 723 */         .custom(CombatCommon::canThrowEnderPearl)
/* 724 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 725 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 726 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 729 */     .newBehaviorRoot(
/* 730 */       CECombatBehaviors.BehaviorRoot.builder()
/* 731 */       .priority(1.0D)
/* 732 */       .weight(2.0D)
/* 733 */       .maxCooldown(100)
/* 734 */       .addFirstBehavior(
/* 735 */         CECombatBehaviors.Behavior.builder()
/* 736 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 737 */         .withinDistance(0.0D, 3.0D)
/* 738 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 740 */       .addFirstBehavior(
/* 741 */         CECombatBehaviors.Behavior.builder()
/* 742 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 743 */         .withinDistance(0.0D, 3.0D)
/* 744 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 746 */       .addFirstBehavior(
/* 747 */         CECombatBehaviors.Behavior.builder()
/* 748 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 749 */         .withinDistance(0.0D, 3.0D)
/* 750 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 752 */       .addFirstBehavior(
/* 753 */         CECombatBehaviors.Behavior.builder()
/* 754 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 755 */         .withinDistance(0.0D, 3.0D)
/* 756 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 758 */       .addFirstBehavior(
/* 759 */         CECombatBehaviors.Behavior.builder()
/* 760 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 761 */         .withinDistance(0.0D, 3.0D)
/* 762 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 764 */       .addFirstBehavior(
/* 765 */         CECombatBehaviors.Behavior.builder()
/* 766 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 767 */         .withinDistance(0.0D, 3.0D)
/* 768 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 770 */       .addFirstBehavior(
/* 771 */         CECombatBehaviors.Behavior.builder()
/* 772 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 773 */         .withinDistance(0.0D, 3.0D)
/* 774 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 777 */     .newBehaviorRoot(
/* 778 */       CECombatBehaviors.BehaviorRoot.builder()
/* 779 */       .priority(1.0D)
/* 780 */       .weight(15.0D)
/* 781 */       .addFirstBehavior(
/* 782 */         CECombatBehaviors.Behavior.builder()
/* 783 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 784 */         .withinDistance(0.0D, 3.0D)
/* 785 */         .custom(CombatCommon::canPerformGuarding)
/* 786 */         .guard(40)))
/*     */ 
/*     */     
/* 789 */     .newBehaviorRoot(
/* 790 */       CECombatBehaviors.BehaviorRoot.builder()
/* 791 */       .priority(1.0D)
/* 792 */       .weight(10.0D)
/* 793 */       .addFirstBehavior(
/* 794 */         CECombatBehaviors.Behavior.builder()
/* 795 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 796 */         .withinDistance(0.0D, 3.0D)
/* 797 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 799 */       .addFirstBehavior(
/* 800 */         CECombatBehaviors.Behavior.builder()
/* 801 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 802 */         .withinDistance(0.0D, 3.0D)
/* 803 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))
/*     */ 
/*     */     
/* 806 */     .newBehaviorRoot(
/* 807 */       CECombatBehaviors.BehaviorRoot.builder()
/* 808 */       .priority(1.0D)
/* 809 */       .weight(40.0D)
/* 810 */       .maxCooldown(160)
/* 811 */       .addFirstBehavior(
/* 812 */         CECombatBehaviors.Behavior.builder()
/* 813 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 814 */         .custom(CombatCommon::canJump)
/* 815 */         .withinDistance(5.0D, 14.0D)
/* 816 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 817 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveTrapdoor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */