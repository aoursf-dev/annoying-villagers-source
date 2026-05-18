/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsRuine;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HerobrineDemoniacVoltageReaver
/*     */ {
/*  17 */   public static final CECombatBehaviors.Builder<MobPatch<?>> DEMONIAC_VOLTAGE_REAVER = CECombatBehaviors.builder()
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
/*  40 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  41 */         .addExBehavior(HerobrineCommon::performEscapeRunAwayWithLowClone))
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
/*  57 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  58 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  59 */         .custom(HerobrineCommon::canPerformHealing)
/*  60 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*  61 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*     */ 
/*     */     
/*  64 */     .newBehaviorRoot(
/*  65 */       CECombatBehaviors.BehaviorRoot.builder()
/*  66 */       .priority(1.0D)
/*  67 */       .weight(30.0D)
/*  68 */       .maxCooldown(120)
/*  69 */       .addFirstBehavior(
/*  70 */         CECombatBehaviors.Behavior.builder()
/*  71 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  72 */         .withinDistance(7.0D, 48.0D)
/*  73 */         .animationBehavior(AVAnimations.HEROBRINE_MOB_ENDERSTEP_OBSCURIS, 0.0F)
/*  74 */         .addExBehavior(HerobrineCommon::giveSlowFalling)))
/*     */ 
/*     */     
/*  77 */     .newBehaviorRoot(
/*  78 */       CECombatBehaviors.BehaviorRoot.builder()
/*  79 */       .priority(1.0D)
/*  80 */       .weight(40.0D)
/*  81 */       .maxCooldown(20)
/*  82 */       .addFirstBehavior(
/*  83 */         CECombatBehaviors.Behavior.builder()
/*  84 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  85 */         .withinDistance(0.0D, 5.0D)
/*  86 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  87 */         .addNextBehavior(
/*  88 */           CECombatBehaviors.Behavior.builder()
/*  89 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  90 */           .withinDistance(0.0D, 6.0D)
/*  91 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  92 */           .addNextBehavior(
/*  93 */             CECombatBehaviors.Behavior.builder()
/*  94 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  95 */             .withinDistance(0.0D, 6.0D)
/*  96 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  97 */             .addNextBehavior(
/*  98 */               CECombatBehaviors.Behavior.builder()
/*  99 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 100 */               .withinDistance(0.0D, 6.0D)
/* 101 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 102 */               .addNextBehavior(
/* 103 */                 CECombatBehaviors.Behavior.builder()
/* 104 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 105 */                 .withinDistance(0.0D, 8.0D)
/* 106 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 112 */       .addFirstBehavior(
/* 113 */         CECombatBehaviors.Behavior.builder()
/* 114 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 115 */         .withinDistance(0.0D, 8.0D)
/* 116 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/* 117 */         .addNextBehavior(
/* 118 */           CECombatBehaviors.Behavior.builder()
/* 119 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 120 */           .withinDistance(0.0D, 6.0D)
/* 121 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 122 */           .addNextBehavior(
/* 123 */             CECombatBehaviors.Behavior.builder()
/* 124 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 125 */             .withinDistance(0.0D, 8.0D)
/* 126 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 127 */             .addNextBehavior(
/* 128 */               CECombatBehaviors.Behavior.builder()
/* 129 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 130 */               .withinDistance(0.0D, 8.0D)
/* 131 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 132 */               .addNextBehavior(
/* 133 */                 CECombatBehaviors.Behavior.builder()
/* 134 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 135 */                 .withinDistance(0.0D, 8.0D)
/* 136 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       .addFirstBehavior(
/* 143 */         CECombatBehaviors.Behavior.builder()
/* 144 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 145 */         .withinDistance(0.0D, 10.0D)
/* 146 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 147 */         .addNextBehavior(
/* 148 */           CECombatBehaviors.Behavior.builder()
/* 149 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 150 */           .withinDistance(0.0D, 6.0D)
/* 151 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 152 */           .addNextBehavior(
/* 153 */             CECombatBehaviors.Behavior.builder()
/* 154 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 155 */             .withinDistance(0.0D, 6.0D)
/* 156 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/* 157 */             .addNextBehavior(
/* 158 */               CECombatBehaviors.Behavior.builder()
/* 159 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 160 */               .withinDistance(0.0D, 6.0D)
/* 161 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 162 */               .addNextBehavior(
/* 163 */                 CECombatBehaviors.Behavior.builder()
/* 164 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 165 */                 .withinDistance(0.0D, 8.0D)
/* 166 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 172 */       .addFirstBehavior(
/* 173 */         CECombatBehaviors.Behavior.builder()
/* 174 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 175 */         .withinDistance(0.0D, 8.0D)
/* 176 */         .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 177 */         .addNextBehavior(
/* 178 */           CECombatBehaviors.Behavior.builder()
/* 179 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 180 */           .withinDistance(0.0D, 6.0D)
/* 181 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 182 */           .addNextBehavior(
/* 183 */             CECombatBehaviors.Behavior.builder()
/* 184 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 185 */             .withinDistance(0.0D, 6.0D)
/* 186 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 187 */             .addNextBehavior(
/* 188 */               CECombatBehaviors.Behavior.builder()
/* 189 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 190 */               .withinDistance(0.0D, 6.0D)
/* 191 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)
/* 192 */               .addNextBehavior(
/* 193 */                 CECombatBehaviors.Behavior.builder()
/* 194 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 195 */                 .withinDistance(0.0D, 8.0D)
/* 196 */                 .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 202 */       .addFirstBehavior(
/* 203 */         CECombatBehaviors.Behavior.builder()
/* 204 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 205 */         .withinDistance(0.0D, 6.0D)
/* 206 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 207 */         .addNextBehavior(
/* 208 */           CECombatBehaviors.Behavior.builder()
/* 209 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 210 */           .withinDistance(0.0D, 8.0D)
/* 211 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 212 */           .addNextBehavior(
/* 213 */             CECombatBehaviors.Behavior.builder()
/* 214 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 215 */             .withinDistance(0.0D, 6.0D)
/* 216 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/* 217 */             .addNextBehavior(
/* 218 */               CECombatBehaviors.Behavior.builder()
/* 219 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 220 */               .withinDistance(0.0D, 6.0D)
/* 221 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/* 222 */               .addNextBehavior(
/* 223 */                 CECombatBehaviors.Behavior.builder()
/* 224 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 225 */                 .withinDistance(0.0D, 6.0D)
/* 226 */                 .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 232 */       .addFirstBehavior(
/* 233 */         CECombatBehaviors.Behavior.builder()
/* 234 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 235 */         .withinDistance(0.0D, 5.0D)
/* 236 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 237 */         .addNextBehavior(
/* 238 */           CECombatBehaviors.Behavior.builder()
/* 239 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 240 */           .withinDistance(0.0D, 6.0D)
/* 241 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 242 */           .addNextBehavior(
/* 243 */             CECombatBehaviors.Behavior.builder()
/* 244 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 245 */             .withinDistance(0.0D, 6.0D)
/* 246 */             .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/* 247 */             .addNextBehavior(
/* 248 */               CECombatBehaviors.Behavior.builder()
/* 249 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 250 */               .withinDistance(0.0D, 8.0D)
/* 251 */               .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 252 */               .addNextBehavior(
/* 253 */                 CECombatBehaviors.Behavior.builder()
/* 254 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 255 */                 .withinDistance(0.0D, 8.0D)
/* 256 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 262 */       .addFirstBehavior(
/* 263 */         CECombatBehaviors.Behavior.builder()
/* 264 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 265 */         .withinDistance(0.0D, 5.0D)
/* 266 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/* 267 */         .addNextBehavior(
/* 268 */           CECombatBehaviors.Behavior.builder()
/* 269 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 270 */           .withinDistance(0.0D, 6.0D)
/* 271 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 272 */           .addNextBehavior(
/* 273 */             CECombatBehaviors.Behavior.builder()
/* 274 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 275 */             .withinDistance(0.0D, 6.0D)
/* 276 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 277 */             .addNextBehavior(
/* 278 */               CECombatBehaviors.Behavior.builder()
/* 279 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 280 */               .withinDistance(0.0D, 6.0D)
/* 281 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/* 282 */               .addNextBehavior(
/* 283 */                 CECombatBehaviors.Behavior.builder()
/* 284 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 285 */                 .withinDistance(0.0D, 8.0D)
/* 286 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 292 */       .addFirstBehavior(
/* 293 */         CECombatBehaviors.Behavior.builder()
/* 294 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 295 */         .withinDistance(0.0D, 8.0D)
/* 296 */         .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 297 */         .addNextBehavior(
/* 298 */           CECombatBehaviors.Behavior.builder()
/* 299 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 300 */           .withinDistance(0.0D, 8.0D)
/* 301 */           .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/* 302 */           .addNextBehavior(
/* 303 */             CECombatBehaviors.Behavior.builder()
/* 304 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 305 */             .withinDistance(0.0D, 6.0D)
/* 306 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 307 */             .addNextBehavior(
/* 308 */               CECombatBehaviors.Behavior.builder()
/* 309 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 310 */               .withinDistance(0.0D, 6.0D)
/* 311 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 312 */               .addNextBehavior(
/* 313 */                 CECombatBehaviors.Behavior.builder()
/* 314 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 315 */                 .withinDistance(0.0D, 6.0D)
/* 316 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 322 */       .addFirstBehavior(
/* 323 */         CECombatBehaviors.Behavior.builder()
/* 324 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 325 */         .withinDistance(0.0D, 5.0D)
/* 326 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/* 327 */         .addNextBehavior(
/* 328 */           CECombatBehaviors.Behavior.builder()
/* 329 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 330 */           .withinDistance(0.0D, 8.0D)
/* 331 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 332 */           .addNextBehavior(
/* 333 */             CECombatBehaviors.Behavior.builder()
/* 334 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 335 */             .withinDistance(0.0D, 8.0D)
/* 336 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 337 */             .addNextBehavior(
/* 338 */               CECombatBehaviors.Behavior.builder()
/* 339 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 340 */               .withinDistance(0.0D, 6.0D)
/* 341 */               .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 342 */               .addNextBehavior(
/* 343 */                 CECombatBehaviors.Behavior.builder()
/* 344 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 345 */                 .withinDistance(0.0D, 8.0D)
/* 346 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 352 */       .addFirstBehavior(
/* 353 */         CECombatBehaviors.Behavior.builder()
/* 354 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 355 */         .withinDistance(0.0D, 5.0D)
/* 356 */         .animationBehavior(AnimsAgony.AGONY_RIPPING_FANGS, 0.0F)
/* 357 */         .addNextBehavior(
/* 358 */           CECombatBehaviors.Behavior.builder()
/* 359 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 360 */           .withinDistance(0.0D, 6.0D)
/* 361 */           .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/* 362 */           .addNextBehavior(
/* 363 */             CECombatBehaviors.Behavior.builder()
/* 364 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 365 */             .withinDistance(0.0D, 6.0D)
/* 366 */             .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)
/* 367 */             .addNextBehavior(
/* 368 */               CECombatBehaviors.Behavior.builder()
/* 369 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 370 */               .withinDistance(0.0D, 8.0D)
/* 371 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 372 */               .addNextBehavior(
/* 373 */                 CECombatBehaviors.Behavior.builder()
/* 374 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 375 */                 .withinDistance(0.0D, 8.0D)
/* 376 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 382 */       .addFirstBehavior(
/* 383 */         CECombatBehaviors.Behavior.builder()
/* 384 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 385 */         .withinDistance(0.0D, 5.0D)
/* 386 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 387 */         .addNextBehavior(
/* 388 */           CECombatBehaviors.Behavior.builder()
/* 389 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 390 */           .withinDistance(0.0D, 8.0D)
/* 391 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 392 */           .addNextBehavior(
/* 393 */             CECombatBehaviors.Behavior.builder()
/* 394 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 395 */             .withinDistance(0.0D, 6.0D)
/* 396 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/* 397 */             .addNextBehavior(
/* 398 */               CECombatBehaviors.Behavior.builder()
/* 399 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 400 */               .withinDistance(0.0D, 6.0D)
/* 401 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/* 402 */               .addNextBehavior(
/* 403 */                 CECombatBehaviors.Behavior.builder()
/* 404 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 405 */                 .withinDistance(0.0D, 6.0D)
/* 406 */                 .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 412 */       .addFirstBehavior(
/* 413 */         CECombatBehaviors.Behavior.builder()
/* 414 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 415 */         .withinDistance(0.0D, 5.0D)
/* 416 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 417 */         .addNextBehavior(
/* 418 */           CECombatBehaviors.Behavior.builder()
/* 419 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 420 */           .withinDistance(0.0D, 6.0D)
/* 421 */           .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 422 */           .addNextBehavior(
/* 423 */             CECombatBehaviors.Behavior.builder()
/* 424 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 425 */             .withinDistance(0.0D, 6.0D)
/* 426 */             .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/* 427 */             .addNextBehavior(
/* 428 */               CECombatBehaviors.Behavior.builder()
/* 429 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 430 */               .withinDistance(0.0D, 6.0D)
/* 431 */               .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 432 */               .addNextBehavior(
/* 433 */                 CECombatBehaviors.Behavior.builder()
/* 434 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 435 */                 .withinDistance(0.0D, 8.0D)
/* 436 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 442 */       .addFirstBehavior(
/* 443 */         CECombatBehaviors.Behavior.builder()
/* 444 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 445 */         .withinDistance(0.0D, 5.0D)
/* 446 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/* 447 */         .addNextBehavior(
/* 448 */           CECombatBehaviors.Behavior.builder()
/* 449 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 450 */           .withinDistance(0.0D, 8.0D)
/* 451 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 452 */           .addNextBehavior(
/* 453 */             CECombatBehaviors.Behavior.builder()
/* 454 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 455 */             .withinDistance(0.0D, 6.0D)
/* 456 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 457 */             .addNextBehavior(
/* 458 */               CECombatBehaviors.Behavior.builder()
/* 459 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 460 */               .withinDistance(0.0D, 6.0D)
/* 461 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)
/* 462 */               .addNextBehavior(
/* 463 */                 CECombatBehaviors.Behavior.builder()
/* 464 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 465 */                 .withinDistance(0.0D, 8.0D)
/* 466 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 472 */       .addFirstBehavior(
/* 473 */         CECombatBehaviors.Behavior.builder()
/* 474 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 475 */         .withinDistance(0.0D, 5.0D)
/* 476 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/* 477 */         .addNextBehavior(
/* 478 */           CECombatBehaviors.Behavior.builder()
/* 479 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 480 */           .withinDistance(0.0D, 6.0D)
/* 481 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 482 */           .addNextBehavior(
/* 483 */             CECombatBehaviors.Behavior.builder()
/* 484 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 485 */             .withinDistance(0.0D, 8.0D)
/* 486 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 487 */             .addNextBehavior(
/* 488 */               CECombatBehaviors.Behavior.builder()
/* 489 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 490 */               .withinDistance(0.0D, 8.0D)
/* 491 */               .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/* 492 */               .addNextBehavior(
/* 493 */                 CECombatBehaviors.Behavior.builder()
/* 494 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 495 */                 .withinDistance(0.0D, 8.0D)
/* 496 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 502 */       .addFirstBehavior(
/* 503 */         CECombatBehaviors.Behavior.builder()
/* 504 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 505 */         .withinDistance(0.0D, 8.0D)
/* 506 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/* 507 */         .addNextBehavior(
/* 508 */           CECombatBehaviors.Behavior.builder()
/* 509 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 510 */           .withinDistance(0.0D, 8.0D)
/* 511 */           .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)
/* 512 */           .addNextBehavior(
/* 513 */             CECombatBehaviors.Behavior.builder()
/* 514 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 515 */             .withinDistance(0.0D, 8.0D)
/* 516 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 517 */             .addNextBehavior(
/* 518 */               CECombatBehaviors.Behavior.builder()
/* 519 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 520 */               .withinDistance(0.0D, 6.0D)
/* 521 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/* 522 */               .addNextBehavior(
/* 523 */                 CECombatBehaviors.Behavior.builder()
/* 524 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 525 */                 .withinDistance(0.0D, 8.0D)
/* 526 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 532 */       .addFirstBehavior(
/* 533 */         CECombatBehaviors.Behavior.builder()
/* 534 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 535 */         .withinDistance(0.0D, 5.0D)
/* 536 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/* 537 */         .addNextBehavior(
/* 538 */           CECombatBehaviors.Behavior.builder()
/* 539 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 540 */           .withinDistance(0.0D, 6.0D)
/* 541 */           .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/* 542 */           .addNextBehavior(
/* 543 */             CECombatBehaviors.Behavior.builder()
/* 544 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 545 */             .withinDistance(0.0D, 6.0D)
/* 546 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 547 */             .addNextBehavior(
/* 548 */               CECombatBehaviors.Behavior.builder()
/* 549 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 550 */               .withinDistance(0.0D, 6.0D)
/* 551 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/* 552 */               .addNextBehavior(
/* 553 */                 CECombatBehaviors.Behavior.builder()
/* 554 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 555 */                 .withinDistance(0.0D, 6.0D)
/* 556 */                 .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 562 */       .addFirstBehavior(
/* 563 */         CECombatBehaviors.Behavior.builder()
/* 564 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 565 */         .withinDistance(0.0D, 10.0D)
/* 566 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 567 */         .addNextBehavior(
/* 568 */           CECombatBehaviors.Behavior.builder()
/* 569 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 570 */           .withinDistance(0.0D, 8.0D)
/* 571 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 572 */           .addNextBehavior(
/* 573 */             CECombatBehaviors.Behavior.builder()
/* 574 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 575 */             .withinDistance(0.0D, 6.0D)
/* 576 */             .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 577 */             .addNextBehavior(
/* 578 */               CECombatBehaviors.Behavior.builder()
/* 579 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 580 */               .withinDistance(0.0D, 6.0D)
/* 581 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/* 582 */               .addNextBehavior(
/* 583 */                 CECombatBehaviors.Behavior.builder()
/* 584 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 585 */                 .withinDistance(0.0D, 6.0D)
/* 586 */                 .animationBehavior(Animations.THE_GUILLOTINE, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 592 */       .addFirstBehavior(
/* 593 */         CECombatBehaviors.Behavior.builder()
/* 594 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 595 */         .withinDistance(0.0D, 5.0D)
/* 596 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 597 */         .addNextBehavior(
/* 598 */           CECombatBehaviors.Behavior.builder()
/* 599 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 600 */           .withinDistance(0.0D, 8.0D)
/* 601 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 602 */           .addNextBehavior(
/* 603 */             CECombatBehaviors.Behavior.builder()
/* 604 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 605 */             .withinDistance(0.0D, 6.0D)
/* 606 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 607 */             .addNextBehavior(
/* 608 */               CECombatBehaviors.Behavior.builder()
/* 609 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 610 */               .withinDistance(0.0D, 6.0D)
/* 611 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 612 */               .addNextBehavior(
/* 613 */                 CECombatBehaviors.Behavior.builder()
/* 614 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 615 */                 .withinDistance(0.0D, 6.0D)
/* 616 */                 .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 622 */       .addFirstBehavior(
/* 623 */         CECombatBehaviors.Behavior.builder()
/* 624 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 625 */         .withinDistance(0.0D, 5.0D)
/* 626 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/* 627 */         .addNextBehavior(
/* 628 */           CECombatBehaviors.Behavior.builder()
/* 629 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 630 */           .withinDistance(0.0D, 8.0D)
/* 631 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 632 */           .addNextBehavior(
/* 633 */             CECombatBehaviors.Behavior.builder()
/* 634 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 635 */             .withinDistance(0.0D, 8.0D)
/* 636 */             .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/* 637 */             .addNextBehavior(
/* 638 */               CECombatBehaviors.Behavior.builder()
/* 639 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 640 */               .withinDistance(0.0D, 10.0D)
/* 641 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 642 */               .addNextBehavior(
/* 643 */                 CECombatBehaviors.Behavior.builder()
/* 644 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 645 */                 .withinDistance(0.0D, 8.0D)
/* 646 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 652 */       .addFirstBehavior(
/* 653 */         CECombatBehaviors.Behavior.builder()
/* 654 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 655 */         .withinDistance(0.0D, 6.0D)
/* 656 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 657 */         .addNextBehavior(
/* 658 */           CECombatBehaviors.Behavior.builder()
/* 659 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 660 */           .withinDistance(0.0D, 6.0D)
/* 661 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 662 */           .addNextBehavior(
/* 663 */             CECombatBehaviors.Behavior.builder()
/* 664 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 665 */             .withinDistance(0.0D, 6.0D)
/* 666 */             .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 667 */             .addNextBehavior(
/* 668 */               CECombatBehaviors.Behavior.builder()
/* 669 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 670 */               .withinDistance(0.0D, 10.0D)
/* 671 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 672 */               .addNextBehavior(
/* 673 */                 CECombatBehaviors.Behavior.builder()
/* 674 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 675 */                 .withinDistance(0.0D, 8.0D)
/* 676 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 682 */       .addFirstBehavior(
/* 683 */         CECombatBehaviors.Behavior.builder()
/* 684 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 685 */         .withinDistance(0.0D, 8.0D)
/* 686 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 687 */         .addNextBehavior(
/* 688 */           CECombatBehaviors.Behavior.builder()
/* 689 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 690 */           .withinDistance(0.0D, 8.0D)
/* 691 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 692 */           .addNextBehavior(
/* 693 */             CECombatBehaviors.Behavior.builder()
/* 694 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 695 */             .withinDistance(0.0D, 6.0D)
/* 696 */             .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)
/* 697 */             .addNextBehavior(
/* 698 */               CECombatBehaviors.Behavior.builder()
/* 699 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 700 */               .withinDistance(0.0D, 6.0D)
/* 701 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)
/* 702 */               .addNextBehavior(
/* 703 */                 CECombatBehaviors.Behavior.builder()
/* 704 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 705 */                 .withinDistance(0.0D, 8.0D)
/* 706 */                 .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 712 */       .addFirstBehavior(
/* 713 */         CECombatBehaviors.Behavior.builder()
/* 714 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 715 */         .withinDistance(0.0D, 5.0D)
/* 716 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/* 717 */         .addNextBehavior(
/* 718 */           CECombatBehaviors.Behavior.builder()
/* 719 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 720 */           .withinDistance(0.0D, 6.0D)
/* 721 */           .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 722 */           .addNextBehavior(
/* 723 */             CECombatBehaviors.Behavior.builder()
/* 724 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 725 */             .withinDistance(0.0D, 6.0D)
/* 726 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 727 */             .addNextBehavior(
/* 728 */               CECombatBehaviors.Behavior.builder()
/* 729 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 730 */               .withinDistance(0.0D, 8.0D)
/* 731 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 732 */               .addNextBehavior(
/* 733 */                 CECombatBehaviors.Behavior.builder()
/* 734 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 735 */                 .withinDistance(0.0D, 6.0D)
/* 736 */                 .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 742 */       .addFirstBehavior(
/* 743 */         CECombatBehaviors.Behavior.builder()
/* 744 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 745 */         .withinDistance(0.0D, 5.0D)
/* 746 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 747 */         .addNextBehavior(
/* 748 */           CECombatBehaviors.Behavior.builder()
/* 749 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 750 */           .withinDistance(0.0D, 6.0D)
/* 751 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 752 */           .addNextBehavior(
/* 753 */             CECombatBehaviors.Behavior.builder()
/* 754 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 755 */             .withinDistance(0.0D, 6.0D)
/* 756 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 757 */             .addNextBehavior(
/* 758 */               CECombatBehaviors.Behavior.builder()
/* 759 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 760 */               .withinDistance(0.0D, 10.0D)
/* 761 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 762 */               .addNextBehavior(
/* 763 */                 CECombatBehaviors.Behavior.builder()
/* 764 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 765 */                 .withinDistance(0.0D, 6.0D)
/* 766 */                 .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 772 */       .addFirstBehavior(
/* 773 */         CECombatBehaviors.Behavior.builder()
/* 774 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 775 */         .withinDistance(0.0D, 5.0D)
/* 776 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/* 777 */         .addNextBehavior(
/* 778 */           CECombatBehaviors.Behavior.builder()
/* 779 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 780 */           .withinDistance(0.0D, 6.0D)
/* 781 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 782 */           .addNextBehavior(
/* 783 */             CECombatBehaviors.Behavior.builder()
/* 784 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 785 */             .withinDistance(0.0D, 10.0D)
/* 786 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 787 */             .addNextBehavior(
/* 788 */               CECombatBehaviors.Behavior.builder()
/* 789 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 790 */               .withinDistance(0.0D, 8.0D)
/* 791 */               .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 792 */               .addNextBehavior(
/* 793 */                 CECombatBehaviors.Behavior.builder()
/* 794 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 795 */                 .withinDistance(0.0D, 6.0D)
/* 796 */                 .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 802 */       .addFirstBehavior(
/* 803 */         CECombatBehaviors.Behavior.builder()
/* 804 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 805 */         .withinDistance(0.0D, 5.0D)
/* 806 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 807 */         .addNextBehavior(
/* 808 */           CECombatBehaviors.Behavior.builder()
/* 809 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 810 */           .withinDistance(0.0D, 6.0D)
/* 811 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 812 */           .addNextBehavior(
/* 813 */             CECombatBehaviors.Behavior.builder()
/* 814 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 815 */             .withinDistance(0.0D, 8.0D)
/* 816 */             .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/* 817 */             .addNextBehavior(
/* 818 */               CECombatBehaviors.Behavior.builder()
/* 819 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 820 */               .withinDistance(0.0D, 6.0D)
/* 821 */               .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 822 */               .addNextBehavior(
/* 823 */                 CECombatBehaviors.Behavior.builder()
/* 824 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 825 */                 .withinDistance(0.0D, 10.0D)
/* 826 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 832 */       .addFirstBehavior(
/* 833 */         CECombatBehaviors.Behavior.builder()
/* 834 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 835 */         .withinDistance(0.0D, 5.0D)
/* 836 */         .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/* 837 */         .addNextBehavior(
/* 838 */           CECombatBehaviors.Behavior.builder()
/* 839 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 840 */           .withinDistance(0.0D, 6.0D)
/* 841 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/* 842 */           .addNextBehavior(
/* 843 */             CECombatBehaviors.Behavior.builder()
/* 844 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 845 */             .withinDistance(0.0D, 6.0D)
/* 846 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/* 847 */             .addNextBehavior(
/* 848 */               CECombatBehaviors.Behavior.builder()
/* 849 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 850 */               .withinDistance(0.0D, 8.0D)
/* 851 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 852 */               .addNextBehavior(
/* 853 */                 CECombatBehaviors.Behavior.builder()
/* 854 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 855 */                 .withinDistance(0.0D, 8.0D)
/* 856 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F)))))))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 863 */     .newBehaviorRoot(
/* 864 */       CECombatBehaviors.BehaviorRoot.builder()
/* 865 */       .priority(1.0D)
/* 866 */       .weight(30.0D)
/* 867 */       .maxCooldown(100)
/* 868 */       .addFirstBehavior(
/* 869 */         CECombatBehaviors.Behavior.builder()
/* 870 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 871 */         .withinDistance(0.0D, 5.0D)
/* 872 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F))
/*     */       
/* 874 */       .addFirstBehavior(
/* 875 */         CECombatBehaviors.Behavior.builder()
/* 876 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 877 */         .withinDistance(0.0D, 5.0D)
/* 878 */         .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F))
/*     */       
/* 880 */       .addFirstBehavior(
/* 881 */         CECombatBehaviors.Behavior.builder()
/* 882 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 883 */         .withinDistance(0.0D, 5.0D)
/* 884 */         .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)))
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
/* 897 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_CONVERT, 0.0F)
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
/* 911 */         .animationBehavior(AVAnimations.SNAKE_BLADE, 0.0F)
/* 912 */         .addExBehavior(HerobrineCommon::playSecondFormAnimation)))
/*     */ 
/*     */     
/* 915 */     .newBehaviorRoot(
/* 916 */       CECombatBehaviors.BehaviorRoot.builder()
/* 917 */       .priority(1.0D)
/* 918 */       .weight(15.0D)
/* 919 */       .maxCooldown(300)
/* 920 */       .addFirstBehavior(
/* 921 */         CECombatBehaviors.Behavior.builder()
/* 922 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 923 */         .withinDistance(0.0D, 8.0D)
/* 924 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/* 925 */         .animationBehavior(AVAnimations.SNAKE_BLADE_GUARD, 0.0F)
/* 926 */         .addExBehavior(HerobrineCommon::playSecondFormGuardAnimation)))
/*     */ 
/*     */     
/* 929 */     .newBehaviorRoot(
/* 930 */       CECombatBehaviors.BehaviorRoot.builder()
/* 931 */       .priority(1.0D)
/* 932 */       .weight(15.0D)
/* 933 */       .addFirstBehavior(
/* 934 */         CECombatBehaviors.Behavior.builder()
/* 935 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 936 */         .withinDistance(0.0D, 5.0D)
/* 937 */         .custom(HerobrineCommon::canPerformGuarding)
/* 938 */         .guard(40)))
/*     */ 
/*     */     
/* 941 */     .newBehaviorRoot(
/* 942 */       CECombatBehaviors.BehaviorRoot.builder()
/* 943 */       .priority(1.0D)
/* 944 */       .weight(10.0D)
/* 945 */       .addFirstBehavior(
/* 946 */         CECombatBehaviors.Behavior.builder()
/* 947 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 948 */         .withinDistance(0.0D, 5.0D)
/* 949 */         .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F))
/*     */       
/* 951 */       .addFirstBehavior(
/* 952 */         CECombatBehaviors.Behavior.builder()
/* 953 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 954 */         .withinDistance(0.0D, 5.0D)
/* 955 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F))
/*     */       
/* 957 */       .addFirstBehavior(
/* 958 */         CECombatBehaviors.Behavior.builder()
/* 959 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 960 */         .withinDistance(0.0D, 5.0D)
/* 961 */         .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F))
/*     */       
/* 963 */       .addFirstBehavior(
/* 964 */         CECombatBehaviors.Behavior.builder()
/* 965 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 966 */         .withinDistance(0.0D, 5.0D)
/* 967 */         .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)))
/*     */ 
/*     */     
/* 970 */     .newBehaviorRoot(
/* 971 */       CECombatBehaviors.BehaviorRoot.builder()
/* 972 */       .priority(1.0D)
/* 973 */       .weight(20.0D)
/* 974 */       .maxCooldown(160)
/* 975 */       .addFirstBehavior(
/* 976 */         CECombatBehaviors.Behavior.builder()
/* 977 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 978 */         .custom(HerobrineCommon::canJump)
/* 979 */         .withinDistance(5.0D, 14.0D)
/* 980 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 981 */         .addExBehavior(HerobrineCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineDemoniacVoltageReaver.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */