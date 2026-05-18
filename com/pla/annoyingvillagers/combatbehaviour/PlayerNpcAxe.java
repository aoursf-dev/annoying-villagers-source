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
/*      */ public class PlayerNpcAxe
/*      */ {
/*   14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AXE = CECombatBehaviors.builder()
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
/*   44 */         .guard(40)))
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
/*  105 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  106 */         .addNextBehavior(
/*  107 */           CECombatBehaviors.Behavior.builder()
/*  108 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  109 */           .withinDistance(0.0D, 3.0D)
/*  110 */           .animationBehavior(Animations.AXE_AUTO2, 0.0F)))
/*      */ 
/*      */       
/*  113 */       .addFirstBehavior(
/*  114 */         CECombatBehaviors.Behavior.builder()
/*  115 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  116 */         .withinDistance(0.0D, 3.0D)
/*  117 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  118 */         .addNextBehavior(
/*  119 */           CECombatBehaviors.Behavior.builder()
/*  120 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  121 */           .withinDistance(0.0D, 3.0D)
/*  122 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/*  123 */           .addNextBehavior(
/*  124 */             CECombatBehaviors.Behavior.builder()
/*  125 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  126 */             .withinDistance(0.0D, 4.0D)
/*  127 */             .animationBehavior(Animations.AXE_DASH, 0.0F)
/*  128 */             .addNextBehavior(
/*  129 */               CECombatBehaviors.Behavior.builder()
/*  130 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  131 */               .withinDistance(0.0D, 4.0D)
/*  132 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  133 */               .addNextBehavior(
/*  134 */                 CECombatBehaviors.Behavior.builder()
/*  135 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  136 */                 .withinDistance(0.0D, 5.0D)
/*  137 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  144 */       .addFirstBehavior(
/*  145 */         CECombatBehaviors.Behavior.builder()
/*  146 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  147 */         .withinDistance(0.0D, 3.0D)
/*  148 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  149 */         .addNextBehavior(
/*  150 */           CECombatBehaviors.Behavior.builder()
/*  151 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  152 */           .withinDistance(0.0D, 3.0D)
/*  153 */           .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/*  154 */           .addNextBehavior(
/*  155 */             CECombatBehaviors.Behavior.builder()
/*  156 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  157 */             .withinDistance(0.0D, 4.0D)
/*  158 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  159 */             .addNextBehavior(
/*  160 */               CECombatBehaviors.Behavior.builder()
/*  161 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  162 */               .withinDistance(0.0D, 4.0D)
/*  163 */               .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/*  164 */               .addNextBehavior(
/*  165 */                 CECombatBehaviors.Behavior.builder()
/*  166 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  167 */                 .withinDistance(0.0D, 5.0D)
/*  168 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  169 */                 .addNextBehavior(
/*  170 */                   CECombatBehaviors.Behavior.builder()
/*  171 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  172 */                   .withinDistance(0.0D, 5.0D)
/*  173 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  181 */       .addFirstBehavior(
/*  182 */         CECombatBehaviors.Behavior.builder()
/*  183 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  184 */         .withinDistance(0.0D, 3.0D)
/*  185 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  186 */         .addNextBehavior(
/*  187 */           CECombatBehaviors.Behavior.builder()
/*  188 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  189 */           .withinDistance(0.0D, 3.0D)
/*  190 */           .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)
/*  191 */           .addNextBehavior(
/*  192 */             CECombatBehaviors.Behavior.builder()
/*  193 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  194 */             .withinDistance(0.0D, 4.0D)
/*  195 */             .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/*  196 */             .addNextBehavior(
/*  197 */               CECombatBehaviors.Behavior.builder()
/*  198 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  199 */               .withinDistance(0.0D, 4.0D)
/*  200 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  201 */               .addNextBehavior(
/*  202 */                 CECombatBehaviors.Behavior.builder()
/*  203 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  204 */                 .withinDistance(0.0D, 5.0D)
/*  205 */                 .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  206 */                 .addNextBehavior(
/*  207 */                   CECombatBehaviors.Behavior.builder()
/*  208 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  209 */                   .withinDistance(0.0D, 5.0D)
/*  210 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  218 */       .addFirstBehavior(
/*  219 */         CECombatBehaviors.Behavior.builder()
/*  220 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  221 */         .withinDistance(0.0D, 3.0D)
/*  222 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  223 */         .addNextBehavior(
/*  224 */           CECombatBehaviors.Behavior.builder()
/*  225 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  226 */           .withinDistance(0.0D, 3.0D)
/*  227 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/*  228 */           .addNextBehavior(
/*  229 */             CECombatBehaviors.Behavior.builder()
/*  230 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  231 */             .withinDistance(0.0D, 4.0D)
/*  232 */             .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/*  233 */             .addNextBehavior(
/*  234 */               CECombatBehaviors.Behavior.builder()
/*  235 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  236 */               .withinDistance(0.0D, 4.0D)
/*  237 */               .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  238 */               .addNextBehavior(
/*  239 */                 CECombatBehaviors.Behavior.builder()
/*  240 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  241 */                 .withinDistance(0.0D, 5.0D)
/*  242 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  243 */                 .addNextBehavior(
/*  244 */                   CECombatBehaviors.Behavior.builder()
/*  245 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  246 */                   .withinDistance(0.0D, 5.0D)
/*  247 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  255 */       .addFirstBehavior(
/*  256 */         CECombatBehaviors.Behavior.builder()
/*  257 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  258 */         .withinDistance(0.0D, 3.0D)
/*  259 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  260 */         .addNextBehavior(
/*  261 */           CECombatBehaviors.Behavior.builder()
/*  262 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  263 */           .withinDistance(0.0D, 3.0D)
/*  264 */           .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  265 */           .addNextBehavior(
/*  266 */             CECombatBehaviors.Behavior.builder()
/*  267 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  268 */             .withinDistance(0.0D, 4.0D)
/*  269 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  270 */             .addNextBehavior(
/*  271 */               CECombatBehaviors.Behavior.builder()
/*  272 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  273 */               .withinDistance(0.0D, 4.0D)
/*  274 */               .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/*  275 */               .addNextBehavior(
/*  276 */                 CECombatBehaviors.Behavior.builder()
/*  277 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  278 */                 .withinDistance(0.0D, 5.0D)
/*  279 */                 .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/*  280 */                 .addNextBehavior(
/*  281 */                   CECombatBehaviors.Behavior.builder()
/*  282 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  283 */                   .withinDistance(0.0D, 5.0D)
/*  284 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  292 */       .addFirstBehavior(
/*  293 */         CECombatBehaviors.Behavior.builder()
/*  294 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  295 */         .withinDistance(0.0D, 3.0D)
/*  296 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  297 */         .addNextBehavior(
/*  298 */           CECombatBehaviors.Behavior.builder()
/*  299 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  300 */           .withinDistance(0.0D, 3.0D)
/*  301 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/*  302 */           .addNextBehavior(
/*  303 */             CECombatBehaviors.Behavior.builder()
/*  304 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  305 */             .withinDistance(0.0D, 4.0D)
/*  306 */             .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  307 */             .addNextBehavior(
/*  308 */               CECombatBehaviors.Behavior.builder()
/*  309 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  310 */               .withinDistance(0.0D, 4.0D)
/*  311 */               .animationBehavior(Animations.AXE_DASH, 0.0F)
/*  312 */               .addNextBehavior(
/*  313 */                 CECombatBehaviors.Behavior.builder()
/*  314 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  315 */                 .withinDistance(0.0D, 5.0D)
/*  316 */                 .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  317 */                 .addNextBehavior(
/*  318 */                   CECombatBehaviors.Behavior.builder()
/*  319 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  320 */                   .withinDistance(0.0D, 5.0D)
/*  321 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  329 */       .addFirstBehavior(
/*  330 */         CECombatBehaviors.Behavior.builder()
/*  331 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  332 */         .withinDistance(0.0D, 3.0D)
/*  333 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  334 */         .addNextBehavior(
/*  335 */           CECombatBehaviors.Behavior.builder()
/*  336 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  337 */           .withinDistance(0.0D, 3.0D)
/*  338 */           .animationBehavior(Animations.AXE_DASH, 0.0F)
/*  339 */           .addNextBehavior(
/*  340 */             CECombatBehaviors.Behavior.builder()
/*  341 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  342 */             .withinDistance(0.0D, 4.0D)
/*  343 */             .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/*  344 */             .addNextBehavior(
/*  345 */               CECombatBehaviors.Behavior.builder()
/*  346 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  347 */               .withinDistance(0.0D, 4.0D)
/*  348 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  349 */               .addNextBehavior(
/*  350 */                 CECombatBehaviors.Behavior.builder()
/*  351 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  352 */                 .withinDistance(0.0D, 5.0D)
/*  353 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  360 */       .addFirstBehavior(
/*  361 */         CECombatBehaviors.Behavior.builder()
/*  362 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  363 */         .withinDistance(0.0D, 3.0D)
/*  364 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  365 */         .addNextBehavior(
/*  366 */           CECombatBehaviors.Behavior.builder()
/*  367 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  368 */           .withinDistance(0.0D, 3.0D)
/*  369 */           .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)
/*  370 */           .addNextBehavior(
/*  371 */             CECombatBehaviors.Behavior.builder()
/*  372 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  373 */             .withinDistance(0.0D, 4.0D)
/*  374 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  375 */             .addNextBehavior(
/*  376 */               CECombatBehaviors.Behavior.builder()
/*  377 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  378 */               .withinDistance(0.0D, 4.0D)
/*  379 */               .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/*  380 */               .addNextBehavior(
/*  381 */                 CECombatBehaviors.Behavior.builder()
/*  382 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  383 */                 .withinDistance(0.0D, 5.0D)
/*  384 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  385 */                 .addNextBehavior(
/*  386 */                   CECombatBehaviors.Behavior.builder()
/*  387 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  388 */                   .withinDistance(0.0D, 5.0D)
/*  389 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  397 */       .addFirstBehavior(
/*  398 */         CECombatBehaviors.Behavior.builder()
/*  399 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  400 */         .withinDistance(0.0D, 3.0D)
/*  401 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  402 */         .addNextBehavior(
/*  403 */           CECombatBehaviors.Behavior.builder()
/*  404 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  405 */           .withinDistance(0.0D, 3.0D)
/*  406 */           .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/*  407 */           .addNextBehavior(
/*  408 */             CECombatBehaviors.Behavior.builder()
/*  409 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  410 */             .withinDistance(0.0D, 4.0D)
/*  411 */             .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/*  412 */             .addNextBehavior(
/*  413 */               CECombatBehaviors.Behavior.builder()
/*  414 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  415 */               .withinDistance(0.0D, 4.0D)
/*  416 */               .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  417 */               .addNextBehavior(
/*  418 */                 CECombatBehaviors.Behavior.builder()
/*  419 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  420 */                 .withinDistance(0.0D, 5.0D)
/*  421 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  422 */                 .addNextBehavior(
/*  423 */                   CECombatBehaviors.Behavior.builder()
/*  424 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  425 */                   .withinDistance(0.0D, 5.0D)
/*  426 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  434 */       .addFirstBehavior(
/*  435 */         CECombatBehaviors.Behavior.builder()
/*  436 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  437 */         .withinDistance(0.0D, 3.0D)
/*  438 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  439 */         .addNextBehavior(
/*  440 */           CECombatBehaviors.Behavior.builder()
/*  441 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  442 */           .withinDistance(0.0D, 3.0D)
/*  443 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/*  444 */           .addNextBehavior(
/*  445 */             CECombatBehaviors.Behavior.builder()
/*  446 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  447 */             .withinDistance(0.0D, 4.0D)
/*  448 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  449 */             .addNextBehavior(
/*  450 */               CECombatBehaviors.Behavior.builder()
/*  451 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  452 */               .withinDistance(0.0D, 4.0D)
/*  453 */               .animationBehavior(Animations.AXE_DASH, 0.0F)
/*  454 */               .addNextBehavior(
/*  455 */                 CECombatBehaviors.Behavior.builder()
/*  456 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  457 */                 .withinDistance(0.0D, 5.0D)
/*  458 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  459 */                 .addNextBehavior(
/*  460 */                   CECombatBehaviors.Behavior.builder()
/*  461 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  462 */                   .withinDistance(0.0D, 5.0D)
/*  463 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  471 */       .addFirstBehavior(
/*  472 */         CECombatBehaviors.Behavior.builder()
/*  473 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  474 */         .withinDistance(0.0D, 3.0D)
/*  475 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  476 */         .addNextBehavior(
/*  477 */           CECombatBehaviors.Behavior.builder()
/*  478 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  479 */           .withinDistance(0.0D, 3.0D)
/*  480 */           .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  481 */           .addNextBehavior(
/*  482 */             CECombatBehaviors.Behavior.builder()
/*  483 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  484 */             .withinDistance(0.0D, 4.0D)
/*  485 */             .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/*  486 */             .addNextBehavior(
/*  487 */               CECombatBehaviors.Behavior.builder()
/*  488 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  489 */               .withinDistance(0.0D, 4.0D)
/*  490 */               .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/*  491 */               .addNextBehavior(
/*  492 */                 CECombatBehaviors.Behavior.builder()
/*  493 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  494 */                 .withinDistance(0.0D, 5.0D)
/*  495 */                 .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  496 */                 .addNextBehavior(
/*  497 */                   CECombatBehaviors.Behavior.builder()
/*  498 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  499 */                   .withinDistance(0.0D, 5.0D)
/*  500 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
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
/*  512 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  513 */         .addNextBehavior(
/*  514 */           CECombatBehaviors.Behavior.builder()
/*  515 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  516 */           .withinDistance(0.0D, 3.0D)
/*  517 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/*  518 */           .addNextBehavior(
/*  519 */             CECombatBehaviors.Behavior.builder()
/*  520 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  521 */             .withinDistance(0.0D, 4.0D)
/*  522 */             .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  523 */             .addNextBehavior(
/*  524 */               CECombatBehaviors.Behavior.builder()
/*  525 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  526 */               .withinDistance(0.0D, 4.0D)
/*  527 */               .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/*  528 */               .addNextBehavior(
/*  529 */                 CECombatBehaviors.Behavior.builder()
/*  530 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  531 */                 .withinDistance(0.0D, 5.0D)
/*  532 */                 .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  533 */                 .addNextBehavior(
/*  534 */                   CECombatBehaviors.Behavior.builder()
/*  535 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  536 */                   .withinDistance(0.0D, 5.0D)
/*  537 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  544 */       .addFirstBehavior(
/*  545 */         CECombatBehaviors.Behavior.builder()
/*  546 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  547 */         .withinDistance(0.0D, 3.0D)
/*  548 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  549 */         .addNextBehavior(
/*  550 */           CECombatBehaviors.Behavior.builder()
/*  551 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  552 */           .withinDistance(0.0D, 3.0D)
/*  553 */           .animationBehavior(Animations.AXE_DASH, 0.0F)
/*  554 */           .addNextBehavior(
/*  555 */             CECombatBehaviors.Behavior.builder()
/*  556 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  557 */             .withinDistance(0.0D, 4.0D)
/*  558 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  559 */             .addNextBehavior(
/*  560 */               CECombatBehaviors.Behavior.builder()
/*  561 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  562 */               .withinDistance(0.0D, 4.0D)
/*  563 */               .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)
/*  564 */               .addNextBehavior(
/*  565 */                 CECombatBehaviors.Behavior.builder()
/*  566 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  567 */                 .withinDistance(0.0D, 5.0D)
/*  568 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  569 */                 .addNextBehavior(
/*  570 */                   CECombatBehaviors.Behavior.builder()
/*  571 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  572 */                   .withinDistance(0.0D, 5.0D)
/*  573 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  581 */       .addFirstBehavior(
/*  582 */         CECombatBehaviors.Behavior.builder()
/*  583 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  584 */         .withinDistance(0.0D, 3.0D)
/*  585 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  586 */         .addNextBehavior(
/*  587 */           CECombatBehaviors.Behavior.builder()
/*  588 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  589 */           .withinDistance(0.0D, 3.0D)
/*  590 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/*  591 */           .addNextBehavior(
/*  592 */             CECombatBehaviors.Behavior.builder()
/*  593 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  594 */             .withinDistance(0.0D, 4.0D)
/*  595 */             .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/*  596 */             .addNextBehavior(
/*  597 */               CECombatBehaviors.Behavior.builder()
/*  598 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  599 */               .withinDistance(0.0D, 4.0D)
/*  600 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  601 */               .addNextBehavior(
/*  602 */                 CECombatBehaviors.Behavior.builder()
/*  603 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  604 */                 .withinDistance(0.0D, 5.0D)
/*  605 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  612 */       .addFirstBehavior(
/*  613 */         CECombatBehaviors.Behavior.builder()
/*  614 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  615 */         .withinDistance(0.0D, 3.0D)
/*  616 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  617 */         .addNextBehavior(
/*  618 */           CECombatBehaviors.Behavior.builder()
/*  619 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  620 */           .withinDistance(0.0D, 3.0D)
/*  621 */           .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  622 */           .addNextBehavior(
/*  623 */             CECombatBehaviors.Behavior.builder()
/*  624 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  625 */             .withinDistance(0.0D, 4.0D)
/*  626 */             .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/*  627 */             .addNextBehavior(
/*  628 */               CECombatBehaviors.Behavior.builder()
/*  629 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  630 */               .withinDistance(0.0D, 4.0D)
/*  631 */               .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/*  632 */               .addNextBehavior(
/*  633 */                 CECombatBehaviors.Behavior.builder()
/*  634 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  635 */                 .withinDistance(0.0D, 5.0D)
/*  636 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  637 */                 .addNextBehavior(
/*  638 */                   CECombatBehaviors.Behavior.builder()
/*  639 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  640 */                   .withinDistance(0.0D, 5.0D)
/*  641 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  650 */     .newBehaviorRoot(
/*  651 */       CECombatBehaviors.BehaviorRoot.builder()
/*  652 */       .priority(1.0D)
/*  653 */       .weight(20.0D)
/*  654 */       .maxCooldown(100)
/*  655 */       .addFirstBehavior(
/*  656 */         CECombatBehaviors.Behavior.builder()
/*  657 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  658 */         .withinDistance(0.0D, 3.0D)
/*  659 */         .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/*  660 */         .addNextBehavior(
/*  661 */           CECombatBehaviors.Behavior.builder()
/*  662 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  663 */           .withinDistance(0.0D, 3.0D)
/*  664 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/*  665 */           .addNextBehavior(
/*  666 */             CECombatBehaviors.Behavior.builder()
/*  667 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  668 */             .withinDistance(0.0D, 3.0D)
/*  669 */             .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  674 */     .newBehaviorRoot(
/*  675 */       CECombatBehaviors.BehaviorRoot.builder()
/*  676 */       .priority(1.0D)
/*  677 */       .weight(10.0D)
/*  678 */       .maxCooldown(100)
/*  679 */       .addFirstBehavior(
/*  680 */         CECombatBehaviors.Behavior.builder()
/*  681 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  682 */         .withinDistance(0.0D, 3.0D)
/*  683 */         .animationBehavior(Animations.AXE_DASH, 0.0F))
/*      */       
/*  685 */       .addFirstBehavior(
/*  686 */         CECombatBehaviors.Behavior.builder()
/*  687 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  688 */         .withinDistance(0.0D, 3.0D)
/*  689 */         .animationBehavior(Animations.AXE_AIRSLASH, 0.0F))
/*      */       
/*  691 */       .addFirstBehavior(
/*  692 */         CECombatBehaviors.Behavior.builder()
/*  693 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  694 */         .withinDistance(0.0D, 3.0D)
/*  695 */         .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)))
/*      */ 
/*      */     
/*  698 */     .newBehaviorRoot(
/*  699 */       CECombatBehaviors.BehaviorRoot.builder()
/*  700 */       .priority(1.0D)
/*  701 */       .weight(10.0D)
/*  702 */       .maxCooldown(40)
/*  703 */       .addFirstBehavior(
/*  704 */         CECombatBehaviors.Behavior.builder()
/*  705 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  706 */         .withinDistance(0.0D, 3.0D)
/*  707 */         .custom(CombatCommon::canThrowEnderPearl)
/*  708 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  709 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  712 */     .newBehaviorRoot(
/*  713 */       CECombatBehaviors.BehaviorRoot.builder()
/*  714 */       .priority(1.0D)
/*  715 */       .weight(2.0D)
/*  716 */       .maxCooldown(100)
/*  717 */       .addFirstBehavior(
/*  718 */         CECombatBehaviors.Behavior.builder()
/*  719 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  720 */         .withinDistance(0.0D, 3.0D)
/*  721 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  723 */       .addFirstBehavior(
/*  724 */         CECombatBehaviors.Behavior.builder()
/*  725 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  726 */         .withinDistance(0.0D, 3.0D)
/*  727 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  729 */       .addFirstBehavior(
/*  730 */         CECombatBehaviors.Behavior.builder()
/*  731 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  732 */         .withinDistance(0.0D, 3.0D)
/*  733 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  735 */       .addFirstBehavior(
/*  736 */         CECombatBehaviors.Behavior.builder()
/*  737 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  738 */         .withinDistance(0.0D, 3.0D)
/*  739 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  741 */       .addFirstBehavior(
/*  742 */         CECombatBehaviors.Behavior.builder()
/*  743 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  744 */         .withinDistance(0.0D, 3.0D)
/*  745 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  747 */       .addFirstBehavior(
/*  748 */         CECombatBehaviors.Behavior.builder()
/*  749 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  750 */         .withinDistance(0.0D, 3.0D)
/*  751 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  753 */       .addFirstBehavior(
/*  754 */         CECombatBehaviors.Behavior.builder()
/*  755 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  756 */         .withinDistance(0.0D, 3.0D)
/*  757 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  760 */     .newBehaviorRoot(
/*  761 */       CECombatBehaviors.BehaviorRoot.builder()
/*  762 */       .priority(1.0D)
/*  763 */       .weight(15.0D)
/*  764 */       .addFirstBehavior(
/*  765 */         CECombatBehaviors.Behavior.builder()
/*  766 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  767 */         .withinDistance(0.0D, 3.0D)
/*  768 */         .custom(CombatCommon::canPerformGuarding)
/*  769 */         .guard(40)))
/*      */ 
/*      */     
/*  772 */     .newBehaviorRoot(
/*  773 */       CECombatBehaviors.BehaviorRoot.builder()
/*  774 */       .priority(1.0D)
/*  775 */       .weight(10.0D)
/*  776 */       .addFirstBehavior(
/*  777 */         CECombatBehaviors.Behavior.builder()
/*  778 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  779 */         .withinDistance(0.0D, 3.0D)
/*  780 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/*  782 */       .addFirstBehavior(
/*  783 */         CECombatBehaviors.Behavior.builder()
/*  784 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  785 */         .withinDistance(0.0D, 3.0D)
/*  786 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/*  789 */     .newBehaviorRoot(
/*  790 */       CECombatBehaviors.BehaviorRoot.builder()
/*  791 */       .priority(1.0D)
/*  792 */       .weight(40.0D)
/*  793 */       .maxCooldown(160)
/*  794 */       .addFirstBehavior(
/*  795 */         CECombatBehaviors.Behavior.builder()
/*  796 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  797 */         .custom(CombatCommon::canJump)
/*  798 */         .withinDistance(5.0D, 14.0D)
/*  799 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/*  800 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/*  804 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_AXE = CECombatBehaviors.builder()
/*  805 */     .newBehaviorRoot(
/*  806 */       CECombatBehaviors.BehaviorRoot.builder()
/*  807 */       .priority(4.0D)
/*  808 */       .weight(1000.0D)
/*  809 */       .maxCooldown(0)
/*  810 */       .addFirstBehavior(
/*  811 */         CECombatBehaviors.Behavior.builder()
/*  812 */         .custom(CombatCommon::canExecute)
/*  813 */         .withinDistance(0.0D, 5.0D)
/*  814 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  815 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  818 */     .newBehaviorRoot(
/*  819 */       CECombatBehaviors.BehaviorRoot.builder()
/*  820 */       .priority(3.0D)
/*  821 */       .weight(1000.0D)
/*  822 */       .maxCooldown(0)
/*  823 */       .addFirstBehavior(
/*  824 */         CECombatBehaviors.Behavior.builder()
/*  825 */         .custom(CombatCommon::canEscape)
/*  826 */         .withinDistance(0.0D, 8.0D)
/*  827 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  828 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  830 */       .addFirstBehavior(
/*  831 */         CECombatBehaviors.Behavior.builder()
/*  832 */         .custom(CombatCommon::canEscape)
/*  833 */         .withinDistance(0.0D, 48.0D)
/*  834 */         .guard(40)))
/*      */ 
/*      */     
/*  837 */     .newBehaviorRoot(
/*  838 */       CECombatBehaviors.BehaviorRoot.builder()
/*  839 */       .priority(2.0D)
/*  840 */       .weight(70.0D)
/*  841 */       .maxCooldown(0)
/*  842 */       .addFirstBehavior(
/*  843 */         CECombatBehaviors.Behavior.builder()
/*  844 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  845 */         .custom(CombatCommon::canPerformEating)
/*  846 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  847 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  850 */     .newBehaviorRoot(
/*  851 */       CECombatBehaviors.BehaviorRoot.builder()
/*  852 */       .priority(2.0D)
/*  853 */       .weight(100.0D)
/*  854 */       .maxCooldown(120)
/*  855 */       .addFirstBehavior(
/*  856 */         CECombatBehaviors.Behavior.builder()
/*  857 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  858 */         .custom(CombatCommon::canSwapToBow)
/*  859 */         .withinDistance(7.0D, 14.0D)
/*  860 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  861 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  863 */       .addFirstBehavior(
/*  864 */         CECombatBehaviors.Behavior.builder()
/*  865 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  866 */         .custom(CombatCommon::canSwapToBow)
/*  867 */         .withinDistance(7.0D, 14.0D)
/*  868 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  869 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  872 */     .newBehaviorRoot(
/*  873 */       CECombatBehaviors.BehaviorRoot.builder()
/*  874 */       .priority(2.0D)
/*  875 */       .weight(80.0D)
/*  876 */       .maxCooldown(120)
/*  877 */       .addFirstBehavior(
/*  878 */         CECombatBehaviors.Behavior.builder()
/*  879 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  880 */         .custom(CombatCommon::canThrowEnderPearl)
/*  881 */         .withinDistance(7.0D, 48.0D)
/*  882 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  883 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  886 */     .newBehaviorRoot(
/*  887 */       CECombatBehaviors.BehaviorRoot.builder()
/*  888 */       .priority(1.0D)
/*  889 */       .weight(40.0D)
/*  890 */       .addFirstBehavior(
/*  891 */         CECombatBehaviors.Behavior.builder()
/*  892 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  893 */         .withinDistance(0.0D, 3.0D)
/*  894 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  895 */         .addNextBehavior(
/*  896 */           CECombatBehaviors.Behavior.builder()
/*  897 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  898 */           .withinDistance(0.0D, 3.0D)
/*  899 */           .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  900 */           .addNextBehavior(
/*  901 */             CECombatBehaviors.Behavior.builder()
/*  902 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  903 */             .withinDistance(0.0D, 3.0D)
/*  904 */             .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  905 */             .addNextBehavior(
/*  906 */               CECombatBehaviors.Behavior.builder()
/*  907 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  908 */               .withinDistance(0.0D, 3.0D)
/*  909 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  914 */       .addFirstBehavior(
/*  915 */         CECombatBehaviors.Behavior.builder()
/*  916 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  917 */         .withinDistance(0.0D, 3.0D)
/*  918 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  919 */         .addNextBehavior(
/*  920 */           CECombatBehaviors.Behavior.builder()
/*  921 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  922 */           .withinDistance(0.0D, 3.0D)
/*  923 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/*  924 */           .addNextBehavior(
/*  925 */             CECombatBehaviors.Behavior.builder()
/*  926 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  927 */             .withinDistance(0.0D, 4.0D)
/*  928 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  929 */             .addNextBehavior(
/*  930 */               CECombatBehaviors.Behavior.builder()
/*  931 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  932 */               .withinDistance(0.0D, 4.0D)
/*  933 */               .animationBehavior(Animations.AXE_DASH, 0.0F)
/*  934 */               .addNextBehavior(
/*  935 */                 CECombatBehaviors.Behavior.builder()
/*  936 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  937 */                 .withinDistance(0.0D, 5.0D)
/*  938 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  939 */                 .addNextBehavior(
/*  940 */                   CECombatBehaviors.Behavior.builder()
/*  941 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  942 */                   .withinDistance(0.0D, 5.0D)
/*  943 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  951 */       .addFirstBehavior(
/*  952 */         CECombatBehaviors.Behavior.builder()
/*  953 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  954 */         .withinDistance(0.0D, 3.0D)
/*  955 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  956 */         .addNextBehavior(
/*  957 */           CECombatBehaviors.Behavior.builder()
/*  958 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  959 */           .withinDistance(0.0D, 3.0D)
/*  960 */           .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/*  961 */           .addNextBehavior(
/*  962 */             CECombatBehaviors.Behavior.builder()
/*  963 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  964 */             .withinDistance(0.0D, 4.0D)
/*  965 */             .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)
/*  966 */             .addNextBehavior(
/*  967 */               CECombatBehaviors.Behavior.builder()
/*  968 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  969 */               .withinDistance(0.0D, 4.0D)
/*  970 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  971 */               .addNextBehavior(
/*  972 */                 CECombatBehaviors.Behavior.builder()
/*  973 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  974 */                 .withinDistance(0.0D, 5.0D)
/*  975 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  982 */       .addFirstBehavior(
/*  983 */         CECombatBehaviors.Behavior.builder()
/*  984 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  985 */         .withinDistance(0.0D, 3.0D)
/*  986 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/*  987 */         .addNextBehavior(
/*  988 */           CECombatBehaviors.Behavior.builder()
/*  989 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  990 */           .withinDistance(0.0D, 3.0D)
/*  991 */           .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/*  992 */           .addNextBehavior(
/*  993 */             CECombatBehaviors.Behavior.builder()
/*  994 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  995 */             .withinDistance(0.0D, 4.0D)
/*  996 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/*  997 */             .addNextBehavior(
/*  998 */               CECombatBehaviors.Behavior.builder()
/*  999 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1000 */               .withinDistance(0.0D, 4.0D)
/* 1001 */               .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/* 1002 */               .addNextBehavior(
/* 1003 */                 CECombatBehaviors.Behavior.builder()
/* 1004 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1005 */                 .withinDistance(0.0D, 5.0D)
/* 1006 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1007 */                 .addNextBehavior(
/* 1008 */                   CECombatBehaviors.Behavior.builder()
/* 1009 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1010 */                   .withinDistance(0.0D, 5.0D)
/* 1011 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
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
/* 1023 */         .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/* 1024 */         .addNextBehavior(
/* 1025 */           CECombatBehaviors.Behavior.builder()
/* 1026 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1027 */           .withinDistance(0.0D, 3.0D)
/* 1028 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/* 1029 */           .addNextBehavior(
/* 1030 */             CECombatBehaviors.Behavior.builder()
/* 1031 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1032 */             .withinDistance(0.0D, 4.0D)
/* 1033 */             .animationBehavior(Animations.AXE_DASH, 0.0F)
/* 1034 */             .addNextBehavior(
/* 1035 */               CECombatBehaviors.Behavior.builder()
/* 1036 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1037 */               .withinDistance(0.0D, 4.0D)
/* 1038 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1039 */               .addNextBehavior(
/* 1040 */                 CECombatBehaviors.Behavior.builder()
/* 1041 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1042 */                 .withinDistance(0.0D, 5.0D)
/* 1043 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/* 1054 */         .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/* 1055 */         .addNextBehavior(
/* 1056 */           CECombatBehaviors.Behavior.builder()
/* 1057 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1058 */           .withinDistance(0.0D, 3.0D)
/* 1059 */           .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/* 1060 */           .addNextBehavior(
/* 1061 */             CECombatBehaviors.Behavior.builder()
/* 1062 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1063 */             .withinDistance(0.0D, 4.0D)
/* 1064 */             .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1065 */             .addNextBehavior(
/* 1066 */               CECombatBehaviors.Behavior.builder()
/* 1067 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1068 */               .withinDistance(0.0D, 4.0D)
/* 1069 */               .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)
/* 1070 */               .addNextBehavior(
/* 1071 */                 CECombatBehaviors.Behavior.builder()
/* 1072 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1073 */                 .withinDistance(0.0D, 5.0D)
/* 1074 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
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
/* 1091 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1092 */         .addNextBehavior(
/* 1093 */           CECombatBehaviors.Behavior.builder()
/* 1094 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1095 */           .withinDistance(0.0D, 3.0D)
/* 1096 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/* 1097 */           .addNextBehavior(
/* 1098 */             CECombatBehaviors.Behavior.builder()
/* 1099 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1100 */             .withinDistance(0.0D, 4.0D)
/* 1101 */             .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/* 1102 */             .addNextBehavior(
/* 1103 */               CECombatBehaviors.Behavior.builder()
/* 1104 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1105 */               .withinDistance(0.0D, 4.0D)
/* 1106 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1107 */               .addNextBehavior(
/* 1108 */                 CECombatBehaviors.Behavior.builder()
/* 1109 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1110 */                 .withinDistance(0.0D, 5.0D)
/* 1111 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1118 */       .addFirstBehavior(
/* 1119 */         CECombatBehaviors.Behavior.builder()
/* 1120 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1121 */         .withinDistance(0.0D, 3.0D)
/* 1122 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1123 */         .addNextBehavior(
/* 1124 */           CECombatBehaviors.Behavior.builder()
/* 1125 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1126 */           .withinDistance(0.0D, 3.0D)
/* 1127 */           .animationBehavior(Animations.AXE_DASH, 0.0F)
/* 1128 */           .addNextBehavior(
/* 1129 */             CECombatBehaviors.Behavior.builder()
/* 1130 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1131 */             .withinDistance(0.0D, 4.0D)
/* 1132 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1133 */             .addNextBehavior(
/* 1134 */               CECombatBehaviors.Behavior.builder()
/* 1135 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1136 */               .withinDistance(0.0D, 4.0D)
/* 1137 */               .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/* 1138 */               .addNextBehavior(
/* 1139 */                 CECombatBehaviors.Behavior.builder()
/* 1140 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1141 */                 .withinDistance(0.0D, 5.0D)
/* 1142 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1143 */                 .addNextBehavior(
/* 1144 */                   CECombatBehaviors.Behavior.builder()
/* 1145 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1146 */                   .withinDistance(0.0D, 5.0D)
/* 1147 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1155 */       .addFirstBehavior(
/* 1156 */         CECombatBehaviors.Behavior.builder()
/* 1157 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1158 */         .withinDistance(0.0D, 3.0D)
/* 1159 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1160 */         .addNextBehavior(
/* 1161 */           CECombatBehaviors.Behavior.builder()
/* 1162 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1163 */           .withinDistance(0.0D, 3.0D)
/* 1164 */           .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)
/* 1165 */           .addNextBehavior(
/* 1166 */             CECombatBehaviors.Behavior.builder()
/* 1167 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1168 */             .withinDistance(0.0D, 4.0D)
/* 1169 */             .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/* 1170 */             .addNextBehavior(
/* 1171 */               CECombatBehaviors.Behavior.builder()
/* 1172 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1173 */               .withinDistance(0.0D, 4.0D)
/* 1174 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1175 */               .addNextBehavior(
/* 1176 */                 CECombatBehaviors.Behavior.builder()
/* 1177 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1178 */                 .withinDistance(0.0D, 5.0D)
/* 1179 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1186 */       .addFirstBehavior(
/* 1187 */         CECombatBehaviors.Behavior.builder()
/* 1188 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1189 */         .withinDistance(0.0D, 3.0D)
/* 1190 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/* 1191 */         .addNextBehavior(
/* 1192 */           CECombatBehaviors.Behavior.builder()
/* 1193 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1194 */           .withinDistance(0.0D, 3.0D)
/* 1195 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/* 1196 */           .addNextBehavior(
/* 1197 */             CECombatBehaviors.Behavior.builder()
/* 1198 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1199 */             .withinDistance(0.0D, 4.0D)
/* 1200 */             .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1201 */             .addNextBehavior(
/* 1202 */               CECombatBehaviors.Behavior.builder()
/* 1203 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1204 */               .withinDistance(0.0D, 4.0D)
/* 1205 */               .animationBehavior(Animations.AXE_DASH, 0.0F)
/* 1206 */               .addNextBehavior(
/* 1207 */                 CECombatBehaviors.Behavior.builder()
/* 1208 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1209 */                 .withinDistance(0.0D, 5.0D)
/* 1210 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1211 */                 .addNextBehavior(
/* 1212 */                   CECombatBehaviors.Behavior.builder()
/* 1213 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1214 */                   .withinDistance(0.0D, 5.0D)
/* 1215 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
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
/* 1227 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/* 1228 */         .addNextBehavior(
/* 1229 */           CECombatBehaviors.Behavior.builder()
/* 1230 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1231 */           .withinDistance(0.0D, 3.0D)
/* 1232 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/* 1233 */           .addNextBehavior(
/* 1234 */             CECombatBehaviors.Behavior.builder()
/* 1235 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1236 */             .withinDistance(0.0D, 4.0D)
/* 1237 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/* 1238 */             .addNextBehavior(
/* 1239 */               CECombatBehaviors.Behavior.builder()
/* 1240 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1241 */               .withinDistance(0.0D, 4.0D)
/* 1242 */               .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/* 1243 */               .addNextBehavior(
/* 1244 */                 CECombatBehaviors.Behavior.builder()
/* 1245 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1246 */                 .withinDistance(0.0D, 5.0D)
/* 1247 */                 .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1248 */                 .addNextBehavior(
/* 1249 */                   CECombatBehaviors.Behavior.builder()
/* 1250 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1251 */                   .withinDistance(0.0D, 5.0D)
/* 1252 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1253 */                   .addNextBehavior(
/* 1254 */                     CECombatBehaviors.Behavior.builder()
/* 1255 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1256 */                     .withinDistance(0.0D, 5.0D)
/* 1257 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1266 */       .addFirstBehavior(
/* 1267 */         CECombatBehaviors.Behavior.builder()
/* 1268 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1269 */         .withinDistance(0.0D, 3.0D)
/* 1270 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/* 1271 */         .addNextBehavior(
/* 1272 */           CECombatBehaviors.Behavior.builder()
/* 1273 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1274 */           .withinDistance(0.0D, 3.0D)
/* 1275 */           .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1276 */           .addNextBehavior(
/* 1277 */             CECombatBehaviors.Behavior.builder()
/* 1278 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1279 */             .withinDistance(0.0D, 4.0D)
/* 1280 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/* 1281 */             .addNextBehavior(
/* 1282 */               CECombatBehaviors.Behavior.builder()
/* 1283 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1284 */               .withinDistance(0.0D, 4.0D)
/* 1285 */               .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/* 1286 */               .addNextBehavior(
/* 1287 */                 CECombatBehaviors.Behavior.builder()
/* 1288 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1289 */                 .withinDistance(0.0D, 5.0D)
/* 1290 */                 .animationBehavior(Animations.AXE_AIRSLASH, 0.0F)
/* 1291 */                 .addNextBehavior(
/* 1292 */                   CECombatBehaviors.Behavior.builder()
/* 1293 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1294 */                   .withinDistance(0.0D, 5.0D)
/* 1295 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1303 */       .addFirstBehavior(
/* 1304 */         CECombatBehaviors.Behavior.builder()
/* 1305 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1306 */         .withinDistance(0.0D, 3.0D)
/* 1307 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/* 1308 */         .addNextBehavior(
/* 1309 */           CECombatBehaviors.Behavior.builder()
/* 1310 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1311 */           .withinDistance(0.0D, 3.0D)
/* 1312 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/* 1313 */           .addNextBehavior(
/* 1314 */             CECombatBehaviors.Behavior.builder()
/* 1315 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1316 */             .withinDistance(0.0D, 4.0D)
/* 1317 */             .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1318 */             .addNextBehavior(
/* 1319 */               CECombatBehaviors.Behavior.builder()
/* 1320 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1321 */               .withinDistance(0.0D, 4.0D)
/* 1322 */               .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/* 1323 */               .addNextBehavior(
/* 1324 */                 CECombatBehaviors.Behavior.builder()
/* 1325 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1326 */                 .withinDistance(0.0D, 5.0D)
/* 1327 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1328 */                 .addNextBehavior(
/* 1329 */                   CECombatBehaviors.Behavior.builder()
/* 1330 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1331 */                   .withinDistance(0.0D, 5.0D)
/* 1332 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1340 */       .addFirstBehavior(
/* 1341 */         CECombatBehaviors.Behavior.builder()
/* 1342 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1343 */         .withinDistance(0.0D, 3.0D)
/* 1344 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 1345 */         .addNextBehavior(
/* 1346 */           CECombatBehaviors.Behavior.builder()
/* 1347 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1348 */           .withinDistance(0.0D, 3.0D)
/* 1349 */           .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)
/* 1350 */           .addNextBehavior(
/* 1351 */             CECombatBehaviors.Behavior.builder()
/* 1352 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1353 */             .withinDistance(0.0D, 4.0D)
/* 1354 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1355 */             .addNextBehavior(
/* 1356 */               CECombatBehaviors.Behavior.builder()
/* 1357 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1358 */               .withinDistance(0.0D, 4.0D)
/* 1359 */               .animationBehavior(Animations.AXE_DASH, 0.0F)
/* 1360 */               .addNextBehavior(
/* 1361 */                 CECombatBehaviors.Behavior.builder()
/* 1362 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1363 */                 .withinDistance(0.0D, 5.0D)
/* 1364 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1365 */                 .addNextBehavior(
/* 1366 */                   CECombatBehaviors.Behavior.builder()
/* 1367 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1368 */                   .withinDistance(0.0D, 5.0D)
/* 1369 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1377 */       .addFirstBehavior(
/* 1378 */         CECombatBehaviors.Behavior.builder()
/* 1379 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1380 */         .withinDistance(0.0D, 3.0D)
/* 1381 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/* 1382 */         .addNextBehavior(
/* 1383 */           CECombatBehaviors.Behavior.builder()
/* 1384 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1385 */           .withinDistance(0.0D, 3.0D)
/* 1386 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/* 1387 */           .addNextBehavior(
/* 1388 */             CECombatBehaviors.Behavior.builder()
/* 1389 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1390 */             .withinDistance(0.0D, 4.0D)
/* 1391 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/* 1392 */             .addNextBehavior(
/* 1393 */               CECombatBehaviors.Behavior.builder()
/* 1394 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1395 */               .withinDistance(0.0D, 4.0D)
/* 1396 */               .animationBehavior(Animations.AXE_DASH, 0.0F)
/* 1397 */               .addNextBehavior(
/* 1398 */                 CECombatBehaviors.Behavior.builder()
/* 1399 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1400 */                 .withinDistance(0.0D, 5.0D)
/* 1401 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1402 */                 .addNextBehavior(
/* 1403 */                   CECombatBehaviors.Behavior.builder()
/* 1404 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1405 */                   .withinDistance(0.0D, 5.0D)
/* 1406 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1414 */       .addFirstBehavior(
/* 1415 */         CECombatBehaviors.Behavior.builder()
/* 1416 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1417 */         .withinDistance(0.0D, 3.0D)
/* 1418 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/* 1419 */         .addNextBehavior(
/* 1420 */           CECombatBehaviors.Behavior.builder()
/* 1421 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1422 */           .withinDistance(0.0D, 3.0D)
/* 1423 */           .animationBehavior(Animations.AXE_DASH, 0.0F)
/* 1424 */           .addNextBehavior(
/* 1425 */             CECombatBehaviors.Behavior.builder()
/* 1426 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1427 */             .withinDistance(0.0D, 4.0D)
/* 1428 */             .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/* 1429 */             .addNextBehavior(
/* 1430 */               CECombatBehaviors.Behavior.builder()
/* 1431 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1432 */               .withinDistance(0.0D, 4.0D)
/* 1433 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1434 */               .addNextBehavior(
/* 1435 */                 CECombatBehaviors.Behavior.builder()
/* 1436 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1437 */                 .withinDistance(0.0D, 5.0D)
/* 1438 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1445 */       .addFirstBehavior(
/* 1446 */         CECombatBehaviors.Behavior.builder()
/* 1447 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1448 */         .withinDistance(0.0D, 3.0D)
/* 1449 */         .animationBehavior(Animations.AXE_AUTO1, 0.0F)
/* 1450 */         .addNextBehavior(
/* 1451 */           CECombatBehaviors.Behavior.builder()
/* 1452 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1453 */           .withinDistance(0.0D, 3.0D)
/* 1454 */           .animationBehavior(Animations.AXE_DASH, 0.0F)
/* 1455 */           .addNextBehavior(
/* 1456 */             CECombatBehaviors.Behavior.builder()
/* 1457 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1458 */             .withinDistance(0.0D, 4.0D)
/* 1459 */             .animationBehavior(Animations.AXE_AUTO2, 0.0F)
/* 1460 */             .addNextBehavior(
/* 1461 */               CECombatBehaviors.Behavior.builder()
/* 1462 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1463 */               .withinDistance(0.0D, 4.0D)
/* 1464 */               .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)
/* 1465 */               .addNextBehavior(
/* 1466 */                 CECombatBehaviors.Behavior.builder()
/* 1467 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1468 */                 .withinDistance(0.0D, 5.0D)
/* 1469 */                 .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 1470 */                 .addNextBehavior(
/* 1471 */                   CECombatBehaviors.Behavior.builder()
/* 1472 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1473 */                   .withinDistance(0.0D, 5.0D)
/* 1474 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1475 */                   .addNextBehavior(
/* 1476 */                     CECombatBehaviors.Behavior.builder()
/* 1477 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1478 */                     .withinDistance(0.0D, 5.0D)
/* 1479 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1489 */     .newBehaviorRoot(
/* 1490 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1491 */       .priority(1.0D)
/* 1492 */       .weight(20.0D)
/* 1493 */       .maxCooldown(100)
/* 1494 */       .addFirstBehavior(
/* 1495 */         CECombatBehaviors.Behavior.builder()
/* 1496 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1497 */         .withinDistance(0.0D, 3.0D)
/* 1498 */         .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_1, 0.0F)
/* 1499 */         .addNextBehavior(
/* 1500 */           CECombatBehaviors.Behavior.builder()
/* 1501 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1502 */           .withinDistance(0.0D, 3.0D)
/* 1503 */           .animationBehavior(AVAnimations.AXE_HEAVY_AUTO_2, 0.0F)
/* 1504 */           .addNextBehavior(
/* 1505 */             CECombatBehaviors.Behavior.builder()
/* 1506 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1507 */             .withinDistance(0.0D, 3.0D)
/* 1508 */             .animationBehavior(AVAnimations.AXE_FUN_SKILL, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1513 */     .newBehaviorRoot(
/* 1514 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1515 */       .priority(1.0D)
/* 1516 */       .weight(10.0D)
/* 1517 */       .maxCooldown(100)
/* 1518 */       .addFirstBehavior(
/* 1519 */         CECombatBehaviors.Behavior.builder()
/* 1520 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1521 */         .withinDistance(0.0D, 3.0D)
/* 1522 */         .animationBehavior(Animations.AXE_DASH, 0.0F))
/*      */       
/* 1524 */       .addFirstBehavior(
/* 1525 */         CECombatBehaviors.Behavior.builder()
/* 1526 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1527 */         .withinDistance(0.0D, 3.0D)
/* 1528 */         .animationBehavior(Animations.AXE_AIRSLASH, 0.0F))
/*      */       
/* 1530 */       .addFirstBehavior(
/* 1531 */         CECombatBehaviors.Behavior.builder()
/* 1532 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1533 */         .withinDistance(0.0D, 3.0D)
/* 1534 */         .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)))
/*      */ 
/*      */     
/* 1537 */     .newBehaviorRoot(
/* 1538 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1539 */       .priority(1.0D)
/* 1540 */       .weight(10.0D)
/* 1541 */       .maxCooldown(100)
/* 1542 */       .addFirstBehavior(
/* 1543 */         CECombatBehaviors.Behavior.builder()
/* 1544 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1545 */         .withinDistance(0.0D, 3.0D)
/* 1546 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1547 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1548 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1551 */     .newBehaviorRoot(
/* 1552 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1553 */       .priority(1.0D)
/* 1554 */       .weight(2.0D)
/* 1555 */       .maxCooldown(100)
/* 1556 */       .addFirstBehavior(
/* 1557 */         CECombatBehaviors.Behavior.builder()
/* 1558 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1559 */         .withinDistance(0.0D, 3.0D)
/* 1560 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1562 */       .addFirstBehavior(
/* 1563 */         CECombatBehaviors.Behavior.builder()
/* 1564 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1565 */         .withinDistance(0.0D, 3.0D)
/* 1566 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1568 */       .addFirstBehavior(
/* 1569 */         CECombatBehaviors.Behavior.builder()
/* 1570 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1571 */         .withinDistance(0.0D, 3.0D)
/* 1572 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1574 */       .addFirstBehavior(
/* 1575 */         CECombatBehaviors.Behavior.builder()
/* 1576 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1577 */         .withinDistance(0.0D, 3.0D)
/* 1578 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1580 */       .addFirstBehavior(
/* 1581 */         CECombatBehaviors.Behavior.builder()
/* 1582 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1583 */         .withinDistance(0.0D, 3.0D)
/* 1584 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1586 */       .addFirstBehavior(
/* 1587 */         CECombatBehaviors.Behavior.builder()
/* 1588 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1589 */         .withinDistance(0.0D, 3.0D)
/* 1590 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1592 */       .addFirstBehavior(
/* 1593 */         CECombatBehaviors.Behavior.builder()
/* 1594 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1595 */         .withinDistance(0.0D, 3.0D)
/* 1596 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1599 */     .newBehaviorRoot(
/* 1600 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1601 */       .priority(1.0D)
/* 1602 */       .weight(15.0D)
/* 1603 */       .addFirstBehavior(
/* 1604 */         CECombatBehaviors.Behavior.builder()
/* 1605 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1606 */         .withinDistance(0.0D, 3.0D)
/* 1607 */         .custom(CombatCommon::canPerformGuarding)
/* 1608 */         .guard(40)))
/*      */ 
/*      */     
/* 1611 */     .newBehaviorRoot(
/* 1612 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1613 */       .priority(1.0D)
/* 1614 */       .weight(10.0D)
/* 1615 */       .addFirstBehavior(
/* 1616 */         CECombatBehaviors.Behavior.builder()
/* 1617 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1618 */         .withinDistance(0.0D, 3.0D)
/* 1619 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1621 */       .addFirstBehavior(
/* 1622 */         CECombatBehaviors.Behavior.builder()
/* 1623 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1624 */         .withinDistance(0.0D, 3.0D)
/* 1625 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1628 */     .newBehaviorRoot(
/* 1629 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1630 */       .priority(1.0D)
/* 1631 */       .weight(40.0D)
/* 1632 */       .maxCooldown(160)
/* 1633 */       .addFirstBehavior(
/* 1634 */         CECombatBehaviors.Behavior.builder()
/* 1635 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1636 */         .custom(CombatCommon::canJump)
/* 1637 */         .withinDistance(5.0D, 14.0D)
/* 1638 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1639 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcAxe.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */