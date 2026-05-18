/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.efkick.gameasset.EFKickAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsRuine;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerNpcCraftingTable
/*     */ {
/*  17 */   public static final CECombatBehaviors.Builder<MobPatch<?>> CRAFTING_TABLE = CECombatBehaviors.builder()
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
/*  40 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
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
/*  73 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  74 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  76 */       .addFirstBehavior(
/*  77 */         CECombatBehaviors.Behavior.builder()
/*  78 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  79 */         .custom(CombatCommon::canSwapToBow)
/*  80 */         .withinDistance(7.0D, 14.0D)
/*  81 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
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
/* 108 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 109 */         .addNextBehavior(
/* 110 */           CECombatBehaviors.Behavior.builder()
/* 111 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 112 */           .withinDistance(0.0D, 3.0D)
/* 113 */           .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 114 */           .addNextBehavior(
/* 115 */             CECombatBehaviors.Behavior.builder()
/* 116 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 117 */             .withinDistance(0.0D, 3.0D)
/* 118 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 119 */             .addNextBehavior(
/* 120 */               CECombatBehaviors.Behavior.builder()
/* 121 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 122 */               .withinDistance(0.0D, 3.0D)
/* 123 */               .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 128 */       .addFirstBehavior(
/* 129 */         CECombatBehaviors.Behavior.builder()
/* 130 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 131 */         .withinDistance(0.0D, 3.0D)
/* 132 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 133 */         .addNextBehavior(
/* 134 */           CECombatBehaviors.Behavior.builder()
/* 135 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 136 */           .withinDistance(0.0D, 3.0D)
/* 137 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 138 */           .addNextBehavior(
/* 139 */             CECombatBehaviors.Behavior.builder()
/* 140 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 141 */             .withinDistance(0.0D, 4.0D)
/* 142 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 143 */             .addNextBehavior(
/* 144 */               CECombatBehaviors.Behavior.builder()
/* 145 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 146 */               .withinDistance(0.0D, 4.0D)
/* 147 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 148 */               .addNextBehavior(
/* 149 */                 CECombatBehaviors.Behavior.builder()
/* 150 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 151 */                 .withinDistance(0.0D, 5.0D)
/* 152 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/* 163 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 164 */         .addNextBehavior(
/* 165 */           CECombatBehaviors.Behavior.builder()
/* 166 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 167 */           .withinDistance(0.0D, 3.0D)
/* 168 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 169 */           .addNextBehavior(
/* 170 */             CECombatBehaviors.Behavior.builder()
/* 171 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 172 */             .withinDistance(0.0D, 4.0D)
/* 173 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 174 */             .addNextBehavior(
/* 175 */               CECombatBehaviors.Behavior.builder()
/* 176 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 177 */               .withinDistance(0.0D, 4.0D)
/* 178 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 179 */               .addNextBehavior(
/* 180 */                 CECombatBehaviors.Behavior.builder()
/* 181 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 182 */                 .withinDistance(0.0D, 5.0D)
/* 183 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 190 */       .addFirstBehavior(
/* 191 */         CECombatBehaviors.Behavior.builder()
/* 192 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 193 */         .withinDistance(0.0D, 3.0D)
/* 194 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 195 */         .addNextBehavior(
/* 196 */           CECombatBehaviors.Behavior.builder()
/* 197 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 198 */           .withinDistance(0.0D, 3.0D)
/* 199 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 200 */           .addNextBehavior(
/* 201 */             CECombatBehaviors.Behavior.builder()
/* 202 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 203 */             .withinDistance(0.0D, 4.0D)
/* 204 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 205 */             .addNextBehavior(
/* 206 */               CECombatBehaviors.Behavior.builder()
/* 207 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 208 */               .withinDistance(0.0D, 4.0D)
/* 209 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 210 */               .addNextBehavior(
/* 211 */                 CECombatBehaviors.Behavior.builder()
/* 212 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 213 */                 .withinDistance(0.0D, 5.0D)
/* 214 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 221 */       .addFirstBehavior(
/* 222 */         CECombatBehaviors.Behavior.builder()
/* 223 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 224 */         .withinDistance(0.0D, 3.0D)
/* 225 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 226 */         .addNextBehavior(
/* 227 */           CECombatBehaviors.Behavior.builder()
/* 228 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 229 */           .withinDistance(0.0D, 3.0D)
/* 230 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 231 */           .addNextBehavior(
/* 232 */             CECombatBehaviors.Behavior.builder()
/* 233 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 234 */             .withinDistance(0.0D, 4.0D)
/* 235 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 236 */             .addNextBehavior(
/* 237 */               CECombatBehaviors.Behavior.builder()
/* 238 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 239 */               .withinDistance(0.0D, 4.0D)
/* 240 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 241 */               .addNextBehavior(
/* 242 */                 CECombatBehaviors.Behavior.builder()
/* 243 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 244 */                 .withinDistance(0.0D, 5.0D)
/* 245 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 252 */       .addFirstBehavior(
/* 253 */         CECombatBehaviors.Behavior.builder()
/* 254 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 255 */         .withinDistance(0.0D, 3.0D)
/* 256 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 257 */         .addNextBehavior(
/* 258 */           CECombatBehaviors.Behavior.builder()
/* 259 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 260 */           .withinDistance(0.0D, 3.0D)
/* 261 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 262 */           .addNextBehavior(
/* 263 */             CECombatBehaviors.Behavior.builder()
/* 264 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 265 */             .withinDistance(0.0D, 4.0D)
/* 266 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 267 */             .addNextBehavior(
/* 268 */               CECombatBehaviors.Behavior.builder()
/* 269 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 270 */               .withinDistance(0.0D, 4.0D)
/* 271 */               .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 272 */               .addNextBehavior(
/* 273 */                 CECombatBehaviors.Behavior.builder()
/* 274 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 275 */                 .withinDistance(0.0D, 5.0D)
/* 276 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 277 */                 .addNextBehavior(
/* 278 */                   CECombatBehaviors.Behavior.builder()
/* 279 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 280 */                   .withinDistance(0.0D, 5.0D)
/* 281 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 289 */       .addFirstBehavior(
/* 290 */         CECombatBehaviors.Behavior.builder()
/* 291 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 292 */         .withinDistance(0.0D, 3.0D)
/* 293 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 294 */         .addNextBehavior(
/* 295 */           CECombatBehaviors.Behavior.builder()
/* 296 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 297 */           .withinDistance(0.0D, 3.0D)
/* 298 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 299 */           .addNextBehavior(
/* 300 */             CECombatBehaviors.Behavior.builder()
/* 301 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 302 */             .withinDistance(0.0D, 4.0D)
/* 303 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 304 */             .addNextBehavior(
/* 305 */               CECombatBehaviors.Behavior.builder()
/* 306 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 307 */               .withinDistance(0.0D, 4.0D)
/* 308 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 309 */               .addNextBehavior(
/* 310 */                 CECombatBehaviors.Behavior.builder()
/* 311 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 312 */                 .withinDistance(0.0D, 5.0D)
/* 313 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 314 */                 .addNextBehavior(
/* 315 */                   CECombatBehaviors.Behavior.builder()
/* 316 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 317 */                   .withinDistance(0.0D, 5.0D)
/* 318 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 326 */       .addFirstBehavior(
/* 327 */         CECombatBehaviors.Behavior.builder()
/* 328 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 329 */         .withinDistance(0.0D, 3.0D)
/* 330 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 331 */         .addNextBehavior(
/* 332 */           CECombatBehaviors.Behavior.builder()
/* 333 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 334 */           .withinDistance(0.0D, 3.0D)
/* 335 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 336 */           .addNextBehavior(
/* 337 */             CECombatBehaviors.Behavior.builder()
/* 338 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 339 */             .withinDistance(0.0D, 4.0D)
/* 340 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 341 */             .addNextBehavior(
/* 342 */               CECombatBehaviors.Behavior.builder()
/* 343 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 344 */               .withinDistance(0.0D, 4.0D)
/* 345 */               .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 346 */               .addNextBehavior(
/* 347 */                 CECombatBehaviors.Behavior.builder()
/* 348 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 349 */                 .withinDistance(0.0D, 5.0D)
/* 350 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 351 */                 .addNextBehavior(
/* 352 */                   CECombatBehaviors.Behavior.builder()
/* 353 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 354 */                   .withinDistance(0.0D, 5.0D)
/* 355 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 363 */       .addFirstBehavior(
/* 364 */         CECombatBehaviors.Behavior.builder()
/* 365 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 366 */         .withinDistance(0.0D, 3.0D)
/* 367 */         .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 368 */         .addNextBehavior(
/* 369 */           CECombatBehaviors.Behavior.builder()
/* 370 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 371 */           .withinDistance(0.0D, 3.0D)
/* 372 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 373 */           .addNextBehavior(
/* 374 */             CECombatBehaviors.Behavior.builder()
/* 375 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 376 */             .withinDistance(0.0D, 4.0D)
/* 377 */             .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 378 */             .addNextBehavior(
/* 379 */               CECombatBehaviors.Behavior.builder()
/* 380 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 381 */               .withinDistance(0.0D, 4.0D)
/* 382 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 383 */               .addNextBehavior(
/* 384 */                 CECombatBehaviors.Behavior.builder()
/* 385 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 386 */                 .withinDistance(0.0D, 5.0D)
/* 387 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 394 */       .addFirstBehavior(
/* 395 */         CECombatBehaviors.Behavior.builder()
/* 396 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 397 */         .withinDistance(0.0D, 3.0D)
/* 398 */         .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 399 */         .addNextBehavior(
/* 400 */           CECombatBehaviors.Behavior.builder()
/* 401 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 402 */           .withinDistance(0.0D, 3.0D)
/* 403 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 404 */           .addNextBehavior(
/* 405 */             CECombatBehaviors.Behavior.builder()
/* 406 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 407 */             .withinDistance(0.0D, 4.0D)
/* 408 */             .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 409 */             .addNextBehavior(
/* 410 */               CECombatBehaviors.Behavior.builder()
/* 411 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 412 */               .withinDistance(0.0D, 4.0D)
/* 413 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 414 */               .addNextBehavior(
/* 415 */                 CECombatBehaviors.Behavior.builder()
/* 416 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 417 */                 .withinDistance(0.0D, 5.0D)
/* 418 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 425 */       .addFirstBehavior(
/* 426 */         CECombatBehaviors.Behavior.builder()
/* 427 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 428 */         .withinDistance(0.0D, 3.0D)
/* 429 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 430 */         .addNextBehavior(
/* 431 */           CECombatBehaviors.Behavior.builder()
/* 432 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 433 */           .withinDistance(0.0D, 3.0D)
/* 434 */           .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 435 */           .addNextBehavior(
/* 436 */             CECombatBehaviors.Behavior.builder()
/* 437 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 438 */             .withinDistance(0.0D, 4.0D)
/* 439 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 440 */             .addNextBehavior(
/* 441 */               CECombatBehaviors.Behavior.builder()
/* 442 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 443 */               .withinDistance(0.0D, 4.0D)
/* 444 */               .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 445 */               .addNextBehavior(
/* 446 */                 CECombatBehaviors.Behavior.builder()
/* 447 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 448 */                 .withinDistance(0.0D, 5.0D)
/* 449 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 456 */       .addFirstBehavior(
/* 457 */         CECombatBehaviors.Behavior.builder()
/* 458 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 459 */         .withinDistance(0.0D, 3.0D)
/* 460 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 461 */         .addNextBehavior(
/* 462 */           CECombatBehaviors.Behavior.builder()
/* 463 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 464 */           .withinDistance(0.0D, 3.0D)
/* 465 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 466 */           .addNextBehavior(
/* 467 */             CECombatBehaviors.Behavior.builder()
/* 468 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 469 */             .withinDistance(0.0D, 4.0D)
/* 470 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 471 */             .addNextBehavior(
/* 472 */               CECombatBehaviors.Behavior.builder()
/* 473 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 474 */               .withinDistance(0.0D, 4.0D)
/* 475 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 476 */               .addNextBehavior(
/* 477 */                 CECombatBehaviors.Behavior.builder()
/* 478 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 479 */                 .withinDistance(0.0D, 5.0D)
/* 480 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 481 */                 .addNextBehavior(
/* 482 */                   CECombatBehaviors.Behavior.builder()
/* 483 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 484 */                   .withinDistance(0.0D, 5.0D)
/* 485 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 493 */       .addFirstBehavior(
/* 494 */         CECombatBehaviors.Behavior.builder()
/* 495 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 496 */         .withinDistance(0.0D, 3.0D)
/* 497 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 498 */         .addNextBehavior(
/* 499 */           CECombatBehaviors.Behavior.builder()
/* 500 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 501 */           .withinDistance(0.0D, 3.0D)
/* 502 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 503 */           .addNextBehavior(
/* 504 */             CECombatBehaviors.Behavior.builder()
/* 505 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 506 */             .withinDistance(0.0D, 4.0D)
/* 507 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 508 */             .addNextBehavior(
/* 509 */               CECombatBehaviors.Behavior.builder()
/* 510 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 511 */               .withinDistance(0.0D, 4.0D)
/* 512 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 513 */               .addNextBehavior(
/* 514 */                 CECombatBehaviors.Behavior.builder()
/* 515 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 516 */                 .withinDistance(0.0D, 5.0D)
/* 517 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 518 */                 .addNextBehavior(
/* 519 */                   CECombatBehaviors.Behavior.builder()
/* 520 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 521 */                   .withinDistance(0.0D, 5.0D)
/* 522 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 530 */       .addFirstBehavior(
/* 531 */         CECombatBehaviors.Behavior.builder()
/* 532 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 533 */         .withinDistance(0.0D, 3.0D)
/* 534 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 535 */         .addNextBehavior(
/* 536 */           CECombatBehaviors.Behavior.builder()
/* 537 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 538 */           .withinDistance(0.0D, 3.0D)
/* 539 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 540 */           .addNextBehavior(
/* 541 */             CECombatBehaviors.Behavior.builder()
/* 542 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 543 */             .withinDistance(0.0D, 4.0D)
/* 544 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 545 */             .addNextBehavior(
/* 546 */               CECombatBehaviors.Behavior.builder()
/* 547 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 548 */               .withinDistance(0.0D, 4.0D)
/* 549 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 550 */               .addNextBehavior(
/* 551 */                 CECombatBehaviors.Behavior.builder()
/* 552 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 553 */                 .withinDistance(0.0D, 5.0D)
/* 554 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 555 */                 .addNextBehavior(
/* 556 */                   CECombatBehaviors.Behavior.builder()
/* 557 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 558 */                   .withinDistance(0.0D, 5.0D)
/* 559 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 567 */       .addFirstBehavior(
/* 568 */         CECombatBehaviors.Behavior.builder()
/* 569 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 570 */         .withinDistance(0.0D, 3.0D)
/* 571 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 572 */         .addNextBehavior(
/* 573 */           CECombatBehaviors.Behavior.builder()
/* 574 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 575 */           .withinDistance(0.0D, 3.0D)
/* 576 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 577 */           .addNextBehavior(
/* 578 */             CECombatBehaviors.Behavior.builder()
/* 579 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 580 */             .withinDistance(0.0D, 4.0D)
/* 581 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 582 */             .addNextBehavior(
/* 583 */               CECombatBehaviors.Behavior.builder()
/* 584 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 585 */               .withinDistance(0.0D, 4.0D)
/* 586 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 587 */               .addNextBehavior(
/* 588 */                 CECombatBehaviors.Behavior.builder()
/* 589 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 590 */                 .withinDistance(0.0D, 5.0D)
/* 591 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 592 */                 .addNextBehavior(
/* 593 */                   CECombatBehaviors.Behavior.builder()
/* 594 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 595 */                   .withinDistance(0.0D, 5.0D)
/* 596 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 604 */       .addFirstBehavior(
/* 605 */         CECombatBehaviors.Behavior.builder()
/* 606 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 607 */         .withinDistance(0.0D, 3.0D)
/* 608 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 609 */         .addNextBehavior(
/* 610 */           CECombatBehaviors.Behavior.builder()
/* 611 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 612 */           .withinDistance(0.0D, 3.0D)
/* 613 */           .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 614 */           .addNextBehavior(
/* 615 */             CECombatBehaviors.Behavior.builder()
/* 616 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 617 */             .withinDistance(0.0D, 4.0D)
/* 618 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 619 */             .addNextBehavior(
/* 620 */               CECombatBehaviors.Behavior.builder()
/* 621 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 622 */               .withinDistance(0.0D, 4.0D)
/* 623 */               .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 624 */               .addNextBehavior(
/* 625 */                 CECombatBehaviors.Behavior.builder()
/* 626 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 627 */                 .withinDistance(0.0D, 5.0D)
/* 628 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 629 */                 .addNextBehavior(
/* 630 */                   CECombatBehaviors.Behavior.builder()
/* 631 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 632 */                   .withinDistance(0.0D, 5.0D)
/* 633 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 642 */     .newBehaviorRoot(
/* 643 */       CECombatBehaviors.BehaviorRoot.builder()
/* 644 */       .priority(1.0D)
/* 645 */       .weight(20.0D)
/* 646 */       .maxCooldown(100)
/* 647 */       .addFirstBehavior(
/* 648 */         CECombatBehaviors.Behavior.builder()
/* 649 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 650 */         .withinDistance(0.0D, 3.0D)
/* 651 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)))
/*     */ 
/*     */     
/* 654 */     .newBehaviorRoot(
/* 655 */       CECombatBehaviors.BehaviorRoot.builder()
/* 656 */       .priority(1.0D)
/* 657 */       .weight(10.0D)
/* 658 */       .maxCooldown(100)
/* 659 */       .addFirstBehavior(
/* 660 */         CECombatBehaviors.Behavior.builder()
/* 661 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 662 */         .withinDistance(0.0D, 3.0D)
/* 663 */         .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F))
/*     */       
/* 665 */       .addFirstBehavior(
/* 666 */         CECombatBehaviors.Behavior.builder()
/* 667 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 668 */         .withinDistance(0.0D, 3.0D)
/* 669 */         .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F))
/*     */       
/* 671 */       .addFirstBehavior(
/* 672 */         CECombatBehaviors.Behavior.builder()
/* 673 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 674 */         .withinDistance(0.0D, 3.0D)
/* 675 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)))
/*     */ 
/*     */     
/* 678 */     .newBehaviorRoot(
/* 679 */       CECombatBehaviors.BehaviorRoot.builder()
/* 680 */       .priority(1.0D)
/* 681 */       .weight(10.0D)
/* 682 */       .maxCooldown(40)
/* 683 */       .addFirstBehavior(
/* 684 */         CECombatBehaviors.Behavior.builder()
/* 685 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 686 */         .withinDistance(0.0D, 3.0D)
/* 687 */         .custom(CombatCommon::canThrowEnderPearl)
/* 688 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 689 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 690 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 693 */     .newBehaviorRoot(
/* 694 */       CECombatBehaviors.BehaviorRoot.builder()
/* 695 */       .priority(1.0D)
/* 696 */       .weight(2.0D)
/* 697 */       .maxCooldown(100)
/* 698 */       .addFirstBehavior(
/* 699 */         CECombatBehaviors.Behavior.builder()
/* 700 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 701 */         .withinDistance(0.0D, 3.0D)
/* 702 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 704 */       .addFirstBehavior(
/* 705 */         CECombatBehaviors.Behavior.builder()
/* 706 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 707 */         .withinDistance(0.0D, 3.0D)
/* 708 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 710 */       .addFirstBehavior(
/* 711 */         CECombatBehaviors.Behavior.builder()
/* 712 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 713 */         .withinDistance(0.0D, 3.0D)
/* 714 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 716 */       .addFirstBehavior(
/* 717 */         CECombatBehaviors.Behavior.builder()
/* 718 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 719 */         .withinDistance(0.0D, 3.0D)
/* 720 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 722 */       .addFirstBehavior(
/* 723 */         CECombatBehaviors.Behavior.builder()
/* 724 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 725 */         .withinDistance(0.0D, 3.0D)
/* 726 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 728 */       .addFirstBehavior(
/* 729 */         CECombatBehaviors.Behavior.builder()
/* 730 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 731 */         .withinDistance(0.0D, 3.0D)
/* 732 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 734 */       .addFirstBehavior(
/* 735 */         CECombatBehaviors.Behavior.builder()
/* 736 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 737 */         .withinDistance(0.0D, 3.0D)
/* 738 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 741 */     .newBehaviorRoot(
/* 742 */       CECombatBehaviors.BehaviorRoot.builder()
/* 743 */       .priority(1.0D)
/* 744 */       .weight(15.0D)
/* 745 */       .addFirstBehavior(
/* 746 */         CECombatBehaviors.Behavior.builder()
/* 747 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 748 */         .withinDistance(0.0D, 3.0D)
/* 749 */         .custom(CombatCommon::canPerformGuarding)
/* 750 */         .guard(40)))
/*     */ 
/*     */     
/* 753 */     .newBehaviorRoot(
/* 754 */       CECombatBehaviors.BehaviorRoot.builder()
/* 755 */       .priority(1.0D)
/* 756 */       .weight(10.0D)
/* 757 */       .addFirstBehavior(
/* 758 */         CECombatBehaviors.Behavior.builder()
/* 759 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 760 */         .withinDistance(0.0D, 3.0D)
/* 761 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 763 */       .addFirstBehavior(
/* 764 */         CECombatBehaviors.Behavior.builder()
/* 765 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 766 */         .withinDistance(0.0D, 3.0D)
/* 767 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*     */ 
/*     */     
/* 770 */     .newBehaviorRoot(
/* 771 */       CECombatBehaviors.BehaviorRoot.builder()
/* 772 */       .priority(1.0D)
/* 773 */       .weight(40.0D)
/* 774 */       .maxCooldown(160)
/* 775 */       .addFirstBehavior(
/* 776 */         CECombatBehaviors.Behavior.builder()
/* 777 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 778 */         .custom(CombatCommon::canJump)
/* 779 */         .withinDistance(5.0D, 14.0D)
/* 780 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 781 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcCraftingTable.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */