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
/*      */ public class PlayerNpcSword
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
/*   38 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
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
/*   57 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
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
/*   71 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   72 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   74 */       .addFirstBehavior(
/*   75 */         CECombatBehaviors.Behavior.builder()
/*   76 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   77 */         .custom(CombatCommon::canSwapToBow)
/*   78 */         .withinDistance(7.0D, 14.0D)
/*   79 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*   80 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*   83 */     .newBehaviorRoot(
/*   84 */       CECombatBehaviors.BehaviorRoot.builder()
/*   85 */       .priority(2.0D)
/*   86 */       .weight(80.0D)
/*   87 */       .maxCooldown(120)
/*   88 */       .addFirstBehavior(
/*   89 */         CECombatBehaviors.Behavior.builder()
/*   90 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   91 */         .custom(CombatCommon::canThrowEnderPearl)
/*   92 */         .withinDistance(7.0D, 48.0D)
/*   93 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*   94 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*   97 */     .newBehaviorRoot(
/*   98 */       CECombatBehaviors.BehaviorRoot.builder()
/*   99 */       .priority(1.0D)
/*  100 */       .weight(40.0D)
/*  101 */       .maxCooldown(20)
/*  102 */       .addFirstBehavior(
/*  103 */         CECombatBehaviors.Behavior.builder()
/*  104 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  105 */         .withinDistance(0.0D, 3.0D)
/*  106 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  107 */         .addNextBehavior(
/*  108 */           CECombatBehaviors.Behavior.builder()
/*  109 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  110 */           .withinDistance(0.0D, 3.0D)
/*  111 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  112 */           .addNextBehavior(
/*  113 */             CECombatBehaviors.Behavior.builder()
/*  114 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  115 */             .withinDistance(0.0D, 3.0D)
/*  116 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  120 */       .addFirstBehavior(
/*  121 */         CECombatBehaviors.Behavior.builder()
/*  122 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  123 */         .withinDistance(0.0D, 3.0D)
/*  124 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  125 */         .addNextBehavior(
/*  126 */           CECombatBehaviors.Behavior.builder()
/*  127 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  128 */           .withinDistance(0.0D, 3.0D)
/*  129 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  130 */           .addNextBehavior(
/*  131 */             CECombatBehaviors.Behavior.builder()
/*  132 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  133 */             .withinDistance(0.0D, 4.0D)
/*  134 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  135 */             .addNextBehavior(
/*  136 */               CECombatBehaviors.Behavior.builder()
/*  137 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  138 */               .withinDistance(0.0D, 4.0D)
/*  139 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  140 */               .addNextBehavior(
/*  141 */                 CECombatBehaviors.Behavior.builder()
/*  142 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  143 */                 .withinDistance(0.0D, 5.0D)
/*  144 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  145 */                 .addNextBehavior(
/*  146 */                   CECombatBehaviors.Behavior.builder()
/*  147 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  148 */                   .withinDistance(0.0D, 5.0D)
/*  149 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  157 */       .addFirstBehavior(
/*  158 */         CECombatBehaviors.Behavior.builder()
/*  159 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  160 */         .withinDistance(0.0D, 3.0D)
/*  161 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  162 */         .addNextBehavior(
/*  163 */           CECombatBehaviors.Behavior.builder()
/*  164 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  165 */           .withinDistance(0.0D, 3.0D)
/*  166 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  167 */           .addNextBehavior(
/*  168 */             CECombatBehaviors.Behavior.builder()
/*  169 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  170 */             .withinDistance(0.0D, 4.0D)
/*  171 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  172 */             .addNextBehavior(
/*  173 */               CECombatBehaviors.Behavior.builder()
/*  174 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  175 */               .withinDistance(0.0D, 4.0D)
/*  176 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  177 */               .addNextBehavior(
/*  178 */                 CECombatBehaviors.Behavior.builder()
/*  179 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  180 */                 .withinDistance(0.0D, 5.0D)
/*  181 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  182 */                 .addNextBehavior(
/*  183 */                   CECombatBehaviors.Behavior.builder()
/*  184 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  185 */                   .withinDistance(0.0D, 5.0D)
/*  186 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  194 */       .addFirstBehavior(
/*  195 */         CECombatBehaviors.Behavior.builder()
/*  196 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  197 */         .withinDistance(0.0D, 3.0D)
/*  198 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  199 */         .addNextBehavior(
/*  200 */           CECombatBehaviors.Behavior.builder()
/*  201 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  202 */           .withinDistance(0.0D, 3.0D)
/*  203 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  204 */           .addNextBehavior(
/*  205 */             CECombatBehaviors.Behavior.builder()
/*  206 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  207 */             .withinDistance(0.0D, 4.0D)
/*  208 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  209 */             .addNextBehavior(
/*  210 */               CECombatBehaviors.Behavior.builder()
/*  211 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  212 */               .withinDistance(0.0D, 4.0D)
/*  213 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  214 */               .addNextBehavior(
/*  215 */                 CECombatBehaviors.Behavior.builder()
/*  216 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  217 */                 .withinDistance(0.0D, 5.0D)
/*  218 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  219 */                 .addNextBehavior(
/*  220 */                   CECombatBehaviors.Behavior.builder()
/*  221 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  222 */                   .withinDistance(0.0D, 5.0D)
/*  223 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  224 */                   .addNextBehavior(
/*  225 */                     CECombatBehaviors.Behavior.builder()
/*  226 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  227 */                     .withinDistance(0.0D, 5.0D)
/*  228 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  237 */       .addFirstBehavior(
/*  238 */         CECombatBehaviors.Behavior.builder()
/*  239 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  240 */         .withinDistance(0.0D, 3.0D)
/*  241 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  242 */         .addNextBehavior(
/*  243 */           CECombatBehaviors.Behavior.builder()
/*  244 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  245 */           .withinDistance(0.0D, 3.0D)
/*  246 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  247 */           .addNextBehavior(
/*  248 */             CECombatBehaviors.Behavior.builder()
/*  249 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  250 */             .withinDistance(0.0D, 4.0D)
/*  251 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  252 */             .addNextBehavior(
/*  253 */               CECombatBehaviors.Behavior.builder()
/*  254 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  255 */               .withinDistance(0.0D, 4.0D)
/*  256 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  257 */               .addNextBehavior(
/*  258 */                 CECombatBehaviors.Behavior.builder()
/*  259 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  260 */                 .withinDistance(0.0D, 5.0D)
/*  261 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  268 */       .addFirstBehavior(
/*  269 */         CECombatBehaviors.Behavior.builder()
/*  270 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  271 */         .withinDistance(0.0D, 3.0D)
/*  272 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  273 */         .addNextBehavior(
/*  274 */           CECombatBehaviors.Behavior.builder()
/*  275 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  276 */           .withinDistance(0.0D, 3.0D)
/*  277 */           .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  278 */           .addNextBehavior(
/*  279 */             CECombatBehaviors.Behavior.builder()
/*  280 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  281 */             .withinDistance(0.0D, 4.0D)
/*  282 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  283 */             .addNextBehavior(
/*  284 */               CECombatBehaviors.Behavior.builder()
/*  285 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  286 */               .withinDistance(0.0D, 4.0D)
/*  287 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  288 */               .addNextBehavior(
/*  289 */                 CECombatBehaviors.Behavior.builder()
/*  290 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  291 */                 .withinDistance(0.0D, 5.0D)
/*  292 */                 .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  293 */                 .addNextBehavior(
/*  294 */                   CECombatBehaviors.Behavior.builder()
/*  295 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  296 */                   .withinDistance(0.0D, 5.0D)
/*  297 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  305 */       .addFirstBehavior(
/*  306 */         CECombatBehaviors.Behavior.builder()
/*  307 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  308 */         .withinDistance(0.0D, 3.0D)
/*  309 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  310 */         .addNextBehavior(
/*  311 */           CECombatBehaviors.Behavior.builder()
/*  312 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  313 */           .withinDistance(0.0D, 3.0D)
/*  314 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  315 */           .addNextBehavior(
/*  316 */             CECombatBehaviors.Behavior.builder()
/*  317 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  318 */             .withinDistance(0.0D, 4.0D)
/*  319 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  320 */             .addNextBehavior(
/*  321 */               CECombatBehaviors.Behavior.builder()
/*  322 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  323 */               .withinDistance(0.0D, 4.0D)
/*  324 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  325 */               .addNextBehavior(
/*  326 */                 CECombatBehaviors.Behavior.builder()
/*  327 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  328 */                 .withinDistance(0.0D, 5.0D)
/*  329 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  330 */                 .addNextBehavior(
/*  331 */                   CECombatBehaviors.Behavior.builder()
/*  332 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  333 */                   .withinDistance(0.0D, 5.0D)
/*  334 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  335 */                   .addNextBehavior(
/*  336 */                     CECombatBehaviors.Behavior.builder()
/*  337 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  338 */                     .withinDistance(0.0D, 5.0D)
/*  339 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  348 */       .addFirstBehavior(
/*  349 */         CECombatBehaviors.Behavior.builder()
/*  350 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  351 */         .withinDistance(0.0D, 3.0D)
/*  352 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  353 */         .addNextBehavior(
/*  354 */           CECombatBehaviors.Behavior.builder()
/*  355 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  356 */           .withinDistance(0.0D, 3.0D)
/*  357 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  358 */           .addNextBehavior(
/*  359 */             CECombatBehaviors.Behavior.builder()
/*  360 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  361 */             .withinDistance(0.0D, 4.0D)
/*  362 */             .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  363 */             .addNextBehavior(
/*  364 */               CECombatBehaviors.Behavior.builder()
/*  365 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  366 */               .withinDistance(0.0D, 4.0D)
/*  367 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  368 */               .addNextBehavior(
/*  369 */                 CECombatBehaviors.Behavior.builder()
/*  370 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  371 */                 .withinDistance(0.0D, 5.0D)
/*  372 */                 .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  373 */                 .addNextBehavior(
/*  374 */                   CECombatBehaviors.Behavior.builder()
/*  375 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  376 */                   .withinDistance(0.0D, 5.0D)
/*  377 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  385 */       .addFirstBehavior(
/*  386 */         CECombatBehaviors.Behavior.builder()
/*  387 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  388 */         .withinDistance(0.0D, 3.0D)
/*  389 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  390 */         .addNextBehavior(
/*  391 */           CECombatBehaviors.Behavior.builder()
/*  392 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  393 */           .withinDistance(0.0D, 3.0D)
/*  394 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  395 */           .addNextBehavior(
/*  396 */             CECombatBehaviors.Behavior.builder()
/*  397 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  398 */             .withinDistance(0.0D, 4.0D)
/*  399 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  400 */             .addNextBehavior(
/*  401 */               CECombatBehaviors.Behavior.builder()
/*  402 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  403 */               .withinDistance(0.0D, 4.0D)
/*  404 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  405 */               .addNextBehavior(
/*  406 */                 CECombatBehaviors.Behavior.builder()
/*  407 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  408 */                 .withinDistance(0.0D, 5.0D)
/*  409 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  410 */                 .addNextBehavior(
/*  411 */                   CECombatBehaviors.Behavior.builder()
/*  412 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  413 */                   .withinDistance(0.0D, 5.0D)
/*  414 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  422 */       .addFirstBehavior(
/*  423 */         CECombatBehaviors.Behavior.builder()
/*  424 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  425 */         .withinDistance(0.0D, 3.0D)
/*  426 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  427 */         .addNextBehavior(
/*  428 */           CECombatBehaviors.Behavior.builder()
/*  429 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  430 */           .withinDistance(0.0D, 3.0D)
/*  431 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  432 */           .addNextBehavior(
/*  433 */             CECombatBehaviors.Behavior.builder()
/*  434 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  435 */             .withinDistance(0.0D, 4.0D)
/*  436 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  437 */             .addNextBehavior(
/*  438 */               CECombatBehaviors.Behavior.builder()
/*  439 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  440 */               .withinDistance(0.0D, 4.0D)
/*  441 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  442 */               .addNextBehavior(
/*  443 */                 CECombatBehaviors.Behavior.builder()
/*  444 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  445 */                 .withinDistance(0.0D, 5.0D)
/*  446 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  447 */                 .addNextBehavior(
/*  448 */                   CECombatBehaviors.Behavior.builder()
/*  449 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  450 */                   .withinDistance(0.0D, 5.0D)
/*  451 */                   .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  452 */                   .addNextBehavior(
/*  453 */                     CECombatBehaviors.Behavior.builder()
/*  454 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  455 */                     .withinDistance(0.0D, 5.0D)
/*  456 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  465 */       .addFirstBehavior(
/*  466 */         CECombatBehaviors.Behavior.builder()
/*  467 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  468 */         .withinDistance(0.0D, 3.0D)
/*  469 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  470 */         .addNextBehavior(
/*  471 */           CECombatBehaviors.Behavior.builder()
/*  472 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  473 */           .withinDistance(0.0D, 3.0D)
/*  474 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  475 */           .addNextBehavior(
/*  476 */             CECombatBehaviors.Behavior.builder()
/*  477 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  478 */             .withinDistance(0.0D, 4.0D)
/*  479 */             .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  480 */             .addNextBehavior(
/*  481 */               CECombatBehaviors.Behavior.builder()
/*  482 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  483 */               .withinDistance(0.0D, 4.0D)
/*  484 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  485 */               .addNextBehavior(
/*  486 */                 CECombatBehaviors.Behavior.builder()
/*  487 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  488 */                 .withinDistance(0.0D, 5.0D)
/*  489 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  496 */       .addFirstBehavior(
/*  497 */         CECombatBehaviors.Behavior.builder()
/*  498 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  499 */         .withinDistance(0.0D, 3.0D)
/*  500 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  501 */         .addNextBehavior(
/*  502 */           CECombatBehaviors.Behavior.builder()
/*  503 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  504 */           .withinDistance(0.0D, 3.0D)
/*  505 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  506 */           .addNextBehavior(
/*  507 */             CECombatBehaviors.Behavior.builder()
/*  508 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  509 */             .withinDistance(0.0D, 4.0D)
/*  510 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  511 */             .addNextBehavior(
/*  512 */               CECombatBehaviors.Behavior.builder()
/*  513 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  514 */               .withinDistance(0.0D, 4.0D)
/*  515 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  516 */               .addNextBehavior(
/*  517 */                 CECombatBehaviors.Behavior.builder()
/*  518 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  519 */                 .withinDistance(0.0D, 5.0D)
/*  520 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  521 */                 .addNextBehavior(
/*  522 */                   CECombatBehaviors.Behavior.builder()
/*  523 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  524 */                   .withinDistance(0.0D, 5.0D)
/*  525 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  533 */       .addFirstBehavior(
/*  534 */         CECombatBehaviors.Behavior.builder()
/*  535 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  536 */         .withinDistance(0.0D, 3.0D)
/*  537 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  538 */         .addNextBehavior(
/*  539 */           CECombatBehaviors.Behavior.builder()
/*  540 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  541 */           .withinDistance(0.0D, 3.0D)
/*  542 */           .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  543 */           .addNextBehavior(
/*  544 */             CECombatBehaviors.Behavior.builder()
/*  545 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  546 */             .withinDistance(0.0D, 4.0D)
/*  547 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  548 */             .addNextBehavior(
/*  549 */               CECombatBehaviors.Behavior.builder()
/*  550 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  551 */               .withinDistance(0.0D, 4.0D)
/*  552 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  553 */               .addNextBehavior(
/*  554 */                 CECombatBehaviors.Behavior.builder()
/*  555 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  556 */                 .withinDistance(0.0D, 5.0D)
/*  557 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  558 */                 .addNextBehavior(
/*  559 */                   CECombatBehaviors.Behavior.builder()
/*  560 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  561 */                   .withinDistance(0.0D, 5.0D)
/*  562 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  563 */                   .addNextBehavior(
/*  564 */                     CECombatBehaviors.Behavior.builder()
/*  565 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  566 */                     .withinDistance(0.0D, 5.0D)
/*  567 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  576 */       .addFirstBehavior(
/*  577 */         CECombatBehaviors.Behavior.builder()
/*  578 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  579 */         .withinDistance(0.0D, 3.0D)
/*  580 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  581 */         .addNextBehavior(
/*  582 */           CECombatBehaviors.Behavior.builder()
/*  583 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  584 */           .withinDistance(0.0D, 3.0D)
/*  585 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  586 */           .addNextBehavior(
/*  587 */             CECombatBehaviors.Behavior.builder()
/*  588 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  589 */             .withinDistance(0.0D, 4.0D)
/*  590 */             .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  591 */             .addNextBehavior(
/*  592 */               CECombatBehaviors.Behavior.builder()
/*  593 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  594 */               .withinDistance(0.0D, 4.0D)
/*  595 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  596 */               .addNextBehavior(
/*  597 */                 CECombatBehaviors.Behavior.builder()
/*  598 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  599 */                 .withinDistance(0.0D, 5.0D)
/*  600 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  601 */                 .addNextBehavior(
/*  602 */                   CECombatBehaviors.Behavior.builder()
/*  603 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  604 */                   .withinDistance(0.0D, 5.0D)
/*  605 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  613 */       .addFirstBehavior(
/*  614 */         CECombatBehaviors.Behavior.builder()
/*  615 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  616 */         .withinDistance(0.0D, 3.0D)
/*  617 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  618 */         .addNextBehavior(
/*  619 */           CECombatBehaviors.Behavior.builder()
/*  620 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  621 */           .withinDistance(0.0D, 3.0D)
/*  622 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  623 */           .addNextBehavior(
/*  624 */             CECombatBehaviors.Behavior.builder()
/*  625 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  626 */             .withinDistance(0.0D, 4.0D)
/*  627 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  628 */             .addNextBehavior(
/*  629 */               CECombatBehaviors.Behavior.builder()
/*  630 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  631 */               .withinDistance(0.0D, 4.0D)
/*  632 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  633 */               .addNextBehavior(
/*  634 */                 CECombatBehaviors.Behavior.builder()
/*  635 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  636 */                 .withinDistance(0.0D, 5.0D)
/*  637 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  638 */                 .addNextBehavior(
/*  639 */                   CECombatBehaviors.Behavior.builder()
/*  640 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  641 */                   .withinDistance(0.0D, 5.0D)
/*  642 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  643 */                   .addNextBehavior(
/*  644 */                     CECombatBehaviors.Behavior.builder()
/*  645 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  646 */                     .withinDistance(0.0D, 5.0D)
/*  647 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  656 */       .addFirstBehavior(
/*  657 */         CECombatBehaviors.Behavior.builder()
/*  658 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  659 */         .withinDistance(0.0D, 3.0D)
/*  660 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  661 */         .addNextBehavior(
/*  662 */           CECombatBehaviors.Behavior.builder()
/*  663 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  664 */           .withinDistance(0.0D, 3.0D)
/*  665 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  666 */           .addNextBehavior(
/*  667 */             CECombatBehaviors.Behavior.builder()
/*  668 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  669 */             .withinDistance(0.0D, 4.0D)
/*  670 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  671 */             .addNextBehavior(
/*  672 */               CECombatBehaviors.Behavior.builder()
/*  673 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  674 */               .withinDistance(0.0D, 4.0D)
/*  675 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  676 */               .addNextBehavior(
/*  677 */                 CECombatBehaviors.Behavior.builder()
/*  678 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  679 */                 .withinDistance(0.0D, 5.0D)
/*  680 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  681 */                 .addNextBehavior(
/*  682 */                   CECombatBehaviors.Behavior.builder()
/*  683 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  684 */                   .withinDistance(0.0D, 5.0D)
/*  685 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  694 */     .newBehaviorRoot(
/*  695 */       CECombatBehaviors.BehaviorRoot.builder()
/*  696 */       .priority(1.0D)
/*  697 */       .weight(20.0D)
/*  698 */       .maxCooldown(100)
/*  699 */       .addFirstBehavior(
/*  700 */         CECombatBehaviors.Behavior.builder()
/*  701 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  702 */         .withinDistance(0.0D, 3.0D)
/*  703 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  704 */         .addNextBehavior(
/*  705 */           CECombatBehaviors.Behavior.builder()
/*  706 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  707 */           .withinDistance(0.0D, 3.0D)
/*  708 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  709 */           .addNextBehavior(
/*  710 */             CECombatBehaviors.Behavior.builder()
/*  711 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  712 */             .withinDistance(0.0D, 3.0D)
/*  713 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  718 */     .newBehaviorRoot(
/*  719 */       CECombatBehaviors.BehaviorRoot.builder()
/*  720 */       .priority(1.0D)
/*  721 */       .weight(10.0D)
/*  722 */       .maxCooldown(100)
/*  723 */       .addFirstBehavior(
/*  724 */         CECombatBehaviors.Behavior.builder()
/*  725 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  726 */         .withinDistance(0.0D, 3.0D)
/*  727 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*      */       
/*  729 */       .addFirstBehavior(
/*  730 */         CECombatBehaviors.Behavior.builder()
/*  731 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  732 */         .withinDistance(0.0D, 3.0D)
/*  733 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*      */       
/*  735 */       .addFirstBehavior(
/*  736 */         CECombatBehaviors.Behavior.builder()
/*  737 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  738 */         .withinDistance(0.0D, 3.0D)
/*  739 */         .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))
/*      */ 
/*      */     
/*  742 */     .newBehaviorRoot(
/*  743 */       CECombatBehaviors.BehaviorRoot.builder()
/*  744 */       .priority(1.0D)
/*  745 */       .weight(10.0D)
/*  746 */       .maxCooldown(100)
/*  747 */       .addFirstBehavior(
/*  748 */         CECombatBehaviors.Behavior.builder()
/*  749 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  750 */         .withinDistance(0.0D, 3.0D)
/*  751 */         .custom(CombatCommon::canThrowEnderPearl)
/*  752 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  753 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  754 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  757 */     .newBehaviorRoot(
/*  758 */       CECombatBehaviors.BehaviorRoot.builder()
/*  759 */       .priority(1.0D)
/*  760 */       .weight(2.0D)
/*  761 */       .maxCooldown(100)
/*  762 */       .addFirstBehavior(
/*  763 */         CECombatBehaviors.Behavior.builder()
/*  764 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  765 */         .withinDistance(0.0D, 3.0D)
/*  766 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  768 */       .addFirstBehavior(
/*  769 */         CECombatBehaviors.Behavior.builder()
/*  770 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  771 */         .withinDistance(0.0D, 3.0D)
/*  772 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  774 */       .addFirstBehavior(
/*  775 */         CECombatBehaviors.Behavior.builder()
/*  776 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  777 */         .withinDistance(0.0D, 3.0D)
/*  778 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  780 */       .addFirstBehavior(
/*  781 */         CECombatBehaviors.Behavior.builder()
/*  782 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  783 */         .withinDistance(0.0D, 3.0D)
/*  784 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  786 */       .addFirstBehavior(
/*  787 */         CECombatBehaviors.Behavior.builder()
/*  788 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  789 */         .withinDistance(0.0D, 3.0D)
/*  790 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  792 */       .addFirstBehavior(
/*  793 */         CECombatBehaviors.Behavior.builder()
/*  794 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  795 */         .withinDistance(0.0D, 3.0D)
/*  796 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  798 */       .addFirstBehavior(
/*  799 */         CECombatBehaviors.Behavior.builder()
/*  800 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  801 */         .withinDistance(0.0D, 3.0D)
/*  802 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  805 */     .newBehaviorRoot(
/*  806 */       CECombatBehaviors.BehaviorRoot.builder()
/*  807 */       .priority(1.0D)
/*  808 */       .weight(15.0D)
/*  809 */       .addFirstBehavior(
/*  810 */         CECombatBehaviors.Behavior.builder()
/*  811 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  812 */         .withinDistance(0.0D, 3.0D)
/*  813 */         .custom(CombatCommon::canPerformGuarding)
/*  814 */         .guard(40)))
/*      */ 
/*      */     
/*  817 */     .newBehaviorRoot(
/*  818 */       CECombatBehaviors.BehaviorRoot.builder()
/*  819 */       .priority(1.0D)
/*  820 */       .weight(10.0D)
/*  821 */       .addFirstBehavior(
/*  822 */         CECombatBehaviors.Behavior.builder()
/*  823 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  824 */         .withinDistance(0.0D, 3.0D)
/*  825 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/*  827 */       .addFirstBehavior(
/*  828 */         CECombatBehaviors.Behavior.builder()
/*  829 */         .withinDistance(0.0D, 3.0D)
/*  830 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  831 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/*  834 */     .newBehaviorRoot(
/*  835 */       CECombatBehaviors.BehaviorRoot.builder()
/*  836 */       .priority(1.0D)
/*  837 */       .weight(40.0D)
/*  838 */       .maxCooldown(160)
/*  839 */       .addFirstBehavior(
/*  840 */         CECombatBehaviors.Behavior.builder()
/*  841 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  842 */         .custom(CombatCommon::canJump)
/*  843 */         .withinDistance(5.0D, 14.0D)
/*  844 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/*  845 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/*  849 */   public static final CECombatBehaviors.Builder<MobPatch<?>> DUAL_SWORD = CECombatBehaviors.builder()
/*  850 */     .newBehaviorRoot(
/*  851 */       CECombatBehaviors.BehaviorRoot.builder()
/*  852 */       .priority(4.0D)
/*  853 */       .weight(1000.0D)
/*  854 */       .maxCooldown(0)
/*  855 */       .addFirstBehavior(
/*  856 */         CECombatBehaviors.Behavior.builder()
/*  857 */         .custom(CombatCommon::canExecute)
/*  858 */         .withinDistance(0.0D, 5.0D)
/*  859 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  860 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  863 */     .newBehaviorRoot(
/*  864 */       CECombatBehaviors.BehaviorRoot.builder()
/*  865 */       .priority(3.0D)
/*  866 */       .weight(1000.0D)
/*  867 */       .maxCooldown(0)
/*  868 */       .addFirstBehavior(
/*  869 */         CECombatBehaviors.Behavior.builder()
/*  870 */         .custom(CombatCommon::canEscape)
/*  871 */         .withinDistance(0.0D, 8.0D)
/*  872 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  873 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  875 */       .addFirstBehavior(
/*  876 */         CECombatBehaviors.Behavior.builder()
/*  877 */         .custom(CombatCommon::canEscape)
/*  878 */         .withinDistance(0.0D, 48.0D)
/*  879 */         .guard(40)))
/*      */ 
/*      */     
/*  882 */     .newBehaviorRoot(
/*  883 */       CECombatBehaviors.BehaviorRoot.builder()
/*  884 */       .priority(2.0D)
/*  885 */       .weight(70.0D)
/*  886 */       .maxCooldown(0)
/*  887 */       .addFirstBehavior(
/*  888 */         CECombatBehaviors.Behavior.builder()
/*  889 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  890 */         .custom(CombatCommon::canPerformEating)
/*  891 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  892 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  895 */     .newBehaviorRoot(
/*  896 */       CECombatBehaviors.BehaviorRoot.builder()
/*  897 */       .priority(2.0D)
/*  898 */       .weight(100.0D)
/*  899 */       .maxCooldown(120)
/*  900 */       .addFirstBehavior(
/*  901 */         CECombatBehaviors.Behavior.builder()
/*  902 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  903 */         .custom(CombatCommon::canSwapToBow)
/*  904 */         .withinDistance(7.0D, 14.0D)
/*  905 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  906 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  908 */       .addFirstBehavior(
/*  909 */         CECombatBehaviors.Behavior.builder()
/*  910 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  911 */         .custom(CombatCommon::canSwapToBow)
/*  912 */         .withinDistance(7.0D, 14.0D)
/*  913 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  914 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  917 */     .newBehaviorRoot(
/*  918 */       CECombatBehaviors.BehaviorRoot.builder()
/*  919 */       .priority(2.0D)
/*  920 */       .weight(80.0D)
/*  921 */       .maxCooldown(120)
/*  922 */       .addFirstBehavior(
/*  923 */         CECombatBehaviors.Behavior.builder()
/*  924 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  925 */         .custom(CombatCommon::canThrowEnderPearl)
/*  926 */         .withinDistance(7.0D, 48.0D)
/*  927 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  928 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  931 */     .newBehaviorRoot(
/*  932 */       CECombatBehaviors.BehaviorRoot.builder()
/*  933 */       .priority(1.0D)
/*  934 */       .weight(40.0D)
/*  935 */       .maxCooldown(20)
/*  936 */       .addFirstBehavior(
/*  937 */         CECombatBehaviors.Behavior.builder()
/*  938 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  939 */         .withinDistance(0.0D, 3.0D)
/*  940 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/*  941 */         .addNextBehavior(
/*  942 */           CECombatBehaviors.Behavior.builder()
/*  943 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  944 */           .withinDistance(0.0D, 3.0D)
/*  945 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/*  946 */           .addNextBehavior(
/*  947 */             CECombatBehaviors.Behavior.builder()
/*  948 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  949 */             .withinDistance(0.0D, 3.0D)
/*  950 */             .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  954 */       .addFirstBehavior(
/*  955 */         CECombatBehaviors.Behavior.builder()
/*  956 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  957 */         .withinDistance(0.0D, 3.0D)
/*  958 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/*  959 */         .addNextBehavior(
/*  960 */           CECombatBehaviors.Behavior.builder()
/*  961 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  962 */           .withinDistance(0.0D, 3.0D)
/*  963 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/*  964 */           .addNextBehavior(
/*  965 */             CECombatBehaviors.Behavior.builder()
/*  966 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  967 */             .withinDistance(0.0D, 4.0D)
/*  968 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/*  969 */             .addNextBehavior(
/*  970 */               CECombatBehaviors.Behavior.builder()
/*  971 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  972 */               .withinDistance(0.0D, 4.0D)
/*  973 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/*  974 */               .addNextBehavior(
/*  975 */                 CECombatBehaviors.Behavior.builder()
/*  976 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  977 */                 .withinDistance(0.0D, 5.0D)
/*  978 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  979 */                 .addNextBehavior(
/*  980 */                   CECombatBehaviors.Behavior.builder()
/*  981 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  982 */                   .withinDistance(0.0D, 5.0D)
/*  983 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  991 */       .addFirstBehavior(
/*  992 */         CECombatBehaviors.Behavior.builder()
/*  993 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  994 */         .withinDistance(0.0D, 3.0D)
/*  995 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/*  996 */         .addNextBehavior(
/*  997 */           CECombatBehaviors.Behavior.builder()
/*  998 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  999 */           .withinDistance(0.0D, 3.0D)
/* 1000 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1001 */           .addNextBehavior(
/* 1002 */             CECombatBehaviors.Behavior.builder()
/* 1003 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1004 */             .withinDistance(0.0D, 4.0D)
/* 1005 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1006 */             .addNextBehavior(
/* 1007 */               CECombatBehaviors.Behavior.builder()
/* 1008 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1009 */               .withinDistance(0.0D, 4.0D)
/* 1010 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1011 */               .addNextBehavior(
/* 1012 */                 CECombatBehaviors.Behavior.builder()
/* 1013 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1014 */                 .withinDistance(0.0D, 5.0D)
/* 1015 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1016 */                 .addNextBehavior(
/* 1017 */                   CECombatBehaviors.Behavior.builder()
/* 1018 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1019 */                   .withinDistance(0.0D, 5.0D)
/* 1020 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1021 */                   .addNextBehavior(
/* 1022 */                     CECombatBehaviors.Behavior.builder()
/* 1023 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1024 */                     .withinDistance(0.0D, 5.0D)
/* 1025 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1034 */       .addFirstBehavior(
/* 1035 */         CECombatBehaviors.Behavior.builder()
/* 1036 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1037 */         .withinDistance(0.0D, 3.0D)
/* 1038 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1039 */         .addNextBehavior(
/* 1040 */           CECombatBehaviors.Behavior.builder()
/* 1041 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1042 */           .withinDistance(0.0D, 3.0D)
/* 1043 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1044 */           .addNextBehavior(
/* 1045 */             CECombatBehaviors.Behavior.builder()
/* 1046 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1047 */             .withinDistance(0.0D, 4.0D)
/* 1048 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1049 */             .addNextBehavior(
/* 1050 */               CECombatBehaviors.Behavior.builder()
/* 1051 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1052 */               .withinDistance(0.0D, 4.0D)
/* 1053 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1054 */               .addNextBehavior(
/* 1055 */                 CECombatBehaviors.Behavior.builder()
/* 1056 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1057 */                 .withinDistance(0.0D, 5.0D)
/* 1058 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1059 */                 .addNextBehavior(
/* 1060 */                   CECombatBehaviors.Behavior.builder()
/* 1061 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1062 */                   .withinDistance(0.0D, 5.0D)
/* 1063 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1064 */                   .addNextBehavior(
/* 1065 */                     CECombatBehaviors.Behavior.builder()
/* 1066 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1067 */                     .withinDistance(0.0D, 5.0D)
/* 1068 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1077 */       .addFirstBehavior(
/* 1078 */         CECombatBehaviors.Behavior.builder()
/* 1079 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1080 */         .withinDistance(0.0D, 3.0D)
/* 1081 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1082 */         .addNextBehavior(
/* 1083 */           CECombatBehaviors.Behavior.builder()
/* 1084 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1085 */           .withinDistance(0.0D, 3.0D)
/* 1086 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1087 */           .addNextBehavior(
/* 1088 */             CECombatBehaviors.Behavior.builder()
/* 1089 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1090 */             .withinDistance(0.0D, 4.0D)
/* 1091 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1092 */             .addNextBehavior(
/* 1093 */               CECombatBehaviors.Behavior.builder()
/* 1094 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1095 */               .withinDistance(0.0D, 4.0D)
/* 1096 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1097 */               .addNextBehavior(
/* 1098 */                 CECombatBehaviors.Behavior.builder()
/* 1099 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1100 */                 .withinDistance(0.0D, 5.0D)
/* 1101 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1102 */                 .addNextBehavior(
/* 1103 */                   CECombatBehaviors.Behavior.builder()
/* 1104 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1105 */                   .withinDistance(0.0D, 5.0D)
/* 1106 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1114 */       .addFirstBehavior(
/* 1115 */         CECombatBehaviors.Behavior.builder()
/* 1116 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1117 */         .withinDistance(0.0D, 3.0D)
/* 1118 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1119 */         .addNextBehavior(
/* 1120 */           CECombatBehaviors.Behavior.builder()
/* 1121 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1122 */           .withinDistance(0.0D, 3.0D)
/* 1123 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1124 */           .addNextBehavior(
/* 1125 */             CECombatBehaviors.Behavior.builder()
/* 1126 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1127 */             .withinDistance(0.0D, 4.0D)
/* 1128 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1129 */             .addNextBehavior(
/* 1130 */               CECombatBehaviors.Behavior.builder()
/* 1131 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1132 */               .withinDistance(0.0D, 4.0D)
/* 1133 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1134 */               .addNextBehavior(
/* 1135 */                 CECombatBehaviors.Behavior.builder()
/* 1136 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1137 */                 .withinDistance(0.0D, 5.0D)
/* 1138 */                 .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1139 */                 .addNextBehavior(
/* 1140 */                   CECombatBehaviors.Behavior.builder()
/* 1141 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1142 */                   .withinDistance(0.0D, 5.0D)
/* 1143 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1144 */                   .addNextBehavior(
/* 1145 */                     CECombatBehaviors.Behavior.builder()
/* 1146 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1147 */                     .withinDistance(0.0D, 5.0D)
/* 1148 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1157 */       .addFirstBehavior(
/* 1158 */         CECombatBehaviors.Behavior.builder()
/* 1159 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1160 */         .withinDistance(0.0D, 3.0D)
/* 1161 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1162 */         .addNextBehavior(
/* 1163 */           CECombatBehaviors.Behavior.builder()
/* 1164 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1165 */           .withinDistance(0.0D, 3.0D)
/* 1166 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1167 */           .addNextBehavior(
/* 1168 */             CECombatBehaviors.Behavior.builder()
/* 1169 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1170 */             .withinDistance(0.0D, 4.0D)
/* 1171 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1172 */             .addNextBehavior(
/* 1173 */               CECombatBehaviors.Behavior.builder()
/* 1174 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1175 */               .withinDistance(0.0D, 4.0D)
/* 1176 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1177 */               .addNextBehavior(
/* 1178 */                 CECombatBehaviors.Behavior.builder()
/* 1179 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1180 */                 .withinDistance(0.0D, 5.0D)
/* 1181 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/* 1197 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1198 */           .addNextBehavior(
/* 1199 */             CECombatBehaviors.Behavior.builder()
/* 1200 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1201 */             .withinDistance(0.0D, 4.0D)
/* 1202 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1203 */             .addNextBehavior(
/* 1204 */               CECombatBehaviors.Behavior.builder()
/* 1205 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1206 */               .withinDistance(0.0D, 4.0D)
/* 1207 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1208 */               .addNextBehavior(
/* 1209 */                 CECombatBehaviors.Behavior.builder()
/* 1210 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1211 */                 .withinDistance(0.0D, 5.0D)
/* 1212 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1213 */                 .addNextBehavior(
/* 1214 */                   CECombatBehaviors.Behavior.builder()
/* 1215 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1216 */                   .withinDistance(0.0D, 5.0D)
/* 1217 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1218 */                   .addNextBehavior(
/* 1219 */                     CECombatBehaviors.Behavior.builder()
/* 1220 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1221 */                     .withinDistance(0.0D, 5.0D)
/* 1222 */                     .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1223 */                     .addNextBehavior(
/* 1224 */                       CECombatBehaviors.Behavior.builder()
/* 1225 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1226 */                       .withinDistance(0.0D, 5.0D)
/* 1227 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1237 */       .addFirstBehavior(
/* 1238 */         CECombatBehaviors.Behavior.builder()
/* 1239 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1240 */         .withinDistance(0.0D, 3.0D)
/* 1241 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1242 */         .addNextBehavior(
/* 1243 */           CECombatBehaviors.Behavior.builder()
/* 1244 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1245 */           .withinDistance(0.0D, 3.0D)
/* 1246 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1247 */           .addNextBehavior(
/* 1248 */             CECombatBehaviors.Behavior.builder()
/* 1249 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1250 */             .withinDistance(0.0D, 4.0D)
/* 1251 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1252 */             .addNextBehavior(
/* 1253 */               CECombatBehaviors.Behavior.builder()
/* 1254 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1255 */               .withinDistance(0.0D, 4.0D)
/* 1256 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1257 */               .addNextBehavior(
/* 1258 */                 CECombatBehaviors.Behavior.builder()
/* 1259 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1260 */                 .withinDistance(0.0D, 5.0D)
/* 1261 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1262 */                 .addNextBehavior(
/* 1263 */                   CECombatBehaviors.Behavior.builder()
/* 1264 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1265 */                   .withinDistance(0.0D, 5.0D)
/* 1266 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
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
/* 1283 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1284 */           .addNextBehavior(
/* 1285 */             CECombatBehaviors.Behavior.builder()
/* 1286 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1287 */             .withinDistance(0.0D, 4.0D)
/* 1288 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1289 */             .addNextBehavior(
/* 1290 */               CECombatBehaviors.Behavior.builder()
/* 1291 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1292 */               .withinDistance(0.0D, 4.0D)
/* 1293 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1294 */               .addNextBehavior(
/* 1295 */                 CECombatBehaviors.Behavior.builder()
/* 1296 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1297 */                 .withinDistance(0.0D, 5.0D)
/* 1298 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1299 */                 .addNextBehavior(
/* 1300 */                   CECombatBehaviors.Behavior.builder()
/* 1301 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1302 */                   .withinDistance(0.0D, 5.0D)
/* 1303 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1304 */                   .addNextBehavior(
/* 1305 */                     CECombatBehaviors.Behavior.builder()
/* 1306 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1307 */                     .withinDistance(0.0D, 5.0D)
/* 1308 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
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
/* 1331 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1332 */             .addNextBehavior(
/* 1333 */               CECombatBehaviors.Behavior.builder()
/* 1334 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1335 */               .withinDistance(0.0D, 4.0D)
/* 1336 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1337 */               .addNextBehavior(
/* 1338 */                 CECombatBehaviors.Behavior.builder()
/* 1339 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1340 */                 .withinDistance(0.0D, 5.0D)
/* 1341 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1348 */       .addFirstBehavior(
/* 1349 */         CECombatBehaviors.Behavior.builder()
/* 1350 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1351 */         .withinDistance(0.0D, 3.0D)
/* 1352 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1353 */         .addNextBehavior(
/* 1354 */           CECombatBehaviors.Behavior.builder()
/* 1355 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1356 */           .withinDistance(0.0D, 3.0D)
/* 1357 */           .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1358 */           .addNextBehavior(
/* 1359 */             CECombatBehaviors.Behavior.builder()
/* 1360 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1361 */             .withinDistance(0.0D, 4.0D)
/* 1362 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1363 */             .addNextBehavior(
/* 1364 */               CECombatBehaviors.Behavior.builder()
/* 1365 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1366 */               .withinDistance(0.0D, 4.0D)
/* 1367 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1368 */               .addNextBehavior(
/* 1369 */                 CECombatBehaviors.Behavior.builder()
/* 1370 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1371 */                 .withinDistance(0.0D, 5.0D)
/* 1372 */                 .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1373 */                 .addNextBehavior(
/* 1374 */                   CECombatBehaviors.Behavior.builder()
/* 1375 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1376 */                   .withinDistance(0.0D, 5.0D)
/* 1377 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1378 */                   .addNextBehavior(
/* 1379 */                     CECombatBehaviors.Behavior.builder()
/* 1380 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1381 */                     .withinDistance(0.0D, 5.0D)
/* 1382 */                     .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1383 */                     .addNextBehavior(
/* 1384 */                       CECombatBehaviors.Behavior.builder()
/* 1385 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1386 */                       .withinDistance(0.0D, 5.0D)
/* 1387 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1397 */       .addFirstBehavior(
/* 1398 */         CECombatBehaviors.Behavior.builder()
/* 1399 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1400 */         .withinDistance(0.0D, 3.0D)
/* 1401 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1402 */         .addNextBehavior(
/* 1403 */           CECombatBehaviors.Behavior.builder()
/* 1404 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1405 */           .withinDistance(0.0D, 3.0D)
/* 1406 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1407 */           .addNextBehavior(
/* 1408 */             CECombatBehaviors.Behavior.builder()
/* 1409 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1410 */             .withinDistance(0.0D, 4.0D)
/* 1411 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1412 */             .addNextBehavior(
/* 1413 */               CECombatBehaviors.Behavior.builder()
/* 1414 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1415 */               .withinDistance(0.0D, 4.0D)
/* 1416 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1417 */               .addNextBehavior(
/* 1418 */                 CECombatBehaviors.Behavior.builder()
/* 1419 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1420 */                 .withinDistance(0.0D, 5.0D)
/* 1421 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1422 */                 .addNextBehavior(
/* 1423 */                   CECombatBehaviors.Behavior.builder()
/* 1424 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1425 */                   .withinDistance(0.0D, 5.0D)
/* 1426 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1434 */       .addFirstBehavior(
/* 1435 */         CECombatBehaviors.Behavior.builder()
/* 1436 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1437 */         .withinDistance(0.0D, 3.0D)
/* 1438 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1439 */         .addNextBehavior(
/* 1440 */           CECombatBehaviors.Behavior.builder()
/* 1441 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1442 */           .withinDistance(0.0D, 3.0D)
/* 1443 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1444 */           .addNextBehavior(
/* 1445 */             CECombatBehaviors.Behavior.builder()
/* 1446 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1447 */             .withinDistance(0.0D, 4.0D)
/* 1448 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1449 */             .addNextBehavior(
/* 1450 */               CECombatBehaviors.Behavior.builder()
/* 1451 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1452 */               .withinDistance(0.0D, 4.0D)
/* 1453 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1454 */               .addNextBehavior(
/* 1455 */                 CECombatBehaviors.Behavior.builder()
/* 1456 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1457 */                 .withinDistance(0.0D, 5.0D)
/* 1458 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1459 */                 .addNextBehavior(
/* 1460 */                   CECombatBehaviors.Behavior.builder()
/* 1461 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1462 */                   .withinDistance(0.0D, 5.0D)
/* 1463 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1464 */                   .addNextBehavior(
/* 1465 */                     CECombatBehaviors.Behavior.builder()
/* 1466 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1467 */                     .withinDistance(0.0D, 5.0D)
/* 1468 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1477 */       .addFirstBehavior(
/* 1478 */         CECombatBehaviors.Behavior.builder()
/* 1479 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1480 */         .withinDistance(0.0D, 3.0D)
/* 1481 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1482 */         .addNextBehavior(
/* 1483 */           CECombatBehaviors.Behavior.builder()
/* 1484 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1485 */           .withinDistance(0.0D, 3.0D)
/* 1486 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1487 */           .addNextBehavior(
/* 1488 */             CECombatBehaviors.Behavior.builder()
/* 1489 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1490 */             .withinDistance(0.0D, 4.0D)
/* 1491 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1492 */             .addNextBehavior(
/* 1493 */               CECombatBehaviors.Behavior.builder()
/* 1494 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1495 */               .withinDistance(0.0D, 4.0D)
/* 1496 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1497 */               .addNextBehavior(
/* 1498 */                 CECombatBehaviors.Behavior.builder()
/* 1499 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1500 */                 .withinDistance(0.0D, 5.0D)
/* 1501 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1502 */                 .addNextBehavior(
/* 1503 */                   CECombatBehaviors.Behavior.builder()
/* 1504 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1505 */                   .withinDistance(0.0D, 5.0D)
/* 1506 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1507 */                   .addNextBehavior(
/* 1508 */                     CECombatBehaviors.Behavior.builder()
/* 1509 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1510 */                     .withinDistance(0.0D, 5.0D)
/* 1511 */                     .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1512 */                     .addNextBehavior(
/* 1513 */                       CECombatBehaviors.Behavior.builder()
/* 1514 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1515 */                       .withinDistance(0.0D, 5.0D)
/* 1516 */                       .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1517 */                       .addNextBehavior(
/* 1518 */                         CECombatBehaviors.Behavior.builder()
/* 1519 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1520 */                         .withinDistance(0.0D, 5.0D)
/* 1521 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/* 1532 */       .addFirstBehavior(
/* 1533 */         CECombatBehaviors.Behavior.builder()
/* 1534 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1535 */         .withinDistance(0.0D, 3.0D)
/* 1536 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1537 */         .addNextBehavior(
/* 1538 */           CECombatBehaviors.Behavior.builder()
/* 1539 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1540 */           .withinDistance(0.0D, 3.0D)
/* 1541 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1542 */           .addNextBehavior(
/* 1543 */             CECombatBehaviors.Behavior.builder()
/* 1544 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1545 */             .withinDistance(0.0D, 4.0D)
/* 1546 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1547 */             .addNextBehavior(
/* 1548 */               CECombatBehaviors.Behavior.builder()
/* 1549 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1550 */               .withinDistance(0.0D, 4.0D)
/* 1551 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1552 */               .addNextBehavior(
/* 1553 */                 CECombatBehaviors.Behavior.builder()
/* 1554 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1555 */                 .withinDistance(0.0D, 5.0D)
/* 1556 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1557 */                 .addNextBehavior(
/* 1558 */                   CECombatBehaviors.Behavior.builder()
/* 1559 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1560 */                   .withinDistance(0.0D, 5.0D)
/* 1561 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1570 */     .newBehaviorRoot(
/* 1571 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1572 */       .priority(1.0D)
/* 1573 */       .weight(20.0D)
/* 1574 */       .maxCooldown(100)
/* 1575 */       .addFirstBehavior(
/* 1576 */         CECombatBehaviors.Behavior.builder()
/* 1577 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1578 */         .withinDistance(0.0D, 3.0D)
/* 1579 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1580 */         .addNextBehavior(
/* 1581 */           CECombatBehaviors.Behavior.builder()
/* 1582 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1583 */           .withinDistance(0.0D, 3.0D)
/* 1584 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1585 */           .addNextBehavior(
/* 1586 */             CECombatBehaviors.Behavior.builder()
/* 1587 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1588 */             .withinDistance(0.0D, 3.0D)
/* 1589 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1590 */             .addNextBehavior(
/* 1591 */               CECombatBehaviors.Behavior.builder()
/* 1592 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1593 */               .withinDistance(0.0D, 3.0D)
/* 1594 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1600 */     .newBehaviorRoot(
/* 1601 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1602 */       .priority(1.0D)
/* 1603 */       .weight(10.0D)
/* 1604 */       .maxCooldown(100)
/* 1605 */       .addFirstBehavior(
/* 1606 */         CECombatBehaviors.Behavior.builder()
/* 1607 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1608 */         .withinDistance(0.0D, 3.0D)
/* 1609 */         .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F))
/*      */       
/* 1611 */       .addFirstBehavior(
/* 1612 */         CECombatBehaviors.Behavior.builder()
/* 1613 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1614 */         .withinDistance(0.0D, 3.0D)
/* 1615 */         .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F))
/*      */       
/* 1617 */       .addFirstBehavior(
/* 1618 */         CECombatBehaviors.Behavior.builder()
/* 1619 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1620 */         .withinDistance(0.0D, 3.0D)
/* 1621 */         .animationBehavior(Animations.DANCING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 1624 */     .newBehaviorRoot(
/* 1625 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1626 */       .priority(1.0D)
/* 1627 */       .weight(10.0D)
/* 1628 */       .maxCooldown(100)
/* 1629 */       .addFirstBehavior(
/* 1630 */         CECombatBehaviors.Behavior.builder()
/* 1631 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1632 */         .withinDistance(0.0D, 3.0D)
/* 1633 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1634 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 1635 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1636 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1639 */     .newBehaviorRoot(
/* 1640 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1641 */       .priority(1.0D)
/* 1642 */       .weight(2.0D)
/* 1643 */       .maxCooldown(100)
/* 1644 */       .addFirstBehavior(
/* 1645 */         CECombatBehaviors.Behavior.builder()
/* 1646 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1647 */         .withinDistance(0.0D, 3.0D)
/* 1648 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1650 */       .addFirstBehavior(
/* 1651 */         CECombatBehaviors.Behavior.builder()
/* 1652 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1653 */         .withinDistance(0.0D, 3.0D)
/* 1654 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1656 */       .addFirstBehavior(
/* 1657 */         CECombatBehaviors.Behavior.builder()
/* 1658 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1659 */         .withinDistance(0.0D, 3.0D)
/* 1660 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1662 */       .addFirstBehavior(
/* 1663 */         CECombatBehaviors.Behavior.builder()
/* 1664 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1665 */         .withinDistance(0.0D, 3.0D)
/* 1666 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1668 */       .addFirstBehavior(
/* 1669 */         CECombatBehaviors.Behavior.builder()
/* 1670 */         .withinDistance(0.0D, 3.0D)
/* 1671 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1673 */       .addFirstBehavior(
/* 1674 */         CECombatBehaviors.Behavior.builder()
/* 1675 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1676 */         .withinDistance(0.0D, 3.0D)
/* 1677 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1679 */       .addFirstBehavior(
/* 1680 */         CECombatBehaviors.Behavior.builder()
/* 1681 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1682 */         .withinDistance(0.0D, 3.0D)
/* 1683 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1686 */     .newBehaviorRoot(
/* 1687 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1688 */       .priority(1.0D)
/* 1689 */       .weight(15.0D)
/* 1690 */       .addFirstBehavior(
/* 1691 */         CECombatBehaviors.Behavior.builder()
/* 1692 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1693 */         .withinDistance(0.0D, 3.0D)
/* 1694 */         .custom(CombatCommon::canPerformGuarding)
/* 1695 */         .guard(40)))
/*      */ 
/*      */     
/* 1698 */     .newBehaviorRoot(
/* 1699 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1700 */       .priority(1.0D)
/* 1701 */       .weight(10.0D)
/* 1702 */       .addFirstBehavior(
/* 1703 */         CECombatBehaviors.Behavior.builder()
/* 1704 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1705 */         .withinDistance(0.0D, 3.0D)
/* 1706 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1708 */       .addFirstBehavior(
/* 1709 */         CECombatBehaviors.Behavior.builder()
/* 1710 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1711 */         .withinDistance(0.0D, 3.0D)
/* 1712 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1715 */     .newBehaviorRoot(
/* 1716 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1717 */       .priority(1.0D)
/* 1718 */       .weight(40.0D)
/* 1719 */       .maxCooldown(160)
/* 1720 */       .addFirstBehavior(
/* 1721 */         CECombatBehaviors.Behavior.builder()
/* 1722 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1723 */         .custom(CombatCommon::canJump)
/* 1724 */         .withinDistance(5.0D, 14.0D)
/* 1725 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1726 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 1730 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_SWORD = CECombatBehaviors.builder()
/* 1731 */     .newBehaviorRoot(
/* 1732 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1733 */       .priority(4.0D)
/* 1734 */       .weight(1000.0D)
/* 1735 */       .maxCooldown(0)
/* 1736 */       .addFirstBehavior(
/* 1737 */         CECombatBehaviors.Behavior.builder()
/* 1738 */         .custom(CombatCommon::canExecute)
/* 1739 */         .withinDistance(0.0D, 5.0D)
/* 1740 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 1741 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 1744 */     .newBehaviorRoot(
/* 1745 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1746 */       .priority(3.0D)
/* 1747 */       .weight(1000.0D)
/* 1748 */       .maxCooldown(0)
/* 1749 */       .addFirstBehavior(
/* 1750 */         CECombatBehaviors.Behavior.builder()
/* 1751 */         .custom(CombatCommon::canEscape)
/* 1752 */         .withinDistance(0.0D, 8.0D)
/* 1753 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1754 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 1756 */       .addFirstBehavior(
/* 1757 */         CECombatBehaviors.Behavior.builder()
/* 1758 */         .custom(CombatCommon::canEscape)
/* 1759 */         .withinDistance(0.0D, 48.0D)
/* 1760 */         .guard(40)))
/*      */ 
/*      */     
/* 1763 */     .newBehaviorRoot(
/* 1764 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1765 */       .priority(2.0D)
/* 1766 */       .weight(70.0D)
/* 1767 */       .maxCooldown(0)
/* 1768 */       .addFirstBehavior(
/* 1769 */         CECombatBehaviors.Behavior.builder()
/* 1770 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 1771 */         .custom(CombatCommon::canPerformEating)
/* 1772 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1773 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 1776 */     .newBehaviorRoot(
/* 1777 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1778 */       .priority(2.0D)
/* 1779 */       .weight(100.0D)
/* 1780 */       .maxCooldown(120)
/* 1781 */       .addFirstBehavior(
/* 1782 */         CECombatBehaviors.Behavior.builder()
/* 1783 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1784 */         .custom(CombatCommon::canSwapToBow)
/* 1785 */         .withinDistance(7.0D, 14.0D)
/* 1786 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1787 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 1789 */       .addFirstBehavior(
/* 1790 */         CECombatBehaviors.Behavior.builder()
/* 1791 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1792 */         .custom(CombatCommon::canSwapToBow)
/* 1793 */         .withinDistance(7.0D, 14.0D)
/* 1794 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1795 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 1798 */     .newBehaviorRoot(
/* 1799 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1800 */       .priority(2.0D)
/* 1801 */       .weight(80.0D)
/* 1802 */       .maxCooldown(120)
/* 1803 */       .addFirstBehavior(
/* 1804 */         CECombatBehaviors.Behavior.builder()
/* 1805 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1806 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1807 */         .withinDistance(7.0D, 48.0D)
/* 1808 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1809 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 1812 */     .newBehaviorRoot(
/* 1813 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1814 */       .priority(1.0D)
/* 1815 */       .weight(40.0D)
/* 1816 */       .maxCooldown(20)
/* 1817 */       .addFirstBehavior(
/* 1818 */         CECombatBehaviors.Behavior.builder()
/* 1819 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1820 */         .withinDistance(0.0D, 3.0D)
/* 1821 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1822 */         .addNextBehavior(
/* 1823 */           CECombatBehaviors.Behavior.builder()
/* 1824 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1825 */           .withinDistance(0.0D, 3.0D)
/* 1826 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1827 */           .addNextBehavior(
/* 1828 */             CECombatBehaviors.Behavior.builder()
/* 1829 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1830 */             .withinDistance(0.0D, 3.0D)
/* 1831 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 1832 */             .addNextBehavior(
/* 1833 */               CECombatBehaviors.Behavior.builder()
/* 1834 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1835 */               .withinDistance(0.0D, 3.0D)
/* 1836 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F).addNextBehavior(
/* 1837 */                 CECombatBehaviors.Behavior.builder()
/* 1838 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1839 */                 .withinDistance(0.0D, 3.0D)
/* 1840 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1846 */       .addFirstBehavior(
/* 1847 */         CECombatBehaviors.Behavior.builder()
/* 1848 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1849 */         .withinDistance(0.0D, 3.0D)
/* 1850 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1851 */         .addNextBehavior(
/* 1852 */           CECombatBehaviors.Behavior.builder()
/* 1853 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1854 */           .withinDistance(0.0D, 3.0D)
/* 1855 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1856 */           .addNextBehavior(
/* 1857 */             CECombatBehaviors.Behavior.builder()
/* 1858 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1859 */             .withinDistance(0.0D, 4.0D)
/* 1860 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 1861 */             .addNextBehavior(
/* 1862 */               CECombatBehaviors.Behavior.builder()
/* 1863 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1864 */               .withinDistance(0.0D, 4.0D)
/* 1865 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1866 */               .addNextBehavior(
/* 1867 */                 CECombatBehaviors.Behavior.builder()
/* 1868 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1869 */                 .withinDistance(0.0D, 5.0D)
/* 1870 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1877 */       .addFirstBehavior(
/* 1878 */         CECombatBehaviors.Behavior.builder()
/* 1879 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1880 */         .withinDistance(0.0D, 3.0D)
/* 1881 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1882 */         .addNextBehavior(
/* 1883 */           CECombatBehaviors.Behavior.builder()
/* 1884 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1885 */           .withinDistance(0.0D, 3.0D)
/* 1886 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1887 */           .addNextBehavior(
/* 1888 */             CECombatBehaviors.Behavior.builder()
/* 1889 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1890 */             .withinDistance(0.0D, 4.0D)
/* 1891 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1892 */             .addNextBehavior(
/* 1893 */               CECombatBehaviors.Behavior.builder()
/* 1894 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1895 */               .withinDistance(0.0D, 4.0D)
/* 1896 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 1897 */               .addNextBehavior(
/* 1898 */                 CECombatBehaviors.Behavior.builder()
/* 1899 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1900 */                 .withinDistance(0.0D, 5.0D)
/* 1901 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1902 */                 .addNextBehavior(
/* 1903 */                   CECombatBehaviors.Behavior.builder()
/* 1904 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1905 */                   .withinDistance(0.0D, 5.0D)
/* 1906 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1914 */       .addFirstBehavior(
/* 1915 */         CECombatBehaviors.Behavior.builder()
/* 1916 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1917 */         .withinDistance(0.0D, 3.0D)
/* 1918 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1919 */         .addNextBehavior(
/* 1920 */           CECombatBehaviors.Behavior.builder()
/* 1921 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1922 */           .withinDistance(0.0D, 3.0D)
/* 1923 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1924 */           .addNextBehavior(
/* 1925 */             CECombatBehaviors.Behavior.builder()
/* 1926 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1927 */             .withinDistance(0.0D, 4.0D)
/* 1928 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1929 */             .addNextBehavior(
/* 1930 */               CECombatBehaviors.Behavior.builder()
/* 1931 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1932 */               .withinDistance(0.0D, 4.0D)
/* 1933 */               .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 1934 */               .addNextBehavior(
/* 1935 */                 CECombatBehaviors.Behavior.builder()
/* 1936 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1937 */                 .withinDistance(0.0D, 5.0D)
/* 1938 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 1939 */                 .addNextBehavior(
/* 1940 */                   CECombatBehaviors.Behavior.builder()
/* 1941 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1942 */                   .withinDistance(0.0D, 5.0D)
/* 1943 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1944 */                   .addNextBehavior(
/* 1945 */                     CECombatBehaviors.Behavior.builder()
/* 1946 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1947 */                     .withinDistance(0.0D, 5.0D)
/* 1948 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1957 */       .addFirstBehavior(
/* 1958 */         CECombatBehaviors.Behavior.builder()
/* 1959 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1960 */         .withinDistance(0.0D, 3.0D)
/* 1961 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 1962 */         .addNextBehavior(
/* 1963 */           CECombatBehaviors.Behavior.builder()
/* 1964 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1965 */           .withinDistance(0.0D, 3.0D)
/* 1966 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1967 */           .addNextBehavior(
/* 1968 */             CECombatBehaviors.Behavior.builder()
/* 1969 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1970 */             .withinDistance(0.0D, 4.0D)
/* 1971 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 1972 */             .addNextBehavior(
/* 1973 */               CECombatBehaviors.Behavior.builder()
/* 1974 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1975 */               .withinDistance(0.0D, 4.0D)
/* 1976 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1977 */               .addNextBehavior(
/* 1978 */                 CECombatBehaviors.Behavior.builder()
/* 1979 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1980 */                 .withinDistance(0.0D, 5.0D)
/* 1981 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1988 */       .addFirstBehavior(
/* 1989 */         CECombatBehaviors.Behavior.builder()
/* 1990 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1991 */         .withinDistance(0.0D, 3.0D)
/* 1992 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 1993 */         .addNextBehavior(
/* 1994 */           CECombatBehaviors.Behavior.builder()
/* 1995 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1996 */           .withinDistance(0.0D, 3.0D)
/* 1997 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1998 */           .addNextBehavior(
/* 1999 */             CECombatBehaviors.Behavior.builder()
/* 2000 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2001 */             .withinDistance(0.0D, 4.0D)
/* 2002 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 2003 */             .addNextBehavior(
/* 2004 */               CECombatBehaviors.Behavior.builder()
/* 2005 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2006 */               .withinDistance(0.0D, 4.0D)
/* 2007 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2008 */               .addNextBehavior(
/* 2009 */                 CECombatBehaviors.Behavior.builder()
/* 2010 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2011 */                 .withinDistance(0.0D, 5.0D)
/* 2012 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2013 */                 .addNextBehavior(
/* 2014 */                   CECombatBehaviors.Behavior.builder()
/* 2015 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2016 */                   .withinDistance(0.0D, 5.0D)
/* 2017 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2025 */       .addFirstBehavior(
/* 2026 */         CECombatBehaviors.Behavior.builder()
/* 2027 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2028 */         .withinDistance(0.0D, 3.0D)
/* 2029 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2030 */         .addNextBehavior(
/* 2031 */           CECombatBehaviors.Behavior.builder()
/* 2032 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2033 */           .withinDistance(0.0D, 3.0D)
/* 2034 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2035 */           .addNextBehavior(
/* 2036 */             CECombatBehaviors.Behavior.builder()
/* 2037 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2038 */             .withinDistance(0.0D, 4.0D)
/* 2039 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2040 */             .addNextBehavior(
/* 2041 */               CECombatBehaviors.Behavior.builder()
/* 2042 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2043 */               .withinDistance(0.0D, 4.0D)
/* 2044 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2045 */               .addNextBehavior(
/* 2046 */                 CECombatBehaviors.Behavior.builder()
/* 2047 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2048 */                 .withinDistance(0.0D, 5.0D)
/* 2049 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2050 */                 .addNextBehavior(
/* 2051 */                   CECombatBehaviors.Behavior.builder()
/* 2052 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2053 */                   .withinDistance(0.0D, 5.0D)
/* 2054 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2055 */                   .addNextBehavior(
/* 2056 */                     CECombatBehaviors.Behavior.builder()
/* 2057 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2058 */                     .withinDistance(0.0D, 5.0D)
/* 2059 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2068 */       .addFirstBehavior(
/* 2069 */         CECombatBehaviors.Behavior.builder()
/* 2070 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2071 */         .withinDistance(0.0D, 3.0D)
/* 2072 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2073 */         .addNextBehavior(
/* 2074 */           CECombatBehaviors.Behavior.builder()
/* 2075 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2076 */           .withinDistance(0.0D, 3.0D)
/* 2077 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2078 */           .addNextBehavior(
/* 2079 */             CECombatBehaviors.Behavior.builder()
/* 2080 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2081 */             .withinDistance(0.0D, 4.0D)
/* 2082 */             .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 2083 */             .addNextBehavior(
/* 2084 */               CECombatBehaviors.Behavior.builder()
/* 2085 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2086 */               .withinDistance(0.0D, 4.0D)
/* 2087 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 2088 */               .addNextBehavior(
/* 2089 */                 CECombatBehaviors.Behavior.builder()
/* 2090 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2091 */                 .withinDistance(0.0D, 5.0D)
/* 2092 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2099 */       .addFirstBehavior(
/* 2100 */         CECombatBehaviors.Behavior.builder()
/* 2101 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2102 */         .withinDistance(0.0D, 3.0D)
/* 2103 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2104 */         .addNextBehavior(
/* 2105 */           CECombatBehaviors.Behavior.builder()
/* 2106 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2107 */           .withinDistance(0.0D, 3.0D)
/* 2108 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 2109 */           .addNextBehavior(
/* 2110 */             CECombatBehaviors.Behavior.builder()
/* 2111 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2112 */             .withinDistance(0.0D, 4.0D)
/* 2113 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2114 */             .addNextBehavior(
/* 2115 */               CECombatBehaviors.Behavior.builder()
/* 2116 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2117 */               .withinDistance(0.0D, 4.0D)
/* 2118 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2119 */               .addNextBehavior(
/* 2120 */                 CECombatBehaviors.Behavior.builder()
/* 2121 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2122 */                 .withinDistance(0.0D, 5.0D)
/* 2123 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2124 */                 .addNextBehavior(
/* 2125 */                   CECombatBehaviors.Behavior.builder()
/* 2126 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2127 */                   .withinDistance(0.0D, 5.0D)
/* 2128 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2136 */       .addFirstBehavior(
/* 2137 */         CECombatBehaviors.Behavior.builder()
/* 2138 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2139 */         .withinDistance(0.0D, 3.0D)
/* 2140 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2141 */         .addNextBehavior(
/* 2142 */           CECombatBehaviors.Behavior.builder()
/* 2143 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2144 */           .withinDistance(0.0D, 3.0D)
/* 2145 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2146 */           .addNextBehavior(
/* 2147 */             CECombatBehaviors.Behavior.builder()
/* 2148 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2149 */             .withinDistance(0.0D, 4.0D)
/* 2150 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2151 */             .addNextBehavior(
/* 2152 */               CECombatBehaviors.Behavior.builder()
/* 2153 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2154 */               .withinDistance(0.0D, 4.0D)
/* 2155 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2156 */               .addNextBehavior(
/* 2157 */                 CECombatBehaviors.Behavior.builder()
/* 2158 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2159 */                 .withinDistance(0.0D, 5.0D)
/* 2160 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2161 */                 .addNextBehavior(
/* 2162 */                   CECombatBehaviors.Behavior.builder()
/* 2163 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2164 */                   .withinDistance(0.0D, 5.0D)
/* 2165 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2166 */                   .addNextBehavior(
/* 2167 */                     CECombatBehaviors.Behavior.builder()
/* 2168 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2169 */                     .withinDistance(0.0D, 5.0D)
/* 2170 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2179 */       .addFirstBehavior(
/* 2180 */         CECombatBehaviors.Behavior.builder()
/* 2181 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2182 */         .withinDistance(0.0D, 3.0D)
/* 2183 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2184 */         .addNextBehavior(
/* 2185 */           CECombatBehaviors.Behavior.builder()
/* 2186 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2187 */           .withinDistance(0.0D, 3.0D)
/* 2188 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2189 */           .addNextBehavior(
/* 2190 */             CECombatBehaviors.Behavior.builder()
/* 2191 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2192 */             .withinDistance(0.0D, 4.0D)
/* 2193 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2194 */             .addNextBehavior(
/* 2195 */               CECombatBehaviors.Behavior.builder()
/* 2196 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2197 */               .withinDistance(0.0D, 4.0D)
/* 2198 */               .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 2199 */               .addNextBehavior(
/* 2200 */                 CECombatBehaviors.Behavior.builder()
/* 2201 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2202 */                 .withinDistance(0.0D, 5.0D)
/* 2203 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2204 */                 .addNextBehavior(
/* 2205 */                   CECombatBehaviors.Behavior.builder()
/* 2206 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2207 */                   .withinDistance(0.0D, 5.0D)
/* 2208 */                   .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 2209 */                   .addNextBehavior(
/* 2210 */                     CECombatBehaviors.Behavior.builder()
/* 2211 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2212 */                     .withinDistance(0.0D, 5.0D)
/* 2213 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2222 */       .addFirstBehavior(
/* 2223 */         CECombatBehaviors.Behavior.builder()
/* 2224 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2225 */         .withinDistance(0.0D, 3.0D)
/* 2226 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 2227 */         .addNextBehavior(
/* 2228 */           CECombatBehaviors.Behavior.builder()
/* 2229 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2230 */           .withinDistance(0.0D, 3.0D)
/* 2231 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2232 */           .addNextBehavior(
/* 2233 */             CECombatBehaviors.Behavior.builder()
/* 2234 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2235 */             .withinDistance(0.0D, 4.0D)
/* 2236 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/* 2237 */             .addNextBehavior(
/* 2238 */               CECombatBehaviors.Behavior.builder()
/* 2239 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2240 */               .withinDistance(0.0D, 4.0D)
/* 2241 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2242 */               .addNextBehavior(
/* 2243 */                 CECombatBehaviors.Behavior.builder()
/* 2244 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2245 */                 .withinDistance(0.0D, 5.0D)
/* 2246 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2253 */       .addFirstBehavior(
/* 2254 */         CECombatBehaviors.Behavior.builder()
/* 2255 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2256 */         .withinDistance(0.0D, 3.0D)
/* 2257 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2258 */         .addNextBehavior(
/* 2259 */           CECombatBehaviors.Behavior.builder()
/* 2260 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2261 */           .withinDistance(0.0D, 3.0D)
/* 2262 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2263 */           .addNextBehavior(
/* 2264 */             CECombatBehaviors.Behavior.builder()
/* 2265 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2266 */             .withinDistance(0.0D, 4.0D)
/* 2267 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2268 */             .addNextBehavior(
/* 2269 */               CECombatBehaviors.Behavior.builder()
/* 2270 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2271 */               .withinDistance(0.0D, 4.0D)
/* 2272 */               .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 2273 */               .addNextBehavior(
/* 2274 */                 CECombatBehaviors.Behavior.builder()
/* 2275 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2276 */                 .withinDistance(0.0D, 5.0D)
/* 2277 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2278 */                 .addNextBehavior(
/* 2279 */                   CECombatBehaviors.Behavior.builder()
/* 2280 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2281 */                   .withinDistance(0.0D, 5.0D)
/* 2282 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2290 */       .addFirstBehavior(
/* 2291 */         CECombatBehaviors.Behavior.builder()
/* 2292 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2293 */         .withinDistance(0.0D, 3.0D)
/* 2294 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 2295 */         .addNextBehavior(
/* 2296 */           CECombatBehaviors.Behavior.builder()
/* 2297 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2298 */           .withinDistance(0.0D, 3.0D)
/* 2299 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2300 */           .addNextBehavior(
/* 2301 */             CECombatBehaviors.Behavior.builder()
/* 2302 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2303 */             .withinDistance(0.0D, 4.0D)
/* 2304 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2305 */             .addNextBehavior(
/* 2306 */               CECombatBehaviors.Behavior.builder()
/* 2307 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2308 */               .withinDistance(0.0D, 4.0D)
/* 2309 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2310 */               .addNextBehavior(
/* 2311 */                 CECombatBehaviors.Behavior.builder()
/* 2312 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2313 */                 .withinDistance(0.0D, 5.0D)
/* 2314 */                 .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 2315 */                 .addNextBehavior(
/* 2316 */                   CECombatBehaviors.Behavior.builder()
/* 2317 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2318 */                   .withinDistance(0.0D, 5.0D)
/* 2319 */                   .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2320 */                   .addNextBehavior(
/* 2321 */                     CECombatBehaviors.Behavior.builder()
/* 2322 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2323 */                     .withinDistance(0.0D, 5.0D)
/* 2324 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2333 */       .addFirstBehavior(
/* 2334 */         CECombatBehaviors.Behavior.builder()
/* 2335 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2336 */         .withinDistance(0.0D, 3.0D)
/* 2337 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 2338 */         .addNextBehavior(
/* 2339 */           CECombatBehaviors.Behavior.builder()
/* 2340 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2341 */           .withinDistance(0.0D, 3.0D)
/* 2342 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2343 */           .addNextBehavior(
/* 2344 */             CECombatBehaviors.Behavior.builder()
/* 2345 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2346 */             .withinDistance(0.0D, 4.0D)
/* 2347 */             .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2348 */             .addNextBehavior(
/* 2349 */               CECombatBehaviors.Behavior.builder()
/* 2350 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2351 */               .withinDistance(0.0D, 4.0D)
/* 2352 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/* 2353 */               .addNextBehavior(
/* 2354 */                 CECombatBehaviors.Behavior.builder()
/* 2355 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2356 */                 .withinDistance(0.0D, 5.0D)
/* 2357 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/* 2358 */                 .addNextBehavior(
/* 2359 */                   CECombatBehaviors.Behavior.builder()
/* 2360 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2361 */                   .withinDistance(0.0D, 5.0D)
/* 2362 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2370 */       .addFirstBehavior(
/* 2371 */         CECombatBehaviors.Behavior.builder()
/* 2372 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2373 */         .withinDistance(0.0D, 3.0D)
/* 2374 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/* 2375 */         .addNextBehavior(
/* 2376 */           CECombatBehaviors.Behavior.builder()
/* 2377 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2378 */           .withinDistance(0.0D, 3.0D)
/* 2379 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/* 2380 */           .addNextBehavior(
/* 2381 */             CECombatBehaviors.Behavior.builder()
/* 2382 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2383 */             .withinDistance(0.0D, 4.0D)
/* 2384 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2385 */             .addNextBehavior(
/* 2386 */               CECombatBehaviors.Behavior.builder()
/* 2387 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2388 */               .withinDistance(0.0D, 4.0D)
/* 2389 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2390 */               .addNextBehavior(
/* 2391 */                 CECombatBehaviors.Behavior.builder()
/* 2392 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2393 */                 .withinDistance(0.0D, 5.0D)
/* 2394 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/* 2395 */                 .addNextBehavior(
/* 2396 */                   CECombatBehaviors.Behavior.builder()
/* 2397 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2398 */                   .withinDistance(0.0D, 5.0D)
/* 2399 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2407 */     .newBehaviorRoot(
/* 2408 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2409 */       .priority(1.0D)
/* 2410 */       .weight(20.0D)
/* 2411 */       .maxCooldown(100)
/* 2412 */       .addFirstBehavior(
/* 2413 */         CECombatBehaviors.Behavior.builder()
/* 2414 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2415 */         .withinDistance(0.0D, 3.0D)
/* 2416 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2417 */         .addNextBehavior(
/* 2418 */           CECombatBehaviors.Behavior.builder()
/* 2419 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2420 */           .withinDistance(0.0D, 3.0D)
/* 2421 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2422 */           .addNextBehavior(
/* 2423 */             CECombatBehaviors.Behavior.builder()
/* 2424 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2425 */             .withinDistance(0.0D, 3.0D)
/* 2426 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2431 */     .newBehaviorRoot(
/* 2432 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2433 */       .priority(1.0D)
/* 2434 */       .weight(10.0D)
/* 2435 */       .maxCooldown(100)
/* 2436 */       .addFirstBehavior(
/* 2437 */         CECombatBehaviors.Behavior.builder()
/* 2438 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2439 */         .withinDistance(0.0D, 3.0D)
/* 2440 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*      */       
/* 2442 */       .addFirstBehavior(
/* 2443 */         CECombatBehaviors.Behavior.builder()
/* 2444 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2445 */         .withinDistance(0.0D, 3.0D)
/* 2446 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*      */       
/* 2448 */       .addFirstBehavior(
/* 2449 */         CECombatBehaviors.Behavior.builder()
/* 2450 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2451 */         .withinDistance(0.0D, 3.0D)
/* 2452 */         .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 2455 */     .newBehaviorRoot(
/* 2456 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2457 */       .priority(1.0D)
/* 2458 */       .weight(10.0D)
/* 2459 */       .maxCooldown(40)
/* 2460 */       .addFirstBehavior(
/* 2461 */         CECombatBehaviors.Behavior.builder()
/* 2462 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2463 */         .withinDistance(0.0D, 3.0D)
/* 2464 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2465 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 2466 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2467 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 2470 */     .newBehaviorRoot(
/* 2471 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2472 */       .priority(1.0D)
/* 2473 */       .weight(2.0D)
/* 2474 */       .maxCooldown(100)
/* 2475 */       .addFirstBehavior(
/* 2476 */         CECombatBehaviors.Behavior.builder()
/* 2477 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2478 */         .withinDistance(0.0D, 3.0D)
/* 2479 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 2481 */       .addFirstBehavior(
/* 2482 */         CECombatBehaviors.Behavior.builder()
/* 2483 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2484 */         .withinDistance(0.0D, 3.0D)
/* 2485 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 2487 */       .addFirstBehavior(
/* 2488 */         CECombatBehaviors.Behavior.builder()
/* 2489 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2490 */         .withinDistance(0.0D, 3.0D)
/* 2491 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 2493 */       .addFirstBehavior(
/* 2494 */         CECombatBehaviors.Behavior.builder()
/* 2495 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2496 */         .withinDistance(0.0D, 3.0D)
/* 2497 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 2499 */       .addFirstBehavior(
/* 2500 */         CECombatBehaviors.Behavior.builder()
/* 2501 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2502 */         .withinDistance(0.0D, 3.0D)
/* 2503 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 2505 */       .addFirstBehavior(
/* 2506 */         CECombatBehaviors.Behavior.builder()
/* 2507 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2508 */         .withinDistance(0.0D, 3.0D)
/* 2509 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 2511 */       .addFirstBehavior(
/* 2512 */         CECombatBehaviors.Behavior.builder()
/* 2513 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2514 */         .withinDistance(0.0D, 3.0D)
/* 2515 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 2518 */     .newBehaviorRoot(
/* 2519 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2520 */       .priority(1.0D)
/* 2521 */       .weight(15.0D)
/* 2522 */       .addFirstBehavior(
/* 2523 */         CECombatBehaviors.Behavior.builder()
/* 2524 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2525 */         .withinDistance(0.0D, 3.0D)
/* 2526 */         .custom(CombatCommon::canPerformGuarding)
/* 2527 */         .guard(40)))
/*      */ 
/*      */     
/* 2530 */     .newBehaviorRoot(
/* 2531 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2532 */       .priority(1.0D)
/* 2533 */       .weight(10.0D)
/* 2534 */       .addFirstBehavior(
/* 2535 */         CECombatBehaviors.Behavior.builder()
/* 2536 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2537 */         .withinDistance(0.0D, 3.0D)
/* 2538 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 2540 */       .addFirstBehavior(
/* 2541 */         CECombatBehaviors.Behavior.builder()
/* 2542 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2543 */         .withinDistance(0.0D, 3.0D)
/* 2544 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 2547 */     .newBehaviorRoot(
/* 2548 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2549 */       .priority(1.0D)
/* 2550 */       .weight(40.0D)
/* 2551 */       .maxCooldown(160)
/* 2552 */       .addFirstBehavior(
/* 2553 */         CECombatBehaviors.Behavior.builder()
/* 2554 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2555 */         .custom(CombatCommon::canJump)
/* 2556 */         .withinDistance(5.0D, 14.0D)
/* 2557 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2558 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 2562 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_DUAL_SWORD = CECombatBehaviors.builder()
/* 2563 */     .newBehaviorRoot(
/* 2564 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2565 */       .priority(4.0D)
/* 2566 */       .weight(1000.0D)
/* 2567 */       .maxCooldown(0)
/* 2568 */       .addFirstBehavior(
/* 2569 */         CECombatBehaviors.Behavior.builder()
/* 2570 */         .custom(CombatCommon::canExecute)
/* 2571 */         .withinDistance(0.0D, 5.0D)
/* 2572 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 2573 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 2576 */     .newBehaviorRoot(
/* 2577 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2578 */       .priority(3.0D)
/* 2579 */       .weight(1000.0D)
/* 2580 */       .maxCooldown(0)
/* 2581 */       .addFirstBehavior(
/* 2582 */         CECombatBehaviors.Behavior.builder()
/* 2583 */         .custom(CombatCommon::canEscape)
/* 2584 */         .withinDistance(0.0D, 8.0D)
/* 2585 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2586 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 2588 */       .addFirstBehavior(
/* 2589 */         CECombatBehaviors.Behavior.builder()
/* 2590 */         .custom(CombatCommon::canEscape)
/* 2591 */         .withinDistance(0.0D, 48.0D)
/* 2592 */         .guard(40)))
/*      */ 
/*      */     
/* 2595 */     .newBehaviorRoot(
/* 2596 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2597 */       .priority(2.0D)
/* 2598 */       .weight(70.0D)
/* 2599 */       .maxCooldown(0)
/* 2600 */       .addFirstBehavior(
/* 2601 */         CECombatBehaviors.Behavior.builder()
/* 2602 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 2603 */         .custom(CombatCommon::canPerformEating)
/* 2604 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2605 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 2608 */     .newBehaviorRoot(
/* 2609 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2610 */       .priority(2.0D)
/* 2611 */       .weight(100.0D)
/* 2612 */       .maxCooldown(120)
/* 2613 */       .addFirstBehavior(
/* 2614 */         CECombatBehaviors.Behavior.builder()
/* 2615 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2616 */         .custom(CombatCommon::canSwapToBow)
/* 2617 */         .withinDistance(7.0D, 14.0D)
/* 2618 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2619 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 2621 */       .addFirstBehavior(
/* 2622 */         CECombatBehaviors.Behavior.builder()
/* 2623 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2624 */         .custom(CombatCommon::canSwapToBow)
/* 2625 */         .withinDistance(7.0D, 14.0D)
/* 2626 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 2627 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 2630 */     .newBehaviorRoot(
/* 2631 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2632 */       .priority(2.0D)
/* 2633 */       .weight(80.0D)
/* 2634 */       .maxCooldown(120)
/* 2635 */       .addFirstBehavior(
/* 2636 */         CECombatBehaviors.Behavior.builder()
/* 2637 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2638 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2639 */         .withinDistance(7.0D, 48.0D)
/* 2640 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2641 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 2644 */     .newBehaviorRoot(
/* 2645 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2646 */       .priority(1.0D)
/* 2647 */       .weight(40.0D)
/* 2648 */       .maxCooldown(20)
/* 2649 */       .addFirstBehavior(
/* 2650 */         CECombatBehaviors.Behavior.builder()
/* 2651 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2652 */         .withinDistance(0.0D, 3.0D)
/* 2653 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2654 */         .addNextBehavior(
/* 2655 */           CECombatBehaviors.Behavior.builder()
/* 2656 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2657 */           .withinDistance(0.0D, 3.0D)
/* 2658 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2659 */           .addNextBehavior(
/* 2660 */             CECombatBehaviors.Behavior.builder()
/* 2661 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2662 */             .withinDistance(0.0D, 3.0D)
/* 2663 */             .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 2664 */             .addNextBehavior(
/* 2665 */               CECombatBehaviors.Behavior.builder()
/* 2666 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2667 */               .withinDistance(0.0D, 3.0D)
/* 2668 */               .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F).addNextBehavior(
/* 2669 */                 CECombatBehaviors.Behavior.builder()
/* 2670 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2671 */                 .withinDistance(0.0D, 3.0D)
/* 2672 */                 .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 2673 */                 .addNextBehavior(
/* 2674 */                   CECombatBehaviors.Behavior.builder()
/* 2675 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2676 */                   .withinDistance(0.0D, 3.0D)
/* 2677 */                   .animationBehavior(AVAnimations.DUAL_SWORD3, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2684 */       .addFirstBehavior(
/* 2685 */         CECombatBehaviors.Behavior.builder()
/* 2686 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2687 */         .withinDistance(0.0D, 3.0D)
/* 2688 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2689 */         .addNextBehavior(
/* 2690 */           CECombatBehaviors.Behavior.builder()
/* 2691 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2692 */           .withinDistance(0.0D, 3.0D)
/* 2693 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2694 */           .addNextBehavior(
/* 2695 */             CECombatBehaviors.Behavior.builder()
/* 2696 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2697 */             .withinDistance(0.0D, 4.0D)
/* 2698 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2699 */             .addNextBehavior(
/* 2700 */               CECombatBehaviors.Behavior.builder()
/* 2701 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2702 */               .withinDistance(0.0D, 4.0D)
/* 2703 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2704 */               .addNextBehavior(
/* 2705 */                 CECombatBehaviors.Behavior.builder()
/* 2706 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2707 */                 .withinDistance(0.0D, 5.0D)
/* 2708 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2709 */                 .addNextBehavior(
/* 2710 */                   CECombatBehaviors.Behavior.builder()
/* 2711 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2712 */                   .withinDistance(0.0D, 5.0D)
/* 2713 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2721 */       .addFirstBehavior(
/* 2722 */         CECombatBehaviors.Behavior.builder()
/* 2723 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2724 */         .withinDistance(0.0D, 3.0D)
/* 2725 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2726 */         .addNextBehavior(
/* 2727 */           CECombatBehaviors.Behavior.builder()
/* 2728 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2729 */           .withinDistance(0.0D, 3.0D)
/* 2730 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2731 */           .addNextBehavior(
/* 2732 */             CECombatBehaviors.Behavior.builder()
/* 2733 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2734 */             .withinDistance(0.0D, 4.0D)
/* 2735 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2736 */             .addNextBehavior(
/* 2737 */               CECombatBehaviors.Behavior.builder()
/* 2738 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2739 */               .withinDistance(0.0D, 4.0D)
/* 2740 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2741 */               .addNextBehavior(
/* 2742 */                 CECombatBehaviors.Behavior.builder()
/* 2743 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2744 */                 .withinDistance(0.0D, 5.0D)
/* 2745 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2746 */                 .addNextBehavior(
/* 2747 */                   CECombatBehaviors.Behavior.builder()
/* 2748 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2749 */                   .withinDistance(0.0D, 5.0D)
/* 2750 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2758 */       .addFirstBehavior(
/* 2759 */         CECombatBehaviors.Behavior.builder()
/* 2760 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2761 */         .withinDistance(0.0D, 3.0D)
/* 2762 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2763 */         .addNextBehavior(
/* 2764 */           CECombatBehaviors.Behavior.builder()
/* 2765 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2766 */           .withinDistance(0.0D, 3.0D)
/* 2767 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2768 */           .addNextBehavior(
/* 2769 */             CECombatBehaviors.Behavior.builder()
/* 2770 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2771 */             .withinDistance(0.0D, 4.0D)
/* 2772 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2773 */             .addNextBehavior(
/* 2774 */               CECombatBehaviors.Behavior.builder()
/* 2775 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2776 */               .withinDistance(0.0D, 4.0D)
/* 2777 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2778 */               .addNextBehavior(
/* 2779 */                 CECombatBehaviors.Behavior.builder()
/* 2780 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2781 */                 .withinDistance(0.0D, 5.0D)
/* 2782 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 2783 */                 .addNextBehavior(
/* 2784 */                   CECombatBehaviors.Behavior.builder()
/* 2785 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2786 */                   .withinDistance(0.0D, 5.0D)
/* 2787 */                   .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2788 */                   .addNextBehavior(
/* 2789 */                     CECombatBehaviors.Behavior.builder()
/* 2790 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2791 */                     .withinDistance(0.0D, 5.0D)
/* 2792 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2801 */       .addFirstBehavior(
/* 2802 */         CECombatBehaviors.Behavior.builder()
/* 2803 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2804 */         .withinDistance(0.0D, 3.0D)
/* 2805 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2806 */         .addNextBehavior(
/* 2807 */           CECombatBehaviors.Behavior.builder()
/* 2808 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2809 */           .withinDistance(0.0D, 3.0D)
/* 2810 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2811 */           .addNextBehavior(
/* 2812 */             CECombatBehaviors.Behavior.builder()
/* 2813 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2814 */             .withinDistance(0.0D, 4.0D)
/* 2815 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2816 */             .addNextBehavior(
/* 2817 */               CECombatBehaviors.Behavior.builder()
/* 2818 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2819 */               .withinDistance(0.0D, 4.0D)
/* 2820 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2821 */               .addNextBehavior(
/* 2822 */                 CECombatBehaviors.Behavior.builder()
/* 2823 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2824 */                 .withinDistance(0.0D, 5.0D)
/* 2825 */                 .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2826 */                 .addNextBehavior(
/* 2827 */                   CECombatBehaviors.Behavior.builder()
/* 2828 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2829 */                   .withinDistance(0.0D, 5.0D)
/* 2830 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2838 */       .addFirstBehavior(
/* 2839 */         CECombatBehaviors.Behavior.builder()
/* 2840 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2841 */         .withinDistance(0.0D, 3.0D)
/* 2842 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2843 */         .addNextBehavior(
/* 2844 */           CECombatBehaviors.Behavior.builder()
/* 2845 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2846 */           .withinDistance(0.0D, 3.0D)
/* 2847 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2848 */           .addNextBehavior(
/* 2849 */             CECombatBehaviors.Behavior.builder()
/* 2850 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2851 */             .withinDistance(0.0D, 4.0D)
/* 2852 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2853 */             .addNextBehavior(
/* 2854 */               CECombatBehaviors.Behavior.builder()
/* 2855 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2856 */               .withinDistance(0.0D, 4.0D)
/* 2857 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2858 */               .addNextBehavior(
/* 2859 */                 CECombatBehaviors.Behavior.builder()
/* 2860 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2861 */                 .withinDistance(0.0D, 5.0D)
/* 2862 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 2863 */                 .addNextBehavior(
/* 2864 */                   CECombatBehaviors.Behavior.builder()
/* 2865 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2866 */                   .withinDistance(0.0D, 5.0D)
/* 2867 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2868 */                   .addNextBehavior(
/* 2869 */                     CECombatBehaviors.Behavior.builder()
/* 2870 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2871 */                     .withinDistance(0.0D, 5.0D)
/* 2872 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2881 */       .addFirstBehavior(
/* 2882 */         CECombatBehaviors.Behavior.builder()
/* 2883 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2884 */         .withinDistance(0.0D, 3.0D)
/* 2885 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2886 */         .addNextBehavior(
/* 2887 */           CECombatBehaviors.Behavior.builder()
/* 2888 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2889 */           .withinDistance(0.0D, 3.0D)
/* 2890 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 2891 */           .addNextBehavior(
/* 2892 */             CECombatBehaviors.Behavior.builder()
/* 2893 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2894 */             .withinDistance(0.0D, 4.0D)
/* 2895 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2896 */             .addNextBehavior(
/* 2897 */               CECombatBehaviors.Behavior.builder()
/* 2898 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2899 */               .withinDistance(0.0D, 4.0D)
/* 2900 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2901 */               .addNextBehavior(
/* 2902 */                 CECombatBehaviors.Behavior.builder()
/* 2903 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2904 */                 .withinDistance(0.0D, 5.0D)
/* 2905 */                 .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2906 */                 .addNextBehavior(
/* 2907 */                   CECombatBehaviors.Behavior.builder()
/* 2908 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2909 */                   .withinDistance(0.0D, 5.0D)
/* 2910 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2918 */       .addFirstBehavior(
/* 2919 */         CECombatBehaviors.Behavior.builder()
/* 2920 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2921 */         .withinDistance(0.0D, 3.0D)
/* 2922 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2923 */         .addNextBehavior(
/* 2924 */           CECombatBehaviors.Behavior.builder()
/* 2925 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2926 */           .withinDistance(0.0D, 3.0D)
/* 2927 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2928 */           .addNextBehavior(
/* 2929 */             CECombatBehaviors.Behavior.builder()
/* 2930 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2931 */             .withinDistance(0.0D, 4.0D)
/* 2932 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2933 */             .addNextBehavior(
/* 2934 */               CECombatBehaviors.Behavior.builder()
/* 2935 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2936 */               .withinDistance(0.0D, 4.0D)
/* 2937 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2938 */               .addNextBehavior(
/* 2939 */                 CECombatBehaviors.Behavior.builder()
/* 2940 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2941 */                 .withinDistance(0.0D, 5.0D)
/* 2942 */                 .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 2943 */                 .addNextBehavior(
/* 2944 */                   CECombatBehaviors.Behavior.builder()
/* 2945 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2946 */                   .withinDistance(0.0D, 5.0D)
/* 2947 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2948 */                   .addNextBehavior(
/* 2949 */                     CECombatBehaviors.Behavior.builder()
/* 2950 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2951 */                     .withinDistance(0.0D, 5.0D)
/* 2952 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*      */ 
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
/* 2965 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2966 */         .addNextBehavior(
/* 2967 */           CECombatBehaviors.Behavior.builder()
/* 2968 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2969 */           .withinDistance(0.0D, 3.0D)
/* 2970 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2971 */           .addNextBehavior(
/* 2972 */             CECombatBehaviors.Behavior.builder()
/* 2973 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2974 */             .withinDistance(0.0D, 4.0D)
/* 2975 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2976 */             .addNextBehavior(
/* 2977 */               CECombatBehaviors.Behavior.builder()
/* 2978 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2979 */               .withinDistance(0.0D, 4.0D)
/* 2980 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2981 */               .addNextBehavior(
/* 2982 */                 CECombatBehaviors.Behavior.builder()
/* 2983 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2984 */                 .withinDistance(0.0D, 5.0D)
/* 2985 */                 .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 2986 */                 .addNextBehavior(
/* 2987 */                   CECombatBehaviors.Behavior.builder()
/* 2988 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2989 */                   .withinDistance(0.0D, 5.0D)
/* 2990 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2991 */                   .addNextBehavior(
/* 2992 */                     CECombatBehaviors.Behavior.builder()
/* 2993 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2994 */                     .withinDistance(0.0D, 5.0D)
/* 2995 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3004 */       .addFirstBehavior(
/* 3005 */         CECombatBehaviors.Behavior.builder()
/* 3006 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3007 */         .withinDistance(0.0D, 3.0D)
/* 3008 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3009 */         .addNextBehavior(
/* 3010 */           CECombatBehaviors.Behavior.builder()
/* 3011 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3012 */           .withinDistance(0.0D, 3.0D)
/* 3013 */           .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 3014 */           .addNextBehavior(
/* 3015 */             CECombatBehaviors.Behavior.builder()
/* 3016 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3017 */             .withinDistance(0.0D, 4.0D)
/* 3018 */             .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3019 */             .addNextBehavior(
/* 3020 */               CECombatBehaviors.Behavior.builder()
/* 3021 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3022 */               .withinDistance(0.0D, 4.0D)
/* 3023 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 3024 */               .addNextBehavior(
/* 3025 */                 CECombatBehaviors.Behavior.builder()
/* 3026 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3027 */                 .withinDistance(0.0D, 5.0D)
/* 3028 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 3029 */                 .addNextBehavior(
/* 3030 */                   CECombatBehaviors.Behavior.builder()
/* 3031 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3032 */                   .withinDistance(0.0D, 5.0D)
/* 3033 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
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
/* 3045 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3046 */         .addNextBehavior(
/* 3047 */           CECombatBehaviors.Behavior.builder()
/* 3048 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3049 */           .withinDistance(0.0D, 3.0D)
/* 3050 */           .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 3051 */           .addNextBehavior(
/* 3052 */             CECombatBehaviors.Behavior.builder()
/* 3053 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3054 */             .withinDistance(0.0D, 4.0D)
/* 3055 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3056 */             .addNextBehavior(
/* 3057 */               CECombatBehaviors.Behavior.builder()
/* 3058 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3059 */               .withinDistance(0.0D, 4.0D)
/* 3060 */               .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 3061 */               .addNextBehavior(
/* 3062 */                 CECombatBehaviors.Behavior.builder()
/* 3063 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3064 */                 .withinDistance(0.0D, 5.0D)
/* 3065 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 3066 */                 .addNextBehavior(
/* 3067 */                   CECombatBehaviors.Behavior.builder()
/* 3068 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3069 */                   .withinDistance(0.0D, 5.0D)
/* 3070 */                   .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 3071 */                   .addNextBehavior(
/* 3072 */                     CECombatBehaviors.Behavior.builder()
/* 3073 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3074 */                     .withinDistance(0.0D, 5.0D)
/* 3075 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
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
/* 3093 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 3094 */           .addNextBehavior(
/* 3095 */             CECombatBehaviors.Behavior.builder()
/* 3096 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3097 */             .withinDistance(0.0D, 4.0D)
/* 3098 */             .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3099 */             .addNextBehavior(
/* 3100 */               CECombatBehaviors.Behavior.builder()
/* 3101 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3102 */               .withinDistance(0.0D, 4.0D)
/* 3103 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 3104 */               .addNextBehavior(
/* 3105 */                 CECombatBehaviors.Behavior.builder()
/* 3106 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3107 */                 .withinDistance(0.0D, 5.0D)
/* 3108 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 3109 */                 .addNextBehavior(
/* 3110 */                   CECombatBehaviors.Behavior.builder()
/* 3111 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3112 */                   .withinDistance(0.0D, 5.0D)
/* 3113 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3121 */       .addFirstBehavior(
/* 3122 */         CECombatBehaviors.Behavior.builder()
/* 3123 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3124 */         .withinDistance(0.0D, 3.0D)
/* 3125 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3126 */         .addNextBehavior(
/* 3127 */           CECombatBehaviors.Behavior.builder()
/* 3128 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3129 */           .withinDistance(0.0D, 3.0D)
/* 3130 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 3131 */           .addNextBehavior(
/* 3132 */             CECombatBehaviors.Behavior.builder()
/* 3133 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3134 */             .withinDistance(0.0D, 4.0D)
/* 3135 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3136 */             .addNextBehavior(
/* 3137 */               CECombatBehaviors.Behavior.builder()
/* 3138 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3139 */               .withinDistance(0.0D, 4.0D)
/* 3140 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 3141 */               .addNextBehavior(
/* 3142 */                 CECombatBehaviors.Behavior.builder()
/* 3143 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3144 */                 .withinDistance(0.0D, 5.0D)
/* 3145 */                 .animationBehavior(AVAnimations.DUAL_SWORD3, 0.0F)
/* 3146 */                 .addNextBehavior(
/* 3147 */                   CECombatBehaviors.Behavior.builder()
/* 3148 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3149 */                   .withinDistance(0.0D, 5.0D)
/* 3150 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 3151 */                   .addNextBehavior(
/* 3152 */                     CECombatBehaviors.Behavior.builder()
/* 3153 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3154 */                     .withinDistance(0.0D, 5.0D)
/* 3155 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
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
/* 3168 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3169 */         .addNextBehavior(
/* 3170 */           CECombatBehaviors.Behavior.builder()
/* 3171 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3172 */           .withinDistance(0.0D, 3.0D)
/* 3173 */           .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 3174 */           .addNextBehavior(
/* 3175 */             CECombatBehaviors.Behavior.builder()
/* 3176 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3177 */             .withinDistance(0.0D, 4.0D)
/* 3178 */             .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 3179 */             .addNextBehavior(
/* 3180 */               CECombatBehaviors.Behavior.builder()
/* 3181 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3182 */               .withinDistance(0.0D, 4.0D)
/* 3183 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 3184 */               .addNextBehavior(
/* 3185 */                 CECombatBehaviors.Behavior.builder()
/* 3186 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3187 */                 .withinDistance(0.0D, 5.0D)
/* 3188 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 3189 */                 .addNextBehavior(
/* 3190 */                   CECombatBehaviors.Behavior.builder()
/* 3191 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3192 */                   .withinDistance(0.0D, 5.0D)
/* 3193 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
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
/* 3210 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 3211 */           .addNextBehavior(
/* 3212 */             CECombatBehaviors.Behavior.builder()
/* 3213 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3214 */             .withinDistance(0.0D, 4.0D)
/* 3215 */             .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 3216 */             .addNextBehavior(
/* 3217 */               CECombatBehaviors.Behavior.builder()
/* 3218 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3219 */               .withinDistance(0.0D, 4.0D)
/* 3220 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 3221 */               .addNextBehavior(
/* 3222 */                 CECombatBehaviors.Behavior.builder()
/* 3223 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3224 */                 .withinDistance(0.0D, 5.0D)
/* 3225 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 3226 */                 .addNextBehavior(
/* 3227 */                   CECombatBehaviors.Behavior.builder()
/* 3228 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3229 */                   .withinDistance(0.0D, 5.0D)
/* 3230 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
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
/* 3242 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 3243 */         .addNextBehavior(
/* 3244 */           CECombatBehaviors.Behavior.builder()
/* 3245 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3246 */           .withinDistance(0.0D, 3.0D)
/* 3247 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 3248 */           .addNextBehavior(
/* 3249 */             CECombatBehaviors.Behavior.builder()
/* 3250 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3251 */             .withinDistance(0.0D, 4.0D)
/* 3252 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 3253 */             .addNextBehavior(
/* 3254 */               CECombatBehaviors.Behavior.builder()
/* 3255 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3256 */               .withinDistance(0.0D, 4.0D)
/* 3257 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 3258 */               .addNextBehavior(
/* 3259 */                 CECombatBehaviors.Behavior.builder()
/* 3260 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3261 */                 .withinDistance(0.0D, 5.0D)
/* 3262 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 3263 */                 .addNextBehavior(
/* 3264 */                   CECombatBehaviors.Behavior.builder()
/* 3265 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3266 */                   .withinDistance(0.0D, 5.0D)
/* 3267 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 3268 */                   .addNextBehavior(
/* 3269 */                     CECombatBehaviors.Behavior.builder()
/* 3270 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3271 */                     .withinDistance(0.0D, 5.0D)
/* 3272 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3282 */     .newBehaviorRoot(
/* 3283 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3284 */       .priority(1.0D)
/* 3285 */       .weight(20.0D)
/* 3286 */       .maxCooldown(100)
/* 3287 */       .addFirstBehavior(
/* 3288 */         CECombatBehaviors.Behavior.builder()
/* 3289 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3290 */         .withinDistance(0.0D, 3.0D)
/* 3291 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 3292 */         .addNextBehavior(
/* 3293 */           CECombatBehaviors.Behavior.builder()
/* 3294 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3295 */           .withinDistance(0.0D, 3.0D)
/* 3296 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 3297 */           .addNextBehavior(
/* 3298 */             CECombatBehaviors.Behavior.builder()
/* 3299 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3300 */             .withinDistance(0.0D, 3.0D)
/* 3301 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 3302 */             .addNextBehavior(
/* 3303 */               CECombatBehaviors.Behavior.builder()
/* 3304 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3305 */               .withinDistance(0.0D, 3.0D)
/* 3306 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3312 */     .newBehaviorRoot(
/* 3313 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3314 */       .priority(1.0D)
/* 3315 */       .weight(10.0D)
/* 3316 */       .maxCooldown(100)
/* 3317 */       .addFirstBehavior(
/* 3318 */         CECombatBehaviors.Behavior.builder()
/* 3319 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3320 */         .withinDistance(0.0D, 3.0D)
/* 3321 */         .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F))
/*      */       
/* 3323 */       .addFirstBehavior(
/* 3324 */         CECombatBehaviors.Behavior.builder()
/* 3325 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3326 */         .withinDistance(0.0D, 3.0D)
/* 3327 */         .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F))
/*      */       
/* 3329 */       .addFirstBehavior(
/* 3330 */         CECombatBehaviors.Behavior.builder()
/* 3331 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3332 */         .withinDistance(0.0D, 3.0D)
/* 3333 */         .animationBehavior(Animations.DANCING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 3336 */     .newBehaviorRoot(
/* 3337 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3338 */       .priority(1.0D)
/* 3339 */       .weight(10.0D)
/* 3340 */       .maxCooldown(100)
/* 3341 */       .addFirstBehavior(
/* 3342 */         CECombatBehaviors.Behavior.builder()
/* 3343 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3344 */         .withinDistance(0.0D, 3.0D)
/* 3345 */         .custom(CombatCommon::canThrowEnderPearl)
/* 3346 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 3347 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 3348 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 3351 */     .newBehaviorRoot(
/* 3352 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3353 */       .priority(1.0D)
/* 3354 */       .weight(2.0D)
/* 3355 */       .maxCooldown(100)
/* 3356 */       .addFirstBehavior(
/* 3357 */         CECombatBehaviors.Behavior.builder()
/* 3358 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3359 */         .withinDistance(0.0D, 3.0D)
/* 3360 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 3362 */       .addFirstBehavior(
/* 3363 */         CECombatBehaviors.Behavior.builder()
/* 3364 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3365 */         .withinDistance(0.0D, 3.0D)
/* 3366 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 3368 */       .addFirstBehavior(
/* 3369 */         CECombatBehaviors.Behavior.builder()
/* 3370 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3371 */         .withinDistance(0.0D, 3.0D)
/* 3372 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 3374 */       .addFirstBehavior(
/* 3375 */         CECombatBehaviors.Behavior.builder()
/* 3376 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3377 */         .withinDistance(0.0D, 3.0D)
/* 3378 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 3380 */       .addFirstBehavior(
/* 3381 */         CECombatBehaviors.Behavior.builder()
/* 3382 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3383 */         .withinDistance(0.0D, 3.0D)
/* 3384 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 3386 */       .addFirstBehavior(
/* 3387 */         CECombatBehaviors.Behavior.builder()
/* 3388 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3389 */         .withinDistance(0.0D, 3.0D)
/* 3390 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 3392 */       .addFirstBehavior(
/* 3393 */         CECombatBehaviors.Behavior.builder()
/* 3394 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3395 */         .withinDistance(0.0D, 3.0D)
/* 3396 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 3399 */     .newBehaviorRoot(
/* 3400 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3401 */       .priority(1.0D)
/* 3402 */       .weight(15.0D)
/* 3403 */       .addFirstBehavior(
/* 3404 */         CECombatBehaviors.Behavior.builder()
/* 3405 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3406 */         .withinDistance(0.0D, 3.0D)
/* 3407 */         .custom(CombatCommon::canPerformGuarding)
/* 3408 */         .guard(40)))
/*      */ 
/*      */     
/* 3411 */     .newBehaviorRoot(
/* 3412 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3413 */       .priority(1.0D)
/* 3414 */       .weight(10.0D)
/* 3415 */       .addFirstBehavior(
/* 3416 */         CECombatBehaviors.Behavior.builder()
/* 3417 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3418 */         .withinDistance(0.0D, 3.0D)
/* 3419 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 3421 */       .addFirstBehavior(
/* 3422 */         CECombatBehaviors.Behavior.builder()
/* 3423 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3424 */         .withinDistance(0.0D, 3.0D)
/* 3425 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 3428 */     .newBehaviorRoot(
/* 3429 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3430 */       .priority(1.0D)
/* 3431 */       .weight(40.0D)
/* 3432 */       .maxCooldown(160)
/* 3433 */       .addFirstBehavior(
/* 3434 */         CECombatBehaviors.Behavior.builder()
/* 3435 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3436 */         .custom(CombatCommon::canJump)
/* 3437 */         .withinDistance(5.0D, 14.0D)
/* 3438 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 3439 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */