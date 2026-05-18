/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HerobrineShadowObsidianSword
/*      */ {
/*   14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SHADOW_OBSIDIAN_SWORD = CECombatBehaviors.builder()
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
/*   97 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*   98 */         .addNextBehavior(
/*   99 */           CECombatBehaviors.Behavior.builder()
/*  100 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  101 */           .withinDistance(0.0D, 5.0D)
/*  102 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  103 */           .addNextBehavior(
/*  104 */             CECombatBehaviors.Behavior.builder()
/*  105 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  106 */             .withinDistance(0.0D, 5.0D)
/*  107 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  108 */             .addNextBehavior(
/*  109 */               CECombatBehaviors.Behavior.builder()
/*  110 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  111 */               .withinDistance(0.0D, 6.0D)
/*  112 */               .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  117 */       .addFirstBehavior(
/*  118 */         CECombatBehaviors.Behavior.builder()
/*  119 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  120 */         .withinDistance(0.0D, 3.0D)
/*  121 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  122 */         .addNextBehavior(
/*  123 */           CECombatBehaviors.Behavior.builder()
/*  124 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  125 */           .withinDistance(0.0D, 4.0D)
/*  126 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  127 */           .addNextBehavior(
/*  128 */             CECombatBehaviors.Behavior.builder()
/*  129 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  130 */             .withinDistance(0.0D, 5.0D)
/*  131 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  132 */             .addNextBehavior(
/*  133 */               CECombatBehaviors.Behavior.builder()
/*  134 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  135 */               .withinDistance(0.0D, 5.0D)
/*  136 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  137 */               .addNextBehavior(
/*  138 */                 CECombatBehaviors.Behavior.builder()
/*  139 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  140 */                 .withinDistance(0.0D, 6.0D)
/*  141 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  148 */       .addFirstBehavior(
/*  149 */         CECombatBehaviors.Behavior.builder()
/*  150 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  151 */         .withinDistance(0.0D, 3.0D)
/*  152 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  153 */         .addNextBehavior(
/*  154 */           CECombatBehaviors.Behavior.builder()
/*  155 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  156 */           .withinDistance(0.0D, 4.0D)
/*  157 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  158 */           .addNextBehavior(
/*  159 */             CECombatBehaviors.Behavior.builder()
/*  160 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  161 */             .withinDistance(0.0D, 5.0D)
/*  162 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  163 */             .addNextBehavior(
/*  164 */               CECombatBehaviors.Behavior.builder()
/*  165 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  166 */               .withinDistance(0.0D, 5.0D)
/*  167 */               .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  168 */               .addNextBehavior(
/*  169 */                 CECombatBehaviors.Behavior.builder()
/*  170 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  171 */                 .withinDistance(0.0D, 6.0D)
/*  172 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  179 */       .addFirstBehavior(
/*  180 */         CECombatBehaviors.Behavior.builder()
/*  181 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  182 */         .withinDistance(0.0D, 3.0D)
/*  183 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  184 */         .addNextBehavior(
/*  185 */           CECombatBehaviors.Behavior.builder()
/*  186 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  187 */           .withinDistance(0.0D, 4.0D)
/*  188 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  189 */           .addNextBehavior(
/*  190 */             CECombatBehaviors.Behavior.builder()
/*  191 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  192 */             .withinDistance(0.0D, 5.0D)
/*  193 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  194 */             .addNextBehavior(
/*  195 */               CECombatBehaviors.Behavior.builder()
/*  196 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  197 */               .withinDistance(0.0D, 5.0D)
/*  198 */               .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F)
/*  199 */               .addNextBehavior(
/*  200 */                 CECombatBehaviors.Behavior.builder()
/*  201 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  202 */                 .withinDistance(0.0D, 6.0D)
/*  203 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  210 */       .addFirstBehavior(
/*  211 */         CECombatBehaviors.Behavior.builder()
/*  212 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  213 */         .withinDistance(0.0D, 3.0D)
/*  214 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  215 */         .addNextBehavior(
/*  216 */           CECombatBehaviors.Behavior.builder()
/*  217 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  218 */           .withinDistance(0.0D, 4.0D)
/*  219 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F)
/*  220 */           .addNextBehavior(
/*  221 */             CECombatBehaviors.Behavior.builder()
/*  222 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  223 */             .withinDistance(0.0D, 5.0D)
/*  224 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  225 */             .addNextBehavior(
/*  226 */               CECombatBehaviors.Behavior.builder()
/*  227 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  228 */               .withinDistance(0.0D, 5.0D)
/*  229 */               .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  230 */               .addNextBehavior(
/*  231 */                 CECombatBehaviors.Behavior.builder()
/*  232 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  233 */                 .withinDistance(0.0D, 6.0D)
/*  234 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  241 */       .addFirstBehavior(
/*  242 */         CECombatBehaviors.Behavior.builder()
/*  243 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  244 */         .withinDistance(0.0D, 3.0D)
/*  245 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  246 */         .addNextBehavior(
/*  247 */           CECombatBehaviors.Behavior.builder()
/*  248 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  249 */           .withinDistance(0.0D, 4.0D)
/*  250 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  251 */           .addNextBehavior(
/*  252 */             CECombatBehaviors.Behavior.builder()
/*  253 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  254 */             .withinDistance(0.0D, 5.0D)
/*  255 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  256 */             .addNextBehavior(
/*  257 */               CECombatBehaviors.Behavior.builder()
/*  258 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  259 */               .withinDistance(0.0D, 5.0D)
/*  260 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  261 */               .addNextBehavior(
/*  262 */                 CECombatBehaviors.Behavior.builder()
/*  263 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  264 */                 .withinDistance(0.0D, 6.0D)
/*  265 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F))))))
/*      */ 
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
/*  278 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  279 */         .addNextBehavior(
/*  280 */           CECombatBehaviors.Behavior.builder()
/*  281 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  282 */           .withinDistance(0.0D, 4.0D)
/*  283 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  284 */           .addNextBehavior(
/*  285 */             CECombatBehaviors.Behavior.builder()
/*  286 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  287 */             .withinDistance(0.0D, 5.0D)
/*  288 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  289 */             .addNextBehavior(
/*  290 */               CECombatBehaviors.Behavior.builder()
/*  291 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  292 */               .withinDistance(0.0D, 5.0D)
/*  293 */               .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  294 */               .addNextBehavior(
/*  295 */                 CECombatBehaviors.Behavior.builder()
/*  296 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  297 */                 .withinDistance(0.0D, 6.0D)
/*  298 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  305 */       .addFirstBehavior(
/*  306 */         CECombatBehaviors.Behavior.builder()
/*  307 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  308 */         .withinDistance(0.0D, 3.0D)
/*  309 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  310 */         .addNextBehavior(
/*  311 */           CECombatBehaviors.Behavior.builder()
/*  312 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  313 */           .withinDistance(0.0D, 4.0D)
/*  314 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  315 */           .addNextBehavior(
/*  316 */             CECombatBehaviors.Behavior.builder()
/*  317 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  318 */             .withinDistance(0.0D, 5.0D)
/*  319 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  320 */             .addNextBehavior(
/*  321 */               CECombatBehaviors.Behavior.builder()
/*  322 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  323 */               .withinDistance(0.0D, 5.0D)
/*  324 */               .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F)
/*  325 */               .addNextBehavior(
/*  326 */                 CECombatBehaviors.Behavior.builder()
/*  327 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  328 */                 .withinDistance(0.0D, 6.0D)
/*  329 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  336 */       .addFirstBehavior(
/*  337 */         CECombatBehaviors.Behavior.builder()
/*  338 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  339 */         .withinDistance(0.0D, 3.0D)
/*  340 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  341 */         .addNextBehavior(
/*  342 */           CECombatBehaviors.Behavior.builder()
/*  343 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  344 */           .withinDistance(0.0D, 4.0D)
/*  345 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  346 */           .addNextBehavior(
/*  347 */             CECombatBehaviors.Behavior.builder()
/*  348 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  349 */             .withinDistance(0.0D, 5.0D)
/*  350 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  351 */             .addNextBehavior(
/*  352 */               CECombatBehaviors.Behavior.builder()
/*  353 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  354 */               .withinDistance(0.0D, 5.0D)
/*  355 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  356 */               .addNextBehavior(
/*  357 */                 CECombatBehaviors.Behavior.builder()
/*  358 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  359 */                 .withinDistance(0.0D, 6.0D)
/*  360 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  367 */       .addFirstBehavior(
/*  368 */         CECombatBehaviors.Behavior.builder()
/*  369 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  370 */         .withinDistance(0.0D, 3.0D)
/*  371 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  372 */         .addNextBehavior(
/*  373 */           CECombatBehaviors.Behavior.builder()
/*  374 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  375 */           .withinDistance(0.0D, 4.0D)
/*  376 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F)
/*  377 */           .addNextBehavior(
/*  378 */             CECombatBehaviors.Behavior.builder()
/*  379 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  380 */             .withinDistance(0.0D, 5.0D)
/*  381 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  382 */             .addNextBehavior(
/*  383 */               CECombatBehaviors.Behavior.builder()
/*  384 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  385 */               .withinDistance(0.0D, 5.0D)
/*  386 */               .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  387 */               .addNextBehavior(
/*  388 */                 CECombatBehaviors.Behavior.builder()
/*  389 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  390 */                 .withinDistance(0.0D, 6.0D)
/*  391 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  400 */       .addFirstBehavior(
/*  401 */         CECombatBehaviors.Behavior.builder()
/*  402 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  403 */         .withinDistance(0.0D, 3.0D)
/*  404 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  405 */         .addNextBehavior(
/*  406 */           CECombatBehaviors.Behavior.builder()
/*  407 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  408 */           .withinDistance(0.0D, 4.0D)
/*  409 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F)
/*  410 */           .addNextBehavior(
/*  411 */             CECombatBehaviors.Behavior.builder()
/*  412 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  413 */             .withinDistance(0.0D, 5.0D)
/*  414 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  415 */             .addNextBehavior(
/*  416 */               CECombatBehaviors.Behavior.builder()
/*  417 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  418 */               .withinDistance(0.0D, 5.0D)
/*  419 */               .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  420 */               .addNextBehavior(
/*  421 */                 CECombatBehaviors.Behavior.builder()
/*  422 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  423 */                 .withinDistance(0.0D, 6.0D)
/*  424 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  431 */       .addFirstBehavior(
/*  432 */         CECombatBehaviors.Behavior.builder()
/*  433 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  434 */         .withinDistance(0.0D, 3.0D)
/*  435 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  436 */         .addNextBehavior(
/*  437 */           CECombatBehaviors.Behavior.builder()
/*  438 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  439 */           .withinDistance(0.0D, 4.0D)
/*  440 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  441 */           .addNextBehavior(
/*  442 */             CECombatBehaviors.Behavior.builder()
/*  443 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  444 */             .withinDistance(0.0D, 5.0D)
/*  445 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  446 */             .addNextBehavior(
/*  447 */               CECombatBehaviors.Behavior.builder()
/*  448 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  449 */               .withinDistance(0.0D, 5.0D)
/*  450 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  451 */               .addNextBehavior(
/*  452 */                 CECombatBehaviors.Behavior.builder()
/*  453 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  454 */                 .withinDistance(0.0D, 6.0D)
/*  455 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  462 */       .addFirstBehavior(
/*  463 */         CECombatBehaviors.Behavior.builder()
/*  464 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  465 */         .withinDistance(0.0D, 3.0D)
/*  466 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  467 */         .addNextBehavior(
/*  468 */           CECombatBehaviors.Behavior.builder()
/*  469 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  470 */           .withinDistance(0.0D, 4.0D)
/*  471 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  472 */           .addNextBehavior(
/*  473 */             CECombatBehaviors.Behavior.builder()
/*  474 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  475 */             .withinDistance(0.0D, 5.0D)
/*  476 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  477 */             .addNextBehavior(
/*  478 */               CECombatBehaviors.Behavior.builder()
/*  479 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  480 */               .withinDistance(0.0D, 5.0D)
/*  481 */               .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  482 */               .addNextBehavior(
/*  483 */                 CECombatBehaviors.Behavior.builder()
/*  484 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  485 */                 .withinDistance(0.0D, 6.0D)
/*  486 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  493 */       .addFirstBehavior(
/*  494 */         CECombatBehaviors.Behavior.builder()
/*  495 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  496 */         .withinDistance(0.0D, 3.0D)
/*  497 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  498 */         .addNextBehavior(
/*  499 */           CECombatBehaviors.Behavior.builder()
/*  500 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  501 */           .withinDistance(0.0D, 4.0D)
/*  502 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  503 */           .addNextBehavior(
/*  504 */             CECombatBehaviors.Behavior.builder()
/*  505 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  506 */             .withinDistance(0.0D, 5.0D)
/*  507 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  508 */             .addNextBehavior(
/*  509 */               CECombatBehaviors.Behavior.builder()
/*  510 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  511 */               .withinDistance(0.0D, 5.0D)
/*  512 */               .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F)
/*  513 */               .addNextBehavior(
/*  514 */                 CECombatBehaviors.Behavior.builder()
/*  515 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  516 */                 .withinDistance(0.0D, 6.0D)
/*  517 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  524 */       .addFirstBehavior(
/*  525 */         CECombatBehaviors.Behavior.builder()
/*  526 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  527 */         .withinDistance(0.0D, 3.0D)
/*  528 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  529 */         .addNextBehavior(
/*  530 */           CECombatBehaviors.Behavior.builder()
/*  531 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  532 */           .withinDistance(0.0D, 4.0D)
/*  533 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F)
/*  534 */           .addNextBehavior(
/*  535 */             CECombatBehaviors.Behavior.builder()
/*  536 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  537 */             .withinDistance(0.0D, 5.0D)
/*  538 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  539 */             .addNextBehavior(
/*  540 */               CECombatBehaviors.Behavior.builder()
/*  541 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  542 */               .withinDistance(0.0D, 5.0D)
/*  543 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  544 */               .addNextBehavior(
/*  545 */                 CECombatBehaviors.Behavior.builder()
/*  546 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  547 */                 .withinDistance(0.0D, 6.0D)
/*  548 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  557 */       .addFirstBehavior(
/*  558 */         CECombatBehaviors.Behavior.builder()
/*  559 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  560 */         .withinDistance(0.0D, 3.0D)
/*  561 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  562 */         .addNextBehavior(
/*  563 */           CECombatBehaviors.Behavior.builder()
/*  564 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  565 */           .withinDistance(0.0D, 4.0D)
/*  566 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  567 */           .addNextBehavior(
/*  568 */             CECombatBehaviors.Behavior.builder()
/*  569 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  570 */             .withinDistance(0.0D, 5.0D)
/*  571 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  572 */             .addNextBehavior(
/*  573 */               CECombatBehaviors.Behavior.builder()
/*  574 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  575 */               .withinDistance(0.0D, 5.0D)
/*  576 */               .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  577 */               .addNextBehavior(
/*  578 */                 CECombatBehaviors.Behavior.builder()
/*  579 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  580 */                 .withinDistance(0.0D, 6.0D)
/*  581 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F))))))
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
/*  592 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  593 */         .addNextBehavior(
/*  594 */           CECombatBehaviors.Behavior.builder()
/*  595 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  596 */           .withinDistance(0.0D, 4.0D)
/*  597 */           .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  598 */           .addNextBehavior(
/*  599 */             CECombatBehaviors.Behavior.builder()
/*  600 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  601 */             .withinDistance(0.0D, 5.0D)
/*  602 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  603 */             .addNextBehavior(
/*  604 */               CECombatBehaviors.Behavior.builder()
/*  605 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  606 */               .withinDistance(0.0D, 5.0D)
/*  607 */               .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F)
/*  608 */               .addNextBehavior(
/*  609 */                 CECombatBehaviors.Behavior.builder()
/*  610 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  611 */                 .withinDistance(0.0D, 6.0D)
/*  612 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  619 */       .addFirstBehavior(
/*  620 */         CECombatBehaviors.Behavior.builder()
/*  621 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  622 */         .withinDistance(0.0D, 3.0D)
/*  623 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  624 */         .addNextBehavior(
/*  625 */           CECombatBehaviors.Behavior.builder()
/*  626 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  627 */           .withinDistance(0.0D, 4.0D)
/*  628 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  629 */           .addNextBehavior(
/*  630 */             CECombatBehaviors.Behavior.builder()
/*  631 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  632 */             .withinDistance(0.0D, 5.0D)
/*  633 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  634 */             .addNextBehavior(
/*  635 */               CECombatBehaviors.Behavior.builder()
/*  636 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  637 */               .withinDistance(0.0D, 5.0D)
/*  638 */               .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  639 */               .addNextBehavior(
/*  640 */                 CECombatBehaviors.Behavior.builder()
/*  641 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  642 */                 .withinDistance(0.0D, 6.0D)
/*  643 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  650 */       .addFirstBehavior(
/*  651 */         CECombatBehaviors.Behavior.builder()
/*  652 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  653 */         .withinDistance(0.0D, 3.0D)
/*  654 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  655 */         .addNextBehavior(
/*  656 */           CECombatBehaviors.Behavior.builder()
/*  657 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  658 */           .withinDistance(0.0D, 4.0D)
/*  659 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F)
/*  660 */           .addNextBehavior(
/*  661 */             CECombatBehaviors.Behavior.builder()
/*  662 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  663 */             .withinDistance(0.0D, 5.0D)
/*  664 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  665 */             .addNextBehavior(
/*  666 */               CECombatBehaviors.Behavior.builder()
/*  667 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  668 */               .withinDistance(0.0D, 5.0D)
/*  669 */               .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  670 */               .addNextBehavior(
/*  671 */                 CECombatBehaviors.Behavior.builder()
/*  672 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  673 */                 .withinDistance(0.0D, 6.0D)
/*  674 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  681 */       .addFirstBehavior(
/*  682 */         CECombatBehaviors.Behavior.builder()
/*  683 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  684 */         .withinDistance(0.0D, 3.0D)
/*  685 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  686 */         .addNextBehavior(
/*  687 */           CECombatBehaviors.Behavior.builder()
/*  688 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  689 */           .withinDistance(0.0D, 4.0D)
/*  690 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  691 */           .addNextBehavior(
/*  692 */             CECombatBehaviors.Behavior.builder()
/*  693 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  694 */             .withinDistance(0.0D, 5.0D)
/*  695 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  696 */             .addNextBehavior(
/*  697 */               CECombatBehaviors.Behavior.builder()
/*  698 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  699 */               .withinDistance(0.0D, 5.0D)
/*  700 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  701 */               .addNextBehavior(
/*  702 */                 CECombatBehaviors.Behavior.builder()
/*  703 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  704 */                 .withinDistance(0.0D, 6.0D)
/*  705 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  712 */       .addFirstBehavior(
/*  713 */         CECombatBehaviors.Behavior.builder()
/*  714 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  715 */         .withinDistance(0.0D, 3.0D)
/*  716 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  717 */         .addNextBehavior(
/*  718 */           CECombatBehaviors.Behavior.builder()
/*  719 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  720 */           .withinDistance(0.0D, 4.0D)
/*  721 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  722 */           .addNextBehavior(
/*  723 */             CECombatBehaviors.Behavior.builder()
/*  724 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  725 */             .withinDistance(0.0D, 5.0D)
/*  726 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  727 */             .addNextBehavior(
/*  728 */               CECombatBehaviors.Behavior.builder()
/*  729 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  730 */               .withinDistance(0.0D, 5.0D)
/*  731 */               .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  732 */               .addNextBehavior(
/*  733 */                 CECombatBehaviors.Behavior.builder()
/*  734 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  735 */                 .withinDistance(0.0D, 6.0D)
/*  736 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  743 */       .addFirstBehavior(
/*  744 */         CECombatBehaviors.Behavior.builder()
/*  745 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  746 */         .withinDistance(0.0D, 3.0D)
/*  747 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  748 */         .addNextBehavior(
/*  749 */           CECombatBehaviors.Behavior.builder()
/*  750 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  751 */           .withinDistance(0.0D, 4.0D)
/*  752 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F)
/*  753 */           .addNextBehavior(
/*  754 */             CECombatBehaviors.Behavior.builder()
/*  755 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  756 */             .withinDistance(0.0D, 5.0D)
/*  757 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  758 */             .addNextBehavior(
/*  759 */               CECombatBehaviors.Behavior.builder()
/*  760 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  761 */               .withinDistance(0.0D, 5.0D)
/*  762 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  763 */               .addNextBehavior(
/*  764 */                 CECombatBehaviors.Behavior.builder()
/*  765 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  766 */                 .withinDistance(0.0D, 6.0D)
/*  767 */                 .animationBehavior(AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  774 */       .addFirstBehavior(
/*  775 */         CECombatBehaviors.Behavior.builder()
/*  776 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  777 */         .withinDistance(0.0D, 3.0D)
/*  778 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, 0.0F)
/*  779 */         .addNextBehavior(
/*  780 */           CECombatBehaviors.Behavior.builder()
/*  781 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  782 */           .withinDistance(0.0D, 4.0D)
/*  783 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F)
/*  784 */           .addNextBehavior(
/*  785 */             CECombatBehaviors.Behavior.builder()
/*  786 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  787 */             .withinDistance(0.0D, 5.0D)
/*  788 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  789 */             .addNextBehavior(
/*  790 */               CECombatBehaviors.Behavior.builder()
/*  791 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  792 */               .withinDistance(0.0D, 5.0D)
/*  793 */               .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  794 */               .addNextBehavior(
/*  795 */                 CECombatBehaviors.Behavior.builder()
/*  796 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  797 */                 .withinDistance(0.0D, 6.0D)
/*  798 */                 .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F))))))
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
/*  809 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, 0.0F)
/*  810 */         .addNextBehavior(
/*  811 */           CECombatBehaviors.Behavior.builder()
/*  812 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  813 */           .withinDistance(0.0D, 4.0D)
/*  814 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  815 */           .addNextBehavior(
/*  816 */             CECombatBehaviors.Behavior.builder()
/*  817 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  818 */             .withinDistance(0.0D, 5.0D)
/*  819 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, 0.0F)
/*  820 */             .addNextBehavior(
/*  821 */               CECombatBehaviors.Behavior.builder()
/*  822 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  823 */               .withinDistance(0.0D, 5.0D)
/*  824 */               .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  825 */               .addNextBehavior(
/*  826 */                 CECombatBehaviors.Behavior.builder()
/*  827 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  828 */                 .withinDistance(0.0D, 6.0D)
/*  829 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  836 */     .newBehaviorRoot(
/*  837 */       CECombatBehaviors.BehaviorRoot.builder()
/*  838 */       .priority(1.0D)
/*  839 */       .weight(30.0D)
/*  840 */       .maxCooldown(20)
/*  841 */       .addFirstBehavior(
/*  842 */         CECombatBehaviors.Behavior.builder()
/*  843 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  844 */         .withinDistance(5.0D, 10.0D)
/*  845 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)))
/*      */ 
/*      */     
/*  848 */     .newBehaviorRoot(
/*  849 */       CECombatBehaviors.BehaviorRoot.builder()
/*  850 */       .priority(1.0D)
/*  851 */       .weight(30.0D)
/*  852 */       .maxCooldown(100)
/*  853 */       .addFirstBehavior(
/*  854 */         CECombatBehaviors.Behavior.builder()
/*  855 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  856 */         .withinDistance(0.0D, 5.0D)
/*  857 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F))
/*      */       
/*  859 */       .addFirstBehavior(
/*  860 */         CECombatBehaviors.Behavior.builder()
/*  861 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  862 */         .withinDistance(0.0D, 5.0D)
/*  863 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM, 0.0F)))
/*      */ 
/*      */     
/*  866 */     .newBehaviorRoot(
/*  867 */       CECombatBehaviors.BehaviorRoot.builder()
/*  868 */       .priority(1.0D)
/*  869 */       .weight(20.0D)
/*  870 */       .maxCooldown(200)
/*  871 */       .addFirstBehavior(
/*  872 */         CECombatBehaviors.Behavior.builder()
/*  873 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  874 */         .withinDistance(0.0D, 5.0D)
/*  875 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F)
/*  876 */         .addNextBehavior(
/*  877 */           CECombatBehaviors.Behavior.builder()
/*  878 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  879 */           .withinDistance(0.0D, 6.0D)
/*  880 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH, 0.0F)))
/*      */ 
/*      */       
/*  883 */       .addFirstBehavior(
/*  884 */         CECombatBehaviors.Behavior.builder()
/*  885 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  886 */         .custom(HerobrineCommon::canShootDarkOb)
/*  887 */         .withinDistance(5.0D, 10.0D)
/*  888 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  889 */         .addExBehavior(HerobrineCommon::performShootDarkOb)))
/*      */ 
/*      */     
/*  892 */     .newBehaviorRoot(
/*  893 */       CECombatBehaviors.BehaviorRoot.builder()
/*  894 */       .priority(1.0D)
/*  895 */       .weight(15.0D)
/*  896 */       .maxCooldown(200)
/*  897 */       .addFirstBehavior(
/*  898 */         CECombatBehaviors.Behavior.builder()
/*  899 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  900 */         .custom(HerobrineCommon::canPlayObsidianMachine)
/*  901 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  902 */         .addExBehavior(HerobrineCommon::performObsidianMachine)))
/*      */ 
/*      */     
/*  905 */     .newBehaviorRoot(
/*  906 */       CECombatBehaviors.BehaviorRoot.builder()
/*  907 */       .priority(1.0D)
/*  908 */       .weight(15.0D)
/*  909 */       .addFirstBehavior(
/*  910 */         CECombatBehaviors.Behavior.builder()
/*  911 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  912 */         .withinDistance(0.0D, 3.0D)
/*  913 */         .custom(HerobrineCommon::canPerformGuarding)
/*  914 */         .guard(40)))
/*      */ 
/*      */     
/*  917 */     .newBehaviorRoot(
/*  918 */       CECombatBehaviors.BehaviorRoot.builder()
/*  919 */       .priority(1.0D)
/*  920 */       .weight(10.0D)
/*  921 */       .addFirstBehavior(
/*  922 */         CECombatBehaviors.Behavior.builder()
/*  923 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  924 */         .withinDistance(0.0D, 5.0D)
/*  925 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/*  927 */       .addFirstBehavior(
/*  928 */         CECombatBehaviors.Behavior.builder()
/*  929 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  930 */         .withinDistance(0.0D, 5.0D)
/*  931 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))
/*      */       
/*  933 */       .addFirstBehavior(
/*  934 */         CECombatBehaviors.Behavior.builder()
/*  935 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  936 */         .withinDistance(0.0D, 5.0D)
/*  937 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/*  939 */       .addFirstBehavior(
/*  940 */         CECombatBehaviors.Behavior.builder()
/*  941 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  942 */         .withinDistance(0.0D, 5.0D)
/*  943 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/*  945 */       .addFirstBehavior(
/*  946 */         CECombatBehaviors.Behavior.builder()
/*  947 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  948 */         .withinDistance(0.0D, 5.0D)
/*  949 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/*  951 */       .addFirstBehavior(
/*  952 */         CECombatBehaviors.Behavior.builder()
/*  953 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  954 */         .withinDistance(0.0D, 5.0D)
/*  955 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/*  958 */     .newBehaviorRoot(
/*  959 */       CECombatBehaviors.BehaviorRoot.builder()
/*  960 */       .priority(1.0D)
/*  961 */       .weight(20.0D)
/*  962 */       .maxCooldown(160)
/*  963 */       .addFirstBehavior(
/*  964 */         CECombatBehaviors.Behavior.builder()
/*  965 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  966 */         .custom(HerobrineCommon::canJump)
/*  967 */         .withinDistance(5.0D, 14.0D)
/*  968 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/*  969 */         .addExBehavior(HerobrineCommon::jump)));
/*      */ 
/*      */ 
/*      */   
/*  973 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SHADOW_OBSIDIAN_DUAL_SWORD = CECombatBehaviors.builder()
/*  974 */     .newBehaviorRoot(
/*  975 */       CECombatBehaviors.BehaviorRoot.builder()
/*  976 */       .priority(5.0D)
/*  977 */       .weight(1000.0D)
/*  978 */       .maxCooldown(0)
/*  979 */       .addFirstBehavior(
/*  980 */         CECombatBehaviors.Behavior.builder()
/*  981 */         .custom(CombatCommon::canExecute)
/*  982 */         .withinDistance(0.0D, 5.0D)
/*  983 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  984 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  987 */     .newBehaviorRoot(
/*  988 */       CECombatBehaviors.BehaviorRoot.builder()
/*  989 */       .priority(4.0D)
/*  990 */       .weight(1000.0D)
/*  991 */       .maxCooldown(0)
/*  992 */       .addFirstBehavior(
/*  993 */         CECombatBehaviors.Behavior.builder()
/*  994 */         .custom(CombatCommon::canEscape)
/*  995 */         .withinDistance(0.0D, 8.0D)
/*  996 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  997 */         .addExBehavior(CombatCommon::performEscapeRunAway)))
/*      */ 
/*      */     
/* 1000 */     .newBehaviorRoot(
/* 1001 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1002 */       .priority(3.0D)
/* 1003 */       .weight(100.0D)
/* 1004 */       .maxCooldown(120)
/* 1005 */       .addFirstBehavior(
/* 1006 */         CECombatBehaviors.Behavior.builder()
/* 1007 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1008 */         .custom(CombatCommon::canSwitchWeapon)
/* 1009 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1010 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/* 1012 */       .addFirstBehavior(
/* 1013 */         CECombatBehaviors.Behavior.builder()
/* 1014 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1015 */         .custom(CombatCommon::canSwitchWeapon)
/* 1016 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1017 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/* 1020 */     .newBehaviorRoot(
/* 1021 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1022 */       .priority(2.0D)
/* 1023 */       .weight(70.0D)
/* 1024 */       .maxCooldown(0)
/* 1025 */       .addFirstBehavior(
/* 1026 */         CECombatBehaviors.Behavior.builder()
/* 1027 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1028 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/* 1029 */         .custom(HerobrineCommon::canPerformHealing)
/* 1030 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/* 1031 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*      */ 
/*      */     
/* 1034 */     .newBehaviorRoot(
/* 1035 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1036 */       .priority(2.0D)
/* 1037 */       .weight(70.0D)
/* 1038 */       .maxCooldown(100)
/* 1039 */       .addFirstBehavior(
/* 1040 */         CECombatBehaviors.Behavior.builder()
/* 1041 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1042 */         .custom(HerobrineCommon::canSummonDarkOb)
/* 1043 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/* 1044 */         .addExBehavior(HerobrineCommon::performSummonDarkOb)))
/*      */ 
/*      */     
/* 1047 */     .newBehaviorRoot(
/* 1048 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1049 */       .priority(1.0D)
/* 1050 */       .weight(40.0D)
/* 1051 */       .maxCooldown(20)
/* 1052 */       .addFirstBehavior(
/* 1053 */         CECombatBehaviors.Behavior.builder()
/* 1054 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1055 */         .withinDistance(0.0D, 4.0D)
/* 1056 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1057 */         .addNextBehavior(
/* 1058 */           CECombatBehaviors.Behavior.builder()
/* 1059 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1060 */           .withinDistance(0.0D, 5.0D)
/* 1061 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1062 */           .addNextBehavior(
/* 1063 */             CECombatBehaviors.Behavior.builder()
/* 1064 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1065 */             .withinDistance(0.0D, 5.0D)
/* 1066 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1067 */             .addNextBehavior(
/* 1068 */               CECombatBehaviors.Behavior.builder()
/* 1069 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1070 */               .withinDistance(0.0D, 6.0D)
/* 1071 */               .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1072 */               .addNextBehavior(
/* 1073 */                 CECombatBehaviors.Behavior.builder()
/* 1074 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1075 */                 .withinDistance(0.0D, 6.0D)
/* 1076 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1082 */       .addFirstBehavior(
/* 1083 */         CECombatBehaviors.Behavior.builder()
/* 1084 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1085 */         .withinDistance(0.0D, 3.0D)
/* 1086 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1087 */         .addNextBehavior(
/* 1088 */           CECombatBehaviors.Behavior.builder()
/* 1089 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1090 */           .withinDistance(0.0D, 4.0D)
/* 1091 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1092 */           .addNextBehavior(
/* 1093 */             CECombatBehaviors.Behavior.builder()
/* 1094 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1095 */             .withinDistance(0.0D, 5.0D)
/* 1096 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1097 */             .addNextBehavior(
/* 1098 */               CECombatBehaviors.Behavior.builder()
/* 1099 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1100 */               .withinDistance(0.0D, 5.0D)
/* 1101 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1102 */               .addNextBehavior(
/* 1103 */                 CECombatBehaviors.Behavior.builder()
/* 1104 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1105 */                 .withinDistance(0.0D, 6.0D)
/* 1106 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1113 */       .addFirstBehavior(
/* 1114 */         CECombatBehaviors.Behavior.builder()
/* 1115 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1116 */         .withinDistance(0.0D, 3.0D)
/* 1117 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1118 */         .addNextBehavior(
/* 1119 */           CECombatBehaviors.Behavior.builder()
/* 1120 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1121 */           .withinDistance(0.0D, 4.0D)
/* 1122 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1123 */           .addNextBehavior(
/* 1124 */             CECombatBehaviors.Behavior.builder()
/* 1125 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1126 */             .withinDistance(0.0D, 5.0D)
/* 1127 */             .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1128 */             .addNextBehavior(
/* 1129 */               CECombatBehaviors.Behavior.builder()
/* 1130 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1131 */               .withinDistance(0.0D, 5.0D)
/* 1132 */               .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1133 */               .addNextBehavior(
/* 1134 */                 CECombatBehaviors.Behavior.builder()
/* 1135 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1136 */                 .withinDistance(0.0D, 6.0D)
/* 1137 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F))))))
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
/* 1148 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1149 */         .addNextBehavior(
/* 1150 */           CECombatBehaviors.Behavior.builder()
/* 1151 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1152 */           .withinDistance(0.0D, 4.0D)
/* 1153 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F)
/* 1154 */           .addNextBehavior(
/* 1155 */             CECombatBehaviors.Behavior.builder()
/* 1156 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1157 */             .withinDistance(0.0D, 5.0D)
/* 1158 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1159 */             .addNextBehavior(
/* 1160 */               CECombatBehaviors.Behavior.builder()
/* 1161 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1162 */               .withinDistance(0.0D, 5.0D)
/* 1163 */               .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1164 */               .addNextBehavior(
/* 1165 */                 CECombatBehaviors.Behavior.builder()
/* 1166 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1167 */                 .withinDistance(0.0D, 6.0D)
/* 1168 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1175 */       .addFirstBehavior(
/* 1176 */         CECombatBehaviors.Behavior.builder()
/* 1177 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1178 */         .withinDistance(0.0D, 3.0D)
/* 1179 */         .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1180 */         .addNextBehavior(
/* 1181 */           CECombatBehaviors.Behavior.builder()
/* 1182 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1183 */           .withinDistance(0.0D, 4.0D)
/* 1184 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1185 */           .addNextBehavior(
/* 1186 */             CECombatBehaviors.Behavior.builder()
/* 1187 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1188 */             .withinDistance(0.0D, 5.0D)
/* 1189 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1190 */             .addNextBehavior(
/* 1191 */               CECombatBehaviors.Behavior.builder()
/* 1192 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1193 */               .withinDistance(0.0D, 5.0D)
/* 1194 */               .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1195 */               .addNextBehavior(
/* 1196 */                 CECombatBehaviors.Behavior.builder()
/* 1197 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1198 */                 .withinDistance(0.0D, 6.0D)
/* 1199 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F))))))
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
/* 1210 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1211 */         .addNextBehavior(
/* 1212 */           CECombatBehaviors.Behavior.builder()
/* 1213 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1214 */           .withinDistance(0.0D, 4.0D)
/* 1215 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1216 */           .addNextBehavior(
/* 1217 */             CECombatBehaviors.Behavior.builder()
/* 1218 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1219 */             .withinDistance(0.0D, 5.0D)
/* 1220 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1221 */             .addNextBehavior(
/* 1222 */               CECombatBehaviors.Behavior.builder()
/* 1223 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1224 */               .withinDistance(0.0D, 5.0D)
/* 1225 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 1226 */               .addNextBehavior(
/* 1227 */                 CECombatBehaviors.Behavior.builder()
/* 1228 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1229 */                 .withinDistance(0.0D, 6.0D)
/* 1230 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1239 */       .addFirstBehavior(
/* 1240 */         CECombatBehaviors.Behavior.builder()
/* 1241 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1242 */         .withinDistance(0.0D, 3.0D)
/* 1243 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1244 */         .addNextBehavior(
/* 1245 */           CECombatBehaviors.Behavior.builder()
/* 1246 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1247 */           .withinDistance(0.0D, 4.0D)
/* 1248 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F)
/* 1249 */           .addNextBehavior(
/* 1250 */             CECombatBehaviors.Behavior.builder()
/* 1251 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1252 */             .withinDistance(0.0D, 5.0D)
/* 1253 */             .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1254 */             .addNextBehavior(
/* 1255 */               CECombatBehaviors.Behavior.builder()
/* 1256 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1257 */               .withinDistance(0.0D, 5.0D)
/* 1258 */               .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1259 */               .addNextBehavior(
/* 1260 */                 CECombatBehaviors.Behavior.builder()
/* 1261 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1262 */                 .withinDistance(0.0D, 6.0D)
/* 1263 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1270 */       .addFirstBehavior(
/* 1271 */         CECombatBehaviors.Behavior.builder()
/* 1272 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1273 */         .withinDistance(0.0D, 3.0D)
/* 1274 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1275 */         .addNextBehavior(
/* 1276 */           CECombatBehaviors.Behavior.builder()
/* 1277 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1278 */           .withinDistance(0.0D, 4.0D)
/* 1279 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1280 */           .addNextBehavior(
/* 1281 */             CECombatBehaviors.Behavior.builder()
/* 1282 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1283 */             .withinDistance(0.0D, 5.0D)
/* 1284 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1285 */             .addNextBehavior(
/* 1286 */               CECombatBehaviors.Behavior.builder()
/* 1287 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1288 */               .withinDistance(0.0D, 5.0D)
/* 1289 */               .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1290 */               .addNextBehavior(
/* 1291 */                 CECombatBehaviors.Behavior.builder()
/* 1292 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1293 */                 .withinDistance(0.0D, 6.0D)
/* 1294 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1301 */       .addFirstBehavior(
/* 1302 */         CECombatBehaviors.Behavior.builder()
/* 1303 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1304 */         .withinDistance(0.0D, 3.0D)
/* 1305 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1306 */         .addNextBehavior(
/* 1307 */           CECombatBehaviors.Behavior.builder()
/* 1308 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1309 */           .withinDistance(0.0D, 4.0D)
/* 1310 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1311 */           .addNextBehavior(
/* 1312 */             CECombatBehaviors.Behavior.builder()
/* 1313 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1314 */             .withinDistance(0.0D, 5.0D)
/* 1315 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1316 */             .addNextBehavior(
/* 1317 */               CECombatBehaviors.Behavior.builder()
/* 1318 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1319 */               .withinDistance(0.0D, 5.0D)
/* 1320 */               .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1321 */               .addNextBehavior(
/* 1322 */                 CECombatBehaviors.Behavior.builder()
/* 1323 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1324 */                 .withinDistance(0.0D, 6.0D)
/* 1325 */                 .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1332 */       .addFirstBehavior(
/* 1333 */         CECombatBehaviors.Behavior.builder()
/* 1334 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1335 */         .withinDistance(0.0D, 3.0D)
/* 1336 */         .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1337 */         .addNextBehavior(
/* 1338 */           CECombatBehaviors.Behavior.builder()
/* 1339 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1340 */           .withinDistance(0.0D, 4.0D)
/* 1341 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1342 */           .addNextBehavior(
/* 1343 */             CECombatBehaviors.Behavior.builder()
/* 1344 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1345 */             .withinDistance(0.0D, 5.0D)
/* 1346 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1347 */             .addNextBehavior(
/* 1348 */               CECombatBehaviors.Behavior.builder()
/* 1349 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1350 */               .withinDistance(0.0D, 5.0D)
/* 1351 */               .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1352 */               .addNextBehavior(
/* 1353 */                 CECombatBehaviors.Behavior.builder()
/* 1354 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1355 */                 .withinDistance(0.0D, 6.0D)
/* 1356 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1362 */       .addFirstBehavior(
/* 1363 */         CECombatBehaviors.Behavior.builder()
/* 1364 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1365 */         .withinDistance(0.0D, 3.0D)
/* 1366 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1367 */         .addNextBehavior(
/* 1368 */           CECombatBehaviors.Behavior.builder()
/* 1369 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1370 */           .withinDistance(0.0D, 4.0D)
/* 1371 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F)
/* 1372 */           .addNextBehavior(
/* 1373 */             CECombatBehaviors.Behavior.builder()
/* 1374 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1375 */             .withinDistance(0.0D, 5.0D)
/* 1376 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1377 */             .addNextBehavior(
/* 1378 */               CECombatBehaviors.Behavior.builder()
/* 1379 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1380 */               .withinDistance(0.0D, 5.0D)
/* 1381 */               .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1382 */               .addNextBehavior(
/* 1383 */                 CECombatBehaviors.Behavior.builder()
/* 1384 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1385 */                 .withinDistance(0.0D, 6.0D)
/* 1386 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1393 */       .addFirstBehavior(
/* 1394 */         CECombatBehaviors.Behavior.builder()
/* 1395 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1396 */         .withinDistance(0.0D, 3.0D)
/* 1397 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1398 */         .addNextBehavior(
/* 1399 */           CECombatBehaviors.Behavior.builder()
/* 1400 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1401 */           .withinDistance(0.0D, 4.0D)
/* 1402 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1403 */           .addNextBehavior(
/* 1404 */             CECombatBehaviors.Behavior.builder()
/* 1405 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1406 */             .withinDistance(0.0D, 5.0D)
/* 1407 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1408 */             .addNextBehavior(
/* 1409 */               CECombatBehaviors.Behavior.builder()
/* 1410 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1411 */               .withinDistance(0.0D, 5.0D)
/* 1412 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 1413 */               .addNextBehavior(
/* 1414 */                 CECombatBehaviors.Behavior.builder()
/* 1415 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1416 */                 .withinDistance(0.0D, 6.0D)
/* 1417 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1424 */       .addFirstBehavior(
/* 1425 */         CECombatBehaviors.Behavior.builder()
/* 1426 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1427 */         .withinDistance(0.0D, 3.0D)
/* 1428 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1429 */         .addNextBehavior(
/* 1430 */           CECombatBehaviors.Behavior.builder()
/* 1431 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1432 */           .withinDistance(0.0D, 4.0D)
/* 1433 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1434 */           .addNextBehavior(
/* 1435 */             CECombatBehaviors.Behavior.builder()
/* 1436 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1437 */             .withinDistance(0.0D, 5.0D)
/* 1438 */             .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1439 */             .addNextBehavior(
/* 1440 */               CECombatBehaviors.Behavior.builder()
/* 1441 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1442 */               .withinDistance(0.0D, 5.0D)
/* 1443 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1444 */               .addNextBehavior(
/* 1445 */                 CECombatBehaviors.Behavior.builder()
/* 1446 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1447 */                 .withinDistance(0.0D, 6.0D)
/* 1448 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1455 */       .addFirstBehavior(
/* 1456 */         CECombatBehaviors.Behavior.builder()
/* 1457 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1458 */         .withinDistance(0.0D, 3.0D)
/* 1459 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1460 */         .addNextBehavior(
/* 1461 */           CECombatBehaviors.Behavior.builder()
/* 1462 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1463 */           .withinDistance(0.0D, 4.0D)
/* 1464 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1465 */           .addNextBehavior(
/* 1466 */             CECombatBehaviors.Behavior.builder()
/* 1467 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1468 */             .withinDistance(0.0D, 5.0D)
/* 1469 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1470 */             .addNextBehavior(
/* 1471 */               CECombatBehaviors.Behavior.builder()
/* 1472 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1473 */               .withinDistance(0.0D, 5.0D)
/* 1474 */               .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1475 */               .addNextBehavior(
/* 1476 */                 CECombatBehaviors.Behavior.builder()
/* 1477 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1478 */                 .withinDistance(0.0D, 6.0D)
/* 1479 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1486 */       .addFirstBehavior(
/* 1487 */         CECombatBehaviors.Behavior.builder()
/* 1488 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1489 */         .withinDistance(0.0D, 3.0D)
/* 1490 */         .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1491 */         .addNextBehavior(
/* 1492 */           CECombatBehaviors.Behavior.builder()
/* 1493 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1494 */           .withinDistance(0.0D, 4.0D)
/* 1495 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F)
/* 1496 */           .addNextBehavior(
/* 1497 */             CECombatBehaviors.Behavior.builder()
/* 1498 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1499 */             .withinDistance(0.0D, 5.0D)
/* 1500 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1501 */             .addNextBehavior(
/* 1502 */               CECombatBehaviors.Behavior.builder()
/* 1503 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1504 */               .withinDistance(0.0D, 5.0D)
/* 1505 */               .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1506 */               .addNextBehavior(
/* 1507 */                 CECombatBehaviors.Behavior.builder()
/* 1508 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1509 */                 .withinDistance(0.0D, 6.0D)
/* 1510 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1519 */       .addFirstBehavior(
/* 1520 */         CECombatBehaviors.Behavior.builder()
/* 1521 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1522 */         .withinDistance(0.0D, 3.0D)
/* 1523 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1524 */         .addNextBehavior(
/* 1525 */           CECombatBehaviors.Behavior.builder()
/* 1526 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1527 */           .withinDistance(0.0D, 4.0D)
/* 1528 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1529 */           .addNextBehavior(
/* 1530 */             CECombatBehaviors.Behavior.builder()
/* 1531 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1532 */             .withinDistance(0.0D, 5.0D)
/* 1533 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1534 */             .addNextBehavior(
/* 1535 */               CECombatBehaviors.Behavior.builder()
/* 1536 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1537 */               .withinDistance(0.0D, 5.0D)
/* 1538 */               .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1539 */               .addNextBehavior(
/* 1540 */                 CECombatBehaviors.Behavior.builder()
/* 1541 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1542 */                 .withinDistance(0.0D, 6.0D)
/* 1543 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1550 */       .addFirstBehavior(
/* 1551 */         CECombatBehaviors.Behavior.builder()
/* 1552 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1553 */         .withinDistance(0.0D, 3.0D)
/* 1554 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1555 */         .addNextBehavior(
/* 1556 */           CECombatBehaviors.Behavior.builder()
/* 1557 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1558 */           .withinDistance(0.0D, 4.0D)
/* 1559 */           .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 1560 */           .addNextBehavior(
/* 1561 */             CECombatBehaviors.Behavior.builder()
/* 1562 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1563 */             .withinDistance(0.0D, 5.0D)
/* 1564 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1565 */             .addNextBehavior(
/* 1566 */               CECombatBehaviors.Behavior.builder()
/* 1567 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1568 */               .withinDistance(0.0D, 5.0D)
/* 1569 */               .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F)
/* 1570 */               .addNextBehavior(
/* 1571 */                 CECombatBehaviors.Behavior.builder()
/* 1572 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1573 */                 .withinDistance(0.0D, 6.0D)
/* 1574 */                 .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1581 */       .addFirstBehavior(
/* 1582 */         CECombatBehaviors.Behavior.builder()
/* 1583 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1584 */         .withinDistance(0.0D, 3.0D)
/* 1585 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1586 */         .addNextBehavior(
/* 1587 */           CECombatBehaviors.Behavior.builder()
/* 1588 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1589 */           .withinDistance(0.0D, 4.0D)
/* 1590 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1591 */           .addNextBehavior(
/* 1592 */             CECombatBehaviors.Behavior.builder()
/* 1593 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1594 */             .withinDistance(0.0D, 5.0D)
/* 1595 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1596 */             .addNextBehavior(
/* 1597 */               CECombatBehaviors.Behavior.builder()
/* 1598 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1599 */               .withinDistance(0.0D, 5.0D)
/* 1600 */               .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1601 */               .addNextBehavior(
/* 1602 */                 CECombatBehaviors.Behavior.builder()
/* 1603 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1604 */                 .withinDistance(0.0D, 6.0D)
/* 1605 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1612 */       .addFirstBehavior(
/* 1613 */         CECombatBehaviors.Behavior.builder()
/* 1614 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1615 */         .withinDistance(0.0D, 3.0D)
/* 1616 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1617 */         .addNextBehavior(
/* 1618 */           CECombatBehaviors.Behavior.builder()
/* 1619 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1620 */           .withinDistance(0.0D, 4.0D)
/* 1621 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1622 */           .addNextBehavior(
/* 1623 */             CECombatBehaviors.Behavior.builder()
/* 1624 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1625 */             .withinDistance(0.0D, 5.0D)
/* 1626 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1627 */             .addNextBehavior(
/* 1628 */               CECombatBehaviors.Behavior.builder()
/* 1629 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1630 */               .withinDistance(0.0D, 5.0D)
/* 1631 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1632 */               .addNextBehavior(
/* 1633 */                 CECombatBehaviors.Behavior.builder()
/* 1634 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1635 */                 .withinDistance(0.0D, 6.0D)
/* 1636 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1643 */       .addFirstBehavior(
/* 1644 */         CECombatBehaviors.Behavior.builder()
/* 1645 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1646 */         .withinDistance(0.0D, 3.0D)
/* 1647 */         .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1648 */         .addNextBehavior(
/* 1649 */           CECombatBehaviors.Behavior.builder()
/* 1650 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1651 */           .withinDistance(0.0D, 4.0D)
/* 1652 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1653 */           .addNextBehavior(
/* 1654 */             CECombatBehaviors.Behavior.builder()
/* 1655 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1656 */             .withinDistance(0.0D, 5.0D)
/* 1657 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1658 */             .addNextBehavior(
/* 1659 */               CECombatBehaviors.Behavior.builder()
/* 1660 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1661 */               .withinDistance(0.0D, 5.0D)
/* 1662 */               .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1663 */               .addNextBehavior(
/* 1664 */                 CECombatBehaviors.Behavior.builder()
/* 1665 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1666 */                 .withinDistance(0.0D, 6.0D)
/* 1667 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1676 */       .addFirstBehavior(
/* 1677 */         CECombatBehaviors.Behavior.builder()
/* 1678 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1679 */         .withinDistance(0.0D, 3.0D)
/* 1680 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1681 */         .addNextBehavior(
/* 1682 */           CECombatBehaviors.Behavior.builder()
/* 1683 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1684 */           .withinDistance(0.0D, 4.0D)
/* 1685 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1686 */           .addNextBehavior(
/* 1687 */             CECombatBehaviors.Behavior.builder()
/* 1688 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1689 */             .withinDistance(0.0D, 5.0D)
/* 1690 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1691 */             .addNextBehavior(
/* 1692 */               CECombatBehaviors.Behavior.builder()
/* 1693 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1694 */               .withinDistance(0.0D, 5.0D)
/* 1695 */               .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/* 1696 */               .addNextBehavior(
/* 1697 */                 CECombatBehaviors.Behavior.builder()
/* 1698 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1699 */                 .withinDistance(0.0D, 6.0D)
/* 1700 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1707 */       .addFirstBehavior(
/* 1708 */         CECombatBehaviors.Behavior.builder()
/* 1709 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1710 */         .withinDistance(0.0D, 3.0D)
/* 1711 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1712 */         .addNextBehavior(
/* 1713 */           CECombatBehaviors.Behavior.builder()
/* 1714 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1715 */           .withinDistance(0.0D, 4.0D)
/* 1716 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F)
/* 1717 */           .addNextBehavior(
/* 1718 */             CECombatBehaviors.Behavior.builder()
/* 1719 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1720 */             .withinDistance(0.0D, 5.0D)
/* 1721 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1722 */             .addNextBehavior(
/* 1723 */               CECombatBehaviors.Behavior.builder()
/* 1724 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1725 */               .withinDistance(0.0D, 5.0D)
/* 1726 */               .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/* 1727 */               .addNextBehavior(
/* 1728 */                 CECombatBehaviors.Behavior.builder()
/* 1729 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1730 */                 .withinDistance(0.0D, 6.0D)
/* 1731 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1738 */       .addFirstBehavior(
/* 1739 */         CECombatBehaviors.Behavior.builder()
/* 1740 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1741 */         .withinDistance(0.0D, 3.0D)
/* 1742 */         .animationBehavior(AVAnimations.GREATSWORD_DUAL_AUTO_2, 0.0F)
/* 1743 */         .addNextBehavior(
/* 1744 */           CECombatBehaviors.Behavior.builder()
/* 1745 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1746 */           .withinDistance(0.0D, 4.0D)
/* 1747 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1748 */           .addNextBehavior(
/* 1749 */             CECombatBehaviors.Behavior.builder()
/* 1750 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1751 */             .withinDistance(0.0D, 5.0D)
/* 1752 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)
/* 1753 */             .addNextBehavior(
/* 1754 */               CECombatBehaviors.Behavior.builder()
/* 1755 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1756 */               .withinDistance(0.0D, 5.0D)
/* 1757 */               .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/* 1758 */               .addNextBehavior(
/* 1759 */                 CECombatBehaviors.Behavior.builder()
/* 1760 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1761 */                 .withinDistance(0.0D, 6.0D)
/* 1762 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1769 */       .addFirstBehavior(
/* 1770 */         CECombatBehaviors.Behavior.builder()
/* 1771 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1772 */         .withinDistance(0.0D, 3.0D)
/* 1773 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1774 */         .addNextBehavior(
/* 1775 */           CECombatBehaviors.Behavior.builder()
/* 1776 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1777 */           .withinDistance(0.0D, 4.0D)
/* 1778 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)
/* 1779 */           .addNextBehavior(
/* 1780 */             CECombatBehaviors.Behavior.builder()
/* 1781 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1782 */             .withinDistance(0.0D, 5.0D)
/* 1783 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, 0.0F)
/* 1784 */             .addNextBehavior(
/* 1785 */               CECombatBehaviors.Behavior.builder()
/* 1786 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1787 */               .withinDistance(0.0D, 5.0D)
/* 1788 */               .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/* 1789 */               .addNextBehavior(
/* 1790 */                 CECombatBehaviors.Behavior.builder()
/* 1791 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1792 */                 .withinDistance(0.0D, 6.0D)
/* 1793 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1800 */       .addFirstBehavior(
/* 1801 */         CECombatBehaviors.Behavior.builder()
/* 1802 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1803 */         .withinDistance(0.0D, 3.0D)
/* 1804 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, 0.0F)
/* 1805 */         .addNextBehavior(
/* 1806 */           CECombatBehaviors.Behavior.builder()
/* 1807 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1808 */           .withinDistance(0.0D, 4.0D)
/* 1809 */           .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F)
/* 1810 */           .addNextBehavior(
/* 1811 */             CECombatBehaviors.Behavior.builder()
/* 1812 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1813 */             .withinDistance(0.0D, 5.0D)
/* 1814 */             .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, 0.0F)
/* 1815 */             .addNextBehavior(
/* 1816 */               CECombatBehaviors.Behavior.builder()
/* 1817 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1818 */               .withinDistance(0.0D, 5.0D)
/* 1819 */               .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/* 1820 */               .addNextBehavior(
/* 1821 */                 CECombatBehaviors.Behavior.builder()
/* 1822 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1823 */                 .withinDistance(0.0D, 6.0D)
/* 1824 */                 .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1831 */     .newBehaviorRoot(
/* 1832 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1833 */       .priority(1.0D)
/* 1834 */       .weight(30.0D)
/* 1835 */       .maxCooldown(20)
/* 1836 */       .addFirstBehavior(
/* 1837 */         CECombatBehaviors.Behavior.builder()
/* 1838 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1839 */         .withinDistance(5.0D, 10.0D)
/* 1840 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F)))
/*      */ 
/*      */     
/* 1843 */     .newBehaviorRoot(
/* 1844 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1845 */       .priority(1.0D)
/* 1846 */       .weight(30.0D)
/* 1847 */       .maxCooldown(100)
/* 1848 */       .addFirstBehavior(
/* 1849 */         CECombatBehaviors.Behavior.builder()
/* 1850 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1851 */         .withinDistance(0.0D, 5.0D)
/* 1852 */         .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))
/*      */       
/* 1854 */       .addFirstBehavior(
/* 1855 */         CECombatBehaviors.Behavior.builder()
/* 1856 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1857 */         .withinDistance(0.0D, 5.0D)
/* 1858 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH, 0.0F)))
/*      */ 
/*      */     
/* 1861 */     .newBehaviorRoot(
/* 1862 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1863 */       .priority(1.0D)
/* 1864 */       .weight(20.0D)
/* 1865 */       .maxCooldown(200)
/* 1866 */       .addFirstBehavior(
/* 1867 */         CECombatBehaviors.Behavior.builder()
/* 1868 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1869 */         .withinDistance(0.0D, 5.0D)
/* 1870 */         .animationBehavior(AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE, 0.0F))
/*      */       
/* 1872 */       .addFirstBehavior(
/* 1873 */         CECombatBehaviors.Behavior.builder()
/* 1874 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1875 */         .custom(HerobrineCommon::canShootDarkOb)
/* 1876 */         .withinDistance(5.0D, 10.0D)
/* 1877 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1878 */         .addExBehavior(HerobrineCommon::performShootDarkOb)))
/*      */ 
/*      */     
/* 1881 */     .newBehaviorRoot(
/* 1882 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1883 */       .priority(1.0D)
/* 1884 */       .weight(15.0D)
/* 1885 */       .maxCooldown(200)
/* 1886 */       .addFirstBehavior(
/* 1887 */         CECombatBehaviors.Behavior.builder()
/* 1888 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1889 */         .custom(HerobrineCommon::canPlayObsidianMachine)
/* 1890 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/* 1891 */         .addExBehavior(HerobrineCommon::performObsidianMachine)))
/*      */ 
/*      */     
/* 1894 */     .newBehaviorRoot(
/* 1895 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1896 */       .priority(1.0D)
/* 1897 */       .weight(15.0D)
/* 1898 */       .addFirstBehavior(
/* 1899 */         CECombatBehaviors.Behavior.builder()
/* 1900 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1901 */         .withinDistance(0.0D, 3.0D)
/* 1902 */         .custom(HerobrineCommon::canPerformGuarding)
/* 1903 */         .guard(40)))
/*      */ 
/*      */     
/* 1906 */     .newBehaviorRoot(
/* 1907 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1908 */       .priority(1.0D)
/* 1909 */       .weight(10.0D)
/* 1910 */       .addFirstBehavior(
/* 1911 */         CECombatBehaviors.Behavior.builder()
/* 1912 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1913 */         .withinDistance(0.0D, 5.0D)
/* 1914 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1916 */       .addFirstBehavior(
/* 1917 */         CECombatBehaviors.Behavior.builder()
/* 1918 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1919 */         .withinDistance(0.0D, 5.0D)
/* 1920 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))
/*      */       
/* 1922 */       .addFirstBehavior(
/* 1923 */         CECombatBehaviors.Behavior.builder()
/* 1924 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1925 */         .withinDistance(0.0D, 5.0D)
/* 1926 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1928 */       .addFirstBehavior(
/* 1929 */         CECombatBehaviors.Behavior.builder()
/* 1930 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1931 */         .withinDistance(0.0D, 5.0D)
/* 1932 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1934 */       .addFirstBehavior(
/* 1935 */         CECombatBehaviors.Behavior.builder()
/* 1936 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1937 */         .withinDistance(0.0D, 5.0D)
/* 1938 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1940 */       .addFirstBehavior(
/* 1941 */         CECombatBehaviors.Behavior.builder()
/* 1942 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1943 */         .withinDistance(0.0D, 5.0D)
/* 1944 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1947 */     .newBehaviorRoot(
/* 1948 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1949 */       .priority(1.0D)
/* 1950 */       .weight(20.0D)
/* 1951 */       .maxCooldown(160)
/* 1952 */       .addFirstBehavior(
/* 1953 */         CECombatBehaviors.Behavior.builder()
/* 1954 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1955 */         .custom(HerobrineCommon::canJump)
/* 1956 */         .withinDistance(5.0D, 14.0D)
/* 1957 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1958 */         .addExBehavior(HerobrineCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineShadowObsidianSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */