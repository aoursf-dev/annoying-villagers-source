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
/*     */ public class JevFist
/*     */ {
/*  14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> FIST = CECombatBehaviors.builder()
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
/*  30 */       .priority(2.0D)
/*  31 */       .weight(70.0D)
/*  32 */       .maxCooldown(0)
/*  33 */       .addFirstBehavior(
/*  34 */         CECombatBehaviors.Behavior.builder()
/*  35 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  36 */         .custom(CombatCommon::canPerformEating)
/*  37 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  38 */         .addExBehavior(CombatCommon::performDrinkingAnimation))
/*     */       
/*  40 */       .addFirstBehavior(
/*  41 */         CECombatBehaviors.Behavior.builder()
/*  42 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  43 */         .custom(CombatCommon::canPerformEating)
/*  44 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  45 */         .addExBehavior(CombatCommon::performDrinkingAnimation)))
/*     */ 
/*     */     
/*  48 */     .newBehaviorRoot(
/*  49 */       CECombatBehaviors.BehaviorRoot.builder()
/*  50 */       .priority(1.0D)
/*  51 */       .weight(40.0D)
/*  52 */       .maxCooldown(20)
/*  53 */       .addFirstBehavior(
/*  54 */         CECombatBehaviors.Behavior.builder()
/*  55 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  56 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  57 */         .withinDistance(0.0D, 3.0D)
/*  58 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  59 */         .addNextBehavior(
/*  60 */           CECombatBehaviors.Behavior.builder()
/*  61 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  62 */           .custom(CombatCommon::canAttackWhileNotHealing)
/*  63 */           .withinDistance(0.0D, 3.0D)
/*  64 */           .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  65 */           .addNextBehavior(
/*  66 */             CECombatBehaviors.Behavior.builder()
/*  67 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  68 */             .custom(CombatCommon::canAttackWhileNotHealing)
/*  69 */             .withinDistance(0.0D, 3.0D)
/*  70 */             .animationBehavior(Animations.FIST_AUTO3, 0.0F))))
/*     */ 
/*     */ 
/*     */       
/*  74 */       .addFirstBehavior(
/*  75 */         CECombatBehaviors.Behavior.builder()
/*  76 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  77 */         .withinDistance(0.0D, 3.0D)
/*  78 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  79 */         .addNextBehavior(
/*  80 */           CECombatBehaviors.Behavior.builder()
/*  81 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  82 */           .withinDistance(0.0D, 3.0D)
/*  83 */           .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/*  84 */           .addNextBehavior(
/*  85 */             CECombatBehaviors.Behavior.builder()
/*  86 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  87 */             .withinDistance(0.0D, 4.0D)
/*  88 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  89 */             .addNextBehavior(
/*  90 */               CECombatBehaviors.Behavior.builder()
/*  91 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  92 */               .withinDistance(0.0D, 4.0D)
/*  93 */               .animationBehavior(Animations.FIST_DASH, 0.0F)
/*  94 */               .addNextBehavior(
/*  95 */                 CECombatBehaviors.Behavior.builder()
/*  96 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  97 */                 .withinDistance(0.0D, 5.0D)
/*  98 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/*  99 */                 .addNextBehavior(
/* 100 */                   CECombatBehaviors.Behavior.builder()
/* 101 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 102 */                   .withinDistance(0.0D, 5.0D)
/* 103 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 104 */                   .addNextBehavior(
/* 105 */                     CECombatBehaviors.Behavior.builder()
/* 106 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 107 */                     .withinDistance(0.0D, 5.0D)
/* 108 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 117 */       .addFirstBehavior(
/* 118 */         CECombatBehaviors.Behavior.builder()
/* 119 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 120 */         .withinDistance(0.0D, 3.0D)
/* 121 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 122 */         .addNextBehavior(
/* 123 */           CECombatBehaviors.Behavior.builder()
/* 124 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 125 */           .withinDistance(0.0D, 3.0D)
/* 126 */           .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 127 */           .addNextBehavior(
/* 128 */             CECombatBehaviors.Behavior.builder()
/* 129 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 130 */             .withinDistance(0.0D, 4.0D)
/* 131 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 132 */             .addNextBehavior(
/* 133 */               CECombatBehaviors.Behavior.builder()
/* 134 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 135 */               .withinDistance(0.0D, 4.0D)
/* 136 */               .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 137 */               .addNextBehavior(
/* 138 */                 CECombatBehaviors.Behavior.builder()
/* 139 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 140 */                 .withinDistance(0.0D, 5.0D)
/* 141 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 142 */                 .addNextBehavior(
/* 143 */                   CECombatBehaviors.Behavior.builder()
/* 144 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 145 */                   .withinDistance(0.0D, 5.0D)
/* 146 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       .addFirstBehavior(
/* 155 */         CECombatBehaviors.Behavior.builder()
/* 156 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 157 */         .withinDistance(0.0D, 3.0D)
/* 158 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 159 */         .addNextBehavior(
/* 160 */           CECombatBehaviors.Behavior.builder()
/* 161 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 162 */           .withinDistance(0.0D, 3.0D)
/* 163 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 164 */           .addNextBehavior(
/* 165 */             CECombatBehaviors.Behavior.builder()
/* 166 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 167 */             .withinDistance(0.0D, 4.0D)
/* 168 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 169 */             .addNextBehavior(
/* 170 */               CECombatBehaviors.Behavior.builder()
/* 171 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 172 */               .withinDistance(0.0D, 4.0D)
/* 173 */               .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 174 */               .addNextBehavior(
/* 175 */                 CECombatBehaviors.Behavior.builder()
/* 176 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 177 */                 .withinDistance(0.0D, 5.0D)
/* 178 */                 .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 179 */                 .addNextBehavior(
/* 180 */                   CECombatBehaviors.Behavior.builder()
/* 181 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 182 */                   .withinDistance(0.0D, 5.0D)
/* 183 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       .addFirstBehavior(
/* 192 */         CECombatBehaviors.Behavior.builder()
/* 193 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 194 */         .withinDistance(0.0D, 3.0D)
/* 195 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 196 */         .addNextBehavior(
/* 197 */           CECombatBehaviors.Behavior.builder()
/* 198 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 199 */           .withinDistance(0.0D, 3.0D)
/* 200 */           .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 201 */           .addNextBehavior(
/* 202 */             CECombatBehaviors.Behavior.builder()
/* 203 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 204 */             .withinDistance(0.0D, 4.0D)
/* 205 */             .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 206 */             .addNextBehavior(
/* 207 */               CECombatBehaviors.Behavior.builder()
/* 208 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 209 */               .withinDistance(0.0D, 4.0D)
/* 210 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 211 */               .addNextBehavior(
/* 212 */                 CECombatBehaviors.Behavior.builder()
/* 213 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 214 */                 .withinDistance(0.0D, 5.0D)
/* 215 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 216 */                 .addNextBehavior(
/* 217 */                   CECombatBehaviors.Behavior.builder()
/* 218 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 219 */                   .withinDistance(0.0D, 5.0D)
/* 220 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 228 */       .addFirstBehavior(
/* 229 */         CECombatBehaviors.Behavior.builder()
/* 230 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 231 */         .withinDistance(0.0D, 3.0D)
/* 232 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 233 */         .addNextBehavior(
/* 234 */           CECombatBehaviors.Behavior.builder()
/* 235 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 236 */           .withinDistance(0.0D, 3.0D)
/* 237 */           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 238 */           .addNextBehavior(
/* 239 */             CECombatBehaviors.Behavior.builder()
/* 240 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 241 */             .withinDistance(0.0D, 4.0D)
/* 242 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 243 */             .addNextBehavior(
/* 244 */               CECombatBehaviors.Behavior.builder()
/* 245 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 246 */               .withinDistance(0.0D, 4.0D)
/* 247 */               .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F)
/* 248 */               .addNextBehavior(
/* 249 */                 CECombatBehaviors.Behavior.builder()
/* 250 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 251 */                 .withinDistance(0.0D, 5.0D)
/* 252 */                 .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 253 */                 .addNextBehavior(
/* 254 */                   CECombatBehaviors.Behavior.builder()
/* 255 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 256 */                   .withinDistance(0.0D, 5.0D)
/* 257 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 258 */                   .addNextBehavior(
/* 259 */                     CECombatBehaviors.Behavior.builder()
/* 260 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 261 */                     .withinDistance(0.0D, 5.0D)
/* 262 */                     .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 271 */       .addFirstBehavior(
/* 272 */         CECombatBehaviors.Behavior.builder()
/* 273 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 274 */         .withinDistance(0.0D, 3.0D)
/* 275 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 276 */         .addNextBehavior(
/* 277 */           CECombatBehaviors.Behavior.builder()
/* 278 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 279 */           .withinDistance(0.0D, 3.0D)
/* 280 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 281 */           .addNextBehavior(
/* 282 */             CECombatBehaviors.Behavior.builder()
/* 283 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 284 */             .withinDistance(0.0D, 4.0D)
/* 285 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 286 */             .addNextBehavior(
/* 287 */               CECombatBehaviors.Behavior.builder()
/* 288 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 289 */               .withinDistance(0.0D, 4.0D)
/* 290 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 291 */               .addNextBehavior(
/* 292 */                 CECombatBehaviors.Behavior.builder()
/* 293 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 294 */                 .withinDistance(0.0D, 5.0D)
/* 295 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 296 */                 .addNextBehavior(
/* 297 */                   CECombatBehaviors.Behavior.builder()
/* 298 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 299 */                   .withinDistance(0.0D, 5.0D)
/* 300 */                   .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 301 */                   .addNextBehavior(
/* 302 */                     CECombatBehaviors.Behavior.builder()
/* 303 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 304 */                     .withinDistance(0.0D, 5.0D)
/* 305 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 314 */       .addFirstBehavior(
/* 315 */         CECombatBehaviors.Behavior.builder()
/* 316 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 317 */         .withinDistance(0.0D, 3.0D)
/* 318 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 319 */         .addNextBehavior(
/* 320 */           CECombatBehaviors.Behavior.builder()
/* 321 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 322 */           .withinDistance(0.0D, 3.0D)
/* 323 */           .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 324 */           .addNextBehavior(
/* 325 */             CECombatBehaviors.Behavior.builder()
/* 326 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 327 */             .withinDistance(0.0D, 4.0D)
/* 328 */             .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 329 */             .addNextBehavior(
/* 330 */               CECombatBehaviors.Behavior.builder()
/* 331 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 332 */               .withinDistance(0.0D, 4.0D)
/* 333 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 334 */               .addNextBehavior(
/* 335 */                 CECombatBehaviors.Behavior.builder()
/* 336 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 337 */                 .withinDistance(0.0D, 5.0D)
/* 338 */                 .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)
/* 339 */                 .addNextBehavior(
/* 340 */                   CECombatBehaviors.Behavior.builder()
/* 341 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 342 */                   .withinDistance(0.0D, 5.0D)
/* 343 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 351 */       .addFirstBehavior(
/* 352 */         CECombatBehaviors.Behavior.builder()
/* 353 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 354 */         .withinDistance(0.0D, 3.0D)
/* 355 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 356 */         .addNextBehavior(
/* 357 */           CECombatBehaviors.Behavior.builder()
/* 358 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 359 */           .withinDistance(0.0D, 3.0D)
/* 360 */           .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 361 */           .addNextBehavior(
/* 362 */             CECombatBehaviors.Behavior.builder()
/* 363 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 364 */             .withinDistance(0.0D, 4.0D)
/* 365 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 366 */             .addNextBehavior(
/* 367 */               CECombatBehaviors.Behavior.builder()
/* 368 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 369 */               .withinDistance(0.0D, 4.0D)
/* 370 */               .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 371 */               .addNextBehavior(
/* 372 */                 CECombatBehaviors.Behavior.builder()
/* 373 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 374 */                 .withinDistance(0.0D, 5.0D)
/* 375 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 376 */                 .addNextBehavior(
/* 377 */                   CECombatBehaviors.Behavior.builder()
/* 378 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 379 */                   .withinDistance(0.0D, 5.0D)
/* 380 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 381 */                   .addNextBehavior(
/* 382 */                     CECombatBehaviors.Behavior.builder()
/* 383 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 384 */                     .withinDistance(0.0D, 5.0D)
/* 385 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 394 */       .addFirstBehavior(
/* 395 */         CECombatBehaviors.Behavior.builder()
/* 396 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 397 */         .withinDistance(0.0D, 3.0D)
/* 398 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 399 */         .addNextBehavior(
/* 400 */           CECombatBehaviors.Behavior.builder()
/* 401 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 402 */           .withinDistance(0.0D, 3.0D)
/* 403 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 404 */           .addNextBehavior(
/* 405 */             CECombatBehaviors.Behavior.builder()
/* 406 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 407 */             .withinDistance(0.0D, 4.0D)
/* 408 */             .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 409 */             .addNextBehavior(
/* 410 */               CECombatBehaviors.Behavior.builder()
/* 411 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 412 */               .withinDistance(0.0D, 4.0D)
/* 413 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 414 */               .addNextBehavior(
/* 415 */                 CECombatBehaviors.Behavior.builder()
/* 416 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 417 */                 .withinDistance(0.0D, 5.0D)
/* 418 */                 .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 419 */                 .addNextBehavior(
/* 420 */                   CECombatBehaviors.Behavior.builder()
/* 421 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 422 */                   .withinDistance(0.0D, 5.0D)
/* 423 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 431 */       .addFirstBehavior(
/* 432 */         CECombatBehaviors.Behavior.builder()
/* 433 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 434 */         .withinDistance(0.0D, 3.0D)
/* 435 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 436 */         .addNextBehavior(
/* 437 */           CECombatBehaviors.Behavior.builder()
/* 438 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 439 */           .withinDistance(0.0D, 3.0D)
/* 440 */           .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F)
/* 441 */           .addNextBehavior(
/* 442 */             CECombatBehaviors.Behavior.builder()
/* 443 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 444 */             .withinDistance(0.0D, 4.0D)
/* 445 */             .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 446 */             .addNextBehavior(
/* 447 */               CECombatBehaviors.Behavior.builder()
/* 448 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 449 */               .withinDistance(0.0D, 4.0D)
/* 450 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 451 */               .addNextBehavior(
/* 452 */                 CECombatBehaviors.Behavior.builder()
/* 453 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 454 */                 .withinDistance(0.0D, 5.0D)
/* 455 */                 .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 456 */                 .addNextBehavior(
/* 457 */                   CECombatBehaviors.Behavior.builder()
/* 458 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 459 */                   .withinDistance(0.0D, 5.0D)
/* 460 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 461 */                   .addNextBehavior(
/* 462 */                     CECombatBehaviors.Behavior.builder()
/* 463 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 464 */                     .withinDistance(0.0D, 5.0D)
/* 465 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 474 */       .addFirstBehavior(
/* 475 */         CECombatBehaviors.Behavior.builder()
/* 476 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 477 */         .withinDistance(0.0D, 3.0D)
/* 478 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 479 */         .addNextBehavior(
/* 480 */           CECombatBehaviors.Behavior.builder()
/* 481 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 482 */           .withinDistance(0.0D, 3.0D)
/* 483 */           .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 484 */           .addNextBehavior(
/* 485 */             CECombatBehaviors.Behavior.builder()
/* 486 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 487 */             .withinDistance(0.0D, 4.0D)
/* 488 */             .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 489 */             .addNextBehavior(
/* 490 */               CECombatBehaviors.Behavior.builder()
/* 491 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 492 */               .withinDistance(0.0D, 4.0D)
/* 493 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 494 */               .addNextBehavior(
/* 495 */                 CECombatBehaviors.Behavior.builder()
/* 496 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 497 */                 .withinDistance(0.0D, 5.0D)
/* 498 */                 .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 499 */                 .addNextBehavior(
/* 500 */                   CECombatBehaviors.Behavior.builder()
/* 501 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 502 */                   .withinDistance(0.0D, 5.0D)
/* 503 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 504 */                   .addNextBehavior(
/* 505 */                     CECombatBehaviors.Behavior.builder()
/* 506 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 507 */                     .withinDistance(0.0D, 5.0D)
/* 508 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 517 */       .addFirstBehavior(
/* 518 */         CECombatBehaviors.Behavior.builder()
/* 519 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 520 */         .withinDistance(0.0D, 3.0D)
/* 521 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 522 */         .addNextBehavior(
/* 523 */           CECombatBehaviors.Behavior.builder()
/* 524 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 525 */           .withinDistance(0.0D, 3.0D)
/* 526 */           .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 527 */           .addNextBehavior(
/* 528 */             CECombatBehaviors.Behavior.builder()
/* 529 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 530 */             .withinDistance(0.0D, 4.0D)
/* 531 */             .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 532 */             .addNextBehavior(
/* 533 */               CECombatBehaviors.Behavior.builder()
/* 534 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 535 */               .withinDistance(0.0D, 4.0D)
/* 536 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 537 */               .addNextBehavior(
/* 538 */                 CECombatBehaviors.Behavior.builder()
/* 539 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 540 */                 .withinDistance(0.0D, 5.0D)
/* 541 */                 .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 542 */                 .addNextBehavior(
/* 543 */                   CECombatBehaviors.Behavior.builder()
/* 544 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 545 */                   .withinDistance(0.0D, 5.0D)
/* 546 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 547 */                   .addNextBehavior(
/* 548 */                     CECombatBehaviors.Behavior.builder()
/* 549 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 550 */                     .withinDistance(0.0D, 5.0D)
/* 551 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 560 */       .addFirstBehavior(
/* 561 */         CECombatBehaviors.Behavior.builder()
/* 562 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 563 */         .withinDistance(0.0D, 3.0D)
/* 564 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 565 */         .addNextBehavior(
/* 566 */           CECombatBehaviors.Behavior.builder()
/* 567 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 568 */           .withinDistance(0.0D, 3.0D)
/* 569 */           .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)
/* 570 */           .addNextBehavior(
/* 571 */             CECombatBehaviors.Behavior.builder()
/* 572 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 573 */             .withinDistance(0.0D, 4.0D)
/* 574 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 575 */             .addNextBehavior(
/* 576 */               CECombatBehaviors.Behavior.builder()
/* 577 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 578 */               .withinDistance(0.0D, 4.0D)
/* 579 */               .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 580 */               .addNextBehavior(
/* 581 */                 CECombatBehaviors.Behavior.builder()
/* 582 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 583 */                 .withinDistance(0.0D, 5.0D)
/* 584 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 585 */                 .addNextBehavior(
/* 586 */                   CECombatBehaviors.Behavior.builder()
/* 587 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 588 */                   .withinDistance(0.0D, 5.0D)
/* 589 */                   .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 590 */                   .addNextBehavior(
/* 591 */                     CECombatBehaviors.Behavior.builder()
/* 592 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 593 */                     .withinDistance(0.0D, 5.0D)
/* 594 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 603 */       .addFirstBehavior(
/* 604 */         CECombatBehaviors.Behavior.builder()
/* 605 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 606 */         .withinDistance(0.0D, 3.0D)
/* 607 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 608 */         .addNextBehavior(
/* 609 */           CECombatBehaviors.Behavior.builder()
/* 610 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 611 */           .withinDistance(0.0D, 3.0D)
/* 612 */           .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 613 */           .addNextBehavior(
/* 614 */             CECombatBehaviors.Behavior.builder()
/* 615 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 616 */             .withinDistance(0.0D, 4.0D)
/* 617 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 618 */             .addNextBehavior(
/* 619 */               CECombatBehaviors.Behavior.builder()
/* 620 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 621 */               .withinDistance(0.0D, 4.0D)
/* 622 */               .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 623 */               .addNextBehavior(
/* 624 */                 CECombatBehaviors.Behavior.builder()
/* 625 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 626 */                 .withinDistance(0.0D, 5.0D)
/* 627 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 628 */                 .addNextBehavior(
/* 629 */                   CECombatBehaviors.Behavior.builder()
/* 630 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 631 */                   .withinDistance(0.0D, 5.0D)
/* 632 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 640 */       .addFirstBehavior(
/* 641 */         CECombatBehaviors.Behavior.builder()
/* 642 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 643 */         .withinDistance(0.0D, 3.0D)
/* 644 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 645 */         .addNextBehavior(
/* 646 */           CECombatBehaviors.Behavior.builder()
/* 647 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 648 */           .withinDistance(0.0D, 3.0D)
/* 649 */           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 650 */           .addNextBehavior(
/* 651 */             CECombatBehaviors.Behavior.builder()
/* 652 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 653 */             .withinDistance(0.0D, 4.0D)
/* 654 */             .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 655 */             .addNextBehavior(
/* 656 */               CECombatBehaviors.Behavior.builder()
/* 657 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 658 */               .withinDistance(0.0D, 4.0D)
/* 659 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 660 */               .addNextBehavior(
/* 661 */                 CECombatBehaviors.Behavior.builder()
/* 662 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 663 */                 .withinDistance(0.0D, 5.0D)
/* 664 */                 .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 665 */                 .addNextBehavior(
/* 666 */                   CECombatBehaviors.Behavior.builder()
/* 667 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 668 */                   .withinDistance(0.0D, 5.0D)
/* 669 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 670 */                   .addNextBehavior(
/* 671 */                     CECombatBehaviors.Behavior.builder()
/* 672 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 673 */                     .withinDistance(0.0D, 5.0D)
/* 674 */                     .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 683 */     .newBehaviorRoot(
/* 684 */       CECombatBehaviors.BehaviorRoot.builder()
/* 685 */       .priority(1.0D)
/* 686 */       .weight(20.0D)
/* 687 */       .maxCooldown(100)
/* 688 */       .addFirstBehavior(
/* 689 */         CECombatBehaviors.Behavior.builder()
/* 690 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 691 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 692 */         .withinDistance(0.0D, 3.0D)
/* 693 */         .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 694 */         .addNextBehavior(
/* 695 */           CECombatBehaviors.Behavior.builder()
/* 696 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 697 */           .custom(CombatCommon::canAttackWhileNotHealing)
/* 698 */           .withinDistance(0.0D, 3.0D)
/* 699 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 700 */           .addNextBehavior(
/* 701 */             CECombatBehaviors.Behavior.builder()
/* 702 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 703 */             .custom(CombatCommon::canAttackWhileNotHealing)
/* 704 */             .withinDistance(0.0D, 3.0D)
/* 705 */             .animationBehavior(AVAnimations.FIST_DASH, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 710 */     .newBehaviorRoot(
/* 711 */       CECombatBehaviors.BehaviorRoot.builder()
/* 712 */       .priority(1.0D)
/* 713 */       .weight(10.0D)
/* 714 */       .maxCooldown(100)
/* 715 */       .addFirstBehavior(
/* 716 */         CECombatBehaviors.Behavior.builder()
/* 717 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 718 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 719 */         .withinDistance(0.0D, 3.0D)
/* 720 */         .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F))
/*     */       
/* 722 */       .addFirstBehavior(
/* 723 */         CECombatBehaviors.Behavior.builder()
/* 724 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 725 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 726 */         .withinDistance(0.0D, 3.0D)
/* 727 */         .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F))
/*     */       
/* 729 */       .addFirstBehavior(
/* 730 */         CECombatBehaviors.Behavior.builder()
/* 731 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 732 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 733 */         .withinDistance(0.0D, 3.0D)
/* 734 */         .animationBehavior(Animations.FIST_DASH, 0.0F))
/*     */       
/* 736 */       .addFirstBehavior(
/* 737 */         CECombatBehaviors.Behavior.builder()
/* 738 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 739 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 740 */         .withinDistance(0.0D, 3.0D)
/* 741 */         .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F))
/*     */       
/* 743 */       .addFirstBehavior(
/* 744 */         CECombatBehaviors.Behavior.builder()
/* 745 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 746 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 747 */         .withinDistance(0.0D, 3.0D)
/* 748 */         .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)))
/*     */ 
/*     */     
/* 751 */     .newBehaviorRoot(
/* 752 */       CECombatBehaviors.BehaviorRoot.builder()
/* 753 */       .priority(1.0D)
/* 754 */       .weight(2.0D)
/* 755 */       .maxCooldown(100)
/* 756 */       .addFirstBehavior(
/* 757 */         CECombatBehaviors.Behavior.builder()
/* 758 */         .withinDistance(0.0D, 3.0D)
/* 759 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 760 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 761 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 763 */       .addFirstBehavior(
/* 764 */         CECombatBehaviors.Behavior.builder()
/* 765 */         .withinDistance(0.0D, 3.0D)
/* 766 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 767 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 768 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 770 */       .addFirstBehavior(
/* 771 */         CECombatBehaviors.Behavior.builder()
/* 772 */         .withinDistance(0.0D, 3.0D)
/* 773 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 774 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 775 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 777 */       .addFirstBehavior(
/* 778 */         CECombatBehaviors.Behavior.builder()
/* 779 */         .withinDistance(0.0D, 3.0D)
/* 780 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 781 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 782 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 784 */       .addFirstBehavior(
/* 785 */         CECombatBehaviors.Behavior.builder()
/* 786 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 787 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 788 */         .withinDistance(0.0D, 3.0D)
/* 789 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 791 */       .addFirstBehavior(
/* 792 */         CECombatBehaviors.Behavior.builder()
/* 793 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 794 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 795 */         .withinDistance(0.0D, 3.0D)
/* 796 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 798 */       .addFirstBehavior(
/* 799 */         CECombatBehaviors.Behavior.builder()
/* 800 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 801 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 802 */         .withinDistance(0.0D, 3.0D)
/* 803 */         .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)))
/*     */ 
/*     */     
/* 806 */     .newBehaviorRoot(
/* 807 */       CECombatBehaviors.BehaviorRoot.builder()
/* 808 */       .priority(1.0D)
/* 809 */       .weight(10.0D)
/* 810 */       .addFirstBehavior(
/* 811 */         CECombatBehaviors.Behavior.builder()
/* 812 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 813 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 814 */         .withinDistance(0.0D, 3.0D)
/* 815 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 817 */       .addFirstBehavior(
/* 818 */         CECombatBehaviors.Behavior.builder()
/* 819 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 820 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 821 */         .withinDistance(0.0D, 3.0D)
/* 822 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*     */ 
/*     */     
/* 825 */     .newBehaviorRoot(
/* 826 */       CECombatBehaviors.BehaviorRoot.builder()
/* 827 */       .priority(1.0D)
/* 828 */       .weight(40.0D)
/* 829 */       .maxCooldown(160)
/* 830 */       .addFirstBehavior(
/* 831 */         CECombatBehaviors.Behavior.builder()
/* 832 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 833 */         .custom(CombatCommon::canJump)
/* 834 */         .withinDistance(5.0D, 14.0D)
/* 835 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 836 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\JevFist.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */