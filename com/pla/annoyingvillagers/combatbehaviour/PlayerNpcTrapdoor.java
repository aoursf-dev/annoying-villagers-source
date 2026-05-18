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
/*     */ 
/*     */ public class PlayerNpcTrapdoor
/*     */ {
/*  16 */   public static final CECombatBehaviors.Builder<MobPatch<?>> TRAPDOOR = CECombatBehaviors.builder()
/*  17 */     .newBehaviorRoot(
/*  18 */       CECombatBehaviors.BehaviorRoot.builder()
/*  19 */       .priority(4.0D)
/*  20 */       .weight(1000.0D)
/*  21 */       .maxCooldown(0)
/*  22 */       .addFirstBehavior(
/*  23 */         CECombatBehaviors.Behavior.builder()
/*  24 */         .custom(CombatCommon::canExecute)
/*  25 */         .withinDistance(0.0D, 5.0D)
/*  26 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  27 */         .addExBehavior(CombatCommon::performExecute)))
/*     */ 
/*     */     
/*  30 */     .newBehaviorRoot(
/*  31 */       CECombatBehaviors.BehaviorRoot.builder()
/*  32 */       .priority(3.0D)
/*  33 */       .weight(1000.0D)
/*  34 */       .maxCooldown(0)
/*  35 */       .addFirstBehavior(
/*  36 */         CECombatBehaviors.Behavior.builder()
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
/* 107 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 108 */         .addNextBehavior(
/* 109 */           CECombatBehaviors.Behavior.builder()
/* 110 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 111 */           .withinDistance(0.0D, 3.0D)
/* 112 */           .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 113 */           .addNextBehavior(
/* 114 */             CECombatBehaviors.Behavior.builder()
/* 115 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 116 */             .withinDistance(0.0D, 3.0D)
/* 117 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 118 */             .addNextBehavior(
/* 119 */               CECombatBehaviors.Behavior.builder()
/* 120 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 121 */               .withinDistance(0.0D, 3.0D)
/* 122 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 127 */       .addFirstBehavior(
/* 128 */         CECombatBehaviors.Behavior.builder()
/* 129 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 130 */         .withinDistance(0.0D, 3.0D)
/* 131 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 132 */         .addNextBehavior(
/* 133 */           CECombatBehaviors.Behavior.builder()
/* 134 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */           .withinDistance(0.0D, 3.0D)
/* 136 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 137 */           .addNextBehavior(
/* 138 */             CECombatBehaviors.Behavior.builder()
/* 139 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 140 */             .withinDistance(0.0D, 4.0D)
/* 141 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 142 */             .addNextBehavior(
/* 143 */               CECombatBehaviors.Behavior.builder()
/* 144 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 145 */               .withinDistance(0.0D, 4.0D)
/* 146 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 147 */               .addNextBehavior(
/* 148 */                 CECombatBehaviors.Behavior.builder()
/* 149 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 150 */                 .withinDistance(0.0D, 5.0D)
/* 151 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 152 */                 .addNextBehavior(
/* 153 */                   CECombatBehaviors.Behavior.builder()
/* 154 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 155 */                   .withinDistance(0.0D, 5.0D)
/* 156 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       .addFirstBehavior(
/* 164 */         CECombatBehaviors.Behavior.builder()
/* 165 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 166 */         .withinDistance(0.0D, 3.0D)
/* 167 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 168 */         .addNextBehavior(
/* 169 */           CECombatBehaviors.Behavior.builder()
/* 170 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 171 */           .withinDistance(0.0D, 3.0D)
/* 172 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 173 */           .addNextBehavior(
/* 174 */             CECombatBehaviors.Behavior.builder()
/* 175 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 176 */             .withinDistance(0.0D, 4.0D)
/* 177 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 178 */             .addNextBehavior(
/* 179 */               CECombatBehaviors.Behavior.builder()
/* 180 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 181 */               .withinDistance(0.0D, 4.0D)
/* 182 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 183 */               .addNextBehavior(
/* 184 */                 CECombatBehaviors.Behavior.builder()
/* 185 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 186 */                 .withinDistance(0.0D, 5.0D)
/* 187 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 194 */       .addFirstBehavior(
/* 195 */         CECombatBehaviors.Behavior.builder()
/* 196 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 197 */         .withinDistance(0.0D, 3.0D)
/* 198 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 199 */         .addNextBehavior(
/* 200 */           CECombatBehaviors.Behavior.builder()
/* 201 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 202 */           .withinDistance(0.0D, 3.0D)
/* 203 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 204 */           .addNextBehavior(
/* 205 */             CECombatBehaviors.Behavior.builder()
/* 206 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 207 */             .withinDistance(0.0D, 4.0D)
/* 208 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 209 */             .addNextBehavior(
/* 210 */               CECombatBehaviors.Behavior.builder()
/* 211 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 212 */               .withinDistance(0.0D, 4.0D)
/* 213 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 214 */               .addNextBehavior(
/* 215 */                 CECombatBehaviors.Behavior.builder()
/* 216 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 217 */                 .withinDistance(0.0D, 5.0D)
/* 218 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 225 */       .addFirstBehavior(
/* 226 */         CECombatBehaviors.Behavior.builder()
/* 227 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 228 */         .withinDistance(0.0D, 3.0D)
/* 229 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 230 */         .addNextBehavior(
/* 231 */           CECombatBehaviors.Behavior.builder()
/* 232 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 233 */           .withinDistance(0.0D, 3.0D)
/* 234 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 235 */           .addNextBehavior(
/* 236 */             CECombatBehaviors.Behavior.builder()
/* 237 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 238 */             .withinDistance(0.0D, 4.0D)
/* 239 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 240 */             .addNextBehavior(
/* 241 */               CECombatBehaviors.Behavior.builder()
/* 242 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 243 */               .withinDistance(0.0D, 4.0D)
/* 244 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 245 */               .addNextBehavior(
/* 246 */                 CECombatBehaviors.Behavior.builder()
/* 247 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 248 */                 .withinDistance(0.0D, 5.0D)
/* 249 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 256 */       .addFirstBehavior(
/* 257 */         CECombatBehaviors.Behavior.builder()
/* 258 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 259 */         .withinDistance(0.0D, 3.0D)
/* 260 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 261 */         .addNextBehavior(
/* 262 */           CECombatBehaviors.Behavior.builder()
/* 263 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 264 */           .withinDistance(0.0D, 3.0D)
/* 265 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 266 */           .addNextBehavior(
/* 267 */             CECombatBehaviors.Behavior.builder()
/* 268 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 269 */             .withinDistance(0.0D, 4.0D)
/* 270 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 271 */             .addNextBehavior(
/* 272 */               CECombatBehaviors.Behavior.builder()
/* 273 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 274 */               .withinDistance(0.0D, 4.0D)
/* 275 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 276 */               .addNextBehavior(
/* 277 */                 CECombatBehaviors.Behavior.builder()
/* 278 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 279 */                 .withinDistance(0.0D, 5.0D)
/* 280 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/* 291 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 292 */         .addNextBehavior(
/* 293 */           CECombatBehaviors.Behavior.builder()
/* 294 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 295 */           .withinDistance(0.0D, 3.0D)
/* 296 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 297 */           .addNextBehavior(
/* 298 */             CECombatBehaviors.Behavior.builder()
/* 299 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 300 */             .withinDistance(0.0D, 4.0D)
/* 301 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 302 */             .addNextBehavior(
/* 303 */               CECombatBehaviors.Behavior.builder()
/* 304 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 305 */               .withinDistance(0.0D, 4.0D)
/* 306 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 307 */               .addNextBehavior(
/* 308 */                 CECombatBehaviors.Behavior.builder()
/* 309 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 310 */                 .withinDistance(0.0D, 5.0D)
/* 311 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/* 322 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 323 */         .addNextBehavior(
/* 324 */           CECombatBehaviors.Behavior.builder()
/* 325 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 326 */           .withinDistance(0.0D, 3.0D)
/* 327 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 328 */           .addNextBehavior(
/* 329 */             CECombatBehaviors.Behavior.builder()
/* 330 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 331 */             .withinDistance(0.0D, 4.0D)
/* 332 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 333 */             .addNextBehavior(
/* 334 */               CECombatBehaviors.Behavior.builder()
/* 335 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 336 */               .withinDistance(0.0D, 4.0D)
/* 337 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 338 */               .addNextBehavior(
/* 339 */                 CECombatBehaviors.Behavior.builder()
/* 340 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 341 */                 .withinDistance(0.0D, 5.0D)
/* 342 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 349 */       .addFirstBehavior(
/* 350 */         CECombatBehaviors.Behavior.builder()
/* 351 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 352 */         .withinDistance(0.0D, 3.0D)
/* 353 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 354 */         .addNextBehavior(
/* 355 */           CECombatBehaviors.Behavior.builder()
/* 356 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 357 */           .withinDistance(0.0D, 3.0D)
/* 358 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 359 */           .addNextBehavior(
/* 360 */             CECombatBehaviors.Behavior.builder()
/* 361 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 362 */             .withinDistance(0.0D, 4.0D)
/* 363 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 364 */             .addNextBehavior(
/* 365 */               CECombatBehaviors.Behavior.builder()
/* 366 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 367 */               .withinDistance(0.0D, 4.0D)
/* 368 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 369 */               .addNextBehavior(
/* 370 */                 CECombatBehaviors.Behavior.builder()
/* 371 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 372 */                 .withinDistance(0.0D, 5.0D)
/* 373 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 374 */                 .addNextBehavior(
/* 375 */                   CECombatBehaviors.Behavior.builder()
/* 376 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 377 */                   .withinDistance(0.0D, 5.0D)
/* 378 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 386 */       .addFirstBehavior(
/* 387 */         CECombatBehaviors.Behavior.builder()
/* 388 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 389 */         .withinDistance(0.0D, 3.0D)
/* 390 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 391 */         .addNextBehavior(
/* 392 */           CECombatBehaviors.Behavior.builder()
/* 393 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 394 */           .withinDistance(0.0D, 3.0D)
/* 395 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 396 */           .addNextBehavior(
/* 397 */             CECombatBehaviors.Behavior.builder()
/* 398 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 399 */             .withinDistance(0.0D, 4.0D)
/* 400 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 401 */             .addNextBehavior(
/* 402 */               CECombatBehaviors.Behavior.builder()
/* 403 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 404 */               .withinDistance(0.0D, 4.0D)
/* 405 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 406 */               .addNextBehavior(
/* 407 */                 CECombatBehaviors.Behavior.builder()
/* 408 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 409 */                 .withinDistance(0.0D, 5.0D)
/* 410 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 411 */                 .addNextBehavior(
/* 412 */                   CECombatBehaviors.Behavior.builder()
/* 413 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 414 */                   .withinDistance(0.0D, 5.0D)
/* 415 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
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
/* 432 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 433 */           .addNextBehavior(
/* 434 */             CECombatBehaviors.Behavior.builder()
/* 435 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 436 */             .withinDistance(0.0D, 4.0D)
/* 437 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 438 */             .addNextBehavior(
/* 439 */               CECombatBehaviors.Behavior.builder()
/* 440 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 441 */               .withinDistance(0.0D, 4.0D)
/* 442 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 443 */               .addNextBehavior(
/* 444 */                 CECombatBehaviors.Behavior.builder()
/* 445 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 446 */                 .withinDistance(0.0D, 5.0D)
/* 447 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 448 */                 .addNextBehavior(
/* 449 */                   CECombatBehaviors.Behavior.builder()
/* 450 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 451 */                   .withinDistance(0.0D, 5.0D)
/* 452 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 460 */       .addFirstBehavior(
/* 461 */         CECombatBehaviors.Behavior.builder()
/* 462 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 463 */         .withinDistance(0.0D, 3.0D)
/* 464 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 465 */         .addNextBehavior(
/* 466 */           CECombatBehaviors.Behavior.builder()
/* 467 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 468 */           .withinDistance(0.0D, 3.0D)
/* 469 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 470 */           .addNextBehavior(
/* 471 */             CECombatBehaviors.Behavior.builder()
/* 472 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 473 */             .withinDistance(0.0D, 4.0D)
/* 474 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 475 */             .addNextBehavior(
/* 476 */               CECombatBehaviors.Behavior.builder()
/* 477 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 478 */               .withinDistance(0.0D, 4.0D)
/* 479 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 480 */               .addNextBehavior(
/* 481 */                 CECombatBehaviors.Behavior.builder()
/* 482 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 483 */                 .withinDistance(0.0D, 5.0D)
/* 484 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 485 */                 .addNextBehavior(
/* 486 */                   CECombatBehaviors.Behavior.builder()
/* 487 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 488 */                   .withinDistance(0.0D, 5.0D)
/* 489 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 497 */       .addFirstBehavior(
/* 498 */         CECombatBehaviors.Behavior.builder()
/* 499 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 500 */         .withinDistance(0.0D, 3.0D)
/* 501 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 502 */         .addNextBehavior(
/* 503 */           CECombatBehaviors.Behavior.builder()
/* 504 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 505 */           .withinDistance(0.0D, 3.0D)
/* 506 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 507 */           .addNextBehavior(
/* 508 */             CECombatBehaviors.Behavior.builder()
/* 509 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 510 */             .withinDistance(0.0D, 4.0D)
/* 511 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 512 */             .addNextBehavior(
/* 513 */               CECombatBehaviors.Behavior.builder()
/* 514 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 515 */               .withinDistance(0.0D, 4.0D)
/* 516 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 517 */               .addNextBehavior(
/* 518 */                 CECombatBehaviors.Behavior.builder()
/* 519 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 520 */                 .withinDistance(0.0D, 5.0D)
/* 521 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 528 */       .addFirstBehavior(
/* 529 */         CECombatBehaviors.Behavior.builder()
/* 530 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 531 */         .withinDistance(0.0D, 3.0D)
/* 532 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 533 */         .addNextBehavior(
/* 534 */           CECombatBehaviors.Behavior.builder()
/* 535 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 536 */           .withinDistance(0.0D, 3.0D)
/* 537 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 538 */           .addNextBehavior(
/* 539 */             CECombatBehaviors.Behavior.builder()
/* 540 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 541 */             .withinDistance(0.0D, 4.0D)
/* 542 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 543 */             .addNextBehavior(
/* 544 */               CECombatBehaviors.Behavior.builder()
/* 545 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 546 */               .withinDistance(0.0D, 4.0D)
/* 547 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 548 */               .addNextBehavior(
/* 549 */                 CECombatBehaviors.Behavior.builder()
/* 550 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 551 */                 .withinDistance(0.0D, 5.0D)
/* 552 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/* 568 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 569 */           .addNextBehavior(
/* 570 */             CECombatBehaviors.Behavior.builder()
/* 571 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 572 */             .withinDistance(0.0D, 4.0D)
/* 573 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 574 */             .addNextBehavior(
/* 575 */               CECombatBehaviors.Behavior.builder()
/* 576 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 577 */               .withinDistance(0.0D, 4.0D)
/* 578 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 579 */               .addNextBehavior(
/* 580 */                 CECombatBehaviors.Behavior.builder()
/* 581 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 582 */                 .withinDistance(0.0D, 5.0D)
/* 583 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/* 594 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 595 */         .addNextBehavior(
/* 596 */           CECombatBehaviors.Behavior.builder()
/* 597 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 598 */           .withinDistance(0.0D, 3.0D)
/* 599 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/* 600 */           .addNextBehavior(
/* 601 */             CECombatBehaviors.Behavior.builder()
/* 602 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 603 */             .withinDistance(0.0D, 4.0D)
/* 604 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 605 */             .addNextBehavior(
/* 606 */               CECombatBehaviors.Behavior.builder()
/* 607 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 608 */               .withinDistance(0.0D, 4.0D)
/* 609 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 610 */               .addNextBehavior(
/* 611 */                 CECombatBehaviors.Behavior.builder()
/* 612 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 613 */                 .withinDistance(0.0D, 5.0D)
/* 614 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 615 */                 .addNextBehavior(
/* 616 */                   CECombatBehaviors.Behavior.builder()
/* 617 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 618 */                   .withinDistance(0.0D, 5.0D)
/* 619 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 627 */       .addFirstBehavior(
/* 628 */         CECombatBehaviors.Behavior.builder()
/* 629 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 630 */         .withinDistance(0.0D, 3.0D)
/* 631 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 632 */         .addNextBehavior(
/* 633 */           CECombatBehaviors.Behavior.builder()
/* 634 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 635 */           .withinDistance(0.0D, 3.0D)
/* 636 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 637 */           .addNextBehavior(
/* 638 */             CECombatBehaviors.Behavior.builder()
/* 639 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 640 */             .withinDistance(0.0D, 4.0D)
/* 641 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 642 */             .addNextBehavior(
/* 643 */               CECombatBehaviors.Behavior.builder()
/* 644 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 645 */               .withinDistance(0.0D, 4.0D)
/* 646 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 647 */               .addNextBehavior(
/* 648 */                 CECombatBehaviors.Behavior.builder()
/* 649 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 650 */                 .withinDistance(0.0D, 5.0D)
/* 651 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 658 */     .newBehaviorRoot(
/* 659 */       CECombatBehaviors.BehaviorRoot.builder()
/* 660 */       .priority(1.0D)
/* 661 */       .weight(20.0D)
/* 662 */       .maxCooldown(100)
/* 663 */       .addFirstBehavior(
/* 664 */         CECombatBehaviors.Behavior.builder()
/* 665 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 666 */         .withinDistance(0.0D, 3.0D)
/* 667 */         .animationBehavior(Animations.VINDICATOR_SWING_AXE2, 0.0F)))
/*     */ 
/*     */     
/* 670 */     .newBehaviorRoot(
/* 671 */       CECombatBehaviors.BehaviorRoot.builder()
/* 672 */       .priority(1.0D)
/* 673 */       .weight(10.0D)
/* 674 */       .maxCooldown(100)
/* 675 */       .addFirstBehavior(
/* 676 */         CECombatBehaviors.Behavior.builder()
/* 677 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 678 */         .withinDistance(0.0D, 3.0D)
/* 679 */         .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F))
/*     */       
/* 681 */       .addFirstBehavior(
/* 682 */         CECombatBehaviors.Behavior.builder()
/* 683 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 684 */         .withinDistance(0.0D, 3.0D)
/* 685 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*     */       
/* 687 */       .addFirstBehavior(
/* 688 */         CECombatBehaviors.Behavior.builder()
/* 689 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 690 */         .withinDistance(0.0D, 3.0D)
/* 691 */         .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)))
/*     */ 
/*     */     
/* 694 */     .newBehaviorRoot(
/* 695 */       CECombatBehaviors.BehaviorRoot.builder()
/* 696 */       .priority(1.0D)
/* 697 */       .weight(10.0D)
/* 698 */       .maxCooldown(40)
/* 699 */       .addFirstBehavior(
/* 700 */         CECombatBehaviors.Behavior.builder()
/* 701 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 702 */         .withinDistance(0.0D, 3.0D)
/* 703 */         .custom(CombatCommon::canThrowEnderPearl)
/* 704 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 705 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 706 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 709 */     .newBehaviorRoot(
/* 710 */       CECombatBehaviors.BehaviorRoot.builder()
/* 711 */       .priority(1.0D)
/* 712 */       .weight(2.0D)
/* 713 */       .maxCooldown(100)
/* 714 */       .addFirstBehavior(
/* 715 */         CECombatBehaviors.Behavior.builder()
/* 716 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 717 */         .withinDistance(0.0D, 3.0D)
/* 718 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 720 */       .addFirstBehavior(
/* 721 */         CECombatBehaviors.Behavior.builder()
/* 722 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 723 */         .withinDistance(0.0D, 3.0D)
/* 724 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 726 */       .addFirstBehavior(
/* 727 */         CECombatBehaviors.Behavior.builder()
/* 728 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 729 */         .withinDistance(0.0D, 3.0D)
/* 730 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 732 */       .addFirstBehavior(
/* 733 */         CECombatBehaviors.Behavior.builder()
/* 734 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 735 */         .withinDistance(0.0D, 3.0D)
/* 736 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 738 */       .addFirstBehavior(
/* 739 */         CECombatBehaviors.Behavior.builder()
/* 740 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 741 */         .withinDistance(0.0D, 3.0D)
/* 742 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 744 */       .addFirstBehavior(
/* 745 */         CECombatBehaviors.Behavior.builder()
/* 746 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 747 */         .withinDistance(0.0D, 3.0D)
/* 748 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 750 */       .addFirstBehavior(
/* 751 */         CECombatBehaviors.Behavior.builder()
/* 752 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 753 */         .withinDistance(0.0D, 3.0D)
/* 754 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 757 */     .newBehaviorRoot(
/* 758 */       CECombatBehaviors.BehaviorRoot.builder()
/* 759 */       .priority(1.0D)
/* 760 */       .weight(15.0D)
/* 761 */       .addFirstBehavior(
/* 762 */         CECombatBehaviors.Behavior.builder()
/* 763 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 764 */         .withinDistance(0.0D, 3.0D)
/* 765 */         .custom(CombatCommon::canPerformGuarding)
/* 766 */         .guard(40)))
/*     */ 
/*     */     
/* 769 */     .newBehaviorRoot(
/* 770 */       CECombatBehaviors.BehaviorRoot.builder()
/* 771 */       .priority(1.0D)
/* 772 */       .weight(10.0D)
/* 773 */       .addFirstBehavior(
/* 774 */         CECombatBehaviors.Behavior.builder()
/* 775 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 776 */         .withinDistance(0.0D, 3.0D)
/* 777 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 779 */       .addFirstBehavior(
/* 780 */         CECombatBehaviors.Behavior.builder()
/* 781 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 782 */         .withinDistance(0.0D, 3.0D)
/* 783 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))
/*     */ 
/*     */     
/* 786 */     .newBehaviorRoot(
/* 787 */       CECombatBehaviors.BehaviorRoot.builder()
/* 788 */       .priority(1.0D)
/* 789 */       .weight(40.0D)
/* 790 */       .maxCooldown(160)
/* 791 */       .addFirstBehavior(
/* 792 */         CECombatBehaviors.Behavior.builder()
/* 793 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 794 */         .custom(CombatCommon::canJump)
/* 795 */         .withinDistance(5.0D, 14.0D)
/* 796 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 797 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcTrapdoor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */