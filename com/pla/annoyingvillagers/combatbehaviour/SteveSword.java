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
/*      */ public class SteveSword
/*      */ {
/*   15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_SWORD = CECombatBehaviors.builder()
/*   16 */     .newBehaviorRoot(
/*   17 */       CECombatBehaviors.BehaviorRoot.builder()
/*   18 */       .priority(5.0D)
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
/*   31 */       .priority(4.0D)
/*   32 */       .weight(1000.0D)
/*   33 */       .maxCooldown(0)
/*   34 */       .addFirstBehavior(
/*   35 */         CECombatBehaviors.Behavior.builder()
/*   36 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   37 */         .custom(CombatCommon::canEscape)
/*   38 */         .withinDistance(0.0D, 8.0D)
/*   39 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   40 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*   42 */       .addFirstBehavior(
/*   43 */         CECombatBehaviors.Behavior.builder()
/*   44 */         .custom(CombatCommon::canEscape)
/*   45 */         .withinDistance(0.0D, 48.0D)
/*   46 */         .animationBehavior(AVAnimations.KNIFE_CHECK, 0.0F)))
/*      */ 
/*      */     
/*   49 */     .newBehaviorRoot(
/*   50 */       CECombatBehaviors.BehaviorRoot.builder()
/*   51 */       .priority(3.0D)
/*   52 */       .weight(100.0D)
/*   53 */       .maxCooldown(120)
/*   54 */       .addFirstBehavior(
/*   55 */         CECombatBehaviors.Behavior.builder()
/*   56 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   57 */         .custom(CombatCommon::canSwitchWeapon)
/*   58 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   59 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   61 */       .addFirstBehavior(
/*   62 */         CECombatBehaviors.Behavior.builder()
/*   63 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   64 */         .custom(CombatCommon::canSwitchWeapon)
/*   65 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*   66 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*   69 */     .newBehaviorRoot(
/*   70 */       CECombatBehaviors.BehaviorRoot.builder()
/*   71 */       .priority(2.0D)
/*   72 */       .weight(70.0D)
/*   73 */       .maxCooldown(0)
/*   74 */       .addFirstBehavior(
/*   75 */         CECombatBehaviors.Behavior.builder()
/*   76 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   77 */         .custom(CombatCommon::canPerformEating)
/*   78 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   79 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*   82 */     .newBehaviorRoot(
/*   83 */       CECombatBehaviors.BehaviorRoot.builder()
/*   84 */       .priority(2.0D)
/*   85 */       .weight(100.0D)
/*   86 */       .maxCooldown(120)
/*   87 */       .addFirstBehavior(
/*   88 */         CECombatBehaviors.Behavior.builder()
/*   89 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   90 */         .custom(CombatCommon::canSwitchWeapon)
/*   91 */         .withinDistance(2.0D, 14.0D)
/*   92 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   93 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   95 */       .addFirstBehavior(
/*   96 */         CECombatBehaviors.Behavior.builder()
/*   97 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   98 */         .custom(CombatCommon::canSwapToBow)
/*   99 */         .withinDistance(2.0D, 14.0D)
/*  100 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  101 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*  104 */     .newBehaviorRoot(
/*  105 */       CECombatBehaviors.BehaviorRoot.builder()
/*  106 */       .priority(2.0D)
/*  107 */       .weight(80.0D)
/*  108 */       .maxCooldown(120)
/*  109 */       .addFirstBehavior(
/*  110 */         CECombatBehaviors.Behavior.builder()
/*  111 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  112 */         .custom(CombatCommon::canThrowEnderPearl)
/*  113 */         .withinDistance(7.0D, 48.0D)
/*  114 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  115 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  118 */     .newBehaviorRoot(
/*  119 */       CECombatBehaviors.BehaviorRoot.builder()
/*  120 */       .priority(1.0D)
/*  121 */       .weight(40.0D)
/*  122 */       .maxCooldown(20)
/*  123 */       .addFirstBehavior(
/*  124 */         CECombatBehaviors.Behavior.builder()
/*  125 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  126 */         .withinDistance(0.0D, 3.0D)
/*  127 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  128 */         .addNextBehavior(
/*  129 */           CECombatBehaviors.Behavior.builder()
/*  130 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  131 */           .withinDistance(0.0D, 3.0D)
/*  132 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  133 */           .addNextBehavior(
/*  134 */             CECombatBehaviors.Behavior.builder()
/*  135 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  136 */             .withinDistance(0.0D, 3.0D)
/*  137 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  138 */             .addNextBehavior(
/*  139 */               CECombatBehaviors.Behavior.builder()
/*  140 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  141 */               .withinDistance(0.0D, 3.0D)
/*  142 */               .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F).addNextBehavior(
/*  143 */                 CECombatBehaviors.Behavior.builder()
/*  144 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  145 */                 .withinDistance(0.0D, 3.0D)
/*  146 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  152 */       .addFirstBehavior(
/*  153 */         CECombatBehaviors.Behavior.builder()
/*  154 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  155 */         .withinDistance(0.0D, 3.0D)
/*  156 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  157 */         .addNextBehavior(
/*  158 */           CECombatBehaviors.Behavior.builder()
/*  159 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  160 */           .withinDistance(0.0D, 3.0D)
/*  161 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  162 */           .addNextBehavior(
/*  163 */             CECombatBehaviors.Behavior.builder()
/*  164 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  165 */             .withinDistance(0.0D, 4.0D)
/*  166 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  167 */             .addNextBehavior(
/*  168 */               CECombatBehaviors.Behavior.builder()
/*  169 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  170 */               .withinDistance(0.0D, 4.0D)
/*  171 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  172 */               .addNextBehavior(
/*  173 */                 CECombatBehaviors.Behavior.builder()
/*  174 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  175 */                 .withinDistance(0.0D, 5.0D)
/*  176 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  183 */       .addFirstBehavior(
/*  184 */         CECombatBehaviors.Behavior.builder()
/*  185 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  186 */         .withinDistance(0.0D, 3.0D)
/*  187 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  188 */         .addNextBehavior(
/*  189 */           CECombatBehaviors.Behavior.builder()
/*  190 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  191 */           .withinDistance(0.0D, 3.0D)
/*  192 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  193 */           .addNextBehavior(
/*  194 */             CECombatBehaviors.Behavior.builder()
/*  195 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  196 */             .withinDistance(0.0D, 4.0D)
/*  197 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  198 */             .addNextBehavior(
/*  199 */               CECombatBehaviors.Behavior.builder()
/*  200 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  201 */               .withinDistance(0.0D, 4.0D)
/*  202 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  203 */               .addNextBehavior(
/*  204 */                 CECombatBehaviors.Behavior.builder()
/*  205 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  206 */                 .withinDistance(0.0D, 5.0D)
/*  207 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  208 */                 .addNextBehavior(
/*  209 */                   CECombatBehaviors.Behavior.builder()
/*  210 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  211 */                   .withinDistance(0.0D, 5.0D)
/*  212 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  220 */       .addFirstBehavior(
/*  221 */         CECombatBehaviors.Behavior.builder()
/*  222 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  223 */         .withinDistance(0.0D, 3.0D)
/*  224 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  225 */         .addNextBehavior(
/*  226 */           CECombatBehaviors.Behavior.builder()
/*  227 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  228 */           .withinDistance(0.0D, 3.0D)
/*  229 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  230 */           .addNextBehavior(
/*  231 */             CECombatBehaviors.Behavior.builder()
/*  232 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  233 */             .withinDistance(0.0D, 4.0D)
/*  234 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  235 */             .addNextBehavior(
/*  236 */               CECombatBehaviors.Behavior.builder()
/*  237 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  238 */               .withinDistance(0.0D, 4.0D)
/*  239 */               .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  240 */               .addNextBehavior(
/*  241 */                 CECombatBehaviors.Behavior.builder()
/*  242 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  243 */                 .withinDistance(0.0D, 5.0D)
/*  244 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  245 */                 .addNextBehavior(
/*  246 */                   CECombatBehaviors.Behavior.builder()
/*  247 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  248 */                   .withinDistance(0.0D, 5.0D)
/*  249 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  250 */                   .addNextBehavior(
/*  251 */                     CECombatBehaviors.Behavior.builder()
/*  252 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  253 */                     .withinDistance(0.0D, 5.0D)
/*  254 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  263 */       .addFirstBehavior(
/*  264 */         CECombatBehaviors.Behavior.builder()
/*  265 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  266 */         .withinDistance(0.0D, 3.0D)
/*  267 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/*  268 */         .addNextBehavior(
/*  269 */           CECombatBehaviors.Behavior.builder()
/*  270 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  271 */           .withinDistance(0.0D, 3.0D)
/*  272 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  273 */           .addNextBehavior(
/*  274 */             CECombatBehaviors.Behavior.builder()
/*  275 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  276 */             .withinDistance(0.0D, 4.0D)
/*  277 */             .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  278 */             .addNextBehavior(
/*  279 */               CECombatBehaviors.Behavior.builder()
/*  280 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  281 */               .withinDistance(0.0D, 4.0D)
/*  282 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  283 */               .addNextBehavior(
/*  284 */                 CECombatBehaviors.Behavior.builder()
/*  285 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  286 */                 .withinDistance(0.0D, 5.0D)
/*  287 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  294 */       .addFirstBehavior(
/*  295 */         CECombatBehaviors.Behavior.builder()
/*  296 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  297 */         .withinDistance(0.0D, 3.0D)
/*  298 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/*  299 */         .addNextBehavior(
/*  300 */           CECombatBehaviors.Behavior.builder()
/*  301 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  302 */           .withinDistance(0.0D, 3.0D)
/*  303 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  304 */           .addNextBehavior(
/*  305 */             CECombatBehaviors.Behavior.builder()
/*  306 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  307 */             .withinDistance(0.0D, 4.0D)
/*  308 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/*  309 */             .addNextBehavior(
/*  310 */               CECombatBehaviors.Behavior.builder()
/*  311 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  312 */               .withinDistance(0.0D, 4.0D)
/*  313 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  314 */               .addNextBehavior(
/*  315 */                 CECombatBehaviors.Behavior.builder()
/*  316 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  317 */                 .withinDistance(0.0D, 5.0D)
/*  318 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  319 */                 .addNextBehavior(
/*  320 */                   CECombatBehaviors.Behavior.builder()
/*  321 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  322 */                   .withinDistance(0.0D, 5.0D)
/*  323 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  331 */       .addFirstBehavior(
/*  332 */         CECombatBehaviors.Behavior.builder()
/*  333 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  334 */         .withinDistance(0.0D, 3.0D)
/*  335 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  336 */         .addNextBehavior(
/*  337 */           CECombatBehaviors.Behavior.builder()
/*  338 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  339 */           .withinDistance(0.0D, 3.0D)
/*  340 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  341 */           .addNextBehavior(
/*  342 */             CECombatBehaviors.Behavior.builder()
/*  343 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  344 */             .withinDistance(0.0D, 4.0D)
/*  345 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  346 */             .addNextBehavior(
/*  347 */               CECombatBehaviors.Behavior.builder()
/*  348 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  349 */               .withinDistance(0.0D, 4.0D)
/*  350 */               .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  351 */               .addNextBehavior(
/*  352 */                 CECombatBehaviors.Behavior.builder()
/*  353 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  354 */                 .withinDistance(0.0D, 5.0D)
/*  355 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/*  356 */                 .addNextBehavior(
/*  357 */                   CECombatBehaviors.Behavior.builder()
/*  358 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  359 */                   .withinDistance(0.0D, 5.0D)
/*  360 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  361 */                   .addNextBehavior(
/*  362 */                     CECombatBehaviors.Behavior.builder()
/*  363 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  364 */                     .withinDistance(0.0D, 5.0D)
/*  365 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  374 */       .addFirstBehavior(
/*  375 */         CECombatBehaviors.Behavior.builder()
/*  376 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  377 */         .withinDistance(0.0D, 3.0D)
/*  378 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  379 */         .addNextBehavior(
/*  380 */           CECombatBehaviors.Behavior.builder()
/*  381 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  382 */           .withinDistance(0.0D, 3.0D)
/*  383 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  384 */           .addNextBehavior(
/*  385 */             CECombatBehaviors.Behavior.builder()
/*  386 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  387 */             .withinDistance(0.0D, 4.0D)
/*  388 */             .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  389 */             .addNextBehavior(
/*  390 */               CECombatBehaviors.Behavior.builder()
/*  391 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  392 */               .withinDistance(0.0D, 4.0D)
/*  393 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  394 */               .addNextBehavior(
/*  395 */                 CECombatBehaviors.Behavior.builder()
/*  396 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  397 */                 .withinDistance(0.0D, 5.0D)
/*  398 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  405 */       .addFirstBehavior(
/*  406 */         CECombatBehaviors.Behavior.builder()
/*  407 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  408 */         .withinDistance(0.0D, 3.0D)
/*  409 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  410 */         .addNextBehavior(
/*  411 */           CECombatBehaviors.Behavior.builder()
/*  412 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  413 */           .withinDistance(0.0D, 3.0D)
/*  414 */           .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  415 */           .addNextBehavior(
/*  416 */             CECombatBehaviors.Behavior.builder()
/*  417 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  418 */             .withinDistance(0.0D, 4.0D)
/*  419 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  420 */             .addNextBehavior(
/*  421 */               CECombatBehaviors.Behavior.builder()
/*  422 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  423 */               .withinDistance(0.0D, 4.0D)
/*  424 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  425 */               .addNextBehavior(
/*  426 */                 CECombatBehaviors.Behavior.builder()
/*  427 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  428 */                 .withinDistance(0.0D, 5.0D)
/*  429 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  430 */                 .addNextBehavior(
/*  431 */                   CECombatBehaviors.Behavior.builder()
/*  432 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  433 */                   .withinDistance(0.0D, 5.0D)
/*  434 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  442 */       .addFirstBehavior(
/*  443 */         CECombatBehaviors.Behavior.builder()
/*  444 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  445 */         .withinDistance(0.0D, 3.0D)
/*  446 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  447 */         .addNextBehavior(
/*  448 */           CECombatBehaviors.Behavior.builder()
/*  449 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  450 */           .withinDistance(0.0D, 3.0D)
/*  451 */           .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  452 */           .addNextBehavior(
/*  453 */             CECombatBehaviors.Behavior.builder()
/*  454 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  455 */             .withinDistance(0.0D, 4.0D)
/*  456 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  457 */             .addNextBehavior(
/*  458 */               CECombatBehaviors.Behavior.builder()
/*  459 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  460 */               .withinDistance(0.0D, 4.0D)
/*  461 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  462 */               .addNextBehavior(
/*  463 */                 CECombatBehaviors.Behavior.builder()
/*  464 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  465 */                 .withinDistance(0.0D, 5.0D)
/*  466 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  467 */                 .addNextBehavior(
/*  468 */                   CECombatBehaviors.Behavior.builder()
/*  469 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  470 */                   .withinDistance(0.0D, 5.0D)
/*  471 */                   .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  472 */                   .addNextBehavior(
/*  473 */                     CECombatBehaviors.Behavior.builder()
/*  474 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  475 */                     .withinDistance(0.0D, 5.0D)
/*  476 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  485 */       .addFirstBehavior(
/*  486 */         CECombatBehaviors.Behavior.builder()
/*  487 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  488 */         .withinDistance(0.0D, 3.0D)
/*  489 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  490 */         .addNextBehavior(
/*  491 */           CECombatBehaviors.Behavior.builder()
/*  492 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  493 */           .withinDistance(0.0D, 3.0D)
/*  494 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  495 */           .addNextBehavior(
/*  496 */             CECombatBehaviors.Behavior.builder()
/*  497 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  498 */             .withinDistance(0.0D, 4.0D)
/*  499 */             .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/*  500 */             .addNextBehavior(
/*  501 */               CECombatBehaviors.Behavior.builder()
/*  502 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  503 */               .withinDistance(0.0D, 4.0D)
/*  504 */               .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  505 */               .addNextBehavior(
/*  506 */                 CECombatBehaviors.Behavior.builder()
/*  507 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  508 */                 .withinDistance(0.0D, 5.0D)
/*  509 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  510 */                 .addNextBehavior(
/*  511 */                   CECombatBehaviors.Behavior.builder()
/*  512 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  513 */                   .withinDistance(0.0D, 5.0D)
/*  514 */                   .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/*  515 */                   .addNextBehavior(
/*  516 */                     CECombatBehaviors.Behavior.builder()
/*  517 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  518 */                     .withinDistance(0.0D, 5.0D)
/*  519 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  528 */       .addFirstBehavior(
/*  529 */         CECombatBehaviors.Behavior.builder()
/*  530 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  531 */         .withinDistance(0.0D, 3.0D)
/*  532 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/*  533 */         .addNextBehavior(
/*  534 */           CECombatBehaviors.Behavior.builder()
/*  535 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  536 */           .withinDistance(0.0D, 3.0D)
/*  537 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  538 */           .addNextBehavior(
/*  539 */             CECombatBehaviors.Behavior.builder()
/*  540 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  541 */             .withinDistance(0.0D, 4.0D)
/*  542 */             .animationBehavior(Animations.SWORD_DASH, 0.0F)
/*  543 */             .addNextBehavior(
/*  544 */               CECombatBehaviors.Behavior.builder()
/*  545 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  546 */               .withinDistance(0.0D, 4.0D)
/*  547 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  548 */               .addNextBehavior(
/*  549 */                 CECombatBehaviors.Behavior.builder()
/*  550 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  551 */                 .withinDistance(0.0D, 5.0D)
/*  552 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  559 */       .addFirstBehavior(
/*  560 */         CECombatBehaviors.Behavior.builder()
/*  561 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  562 */         .withinDistance(0.0D, 3.0D)
/*  563 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  564 */         .addNextBehavior(
/*  565 */           CECombatBehaviors.Behavior.builder()
/*  566 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  567 */           .withinDistance(0.0D, 3.0D)
/*  568 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  569 */           .addNextBehavior(
/*  570 */             CECombatBehaviors.Behavior.builder()
/*  571 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  572 */             .withinDistance(0.0D, 4.0D)
/*  573 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  574 */             .addNextBehavior(
/*  575 */               CECombatBehaviors.Behavior.builder()
/*  576 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  577 */               .withinDistance(0.0D, 4.0D)
/*  578 */               .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  579 */               .addNextBehavior(
/*  580 */                 CECombatBehaviors.Behavior.builder()
/*  581 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  582 */                 .withinDistance(0.0D, 5.0D)
/*  583 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  584 */                 .addNextBehavior(
/*  585 */                   CECombatBehaviors.Behavior.builder()
/*  586 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  587 */                   .withinDistance(0.0D, 5.0D)
/*  588 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  596 */       .addFirstBehavior(
/*  597 */         CECombatBehaviors.Behavior.builder()
/*  598 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  599 */         .withinDistance(0.0D, 3.0D)
/*  600 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  601 */         .addNextBehavior(
/*  602 */           CECombatBehaviors.Behavior.builder()
/*  603 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  604 */           .withinDistance(0.0D, 3.0D)
/*  605 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  606 */           .addNextBehavior(
/*  607 */             CECombatBehaviors.Behavior.builder()
/*  608 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  609 */             .withinDistance(0.0D, 4.0D)
/*  610 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  611 */             .addNextBehavior(
/*  612 */               CECombatBehaviors.Behavior.builder()
/*  613 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  614 */               .withinDistance(0.0D, 4.0D)
/*  615 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  616 */               .addNextBehavior(
/*  617 */                 CECombatBehaviors.Behavior.builder()
/*  618 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  619 */                 .withinDistance(0.0D, 5.0D)
/*  620 */                 .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  621 */                 .addNextBehavior(
/*  622 */                   CECombatBehaviors.Behavior.builder()
/*  623 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  624 */                   .withinDistance(0.0D, 5.0D)
/*  625 */                   .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/*  626 */                   .addNextBehavior(
/*  627 */                     CECombatBehaviors.Behavior.builder()
/*  628 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  629 */                     .withinDistance(0.0D, 5.0D)
/*  630 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  639 */       .addFirstBehavior(
/*  640 */         CECombatBehaviors.Behavior.builder()
/*  641 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  642 */         .withinDistance(0.0D, 3.0D)
/*  643 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  644 */         .addNextBehavior(
/*  645 */           CECombatBehaviors.Behavior.builder()
/*  646 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  647 */           .withinDistance(0.0D, 3.0D)
/*  648 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  649 */           .addNextBehavior(
/*  650 */             CECombatBehaviors.Behavior.builder()
/*  651 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  652 */             .withinDistance(0.0D, 4.0D)
/*  653 */             .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  654 */             .addNextBehavior(
/*  655 */               CECombatBehaviors.Behavior.builder()
/*  656 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  657 */               .withinDistance(0.0D, 4.0D)
/*  658 */               .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F)
/*  659 */               .addNextBehavior(
/*  660 */                 CECombatBehaviors.Behavior.builder()
/*  661 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  662 */                 .withinDistance(0.0D, 5.0D)
/*  663 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  664 */                 .addNextBehavior(
/*  665 */                   CECombatBehaviors.Behavior.builder()
/*  666 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  667 */                   .withinDistance(0.0D, 5.0D)
/*  668 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  676 */       .addFirstBehavior(
/*  677 */         CECombatBehaviors.Behavior.builder()
/*  678 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  679 */         .withinDistance(0.0D, 3.0D)
/*  680 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_1, 0.0F)
/*  681 */         .addNextBehavior(
/*  682 */           CECombatBehaviors.Behavior.builder()
/*  683 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  684 */           .withinDistance(0.0D, 3.0D)
/*  685 */           .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)
/*  686 */           .addNextBehavior(
/*  687 */             CECombatBehaviors.Behavior.builder()
/*  688 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  689 */             .withinDistance(0.0D, 4.0D)
/*  690 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  691 */             .addNextBehavior(
/*  692 */               CECombatBehaviors.Behavior.builder()
/*  693 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  694 */               .withinDistance(0.0D, 4.0D)
/*  695 */               .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  696 */               .addNextBehavior(
/*  697 */                 CECombatBehaviors.Behavior.builder()
/*  698 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  699 */                 .withinDistance(0.0D, 5.0D)
/*  700 */                 .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/*  701 */                 .addNextBehavior(
/*  702 */                   CECombatBehaviors.Behavior.builder()
/*  703 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  704 */                   .withinDistance(0.0D, 5.0D)
/*  705 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  714 */     .newBehaviorRoot(
/*  715 */       CECombatBehaviors.BehaviorRoot.builder()
/*  716 */       .priority(1.0D)
/*  717 */       .weight(20.0D)
/*  718 */       .maxCooldown(100)
/*  719 */       .addFirstBehavior(
/*  720 */         CECombatBehaviors.Behavior.builder()
/*  721 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  722 */         .withinDistance(0.0D, 3.0D)
/*  723 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  724 */         .addNextBehavior(
/*  725 */           CECombatBehaviors.Behavior.builder()
/*  726 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  727 */           .withinDistance(0.0D, 3.0D)
/*  728 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  729 */           .addNextBehavior(
/*  730 */             CECombatBehaviors.Behavior.builder()
/*  731 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  732 */             .withinDistance(0.0D, 3.0D)
/*  733 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  738 */     .newBehaviorRoot(
/*  739 */       CECombatBehaviors.BehaviorRoot.builder()
/*  740 */       .priority(1.0D)
/*  741 */       .weight(10.0D)
/*  742 */       .maxCooldown(100)
/*  743 */       .addFirstBehavior(
/*  744 */         CECombatBehaviors.Behavior.builder()
/*  745 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  746 */         .withinDistance(0.0D, 3.0D)
/*  747 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*      */       
/*  749 */       .addFirstBehavior(
/*  750 */         CECombatBehaviors.Behavior.builder()
/*  751 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  752 */         .withinDistance(0.0D, 3.0D)
/*  753 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*      */       
/*  755 */       .addFirstBehavior(
/*  756 */         CECombatBehaviors.Behavior.builder()
/*  757 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  758 */         .withinDistance(0.0D, 3.0D)
/*  759 */         .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))
/*      */ 
/*      */     
/*  762 */     .newBehaviorRoot(
/*  763 */       CECombatBehaviors.BehaviorRoot.builder()
/*  764 */       .priority(1.0D)
/*  765 */       .weight(10.0D)
/*  766 */       .maxCooldown(40)
/*  767 */       .addFirstBehavior(
/*  768 */         CECombatBehaviors.Behavior.builder()
/*  769 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  770 */         .withinDistance(0.0D, 3.0D)
/*  771 */         .custom(CombatCommon::canThrowEnderPearl)
/*  772 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  773 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  774 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  777 */     .newBehaviorRoot(
/*  778 */       CECombatBehaviors.BehaviorRoot.builder()
/*  779 */       .priority(1.0D)
/*  780 */       .weight(2.0D)
/*  781 */       .maxCooldown(100)
/*  782 */       .addFirstBehavior(
/*  783 */         CECombatBehaviors.Behavior.builder()
/*  784 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  785 */         .withinDistance(0.0D, 3.0D)
/*  786 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  788 */       .addFirstBehavior(
/*  789 */         CECombatBehaviors.Behavior.builder()
/*  790 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  791 */         .withinDistance(0.0D, 3.0D)
/*  792 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  794 */       .addFirstBehavior(
/*  795 */         CECombatBehaviors.Behavior.builder()
/*  796 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  797 */         .withinDistance(0.0D, 3.0D)
/*  798 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  800 */       .addFirstBehavior(
/*  801 */         CECombatBehaviors.Behavior.builder()
/*  802 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  803 */         .withinDistance(0.0D, 3.0D)
/*  804 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  806 */       .addFirstBehavior(
/*  807 */         CECombatBehaviors.Behavior.builder()
/*  808 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  809 */         .withinDistance(0.0D, 3.0D)
/*  810 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  812 */       .addFirstBehavior(
/*  813 */         CECombatBehaviors.Behavior.builder()
/*  814 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  815 */         .withinDistance(0.0D, 3.0D)
/*  816 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  818 */       .addFirstBehavior(
/*  819 */         CECombatBehaviors.Behavior.builder()
/*  820 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  821 */         .withinDistance(0.0D, 3.0D)
/*  822 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  825 */     .newBehaviorRoot(
/*  826 */       CECombatBehaviors.BehaviorRoot.builder()
/*  827 */       .priority(1.0D)
/*  828 */       .weight(10.0D)
/*  829 */       .addFirstBehavior(
/*  830 */         CECombatBehaviors.Behavior.builder()
/*  831 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  832 */         .withinDistance(0.0D, 3.0D)
/*  833 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/*  835 */       .addFirstBehavior(
/*  836 */         CECombatBehaviors.Behavior.builder()
/*  837 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  838 */         .withinDistance(0.0D, 3.0D)
/*  839 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/*  842 */     .newBehaviorRoot(
/*  843 */       CECombatBehaviors.BehaviorRoot.builder()
/*  844 */       .priority(1.0D)
/*  845 */       .weight(40.0D)
/*  846 */       .maxCooldown(160)
/*  847 */       .addFirstBehavior(
/*  848 */         CECombatBehaviors.Behavior.builder()
/*  849 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  850 */         .custom(CombatCommon::canJump)
/*  851 */         .withinDistance(5.0D, 14.0D)
/*  852 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/*  853 */         .addExBehavior(CombatCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/*  857 */   public static final CECombatBehaviors.Builder<MobPatch<?>> AV_DUAL_SWORD = CECombatBehaviors.builder()
/*  858 */     .newBehaviorRoot(
/*  859 */       CECombatBehaviors.BehaviorRoot.builder()
/*  860 */       .priority(5.0D)
/*  861 */       .weight(1000.0D)
/*  862 */       .maxCooldown(0)
/*  863 */       .addFirstBehavior(
/*  864 */         CECombatBehaviors.Behavior.builder()
/*  865 */         .custom(CombatCommon::canExecute)
/*  866 */         .withinDistance(0.0D, 5.0D)
/*  867 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  868 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  871 */     .newBehaviorRoot(
/*  872 */       CECombatBehaviors.BehaviorRoot.builder()
/*  873 */       .priority(4.0D)
/*  874 */       .weight(1000.0D)
/*  875 */       .maxCooldown(0)
/*  876 */       .addFirstBehavior(
/*  877 */         CECombatBehaviors.Behavior.builder()
/*  878 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  879 */         .custom(CombatCommon::canEscape)
/*  880 */         .withinDistance(0.0D, 8.0D)
/*  881 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  882 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  884 */       .addFirstBehavior(
/*  885 */         CECombatBehaviors.Behavior.builder()
/*  886 */         .custom(CombatCommon::canEscape)
/*  887 */         .withinDistance(0.0D, 48.0D)
/*  888 */         .guard(40)))
/*      */ 
/*      */     
/*  891 */     .newBehaviorRoot(
/*  892 */       CECombatBehaviors.BehaviorRoot.builder()
/*  893 */       .priority(3.0D)
/*  894 */       .weight(100.0D)
/*  895 */       .maxCooldown(120)
/*  896 */       .addFirstBehavior(
/*  897 */         CECombatBehaviors.Behavior.builder()
/*  898 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  899 */         .custom(CombatCommon::canSwitchWeapon)
/*  900 */         .withinDistance(1.0D, 14.0D)
/*  901 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  902 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  904 */       .addFirstBehavior(
/*  905 */         CECombatBehaviors.Behavior.builder()
/*  906 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  907 */         .custom(CombatCommon::canSwapToBow)
/*  908 */         .withinDistance(1.0D, 14.0D)
/*  909 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  910 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*  913 */     .newBehaviorRoot(
/*  914 */       CECombatBehaviors.BehaviorRoot.builder()
/*  915 */       .priority(2.0D)
/*  916 */       .weight(70.0D)
/*  917 */       .maxCooldown(0)
/*  918 */       .addFirstBehavior(
/*  919 */         CECombatBehaviors.Behavior.builder()
/*  920 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  921 */         .custom(CombatCommon::canPerformEating)
/*  922 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  923 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  926 */     .newBehaviorRoot(
/*  927 */       CECombatBehaviors.BehaviorRoot.builder()
/*  928 */       .priority(2.0D)
/*  929 */       .weight(100.0D)
/*  930 */       .maxCooldown(120)
/*  931 */       .addFirstBehavior(
/*  932 */         CECombatBehaviors.Behavior.builder()
/*  933 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  934 */         .custom(CombatCommon::canSwapToBow)
/*  935 */         .withinDistance(7.0D, 14.0D)
/*  936 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  937 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  939 */       .addFirstBehavior(
/*  940 */         CECombatBehaviors.Behavior.builder()
/*  941 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  942 */         .custom(CombatCommon::canSwapToBow)
/*  943 */         .withinDistance(7.0D, 14.0D)
/*  944 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
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
/*  981 */             .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/*  982 */             .addNextBehavior(
/*  983 */               CECombatBehaviors.Behavior.builder()
/*  984 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  985 */               .withinDistance(0.0D, 3.0D)
/*  986 */               .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F).addNextBehavior(
/*  987 */                 CECombatBehaviors.Behavior.builder()
/*  988 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  989 */                 .withinDistance(0.0D, 3.0D)
/*  990 */                 .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/*  991 */                 .addNextBehavior(
/*  992 */                   CECombatBehaviors.Behavior.builder()
/*  993 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  994 */                   .withinDistance(0.0D, 3.0D)
/*  995 */                   .animationBehavior(AVAnimations.DUAL_SWORD3, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1002 */       .addFirstBehavior(
/* 1003 */         CECombatBehaviors.Behavior.builder()
/* 1004 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1005 */         .withinDistance(0.0D, 3.0D)
/* 1006 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1007 */         .addNextBehavior(
/* 1008 */           CECombatBehaviors.Behavior.builder()
/* 1009 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1010 */           .withinDistance(0.0D, 3.0D)
/* 1011 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1012 */           .addNextBehavior(
/* 1013 */             CECombatBehaviors.Behavior.builder()
/* 1014 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1015 */             .withinDistance(0.0D, 4.0D)
/* 1016 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1017 */             .addNextBehavior(
/* 1018 */               CECombatBehaviors.Behavior.builder()
/* 1019 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1020 */               .withinDistance(0.0D, 4.0D)
/* 1021 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1022 */               .addNextBehavior(
/* 1023 */                 CECombatBehaviors.Behavior.builder()
/* 1024 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1025 */                 .withinDistance(0.0D, 5.0D)
/* 1026 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1033 */       .addFirstBehavior(
/* 1034 */         CECombatBehaviors.Behavior.builder()
/* 1035 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1036 */         .withinDistance(0.0D, 3.0D)
/* 1037 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1038 */         .addNextBehavior(
/* 1039 */           CECombatBehaviors.Behavior.builder()
/* 1040 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1041 */           .withinDistance(0.0D, 3.0D)
/* 1042 */           .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1043 */           .addNextBehavior(
/* 1044 */             CECombatBehaviors.Behavior.builder()
/* 1045 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1046 */             .withinDistance(0.0D, 4.0D)
/* 1047 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1048 */             .addNextBehavior(
/* 1049 */               CECombatBehaviors.Behavior.builder()
/* 1050 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1051 */               .withinDistance(0.0D, 4.0D)
/* 1052 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1053 */               .addNextBehavior(
/* 1054 */                 CECombatBehaviors.Behavior.builder()
/* 1055 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1056 */                 .withinDistance(0.0D, 5.0D)
/* 1057 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1058 */                 .addNextBehavior(
/* 1059 */                   CECombatBehaviors.Behavior.builder()
/* 1060 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1061 */                   .withinDistance(0.0D, 5.0D)
/* 1062 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1070 */       .addFirstBehavior(
/* 1071 */         CECombatBehaviors.Behavior.builder()
/* 1072 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1073 */         .withinDistance(0.0D, 3.0D)
/* 1074 */         .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1075 */         .addNextBehavior(
/* 1076 */           CECombatBehaviors.Behavior.builder()
/* 1077 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1078 */           .withinDistance(0.0D, 3.0D)
/* 1079 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1080 */           .addNextBehavior(
/* 1081 */             CECombatBehaviors.Behavior.builder()
/* 1082 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1083 */             .withinDistance(0.0D, 4.0D)
/* 1084 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1085 */             .addNextBehavior(
/* 1086 */               CECombatBehaviors.Behavior.builder()
/* 1087 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1088 */               .withinDistance(0.0D, 4.0D)
/* 1089 */               .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1090 */               .addNextBehavior(
/* 1091 */                 CECombatBehaviors.Behavior.builder()
/* 1092 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1093 */                 .withinDistance(0.0D, 5.0D)
/* 1094 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1095 */                 .addNextBehavior(
/* 1096 */                   CECombatBehaviors.Behavior.builder()
/* 1097 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1098 */                   .withinDistance(0.0D, 5.0D)
/* 1099 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1107 */       .addFirstBehavior(
/* 1108 */         CECombatBehaviors.Behavior.builder()
/* 1109 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1110 */         .withinDistance(0.0D, 3.0D)
/* 1111 */         .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1112 */         .addNextBehavior(
/* 1113 */           CECombatBehaviors.Behavior.builder()
/* 1114 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1115 */           .withinDistance(0.0D, 3.0D)
/* 1116 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1117 */           .addNextBehavior(
/* 1118 */             CECombatBehaviors.Behavior.builder()
/* 1119 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1120 */             .withinDistance(0.0D, 4.0D)
/* 1121 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1122 */             .addNextBehavior(
/* 1123 */               CECombatBehaviors.Behavior.builder()
/* 1124 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1125 */               .withinDistance(0.0D, 4.0D)
/* 1126 */               .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 1127 */               .addNextBehavior(
/* 1128 */                 CECombatBehaviors.Behavior.builder()
/* 1129 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1130 */                 .withinDistance(0.0D, 5.0D)
/* 1131 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1132 */                 .addNextBehavior(
/* 1133 */                   CECombatBehaviors.Behavior.builder()
/* 1134 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1135 */                   .withinDistance(0.0D, 5.0D)
/* 1136 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1144 */       .addFirstBehavior(
/* 1145 */         CECombatBehaviors.Behavior.builder()
/* 1146 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1147 */         .withinDistance(0.0D, 3.0D)
/* 1148 */         .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 1149 */         .addNextBehavior(
/* 1150 */           CECombatBehaviors.Behavior.builder()
/* 1151 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1152 */           .withinDistance(0.0D, 3.0D)
/* 1153 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1154 */           .addNextBehavior(
/* 1155 */             CECombatBehaviors.Behavior.builder()
/* 1156 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1157 */             .withinDistance(0.0D, 4.0D)
/* 1158 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1159 */             .addNextBehavior(
/* 1160 */               CECombatBehaviors.Behavior.builder()
/* 1161 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1162 */               .withinDistance(0.0D, 4.0D)
/* 1163 */               .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 1164 */               .addNextBehavior(
/* 1165 */                 CECombatBehaviors.Behavior.builder()
/* 1166 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1167 */                 .withinDistance(0.0D, 5.0D)
/* 1168 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1169 */                 .addNextBehavior(
/* 1170 */                   CECombatBehaviors.Behavior.builder()
/* 1171 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1172 */                   .withinDistance(0.0D, 5.0D)
/* 1173 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1181 */       .addFirstBehavior(
/* 1182 */         CECombatBehaviors.Behavior.builder()
/* 1183 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1184 */         .withinDistance(0.0D, 3.0D)
/* 1185 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1186 */         .addNextBehavior(
/* 1187 */           CECombatBehaviors.Behavior.builder()
/* 1188 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1189 */           .withinDistance(0.0D, 3.0D)
/* 1190 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1191 */           .addNextBehavior(
/* 1192 */             CECombatBehaviors.Behavior.builder()
/* 1193 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1194 */             .withinDistance(0.0D, 4.0D)
/* 1195 */             .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1196 */             .addNextBehavior(
/* 1197 */               CECombatBehaviors.Behavior.builder()
/* 1198 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1199 */               .withinDistance(0.0D, 4.0D)
/* 1200 */               .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1201 */               .addNextBehavior(
/* 1202 */                 CECombatBehaviors.Behavior.builder()
/* 1203 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1204 */                 .withinDistance(0.0D, 5.0D)
/* 1205 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1206 */                 .addNextBehavior(
/* 1207 */                   CECombatBehaviors.Behavior.builder()
/* 1208 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1209 */                   .withinDistance(0.0D, 5.0D)
/* 1210 */                   .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1211 */                   .addNextBehavior(
/* 1212 */                     CECombatBehaviors.Behavior.builder()
/* 1213 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1214 */                     .withinDistance(0.0D, 5.0D)
/* 1215 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1224 */       .addFirstBehavior(
/* 1225 */         CECombatBehaviors.Behavior.builder()
/* 1226 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1227 */         .withinDistance(0.0D, 3.0D)
/* 1228 */         .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1229 */         .addNextBehavior(
/* 1230 */           CECombatBehaviors.Behavior.builder()
/* 1231 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1232 */           .withinDistance(0.0D, 3.0D)
/* 1233 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1234 */           .addNextBehavior(
/* 1235 */             CECombatBehaviors.Behavior.builder()
/* 1236 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1237 */             .withinDistance(0.0D, 4.0D)
/* 1238 */             .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1239 */             .addNextBehavior(
/* 1240 */               CECombatBehaviors.Behavior.builder()
/* 1241 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1242 */               .withinDistance(0.0D, 4.0D)
/* 1243 */               .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1244 */               .addNextBehavior(
/* 1245 */                 CECombatBehaviors.Behavior.builder()
/* 1246 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1247 */                 .withinDistance(0.0D, 5.0D)
/* 1248 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1249 */                 .addNextBehavior(
/* 1250 */                   CECombatBehaviors.Behavior.builder()
/* 1251 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1252 */                   .withinDistance(0.0D, 5.0D)
/* 1253 */                   .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 1254 */                   .addNextBehavior(
/* 1255 */                     CECombatBehaviors.Behavior.builder()
/* 1256 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1257 */                     .withinDistance(0.0D, 5.0D)
/* 1258 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1267 */       .addFirstBehavior(
/* 1268 */         CECombatBehaviors.Behavior.builder()
/* 1269 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1270 */         .withinDistance(0.0D, 3.0D)
/* 1271 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1272 */         .addNextBehavior(
/* 1273 */           CECombatBehaviors.Behavior.builder()
/* 1274 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1275 */           .withinDistance(0.0D, 3.0D)
/* 1276 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1277 */           .addNextBehavior(
/* 1278 */             CECombatBehaviors.Behavior.builder()
/* 1279 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1280 */             .withinDistance(0.0D, 4.0D)
/* 1281 */             .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1282 */             .addNextBehavior(
/* 1283 */               CECombatBehaviors.Behavior.builder()
/* 1284 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1285 */               .withinDistance(0.0D, 4.0D)
/* 1286 */               .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1287 */               .addNextBehavior(
/* 1288 */                 CECombatBehaviors.Behavior.builder()
/* 1289 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1290 */                 .withinDistance(0.0D, 5.0D)
/* 1291 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1292 */                 .addNextBehavior(
/* 1293 */                   CECombatBehaviors.Behavior.builder()
/* 1294 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1295 */                   .withinDistance(0.0D, 5.0D)
/* 1296 */                   .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 1297 */                   .addNextBehavior(
/* 1298 */                     CECombatBehaviors.Behavior.builder()
/* 1299 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1300 */                     .withinDistance(0.0D, 5.0D)
/* 1301 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1310 */       .addFirstBehavior(
/* 1311 */         CECombatBehaviors.Behavior.builder()
/* 1312 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1313 */         .withinDistance(0.0D, 3.0D)
/* 1314 */         .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 1315 */         .addNextBehavior(
/* 1316 */           CECombatBehaviors.Behavior.builder()
/* 1317 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1318 */           .withinDistance(0.0D, 3.0D)
/* 1319 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1320 */           .addNextBehavior(
/* 1321 */             CECombatBehaviors.Behavior.builder()
/* 1322 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1323 */             .withinDistance(0.0D, 4.0D)
/* 1324 */             .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1325 */             .addNextBehavior(
/* 1326 */               CECombatBehaviors.Behavior.builder()
/* 1327 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1328 */               .withinDistance(0.0D, 4.0D)
/* 1329 */               .animationBehavior(AVAnimations.DUAL_SWORD3, 0.0F)
/* 1330 */               .addNextBehavior(
/* 1331 */                 CECombatBehaviors.Behavior.builder()
/* 1332 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1333 */                 .withinDistance(0.0D, 5.0D)
/* 1334 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1335 */                 .addNextBehavior(
/* 1336 */                   CECombatBehaviors.Behavior.builder()
/* 1337 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1338 */                   .withinDistance(0.0D, 5.0D)
/* 1339 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1347 */       .addFirstBehavior(
/* 1348 */         CECombatBehaviors.Behavior.builder()
/* 1349 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1350 */         .withinDistance(0.0D, 3.0D)
/* 1351 */         .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1352 */         .addNextBehavior(
/* 1353 */           CECombatBehaviors.Behavior.builder()
/* 1354 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1355 */           .withinDistance(0.0D, 3.0D)
/* 1356 */           .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1357 */           .addNextBehavior(
/* 1358 */             CECombatBehaviors.Behavior.builder()
/* 1359 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1360 */             .withinDistance(0.0D, 4.0D)
/* 1361 */             .animationBehavior(Animations.DANCING_EDGE, 0.0F)
/* 1362 */             .addNextBehavior(
/* 1363 */               CECombatBehaviors.Behavior.builder()
/* 1364 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1365 */               .withinDistance(0.0D, 4.0D)
/* 1366 */               .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 1367 */               .addNextBehavior(
/* 1368 */                 CECombatBehaviors.Behavior.builder()
/* 1369 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1370 */                 .withinDistance(0.0D, 5.0D)
/* 1371 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1372 */                 .addNextBehavior(
/* 1373 */                   CECombatBehaviors.Behavior.builder()
/* 1374 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1375 */                   .withinDistance(0.0D, 5.0D)
/* 1376 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1384 */       .addFirstBehavior(
/* 1385 */         CECombatBehaviors.Behavior.builder()
/* 1386 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1387 */         .withinDistance(0.0D, 3.0D)
/* 1388 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1389 */         .addNextBehavior(
/* 1390 */           CECombatBehaviors.Behavior.builder()
/* 1391 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1392 */           .withinDistance(0.0D, 3.0D)
/* 1393 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/* 1394 */           .addNextBehavior(
/* 1395 */             CECombatBehaviors.Behavior.builder()
/* 1396 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1397 */             .withinDistance(0.0D, 4.0D)
/* 1398 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1399 */             .addNextBehavior(
/* 1400 */               CECombatBehaviors.Behavior.builder()
/* 1401 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1402 */               .withinDistance(0.0D, 4.0D)
/* 1403 */               .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1404 */               .addNextBehavior(
/* 1405 */                 CECombatBehaviors.Behavior.builder()
/* 1406 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1407 */                 .withinDistance(0.0D, 5.0D)
/* 1408 */                 .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1409 */                 .addNextBehavior(
/* 1410 */                   CECombatBehaviors.Behavior.builder()
/* 1411 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1412 */                   .withinDistance(0.0D, 5.0D)
/* 1413 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1421 */       .addFirstBehavior(
/* 1422 */         CECombatBehaviors.Behavior.builder()
/* 1423 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1424 */         .withinDistance(0.0D, 3.0D)
/* 1425 */         .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1426 */         .addNextBehavior(
/* 1427 */           CECombatBehaviors.Behavior.builder()
/* 1428 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1429 */           .withinDistance(0.0D, 3.0D)
/* 1430 */           .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1431 */           .addNextBehavior(
/* 1432 */             CECombatBehaviors.Behavior.builder()
/* 1433 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1434 */             .withinDistance(0.0D, 4.0D)
/* 1435 */             .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1436 */             .addNextBehavior(
/* 1437 */               CECombatBehaviors.Behavior.builder()
/* 1438 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1439 */               .withinDistance(0.0D, 4.0D)
/* 1440 */               .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1441 */               .addNextBehavior(
/* 1442 */                 CECombatBehaviors.Behavior.builder()
/* 1443 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1444 */                 .withinDistance(0.0D, 5.0D)
/* 1445 */                 .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 1446 */                 .addNextBehavior(
/* 1447 */                   CECombatBehaviors.Behavior.builder()
/* 1448 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1449 */                   .withinDistance(0.0D, 5.0D)
/* 1450 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1451 */                   .addNextBehavior(
/* 1452 */                     CECombatBehaviors.Behavior.builder()
/* 1453 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1454 */                     .withinDistance(0.0D, 5.0D)
/* 1455 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1464 */       .addFirstBehavior(
/* 1465 */         CECombatBehaviors.Behavior.builder()
/* 1466 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1467 */         .withinDistance(0.0D, 3.0D)
/* 1468 */         .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 1469 */         .addNextBehavior(
/* 1470 */           CECombatBehaviors.Behavior.builder()
/* 1471 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1472 */           .withinDistance(0.0D, 3.0D)
/* 1473 */           .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1474 */           .addNextBehavior(
/* 1475 */             CECombatBehaviors.Behavior.builder()
/* 1476 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1477 */             .withinDistance(0.0D, 4.0D)
/* 1478 */             .animationBehavior(AVAnimations.DUAL_SWORD2, 0.0F)
/* 1479 */             .addNextBehavior(
/* 1480 */               CECombatBehaviors.Behavior.builder()
/* 1481 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1482 */               .withinDistance(0.0D, 4.0D)
/* 1483 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1484 */               .addNextBehavior(
/* 1485 */                 CECombatBehaviors.Behavior.builder()
/* 1486 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1487 */                 .withinDistance(0.0D, 5.0D)
/* 1488 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/* 1489 */                 .addNextBehavior(
/* 1490 */                   CECombatBehaviors.Behavior.builder()
/* 1491 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1492 */                   .withinDistance(0.0D, 5.0D)
/* 1493 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1501 */       .addFirstBehavior(
/* 1502 */         CECombatBehaviors.Behavior.builder()
/* 1503 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1504 */         .withinDistance(0.0D, 3.0D)
/* 1505 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1506 */         .addNextBehavior(
/* 1507 */           CECombatBehaviors.Behavior.builder()
/* 1508 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1509 */           .withinDistance(0.0D, 3.0D)
/* 1510 */           .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1511 */           .addNextBehavior(
/* 1512 */             CECombatBehaviors.Behavior.builder()
/* 1513 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1514 */             .withinDistance(0.0D, 4.0D)
/* 1515 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1516 */             .addNextBehavior(
/* 1517 */               CECombatBehaviors.Behavior.builder()
/* 1518 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1519 */               .withinDistance(0.0D, 4.0D)
/* 1520 */               .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F)
/* 1521 */               .addNextBehavior(
/* 1522 */                 CECombatBehaviors.Behavior.builder()
/* 1523 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1524 */                 .withinDistance(0.0D, 5.0D)
/* 1525 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/* 1526 */                 .addNextBehavior(
/* 1527 */                   CECombatBehaviors.Behavior.builder()
/* 1528 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1529 */                   .withinDistance(0.0D, 5.0D)
/* 1530 */                   .animationBehavior(AVAnimations.DUAL_SWORD1, 0.0F)
/* 1531 */                   .addNextBehavior(
/* 1532 */                     CECombatBehaviors.Behavior.builder()
/* 1533 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1534 */                     .withinDistance(0.0D, 5.0D)
/* 1535 */                     .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1544 */       .addFirstBehavior(
/* 1545 */         CECombatBehaviors.Behavior.builder()
/* 1546 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1547 */         .withinDistance(0.0D, 3.0D)
/* 1548 */         .animationBehavior(Animations.SWORD_DUAL_AUTO1, 0.0F)
/* 1549 */         .addNextBehavior(
/* 1550 */           CECombatBehaviors.Behavior.builder()
/* 1551 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1552 */           .withinDistance(0.0D, 3.0D)
/* 1553 */           .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F)
/* 1554 */           .addNextBehavior(
/* 1555 */             CECombatBehaviors.Behavior.builder()
/* 1556 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1557 */             .withinDistance(0.0D, 4.0D)
/* 1558 */             .animationBehavior(Animations.SWORD_DUAL_AUTO2, 0.0F)
/* 1559 */             .addNextBehavior(
/* 1560 */               CECombatBehaviors.Behavior.builder()
/* 1561 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1562 */               .withinDistance(0.0D, 4.0D)
/* 1563 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F)
/* 1564 */               .addNextBehavior(
/* 1565 */                 CECombatBehaviors.Behavior.builder()
/* 1566 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1567 */                 .withinDistance(0.0D, 5.0D)
/* 1568 */                 .animationBehavior(Animations.SWORD_DUAL_AUTO3, 0.0F)
/* 1569 */                 .addNextBehavior(
/* 1570 */                   CECombatBehaviors.Behavior.builder()
/* 1571 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1572 */                   .withinDistance(0.0D, 5.0D)
/* 1573 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1574 */                   .addNextBehavior(
/* 1575 */                     CECombatBehaviors.Behavior.builder()
/* 1576 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1577 */                     .withinDistance(0.0D, 5.0D)
/* 1578 */                     .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1588 */     .newBehaviorRoot(
/* 1589 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1590 */       .priority(1.0D)
/* 1591 */       .weight(20.0D)
/* 1592 */       .maxCooldown(100)
/* 1593 */       .addFirstBehavior(
/* 1594 */         CECombatBehaviors.Behavior.builder()
/* 1595 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1596 */         .withinDistance(0.0D, 3.0D)
/* 1597 */         .animationBehavior(Animations.DAGGER_DUAL_DASH, 0.0F)
/* 1598 */         .addNextBehavior(
/* 1599 */           CECombatBehaviors.Behavior.builder()
/* 1600 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1601 */           .withinDistance(0.0D, 3.0D)
/* 1602 */           .animationBehavior(Animations.LONGSWORD_AUTO2, 0.0F)
/* 1603 */           .addNextBehavior(
/* 1604 */             CECombatBehaviors.Behavior.builder()
/* 1605 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1606 */             .withinDistance(0.0D, 3.0D)
/* 1607 */             .animationBehavior(AVAnimations.DUAL_DANCING_EDGE, 0.0F)
/* 1608 */             .addNextBehavior(
/* 1609 */               CECombatBehaviors.Behavior.builder()
/* 1610 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1611 */               .withinDistance(0.0D, 3.0D)
/* 1612 */               .animationBehavior(AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1618 */     .newBehaviorRoot(
/* 1619 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1620 */       .priority(1.0D)
/* 1621 */       .weight(10.0D)
/* 1622 */       .maxCooldown(100)
/* 1623 */       .addFirstBehavior(
/* 1624 */         CECombatBehaviors.Behavior.builder()
/* 1625 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1626 */         .withinDistance(0.0D, 3.0D)
/* 1627 */         .animationBehavior(Animations.SWORD_DUAL_DASH, 0.0F))
/*      */       
/* 1629 */       .addFirstBehavior(
/* 1630 */         CECombatBehaviors.Behavior.builder()
/* 1631 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1632 */         .withinDistance(0.0D, 3.0D)
/* 1633 */         .animationBehavior(Animations.SWORD_DUAL_AIR_SLASH, 0.0F))
/*      */       
/* 1635 */       .addFirstBehavior(
/* 1636 */         CECombatBehaviors.Behavior.builder()
/* 1637 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1638 */         .withinDistance(0.0D, 3.0D)
/* 1639 */         .animationBehavior(Animations.DANCING_EDGE, 0.0F)))
/*      */ 
/*      */     
/* 1642 */     .newBehaviorRoot(
/* 1643 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1644 */       .priority(1.0D)
/* 1645 */       .weight(10.0D)
/* 1646 */       .maxCooldown(100)
/* 1647 */       .addFirstBehavior(
/* 1648 */         CECombatBehaviors.Behavior.builder()
/* 1649 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1650 */         .withinDistance(0.0D, 3.0D)
/* 1651 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1652 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 1653 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1654 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1657 */     .newBehaviorRoot(
/* 1658 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1659 */       .priority(1.0D)
/* 1660 */       .weight(2.0D)
/* 1661 */       .maxCooldown(100)
/* 1662 */       .addFirstBehavior(
/* 1663 */         CECombatBehaviors.Behavior.builder()
/* 1664 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1665 */         .withinDistance(0.0D, 3.0D)
/* 1666 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1668 */       .addFirstBehavior(
/* 1669 */         CECombatBehaviors.Behavior.builder()
/* 1670 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1671 */         .withinDistance(0.0D, 3.0D)
/* 1672 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1674 */       .addFirstBehavior(
/* 1675 */         CECombatBehaviors.Behavior.builder()
/* 1676 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1677 */         .withinDistance(0.0D, 3.0D)
/* 1678 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1680 */       .addFirstBehavior(
/* 1681 */         CECombatBehaviors.Behavior.builder()
/* 1682 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1683 */         .withinDistance(0.0D, 3.0D)
/* 1684 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1686 */       .addFirstBehavior(
/* 1687 */         CECombatBehaviors.Behavior.builder()
/* 1688 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1689 */         .withinDistance(0.0D, 3.0D)
/* 1690 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1692 */       .addFirstBehavior(
/* 1693 */         CECombatBehaviors.Behavior.builder()
/* 1694 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1695 */         .withinDistance(0.0D, 3.0D)
/* 1696 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1698 */       .addFirstBehavior(
/* 1699 */         CECombatBehaviors.Behavior.builder()
/* 1700 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1701 */         .withinDistance(0.0D, 3.0D)
/* 1702 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1705 */     .newBehaviorRoot(
/* 1706 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1707 */       .priority(1.0D)
/* 1708 */       .weight(15.0D)
/* 1709 */       .addFirstBehavior(
/* 1710 */         CECombatBehaviors.Behavior.builder()
/* 1711 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1712 */         .withinDistance(0.0D, 3.0D)
/* 1713 */         .custom(CombatCommon::canPerformGuarding)
/* 1714 */         .guard(40)))
/*      */ 
/*      */     
/* 1717 */     .newBehaviorRoot(
/* 1718 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1719 */       .priority(1.0D)
/* 1720 */       .weight(10.0D)
/* 1721 */       .addFirstBehavior(
/* 1722 */         CECombatBehaviors.Behavior.builder()
/* 1723 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1724 */         .withinDistance(0.0D, 3.0D)
/* 1725 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1727 */       .addFirstBehavior(
/* 1728 */         CECombatBehaviors.Behavior.builder()
/* 1729 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1730 */         .withinDistance(0.0D, 3.0D)
/* 1731 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1734 */     .newBehaviorRoot(
/* 1735 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1736 */       .priority(1.0D)
/* 1737 */       .weight(40.0D)
/* 1738 */       .maxCooldown(160)
/* 1739 */       .addFirstBehavior(
/* 1740 */         CECombatBehaviors.Behavior.builder()
/* 1741 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1742 */         .custom(CombatCommon::canJump)
/* 1743 */         .withinDistance(5.0D, 14.0D)
/* 1744 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1745 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */