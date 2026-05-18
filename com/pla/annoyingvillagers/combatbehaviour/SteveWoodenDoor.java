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
/*     */ public class SteveWoodenDoor
/*     */ {
/*  15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> WOODEN_DOOR = CECombatBehaviors.builder()
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
/* 126 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 127 */         .addNextBehavior(
/* 128 */           CECombatBehaviors.Behavior.builder()
/* 129 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 130 */           .withinDistance(0.0D, 3.0D)
/* 131 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 132 */           .addNextBehavior(
/* 133 */             CECombatBehaviors.Behavior.builder()
/* 134 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */             .withinDistance(0.0D, 3.0D)
/* 136 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 137 */             .addNextBehavior(
/* 138 */               CECombatBehaviors.Behavior.builder()
/* 139 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 140 */               .withinDistance(0.0D, 3.0D)
/* 141 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       .addFirstBehavior(
/* 147 */         CECombatBehaviors.Behavior.builder()
/* 148 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 149 */         .withinDistance(0.0D, 3.0D)
/* 150 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 151 */         .addNextBehavior(
/* 152 */           CECombatBehaviors.Behavior.builder()
/* 153 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 154 */           .withinDistance(0.0D, 3.0D)
/* 155 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 156 */           .addNextBehavior(
/* 157 */             CECombatBehaviors.Behavior.builder()
/* 158 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 159 */             .withinDistance(0.0D, 4.0D)
/* 160 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 161 */             .addNextBehavior(
/* 162 */               CECombatBehaviors.Behavior.builder()
/* 163 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 164 */               .withinDistance(0.0D, 4.0D)
/* 165 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 166 */               .addNextBehavior(
/* 167 */                 CECombatBehaviors.Behavior.builder()
/* 168 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 169 */                 .withinDistance(0.0D, 5.0D)
/* 170 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       .addFirstBehavior(
/* 178 */         CECombatBehaviors.Behavior.builder()
/* 179 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 180 */         .withinDistance(0.0D, 3.0D)
/* 181 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 182 */         .addNextBehavior(
/* 183 */           CECombatBehaviors.Behavior.builder()
/* 184 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 185 */           .withinDistance(0.0D, 3.0D)
/* 186 */           .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 187 */           .addNextBehavior(
/* 188 */             CECombatBehaviors.Behavior.builder()
/* 189 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 190 */             .withinDistance(0.0D, 4.0D)
/* 191 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 192 */             .addNextBehavior(
/* 193 */               CECombatBehaviors.Behavior.builder()
/* 194 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 195 */               .withinDistance(0.0D, 4.0D)
/* 196 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 197 */               .addNextBehavior(
/* 198 */                 CECombatBehaviors.Behavior.builder()
/* 199 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 200 */                 .withinDistance(0.0D, 5.0D)
/* 201 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 208 */       .addFirstBehavior(
/* 209 */         CECombatBehaviors.Behavior.builder()
/* 210 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 211 */         .withinDistance(0.0D, 3.0D)
/* 212 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 213 */         .addNextBehavior(
/* 214 */           CECombatBehaviors.Behavior.builder()
/* 215 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 216 */           .withinDistance(0.0D, 3.0D)
/* 217 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 218 */           .addNextBehavior(
/* 219 */             CECombatBehaviors.Behavior.builder()
/* 220 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 221 */             .withinDistance(0.0D, 4.0D)
/* 222 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 223 */             .addNextBehavior(
/* 224 */               CECombatBehaviors.Behavior.builder()
/* 225 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 226 */               .withinDistance(0.0D, 4.0D)
/* 227 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 228 */               .addNextBehavior(
/* 229 */                 CECombatBehaviors.Behavior.builder()
/* 230 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 231 */                 .withinDistance(0.0D, 5.0D)
/* 232 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 233 */                 .addNextBehavior(
/* 234 */                   CECombatBehaviors.Behavior.builder()
/* 235 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 236 */                   .withinDistance(0.0D, 5.0D)
/* 237 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 245 */       .addFirstBehavior(
/* 246 */         CECombatBehaviors.Behavior.builder()
/* 247 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 248 */         .withinDistance(0.0D, 3.0D)
/* 249 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 250 */         .addNextBehavior(
/* 251 */           CECombatBehaviors.Behavior.builder()
/* 252 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 253 */           .withinDistance(0.0D, 3.0D)
/* 254 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 255 */           .addNextBehavior(
/* 256 */             CECombatBehaviors.Behavior.builder()
/* 257 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 258 */             .withinDistance(0.0D, 4.0D)
/* 259 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 260 */             .addNextBehavior(
/* 261 */               CECombatBehaviors.Behavior.builder()
/* 262 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 263 */               .withinDistance(0.0D, 4.0D)
/* 264 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 265 */               .addNextBehavior(
/* 266 */                 CECombatBehaviors.Behavior.builder()
/* 267 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 268 */                 .withinDistance(0.0D, 5.0D)
/* 269 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 270 */                 .addNextBehavior(
/* 271 */                   CECombatBehaviors.Behavior.builder()
/* 272 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 273 */                   .withinDistance(0.0D, 5.0D)
/* 274 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 282 */       .addFirstBehavior(
/* 283 */         CECombatBehaviors.Behavior.builder()
/* 284 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 285 */         .withinDistance(0.0D, 3.0D)
/* 286 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 287 */         .addNextBehavior(
/* 288 */           CECombatBehaviors.Behavior.builder()
/* 289 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 290 */           .withinDistance(0.0D, 3.0D)
/* 291 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 292 */           .addNextBehavior(
/* 293 */             CECombatBehaviors.Behavior.builder()
/* 294 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 295 */             .withinDistance(0.0D, 4.0D)
/* 296 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 297 */             .addNextBehavior(
/* 298 */               CECombatBehaviors.Behavior.builder()
/* 299 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 300 */               .withinDistance(0.0D, 4.0D)
/* 301 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 302 */               .addNextBehavior(
/* 303 */                 CECombatBehaviors.Behavior.builder()
/* 304 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 305 */                 .withinDistance(0.0D, 5.0D)
/* 306 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 313 */       .addFirstBehavior(
/* 314 */         CECombatBehaviors.Behavior.builder()
/* 315 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 316 */         .withinDistance(0.0D, 3.0D)
/* 317 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 318 */         .addNextBehavior(
/* 319 */           CECombatBehaviors.Behavior.builder()
/* 320 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 321 */           .withinDistance(0.0D, 3.0D)
/* 322 */           .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 323 */           .addNextBehavior(
/* 324 */             CECombatBehaviors.Behavior.builder()
/* 325 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 326 */             .withinDistance(0.0D, 4.0D)
/* 327 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 328 */             .addNextBehavior(
/* 329 */               CECombatBehaviors.Behavior.builder()
/* 330 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 331 */               .withinDistance(0.0D, 4.0D)
/* 332 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 333 */               .addNextBehavior(
/* 334 */                 CECombatBehaviors.Behavior.builder()
/* 335 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 336 */                 .withinDistance(0.0D, 5.0D)
/* 337 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 338 */                 .addNextBehavior(
/* 339 */                   CECombatBehaviors.Behavior.builder()
/* 340 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 341 */                   .withinDistance(0.0D, 5.0D)
/* 342 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 343 */                   .addNextBehavior(
/* 344 */                     CECombatBehaviors.Behavior.builder()
/* 345 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 346 */                     .withinDistance(0.0D, 5.0D)
/* 347 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 356 */       .addFirstBehavior(
/* 357 */         CECombatBehaviors.Behavior.builder()
/* 358 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 359 */         .withinDistance(0.0D, 3.0D)
/* 360 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 361 */         .addNextBehavior(
/* 362 */           CECombatBehaviors.Behavior.builder()
/* 363 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 364 */           .withinDistance(0.0D, 3.0D)
/* 365 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 366 */           .addNextBehavior(
/* 367 */             CECombatBehaviors.Behavior.builder()
/* 368 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 369 */             .withinDistance(0.0D, 4.0D)
/* 370 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 371 */             .addNextBehavior(
/* 372 */               CECombatBehaviors.Behavior.builder()
/* 373 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 374 */               .withinDistance(0.0D, 4.0D)
/* 375 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 376 */               .addNextBehavior(
/* 377 */                 CECombatBehaviors.Behavior.builder()
/* 378 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 379 */                 .withinDistance(0.0D, 5.0D)
/* 380 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 381 */                 .addNextBehavior(
/* 382 */                   CECombatBehaviors.Behavior.builder()
/* 383 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 384 */                   .withinDistance(0.0D, 5.0D)
/* 385 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 393 */       .addFirstBehavior(
/* 394 */         CECombatBehaviors.Behavior.builder()
/* 395 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 396 */         .withinDistance(0.0D, 3.0D)
/* 397 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 398 */         .addNextBehavior(
/* 399 */           CECombatBehaviors.Behavior.builder()
/* 400 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 401 */           .withinDistance(0.0D, 3.0D)
/* 402 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 403 */           .addNextBehavior(
/* 404 */             CECombatBehaviors.Behavior.builder()
/* 405 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 406 */             .withinDistance(0.0D, 4.0D)
/* 407 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 408 */             .addNextBehavior(
/* 409 */               CECombatBehaviors.Behavior.builder()
/* 410 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 411 */               .withinDistance(0.0D, 4.0D)
/* 412 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 413 */               .addNextBehavior(
/* 414 */                 CECombatBehaviors.Behavior.builder()
/* 415 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 416 */                 .withinDistance(0.0D, 5.0D)
/* 417 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 424 */       .addFirstBehavior(
/* 425 */         CECombatBehaviors.Behavior.builder()
/* 426 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 427 */         .withinDistance(0.0D, 3.0D)
/* 428 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 429 */         .addNextBehavior(
/* 430 */           CECombatBehaviors.Behavior.builder()
/* 431 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 432 */           .withinDistance(0.0D, 3.0D)
/* 433 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 434 */           .addNextBehavior(
/* 435 */             CECombatBehaviors.Behavior.builder()
/* 436 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 437 */             .withinDistance(0.0D, 4.0D)
/* 438 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 439 */             .addNextBehavior(
/* 440 */               CECombatBehaviors.Behavior.builder()
/* 441 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 442 */               .withinDistance(0.0D, 4.0D)
/* 443 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 444 */               .addNextBehavior(
/* 445 */                 CECombatBehaviors.Behavior.builder()
/* 446 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 447 */                 .withinDistance(0.0D, 5.0D)
/* 448 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 449 */                 .addNextBehavior(
/* 450 */                   CECombatBehaviors.Behavior.builder()
/* 451 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 452 */                   .withinDistance(0.0D, 5.0D)
/* 453 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 461 */       .addFirstBehavior(
/* 462 */         CECombatBehaviors.Behavior.builder()
/* 463 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 464 */         .withinDistance(0.0D, 3.0D)
/* 465 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 466 */         .addNextBehavior(
/* 467 */           CECombatBehaviors.Behavior.builder()
/* 468 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 469 */           .withinDistance(0.0D, 3.0D)
/* 470 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 471 */           .addNextBehavior(
/* 472 */             CECombatBehaviors.Behavior.builder()
/* 473 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 474 */             .withinDistance(0.0D, 4.0D)
/* 475 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 476 */             .addNextBehavior(
/* 477 */               CECombatBehaviors.Behavior.builder()
/* 478 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 479 */               .withinDistance(0.0D, 4.0D)
/* 480 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 481 */               .addNextBehavior(
/* 482 */                 CECombatBehaviors.Behavior.builder()
/* 483 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 484 */                 .withinDistance(0.0D, 5.0D)
/* 485 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 486 */                 .addNextBehavior(
/* 487 */                   CECombatBehaviors.Behavior.builder()
/* 488 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 489 */                   .withinDistance(0.0D, 5.0D)
/* 490 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 491 */                   .addNextBehavior(
/* 492 */                     CECombatBehaviors.Behavior.builder()
/* 493 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 494 */                     .withinDistance(0.0D, 5.0D)
/* 495 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
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
/* 508 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 509 */         .addNextBehavior(
/* 510 */           CECombatBehaviors.Behavior.builder()
/* 511 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 512 */           .withinDistance(0.0D, 3.0D)
/* 513 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 514 */           .addNextBehavior(
/* 515 */             CECombatBehaviors.Behavior.builder()
/* 516 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 517 */             .withinDistance(0.0D, 4.0D)
/* 518 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 519 */             .addNextBehavior(
/* 520 */               CECombatBehaviors.Behavior.builder()
/* 521 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 522 */               .withinDistance(0.0D, 4.0D)
/* 523 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 524 */               .addNextBehavior(
/* 525 */                 CECombatBehaviors.Behavior.builder()
/* 526 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 527 */                 .withinDistance(0.0D, 5.0D)
/* 528 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/* 539 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 540 */         .addNextBehavior(
/* 541 */           CECombatBehaviors.Behavior.builder()
/* 542 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 543 */           .withinDistance(0.0D, 3.0D)
/* 544 */           .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 545 */           .addNextBehavior(
/* 546 */             CECombatBehaviors.Behavior.builder()
/* 547 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 548 */             .withinDistance(0.0D, 4.0D)
/* 549 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 550 */             .addNextBehavior(
/* 551 */               CECombatBehaviors.Behavior.builder()
/* 552 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 553 */               .withinDistance(0.0D, 4.0D)
/* 554 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 555 */               .addNextBehavior(
/* 556 */                 CECombatBehaviors.Behavior.builder()
/* 557 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 558 */                 .withinDistance(0.0D, 5.0D)
/* 559 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 560 */                 .addNextBehavior(
/* 561 */                   CECombatBehaviors.Behavior.builder()
/* 562 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 563 */                   .withinDistance(0.0D, 5.0D)
/* 564 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 572 */       .addFirstBehavior(
/* 573 */         CECombatBehaviors.Behavior.builder()
/* 574 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 575 */         .withinDistance(0.0D, 3.0D)
/* 576 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 577 */         .addNextBehavior(
/* 578 */           CECombatBehaviors.Behavior.builder()
/* 579 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 580 */           .withinDistance(0.0D, 3.0D)
/* 581 */           .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 582 */           .addNextBehavior(
/* 583 */             CECombatBehaviors.Behavior.builder()
/* 584 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 585 */             .withinDistance(0.0D, 4.0D)
/* 586 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 587 */             .addNextBehavior(
/* 588 */               CECombatBehaviors.Behavior.builder()
/* 589 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 590 */               .withinDistance(0.0D, 4.0D)
/* 591 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 592 */               .addNextBehavior(
/* 593 */                 CECombatBehaviors.Behavior.builder()
/* 594 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 595 */                 .withinDistance(0.0D, 5.0D)
/* 596 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 597 */                 .addNextBehavior(
/* 598 */                   CECombatBehaviors.Behavior.builder()
/* 599 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 600 */                   .withinDistance(0.0D, 5.0D)
/* 601 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
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
/* 613 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 614 */         .addNextBehavior(
/* 615 */           CECombatBehaviors.Behavior.builder()
/* 616 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 617 */           .withinDistance(0.0D, 3.0D)
/* 618 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 619 */           .addNextBehavior(
/* 620 */             CECombatBehaviors.Behavior.builder()
/* 621 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 622 */             .withinDistance(0.0D, 4.0D)
/* 623 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 624 */             .addNextBehavior(
/* 625 */               CECombatBehaviors.Behavior.builder()
/* 626 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 627 */               .withinDistance(0.0D, 4.0D)
/* 628 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 629 */               .addNextBehavior(
/* 630 */                 CECombatBehaviors.Behavior.builder()
/* 631 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 632 */                 .withinDistance(0.0D, 5.0D)
/* 633 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 634 */                 .addNextBehavior(
/* 635 */                   CECombatBehaviors.Behavior.builder()
/* 636 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 637 */                   .withinDistance(0.0D, 5.0D)
/* 638 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 639 */                   .addNextBehavior(
/* 640 */                     CECombatBehaviors.Behavior.builder()
/* 641 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 642 */                     .withinDistance(0.0D, 5.0D)
/* 643 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 652 */       .addFirstBehavior(
/* 653 */         CECombatBehaviors.Behavior.builder()
/* 654 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 655 */         .withinDistance(0.0D, 3.0D)
/* 656 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 657 */         .addNextBehavior(
/* 658 */           CECombatBehaviors.Behavior.builder()
/* 659 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 660 */           .withinDistance(0.0D, 3.0D)
/* 661 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 662 */           .addNextBehavior(
/* 663 */             CECombatBehaviors.Behavior.builder()
/* 664 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 665 */             .withinDistance(0.0D, 4.0D)
/* 666 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 667 */             .addNextBehavior(
/* 668 */               CECombatBehaviors.Behavior.builder()
/* 669 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 670 */               .withinDistance(0.0D, 4.0D)
/* 671 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 672 */               .addNextBehavior(
/* 673 */                 CECombatBehaviors.Behavior.builder()
/* 674 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 675 */                 .withinDistance(0.0D, 5.0D)
/* 676 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 677 */                 .addNextBehavior(
/* 678 */                   CECombatBehaviors.Behavior.builder()
/* 679 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 680 */                   .withinDistance(0.0D, 5.0D)
/* 681 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 690 */     .newBehaviorRoot(
/* 691 */       CECombatBehaviors.BehaviorRoot.builder()
/* 692 */       .priority(1.0D)
/* 693 */       .weight(20.0D)
/* 694 */       .maxCooldown(100)
/* 695 */       .addFirstBehavior(
/* 696 */         CECombatBehaviors.Behavior.builder()
/* 697 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 698 */         .withinDistance(0.0D, 3.0D)
/* 699 */         .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F)))
/*     */ 
/*     */     
/* 702 */     .newBehaviorRoot(
/* 703 */       CECombatBehaviors.BehaviorRoot.builder()
/* 704 */       .priority(1.0D)
/* 705 */       .weight(10.0D)
/* 706 */       .maxCooldown(100)
/* 707 */       .addFirstBehavior(
/* 708 */         CECombatBehaviors.Behavior.builder()
/* 709 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 710 */         .withinDistance(0.0D, 3.0D)
/* 711 */         .animationBehavior(Animations.GREATSWORD_DASH, 0.0F))
/*     */       
/* 713 */       .addFirstBehavior(
/* 714 */         CECombatBehaviors.Behavior.builder()
/* 715 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 716 */         .withinDistance(0.0D, 3.0D)
/* 717 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F))
/*     */       
/* 719 */       .addFirstBehavior(
/* 720 */         CECombatBehaviors.Behavior.builder()
/* 721 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 722 */         .withinDistance(0.0D, 3.0D)
/* 723 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)))
/*     */ 
/*     */     
/* 726 */     .newBehaviorRoot(
/* 727 */       CECombatBehaviors.BehaviorRoot.builder()
/* 728 */       .priority(1.0D)
/* 729 */       .weight(10.0D)
/* 730 */       .maxCooldown(40)
/* 731 */       .addFirstBehavior(
/* 732 */         CECombatBehaviors.Behavior.builder()
/* 733 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 734 */         .withinDistance(0.0D, 3.0D)
/* 735 */         .custom(CombatCommon::canThrowEnderPearl)
/* 736 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 737 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 738 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 741 */     .newBehaviorRoot(
/* 742 */       CECombatBehaviors.BehaviorRoot.builder()
/* 743 */       .priority(1.0D)
/* 744 */       .weight(2.0D)
/* 745 */       .maxCooldown(100)
/* 746 */       .addFirstBehavior(
/* 747 */         CECombatBehaviors.Behavior.builder()
/* 748 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 749 */         .withinDistance(0.0D, 3.0D)
/* 750 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 752 */       .addFirstBehavior(
/* 753 */         CECombatBehaviors.Behavior.builder()
/* 754 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 755 */         .withinDistance(0.0D, 3.0D)
/* 756 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 758 */       .addFirstBehavior(
/* 759 */         CECombatBehaviors.Behavior.builder()
/* 760 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 761 */         .withinDistance(0.0D, 3.0D)
/* 762 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 764 */       .addFirstBehavior(
/* 765 */         CECombatBehaviors.Behavior.builder()
/* 766 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 767 */         .withinDistance(0.0D, 3.0D)
/* 768 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 770 */       .addFirstBehavior(
/* 771 */         CECombatBehaviors.Behavior.builder()
/* 772 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 773 */         .withinDistance(0.0D, 3.0D)
/* 774 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 776 */       .addFirstBehavior(
/* 777 */         CECombatBehaviors.Behavior.builder()
/* 778 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 779 */         .withinDistance(0.0D, 3.0D)
/* 780 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 782 */       .addFirstBehavior(
/* 783 */         CECombatBehaviors.Behavior.builder()
/* 784 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 785 */         .withinDistance(0.0D, 3.0D)
/* 786 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 789 */     .newBehaviorRoot(
/* 790 */       CECombatBehaviors.BehaviorRoot.builder()
/* 791 */       .priority(1.0D)
/* 792 */       .weight(15.0D)
/* 793 */       .addFirstBehavior(
/* 794 */         CECombatBehaviors.Behavior.builder()
/* 795 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 796 */         .withinDistance(0.0D, 3.0D)
/* 797 */         .custom(CombatCommon::canPerformGuarding)
/* 798 */         .guard(40)))
/*     */ 
/*     */     
/* 801 */     .newBehaviorRoot(
/* 802 */       CECombatBehaviors.BehaviorRoot.builder()
/* 803 */       .priority(1.0D)
/* 804 */       .weight(10.0D)
/* 805 */       .addFirstBehavior(
/* 806 */         CECombatBehaviors.Behavior.builder()
/* 807 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 808 */         .withinDistance(0.0D, 3.0D)
/* 809 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 811 */       .addFirstBehavior(
/* 812 */         CECombatBehaviors.Behavior.builder()
/* 813 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 814 */         .withinDistance(0.0D, 3.0D)
/* 815 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))
/*     */ 
/*     */     
/* 818 */     .newBehaviorRoot(
/* 819 */       CECombatBehaviors.BehaviorRoot.builder()
/* 820 */       .priority(1.0D)
/* 821 */       .weight(40.0D)
/* 822 */       .maxCooldown(160)
/* 823 */       .addFirstBehavior(
/* 824 */         CECombatBehaviors.Behavior.builder()
/* 825 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 826 */         .custom(CombatCommon::canJump)
/* 827 */         .withinDistance(5.0D, 14.0D)
/* 828 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 829 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveWoodenDoor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */