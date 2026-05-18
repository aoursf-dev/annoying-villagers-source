/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.efkick.gameasset.EFKickAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsRuine;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PlayerNpcLongsword
/*      */ {
/*   15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> LONGSWORD_SHIELD = CECombatBehaviors.builder()
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
/*  106 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  107 */         .addNextBehavior(
/*  108 */           CECombatBehaviors.Behavior.builder()
/*  109 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  110 */           .withinDistance(0.0D, 3.0D)
/*  111 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  112 */           .addNextBehavior(
/*  113 */             CECombatBehaviors.Behavior.builder()
/*  114 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  115 */             .withinDistance(0.0D, 3.0D)
/*  116 */             .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  120 */       .addFirstBehavior(
/*  121 */         CECombatBehaviors.Behavior.builder()
/*  122 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  123 */         .withinDistance(0.0D, 3.0D)
/*  124 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  125 */         .addNextBehavior(
/*  126 */           CECombatBehaviors.Behavior.builder()
/*  127 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  128 */           .withinDistance(0.0D, 3.0D)
/*  129 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/*  130 */           .addNextBehavior(
/*  131 */             CECombatBehaviors.Behavior.builder()
/*  132 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  133 */             .withinDistance(0.0D, 4.0D)
/*  134 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  135 */             .addNextBehavior(
/*  136 */               CECombatBehaviors.Behavior.builder()
/*  137 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  138 */               .withinDistance(0.0D, 4.0D)
/*  139 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  140 */               .addNextBehavior(
/*  141 */                 CECombatBehaviors.Behavior.builder()
/*  142 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  143 */                 .withinDistance(0.0D, 5.0D)
/*  144 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  145 */                 .addNextBehavior(
/*  146 */                   CECombatBehaviors.Behavior.builder()
/*  147 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  148 */                   .withinDistance(0.0D, 5.0D)
/*  149 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
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
/*  161 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  162 */         .addNextBehavior(
/*  163 */           CECombatBehaviors.Behavior.builder()
/*  164 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  165 */           .withinDistance(0.0D, 3.0D)
/*  166 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  167 */           .addNextBehavior(
/*  168 */             CECombatBehaviors.Behavior.builder()
/*  169 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  170 */             .withinDistance(0.0D, 4.0D)
/*  171 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  172 */             .addNextBehavior(
/*  173 */               CECombatBehaviors.Behavior.builder()
/*  174 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  175 */               .withinDistance(0.0D, 4.0D)
/*  176 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  177 */               .addNextBehavior(
/*  178 */                 CECombatBehaviors.Behavior.builder()
/*  179 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  180 */                 .withinDistance(0.0D, 5.0D)
/*  181 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  182 */                 .addNextBehavior(
/*  183 */                   CECombatBehaviors.Behavior.builder()
/*  184 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  185 */                   .withinDistance(0.0D, 5.0D)
/*  186 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
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
/*  198 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  199 */         .addNextBehavior(
/*  200 */           CECombatBehaviors.Behavior.builder()
/*  201 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  202 */           .withinDistance(0.0D, 3.0D)
/*  203 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  204 */           .addNextBehavior(
/*  205 */             CECombatBehaviors.Behavior.builder()
/*  206 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  207 */             .withinDistance(0.0D, 4.0D)
/*  208 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  209 */             .addNextBehavior(
/*  210 */               CECombatBehaviors.Behavior.builder()
/*  211 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  212 */               .withinDistance(0.0D, 4.0D)
/*  213 */               .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/*  214 */               .addNextBehavior(
/*  215 */                 CECombatBehaviors.Behavior.builder()
/*  216 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  217 */                 .withinDistance(0.0D, 5.0D)
/*  218 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  219 */                 .addNextBehavior(
/*  220 */                   CECombatBehaviors.Behavior.builder()
/*  221 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  222 */                   .withinDistance(0.0D, 5.0D)
/*  223 */                   .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
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
/*  241 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  242 */         .addNextBehavior(
/*  243 */           CECombatBehaviors.Behavior.builder()
/*  244 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  245 */           .withinDistance(0.0D, 3.0D)
/*  246 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  247 */           .addNextBehavior(
/*  248 */             CECombatBehaviors.Behavior.builder()
/*  249 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  250 */             .withinDistance(0.0D, 4.0D)
/*  251 */             .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/*  252 */             .addNextBehavior(
/*  253 */               CECombatBehaviors.Behavior.builder()
/*  254 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  255 */               .withinDistance(0.0D, 4.0D)
/*  256 */               .animationBehavior(Animations.SHARP_STAB, 0.0F)
/*  257 */               .addNextBehavior(
/*  258 */                 CECombatBehaviors.Behavior.builder()
/*  259 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  260 */                 .withinDistance(0.0D, 5.0D)
/*  261 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  262 */                 .addNextBehavior(
/*  263 */                   CECombatBehaviors.Behavior.builder()
/*  264 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  265 */                   .withinDistance(0.0D, 5.0D)
/*  266 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  274 */       .addFirstBehavior(
/*  275 */         CECombatBehaviors.Behavior.builder()
/*  276 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  277 */         .withinDistance(0.0D, 3.0D)
/*  278 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  279 */         .addNextBehavior(
/*  280 */           CECombatBehaviors.Behavior.builder()
/*  281 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  282 */           .withinDistance(0.0D, 3.0D)
/*  283 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  284 */           .addNextBehavior(
/*  285 */             CECombatBehaviors.Behavior.builder()
/*  286 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  287 */             .withinDistance(0.0D, 4.0D)
/*  288 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  289 */             .addNextBehavior(
/*  290 */               CECombatBehaviors.Behavior.builder()
/*  291 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  292 */               .withinDistance(0.0D, 4.0D)
/*  293 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  294 */               .addNextBehavior(
/*  295 */                 CECombatBehaviors.Behavior.builder()
/*  296 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  297 */                 .withinDistance(0.0D, 5.0D)
/*  298 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  299 */                 .addNextBehavior(
/*  300 */                   CECombatBehaviors.Behavior.builder()
/*  301 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  302 */                   .withinDistance(0.0D, 5.0D)
/*  303 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  311 */       .addFirstBehavior(
/*  312 */         CECombatBehaviors.Behavior.builder()
/*  313 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  314 */         .withinDistance(0.0D, 3.0D)
/*  315 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  316 */         .addNextBehavior(
/*  317 */           CECombatBehaviors.Behavior.builder()
/*  318 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  319 */           .withinDistance(0.0D, 3.0D)
/*  320 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  321 */           .addNextBehavior(
/*  322 */             CECombatBehaviors.Behavior.builder()
/*  323 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  324 */             .withinDistance(0.0D, 4.0D)
/*  325 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  326 */             .addNextBehavior(
/*  327 */               CECombatBehaviors.Behavior.builder()
/*  328 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  329 */               .withinDistance(0.0D, 4.0D)
/*  330 */               .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/*  331 */               .addNextBehavior(
/*  332 */                 CECombatBehaviors.Behavior.builder()
/*  333 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  334 */                 .withinDistance(0.0D, 5.0D)
/*  335 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  336 */                 .addNextBehavior(
/*  337 */                   CECombatBehaviors.Behavior.builder()
/*  338 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  339 */                   .withinDistance(0.0D, 5.0D)
/*  340 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
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
/*  352 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  353 */         .addNextBehavior(
/*  354 */           CECombatBehaviors.Behavior.builder()
/*  355 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  356 */           .withinDistance(0.0D, 3.0D)
/*  357 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/*  358 */           .addNextBehavior(
/*  359 */             CECombatBehaviors.Behavior.builder()
/*  360 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  361 */             .withinDistance(0.0D, 4.0D)
/*  362 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  363 */             .addNextBehavior(
/*  364 */               CECombatBehaviors.Behavior.builder()
/*  365 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  366 */               .withinDistance(0.0D, 4.0D)
/*  367 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  368 */               .addNextBehavior(
/*  369 */                 CECombatBehaviors.Behavior.builder()
/*  370 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  371 */                 .withinDistance(0.0D, 5.0D)
/*  372 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  373 */                 .addNextBehavior(
/*  374 */                   CECombatBehaviors.Behavior.builder()
/*  375 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  376 */                   .withinDistance(0.0D, 5.0D)
/*  377 */                   .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
/*  378 */                   .addNextBehavior(
/*  379 */                     CECombatBehaviors.Behavior.builder()
/*  380 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  381 */                     .withinDistance(0.0D, 5.0D)
/*  382 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  391 */       .addFirstBehavior(
/*  392 */         CECombatBehaviors.Behavior.builder()
/*  393 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  394 */         .withinDistance(0.0D, 3.0D)
/*  395 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  396 */         .addNextBehavior(
/*  397 */           CECombatBehaviors.Behavior.builder()
/*  398 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  399 */           .withinDistance(0.0D, 3.0D)
/*  400 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  401 */           .addNextBehavior(
/*  402 */             CECombatBehaviors.Behavior.builder()
/*  403 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  404 */             .withinDistance(0.0D, 4.0D)
/*  405 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  406 */             .addNextBehavior(
/*  407 */               CECombatBehaviors.Behavior.builder()
/*  408 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  409 */               .withinDistance(0.0D, 4.0D)
/*  410 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  411 */               .addNextBehavior(
/*  412 */                 CECombatBehaviors.Behavior.builder()
/*  413 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  414 */                 .withinDistance(0.0D, 5.0D)
/*  415 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  416 */                 .addNextBehavior(
/*  417 */                   CECombatBehaviors.Behavior.builder()
/*  418 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  419 */                   .withinDistance(0.0D, 5.0D)
/*  420 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  428 */       .addFirstBehavior(
/*  429 */         CECombatBehaviors.Behavior.builder()
/*  430 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  431 */         .withinDistance(0.0D, 3.0D)
/*  432 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  433 */         .addNextBehavior(
/*  434 */           CECombatBehaviors.Behavior.builder()
/*  435 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  436 */           .withinDistance(0.0D, 3.0D)
/*  437 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  438 */           .addNextBehavior(
/*  439 */             CECombatBehaviors.Behavior.builder()
/*  440 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  441 */             .withinDistance(0.0D, 4.0D)
/*  442 */             .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/*  443 */             .addNextBehavior(
/*  444 */               CECombatBehaviors.Behavior.builder()
/*  445 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  446 */               .withinDistance(0.0D, 4.0D)
/*  447 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  448 */               .addNextBehavior(
/*  449 */                 CECombatBehaviors.Behavior.builder()
/*  450 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  451 */                 .withinDistance(0.0D, 5.0D)
/*  452 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  453 */                 .addNextBehavior(
/*  454 */                   CECombatBehaviors.Behavior.builder()
/*  455 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  456 */                   .withinDistance(0.0D, 5.0D)
/*  457 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
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
/*  469 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  470 */         .addNextBehavior(
/*  471 */           CECombatBehaviors.Behavior.builder()
/*  472 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  473 */           .withinDistance(0.0D, 3.0D)
/*  474 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  475 */           .addNextBehavior(
/*  476 */             CECombatBehaviors.Behavior.builder()
/*  477 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  478 */             .withinDistance(0.0D, 4.0D)
/*  479 */             .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/*  480 */             .addNextBehavior(
/*  481 */               CECombatBehaviors.Behavior.builder()
/*  482 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  483 */               .withinDistance(0.0D, 4.0D)
/*  484 */               .animationBehavior(Animations.SHARP_STAB, 0.0F)
/*  485 */               .addNextBehavior(
/*  486 */                 CECombatBehaviors.Behavior.builder()
/*  487 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  488 */                 .withinDistance(0.0D, 5.0D)
/*  489 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  490 */                 .addNextBehavior(
/*  491 */                   CECombatBehaviors.Behavior.builder()
/*  492 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  493 */                   .withinDistance(0.0D, 5.0D)
/*  494 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  495 */                   .addNextBehavior(
/*  496 */                     CECombatBehaviors.Behavior.builder()
/*  497 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  498 */                     .withinDistance(0.0D, 5.0D)
/*  499 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  508 */       .addFirstBehavior(
/*  509 */         CECombatBehaviors.Behavior.builder()
/*  510 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  511 */         .withinDistance(0.0D, 3.0D)
/*  512 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  513 */         .addNextBehavior(
/*  514 */           CECombatBehaviors.Behavior.builder()
/*  515 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  516 */           .withinDistance(0.0D, 3.0D)
/*  517 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  518 */           .addNextBehavior(
/*  519 */             CECombatBehaviors.Behavior.builder()
/*  520 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  521 */             .withinDistance(0.0D, 4.0D)
/*  522 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  523 */             .addNextBehavior(
/*  524 */               CECombatBehaviors.Behavior.builder()
/*  525 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  526 */               .withinDistance(0.0D, 4.0D)
/*  527 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  528 */               .addNextBehavior(
/*  529 */                 CECombatBehaviors.Behavior.builder()
/*  530 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  531 */                 .withinDistance(0.0D, 5.0D)
/*  532 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  533 */                 .addNextBehavior(
/*  534 */                   CECombatBehaviors.Behavior.builder()
/*  535 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  536 */                   .withinDistance(0.0D, 5.0D)
/*  537 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  545 */       .addFirstBehavior(
/*  546 */         CECombatBehaviors.Behavior.builder()
/*  547 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  548 */         .withinDistance(0.0D, 3.0D)
/*  549 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  550 */         .addNextBehavior(
/*  551 */           CECombatBehaviors.Behavior.builder()
/*  552 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  553 */           .withinDistance(0.0D, 3.0D)
/*  554 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  555 */           .addNextBehavior(
/*  556 */             CECombatBehaviors.Behavior.builder()
/*  557 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  558 */             .withinDistance(0.0D, 4.0D)
/*  559 */             .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/*  560 */             .addNextBehavior(
/*  561 */               CECombatBehaviors.Behavior.builder()
/*  562 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  563 */               .withinDistance(0.0D, 4.0D)
/*  564 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  565 */               .addNextBehavior(
/*  566 */                 CECombatBehaviors.Behavior.builder()
/*  567 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  568 */                 .withinDistance(0.0D, 5.0D)
/*  569 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  570 */                 .addNextBehavior(
/*  571 */                   CECombatBehaviors.Behavior.builder()
/*  572 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  573 */                   .withinDistance(0.0D, 5.0D)
/*  574 */                   .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
/*  575 */                   .addNextBehavior(
/*  576 */                     CECombatBehaviors.Behavior.builder()
/*  577 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  578 */                     .withinDistance(0.0D, 5.0D)
/*  579 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  588 */       .addFirstBehavior(
/*  589 */         CECombatBehaviors.Behavior.builder()
/*  590 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  591 */         .withinDistance(0.0D, 3.0D)
/*  592 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  593 */         .addNextBehavior(
/*  594 */           CECombatBehaviors.Behavior.builder()
/*  595 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  596 */           .withinDistance(0.0D, 3.0D)
/*  597 */           .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  598 */           .addNextBehavior(
/*  599 */             CECombatBehaviors.Behavior.builder()
/*  600 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  601 */             .withinDistance(0.0D, 4.0D)
/*  602 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  603 */             .addNextBehavior(
/*  604 */               CECombatBehaviors.Behavior.builder()
/*  605 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  606 */               .withinDistance(0.0D, 4.0D)
/*  607 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  608 */               .addNextBehavior(
/*  609 */                 CECombatBehaviors.Behavior.builder()
/*  610 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  611 */                 .withinDistance(0.0D, 5.0D)
/*  612 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  613 */                 .addNextBehavior(
/*  614 */                   CECombatBehaviors.Behavior.builder()
/*  615 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  616 */                   .withinDistance(0.0D, 5.0D)
/*  617 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  625 */       .addFirstBehavior(
/*  626 */         CECombatBehaviors.Behavior.builder()
/*  627 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  628 */         .withinDistance(0.0D, 3.0D)
/*  629 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  630 */         .addNextBehavior(
/*  631 */           CECombatBehaviors.Behavior.builder()
/*  632 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  633 */           .withinDistance(0.0D, 3.0D)
/*  634 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/*  635 */           .addNextBehavior(
/*  636 */             CECombatBehaviors.Behavior.builder()
/*  637 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  638 */             .withinDistance(0.0D, 4.0D)
/*  639 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  640 */             .addNextBehavior(
/*  641 */               CECombatBehaviors.Behavior.builder()
/*  642 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  643 */               .withinDistance(0.0D, 4.0D)
/*  644 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  645 */               .addNextBehavior(
/*  646 */                 CECombatBehaviors.Behavior.builder()
/*  647 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  648 */                 .withinDistance(0.0D, 5.0D)
/*  649 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  650 */                 .addNextBehavior(
/*  651 */                   CECombatBehaviors.Behavior.builder()
/*  652 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  653 */                   .withinDistance(0.0D, 5.0D)
/*  654 */                   .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
/*  655 */                   .addNextBehavior(
/*  656 */                     CECombatBehaviors.Behavior.builder()
/*  657 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  658 */                     .withinDistance(0.0D, 5.0D)
/*  659 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  668 */       .addFirstBehavior(
/*  669 */         CECombatBehaviors.Behavior.builder()
/*  670 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  671 */         .withinDistance(0.0D, 3.0D)
/*  672 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  673 */         .addNextBehavior(
/*  674 */           CECombatBehaviors.Behavior.builder()
/*  675 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  676 */           .withinDistance(0.0D, 3.0D)
/*  677 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  678 */           .addNextBehavior(
/*  679 */             CECombatBehaviors.Behavior.builder()
/*  680 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  681 */             .withinDistance(0.0D, 4.0D)
/*  682 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  683 */             .addNextBehavior(
/*  684 */               CECombatBehaviors.Behavior.builder()
/*  685 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  686 */               .withinDistance(0.0D, 4.0D)
/*  687 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  688 */               .addNextBehavior(
/*  689 */                 CECombatBehaviors.Behavior.builder()
/*  690 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  691 */                 .withinDistance(0.0D, 5.0D)
/*  692 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  693 */                 .addNextBehavior(
/*  694 */                   CECombatBehaviors.Behavior.builder()
/*  695 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  696 */                   .withinDistance(0.0D, 5.0D)
/*  697 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  706 */     .newBehaviorRoot(
/*  707 */       CECombatBehaviors.BehaviorRoot.builder()
/*  708 */       .priority(1.0D)
/*  709 */       .weight(20.0D)
/*  710 */       .maxCooldown(100)
/*  711 */       .addFirstBehavior(
/*  712 */         CECombatBehaviors.Behavior.builder()
/*  713 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  714 */         .withinDistance(0.0D, 3.0D)
/*  715 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  716 */         .addNextBehavior(
/*  717 */           CECombatBehaviors.Behavior.builder()
/*  718 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  719 */           .withinDistance(0.0D, 3.0D)
/*  720 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  721 */           .addNextBehavior(
/*  722 */             CECombatBehaviors.Behavior.builder()
/*  723 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  724 */             .withinDistance(0.0D, 3.0D)
/*  725 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  730 */     .newBehaviorRoot(
/*  731 */       CECombatBehaviors.BehaviorRoot.builder()
/*  732 */       .priority(1.0D)
/*  733 */       .weight(10.0D)
/*  734 */       .maxCooldown(100)
/*  735 */       .addFirstBehavior(
/*  736 */         CECombatBehaviors.Behavior.builder()
/*  737 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  738 */         .withinDistance(0.0D, 3.0D)
/*  739 */         .animationBehavior(Animations.LONGSWORD_DASH, 0.0F))
/*      */       
/*  741 */       .addFirstBehavior(
/*  742 */         CECombatBehaviors.Behavior.builder()
/*  743 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  744 */         .withinDistance(0.0D, 3.0D)
/*  745 */         .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F))
/*      */       
/*  747 */       .addFirstBehavior(
/*  748 */         CECombatBehaviors.Behavior.builder()
/*  749 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  750 */         .withinDistance(0.0D, 3.0D)
/*  751 */         .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/*  752 */         .addNextBehavior(
/*  753 */           CECombatBehaviors.Behavior.builder()
/*  754 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  755 */           .withinDistance(0.0D, 3.0D)
/*  756 */           .animationBehavior(Animations.SHARP_STAB, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/*  760 */     .newBehaviorRoot(
/*  761 */       CECombatBehaviors.BehaviorRoot.builder()
/*  762 */       .priority(1.0D)
/*  763 */       .weight(10.0D)
/*  764 */       .maxCooldown(40)
/*  765 */       .addFirstBehavior(
/*  766 */         CECombatBehaviors.Behavior.builder()
/*  767 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  768 */         .withinDistance(0.0D, 3.0D)
/*  769 */         .custom(CombatCommon::canThrowEnderPearl)
/*  770 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  771 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  774 */     .newBehaviorRoot(
/*  775 */       CECombatBehaviors.BehaviorRoot.builder()
/*  776 */       .priority(1.0D)
/*  777 */       .weight(2.0D)
/*  778 */       .maxCooldown(100)
/*  779 */       .addFirstBehavior(
/*  780 */         CECombatBehaviors.Behavior.builder()
/*  781 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  782 */         .withinDistance(0.0D, 3.0D)
/*  783 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  785 */       .addFirstBehavior(
/*  786 */         CECombatBehaviors.Behavior.builder()
/*  787 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  788 */         .withinDistance(0.0D, 3.0D)
/*  789 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  791 */       .addFirstBehavior(
/*  792 */         CECombatBehaviors.Behavior.builder()
/*  793 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  794 */         .withinDistance(0.0D, 3.0D)
/*  795 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  797 */       .addFirstBehavior(
/*  798 */         CECombatBehaviors.Behavior.builder()
/*  799 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  800 */         .withinDistance(0.0D, 3.0D)
/*  801 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  803 */       .addFirstBehavior(
/*  804 */         CECombatBehaviors.Behavior.builder()
/*  805 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  806 */         .withinDistance(0.0D, 3.0D)
/*  807 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  809 */       .addFirstBehavior(
/*  810 */         CECombatBehaviors.Behavior.builder()
/*  811 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  812 */         .withinDistance(0.0D, 3.0D)
/*  813 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  815 */       .addFirstBehavior(
/*  816 */         CECombatBehaviors.Behavior.builder()
/*  817 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  818 */         .withinDistance(0.0D, 3.0D)
/*  819 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  822 */     .newBehaviorRoot(
/*  823 */       CECombatBehaviors.BehaviorRoot.builder()
/*  824 */       .priority(1.0D)
/*  825 */       .weight(15.0D)
/*  826 */       .addFirstBehavior(
/*  827 */         CECombatBehaviors.Behavior.builder()
/*  828 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  829 */         .withinDistance(0.0D, 3.0D)
/*  830 */         .custom(CombatCommon::canPerformGuarding)
/*  831 */         .guard(40)))
/*      */ 
/*      */     
/*  834 */     .newBehaviorRoot(
/*  835 */       CECombatBehaviors.BehaviorRoot.builder()
/*  836 */       .priority(1.0D)
/*  837 */       .weight(10.0D)
/*  838 */       .addFirstBehavior(
/*  839 */         CECombatBehaviors.Behavior.builder()
/*  840 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  841 */         .withinDistance(0.0D, 3.0D)
/*  842 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/*  844 */       .addFirstBehavior(
/*  845 */         CECombatBehaviors.Behavior.builder()
/*  846 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  847 */         .withinDistance(0.0D, 3.0D)
/*  848 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/*  851 */     .newBehaviorRoot(
/*  852 */       CECombatBehaviors.BehaviorRoot.builder()
/*  853 */       .priority(1.0D)
/*  854 */       .weight(40.0D)
/*  855 */       .maxCooldown(160)
/*  856 */       .addFirstBehavior(
/*  857 */         CECombatBehaviors.Behavior.builder()
/*  858 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  859 */         .custom(CombatCommon::canJump)
/*  860 */         .withinDistance(5.0D, 14.0D)
/*  861 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/*  862 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/*  866 */   public static final CECombatBehaviors.Builder<MobPatch<?>> LONGSWORD = CECombatBehaviors.builder()
/*  867 */     .newBehaviorRoot(
/*  868 */       CECombatBehaviors.BehaviorRoot.builder()
/*  869 */       .priority(4.0D)
/*  870 */       .weight(1000.0D)
/*  871 */       .maxCooldown(0)
/*  872 */       .addFirstBehavior(
/*  873 */         CECombatBehaviors.Behavior.builder()
/*  874 */         .custom(CombatCommon::canExecute)
/*  875 */         .withinDistance(0.0D, 5.0D)
/*  876 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  877 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  880 */     .newBehaviorRoot(
/*  881 */       CECombatBehaviors.BehaviorRoot.builder()
/*  882 */       .priority(3.0D)
/*  883 */       .weight(1000.0D)
/*  884 */       .maxCooldown(0)
/*  885 */       .addFirstBehavior(
/*  886 */         CECombatBehaviors.Behavior.builder()
/*  887 */         .custom(CombatCommon::canEscape)
/*  888 */         .withinDistance(0.0D, 8.0D)
/*  889 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  890 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  892 */       .addFirstBehavior(
/*  893 */         CECombatBehaviors.Behavior.builder()
/*  894 */         .custom(CombatCommon::canEscape)
/*  895 */         .withinDistance(0.0D, 48.0D)
/*  896 */         .guard(40)))
/*      */ 
/*      */     
/*  899 */     .newBehaviorRoot(
/*  900 */       CECombatBehaviors.BehaviorRoot.builder()
/*  901 */       .priority(2.0D)
/*  902 */       .weight(70.0D)
/*  903 */       .maxCooldown(0)
/*  904 */       .addFirstBehavior(
/*  905 */         CECombatBehaviors.Behavior.builder()
/*  906 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  907 */         .custom(CombatCommon::canPerformEating)
/*  908 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  909 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  912 */     .newBehaviorRoot(
/*  913 */       CECombatBehaviors.BehaviorRoot.builder()
/*  914 */       .priority(2.0D)
/*  915 */       .weight(100.0D)
/*  916 */       .maxCooldown(120)
/*  917 */       .addFirstBehavior(
/*  918 */         CECombatBehaviors.Behavior.builder()
/*  919 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  920 */         .custom(CombatCommon::canSwapToBow)
/*  921 */         .withinDistance(7.0D, 14.0D)
/*  922 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  923 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  925 */       .addFirstBehavior(
/*  926 */         CECombatBehaviors.Behavior.builder()
/*  927 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  928 */         .custom(CombatCommon::canSwapToBow)
/*  929 */         .withinDistance(7.0D, 14.0D)
/*  930 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  931 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  934 */     .newBehaviorRoot(
/*  935 */       CECombatBehaviors.BehaviorRoot.builder()
/*  936 */       .priority(2.0D)
/*  937 */       .weight(80.0D)
/*  938 */       .maxCooldown(120)
/*  939 */       .addFirstBehavior(
/*  940 */         CECombatBehaviors.Behavior.builder()
/*  941 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  942 */         .custom(CombatCommon::canThrowEnderPearl)
/*  943 */         .withinDistance(7.0D, 48.0D)
/*  944 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  945 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  948 */     .newBehaviorRoot(
/*  949 */       CECombatBehaviors.BehaviorRoot.builder()
/*  950 */       .priority(1.0D)
/*  951 */       .weight(40.0D)
/*  952 */       .maxCooldown(20)
/*  953 */       .addFirstBehavior(
/*  954 */         CECombatBehaviors.Behavior.builder()
/*  955 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  956 */         .withinDistance(0.0D, 3.0D)
/*  957 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  958 */         .addNextBehavior(
/*  959 */           CECombatBehaviors.Behavior.builder()
/*  960 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  961 */           .withinDistance(0.0D, 3.0D)
/*  962 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  963 */           .addNextBehavior(
/*  964 */             CECombatBehaviors.Behavior.builder()
/*  965 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  966 */             .withinDistance(0.0D, 3.0D)
/*  967 */             .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  971 */       .addFirstBehavior(
/*  972 */         CECombatBehaviors.Behavior.builder()
/*  973 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  974 */         .withinDistance(0.0D, 3.0D)
/*  975 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/*  976 */         .addNextBehavior(
/*  977 */           CECombatBehaviors.Behavior.builder()
/*  978 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  979 */           .withinDistance(0.0D, 3.0D)
/*  980 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/*  981 */           .addNextBehavior(
/*  982 */             CECombatBehaviors.Behavior.builder()
/*  983 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  984 */             .withinDistance(0.0D, 4.0D)
/*  985 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/*  986 */             .addNextBehavior(
/*  987 */               CECombatBehaviors.Behavior.builder()
/*  988 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  989 */               .withinDistance(0.0D, 4.0D)
/*  990 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  991 */               .addNextBehavior(
/*  992 */                 CECombatBehaviors.Behavior.builder()
/*  993 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  994 */                 .withinDistance(0.0D, 5.0D)
/*  995 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  996 */                 .addNextBehavior(
/*  997 */                   CECombatBehaviors.Behavior.builder()
/*  998 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  999 */                   .withinDistance(0.0D, 5.0D)
/* 1000 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1008 */       .addFirstBehavior(
/* 1009 */         CECombatBehaviors.Behavior.builder()
/* 1010 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1011 */         .withinDistance(0.0D, 3.0D)
/* 1012 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1013 */         .addNextBehavior(
/* 1014 */           CECombatBehaviors.Behavior.builder()
/* 1015 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1016 */           .withinDistance(0.0D, 3.0D)
/* 1017 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1018 */           .addNextBehavior(
/* 1019 */             CECombatBehaviors.Behavior.builder()
/* 1020 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1021 */             .withinDistance(0.0D, 4.0D)
/* 1022 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1023 */             .addNextBehavior(
/* 1024 */               CECombatBehaviors.Behavior.builder()
/* 1025 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1026 */               .withinDistance(0.0D, 4.0D)
/* 1027 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1028 */               .addNextBehavior(
/* 1029 */                 CECombatBehaviors.Behavior.builder()
/* 1030 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1031 */                 .withinDistance(0.0D, 5.0D)
/* 1032 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1033 */                 .addNextBehavior(
/* 1034 */                   CECombatBehaviors.Behavior.builder()
/* 1035 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1036 */                   .withinDistance(0.0D, 5.0D)
/* 1037 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1045 */       .addFirstBehavior(
/* 1046 */         CECombatBehaviors.Behavior.builder()
/* 1047 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1048 */         .withinDistance(0.0D, 3.0D)
/* 1049 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1050 */         .addNextBehavior(
/* 1051 */           CECombatBehaviors.Behavior.builder()
/* 1052 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1053 */           .withinDistance(0.0D, 3.0D)
/* 1054 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1055 */           .addNextBehavior(
/* 1056 */             CECombatBehaviors.Behavior.builder()
/* 1057 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1058 */             .withinDistance(0.0D, 4.0D)
/* 1059 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1060 */             .addNextBehavior(
/* 1061 */               CECombatBehaviors.Behavior.builder()
/* 1062 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1063 */               .withinDistance(0.0D, 4.0D)
/* 1064 */               .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 1065 */               .addNextBehavior(
/* 1066 */                 CECombatBehaviors.Behavior.builder()
/* 1067 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1068 */                 .withinDistance(0.0D, 5.0D)
/* 1069 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1070 */                 .addNextBehavior(
/* 1071 */                   CECombatBehaviors.Behavior.builder()
/* 1072 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1073 */                   .withinDistance(0.0D, 5.0D)
/* 1074 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1075 */                   .addNextBehavior(
/* 1076 */                     CECombatBehaviors.Behavior.builder()
/* 1077 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1078 */                     .withinDistance(0.0D, 5.0D)
/* 1079 */                     .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1088 */       .addFirstBehavior(
/* 1089 */         CECombatBehaviors.Behavior.builder()
/* 1090 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1091 */         .withinDistance(0.0D, 3.0D)
/* 1092 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1093 */         .addNextBehavior(
/* 1094 */           CECombatBehaviors.Behavior.builder()
/* 1095 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1096 */           .withinDistance(0.0D, 3.0D)
/* 1097 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1098 */           .addNextBehavior(
/* 1099 */             CECombatBehaviors.Behavior.builder()
/* 1100 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1101 */             .withinDistance(0.0D, 4.0D)
/* 1102 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1103 */             .addNextBehavior(
/* 1104 */               CECombatBehaviors.Behavior.builder()
/* 1105 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1106 */               .withinDistance(0.0D, 4.0D)
/* 1107 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1108 */               .addNextBehavior(
/* 1109 */                 CECombatBehaviors.Behavior.builder()
/* 1110 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1111 */                 .withinDistance(0.0D, 5.0D)
/* 1112 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1113 */                 .addNextBehavior(
/* 1114 */                   CECombatBehaviors.Behavior.builder()
/* 1115 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1116 */                   .withinDistance(0.0D, 5.0D)
/* 1117 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1125 */       .addFirstBehavior(
/* 1126 */         CECombatBehaviors.Behavior.builder()
/* 1127 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1128 */         .withinDistance(0.0D, 3.0D)
/* 1129 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1130 */         .addNextBehavior(
/* 1131 */           CECombatBehaviors.Behavior.builder()
/* 1132 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1133 */           .withinDistance(0.0D, 3.0D)
/* 1134 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1135 */           .addNextBehavior(
/* 1136 */             CECombatBehaviors.Behavior.builder()
/* 1137 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1138 */             .withinDistance(0.0D, 4.0D)
/* 1139 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1140 */             .addNextBehavior(
/* 1141 */               CECombatBehaviors.Behavior.builder()
/* 1142 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1143 */               .withinDistance(0.0D, 4.0D)
/* 1144 */               .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 1145 */               .addNextBehavior(
/* 1146 */                 CECombatBehaviors.Behavior.builder()
/* 1147 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1148 */                 .withinDistance(0.0D, 5.0D)
/* 1149 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1150 */                 .addNextBehavior(
/* 1151 */                   CECombatBehaviors.Behavior.builder()
/* 1152 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1153 */                   .withinDistance(0.0D, 5.0D)
/* 1154 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1162 */       .addFirstBehavior(
/* 1163 */         CECombatBehaviors.Behavior.builder()
/* 1164 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1165 */         .withinDistance(0.0D, 3.0D)
/* 1166 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1167 */         .addNextBehavior(
/* 1168 */           CECombatBehaviors.Behavior.builder()
/* 1169 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1170 */           .withinDistance(0.0D, 3.0D)
/* 1171 */           .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO1, 0.0F)
/* 1172 */           .addNextBehavior(
/* 1173 */             CECombatBehaviors.Behavior.builder()
/* 1174 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1175 */             .withinDistance(0.0D, 4.0D)
/* 1176 */             .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO2, 0.0F)
/* 1177 */             .addNextBehavior(
/* 1178 */               CECombatBehaviors.Behavior.builder()
/* 1179 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1180 */               .withinDistance(0.0D, 4.0D)
/* 1181 */               .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO3, 0.0F)
/* 1182 */               .addNextBehavior(
/* 1183 */                 CECombatBehaviors.Behavior.builder()
/* 1184 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1185 */                 .withinDistance(0.0D, 5.0D)
/* 1186 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1187 */                 .addNextBehavior(
/* 1188 */                   CECombatBehaviors.Behavior.builder()
/* 1189 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1190 */                   .withinDistance(0.0D, 5.0D)
/* 1191 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1192 */                   .addNextBehavior(
/* 1193 */                     CECombatBehaviors.Behavior.builder()
/* 1194 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1195 */                     .withinDistance(0.0D, 5.0D)
/* 1196 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1205 */       .addFirstBehavior(
/* 1206 */         CECombatBehaviors.Behavior.builder()
/* 1207 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1208 */         .withinDistance(0.0D, 3.0D)
/* 1209 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1210 */         .addNextBehavior(
/* 1211 */           CECombatBehaviors.Behavior.builder()
/* 1212 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1213 */           .withinDistance(0.0D, 3.0D)
/* 1214 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1215 */           .addNextBehavior(
/* 1216 */             CECombatBehaviors.Behavior.builder()
/* 1217 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1218 */             .withinDistance(0.0D, 4.0D)
/* 1219 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1220 */             .addNextBehavior(
/* 1221 */               CECombatBehaviors.Behavior.builder()
/* 1222 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1223 */               .withinDistance(0.0D, 4.0D)
/* 1224 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1225 */               .addNextBehavior(
/* 1226 */                 CECombatBehaviors.Behavior.builder()
/* 1227 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1228 */                 .withinDistance(0.0D, 5.0D)
/* 1229 */                 .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1230 */                 .addNextBehavior(
/* 1231 */                   CECombatBehaviors.Behavior.builder()
/* 1232 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1233 */                   .withinDistance(0.0D, 5.0D)
/* 1234 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1242 */       .addFirstBehavior(
/* 1243 */         CECombatBehaviors.Behavior.builder()
/* 1244 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1245 */         .withinDistance(0.0D, 3.0D)
/* 1246 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1247 */         .addNextBehavior(
/* 1248 */           CECombatBehaviors.Behavior.builder()
/* 1249 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1250 */           .withinDistance(0.0D, 3.0D)
/* 1251 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 1252 */           .addNextBehavior(
/* 1253 */             CECombatBehaviors.Behavior.builder()
/* 1254 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1255 */             .withinDistance(0.0D, 4.0D)
/* 1256 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1257 */             .addNextBehavior(
/* 1258 */               CECombatBehaviors.Behavior.builder()
/* 1259 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1260 */               .withinDistance(0.0D, 4.0D)
/* 1261 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1262 */               .addNextBehavior(
/* 1263 */                 CECombatBehaviors.Behavior.builder()
/* 1264 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1265 */                 .withinDistance(0.0D, 5.0D)
/* 1266 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1267 */                 .addNextBehavior(
/* 1268 */                   CECombatBehaviors.Behavior.builder()
/* 1269 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1270 */                   .withinDistance(0.0D, 5.0D)
/* 1271 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1272 */                   .addNextBehavior(
/* 1273 */                     CECombatBehaviors.Behavior.builder()
/* 1274 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1275 */                     .withinDistance(0.0D, 5.0D)
/* 1276 */                     .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1285 */       .addFirstBehavior(
/* 1286 */         CECombatBehaviors.Behavior.builder()
/* 1287 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1288 */         .withinDistance(0.0D, 3.0D)
/* 1289 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1290 */         .addNextBehavior(
/* 1291 */           CECombatBehaviors.Behavior.builder()
/* 1292 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1293 */           .withinDistance(0.0D, 3.0D)
/* 1294 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1295 */           .addNextBehavior(
/* 1296 */             CECombatBehaviors.Behavior.builder()
/* 1297 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1298 */             .withinDistance(0.0D, 4.0D)
/* 1299 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1300 */             .addNextBehavior(
/* 1301 */               CECombatBehaviors.Behavior.builder()
/* 1302 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1303 */               .withinDistance(0.0D, 4.0D)
/* 1304 */               .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 1305 */               .addNextBehavior(
/* 1306 */                 CECombatBehaviors.Behavior.builder()
/* 1307 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1308 */                 .withinDistance(0.0D, 5.0D)
/* 1309 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1310 */                 .addNextBehavior(
/* 1311 */                   CECombatBehaviors.Behavior.builder()
/* 1312 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1313 */                   .withinDistance(0.0D, 5.0D)
/* 1314 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1322 */       .addFirstBehavior(
/* 1323 */         CECombatBehaviors.Behavior.builder()
/* 1324 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1325 */         .withinDistance(0.0D, 3.0D)
/* 1326 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1327 */         .addNextBehavior(
/* 1328 */           CECombatBehaviors.Behavior.builder()
/* 1329 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1330 */           .withinDistance(0.0D, 3.0D)
/* 1331 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1332 */           .addNextBehavior(
/* 1333 */             CECombatBehaviors.Behavior.builder()
/* 1334 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1335 */             .withinDistance(0.0D, 4.0D)
/* 1336 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1337 */             .addNextBehavior(
/* 1338 */               CECombatBehaviors.Behavior.builder()
/* 1339 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1340 */               .withinDistance(0.0D, 4.0D)
/* 1341 */               .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO1, 0.0F)
/* 1342 */               .addNextBehavior(
/* 1343 */                 CECombatBehaviors.Behavior.builder()
/* 1344 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1345 */                 .withinDistance(0.0D, 5.0D)
/* 1346 */                 .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO2, 0.0F)
/* 1347 */                 .addNextBehavior(
/* 1348 */                   CECombatBehaviors.Behavior.builder()
/* 1349 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1350 */                   .withinDistance(0.0D, 5.0D)
/* 1351 */                   .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO3, 0.0F)
/* 1352 */                   .addNextBehavior(
/* 1353 */                     CECombatBehaviors.Behavior.builder()
/* 1354 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1355 */                     .withinDistance(0.0D, 5.0D)
/* 1356 */                     .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1357 */                     .addNextBehavior(
/* 1358 */                       CECombatBehaviors.Behavior.builder()
/* 1359 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1360 */                       .withinDistance(0.0D, 5.0D)
/* 1361 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1371 */       .addFirstBehavior(
/* 1372 */         CECombatBehaviors.Behavior.builder()
/* 1373 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1374 */         .withinDistance(0.0D, 3.0D)
/* 1375 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1376 */         .addNextBehavior(
/* 1377 */           CECombatBehaviors.Behavior.builder()
/* 1378 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1379 */           .withinDistance(0.0D, 3.0D)
/* 1380 */           .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1381 */           .addNextBehavior(
/* 1382 */             CECombatBehaviors.Behavior.builder()
/* 1383 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1384 */             .withinDistance(0.0D, 4.0D)
/* 1385 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1386 */             .addNextBehavior(
/* 1387 */               CECombatBehaviors.Behavior.builder()
/* 1388 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1389 */               .withinDistance(0.0D, 4.0D)
/* 1390 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1391 */               .addNextBehavior(
/* 1392 */                 CECombatBehaviors.Behavior.builder()
/* 1393 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1394 */                 .withinDistance(0.0D, 5.0D)
/* 1395 */                 .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1396 */                 .addNextBehavior(
/* 1397 */                   CECombatBehaviors.Behavior.builder()
/* 1398 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1399 */                   .withinDistance(0.0D, 5.0D)
/* 1400 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1408 */       .addFirstBehavior(
/* 1409 */         CECombatBehaviors.Behavior.builder()
/* 1410 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1411 */         .withinDistance(0.0D, 3.0D)
/* 1412 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1413 */         .addNextBehavior(
/* 1414 */           CECombatBehaviors.Behavior.builder()
/* 1415 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1416 */           .withinDistance(0.0D, 3.0D)
/* 1417 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1418 */           .addNextBehavior(
/* 1419 */             CECombatBehaviors.Behavior.builder()
/* 1420 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1421 */             .withinDistance(0.0D, 4.0D)
/* 1422 */             .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 1423 */             .addNextBehavior(
/* 1424 */               CECombatBehaviors.Behavior.builder()
/* 1425 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1426 */               .withinDistance(0.0D, 4.0D)
/* 1427 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1428 */               .addNextBehavior(
/* 1429 */                 CECombatBehaviors.Behavior.builder()
/* 1430 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1431 */                 .withinDistance(0.0D, 5.0D)
/* 1432 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1433 */                 .addNextBehavior(
/* 1434 */                   CECombatBehaviors.Behavior.builder()
/* 1435 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1436 */                   .withinDistance(0.0D, 5.0D)
/* 1437 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1438 */                   .addNextBehavior(
/* 1439 */                     CECombatBehaviors.Behavior.builder()
/* 1440 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1441 */                     .withinDistance(0.0D, 5.0D)
/* 1442 */                     .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1451 */       .addFirstBehavior(
/* 1452 */         CECombatBehaviors.Behavior.builder()
/* 1453 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1454 */         .withinDistance(0.0D, 3.0D)
/* 1455 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1456 */         .addNextBehavior(
/* 1457 */           CECombatBehaviors.Behavior.builder()
/* 1458 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1459 */           .withinDistance(0.0D, 3.0D)
/* 1460 */           .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO1, 0.0F)
/* 1461 */           .addNextBehavior(
/* 1462 */             CECombatBehaviors.Behavior.builder()
/* 1463 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1464 */             .withinDistance(0.0D, 4.0D)
/* 1465 */             .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO2, 0.0F)
/* 1466 */             .addNextBehavior(
/* 1467 */               CECombatBehaviors.Behavior.builder()
/* 1468 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1469 */               .withinDistance(0.0D, 4.0D)
/* 1470 */               .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO3, 0.0F)
/* 1471 */               .addNextBehavior(
/* 1472 */                 CECombatBehaviors.Behavior.builder()
/* 1473 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1474 */                 .withinDistance(0.0D, 5.0D)
/* 1475 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1476 */                 .addNextBehavior(
/* 1477 */                   CECombatBehaviors.Behavior.builder()
/* 1478 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1479 */                   .withinDistance(0.0D, 5.0D)
/* 1480 */                   .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1481 */                   .addNextBehavior(
/* 1482 */                     CECombatBehaviors.Behavior.builder()
/* 1483 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1484 */                     .withinDistance(0.0D, 5.0D)
/* 1485 */                     .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1486 */                     .addNextBehavior(
/* 1487 */                       CECombatBehaviors.Behavior.builder()
/* 1488 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1489 */                       .withinDistance(0.0D, 5.0D)
/* 1490 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1500 */       .addFirstBehavior(
/* 1501 */         CECombatBehaviors.Behavior.builder()
/* 1502 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1503 */         .withinDistance(0.0D, 3.0D)
/* 1504 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1505 */         .addNextBehavior(
/* 1506 */           CECombatBehaviors.Behavior.builder()
/* 1507 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1508 */           .withinDistance(0.0D, 3.0D)
/* 1509 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 1510 */           .addNextBehavior(
/* 1511 */             CECombatBehaviors.Behavior.builder()
/* 1512 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1513 */             .withinDistance(0.0D, 4.0D)
/* 1514 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1515 */             .addNextBehavior(
/* 1516 */               CECombatBehaviors.Behavior.builder()
/* 1517 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1518 */               .withinDistance(0.0D, 4.0D)
/* 1519 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1520 */               .addNextBehavior(
/* 1521 */                 CECombatBehaviors.Behavior.builder()
/* 1522 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1523 */                 .withinDistance(0.0D, 5.0D)
/* 1524 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1525 */                 .addNextBehavior(
/* 1526 */                   CECombatBehaviors.Behavior.builder()
/* 1527 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1528 */                   .withinDistance(0.0D, 5.0D)
/* 1529 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1537 */       .addFirstBehavior(
/* 1538 */         CECombatBehaviors.Behavior.builder()
/* 1539 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1540 */         .withinDistance(0.0D, 3.0D)
/* 1541 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1542 */         .addNextBehavior(
/* 1543 */           CECombatBehaviors.Behavior.builder()
/* 1544 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1545 */           .withinDistance(0.0D, 3.0D)
/* 1546 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1547 */           .addNextBehavior(
/* 1548 */             CECombatBehaviors.Behavior.builder()
/* 1549 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1550 */             .withinDistance(0.0D, 4.0D)
/* 1551 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1552 */             .addNextBehavior(
/* 1553 */               CECombatBehaviors.Behavior.builder()
/* 1554 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1555 */               .withinDistance(0.0D, 4.0D)
/* 1556 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1557 */               .addNextBehavior(
/* 1558 */                 CECombatBehaviors.Behavior.builder()
/* 1559 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1560 */                 .withinDistance(0.0D, 5.0D)
/* 1561 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1562 */                 .addNextBehavior(
/* 1563 */                   CECombatBehaviors.Behavior.builder()
/* 1564 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1565 */                   .withinDistance(0.0D, 5.0D)
/* 1566 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1575 */     .newBehaviorRoot(
/* 1576 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1577 */       .priority(1.0D)
/* 1578 */       .weight(20.0D)
/* 1579 */       .maxCooldown(100)
/* 1580 */       .addFirstBehavior(
/* 1581 */         CECombatBehaviors.Behavior.builder()
/* 1582 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1583 */         .withinDistance(0.0D, 3.0D)
/* 1584 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1585 */         .addNextBehavior(
/* 1586 */           CECombatBehaviors.Behavior.builder()
/* 1587 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1588 */           .withinDistance(0.0D, 3.0D)
/* 1589 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1590 */           .addNextBehavior(
/* 1591 */             CECombatBehaviors.Behavior.builder()
/* 1592 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1593 */             .withinDistance(0.0D, 3.0D)
/* 1594 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1599 */     .newBehaviorRoot(
/* 1600 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1601 */       .priority(1.0D)
/* 1602 */       .weight(10.0D)
/* 1603 */       .maxCooldown(100)
/* 1604 */       .addFirstBehavior(
/* 1605 */         CECombatBehaviors.Behavior.builder()
/* 1606 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1607 */         .withinDistance(0.0D, 3.0D)
/* 1608 */         .animationBehavior(Animations.LONGSWORD_DASH, 0.0F))
/*      */       
/* 1610 */       .addFirstBehavior(
/* 1611 */         CECombatBehaviors.Behavior.builder()
/* 1612 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1613 */         .withinDistance(0.0D, 3.0D)
/* 1614 */         .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F))
/*      */       
/* 1616 */       .addFirstBehavior(
/* 1617 */         CECombatBehaviors.Behavior.builder()
/* 1618 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1619 */         .withinDistance(0.0D, 3.0D)
/* 1620 */         .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO1, 0.0F)
/* 1621 */         .addNextBehavior(
/* 1622 */           CECombatBehaviors.Behavior.builder()
/* 1623 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1624 */           .withinDistance(0.0D, 3.0D)
/* 1625 */           .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO2, 0.0F)
/* 1626 */           .addNextBehavior(
/* 1627 */             CECombatBehaviors.Behavior.builder()
/* 1628 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1629 */             .withinDistance(0.0D, 3.0D)
/* 1630 */             .animationBehavior(Animations.LONGSWORD_LIECHTENAUER_AUTO3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1635 */     .newBehaviorRoot(
/* 1636 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1637 */       .priority(1.0D)
/* 1638 */       .weight(10.0D)
/* 1639 */       .maxCooldown(40)
/* 1640 */       .addFirstBehavior(
/* 1641 */         CECombatBehaviors.Behavior.builder()
/* 1642 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1643 */         .withinDistance(0.0D, 3.0D)
/* 1644 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1645 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1646 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1649 */     .newBehaviorRoot(
/* 1650 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1651 */       .priority(1.0D)
/* 1652 */       .weight(2.0D)
/* 1653 */       .maxCooldown(100)
/* 1654 */       .addFirstBehavior(
/* 1655 */         CECombatBehaviors.Behavior.builder()
/* 1656 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1657 */         .withinDistance(0.0D, 3.0D)
/* 1658 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1660 */       .addFirstBehavior(
/* 1661 */         CECombatBehaviors.Behavior.builder()
/* 1662 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1663 */         .withinDistance(0.0D, 3.0D)
/* 1664 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1666 */       .addFirstBehavior(
/* 1667 */         CECombatBehaviors.Behavior.builder()
/* 1668 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1669 */         .withinDistance(0.0D, 3.0D)
/* 1670 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1672 */       .addFirstBehavior(
/* 1673 */         CECombatBehaviors.Behavior.builder()
/* 1674 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1675 */         .withinDistance(0.0D, 3.0D)
/* 1676 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1678 */       .addFirstBehavior(
/* 1679 */         CECombatBehaviors.Behavior.builder()
/* 1680 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1681 */         .withinDistance(0.0D, 3.0D)
/* 1682 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1684 */       .addFirstBehavior(
/* 1685 */         CECombatBehaviors.Behavior.builder()
/* 1686 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1687 */         .withinDistance(0.0D, 3.0D)
/* 1688 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1690 */       .addFirstBehavior(
/* 1691 */         CECombatBehaviors.Behavior.builder()
/* 1692 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1693 */         .withinDistance(0.0D, 3.0D)
/* 1694 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1697 */     .newBehaviorRoot(
/* 1698 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1699 */       .priority(1.0D)
/* 1700 */       .weight(15.0D)
/* 1701 */       .addFirstBehavior(
/* 1702 */         CECombatBehaviors.Behavior.builder()
/* 1703 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1704 */         .withinDistance(0.0D, 3.0D)
/* 1705 */         .custom(CombatCommon::canPerformGuarding)
/* 1706 */         .guard(40)))
/*      */ 
/*      */     
/* 1709 */     .newBehaviorRoot(
/* 1710 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1711 */       .priority(1.0D)
/* 1712 */       .weight(10.0D)
/* 1713 */       .addFirstBehavior(
/* 1714 */         CECombatBehaviors.Behavior.builder()
/* 1715 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1716 */         .withinDistance(0.0D, 3.0D)
/* 1717 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1719 */       .addFirstBehavior(
/* 1720 */         CECombatBehaviors.Behavior.builder()
/* 1721 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1722 */         .withinDistance(0.0D, 3.0D)
/* 1723 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1726 */     .newBehaviorRoot(
/* 1727 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1728 */       .priority(1.0D)
/* 1729 */       .weight(40.0D)
/* 1730 */       .maxCooldown(160)
/* 1731 */       .addFirstBehavior(
/* 1732 */         CECombatBehaviors.Behavior.builder()
/* 1733 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1734 */         .custom(CombatCommon::canJump)
/* 1735 */         .withinDistance(5.0D, 14.0D)
/* 1736 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1737 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 1741 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_LONGSWORD_SHIELD = CECombatBehaviors.builder()
/* 1742 */     .newBehaviorRoot(
/* 1743 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1744 */       .priority(4.0D)
/* 1745 */       .weight(1000.0D)
/* 1746 */       .maxCooldown(0)
/* 1747 */       .addFirstBehavior(
/* 1748 */         CECombatBehaviors.Behavior.builder()
/* 1749 */         .custom(CombatCommon::canExecute)
/* 1750 */         .withinDistance(0.0D, 5.0D)
/* 1751 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 1752 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 1755 */     .newBehaviorRoot(
/* 1756 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1757 */       .priority(3.0D)
/* 1758 */       .weight(1000.0D)
/* 1759 */       .maxCooldown(0)
/* 1760 */       .addFirstBehavior(
/* 1761 */         CECombatBehaviors.Behavior.builder()
/* 1762 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1763 */         .custom(CombatCommon::canEscape)
/* 1764 */         .withinDistance(0.0D, 8.0D)
/* 1765 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1766 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 1768 */       .addFirstBehavior(
/* 1769 */         CECombatBehaviors.Behavior.builder()
/* 1770 */         .custom(CombatCommon::canEscape)
/* 1771 */         .withinDistance(0.0D, 48.0D)
/* 1772 */         .guard(40)))
/*      */ 
/*      */     
/* 1775 */     .newBehaviorRoot(
/* 1776 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1777 */       .priority(2.0D)
/* 1778 */       .weight(70.0D)
/* 1779 */       .maxCooldown(0)
/* 1780 */       .addFirstBehavior(
/* 1781 */         CECombatBehaviors.Behavior.builder()
/* 1782 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 1783 */         .custom(CombatCommon::canPerformEating)
/* 1784 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1785 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 1788 */     .newBehaviorRoot(
/* 1789 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1790 */       .priority(2.0D)
/* 1791 */       .weight(100.0D)
/* 1792 */       .maxCooldown(120)
/* 1793 */       .addFirstBehavior(
/* 1794 */         CECombatBehaviors.Behavior.builder()
/* 1795 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1796 */         .custom(CombatCommon::canSwapToBow)
/* 1797 */         .withinDistance(7.0D, 14.0D)
/* 1798 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1799 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 1801 */       .addFirstBehavior(
/* 1802 */         CECombatBehaviors.Behavior.builder()
/* 1803 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1804 */         .custom(CombatCommon::canSwapToBow)
/* 1805 */         .withinDistance(7.0D, 14.0D)
/* 1806 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1807 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 1810 */     .newBehaviorRoot(
/* 1811 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1812 */       .priority(2.0D)
/* 1813 */       .weight(80.0D)
/* 1814 */       .maxCooldown(120)
/* 1815 */       .addFirstBehavior(
/* 1816 */         CECombatBehaviors.Behavior.builder()
/* 1817 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1818 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1819 */         .withinDistance(7.0D, 48.0D)
/* 1820 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1821 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 1824 */     .newBehaviorRoot(
/* 1825 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1826 */       .priority(1.0D)
/* 1827 */       .weight(40.0D)
/* 1828 */       .maxCooldown(20)
/* 1829 */       .addFirstBehavior(
/* 1830 */         CECombatBehaviors.Behavior.builder()
/* 1831 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1832 */         .withinDistance(0.0D, 3.0D)
/* 1833 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1834 */         .addNextBehavior(
/* 1835 */           CECombatBehaviors.Behavior.builder()
/* 1836 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1837 */           .withinDistance(0.0D, 3.0D)
/* 1838 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1839 */           .addNextBehavior(
/* 1840 */             CECombatBehaviors.Behavior.builder()
/* 1841 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1842 */             .withinDistance(0.0D, 3.0D)
/* 1843 */             .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/* 1847 */       .addFirstBehavior(
/* 1848 */         CECombatBehaviors.Behavior.builder()
/* 1849 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1850 */         .withinDistance(0.0D, 3.0D)
/* 1851 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1852 */         .addNextBehavior(
/* 1853 */           CECombatBehaviors.Behavior.builder()
/* 1854 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1855 */           .withinDistance(0.0D, 3.0D)
/* 1856 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 1857 */           .addNextBehavior(
/* 1858 */             CECombatBehaviors.Behavior.builder()
/* 1859 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1860 */             .withinDistance(0.0D, 4.0D)
/* 1861 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1862 */             .addNextBehavior(
/* 1863 */               CECombatBehaviors.Behavior.builder()
/* 1864 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1865 */               .withinDistance(0.0D, 4.0D)
/* 1866 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1867 */               .addNextBehavior(
/* 1868 */                 CECombatBehaviors.Behavior.builder()
/* 1869 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1870 */                 .withinDistance(0.0D, 5.0D)
/* 1871 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1872 */                 .addNextBehavior(
/* 1873 */                   CECombatBehaviors.Behavior.builder()
/* 1874 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1875 */                   .withinDistance(0.0D, 5.0D)
/* 1876 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1884 */       .addFirstBehavior(
/* 1885 */         CECombatBehaviors.Behavior.builder()
/* 1886 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1887 */         .withinDistance(0.0D, 3.0D)
/* 1888 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1889 */         .addNextBehavior(
/* 1890 */           CECombatBehaviors.Behavior.builder()
/* 1891 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1892 */           .withinDistance(0.0D, 3.0D)
/* 1893 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1894 */           .addNextBehavior(
/* 1895 */             CECombatBehaviors.Behavior.builder()
/* 1896 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1897 */             .withinDistance(0.0D, 4.0D)
/* 1898 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1899 */             .addNextBehavior(
/* 1900 */               CECombatBehaviors.Behavior.builder()
/* 1901 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1902 */               .withinDistance(0.0D, 4.0D)
/* 1903 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1904 */               .addNextBehavior(
/* 1905 */                 CECombatBehaviors.Behavior.builder()
/* 1906 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1907 */                 .withinDistance(0.0D, 5.0D)
/* 1908 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1909 */                 .addNextBehavior(
/* 1910 */                   CECombatBehaviors.Behavior.builder()
/* 1911 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1912 */                   .withinDistance(0.0D, 5.0D)
/* 1913 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1921 */       .addFirstBehavior(
/* 1922 */         CECombatBehaviors.Behavior.builder()
/* 1923 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1924 */         .withinDistance(0.0D, 3.0D)
/* 1925 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1926 */         .addNextBehavior(
/* 1927 */           CECombatBehaviors.Behavior.builder()
/* 1928 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1929 */           .withinDistance(0.0D, 3.0D)
/* 1930 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1931 */           .addNextBehavior(
/* 1932 */             CECombatBehaviors.Behavior.builder()
/* 1933 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1934 */             .withinDistance(0.0D, 4.0D)
/* 1935 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1936 */             .addNextBehavior(
/* 1937 */               CECombatBehaviors.Behavior.builder()
/* 1938 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1939 */               .withinDistance(0.0D, 4.0D)
/* 1940 */               .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 1941 */               .addNextBehavior(
/* 1942 */                 CECombatBehaviors.Behavior.builder()
/* 1943 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1944 */                 .withinDistance(0.0D, 5.0D)
/* 1945 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1946 */                 .addNextBehavior(
/* 1947 */                   CECombatBehaviors.Behavior.builder()
/* 1948 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1949 */                   .withinDistance(0.0D, 5.0D)
/* 1950 */                   .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
/* 1951 */                   .addNextBehavior(
/* 1952 */                     CECombatBehaviors.Behavior.builder()
/* 1953 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1954 */                     .withinDistance(0.0D, 5.0D)
/* 1955 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1964 */       .addFirstBehavior(
/* 1965 */         CECombatBehaviors.Behavior.builder()
/* 1966 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1967 */         .withinDistance(0.0D, 3.0D)
/* 1968 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 1969 */         .addNextBehavior(
/* 1970 */           CECombatBehaviors.Behavior.builder()
/* 1971 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1972 */           .withinDistance(0.0D, 3.0D)
/* 1973 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1974 */           .addNextBehavior(
/* 1975 */             CECombatBehaviors.Behavior.builder()
/* 1976 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1977 */             .withinDistance(0.0D, 4.0D)
/* 1978 */             .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/* 1979 */             .addNextBehavior(
/* 1980 */               CECombatBehaviors.Behavior.builder()
/* 1981 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1982 */               .withinDistance(0.0D, 4.0D)
/* 1983 */               .animationBehavior(Animations.SHARP_STAB, 0.0F)
/* 1984 */               .addNextBehavior(
/* 1985 */                 CECombatBehaviors.Behavior.builder()
/* 1986 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1987 */                 .withinDistance(0.0D, 5.0D)
/* 1988 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1989 */                 .addNextBehavior(
/* 1990 */                   CECombatBehaviors.Behavior.builder()
/* 1991 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1992 */                   .withinDistance(0.0D, 5.0D)
/* 1993 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2001 */       .addFirstBehavior(
/* 2002 */         CECombatBehaviors.Behavior.builder()
/* 2003 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2004 */         .withinDistance(0.0D, 3.0D)
/* 2005 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2006 */         .addNextBehavior(
/* 2007 */           CECombatBehaviors.Behavior.builder()
/* 2008 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2009 */           .withinDistance(0.0D, 3.0D)
/* 2010 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 2011 */           .addNextBehavior(
/* 2012 */             CECombatBehaviors.Behavior.builder()
/* 2013 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2014 */             .withinDistance(0.0D, 4.0D)
/* 2015 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2016 */             .addNextBehavior(
/* 2017 */               CECombatBehaviors.Behavior.builder()
/* 2018 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2019 */               .withinDistance(0.0D, 4.0D)
/* 2020 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2021 */               .addNextBehavior(
/* 2022 */                 CECombatBehaviors.Behavior.builder()
/* 2023 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2024 */                 .withinDistance(0.0D, 5.0D)
/* 2025 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2026 */                 .addNextBehavior(
/* 2027 */                   CECombatBehaviors.Behavior.builder()
/* 2028 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2029 */                   .withinDistance(0.0D, 5.0D)
/* 2030 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2038 */       .addFirstBehavior(
/* 2039 */         CECombatBehaviors.Behavior.builder()
/* 2040 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2041 */         .withinDistance(0.0D, 3.0D)
/* 2042 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2043 */         .addNextBehavior(
/* 2044 */           CECombatBehaviors.Behavior.builder()
/* 2045 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2046 */           .withinDistance(0.0D, 3.0D)
/* 2047 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2048 */           .addNextBehavior(
/* 2049 */             CECombatBehaviors.Behavior.builder()
/* 2050 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2051 */             .withinDistance(0.0D, 4.0D)
/* 2052 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2053 */             .addNextBehavior(
/* 2054 */               CECombatBehaviors.Behavior.builder()
/* 2055 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2056 */               .withinDistance(0.0D, 4.0D)
/* 2057 */               .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 2058 */               .addNextBehavior(
/* 2059 */                 CECombatBehaviors.Behavior.builder()
/* 2060 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2061 */                 .withinDistance(0.0D, 5.0D)
/* 2062 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2063 */                 .addNextBehavior(
/* 2064 */                   CECombatBehaviors.Behavior.builder()
/* 2065 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2066 */                   .withinDistance(0.0D, 5.0D)
/* 2067 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2075 */       .addFirstBehavior(
/* 2076 */         CECombatBehaviors.Behavior.builder()
/* 2077 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2078 */         .withinDistance(0.0D, 3.0D)
/* 2079 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2080 */         .addNextBehavior(
/* 2081 */           CECombatBehaviors.Behavior.builder()
/* 2082 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2083 */           .withinDistance(0.0D, 3.0D)
/* 2084 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 2085 */           .addNextBehavior(
/* 2086 */             CECombatBehaviors.Behavior.builder()
/* 2087 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2088 */             .withinDistance(0.0D, 4.0D)
/* 2089 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2090 */             .addNextBehavior(
/* 2091 */               CECombatBehaviors.Behavior.builder()
/* 2092 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2093 */               .withinDistance(0.0D, 4.0D)
/* 2094 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2095 */               .addNextBehavior(
/* 2096 */                 CECombatBehaviors.Behavior.builder()
/* 2097 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2098 */                 .withinDistance(0.0D, 5.0D)
/* 2099 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2100 */                 .addNextBehavior(
/* 2101 */                   CECombatBehaviors.Behavior.builder()
/* 2102 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2103 */                   .withinDistance(0.0D, 5.0D)
/* 2104 */                   .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
/* 2105 */                   .addNextBehavior(
/* 2106 */                     CECombatBehaviors.Behavior.builder()
/* 2107 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2108 */                     .withinDistance(0.0D, 5.0D)
/* 2109 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2118 */       .addFirstBehavior(
/* 2119 */         CECombatBehaviors.Behavior.builder()
/* 2120 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2121 */         .withinDistance(0.0D, 3.0D)
/* 2122 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2123 */         .addNextBehavior(
/* 2124 */           CECombatBehaviors.Behavior.builder()
/* 2125 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2126 */           .withinDistance(0.0D, 3.0D)
/* 2127 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2128 */           .addNextBehavior(
/* 2129 */             CECombatBehaviors.Behavior.builder()
/* 2130 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2131 */             .withinDistance(0.0D, 4.0D)
/* 2132 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 2133 */             .addNextBehavior(
/* 2134 */               CECombatBehaviors.Behavior.builder()
/* 2135 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2136 */               .withinDistance(0.0D, 4.0D)
/* 2137 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2138 */               .addNextBehavior(
/* 2139 */                 CECombatBehaviors.Behavior.builder()
/* 2140 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2141 */                 .withinDistance(0.0D, 5.0D)
/* 2142 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2143 */                 .addNextBehavior(
/* 2144 */                   CECombatBehaviors.Behavior.builder()
/* 2145 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2146 */                   .withinDistance(0.0D, 5.0D)
/* 2147 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2155 */       .addFirstBehavior(
/* 2156 */         CECombatBehaviors.Behavior.builder()
/* 2157 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2158 */         .withinDistance(0.0D, 3.0D)
/* 2159 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2160 */         .addNextBehavior(
/* 2161 */           CECombatBehaviors.Behavior.builder()
/* 2162 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2163 */           .withinDistance(0.0D, 3.0D)
/* 2164 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2165 */           .addNextBehavior(
/* 2166 */             CECombatBehaviors.Behavior.builder()
/* 2167 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2168 */             .withinDistance(0.0D, 4.0D)
/* 2169 */             .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 2170 */             .addNextBehavior(
/* 2171 */               CECombatBehaviors.Behavior.builder()
/* 2172 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2173 */               .withinDistance(0.0D, 4.0D)
/* 2174 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2175 */               .addNextBehavior(
/* 2176 */                 CECombatBehaviors.Behavior.builder()
/* 2177 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2178 */                 .withinDistance(0.0D, 5.0D)
/* 2179 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2180 */                 .addNextBehavior(
/* 2181 */                   CECombatBehaviors.Behavior.builder()
/* 2182 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2183 */                   .withinDistance(0.0D, 5.0D)
/* 2184 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2192 */       .addFirstBehavior(
/* 2193 */         CECombatBehaviors.Behavior.builder()
/* 2194 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2195 */         .withinDistance(0.0D, 3.0D)
/* 2196 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2197 */         .addNextBehavior(
/* 2198 */           CECombatBehaviors.Behavior.builder()
/* 2199 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2200 */           .withinDistance(0.0D, 3.0D)
/* 2201 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2202 */           .addNextBehavior(
/* 2203 */             CECombatBehaviors.Behavior.builder()
/* 2204 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2205 */             .withinDistance(0.0D, 4.0D)
/* 2206 */             .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/* 2207 */             .addNextBehavior(
/* 2208 */               CECombatBehaviors.Behavior.builder()
/* 2209 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2210 */               .withinDistance(0.0D, 4.0D)
/* 2211 */               .animationBehavior(Animations.SHARP_STAB, 0.0F)
/* 2212 */               .addNextBehavior(
/* 2213 */                 CECombatBehaviors.Behavior.builder()
/* 2214 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2215 */                 .withinDistance(0.0D, 5.0D)
/* 2216 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2217 */                 .addNextBehavior(
/* 2218 */                   CECombatBehaviors.Behavior.builder()
/* 2219 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2220 */                   .withinDistance(0.0D, 5.0D)
/* 2221 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2222 */                   .addNextBehavior(
/* 2223 */                     CECombatBehaviors.Behavior.builder()
/* 2224 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2225 */                     .withinDistance(0.0D, 5.0D)
/* 2226 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2235 */       .addFirstBehavior(
/* 2236 */         CECombatBehaviors.Behavior.builder()
/* 2237 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2238 */         .withinDistance(0.0D, 3.0D)
/* 2239 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2240 */         .addNextBehavior(
/* 2241 */           CECombatBehaviors.Behavior.builder()
/* 2242 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2243 */           .withinDistance(0.0D, 3.0D)
/* 2244 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 2245 */           .addNextBehavior(
/* 2246 */             CECombatBehaviors.Behavior.builder()
/* 2247 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2248 */             .withinDistance(0.0D, 4.0D)
/* 2249 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2250 */             .addNextBehavior(
/* 2251 */               CECombatBehaviors.Behavior.builder()
/* 2252 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2253 */               .withinDistance(0.0D, 4.0D)
/* 2254 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2255 */               .addNextBehavior(
/* 2256 */                 CECombatBehaviors.Behavior.builder()
/* 2257 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2258 */                 .withinDistance(0.0D, 5.0D)
/* 2259 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2260 */                 .addNextBehavior(
/* 2261 */                   CECombatBehaviors.Behavior.builder()
/* 2262 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2263 */                   .withinDistance(0.0D, 5.0D)
/* 2264 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2272 */       .addFirstBehavior(
/* 2273 */         CECombatBehaviors.Behavior.builder()
/* 2274 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2275 */         .withinDistance(0.0D, 3.0D)
/* 2276 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2277 */         .addNextBehavior(
/* 2278 */           CECombatBehaviors.Behavior.builder()
/* 2279 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2280 */           .withinDistance(0.0D, 3.0D)
/* 2281 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2282 */           .addNextBehavior(
/* 2283 */             CECombatBehaviors.Behavior.builder()
/* 2284 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2285 */             .withinDistance(0.0D, 4.0D)
/* 2286 */             .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 2287 */             .addNextBehavior(
/* 2288 */               CECombatBehaviors.Behavior.builder()
/* 2289 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2290 */               .withinDistance(0.0D, 4.0D)
/* 2291 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2292 */               .addNextBehavior(
/* 2293 */                 CECombatBehaviors.Behavior.builder()
/* 2294 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2295 */                 .withinDistance(0.0D, 5.0D)
/* 2296 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2297 */                 .addNextBehavior(
/* 2298 */                   CECombatBehaviors.Behavior.builder()
/* 2299 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2300 */                   .withinDistance(0.0D, 5.0D)
/* 2301 */                   .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
/* 2302 */                   .addNextBehavior(
/* 2303 */                     CECombatBehaviors.Behavior.builder()
/* 2304 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2305 */                     .withinDistance(0.0D, 5.0D)
/* 2306 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2315 */       .addFirstBehavior(
/* 2316 */         CECombatBehaviors.Behavior.builder()
/* 2317 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2318 */         .withinDistance(0.0D, 3.0D)
/* 2319 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2320 */         .addNextBehavior(
/* 2321 */           CECombatBehaviors.Behavior.builder()
/* 2322 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2323 */           .withinDistance(0.0D, 3.0D)
/* 2324 */           .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2325 */           .addNextBehavior(
/* 2326 */             CECombatBehaviors.Behavior.builder()
/* 2327 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2328 */             .withinDistance(0.0D, 4.0D)
/* 2329 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2330 */             .addNextBehavior(
/* 2331 */               CECombatBehaviors.Behavior.builder()
/* 2332 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2333 */               .withinDistance(0.0D, 4.0D)
/* 2334 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 2335 */               .addNextBehavior(
/* 2336 */                 CECombatBehaviors.Behavior.builder()
/* 2337 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2338 */                 .withinDistance(0.0D, 5.0D)
/* 2339 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2340 */                 .addNextBehavior(
/* 2341 */                   CECombatBehaviors.Behavior.builder()
/* 2342 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2343 */                   .withinDistance(0.0D, 5.0D)
/* 2344 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2352 */       .addFirstBehavior(
/* 2353 */         CECombatBehaviors.Behavior.builder()
/* 2354 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2355 */         .withinDistance(0.0D, 3.0D)
/* 2356 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2357 */         .addNextBehavior(
/* 2358 */           CECombatBehaviors.Behavior.builder()
/* 2359 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2360 */           .withinDistance(0.0D, 3.0D)
/* 2361 */           .animationBehavior(Animations.LONGSWORD_DASH, 0.0F)
/* 2362 */           .addNextBehavior(
/* 2363 */             CECombatBehaviors.Behavior.builder()
/* 2364 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2365 */             .withinDistance(0.0D, 4.0D)
/* 2366 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2367 */             .addNextBehavior(
/* 2368 */               CECombatBehaviors.Behavior.builder()
/* 2369 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2370 */               .withinDistance(0.0D, 4.0D)
/* 2371 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2372 */               .addNextBehavior(
/* 2373 */                 CECombatBehaviors.Behavior.builder()
/* 2374 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2375 */                 .withinDistance(0.0D, 5.0D)
/* 2376 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2377 */                 .addNextBehavior(
/* 2378 */                   CECombatBehaviors.Behavior.builder()
/* 2379 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2380 */                   .withinDistance(0.0D, 5.0D)
/* 2381 */                   .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
/* 2382 */                   .addNextBehavior(
/* 2383 */                     CECombatBehaviors.Behavior.builder()
/* 2384 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2385 */                     .withinDistance(0.0D, 5.0D)
/* 2386 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2395 */       .addFirstBehavior(
/* 2396 */         CECombatBehaviors.Behavior.builder()
/* 2397 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2398 */         .withinDistance(0.0D, 3.0D)
/* 2399 */         .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2400 */         .addNextBehavior(
/* 2401 */           CECombatBehaviors.Behavior.builder()
/* 2402 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2403 */           .withinDistance(0.0D, 3.0D)
/* 2404 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 2405 */           .addNextBehavior(
/* 2406 */             CECombatBehaviors.Behavior.builder()
/* 2407 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2408 */             .withinDistance(0.0D, 4.0D)
/* 2409 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 2410 */             .addNextBehavior(
/* 2411 */               CECombatBehaviors.Behavior.builder()
/* 2412 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2413 */               .withinDistance(0.0D, 4.0D)
/* 2414 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 2415 */               .addNextBehavior(
/* 2416 */                 CECombatBehaviors.Behavior.builder()
/* 2417 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2418 */                 .withinDistance(0.0D, 5.0D)
/* 2419 */                 .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2420 */                 .addNextBehavior(
/* 2421 */                   CECombatBehaviors.Behavior.builder()
/* 2422 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2423 */                   .withinDistance(0.0D, 5.0D)
/* 2424 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2433 */     .newBehaviorRoot(
/* 2434 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2435 */       .priority(1.0D)
/* 2436 */       .weight(20.0D)
/* 2437 */       .maxCooldown(100)
/* 2438 */       .addFirstBehavior(
/* 2439 */         CECombatBehaviors.Behavior.builder()
/* 2440 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2441 */         .withinDistance(0.0D, 3.0D)
/* 2442 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2443 */         .addNextBehavior(
/* 2444 */           CECombatBehaviors.Behavior.builder()
/* 2445 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2446 */           .withinDistance(0.0D, 3.0D)
/* 2447 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2448 */           .addNextBehavior(
/* 2449 */             CECombatBehaviors.Behavior.builder()
/* 2450 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2451 */             .withinDistance(0.0D, 3.0D)
/* 2452 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2457 */     .newBehaviorRoot(
/* 2458 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2459 */       .priority(1.0D)
/* 2460 */       .weight(10.0D)
/* 2461 */       .maxCooldown(100)
/* 2462 */       .addFirstBehavior(
/* 2463 */         CECombatBehaviors.Behavior.builder()
/* 2464 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2465 */         .withinDistance(0.0D, 3.0D)
/* 2466 */         .animationBehavior(Animations.LONGSWORD_DASH, 0.0F))
/*      */       
/* 2468 */       .addFirstBehavior(
/* 2469 */         CECombatBehaviors.Behavior.builder()
/* 2470 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2471 */         .withinDistance(0.0D, 3.0D)
/* 2472 */         .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F))
/*      */       
/* 2474 */       .addFirstBehavior(
/* 2475 */         CECombatBehaviors.Behavior.builder()
/* 2476 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2477 */         .withinDistance(0.0D, 3.0D)
/* 2478 */         .animationBehavior(Animations.BATTOJUTSU, 0.0F)
/* 2479 */         .addNextBehavior(
/* 2480 */           CECombatBehaviors.Behavior.builder()
/* 2481 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2482 */           .withinDistance(0.0D, 3.0D)
/* 2483 */           .animationBehavior(Animations.SHARP_STAB, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/* 2487 */     .newBehaviorRoot(
/* 2488 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2489 */       .priority(1.0D)
/* 2490 */       .weight(10.0D)
/* 2491 */       .maxCooldown(40)
/* 2492 */       .addFirstBehavior(
/* 2493 */         CECombatBehaviors.Behavior.builder()
/* 2494 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2495 */         .withinDistance(0.0D, 3.0D)
/* 2496 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2497 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2498 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 2501 */     .newBehaviorRoot(
/* 2502 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2503 */       .priority(1.0D)
/* 2504 */       .weight(2.0D)
/* 2505 */       .maxCooldown(100)
/* 2506 */       .addFirstBehavior(
/* 2507 */         CECombatBehaviors.Behavior.builder()
/* 2508 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2509 */         .withinDistance(0.0D, 3.0D)
/* 2510 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 2512 */       .addFirstBehavior(
/* 2513 */         CECombatBehaviors.Behavior.builder()
/* 2514 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2515 */         .withinDistance(0.0D, 3.0D)
/* 2516 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 2518 */       .addFirstBehavior(
/* 2519 */         CECombatBehaviors.Behavior.builder()
/* 2520 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2521 */         .withinDistance(0.0D, 3.0D)
/* 2522 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 2524 */       .addFirstBehavior(
/* 2525 */         CECombatBehaviors.Behavior.builder()
/* 2526 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2527 */         .withinDistance(0.0D, 3.0D)
/* 2528 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 2530 */       .addFirstBehavior(
/* 2531 */         CECombatBehaviors.Behavior.builder()
/* 2532 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2533 */         .withinDistance(0.0D, 3.0D)
/* 2534 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 2536 */       .addFirstBehavior(
/* 2537 */         CECombatBehaviors.Behavior.builder()
/* 2538 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2539 */         .withinDistance(0.0D, 3.0D)
/* 2540 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 2542 */       .addFirstBehavior(
/* 2543 */         CECombatBehaviors.Behavior.builder()
/* 2544 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2545 */         .withinDistance(0.0D, 3.0D)
/* 2546 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 2549 */     .newBehaviorRoot(
/* 2550 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2551 */       .priority(1.0D)
/* 2552 */       .weight(15.0D)
/* 2553 */       .addFirstBehavior(
/* 2554 */         CECombatBehaviors.Behavior.builder()
/* 2555 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2556 */         .withinDistance(0.0D, 3.0D)
/* 2557 */         .custom(CombatCommon::canPerformGuarding)
/* 2558 */         .guard(40)))
/*      */ 
/*      */     
/* 2561 */     .newBehaviorRoot(
/* 2562 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2563 */       .priority(1.0D)
/* 2564 */       .weight(10.0D)
/* 2565 */       .addFirstBehavior(
/* 2566 */         CECombatBehaviors.Behavior.builder()
/* 2567 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2568 */         .withinDistance(0.0D, 3.0D)
/* 2569 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 2571 */       .addFirstBehavior(
/* 2572 */         CECombatBehaviors.Behavior.builder()
/* 2573 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2574 */         .withinDistance(0.0D, 3.0D)
/* 2575 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 2578 */     .newBehaviorRoot(
/* 2579 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2580 */       .priority(1.0D)
/* 2581 */       .weight(40.0D)
/* 2582 */       .maxCooldown(160)
/* 2583 */       .addFirstBehavior(
/* 2584 */         CECombatBehaviors.Behavior.builder()
/* 2585 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2586 */         .custom(CombatCommon::canJump)
/* 2587 */         .withinDistance(5.0D, 14.0D)
/* 2588 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2589 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 2593 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_LONGSWORD = CECombatBehaviors.builder()
/* 2594 */     .newBehaviorRoot(
/* 2595 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2596 */       .priority(4.0D)
/* 2597 */       .weight(1000.0D)
/* 2598 */       .maxCooldown(0)
/* 2599 */       .addFirstBehavior(
/* 2600 */         CECombatBehaviors.Behavior.builder()
/* 2601 */         .custom(CombatCommon::canExecute)
/* 2602 */         .withinDistance(0.0D, 5.0D)
/* 2603 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 2604 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 2607 */     .newBehaviorRoot(
/* 2608 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2609 */       .priority(3.0D)
/* 2610 */       .weight(1000.0D)
/* 2611 */       .maxCooldown(0)
/* 2612 */       .addFirstBehavior(
/* 2613 */         CECombatBehaviors.Behavior.builder()
/* 2614 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2615 */         .custom(CombatCommon::canEscape)
/* 2616 */         .withinDistance(0.0D, 8.0D)
/* 2617 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2618 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 2620 */       .addFirstBehavior(
/* 2621 */         CECombatBehaviors.Behavior.builder()
/* 2622 */         .custom(CombatCommon::canEscape)
/* 2623 */         .withinDistance(0.0D, 48.0D)
/* 2624 */         .guard(40)))
/*      */ 
/*      */     
/* 2627 */     .newBehaviorRoot(
/* 2628 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2629 */       .priority(2.0D)
/* 2630 */       .weight(70.0D)
/* 2631 */       .maxCooldown(0)
/* 2632 */       .addFirstBehavior(
/* 2633 */         CECombatBehaviors.Behavior.builder()
/* 2634 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 2635 */         .custom(CombatCommon::canPerformEating)
/* 2636 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2637 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 2640 */     .newBehaviorRoot(
/* 2641 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2642 */       .priority(2.0D)
/* 2643 */       .weight(100.0D)
/* 2644 */       .maxCooldown(120)
/* 2645 */       .addFirstBehavior(
/* 2646 */         CECombatBehaviors.Behavior.builder()
/* 2647 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2648 */         .custom(CombatCommon::canSwapToBow)
/* 2649 */         .withinDistance(7.0D, 14.0D)
/* 2650 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2651 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 2653 */       .addFirstBehavior(
/* 2654 */         CECombatBehaviors.Behavior.builder()
/* 2655 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2656 */         .custom(CombatCommon::canSwapToBow)
/* 2657 */         .withinDistance(7.0D, 14.0D)
/* 2658 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 2659 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 2662 */     .newBehaviorRoot(
/* 2663 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2664 */       .priority(2.0D)
/* 2665 */       .weight(80.0D)
/* 2666 */       .maxCooldown(120)
/* 2667 */       .addFirstBehavior(
/* 2668 */         CECombatBehaviors.Behavior.builder()
/* 2669 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2670 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2671 */         .withinDistance(7.0D, 48.0D)
/* 2672 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2673 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 2676 */     .newBehaviorRoot(
/* 2677 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2678 */       .priority(1.0D)
/* 2679 */       .weight(40.0D)
/* 2680 */       .addFirstBehavior(
/* 2681 */         CECombatBehaviors.Behavior.builder()
/* 2682 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2683 */         .withinDistance(0.0D, 3.0D)
/* 2684 */         .animationBehavior(AVAnimations.LONGSWORD_AUTO1, 0.0F)
/* 2685 */         .addNextBehavior(
/* 2686 */           CECombatBehaviors.Behavior.builder()
/* 2687 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2688 */           .withinDistance(0.0D, 3.0D)
/* 2689 */           .animationBehavior(Animations.LONGSWORD_AUTO1, 0.0F)
/* 2690 */           .addNextBehavior(
/* 2691 */             CECombatBehaviors.Behavior.builder()
/* 2692 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2693 */             .withinDistance(0.0D, 3.0D)
/* 2694 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2695 */             .addNextBehavior(
/* 2696 */               CECombatBehaviors.Behavior.builder()
/* 2697 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2698 */               .withinDistance(0.0D, 3.0D)
/* 2699 */               .animationBehavior(Animations.LONGSWORD_AUTO3, 0.0F)
/* 2700 */               .addNextBehavior(
/* 2701 */                 CECombatBehaviors.Behavior.builder()
/* 2702 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2703 */                 .withinDistance(0.0D, 3.0D)
/* 2704 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO1, 0.0F)
/* 2705 */                 .addNextBehavior(
/* 2706 */                   CECombatBehaviors.Behavior.builder()
/* 2707 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2708 */                   .withinDistance(0.0D, 3.0D)
/* 2709 */                   .animationBehavior(AVAnimations.DUAL_SWORD_AUTO2, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2717 */     .newBehaviorRoot(
/* 2718 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2719 */       .priority(1.0D)
/* 2720 */       .weight(20.0D)
/* 2721 */       .maxCooldown(100)
/* 2722 */       .addFirstBehavior(
/* 2723 */         CECombatBehaviors.Behavior.builder()
/* 2724 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2725 */         .withinDistance(0.0D, 3.0D)
/* 2726 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 2727 */         .addNextBehavior(
/* 2728 */           CECombatBehaviors.Behavior.builder()
/* 2729 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2730 */           .withinDistance(0.0D, 3.0D)
/* 2731 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 2732 */           .addNextBehavior(
/* 2733 */             CECombatBehaviors.Behavior.builder()
/* 2734 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2735 */             .withinDistance(0.0D, 3.0D)
/* 2736 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2741 */     .newBehaviorRoot(
/* 2742 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2743 */       .priority(1.0D)
/* 2744 */       .weight(10.0D)
/* 2745 */       .maxCooldown(100)
/* 2746 */       .addFirstBehavior(
/* 2747 */         CECombatBehaviors.Behavior.builder()
/* 2748 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2749 */         .withinDistance(0.0D, 3.0D)
/* 2750 */         .animationBehavior(Animations.LONGSWORD_DASH, 0.0F))
/*      */       
/* 2752 */       .addFirstBehavior(
/* 2753 */         CECombatBehaviors.Behavior.builder()
/* 2754 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2755 */         .withinDistance(0.0D, 3.0D)
/* 2756 */         .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F))
/*      */       
/* 2758 */       .addFirstBehavior(
/* 2759 */         CECombatBehaviors.Behavior.builder()
/* 2760 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2761 */         .withinDistance(0.0D, 3.0D)
/* 2762 */         .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 2763 */         .addNextBehavior(
/* 2764 */           CECombatBehaviors.Behavior.builder()
/* 2765 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2766 */           .withinDistance(0.0D, 3.0D)
/* 2767 */           .animationBehavior(AnimsRuine.RUINE_AUTO_2, 0.0F)
/* 2768 */           .addNextBehavior(
/* 2769 */             CECombatBehaviors.Behavior.builder()
/* 2770 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2771 */             .withinDistance(0.0D, 3.0D)
/* 2772 */             .animationBehavior(AnimsRuine.RUINE_AUTO_3, 0.0F)
/* 2773 */             .addNextBehavior(
/* 2774 */               CECombatBehaviors.Behavior.builder()
/* 2775 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2776 */               .withinDistance(0.0D, 3.0D)
/* 2777 */               .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2783 */     .newBehaviorRoot(
/* 2784 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2785 */       .priority(1.0D)
/* 2786 */       .weight(10.0D)
/* 2787 */       .maxCooldown(40)
/* 2788 */       .addFirstBehavior(
/* 2789 */         CECombatBehaviors.Behavior.builder()
/* 2790 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2791 */         .withinDistance(0.0D, 3.0D)
/* 2792 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2793 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2794 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 2797 */     .newBehaviorRoot(
/* 2798 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2799 */       .priority(1.0D)
/* 2800 */       .weight(2.0D)
/* 2801 */       .maxCooldown(100)
/* 2802 */       .addFirstBehavior(
/* 2803 */         CECombatBehaviors.Behavior.builder()
/* 2804 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2805 */         .withinDistance(0.0D, 3.0D)
/* 2806 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 2808 */       .addFirstBehavior(
/* 2809 */         CECombatBehaviors.Behavior.builder()
/* 2810 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2811 */         .withinDistance(0.0D, 3.0D)
/* 2812 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 2814 */       .addFirstBehavior(
/* 2815 */         CECombatBehaviors.Behavior.builder()
/* 2816 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2817 */         .withinDistance(0.0D, 3.0D)
/* 2818 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 2820 */       .addFirstBehavior(
/* 2821 */         CECombatBehaviors.Behavior.builder()
/* 2822 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2823 */         .withinDistance(0.0D, 3.0D)
/* 2824 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 2826 */       .addFirstBehavior(
/* 2827 */         CECombatBehaviors.Behavior.builder()
/* 2828 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2829 */         .withinDistance(0.0D, 3.0D)
/* 2830 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 2832 */       .addFirstBehavior(
/* 2833 */         CECombatBehaviors.Behavior.builder()
/* 2834 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2835 */         .withinDistance(0.0D, 3.0D)
/* 2836 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 2838 */       .addFirstBehavior(
/* 2839 */         CECombatBehaviors.Behavior.builder()
/* 2840 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2841 */         .withinDistance(0.0D, 3.0D)
/* 2842 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 2845 */     .newBehaviorRoot(
/* 2846 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2847 */       .priority(1.0D)
/* 2848 */       .weight(15.0D)
/* 2849 */       .addFirstBehavior(
/* 2850 */         CECombatBehaviors.Behavior.builder()
/* 2851 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2852 */         .withinDistance(0.0D, 3.0D)
/* 2853 */         .custom(CombatCommon::canPerformGuarding)
/* 2854 */         .guard(40)))
/*      */ 
/*      */     
/* 2857 */     .newBehaviorRoot(
/* 2858 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2859 */       .priority(1.0D)
/* 2860 */       .weight(10.0D)
/* 2861 */       .addFirstBehavior(
/* 2862 */         CECombatBehaviors.Behavior.builder()
/* 2863 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2864 */         .withinDistance(0.0D, 3.0D)
/* 2865 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 2867 */       .addFirstBehavior(
/* 2868 */         CECombatBehaviors.Behavior.builder()
/* 2869 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2870 */         .withinDistance(0.0D, 3.0D)
/* 2871 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 2874 */     .newBehaviorRoot(
/* 2875 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2876 */       .priority(1.0D)
/* 2877 */       .weight(40.0D)
/* 2878 */       .maxCooldown(160)
/* 2879 */       .addFirstBehavior(
/* 2880 */         CECombatBehaviors.Behavior.builder()
/* 2881 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2882 */         .custom(CombatCommon::canJump)
/* 2883 */         .withinDistance(5.0D, 14.0D)
/* 2884 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2885 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcLongsword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */