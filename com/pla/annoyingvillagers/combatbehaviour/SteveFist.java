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
/*     */ public class SteveFist
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
/*  30 */       .priority(3.0D)
/*  31 */       .weight(1000.0D)
/*  32 */       .maxCooldown(0)
/*  33 */       .addFirstBehavior(
/*  34 */         CECombatBehaviors.Behavior.builder()
/*  35 */         .custom(CombatCommon::canEscape)
/*  36 */         .withinDistance(0.0D, 8.0D)
/*  37 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  38 */         .addExBehavior(CombatCommon::performEscapeRunAway))
/*     */       
/*  40 */       .addFirstBehavior(
/*  41 */         CECombatBehaviors.Behavior.builder()
/*  42 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  43 */         .custom(CombatCommon::canEscape)
/*  44 */         .withinDistance(0.0D, 48.0D)
/*  45 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  46 */         .addExBehavior(CombatCommon::swapToMelee)))
/*     */ 
/*     */     
/*  49 */     .newBehaviorRoot(
/*  50 */       CECombatBehaviors.BehaviorRoot.builder()
/*  51 */       .priority(3.0D)
/*  52 */       .weight(1000.0D)
/*  53 */       .maxCooldown(0)
/*  54 */       .addFirstBehavior(
/*  55 */         CECombatBehaviors.Behavior.builder()
/*  56 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  57 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  58 */         .custom(CombatCommon::isWrongWeapon)
/*  59 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  60 */         .addExBehavior(CombatCommon::swapToMelee)))
/*     */ 
/*     */     
/*  63 */     .newBehaviorRoot(
/*  64 */       CECombatBehaviors.BehaviorRoot.builder()
/*  65 */       .priority(3.0D)
/*  66 */       .weight(100.0D)
/*  67 */       .maxCooldown(120)
/*  68 */       .addFirstBehavior(
/*  69 */         CECombatBehaviors.Behavior.builder()
/*  70 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  71 */         .custom(CombatCommon::canSwitchWeapon)
/*  72 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  73 */         .addExBehavior(CombatCommon::switchWeapon))
/*     */       
/*  75 */       .addFirstBehavior(
/*  76 */         CECombatBehaviors.Behavior.builder()
/*  77 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  78 */         .custom(CombatCommon::canSwitchWeapon)
/*  79 */         .withinDistance(1.0D, 14.0D)
/*  80 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  81 */         .addExBehavior(CombatCommon::switchWeapon)))
/*     */ 
/*     */     
/*  84 */     .newBehaviorRoot(
/*  85 */       CECombatBehaviors.BehaviorRoot.builder()
/*  86 */       .priority(2.0D)
/*  87 */       .weight(70.0D)
/*  88 */       .maxCooldown(0)
/*  89 */       .addFirstBehavior(
/*  90 */         CECombatBehaviors.Behavior.builder()
/*  91 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  92 */         .custom(CombatCommon::canPerformEating)
/*  93 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  94 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  97 */     .newBehaviorRoot(
/*  98 */       CECombatBehaviors.BehaviorRoot.builder()
/*  99 */       .priority(2.0D)
/* 100 */       .weight(100.0D)
/* 101 */       .maxCooldown(120)
/* 102 */       .addFirstBehavior(
/* 103 */         CECombatBehaviors.Behavior.builder()
/* 104 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 105 */         .custom(CombatCommon::canSwapToBow)
/* 106 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 107 */         .withinDistance(7.0D, 14.0D)
/* 108 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 109 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/* 111 */       .addFirstBehavior(
/* 112 */         CECombatBehaviors.Behavior.builder()
/* 113 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 114 */         .custom(CombatCommon::canSwapToBow)
/* 115 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 116 */         .withinDistance(7.0D, 14.0D)
/* 117 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 118 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/* 121 */     .newBehaviorRoot(
/* 122 */       CECombatBehaviors.BehaviorRoot.builder()
/* 123 */       .priority(2.0D)
/* 124 */       .weight(80.0D)
/* 125 */       .maxCooldown(120)
/* 126 */       .addFirstBehavior(
/* 127 */         CECombatBehaviors.Behavior.builder()
/* 128 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 129 */         .custom(CombatCommon::canThrowEnderPearl)
/* 130 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 131 */         .withinDistance(7.0D, 48.0D)
/* 132 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 133 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/* 136 */     .newBehaviorRoot(
/* 137 */       CECombatBehaviors.BehaviorRoot.builder()
/* 138 */       .priority(1.0D)
/* 139 */       .weight(40.0D)
/* 140 */       .maxCooldown(20)
/* 141 */       .addFirstBehavior(
/* 142 */         CECombatBehaviors.Behavior.builder()
/* 143 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 144 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 145 */         .withinDistance(0.0D, 3.0D)
/* 146 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 147 */         .addNextBehavior(
/* 148 */           CECombatBehaviors.Behavior.builder()
/* 149 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 150 */           .custom(CombatCommon::canAttackWhileNotHealing)
/* 151 */           .withinDistance(0.0D, 3.0D)
/* 152 */           .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 153 */           .addNextBehavior(
/* 154 */             CECombatBehaviors.Behavior.builder()
/* 155 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 156 */             .custom(CombatCommon::canAttackWhileNotHealing)
/* 157 */             .withinDistance(0.0D, 3.0D)
/* 158 */             .animationBehavior(Animations.FIST_AUTO3, 0.0F))))
/*     */ 
/*     */ 
/*     */       
/* 162 */       .addFirstBehavior(
/* 163 */         CECombatBehaviors.Behavior.builder()
/* 164 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 165 */         .withinDistance(0.0D, 3.0D)
/* 166 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 167 */         .addNextBehavior(
/* 168 */           CECombatBehaviors.Behavior.builder()
/* 169 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 170 */           .withinDistance(0.0D, 3.0D)
/* 171 */           .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 172 */           .addNextBehavior(
/* 173 */             CECombatBehaviors.Behavior.builder()
/* 174 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 175 */             .withinDistance(0.0D, 4.0D)
/* 176 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 177 */             .addNextBehavior(
/* 178 */               CECombatBehaviors.Behavior.builder()
/* 179 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 180 */               .withinDistance(0.0D, 4.0D)
/* 181 */               .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 182 */               .addNextBehavior(
/* 183 */                 CECombatBehaviors.Behavior.builder()
/* 184 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 185 */                 .withinDistance(0.0D, 5.0D)
/* 186 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 187 */                 .addNextBehavior(
/* 188 */                   CECombatBehaviors.Behavior.builder()
/* 189 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 190 */                   .withinDistance(0.0D, 5.0D)
/* 191 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 192 */                   .addNextBehavior(
/* 193 */                     CECombatBehaviors.Behavior.builder()
/* 194 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 195 */                     .withinDistance(0.0D, 5.0D)
/* 196 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 205 */       .addFirstBehavior(
/* 206 */         CECombatBehaviors.Behavior.builder()
/* 207 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 208 */         .withinDistance(0.0D, 3.0D)
/* 209 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 210 */         .addNextBehavior(
/* 211 */           CECombatBehaviors.Behavior.builder()
/* 212 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 213 */           .withinDistance(0.0D, 3.0D)
/* 214 */           .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 215 */           .addNextBehavior(
/* 216 */             CECombatBehaviors.Behavior.builder()
/* 217 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 218 */             .withinDistance(0.0D, 4.0D)
/* 219 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 220 */             .addNextBehavior(
/* 221 */               CECombatBehaviors.Behavior.builder()
/* 222 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 223 */               .withinDistance(0.0D, 4.0D)
/* 224 */               .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 225 */               .addNextBehavior(
/* 226 */                 CECombatBehaviors.Behavior.builder()
/* 227 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 228 */                 .withinDistance(0.0D, 5.0D)
/* 229 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 230 */                 .addNextBehavior(
/* 231 */                   CECombatBehaviors.Behavior.builder()
/* 232 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 233 */                   .withinDistance(0.0D, 5.0D)
/* 234 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 242 */       .addFirstBehavior(
/* 243 */         CECombatBehaviors.Behavior.builder()
/* 244 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 245 */         .withinDistance(0.0D, 3.0D)
/* 246 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 247 */         .addNextBehavior(
/* 248 */           CECombatBehaviors.Behavior.builder()
/* 249 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 250 */           .withinDistance(0.0D, 3.0D)
/* 251 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 252 */           .addNextBehavior(
/* 253 */             CECombatBehaviors.Behavior.builder()
/* 254 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 255 */             .withinDistance(0.0D, 4.0D)
/* 256 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 257 */             .addNextBehavior(
/* 258 */               CECombatBehaviors.Behavior.builder()
/* 259 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 260 */               .withinDistance(0.0D, 4.0D)
/* 261 */               .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 262 */               .addNextBehavior(
/* 263 */                 CECombatBehaviors.Behavior.builder()
/* 264 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 265 */                 .withinDistance(0.0D, 5.0D)
/* 266 */                 .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 267 */                 .addNextBehavior(
/* 268 */                   CECombatBehaviors.Behavior.builder()
/* 269 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 270 */                   .withinDistance(0.0D, 5.0D)
/* 271 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 279 */       .addFirstBehavior(
/* 280 */         CECombatBehaviors.Behavior.builder()
/* 281 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 282 */         .withinDistance(0.0D, 3.0D)
/* 283 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 284 */         .addNextBehavior(
/* 285 */           CECombatBehaviors.Behavior.builder()
/* 286 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 287 */           .withinDistance(0.0D, 3.0D)
/* 288 */           .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 289 */           .addNextBehavior(
/* 290 */             CECombatBehaviors.Behavior.builder()
/* 291 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 292 */             .withinDistance(0.0D, 4.0D)
/* 293 */             .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 294 */             .addNextBehavior(
/* 295 */               CECombatBehaviors.Behavior.builder()
/* 296 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 297 */               .withinDistance(0.0D, 4.0D)
/* 298 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 299 */               .addNextBehavior(
/* 300 */                 CECombatBehaviors.Behavior.builder()
/* 301 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 302 */                 .withinDistance(0.0D, 5.0D)
/* 303 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 304 */                 .addNextBehavior(
/* 305 */                   CECombatBehaviors.Behavior.builder()
/* 306 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
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
/* 318 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 319 */         .withinDistance(0.0D, 3.0D)
/* 320 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 321 */         .addNextBehavior(
/* 322 */           CECombatBehaviors.Behavior.builder()
/* 323 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 324 */           .withinDistance(0.0D, 3.0D)
/* 325 */           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 326 */           .addNextBehavior(
/* 327 */             CECombatBehaviors.Behavior.builder()
/* 328 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 329 */             .withinDistance(0.0D, 4.0D)
/* 330 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 331 */             .addNextBehavior(
/* 332 */               CECombatBehaviors.Behavior.builder()
/* 333 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 334 */               .withinDistance(0.0D, 4.0D)
/* 335 */               .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F)
/* 336 */               .addNextBehavior(
/* 337 */                 CECombatBehaviors.Behavior.builder()
/* 338 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 339 */                 .withinDistance(0.0D, 5.0D)
/* 340 */                 .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 341 */                 .addNextBehavior(
/* 342 */                   CECombatBehaviors.Behavior.builder()
/* 343 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 344 */                   .withinDistance(0.0D, 5.0D)
/* 345 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 346 */                   .addNextBehavior(
/* 347 */                     CECombatBehaviors.Behavior.builder()
/* 348 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 349 */                     .withinDistance(0.0D, 5.0D)
/* 350 */                     .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F))))))))
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
/* 361 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 362 */         .withinDistance(0.0D, 3.0D)
/* 363 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 364 */         .addNextBehavior(
/* 365 */           CECombatBehaviors.Behavior.builder()
/* 366 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 367 */           .withinDistance(0.0D, 3.0D)
/* 368 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 369 */           .addNextBehavior(
/* 370 */             CECombatBehaviors.Behavior.builder()
/* 371 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 372 */             .withinDistance(0.0D, 4.0D)
/* 373 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 374 */             .addNextBehavior(
/* 375 */               CECombatBehaviors.Behavior.builder()
/* 376 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 377 */               .withinDistance(0.0D, 4.0D)
/* 378 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 379 */               .addNextBehavior(
/* 380 */                 CECombatBehaviors.Behavior.builder()
/* 381 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 382 */                 .withinDistance(0.0D, 5.0D)
/* 383 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 384 */                 .addNextBehavior(
/* 385 */                   CECombatBehaviors.Behavior.builder()
/* 386 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 387 */                   .withinDistance(0.0D, 5.0D)
/* 388 */                   .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 389 */                   .addNextBehavior(
/* 390 */                     CECombatBehaviors.Behavior.builder()
/* 391 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
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
/* 404 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 405 */         .withinDistance(0.0D, 3.0D)
/* 406 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 407 */         .addNextBehavior(
/* 408 */           CECombatBehaviors.Behavior.builder()
/* 409 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 410 */           .withinDistance(0.0D, 3.0D)
/* 411 */           .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 412 */           .addNextBehavior(
/* 413 */             CECombatBehaviors.Behavior.builder()
/* 414 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 415 */             .withinDistance(0.0D, 4.0D)
/* 416 */             .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 417 */             .addNextBehavior(
/* 418 */               CECombatBehaviors.Behavior.builder()
/* 419 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 420 */               .withinDistance(0.0D, 4.0D)
/* 421 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 422 */               .addNextBehavior(
/* 423 */                 CECombatBehaviors.Behavior.builder()
/* 424 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 425 */                 .withinDistance(0.0D, 5.0D)
/* 426 */                 .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)
/* 427 */                 .addNextBehavior(
/* 428 */                   CECombatBehaviors.Behavior.builder()
/* 429 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 430 */                   .withinDistance(0.0D, 5.0D)
/* 431 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 439 */       .addFirstBehavior(
/* 440 */         CECombatBehaviors.Behavior.builder()
/* 441 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 442 */         .withinDistance(0.0D, 3.0D)
/* 443 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 444 */         .addNextBehavior(
/* 445 */           CECombatBehaviors.Behavior.builder()
/* 446 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 447 */           .withinDistance(0.0D, 3.0D)
/* 448 */           .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 449 */           .addNextBehavior(
/* 450 */             CECombatBehaviors.Behavior.builder()
/* 451 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 452 */             .withinDistance(0.0D, 4.0D)
/* 453 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 454 */             .addNextBehavior(
/* 455 */               CECombatBehaviors.Behavior.builder()
/* 456 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 457 */               .withinDistance(0.0D, 4.0D)
/* 458 */               .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 459 */               .addNextBehavior(
/* 460 */                 CECombatBehaviors.Behavior.builder()
/* 461 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 462 */                 .withinDistance(0.0D, 5.0D)
/* 463 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 464 */                 .addNextBehavior(
/* 465 */                   CECombatBehaviors.Behavior.builder()
/* 466 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 467 */                   .withinDistance(0.0D, 5.0D)
/* 468 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 469 */                   .addNextBehavior(
/* 470 */                     CECombatBehaviors.Behavior.builder()
/* 471 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 472 */                     .withinDistance(0.0D, 5.0D)
/* 473 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
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
/* 484 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 485 */         .withinDistance(0.0D, 3.0D)
/* 486 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 487 */         .addNextBehavior(
/* 488 */           CECombatBehaviors.Behavior.builder()
/* 489 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 490 */           .withinDistance(0.0D, 3.0D)
/* 491 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 492 */           .addNextBehavior(
/* 493 */             CECombatBehaviors.Behavior.builder()
/* 494 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 495 */             .withinDistance(0.0D, 4.0D)
/* 496 */             .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 497 */             .addNextBehavior(
/* 498 */               CECombatBehaviors.Behavior.builder()
/* 499 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 500 */               .withinDistance(0.0D, 4.0D)
/* 501 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 502 */               .addNextBehavior(
/* 503 */                 CECombatBehaviors.Behavior.builder()
/* 504 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 505 */                 .withinDistance(0.0D, 5.0D)
/* 506 */                 .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 507 */                 .addNextBehavior(
/* 508 */                   CECombatBehaviors.Behavior.builder()
/* 509 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 510 */                   .withinDistance(0.0D, 5.0D)
/* 511 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 519 */       .addFirstBehavior(
/* 520 */         CECombatBehaviors.Behavior.builder()
/* 521 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 522 */         .withinDistance(0.0D, 3.0D)
/* 523 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 524 */         .addNextBehavior(
/* 525 */           CECombatBehaviors.Behavior.builder()
/* 526 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 527 */           .withinDistance(0.0D, 3.0D)
/* 528 */           .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F)
/* 529 */           .addNextBehavior(
/* 530 */             CECombatBehaviors.Behavior.builder()
/* 531 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 532 */             .withinDistance(0.0D, 4.0D)
/* 533 */             .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 534 */             .addNextBehavior(
/* 535 */               CECombatBehaviors.Behavior.builder()
/* 536 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 537 */               .withinDistance(0.0D, 4.0D)
/* 538 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 539 */               .addNextBehavior(
/* 540 */                 CECombatBehaviors.Behavior.builder()
/* 541 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 542 */                 .withinDistance(0.0D, 5.0D)
/* 543 */                 .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 544 */                 .addNextBehavior(
/* 545 */                   CECombatBehaviors.Behavior.builder()
/* 546 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 547 */                   .withinDistance(0.0D, 5.0D)
/* 548 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 549 */                   .addNextBehavior(
/* 550 */                     CECombatBehaviors.Behavior.builder()
/* 551 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 552 */                     .withinDistance(0.0D, 5.0D)
/* 553 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 562 */       .addFirstBehavior(
/* 563 */         CECombatBehaviors.Behavior.builder()
/* 564 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 565 */         .withinDistance(0.0D, 3.0D)
/* 566 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 567 */         .addNextBehavior(
/* 568 */           CECombatBehaviors.Behavior.builder()
/* 569 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 570 */           .withinDistance(0.0D, 3.0D)
/* 571 */           .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 572 */           .addNextBehavior(
/* 573 */             CECombatBehaviors.Behavior.builder()
/* 574 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 575 */             .withinDistance(0.0D, 4.0D)
/* 576 */             .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 577 */             .addNextBehavior(
/* 578 */               CECombatBehaviors.Behavior.builder()
/* 579 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 580 */               .withinDistance(0.0D, 4.0D)
/* 581 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 582 */               .addNextBehavior(
/* 583 */                 CECombatBehaviors.Behavior.builder()
/* 584 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 585 */                 .withinDistance(0.0D, 5.0D)
/* 586 */                 .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 587 */                 .addNextBehavior(
/* 588 */                   CECombatBehaviors.Behavior.builder()
/* 589 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 590 */                   .withinDistance(0.0D, 5.0D)
/* 591 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 592 */                   .addNextBehavior(
/* 593 */                     CECombatBehaviors.Behavior.builder()
/* 594 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 595 */                     .withinDistance(0.0D, 5.0D)
/* 596 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 605 */       .addFirstBehavior(
/* 606 */         CECombatBehaviors.Behavior.builder()
/* 607 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 608 */         .withinDistance(0.0D, 3.0D)
/* 609 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 610 */         .addNextBehavior(
/* 611 */           CECombatBehaviors.Behavior.builder()
/* 612 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 613 */           .withinDistance(0.0D, 3.0D)
/* 614 */           .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 615 */           .addNextBehavior(
/* 616 */             CECombatBehaviors.Behavior.builder()
/* 617 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 618 */             .withinDistance(0.0D, 4.0D)
/* 619 */             .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 620 */             .addNextBehavior(
/* 621 */               CECombatBehaviors.Behavior.builder()
/* 622 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 623 */               .withinDistance(0.0D, 4.0D)
/* 624 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 625 */               .addNextBehavior(
/* 626 */                 CECombatBehaviors.Behavior.builder()
/* 627 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 628 */                 .withinDistance(0.0D, 5.0D)
/* 629 */                 .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 630 */                 .addNextBehavior(
/* 631 */                   CECombatBehaviors.Behavior.builder()
/* 632 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 633 */                   .withinDistance(0.0D, 5.0D)
/* 634 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 635 */                   .addNextBehavior(
/* 636 */                     CECombatBehaviors.Behavior.builder()
/* 637 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 638 */                     .withinDistance(0.0D, 5.0D)
/* 639 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 648 */       .addFirstBehavior(
/* 649 */         CECombatBehaviors.Behavior.builder()
/* 650 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 651 */         .withinDistance(0.0D, 3.0D)
/* 652 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 653 */         .addNextBehavior(
/* 654 */           CECombatBehaviors.Behavior.builder()
/* 655 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 656 */           .withinDistance(0.0D, 3.0D)
/* 657 */           .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)
/* 658 */           .addNextBehavior(
/* 659 */             CECombatBehaviors.Behavior.builder()
/* 660 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 661 */             .withinDistance(0.0D, 4.0D)
/* 662 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 663 */             .addNextBehavior(
/* 664 */               CECombatBehaviors.Behavior.builder()
/* 665 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 666 */               .withinDistance(0.0D, 4.0D)
/* 667 */               .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 668 */               .addNextBehavior(
/* 669 */                 CECombatBehaviors.Behavior.builder()
/* 670 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 671 */                 .withinDistance(0.0D, 5.0D)
/* 672 */                 .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 673 */                 .addNextBehavior(
/* 674 */                   CECombatBehaviors.Behavior.builder()
/* 675 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 676 */                   .withinDistance(0.0D, 5.0D)
/* 677 */                   .animationBehavior(Animations.FIST_DASH, 0.0F)
/* 678 */                   .addNextBehavior(
/* 679 */                     CECombatBehaviors.Behavior.builder()
/* 680 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 681 */                     .withinDistance(0.0D, 5.0D)
/* 682 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 691 */       .addFirstBehavior(
/* 692 */         CECombatBehaviors.Behavior.builder()
/* 693 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 694 */         .withinDistance(0.0D, 3.0D)
/* 695 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 696 */         .addNextBehavior(
/* 697 */           CECombatBehaviors.Behavior.builder()
/* 698 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 699 */           .withinDistance(0.0D, 3.0D)
/* 700 */           .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/* 701 */           .addNextBehavior(
/* 702 */             CECombatBehaviors.Behavior.builder()
/* 703 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 704 */             .withinDistance(0.0D, 4.0D)
/* 705 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 706 */             .addNextBehavior(
/* 707 */               CECombatBehaviors.Behavior.builder()
/* 708 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 709 */               .withinDistance(0.0D, 4.0D)
/* 710 */               .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/* 711 */               .addNextBehavior(
/* 712 */                 CECombatBehaviors.Behavior.builder()
/* 713 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 714 */                 .withinDistance(0.0D, 5.0D)
/* 715 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 716 */                 .addNextBehavior(
/* 717 */                   CECombatBehaviors.Behavior.builder()
/* 718 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 719 */                   .withinDistance(0.0D, 5.0D)
/* 720 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 728 */       .addFirstBehavior(
/* 729 */         CECombatBehaviors.Behavior.builder()
/* 730 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 731 */         .withinDistance(0.0D, 3.0D)
/* 732 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/* 733 */         .addNextBehavior(
/* 734 */           CECombatBehaviors.Behavior.builder()
/* 735 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 736 */           .withinDistance(0.0D, 3.0D)
/* 737 */           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 738 */           .addNextBehavior(
/* 739 */             CECombatBehaviors.Behavior.builder()
/* 740 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 741 */             .withinDistance(0.0D, 4.0D)
/* 742 */             .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/* 743 */             .addNextBehavior(
/* 744 */               CECombatBehaviors.Behavior.builder()
/* 745 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 746 */               .withinDistance(0.0D, 4.0D)
/* 747 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/* 748 */               .addNextBehavior(
/* 749 */                 CECombatBehaviors.Behavior.builder()
/* 750 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 751 */                 .withinDistance(0.0D, 5.0D)
/* 752 */                 .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/* 753 */                 .addNextBehavior(
/* 754 */                   CECombatBehaviors.Behavior.builder()
/* 755 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 756 */                   .withinDistance(0.0D, 5.0D)
/* 757 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/* 758 */                   .addNextBehavior(
/* 759 */                     CECombatBehaviors.Behavior.builder()
/* 760 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/* 761 */                     .withinDistance(0.0D, 5.0D)
/* 762 */                     .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)))))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 771 */     .newBehaviorRoot(
/* 772 */       CECombatBehaviors.BehaviorRoot.builder()
/* 773 */       .priority(1.0D)
/* 774 */       .weight(20.0D)
/* 775 */       .maxCooldown(100)
/* 776 */       .addFirstBehavior(
/* 777 */         CECombatBehaviors.Behavior.builder()
/* 778 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 779 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 780 */         .withinDistance(0.0D, 3.0D)
/* 781 */         .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/* 782 */         .addNextBehavior(
/* 783 */           CECombatBehaviors.Behavior.builder()
/* 784 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 785 */           .custom(CombatCommon::canAttackWhileNotHealing)
/* 786 */           .withinDistance(0.0D, 3.0D)
/* 787 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/* 788 */           .addNextBehavior(
/* 789 */             CECombatBehaviors.Behavior.builder()
/* 790 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 791 */             .custom(CombatCommon::canAttackWhileNotHealing)
/* 792 */             .withinDistance(0.0D, 3.0D)
/* 793 */             .animationBehavior(AVAnimations.FIST_DASH, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 798 */     .newBehaviorRoot(
/* 799 */       CECombatBehaviors.BehaviorRoot.builder()
/* 800 */       .priority(1.0D)
/* 801 */       .weight(10.0D)
/* 802 */       .maxCooldown(100)
/* 803 */       .addFirstBehavior(
/* 804 */         CECombatBehaviors.Behavior.builder()
/* 805 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 806 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 807 */         .withinDistance(0.0D, 3.0D)
/* 808 */         .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F))
/*     */       
/* 810 */       .addFirstBehavior(
/* 811 */         CECombatBehaviors.Behavior.builder()
/* 812 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 813 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 814 */         .withinDistance(0.0D, 3.0D)
/* 815 */         .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F))
/*     */       
/* 817 */       .addFirstBehavior(
/* 818 */         CECombatBehaviors.Behavior.builder()
/* 819 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 820 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 821 */         .withinDistance(0.0D, 3.0D)
/* 822 */         .animationBehavior(Animations.FIST_DASH, 0.0F))
/*     */       
/* 824 */       .addFirstBehavior(
/* 825 */         CECombatBehaviors.Behavior.builder()
/* 826 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 827 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 828 */         .withinDistance(0.0D, 3.0D)
/* 829 */         .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F))
/*     */       
/* 831 */       .addFirstBehavior(
/* 832 */         CECombatBehaviors.Behavior.builder()
/* 833 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 834 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 835 */         .withinDistance(0.0D, 3.0D)
/* 836 */         .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)))
/*     */ 
/*     */     
/* 839 */     .newBehaviorRoot(
/* 840 */       CECombatBehaviors.BehaviorRoot.builder()
/* 841 */       .priority(1.0D)
/* 842 */       .weight(10.0D)
/* 843 */       .maxCooldown(40)
/* 844 */       .addFirstBehavior(
/* 845 */         CECombatBehaviors.Behavior.builder()
/* 846 */         .withinDistance(0.0D, 3.0D)
/* 847 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 848 */         .custom(CombatCommon::canThrowEnderPearl)
/* 849 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 850 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 851 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 854 */     .newBehaviorRoot(
/* 855 */       CECombatBehaviors.BehaviorRoot.builder()
/* 856 */       .priority(1.0D)
/* 857 */       .weight(2.0D)
/* 858 */       .maxCooldown(100)
/* 859 */       .addFirstBehavior(
/* 860 */         CECombatBehaviors.Behavior.builder()
/* 861 */         .withinDistance(0.0D, 3.0D)
/* 862 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 863 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 864 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 866 */       .addFirstBehavior(
/* 867 */         CECombatBehaviors.Behavior.builder()
/* 868 */         .withinDistance(0.0D, 3.0D)
/* 869 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 870 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 871 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 873 */       .addFirstBehavior(
/* 874 */         CECombatBehaviors.Behavior.builder()
/* 875 */         .withinDistance(0.0D, 3.0D)
/* 876 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 877 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 878 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 880 */       .addFirstBehavior(
/* 881 */         CECombatBehaviors.Behavior.builder()
/* 882 */         .withinDistance(0.0D, 3.0D)
/* 883 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 884 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 885 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 887 */       .addFirstBehavior(
/* 888 */         CECombatBehaviors.Behavior.builder()
/* 889 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 890 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 891 */         .withinDistance(0.0D, 3.0D)
/* 892 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 894 */       .addFirstBehavior(
/* 895 */         CECombatBehaviors.Behavior.builder()
/* 896 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 897 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 898 */         .withinDistance(0.0D, 3.0D)
/* 899 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 901 */       .addFirstBehavior(
/* 902 */         CECombatBehaviors.Behavior.builder()
/* 903 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 904 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 905 */         .withinDistance(0.0D, 3.0D)
/* 906 */         .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)))
/*     */ 
/*     */     
/* 909 */     .newBehaviorRoot(
/* 910 */       CECombatBehaviors.BehaviorRoot.builder()
/* 911 */       .priority(1.0D)
/* 912 */       .weight(10.0D)
/* 913 */       .addFirstBehavior(
/* 914 */         CECombatBehaviors.Behavior.builder()
/* 915 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 916 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 917 */         .withinDistance(0.0D, 3.0D)
/* 918 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*     */       
/* 920 */       .addFirstBehavior(
/* 921 */         CECombatBehaviors.Behavior.builder()
/* 922 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 923 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 924 */         .withinDistance(0.0D, 3.0D)
/* 925 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*     */ 
/*     */     
/* 928 */     .newBehaviorRoot(
/* 929 */       CECombatBehaviors.BehaviorRoot.builder()
/* 930 */       .priority(1.0D)
/* 931 */       .weight(40.0D)
/* 932 */       .maxCooldown(160)
/* 933 */       .addFirstBehavior(
/* 934 */         CECombatBehaviors.Behavior.builder()
/* 935 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 936 */         .custom(CombatCommon::canJump)
/* 937 */         .withinDistance(5.0D, 14.0D)
/* 938 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 939 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveFist.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */