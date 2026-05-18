/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsRuine;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HerobrineObsidianSledgehammer
/*      */ {
/*   18 */   public static final CECombatBehaviors.Builder<MobPatch<?>> OBSIDIAN_SLEDGEHAMMER = CECombatBehaviors.builder()
/*   19 */     .newBehaviorRoot(
/*   20 */       CECombatBehaviors.BehaviorRoot.builder()
/*   21 */       .priority(5.0D)
/*   22 */       .weight(1000.0D)
/*   23 */       .maxCooldown(0)
/*   24 */       .addFirstBehavior(
/*   25 */         CECombatBehaviors.Behavior.builder()
/*   26 */         .custom(CombatCommon::canExecute)
/*   27 */         .withinDistance(0.0D, 5.0D)
/*   28 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*   29 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*   32 */     .newBehaviorRoot(
/*   33 */       CECombatBehaviors.BehaviorRoot.builder()
/*   34 */       .priority(4.0D)
/*   35 */       .weight(1000.0D)
/*   36 */       .maxCooldown(0)
/*   37 */       .addFirstBehavior(
/*   38 */         CECombatBehaviors.Behavior.builder()
/*   39 */         .custom(CombatCommon::canEscape)
/*   40 */         .withinDistance(0.0D, 8.0D)
/*   41 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F)
/*   42 */         .addExBehavior(HerobrineCommon::performEscapeRunAwayWithLowClone))
/*      */       
/*   44 */       .addFirstBehavior(
/*   45 */         CECombatBehaviors.Behavior.builder()
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
/*   58 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   59 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   60 */         .custom(HerobrineCommon::canPerformHealing)
/*   61 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*   62 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*      */ 
/*      */     
/*   65 */     .newBehaviorRoot(
/*   66 */       CECombatBehaviors.BehaviorRoot.builder()
/*   67 */       .priority(1.0D)
/*   68 */       .weight(30.0D)
/*   69 */       .maxCooldown(120)
/*   70 */       .addFirstBehavior(
/*   71 */         CECombatBehaviors.Behavior.builder()
/*   72 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   73 */         .withinDistance(7.0D, 48.0D)
/*   74 */         .animationBehavior(AVAnimations.HEROBRINE_MOB_ENDERSTEP_OBSCURIS, 0.0F)
/*   75 */         .addExBehavior(HerobrineCommon::giveSlowFalling)))
/*      */ 
/*      */     
/*   78 */     .newBehaviorRoot(
/*   79 */       CECombatBehaviors.BehaviorRoot.builder()
/*   80 */       .priority(1.0D)
/*   81 */       .weight(40.0D)
/*   82 */       .maxCooldown(20)
/*   83 */       .addFirstBehavior(
/*   84 */         CECombatBehaviors.Behavior.builder()
/*   85 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*   86 */         .withinDistance(0.0D, 5.0D)
/*   87 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*   88 */         .addNextBehavior(
/*   89 */           CECombatBehaviors.Behavior.builder()
/*   90 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*   91 */           .withinDistance(0.0D, 6.0D)
/*   92 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*   93 */           .addNextBehavior(
/*   94 */             CECombatBehaviors.Behavior.builder()
/*   95 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*   96 */             .withinDistance(0.0D, 6.0D)
/*   97 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*   98 */             .addNextBehavior(
/*   99 */               CECombatBehaviors.Behavior.builder()
/*  100 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  101 */               .withinDistance(0.0D, 6.0D)
/*  102 */               .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  103 */               .addNextBehavior(
/*  104 */                 CECombatBehaviors.Behavior.builder()
/*  105 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  106 */                 .withinDistance(0.0D, 8.0D)
/*  107 */                 .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  113 */       .addFirstBehavior(
/*  114 */         CECombatBehaviors.Behavior.builder()
/*  115 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  116 */         .withinDistance(0.0D, 8.0D)
/*  117 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  118 */         .addNextBehavior(
/*  119 */           CECombatBehaviors.Behavior.builder()
/*  120 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  121 */           .withinDistance(0.0D, 6.5D)
/*  122 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  123 */           .addNextBehavior(
/*  124 */             CECombatBehaviors.Behavior.builder()
/*  125 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  126 */             .withinDistance(0.0D, 6.0D)
/*  127 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  128 */             .addNextBehavior(
/*  129 */               CECombatBehaviors.Behavior.builder()
/*  130 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  131 */               .withinDistance(0.0D, 6.5D)
/*  132 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)
/*  133 */               .addNextBehavior(
/*  134 */                 CECombatBehaviors.Behavior.builder()
/*  135 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  136 */                 .withinDistance(0.0D, 8.0D)
/*  137 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  144 */       .addFirstBehavior(
/*  145 */         CECombatBehaviors.Behavior.builder()
/*  146 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  147 */         .withinDistance(0.0D, 5.0D)
/*  148 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  149 */         .addNextBehavior(
/*  150 */           CECombatBehaviors.Behavior.builder()
/*  151 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  152 */           .withinDistance(0.0D, 8.0D)
/*  153 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  154 */           .addNextBehavior(
/*  155 */             CECombatBehaviors.Behavior.builder()
/*  156 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  157 */             .withinDistance(0.0D, 6.0D)
/*  158 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  159 */             .addNextBehavior(
/*  160 */               CECombatBehaviors.Behavior.builder()
/*  161 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  162 */               .withinDistance(0.0D, 6.0D)
/*  163 */               .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  164 */               .addNextBehavior(
/*  165 */                 CECombatBehaviors.Behavior.builder()
/*  166 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  167 */                 .withinDistance(0.0D, 8.0D)
/*  168 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  174 */       .addFirstBehavior(
/*  175 */         CECombatBehaviors.Behavior.builder()
/*  176 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  177 */         .withinDistance(0.0D, 5.5D)
/*  178 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  179 */         .addNextBehavior(
/*  180 */           CECombatBehaviors.Behavior.builder()
/*  181 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  182 */           .withinDistance(0.0D, 6.0D)
/*  183 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  184 */           .addNextBehavior(
/*  185 */             CECombatBehaviors.Behavior.builder()
/*  186 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  187 */             .withinDistance(0.0D, 6.0D)
/*  188 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  189 */             .addNextBehavior(
/*  190 */               CECombatBehaviors.Behavior.builder()
/*  191 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  192 */               .withinDistance(0.0D, 6.0D)
/*  193 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  194 */               .addNextBehavior(
/*  195 */                 CECombatBehaviors.Behavior.builder()
/*  196 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  197 */                 .withinDistance(0.0D, 8.0D)
/*  198 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  204 */       .addFirstBehavior(
/*  205 */         CECombatBehaviors.Behavior.builder()
/*  206 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  207 */         .withinDistance(0.0D, 5.5D)
/*  208 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  209 */         .addNextBehavior(
/*  210 */           CECombatBehaviors.Behavior.builder()
/*  211 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  212 */           .withinDistance(0.0D, 6.5D)
/*  213 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  214 */           .addNextBehavior(
/*  215 */             CECombatBehaviors.Behavior.builder()
/*  216 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  217 */             .withinDistance(0.0D, 7.0D)
/*  218 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  219 */             .addNextBehavior(
/*  220 */               CECombatBehaviors.Behavior.builder()
/*  221 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  222 */               .withinDistance(0.0D, 7.5D)
/*  223 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  224 */               .addNextBehavior(
/*  225 */                 CECombatBehaviors.Behavior.builder()
/*  226 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  227 */                 .withinDistance(0.0D, 6.5D)
/*  228 */                 .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  234 */       .addFirstBehavior(
/*  235 */         CECombatBehaviors.Behavior.builder()
/*  236 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  237 */         .withinDistance(0.0D, 5.5D)
/*  238 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  239 */         .addNextBehavior(
/*  240 */           CECombatBehaviors.Behavior.builder()
/*  241 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  242 */           .withinDistance(0.0D, 6.5D)
/*  243 */           .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/*  244 */           .addNextBehavior(
/*  245 */             CECombatBehaviors.Behavior.builder()
/*  246 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  247 */             .withinDistance(0.0D, 6.5D)
/*  248 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  249 */             .addNextBehavior(
/*  250 */               CECombatBehaviors.Behavior.builder()
/*  251 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  252 */               .withinDistance(0.0D, 6.0D)
/*  253 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  254 */               .addNextBehavior(
/*  255 */                 CECombatBehaviors.Behavior.builder()
/*  256 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  257 */                 .withinDistance(0.0D, 8.0D)
/*  258 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  264 */       .addFirstBehavior(
/*  265 */         CECombatBehaviors.Behavior.builder()
/*  266 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  267 */         .withinDistance(0.0D, 5.5D)
/*  268 */         .animationBehavior(AnimsAgony.AGONY_RIPPING_FANGS, 0.0F)
/*  269 */         .addNextBehavior(
/*  270 */           CECombatBehaviors.Behavior.builder()
/*  271 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  272 */           .withinDistance(0.0D, 6.0D)
/*  273 */           .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/*  274 */           .addNextBehavior(
/*  275 */             CECombatBehaviors.Behavior.builder()
/*  276 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  277 */             .withinDistance(0.0D, 7.0D)
/*  278 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  279 */             .addNextBehavior(
/*  280 */               CECombatBehaviors.Behavior.builder()
/*  281 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  282 */               .withinDistance(0.0D, 7.5D)
/*  283 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  288 */       .addFirstBehavior(
/*  289 */         CECombatBehaviors.Behavior.builder()
/*  290 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  291 */         .withinDistance(0.0D, 6.0D)
/*  292 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  293 */         .addNextBehavior(
/*  294 */           CECombatBehaviors.Behavior.builder()
/*  295 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  296 */           .withinDistance(0.0D, 8.0D)
/*  297 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*  298 */           .addNextBehavior(
/*  299 */             CECombatBehaviors.Behavior.builder()
/*  300 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  301 */             .withinDistance(0.0D, 7.5D)
/*  302 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  303 */             .addNextBehavior(
/*  304 */               CECombatBehaviors.Behavior.builder()
/*  305 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  306 */               .withinDistance(0.0D, 7.5D)
/*  307 */               .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  312 */       .addFirstBehavior(
/*  313 */         CECombatBehaviors.Behavior.builder()
/*  314 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  315 */         .withinDistance(0.0D, 6.0D)
/*  316 */         .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  317 */         .addNextBehavior(
/*  318 */           CECombatBehaviors.Behavior.builder()
/*  319 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  320 */           .withinDistance(0.0D, 6.5D)
/*  321 */           .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/*  322 */           .addNextBehavior(
/*  323 */             CECombatBehaviors.Behavior.builder()
/*  324 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  325 */             .withinDistance(0.0D, 6.0D)
/*  326 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  327 */             .addNextBehavior(
/*  328 */               CECombatBehaviors.Behavior.builder()
/*  329 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  330 */               .withinDistance(0.0D, 8.0D)
/*  331 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  336 */       .addFirstBehavior(
/*  337 */         CECombatBehaviors.Behavior.builder()
/*  338 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  339 */         .withinDistance(0.0D, 5.5D)
/*  340 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  341 */         .addNextBehavior(
/*  342 */           CECombatBehaviors.Behavior.builder()
/*  343 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  344 */           .withinDistance(0.0D, 6.0D)
/*  345 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  346 */           .addNextBehavior(
/*  347 */             CECombatBehaviors.Behavior.builder()
/*  348 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  349 */             .withinDistance(0.0D, 8.0D)
/*  350 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  351 */             .addNextBehavior(
/*  352 */               CECombatBehaviors.Behavior.builder()
/*  353 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  354 */               .withinDistance(0.0D, 6.5D)
/*  355 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  360 */       .addFirstBehavior(
/*  361 */         CECombatBehaviors.Behavior.builder()
/*  362 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  363 */         .withinDistance(0.0D, 6.5D)
/*  364 */         .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)
/*  365 */         .addNextBehavior(
/*  366 */           CECombatBehaviors.Behavior.builder()
/*  367 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  368 */           .withinDistance(0.0D, 8.0D)
/*  369 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  370 */           .addNextBehavior(
/*  371 */             CECombatBehaviors.Behavior.builder()
/*  372 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  373 */             .withinDistance(0.0D, 6.5D)
/*  374 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  375 */             .addNextBehavior(
/*  376 */               CECombatBehaviors.Behavior.builder()
/*  377 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  378 */               .withinDistance(0.0D, 8.0D)
/*  379 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  384 */       .addFirstBehavior(
/*  385 */         CECombatBehaviors.Behavior.builder()
/*  386 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  387 */         .withinDistance(0.0D, 5.5D)
/*  388 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  389 */         .addNextBehavior(
/*  390 */           CECombatBehaviors.Behavior.builder()
/*  391 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  392 */           .withinDistance(0.0D, 6.0D)
/*  393 */           .animationBehavior(AnimsAgony.AGONY_RIPPING_FANGS, 0.0F)
/*  394 */           .addNextBehavior(
/*  395 */             CECombatBehaviors.Behavior.builder()
/*  396 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  397 */             .withinDistance(0.0D, 6.0D)
/*  398 */             .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/*  399 */             .addNextBehavior(
/*  400 */               CECombatBehaviors.Behavior.builder()
/*  401 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  402 */               .withinDistance(0.0D, 7.0D)
/*  403 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  404 */               .addNextBehavior(
/*  405 */                 CECombatBehaviors.Behavior.builder()
/*  406 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  407 */                 .withinDistance(0.0D, 7.5D)
/*  408 */                 .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  414 */       .addFirstBehavior(
/*  415 */         CECombatBehaviors.Behavior.builder()
/*  416 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  417 */         .withinDistance(0.0D, 5.5D)
/*  418 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  419 */         .addNextBehavior(
/*  420 */           CECombatBehaviors.Behavior.builder()
/*  421 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  422 */           .withinDistance(0.0D, 7.0D)
/*  423 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  424 */           .addNextBehavior(
/*  425 */             CECombatBehaviors.Behavior.builder()
/*  426 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  427 */             .withinDistance(0.0D, 6.5D)
/*  428 */             .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/*  429 */             .addNextBehavior(
/*  430 */               CECombatBehaviors.Behavior.builder()
/*  431 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  432 */               .withinDistance(0.0D, 7.5D)
/*  433 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  434 */               .addNextBehavior(
/*  435 */                 CECombatBehaviors.Behavior.builder()
/*  436 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  437 */                 .withinDistance(0.0D, 7.5D)
/*  438 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  444 */       .addFirstBehavior(
/*  445 */         CECombatBehaviors.Behavior.builder()
/*  446 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  447 */         .withinDistance(0.0D, 5.5D)
/*  448 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/*  449 */         .addNextBehavior(
/*  450 */           CECombatBehaviors.Behavior.builder()
/*  451 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  452 */           .withinDistance(0.0D, 6.0D)
/*  453 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  454 */           .addNextBehavior(
/*  455 */             CECombatBehaviors.Behavior.builder()
/*  456 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  457 */             .withinDistance(0.0D, 6.0D)
/*  458 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  459 */             .addNextBehavior(
/*  460 */               CECombatBehaviors.Behavior.builder()
/*  461 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  462 */               .withinDistance(0.0D, 6.0D)
/*  463 */               .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  468 */       .addFirstBehavior(
/*  469 */         CECombatBehaviors.Behavior.builder()
/*  470 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  471 */         .withinDistance(0.0D, 8.0D)
/*  472 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  473 */         .addNextBehavior(
/*  474 */           CECombatBehaviors.Behavior.builder()
/*  475 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  476 */           .withinDistance(0.0D, 6.0D)
/*  477 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  478 */           .addNextBehavior(
/*  479 */             CECombatBehaviors.Behavior.builder()
/*  480 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  481 */             .withinDistance(0.0D, 6.0D)
/*  482 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  483 */             .addNextBehavior(
/*  484 */               CECombatBehaviors.Behavior.builder()
/*  485 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */               .withinDistance(0.0D, 6.0D)
/*  487 */               .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  492 */       .addFirstBehavior(
/*  493 */         CECombatBehaviors.Behavior.builder()
/*  494 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  495 */         .withinDistance(0.0D, 5.5D)
/*  496 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  497 */         .addNextBehavior(
/*  498 */           CECombatBehaviors.Behavior.builder()
/*  499 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  500 */           .withinDistance(0.0D, 6.0D)
/*  501 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  502 */           .addNextBehavior(
/*  503 */             CECombatBehaviors.Behavior.builder()
/*  504 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  505 */             .withinDistance(0.0D, 6.5D)
/*  506 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  507 */             .addNextBehavior(
/*  508 */               CECombatBehaviors.Behavior.builder()
/*  509 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  510 */               .withinDistance(0.0D, 6.5D)
/*  511 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)
/*  512 */               .addNextBehavior(
/*  513 */                 CECombatBehaviors.Behavior.builder()
/*  514 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  515 */                 .withinDistance(0.0D, 7.5D)
/*  516 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  522 */       .addFirstBehavior(
/*  523 */         CECombatBehaviors.Behavior.builder()
/*  524 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  525 */         .withinDistance(0.0D, 5.5D)
/*  526 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  527 */         .addNextBehavior(
/*  528 */           CECombatBehaviors.Behavior.builder()
/*  529 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  530 */           .withinDistance(0.0D, 7.0D)
/*  531 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  532 */           .addNextBehavior(
/*  533 */             CECombatBehaviors.Behavior.builder()
/*  534 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  535 */             .withinDistance(0.0D, 6.5D)
/*  536 */             .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)
/*  537 */             .addNextBehavior(
/*  538 */               CECombatBehaviors.Behavior.builder()
/*  539 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  540 */               .withinDistance(0.0D, 6.0D)
/*  541 */               .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  542 */               .addNextBehavior(
/*  543 */                 CECombatBehaviors.Behavior.builder()
/*  544 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  545 */                 .withinDistance(0.0D, 8.0D)
/*  546 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  552 */       .addFirstBehavior(
/*  553 */         CECombatBehaviors.Behavior.builder()
/*  554 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  555 */         .withinDistance(0.0D, 5.5D)
/*  556 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  557 */         .addNextBehavior(
/*  558 */           CECombatBehaviors.Behavior.builder()
/*  559 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  560 */           .withinDistance(0.0D, 6.0D)
/*  561 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  562 */           .addNextBehavior(
/*  563 */             CECombatBehaviors.Behavior.builder()
/*  564 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  565 */             .withinDistance(0.0D, 7.0D)
/*  566 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  567 */             .addNextBehavior(
/*  568 */               CECombatBehaviors.Behavior.builder()
/*  569 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  570 */               .withinDistance(0.0D, 7.5D)
/*  571 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  576 */       .addFirstBehavior(
/*  577 */         CECombatBehaviors.Behavior.builder()
/*  578 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  579 */         .withinDistance(0.0D, 8.0D)
/*  580 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  581 */         .addNextBehavior(
/*  582 */           CECombatBehaviors.Behavior.builder()
/*  583 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  584 */           .withinDistance(0.0D, 7.5D)
/*  585 */           .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  586 */           .addNextBehavior(
/*  587 */             CECombatBehaviors.Behavior.builder()
/*  588 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  589 */             .withinDistance(0.0D, 6.0D)
/*  590 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  591 */             .addNextBehavior(
/*  592 */               CECombatBehaviors.Behavior.builder()
/*  593 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  594 */               .withinDistance(0.0D, 6.0D)
/*  595 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  596 */               .addNextBehavior(
/*  597 */                 CECombatBehaviors.Behavior.builder()
/*  598 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  599 */                 .withinDistance(0.0D, 8.0D)
/*  600 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  606 */       .addFirstBehavior(
/*  607 */         CECombatBehaviors.Behavior.builder()
/*  608 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  609 */         .withinDistance(0.0D, 6.0D)
/*  610 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  611 */         .addNextBehavior(
/*  612 */           CECombatBehaviors.Behavior.builder()
/*  613 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  614 */           .withinDistance(0.0D, 8.0D)
/*  615 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  616 */           .addNextBehavior(
/*  617 */             CECombatBehaviors.Behavior.builder()
/*  618 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  619 */             .withinDistance(0.0D, 6.5D)
/*  620 */             .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)
/*  621 */             .addNextBehavior(
/*  622 */               CECombatBehaviors.Behavior.builder()
/*  623 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  624 */               .withinDistance(0.0D, 8.0D)
/*  625 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*  626 */               .addNextBehavior(
/*  627 */                 CECombatBehaviors.Behavior.builder()
/*  628 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  629 */                 .withinDistance(0.0D, 7.5D)
/*  630 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  636 */       .addFirstBehavior(
/*  637 */         CECombatBehaviors.Behavior.builder()
/*  638 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  639 */         .withinDistance(0.0D, 6.5D)
/*  640 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/*  641 */         .addNextBehavior(
/*  642 */           CECombatBehaviors.Behavior.builder()
/*  643 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  644 */           .withinDistance(0.0D, 8.0D)
/*  645 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  646 */           .addNextBehavior(
/*  647 */             CECombatBehaviors.Behavior.builder()
/*  648 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  649 */             .withinDistance(0.0D, 6.5D)
/*  650 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  651 */             .addNextBehavior(
/*  652 */               CECombatBehaviors.Behavior.builder()
/*  653 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  654 */               .withinDistance(0.0D, 8.0D)
/*  655 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  660 */       .addFirstBehavior(
/*  661 */         CECombatBehaviors.Behavior.builder()
/*  662 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  663 */         .withinDistance(0.0D, 6.0D)
/*  664 */         .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  665 */         .addNextBehavior(
/*  666 */           CECombatBehaviors.Behavior.builder()
/*  667 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  668 */           .withinDistance(0.0D, 6.0D)
/*  669 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  670 */           .addNextBehavior(
/*  671 */             CECombatBehaviors.Behavior.builder()
/*  672 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  673 */             .withinDistance(0.0D, 6.0D)
/*  674 */             .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/*  675 */             .addNextBehavior(
/*  676 */               CECombatBehaviors.Behavior.builder()
/*  677 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  678 */               .withinDistance(0.0D, 8.0D)
/*  679 */               .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  680 */               .addNextBehavior(
/*  681 */                 CECombatBehaviors.Behavior.builder()
/*  682 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  683 */                 .withinDistance(0.0D, 6.5D)
/*  684 */                 .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  690 */       .addFirstBehavior(
/*  691 */         CECombatBehaviors.Behavior.builder()
/*  692 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  693 */         .withinDistance(0.0D, 5.5D)
/*  694 */         .animationBehavior(AnimsAgony.AGONY_RIPPING_FANGS, 0.0F)
/*  695 */         .addNextBehavior(
/*  696 */           CECombatBehaviors.Behavior.builder()
/*  697 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  698 */           .withinDistance(0.0D, 6.0D)
/*  699 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  700 */           .addNextBehavior(
/*  701 */             CECombatBehaviors.Behavior.builder()
/*  702 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  703 */             .withinDistance(0.0D, 8.0D)
/*  704 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  705 */             .addNextBehavior(
/*  706 */               CECombatBehaviors.Behavior.builder()
/*  707 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  708 */               .withinDistance(0.0D, 6.5D)
/*  709 */               .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  710 */               .addNextBehavior(
/*  711 */                 CECombatBehaviors.Behavior.builder()
/*  712 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  713 */                 .withinDistance(0.0D, 6.5D)
/*  714 */                 .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  720 */       .addFirstBehavior(
/*  721 */         CECombatBehaviors.Behavior.builder()
/*  722 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  723 */         .withinDistance(0.0D, 5.5D)
/*  724 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  725 */         .addNextBehavior(
/*  726 */           CECombatBehaviors.Behavior.builder()
/*  727 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  728 */           .withinDistance(0.0D, 6.0D)
/*  729 */           .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  730 */           .addNextBehavior(
/*  731 */             CECombatBehaviors.Behavior.builder()
/*  732 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  733 */             .withinDistance(0.0D, 6.0D)
/*  734 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  735 */             .addNextBehavior(
/*  736 */               CECombatBehaviors.Behavior.builder()
/*  737 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  738 */               .withinDistance(0.0D, 7.5D)
/*  739 */               .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  744 */       .addFirstBehavior(
/*  745 */         CECombatBehaviors.Behavior.builder()
/*  746 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  747 */         .withinDistance(0.0D, 6.5D)
/*  748 */         .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)
/*  749 */         .addNextBehavior(
/*  750 */           CECombatBehaviors.Behavior.builder()
/*  751 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  752 */           .withinDistance(0.0D, 7.0D)
/*  753 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  754 */           .addNextBehavior(
/*  755 */             CECombatBehaviors.Behavior.builder()
/*  756 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  757 */             .withinDistance(0.0D, 7.5D)
/*  758 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  759 */             .addNextBehavior(
/*  760 */               CECombatBehaviors.Behavior.builder()
/*  761 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  762 */               .withinDistance(0.0D, 6.0D)
/*  763 */               .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  764 */               .addNextBehavior(
/*  765 */                 CECombatBehaviors.Behavior.builder()
/*  766 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  767 */                 .withinDistance(0.0D, 6.5D)
/*  768 */                 .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  774 */       .addFirstBehavior(
/*  775 */         CECombatBehaviors.Behavior.builder()
/*  776 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  777 */         .withinDistance(0.0D, 5.5D)
/*  778 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  779 */         .addNextBehavior(
/*  780 */           CECombatBehaviors.Behavior.builder()
/*  781 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  782 */           .withinDistance(0.0D, 6.0D)
/*  783 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/*  784 */           .addNextBehavior(
/*  785 */             CECombatBehaviors.Behavior.builder()
/*  786 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  787 */             .withinDistance(0.0D, 7.5D)
/*  788 */             .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  789 */             .addNextBehavior(
/*  790 */               CECombatBehaviors.Behavior.builder()
/*  791 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  792 */               .withinDistance(0.0D, 6.5D)
/*  793 */               .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  794 */               .addNextBehavior(
/*  795 */                 CECombatBehaviors.Behavior.builder()
/*  796 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  797 */                 .withinDistance(0.0D, 8.0D)
/*  798 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  805 */     .newBehaviorRoot(
/*  806 */       CECombatBehaviors.BehaviorRoot.builder()
/*  807 */       .priority(1.0D)
/*  808 */       .weight(30.0D)
/*  809 */       .maxCooldown(100)
/*  810 */       .addFirstBehavior(
/*  811 */         CECombatBehaviors.Behavior.builder()
/*  812 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  813 */         .withinDistance(0.0D, 5.0D)
/*  814 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F))
/*      */       
/*  816 */       .addFirstBehavior(
/*  817 */         CECombatBehaviors.Behavior.builder()
/*  818 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  819 */         .withinDistance(0.0D, 5.0D)
/*  820 */         .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)))
/*      */ 
/*      */     
/*  823 */     .newBehaviorRoot(
/*  824 */       CECombatBehaviors.BehaviorRoot.builder()
/*  825 */       .priority(1.0D)
/*  826 */       .weight(30.0D)
/*  827 */       .maxCooldown(40)
/*  828 */       .addFirstBehavior(
/*  829 */         CECombatBehaviors.Behavior.builder()
/*  830 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  831 */         .withinDistance(0.0D, 5.0D)
/*  832 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  833 */         .addNextBehavior(
/*  834 */           CECombatBehaviors.Behavior.builder()
/*  835 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  836 */           .withinDistance(0.0D, 5.0D)
/*  837 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  838 */           .addNextBehavior(
/*  839 */             CECombatBehaviors.Behavior.builder()
/*  840 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  841 */             .withinDistance(0.0D, 5.0D)
/*  842 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  843 */             .addNextBehavior(
/*  844 */               CECombatBehaviors.Behavior.builder()
/*  845 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  846 */               .withinDistance(0.0D, 5.0D)
/*  847 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  853 */     .newBehaviorRoot(
/*  854 */       CECombatBehaviors.BehaviorRoot.builder()
/*  855 */       .priority(1.0D)
/*  856 */       .weight(10.0D)
/*  857 */       .maxCooldown(600)
/*  858 */       .addFirstBehavior(
/*  859 */         CECombatBehaviors.Behavior.builder()
/*  860 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  861 */         .custom(HerobrineCommon::canChangeToSecondForm)
/*  862 */         .withinDistance(0.0D, 32.0D)
/*  863 */         .animationBehavior(AVAnimations.POSE_UP, 0.0F)
/*  864 */         .addExBehavior(HerobrineCommon::changeToSecondForm)))
/*      */ 
/*      */     
/*  867 */     .newBehaviorRoot(
/*  868 */       CECombatBehaviors.BehaviorRoot.builder()
/*  869 */       .priority(1.0D)
/*  870 */       .weight(25.0D)
/*  871 */       .maxCooldown(300)
/*  872 */       .addFirstBehavior(
/*  873 */         CECombatBehaviors.Behavior.builder()
/*  874 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  875 */         .withinDistance(5.0D, 12.0D)
/*  876 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  877 */         .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1, 0.0F)
/*  878 */         .addExBehavior(HerobrineCommon::playSecondFormAnimation)
/*  879 */         .addNextBehavior(
/*  880 */           CECombatBehaviors.Behavior.builder()
/*  881 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  882 */           .withinDistance(5.0D, 12.0D)
/*  883 */           .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2, 0.0F)
/*  884 */           .addNextBehavior(
/*  885 */             CECombatBehaviors.Behavior.builder()
/*  886 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  887 */             .withinDistance(5.0D, 12.0D)
/*  888 */             .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1, 0.0F)
/*  889 */             .addNextBehavior(
/*  890 */               CECombatBehaviors.Behavior.builder()
/*  891 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  892 */               .withinDistance(5.0D, 12.0D)
/*  893 */               .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2, 0.0F)
/*  894 */               .addNextBehavior(
/*  895 */                 CECombatBehaviors.Behavior.builder()
/*  896 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  897 */                 .withinDistance(5.0D, 12.0D)
/*  898 */                 .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1, 0.0F)
/*  899 */                 .addNextBehavior(
/*  900 */                   CECombatBehaviors.Behavior.builder()
/*  901 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  902 */                   .withinDistance(5.0D, 12.0D)
/*  903 */                   .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2, 0.0F)
/*  904 */                   .addNextBehavior(
/*  905 */                     CECombatBehaviors.Behavior.builder()
/*  906 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  907 */                     .withinDistance(5.0D, 12.0D)
/*  908 */                     .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1, 0.0F)
/*  909 */                     .addNextBehavior(
/*  910 */                       CECombatBehaviors.Behavior.builder()
/*  911 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  912 */                       .withinDistance(5.0D, 12.0D)
/*  913 */                       .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2, 0.0F)
/*  914 */                       .addNextBehavior(
/*  915 */                         CECombatBehaviors.Behavior.builder()
/*  916 */                         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  917 */                         .withinDistance(5.0D, 12.0D)
/*  918 */                         .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1, 0.0F)
/*  919 */                         .addNextBehavior(
/*  920 */                           CECombatBehaviors.Behavior.builder()
/*  921 */                           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  922 */                           .withinDistance(5.0D, 12.0D)
/*  923 */                           .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2, 0.0F))))))))))))
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
/*  935 */     .newBehaviorRoot(
/*  936 */       CECombatBehaviors.BehaviorRoot.builder()
/*  937 */       .priority(1.0D)
/*  938 */       .weight(25.0D)
/*  939 */       .maxCooldown(300)
/*  940 */       .addFirstBehavior(
/*  941 */         CECombatBehaviors.Behavior.builder()
/*  942 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  943 */         .withinDistance(5.0D, 12.0D)
/*  944 */         .custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  945 */         .animationBehavior(AVAnimations.SLEDGEHAMMER_SOLAR_AUTO_3, 0.0F)
/*  946 */         .addExBehavior(HerobrineCommon::playSecondFormSpecialAnimation)
/*  947 */         .addNextBehavior(
/*  948 */           CECombatBehaviors.Behavior.builder()
/*  949 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  950 */           .withinDistance(5.0D, 12.0D)
/*  951 */           .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1, 0.0F)
/*  952 */           .addNextBehavior(
/*  953 */             CECombatBehaviors.Behavior.builder()
/*  954 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  955 */             .withinDistance(5.0D, 12.0D)
/*  956 */             .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2, 0.0F)
/*  957 */             .addNextBehavior(
/*  958 */               CECombatBehaviors.Behavior.builder()
/*  959 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  960 */               .withinDistance(5.0D, 12.0D)
/*  961 */               .animationBehavior(AVAnimations.SLEDGEHAMMER_SOLAR_AUTO_3, 0.0F)
/*  962 */               .addNextBehavior(
/*  963 */                 CECombatBehaviors.Behavior.builder()
/*  964 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  965 */                 .withinDistance(5.0D, 12.0D)
/*  966 */                 .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1, 0.0F)
/*  967 */                 .addNextBehavior(
/*  968 */                   CECombatBehaviors.Behavior.builder()
/*  969 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  970 */                   .withinDistance(5.0D, 12.0D)
/*  971 */                   .animationBehavior(AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  979 */     .newBehaviorRoot(
/*  980 */       CECombatBehaviors.BehaviorRoot.builder()
/*  981 */       .priority(1.0D)
/*  982 */       .weight(15.0D)
/*  983 */       .addFirstBehavior(
/*  984 */         CECombatBehaviors.Behavior.builder()
/*  985 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  986 */         .withinDistance(0.0D, 5.0D)
/*  987 */         .custom(HerobrineCommon::canPerformGuarding)
/*  988 */         .guard(40)))
/*      */ 
/*      */     
/*  991 */     .newBehaviorRoot(
/*  992 */       CECombatBehaviors.BehaviorRoot.builder()
/*  993 */       .priority(1.0D)
/*  994 */       .weight(10.0D)
/*  995 */       .addFirstBehavior(
/*  996 */         CECombatBehaviors.Behavior.builder()
/*  997 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  998 */         .withinDistance(0.0D, 5.0D)
/*  999 */         .animationBehavior(WOMAnimations.ENDERSTEP_FORWARD, 0.0F))
/*      */       
/* 1001 */       .addFirstBehavior(
/* 1002 */         CECombatBehaviors.Behavior.builder()
/* 1003 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1004 */         .withinDistance(0.0D, 5.0D)
/* 1005 */         .animationBehavior(WOMAnimations.ENDERSTEP_BACKWARD, 0.0F))
/*      */       
/* 1007 */       .addFirstBehavior(
/* 1008 */         CECombatBehaviors.Behavior.builder()
/* 1009 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1010 */         .withinDistance(0.0D, 5.0D)
/* 1011 */         .animationBehavior(WOMAnimations.ENDERSTEP_LEFT, 0.0F))
/*      */       
/* 1013 */       .addFirstBehavior(
/* 1014 */         CECombatBehaviors.Behavior.builder()
/* 1015 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1016 */         .withinDistance(0.0D, 5.0D)
/* 1017 */         .animationBehavior(WOMAnimations.ENDERSTEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1020 */     .newBehaviorRoot(
/* 1021 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1022 */       .priority(1.0D)
/* 1023 */       .weight(20.0D)
/* 1024 */       .maxCooldown(160)
/* 1025 */       .addFirstBehavior(
/* 1026 */         CECombatBehaviors.Behavior.builder()
/* 1027 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1028 */         .custom(HerobrineCommon::canJump)
/* 1029 */         .withinDistance(5.0D, 14.0D)
/* 1030 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1031 */         .addExBehavior(HerobrineCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineObsidianSledgehammer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */