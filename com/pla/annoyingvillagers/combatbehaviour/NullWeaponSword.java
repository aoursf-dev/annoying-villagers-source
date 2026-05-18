/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NullWeaponSword
/*     */ {
/*  14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SWORD = CECombatBehaviors.builder()
/*  15 */     .newBehaviorRoot(
/*  16 */       CECombatBehaviors.BehaviorRoot.builder()
/*  17 */       .priority(2.0D)
/*  18 */       .weight(1000.0D)
/*  19 */       .maxCooldown(0)
/*  20 */       .addFirstBehavior(
/*  21 */         CECombatBehaviors.Behavior.builder()
/*  22 */         .custom(HerobrineCommon::canSpinning)
/*  23 */         .withinDistance(0.0D, 45.0D)
/*  24 */         .guard(40)
/*  25 */         .addExBehavior(HerobrineCommon::performSpinning)))
/*     */ 
/*     */     
/*  28 */     .newBehaviorRoot(
/*  29 */       CECombatBehaviors.BehaviorRoot.builder()
/*  30 */       .priority(1.0D)
/*  31 */       .weight(40.0D)
/*  32 */       .maxCooldown(80)
/*  33 */       .addFirstBehavior(
/*  34 */         CECombatBehaviors.Behavior.builder()
/*  35 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  36 */         .withinDistance(0.0D, 3.0D)
/*  37 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  38 */         .addNextBehavior(
/*  39 */           CECombatBehaviors.Behavior.builder()
/*  40 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  41 */           .withinDistance(0.0D, 3.0D)
/*  42 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  43 */           .addNextBehavior(
/*  44 */             CECombatBehaviors.Behavior.builder()
/*  45 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  46 */             .withinDistance(0.0D, 3.0D)
/*  47 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F))))
/*     */ 
/*     */ 
/*     */       
/*  51 */       .addFirstBehavior(
/*  52 */         CECombatBehaviors.Behavior.builder()
/*  53 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  54 */         .withinDistance(0.0D, 3.0D)
/*  55 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  56 */         .addNextBehavior(
/*  57 */           CECombatBehaviors.Behavior.builder()
/*  58 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  59 */           .withinDistance(0.0D, 3.0D)
/*  60 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  61 */           .addNextBehavior(
/*  62 */             CECombatBehaviors.Behavior.builder()
/*  63 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  64 */             .withinDistance(0.0D, 4.0D)
/*  65 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  66 */             .addNextBehavior(
/*  67 */               CECombatBehaviors.Behavior.builder()
/*  68 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  69 */               .withinDistance(0.0D, 4.0D)
/*  70 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  71 */               .addNextBehavior(
/*  72 */                 CECombatBehaviors.Behavior.builder()
/*  73 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  74 */                 .withinDistance(0.0D, 5.0D)
/*  75 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  82 */       .addFirstBehavior(
/*  83 */         CECombatBehaviors.Behavior.builder()
/*  84 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  85 */         .withinDistance(0.0D, 3.0D)
/*  86 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  87 */         .addNextBehavior(
/*  88 */           CECombatBehaviors.Behavior.builder()
/*  89 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  90 */           .withinDistance(0.0D, 3.0D)
/*  91 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  92 */           .addNextBehavior(
/*  93 */             CECombatBehaviors.Behavior.builder()
/*  94 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  95 */             .withinDistance(0.0D, 4.0D)
/*  96 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  97 */             .addNextBehavior(
/*  98 */               CECombatBehaviors.Behavior.builder()
/*  99 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 100 */               .withinDistance(0.0D, 4.0D)
/* 101 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 102 */               .addNextBehavior(
/* 103 */                 CECombatBehaviors.Behavior.builder()
/* 104 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 105 */                 .withinDistance(0.0D, 5.0D)
/* 106 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       .addFirstBehavior(
/* 114 */         CECombatBehaviors.Behavior.builder()
/* 115 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 116 */         .withinDistance(0.0D, 3.0D)
/* 117 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 118 */         .addNextBehavior(
/* 119 */           CECombatBehaviors.Behavior.builder()
/* 120 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 121 */           .withinDistance(0.0D, 3.0D)
/* 122 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 123 */           .addNextBehavior(
/* 124 */             CECombatBehaviors.Behavior.builder()
/* 125 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 126 */             .withinDistance(0.0D, 4.0D)
/* 127 */             .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 128 */             .addNextBehavior(
/* 129 */               CECombatBehaviors.Behavior.builder()
/* 130 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 131 */               .withinDistance(0.0D, 4.0D)
/* 132 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 133 */               .addNextBehavior(
/* 134 */                 CECombatBehaviors.Behavior.builder()
/* 135 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 136 */                 .withinDistance(0.0D, 5.0D)
/* 137 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 144 */       .addFirstBehavior(
/* 145 */         CECombatBehaviors.Behavior.builder()
/* 146 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 147 */         .withinDistance(0.0D, 3.0D)
/* 148 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 149 */         .addNextBehavior(
/* 150 */           CECombatBehaviors.Behavior.builder()
/* 151 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 152 */           .withinDistance(0.0D, 3.0D)
/* 153 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 154 */           .addNextBehavior(
/* 155 */             CECombatBehaviors.Behavior.builder()
/* 156 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 157 */             .withinDistance(0.0D, 4.0D)
/* 158 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 159 */             .addNextBehavior(
/* 160 */               CECombatBehaviors.Behavior.builder()
/* 161 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 162 */               .withinDistance(0.0D, 4.0D)
/* 163 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 164 */               .addNextBehavior(
/* 165 */                 CECombatBehaviors.Behavior.builder()
/* 166 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 167 */                 .withinDistance(0.0D, 5.0D)
/* 168 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 169 */                 .addNextBehavior(
/* 170 */                   CECombatBehaviors.Behavior.builder()
/* 171 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 172 */                   .withinDistance(0.0D, 5.0D)
/* 173 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 181 */       .addFirstBehavior(
/* 182 */         CECombatBehaviors.Behavior.builder()
/* 183 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 184 */         .withinDistance(0.0D, 3.0D)
/* 185 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 186 */         .addNextBehavior(
/* 187 */           CECombatBehaviors.Behavior.builder()
/* 188 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 189 */           .withinDistance(0.0D, 3.0D)
/* 190 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 191 */           .addNextBehavior(
/* 192 */             CECombatBehaviors.Behavior.builder()
/* 193 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 194 */             .withinDistance(0.0D, 4.0D)
/* 195 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 196 */             .addNextBehavior(
/* 197 */               CECombatBehaviors.Behavior.builder()
/* 198 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 199 */               .withinDistance(0.0D, 4.0D)
/* 200 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 201 */               .addNextBehavior(
/* 202 */                 CECombatBehaviors.Behavior.builder()
/* 203 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 204 */                 .withinDistance(0.0D, 5.0D)
/* 205 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 206 */                 .addNextBehavior(
/* 207 */                   CECombatBehaviors.Behavior.builder()
/* 208 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 209 */                   .withinDistance(0.0D, 5.0D)
/* 210 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 218 */       .addFirstBehavior(
/* 219 */         CECombatBehaviors.Behavior.builder()
/* 220 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 221 */         .withinDistance(0.0D, 3.0D)
/* 222 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 223 */         .addNextBehavior(
/* 224 */           CECombatBehaviors.Behavior.builder()
/* 225 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 226 */           .withinDistance(0.0D, 3.0D)
/* 227 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 228 */           .addNextBehavior(
/* 229 */             CECombatBehaviors.Behavior.builder()
/* 230 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 231 */             .withinDistance(0.0D, 4.0D)
/* 232 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 233 */             .addNextBehavior(
/* 234 */               CECombatBehaviors.Behavior.builder()
/* 235 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 236 */               .withinDistance(0.0D, 4.0D)
/* 237 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 238 */               .addNextBehavior(
/* 239 */                 CECombatBehaviors.Behavior.builder()
/* 240 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 241 */                 .withinDistance(0.0D, 5.0D)
/* 242 */                 .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 243 */                 .addNextBehavior(
/* 244 */                   CECombatBehaviors.Behavior.builder()
/* 245 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 246 */                   .withinDistance(0.0D, 5.0D)
/* 247 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 255 */       .addFirstBehavior(
/* 256 */         CECombatBehaviors.Behavior.builder()
/* 257 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 258 */         .withinDistance(0.0D, 3.0D)
/* 259 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 260 */         .addNextBehavior(
/* 261 */           CECombatBehaviors.Behavior.builder()
/* 262 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 263 */           .withinDistance(0.0D, 3.0D)
/* 264 */           .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 265 */           .addNextBehavior(
/* 266 */             CECombatBehaviors.Behavior.builder()
/* 267 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 268 */             .withinDistance(0.0D, 4.0D)
/* 269 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 270 */             .addNextBehavior(
/* 271 */               CECombatBehaviors.Behavior.builder()
/* 272 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 273 */               .withinDistance(0.0D, 4.0D)
/* 274 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 275 */               .addNextBehavior(
/* 276 */                 CECombatBehaviors.Behavior.builder()
/* 277 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 278 */                 .withinDistance(0.0D, 5.0D)
/* 279 */                 .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 280 */                 .addNextBehavior(
/* 281 */                   CECombatBehaviors.Behavior.builder()
/* 282 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 283 */                   .withinDistance(0.0D, 5.0D)
/* 284 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 292 */       .addFirstBehavior(
/* 293 */         CECombatBehaviors.Behavior.builder()
/* 294 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 295 */         .withinDistance(0.0D, 3.0D)
/* 296 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 297 */         .addNextBehavior(
/* 298 */           CECombatBehaviors.Behavior.builder()
/* 299 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 300 */           .withinDistance(0.0D, 3.0D)
/* 301 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 302 */           .addNextBehavior(
/* 303 */             CECombatBehaviors.Behavior.builder()
/* 304 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 305 */             .withinDistance(0.0D, 4.0D)
/* 306 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 307 */             .addNextBehavior(
/* 308 */               CECombatBehaviors.Behavior.builder()
/* 309 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 310 */               .withinDistance(0.0D, 4.0D)
/* 311 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 312 */               .addNextBehavior(
/* 313 */                 CECombatBehaviors.Behavior.builder()
/* 314 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 315 */                 .withinDistance(0.0D, 5.0D)
/* 316 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 317 */                 .addNextBehavior(
/* 318 */                   CECombatBehaviors.Behavior.builder()
/* 319 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 320 */                   .withinDistance(0.0D, 5.0D)
/* 321 */                   .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 322 */                   .addNextBehavior(
/* 323 */                     CECombatBehaviors.Behavior.builder()
/* 324 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 325 */                     .withinDistance(0.0D, 5.0D)
/* 326 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 335 */       .addFirstBehavior(
/* 336 */         CECombatBehaviors.Behavior.builder()
/* 337 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 338 */         .withinDistance(0.0D, 3.0D)
/* 339 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 340 */         .addNextBehavior(
/* 341 */           CECombatBehaviors.Behavior.builder()
/* 342 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 343 */           .withinDistance(0.0D, 3.0D)
/* 344 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 345 */           .addNextBehavior(
/* 346 */             CECombatBehaviors.Behavior.builder()
/* 347 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 348 */             .withinDistance(0.0D, 4.0D)
/* 349 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 350 */             .addNextBehavior(
/* 351 */               CECombatBehaviors.Behavior.builder()
/* 352 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 353 */               .withinDistance(0.0D, 4.0D)
/* 354 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 355 */               .addNextBehavior(
/* 356 */                 CECombatBehaviors.Behavior.builder()
/* 357 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 358 */                 .withinDistance(0.0D, 5.0D)
/* 359 */                 .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 360 */                 .addNextBehavior(
/* 361 */                   CECombatBehaviors.Behavior.builder()
/* 362 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 363 */                   .withinDistance(0.0D, 5.0D)
/* 364 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 365 */                   .addNextBehavior(
/* 366 */                     CECombatBehaviors.Behavior.builder()
/* 367 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 368 */                     .withinDistance(0.0D, 5.0D)
/* 369 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 378 */       .addFirstBehavior(
/* 379 */         CECombatBehaviors.Behavior.builder()
/* 380 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 381 */         .withinDistance(0.0D, 3.0D)
/* 382 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 383 */         .addNextBehavior(
/* 384 */           CECombatBehaviors.Behavior.builder()
/* 385 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 386 */           .withinDistance(0.0D, 3.0D)
/* 387 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 388 */           .addNextBehavior(
/* 389 */             CECombatBehaviors.Behavior.builder()
/* 390 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 391 */             .withinDistance(0.0D, 4.0D)
/* 392 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 393 */             .addNextBehavior(
/* 394 */               CECombatBehaviors.Behavior.builder()
/* 395 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 396 */               .withinDistance(0.0D, 4.0D)
/* 397 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 398 */               .addNextBehavior(
/* 399 */                 CECombatBehaviors.Behavior.builder()
/* 400 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 401 */                 .withinDistance(0.0D, 5.0D)
/* 402 */                 .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 403 */                 .addNextBehavior(
/* 404 */                   CECombatBehaviors.Behavior.builder()
/* 405 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 406 */                   .withinDistance(0.0D, 5.0D)
/* 407 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 408 */                   .addNextBehavior(
/* 409 */                     CECombatBehaviors.Behavior.builder()
/* 410 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 411 */                     .withinDistance(0.0D, 5.0D)
/* 412 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 421 */       .addFirstBehavior(
/* 422 */         CECombatBehaviors.Behavior.builder()
/* 423 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 424 */         .withinDistance(0.0D, 3.0D)
/* 425 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 426 */         .addNextBehavior(
/* 427 */           CECombatBehaviors.Behavior.builder()
/* 428 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 429 */           .withinDistance(0.0D, 3.0D)
/* 430 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 431 */           .addNextBehavior(
/* 432 */             CECombatBehaviors.Behavior.builder()
/* 433 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 434 */             .withinDistance(0.0D, 4.0D)
/* 435 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 436 */             .addNextBehavior(
/* 437 */               CECombatBehaviors.Behavior.builder()
/* 438 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 439 */               .withinDistance(0.0D, 4.0D)
/* 440 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 441 */               .addNextBehavior(
/* 442 */                 CECombatBehaviors.Behavior.builder()
/* 443 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 444 */                 .withinDistance(0.0D, 5.0D)
/* 445 */                 .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 446 */                 .addNextBehavior(
/* 447 */                   CECombatBehaviors.Behavior.builder()
/* 448 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 449 */                   .withinDistance(0.0D, 5.0D)
/* 450 */                   .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 451 */                   .addNextBehavior(
/* 452 */                     CECombatBehaviors.Behavior.builder()
/* 453 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 454 */                     .withinDistance(0.0D, 5.0D)
/* 455 */                     .animationBehavior(Animations.SWORD_AUTO3, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 464 */       .addFirstBehavior(
/* 465 */         CECombatBehaviors.Behavior.builder()
/* 466 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 467 */         .withinDistance(0.0D, 3.0D)
/* 468 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 469 */         .addNextBehavior(
/* 470 */           CECombatBehaviors.Behavior.builder()
/* 471 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 472 */           .withinDistance(0.0D, 3.0D)
/* 473 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 474 */           .addNextBehavior(
/* 475 */             CECombatBehaviors.Behavior.builder()
/* 476 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 477 */             .withinDistance(0.0D, 4.0D)
/* 478 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 479 */             .addNextBehavior(
/* 480 */               CECombatBehaviors.Behavior.builder()
/* 481 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 482 */               .withinDistance(0.0D, 4.0D)
/* 483 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 484 */               .addNextBehavior(
/* 485 */                 CECombatBehaviors.Behavior.builder()
/* 486 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 487 */                 .withinDistance(0.0D, 5.0D)
/* 488 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 489 */                 .addNextBehavior(
/* 490 */                   CECombatBehaviors.Behavior.builder()
/* 491 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 492 */                   .withinDistance(0.0D, 5.0D)
/* 493 */                   .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 494 */                   .addNextBehavior(
/* 495 */                     CECombatBehaviors.Behavior.builder()
/* 496 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 497 */                     .withinDistance(0.0D, 5.0D)
/* 498 */                     .animationBehavior(Animations.SWORD_AUTO3, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 507 */       .addFirstBehavior(
/* 508 */         CECombatBehaviors.Behavior.builder()
/* 509 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 510 */         .withinDistance(0.0D, 3.0D)
/* 511 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 512 */         .addNextBehavior(
/* 513 */           CECombatBehaviors.Behavior.builder()
/* 514 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 515 */           .withinDistance(0.0D, 3.0D)
/* 516 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 517 */           .addNextBehavior(
/* 518 */             CECombatBehaviors.Behavior.builder()
/* 519 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 520 */             .withinDistance(0.0D, 4.0D)
/* 521 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 522 */             .addNextBehavior(
/* 523 */               CECombatBehaviors.Behavior.builder()
/* 524 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 525 */               .withinDistance(0.0D, 4.0D)
/* 526 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 527 */               .addNextBehavior(
/* 528 */                 CECombatBehaviors.Behavior.builder()
/* 529 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 530 */                 .withinDistance(0.0D, 5.0D)
/* 531 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 532 */                 .addNextBehavior(
/* 533 */                   CECombatBehaviors.Behavior.builder()
/* 534 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 535 */                   .withinDistance(0.0D, 5.0D)
/* 536 */                   .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 544 */       .addFirstBehavior(
/* 545 */         CECombatBehaviors.Behavior.builder()
/* 546 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 547 */         .withinDistance(0.0D, 3.0D)
/* 548 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 549 */         .addNextBehavior(
/* 550 */           CECombatBehaviors.Behavior.builder()
/* 551 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 552 */           .withinDistance(0.0D, 3.0D)
/* 553 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 554 */           .addNextBehavior(
/* 555 */             CECombatBehaviors.Behavior.builder()
/* 556 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 557 */             .withinDistance(0.0D, 4.0D)
/* 558 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 559 */             .addNextBehavior(
/* 560 */               CECombatBehaviors.Behavior.builder()
/* 561 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 562 */               .withinDistance(0.0D, 4.0D)
/* 563 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 564 */               .addNextBehavior(
/* 565 */                 CECombatBehaviors.Behavior.builder()
/* 566 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 567 */                 .withinDistance(0.0D, 5.0D)
/* 568 */                 .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 569 */                 .addNextBehavior(
/* 570 */                   CECombatBehaviors.Behavior.builder()
/* 571 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 572 */                   .withinDistance(0.0D, 5.0D)
/* 573 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 581 */       .addFirstBehavior(
/* 582 */         CECombatBehaviors.Behavior.builder()
/* 583 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 584 */         .withinDistance(0.0D, 3.0D)
/* 585 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 586 */         .addNextBehavior(
/* 587 */           CECombatBehaviors.Behavior.builder()
/* 588 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 589 */           .withinDistance(0.0D, 3.0D)
/* 590 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 591 */           .addNextBehavior(
/* 592 */             CECombatBehaviors.Behavior.builder()
/* 593 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 594 */             .withinDistance(0.0D, 4.0D)
/* 595 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 596 */             .addNextBehavior(
/* 597 */               CECombatBehaviors.Behavior.builder()
/* 598 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 599 */               .withinDistance(0.0D, 4.0D)
/* 600 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 601 */               .addNextBehavior(
/* 602 */                 CECombatBehaviors.Behavior.builder()
/* 603 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 604 */                 .withinDistance(0.0D, 5.0D)
/* 605 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 612 */     .newBehaviorRoot(
/* 613 */       CECombatBehaviors.BehaviorRoot.builder()
/* 614 */       .priority(1.0D)
/* 615 */       .weight(20.0D)
/* 616 */       .maxCooldown(80)
/* 617 */       .addFirstBehavior(
/* 618 */         CECombatBehaviors.Behavior.builder()
/* 619 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 620 */         .withinDistance(0.0D, 3.0D)
/* 621 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 622 */         .addNextBehavior(
/* 623 */           CECombatBehaviors.Behavior.builder()
/* 624 */           .withinDistance(0.0D, 3.0D)
/* 625 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 626 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 627 */           .addNextBehavior(
/* 628 */             CECombatBehaviors.Behavior.builder()
/* 629 */             .withinDistance(0.0D, 3.0D)
/* 630 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 631 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 636 */     .newBehaviorRoot(
/* 637 */       CECombatBehaviors.BehaviorRoot.builder()
/* 638 */       .priority(1.0D)
/* 639 */       .weight(10.0D)
/* 640 */       .maxCooldown(80)
/* 641 */       .addFirstBehavior(
/* 642 */         CECombatBehaviors.Behavior.builder()
/* 643 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 644 */         .withinDistance(0.0D, 3.0D)
/* 645 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*     */       
/* 647 */       .addFirstBehavior(
/* 648 */         CECombatBehaviors.Behavior.builder()
/* 649 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 650 */         .withinDistance(0.0D, 3.0D)
/* 651 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*     */       
/* 653 */       .addFirstBehavior(
/* 654 */         CECombatBehaviors.Behavior.builder()
/* 655 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 656 */         .withinDistance(0.0D, 3.0D)
/* 657 */         .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))
/*     */ 
/*     */     
/* 660 */     .newBehaviorRoot(
/* 661 */       CECombatBehaviors.BehaviorRoot.builder()
/* 662 */       .priority(1.0D)
/* 663 */       .weight(15.0D)
/* 664 */       .addFirstBehavior(
/* 665 */         CECombatBehaviors.Behavior.builder()
/* 666 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 667 */         .withinDistance(0.5D, 3.0D)
/* 668 */         .custom(CombatCommon::canPerformGuarding)
/* 669 */         .guard(40)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\NullWeaponSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */