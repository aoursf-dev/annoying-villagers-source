/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ import com.pla.annoyingvillagers.entity.AngrySteveEntity;
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*      */ import com.pla.annoyingvillagers.task.DelayedTask;
/*      */ import com.pla.efkick.gameasset.EFKickAnimations;
/*      */ import net.minecraft.core.particles.ParticleOptions;
/*      */ import net.minecraft.core.particles.ParticleTypes;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.sounds.SoundEvent;
/*      */ import net.minecraft.sounds.SoundSource;
/*      */ import net.minecraft.world.effect.MobEffect;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsRuine;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*      */ import yesman.epicfight.api.asset.AssetAccessor;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ 
/*      */ public class AngrySteveLegendarySword {
/*      */   static void legendarySwordHeavyAttack(final MobPatch<?> mobpatch) {
/*   27 */     final AngrySteveEntity steveEntity = (AngrySteveEntity)mobpatch.getOriginal();
/*   28 */     ItemStack itemStack = steveEntity.m_21205_();
/*   29 */     if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.LegendarySwordItem) { Level level = steveEntity.m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/*   30 */         steveEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/*   31 */         serverLevel.m_6263_(null, steveEntity
/*      */             
/*   33 */             .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.STEVE_SAY_ON_ATTACK
/*   34 */             .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */         
/*   38 */         new DelayedTask(10)
/*      */           {
/*      */             public void run() {
/*   41 */               serverLevel.m_6263_(null, steveEntity
/*      */                   
/*   43 */                   .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_START
/*   44 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   49 */               serverLevel.m_6263_(null, steveEntity
/*      */                   
/*   51 */                   .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD
/*   52 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   57 */               serverLevel.m_6263_(null, steveEntity
/*      */                   
/*   59 */                   .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD_2
/*   60 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   65 */               serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, steveEntity
/*      */                   
/*   67 */                   .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), 15, 0.0D, 0.0D, 0.0D, 0.2D);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   72 */               serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, steveEntity
/*      */                   
/*   74 */                   .m_20185_(), steveEntity.m_20188_(), steveEntity.m_20189_(), 100, 0.0D, 0.0D, 0.0D, 0.5D);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   79 */               mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_HEAVY_ATTACK, 0.0F);
/*      */             }
/*      */           }; }
/*      */        }
/*      */   
/*      */   }
/*      */   static void legendarySwordSpecialAttack(final MobPatch<?> mobpatch) {
/*   86 */     AngrySteveEntity steveEntity = (AngrySteveEntity)mobpatch.getOriginal();
/*   87 */     ItemStack itemStack = steveEntity.m_21205_();
/*   88 */     if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.LegendarySwordItem && steveEntity.m_9236_() instanceof ServerLevel) {
/*   89 */       steveEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/*   90 */       new DelayedTask(20)
/*      */         {
/*      */           public void run() {
/*   93 */             mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F);
/*      */           }
/*      */         };
/*      */     } 
/*      */   }
/*      */   
/*   99 */   public static final CECombatBehaviors.Builder<MobPatch<?>> LEGENDARY_SWORD = CECombatBehaviors.builder()
/*  100 */     .newBehaviorRoot(
/*  101 */       CECombatBehaviors.BehaviorRoot.builder()
/*  102 */       .priority(4.0D)
/*  103 */       .weight(1000.0D)
/*  104 */       .maxCooldown(0)
/*  105 */       .addFirstBehavior(
/*  106 */         CECombatBehaviors.Behavior.builder()
/*  107 */         .custom(CombatCommon::canExecute)
/*  108 */         .withinDistance(0.0D, 5.0D)
/*  109 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  110 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  113 */     .newBehaviorRoot(
/*  114 */       CECombatBehaviors.BehaviorRoot.builder()
/*  115 */       .priority(3.0D)
/*  116 */       .weight(1000.0D)
/*  117 */       .maxCooldown(0)
/*  118 */       .addFirstBehavior(
/*  119 */         CECombatBehaviors.Behavior.builder()
/*  120 */         .custom(CombatCommon::canEscape)
/*  121 */         .withinDistance(0.0D, 8.0D)
/*  122 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  123 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  125 */       .addFirstBehavior(
/*  126 */         CECombatBehaviors.Behavior.builder()
/*  127 */         .custom(CombatCommon::canEscape)
/*  128 */         .withinDistance(0.0D, 48.0D)
/*  129 */         .guard(40)))
/*      */ 
/*      */     
/*  132 */     .newBehaviorRoot(
/*  133 */       CECombatBehaviors.BehaviorRoot.builder()
/*  134 */       .priority(2.0D)
/*  135 */       .weight(70.0D)
/*  136 */       .maxCooldown(0)
/*  137 */       .addFirstBehavior(
/*  138 */         CECombatBehaviors.Behavior.builder()
/*  139 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  140 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  141 */         .custom(CombatCommon::canPerformEating)
/*  142 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  143 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  146 */     .newBehaviorRoot(
/*  147 */       CECombatBehaviors.BehaviorRoot.builder()
/*  148 */       .priority(2.0D)
/*  149 */       .weight(100.0D)
/*  150 */       .maxCooldown(120)
/*  151 */       .addFirstBehavior(
/*  152 */         CECombatBehaviors.Behavior.builder()
/*  153 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  154 */         .custom(CombatCommon::canSwapToBow)
/*  155 */         .withinDistance(7.0D, 14.0D)
/*  156 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  157 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  159 */       .addFirstBehavior(
/*  160 */         CECombatBehaviors.Behavior.builder()
/*  161 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  162 */         .custom(CombatCommon::canSwapToBow)
/*  163 */         .withinDistance(7.0D, 14.0D)
/*  164 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  165 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  167 */       .addFirstBehavior(
/*  168 */         CECombatBehaviors.Behavior.builder()
/*  169 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  170 */         .custom(CombatCommon::canSwapToBow)
/*  171 */         .withinDistance(7.0D, 14.0D)
/*  172 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  173 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  175 */       .addFirstBehavior(
/*  176 */         CECombatBehaviors.Behavior.builder()
/*  177 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  178 */         .custom(CombatCommon::canSwapToBow)
/*  179 */         .withinDistance(7.0D, 14.0D)
/*  180 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  181 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  184 */     .newBehaviorRoot(
/*  185 */       CECombatBehaviors.BehaviorRoot.builder()
/*  186 */       .priority(2.0D)
/*  187 */       .weight(80.0D)
/*  188 */       .maxCooldown(120)
/*  189 */       .addFirstBehavior(
/*  190 */         CECombatBehaviors.Behavior.builder()
/*  191 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  192 */         .custom(CombatCommon::canThrowEnderPearl)
/*  193 */         .withinDistance(7.0D, 48.0D)
/*  194 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  195 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  198 */     .newBehaviorRoot(
/*  199 */       CECombatBehaviors.BehaviorRoot.builder()
/*  200 */       .priority(1.0D)
/*  201 */       .weight(40.0D)
/*  202 */       .maxCooldown(20)
/*  203 */       .addFirstBehavior(
/*  204 */         CECombatBehaviors.Behavior.builder()
/*  205 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  206 */         .withinDistance(0.0D, 5.0D)
/*  207 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  208 */         .addNextBehavior(
/*  209 */           CECombatBehaviors.Behavior.builder()
/*  210 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  211 */           .withinDistance(0.0D, 6.0D)
/*  212 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  213 */           .addNextBehavior(
/*  214 */             CECombatBehaviors.Behavior.builder()
/*  215 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  216 */             .withinDistance(0.0D, 6.0D)
/*  217 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  218 */             .addNextBehavior(
/*  219 */               CECombatBehaviors.Behavior.builder()
/*  220 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  221 */               .withinDistance(0.0D, 6.0D)
/*  222 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  223 */               .addNextBehavior(
/*  224 */                 CECombatBehaviors.Behavior.builder()
/*  225 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  226 */                 .withinDistance(0.0D, 7.0D)
/*  227 */                 .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  228 */                 .addNextBehavior(
/*  229 */                   CECombatBehaviors.Behavior.builder()
/*  230 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  231 */                   .withinDistance(0.0D, 7.0D)
/*  232 */                   .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  233 */                   .addNextBehavior(
/*  234 */                     CECombatBehaviors.Behavior.builder()
/*  235 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  236 */                     .withinDistance(0.0D, 7.0D)
/*  237 */                     .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/*  238 */                     .addNextBehavior(
/*  239 */                       CECombatBehaviors.Behavior.builder()
/*  240 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  241 */                       .withinDistance(0.0D, 7.0D)
/*  242 */                       .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  252 */       .addFirstBehavior(
/*  253 */         CECombatBehaviors.Behavior.builder()
/*  254 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  255 */         .withinDistance(0.0D, 5.0D)
/*  256 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  257 */         .addNextBehavior(
/*  258 */           CECombatBehaviors.Behavior.builder()
/*  259 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  260 */           .withinDistance(0.0D, 6.0D)
/*  261 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  262 */           .addNextBehavior(
/*  263 */             CECombatBehaviors.Behavior.builder()
/*  264 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  265 */             .withinDistance(0.0D, 6.0D)
/*  266 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  267 */             .addNextBehavior(
/*  268 */               CECombatBehaviors.Behavior.builder()
/*  269 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  270 */               .withinDistance(0.0D, 7.0D)
/*  271 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  277 */       .addFirstBehavior(
/*  278 */         CECombatBehaviors.Behavior.builder()
/*  279 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  280 */         .withinDistance(0.0D, 5.0D)
/*  281 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  282 */         .addNextBehavior(
/*  283 */           CECombatBehaviors.Behavior.builder()
/*  284 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  285 */           .withinDistance(0.0D, 5.0D)
/*  286 */           .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  287 */           .addNextBehavior(
/*  288 */             CECombatBehaviors.Behavior.builder()
/*  289 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  290 */             .withinDistance(0.0D, 5.0D)
/*  291 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F).addNextBehavior(
/*  292 */               CECombatBehaviors.Behavior.builder()
/*  293 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  294 */               .withinDistance(0.0D, 5.0D)
/*  295 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  300 */       .addFirstBehavior(
/*  301 */         CECombatBehaviors.Behavior.builder()
/*  302 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  303 */         .withinDistance(0.0D, 5.0D)
/*  304 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  305 */         .addNextBehavior(
/*  306 */           CECombatBehaviors.Behavior.builder()
/*  307 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  308 */           .withinDistance(0.0D, 6.0D)
/*  309 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  310 */           .addNextBehavior(
/*  311 */             CECombatBehaviors.Behavior.builder()
/*  312 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  313 */             .withinDistance(0.0D, 6.0D)
/*  314 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  315 */             .addNextBehavior(
/*  316 */               CECombatBehaviors.Behavior.builder()
/*  317 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  318 */               .withinDistance(0.0D, 6.0D)
/*  319 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  320 */               .addNextBehavior(
/*  321 */                 CECombatBehaviors.Behavior.builder()
/*  322 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  323 */                 .withinDistance(0.0D, 8.0D)
/*  324 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  330 */       .addFirstBehavior(
/*  331 */         CECombatBehaviors.Behavior.builder()
/*  332 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  333 */         .withinDistance(0.0D, 5.0D)
/*  334 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  335 */         .addNextBehavior(
/*  336 */           CECombatBehaviors.Behavior.builder()
/*  337 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  338 */           .withinDistance(0.0D, 6.0D)
/*  339 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/*  340 */           .addNextBehavior(
/*  341 */             CECombatBehaviors.Behavior.builder()
/*  342 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  343 */             .withinDistance(0.0D, 6.0D)
/*  344 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  345 */             .addNextBehavior(
/*  346 */               CECombatBehaviors.Behavior.builder()
/*  347 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  348 */               .withinDistance(0.0D, 6.0D)
/*  349 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  350 */               .addNextBehavior(
/*  351 */                 CECombatBehaviors.Behavior.builder()
/*  352 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  353 */                 .withinDistance(0.0D, 8.0D)
/*  354 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  360 */       .addFirstBehavior(
/*  361 */         CECombatBehaviors.Behavior.builder()
/*  362 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  363 */         .withinDistance(0.0D, 5.0D)
/*  364 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  365 */         .addNextBehavior(
/*  366 */           CECombatBehaviors.Behavior.builder()
/*  367 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  368 */           .withinDistance(0.0D, 6.0D)
/*  369 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  370 */           .addNextBehavior(
/*  371 */             CECombatBehaviors.Behavior.builder()
/*  372 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  373 */             .withinDistance(0.0D, 6.0D)
/*  374 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  375 */             .addNextBehavior(
/*  376 */               CECombatBehaviors.Behavior.builder()
/*  377 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  378 */               .withinDistance(0.0D, 6.0D)
/*  379 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  385 */       .addFirstBehavior(
/*  386 */         CECombatBehaviors.Behavior.builder()
/*  387 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  388 */         .withinDistance(0.0D, 5.0D)
/*  389 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  390 */         .addNextBehavior(
/*  391 */           CECombatBehaviors.Behavior.builder()
/*  392 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  393 */           .withinDistance(0.0D, 6.0D)
/*  394 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  395 */           .addNextBehavior(
/*  396 */             CECombatBehaviors.Behavior.builder()
/*  397 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  398 */             .withinDistance(0.0D, 6.0D)
/*  399 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  400 */             .addNextBehavior(
/*  401 */               CECombatBehaviors.Behavior.builder()
/*  402 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  403 */               .withinDistance(0.0D, 6.0D)
/*  404 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  410 */       .addFirstBehavior(
/*  411 */         CECombatBehaviors.Behavior.builder()
/*  412 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  413 */         .withinDistance(0.0D, 5.0D)
/*  414 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  415 */         .addNextBehavior(
/*  416 */           CECombatBehaviors.Behavior.builder()
/*  417 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  418 */           .withinDistance(0.0D, 6.0D)
/*  419 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  420 */           .addNextBehavior(
/*  421 */             CECombatBehaviors.Behavior.builder()
/*  422 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  423 */             .withinDistance(0.0D, 6.0D)
/*  424 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  425 */             .addNextBehavior(
/*  426 */               CECombatBehaviors.Behavior.builder()
/*  427 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  428 */               .withinDistance(0.0D, 6.0D)
/*  429 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  435 */       .addFirstBehavior(
/*  436 */         CECombatBehaviors.Behavior.builder()
/*  437 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  438 */         .withinDistance(0.0D, 5.0D)
/*  439 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  440 */         .addNextBehavior(
/*  441 */           CECombatBehaviors.Behavior.builder()
/*  442 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  443 */           .withinDistance(0.0D, 6.0D)
/*  444 */           .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  445 */           .addNextBehavior(
/*  446 */             CECombatBehaviors.Behavior.builder()
/*  447 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  448 */             .withinDistance(0.0D, 6.0D)
/*  449 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  450 */             .addNextBehavior(
/*  451 */               CECombatBehaviors.Behavior.builder()
/*  452 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  453 */               .withinDistance(0.0D, 6.0D)
/*  454 */               .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  460 */       .addFirstBehavior(
/*  461 */         CECombatBehaviors.Behavior.builder()
/*  462 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  463 */         .withinDistance(0.0D, 5.0D)
/*  464 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  465 */         .addNextBehavior(
/*  466 */           CECombatBehaviors.Behavior.builder()
/*  467 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  468 */           .withinDistance(0.0D, 6.0D)
/*  469 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  470 */           .addNextBehavior(
/*  471 */             CECombatBehaviors.Behavior.builder()
/*  472 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  473 */             .withinDistance(0.0D, 6.0D)
/*  474 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/*  475 */             .addNextBehavior(
/*  476 */               CECombatBehaviors.Behavior.builder()
/*  477 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  478 */               .withinDistance(0.0D, 6.0D)
/*  479 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  485 */       .addFirstBehavior(
/*  486 */         CECombatBehaviors.Behavior.builder()
/*  487 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  488 */         .withinDistance(0.0D, 5.0D)
/*  489 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  490 */         .addNextBehavior(
/*  491 */           CECombatBehaviors.Behavior.builder()
/*  492 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  493 */           .withinDistance(0.0D, 6.0D)
/*  494 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  495 */           .addNextBehavior(
/*  496 */             CECombatBehaviors.Behavior.builder()
/*  497 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  498 */             .withinDistance(0.0D, 6.0D)
/*  499 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  500 */             .addNextBehavior(
/*  501 */               CECombatBehaviors.Behavior.builder()
/*  502 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  503 */               .withinDistance(0.0D, 6.0D)
/*  504 */               .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  510 */       .addFirstBehavior(
/*  511 */         CECombatBehaviors.Behavior.builder()
/*  512 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  513 */         .withinDistance(0.0D, 5.0D)
/*  514 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  515 */         .addNextBehavior(
/*  516 */           CECombatBehaviors.Behavior.builder()
/*  517 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  518 */           .withinDistance(0.0D, 6.0D)
/*  519 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*  520 */           .addNextBehavior(
/*  521 */             CECombatBehaviors.Behavior.builder()
/*  522 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  523 */             .withinDistance(0.0D, 6.0D)
/*  524 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  525 */             .addNextBehavior(
/*  526 */               CECombatBehaviors.Behavior.builder()
/*  527 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  528 */               .withinDistance(0.0D, 6.0D)
/*  529 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  535 */       .addFirstBehavior(
/*  536 */         CECombatBehaviors.Behavior.builder()
/*  537 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  538 */         .withinDistance(0.0D, 5.0D)
/*  539 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  540 */         .addNextBehavior(
/*  541 */           CECombatBehaviors.Behavior.builder()
/*  542 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  543 */           .withinDistance(0.0D, 6.0D)
/*  544 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  545 */           .addNextBehavior(
/*  546 */             CECombatBehaviors.Behavior.builder()
/*  547 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  548 */             .withinDistance(0.0D, 6.0D)
/*  549 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  554 */       .addFirstBehavior(
/*  555 */         CECombatBehaviors.Behavior.builder()
/*  556 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  557 */         .withinDistance(0.0D, 5.0D)
/*  558 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  559 */         .addNextBehavior(
/*  560 */           CECombatBehaviors.Behavior.builder()
/*  561 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  562 */           .withinDistance(0.0D, 6.0D)
/*  563 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/*  564 */           .addNextBehavior(
/*  565 */             CECombatBehaviors.Behavior.builder()
/*  566 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  567 */             .withinDistance(0.0D, 6.0D)
/*  568 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  573 */       .addFirstBehavior(
/*  574 */         CECombatBehaviors.Behavior.builder()
/*  575 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  576 */         .withinDistance(0.0D, 5.0D)
/*  577 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  578 */         .addNextBehavior(
/*  579 */           CECombatBehaviors.Behavior.builder()
/*  580 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  581 */           .withinDistance(0.0D, 6.0D)
/*  582 */           .animationBehavior(AnimsAgony.AGONY_RIPPING_FANGS, 0.0F)
/*  583 */           .addNextBehavior(
/*  584 */             CECombatBehaviors.Behavior.builder()
/*  585 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  586 */             .withinDistance(0.0D, 6.0D)
/*  587 */             .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/*  588 */             .addNextBehavior(
/*  589 */               CECombatBehaviors.Behavior.builder()
/*  590 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  591 */               .withinDistance(0.0D, 6.0D)
/*  592 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  598 */       .addFirstBehavior(
/*  599 */         CECombatBehaviors.Behavior.builder()
/*  600 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  601 */         .withinDistance(0.0D, 5.0D)
/*  602 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  603 */         .addNextBehavior(
/*  604 */           CECombatBehaviors.Behavior.builder()
/*  605 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  606 */           .withinDistance(0.0D, 6.0D)
/*  607 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  608 */           .addNextBehavior(
/*  609 */             CECombatBehaviors.Behavior.builder()
/*  610 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  611 */             .withinDistance(0.0D, 6.0D)
/*  612 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  613 */             .addNextBehavior(
/*  614 */               CECombatBehaviors.Behavior.builder()
/*  615 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  616 */               .withinDistance(0.0D, 7.0D)
/*  617 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  618 */               .addNextBehavior(
/*  619 */                 CECombatBehaviors.Behavior.builder()
/*  620 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  621 */                 .withinDistance(0.0D, 8.0D)
/*  622 */                 .animationBehavior(AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  628 */       .addFirstBehavior(
/*  629 */         CECombatBehaviors.Behavior.builder()
/*  630 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  631 */         .withinDistance(0.0D, 5.0D)
/*  632 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  633 */         .addNextBehavior(
/*  634 */           CECombatBehaviors.Behavior.builder()
/*  635 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  636 */           .withinDistance(0.0D, 6.0D)
/*  637 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  638 */           .addNextBehavior(
/*  639 */             CECombatBehaviors.Behavior.builder()
/*  640 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  641 */             .withinDistance(0.0D, 6.0D)
/*  642 */             .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  643 */             .addNextBehavior(
/*  644 */               CECombatBehaviors.Behavior.builder()
/*  645 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  646 */               .withinDistance(0.0D, 8.0D)
/*  647 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/*  648 */               .addNextBehavior(
/*  649 */                 CECombatBehaviors.Behavior.builder()
/*  650 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  651 */                 .withinDistance(0.0D, 8.0D)
/*  652 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  658 */       .addFirstBehavior(
/*  659 */         CECombatBehaviors.Behavior.builder()
/*  660 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  661 */         .withinDistance(0.0D, 5.0D)
/*  662 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  663 */         .addNextBehavior(
/*  664 */           CECombatBehaviors.Behavior.builder()
/*  665 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  666 */           .withinDistance(0.0D, 6.0D)
/*  667 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  668 */           .addNextBehavior(
/*  669 */             CECombatBehaviors.Behavior.builder()
/*  670 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  671 */             .withinDistance(0.0D, 8.0D)
/*  672 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  673 */             .addNextBehavior(
/*  674 */               CECombatBehaviors.Behavior.builder()
/*  675 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  676 */               .withinDistance(0.0D, 6.0D)
/*  677 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  678 */               .addNextBehavior(
/*  679 */                 CECombatBehaviors.Behavior.builder()
/*  680 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  681 */                 .withinDistance(0.0D, 8.0D)
/*  682 */                 .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  688 */       .addFirstBehavior(
/*  689 */         CECombatBehaviors.Behavior.builder()
/*  690 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  691 */         .withinDistance(0.0D, 7.0D)
/*  692 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  693 */         .addNextBehavior(
/*  694 */           CECombatBehaviors.Behavior.builder()
/*  695 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  696 */           .withinDistance(0.0D, 8.0D)
/*  697 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/*  698 */           .addNextBehavior(
/*  699 */             CECombatBehaviors.Behavior.builder()
/*  700 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  701 */             .withinDistance(0.0D, 10.0D)
/*  702 */             .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/*  703 */             .addNextBehavior(
/*  704 */               CECombatBehaviors.Behavior.builder()
/*  705 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  706 */               .withinDistance(0.0D, 8.0D)
/*  707 */               .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  708 */               .addNextBehavior(
/*  709 */                 CECombatBehaviors.Behavior.builder()
/*  710 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  711 */                 .withinDistance(0.0D, 15.0D)
/*  712 */                 .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  718 */       .addFirstBehavior(
/*  719 */         CECombatBehaviors.Behavior.builder()
/*  720 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  721 */         .withinDistance(0.0D, 6.0D)
/*  722 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/*  723 */         .addNextBehavior(
/*  724 */           CECombatBehaviors.Behavior.builder()
/*  725 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  726 */           .withinDistance(0.0D, 6.0D)
/*  727 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/*  728 */           .addNextBehavior(
/*  729 */             CECombatBehaviors.Behavior.builder()
/*  730 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  731 */             .withinDistance(0.0D, 6.0D)
/*  732 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  733 */             .addNextBehavior(
/*  734 */               CECombatBehaviors.Behavior.builder()
/*  735 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  736 */               .withinDistance(0.0D, 6.0D)
/*  737 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  738 */               .addNextBehavior(
/*  739 */                 CECombatBehaviors.Behavior.builder()
/*  740 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  741 */                 .withinDistance(0.0D, 8.0D)
/*  742 */                 .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  748 */       .addFirstBehavior(
/*  749 */         CECombatBehaviors.Behavior.builder()
/*  750 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  751 */         .withinDistance(0.0D, 5.0D)
/*  752 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  753 */         .addNextBehavior(
/*  754 */           CECombatBehaviors.Behavior.builder()
/*  755 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  756 */           .withinDistance(0.0D, 6.0D)
/*  757 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  758 */           .addNextBehavior(
/*  759 */             CECombatBehaviors.Behavior.builder()
/*  760 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  761 */             .withinDistance(0.0D, 6.0D)
/*  762 */             .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/*  763 */             .addNextBehavior(
/*  764 */               CECombatBehaviors.Behavior.builder()
/*  765 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  766 */               .withinDistance(0.0D, 8.0D)
/*  767 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  768 */               .addNextBehavior(
/*  769 */                 CECombatBehaviors.Behavior.builder()
/*  770 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  771 */                 .withinDistance(0.0D, 7.0D)
/*  772 */                 .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  778 */       .addFirstBehavior(
/*  779 */         CECombatBehaviors.Behavior.builder()
/*  780 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  781 */         .withinDistance(0.0D, 5.0D)
/*  782 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  783 */         .addNextBehavior(
/*  784 */           CECombatBehaviors.Behavior.builder()
/*  785 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  786 */           .withinDistance(0.0D, 8.0D)
/*  787 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/*  788 */           .addNextBehavior(
/*  789 */             CECombatBehaviors.Behavior.builder()
/*  790 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  791 */             .withinDistance(0.0D, 6.0D)
/*  792 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  793 */             .addNextBehavior(
/*  794 */               CECombatBehaviors.Behavior.builder()
/*  795 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  796 */               .withinDistance(0.0D, 8.0D)
/*  797 */               .animationBehavior(AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F)
/*  798 */               .addNextBehavior(
/*  799 */                 CECombatBehaviors.Behavior.builder()
/*  800 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  801 */                 .withinDistance(0.0D, 15.0D)
/*  802 */                 .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  808 */       .addFirstBehavior(
/*  809 */         CECombatBehaviors.Behavior.builder()
/*  810 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  811 */         .withinDistance(0.0D, 5.0D)
/*  812 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  813 */         .addNextBehavior(
/*  814 */           CECombatBehaviors.Behavior.builder()
/*  815 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  816 */           .withinDistance(0.0D, 7.0D)
/*  817 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  818 */           .addNextBehavior(
/*  819 */             CECombatBehaviors.Behavior.builder()
/*  820 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  821 */             .withinDistance(0.0D, 6.0D)
/*  822 */             .animationBehavior(AnimsAgony.AGONY_RIPPING_FANGS, 0.0F)
/*  823 */             .addNextBehavior(
/*  824 */               CECombatBehaviors.Behavior.builder()
/*  825 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  826 */               .withinDistance(0.0D, 6.0D)
/*  827 */               .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/*  828 */               .addNextBehavior(
/*  829 */                 CECombatBehaviors.Behavior.builder()
/*  830 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  831 */                 .withinDistance(0.0D, 8.0D)
/*  832 */                 .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  838 */       .addFirstBehavior(
/*  839 */         CECombatBehaviors.Behavior.builder()
/*  840 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  841 */         .withinDistance(0.0D, 6.0D)
/*  842 */         .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  843 */         .addNextBehavior(
/*  844 */           CECombatBehaviors.Behavior.builder()
/*  845 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  846 */           .withinDistance(0.0D, 6.0D)
/*  847 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  848 */           .addNextBehavior(
/*  849 */             CECombatBehaviors.Behavior.builder()
/*  850 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  851 */             .withinDistance(0.0D, 7.0D)
/*  852 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  853 */             .addNextBehavior(
/*  854 */               CECombatBehaviors.Behavior.builder()
/*  855 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  856 */               .withinDistance(0.0D, 7.0D)
/*  857 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/*  858 */               .addNextBehavior(
/*  859 */                 CECombatBehaviors.Behavior.builder()
/*  860 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  861 */                 .withinDistance(0.0D, 8.0D)
/*  862 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  868 */       .addFirstBehavior(
/*  869 */         CECombatBehaviors.Behavior.builder()
/*  870 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  871 */         .withinDistance(0.0D, 6.0D)
/*  872 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  873 */         .addNextBehavior(
/*  874 */           CECombatBehaviors.Behavior.builder()
/*  875 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  876 */           .withinDistance(0.0D, 6.0D)
/*  877 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*  878 */           .addNextBehavior(
/*  879 */             CECombatBehaviors.Behavior.builder()
/*  880 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  881 */             .withinDistance(0.0D, 6.0D)
/*  882 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  883 */             .addNextBehavior(
/*  884 */               CECombatBehaviors.Behavior.builder()
/*  885 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  886 */               .withinDistance(0.0D, 8.0D)
/*  887 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/*  888 */               .addNextBehavior(
/*  889 */                 CECombatBehaviors.Behavior.builder()
/*  890 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  891 */                 .withinDistance(0.0D, 6.0D)
/*  892 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  898 */       .addFirstBehavior(
/*  899 */         CECombatBehaviors.Behavior.builder()
/*  900 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  901 */         .withinDistance(0.0D, 5.0D)
/*  902 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  903 */         .addNextBehavior(
/*  904 */           CECombatBehaviors.Behavior.builder()
/*  905 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  906 */           .withinDistance(0.0D, 6.0D)
/*  907 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  908 */           .addNextBehavior(
/*  909 */             CECombatBehaviors.Behavior.builder()
/*  910 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  911 */             .withinDistance(0.0D, 6.0D)
/*  912 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  913 */             .addNextBehavior(
/*  914 */               CECombatBehaviors.Behavior.builder()
/*  915 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  916 */               .withinDistance(0.0D, 6.0D)
/*  917 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*  918 */               .addNextBehavior(
/*  919 */                 CECombatBehaviors.Behavior.builder()
/*  920 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  921 */                 .withinDistance(0.0D, 8.0D)
/*  922 */                 .animationBehavior(AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  928 */       .addFirstBehavior(
/*  929 */         CECombatBehaviors.Behavior.builder()
/*  930 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  931 */         .withinDistance(0.0D, 6.0D)
/*  932 */         .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  933 */         .addNextBehavior(
/*  934 */           CECombatBehaviors.Behavior.builder()
/*  935 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  936 */           .withinDistance(0.0D, 8.0D)
/*  937 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F)
/*  938 */           .addNextBehavior(
/*  939 */             CECombatBehaviors.Behavior.builder()
/*  940 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  941 */             .withinDistance(0.0D, 6.0D)
/*  942 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  943 */             .addNextBehavior(
/*  944 */               CECombatBehaviors.Behavior.builder()
/*  945 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  946 */               .withinDistance(0.0D, 8.0D)
/*  947 */               .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)
/*  948 */               .addNextBehavior(
/*  949 */                 CECombatBehaviors.Behavior.builder()
/*  950 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  951 */                 .withinDistance(0.0D, 10.0D)
/*  952 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  958 */       .addFirstBehavior(
/*  959 */         CECombatBehaviors.Behavior.builder()
/*  960 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  961 */         .withinDistance(0.0D, 6.0D)
/*  962 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  963 */         .addNextBehavior(
/*  964 */           CECombatBehaviors.Behavior.builder()
/*  965 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  966 */           .withinDistance(0.0D, 7.0D)
/*  967 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  968 */           .addNextBehavior(
/*  969 */             CECombatBehaviors.Behavior.builder()
/*  970 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  971 */             .withinDistance(0.0D, 7.0D)
/*  972 */             .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  973 */             .addNextBehavior(
/*  974 */               CECombatBehaviors.Behavior.builder()
/*  975 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  976 */               .withinDistance(0.0D, 6.0D)
/*  977 */               .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/*  978 */               .addNextBehavior(
/*  979 */                 CECombatBehaviors.Behavior.builder()
/*  980 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  981 */                 .withinDistance(0.0D, 15.0D)
/*  982 */                 .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  988 */       .addFirstBehavior(
/*  989 */         CECombatBehaviors.Behavior.builder()
/*  990 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  991 */         .withinDistance(0.0D, 6.0D)
/*  992 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  993 */         .addNextBehavior(
/*  994 */           CECombatBehaviors.Behavior.builder()
/*  995 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  996 */           .withinDistance(0.0D, 6.0D)
/*  997 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  998 */           .addNextBehavior(
/*  999 */             CECombatBehaviors.Behavior.builder()
/* 1000 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1001 */             .withinDistance(0.0D, 8.0D)
/* 1002 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1003 */             .addNextBehavior(
/* 1004 */               CECombatBehaviors.Behavior.builder()
/* 1005 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1006 */               .withinDistance(0.0D, 8.0D)
/* 1007 */               .animationBehavior(AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F)
/* 1008 */               .addNextBehavior(
/* 1009 */                 CECombatBehaviors.Behavior.builder()
/* 1010 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1011 */                 .withinDistance(0.0D, 8.0D)
/* 1012 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1018 */       .addFirstBehavior(
/* 1019 */         CECombatBehaviors.Behavior.builder()
/* 1020 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1021 */         .withinDistance(0.0D, 6.0D)
/* 1022 */         .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/* 1023 */         .addNextBehavior(
/* 1024 */           CECombatBehaviors.Behavior.builder()
/* 1025 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1026 */           .withinDistance(0.0D, 6.0D)
/* 1027 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 1028 */           .addNextBehavior(
/* 1029 */             CECombatBehaviors.Behavior.builder()
/* 1030 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1031 */             .withinDistance(0.0D, 8.0D)
/* 1032 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1033 */             .addNextBehavior(
/* 1034 */               CECombatBehaviors.Behavior.builder()
/* 1035 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1036 */               .withinDistance(0.0D, 8.0D)
/* 1037 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)
/* 1038 */               .addNextBehavior(
/* 1039 */                 CECombatBehaviors.Behavior.builder()
/* 1040 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1041 */                 .withinDistance(0.0D, 15.0D)
/* 1042 */                 .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1048 */       .addFirstBehavior(
/* 1049 */         CECombatBehaviors.Behavior.builder()
/* 1050 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1051 */         .withinDistance(0.0D, 5.0D)
/* 1052 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 1053 */         .addNextBehavior(
/* 1054 */           CECombatBehaviors.Behavior.builder()
/* 1055 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1056 */           .withinDistance(0.0D, 6.0D)
/* 1057 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 1058 */           .addNextBehavior(
/* 1059 */             CECombatBehaviors.Behavior.builder()
/* 1060 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1061 */             .withinDistance(0.0D, 6.0D)
/* 1062 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1063 */             .addNextBehavior(
/* 1064 */               CECombatBehaviors.Behavior.builder()
/* 1065 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1066 */               .withinDistance(0.0D, 6.0D)
/* 1067 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 1068 */               .addNextBehavior(
/* 1069 */                 CECombatBehaviors.Behavior.builder()
/* 1070 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1071 */                 .withinDistance(0.0D, 8.0D)
/* 1072 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1078 */       .addFirstBehavior(
/* 1079 */         CECombatBehaviors.Behavior.builder()
/* 1080 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1081 */         .withinDistance(0.0D, 7.0D)
/* 1082 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/* 1083 */         .addNextBehavior(
/* 1084 */           CECombatBehaviors.Behavior.builder()
/* 1085 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1086 */           .withinDistance(0.0D, 7.0D)
/* 1087 */           .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/* 1088 */           .addNextBehavior(
/* 1089 */             CECombatBehaviors.Behavior.builder()
/* 1090 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1091 */             .withinDistance(0.0D, 15.0D)
/* 1092 */             .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/* 1093 */             .addNextBehavior(
/* 1094 */               CECombatBehaviors.Behavior.builder()
/* 1095 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1096 */               .withinDistance(0.0D, 8.0D)
/* 1097 */               .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1098 */               .addNextBehavior(
/* 1099 */                 CECombatBehaviors.Behavior.builder()
/* 1100 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1101 */                 .withinDistance(0.0D, 6.0D)
/* 1102 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1108 */       .addFirstBehavior(
/* 1109 */         CECombatBehaviors.Behavior.builder()
/* 1110 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1111 */         .withinDistance(0.0D, 5.0D)
/* 1112 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 1113 */         .addNextBehavior(
/* 1114 */           CECombatBehaviors.Behavior.builder()
/* 1115 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1116 */           .withinDistance(0.0D, 6.0D)
/* 1117 */           .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1118 */           .addNextBehavior(
/* 1119 */             CECombatBehaviors.Behavior.builder()
/* 1120 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1121 */             .withinDistance(0.0D, 6.0D)
/* 1122 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/* 1123 */             .addNextBehavior(
/* 1124 */               CECombatBehaviors.Behavior.builder()
/* 1125 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1126 */               .withinDistance(0.0D, 6.0D)
/* 1127 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 1128 */               .addNextBehavior(
/* 1129 */                 CECombatBehaviors.Behavior.builder()
/* 1130 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1131 */                 .withinDistance(0.0D, 6.0D)
/* 1132 */                 .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1138 */       .addFirstBehavior(
/* 1139 */         CECombatBehaviors.Behavior.builder()
/* 1140 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1141 */         .withinDistance(0.0D, 5.0D)
/* 1142 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 1143 */         .addNextBehavior(
/* 1144 */           CECombatBehaviors.Behavior.builder()
/* 1145 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1146 */           .withinDistance(0.0D, 6.0D)
/* 1147 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/* 1148 */           .addNextBehavior(
/* 1149 */             CECombatBehaviors.Behavior.builder()
/* 1150 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1151 */             .withinDistance(0.0D, 6.0D)
/* 1152 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/* 1153 */             .addNextBehavior(
/* 1154 */               CECombatBehaviors.Behavior.builder()
/* 1155 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1156 */               .withinDistance(0.0D, 7.0D)
/* 1157 */               .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/* 1158 */               .addNextBehavior(
/* 1159 */                 CECombatBehaviors.Behavior.builder()
/* 1160 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1161 */                 .withinDistance(0.0D, 8.0D)
/* 1162 */                 .animationBehavior(AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1168 */       .addFirstBehavior(
/* 1169 */         CECombatBehaviors.Behavior.builder()
/* 1170 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1171 */         .withinDistance(0.0D, 10.0D)
/* 1172 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/* 1173 */         .addNextBehavior(
/* 1174 */           CECombatBehaviors.Behavior.builder()
/* 1175 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1176 */           .withinDistance(0.0D, 8.0D)
/* 1177 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1178 */           .addNextBehavior(
/* 1179 */             CECombatBehaviors.Behavior.builder()
/* 1180 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1181 */             .withinDistance(0.0D, 8.0D)
/* 1182 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1183 */             .addNextBehavior(
/* 1184 */               CECombatBehaviors.Behavior.builder()
/* 1185 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1186 */               .withinDistance(0.0D, 6.0D)
/* 1187 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/* 1188 */               .addNextBehavior(
/* 1189 */                 CECombatBehaviors.Behavior.builder()
/* 1190 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1191 */                 .withinDistance(0.0D, 8.0D)
/* 1192 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1198 */       .addFirstBehavior(
/* 1199 */         CECombatBehaviors.Behavior.builder()
/* 1200 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1201 */         .withinDistance(0.0D, 6.0D)
/* 1202 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/* 1203 */         .addNextBehavior(
/* 1204 */           CECombatBehaviors.Behavior.builder()
/* 1205 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1206 */           .withinDistance(0.0D, 7.0D)
/* 1207 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/* 1208 */           .addNextBehavior(
/* 1209 */             CECombatBehaviors.Behavior.builder()
/* 1210 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1211 */             .withinDistance(0.0D, 8.0D)
/* 1212 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1213 */             .addNextBehavior(
/* 1214 */               CECombatBehaviors.Behavior.builder()
/* 1215 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1216 */               .withinDistance(0.0D, 8.0D)
/* 1217 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 1218 */               .addNextBehavior(
/* 1219 */                 CECombatBehaviors.Behavior.builder()
/* 1220 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1221 */                 .withinDistance(0.0D, 8.0D)
/* 1222 */                 .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1228 */       .addFirstBehavior(
/* 1229 */         CECombatBehaviors.Behavior.builder()
/* 1230 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1231 */         .withinDistance(0.0D, 6.0D)
/* 1232 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/* 1233 */         .addNextBehavior(
/* 1234 */           CECombatBehaviors.Behavior.builder()
/* 1235 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1236 */           .withinDistance(0.0D, 6.0D)
/* 1237 */           .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/* 1238 */           .addNextBehavior(
/* 1239 */             CECombatBehaviors.Behavior.builder()
/* 1240 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1241 */             .withinDistance(0.0D, 8.0D)
/* 1242 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1243 */             .addNextBehavior(
/* 1244 */               CECombatBehaviors.Behavior.builder()
/* 1245 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1246 */               .withinDistance(0.0D, 7.0D)
/* 1247 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/* 1248 */               .addNextBehavior(
/* 1249 */                 CECombatBehaviors.Behavior.builder()
/* 1250 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1251 */                 .withinDistance(0.0D, 15.0D)
/* 1252 */                 .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1258 */       .addFirstBehavior(
/* 1259 */         CECombatBehaviors.Behavior.builder()
/* 1260 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1261 */         .withinDistance(0.0D, 5.0D)
/* 1262 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 1263 */         .addNextBehavior(
/* 1264 */           CECombatBehaviors.Behavior.builder()
/* 1265 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1266 */           .withinDistance(0.0D, 6.0D)
/* 1267 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 1268 */           .addNextBehavior(
/* 1269 */             CECombatBehaviors.Behavior.builder()
/* 1270 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1271 */             .withinDistance(0.0D, 8.0D)
/* 1272 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1273 */             .addNextBehavior(
/* 1274 */               CECombatBehaviors.Behavior.builder()
/* 1275 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1276 */               .withinDistance(0.0D, 8.0D)
/* 1277 */               .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/* 1278 */               .addNextBehavior(
/* 1279 */                 CECombatBehaviors.Behavior.builder()
/* 1280 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1281 */                 .withinDistance(0.0D, 8.0D)
/* 1282 */                 .animationBehavior(AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1288 */       .addFirstBehavior(
/* 1289 */         CECombatBehaviors.Behavior.builder()
/* 1290 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1291 */         .withinDistance(0.0D, 6.0D)
/* 1292 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/* 1293 */         .addNextBehavior(
/* 1294 */           CECombatBehaviors.Behavior.builder()
/* 1295 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1296 */           .withinDistance(0.0D, 6.0D)
/* 1297 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 1298 */           .addNextBehavior(
/* 1299 */             CECombatBehaviors.Behavior.builder()
/* 1300 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1301 */             .withinDistance(0.0D, 7.0D)
/* 1302 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/* 1303 */             .addNextBehavior(
/* 1304 */               CECombatBehaviors.Behavior.builder()
/* 1305 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1306 */               .withinDistance(0.0D, 7.0D)
/* 1307 */               .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/* 1308 */               .addNextBehavior(
/* 1309 */                 CECombatBehaviors.Behavior.builder()
/* 1310 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1311 */                 .withinDistance(0.0D, 6.0D)
/* 1312 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1318 */       .addFirstBehavior(
/* 1319 */         CECombatBehaviors.Behavior.builder()
/* 1320 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1321 */         .withinDistance(0.0D, 6.0D)
/* 1322 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/* 1323 */         .addNextBehavior(
/* 1324 */           CECombatBehaviors.Behavior.builder()
/* 1325 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1326 */           .withinDistance(0.0D, 8.0D)
/* 1327 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1328 */           .addNextBehavior(
/* 1329 */             CECombatBehaviors.Behavior.builder()
/* 1330 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1331 */             .withinDistance(0.0D, 6.0D)
/* 1332 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/* 1333 */             .addNextBehavior(
/* 1334 */               CECombatBehaviors.Behavior.builder()
/* 1335 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1336 */               .withinDistance(0.0D, 8.0D)
/* 1337 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F)
/* 1338 */               .addNextBehavior(
/* 1339 */                 CECombatBehaviors.Behavior.builder()
/* 1340 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1341 */                 .withinDistance(0.0D, 15.0D)
/* 1342 */                 .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1350 */     .newBehaviorRoot(
/* 1351 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1352 */       .priority(1.0D)
/* 1353 */       .weight(30.0D)
/* 1354 */       .maxCooldown(40)
/* 1355 */       .addFirstBehavior(
/* 1356 */         CECombatBehaviors.Behavior.builder()
/* 1357 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1358 */         .withinDistance(0.0D, 5.0D)
/* 1359 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1360 */         .addNextBehavior(
/* 1361 */           CECombatBehaviors.Behavior.builder()
/* 1362 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1363 */           .withinDistance(0.0D, 5.0D)
/* 1364 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1365 */           .addNextBehavior(
/* 1366 */             CECombatBehaviors.Behavior.builder()
/* 1367 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1368 */             .withinDistance(0.0D, 5.0D)
/* 1369 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1370 */             .addNextBehavior(
/* 1371 */               CECombatBehaviors.Behavior.builder()
/* 1372 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1373 */               .withinDistance(0.0D, 5.0D)
/* 1374 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1380 */     .newBehaviorRoot(
/* 1381 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1382 */       .priority(1.0D)
/* 1383 */       .weight(30.0D)
/* 1384 */       .maxCooldown(40)
/* 1385 */       .addFirstBehavior(
/* 1386 */         CECombatBehaviors.Behavior.builder()
/* 1387 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1388 */         .withinDistance(0.0D, 5.0D)
/* 1389 */         .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1390 */         .addNextBehavior(
/* 1391 */           CECombatBehaviors.Behavior.builder()
/* 1392 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1393 */           .withinDistance(0.0D, 5.0D)
/* 1394 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/* 1398 */     .newBehaviorRoot(
/* 1399 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1400 */       .priority(1.0D)
/* 1401 */       .weight(30.0D)
/* 1402 */       .maxCooldown(40)
/* 1403 */       .addFirstBehavior(
/* 1404 */         CECombatBehaviors.Behavior.builder()
/* 1405 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1406 */         .withinDistance(0.0D, 5.0D)
/* 1407 */         .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/* 1408 */         .addNextBehavior(
/* 1409 */           CECombatBehaviors.Behavior.builder()
/* 1410 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1411 */           .withinDistance(0.0D, 5.0D)
/* 1412 */           .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/* 1416 */     .newBehaviorRoot(
/* 1417 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1418 */       .priority(1.0D)
/* 1419 */       .weight(30.0D)
/* 1420 */       .maxCooldown(100)
/* 1421 */       .addFirstBehavior(
/* 1422 */         CECombatBehaviors.Behavior.builder()
/* 1423 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1424 */         .withinDistance(0.0D, 5.0D)
/* 1425 */         .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/* 1426 */         .addExBehavior(AngrySteveLegendarySword::legendarySwordSpecialAttack)))
/*      */ 
/*      */     
/* 1429 */     .newBehaviorRoot(
/* 1430 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1431 */       .priority(1.0D)
/* 1432 */       .weight(20.0D)
/* 1433 */       .maxCooldown(200)
/* 1434 */       .addFirstBehavior(
/* 1435 */         CECombatBehaviors.Behavior.builder()
/* 1436 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1437 */         .withinDistance(0.0D, 5.0D)
/* 1438 */         .animationBehavior(AnimsAgony.AGONY_RISING_EAGLE, 0.0F)
/* 1439 */         .addExBehavior(AngrySteveLegendarySword::legendarySwordHeavyAttack)))
/*      */ 
/*      */     
/* 1442 */     .newBehaviorRoot(
/* 1443 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1444 */       .priority(1.0D)
/* 1445 */       .weight(10.0D)
/* 1446 */       .maxCooldown(400)
/* 1447 */       .addFirstBehavior(
/* 1448 */         CECombatBehaviors.Behavior.builder()
/* 1449 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1450 */         .withinDistance(5.0D, 10.0D)
/* 1451 */         .animationBehavior(AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F)))
/*      */ 
/*      */     
/* 1454 */     .newBehaviorRoot(
/* 1455 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1456 */       .priority(1.0D)
/* 1457 */       .weight(10.0D)
/* 1458 */       .maxCooldown(40)
/* 1459 */       .addFirstBehavior(
/* 1460 */         CECombatBehaviors.Behavior.builder()
/* 1461 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1462 */         .withinDistance(0.0D, 3.0D)
/* 1463 */         .custom(CombatCommon::canThrowEnderPearl)
/* 1464 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 1465 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 1466 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/* 1469 */     .newBehaviorRoot(
/* 1470 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1471 */       .priority(1.0D)
/* 1472 */       .weight(2.0D)
/* 1473 */       .maxCooldown(100)
/* 1474 */       .addFirstBehavior(
/* 1475 */         CECombatBehaviors.Behavior.builder()
/* 1476 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1477 */         .withinDistance(0.0D, 3.0D)
/* 1478 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/* 1480 */       .addFirstBehavior(
/* 1481 */         CECombatBehaviors.Behavior.builder()
/* 1482 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1483 */         .withinDistance(0.0D, 3.0D)
/* 1484 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/* 1486 */       .addFirstBehavior(
/* 1487 */         CECombatBehaviors.Behavior.builder()
/* 1488 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1489 */         .withinDistance(0.0D, 3.0D)
/* 1490 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/* 1492 */       .addFirstBehavior(
/* 1493 */         CECombatBehaviors.Behavior.builder()
/* 1494 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1495 */         .withinDistance(0.0D, 3.0D)
/* 1496 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/* 1498 */       .addFirstBehavior(
/* 1499 */         CECombatBehaviors.Behavior.builder()
/* 1500 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1501 */         .withinDistance(0.0D, 3.0D)
/* 1502 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/* 1504 */       .addFirstBehavior(
/* 1505 */         CECombatBehaviors.Behavior.builder()
/* 1506 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1507 */         .withinDistance(0.0D, 3.0D)
/* 1508 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/* 1510 */       .addFirstBehavior(
/* 1511 */         CECombatBehaviors.Behavior.builder()
/* 1512 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1513 */         .withinDistance(0.0D, 3.0D)
/* 1514 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/* 1517 */     .newBehaviorRoot(
/* 1518 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1519 */       .priority(1.0D)
/* 1520 */       .weight(15.0D)
/* 1521 */       .addFirstBehavior(
/* 1522 */         CECombatBehaviors.Behavior.builder()
/* 1523 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1524 */         .withinDistance(0.0D, 3.0D)
/* 1525 */         .custom(CombatCommon::canPerformGuarding)
/* 1526 */         .guard(40)))
/*      */ 
/*      */     
/* 1529 */     .newBehaviorRoot(
/* 1530 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1531 */       .priority(1.0D)
/* 1532 */       .weight(10.0D)
/* 1533 */       .addFirstBehavior(
/* 1534 */         CECombatBehaviors.Behavior.builder()
/* 1535 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1536 */         .withinDistance(0.0D, 3.0D)
/* 1537 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1539 */       .addFirstBehavior(
/* 1540 */         CECombatBehaviors.Behavior.builder()
/* 1541 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1542 */         .withinDistance(0.0D, 3.0D)
/* 1543 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1545 */       .addFirstBehavior(
/* 1546 */         CECombatBehaviors.Behavior.builder()
/* 1547 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1548 */         .withinDistance(0.0D, 3.0D)
/* 1549 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1551 */       .addFirstBehavior(
/* 1552 */         CECombatBehaviors.Behavior.builder()
/* 1553 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1554 */         .withinDistance(0.0D, 3.0D)
/* 1555 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1558 */     .newBehaviorRoot(
/* 1559 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1560 */       .priority(1.0D)
/* 1561 */       .weight(40.0D)
/* 1562 */       .maxCooldown(160)
/* 1563 */       .addFirstBehavior(
/* 1564 */         CECombatBehaviors.Behavior.builder()
/* 1565 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1566 */         .custom(CombatCommon::canJump)
/* 1567 */         .withinDistance(5.0D, 14.0D)
/* 1568 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1569 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\AngrySteveLegendarySword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */