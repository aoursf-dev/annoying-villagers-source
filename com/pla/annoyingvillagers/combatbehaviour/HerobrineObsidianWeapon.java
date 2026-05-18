/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.efkick.gameasset.EFKickAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HerobrineObsidianWeapon
/*      */ {
/*   15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> OBSIDIAN_WEAPON = CECombatBehaviors.builder()
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
/*   36 */         .custom(CombatCommon::canEscape)
/*   37 */         .withinDistance(0.0D, 8.0D)
/*   38 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   39 */         .addExBehavior(CombatCommon::performEscapeRunAway)))
/*      */ 
/*      */     
/*   42 */     .newBehaviorRoot(
/*   43 */       CECombatBehaviors.BehaviorRoot.builder()
/*   44 */       .priority(3.0D)
/*   45 */       .weight(100.0D)
/*   46 */       .maxCooldown(120)
/*   47 */       .addFirstBehavior(
/*   48 */         CECombatBehaviors.Behavior.builder()
/*   49 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   50 */         .custom(CombatCommon::canSwitchWeapon)
/*   51 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*   52 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*   54 */       .addFirstBehavior(
/*   55 */         CECombatBehaviors.Behavior.builder()
/*   56 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   57 */         .custom(CombatCommon::canSwitchWeapon)
/*   58 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*   59 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*   62 */     .newBehaviorRoot(
/*   63 */       CECombatBehaviors.BehaviorRoot.builder()
/*   64 */       .priority(2.0D)
/*   65 */       .weight(70.0D)
/*   66 */       .maxCooldown(0)
/*   67 */       .addFirstBehavior(
/*   68 */         CECombatBehaviors.Behavior.builder()
/*   69 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   70 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   71 */         .custom(HerobrineCommon::canPerformHealing)
/*   72 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*   73 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*      */ 
/*      */     
/*   76 */     .newBehaviorRoot(
/*   77 */       CECombatBehaviors.BehaviorRoot.builder()
/*   78 */       .priority(2.0D)
/*   79 */       .weight(70.0D)
/*   80 */       .maxCooldown(100)
/*   81 */       .addFirstBehavior(
/*   82 */         CECombatBehaviors.Behavior.builder()
/*   83 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   84 */         .custom(HerobrineCommon::canSummonDarkOb)
/*   85 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*   86 */         .addExBehavior(HerobrineCommon::performSummonDarkOb)))
/*      */ 
/*      */     
/*   89 */     .newBehaviorRoot(
/*   90 */       CECombatBehaviors.BehaviorRoot.builder()
/*   91 */       .priority(1.0D)
/*   92 */       .weight(15.0D)
/*   93 */       .maxCooldown(600)
/*   94 */       .addFirstBehavior(
/*   95 */         CECombatBehaviors.Behavior.builder()
/*   96 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   97 */         .custom(HerobrineCommon::canChangeToSecondForm)
/*   98 */         .withinDistance(0.0D, 8.0D)
/*   99 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_ONEHAND_RELOAD, 0.0F)
/*  100 */         .addExBehavior(HerobrineCommon::changeToSecondForm)))
/*      */ 
/*      */     
/*  103 */     .newBehaviorRoot(
/*  104 */       CECombatBehaviors.BehaviorRoot.builder()
/*  105 */       .priority(1.0D)
/*  106 */       .weight(40.0D)
/*  107 */       .maxCooldown(20)
/*  108 */       .addFirstBehavior(
/*  109 */         CECombatBehaviors.Behavior.builder()
/*  110 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  111 */         .withinDistance(0.0D, 4.0D)
/*  112 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  113 */         .addNextBehavior(
/*  114 */           CECombatBehaviors.Behavior.builder()
/*  115 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  116 */           .withinDistance(0.0D, 5.0D)
/*  117 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  118 */           .addNextBehavior(
/*  119 */             CECombatBehaviors.Behavior.builder()
/*  120 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  121 */             .withinDistance(0.0D, 5.0D)
/*  122 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  123 */             .addNextBehavior(
/*  124 */               CECombatBehaviors.Behavior.builder()
/*  125 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  126 */               .withinDistance(0.0D, 6.0D)
/*  127 */               .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  128 */               .addNextBehavior(
/*  129 */                 CECombatBehaviors.Behavior.builder()
/*  130 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  131 */                 .withinDistance(0.0D, 6.0D)
/*  132 */                 .animationBehavior(AVAnimations.OBSIDIAN_BIPED_LANDING, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  138 */       .addFirstBehavior(
/*  139 */         CECombatBehaviors.Behavior.builder()
/*  140 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  141 */         .withinDistance(0.0D, 3.0D)
/*  142 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  143 */         .addNextBehavior(
/*  144 */           CECombatBehaviors.Behavior.builder()
/*  145 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  146 */           .withinDistance(0.0D, 4.0D)
/*  147 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  148 */           .addNextBehavior(
/*  149 */             CECombatBehaviors.Behavior.builder()
/*  150 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  151 */             .withinDistance(0.0D, 5.0D)
/*  152 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  153 */             .addNextBehavior(
/*  154 */               CECombatBehaviors.Behavior.builder()
/*  155 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  156 */               .withinDistance(0.0D, 5.0D)
/*  157 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  158 */               .addNextBehavior(
/*  159 */                 CECombatBehaviors.Behavior.builder()
/*  160 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  161 */                 .withinDistance(0.0D, 6.0D)
/*  162 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
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
/*  173 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  174 */         .addNextBehavior(
/*  175 */           CECombatBehaviors.Behavior.builder()
/*  176 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  177 */           .withinDistance(0.0D, 4.0D)
/*  178 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  179 */           .addNextBehavior(
/*  180 */             CECombatBehaviors.Behavior.builder()
/*  181 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  182 */             .withinDistance(0.0D, 5.0D)
/*  183 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  184 */             .addNextBehavior(
/*  185 */               CECombatBehaviors.Behavior.builder()
/*  186 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  187 */               .withinDistance(0.0D, 5.0D)
/*  188 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  189 */               .addNextBehavior(
/*  190 */                 CECombatBehaviors.Behavior.builder()
/*  191 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  192 */                 .withinDistance(0.0D, 6.0D)
/*  193 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  200 */       .addFirstBehavior(
/*  201 */         CECombatBehaviors.Behavior.builder()
/*  202 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  203 */         .withinDistance(0.0D, 3.0D)
/*  204 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  205 */         .addNextBehavior(
/*  206 */           CECombatBehaviors.Behavior.builder()
/*  207 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  208 */           .withinDistance(0.0D, 4.0D)
/*  209 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  210 */           .addNextBehavior(
/*  211 */             CECombatBehaviors.Behavior.builder()
/*  212 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  213 */             .withinDistance(0.0D, 5.0D)
/*  214 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  215 */             .addNextBehavior(
/*  216 */               CECombatBehaviors.Behavior.builder()
/*  217 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  218 */               .withinDistance(0.0D, 5.0D)
/*  219 */               .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  220 */               .addNextBehavior(
/*  221 */                 CECombatBehaviors.Behavior.builder()
/*  222 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  223 */                 .withinDistance(0.0D, 6.0D)
/*  224 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  231 */       .addFirstBehavior(
/*  232 */         CECombatBehaviors.Behavior.builder()
/*  233 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  234 */         .withinDistance(0.0D, 3.0D)
/*  235 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  236 */         .addNextBehavior(
/*  237 */           CECombatBehaviors.Behavior.builder()
/*  238 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  239 */           .withinDistance(0.0D, 4.0D)
/*  240 */           .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  241 */           .addNextBehavior(
/*  242 */             CECombatBehaviors.Behavior.builder()
/*  243 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  244 */             .withinDistance(0.0D, 5.0D)
/*  245 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  246 */             .addNextBehavior(
/*  247 */               CECombatBehaviors.Behavior.builder()
/*  248 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  249 */               .withinDistance(0.0D, 5.0D)
/*  250 */               .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  251 */               .addNextBehavior(
/*  252 */                 CECombatBehaviors.Behavior.builder()
/*  253 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  254 */                 .withinDistance(0.0D, 6.0D)
/*  255 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  262 */       .addFirstBehavior(
/*  263 */         CECombatBehaviors.Behavior.builder()
/*  264 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  265 */         .withinDistance(0.0D, 3.0D)
/*  266 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  267 */         .addNextBehavior(
/*  268 */           CECombatBehaviors.Behavior.builder()
/*  269 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  270 */           .withinDistance(0.0D, 4.0D)
/*  271 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  272 */           .addNextBehavior(
/*  273 */             CECombatBehaviors.Behavior.builder()
/*  274 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  275 */             .withinDistance(0.0D, 5.0D)
/*  276 */             .animationBehavior(AVAnimations.OBSIDIAN_BIPED_LANDING, 0.0F)
/*  277 */             .addNextBehavior(
/*  278 */               CECombatBehaviors.Behavior.builder()
/*  279 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  280 */               .withinDistance(0.0D, 5.0D)
/*  281 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  282 */               .addNextBehavior(
/*  283 */                 CECombatBehaviors.Behavior.builder()
/*  284 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  285 */                 .withinDistance(0.0D, 6.0D)
/*  286 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  295 */       .addFirstBehavior(
/*  296 */         CECombatBehaviors.Behavior.builder()
/*  297 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  298 */         .withinDistance(0.0D, 3.0D)
/*  299 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  300 */         .addNextBehavior(
/*  301 */           CECombatBehaviors.Behavior.builder()
/*  302 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  303 */           .withinDistance(0.0D, 4.0D)
/*  304 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  305 */           .addNextBehavior(
/*  306 */             CECombatBehaviors.Behavior.builder()
/*  307 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  308 */             .withinDistance(0.0D, 5.0D)
/*  309 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  310 */             .addNextBehavior(
/*  311 */               CECombatBehaviors.Behavior.builder()
/*  312 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  313 */               .withinDistance(0.0D, 5.0D)
/*  314 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  315 */               .addNextBehavior(
/*  316 */                 CECombatBehaviors.Behavior.builder()
/*  317 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  318 */                 .withinDistance(0.0D, 6.0D)
/*  319 */                 .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  326 */       .addFirstBehavior(
/*  327 */         CECombatBehaviors.Behavior.builder()
/*  328 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  329 */         .withinDistance(0.0D, 3.0D)
/*  330 */         .animationBehavior(AVAnimations.OBSIDIAN_BIPED_LANDING, 0.0F)
/*  331 */         .addNextBehavior(
/*  332 */           CECombatBehaviors.Behavior.builder()
/*  333 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  334 */           .withinDistance(0.0D, 4.0D)
/*  335 */           .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  336 */           .addNextBehavior(
/*  337 */             CECombatBehaviors.Behavior.builder()
/*  338 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  339 */             .withinDistance(0.0D, 5.0D)
/*  340 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  341 */             .addNextBehavior(
/*  342 */               CECombatBehaviors.Behavior.builder()
/*  343 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  344 */               .withinDistance(0.0D, 5.0D)
/*  345 */               .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  346 */               .addNextBehavior(
/*  347 */                 CECombatBehaviors.Behavior.builder()
/*  348 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  349 */                 .withinDistance(0.0D, 6.0D)
/*  350 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  357 */       .addFirstBehavior(
/*  358 */         CECombatBehaviors.Behavior.builder()
/*  359 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  360 */         .withinDistance(0.0D, 3.0D)
/*  361 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  362 */         .addNextBehavior(
/*  363 */           CECombatBehaviors.Behavior.builder()
/*  364 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  365 */           .withinDistance(0.0D, 4.0D)
/*  366 */           .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  367 */           .addNextBehavior(
/*  368 */             CECombatBehaviors.Behavior.builder()
/*  369 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  370 */             .withinDistance(0.0D, 5.0D)
/*  371 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  372 */             .addNextBehavior(
/*  373 */               CECombatBehaviors.Behavior.builder()
/*  374 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  375 */               .withinDistance(0.0D, 5.0D)
/*  376 */               .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  377 */               .addNextBehavior(
/*  378 */                 CECombatBehaviors.Behavior.builder()
/*  379 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  380 */                 .withinDistance(0.0D, 6.0D)
/*  381 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  388 */       .addFirstBehavior(
/*  389 */         CECombatBehaviors.Behavior.builder()
/*  390 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  391 */         .withinDistance(0.0D, 3.0D)
/*  392 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  393 */         .addNextBehavior(
/*  394 */           CECombatBehaviors.Behavior.builder()
/*  395 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  396 */           .withinDistance(0.0D, 4.0D)
/*  397 */           .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  398 */           .addNextBehavior(
/*  399 */             CECombatBehaviors.Behavior.builder()
/*  400 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  401 */             .withinDistance(0.0D, 5.0D)
/*  402 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  403 */             .addNextBehavior(
/*  404 */               CECombatBehaviors.Behavior.builder()
/*  405 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  406 */               .withinDistance(0.0D, 5.0D)
/*  407 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  408 */               .addNextBehavior(
/*  409 */                 CECombatBehaviors.Behavior.builder()
/*  410 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  411 */                 .withinDistance(0.0D, 6.0D)
/*  412 */                 .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  419 */       .addFirstBehavior(
/*  420 */         CECombatBehaviors.Behavior.builder()
/*  421 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  422 */         .withinDistance(0.0D, 3.0D)
/*  423 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  424 */         .addNextBehavior(
/*  425 */           CECombatBehaviors.Behavior.builder()
/*  426 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  427 */           .withinDistance(0.0D, 4.0D)
/*  428 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  429 */           .addNextBehavior(
/*  430 */             CECombatBehaviors.Behavior.builder()
/*  431 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  432 */             .withinDistance(0.0D, 5.0D)
/*  433 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  434 */             .addNextBehavior(
/*  435 */               CECombatBehaviors.Behavior.builder()
/*  436 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  437 */               .withinDistance(0.0D, 5.0D)
/*  438 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  439 */               .addNextBehavior(
/*  440 */                 CECombatBehaviors.Behavior.builder()
/*  441 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  442 */                 .withinDistance(0.0D, 6.0D)
/*  443 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  452 */       .addFirstBehavior(
/*  453 */         CECombatBehaviors.Behavior.builder()
/*  454 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  455 */         .withinDistance(0.0D, 3.0D)
/*  456 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  457 */         .addNextBehavior(
/*  458 */           CECombatBehaviors.Behavior.builder()
/*  459 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  460 */           .withinDistance(0.0D, 4.0D)
/*  461 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  462 */           .addNextBehavior(
/*  463 */             CECombatBehaviors.Behavior.builder()
/*  464 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  465 */             .withinDistance(0.0D, 5.0D)
/*  466 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  467 */             .addNextBehavior(
/*  468 */               CECombatBehaviors.Behavior.builder()
/*  469 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  470 */               .withinDistance(0.0D, 5.0D)
/*  471 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  472 */               .addNextBehavior(
/*  473 */                 CECombatBehaviors.Behavior.builder()
/*  474 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  475 */                 .withinDistance(0.0D, 6.0D)
/*  476 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  483 */       .addFirstBehavior(
/*  484 */         CECombatBehaviors.Behavior.builder()
/*  485 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */         .withinDistance(0.0D, 3.0D)
/*  487 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  488 */         .addNextBehavior(
/*  489 */           CECombatBehaviors.Behavior.builder()
/*  490 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  491 */           .withinDistance(0.0D, 4.0D)
/*  492 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  493 */           .addNextBehavior(
/*  494 */             CECombatBehaviors.Behavior.builder()
/*  495 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  496 */             .withinDistance(0.0D, 5.0D)
/*  497 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  498 */             .addNextBehavior(
/*  499 */               CECombatBehaviors.Behavior.builder()
/*  500 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  501 */               .withinDistance(0.0D, 5.0D)
/*  502 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  503 */               .addNextBehavior(
/*  504 */                 CECombatBehaviors.Behavior.builder()
/*  505 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  506 */                 .withinDistance(0.0D, 6.0D)
/*  507 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  514 */       .addFirstBehavior(
/*  515 */         CECombatBehaviors.Behavior.builder()
/*  516 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  517 */         .withinDistance(0.0D, 3.0D)
/*  518 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  519 */         .addNextBehavior(
/*  520 */           CECombatBehaviors.Behavior.builder()
/*  521 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  522 */           .withinDistance(0.0D, 4.0D)
/*  523 */           .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  524 */           .addNextBehavior(
/*  525 */             CECombatBehaviors.Behavior.builder()
/*  526 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  527 */             .withinDistance(0.0D, 5.0D)
/*  528 */             .animationBehavior(AVAnimations.OBSIDIAN_BIPED_LANDING, 0.0F)
/*  529 */             .addNextBehavior(
/*  530 */               CECombatBehaviors.Behavior.builder()
/*  531 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  532 */               .withinDistance(0.0D, 5.0D)
/*  533 */               .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  534 */               .addNextBehavior(
/*  535 */                 CECombatBehaviors.Behavior.builder()
/*  536 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  537 */                 .withinDistance(0.0D, 6.0D)
/*  538 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  545 */       .addFirstBehavior(
/*  546 */         CECombatBehaviors.Behavior.builder()
/*  547 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  548 */         .withinDistance(0.0D, 3.0D)
/*  549 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  550 */         .addNextBehavior(
/*  551 */           CECombatBehaviors.Behavior.builder()
/*  552 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  553 */           .withinDistance(0.0D, 4.0D)
/*  554 */           .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  555 */           .addNextBehavior(
/*  556 */             CECombatBehaviors.Behavior.builder()
/*  557 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  558 */             .withinDistance(0.0D, 5.0D)
/*  559 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  560 */             .addNextBehavior(
/*  561 */               CECombatBehaviors.Behavior.builder()
/*  562 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  563 */               .withinDistance(0.0D, 5.0D)
/*  564 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  565 */               .addNextBehavior(
/*  566 */                 CECombatBehaviors.Behavior.builder()
/*  567 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  568 */                 .withinDistance(0.0D, 6.0D)
/*  569 */                 .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  576 */       .addFirstBehavior(
/*  577 */         CECombatBehaviors.Behavior.builder()
/*  578 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  579 */         .withinDistance(0.0D, 3.0D)
/*  580 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  581 */         .addNextBehavior(
/*  582 */           CECombatBehaviors.Behavior.builder()
/*  583 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  584 */           .withinDistance(0.0D, 4.0D)
/*  585 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  586 */           .addNextBehavior(
/*  587 */             CECombatBehaviors.Behavior.builder()
/*  588 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  589 */             .withinDistance(0.0D, 5.0D)
/*  590 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  591 */             .addNextBehavior(
/*  592 */               CECombatBehaviors.Behavior.builder()
/*  593 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  594 */               .withinDistance(0.0D, 5.0D)
/*  595 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  596 */               .addNextBehavior(
/*  597 */                 CECombatBehaviors.Behavior.builder()
/*  598 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  599 */                 .withinDistance(0.0D, 6.0D)
/*  600 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  609 */       .addFirstBehavior(
/*  610 */         CECombatBehaviors.Behavior.builder()
/*  611 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  612 */         .withinDistance(0.0D, 3.0D)
/*  613 */         .animationBehavior(AVAnimations.OBSIDIAN_BIPED_LANDING, 0.0F)
/*  614 */         .addNextBehavior(
/*  615 */           CECombatBehaviors.Behavior.builder()
/*  616 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  617 */           .withinDistance(0.0D, 4.0D)
/*  618 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  619 */           .addNextBehavior(
/*  620 */             CECombatBehaviors.Behavior.builder()
/*  621 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  622 */             .withinDistance(0.0D, 5.0D)
/*  623 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  624 */             .addNextBehavior(
/*  625 */               CECombatBehaviors.Behavior.builder()
/*  626 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  627 */               .withinDistance(0.0D, 5.0D)
/*  628 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  629 */               .addNextBehavior(
/*  630 */                 CECombatBehaviors.Behavior.builder()
/*  631 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  632 */                 .withinDistance(0.0D, 6.0D)
/*  633 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  640 */       .addFirstBehavior(
/*  641 */         CECombatBehaviors.Behavior.builder()
/*  642 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  643 */         .withinDistance(0.0D, 3.0D)
/*  644 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  645 */         .addNextBehavior(
/*  646 */           CECombatBehaviors.Behavior.builder()
/*  647 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  648 */           .withinDistance(0.0D, 4.0D)
/*  649 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  650 */           .addNextBehavior(
/*  651 */             CECombatBehaviors.Behavior.builder()
/*  652 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  653 */             .withinDistance(0.0D, 5.0D)
/*  654 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  655 */             .addNextBehavior(
/*  656 */               CECombatBehaviors.Behavior.builder()
/*  657 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  658 */               .withinDistance(0.0D, 5.0D)
/*  659 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  660 */               .addNextBehavior(
/*  661 */                 CECombatBehaviors.Behavior.builder()
/*  662 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  663 */                 .withinDistance(0.0D, 6.0D)
/*  664 */                 .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  671 */       .addFirstBehavior(
/*  672 */         CECombatBehaviors.Behavior.builder()
/*  673 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  674 */         .withinDistance(0.0D, 3.0D)
/*  675 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  676 */         .addNextBehavior(
/*  677 */           CECombatBehaviors.Behavior.builder()
/*  678 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  679 */           .withinDistance(0.0D, 4.0D)
/*  680 */           .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  681 */           .addNextBehavior(
/*  682 */             CECombatBehaviors.Behavior.builder()
/*  683 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  684 */             .withinDistance(0.0D, 5.0D)
/*  685 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  686 */             .addNextBehavior(
/*  687 */               CECombatBehaviors.Behavior.builder()
/*  688 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  689 */               .withinDistance(0.0D, 5.0D)
/*  690 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  691 */               .addNextBehavior(
/*  692 */                 CECombatBehaviors.Behavior.builder()
/*  693 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  694 */                 .withinDistance(0.0D, 6.0D)
/*  695 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  702 */       .addFirstBehavior(
/*  703 */         CECombatBehaviors.Behavior.builder()
/*  704 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  705 */         .withinDistance(0.0D, 3.0D)
/*  706 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  707 */         .addNextBehavior(
/*  708 */           CECombatBehaviors.Behavior.builder()
/*  709 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  710 */           .withinDistance(0.0D, 4.0D)
/*  711 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  712 */           .addNextBehavior(
/*  713 */             CECombatBehaviors.Behavior.builder()
/*  714 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  715 */             .withinDistance(0.0D, 5.0D)
/*  716 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  717 */             .addNextBehavior(
/*  718 */               CECombatBehaviors.Behavior.builder()
/*  719 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  720 */               .withinDistance(0.0D, 5.0D)
/*  721 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  722 */               .addNextBehavior(
/*  723 */                 CECombatBehaviors.Behavior.builder()
/*  724 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  725 */                 .withinDistance(0.0D, 6.0D)
/*  726 */                 .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  733 */       .addFirstBehavior(
/*  734 */         CECombatBehaviors.Behavior.builder()
/*  735 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  736 */         .withinDistance(0.0D, 3.0D)
/*  737 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  738 */         .addNextBehavior(
/*  739 */           CECombatBehaviors.Behavior.builder()
/*  740 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  741 */           .withinDistance(0.0D, 4.0D)
/*  742 */           .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  743 */           .addNextBehavior(
/*  744 */             CECombatBehaviors.Behavior.builder()
/*  745 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  746 */             .withinDistance(0.0D, 5.0D)
/*  747 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  748 */             .addNextBehavior(
/*  749 */               CECombatBehaviors.Behavior.builder()
/*  750 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  751 */               .withinDistance(0.0D, 5.0D)
/*  752 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  753 */               .addNextBehavior(
/*  754 */                 CECombatBehaviors.Behavior.builder()
/*  755 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  756 */                 .withinDistance(0.0D, 6.0D)
/*  757 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  764 */       .addFirstBehavior(
/*  765 */         CECombatBehaviors.Behavior.builder()
/*  766 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  767 */         .withinDistance(0.0D, 3.0D)
/*  768 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  769 */         .addNextBehavior(
/*  770 */           CECombatBehaviors.Behavior.builder()
/*  771 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  772 */           .withinDistance(0.0D, 4.0D)
/*  773 */           .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)
/*  774 */           .addNextBehavior(
/*  775 */             CECombatBehaviors.Behavior.builder()
/*  776 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  777 */             .withinDistance(0.0D, 5.0D)
/*  778 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  779 */             .addNextBehavior(
/*  780 */               CECombatBehaviors.Behavior.builder()
/*  781 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  782 */               .withinDistance(0.0D, 5.0D)
/*  783 */               .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  784 */               .addNextBehavior(
/*  785 */                 CECombatBehaviors.Behavior.builder()
/*  786 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  787 */                 .withinDistance(0.0D, 6.0D)
/*  788 */                 .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  795 */       .addFirstBehavior(
/*  796 */         CECombatBehaviors.Behavior.builder()
/*  797 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  798 */         .withinDistance(0.0D, 3.0D)
/*  799 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO2, 0.0F)
/*  800 */         .addNextBehavior(
/*  801 */           CECombatBehaviors.Behavior.builder()
/*  802 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  803 */           .withinDistance(0.0D, 4.0D)
/*  804 */           .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)
/*  805 */           .addNextBehavior(
/*  806 */             CECombatBehaviors.Behavior.builder()
/*  807 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  808 */             .withinDistance(0.0D, 5.0D)
/*  809 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  810 */             .addNextBehavior(
/*  811 */               CECombatBehaviors.Behavior.builder()
/*  812 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  813 */               .withinDistance(0.0D, 5.0D)
/*  814 */               .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  815 */               .addNextBehavior(
/*  816 */                 CECombatBehaviors.Behavior.builder()
/*  817 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  818 */                 .withinDistance(0.0D, 6.0D)
/*  819 */                 .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  826 */       .addFirstBehavior(
/*  827 */         CECombatBehaviors.Behavior.builder()
/*  828 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  829 */         .withinDistance(0.0D, 3.0D)
/*  830 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO3, 0.0F)
/*  831 */         .addNextBehavior(
/*  832 */           CECombatBehaviors.Behavior.builder()
/*  833 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  834 */           .withinDistance(0.0D, 4.0D)
/*  835 */           .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  836 */           .addNextBehavior(
/*  837 */             CECombatBehaviors.Behavior.builder()
/*  838 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  839 */             .withinDistance(0.0D, 5.0D)
/*  840 */             .animationBehavior(AVAnimations.OBSIDIAN_BIPED_LANDING, 0.0F)
/*  841 */             .addNextBehavior(
/*  842 */               CECombatBehaviors.Behavior.builder()
/*  843 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  844 */               .withinDistance(0.0D, 5.0D)
/*  845 */               .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  846 */               .addNextBehavior(
/*  847 */                 CECombatBehaviors.Behavior.builder()
/*  848 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  849 */                 .withinDistance(0.0D, 6.0D)
/*  850 */                 .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  857 */       .addFirstBehavior(
/*  858 */         CECombatBehaviors.Behavior.builder()
/*  859 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  860 */         .withinDistance(0.0D, 3.0D)
/*  861 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_AIR_SLASH, 0.0F)
/*  862 */         .addNextBehavior(
/*  863 */           CECombatBehaviors.Behavior.builder()
/*  864 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  865 */           .withinDistance(0.0D, 4.0D)
/*  866 */           .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  867 */           .addNextBehavior(
/*  868 */             CECombatBehaviors.Behavior.builder()
/*  869 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  870 */             .withinDistance(0.0D, 5.0D)
/*  871 */             .animationBehavior(AVAnimations.OBSIDIAN_FIST_AUTO1, 0.0F)
/*  872 */             .addNextBehavior(
/*  873 */               CECombatBehaviors.Behavior.builder()
/*  874 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  875 */               .withinDistance(0.0D, 5.0D)
/*  876 */               .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  877 */               .addNextBehavior(
/*  878 */                 CECombatBehaviors.Behavior.builder()
/*  879 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  880 */                 .withinDistance(0.0D, 6.0D)
/*  881 */                 .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  888 */     .newBehaviorRoot(
/*  889 */       CECombatBehaviors.BehaviorRoot.builder()
/*  890 */       .priority(1.0D)
/*  891 */       .weight(30.0D)
/*  892 */       .maxCooldown(20)
/*  893 */       .addFirstBehavior(
/*  894 */         CECombatBehaviors.Behavior.builder()
/*  895 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  896 */         .withinDistance(5.0D, 10.0D)
/*  897 */         .animationBehavior(AVAnimations.OBSIDIAN_FIST_DASH, 0.0F)))
/*      */ 
/*      */     
/*  900 */     .newBehaviorRoot(
/*  901 */       CECombatBehaviors.BehaviorRoot.builder()
/*  902 */       .priority(1.0D)
/*  903 */       .weight(30.0D)
/*  904 */       .maxCooldown(100)
/*  905 */       .addFirstBehavior(
/*  906 */         CECombatBehaviors.Behavior.builder()
/*  907 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  908 */         .withinDistance(0.0D, 5.0D)
/*  909 */         .animationBehavior(AVAnimations.OBSIDIAN_STRONG_PUNCH, 0.0F))
/*      */       
/*  911 */       .addFirstBehavior(
/*  912 */         CECombatBehaviors.Behavior.builder()
/*  913 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  914 */         .withinDistance(0.0D, 10.0D)
/*  915 */         .animationBehavior(AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)))
/*      */ 
/*      */     
/*  918 */     .newBehaviorRoot(
/*  919 */       CECombatBehaviors.BehaviorRoot.builder()
/*  920 */       .priority(1.0D)
/*  921 */       .weight(20.0D)
/*  922 */       .maxCooldown(200)
/*  923 */       .addFirstBehavior(
/*  924 */         CECombatBehaviors.Behavior.builder()
/*  925 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  926 */         .withinDistance(0.0D, 5.0D)
/*  927 */         .animationBehavior(AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F))
/*      */       
/*  929 */       .addFirstBehavior(
/*  930 */         CECombatBehaviors.Behavior.builder()
/*  931 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  932 */         .withinDistance(0.0D, 5.0D)
/*  933 */         .animationBehavior(AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F))
/*      */       
/*  935 */       .addFirstBehavior(
/*  936 */         CECombatBehaviors.Behavior.builder()
/*  937 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  938 */         .custom(HerobrineCommon::canShootDarkOb)
/*  939 */         .withinDistance(5.0D, 10.0D)
/*  940 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  941 */         .addExBehavior(HerobrineCommon::performShootDarkOb)))
/*      */ 
/*      */     
/*  944 */     .newBehaviorRoot(
/*  945 */       CECombatBehaviors.BehaviorRoot.builder()
/*  946 */       .priority(1.0D)
/*  947 */       .weight(15.0D)
/*  948 */       .maxCooldown(200)
/*  949 */       .addFirstBehavior(
/*  950 */         CECombatBehaviors.Behavior.builder()
/*  951 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  952 */         .custom(HerobrineCommon::canPlayObsidianMachine)
/*  953 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  954 */         .addExBehavior(HerobrineCommon::performObsidianMachine)))
/*      */ 
/*      */     
/*  957 */     .newBehaviorRoot(
/*  958 */       CECombatBehaviors.BehaviorRoot.builder()
/*  959 */       .priority(1.0D)
/*  960 */       .weight(2.0D)
/*  961 */       .maxCooldown(100)
/*  962 */       .addFirstBehavior(
/*  963 */         CECombatBehaviors.Behavior.builder()
/*  964 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  965 */         .withinDistance(0.0D, 5.0D)
/*  966 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  968 */       .addFirstBehavior(
/*  969 */         CECombatBehaviors.Behavior.builder()
/*  970 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  971 */         .withinDistance(0.0D, 5.0D)
/*  972 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  974 */       .addFirstBehavior(
/*  975 */         CECombatBehaviors.Behavior.builder()
/*  976 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  977 */         .withinDistance(0.0D, 5.0D)
/*  978 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  980 */       .addFirstBehavior(
/*  981 */         CECombatBehaviors.Behavior.builder()
/*  982 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  983 */         .withinDistance(0.0D, 5.0D)
/*  984 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F)))
/*      */ 
/*      */     
/*  987 */     .newBehaviorRoot(
/*  988 */       CECombatBehaviors.BehaviorRoot.builder()
/*  989 */       .priority(1.0D)
/*  990 */       .weight(15.0D)
/*  991 */       .addFirstBehavior(
/*  992 */         CECombatBehaviors.Behavior.builder()
/*  993 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  994 */         .withinDistance(0.0D, 3.0D)
/*  995 */         .custom(HerobrineCommon::canPerformGuarding)
/*  996 */         .guard(40)))
/*      */ 
/*      */     
/*  999 */     .newBehaviorRoot(
/* 1000 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1001 */       .priority(1.0D)
/* 1002 */       .weight(10.0D)
/* 1003 */       .addFirstBehavior(
/* 1004 */         CECombatBehaviors.Behavior.builder()
/* 1005 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1006 */         .withinDistance(0.0D, 5.0D)
/* 1007 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F))
/*      */       
/* 1009 */       .addFirstBehavior(
/* 1010 */         CECombatBehaviors.Behavior.builder()
/* 1011 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1012 */         .withinDistance(0.0D, 5.0D)
/* 1013 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F))
/*      */       
/* 1015 */       .addFirstBehavior(
/* 1016 */         CECombatBehaviors.Behavior.builder()
/* 1017 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1018 */         .withinDistance(0.0D, 5.0D)
/* 1019 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1021 */       .addFirstBehavior(
/* 1022 */         CECombatBehaviors.Behavior.builder()
/* 1023 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1024 */         .withinDistance(0.0D, 5.0D)
/* 1025 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1027 */       .addFirstBehavior(
/* 1028 */         CECombatBehaviors.Behavior.builder()
/* 1029 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1030 */         .withinDistance(0.0D, 5.0D)
/* 1031 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1033 */       .addFirstBehavior(
/* 1034 */         CECombatBehaviors.Behavior.builder()
/* 1035 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1036 */         .withinDistance(0.0D, 5.0D)
/* 1037 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1040 */     .newBehaviorRoot(
/* 1041 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1042 */       .priority(1.0D)
/* 1043 */       .weight(20.0D)
/* 1044 */       .maxCooldown(160)
/* 1045 */       .addFirstBehavior(
/* 1046 */         CECombatBehaviors.Behavior.builder()
/* 1047 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1048 */         .custom(HerobrineCommon::canJump)
/* 1049 */         .withinDistance(5.0D, 14.0D)
/* 1050 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1051 */         .addExBehavior(HerobrineCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineObsidianWeapon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */