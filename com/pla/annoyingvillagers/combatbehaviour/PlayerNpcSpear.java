/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.efkick.gameasset.EFKickAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PlayerNpcSpear
/*      */ {
/*   16 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SPEAR_SHIELD = CECombatBehaviors.builder()
/*   17 */     .newBehaviorRoot(
/*   18 */       CECombatBehaviors.BehaviorRoot.builder()
/*   19 */       .priority(4.0D)
/*   20 */       .weight(1000.0D)
/*   21 */       .maxCooldown(0)
/*   22 */       .addFirstBehavior(
/*   23 */         CECombatBehaviors.Behavior.builder()
/*   24 */         .custom(CombatCommon::canExecute)
/*   25 */         .withinDistance(0.0D, 5.0D)
/*   26 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*   27 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*   30 */     .newBehaviorRoot(
/*   31 */       CECombatBehaviors.BehaviorRoot.builder()
/*   32 */       .priority(3.0D)
/*   33 */       .weight(1000.0D)
/*   34 */       .maxCooldown(0)
/*   35 */       .addFirstBehavior(
/*   36 */         CECombatBehaviors.Behavior.builder()
/*   37 */         .custom(CombatCommon::canEscape)
/*   38 */         .withinDistance(0.0D, 8.0D)
/*   39 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   40 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*   42 */       .addFirstBehavior(
/*   43 */         CECombatBehaviors.Behavior.builder()
/*   44 */         .custom(CombatCommon::canEscape)
/*   45 */         .withinDistance(0.0D, 48.0D)
/*   46 */         .guard(40)))
/*      */ 
/*      */     
/*   49 */     .newBehaviorRoot(
/*   50 */       CECombatBehaviors.BehaviorRoot.builder()
/*   51 */       .priority(2.0D)
/*   52 */       .weight(70.0D)
/*   53 */       .maxCooldown(0)
/*   54 */       .addFirstBehavior(
/*   55 */         CECombatBehaviors.Behavior.builder()
/*   56 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   57 */         .custom(CombatCommon::canPerformEating)
/*   58 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   59 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*   62 */     .newBehaviorRoot(
/*   63 */       CECombatBehaviors.BehaviorRoot.builder()
/*   64 */       .priority(2.0D)
/*   65 */       .weight(100.0D)
/*   66 */       .maxCooldown(120)
/*   67 */       .addFirstBehavior(
/*   68 */         CECombatBehaviors.Behavior.builder()
/*   69 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   70 */         .custom(CombatCommon::canSwapToBow)
/*   71 */         .withinDistance(7.0D, 14.0D)
/*   72 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   73 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   75 */       .addFirstBehavior(
/*   76 */         CECombatBehaviors.Behavior.builder()
/*   77 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   78 */         .custom(CombatCommon::canSwapToBow)
/*   79 */         .withinDistance(7.0D, 14.0D)
/*   80 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*   81 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*   84 */     .newBehaviorRoot(
/*   85 */       CECombatBehaviors.BehaviorRoot.builder()
/*   86 */       .priority(2.0D)
/*   87 */       .weight(80.0D)
/*   88 */       .maxCooldown(120)
/*   89 */       .addFirstBehavior(
/*   90 */         CECombatBehaviors.Behavior.builder()
/*   91 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   92 */         .custom(CombatCommon::canThrowEnderPearl)
/*   93 */         .withinDistance(7.0D, 48.0D)
/*   94 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*   95 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*   98 */     .newBehaviorRoot(
/*   99 */       CECombatBehaviors.BehaviorRoot.builder()
/*  100 */       .priority(1.0D)
/*  101 */       .weight(40.0D)
/*  102 */       .maxCooldown(20)
/*  103 */       .addFirstBehavior(
/*  104 */         CECombatBehaviors.Behavior.builder()
/*  105 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  106 */         .withinDistance(0.0D, 3.0D)
/*  107 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  108 */         .addNextBehavior(
/*  109 */           CECombatBehaviors.Behavior.builder()
/*  110 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  111 */           .withinDistance(0.0D, 4.0D)
/*  112 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  113 */           .addNextBehavior(
/*  114 */             CECombatBehaviors.Behavior.builder()
/*  115 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  116 */             .withinDistance(0.0D, 5.0D)
/*  117 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  121 */       .addFirstBehavior(
/*  122 */         CECombatBehaviors.Behavior.builder()
/*  123 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  124 */         .withinDistance(0.0D, 3.0D)
/*  125 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  126 */         .addNextBehavior(
/*  127 */           CECombatBehaviors.Behavior.builder()
/*  128 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  129 */           .withinDistance(0.0D, 3.0D)
/*  130 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  131 */           .addNextBehavior(
/*  132 */             CECombatBehaviors.Behavior.builder()
/*  133 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  134 */             .withinDistance(0.0D, 4.0D)
/*  135 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  136 */             .addNextBehavior(
/*  137 */               CECombatBehaviors.Behavior.builder()
/*  138 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  139 */               .withinDistance(0.0D, 4.0D)
/*  140 */               .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/*  141 */               .addNextBehavior(
/*  142 */                 CECombatBehaviors.Behavior.builder()
/*  143 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  144 */                 .withinDistance(0.0D, 5.0D)
/*  145 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  146 */                 .addNextBehavior(
/*  147 */                   CECombatBehaviors.Behavior.builder()
/*  148 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  149 */                   .withinDistance(0.0D, 5.0D)
/*  150 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  151 */                   .addNextBehavior(
/*  152 */                     CECombatBehaviors.Behavior.builder()
/*  153 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  154 */                     .withinDistance(0.0D, 5.0D)
/*  155 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  156 */                     .addNextBehavior(
/*  157 */                       CECombatBehaviors.Behavior.builder()
/*  158 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  159 */                       .withinDistance(0.0D, 5.0D)
/*  160 */                       .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  161 */                       .addNextBehavior(
/*  162 */                         CECombatBehaviors.Behavior.builder()
/*  163 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  164 */                         .withinDistance(0.0D, 5.0D)
/*  165 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/*  176 */       .addFirstBehavior(
/*  177 */         CECombatBehaviors.Behavior.builder()
/*  178 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  179 */         .withinDistance(0.0D, 3.0D)
/*  180 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  181 */         .addNextBehavior(
/*  182 */           CECombatBehaviors.Behavior.builder()
/*  183 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  184 */           .withinDistance(0.0D, 3.0D)
/*  185 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  186 */           .addNextBehavior(
/*  187 */             CECombatBehaviors.Behavior.builder()
/*  188 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  189 */             .withinDistance(0.0D, 4.0D)
/*  190 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  191 */             .addNextBehavior(
/*  192 */               CECombatBehaviors.Behavior.builder()
/*  193 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  194 */               .withinDistance(0.0D, 4.0D)
/*  195 */               .animationBehavior(Animations.SPEAR_ONEHAND_AIR_SLASH, 0.0F)
/*  196 */               .addNextBehavior(
/*  197 */                 CECombatBehaviors.Behavior.builder()
/*  198 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  199 */                 .withinDistance(0.0D, 5.0D)
/*  200 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  201 */                 .addNextBehavior(
/*  202 */                   CECombatBehaviors.Behavior.builder()
/*  203 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  204 */                   .withinDistance(0.0D, 5.0D)
/*  205 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  206 */                   .addNextBehavior(
/*  207 */                     CECombatBehaviors.Behavior.builder()
/*  208 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  209 */                     .withinDistance(0.0D, 5.0D)
/*  210 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  211 */                     .addNextBehavior(
/*  212 */                       CECombatBehaviors.Behavior.builder()
/*  213 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  214 */                       .withinDistance(0.0D, 5.0D)
/*  215 */                       .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  216 */                       .addNextBehavior(
/*  217 */                         CECombatBehaviors.Behavior.builder()
/*  218 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  219 */                         .withinDistance(0.0D, 5.0D)
/*  220 */                         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
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
/*  231 */       .addFirstBehavior(
/*  232 */         CECombatBehaviors.Behavior.builder()
/*  233 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  234 */         .withinDistance(0.0D, 3.0D)
/*  235 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  236 */         .addNextBehavior(
/*  237 */           CECombatBehaviors.Behavior.builder()
/*  238 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  239 */           .withinDistance(0.0D, 3.0D)
/*  240 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  241 */           .addNextBehavior(
/*  242 */             CECombatBehaviors.Behavior.builder()
/*  243 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  244 */             .withinDistance(0.0D, 4.0D)
/*  245 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  246 */             .addNextBehavior(
/*  247 */               CECombatBehaviors.Behavior.builder()
/*  248 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  249 */               .withinDistance(0.0D, 4.0D)
/*  250 */               .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/*  251 */               .addNextBehavior(
/*  252 */                 CECombatBehaviors.Behavior.builder()
/*  253 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  254 */                 .withinDistance(0.0D, 5.0D)
/*  255 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  256 */                 .addNextBehavior(
/*  257 */                   CECombatBehaviors.Behavior.builder()
/*  258 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  259 */                   .withinDistance(0.0D, 5.0D)
/*  260 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  261 */                   .addNextBehavior(
/*  262 */                     CECombatBehaviors.Behavior.builder()
/*  263 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  264 */                     .withinDistance(0.0D, 5.0D)
/*  265 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  266 */                     .addNextBehavior(
/*  267 */                       CECombatBehaviors.Behavior.builder()
/*  268 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  269 */                       .withinDistance(0.0D, 5.0D)
/*  270 */                       .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  271 */                       .addNextBehavior(
/*  272 */                         CECombatBehaviors.Behavior.builder()
/*  273 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  274 */                         .withinDistance(0.0D, 5.0D)
/*  275 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/*  286 */       .addFirstBehavior(
/*  287 */         CECombatBehaviors.Behavior.builder()
/*  288 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  289 */         .withinDistance(0.0D, 3.0D)
/*  290 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  291 */         .addNextBehavior(
/*  292 */           CECombatBehaviors.Behavior.builder()
/*  293 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  294 */           .withinDistance(0.0D, 3.0D)
/*  295 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  296 */           .addNextBehavior(
/*  297 */             CECombatBehaviors.Behavior.builder()
/*  298 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  299 */             .withinDistance(0.0D, 4.0D)
/*  300 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  301 */             .addNextBehavior(
/*  302 */               CECombatBehaviors.Behavior.builder()
/*  303 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  304 */               .withinDistance(0.0D, 4.0D)
/*  305 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  306 */               .addNextBehavior(
/*  307 */                 CECombatBehaviors.Behavior.builder()
/*  308 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  309 */                 .withinDistance(0.0D, 5.0D)
/*  310 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  311 */                 .addNextBehavior(
/*  312 */                   CECombatBehaviors.Behavior.builder()
/*  313 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  314 */                   .withinDistance(0.0D, 5.0D)
/*  315 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  316 */                   .addNextBehavior(
/*  317 */                     CECombatBehaviors.Behavior.builder()
/*  318 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  319 */                     .withinDistance(0.0D, 5.0D)
/*  320 */                     .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/*  321 */                     .addNextBehavior(
/*  322 */                       CECombatBehaviors.Behavior.builder()
/*  323 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  324 */                       .withinDistance(0.0D, 5.0D)
/*  325 */                       .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  326 */                       .addNextBehavior(
/*  327 */                         CECombatBehaviors.Behavior.builder()
/*  328 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  329 */                         .withinDistance(0.0D, 5.0D)
/*  330 */                         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
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
/*  341 */       .addFirstBehavior(
/*  342 */         CECombatBehaviors.Behavior.builder()
/*  343 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  344 */         .withinDistance(0.0D, 3.0D)
/*  345 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  346 */         .addNextBehavior(
/*  347 */           CECombatBehaviors.Behavior.builder()
/*  348 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  349 */           .withinDistance(0.0D, 3.0D)
/*  350 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  351 */           .addNextBehavior(
/*  352 */             CECombatBehaviors.Behavior.builder()
/*  353 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  354 */             .withinDistance(0.0D, 4.0D)
/*  355 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  356 */             .addNextBehavior(
/*  357 */               CECombatBehaviors.Behavior.builder()
/*  358 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  359 */               .withinDistance(0.0D, 4.0D)
/*  360 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  361 */               .addNextBehavior(
/*  362 */                 CECombatBehaviors.Behavior.builder()
/*  363 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  364 */                 .withinDistance(0.0D, 5.0D)
/*  365 */                 .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/*  366 */                 .addNextBehavior(
/*  367 */                   CECombatBehaviors.Behavior.builder()
/*  368 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  369 */                   .withinDistance(0.0D, 5.0D)
/*  370 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  371 */                   .addNextBehavior(
/*  372 */                     CECombatBehaviors.Behavior.builder()
/*  373 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  374 */                     .withinDistance(0.0D, 5.0D)
/*  375 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  376 */                     .addNextBehavior(
/*  377 */                       CECombatBehaviors.Behavior.builder()
/*  378 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  379 */                       .withinDistance(0.0D, 5.0D)
/*  380 */                       .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  381 */                       .addNextBehavior(
/*  382 */                         CECombatBehaviors.Behavior.builder()
/*  383 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  384 */                         .withinDistance(0.0D, 5.0D)
/*  385 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/*  396 */       .addFirstBehavior(
/*  397 */         CECombatBehaviors.Behavior.builder()
/*  398 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  399 */         .withinDistance(0.0D, 3.0D)
/*  400 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  401 */         .addNextBehavior(
/*  402 */           CECombatBehaviors.Behavior.builder()
/*  403 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  404 */           .withinDistance(0.0D, 3.0D)
/*  405 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  406 */           .addNextBehavior(
/*  407 */             CECombatBehaviors.Behavior.builder()
/*  408 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  409 */             .withinDistance(0.0D, 4.0D)
/*  410 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  411 */             .addNextBehavior(
/*  412 */               CECombatBehaviors.Behavior.builder()
/*  413 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  414 */               .withinDistance(0.0D, 4.0D)
/*  415 */               .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/*  416 */               .addNextBehavior(
/*  417 */                 CECombatBehaviors.Behavior.builder()
/*  418 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  419 */                 .withinDistance(0.0D, 5.0D)
/*  420 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  421 */                 .addNextBehavior(
/*  422 */                   CECombatBehaviors.Behavior.builder()
/*  423 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  424 */                   .withinDistance(0.0D, 5.0D)
/*  425 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  426 */                   .addNextBehavior(
/*  427 */                     CECombatBehaviors.Behavior.builder()
/*  428 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  429 */                     .withinDistance(0.0D, 5.0D)
/*  430 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  431 */                     .addNextBehavior(
/*  432 */                       CECombatBehaviors.Behavior.builder()
/*  433 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  434 */                       .withinDistance(0.0D, 5.0D)
/*  435 */                       .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  436 */                       .addNextBehavior(
/*  437 */                         CECombatBehaviors.Behavior.builder()
/*  438 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  439 */                         .withinDistance(0.0D, 5.0D)
/*  440 */                         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
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
/*  451 */       .addFirstBehavior(
/*  452 */         CECombatBehaviors.Behavior.builder()
/*  453 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  454 */         .withinDistance(0.0D, 3.0D)
/*  455 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  456 */         .addNextBehavior(
/*  457 */           CECombatBehaviors.Behavior.builder()
/*  458 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  459 */           .withinDistance(0.0D, 3.0D)
/*  460 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  461 */           .addNextBehavior(
/*  462 */             CECombatBehaviors.Behavior.builder()
/*  463 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  464 */             .withinDistance(0.0D, 4.0D)
/*  465 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  466 */             .addNextBehavior(
/*  467 */               CECombatBehaviors.Behavior.builder()
/*  468 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  469 */               .withinDistance(0.0D, 4.0D)
/*  470 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  471 */               .addNextBehavior(
/*  472 */                 CECombatBehaviors.Behavior.builder()
/*  473 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  474 */                 .withinDistance(0.0D, 5.0D)
/*  475 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  476 */                 .addNextBehavior(
/*  477 */                   CECombatBehaviors.Behavior.builder()
/*  478 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  479 */                   .withinDistance(0.0D, 5.0D)
/*  480 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  481 */                   .addNextBehavior(
/*  482 */                     CECombatBehaviors.Behavior.builder()
/*  483 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  484 */                     .withinDistance(0.0D, 5.0D)
/*  485 */                     .animationBehavior(Animations.SPEAR_ONEHAND_AIR_SLASH, 0.0F)
/*  486 */                     .addNextBehavior(
/*  487 */                       CECombatBehaviors.Behavior.builder()
/*  488 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  489 */                       .withinDistance(0.0D, 5.0D)
/*  490 */                       .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  491 */                       .addNextBehavior(
/*  492 */                         CECombatBehaviors.Behavior.builder()
/*  493 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  494 */                         .withinDistance(0.0D, 5.0D)
/*  495 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/*  506 */       .addFirstBehavior(
/*  507 */         CECombatBehaviors.Behavior.builder()
/*  508 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  509 */         .withinDistance(0.0D, 3.0D)
/*  510 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  511 */         .addNextBehavior(
/*  512 */           CECombatBehaviors.Behavior.builder()
/*  513 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  514 */           .withinDistance(0.0D, 3.0D)
/*  515 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  516 */           .addNextBehavior(
/*  517 */             CECombatBehaviors.Behavior.builder()
/*  518 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  519 */             .withinDistance(0.0D, 4.0D)
/*  520 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  521 */             .addNextBehavior(
/*  522 */               CECombatBehaviors.Behavior.builder()
/*  523 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  524 */               .withinDistance(0.0D, 4.0D)
/*  525 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  526 */               .addNextBehavior(
/*  527 */                 CECombatBehaviors.Behavior.builder()
/*  528 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  529 */                 .withinDistance(0.0D, 5.0D)
/*  530 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  531 */                 .addNextBehavior(
/*  532 */                   CECombatBehaviors.Behavior.builder()
/*  533 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  534 */                   .withinDistance(0.0D, 5.0D)
/*  535 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  536 */                   .addNextBehavior(
/*  537 */                     CECombatBehaviors.Behavior.builder()
/*  538 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  539 */                     .withinDistance(0.0D, 5.0D)
/*  540 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  541 */                     .addNextBehavior(
/*  542 */                       CECombatBehaviors.Behavior.builder()
/*  543 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  544 */                       .withinDistance(0.0D, 5.0D)
/*  545 */                       .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/*  546 */                       .addNextBehavior(
/*  547 */                         CECombatBehaviors.Behavior.builder()
/*  548 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  549 */                         .withinDistance(0.0D, 5.0D)
/*  550 */                         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
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
/*  561 */       .addFirstBehavior(
/*  562 */         CECombatBehaviors.Behavior.builder()
/*  563 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  564 */         .withinDistance(0.0D, 3.0D)
/*  565 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  566 */         .addNextBehavior(
/*  567 */           CECombatBehaviors.Behavior.builder()
/*  568 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  569 */           .withinDistance(0.0D, 3.0D)
/*  570 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  571 */           .addNextBehavior(
/*  572 */             CECombatBehaviors.Behavior.builder()
/*  573 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  574 */             .withinDistance(0.0D, 4.0D)
/*  575 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  576 */             .addNextBehavior(
/*  577 */               CECombatBehaviors.Behavior.builder()
/*  578 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  579 */               .withinDistance(0.0D, 4.0D)
/*  580 */               .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/*  581 */               .addNextBehavior(
/*  582 */                 CECombatBehaviors.Behavior.builder()
/*  583 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  584 */                 .withinDistance(0.0D, 5.0D)
/*  585 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  586 */                 .addNextBehavior(
/*  587 */                   CECombatBehaviors.Behavior.builder()
/*  588 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  589 */                   .withinDistance(0.0D, 5.0D)
/*  590 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  591 */                   .addNextBehavior(
/*  592 */                     CECombatBehaviors.Behavior.builder()
/*  593 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  594 */                     .withinDistance(0.0D, 5.0D)
/*  595 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  596 */                     .addNextBehavior(
/*  597 */                       CECombatBehaviors.Behavior.builder()
/*  598 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  599 */                       .withinDistance(0.0D, 5.0D)
/*  600 */                       .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  601 */                       .addNextBehavior(
/*  602 */                         CECombatBehaviors.Behavior.builder()
/*  603 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  604 */                         .withinDistance(0.0D, 5.0D)
/*  605 */                         .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/*  606 */                         .addNextBehavior(
/*  607 */                           CECombatBehaviors.Behavior.builder()
/*  608 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  609 */                           .withinDistance(0.0D, 5.0D)
/*  610 */                           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))))
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
/*  622 */       .addFirstBehavior(
/*  623 */         CECombatBehaviors.Behavior.builder()
/*  624 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  625 */         .withinDistance(0.0D, 3.0D)
/*  626 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  627 */         .addNextBehavior(
/*  628 */           CECombatBehaviors.Behavior.builder()
/*  629 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  630 */           .withinDistance(0.0D, 3.0D)
/*  631 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  632 */           .addNextBehavior(
/*  633 */             CECombatBehaviors.Behavior.builder()
/*  634 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  635 */             .withinDistance(0.0D, 4.0D)
/*  636 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  637 */             .addNextBehavior(
/*  638 */               CECombatBehaviors.Behavior.builder()
/*  639 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  640 */               .withinDistance(0.0D, 4.0D)
/*  641 */               .animationBehavior(Animations.SPEAR_ONEHAND_AIR_SLASH, 0.0F)
/*  642 */               .addNextBehavior(
/*  643 */                 CECombatBehaviors.Behavior.builder()
/*  644 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  645 */                 .withinDistance(0.0D, 5.0D)
/*  646 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  647 */                 .addNextBehavior(
/*  648 */                   CECombatBehaviors.Behavior.builder()
/*  649 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  650 */                   .withinDistance(0.0D, 5.0D)
/*  651 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  652 */                   .addNextBehavior(
/*  653 */                     CECombatBehaviors.Behavior.builder()
/*  654 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  655 */                     .withinDistance(0.0D, 5.0D)
/*  656 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  657 */                     .addNextBehavior(
/*  658 */                       CECombatBehaviors.Behavior.builder()
/*  659 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  660 */                       .withinDistance(0.0D, 5.0D)
/*  661 */                       .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  662 */                       .addNextBehavior(
/*  663 */                         CECombatBehaviors.Behavior.builder()
/*  664 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  665 */                         .withinDistance(0.0D, 5.0D)
/*  666 */                         .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  667 */                         .addNextBehavior(
/*  668 */                           CECombatBehaviors.Behavior.builder()
/*  669 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  670 */                           .withinDistance(0.0D, 5.0D)
/*  671 */                           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))))
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
/*  683 */       .addFirstBehavior(
/*  684 */         CECombatBehaviors.Behavior.builder()
/*  685 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  686 */         .withinDistance(0.0D, 3.0D)
/*  687 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  688 */         .addNextBehavior(
/*  689 */           CECombatBehaviors.Behavior.builder()
/*  690 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  691 */           .withinDistance(0.0D, 3.0D)
/*  692 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  693 */           .addNextBehavior(
/*  694 */             CECombatBehaviors.Behavior.builder()
/*  695 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  696 */             .withinDistance(0.0D, 4.0D)
/*  697 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  698 */             .addNextBehavior(
/*  699 */               CECombatBehaviors.Behavior.builder()
/*  700 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  701 */               .withinDistance(0.0D, 4.0D)
/*  702 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  703 */               .addNextBehavior(
/*  704 */                 CECombatBehaviors.Behavior.builder()
/*  705 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  706 */                 .withinDistance(0.0D, 5.0D)
/*  707 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  708 */                 .addNextBehavior(
/*  709 */                   CECombatBehaviors.Behavior.builder()
/*  710 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  711 */                   .withinDistance(0.0D, 5.0D)
/*  712 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  713 */                   .addNextBehavior(
/*  714 */                     CECombatBehaviors.Behavior.builder()
/*  715 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  716 */                     .withinDistance(0.0D, 5.0D)
/*  717 */                     .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/*  718 */                     .addNextBehavior(
/*  719 */                       CECombatBehaviors.Behavior.builder()
/*  720 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  721 */                       .withinDistance(0.0D, 5.0D)
/*  722 */                       .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  723 */                       .addNextBehavior(
/*  724 */                         CECombatBehaviors.Behavior.builder()
/*  725 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  726 */                         .withinDistance(0.0D, 5.0D)
/*  727 */                         .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/*  728 */                         .addNextBehavior(
/*  729 */                           CECombatBehaviors.Behavior.builder()
/*  730 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  731 */                           .withinDistance(0.0D, 5.0D)
/*  732 */                           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))))
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
/*  744 */       .addFirstBehavior(
/*  745 */         CECombatBehaviors.Behavior.builder()
/*  746 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  747 */         .withinDistance(0.0D, 3.0D)
/*  748 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  749 */         .addNextBehavior(
/*  750 */           CECombatBehaviors.Behavior.builder()
/*  751 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  752 */           .withinDistance(0.0D, 3.0D)
/*  753 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  754 */           .addNextBehavior(
/*  755 */             CECombatBehaviors.Behavior.builder()
/*  756 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  757 */             .withinDistance(0.0D, 4.0D)
/*  758 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  759 */             .addNextBehavior(
/*  760 */               CECombatBehaviors.Behavior.builder()
/*  761 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  762 */               .withinDistance(0.0D, 4.0D)
/*  763 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  764 */               .addNextBehavior(
/*  765 */                 CECombatBehaviors.Behavior.builder()
/*  766 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  767 */                 .withinDistance(0.0D, 5.0D)
/*  768 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  769 */                 .addNextBehavior(
/*  770 */                   CECombatBehaviors.Behavior.builder()
/*  771 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  772 */                   .withinDistance(0.0D, 5.0D)
/*  773 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  774 */                   .addNextBehavior(
/*  775 */                     CECombatBehaviors.Behavior.builder()
/*  776 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  777 */                     .withinDistance(0.0D, 5.0D)
/*  778 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  779 */                     .addNextBehavior(
/*  780 */                       CECombatBehaviors.Behavior.builder()
/*  781 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  782 */                       .withinDistance(0.0D, 5.0D)
/*  783 */                       .animationBehavior(Animations.SPEAR_ONEHAND_AIR_SLASH, 0.0F)
/*  784 */                       .addNextBehavior(
/*  785 */                         CECombatBehaviors.Behavior.builder()
/*  786 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  787 */                         .withinDistance(0.0D, 5.0D)
/*  788 */                         .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  789 */                         .addNextBehavior(
/*  790 */                           CECombatBehaviors.Behavior.builder()
/*  791 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  792 */                           .withinDistance(0.0D, 5.0D)
/*  793 */                           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))))
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
/*  805 */       .addFirstBehavior(
/*  806 */         CECombatBehaviors.Behavior.builder()
/*  807 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  808 */         .withinDistance(0.0D, 3.0D)
/*  809 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  810 */         .addNextBehavior(
/*  811 */           CECombatBehaviors.Behavior.builder()
/*  812 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  813 */           .withinDistance(0.0D, 3.0D)
/*  814 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  815 */           .addNextBehavior(
/*  816 */             CECombatBehaviors.Behavior.builder()
/*  817 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  818 */             .withinDistance(0.0D, 4.0D)
/*  819 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  820 */             .addNextBehavior(
/*  821 */               CECombatBehaviors.Behavior.builder()
/*  822 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  823 */               .withinDistance(0.0D, 4.0D)
/*  824 */               .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/*  825 */               .addNextBehavior(
/*  826 */                 CECombatBehaviors.Behavior.builder()
/*  827 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  828 */                 .withinDistance(0.0D, 5.0D)
/*  829 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  830 */                 .addNextBehavior(
/*  831 */                   CECombatBehaviors.Behavior.builder()
/*  832 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  833 */                   .withinDistance(0.0D, 5.0D)
/*  834 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  835 */                   .addNextBehavior(
/*  836 */                     CECombatBehaviors.Behavior.builder()
/*  837 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  838 */                     .withinDistance(0.0D, 5.0D)
/*  839 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  840 */                     .addNextBehavior(
/*  841 */                       CECombatBehaviors.Behavior.builder()
/*  842 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  843 */                       .withinDistance(0.0D, 5.0D)
/*  844 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  845 */                       .addNextBehavior(
/*  846 */                         CECombatBehaviors.Behavior.builder()
/*  847 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  848 */                         .withinDistance(0.0D, 5.0D)
/*  849 */                         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))))))))))
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
/*  860 */       .addFirstBehavior(
/*  861 */         CECombatBehaviors.Behavior.builder()
/*  862 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  863 */         .withinDistance(0.0D, 3.0D)
/*  864 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  865 */         .addNextBehavior(
/*  866 */           CECombatBehaviors.Behavior.builder()
/*  867 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  868 */           .withinDistance(0.0D, 3.0D)
/*  869 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  870 */           .addNextBehavior(
/*  871 */             CECombatBehaviors.Behavior.builder()
/*  872 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  873 */             .withinDistance(0.0D, 4.0D)
/*  874 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  875 */             .addNextBehavior(
/*  876 */               CECombatBehaviors.Behavior.builder()
/*  877 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  878 */               .withinDistance(0.0D, 4.0D)
/*  879 */               .animationBehavior(Animations.SPEAR_ONEHAND_AIR_SLASH, 0.0F)
/*  880 */               .addNextBehavior(
/*  881 */                 CECombatBehaviors.Behavior.builder()
/*  882 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  883 */                 .withinDistance(0.0D, 5.0D)
/*  884 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  885 */                 .addNextBehavior(
/*  886 */                   CECombatBehaviors.Behavior.builder()
/*  887 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  888 */                   .withinDistance(0.0D, 5.0D)
/*  889 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  890 */                   .addNextBehavior(
/*  891 */                     CECombatBehaviors.Behavior.builder()
/*  892 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  893 */                     .withinDistance(0.0D, 5.0D)
/*  894 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  895 */                     .addNextBehavior(
/*  896 */                       CECombatBehaviors.Behavior.builder()
/*  897 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  898 */                       .withinDistance(0.0D, 5.0D)
/*  899 */                       .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  900 */                       .addNextBehavior(
/*  901 */                         CECombatBehaviors.Behavior.builder()
/*  902 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  903 */                         .withinDistance(0.0D, 5.0D)
/*  904 */                         .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/*  905 */                         .addNextBehavior(
/*  906 */                           CECombatBehaviors.Behavior.builder()
/*  907 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  908 */                           .withinDistance(0.0D, 5.0D)
/*  909 */                           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))))
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
/*  921 */       .addFirstBehavior(
/*  922 */         CECombatBehaviors.Behavior.builder()
/*  923 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  924 */         .withinDistance(0.0D, 3.0D)
/*  925 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  926 */         .addNextBehavior(
/*  927 */           CECombatBehaviors.Behavior.builder()
/*  928 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  929 */           .withinDistance(0.0D, 3.0D)
/*  930 */           .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  931 */           .addNextBehavior(
/*  932 */             CECombatBehaviors.Behavior.builder()
/*  933 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  934 */             .withinDistance(0.0D, 4.0D)
/*  935 */             .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/*  936 */             .addNextBehavior(
/*  937 */               CECombatBehaviors.Behavior.builder()
/*  938 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  939 */               .withinDistance(0.0D, 4.0D)
/*  940 */               .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/*  941 */               .addNextBehavior(
/*  942 */                 CECombatBehaviors.Behavior.builder()
/*  943 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  944 */                 .withinDistance(0.0D, 5.0D)
/*  945 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  946 */                 .addNextBehavior(
/*  947 */                   CECombatBehaviors.Behavior.builder()
/*  948 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  949 */                   .withinDistance(0.0D, 5.0D)
/*  950 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  951 */                   .addNextBehavior(
/*  952 */                     CECombatBehaviors.Behavior.builder()
/*  953 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  954 */                     .withinDistance(0.0D, 5.0D)
/*  955 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  956 */                     .addNextBehavior(
/*  957 */                       CECombatBehaviors.Behavior.builder()
/*  958 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  959 */                       .withinDistance(0.0D, 5.0D)
/*  960 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  961 */                       .addNextBehavior(
/*  962 */                         CECombatBehaviors.Behavior.builder()
/*  963 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  964 */                         .withinDistance(0.0D, 5.0D)
/*  965 */                         .animationBehavior(EFKickAnimations.KICK_2, 0.0F)))))))))))
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
/*  976 */     .newBehaviorRoot(
/*  977 */       CECombatBehaviors.BehaviorRoot.builder()
/*  978 */       .priority(1.0D)
/*  979 */       .weight(20.0D)
/*  980 */       .maxCooldown(100)
/*  981 */       .addFirstBehavior(
/*  982 */         CECombatBehaviors.Behavior.builder()
/*  983 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  984 */         .withinDistance(0.0D, 3.0D)
/*  985 */         .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  986 */         .addNextBehavior(
/*  987 */           CECombatBehaviors.Behavior.builder()
/*  988 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  989 */           .withinDistance(0.0D, 4.0D)
/*  990 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/*  991 */           .addNextBehavior(
/*  992 */             CECombatBehaviors.Behavior.builder()
/*  993 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  994 */             .withinDistance(0.0D, 5.0D)
/*  995 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1000 */     .newBehaviorRoot(
/* 1001 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1002 */       .priority(1.0D)
/* 1003 */       .weight(10.0D)
/* 1004 */       .maxCooldown(100)
/* 1005 */       .addFirstBehavior(
/* 1006 */         CECombatBehaviors.Behavior.builder()
/* 1007 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1008 */         .withinDistance(0.0D, 3.0D)
/* 1009 */         .animationBehavior(Animations.SPEAR_DASH, 0.0F))
/*      */       
/* 1011 */       .addFirstBehavior(
/* 1012 */         CECombatBehaviors.Behavior.builder()
/* 1013 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1014 */         .withinDistance(0.0D, 3.0D)
/* 1015 */         .animationBehavior(Animations.SPEAR_ONEHAND_AIR_SLASH, 0.0F))
/*      */       
/* 1017 */       .addFirstBehavior(
/* 1018 */         CECombatBehaviors.Behavior.builder()
/* 1019 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1020 */         .withinDistance(0.0D, 3.0D)
/* 1021 */         .animationBehavior(Animations.HEARTPIERCER, 0.0F)))
/*      */ 
/*      */     
/* 1024 */     .newBehaviorRoot(
/* 1025 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1026 */       .priority(1.0D)
/* 1027 */       .weight(10.0D)
/* 1028 */       .maxCooldown(40)
/* 1029 */       .addFirstBehavior(
/* 1030 */         CECombatBehaviors.Behavior.builder()
/* 1031 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1032 */         .withinDistance(0.0D, 3.0D)
/* 1033 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1034 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1035 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1038 */     .newBehaviorRoot(
/* 1039 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1040 */       .priority(1.0D)
/* 1041 */       .weight(2.0D)
/* 1042 */       .maxCooldown(100)
/* 1043 */       .addFirstBehavior(
/* 1044 */         CECombatBehaviors.Behavior.builder()
/* 1045 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1046 */         .withinDistance(0.0D, 3.0D)
/* 1047 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1049 */       .addFirstBehavior(
/* 1050 */         CECombatBehaviors.Behavior.builder()
/* 1051 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1052 */         .withinDistance(0.0D, 3.0D)
/* 1053 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1055 */       .addFirstBehavior(
/* 1056 */         CECombatBehaviors.Behavior.builder()
/* 1057 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1058 */         .withinDistance(0.0D, 3.0D)
/* 1059 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1061 */       .addFirstBehavior(
/* 1062 */         CECombatBehaviors.Behavior.builder()
/* 1063 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1064 */         .withinDistance(0.0D, 3.0D)
/* 1065 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1067 */       .addFirstBehavior(
/* 1068 */         CECombatBehaviors.Behavior.builder()
/* 1069 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1070 */         .withinDistance(0.0D, 3.0D)
/* 1071 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1073 */       .addFirstBehavior(
/* 1074 */         CECombatBehaviors.Behavior.builder()
/* 1075 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1076 */         .withinDistance(0.0D, 3.0D)
/* 1077 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1079 */       .addFirstBehavior(
/* 1080 */         CECombatBehaviors.Behavior.builder()
/* 1081 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1082 */         .withinDistance(0.0D, 3.0D)
/* 1083 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1086 */     .newBehaviorRoot(
/* 1087 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1088 */       .priority(1.0D)
/* 1089 */       .weight(15.0D)
/* 1090 */       .addFirstBehavior(
/* 1091 */         CECombatBehaviors.Behavior.builder()
/* 1092 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1093 */         .withinDistance(0.0D, 3.0D)
/* 1094 */         .custom(CombatCommon::canPerformGuarding)
/* 1095 */         .guard(40)))
/*      */ 
/*      */     
/* 1098 */     .newBehaviorRoot(
/* 1099 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1100 */       .priority(1.0D)
/* 1101 */       .weight(10.0D)
/* 1102 */       .addFirstBehavior(
/* 1103 */         CECombatBehaviors.Behavior.builder()
/* 1104 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1105 */         .withinDistance(0.0D, 3.0D)
/* 1106 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1108 */       .addFirstBehavior(
/* 1109 */         CECombatBehaviors.Behavior.builder()
/* 1110 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1111 */         .withinDistance(0.0D, 3.0D)
/* 1112 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1115 */     .newBehaviorRoot(
/* 1116 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1117 */       .priority(1.0D)
/* 1118 */       .weight(40.0D)
/* 1119 */       .maxCooldown(160)
/* 1120 */       .addFirstBehavior(
/* 1121 */         CECombatBehaviors.Behavior.builder()
/* 1122 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1123 */         .custom(CombatCommon::canJump)
/* 1124 */         .withinDistance(5.0D, 14.0D)
/* 1125 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1126 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 1130 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SPEAR = CECombatBehaviors.builder()
/* 1131 */     .newBehaviorRoot(
/* 1132 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1133 */       .priority(4.0D)
/* 1134 */       .weight(1000.0D)
/* 1135 */       .maxCooldown(0)
/* 1136 */       .addFirstBehavior(
/* 1137 */         CECombatBehaviors.Behavior.builder()
/* 1138 */         .custom(CombatCommon::canExecute)
/* 1139 */         .withinDistance(0.0D, 5.0D)
/* 1140 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 1141 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 1144 */     .newBehaviorRoot(
/* 1145 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1146 */       .priority(3.0D)
/* 1147 */       .weight(1000.0D)
/* 1148 */       .maxCooldown(0)
/* 1149 */       .addFirstBehavior(
/* 1150 */         CECombatBehaviors.Behavior.builder()
/* 1151 */         .custom(CombatCommon::canEscape)
/* 1152 */         .withinDistance(0.0D, 8.0D)
/* 1153 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1154 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 1156 */       .addFirstBehavior(
/* 1157 */         CECombatBehaviors.Behavior.builder()
/* 1158 */         .custom(CombatCommon::canEscape)
/* 1159 */         .withinDistance(0.0D, 48.0D)
/* 1160 */         .guard(40)))
/*      */ 
/*      */     
/* 1163 */     .newBehaviorRoot(
/* 1164 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1165 */       .priority(2.0D)
/* 1166 */       .weight(70.0D)
/* 1167 */       .maxCooldown(0)
/* 1168 */       .addFirstBehavior(
/* 1169 */         CECombatBehaviors.Behavior.builder()
/* 1170 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 1171 */         .custom(CombatCommon::canPerformEating)
/* 1172 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1173 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 1176 */     .newBehaviorRoot(
/* 1177 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1178 */       .priority(2.0D)
/* 1179 */       .weight(100.0D)
/* 1180 */       .maxCooldown(120)
/* 1181 */       .addFirstBehavior(
/* 1182 */         CECombatBehaviors.Behavior.builder()
/* 1183 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1184 */         .custom(CombatCommon::canSwapToBow)
/* 1185 */         .withinDistance(7.0D, 14.0D)
/* 1186 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1187 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 1189 */       .addFirstBehavior(
/* 1190 */         CECombatBehaviors.Behavior.builder()
/* 1191 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1192 */         .custom(CombatCommon::canSwapToBow)
/* 1193 */         .withinDistance(7.0D, 14.0D)
/* 1194 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1195 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 1198 */     .newBehaviorRoot(
/* 1199 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1200 */       .priority(2.0D)
/* 1201 */       .weight(80.0D)
/* 1202 */       .maxCooldown(120)
/* 1203 */       .addFirstBehavior(
/* 1204 */         CECombatBehaviors.Behavior.builder()
/* 1205 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1206 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1207 */         .withinDistance(7.0D, 48.0D)
/* 1208 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1209 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 1212 */     .newBehaviorRoot(
/* 1213 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1214 */       .priority(1.0D)
/* 1215 */       .weight(40.0D)
/* 1216 */       .maxCooldown(20)
/* 1217 */       .addFirstBehavior(
/* 1218 */         CECombatBehaviors.Behavior.builder()
/* 1219 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1220 */         .withinDistance(0.0D, 3.0D)
/* 1221 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1222 */         .addNextBehavior(
/* 1223 */           CECombatBehaviors.Behavior.builder()
/* 1224 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1225 */           .withinDistance(0.0D, 3.0D)
/* 1226 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)))
/*      */ 
/*      */       
/* 1229 */       .addFirstBehavior(
/* 1230 */         CECombatBehaviors.Behavior.builder()
/* 1231 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1232 */         .withinDistance(0.0D, 3.0D)
/* 1233 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1234 */         .addNextBehavior(
/* 1235 */           CECombatBehaviors.Behavior.builder()
/* 1236 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1237 */           .withinDistance(0.0D, 3.0D)
/* 1238 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1239 */           .addNextBehavior(
/* 1240 */             CECombatBehaviors.Behavior.builder()
/* 1241 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1242 */             .withinDistance(0.0D, 4.0D)
/* 1243 */             .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 1244 */             .addNextBehavior(
/* 1245 */               CECombatBehaviors.Behavior.builder()
/* 1246 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1247 */               .withinDistance(0.0D, 4.0D)
/* 1248 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1249 */               .addNextBehavior(
/* 1250 */                 CECombatBehaviors.Behavior.builder()
/* 1251 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1252 */                 .withinDistance(0.0D, 5.0D)
/* 1253 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1254 */                 .addNextBehavior(
/* 1255 */                   CECombatBehaviors.Behavior.builder()
/* 1256 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1257 */                   .withinDistance(0.0D, 5.0D)
/* 1258 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1259 */                   .addNextBehavior(
/* 1260 */                     CECombatBehaviors.Behavior.builder()
/* 1261 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1262 */                     .withinDistance(0.0D, 5.0D)
/* 1263 */                     .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1264 */                     .addNextBehavior(
/* 1265 */                       CECombatBehaviors.Behavior.builder()
/* 1266 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1267 */                       .withinDistance(0.0D, 5.0D)
/* 1268 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1278 */       .addFirstBehavior(
/* 1279 */         CECombatBehaviors.Behavior.builder()
/* 1280 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1281 */         .withinDistance(0.0D, 3.0D)
/* 1282 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1283 */         .addNextBehavior(
/* 1284 */           CECombatBehaviors.Behavior.builder()
/* 1285 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1286 */           .withinDistance(0.0D, 3.0D)
/* 1287 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1288 */           .addNextBehavior(
/* 1289 */             CECombatBehaviors.Behavior.builder()
/* 1290 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1291 */             .withinDistance(0.0D, 4.0D)
/* 1292 */             .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 1293 */             .addNextBehavior(
/* 1294 */               CECombatBehaviors.Behavior.builder()
/* 1295 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1296 */               .withinDistance(0.0D, 4.0D)
/* 1297 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1298 */               .addNextBehavior(
/* 1299 */                 CECombatBehaviors.Behavior.builder()
/* 1300 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1301 */                 .withinDistance(0.0D, 5.0D)
/* 1302 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1303 */                 .addNextBehavior(
/* 1304 */                   CECombatBehaviors.Behavior.builder()
/* 1305 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1306 */                   .withinDistance(0.0D, 5.0D)
/* 1307 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1308 */                   .addNextBehavior(
/* 1309 */                     CECombatBehaviors.Behavior.builder()
/* 1310 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1311 */                     .withinDistance(0.0D, 5.0D)
/* 1312 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1313 */                     .addNextBehavior(
/* 1314 */                       CECombatBehaviors.Behavior.builder()
/* 1315 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1316 */                       .withinDistance(0.0D, 5.0D)
/* 1317 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1327 */       .addFirstBehavior(
/* 1328 */         CECombatBehaviors.Behavior.builder()
/* 1329 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1330 */         .withinDistance(0.0D, 3.0D)
/* 1331 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1332 */         .addNextBehavior(
/* 1333 */           CECombatBehaviors.Behavior.builder()
/* 1334 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1335 */           .withinDistance(0.0D, 3.0D)
/* 1336 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1337 */           .addNextBehavior(
/* 1338 */             CECombatBehaviors.Behavior.builder()
/* 1339 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1340 */             .withinDistance(0.0D, 4.0D)
/* 1341 */             .animationBehavior(Animations.GRASPING_SPIRAL_FIRST, 0.0F)
/* 1342 */             .addNextBehavior(
/* 1343 */               CECombatBehaviors.Behavior.builder()
/* 1344 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1345 */               .withinDistance(0.0D, 4.0D)
/* 1346 */               .animationBehavior(Animations.GRASPING_SPIRAL_SECOND, 0.0F)
/* 1347 */               .addNextBehavior(
/* 1348 */                 CECombatBehaviors.Behavior.builder()
/* 1349 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1350 */                 .withinDistance(0.0D, 5.0D)
/* 1351 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1352 */                 .addNextBehavior(
/* 1353 */                   CECombatBehaviors.Behavior.builder()
/* 1354 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1355 */                   .withinDistance(0.0D, 5.0D)
/* 1356 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1357 */                   .addNextBehavior(
/* 1358 */                     CECombatBehaviors.Behavior.builder()
/* 1359 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1360 */                     .withinDistance(0.0D, 5.0D)
/* 1361 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1362 */                     .addNextBehavior(
/* 1363 */                       CECombatBehaviors.Behavior.builder()
/* 1364 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1365 */                       .withinDistance(0.0D, 5.0D)
/* 1366 */                       .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1367 */                       .addNextBehavior(
/* 1368 */                         CECombatBehaviors.Behavior.builder()
/* 1369 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1370 */                         .withinDistance(0.0D, 5.0D)
/* 1371 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/* 1382 */       .addFirstBehavior(
/* 1383 */         CECombatBehaviors.Behavior.builder()
/* 1384 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1385 */         .withinDistance(0.0D, 3.0D)
/* 1386 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1387 */         .addNextBehavior(
/* 1388 */           CECombatBehaviors.Behavior.builder()
/* 1389 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1390 */           .withinDistance(0.0D, 3.0D)
/* 1391 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1392 */           .addNextBehavior(
/* 1393 */             CECombatBehaviors.Behavior.builder()
/* 1394 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1395 */             .withinDistance(0.0D, 4.0D)
/* 1396 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1397 */             .addNextBehavior(
/* 1398 */               CECombatBehaviors.Behavior.builder()
/* 1399 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1400 */               .withinDistance(0.0D, 4.0D)
/* 1401 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1402 */               .addNextBehavior(
/* 1403 */                 CECombatBehaviors.Behavior.builder()
/* 1404 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1405 */                 .withinDistance(0.0D, 5.0D)
/* 1406 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1407 */                 .addNextBehavior(
/* 1408 */                   CECombatBehaviors.Behavior.builder()
/* 1409 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1410 */                   .withinDistance(0.0D, 5.0D)
/* 1411 */                   .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 1412 */                   .addNextBehavior(
/* 1413 */                     CECombatBehaviors.Behavior.builder()
/* 1414 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1415 */                     .withinDistance(0.0D, 5.0D)
/* 1416 */                     .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1417 */                     .addNextBehavior(
/* 1418 */                       CECombatBehaviors.Behavior.builder()
/* 1419 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1420 */                       .withinDistance(0.0D, 5.0D)
/* 1421 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1431 */       .addFirstBehavior(
/* 1432 */         CECombatBehaviors.Behavior.builder()
/* 1433 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1434 */         .withinDistance(0.0D, 3.0D)
/* 1435 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1436 */         .addNextBehavior(
/* 1437 */           CECombatBehaviors.Behavior.builder()
/* 1438 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1439 */           .withinDistance(0.0D, 3.0D)
/* 1440 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1441 */           .addNextBehavior(
/* 1442 */             CECombatBehaviors.Behavior.builder()
/* 1443 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1444 */             .withinDistance(0.0D, 4.0D)
/* 1445 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1446 */             .addNextBehavior(
/* 1447 */               CECombatBehaviors.Behavior.builder()
/* 1448 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1449 */               .withinDistance(0.0D, 4.0D)
/* 1450 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1451 */               .addNextBehavior(
/* 1452 */                 CECombatBehaviors.Behavior.builder()
/* 1453 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1454 */                 .withinDistance(0.0D, 5.0D)
/* 1455 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1456 */                 .addNextBehavior(
/* 1457 */                   CECombatBehaviors.Behavior.builder()
/* 1458 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1459 */                   .withinDistance(0.0D, 5.0D)
/* 1460 */                   .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 1461 */                   .addNextBehavior(
/* 1462 */                     CECombatBehaviors.Behavior.builder()
/* 1463 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1464 */                     .withinDistance(0.0D, 5.0D)
/* 1465 */                     .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1466 */                     .addNextBehavior(
/* 1467 */                       CECombatBehaviors.Behavior.builder()
/* 1468 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1469 */                       .withinDistance(0.0D, 5.0D)
/* 1470 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1480 */       .addFirstBehavior(
/* 1481 */         CECombatBehaviors.Behavior.builder()
/* 1482 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1483 */         .withinDistance(0.0D, 3.0D)
/* 1484 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1485 */         .addNextBehavior(
/* 1486 */           CECombatBehaviors.Behavior.builder()
/* 1487 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1488 */           .withinDistance(0.0D, 3.0D)
/* 1489 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1490 */           .addNextBehavior(
/* 1491 */             CECombatBehaviors.Behavior.builder()
/* 1492 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1493 */             .withinDistance(0.0D, 4.0D)
/* 1494 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1495 */             .addNextBehavior(
/* 1496 */               CECombatBehaviors.Behavior.builder()
/* 1497 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1498 */               .withinDistance(0.0D, 4.0D)
/* 1499 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1500 */               .addNextBehavior(
/* 1501 */                 CECombatBehaviors.Behavior.builder()
/* 1502 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1503 */                 .withinDistance(0.0D, 5.0D)
/* 1504 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1505 */                 .addNextBehavior(
/* 1506 */                   CECombatBehaviors.Behavior.builder()
/* 1507 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1508 */                   .withinDistance(0.0D, 5.0D)
/* 1509 */                   .animationBehavior(Animations.GRASPING_SPIRAL_FIRST, 0.0F)
/* 1510 */                   .addNextBehavior(
/* 1511 */                     CECombatBehaviors.Behavior.builder()
/* 1512 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1513 */                     .withinDistance(0.0D, 5.0D)
/* 1514 */                     .animationBehavior(Animations.GRASPING_SPIRAL_SECOND, 0.0F)
/* 1515 */                     .addNextBehavior(
/* 1516 */                       CECombatBehaviors.Behavior.builder()
/* 1517 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1518 */                       .withinDistance(0.0D, 5.0D)
/* 1519 */                       .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1520 */                       .addNextBehavior(
/* 1521 */                         CECombatBehaviors.Behavior.builder()
/* 1522 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1523 */                         .withinDistance(0.0D, 5.0D)
/* 1524 */                         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
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
/* 1535 */       .addFirstBehavior(
/* 1536 */         CECombatBehaviors.Behavior.builder()
/* 1537 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1538 */         .withinDistance(0.0D, 3.0D)
/* 1539 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1540 */         .addNextBehavior(
/* 1541 */           CECombatBehaviors.Behavior.builder()
/* 1542 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1543 */           .withinDistance(0.0D, 3.0D)
/* 1544 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1545 */           .addNextBehavior(
/* 1546 */             CECombatBehaviors.Behavior.builder()
/* 1547 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1548 */             .withinDistance(0.0D, 4.0D)
/* 1549 */             .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1550 */             .addNextBehavior(
/* 1551 */               CECombatBehaviors.Behavior.builder()
/* 1552 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1553 */               .withinDistance(0.0D, 4.0D)
/* 1554 */               .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 1555 */               .addNextBehavior(
/* 1556 */                 CECombatBehaviors.Behavior.builder()
/* 1557 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1558 */                 .withinDistance(0.0D, 5.0D)
/* 1559 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1560 */                 .addNextBehavior(
/* 1561 */                   CECombatBehaviors.Behavior.builder()
/* 1562 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1563 */                   .withinDistance(0.0D, 5.0D)
/* 1564 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1565 */                   .addNextBehavior(
/* 1566 */                     CECombatBehaviors.Behavior.builder()
/* 1567 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1568 */                     .withinDistance(0.0D, 5.0D)
/* 1569 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1570 */                     .addNextBehavior(
/* 1571 */                       CECombatBehaviors.Behavior.builder()
/* 1572 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1573 */                       .withinDistance(0.0D, 5.0D)
/* 1574 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1584 */       .addFirstBehavior(
/* 1585 */         CECombatBehaviors.Behavior.builder()
/* 1586 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1587 */         .withinDistance(0.0D, 3.0D)
/* 1588 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1589 */         .addNextBehavior(
/* 1590 */           CECombatBehaviors.Behavior.builder()
/* 1591 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1592 */           .withinDistance(0.0D, 3.0D)
/* 1593 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1594 */           .addNextBehavior(
/* 1595 */             CECombatBehaviors.Behavior.builder()
/* 1596 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1597 */             .withinDistance(0.0D, 4.0D)
/* 1598 */             .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1599 */             .addNextBehavior(
/* 1600 */               CECombatBehaviors.Behavior.builder()
/* 1601 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1602 */               .withinDistance(0.0D, 4.0D)
/* 1603 */               .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 1604 */               .addNextBehavior(
/* 1605 */                 CECombatBehaviors.Behavior.builder()
/* 1606 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1607 */                 .withinDistance(0.0D, 5.0D)
/* 1608 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1609 */                 .addNextBehavior(
/* 1610 */                   CECombatBehaviors.Behavior.builder()
/* 1611 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1612 */                   .withinDistance(0.0D, 5.0D)
/* 1613 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1614 */                   .addNextBehavior(
/* 1615 */                     CECombatBehaviors.Behavior.builder()
/* 1616 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1617 */                     .withinDistance(0.0D, 5.0D)
/* 1618 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1619 */                     .addNextBehavior(
/* 1620 */                       CECombatBehaviors.Behavior.builder()
/* 1621 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1622 */                       .withinDistance(0.0D, 5.0D)
/* 1623 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1633 */       .addFirstBehavior(
/* 1634 */         CECombatBehaviors.Behavior.builder()
/* 1635 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1636 */         .withinDistance(0.0D, 3.0D)
/* 1637 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1638 */         .addNextBehavior(
/* 1639 */           CECombatBehaviors.Behavior.builder()
/* 1640 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1641 */           .withinDistance(0.0D, 3.0D)
/* 1642 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1643 */           .addNextBehavior(
/* 1644 */             CECombatBehaviors.Behavior.builder()
/* 1645 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1646 */             .withinDistance(0.0D, 4.0D)
/* 1647 */             .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1648 */             .addNextBehavior(
/* 1649 */               CECombatBehaviors.Behavior.builder()
/* 1650 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1651 */               .withinDistance(0.0D, 4.0D)
/* 1652 */               .animationBehavior(Animations.GRASPING_SPIRAL_FIRST, 0.0F)
/* 1653 */               .addNextBehavior(
/* 1654 */                 CECombatBehaviors.Behavior.builder()
/* 1655 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1656 */                 .withinDistance(0.0D, 5.0D)
/* 1657 */                 .animationBehavior(Animations.GRASPING_SPIRAL_SECOND, 0.0F)
/* 1658 */                 .addNextBehavior(
/* 1659 */                   CECombatBehaviors.Behavior.builder()
/* 1660 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1661 */                   .withinDistance(0.0D, 5.0D)
/* 1662 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1663 */                   .addNextBehavior(
/* 1664 */                     CECombatBehaviors.Behavior.builder()
/* 1665 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1666 */                     .withinDistance(0.0D, 5.0D)
/* 1667 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1668 */                     .addNextBehavior(
/* 1669 */                       CECombatBehaviors.Behavior.builder()
/* 1670 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1671 */                       .withinDistance(0.0D, 5.0D)
/* 1672 */                       .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1673 */                       .addNextBehavior(
/* 1674 */                         CECombatBehaviors.Behavior.builder()
/* 1675 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1676 */                         .withinDistance(0.0D, 5.0D)
/* 1677 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/* 1688 */       .addFirstBehavior(
/* 1689 */         CECombatBehaviors.Behavior.builder()
/* 1690 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1691 */         .withinDistance(0.0D, 3.0D)
/* 1692 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1693 */         .addNextBehavior(
/* 1694 */           CECombatBehaviors.Behavior.builder()
/* 1695 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1696 */           .withinDistance(0.0D, 3.0D)
/* 1697 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1698 */           .addNextBehavior(
/* 1699 */             CECombatBehaviors.Behavior.builder()
/* 1700 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1701 */             .withinDistance(0.0D, 4.0D)
/* 1702 */             .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 1703 */             .addNextBehavior(
/* 1704 */               CECombatBehaviors.Behavior.builder()
/* 1705 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1706 */               .withinDistance(0.0D, 4.0D)
/* 1707 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1708 */               .addNextBehavior(
/* 1709 */                 CECombatBehaviors.Behavior.builder()
/* 1710 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1711 */                 .withinDistance(0.0D, 5.0D)
/* 1712 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1713 */                 .addNextBehavior(
/* 1714 */                   CECombatBehaviors.Behavior.builder()
/* 1715 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1716 */                   .withinDistance(0.0D, 5.0D)
/* 1717 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1718 */                   .addNextBehavior(
/* 1719 */                     CECombatBehaviors.Behavior.builder()
/* 1720 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1721 */                     .withinDistance(0.0D, 5.0D)
/* 1722 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1723 */                     .addNextBehavior(
/* 1724 */                       CECombatBehaviors.Behavior.builder()
/* 1725 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1726 */                       .withinDistance(0.0D, 5.0D)
/* 1727 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1737 */       .addFirstBehavior(
/* 1738 */         CECombatBehaviors.Behavior.builder()
/* 1739 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1740 */         .withinDistance(0.0D, 3.0D)
/* 1741 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1742 */         .addNextBehavior(
/* 1743 */           CECombatBehaviors.Behavior.builder()
/* 1744 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1745 */           .withinDistance(0.0D, 3.0D)
/* 1746 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1747 */           .addNextBehavior(
/* 1748 */             CECombatBehaviors.Behavior.builder()
/* 1749 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1750 */             .withinDistance(0.0D, 4.0D)
/* 1751 */             .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 1752 */             .addNextBehavior(
/* 1753 */               CECombatBehaviors.Behavior.builder()
/* 1754 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1755 */               .withinDistance(0.0D, 4.0D)
/* 1756 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1757 */               .addNextBehavior(
/* 1758 */                 CECombatBehaviors.Behavior.builder()
/* 1759 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1760 */                 .withinDistance(0.0D, 5.0D)
/* 1761 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1762 */                 .addNextBehavior(
/* 1763 */                   CECombatBehaviors.Behavior.builder()
/* 1764 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1765 */                   .withinDistance(0.0D, 5.0D)
/* 1766 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1767 */                   .addNextBehavior(
/* 1768 */                     CECombatBehaviors.Behavior.builder()
/* 1769 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1770 */                     .withinDistance(0.0D, 5.0D)
/* 1771 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1772 */                     .addNextBehavior(
/* 1773 */                       CECombatBehaviors.Behavior.builder()
/* 1774 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1775 */                       .withinDistance(0.0D, 5.0D)
/* 1776 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1786 */       .addFirstBehavior(
/* 1787 */         CECombatBehaviors.Behavior.builder()
/* 1788 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1789 */         .withinDistance(0.0D, 3.0D)
/* 1790 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1791 */         .addNextBehavior(
/* 1792 */           CECombatBehaviors.Behavior.builder()
/* 1793 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1794 */           .withinDistance(0.0D, 3.0D)
/* 1795 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1796 */           .addNextBehavior(
/* 1797 */             CECombatBehaviors.Behavior.builder()
/* 1798 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1799 */             .withinDistance(0.0D, 4.0D)
/* 1800 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1801 */             .addNextBehavior(
/* 1802 */               CECombatBehaviors.Behavior.builder()
/* 1803 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1804 */               .withinDistance(0.0D, 4.0D)
/* 1805 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1806 */               .addNextBehavior(
/* 1807 */                 CECombatBehaviors.Behavior.builder()
/* 1808 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1809 */                 .withinDistance(0.0D, 5.0D)
/* 1810 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1811 */                 .addNextBehavior(
/* 1812 */                   CECombatBehaviors.Behavior.builder()
/* 1813 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1814 */                   .withinDistance(0.0D, 5.0D)
/* 1815 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1816 */                   .addNextBehavior(
/* 1817 */                     CECombatBehaviors.Behavior.builder()
/* 1818 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1819 */                     .withinDistance(0.0D, 5.0D)
/* 1820 */                     .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 1821 */                     .addNextBehavior(
/* 1822 */                       CECombatBehaviors.Behavior.builder()
/* 1823 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1824 */                       .withinDistance(0.0D, 5.0D)
/* 1825 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1835 */       .addFirstBehavior(
/* 1836 */         CECombatBehaviors.Behavior.builder()
/* 1837 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1838 */         .withinDistance(0.0D, 3.0D)
/* 1839 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1840 */         .addNextBehavior(
/* 1841 */           CECombatBehaviors.Behavior.builder()
/* 1842 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1843 */           .withinDistance(0.0D, 3.0D)
/* 1844 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1845 */           .addNextBehavior(
/* 1846 */             CECombatBehaviors.Behavior.builder()
/* 1847 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1848 */             .withinDistance(0.0D, 4.0D)
/* 1849 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1850 */             .addNextBehavior(
/* 1851 */               CECombatBehaviors.Behavior.builder()
/* 1852 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1853 */               .withinDistance(0.0D, 4.0D)
/* 1854 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1855 */               .addNextBehavior(
/* 1856 */                 CECombatBehaviors.Behavior.builder()
/* 1857 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1858 */                 .withinDistance(0.0D, 5.0D)
/* 1859 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1860 */                 .addNextBehavior(
/* 1861 */                   CECombatBehaviors.Behavior.builder()
/* 1862 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1863 */                   .withinDistance(0.0D, 5.0D)
/* 1864 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1865 */                   .addNextBehavior(
/* 1866 */                     CECombatBehaviors.Behavior.builder()
/* 1867 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1868 */                     .withinDistance(0.0D, 5.0D)
/* 1869 */                     .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 1870 */                     .addNextBehavior(
/* 1871 */                       CECombatBehaviors.Behavior.builder()
/* 1872 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1873 */                       .withinDistance(0.0D, 5.0D)
/* 1874 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
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
/* 1888 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1889 */         .addNextBehavior(
/* 1890 */           CECombatBehaviors.Behavior.builder()
/* 1891 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1892 */           .withinDistance(0.0D, 3.0D)
/* 1893 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1894 */           .addNextBehavior(
/* 1895 */             CECombatBehaviors.Behavior.builder()
/* 1896 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1897 */             .withinDistance(0.0D, 4.0D)
/* 1898 */             .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 1899 */             .addNextBehavior(
/* 1900 */               CECombatBehaviors.Behavior.builder()
/* 1901 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1902 */               .withinDistance(0.0D, 4.0D)
/* 1903 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1904 */               .addNextBehavior(
/* 1905 */                 CECombatBehaviors.Behavior.builder()
/* 1906 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1907 */                 .withinDistance(0.0D, 5.0D)
/* 1908 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1909 */                 .addNextBehavior(
/* 1910 */                   CECombatBehaviors.Behavior.builder()
/* 1911 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1912 */                   .withinDistance(0.0D, 5.0D)
/* 1913 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1914 */                   .addNextBehavior(
/* 1915 */                     CECombatBehaviors.Behavior.builder()
/* 1916 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1917 */                     .withinDistance(0.0D, 5.0D)
/* 1918 */                     .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1919 */                     .addNextBehavior(
/* 1920 */                       CECombatBehaviors.Behavior.builder()
/* 1921 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1922 */                       .withinDistance(0.0D, 5.0D)
/* 1923 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1924 */                       .addNextBehavior(
/* 1925 */                         CECombatBehaviors.Behavior.builder()
/* 1926 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1927 */                         .withinDistance(0.0D, 5.0D)
/* 1928 */                         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1929 */                         .addNextBehavior(
/* 1930 */                           CECombatBehaviors.Behavior.builder()
/* 1931 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1932 */                           .withinDistance(0.0D, 5.0D)
/* 1933 */                           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)))))))))))
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
/* 1944 */       .addFirstBehavior(
/* 1945 */         CECombatBehaviors.Behavior.builder()
/* 1946 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1947 */         .withinDistance(0.0D, 3.0D)
/* 1948 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1949 */         .addNextBehavior(
/* 1950 */           CECombatBehaviors.Behavior.builder()
/* 1951 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1952 */           .withinDistance(0.0D, 3.0D)
/* 1953 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 1954 */           .addNextBehavior(
/* 1955 */             CECombatBehaviors.Behavior.builder()
/* 1956 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1957 */             .withinDistance(0.0D, 4.0D)
/* 1958 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1959 */             .addNextBehavior(
/* 1960 */               CECombatBehaviors.Behavior.builder()
/* 1961 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1962 */               .withinDistance(0.0D, 4.0D)
/* 1963 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1964 */               .addNextBehavior(
/* 1965 */                 CECombatBehaviors.Behavior.builder()
/* 1966 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1967 */                 .withinDistance(0.0D, 5.0D)
/* 1968 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 1969 */                 .addNextBehavior(
/* 1970 */                   CECombatBehaviors.Behavior.builder()
/* 1971 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1972 */                   .withinDistance(0.0D, 5.0D)
/* 1973 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1974 */                   .addNextBehavior(
/* 1975 */                     CECombatBehaviors.Behavior.builder()
/* 1976 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1977 */                     .withinDistance(0.0D, 5.0D)
/* 1978 */                     .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 1979 */                     .addNextBehavior(
/* 1980 */                       CECombatBehaviors.Behavior.builder()
/* 1981 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1982 */                       .withinDistance(0.0D, 5.0D)
/* 1983 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1984 */                       .addNextBehavior(
/* 1985 */                         CECombatBehaviors.Behavior.builder()
/* 1986 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1987 */                         .withinDistance(0.0D, 5.0D)
/* 1988 */                         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 1989 */                         .addNextBehavior(
/* 1990 */                           CECombatBehaviors.Behavior.builder()
/* 1991 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1992 */                           .withinDistance(0.0D, 5.0D)
/* 1993 */                           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F))))))))))))
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
/*      */     
/* 2006 */     .newBehaviorRoot(
/* 2007 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2008 */       .priority(1.0D)
/* 2009 */       .weight(20.0D)
/* 2010 */       .maxCooldown(100)
/* 2011 */       .addFirstBehavior(
/* 2012 */         CECombatBehaviors.Behavior.builder()
/* 2013 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2014 */         .withinDistance(0.0D, 3.0D)
/* 2015 */         .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2016 */         .addNextBehavior(
/* 2017 */           CECombatBehaviors.Behavior.builder()
/* 2018 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2019 */           .withinDistance(0.0D, 4.0D)
/* 2020 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2021 */           .addNextBehavior(
/* 2022 */             CECombatBehaviors.Behavior.builder()
/* 2023 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2024 */             .withinDistance(0.0D, 5.0D)
/* 2025 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2030 */     .newBehaviorRoot(
/* 2031 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2032 */       .priority(1.0D)
/* 2033 */       .weight(10.0D)
/* 2034 */       .maxCooldown(100)
/* 2035 */       .addFirstBehavior(
/* 2036 */         CECombatBehaviors.Behavior.builder()
/* 2037 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2038 */         .withinDistance(0.0D, 3.0D)
/* 2039 */         .animationBehavior(Animations.SPEAR_DASH, 0.0F))
/*      */       
/* 2041 */       .addFirstBehavior(
/* 2042 */         CECombatBehaviors.Behavior.builder()
/* 2043 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2044 */         .withinDistance(0.0D, 3.0D)
/* 2045 */         .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F))
/*      */       
/* 2047 */       .addFirstBehavior(
/* 2048 */         CECombatBehaviors.Behavior.builder()
/* 2049 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2050 */         .withinDistance(0.0D, 3.0D)
/* 2051 */         .animationBehavior(Animations.GRASPING_SPIRAL_FIRST, 0.0F)
/* 2052 */         .addNextBehavior(
/* 2053 */           CECombatBehaviors.Behavior.builder()
/* 2054 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2055 */           .withinDistance(0.0D, 3.0D)
/* 2056 */           .animationBehavior(Animations.GRASPING_SPIRAL_SECOND, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/* 2060 */     .newBehaviorRoot(
/* 2061 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2062 */       .priority(1.0D)
/* 2063 */       .weight(10.0D)
/* 2064 */       .maxCooldown(40)
/* 2065 */       .addFirstBehavior(
/* 2066 */         CECombatBehaviors.Behavior.builder()
/* 2067 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2068 */         .withinDistance(0.0D, 3.0D)
/* 2069 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2070 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2071 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 2074 */     .newBehaviorRoot(
/* 2075 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2076 */       .priority(1.0D)
/* 2077 */       .weight(2.0D)
/* 2078 */       .maxCooldown(100)
/* 2079 */       .addFirstBehavior(
/* 2080 */         CECombatBehaviors.Behavior.builder()
/* 2081 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2082 */         .withinDistance(0.0D, 3.0D)
/* 2083 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 2085 */       .addFirstBehavior(
/* 2086 */         CECombatBehaviors.Behavior.builder()
/* 2087 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2088 */         .withinDistance(0.0D, 3.0D)
/* 2089 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 2091 */       .addFirstBehavior(
/* 2092 */         CECombatBehaviors.Behavior.builder()
/* 2093 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2094 */         .withinDistance(0.0D, 3.0D)
/* 2095 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 2097 */       .addFirstBehavior(
/* 2098 */         CECombatBehaviors.Behavior.builder()
/* 2099 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2100 */         .withinDistance(0.0D, 3.0D)
/* 2101 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 2103 */       .addFirstBehavior(
/* 2104 */         CECombatBehaviors.Behavior.builder()
/* 2105 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2106 */         .withinDistance(0.0D, 3.0D)
/* 2107 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 2109 */       .addFirstBehavior(
/* 2110 */         CECombatBehaviors.Behavior.builder()
/* 2111 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2112 */         .withinDistance(0.0D, 3.0D)
/* 2113 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 2115 */       .addFirstBehavior(
/* 2116 */         CECombatBehaviors.Behavior.builder()
/* 2117 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2118 */         .withinDistance(0.0D, 3.0D)
/* 2119 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 2122 */     .newBehaviorRoot(
/* 2123 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2124 */       .priority(1.0D)
/* 2125 */       .weight(15.0D)
/* 2126 */       .addFirstBehavior(
/* 2127 */         CECombatBehaviors.Behavior.builder()
/* 2128 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2129 */         .withinDistance(0.0D, 3.0D)
/* 2130 */         .custom(CombatCommon::canPerformGuarding)
/* 2131 */         .guard(40)))
/*      */ 
/*      */     
/* 2134 */     .newBehaviorRoot(
/* 2135 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2136 */       .priority(1.0D)
/* 2137 */       .weight(10.0D)
/* 2138 */       .addFirstBehavior(
/* 2139 */         CECombatBehaviors.Behavior.builder()
/* 2140 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2141 */         .withinDistance(0.0D, 3.0D)
/* 2142 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 2144 */       .addFirstBehavior(
/* 2145 */         CECombatBehaviors.Behavior.builder()
/* 2146 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2147 */         .withinDistance(0.0D, 3.0D)
/* 2148 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 2151 */     .newBehaviorRoot(
/* 2152 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2153 */       .priority(1.0D)
/* 2154 */       .weight(40.0D)
/* 2155 */       .maxCooldown(160)
/* 2156 */       .addFirstBehavior(
/* 2157 */         CECombatBehaviors.Behavior.builder()
/* 2158 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2159 */         .custom(CombatCommon::canJump)
/* 2160 */         .withinDistance(5.0D, 14.0D)
/* 2161 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2162 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 2166 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_SPEAR_SHIELD = CECombatBehaviors.builder()
/* 2167 */     .newBehaviorRoot(
/* 2168 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2169 */       .priority(4.0D)
/* 2170 */       .weight(1000.0D)
/* 2171 */       .maxCooldown(0)
/* 2172 */       .addFirstBehavior(
/* 2173 */         CECombatBehaviors.Behavior.builder()
/* 2174 */         .custom(CombatCommon::canExecute)
/* 2175 */         .withinDistance(0.0D, 5.0D)
/* 2176 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 2177 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 2180 */     .newBehaviorRoot(
/* 2181 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2182 */       .priority(3.0D)
/* 2183 */       .weight(1000.0D)
/* 2184 */       .maxCooldown(0)
/* 2185 */       .addFirstBehavior(
/* 2186 */         CECombatBehaviors.Behavior.builder()
/* 2187 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2188 */         .custom(CombatCommon::canEscape)
/* 2189 */         .withinDistance(0.0D, 8.0D)
/* 2190 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2191 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 2193 */       .addFirstBehavior(
/* 2194 */         CECombatBehaviors.Behavior.builder()
/* 2195 */         .custom(CombatCommon::canEscape)
/* 2196 */         .withinDistance(0.0D, 48.0D)
/* 2197 */         .guard(40)))
/*      */ 
/*      */     
/* 2200 */     .newBehaviorRoot(
/* 2201 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2202 */       .priority(2.0D)
/* 2203 */       .weight(70.0D)
/* 2204 */       .maxCooldown(0)
/* 2205 */       .addFirstBehavior(
/* 2206 */         CECombatBehaviors.Behavior.builder()
/* 2207 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 2208 */         .custom(CombatCommon::canPerformEating)
/* 2209 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2210 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 2213 */     .newBehaviorRoot(
/* 2214 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2215 */       .priority(2.0D)
/* 2216 */       .weight(100.0D)
/* 2217 */       .maxCooldown(120)
/* 2218 */       .addFirstBehavior(
/* 2219 */         CECombatBehaviors.Behavior.builder()
/* 2220 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2221 */         .custom(CombatCommon::canSwapToBow)
/* 2222 */         .withinDistance(7.0D, 14.0D)
/* 2223 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2224 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 2226 */       .addFirstBehavior(
/* 2227 */         CECombatBehaviors.Behavior.builder()
/* 2228 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2229 */         .custom(CombatCommon::canSwapToBow)
/* 2230 */         .withinDistance(7.0D, 14.0D)
/* 2231 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 2232 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 2235 */     .newBehaviorRoot(
/* 2236 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2237 */       .priority(2.0D)
/* 2238 */       .weight(80.0D)
/* 2239 */       .maxCooldown(120)
/* 2240 */       .addFirstBehavior(
/* 2241 */         CECombatBehaviors.Behavior.builder()
/* 2242 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2243 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2244 */         .withinDistance(7.0D, 48.0D)
/* 2245 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2246 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 2249 */     .newBehaviorRoot(
/* 2250 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2251 */       .priority(1.0D)
/* 2252 */       .weight(40.0D)
/* 2253 */       .maxCooldown(20)
/* 2254 */       .addFirstBehavior(
/* 2255 */         CECombatBehaviors.Behavior.builder()
/* 2256 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2257 */         .withinDistance(0.0D, 3.0D)
/* 2258 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2259 */         .addNextBehavior(
/* 2260 */           CECombatBehaviors.Behavior.builder()
/* 2261 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2262 */           .withinDistance(0.0D, 3.0D)
/* 2263 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)))
/*      */ 
/*      */       
/* 2266 */       .addFirstBehavior(
/* 2267 */         CECombatBehaviors.Behavior.builder()
/* 2268 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2269 */         .withinDistance(0.0D, 3.0D)
/* 2270 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2271 */         .addNextBehavior(
/* 2272 */           CECombatBehaviors.Behavior.builder()
/* 2273 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2274 */           .withinDistance(0.0D, 3.0D)
/* 2275 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2276 */           .addNextBehavior(
/* 2277 */             CECombatBehaviors.Behavior.builder()
/* 2278 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2279 */             .withinDistance(0.0D, 4.0D)
/* 2280 */             .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 2281 */             .addNextBehavior(
/* 2282 */               CECombatBehaviors.Behavior.builder()
/* 2283 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2284 */               .withinDistance(0.0D, 4.0D)
/* 2285 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2286 */               .addNextBehavior(
/* 2287 */                 CECombatBehaviors.Behavior.builder()
/* 2288 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2289 */                 .withinDistance(0.0D, 5.0D)
/* 2290 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2291 */                 .addNextBehavior(
/* 2292 */                   CECombatBehaviors.Behavior.builder()
/* 2293 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2294 */                   .withinDistance(0.0D, 5.0D)
/* 2295 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2296 */                   .addNextBehavior(
/* 2297 */                     CECombatBehaviors.Behavior.builder()
/* 2298 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2299 */                     .withinDistance(0.0D, 5.0D)
/* 2300 */                     .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2301 */                     .addNextBehavior(
/* 2302 */                       CECombatBehaviors.Behavior.builder()
/* 2303 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2304 */                       .withinDistance(0.0D, 5.0D)
/* 2305 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
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
/* 2319 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2320 */         .addNextBehavior(
/* 2321 */           CECombatBehaviors.Behavior.builder()
/* 2322 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2323 */           .withinDistance(0.0D, 3.0D)
/* 2324 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2325 */           .addNextBehavior(
/* 2326 */             CECombatBehaviors.Behavior.builder()
/* 2327 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2328 */             .withinDistance(0.0D, 4.0D)
/* 2329 */             .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 2330 */             .addNextBehavior(
/* 2331 */               CECombatBehaviors.Behavior.builder()
/* 2332 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2333 */               .withinDistance(0.0D, 4.0D)
/* 2334 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2335 */               .addNextBehavior(
/* 2336 */                 CECombatBehaviors.Behavior.builder()
/* 2337 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2338 */                 .withinDistance(0.0D, 5.0D)
/* 2339 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2340 */                 .addNextBehavior(
/* 2341 */                   CECombatBehaviors.Behavior.builder()
/* 2342 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2343 */                   .withinDistance(0.0D, 5.0D)
/* 2344 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2345 */                   .addNextBehavior(
/* 2346 */                     CECombatBehaviors.Behavior.builder()
/* 2347 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2348 */                     .withinDistance(0.0D, 5.0D)
/* 2349 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2350 */                     .addNextBehavior(
/* 2351 */                       CECombatBehaviors.Behavior.builder()
/* 2352 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2353 */                       .withinDistance(0.0D, 5.0D)
/* 2354 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2364 */       .addFirstBehavior(
/* 2365 */         CECombatBehaviors.Behavior.builder()
/* 2366 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2367 */         .withinDistance(0.0D, 3.0D)
/* 2368 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2369 */         .addNextBehavior(
/* 2370 */           CECombatBehaviors.Behavior.builder()
/* 2371 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2372 */           .withinDistance(0.0D, 3.0D)
/* 2373 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2374 */           .addNextBehavior(
/* 2375 */             CECombatBehaviors.Behavior.builder()
/* 2376 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2377 */             .withinDistance(0.0D, 4.0D)
/* 2378 */             .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/* 2379 */             .addNextBehavior(
/* 2380 */               CECombatBehaviors.Behavior.builder()
/* 2381 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2382 */               .withinDistance(0.0D, 4.0D)
/* 2383 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2384 */               .addNextBehavior(
/* 2385 */                 CECombatBehaviors.Behavior.builder()
/* 2386 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2387 */                 .withinDistance(0.0D, 5.0D)
/* 2388 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2389 */                 .addNextBehavior(
/* 2390 */                   CECombatBehaviors.Behavior.builder()
/* 2391 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2392 */                   .withinDistance(0.0D, 5.0D)
/* 2393 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2394 */                   .addNextBehavior(
/* 2395 */                     CECombatBehaviors.Behavior.builder()
/* 2396 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2397 */                     .withinDistance(0.0D, 5.0D)
/* 2398 */                     .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2399 */                     .addNextBehavior(
/* 2400 */                       CECombatBehaviors.Behavior.builder()
/* 2401 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2402 */                       .withinDistance(0.0D, 5.0D)
/* 2403 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2413 */       .addFirstBehavior(
/* 2414 */         CECombatBehaviors.Behavior.builder()
/* 2415 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2416 */         .withinDistance(0.0D, 3.0D)
/* 2417 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2418 */         .addNextBehavior(
/* 2419 */           CECombatBehaviors.Behavior.builder()
/* 2420 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2421 */           .withinDistance(0.0D, 3.0D)
/* 2422 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2423 */           .addNextBehavior(
/* 2424 */             CECombatBehaviors.Behavior.builder()
/* 2425 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2426 */             .withinDistance(0.0D, 4.0D)
/* 2427 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2428 */             .addNextBehavior(
/* 2429 */               CECombatBehaviors.Behavior.builder()
/* 2430 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2431 */               .withinDistance(0.0D, 4.0D)
/* 2432 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2433 */               .addNextBehavior(
/* 2434 */                 CECombatBehaviors.Behavior.builder()
/* 2435 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2436 */                 .withinDistance(0.0D, 5.0D)
/* 2437 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2438 */                 .addNextBehavior(
/* 2439 */                   CECombatBehaviors.Behavior.builder()
/* 2440 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2441 */                   .withinDistance(0.0D, 5.0D)
/* 2442 */                   .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 2443 */                   .addNextBehavior(
/* 2444 */                     CECombatBehaviors.Behavior.builder()
/* 2445 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2446 */                     .withinDistance(0.0D, 5.0D)
/* 2447 */                     .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2448 */                     .addNextBehavior(
/* 2449 */                       CECombatBehaviors.Behavior.builder()
/* 2450 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2451 */                       .withinDistance(0.0D, 5.0D)
/* 2452 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2462 */       .addFirstBehavior(
/* 2463 */         CECombatBehaviors.Behavior.builder()
/* 2464 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2465 */         .withinDistance(0.0D, 3.0D)
/* 2466 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2467 */         .addNextBehavior(
/* 2468 */           CECombatBehaviors.Behavior.builder()
/* 2469 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2470 */           .withinDistance(0.0D, 3.0D)
/* 2471 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2472 */           .addNextBehavior(
/* 2473 */             CECombatBehaviors.Behavior.builder()
/* 2474 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2475 */             .withinDistance(0.0D, 4.0D)
/* 2476 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2477 */             .addNextBehavior(
/* 2478 */               CECombatBehaviors.Behavior.builder()
/* 2479 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2480 */               .withinDistance(0.0D, 4.0D)
/* 2481 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2482 */               .addNextBehavior(
/* 2483 */                 CECombatBehaviors.Behavior.builder()
/* 2484 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2485 */                 .withinDistance(0.0D, 5.0D)
/* 2486 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2487 */                 .addNextBehavior(
/* 2488 */                   CECombatBehaviors.Behavior.builder()
/* 2489 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2490 */                   .withinDistance(0.0D, 5.0D)
/* 2491 */                   .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 2492 */                   .addNextBehavior(
/* 2493 */                     CECombatBehaviors.Behavior.builder()
/* 2494 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2495 */                     .withinDistance(0.0D, 5.0D)
/* 2496 */                     .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2497 */                     .addNextBehavior(
/* 2498 */                       CECombatBehaviors.Behavior.builder()
/* 2499 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2500 */                       .withinDistance(0.0D, 5.0D)
/* 2501 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2511 */       .addFirstBehavior(
/* 2512 */         CECombatBehaviors.Behavior.builder()
/* 2513 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2514 */         .withinDistance(0.0D, 3.0D)
/* 2515 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2516 */         .addNextBehavior(
/* 2517 */           CECombatBehaviors.Behavior.builder()
/* 2518 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2519 */           .withinDistance(0.0D, 3.0D)
/* 2520 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2521 */           .addNextBehavior(
/* 2522 */             CECombatBehaviors.Behavior.builder()
/* 2523 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2524 */             .withinDistance(0.0D, 4.0D)
/* 2525 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2526 */             .addNextBehavior(
/* 2527 */               CECombatBehaviors.Behavior.builder()
/* 2528 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2529 */               .withinDistance(0.0D, 4.0D)
/* 2530 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2531 */               .addNextBehavior(
/* 2532 */                 CECombatBehaviors.Behavior.builder()
/* 2533 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2534 */                 .withinDistance(0.0D, 5.0D)
/* 2535 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2536 */                 .addNextBehavior(
/* 2537 */                   CECombatBehaviors.Behavior.builder()
/* 2538 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2539 */                   .withinDistance(0.0D, 5.0D)
/* 2540 */                   .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/* 2541 */                   .addNextBehavior(
/* 2542 */                     CECombatBehaviors.Behavior.builder()
/* 2543 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2544 */                     .withinDistance(0.0D, 5.0D)
/* 2545 */                     .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2546 */                     .addNextBehavior(
/* 2547 */                       CECombatBehaviors.Behavior.builder()
/* 2548 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2549 */                       .withinDistance(0.0D, 5.0D)
/* 2550 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2560 */       .addFirstBehavior(
/* 2561 */         CECombatBehaviors.Behavior.builder()
/* 2562 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2563 */         .withinDistance(0.0D, 3.0D)
/* 2564 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2565 */         .addNextBehavior(
/* 2566 */           CECombatBehaviors.Behavior.builder()
/* 2567 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2568 */           .withinDistance(0.0D, 3.0D)
/* 2569 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2570 */           .addNextBehavior(
/* 2571 */             CECombatBehaviors.Behavior.builder()
/* 2572 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2573 */             .withinDistance(0.0D, 4.0D)
/* 2574 */             .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2575 */             .addNextBehavior(
/* 2576 */               CECombatBehaviors.Behavior.builder()
/* 2577 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2578 */               .withinDistance(0.0D, 4.0D)
/* 2579 */               .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 2580 */               .addNextBehavior(
/* 2581 */                 CECombatBehaviors.Behavior.builder()
/* 2582 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2583 */                 .withinDistance(0.0D, 5.0D)
/* 2584 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2585 */                 .addNextBehavior(
/* 2586 */                   CECombatBehaviors.Behavior.builder()
/* 2587 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2588 */                   .withinDistance(0.0D, 5.0D)
/* 2589 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2590 */                   .addNextBehavior(
/* 2591 */                     CECombatBehaviors.Behavior.builder()
/* 2592 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2593 */                     .withinDistance(0.0D, 5.0D)
/* 2594 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2595 */                     .addNextBehavior(
/* 2596 */                       CECombatBehaviors.Behavior.builder()
/* 2597 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2598 */                       .withinDistance(0.0D, 5.0D)
/* 2599 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2609 */       .addFirstBehavior(
/* 2610 */         CECombatBehaviors.Behavior.builder()
/* 2611 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2612 */         .withinDistance(0.0D, 3.0D)
/* 2613 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2614 */         .addNextBehavior(
/* 2615 */           CECombatBehaviors.Behavior.builder()
/* 2616 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2617 */           .withinDistance(0.0D, 3.0D)
/* 2618 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2619 */           .addNextBehavior(
/* 2620 */             CECombatBehaviors.Behavior.builder()
/* 2621 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2622 */             .withinDistance(0.0D, 4.0D)
/* 2623 */             .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2624 */             .addNextBehavior(
/* 2625 */               CECombatBehaviors.Behavior.builder()
/* 2626 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2627 */               .withinDistance(0.0D, 4.0D)
/* 2628 */               .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 2629 */               .addNextBehavior(
/* 2630 */                 CECombatBehaviors.Behavior.builder()
/* 2631 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2632 */                 .withinDistance(0.0D, 5.0D)
/* 2633 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2634 */                 .addNextBehavior(
/* 2635 */                   CECombatBehaviors.Behavior.builder()
/* 2636 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2637 */                   .withinDistance(0.0D, 5.0D)
/* 2638 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2639 */                   .addNextBehavior(
/* 2640 */                     CECombatBehaviors.Behavior.builder()
/* 2641 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2642 */                     .withinDistance(0.0D, 5.0D)
/* 2643 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2644 */                     .addNextBehavior(
/* 2645 */                       CECombatBehaviors.Behavior.builder()
/* 2646 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2647 */                       .withinDistance(0.0D, 5.0D)
/* 2648 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2658 */       .addFirstBehavior(
/* 2659 */         CECombatBehaviors.Behavior.builder()
/* 2660 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2661 */         .withinDistance(0.0D, 3.0D)
/* 2662 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2663 */         .addNextBehavior(
/* 2664 */           CECombatBehaviors.Behavior.builder()
/* 2665 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2666 */           .withinDistance(0.0D, 3.0D)
/* 2667 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2668 */           .addNextBehavior(
/* 2669 */             CECombatBehaviors.Behavior.builder()
/* 2670 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2671 */             .withinDistance(0.0D, 4.0D)
/* 2672 */             .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2673 */             .addNextBehavior(
/* 2674 */               CECombatBehaviors.Behavior.builder()
/* 2675 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2676 */               .withinDistance(0.0D, 4.0D)
/* 2677 */               .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/* 2678 */               .addNextBehavior(
/* 2679 */                 CECombatBehaviors.Behavior.builder()
/* 2680 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2681 */                 .withinDistance(0.0D, 5.0D)
/* 2682 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2683 */                 .addNextBehavior(
/* 2684 */                   CECombatBehaviors.Behavior.builder()
/* 2685 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2686 */                   .withinDistance(0.0D, 5.0D)
/* 2687 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2688 */                   .addNextBehavior(
/* 2689 */                     CECombatBehaviors.Behavior.builder()
/* 2690 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2691 */                     .withinDistance(0.0D, 5.0D)
/* 2692 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2693 */                     .addNextBehavior(
/* 2694 */                       CECombatBehaviors.Behavior.builder()
/* 2695 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2696 */                       .withinDistance(0.0D, 5.0D)
/* 2697 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2707 */       .addFirstBehavior(
/* 2708 */         CECombatBehaviors.Behavior.builder()
/* 2709 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2710 */         .withinDistance(0.0D, 3.0D)
/* 2711 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2712 */         .addNextBehavior(
/* 2713 */           CECombatBehaviors.Behavior.builder()
/* 2714 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2715 */           .withinDistance(0.0D, 3.0D)
/* 2716 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2717 */           .addNextBehavior(
/* 2718 */             CECombatBehaviors.Behavior.builder()
/* 2719 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2720 */             .withinDistance(0.0D, 4.0D)
/* 2721 */             .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 2722 */             .addNextBehavior(
/* 2723 */               CECombatBehaviors.Behavior.builder()
/* 2724 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2725 */               .withinDistance(0.0D, 4.0D)
/* 2726 */               .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2727 */               .addNextBehavior(
/* 2728 */                 CECombatBehaviors.Behavior.builder()
/* 2729 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2730 */                 .withinDistance(0.0D, 5.0D)
/* 2731 */                 .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2732 */                 .addNextBehavior(
/* 2733 */                   CECombatBehaviors.Behavior.builder()
/* 2734 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2735 */                   .withinDistance(0.0D, 5.0D)
/* 2736 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2737 */                   .addNextBehavior(
/* 2738 */                     CECombatBehaviors.Behavior.builder()
/* 2739 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2740 */                     .withinDistance(0.0D, 5.0D)
/* 2741 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2742 */                     .addNextBehavior(
/* 2743 */                       CECombatBehaviors.Behavior.builder()
/* 2744 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2745 */                       .withinDistance(0.0D, 5.0D)
/* 2746 */                       .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2747 */                       .addNextBehavior(
/* 2748 */                         CECombatBehaviors.Behavior.builder()
/* 2749 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2750 */                         .withinDistance(0.0D, 5.0D)
/* 2751 */                         .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2752 */                         .addNextBehavior(
/* 2753 */                           CECombatBehaviors.Behavior.builder()
/* 2754 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2755 */                           .withinDistance(0.0D, 5.0D)
/* 2756 */                           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))))
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
/* 2768 */       .addFirstBehavior(
/* 2769 */         CECombatBehaviors.Behavior.builder()
/* 2770 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2771 */         .withinDistance(0.0D, 3.0D)
/* 2772 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2773 */         .addNextBehavior(
/* 2774 */           CECombatBehaviors.Behavior.builder()
/* 2775 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2776 */           .withinDistance(0.0D, 3.0D)
/* 2777 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2778 */           .addNextBehavior(
/* 2779 */             CECombatBehaviors.Behavior.builder()
/* 2780 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2781 */             .withinDistance(0.0D, 4.0D)
/* 2782 */             .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 2783 */             .addNextBehavior(
/* 2784 */               CECombatBehaviors.Behavior.builder()
/* 2785 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2786 */               .withinDistance(0.0D, 4.0D)
/* 2787 */               .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2788 */               .addNextBehavior(
/* 2789 */                 CECombatBehaviors.Behavior.builder()
/* 2790 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2791 */                 .withinDistance(0.0D, 5.0D)
/* 2792 */                 .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2793 */                 .addNextBehavior(
/* 2794 */                   CECombatBehaviors.Behavior.builder()
/* 2795 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2796 */                   .withinDistance(0.0D, 5.0D)
/* 2797 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2798 */                   .addNextBehavior(
/* 2799 */                     CECombatBehaviors.Behavior.builder()
/* 2800 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2801 */                     .withinDistance(0.0D, 5.0D)
/* 2802 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2803 */                     .addNextBehavior(
/* 2804 */                       CECombatBehaviors.Behavior.builder()
/* 2805 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2806 */                       .withinDistance(0.0D, 5.0D)
/* 2807 */                       .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2808 */                       .addNextBehavior(
/* 2809 */                         CECombatBehaviors.Behavior.builder()
/* 2810 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2811 */                         .withinDistance(0.0D, 5.0D)
/* 2812 */                         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2813 */                         .addNextBehavior(
/* 2814 */                           CECombatBehaviors.Behavior.builder()
/* 2815 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2816 */                           .withinDistance(0.0D, 5.0D)
/* 2817 */                           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))))
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
/* 2829 */       .addFirstBehavior(
/* 2830 */         CECombatBehaviors.Behavior.builder()
/* 2831 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2832 */         .withinDistance(0.0D, 3.0D)
/* 2833 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2834 */         .addNextBehavior(
/* 2835 */           CECombatBehaviors.Behavior.builder()
/* 2836 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2837 */           .withinDistance(0.0D, 3.0D)
/* 2838 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2839 */           .addNextBehavior(
/* 2840 */             CECombatBehaviors.Behavior.builder()
/* 2841 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2842 */             .withinDistance(0.0D, 4.0D)
/* 2843 */             .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/* 2844 */             .addNextBehavior(
/* 2845 */               CECombatBehaviors.Behavior.builder()
/* 2846 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2847 */               .withinDistance(0.0D, 4.0D)
/* 2848 */               .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2849 */               .addNextBehavior(
/* 2850 */                 CECombatBehaviors.Behavior.builder()
/* 2851 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2852 */                 .withinDistance(0.0D, 5.0D)
/* 2853 */                 .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2854 */                 .addNextBehavior(
/* 2855 */                   CECombatBehaviors.Behavior.builder()
/* 2856 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2857 */                   .withinDistance(0.0D, 5.0D)
/* 2858 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2859 */                   .addNextBehavior(
/* 2860 */                     CECombatBehaviors.Behavior.builder()
/* 2861 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2862 */                     .withinDistance(0.0D, 5.0D)
/* 2863 */                     .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2864 */                     .addNextBehavior(
/* 2865 */                       CECombatBehaviors.Behavior.builder()
/* 2866 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2867 */                       .withinDistance(0.0D, 5.0D)
/* 2868 */                       .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2869 */                       .addNextBehavior(
/* 2870 */                         CECombatBehaviors.Behavior.builder()
/* 2871 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2872 */                         .withinDistance(0.0D, 5.0D)
/* 2873 */                         .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 2874 */                         .addNextBehavior(
/* 2875 */                           CECombatBehaviors.Behavior.builder()
/* 2876 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2877 */                           .withinDistance(0.0D, 5.0D)
/* 2878 */                           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))))
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
/* 2890 */       .addFirstBehavior(
/* 2891 */         CECombatBehaviors.Behavior.builder()
/* 2892 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2893 */         .withinDistance(0.0D, 3.0D)
/* 2894 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2895 */         .addNextBehavior(
/* 2896 */           CECombatBehaviors.Behavior.builder()
/* 2897 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2898 */           .withinDistance(0.0D, 3.0D)
/* 2899 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2900 */           .addNextBehavior(
/* 2901 */             CECombatBehaviors.Behavior.builder()
/* 2902 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2903 */             .withinDistance(0.0D, 4.0D)
/* 2904 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2905 */             .addNextBehavior(
/* 2906 */               CECombatBehaviors.Behavior.builder()
/* 2907 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2908 */               .withinDistance(0.0D, 4.0D)
/* 2909 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2910 */               .addNextBehavior(
/* 2911 */                 CECombatBehaviors.Behavior.builder()
/* 2912 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2913 */                 .withinDistance(0.0D, 5.0D)
/* 2914 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2915 */                 .addNextBehavior(
/* 2916 */                   CECombatBehaviors.Behavior.builder()
/* 2917 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2918 */                   .withinDistance(0.0D, 5.0D)
/* 2919 */                   .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 2920 */                   .addNextBehavior(
/* 2921 */                     CECombatBehaviors.Behavior.builder()
/* 2922 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2923 */                     .withinDistance(0.0D, 5.0D)
/* 2924 */                     .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2925 */                     .addNextBehavior(
/* 2926 */                       CECombatBehaviors.Behavior.builder()
/* 2927 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2928 */                       .withinDistance(0.0D, 5.0D)
/* 2929 */                       .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2930 */                       .addNextBehavior(
/* 2931 */                         CECombatBehaviors.Behavior.builder()
/* 2932 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2933 */                         .withinDistance(0.0D, 5.0D)
/* 2934 */                         .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2935 */                         .addNextBehavior(
/* 2936 */                           CECombatBehaviors.Behavior.builder()
/* 2937 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2938 */                           .withinDistance(0.0D, 5.0D)
/* 2939 */                           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))))
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
/* 2951 */       .addFirstBehavior(
/* 2952 */         CECombatBehaviors.Behavior.builder()
/* 2953 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2954 */         .withinDistance(0.0D, 3.0D)
/* 2955 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2956 */         .addNextBehavior(
/* 2957 */           CECombatBehaviors.Behavior.builder()
/* 2958 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2959 */           .withinDistance(0.0D, 3.0D)
/* 2960 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2961 */           .addNextBehavior(
/* 2962 */             CECombatBehaviors.Behavior.builder()
/* 2963 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2964 */             .withinDistance(0.0D, 4.0D)
/* 2965 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2966 */             .addNextBehavior(
/* 2967 */               CECombatBehaviors.Behavior.builder()
/* 2968 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2969 */               .withinDistance(0.0D, 4.0D)
/* 2970 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2971 */               .addNextBehavior(
/* 2972 */                 CECombatBehaviors.Behavior.builder()
/* 2973 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2974 */                 .withinDistance(0.0D, 5.0D)
/* 2975 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 2976 */                 .addNextBehavior(
/* 2977 */                   CECombatBehaviors.Behavior.builder()
/* 2978 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2979 */                   .withinDistance(0.0D, 5.0D)
/* 2980 */                   .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F)
/* 2981 */                   .addNextBehavior(
/* 2982 */                     CECombatBehaviors.Behavior.builder()
/* 2983 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2984 */                     .withinDistance(0.0D, 5.0D)
/* 2985 */                     .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 2986 */                     .addNextBehavior(
/* 2987 */                       CECombatBehaviors.Behavior.builder()
/* 2988 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2989 */                       .withinDistance(0.0D, 5.0D)
/* 2990 */                       .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 2991 */                       .addNextBehavior(
/* 2992 */                         CECombatBehaviors.Behavior.builder()
/* 2993 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2994 */                         .withinDistance(0.0D, 5.0D)
/* 2995 */                         .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2996 */                         .addNextBehavior(
/* 2997 */                           CECombatBehaviors.Behavior.builder()
/* 2998 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2999 */                           .withinDistance(0.0D, 5.0D)
/* 3000 */                           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))))
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
/* 3012 */       .addFirstBehavior(
/* 3013 */         CECombatBehaviors.Behavior.builder()
/* 3014 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3015 */         .withinDistance(0.0D, 3.0D)
/* 3016 */         .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 3017 */         .addNextBehavior(
/* 3018 */           CECombatBehaviors.Behavior.builder()
/* 3019 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3020 */           .withinDistance(0.0D, 3.0D)
/* 3021 */           .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 3022 */           .addNextBehavior(
/* 3023 */             CECombatBehaviors.Behavior.builder()
/* 3024 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3025 */             .withinDistance(0.0D, 4.0D)
/* 3026 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3027 */             .addNextBehavior(
/* 3028 */               CECombatBehaviors.Behavior.builder()
/* 3029 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3030 */               .withinDistance(0.0D, 4.0D)
/* 3031 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3032 */               .addNextBehavior(
/* 3033 */                 CECombatBehaviors.Behavior.builder()
/* 3034 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3035 */                 .withinDistance(0.0D, 5.0D)
/* 3036 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3037 */                 .addNextBehavior(
/* 3038 */                   CECombatBehaviors.Behavior.builder()
/* 3039 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3040 */                   .withinDistance(0.0D, 5.0D)
/* 3041 */                   .animationBehavior(Animations.HEARTPIERCER, 0.0F)
/* 3042 */                   .addNextBehavior(
/* 3043 */                     CECombatBehaviors.Behavior.builder()
/* 3044 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3045 */                     .withinDistance(0.0D, 5.0D)
/* 3046 */                     .animationBehavior(Animations.SPEAR_ONEHAND_AUTO, 0.0F)
/* 3047 */                     .addNextBehavior(
/* 3048 */                       CECombatBehaviors.Behavior.builder()
/* 3049 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3050 */                       .withinDistance(0.0D, 5.0D)
/* 3051 */                       .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 3052 */                       .addNextBehavior(
/* 3053 */                         CECombatBehaviors.Behavior.builder()
/* 3054 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3055 */                         .withinDistance(0.0D, 5.0D)
/* 3056 */                         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 3057 */                         .addNextBehavior(
/* 3058 */                           CECombatBehaviors.Behavior.builder()
/* 3059 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3060 */                           .withinDistance(0.0D, 5.0D)
/* 3061 */                           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))))
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
/*      */     
/* 3074 */     .newBehaviorRoot(
/* 3075 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3076 */       .priority(1.0D)
/* 3077 */       .weight(20.0D)
/* 3078 */       .maxCooldown(100)
/* 3079 */       .addFirstBehavior(
/* 3080 */         CECombatBehaviors.Behavior.builder()
/* 3081 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3082 */         .withinDistance(0.0D, 3.0D)
/* 3083 */         .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3084 */         .addNextBehavior(
/* 3085 */           CECombatBehaviors.Behavior.builder()
/* 3086 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3087 */           .withinDistance(0.0D, 4.0D)
/* 3088 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3089 */           .addNextBehavior(
/* 3090 */             CECombatBehaviors.Behavior.builder()
/* 3091 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3092 */             .withinDistance(0.0D, 5.0D)
/* 3093 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3098 */     .newBehaviorRoot(
/* 3099 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3100 */       .priority(1.0D)
/* 3101 */       .weight(10.0D)
/* 3102 */       .maxCooldown(100)
/* 3103 */       .addFirstBehavior(
/* 3104 */         CECombatBehaviors.Behavior.builder()
/* 3105 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3106 */         .withinDistance(0.0D, 3.0D)
/* 3107 */         .animationBehavior(Animations.SPEAR_DASH, 0.0F))
/*      */       
/* 3109 */       .addFirstBehavior(
/* 3110 */         CECombatBehaviors.Behavior.builder()
/* 3111 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3112 */         .withinDistance(0.0D, 3.0D)
/* 3113 */         .animationBehavior(WOMAnimations.STAFF_KINKONG, 0.0F))
/*      */       
/* 3115 */       .addFirstBehavior(
/* 3116 */         CECombatBehaviors.Behavior.builder()
/* 3117 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3118 */         .withinDistance(0.0D, 3.0D)
/* 3119 */         .animationBehavior(Animations.HEARTPIERCER, 0.0F)))
/*      */ 
/*      */     
/* 3122 */     .newBehaviorRoot(
/* 3123 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3124 */       .priority(1.0D)
/* 3125 */       .weight(10.0D)
/* 3126 */       .maxCooldown(40)
/* 3127 */       .addFirstBehavior(
/* 3128 */         CECombatBehaviors.Behavior.builder()
/* 3129 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3130 */         .withinDistance(0.0D, 3.0D)
/* 3131 */         .custom(CombatCommon::canThrowEnderPearl)
/* 3132 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 3133 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 3136 */     .newBehaviorRoot(
/* 3137 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3138 */       .priority(1.0D)
/* 3139 */       .weight(2.0D)
/* 3140 */       .maxCooldown(100)
/* 3141 */       .addFirstBehavior(
/* 3142 */         CECombatBehaviors.Behavior.builder()
/* 3143 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3144 */         .withinDistance(0.0D, 3.0D)
/* 3145 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 3147 */       .addFirstBehavior(
/* 3148 */         CECombatBehaviors.Behavior.builder()
/* 3149 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3150 */         .withinDistance(0.0D, 3.0D)
/* 3151 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 3153 */       .addFirstBehavior(
/* 3154 */         CECombatBehaviors.Behavior.builder()
/* 3155 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3156 */         .withinDistance(0.0D, 3.0D)
/* 3157 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 3159 */       .addFirstBehavior(
/* 3160 */         CECombatBehaviors.Behavior.builder()
/* 3161 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3162 */         .withinDistance(0.0D, 3.0D)
/* 3163 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 3165 */       .addFirstBehavior(
/* 3166 */         CECombatBehaviors.Behavior.builder()
/* 3167 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3168 */         .withinDistance(0.0D, 3.0D)
/* 3169 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 3171 */       .addFirstBehavior(
/* 3172 */         CECombatBehaviors.Behavior.builder()
/* 3173 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3174 */         .withinDistance(0.0D, 3.0D)
/* 3175 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 3177 */       .addFirstBehavior(
/* 3178 */         CECombatBehaviors.Behavior.builder()
/* 3179 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3180 */         .withinDistance(0.0D, 3.0D)
/* 3181 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 3184 */     .newBehaviorRoot(
/* 3185 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3186 */       .priority(1.0D)
/* 3187 */       .weight(15.0D)
/* 3188 */       .addFirstBehavior(
/* 3189 */         CECombatBehaviors.Behavior.builder()
/* 3190 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3191 */         .withinDistance(0.0D, 3.0D)
/* 3192 */         .custom(CombatCommon::canPerformGuarding)
/* 3193 */         .guard(40)))
/*      */ 
/*      */     
/* 3196 */     .newBehaviorRoot(
/* 3197 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3198 */       .priority(1.0D)
/* 3199 */       .weight(10.0D)
/* 3200 */       .addFirstBehavior(
/* 3201 */         CECombatBehaviors.Behavior.builder()
/* 3202 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3203 */         .withinDistance(0.0D, 3.0D)
/* 3204 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 3206 */       .addFirstBehavior(
/* 3207 */         CECombatBehaviors.Behavior.builder()
/* 3208 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3209 */         .withinDistance(0.0D, 3.0D)
/* 3210 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 3213 */     .newBehaviorRoot(
/* 3214 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3215 */       .priority(1.0D)
/* 3216 */       .weight(40.0D)
/* 3217 */       .maxCooldown(160)
/* 3218 */       .addFirstBehavior(
/* 3219 */         CECombatBehaviors.Behavior.builder()
/* 3220 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3221 */         .custom(CombatCommon::canJump)
/* 3222 */         .withinDistance(5.0D, 14.0D)
/* 3223 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 3224 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 3228 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_SPEAR = CECombatBehaviors.builder()
/* 3229 */     .newBehaviorRoot(
/* 3230 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3231 */       .priority(4.0D)
/* 3232 */       .weight(1000.0D)
/* 3233 */       .maxCooldown(0)
/* 3234 */       .addFirstBehavior(
/* 3235 */         CECombatBehaviors.Behavior.builder()
/* 3236 */         .custom(CombatCommon::canExecute)
/* 3237 */         .withinDistance(0.0D, 5.0D)
/* 3238 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 3239 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 3242 */     .newBehaviorRoot(
/* 3243 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3244 */       .priority(3.0D)
/* 3245 */       .weight(1000.0D)
/* 3246 */       .maxCooldown(0)
/* 3247 */       .addFirstBehavior(
/* 3248 */         CECombatBehaviors.Behavior.builder()
/* 3249 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3250 */         .custom(CombatCommon::canEscape)
/* 3251 */         .withinDistance(0.0D, 8.0D)
/* 3252 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 3253 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 3255 */       .addFirstBehavior(
/* 3256 */         CECombatBehaviors.Behavior.builder()
/* 3257 */         .custom(CombatCommon::canEscape)
/* 3258 */         .withinDistance(0.0D, 48.0D)
/* 3259 */         .guard(40)))
/*      */ 
/*      */     
/* 3262 */     .newBehaviorRoot(
/* 3263 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3264 */       .priority(2.0D)
/* 3265 */       .weight(70.0D)
/* 3266 */       .maxCooldown(0)
/* 3267 */       .addFirstBehavior(
/* 3268 */         CECombatBehaviors.Behavior.builder()
/* 3269 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 3270 */         .custom(CombatCommon::canPerformEating)
/* 3271 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 3272 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 3275 */     .newBehaviorRoot(
/* 3276 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3277 */       .priority(2.0D)
/* 3278 */       .weight(100.0D)
/* 3279 */       .maxCooldown(120)
/* 3280 */       .addFirstBehavior(
/* 3281 */         CECombatBehaviors.Behavior.builder()
/* 3282 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3283 */         .custom(CombatCommon::canSwapToBow)
/* 3284 */         .withinDistance(7.0D, 14.0D)
/* 3285 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 3286 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 3288 */       .addFirstBehavior(
/* 3289 */         CECombatBehaviors.Behavior.builder()
/* 3290 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3291 */         .custom(CombatCommon::canSwapToBow)
/* 3292 */         .withinDistance(7.0D, 14.0D)
/* 3293 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 3294 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 3297 */     .newBehaviorRoot(
/* 3298 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3299 */       .priority(2.0D)
/* 3300 */       .weight(80.0D)
/* 3301 */       .maxCooldown(120)
/* 3302 */       .addFirstBehavior(
/* 3303 */         CECombatBehaviors.Behavior.builder()
/* 3304 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3305 */         .custom(CombatCommon::canThrowEnderPearl)
/* 3306 */         .withinDistance(7.0D, 48.0D)
/* 3307 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 3308 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 3311 */     .newBehaviorRoot(
/* 3312 */       CECombatBehaviors.BehaviorRoot.builder()
/* 3313 */       .priority(1.0D)
/* 3314 */       .weight(40.0D)
/* 3315 */       .maxCooldown(20)
/* 3316 */       .addFirstBehavior(
/* 3317 */         CECombatBehaviors.Behavior.builder()
/* 3318 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3319 */         .withinDistance(0.0D, 3.0D)
/* 3320 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 3321 */         .addNextBehavior(
/* 3322 */           CECombatBehaviors.Behavior.builder()
/* 3323 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3324 */           .withinDistance(0.0D, 3.0D)
/* 3325 */           .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 3326 */           .addNextBehavior(
/* 3327 */             CECombatBehaviors.Behavior.builder()
/* 3328 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3329 */             .withinDistance(0.0D, 3.0D)
/* 3330 */             .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 3331 */             .addNextBehavior(
/* 3332 */               CECombatBehaviors.Behavior.builder()
/* 3333 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3334 */               .withinDistance(0.0D, 3.0D)
/* 3335 */               .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 3336 */               .addNextBehavior(
/* 3337 */                 CECombatBehaviors.Behavior.builder()
/* 3338 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3339 */                 .withinDistance(0.0D, 3.0D)
/* 3340 */                 .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3346 */       .addFirstBehavior(
/* 3347 */         CECombatBehaviors.Behavior.builder()
/* 3348 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3349 */         .withinDistance(0.0D, 3.0D)
/* 3350 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 3351 */         .addNextBehavior(
/* 3352 */           CECombatBehaviors.Behavior.builder()
/* 3353 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3354 */           .withinDistance(0.0D, 3.0D)
/* 3355 */           .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 3356 */           .addNextBehavior(
/* 3357 */             CECombatBehaviors.Behavior.builder()
/* 3358 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3359 */             .withinDistance(0.0D, 4.0D)
/* 3360 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3361 */             .addNextBehavior(
/* 3362 */               CECombatBehaviors.Behavior.builder()
/* 3363 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3364 */               .withinDistance(0.0D, 4.0D)
/* 3365 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3366 */               .addNextBehavior(
/* 3367 */                 CECombatBehaviors.Behavior.builder()
/* 3368 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3369 */                 .withinDistance(0.0D, 5.0D)
/* 3370 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3371 */                 .addNextBehavior(
/* 3372 */                   CECombatBehaviors.Behavior.builder()
/* 3373 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3374 */                   .withinDistance(0.0D, 5.0D)
/* 3375 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 3376 */                   .addNextBehavior(
/* 3377 */                     CECombatBehaviors.Behavior.builder()
/* 3378 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3379 */                     .withinDistance(0.0D, 5.0D)
/* 3380 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3389 */       .addFirstBehavior(
/* 3390 */         CECombatBehaviors.Behavior.builder()
/* 3391 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3392 */         .withinDistance(0.0D, 3.0D)
/* 3393 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 3394 */         .addNextBehavior(
/* 3395 */           CECombatBehaviors.Behavior.builder()
/* 3396 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3397 */           .withinDistance(0.0D, 3.0D)
/* 3398 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 3399 */           .addNextBehavior(
/* 3400 */             CECombatBehaviors.Behavior.builder()
/* 3401 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3402 */             .withinDistance(0.0D, 4.0D)
/* 3403 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3404 */             .addNextBehavior(
/* 3405 */               CECombatBehaviors.Behavior.builder()
/* 3406 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3407 */               .withinDistance(0.0D, 4.0D)
/* 3408 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3409 */               .addNextBehavior(
/* 3410 */                 CECombatBehaviors.Behavior.builder()
/* 3411 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3412 */                 .withinDistance(0.0D, 5.0D)
/* 3413 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3414 */                 .addNextBehavior(
/* 3415 */                   CECombatBehaviors.Behavior.builder()
/* 3416 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3417 */                   .withinDistance(0.0D, 5.0D)
/* 3418 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 3419 */                   .addNextBehavior(
/* 3420 */                     CECombatBehaviors.Behavior.builder()
/* 3421 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3422 */                     .withinDistance(0.0D, 5.0D)
/* 3423 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3432 */       .addFirstBehavior(
/* 3433 */         CECombatBehaviors.Behavior.builder()
/* 3434 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3435 */         .withinDistance(0.0D, 3.0D)
/* 3436 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 3437 */         .addNextBehavior(
/* 3438 */           CECombatBehaviors.Behavior.builder()
/* 3439 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3440 */           .withinDistance(0.0D, 3.0D)
/* 3441 */           .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 3442 */           .addNextBehavior(
/* 3443 */             CECombatBehaviors.Behavior.builder()
/* 3444 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3445 */             .withinDistance(0.0D, 4.0D)
/* 3446 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3447 */             .addNextBehavior(
/* 3448 */               CECombatBehaviors.Behavior.builder()
/* 3449 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3450 */               .withinDistance(0.0D, 4.0D)
/* 3451 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3452 */               .addNextBehavior(
/* 3453 */                 CECombatBehaviors.Behavior.builder()
/* 3454 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3455 */                 .withinDistance(0.0D, 5.0D)
/* 3456 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3457 */                 .addNextBehavior(
/* 3458 */                   CECombatBehaviors.Behavior.builder()
/* 3459 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3460 */                   .withinDistance(0.0D, 5.0D)
/* 3461 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 3462 */                   .addNextBehavior(
/* 3463 */                     CECombatBehaviors.Behavior.builder()
/* 3464 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3465 */                     .withinDistance(0.0D, 5.0D)
/* 3466 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3475 */       .addFirstBehavior(
/* 3476 */         CECombatBehaviors.Behavior.builder()
/* 3477 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3478 */         .withinDistance(0.0D, 3.0D)
/* 3479 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 3480 */         .addNextBehavior(
/* 3481 */           CECombatBehaviors.Behavior.builder()
/* 3482 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3483 */           .withinDistance(0.0D, 3.0D)
/* 3484 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 3485 */           .addNextBehavior(
/* 3486 */             CECombatBehaviors.Behavior.builder()
/* 3487 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3488 */             .withinDistance(0.0D, 4.0D)
/* 3489 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3490 */             .addNextBehavior(
/* 3491 */               CECombatBehaviors.Behavior.builder()
/* 3492 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3493 */               .withinDistance(0.0D, 4.0D)
/* 3494 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3495 */               .addNextBehavior(
/* 3496 */                 CECombatBehaviors.Behavior.builder()
/* 3497 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3498 */                 .withinDistance(0.0D, 5.0D)
/* 3499 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3500 */                 .addNextBehavior(
/* 3501 */                   CECombatBehaviors.Behavior.builder()
/* 3502 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3503 */                   .withinDistance(0.0D, 5.0D)
/* 3504 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 3505 */                   .addNextBehavior(
/* 3506 */                     CECombatBehaviors.Behavior.builder()
/* 3507 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3508 */                     .withinDistance(0.0D, 5.0D)
/* 3509 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3518 */       .addFirstBehavior(
/* 3519 */         CECombatBehaviors.Behavior.builder()
/* 3520 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3521 */         .withinDistance(0.0D, 3.0D)
/* 3522 */         .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 3523 */         .addNextBehavior(
/* 3524 */           CECombatBehaviors.Behavior.builder()
/* 3525 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3526 */           .withinDistance(0.0D, 3.0D)
/* 3527 */           .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 3528 */           .addNextBehavior(
/* 3529 */             CECombatBehaviors.Behavior.builder()
/* 3530 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3531 */             .withinDistance(0.0D, 4.0D)
/* 3532 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3533 */             .addNextBehavior(
/* 3534 */               CECombatBehaviors.Behavior.builder()
/* 3535 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3536 */               .withinDistance(0.0D, 4.0D)
/* 3537 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3538 */               .addNextBehavior(
/* 3539 */                 CECombatBehaviors.Behavior.builder()
/* 3540 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3541 */                 .withinDistance(0.0D, 5.0D)
/* 3542 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3543 */                 .addNextBehavior(
/* 3544 */                   CECombatBehaviors.Behavior.builder()
/* 3545 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3546 */                   .withinDistance(0.0D, 5.0D)
/* 3547 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 3548 */                   .addNextBehavior(
/* 3549 */                     CECombatBehaviors.Behavior.builder()
/* 3550 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3551 */                     .withinDistance(0.0D, 5.0D)
/* 3552 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3561 */       .addFirstBehavior(
/* 3562 */         CECombatBehaviors.Behavior.builder()
/* 3563 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3564 */         .withinDistance(0.0D, 3.0D)
/* 3565 */         .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 3566 */         .addNextBehavior(
/* 3567 */           CECombatBehaviors.Behavior.builder()
/* 3568 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3569 */           .withinDistance(0.0D, 3.0D)
/* 3570 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 3571 */           .addNextBehavior(
/* 3572 */             CECombatBehaviors.Behavior.builder()
/* 3573 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3574 */             .withinDistance(0.0D, 4.0D)
/* 3575 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3576 */             .addNextBehavior(
/* 3577 */               CECombatBehaviors.Behavior.builder()
/* 3578 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3579 */               .withinDistance(0.0D, 4.0D)
/* 3580 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3581 */               .addNextBehavior(
/* 3582 */                 CECombatBehaviors.Behavior.builder()
/* 3583 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3584 */                 .withinDistance(0.0D, 5.0D)
/* 3585 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3586 */                 .addNextBehavior(
/* 3587 */                   CECombatBehaviors.Behavior.builder()
/* 3588 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3589 */                   .withinDistance(0.0D, 5.0D)
/* 3590 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 3591 */                   .addNextBehavior(
/* 3592 */                     CECombatBehaviors.Behavior.builder()
/* 3593 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3594 */                     .withinDistance(0.0D, 5.0D)
/* 3595 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3604 */       .addFirstBehavior(
/* 3605 */         CECombatBehaviors.Behavior.builder()
/* 3606 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3607 */         .withinDistance(0.0D, 3.0D)
/* 3608 */         .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 3609 */         .addNextBehavior(
/* 3610 */           CECombatBehaviors.Behavior.builder()
/* 3611 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3612 */           .withinDistance(0.0D, 3.0D)
/* 3613 */           .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 3614 */           .addNextBehavior(
/* 3615 */             CECombatBehaviors.Behavior.builder()
/* 3616 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3617 */             .withinDistance(0.0D, 4.0D)
/* 3618 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3619 */             .addNextBehavior(
/* 3620 */               CECombatBehaviors.Behavior.builder()
/* 3621 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3622 */               .withinDistance(0.0D, 4.0D)
/* 3623 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3624 */               .addNextBehavior(
/* 3625 */                 CECombatBehaviors.Behavior.builder()
/* 3626 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3627 */                 .withinDistance(0.0D, 5.0D)
/* 3628 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3629 */                 .addNextBehavior(
/* 3630 */                   CECombatBehaviors.Behavior.builder()
/* 3631 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3632 */                   .withinDistance(0.0D, 5.0D)
/* 3633 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 3634 */                   .addNextBehavior(
/* 3635 */                     CECombatBehaviors.Behavior.builder()
/* 3636 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3637 */                     .withinDistance(0.0D, 5.0D)
/* 3638 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3647 */       .addFirstBehavior(
/* 3648 */         CECombatBehaviors.Behavior.builder()
/* 3649 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3650 */         .withinDistance(0.0D, 3.0D)
/* 3651 */         .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 3652 */         .addNextBehavior(
/* 3653 */           CECombatBehaviors.Behavior.builder()
/* 3654 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3655 */           .withinDistance(0.0D, 3.0D)
/* 3656 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 3657 */           .addNextBehavior(
/* 3658 */             CECombatBehaviors.Behavior.builder()
/* 3659 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3660 */             .withinDistance(0.0D, 4.0D)
/* 3661 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3662 */             .addNextBehavior(
/* 3663 */               CECombatBehaviors.Behavior.builder()
/* 3664 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3665 */               .withinDistance(0.0D, 4.0D)
/* 3666 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3667 */               .addNextBehavior(
/* 3668 */                 CECombatBehaviors.Behavior.builder()
/* 3669 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3670 */                 .withinDistance(0.0D, 5.0D)
/* 3671 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3672 */                 .addNextBehavior(
/* 3673 */                   CECombatBehaviors.Behavior.builder()
/* 3674 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3675 */                   .withinDistance(0.0D, 5.0D)
/* 3676 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 3677 */                   .addNextBehavior(
/* 3678 */                     CECombatBehaviors.Behavior.builder()
/* 3679 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3680 */                     .withinDistance(0.0D, 5.0D)
/* 3681 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3690 */       .addFirstBehavior(
/* 3691 */         CECombatBehaviors.Behavior.builder()
/* 3692 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3693 */         .withinDistance(0.0D, 3.0D)
/* 3694 */         .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 3695 */         .addNextBehavior(
/* 3696 */           CECombatBehaviors.Behavior.builder()
/* 3697 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3698 */           .withinDistance(0.0D, 3.0D)
/* 3699 */           .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 3700 */           .addNextBehavior(
/* 3701 */             CECombatBehaviors.Behavior.builder()
/* 3702 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3703 */             .withinDistance(0.0D, 4.0D)
/* 3704 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3705 */             .addNextBehavior(
/* 3706 */               CECombatBehaviors.Behavior.builder()
/* 3707 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3708 */               .withinDistance(0.0D, 4.0D)
/* 3709 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3710 */               .addNextBehavior(
/* 3711 */                 CECombatBehaviors.Behavior.builder()
/* 3712 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3713 */                 .withinDistance(0.0D, 5.0D)
/* 3714 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3715 */                 .addNextBehavior(
/* 3716 */                   CECombatBehaviors.Behavior.builder()
/* 3717 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3718 */                   .withinDistance(0.0D, 5.0D)
/* 3719 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 3720 */                   .addNextBehavior(
/* 3721 */                     CECombatBehaviors.Behavior.builder()
/* 3722 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3723 */                     .withinDistance(0.0D, 5.0D)
/* 3724 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3733 */       .addFirstBehavior(
/* 3734 */         CECombatBehaviors.Behavior.builder()
/* 3735 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3736 */         .withinDistance(0.0D, 3.0D)
/* 3737 */         .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 3738 */         .addNextBehavior(
/* 3739 */           CECombatBehaviors.Behavior.builder()
/* 3740 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3741 */           .withinDistance(0.0D, 3.0D)
/* 3742 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 3743 */           .addNextBehavior(
/* 3744 */             CECombatBehaviors.Behavior.builder()
/* 3745 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3746 */             .withinDistance(0.0D, 4.0D)
/* 3747 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3748 */             .addNextBehavior(
/* 3749 */               CECombatBehaviors.Behavior.builder()
/* 3750 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3751 */               .withinDistance(0.0D, 4.0D)
/* 3752 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3753 */               .addNextBehavior(
/* 3754 */                 CECombatBehaviors.Behavior.builder()
/* 3755 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3756 */                 .withinDistance(0.0D, 5.0D)
/* 3757 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3758 */                 .addNextBehavior(
/* 3759 */                   CECombatBehaviors.Behavior.builder()
/* 3760 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3761 */                   .withinDistance(0.0D, 5.0D)
/* 3762 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 3763 */                   .addNextBehavior(
/* 3764 */                     CECombatBehaviors.Behavior.builder()
/* 3765 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3766 */                     .withinDistance(0.0D, 5.0D)
/* 3767 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3776 */       .addFirstBehavior(
/* 3777 */         CECombatBehaviors.Behavior.builder()
/* 3778 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3779 */         .withinDistance(0.0D, 3.0D)
/* 3780 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 3781 */         .addNextBehavior(
/* 3782 */           CECombatBehaviors.Behavior.builder()
/* 3783 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3784 */           .withinDistance(0.0D, 3.0D)
/* 3785 */           .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 3786 */           .addNextBehavior(
/* 3787 */             CECombatBehaviors.Behavior.builder()
/* 3788 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3789 */             .withinDistance(0.0D, 4.0D)
/* 3790 */             .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 3791 */             .addNextBehavior(
/* 3792 */               CECombatBehaviors.Behavior.builder()
/* 3793 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3794 */               .withinDistance(0.0D, 4.0D)
/* 3795 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3796 */               .addNextBehavior(
/* 3797 */                 CECombatBehaviors.Behavior.builder()
/* 3798 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3799 */                 .withinDistance(0.0D, 5.0D)
/* 3800 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3801 */                 .addNextBehavior(
/* 3802 */                   CECombatBehaviors.Behavior.builder()
/* 3803 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3804 */                   .withinDistance(0.0D, 5.0D)
/* 3805 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3806 */                   .addNextBehavior(
/* 3807 */                     CECombatBehaviors.Behavior.builder()
/* 3808 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3809 */                     .withinDistance(0.0D, 5.0D)
/* 3810 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 3811 */                     .addNextBehavior(
/* 3812 */                       CECombatBehaviors.Behavior.builder()
/* 3813 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3814 */                       .withinDistance(0.0D, 5.0D)
/* 3815 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3825 */       .addFirstBehavior(
/* 3826 */         CECombatBehaviors.Behavior.builder()
/* 3827 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3828 */         .withinDistance(0.0D, 3.0D)
/* 3829 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO1, 0.0F)
/* 3830 */         .addNextBehavior(
/* 3831 */           CECombatBehaviors.Behavior.builder()
/* 3832 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3833 */           .withinDistance(0.0D, 3.0D)
/* 3834 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 3835 */           .addNextBehavior(
/* 3836 */             CECombatBehaviors.Behavior.builder()
/* 3837 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3838 */             .withinDistance(0.0D, 4.0D)
/* 3839 */             .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 3840 */             .addNextBehavior(
/* 3841 */               CECombatBehaviors.Behavior.builder()
/* 3842 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3843 */               .withinDistance(0.0D, 4.0D)
/* 3844 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3845 */               .addNextBehavior(
/* 3846 */                 CECombatBehaviors.Behavior.builder()
/* 3847 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3848 */                 .withinDistance(0.0D, 5.0D)
/* 3849 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3850 */                 .addNextBehavior(
/* 3851 */                   CECombatBehaviors.Behavior.builder()
/* 3852 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3853 */                   .withinDistance(0.0D, 5.0D)
/* 3854 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3855 */                   .addNextBehavior(
/* 3856 */                     CECombatBehaviors.Behavior.builder()
/* 3857 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3858 */                     .withinDistance(0.0D, 5.0D)
/* 3859 */                     .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 3860 */                     .addNextBehavior(
/* 3861 */                       CECombatBehaviors.Behavior.builder()
/* 3862 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3863 */                       .withinDistance(0.0D, 5.0D)
/* 3864 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3874 */       .addFirstBehavior(
/* 3875 */         CECombatBehaviors.Behavior.builder()
/* 3876 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3877 */         .withinDistance(0.0D, 3.0D)
/* 3878 */         .animationBehavior(Animations.SPEAR_TWOHAND_AUTO2, 0.0F)
/* 3879 */         .addNextBehavior(
/* 3880 */           CECombatBehaviors.Behavior.builder()
/* 3881 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3882 */           .withinDistance(0.0D, 3.0D)
/* 3883 */           .animationBehavior(Animations.SPEAR_DASH, 0.0F)
/* 3884 */           .addNextBehavior(
/* 3885 */             CECombatBehaviors.Behavior.builder()
/* 3886 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3887 */             .withinDistance(0.0D, 4.0D)
/* 3888 */             .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 3889 */             .addNextBehavior(
/* 3890 */               CECombatBehaviors.Behavior.builder()
/* 3891 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3892 */               .withinDistance(0.0D, 4.0D)
/* 3893 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3894 */               .addNextBehavior(
/* 3895 */                 CECombatBehaviors.Behavior.builder()
/* 3896 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3897 */                 .withinDistance(0.0D, 5.0D)
/* 3898 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3899 */                 .addNextBehavior(
/* 3900 */                   CECombatBehaviors.Behavior.builder()
/* 3901 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3902 */                   .withinDistance(0.0D, 5.0D)
/* 3903 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3904 */                   .addNextBehavior(
/* 3905 */                     CECombatBehaviors.Behavior.builder()
/* 3906 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3907 */                     .withinDistance(0.0D, 5.0D)
/* 3908 */                     .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 3909 */                     .addNextBehavior(
/* 3910 */                       CECombatBehaviors.Behavior.builder()
/* 3911 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3912 */                       .withinDistance(0.0D, 5.0D)
/* 3913 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3923 */       .addFirstBehavior(
/* 3924 */         CECombatBehaviors.Behavior.builder()
/* 3925 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3926 */         .withinDistance(0.0D, 3.0D)
/* 3927 */         .animationBehavior(WOMAnimations.STAFF_AUTO_2, 0.0F)
/* 3928 */         .addNextBehavior(
/* 3929 */           CECombatBehaviors.Behavior.builder()
/* 3930 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3931 */           .withinDistance(0.0D, 3.0D)
/* 3932 */           .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F)
/* 3933 */           .addNextBehavior(
/* 3934 */             CECombatBehaviors.Behavior.builder()
/* 3935 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3936 */             .withinDistance(0.0D, 4.0D)
/* 3937 */             .animationBehavior(WOMAnimations.STAFF_AUTO_3, 0.0F)
/* 3938 */             .addNextBehavior(
/* 3939 */               CECombatBehaviors.Behavior.builder()
/* 3940 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3941 */               .withinDistance(0.0D, 4.0D)
/* 3942 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3943 */               .addNextBehavior(
/* 3944 */                 CECombatBehaviors.Behavior.builder()
/* 3945 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3946 */                 .withinDistance(0.0D, 5.0D)
/* 3947 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3948 */                 .addNextBehavior(
/* 3949 */                   CECombatBehaviors.Behavior.builder()
/* 3950 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3951 */                   .withinDistance(0.0D, 5.0D)
/* 3952 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3953 */                   .addNextBehavior(
/* 3954 */                     CECombatBehaviors.Behavior.builder()
/* 3955 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3956 */                     .withinDistance(0.0D, 5.0D)
/* 3957 */                     .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 3958 */                     .addNextBehavior(
/* 3959 */                       CECombatBehaviors.Behavior.builder()
/* 3960 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3961 */                       .withinDistance(0.0D, 5.0D)
/* 3962 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3972 */       .addFirstBehavior(
/* 3973 */         CECombatBehaviors.Behavior.builder()
/* 3974 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3975 */         .withinDistance(0.0D, 3.0D)
/* 3976 */         .animationBehavior(AnimsAgony.AGONY_AUTO_4, 0.0F)
/* 3977 */         .addNextBehavior(
/* 3978 */           CECombatBehaviors.Behavior.builder()
/* 3979 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3980 */           .withinDistance(0.0D, 3.0D)
/* 3981 */           .animationBehavior(Animations.GRASPING_SPIRAL_FIRST, 0.0F)
/* 3982 */           .addNextBehavior(
/* 3983 */             CECombatBehaviors.Behavior.builder()
/* 3984 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3985 */             .withinDistance(0.0D, 4.0D)
/* 3986 */             .animationBehavior(Animations.GRASPING_SPIRAL_SECOND, 0.0F)
/* 3987 */             .addNextBehavior(
/* 3988 */               CECombatBehaviors.Behavior.builder()
/* 3989 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3990 */               .withinDistance(0.0D, 4.0D)
/* 3991 */               .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3992 */               .addNextBehavior(
/* 3993 */                 CECombatBehaviors.Behavior.builder()
/* 3994 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 3995 */                 .withinDistance(0.0D, 5.0D)
/* 3996 */                 .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 3997 */                 .addNextBehavior(
/* 3998 */                   CECombatBehaviors.Behavior.builder()
/* 3999 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4000 */                   .withinDistance(0.0D, 5.0D)
/* 4001 */                   .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 4002 */                   .addNextBehavior(
/* 4003 */                     CECombatBehaviors.Behavior.builder()
/* 4004 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4005 */                     .withinDistance(0.0D, 5.0D)
/* 4006 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 4007 */                     .addNextBehavior(
/* 4008 */                       CECombatBehaviors.Behavior.builder()
/* 4009 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4010 */                       .withinDistance(0.0D, 5.0D)
/* 4011 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4021 */     .newBehaviorRoot(
/* 4022 */       CECombatBehaviors.BehaviorRoot.builder()
/* 4023 */       .priority(1.0D)
/* 4024 */       .weight(20.0D)
/* 4025 */       .maxCooldown(100)
/* 4026 */       .addFirstBehavior(
/* 4027 */         CECombatBehaviors.Behavior.builder()
/* 4028 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4029 */         .withinDistance(0.0D, 3.0D)
/* 4030 */         .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 4031 */         .addNextBehavior(
/* 4032 */           CECombatBehaviors.Behavior.builder()
/* 4033 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4034 */           .withinDistance(0.0D, 4.0D)
/* 4035 */           .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)
/* 4036 */           .addNextBehavior(
/* 4037 */             CECombatBehaviors.Behavior.builder()
/* 4038 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4039 */             .withinDistance(0.0D, 5.0D)
/* 4040 */             .animationBehavior(AVAnimations.SPEAR_THRUST, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4045 */     .newBehaviorRoot(
/* 4046 */       CECombatBehaviors.BehaviorRoot.builder()
/* 4047 */       .priority(1.0D)
/* 4048 */       .weight(10.0D)
/* 4049 */       .maxCooldown(100)
/* 4050 */       .addFirstBehavior(
/* 4051 */         CECombatBehaviors.Behavior.builder()
/* 4052 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4053 */         .withinDistance(0.0D, 3.0D)
/* 4054 */         .animationBehavior(Animations.SPEAR_DASH, 0.0F))
/*      */       
/* 4056 */       .addFirstBehavior(
/* 4057 */         CECombatBehaviors.Behavior.builder()
/* 4058 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4059 */         .withinDistance(0.0D, 3.0D)
/* 4060 */         .animationBehavior(Animations.SPEAR_TWOHAND_AIR_SLASH, 0.0F))
/*      */       
/* 4062 */       .addFirstBehavior(
/* 4063 */         CECombatBehaviors.Behavior.builder()
/* 4064 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4065 */         .withinDistance(0.0D, 3.0D)
/* 4066 */         .animationBehavior(Animations.GRASPING_SPIRAL_FIRST, 0.0F)
/* 4067 */         .addNextBehavior(
/* 4068 */           CECombatBehaviors.Behavior.builder()
/* 4069 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4070 */           .withinDistance(0.0D, 3.0D)
/* 4071 */           .animationBehavior(Animations.GRASPING_SPIRAL_SECOND, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/* 4075 */     .newBehaviorRoot(
/* 4076 */       CECombatBehaviors.BehaviorRoot.builder()
/* 4077 */       .priority(1.0D)
/* 4078 */       .weight(10.0D)
/* 4079 */       .maxCooldown(40)
/* 4080 */       .addFirstBehavior(
/* 4081 */         CECombatBehaviors.Behavior.builder()
/* 4082 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4083 */         .withinDistance(0.0D, 3.0D)
/* 4084 */         .custom(CombatCommon::canThrowEnderPearl)
/* 4085 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 4086 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 4089 */     .newBehaviorRoot(
/* 4090 */       CECombatBehaviors.BehaviorRoot.builder()
/* 4091 */       .priority(1.0D)
/* 4092 */       .weight(2.0D)
/* 4093 */       .maxCooldown(100)
/* 4094 */       .addFirstBehavior(
/* 4095 */         CECombatBehaviors.Behavior.builder()
/* 4096 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4097 */         .withinDistance(0.0D, 3.0D)
/* 4098 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 4100 */       .addFirstBehavior(
/* 4101 */         CECombatBehaviors.Behavior.builder()
/* 4102 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4103 */         .withinDistance(0.0D, 3.0D)
/* 4104 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 4106 */       .addFirstBehavior(
/* 4107 */         CECombatBehaviors.Behavior.builder()
/* 4108 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4109 */         .withinDistance(0.0D, 3.0D)
/* 4110 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 4112 */       .addFirstBehavior(
/* 4113 */         CECombatBehaviors.Behavior.builder()
/* 4114 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4115 */         .withinDistance(0.0D, 3.0D)
/* 4116 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 4118 */       .addFirstBehavior(
/* 4119 */         CECombatBehaviors.Behavior.builder()
/* 4120 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4121 */         .withinDistance(0.0D, 3.0D)
/* 4122 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 4124 */       .addFirstBehavior(
/* 4125 */         CECombatBehaviors.Behavior.builder()
/* 4126 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4127 */         .withinDistance(0.0D, 3.0D)
/* 4128 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 4130 */       .addFirstBehavior(
/* 4131 */         CECombatBehaviors.Behavior.builder()
/* 4132 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4133 */         .withinDistance(0.0D, 3.0D)
/* 4134 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 4137 */     .newBehaviorRoot(
/* 4138 */       CECombatBehaviors.BehaviorRoot.builder()
/* 4139 */       .priority(1.0D)
/* 4140 */       .weight(15.0D)
/* 4141 */       .addFirstBehavior(
/* 4142 */         CECombatBehaviors.Behavior.builder()
/* 4143 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4144 */         .withinDistance(0.0D, 3.0D)
/* 4145 */         .custom(CombatCommon::canPerformGuarding)
/* 4146 */         .guard(40)))
/*      */ 
/*      */     
/* 4149 */     .newBehaviorRoot(
/* 4150 */       CECombatBehaviors.BehaviorRoot.builder()
/* 4151 */       .priority(1.0D)
/* 4152 */       .weight(10.0D)
/* 4153 */       .addFirstBehavior(
/* 4154 */         CECombatBehaviors.Behavior.builder()
/* 4155 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4156 */         .withinDistance(0.0D, 3.0D)
/* 4157 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 4159 */       .addFirstBehavior(
/* 4160 */         CECombatBehaviors.Behavior.builder()
/* 4161 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4162 */         .withinDistance(0.0D, 3.0D)
/* 4163 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 4166 */     .newBehaviorRoot(
/* 4167 */       CECombatBehaviors.BehaviorRoot.builder()
/* 4168 */       .priority(1.0D)
/* 4169 */       .weight(40.0D)
/* 4170 */       .maxCooldown(160)
/* 4171 */       .addFirstBehavior(
/* 4172 */         CECombatBehaviors.Behavior.builder()
/* 4173 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 4174 */         .custom(CombatCommon::canJump)
/* 4175 */         .withinDistance(5.0D, 14.0D)
/* 4176 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 4177 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcSpear.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */