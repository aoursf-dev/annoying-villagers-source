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
/*      */ public class HerobrineShadowObsidianPillar
/*      */ {
/*   14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SHADOW_OBSIDIAN_PILLAR_WEAPON = CECombatBehaviors.builder()
/*   15 */     .newBehaviorRoot(
/*   16 */       CECombatBehaviors.BehaviorRoot.builder()
/*   17 */       .priority(5.0D)
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
/*   30 */       .priority(4.0D)
/*   31 */       .weight(1000.0D)
/*   32 */       .maxCooldown(0)
/*   33 */       .addFirstBehavior(
/*   34 */         CECombatBehaviors.Behavior.builder()
/*   35 */         .custom(CombatCommon::canEscape)
/*   36 */         .withinDistance(0.0D, 8.0D)
/*   37 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   38 */         .addExBehavior(CombatCommon::performEscapeRunAway)))
/*      */ 
/*      */     
/*   41 */     .newBehaviorRoot(
/*   42 */       CECombatBehaviors.BehaviorRoot.builder()
/*   43 */       .priority(3.0D)
/*   44 */       .weight(100.0D)
/*   45 */       .maxCooldown(120)
/*   46 */       .addFirstBehavior(
/*   47 */         CECombatBehaviors.Behavior.builder()
/*   48 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   49 */         .custom(CombatCommon::canSwitchWeapon)
/*   50 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   51 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   53 */       .addFirstBehavior(
/*   54 */         CECombatBehaviors.Behavior.builder()
/*   55 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   56 */         .custom(CombatCommon::canSwitchWeapon)
/*   57 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*   58 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*   61 */     .newBehaviorRoot(
/*   62 */       CECombatBehaviors.BehaviorRoot.builder()
/*   63 */       .priority(2.0D)
/*   64 */       .weight(70.0D)
/*   65 */       .maxCooldown(0)
/*   66 */       .addFirstBehavior(
/*   67 */         CECombatBehaviors.Behavior.builder()
/*   68 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   69 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   70 */         .custom(HerobrineCommon::canPerformHealing)
/*   71 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*   72 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*      */ 
/*      */     
/*   75 */     .newBehaviorRoot(
/*   76 */       CECombatBehaviors.BehaviorRoot.builder()
/*   77 */       .priority(2.0D)
/*   78 */       .weight(70.0D)
/*   79 */       .maxCooldown(100)
/*   80 */       .addFirstBehavior(
/*   81 */         CECombatBehaviors.Behavior.builder()
/*   82 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   83 */         .custom(HerobrineCommon::canSummonDarkOb)
/*   84 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*   85 */         .addExBehavior(HerobrineCommon::performSummonDarkOb)))
/*      */ 
/*      */     
/*   88 */     .newBehaviorRoot(
/*   89 */       CECombatBehaviors.BehaviorRoot.builder()
/*   90 */       .priority(1.0D)
/*   91 */       .weight(40.0D)
/*   92 */       .maxCooldown(20)
/*   93 */       .addFirstBehavior(
/*   94 */         CECombatBehaviors.Behavior.builder()
/*   95 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   96 */         .withinDistance(0.0D, 4.0D)
/*   97 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*   98 */         .addNextBehavior(
/*   99 */           CECombatBehaviors.Behavior.builder()
/*  100 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  101 */           .withinDistance(0.0D, 5.0D)
/*  102 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  103 */           .addNextBehavior(
/*  104 */             CECombatBehaviors.Behavior.builder()
/*  105 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  106 */             .withinDistance(0.0D, 5.0D)
/*  107 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  108 */             .addNextBehavior(
/*  109 */               CECombatBehaviors.Behavior.builder()
/*  110 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  111 */               .withinDistance(0.0D, 6.0D)
/*  112 */               .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  113 */               .addNextBehavior(
/*  114 */                 CECombatBehaviors.Behavior.builder()
/*  115 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  116 */                 .withinDistance(0.0D, 6.0D)
/*  117 */                 .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  123 */       .addFirstBehavior(
/*  124 */         CECombatBehaviors.Behavior.builder()
/*  125 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  126 */         .withinDistance(0.0D, 3.0D)
/*  127 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  128 */         .addNextBehavior(
/*  129 */           CECombatBehaviors.Behavior.builder()
/*  130 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  131 */           .withinDistance(0.0D, 4.0D)
/*  132 */           .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/*  133 */           .addNextBehavior(
/*  134 */             CECombatBehaviors.Behavior.builder()
/*  135 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  136 */             .withinDistance(0.0D, 5.0D)
/*  137 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  138 */             .addNextBehavior(
/*  139 */               CECombatBehaviors.Behavior.builder()
/*  140 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  141 */               .withinDistance(0.0D, 5.0D)
/*  142 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  143 */               .addNextBehavior(
/*  144 */                 CECombatBehaviors.Behavior.builder()
/*  145 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  146 */                 .withinDistance(0.0D, 6.0D)
/*  147 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  154 */       .addFirstBehavior(
/*  155 */         CECombatBehaviors.Behavior.builder()
/*  156 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  157 */         .withinDistance(0.0D, 3.0D)
/*  158 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  159 */         .addNextBehavior(
/*  160 */           CECombatBehaviors.Behavior.builder()
/*  161 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  162 */           .withinDistance(0.0D, 4.0D)
/*  163 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  164 */           .addNextBehavior(
/*  165 */             CECombatBehaviors.Behavior.builder()
/*  166 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  167 */             .withinDistance(0.0D, 5.0D)
/*  168 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  169 */             .addNextBehavior(
/*  170 */               CECombatBehaviors.Behavior.builder()
/*  171 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  172 */               .withinDistance(0.0D, 5.0D)
/*  173 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  174 */               .addNextBehavior(
/*  175 */                 CECombatBehaviors.Behavior.builder()
/*  176 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  177 */                 .withinDistance(0.0D, 6.0D)
/*  178 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  185 */       .addFirstBehavior(
/*  186 */         CECombatBehaviors.Behavior.builder()
/*  187 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  188 */         .withinDistance(0.0D, 3.0D)
/*  189 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  190 */         .addNextBehavior(
/*  191 */           CECombatBehaviors.Behavior.builder()
/*  192 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  193 */           .withinDistance(0.0D, 4.0D)
/*  194 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  195 */           .addNextBehavior(
/*  196 */             CECombatBehaviors.Behavior.builder()
/*  197 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  198 */             .withinDistance(0.0D, 5.0D)
/*  199 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  200 */             .addNextBehavior(
/*  201 */               CECombatBehaviors.Behavior.builder()
/*  202 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  203 */               .withinDistance(0.0D, 5.0D)
/*  204 */               .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  205 */               .addNextBehavior(
/*  206 */                 CECombatBehaviors.Behavior.builder()
/*  207 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  208 */                 .withinDistance(0.0D, 6.0D)
/*  209 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  216 */       .addFirstBehavior(
/*  217 */         CECombatBehaviors.Behavior.builder()
/*  218 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  219 */         .withinDistance(0.0D, 3.0D)
/*  220 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/*  221 */         .addNextBehavior(
/*  222 */           CECombatBehaviors.Behavior.builder()
/*  223 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  224 */           .withinDistance(0.0D, 4.0D)
/*  225 */           .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  226 */           .addNextBehavior(
/*  227 */             CECombatBehaviors.Behavior.builder()
/*  228 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  229 */             .withinDistance(0.0D, 5.0D)
/*  230 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  231 */             .addNextBehavior(
/*  232 */               CECombatBehaviors.Behavior.builder()
/*  233 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  234 */               .withinDistance(0.0D, 5.0D)
/*  235 */               .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  236 */               .addNextBehavior(
/*  237 */                 CECombatBehaviors.Behavior.builder()
/*  238 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  239 */                 .withinDistance(0.0D, 6.0D)
/*  240 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  247 */       .addFirstBehavior(
/*  248 */         CECombatBehaviors.Behavior.builder()
/*  249 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  250 */         .withinDistance(0.0D, 3.0D)
/*  251 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  252 */         .addNextBehavior(
/*  253 */           CECombatBehaviors.Behavior.builder()
/*  254 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  255 */           .withinDistance(0.0D, 4.0D)
/*  256 */           .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/*  257 */           .addNextBehavior(
/*  258 */             CECombatBehaviors.Behavior.builder()
/*  259 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  260 */             .withinDistance(0.0D, 5.0D)
/*  261 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  262 */             .addNextBehavior(
/*  263 */               CECombatBehaviors.Behavior.builder()
/*  264 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  265 */               .withinDistance(0.0D, 5.0D)
/*  266 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  267 */               .addNextBehavior(
/*  268 */                 CECombatBehaviors.Behavior.builder()
/*  269 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  270 */                 .withinDistance(0.0D, 6.0D)
/*  271 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  280 */       .addFirstBehavior(
/*  281 */         CECombatBehaviors.Behavior.builder()
/*  282 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  283 */         .withinDistance(0.0D, 3.0D)
/*  284 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  285 */         .addNextBehavior(
/*  286 */           CECombatBehaviors.Behavior.builder()
/*  287 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  288 */           .withinDistance(0.0D, 4.0D)
/*  289 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  290 */           .addNextBehavior(
/*  291 */             CECombatBehaviors.Behavior.builder()
/*  292 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  293 */             .withinDistance(0.0D, 5.0D)
/*  294 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  295 */             .addNextBehavior(
/*  296 */               CECombatBehaviors.Behavior.builder()
/*  297 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  298 */               .withinDistance(0.0D, 5.0D)
/*  299 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  300 */               .addNextBehavior(
/*  301 */                 CECombatBehaviors.Behavior.builder()
/*  302 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  303 */                 .withinDistance(0.0D, 6.0D)
/*  304 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
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
/*  315 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  316 */         .addNextBehavior(
/*  317 */           CECombatBehaviors.Behavior.builder()
/*  318 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  319 */           .withinDistance(0.0D, 4.0D)
/*  320 */           .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  321 */           .addNextBehavior(
/*  322 */             CECombatBehaviors.Behavior.builder()
/*  323 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  324 */             .withinDistance(0.0D, 5.0D)
/*  325 */             .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/*  326 */             .addNextBehavior(
/*  327 */               CECombatBehaviors.Behavior.builder()
/*  328 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  329 */               .withinDistance(0.0D, 5.0D)
/*  330 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  331 */               .addNextBehavior(
/*  332 */                 CECombatBehaviors.Behavior.builder()
/*  333 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  334 */                 .withinDistance(0.0D, 6.0D)
/*  335 */                 .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  342 */       .addFirstBehavior(
/*  343 */         CECombatBehaviors.Behavior.builder()
/*  344 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  345 */         .withinDistance(0.0D, 3.0D)
/*  346 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  347 */         .addNextBehavior(
/*  348 */           CECombatBehaviors.Behavior.builder()
/*  349 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  350 */           .withinDistance(0.0D, 4.0D)
/*  351 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  352 */           .addNextBehavior(
/*  353 */             CECombatBehaviors.Behavior.builder()
/*  354 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  355 */             .withinDistance(0.0D, 5.0D)
/*  356 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  357 */             .addNextBehavior(
/*  358 */               CECombatBehaviors.Behavior.builder()
/*  359 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  360 */               .withinDistance(0.0D, 5.0D)
/*  361 */               .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/*  362 */               .addNextBehavior(
/*  363 */                 CECombatBehaviors.Behavior.builder()
/*  364 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  365 */                 .withinDistance(0.0D, 6.0D)
/*  366 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  373 */       .addFirstBehavior(
/*  374 */         CECombatBehaviors.Behavior.builder()
/*  375 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  376 */         .withinDistance(0.0D, 3.0D)
/*  377 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  378 */         .addNextBehavior(
/*  379 */           CECombatBehaviors.Behavior.builder()
/*  380 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  381 */           .withinDistance(0.0D, 4.0D)
/*  382 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  383 */           .addNextBehavior(
/*  384 */             CECombatBehaviors.Behavior.builder()
/*  385 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  386 */             .withinDistance(0.0D, 5.0D)
/*  387 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  388 */             .addNextBehavior(
/*  389 */               CECombatBehaviors.Behavior.builder()
/*  390 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  391 */               .withinDistance(0.0D, 5.0D)
/*  392 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  393 */               .addNextBehavior(
/*  394 */                 CECombatBehaviors.Behavior.builder()
/*  395 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  396 */                 .withinDistance(0.0D, 6.0D)
/*  397 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
/*      */ 
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
/*  410 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  411 */         .addNextBehavior(
/*  412 */           CECombatBehaviors.Behavior.builder()
/*  413 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  414 */           .withinDistance(0.0D, 4.0D)
/*  415 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  416 */           .addNextBehavior(
/*  417 */             CECombatBehaviors.Behavior.builder()
/*  418 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  419 */             .withinDistance(0.0D, 5.0D)
/*  420 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  421 */             .addNextBehavior(
/*  422 */               CECombatBehaviors.Behavior.builder()
/*  423 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  424 */               .withinDistance(0.0D, 5.0D)
/*  425 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  426 */               .addNextBehavior(
/*  427 */                 CECombatBehaviors.Behavior.builder()
/*  428 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  429 */                 .withinDistance(0.0D, 6.0D)
/*  430 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
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
/*  441 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/*  442 */         .addNextBehavior(
/*  443 */           CECombatBehaviors.Behavior.builder()
/*  444 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  445 */           .withinDistance(0.0D, 4.0D)
/*  446 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  447 */           .addNextBehavior(
/*  448 */             CECombatBehaviors.Behavior.builder()
/*  449 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  450 */             .withinDistance(0.0D, 5.0D)
/*  451 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  452 */             .addNextBehavior(
/*  453 */               CECombatBehaviors.Behavior.builder()
/*  454 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  455 */               .withinDistance(0.0D, 5.0D)
/*  456 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  457 */               .addNextBehavior(
/*  458 */                 CECombatBehaviors.Behavior.builder()
/*  459 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  460 */                 .withinDistance(0.0D, 6.0D)
/*  461 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
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
/*  472 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  473 */         .addNextBehavior(
/*  474 */           CECombatBehaviors.Behavior.builder()
/*  475 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  476 */           .withinDistance(0.0D, 4.0D)
/*  477 */           .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/*  478 */           .addNextBehavior(
/*  479 */             CECombatBehaviors.Behavior.builder()
/*  480 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  481 */             .withinDistance(0.0D, 5.0D)
/*  482 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  483 */             .addNextBehavior(
/*  484 */               CECombatBehaviors.Behavior.builder()
/*  485 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */               .withinDistance(0.0D, 5.0D)
/*  487 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  488 */               .addNextBehavior(
/*  489 */                 CECombatBehaviors.Behavior.builder()
/*  490 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  491 */                 .withinDistance(0.0D, 6.0D)
/*  492 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
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
/*  503 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  504 */         .addNextBehavior(
/*  505 */           CECombatBehaviors.Behavior.builder()
/*  506 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  507 */           .withinDistance(0.0D, 4.0D)
/*  508 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  509 */           .addNextBehavior(
/*  510 */             CECombatBehaviors.Behavior.builder()
/*  511 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  512 */             .withinDistance(0.0D, 5.0D)
/*  513 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  514 */             .addNextBehavior(
/*  515 */               CECombatBehaviors.Behavior.builder()
/*  516 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  517 */               .withinDistance(0.0D, 5.0D)
/*  518 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  519 */               .addNextBehavior(
/*  520 */                 CECombatBehaviors.Behavior.builder()
/*  521 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  522 */                 .withinDistance(0.0D, 6.0D)
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
/*  534 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  535 */         .addNextBehavior(
/*  536 */           CECombatBehaviors.Behavior.builder()
/*  537 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  538 */           .withinDistance(0.0D, 4.0D)
/*  539 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  540 */           .addNextBehavior(
/*  541 */             CECombatBehaviors.Behavior.builder()
/*  542 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  543 */             .withinDistance(0.0D, 5.0D)
/*  544 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  545 */             .addNextBehavior(
/*  546 */               CECombatBehaviors.Behavior.builder()
/*  547 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  548 */               .withinDistance(0.0D, 5.0D)
/*  549 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  550 */               .addNextBehavior(
/*  551 */                 CECombatBehaviors.Behavior.builder()
/*  552 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  553 */                 .withinDistance(0.0D, 6.0D)
/*  554 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  563 */       .addFirstBehavior(
/*  564 */         CECombatBehaviors.Behavior.builder()
/*  565 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  566 */         .withinDistance(0.0D, 3.0D)
/*  567 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  568 */         .addNextBehavior(
/*  569 */           CECombatBehaviors.Behavior.builder()
/*  570 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  571 */           .withinDistance(0.0D, 4.0D)
/*  572 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  573 */           .addNextBehavior(
/*  574 */             CECombatBehaviors.Behavior.builder()
/*  575 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  576 */             .withinDistance(0.0D, 5.0D)
/*  577 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  578 */             .addNextBehavior(
/*  579 */               CECombatBehaviors.Behavior.builder()
/*  580 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  581 */               .withinDistance(0.0D, 5.0D)
/*  582 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  583 */               .addNextBehavior(
/*  584 */                 CECombatBehaviors.Behavior.builder()
/*  585 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  586 */                 .withinDistance(0.0D, 6.0D)
/*  587 */                 .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  594 */       .addFirstBehavior(
/*  595 */         CECombatBehaviors.Behavior.builder()
/*  596 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  597 */         .withinDistance(0.0D, 3.0D)
/*  598 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/*  599 */         .addNextBehavior(
/*  600 */           CECombatBehaviors.Behavior.builder()
/*  601 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  602 */           .withinDistance(0.0D, 4.0D)
/*  603 */           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  604 */           .addNextBehavior(
/*  605 */             CECombatBehaviors.Behavior.builder()
/*  606 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  607 */             .withinDistance(0.0D, 5.0D)
/*  608 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  609 */             .addNextBehavior(
/*  610 */               CECombatBehaviors.Behavior.builder()
/*  611 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  612 */               .withinDistance(0.0D, 5.0D)
/*  613 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  614 */               .addNextBehavior(
/*  615 */                 CECombatBehaviors.Behavior.builder()
/*  616 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  617 */                 .withinDistance(0.0D, 6.0D)
/*  618 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
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
/*  629 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  630 */         .addNextBehavior(
/*  631 */           CECombatBehaviors.Behavior.builder()
/*  632 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  633 */           .withinDistance(0.0D, 4.0D)
/*  634 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  635 */           .addNextBehavior(
/*  636 */             CECombatBehaviors.Behavior.builder()
/*  637 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  638 */             .withinDistance(0.0D, 5.0D)
/*  639 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  640 */             .addNextBehavior(
/*  641 */               CECombatBehaviors.Behavior.builder()
/*  642 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  643 */               .withinDistance(0.0D, 5.0D)
/*  644 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  645 */               .addNextBehavior(
/*  646 */                 CECombatBehaviors.Behavior.builder()
/*  647 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  648 */                 .withinDistance(0.0D, 6.0D)
/*  649 */                 .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
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
/*  660 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  661 */         .addNextBehavior(
/*  662 */           CECombatBehaviors.Behavior.builder()
/*  663 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  664 */           .withinDistance(0.0D, 4.0D)
/*  665 */           .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  666 */           .addNextBehavior(
/*  667 */             CECombatBehaviors.Behavior.builder()
/*  668 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  669 */             .withinDistance(0.0D, 5.0D)
/*  670 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  671 */             .addNextBehavior(
/*  672 */               CECombatBehaviors.Behavior.builder()
/*  673 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  674 */               .withinDistance(0.0D, 5.0D)
/*  675 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  676 */               .addNextBehavior(
/*  677 */                 CECombatBehaviors.Behavior.builder()
/*  678 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  679 */                 .withinDistance(0.0D, 6.0D)
/*  680 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  687 */       .addFirstBehavior(
/*  688 */         CECombatBehaviors.Behavior.builder()
/*  689 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  690 */         .withinDistance(0.0D, 3.0D)
/*  691 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  692 */         .addNextBehavior(
/*  693 */           CECombatBehaviors.Behavior.builder()
/*  694 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  695 */           .withinDistance(0.0D, 4.0D)
/*  696 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  697 */           .addNextBehavior(
/*  698 */             CECombatBehaviors.Behavior.builder()
/*  699 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  700 */             .withinDistance(0.0D, 5.0D)
/*  701 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  702 */             .addNextBehavior(
/*  703 */               CECombatBehaviors.Behavior.builder()
/*  704 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  705 */               .withinDistance(0.0D, 5.0D)
/*  706 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  707 */               .addNextBehavior(
/*  708 */                 CECombatBehaviors.Behavior.builder()
/*  709 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  710 */                 .withinDistance(0.0D, 6.0D)
/*  711 */                 .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  720 */       .addFirstBehavior(
/*  721 */         CECombatBehaviors.Behavior.builder()
/*  722 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  723 */         .withinDistance(0.0D, 3.0D)
/*  724 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  725 */         .addNextBehavior(
/*  726 */           CECombatBehaviors.Behavior.builder()
/*  727 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  728 */           .withinDistance(0.0D, 4.0D)
/*  729 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  730 */           .addNextBehavior(
/*  731 */             CECombatBehaviors.Behavior.builder()
/*  732 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  733 */             .withinDistance(0.0D, 5.0D)
/*  734 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  735 */             .addNextBehavior(
/*  736 */               CECombatBehaviors.Behavior.builder()
/*  737 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  738 */               .withinDistance(0.0D, 5.0D)
/*  739 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  740 */               .addNextBehavior(
/*  741 */                 CECombatBehaviors.Behavior.builder()
/*  742 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  743 */                 .withinDistance(0.0D, 6.0D)
/*  744 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  751 */       .addFirstBehavior(
/*  752 */         CECombatBehaviors.Behavior.builder()
/*  753 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  754 */         .withinDistance(0.0D, 3.0D)
/*  755 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  756 */         .addNextBehavior(
/*  757 */           CECombatBehaviors.Behavior.builder()
/*  758 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  759 */           .withinDistance(0.0D, 4.0D)
/*  760 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  761 */           .addNextBehavior(
/*  762 */             CECombatBehaviors.Behavior.builder()
/*  763 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  764 */             .withinDistance(0.0D, 5.0D)
/*  765 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  766 */             .addNextBehavior(
/*  767 */               CECombatBehaviors.Behavior.builder()
/*  768 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  769 */               .withinDistance(0.0D, 5.0D)
/*  770 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  771 */               .addNextBehavior(
/*  772 */                 CECombatBehaviors.Behavior.builder()
/*  773 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  774 */                 .withinDistance(0.0D, 6.0D)
/*  775 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  782 */       .addFirstBehavior(
/*  783 */         CECombatBehaviors.Behavior.builder()
/*  784 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  785 */         .withinDistance(0.0D, 3.0D)
/*  786 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/*  787 */         .addNextBehavior(
/*  788 */           CECombatBehaviors.Behavior.builder()
/*  789 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  790 */           .withinDistance(0.0D, 4.0D)
/*  791 */           .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/*  792 */           .addNextBehavior(
/*  793 */             CECombatBehaviors.Behavior.builder()
/*  794 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  795 */             .withinDistance(0.0D, 5.0D)
/*  796 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  797 */             .addNextBehavior(
/*  798 */               CECombatBehaviors.Behavior.builder()
/*  799 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  800 */               .withinDistance(0.0D, 5.0D)
/*  801 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  802 */               .addNextBehavior(
/*  803 */                 CECombatBehaviors.Behavior.builder()
/*  804 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  805 */                 .withinDistance(0.0D, 6.0D)
/*  806 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  813 */       .addFirstBehavior(
/*  814 */         CECombatBehaviors.Behavior.builder()
/*  815 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  816 */         .withinDistance(0.0D, 3.0D)
/*  817 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  818 */         .addNextBehavior(
/*  819 */           CECombatBehaviors.Behavior.builder()
/*  820 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  821 */           .withinDistance(0.0D, 4.0D)
/*  822 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  823 */           .addNextBehavior(
/*  824 */             CECombatBehaviors.Behavior.builder()
/*  825 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  826 */             .withinDistance(0.0D, 5.0D)
/*  827 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  828 */             .addNextBehavior(
/*  829 */               CECombatBehaviors.Behavior.builder()
/*  830 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  831 */               .withinDistance(0.0D, 5.0D)
/*  832 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  833 */               .addNextBehavior(
/*  834 */                 CECombatBehaviors.Behavior.builder()
/*  835 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  836 */                 .withinDistance(0.0D, 6.0D)
/*  837 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  844 */       .addFirstBehavior(
/*  845 */         CECombatBehaviors.Behavior.builder()
/*  846 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  847 */         .withinDistance(0.0D, 3.0D)
/*  848 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  849 */         .addNextBehavior(
/*  850 */           CECombatBehaviors.Behavior.builder()
/*  851 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  852 */           .withinDistance(0.0D, 4.0D)
/*  853 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  854 */           .addNextBehavior(
/*  855 */             CECombatBehaviors.Behavior.builder()
/*  856 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  857 */             .withinDistance(0.0D, 5.0D)
/*  858 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  859 */             .addNextBehavior(
/*  860 */               CECombatBehaviors.Behavior.builder()
/*  861 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  862 */               .withinDistance(0.0D, 5.0D)
/*  863 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  864 */               .addNextBehavior(
/*  865 */                 CECombatBehaviors.Behavior.builder()
/*  866 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  867 */                 .withinDistance(0.0D, 6.0D)
/*  868 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  875 */     .newBehaviorRoot(
/*  876 */       CECombatBehaviors.BehaviorRoot.builder()
/*  877 */       .priority(1.0D)
/*  878 */       .weight(30.0D)
/*  879 */       .maxCooldown(100)
/*  880 */       .addFirstBehavior(
/*  881 */         CECombatBehaviors.Behavior.builder()
/*  882 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  883 */         .withinDistance(0.0D, 5.0D)
/*  884 */         .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))
/*      */       
/*  886 */       .addFirstBehavior(
/*  887 */         CECombatBehaviors.Behavior.builder()
/*  888 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  889 */         .withinDistance(0.0D, 10.0D)
/*  890 */         .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))
/*      */       
/*  892 */       .addFirstBehavior(
/*  893 */         CECombatBehaviors.Behavior.builder()
/*  894 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  895 */         .withinDistance(0.0D, 5.0D)
/*  896 */         .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)))
/*      */ 
/*      */     
/*  899 */     .newBehaviorRoot(
/*  900 */       CECombatBehaviors.BehaviorRoot.builder()
/*  901 */       .priority(1.0D)
/*  902 */       .weight(20.0D)
/*  903 */       .maxCooldown(200)
/*  904 */       .addFirstBehavior(
/*  905 */         CECombatBehaviors.Behavior.builder()
/*  906 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  907 */         .withinDistance(0.0D, 5.0D)
/*  908 */         .animationBehavior(AVAnimations.OBSIDIAN_BIPED_LANDING, 0.0F))
/*      */       
/*  910 */       .addFirstBehavior(
/*  911 */         CECombatBehaviors.Behavior.builder()
/*  912 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  913 */         .withinDistance(0.0D, 5.0D)
/*  914 */         .animationBehavior(AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F))
/*      */       
/*  916 */       .addFirstBehavior(
/*  917 */         CECombatBehaviors.Behavior.builder()
/*  918 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  919 */         .custom(HerobrineCommon::canShootDarkOb)
/*  920 */         .withinDistance(5.0D, 10.0D)
/*  921 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  922 */         .addExBehavior(HerobrineCommon::performShootDarkOb)))
/*      */ 
/*      */     
/*  925 */     .newBehaviorRoot(
/*  926 */       CECombatBehaviors.BehaviorRoot.builder()
/*  927 */       .priority(1.0D)
/*  928 */       .weight(15.0D)
/*  929 */       .maxCooldown(200)
/*  930 */       .addFirstBehavior(
/*  931 */         CECombatBehaviors.Behavior.builder()
/*  932 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  933 */         .custom(HerobrineCommon::canPlayObsidianMachine)
/*  934 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  935 */         .addExBehavior(HerobrineCommon::performObsidianMachine)))
/*      */ 
/*      */     
/*  938 */     .newBehaviorRoot(
/*  939 */       CECombatBehaviors.BehaviorRoot.builder()
/*  940 */       .priority(1.0D)
/*  941 */       .weight(2.0D)
/*  942 */       .maxCooldown(100)
/*  943 */       .addFirstBehavior(
/*  944 */         CECombatBehaviors.Behavior.builder()
/*  945 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  946 */         .withinDistance(0.0D, 5.0D)
/*  947 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  949 */       .addFirstBehavior(
/*  950 */         CECombatBehaviors.Behavior.builder()
/*  951 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  952 */         .withinDistance(0.0D, 5.0D)
/*  953 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  955 */       .addFirstBehavior(
/*  956 */         CECombatBehaviors.Behavior.builder()
/*  957 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  958 */         .withinDistance(0.0D, 5.0D)
/*  959 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  961 */       .addFirstBehavior(
/*  962 */         CECombatBehaviors.Behavior.builder()
/*  963 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  964 */         .withinDistance(0.0D, 5.0D)
/*  965 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F)))
/*      */ 
/*      */     
/*  968 */     .newBehaviorRoot(
/*  969 */       CECombatBehaviors.BehaviorRoot.builder()
/*  970 */       .priority(1.0D)
/*  971 */       .weight(15.0D)
/*  972 */       .addFirstBehavior(
/*  973 */         CECombatBehaviors.Behavior.builder()
/*  974 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  975 */         .withinDistance(0.0D, 3.0D)
/*  976 */         .custom(HerobrineCommon::canPerformGuarding)
/*  977 */         .guard(40)))
/*      */ 
/*      */     
/*  980 */     .newBehaviorRoot(
/*  981 */       CECombatBehaviors.BehaviorRoot.builder()
/*  982 */       .priority(1.0D)
/*  983 */       .weight(10.0D)
/*  984 */       .addFirstBehavior(
/*  985 */         CECombatBehaviors.Behavior.builder()
/*  986 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  987 */         .withinDistance(0.0D, 5.0D)
/*  988 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/*  990 */       .addFirstBehavior(
/*  991 */         CECombatBehaviors.Behavior.builder()
/*  992 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  993 */         .withinDistance(0.0D, 5.0D)
/*  994 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))
/*      */       
/*  996 */       .addFirstBehavior(
/*  997 */         CECombatBehaviors.Behavior.builder()
/*  998 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  999 */         .withinDistance(0.0D, 5.0D)
/* 1000 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1002 */       .addFirstBehavior(
/* 1003 */         CECombatBehaviors.Behavior.builder()
/* 1004 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1005 */         .withinDistance(0.0D, 5.0D)
/* 1006 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1008 */       .addFirstBehavior(
/* 1009 */         CECombatBehaviors.Behavior.builder()
/* 1010 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1011 */         .withinDistance(0.0D, 5.0D)
/* 1012 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1014 */       .addFirstBehavior(
/* 1015 */         CECombatBehaviors.Behavior.builder()
/* 1016 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1017 */         .withinDistance(0.0D, 5.0D)
/* 1018 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1021 */     .newBehaviorRoot(
/* 1022 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1023 */       .priority(1.0D)
/* 1024 */       .weight(20.0D)
/* 1025 */       .maxCooldown(160)
/* 1026 */       .addFirstBehavior(
/* 1027 */         CECombatBehaviors.Behavior.builder()
/* 1028 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1029 */         .custom(HerobrineCommon::canJump)
/* 1030 */         .withinDistance(5.0D, 14.0D)
/* 1031 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1032 */         .addExBehavior(HerobrineCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/* 1036 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SHADOW_OBSIDIAN_PILLAR_SWORD_WEAPON = CECombatBehaviors.builder()
/* 1037 */     .newBehaviorRoot(
/* 1038 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1039 */       .priority(5.0D)
/* 1040 */       .weight(1000.0D)
/* 1041 */       .maxCooldown(0)
/* 1042 */       .addFirstBehavior(
/* 1043 */         CECombatBehaviors.Behavior.builder()
/* 1044 */         .custom(CombatCommon::canExecute)
/* 1045 */         .withinDistance(0.0D, 5.0D)
/* 1046 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/* 1047 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/* 1050 */     .newBehaviorRoot(
/* 1051 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1052 */       .priority(4.0D)
/* 1053 */       .weight(1000.0D)
/* 1054 */       .maxCooldown(0)
/* 1055 */       .addFirstBehavior(
/* 1056 */         CECombatBehaviors.Behavior.builder()
/* 1057 */         .custom(CombatCommon::canEscape)
/* 1058 */         .withinDistance(0.0D, 8.0D)
/* 1059 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1060 */         .addExBehavior(CombatCommon::performEscapeRunAway)))
/*      */ 
/*      */     
/* 1063 */     .newBehaviorRoot(
/* 1064 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1065 */       .priority(3.0D)
/* 1066 */       .weight(100.0D)
/* 1067 */       .maxCooldown(120)
/* 1068 */       .addFirstBehavior(
/* 1069 */         CECombatBehaviors.Behavior.builder()
/* 1070 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1071 */         .custom(CombatCommon::canSwitchWeapon)
/* 1072 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1073 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/* 1075 */       .addFirstBehavior(
/* 1076 */         CECombatBehaviors.Behavior.builder()
/* 1077 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1078 */         .custom(CombatCommon::canSwitchWeapon)
/* 1079 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1080 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/* 1083 */     .newBehaviorRoot(
/* 1084 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1085 */       .priority(2.0D)
/* 1086 */       .weight(70.0D)
/* 1087 */       .maxCooldown(0)
/* 1088 */       .addFirstBehavior(
/* 1089 */         CECombatBehaviors.Behavior.builder()
/* 1090 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1091 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 1092 */         .custom(HerobrineCommon::canPerformHealing)
/* 1093 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/* 1094 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*      */ 
/*      */     
/* 1097 */     .newBehaviorRoot(
/* 1098 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1099 */       .priority(2.0D)
/* 1100 */       .weight(70.0D)
/* 1101 */       .maxCooldown(100)
/* 1102 */       .addFirstBehavior(
/* 1103 */         CECombatBehaviors.Behavior.builder()
/* 1104 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1105 */         .custom(HerobrineCommon::canSummonDarkOb)
/* 1106 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/* 1107 */         .addExBehavior(HerobrineCommon::performSummonDarkOb)))
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
/* 1118 */         .withinDistance(0.0D, 4.0D)
/* 1119 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1120 */         .addNextBehavior(
/* 1121 */           CECombatBehaviors.Behavior.builder()
/* 1122 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1123 */           .withinDistance(0.0D, 5.0D)
/* 1124 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1125 */           .addNextBehavior(
/* 1126 */             CECombatBehaviors.Behavior.builder()
/* 1127 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1128 */             .withinDistance(0.0D, 5.0D)
/* 1129 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1130 */             .addNextBehavior(
/* 1131 */               CECombatBehaviors.Behavior.builder()
/* 1132 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1133 */               .withinDistance(0.0D, 6.0D)
/* 1134 */               .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1135 */               .addNextBehavior(
/* 1136 */                 CECombatBehaviors.Behavior.builder()
/* 1137 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1138 */                 .withinDistance(0.0D, 6.0D)
/* 1139 */                 .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1145 */       .addFirstBehavior(
/* 1146 */         CECombatBehaviors.Behavior.builder()
/* 1147 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1148 */         .withinDistance(0.0D, 3.0D)
/* 1149 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1150 */         .addNextBehavior(
/* 1151 */           CECombatBehaviors.Behavior.builder()
/* 1152 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1153 */           .withinDistance(0.0D, 4.0D)
/* 1154 */           .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/* 1155 */           .addNextBehavior(
/* 1156 */             CECombatBehaviors.Behavior.builder()
/* 1157 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1158 */             .withinDistance(0.0D, 5.0D)
/* 1159 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1160 */             .addNextBehavior(
/* 1161 */               CECombatBehaviors.Behavior.builder()
/* 1162 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1163 */               .withinDistance(0.0D, 5.0D)
/* 1164 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1165 */               .addNextBehavior(
/* 1166 */                 CECombatBehaviors.Behavior.builder()
/* 1167 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1168 */                 .withinDistance(0.0D, 6.0D)
/* 1169 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1176 */       .addFirstBehavior(
/* 1177 */         CECombatBehaviors.Behavior.builder()
/* 1178 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1179 */         .withinDistance(0.0D, 3.0D)
/* 1180 */         .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1181 */         .addNextBehavior(
/* 1182 */           CECombatBehaviors.Behavior.builder()
/* 1183 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1184 */           .withinDistance(0.0D, 4.0D)
/* 1185 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/* 1186 */           .addNextBehavior(
/* 1187 */             CECombatBehaviors.Behavior.builder()
/* 1188 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1189 */             .withinDistance(0.0D, 5.0D)
/* 1190 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1191 */             .addNextBehavior(
/* 1192 */               CECombatBehaviors.Behavior.builder()
/* 1193 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1194 */               .withinDistance(0.0D, 5.0D)
/* 1195 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1196 */               .addNextBehavior(
/* 1197 */                 CECombatBehaviors.Behavior.builder()
/* 1198 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1199 */                 .withinDistance(0.0D, 6.0D)
/* 1200 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1207 */       .addFirstBehavior(
/* 1208 */         CECombatBehaviors.Behavior.builder()
/* 1209 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1210 */         .withinDistance(0.0D, 3.0D)
/* 1211 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/* 1212 */         .addNextBehavior(
/* 1213 */           CECombatBehaviors.Behavior.builder()
/* 1214 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1215 */           .withinDistance(0.0D, 4.0D)
/* 1216 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1217 */           .addNextBehavior(
/* 1218 */             CECombatBehaviors.Behavior.builder()
/* 1219 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1220 */             .withinDistance(0.0D, 5.0D)
/* 1221 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1222 */             .addNextBehavior(
/* 1223 */               CECombatBehaviors.Behavior.builder()
/* 1224 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1225 */               .withinDistance(0.0D, 5.0D)
/* 1226 */               .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/* 1227 */               .addNextBehavior(
/* 1228 */                 CECombatBehaviors.Behavior.builder()
/* 1229 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1230 */                 .withinDistance(0.0D, 6.0D)
/* 1231 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1238 */       .addFirstBehavior(
/* 1239 */         CECombatBehaviors.Behavior.builder()
/* 1240 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1241 */         .withinDistance(0.0D, 3.0D)
/* 1242 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1243 */         .addNextBehavior(
/* 1244 */           CECombatBehaviors.Behavior.builder()
/* 1245 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1246 */           .withinDistance(0.0D, 4.0D)
/* 1247 */           .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1248 */           .addNextBehavior(
/* 1249 */             CECombatBehaviors.Behavior.builder()
/* 1250 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1251 */             .withinDistance(0.0D, 5.0D)
/* 1252 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1253 */             .addNextBehavior(
/* 1254 */               CECombatBehaviors.Behavior.builder()
/* 1255 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1256 */               .withinDistance(0.0D, 5.0D)
/* 1257 */               .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/* 1258 */               .addNextBehavior(
/* 1259 */                 CECombatBehaviors.Behavior.builder()
/* 1260 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1261 */                 .withinDistance(0.0D, 6.0D)
/* 1262 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1269 */       .addFirstBehavior(
/* 1270 */         CECombatBehaviors.Behavior.builder()
/* 1271 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1272 */         .withinDistance(0.0D, 3.0D)
/* 1273 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1274 */         .addNextBehavior(
/* 1275 */           CECombatBehaviors.Behavior.builder()
/* 1276 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1277 */           .withinDistance(0.0D, 4.0D)
/* 1278 */           .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/* 1279 */           .addNextBehavior(
/* 1280 */             CECombatBehaviors.Behavior.builder()
/* 1281 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1282 */             .withinDistance(0.0D, 5.0D)
/* 1283 */             .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1284 */             .addNextBehavior(
/* 1285 */               CECombatBehaviors.Behavior.builder()
/* 1286 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1287 */               .withinDistance(0.0D, 5.0D)
/* 1288 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1289 */               .addNextBehavior(
/* 1290 */                 CECombatBehaviors.Behavior.builder()
/* 1291 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1292 */                 .withinDistance(0.0D, 6.0D)
/* 1293 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1302 */       .addFirstBehavior(
/* 1303 */         CECombatBehaviors.Behavior.builder()
/* 1304 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1305 */         .withinDistance(0.0D, 3.0D)
/* 1306 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1307 */         .addNextBehavior(
/* 1308 */           CECombatBehaviors.Behavior.builder()
/* 1309 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1310 */           .withinDistance(0.0D, 4.0D)
/* 1311 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/* 1312 */           .addNextBehavior(
/* 1313 */             CECombatBehaviors.Behavior.builder()
/* 1314 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1315 */             .withinDistance(0.0D, 5.0D)
/* 1316 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1317 */             .addNextBehavior(
/* 1318 */               CECombatBehaviors.Behavior.builder()
/* 1319 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1320 */               .withinDistance(0.0D, 5.0D)
/* 1321 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1322 */               .addNextBehavior(
/* 1323 */                 CECombatBehaviors.Behavior.builder()
/* 1324 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1325 */                 .withinDistance(0.0D, 6.0D)
/* 1326 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1333 */       .addFirstBehavior(
/* 1334 */         CECombatBehaviors.Behavior.builder()
/* 1335 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1336 */         .withinDistance(0.0D, 3.0D)
/* 1337 */         .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1338 */         .addNextBehavior(
/* 1339 */           CECombatBehaviors.Behavior.builder()
/* 1340 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1341 */           .withinDistance(0.0D, 4.0D)
/* 1342 */           .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 1343 */           .addNextBehavior(
/* 1344 */             CECombatBehaviors.Behavior.builder()
/* 1345 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1346 */             .withinDistance(0.0D, 5.0D)
/* 1347 */             .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/* 1348 */             .addNextBehavior(
/* 1349 */               CECombatBehaviors.Behavior.builder()
/* 1350 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1351 */               .withinDistance(0.0D, 5.0D)
/* 1352 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1353 */               .addNextBehavior(
/* 1354 */                 CECombatBehaviors.Behavior.builder()
/* 1355 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1356 */                 .withinDistance(0.0D, 6.0D)
/* 1357 */                 .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1364 */       .addFirstBehavior(
/* 1365 */         CECombatBehaviors.Behavior.builder()
/* 1366 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1367 */         .withinDistance(0.0D, 3.0D)
/* 1368 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1369 */         .addNextBehavior(
/* 1370 */           CECombatBehaviors.Behavior.builder()
/* 1371 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1372 */           .withinDistance(0.0D, 4.0D)
/* 1373 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1374 */           .addNextBehavior(
/* 1375 */             CECombatBehaviors.Behavior.builder()
/* 1376 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1377 */             .withinDistance(0.0D, 5.0D)
/* 1378 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1379 */             .addNextBehavior(
/* 1380 */               CECombatBehaviors.Behavior.builder()
/* 1381 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1382 */               .withinDistance(0.0D, 5.0D)
/* 1383 */               .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/* 1384 */               .addNextBehavior(
/* 1385 */                 CECombatBehaviors.Behavior.builder()
/* 1386 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1387 */                 .withinDistance(0.0D, 6.0D)
/* 1388 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1395 */       .addFirstBehavior(
/* 1396 */         CECombatBehaviors.Behavior.builder()
/* 1397 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1398 */         .withinDistance(0.0D, 3.0D)
/* 1399 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1400 */         .addNextBehavior(
/* 1401 */           CECombatBehaviors.Behavior.builder()
/* 1402 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1403 */           .withinDistance(0.0D, 4.0D)
/* 1404 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1405 */           .addNextBehavior(
/* 1406 */             CECombatBehaviors.Behavior.builder()
/* 1407 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1408 */             .withinDistance(0.0D, 5.0D)
/* 1409 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1410 */             .addNextBehavior(
/* 1411 */               CECombatBehaviors.Behavior.builder()
/* 1412 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1413 */               .withinDistance(0.0D, 5.0D)
/* 1414 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1415 */               .addNextBehavior(
/* 1416 */                 CECombatBehaviors.Behavior.builder()
/* 1417 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1418 */                 .withinDistance(0.0D, 6.0D)
/* 1419 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1425 */       .addFirstBehavior(
/* 1426 */         CECombatBehaviors.Behavior.builder()
/* 1427 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1428 */         .withinDistance(0.0D, 3.0D)
/* 1429 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/* 1430 */         .addNextBehavior(
/* 1431 */           CECombatBehaviors.Behavior.builder()
/* 1432 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1433 */           .withinDistance(0.0D, 4.0D)
/* 1434 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/* 1435 */           .addNextBehavior(
/* 1436 */             CECombatBehaviors.Behavior.builder()
/* 1437 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1438 */             .withinDistance(0.0D, 5.0D)
/* 1439 */             .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1440 */             .addNextBehavior(
/* 1441 */               CECombatBehaviors.Behavior.builder()
/* 1442 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1443 */               .withinDistance(0.0D, 5.0D)
/* 1444 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1445 */               .addNextBehavior(
/* 1446 */                 CECombatBehaviors.Behavior.builder()
/* 1447 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1448 */                 .withinDistance(0.0D, 6.0D)
/* 1449 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1456 */       .addFirstBehavior(
/* 1457 */         CECombatBehaviors.Behavior.builder()
/* 1458 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1459 */         .withinDistance(0.0D, 3.0D)
/* 1460 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1461 */         .addNextBehavior(
/* 1462 */           CECombatBehaviors.Behavior.builder()
/* 1463 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1464 */           .withinDistance(0.0D, 4.0D)
/* 1465 */           .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/* 1466 */           .addNextBehavior(
/* 1467 */             CECombatBehaviors.Behavior.builder()
/* 1468 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1469 */             .withinDistance(0.0D, 5.0D)
/* 1470 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1471 */             .addNextBehavior(
/* 1472 */               CECombatBehaviors.Behavior.builder()
/* 1473 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1474 */               .withinDistance(0.0D, 5.0D)
/* 1475 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1476 */               .addNextBehavior(
/* 1477 */                 CECombatBehaviors.Behavior.builder()
/* 1478 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1479 */                 .withinDistance(0.0D, 6.0D)
/* 1480 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1487 */       .addFirstBehavior(
/* 1488 */         CECombatBehaviors.Behavior.builder()
/* 1489 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1490 */         .withinDistance(0.0D, 3.0D)
/* 1491 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1492 */         .addNextBehavior(
/* 1493 */           CECombatBehaviors.Behavior.builder()
/* 1494 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1495 */           .withinDistance(0.0D, 4.0D)
/* 1496 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/* 1497 */           .addNextBehavior(
/* 1498 */             CECombatBehaviors.Behavior.builder()
/* 1499 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1500 */             .withinDistance(0.0D, 5.0D)
/* 1501 */             .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/* 1502 */             .addNextBehavior(
/* 1503 */               CECombatBehaviors.Behavior.builder()
/* 1504 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1505 */               .withinDistance(0.0D, 5.0D)
/* 1506 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1507 */               .addNextBehavior(
/* 1508 */                 CECombatBehaviors.Behavior.builder()
/* 1509 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1510 */                 .withinDistance(0.0D, 6.0D)
/* 1511 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1518 */       .addFirstBehavior(
/* 1519 */         CECombatBehaviors.Behavior.builder()
/* 1520 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1521 */         .withinDistance(0.0D, 3.0D)
/* 1522 */         .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1523 */         .addNextBehavior(
/* 1524 */           CECombatBehaviors.Behavior.builder()
/* 1525 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1526 */           .withinDistance(0.0D, 4.0D)
/* 1527 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1528 */           .addNextBehavior(
/* 1529 */             CECombatBehaviors.Behavior.builder()
/* 1530 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1531 */             .withinDistance(0.0D, 5.0D)
/* 1532 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1533 */             .addNextBehavior(
/* 1534 */               CECombatBehaviors.Behavior.builder()
/* 1535 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1536 */               .withinDistance(0.0D, 5.0D)
/* 1537 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1538 */               .addNextBehavior(
/* 1539 */                 CECombatBehaviors.Behavior.builder()
/* 1540 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1541 */                 .withinDistance(0.0D, 6.0D)
/* 1542 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1549 */       .addFirstBehavior(
/* 1550 */         CECombatBehaviors.Behavior.builder()
/* 1551 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1552 */         .withinDistance(0.0D, 3.0D)
/* 1553 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1554 */         .addNextBehavior(
/* 1555 */           CECombatBehaviors.Behavior.builder()
/* 1556 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1557 */           .withinDistance(0.0D, 4.0D)
/* 1558 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/* 1559 */           .addNextBehavior(
/* 1560 */             CECombatBehaviors.Behavior.builder()
/* 1561 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1562 */             .withinDistance(0.0D, 5.0D)
/* 1563 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1564 */             .addNextBehavior(
/* 1565 */               CECombatBehaviors.Behavior.builder()
/* 1566 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1567 */               .withinDistance(0.0D, 5.0D)
/* 1568 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1569 */               .addNextBehavior(
/* 1570 */                 CECombatBehaviors.Behavior.builder()
/* 1571 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1572 */                 .withinDistance(0.0D, 6.0D)
/* 1573 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1579 */       .addFirstBehavior(
/* 1580 */         CECombatBehaviors.Behavior.builder()
/* 1581 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1582 */         .withinDistance(0.0D, 3.0D)
/* 1583 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/* 1584 */         .addNextBehavior(
/* 1585 */           CECombatBehaviors.Behavior.builder()
/* 1586 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1587 */           .withinDistance(0.0D, 4.0D)
/* 1588 */           .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)
/* 1589 */           .addNextBehavior(
/* 1590 */             CECombatBehaviors.Behavior.builder()
/* 1591 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1592 */             .withinDistance(0.0D, 5.0D)
/* 1593 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1594 */             .addNextBehavior(
/* 1595 */               CECombatBehaviors.Behavior.builder()
/* 1596 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1597 */               .withinDistance(0.0D, 5.0D)
/* 1598 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1599 */               .addNextBehavior(
/* 1600 */                 CECombatBehaviors.Behavior.builder()
/* 1601 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1602 */                 .withinDistance(0.0D, 6.0D)
/* 1603 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1610 */       .addFirstBehavior(
/* 1611 */         CECombatBehaviors.Behavior.builder()
/* 1612 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1613 */         .withinDistance(0.0D, 3.0D)
/* 1614 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1615 */         .addNextBehavior(
/* 1616 */           CECombatBehaviors.Behavior.builder()
/* 1617 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1618 */           .withinDistance(0.0D, 4.0D)
/* 1619 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1620 */           .addNextBehavior(
/* 1621 */             CECombatBehaviors.Behavior.builder()
/* 1622 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1623 */             .withinDistance(0.0D, 5.0D)
/* 1624 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1625 */             .addNextBehavior(
/* 1626 */               CECombatBehaviors.Behavior.builder()
/* 1627 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1628 */               .withinDistance(0.0D, 5.0D)
/* 1629 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1630 */               .addNextBehavior(
/* 1631 */                 CECombatBehaviors.Behavior.builder()
/* 1632 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1633 */                 .withinDistance(0.0D, 6.0D)
/* 1634 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1641 */       .addFirstBehavior(
/* 1642 */         CECombatBehaviors.Behavior.builder()
/* 1643 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1644 */         .withinDistance(0.0D, 3.0D)
/* 1645 */         .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1646 */         .addNextBehavior(
/* 1647 */           CECombatBehaviors.Behavior.builder()
/* 1648 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1649 */           .withinDistance(0.0D, 4.0D)
/* 1650 */           .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1651 */           .addNextBehavior(
/* 1652 */             CECombatBehaviors.Behavior.builder()
/* 1653 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1654 */             .withinDistance(0.0D, 5.0D)
/* 1655 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1656 */             .addNextBehavior(
/* 1657 */               CECombatBehaviors.Behavior.builder()
/* 1658 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1659 */               .withinDistance(0.0D, 5.0D)
/* 1660 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1661 */               .addNextBehavior(
/* 1662 */                 CECombatBehaviors.Behavior.builder()
/* 1663 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1664 */                 .withinDistance(0.0D, 6.0D)
/* 1665 */                 .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1672 */       .addFirstBehavior(
/* 1673 */         CECombatBehaviors.Behavior.builder()
/* 1674 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1675 */         .withinDistance(0.0D, 3.0D)
/* 1676 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1677 */         .addNextBehavior(
/* 1678 */           CECombatBehaviors.Behavior.builder()
/* 1679 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1680 */           .withinDistance(0.0D, 4.0D)
/* 1681 */           .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1682 */           .addNextBehavior(
/* 1683 */             CECombatBehaviors.Behavior.builder()
/* 1684 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1685 */             .withinDistance(0.0D, 5.0D)
/* 1686 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1687 */             .addNextBehavior(
/* 1688 */               CECombatBehaviors.Behavior.builder()
/* 1689 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1690 */               .withinDistance(0.0D, 5.0D)
/* 1691 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1692 */               .addNextBehavior(
/* 1693 */                 CECombatBehaviors.Behavior.builder()
/* 1694 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1695 */                 .withinDistance(0.0D, 6.0D)
/* 1696 */                 .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1703 */       .addFirstBehavior(
/* 1704 */         CECombatBehaviors.Behavior.builder()
/* 1705 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1706 */         .withinDistance(0.0D, 3.0D)
/* 1707 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1708 */         .addNextBehavior(
/* 1709 */           CECombatBehaviors.Behavior.builder()
/* 1710 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1711 */           .withinDistance(0.0D, 4.0D)
/* 1712 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1713 */           .addNextBehavior(
/* 1714 */             CECombatBehaviors.Behavior.builder()
/* 1715 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1716 */             .withinDistance(0.0D, 5.0D)
/* 1717 */             .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1718 */             .addNextBehavior(
/* 1719 */               CECombatBehaviors.Behavior.builder()
/* 1720 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1721 */               .withinDistance(0.0D, 5.0D)
/* 1722 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1723 */               .addNextBehavior(
/* 1724 */                 CECombatBehaviors.Behavior.builder()
/* 1725 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1726 */                 .withinDistance(0.0D, 6.0D)
/* 1727 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1733 */       .addFirstBehavior(
/* 1734 */         CECombatBehaviors.Behavior.builder()
/* 1735 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1736 */         .withinDistance(0.0D, 3.0D)
/* 1737 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1738 */         .addNextBehavior(
/* 1739 */           CECombatBehaviors.Behavior.builder()
/* 1740 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1741 */           .withinDistance(0.0D, 4.0D)
/* 1742 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/* 1743 */           .addNextBehavior(
/* 1744 */             CECombatBehaviors.Behavior.builder()
/* 1745 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1746 */             .withinDistance(0.0D, 5.0D)
/* 1747 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1748 */             .addNextBehavior(
/* 1749 */               CECombatBehaviors.Behavior.builder()
/* 1750 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1751 */               .withinDistance(0.0D, 5.0D)
/* 1752 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/* 1753 */               .addNextBehavior(
/* 1754 */                 CECombatBehaviors.Behavior.builder()
/* 1755 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1756 */                 .withinDistance(0.0D, 6.0D)
/* 1757 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1764 */       .addFirstBehavior(
/* 1765 */         CECombatBehaviors.Behavior.builder()
/* 1766 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1767 */         .withinDistance(0.0D, 3.0D)
/* 1768 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F)
/* 1769 */         .addNextBehavior(
/* 1770 */           CECombatBehaviors.Behavior.builder()
/* 1771 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1772 */           .withinDistance(0.0D, 4.0D)
/* 1773 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/* 1774 */           .addNextBehavior(
/* 1775 */             CECombatBehaviors.Behavior.builder()
/* 1776 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1777 */             .withinDistance(0.0D, 5.0D)
/* 1778 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, 0.0F)
/* 1779 */             .addNextBehavior(
/* 1780 */               CECombatBehaviors.Behavior.builder()
/* 1781 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1782 */               .withinDistance(0.0D, 5.0D)
/* 1783 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/* 1784 */               .addNextBehavior(
/* 1785 */                 CECombatBehaviors.Behavior.builder()
/* 1786 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1787 */                 .withinDistance(0.0D, 6.0D)
/* 1788 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1795 */       .addFirstBehavior(
/* 1796 */         CECombatBehaviors.Behavior.builder()
/* 1797 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1798 */         .withinDistance(0.0D, 3.0D)
/* 1799 */         .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1800 */         .addNextBehavior(
/* 1801 */           CECombatBehaviors.Behavior.builder()
/* 1802 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1803 */           .withinDistance(0.0D, 4.0D)
/* 1804 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1805 */           .addNextBehavior(
/* 1806 */             CECombatBehaviors.Behavior.builder()
/* 1807 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1808 */             .withinDistance(0.0D, 5.0D)
/* 1809 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/* 1810 */             .addNextBehavior(
/* 1811 */               CECombatBehaviors.Behavior.builder()
/* 1812 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1813 */               .withinDistance(0.0D, 5.0D)
/* 1814 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/* 1815 */               .addNextBehavior(
/* 1816 */                 CECombatBehaviors.Behavior.builder()
/* 1817 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1818 */                 .withinDistance(0.0D, 6.0D)
/* 1819 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1826 */       .addFirstBehavior(
/* 1827 */         CECombatBehaviors.Behavior.builder()
/* 1828 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1829 */         .withinDistance(0.0D, 3.0D)
/* 1830 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, 0.0F)
/* 1831 */         .addNextBehavior(
/* 1832 */           CECombatBehaviors.Behavior.builder()
/* 1833 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1834 */           .withinDistance(0.0D, 4.0D)
/* 1835 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1836 */           .addNextBehavior(
/* 1837 */             CECombatBehaviors.Behavior.builder()
/* 1838 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1839 */             .withinDistance(0.0D, 5.0D)
/* 1840 */             .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, 0.0F)
/* 1841 */             .addNextBehavior(
/* 1842 */               CECombatBehaviors.Behavior.builder()
/* 1843 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1844 */               .withinDistance(0.0D, 5.0D)
/* 1845 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/* 1846 */               .addNextBehavior(
/* 1847 */                 CECombatBehaviors.Behavior.builder()
/* 1848 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1849 */                 .withinDistance(0.0D, 6.0D)
/* 1850 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1857 */     .newBehaviorRoot(
/* 1858 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1859 */       .priority(1.0D)
/* 1860 */       .weight(30.0D)
/* 1861 */       .maxCooldown(100)
/* 1862 */       .addFirstBehavior(
/* 1863 */         CECombatBehaviors.Behavior.builder()
/* 1864 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1865 */         .withinDistance(0.0D, 5.0D)
/* 1866 */         .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))
/*      */       
/* 1868 */       .addFirstBehavior(
/* 1869 */         CECombatBehaviors.Behavior.builder()
/* 1870 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1871 */         .withinDistance(0.0D, 10.0D)
/* 1872 */         .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))
/*      */       
/* 1874 */       .addFirstBehavior(
/* 1875 */         CECombatBehaviors.Behavior.builder()
/* 1876 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1877 */         .withinDistance(0.0D, 5.0D)
/* 1878 */         .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F)))
/*      */ 
/*      */     
/* 1881 */     .newBehaviorRoot(
/* 1882 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1883 */       .priority(1.0D)
/* 1884 */       .weight(20.0D)
/* 1885 */       .maxCooldown(200)
/* 1886 */       .addFirstBehavior(
/* 1887 */         CECombatBehaviors.Behavior.builder()
/* 1888 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1889 */         .withinDistance(0.0D, 5.0D)
/* 1890 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE_PILLAR, 0.0F))
/*      */       
/* 1892 */       .addFirstBehavior(
/* 1893 */         CECombatBehaviors.Behavior.builder()
/* 1894 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1895 */         .withinDistance(0.0D, 5.0D)
/* 1896 */         .animationBehavior(AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F))
/*      */       
/* 1898 */       .addFirstBehavior(
/* 1899 */         CECombatBehaviors.Behavior.builder()
/* 1900 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1901 */         .custom(HerobrineCommon::canShootDarkOb)
/* 1902 */         .withinDistance(5.0D, 10.0D)
/* 1903 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1904 */         .addExBehavior(HerobrineCommon::performShootDarkOb)))
/*      */ 
/*      */     
/* 1907 */     .newBehaviorRoot(
/* 1908 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1909 */       .priority(1.0D)
/* 1910 */       .weight(15.0D)
/* 1911 */       .maxCooldown(200)
/* 1912 */       .addFirstBehavior(
/* 1913 */         CECombatBehaviors.Behavior.builder()
/* 1914 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1915 */         .custom(HerobrineCommon::canPlayObsidianMachine)
/* 1916 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1917 */         .addExBehavior(HerobrineCommon::performObsidianMachine)))
/*      */ 
/*      */     
/* 1920 */     .newBehaviorRoot(
/* 1921 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1922 */       .priority(1.0D)
/* 1923 */       .weight(2.0D)
/* 1924 */       .maxCooldown(100)
/* 1925 */       .addFirstBehavior(
/* 1926 */         CECombatBehaviors.Behavior.builder()
/* 1927 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1928 */         .withinDistance(0.0D, 5.0D)
/* 1929 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1931 */       .addFirstBehavior(
/* 1932 */         CECombatBehaviors.Behavior.builder()
/* 1933 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1934 */         .withinDistance(0.0D, 5.0D)
/* 1935 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1937 */       .addFirstBehavior(
/* 1938 */         CECombatBehaviors.Behavior.builder()
/* 1939 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1940 */         .withinDistance(0.0D, 5.0D)
/* 1941 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1943 */       .addFirstBehavior(
/* 1944 */         CECombatBehaviors.Behavior.builder()
/* 1945 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1946 */         .withinDistance(0.0D, 5.0D)
/* 1947 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F)))
/*      */ 
/*      */     
/* 1950 */     .newBehaviorRoot(
/* 1951 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1952 */       .priority(1.0D)
/* 1953 */       .weight(15.0D)
/* 1954 */       .addFirstBehavior(
/* 1955 */         CECombatBehaviors.Behavior.builder()
/* 1956 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1957 */         .withinDistance(0.0D, 3.0D)
/* 1958 */         .custom(HerobrineCommon::canPerformGuarding)
/* 1959 */         .guard(40)))
/*      */ 
/*      */     
/* 1962 */     .newBehaviorRoot(
/* 1963 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1964 */       .priority(1.0D)
/* 1965 */       .weight(10.0D)
/* 1966 */       .addFirstBehavior(
/* 1967 */         CECombatBehaviors.Behavior.builder()
/* 1968 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1969 */         .withinDistance(0.0D, 5.0D)
/* 1970 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1972 */       .addFirstBehavior(
/* 1973 */         CECombatBehaviors.Behavior.builder()
/* 1974 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1975 */         .withinDistance(0.0D, 5.0D)
/* 1976 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))
/*      */       
/* 1978 */       .addFirstBehavior(
/* 1979 */         CECombatBehaviors.Behavior.builder()
/* 1980 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1981 */         .withinDistance(0.0D, 5.0D)
/* 1982 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1984 */       .addFirstBehavior(
/* 1985 */         CECombatBehaviors.Behavior.builder()
/* 1986 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1987 */         .withinDistance(0.0D, 5.0D)
/* 1988 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1990 */       .addFirstBehavior(
/* 1991 */         CECombatBehaviors.Behavior.builder()
/* 1992 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1993 */         .withinDistance(0.0D, 5.0D)
/* 1994 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1996 */       .addFirstBehavior(
/* 1997 */         CECombatBehaviors.Behavior.builder()
/* 1998 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1999 */         .withinDistance(0.0D, 5.0D)
/* 2000 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 2003 */     .newBehaviorRoot(
/* 2004 */       CECombatBehaviors.BehaviorRoot.builder()
/* 2005 */       .priority(1.0D)
/* 2006 */       .weight(20.0D)
/* 2007 */       .maxCooldown(160)
/* 2008 */       .addFirstBehavior(
/* 2009 */         CECombatBehaviors.Behavior.builder()
/* 2010 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 2011 */         .custom(HerobrineCommon::canJump)
/* 2012 */         .withinDistance(5.0D, 14.0D)
/* 2013 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 2014 */         .addExBehavior(HerobrineCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineShadowObsidianPillar.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */