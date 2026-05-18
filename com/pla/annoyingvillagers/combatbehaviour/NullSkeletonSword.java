/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.efkick.gameasset.EFKickAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsHerrscher;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ public class NullSkeletonSword {
/*  11 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_SWORD = CECombatBehaviors.builder()
/*  12 */     .newBehaviorRoot(
/*  13 */       CECombatBehaviors.BehaviorRoot.builder()
/*  14 */       .priority(2.0D)
/*  15 */       .weight(1000.0D)
/*  16 */       .maxCooldown(0)
/*  17 */       .addFirstBehavior(
/*  18 */         CECombatBehaviors.Behavior.builder()
/*  19 */         .custom(CombatCommon::canExecute)
/*  20 */         .withinDistance(0.0D, 5.0D)
/*  21 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  22 */         .addExBehavior(CombatCommon::performExecute)))
/*     */ 
/*     */     
/*  25 */     .newBehaviorRoot(
/*  26 */       CECombatBehaviors.BehaviorRoot.builder()
/*  27 */       .priority(1.0D)
/*  28 */       .weight(40.0D)
/*  29 */       .maxCooldown(20)
/*  30 */       .addFirstBehavior(
/*  31 */         CECombatBehaviors.Behavior.builder()
/*  32 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  33 */         .withinDistance(0.0D, 3.0D)
/*  34 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  35 */         .addNextBehavior(
/*  36 */           CECombatBehaviors.Behavior.builder()
/*  37 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  38 */           .withinDistance(0.0D, 3.0D)
/*  39 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  40 */           .addNextBehavior(
/*  41 */             CECombatBehaviors.Behavior.builder()
/*  42 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  43 */             .withinDistance(0.0D, 3.0D)
/*  44 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  45 */             .addNextBehavior(
/*  46 */               CECombatBehaviors.Behavior.builder()
/*  47 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  48 */               .withinDistance(0.0D, 3.0D)
/*  49 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F).addNextBehavior(
/*  50 */                 CECombatBehaviors.Behavior.builder()
/*  51 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  52 */                 .withinDistance(0.0D, 3.0D)
/*  53 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  59 */       .addFirstBehavior(
/*  60 */         CECombatBehaviors.Behavior.builder()
/*  61 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  62 */         .withinDistance(0.0D, 3.0D)
/*  63 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  64 */         .addNextBehavior(
/*  65 */           CECombatBehaviors.Behavior.builder()
/*  66 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  67 */           .withinDistance(0.0D, 3.0D)
/*  68 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  69 */           .addNextBehavior(
/*  70 */             CECombatBehaviors.Behavior.builder()
/*  71 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  72 */             .withinDistance(0.0D, 4.0D)
/*  73 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  74 */             .addNextBehavior(
/*  75 */               CECombatBehaviors.Behavior.builder()
/*  76 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  77 */               .withinDistance(0.0D, 4.0D)
/*  78 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  79 */               .addNextBehavior(
/*  80 */                 CECombatBehaviors.Behavior.builder()
/*  81 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  82 */                 .withinDistance(0.0D, 5.0D)
/*  83 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  84 */                 .addNextBehavior(
/*  85 */                   CECombatBehaviors.Behavior.builder()
/*  86 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  87 */                   .withinDistance(0.0D, 5.0D)
/*  88 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       .addFirstBehavior(
/*  97 */         CECombatBehaviors.Behavior.builder()
/*  98 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  99 */         .withinDistance(0.0D, 3.0D)
/* 100 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 101 */         .addNextBehavior(
/* 102 */           CECombatBehaviors.Behavior.builder()
/* 103 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 104 */           .withinDistance(0.0D, 3.0D)
/* 105 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 106 */           .addNextBehavior(
/* 107 */             CECombatBehaviors.Behavior.builder()
/* 108 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 109 */             .withinDistance(0.0D, 4.0D)
/* 110 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 111 */             .addNextBehavior(
/* 112 */               CECombatBehaviors.Behavior.builder()
/* 113 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 114 */               .withinDistance(0.0D, 4.0D)
/* 115 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 116 */               .addNextBehavior(
/* 117 */                 CECombatBehaviors.Behavior.builder()
/* 118 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 119 */                 .withinDistance(0.0D, 5.0D)
/* 120 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 121 */                 .addNextBehavior(
/* 122 */                   CECombatBehaviors.Behavior.builder()
/* 123 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 124 */                   .withinDistance(0.0D, 5.0D)
/* 125 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       .addFirstBehavior(
/* 134 */         CECombatBehaviors.Behavior.builder()
/* 135 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 136 */         .withinDistance(0.0D, 3.0D)
/* 137 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 138 */         .addNextBehavior(
/* 139 */           CECombatBehaviors.Behavior.builder()
/* 140 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 141 */           .withinDistance(0.0D, 3.0D)
/* 142 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 143 */           .addNextBehavior(
/* 144 */             CECombatBehaviors.Behavior.builder()
/* 145 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 146 */             .withinDistance(0.0D, 4.0D)
/* 147 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 148 */             .addNextBehavior(
/* 149 */               CECombatBehaviors.Behavior.builder()
/* 150 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 151 */               .withinDistance(0.0D, 4.0D)
/* 152 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 153 */               .addNextBehavior(
/* 154 */                 CECombatBehaviors.Behavior.builder()
/* 155 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 156 */                 .withinDistance(0.0D, 5.0D)
/* 157 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 158 */                 .addNextBehavior(
/* 159 */                   CECombatBehaviors.Behavior.builder()
/* 160 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 161 */                   .withinDistance(0.0D, 5.0D)
/* 162 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 163 */                   .addNextBehavior(
/* 164 */                     CECombatBehaviors.Behavior.builder()
/* 165 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 166 */                     .withinDistance(0.0D, 5.0D)
/* 167 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*     */ 
/*     */ 
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
/* 180 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 181 */         .addNextBehavior(
/* 182 */           CECombatBehaviors.Behavior.builder()
/* 183 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 184 */           .withinDistance(0.0D, 3.0D)
/* 185 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 186 */           .addNextBehavior(
/* 187 */             CECombatBehaviors.Behavior.builder()
/* 188 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 189 */             .withinDistance(0.0D, 4.0D)
/* 190 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 191 */             .addNextBehavior(
/* 192 */               CECombatBehaviors.Behavior.builder()
/* 193 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 194 */               .withinDistance(0.0D, 4.0D)
/* 195 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 196 */               .addNextBehavior(
/* 197 */                 CECombatBehaviors.Behavior.builder()
/* 198 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 199 */                 .withinDistance(0.0D, 5.0D)
/* 200 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 201 */                 .addNextBehavior(
/* 202 */                   CECombatBehaviors.Behavior.builder()
/* 203 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 204 */                   .withinDistance(0.0D, 5.0D)
/* 205 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*     */ 
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
/* 217 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 218 */         .addNextBehavior(
/* 219 */           CECombatBehaviors.Behavior.builder()
/* 220 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 221 */           .withinDistance(0.0D, 3.0D)
/* 222 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 223 */           .addNextBehavior(
/* 224 */             CECombatBehaviors.Behavior.builder()
/* 225 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 226 */             .withinDistance(0.0D, 4.0D)
/* 227 */             .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 228 */             .addNextBehavior(
/* 229 */               CECombatBehaviors.Behavior.builder()
/* 230 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 231 */               .withinDistance(0.0D, 4.0D)
/* 232 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 233 */               .addNextBehavior(
/* 234 */                 CECombatBehaviors.Behavior.builder()
/* 235 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 236 */                 .withinDistance(0.0D, 5.0D)
/* 237 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 238 */                 .addNextBehavior(
/* 239 */                   CECombatBehaviors.Behavior.builder()
/* 240 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 241 */                   .withinDistance(0.0D, 5.0D)
/* 242 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*     */ 
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
/* 259 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 260 */           .addNextBehavior(
/* 261 */             CECombatBehaviors.Behavior.builder()
/* 262 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 263 */             .withinDistance(0.0D, 4.0D)
/* 264 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 265 */             .addNextBehavior(
/* 266 */               CECombatBehaviors.Behavior.builder()
/* 267 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 268 */               .withinDistance(0.0D, 4.0D)
/* 269 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 270 */               .addNextBehavior(
/* 271 */                 CECombatBehaviors.Behavior.builder()
/* 272 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 273 */                 .withinDistance(0.0D, 5.0D)
/* 274 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 275 */                 .addNextBehavior(
/* 276 */                   CECombatBehaviors.Behavior.builder()
/* 277 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 278 */                   .withinDistance(0.0D, 5.0D)
/* 279 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
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
/* 301 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 302 */             .addNextBehavior(
/* 303 */               CECombatBehaviors.Behavior.builder()
/* 304 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 305 */               .withinDistance(0.0D, 4.0D)
/* 306 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 307 */               .addNextBehavior(
/* 308 */                 CECombatBehaviors.Behavior.builder()
/* 309 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 310 */                 .withinDistance(0.0D, 5.0D)
/* 311 */                 .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 312 */                 .addNextBehavior(
/* 313 */                   CECombatBehaviors.Behavior.builder()
/* 314 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 315 */                   .withinDistance(0.0D, 5.0D)
/* 316 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 324 */       .addFirstBehavior(
/* 325 */         CECombatBehaviors.Behavior.builder()
/* 326 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 327 */         .withinDistance(0.0D, 3.0D)
/* 328 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 329 */         .addNextBehavior(
/* 330 */           CECombatBehaviors.Behavior.builder()
/* 331 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 332 */           .withinDistance(0.0D, 3.0D)
/* 333 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 334 */           .addNextBehavior(
/* 335 */             CECombatBehaviors.Behavior.builder()
/* 336 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 337 */             .withinDistance(0.0D, 4.0D)
/* 338 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 339 */             .addNextBehavior(
/* 340 */               CECombatBehaviors.Behavior.builder()
/* 341 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 342 */               .withinDistance(0.0D, 4.0D)
/* 343 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 344 */               .addNextBehavior(
/* 345 */                 CECombatBehaviors.Behavior.builder()
/* 346 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 347 */                 .withinDistance(0.0D, 5.0D)
/* 348 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 349 */                 .addNextBehavior(
/* 350 */                   CECombatBehaviors.Behavior.builder()
/* 351 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 352 */                   .withinDistance(0.0D, 5.0D)
/* 353 */                   .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 354 */                   .addNextBehavior(
/* 355 */                     CECombatBehaviors.Behavior.builder()
/* 356 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 357 */                     .withinDistance(0.0D, 5.0D)
/* 358 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 367 */       .addFirstBehavior(
/* 368 */         CECombatBehaviors.Behavior.builder()
/* 369 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 370 */         .withinDistance(0.0D, 3.0D)
/* 371 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 372 */         .addNextBehavior(
/* 373 */           CECombatBehaviors.Behavior.builder()
/* 374 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 375 */           .withinDistance(0.0D, 3.0D)
/* 376 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 377 */           .addNextBehavior(
/* 378 */             CECombatBehaviors.Behavior.builder()
/* 379 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 380 */             .withinDistance(0.0D, 4.0D)
/* 381 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 382 */             .addNextBehavior(
/* 383 */               CECombatBehaviors.Behavior.builder()
/* 384 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 385 */               .withinDistance(0.0D, 4.0D)
/* 386 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 387 */               .addNextBehavior(
/* 388 */                 CECombatBehaviors.Behavior.builder()
/* 389 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 390 */                 .withinDistance(0.0D, 5.0D)
/* 391 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 392 */                 .addNextBehavior(
/* 393 */                   CECombatBehaviors.Behavior.builder()
/* 394 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 395 */                   .withinDistance(0.0D, 5.0D)
/* 396 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 397 */                   .addNextBehavior(
/* 398 */                     CECombatBehaviors.Behavior.builder()
/* 399 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 400 */                     .withinDistance(0.0D, 5.0D)
/* 401 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 410 */       .addFirstBehavior(
/* 411 */         CECombatBehaviors.Behavior.builder()
/* 412 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 413 */         .withinDistance(0.0D, 3.0D)
/* 414 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 415 */         .addNextBehavior(
/* 416 */           CECombatBehaviors.Behavior.builder()
/* 417 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 418 */           .withinDistance(0.0D, 3.0D)
/* 419 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 420 */           .addNextBehavior(
/* 421 */             CECombatBehaviors.Behavior.builder()
/* 422 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 423 */             .withinDistance(0.0D, 4.0D)
/* 424 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 425 */             .addNextBehavior(
/* 426 */               CECombatBehaviors.Behavior.builder()
/* 427 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 428 */               .withinDistance(0.0D, 4.0D)
/* 429 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 430 */               .addNextBehavior(
/* 431 */                 CECombatBehaviors.Behavior.builder()
/* 432 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 433 */                 .withinDistance(0.0D, 5.0D)
/* 434 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 435 */                 .addNextBehavior(
/* 436 */                   CECombatBehaviors.Behavior.builder()
/* 437 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 438 */                   .withinDistance(0.0D, 5.0D)
/* 439 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 447 */       .addFirstBehavior(
/* 448 */         CECombatBehaviors.Behavior.builder()
/* 449 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 450 */         .withinDistance(0.0D, 3.0D)
/* 451 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 452 */         .addNextBehavior(
/* 453 */           CECombatBehaviors.Behavior.builder()
/* 454 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 455 */           .withinDistance(0.0D, 3.0D)
/* 456 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 457 */           .addNextBehavior(
/* 458 */             CECombatBehaviors.Behavior.builder()
/* 459 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 460 */             .withinDistance(0.0D, 4.0D)
/* 461 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 462 */             .addNextBehavior(
/* 463 */               CECombatBehaviors.Behavior.builder()
/* 464 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 465 */               .withinDistance(0.0D, 4.0D)
/* 466 */               .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 467 */               .addNextBehavior(
/* 468 */                 CECombatBehaviors.Behavior.builder()
/* 469 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 470 */                 .withinDistance(0.0D, 5.0D)
/* 471 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 472 */                 .addNextBehavior(
/* 473 */                   CECombatBehaviors.Behavior.builder()
/* 474 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 475 */                   .withinDistance(0.0D, 5.0D)
/* 476 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 484 */       .addFirstBehavior(
/* 485 */         CECombatBehaviors.Behavior.builder()
/* 486 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 487 */         .withinDistance(0.0D, 3.0D)
/* 488 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 489 */         .addNextBehavior(
/* 490 */           CECombatBehaviors.Behavior.builder()
/* 491 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 492 */           .withinDistance(0.0D, 3.0D)
/* 493 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 494 */           .addNextBehavior(
/* 495 */             CECombatBehaviors.Behavior.builder()
/* 496 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 497 */             .withinDistance(0.0D, 4.0D)
/* 498 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 499 */             .addNextBehavior(
/* 500 */               CECombatBehaviors.Behavior.builder()
/* 501 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 502 */               .withinDistance(0.0D, 4.0D)
/* 503 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 504 */               .addNextBehavior(
/* 505 */                 CECombatBehaviors.Behavior.builder()
/* 506 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 507 */                 .withinDistance(0.0D, 5.0D)
/* 508 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 509 */                 .addNextBehavior(
/* 510 */                   CECombatBehaviors.Behavior.builder()
/* 511 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 512 */                   .withinDistance(0.0D, 5.0D)
/* 513 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 514 */                   .addNextBehavior(
/* 515 */                     CECombatBehaviors.Behavior.builder()
/* 516 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 517 */                     .withinDistance(0.0D, 5.0D)
/* 518 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 527 */       .addFirstBehavior(
/* 528 */         CECombatBehaviors.Behavior.builder()
/* 529 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 530 */         .withinDistance(0.0D, 3.0D)
/* 531 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 532 */         .addNextBehavior(
/* 533 */           CECombatBehaviors.Behavior.builder()
/* 534 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 535 */           .withinDistance(0.0D, 3.0D)
/* 536 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 537 */           .addNextBehavior(
/* 538 */             CECombatBehaviors.Behavior.builder()
/* 539 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 540 */             .withinDistance(0.0D, 4.0D)
/* 541 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 542 */             .addNextBehavior(
/* 543 */               CECombatBehaviors.Behavior.builder()
/* 544 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 545 */               .withinDistance(0.0D, 4.0D)
/* 546 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 547 */               .addNextBehavior(
/* 548 */                 CECombatBehaviors.Behavior.builder()
/* 549 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 550 */                 .withinDistance(0.0D, 5.0D)
/* 551 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 552 */                 .addNextBehavior(
/* 553 */                   CECombatBehaviors.Behavior.builder()
/* 554 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 555 */                   .withinDistance(0.0D, 5.0D)
/* 556 */                   .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 557 */                   .addNextBehavior(
/* 558 */                     CECombatBehaviors.Behavior.builder()
/* 559 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 560 */                     .withinDistance(0.0D, 5.0D)
/* 561 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 570 */       .addFirstBehavior(
/* 571 */         CECombatBehaviors.Behavior.builder()
/* 572 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 573 */         .withinDistance(0.0D, 3.0D)
/* 574 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 575 */         .addNextBehavior(
/* 576 */           CECombatBehaviors.Behavior.builder()
/* 577 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 578 */           .withinDistance(0.0D, 3.0D)
/* 579 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 580 */           .addNextBehavior(
/* 581 */             CECombatBehaviors.Behavior.builder()
/* 582 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 583 */             .withinDistance(0.0D, 4.0D)
/* 584 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 585 */             .addNextBehavior(
/* 586 */               CECombatBehaviors.Behavior.builder()
/* 587 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 588 */               .withinDistance(0.0D, 4.0D)
/* 589 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 590 */               .addNextBehavior(
/* 591 */                 CECombatBehaviors.Behavior.builder()
/* 592 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 593 */                 .withinDistance(0.0D, 5.0D)
/* 594 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 595 */                 .addNextBehavior(
/* 596 */                   CECombatBehaviors.Behavior.builder()
/* 597 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 598 */                   .withinDistance(0.0D, 5.0D)
/* 599 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 600 */                   .addNextBehavior(
/* 601 */                     CECombatBehaviors.Behavior.builder()
/* 602 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 603 */                     .withinDistance(0.0D, 5.0D)
/* 604 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 613 */       .addFirstBehavior(
/* 614 */         CECombatBehaviors.Behavior.builder()
/* 615 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 616 */         .withinDistance(0.0D, 3.0D)
/* 617 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 618 */         .addNextBehavior(
/* 619 */           CECombatBehaviors.Behavior.builder()
/* 620 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 621 */           .withinDistance(0.0D, 3.0D)
/* 622 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 623 */           .addNextBehavior(
/* 624 */             CECombatBehaviors.Behavior.builder()
/* 625 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 626 */             .withinDistance(0.0D, 4.0D)
/* 627 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 628 */             .addNextBehavior(
/* 629 */               CECombatBehaviors.Behavior.builder()
/* 630 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 631 */               .withinDistance(0.0D, 4.0D)
/* 632 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 633 */               .addNextBehavior(
/* 634 */                 CECombatBehaviors.Behavior.builder()
/* 635 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 636 */                 .withinDistance(0.0D, 5.0D)
/* 637 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 638 */                 .addNextBehavior(
/* 639 */                   CECombatBehaviors.Behavior.builder()
/* 640 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 641 */                   .withinDistance(0.0D, 5.0D)
/* 642 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 643 */                   .addNextBehavior(
/* 644 */                     CECombatBehaviors.Behavior.builder()
/* 645 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 646 */                     .withinDistance(0.0D, 5.0D)
/* 647 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 656 */     .newBehaviorRoot(
/* 657 */       CECombatBehaviors.BehaviorRoot.builder()
/* 658 */       .priority(1.0D)
/* 659 */       .weight(20.0D)
/* 660 */       .maxCooldown(80)
/* 661 */       .addFirstBehavior(
/* 662 */         CECombatBehaviors.Behavior.builder()
/* 663 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 664 */         .withinDistance(0.0D, 3.0D)
/* 665 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 666 */         .addNextBehavior(
/* 667 */           CECombatBehaviors.Behavior.builder()
/* 668 */           .withinDistance(0.0D, 3.0D)
/* 669 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 670 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 671 */           .addNextBehavior(
/* 672 */             CECombatBehaviors.Behavior.builder()
/* 673 */             .withinDistance(0.0D, 3.0D)
/* 674 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 675 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 680 */     .newBehaviorRoot(
/* 681 */       CECombatBehaviors.BehaviorRoot.builder()
/* 682 */       .priority(1.0D)
/* 683 */       .weight(10.0D)
/* 684 */       .maxCooldown(80)
/* 685 */       .addFirstBehavior(
/* 686 */         CECombatBehaviors.Behavior.builder()
/* 687 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 688 */         .withinDistance(0.0D, 3.0D)
/* 689 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*     */       
/* 691 */       .addFirstBehavior(
/* 692 */         CECombatBehaviors.Behavior.builder()
/* 693 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 694 */         .withinDistance(0.0D, 3.0D)
/* 695 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*     */       
/* 697 */       .addFirstBehavior(
/* 698 */         CECombatBehaviors.Behavior.builder()
/* 699 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 700 */         .withinDistance(0.0D, 3.0D)
/* 701 */         .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))
/*     */ 
/*     */     
/* 704 */     .newBehaviorRoot(
/* 705 */       CECombatBehaviors.BehaviorRoot.builder()
/* 706 */       .priority(1.0D)
/* 707 */       .weight(2.0D)
/* 708 */       .maxCooldown(80)
/* 709 */       .addFirstBehavior(
/* 710 */         CECombatBehaviors.Behavior.builder()
/* 711 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 712 */         .withinDistance(0.0D, 3.0D)
/* 713 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 715 */       .addFirstBehavior(
/* 716 */         CECombatBehaviors.Behavior.builder()
/* 717 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 718 */         .withinDistance(0.0D, 3.0D)
/* 719 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 721 */       .addFirstBehavior(
/* 722 */         CECombatBehaviors.Behavior.builder()
/* 723 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 724 */         .withinDistance(0.0D, 3.0D)
/* 725 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 727 */       .addFirstBehavior(
/* 728 */         CECombatBehaviors.Behavior.builder()
/* 729 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 730 */         .withinDistance(0.0D, 3.0D)
/* 731 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 733 */       .addFirstBehavior(
/* 734 */         CECombatBehaviors.Behavior.builder()
/* 735 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 736 */         .withinDistance(0.0D, 3.0D)
/* 737 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 739 */       .addFirstBehavior(
/* 740 */         CECombatBehaviors.Behavior.builder()
/* 741 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 742 */         .withinDistance(0.0D, 3.0D)
/* 743 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 745 */       .addFirstBehavior(
/* 746 */         CECombatBehaviors.Behavior.builder()
/* 747 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 748 */         .withinDistance(0.0D, 3.0D)
/* 749 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 752 */     .newBehaviorRoot(
/* 753 */       CECombatBehaviors.BehaviorRoot.builder()
/* 754 */       .priority(1.0D)
/* 755 */       .weight(15.0D)
/* 756 */       .addFirstBehavior(
/* 757 */         CECombatBehaviors.Behavior.builder()
/* 758 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 759 */         .withinDistance(0.0D, 3.0D)
/* 760 */         .custom(CombatCommon::canPerformGuarding)
/* 761 */         .guard(40)))
/*     */ 
/*     */     
/* 764 */     .newBehaviorRoot(
/* 765 */       CECombatBehaviors.BehaviorRoot.builder()
/* 766 */       .priority(1.0D)
/* 767 */       .weight(10.0D)
/* 768 */       .addFirstBehavior(
/* 769 */         CECombatBehaviors.Behavior.builder()
/* 770 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 771 */         .withinDistance(0.0D, 3.0D)
/* 772 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*     */       
/* 774 */       .addFirstBehavior(
/* 775 */         CECombatBehaviors.Behavior.builder()
/* 776 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 777 */         .withinDistance(0.0D, 3.0D)
/* 778 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*     */       
/* 780 */       .addFirstBehavior(
/* 781 */         CECombatBehaviors.Behavior.builder()
/* 782 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 783 */         .withinDistance(0.0D, 3.0D)
/* 784 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*     */       
/* 786 */       .addFirstBehavior(
/* 787 */         CECombatBehaviors.Behavior.builder()
/* 788 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 789 */         .withinDistance(0.0D, 3.0D)
/* 790 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*     */ 
/*     */     
/* 793 */     .newBehaviorRoot(
/* 794 */       CECombatBehaviors.BehaviorRoot.builder()
/* 795 */       .priority(1.0D)
/* 796 */       .weight(40.0D)
/* 797 */       .maxCooldown(160)
/* 798 */       .addFirstBehavior(
/* 799 */         CECombatBehaviors.Behavior.builder()
/* 800 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 801 */         .custom(CombatCommon::canJump)
/* 802 */         .withinDistance(5.0D, 14.0D)
/* 803 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 804 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\NullSkeletonSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */