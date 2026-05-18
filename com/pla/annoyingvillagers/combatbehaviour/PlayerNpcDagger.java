/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.efkick.gameasset.EFKickAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PlayerNpcDagger
/*      */ {
/*   14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> DAGGER = CECombatBehaviors.builder()
/*   15 */     .newBehaviorRoot(
/*   16 */       CECombatBehaviors.BehaviorRoot.builder()
/*   17 */       .priority(4.0D)
/*   18 */       .weight(1000.0D)
/*   19 */       .maxCooldown(0)
/*   20 */       .addFirstBehavior(
/*   21 */         CECombatBehaviors.Behavior.builder()
/*   22 */         .custom(CombatCommon::canExecute)
/*   23 */         .withinDistance(0.0D, 5.0D)
/*   24 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*   25 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*   28 */     .newBehaviorRoot(
/*   29 */       CECombatBehaviors.BehaviorRoot.builder()
/*   30 */       .priority(3.0D)
/*   31 */       .weight(1000.0D)
/*   32 */       .maxCooldown(0)
/*   33 */       .addFirstBehavior(
/*   34 */         CECombatBehaviors.Behavior.builder()
/*   35 */         .custom(CombatCommon::canEscape)
/*   36 */         .withinDistance(0.0D, 8.0D)
/*   37 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   38 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*   40 */       .addFirstBehavior(
/*   41 */         CECombatBehaviors.Behavior.builder()
/*   42 */         .custom(CombatCommon::canEscape)
/*   43 */         .withinDistance(0.0D, 48.0D)
/*   44 */         .animationBehavior(AVAnimations.KNIFE_CHECK, 0.0F)))
/*      */ 
/*      */     
/*   47 */     .newBehaviorRoot(
/*   48 */       CECombatBehaviors.BehaviorRoot.builder()
/*   49 */       .priority(2.0D)
/*   50 */       .weight(70.0D)
/*   51 */       .maxCooldown(0)
/*   52 */       .addFirstBehavior(
/*   53 */         CECombatBehaviors.Behavior.builder()
/*   54 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   55 */         .custom(CombatCommon::canPerformEating)
/*   56 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   57 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*   60 */     .newBehaviorRoot(
/*   61 */       CECombatBehaviors.BehaviorRoot.builder()
/*   62 */       .priority(2.0D)
/*   63 */       .weight(100.0D)
/*   64 */       .maxCooldown(120)
/*   65 */       .addFirstBehavior(
/*   66 */         CECombatBehaviors.Behavior.builder()
/*   67 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   68 */         .custom(CombatCommon::canSwapToBow)
/*   69 */         .withinDistance(7.0D, 14.0D)
/*   70 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   71 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   73 */       .addFirstBehavior(
/*   74 */         CECombatBehaviors.Behavior.builder()
/*   75 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   76 */         .custom(CombatCommon::canSwapToBow)
/*   77 */         .withinDistance(7.0D, 14.0D)
/*   78 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*   79 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*   82 */     .newBehaviorRoot(
/*   83 */       CECombatBehaviors.BehaviorRoot.builder()
/*   84 */       .priority(2.0D)
/*   85 */       .weight(80.0D)
/*   86 */       .maxCooldown(120)
/*   87 */       .addFirstBehavior(
/*   88 */         CECombatBehaviors.Behavior.builder()
/*   89 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   90 */         .custom(CombatCommon::canThrowEnderPearl)
/*   91 */         .withinDistance(7.0D, 48.0D)
/*   92 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*   93 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*   96 */     .newBehaviorRoot(
/*   97 */       CECombatBehaviors.BehaviorRoot.builder()
/*   98 */       .priority(1.0D)
/*   99 */       .weight(40.0D)
/*  100 */       .maxCooldown(20)
/*  101 */       .addFirstBehavior(
/*  102 */         CECombatBehaviors.Behavior.builder()
/*  103 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  104 */         .withinDistance(0.0D, 3.0D)
/*  105 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  106 */         .addNextBehavior(
/*  107 */           CECombatBehaviors.Behavior.builder()
/*  108 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  109 */           .withinDistance(0.0D, 3.0D)
/*  110 */           .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  111 */           .addNextBehavior(
/*  112 */             CECombatBehaviors.Behavior.builder()
/*  113 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  114 */             .withinDistance(0.0D, 3.0D)
/*  115 */             .animationBehavior(Animations.DAGGER_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  119 */       .addFirstBehavior(
/*  120 */         CECombatBehaviors.Behavior.builder()
/*  121 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  122 */         .withinDistance(0.0D, 3.0D)
/*  123 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  124 */         .addNextBehavior(
/*  125 */           CECombatBehaviors.Behavior.builder()
/*  126 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  127 */           .withinDistance(0.0D, 3.0D)
/*  128 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  129 */           .addNextBehavior(
/*  130 */             CECombatBehaviors.Behavior.builder()
/*  131 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  132 */             .withinDistance(0.0D, 4.0D)
/*  133 */             .animationBehavior(Animations.DAGGER_DASH, 0.0F)
/*  134 */             .addNextBehavior(
/*  135 */               CECombatBehaviors.Behavior.builder()
/*  136 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  137 */               .withinDistance(0.0D, 4.0D)
/*  138 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  139 */               .addNextBehavior(
/*  140 */                 CECombatBehaviors.Behavior.builder()
/*  141 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  142 */                 .withinDistance(0.0D, 5.0D)
/*  143 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  150 */       .addFirstBehavior(
/*  151 */         CECombatBehaviors.Behavior.builder()
/*  152 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  153 */         .withinDistance(0.0D, 3.0D)
/*  154 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  155 */         .addNextBehavior(
/*  156 */           CECombatBehaviors.Behavior.builder()
/*  157 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  158 */           .withinDistance(0.0D, 3.0D)
/*  159 */           .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/*  160 */           .addNextBehavior(
/*  161 */             CECombatBehaviors.Behavior.builder()
/*  162 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  163 */             .withinDistance(0.0D, 4.0D)
/*  164 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  165 */             .addNextBehavior(
/*  166 */               CECombatBehaviors.Behavior.builder()
/*  167 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  168 */               .withinDistance(0.0D, 4.0D)
/*  169 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  170 */               .addNextBehavior(
/*  171 */                 CECombatBehaviors.Behavior.builder()
/*  172 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  173 */                 .withinDistance(0.0D, 5.0D)
/*  174 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  175 */                 .addNextBehavior(
/*  176 */                   CECombatBehaviors.Behavior.builder()
/*  177 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  178 */                   .withinDistance(0.0D, 5.0D)
/*  179 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  187 */       .addFirstBehavior(
/*  188 */         CECombatBehaviors.Behavior.builder()
/*  189 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  190 */         .withinDistance(0.0D, 3.0D)
/*  191 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  192 */         .addNextBehavior(
/*  193 */           CECombatBehaviors.Behavior.builder()
/*  194 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  195 */           .withinDistance(0.0D, 3.0D)
/*  196 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  197 */           .addNextBehavior(
/*  198 */             CECombatBehaviors.Behavior.builder()
/*  199 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  200 */             .withinDistance(0.0D, 4.0D)
/*  201 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  202 */             .addNextBehavior(
/*  203 */               CECombatBehaviors.Behavior.builder()
/*  204 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  205 */               .withinDistance(0.0D, 4.0D)
/*  206 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  207 */               .addNextBehavior(
/*  208 */                 CECombatBehaviors.Behavior.builder()
/*  209 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  210 */                 .withinDistance(0.0D, 5.0D)
/*  211 */                 .animationBehavior(Animations.DAGGER_DASH, 0.0F)
/*  212 */                 .addNextBehavior(
/*  213 */                   CECombatBehaviors.Behavior.builder()
/*  214 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  215 */                   .withinDistance(0.0D, 5.0D)
/*  216 */                   .animationBehavior(Animations.DAGGER_AUTO3, 0.0F)
/*  217 */                   .addNextBehavior(
/*  218 */                     CECombatBehaviors.Behavior.builder()
/*  219 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  220 */                     .withinDistance(0.0D, 5.0D)
/*  221 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  230 */       .addFirstBehavior(
/*  231 */         CECombatBehaviors.Behavior.builder()
/*  232 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  233 */         .withinDistance(0.0D, 3.0D)
/*  234 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  235 */         .addNextBehavior(
/*  236 */           CECombatBehaviors.Behavior.builder()
/*  237 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  238 */           .withinDistance(0.0D, 3.0D)
/*  239 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  240 */           .addNextBehavior(
/*  241 */             CECombatBehaviors.Behavior.builder()
/*  242 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  243 */             .withinDistance(0.0D, 4.0D)
/*  244 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  245 */             .addNextBehavior(
/*  246 */               CECombatBehaviors.Behavior.builder()
/*  247 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  248 */               .withinDistance(0.0D, 4.0D)
/*  249 */               .animationBehavior(Animations.EVISCERATE_FIRST, 0.0F)
/*  250 */               .addNextBehavior(
/*  251 */                 CECombatBehaviors.Behavior.builder()
/*  252 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  253 */                 .withinDistance(0.0D, 5.0D)
/*  254 */                 .animationBehavior(Animations.EVISCERATE_SECOND, 0.0F)
/*  255 */                 .addNextBehavior(
/*  256 */                   CECombatBehaviors.Behavior.builder()
/*  257 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  258 */                   .withinDistance(0.0D, 5.0D)
/*  259 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  260 */                   .addNextBehavior(
/*  261 */                     CECombatBehaviors.Behavior.builder()
/*  262 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  263 */                     .withinDistance(0.0D, 5.0D)
/*  264 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  273 */       .addFirstBehavior(
/*  274 */         CECombatBehaviors.Behavior.builder()
/*  275 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  276 */         .withinDistance(0.0D, 3.0D)
/*  277 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  278 */         .addNextBehavior(
/*  279 */           CECombatBehaviors.Behavior.builder()
/*  280 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  281 */           .withinDistance(0.0D, 3.0D)
/*  282 */           .animationBehavior(Animations.DAGGER_DASH, 0.0F)
/*  283 */           .addNextBehavior(
/*  284 */             CECombatBehaviors.Behavior.builder()
/*  285 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  286 */             .withinDistance(0.0D, 4.0D)
/*  287 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  288 */             .addNextBehavior(
/*  289 */               CECombatBehaviors.Behavior.builder()
/*  290 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  291 */               .withinDistance(0.0D, 4.0D)
/*  292 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  293 */               .addNextBehavior(
/*  294 */                 CECombatBehaviors.Behavior.builder()
/*  295 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  296 */                 .withinDistance(0.0D, 5.0D)
/*  297 */                 .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  298 */                 .addNextBehavior(
/*  299 */                   CECombatBehaviors.Behavior.builder()
/*  300 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  301 */                   .withinDistance(0.0D, 5.0D)
/*  302 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  310 */       .addFirstBehavior(
/*  311 */         CECombatBehaviors.Behavior.builder()
/*  312 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  313 */         .withinDistance(0.0D, 3.0D)
/*  314 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  315 */         .addNextBehavior(
/*  316 */           CECombatBehaviors.Behavior.builder()
/*  317 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  318 */           .withinDistance(0.0D, 3.0D)
/*  319 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  320 */           .addNextBehavior(
/*  321 */             CECombatBehaviors.Behavior.builder()
/*  322 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  323 */             .withinDistance(0.0D, 4.0D)
/*  324 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  325 */             .addNextBehavior(
/*  326 */               CECombatBehaviors.Behavior.builder()
/*  327 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  328 */               .withinDistance(0.0D, 4.0D)
/*  329 */               .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/*  330 */               .addNextBehavior(
/*  331 */                 CECombatBehaviors.Behavior.builder()
/*  332 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  333 */                 .withinDistance(0.0D, 5.0D)
/*  334 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  335 */                 .addNextBehavior(
/*  336 */                   CECombatBehaviors.Behavior.builder()
/*  337 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  338 */                   .withinDistance(0.0D, 5.0D)
/*  339 */                   .animationBehavior(Animations.DAGGER_AUTO3, 0.0F)
/*  340 */                   .addNextBehavior(
/*  341 */                     CECombatBehaviors.Behavior.builder()
/*  342 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  343 */                     .withinDistance(0.0D, 5.0D)
/*  344 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  353 */       .addFirstBehavior(
/*  354 */         CECombatBehaviors.Behavior.builder()
/*  355 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  356 */         .withinDistance(0.0D, 3.0D)
/*  357 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  358 */         .addNextBehavior(
/*  359 */           CECombatBehaviors.Behavior.builder()
/*  360 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  361 */           .withinDistance(0.0D, 3.0D)
/*  362 */           .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  363 */           .addNextBehavior(
/*  364 */             CECombatBehaviors.Behavior.builder()
/*  365 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  366 */             .withinDistance(0.0D, 4.0D)
/*  367 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  368 */             .addNextBehavior(
/*  369 */               CECombatBehaviors.Behavior.builder()
/*  370 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  371 */               .withinDistance(0.0D, 4.0D)
/*  372 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  373 */               .addNextBehavior(
/*  374 */                 CECombatBehaviors.Behavior.builder()
/*  375 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  376 */                 .withinDistance(0.0D, 5.0D)
/*  377 */                 .animationBehavior(Animations.DAGGER_DASH, 0.0F)
/*  378 */                 .addNextBehavior(
/*  379 */                   CECombatBehaviors.Behavior.builder()
/*  380 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  381 */                   .withinDistance(0.0D, 5.0D)
/*  382 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  390 */       .addFirstBehavior(
/*  391 */         CECombatBehaviors.Behavior.builder()
/*  392 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  393 */         .withinDistance(0.0D, 3.0D)
/*  394 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  395 */         .addNextBehavior(
/*  396 */           CECombatBehaviors.Behavior.builder()
/*  397 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  398 */           .withinDistance(0.0D, 3.0D)
/*  399 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  400 */           .addNextBehavior(
/*  401 */             CECombatBehaviors.Behavior.builder()
/*  402 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  403 */             .withinDistance(0.0D, 4.0D)
/*  404 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  405 */             .addNextBehavior(
/*  406 */               CECombatBehaviors.Behavior.builder()
/*  407 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  408 */               .withinDistance(0.0D, 4.0D)
/*  409 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  410 */               .addNextBehavior(
/*  411 */                 CECombatBehaviors.Behavior.builder()
/*  412 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  413 */                 .withinDistance(0.0D, 5.0D)
/*  414 */                 .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/*  415 */                 .addNextBehavior(
/*  416 */                   CECombatBehaviors.Behavior.builder()
/*  417 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  418 */                   .withinDistance(0.0D, 5.0D)
/*  419 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  427 */       .addFirstBehavior(
/*  428 */         CECombatBehaviors.Behavior.builder()
/*  429 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  430 */         .withinDistance(0.0D, 3.0D)
/*  431 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  432 */         .addNextBehavior(
/*  433 */           CECombatBehaviors.Behavior.builder()
/*  434 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  435 */           .withinDistance(0.0D, 3.0D)
/*  436 */           .animationBehavior(Animations.EVISCERATE_FIRST, 0.0F)
/*  437 */           .addNextBehavior(
/*  438 */             CECombatBehaviors.Behavior.builder()
/*  439 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  440 */             .withinDistance(0.0D, 4.0D)
/*  441 */             .animationBehavior(Animations.EVISCERATE_SECOND, 0.0F)
/*  442 */             .addNextBehavior(
/*  443 */               CECombatBehaviors.Behavior.builder()
/*  444 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  445 */               .withinDistance(0.0D, 4.0D)
/*  446 */               .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  447 */               .addNextBehavior(
/*  448 */                 CECombatBehaviors.Behavior.builder()
/*  449 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  450 */                 .withinDistance(0.0D, 5.0D)
/*  451 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  452 */                 .addNextBehavior(
/*  453 */                   CECombatBehaviors.Behavior.builder()
/*  454 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  455 */                   .withinDistance(0.0D, 5.0D)
/*  456 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  457 */                   .addNextBehavior(
/*  458 */                     CECombatBehaviors.Behavior.builder()
/*  459 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  460 */                     .withinDistance(0.0D, 5.0D)
/*  461 */                     .animationBehavior(Animations.DAGGER_AUTO3, 0.0F)
/*  462 */                     .addNextBehavior(
/*  463 */                       CECombatBehaviors.Behavior.builder()
/*  464 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  465 */                       .withinDistance(0.0D, 5.0D)
/*  466 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  476 */       .addFirstBehavior(
/*  477 */         CECombatBehaviors.Behavior.builder()
/*  478 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  479 */         .withinDistance(0.0D, 3.0D)
/*  480 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  481 */         .addNextBehavior(
/*  482 */           CECombatBehaviors.Behavior.builder()
/*  483 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  484 */           .withinDistance(0.0D, 3.0D)
/*  485 */           .animationBehavior(Animations.DAGGER_DASH, 0.0F)
/*  486 */           .addNextBehavior(
/*  487 */             CECombatBehaviors.Behavior.builder()
/*  488 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  489 */             .withinDistance(0.0D, 4.0D)
/*  490 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  491 */             .addNextBehavior(
/*  492 */               CECombatBehaviors.Behavior.builder()
/*  493 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  494 */               .withinDistance(0.0D, 4.0D)
/*  495 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  496 */               .addNextBehavior(
/*  497 */                 CECombatBehaviors.Behavior.builder()
/*  498 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  499 */                 .withinDistance(0.0D, 5.0D)
/*  500 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  501 */                 .addNextBehavior(
/*  502 */                   CECombatBehaviors.Behavior.builder()
/*  503 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  504 */                   .withinDistance(0.0D, 5.0D)
/*  505 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  513 */       .addFirstBehavior(
/*  514 */         CECombatBehaviors.Behavior.builder()
/*  515 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  516 */         .withinDistance(0.0D, 3.0D)
/*  517 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  518 */         .addNextBehavior(
/*  519 */           CECombatBehaviors.Behavior.builder()
/*  520 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  521 */           .withinDistance(0.0D, 3.0D)
/*  522 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  523 */           .addNextBehavior(
/*  524 */             CECombatBehaviors.Behavior.builder()
/*  525 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  526 */             .withinDistance(0.0D, 4.0D)
/*  527 */             .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  528 */             .addNextBehavior(
/*  529 */               CECombatBehaviors.Behavior.builder()
/*  530 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  531 */               .withinDistance(0.0D, 4.0D)
/*  532 */               .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  533 */               .addNextBehavior(
/*  534 */                 CECombatBehaviors.Behavior.builder()
/*  535 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  536 */                 .withinDistance(0.0D, 5.0D)
/*  537 */                 .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/*  538 */                 .addNextBehavior(
/*  539 */                   CECombatBehaviors.Behavior.builder()
/*  540 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  541 */                   .withinDistance(0.0D, 5.0D)
/*  542 */                   .animationBehavior(Animations.DAGGER_AUTO3, 0.0F)
/*  543 */                   .addNextBehavior(
/*  544 */                     CECombatBehaviors.Behavior.builder()
/*  545 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  546 */                     .withinDistance(0.0D, 5.0D)
/*  547 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  556 */       .addFirstBehavior(
/*  557 */         CECombatBehaviors.Behavior.builder()
/*  558 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  559 */         .withinDistance(0.0D, 3.0D)
/*  560 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  561 */         .addNextBehavior(
/*  562 */           CECombatBehaviors.Behavior.builder()
/*  563 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  564 */           .withinDistance(0.0D, 3.0D)
/*  565 */           .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  566 */           .addNextBehavior(
/*  567 */             CECombatBehaviors.Behavior.builder()
/*  568 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  569 */             .withinDistance(0.0D, 4.0D)
/*  570 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  571 */             .addNextBehavior(
/*  572 */               CECombatBehaviors.Behavior.builder()
/*  573 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  574 */               .withinDistance(0.0D, 4.0D)
/*  575 */               .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  576 */               .addNextBehavior(
/*  577 */                 CECombatBehaviors.Behavior.builder()
/*  578 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  579 */                 .withinDistance(0.0D, 5.0D)
/*  580 */                 .animationBehavior(Animations.EVISCERATE_FIRST, 0.0F)
/*  581 */                 .addNextBehavior(
/*  582 */                   CECombatBehaviors.Behavior.builder()
/*  583 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  584 */                   .withinDistance(0.0D, 5.0D)
/*  585 */                   .animationBehavior(Animations.EVISCERATE_SECOND, 0.0F)
/*  586 */                   .addNextBehavior(
/*  587 */                     CECombatBehaviors.Behavior.builder()
/*  588 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  589 */                     .withinDistance(0.0D, 5.0D)
/*  590 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  599 */       .addFirstBehavior(
/*  600 */         CECombatBehaviors.Behavior.builder()
/*  601 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  602 */         .withinDistance(0.0D, 3.0D)
/*  603 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  604 */         .addNextBehavior(
/*  605 */           CECombatBehaviors.Behavior.builder()
/*  606 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  607 */           .withinDistance(0.0D, 3.0D)
/*  608 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  609 */           .addNextBehavior(
/*  610 */             CECombatBehaviors.Behavior.builder()
/*  611 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  612 */             .withinDistance(0.0D, 4.0D)
/*  613 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  614 */             .addNextBehavior(
/*  615 */               CECombatBehaviors.Behavior.builder()
/*  616 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  617 */               .withinDistance(0.0D, 4.0D)
/*  618 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  619 */               .addNextBehavior(
/*  620 */                 CECombatBehaviors.Behavior.builder()
/*  621 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  622 */                 .withinDistance(0.0D, 5.0D)
/*  623 */                 .animationBehavior(Animations.DAGGER_AUTO3, 0.0F)
/*  624 */                 .addNextBehavior(
/*  625 */                   CECombatBehaviors.Behavior.builder()
/*  626 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  627 */                   .withinDistance(0.0D, 5.0D)
/*  628 */                   .animationBehavior(Animations.DAGGER_DASH, 0.0F)
/*  629 */                   .addNextBehavior(
/*  630 */                     CECombatBehaviors.Behavior.builder()
/*  631 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  632 */                     .withinDistance(0.0D, 5.0D)
/*  633 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  642 */       .addFirstBehavior(
/*  643 */         CECombatBehaviors.Behavior.builder()
/*  644 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  645 */         .withinDistance(0.0D, 3.0D)
/*  646 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  647 */         .addNextBehavior(
/*  648 */           CECombatBehaviors.Behavior.builder()
/*  649 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  650 */           .withinDistance(0.0D, 3.0D)
/*  651 */           .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/*  652 */           .addNextBehavior(
/*  653 */             CECombatBehaviors.Behavior.builder()
/*  654 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  655 */             .withinDistance(0.0D, 4.0D)
/*  656 */             .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  657 */             .addNextBehavior(
/*  658 */               CECombatBehaviors.Behavior.builder()
/*  659 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  660 */               .withinDistance(0.0D, 4.0D)
/*  661 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  662 */               .addNextBehavior(
/*  663 */                 CECombatBehaviors.Behavior.builder()
/*  664 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  665 */                 .withinDistance(0.0D, 5.0D)
/*  666 */                 .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  667 */                 .addNextBehavior(
/*  668 */                   CECombatBehaviors.Behavior.builder()
/*  669 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  670 */                   .withinDistance(0.0D, 5.0D)
/*  671 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  679 */       .addFirstBehavior(
/*  680 */         CECombatBehaviors.Behavior.builder()
/*  681 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  682 */         .withinDistance(0.0D, 3.0D)
/*  683 */         .animationBehavior(Animations.DAGGER_AUTO1, 0.0F)
/*  684 */         .addNextBehavior(
/*  685 */           CECombatBehaviors.Behavior.builder()
/*  686 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  687 */           .withinDistance(0.0D, 3.0D)
/*  688 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  689 */           .addNextBehavior(
/*  690 */             CECombatBehaviors.Behavior.builder()
/*  691 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  692 */             .withinDistance(0.0D, 4.0D)
/*  693 */             .animationBehavior(Animations.DAGGER_AUTO2, 0.0F)
/*  694 */             .addNextBehavior(
/*  695 */               CECombatBehaviors.Behavior.builder()
/*  696 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  697 */               .withinDistance(0.0D, 4.0D)
/*  698 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  699 */               .addNextBehavior(
/*  700 */                 CECombatBehaviors.Behavior.builder()
/*  701 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  702 */                 .withinDistance(0.0D, 5.0D)
/*  703 */                 .animationBehavior(Animations.DAGGER_AUTO3, 0.0F)
/*  704 */                 .addNextBehavior(
/*  705 */                   CECombatBehaviors.Behavior.builder()
/*  706 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  707 */                   .withinDistance(0.0D, 5.0D)
/*  708 */                   .animationBehavior(Animations.EVISCERATE_FIRST, 0.0F)
/*  709 */                   .addNextBehavior(
/*  710 */                     CECombatBehaviors.Behavior.builder()
/*  711 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  712 */                     .withinDistance(0.0D, 5.0D)
/*  713 */                     .animationBehavior(Animations.EVISCERATE_SECOND, 0.0F)
/*  714 */                     .addNextBehavior(
/*  715 */                       CECombatBehaviors.Behavior.builder()
/*  716 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  717 */                       .withinDistance(0.0D, 5.0D)
/*  718 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  729 */     .newBehaviorRoot(
/*  730 */       CECombatBehaviors.BehaviorRoot.builder()
/*  731 */       .priority(1.0D)
/*  732 */       .weight(20.0D)
/*  733 */       .maxCooldown(100)
/*  734 */       .addFirstBehavior(
/*  735 */         CECombatBehaviors.Behavior.builder()
/*  736 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  737 */         .withinDistance(0.0D, 3.0D)
/*  738 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  739 */         .addNextBehavior(
/*  740 */           CECombatBehaviors.Behavior.builder()
/*  741 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  742 */           .withinDistance(0.0D, 3.0D)
/*  743 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  744 */           .addNextBehavior(
/*  745 */             CECombatBehaviors.Behavior.builder()
/*  746 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  747 */             .withinDistance(0.0D, 3.0D)
/*  748 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  753 */     .newBehaviorRoot(
/*  754 */       CECombatBehaviors.BehaviorRoot.builder()
/*  755 */       .priority(1.0D)
/*  756 */       .weight(10.0D)
/*  757 */       .maxCooldown(100)
/*  758 */       .addFirstBehavior(
/*  759 */         CECombatBehaviors.Behavior.builder()
/*  760 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  761 */         .withinDistance(0.0D, 3.0D)
/*  762 */         .animationBehavior(Animations.DAGGER_DASH, 0.0F)))
/*      */ 
/*      */     
/*  765 */     .newBehaviorRoot(
/*  766 */       CECombatBehaviors.BehaviorRoot.builder()
/*  767 */       .priority(1.0D)
/*  768 */       .weight(10.0D)
/*  769 */       .maxCooldown(100)
/*  770 */       .addFirstBehavior(
/*  771 */         CECombatBehaviors.Behavior.builder()
/*  772 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  773 */         .withinDistance(0.0D, 3.0D)
/*  774 */         .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)))
/*      */ 
/*      */     
/*  777 */     .newBehaviorRoot(
/*  778 */       CECombatBehaviors.BehaviorRoot.builder()
/*  779 */       .priority(1.0D)
/*  780 */       .weight(10.0D)
/*  781 */       .maxCooldown(100)
/*  782 */       .addFirstBehavior(
/*  783 */         CECombatBehaviors.Behavior.builder()
/*  784 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  785 */         .withinDistance(0.0D, 3.0D)
/*  786 */         .animationBehavior(Animations.EVISCERATE_FIRST, 0.0F)
/*  787 */         .addNextBehavior(
/*  788 */           CECombatBehaviors.Behavior.builder()
/*  789 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  790 */           .withinDistance(0.0D, 3.0D)
/*  791 */           .animationBehavior(Animations.EVISCERATE_SECOND, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/*  795 */     .newBehaviorRoot(
/*  796 */       CECombatBehaviors.BehaviorRoot.builder()
/*  797 */       .priority(1.0D)
/*  798 */       .weight(10.0D)
/*  799 */       .maxCooldown(40)
/*  800 */       .addFirstBehavior(
/*  801 */         CECombatBehaviors.Behavior.builder()
/*  802 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  803 */         .withinDistance(0.0D, 3.0D)
/*  804 */         .custom(CombatCommon::canThrowEnderPearl)
/*  805 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  806 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  809 */     .newBehaviorRoot(
/*  810 */       CECombatBehaviors.BehaviorRoot.builder()
/*  811 */       .priority(1.0D)
/*  812 */       .weight(2.0D)
/*  813 */       .maxCooldown(100)
/*  814 */       .addFirstBehavior(
/*  815 */         CECombatBehaviors.Behavior.builder()
/*  816 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  817 */         .withinDistance(0.0D, 3.0D)
/*  818 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  820 */       .addFirstBehavior(
/*  821 */         CECombatBehaviors.Behavior.builder()
/*  822 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  823 */         .withinDistance(0.0D, 3.0D)
/*  824 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  826 */       .addFirstBehavior(
/*  827 */         CECombatBehaviors.Behavior.builder()
/*  828 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  829 */         .withinDistance(0.0D, 3.0D)
/*  830 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  832 */       .addFirstBehavior(
/*  833 */         CECombatBehaviors.Behavior.builder()
/*  834 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  835 */         .withinDistance(0.0D, 3.0D)
/*  836 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  838 */       .addFirstBehavior(
/*  839 */         CECombatBehaviors.Behavior.builder()
/*  840 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  841 */         .withinDistance(0.0D, 3.0D)
/*  842 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  844 */       .addFirstBehavior(
/*  845 */         CECombatBehaviors.Behavior.builder()
/*  846 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  847 */         .withinDistance(0.0D, 3.0D)
/*  848 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  850 */       .addFirstBehavior(
/*  851 */         CECombatBehaviors.Behavior.builder()
/*  852 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  853 */         .withinDistance(0.0D, 3.0D)
/*  854 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  857 */     .newBehaviorRoot(
/*  858 */       CECombatBehaviors.BehaviorRoot.builder()
/*  859 */       .priority(1.0D)
/*  860 */       .weight(10.0D)
/*  861 */       .addFirstBehavior(
/*  862 */         CECombatBehaviors.Behavior.builder()
/*  863 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  864 */         .withinDistance(0.0D, 3.0D)
/*  865 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/*  867 */       .addFirstBehavior(
/*  868 */         CECombatBehaviors.Behavior.builder()
/*  869 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  870 */         .withinDistance(0.0D, 3.0D)
/*  871 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/*  874 */     .newBehaviorRoot(
/*  875 */       CECombatBehaviors.BehaviorRoot.builder()
/*  876 */       .priority(1.0D)
/*  877 */       .weight(40.0D)
/*  878 */       .maxCooldown(160)
/*  879 */       .addFirstBehavior(
/*  880 */         CECombatBehaviors.Behavior.builder()
/*  881 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  882 */         .custom(CombatCommon::canJump)
/*  883 */         .withinDistance(5.0D, 14.0D)
/*  884 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/*  885 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/*  889 */   public static final CECombatBehaviors.Builder<MobPatch<?>> DUAL_DAGGER = CECombatBehaviors.builder()
/*  890 */     .newBehaviorRoot(
/*  891 */       CECombatBehaviors.BehaviorRoot.builder()
/*  892 */       .priority(4.0D)
/*  893 */       .weight(1000.0D)
/*  894 */       .maxCooldown(0)
/*  895 */       .addFirstBehavior(
/*  896 */         CECombatBehaviors.Behavior.builder()
/*  897 */         .custom(CombatCommon::canExecute)
/*  898 */         .withinDistance(0.0D, 5.0D)
/*  899 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  900 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  903 */     .newBehaviorRoot(
/*  904 */       CECombatBehaviors.BehaviorRoot.builder()
/*  905 */       .priority(3.0D)
/*  906 */       .weight(1000.0D)
/*  907 */       .maxCooldown(0)
/*  908 */       .addFirstBehavior(
/*  909 */         CECombatBehaviors.Behavior.builder()
/*  910 */         .custom(CombatCommon::canEscape)
/*  911 */         .withinDistance(0.0D, 8.0D)
/*  912 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  913 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  915 */       .addFirstBehavior(
/*  916 */         CECombatBehaviors.Behavior.builder()
/*  917 */         .custom(CombatCommon::canEscape)
/*  918 */         .withinDistance(0.0D, 48.0D)
/*  919 */         .animationBehavior(AVAnimations.KNIFE_CHECK, 0.0F)))
/*      */ 
/*      */     
/*  922 */     .newBehaviorRoot(
/*  923 */       CECombatBehaviors.BehaviorRoot.builder()
/*  924 */       .priority(2.0D)
/*  925 */       .weight(70.0D)
/*  926 */       .maxCooldown(0)
/*  927 */       .addFirstBehavior(
/*  928 */         CECombatBehaviors.Behavior.builder()
/*  929 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  930 */         .custom(CombatCommon::canPerformEating)
/*  931 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  932 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  935 */     .newBehaviorRoot(
/*  936 */       CECombatBehaviors.BehaviorRoot.builder()
/*  937 */       .priority(2.0D)
/*  938 */       .weight(100.0D)
/*  939 */       .maxCooldown(120)
/*  940 */       .addFirstBehavior(
/*  941 */         CECombatBehaviors.Behavior.builder()
/*  942 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  943 */         .custom(CombatCommon::canSwapToBow)
/*  944 */         .withinDistance(7.0D, 14.0D)
/*  945 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  946 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  948 */       .addFirstBehavior(
/*  949 */         CECombatBehaviors.Behavior.builder()
/*  950 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  951 */         .custom(CombatCommon::canSwapToBow)
/*  952 */         .withinDistance(7.0D, 14.0D)
/*  953 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  954 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  957 */     .newBehaviorRoot(
/*  958 */       CECombatBehaviors.BehaviorRoot.builder()
/*  959 */       .priority(2.0D)
/*  960 */       .weight(80.0D)
/*  961 */       .maxCooldown(120)
/*  962 */       .addFirstBehavior(
/*  963 */         CECombatBehaviors.Behavior.builder()
/*  964 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  965 */         .custom(CombatCommon::canThrowEnderPearl)
/*  966 */         .withinDistance(7.0D, 48.0D)
/*  967 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  968 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  971 */     .newBehaviorRoot(
/*  972 */       CECombatBehaviors.BehaviorRoot.builder()
/*  973 */       .priority(1.0D)
/*  974 */       .weight(40.0D)
/*  975 */       .maxCooldown(20)
/*  976 */       .addFirstBehavior(
/*  977 */         CECombatBehaviors.Behavior.builder()
/*  978 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  979 */         .withinDistance(0.0D, 3.0D)
/*  980 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/*  981 */         .addNextBehavior(
/*  982 */           CECombatBehaviors.Behavior.builder()
/*  983 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  984 */           .withinDistance(0.0D, 3.0D)
/*  985 */           .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/*  986 */           .addNextBehavior(
/*  987 */             CECombatBehaviors.Behavior.builder()
/*  988 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  989 */             .withinDistance(0.0D, 3.0D)
/*  990 */             .animationBehavior(Animations.DAGGER_DUAL_AUTO3, 0.0F)
/*  991 */             .addNextBehavior(
/*  992 */               CECombatBehaviors.Behavior.builder()
/*  993 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  994 */               .withinDistance(0.0D, 3.0D)
/*  995 */               .animationBehavior(AVAnimations.DAGGER_DUAL_AUTO4, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1000 */       .addFirstBehavior(
/* 1001 */         CECombatBehaviors.Behavior.builder()
/* 1002 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1003 */         .withinDistance(0.0D, 3.0D)
/* 1004 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1005 */         .addNextBehavior(
/* 1006 */           CECombatBehaviors.Behavior.builder()
/* 1007 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1008 */           .withinDistance(0.0D, 3.0D)
/* 1009 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1010 */           .addNextBehavior(
/* 1011 */             CECombatBehaviors.Behavior.builder()
/* 1012 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1013 */             .withinDistance(0.0D, 4.0D)
/* 1014 */             .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1015 */             .addNextBehavior(
/* 1016 */               CECombatBehaviors.Behavior.builder()
/* 1017 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1018 */               .withinDistance(0.0D, 4.0D)
/* 1019 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1020 */               .addNextBehavior(
/* 1021 */                 CECombatBehaviors.Behavior.builder()
/* 1022 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1023 */                 .withinDistance(0.0D, 5.0D)
/* 1024 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1031 */       .addFirstBehavior(
/* 1032 */         CECombatBehaviors.Behavior.builder()
/* 1033 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1034 */         .withinDistance(0.0D, 3.0D)
/* 1035 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1036 */         .addNextBehavior(
/* 1037 */           CECombatBehaviors.Behavior.builder()
/* 1038 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1039 */           .withinDistance(0.0D, 3.0D)
/* 1040 */           .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/* 1041 */           .addNextBehavior(
/* 1042 */             CECombatBehaviors.Behavior.builder()
/* 1043 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1044 */             .withinDistance(0.0D, 4.0D)
/* 1045 */             .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1046 */             .addNextBehavior(
/* 1047 */               CECombatBehaviors.Behavior.builder()
/* 1048 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1049 */               .withinDistance(0.0D, 4.0D)
/* 1050 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1051 */               .addNextBehavior(
/* 1052 */                 CECombatBehaviors.Behavior.builder()
/* 1053 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1054 */                 .withinDistance(0.0D, 5.0D)
/* 1055 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1056 */                 .addNextBehavior(
/* 1057 */                   CECombatBehaviors.Behavior.builder()
/* 1058 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1059 */                   .withinDistance(0.0D, 5.0D)
/* 1060 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1068 */       .addFirstBehavior(
/* 1069 */         CECombatBehaviors.Behavior.builder()
/* 1070 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1071 */         .withinDistance(0.0D, 3.0D)
/* 1072 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1073 */         .addNextBehavior(
/* 1074 */           CECombatBehaviors.Behavior.builder()
/* 1075 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1076 */           .withinDistance(0.0D, 3.0D)
/* 1077 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1078 */           .addNextBehavior(
/* 1079 */             CECombatBehaviors.Behavior.builder()
/* 1080 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1081 */             .withinDistance(0.0D, 4.0D)
/* 1082 */             .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1083 */             .addNextBehavior(
/* 1084 */               CECombatBehaviors.Behavior.builder()
/* 1085 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1086 */               .withinDistance(0.0D, 4.0D)
/* 1087 */               .animationBehavior(Animations.BLADE_RUSH_COMBO1, 0.0F)
/* 1088 */               .addNextBehavior(
/* 1089 */                 CECombatBehaviors.Behavior.builder()
/* 1090 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1091 */                 .withinDistance(0.0D, 5.0D)
/* 1092 */                 .animationBehavior(Animations.BLADE_RUSH_COMBO2, 0.0F)
/* 1093 */                 .addNextBehavior(
/* 1094 */                   CECombatBehaviors.Behavior.builder()
/* 1095 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1096 */                   .withinDistance(0.0D, 5.0D)
/* 1097 */                   .animationBehavior(Animations.BLADE_RUSH_COMBO3, 0.0F)
/* 1098 */                   .addNextBehavior(
/* 1099 */                     CECombatBehaviors.Behavior.builder()
/* 1100 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1101 */                     .withinDistance(0.0D, 5.0D)
/* 1102 */                     .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1103 */                     .addNextBehavior(
/* 1104 */                       CECombatBehaviors.Behavior.builder()
/* 1105 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1106 */                       .withinDistance(0.0D, 5.0D)
/* 1107 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1117 */       .addFirstBehavior(
/* 1118 */         CECombatBehaviors.Behavior.builder()
/* 1119 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1120 */         .withinDistance(0.0D, 3.0D)
/* 1121 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1122 */         .addNextBehavior(
/* 1123 */           CECombatBehaviors.Behavior.builder()
/* 1124 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1125 */           .withinDistance(0.0D, 3.0D)
/* 1126 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1127 */           .addNextBehavior(
/* 1128 */             CECombatBehaviors.Behavior.builder()
/* 1129 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1130 */             .withinDistance(0.0D, 4.0D)
/* 1131 */             .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/* 1132 */             .addNextBehavior(
/* 1133 */               CECombatBehaviors.Behavior.builder()
/* 1134 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1135 */               .withinDistance(0.0D, 4.0D)
/* 1136 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1137 */               .addNextBehavior(
/* 1138 */                 CECombatBehaviors.Behavior.builder()
/* 1139 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1140 */                 .withinDistance(0.0D, 5.0D)
/* 1141 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1148 */       .addFirstBehavior(
/* 1149 */         CECombatBehaviors.Behavior.builder()
/* 1150 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1151 */         .withinDistance(0.0D, 3.0D)
/* 1152 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1153 */         .addNextBehavior(
/* 1154 */           CECombatBehaviors.Behavior.builder()
/* 1155 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1156 */           .withinDistance(0.0D, 3.0D)
/* 1157 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1158 */           .addNextBehavior(
/* 1159 */             CECombatBehaviors.Behavior.builder()
/* 1160 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1161 */             .withinDistance(0.0D, 4.0D)
/* 1162 */             .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1163 */             .addNextBehavior(
/* 1164 */               CECombatBehaviors.Behavior.builder()
/* 1165 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1166 */               .withinDistance(0.0D, 4.0D)
/* 1167 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1168 */               .addNextBehavior(
/* 1169 */                 CECombatBehaviors.Behavior.builder()
/* 1170 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1171 */                 .withinDistance(0.0D, 5.0D)
/* 1172 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1173 */                 .addNextBehavior(
/* 1174 */                   CECombatBehaviors.Behavior.builder()
/* 1175 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1176 */                   .withinDistance(0.0D, 5.0D)
/* 1177 */                   .animationBehavior(Animations.DAGGER_DUAL_AUTO3, 0.0F)
/* 1178 */                   .addNextBehavior(
/* 1179 */                     CECombatBehaviors.Behavior.builder()
/* 1180 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1181 */                     .withinDistance(0.0D, 5.0D)
/* 1182 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1191 */       .addFirstBehavior(
/* 1192 */         CECombatBehaviors.Behavior.builder()
/* 1193 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1194 */         .withinDistance(0.0D, 3.0D)
/* 1195 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1196 */         .addNextBehavior(
/* 1197 */           CECombatBehaviors.Behavior.builder()
/* 1198 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1199 */           .withinDistance(0.0D, 3.0D)
/* 1200 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1201 */           .addNextBehavior(
/* 1202 */             CECombatBehaviors.Behavior.builder()
/* 1203 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1204 */             .withinDistance(0.0D, 4.0D)
/* 1205 */             .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/* 1206 */             .addNextBehavior(
/* 1207 */               CECombatBehaviors.Behavior.builder()
/* 1208 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1209 */               .withinDistance(0.0D, 4.0D)
/* 1210 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1211 */               .addNextBehavior(
/* 1212 */                 CECombatBehaviors.Behavior.builder()
/* 1213 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1214 */                 .withinDistance(0.0D, 5.0D)
/* 1215 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1222 */       .addFirstBehavior(
/* 1223 */         CECombatBehaviors.Behavior.builder()
/* 1224 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1225 */         .withinDistance(0.0D, 3.0D)
/* 1226 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1227 */         .addNextBehavior(
/* 1228 */           CECombatBehaviors.Behavior.builder()
/* 1229 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1230 */           .withinDistance(0.0D, 3.0D)
/* 1231 */           .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1232 */           .addNextBehavior(
/* 1233 */             CECombatBehaviors.Behavior.builder()
/* 1234 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1235 */             .withinDistance(0.0D, 4.0D)
/* 1236 */             .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1237 */             .addNextBehavior(
/* 1238 */               CECombatBehaviors.Behavior.builder()
/* 1239 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1240 */               .withinDistance(0.0D, 4.0D)
/* 1241 */               .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1242 */               .addNextBehavior(
/* 1243 */                 CECombatBehaviors.Behavior.builder()
/* 1244 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1245 */                 .withinDistance(0.0D, 5.0D)
/* 1246 */                 .animationBehavior(Animations.BLADE_RUSH_COMBO1, 0.0F)
/* 1247 */                 .addNextBehavior(
/* 1248 */                   CECombatBehaviors.Behavior.builder()
/* 1249 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1250 */                   .withinDistance(0.0D, 5.0D)
/* 1251 */                   .animationBehavior(Animations.BLADE_RUSH_COMBO2, 0.0F)
/* 1252 */                   .addNextBehavior(
/* 1253 */                     CECombatBehaviors.Behavior.builder()
/* 1254 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1255 */                     .withinDistance(0.0D, 5.0D)
/* 1256 */                     .animationBehavior(Animations.BLADE_RUSH_COMBO3, 0.0F)
/* 1257 */                     .addNextBehavior(
/* 1258 */                       CECombatBehaviors.Behavior.builder()
/* 1259 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1260 */                       .withinDistance(0.0D, 5.0D)
/* 1261 */                       .animationBehavior(Animations.DAGGER_DUAL_AUTO3, 0.0F)
/* 1262 */                       .addNextBehavior(
/* 1263 */                         CECombatBehaviors.Behavior.builder()
/* 1264 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1265 */                         .withinDistance(0.0D, 5.0D)
/* 1266 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1277 */       .addFirstBehavior(
/* 1278 */         CECombatBehaviors.Behavior.builder()
/* 1279 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1280 */         .withinDistance(0.0D, 3.0D)
/* 1281 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1282 */         .addNextBehavior(
/* 1283 */           CECombatBehaviors.Behavior.builder()
/* 1284 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1285 */           .withinDistance(0.0D, 3.0D)
/* 1286 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1287 */           .addNextBehavior(
/* 1288 */             CECombatBehaviors.Behavior.builder()
/* 1289 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1290 */             .withinDistance(0.0D, 4.0D)
/* 1291 */             .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1292 */             .addNextBehavior(
/* 1293 */               CECombatBehaviors.Behavior.builder()
/* 1294 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1295 */               .withinDistance(0.0D, 4.0D)
/* 1296 */               .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1297 */               .addNextBehavior(
/* 1298 */                 CECombatBehaviors.Behavior.builder()
/* 1299 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1300 */                 .withinDistance(0.0D, 5.0D)
/* 1301 */                 .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1302 */                 .addNextBehavior(
/* 1303 */                   CECombatBehaviors.Behavior.builder()
/* 1304 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1305 */                   .withinDistance(0.0D, 5.0D)
/* 1306 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1314 */       .addFirstBehavior(
/* 1315 */         CECombatBehaviors.Behavior.builder()
/* 1316 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1317 */         .withinDistance(0.0D, 3.0D)
/* 1318 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO4, 0.0F)
/* 1319 */         .addNextBehavior(
/* 1320 */           CECombatBehaviors.Behavior.builder()
/* 1321 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1322 */           .withinDistance(0.0D, 3.0D)
/* 1323 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1324 */           .addNextBehavior(
/* 1325 */             CECombatBehaviors.Behavior.builder()
/* 1326 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1327 */             .withinDistance(0.0D, 4.0D)
/* 1328 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1329 */             .addNextBehavior(
/* 1330 */               CECombatBehaviors.Behavior.builder()
/* 1331 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1332 */               .withinDistance(0.0D, 4.0D)
/* 1333 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1334 */               .addNextBehavior(
/* 1335 */                 CECombatBehaviors.Behavior.builder()
/* 1336 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1337 */                 .withinDistance(0.0D, 5.0D)
/* 1338 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1345 */       .addFirstBehavior(
/* 1346 */         CECombatBehaviors.Behavior.builder()
/* 1347 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1348 */         .withinDistance(0.0D, 3.0D)
/* 1349 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1350 */         .addNextBehavior(
/* 1351 */           CECombatBehaviors.Behavior.builder()
/* 1352 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1353 */           .withinDistance(0.0D, 3.0D)
/* 1354 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1355 */           .addNextBehavior(
/* 1356 */             CECombatBehaviors.Behavior.builder()
/* 1357 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1358 */             .withinDistance(0.0D, 4.0D)
/* 1359 */             .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1360 */             .addNextBehavior(
/* 1361 */               CECombatBehaviors.Behavior.builder()
/* 1362 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1363 */               .withinDistance(0.0D, 4.0D)
/* 1364 */               .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/* 1365 */               .addNextBehavior(
/* 1366 */                 CECombatBehaviors.Behavior.builder()
/* 1367 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1368 */                 .withinDistance(0.0D, 5.0D)
/* 1369 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1370 */                 .addNextBehavior(
/* 1371 */                   CECombatBehaviors.Behavior.builder()
/* 1372 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1373 */                   .withinDistance(0.0D, 5.0D)
/* 1374 */                   .animationBehavior(Animations.DAGGER_DUAL_AUTO3, 0.0F)
/* 1375 */                   .addNextBehavior(
/* 1376 */                     CECombatBehaviors.Behavior.builder()
/* 1377 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1378 */                     .withinDistance(0.0D, 5.0D)
/* 1379 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1388 */       .addFirstBehavior(
/* 1389 */         CECombatBehaviors.Behavior.builder()
/* 1390 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1391 */         .withinDistance(0.0D, 3.0D)
/* 1392 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1393 */         .addNextBehavior(
/* 1394 */           CECombatBehaviors.Behavior.builder()
/* 1395 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1396 */           .withinDistance(0.0D, 3.0D)
/* 1397 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1398 */           .addNextBehavior(
/* 1399 */             CECombatBehaviors.Behavior.builder()
/* 1400 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1401 */             .withinDistance(0.0D, 4.0D)
/* 1402 */             .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1403 */             .addNextBehavior(
/* 1404 */               CECombatBehaviors.Behavior.builder()
/* 1405 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1406 */               .withinDistance(0.0D, 4.0D)
/* 1407 */               .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1408 */               .addNextBehavior(
/* 1409 */                 CECombatBehaviors.Behavior.builder()
/* 1410 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1411 */                 .withinDistance(0.0D, 5.0D)
/* 1412 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1413 */                 .addNextBehavior(
/* 1414 */                   CECombatBehaviors.Behavior.builder()
/* 1415 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1416 */                   .withinDistance(0.0D, 5.0D)
/* 1417 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1425 */       .addFirstBehavior(
/* 1426 */         CECombatBehaviors.Behavior.builder()
/* 1427 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1428 */         .withinDistance(0.0D, 3.0D)
/* 1429 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1430 */         .addNextBehavior(
/* 1431 */           CECombatBehaviors.Behavior.builder()
/* 1432 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1433 */           .withinDistance(0.0D, 3.0D)
/* 1434 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1435 */           .addNextBehavior(
/* 1436 */             CECombatBehaviors.Behavior.builder()
/* 1437 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1438 */             .withinDistance(0.0D, 4.0D)
/* 1439 */             .animationBehavior(Animations.BLADE_RUSH_COMBO1, 0.0F)
/* 1440 */             .addNextBehavior(
/* 1441 */               CECombatBehaviors.Behavior.builder()
/* 1442 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1443 */               .withinDistance(0.0D, 4.0D)
/* 1444 */               .animationBehavior(Animations.BLADE_RUSH_COMBO2, 0.0F)
/* 1445 */               .addNextBehavior(
/* 1446 */                 CECombatBehaviors.Behavior.builder()
/* 1447 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1448 */                 .withinDistance(0.0D, 5.0D)
/* 1449 */                 .animationBehavior(Animations.BLADE_RUSH_COMBO3, 0.0F)
/* 1450 */                 .addNextBehavior(
/* 1451 */                   CECombatBehaviors.Behavior.builder()
/* 1452 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1453 */                   .withinDistance(0.0D, 5.0D)
/* 1454 */                   .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/* 1455 */                   .addNextBehavior(
/* 1456 */                     CECombatBehaviors.Behavior.builder()
/* 1457 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1458 */                     .withinDistance(0.0D, 5.0D)
/* 1459 */                     .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1460 */                     .addNextBehavior(
/* 1461 */                       CECombatBehaviors.Behavior.builder()
/* 1462 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1463 */                       .withinDistance(0.0D, 5.0D)
/* 1464 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1474 */       .addFirstBehavior(
/* 1475 */         CECombatBehaviors.Behavior.builder()
/* 1476 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1477 */         .withinDistance(0.0D, 3.0D)
/* 1478 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1479 */         .addNextBehavior(
/* 1480 */           CECombatBehaviors.Behavior.builder()
/* 1481 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1482 */           .withinDistance(0.0D, 3.0D)
/* 1483 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1484 */           .addNextBehavior(
/* 1485 */             CECombatBehaviors.Behavior.builder()
/* 1486 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1487 */             .withinDistance(0.0D, 4.0D)
/* 1488 */             .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F)
/* 1489 */             .addNextBehavior(
/* 1490 */               CECombatBehaviors.Behavior.builder()
/* 1491 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1492 */               .withinDistance(0.0D, 4.0D)
/* 1493 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1494 */               .addNextBehavior(
/* 1495 */                 CECombatBehaviors.Behavior.builder()
/* 1496 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1497 */                 .withinDistance(0.0D, 5.0D)
/* 1498 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1505 */       .addFirstBehavior(
/* 1506 */         CECombatBehaviors.Behavior.builder()
/* 1507 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1508 */         .withinDistance(0.0D, 3.0D)
/* 1509 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1510 */         .addNextBehavior(
/* 1511 */           CECombatBehaviors.Behavior.builder()
/* 1512 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1513 */           .withinDistance(0.0D, 3.0D)
/* 1514 */           .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1515 */           .addNextBehavior(
/* 1516 */             CECombatBehaviors.Behavior.builder()
/* 1517 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1518 */             .withinDistance(0.0D, 4.0D)
/* 1519 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1520 */             .addNextBehavior(
/* 1521 */               CECombatBehaviors.Behavior.builder()
/* 1522 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1523 */               .withinDistance(0.0D, 4.0D)
/* 1524 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1525 */               .addNextBehavior(
/* 1526 */                 CECombatBehaviors.Behavior.builder()
/* 1527 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1528 */                 .withinDistance(0.0D, 5.0D)
/* 1529 */                 .animationBehavior(Animations.DAGGER_DUAL_AUTO3, 0.0F)
/* 1530 */                 .addNextBehavior(
/* 1531 */                   CECombatBehaviors.Behavior.builder()
/* 1532 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1533 */                   .withinDistance(0.0D, 5.0D)
/* 1534 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1542 */       .addFirstBehavior(
/* 1543 */         CECombatBehaviors.Behavior.builder()
/* 1544 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1545 */         .withinDistance(0.0D, 3.0D)
/* 1546 */         .animationBehavior(Animations.DAGGER_DUAL_AUTO1, 0.0F)
/* 1547 */         .addNextBehavior(
/* 1548 */           CECombatBehaviors.Behavior.builder()
/* 1549 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1550 */           .withinDistance(0.0D, 3.0D)
/* 1551 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1552 */           .addNextBehavior(
/* 1553 */             CECombatBehaviors.Behavior.builder()
/* 1554 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1555 */             .withinDistance(0.0D, 4.0D)
/* 1556 */             .animationBehavior(Animations.DAGGER_DUAL_AUTO2, 0.0F)
/* 1557 */             .addNextBehavior(
/* 1558 */               CECombatBehaviors.Behavior.builder()
/* 1559 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1560 */               .withinDistance(0.0D, 4.0D)
/* 1561 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1562 */               .addNextBehavior(
/* 1563 */                 CECombatBehaviors.Behavior.builder()
/* 1564 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1565 */                 .withinDistance(0.0D, 5.0D)
/* 1566 */                 .animationBehavior(Animations.DAGGER_DUAL_AUTO3, 0.0F)
/* 1567 */                 .addNextBehavior(
/* 1568 */                   CECombatBehaviors.Behavior.builder()
/* 1569 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1570 */                   .withinDistance(0.0D, 5.0D)
/* 1571 */                   .animationBehavior(Animations.BLADE_RUSH_COMBO1, 0.0F)
/* 1572 */                   .addNextBehavior(
/* 1573 */                     CECombatBehaviors.Behavior.builder()
/* 1574 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1575 */                     .withinDistance(0.0D, 5.0D)
/* 1576 */                     .animationBehavior(Animations.BLADE_RUSH_COMBO2, 0.0F)
/* 1577 */                     .addNextBehavior(
/* 1578 */                       CECombatBehaviors.Behavior.builder()
/* 1579 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1580 */                       .withinDistance(0.0D, 5.0D)
/* 1581 */                       .animationBehavior(Animations.BLADE_RUSH_COMBO3, 0.0F)
/* 1582 */                       .addNextBehavior(
/* 1583 */                         CECombatBehaviors.Behavior.builder()
/* 1584 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1585 */                         .withinDistance(0.0D, 5.0D)
/* 1586 */                         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1587 */                         .addNextBehavior(
/* 1588 */                           CECombatBehaviors.Behavior.builder()
/* 1589 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1590 */                           .withinDistance(0.0D, 5.0D)
/* 1591 */                           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1603 */     .newBehaviorRoot(
/* 1604 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1605 */       .priority(1.0D)
/* 1606 */       .weight(20.0D)
/* 1607 */       .maxCooldown(100)
/* 1608 */       .addFirstBehavior(
/* 1609 */         CECombatBehaviors.Behavior.builder()
/* 1610 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1611 */         .withinDistance(0.0D, 3.0D)
/* 1612 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1613 */         .addNextBehavior(
/* 1614 */           CECombatBehaviors.Behavior.builder()
/* 1615 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1616 */           .withinDistance(0.0D, 3.0D)
/* 1617 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1618 */           .addNextBehavior(
/* 1619 */             CECombatBehaviors.Behavior.builder()
/* 1620 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1621 */             .withinDistance(0.0D, 3.0D)
/* 1622 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1623 */             .addNextBehavior(
/* 1624 */               CECombatBehaviors.Behavior.builder()
/* 1625 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1626 */               .withinDistance(0.0D, 3.0D)
/* 1627 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1633 */     .newBehaviorRoot(
/* 1634 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1635 */       .priority(1.0D)
/* 1636 */       .weight(10.0D)
/* 1637 */       .maxCooldown(100)
/* 1638 */       .addFirstBehavior(
/* 1639 */         CECombatBehaviors.Behavior.builder()
/* 1640 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1641 */         .withinDistance(0.0D, 3.0D)
/* 1642 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F))
/*      */       
/* 1644 */       .addFirstBehavior(
/* 1645 */         CECombatBehaviors.Behavior.builder()
/* 1646 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1647 */         .withinDistance(0.0D, 3.0D)
/* 1648 */         .animationBehavior(Animations.DAGGER_AIR_SLASH, 0.0F))
/*      */       
/* 1650 */       .addFirstBehavior(
/* 1651 */         CECombatBehaviors.Behavior.builder()
/* 1652 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1653 */         .withinDistance(0.0D, 3.0D)
/* 1654 */         .animationBehavior(Animations.BLADE_RUSH_COMBO1, 0.0F)
/* 1655 */         .addNextBehavior(
/* 1656 */           CECombatBehaviors.Behavior.builder()
/* 1657 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1658 */           .withinDistance(0.0D, 3.0D)
/* 1659 */           .animationBehavior(Animations.BLADE_RUSH_COMBO2, 0.0F)
/* 1660 */           .addNextBehavior(
/* 1661 */             CECombatBehaviors.Behavior.builder()
/* 1662 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1663 */             .withinDistance(0.0D, 3.0D)
/* 1664 */             .animationBehavior(Animations.BLADE_RUSH_COMBO3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1669 */     .newBehaviorRoot(
/* 1670 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1671 */       .priority(1.0D)
/* 1672 */       .weight(10.0D)
/* 1673 */       .maxCooldown(40)
/* 1674 */       .addFirstBehavior(
/* 1675 */         CECombatBehaviors.Behavior.builder()
/* 1676 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1677 */         .withinDistance(0.0D, 3.0D)
/* 1678 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1679 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1680 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1683 */     .newBehaviorRoot(
/* 1684 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1685 */       .priority(1.0D)
/* 1686 */       .weight(2.0D)
/* 1687 */       .maxCooldown(100)
/* 1688 */       .addFirstBehavior(
/* 1689 */         CECombatBehaviors.Behavior.builder()
/* 1690 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1691 */         .withinDistance(0.0D, 3.0D)
/* 1692 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1694 */       .addFirstBehavior(
/* 1695 */         CECombatBehaviors.Behavior.builder()
/* 1696 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1697 */         .withinDistance(0.0D, 3.0D)
/* 1698 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1700 */       .addFirstBehavior(
/* 1701 */         CECombatBehaviors.Behavior.builder()
/* 1702 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1703 */         .withinDistance(0.0D, 3.0D)
/* 1704 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1706 */       .addFirstBehavior(
/* 1707 */         CECombatBehaviors.Behavior.builder()
/* 1708 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1709 */         .withinDistance(0.0D, 3.0D)
/* 1710 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1712 */       .addFirstBehavior(
/* 1713 */         CECombatBehaviors.Behavior.builder()
/* 1714 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1715 */         .withinDistance(0.0D, 3.0D)
/* 1716 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1718 */       .addFirstBehavior(
/* 1719 */         CECombatBehaviors.Behavior.builder()
/* 1720 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1721 */         .withinDistance(0.0D, 3.0D)
/* 1722 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1724 */       .addFirstBehavior(
/* 1725 */         CECombatBehaviors.Behavior.builder()
/* 1726 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1727 */         .withinDistance(0.0D, 3.0D)
/* 1728 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1731 */     .newBehaviorRoot(
/* 1732 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1733 */       .priority(1.0D)
/* 1734 */       .weight(10.0D)
/* 1735 */       .addFirstBehavior(
/* 1736 */         CECombatBehaviors.Behavior.builder()
/* 1737 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1738 */         .withinDistance(0.0D, 3.0D)
/* 1739 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1741 */       .addFirstBehavior(
/* 1742 */         CECombatBehaviors.Behavior.builder()
/* 1743 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1744 */         .withinDistance(0.0D, 3.0D)
/* 1745 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1748 */     .newBehaviorRoot(
/* 1749 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1750 */       .priority(1.0D)
/* 1751 */       .weight(40.0D)
/* 1752 */       .maxCooldown(160)
/* 1753 */       .addFirstBehavior(
/* 1754 */         CECombatBehaviors.Behavior.builder()
/* 1755 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1756 */         .custom(CombatCommon::canJump)
/* 1757 */         .withinDistance(5.0D, 14.0D)
/* 1758 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1759 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcDagger.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */