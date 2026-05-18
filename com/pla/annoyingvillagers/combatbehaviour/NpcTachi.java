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
/*      */ public class NpcTachi
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
/*   71 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   72 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   74 */       .addFirstBehavior(
/*   75 */         CECombatBehaviors.Behavior.builder()
/*   76 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   77 */         .custom(CombatCommon::canSwapToBow)
/*   78 */         .withinDistance(7.0D, 14.0D)
/*   79 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
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
/*  159 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/*  213 */                         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))))
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
/*  268 */                         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))))
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
/*  313 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
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
/*  361 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/*  405 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
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
/*  453 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/*  502 */                       .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
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
/*  556 */                         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))))
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
/*  601 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
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
/*  649 */                       .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
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
/*  698 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/*  747 */                       .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
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
/*  796 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/*  850 */                         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))))
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
/* 1004 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1006 */       .addFirstBehavior(
/* 1007 */         CECombatBehaviors.Behavior.builder()
/* 1008 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1009 */         .withinDistance(0.0D, 3.0D)
/* 1010 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))
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
/* 1051 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
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
/* 1070 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
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
/* 1084 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1085 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 1087 */       .addFirstBehavior(
/* 1088 */         CECombatBehaviors.Behavior.builder()
/* 1089 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1090 */         .custom(CombatCommon::canSwapToBow)
/* 1091 */         .withinDistance(7.0D, 14.0D)
/* 1092 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
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
/* 1184 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/* 1233 */                       .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
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
/* 1282 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/* 1331 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/* 1380 */                       .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
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
/* 1429 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/* 1478 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/* 1527 */                       .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
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
/* 1576 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/* 1620 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
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
/* 1673 */                         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))))
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
/* 1728 */                         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))))
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
/* 1778 */                       .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))
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
/* 1827 */                       .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
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
/* 1881 */                         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))))))
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
/* 2034 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 2036 */       .addFirstBehavior(
/* 2037 */         CECombatBehaviors.Behavior.builder()
/* 2038 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2039 */         .withinDistance(0.0D, 3.0D)
/* 2040 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))
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
/* 2079 */         .custom(CombatCommon::canEscape)
/* 2080 */         .withinDistance(0.0D, 8.0D)
/* 2081 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 2082 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/* 2084 */       .addFirstBehavior(
/* 2085 */         CECombatBehaviors.Behavior.builder()
/* 2086 */         .custom(CombatCommon::canEscape)
/* 2087 */         .withinDistance(0.0D, 48.0D)
/* 2088 */         .guard(40)))
/*      */ 
/*      */     
/* 2091 */     .newBehaviorRoot(
/* 2092 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2093 */       .priority(2.0D)
/* 2094 */       .weight(70.0D)
/* 2095 */       .maxCooldown(0)
/* 2096 */       .addFirstBehavior(
/* 2097 */         CECombatBehaviors.Behavior.builder()
/* 2098 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 2099 */         .custom(CombatCommon::canPerformEating)
/* 2100 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 2101 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/* 2104 */     .newBehaviorRoot(
/* 2105 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2106 */       .priority(2.0D)
/* 2107 */       .weight(100.0D)
/* 2108 */       .maxCooldown(120)
/* 2109 */       .addFirstBehavior(
/* 2110 */         CECombatBehaviors.Behavior.builder()
/* 2111 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2112 */         .custom(CombatCommon::canSwapToBow)
/* 2113 */         .withinDistance(7.0D, 14.0D)
/* 2114 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 2115 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/* 2117 */       .addFirstBehavior(
/* 2118 */         CECombatBehaviors.Behavior.builder()
/* 2119 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2120 */         .custom(CombatCommon::canSwapToBow)
/* 2121 */         .withinDistance(7.0D, 14.0D)
/* 2122 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 2123 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/* 2126 */     .newBehaviorRoot(
/* 2127 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2128 */       .priority(2.0D)
/* 2129 */       .weight(80.0D)
/* 2130 */       .maxCooldown(120)
/* 2131 */       .addFirstBehavior(
/* 2132 */         CECombatBehaviors.Behavior.builder()
/* 2133 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2134 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2135 */         .withinDistance(7.0D, 48.0D)
/* 2136 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2137 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/* 2140 */     .newBehaviorRoot(
/* 2141 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2142 */       .priority(1.0D)
/* 2143 */       .weight(40.0D)
/* 2144 */       .maxCooldown(20)
/* 2145 */       .addFirstBehavior(
/* 2146 */         CECombatBehaviors.Behavior.builder()
/* 2147 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2148 */         .withinDistance(0.0D, 3.0D)
/* 2149 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2150 */         .addNextBehavior(
/* 2151 */           CECombatBehaviors.Behavior.builder()
/* 2152 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2153 */           .withinDistance(0.0D, 3.0D)
/* 2154 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2155 */           .addNextBehavior(
/* 2156 */             CECombatBehaviors.Behavior.builder()
/* 2157 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2158 */             .withinDistance(0.0D, 3.0D)
/* 2159 */             .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2160 */             .addNextBehavior(
/* 2161 */               CECombatBehaviors.Behavior.builder()
/* 2162 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2163 */               .withinDistance(0.0D, 3.0D)
/* 2164 */               .animationBehavior(AVAnimations.DUAL_SWORD_AUTO4, 0.0F)
/* 2165 */               .addNextBehavior(
/* 2166 */                 CECombatBehaviors.Behavior.builder()
/* 2167 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2168 */                 .withinDistance(0.0D, 3.0D)
/* 2169 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO5, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2175 */       .addFirstBehavior(
/* 2176 */         CECombatBehaviors.Behavior.builder()
/* 2177 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2178 */         .withinDistance(0.0D, 3.0D)
/* 2179 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2180 */         .addNextBehavior(
/* 2181 */           CECombatBehaviors.Behavior.builder()
/* 2182 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2183 */           .withinDistance(0.0D, 3.0D)
/* 2184 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2185 */           .addNextBehavior(
/* 2186 */             CECombatBehaviors.Behavior.builder()
/* 2187 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2188 */             .withinDistance(0.0D, 4.0D)
/* 2189 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2190 */             .addNextBehavior(
/* 2191 */               CECombatBehaviors.Behavior.builder()
/* 2192 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2193 */               .withinDistance(0.0D, 4.0D)
/* 2194 */               .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2195 */               .addNextBehavior(
/* 2196 */                 CECombatBehaviors.Behavior.builder()
/* 2197 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2198 */                 .withinDistance(0.0D, 5.0D)
/* 2199 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2200 */                 .addNextBehavior(
/* 2201 */                   CECombatBehaviors.Behavior.builder()
/* 2202 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2203 */                   .withinDistance(0.0D, 5.0D)
/* 2204 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2212 */       .addFirstBehavior(
/* 2213 */         CECombatBehaviors.Behavior.builder()
/* 2214 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2215 */         .withinDistance(0.0D, 3.0D)
/* 2216 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2217 */         .addNextBehavior(
/* 2218 */           CECombatBehaviors.Behavior.builder()
/* 2219 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2220 */           .withinDistance(0.0D, 3.0D)
/* 2221 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2222 */           .addNextBehavior(
/* 2223 */             CECombatBehaviors.Behavior.builder()
/* 2224 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2225 */             .withinDistance(0.0D, 4.0D)
/* 2226 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2227 */             .addNextBehavior(
/* 2228 */               CECombatBehaviors.Behavior.builder()
/* 2229 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2230 */               .withinDistance(0.0D, 4.0D)
/* 2231 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2232 */               .addNextBehavior(
/* 2233 */                 CECombatBehaviors.Behavior.builder()
/* 2234 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2235 */                 .withinDistance(0.0D, 5.0D)
/* 2236 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2237 */                 .addNextBehavior(
/* 2238 */                   CECombatBehaviors.Behavior.builder()
/* 2239 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2240 */                   .withinDistance(0.0D, 5.0D)
/* 2241 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2249 */       .addFirstBehavior(
/* 2250 */         CECombatBehaviors.Behavior.builder()
/* 2251 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2252 */         .withinDistance(0.0D, 3.0D)
/* 2253 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2254 */         .addNextBehavior(
/* 2255 */           CECombatBehaviors.Behavior.builder()
/* 2256 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2257 */           .withinDistance(0.0D, 3.0D)
/* 2258 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2259 */           .addNextBehavior(
/* 2260 */             CECombatBehaviors.Behavior.builder()
/* 2261 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2262 */             .withinDistance(0.0D, 4.0D)
/* 2263 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2264 */             .addNextBehavior(
/* 2265 */               CECombatBehaviors.Behavior.builder()
/* 2266 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2267 */               .withinDistance(0.0D, 4.0D)
/* 2268 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2269 */               .addNextBehavior(
/* 2270 */                 CECombatBehaviors.Behavior.builder()
/* 2271 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2272 */                 .withinDistance(0.0D, 5.0D)
/* 2273 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2274 */                 .addNextBehavior(
/* 2275 */                   CECombatBehaviors.Behavior.builder()
/* 2276 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2277 */                   .withinDistance(0.0D, 5.0D)
/* 2278 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2279 */                   .addNextBehavior(
/* 2280 */                     CECombatBehaviors.Behavior.builder()
/* 2281 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2282 */                     .withinDistance(0.0D, 5.0D)
/* 2283 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2292 */       .addFirstBehavior(
/* 2293 */         CECombatBehaviors.Behavior.builder()
/* 2294 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2295 */         .withinDistance(0.0D, 3.0D)
/* 2296 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2297 */         .addNextBehavior(
/* 2298 */           CECombatBehaviors.Behavior.builder()
/* 2299 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2300 */           .withinDistance(0.0D, 3.0D)
/* 2301 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2302 */           .addNextBehavior(
/* 2303 */             CECombatBehaviors.Behavior.builder()
/* 2304 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2305 */             .withinDistance(0.0D, 4.0D)
/* 2306 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2307 */             .addNextBehavior(
/* 2308 */               CECombatBehaviors.Behavior.builder()
/* 2309 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2310 */               .withinDistance(0.0D, 4.0D)
/* 2311 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2312 */               .addNextBehavior(
/* 2313 */                 CECombatBehaviors.Behavior.builder()
/* 2314 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2315 */                 .withinDistance(0.0D, 5.0D)
/* 2316 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 2317 */                 .addNextBehavior(
/* 2318 */                   CECombatBehaviors.Behavior.builder()
/* 2319 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2320 */                   .withinDistance(0.0D, 5.0D)
/* 2321 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2329 */       .addFirstBehavior(
/* 2330 */         CECombatBehaviors.Behavior.builder()
/* 2331 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2332 */         .withinDistance(0.0D, 3.0D)
/* 2333 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2334 */         .addNextBehavior(
/* 2335 */           CECombatBehaviors.Behavior.builder()
/* 2336 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2337 */           .withinDistance(0.0D, 3.0D)
/* 2338 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2339 */           .addNextBehavior(
/* 2340 */             CECombatBehaviors.Behavior.builder()
/* 2341 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2342 */             .withinDistance(0.0D, 4.0D)
/* 2343 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2344 */             .addNextBehavior(
/* 2345 */               CECombatBehaviors.Behavior.builder()
/* 2346 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2347 */               .withinDistance(0.0D, 4.0D)
/* 2348 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2349 */               .addNextBehavior(
/* 2350 */                 CECombatBehaviors.Behavior.builder()
/* 2351 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2352 */                 .withinDistance(0.0D, 5.0D)
/* 2353 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2354 */                 .addNextBehavior(
/* 2355 */                   CECombatBehaviors.Behavior.builder()
/* 2356 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2357 */                   .withinDistance(0.0D, 5.0D)
/* 2358 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2366 */       .addFirstBehavior(
/* 2367 */         CECombatBehaviors.Behavior.builder()
/* 2368 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2369 */         .withinDistance(0.0D, 3.0D)
/* 2370 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2371 */         .addNextBehavior(
/* 2372 */           CECombatBehaviors.Behavior.builder()
/* 2373 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2374 */           .withinDistance(0.0D, 3.0D)
/* 2375 */           .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2376 */           .addNextBehavior(
/* 2377 */             CECombatBehaviors.Behavior.builder()
/* 2378 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2379 */             .withinDistance(0.0D, 4.0D)
/* 2380 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2381 */             .addNextBehavior(
/* 2382 */               CECombatBehaviors.Behavior.builder()
/* 2383 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2384 */               .withinDistance(0.0D, 4.0D)
/* 2385 */               .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2386 */               .addNextBehavior(
/* 2387 */                 CECombatBehaviors.Behavior.builder()
/* 2388 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2389 */                 .withinDistance(0.0D, 5.0D)
/* 2390 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2391 */                 .addNextBehavior(
/* 2392 */                   CECombatBehaviors.Behavior.builder()
/* 2393 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2394 */                   .withinDistance(0.0D, 5.0D)
/* 2395 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2403 */       .addFirstBehavior(
/* 2404 */         CECombatBehaviors.Behavior.builder()
/* 2405 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2406 */         .withinDistance(0.0D, 3.0D)
/* 2407 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2408 */         .addNextBehavior(
/* 2409 */           CECombatBehaviors.Behavior.builder()
/* 2410 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2411 */           .withinDistance(0.0D, 3.0D)
/* 2412 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2413 */           .addNextBehavior(
/* 2414 */             CECombatBehaviors.Behavior.builder()
/* 2415 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2416 */             .withinDistance(0.0D, 4.0D)
/* 2417 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2418 */             .addNextBehavior(
/* 2419 */               CECombatBehaviors.Behavior.builder()
/* 2420 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2421 */               .withinDistance(0.0D, 4.0D)
/* 2422 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2423 */               .addNextBehavior(
/* 2424 */                 CECombatBehaviors.Behavior.builder()
/* 2425 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2426 */                 .withinDistance(0.0D, 5.0D)
/* 2427 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2428 */                 .addNextBehavior(
/* 2429 */                   CECombatBehaviors.Behavior.builder()
/* 2430 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2431 */                   .withinDistance(0.0D, 5.0D)
/* 2432 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2440 */       .addFirstBehavior(
/* 2441 */         CECombatBehaviors.Behavior.builder()
/* 2442 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2443 */         .withinDistance(0.0D, 3.0D)
/* 2444 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2445 */         .addNextBehavior(
/* 2446 */           CECombatBehaviors.Behavior.builder()
/* 2447 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2448 */           .withinDistance(0.0D, 3.0D)
/* 2449 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2450 */           .addNextBehavior(
/* 2451 */             CECombatBehaviors.Behavior.builder()
/* 2452 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2453 */             .withinDistance(0.0D, 4.0D)
/* 2454 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2455 */             .addNextBehavior(
/* 2456 */               CECombatBehaviors.Behavior.builder()
/* 2457 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2458 */               .withinDistance(0.0D, 4.0D)
/* 2459 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2460 */               .addNextBehavior(
/* 2461 */                 CECombatBehaviors.Behavior.builder()
/* 2462 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2463 */                 .withinDistance(0.0D, 5.0D)
/* 2464 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2465 */                 .addNextBehavior(
/* 2466 */                   CECombatBehaviors.Behavior.builder()
/* 2467 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2468 */                   .withinDistance(0.0D, 5.0D)
/* 2469 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2477 */       .addFirstBehavior(
/* 2478 */         CECombatBehaviors.Behavior.builder()
/* 2479 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2480 */         .withinDistance(0.0D, 3.0D)
/* 2481 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2482 */         .addNextBehavior(
/* 2483 */           CECombatBehaviors.Behavior.builder()
/* 2484 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2485 */           .withinDistance(0.0D, 3.0D)
/* 2486 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2487 */           .addNextBehavior(
/* 2488 */             CECombatBehaviors.Behavior.builder()
/* 2489 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2490 */             .withinDistance(0.0D, 4.0D)
/* 2491 */             .animationBehavior(AVAnimations.DUAL_SWORD_AUTO4, 0.0F)
/* 2492 */             .addNextBehavior(
/* 2493 */               CECombatBehaviors.Behavior.builder()
/* 2494 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2495 */               .withinDistance(0.0D, 4.0D)
/* 2496 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2497 */               .addNextBehavior(
/* 2498 */                 CECombatBehaviors.Behavior.builder()
/* 2499 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2500 */                 .withinDistance(0.0D, 5.0D)
/* 2501 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2502 */                 .addNextBehavior(
/* 2503 */                   CECombatBehaviors.Behavior.builder()
/* 2504 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2505 */                   .withinDistance(0.0D, 5.0D)
/* 2506 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2514 */       .addFirstBehavior(
/* 2515 */         CECombatBehaviors.Behavior.builder()
/* 2516 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2517 */         .withinDistance(0.0D, 3.0D)
/* 2518 */         .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2519 */         .addNextBehavior(
/* 2520 */           CECombatBehaviors.Behavior.builder()
/* 2521 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2522 */           .withinDistance(0.0D, 3.0D)
/* 2523 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2524 */           .addNextBehavior(
/* 2525 */             CECombatBehaviors.Behavior.builder()
/* 2526 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2527 */             .withinDistance(0.0D, 4.0D)
/* 2528 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2529 */             .addNextBehavior(
/* 2530 */               CECombatBehaviors.Behavior.builder()
/* 2531 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2532 */               .withinDistance(0.0D, 4.0D)
/* 2533 */               .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2534 */               .addNextBehavior(
/* 2535 */                 CECombatBehaviors.Behavior.builder()
/* 2536 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2537 */                 .withinDistance(0.0D, 5.0D)
/* 2538 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 2539 */                 .addNextBehavior(
/* 2540 */                   CECombatBehaviors.Behavior.builder()
/* 2541 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2542 */                   .withinDistance(0.0D, 5.0D)
/* 2543 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2551 */       .addFirstBehavior(
/* 2552 */         CECombatBehaviors.Behavior.builder()
/* 2553 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2554 */         .withinDistance(0.0D, 3.0D)
/* 2555 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2556 */         .addNextBehavior(
/* 2557 */           CECombatBehaviors.Behavior.builder()
/* 2558 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2559 */           .withinDistance(0.0D, 3.0D)
/* 2560 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2561 */           .addNextBehavior(
/* 2562 */             CECombatBehaviors.Behavior.builder()
/* 2563 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2564 */             .withinDistance(0.0D, 4.0D)
/* 2565 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2566 */             .addNextBehavior(
/* 2567 */               CECombatBehaviors.Behavior.builder()
/* 2568 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2569 */               .withinDistance(0.0D, 4.0D)
/* 2570 */               .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 2571 */               .addNextBehavior(
/* 2572 */                 CECombatBehaviors.Behavior.builder()
/* 2573 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2574 */                 .withinDistance(0.0D, 5.0D)
/* 2575 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2582 */       .addFirstBehavior(
/* 2583 */         CECombatBehaviors.Behavior.builder()
/* 2584 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2585 */         .withinDistance(0.0D, 3.0D)
/* 2586 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2587 */         .addNextBehavior(
/* 2588 */           CECombatBehaviors.Behavior.builder()
/* 2589 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2590 */           .withinDistance(0.0D, 3.0D)
/* 2591 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2592 */           .addNextBehavior(
/* 2593 */             CECombatBehaviors.Behavior.builder()
/* 2594 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2595 */             .withinDistance(0.0D, 4.0D)
/* 2596 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2597 */             .addNextBehavior(
/* 2598 */               CECombatBehaviors.Behavior.builder()
/* 2599 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2600 */               .withinDistance(0.0D, 4.0D)
/* 2601 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2602 */               .addNextBehavior(
/* 2603 */                 CECombatBehaviors.Behavior.builder()
/* 2604 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2605 */                 .withinDistance(0.0D, 5.0D)
/* 2606 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2607 */                 .addNextBehavior(
/* 2608 */                   CECombatBehaviors.Behavior.builder()
/* 2609 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2610 */                   .withinDistance(0.0D, 5.0D)
/* 2611 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 2612 */                   .addNextBehavior(
/* 2613 */                     CECombatBehaviors.Behavior.builder()
/* 2614 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2615 */                     .withinDistance(0.0D, 5.0D)
/* 2616 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2625 */       .addFirstBehavior(
/* 2626 */         CECombatBehaviors.Behavior.builder()
/* 2627 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2628 */         .withinDistance(0.0D, 3.0D)
/* 2629 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2630 */         .addNextBehavior(
/* 2631 */           CECombatBehaviors.Behavior.builder()
/* 2632 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2633 */           .withinDistance(0.0D, 3.0D)
/* 2634 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2635 */           .addNextBehavior(
/* 2636 */             CECombatBehaviors.Behavior.builder()
/* 2637 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2638 */             .withinDistance(0.0D, 4.0D)
/* 2639 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 2640 */             .addNextBehavior(
/* 2641 */               CECombatBehaviors.Behavior.builder()
/* 2642 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2643 */               .withinDistance(0.0D, 4.0D)
/* 2644 */               .animationBehavior(AVAnimations.DUAL_SWORD_AUTO5, 0.0F)
/* 2645 */               .addNextBehavior(
/* 2646 */                 CECombatBehaviors.Behavior.builder()
/* 2647 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2648 */                 .withinDistance(0.0D, 5.0D)
/* 2649 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 2650 */                 .addNextBehavior(
/* 2651 */                   CECombatBehaviors.Behavior.builder()
/* 2652 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2653 */                   .withinDistance(0.0D, 5.0D)
/* 2654 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2662 */       .addFirstBehavior(
/* 2663 */         CECombatBehaviors.Behavior.builder()
/* 2664 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2665 */         .withinDistance(0.0D, 3.0D)
/* 2666 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2667 */         .addNextBehavior(
/* 2668 */           CECombatBehaviors.Behavior.builder()
/* 2669 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2670 */           .withinDistance(0.0D, 3.0D)
/* 2671 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 2672 */           .addNextBehavior(
/* 2673 */             CECombatBehaviors.Behavior.builder()
/* 2674 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2675 */             .withinDistance(0.0D, 4.0D)
/* 2676 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2677 */             .addNextBehavior(
/* 2678 */               CECombatBehaviors.Behavior.builder()
/* 2679 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2680 */               .withinDistance(0.0D, 4.0D)
/* 2681 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2682 */               .addNextBehavior(
/* 2683 */                 CECombatBehaviors.Behavior.builder()
/* 2684 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2685 */                 .withinDistance(0.0D, 5.0D)
/* 2686 */                 .animationBehavior(AVAnimations.DUAL_SWORD_AUTO3, 0.0F)
/* 2687 */                 .addNextBehavior(
/* 2688 */                   CECombatBehaviors.Behavior.builder()
/* 2689 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2690 */                   .withinDistance(0.0D, 5.0D)
/* 2691 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 2692 */                   .addNextBehavior(
/* 2693 */                     CECombatBehaviors.Behavior.builder()
/* 2694 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2695 */                     .withinDistance(0.0D, 5.0D)
/* 2696 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2705 */       .addFirstBehavior(
/* 2706 */         CECombatBehaviors.Behavior.builder()
/* 2707 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2708 */         .withinDistance(0.0D, 3.0D)
/* 2709 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 2710 */         .addNextBehavior(
/* 2711 */           CECombatBehaviors.Behavior.builder()
/* 2712 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2713 */           .withinDistance(0.0D, 3.0D)
/* 2714 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 2715 */           .addNextBehavior(
/* 2716 */             CECombatBehaviors.Behavior.builder()
/* 2717 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2718 */             .withinDistance(0.0D, 4.0D)
/* 2719 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 2720 */             .addNextBehavior(
/* 2721 */               CECombatBehaviors.Behavior.builder()
/* 2722 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2723 */               .withinDistance(0.0D, 4.0D)
/* 2724 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 2725 */               .addNextBehavior(
/* 2726 */                 CECombatBehaviors.Behavior.builder()
/* 2727 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2728 */                 .withinDistance(0.0D, 5.0D)
/* 2729 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 2730 */                 .addNextBehavior(
/* 2731 */                   CECombatBehaviors.Behavior.builder()
/* 2732 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2733 */                   .withinDistance(0.0D, 5.0D)
/* 2734 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2742 */     .newBehaviorRoot(
/* 2743 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2744 */       .priority(1.0D)
/* 2745 */       .weight(20.0D)
/* 2746 */       .maxCooldown(100)
/* 2747 */       .addFirstBehavior(
/* 2748 */         CECombatBehaviors.Behavior.builder()
/* 2749 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2750 */         .withinDistance(0.0D, 3.0D)
/* 2751 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 2752 */         .addNextBehavior(
/* 2753 */           CECombatBehaviors.Behavior.builder()
/* 2754 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2755 */           .withinDistance(0.0D, 3.0D)
/* 2756 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 2757 */           .addNextBehavior(
/* 2758 */             CECombatBehaviors.Behavior.builder()
/* 2759 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2760 */             .withinDistance(0.0D, 3.0D)
/* 2761 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 2762 */             .addNextBehavior(
/* 2763 */               CECombatBehaviors.Behavior.builder()
/* 2764 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2765 */               .withinDistance(0.0D, 3.0D)
/* 2766 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2772 */     .newBehaviorRoot(
/* 2773 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2774 */       .priority(1.0D)
/* 2775 */       .weight(10.0D)
/* 2776 */       .maxCooldown(100)
/* 2777 */       .addFirstBehavior(
/* 2778 */         CECombatBehaviors.Behavior.builder()
/* 2779 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2780 */         .withinDistance(0.0D, 3.0D)
/* 2781 */         .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F))
/*      */       
/* 2783 */       .addFirstBehavior(
/* 2784 */         CECombatBehaviors.Behavior.builder()
/* 2785 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2786 */         .withinDistance(0.0D, 3.0D)
/* 2787 */         .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F))
/*      */       
/* 2789 */       .addFirstBehavior(
/* 2790 */         CECombatBehaviors.Behavior.builder()
/* 2791 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2792 */         .withinDistance(0.0D, 3.0D)
/* 2793 */         .animationBehavior(Animations.DANCING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 2796 */     .newBehaviorRoot(
/* 2797 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2798 */       .priority(1.0D)
/* 2799 */       .weight(10.0D)
/* 2800 */       .maxCooldown(40)
/* 2801 */       .addFirstBehavior(
/* 2802 */         CECombatBehaviors.Behavior.builder()
/* 2803 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2804 */         .withinDistance(0.0D, 3.0D)
/* 2805 */         .custom(CombatCommon::canThrowEnderPearl)
/* 2806 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 2807 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 2810 */     .newBehaviorRoot(
/* 2811 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2812 */       .priority(1.0D)
/* 2813 */       .weight(2.0D)
/* 2814 */       .maxCooldown(100)
/* 2815 */       .addFirstBehavior(
/* 2816 */         CECombatBehaviors.Behavior.builder()
/* 2817 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2818 */         .withinDistance(0.0D, 3.0D)
/* 2819 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 2821 */       .addFirstBehavior(
/* 2822 */         CECombatBehaviors.Behavior.builder()
/* 2823 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2824 */         .withinDistance(0.0D, 3.0D)
/* 2825 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 2827 */       .addFirstBehavior(
/* 2828 */         CECombatBehaviors.Behavior.builder()
/* 2829 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2830 */         .withinDistance(0.0D, 3.0D)
/* 2831 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 2833 */       .addFirstBehavior(
/* 2834 */         CECombatBehaviors.Behavior.builder()
/* 2835 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2836 */         .withinDistance(0.0D, 3.0D)
/* 2837 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 2839 */       .addFirstBehavior(
/* 2840 */         CECombatBehaviors.Behavior.builder()
/* 2841 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2842 */         .withinDistance(0.0D, 3.0D)
/* 2843 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 2845 */       .addFirstBehavior(
/* 2846 */         CECombatBehaviors.Behavior.builder()
/* 2847 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2848 */         .withinDistance(0.0D, 3.0D)
/* 2849 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 2851 */       .addFirstBehavior(
/* 2852 */         CECombatBehaviors.Behavior.builder()
/* 2853 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2854 */         .withinDistance(0.0D, 3.0D)
/* 2855 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 2858 */     .newBehaviorRoot(
/* 2859 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2860 */       .priority(1.0D)
/* 2861 */       .weight(15.0D)
/* 2862 */       .addFirstBehavior(
/* 2863 */         CECombatBehaviors.Behavior.builder()
/* 2864 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2865 */         .withinDistance(0.0D, 3.0D)
/* 2866 */         .custom(CombatCommon::canPerformGuarding)
/* 2867 */         .guard(40)))
/*      */ 
/*      */     
/* 2870 */     .newBehaviorRoot(
/* 2871 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2872 */       .priority(1.0D)
/* 2873 */       .weight(10.0D)
/* 2874 */       .addFirstBehavior(
/* 2875 */         CECombatBehaviors.Behavior.builder()
/* 2876 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2877 */         .withinDistance(0.0D, 3.0D)
/* 2878 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 2880 */       .addFirstBehavior(
/* 2881 */         CECombatBehaviors.Behavior.builder()
/* 2882 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2883 */         .withinDistance(0.0D, 3.0D)
/* 2884 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 2887 */     .newBehaviorRoot(
/* 2888 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2889 */       .priority(1.0D)
/* 2890 */       .weight(40.0D)
/* 2891 */       .maxCooldown(160)
/* 2892 */       .addFirstBehavior(
/* 2893 */         CECombatBehaviors.Behavior.builder()
/* 2894 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2895 */         .custom(CombatCommon::canJump)
/* 2896 */         .withinDistance(5.0D, 14.0D)
/* 2897 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2898 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\NpcTachi.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */