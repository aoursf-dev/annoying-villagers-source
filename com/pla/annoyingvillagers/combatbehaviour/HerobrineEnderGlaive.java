/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HerobrineEnderGlaive
/*     */ {
/*  15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> ENDER_GLAIVE = CECombatBehaviors.builder()
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
/*  36 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  37 */         .custom(CombatCommon::canEscape)
/*  38 */         .withinDistance(0.0D, 8.0D)
/*  39 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  40 */         .addExBehavior(HerobrineCommon::performEscapeRunAwayWithLowClone))
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
/*  56 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  57 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  58 */         .custom(HerobrineCommon::canPerformHealing)
/*  59 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*  60 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*     */ 
/*     */     
/*  63 */     .newBehaviorRoot(
/*  64 */       CECombatBehaviors.BehaviorRoot.builder()
/*  65 */       .priority(1.0D)
/*  66 */       .weight(30.0D)
/*  67 */       .maxCooldown(120)
/*  68 */       .addFirstBehavior(
/*  69 */         CECombatBehaviors.Behavior.builder()
/*  70 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  71 */         .withinDistance(7.0D, 48.0D)
/*  72 */         .animationBehavior(AVAnimations.HEROBRINE_MOB_ENDERSTEP_OBSCURIS, 0.0F)
/*  73 */         .addExBehavior(HerobrineCommon::giveSlowFalling)))
/*     */ 
/*     */     
/*  76 */     .newBehaviorRoot(
/*  77 */       CECombatBehaviors.BehaviorRoot.builder()
/*  78 */       .priority(1.0D)
/*  79 */       .weight(40.0D)
/*  80 */       .maxCooldown(20)
/*  81 */       .addFirstBehavior(
/*  82 */         CECombatBehaviors.Behavior.builder()
/*  83 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  84 */         .withinDistance(0.0D, 5.0D)
/*  85 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/*  86 */         .addNextBehavior(
/*  87 */           CECombatBehaviors.Behavior.builder()
/*  88 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  89 */           .withinDistance(0.0D, 6.0D)
/*  90 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/*  91 */           .addNextBehavior(
/*  92 */             CECombatBehaviors.Behavior.builder()
/*  93 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  94 */             .withinDistance(0.0D, 6.0D)
/*  95 */             .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/*  96 */             .addNextBehavior(
/*  97 */               CECombatBehaviors.Behavior.builder()
/*  98 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  99 */               .withinDistance(0.0D, 6.0D)
/* 100 */               .animationBehavior(AnimsAgony.AGONY_AUTO_2, 0.0F)
/* 101 */               .addNextBehavior(
/* 102 */                 CECombatBehaviors.Behavior.builder()
/* 103 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 104 */                 .withinDistance(0.0D, 8.0D)
/* 105 */                 .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 111 */       .addFirstBehavior(
/* 112 */         CECombatBehaviors.Behavior.builder()
/* 113 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 114 */         .withinDistance(0.0D, 5.0D)
/* 115 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 116 */         .addNextBehavior(
/* 117 */           CECombatBehaviors.Behavior.builder()
/* 118 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 119 */           .withinDistance(0.0D, 6.0D)
/* 120 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 121 */           .addNextBehavior(
/* 122 */             CECombatBehaviors.Behavior.builder()
/* 123 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 124 */             .withinDistance(0.0D, 7.0D)
/* 125 */             .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUSTERLITZ, 0.0F)
/* 126 */             .addNextBehavior(
/* 127 */               CECombatBehaviors.Behavior.builder()
/* 128 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 129 */               .withinDistance(0.0D, 8.0D)
/* 130 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       .addFirstBehavior(
/* 136 */         CECombatBehaviors.Behavior.builder()
/* 137 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 138 */         .withinDistance(0.0D, 8.0D)
/* 139 */         .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 140 */         .addNextBehavior(
/* 141 */           CECombatBehaviors.Behavior.builder()
/* 142 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 143 */           .withinDistance(0.0D, 5.0D)
/* 144 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 145 */           .addNextBehavior(
/* 146 */             CECombatBehaviors.Behavior.builder()
/* 147 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 148 */             .withinDistance(0.0D, 6.0D)
/* 149 */             .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 150 */             .addNextBehavior(
/* 151 */               CECombatBehaviors.Behavior.builder()
/* 152 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 153 */               .withinDistance(0.0D, 8.0D)
/* 154 */               .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       .addFirstBehavior(
/* 160 */         CECombatBehaviors.Behavior.builder()
/* 161 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 162 */         .withinDistance(0.0D, 5.0D)
/* 163 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 164 */         .addNextBehavior(
/* 165 */           CECombatBehaviors.Behavior.builder()
/* 166 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 167 */           .withinDistance(0.0D, 6.0D)
/* 168 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_1, 0.0F)
/* 169 */           .addNextBehavior(
/* 170 */             CECombatBehaviors.Behavior.builder()
/* 171 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 172 */             .withinDistance(0.0D, 6.0D)
/* 173 */             .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_2, 0.0F)
/* 174 */             .addNextBehavior(
/* 175 */               CECombatBehaviors.Behavior.builder()
/* 176 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 177 */               .withinDistance(0.0D, 8.0D)
/* 178 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_GUILLOTINE, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       .addFirstBehavior(
/* 184 */         CECombatBehaviors.Behavior.builder()
/* 185 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 186 */         .withinDistance(0.0D, 6.0D)
/* 187 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 188 */         .addNextBehavior(
/* 189 */           CECombatBehaviors.Behavior.builder()
/* 190 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 191 */           .withinDistance(0.0D, 6.0D)
/* 192 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 193 */           .addNextBehavior(
/* 194 */             CECombatBehaviors.Behavior.builder()
/* 195 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 196 */             .withinDistance(0.0D, 7.0D)
/* 197 */             .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 198 */             .addNextBehavior(
/* 199 */               CECombatBehaviors.Behavior.builder()
/* 200 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 201 */               .withinDistance(0.0D, 8.0D)
/* 202 */               .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 207 */       .addFirstBehavior(
/* 208 */         CECombatBehaviors.Behavior.builder()
/* 209 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 210 */         .withinDistance(0.0D, 8.0D)
/* 211 */         .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AGRESSION, 0.0F)
/* 212 */         .addNextBehavior(
/* 213 */           CECombatBehaviors.Behavior.builder()
/* 214 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 215 */           .withinDistance(0.0D, 6.0D)
/* 216 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 217 */           .addNextBehavior(
/* 218 */             CECombatBehaviors.Behavior.builder()
/* 219 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 220 */             .withinDistance(0.0D, 6.0D)
/* 221 */             .animationBehavior(AnimsAgony.AGONY_AUTO_2, 0.0F)
/* 222 */             .addNextBehavior(
/* 223 */               CECombatBehaviors.Behavior.builder()
/* 224 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 225 */               .withinDistance(0.0D, 8.0D)
/* 226 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 231 */       .addFirstBehavior(
/* 232 */         CECombatBehaviors.Behavior.builder()
/* 233 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 234 */         .withinDistance(0.0D, 5.0D)
/* 235 */         .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 236 */         .addNextBehavior(
/* 237 */           CECombatBehaviors.Behavior.builder()
/* 238 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 239 */           .withinDistance(0.0D, 6.0D)
/* 240 */           .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 241 */           .addNextBehavior(
/* 242 */             CECombatBehaviors.Behavior.builder()
/* 243 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 244 */             .withinDistance(0.0D, 6.0D)
/* 245 */             .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 246 */             .addNextBehavior(
/* 247 */               CECombatBehaviors.Behavior.builder()
/* 248 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 249 */               .withinDistance(0.0D, 8.0D)
/* 250 */               .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUSTERLITZ, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 255 */       .addFirstBehavior(
/* 256 */         CECombatBehaviors.Behavior.builder()
/* 257 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 258 */         .withinDistance(0.0D, 5.0D)
/* 259 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 260 */         .addNextBehavior(
/* 261 */           CECombatBehaviors.Behavior.builder()
/* 262 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 263 */           .withinDistance(0.0D, 6.0D)
/* 264 */           .animationBehavior(AnimsAgony.AGONY_AUTO_2, 0.0F)
/* 265 */           .addNextBehavior(
/* 266 */             CECombatBehaviors.Behavior.builder()
/* 267 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 268 */             .withinDistance(0.0D, 6.0D)
/* 269 */             .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_3, 0.0F)
/* 270 */             .addNextBehavior(
/* 271 */               CECombatBehaviors.Behavior.builder()
/* 272 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 273 */               .withinDistance(0.0D, 8.0D)
/* 274 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_4, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 279 */       .addFirstBehavior(
/* 280 */         CECombatBehaviors.Behavior.builder()
/* 281 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 282 */         .withinDistance(0.0D, 6.0D)
/* 283 */         .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_4, 0.0F)
/* 284 */         .addNextBehavior(
/* 285 */           CECombatBehaviors.Behavior.builder()
/* 286 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 287 */           .withinDistance(0.0D, 6.0D)
/* 288 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 289 */           .addNextBehavior(
/* 290 */             CECombatBehaviors.Behavior.builder()
/* 291 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 292 */             .withinDistance(0.0D, 6.0D)
/* 293 */             .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 294 */             .addNextBehavior(
/* 295 */               CECombatBehaviors.Behavior.builder()
/* 296 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 297 */               .withinDistance(0.0D, 8.0D)
/* 298 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_GUILLOTINE, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 303 */       .addFirstBehavior(
/* 304 */         CECombatBehaviors.Behavior.builder()
/* 305 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 306 */         .withinDistance(0.0D, 7.0D)
/* 307 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUSTERLITZ, 0.0F)
/* 308 */         .addNextBehavior(
/* 309 */           CECombatBehaviors.Behavior.builder()
/* 310 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 311 */           .withinDistance(0.0D, 6.0D)
/* 312 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 313 */           .addNextBehavior(
/* 314 */             CECombatBehaviors.Behavior.builder()
/* 315 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 316 */             .withinDistance(0.0D, 6.0D)
/* 317 */             .animationBehavior(AnimsAgony.AGONY_AUTO_2, 0.0F)
/* 318 */             .addNextBehavior(
/* 319 */               CECombatBehaviors.Behavior.builder()
/* 320 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 321 */               .withinDistance(0.0D, 8.0D)
/* 322 */               .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 327 */       .addFirstBehavior(
/* 328 */         CECombatBehaviors.Behavior.builder()
/* 329 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 330 */         .withinDistance(0.0D, 8.0D)
/* 331 */         .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 332 */         .addNextBehavior(
/* 333 */           CECombatBehaviors.Behavior.builder()
/* 334 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 335 */           .withinDistance(0.0D, 6.0D)
/* 336 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 337 */           .addNextBehavior(
/* 338 */             CECombatBehaviors.Behavior.builder()
/* 339 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 340 */             .withinDistance(0.0D, 8.0D)
/* 341 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 342 */             .addNextBehavior(
/* 343 */               CECombatBehaviors.Behavior.builder()
/* 344 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 345 */               .withinDistance(0.0D, 8.0D)
/* 346 */               .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 351 */       .addFirstBehavior(
/* 352 */         CECombatBehaviors.Behavior.builder()
/* 353 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 354 */         .withinDistance(0.0D, 6.0D)
/* 355 */         .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_1, 0.0F)
/* 356 */         .addNextBehavior(
/* 357 */           CECombatBehaviors.Behavior.builder()
/* 358 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 359 */           .withinDistance(0.0D, 6.0D)
/* 360 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 361 */           .addNextBehavior(
/* 362 */             CECombatBehaviors.Behavior.builder()
/* 363 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 364 */             .withinDistance(0.0D, 7.0D)
/* 365 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/* 366 */             .addNextBehavior(
/* 367 */               CECombatBehaviors.Behavior.builder()
/* 368 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 369 */               .withinDistance(0.0D, 8.0D)
/* 370 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_GUILLOTINE, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 375 */       .addFirstBehavior(
/* 376 */         CECombatBehaviors.Behavior.builder()
/* 377 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 378 */         .withinDistance(0.0D, 6.0D)
/* 379 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 380 */         .addNextBehavior(
/* 381 */           CECombatBehaviors.Behavior.builder()
/* 382 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 383 */           .withinDistance(0.0D, 7.0D)
/* 384 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 385 */           .addNextBehavior(
/* 386 */             CECombatBehaviors.Behavior.builder()
/* 387 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 388 */             .withinDistance(0.0D, 6.0D)
/* 389 */             .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_2, 0.0F)
/* 390 */             .addNextBehavior(
/* 391 */               CECombatBehaviors.Behavior.builder()
/* 392 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 393 */               .withinDistance(0.0D, 6.0D)
/* 394 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 399 */       .addFirstBehavior(
/* 400 */         CECombatBehaviors.Behavior.builder()
/* 401 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 402 */         .withinDistance(0.0D, 6.0D)
/* 403 */         .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 404 */         .addNextBehavior(
/* 405 */           CECombatBehaviors.Behavior.builder()
/* 406 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 407 */           .withinDistance(0.0D, 6.0D)
/* 408 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 409 */           .addNextBehavior(
/* 410 */             CECombatBehaviors.Behavior.builder()
/* 411 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 412 */             .withinDistance(0.0D, 8.0D)
/* 413 */             .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AGRESSION, 0.0F)
/* 414 */             .addNextBehavior(
/* 415 */               CECombatBehaviors.Behavior.builder()
/* 416 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 417 */               .withinDistance(0.0D, 8.0D)
/* 418 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_GUILLOTINE, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 423 */       .addFirstBehavior(
/* 424 */         CECombatBehaviors.Behavior.builder()
/* 425 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 426 */         .withinDistance(0.0D, 6.0D)
/* 427 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 428 */         .addNextBehavior(
/* 429 */           CECombatBehaviors.Behavior.builder()
/* 430 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 431 */           .withinDistance(0.0D, 8.0D)
/* 432 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 433 */           .addNextBehavior(
/* 434 */             CECombatBehaviors.Behavior.builder()
/* 435 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 436 */             .withinDistance(0.0D, 6.0D)
/* 437 */             .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 438 */             .addNextBehavior(
/* 439 */               CECombatBehaviors.Behavior.builder()
/* 440 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 441 */               .withinDistance(0.0D, 8.0D)
/* 442 */               .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUSTERLITZ, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 447 */       .addFirstBehavior(
/* 448 */         CECombatBehaviors.Behavior.builder()
/* 449 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 450 */         .withinDistance(0.0D, 5.0D)
/* 451 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 452 */         .addNextBehavior(
/* 453 */           CECombatBehaviors.Behavior.builder()
/* 454 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 455 */           .withinDistance(0.0D, 6.0D)
/* 456 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_1, 0.0F)
/* 457 */           .addNextBehavior(
/* 458 */             CECombatBehaviors.Behavior.builder()
/* 459 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 460 */             .withinDistance(0.0D, 6.0D)
/* 461 */             .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 462 */             .addNextBehavior(
/* 463 */               CECombatBehaviors.Behavior.builder()
/* 464 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 465 */               .withinDistance(0.0D, 6.0D)
/* 466 */               .animationBehavior(AnimsAgony.AGONY_AUTO_2, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 471 */       .addFirstBehavior(
/* 472 */         CECombatBehaviors.Behavior.builder()
/* 473 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 474 */         .withinDistance(0.0D, 6.0D)
/* 475 */         .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_2, 0.0F)
/* 476 */         .addNextBehavior(
/* 477 */           CECombatBehaviors.Behavior.builder()
/* 478 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 479 */           .withinDistance(0.0D, 6.0D)
/* 480 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_4, 0.0F)
/* 481 */           .addNextBehavior(
/* 482 */             CECombatBehaviors.Behavior.builder()
/* 483 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 484 */             .withinDistance(0.0D, 7.0D)
/* 485 */             .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 486 */             .addNextBehavior(
/* 487 */               CECombatBehaviors.Behavior.builder()
/* 488 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 489 */               .withinDistance(0.0D, 8.0D)
/* 490 */               .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 495 */       .addFirstBehavior(
/* 496 */         CECombatBehaviors.Behavior.builder()
/* 497 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 498 */         .withinDistance(0.0D, 6.0D)
/* 499 */         .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 500 */         .addNextBehavior(
/* 501 */           CECombatBehaviors.Behavior.builder()
/* 502 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 503 */           .withinDistance(0.0D, 6.0D)
/* 504 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 505 */           .addNextBehavior(
/* 506 */             CECombatBehaviors.Behavior.builder()
/* 507 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 508 */             .withinDistance(0.0D, 8.0D)
/* 509 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 510 */             .addNextBehavior(
/* 511 */               CECombatBehaviors.Behavior.builder()
/* 512 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 513 */               .withinDistance(0.0D, 6.0D)
/* 514 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 519 */       .addFirstBehavior(
/* 520 */         CECombatBehaviors.Behavior.builder()
/* 521 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 522 */         .withinDistance(0.0D, 8.0D)
/* 523 */         .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 524 */         .addNextBehavior(
/* 525 */           CECombatBehaviors.Behavior.builder()
/* 526 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 527 */           .withinDistance(0.0D, 7.0D)
/* 528 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUSTERLITZ, 0.0F)
/* 529 */           .addNextBehavior(
/* 530 */             CECombatBehaviors.Behavior.builder()
/* 531 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 532 */             .withinDistance(0.0D, 6.0D)
/* 533 */             .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_4, 0.0F)
/* 534 */             .addNextBehavior(
/* 535 */               CECombatBehaviors.Behavior.builder()
/* 536 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 537 */               .withinDistance(0.0D, 8.0D)
/* 538 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_GUILLOTINE, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 543 */       .addFirstBehavior(
/* 544 */         CECombatBehaviors.Behavior.builder()
/* 545 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 546 */         .withinDistance(0.0D, 5.0D)
/* 547 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 548 */         .addNextBehavior(
/* 549 */           CECombatBehaviors.Behavior.builder()
/* 550 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 551 */           .withinDistance(0.0D, 6.0D)
/* 552 */           .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 553 */           .addNextBehavior(
/* 554 */             CECombatBehaviors.Behavior.builder()
/* 555 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 556 */             .withinDistance(0.0D, 6.0D)
/* 557 */             .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 558 */             .addNextBehavior(
/* 559 */               CECombatBehaviors.Behavior.builder()
/* 560 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 561 */               .withinDistance(0.0D, 8.0D)
/* 562 */               .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 567 */       .addFirstBehavior(
/* 568 */         CECombatBehaviors.Behavior.builder()
/* 569 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 570 */         .withinDistance(0.0D, 6.0D)
/* 571 */         .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_3, 0.0F)
/* 572 */         .addNextBehavior(
/* 573 */           CECombatBehaviors.Behavior.builder()
/* 574 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 575 */           .withinDistance(0.0D, 6.0D)
/* 576 */           .animationBehavior(AnimsAgony.AGONY_AUTO_2, 0.0F)
/* 577 */           .addNextBehavior(
/* 578 */             CECombatBehaviors.Behavior.builder()
/* 579 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 580 */             .withinDistance(0.0D, 6.0D)
/* 581 */             .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 582 */             .addNextBehavior(
/* 583 */               CECombatBehaviors.Behavior.builder()
/* 584 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 585 */               .withinDistance(0.0D, 6.0D)
/* 586 */               .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 591 */       .addFirstBehavior(
/* 592 */         CECombatBehaviors.Behavior.builder()
/* 593 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 594 */         .withinDistance(0.0D, 5.0D)
/* 595 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 596 */         .addNextBehavior(
/* 597 */           CECombatBehaviors.Behavior.builder()
/* 598 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 599 */           .withinDistance(0.0D, 6.0D)
/* 600 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 601 */           .addNextBehavior(
/* 602 */             CECombatBehaviors.Behavior.builder()
/* 603 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 604 */             .withinDistance(0.0D, 6.0D)
/* 605 */             .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 606 */             .addNextBehavior(
/* 607 */               CECombatBehaviors.Behavior.builder()
/* 608 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 609 */               .withinDistance(0.0D, 8.0D)
/* 610 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 615 */       .addFirstBehavior(
/* 616 */         CECombatBehaviors.Behavior.builder()
/* 617 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 618 */         .withinDistance(0.0D, 8.0D)
/* 619 */         .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AGRESSION, 0.0F)
/* 620 */         .addNextBehavior(
/* 621 */           CECombatBehaviors.Behavior.builder()
/* 622 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 623 */           .withinDistance(0.0D, 7.0D)
/* 624 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 625 */           .addNextBehavior(
/* 626 */             CECombatBehaviors.Behavior.builder()
/* 627 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 628 */             .withinDistance(0.0D, 6.0D)
/* 629 */             .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/* 630 */             .addNextBehavior(
/* 631 */               CECombatBehaviors.Behavior.builder()
/* 632 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 633 */               .withinDistance(0.0D, 8.0D)
/* 634 */               .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUSTERLITZ, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 639 */       .addFirstBehavior(
/* 640 */         CECombatBehaviors.Behavior.builder()
/* 641 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 642 */         .withinDistance(0.0D, 7.0D)
/* 643 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/* 644 */         .addNextBehavior(
/* 645 */           CECombatBehaviors.Behavior.builder()
/* 646 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 647 */           .withinDistance(0.0D, 6.0D)
/* 648 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 649 */           .addNextBehavior(
/* 650 */             CECombatBehaviors.Behavior.builder()
/* 651 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 652 */             .withinDistance(0.0D, 6.0D)
/* 653 */             .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 654 */             .addNextBehavior(
/* 655 */               CECombatBehaviors.Behavior.builder()
/* 656 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 657 */               .withinDistance(0.0D, 8.0D)
/* 658 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 663 */       .addFirstBehavior(
/* 664 */         CECombatBehaviors.Behavior.builder()
/* 665 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 666 */         .withinDistance(0.0D, 5.0D)
/* 667 */         .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 668 */         .addNextBehavior(
/* 669 */           CECombatBehaviors.Behavior.builder()
/* 670 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 671 */           .withinDistance(0.0D, 6.0D)
/* 672 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, 0.0F)
/* 673 */           .addNextBehavior(
/* 674 */             CECombatBehaviors.Behavior.builder()
/* 675 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 676 */             .withinDistance(0.0D, 6.0D)
/* 677 */             .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_1, 0.0F)
/* 678 */             .addNextBehavior(
/* 679 */               CECombatBehaviors.Behavior.builder()
/* 680 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 681 */               .withinDistance(0.0D, 8.0D)
/* 682 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_4, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 687 */       .addFirstBehavior(
/* 688 */         CECombatBehaviors.Behavior.builder()
/* 689 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 690 */         .withinDistance(0.0D, 8.0D)
/* 691 */         .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 692 */         .addNextBehavior(
/* 693 */           CECombatBehaviors.Behavior.builder()
/* 694 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 695 */           .withinDistance(0.0D, 6.0D)
/* 696 */           .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, 0.0F)
/* 697 */           .addNextBehavior(
/* 698 */             CECombatBehaviors.Behavior.builder()
/* 699 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 700 */             .withinDistance(0.0D, 6.0D)
/* 701 */             .animationBehavior(AVAnimations.CLONE_ANTITHEUS_AUTO_2, 0.0F)
/* 702 */             .addNextBehavior(
/* 703 */               CECombatBehaviors.Behavior.builder()
/* 704 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 705 */               .withinDistance(0.0D, 8.0D)
/* 706 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_GUILLOTINE, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 712 */     .newBehaviorRoot(
/* 713 */       CECombatBehaviors.BehaviorRoot.builder()
/* 714 */       .priority(1.0D)
/* 715 */       .weight(30.0D)
/* 716 */       .maxCooldown(100)
/* 717 */       .addFirstBehavior(
/* 718 */         CECombatBehaviors.Behavior.builder()
/* 719 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 720 */         .withinDistance(0.0D, 5.0D)
/* 721 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_AUSTERLITZ, 0.0F))
/*     */       
/* 723 */       .addFirstBehavior(
/* 724 */         CECombatBehaviors.Behavior.builder()
/* 725 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 726 */         .withinDistance(0.0D, 5.0D)
/* 727 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)))
/*     */ 
/*     */     
/* 730 */     .newBehaviorRoot(
/* 731 */       CECombatBehaviors.BehaviorRoot.builder()
/* 732 */       .priority(1.0D)
/* 733 */       .weight(20.0D)
/* 734 */       .maxCooldown(100)
/* 735 */       .addFirstBehavior(
/* 736 */         CECombatBehaviors.Behavior.builder()
/* 737 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 738 */         .withinDistance(0.0D, 5.0D)
/* 739 */         .animationBehavior(AnimsAgony.AGONY_RISING_EAGLE, 0.0F)
/* 740 */         .addNextBehavior(
/* 741 */           CECombatBehaviors.Behavior.builder()
/* 742 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 743 */           .withinDistance(0.0D, 8.0D)
/* 744 */           .animationBehavior(AnimsAgony.AGONY_SKY_DIVE, 0.0F))))
/*     */ 
/*     */ 
/*     */     
/* 748 */     .newBehaviorRoot(
/* 749 */       CECombatBehaviors.BehaviorRoot.builder()
/* 750 */       .priority(1.0D)
/* 751 */       .weight(20.0D)
/* 752 */       .maxCooldown(100)
/* 753 */       .addFirstBehavior(
/* 754 */         CECombatBehaviors.Behavior.builder()
/* 755 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 756 */         .withinDistance(4.0D, 10.0D)
/* 757 */         .animationBehavior(AnimsAgony.AGONY_RISING_EAGLE, 0.0F)
/* 758 */         .addExBehavior(HerobrineCommon::performAgonySpecialAttack)))
/*     */ 
/*     */     
/* 761 */     .newBehaviorRoot(
/* 762 */       CECombatBehaviors.BehaviorRoot.builder()
/* 763 */       .priority(1.0D)
/* 764 */       .weight(15.0D)
/* 765 */       .maxCooldown(600)
/* 766 */       .addFirstBehavior(
/* 767 */         CECombatBehaviors.Behavior.builder()
/* 768 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 769 */         .custom(HerobrineCommon::canChangeToSecondForm)
/* 770 */         .withinDistance(0.0D, 8.0D)
/* 771 */         .animationBehavior(AVAnimations.AGONY_GUARD_HIT_1, 0.0F)
/* 772 */         .addExBehavior(HerobrineCommon::changeToSecondForm)))
/*     */ 
/*     */     
/* 775 */     .newBehaviorRoot(
/* 776 */       CECombatBehaviors.BehaviorRoot.builder()
/* 777 */       .priority(1.0D)
/* 778 */       .weight(25.0D)
/* 779 */       .maxCooldown(300)
/* 780 */       .addFirstBehavior(
/* 781 */         CECombatBehaviors.Behavior.builder()
/* 782 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 783 */         .withinDistance(2.0D, 8.0D)
/* 784 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/* 785 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_AGONY_AUTO_1, 0.0F)
/* 786 */         .addExBehavior(HerobrineCommon::playSecondFormAnimation)))
/*     */ 
/*     */     
/* 789 */     .newBehaviorRoot(
/* 790 */       CECombatBehaviors.BehaviorRoot.builder()
/* 791 */       .priority(1.0D)
/* 792 */       .weight(25.0D)
/* 793 */       .maxCooldown(300)
/* 794 */       .addFirstBehavior(
/* 795 */         CECombatBehaviors.Behavior.builder()
/* 796 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 797 */         .withinDistance(2.0D, 8.0D)
/* 798 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/* 799 */         .animationBehavior(AVAnimations.ENDER_GLAIVE_NAPOLEON_SHOOT_3, 0.0F)
/* 800 */         .addExBehavior(HerobrineCommon::playSecondFormSpecialAnimation)))
/*     */ 
/*     */     
/* 803 */     .newBehaviorRoot(
/* 804 */       CECombatBehaviors.BehaviorRoot.builder()
/* 805 */       .priority(1.0D)
/* 806 */       .weight(15.0D)
/* 807 */       .addFirstBehavior(
/* 808 */         CECombatBehaviors.Behavior.builder()
/* 809 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 810 */         .withinDistance(0.0D, 5.0D)
/* 811 */         .custom(HerobrineCommon::canPerformGuarding)
/* 812 */         .guard(40)))
/*     */ 
/*     */     
/* 815 */     .newBehaviorRoot(
/* 816 */       CECombatBehaviors.BehaviorRoot.builder()
/* 817 */       .priority(1.0D)
/* 818 */       .weight(10.0D)
/* 819 */       .addFirstBehavior(
/* 820 */         CECombatBehaviors.Behavior.builder()
/* 821 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 822 */         .withinDistance(0.0D, 5.0D)
/* 823 */         .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F))
/*     */       
/* 825 */       .addFirstBehavior(
/* 826 */         CECombatBehaviors.Behavior.builder()
/* 827 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 828 */         .withinDistance(0.0D, 5.0D)
/* 829 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F))
/*     */       
/* 831 */       .addFirstBehavior(
/* 832 */         CECombatBehaviors.Behavior.builder()
/* 833 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 834 */         .withinDistance(0.0D, 5.0D)
/* 835 */         .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F))
/*     */       
/* 837 */       .addFirstBehavior(
/* 838 */         CECombatBehaviors.Behavior.builder()
/* 839 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 840 */         .withinDistance(0.0D, 5.0D)
/* 841 */         .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)))
/*     */ 
/*     */     
/* 844 */     .newBehaviorRoot(
/* 845 */       CECombatBehaviors.BehaviorRoot.builder()
/* 846 */       .priority(1.0D)
/* 847 */       .weight(20.0D)
/* 848 */       .maxCooldown(160)
/* 849 */       .addFirstBehavior(
/* 850 */         CECombatBehaviors.Behavior.builder()
/* 851 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 852 */         .custom(HerobrineCommon::canJump)
/* 853 */         .withinDistance(5.0D, 14.0D)
/* 854 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 855 */         .addExBehavior(HerobrineCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineEnderGlaive.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */