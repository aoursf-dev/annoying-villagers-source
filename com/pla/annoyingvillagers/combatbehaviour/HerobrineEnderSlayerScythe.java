/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HerobrineEnderSlayerScythe
/*      */ {
/*   15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> ENDER_SLAYER_SCYTHE = CECombatBehaviors.builder()
/*   16 */     .newBehaviorRoot(
/*   17 */       CECombatBehaviors.BehaviorRoot.builder()
/*   18 */       .priority(5.0D)
/*   19 */       .weight(1000.0D)
/*   20 */       .maxCooldown(0)
/*   21 */       .addFirstBehavior(
/*   22 */         CECombatBehaviors.Behavior.builder()
/*   23 */         .custom(CombatCommon::isNotRiding)
/*   24 */         .custom(CombatCommon::canExecute)
/*   25 */         .withinDistance(0.0D, 5.0D)
/*   26 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*   27 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*   30 */     .newBehaviorRoot(
/*   31 */       CECombatBehaviors.BehaviorRoot.builder()
/*   32 */       .priority(4.0D)
/*   33 */       .weight(1000.0D)
/*   34 */       .maxCooldown(0)
/*   35 */       .addFirstBehavior(
/*   36 */         CECombatBehaviors.Behavior.builder()
/*   37 */         .custom(CombatCommon::isNotRiding)
/*   38 */         .custom(CombatCommon::canEscape)
/*   39 */         .withinDistance(0.0D, 8.0D)
/*   40 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*   41 */         .addExBehavior(HerobrineCommon::performEscapeRunAwayWithLowClone))
/*      */       
/*   43 */       .addFirstBehavior(
/*   44 */         CECombatBehaviors.Behavior.builder()
/*   45 */         .custom(CombatCommon::isNotRiding)
/*   46 */         .custom(CombatCommon::canEscape)
/*   47 */         .withinDistance(0.0D, 48.0D)
/*   48 */         .guard(40)))
/*      */ 
/*      */     
/*   51 */     .newBehaviorRoot(
/*   52 */       CECombatBehaviors.BehaviorRoot.builder()
/*   53 */       .priority(2.0D)
/*   54 */       .weight(70.0D)
/*   55 */       .maxCooldown(0)
/*   56 */       .addFirstBehavior(
/*   57 */         CECombatBehaviors.Behavior.builder()
/*   58 */         .custom(CombatCommon::isNotRiding)
/*   59 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   60 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   61 */         .custom(HerobrineCommon::canPerformHealing)
/*   62 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*   63 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*      */ 
/*      */     
/*   66 */     .newBehaviorRoot(
/*   67 */       CECombatBehaviors.BehaviorRoot.builder()
/*   68 */       .priority(1.0D)
/*   69 */       .weight(30.0D)
/*   70 */       .maxCooldown(120)
/*   71 */       .addFirstBehavior(
/*   72 */         CECombatBehaviors.Behavior.builder()
/*   73 */         .custom(CombatCommon::isNotRiding)
/*   74 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   75 */         .withinDistance(7.0D, 48.0D)
/*   76 */         .animationBehavior(AVAnimations.HEROBRINE_MOB_ENDERSTEP_OBSCURIS, 0.0F)
/*   77 */         .addExBehavior(HerobrineCommon::giveSlowFalling)))
/*      */ 
/*      */     
/*   80 */     .newBehaviorRoot(
/*   81 */       CECombatBehaviors.BehaviorRoot.builder()
/*   82 */       .priority(1.0D)
/*   83 */       .weight(40.0D)
/*   84 */       .maxCooldown(20)
/*   85 */       .addFirstBehavior(
/*   86 */         CECombatBehaviors.Behavior.builder()
/*   87 */         .custom(CombatCommon::isNotRiding)
/*   88 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   89 */         .withinDistance(0.0D, 3.0D)
/*   90 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/*   91 */         .addNextBehavior(
/*   92 */           CECombatBehaviors.Behavior.builder()
/*   93 */           .custom(CombatCommon::isNotRiding)
/*   94 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*   95 */           .withinDistance(0.0D, 4.0D)
/*   96 */           .animationBehavior(WOMAnimations.KICK_AUTO_3, 0.0F)
/*   97 */           .addNextBehavior(
/*   98 */             CECombatBehaviors.Behavior.builder()
/*   99 */             .custom(CombatCommon::isNotRiding)
/*  100 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  101 */             .withinDistance(0.0D, 4.0D)
/*  102 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  103 */             .addNextBehavior(
/*  104 */               CECombatBehaviors.Behavior.builder()
/*  105 */               .custom(CombatCommon::isNotRiding)
/*  106 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  107 */               .withinDistance(0.0D, 5.0D)
/*  108 */               .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F)
/*  109 */               .addNextBehavior(
/*  110 */                 CECombatBehaviors.Behavior.builder()
/*  111 */                 .custom(CombatCommon::isNotRiding)
/*  112 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  113 */                 .withinDistance(0.0D, 5.0D)
/*  114 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  120 */       .addFirstBehavior(
/*  121 */         CECombatBehaviors.Behavior.builder()
/*  122 */         .custom(CombatCommon::isNotRiding)
/*  123 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  124 */         .withinDistance(0.0D, 4.0D)
/*  125 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  126 */         .addNextBehavior(
/*  127 */           CECombatBehaviors.Behavior.builder()
/*  128 */           .custom(CombatCommon::isNotRiding)
/*  129 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  130 */           .withinDistance(0.0D, 8.0D)
/*  131 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  132 */           .addNextBehavior(
/*  133 */             CECombatBehaviors.Behavior.builder()
/*  134 */             .custom(CombatCommon::isNotRiding)
/*  135 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  136 */             .withinDistance(0.0D, 4.0D)
/*  137 */             .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F)
/*  138 */             .addNextBehavior(
/*  139 */               CECombatBehaviors.Behavior.builder()
/*  140 */               .custom(CombatCommon::isNotRiding)
/*  141 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  142 */               .withinDistance(0.0D, 8.0D)
/*  143 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  144 */               .addNextBehavior(
/*  145 */                 CECombatBehaviors.Behavior.builder()
/*  146 */                 .custom(CombatCommon::isNotRiding)
/*  147 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  148 */                 .withinDistance(0.0D, 5.0D)
/*  149 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  155 */       .addFirstBehavior(
/*  156 */         CECombatBehaviors.Behavior.builder()
/*  157 */         .custom(CombatCommon::isNotRiding)
/*  158 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  159 */         .withinDistance(0.0D, 3.0D)
/*  160 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/*  161 */         .addNextBehavior(
/*  162 */           CECombatBehaviors.Behavior.builder()
/*  163 */           .custom(CombatCommon::isNotRiding)
/*  164 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  165 */           .withinDistance(0.0D, 8.0D)
/*  166 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  167 */           .addNextBehavior(
/*  168 */             CECombatBehaviors.Behavior.builder()
/*  169 */             .custom(CombatCommon::isNotRiding)
/*  170 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  171 */             .withinDistance(0.0D, 4.0D)
/*  172 */             .animationBehavior(WOMAnimations.KICK_AUTO_3, 0.0F)
/*  173 */             .addNextBehavior(
/*  174 */               CECombatBehaviors.Behavior.builder()
/*  175 */               .custom(CombatCommon::isNotRiding)
/*  176 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  177 */               .withinDistance(0.0D, 8.0D)
/*  178 */               .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/*  179 */               .addNextBehavior(
/*  180 */                 CECombatBehaviors.Behavior.builder()
/*  181 */                 .custom(CombatCommon::isNotRiding)
/*  182 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  183 */                 .withinDistance(0.0D, 5.0D)
/*  184 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  190 */       .addFirstBehavior(
/*  191 */         CECombatBehaviors.Behavior.builder()
/*  192 */         .custom(CombatCommon::isNotRiding)
/*  193 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  194 */         .withinDistance(0.0D, 4.0D)
/*  195 */         .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F)
/*  196 */         .addNextBehavior(
/*  197 */           CECombatBehaviors.Behavior.builder()
/*  198 */           .custom(CombatCommon::isNotRiding)
/*  199 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  200 */           .withinDistance(0.0D, 8.0D)
/*  201 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  202 */           .addNextBehavior(
/*  203 */             CECombatBehaviors.Behavior.builder()
/*  204 */             .custom(CombatCommon::isNotRiding)
/*  205 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  206 */             .withinDistance(0.0D, 5.0D)
/*  207 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  208 */             .addNextBehavior(
/*  209 */               CECombatBehaviors.Behavior.builder()
/*  210 */               .custom(CombatCommon::isNotRiding)
/*  211 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  212 */               .withinDistance(0.0D, 8.0D)
/*  213 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  214 */               .addNextBehavior(
/*  215 */                 CECombatBehaviors.Behavior.builder()
/*  216 */                 .custom(CombatCommon::isNotRiding)
/*  217 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  218 */                 .withinDistance(0.0D, 4.5D)
/*  219 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  225 */       .addFirstBehavior(
/*  226 */         CECombatBehaviors.Behavior.builder()
/*  227 */         .custom(CombatCommon::isNotRiding)
/*  228 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  229 */         .withinDistance(0.0D, 6.0D)
/*  230 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F)
/*  231 */         .addNextBehavior(
/*  232 */           CECombatBehaviors.Behavior.builder()
/*  233 */           .custom(CombatCommon::isNotRiding)
/*  234 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  235 */           .withinDistance(0.0D, 10.0D)
/*  236 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  237 */           .addNextBehavior(
/*  238 */             CECombatBehaviors.Behavior.builder()
/*  239 */             .custom(CombatCommon::isNotRiding)
/*  240 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  241 */             .withinDistance(0.0D, 4.0D)
/*  242 */             .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F)
/*  243 */             .addNextBehavior(
/*  244 */               CECombatBehaviors.Behavior.builder()
/*  245 */               .custom(CombatCommon::isNotRiding)
/*  246 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  247 */               .withinDistance(0.0D, 8.0D)
/*  248 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  249 */               .addNextBehavior(
/*  250 */                 CECombatBehaviors.Behavior.builder()
/*  251 */                 .custom(CombatCommon::isNotRiding)
/*  252 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  253 */                 .withinDistance(0.0D, 5.0D)
/*  254 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  260 */       .addFirstBehavior(
/*  261 */         CECombatBehaviors.Behavior.builder()
/*  262 */         .custom(CombatCommon::isNotRiding)
/*  263 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  264 */         .withinDistance(0.0D, 4.5D)
/*  265 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  266 */         .addNextBehavior(
/*  267 */           CECombatBehaviors.Behavior.builder()
/*  268 */           .custom(CombatCommon::isNotRiding)
/*  269 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  270 */           .withinDistance(0.0D, 8.0D)
/*  271 */           .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  272 */           .addNextBehavior(
/*  273 */             CECombatBehaviors.Behavior.builder()
/*  274 */             .custom(CombatCommon::isNotRiding)
/*  275 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  276 */             .withinDistance(0.0D, 4.0D)
/*  277 */             .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F)
/*  278 */             .addNextBehavior(
/*  279 */               CECombatBehaviors.Behavior.builder()
/*  280 */               .custom(CombatCommon::isNotRiding)
/*  281 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  282 */               .withinDistance(0.0D, 8.0D)
/*  283 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  284 */               .addNextBehavior(
/*  285 */                 CECombatBehaviors.Behavior.builder()
/*  286 */                 .custom(CombatCommon::isNotRiding)
/*  287 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  288 */                 .withinDistance(0.0D, 4.5D)
/*  289 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  295 */       .addFirstBehavior(
/*  296 */         CECombatBehaviors.Behavior.builder()
/*  297 */         .custom(CombatCommon::isNotRiding)
/*  298 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  299 */         .withinDistance(0.0D, 4.0D)
/*  300 */         .animationBehavior(WOMAnimations.KICK_AUTO_3, 0.0F)
/*  301 */         .addNextBehavior(
/*  302 */           CECombatBehaviors.Behavior.builder()
/*  303 */           .custom(CombatCommon::isNotRiding)
/*  304 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  305 */           .withinDistance(0.0D, 10.0D)
/*  306 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  307 */           .addNextBehavior(
/*  308 */             CECombatBehaviors.Behavior.builder()
/*  309 */             .custom(CombatCommon::isNotRiding)
/*  310 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  311 */             .withinDistance(0.0D, 4.0D)
/*  312 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  313 */             .addNextBehavior(
/*  314 */               CECombatBehaviors.Behavior.builder()
/*  315 */               .custom(CombatCommon::isNotRiding)
/*  316 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  317 */               .withinDistance(0.0D, 8.0D)
/*  318 */               .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  319 */               .addNextBehavior(
/*  320 */                 CECombatBehaviors.Behavior.builder()
/*  321 */                 .custom(CombatCommon::isNotRiding)
/*  322 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  323 */                 .withinDistance(0.0D, 5.0D)
/*  324 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  330 */       .addFirstBehavior(
/*  331 */         CECombatBehaviors.Behavior.builder()
/*  332 */         .custom(CombatCommon::isNotRiding)
/*  333 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  334 */         .withinDistance(0.0D, 5.0D)
/*  335 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F)
/*  336 */         .addNextBehavior(
/*  337 */           CECombatBehaviors.Behavior.builder()
/*  338 */           .custom(CombatCommon::isNotRiding)
/*  339 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  340 */           .withinDistance(0.0D, 10.0D)
/*  341 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  342 */           .addNextBehavior(
/*  343 */             CECombatBehaviors.Behavior.builder()
/*  344 */             .custom(CombatCommon::isNotRiding)
/*  345 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  346 */             .withinDistance(0.0D, 4.0D)
/*  347 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  348 */             .addNextBehavior(
/*  349 */               CECombatBehaviors.Behavior.builder()
/*  350 */               .custom(CombatCommon::isNotRiding)
/*  351 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  352 */               .withinDistance(0.0D, 8.0D)
/*  353 */               .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/*  354 */               .addNextBehavior(
/*  355 */                 CECombatBehaviors.Behavior.builder()
/*  356 */                 .custom(CombatCommon::isNotRiding)
/*  357 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  358 */                 .withinDistance(0.0D, 4.0D)
/*  359 */                 .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  365 */       .addFirstBehavior(
/*  366 */         CECombatBehaviors.Behavior.builder()
/*  367 */         .custom(CombatCommon::isNotRiding)
/*  368 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  369 */         .withinDistance(0.0D, 4.0D)
/*  370 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  371 */         .addNextBehavior(
/*  372 */           CECombatBehaviors.Behavior.builder()
/*  373 */           .custom(CombatCommon::isNotRiding)
/*  374 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  375 */           .withinDistance(0.0D, 9.0D)
/*  376 */           .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/*  377 */           .addNextBehavior(
/*  378 */             CECombatBehaviors.Behavior.builder()
/*  379 */             .custom(CombatCommon::isNotRiding)
/*  380 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  381 */             .withinDistance(0.0D, 4.5D)
/*  382 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  383 */             .addNextBehavior(
/*  384 */               CECombatBehaviors.Behavior.builder()
/*  385 */               .custom(CombatCommon::isNotRiding)
/*  386 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  387 */               .withinDistance(0.0D, 8.0D)
/*  388 */               .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  389 */               .addNextBehavior(
/*  390 */                 CECombatBehaviors.Behavior.builder()
/*  391 */                 .custom(CombatCommon::isNotRiding)
/*  392 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  393 */                 .withinDistance(0.0D, 6.0D)
/*  394 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  400 */       .addFirstBehavior(
/*  401 */         CECombatBehaviors.Behavior.builder()
/*  402 */         .custom(CombatCommon::isNotRiding)
/*  403 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  404 */         .withinDistance(0.0D, 4.0D)
/*  405 */         .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F)
/*  406 */         .addNextBehavior(
/*  407 */           CECombatBehaviors.Behavior.builder()
/*  408 */           .custom(CombatCommon::isNotRiding)
/*  409 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  410 */           .withinDistance(0.0D, 8.0D)
/*  411 */           .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  412 */           .addNextBehavior(
/*  413 */             CECombatBehaviors.Behavior.builder()
/*  414 */             .custom(CombatCommon::isNotRiding)
/*  415 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  416 */             .withinDistance(0.0D, 4.5D)
/*  417 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/*  418 */             .addNextBehavior(
/*  419 */               CECombatBehaviors.Behavior.builder()
/*  420 */               .custom(CombatCommon::isNotRiding)
/*  421 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  422 */               .withinDistance(0.0D, 10.0D)
/*  423 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  424 */               .addNextBehavior(
/*  425 */                 CECombatBehaviors.Behavior.builder()
/*  426 */                 .custom(CombatCommon::isNotRiding)
/*  427 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  428 */                 .withinDistance(0.0D, 5.0D)
/*  429 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  435 */       .addFirstBehavior(
/*  436 */         CECombatBehaviors.Behavior.builder()
/*  437 */         .custom(CombatCommon::isNotRiding)
/*  438 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  439 */         .withinDistance(0.0D, 4.5D)
/*  440 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/*  441 */         .addNextBehavior(
/*  442 */           CECombatBehaviors.Behavior.builder()
/*  443 */           .custom(CombatCommon::isNotRiding)
/*  444 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  445 */           .withinDistance(0.0D, 8.0D)
/*  446 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  447 */           .addNextBehavior(
/*  448 */             CECombatBehaviors.Behavior.builder()
/*  449 */             .custom(CombatCommon::isNotRiding)
/*  450 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  451 */             .withinDistance(0.0D, 4.0D)
/*  452 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  453 */             .addNextBehavior(
/*  454 */               CECombatBehaviors.Behavior.builder()
/*  455 */               .custom(CombatCommon::isNotRiding)
/*  456 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  457 */               .withinDistance(0.0D, 8.0D)
/*  458 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  459 */               .addNextBehavior(
/*  460 */                 CECombatBehaviors.Behavior.builder()
/*  461 */                 .custom(CombatCommon::isNotRiding)
/*  462 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  463 */                 .withinDistance(0.0D, 4.5D)
/*  464 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  470 */       .addFirstBehavior(
/*  471 */         CECombatBehaviors.Behavior.builder()
/*  472 */         .custom(CombatCommon::isNotRiding)
/*  473 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  474 */         .withinDistance(0.0D, 4.5D)
/*  475 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  476 */         .addNextBehavior(
/*  477 */           CECombatBehaviors.Behavior.builder()
/*  478 */           .custom(CombatCommon::isNotRiding)
/*  479 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  480 */           .withinDistance(0.0D, 10.0D)
/*  481 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  482 */           .addNextBehavior(
/*  483 */             CECombatBehaviors.Behavior.builder()
/*  484 */             .custom(CombatCommon::isNotRiding)
/*  485 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */             .withinDistance(0.0D, 6.0D)
/*  487 */             .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F)
/*  488 */             .addNextBehavior(
/*  489 */               CECombatBehaviors.Behavior.builder()
/*  490 */               .custom(CombatCommon::isNotRiding)
/*  491 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  492 */               .withinDistance(0.0D, 8.0D)
/*  493 */               .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  494 */               .addNextBehavior(
/*  495 */                 CECombatBehaviors.Behavior.builder()
/*  496 */                 .custom(CombatCommon::isNotRiding)
/*  497 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  498 */                 .withinDistance(0.0D, 5.0D)
/*  499 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  505 */       .addFirstBehavior(
/*  506 */         CECombatBehaviors.Behavior.builder()
/*  507 */         .custom(CombatCommon::isNotRiding)
/*  508 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  509 */         .withinDistance(0.0D, 4.0D)
/*  510 */         .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F)
/*  511 */         .addNextBehavior(
/*  512 */           CECombatBehaviors.Behavior.builder()
/*  513 */           .custom(CombatCommon::isNotRiding)
/*  514 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  515 */           .withinDistance(0.0D, 10.0D)
/*  516 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  517 */           .addNextBehavior(
/*  518 */             CECombatBehaviors.Behavior.builder()
/*  519 */             .custom(CombatCommon::isNotRiding)
/*  520 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  521 */             .withinDistance(0.0D, 4.0D)
/*  522 */             .animationBehavior(WOMAnimations.KICK_AUTO_3, 0.0F)
/*  523 */             .addNextBehavior(
/*  524 */               CECombatBehaviors.Behavior.builder()
/*  525 */               .custom(CombatCommon::isNotRiding)
/*  526 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  527 */               .withinDistance(0.0D, 8.0D)
/*  528 */               .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/*  529 */               .addNextBehavior(
/*  530 */                 CECombatBehaviors.Behavior.builder()
/*  531 */                 .custom(CombatCommon::isNotRiding)
/*  532 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  533 */                 .withinDistance(0.0D, 5.0D)
/*  534 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  540 */       .addFirstBehavior(
/*  541 */         CECombatBehaviors.Behavior.builder()
/*  542 */         .custom(CombatCommon::isNotRiding)
/*  543 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  544 */         .withinDistance(0.0D, 4.0D)
/*  545 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  546 */         .addNextBehavior(
/*  547 */           CECombatBehaviors.Behavior.builder()
/*  548 */           .custom(CombatCommon::isNotRiding)
/*  549 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  550 */           .withinDistance(0.0D, 8.0D)
/*  551 */           .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  552 */           .addNextBehavior(
/*  553 */             CECombatBehaviors.Behavior.builder()
/*  554 */             .custom(CombatCommon::isNotRiding)
/*  555 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  556 */             .withinDistance(0.0D, 4.0D)
/*  557 */             .animationBehavior(WOMAnimations.KICK_AUTO_3, 0.0F)
/*  558 */             .addNextBehavior(
/*  559 */               CECombatBehaviors.Behavior.builder()
/*  560 */               .custom(CombatCommon::isNotRiding)
/*  561 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  562 */               .withinDistance(0.0D, 8.0D)
/*  563 */               .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  564 */               .addNextBehavior(
/*  565 */                 CECombatBehaviors.Behavior.builder()
/*  566 */                 .custom(CombatCommon::isNotRiding)
/*  567 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  568 */                 .withinDistance(0.0D, 4.5D)
/*  569 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  575 */       .addFirstBehavior(
/*  576 */         CECombatBehaviors.Behavior.builder()
/*  577 */         .custom(CombatCommon::isNotRiding)
/*  578 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  579 */         .withinDistance(0.0D, 4.5D)
/*  580 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  581 */         .addNextBehavior(
/*  582 */           CECombatBehaviors.Behavior.builder()
/*  583 */           .custom(CombatCommon::isNotRiding)
/*  584 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  585 */           .withinDistance(0.0D, 9.0D)
/*  586 */           .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/*  587 */           .addNextBehavior(
/*  588 */             CECombatBehaviors.Behavior.builder()
/*  589 */             .custom(CombatCommon::isNotRiding)
/*  590 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  591 */             .withinDistance(0.0D, 4.0D)
/*  592 */             .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F)
/*  593 */             .addNextBehavior(
/*  594 */               CECombatBehaviors.Behavior.builder()
/*  595 */               .custom(CombatCommon::isNotRiding)
/*  596 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  597 */               .withinDistance(0.0D, 8.0D)
/*  598 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  599 */               .addNextBehavior(
/*  600 */                 CECombatBehaviors.Behavior.builder()
/*  601 */                 .custom(CombatCommon::isNotRiding)
/*  602 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  603 */                 .withinDistance(0.0D, 5.0D)
/*  604 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  610 */       .addFirstBehavior(
/*  611 */         CECombatBehaviors.Behavior.builder()
/*  612 */         .custom(CombatCommon::isNotRiding)
/*  613 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  614 */         .withinDistance(0.0D, 6.0D)
/*  615 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F)
/*  616 */         .addNextBehavior(
/*  617 */           CECombatBehaviors.Behavior.builder()
/*  618 */           .custom(CombatCommon::isNotRiding)
/*  619 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  620 */           .withinDistance(0.0D, 8.0D)
/*  621 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  622 */           .addNextBehavior(
/*  623 */             CECombatBehaviors.Behavior.builder()
/*  624 */             .custom(CombatCommon::isNotRiding)
/*  625 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  626 */             .withinDistance(0.0D, 4.5D)
/*  627 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/*  628 */             .addNextBehavior(
/*  629 */               CECombatBehaviors.Behavior.builder()
/*  630 */               .custom(CombatCommon::isNotRiding)
/*  631 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  632 */               .withinDistance(0.0D, 8.0D)
/*  633 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  634 */               .addNextBehavior(
/*  635 */                 CECombatBehaviors.Behavior.builder()
/*  636 */                 .custom(CombatCommon::isNotRiding)
/*  637 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  638 */                 .withinDistance(0.0D, 4.0D)
/*  639 */                 .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  645 */       .addFirstBehavior(
/*  646 */         CECombatBehaviors.Behavior.builder()
/*  647 */         .custom(CombatCommon::isNotRiding)
/*  648 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  649 */         .withinDistance(0.0D, 4.5D)
/*  650 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/*  651 */         .addNextBehavior(
/*  652 */           CECombatBehaviors.Behavior.builder()
/*  653 */           .custom(CombatCommon::isNotRiding)
/*  654 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  655 */           .withinDistance(0.0D, 9.0D)
/*  656 */           .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/*  657 */           .addNextBehavior(
/*  658 */             CECombatBehaviors.Behavior.builder()
/*  659 */             .custom(CombatCommon::isNotRiding)
/*  660 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  661 */             .withinDistance(0.0D, 4.0D)
/*  662 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  663 */             .addNextBehavior(
/*  664 */               CECombatBehaviors.Behavior.builder()
/*  665 */               .custom(CombatCommon::isNotRiding)
/*  666 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  667 */               .withinDistance(0.0D, 10.0D)
/*  668 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  669 */               .addNextBehavior(
/*  670 */                 CECombatBehaviors.Behavior.builder()
/*  671 */                 .custom(CombatCommon::isNotRiding)
/*  672 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  673 */                 .withinDistance(0.0D, 6.0D)
/*  674 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  680 */       .addFirstBehavior(
/*  681 */         CECombatBehaviors.Behavior.builder()
/*  682 */         .custom(CombatCommon::isNotRiding)
/*  683 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  684 */         .withinDistance(0.0D, 4.0D)
/*  685 */         .animationBehavior(WOMAnimations.KICK_AUTO_3, 0.0F)
/*  686 */         .addNextBehavior(
/*  687 */           CECombatBehaviors.Behavior.builder()
/*  688 */           .custom(CombatCommon::isNotRiding)
/*  689 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  690 */           .withinDistance(0.0D, 8.0D)
/*  691 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  692 */           .addNextBehavior(
/*  693 */             CECombatBehaviors.Behavior.builder()
/*  694 */             .custom(CombatCommon::isNotRiding)
/*  695 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  696 */             .withinDistance(0.0D, 4.5D)
/*  697 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  698 */             .addNextBehavior(
/*  699 */               CECombatBehaviors.Behavior.builder()
/*  700 */               .custom(CombatCommon::isNotRiding)
/*  701 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  702 */               .withinDistance(0.0D, 10.0D)
/*  703 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  704 */               .addNextBehavior(
/*  705 */                 CECombatBehaviors.Behavior.builder()
/*  706 */                 .custom(CombatCommon::isNotRiding)
/*  707 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  708 */                 .withinDistance(0.0D, 6.0D)
/*  709 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  715 */       .addFirstBehavior(
/*  716 */         CECombatBehaviors.Behavior.builder()
/*  717 */         .custom(CombatCommon::isNotRiding)
/*  718 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  719 */         .withinDistance(0.0D, 4.0D)
/*  720 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  721 */         .addNextBehavior(
/*  722 */           CECombatBehaviors.Behavior.builder()
/*  723 */           .custom(CombatCommon::isNotRiding)
/*  724 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  725 */           .withinDistance(0.0D, 10.0D)
/*  726 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  727 */           .addNextBehavior(
/*  728 */             CECombatBehaviors.Behavior.builder()
/*  729 */             .custom(CombatCommon::isNotRiding)
/*  730 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  731 */             .withinDistance(0.0D, 4.5D)
/*  732 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  733 */             .addNextBehavior(
/*  734 */               CECombatBehaviors.Behavior.builder()
/*  735 */               .custom(CombatCommon::isNotRiding)
/*  736 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  737 */               .withinDistance(0.0D, 8.0D)
/*  738 */               .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  739 */               .addNextBehavior(
/*  740 */                 CECombatBehaviors.Behavior.builder()
/*  741 */                 .custom(CombatCommon::isNotRiding)
/*  742 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  743 */                 .withinDistance(0.0D, 5.0D)
/*  744 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  750 */       .addFirstBehavior(
/*  751 */         CECombatBehaviors.Behavior.builder()
/*  752 */         .custom(CombatCommon::isNotRiding)
/*  753 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  754 */         .withinDistance(0.0D, 4.5D)
/*  755 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  756 */         .addNextBehavior(
/*  757 */           CECombatBehaviors.Behavior.builder()
/*  758 */           .custom(CombatCommon::isNotRiding)
/*  759 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  760 */           .withinDistance(0.0D, 8.0D)
/*  761 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  762 */           .addNextBehavior(
/*  763 */             CECombatBehaviors.Behavior.builder()
/*  764 */             .custom(CombatCommon::isNotRiding)
/*  765 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  766 */             .withinDistance(0.0D, 4.5D)
/*  767 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/*  768 */             .addNextBehavior(
/*  769 */               CECombatBehaviors.Behavior.builder()
/*  770 */               .custom(CombatCommon::isNotRiding)
/*  771 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  772 */               .withinDistance(0.0D, 10.0D)
/*  773 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  774 */               .addNextBehavior(
/*  775 */                 CECombatBehaviors.Behavior.builder()
/*  776 */                 .custom(CombatCommon::isNotRiding)
/*  777 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  778 */                 .withinDistance(0.0D, 4.0D)
/*  779 */                 .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  785 */       .addFirstBehavior(
/*  786 */         CECombatBehaviors.Behavior.builder()
/*  787 */         .custom(CombatCommon::isNotRiding)
/*  788 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  789 */         .withinDistance(0.0D, 4.0D)
/*  790 */         .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F)
/*  791 */         .addNextBehavior(
/*  792 */           CECombatBehaviors.Behavior.builder()
/*  793 */           .custom(CombatCommon::isNotRiding)
/*  794 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  795 */           .withinDistance(0.0D, 9.0D)
/*  796 */           .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/*  797 */           .addNextBehavior(
/*  798 */             CECombatBehaviors.Behavior.builder()
/*  799 */             .custom(CombatCommon::isNotRiding)
/*  800 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  801 */             .withinDistance(0.0D, 4.0D)
/*  802 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  803 */             .addNextBehavior(
/*  804 */               CECombatBehaviors.Behavior.builder()
/*  805 */               .custom(CombatCommon::isNotRiding)
/*  806 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  807 */               .withinDistance(0.0D, 10.0D)
/*  808 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  809 */               .addNextBehavior(
/*  810 */                 CECombatBehaviors.Behavior.builder()
/*  811 */                 .custom(CombatCommon::isNotRiding)
/*  812 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  813 */                 .withinDistance(0.0D, 5.0D)
/*  814 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  820 */       .addFirstBehavior(
/*  821 */         CECombatBehaviors.Behavior.builder()
/*  822 */         .custom(CombatCommon::isNotRiding)
/*  823 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  824 */         .withinDistance(0.0D, 4.0D)
/*  825 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/*  826 */         .addNextBehavior(
/*  827 */           CECombatBehaviors.Behavior.builder()
/*  828 */           .custom(CombatCommon::isNotRiding)
/*  829 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  830 */           .withinDistance(0.0D, 8.0D)
/*  831 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  832 */           .addNextBehavior(
/*  833 */             CECombatBehaviors.Behavior.builder()
/*  834 */             .custom(CombatCommon::isNotRiding)
/*  835 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  836 */             .withinDistance(0.0D, 6.0D)
/*  837 */             .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F)
/*  838 */             .addNextBehavior(
/*  839 */               CECombatBehaviors.Behavior.builder()
/*  840 */               .custom(CombatCommon::isNotRiding)
/*  841 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  842 */               .withinDistance(0.0D, 8.0D)
/*  843 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  844 */               .addNextBehavior(
/*  845 */                 CECombatBehaviors.Behavior.builder()
/*  846 */                 .custom(CombatCommon::isNotRiding)
/*  847 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  848 */                 .withinDistance(0.0D, 4.5D)
/*  849 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  855 */       .addFirstBehavior(
/*  856 */         CECombatBehaviors.Behavior.builder()
/*  857 */         .custom(CombatCommon::isNotRiding)
/*  858 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  859 */         .withinDistance(0.0D, 4.5D)
/*  860 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/*  861 */         .addNextBehavior(
/*  862 */           CECombatBehaviors.Behavior.builder()
/*  863 */           .custom(CombatCommon::isNotRiding)
/*  864 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  865 */           .withinDistance(0.0D, 8.0D)
/*  866 */           .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  867 */           .addNextBehavior(
/*  868 */             CECombatBehaviors.Behavior.builder()
/*  869 */             .custom(CombatCommon::isNotRiding)
/*  870 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  871 */             .withinDistance(0.0D, 4.0D)
/*  872 */             .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F)
/*  873 */             .addNextBehavior(
/*  874 */               CECombatBehaviors.Behavior.builder()
/*  875 */               .custom(CombatCommon::isNotRiding)
/*  876 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  877 */               .withinDistance(0.0D, 10.0D)
/*  878 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  879 */               .addNextBehavior(
/*  880 */                 CECombatBehaviors.Behavior.builder()
/*  881 */                 .custom(CombatCommon::isNotRiding)
/*  882 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  883 */                 .withinDistance(0.0D, 4.0D)
/*  884 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  890 */       .addFirstBehavior(
/*  891 */         CECombatBehaviors.Behavior.builder()
/*  892 */         .custom(CombatCommon::isNotRiding)
/*  893 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  894 */         .withinDistance(0.0D, 4.0D)
/*  895 */         .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F)
/*  896 */         .addNextBehavior(
/*  897 */           CECombatBehaviors.Behavior.builder()
/*  898 */           .custom(CombatCommon::isNotRiding)
/*  899 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  900 */           .withinDistance(0.0D, 8.0D)
/*  901 */           .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  902 */           .addNextBehavior(
/*  903 */             CECombatBehaviors.Behavior.builder()
/*  904 */             .custom(CombatCommon::isNotRiding)
/*  905 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  906 */             .withinDistance(0.0D, 5.0D)
/*  907 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F)
/*  908 */             .addNextBehavior(
/*  909 */               CECombatBehaviors.Behavior.builder()
/*  910 */               .custom(CombatCommon::isNotRiding)
/*  911 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  912 */               .withinDistance(0.0D, 10.0D)
/*  913 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  914 */               .addNextBehavior(
/*  915 */                 CECombatBehaviors.Behavior.builder()
/*  916 */                 .custom(CombatCommon::isNotRiding)
/*  917 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  918 */                 .withinDistance(0.0D, 6.0D)
/*  919 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  925 */       .addFirstBehavior(
/*  926 */         CECombatBehaviors.Behavior.builder()
/*  927 */         .custom(CombatCommon::isNotRiding)
/*  928 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  929 */         .withinDistance(0.0D, 4.5D)
/*  930 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  931 */         .addNextBehavior(
/*  932 */           CECombatBehaviors.Behavior.builder()
/*  933 */           .custom(CombatCommon::isNotRiding)
/*  934 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  935 */           .withinDistance(0.0D, 8.0D)
/*  936 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/*  937 */           .addNextBehavior(
/*  938 */             CECombatBehaviors.Behavior.builder()
/*  939 */             .custom(CombatCommon::isNotRiding)
/*  940 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  941 */             .withinDistance(0.0D, 4.0D)
/*  942 */             .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F)
/*  943 */             .addNextBehavior(
/*  944 */               CECombatBehaviors.Behavior.builder()
/*  945 */               .custom(CombatCommon::isNotRiding)
/*  946 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  947 */               .withinDistance(0.0D, 9.0D)
/*  948 */               .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/*  949 */               .addNextBehavior(
/*  950 */                 CECombatBehaviors.Behavior.builder()
/*  951 */                 .custom(CombatCommon::isNotRiding)
/*  952 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  953 */                 .withinDistance(0.0D, 4.5D)
/*  954 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  960 */       .addFirstBehavior(
/*  961 */         CECombatBehaviors.Behavior.builder()
/*  962 */         .custom(CombatCommon::isNotRiding)
/*  963 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  964 */         .withinDistance(0.0D, 6.0D)
/*  965 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F)
/*  966 */         .addNextBehavior(
/*  967 */           CECombatBehaviors.Behavior.builder()
/*  968 */           .custom(CombatCommon::isNotRiding)
/*  969 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  970 */           .withinDistance(0.0D, 10.0D)
/*  971 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*  972 */           .addNextBehavior(
/*  973 */             CECombatBehaviors.Behavior.builder()
/*  974 */             .custom(CombatCommon::isNotRiding)
/*  975 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  976 */             .withinDistance(0.0D, 4.5D)
/*  977 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/*  978 */             .addNextBehavior(
/*  979 */               CECombatBehaviors.Behavior.builder()
/*  980 */               .custom(CombatCommon::isNotRiding)
/*  981 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  982 */               .withinDistance(0.0D, 8.0D)
/*  983 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/*  984 */               .addNextBehavior(
/*  985 */                 CECombatBehaviors.Behavior.builder()
/*  986 */                 .custom(CombatCommon::isNotRiding)
/*  987 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  988 */                 .withinDistance(0.0D, 5.0D)
/*  989 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  995 */       .addFirstBehavior(
/*  996 */         CECombatBehaviors.Behavior.builder()
/*  997 */         .custom(CombatCommon::isNotRiding)
/*  998 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  999 */         .withinDistance(0.0D, 4.5D)
/* 1000 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/* 1001 */         .addNextBehavior(
/* 1002 */           CECombatBehaviors.Behavior.builder()
/* 1003 */           .custom(CombatCommon::isNotRiding)
/* 1004 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1005 */           .withinDistance(0.0D, 8.0D)
/* 1006 */           .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/* 1007 */           .addNextBehavior(
/* 1008 */             CECombatBehaviors.Behavior.builder()
/* 1009 */             .custom(CombatCommon::isNotRiding)
/* 1010 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1011 */             .withinDistance(0.0D, 5.0D)
/* 1012 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F)
/* 1013 */             .addNextBehavior(
/* 1014 */               CECombatBehaviors.Behavior.builder()
/* 1015 */               .custom(CombatCommon::isNotRiding)
/* 1016 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1017 */               .withinDistance(0.0D, 10.0D)
/* 1018 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/* 1019 */               .addNextBehavior(
/* 1020 */                 CECombatBehaviors.Behavior.builder()
/* 1021 */                 .custom(CombatCommon::isNotRiding)
/* 1022 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1023 */                 .withinDistance(0.0D, 6.0D)
/* 1024 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1030 */       .addFirstBehavior(
/* 1031 */         CECombatBehaviors.Behavior.builder()
/* 1032 */         .custom(CombatCommon::isNotRiding)
/* 1033 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1034 */         .withinDistance(0.0D, 4.0D)
/* 1035 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F)
/* 1036 */         .addNextBehavior(
/* 1037 */           CECombatBehaviors.Behavior.builder()
/* 1038 */           .custom(CombatCommon::isNotRiding)
/* 1039 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1040 */           .withinDistance(0.0D, 8.0D)
/* 1041 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/* 1042 */           .addNextBehavior(
/* 1043 */             CECombatBehaviors.Behavior.builder()
/* 1044 */             .custom(CombatCommon::isNotRiding)
/* 1045 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1046 */             .withinDistance(0.0D, 4.0D)
/* 1047 */             .animationBehavior(WOMAnimations.KICK_AUTO_3, 0.0F)
/* 1048 */             .addNextBehavior(
/* 1049 */               CECombatBehaviors.Behavior.builder()
/* 1050 */               .custom(CombatCommon::isNotRiding)
/* 1051 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1052 */               .withinDistance(0.0D, 10.0D)
/* 1053 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/* 1054 */               .addNextBehavior(
/* 1055 */                 CECombatBehaviors.Behavior.builder()
/* 1056 */                 .custom(CombatCommon::isNotRiding)
/* 1057 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1058 */                 .withinDistance(0.0D, 6.0D)
/* 1059 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1065 */       .addFirstBehavior(
/* 1066 */         CECombatBehaviors.Behavior.builder()
/* 1067 */         .custom(CombatCommon::isNotRiding)
/* 1068 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1069 */         .withinDistance(0.0D, 4.5D)
/* 1070 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F)
/* 1071 */         .addNextBehavior(
/* 1072 */           CECombatBehaviors.Behavior.builder()
/* 1073 */           .custom(CombatCommon::isNotRiding)
/* 1074 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1075 */           .withinDistance(0.0D, 8.0D)
/* 1076 */           .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/* 1077 */           .addNextBehavior(
/* 1078 */             CECombatBehaviors.Behavior.builder()
/* 1079 */             .custom(CombatCommon::isNotRiding)
/* 1080 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1081 */             .withinDistance(0.0D, 4.0D)
/* 1082 */             .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F)
/* 1083 */             .addNextBehavior(
/* 1084 */               CECombatBehaviors.Behavior.builder()
/* 1085 */               .custom(CombatCommon::isNotRiding)
/* 1086 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1087 */               .withinDistance(0.0D, 10.0D)
/* 1088 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/* 1089 */               .addNextBehavior(
/* 1090 */                 CECombatBehaviors.Behavior.builder()
/* 1091 */                 .custom(CombatCommon::isNotRiding)
/* 1092 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1093 */                 .withinDistance(0.0D, 4.0D)
/* 1094 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1100 */       .addFirstBehavior(
/* 1101 */         CECombatBehaviors.Behavior.builder()
/* 1102 */         .custom(CombatCommon::isNotRiding)
/* 1103 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1104 */         .withinDistance(0.0D, 4.0D)
/* 1105 */         .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F)
/* 1106 */         .addNextBehavior(
/* 1107 */           CECombatBehaviors.Behavior.builder()
/* 1108 */           .custom(CombatCommon::isNotRiding)
/* 1109 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1110 */           .withinDistance(0.0D, 8.0D)
/* 1111 */           .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/* 1112 */           .addNextBehavior(
/* 1113 */             CECombatBehaviors.Behavior.builder()
/* 1114 */             .custom(CombatCommon::isNotRiding)
/* 1115 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1116 */             .withinDistance(0.0D, 5.0D)
/* 1117 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F)
/* 1118 */             .addNextBehavior(
/* 1119 */               CECombatBehaviors.Behavior.builder()
/* 1120 */               .custom(CombatCommon::isNotRiding)
/* 1121 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1122 */               .withinDistance(0.0D, 10.0D)
/* 1123 */               .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/* 1124 */               .addNextBehavior(
/* 1125 */                 CECombatBehaviors.Behavior.builder()
/* 1126 */                 .custom(CombatCommon::isNotRiding)
/* 1127 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1128 */                 .withinDistance(0.0D, 6.0D)
/* 1129 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1135 */       .addFirstBehavior(
/* 1136 */         CECombatBehaviors.Behavior.builder()
/* 1137 */         .custom(CombatCommon::isNotRiding)
/* 1138 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1139 */         .withinDistance(0.0D, 4.5D)
/* 1140 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/* 1141 */         .addNextBehavior(
/* 1142 */           CECombatBehaviors.Behavior.builder()
/* 1143 */           .custom(CombatCommon::isNotRiding)
/* 1144 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1145 */           .withinDistance(0.0D, 8.0D)
/* 1146 */           .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F)
/* 1147 */           .addNextBehavior(
/* 1148 */             CECombatBehaviors.Behavior.builder()
/* 1149 */             .custom(CombatCommon::isNotRiding)
/* 1150 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1151 */             .withinDistance(0.0D, 4.0D)
/* 1152 */             .animationBehavior(WOMAnimations.KICK_AUTO_1, 0.0F)
/* 1153 */             .addNextBehavior(
/* 1154 */               CECombatBehaviors.Behavior.builder()
/* 1155 */               .custom(CombatCommon::isNotRiding)
/* 1156 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1157 */               .withinDistance(0.0D, 9.0D)
/* 1158 */               .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F)
/* 1159 */               .addNextBehavior(
/* 1160 */                 CECombatBehaviors.Behavior.builder()
/* 1161 */                 .custom(CombatCommon::isNotRiding)
/* 1162 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1163 */                 .withinDistance(0.0D, 4.5D)
/* 1164 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1170 */       .addFirstBehavior(
/* 1171 */         CECombatBehaviors.Behavior.builder()
/* 1172 */         .custom(CombatCommon::isNotRiding)
/* 1173 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1174 */         .withinDistance(0.0D, 6.0D)
/* 1175 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F)
/* 1176 */         .addNextBehavior(
/* 1177 */           CECombatBehaviors.Behavior.builder()
/* 1178 */           .custom(CombatCommon::isNotRiding)
/* 1179 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1180 */           .withinDistance(0.0D, 10.0D)
/* 1181 */           .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/* 1182 */           .addNextBehavior(
/* 1183 */             CECombatBehaviors.Behavior.builder()
/* 1184 */             .custom(CombatCommon::isNotRiding)
/* 1185 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1186 */             .withinDistance(0.0D, 4.5D)
/* 1187 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, 0.0F)
/* 1188 */             .addNextBehavior(
/* 1189 */               CECombatBehaviors.Behavior.builder()
/* 1190 */               .custom(CombatCommon::isNotRiding)
/* 1191 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1192 */               .withinDistance(0.0D, 8.0D)
/* 1193 */               .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)
/* 1194 */               .addNextBehavior(
/* 1195 */                 CECombatBehaviors.Behavior.builder()
/* 1196 */                 .custom(CombatCommon::isNotRiding)
/* 1197 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1198 */                 .withinDistance(0.0D, 5.0D)
/* 1199 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1206 */     .newBehaviorRoot(
/* 1207 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1208 */       .priority(1.0D)
/* 1209 */       .weight(30.0D)
/* 1210 */       .maxCooldown(100)
/* 1211 */       .addFirstBehavior(
/* 1212 */         CECombatBehaviors.Behavior.builder()
/* 1213 */         .custom(CombatCommon::isNotRiding)
/* 1214 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1215 */         .withinDistance(0.0D, 6.0D)
/* 1216 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, 0.0F))
/*      */       
/* 1218 */       .addFirstBehavior(
/* 1219 */         CECombatBehaviors.Behavior.builder()
/* 1220 */         .custom(CombatCommon::isNotRiding)
/* 1221 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1222 */         .withinDistance(0.0D, 4.0D)
/* 1223 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK, 0.0F))
/*      */       
/* 1225 */       .addFirstBehavior(
/* 1226 */         CECombatBehaviors.Behavior.builder()
/* 1227 */         .custom(CombatCommon::isNotRiding)
/* 1228 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1229 */         .withinDistance(0.0D, 4.0D)
/* 1230 */         .animationBehavior(WOMAnimations.KICK_AUTO_2, 0.0F)))
/*      */ 
/*      */     
/* 1233 */     .newBehaviorRoot(
/* 1234 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1235 */       .priority(1.0D)
/* 1236 */       .weight(10.0D)
/* 1237 */       .maxCooldown(600)
/* 1238 */       .addFirstBehavior(
/* 1239 */         CECombatBehaviors.Behavior.builder()
/* 1240 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1241 */         .custom(HerobrineCommon::canChangeToSecondForm)
/* 1242 */         .withinDistance(2.0D, 90.0D)
/* 1243 */         .animationBehavior(AVAnimations.AGONY_GUARD_HIT_1, 0.0F)
/* 1244 */         .addExBehavior(HerobrineCommon::changeToSecondForm)))
/*      */ 
/*      */     
/* 1247 */     .newBehaviorRoot(
/* 1248 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1249 */       .priority(1.0D)
/* 1250 */       .weight(25.0D)
/* 1251 */       .maxCooldown(600)
/* 1252 */       .addFirstBehavior(
/* 1253 */         CECombatBehaviors.Behavior.builder()
/* 1254 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1255 */         .custom(HerobrineCommon::canMountOrDismountDragon)
/* 1256 */         .withinDistance(2.0D, 90.0D)
/* 1257 */         .animationBehavior(AVAnimations.POSE_UP, 0.0F)
/* 1258 */         .addExBehavior(HerobrineCommon::mountOrDismountDragon)))
/*      */ 
/*      */     
/* 1261 */     .newBehaviorRoot(
/* 1262 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1263 */       .priority(1.0D)
/* 1264 */       .weight(25.0D)
/* 1265 */       .maxCooldown(300)
/* 1266 */       .addFirstBehavior(
/* 1267 */         CECombatBehaviors.Behavior.builder()
/* 1268 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1269 */         .withinDistance(2.0D, 90.0D)
/* 1270 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/* 1271 */         .custom(HerobrineCommon::canCastThunder)
/* 1272 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1273 */         .addExBehavior(HerobrineCommon::playSecondFormAnimation)))
/*      */ 
/*      */     
/* 1276 */     .newBehaviorRoot(
/* 1277 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1278 */       .priority(1.0D)
/* 1279 */       .weight(25.0D)
/* 1280 */       .maxCooldown(100)
/* 1281 */       .addFirstBehavior(
/* 1282 */         CECombatBehaviors.Behavior.builder()
/* 1283 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1284 */         .withinDistance(2.0D, 90.0D)
/* 1285 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/* 1286 */         .custom(HerobrineCommon::canCastMeteorite)
/* 1287 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/* 1288 */         .addExBehavior(HerobrineCommon::playSecondFormSpecialAnimation)))
/*      */ 
/*      */     
/* 1291 */     .newBehaviorRoot(
/* 1292 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1293 */       .priority(1.0D)
/* 1294 */       .weight(25.0D)
/* 1295 */       .maxCooldown(900)
/* 1296 */       .addFirstBehavior(
/* 1297 */         CECombatBehaviors.Behavior.builder()
/* 1298 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1299 */         .withinDistance(2.0D, 90.0D)
/* 1300 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/* 1301 */         .custom(HerobrineCommon::canRespawnCrystal)
/* 1302 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_INWARD, 0.0F)
/* 1303 */         .addExBehavior(HerobrineCommon::respawnCrystal)))
/*      */ 
/*      */     
/* 1306 */     .newBehaviorRoot(
/* 1307 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1308 */       .priority(1.0D)
/* 1309 */       .weight(15.0D)
/* 1310 */       .addFirstBehavior(
/* 1311 */         CECombatBehaviors.Behavior.builder()
/* 1312 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1313 */         .withinDistance(0.0D, 5.0D)
/* 1314 */         .custom(HerobrineCommon::canPerformGuarding)
/* 1315 */         .guard(40)))
/*      */ 
/*      */     
/* 1318 */     .newBehaviorRoot(
/* 1319 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1320 */       .priority(1.0D)
/* 1321 */       .weight(10.0D)
/* 1322 */       .addFirstBehavior(
/* 1323 */         CECombatBehaviors.Behavior.builder()
/* 1324 */         .custom(CombatCommon::isNotRiding)
/* 1325 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1326 */         .withinDistance(0.0D, 5.0D)
/* 1327 */         .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F))
/*      */       
/* 1329 */       .addFirstBehavior(
/* 1330 */         CECombatBehaviors.Behavior.builder()
/* 1331 */         .custom(CombatCommon::isNotRiding)
/* 1332 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1333 */         .withinDistance(0.0D, 5.0D)
/* 1334 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F))
/*      */       
/* 1336 */       .addFirstBehavior(
/* 1337 */         CECombatBehaviors.Behavior.builder()
/* 1338 */         .custom(CombatCommon::isNotRiding)
/* 1339 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1340 */         .withinDistance(0.0D, 5.0D)
/* 1341 */         .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F))
/*      */       
/* 1343 */       .addFirstBehavior(
/* 1344 */         CECombatBehaviors.Behavior.builder()
/* 1345 */         .custom(CombatCommon::isNotRiding)
/* 1346 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1347 */         .withinDistance(0.0D, 5.0D)
/* 1348 */         .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1351 */     .newBehaviorRoot(
/* 1352 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1353 */       .priority(1.0D)
/* 1354 */       .weight(20.0D)
/* 1355 */       .maxCooldown(160)
/* 1356 */       .addFirstBehavior(
/* 1357 */         CECombatBehaviors.Behavior.builder()
/* 1358 */         .custom(CombatCommon::isNotRiding)
/* 1359 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1360 */         .custom(HerobrineCommon::canJump)
/* 1361 */         .withinDistance(5.0D, 14.0D)
/* 1362 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1363 */         .addExBehavior(HerobrineCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineEnderSlayerScythe.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */