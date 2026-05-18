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
/*     */ public class PlayerNpcUchigatana
/*     */ {
/*  14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> UCHIGATANA = CECombatBehaviors.builder()
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
/*  49 */       .priority(2.0D)
/*  50 */       .weight(70.0D)
/*  51 */       .maxCooldown(0)
/*  52 */       .addFirstBehavior(
/*  53 */         CECombatBehaviors.Behavior.builder()
/*  54 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  55 */         .custom(CombatCommon::canPerformEating)
/*  56 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  57 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  60 */     .newBehaviorRoot(
/*  61 */       CECombatBehaviors.BehaviorRoot.builder()
/*  62 */       .priority(2.0D)
/*  63 */       .weight(100.0D)
/*  64 */       .maxCooldown(120)
/*  65 */       .addFirstBehavior(
/*  66 */         CECombatBehaviors.Behavior.builder()
/*  67 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  68 */         .custom(CombatCommon::canSwapToBow)
/*  69 */         .withinDistance(7.0D, 14.0D)
/*  70 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  71 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  73 */       .addFirstBehavior(
/*  74 */         CECombatBehaviors.Behavior.builder()
/*  75 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  76 */         .custom(CombatCommon::canSwapToBow)
/*  77 */         .withinDistance(7.0D, 14.0D)
/*  78 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  79 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/*  82 */     .newBehaviorRoot(
/*  83 */       CECombatBehaviors.BehaviorRoot.builder()
/*  84 */       .priority(2.0D)
/*  85 */       .weight(80.0D)
/*  86 */       .maxCooldown(120)
/*  87 */       .addFirstBehavior(
/*  88 */         CECombatBehaviors.Behavior.builder()
/*  89 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  90 */         .custom(CombatCommon::canThrowEnderPearl)
/*  91 */         .withinDistance(7.0D, 48.0D)
/*  92 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  93 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/*  96 */     .newBehaviorRoot(
/*  97 */       CECombatBehaviors.BehaviorRoot.builder()
/*  98 */       .priority(1.0D)
/*  99 */       .weight(40.0D)
/* 100 */       .maxCooldown(20)
/* 101 */       .addFirstBehavior(
/* 102 */         CECombatBehaviors.Behavior.builder()
/* 103 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 104 */         .withinDistance(0.0D, 3.0D)
/* 105 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 106 */         .addNextBehavior(
/* 107 */           CECombatBehaviors.Behavior.builder()
/* 108 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 109 */           .withinDistance(0.0D, 3.0D)
/* 110 */           .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 111 */           .addNextBehavior(
/* 112 */             CECombatBehaviors.Behavior.builder()
/* 113 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 114 */             .withinDistance(0.0D, 3.0D)
/* 115 */             .animationBehavior(Animations.UCHIGATANA_AUTO3, 0.0F))))
/*     */ 
/*     */ 
/*     */       
/* 119 */       .addFirstBehavior(
/* 120 */         CECombatBehaviors.Behavior.builder()
/* 121 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 122 */         .withinDistance(0.0D, 3.0D)
/* 123 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 124 */         .addNextBehavior(
/* 125 */           CECombatBehaviors.Behavior.builder()
/* 126 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 127 */           .withinDistance(0.0D, 3.0D)
/* 128 */           .animationBehavior(Animations.UCHIGATANA_DASH, 0.0F)
/* 129 */           .addNextBehavior(
/* 130 */             CECombatBehaviors.Behavior.builder()
/* 131 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 132 */             .withinDistance(0.0D, 4.0D)
/* 133 */             .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 134 */             .addNextBehavior(
/* 135 */               CECombatBehaviors.Behavior.builder()
/* 136 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 137 */               .withinDistance(0.0D, 4.0D)
/* 138 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 139 */               .addNextBehavior(
/* 140 */                 CECombatBehaviors.Behavior.builder()
/* 141 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 142 */                 .withinDistance(0.0D, 5.0D)
/* 143 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 144 */                 .addNextBehavior(
/* 145 */                   CECombatBehaviors.Behavior.builder()
/* 146 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 147 */                   .withinDistance(0.0D, 5.0D)
/* 148 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 156 */       .addFirstBehavior(
/* 157 */         CECombatBehaviors.Behavior.builder()
/* 158 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 159 */         .withinDistance(0.0D, 3.0D)
/* 160 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 161 */         .addNextBehavior(
/* 162 */           CECombatBehaviors.Behavior.builder()
/* 163 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 164 */           .withinDistance(0.0D, 3.0D)
/* 165 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 166 */           .addNextBehavior(
/* 167 */             CECombatBehaviors.Behavior.builder()
/* 168 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 169 */             .withinDistance(0.0D, 4.0D)
/* 170 */             .animationBehavior(Animations.UCHIGATANA_SHEATHING_AUTO, 0.0F)
/* 171 */             .addNextBehavior(
/* 172 */               CECombatBehaviors.Behavior.builder()
/* 173 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 174 */               .withinDistance(0.0D, 4.0D)
/* 175 */               .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 176 */               .addNextBehavior(
/* 177 */                 CECombatBehaviors.Behavior.builder()
/* 178 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 179 */                 .withinDistance(0.0D, 5.0D)
/* 180 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 181 */                 .addNextBehavior(
/* 182 */                   CECombatBehaviors.Behavior.builder()
/* 183 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 184 */                   .withinDistance(0.0D, 5.0D)
/* 185 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       .addFirstBehavior(
/* 194 */         CECombatBehaviors.Behavior.builder()
/* 195 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 196 */         .withinDistance(0.0D, 3.0D)
/* 197 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 198 */         .addNextBehavior(
/* 199 */           CECombatBehaviors.Behavior.builder()
/* 200 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 201 */           .withinDistance(0.0D, 3.0D)
/* 202 */           .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/* 203 */           .addNextBehavior(
/* 204 */             CECombatBehaviors.Behavior.builder()
/* 205 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 206 */             .withinDistance(0.0D, 4.0D)
/* 207 */             .animationBehavior(Animations.BATTOJUTSU_DASH, 0.0F)
/* 208 */             .addNextBehavior(
/* 209 */               CECombatBehaviors.Behavior.builder()
/* 210 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 211 */               .withinDistance(0.0D, 4.0D)
/* 212 */               .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 213 */               .addNextBehavior(
/* 214 */                 CECombatBehaviors.Behavior.builder()
/* 215 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 216 */                 .withinDistance(0.0D, 5.0D)
/* 217 */                 .animationBehavior(Animations.UCHIGATANA_AIR_SLASH, 0.0F)
/* 218 */                 .addNextBehavior(
/* 219 */                   CECombatBehaviors.Behavior.builder()
/* 220 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 221 */                   .withinDistance(0.0D, 5.0D)
/* 222 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 223 */                   .addNextBehavior(
/* 224 */                     CECombatBehaviors.Behavior.builder()
/* 225 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 226 */                     .withinDistance(0.0D, 5.0D)
/* 227 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 236 */       .addFirstBehavior(
/* 237 */         CECombatBehaviors.Behavior.builder()
/* 238 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 239 */         .withinDistance(0.0D, 3.0D)
/* 240 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 241 */         .addNextBehavior(
/* 242 */           CECombatBehaviors.Behavior.builder()
/* 243 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 244 */           .withinDistance(0.0D, 3.0D)
/* 245 */           .animationBehavior(Animations.UCHIGATANA_SHEATHING_DASH, 0.0F)
/* 246 */           .addNextBehavior(
/* 247 */             CECombatBehaviors.Behavior.builder()
/* 248 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 249 */             .withinDistance(0.0D, 4.0D)
/* 250 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 251 */             .addNextBehavior(
/* 252 */               CECombatBehaviors.Behavior.builder()
/* 253 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 254 */               .withinDistance(0.0D, 4.0D)
/* 255 */               .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 256 */               .addNextBehavior(
/* 257 */                 CECombatBehaviors.Behavior.builder()
/* 258 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 259 */                 .withinDistance(0.0D, 5.0D)
/* 260 */                 .animationBehavior(Animations.UCHIGATANA_AUTO3, 0.0F)
/* 261 */                 .addNextBehavior(
/* 262 */                   CECombatBehaviors.Behavior.builder()
/* 263 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 264 */                   .withinDistance(0.0D, 5.0D)
/* 265 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 266 */                   .addNextBehavior(
/* 267 */                     CECombatBehaviors.Behavior.builder()
/* 268 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 269 */                     .withinDistance(0.0D, 5.0D)
/* 270 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 279 */       .addFirstBehavior(
/* 280 */         CECombatBehaviors.Behavior.builder()
/* 281 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 282 */         .withinDistance(0.0D, 3.0D)
/* 283 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 284 */         .addNextBehavior(
/* 285 */           CECombatBehaviors.Behavior.builder()
/* 286 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 287 */           .withinDistance(0.0D, 3.0D)
/* 288 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 289 */           .addNextBehavior(
/* 290 */             CECombatBehaviors.Behavior.builder()
/* 291 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 292 */             .withinDistance(0.0D, 4.0D)
/* 293 */             .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 294 */             .addNextBehavior(
/* 295 */               CECombatBehaviors.Behavior.builder()
/* 296 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 297 */               .withinDistance(0.0D, 4.0D)
/* 298 */               .animationBehavior(Animations.UCHIGATANA_DASH, 0.0F)
/* 299 */               .addNextBehavior(
/* 300 */                 CECombatBehaviors.Behavior.builder()
/* 301 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 302 */                 .withinDistance(0.0D, 5.0D)
/* 303 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 304 */                 .addNextBehavior(
/* 305 */                   CECombatBehaviors.Behavior.builder()
/* 306 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 307 */                   .withinDistance(0.0D, 5.0D)
/* 308 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 316 */       .addFirstBehavior(
/* 317 */         CECombatBehaviors.Behavior.builder()
/* 318 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 319 */         .withinDistance(0.0D, 3.0D)
/* 320 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 321 */         .addNextBehavior(
/* 322 */           CECombatBehaviors.Behavior.builder()
/* 323 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 324 */           .withinDistance(0.0D, 3.0D)
/* 325 */           .animationBehavior(Animations.UCHIGATANA_SHEATHING_AUTO, 0.0F)
/* 326 */           .addNextBehavior(
/* 327 */             CECombatBehaviors.Behavior.builder()
/* 328 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 329 */             .withinDistance(0.0D, 4.0D)
/* 330 */             .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 331 */             .addNextBehavior(
/* 332 */               CECombatBehaviors.Behavior.builder()
/* 333 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 334 */               .withinDistance(0.0D, 4.0D)
/* 335 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 336 */               .addNextBehavior(
/* 337 */                 CECombatBehaviors.Behavior.builder()
/* 338 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 339 */                 .withinDistance(0.0D, 5.0D)
/* 340 */                 .animationBehavior(Animations.UCHIGATANA_AIR_SLASH, 0.0F)
/* 341 */                 .addNextBehavior(
/* 342 */                   CECombatBehaviors.Behavior.builder()
/* 343 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 344 */                   .withinDistance(0.0D, 5.0D)
/* 345 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 346 */                   .addNextBehavior(
/* 347 */                     CECombatBehaviors.Behavior.builder()
/* 348 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 349 */                     .withinDistance(0.0D, 5.0D)
/* 350 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 359 */       .addFirstBehavior(
/* 360 */         CECombatBehaviors.Behavior.builder()
/* 361 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 362 */         .withinDistance(0.0D, 3.0D)
/* 363 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 364 */         .addNextBehavior(
/* 365 */           CECombatBehaviors.Behavior.builder()
/* 366 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 367 */           .withinDistance(0.0D, 3.0D)
/* 368 */           .animationBehavior(Animations.UCHIGATANA_DASH, 0.0F)
/* 369 */           .addNextBehavior(
/* 370 */             CECombatBehaviors.Behavior.builder()
/* 371 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 372 */             .withinDistance(0.0D, 4.0D)
/* 373 */             .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 374 */             .addNextBehavior(
/* 375 */               CECombatBehaviors.Behavior.builder()
/* 376 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 377 */               .withinDistance(0.0D, 4.0D)
/* 378 */               .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/* 379 */               .addNextBehavior(
/* 380 */                 CECombatBehaviors.Behavior.builder()
/* 381 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 382 */                 .withinDistance(0.0D, 5.0D)
/* 383 */                 .animationBehavior(Animations.BATTOJUTSU_DASH, 0.0F)
/* 384 */                 .addNextBehavior(
/* 385 */                   CECombatBehaviors.Behavior.builder()
/* 386 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 387 */                   .withinDistance(0.0D, 5.0D)
/* 388 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 389 */                   .addNextBehavior(
/* 390 */                     CECombatBehaviors.Behavior.builder()
/* 391 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 392 */                     .withinDistance(0.0D, 5.0D)
/* 393 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 402 */       .addFirstBehavior(
/* 403 */         CECombatBehaviors.Behavior.builder()
/* 404 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 405 */         .withinDistance(0.0D, 3.0D)
/* 406 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 407 */         .addNextBehavior(
/* 408 */           CECombatBehaviors.Behavior.builder()
/* 409 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 410 */           .withinDistance(0.0D, 3.0D)
/* 411 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 412 */           .addNextBehavior(
/* 413 */             CECombatBehaviors.Behavior.builder()
/* 414 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 415 */             .withinDistance(0.0D, 4.0D)
/* 416 */             .animationBehavior(Animations.UCHIGATANA_SHEATHING_DASH, 0.0F)
/* 417 */             .addNextBehavior(
/* 418 */               CECombatBehaviors.Behavior.builder()
/* 419 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 420 */               .withinDistance(0.0D, 4.0D)
/* 421 */               .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 422 */               .addNextBehavior(
/* 423 */                 CECombatBehaviors.Behavior.builder()
/* 424 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 425 */                 .withinDistance(0.0D, 5.0D)
/* 426 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 427 */                 .addNextBehavior(
/* 428 */                   CECombatBehaviors.Behavior.builder()
/* 429 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 430 */                   .withinDistance(0.0D, 5.0D)
/* 431 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 439 */       .addFirstBehavior(
/* 440 */         CECombatBehaviors.Behavior.builder()
/* 441 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 442 */         .withinDistance(0.0D, 3.0D)
/* 443 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 444 */         .addNextBehavior(
/* 445 */           CECombatBehaviors.Behavior.builder()
/* 446 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 447 */           .withinDistance(0.0D, 3.0D)
/* 448 */           .animationBehavior(Animations.UCHIGATANA_AIR_SLASH, 0.0F)
/* 449 */           .addNextBehavior(
/* 450 */             CECombatBehaviors.Behavior.builder()
/* 451 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 452 */             .withinDistance(0.0D, 4.0D)
/* 453 */             .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 454 */             .addNextBehavior(
/* 455 */               CECombatBehaviors.Behavior.builder()
/* 456 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 457 */               .withinDistance(0.0D, 4.0D)
/* 458 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 459 */               .addNextBehavior(
/* 460 */                 CECombatBehaviors.Behavior.builder()
/* 461 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 462 */                 .withinDistance(0.0D, 5.0D)
/* 463 */                 .animationBehavior(Animations.UCHIGATANA_AUTO3, 0.0F)
/* 464 */                 .addNextBehavior(
/* 465 */                   CECombatBehaviors.Behavior.builder()
/* 466 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 467 */                   .withinDistance(0.0D, 5.0D)
/* 468 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 469 */                   .addNextBehavior(
/* 470 */                     CECombatBehaviors.Behavior.builder()
/* 471 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 472 */                     .withinDistance(0.0D, 5.0D)
/* 473 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 482 */       .addFirstBehavior(
/* 483 */         CECombatBehaviors.Behavior.builder()
/* 484 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 485 */         .withinDistance(0.0D, 3.0D)
/* 486 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 487 */         .addNextBehavior(
/* 488 */           CECombatBehaviors.Behavior.builder()
/* 489 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 490 */           .withinDistance(0.0D, 3.0D)
/* 491 */           .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/* 492 */           .addNextBehavior(
/* 493 */             CECombatBehaviors.Behavior.builder()
/* 494 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 495 */             .withinDistance(0.0D, 4.0D)
/* 496 */             .animationBehavior(Animations.BATTOJUTSU_DASH, 0.0F)
/* 497 */             .addNextBehavior(
/* 498 */               CECombatBehaviors.Behavior.builder()
/* 499 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 500 */               .withinDistance(0.0D, 4.0D)
/* 501 */               .animationBehavior(Animations.UCHIGATANA_SHEATHING_AUTO, 0.0F)
/* 502 */               .addNextBehavior(
/* 503 */                 CECombatBehaviors.Behavior.builder()
/* 504 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 505 */                 .withinDistance(0.0D, 5.0D)
/* 506 */                 .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 507 */                 .addNextBehavior(
/* 508 */                   CECombatBehaviors.Behavior.builder()
/* 509 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 510 */                   .withinDistance(0.0D, 5.0D)
/* 511 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 512 */                   .addNextBehavior(
/* 513 */                     CECombatBehaviors.Behavior.builder()
/* 514 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 515 */                     .withinDistance(0.0D, 5.0D)
/* 516 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 525 */       .addFirstBehavior(
/* 526 */         CECombatBehaviors.Behavior.builder()
/* 527 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 528 */         .withinDistance(0.0D, 3.0D)
/* 529 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 530 */         .addNextBehavior(
/* 531 */           CECombatBehaviors.Behavior.builder()
/* 532 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 533 */           .withinDistance(0.0D, 3.0D)
/* 534 */           .animationBehavior(Animations.UCHIGATANA_SHEATHING_AUTO, 0.0F)
/* 535 */           .addNextBehavior(
/* 536 */             CECombatBehaviors.Behavior.builder()
/* 537 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 538 */             .withinDistance(0.0D, 4.0D)
/* 539 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 540 */             .addNextBehavior(
/* 541 */               CECombatBehaviors.Behavior.builder()
/* 542 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 543 */               .withinDistance(0.0D, 4.0D)
/* 544 */               .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 545 */               .addNextBehavior(
/* 546 */                 CECombatBehaviors.Behavior.builder()
/* 547 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 548 */                 .withinDistance(0.0D, 5.0D)
/* 549 */                 .animationBehavior(Animations.UCHIGATANA_DASH, 0.0F)
/* 550 */                 .addNextBehavior(
/* 551 */                   CECombatBehaviors.Behavior.builder()
/* 552 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 553 */                   .withinDistance(0.0D, 5.0D)
/* 554 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 555 */                   .addNextBehavior(
/* 556 */                     CECombatBehaviors.Behavior.builder()
/* 557 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 558 */                     .withinDistance(0.0D, 5.0D)
/* 559 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 568 */       .addFirstBehavior(
/* 569 */         CECombatBehaviors.Behavior.builder()
/* 570 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 571 */         .withinDistance(0.0D, 3.0D)
/* 572 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 573 */         .addNextBehavior(
/* 574 */           CECombatBehaviors.Behavior.builder()
/* 575 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 576 */           .withinDistance(0.0D, 3.0D)
/* 577 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 578 */           .addNextBehavior(
/* 579 */             CECombatBehaviors.Behavior.builder()
/* 580 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 581 */             .withinDistance(0.0D, 4.0D)
/* 582 */             .animationBehavior(Animations.UCHIGATANA_SHEATHING_DASH, 0.0F)
/* 583 */             .addNextBehavior(
/* 584 */               CECombatBehaviors.Behavior.builder()
/* 585 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 586 */               .withinDistance(0.0D, 4.0D)
/* 587 */               .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 588 */               .addNextBehavior(
/* 589 */                 CECombatBehaviors.Behavior.builder()
/* 590 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 591 */                 .withinDistance(0.0D, 5.0D)
/* 592 */                 .animationBehavior(Animations.UCHIGATANA_AIR_SLASH, 0.0F)
/* 593 */                 .addNextBehavior(
/* 594 */                   CECombatBehaviors.Behavior.builder()
/* 595 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 596 */                   .withinDistance(0.0D, 5.0D)
/* 597 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 598 */                   .addNextBehavior(
/* 599 */                     CECombatBehaviors.Behavior.builder()
/* 600 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 601 */                     .withinDistance(0.0D, 5.0D)
/* 602 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 611 */       .addFirstBehavior(
/* 612 */         CECombatBehaviors.Behavior.builder()
/* 613 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 614 */         .withinDistance(0.0D, 3.0D)
/* 615 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 616 */         .addNextBehavior(
/* 617 */           CECombatBehaviors.Behavior.builder()
/* 618 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 619 */           .withinDistance(0.0D, 3.0D)
/* 620 */           .animationBehavior(Animations.UCHIGATANA_DASH, 0.0F)
/* 621 */           .addNextBehavior(
/* 622 */             CECombatBehaviors.Behavior.builder()
/* 623 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 624 */             .withinDistance(0.0D, 4.0D)
/* 625 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 626 */             .addNextBehavior(
/* 627 */               CECombatBehaviors.Behavior.builder()
/* 628 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 629 */               .withinDistance(0.0D, 4.0D)
/* 630 */               .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 631 */               .addNextBehavior(
/* 632 */                 CECombatBehaviors.Behavior.builder()
/* 633 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 634 */                 .withinDistance(0.0D, 5.0D)
/* 635 */                 .animationBehavior(Animations.UCHIGATANA_SHEATHING_AUTO, 0.0F)
/* 636 */                 .addNextBehavior(
/* 637 */                   CECombatBehaviors.Behavior.builder()
/* 638 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 639 */                   .withinDistance(0.0D, 5.0D)
/* 640 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 641 */                   .addNextBehavior(
/* 642 */                     CECombatBehaviors.Behavior.builder()
/* 643 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 644 */                     .withinDistance(0.0D, 5.0D)
/* 645 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 654 */       .addFirstBehavior(
/* 655 */         CECombatBehaviors.Behavior.builder()
/* 656 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 657 */         .withinDistance(0.0D, 3.0D)
/* 658 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 659 */         .addNextBehavior(
/* 660 */           CECombatBehaviors.Behavior.builder()
/* 661 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 662 */           .withinDistance(0.0D, 3.0D)
/* 663 */           .animationBehavior(Animations.UCHIGATANA_SHEATHING_AUTO, 0.0F)
/* 664 */           .addNextBehavior(
/* 665 */             CECombatBehaviors.Behavior.builder()
/* 666 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 667 */             .withinDistance(0.0D, 4.0D)
/* 668 */             .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 669 */             .addNextBehavior(
/* 670 */               CECombatBehaviors.Behavior.builder()
/* 671 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 672 */               .withinDistance(0.0D, 4.0D)
/* 673 */               .animationBehavior(Animations.UCHIGATANA_SHEATHING_DASH, 0.0F)
/* 674 */               .addNextBehavior(
/* 675 */                 CECombatBehaviors.Behavior.builder()
/* 676 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 677 */                 .withinDistance(0.0D, 5.0D)
/* 678 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 679 */                 .addNextBehavior(
/* 680 */                   CECombatBehaviors.Behavior.builder()
/* 681 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 682 */                   .withinDistance(0.0D, 5.0D)
/* 683 */                   .animationBehavior(Animations.UCHIGATANA_AUTO3, 0.0F)
/* 684 */                   .addNextBehavior(
/* 685 */                     CECombatBehaviors.Behavior.builder()
/* 686 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 687 */                     .withinDistance(0.0D, 5.0D)
/* 688 */                     .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 689 */                     .addNextBehavior(
/* 690 */                       CECombatBehaviors.Behavior.builder()
/* 691 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 692 */                       .withinDistance(0.0D, 5.0D)
/* 693 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 703 */       .addFirstBehavior(
/* 704 */         CECombatBehaviors.Behavior.builder()
/* 705 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 706 */         .withinDistance(0.0D, 3.0D)
/* 707 */         .animationBehavior(Animations.UCHIGATANA_AUTO1, 0.0F)
/* 708 */         .addNextBehavior(
/* 709 */           CECombatBehaviors.Behavior.builder()
/* 710 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 711 */           .withinDistance(0.0D, 3.0D)
/* 712 */           .animationBehavior(Animations.UCHIGATANA_SHEATHING_DASH, 0.0F)
/* 713 */           .addNextBehavior(
/* 714 */             CECombatBehaviors.Behavior.builder()
/* 715 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 716 */             .withinDistance(0.0D, 4.0D)
/* 717 */             .animationBehavior(Animations.UCHIGATANA_AUTO2, 0.0F)
/* 718 */             .addNextBehavior(
/* 719 */               CECombatBehaviors.Behavior.builder()
/* 720 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 721 */               .withinDistance(0.0D, 4.0D)
/* 722 */               .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/* 723 */               .addNextBehavior(
/* 724 */                 CECombatBehaviors.Behavior.builder()
/* 725 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 726 */                 .withinDistance(0.0D, 5.0D)
/* 727 */                 .animationBehavior(Animations.BATTOJUTSU_DASH, 0.0F)
/* 728 */                 .addNextBehavior(
/* 729 */                   CECombatBehaviors.Behavior.builder()
/* 730 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 731 */                   .withinDistance(0.0D, 5.0D)
/* 732 */                   .animationBehavior(Animations.UCHIGATANA_AUTO3, 0.0F)
/* 733 */                   .addNextBehavior(
/* 734 */                     CECombatBehaviors.Behavior.builder()
/* 735 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 736 */                     .withinDistance(0.0D, 5.0D)
/* 737 */                     .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 738 */                     .addNextBehavior(
/* 739 */                       CECombatBehaviors.Behavior.builder()
/* 740 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 741 */                       .withinDistance(0.0D, 5.0D)
/* 742 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 753 */     .newBehaviorRoot(
/* 754 */       CECombatBehaviors.BehaviorRoot.builder()
/* 755 */       .priority(1.0D)
/* 756 */       .weight(20.0D)
/* 757 */       .maxCooldown(100)
/* 758 */       .addFirstBehavior(
/* 759 */         CECombatBehaviors.Behavior.builder()
/* 760 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 761 */         .withinDistance(0.0D, 3.0D)
/* 762 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 763 */         .addNextBehavior(
/* 764 */           CECombatBehaviors.Behavior.builder()
/* 765 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 766 */           .withinDistance(0.0D, 3.0D)
/* 767 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 768 */           .addNextBehavior(
/* 769 */             CECombatBehaviors.Behavior.builder()
/* 770 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 771 */             .withinDistance(0.0D, 3.0D)
/* 772 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F))))
/*     */ 
/*     */ 
/*     */       
/* 776 */       .addFirstBehavior(
/* 777 */         CECombatBehaviors.Behavior.builder()
/* 778 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 779 */         .withinDistance(0.0D, 3.0D)
/* 780 */         .animationBehavior(Animations.UCHIGATANA_SHEATHING_AUTO, 0.0F)))
/*     */ 
/*     */     
/* 783 */     .newBehaviorRoot(
/* 784 */       CECombatBehaviors.BehaviorRoot.builder()
/* 785 */       .priority(1.0D)
/* 786 */       .weight(10.0D)
/* 787 */       .maxCooldown(100)
/* 788 */       .addFirstBehavior(
/* 789 */         CECombatBehaviors.Behavior.builder()
/* 790 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 791 */         .withinDistance(0.0D, 3.0D)
/* 792 */         .animationBehavior(Animations.UCHIGATANA_DASH, 0.0F))
/*     */       
/* 794 */       .addFirstBehavior(
/* 795 */         CECombatBehaviors.Behavior.builder()
/* 796 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 797 */         .withinDistance(0.0D, 3.0D)
/* 798 */         .animationBehavior(Animations.UCHIGATANA_AIR_SLASH, 0.0F))
/*     */       
/* 800 */       .addFirstBehavior(
/* 801 */         CECombatBehaviors.Behavior.builder()
/* 802 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 803 */         .withinDistance(0.0D, 3.0D)
/* 804 */         .animationBehavior(Animations.UCHIGATANA_SHEATHING_DASH, 0.0F))
/*     */       
/* 806 */       .addFirstBehavior(
/* 807 */         CECombatBehaviors.Behavior.builder()
/* 808 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 809 */         .withinDistance(0.0D, 3.0D)
/* 810 */         .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/* 811 */         .addNextBehavior(
/* 812 */           CECombatBehaviors.Behavior.builder()
/* 813 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 814 */           .withinDistance(0.0D, 3.0D)
/* 815 */           .animationBehavior(Animations.BATTOJUTSU_DASH, 0.0F))))
/*     */ 
/*     */ 
/*     */     
/* 819 */     .newBehaviorRoot(
/* 820 */       CECombatBehaviors.BehaviorRoot.builder()
/* 821 */       .priority(1.0D)
/* 822 */       .weight(10.0D)
/* 823 */       .maxCooldown(40)
/* 824 */       .addFirstBehavior(
/* 825 */         CECombatBehaviors.Behavior.builder()
/* 826 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 827 */         .withinDistance(0.0D, 3.0D)
/* 828 */         .custom(CombatCommon::canThrowEnderPearl)
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
/* 840 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 841 */         .withinDistance(0.0D, 3.0D)
/* 842 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 844 */       .addFirstBehavior(
/* 845 */         CECombatBehaviors.Behavior.builder()
/* 846 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 847 */         .withinDistance(0.0D, 3.0D)
/* 848 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 850 */       .addFirstBehavior(
/* 851 */         CECombatBehaviors.Behavior.builder()
/* 852 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 853 */         .withinDistance(0.0D, 3.0D)
/* 854 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 856 */       .addFirstBehavior(
/* 857 */         CECombatBehaviors.Behavior.builder()
/* 858 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 859 */         .withinDistance(0.0D, 3.0D)
/* 860 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 862 */       .addFirstBehavior(
/* 863 */         CECombatBehaviors.Behavior.builder()
/* 864 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 865 */         .withinDistance(0.0D, 3.0D)
/* 866 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 868 */       .addFirstBehavior(
/* 869 */         CECombatBehaviors.Behavior.builder()
/* 870 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 871 */         .withinDistance(0.0D, 3.0D)
/* 872 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 874 */       .addFirstBehavior(
/* 875 */         CECombatBehaviors.Behavior.builder()
/* 876 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 877 */         .withinDistance(0.0D, 3.0D)
/* 878 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 881 */     .newBehaviorRoot(
/* 882 */       CECombatBehaviors.BehaviorRoot.builder()
/* 883 */       .priority(1.0D)
/* 884 */       .weight(15.0D)
/* 885 */       .addFirstBehavior(
/* 886 */         CECombatBehaviors.Behavior.builder()
/* 887 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 888 */         .withinDistance(0.0D, 3.0D)
/* 889 */         .custom(CombatCommon::canPerformGuarding)
/* 890 */         .guard(40)))
/*     */ 
/*     */     
/* 893 */     .newBehaviorRoot(
/* 894 */       CECombatBehaviors.BehaviorRoot.builder()
/* 895 */       .priority(1.0D)
/* 896 */       .weight(10.0D)
/* 897 */       .addFirstBehavior(
/* 898 */         CECombatBehaviors.Behavior.builder()
/* 899 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 900 */         .withinDistance(0.0D, 3.0D)
/* 901 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 903 */       .addFirstBehavior(
/* 904 */         CECombatBehaviors.Behavior.builder()
/* 905 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 906 */         .withinDistance(0.0D, 3.0D)
/* 907 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*     */ 
/*     */     
/* 910 */     .newBehaviorRoot(
/* 911 */       CECombatBehaviors.BehaviorRoot.builder()
/* 912 */       .priority(1.0D)
/* 913 */       .weight(40.0D)
/* 914 */       .maxCooldown(160)
/* 915 */       .addFirstBehavior(
/* 916 */         CECombatBehaviors.Behavior.builder()
/* 917 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 918 */         .custom(CombatCommon::canJump)
/* 919 */         .withinDistance(5.0D, 14.0D)
/* 920 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 921 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcUchigatana.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */