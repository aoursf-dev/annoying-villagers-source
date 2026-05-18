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
/*      */ public class NpcFist
/*      */ {
/*   14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> FIST = CECombatBehaviors.builder()
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
/*   37 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   38 */         .addExBehavior(CombatCommon::performEscapeRunAway))
/*      */       
/*   40 */       .addFirstBehavior(
/*   41 */         CECombatBehaviors.Behavior.builder()
/*   42 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*   43 */         .custom(CombatCommon::canEscape)
/*   44 */         .withinDistance(0.0D, 48.0D)
/*   45 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*   46 */         .addExBehavior(CombatCommon::swapToMelee)))
/*      */ 
/*      */     
/*   49 */     .newBehaviorRoot(
/*   50 */       CECombatBehaviors.BehaviorRoot.builder()
/*   51 */       .priority(3.0D)
/*   52 */       .weight(1000.0D)
/*   53 */       .maxCooldown(0)
/*   54 */       .addFirstBehavior(
/*   55 */         CECombatBehaviors.Behavior.builder()
/*   56 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   57 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*   58 */         .custom(CombatCommon::isWrongWeapon)
/*   59 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*   60 */         .addExBehavior(CombatCommon::swapToMelee)))
/*      */ 
/*      */     
/*   63 */     .newBehaviorRoot(
/*   64 */       CECombatBehaviors.BehaviorRoot.builder()
/*   65 */       .priority(2.0D)
/*   66 */       .weight(70.0D)
/*   67 */       .maxCooldown(0)
/*   68 */       .addFirstBehavior(
/*   69 */         CECombatBehaviors.Behavior.builder()
/*   70 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   71 */         .custom(CombatCommon::canPerformEating)
/*   72 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   73 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*   76 */     .newBehaviorRoot(
/*   77 */       CECombatBehaviors.BehaviorRoot.builder()
/*   78 */       .priority(2.0D)
/*   79 */       .weight(100.0D)
/*   80 */       .maxCooldown(120)
/*   81 */       .addFirstBehavior(
/*   82 */         CECombatBehaviors.Behavior.builder()
/*   83 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   84 */         .custom(CombatCommon::canSwapToBow)
/*   85 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*   86 */         .withinDistance(7.0D, 14.0D)
/*   87 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*   88 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   90 */       .addFirstBehavior(
/*   91 */         CECombatBehaviors.Behavior.builder()
/*   92 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   93 */         .custom(CombatCommon::canSwapToBow)
/*   94 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*   95 */         .withinDistance(7.0D, 14.0D)
/*   96 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*   97 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*   99 */       .addFirstBehavior(
/*  100 */         CECombatBehaviors.Behavior.builder()
/*  101 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  102 */         .custom(CombatCommon::canSwapToBow)
/*  103 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  104 */         .withinDistance(7.0D, 14.0D)
/*  105 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  106 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  108 */       .addFirstBehavior(
/*  109 */         CECombatBehaviors.Behavior.builder()
/*  110 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  111 */         .custom(CombatCommon::canSwapToBow)
/*  112 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  113 */         .withinDistance(7.0D, 14.0D)
/*  114 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  115 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  118 */     .newBehaviorRoot(
/*  119 */       CECombatBehaviors.BehaviorRoot.builder()
/*  120 */       .priority(2.0D)
/*  121 */       .weight(80.0D)
/*  122 */       .maxCooldown(120)
/*  123 */       .addFirstBehavior(
/*  124 */         CECombatBehaviors.Behavior.builder()
/*  125 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  126 */         .custom(CombatCommon::canThrowEnderPearl)
/*  127 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  128 */         .withinDistance(7.0D, 48.0D)
/*  129 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  130 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  133 */     .newBehaviorRoot(
/*  134 */       CECombatBehaviors.BehaviorRoot.builder()
/*  135 */       .priority(1.0D)
/*  136 */       .weight(40.0D)
/*  137 */       .maxCooldown(20)
/*  138 */       .addFirstBehavior(
/*  139 */         CECombatBehaviors.Behavior.builder()
/*  140 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  141 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  142 */         .withinDistance(0.0D, 3.0D)
/*  143 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  144 */         .addNextBehavior(
/*  145 */           CECombatBehaviors.Behavior.builder()
/*  146 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  147 */           .custom(CombatCommon::canAttackWhileNotHealing)
/*  148 */           .withinDistance(0.0D, 3.0D)
/*  149 */           .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  150 */           .addNextBehavior(
/*  151 */             CECombatBehaviors.Behavior.builder()
/*  152 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  153 */             .custom(CombatCommon::canAttackWhileNotHealing)
/*  154 */             .withinDistance(0.0D, 3.0D)
/*  155 */             .animationBehavior(Animations.FIST_AUTO3, 0.0F))))
/*      */ 
/*      */ 
/*      */       
/*  159 */       .addFirstBehavior(
/*  160 */         CECombatBehaviors.Behavior.builder()
/*  161 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  162 */         .withinDistance(0.0D, 3.0D)
/*  163 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  164 */         .addNextBehavior(
/*  165 */           CECombatBehaviors.Behavior.builder()
/*  166 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  167 */           .withinDistance(0.0D, 3.0D)
/*  168 */           .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/*  169 */           .addNextBehavior(
/*  170 */             CECombatBehaviors.Behavior.builder()
/*  171 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  172 */             .withinDistance(0.0D, 4.0D)
/*  173 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  174 */             .addNextBehavior(
/*  175 */               CECombatBehaviors.Behavior.builder()
/*  176 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  177 */               .withinDistance(0.0D, 4.0D)
/*  178 */               .animationBehavior(Animations.FIST_DASH, 0.0F)
/*  179 */               .addNextBehavior(
/*  180 */                 CECombatBehaviors.Behavior.builder()
/*  181 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  182 */                 .withinDistance(0.0D, 5.0D)
/*  183 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  184 */                 .addNextBehavior(
/*  185 */                   CECombatBehaviors.Behavior.builder()
/*  186 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  187 */                   .withinDistance(0.0D, 5.0D)
/*  188 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  196 */       .addFirstBehavior(
/*  197 */         CECombatBehaviors.Behavior.builder()
/*  198 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  199 */         .withinDistance(0.0D, 3.0D)
/*  200 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  201 */         .addNextBehavior(
/*  202 */           CECombatBehaviors.Behavior.builder()
/*  203 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  204 */           .withinDistance(0.0D, 3.0D)
/*  205 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  206 */           .addNextBehavior(
/*  207 */             CECombatBehaviors.Behavior.builder()
/*  208 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  209 */             .withinDistance(0.0D, 4.0D)
/*  210 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  211 */             .addNextBehavior(
/*  212 */               CECombatBehaviors.Behavior.builder()
/*  213 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  214 */               .withinDistance(0.0D, 4.0D)
/*  215 */               .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/*  216 */               .addNextBehavior(
/*  217 */                 CECombatBehaviors.Behavior.builder()
/*  218 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  219 */                 .withinDistance(0.0D, 5.0D)
/*  220 */                 .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/*  221 */                 .addNextBehavior(
/*  222 */                   CECombatBehaviors.Behavior.builder()
/*  223 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  224 */                   .withinDistance(0.0D, 5.0D)
/*  225 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  226 */                   .addNextBehavior(
/*  227 */                     CECombatBehaviors.Behavior.builder()
/*  228 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  229 */                     .withinDistance(0.0D, 5.0D)
/*  230 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/*  231 */                     .addNextBehavior(
/*  232 */                       CECombatBehaviors.Behavior.builder()
/*  233 */                       .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  234 */                       .withinDistance(0.0D, 5.0D)
/*  235 */                       .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  245 */       .addFirstBehavior(
/*  246 */         CECombatBehaviors.Behavior.builder()
/*  247 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  248 */         .withinDistance(0.0D, 3.0D)
/*  249 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  250 */         .addNextBehavior(
/*  251 */           CECombatBehaviors.Behavior.builder()
/*  252 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  253 */           .withinDistance(0.0D, 3.0D)
/*  254 */           .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/*  255 */           .addNextBehavior(
/*  256 */             CECombatBehaviors.Behavior.builder()
/*  257 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  258 */             .withinDistance(0.0D, 4.0D)
/*  259 */             .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/*  260 */             .addNextBehavior(
/*  261 */               CECombatBehaviors.Behavior.builder()
/*  262 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  263 */               .withinDistance(0.0D, 4.0D)
/*  264 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  265 */               .addNextBehavior(
/*  266 */                 CECombatBehaviors.Behavior.builder()
/*  267 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  268 */                 .withinDistance(0.0D, 5.0D)
/*  269 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  270 */                 .addNextBehavior(
/*  271 */                   CECombatBehaviors.Behavior.builder()
/*  272 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  273 */                   .withinDistance(0.0D, 5.0D)
/*  274 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  275 */                   .addNextBehavior(
/*  276 */                     CECombatBehaviors.Behavior.builder()
/*  277 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  278 */                     .withinDistance(0.0D, 5.0D)
/*  279 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  288 */       .addFirstBehavior(
/*  289 */         CECombatBehaviors.Behavior.builder()
/*  290 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  291 */         .withinDistance(0.0D, 3.0D)
/*  292 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  293 */         .addNextBehavior(
/*  294 */           CECombatBehaviors.Behavior.builder()
/*  295 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  296 */           .withinDistance(0.0D, 3.0D)
/*  297 */           .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  298 */           .addNextBehavior(
/*  299 */             CECombatBehaviors.Behavior.builder()
/*  300 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  301 */             .withinDistance(0.0D, 4.0D)
/*  302 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  303 */             .addNextBehavior(
/*  304 */               CECombatBehaviors.Behavior.builder()
/*  305 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  306 */               .withinDistance(0.0D, 4.0D)
/*  307 */               .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/*  308 */               .addNextBehavior(
/*  309 */                 CECombatBehaviors.Behavior.builder()
/*  310 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  311 */                 .withinDistance(0.0D, 5.0D)
/*  312 */                 .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/*  313 */                 .addNextBehavior(
/*  314 */                   CECombatBehaviors.Behavior.builder()
/*  315 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  316 */                   .withinDistance(0.0D, 5.0D)
/*  317 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/*  318 */                   .addNextBehavior(
/*  319 */                     CECombatBehaviors.Behavior.builder()
/*  320 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  321 */                     .withinDistance(0.0D, 5.0D)
/*  322 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  331 */       .addFirstBehavior(
/*  332 */         CECombatBehaviors.Behavior.builder()
/*  333 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  334 */         .withinDistance(0.0D, 3.0D)
/*  335 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  336 */         .addNextBehavior(
/*  337 */           CECombatBehaviors.Behavior.builder()
/*  338 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  339 */           .withinDistance(0.0D, 3.0D)
/*  340 */           .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/*  341 */           .addNextBehavior(
/*  342 */             CECombatBehaviors.Behavior.builder()
/*  343 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  344 */             .withinDistance(0.0D, 4.0D)
/*  345 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  346 */             .addNextBehavior(
/*  347 */               CECombatBehaviors.Behavior.builder()
/*  348 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  349 */               .withinDistance(0.0D, 4.0D)
/*  350 */               .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F)
/*  351 */               .addNextBehavior(
/*  352 */                 CECombatBehaviors.Behavior.builder()
/*  353 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  354 */                 .withinDistance(0.0D, 5.0D)
/*  355 */                 .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)
/*  356 */                 .addNextBehavior(
/*  357 */                   CECombatBehaviors.Behavior.builder()
/*  358 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  359 */                   .withinDistance(0.0D, 5.0D)
/*  360 */                   .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/*  361 */                   .addNextBehavior(
/*  362 */                     CECombatBehaviors.Behavior.builder()
/*  363 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  364 */                     .withinDistance(0.0D, 5.0D)
/*  365 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
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
/*  376 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  377 */         .withinDistance(0.0D, 3.0D)
/*  378 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  379 */         .addNextBehavior(
/*  380 */           CECombatBehaviors.Behavior.builder()
/*  381 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  382 */           .withinDistance(0.0D, 3.0D)
/*  383 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/*  384 */           .addNextBehavior(
/*  385 */             CECombatBehaviors.Behavior.builder()
/*  386 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  387 */             .withinDistance(0.0D, 4.0D)
/*  388 */             .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  389 */             .addNextBehavior(
/*  390 */               CECombatBehaviors.Behavior.builder()
/*  391 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  392 */               .withinDistance(0.0D, 4.0D)
/*  393 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  394 */               .addNextBehavior(
/*  395 */                 CECombatBehaviors.Behavior.builder()
/*  396 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  397 */                 .withinDistance(0.0D, 5.0D)
/*  398 */                 .animationBehavior(Animations.FIST_DASH, 0.0F)
/*  399 */                 .addNextBehavior(
/*  400 */                   CECombatBehaviors.Behavior.builder()
/*  401 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  402 */                   .withinDistance(0.0D, 5.0D)
/*  403 */                   .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  404 */                   .addNextBehavior(
/*  405 */                     CECombatBehaviors.Behavior.builder()
/*  406 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  407 */                     .withinDistance(0.0D, 5.0D)
/*  408 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  417 */       .addFirstBehavior(
/*  418 */         CECombatBehaviors.Behavior.builder()
/*  419 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  420 */         .withinDistance(0.0D, 3.0D)
/*  421 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  422 */         .addNextBehavior(
/*  423 */           CECombatBehaviors.Behavior.builder()
/*  424 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  425 */           .withinDistance(0.0D, 3.0D)
/*  426 */           .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  427 */           .addNextBehavior(
/*  428 */             CECombatBehaviors.Behavior.builder()
/*  429 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  430 */             .withinDistance(0.0D, 4.0D)
/*  431 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  432 */             .addNextBehavior(
/*  433 */               CECombatBehaviors.Behavior.builder()
/*  434 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  435 */               .withinDistance(0.0D, 4.0D)
/*  436 */               .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/*  437 */               .addNextBehavior(
/*  438 */                 CECombatBehaviors.Behavior.builder()
/*  439 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  440 */                 .withinDistance(0.0D, 5.0D)
/*  441 */                 .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/*  442 */                 .addNextBehavior(
/*  443 */                   CECombatBehaviors.Behavior.builder()
/*  444 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  445 */                   .withinDistance(0.0D, 5.0D)
/*  446 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  447 */                   .addNextBehavior(
/*  448 */                     CECombatBehaviors.Behavior.builder()
/*  449 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  450 */                     .withinDistance(0.0D, 5.0D)
/*  451 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  460 */       .addFirstBehavior(
/*  461 */         CECombatBehaviors.Behavior.builder()
/*  462 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  463 */         .withinDistance(0.0D, 3.0D)
/*  464 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  465 */         .addNextBehavior(
/*  466 */           CECombatBehaviors.Behavior.builder()
/*  467 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  468 */           .withinDistance(0.0D, 3.0D)
/*  469 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  470 */           .addNextBehavior(
/*  471 */             CECombatBehaviors.Behavior.builder()
/*  472 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  473 */             .withinDistance(0.0D, 4.0D)
/*  474 */             .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/*  475 */             .addNextBehavior(
/*  476 */               CECombatBehaviors.Behavior.builder()
/*  477 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  478 */               .withinDistance(0.0D, 4.0D)
/*  479 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  480 */               .addNextBehavior(
/*  481 */                 CECombatBehaviors.Behavior.builder()
/*  482 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  483 */                 .withinDistance(0.0D, 5.0D)
/*  484 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  485 */                 .addNextBehavior(
/*  486 */                   CECombatBehaviors.Behavior.builder()
/*  487 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  488 */                   .withinDistance(0.0D, 5.0D)
/*  489 */                   .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/*  490 */                   .addNextBehavior(
/*  491 */                     CECombatBehaviors.Behavior.builder()
/*  492 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  493 */                     .withinDistance(0.0D, 5.0D)
/*  494 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/*  495 */                     .addNextBehavior(
/*  496 */                       CECombatBehaviors.Behavior.builder()
/*  497 */                       .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  498 */                       .withinDistance(0.0D, 5.0D)
/*  499 */                       .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  509 */       .addFirstBehavior(
/*  510 */         CECombatBehaviors.Behavior.builder()
/*  511 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  512 */         .withinDistance(0.0D, 3.0D)
/*  513 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  514 */         .addNextBehavior(
/*  515 */           CECombatBehaviors.Behavior.builder()
/*  516 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  517 */           .withinDistance(0.0D, 3.0D)
/*  518 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/*  519 */           .addNextBehavior(
/*  520 */             CECombatBehaviors.Behavior.builder()
/*  521 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  522 */             .withinDistance(0.0D, 4.0D)
/*  523 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  524 */             .addNextBehavior(
/*  525 */               CECombatBehaviors.Behavior.builder()
/*  526 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  527 */               .withinDistance(0.0D, 4.0D)
/*  528 */               .animationBehavior(Animations.FIST_DASH, 0.0F)
/*  529 */               .addNextBehavior(
/*  530 */                 CECombatBehaviors.Behavior.builder()
/*  531 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  532 */                 .withinDistance(0.0D, 5.0D)
/*  533 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  534 */                 .addNextBehavior(
/*  535 */                   CECombatBehaviors.Behavior.builder()
/*  536 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  537 */                   .withinDistance(0.0D, 5.0D)
/*  538 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  539 */                   .addNextBehavior(
/*  540 */                     CECombatBehaviors.Behavior.builder()
/*  541 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  542 */                     .withinDistance(0.0D, 5.0D)
/*  543 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  552 */       .addFirstBehavior(
/*  553 */         CECombatBehaviors.Behavior.builder()
/*  554 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  555 */         .withinDistance(0.0D, 3.0D)
/*  556 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  557 */         .addNextBehavior(
/*  558 */           CECombatBehaviors.Behavior.builder()
/*  559 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  560 */           .withinDistance(0.0D, 3.0D)
/*  561 */           .animationBehavior(Animations.FIST_DASH, 0.0F)
/*  562 */           .addNextBehavior(
/*  563 */             CECombatBehaviors.Behavior.builder()
/*  564 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  565 */             .withinDistance(0.0D, 4.0D)
/*  566 */             .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/*  567 */             .addNextBehavior(
/*  568 */               CECombatBehaviors.Behavior.builder()
/*  569 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  570 */               .withinDistance(0.0D, 4.0D)
/*  571 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  572 */               .addNextBehavior(
/*  573 */                 CECombatBehaviors.Behavior.builder()
/*  574 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  575 */                 .withinDistance(0.0D, 5.0D)
/*  576 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  577 */                 .addNextBehavior(
/*  578 */                   CECombatBehaviors.Behavior.builder()
/*  579 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  580 */                   .withinDistance(0.0D, 5.0D)
/*  581 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  582 */                   .addNextBehavior(
/*  583 */                     CECombatBehaviors.Behavior.builder()
/*  584 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  585 */                     .withinDistance(0.0D, 5.0D)
/*  586 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  595 */       .addFirstBehavior(
/*  596 */         CECombatBehaviors.Behavior.builder()
/*  597 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  598 */         .withinDistance(0.0D, 3.0D)
/*  599 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  600 */         .addNextBehavior(
/*  601 */           CECombatBehaviors.Behavior.builder()
/*  602 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  603 */           .withinDistance(0.0D, 3.0D)
/*  604 */           .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F)
/*  605 */           .addNextBehavior(
/*  606 */             CECombatBehaviors.Behavior.builder()
/*  607 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  608 */             .withinDistance(0.0D, 4.0D)
/*  609 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  610 */             .addNextBehavior(
/*  611 */               CECombatBehaviors.Behavior.builder()
/*  612 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  613 */               .withinDistance(0.0D, 4.0D)
/*  614 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  615 */               .addNextBehavior(
/*  616 */                 CECombatBehaviors.Behavior.builder()
/*  617 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  618 */                 .withinDistance(0.0D, 5.0D)
/*  619 */                 .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)
/*  620 */                 .addNextBehavior(
/*  621 */                   CECombatBehaviors.Behavior.builder()
/*  622 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  623 */                   .withinDistance(0.0D, 5.0D)
/*  624 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  625 */                   .addNextBehavior(
/*  626 */                     CECombatBehaviors.Behavior.builder()
/*  627 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  628 */                     .withinDistance(0.0D, 5.0D)
/*  629 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  638 */       .addFirstBehavior(
/*  639 */         CECombatBehaviors.Behavior.builder()
/*  640 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  641 */         .withinDistance(0.0D, 3.0D)
/*  642 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  643 */         .addNextBehavior(
/*  644 */           CECombatBehaviors.Behavior.builder()
/*  645 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  646 */           .withinDistance(0.0D, 3.0D)
/*  647 */           .animationBehavior(AVAnimations.FIST_DASH, 0.0F)
/*  648 */           .addNextBehavior(
/*  649 */             CECombatBehaviors.Behavior.builder()
/*  650 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  651 */             .withinDistance(0.0D, 4.0D)
/*  652 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  653 */             .addNextBehavior(
/*  654 */               CECombatBehaviors.Behavior.builder()
/*  655 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  656 */               .withinDistance(0.0D, 4.0D)
/*  657 */               .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/*  658 */               .addNextBehavior(
/*  659 */                 CECombatBehaviors.Behavior.builder()
/*  660 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  661 */                 .withinDistance(0.0D, 5.0D)
/*  662 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  663 */                 .addNextBehavior(
/*  664 */                   CECombatBehaviors.Behavior.builder()
/*  665 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  666 */                   .withinDistance(0.0D, 5.0D)
/*  667 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  668 */                   .addNextBehavior(
/*  669 */                     CECombatBehaviors.Behavior.builder()
/*  670 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  671 */                     .withinDistance(0.0D, 5.0D)
/*  672 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/*  673 */                     .addNextBehavior(
/*  674 */                       CECombatBehaviors.Behavior.builder()
/*  675 */                       .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  676 */                       .withinDistance(0.0D, 5.0D)
/*  677 */                       .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  687 */       .addFirstBehavior(
/*  688 */         CECombatBehaviors.Behavior.builder()
/*  689 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  690 */         .withinDistance(0.0D, 3.0D)
/*  691 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  692 */         .addNextBehavior(
/*  693 */           CECombatBehaviors.Behavior.builder()
/*  694 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  695 */           .withinDistance(0.0D, 3.0D)
/*  696 */           .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  697 */           .addNextBehavior(
/*  698 */             CECombatBehaviors.Behavior.builder()
/*  699 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  700 */             .withinDistance(0.0D, 4.0D)
/*  701 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  702 */             .addNextBehavior(
/*  703 */               CECombatBehaviors.Behavior.builder()
/*  704 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  705 */               .withinDistance(0.0D, 4.0D)
/*  706 */               .animationBehavior(Animations.FIST_DASH, 0.0F)
/*  707 */               .addNextBehavior(
/*  708 */                 CECombatBehaviors.Behavior.builder()
/*  709 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  710 */                 .withinDistance(0.0D, 5.0D)
/*  711 */                 .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/*  712 */                 .addNextBehavior(
/*  713 */                   CECombatBehaviors.Behavior.builder()
/*  714 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  715 */                   .withinDistance(0.0D, 5.0D)
/*  716 */                   .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)
/*  717 */                   .addNextBehavior(
/*  718 */                     CECombatBehaviors.Behavior.builder()
/*  719 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  720 */                     .withinDistance(0.0D, 5.0D)
/*  721 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  730 */       .addFirstBehavior(
/*  731 */         CECombatBehaviors.Behavior.builder()
/*  732 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  733 */         .withinDistance(0.0D, 3.0D)
/*  734 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  735 */         .addNextBehavior(
/*  736 */           CECombatBehaviors.Behavior.builder()
/*  737 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  738 */           .withinDistance(0.0D, 3.0D)
/*  739 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  740 */           .addNextBehavior(
/*  741 */             CECombatBehaviors.Behavior.builder()
/*  742 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  743 */             .withinDistance(0.0D, 4.0D)
/*  744 */             .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  745 */             .addNextBehavior(
/*  746 */               CECombatBehaviors.Behavior.builder()
/*  747 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  748 */               .withinDistance(0.0D, 4.0D)
/*  749 */               .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  750 */               .addNextBehavior(
/*  751 */                 CECombatBehaviors.Behavior.builder()
/*  752 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  753 */                 .withinDistance(0.0D, 5.0D)
/*  754 */                 .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F)
/*  755 */                 .addNextBehavior(
/*  756 */                   CECombatBehaviors.Behavior.builder()
/*  757 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  758 */                   .withinDistance(0.0D, 5.0D)
/*  759 */                   .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F)
/*  760 */                   .addNextBehavior(
/*  761 */                     CECombatBehaviors.Behavior.builder()
/*  762 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  763 */                     .withinDistance(0.0D, 5.0D)
/*  764 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  773 */       .addFirstBehavior(
/*  774 */         CECombatBehaviors.Behavior.builder()
/*  775 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  776 */         .withinDistance(0.0D, 3.0D)
/*  777 */         .animationBehavior(Animations.FIST_AUTO1, 0.0F)
/*  778 */         .addNextBehavior(
/*  779 */           CECombatBehaviors.Behavior.builder()
/*  780 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  781 */           .withinDistance(0.0D, 3.0D)
/*  782 */           .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/*  783 */           .addNextBehavior(
/*  784 */             CECombatBehaviors.Behavior.builder()
/*  785 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  786 */             .withinDistance(0.0D, 4.0D)
/*  787 */             .animationBehavior(Animations.FIST_AUTO2, 0.0F)
/*  788 */             .addNextBehavior(
/*  789 */               CECombatBehaviors.Behavior.builder()
/*  790 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  791 */               .withinDistance(0.0D, 4.0D)
/*  792 */               .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  793 */               .addNextBehavior(
/*  794 */                 CECombatBehaviors.Behavior.builder()
/*  795 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  796 */                 .withinDistance(0.0D, 5.0D)
/*  797 */                 .animationBehavior(Animations.FIST_DASH, 0.0F)
/*  798 */                 .addNextBehavior(
/*  799 */                   CECombatBehaviors.Behavior.builder()
/*  800 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  801 */                   .withinDistance(0.0D, 5.0D)
/*  802 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  803 */                   .addNextBehavior(
/*  804 */                     CECombatBehaviors.Behavior.builder()
/*  805 */                     .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  806 */                     .withinDistance(0.0D, 5.0D)
/*  807 */                     .animationBehavior(Animations.FIST_AUTO3, 0.0F)
/*  808 */                     .addNextBehavior(
/*  809 */                       CECombatBehaviors.Behavior.builder()
/*  810 */                       .custom(CombatCommon::canPerformNormalAttackLogic).custom(CombatCommon::canAttackWhileNotHealing)
/*  811 */                       .withinDistance(0.0D, 5.0D)
/*  812 */                       .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  822 */     .newBehaviorRoot(
/*  823 */       CECombatBehaviors.BehaviorRoot.builder()
/*  824 */       .priority(1.0D)
/*  825 */       .weight(20.0D)
/*  826 */       .maxCooldown(100)
/*  827 */       .addFirstBehavior(
/*  828 */         CECombatBehaviors.Behavior.builder()
/*  829 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  830 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  831 */         .withinDistance(0.0D, 3.0D)
/*  832 */         .animationBehavior(AVAnimations.FIST_LEFT, 0.0F)
/*  833 */         .addNextBehavior(
/*  834 */           CECombatBehaviors.Behavior.builder()
/*  835 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  836 */           .custom(CombatCommon::canAttackWhileNotHealing)
/*  837 */           .withinDistance(0.0D, 3.0D)
/*  838 */           .animationBehavior(AVAnimations.FIST_UP, 0.0F)
/*  839 */           .addNextBehavior(
/*  840 */             CECombatBehaviors.Behavior.builder()
/*  841 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  842 */             .custom(CombatCommon::canAttackWhileNotHealing)
/*  843 */             .withinDistance(0.0D, 3.0D)
/*  844 */             .animationBehavior(AVAnimations.FIST_DASH, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  849 */     .newBehaviorRoot(
/*  850 */       CECombatBehaviors.BehaviorRoot.builder()
/*  851 */       .priority(1.0D)
/*  852 */       .weight(10.0D)
/*  853 */       .maxCooldown(100)
/*  854 */       .addFirstBehavior(
/*  855 */         CECombatBehaviors.Behavior.builder()
/*  856 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  857 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  858 */         .withinDistance(0.0D, 3.0D)
/*  859 */         .animationBehavior(AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F))
/*      */       
/*  861 */       .addFirstBehavior(
/*  862 */         CECombatBehaviors.Behavior.builder()
/*  863 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  864 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  865 */         .withinDistance(0.0D, 3.0D)
/*  866 */         .animationBehavior(AVAnimations.WHIRLWIND_KICK, 0.0F))
/*      */       
/*  868 */       .addFirstBehavior(
/*  869 */         CECombatBehaviors.Behavior.builder()
/*  870 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  871 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  872 */         .withinDistance(0.0D, 3.0D)
/*  873 */         .animationBehavior(Animations.FIST_DASH, 0.0F))
/*      */       
/*  875 */       .addFirstBehavior(
/*  876 */         CECombatBehaviors.Behavior.builder()
/*  877 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  878 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  879 */         .withinDistance(0.0D, 3.0D)
/*  880 */         .animationBehavior(Animations.FIST_AIR_SLASH, 0.0F))
/*      */       
/*  882 */       .addFirstBehavior(
/*  883 */         CECombatBehaviors.Behavior.builder()
/*  884 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  885 */         .withinDistance(0.0D, 3.0D)
/*  886 */         .animationBehavior(Animations.RELENTLESS_COMBO, 0.0F)))
/*      */ 
/*      */     
/*  889 */     .newBehaviorRoot(
/*  890 */       CECombatBehaviors.BehaviorRoot.builder()
/*  891 */       .priority(1.0D)
/*  892 */       .weight(10.0D)
/*  893 */       .maxCooldown(40)
/*  894 */       .addFirstBehavior(
/*  895 */         CECombatBehaviors.Behavior.builder()
/*  896 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  897 */         .withinDistance(0.0D, 3.0D)
/*  898 */         .custom(CombatCommon::canThrowEnderPearl)
/*  899 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  900 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  901 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  904 */     .newBehaviorRoot(
/*  905 */       CECombatBehaviors.BehaviorRoot.builder()
/*  906 */       .priority(1.0D)
/*  907 */       .weight(2.0D)
/*  908 */       .maxCooldown(100)
/*  909 */       .addFirstBehavior(
/*  910 */         CECombatBehaviors.Behavior.builder()
/*  911 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  912 */         .withinDistance(0.0D, 3.0D)
/*  913 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  914 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  916 */       .addFirstBehavior(
/*  917 */         CECombatBehaviors.Behavior.builder()
/*  918 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  919 */         .withinDistance(0.0D, 3.0D)
/*  920 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  921 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  923 */       .addFirstBehavior(
/*  924 */         CECombatBehaviors.Behavior.builder()
/*  925 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  926 */         .withinDistance(0.0D, 3.0D)
/*  927 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  928 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  930 */       .addFirstBehavior(
/*  931 */         CECombatBehaviors.Behavior.builder()
/*  932 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  933 */         .withinDistance(0.0D, 3.0D)
/*  934 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  935 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  937 */       .addFirstBehavior(
/*  938 */         CECombatBehaviors.Behavior.builder()
/*  939 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  940 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  941 */         .withinDistance(0.0D, 3.0D)
/*  942 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  944 */       .addFirstBehavior(
/*  945 */         CECombatBehaviors.Behavior.builder()
/*  946 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  947 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  948 */         .withinDistance(0.0D, 3.0D)
/*  949 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  951 */       .addFirstBehavior(
/*  952 */         CECombatBehaviors.Behavior.builder()
/*  953 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  954 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  955 */         .withinDistance(0.0D, 3.0D)
/*  956 */         .animationBehavior(EFKickAnimations.KICK_COMBO, 0.0F)))
/*      */ 
/*      */     
/*  959 */     .newBehaviorRoot(
/*  960 */       CECombatBehaviors.BehaviorRoot.builder()
/*  961 */       .priority(1.0D)
/*  962 */       .weight(10.0D)
/*  963 */       .addFirstBehavior(
/*  964 */         CECombatBehaviors.Behavior.builder()
/*  965 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  966 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  967 */         .withinDistance(0.0D, 3.0D)
/*  968 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/*  970 */       .addFirstBehavior(
/*  971 */         CECombatBehaviors.Behavior.builder()
/*  972 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  973 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  974 */         .withinDistance(0.0D, 3.0D)
/*  975 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/*  977 */       .addFirstBehavior(
/*  978 */         CECombatBehaviors.Behavior.builder()
/*  979 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  980 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  981 */         .withinDistance(0.0D, 3.0D)
/*  982 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))
/*      */       
/*  984 */       .addFirstBehavior(
/*  985 */         CECombatBehaviors.Behavior.builder()
/*  986 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  987 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  988 */         .withinDistance(0.0D, 3.0D)
/*  989 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))
/*      */ 
/*      */     
/*  992 */     .newBehaviorRoot(
/*  993 */       CECombatBehaviors.BehaviorRoot.builder()
/*  994 */       .priority(1.0D)
/*  995 */       .weight(40.0D)
/*  996 */       .maxCooldown(160)
/*  997 */       .addFirstBehavior(
/*  998 */         CECombatBehaviors.Behavior.builder()
/*  999 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1000 */         .custom(CombatCommon::canJump)
/* 1001 */         .withinDistance(5.0D, 14.0D)
/* 1002 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1003 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\NpcFist.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */