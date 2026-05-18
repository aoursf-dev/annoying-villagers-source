/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class BlueDemonTrident
/*      */ {
/*   15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> TRIDENT = CECombatBehaviors.builder()
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
/*   39 */         .addExBehavior(CombatCommon::performEscapeRunAway))
/*      */       
/*   41 */       .addFirstBehavior(
/*   42 */         CECombatBehaviors.Behavior.builder()
/*   43 */         .custom(CombatCommon::canEscape)
/*   44 */         .withinDistance(0.0D, 8.0D)
/*   45 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   46 */         .addExBehavior(CombatCommon::performEscapeRunAway))
/*      */       
/*   48 */       .addFirstBehavior(
/*   49 */         CECombatBehaviors.Behavior.builder()
/*   50 */         .custom(CombatCommon::canEscape)
/*   51 */         .withinDistance(0.0D, 48.0D)
/*   52 */         .guard(40)))
/*      */ 
/*      */     
/*   55 */     .newBehaviorRoot(
/*   56 */       CECombatBehaviors.BehaviorRoot.builder()
/*   57 */       .priority(3.0D)
/*   58 */       .weight(100.0D)
/*   59 */       .maxCooldown(120)
/*   60 */       .addFirstBehavior(
/*   61 */         CECombatBehaviors.Behavior.builder()
/*   62 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   63 */         .custom(CombatCommon::canSwitchWeapon)
/*   64 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   65 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   67 */       .addFirstBehavior(
/*   68 */         CECombatBehaviors.Behavior.builder()
/*   69 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   70 */         .custom(CombatCommon::canSwitchWeapon)
/*   71 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*   72 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   74 */       .addFirstBehavior(
/*   75 */         CECombatBehaviors.Behavior.builder()
/*   76 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   77 */         .custom(CombatCommon::canSwitchWeapon)
/*   78 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   79 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   81 */       .addFirstBehavior(
/*   82 */         CECombatBehaviors.Behavior.builder()
/*   83 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   84 */         .custom(CombatCommon::canSwitchWeapon)
/*   85 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*   86 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   88 */       .addFirstBehavior(
/*   89 */         CECombatBehaviors.Behavior.builder()
/*   90 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   91 */         .custom(CombatCommon::canSwitchWeapon)
/*   92 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*   93 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   95 */       .addFirstBehavior(
/*   96 */         CECombatBehaviors.Behavior.builder()
/*   97 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   98 */         .custom(CombatCommon::canSwitchWeapon)
/*   99 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  100 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*  103 */     .newBehaviorRoot(
/*  104 */       CECombatBehaviors.BehaviorRoot.builder()
/*  105 */       .priority(2.0D)
/*  106 */       .weight(70.0D)
/*  107 */       .maxCooldown(0)
/*  108 */       .addFirstBehavior(
/*  109 */         CECombatBehaviors.Behavior.builder()
/*  110 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  111 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  112 */         .custom(CombatCommon::canBlueDemonPerformHealing)
/*  113 */         .animationBehavior(AVAnimations.CUT_ANTITHEUS_ASCENSION, 0.0F)
/*  114 */         .addExBehavior(CombatCommon::performBlueDemonHealing)))
/*      */ 
/*      */     
/*  117 */     .newBehaviorRoot(
/*  118 */       CECombatBehaviors.BehaviorRoot.builder()
/*  119 */       .priority(1.0D)
/*  120 */       .weight(40.0D)
/*  121 */       .maxCooldown(20)
/*  122 */       .addFirstBehavior(
/*  123 */         CECombatBehaviors.Behavior.builder()
/*  124 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  125 */         .withinDistance(0.0D, 3.0D)
/*  126 */         .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)
/*  127 */         .addNextBehavior(
/*  128 */           CECombatBehaviors.Behavior.builder()
/*  129 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  130 */           .withinDistance(0.0D, 4.0D)
/*  131 */           .animationBehavior(AVAnimations.TRIDENT_DUAL_AUTO2, 0.0F)
/*  132 */           .addNextBehavior(
/*  133 */             CECombatBehaviors.Behavior.builder()
/*  134 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  135 */             .withinDistance(0.0D, 4.0D)
/*  136 */             .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  137 */             .addNextBehavior(
/*  138 */               CECombatBehaviors.Behavior.builder()
/*  139 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  140 */               .withinDistance(0.0D, 4.0D)
/*  141 */               .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)
/*  142 */               .addNextBehavior(
/*  143 */                 CECombatBehaviors.Behavior.builder()
/*  144 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  145 */                 .withinDistance(0.0D, 5.0D)
/*  146 */                 .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/*  147 */                 .addNextBehavior(
/*  148 */                   CECombatBehaviors.Behavior.builder()
/*  149 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  150 */                   .withinDistance(0.0D, 5.0D)
/*  151 */                   .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  158 */       .addFirstBehavior(
/*  159 */         CECombatBehaviors.Behavior.builder()
/*  160 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  161 */         .withinDistance(0.0D, 3.0D)
/*  162 */         .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)
/*  163 */         .addNextBehavior(
/*  164 */           CECombatBehaviors.Behavior.builder()
/*  165 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  166 */           .withinDistance(0.0D, 4.0D)
/*  167 */           .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)
/*  168 */           .addNextBehavior(
/*  169 */             CECombatBehaviors.Behavior.builder()
/*  170 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  171 */             .withinDistance(0.0D, 5.0D)
/*  172 */             .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_1, 0.0F)
/*  173 */             .addNextBehavior(
/*  174 */               CECombatBehaviors.Behavior.builder()
/*  175 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  176 */               .withinDistance(0.0D, 5.0D)
/*  177 */               .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/*  178 */               .addNextBehavior(
/*  179 */                 CECombatBehaviors.Behavior.builder()
/*  180 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  181 */                 .withinDistance(0.0D, 6.0D)
/*  182 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  189 */       .addFirstBehavior(
/*  190 */         CECombatBehaviors.Behavior.builder()
/*  191 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  192 */         .withinDistance(0.0D, 3.0D)
/*  193 */         .animationBehavior(AVAnimations.TRIDENT_DUAL_AUTO2, 0.0F)
/*  194 */         .addNextBehavior(
/*  195 */           CECombatBehaviors.Behavior.builder()
/*  196 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  197 */           .withinDistance(0.0D, 4.0D)
/*  198 */           .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/*  199 */           .addNextBehavior(
/*  200 */             CECombatBehaviors.Behavior.builder()
/*  201 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  202 */             .withinDistance(0.0D, 5.0D)
/*  203 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  204 */             .addNextBehavior(
/*  205 */               CECombatBehaviors.Behavior.builder()
/*  206 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  207 */               .withinDistance(0.0D, 5.0D)
/*  208 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  209 */               .addNextBehavior(
/*  210 */                 CECombatBehaviors.Behavior.builder()
/*  211 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  212 */                 .withinDistance(0.0D, 6.0D)
/*  213 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/*  224 */         .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  225 */         .addNextBehavior(
/*  226 */           CECombatBehaviors.Behavior.builder()
/*  227 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  228 */           .withinDistance(0.0D, 4.0D)
/*  229 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  230 */           .addNextBehavior(
/*  231 */             CECombatBehaviors.Behavior.builder()
/*  232 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  233 */             .withinDistance(0.0D, 5.0D)
/*  234 */             .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F)
/*  235 */             .addNextBehavior(
/*  236 */               CECombatBehaviors.Behavior.builder()
/*  237 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  238 */               .withinDistance(0.0D, 5.0D)
/*  239 */               .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F)
/*  240 */               .addNextBehavior(
/*  241 */                 CECombatBehaviors.Behavior.builder()
/*  242 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  243 */                 .withinDistance(0.0D, 6.0D)
/*  244 */                 .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  251 */       .addFirstBehavior(
/*  252 */         CECombatBehaviors.Behavior.builder()
/*  253 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  254 */         .withinDistance(0.0D, 3.0D)
/*  255 */         .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)
/*  256 */         .addNextBehavior(
/*  257 */           CECombatBehaviors.Behavior.builder()
/*  258 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  259 */           .withinDistance(0.0D, 4.0D)
/*  260 */           .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)
/*  261 */           .addNextBehavior(
/*  262 */             CECombatBehaviors.Behavior.builder()
/*  263 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  264 */             .withinDistance(0.0D, 5.0D)
/*  265 */             .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)
/*  266 */             .addNextBehavior(
/*  267 */               CECombatBehaviors.Behavior.builder()
/*  268 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  269 */               .withinDistance(0.0D, 5.0D)
/*  270 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  271 */               .addNextBehavior(
/*  272 */                 CECombatBehaviors.Behavior.builder()
/*  273 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  274 */                 .withinDistance(0.0D, 6.0D)
/*  275 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  282 */       .addFirstBehavior(
/*  283 */         CECombatBehaviors.Behavior.builder()
/*  284 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  285 */         .withinDistance(0.0D, 3.0D)
/*  286 */         .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/*  287 */         .addNextBehavior(
/*  288 */           CECombatBehaviors.Behavior.builder()
/*  289 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  290 */           .withinDistance(0.0D, 4.0D)
/*  291 */           .animationBehavior(AVAnimations.TRIDENT_THROW_5, 0.0F)
/*  292 */           .addNextBehavior(
/*  293 */             CECombatBehaviors.Behavior.builder()
/*  294 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  295 */             .withinDistance(0.0D, 5.0D)
/*  296 */             .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_1, 0.0F)
/*  297 */             .addNextBehavior(
/*  298 */               CECombatBehaviors.Behavior.builder()
/*  299 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  300 */               .withinDistance(0.0D, 5.0D)
/*  301 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  302 */               .addNextBehavior(
/*  303 */                 CECombatBehaviors.Behavior.builder()
/*  304 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  305 */                 .withinDistance(0.0D, 6.0D)
/*  306 */                 .animationBehavior(AVAnimations.TRIDENT_DUAL_AUTO2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  315 */       .addFirstBehavior(
/*  316 */         CECombatBehaviors.Behavior.builder()
/*  317 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  318 */         .withinDistance(0.0D, 3.0D)
/*  319 */         .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)
/*  320 */         .addNextBehavior(
/*  321 */           CECombatBehaviors.Behavior.builder()
/*  322 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  323 */           .withinDistance(0.0D, 4.0D)
/*  324 */           .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/*  325 */           .addNextBehavior(
/*  326 */             CECombatBehaviors.Behavior.builder()
/*  327 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  328 */             .withinDistance(0.0D, 5.0D)
/*  329 */             .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F)
/*  330 */             .addNextBehavior(
/*  331 */               CECombatBehaviors.Behavior.builder()
/*  332 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  333 */               .withinDistance(0.0D, 5.0D)
/*  334 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  335 */               .addNextBehavior(
/*  336 */                 CECombatBehaviors.Behavior.builder()
/*  337 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  338 */                 .withinDistance(0.0D, 6.0D)
/*  339 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  346 */       .addFirstBehavior(
/*  347 */         CECombatBehaviors.Behavior.builder()
/*  348 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  349 */         .withinDistance(0.0D, 3.0D)
/*  350 */         .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  351 */         .addNextBehavior(
/*  352 */           CECombatBehaviors.Behavior.builder()
/*  353 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  354 */           .withinDistance(0.0D, 4.0D)
/*  355 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  356 */           .addNextBehavior(
/*  357 */             CECombatBehaviors.Behavior.builder()
/*  358 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  359 */             .withinDistance(0.0D, 5.0D)
/*  360 */             .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)
/*  361 */             .addNextBehavior(
/*  362 */               CECombatBehaviors.Behavior.builder()
/*  363 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  364 */               .withinDistance(0.0D, 5.0D)
/*  365 */               .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  366 */               .addNextBehavior(
/*  367 */                 CECombatBehaviors.Behavior.builder()
/*  368 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  369 */                 .withinDistance(0.0D, 6.0D)
/*  370 */                 .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  377 */       .addFirstBehavior(
/*  378 */         CECombatBehaviors.Behavior.builder()
/*  379 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  380 */         .withinDistance(0.0D, 3.0D)
/*  381 */         .animationBehavior(AVAnimations.TRIDENT_DUAL_AUTO2, 0.0F)
/*  382 */         .addNextBehavior(
/*  383 */           CECombatBehaviors.Behavior.builder()
/*  384 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  385 */           .withinDistance(0.0D, 4.0D)
/*  386 */           .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)
/*  387 */           .addNextBehavior(
/*  388 */             CECombatBehaviors.Behavior.builder()
/*  389 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  390 */             .withinDistance(0.0D, 5.0D)
/*  391 */             .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)
/*  392 */             .addNextBehavior(
/*  393 */               CECombatBehaviors.Behavior.builder()
/*  394 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  395 */               .withinDistance(0.0D, 5.0D)
/*  396 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  397 */               .addNextBehavior(
/*  398 */                 CECombatBehaviors.Behavior.builder()
/*  399 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  400 */                 .withinDistance(0.0D, 6.0D)
/*  401 */                 .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  408 */       .addFirstBehavior(
/*  409 */         CECombatBehaviors.Behavior.builder()
/*  410 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  411 */         .withinDistance(0.0D, 3.0D)
/*  412 */         .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  413 */         .addNextBehavior(
/*  414 */           CECombatBehaviors.Behavior.builder()
/*  415 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  416 */           .withinDistance(0.0D, 4.0D)
/*  417 */           .animationBehavior(AVAnimations.TRIDENT_THROW_5, 0.0F)
/*  418 */           .addNextBehavior(
/*  419 */             CECombatBehaviors.Behavior.builder()
/*  420 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  421 */             .withinDistance(0.0D, 5.0D)
/*  422 */             .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)
/*  423 */             .addNextBehavior(
/*  424 */               CECombatBehaviors.Behavior.builder()
/*  425 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  426 */               .withinDistance(0.0D, 5.0D)
/*  427 */               .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)
/*  428 */               .addNextBehavior(
/*  429 */                 CECombatBehaviors.Behavior.builder()
/*  430 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  431 */                 .withinDistance(0.0D, 6.0D)
/*  432 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  441 */       .addFirstBehavior(
/*  442 */         CECombatBehaviors.Behavior.builder()
/*  443 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  444 */         .withinDistance(0.0D, 3.0D)
/*  445 */         .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)
/*  446 */         .addNextBehavior(
/*  447 */           CECombatBehaviors.Behavior.builder()
/*  448 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  449 */           .withinDistance(0.0D, 4.0D)
/*  450 */           .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)
/*  451 */           .addNextBehavior(
/*  452 */             CECombatBehaviors.Behavior.builder()
/*  453 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  454 */             .withinDistance(0.0D, 5.0D)
/*  455 */             .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)
/*  456 */             .addNextBehavior(
/*  457 */               CECombatBehaviors.Behavior.builder()
/*  458 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  459 */               .withinDistance(0.0D, 5.0D)
/*  460 */               .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_1, 0.0F)
/*  461 */               .addNextBehavior(
/*  462 */                 CECombatBehaviors.Behavior.builder()
/*  463 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  464 */                 .withinDistance(0.0D, 6.0D)
/*  465 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  472 */       .addFirstBehavior(
/*  473 */         CECombatBehaviors.Behavior.builder()
/*  474 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  475 */         .withinDistance(0.0D, 3.0D)
/*  476 */         .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/*  477 */         .addNextBehavior(
/*  478 */           CECombatBehaviors.Behavior.builder()
/*  479 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  480 */           .withinDistance(0.0D, 4.0D)
/*  481 */           .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/*  482 */           .addNextBehavior(
/*  483 */             CECombatBehaviors.Behavior.builder()
/*  484 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  485 */             .withinDistance(0.0D, 5.0D)
/*  486 */             .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F)
/*  487 */             .addNextBehavior(
/*  488 */               CECombatBehaviors.Behavior.builder()
/*  489 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  490 */               .withinDistance(0.0D, 5.0D)
/*  491 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  492 */               .addNextBehavior(
/*  493 */                 CECombatBehaviors.Behavior.builder()
/*  494 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  495 */                 .withinDistance(0.0D, 6.0D)
/*  496 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  503 */       .addFirstBehavior(
/*  504 */         CECombatBehaviors.Behavior.builder()
/*  505 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  506 */         .withinDistance(0.0D, 3.0D)
/*  507 */         .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  508 */         .addNextBehavior(
/*  509 */           CECombatBehaviors.Behavior.builder()
/*  510 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  511 */           .withinDistance(0.0D, 4.0D)
/*  512 */           .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F)
/*  513 */           .addNextBehavior(
/*  514 */             CECombatBehaviors.Behavior.builder()
/*  515 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  516 */             .withinDistance(0.0D, 5.0D)
/*  517 */             .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)
/*  518 */             .addNextBehavior(
/*  519 */               CECombatBehaviors.Behavior.builder()
/*  520 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  521 */               .withinDistance(0.0D, 5.0D)
/*  522 */               .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)
/*  523 */               .addNextBehavior(
/*  524 */                 CECombatBehaviors.Behavior.builder()
/*  525 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  526 */                 .withinDistance(0.0D, 6.0D)
/*  527 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  534 */       .addFirstBehavior(
/*  535 */         CECombatBehaviors.Behavior.builder()
/*  536 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  537 */         .withinDistance(0.0D, 3.0D)
/*  538 */         .animationBehavior(AVAnimations.TRIDENT_DUAL_AUTO2, 0.0F)
/*  539 */         .addNextBehavior(
/*  540 */           CECombatBehaviors.Behavior.builder()
/*  541 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  542 */           .withinDistance(0.0D, 4.0D)
/*  543 */           .animationBehavior(AVAnimations.TRIDENT_THROW_5, 0.0F)
/*  544 */           .addNextBehavior(
/*  545 */             CECombatBehaviors.Behavior.builder()
/*  546 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  547 */             .withinDistance(0.0D, 5.0D)
/*  548 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  549 */             .addNextBehavior(
/*  550 */               CECombatBehaviors.Behavior.builder()
/*  551 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  552 */               .withinDistance(0.0D, 5.0D)
/*  553 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  554 */               .addNextBehavior(
/*  555 */                 CECombatBehaviors.Behavior.builder()
/*  556 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  557 */                 .withinDistance(0.0D, 6.0D)
/*  558 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  565 */       .addFirstBehavior(
/*  566 */         CECombatBehaviors.Behavior.builder()
/*  567 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  568 */         .withinDistance(0.0D, 3.0D)
/*  569 */         .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)
/*  570 */         .addNextBehavior(
/*  571 */           CECombatBehaviors.Behavior.builder()
/*  572 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  573 */           .withinDistance(0.0D, 4.0D)
/*  574 */           .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)
/*  575 */           .addNextBehavior(
/*  576 */             CECombatBehaviors.Behavior.builder()
/*  577 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  578 */             .withinDistance(0.0D, 5.0D)
/*  579 */             .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/*  580 */             .addNextBehavior(
/*  581 */               CECombatBehaviors.Behavior.builder()
/*  582 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  583 */               .withinDistance(0.0D, 5.0D)
/*  584 */               .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/*  585 */               .addNextBehavior(
/*  586 */                 CECombatBehaviors.Behavior.builder()
/*  587 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  588 */                 .withinDistance(0.0D, 6.0D)
/*  589 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  598 */       .addFirstBehavior(
/*  599 */         CECombatBehaviors.Behavior.builder()
/*  600 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  601 */         .withinDistance(0.0D, 3.0D)
/*  602 */         .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)
/*  603 */         .addNextBehavior(
/*  604 */           CECombatBehaviors.Behavior.builder()
/*  605 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  606 */           .withinDistance(0.0D, 4.0D)
/*  607 */           .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)
/*  608 */           .addNextBehavior(
/*  609 */             CECombatBehaviors.Behavior.builder()
/*  610 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  611 */             .withinDistance(0.0D, 5.0D)
/*  612 */             .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F)
/*  613 */             .addNextBehavior(
/*  614 */               CECombatBehaviors.Behavior.builder()
/*  615 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  616 */               .withinDistance(0.0D, 5.0D)
/*  617 */               .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)
/*  618 */               .addNextBehavior(
/*  619 */                 CECombatBehaviors.Behavior.builder()
/*  620 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  621 */                 .withinDistance(0.0D, 6.0D)
/*  622 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  629 */       .addFirstBehavior(
/*  630 */         CECombatBehaviors.Behavior.builder()
/*  631 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  632 */         .withinDistance(0.0D, 3.0D)
/*  633 */         .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  634 */         .addNextBehavior(
/*  635 */           CECombatBehaviors.Behavior.builder()
/*  636 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  637 */           .withinDistance(0.0D, 4.0D)
/*  638 */           .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)
/*  639 */           .addNextBehavior(
/*  640 */             CECombatBehaviors.Behavior.builder()
/*  641 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  642 */             .withinDistance(0.0D, 5.0D)
/*  643 */             .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_1, 0.0F)
/*  644 */             .addNextBehavior(
/*  645 */               CECombatBehaviors.Behavior.builder()
/*  646 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  647 */               .withinDistance(0.0D, 5.0D)
/*  648 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  649 */               .addNextBehavior(
/*  650 */                 CECombatBehaviors.Behavior.builder()
/*  651 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  652 */                 .withinDistance(0.0D, 6.0D)
/*  653 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  660 */       .addFirstBehavior(
/*  661 */         CECombatBehaviors.Behavior.builder()
/*  662 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  663 */         .withinDistance(0.0D, 3.0D)
/*  664 */         .animationBehavior(AVAnimations.TRIDENT_DUAL_AUTO2, 0.0F)
/*  665 */         .addNextBehavior(
/*  666 */           CECombatBehaviors.Behavior.builder()
/*  667 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  668 */           .withinDistance(0.0D, 4.0D)
/*  669 */           .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/*  670 */           .addNextBehavior(
/*  671 */             CECombatBehaviors.Behavior.builder()
/*  672 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  673 */             .withinDistance(0.0D, 5.0D)
/*  674 */             .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F)
/*  675 */             .addNextBehavior(
/*  676 */               CECombatBehaviors.Behavior.builder()
/*  677 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  678 */               .withinDistance(0.0D, 5.0D)
/*  679 */               .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/*  680 */               .addNextBehavior(
/*  681 */                 CECombatBehaviors.Behavior.builder()
/*  682 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  683 */                 .withinDistance(0.0D, 6.0D)
/*  684 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  691 */       .addFirstBehavior(
/*  692 */         CECombatBehaviors.Behavior.builder()
/*  693 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  694 */         .withinDistance(0.0D, 3.0D)
/*  695 */         .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  696 */         .addNextBehavior(
/*  697 */           CECombatBehaviors.Behavior.builder()
/*  698 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  699 */           .withinDistance(0.0D, 4.0D)
/*  700 */           .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  701 */           .addNextBehavior(
/*  702 */             CECombatBehaviors.Behavior.builder()
/*  703 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  704 */             .withinDistance(0.0D, 5.0D)
/*  705 */             .animationBehavior(AVAnimations.TRIDENT_THROW_5, 0.0F)
/*  706 */             .addNextBehavior(
/*  707 */               CECombatBehaviors.Behavior.builder()
/*  708 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  709 */               .withinDistance(0.0D, 5.0D)
/*  710 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  711 */               .addNextBehavior(
/*  712 */                 CECombatBehaviors.Behavior.builder()
/*  713 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  714 */                 .withinDistance(0.0D, 6.0D)
/*  715 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  722 */       .addFirstBehavior(
/*  723 */         CECombatBehaviors.Behavior.builder()
/*  724 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  725 */         .withinDistance(0.0D, 3.0D)
/*  726 */         .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)
/*  727 */         .addNextBehavior(
/*  728 */           CECombatBehaviors.Behavior.builder()
/*  729 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  730 */           .withinDistance(0.0D, 4.0D)
/*  731 */           .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)
/*  732 */           .addNextBehavior(
/*  733 */             CECombatBehaviors.Behavior.builder()
/*  734 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  735 */             .withinDistance(0.0D, 5.0D)
/*  736 */             .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/*  737 */             .addNextBehavior(
/*  738 */               CECombatBehaviors.Behavior.builder()
/*  739 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  740 */               .withinDistance(0.0D, 5.0D)
/*  741 */               .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)
/*  742 */               .addNextBehavior(
/*  743 */                 CECombatBehaviors.Behavior.builder()
/*  744 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  745 */                 .withinDistance(0.0D, 6.0D)
/*  746 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  755 */       .addFirstBehavior(
/*  756 */         CECombatBehaviors.Behavior.builder()
/*  757 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  758 */         .withinDistance(0.0D, 3.0D)
/*  759 */         .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)
/*  760 */         .addNextBehavior(
/*  761 */           CECombatBehaviors.Behavior.builder()
/*  762 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  763 */           .withinDistance(0.0D, 4.0D)
/*  764 */           .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F)
/*  765 */           .addNextBehavior(
/*  766 */             CECombatBehaviors.Behavior.builder()
/*  767 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  768 */             .withinDistance(0.0D, 5.0D)
/*  769 */             .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F)
/*  770 */             .addNextBehavior(
/*  771 */               CECombatBehaviors.Behavior.builder()
/*  772 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  773 */               .withinDistance(0.0D, 5.0D)
/*  774 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  775 */               .addNextBehavior(
/*  776 */                 CECombatBehaviors.Behavior.builder()
/*  777 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  778 */                 .withinDistance(0.0D, 6.0D)
/*  779 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  786 */       .addFirstBehavior(
/*  787 */         CECombatBehaviors.Behavior.builder()
/*  788 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  789 */         .withinDistance(0.0D, 3.0D)
/*  790 */         .animationBehavior(AVAnimations.TRIDENT_DUAL_AUTO2, 0.0F)
/*  791 */         .addNextBehavior(
/*  792 */           CECombatBehaviors.Behavior.builder()
/*  793 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  794 */           .withinDistance(0.0D, 4.0D)
/*  795 */           .animationBehavior(AVAnimations.TRIDENT_THROW_5, 0.0F)
/*  796 */           .addNextBehavior(
/*  797 */             CECombatBehaviors.Behavior.builder()
/*  798 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  799 */             .withinDistance(0.0D, 5.0D)
/*  800 */             .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_1, 0.0F)
/*  801 */             .addNextBehavior(
/*  802 */               CECombatBehaviors.Behavior.builder()
/*  803 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  804 */               .withinDistance(0.0D, 5.0D)
/*  805 */               .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/*  806 */               .addNextBehavior(
/*  807 */                 CECombatBehaviors.Behavior.builder()
/*  808 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  809 */                 .withinDistance(0.0D, 6.0D)
/*  810 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  817 */       .addFirstBehavior(
/*  818 */         CECombatBehaviors.Behavior.builder()
/*  819 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  820 */         .withinDistance(0.0D, 3.0D)
/*  821 */         .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  822 */         .addNextBehavior(
/*  823 */           CECombatBehaviors.Behavior.builder()
/*  824 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  825 */           .withinDistance(0.0D, 4.0D)
/*  826 */           .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)
/*  827 */           .addNextBehavior(
/*  828 */             CECombatBehaviors.Behavior.builder()
/*  829 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  830 */             .withinDistance(0.0D, 5.0D)
/*  831 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  832 */             .addNextBehavior(
/*  833 */               CECombatBehaviors.Behavior.builder()
/*  834 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  835 */               .withinDistance(0.0D, 5.0D)
/*  836 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  837 */               .addNextBehavior(
/*  838 */                 CECombatBehaviors.Behavior.builder()
/*  839 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  840 */                 .withinDistance(0.0D, 6.0D)
/*  841 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  848 */       .addFirstBehavior(
/*  849 */         CECombatBehaviors.Behavior.builder()
/*  850 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  851 */         .withinDistance(0.0D, 3.0D)
/*  852 */         .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/*  853 */         .addNextBehavior(
/*  854 */           CECombatBehaviors.Behavior.builder()
/*  855 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  856 */           .withinDistance(0.0D, 4.0D)
/*  857 */           .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/*  858 */           .addNextBehavior(
/*  859 */             CECombatBehaviors.Behavior.builder()
/*  860 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  861 */             .withinDistance(0.0D, 5.0D)
/*  862 */             .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F)
/*  863 */             .addNextBehavior(
/*  864 */               CECombatBehaviors.Behavior.builder()
/*  865 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  866 */               .withinDistance(0.0D, 5.0D)
/*  867 */               .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)
/*  868 */               .addNextBehavior(
/*  869 */                 CECombatBehaviors.Behavior.builder()
/*  870 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  871 */                 .withinDistance(0.0D, 6.0D)
/*  872 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  879 */       .addFirstBehavior(
/*  880 */         CECombatBehaviors.Behavior.builder()
/*  881 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  882 */         .withinDistance(0.0D, 3.0D)
/*  883 */         .animationBehavior(AVAnimations.TRIDENT_DUAL_AUTO2, 0.0F)
/*  884 */         .addNextBehavior(
/*  885 */           CECombatBehaviors.Behavior.builder()
/*  886 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  887 */           .withinDistance(0.0D, 4.0D)
/*  888 */           .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)
/*  889 */           .addNextBehavior(
/*  890 */             CECombatBehaviors.Behavior.builder()
/*  891 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  892 */             .withinDistance(0.0D, 5.0D)
/*  893 */             .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F)
/*  894 */             .addNextBehavior(
/*  895 */               CECombatBehaviors.Behavior.builder()
/*  896 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  897 */               .withinDistance(0.0D, 5.0D)
/*  898 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/*  899 */               .addNextBehavior(
/*  900 */                 CECombatBehaviors.Behavior.builder()
/*  901 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  902 */                 .withinDistance(0.0D, 6.0D)
/*  903 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  910 */       .addFirstBehavior(
/*  911 */         CECombatBehaviors.Behavior.builder()
/*  912 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  913 */         .withinDistance(0.0D, 3.0D)
/*  914 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  915 */         .addNextBehavior(
/*  916 */           CECombatBehaviors.Behavior.builder()
/*  917 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  918 */           .withinDistance(0.0D, 4.0D)
/*  919 */           .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)
/*  920 */           .addNextBehavior(
/*  921 */             CECombatBehaviors.Behavior.builder()
/*  922 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  923 */             .withinDistance(0.0D, 5.0D)
/*  924 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  925 */             .addNextBehavior(
/*  926 */               CECombatBehaviors.Behavior.builder()
/*  927 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  928 */               .withinDistance(0.0D, 5.0D)
/*  929 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  930 */               .addNextBehavior(
/*  931 */                 CECombatBehaviors.Behavior.builder()
/*  932 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  933 */                 .withinDistance(0.0D, 6.0D)
/*  934 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  935 */                 .addNextBehavior(
/*  936 */                   CECombatBehaviors.Behavior.builder()
/*  937 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  938 */                   .withinDistance(0.0D, 6.0D)
/*  939 */                   .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  947 */       .addFirstBehavior(
/*  948 */         CECombatBehaviors.Behavior.builder()
/*  949 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  950 */         .withinDistance(0.0D, 3.0D)
/*  951 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  952 */         .addNextBehavior(
/*  953 */           CECombatBehaviors.Behavior.builder()
/*  954 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  955 */           .withinDistance(0.0D, 4.0D)
/*  956 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  957 */           .addNextBehavior(
/*  958 */             CECombatBehaviors.Behavior.builder()
/*  959 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  960 */             .withinDistance(0.0D, 5.0D)
/*  961 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  962 */             .addNextBehavior(
/*  963 */               CECombatBehaviors.Behavior.builder()
/*  964 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  965 */               .withinDistance(0.0D, 5.0D)
/*  966 */               .animationBehavior(AVAnimations.DUAL_SWORD_AUTO2, 0.0F)
/*  967 */               .addNextBehavior(
/*  968 */                 CECombatBehaviors.Behavior.builder()
/*  969 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  970 */                 .withinDistance(0.0D, 6.0D)
/*  971 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  972 */                 .addNextBehavior(
/*  973 */                   CECombatBehaviors.Behavior.builder()
/*  974 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  975 */                   .withinDistance(0.0D, 6.0D)
/*  976 */                   .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  984 */       .addFirstBehavior(
/*  985 */         CECombatBehaviors.Behavior.builder()
/*  986 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  987 */         .withinDistance(0.0D, 3.0D)
/*  988 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  989 */         .addNextBehavior(
/*  990 */           CECombatBehaviors.Behavior.builder()
/*  991 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  992 */           .withinDistance(0.0D, 4.0D)
/*  993 */           .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/*  994 */           .addNextBehavior(
/*  995 */             CECombatBehaviors.Behavior.builder()
/*  996 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  997 */             .withinDistance(0.0D, 5.0D)
/*  998 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/*  999 */             .addNextBehavior(
/* 1000 */               CECombatBehaviors.Behavior.builder()
/* 1001 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1002 */               .withinDistance(0.0D, 5.0D)
/* 1003 */               .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1004 */               .addNextBehavior(
/* 1005 */                 CECombatBehaviors.Behavior.builder()
/* 1006 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1007 */                 .withinDistance(0.0D, 6.0D)
/* 1008 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1009 */                 .addNextBehavior(
/* 1010 */                   CECombatBehaviors.Behavior.builder()
/* 1011 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1012 */                   .withinDistance(0.0D, 6.0D)
/* 1013 */                   .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1021 */       .addFirstBehavior(
/* 1022 */         CECombatBehaviors.Behavior.builder()
/* 1023 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1024 */         .withinDistance(0.0D, 3.0D)
/* 1025 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1026 */         .addNextBehavior(
/* 1027 */           CECombatBehaviors.Behavior.builder()
/* 1028 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1029 */           .withinDistance(0.0D, 4.0D)
/* 1030 */           .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 1031 */           .addNextBehavior(
/* 1032 */             CECombatBehaviors.Behavior.builder()
/* 1033 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1034 */             .withinDistance(0.0D, 5.0D)
/* 1035 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1036 */             .addNextBehavior(
/* 1037 */               CECombatBehaviors.Behavior.builder()
/* 1038 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1039 */               .withinDistance(0.0D, 5.0D)
/* 1040 */               .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/* 1041 */               .addNextBehavior(
/* 1042 */                 CECombatBehaviors.Behavior.builder()
/* 1043 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1044 */                 .withinDistance(0.0D, 6.0D)
/* 1045 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1046 */                 .addNextBehavior(
/* 1047 */                   CECombatBehaviors.Behavior.builder()
/* 1048 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1049 */                   .withinDistance(0.0D, 6.0D)
/* 1050 */                   .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1058 */       .addFirstBehavior(
/* 1059 */         CECombatBehaviors.Behavior.builder()
/* 1060 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1061 */         .withinDistance(0.0D, 3.0D)
/* 1062 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1063 */         .addNextBehavior(
/* 1064 */           CECombatBehaviors.Behavior.builder()
/* 1065 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1066 */           .withinDistance(0.0D, 4.0D)
/* 1067 */           .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F)
/* 1068 */           .addNextBehavior(
/* 1069 */             CECombatBehaviors.Behavior.builder()
/* 1070 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1071 */             .withinDistance(0.0D, 5.0D)
/* 1072 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1073 */             .addNextBehavior(
/* 1074 */               CECombatBehaviors.Behavior.builder()
/* 1075 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1076 */               .withinDistance(0.0D, 5.0D)
/* 1077 */               .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1078 */               .addNextBehavior(
/* 1079 */                 CECombatBehaviors.Behavior.builder()
/* 1080 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1081 */                 .withinDistance(0.0D, 6.0D)
/* 1082 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1083 */                 .addNextBehavior(
/* 1084 */                   CECombatBehaviors.Behavior.builder()
/* 1085 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1086 */                   .withinDistance(0.0D, 6.0D)
/* 1087 */                   .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1095 */       .addFirstBehavior(
/* 1096 */         CECombatBehaviors.Behavior.builder()
/* 1097 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1098 */         .withinDistance(0.0D, 3.0D)
/* 1099 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1100 */         .addNextBehavior(
/* 1101 */           CECombatBehaviors.Behavior.builder()
/* 1102 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1103 */           .withinDistance(0.0D, 4.0D)
/* 1104 */           .animationBehavior(AVAnimations.TRIDENT_THROW_5, 0.0F)
/* 1105 */           .addNextBehavior(
/* 1106 */             CECombatBehaviors.Behavior.builder()
/* 1107 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1108 */             .withinDistance(0.0D, 5.0D)
/* 1109 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1110 */             .addNextBehavior(
/* 1111 */               CECombatBehaviors.Behavior.builder()
/* 1112 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1113 */               .withinDistance(0.0D, 5.0D)
/* 1114 */               .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F)
/* 1115 */               .addNextBehavior(
/* 1116 */                 CECombatBehaviors.Behavior.builder()
/* 1117 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1118 */                 .withinDistance(0.0D, 6.0D)
/* 1119 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1120 */                 .addNextBehavior(
/* 1121 */                   CECombatBehaviors.Behavior.builder()
/* 1122 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1123 */                   .withinDistance(0.0D, 6.0D)
/* 1124 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1132 */       .addFirstBehavior(
/* 1133 */         CECombatBehaviors.Behavior.builder()
/* 1134 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1135 */         .withinDistance(0.0D, 3.0D)
/* 1136 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1137 */         .addNextBehavior(
/* 1138 */           CECombatBehaviors.Behavior.builder()
/* 1139 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1140 */           .withinDistance(0.0D, 4.0D)
/* 1141 */           .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_1, 0.0F)
/* 1142 */           .addNextBehavior(
/* 1143 */             CECombatBehaviors.Behavior.builder()
/* 1144 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1145 */             .withinDistance(0.0D, 5.0D)
/* 1146 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1147 */             .addNextBehavior(
/* 1148 */               CECombatBehaviors.Behavior.builder()
/* 1149 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1150 */               .withinDistance(0.0D, 5.0D)
/* 1151 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 1152 */               .addNextBehavior(
/* 1153 */                 CECombatBehaviors.Behavior.builder()
/* 1154 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1155 */                 .withinDistance(0.0D, 6.0D)
/* 1156 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1157 */                 .addNextBehavior(
/* 1158 */                   CECombatBehaviors.Behavior.builder()
/* 1159 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1160 */                   .withinDistance(0.0D, 6.0D)
/* 1161 */                   .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1169 */       .addFirstBehavior(
/* 1170 */         CECombatBehaviors.Behavior.builder()
/* 1171 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1172 */         .withinDistance(0.0D, 3.0D)
/* 1173 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1174 */         .addNextBehavior(
/* 1175 */           CECombatBehaviors.Behavior.builder()
/* 1176 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1177 */           .withinDistance(0.0D, 4.0D)
/* 1178 */           .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F)
/* 1179 */           .addNextBehavior(
/* 1180 */             CECombatBehaviors.Behavior.builder()
/* 1181 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1182 */             .withinDistance(0.0D, 5.0D)
/* 1183 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1184 */             .addNextBehavior(
/* 1185 */               CECombatBehaviors.Behavior.builder()
/* 1186 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1187 */               .withinDistance(0.0D, 5.0D)
/* 1188 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1189 */               .addNextBehavior(
/* 1190 */                 CECombatBehaviors.Behavior.builder()
/* 1191 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1192 */                 .withinDistance(0.0D, 6.0D)
/* 1193 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1194 */                 .addNextBehavior(
/* 1195 */                   CECombatBehaviors.Behavior.builder()
/* 1196 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1197 */                   .withinDistance(0.0D, 6.0D)
/* 1198 */                   .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1206 */       .addFirstBehavior(
/* 1207 */         CECombatBehaviors.Behavior.builder()
/* 1208 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1209 */         .withinDistance(0.0D, 3.0D)
/* 1210 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1211 */         .addNextBehavior(
/* 1212 */           CECombatBehaviors.Behavior.builder()
/* 1213 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1214 */           .withinDistance(0.0D, 4.0D)
/* 1215 */           .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F)
/* 1216 */           .addNextBehavior(
/* 1217 */             CECombatBehaviors.Behavior.builder()
/* 1218 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1219 */             .withinDistance(0.0D, 5.0D)
/* 1220 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1221 */             .addNextBehavior(
/* 1222 */               CECombatBehaviors.Behavior.builder()
/* 1223 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1224 */               .withinDistance(0.0D, 5.0D)
/* 1225 */               .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/* 1226 */               .addNextBehavior(
/* 1227 */                 CECombatBehaviors.Behavior.builder()
/* 1228 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1229 */                 .withinDistance(0.0D, 6.0D)
/* 1230 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1231 */                 .addNextBehavior(
/* 1232 */                   CECombatBehaviors.Behavior.builder()
/* 1233 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1234 */                   .withinDistance(0.0D, 6.0D)
/* 1235 */                   .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))))))
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
/* 1247 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1248 */         .addNextBehavior(
/* 1249 */           CECombatBehaviors.Behavior.builder()
/* 1250 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1251 */           .withinDistance(0.0D, 4.0D)
/* 1252 */           .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1253 */           .addNextBehavior(
/* 1254 */             CECombatBehaviors.Behavior.builder()
/* 1255 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1256 */             .withinDistance(0.0D, 5.0D)
/* 1257 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1258 */             .addNextBehavior(
/* 1259 */               CECombatBehaviors.Behavior.builder()
/* 1260 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1261 */               .withinDistance(0.0D, 5.0D)
/* 1262 */               .animationBehavior(AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, 0.0F)
/* 1263 */               .addNextBehavior(
/* 1264 */                 CECombatBehaviors.Behavior.builder()
/* 1265 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1266 */                 .withinDistance(0.0D, 6.0D)
/* 1267 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1268 */                 .addNextBehavior(
/* 1269 */                   CECombatBehaviors.Behavior.builder()
/* 1270 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1271 */                   .withinDistance(0.0D, 6.0D)
/* 1272 */                   .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1280 */       .addFirstBehavior(
/* 1281 */         CECombatBehaviors.Behavior.builder()
/* 1282 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1283 */         .withinDistance(0.0D, 3.0D)
/* 1284 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1285 */         .addNextBehavior(
/* 1286 */           CECombatBehaviors.Behavior.builder()
/* 1287 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1288 */           .withinDistance(0.0D, 4.0D)
/* 1289 */           .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F)
/* 1290 */           .addNextBehavior(
/* 1291 */             CECombatBehaviors.Behavior.builder()
/* 1292 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1293 */             .withinDistance(0.0D, 5.0D)
/* 1294 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1295 */             .addNextBehavior(
/* 1296 */               CECombatBehaviors.Behavior.builder()
/* 1297 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1298 */               .withinDistance(0.0D, 5.0D)
/* 1299 */               .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/* 1300 */               .addNextBehavior(
/* 1301 */                 CECombatBehaviors.Behavior.builder()
/* 1302 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1303 */                 .withinDistance(0.0D, 6.0D)
/* 1304 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1305 */                 .addNextBehavior(
/* 1306 */                   CECombatBehaviors.Behavior.builder()
/* 1307 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1308 */                   .withinDistance(0.0D, 6.0D)
/* 1309 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
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
/* 1321 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1322 */         .addNextBehavior(
/* 1323 */           CECombatBehaviors.Behavior.builder()
/* 1324 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1325 */           .withinDistance(0.0D, 4.0D)
/* 1326 */           .animationBehavior(AVAnimations.DUAL_SWORD_AUTO2, 0.0F)
/* 1327 */           .addNextBehavior(
/* 1328 */             CECombatBehaviors.Behavior.builder()
/* 1329 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1330 */             .withinDistance(0.0D, 5.0D)
/* 1331 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1332 */             .addNextBehavior(
/* 1333 */               CECombatBehaviors.Behavior.builder()
/* 1334 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1335 */               .withinDistance(0.0D, 5.0D)
/* 1336 */               .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)
/* 1337 */               .addNextBehavior(
/* 1338 */                 CECombatBehaviors.Behavior.builder()
/* 1339 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1340 */                 .withinDistance(0.0D, 6.0D)
/* 1341 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1342 */                 .addNextBehavior(
/* 1343 */                   CECombatBehaviors.Behavior.builder()
/* 1344 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1345 */                   .withinDistance(0.0D, 6.0D)
/* 1346 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1354 */       .addFirstBehavior(
/* 1355 */         CECombatBehaviors.Behavior.builder()
/* 1356 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1357 */         .withinDistance(0.0D, 3.0D)
/* 1358 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1359 */         .addNextBehavior(
/* 1360 */           CECombatBehaviors.Behavior.builder()
/* 1361 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1362 */           .withinDistance(0.0D, 4.0D)
/* 1363 */           .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO3, 0.0F)
/* 1364 */           .addNextBehavior(
/* 1365 */             CECombatBehaviors.Behavior.builder()
/* 1366 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1367 */             .withinDistance(0.0D, 5.0D)
/* 1368 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1369 */             .addNextBehavior(
/* 1370 */               CECombatBehaviors.Behavior.builder()
/* 1371 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1372 */               .withinDistance(0.0D, 5.0D)
/* 1373 */               .animationBehavior(AVAnimations.TRIDENT_THROW_5, 0.0F)
/* 1374 */               .addNextBehavior(
/* 1375 */                 CECombatBehaviors.Behavior.builder()
/* 1376 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1377 */                 .withinDistance(0.0D, 6.0D)
/* 1378 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1379 */                 .addNextBehavior(
/* 1380 */                   CECombatBehaviors.Behavior.builder()
/* 1381 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1382 */                   .withinDistance(0.0D, 6.0D)
/* 1383 */                   .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1391 */       .addFirstBehavior(
/* 1392 */         CECombatBehaviors.Behavior.builder()
/* 1393 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1394 */         .withinDistance(0.0D, 3.0D)
/* 1395 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1396 */         .addNextBehavior(
/* 1397 */           CECombatBehaviors.Behavior.builder()
/* 1398 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1399 */           .withinDistance(0.0D, 4.0D)
/* 1400 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1401 */           .addNextBehavior(
/* 1402 */             CECombatBehaviors.Behavior.builder()
/* 1403 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1404 */             .withinDistance(0.0D, 5.0D)
/* 1405 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1406 */             .addNextBehavior(
/* 1407 */               CECombatBehaviors.Behavior.builder()
/* 1408 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1409 */               .withinDistance(0.0D, 5.0D)
/* 1410 */               .animationBehavior(AVAnimations.CUT_DP_AIR_ATTACK, 0.0F)
/* 1411 */               .addNextBehavior(
/* 1412 */                 CECombatBehaviors.Behavior.builder()
/* 1413 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1414 */                 .withinDistance(0.0D, 6.0D)
/* 1415 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1416 */                 .addNextBehavior(
/* 1417 */                   CECombatBehaviors.Behavior.builder()
/* 1418 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1419 */                   .withinDistance(0.0D, 6.0D)
/* 1420 */                   .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1428 */       .addFirstBehavior(
/* 1429 */         CECombatBehaviors.Behavior.builder()
/* 1430 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1431 */         .withinDistance(0.0D, 3.0D)
/* 1432 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1433 */         .addNextBehavior(
/* 1434 */           CECombatBehaviors.Behavior.builder()
/* 1435 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1436 */           .withinDistance(0.0D, 4.0D)
/* 1437 */           .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)
/* 1438 */           .addNextBehavior(
/* 1439 */             CECombatBehaviors.Behavior.builder()
/* 1440 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1441 */             .withinDistance(0.0D, 5.0D)
/* 1442 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1443 */             .addNextBehavior(
/* 1444 */               CECombatBehaviors.Behavior.builder()
/* 1445 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1446 */               .withinDistance(0.0D, 5.0D)
/* 1447 */               .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1448 */               .addNextBehavior(
/* 1449 */                 CECombatBehaviors.Behavior.builder()
/* 1450 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1451 */                 .withinDistance(0.0D, 6.0D)
/* 1452 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1453 */                 .addNextBehavior(
/* 1454 */                   CECombatBehaviors.Behavior.builder()
/* 1455 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1456 */                   .withinDistance(0.0D, 6.0D)
/* 1457 */                   .animationBehavior(AVAnimations.ADVANCED_LANCER_AUTO1, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1465 */       .addFirstBehavior(
/* 1466 */         CECombatBehaviors.Behavior.builder()
/* 1467 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1468 */         .withinDistance(0.0D, 3.0D)
/* 1469 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1470 */         .addNextBehavior(
/* 1471 */           CECombatBehaviors.Behavior.builder()
/* 1472 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1473 */           .withinDistance(0.0D, 4.0D)
/* 1474 */           .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)
/* 1475 */           .addNextBehavior(
/* 1476 */             CECombatBehaviors.Behavior.builder()
/* 1477 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1478 */             .withinDistance(0.0D, 5.0D)
/* 1479 */             .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1480 */             .addNextBehavior(
/* 1481 */               CECombatBehaviors.Behavior.builder()
/* 1482 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1483 */               .withinDistance(0.0D, 5.0D)
/* 1484 */               .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1485 */               .addNextBehavior(
/* 1486 */                 CECombatBehaviors.Behavior.builder()
/* 1487 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1488 */                 .withinDistance(0.0D, 6.0D)
/* 1489 */                 .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F)
/* 1490 */                 .addNextBehavior(
/* 1491 */                   CECombatBehaviors.Behavior.builder()
/* 1492 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1493 */                   .withinDistance(0.0D, 6.0D)
/* 1494 */                   .animationBehavior(AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1502 */     .newBehaviorRoot(
/* 1503 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1504 */       .priority(1.0D)
/* 1505 */       .weight(40.0D)
/* 1506 */       .maxCooldown(20)
/* 1507 */       .addFirstBehavior(
/* 1508 */         CECombatBehaviors.Behavior.builder()
/* 1509 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1510 */         .custom(CombatCommon::isTargetingHerobrineDragon)
/* 1511 */         .withinDistance(10.0D, 80.0D)
/* 1512 */         .animationBehavior(AVAnimations.TRIDENT_THROW_1, 0.0F)
/* 1513 */         .addNextBehavior(
/* 1514 */           CECombatBehaviors.Behavior.builder()
/* 1515 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1516 */           .custom(CombatCommon::isTargetingHerobrineDragon)
/* 1517 */           .withinDistance(10.0D, 80.0D)
/* 1518 */           .animationBehavior(AVAnimations.TRIDENT_THROW_2, 0.0F)
/* 1519 */           .addNextBehavior(
/* 1520 */             CECombatBehaviors.Behavior.builder()
/* 1521 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1522 */             .custom(CombatCommon::isTargetingHerobrineDragon)
/* 1523 */             .withinDistance(10.0D, 80.0D)
/* 1524 */             .animationBehavior(AVAnimations.TRIDENT_THROW_3, 0.0F)
/* 1525 */             .addNextBehavior(
/* 1526 */               CECombatBehaviors.Behavior.builder()
/* 1527 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1528 */               .custom(CombatCommon::isTargetingHerobrineDragon)
/* 1529 */               .withinDistance(10.0D, 80.0D)
/* 1530 */               .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F)
/* 1531 */               .addNextBehavior(
/* 1532 */                 CECombatBehaviors.Behavior.builder()
/* 1533 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1534 */                 .custom(CombatCommon::isTargetingHerobrineDragon)
/* 1535 */                 .withinDistance(10.0D, 80.0D)
/* 1536 */                 .animationBehavior(AVAnimations.TRIDENT_THROW_5, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1543 */     .newBehaviorRoot(
/* 1544 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1545 */       .priority(1.0D)
/* 1546 */       .weight(10.0D)
/* 1547 */       .maxCooldown(80)
/* 1548 */       .addFirstBehavior(
/* 1549 */         CECombatBehaviors.Behavior.builder()
/* 1550 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1551 */         .withinDistance(0.0D, 5.0D)
/* 1552 */         .animationBehavior(AVAnimations.NERF_TSUNAMI_REINFORCED, 0.0F))
/*      */       
/* 1554 */       .addFirstBehavior(
/* 1555 */         CECombatBehaviors.Behavior.builder()
/* 1556 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1557 */         .withinDistance(0.0D, 4.0D)
/* 1558 */         .animationBehavior(AVAnimations.CUT_HOOK_SPIN_SLASH_AIR, 0.0F))
/*      */       
/* 1560 */       .addFirstBehavior(
/* 1561 */         CECombatBehaviors.Behavior.builder()
/* 1562 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1563 */         .withinDistance(5.0D, 10.0D)
/* 1564 */         .animationBehavior(AVAnimations.DP_THROW_BLADE_AUTO_1, 0.0F))
/*      */       
/* 1566 */       .addFirstBehavior(
/* 1567 */         CECombatBehaviors.Behavior.builder()
/* 1568 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1569 */         .withinDistance(5.0D, 10.0D)
/* 1570 */         .animationBehavior(AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F)))
/*      */ 
/*      */     
/* 1573 */     .newBehaviorRoot(
/* 1574 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1575 */       .priority(1.0D)
/* 1576 */       .weight(10.0D)
/* 1577 */       .maxCooldown(600)
/* 1578 */       .addFirstBehavior(
/* 1579 */         CECombatBehaviors.Behavior.builder()
/* 1580 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1581 */         .withinDistance(0.0D, 10.0D)
/* 1582 */         .animationBehavior(AVAnimations.ELECTRIC_FIELD, 0.0F))
/*      */       
/* 1584 */       .addFirstBehavior(
/* 1585 */         CECombatBehaviors.Behavior.builder()
/* 1586 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1587 */         .custom(CombatCommon::canPerformTridentAttack)
/* 1588 */         .withinDistance(0.0D, 10.0D)
/* 1589 */         .animationBehavior(AVAnimations.TRIDENT_ATTACK, 0.0F)))
/*      */ 
/*      */     
/* 1592 */     .newBehaviorRoot(
/* 1593 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1594 */       .priority(1.0D)
/* 1595 */       .weight(15.0D)
/* 1596 */       .addFirstBehavior(
/* 1597 */         CECombatBehaviors.Behavior.builder()
/* 1598 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1599 */         .withinDistance(0.5D, 3.0D)
/* 1600 */         .custom(CombatCommon::canPerformGuarding)
/* 1601 */         .guard(40)))
/*      */ 
/*      */     
/* 1604 */     .newBehaviorRoot(
/* 1605 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1606 */       .priority(1.0D)
/* 1607 */       .weight(10.0D)
/* 1608 */       .addFirstBehavior(
/* 1609 */         CECombatBehaviors.Behavior.builder()
/* 1610 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1611 */         .withinDistance(0.0D, 3.0D)
/* 1612 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1614 */       .addFirstBehavior(
/* 1615 */         CECombatBehaviors.Behavior.builder()
/* 1616 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1617 */         .withinDistance(0.0D, 3.0D)
/* 1618 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1620 */       .addFirstBehavior(
/* 1621 */         CECombatBehaviors.Behavior.builder()
/* 1622 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1623 */         .withinDistance(0.0D, 3.0D)
/* 1624 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1626 */       .addFirstBehavior(
/* 1627 */         CECombatBehaviors.Behavior.builder()
/* 1628 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1629 */         .withinDistance(0.0D, 3.0D)
/* 1630 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))
/*      */       
/* 1632 */       .addFirstBehavior(
/* 1633 */         CECombatBehaviors.Behavior.builder()
/* 1634 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1635 */         .withinDistance(0.0D, 3.0D)
/* 1636 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1638 */       .addFirstBehavior(
/* 1639 */         CECombatBehaviors.Behavior.builder()
/* 1640 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1641 */         .withinDistance(0.0D, 3.0D)
/* 1642 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)))
/*      */ 
/*      */     
/* 1645 */     .newBehaviorRoot(
/* 1646 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1647 */       .priority(1.0D)
/* 1648 */       .weight(40.0D)
/* 1649 */       .maxCooldown(160)
/* 1650 */       .addFirstBehavior(
/* 1651 */         CECombatBehaviors.Behavior.builder()
/* 1652 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1653 */         .custom(CombatCommon::canJump)
/* 1654 */         .withinDistance(5.0D, 14.0D)
/* 1655 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1656 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\BlueDemonTrident.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */