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
/*      */ public class PlayerNpcTachi
/*      */ {
/*   15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> TACHI = CECombatBehaviors.builder()
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
/*  106 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  107 */         .addNextBehavior(
/*  108 */           CECombatBehaviors.Behavior.builder()
/*  109 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  110 */           .withinDistance(0.0D, 3.0D)
/*  111 */           .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  112 */           .addNextBehavior(
/*  113 */             CECombatBehaviors.Behavior.builder()
/*  114 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  115 */             .withinDistance(0.0D, 3.0D)
/*  116 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  120 */       .addFirstBehavior(
/*  121 */         CECombatBehaviors.Behavior.builder()
/*  122 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  123 */         .withinDistance(0.0D, 3.0D)
/*  124 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  125 */         .addNextBehavior(
/*  126 */           CECombatBehaviors.Behavior.builder()
/*  127 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  128 */           .withinDistance(0.0D, 3.0D)
/*  129 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  130 */           .addNextBehavior(
/*  131 */             CECombatBehaviors.Behavior.builder()
/*  132 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  133 */             .withinDistance(0.0D, 4.0D)
/*  134 */             .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  135 */             .addNextBehavior(
/*  136 */               CECombatBehaviors.Behavior.builder()
/*  137 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  138 */               .withinDistance(0.0D, 4.0D)
/*  139 */               .animationBehavior(Animations.TACHI_DASH, 0.0F)
/*  140 */               .addNextBehavior(
/*  141 */                 CECombatBehaviors.Behavior.builder()
/*  142 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  143 */                 .withinDistance(0.0D, 5.0D)
/*  144 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  145 */                 .addNextBehavior(
/*  146 */                   CECombatBehaviors.Behavior.builder()
/*  147 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  148 */                   .withinDistance(0.0D, 5.0D)
/*  149 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  150 */                   .addNextBehavior(
/*  151 */                     CECombatBehaviors.Behavior.builder()
/*  152 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  153 */                     .withinDistance(0.0D, 5.0D)
/*  154 */                     .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  155 */                     .addNextBehavior(
/*  156 */                       CECombatBehaviors.Behavior.builder()
/*  157 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  158 */                       .withinDistance(0.0D, 5.0D)
/*  159 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  169 */       .addFirstBehavior(
/*  170 */         CECombatBehaviors.Behavior.builder()
/*  171 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  172 */         .withinDistance(0.0D, 3.0D)
/*  173 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  174 */         .addNextBehavior(
/*  175 */           CECombatBehaviors.Behavior.builder()
/*  176 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  177 */           .withinDistance(0.0D, 3.0D)
/*  178 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  179 */           .addNextBehavior(
/*  180 */             CECombatBehaviors.Behavior.builder()
/*  181 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  182 */             .withinDistance(0.0D, 4.0D)
/*  183 */             .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  184 */             .addNextBehavior(
/*  185 */               CECombatBehaviors.Behavior.builder()
/*  186 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  187 */               .withinDistance(0.0D, 4.0D)
/*  188 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  189 */               .addNextBehavior(
/*  190 */                 CECombatBehaviors.Behavior.builder()
/*  191 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  192 */                 .withinDistance(0.0D, 5.0D)
/*  193 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  194 */                 .addNextBehavior(
/*  195 */                   CECombatBehaviors.Behavior.builder()
/*  196 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  197 */                   .withinDistance(0.0D, 5.0D)
/*  198 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  199 */                   .addNextBehavior(
/*  200 */                     CECombatBehaviors.Behavior.builder()
/*  201 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  202 */                     .withinDistance(0.0D, 5.0D)
/*  203 */                     .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/*  204 */                     .addNextBehavior(
/*  205 */                       CECombatBehaviors.Behavior.builder()
/*  206 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  207 */                       .withinDistance(0.0D, 5.0D)
/*  208 */                       .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  209 */                       .addNextBehavior(
/*  210 */                         CECombatBehaviors.Behavior.builder()
/*  211 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  212 */                         .withinDistance(0.0D, 5.0D)
/*  213 */                         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
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
/*  224 */       .addFirstBehavior(
/*  225 */         CECombatBehaviors.Behavior.builder()
/*  226 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  227 */         .withinDistance(0.0D, 3.0D)
/*  228 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  229 */         .addNextBehavior(
/*  230 */           CECombatBehaviors.Behavior.builder()
/*  231 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  232 */           .withinDistance(0.0D, 3.0D)
/*  233 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  234 */           .addNextBehavior(
/*  235 */             CECombatBehaviors.Behavior.builder()
/*  236 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  237 */             .withinDistance(0.0D, 4.0D)
/*  238 */             .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  239 */             .addNextBehavior(
/*  240 */               CECombatBehaviors.Behavior.builder()
/*  241 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  242 */               .withinDistance(0.0D, 4.0D)
/*  243 */               .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/*  244 */               .addNextBehavior(
/*  245 */                 CECombatBehaviors.Behavior.builder()
/*  246 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  247 */                 .withinDistance(0.0D, 5.0D)
/*  248 */                 .animationBehavior(Animations.TACHI_DASH, 0.0F)
/*  249 */                 .addNextBehavior(
/*  250 */                   CECombatBehaviors.Behavior.builder()
/*  251 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  252 */                   .withinDistance(0.0D, 5.0D)
/*  253 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  254 */                   .addNextBehavior(
/*  255 */                     CECombatBehaviors.Behavior.builder()
/*  256 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  257 */                     .withinDistance(0.0D, 5.0D)
/*  258 */                     .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/*  259 */                     .addNextBehavior(
/*  260 */                       CECombatBehaviors.Behavior.builder()
/*  261 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  262 */                       .withinDistance(0.0D, 5.0D)
/*  263 */                       .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  264 */                       .addNextBehavior(
/*  265 */                         CECombatBehaviors.Behavior.builder()
/*  266 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  267 */                         .withinDistance(0.0D, 5.0D)
/*  268 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/*  279 */       .addFirstBehavior(
/*  280 */         CECombatBehaviors.Behavior.builder()
/*  281 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  282 */         .withinDistance(0.0D, 3.0D)
/*  283 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  284 */         .addNextBehavior(
/*  285 */           CECombatBehaviors.Behavior.builder()
/*  286 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  287 */           .withinDistance(0.0D, 3.0D)
/*  288 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  289 */           .addNextBehavior(
/*  290 */             CECombatBehaviors.Behavior.builder()
/*  291 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  292 */             .withinDistance(0.0D, 4.0D)
/*  293 */             .animationBehavior(Animations.TACHI_DASH, 0.0F)
/*  294 */             .addNextBehavior(
/*  295 */               CECombatBehaviors.Behavior.builder()
/*  296 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  297 */               .withinDistance(0.0D, 4.0D)
/*  298 */               .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  299 */               .addNextBehavior(
/*  300 */                 CECombatBehaviors.Behavior.builder()
/*  301 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  302 */                 .withinDistance(0.0D, 5.0D)
/*  303 */                 .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  304 */                 .addNextBehavior(
/*  305 */                   CECombatBehaviors.Behavior.builder()
/*  306 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  307 */                   .withinDistance(0.0D, 5.0D)
/*  308 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  309 */                   .addNextBehavior(
/*  310 */                     CECombatBehaviors.Behavior.builder()
/*  311 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  312 */                     .withinDistance(0.0D, 5.0D)
/*  313 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  322 */       .addFirstBehavior(
/*  323 */         CECombatBehaviors.Behavior.builder()
/*  324 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  325 */         .withinDistance(0.0D, 3.0D)
/*  326 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  327 */         .addNextBehavior(
/*  328 */           CECombatBehaviors.Behavior.builder()
/*  329 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  330 */           .withinDistance(0.0D, 3.0D)
/*  331 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  332 */           .addNextBehavior(
/*  333 */             CECombatBehaviors.Behavior.builder()
/*  334 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  335 */             .withinDistance(0.0D, 4.0D)
/*  336 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/*  337 */             .addNextBehavior(
/*  338 */               CECombatBehaviors.Behavior.builder()
/*  339 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  340 */               .withinDistance(0.0D, 4.0D)
/*  341 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  342 */               .addNextBehavior(
/*  343 */                 CECombatBehaviors.Behavior.builder()
/*  344 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  345 */                 .withinDistance(0.0D, 5.0D)
/*  346 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  347 */                 .addNextBehavior(
/*  348 */                   CECombatBehaviors.Behavior.builder()
/*  349 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  350 */                   .withinDistance(0.0D, 5.0D)
/*  351 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  352 */                   .addNextBehavior(
/*  353 */                     CECombatBehaviors.Behavior.builder()
/*  354 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  355 */                     .withinDistance(0.0D, 5.0D)
/*  356 */                     .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  357 */                     .addNextBehavior(
/*  358 */                       CECombatBehaviors.Behavior.builder()
/*  359 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  360 */                       .withinDistance(0.0D, 5.0D)
/*  361 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  371 */       .addFirstBehavior(
/*  372 */         CECombatBehaviors.Behavior.builder()
/*  373 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  374 */         .withinDistance(0.0D, 3.0D)
/*  375 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/*  376 */         .addNextBehavior(
/*  377 */           CECombatBehaviors.Behavior.builder()
/*  378 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  379 */           .withinDistance(0.0D, 3.0D)
/*  380 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  381 */           .addNextBehavior(
/*  382 */             CECombatBehaviors.Behavior.builder()
/*  383 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  384 */             .withinDistance(0.0D, 4.0D)
/*  385 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  386 */             .addNextBehavior(
/*  387 */               CECombatBehaviors.Behavior.builder()
/*  388 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  389 */               .withinDistance(0.0D, 4.0D)
/*  390 */               .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  391 */               .addNextBehavior(
/*  392 */                 CECombatBehaviors.Behavior.builder()
/*  393 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  394 */                 .withinDistance(0.0D, 5.0D)
/*  395 */                 .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  396 */                 .addNextBehavior(
/*  397 */                   CECombatBehaviors.Behavior.builder()
/*  398 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  399 */                   .withinDistance(0.0D, 5.0D)
/*  400 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  401 */                   .addNextBehavior(
/*  402 */                     CECombatBehaviors.Behavior.builder()
/*  403 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  404 */                     .withinDistance(0.0D, 5.0D)
/*  405 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  414 */       .addFirstBehavior(
/*  415 */         CECombatBehaviors.Behavior.builder()
/*  416 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  417 */         .withinDistance(0.0D, 3.0D)
/*  418 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  419 */         .addNextBehavior(
/*  420 */           CECombatBehaviors.Behavior.builder()
/*  421 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  422 */           .withinDistance(0.0D, 3.0D)
/*  423 */           .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  424 */           .addNextBehavior(
/*  425 */             CECombatBehaviors.Behavior.builder()
/*  426 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  427 */             .withinDistance(0.0D, 4.0D)
/*  428 */             .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  429 */             .addNextBehavior(
/*  430 */               CECombatBehaviors.Behavior.builder()
/*  431 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  432 */               .withinDistance(0.0D, 4.0D)
/*  433 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  434 */               .addNextBehavior(
/*  435 */                 CECombatBehaviors.Behavior.builder()
/*  436 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  437 */                 .withinDistance(0.0D, 5.0D)
/*  438 */                 .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  439 */                 .addNextBehavior(
/*  440 */                   CECombatBehaviors.Behavior.builder()
/*  441 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  442 */                   .withinDistance(0.0D, 5.0D)
/*  443 */                   .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  444 */                   .addNextBehavior(
/*  445 */                     CECombatBehaviors.Behavior.builder()
/*  446 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  447 */                     .withinDistance(0.0D, 5.0D)
/*  448 */                     .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  449 */                     .addNextBehavior(
/*  450 */                       CECombatBehaviors.Behavior.builder()
/*  451 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  452 */                       .withinDistance(0.0D, 5.0D)
/*  453 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
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
/*  467 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  468 */         .addNextBehavior(
/*  469 */           CECombatBehaviors.Behavior.builder()
/*  470 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  471 */           .withinDistance(0.0D, 3.0D)
/*  472 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/*  473 */           .addNextBehavior(
/*  474 */             CECombatBehaviors.Behavior.builder()
/*  475 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  476 */             .withinDistance(0.0D, 4.0D)
/*  477 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  478 */             .addNextBehavior(
/*  479 */               CECombatBehaviors.Behavior.builder()
/*  480 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  481 */               .withinDistance(0.0D, 4.0D)
/*  482 */               .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  483 */               .addNextBehavior(
/*  484 */                 CECombatBehaviors.Behavior.builder()
/*  485 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */                 .withinDistance(0.0D, 5.0D)
/*  487 */                 .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/*  488 */                 .addNextBehavior(
/*  489 */                   CECombatBehaviors.Behavior.builder()
/*  490 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  491 */                   .withinDistance(0.0D, 5.0D)
/*  492 */                   .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  493 */                   .addNextBehavior(
/*  494 */                     CECombatBehaviors.Behavior.builder()
/*  495 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  496 */                     .withinDistance(0.0D, 5.0D)
/*  497 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  498 */                     .addNextBehavior(
/*  499 */                       CECombatBehaviors.Behavior.builder()
/*  500 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  501 */                       .withinDistance(0.0D, 5.0D)
/*  502 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  512 */       .addFirstBehavior(
/*  513 */         CECombatBehaviors.Behavior.builder()
/*  514 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  515 */         .withinDistance(0.0D, 3.0D)
/*  516 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  517 */         .addNextBehavior(
/*  518 */           CECombatBehaviors.Behavior.builder()
/*  519 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  520 */           .withinDistance(0.0D, 3.0D)
/*  521 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  522 */           .addNextBehavior(
/*  523 */             CECombatBehaviors.Behavior.builder()
/*  524 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  525 */             .withinDistance(0.0D, 4.0D)
/*  526 */             .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  527 */             .addNextBehavior(
/*  528 */               CECombatBehaviors.Behavior.builder()
/*  529 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  530 */               .withinDistance(0.0D, 4.0D)
/*  531 */               .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  532 */               .addNextBehavior(
/*  533 */                 CECombatBehaviors.Behavior.builder()
/*  534 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  535 */                 .withinDistance(0.0D, 5.0D)
/*  536 */                 .animationBehavior(Animations.TACHI_DASH, 0.0F)
/*  537 */                 .addNextBehavior(
/*  538 */                   CECombatBehaviors.Behavior.builder()
/*  539 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  540 */                   .withinDistance(0.0D, 5.0D)
/*  541 */                   .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  542 */                   .addNextBehavior(
/*  543 */                     CECombatBehaviors.Behavior.builder()
/*  544 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  545 */                     .withinDistance(0.0D, 5.0D)
/*  546 */                     .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/*  547 */                     .addNextBehavior(
/*  548 */                       CECombatBehaviors.Behavior.builder()
/*  549 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  550 */                       .withinDistance(0.0D, 5.0D)
/*  551 */                       .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  552 */                       .addNextBehavior(
/*  553 */                         CECombatBehaviors.Behavior.builder()
/*  554 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  555 */                         .withinDistance(0.0D, 5.0D)
/*  556 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/*  567 */       .addFirstBehavior(
/*  568 */         CECombatBehaviors.Behavior.builder()
/*  569 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  570 */         .withinDistance(0.0D, 3.0D)
/*  571 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  572 */         .addNextBehavior(
/*  573 */           CECombatBehaviors.Behavior.builder()
/*  574 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  575 */           .withinDistance(0.0D, 3.0D)
/*  576 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  577 */           .addNextBehavior(
/*  578 */             CECombatBehaviors.Behavior.builder()
/*  579 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  580 */             .withinDistance(0.0D, 4.0D)
/*  581 */             .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  582 */             .addNextBehavior(
/*  583 */               CECombatBehaviors.Behavior.builder()
/*  584 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  585 */               .withinDistance(0.0D, 4.0D)
/*  586 */               .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/*  587 */               .addNextBehavior(
/*  588 */                 CECombatBehaviors.Behavior.builder()
/*  589 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  590 */                 .withinDistance(0.0D, 5.0D)
/*  591 */                 .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  592 */                 .addNextBehavior(
/*  593 */                   CECombatBehaviors.Behavior.builder()
/*  594 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  595 */                   .withinDistance(0.0D, 5.0D)
/*  596 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  597 */                   .addNextBehavior(
/*  598 */                     CECombatBehaviors.Behavior.builder()
/*  599 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  600 */                     .withinDistance(0.0D, 5.0D)
/*  601 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  610 */       .addFirstBehavior(
/*  611 */         CECombatBehaviors.Behavior.builder()
/*  612 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  613 */         .withinDistance(0.0D, 3.0D)
/*  614 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/*  615 */         .addNextBehavior(
/*  616 */           CECombatBehaviors.Behavior.builder()
/*  617 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  618 */           .withinDistance(0.0D, 3.0D)
/*  619 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/*  620 */           .addNextBehavior(
/*  621 */             CECombatBehaviors.Behavior.builder()
/*  622 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  623 */             .withinDistance(0.0D, 4.0D)
/*  624 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  625 */             .addNextBehavior(
/*  626 */               CECombatBehaviors.Behavior.builder()
/*  627 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  628 */               .withinDistance(0.0D, 4.0D)
/*  629 */               .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  630 */               .addNextBehavior(
/*  631 */                 CECombatBehaviors.Behavior.builder()
/*  632 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  633 */                 .withinDistance(0.0D, 5.0D)
/*  634 */                 .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  635 */                 .addNextBehavior(
/*  636 */                   CECombatBehaviors.Behavior.builder()
/*  637 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  638 */                   .withinDistance(0.0D, 5.0D)
/*  639 */                   .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/*  640 */                   .addNextBehavior(
/*  641 */                     CECombatBehaviors.Behavior.builder()
/*  642 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  643 */                     .withinDistance(0.0D, 5.0D)
/*  644 */                     .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  645 */                     .addNextBehavior(
/*  646 */                       CECombatBehaviors.Behavior.builder()
/*  647 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  648 */                       .withinDistance(0.0D, 5.0D)
/*  649 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  659 */       .addFirstBehavior(
/*  660 */         CECombatBehaviors.Behavior.builder()
/*  661 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  662 */         .withinDistance(0.0D, 3.0D)
/*  663 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  664 */         .addNextBehavior(
/*  665 */           CECombatBehaviors.Behavior.builder()
/*  666 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  667 */           .withinDistance(0.0D, 3.0D)
/*  668 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  669 */           .addNextBehavior(
/*  670 */             CECombatBehaviors.Behavior.builder()
/*  671 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  672 */             .withinDistance(0.0D, 4.0D)
/*  673 */             .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  674 */             .addNextBehavior(
/*  675 */               CECombatBehaviors.Behavior.builder()
/*  676 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  677 */               .withinDistance(0.0D, 4.0D)
/*  678 */               .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  679 */               .addNextBehavior(
/*  680 */                 CECombatBehaviors.Behavior.builder()
/*  681 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  682 */                 .withinDistance(0.0D, 5.0D)
/*  683 */                 .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  684 */                 .addNextBehavior(
/*  685 */                   CECombatBehaviors.Behavior.builder()
/*  686 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  687 */                   .withinDistance(0.0D, 5.0D)
/*  688 */                   .animationBehavior(Animations.TACHI_DASH, 0.0F)
/*  689 */                   .addNextBehavior(
/*  690 */                     CECombatBehaviors.Behavior.builder()
/*  691 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  692 */                     .withinDistance(0.0D, 5.0D)
/*  693 */                     .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  694 */                     .addNextBehavior(
/*  695 */                       CECombatBehaviors.Behavior.builder()
/*  696 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  697 */                       .withinDistance(0.0D, 5.0D)
/*  698 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  708 */       .addFirstBehavior(
/*  709 */         CECombatBehaviors.Behavior.builder()
/*  710 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  711 */         .withinDistance(0.0D, 3.0D)
/*  712 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  713 */         .addNextBehavior(
/*  714 */           CECombatBehaviors.Behavior.builder()
/*  715 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  716 */           .withinDistance(0.0D, 3.0D)
/*  717 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  718 */           .addNextBehavior(
/*  719 */             CECombatBehaviors.Behavior.builder()
/*  720 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  721 */             .withinDistance(0.0D, 4.0D)
/*  722 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  723 */             .addNextBehavior(
/*  724 */               CECombatBehaviors.Behavior.builder()
/*  725 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  726 */               .withinDistance(0.0D, 4.0D)
/*  727 */               .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  728 */               .addNextBehavior(
/*  729 */                 CECombatBehaviors.Behavior.builder()
/*  730 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  731 */                 .withinDistance(0.0D, 5.0D)
/*  732 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  733 */                 .addNextBehavior(
/*  734 */                   CECombatBehaviors.Behavior.builder()
/*  735 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  736 */                   .withinDistance(0.0D, 5.0D)
/*  737 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  738 */                   .addNextBehavior(
/*  739 */                     CECombatBehaviors.Behavior.builder()
/*  740 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  741 */                     .withinDistance(0.0D, 5.0D)
/*  742 */                     .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  743 */                     .addNextBehavior(
/*  744 */                       CECombatBehaviors.Behavior.builder()
/*  745 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  746 */                       .withinDistance(0.0D, 5.0D)
/*  747 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  757 */       .addFirstBehavior(
/*  758 */         CECombatBehaviors.Behavior.builder()
/*  759 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  760 */         .withinDistance(0.0D, 3.0D)
/*  761 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  762 */         .addNextBehavior(
/*  763 */           CECombatBehaviors.Behavior.builder()
/*  764 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  765 */           .withinDistance(0.0D, 3.0D)
/*  766 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/*  767 */           .addNextBehavior(
/*  768 */             CECombatBehaviors.Behavior.builder()
/*  769 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  770 */             .withinDistance(0.0D, 4.0D)
/*  771 */             .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  772 */             .addNextBehavior(
/*  773 */               CECombatBehaviors.Behavior.builder()
/*  774 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  775 */               .withinDistance(0.0D, 4.0D)
/*  776 */               .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  777 */               .addNextBehavior(
/*  778 */                 CECombatBehaviors.Behavior.builder()
/*  779 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  780 */                 .withinDistance(0.0D, 5.0D)
/*  781 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  782 */                 .addNextBehavior(
/*  783 */                   CECombatBehaviors.Behavior.builder()
/*  784 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  785 */                   .withinDistance(0.0D, 5.0D)
/*  786 */                   .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/*  787 */                   .addNextBehavior(
/*  788 */                     CECombatBehaviors.Behavior.builder()
/*  789 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  790 */                     .withinDistance(0.0D, 5.0D)
/*  791 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  792 */                     .addNextBehavior(
/*  793 */                       CECombatBehaviors.Behavior.builder()
/*  794 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  795 */                       .withinDistance(0.0D, 5.0D)
/*  796 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  806 */       .addFirstBehavior(
/*  807 */         CECombatBehaviors.Behavior.builder()
/*  808 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  809 */         .withinDistance(0.0D, 3.0D)
/*  810 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/*  811 */         .addNextBehavior(
/*  812 */           CECombatBehaviors.Behavior.builder()
/*  813 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  814 */           .withinDistance(0.0D, 3.0D)
/*  815 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  816 */           .addNextBehavior(
/*  817 */             CECombatBehaviors.Behavior.builder()
/*  818 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  819 */             .withinDistance(0.0D, 4.0D)
/*  820 */             .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/*  821 */             .addNextBehavior(
/*  822 */               CECombatBehaviors.Behavior.builder()
/*  823 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  824 */               .withinDistance(0.0D, 4.0D)
/*  825 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/*  826 */               .addNextBehavior(
/*  827 */                 CECombatBehaviors.Behavior.builder()
/*  828 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  829 */                 .withinDistance(0.0D, 5.0D)
/*  830 */                 .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/*  831 */                 .addNextBehavior(
/*  832 */                   CECombatBehaviors.Behavior.builder()
/*  833 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  834 */                   .withinDistance(0.0D, 5.0D)
/*  835 */                   .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  836 */                   .addNextBehavior(
/*  837 */                     CECombatBehaviors.Behavior.builder()
/*  838 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  839 */                     .withinDistance(0.0D, 5.0D)
/*  840 */                     .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  841 */                     .addNextBehavior(
/*  842 */                       CECombatBehaviors.Behavior.builder()
/*  843 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  844 */                       .withinDistance(0.0D, 5.0D)
/*  845 */                       .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  846 */                       .addNextBehavior(
/*  847 */                         CECombatBehaviors.Behavior.builder()
/*  848 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  849 */                         .withinDistance(0.0D, 5.0D)
/*  850 */                         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))))
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
/*  862 */     .newBehaviorRoot(
/*  863 */       CECombatBehaviors.BehaviorRoot.builder()
/*  864 */       .priority(1.0D)
/*  865 */       .weight(20.0D)
/*  866 */       .maxCooldown(100)
/*  867 */       .addFirstBehavior(
/*  868 */         CECombatBehaviors.Behavior.builder()
/*  869 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  870 */         .withinDistance(0.0D, 3.0D)
/*  871 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  872 */         .addNextBehavior(
/*  873 */           CECombatBehaviors.Behavior.builder()
/*  874 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  875 */           .withinDistance(0.0D, 3.0D)
/*  876 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  877 */           .addNextBehavior(
/*  878 */             CECombatBehaviors.Behavior.builder()
/*  879 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  880 */             .withinDistance(0.0D, 3.0D)
/*  881 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  886 */     .newBehaviorRoot(
/*  887 */       CECombatBehaviors.BehaviorRoot.builder()
/*  888 */       .priority(1.0D)
/*  889 */       .weight(10.0D)
/*  890 */       .maxCooldown(100)
/*  891 */       .addFirstBehavior(
/*  892 */         CECombatBehaviors.Behavior.builder()
/*  893 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  894 */         .withinDistance(0.0D, 3.0D)
/*  895 */         .animationBehavior(Animations.TACHI_DASH, 0.0F))
/*      */       
/*  897 */       .addFirstBehavior(
/*  898 */         CECombatBehaviors.Behavior.builder()
/*  899 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  900 */         .withinDistance(0.0D, 3.0D)
/*  901 */         .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F))
/*      */       
/*  903 */       .addFirstBehavior(
/*  904 */         CECombatBehaviors.Behavior.builder()
/*  905 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  906 */         .withinDistance(0.0D, 3.0D)
/*  907 */         .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/*  908 */         .addNextBehavior(
/*  909 */           CECombatBehaviors.Behavior.builder()
/*  910 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  911 */           .withinDistance(0.0D, 3.0D)
/*  912 */           .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/*  913 */           .addNextBehavior(
/*  914 */             CECombatBehaviors.Behavior.builder()
/*  915 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  916 */             .withinDistance(0.0D, 3.0D)
/*  917 */             .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  922 */     .newBehaviorRoot(
/*  923 */       CECombatBehaviors.BehaviorRoot.builder()
/*  924 */       .priority(1.0D)
/*  925 */       .weight(10.0D)
/*  926 */       .maxCooldown(40)
/*  927 */       .addFirstBehavior(
/*  928 */         CECombatBehaviors.Behavior.builder()
/*  929 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  930 */         .withinDistance(0.0D, 3.0D)
/*  931 */         .custom(CombatCommon::canThrowEnderPearl)
/*  932 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  933 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  936 */     .newBehaviorRoot(
/*  937 */       CECombatBehaviors.BehaviorRoot.builder()
/*  938 */       .priority(1.0D)
/*  939 */       .weight(2.0D)
/*  940 */       .maxCooldown(100)
/*  941 */       .addFirstBehavior(
/*  942 */         CECombatBehaviors.Behavior.builder()
/*  943 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  944 */         .withinDistance(0.0D, 3.0D)
/*  945 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  947 */       .addFirstBehavior(
/*  948 */         CECombatBehaviors.Behavior.builder()
/*  949 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  950 */         .withinDistance(0.0D, 3.0D)
/*  951 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  953 */       .addFirstBehavior(
/*  954 */         CECombatBehaviors.Behavior.builder()
/*  955 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  956 */         .withinDistance(0.0D, 3.0D)
/*  957 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  959 */       .addFirstBehavior(
/*  960 */         CECombatBehaviors.Behavior.builder()
/*  961 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  962 */         .withinDistance(0.0D, 3.0D)
/*  963 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  965 */       .addFirstBehavior(
/*  966 */         CECombatBehaviors.Behavior.builder()
/*  967 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  968 */         .withinDistance(0.0D, 3.0D)
/*  969 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  971 */       .addFirstBehavior(
/*  972 */         CECombatBehaviors.Behavior.builder()
/*  973 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  974 */         .withinDistance(0.0D, 3.0D)
/*  975 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  977 */       .addFirstBehavior(
/*  978 */         CECombatBehaviors.Behavior.builder()
/*  979 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  980 */         .withinDistance(0.0D, 3.0D)
/*  981 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  984 */     .newBehaviorRoot(
/*  985 */       CECombatBehaviors.BehaviorRoot.builder()
/*  986 */       .priority(1.0D)
/*  987 */       .weight(15.0D)
/*  988 */       .addFirstBehavior(
/*  989 */         CECombatBehaviors.Behavior.builder()
/*  990 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  991 */         .withinDistance(0.0D, 3.0D)
/*  992 */         .custom(CombatCommon::canPerformGuarding)
/*  993 */         .guard(40)))
/*      */ 
/*      */     
/*  996 */     .newBehaviorRoot(
/*  997 */       CECombatBehaviors.BehaviorRoot.builder()
/*  998 */       .priority(1.0D)
/*  999 */       .weight(10.0D)
/* 1000 */       .addFirstBehavior(
/* 1001 */         CECombatBehaviors.Behavior.builder()
/* 1002 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1003 */         .withinDistance(0.0D, 3.0D)
/* 1004 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1006 */       .addFirstBehavior(
/* 1007 */         CECombatBehaviors.Behavior.builder()
/* 1008 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1009 */         .withinDistance(0.0D, 3.0D)
/* 1010 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1013 */     .newBehaviorRoot(
/* 1014 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1015 */       .priority(1.0D)
/* 1016 */       .weight(40.0D)
/* 1017 */       .maxCooldown(160)
/* 1018 */       .addFirstBehavior(
/* 1019 */         CECombatBehaviors.Behavior.builder()
/* 1020 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1021 */         .custom(CombatCommon::canJump)
/* 1022 */         .withinDistance(5.0D, 14.0D)
/* 1023 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1024 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 1028 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_TACHI = CECombatBehaviors.builder()
/* 1029 */     .newBehaviorRoot(
/* 1030 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1031 */       .priority(4.0D)
/* 1032 */       .weight(1000.0D)
/* 1033 */       .maxCooldown(0)
/* 1034 */       .addFirstBehavior(
/* 1035 */         CECombatBehaviors.Behavior.builder()
/* 1036 */         .custom(CombatCommon::canExecute)
/* 1037 */         .withinDistance(0.0D, 5.0D)
/* 1038 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 1039 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 1042 */     .newBehaviorRoot(
/* 1043 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1044 */       .priority(3.0D)
/* 1045 */       .weight(1000.0D)
/* 1046 */       .maxCooldown(0)
/* 1047 */       .addFirstBehavior(
/* 1048 */         CECombatBehaviors.Behavior.builder()
/* 1049 */         .custom(CombatCommon::canEscape)
/* 1050 */         .withinDistance(0.0D, 8.0D)
/* 1051 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1052 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 1054 */       .addFirstBehavior(
/* 1055 */         CECombatBehaviors.Behavior.builder()
/* 1056 */         .custom(CombatCommon::canEscape)
/* 1057 */         .withinDistance(0.0D, 48.0D)
/* 1058 */         .guard(40)))
/*      */ 
/*      */     
/* 1061 */     .newBehaviorRoot(
/* 1062 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1063 */       .priority(2.0D)
/* 1064 */       .weight(70.0D)
/* 1065 */       .maxCooldown(0)
/* 1066 */       .addFirstBehavior(
/* 1067 */         CECombatBehaviors.Behavior.builder()
/* 1068 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 1069 */         .custom(CombatCommon::canPerformEating)
/* 1070 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1071 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 1074 */     .newBehaviorRoot(
/* 1075 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1076 */       .priority(2.0D)
/* 1077 */       .weight(100.0D)
/* 1078 */       .maxCooldown(120)
/* 1079 */       .addFirstBehavior(
/* 1080 */         CECombatBehaviors.Behavior.builder()
/* 1081 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1082 */         .custom(CombatCommon::canSwapToBow)
/* 1083 */         .withinDistance(7.0D, 14.0D)
/* 1084 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1085 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 1087 */       .addFirstBehavior(
/* 1088 */         CECombatBehaviors.Behavior.builder()
/* 1089 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1090 */         .custom(CombatCommon::canSwapToBow)
/* 1091 */         .withinDistance(7.0D, 14.0D)
/* 1092 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1093 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 1096 */     .newBehaviorRoot(
/* 1097 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1098 */       .priority(2.0D)
/* 1099 */       .weight(80.0D)
/* 1100 */       .maxCooldown(120)
/* 1101 */       .addFirstBehavior(
/* 1102 */         CECombatBehaviors.Behavior.builder()
/* 1103 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1104 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1105 */         .withinDistance(7.0D, 48.0D)
/* 1106 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1107 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 1110 */     .newBehaviorRoot(
/* 1111 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1112 */       .priority(1.0D)
/* 1113 */       .weight(40.0D)
/* 1114 */       .maxCooldown(20)
/* 1115 */       .addFirstBehavior(
/* 1116 */         CECombatBehaviors.Behavior.builder()
/* 1117 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1118 */         .withinDistance(0.0D, 3.0D)
/* 1119 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/* 1120 */         .addNextBehavior(
/* 1121 */           CECombatBehaviors.Behavior.builder()
/* 1122 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1123 */           .withinDistance(0.0D, 3.0D)
/* 1124 */           .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1125 */           .addNextBehavior(
/* 1126 */             CECombatBehaviors.Behavior.builder()
/* 1127 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1128 */             .withinDistance(0.0D, 3.0D)
/* 1129 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 1130 */             .addNextBehavior(
/* 1131 */               CECombatBehaviors.Behavior.builder()
/* 1132 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1133 */               .withinDistance(0.0D, 3.0D)
/* 1134 */               .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 1135 */               .addNextBehavior(
/* 1136 */                 CECombatBehaviors.Behavior.builder()
/* 1137 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1138 */                 .withinDistance(0.0D, 3.0D)
/* 1139 */                 .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1145 */       .addFirstBehavior(
/* 1146 */         CECombatBehaviors.Behavior.builder()
/* 1147 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1148 */         .withinDistance(0.0D, 3.0D)
/* 1149 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/* 1150 */         .addNextBehavior(
/* 1151 */           CECombatBehaviors.Behavior.builder()
/* 1152 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1153 */           .withinDistance(0.0D, 3.0D)
/* 1154 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1155 */           .addNextBehavior(
/* 1156 */             CECombatBehaviors.Behavior.builder()
/* 1157 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1158 */             .withinDistance(0.0D, 4.0D)
/* 1159 */             .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1160 */             .addNextBehavior(
/* 1161 */               CECombatBehaviors.Behavior.builder()
/* 1162 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1163 */               .withinDistance(0.0D, 4.0D)
/* 1164 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1165 */               .addNextBehavior(
/* 1166 */                 CECombatBehaviors.Behavior.builder()
/* 1167 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1168 */                 .withinDistance(0.0D, 5.0D)
/* 1169 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1170 */                 .addNextBehavior(
/* 1171 */                   CECombatBehaviors.Behavior.builder()
/* 1172 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1173 */                   .withinDistance(0.0D, 5.0D)
/* 1174 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1175 */                   .addNextBehavior(
/* 1176 */                     CECombatBehaviors.Behavior.builder()
/* 1177 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1178 */                     .withinDistance(0.0D, 5.0D)
/* 1179 */                     .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1180 */                     .addNextBehavior(
/* 1181 */                       CECombatBehaviors.Behavior.builder()
/* 1182 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1183 */                       .withinDistance(0.0D, 5.0D)
/* 1184 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1194 */       .addFirstBehavior(
/* 1195 */         CECombatBehaviors.Behavior.builder()
/* 1196 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1197 */         .withinDistance(0.0D, 3.0D)
/* 1198 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/* 1199 */         .addNextBehavior(
/* 1200 */           CECombatBehaviors.Behavior.builder()
/* 1201 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1202 */           .withinDistance(0.0D, 3.0D)
/* 1203 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1204 */           .addNextBehavior(
/* 1205 */             CECombatBehaviors.Behavior.builder()
/* 1206 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1207 */             .withinDistance(0.0D, 4.0D)
/* 1208 */             .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1209 */             .addNextBehavior(
/* 1210 */               CECombatBehaviors.Behavior.builder()
/* 1211 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1212 */               .withinDistance(0.0D, 4.0D)
/* 1213 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1214 */               .addNextBehavior(
/* 1215 */                 CECombatBehaviors.Behavior.builder()
/* 1216 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1217 */                 .withinDistance(0.0D, 5.0D)
/* 1218 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1219 */                 .addNextBehavior(
/* 1220 */                   CECombatBehaviors.Behavior.builder()
/* 1221 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1222 */                   .withinDistance(0.0D, 5.0D)
/* 1223 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1224 */                   .addNextBehavior(
/* 1225 */                     CECombatBehaviors.Behavior.builder()
/* 1226 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1227 */                     .withinDistance(0.0D, 5.0D)
/* 1228 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1229 */                     .addNextBehavior(
/* 1230 */                       CECombatBehaviors.Behavior.builder()
/* 1231 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1232 */                       .withinDistance(0.0D, 5.0D)
/* 1233 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1243 */       .addFirstBehavior(
/* 1244 */         CECombatBehaviors.Behavior.builder()
/* 1245 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1246 */         .withinDistance(0.0D, 3.0D)
/* 1247 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1248 */         .addNextBehavior(
/* 1249 */           CECombatBehaviors.Behavior.builder()
/* 1250 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1251 */           .withinDistance(0.0D, 3.0D)
/* 1252 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1253 */           .addNextBehavior(
/* 1254 */             CECombatBehaviors.Behavior.builder()
/* 1255 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1256 */             .withinDistance(0.0D, 4.0D)
/* 1257 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 1258 */             .addNextBehavior(
/* 1259 */               CECombatBehaviors.Behavior.builder()
/* 1260 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1261 */               .withinDistance(0.0D, 4.0D)
/* 1262 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1263 */               .addNextBehavior(
/* 1264 */                 CECombatBehaviors.Behavior.builder()
/* 1265 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1266 */                 .withinDistance(0.0D, 5.0D)
/* 1267 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1268 */                 .addNextBehavior(
/* 1269 */                   CECombatBehaviors.Behavior.builder()
/* 1270 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1271 */                   .withinDistance(0.0D, 5.0D)
/* 1272 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1273 */                   .addNextBehavior(
/* 1274 */                     CECombatBehaviors.Behavior.builder()
/* 1275 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1276 */                     .withinDistance(0.0D, 5.0D)
/* 1277 */                     .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1278 */                     .addNextBehavior(
/* 1279 */                       CECombatBehaviors.Behavior.builder()
/* 1280 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1281 */                       .withinDistance(0.0D, 5.0D)
/* 1282 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1292 */       .addFirstBehavior(
/* 1293 */         CECombatBehaviors.Behavior.builder()
/* 1294 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1295 */         .withinDistance(0.0D, 3.0D)
/* 1296 */         .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 1297 */         .addNextBehavior(
/* 1298 */           CECombatBehaviors.Behavior.builder()
/* 1299 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1300 */           .withinDistance(0.0D, 3.0D)
/* 1301 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1302 */           .addNextBehavior(
/* 1303 */             CECombatBehaviors.Behavior.builder()
/* 1304 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1305 */             .withinDistance(0.0D, 4.0D)
/* 1306 */             .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1307 */             .addNextBehavior(
/* 1308 */               CECombatBehaviors.Behavior.builder()
/* 1309 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1310 */               .withinDistance(0.0D, 4.0D)
/* 1311 */               .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1312 */               .addNextBehavior(
/* 1313 */                 CECombatBehaviors.Behavior.builder()
/* 1314 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1315 */                 .withinDistance(0.0D, 5.0D)
/* 1316 */                 .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1317 */                 .addNextBehavior(
/* 1318 */                   CECombatBehaviors.Behavior.builder()
/* 1319 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1320 */                   .withinDistance(0.0D, 5.0D)
/* 1321 */                   .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/* 1322 */                   .addNextBehavior(
/* 1323 */                     CECombatBehaviors.Behavior.builder()
/* 1324 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1325 */                     .withinDistance(0.0D, 5.0D)
/* 1326 */                     .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1327 */                     .addNextBehavior(
/* 1328 */                       CECombatBehaviors.Behavior.builder()
/* 1329 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1330 */                       .withinDistance(0.0D, 5.0D)
/* 1331 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1341 */       .addFirstBehavior(
/* 1342 */         CECombatBehaviors.Behavior.builder()
/* 1343 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1344 */         .withinDistance(0.0D, 3.0D)
/* 1345 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/* 1346 */         .addNextBehavior(
/* 1347 */           CECombatBehaviors.Behavior.builder()
/* 1348 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1349 */           .withinDistance(0.0D, 3.0D)
/* 1350 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1351 */           .addNextBehavior(
/* 1352 */             CECombatBehaviors.Behavior.builder()
/* 1353 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1354 */             .withinDistance(0.0D, 4.0D)
/* 1355 */             .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1356 */             .addNextBehavior(
/* 1357 */               CECombatBehaviors.Behavior.builder()
/* 1358 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1359 */               .withinDistance(0.0D, 4.0D)
/* 1360 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1361 */               .addNextBehavior(
/* 1362 */                 CECombatBehaviors.Behavior.builder()
/* 1363 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1364 */                 .withinDistance(0.0D, 5.0D)
/* 1365 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1366 */                 .addNextBehavior(
/* 1367 */                   CECombatBehaviors.Behavior.builder()
/* 1368 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1369 */                   .withinDistance(0.0D, 5.0D)
/* 1370 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1371 */                   .addNextBehavior(
/* 1372 */                     CECombatBehaviors.Behavior.builder()
/* 1373 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1374 */                     .withinDistance(0.0D, 5.0D)
/* 1375 */                     .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1376 */                     .addNextBehavior(
/* 1377 */                       CECombatBehaviors.Behavior.builder()
/* 1378 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1379 */                       .withinDistance(0.0D, 5.0D)
/* 1380 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1390 */       .addFirstBehavior(
/* 1391 */         CECombatBehaviors.Behavior.builder()
/* 1392 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1393 */         .withinDistance(0.0D, 3.0D)
/* 1394 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 1395 */         .addNextBehavior(
/* 1396 */           CECombatBehaviors.Behavior.builder()
/* 1397 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1398 */           .withinDistance(0.0D, 3.0D)
/* 1399 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1400 */           .addNextBehavior(
/* 1401 */             CECombatBehaviors.Behavior.builder()
/* 1402 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1403 */             .withinDistance(0.0D, 4.0D)
/* 1404 */             .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1405 */             .addNextBehavior(
/* 1406 */               CECombatBehaviors.Behavior.builder()
/* 1407 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1408 */               .withinDistance(0.0D, 4.0D)
/* 1409 */               .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1410 */               .addNextBehavior(
/* 1411 */                 CECombatBehaviors.Behavior.builder()
/* 1412 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1413 */                 .withinDistance(0.0D, 5.0D)
/* 1414 */                 .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1415 */                 .addNextBehavior(
/* 1416 */                   CECombatBehaviors.Behavior.builder()
/* 1417 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1418 */                   .withinDistance(0.0D, 5.0D)
/* 1419 */                   .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/* 1420 */                   .addNextBehavior(
/* 1421 */                     CECombatBehaviors.Behavior.builder()
/* 1422 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1423 */                     .withinDistance(0.0D, 5.0D)
/* 1424 */                     .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1425 */                     .addNextBehavior(
/* 1426 */                       CECombatBehaviors.Behavior.builder()
/* 1427 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1428 */                       .withinDistance(0.0D, 5.0D)
/* 1429 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1439 */       .addFirstBehavior(
/* 1440 */         CECombatBehaviors.Behavior.builder()
/* 1441 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1442 */         .withinDistance(0.0D, 3.0D)
/* 1443 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/* 1444 */         .addNextBehavior(
/* 1445 */           CECombatBehaviors.Behavior.builder()
/* 1446 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1447 */           .withinDistance(0.0D, 3.0D)
/* 1448 */           .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1449 */           .addNextBehavior(
/* 1450 */             CECombatBehaviors.Behavior.builder()
/* 1451 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1452 */             .withinDistance(0.0D, 4.0D)
/* 1453 */             .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1454 */             .addNextBehavior(
/* 1455 */               CECombatBehaviors.Behavior.builder()
/* 1456 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1457 */               .withinDistance(0.0D, 4.0D)
/* 1458 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1459 */               .addNextBehavior(
/* 1460 */                 CECombatBehaviors.Behavior.builder()
/* 1461 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1462 */                 .withinDistance(0.0D, 5.0D)
/* 1463 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1464 */                 .addNextBehavior(
/* 1465 */                   CECombatBehaviors.Behavior.builder()
/* 1466 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1467 */                   .withinDistance(0.0D, 5.0D)
/* 1468 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1469 */                   .addNextBehavior(
/* 1470 */                     CECombatBehaviors.Behavior.builder()
/* 1471 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1472 */                     .withinDistance(0.0D, 5.0D)
/* 1473 */                     .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1474 */                     .addNextBehavior(
/* 1475 */                       CECombatBehaviors.Behavior.builder()
/* 1476 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1477 */                       .withinDistance(0.0D, 5.0D)
/* 1478 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1488 */       .addFirstBehavior(
/* 1489 */         CECombatBehaviors.Behavior.builder()
/* 1490 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1491 */         .withinDistance(0.0D, 3.0D)
/* 1492 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1493 */         .addNextBehavior(
/* 1494 */           CECombatBehaviors.Behavior.builder()
/* 1495 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1496 */           .withinDistance(0.0D, 3.0D)
/* 1497 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1498 */           .addNextBehavior(
/* 1499 */             CECombatBehaviors.Behavior.builder()
/* 1500 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1501 */             .withinDistance(0.0D, 4.0D)
/* 1502 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 1503 */             .addNextBehavior(
/* 1504 */               CECombatBehaviors.Behavior.builder()
/* 1505 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1506 */               .withinDistance(0.0D, 4.0D)
/* 1507 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1508 */               .addNextBehavior(
/* 1509 */                 CECombatBehaviors.Behavior.builder()
/* 1510 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1511 */                 .withinDistance(0.0D, 5.0D)
/* 1512 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1513 */                 .addNextBehavior(
/* 1514 */                   CECombatBehaviors.Behavior.builder()
/* 1515 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1516 */                   .withinDistance(0.0D, 5.0D)
/* 1517 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1518 */                   .addNextBehavior(
/* 1519 */                     CECombatBehaviors.Behavior.builder()
/* 1520 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1521 */                     .withinDistance(0.0D, 5.0D)
/* 1522 */                     .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1523 */                     .addNextBehavior(
/* 1524 */                       CECombatBehaviors.Behavior.builder()
/* 1525 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1526 */                       .withinDistance(0.0D, 5.0D)
/* 1527 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
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
/* 1541 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/* 1542 */         .addNextBehavior(
/* 1543 */           CECombatBehaviors.Behavior.builder()
/* 1544 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1545 */           .withinDistance(0.0D, 3.0D)
/* 1546 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1547 */           .addNextBehavior(
/* 1548 */             CECombatBehaviors.Behavior.builder()
/* 1549 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1550 */             .withinDistance(0.0D, 4.0D)
/* 1551 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1552 */             .addNextBehavior(
/* 1553 */               CECombatBehaviors.Behavior.builder()
/* 1554 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1555 */               .withinDistance(0.0D, 4.0D)
/* 1556 */               .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1557 */               .addNextBehavior(
/* 1558 */                 CECombatBehaviors.Behavior.builder()
/* 1559 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1560 */                 .withinDistance(0.0D, 5.0D)
/* 1561 */                 .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1562 */                 .addNextBehavior(
/* 1563 */                   CECombatBehaviors.Behavior.builder()
/* 1564 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1565 */                   .withinDistance(0.0D, 5.0D)
/* 1566 */                   .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1567 */                   .addNextBehavior(
/* 1568 */                     CECombatBehaviors.Behavior.builder()
/* 1569 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1570 */                     .withinDistance(0.0D, 5.0D)
/* 1571 */                     .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1572 */                     .addNextBehavior(
/* 1573 */                       CECombatBehaviors.Behavior.builder()
/* 1574 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1575 */                       .withinDistance(0.0D, 5.0D)
/* 1576 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1586 */       .addFirstBehavior(
/* 1587 */         CECombatBehaviors.Behavior.builder()
/* 1588 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1589 */         .withinDistance(0.0D, 3.0D)
/* 1590 */         .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 1591 */         .addNextBehavior(
/* 1592 */           CECombatBehaviors.Behavior.builder()
/* 1593 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1594 */           .withinDistance(0.0D, 3.0D)
/* 1595 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1596 */           .addNextBehavior(
/* 1597 */             CECombatBehaviors.Behavior.builder()
/* 1598 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1599 */             .withinDistance(0.0D, 4.0D)
/* 1600 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1601 */             .addNextBehavior(
/* 1602 */               CECombatBehaviors.Behavior.builder()
/* 1603 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1604 */               .withinDistance(0.0D, 4.0D)
/* 1605 */               .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1606 */               .addNextBehavior(
/* 1607 */                 CECombatBehaviors.Behavior.builder()
/* 1608 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1609 */                 .withinDistance(0.0D, 5.0D)
/* 1610 */                 .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1611 */                 .addNextBehavior(
/* 1612 */                   CECombatBehaviors.Behavior.builder()
/* 1613 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1614 */                   .withinDistance(0.0D, 5.0D)
/* 1615 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1616 */                   .addNextBehavior(
/* 1617 */                     CECombatBehaviors.Behavior.builder()
/* 1618 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1619 */                     .withinDistance(0.0D, 5.0D)
/* 1620 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1629 */       .addFirstBehavior(
/* 1630 */         CECombatBehaviors.Behavior.builder()
/* 1631 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1632 */         .withinDistance(0.0D, 3.0D)
/* 1633 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/* 1634 */         .addNextBehavior(
/* 1635 */           CECombatBehaviors.Behavior.builder()
/* 1636 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1637 */           .withinDistance(0.0D, 3.0D)
/* 1638 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1639 */           .addNextBehavior(
/* 1640 */             CECombatBehaviors.Behavior.builder()
/* 1641 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1642 */             .withinDistance(0.0D, 4.0D)
/* 1643 */             .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1644 */             .addNextBehavior(
/* 1645 */               CECombatBehaviors.Behavior.builder()
/* 1646 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1647 */               .withinDistance(0.0D, 4.0D)
/* 1648 */               .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 1649 */               .addNextBehavior(
/* 1650 */                 CECombatBehaviors.Behavior.builder()
/* 1651 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1652 */                 .withinDistance(0.0D, 5.0D)
/* 1653 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1654 */                 .addNextBehavior(
/* 1655 */                   CECombatBehaviors.Behavior.builder()
/* 1656 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1657 */                   .withinDistance(0.0D, 5.0D)
/* 1658 */                   .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1659 */                   .addNextBehavior(
/* 1660 */                     CECombatBehaviors.Behavior.builder()
/* 1661 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1662 */                     .withinDistance(0.0D, 5.0D)
/* 1663 */                     .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1664 */                     .addNextBehavior(
/* 1665 */                       CECombatBehaviors.Behavior.builder()
/* 1666 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1667 */                       .withinDistance(0.0D, 5.0D)
/* 1668 */                       .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1669 */                       .addNextBehavior(
/* 1670 */                         CECombatBehaviors.Behavior.builder()
/* 1671 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1672 */                         .withinDistance(0.0D, 5.0D)
/* 1673 */                         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))))
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
/* 1684 */       .addFirstBehavior(
/* 1685 */         CECombatBehaviors.Behavior.builder()
/* 1686 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1687 */         .withinDistance(0.0D, 3.0D)
/* 1688 */         .animationBehavior(Animations.TACHI_AUTO2, 0.0F)
/* 1689 */         .addNextBehavior(
/* 1690 */           CECombatBehaviors.Behavior.builder()
/* 1691 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1692 */           .withinDistance(0.0D, 3.0D)
/* 1693 */           .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1694 */           .addNextBehavior(
/* 1695 */             CECombatBehaviors.Behavior.builder()
/* 1696 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1697 */             .withinDistance(0.0D, 4.0D)
/* 1698 */             .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 1699 */             .addNextBehavior(
/* 1700 */               CECombatBehaviors.Behavior.builder()
/* 1701 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1702 */               .withinDistance(0.0D, 4.0D)
/* 1703 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1704 */               .addNextBehavior(
/* 1705 */                 CECombatBehaviors.Behavior.builder()
/* 1706 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1707 */                 .withinDistance(0.0D, 5.0D)
/* 1708 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1709 */                 .addNextBehavior(
/* 1710 */                   CECombatBehaviors.Behavior.builder()
/* 1711 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1712 */                   .withinDistance(0.0D, 5.0D)
/* 1713 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1714 */                   .addNextBehavior(
/* 1715 */                     CECombatBehaviors.Behavior.builder()
/* 1716 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1717 */                     .withinDistance(0.0D, 5.0D)
/* 1718 */                     .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/* 1719 */                     .addNextBehavior(
/* 1720 */                       CECombatBehaviors.Behavior.builder()
/* 1721 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1722 */                       .withinDistance(0.0D, 5.0D)
/* 1723 */                       .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1724 */                       .addNextBehavior(
/* 1725 */                         CECombatBehaviors.Behavior.builder()
/* 1726 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1727 */                         .withinDistance(0.0D, 5.0D)
/* 1728 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))))
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
/* 1739 */       .addFirstBehavior(
/* 1740 */         CECombatBehaviors.Behavior.builder()
/* 1741 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1742 */         .withinDistance(0.0D, 3.0D)
/* 1743 */         .animationBehavior(AnimsRuine.RUINE_AUTO_1, 0.0F)
/* 1744 */         .addNextBehavior(
/* 1745 */           CECombatBehaviors.Behavior.builder()
/* 1746 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1747 */           .withinDistance(0.0D, 3.0D)
/* 1748 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1749 */           .addNextBehavior(
/* 1750 */             CECombatBehaviors.Behavior.builder()
/* 1751 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1752 */             .withinDistance(0.0D, 4.0D)
/* 1753 */             .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 1754 */             .addNextBehavior(
/* 1755 */               CECombatBehaviors.Behavior.builder()
/* 1756 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1757 */               .withinDistance(0.0D, 4.0D)
/* 1758 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1759 */               .addNextBehavior(
/* 1760 */                 CECombatBehaviors.Behavior.builder()
/* 1761 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1762 */                 .withinDistance(0.0D, 5.0D)
/* 1763 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1764 */                 .addNextBehavior(
/* 1765 */                   CECombatBehaviors.Behavior.builder()
/* 1766 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1767 */                   .withinDistance(0.0D, 5.0D)
/* 1768 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1769 */                   .addNextBehavior(
/* 1770 */                     CECombatBehaviors.Behavior.builder()
/* 1771 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1772 */                     .withinDistance(0.0D, 5.0D)
/* 1773 */                     .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1774 */                     .addNextBehavior(
/* 1775 */                       CECombatBehaviors.Behavior.builder()
/* 1776 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1777 */                       .withinDistance(0.0D, 5.0D)
/* 1778 */                       .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1788 */       .addFirstBehavior(
/* 1789 */         CECombatBehaviors.Behavior.builder()
/* 1790 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1791 */         .withinDistance(0.0D, 3.0D)
/* 1792 */         .animationBehavior(Animations.TACHI_AUTO1, 0.0F)
/* 1793 */         .addNextBehavior(
/* 1794 */           CECombatBehaviors.Behavior.builder()
/* 1795 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1796 */           .withinDistance(0.0D, 3.0D)
/* 1797 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1798 */           .addNextBehavior(
/* 1799 */             CECombatBehaviors.Behavior.builder()
/* 1800 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1801 */             .withinDistance(0.0D, 4.0D)
/* 1802 */             .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 1803 */             .addNextBehavior(
/* 1804 */               CECombatBehaviors.Behavior.builder()
/* 1805 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1806 */               .withinDistance(0.0D, 4.0D)
/* 1807 */               .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F)
/* 1808 */               .addNextBehavior(
/* 1809 */                 CECombatBehaviors.Behavior.builder()
/* 1810 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1811 */                 .withinDistance(0.0D, 5.0D)
/* 1812 */                 .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1813 */                 .addNextBehavior(
/* 1814 */                   CECombatBehaviors.Behavior.builder()
/* 1815 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1816 */                   .withinDistance(0.0D, 5.0D)
/* 1817 */                   .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1818 */                   .addNextBehavior(
/* 1819 */                     CECombatBehaviors.Behavior.builder()
/* 1820 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1821 */                     .withinDistance(0.0D, 5.0D)
/* 1822 */                     .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1823 */                     .addNextBehavior(
/* 1824 */                       CECombatBehaviors.Behavior.builder()
/* 1825 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1826 */                       .withinDistance(0.0D, 5.0D)
/* 1827 */                       .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1837 */       .addFirstBehavior(
/* 1838 */         CECombatBehaviors.Behavior.builder()
/* 1839 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1840 */         .withinDistance(0.0D, 3.0D)
/* 1841 */         .animationBehavior(Animations.TACHI_AUTO3, 0.0F)
/* 1842 */         .addNextBehavior(
/* 1843 */           CECombatBehaviors.Behavior.builder()
/* 1844 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1845 */           .withinDistance(0.0D, 3.0D)
/* 1846 */           .animationBehavior(Animations.TACHI_DASH, 0.0F)
/* 1847 */           .addNextBehavior(
/* 1848 */             CECombatBehaviors.Behavior.builder()
/* 1849 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1850 */             .withinDistance(0.0D, 4.0D)
/* 1851 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/* 1852 */             .addNextBehavior(
/* 1853 */               CECombatBehaviors.Behavior.builder()
/* 1854 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1855 */               .withinDistance(0.0D, 4.0D)
/* 1856 */               .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1857 */               .addNextBehavior(
/* 1858 */                 CECombatBehaviors.Behavior.builder()
/* 1859 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1860 */                 .withinDistance(0.0D, 5.0D)
/* 1861 */                 .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1862 */                 .addNextBehavior(
/* 1863 */                   CECombatBehaviors.Behavior.builder()
/* 1864 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1865 */                   .withinDistance(0.0D, 5.0D)
/* 1866 */                   .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)
/* 1867 */                   .addNextBehavior(
/* 1868 */                     CECombatBehaviors.Behavior.builder()
/* 1869 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1870 */                     .withinDistance(0.0D, 5.0D)
/* 1871 */                     .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 1872 */                     .addNextBehavior(
/* 1873 */                       CECombatBehaviors.Behavior.builder()
/* 1874 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1875 */                       .withinDistance(0.0D, 5.0D)
/* 1876 */                       .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1877 */                       .addNextBehavior(
/* 1878 */                         CECombatBehaviors.Behavior.builder()
/* 1879 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1880 */                         .withinDistance(0.0D, 5.0D)
/* 1881 */                         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))))
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
/* 1892 */     .newBehaviorRoot(
/* 1893 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1894 */       .priority(1.0D)
/* 1895 */       .weight(20.0D)
/* 1896 */       .maxCooldown(100)
/* 1897 */       .addFirstBehavior(
/* 1898 */         CECombatBehaviors.Behavior.builder()
/* 1899 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1900 */         .withinDistance(0.0D, 3.0D)
/* 1901 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 1902 */         .addNextBehavior(
/* 1903 */           CECombatBehaviors.Behavior.builder()
/* 1904 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1905 */           .withinDistance(0.0D, 3.0D)
/* 1906 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 1907 */           .addNextBehavior(
/* 1908 */             CECombatBehaviors.Behavior.builder()
/* 1909 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1910 */             .withinDistance(0.0D, 3.0D)
/* 1911 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1916 */     .newBehaviorRoot(
/* 1917 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1918 */       .priority(1.0D)
/* 1919 */       .weight(10.0D)
/* 1920 */       .maxCooldown(100)
/* 1921 */       .addFirstBehavior(
/* 1922 */         CECombatBehaviors.Behavior.builder()
/* 1923 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1924 */         .withinDistance(0.0D, 3.0D)
/* 1925 */         .animationBehavior(Animations.TACHI_DASH, 0.0F))
/*      */       
/* 1927 */       .addFirstBehavior(
/* 1928 */         CECombatBehaviors.Behavior.builder()
/* 1929 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1930 */         .withinDistance(0.0D, 3.0D)
/* 1931 */         .animationBehavior(Animations.LONGSWORD_AIR_SLASH, 0.0F))
/*      */       
/* 1933 */       .addFirstBehavior(
/* 1934 */         CECombatBehaviors.Behavior.builder()
/* 1935 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1936 */         .withinDistance(0.0D, 3.0D)
/* 1937 */         .animationBehavior(Animations.RUSHING_TEMPO1, 0.0F)
/* 1938 */         .addNextBehavior(
/* 1939 */           CECombatBehaviors.Behavior.builder()
/* 1940 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1941 */           .withinDistance(0.0D, 3.0D)
/* 1942 */           .animationBehavior(Animations.RUSHING_TEMPO2, 0.0F)
/* 1943 */           .addNextBehavior(
/* 1944 */             CECombatBehaviors.Behavior.builder()
/* 1945 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1946 */             .withinDistance(0.0D, 3.0D)
/* 1947 */             .animationBehavior(Animations.RUSHING_TEMPO3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1952 */     .newBehaviorRoot(
/* 1953 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1954 */       .priority(1.0D)
/* 1955 */       .weight(10.0D)
/* 1956 */       .maxCooldown(40)
/* 1957 */       .addFirstBehavior(
/* 1958 */         CECombatBehaviors.Behavior.builder()
/* 1959 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1960 */         .withinDistance(0.0D, 3.0D)
/* 1961 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1962 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1963 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1966 */     .newBehaviorRoot(
/* 1967 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1968 */       .priority(1.0D)
/* 1969 */       .weight(2.0D)
/* 1970 */       .maxCooldown(100)
/* 1971 */       .addFirstBehavior(
/* 1972 */         CECombatBehaviors.Behavior.builder()
/* 1973 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1974 */         .withinDistance(0.0D, 3.0D)
/* 1975 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1977 */       .addFirstBehavior(
/* 1978 */         CECombatBehaviors.Behavior.builder()
/* 1979 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1980 */         .withinDistance(0.0D, 3.0D)
/* 1981 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1983 */       .addFirstBehavior(
/* 1984 */         CECombatBehaviors.Behavior.builder()
/* 1985 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1986 */         .withinDistance(0.0D, 3.0D)
/* 1987 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1989 */       .addFirstBehavior(
/* 1990 */         CECombatBehaviors.Behavior.builder()
/* 1991 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1992 */         .withinDistance(0.0D, 3.0D)
/* 1993 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1995 */       .addFirstBehavior(
/* 1996 */         CECombatBehaviors.Behavior.builder()
/* 1997 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1998 */         .withinDistance(0.0D, 3.0D)
/* 1999 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 2001 */       .addFirstBehavior(
/* 2002 */         CECombatBehaviors.Behavior.builder()
/* 2003 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2004 */         .withinDistance(0.0D, 3.0D)
/* 2005 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 2007 */       .addFirstBehavior(
/* 2008 */         CECombatBehaviors.Behavior.builder()
/* 2009 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2010 */         .withinDistance(0.0D, 3.0D)
/* 2011 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 2014 */     .newBehaviorRoot(
/* 2015 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2016 */       .priority(1.0D)
/* 2017 */       .weight(15.0D)
/* 2018 */       .addFirstBehavior(
/* 2019 */         CECombatBehaviors.Behavior.builder()
/* 2020 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2021 */         .withinDistance(0.0D, 3.0D)
/* 2022 */         .custom(CombatCommon::canPerformGuarding)
/* 2023 */         .guard(40)))
/*      */ 
/*      */     
/* 2026 */     .newBehaviorRoot(
/* 2027 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2028 */       .priority(1.0D)
/* 2029 */       .weight(10.0D)
/* 2030 */       .addFirstBehavior(
/* 2031 */         CECombatBehaviors.Behavior.builder()
/* 2032 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2033 */         .withinDistance(0.0D, 3.0D)
/* 2034 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 2036 */       .addFirstBehavior(
/* 2037 */         CECombatBehaviors.Behavior.builder()
/* 2038 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2039 */         .withinDistance(0.0D, 3.0D)
/* 2040 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 2043 */     .newBehaviorRoot(
/* 2044 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2045 */       .priority(1.0D)
/* 2046 */       .weight(40.0D)
/* 2047 */       .maxCooldown(160)
/* 2048 */       .addFirstBehavior(
/* 2049 */         CECombatBehaviors.Behavior.builder()
/* 2050 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2051 */         .custom(CombatCommon::canJump)
/* 2052 */         .withinDistance(5.0D, 14.0D)
/* 2053 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2054 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 2058 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_DUAL_TACHI = CECombatBehaviors.builder()
/* 2059 */     .newBehaviorRoot(
/* 2060 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2061 */       .priority(4.0D)
/* 2062 */       .weight(1000.0D)
/* 2063 */       .maxCooldown(0)
/* 2064 */       .addFirstBehavior(
/* 2065 */         CECombatBehaviors.Behavior.builder()
/* 2066 */         .custom(CombatCommon::canExecute)
/* 2067 */         .withinDistance(0.0D, 5.0D)
/* 2068 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 2069 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 2072 */     .newBehaviorRoot(
/* 2073 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2074 */       .priority(3.0D)
/* 2075 */       .weight(1000.0D)
/* 2076 */       .maxCooldown(0)
/* 2077 */       .addFirstBehavior(
/* 2078 */         CECombatBehaviors.Behavior.builder()
/* 2079 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2080 */         .custom(CombatCommon::canEscape)
/* 2081 */         .withinDistance(0.0D, 8.0D)
/* 2082 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2083 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 2085 */       .addFirstBehavior(
/* 2086 */         CECombatBehaviors.Behavior.builder()
/* 2087 */         .custom(CombatCommon::canEscape)
/* 2088 */         .withinDistance(0.0D, 48.0D)
/* 2089 */         .guard(40)))
/*      */ 
/*      */     
/* 2092 */     .newBehaviorRoot(
/* 2093 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2094 */       .priority(2.0D)
/* 2095 */       .weight(70.0D)
/* 2096 */       .maxCooldown(0)
/* 2097 */       .addFirstBehavior(
/* 2098 */         CECombatBehaviors.Behavior.builder()
/* 2099 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 2100 */         .custom(CombatCommon::canPerformEating)
/* 2101 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2102 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 2105 */     .newBehaviorRoot(
/* 2106 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2107 */       .priority(2.0D)
/* 2108 */       .weight(100.0D)
/* 2109 */       .maxCooldown(120)
/* 2110 */       .addFirstBehavior(
/* 2111 */         CECombatBehaviors.Behavior.builder()
/* 2112 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2113 */         .custom(CombatCommon::canSwapToBow)
/* 2114 */         .withinDistance(7.0D, 14.0D)
/* 2115 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 2116 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 2118 */       .addFirstBehavior(
/* 2119 */         CECombatBehaviors.Behavior.builder()
/* 2120 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2121 */         .custom(CombatCommon::canSwapToBow)
/* 2122 */         .withinDistance(7.0D, 14.0D)
/* 2123 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 2124 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 2127 */     .newBehaviorRoot(
/* 2128 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2129 */       .priority(2.0D)
/* 2130 */       .weight(80.0D)
/* 2131 */       .maxCooldown(120)
/* 2132 */       .addFirstBehavior(
/* 2133 */         CECombatBehaviors.Behavior.builder()
/* 2134 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2135 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2136 */         .withinDistance(7.0D, 48.0D)
/* 2137 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2138 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 2141 */     .newBehaviorRoot(
/* 2142 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2143 */       .priority(1.0D)
/* 2144 */       .weight(40.0D)
/* 2145 */       .maxCooldown(20)
/* 2146 */       .addFirstBehavior(
/* 2147 */         CECombatBehaviors.Behavior.builder()
/* 2148 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2149 */         .withinDistance(0.0D, 3.0D)
/* 2150 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2151 */         .addNextBehavior(
/* 2152 */           CECombatBehaviors.Behavior.builder()
/* 2153 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2154 */           .withinDistance(0.0D, 3.0D)
/* 2155 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2156 */           .addNextBehavior(
/* 2157 */             CECombatBehaviors.Behavior.builder()
/* 2158 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2159 */             .withinDistance(0.0D, 3.0D)
/* 2160 */             .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2161 */             .addNextBehavior(
/* 2162 */               CECombatBehaviors.Behavior.builder()
/* 2163 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2164 */               .withinDistance(0.0D, 3.0D)
/* 2165 */               .animationBehavior(AVAnimations.DUAL_SWORD_AUTO4, 0.0F)
/* 2166 */               .addNextBehavior(
/* 2167 */                 CECombatBehaviors.Behavior.builder()
/* 2168 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2169 */                 .withinDistance(0.0D, 3.0D)
/* 2170 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO5, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2176 */       .addFirstBehavior(
/* 2177 */         CECombatBehaviors.Behavior.builder()
/* 2178 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2179 */         .withinDistance(0.0D, 3.0D)
/* 2180 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2181 */         .addNextBehavior(
/* 2182 */           CECombatBehaviors.Behavior.builder()
/* 2183 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2184 */           .withinDistance(0.0D, 3.0D)
/* 2185 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2186 */           .addNextBehavior(
/* 2187 */             CECombatBehaviors.Behavior.builder()
/* 2188 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2189 */             .withinDistance(0.0D, 4.0D)
/* 2190 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2191 */             .addNextBehavior(
/* 2192 */               CECombatBehaviors.Behavior.builder()
/* 2193 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2194 */               .withinDistance(0.0D, 4.0D)
/* 2195 */               .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2196 */               .addNextBehavior(
/* 2197 */                 CECombatBehaviors.Behavior.builder()
/* 2198 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2199 */                 .withinDistance(0.0D, 5.0D)
/* 2200 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2201 */                 .addNextBehavior(
/* 2202 */                   CECombatBehaviors.Behavior.builder()
/* 2203 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2204 */                   .withinDistance(0.0D, 5.0D)
/* 2205 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2213 */       .addFirstBehavior(
/* 2214 */         CECombatBehaviors.Behavior.builder()
/* 2215 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2216 */         .withinDistance(0.0D, 3.0D)
/* 2217 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2218 */         .addNextBehavior(
/* 2219 */           CECombatBehaviors.Behavior.builder()
/* 2220 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2221 */           .withinDistance(0.0D, 3.0D)
/* 2222 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2223 */           .addNextBehavior(
/* 2224 */             CECombatBehaviors.Behavior.builder()
/* 2225 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2226 */             .withinDistance(0.0D, 4.0D)
/* 2227 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2228 */             .addNextBehavior(
/* 2229 */               CECombatBehaviors.Behavior.builder()
/* 2230 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2231 */               .withinDistance(0.0D, 4.0D)
/* 2232 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2233 */               .addNextBehavior(
/* 2234 */                 CECombatBehaviors.Behavior.builder()
/* 2235 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2236 */                 .withinDistance(0.0D, 5.0D)
/* 2237 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2238 */                 .addNextBehavior(
/* 2239 */                   CECombatBehaviors.Behavior.builder()
/* 2240 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2241 */                   .withinDistance(0.0D, 5.0D)
/* 2242 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2250 */       .addFirstBehavior(
/* 2251 */         CECombatBehaviors.Behavior.builder()
/* 2252 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2253 */         .withinDistance(0.0D, 3.0D)
/* 2254 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2255 */         .addNextBehavior(
/* 2256 */           CECombatBehaviors.Behavior.builder()
/* 2257 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2258 */           .withinDistance(0.0D, 3.0D)
/* 2259 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2260 */           .addNextBehavior(
/* 2261 */             CECombatBehaviors.Behavior.builder()
/* 2262 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2263 */             .withinDistance(0.0D, 4.0D)
/* 2264 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2265 */             .addNextBehavior(
/* 2266 */               CECombatBehaviors.Behavior.builder()
/* 2267 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2268 */               .withinDistance(0.0D, 4.0D)
/* 2269 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2270 */               .addNextBehavior(
/* 2271 */                 CECombatBehaviors.Behavior.builder()
/* 2272 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2273 */                 .withinDistance(0.0D, 5.0D)
/* 2274 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2275 */                 .addNextBehavior(
/* 2276 */                   CECombatBehaviors.Behavior.builder()
/* 2277 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2278 */                   .withinDistance(0.0D, 5.0D)
/* 2279 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2280 */                   .addNextBehavior(
/* 2281 */                     CECombatBehaviors.Behavior.builder()
/* 2282 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2283 */                     .withinDistance(0.0D, 5.0D)
/* 2284 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2293 */       .addFirstBehavior(
/* 2294 */         CECombatBehaviors.Behavior.builder()
/* 2295 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2296 */         .withinDistance(0.0D, 3.0D)
/* 2297 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2298 */         .addNextBehavior(
/* 2299 */           CECombatBehaviors.Behavior.builder()
/* 2300 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2301 */           .withinDistance(0.0D, 3.0D)
/* 2302 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2303 */           .addNextBehavior(
/* 2304 */             CECombatBehaviors.Behavior.builder()
/* 2305 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2306 */             .withinDistance(0.0D, 4.0D)
/* 2307 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2308 */             .addNextBehavior(
/* 2309 */               CECombatBehaviors.Behavior.builder()
/* 2310 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2311 */               .withinDistance(0.0D, 4.0D)
/* 2312 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2313 */               .addNextBehavior(
/* 2314 */                 CECombatBehaviors.Behavior.builder()
/* 2315 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2316 */                 .withinDistance(0.0D, 5.0D)
/* 2317 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 2318 */                 .addNextBehavior(
/* 2319 */                   CECombatBehaviors.Behavior.builder()
/* 2320 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2321 */                   .withinDistance(0.0D, 5.0D)
/* 2322 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2330 */       .addFirstBehavior(
/* 2331 */         CECombatBehaviors.Behavior.builder()
/* 2332 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2333 */         .withinDistance(0.0D, 3.0D)
/* 2334 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2335 */         .addNextBehavior(
/* 2336 */           CECombatBehaviors.Behavior.builder()
/* 2337 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2338 */           .withinDistance(0.0D, 3.0D)
/* 2339 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2340 */           .addNextBehavior(
/* 2341 */             CECombatBehaviors.Behavior.builder()
/* 2342 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2343 */             .withinDistance(0.0D, 4.0D)
/* 2344 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2345 */             .addNextBehavior(
/* 2346 */               CECombatBehaviors.Behavior.builder()
/* 2347 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2348 */               .withinDistance(0.0D, 4.0D)
/* 2349 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2350 */               .addNextBehavior(
/* 2351 */                 CECombatBehaviors.Behavior.builder()
/* 2352 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2353 */                 .withinDistance(0.0D, 5.0D)
/* 2354 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2355 */                 .addNextBehavior(
/* 2356 */                   CECombatBehaviors.Behavior.builder()
/* 2357 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2358 */                   .withinDistance(0.0D, 5.0D)
/* 2359 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2367 */       .addFirstBehavior(
/* 2368 */         CECombatBehaviors.Behavior.builder()
/* 2369 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2370 */         .withinDistance(0.0D, 3.0D)
/* 2371 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2372 */         .addNextBehavior(
/* 2373 */           CECombatBehaviors.Behavior.builder()
/* 2374 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2375 */           .withinDistance(0.0D, 3.0D)
/* 2376 */           .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2377 */           .addNextBehavior(
/* 2378 */             CECombatBehaviors.Behavior.builder()
/* 2379 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2380 */             .withinDistance(0.0D, 4.0D)
/* 2381 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2382 */             .addNextBehavior(
/* 2383 */               CECombatBehaviors.Behavior.builder()
/* 2384 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2385 */               .withinDistance(0.0D, 4.0D)
/* 2386 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2387 */               .addNextBehavior(
/* 2388 */                 CECombatBehaviors.Behavior.builder()
/* 2389 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2390 */                 .withinDistance(0.0D, 5.0D)
/* 2391 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2392 */                 .addNextBehavior(
/* 2393 */                   CECombatBehaviors.Behavior.builder()
/* 2394 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2395 */                   .withinDistance(0.0D, 5.0D)
/* 2396 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2404 */       .addFirstBehavior(
/* 2405 */         CECombatBehaviors.Behavior.builder()
/* 2406 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2407 */         .withinDistance(0.0D, 3.0D)
/* 2408 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2409 */         .addNextBehavior(
/* 2410 */           CECombatBehaviors.Behavior.builder()
/* 2411 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2412 */           .withinDistance(0.0D, 3.0D)
/* 2413 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2414 */           .addNextBehavior(
/* 2415 */             CECombatBehaviors.Behavior.builder()
/* 2416 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2417 */             .withinDistance(0.0D, 4.0D)
/* 2418 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2419 */             .addNextBehavior(
/* 2420 */               CECombatBehaviors.Behavior.builder()
/* 2421 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2422 */               .withinDistance(0.0D, 4.0D)
/* 2423 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2424 */               .addNextBehavior(
/* 2425 */                 CECombatBehaviors.Behavior.builder()
/* 2426 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2427 */                 .withinDistance(0.0D, 5.0D)
/* 2428 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2429 */                 .addNextBehavior(
/* 2430 */                   CECombatBehaviors.Behavior.builder()
/* 2431 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2432 */                   .withinDistance(0.0D, 5.0D)
/* 2433 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2441 */       .addFirstBehavior(
/* 2442 */         CECombatBehaviors.Behavior.builder()
/* 2443 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2444 */         .withinDistance(0.0D, 3.0D)
/* 2445 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2446 */         .addNextBehavior(
/* 2447 */           CECombatBehaviors.Behavior.builder()
/* 2448 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2449 */           .withinDistance(0.0D, 3.0D)
/* 2450 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2451 */           .addNextBehavior(
/* 2452 */             CECombatBehaviors.Behavior.builder()
/* 2453 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2454 */             .withinDistance(0.0D, 4.0D)
/* 2455 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2456 */             .addNextBehavior(
/* 2457 */               CECombatBehaviors.Behavior.builder()
/* 2458 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2459 */               .withinDistance(0.0D, 4.0D)
/* 2460 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2461 */               .addNextBehavior(
/* 2462 */                 CECombatBehaviors.Behavior.builder()
/* 2463 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2464 */                 .withinDistance(0.0D, 5.0D)
/* 2465 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2466 */                 .addNextBehavior(
/* 2467 */                   CECombatBehaviors.Behavior.builder()
/* 2468 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2469 */                   .withinDistance(0.0D, 5.0D)
/* 2470 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2478 */       .addFirstBehavior(
/* 2479 */         CECombatBehaviors.Behavior.builder()
/* 2480 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2481 */         .withinDistance(0.0D, 3.0D)
/* 2482 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2483 */         .addNextBehavior(
/* 2484 */           CECombatBehaviors.Behavior.builder()
/* 2485 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2486 */           .withinDistance(0.0D, 3.0D)
/* 2487 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2488 */           .addNextBehavior(
/* 2489 */             CECombatBehaviors.Behavior.builder()
/* 2490 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2491 */             .withinDistance(0.0D, 4.0D)
/* 2492 */             .animationBehavior(AVAnimations.DUAL_SWORD_AUTO4, 0.0F)
/* 2493 */             .addNextBehavior(
/* 2494 */               CECombatBehaviors.Behavior.builder()
/* 2495 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2496 */               .withinDistance(0.0D, 4.0D)
/* 2497 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2498 */               .addNextBehavior(
/* 2499 */                 CECombatBehaviors.Behavior.builder()
/* 2500 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2501 */                 .withinDistance(0.0D, 5.0D)
/* 2502 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2503 */                 .addNextBehavior(
/* 2504 */                   CECombatBehaviors.Behavior.builder()
/* 2505 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2506 */                   .withinDistance(0.0D, 5.0D)
/* 2507 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2515 */       .addFirstBehavior(
/* 2516 */         CECombatBehaviors.Behavior.builder()
/* 2517 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2518 */         .withinDistance(0.0D, 3.0D)
/* 2519 */         .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2520 */         .addNextBehavior(
/* 2521 */           CECombatBehaviors.Behavior.builder()
/* 2522 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2523 */           .withinDistance(0.0D, 3.0D)
/* 2524 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2525 */           .addNextBehavior(
/* 2526 */             CECombatBehaviors.Behavior.builder()
/* 2527 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2528 */             .withinDistance(0.0D, 4.0D)
/* 2529 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2530 */             .addNextBehavior(
/* 2531 */               CECombatBehaviors.Behavior.builder()
/* 2532 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2533 */               .withinDistance(0.0D, 4.0D)
/* 2534 */               .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2535 */               .addNextBehavior(
/* 2536 */                 CECombatBehaviors.Behavior.builder()
/* 2537 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2538 */                 .withinDistance(0.0D, 5.0D)
/* 2539 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2540 */                 .addNextBehavior(
/* 2541 */                   CECombatBehaviors.Behavior.builder()
/* 2542 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2543 */                   .withinDistance(0.0D, 5.0D)
/* 2544 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2552 */       .addFirstBehavior(
/* 2553 */         CECombatBehaviors.Behavior.builder()
/* 2554 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2555 */         .withinDistance(0.0D, 3.0D)
/* 2556 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2557 */         .addNextBehavior(
/* 2558 */           CECombatBehaviors.Behavior.builder()
/* 2559 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2560 */           .withinDistance(0.0D, 3.0D)
/* 2561 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2562 */           .addNextBehavior(
/* 2563 */             CECombatBehaviors.Behavior.builder()
/* 2564 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2565 */             .withinDistance(0.0D, 4.0D)
/* 2566 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2567 */             .addNextBehavior(
/* 2568 */               CECombatBehaviors.Behavior.builder()
/* 2569 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2570 */               .withinDistance(0.0D, 4.0D)
/* 2571 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2572 */               .addNextBehavior(
/* 2573 */                 CECombatBehaviors.Behavior.builder()
/* 2574 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2575 */                 .withinDistance(0.0D, 5.0D)
/* 2576 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2583 */       .addFirstBehavior(
/* 2584 */         CECombatBehaviors.Behavior.builder()
/* 2585 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2586 */         .withinDistance(0.0D, 3.0D)
/* 2587 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2588 */         .addNextBehavior(
/* 2589 */           CECombatBehaviors.Behavior.builder()
/* 2590 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2591 */           .withinDistance(0.0D, 3.0D)
/* 2592 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2593 */           .addNextBehavior(
/* 2594 */             CECombatBehaviors.Behavior.builder()
/* 2595 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2596 */             .withinDistance(0.0D, 4.0D)
/* 2597 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2598 */             .addNextBehavior(
/* 2599 */               CECombatBehaviors.Behavior.builder()
/* 2600 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2601 */               .withinDistance(0.0D, 4.0D)
/* 2602 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2603 */               .addNextBehavior(
/* 2604 */                 CECombatBehaviors.Behavior.builder()
/* 2605 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2606 */                 .withinDistance(0.0D, 5.0D)
/* 2607 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2608 */                 .addNextBehavior(
/* 2609 */                   CECombatBehaviors.Behavior.builder()
/* 2610 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2611 */                   .withinDistance(0.0D, 5.0D)
/* 2612 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2613 */                   .addNextBehavior(
/* 2614 */                     CECombatBehaviors.Behavior.builder()
/* 2615 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2616 */                     .withinDistance(0.0D, 5.0D)
/* 2617 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2626 */       .addFirstBehavior(
/* 2627 */         CECombatBehaviors.Behavior.builder()
/* 2628 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2629 */         .withinDistance(0.0D, 3.0D)
/* 2630 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2631 */         .addNextBehavior(
/* 2632 */           CECombatBehaviors.Behavior.builder()
/* 2633 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2634 */           .withinDistance(0.0D, 3.0D)
/* 2635 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2636 */           .addNextBehavior(
/* 2637 */             CECombatBehaviors.Behavior.builder()
/* 2638 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2639 */             .withinDistance(0.0D, 4.0D)
/* 2640 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2641 */             .addNextBehavior(
/* 2642 */               CECombatBehaviors.Behavior.builder()
/* 2643 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2644 */               .withinDistance(0.0D, 4.0D)
/* 2645 */               .animationBehavior(AVAnimations.DUAL_SWORD_AUTO5, 0.0F)
/* 2646 */               .addNextBehavior(
/* 2647 */                 CECombatBehaviors.Behavior.builder()
/* 2648 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2649 */                 .withinDistance(0.0D, 5.0D)
/* 2650 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2651 */                 .addNextBehavior(
/* 2652 */                   CECombatBehaviors.Behavior.builder()
/* 2653 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2654 */                   .withinDistance(0.0D, 5.0D)
/* 2655 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2663 */       .addFirstBehavior(
/* 2664 */         CECombatBehaviors.Behavior.builder()
/* 2665 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2666 */         .withinDistance(0.0D, 3.0D)
/* 2667 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2668 */         .addNextBehavior(
/* 2669 */           CECombatBehaviors.Behavior.builder()
/* 2670 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2671 */           .withinDistance(0.0D, 3.0D)
/* 2672 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2673 */           .addNextBehavior(
/* 2674 */             CECombatBehaviors.Behavior.builder()
/* 2675 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2676 */             .withinDistance(0.0D, 4.0D)
/* 2677 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2678 */             .addNextBehavior(
/* 2679 */               CECombatBehaviors.Behavior.builder()
/* 2680 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2681 */               .withinDistance(0.0D, 4.0D)
/* 2682 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2683 */               .addNextBehavior(
/* 2684 */                 CECombatBehaviors.Behavior.builder()
/* 2685 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2686 */                 .withinDistance(0.0D, 5.0D)
/* 2687 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2688 */                 .addNextBehavior(
/* 2689 */                   CECombatBehaviors.Behavior.builder()
/* 2690 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2691 */                   .withinDistance(0.0D, 5.0D)
/* 2692 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2693 */                   .addNextBehavior(
/* 2694 */                     CECombatBehaviors.Behavior.builder()
/* 2695 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2696 */                     .withinDistance(0.0D, 5.0D)
/* 2697 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2706 */       .addFirstBehavior(
/* 2707 */         CECombatBehaviors.Behavior.builder()
/* 2708 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2709 */         .withinDistance(0.0D, 3.0D)
/* 2710 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2711 */         .addNextBehavior(
/* 2712 */           CECombatBehaviors.Behavior.builder()
/* 2713 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2714 */           .withinDistance(0.0D, 3.0D)
/* 2715 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2716 */           .addNextBehavior(
/* 2717 */             CECombatBehaviors.Behavior.builder()
/* 2718 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2719 */             .withinDistance(0.0D, 4.0D)
/* 2720 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2721 */             .addNextBehavior(
/* 2722 */               CECombatBehaviors.Behavior.builder()
/* 2723 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2724 */               .withinDistance(0.0D, 4.0D)
/* 2725 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2726 */               .addNextBehavior(
/* 2727 */                 CECombatBehaviors.Behavior.builder()
/* 2728 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2729 */                 .withinDistance(0.0D, 5.0D)
/* 2730 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2731 */                 .addNextBehavior(
/* 2732 */                   CECombatBehaviors.Behavior.builder()
/* 2733 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2734 */                   .withinDistance(0.0D, 5.0D)
/* 2735 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2743 */     .newBehaviorRoot(
/* 2744 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2745 */       .priority(1.0D)
/* 2746 */       .weight(20.0D)
/* 2747 */       .maxCooldown(100)
/* 2748 */       .addFirstBehavior(
/* 2749 */         CECombatBehaviors.Behavior.builder()
/* 2750 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2751 */         .withinDistance(0.0D, 3.0D)
/* 2752 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2753 */         .addNextBehavior(
/* 2754 */           CECombatBehaviors.Behavior.builder()
/* 2755 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2756 */           .withinDistance(0.0D, 3.0D)
/* 2757 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2758 */           .addNextBehavior(
/* 2759 */             CECombatBehaviors.Behavior.builder()
/* 2760 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2761 */             .withinDistance(0.0D, 3.0D)
/* 2762 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2763 */             .addNextBehavior(
/* 2764 */               CECombatBehaviors.Behavior.builder()
/* 2765 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2766 */               .withinDistance(0.0D, 3.0D)
/* 2767 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2773 */     .newBehaviorRoot(
/* 2774 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2775 */       .priority(1.0D)
/* 2776 */       .weight(10.0D)
/* 2777 */       .maxCooldown(100)
/* 2778 */       .addFirstBehavior(
/* 2779 */         CECombatBehaviors.Behavior.builder()
/* 2780 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2781 */         .withinDistance(0.0D, 3.0D)
/* 2782 */         .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F))
/*      */       
/* 2784 */       .addFirstBehavior(
/* 2785 */         CECombatBehaviors.Behavior.builder()
/* 2786 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2787 */         .withinDistance(0.0D, 3.0D)
/* 2788 */         .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F))
/*      */       
/* 2790 */       .addFirstBehavior(
/* 2791 */         CECombatBehaviors.Behavior.builder()
/* 2792 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2793 */         .withinDistance(0.0D, 3.0D)
/* 2794 */         .animationBehavior(Animations.DANCING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 2797 */     .newBehaviorRoot(
/* 2798 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2799 */       .priority(1.0D)
/* 2800 */       .weight(10.0D)
/* 2801 */       .maxCooldown(40)
/* 2802 */       .addFirstBehavior(
/* 2803 */         CECombatBehaviors.Behavior.builder()
/* 2804 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2805 */         .withinDistance(0.0D, 3.0D)
/* 2806 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2807 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2808 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 2811 */     .newBehaviorRoot(
/* 2812 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2813 */       .priority(1.0D)
/* 2814 */       .weight(2.0D)
/* 2815 */       .maxCooldown(100)
/* 2816 */       .addFirstBehavior(
/* 2817 */         CECombatBehaviors.Behavior.builder()
/* 2818 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2819 */         .withinDistance(0.0D, 3.0D)
/* 2820 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 2822 */       .addFirstBehavior(
/* 2823 */         CECombatBehaviors.Behavior.builder()
/* 2824 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2825 */         .withinDistance(0.0D, 3.0D)
/* 2826 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 2828 */       .addFirstBehavior(
/* 2829 */         CECombatBehaviors.Behavior.builder()
/* 2830 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2831 */         .withinDistance(0.0D, 3.0D)
/* 2832 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 2834 */       .addFirstBehavior(
/* 2835 */         CECombatBehaviors.Behavior.builder()
/* 2836 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2837 */         .withinDistance(0.0D, 3.0D)
/* 2838 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 2840 */       .addFirstBehavior(
/* 2841 */         CECombatBehaviors.Behavior.builder()
/* 2842 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2843 */         .withinDistance(0.0D, 3.0D)
/* 2844 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 2846 */       .addFirstBehavior(
/* 2847 */         CECombatBehaviors.Behavior.builder()
/* 2848 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2849 */         .withinDistance(0.0D, 3.0D)
/* 2850 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 2852 */       .addFirstBehavior(
/* 2853 */         CECombatBehaviors.Behavior.builder()
/* 2854 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2855 */         .withinDistance(0.0D, 3.0D)
/* 2856 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 2859 */     .newBehaviorRoot(
/* 2860 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2861 */       .priority(1.0D)
/* 2862 */       .weight(15.0D)
/* 2863 */       .addFirstBehavior(
/* 2864 */         CECombatBehaviors.Behavior.builder()
/* 2865 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2866 */         .withinDistance(0.0D, 3.0D)
/* 2867 */         .custom(CombatCommon::canPerformGuarding)
/* 2868 */         .guard(40)))
/*      */ 
/*      */     
/* 2871 */     .newBehaviorRoot(
/* 2872 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2873 */       .priority(1.0D)
/* 2874 */       .weight(10.0D)
/* 2875 */       .addFirstBehavior(
/* 2876 */         CECombatBehaviors.Behavior.builder()
/* 2877 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2878 */         .withinDistance(0.0D, 3.0D)
/* 2879 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 2881 */       .addFirstBehavior(
/* 2882 */         CECombatBehaviors.Behavior.builder()
/* 2883 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2884 */         .withinDistance(0.0D, 3.0D)
/* 2885 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 2888 */     .newBehaviorRoot(
/* 2889 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2890 */       .priority(1.0D)
/* 2891 */       .weight(40.0D)
/* 2892 */       .maxCooldown(160)
/* 2893 */       .addFirstBehavior(
/* 2894 */         CECombatBehaviors.Behavior.builder()
/* 2895 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2896 */         .custom(CombatCommon::canJump)
/* 2897 */         .withinDistance(5.0D, 14.0D)
/* 2898 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2899 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\PlayerNpcTachi.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */