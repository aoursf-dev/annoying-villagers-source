/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsHerrscher;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HerobrineEnderAegis
/*     */ {
/*  16 */   public static final CECombatBehaviors.Builder<MobPatch<?>> ENDER_AEGIS = CECombatBehaviors.builder()
/*  17 */     .newBehaviorRoot(
/*  18 */       CECombatBehaviors.BehaviorRoot.builder()
/*  19 */       .priority(5.0D)
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
/*  32 */       .priority(4.0D)
/*  33 */       .weight(1000.0D)
/*  34 */       .maxCooldown(0)
/*  35 */       .addFirstBehavior(
/*  36 */         CECombatBehaviors.Behavior.builder()
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
/*  67 */       .maxCooldown(20)
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
/*  84 */         .withinDistance(0.0D, 4.0D)
/*  85 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/*  86 */         .addNextBehavior(
/*  87 */           CECombatBehaviors.Behavior.builder()
/*  88 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  89 */           .withinDistance(0.0D, 5.0D)
/*  90 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/*  91 */           .addNextBehavior(
/*  92 */             CECombatBehaviors.Behavior.builder()
/*  93 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  94 */             .withinDistance(0.0D, 5.0D)
/*  95 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/*  96 */             .addNextBehavior(
/*  97 */               CECombatBehaviors.Behavior.builder()
/*  98 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  99 */               .withinDistance(0.0D, 6.0D)
/* 100 */               .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 101 */               .addNextBehavior(
/* 102 */                 CECombatBehaviors.Behavior.builder()
/* 103 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 104 */                 .withinDistance(0.0D, 6.0D)
/* 105 */                 .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 106 */                 .addNextBehavior(
/* 107 */                   CECombatBehaviors.Behavior.builder()
/* 108 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 109 */                   .withinDistance(0.0D, 6.0D)
/* 110 */                   .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 117 */       .addFirstBehavior(
/* 118 */         CECombatBehaviors.Behavior.builder()
/* 119 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 120 */         .withinDistance(0.0D, 4.0D)
/* 121 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 122 */         .addNextBehavior(
/* 123 */           CECombatBehaviors.Behavior.builder()
/* 124 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 125 */           .withinDistance(0.0D, 5.0D)
/* 126 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 127 */           .addNextBehavior(
/* 128 */             CECombatBehaviors.Behavior.builder()
/* 129 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 130 */             .withinDistance(0.0D, 6.0D)
/* 131 */             .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 132 */             .addNextBehavior(
/* 133 */               CECombatBehaviors.Behavior.builder()
/* 134 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */               .withinDistance(0.0D, 6.0D)
/* 136 */               .custom(HerobrineCommon::canPerformGuarding)
/* 137 */               .guard(40)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       .addFirstBehavior(
/* 143 */         CECombatBehaviors.Behavior.builder()
/* 144 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 145 */         .withinDistance(0.0D, 4.0D)
/* 146 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 147 */         .addNextBehavior(
/* 148 */           CECombatBehaviors.Behavior.builder()
/* 149 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 150 */           .withinDistance(0.0D, 6.0D)
/* 151 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 152 */           .addNextBehavior(
/* 153 */             CECombatBehaviors.Behavior.builder()
/* 154 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 155 */             .withinDistance(0.0D, 6.0D)
/* 156 */             .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 157 */             .addNextBehavior(
/* 158 */               CECombatBehaviors.Behavior.builder()
/* 159 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 160 */               .withinDistance(0.0D, 6.0D)
/* 161 */               .custom(HerobrineCommon::canPerformGuarding)
/* 162 */               .guard(40)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 167 */       .addFirstBehavior(
/* 168 */         CECombatBehaviors.Behavior.builder()
/* 169 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 170 */         .withinDistance(0.0D, 6.0D)
/* 171 */         .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 172 */         .addNextBehavior(
/* 173 */           CECombatBehaviors.Behavior.builder()
/* 174 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 175 */           .withinDistance(0.0D, 6.0D)
/* 176 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 177 */           .addNextBehavior(
/* 178 */             CECombatBehaviors.Behavior.builder()
/* 179 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 180 */             .withinDistance(0.0D, 6.0D)
/* 181 */             .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 182 */             .addNextBehavior(
/* 183 */               CECombatBehaviors.Behavior.builder()
/* 184 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 185 */               .withinDistance(0.0D, 6.0D)
/* 186 */               .custom(HerobrineCommon::canPerformGuarding)
/* 187 */               .guard(40)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 192 */       .addFirstBehavior(
/* 193 */         CECombatBehaviors.Behavior.builder()
/* 194 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 195 */         .withinDistance(0.0D, 5.0D)
/* 196 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 197 */         .addNextBehavior(
/* 198 */           CECombatBehaviors.Behavior.builder()
/* 199 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 200 */           .withinDistance(0.0D, 5.0D)
/* 201 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 202 */           .addNextBehavior(
/* 203 */             CECombatBehaviors.Behavior.builder()
/* 204 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 205 */             .withinDistance(0.0D, 7.0D)
/* 206 */             .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 207 */             .addNextBehavior(
/* 208 */               CECombatBehaviors.Behavior.builder()
/* 209 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 210 */               .withinDistance(0.0D, 6.0D)
/* 211 */               .custom(HerobrineCommon::canPerformGuarding)
/* 212 */               .guard(40)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 217 */       .addFirstBehavior(
/* 218 */         CECombatBehaviors.Behavior.builder()
/* 219 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 220 */         .withinDistance(0.0D, 5.0D)
/* 221 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 222 */         .addNextBehavior(
/* 223 */           CECombatBehaviors.Behavior.builder()
/* 224 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 225 */           .withinDistance(0.0D, 9.0D)
/* 226 */           .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 227 */           .addNextBehavior(
/* 228 */             CECombatBehaviors.Behavior.builder()
/* 229 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 230 */             .withinDistance(0.0D, 7.0D)
/* 231 */             .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 232 */             .addNextBehavior(
/* 233 */               CECombatBehaviors.Behavior.builder()
/* 234 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 235 */               .withinDistance(0.0D, 6.0D)
/* 236 */               .custom(HerobrineCommon::canPerformGuarding)
/* 237 */               .guard(40)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 242 */       .addFirstBehavior(
/* 243 */         CECombatBehaviors.Behavior.builder()
/* 244 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 245 */         .withinDistance(0.0D, 9.0D)
/* 246 */         .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 247 */         .addNextBehavior(
/* 248 */           CECombatBehaviors.Behavior.builder()
/* 249 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 250 */           .withinDistance(0.0D, 6.0D)
/* 251 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 252 */           .addNextBehavior(
/* 253 */             CECombatBehaviors.Behavior.builder()
/* 254 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 255 */             .withinDistance(0.0D, 6.0D)
/* 256 */             .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 257 */             .addNextBehavior(
/* 258 */               CECombatBehaviors.Behavior.builder()
/* 259 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 260 */               .withinDistance(0.0D, 6.0D)
/* 261 */               .custom(HerobrineCommon::canPerformGuarding)
/* 262 */               .guard(40)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 267 */       .addFirstBehavior(
/* 268 */         CECombatBehaviors.Behavior.builder()
/* 269 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 270 */         .withinDistance(0.0D, 7.0D)
/* 271 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 272 */         .addNextBehavior(
/* 273 */           CECombatBehaviors.Behavior.builder()
/* 274 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 275 */           .withinDistance(0.0D, 7.0D)
/* 276 */           .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 277 */           .addNextBehavior(
/* 278 */             CECombatBehaviors.Behavior.builder()
/* 279 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 280 */             .withinDistance(0.0D, 6.0D)
/* 281 */             .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 282 */             .addNextBehavior(
/* 283 */               CECombatBehaviors.Behavior.builder()
/* 284 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 285 */               .withinDistance(0.0D, 6.0D)
/* 286 */               .custom(HerobrineCommon::canPerformGuarding)
/* 287 */               .guard(40)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 292 */       .addFirstBehavior(
/* 293 */         CECombatBehaviors.Behavior.builder()
/* 294 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 295 */         .withinDistance(0.0D, 4.0D)
/* 296 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 297 */         .addNextBehavior(
/* 298 */           CECombatBehaviors.Behavior.builder()
/* 299 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 300 */           .withinDistance(0.0D, 6.0D)
/* 301 */           .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 302 */           .addNextBehavior(
/* 303 */             CECombatBehaviors.Behavior.builder()
/* 304 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 305 */             .withinDistance(0.0D, 7.0D)
/* 306 */             .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 307 */             .addNextBehavior(
/* 308 */               CECombatBehaviors.Behavior.builder()
/* 309 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 310 */               .withinDistance(0.0D, 6.0D)
/* 311 */               .custom(HerobrineCommon::canPerformGuarding)
/* 312 */               .guard(40)))))
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 317 */       .addFirstBehavior(
/* 318 */         CECombatBehaviors.Behavior.builder()
/* 319 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 320 */         .withinDistance(0.0D, 4.0D)
/* 321 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 322 */         .addNextBehavior(
/* 323 */           CECombatBehaviors.Behavior.builder()
/* 324 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 325 */           .withinDistance(0.0D, 5.0D)
/* 326 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 327 */           .addNextBehavior(
/* 328 */             CECombatBehaviors.Behavior.builder()
/* 329 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 330 */             .withinDistance(0.0D, 5.0D)
/* 331 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 332 */             .addNextBehavior(
/* 333 */               CECombatBehaviors.Behavior.builder()
/* 334 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 335 */               .withinDistance(0.0D, 6.0D)
/* 336 */               .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 337 */               .addNextBehavior(
/* 338 */                 CECombatBehaviors.Behavior.builder()
/* 339 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 340 */                 .withinDistance(0.0D, 6.0D)
/* 341 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 342 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 348 */       .addFirstBehavior(
/* 349 */         CECombatBehaviors.Behavior.builder()
/* 350 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 351 */         .withinDistance(0.0D, 5.0D)
/* 352 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 353 */         .addNextBehavior(
/* 354 */           CECombatBehaviors.Behavior.builder()
/* 355 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 356 */           .withinDistance(0.0D, 5.0D)
/* 357 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 358 */           .addNextBehavior(
/* 359 */             CECombatBehaviors.Behavior.builder()
/* 360 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 361 */             .withinDistance(0.0D, 6.0D)
/* 362 */             .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 363 */             .addNextBehavior(
/* 364 */               CECombatBehaviors.Behavior.builder()
/* 365 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 366 */               .withinDistance(0.0D, 6.0D)
/* 367 */               .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 368 */               .addNextBehavior(
/* 369 */                 CECombatBehaviors.Behavior.builder()
/* 370 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 371 */                 .withinDistance(0.0D, 6.0D)
/* 372 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 373 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 379 */       .addFirstBehavior(
/* 380 */         CECombatBehaviors.Behavior.builder()
/* 381 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 382 */         .withinDistance(0.0D, 6.0D)
/* 383 */         .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 384 */         .addNextBehavior(
/* 385 */           CECombatBehaviors.Behavior.builder()
/* 386 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 387 */           .withinDistance(0.0D, 5.0D)
/* 388 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 389 */           .addNextBehavior(
/* 390 */             CECombatBehaviors.Behavior.builder()
/* 391 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 392 */             .withinDistance(0.0D, 7.0D)
/* 393 */             .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 394 */             .addNextBehavior(
/* 395 */               CECombatBehaviors.Behavior.builder()
/* 396 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 397 */               .withinDistance(0.0D, 6.0D)
/* 398 */               .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 399 */               .addNextBehavior(
/* 400 */                 CECombatBehaviors.Behavior.builder()
/* 401 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 402 */                 .withinDistance(0.0D, 6.0D)
/* 403 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 404 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 410 */       .addFirstBehavior(
/* 411 */         CECombatBehaviors.Behavior.builder()
/* 412 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 413 */         .withinDistance(0.0D, 9.0D)
/* 414 */         .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 415 */         .addNextBehavior(
/* 416 */           CECombatBehaviors.Behavior.builder()
/* 417 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 418 */           .withinDistance(0.0D, 6.0D)
/* 419 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 420 */           .addNextBehavior(
/* 421 */             CECombatBehaviors.Behavior.builder()
/* 422 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 423 */             .withinDistance(0.0D, 6.0D)
/* 424 */             .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 425 */             .addNextBehavior(
/* 426 */               CECombatBehaviors.Behavior.builder()
/* 427 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 428 */               .withinDistance(0.0D, 7.0D)
/* 429 */               .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 430 */               .addNextBehavior(
/* 431 */                 CECombatBehaviors.Behavior.builder()
/* 432 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 433 */                 .withinDistance(0.0D, 6.0D)
/* 434 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 435 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 441 */       .addFirstBehavior(
/* 442 */         CECombatBehaviors.Behavior.builder()
/* 443 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 444 */         .withinDistance(0.0D, 4.0D)
/* 445 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 446 */         .addNextBehavior(
/* 447 */           CECombatBehaviors.Behavior.builder()
/* 448 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 449 */           .withinDistance(0.0D, 6.0D)
/* 450 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 451 */           .addNextBehavior(
/* 452 */             CECombatBehaviors.Behavior.builder()
/* 453 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 454 */             .withinDistance(0.0D, 6.0D)
/* 455 */             .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 456 */             .addNextBehavior(
/* 457 */               CECombatBehaviors.Behavior.builder()
/* 458 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 459 */               .withinDistance(0.0D, 7.0D)
/* 460 */               .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 461 */               .addNextBehavior(
/* 462 */                 CECombatBehaviors.Behavior.builder()
/* 463 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 464 */                 .withinDistance(0.0D, 6.0D)
/* 465 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 466 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 472 */       .addFirstBehavior(
/* 473 */         CECombatBehaviors.Behavior.builder()
/* 474 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 475 */         .withinDistance(0.0D, 5.0D)
/* 476 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 477 */         .addNextBehavior(
/* 478 */           CECombatBehaviors.Behavior.builder()
/* 479 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 480 */           .withinDistance(0.0D, 6.0D)
/* 481 */           .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 482 */           .addNextBehavior(
/* 483 */             CECombatBehaviors.Behavior.builder()
/* 484 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 485 */             .withinDistance(0.0D, 7.0D)
/* 486 */             .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 487 */             .addNextBehavior(
/* 488 */               CECombatBehaviors.Behavior.builder()
/* 489 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 490 */               .withinDistance(0.0D, 6.0D)
/* 491 */               .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 492 */               .addNextBehavior(
/* 493 */                 CECombatBehaviors.Behavior.builder()
/* 494 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 495 */                 .withinDistance(0.0D, 6.0D)
/* 496 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 497 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 503 */       .addFirstBehavior(
/* 504 */         CECombatBehaviors.Behavior.builder()
/* 505 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 506 */         .withinDistance(0.0D, 6.0D)
/* 507 */         .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 508 */         .addNextBehavior(
/* 509 */           CECombatBehaviors.Behavior.builder()
/* 510 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 511 */           .withinDistance(0.0D, 5.0D)
/* 512 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 513 */           .addNextBehavior(
/* 514 */             CECombatBehaviors.Behavior.builder()
/* 515 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 516 */             .withinDistance(0.0D, 7.0D)
/* 517 */             .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 518 */             .addNextBehavior(
/* 519 */               CECombatBehaviors.Behavior.builder()
/* 520 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 521 */               .withinDistance(0.0D, 9.0D)
/* 522 */               .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 523 */               .addNextBehavior(
/* 524 */                 CECombatBehaviors.Behavior.builder()
/* 525 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 526 */                 .withinDistance(0.0D, 6.0D)
/* 527 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 528 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 534 */       .addFirstBehavior(
/* 535 */         CECombatBehaviors.Behavior.builder()
/* 536 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 537 */         .withinDistance(0.0D, 6.0D)
/* 538 */         .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 539 */         .addNextBehavior(
/* 540 */           CECombatBehaviors.Behavior.builder()
/* 541 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 542 */           .withinDistance(0.0D, 4.0D)
/* 543 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 544 */           .addNextBehavior(
/* 545 */             CECombatBehaviors.Behavior.builder()
/* 546 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 547 */             .withinDistance(0.0D, 5.0D)
/* 548 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 549 */             .addNextBehavior(
/* 550 */               CECombatBehaviors.Behavior.builder()
/* 551 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 552 */               .withinDistance(0.0D, 7.0D)
/* 553 */               .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 554 */               .addNextBehavior(
/* 555 */                 CECombatBehaviors.Behavior.builder()
/* 556 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 557 */                 .withinDistance(0.0D, 6.0D)
/* 558 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 559 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 565 */       .addFirstBehavior(
/* 566 */         CECombatBehaviors.Behavior.builder()
/* 567 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 568 */         .withinDistance(0.0D, 9.0D)
/* 569 */         .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 570 */         .addNextBehavior(
/* 571 */           CECombatBehaviors.Behavior.builder()
/* 572 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 573 */           .withinDistance(0.0D, 4.0D)
/* 574 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 575 */           .addNextBehavior(
/* 576 */             CECombatBehaviors.Behavior.builder()
/* 577 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 578 */             .withinDistance(0.0D, 5.0D)
/* 579 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 580 */             .addNextBehavior(
/* 581 */               CECombatBehaviors.Behavior.builder()
/* 582 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 583 */               .withinDistance(0.0D, 6.0D)
/* 584 */               .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 585 */               .addNextBehavior(
/* 586 */                 CECombatBehaviors.Behavior.builder()
/* 587 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 588 */                 .withinDistance(0.0D, 6.0D)
/* 589 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 590 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 596 */       .addFirstBehavior(
/* 597 */         CECombatBehaviors.Behavior.builder()
/* 598 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 599 */         .withinDistance(0.0D, 7.0D)
/* 600 */         .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 601 */         .addNextBehavior(
/* 602 */           CECombatBehaviors.Behavior.builder()
/* 603 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 604 */           .withinDistance(0.0D, 6.0D)
/* 605 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 606 */           .addNextBehavior(
/* 607 */             CECombatBehaviors.Behavior.builder()
/* 608 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 609 */             .withinDistance(0.0D, 5.0D)
/* 610 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 611 */             .addNextBehavior(
/* 612 */               CECombatBehaviors.Behavior.builder()
/* 613 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 614 */               .withinDistance(0.0D, 6.0D)
/* 615 */               .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 616 */               .addNextBehavior(
/* 617 */                 CECombatBehaviors.Behavior.builder()
/* 618 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 619 */                 .withinDistance(0.0D, 6.0D)
/* 620 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 621 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 627 */       .addFirstBehavior(
/* 628 */         CECombatBehaviors.Behavior.builder()
/* 629 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 630 */         .withinDistance(0.0D, 7.0D)
/* 631 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 632 */         .addNextBehavior(
/* 633 */           CECombatBehaviors.Behavior.builder()
/* 634 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 635 */           .withinDistance(0.0D, 5.0D)
/* 636 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 637 */           .addNextBehavior(
/* 638 */             CECombatBehaviors.Behavior.builder()
/* 639 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 640 */             .withinDistance(0.0D, 7.0D)
/* 641 */             .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 642 */             .addNextBehavior(
/* 643 */               CECombatBehaviors.Behavior.builder()
/* 644 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 645 */               .withinDistance(0.0D, 9.0D)
/* 646 */               .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 647 */               .addNextBehavior(
/* 648 */                 CECombatBehaviors.Behavior.builder()
/* 649 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 650 */                 .withinDistance(0.0D, 6.0D)
/* 651 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 652 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 658 */       .addFirstBehavior(
/* 659 */         CECombatBehaviors.Behavior.builder()
/* 660 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 661 */         .withinDistance(0.0D, 5.0D)
/* 662 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 663 */         .addNextBehavior(
/* 664 */           CECombatBehaviors.Behavior.builder()
/* 665 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 666 */           .withinDistance(0.0D, 6.0D)
/* 667 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 668 */           .addNextBehavior(
/* 669 */             CECombatBehaviors.Behavior.builder()
/* 670 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 671 */             .withinDistance(0.0D, 7.0D)
/* 672 */             .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 673 */             .addNextBehavior(
/* 674 */               CECombatBehaviors.Behavior.builder()
/* 675 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 676 */               .withinDistance(0.0D, 7.0D)
/* 677 */               .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 678 */               .addNextBehavior(
/* 679 */                 CECombatBehaviors.Behavior.builder()
/* 680 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 681 */                 .withinDistance(0.0D, 6.0D)
/* 682 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 683 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 689 */       .addFirstBehavior(
/* 690 */         CECombatBehaviors.Behavior.builder()
/* 691 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 692 */         .withinDistance(0.0D, 4.0D)
/* 693 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 694 */         .addNextBehavior(
/* 695 */           CECombatBehaviors.Behavior.builder()
/* 696 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 697 */           .withinDistance(0.0D, 9.0D)
/* 698 */           .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 699 */           .addNextBehavior(
/* 700 */             CECombatBehaviors.Behavior.builder()
/* 701 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 702 */             .withinDistance(0.0D, 6.0D)
/* 703 */             .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 704 */             .addNextBehavior(
/* 705 */               CECombatBehaviors.Behavior.builder()
/* 706 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 707 */               .withinDistance(0.0D, 6.0D)
/* 708 */               .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 709 */               .addNextBehavior(
/* 710 */                 CECombatBehaviors.Behavior.builder()
/* 711 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 712 */                 .withinDistance(0.0D, 6.0D)
/* 713 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 714 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 720 */       .addFirstBehavior(
/* 721 */         CECombatBehaviors.Behavior.builder()
/* 722 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 723 */         .withinDistance(0.0D, 6.0D)
/* 724 */         .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 725 */         .addNextBehavior(
/* 726 */           CECombatBehaviors.Behavior.builder()
/* 727 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 728 */           .withinDistance(0.0D, 7.0D)
/* 729 */           .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 730 */           .addNextBehavior(
/* 731 */             CECombatBehaviors.Behavior.builder()
/* 732 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 733 */             .withinDistance(0.0D, 6.0D)
/* 734 */             .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 735 */             .addNextBehavior(
/* 736 */               CECombatBehaviors.Behavior.builder()
/* 737 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 738 */               .withinDistance(0.0D, 7.0D)
/* 739 */               .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 740 */               .addNextBehavior(
/* 741 */                 CECombatBehaviors.Behavior.builder()
/* 742 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 743 */                 .withinDistance(0.0D, 6.0D)
/* 744 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 745 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 751 */       .addFirstBehavior(
/* 752 */         CECombatBehaviors.Behavior.builder()
/* 753 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 754 */         .withinDistance(0.0D, 5.0D)
/* 755 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 756 */         .addNextBehavior(
/* 757 */           CECombatBehaviors.Behavior.builder()
/* 758 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 759 */           .withinDistance(0.0D, 6.0D)
/* 760 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, 0.0F)
/* 761 */           .addNextBehavior(
/* 762 */             CECombatBehaviors.Behavior.builder()
/* 763 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 764 */             .withinDistance(0.0D, 4.0D)
/* 765 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 766 */             .addNextBehavior(
/* 767 */               CECombatBehaviors.Behavior.builder()
/* 768 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 769 */               .withinDistance(0.0D, 7.0D)
/* 770 */               .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 771 */               .addNextBehavior(
/* 772 */                 CECombatBehaviors.Behavior.builder()
/* 773 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 774 */                 .withinDistance(0.0D, 6.0D)
/* 775 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 776 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 782 */       .addFirstBehavior(
/* 783 */         CECombatBehaviors.Behavior.builder()
/* 784 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 785 */         .withinDistance(0.0D, 6.0D)
/* 786 */         .animationBehavior(AnimsSolar.SOLAR_QUEMADURA, 0.0F)
/* 787 */         .addNextBehavior(
/* 788 */           CECombatBehaviors.Behavior.builder()
/* 789 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 790 */           .withinDistance(0.0D, 6.0D)
/* 791 */           .animationBehavior(AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, 0.0F)
/* 792 */           .addNextBehavior(
/* 793 */             CECombatBehaviors.Behavior.builder()
/* 794 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 795 */             .withinDistance(0.0D, 9.0D)
/* 796 */             .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 797 */             .addNextBehavior(
/* 798 */               CECombatBehaviors.Behavior.builder()
/* 799 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 800 */               .withinDistance(0.0D, 7.0D)
/* 801 */               .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 802 */               .addNextBehavior(
/* 803 */                 CECombatBehaviors.Behavior.builder()
/* 804 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 805 */                 .withinDistance(0.0D, 6.0D)
/* 806 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 807 */                 .guard(40))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 813 */       .addFirstBehavior(
/* 814 */         CECombatBehaviors.Behavior.builder()
/* 815 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 816 */         .withinDistance(0.0D, 5.0D)
/* 817 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 818 */         .addNextBehavior(
/* 819 */           CECombatBehaviors.Behavior.builder()
/* 820 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 821 */           .withinDistance(0.0D, 7.0D)
/* 822 */           .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 823 */           .addNextBehavior(
/* 824 */             CECombatBehaviors.Behavior.builder()
/* 825 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 826 */             .withinDistance(0.0D, 5.0D)
/* 827 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_3, 0.0F)
/* 828 */             .addNextBehavior(
/* 829 */               CECombatBehaviors.Behavior.builder()
/* 830 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 831 */               .withinDistance(0.0D, 7.0D)
/* 832 */               .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F)
/* 833 */               .addNextBehavior(
/* 834 */                 CECombatBehaviors.Behavior.builder()
/* 835 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 836 */                 .withinDistance(0.0D, 6.0D)
/* 837 */                 .custom(HerobrineCommon::canPerformGuarding)
/* 838 */                 .guard(40)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 845 */     .newBehaviorRoot(
/* 846 */       CECombatBehaviors.BehaviorRoot.builder()
/* 847 */       .priority(1.0D)
/* 848 */       .weight(30.0D)
/* 849 */       .maxCooldown(120)
/* 850 */       .addFirstBehavior(
/* 851 */         CECombatBehaviors.Behavior.builder()
/* 852 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 853 */         .withinDistance(0.0D, 5.0D)
/* 854 */         .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 855 */         .addNextBehavior(
/* 856 */           CECombatBehaviors.Behavior.builder()
/* 857 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 858 */           .withinDistance(0.0D, 5.0D)
/* 859 */           .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)
/* 860 */           .addNextBehavior(
/* 861 */             CECombatBehaviors.Behavior.builder()
/* 862 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 863 */             .withinDistance(0.0D, 5.0D)
/* 864 */             .animationBehavior(AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 869 */     .newBehaviorRoot(
/* 870 */       CECombatBehaviors.BehaviorRoot.builder()
/* 871 */       .priority(1.0D)
/* 872 */       .weight(20.0D)
/* 873 */       .maxCooldown(100)
/* 874 */       .addFirstBehavior(
/* 875 */         CECombatBehaviors.Behavior.builder()
/* 876 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 877 */         .withinDistance(0.0D, 5.0D)
/* 878 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, 0.0F))
/*     */       
/* 880 */       .addFirstBehavior(
/* 881 */         CECombatBehaviors.Behavior.builder()
/* 882 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 883 */         .withinDistance(0.0D, 5.0D)
/* 884 */         .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)))
/*     */ 
/*     */     
/* 887 */     .newBehaviorRoot(
/* 888 */       CECombatBehaviors.BehaviorRoot.builder()
/* 889 */       .priority(1.0D)
/* 890 */       .weight(15.0D)
/* 891 */       .maxCooldown(600)
/* 892 */       .addFirstBehavior(
/* 893 */         CECombatBehaviors.Behavior.builder()
/* 894 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 895 */         .custom(HerobrineCommon::canChangeToSecondForm)
/* 896 */         .withinDistance(0.0D, 8.0D)
/* 897 */         .animationBehavior(AVAnimations.ENDER_AEGIS_NAPOLEON_RELOAD_1, 0.0F)
/* 898 */         .addExBehavior(HerobrineCommon::changeToSecondForm)))
/*     */ 
/*     */     
/* 901 */     .newBehaviorRoot(
/* 902 */       CECombatBehaviors.BehaviorRoot.builder()
/* 903 */       .priority(1.0D)
/* 904 */       .weight(25.0D)
/* 905 */       .maxCooldown(300)
/* 906 */       .addFirstBehavior(
/* 907 */         CECombatBehaviors.Behavior.builder()
/* 908 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 909 */         .withinDistance(0.0D, 8.0D)
/* 910 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/* 911 */         .animationBehavior(AVAnimations.AEGIS_SHIELD_SHOOT, 0.0F)
/* 912 */         .addExBehavior(HerobrineCommon::playSecondFormAnimation)))
/*     */ 
/*     */     
/* 915 */     .newBehaviorRoot(
/* 916 */       CECombatBehaviors.BehaviorRoot.builder()
/* 917 */       .priority(1.0D)
/* 918 */       .weight(30.0D)
/* 919 */       .addFirstBehavior(
/* 920 */         CECombatBehaviors.Behavior.builder()
/* 921 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 922 */         .withinDistance(0.0D, 3.0D)
/* 923 */         .custom(HerobrineCommon::canPerformGuarding)
/* 924 */         .guard(40)))
/*     */ 
/*     */     
/* 927 */     .newBehaviorRoot(
/* 928 */       CECombatBehaviors.BehaviorRoot.builder()
/* 929 */       .priority(1.0D)
/* 930 */       .weight(10.0D)
/* 931 */       .addFirstBehavior(
/* 932 */         CECombatBehaviors.Behavior.builder()
/* 933 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 934 */         .withinDistance(0.0D, 5.0D)
/* 935 */         .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F))
/*     */       
/* 937 */       .addFirstBehavior(
/* 938 */         CECombatBehaviors.Behavior.builder()
/* 939 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 940 */         .withinDistance(0.0D, 5.0D)
/* 941 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F))
/*     */       
/* 943 */       .addFirstBehavior(
/* 944 */         CECombatBehaviors.Behavior.builder()
/* 945 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 946 */         .withinDistance(0.0D, 5.0D)
/* 947 */         .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F))
/*     */       
/* 949 */       .addFirstBehavior(
/* 950 */         CECombatBehaviors.Behavior.builder()
/* 951 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 952 */         .withinDistance(0.0D, 5.0D)
/* 953 */         .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)))
/*     */ 
/*     */     
/* 956 */     .newBehaviorRoot(
/* 957 */       CECombatBehaviors.BehaviorRoot.builder()
/* 958 */       .priority(1.0D)
/* 959 */       .weight(20.0D)
/* 960 */       .maxCooldown(160)
/* 961 */       .addFirstBehavior(
/* 962 */         CECombatBehaviors.Behavior.builder()
/* 963 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 964 */         .custom(HerobrineCommon::canJump)
/* 965 */         .withinDistance(5.0D, 14.0D)
/* 966 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 967 */         .addExBehavior(HerobrineCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineEnderAegis.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */