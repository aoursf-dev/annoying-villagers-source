/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.efkick.gameasset.EFKickAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PlayerNpcGreatsword
/*      */ {
/*   16 */   public static final CECombatBehaviors.Builder<MobPatch<?>> GREATSWORD = CECombatBehaviors.builder()
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
/*  107 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  108 */         .addNextBehavior(
/*  109 */           CECombatBehaviors.Behavior.builder()
/*  110 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  111 */           .withinDistance(0.0D, 3.0D)
/*  112 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)))
/*      */ 
/*      */       
/*  115 */       .addFirstBehavior(
/*  116 */         CECombatBehaviors.Behavior.builder()
/*  117 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  118 */         .withinDistance(0.0D, 3.0D)
/*  119 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  120 */         .addNextBehavior(
/*  121 */           CECombatBehaviors.Behavior.builder()
/*  122 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  123 */           .withinDistance(0.0D, 3.0D)
/*  124 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/*  125 */           .addNextBehavior(
/*  126 */             CECombatBehaviors.Behavior.builder()
/*  127 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  128 */             .withinDistance(0.0D, 4.0D)
/*  129 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  130 */             .addNextBehavior(
/*  131 */               CECombatBehaviors.Behavior.builder()
/*  132 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  133 */               .withinDistance(0.0D, 4.0D)
/*  134 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  135 */               .addNextBehavior(
/*  136 */                 CECombatBehaviors.Behavior.builder()
/*  137 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  138 */                 .withinDistance(0.0D, 5.0D)
/*  139 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  146 */       .addFirstBehavior(
/*  147 */         CECombatBehaviors.Behavior.builder()
/*  148 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  149 */         .withinDistance(0.0D, 3.0D)
/*  150 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  151 */         .addNextBehavior(
/*  152 */           CECombatBehaviors.Behavior.builder()
/*  153 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  154 */           .withinDistance(0.0D, 3.0D)
/*  155 */           .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F)
/*  156 */           .addNextBehavior(
/*  157 */             CECombatBehaviors.Behavior.builder()
/*  158 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  159 */             .withinDistance(0.0D, 4.0D)
/*  160 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  161 */             .addNextBehavior(
/*  162 */               CECombatBehaviors.Behavior.builder()
/*  163 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  164 */               .withinDistance(0.0D, 4.0D)
/*  165 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  166 */               .addNextBehavior(
/*  167 */                 CECombatBehaviors.Behavior.builder()
/*  168 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  169 */                 .withinDistance(0.0D, 5.0D)
/*  170 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  177 */       .addFirstBehavior(
/*  178 */         CECombatBehaviors.Behavior.builder()
/*  179 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  180 */         .withinDistance(0.0D, 3.0D)
/*  181 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  182 */         .addNextBehavior(
/*  183 */           CECombatBehaviors.Behavior.builder()
/*  184 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  185 */           .withinDistance(0.0D, 3.0D)
/*  186 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/*  187 */           .addNextBehavior(
/*  188 */             CECombatBehaviors.Behavior.builder()
/*  189 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  190 */             .withinDistance(0.0D, 4.0D)
/*  191 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  192 */             .addNextBehavior(
/*  193 */               CECombatBehaviors.Behavior.builder()
/*  194 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  195 */               .withinDistance(0.0D, 4.0D)
/*  196 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  197 */               .addNextBehavior(
/*  198 */                 CECombatBehaviors.Behavior.builder()
/*  199 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  200 */                 .withinDistance(0.0D, 5.0D)
/*  201 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  208 */       .addFirstBehavior(
/*  209 */         CECombatBehaviors.Behavior.builder()
/*  210 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  211 */         .withinDistance(0.0D, 3.0D)
/*  212 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  213 */         .addNextBehavior(
/*  214 */           CECombatBehaviors.Behavior.builder()
/*  215 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  216 */           .withinDistance(0.0D, 3.0D)
/*  217 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/*  218 */           .addNextBehavior(
/*  219 */             CECombatBehaviors.Behavior.builder()
/*  220 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  221 */             .withinDistance(0.0D, 4.0D)
/*  222 */             .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  223 */             .addNextBehavior(
/*  224 */               CECombatBehaviors.Behavior.builder()
/*  225 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  226 */               .withinDistance(0.0D, 4.0D)
/*  227 */               .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  228 */               .addNextBehavior(
/*  229 */                 CECombatBehaviors.Behavior.builder()
/*  230 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  231 */                 .withinDistance(0.0D, 5.0D)
/*  232 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  239 */       .addFirstBehavior(
/*  240 */         CECombatBehaviors.Behavior.builder()
/*  241 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  242 */         .withinDistance(0.0D, 3.0D)
/*  243 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  244 */         .addNextBehavior(
/*  245 */           CECombatBehaviors.Behavior.builder()
/*  246 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  247 */           .withinDistance(0.0D, 3.0D)
/*  248 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  249 */           .addNextBehavior(
/*  250 */             CECombatBehaviors.Behavior.builder()
/*  251 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  252 */             .withinDistance(0.0D, 4.0D)
/*  253 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  254 */             .addNextBehavior(
/*  255 */               CECombatBehaviors.Behavior.builder()
/*  256 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  257 */               .withinDistance(0.0D, 4.0D)
/*  258 */               .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F)
/*  259 */               .addNextBehavior(
/*  260 */                 CECombatBehaviors.Behavior.builder()
/*  261 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  262 */                 .withinDistance(0.0D, 5.0D)
/*  263 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  270 */       .addFirstBehavior(
/*  271 */         CECombatBehaviors.Behavior.builder()
/*  272 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  273 */         .withinDistance(0.0D, 3.0D)
/*  274 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  275 */         .addNextBehavior(
/*  276 */           CECombatBehaviors.Behavior.builder()
/*  277 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  278 */           .withinDistance(0.0D, 3.0D)
/*  279 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/*  280 */           .addNextBehavior(
/*  281 */             CECombatBehaviors.Behavior.builder()
/*  282 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  283 */             .withinDistance(0.0D, 4.0D)
/*  284 */             .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  285 */             .addNextBehavior(
/*  286 */               CECombatBehaviors.Behavior.builder()
/*  287 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  288 */               .withinDistance(0.0D, 4.0D)
/*  289 */               .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  290 */               .addNextBehavior(
/*  291 */                 CECombatBehaviors.Behavior.builder()
/*  292 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  293 */                 .withinDistance(0.0D, 5.0D)
/*  294 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  301 */       .addFirstBehavior(
/*  302 */         CECombatBehaviors.Behavior.builder()
/*  303 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  304 */         .withinDistance(0.0D, 3.0D)
/*  305 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  306 */         .addNextBehavior(
/*  307 */           CECombatBehaviors.Behavior.builder()
/*  308 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  309 */           .withinDistance(0.0D, 3.0D)
/*  310 */           .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F)
/*  311 */           .addNextBehavior(
/*  312 */             CECombatBehaviors.Behavior.builder()
/*  313 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  314 */             .withinDistance(0.0D, 4.0D)
/*  315 */             .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  316 */             .addNextBehavior(
/*  317 */               CECombatBehaviors.Behavior.builder()
/*  318 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  319 */               .withinDistance(0.0D, 4.0D)
/*  320 */               .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  321 */               .addNextBehavior(
/*  322 */                 CECombatBehaviors.Behavior.builder()
/*  323 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  324 */                 .withinDistance(0.0D, 5.0D)
/*  325 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  332 */       .addFirstBehavior(
/*  333 */         CECombatBehaviors.Behavior.builder()
/*  334 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  335 */         .withinDistance(0.0D, 3.0D)
/*  336 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  337 */         .addNextBehavior(
/*  338 */           CECombatBehaviors.Behavior.builder()
/*  339 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  340 */           .withinDistance(0.0D, 3.0D)
/*  341 */           .animationBehavior(Animations.STEEL_WHIRLWIND_CHARGING, 0.0F)
/*  342 */           .addNextBehavior(
/*  343 */             CECombatBehaviors.Behavior.builder()
/*  344 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  345 */             .withinDistance(0.0D, 4.0D)
/*  346 */             .animationBehavior(Animations.STEEL_WHIRLWIND, 0.0F)
/*  347 */             .addNextBehavior(
/*  348 */               CECombatBehaviors.Behavior.builder()
/*  349 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  350 */               .withinDistance(0.0D, 4.0D)
/*  351 */               .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  352 */               .addNextBehavior(
/*  353 */                 CECombatBehaviors.Behavior.builder()
/*  354 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  355 */                 .withinDistance(0.0D, 5.0D)
/*  356 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  357 */                 .addNextBehavior(
/*  358 */                   CECombatBehaviors.Behavior.builder()
/*  359 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  360 */                   .withinDistance(0.0D, 5.0D)
/*  361 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  369 */       .addFirstBehavior(
/*  370 */         CECombatBehaviors.Behavior.builder()
/*  371 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  372 */         .withinDistance(0.0D, 3.0D)
/*  373 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  374 */         .addNextBehavior(
/*  375 */           CECombatBehaviors.Behavior.builder()
/*  376 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  377 */           .withinDistance(0.0D, 3.0D)
/*  378 */           .animationBehavior(Animations.STEEL_WHIRLWIND_CHARGING, 0.0F)
/*  379 */           .addNextBehavior(
/*  380 */             CECombatBehaviors.Behavior.builder()
/*  381 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  382 */             .withinDistance(0.0D, 4.0D)
/*  383 */             .animationBehavior(Animations.STEEL_WHIRLWIND, 0.0F)
/*  384 */             .addNextBehavior(
/*  385 */               CECombatBehaviors.Behavior.builder()
/*  386 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  387 */               .withinDistance(0.0D, 4.0D)
/*  388 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  389 */               .addNextBehavior(
/*  390 */                 CECombatBehaviors.Behavior.builder()
/*  391 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  392 */                 .withinDistance(0.0D, 5.0D)
/*  393 */                 .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  394 */                 .addNextBehavior(
/*  395 */                   CECombatBehaviors.Behavior.builder()
/*  396 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  397 */                   .withinDistance(0.0D, 5.0D)
/*  398 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  406 */       .addFirstBehavior(
/*  407 */         CECombatBehaviors.Behavior.builder()
/*  408 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  409 */         .withinDistance(0.0D, 3.0D)
/*  410 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  411 */         .addNextBehavior(
/*  412 */           CECombatBehaviors.Behavior.builder()
/*  413 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  414 */           .withinDistance(0.0D, 3.0D)
/*  415 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/*  416 */           .addNextBehavior(
/*  417 */             CECombatBehaviors.Behavior.builder()
/*  418 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  419 */             .withinDistance(0.0D, 4.0D)
/*  420 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  421 */             .addNextBehavior(
/*  422 */               CECombatBehaviors.Behavior.builder()
/*  423 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  424 */               .withinDistance(0.0D, 4.0D)
/*  425 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  426 */               .addNextBehavior(
/*  427 */                 CECombatBehaviors.Behavior.builder()
/*  428 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  429 */                 .withinDistance(0.0D, 5.0D)
/*  430 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  437 */       .addFirstBehavior(
/*  438 */         CECombatBehaviors.Behavior.builder()
/*  439 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  440 */         .withinDistance(0.0D, 3.0D)
/*  441 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  442 */         .addNextBehavior(
/*  443 */           CECombatBehaviors.Behavior.builder()
/*  444 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  445 */           .withinDistance(0.0D, 3.0D)
/*  446 */           .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  447 */           .addNextBehavior(
/*  448 */             CECombatBehaviors.Behavior.builder()
/*  449 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  450 */             .withinDistance(0.0D, 4.0D)
/*  451 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  452 */             .addNextBehavior(
/*  453 */               CECombatBehaviors.Behavior.builder()
/*  454 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  455 */               .withinDistance(0.0D, 4.0D)
/*  456 */               .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/*  457 */               .addNextBehavior(
/*  458 */                 CECombatBehaviors.Behavior.builder()
/*  459 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  460 */                 .withinDistance(0.0D, 5.0D)
/*  461 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  468 */       .addFirstBehavior(
/*  469 */         CECombatBehaviors.Behavior.builder()
/*  470 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  471 */         .withinDistance(0.0D, 3.0D)
/*  472 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  473 */         .addNextBehavior(
/*  474 */           CECombatBehaviors.Behavior.builder()
/*  475 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  476 */           .withinDistance(0.0D, 3.0D)
/*  477 */           .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F)
/*  478 */           .addNextBehavior(
/*  479 */             CECombatBehaviors.Behavior.builder()
/*  480 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  481 */             .withinDistance(0.0D, 4.0D)
/*  482 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  483 */             .addNextBehavior(
/*  484 */               CECombatBehaviors.Behavior.builder()
/*  485 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */               .withinDistance(0.0D, 4.0D)
/*  487 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  488 */               .addNextBehavior(
/*  489 */                 CECombatBehaviors.Behavior.builder()
/*  490 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  491 */                 .withinDistance(0.0D, 5.0D)
/*  492 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  499 */       .addFirstBehavior(
/*  500 */         CECombatBehaviors.Behavior.builder()
/*  501 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  502 */         .withinDistance(0.0D, 3.0D)
/*  503 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  504 */         .addNextBehavior(
/*  505 */           CECombatBehaviors.Behavior.builder()
/*  506 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  507 */           .withinDistance(0.0D, 3.0D)
/*  508 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/*  509 */           .addNextBehavior(
/*  510 */             CECombatBehaviors.Behavior.builder()
/*  511 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  512 */             .withinDistance(0.0D, 4.0D)
/*  513 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  514 */             .addNextBehavior(
/*  515 */               CECombatBehaviors.Behavior.builder()
/*  516 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  517 */               .withinDistance(0.0D, 4.0D)
/*  518 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  519 */               .addNextBehavior(
/*  520 */                 CECombatBehaviors.Behavior.builder()
/*  521 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  522 */                 .withinDistance(0.0D, 5.0D)
/*  523 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  530 */       .addFirstBehavior(
/*  531 */         CECombatBehaviors.Behavior.builder()
/*  532 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  533 */         .withinDistance(0.0D, 3.0D)
/*  534 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  535 */         .addNextBehavior(
/*  536 */           CECombatBehaviors.Behavior.builder()
/*  537 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  538 */           .withinDistance(0.0D, 3.0D)
/*  539 */           .animationBehavior(Animations.STEEL_WHIRLWIND_CHARGING, 0.0F)
/*  540 */           .addNextBehavior(
/*  541 */             CECombatBehaviors.Behavior.builder()
/*  542 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  543 */             .withinDistance(0.0D, 4.0D)
/*  544 */             .animationBehavior(Animations.STEEL_WHIRLWIND, 0.0F)
/*  545 */             .addNextBehavior(
/*  546 */               CECombatBehaviors.Behavior.builder()
/*  547 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  548 */               .withinDistance(0.0D, 4.0D)
/*  549 */               .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  550 */               .addNextBehavior(
/*  551 */                 CECombatBehaviors.Behavior.builder()
/*  552 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  553 */                 .withinDistance(0.0D, 5.0D)
/*  554 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  555 */                 .addNextBehavior(
/*  556 */                   CECombatBehaviors.Behavior.builder()
/*  557 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  558 */                   .withinDistance(0.0D, 5.0D)
/*  559 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  567 */       .addFirstBehavior(
/*  568 */         CECombatBehaviors.Behavior.builder()
/*  569 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  570 */         .withinDistance(0.0D, 3.0D)
/*  571 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  572 */         .addNextBehavior(
/*  573 */           CECombatBehaviors.Behavior.builder()
/*  574 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  575 */           .withinDistance(0.0D, 3.0D)
/*  576 */           .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  577 */           .addNextBehavior(
/*  578 */             CECombatBehaviors.Behavior.builder()
/*  579 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  580 */             .withinDistance(0.0D, 4.0D)
/*  581 */             .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/*  582 */             .addNextBehavior(
/*  583 */               CECombatBehaviors.Behavior.builder()
/*  584 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  585 */               .withinDistance(0.0D, 4.0D)
/*  586 */               .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  587 */               .addNextBehavior(
/*  588 */                 CECombatBehaviors.Behavior.builder()
/*  589 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  590 */                 .withinDistance(0.0D, 5.0D)
/*  591 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  599 */     .newBehaviorRoot(
/*  600 */       CECombatBehaviors.BehaviorRoot.builder()
/*  601 */       .priority(1.0D)
/*  602 */       .weight(20.0D)
/*  603 */       .maxCooldown(100)
/*  604 */       .addFirstBehavior(
/*  605 */         CECombatBehaviors.Behavior.builder()
/*  606 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  607 */         .withinDistance(0.0D, 3.0D)
/*  608 */         .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)))
/*      */ 
/*      */     
/*  611 */     .newBehaviorRoot(
/*  612 */       CECombatBehaviors.BehaviorRoot.builder()
/*  613 */       .priority(1.0D)
/*  614 */       .weight(10.0D)
/*  615 */       .maxCooldown(100)
/*  616 */       .addFirstBehavior(
/*  617 */         CECombatBehaviors.Behavior.builder()
/*  618 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  619 */         .withinDistance(0.0D, 3.0D)
/*  620 */         .animationBehavior(Animations.GREATSWORD_DASH, 0.0F))
/*      */       
/*  622 */       .addFirstBehavior(
/*  623 */         CECombatBehaviors.Behavior.builder()
/*  624 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  625 */         .withinDistance(0.0D, 3.0D)
/*  626 */         .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F))
/*      */       
/*  628 */       .addFirstBehavior(
/*  629 */         CECombatBehaviors.Behavior.builder()
/*  630 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  631 */         .withinDistance(0.0D, 3.0D)
/*  632 */         .animationBehavior(Animations.STEEL_WHIRLWIND_CHARGING, 0.0F)
/*  633 */         .addNextBehavior(
/*  634 */           CECombatBehaviors.Behavior.builder()
/*  635 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  636 */           .withinDistance(0.0D, 3.0D)
/*  637 */           .animationBehavior(Animations.STEEL_WHIRLWIND, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/*  641 */     .newBehaviorRoot(
/*  642 */       CECombatBehaviors.BehaviorRoot.builder()
/*  643 */       .priority(1.0D)
/*  644 */       .weight(10.0D)
/*  645 */       .maxCooldown(40)
/*  646 */       .addFirstBehavior(
/*  647 */         CECombatBehaviors.Behavior.builder()
/*  648 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  649 */         .withinDistance(0.0D, 3.0D)
/*  650 */         .custom(CombatCommon::canThrowEnderPearl)
/*  651 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  652 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  655 */     .newBehaviorRoot(
/*  656 */       CECombatBehaviors.BehaviorRoot.builder()
/*  657 */       .priority(1.0D)
/*  658 */       .weight(2.0D)
/*  659 */       .maxCooldown(100)
/*  660 */       .addFirstBehavior(
/*  661 */         CECombatBehaviors.Behavior.builder()
/*  662 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  663 */         .withinDistance(0.0D, 3.0D)
/*  664 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  666 */       .addFirstBehavior(
/*  667 */         CECombatBehaviors.Behavior.builder()
/*  668 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  669 */         .withinDistance(0.0D, 3.0D)
/*  670 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  672 */       .addFirstBehavior(
/*  673 */         CECombatBehaviors.Behavior.builder()
/*  674 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  675 */         .withinDistance(0.0D, 3.0D)
/*  676 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  678 */       .addFirstBehavior(
/*  679 */         CECombatBehaviors.Behavior.builder()
/*  680 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  681 */         .withinDistance(0.0D, 3.0D)
/*  682 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  684 */       .addFirstBehavior(
/*  685 */         CECombatBehaviors.Behavior.builder()
/*  686 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  687 */         .withinDistance(0.0D, 3.0D)
/*  688 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  690 */       .addFirstBehavior(
/*  691 */         CECombatBehaviors.Behavior.builder()
/*  692 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  693 */         .withinDistance(0.0D, 3.0D)
/*  694 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  696 */       .addFirstBehavior(
/*  697 */         CECombatBehaviors.Behavior.builder()
/*  698 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  699 */         .withinDistance(0.0D, 3.0D)
/*  700 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  703 */     .newBehaviorRoot(
/*  704 */       CECombatBehaviors.BehaviorRoot.builder()
/*  705 */       .priority(1.0D)
/*  706 */       .weight(15.0D)
/*  707 */       .addFirstBehavior(
/*  708 */         CECombatBehaviors.Behavior.builder()
/*  709 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  710 */         .withinDistance(0.0D, 3.0D)
/*  711 */         .custom(CombatCommon::canPerformGuarding)
/*  712 */         .guard(40)))
/*      */ 
/*      */     
/*  715 */     .newBehaviorRoot(
/*  716 */       CECombatBehaviors.BehaviorRoot.builder()
/*  717 */       .priority(1.0D)
/*  718 */       .weight(10.0D)
/*  719 */       .addFirstBehavior(
/*  720 */         CECombatBehaviors.Behavior.builder()
/*  721 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  722 */         .withinDistance(0.0D, 3.0D)
/*  723 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/*  725 */       .addFirstBehavior(
/*  726 */         CECombatBehaviors.Behavior.builder()
/*  727 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  728 */         .withinDistance(0.0D, 3.0D)
/*  729 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/*  732 */     .newBehaviorRoot(
/*  733 */       CECombatBehaviors.BehaviorRoot.builder()
/*  734 */       .priority(1.0D)
/*  735 */       .weight(40.0D)
/*  736 */       .maxCooldown(160)
/*  737 */       .addFirstBehavior(
/*  738 */         CECombatBehaviors.Behavior.builder()
/*  739 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  740 */         .custom(CombatCommon::canJump)
/*  741 */         .withinDistance(5.0D, 14.0D)
/*  742 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/*  743 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/*  747 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_GREATSWORD = CECombatBehaviors.builder()
/*  748 */     .newBehaviorRoot(
/*  749 */       CECombatBehaviors.BehaviorRoot.builder()
/*  750 */       .priority(4.0D)
/*  751 */       .weight(1000.0D)
/*  752 */       .maxCooldown(0)
/*  753 */       .addFirstBehavior(
/*  754 */         CECombatBehaviors.Behavior.builder()
/*  755 */         .custom(CombatCommon::canExecute)
/*  756 */         .withinDistance(0.0D, 5.0D)
/*  757 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  758 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  761 */     .newBehaviorRoot(
/*  762 */       CECombatBehaviors.BehaviorRoot.builder()
/*  763 */       .priority(3.0D)
/*  764 */       .weight(1000.0D)
/*  765 */       .maxCooldown(0)
/*  766 */       .addFirstBehavior(
/*  767 */         CECombatBehaviors.Behavior.builder()
/*  768 */         .custom(CombatCommon::canEscape)
/*  769 */         .withinDistance(0.0D, 8.0D)
/*  770 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  771 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  773 */       .addFirstBehavior(
/*  774 */         CECombatBehaviors.Behavior.builder()
/*  775 */         .custom(CombatCommon::canEscape)
/*  776 */         .withinDistance(0.0D, 48.0D)
/*  777 */         .guard(40)))
/*      */ 
/*      */     
/*  780 */     .newBehaviorRoot(
/*  781 */       CECombatBehaviors.BehaviorRoot.builder()
/*  782 */       .priority(2.0D)
/*  783 */       .weight(70.0D)
/*  784 */       .maxCooldown(0)
/*  785 */       .addFirstBehavior(
/*  786 */         CECombatBehaviors.Behavior.builder()
/*  787 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  788 */         .custom(CombatCommon::canPerformEating)
/*  789 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  790 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  793 */     .newBehaviorRoot(
/*  794 */       CECombatBehaviors.BehaviorRoot.builder()
/*  795 */       .priority(2.0D)
/*  796 */       .weight(100.0D)
/*  797 */       .maxCooldown(120)
/*  798 */       .addFirstBehavior(
/*  799 */         CECombatBehaviors.Behavior.builder()
/*  800 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  801 */         .custom(CombatCommon::canSwapToBow)
/*  802 */         .withinDistance(7.0D, 14.0D)
/*  803 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  804 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  806 */       .addFirstBehavior(
/*  807 */         CECombatBehaviors.Behavior.builder()
/*  808 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  809 */         .custom(CombatCommon::canSwapToBow)
/*  810 */         .withinDistance(7.0D, 14.0D)
/*  811 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  812 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  815 */     .newBehaviorRoot(
/*  816 */       CECombatBehaviors.BehaviorRoot.builder()
/*  817 */       .priority(2.0D)
/*  818 */       .weight(80.0D)
/*  819 */       .maxCooldown(120)
/*  820 */       .addFirstBehavior(
/*  821 */         CECombatBehaviors.Behavior.builder()
/*  822 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  823 */         .custom(CombatCommon::canThrowEnderPearl)
/*  824 */         .withinDistance(7.0D, 48.0D)
/*  825 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  826 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  829 */     .newBehaviorRoot(
/*  830 */       CECombatBehaviors.BehaviorRoot.builder()
/*  831 */       .priority(1.0D)
/*  832 */       .weight(40.0D)
/*  833 */       .maxCooldown(20)
/*  834 */       .addFirstBehavior(
/*  835 */         CECombatBehaviors.Behavior.builder()
/*  836 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  837 */         .withinDistance(0.0D, 3.0D)
/*  838 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  839 */         .addNextBehavior(
/*  840 */           CECombatBehaviors.Behavior.builder()
/*  841 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  842 */           .withinDistance(0.0D, 3.0D)
/*  843 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  844 */           .addNextBehavior(
/*  845 */             CECombatBehaviors.Behavior.builder()
/*  846 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  847 */             .withinDistance(0.0D, 3.0D)
/*  848 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  849 */             .addNextBehavior(
/*  850 */               CECombatBehaviors.Behavior.builder()
/*  851 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  852 */               .withinDistance(0.0D, 3.0D)
/*  853 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  854 */               .addNextBehavior(
/*  855 */                 CECombatBehaviors.Behavior.builder()
/*  856 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  857 */                 .withinDistance(0.0D, 3.0D)
/*  858 */                 .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  864 */       .addFirstBehavior(
/*  865 */         CECombatBehaviors.Behavior.builder()
/*  866 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  867 */         .withinDistance(0.0D, 3.0D)
/*  868 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  869 */         .addNextBehavior(
/*  870 */           CECombatBehaviors.Behavior.builder()
/*  871 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  872 */           .withinDistance(0.0D, 3.0D)
/*  873 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/*  874 */           .addNextBehavior(
/*  875 */             CECombatBehaviors.Behavior.builder()
/*  876 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  877 */             .withinDistance(0.0D, 4.0D)
/*  878 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  879 */             .addNextBehavior(
/*  880 */               CECombatBehaviors.Behavior.builder()
/*  881 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  882 */               .withinDistance(0.0D, 4.0D)
/*  883 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  884 */               .addNextBehavior(
/*  885 */                 CECombatBehaviors.Behavior.builder()
/*  886 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  887 */                 .withinDistance(0.0D, 5.0D)
/*  888 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  895 */       .addFirstBehavior(
/*  896 */         CECombatBehaviors.Behavior.builder()
/*  897 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  898 */         .withinDistance(0.0D, 3.0D)
/*  899 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  900 */         .addNextBehavior(
/*  901 */           CECombatBehaviors.Behavior.builder()
/*  902 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  903 */           .withinDistance(0.0D, 3.0D)
/*  904 */           .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F)
/*  905 */           .addNextBehavior(
/*  906 */             CECombatBehaviors.Behavior.builder()
/*  907 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  908 */             .withinDistance(0.0D, 4.0D)
/*  909 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  910 */             .addNextBehavior(
/*  911 */               CECombatBehaviors.Behavior.builder()
/*  912 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  913 */               .withinDistance(0.0D, 4.0D)
/*  914 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  915 */               .addNextBehavior(
/*  916 */                 CECombatBehaviors.Behavior.builder()
/*  917 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  918 */                 .withinDistance(0.0D, 5.0D)
/*  919 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  926 */       .addFirstBehavior(
/*  927 */         CECombatBehaviors.Behavior.builder()
/*  928 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  929 */         .withinDistance(0.0D, 3.0D)
/*  930 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  931 */         .addNextBehavior(
/*  932 */           CECombatBehaviors.Behavior.builder()
/*  933 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  934 */           .withinDistance(0.0D, 3.0D)
/*  935 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/*  936 */           .addNextBehavior(
/*  937 */             CECombatBehaviors.Behavior.builder()
/*  938 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  939 */             .withinDistance(0.0D, 4.0D)
/*  940 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  941 */             .addNextBehavior(
/*  942 */               CECombatBehaviors.Behavior.builder()
/*  943 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  944 */               .withinDistance(0.0D, 4.0D)
/*  945 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  946 */               .addNextBehavior(
/*  947 */                 CECombatBehaviors.Behavior.builder()
/*  948 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  949 */                 .withinDistance(0.0D, 5.0D)
/*  950 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  957 */       .addFirstBehavior(
/*  958 */         CECombatBehaviors.Behavior.builder()
/*  959 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  960 */         .withinDistance(0.0D, 3.0D)
/*  961 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  962 */         .addNextBehavior(
/*  963 */           CECombatBehaviors.Behavior.builder()
/*  964 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  965 */           .withinDistance(0.0D, 3.0D)
/*  966 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/*  967 */           .addNextBehavior(
/*  968 */             CECombatBehaviors.Behavior.builder()
/*  969 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  970 */             .withinDistance(0.0D, 4.0D)
/*  971 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  972 */             .addNextBehavior(
/*  973 */               CECombatBehaviors.Behavior.builder()
/*  974 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  975 */               .withinDistance(0.0D, 4.0D)
/*  976 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  977 */               .addNextBehavior(
/*  978 */                 CECombatBehaviors.Behavior.builder()
/*  979 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  980 */                 .withinDistance(0.0D, 5.0D)
/*  981 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  988 */       .addFirstBehavior(
/*  989 */         CECombatBehaviors.Behavior.builder()
/*  990 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  991 */         .withinDistance(0.0D, 3.0D)
/*  992 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  993 */         .addNextBehavior(
/*  994 */           CECombatBehaviors.Behavior.builder()
/*  995 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  996 */           .withinDistance(0.0D, 3.0D)
/*  997 */           .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F)
/*  998 */           .addNextBehavior(
/*  999 */             CECombatBehaviors.Behavior.builder()
/* 1000 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1001 */             .withinDistance(0.0D, 4.0D)
/* 1002 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1003 */             .addNextBehavior(
/* 1004 */               CECombatBehaviors.Behavior.builder()
/* 1005 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1006 */               .withinDistance(0.0D, 4.0D)
/* 1007 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1008 */               .addNextBehavior(
/* 1009 */                 CECombatBehaviors.Behavior.builder()
/* 1010 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1011 */                 .withinDistance(0.0D, 5.0D)
/* 1012 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1019 */       .addFirstBehavior(
/* 1020 */         CECombatBehaviors.Behavior.builder()
/* 1021 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1022 */         .withinDistance(0.0D, 3.0D)
/* 1023 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1024 */         .addNextBehavior(
/* 1025 */           CECombatBehaviors.Behavior.builder()
/* 1026 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1027 */           .withinDistance(0.0D, 3.0D)
/* 1028 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 1029 */           .addNextBehavior(
/* 1030 */             CECombatBehaviors.Behavior.builder()
/* 1031 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1032 */             .withinDistance(0.0D, 4.0D)
/* 1033 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1034 */             .addNextBehavior(
/* 1035 */               CECombatBehaviors.Behavior.builder()
/* 1036 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1037 */               .withinDistance(0.0D, 4.0D)
/* 1038 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1039 */               .addNextBehavior(
/* 1040 */                 CECombatBehaviors.Behavior.builder()
/* 1041 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1042 */                 .withinDistance(0.0D, 5.0D)
/* 1043 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1050 */       .addFirstBehavior(
/* 1051 */         CECombatBehaviors.Behavior.builder()
/* 1052 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1053 */         .withinDistance(0.0D, 3.0D)
/* 1054 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1055 */         .addNextBehavior(
/* 1056 */           CECombatBehaviors.Behavior.builder()
/* 1057 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1058 */           .withinDistance(0.0D, 3.0D)
/* 1059 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 1060 */           .addNextBehavior(
/* 1061 */             CECombatBehaviors.Behavior.builder()
/* 1062 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1063 */             .withinDistance(0.0D, 4.0D)
/* 1064 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 1065 */             .addNextBehavior(
/* 1066 */               CECombatBehaviors.Behavior.builder()
/* 1067 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1068 */               .withinDistance(0.0D, 4.0D)
/* 1069 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1070 */               .addNextBehavior(
/* 1071 */                 CECombatBehaviors.Behavior.builder()
/* 1072 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1073 */                 .withinDistance(0.0D, 5.0D)
/* 1074 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1075 */                 .addNextBehavior(
/* 1076 */                   CECombatBehaviors.Behavior.builder()
/* 1077 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1078 */                   .withinDistance(0.0D, 5.0D)
/* 1079 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1087 */       .addFirstBehavior(
/* 1088 */         CECombatBehaviors.Behavior.builder()
/* 1089 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1090 */         .withinDistance(0.0D, 3.0D)
/* 1091 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1092 */         .addNextBehavior(
/* 1093 */           CECombatBehaviors.Behavior.builder()
/* 1094 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1095 */           .withinDistance(0.0D, 3.0D)
/* 1096 */           .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F)
/* 1097 */           .addNextBehavior(
/* 1098 */             CECombatBehaviors.Behavior.builder()
/* 1099 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1100 */             .withinDistance(0.0D, 4.0D)
/* 1101 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 1102 */             .addNextBehavior(
/* 1103 */               CECombatBehaviors.Behavior.builder()
/* 1104 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1105 */               .withinDistance(0.0D, 4.0D)
/* 1106 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1107 */               .addNextBehavior(
/* 1108 */                 CECombatBehaviors.Behavior.builder()
/* 1109 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1110 */                 .withinDistance(0.0D, 5.0D)
/* 1111 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 1112 */                 .addNextBehavior(
/* 1113 */                   CECombatBehaviors.Behavior.builder()
/* 1114 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1115 */                   .withinDistance(0.0D, 5.0D)
/* 1116 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1124 */       .addFirstBehavior(
/* 1125 */         CECombatBehaviors.Behavior.builder()
/* 1126 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1127 */         .withinDistance(0.0D, 3.0D)
/* 1128 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1129 */         .addNextBehavior(
/* 1130 */           CECombatBehaviors.Behavior.builder()
/* 1131 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1132 */           .withinDistance(0.0D, 3.0D)
/* 1133 */           .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)
/* 1134 */           .addNextBehavior(
/* 1135 */             CECombatBehaviors.Behavior.builder()
/* 1136 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1137 */             .withinDistance(0.0D, 4.0D)
/* 1138 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1139 */             .addNextBehavior(
/* 1140 */               CECombatBehaviors.Behavior.builder()
/* 1141 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1142 */               .withinDistance(0.0D, 4.0D)
/* 1143 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1144 */               .addNextBehavior(
/* 1145 */                 CECombatBehaviors.Behavior.builder()
/* 1146 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1147 */                 .withinDistance(0.0D, 5.0D)
/* 1148 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 1149 */                 .addNextBehavior(
/* 1150 */                   CECombatBehaviors.Behavior.builder()
/* 1151 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1152 */                   .withinDistance(0.0D, 5.0D)
/* 1153 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1161 */       .addFirstBehavior(
/* 1162 */         CECombatBehaviors.Behavior.builder()
/* 1163 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1164 */         .withinDistance(0.0D, 3.0D)
/* 1165 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 1166 */         .addNextBehavior(
/* 1167 */           CECombatBehaviors.Behavior.builder()
/* 1168 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1169 */           .withinDistance(0.0D, 3.0D)
/* 1170 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 1171 */           .addNextBehavior(
/* 1172 */             CECombatBehaviors.Behavior.builder()
/* 1173 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1174 */             .withinDistance(0.0D, 4.0D)
/* 1175 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1176 */             .addNextBehavior(
/* 1177 */               CECombatBehaviors.Behavior.builder()
/* 1178 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1179 */               .withinDistance(0.0D, 4.0D)
/* 1180 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1181 */               .addNextBehavior(
/* 1182 */                 CECombatBehaviors.Behavior.builder()
/* 1183 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1184 */                 .withinDistance(0.0D, 5.0D)
/* 1185 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1192 */       .addFirstBehavior(
/* 1193 */         CECombatBehaviors.Behavior.builder()
/* 1194 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1195 */         .withinDistance(0.0D, 3.0D)
/* 1196 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1197 */         .addNextBehavior(
/* 1198 */           CECombatBehaviors.Behavior.builder()
/* 1199 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1200 */           .withinDistance(0.0D, 3.0D)
/* 1201 */           .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F)
/* 1202 */           .addNextBehavior(
/* 1203 */             CECombatBehaviors.Behavior.builder()
/* 1204 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1205 */             .withinDistance(0.0D, 4.0D)
/* 1206 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 1207 */             .addNextBehavior(
/* 1208 */               CECombatBehaviors.Behavior.builder()
/* 1209 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1210 */               .withinDistance(0.0D, 4.0D)
/* 1211 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1212 */               .addNextBehavior(
/* 1213 */                 CECombatBehaviors.Behavior.builder()
/* 1214 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1215 */                 .withinDistance(0.0D, 5.0D)
/* 1216 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1223 */       .addFirstBehavior(
/* 1224 */         CECombatBehaviors.Behavior.builder()
/* 1225 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1226 */         .withinDistance(0.0D, 3.0D)
/* 1227 */         .animationBehavior(AnimsSolar.SOLAR_HORNO, 0.0F)
/* 1228 */         .addNextBehavior(
/* 1229 */           CECombatBehaviors.Behavior.builder()
/* 1230 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1231 */           .withinDistance(0.0D, 3.0D)
/* 1232 */           .animationBehavior(Animations.STEEL_WHIRLWIND_CHARGING, 0.0F)
/* 1233 */           .addNextBehavior(
/* 1234 */             CECombatBehaviors.Behavior.builder()
/* 1235 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1236 */             .withinDistance(0.0D, 4.0D)
/* 1237 */             .animationBehavior(Animations.STEEL_WHIRLWIND, 0.0F)
/* 1238 */             .addNextBehavior(
/* 1239 */               CECombatBehaviors.Behavior.builder()
/* 1240 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1241 */               .withinDistance(0.0D, 4.0D)
/* 1242 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1243 */               .addNextBehavior(
/* 1244 */                 CECombatBehaviors.Behavior.builder()
/* 1245 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1246 */                 .withinDistance(0.0D, 5.0D)
/* 1247 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1254 */       .addFirstBehavior(
/* 1255 */         CECombatBehaviors.Behavior.builder()
/* 1256 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1257 */         .withinDistance(0.0D, 3.0D)
/* 1258 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1259 */         .addNextBehavior(
/* 1260 */           CECombatBehaviors.Behavior.builder()
/* 1261 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1262 */           .withinDistance(0.0D, 3.0D)
/* 1263 */           .animationBehavior(Animations.STEEL_WHIRLWIND_CHARGING, 0.0F)
/* 1264 */           .addNextBehavior(
/* 1265 */             CECombatBehaviors.Behavior.builder()
/* 1266 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1267 */             .withinDistance(0.0D, 4.0D)
/* 1268 */             .animationBehavior(Animations.STEEL_WHIRLWIND, 0.0F)
/* 1269 */             .addNextBehavior(
/* 1270 */               CECombatBehaviors.Behavior.builder()
/* 1271 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1272 */               .withinDistance(0.0D, 4.0D)
/* 1273 */               .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 1274 */               .addNextBehavior(
/* 1275 */                 CECombatBehaviors.Behavior.builder()
/* 1276 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1277 */                 .withinDistance(0.0D, 5.0D)
/* 1278 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1279 */                 .addNextBehavior(
/* 1280 */                   CECombatBehaviors.Behavior.builder()
/* 1281 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1282 */                   .withinDistance(0.0D, 5.0D)
/* 1283 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1291 */       .addFirstBehavior(
/* 1292 */         CECombatBehaviors.Behavior.builder()
/* 1293 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1294 */         .withinDistance(0.0D, 3.0D)
/* 1295 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1296 */         .addNextBehavior(
/* 1297 */           CECombatBehaviors.Behavior.builder()
/* 1298 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1299 */           .withinDistance(0.0D, 3.0D)
/* 1300 */           .animationBehavior(Animations.STEEL_WHIRLWIND_CHARGING, 0.0F)
/* 1301 */           .addNextBehavior(
/* 1302 */             CECombatBehaviors.Behavior.builder()
/* 1303 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1304 */             .withinDistance(0.0D, 4.0D)
/* 1305 */             .animationBehavior(Animations.STEEL_WHIRLWIND, 0.0F)
/* 1306 */             .addNextBehavior(
/* 1307 */               CECombatBehaviors.Behavior.builder()
/* 1308 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1309 */               .withinDistance(0.0D, 4.0D)
/* 1310 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1311 */               .addNextBehavior(
/* 1312 */                 CECombatBehaviors.Behavior.builder()
/* 1313 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1314 */                 .withinDistance(0.0D, 5.0D)
/* 1315 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1316 */                 .addNextBehavior(
/* 1317 */                   CECombatBehaviors.Behavior.builder()
/* 1318 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1319 */                   .withinDistance(0.0D, 5.0D)
/* 1320 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1328 */       .addFirstBehavior(
/* 1329 */         CECombatBehaviors.Behavior.builder()
/* 1330 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1331 */         .withinDistance(0.0D, 3.0D)
/* 1332 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1333 */         .addNextBehavior(
/* 1334 */           CECombatBehaviors.Behavior.builder()
/* 1335 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1336 */           .withinDistance(0.0D, 3.0D)
/* 1337 */           .animationBehavior(Animations.GREATSWORD_DASH, 0.0F)
/* 1338 */           .addNextBehavior(
/* 1339 */             CECombatBehaviors.Behavior.builder()
/* 1340 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1341 */             .withinDistance(0.0D, 4.0D)
/* 1342 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 1343 */             .addNextBehavior(
/* 1344 */               CECombatBehaviors.Behavior.builder()
/* 1345 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1346 */               .withinDistance(0.0D, 4.0D)
/* 1347 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1348 */               .addNextBehavior(
/* 1349 */                 CECombatBehaviors.Behavior.builder()
/* 1350 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1351 */                 .withinDistance(0.0D, 5.0D)
/* 1352 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1360 */     .newBehaviorRoot(
/* 1361 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1362 */       .priority(1.0D)
/* 1363 */       .weight(20.0D)
/* 1364 */       .maxCooldown(100)
/* 1365 */       .addFirstBehavior(
/* 1366 */         CECombatBehaviors.Behavior.builder()
/* 1367 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1368 */         .withinDistance(0.0D, 3.0D)
/* 1369 */         .animationBehavior(AVAnimations.GIANT_WHIRLWIND, 0.0F)))
/*      */ 
/*      */     
/* 1372 */     .newBehaviorRoot(
/* 1373 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1374 */       .priority(1.0D)
/* 1375 */       .weight(10.0D)
/* 1376 */       .maxCooldown(100)
/* 1377 */       .addFirstBehavior(
/* 1378 */         CECombatBehaviors.Behavior.builder()
/* 1379 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1380 */         .withinDistance(0.0D, 3.0D)
/* 1381 */         .animationBehavior(Animations.GREATSWORD_DASH, 0.0F))
/*      */       
/* 1383 */       .addFirstBehavior(
/* 1384 */         CECombatBehaviors.Behavior.builder()
/* 1385 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1386 */         .withinDistance(0.0D, 3.0D)
/* 1387 */         .animationBehavior(Animations.GREATSWORD_AIR_SLASH, 0.0F))
/*      */       
/* 1389 */       .addFirstBehavior(
/* 1390 */         CECombatBehaviors.Behavior.builder()
/* 1391 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1392 */         .withinDistance(0.0D, 3.0D)
/* 1393 */         .animationBehavior(Animations.STEEL_WHIRLWIND_CHARGING, 0.0F)
/* 1394 */         .addNextBehavior(
/* 1395 */           CECombatBehaviors.Behavior.builder()
/* 1396 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1397 */           .withinDistance(0.0D, 3.0D)
/* 1398 */           .animationBehavior(Animations.STEEL_WHIRLWIND, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/* 1402 */     .newBehaviorRoot(
/* 1403 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1404 */       .priority(1.0D)
/* 1405 */       .weight(10.0D)
/* 1406 */       .maxCooldown(40)
/* 1407 */       .addFirstBehavior(
/* 1408 */         CECombatBehaviors.Behavior.builder()
/* 1409 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1410 */         .withinDistance(0.0D, 3.0D)
/* 1411 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1412 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1413 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1416 */     .newBehaviorRoot(
/* 1417 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1418 */       .priority(1.0D)
/* 1419 */       .weight(2.0D)
/* 1420 */       .maxCooldown(100)
/* 1421 */       .addFirstBehavior(
/* 1422 */         CECombatBehaviors.Behavior.builder()
/* 1423 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1424 */         .withinDistance(0.0D, 3.0D)
/* 1425 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1427 */       .addFirstBehavior(
/* 1428 */         CECombatBehaviors.Behavior.builder()
/* 1429 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1430 */         .withinDistance(0.0D, 3.0D)
/* 1431 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1433 */       .addFirstBehavior(
/* 1434 */         CECombatBehaviors.Behavior.builder()
/* 1435 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1436 */         .withinDistance(0.0D, 3.0D)
/* 1437 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1439 */       .addFirstBehavior(
/* 1440 */         CECombatBehaviors.Behavior.builder()
/* 1441 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1442 */         .withinDistance(0.0D, 3.0D)
/* 1443 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1445 */       .addFirstBehavior(
/* 1446 */         CECombatBehaviors.Behavior.builder()
/* 1447 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1448 */         .withinDistance(0.0D, 3.0D)
/* 1449 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1451 */       .addFirstBehavior(
/* 1452 */         CECombatBehaviors.Behavior.builder()
/* 1453 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1454 */         .withinDistance(0.0D, 3.0D)
/* 1455 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1457 */       .addFirstBehavior(
/* 1458 */         CECombatBehaviors.Behavior.builder()
/* 1459 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1460 */         .withinDistance(0.0D, 3.0D)
/* 1461 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1464 */     .newBehaviorRoot(
/* 1465 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1466 */       .priority(1.0D)
/* 1467 */       .weight(15.0D)
/* 1468 */       .addFirstBehavior(
/* 1469 */         CECombatBehaviors.Behavior.builder()
/* 1470 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1471 */         .withinDistance(0.0D, 3.0D)
/* 1472 */         .custom(CombatCommon::canPerformGuarding)
/* 1473 */         .guard(40)))
/*      */ 
/*      */     
/* 1476 */     .newBehaviorRoot(
/* 1477 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1478 */       .priority(1.0D)
/* 1479 */       .weight(10.0D)
/* 1480 */       .addFirstBehavior(
/* 1481 */         CECombatBehaviors.Behavior.builder()
/* 1482 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1483 */         .withinDistance(0.0D, 3.0D)
/* 1484 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1486 */       .addFirstBehavior(
/* 1487 */         CECombatBehaviors.Behavior.builder()
/* 1488 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1489 */         .withinDistance(0.0D, 3.0D)
/* 1490 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1493 */     .newBehaviorRoot(
/* 1494 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1495 */       .priority(1.0D)
/* 1496 */       .weight(40.0D)
/* 1497 */       .maxCooldown(160)
/* 1498 */       .addFirstBehavior(
/* 1499 */         CECombatBehaviors.Behavior.builder()
/* 1500 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1501 */         .custom(CombatCommon::canJump)
/* 1502 */         .withinDistance(5.0D, 14.0D)
/* 1503 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1504 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcGreatsword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */