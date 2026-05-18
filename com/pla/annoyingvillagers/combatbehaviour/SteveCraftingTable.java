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
/*     */ public class SteveCraftingTable
/*     */ {
/*  17 */   public static final CECombatBehaviors.Builder<MobPatch<?>> CRAFTING_TABLE = CECombatBehaviors.builder()
/*  18 */     .newBehaviorRoot(
/*  19 */       CECombatBehaviors.BehaviorRoot.builder()
/*  20 */       .priority(5.0D)
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
/*  33 */       .priority(4.0D)
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
/*  52 */       .priority(3.0D)
/*  53 */       .weight(100.0D)
/*  54 */       .maxCooldown(120)
/*  55 */       .addFirstBehavior(
/*  56 */         CECombatBehaviors.Behavior.builder()
/*  57 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  58 */         .custom(CombatCommon::canSwitchWeapon)
/*  59 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  60 */         .addExBehavior(CombatCommon::switchWeapon))
/*     */       
/*  62 */       .addFirstBehavior(
/*  63 */         CECombatBehaviors.Behavior.builder()
/*  64 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  65 */         .custom(CombatCommon::canSwitchWeapon)
/*  66 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  67 */         .addExBehavior(CombatCommon::switchWeapon)))
/*     */ 
/*     */     
/*  70 */     .newBehaviorRoot(
/*  71 */       CECombatBehaviors.BehaviorRoot.builder()
/*  72 */       .priority(2.0D)
/*  73 */       .weight(70.0D)
/*  74 */       .maxCooldown(0)
/*  75 */       .addFirstBehavior(
/*  76 */         CECombatBehaviors.Behavior.builder()
/*  77 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  78 */         .custom(CombatCommon::canPerformEating)
/*  79 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  80 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  83 */     .newBehaviorRoot(
/*  84 */       CECombatBehaviors.BehaviorRoot.builder()
/*  85 */       .priority(2.0D)
/*  86 */       .weight(100.0D)
/*  87 */       .maxCooldown(120)
/*  88 */       .addFirstBehavior(
/*  89 */         CECombatBehaviors.Behavior.builder()
/*  90 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  91 */         .custom(CombatCommon::canSwapToBow)
/*  92 */         .withinDistance(7.0D, 14.0D)
/*  93 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  94 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  96 */       .addFirstBehavior(
/*  97 */         CECombatBehaviors.Behavior.builder()
/*  98 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  99 */         .custom(CombatCommon::canSwapToBow)
/* 100 */         .withinDistance(7.0D, 14.0D)
/* 101 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 102 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/* 105 */     .newBehaviorRoot(
/* 106 */       CECombatBehaviors.BehaviorRoot.builder()
/* 107 */       .priority(2.0D)
/* 108 */       .weight(80.0D)
/* 109 */       .maxCooldown(120)
/* 110 */       .addFirstBehavior(
/* 111 */         CECombatBehaviors.Behavior.builder()
/* 112 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 113 */         .custom(CombatCommon::canThrowEnderPearl)
/* 114 */         .withinDistance(7.0D, 48.0D)
/* 115 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 116 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/* 119 */     .newBehaviorRoot(
/* 120 */       CECombatBehaviors.BehaviorRoot.builder()
/* 121 */       .priority(1.0D)
/* 122 */       .weight(40.0D)
/* 123 */       .maxCooldown(20)
/* 124 */       .addFirstBehavior(
/* 125 */         CECombatBehaviors.Behavior.builder()
/* 126 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 127 */         .withinDistance(0.0D, 3.0D)
/* 128 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 129 */         .addNextBehavior(
/* 130 */           CECombatBehaviors.Behavior.builder()
/* 131 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 132 */           .withinDistance(0.0D, 3.0D)
/* 133 */           .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 134 */           .addNextBehavior(
/* 135 */             CECombatBehaviors.Behavior.builder()
/* 136 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 137 */             .withinDistance(0.0D, 3.0D)
/* 138 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 139 */             .addNextBehavior(
/* 140 */               CECombatBehaviors.Behavior.builder()
/* 141 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 142 */               .withinDistance(0.0D, 3.0D)
/* 143 */               .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       .addFirstBehavior(
/* 149 */         CECombatBehaviors.Behavior.builder()
/* 150 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 151 */         .withinDistance(0.0D, 3.0D)
/* 152 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 153 */         .addNextBehavior(
/* 154 */           CECombatBehaviors.Behavior.builder()
/* 155 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 156 */           .withinDistance(0.0D, 3.0D)
/* 157 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 158 */           .addNextBehavior(
/* 159 */             CECombatBehaviors.Behavior.builder()
/* 160 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 161 */             .withinDistance(0.0D, 4.0D)
/* 162 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 163 */             .addNextBehavior(
/* 164 */               CECombatBehaviors.Behavior.builder()
/* 165 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 166 */               .withinDistance(0.0D, 4.0D)
/* 167 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 168 */               .addNextBehavior(
/* 169 */                 CECombatBehaviors.Behavior.builder()
/* 170 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 171 */                 .withinDistance(0.0D, 5.0D)
/* 172 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 179 */       .addFirstBehavior(
/* 180 */         CECombatBehaviors.Behavior.builder()
/* 181 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 182 */         .withinDistance(0.0D, 3.0D)
/* 183 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 184 */         .addNextBehavior(
/* 185 */           CECombatBehaviors.Behavior.builder()
/* 186 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 187 */           .withinDistance(0.0D, 3.0D)
/* 188 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 189 */           .addNextBehavior(
/* 190 */             CECombatBehaviors.Behavior.builder()
/* 191 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 192 */             .withinDistance(0.0D, 4.0D)
/* 193 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 194 */             .addNextBehavior(
/* 195 */               CECombatBehaviors.Behavior.builder()
/* 196 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 197 */               .withinDistance(0.0D, 4.0D)
/* 198 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 199 */               .addNextBehavior(
/* 200 */                 CECombatBehaviors.Behavior.builder()
/* 201 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 202 */                 .withinDistance(0.0D, 5.0D)
/* 203 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 210 */       .addFirstBehavior(
/* 211 */         CECombatBehaviors.Behavior.builder()
/* 212 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 213 */         .withinDistance(0.0D, 3.0D)
/* 214 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 215 */         .addNextBehavior(
/* 216 */           CECombatBehaviors.Behavior.builder()
/* 217 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 218 */           .withinDistance(0.0D, 3.0D)
/* 219 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 220 */           .addNextBehavior(
/* 221 */             CECombatBehaviors.Behavior.builder()
/* 222 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 223 */             .withinDistance(0.0D, 4.0D)
/* 224 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 225 */             .addNextBehavior(
/* 226 */               CECombatBehaviors.Behavior.builder()
/* 227 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 228 */               .withinDistance(0.0D, 4.0D)
/* 229 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 230 */               .addNextBehavior(
/* 231 */                 CECombatBehaviors.Behavior.builder()
/* 232 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 233 */                 .withinDistance(0.0D, 5.0D)
/* 234 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 241 */       .addFirstBehavior(
/* 242 */         CECombatBehaviors.Behavior.builder()
/* 243 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 244 */         .withinDistance(0.0D, 3.0D)
/* 245 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 246 */         .addNextBehavior(
/* 247 */           CECombatBehaviors.Behavior.builder()
/* 248 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 249 */           .withinDistance(0.0D, 3.0D)
/* 250 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 251 */           .addNextBehavior(
/* 252 */             CECombatBehaviors.Behavior.builder()
/* 253 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 254 */             .withinDistance(0.0D, 4.0D)
/* 255 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 256 */             .addNextBehavior(
/* 257 */               CECombatBehaviors.Behavior.builder()
/* 258 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 259 */               .withinDistance(0.0D, 4.0D)
/* 260 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 261 */               .addNextBehavior(
/* 262 */                 CECombatBehaviors.Behavior.builder()
/* 263 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 264 */                 .withinDistance(0.0D, 5.0D)
/* 265 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 272 */       .addFirstBehavior(
/* 273 */         CECombatBehaviors.Behavior.builder()
/* 274 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 275 */         .withinDistance(0.0D, 3.0D)
/* 276 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 277 */         .addNextBehavior(
/* 278 */           CECombatBehaviors.Behavior.builder()
/* 279 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 280 */           .withinDistance(0.0D, 3.0D)
/* 281 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 282 */           .addNextBehavior(
/* 283 */             CECombatBehaviors.Behavior.builder()
/* 284 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 285 */             .withinDistance(0.0D, 4.0D)
/* 286 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 287 */             .addNextBehavior(
/* 288 */               CECombatBehaviors.Behavior.builder()
/* 289 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 290 */               .withinDistance(0.0D, 4.0D)
/* 291 */               .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 292 */               .addNextBehavior(
/* 293 */                 CECombatBehaviors.Behavior.builder()
/* 294 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 295 */                 .withinDistance(0.0D, 5.0D)
/* 296 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 297 */                 .addNextBehavior(
/* 298 */                   CECombatBehaviors.Behavior.builder()
/* 299 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 300 */                   .withinDistance(0.0D, 5.0D)
/* 301 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
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
/* 313 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 314 */         .addNextBehavior(
/* 315 */           CECombatBehaviors.Behavior.builder()
/* 316 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 317 */           .withinDistance(0.0D, 3.0D)
/* 318 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 319 */           .addNextBehavior(
/* 320 */             CECombatBehaviors.Behavior.builder()
/* 321 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 322 */             .withinDistance(0.0D, 4.0D)
/* 323 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 324 */             .addNextBehavior(
/* 325 */               CECombatBehaviors.Behavior.builder()
/* 326 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 327 */               .withinDistance(0.0D, 4.0D)
/* 328 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 329 */               .addNextBehavior(
/* 330 */                 CECombatBehaviors.Behavior.builder()
/* 331 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 332 */                 .withinDistance(0.0D, 5.0D)
/* 333 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 334 */                 .addNextBehavior(
/* 335 */                   CECombatBehaviors.Behavior.builder()
/* 336 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 337 */                   .withinDistance(0.0D, 5.0D)
/* 338 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
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
/* 350 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 351 */         .addNextBehavior(
/* 352 */           CECombatBehaviors.Behavior.builder()
/* 353 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 354 */           .withinDistance(0.0D, 3.0D)
/* 355 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 356 */           .addNextBehavior(
/* 357 */             CECombatBehaviors.Behavior.builder()
/* 358 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 359 */             .withinDistance(0.0D, 4.0D)
/* 360 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 361 */             .addNextBehavior(
/* 362 */               CECombatBehaviors.Behavior.builder()
/* 363 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 364 */               .withinDistance(0.0D, 4.0D)
/* 365 */               .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 366 */               .addNextBehavior(
/* 367 */                 CECombatBehaviors.Behavior.builder()
/* 368 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 369 */                 .withinDistance(0.0D, 5.0D)
/* 370 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 371 */                 .addNextBehavior(
/* 372 */                   CECombatBehaviors.Behavior.builder()
/* 373 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 374 */                   .withinDistance(0.0D, 5.0D)
/* 375 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
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
/* 387 */         .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 388 */         .addNextBehavior(
/* 389 */           CECombatBehaviors.Behavior.builder()
/* 390 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 391 */           .withinDistance(0.0D, 3.0D)
/* 392 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 393 */           .addNextBehavior(
/* 394 */             CECombatBehaviors.Behavior.builder()
/* 395 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 396 */             .withinDistance(0.0D, 4.0D)
/* 397 */             .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 398 */             .addNextBehavior(
/* 399 */               CECombatBehaviors.Behavior.builder()
/* 400 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 401 */               .withinDistance(0.0D, 4.0D)
/* 402 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 403 */               .addNextBehavior(
/* 404 */                 CECombatBehaviors.Behavior.builder()
/* 405 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 406 */                 .withinDistance(0.0D, 5.0D)
/* 407 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 414 */       .addFirstBehavior(
/* 415 */         CECombatBehaviors.Behavior.builder()
/* 416 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 417 */         .withinDistance(0.0D, 3.0D)
/* 418 */         .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 419 */         .addNextBehavior(
/* 420 */           CECombatBehaviors.Behavior.builder()
/* 421 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 422 */           .withinDistance(0.0D, 3.0D)
/* 423 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 424 */           .addNextBehavior(
/* 425 */             CECombatBehaviors.Behavior.builder()
/* 426 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 427 */             .withinDistance(0.0D, 4.0D)
/* 428 */             .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 429 */             .addNextBehavior(
/* 430 */               CECombatBehaviors.Behavior.builder()
/* 431 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 432 */               .withinDistance(0.0D, 4.0D)
/* 433 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 434 */               .addNextBehavior(
/* 435 */                 CECombatBehaviors.Behavior.builder()
/* 436 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 437 */                 .withinDistance(0.0D, 5.0D)
/* 438 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 445 */       .addFirstBehavior(
/* 446 */         CECombatBehaviors.Behavior.builder()
/* 447 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 448 */         .withinDistance(0.0D, 3.0D)
/* 449 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 450 */         .addNextBehavior(
/* 451 */           CECombatBehaviors.Behavior.builder()
/* 452 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 453 */           .withinDistance(0.0D, 3.0D)
/* 454 */           .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 455 */           .addNextBehavior(
/* 456 */             CECombatBehaviors.Behavior.builder()
/* 457 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 458 */             .withinDistance(0.0D, 4.0D)
/* 459 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 460 */             .addNextBehavior(
/* 461 */               CECombatBehaviors.Behavior.builder()
/* 462 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 463 */               .withinDistance(0.0D, 4.0D)
/* 464 */               .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 465 */               .addNextBehavior(
/* 466 */                 CECombatBehaviors.Behavior.builder()
/* 467 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 468 */                 .withinDistance(0.0D, 5.0D)
/* 469 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 476 */       .addFirstBehavior(
/* 477 */         CECombatBehaviors.Behavior.builder()
/* 478 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 479 */         .withinDistance(0.0D, 3.0D)
/* 480 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 481 */         .addNextBehavior(
/* 482 */           CECombatBehaviors.Behavior.builder()
/* 483 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 484 */           .withinDistance(0.0D, 3.0D)
/* 485 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 486 */           .addNextBehavior(
/* 487 */             CECombatBehaviors.Behavior.builder()
/* 488 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 489 */             .withinDistance(0.0D, 4.0D)
/* 490 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 491 */             .addNextBehavior(
/* 492 */               CECombatBehaviors.Behavior.builder()
/* 493 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 494 */               .withinDistance(0.0D, 4.0D)
/* 495 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 496 */               .addNextBehavior(
/* 497 */                 CECombatBehaviors.Behavior.builder()
/* 498 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 499 */                 .withinDistance(0.0D, 5.0D)
/* 500 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 501 */                 .addNextBehavior(
/* 502 */                   CECombatBehaviors.Behavior.builder()
/* 503 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 504 */                   .withinDistance(0.0D, 5.0D)
/* 505 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 513 */       .addFirstBehavior(
/* 514 */         CECombatBehaviors.Behavior.builder()
/* 515 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 516 */         .withinDistance(0.0D, 3.0D)
/* 517 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 518 */         .addNextBehavior(
/* 519 */           CECombatBehaviors.Behavior.builder()
/* 520 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 521 */           .withinDistance(0.0D, 3.0D)
/* 522 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 523 */           .addNextBehavior(
/* 524 */             CECombatBehaviors.Behavior.builder()
/* 525 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 526 */             .withinDistance(0.0D, 4.0D)
/* 527 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 528 */             .addNextBehavior(
/* 529 */               CECombatBehaviors.Behavior.builder()
/* 530 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 531 */               .withinDistance(0.0D, 4.0D)
/* 532 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 533 */               .addNextBehavior(
/* 534 */                 CECombatBehaviors.Behavior.builder()
/* 535 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 536 */                 .withinDistance(0.0D, 5.0D)
/* 537 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 538 */                 .addNextBehavior(
/* 539 */                   CECombatBehaviors.Behavior.builder()
/* 540 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 541 */                   .withinDistance(0.0D, 5.0D)
/* 542 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 550 */       .addFirstBehavior(
/* 551 */         CECombatBehaviors.Behavior.builder()
/* 552 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 553 */         .withinDistance(0.0D, 3.0D)
/* 554 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 555 */         .addNextBehavior(
/* 556 */           CECombatBehaviors.Behavior.builder()
/* 557 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 558 */           .withinDistance(0.0D, 3.0D)
/* 559 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 560 */           .addNextBehavior(
/* 561 */             CECombatBehaviors.Behavior.builder()
/* 562 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 563 */             .withinDistance(0.0D, 4.0D)
/* 564 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 565 */             .addNextBehavior(
/* 566 */               CECombatBehaviors.Behavior.builder()
/* 567 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 568 */               .withinDistance(0.0D, 4.0D)
/* 569 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 570 */               .addNextBehavior(
/* 571 */                 CECombatBehaviors.Behavior.builder()
/* 572 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 573 */                 .withinDistance(0.0D, 5.0D)
/* 574 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 575 */                 .addNextBehavior(
/* 576 */                   CECombatBehaviors.Behavior.builder()
/* 577 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 578 */                   .withinDistance(0.0D, 5.0D)
/* 579 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 587 */       .addFirstBehavior(
/* 588 */         CECombatBehaviors.Behavior.builder()
/* 589 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 590 */         .withinDistance(0.0D, 3.0D)
/* 591 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 592 */         .addNextBehavior(
/* 593 */           CECombatBehaviors.Behavior.builder()
/* 594 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 595 */           .withinDistance(0.0D, 3.0D)
/* 596 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 597 */           .addNextBehavior(
/* 598 */             CECombatBehaviors.Behavior.builder()
/* 599 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 600 */             .withinDistance(0.0D, 4.0D)
/* 601 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 602 */             .addNextBehavior(
/* 603 */               CECombatBehaviors.Behavior.builder()
/* 604 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 605 */               .withinDistance(0.0D, 4.0D)
/* 606 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 607 */               .addNextBehavior(
/* 608 */                 CECombatBehaviors.Behavior.builder()
/* 609 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 610 */                 .withinDistance(0.0D, 5.0D)
/* 611 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 612 */                 .addNextBehavior(
/* 613 */                   CECombatBehaviors.Behavior.builder()
/* 614 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 615 */                   .withinDistance(0.0D, 5.0D)
/* 616 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 624 */       .addFirstBehavior(
/* 625 */         CECombatBehaviors.Behavior.builder()
/* 626 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 627 */         .withinDistance(0.0D, 3.0D)
/* 628 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 629 */         .addNextBehavior(
/* 630 */           CECombatBehaviors.Behavior.builder()
/* 631 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 632 */           .withinDistance(0.0D, 3.0D)
/* 633 */           .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 634 */           .addNextBehavior(
/* 635 */             CECombatBehaviors.Behavior.builder()
/* 636 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 637 */             .withinDistance(0.0D, 4.0D)
/* 638 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 639 */             .addNextBehavior(
/* 640 */               CECombatBehaviors.Behavior.builder()
/* 641 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 642 */               .withinDistance(0.0D, 4.0D)
/* 643 */               .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 644 */               .addNextBehavior(
/* 645 */                 CECombatBehaviors.Behavior.builder()
/* 646 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 647 */                 .withinDistance(0.0D, 5.0D)
/* 648 */                 .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 649 */                 .addNextBehavior(
/* 650 */                   CECombatBehaviors.Behavior.builder()
/* 651 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 652 */                   .withinDistance(0.0D, 5.0D)
/* 653 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 662 */     .newBehaviorRoot(
/* 663 */       CECombatBehaviors.BehaviorRoot.builder()
/* 664 */       .priority(1.0D)
/* 665 */       .weight(20.0D)
/* 666 */       .maxCooldown(100)
/* 667 */       .addFirstBehavior(
/* 668 */         CECombatBehaviors.Behavior.builder()
/* 669 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 670 */         .withinDistance(0.0D, 3.0D)
/* 671 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)))
/*     */ 
/*     */     
/* 674 */     .newBehaviorRoot(
/* 675 */       CECombatBehaviors.BehaviorRoot.builder()
/* 676 */       .priority(1.0D)
/* 677 */       .weight(10.0D)
/* 678 */       .maxCooldown(100)
/* 679 */       .addFirstBehavior(
/* 680 */         CECombatBehaviors.Behavior.builder()
/* 681 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 682 */         .withinDistance(0.0D, 3.0D)
/* 683 */         .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F))
/*     */       
/* 685 */       .addFirstBehavior(
/* 686 */         CECombatBehaviors.Behavior.builder()
/* 687 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 688 */         .withinDistance(0.0D, 3.0D)
/* 689 */         .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F))
/*     */       
/* 691 */       .addFirstBehavior(
/* 692 */         CECombatBehaviors.Behavior.builder()
/* 693 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 694 */         .withinDistance(0.0D, 3.0D)
/* 695 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)))
/*     */ 
/*     */     
/* 698 */     .newBehaviorRoot(
/* 699 */       CECombatBehaviors.BehaviorRoot.builder()
/* 700 */       .priority(1.0D)
/* 701 */       .weight(10.0D)
/* 702 */       .maxCooldown(40)
/* 703 */       .addFirstBehavior(
/* 704 */         CECombatBehaviors.Behavior.builder()
/* 705 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 706 */         .withinDistance(0.0D, 3.0D)
/* 707 */         .custom(CombatCommon::canThrowEnderPearl)
/* 708 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 709 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 710 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 713 */     .newBehaviorRoot(
/* 714 */       CECombatBehaviors.BehaviorRoot.builder()
/* 715 */       .priority(1.0D)
/* 716 */       .weight(2.0D)
/* 717 */       .maxCooldown(100)
/* 718 */       .addFirstBehavior(
/* 719 */         CECombatBehaviors.Behavior.builder()
/* 720 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 721 */         .withinDistance(0.0D, 3.0D)
/* 722 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 724 */       .addFirstBehavior(
/* 725 */         CECombatBehaviors.Behavior.builder()
/* 726 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 727 */         .withinDistance(0.0D, 3.0D)
/* 728 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 730 */       .addFirstBehavior(
/* 731 */         CECombatBehaviors.Behavior.builder()
/* 732 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 733 */         .withinDistance(0.0D, 3.0D)
/* 734 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 736 */       .addFirstBehavior(
/* 737 */         CECombatBehaviors.Behavior.builder()
/* 738 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 739 */         .withinDistance(0.0D, 3.0D)
/* 740 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 742 */       .addFirstBehavior(
/* 743 */         CECombatBehaviors.Behavior.builder()
/* 744 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 745 */         .withinDistance(0.0D, 3.0D)
/* 746 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 748 */       .addFirstBehavior(
/* 749 */         CECombatBehaviors.Behavior.builder()
/* 750 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 751 */         .withinDistance(0.0D, 3.0D)
/* 752 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 754 */       .addFirstBehavior(
/* 755 */         CECombatBehaviors.Behavior.builder()
/* 756 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 757 */         .withinDistance(0.0D, 3.0D)
/* 758 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 761 */     .newBehaviorRoot(
/* 762 */       CECombatBehaviors.BehaviorRoot.builder()
/* 763 */       .priority(1.0D)
/* 764 */       .weight(15.0D)
/* 765 */       .addFirstBehavior(
/* 766 */         CECombatBehaviors.Behavior.builder()
/* 767 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 768 */         .withinDistance(0.0D, 3.0D)
/* 769 */         .custom(CombatCommon::canPerformGuarding)
/* 770 */         .guard(40)))
/*     */ 
/*     */     
/* 773 */     .newBehaviorRoot(
/* 774 */       CECombatBehaviors.BehaviorRoot.builder()
/* 775 */       .priority(1.0D)
/* 776 */       .weight(10.0D)
/* 777 */       .addFirstBehavior(
/* 778 */         CECombatBehaviors.Behavior.builder()
/* 779 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 780 */         .withinDistance(0.0D, 3.0D)
/* 781 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 783 */       .addFirstBehavior(
/* 784 */         CECombatBehaviors.Behavior.builder()
/* 785 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 786 */         .withinDistance(0.0D, 3.0D)
/* 787 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*     */ 
/*     */     
/* 790 */     .newBehaviorRoot(
/* 791 */       CECombatBehaviors.BehaviorRoot.builder()
/* 792 */       .priority(1.0D)
/* 793 */       .weight(40.0D)
/* 794 */       .maxCooldown(160)
/* 795 */       .addFirstBehavior(
/* 796 */         CECombatBehaviors.Behavior.builder()
/* 797 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 798 */         .custom(CombatCommon::canJump)
/* 799 */         .withinDistance(5.0D, 14.0D)
/* 800 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 801 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveCraftingTable.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */