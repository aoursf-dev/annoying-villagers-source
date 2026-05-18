/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.efkick.gameasset.EFKickAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsHerrscher;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NpcSword
/*      */ {
/*   15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SWORD = CECombatBehaviors.builder()
/*   16 */     .newBehaviorRoot(
/*   17 */       CECombatBehaviors.BehaviorRoot.builder()
/*   18 */       .priority(4.0D)
/*   19 */       .weight(1000.0D)
/*   20 */       .maxCooldown(0)
/*   21 */       .addFirstBehavior(
/*   22 */         CECombatBehaviors.Behavior.builder()
/*   23 */         .custom(CombatCommon::canExecute)
/*   24 */         .withinDistance(0.0D, 5.0D)
/*   25 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*   26 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*   29 */     .newBehaviorRoot(
/*   30 */       CECombatBehaviors.BehaviorRoot.builder()
/*   31 */       .priority(3.0D)
/*   32 */       .weight(1000.0D)
/*   33 */       .maxCooldown(0)
/*   34 */       .addFirstBehavior(
/*   35 */         CECombatBehaviors.Behavior.builder()
/*   36 */         .custom(CombatCommon::canEscape)
/*   37 */         .withinDistance(0.0D, 8.0D)
/*   38 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   39 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*   41 */       .addFirstBehavior(
/*   42 */         CECombatBehaviors.Behavior.builder()
/*   43 */         .custom(CombatCommon::canEscape)
/*   44 */         .withinDistance(0.0D, 48.0D)
/*   45 */         .guard(40)))
/*      */ 
/*      */     
/*   48 */     .newBehaviorRoot(
/*   49 */       CECombatBehaviors.BehaviorRoot.builder()
/*   50 */       .priority(2.0D)
/*   51 */       .weight(70.0D)
/*   52 */       .maxCooldown(0)
/*   53 */       .addFirstBehavior(
/*   54 */         CECombatBehaviors.Behavior.builder()
/*   55 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   56 */         .custom(CombatCommon::canPerformEating)
/*   57 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   58 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*   61 */     .newBehaviorRoot(
/*   62 */       CECombatBehaviors.BehaviorRoot.builder()
/*   63 */       .priority(2.0D)
/*   64 */       .weight(100.0D)
/*   65 */       .maxCooldown(120)
/*   66 */       .addFirstBehavior(
/*   67 */         CECombatBehaviors.Behavior.builder()
/*   68 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   69 */         .custom(CombatCommon::canSwapToBow)
/*   70 */         .withinDistance(7.0D, 14.0D)
/*   71 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*   72 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   74 */       .addFirstBehavior(
/*   75 */         CECombatBehaviors.Behavior.builder()
/*   76 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   77 */         .custom(CombatCommon::canSwapToBow)
/*   78 */         .withinDistance(7.0D, 14.0D)
/*   79 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   80 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   82 */       .addFirstBehavior(
/*   83 */         CECombatBehaviors.Behavior.builder()
/*   84 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   85 */         .custom(CombatCommon::canSwapToBow)
/*   86 */         .withinDistance(7.0D, 14.0D)
/*   87 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*   88 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   90 */       .addFirstBehavior(
/*   91 */         CECombatBehaviors.Behavior.builder()
/*   92 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   93 */         .custom(CombatCommon::canSwapToBow)
/*   94 */         .withinDistance(7.0D, 14.0D)
/*   95 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*   96 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*   99 */     .newBehaviorRoot(
/*  100 */       CECombatBehaviors.BehaviorRoot.builder()
/*  101 */       .priority(2.0D)
/*  102 */       .weight(80.0D)
/*  103 */       .maxCooldown(120)
/*  104 */       .addFirstBehavior(
/*  105 */         CECombatBehaviors.Behavior.builder()
/*  106 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  107 */         .custom(CombatCommon::canThrowEnderPearl)
/*  108 */         .withinDistance(7.0D, 48.0D)
/*  109 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  110 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  113 */     .newBehaviorRoot(
/*  114 */       CECombatBehaviors.BehaviorRoot.builder()
/*  115 */       .priority(1.0D)
/*  116 */       .weight(40.0D)
/*  117 */       .maxCooldown(20)
/*  118 */       .addFirstBehavior(
/*  119 */         CECombatBehaviors.Behavior.builder()
/*  120 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  121 */         .withinDistance(0.0D, 3.0D)
/*  122 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  123 */         .addNextBehavior(
/*  124 */           CECombatBehaviors.Behavior.builder()
/*  125 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  126 */           .withinDistance(0.0D, 3.0D)
/*  127 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  128 */           .addNextBehavior(
/*  129 */             CECombatBehaviors.Behavior.builder()
/*  130 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  131 */             .withinDistance(0.0D, 3.0D)
/*  132 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  136 */       .addFirstBehavior(
/*  137 */         CECombatBehaviors.Behavior.builder()
/*  138 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  139 */         .withinDistance(0.0D, 3.0D)
/*  140 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  141 */         .addNextBehavior(
/*  142 */           CECombatBehaviors.Behavior.builder()
/*  143 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  144 */           .withinDistance(0.0D, 3.0D)
/*  145 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  146 */           .addNextBehavior(
/*  147 */             CECombatBehaviors.Behavior.builder()
/*  148 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  149 */             .withinDistance(0.0D, 4.0D)
/*  150 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  151 */             .addNextBehavior(
/*  152 */               CECombatBehaviors.Behavior.builder()
/*  153 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  154 */               .withinDistance(0.0D, 4.0D)
/*  155 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  156 */               .addNextBehavior(
/*  157 */                 CECombatBehaviors.Behavior.builder()
/*  158 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  159 */                 .withinDistance(0.0D, 5.0D)
/*  160 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  167 */       .addFirstBehavior(
/*  168 */         CECombatBehaviors.Behavior.builder()
/*  169 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  170 */         .withinDistance(0.0D, 3.0D)
/*  171 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  172 */         .addNextBehavior(
/*  173 */           CECombatBehaviors.Behavior.builder()
/*  174 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  175 */           .withinDistance(0.0D, 3.0D)
/*  176 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  177 */           .addNextBehavior(
/*  178 */             CECombatBehaviors.Behavior.builder()
/*  179 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  180 */             .withinDistance(0.0D, 4.0D)
/*  181 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  182 */             .addNextBehavior(
/*  183 */               CECombatBehaviors.Behavior.builder()
/*  184 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  185 */               .withinDistance(0.0D, 4.0D)
/*  186 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  187 */               .addNextBehavior(
/*  188 */                 CECombatBehaviors.Behavior.builder()
/*  189 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  190 */                 .withinDistance(0.0D, 5.0D)
/*  191 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  198 */       .addFirstBehavior(
/*  199 */         CECombatBehaviors.Behavior.builder()
/*  200 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  201 */         .withinDistance(0.0D, 3.0D)
/*  202 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  203 */         .addNextBehavior(
/*  204 */           CECombatBehaviors.Behavior.builder()
/*  205 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  206 */           .withinDistance(0.0D, 3.0D)
/*  207 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  208 */           .addNextBehavior(
/*  209 */             CECombatBehaviors.Behavior.builder()
/*  210 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  211 */             .withinDistance(0.0D, 4.0D)
/*  212 */             .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  213 */             .addNextBehavior(
/*  214 */               CECombatBehaviors.Behavior.builder()
/*  215 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  216 */               .withinDistance(0.0D, 4.0D)
/*  217 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  218 */               .addNextBehavior(
/*  219 */                 CECombatBehaviors.Behavior.builder()
/*  220 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  221 */                 .withinDistance(0.0D, 5.0D)
/*  222 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  229 */       .addFirstBehavior(
/*  230 */         CECombatBehaviors.Behavior.builder()
/*  231 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  232 */         .withinDistance(0.0D, 3.0D)
/*  233 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  234 */         .addNextBehavior(
/*  235 */           CECombatBehaviors.Behavior.builder()
/*  236 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  237 */           .withinDistance(0.0D, 3.0D)
/*  238 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  239 */           .addNextBehavior(
/*  240 */             CECombatBehaviors.Behavior.builder()
/*  241 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  242 */             .withinDistance(0.0D, 4.0D)
/*  243 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  244 */             .addNextBehavior(
/*  245 */               CECombatBehaviors.Behavior.builder()
/*  246 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  247 */               .withinDistance(0.0D, 4.0D)
/*  248 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  249 */               .addNextBehavior(
/*  250 */                 CECombatBehaviors.Behavior.builder()
/*  251 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  252 */                 .withinDistance(0.0D, 5.0D)
/*  253 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  254 */                 .addNextBehavior(
/*  255 */                   CECombatBehaviors.Behavior.builder()
/*  256 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  257 */                   .withinDistance(0.0D, 5.0D)
/*  258 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  266 */       .addFirstBehavior(
/*  267 */         CECombatBehaviors.Behavior.builder()
/*  268 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  269 */         .withinDistance(0.0D, 3.0D)
/*  270 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  271 */         .addNextBehavior(
/*  272 */           CECombatBehaviors.Behavior.builder()
/*  273 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  274 */           .withinDistance(0.0D, 3.0D)
/*  275 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  276 */           .addNextBehavior(
/*  277 */             CECombatBehaviors.Behavior.builder()
/*  278 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  279 */             .withinDistance(0.0D, 4.0D)
/*  280 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  281 */             .addNextBehavior(
/*  282 */               CECombatBehaviors.Behavior.builder()
/*  283 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  284 */               .withinDistance(0.0D, 4.0D)
/*  285 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  286 */               .addNextBehavior(
/*  287 */                 CECombatBehaviors.Behavior.builder()
/*  288 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  289 */                 .withinDistance(0.0D, 5.0D)
/*  290 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  291 */                 .addNextBehavior(
/*  292 */                   CECombatBehaviors.Behavior.builder()
/*  293 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  294 */                   .withinDistance(0.0D, 5.0D)
/*  295 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  303 */       .addFirstBehavior(
/*  304 */         CECombatBehaviors.Behavior.builder()
/*  305 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  306 */         .withinDistance(0.0D, 3.0D)
/*  307 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  308 */         .addNextBehavior(
/*  309 */           CECombatBehaviors.Behavior.builder()
/*  310 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  311 */           .withinDistance(0.0D, 3.0D)
/*  312 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  313 */           .addNextBehavior(
/*  314 */             CECombatBehaviors.Behavior.builder()
/*  315 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  316 */             .withinDistance(0.0D, 4.0D)
/*  317 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  318 */             .addNextBehavior(
/*  319 */               CECombatBehaviors.Behavior.builder()
/*  320 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  321 */               .withinDistance(0.0D, 4.0D)
/*  322 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  323 */               .addNextBehavior(
/*  324 */                 CECombatBehaviors.Behavior.builder()
/*  325 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  326 */                 .withinDistance(0.0D, 5.0D)
/*  327 */                 .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  328 */                 .addNextBehavior(
/*  329 */                   CECombatBehaviors.Behavior.builder()
/*  330 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  331 */                   .withinDistance(0.0D, 5.0D)
/*  332 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  340 */       .addFirstBehavior(
/*  341 */         CECombatBehaviors.Behavior.builder()
/*  342 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  343 */         .withinDistance(0.0D, 3.0D)
/*  344 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  345 */         .addNextBehavior(
/*  346 */           CECombatBehaviors.Behavior.builder()
/*  347 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  348 */           .withinDistance(0.0D, 3.0D)
/*  349 */           .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  350 */           .addNextBehavior(
/*  351 */             CECombatBehaviors.Behavior.builder()
/*  352 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  353 */             .withinDistance(0.0D, 4.0D)
/*  354 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  355 */             .addNextBehavior(
/*  356 */               CECombatBehaviors.Behavior.builder()
/*  357 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  358 */               .withinDistance(0.0D, 4.0D)
/*  359 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  360 */               .addNextBehavior(
/*  361 */                 CECombatBehaviors.Behavior.builder()
/*  362 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  363 */                 .withinDistance(0.0D, 5.0D)
/*  364 */                 .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  365 */                 .addNextBehavior(
/*  366 */                   CECombatBehaviors.Behavior.builder()
/*  367 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  368 */                   .withinDistance(0.0D, 5.0D)
/*  369 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  377 */       .addFirstBehavior(
/*  378 */         CECombatBehaviors.Behavior.builder()
/*  379 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  380 */         .withinDistance(0.0D, 3.0D)
/*  381 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  382 */         .addNextBehavior(
/*  383 */           CECombatBehaviors.Behavior.builder()
/*  384 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  385 */           .withinDistance(0.0D, 3.0D)
/*  386 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  387 */           .addNextBehavior(
/*  388 */             CECombatBehaviors.Behavior.builder()
/*  389 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  390 */             .withinDistance(0.0D, 4.0D)
/*  391 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  392 */             .addNextBehavior(
/*  393 */               CECombatBehaviors.Behavior.builder()
/*  394 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  395 */               .withinDistance(0.0D, 4.0D)
/*  396 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  397 */               .addNextBehavior(
/*  398 */                 CECombatBehaviors.Behavior.builder()
/*  399 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  400 */                 .withinDistance(0.0D, 5.0D)
/*  401 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  402 */                 .addNextBehavior(
/*  403 */                   CECombatBehaviors.Behavior.builder()
/*  404 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  405 */                   .withinDistance(0.0D, 5.0D)
/*  406 */                   .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  407 */                   .addNextBehavior(
/*  408 */                     CECombatBehaviors.Behavior.builder()
/*  409 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  410 */                     .withinDistance(0.0D, 5.0D)
/*  411 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  420 */       .addFirstBehavior(
/*  421 */         CECombatBehaviors.Behavior.builder()
/*  422 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  423 */         .withinDistance(0.0D, 3.0D)
/*  424 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  425 */         .addNextBehavior(
/*  426 */           CECombatBehaviors.Behavior.builder()
/*  427 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  428 */           .withinDistance(0.0D, 3.0D)
/*  429 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  430 */           .addNextBehavior(
/*  431 */             CECombatBehaviors.Behavior.builder()
/*  432 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  433 */             .withinDistance(0.0D, 4.0D)
/*  434 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  435 */             .addNextBehavior(
/*  436 */               CECombatBehaviors.Behavior.builder()
/*  437 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  438 */               .withinDistance(0.0D, 4.0D)
/*  439 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  440 */               .addNextBehavior(
/*  441 */                 CECombatBehaviors.Behavior.builder()
/*  442 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  443 */                 .withinDistance(0.0D, 5.0D)
/*  444 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  445 */                 .addNextBehavior(
/*  446 */                   CECombatBehaviors.Behavior.builder()
/*  447 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  448 */                   .withinDistance(0.0D, 5.0D)
/*  449 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  450 */                   .addNextBehavior(
/*  451 */                     CECombatBehaviors.Behavior.builder()
/*  452 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  453 */                     .withinDistance(0.0D, 5.0D)
/*  454 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  463 */       .addFirstBehavior(
/*  464 */         CECombatBehaviors.Behavior.builder()
/*  465 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  466 */         .withinDistance(0.0D, 3.0D)
/*  467 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  468 */         .addNextBehavior(
/*  469 */           CECombatBehaviors.Behavior.builder()
/*  470 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  471 */           .withinDistance(0.0D, 3.0D)
/*  472 */           .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  473 */           .addNextBehavior(
/*  474 */             CECombatBehaviors.Behavior.builder()
/*  475 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  476 */             .withinDistance(0.0D, 4.0D)
/*  477 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  478 */             .addNextBehavior(
/*  479 */               CECombatBehaviors.Behavior.builder()
/*  480 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  481 */               .withinDistance(0.0D, 4.0D)
/*  482 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  483 */               .addNextBehavior(
/*  484 */                 CECombatBehaviors.Behavior.builder()
/*  485 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */                 .withinDistance(0.0D, 5.0D)
/*  487 */                 .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  488 */                 .addNextBehavior(
/*  489 */                   CECombatBehaviors.Behavior.builder()
/*  490 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  491 */                   .withinDistance(0.0D, 5.0D)
/*  492 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  493 */                   .addNextBehavior(
/*  494 */                     CECombatBehaviors.Behavior.builder()
/*  495 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  496 */                     .withinDistance(0.0D, 5.0D)
/*  497 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  506 */       .addFirstBehavior(
/*  507 */         CECombatBehaviors.Behavior.builder()
/*  508 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  509 */         .withinDistance(0.0D, 3.0D)
/*  510 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  511 */         .addNextBehavior(
/*  512 */           CECombatBehaviors.Behavior.builder()
/*  513 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  514 */           .withinDistance(0.0D, 3.0D)
/*  515 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  516 */           .addNextBehavior(
/*  517 */             CECombatBehaviors.Behavior.builder()
/*  518 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  519 */             .withinDistance(0.0D, 4.0D)
/*  520 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  521 */             .addNextBehavior(
/*  522 */               CECombatBehaviors.Behavior.builder()
/*  523 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  524 */               .withinDistance(0.0D, 4.0D)
/*  525 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  526 */               .addNextBehavior(
/*  527 */                 CECombatBehaviors.Behavior.builder()
/*  528 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  529 */                 .withinDistance(0.0D, 5.0D)
/*  530 */                 .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  531 */                 .addNextBehavior(
/*  532 */                   CECombatBehaviors.Behavior.builder()
/*  533 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  534 */                   .withinDistance(0.0D, 5.0D)
/*  535 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  536 */                   .addNextBehavior(
/*  537 */                     CECombatBehaviors.Behavior.builder()
/*  538 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  539 */                     .withinDistance(0.0D, 5.0D)
/*  540 */                     .animationBehavior(Animations.SWORD_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  549 */       .addFirstBehavior(
/*  550 */         CECombatBehaviors.Behavior.builder()
/*  551 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  552 */         .withinDistance(0.0D, 3.0D)
/*  553 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  554 */         .addNextBehavior(
/*  555 */           CECombatBehaviors.Behavior.builder()
/*  556 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  557 */           .withinDistance(0.0D, 3.0D)
/*  558 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  559 */           .addNextBehavior(
/*  560 */             CECombatBehaviors.Behavior.builder()
/*  561 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  562 */             .withinDistance(0.0D, 4.0D)
/*  563 */             .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  564 */             .addNextBehavior(
/*  565 */               CECombatBehaviors.Behavior.builder()
/*  566 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  567 */               .withinDistance(0.0D, 4.0D)
/*  568 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  569 */               .addNextBehavior(
/*  570 */                 CECombatBehaviors.Behavior.builder()
/*  571 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  572 */                 .withinDistance(0.0D, 5.0D)
/*  573 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  574 */                 .addNextBehavior(
/*  575 */                   CECombatBehaviors.Behavior.builder()
/*  576 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  577 */                   .withinDistance(0.0D, 5.0D)
/*  578 */                   .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  579 */                   .addNextBehavior(
/*  580 */                     CECombatBehaviors.Behavior.builder()
/*  581 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  582 */                     .withinDistance(0.0D, 5.0D)
/*  583 */                     .animationBehavior(Animations.SWORD_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  592 */       .addFirstBehavior(
/*  593 */         CECombatBehaviors.Behavior.builder()
/*  594 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  595 */         .withinDistance(0.0D, 3.0D)
/*  596 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  597 */         .addNextBehavior(
/*  598 */           CECombatBehaviors.Behavior.builder()
/*  599 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  600 */           .withinDistance(0.0D, 3.0D)
/*  601 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  602 */           .addNextBehavior(
/*  603 */             CECombatBehaviors.Behavior.builder()
/*  604 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  605 */             .withinDistance(0.0D, 4.0D)
/*  606 */             .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  607 */             .addNextBehavior(
/*  608 */               CECombatBehaviors.Behavior.builder()
/*  609 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  610 */               .withinDistance(0.0D, 4.0D)
/*  611 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  612 */               .addNextBehavior(
/*  613 */                 CECombatBehaviors.Behavior.builder()
/*  614 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  615 */                 .withinDistance(0.0D, 5.0D)
/*  616 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  617 */                 .addNextBehavior(
/*  618 */                   CECombatBehaviors.Behavior.builder()
/*  619 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  620 */                   .withinDistance(0.0D, 5.0D)
/*  621 */                   .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  629 */       .addFirstBehavior(
/*  630 */         CECombatBehaviors.Behavior.builder()
/*  631 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  632 */         .withinDistance(0.0D, 3.0D)
/*  633 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  634 */         .addNextBehavior(
/*  635 */           CECombatBehaviors.Behavior.builder()
/*  636 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  637 */           .withinDistance(0.0D, 3.0D)
/*  638 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  639 */           .addNextBehavior(
/*  640 */             CECombatBehaviors.Behavior.builder()
/*  641 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  642 */             .withinDistance(0.0D, 4.0D)
/*  643 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  644 */             .addNextBehavior(
/*  645 */               CECombatBehaviors.Behavior.builder()
/*  646 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  647 */               .withinDistance(0.0D, 4.0D)
/*  648 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  649 */               .addNextBehavior(
/*  650 */                 CECombatBehaviors.Behavior.builder()
/*  651 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  652 */                 .withinDistance(0.0D, 5.0D)
/*  653 */                 .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  654 */                 .addNextBehavior(
/*  655 */                   CECombatBehaviors.Behavior.builder()
/*  656 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  657 */                   .withinDistance(0.0D, 5.0D)
/*  658 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  666 */       .addFirstBehavior(
/*  667 */         CECombatBehaviors.Behavior.builder()
/*  668 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  669 */         .withinDistance(0.0D, 3.0D)
/*  670 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  671 */         .addNextBehavior(
/*  672 */           CECombatBehaviors.Behavior.builder()
/*  673 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  674 */           .withinDistance(0.0D, 3.0D)
/*  675 */           .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  676 */           .addNextBehavior(
/*  677 */             CECombatBehaviors.Behavior.builder()
/*  678 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  679 */             .withinDistance(0.0D, 4.0D)
/*  680 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  681 */             .addNextBehavior(
/*  682 */               CECombatBehaviors.Behavior.builder()
/*  683 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  684 */               .withinDistance(0.0D, 4.0D)
/*  685 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  686 */               .addNextBehavior(
/*  687 */                 CECombatBehaviors.Behavior.builder()
/*  688 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  689 */                 .withinDistance(0.0D, 5.0D)
/*  690 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  697 */     .newBehaviorRoot(
/*  698 */       CECombatBehaviors.BehaviorRoot.builder()
/*  699 */       .priority(1.0D)
/*  700 */       .weight(20.0D)
/*  701 */       .maxCooldown(80)
/*  702 */       .addFirstBehavior(
/*  703 */         CECombatBehaviors.Behavior.builder()
/*  704 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  705 */         .withinDistance(0.0D, 3.0D)
/*  706 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  707 */         .addNextBehavior(
/*  708 */           CECombatBehaviors.Behavior.builder()
/*  709 */           .withinDistance(0.0D, 3.0D)
/*  710 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  711 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  712 */           .addNextBehavior(
/*  713 */             CECombatBehaviors.Behavior.builder()
/*  714 */             .withinDistance(0.0D, 3.0D)
/*  715 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  716 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  721 */     .newBehaviorRoot(
/*  722 */       CECombatBehaviors.BehaviorRoot.builder()
/*  723 */       .priority(1.0D)
/*  724 */       .weight(10.0D)
/*  725 */       .maxCooldown(80)
/*  726 */       .addFirstBehavior(
/*  727 */         CECombatBehaviors.Behavior.builder()
/*  728 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  729 */         .withinDistance(0.0D, 3.0D)
/*  730 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*      */       
/*  732 */       .addFirstBehavior(
/*  733 */         CECombatBehaviors.Behavior.builder()
/*  734 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  735 */         .withinDistance(0.0D, 3.0D)
/*  736 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*      */       
/*  738 */       .addFirstBehavior(
/*  739 */         CECombatBehaviors.Behavior.builder()
/*  740 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  741 */         .withinDistance(0.0D, 3.0D)
/*  742 */         .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))
/*      */ 
/*      */     
/*  745 */     .newBehaviorRoot(
/*  746 */       CECombatBehaviors.BehaviorRoot.builder()
/*  747 */       .priority(1.0D)
/*  748 */       .weight(10.0D)
/*  749 */       .maxCooldown(40)
/*  750 */       .addFirstBehavior(
/*  751 */         CECombatBehaviors.Behavior.builder()
/*  752 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  753 */         .withinDistance(0.0D, 3.0D)
/*  754 */         .custom(CombatCommon::canThrowEnderPearl)
/*  755 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  756 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  757 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  760 */     .newBehaviorRoot(
/*  761 */       CECombatBehaviors.BehaviorRoot.builder()
/*  762 */       .priority(1.0D)
/*  763 */       .weight(2.0D)
/*  764 */       .maxCooldown(100)
/*  765 */       .addFirstBehavior(
/*  766 */         CECombatBehaviors.Behavior.builder()
/*  767 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  768 */         .withinDistance(0.0D, 3.0D)
/*  769 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  771 */       .addFirstBehavior(
/*  772 */         CECombatBehaviors.Behavior.builder()
/*  773 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  774 */         .withinDistance(0.0D, 3.0D)
/*  775 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  777 */       .addFirstBehavior(
/*  778 */         CECombatBehaviors.Behavior.builder()
/*  779 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  780 */         .withinDistance(0.0D, 3.0D)
/*  781 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  783 */       .addFirstBehavior(
/*  784 */         CECombatBehaviors.Behavior.builder()
/*  785 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  786 */         .withinDistance(0.0D, 3.0D)
/*  787 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  789 */       .addFirstBehavior(
/*  790 */         CECombatBehaviors.Behavior.builder()
/*  791 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  792 */         .withinDistance(0.0D, 3.0D)
/*  793 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  795 */       .addFirstBehavior(
/*  796 */         CECombatBehaviors.Behavior.builder()
/*  797 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  798 */         .withinDistance(0.0D, 3.0D)
/*  799 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  801 */       .addFirstBehavior(
/*  802 */         CECombatBehaviors.Behavior.builder()
/*  803 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  804 */         .withinDistance(0.0D, 3.0D)
/*  805 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  808 */     .newBehaviorRoot(
/*  809 */       CECombatBehaviors.BehaviorRoot.builder()
/*  810 */       .priority(1.0D)
/*  811 */       .weight(15.0D)
/*  812 */       .addFirstBehavior(
/*  813 */         CECombatBehaviors.Behavior.builder()
/*  814 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  815 */         .withinDistance(0.5D, 3.0D)
/*  816 */         .custom(CombatCommon::canPerformGuarding)
/*  817 */         .guard(40)))
/*      */ 
/*      */     
/*  820 */     .newBehaviorRoot(
/*  821 */       CECombatBehaviors.BehaviorRoot.builder()
/*  822 */       .priority(1.0D)
/*  823 */       .weight(10.0D)
/*  824 */       .addFirstBehavior(
/*  825 */         CECombatBehaviors.Behavior.builder()
/*  826 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  827 */         .withinDistance(0.0D, 3.0D)
/*  828 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/*  830 */       .addFirstBehavior(
/*  831 */         CECombatBehaviors.Behavior.builder()
/*  832 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  833 */         .withinDistance(0.0D, 3.0D)
/*  834 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/*  836 */       .addFirstBehavior(
/*  837 */         CECombatBehaviors.Behavior.builder()
/*  838 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  839 */         .withinDistance(0.0D, 3.0D)
/*  840 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/*  842 */       .addFirstBehavior(
/*  843 */         CECombatBehaviors.Behavior.builder()
/*  844 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  845 */         .withinDistance(0.0D, 3.0D)
/*  846 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/*  849 */     .newBehaviorRoot(
/*  850 */       CECombatBehaviors.BehaviorRoot.builder()
/*  851 */       .priority(1.0D)
/*  852 */       .weight(40.0D)
/*  853 */       .maxCooldown(160)
/*  854 */       .addFirstBehavior(
/*  855 */         CECombatBehaviors.Behavior.builder()
/*  856 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  857 */         .custom(CombatCommon::canJump)
/*  858 */         .withinDistance(5.0D, 14.0D)
/*  859 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/*  860 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/*  864 */   public static final CECombatBehaviors.Builder<MobPatch<?>> DUAL_SWORD = CECombatBehaviors.builder()
/*  865 */     .newBehaviorRoot(
/*  866 */       CECombatBehaviors.BehaviorRoot.builder()
/*  867 */       .priority(4.0D)
/*  868 */       .weight(1000.0D)
/*  869 */       .maxCooldown(0)
/*  870 */       .addFirstBehavior(
/*  871 */         CECombatBehaviors.Behavior.builder()
/*  872 */         .custom(CombatCommon::canExecute)
/*  873 */         .withinDistance(0.0D, 5.0D)
/*  874 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  875 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  878 */     .newBehaviorRoot(
/*  879 */       CECombatBehaviors.BehaviorRoot.builder()
/*  880 */       .priority(3.0D)
/*  881 */       .weight(1000.0D)
/*  882 */       .maxCooldown(0)
/*  883 */       .addFirstBehavior(
/*  884 */         CECombatBehaviors.Behavior.builder()
/*  885 */         .custom(CombatCommon::canEscape)
/*  886 */         .withinDistance(0.0D, 8.0D)
/*  887 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  888 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  890 */       .addFirstBehavior(
/*  891 */         CECombatBehaviors.Behavior.builder()
/*  892 */         .custom(CombatCommon::canEscape)
/*  893 */         .withinDistance(0.0D, 48.0D)
/*  894 */         .guard(40)))
/*      */ 
/*      */     
/*  897 */     .newBehaviorRoot(
/*  898 */       CECombatBehaviors.BehaviorRoot.builder()
/*  899 */       .priority(2.0D)
/*  900 */       .weight(70.0D)
/*  901 */       .maxCooldown(0)
/*  902 */       .addFirstBehavior(
/*  903 */         CECombatBehaviors.Behavior.builder()
/*  904 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  905 */         .custom(CombatCommon::canPerformEating)
/*  906 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  907 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  910 */     .newBehaviorRoot(
/*  911 */       CECombatBehaviors.BehaviorRoot.builder()
/*  912 */       .priority(2.0D)
/*  913 */       .weight(100.0D)
/*  914 */       .maxCooldown(120)
/*  915 */       .addFirstBehavior(
/*  916 */         CECombatBehaviors.Behavior.builder()
/*  917 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  918 */         .custom(CombatCommon::canSwapToBow)
/*  919 */         .withinDistance(7.0D, 14.0D)
/*  920 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  921 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  923 */       .addFirstBehavior(
/*  924 */         CECombatBehaviors.Behavior.builder()
/*  925 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  926 */         .custom(CombatCommon::canSwapToBow)
/*  927 */         .withinDistance(7.0D, 14.0D)
/*  928 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  929 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  931 */       .addFirstBehavior(
/*  932 */         CECombatBehaviors.Behavior.builder()
/*  933 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  934 */         .custom(CombatCommon::canSwapToBow)
/*  935 */         .withinDistance(7.0D, 14.0D)
/*  936 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  937 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  939 */       .addFirstBehavior(
/*  940 */         CECombatBehaviors.Behavior.builder()
/*  941 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  942 */         .custom(CombatCommon::canSwapToBow)
/*  943 */         .withinDistance(7.0D, 14.0D)
/*  944 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  945 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  948 */     .newBehaviorRoot(
/*  949 */       CECombatBehaviors.BehaviorRoot.builder()
/*  950 */       .priority(2.0D)
/*  951 */       .weight(80.0D)
/*  952 */       .maxCooldown(120)
/*  953 */       .addFirstBehavior(
/*  954 */         CECombatBehaviors.Behavior.builder()
/*  955 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  956 */         .custom(CombatCommon::canThrowEnderPearl)
/*  957 */         .withinDistance(7.0D, 48.0D)
/*  958 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  959 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  962 */     .newBehaviorRoot(
/*  963 */       CECombatBehaviors.BehaviorRoot.builder()
/*  964 */       .priority(1.0D)
/*  965 */       .weight(40.0D)
/*  966 */       .maxCooldown(20)
/*  967 */       .addFirstBehavior(
/*  968 */         CECombatBehaviors.Behavior.builder()
/*  969 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  970 */         .withinDistance(0.0D, 3.0D)
/*  971 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/*  972 */         .addNextBehavior(
/*  973 */           CECombatBehaviors.Behavior.builder()
/*  974 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  975 */           .withinDistance(0.0D, 3.0D)
/*  976 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/*  977 */           .addNextBehavior(
/*  978 */             CECombatBehaviors.Behavior.builder()
/*  979 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  980 */             .withinDistance(0.0D, 3.0D)
/*  981 */             .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  985 */       .addFirstBehavior(
/*  986 */         CECombatBehaviors.Behavior.builder()
/*  987 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  988 */         .withinDistance(0.0D, 3.0D)
/*  989 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/*  990 */         .addNextBehavior(
/*  991 */           CECombatBehaviors.Behavior.builder()
/*  992 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  993 */           .withinDistance(0.0D, 3.0D)
/*  994 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/*  995 */           .addNextBehavior(
/*  996 */             CECombatBehaviors.Behavior.builder()
/*  997 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  998 */             .withinDistance(0.0D, 4.0D)
/*  999 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1000 */             .addNextBehavior(
/* 1001 */               CECombatBehaviors.Behavior.builder()
/* 1002 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1003 */               .withinDistance(0.0D, 4.0D)
/* 1004 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1005 */               .addNextBehavior(
/* 1006 */                 CECombatBehaviors.Behavior.builder()
/* 1007 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1008 */                 .withinDistance(0.0D, 5.0D)
/* 1009 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1010 */                 .addNextBehavior(
/* 1011 */                   CECombatBehaviors.Behavior.builder()
/* 1012 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1013 */                   .withinDistance(0.0D, 5.0D)
/* 1014 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1022 */       .addFirstBehavior(
/* 1023 */         CECombatBehaviors.Behavior.builder()
/* 1024 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1025 */         .withinDistance(0.0D, 3.0D)
/* 1026 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1027 */         .addNextBehavior(
/* 1028 */           CECombatBehaviors.Behavior.builder()
/* 1029 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1030 */           .withinDistance(0.0D, 3.0D)
/* 1031 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1032 */           .addNextBehavior(
/* 1033 */             CECombatBehaviors.Behavior.builder()
/* 1034 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1035 */             .withinDistance(0.0D, 4.0D)
/* 1036 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1037 */             .addNextBehavior(
/* 1038 */               CECombatBehaviors.Behavior.builder()
/* 1039 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1040 */               .withinDistance(0.0D, 4.0D)
/* 1041 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1042 */               .addNextBehavior(
/* 1043 */                 CECombatBehaviors.Behavior.builder()
/* 1044 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1045 */                 .withinDistance(0.0D, 5.0D)
/* 1046 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1047 */                 .addNextBehavior(
/* 1048 */                   CECombatBehaviors.Behavior.builder()
/* 1049 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1050 */                   .withinDistance(0.0D, 5.0D)
/* 1051 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1059 */       .addFirstBehavior(
/* 1060 */         CECombatBehaviors.Behavior.builder()
/* 1061 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1062 */         .withinDistance(0.0D, 3.0D)
/* 1063 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1064 */         .addNextBehavior(
/* 1065 */           CECombatBehaviors.Behavior.builder()
/* 1066 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1067 */           .withinDistance(0.0D, 3.0D)
/* 1068 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1069 */           .addNextBehavior(
/* 1070 */             CECombatBehaviors.Behavior.builder()
/* 1071 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1072 */             .withinDistance(0.0D, 4.0D)
/* 1073 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1074 */             .addNextBehavior(
/* 1075 */               CECombatBehaviors.Behavior.builder()
/* 1076 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1077 */               .withinDistance(0.0D, 4.0D)
/* 1078 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1079 */               .addNextBehavior(
/* 1080 */                 CECombatBehaviors.Behavior.builder()
/* 1081 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1082 */                 .withinDistance(0.0D, 5.0D)
/* 1083 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1084 */                 .addNextBehavior(
/* 1085 */                   CECombatBehaviors.Behavior.builder()
/* 1086 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1087 */                   .withinDistance(0.0D, 5.0D)
/* 1088 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1089 */                   .addNextBehavior(
/* 1090 */                     CECombatBehaviors.Behavior.builder()
/* 1091 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1092 */                     .withinDistance(0.0D, 5.0D)
/* 1093 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1102 */       .addFirstBehavior(
/* 1103 */         CECombatBehaviors.Behavior.builder()
/* 1104 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1105 */         .withinDistance(0.0D, 3.0D)
/* 1106 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1107 */         .addNextBehavior(
/* 1108 */           CECombatBehaviors.Behavior.builder()
/* 1109 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1110 */           .withinDistance(0.0D, 3.0D)
/* 1111 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1112 */           .addNextBehavior(
/* 1113 */             CECombatBehaviors.Behavior.builder()
/* 1114 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1115 */             .withinDistance(0.0D, 4.0D)
/* 1116 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1117 */             .addNextBehavior(
/* 1118 */               CECombatBehaviors.Behavior.builder()
/* 1119 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1120 */               .withinDistance(0.0D, 4.0D)
/* 1121 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1122 */               .addNextBehavior(
/* 1123 */                 CECombatBehaviors.Behavior.builder()
/* 1124 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1125 */                 .withinDistance(0.0D, 5.0D)
/* 1126 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1127 */                 .addNextBehavior(
/* 1128 */                   CECombatBehaviors.Behavior.builder()
/* 1129 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1130 */                   .withinDistance(0.0D, 5.0D)
/* 1131 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1132 */                   .addNextBehavior(
/* 1133 */                     CECombatBehaviors.Behavior.builder()
/* 1134 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1135 */                     .withinDistance(0.0D, 5.0D)
/* 1136 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1145 */       .addFirstBehavior(
/* 1146 */         CECombatBehaviors.Behavior.builder()
/* 1147 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1148 */         .withinDistance(0.0D, 3.0D)
/* 1149 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1150 */         .addNextBehavior(
/* 1151 */           CECombatBehaviors.Behavior.builder()
/* 1152 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1153 */           .withinDistance(0.0D, 3.0D)
/* 1154 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1155 */           .addNextBehavior(
/* 1156 */             CECombatBehaviors.Behavior.builder()
/* 1157 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1158 */             .withinDistance(0.0D, 4.0D)
/* 1159 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1160 */             .addNextBehavior(
/* 1161 */               CECombatBehaviors.Behavior.builder()
/* 1162 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1163 */               .withinDistance(0.0D, 4.0D)
/* 1164 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1165 */               .addNextBehavior(
/* 1166 */                 CECombatBehaviors.Behavior.builder()
/* 1167 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1168 */                 .withinDistance(0.0D, 5.0D)
/* 1169 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1170 */                 .addNextBehavior(
/* 1171 */                   CECombatBehaviors.Behavior.builder()
/* 1172 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1173 */                   .withinDistance(0.0D, 5.0D)
/* 1174 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1175 */                   .addNextBehavior(
/* 1176 */                     CECombatBehaviors.Behavior.builder()
/* 1177 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1178 */                     .withinDistance(0.0D, 5.0D)
/* 1179 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1188 */       .addFirstBehavior(
/* 1189 */         CECombatBehaviors.Behavior.builder()
/* 1190 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1191 */         .withinDistance(0.0D, 3.0D)
/* 1192 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1193 */         .addNextBehavior(
/* 1194 */           CECombatBehaviors.Behavior.builder()
/* 1195 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1196 */           .withinDistance(0.0D, 3.0D)
/* 1197 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1198 */           .addNextBehavior(
/* 1199 */             CECombatBehaviors.Behavior.builder()
/* 1200 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1201 */             .withinDistance(0.0D, 4.0D)
/* 1202 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1203 */             .addNextBehavior(
/* 1204 */               CECombatBehaviors.Behavior.builder()
/* 1205 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1206 */               .withinDistance(0.0D, 4.0D)
/* 1207 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1208 */               .addNextBehavior(
/* 1209 */                 CECombatBehaviors.Behavior.builder()
/* 1210 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1211 */                 .withinDistance(0.0D, 5.0D)
/* 1212 */                 .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1213 */                 .addNextBehavior(
/* 1214 */                   CECombatBehaviors.Behavior.builder()
/* 1215 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1216 */                   .withinDistance(0.0D, 5.0D)
/* 1217 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1218 */                   .addNextBehavior(
/* 1219 */                     CECombatBehaviors.Behavior.builder()
/* 1220 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1221 */                     .withinDistance(0.0D, 5.0D)
/* 1222 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1231 */       .addFirstBehavior(
/* 1232 */         CECombatBehaviors.Behavior.builder()
/* 1233 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1234 */         .withinDistance(0.0D, 3.0D)
/* 1235 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1236 */         .addNextBehavior(
/* 1237 */           CECombatBehaviors.Behavior.builder()
/* 1238 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1239 */           .withinDistance(0.0D, 3.0D)
/* 1240 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1241 */           .addNextBehavior(
/* 1242 */             CECombatBehaviors.Behavior.builder()
/* 1243 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1244 */             .withinDistance(0.0D, 4.0D)
/* 1245 */             .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1246 */             .addNextBehavior(
/* 1247 */               CECombatBehaviors.Behavior.builder()
/* 1248 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1249 */               .withinDistance(0.0D, 4.0D)
/* 1250 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1251 */               .addNextBehavior(
/* 1252 */                 CECombatBehaviors.Behavior.builder()
/* 1253 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1254 */                 .withinDistance(0.0D, 5.0D)
/* 1255 */                 .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1256 */                 .addNextBehavior(
/* 1257 */                   CECombatBehaviors.Behavior.builder()
/* 1258 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1259 */                   .withinDistance(0.0D, 5.0D)
/* 1260 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1261 */                   .addNextBehavior(
/* 1262 */                     CECombatBehaviors.Behavior.builder()
/* 1263 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1264 */                     .withinDistance(0.0D, 5.0D)
/* 1265 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1274 */       .addFirstBehavior(
/* 1275 */         CECombatBehaviors.Behavior.builder()
/* 1276 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1277 */         .withinDistance(0.0D, 3.0D)
/* 1278 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1279 */         .addNextBehavior(
/* 1280 */           CECombatBehaviors.Behavior.builder()
/* 1281 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1282 */           .withinDistance(0.0D, 3.0D)
/* 1283 */           .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1284 */           .addNextBehavior(
/* 1285 */             CECombatBehaviors.Behavior.builder()
/* 1286 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1287 */             .withinDistance(0.0D, 4.0D)
/* 1288 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1289 */             .addNextBehavior(
/* 1290 */               CECombatBehaviors.Behavior.builder()
/* 1291 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1292 */               .withinDistance(0.0D, 4.0D)
/* 1293 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1294 */               .addNextBehavior(
/* 1295 */                 CECombatBehaviors.Behavior.builder()
/* 1296 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1297 */                 .withinDistance(0.0D, 5.0D)
/* 1298 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1299 */                 .addNextBehavior(
/* 1300 */                   CECombatBehaviors.Behavior.builder()
/* 1301 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1302 */                   .withinDistance(0.0D, 5.0D)
/* 1303 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1304 */                   .addNextBehavior(
/* 1305 */                     CECombatBehaviors.Behavior.builder()
/* 1306 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1307 */                     .withinDistance(0.0D, 5.0D)
/* 1308 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1317 */       .addFirstBehavior(
/* 1318 */         CECombatBehaviors.Behavior.builder()
/* 1319 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1320 */         .withinDistance(0.0D, 3.0D)
/* 1321 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1322 */         .addNextBehavior(
/* 1323 */           CECombatBehaviors.Behavior.builder()
/* 1324 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1325 */           .withinDistance(0.0D, 3.0D)
/* 1326 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1327 */           .addNextBehavior(
/* 1328 */             CECombatBehaviors.Behavior.builder()
/* 1329 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1330 */             .withinDistance(0.0D, 4.0D)
/* 1331 */             .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1332 */             .addNextBehavior(
/* 1333 */               CECombatBehaviors.Behavior.builder()
/* 1334 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1335 */               .withinDistance(0.0D, 4.0D)
/* 1336 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1337 */               .addNextBehavior(
/* 1338 */                 CECombatBehaviors.Behavior.builder()
/* 1339 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1340 */                 .withinDistance(0.0D, 5.0D)
/* 1341 */                 .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1342 */                 .addNextBehavior(
/* 1343 */                   CECombatBehaviors.Behavior.builder()
/* 1344 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1345 */                   .withinDistance(0.0D, 5.0D)
/* 1346 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1347 */                   .addNextBehavior(
/* 1348 */                     CECombatBehaviors.Behavior.builder()
/* 1349 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1350 */                     .withinDistance(0.0D, 5.0D)
/* 1351 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1360 */       .addFirstBehavior(
/* 1361 */         CECombatBehaviors.Behavior.builder()
/* 1362 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1363 */         .withinDistance(0.0D, 3.0D)
/* 1364 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1365 */         .addNextBehavior(
/* 1366 */           CECombatBehaviors.Behavior.builder()
/* 1367 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1368 */           .withinDistance(0.0D, 3.0D)
/* 1369 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1370 */           .addNextBehavior(
/* 1371 */             CECombatBehaviors.Behavior.builder()
/* 1372 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1373 */             .withinDistance(0.0D, 4.0D)
/* 1374 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1375 */             .addNextBehavior(
/* 1376 */               CECombatBehaviors.Behavior.builder()
/* 1377 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1378 */               .withinDistance(0.0D, 4.0D)
/* 1379 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1380 */               .addNextBehavior(
/* 1381 */                 CECombatBehaviors.Behavior.builder()
/* 1382 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1383 */                 .withinDistance(0.0D, 5.0D)
/* 1384 */                 .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1385 */                 .addNextBehavior(
/* 1386 */                   CECombatBehaviors.Behavior.builder()
/* 1387 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1388 */                   .withinDistance(0.0D, 5.0D)
/* 1389 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1390 */                   .addNextBehavior(
/* 1391 */                     CECombatBehaviors.Behavior.builder()
/* 1392 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1393 */                     .withinDistance(0.0D, 5.0D)
/* 1394 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1403 */       .addFirstBehavior(
/* 1404 */         CECombatBehaviors.Behavior.builder()
/* 1405 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1406 */         .withinDistance(0.0D, 3.0D)
/* 1407 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1408 */         .addNextBehavior(
/* 1409 */           CECombatBehaviors.Behavior.builder()
/* 1410 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1411 */           .withinDistance(0.0D, 3.0D)
/* 1412 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1413 */           .addNextBehavior(
/* 1414 */             CECombatBehaviors.Behavior.builder()
/* 1415 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1416 */             .withinDistance(0.0D, 4.0D)
/* 1417 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1418 */             .addNextBehavior(
/* 1419 */               CECombatBehaviors.Behavior.builder()
/* 1420 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1421 */               .withinDistance(0.0D, 4.0D)
/* 1422 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1423 */               .addNextBehavior(
/* 1424 */                 CECombatBehaviors.Behavior.builder()
/* 1425 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1426 */                 .withinDistance(0.0D, 5.0D)
/* 1427 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1428 */                 .addNextBehavior(
/* 1429 */                   CECombatBehaviors.Behavior.builder()
/* 1430 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1431 */                   .withinDistance(0.0D, 5.0D)
/* 1432 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1440 */       .addFirstBehavior(
/* 1441 */         CECombatBehaviors.Behavior.builder()
/* 1442 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1443 */         .withinDistance(0.0D, 3.0D)
/* 1444 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1445 */         .addNextBehavior(
/* 1446 */           CECombatBehaviors.Behavior.builder()
/* 1447 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1448 */           .withinDistance(0.0D, 3.0D)
/* 1449 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1450 */           .addNextBehavior(
/* 1451 */             CECombatBehaviors.Behavior.builder()
/* 1452 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1453 */             .withinDistance(0.0D, 4.0D)
/* 1454 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1455 */             .addNextBehavior(
/* 1456 */               CECombatBehaviors.Behavior.builder()
/* 1457 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1458 */               .withinDistance(0.0D, 4.0D)
/* 1459 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1460 */               .addNextBehavior(
/* 1461 */                 CECombatBehaviors.Behavior.builder()
/* 1462 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1463 */                 .withinDistance(0.0D, 5.0D)
/* 1464 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1465 */                 .addNextBehavior(
/* 1466 */                   CECombatBehaviors.Behavior.builder()
/* 1467 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1468 */                   .withinDistance(0.0D, 5.0D)
/* 1469 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1470 */                   .addNextBehavior(
/* 1471 */                     CECombatBehaviors.Behavior.builder()
/* 1472 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1473 */                     .withinDistance(0.0D, 5.0D)
/* 1474 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1483 */       .addFirstBehavior(
/* 1484 */         CECombatBehaviors.Behavior.builder()
/* 1485 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1486 */         .withinDistance(0.0D, 3.0D)
/* 1487 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1488 */         .addNextBehavior(
/* 1489 */           CECombatBehaviors.Behavior.builder()
/* 1490 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1491 */           .withinDistance(0.0D, 3.0D)
/* 1492 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1493 */           .addNextBehavior(
/* 1494 */             CECombatBehaviors.Behavior.builder()
/* 1495 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1496 */             .withinDistance(0.0D, 4.0D)
/* 1497 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1498 */             .addNextBehavior(
/* 1499 */               CECombatBehaviors.Behavior.builder()
/* 1500 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1501 */               .withinDistance(0.0D, 4.0D)
/* 1502 */               .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1503 */               .addNextBehavior(
/* 1504 */                 CECombatBehaviors.Behavior.builder()
/* 1505 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1506 */                 .withinDistance(0.0D, 5.0D)
/* 1507 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1508 */                 .addNextBehavior(
/* 1509 */                   CECombatBehaviors.Behavior.builder()
/* 1510 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1511 */                   .withinDistance(0.0D, 5.0D)
/* 1512 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1513 */                   .addNextBehavior(
/* 1514 */                     CECombatBehaviors.Behavior.builder()
/* 1515 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1516 */                     .withinDistance(0.0D, 5.0D)
/* 1517 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1526 */       .addFirstBehavior(
/* 1527 */         CECombatBehaviors.Behavior.builder()
/* 1528 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1529 */         .withinDistance(0.0D, 3.0D)
/* 1530 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1531 */         .addNextBehavior(
/* 1532 */           CECombatBehaviors.Behavior.builder()
/* 1533 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1534 */           .withinDistance(0.0D, 3.0D)
/* 1535 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1536 */           .addNextBehavior(
/* 1537 */             CECombatBehaviors.Behavior.builder()
/* 1538 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1539 */             .withinDistance(0.0D, 4.0D)
/* 1540 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1541 */             .addNextBehavior(
/* 1542 */               CECombatBehaviors.Behavior.builder()
/* 1543 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1544 */               .withinDistance(0.0D, 4.0D)
/* 1545 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1546 */               .addNextBehavior(
/* 1547 */                 CECombatBehaviors.Behavior.builder()
/* 1548 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1549 */                 .withinDistance(0.0D, 5.0D)
/* 1550 */                 .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1551 */                 .addNextBehavior(
/* 1552 */                   CECombatBehaviors.Behavior.builder()
/* 1553 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1554 */                   .withinDistance(0.0D, 5.0D)
/* 1555 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1556 */                   .addNextBehavior(
/* 1557 */                     CECombatBehaviors.Behavior.builder()
/* 1558 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1559 */                     .withinDistance(0.0D, 5.0D)
/* 1560 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1569 */       .addFirstBehavior(
/* 1570 */         CECombatBehaviors.Behavior.builder()
/* 1571 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1572 */         .withinDistance(0.0D, 3.0D)
/* 1573 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1574 */         .addNextBehavior(
/* 1575 */           CECombatBehaviors.Behavior.builder()
/* 1576 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1577 */           .withinDistance(0.0D, 3.0D)
/* 1578 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1579 */           .addNextBehavior(
/* 1580 */             CECombatBehaviors.Behavior.builder()
/* 1581 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1582 */             .withinDistance(0.0D, 4.0D)
/* 1583 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1584 */             .addNextBehavior(
/* 1585 */               CECombatBehaviors.Behavior.builder()
/* 1586 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1587 */               .withinDistance(0.0D, 4.0D)
/* 1588 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1589 */               .addNextBehavior(
/* 1590 */                 CECombatBehaviors.Behavior.builder()
/* 1591 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1592 */                 .withinDistance(0.0D, 5.0D)
/* 1593 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1594 */                 .addNextBehavior(
/* 1595 */                   CECombatBehaviors.Behavior.builder()
/* 1596 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1597 */                   .withinDistance(0.0D, 5.0D)
/* 1598 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1599 */                   .addNextBehavior(
/* 1600 */                     CECombatBehaviors.Behavior.builder()
/* 1601 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1602 */                     .withinDistance(0.0D, 5.0D)
/* 1603 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1612 */     .newBehaviorRoot(
/* 1613 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1614 */       .priority(1.0D)
/* 1615 */       .weight(20.0D)
/* 1616 */       .maxCooldown(80)
/* 1617 */       .addFirstBehavior(
/* 1618 */         CECombatBehaviors.Behavior.builder()
/* 1619 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1620 */         .withinDistance(0.0D, 3.0D)
/* 1621 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1622 */         .addNextBehavior(
/* 1623 */           CECombatBehaviors.Behavior.builder()
/* 1624 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1625 */           .withinDistance(0.0D, 3.0D)
/* 1626 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1627 */           .addNextBehavior(
/* 1628 */             CECombatBehaviors.Behavior.builder()
/* 1629 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1630 */             .withinDistance(0.0D, 3.0D)
/* 1631 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1632 */             .addNextBehavior(
/* 1633 */               CECombatBehaviors.Behavior.builder()
/* 1634 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1635 */               .withinDistance(0.0D, 3.0D)
/* 1636 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1642 */     .newBehaviorRoot(
/* 1643 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1644 */       .priority(1.0D)
/* 1645 */       .weight(10.0D)
/* 1646 */       .maxCooldown(80)
/* 1647 */       .addFirstBehavior(
/* 1648 */         CECombatBehaviors.Behavior.builder()
/* 1649 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1650 */         .withinDistance(0.0D, 3.0D)
/* 1651 */         .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F))
/*      */       
/* 1653 */       .addFirstBehavior(
/* 1654 */         CECombatBehaviors.Behavior.builder()
/* 1655 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1656 */         .withinDistance(0.0D, 3.0D)
/* 1657 */         .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F))
/*      */       
/* 1659 */       .addFirstBehavior(
/* 1660 */         CECombatBehaviors.Behavior.builder()
/* 1661 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1662 */         .withinDistance(0.0D, 3.0D)
/* 1663 */         .animationBehavior(Animations.DANCING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 1666 */     .newBehaviorRoot(
/* 1667 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1668 */       .priority(1.0D)
/* 1669 */       .weight(10.0D)
/* 1670 */       .maxCooldown(80)
/* 1671 */       .addFirstBehavior(
/* 1672 */         CECombatBehaviors.Behavior.builder()
/* 1673 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1674 */         .withinDistance(0.0D, 3.0D)
/* 1675 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1676 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 1677 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1678 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1681 */     .newBehaviorRoot(
/* 1682 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1683 */       .priority(1.0D)
/* 1684 */       .weight(2.0D)
/* 1685 */       .maxCooldown(80)
/* 1686 */       .addFirstBehavior(
/* 1687 */         CECombatBehaviors.Behavior.builder()
/* 1688 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1689 */         .withinDistance(0.0D, 3.0D)
/* 1690 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1692 */       .addFirstBehavior(
/* 1693 */         CECombatBehaviors.Behavior.builder()
/* 1694 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1695 */         .withinDistance(0.0D, 3.0D)
/* 1696 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1698 */       .addFirstBehavior(
/* 1699 */         CECombatBehaviors.Behavior.builder()
/* 1700 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1701 */         .withinDistance(0.0D, 3.0D)
/* 1702 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1704 */       .addFirstBehavior(
/* 1705 */         CECombatBehaviors.Behavior.builder()
/* 1706 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1707 */         .withinDistance(0.0D, 3.0D)
/* 1708 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1710 */       .addFirstBehavior(
/* 1711 */         CECombatBehaviors.Behavior.builder()
/* 1712 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1713 */         .withinDistance(0.0D, 3.0D)
/* 1714 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1716 */       .addFirstBehavior(
/* 1717 */         CECombatBehaviors.Behavior.builder()
/* 1718 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1719 */         .withinDistance(0.0D, 3.0D)
/* 1720 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1722 */       .addFirstBehavior(
/* 1723 */         CECombatBehaviors.Behavior.builder()
/* 1724 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1725 */         .withinDistance(0.0D, 3.0D)
/* 1726 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1729 */     .newBehaviorRoot(
/* 1730 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1731 */       .priority(1.0D)
/* 1732 */       .weight(15.0D)
/* 1733 */       .addFirstBehavior(
/* 1734 */         CECombatBehaviors.Behavior.builder()
/* 1735 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1736 */         .withinDistance(0.5D, 3.0D)
/* 1737 */         .custom(CombatCommon::canPerformGuarding)
/* 1738 */         .guard(40)))
/*      */ 
/*      */     
/* 1741 */     .newBehaviorRoot(
/* 1742 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1743 */       .priority(1.0D)
/* 1744 */       .weight(10.0D)
/* 1745 */       .addFirstBehavior(
/* 1746 */         CECombatBehaviors.Behavior.builder()
/* 1747 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1748 */         .withinDistance(0.0D, 3.0D)
/* 1749 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1751 */       .addFirstBehavior(
/* 1752 */         CECombatBehaviors.Behavior.builder()
/* 1753 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1754 */         .withinDistance(0.0D, 3.0D)
/* 1755 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1757 */       .addFirstBehavior(
/* 1758 */         CECombatBehaviors.Behavior.builder()
/* 1759 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1760 */         .withinDistance(0.0D, 3.0D)
/* 1761 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1763 */       .addFirstBehavior(
/* 1764 */         CECombatBehaviors.Behavior.builder()
/* 1765 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1766 */         .withinDistance(0.0D, 3.0D)
/* 1767 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1770 */     .newBehaviorRoot(
/* 1771 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1772 */       .priority(1.0D)
/* 1773 */       .weight(40.0D)
/* 1774 */       .maxCooldown(160)
/* 1775 */       .addFirstBehavior(
/* 1776 */         CECombatBehaviors.Behavior.builder()
/* 1777 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1778 */         .custom(CombatCommon::canJump)
/* 1779 */         .withinDistance(5.0D, 14.0D)
/* 1780 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1781 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 1785 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_SWORD = CECombatBehaviors.builder()
/* 1786 */     .newBehaviorRoot(
/* 1787 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1788 */       .priority(4.0D)
/* 1789 */       .weight(1000.0D)
/* 1790 */       .maxCooldown(0)
/* 1791 */       .addFirstBehavior(
/* 1792 */         CECombatBehaviors.Behavior.builder()
/* 1793 */         .custom(CombatCommon::canExecute)
/* 1794 */         .withinDistance(0.0D, 5.0D)
/* 1795 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 1796 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 1799 */     .newBehaviorRoot(
/* 1800 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1801 */       .priority(3.0D)
/* 1802 */       .weight(1000.0D)
/* 1803 */       .maxCooldown(0)
/* 1804 */       .addFirstBehavior(
/* 1805 */         CECombatBehaviors.Behavior.builder()
/* 1806 */         .custom(CombatCommon::canEscape)
/* 1807 */         .withinDistance(0.0D, 8.0D)
/* 1808 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1809 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 1811 */       .addFirstBehavior(
/* 1812 */         CECombatBehaviors.Behavior.builder()
/* 1813 */         .custom(CombatCommon::canEscape)
/* 1814 */         .withinDistance(0.0D, 48.0D)
/* 1815 */         .guard(40)))
/*      */ 
/*      */     
/* 1818 */     .newBehaviorRoot(
/* 1819 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1820 */       .priority(2.0D)
/* 1821 */       .weight(70.0D)
/* 1822 */       .maxCooldown(0)
/* 1823 */       .addFirstBehavior(
/* 1824 */         CECombatBehaviors.Behavior.builder()
/* 1825 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 1826 */         .custom(CombatCommon::canPerformEating)
/* 1827 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1828 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 1831 */     .newBehaviorRoot(
/* 1832 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1833 */       .priority(2.0D)
/* 1834 */       .weight(100.0D)
/* 1835 */       .maxCooldown(120)
/* 1836 */       .addFirstBehavior(
/* 1837 */         CECombatBehaviors.Behavior.builder()
/* 1838 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1839 */         .custom(CombatCommon::canSwapToBow)
/* 1840 */         .withinDistance(7.0D, 14.0D)
/* 1841 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1842 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 1844 */       .addFirstBehavior(
/* 1845 */         CECombatBehaviors.Behavior.builder()
/* 1846 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1847 */         .custom(CombatCommon::canSwapToBow)
/* 1848 */         .withinDistance(7.0D, 14.0D)
/* 1849 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1850 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 1852 */       .addFirstBehavior(
/* 1853 */         CECombatBehaviors.Behavior.builder()
/* 1854 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1855 */         .custom(CombatCommon::canSwapToBow)
/* 1856 */         .withinDistance(7.0D, 14.0D)
/* 1857 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1858 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 1860 */       .addFirstBehavior(
/* 1861 */         CECombatBehaviors.Behavior.builder()
/* 1862 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1863 */         .custom(CombatCommon::canSwapToBow)
/* 1864 */         .withinDistance(7.0D, 14.0D)
/* 1865 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 1866 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 1869 */     .newBehaviorRoot(
/* 1870 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1871 */       .priority(2.0D)
/* 1872 */       .weight(80.0D)
/* 1873 */       .maxCooldown(120)
/* 1874 */       .addFirstBehavior(
/* 1875 */         CECombatBehaviors.Behavior.builder()
/* 1876 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1877 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1878 */         .withinDistance(7.0D, 48.0D)
/* 1879 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1880 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 1883 */     .newBehaviorRoot(
/* 1884 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1885 */       .priority(1.0D)
/* 1886 */       .weight(40.0D)
/* 1887 */       .maxCooldown(20)
/* 1888 */       .addFirstBehavior(
/* 1889 */         CECombatBehaviors.Behavior.builder()
/* 1890 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1891 */         .withinDistance(0.0D, 3.0D)
/* 1892 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1893 */         .addNextBehavior(
/* 1894 */           CECombatBehaviors.Behavior.builder()
/* 1895 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1896 */           .withinDistance(0.0D, 3.0D)
/* 1897 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1898 */           .addNextBehavior(
/* 1899 */             CECombatBehaviors.Behavior.builder()
/* 1900 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1901 */             .withinDistance(0.0D, 3.0D)
/* 1902 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 1903 */             .addNextBehavior(
/* 1904 */               CECombatBehaviors.Behavior.builder()
/* 1905 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1906 */               .withinDistance(0.0D, 3.0D)
/* 1907 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F).addNextBehavior(
/* 1908 */                 CECombatBehaviors.Behavior.builder()
/* 1909 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1910 */                 .withinDistance(0.0D, 3.0D)
/* 1911 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1917 */       .addFirstBehavior(
/* 1918 */         CECombatBehaviors.Behavior.builder()
/* 1919 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1920 */         .withinDistance(0.0D, 3.0D)
/* 1921 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1922 */         .addNextBehavior(
/* 1923 */           CECombatBehaviors.Behavior.builder()
/* 1924 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1925 */           .withinDistance(0.0D, 3.0D)
/* 1926 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1927 */           .addNextBehavior(
/* 1928 */             CECombatBehaviors.Behavior.builder()
/* 1929 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1930 */             .withinDistance(0.0D, 4.0D)
/* 1931 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1932 */             .addNextBehavior(
/* 1933 */               CECombatBehaviors.Behavior.builder()
/* 1934 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1935 */               .withinDistance(0.0D, 4.0D)
/* 1936 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 1937 */               .addNextBehavior(
/* 1938 */                 CECombatBehaviors.Behavior.builder()
/* 1939 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1940 */                 .withinDistance(0.0D, 5.0D)
/* 1941 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1942 */                 .addNextBehavior(
/* 1943 */                   CECombatBehaviors.Behavior.builder()
/* 1944 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1945 */                   .withinDistance(0.0D, 5.0D)
/* 1946 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1954 */       .addFirstBehavior(
/* 1955 */         CECombatBehaviors.Behavior.builder()
/* 1956 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1957 */         .withinDistance(0.0D, 3.0D)
/* 1958 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1959 */         .addNextBehavior(
/* 1960 */           CECombatBehaviors.Behavior.builder()
/* 1961 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1962 */           .withinDistance(0.0D, 3.0D)
/* 1963 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 1964 */           .addNextBehavior(
/* 1965 */             CECombatBehaviors.Behavior.builder()
/* 1966 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1967 */             .withinDistance(0.0D, 4.0D)
/* 1968 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1969 */             .addNextBehavior(
/* 1970 */               CECombatBehaviors.Behavior.builder()
/* 1971 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1972 */               .withinDistance(0.0D, 4.0D)
/* 1973 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1974 */               .addNextBehavior(
/* 1975 */                 CECombatBehaviors.Behavior.builder()
/* 1976 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1977 */                 .withinDistance(0.0D, 5.0D)
/* 1978 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1979 */                 .addNextBehavior(
/* 1980 */                   CECombatBehaviors.Behavior.builder()
/* 1981 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1982 */                   .withinDistance(0.0D, 5.0D)
/* 1983 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1991 */       .addFirstBehavior(
/* 1992 */         CECombatBehaviors.Behavior.builder()
/* 1993 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1994 */         .withinDistance(0.0D, 3.0D)
/* 1995 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1996 */         .addNextBehavior(
/* 1997 */           CECombatBehaviors.Behavior.builder()
/* 1998 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1999 */           .withinDistance(0.0D, 3.0D)
/* 2000 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2001 */           .addNextBehavior(
/* 2002 */             CECombatBehaviors.Behavior.builder()
/* 2003 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2004 */             .withinDistance(0.0D, 4.0D)
/* 2005 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2006 */             .addNextBehavior(
/* 2007 */               CECombatBehaviors.Behavior.builder()
/* 2008 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2009 */               .withinDistance(0.0D, 4.0D)
/* 2010 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2011 */               .addNextBehavior(
/* 2012 */                 CECombatBehaviors.Behavior.builder()
/* 2013 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2014 */                 .withinDistance(0.0D, 5.0D)
/* 2015 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2016 */                 .addNextBehavior(
/* 2017 */                   CECombatBehaviors.Behavior.builder()
/* 2018 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2019 */                   .withinDistance(0.0D, 5.0D)
/* 2020 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2021 */                   .addNextBehavior(
/* 2022 */                     CECombatBehaviors.Behavior.builder()
/* 2023 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2024 */                     .withinDistance(0.0D, 5.0D)
/* 2025 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2034 */       .addFirstBehavior(
/* 2035 */         CECombatBehaviors.Behavior.builder()
/* 2036 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2037 */         .withinDistance(0.0D, 3.0D)
/* 2038 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2039 */         .addNextBehavior(
/* 2040 */           CECombatBehaviors.Behavior.builder()
/* 2041 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2042 */           .withinDistance(0.0D, 3.0D)
/* 2043 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2044 */           .addNextBehavior(
/* 2045 */             CECombatBehaviors.Behavior.builder()
/* 2046 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2047 */             .withinDistance(0.0D, 4.0D)
/* 2048 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 2049 */             .addNextBehavior(
/* 2050 */               CECombatBehaviors.Behavior.builder()
/* 2051 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2052 */               .withinDistance(0.0D, 4.0D)
/* 2053 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2054 */               .addNextBehavior(
/* 2055 */                 CECombatBehaviors.Behavior.builder()
/* 2056 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2057 */                 .withinDistance(0.0D, 5.0D)
/* 2058 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2059 */                 .addNextBehavior(
/* 2060 */                   CECombatBehaviors.Behavior.builder()
/* 2061 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2062 */                   .withinDistance(0.0D, 5.0D)
/* 2063 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2071 */       .addFirstBehavior(
/* 2072 */         CECombatBehaviors.Behavior.builder()
/* 2073 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2074 */         .withinDistance(0.0D, 3.0D)
/* 2075 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2076 */         .addNextBehavior(
/* 2077 */           CECombatBehaviors.Behavior.builder()
/* 2078 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2079 */           .withinDistance(0.0D, 3.0D)
/* 2080 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2081 */           .addNextBehavior(
/* 2082 */             CECombatBehaviors.Behavior.builder()
/* 2083 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2084 */             .withinDistance(0.0D, 4.0D)
/* 2085 */             .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 2086 */             .addNextBehavior(
/* 2087 */               CECombatBehaviors.Behavior.builder()
/* 2088 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2089 */               .withinDistance(0.0D, 4.0D)
/* 2090 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2091 */               .addNextBehavior(
/* 2092 */                 CECombatBehaviors.Behavior.builder()
/* 2093 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2094 */                 .withinDistance(0.0D, 5.0D)
/* 2095 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 2096 */                 .addNextBehavior(
/* 2097 */                   CECombatBehaviors.Behavior.builder()
/* 2098 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2099 */                   .withinDistance(0.0D, 5.0D)
/* 2100 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2108 */       .addFirstBehavior(
/* 2109 */         CECombatBehaviors.Behavior.builder()
/* 2110 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2111 */         .withinDistance(0.0D, 3.0D)
/* 2112 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2113 */         .addNextBehavior(
/* 2114 */           CECombatBehaviors.Behavior.builder()
/* 2115 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2116 */           .withinDistance(0.0D, 3.0D)
/* 2117 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2118 */           .addNextBehavior(
/* 2119 */             CECombatBehaviors.Behavior.builder()
/* 2120 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2121 */             .withinDistance(0.0D, 4.0D)
/* 2122 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2123 */             .addNextBehavior(
/* 2124 */               CECombatBehaviors.Behavior.builder()
/* 2125 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2126 */               .withinDistance(0.0D, 4.0D)
/* 2127 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 2128 */               .addNextBehavior(
/* 2129 */                 CECombatBehaviors.Behavior.builder()
/* 2130 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2131 */                 .withinDistance(0.0D, 5.0D)
/* 2132 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2133 */                 .addNextBehavior(
/* 2134 */                   CECombatBehaviors.Behavior.builder()
/* 2135 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2136 */                   .withinDistance(0.0D, 5.0D)
/* 2137 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2145 */       .addFirstBehavior(
/* 2146 */         CECombatBehaviors.Behavior.builder()
/* 2147 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2148 */         .withinDistance(0.0D, 3.0D)
/* 2149 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2150 */         .addNextBehavior(
/* 2151 */           CECombatBehaviors.Behavior.builder()
/* 2152 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2153 */           .withinDistance(0.0D, 3.0D)
/* 2154 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2155 */           .addNextBehavior(
/* 2156 */             CECombatBehaviors.Behavior.builder()
/* 2157 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2158 */             .withinDistance(0.0D, 4.0D)
/* 2159 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2160 */             .addNextBehavior(
/* 2161 */               CECombatBehaviors.Behavior.builder()
/* 2162 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2163 */               .withinDistance(0.0D, 4.0D)
/* 2164 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2165 */               .addNextBehavior(
/* 2166 */                 CECombatBehaviors.Behavior.builder()
/* 2167 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2168 */                 .withinDistance(0.0D, 5.0D)
/* 2169 */                 .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 2170 */                 .addNextBehavior(
/* 2171 */                   CECombatBehaviors.Behavior.builder()
/* 2172 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2173 */                   .withinDistance(0.0D, 5.0D)
/* 2174 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2182 */       .addFirstBehavior(
/* 2183 */         CECombatBehaviors.Behavior.builder()
/* 2184 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2185 */         .withinDistance(0.0D, 3.0D)
/* 2186 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2187 */         .addNextBehavior(
/* 2188 */           CECombatBehaviors.Behavior.builder()
/* 2189 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2190 */           .withinDistance(0.0D, 3.0D)
/* 2191 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2192 */           .addNextBehavior(
/* 2193 */             CECombatBehaviors.Behavior.builder()
/* 2194 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2195 */             .withinDistance(0.0D, 4.0D)
/* 2196 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2197 */             .addNextBehavior(
/* 2198 */               CECombatBehaviors.Behavior.builder()
/* 2199 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2200 */               .withinDistance(0.0D, 4.0D)
/* 2201 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2202 */               .addNextBehavior(
/* 2203 */                 CECombatBehaviors.Behavior.builder()
/* 2204 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2205 */                 .withinDistance(0.0D, 5.0D)
/* 2206 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2207 */                 .addNextBehavior(
/* 2208 */                   CECombatBehaviors.Behavior.builder()
/* 2209 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2210 */                   .withinDistance(0.0D, 5.0D)
/* 2211 */                   .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2212 */                   .addNextBehavior(
/* 2213 */                     CECombatBehaviors.Behavior.builder()
/* 2214 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2215 */                     .withinDistance(0.0D, 5.0D)
/* 2216 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2225 */       .addFirstBehavior(
/* 2226 */         CECombatBehaviors.Behavior.builder()
/* 2227 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2228 */         .withinDistance(0.0D, 3.0D)
/* 2229 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2230 */         .addNextBehavior(
/* 2231 */           CECombatBehaviors.Behavior.builder()
/* 2232 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2233 */           .withinDistance(0.0D, 3.0D)
/* 2234 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2235 */           .addNextBehavior(
/* 2236 */             CECombatBehaviors.Behavior.builder()
/* 2237 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2238 */             .withinDistance(0.0D, 4.0D)
/* 2239 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2240 */             .addNextBehavior(
/* 2241 */               CECombatBehaviors.Behavior.builder()
/* 2242 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2243 */               .withinDistance(0.0D, 4.0D)
/* 2244 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 2245 */               .addNextBehavior(
/* 2246 */                 CECombatBehaviors.Behavior.builder()
/* 2247 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2248 */                 .withinDistance(0.0D, 5.0D)
/* 2249 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2250 */                 .addNextBehavior(
/* 2251 */                   CECombatBehaviors.Behavior.builder()
/* 2252 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2253 */                   .withinDistance(0.0D, 5.0D)
/* 2254 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2255 */                   .addNextBehavior(
/* 2256 */                     CECombatBehaviors.Behavior.builder()
/* 2257 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2258 */                     .withinDistance(0.0D, 5.0D)
/* 2259 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2268 */       .addFirstBehavior(
/* 2269 */         CECombatBehaviors.Behavior.builder()
/* 2270 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2271 */         .withinDistance(0.0D, 3.0D)
/* 2272 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2273 */         .addNextBehavior(
/* 2274 */           CECombatBehaviors.Behavior.builder()
/* 2275 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2276 */           .withinDistance(0.0D, 3.0D)
/* 2277 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2278 */           .addNextBehavior(
/* 2279 */             CECombatBehaviors.Behavior.builder()
/* 2280 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2281 */             .withinDistance(0.0D, 4.0D)
/* 2282 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2283 */             .addNextBehavior(
/* 2284 */               CECombatBehaviors.Behavior.builder()
/* 2285 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2286 */               .withinDistance(0.0D, 4.0D)
/* 2287 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 2288 */               .addNextBehavior(
/* 2289 */                 CECombatBehaviors.Behavior.builder()
/* 2290 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2291 */                 .withinDistance(0.0D, 5.0D)
/* 2292 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2293 */                 .addNextBehavior(
/* 2294 */                   CECombatBehaviors.Behavior.builder()
/* 2295 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2296 */                   .withinDistance(0.0D, 5.0D)
/* 2297 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2305 */       .addFirstBehavior(
/* 2306 */         CECombatBehaviors.Behavior.builder()
/* 2307 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2308 */         .withinDistance(0.0D, 3.0D)
/* 2309 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2310 */         .addNextBehavior(
/* 2311 */           CECombatBehaviors.Behavior.builder()
/* 2312 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2313 */           .withinDistance(0.0D, 3.0D)
/* 2314 */           .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2315 */           .addNextBehavior(
/* 2316 */             CECombatBehaviors.Behavior.builder()
/* 2317 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2318 */             .withinDistance(0.0D, 4.0D)
/* 2319 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2320 */             .addNextBehavior(
/* 2321 */               CECombatBehaviors.Behavior.builder()
/* 2322 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2323 */               .withinDistance(0.0D, 4.0D)
/* 2324 */               .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 2325 */               .addNextBehavior(
/* 2326 */                 CECombatBehaviors.Behavior.builder()
/* 2327 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2328 */                 .withinDistance(0.0D, 5.0D)
/* 2329 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2330 */                 .addNextBehavior(
/* 2331 */                   CECombatBehaviors.Behavior.builder()
/* 2332 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2333 */                   .withinDistance(0.0D, 5.0D)
/* 2334 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2342 */       .addFirstBehavior(
/* 2343 */         CECombatBehaviors.Behavior.builder()
/* 2344 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2345 */         .withinDistance(0.0D, 3.0D)
/* 2346 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2347 */         .addNextBehavior(
/* 2348 */           CECombatBehaviors.Behavior.builder()
/* 2349 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2350 */           .withinDistance(0.0D, 3.0D)
/* 2351 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2352 */           .addNextBehavior(
/* 2353 */             CECombatBehaviors.Behavior.builder()
/* 2354 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2355 */             .withinDistance(0.0D, 4.0D)
/* 2356 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2357 */             .addNextBehavior(
/* 2358 */               CECombatBehaviors.Behavior.builder()
/* 2359 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2360 */               .withinDistance(0.0D, 4.0D)
/* 2361 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2362 */               .addNextBehavior(
/* 2363 */                 CECombatBehaviors.Behavior.builder()
/* 2364 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2365 */                 .withinDistance(0.0D, 5.0D)
/* 2366 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2367 */                 .addNextBehavior(
/* 2368 */                   CECombatBehaviors.Behavior.builder()
/* 2369 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2370 */                   .withinDistance(0.0D, 5.0D)
/* 2371 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 2372 */                   .addNextBehavior(
/* 2373 */                     CECombatBehaviors.Behavior.builder()
/* 2374 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2375 */                     .withinDistance(0.0D, 5.0D)
/* 2376 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2385 */       .addFirstBehavior(
/* 2386 */         CECombatBehaviors.Behavior.builder()
/* 2387 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2388 */         .withinDistance(0.0D, 3.0D)
/* 2389 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2390 */         .addNextBehavior(
/* 2391 */           CECombatBehaviors.Behavior.builder()
/* 2392 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2393 */           .withinDistance(0.0D, 3.0D)
/* 2394 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2395 */           .addNextBehavior(
/* 2396 */             CECombatBehaviors.Behavior.builder()
/* 2397 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2398 */             .withinDistance(0.0D, 4.0D)
/* 2399 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 2400 */             .addNextBehavior(
/* 2401 */               CECombatBehaviors.Behavior.builder()
/* 2402 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2403 */               .withinDistance(0.0D, 4.0D)
/* 2404 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2405 */               .addNextBehavior(
/* 2406 */                 CECombatBehaviors.Behavior.builder()
/* 2407 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2408 */                 .withinDistance(0.0D, 5.0D)
/* 2409 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2410 */                 .addNextBehavior(
/* 2411 */                   CECombatBehaviors.Behavior.builder()
/* 2412 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2413 */                   .withinDistance(0.0D, 5.0D)
/* 2414 */                   .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2415 */                   .addNextBehavior(
/* 2416 */                     CECombatBehaviors.Behavior.builder()
/* 2417 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2418 */                     .withinDistance(0.0D, 5.0D)
/* 2419 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2428 */       .addFirstBehavior(
/* 2429 */         CECombatBehaviors.Behavior.builder()
/* 2430 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2431 */         .withinDistance(0.0D, 3.0D)
/* 2432 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2433 */         .addNextBehavior(
/* 2434 */           CECombatBehaviors.Behavior.builder()
/* 2435 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2436 */           .withinDistance(0.0D, 3.0D)
/* 2437 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 2438 */           .addNextBehavior(
/* 2439 */             CECombatBehaviors.Behavior.builder()
/* 2440 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2441 */             .withinDistance(0.0D, 4.0D)
/* 2442 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2443 */             .addNextBehavior(
/* 2444 */               CECombatBehaviors.Behavior.builder()
/* 2445 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2446 */               .withinDistance(0.0D, 4.0D)
/* 2447 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2448 */               .addNextBehavior(
/* 2449 */                 CECombatBehaviors.Behavior.builder()
/* 2450 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2451 */                 .withinDistance(0.0D, 5.0D)
/* 2452 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2453 */                 .addNextBehavior(
/* 2454 */                   CECombatBehaviors.Behavior.builder()
/* 2455 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2456 */                   .withinDistance(0.0D, 5.0D)
/* 2457 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2458 */                   .addNextBehavior(
/* 2459 */                     CECombatBehaviors.Behavior.builder()
/* 2460 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2461 */                     .withinDistance(0.0D, 5.0D)
/* 2462 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2471 */       .addFirstBehavior(
/* 2472 */         CECombatBehaviors.Behavior.builder()
/* 2473 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2474 */         .withinDistance(0.0D, 3.0D)
/* 2475 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2476 */         .addNextBehavior(
/* 2477 */           CECombatBehaviors.Behavior.builder()
/* 2478 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2479 */           .withinDistance(0.0D, 3.0D)
/* 2480 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2481 */           .addNextBehavior(
/* 2482 */             CECombatBehaviors.Behavior.builder()
/* 2483 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2484 */             .withinDistance(0.0D, 4.0D)
/* 2485 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2486 */             .addNextBehavior(
/* 2487 */               CECombatBehaviors.Behavior.builder()
/* 2488 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2489 */               .withinDistance(0.0D, 4.0D)
/* 2490 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2491 */               .addNextBehavior(
/* 2492 */                 CECombatBehaviors.Behavior.builder()
/* 2493 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2494 */                 .withinDistance(0.0D, 5.0D)
/* 2495 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 2496 */                 .addNextBehavior(
/* 2497 */                   CECombatBehaviors.Behavior.builder()
/* 2498 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2499 */                   .withinDistance(0.0D, 5.0D)
/* 2500 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2501 */                   .addNextBehavior(
/* 2502 */                     CECombatBehaviors.Behavior.builder()
/* 2503 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2504 */                     .withinDistance(0.0D, 5.0D)
/* 2505 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2514 */     .newBehaviorRoot(
/* 2515 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2516 */       .priority(1.0D)
/* 2517 */       .weight(20.0D)
/* 2518 */       .maxCooldown(80)
/* 2519 */       .addFirstBehavior(
/* 2520 */         CECombatBehaviors.Behavior.builder()
/* 2521 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2522 */         .withinDistance(0.0D, 3.0D)
/* 2523 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2524 */         .addNextBehavior(
/* 2525 */           CECombatBehaviors.Behavior.builder()
/* 2526 */           .withinDistance(0.0D, 3.0D)
/* 2527 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2528 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2529 */           .addNextBehavior(
/* 2530 */             CECombatBehaviors.Behavior.builder()
/* 2531 */             .withinDistance(0.0D, 3.0D)
/* 2532 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2533 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2538 */     .newBehaviorRoot(
/* 2539 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2540 */       .priority(1.0D)
/* 2541 */       .weight(10.0D)
/* 2542 */       .maxCooldown(80)
/* 2543 */       .addFirstBehavior(
/* 2544 */         CECombatBehaviors.Behavior.builder()
/* 2545 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2546 */         .withinDistance(0.0D, 3.0D)
/* 2547 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*      */       
/* 2549 */       .addFirstBehavior(
/* 2550 */         CECombatBehaviors.Behavior.builder()
/* 2551 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2552 */         .withinDistance(0.0D, 3.0D)
/* 2553 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*      */       
/* 2555 */       .addFirstBehavior(
/* 2556 */         CECombatBehaviors.Behavior.builder()
/* 2557 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2558 */         .withinDistance(0.0D, 3.0D)
/* 2559 */         .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 2562 */     .newBehaviorRoot(
/* 2563 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2564 */       .priority(1.0D)
/* 2565 */       .weight(10.0D)
/* 2566 */       .maxCooldown(40)
/* 2567 */       .addFirstBehavior(
/* 2568 */         CECombatBehaviors.Behavior.builder()
/* 2569 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2570 */         .withinDistance(0.0D, 3.0D)
/* 2571 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2572 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 2573 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2574 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 2577 */     .newBehaviorRoot(
/* 2578 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2579 */       .priority(1.0D)
/* 2580 */       .weight(2.0D)
/* 2581 */       .maxCooldown(80)
/* 2582 */       .addFirstBehavior(
/* 2583 */         CECombatBehaviors.Behavior.builder()
/* 2584 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2585 */         .withinDistance(0.0D, 3.0D)
/* 2586 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 2588 */       .addFirstBehavior(
/* 2589 */         CECombatBehaviors.Behavior.builder()
/* 2590 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2591 */         .withinDistance(0.0D, 3.0D)
/* 2592 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 2594 */       .addFirstBehavior(
/* 2595 */         CECombatBehaviors.Behavior.builder()
/* 2596 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2597 */         .withinDistance(0.0D, 3.0D)
/* 2598 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 2600 */       .addFirstBehavior(
/* 2601 */         CECombatBehaviors.Behavior.builder()
/* 2602 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2603 */         .withinDistance(0.0D, 3.0D)
/* 2604 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 2606 */       .addFirstBehavior(
/* 2607 */         CECombatBehaviors.Behavior.builder()
/* 2608 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2609 */         .withinDistance(0.0D, 3.0D)
/* 2610 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 2612 */       .addFirstBehavior(
/* 2613 */         CECombatBehaviors.Behavior.builder()
/* 2614 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2615 */         .withinDistance(0.0D, 3.0D)
/* 2616 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 2618 */       .addFirstBehavior(
/* 2619 */         CECombatBehaviors.Behavior.builder()
/* 2620 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2621 */         .withinDistance(0.0D, 3.0D)
/* 2622 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 2625 */     .newBehaviorRoot(
/* 2626 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2627 */       .priority(1.0D)
/* 2628 */       .weight(15.0D)
/* 2629 */       .addFirstBehavior(
/* 2630 */         CECombatBehaviors.Behavior.builder()
/* 2631 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2632 */         .withinDistance(0.0D, 3.0D)
/* 2633 */         .custom(CombatCommon::canPerformGuarding)
/* 2634 */         .guard(40)))
/*      */ 
/*      */     
/* 2637 */     .newBehaviorRoot(
/* 2638 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2639 */       .priority(1.0D)
/* 2640 */       .weight(10.0D)
/* 2641 */       .addFirstBehavior(
/* 2642 */         CECombatBehaviors.Behavior.builder()
/* 2643 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2644 */         .withinDistance(0.0D, 3.0D)
/* 2645 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 2647 */       .addFirstBehavior(
/* 2648 */         CECombatBehaviors.Behavior.builder()
/* 2649 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2650 */         .withinDistance(0.0D, 3.0D)
/* 2651 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 2653 */       .addFirstBehavior(
/* 2654 */         CECombatBehaviors.Behavior.builder()
/* 2655 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2656 */         .withinDistance(0.0D, 3.0D)
/* 2657 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 2659 */       .addFirstBehavior(
/* 2660 */         CECombatBehaviors.Behavior.builder()
/* 2661 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2662 */         .withinDistance(0.0D, 3.0D)
/* 2663 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 2666 */     .newBehaviorRoot(
/* 2667 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2668 */       .priority(1.0D)
/* 2669 */       .weight(40.0D)
/* 2670 */       .maxCooldown(160)
/* 2671 */       .addFirstBehavior(
/* 2672 */         CECombatBehaviors.Behavior.builder()
/* 2673 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2674 */         .custom(CombatCommon::canJump)
/* 2675 */         .withinDistance(5.0D, 14.0D)
/* 2676 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2677 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 2681 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_DUAL_SWORD = CECombatBehaviors.builder()
/* 2682 */     .newBehaviorRoot(
/* 2683 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2684 */       .priority(4.0D)
/* 2685 */       .weight(1000.0D)
/* 2686 */       .maxCooldown(0)
/* 2687 */       .addFirstBehavior(
/* 2688 */         CECombatBehaviors.Behavior.builder()
/* 2689 */         .custom(CombatCommon::canExecute)
/* 2690 */         .withinDistance(0.0D, 5.0D)
/* 2691 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 2692 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 2695 */     .newBehaviorRoot(
/* 2696 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2697 */       .priority(3.0D)
/* 2698 */       .weight(1000.0D)
/* 2699 */       .maxCooldown(0)
/* 2700 */       .addFirstBehavior(
/* 2701 */         CECombatBehaviors.Behavior.builder()
/* 2702 */         .custom(CombatCommon::canEscape)
/* 2703 */         .withinDistance(0.0D, 8.0D)
/* 2704 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 2705 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 2707 */       .addFirstBehavior(
/* 2708 */         CECombatBehaviors.Behavior.builder()
/* 2709 */         .custom(CombatCommon::canEscape)
/* 2710 */         .withinDistance(0.0D, 48.0D)
/* 2711 */         .guard(40)))
/*      */ 
/*      */     
/* 2714 */     .newBehaviorRoot(
/* 2715 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2716 */       .priority(2.0D)
/* 2717 */       .weight(70.0D)
/* 2718 */       .maxCooldown(0)
/* 2719 */       .addFirstBehavior(
/* 2720 */         CECombatBehaviors.Behavior.builder()
/* 2721 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 2722 */         .custom(CombatCommon::canPerformEating)
/* 2723 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 2724 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 2727 */     .newBehaviorRoot(
/* 2728 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2729 */       .priority(2.0D)
/* 2730 */       .weight(100.0D)
/* 2731 */       .maxCooldown(120)
/* 2732 */       .addFirstBehavior(
/* 2733 */         CECombatBehaviors.Behavior.builder()
/* 2734 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2735 */         .custom(CombatCommon::canSwapToBow)
/* 2736 */         .withinDistance(7.0D, 14.0D)
/* 2737 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 2738 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 2740 */       .addFirstBehavior(
/* 2741 */         CECombatBehaviors.Behavior.builder()
/* 2742 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2743 */         .custom(CombatCommon::canSwapToBow)
/* 2744 */         .withinDistance(7.0D, 14.0D)
/* 2745 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 2746 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 2748 */       .addFirstBehavior(
/* 2749 */         CECombatBehaviors.Behavior.builder()
/* 2750 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2751 */         .custom(CombatCommon::canSwapToBow)
/* 2752 */         .withinDistance(7.0D, 14.0D)
/* 2753 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 2754 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 2756 */       .addFirstBehavior(
/* 2757 */         CECombatBehaviors.Behavior.builder()
/* 2758 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2759 */         .custom(CombatCommon::canSwapToBow)
/* 2760 */         .withinDistance(7.0D, 14.0D)
/* 2761 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 2762 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 2765 */     .newBehaviorRoot(
/* 2766 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2767 */       .priority(2.0D)
/* 2768 */       .weight(80.0D)
/* 2769 */       .maxCooldown(120)
/* 2770 */       .addFirstBehavior(
/* 2771 */         CECombatBehaviors.Behavior.builder()
/* 2772 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2773 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2774 */         .withinDistance(7.0D, 48.0D)
/* 2775 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2776 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 2779 */     .newBehaviorRoot(
/* 2780 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2781 */       .priority(1.0D)
/* 2782 */       .weight(40.0D)
/* 2783 */       .maxCooldown(20)
/* 2784 */       .addFirstBehavior(
/* 2785 */         CECombatBehaviors.Behavior.builder()
/* 2786 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2787 */         .withinDistance(0.0D, 3.0D)
/* 2788 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2789 */         .addNextBehavior(
/* 2790 */           CECombatBehaviors.Behavior.builder()
/* 2791 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2792 */           .withinDistance(0.0D, 3.0D)
/* 2793 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2794 */           .addNextBehavior(
/* 2795 */             CECombatBehaviors.Behavior.builder()
/* 2796 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2797 */             .withinDistance(0.0D, 3.0D)
/* 2798 */             .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 2799 */             .addNextBehavior(
/* 2800 */               CECombatBehaviors.Behavior.builder()
/* 2801 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2802 */               .withinDistance(0.0D, 3.0D)
/* 2803 */               .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F).addNextBehavior(
/* 2804 */                 CECombatBehaviors.Behavior.builder()
/* 2805 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2806 */                 .withinDistance(0.0D, 3.0D)
/* 2807 */                 .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 2808 */                 .addNextBehavior(
/* 2809 */                   CECombatBehaviors.Behavior.builder()
/* 2810 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2811 */                   .withinDistance(0.0D, 3.0D)
/* 2812 */                   .animationBehavior(AVAnimations.DUAL_SWORD3, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2819 */       .addFirstBehavior(
/* 2820 */         CECombatBehaviors.Behavior.builder()
/* 2821 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2822 */         .withinDistance(0.0D, 3.0D)
/* 2823 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2824 */         .addNextBehavior(
/* 2825 */           CECombatBehaviors.Behavior.builder()
/* 2826 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2827 */           .withinDistance(0.0D, 3.0D)
/* 2828 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2829 */           .addNextBehavior(
/* 2830 */             CECombatBehaviors.Behavior.builder()
/* 2831 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2832 */             .withinDistance(0.0D, 4.0D)
/* 2833 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2834 */             .addNextBehavior(
/* 2835 */               CECombatBehaviors.Behavior.builder()
/* 2836 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2837 */               .withinDistance(0.0D, 4.0D)
/* 2838 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2839 */               .addNextBehavior(
/* 2840 */                 CECombatBehaviors.Behavior.builder()
/* 2841 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2842 */                 .withinDistance(0.0D, 5.0D)
/* 2843 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2850 */       .addFirstBehavior(
/* 2851 */         CECombatBehaviors.Behavior.builder()
/* 2852 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2853 */         .withinDistance(0.0D, 3.0D)
/* 2854 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2855 */         .addNextBehavior(
/* 2856 */           CECombatBehaviors.Behavior.builder()
/* 2857 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2858 */           .withinDistance(0.0D, 3.0D)
/* 2859 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2860 */           .addNextBehavior(
/* 2861 */             CECombatBehaviors.Behavior.builder()
/* 2862 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2863 */             .withinDistance(0.0D, 4.0D)
/* 2864 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2865 */             .addNextBehavior(
/* 2866 */               CECombatBehaviors.Behavior.builder()
/* 2867 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2868 */               .withinDistance(0.0D, 4.0D)
/* 2869 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2870 */               .addNextBehavior(
/* 2871 */                 CECombatBehaviors.Behavior.builder()
/* 2872 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2873 */                 .withinDistance(0.0D, 5.0D)
/* 2874 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2875 */                 .addNextBehavior(
/* 2876 */                   CECombatBehaviors.Behavior.builder()
/* 2877 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2878 */                   .withinDistance(0.0D, 5.0D)
/* 2879 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2887 */       .addFirstBehavior(
/* 2888 */         CECombatBehaviors.Behavior.builder()
/* 2889 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2890 */         .withinDistance(0.0D, 3.0D)
/* 2891 */         .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2892 */         .addNextBehavior(
/* 2893 */           CECombatBehaviors.Behavior.builder()
/* 2894 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2895 */           .withinDistance(0.0D, 3.0D)
/* 2896 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2897 */           .addNextBehavior(
/* 2898 */             CECombatBehaviors.Behavior.builder()
/* 2899 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2900 */             .withinDistance(0.0D, 4.0D)
/* 2901 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2902 */             .addNextBehavior(
/* 2903 */               CECombatBehaviors.Behavior.builder()
/* 2904 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2905 */               .withinDistance(0.0D, 4.0D)
/* 2906 */               .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 2907 */               .addNextBehavior(
/* 2908 */                 CECombatBehaviors.Behavior.builder()
/* 2909 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2910 */                 .withinDistance(0.0D, 5.0D)
/* 2911 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2912 */                 .addNextBehavior(
/* 2913 */                   CECombatBehaviors.Behavior.builder()
/* 2914 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2915 */                   .withinDistance(0.0D, 5.0D)
/* 2916 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2924 */       .addFirstBehavior(
/* 2925 */         CECombatBehaviors.Behavior.builder()
/* 2926 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2927 */         .withinDistance(0.0D, 3.0D)
/* 2928 */         .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 2929 */         .addNextBehavior(
/* 2930 */           CECombatBehaviors.Behavior.builder()
/* 2931 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2932 */           .withinDistance(0.0D, 3.0D)
/* 2933 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2934 */           .addNextBehavior(
/* 2935 */             CECombatBehaviors.Behavior.builder()
/* 2936 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2937 */             .withinDistance(0.0D, 4.0D)
/* 2938 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2939 */             .addNextBehavior(
/* 2940 */               CECombatBehaviors.Behavior.builder()
/* 2941 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2942 */               .withinDistance(0.0D, 4.0D)
/* 2943 */               .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 2944 */               .addNextBehavior(
/* 2945 */                 CECombatBehaviors.Behavior.builder()
/* 2946 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2947 */                 .withinDistance(0.0D, 5.0D)
/* 2948 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 2949 */                 .addNextBehavior(
/* 2950 */                   CECombatBehaviors.Behavior.builder()
/* 2951 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2952 */                   .withinDistance(0.0D, 5.0D)
/* 2953 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2961 */       .addFirstBehavior(
/* 2962 */         CECombatBehaviors.Behavior.builder()
/* 2963 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2964 */         .withinDistance(0.0D, 3.0D)
/* 2965 */         .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 2966 */         .addNextBehavior(
/* 2967 */           CECombatBehaviors.Behavior.builder()
/* 2968 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2969 */           .withinDistance(0.0D, 3.0D)
/* 2970 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2971 */           .addNextBehavior(
/* 2972 */             CECombatBehaviors.Behavior.builder()
/* 2973 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2974 */             .withinDistance(0.0D, 4.0D)
/* 2975 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2976 */             .addNextBehavior(
/* 2977 */               CECombatBehaviors.Behavior.builder()
/* 2978 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2979 */               .withinDistance(0.0D, 4.0D)
/* 2980 */               .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 2981 */               .addNextBehavior(
/* 2982 */                 CECombatBehaviors.Behavior.builder()
/* 2983 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2984 */                 .withinDistance(0.0D, 5.0D)
/* 2985 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2986 */                 .addNextBehavior(
/* 2987 */                   CECombatBehaviors.Behavior.builder()
/* 2988 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2989 */                   .withinDistance(0.0D, 5.0D)
/* 2990 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2998 */       .addFirstBehavior(
/* 2999 */         CECombatBehaviors.Behavior.builder()
/* 3000 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3001 */         .withinDistance(0.0D, 3.0D)
/* 3002 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3003 */         .addNextBehavior(
/* 3004 */           CECombatBehaviors.Behavior.builder()
/* 3005 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3006 */           .withinDistance(0.0D, 3.0D)
/* 3007 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3008 */           .addNextBehavior(
/* 3009 */             CECombatBehaviors.Behavior.builder()
/* 3010 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3011 */             .withinDistance(0.0D, 4.0D)
/* 3012 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 3013 */             .addNextBehavior(
/* 3014 */               CECombatBehaviors.Behavior.builder()
/* 3015 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3016 */               .withinDistance(0.0D, 4.0D)
/* 3017 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 3018 */               .addNextBehavior(
/* 3019 */                 CECombatBehaviors.Behavior.builder()
/* 3020 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3021 */                 .withinDistance(0.0D, 5.0D)
/* 3022 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 3023 */                 .addNextBehavior(
/* 3024 */                   CECombatBehaviors.Behavior.builder()
/* 3025 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3026 */                   .withinDistance(0.0D, 5.0D)
/* 3027 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 3028 */                   .addNextBehavior(
/* 3029 */                     CECombatBehaviors.Behavior.builder()
/* 3030 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3031 */                     .withinDistance(0.0D, 5.0D)
/* 3032 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3041 */       .addFirstBehavior(
/* 3042 */         CECombatBehaviors.Behavior.builder()
/* 3043 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3044 */         .withinDistance(0.0D, 3.0D)
/* 3045 */         .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3046 */         .addNextBehavior(
/* 3047 */           CECombatBehaviors.Behavior.builder()
/* 3048 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3049 */           .withinDistance(0.0D, 3.0D)
/* 3050 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 3051 */           .addNextBehavior(
/* 3052 */             CECombatBehaviors.Behavior.builder()
/* 3053 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3054 */             .withinDistance(0.0D, 4.0D)
/* 3055 */             .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 3056 */             .addNextBehavior(
/* 3057 */               CECombatBehaviors.Behavior.builder()
/* 3058 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3059 */               .withinDistance(0.0D, 4.0D)
/* 3060 */               .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 3061 */               .addNextBehavior(
/* 3062 */                 CECombatBehaviors.Behavior.builder()
/* 3063 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3064 */                 .withinDistance(0.0D, 5.0D)
/* 3065 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 3066 */                 .addNextBehavior(
/* 3067 */                   CECombatBehaviors.Behavior.builder()
/* 3068 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3069 */                   .withinDistance(0.0D, 5.0D)
/* 3070 */                   .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3071 */                   .addNextBehavior(
/* 3072 */                     CECombatBehaviors.Behavior.builder()
/* 3073 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3074 */                     .withinDistance(0.0D, 5.0D)
/* 3075 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3084 */       .addFirstBehavior(
/* 3085 */         CECombatBehaviors.Behavior.builder()
/* 3086 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3087 */         .withinDistance(0.0D, 3.0D)
/* 3088 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3089 */         .addNextBehavior(
/* 3090 */           CECombatBehaviors.Behavior.builder()
/* 3091 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3092 */           .withinDistance(0.0D, 3.0D)
/* 3093 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 3094 */           .addNextBehavior(
/* 3095 */             CECombatBehaviors.Behavior.builder()
/* 3096 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3097 */             .withinDistance(0.0D, 4.0D)
/* 3098 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 3099 */             .addNextBehavior(
/* 3100 */               CECombatBehaviors.Behavior.builder()
/* 3101 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3102 */               .withinDistance(0.0D, 4.0D)
/* 3103 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3104 */               .addNextBehavior(
/* 3105 */                 CECombatBehaviors.Behavior.builder()
/* 3106 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3107 */                 .withinDistance(0.0D, 5.0D)
/* 3108 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 3109 */                 .addNextBehavior(
/* 3110 */                   CECombatBehaviors.Behavior.builder()
/* 3111 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3112 */                   .withinDistance(0.0D, 5.0D)
/* 3113 */                   .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3114 */                   .addNextBehavior(
/* 3115 */                     CECombatBehaviors.Behavior.builder()
/* 3116 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3117 */                     .withinDistance(0.0D, 5.0D)
/* 3118 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3127 */       .addFirstBehavior(
/* 3128 */         CECombatBehaviors.Behavior.builder()
/* 3129 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3130 */         .withinDistance(0.0D, 3.0D)
/* 3131 */         .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 3132 */         .addNextBehavior(
/* 3133 */           CECombatBehaviors.Behavior.builder()
/* 3134 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3135 */           .withinDistance(0.0D, 3.0D)
/* 3136 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 3137 */           .addNextBehavior(
/* 3138 */             CECombatBehaviors.Behavior.builder()
/* 3139 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3140 */             .withinDistance(0.0D, 4.0D)
/* 3141 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 3142 */             .addNextBehavior(
/* 3143 */               CECombatBehaviors.Behavior.builder()
/* 3144 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3145 */               .withinDistance(0.0D, 4.0D)
/* 3146 */               .animationBehavior(AVAnimations.DUAL_SWORD3, 0.0F)
/* 3147 */               .addNextBehavior(
/* 3148 */                 CECombatBehaviors.Behavior.builder()
/* 3149 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3150 */                 .withinDistance(0.0D, 5.0D)
/* 3151 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 3152 */                 .addNextBehavior(
/* 3153 */                   CECombatBehaviors.Behavior.builder()
/* 3154 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3155 */                   .withinDistance(0.0D, 5.0D)
/* 3156 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3164 */       .addFirstBehavior(
/* 3165 */         CECombatBehaviors.Behavior.builder()
/* 3166 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3167 */         .withinDistance(0.0D, 3.0D)
/* 3168 */         .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 3169 */         .addNextBehavior(
/* 3170 */           CECombatBehaviors.Behavior.builder()
/* 3171 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3172 */           .withinDistance(0.0D, 3.0D)
/* 3173 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 3174 */           .addNextBehavior(
/* 3175 */             CECombatBehaviors.Behavior.builder()
/* 3176 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3177 */             .withinDistance(0.0D, 4.0D)
/* 3178 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 3179 */             .addNextBehavior(
/* 3180 */               CECombatBehaviors.Behavior.builder()
/* 3181 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3182 */               .withinDistance(0.0D, 4.0D)
/* 3183 */               .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3184 */               .addNextBehavior(
/* 3185 */                 CECombatBehaviors.Behavior.builder()
/* 3186 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3187 */                 .withinDistance(0.0D, 5.0D)
/* 3188 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 3189 */                 .addNextBehavior(
/* 3190 */                   CECombatBehaviors.Behavior.builder()
/* 3191 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3192 */                   .withinDistance(0.0D, 5.0D)
/* 3193 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3201 */       .addFirstBehavior(
/* 3202 */         CECombatBehaviors.Behavior.builder()
/* 3203 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3204 */         .withinDistance(0.0D, 3.0D)
/* 3205 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3206 */         .addNextBehavior(
/* 3207 */           CECombatBehaviors.Behavior.builder()
/* 3208 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3209 */           .withinDistance(0.0D, 3.0D)
/* 3210 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 3211 */           .addNextBehavior(
/* 3212 */             CECombatBehaviors.Behavior.builder()
/* 3213 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3214 */             .withinDistance(0.0D, 4.0D)
/* 3215 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3216 */             .addNextBehavior(
/* 3217 */               CECombatBehaviors.Behavior.builder()
/* 3218 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3219 */               .withinDistance(0.0D, 4.0D)
/* 3220 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 3221 */               .addNextBehavior(
/* 3222 */                 CECombatBehaviors.Behavior.builder()
/* 3223 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3224 */                 .withinDistance(0.0D, 5.0D)
/* 3225 */                 .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 3226 */                 .addNextBehavior(
/* 3227 */                   CECombatBehaviors.Behavior.builder()
/* 3228 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3229 */                   .withinDistance(0.0D, 5.0D)
/* 3230 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3238 */       .addFirstBehavior(
/* 3239 */         CECombatBehaviors.Behavior.builder()
/* 3240 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3241 */         .withinDistance(0.0D, 3.0D)
/* 3242 */         .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3243 */         .addNextBehavior(
/* 3244 */           CECombatBehaviors.Behavior.builder()
/* 3245 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3246 */           .withinDistance(0.0D, 3.0D)
/* 3247 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 3248 */           .addNextBehavior(
/* 3249 */             CECombatBehaviors.Behavior.builder()
/* 3250 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3251 */             .withinDistance(0.0D, 4.0D)
/* 3252 */             .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 3253 */             .addNextBehavior(
/* 3254 */               CECombatBehaviors.Behavior.builder()
/* 3255 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3256 */               .withinDistance(0.0D, 4.0D)
/* 3257 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 3258 */               .addNextBehavior(
/* 3259 */                 CECombatBehaviors.Behavior.builder()
/* 3260 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3261 */                 .withinDistance(0.0D, 5.0D)
/* 3262 */                 .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3263 */                 .addNextBehavior(
/* 3264 */                   CECombatBehaviors.Behavior.builder()
/* 3265 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3266 */                   .withinDistance(0.0D, 5.0D)
/* 3267 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 3268 */                   .addNextBehavior(
/* 3269 */                     CECombatBehaviors.Behavior.builder()
/* 3270 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3271 */                     .withinDistance(0.0D, 5.0D)
/* 3272 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3281 */       .addFirstBehavior(
/* 3282 */         CECombatBehaviors.Behavior.builder()
/* 3283 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3284 */         .withinDistance(0.0D, 3.0D)
/* 3285 */         .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3286 */         .addNextBehavior(
/* 3287 */           CECombatBehaviors.Behavior.builder()
/* 3288 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3289 */           .withinDistance(0.0D, 3.0D)
/* 3290 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 3291 */           .addNextBehavior(
/* 3292 */             CECombatBehaviors.Behavior.builder()
/* 3293 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3294 */             .withinDistance(0.0D, 4.0D)
/* 3295 */             .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 3296 */             .addNextBehavior(
/* 3297 */               CECombatBehaviors.Behavior.builder()
/* 3298 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3299 */               .withinDistance(0.0D, 4.0D)
/* 3300 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 3301 */               .addNextBehavior(
/* 3302 */                 CECombatBehaviors.Behavior.builder()
/* 3303 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3304 */                 .withinDistance(0.0D, 5.0D)
/* 3305 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 3306 */                 .addNextBehavior(
/* 3307 */                   CECombatBehaviors.Behavior.builder()
/* 3308 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3309 */                   .withinDistance(0.0D, 5.0D)
/* 3310 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3318 */       .addFirstBehavior(
/* 3319 */         CECombatBehaviors.Behavior.builder()
/* 3320 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3321 */         .withinDistance(0.0D, 3.0D)
/* 3322 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3323 */         .addNextBehavior(
/* 3324 */           CECombatBehaviors.Behavior.builder()
/* 3325 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3326 */           .withinDistance(0.0D, 3.0D)
/* 3327 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3328 */           .addNextBehavior(
/* 3329 */             CECombatBehaviors.Behavior.builder()
/* 3330 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3331 */             .withinDistance(0.0D, 4.0D)
/* 3332 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 3333 */             .addNextBehavior(
/* 3334 */               CECombatBehaviors.Behavior.builder()
/* 3335 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3336 */               .withinDistance(0.0D, 4.0D)
/* 3337 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 3338 */               .addNextBehavior(
/* 3339 */                 CECombatBehaviors.Behavior.builder()
/* 3340 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3341 */                 .withinDistance(0.0D, 5.0D)
/* 3342 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 3343 */                 .addNextBehavior(
/* 3344 */                   CECombatBehaviors.Behavior.builder()
/* 3345 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3346 */                   .withinDistance(0.0D, 5.0D)
/* 3347 */                   .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3348 */                   .addNextBehavior(
/* 3349 */                     CECombatBehaviors.Behavior.builder()
/* 3350 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3351 */                     .withinDistance(0.0D, 5.0D)
/* 3352 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3361 */       .addFirstBehavior(
/* 3362 */         CECombatBehaviors.Behavior.builder()
/* 3363 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3364 */         .withinDistance(0.0D, 3.0D)
/* 3365 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3366 */         .addNextBehavior(
/* 3367 */           CECombatBehaviors.Behavior.builder()
/* 3368 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3369 */           .withinDistance(0.0D, 3.0D)
/* 3370 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 3371 */           .addNextBehavior(
/* 3372 */             CECombatBehaviors.Behavior.builder()
/* 3373 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3374 */             .withinDistance(0.0D, 4.0D)
/* 3375 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3376 */             .addNextBehavior(
/* 3377 */               CECombatBehaviors.Behavior.builder()
/* 3378 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3379 */               .withinDistance(0.0D, 4.0D)
/* 3380 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 3381 */               .addNextBehavior(
/* 3382 */                 CECombatBehaviors.Behavior.builder()
/* 3383 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3384 */                 .withinDistance(0.0D, 5.0D)
/* 3385 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 3386 */                 .addNextBehavior(
/* 3387 */                   CECombatBehaviors.Behavior.builder()
/* 3388 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3389 */                   .withinDistance(0.0D, 5.0D)
/* 3390 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 3391 */                   .addNextBehavior(
/* 3392 */                     CECombatBehaviors.Behavior.builder()
/* 3393 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3394 */                     .withinDistance(0.0D, 5.0D)
/* 3395 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3405 */     .newBehaviorRoot(
/* 3406 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3407 */       .priority(1.0D)
/* 3408 */       .weight(20.0D)
/* 3409 */       .maxCooldown(80)
/* 3410 */       .addFirstBehavior(
/* 3411 */         CECombatBehaviors.Behavior.builder()
/* 3412 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3413 */         .withinDistance(0.0D, 3.0D)
/* 3414 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 3415 */         .addNextBehavior(
/* 3416 */           CECombatBehaviors.Behavior.builder()
/* 3417 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3418 */           .withinDistance(0.0D, 3.0D)
/* 3419 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 3420 */           .addNextBehavior(
/* 3421 */             CECombatBehaviors.Behavior.builder()
/* 3422 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3423 */             .withinDistance(0.0D, 3.0D)
/* 3424 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 3425 */             .addNextBehavior(
/* 3426 */               CECombatBehaviors.Behavior.builder()
/* 3427 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3428 */               .withinDistance(0.0D, 3.0D)
/* 3429 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3435 */     .newBehaviorRoot(
/* 3436 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3437 */       .priority(1.0D)
/* 3438 */       .weight(10.0D)
/* 3439 */       .maxCooldown(80)
/* 3440 */       .addFirstBehavior(
/* 3441 */         CECombatBehaviors.Behavior.builder()
/* 3442 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3443 */         .withinDistance(0.0D, 3.0D)
/* 3444 */         .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F))
/*      */       
/* 3446 */       .addFirstBehavior(
/* 3447 */         CECombatBehaviors.Behavior.builder()
/* 3448 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3449 */         .withinDistance(0.0D, 3.0D)
/* 3450 */         .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F))
/*      */       
/* 3452 */       .addFirstBehavior(
/* 3453 */         CECombatBehaviors.Behavior.builder()
/* 3454 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3455 */         .withinDistance(0.0D, 3.0D)
/* 3456 */         .animationBehavior(Animations.DANCING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 3459 */     .newBehaviorRoot(
/* 3460 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3461 */       .priority(1.0D)
/* 3462 */       .weight(10.0D)
/* 3463 */       .maxCooldown(80)
/* 3464 */       .addFirstBehavior(
/* 3465 */         CECombatBehaviors.Behavior.builder()
/* 3466 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3467 */         .withinDistance(0.0D, 3.0D)
/* 3468 */         .custom(CombatCommon::canThrowEnderPearl)
/* 3469 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 3470 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 3471 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 3474 */     .newBehaviorRoot(
/* 3475 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3476 */       .priority(1.0D)
/* 3477 */       .weight(2.0D)
/* 3478 */       .maxCooldown(80)
/* 3479 */       .addFirstBehavior(
/* 3480 */         CECombatBehaviors.Behavior.builder()
/* 3481 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3482 */         .withinDistance(0.0D, 3.0D)
/* 3483 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 3485 */       .addFirstBehavior(
/* 3486 */         CECombatBehaviors.Behavior.builder()
/* 3487 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3488 */         .withinDistance(0.0D, 3.0D)
/* 3489 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 3491 */       .addFirstBehavior(
/* 3492 */         CECombatBehaviors.Behavior.builder()
/* 3493 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3494 */         .withinDistance(0.0D, 3.0D)
/* 3495 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 3497 */       .addFirstBehavior(
/* 3498 */         CECombatBehaviors.Behavior.builder()
/* 3499 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3500 */         .withinDistance(0.0D, 3.0D)
/* 3501 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 3503 */       .addFirstBehavior(
/* 3504 */         CECombatBehaviors.Behavior.builder()
/* 3505 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3506 */         .withinDistance(0.0D, 3.0D)
/* 3507 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 3509 */       .addFirstBehavior(
/* 3510 */         CECombatBehaviors.Behavior.builder()
/* 3511 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3512 */         .withinDistance(0.0D, 3.0D)
/* 3513 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 3515 */       .addFirstBehavior(
/* 3516 */         CECombatBehaviors.Behavior.builder()
/* 3517 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3518 */         .withinDistance(0.0D, 3.0D)
/* 3519 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 3522 */     .newBehaviorRoot(
/* 3523 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3524 */       .priority(1.0D)
/* 3525 */       .weight(15.0D)
/* 3526 */       .addFirstBehavior(
/* 3527 */         CECombatBehaviors.Behavior.builder()
/* 3528 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3529 */         .withinDistance(0.0D, 3.0D)
/* 3530 */         .custom(CombatCommon::canPerformGuarding)
/* 3531 */         .guard(40)))
/*      */ 
/*      */     
/* 3534 */     .newBehaviorRoot(
/* 3535 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3536 */       .priority(1.0D)
/* 3537 */       .weight(10.0D)
/* 3538 */       .addFirstBehavior(
/* 3539 */         CECombatBehaviors.Behavior.builder()
/* 3540 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3541 */         .withinDistance(0.0D, 3.0D)
/* 3542 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 3544 */       .addFirstBehavior(
/* 3545 */         CECombatBehaviors.Behavior.builder()
/* 3546 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3547 */         .withinDistance(0.0D, 3.0D)
/* 3548 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 3550 */       .addFirstBehavior(
/* 3551 */         CECombatBehaviors.Behavior.builder()
/* 3552 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3553 */         .withinDistance(0.0D, 3.0D)
/* 3554 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 3556 */       .addFirstBehavior(
/* 3557 */         CECombatBehaviors.Behavior.builder()
/* 3558 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3559 */         .withinDistance(0.0D, 3.0D)
/* 3560 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 3563 */     .newBehaviorRoot(
/* 3564 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3565 */       .priority(1.0D)
/* 3566 */       .weight(40.0D)
/* 3567 */       .maxCooldown(160)
/* 3568 */       .addFirstBehavior(
/* 3569 */         CECombatBehaviors.Behavior.builder()
/* 3570 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3571 */         .custom(CombatCommon::canJump)
/* 3572 */         .withinDistance(5.0D, 14.0D)
/* 3573 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 3574 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\NpcSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */