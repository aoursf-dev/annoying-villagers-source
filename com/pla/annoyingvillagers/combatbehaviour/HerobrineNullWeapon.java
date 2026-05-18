/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HerobrineNullWeapon
/*      */ {
/*   15 */   public static final CECombatBehaviors.Builder<MobPatch<?>> NULL_WEAPON = CECombatBehaviors.builder()
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
/*   38 */         .animationBehavior(WOMAnimations.SHADOWSTEP_BACKWARD, 0.0F)
/*   39 */         .addExBehavior(CombatCommon::performEscapeRunAway))
/*      */       
/*   41 */       .addFirstBehavior(
/*   42 */         CECombatBehaviors.Behavior.builder()
/*   43 */         .custom(CombatCommon::canEscape)
/*   44 */         .withinDistance(0.0D, 48.0D)
/*   45 */         .guard(40)
/*   46 */         .addExBehavior(HerobrineCommon::performGuardWeaponSpinning)))
/*      */ 
/*      */     
/*   49 */     .newBehaviorRoot(
/*   50 */       CECombatBehaviors.BehaviorRoot.builder()
/*   51 */       .priority(2.0D)
/*   52 */       .weight(70.0D)
/*   53 */       .maxCooldown(0)
/*   54 */       .addFirstBehavior(
/*   55 */         CECombatBehaviors.Behavior.builder()
/*   56 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*   57 */         .custom(HerobrineCommon::canPerformHealing)
/*   58 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F)
/*   59 */         .addExBehavior(HerobrineCommon::performHealingAnimation)))
/*      */ 
/*      */     
/*   62 */     .newBehaviorRoot(
/*   63 */       CECombatBehaviors.BehaviorRoot.builder()
/*   64 */       .priority(1.0D)
/*   65 */       .weight(40.0D)
/*   66 */       .maxCooldown(100)
/*   67 */       .addFirstBehavior(
/*   68 */         CECombatBehaviors.Behavior.builder()
/*   69 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*   70 */         .withinDistance(0.0D, 4.0D)
/*   71 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*   72 */         .addNextBehavior(
/*   73 */           CECombatBehaviors.Behavior.builder()
/*   74 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*   75 */           .withinDistance(0.0D, 5.0D)
/*   76 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*   77 */           .addNextBehavior(
/*   78 */             CECombatBehaviors.Behavior.builder()
/*   79 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*   80 */             .withinDistance(0.0D, 5.0D)
/*   81 */             .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*   82 */             .addNextBehavior(
/*   83 */               CECombatBehaviors.Behavior.builder()
/*   84 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*   85 */               .withinDistance(0.0D, 6.0D)
/*   86 */               .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*   87 */               .addNextBehavior(
/*   88 */                 CECombatBehaviors.Behavior.builder()
/*   89 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*   90 */                 .withinDistance(0.0D, 6.0D)
/*   91 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, 0.0F)
/*   92 */                 .addNextBehavior(
/*   93 */                   CECombatBehaviors.Behavior.builder()
/*   94 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*   95 */                   .withinDistance(0.0D, 6.0D)
/*   96 */                   .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  103 */       .addFirstBehavior(
/*  104 */         CECombatBehaviors.Behavior.builder()
/*  105 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  106 */         .withinDistance(0.0D, 3.0D)
/*  107 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  108 */         .addNextBehavior(
/*  109 */           CECombatBehaviors.Behavior.builder()
/*  110 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  111 */           .withinDistance(0.0D, 4.0D)
/*  112 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  113 */           .addNextBehavior(
/*  114 */             CECombatBehaviors.Behavior.builder()
/*  115 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  116 */             .withinDistance(0.0D, 5.0D)
/*  117 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  118 */             .addNextBehavior(
/*  119 */               CECombatBehaviors.Behavior.builder()
/*  120 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  121 */               .withinDistance(0.0D, 5.0D)
/*  122 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  123 */               .addNextBehavior(
/*  124 */                 CECombatBehaviors.Behavior.builder()
/*  125 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  126 */                 .withinDistance(0.0D, 6.0D)
/*  127 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  133 */       .addFirstBehavior(
/*  134 */         CECombatBehaviors.Behavior.builder()
/*  135 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  136 */         .withinDistance(0.0D, 3.0D)
/*  137 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  138 */         .addNextBehavior(
/*  139 */           CECombatBehaviors.Behavior.builder()
/*  140 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  141 */           .withinDistance(0.0D, 4.0D)
/*  142 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  143 */           .addNextBehavior(
/*  144 */             CECombatBehaviors.Behavior.builder()
/*  145 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  146 */             .withinDistance(0.0D, 5.0D)
/*  147 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  148 */             .addNextBehavior(
/*  149 */               CECombatBehaviors.Behavior.builder()
/*  150 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  151 */               .withinDistance(0.0D, 5.0D)
/*  152 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLINK, 0.0F)
/*  153 */               .addNextBehavior(
/*  154 */                 CECombatBehaviors.Behavior.builder()
/*  155 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  156 */                 .withinDistance(0.0D, 6.0D)
/*  157 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  163 */       .addFirstBehavior(
/*  164 */         CECombatBehaviors.Behavior.builder()
/*  165 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  166 */         .withinDistance(0.0D, 3.0D)
/*  167 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  168 */         .addNextBehavior(
/*  169 */           CECombatBehaviors.Behavior.builder()
/*  170 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  171 */           .withinDistance(0.0D, 4.0D)
/*  172 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*  173 */           .addNextBehavior(
/*  174 */             CECombatBehaviors.Behavior.builder()
/*  175 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  176 */             .withinDistance(0.0D, 5.0D)
/*  177 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  178 */             .addNextBehavior(
/*  179 */               CECombatBehaviors.Behavior.builder()
/*  180 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  181 */               .withinDistance(0.0D, 5.0D)
/*  182 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F)
/*  183 */               .addNextBehavior(
/*  184 */                 CECombatBehaviors.Behavior.builder()
/*  185 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  186 */                 .withinDistance(0.0D, 6.0D)
/*  187 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  193 */       .addFirstBehavior(
/*  194 */         CECombatBehaviors.Behavior.builder()
/*  195 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  196 */         .withinDistance(0.0D, 3.0D)
/*  197 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  198 */         .addNextBehavior(
/*  199 */           CECombatBehaviors.Behavior.builder()
/*  200 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  201 */           .withinDistance(0.0D, 4.0D)
/*  202 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, 0.0F)
/*  203 */           .addNextBehavior(
/*  204 */             CECombatBehaviors.Behavior.builder()
/*  205 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  206 */             .withinDistance(0.0D, 5.0D)
/*  207 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  208 */             .addNextBehavior(
/*  209 */               CECombatBehaviors.Behavior.builder()
/*  210 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  211 */               .withinDistance(0.0D, 5.0D)
/*  212 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  213 */               .addNextBehavior(
/*  214 */                 CECombatBehaviors.Behavior.builder()
/*  215 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  216 */                 .withinDistance(0.0D, 6.0D)
/*  217 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  224 */       .addFirstBehavior(
/*  225 */         CECombatBehaviors.Behavior.builder()
/*  226 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  227 */         .withinDistance(0.0D, 3.0D)
/*  228 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  229 */         .addNextBehavior(
/*  230 */           CECombatBehaviors.Behavior.builder()
/*  231 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  232 */           .withinDistance(0.0D, 4.0D)
/*  233 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  234 */           .addNextBehavior(
/*  235 */             CECombatBehaviors.Behavior.builder()
/*  236 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  237 */             .withinDistance(0.0D, 5.0D)
/*  238 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  239 */             .addNextBehavior(
/*  240 */               CECombatBehaviors.Behavior.builder()
/*  241 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  242 */               .withinDistance(0.0D, 5.0D)
/*  243 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLINK, 0.0F)
/*  244 */               .addNextBehavior(
/*  245 */                 CECombatBehaviors.Behavior.builder()
/*  246 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  247 */                 .withinDistance(0.0D, 6.0D)
/*  248 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  254 */       .addFirstBehavior(
/*  255 */         CECombatBehaviors.Behavior.builder()
/*  256 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  257 */         .withinDistance(0.0D, 3.0D)
/*  258 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  259 */         .addNextBehavior(
/*  260 */           CECombatBehaviors.Behavior.builder()
/*  261 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  262 */           .withinDistance(0.0D, 4.0D)
/*  263 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  264 */           .addNextBehavior(
/*  265 */             CECombatBehaviors.Behavior.builder()
/*  266 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  267 */             .withinDistance(0.0D, 5.0D)
/*  268 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  269 */             .addNextBehavior(
/*  270 */               CECombatBehaviors.Behavior.builder()
/*  271 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  272 */               .withinDistance(0.0D, 5.0D)
/*  273 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F)
/*  274 */               .addNextBehavior(
/*  275 */                 CECombatBehaviors.Behavior.builder()
/*  276 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  277 */                 .withinDistance(0.0D, 6.0D)
/*  278 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  284 */       .addFirstBehavior(
/*  285 */         CECombatBehaviors.Behavior.builder()
/*  286 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  287 */         .withinDistance(0.0D, 3.0D)
/*  288 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  289 */         .addNextBehavior(
/*  290 */           CECombatBehaviors.Behavior.builder()
/*  291 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  292 */           .withinDistance(0.0D, 4.0D)
/*  293 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*  294 */           .addNextBehavior(
/*  295 */             CECombatBehaviors.Behavior.builder()
/*  296 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  297 */             .withinDistance(0.0D, 5.0D)
/*  298 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  299 */             .addNextBehavior(
/*  300 */               CECombatBehaviors.Behavior.builder()
/*  301 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  302 */               .withinDistance(0.0D, 5.0D)
/*  303 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  304 */               .addNextBehavior(
/*  305 */                 CECombatBehaviors.Behavior.builder()
/*  306 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  307 */                 .withinDistance(0.0D, 6.0D)
/*  308 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  314 */       .addFirstBehavior(
/*  315 */         CECombatBehaviors.Behavior.builder()
/*  316 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  317 */         .withinDistance(0.0D, 3.0D)
/*  318 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  319 */         .addNextBehavior(
/*  320 */           CECombatBehaviors.Behavior.builder()
/*  321 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  322 */           .withinDistance(0.0D, 4.0D)
/*  323 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, 0.0F)
/*  324 */           .addNextBehavior(
/*  325 */             CECombatBehaviors.Behavior.builder()
/*  326 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  327 */             .withinDistance(0.0D, 5.0D)
/*  328 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  329 */             .addNextBehavior(
/*  330 */               CECombatBehaviors.Behavior.builder()
/*  331 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  332 */               .withinDistance(0.0D, 5.0D)
/*  333 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLINK, 0.0F)
/*  334 */               .addNextBehavior(
/*  335 */                 CECombatBehaviors.Behavior.builder()
/*  336 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  337 */                 .withinDistance(0.0D, 6.0D)
/*  338 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  345 */       .addFirstBehavior(
/*  346 */         CECombatBehaviors.Behavior.builder()
/*  347 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  348 */         .withinDistance(0.0D, 3.0D)
/*  349 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  350 */         .addNextBehavior(
/*  351 */           CECombatBehaviors.Behavior.builder()
/*  352 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  353 */           .withinDistance(0.0D, 4.0D)
/*  354 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  355 */           .addNextBehavior(
/*  356 */             CECombatBehaviors.Behavior.builder()
/*  357 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  358 */             .withinDistance(0.0D, 5.0D)
/*  359 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  360 */             .addNextBehavior(
/*  361 */               CECombatBehaviors.Behavior.builder()
/*  362 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  363 */               .withinDistance(0.0D, 5.0D)
/*  364 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F)
/*  365 */               .addNextBehavior(
/*  366 */                 CECombatBehaviors.Behavior.builder()
/*  367 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  368 */                 .withinDistance(0.0D, 6.0D)
/*  369 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  375 */       .addFirstBehavior(
/*  376 */         CECombatBehaviors.Behavior.builder()
/*  377 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  378 */         .withinDistance(0.0D, 3.0D)
/*  379 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  380 */         .addNextBehavior(
/*  381 */           CECombatBehaviors.Behavior.builder()
/*  382 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  383 */           .withinDistance(0.0D, 4.0D)
/*  384 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  385 */           .addNextBehavior(
/*  386 */             CECombatBehaviors.Behavior.builder()
/*  387 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  388 */             .withinDistance(0.0D, 5.0D)
/*  389 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  390 */             .addNextBehavior(
/*  391 */               CECombatBehaviors.Behavior.builder()
/*  392 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  393 */               .withinDistance(0.0D, 5.0D)
/*  394 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  395 */               .addNextBehavior(
/*  396 */                 CECombatBehaviors.Behavior.builder()
/*  397 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  398 */                 .withinDistance(0.0D, 6.0D)
/*  399 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  405 */       .addFirstBehavior(
/*  406 */         CECombatBehaviors.Behavior.builder()
/*  407 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  408 */         .withinDistance(0.0D, 3.0D)
/*  409 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  410 */         .addNextBehavior(
/*  411 */           CECombatBehaviors.Behavior.builder()
/*  412 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  413 */           .withinDistance(0.0D, 4.0D)
/*  414 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*  415 */           .addNextBehavior(
/*  416 */             CECombatBehaviors.Behavior.builder()
/*  417 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  418 */             .withinDistance(0.0D, 5.0D)
/*  419 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  420 */             .addNextBehavior(
/*  421 */               CECombatBehaviors.Behavior.builder()
/*  422 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  423 */               .withinDistance(0.0D, 5.0D)
/*  424 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLINK, 0.0F)
/*  425 */               .addNextBehavior(
/*  426 */                 CECombatBehaviors.Behavior.builder()
/*  427 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  428 */                 .withinDistance(0.0D, 6.0D)
/*  429 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  435 */       .addFirstBehavior(
/*  436 */         CECombatBehaviors.Behavior.builder()
/*  437 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  438 */         .withinDistance(0.0D, 3.0D)
/*  439 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  440 */         .addNextBehavior(
/*  441 */           CECombatBehaviors.Behavior.builder()
/*  442 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  443 */           .withinDistance(0.0D, 4.0D)
/*  444 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, 0.0F)
/*  445 */           .addNextBehavior(
/*  446 */             CECombatBehaviors.Behavior.builder()
/*  447 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  448 */             .withinDistance(0.0D, 5.0D)
/*  449 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  450 */             .addNextBehavior(
/*  451 */               CECombatBehaviors.Behavior.builder()
/*  452 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  453 */               .withinDistance(0.0D, 5.0D)
/*  454 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F)
/*  455 */               .addNextBehavior(
/*  456 */                 CECombatBehaviors.Behavior.builder()
/*  457 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  458 */                 .withinDistance(0.0D, 6.0D)
/*  459 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  466 */       .addFirstBehavior(
/*  467 */         CECombatBehaviors.Behavior.builder()
/*  468 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  469 */         .withinDistance(0.0D, 3.0D)
/*  470 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  471 */         .addNextBehavior(
/*  472 */           CECombatBehaviors.Behavior.builder()
/*  473 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  474 */           .withinDistance(0.0D, 4.0D)
/*  475 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  476 */           .addNextBehavior(
/*  477 */             CECombatBehaviors.Behavior.builder()
/*  478 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  479 */             .withinDistance(0.0D, 5.0D)
/*  480 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  481 */             .addNextBehavior(
/*  482 */               CECombatBehaviors.Behavior.builder()
/*  483 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  484 */               .withinDistance(0.0D, 5.0D)
/*  485 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  486 */               .addNextBehavior(
/*  487 */                 CECombatBehaviors.Behavior.builder()
/*  488 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  489 */                 .withinDistance(0.0D, 6.0D)
/*  490 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_BACKWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  496 */       .addFirstBehavior(
/*  497 */         CECombatBehaviors.Behavior.builder()
/*  498 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  499 */         .withinDistance(0.0D, 3.0D)
/*  500 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  501 */         .addNextBehavior(
/*  502 */           CECombatBehaviors.Behavior.builder()
/*  503 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  504 */           .withinDistance(0.0D, 4.0D)
/*  505 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  506 */           .addNextBehavior(
/*  507 */             CECombatBehaviors.Behavior.builder()
/*  508 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  509 */             .withinDistance(0.0D, 5.0D)
/*  510 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  511 */             .addNextBehavior(
/*  512 */               CECombatBehaviors.Behavior.builder()
/*  513 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  514 */               .withinDistance(0.0D, 5.0D)
/*  515 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLINK, 0.0F)
/*  516 */               .addNextBehavior(
/*  517 */                 CECombatBehaviors.Behavior.builder()
/*  518 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  519 */                 .withinDistance(0.0D, 6.0D)
/*  520 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_FORWARD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  526 */       .addFirstBehavior(
/*  527 */         CECombatBehaviors.Behavior.builder()
/*  528 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  529 */         .withinDistance(0.0D, 3.0D)
/*  530 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  531 */         .addNextBehavior(
/*  532 */           CECombatBehaviors.Behavior.builder()
/*  533 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  534 */           .withinDistance(0.0D, 4.0D)
/*  535 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*  536 */           .addNextBehavior(
/*  537 */             CECombatBehaviors.Behavior.builder()
/*  538 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  539 */             .withinDistance(0.0D, 5.0D)
/*  540 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  541 */             .addNextBehavior(
/*  542 */               CECombatBehaviors.Behavior.builder()
/*  543 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  544 */               .withinDistance(0.0D, 5.0D)
/*  545 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F)
/*  546 */               .addNextBehavior(
/*  547 */                 CECombatBehaviors.Behavior.builder()
/*  548 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  549 */                 .withinDistance(0.0D, 6.0D)
/*  550 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_LEFT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  556 */       .addFirstBehavior(
/*  557 */         CECombatBehaviors.Behavior.builder()
/*  558 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  559 */         .withinDistance(0.0D, 3.0D)
/*  560 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  561 */         .addNextBehavior(
/*  562 */           CECombatBehaviors.Behavior.builder()
/*  563 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  564 */           .withinDistance(0.0D, 4.0D)
/*  565 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, 0.0F)
/*  566 */           .addNextBehavior(
/*  567 */             CECombatBehaviors.Behavior.builder()
/*  568 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  569 */             .withinDistance(0.0D, 5.0D)
/*  570 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  571 */             .addNextBehavior(
/*  572 */               CECombatBehaviors.Behavior.builder()
/*  573 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  574 */               .withinDistance(0.0D, 5.0D)
/*  575 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  576 */               .addNextBehavior(
/*  577 */                 CECombatBehaviors.Behavior.builder()
/*  578 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  579 */                 .withinDistance(0.0D, 6.0D)
/*  580 */                 .animationBehavior(WOMAnimations.SHADOWSTEP_RIGHT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  587 */       .addFirstBehavior(
/*  588 */         CECombatBehaviors.Behavior.builder()
/*  589 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  590 */         .withinDistance(0.0D, 3.0D)
/*  591 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  592 */         .addNextBehavior(
/*  593 */           CECombatBehaviors.Behavior.builder()
/*  594 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  595 */           .withinDistance(0.0D, 4.0D)
/*  596 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  597 */           .addNextBehavior(
/*  598 */             CECombatBehaviors.Behavior.builder()
/*  599 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  600 */             .withinDistance(0.0D, 5.0D)
/*  601 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  602 */             .addNextBehavior(
/*  603 */               CECombatBehaviors.Behavior.builder()
/*  604 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  605 */               .withinDistance(0.0D, 5.0D)
/*  606 */               .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  607 */               .addNextBehavior(
/*  608 */                 CECombatBehaviors.Behavior.builder()
/*  609 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  610 */                 .withinDistance(0.0D, 6.0D)
/*  611 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  612 */                 .addNextBehavior(
/*  613 */                   CECombatBehaviors.Behavior.builder()
/*  614 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  615 */                   .withinDistance(0.0D, 6.0D)
/*  616 */                   .animationBehavior(WOMAnimations.SHADOWSTEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  623 */       .addFirstBehavior(
/*  624 */         CECombatBehaviors.Behavior.builder()
/*  625 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  626 */         .withinDistance(0.0D, 3.0D)
/*  627 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  628 */         .addNextBehavior(
/*  629 */           CECombatBehaviors.Behavior.builder()
/*  630 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  631 */           .withinDistance(0.0D, 4.0D)
/*  632 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  633 */           .addNextBehavior(
/*  634 */             CECombatBehaviors.Behavior.builder()
/*  635 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  636 */             .withinDistance(0.0D, 5.0D)
/*  637 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  638 */             .addNextBehavior(
/*  639 */               CECombatBehaviors.Behavior.builder()
/*  640 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  641 */               .withinDistance(0.0D, 5.0D)
/*  642 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, 0.0F)
/*  643 */               .addNextBehavior(
/*  644 */                 CECombatBehaviors.Behavior.builder()
/*  645 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  646 */                 .withinDistance(0.0D, 6.0D)
/*  647 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLINK, 0.0F)
/*  648 */                 .addNextBehavior(
/*  649 */                   CECombatBehaviors.Behavior.builder()
/*  650 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  651 */                   .withinDistance(0.0D, 6.0D)
/*  652 */                   .animationBehavior(WOMAnimations.SHADOWSTEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  659 */       .addFirstBehavior(
/*  660 */         CECombatBehaviors.Behavior.builder()
/*  661 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  662 */         .withinDistance(0.0D, 3.0D)
/*  663 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  664 */         .addNextBehavior(
/*  665 */           CECombatBehaviors.Behavior.builder()
/*  666 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  667 */           .withinDistance(0.0D, 4.0D)
/*  668 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*  669 */           .addNextBehavior(
/*  670 */             CECombatBehaviors.Behavior.builder()
/*  671 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  672 */             .withinDistance(0.0D, 5.0D)
/*  673 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  674 */             .addNextBehavior(
/*  675 */               CECombatBehaviors.Behavior.builder()
/*  676 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  677 */               .withinDistance(0.0D, 5.0D)
/*  678 */               .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  679 */               .addNextBehavior(
/*  680 */                 CECombatBehaviors.Behavior.builder()
/*  681 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  682 */                 .withinDistance(0.0D, 6.0D)
/*  683 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F)
/*  684 */                 .addNextBehavior(
/*  685 */                   CECombatBehaviors.Behavior.builder()
/*  686 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  687 */                   .withinDistance(0.0D, 6.0D)
/*  688 */                   .animationBehavior(WOMAnimations.SHADOWSTEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  695 */       .addFirstBehavior(
/*  696 */         CECombatBehaviors.Behavior.builder()
/*  697 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  698 */         .withinDistance(0.0D, 3.0D)
/*  699 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  700 */         .addNextBehavior(
/*  701 */           CECombatBehaviors.Behavior.builder()
/*  702 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  703 */           .withinDistance(0.0D, 4.0D)
/*  704 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, 0.0F)
/*  705 */           .addNextBehavior(
/*  706 */             CECombatBehaviors.Behavior.builder()
/*  707 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  708 */             .withinDistance(0.0D, 5.0D)
/*  709 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  710 */             .addNextBehavior(
/*  711 */               CECombatBehaviors.Behavior.builder()
/*  712 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  713 */               .withinDistance(0.0D, 5.0D)
/*  714 */               .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  715 */               .addNextBehavior(
/*  716 */                 CECombatBehaviors.Behavior.builder()
/*  717 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  718 */                 .withinDistance(0.0D, 6.0D)
/*  719 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  720 */                 .addNextBehavior(
/*  721 */                   CECombatBehaviors.Behavior.builder()
/*  722 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  723 */                   .withinDistance(0.0D, 6.0D)
/*  724 */                   .animationBehavior(WOMAnimations.SHADOWSTEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  731 */       .addFirstBehavior(
/*  732 */         CECombatBehaviors.Behavior.builder()
/*  733 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  734 */         .withinDistance(0.0D, 3.0D)
/*  735 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  736 */         .addNextBehavior(
/*  737 */           CECombatBehaviors.Behavior.builder()
/*  738 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  739 */           .withinDistance(0.0D, 4.0D)
/*  740 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*  741 */           .addNextBehavior(
/*  742 */             CECombatBehaviors.Behavior.builder()
/*  743 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  744 */             .withinDistance(0.0D, 5.0D)
/*  745 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  746 */             .addNextBehavior(
/*  747 */               CECombatBehaviors.Behavior.builder()
/*  748 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  749 */               .withinDistance(0.0D, 5.0D)
/*  750 */               .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  751 */               .addNextBehavior(
/*  752 */                 CECombatBehaviors.Behavior.builder()
/*  753 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  754 */                 .withinDistance(0.0D, 6.0D)
/*  755 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLINK, 0.0F)
/*  756 */                 .addNextBehavior(
/*  757 */                   CECombatBehaviors.Behavior.builder()
/*  758 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  759 */                   .withinDistance(0.0D, 6.0D)
/*  760 */                   .animationBehavior(WOMAnimations.SHADOWSTEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  767 */       .addFirstBehavior(
/*  768 */         CECombatBehaviors.Behavior.builder()
/*  769 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  770 */         .withinDistance(0.0D, 3.0D)
/*  771 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  772 */         .addNextBehavior(
/*  773 */           CECombatBehaviors.Behavior.builder()
/*  774 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  775 */           .withinDistance(0.0D, 4.0D)
/*  776 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  777 */           .addNextBehavior(
/*  778 */             CECombatBehaviors.Behavior.builder()
/*  779 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  780 */             .withinDistance(0.0D, 5.0D)
/*  781 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  782 */             .addNextBehavior(
/*  783 */               CECombatBehaviors.Behavior.builder()
/*  784 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  785 */               .withinDistance(0.0D, 5.0D)
/*  786 */               .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*  787 */               .addNextBehavior(
/*  788 */                 CECombatBehaviors.Behavior.builder()
/*  789 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  790 */                 .withinDistance(0.0D, 6.0D)
/*  791 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F)
/*  792 */                 .addNextBehavior(
/*  793 */                   CECombatBehaviors.Behavior.builder()
/*  794 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  795 */                   .withinDistance(0.0D, 6.0D)
/*  796 */                   .animationBehavior(WOMAnimations.SHADOWSTEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  803 */       .addFirstBehavior(
/*  804 */         CECombatBehaviors.Behavior.builder()
/*  805 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  806 */         .withinDistance(0.0D, 3.0D)
/*  807 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F)
/*  808 */         .addNextBehavior(
/*  809 */           CECombatBehaviors.Behavior.builder()
/*  810 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  811 */           .withinDistance(0.0D, 4.0D)
/*  812 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  813 */           .addNextBehavior(
/*  814 */             CECombatBehaviors.Behavior.builder()
/*  815 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  816 */             .withinDistance(0.0D, 5.0D)
/*  817 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_2, 0.0F)
/*  818 */             .addNextBehavior(
/*  819 */               CECombatBehaviors.Behavior.builder()
/*  820 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  821 */               .withinDistance(0.0D, 5.0D)
/*  822 */               .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, 0.0F)
/*  823 */               .addNextBehavior(
/*  824 */                 CECombatBehaviors.Behavior.builder()
/*  825 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  826 */                 .withinDistance(0.0D, 6.0D)
/*  827 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  828 */                 .addNextBehavior(
/*  829 */                   CECombatBehaviors.Behavior.builder()
/*  830 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  831 */                   .withinDistance(0.0D, 6.0D)
/*  832 */                   .animationBehavior(WOMAnimations.SHADOWSTEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  839 */       .addFirstBehavior(
/*  840 */         CECombatBehaviors.Behavior.builder()
/*  841 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  842 */         .withinDistance(0.0D, 3.0D)
/*  843 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_4, 0.0F)
/*  844 */         .addNextBehavior(
/*  845 */           CECombatBehaviors.Behavior.builder()
/*  846 */           .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  847 */           .withinDistance(0.0D, 4.0D)
/*  848 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)
/*  849 */           .addNextBehavior(
/*  850 */             CECombatBehaviors.Behavior.builder()
/*  851 */             .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  852 */             .withinDistance(0.0D, 5.0D)
/*  853 */             .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_1, 0.0F)
/*  854 */             .addNextBehavior(
/*  855 */               CECombatBehaviors.Behavior.builder()
/*  856 */               .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  857 */               .withinDistance(0.0D, 5.0D)
/*  858 */               .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  859 */               .addNextBehavior(
/*  860 */                 CECombatBehaviors.Behavior.builder()
/*  861 */                 .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  862 */                 .withinDistance(0.0D, 6.0D)
/*  863 */                 .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLINK, 0.0F)
/*  864 */                 .addNextBehavior(
/*  865 */                   CECombatBehaviors.Behavior.builder()
/*  866 */                   .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  867 */                   .withinDistance(0.0D, 6.0D)
/*  868 */                   .animationBehavior(WOMAnimations.SHADOWSTEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  877 */     .newBehaviorRoot(
/*  878 */       CECombatBehaviors.BehaviorRoot.builder()
/*  879 */       .priority(1.0D)
/*  880 */       .weight(40.0D)
/*  881 */       .maxCooldown(100)
/*  882 */       .addFirstBehavior(
/*  883 */         CECombatBehaviors.Behavior.builder()
/*  884 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  885 */         .withinDistance(2.0D, 15.0D)
/*  886 */         .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_1, 0.0F)
/*  887 */         .addNextBehavior(
/*  888 */           CECombatBehaviors.Behavior.builder()
/*  889 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  890 */           .withinDistance(2.0D, 15.0D)
/*  891 */           .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_2, 0.0F)
/*  892 */           .addNextBehavior(
/*  893 */             CECombatBehaviors.Behavior.builder()
/*  894 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  895 */             .withinDistance(2.0D, 15.0D)
/*  896 */             .animationBehavior(AVAnimations.NULL_ANTITHEUS_ASCENDED_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  901 */     .newBehaviorRoot(
/*  902 */       CECombatBehaviors.BehaviorRoot.builder()
/*  903 */       .priority(1.0D)
/*  904 */       .weight(30.0D)
/*  905 */       .maxCooldown(80)
/*  906 */       .addFirstBehavior(
/*  907 */         CECombatBehaviors.Behavior.builder()
/*  908 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  909 */         .withinDistance(2.0D, 15.0D)
/*  910 */         .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  911 */         .addNextBehavior(
/*  912 */           CECombatBehaviors.Behavior.builder()
/*  913 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  914 */           .withinDistance(2.0D, 15.0D)
/*  915 */           .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)
/*  916 */           .addNextBehavior(
/*  917 */             CECombatBehaviors.Behavior.builder()
/*  918 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  919 */             .withinDistance(2.0D, 15.0D)
/*  920 */             .animationBehavior(AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  925 */     .newBehaviorRoot(
/*  926 */       CECombatBehaviors.BehaviorRoot.builder()
/*  927 */       .priority(1.0D)
/*  928 */       .weight(20.0D)
/*  929 */       .maxCooldown(100)
/*  930 */       .addFirstBehavior(
/*  931 */         CECombatBehaviors.Behavior.builder()
/*  932 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  933 */         .withinDistance(0.0D, 5.0D)
/*  934 */         .animationBehavior(AnimsAgony.AGONY_AIR_ATTACK_3, 0.0F))
/*      */       
/*  936 */       .addFirstBehavior(
/*  937 */         CECombatBehaviors.Behavior.builder()
/*  938 */         .custom(CombatCommon::canPerformNormalAttackLogic).custom(HerobrineCommon::canPlaySecondFormAnimation)
/*  939 */         .withinDistance(0.0D, 5.0D)
/*  940 */         .animationBehavior(AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F)))
/*      */ 
/*      */     
/*  943 */     .newBehaviorRoot(
/*  944 */       CECombatBehaviors.BehaviorRoot.builder()
/*  945 */       .priority(1.0D)
/*  946 */       .weight(15.0D)
/*  947 */       .maxCooldown(600)
/*  948 */       .addFirstBehavior(
/*  949 */         CECombatBehaviors.Behavior.builder()
/*  950 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  951 */         .withinDistance(2.0D, 15.0D)
/*  952 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  953 */         .addExBehavior(HerobrineCommon::releaseWeapon)))
/*      */ 
/*      */     
/*  956 */     .newBehaviorRoot(
/*  957 */       CECombatBehaviors.BehaviorRoot.builder()
/*  958 */       .priority(1.0D)
/*  959 */       .weight(25.0D)
/*  960 */       .maxCooldown(600)
/*  961 */       .addFirstBehavior(
/*  962 */         CECombatBehaviors.Behavior.builder()
/*  963 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  964 */         .withinDistance(2.0D, 15.0D)
/*  965 */         .custom(HerobrineCommon::canSummonNullSkeleton)
/*  966 */         .animationBehavior(AVAnimations.NULL_SKELETON_ANTITHEUS_ASCENSION, 0.0F)))
/*      */ 
/*      */     
/*  969 */     .newBehaviorRoot(
/*  970 */       CECombatBehaviors.BehaviorRoot.builder()
/*  971 */       .priority(1.0D)
/*  972 */       .weight(15.0D)
/*  973 */       .maxCooldown(100)
/*  974 */       .addFirstBehavior(
/*  975 */         CECombatBehaviors.Behavior.builder()
/*  976 */         .withinDistance(0.0D, 4.0D)
/*  977 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  978 */         .custom(HerobrineCommon::canPerformGuarding)
/*  979 */         .guard(40)
/*  980 */         .addExBehavior(HerobrineCommon::performGuardWeaponSpinning)))
/*      */ 
/*      */     
/*  983 */     .newBehaviorRoot(
/*  984 */       CECombatBehaviors.BehaviorRoot.builder()
/*  985 */       .priority(1.0D)
/*  986 */       .weight(10.0D)
/*  987 */       .addFirstBehavior(
/*  988 */         CECombatBehaviors.Behavior.builder()
/*  989 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  990 */         .withinDistance(2.0D, 15.0D)
/*  991 */         .animationBehavior(WOMAnimations.SHADOWSTEP_FORWARD, 0.0F))
/*      */       
/*  993 */       .addFirstBehavior(
/*  994 */         CECombatBehaviors.Behavior.builder()
/*  995 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  996 */         .withinDistance(2.0D, 15.0D)
/*  997 */         .animationBehavior(WOMAnimations.SHADOWSTEP_BACKWARD, 0.0F))
/*      */       
/*  999 */       .addFirstBehavior(
/* 1000 */         CECombatBehaviors.Behavior.builder()
/* 1001 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1002 */         .withinDistance(2.0D, 15.0D)
/* 1003 */         .animationBehavior(WOMAnimations.SHADOWSTEP_RIGHT, 0.0F))
/*      */       
/* 1005 */       .addFirstBehavior(
/* 1006 */         CECombatBehaviors.Behavior.builder()
/* 1007 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1008 */         .withinDistance(2.0D, 15.0D)
/* 1009 */         .animationBehavior(WOMAnimations.SHADOWSTEP_LEFT, 0.0F)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineNullWeapon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */