/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.entity.SteveEntity;
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
/*      */ import net.minecraft.world.effect.MobEffectInstance;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*      */ import yesman.epicfight.api.asset.AssetAccessor;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*      */ 
/*      */ public class SteveLegendarySword {
/*      */   static void legendarySwordHeavyAttack(final MobPatch<?> mobpatch) {
/*   29 */     final SteveEntity steveEntity = (SteveEntity)mobpatch.getOriginal();
/*   30 */     ItemStack itemStack = steveEntity.m_21205_();
/*   31 */     if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.LegendarySwordItem) { Level level = steveEntity.m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/*   32 */         steveEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/*   33 */         new DelayedTask(10)
/*      */           {
/*      */             public void run() {
/*   36 */               serverLevel.m_6263_(null, steveEntity
/*      */                   
/*   38 */                   .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_START
/*   39 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   44 */               serverLevel.m_6263_(null, steveEntity
/*      */                   
/*   46 */                   .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD
/*   47 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   52 */               serverLevel.m_6263_(null, steveEntity
/*      */                   
/*   54 */                   .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD_2
/*   55 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   60 */               serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, steveEntity
/*      */                   
/*   62 */                   .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), 15, 0.0D, 0.0D, 0.0D, 0.2D);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   67 */               serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, steveEntity
/*      */                   
/*   69 */                   .m_20185_(), steveEntity.m_20188_(), steveEntity.m_20189_(), 100, 0.0D, 0.0D, 0.0D, 0.5D);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   74 */               mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_HEAVY_ATTACK, 0.0F);
/*      */             }
/*      */           }; }
/*      */        }
/*      */   
/*      */   }
/*      */   static void legendarySwordSpecialAttack(final MobPatch<?> mobpatch) {
/*   81 */     SteveEntity steveEntity = (SteveEntity)mobpatch.getOriginal();
/*   82 */     ItemStack itemStack = steveEntity.m_21205_();
/*   83 */     if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.LegendarySwordItem && steveEntity.m_9236_() instanceof ServerLevel) {
/*   84 */       steveEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/*   85 */       new DelayedTask(20)
/*      */         {
/*      */           public void run() {
/*   88 */             mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F);
/*      */           }
/*      */         };
/*      */     } 
/*      */   }
/*      */   
/*   94 */   public static final CECombatBehaviors.Builder<MobPatch<?>> LEGENDARY_SWORD = CECombatBehaviors.builder()
/*   95 */     .newBehaviorRoot(
/*   96 */       CECombatBehaviors.BehaviorRoot.builder()
/*   97 */       .priority(5.0D)
/*   98 */       .weight(1000.0D)
/*   99 */       .maxCooldown(0)
/*  100 */       .addFirstBehavior(
/*  101 */         CECombatBehaviors.Behavior.builder()
/*  102 */         .custom(CombatCommon::canExecute)
/*  103 */         .withinDistance(0.0D, 5.0D)
/*  104 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  105 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  108 */     .newBehaviorRoot(
/*  109 */       CECombatBehaviors.BehaviorRoot.builder()
/*  110 */       .priority(4.0D)
/*  111 */       .weight(1000.0D)
/*  112 */       .maxCooldown(0)
/*  113 */       .addFirstBehavior(
/*  114 */         CECombatBehaviors.Behavior.builder()
/*  115 */         .custom(CombatCommon::canEscape)
/*  116 */         .withinDistance(0.0D, 8.0D)
/*  117 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  118 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*  120 */       .addFirstBehavior(
/*  121 */         CECombatBehaviors.Behavior.builder()
/*  122 */         .custom(CombatCommon::canEscape)
/*  123 */         .withinDistance(0.0D, 48.0D)
/*  124 */         .guard(40)))
/*      */ 
/*      */     
/*  127 */     .newBehaviorRoot(
/*  128 */       CECombatBehaviors.BehaviorRoot.builder()
/*  129 */       .priority(3.0D)
/*  130 */       .weight(100.0D)
/*  131 */       .maxCooldown(120)
/*  132 */       .addFirstBehavior(
/*  133 */         CECombatBehaviors.Behavior.builder()
/*  134 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  135 */         .custom(CombatCommon::canSwitchWeapon)
/*  136 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  137 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  139 */       .addFirstBehavior(
/*  140 */         CECombatBehaviors.Behavior.builder()
/*  141 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  142 */         .custom(CombatCommon::canSwitchWeapon)
/*  143 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  144 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  146 */       .addFirstBehavior(
/*  147 */         CECombatBehaviors.Behavior.builder()
/*  148 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  149 */         .custom(CombatCommon::canSwitchWeapon)
/*  150 */         .withinDistance(1.0D, 14.0D)
/*  151 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  152 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  154 */       .addFirstBehavior(
/*  155 */         CECombatBehaviors.Behavior.builder()
/*  156 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  157 */         .custom(CombatCommon::canSwitchWeapon)
/*  158 */         .withinDistance(1.0D, 14.0D)
/*  159 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  160 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*  163 */     .newBehaviorRoot(
/*  164 */       CECombatBehaviors.BehaviorRoot.builder()
/*  165 */       .priority(2.0D)
/*  166 */       .weight(70.0D)
/*  167 */       .maxCooldown(0)
/*  168 */       .addFirstBehavior(
/*  169 */         CECombatBehaviors.Behavior.builder()
/*  170 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  171 */         .custom(CombatCommon::canPerformEating)
/*  172 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  173 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  176 */     .newBehaviorRoot(
/*  177 */       CECombatBehaviors.BehaviorRoot.builder()
/*  178 */       .priority(2.0D)
/*  179 */       .weight(100.0D)
/*  180 */       .maxCooldown(120)
/*  181 */       .addFirstBehavior(
/*  182 */         CECombatBehaviors.Behavior.builder()
/*  183 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  184 */         .custom(CombatCommon::canSwapToBow)
/*  185 */         .withinDistance(7.0D, 14.0D)
/*  186 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  187 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  189 */       .addFirstBehavior(
/*  190 */         CECombatBehaviors.Behavior.builder()
/*  191 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  192 */         .custom(CombatCommon::canSwapToBow)
/*  193 */         .withinDistance(7.0D, 14.0D)
/*  194 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  195 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  197 */       .addFirstBehavior(
/*  198 */         CECombatBehaviors.Behavior.builder()
/*  199 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  200 */         .custom(CombatCommon::canSwapToBow)
/*  201 */         .withinDistance(7.0D, 14.0D)
/*  202 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  203 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  205 */       .addFirstBehavior(
/*  206 */         CECombatBehaviors.Behavior.builder()
/*  207 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  208 */         .custom(CombatCommon::canSwapToBow)
/*  209 */         .withinDistance(7.0D, 14.0D)
/*  210 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  211 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  214 */     .newBehaviorRoot(
/*  215 */       CECombatBehaviors.BehaviorRoot.builder()
/*  216 */       .priority(2.0D)
/*  217 */       .weight(80.0D)
/*  218 */       .maxCooldown(120)
/*  219 */       .addFirstBehavior(
/*  220 */         CECombatBehaviors.Behavior.builder()
/*  221 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  222 */         .custom(CombatCommon::canThrowEnderPearl)
/*  223 */         .withinDistance(7.0D, 48.0D)
/*  224 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  225 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  228 */     .newBehaviorRoot(
/*  229 */       CECombatBehaviors.BehaviorRoot.builder()
/*  230 */       .priority(1.0D)
/*  231 */       .weight(40.0D)
/*  232 */       .maxCooldown(20)
/*  233 */       .addFirstBehavior(
/*  234 */         CECombatBehaviors.Behavior.builder()
/*  235 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  236 */         .withinDistance(0.0D, 5.0D)
/*  237 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  238 */         .addNextBehavior(
/*  239 */           CECombatBehaviors.Behavior.builder()
/*  240 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  241 */           .withinDistance(0.0D, 6.0D)
/*  242 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  243 */           .addNextBehavior(
/*  244 */             CECombatBehaviors.Behavior.builder()
/*  245 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  246 */             .withinDistance(0.0D, 6.0D)
/*  247 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  248 */             .addNextBehavior(
/*  249 */               CECombatBehaviors.Behavior.builder()
/*  250 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  251 */               .withinDistance(0.0D, 6.0D)
/*  252 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  253 */               .addNextBehavior(
/*  254 */                 CECombatBehaviors.Behavior.builder()
/*  255 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  256 */                 .withinDistance(0.0D, 7.0D)
/*  257 */                 .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  258 */                 .addNextBehavior(
/*  259 */                   CECombatBehaviors.Behavior.builder()
/*  260 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  261 */                   .withinDistance(0.0D, 7.0D)
/*  262 */                   .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F).addNextBehavior(
/*  263 */                     CECombatBehaviors.Behavior.builder()
/*  264 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  265 */                     .withinDistance(0.0D, 7.0D)
/*  266 */                     .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/*  267 */                     .addNextBehavior(
/*  268 */                       CECombatBehaviors.Behavior.builder()
/*  269 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  270 */                       .withinDistance(0.0D, 7.0D)
/*  271 */                       .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  281 */       .addFirstBehavior(
/*  282 */         CECombatBehaviors.Behavior.builder()
/*  283 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  284 */         .withinDistance(0.0D, 5.0D)
/*  285 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  286 */         .addNextBehavior(
/*  287 */           CECombatBehaviors.Behavior.builder()
/*  288 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  289 */           .withinDistance(0.0D, 6.0D)
/*  290 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  291 */           .addNextBehavior(
/*  292 */             CECombatBehaviors.Behavior.builder()
/*  293 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  294 */             .withinDistance(0.0D, 6.0D)
/*  295 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  296 */             .addNextBehavior(
/*  297 */               CECombatBehaviors.Behavior.builder()
/*  298 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  299 */               .withinDistance(0.0D, 7.0D)
/*  300 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  306 */       .addFirstBehavior(
/*  307 */         CECombatBehaviors.Behavior.builder()
/*  308 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  309 */         .withinDistance(0.0D, 5.0D)
/*  310 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  311 */         .addNextBehavior(
/*  312 */           CECombatBehaviors.Behavior.builder()
/*  313 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  314 */           .withinDistance(0.0D, 5.0D)
/*  315 */           .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  316 */           .addNextBehavior(
/*  317 */             CECombatBehaviors.Behavior.builder()
/*  318 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  319 */             .withinDistance(0.0D, 5.0D)
/*  320 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F).addNextBehavior(
/*  321 */               CECombatBehaviors.Behavior.builder()
/*  322 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  323 */               .withinDistance(0.0D, 5.0D)
/*  324 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  329 */       .addFirstBehavior(
/*  330 */         CECombatBehaviors.Behavior.builder()
/*  331 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  332 */         .withinDistance(0.0D, 3.0D)
/*  333 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  334 */         .addNextBehavior(
/*  335 */           CECombatBehaviors.Behavior.builder()
/*  336 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  337 */           .withinDistance(0.0D, 3.0D)
/*  338 */           .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  339 */           .addNextBehavior(
/*  340 */             CECombatBehaviors.Behavior.builder()
/*  341 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  342 */             .withinDistance(0.0D, 4.0D)
/*  343 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  344 */             .addNextBehavior(
/*  345 */               CECombatBehaviors.Behavior.builder()
/*  346 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  347 */               .withinDistance(0.0D, 4.0D)
/*  348 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  349 */               .addNextBehavior(
/*  350 */                 CECombatBehaviors.Behavior.builder()
/*  351 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  352 */                 .withinDistance(0.0D, 5.0D)
/*  353 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  354 */                 .addNextBehavior(
/*  355 */                   CECombatBehaviors.Behavior.builder()
/*  356 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  357 */                   .withinDistance(0.0D, 5.0D)
/*  358 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  365 */       .addFirstBehavior(
/*  366 */         CECombatBehaviors.Behavior.builder()
/*  367 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  368 */         .withinDistance(0.0D, 3.0D)
/*  369 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  370 */         .addNextBehavior(
/*  371 */           CECombatBehaviors.Behavior.builder()
/*  372 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  373 */           .withinDistance(0.0D, 3.0D)
/*  374 */           .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/*  375 */           .addNextBehavior(
/*  376 */             CECombatBehaviors.Behavior.builder()
/*  377 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  378 */             .withinDistance(0.0D, 4.0D)
/*  379 */             .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  380 */             .addNextBehavior(
/*  381 */               CECombatBehaviors.Behavior.builder()
/*  382 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  383 */               .withinDistance(0.0D, 4.0D)
/*  384 */               .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  385 */               .addNextBehavior(
/*  386 */                 CECombatBehaviors.Behavior.builder()
/*  387 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  388 */                 .withinDistance(0.0D, 5.0D)
/*  389 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  390 */                 .addNextBehavior(
/*  391 */                   CECombatBehaviors.Behavior.builder()
/*  392 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  393 */                   .withinDistance(0.0D, 5.0D)
/*  394 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  401 */       .addFirstBehavior(
/*  402 */         CECombatBehaviors.Behavior.builder()
/*  403 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  404 */         .withinDistance(0.0D, 3.0D)
/*  405 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  406 */         .addNextBehavior(
/*  407 */           CECombatBehaviors.Behavior.builder()
/*  408 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  409 */           .withinDistance(0.0D, 3.0D)
/*  410 */           .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  411 */           .addNextBehavior(
/*  412 */             CECombatBehaviors.Behavior.builder()
/*  413 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  414 */             .withinDistance(0.0D, 4.0D)
/*  415 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  416 */             .addNextBehavior(
/*  417 */               CECombatBehaviors.Behavior.builder()
/*  418 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  419 */               .withinDistance(0.0D, 4.0D)
/*  420 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  421 */               .addNextBehavior(
/*  422 */                 CECombatBehaviors.Behavior.builder()
/*  423 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  424 */                 .withinDistance(0.0D, 5.0D)
/*  425 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  426 */                 .addNextBehavior(
/*  427 */                   CECombatBehaviors.Behavior.builder()
/*  428 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  429 */                   .withinDistance(0.0D, 5.0D)
/*  430 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
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
/*  441 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  442 */         .addNextBehavior(
/*  443 */           CECombatBehaviors.Behavior.builder()
/*  444 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  445 */           .withinDistance(0.0D, 3.0D)
/*  446 */           .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/*  447 */           .addNextBehavior(
/*  448 */             CECombatBehaviors.Behavior.builder()
/*  449 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  450 */             .withinDistance(0.0D, 4.0D)
/*  451 */             .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  452 */             .addNextBehavior(
/*  453 */               CECombatBehaviors.Behavior.builder()
/*  454 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  455 */               .withinDistance(0.0D, 4.0D)
/*  456 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  457 */               .addNextBehavior(
/*  458 */                 CECombatBehaviors.Behavior.builder()
/*  459 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  460 */                 .withinDistance(0.0D, 5.0D)
/*  461 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  462 */                 .addNextBehavior(
/*  463 */                   CECombatBehaviors.Behavior.builder()
/*  464 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  465 */                   .withinDistance(0.0D, 5.0D)
/*  466 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  473 */       .addFirstBehavior(
/*  474 */         CECombatBehaviors.Behavior.builder()
/*  475 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  476 */         .withinDistance(0.0D, 3.0D)
/*  477 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  478 */         .addNextBehavior(
/*  479 */           CECombatBehaviors.Behavior.builder()
/*  480 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  481 */           .withinDistance(0.0D, 3.0D)
/*  482 */           .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  483 */           .addNextBehavior(
/*  484 */             CECombatBehaviors.Behavior.builder()
/*  485 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */             .withinDistance(0.0D, 4.0D)
/*  487 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  488 */             .addNextBehavior(
/*  489 */               CECombatBehaviors.Behavior.builder()
/*  490 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  491 */               .withinDistance(0.0D, 4.0D)
/*  492 */               .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  493 */               .addNextBehavior(
/*  494 */                 CECombatBehaviors.Behavior.builder()
/*  495 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  496 */                 .withinDistance(0.0D, 5.0D)
/*  497 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  498 */                 .addNextBehavior(
/*  499 */                   CECombatBehaviors.Behavior.builder()
/*  500 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  501 */                   .withinDistance(0.0D, 5.0D)
/*  502 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  509 */       .addFirstBehavior(
/*  510 */         CECombatBehaviors.Behavior.builder()
/*  511 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  512 */         .withinDistance(0.0D, 3.0D)
/*  513 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  514 */         .addNextBehavior(
/*  515 */           CECombatBehaviors.Behavior.builder()
/*  516 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  517 */           .withinDistance(0.0D, 3.0D)
/*  518 */           .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  519 */           .addNextBehavior(
/*  520 */             CECombatBehaviors.Behavior.builder()
/*  521 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  522 */             .withinDistance(0.0D, 4.0D)
/*  523 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  524 */             .addNextBehavior(
/*  525 */               CECombatBehaviors.Behavior.builder()
/*  526 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  527 */               .withinDistance(0.0D, 4.0D)
/*  528 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/*  529 */               .addNextBehavior(
/*  530 */                 CECombatBehaviors.Behavior.builder()
/*  531 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  532 */                 .withinDistance(0.0D, 5.0D)
/*  533 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  534 */                 .addNextBehavior(
/*  535 */                   CECombatBehaviors.Behavior.builder()
/*  536 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  537 */                   .withinDistance(0.0D, 5.0D)
/*  538 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
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
/*  549 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  550 */         .addNextBehavior(
/*  551 */           CECombatBehaviors.Behavior.builder()
/*  552 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  553 */           .withinDistance(0.0D, 3.0D)
/*  554 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  555 */           .addNextBehavior(
/*  556 */             CECombatBehaviors.Behavior.builder()
/*  557 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  558 */             .withinDistance(0.0D, 4.0D)
/*  559 */             .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  560 */             .addNextBehavior(
/*  561 */               CECombatBehaviors.Behavior.builder()
/*  562 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  563 */               .withinDistance(0.0D, 4.0D)
/*  564 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/*  565 */               .addNextBehavior(
/*  566 */                 CECombatBehaviors.Behavior.builder()
/*  567 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  568 */                 .withinDistance(0.0D, 5.0D)
/*  569 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  570 */                 .addNextBehavior(
/*  571 */                   CECombatBehaviors.Behavior.builder()
/*  572 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  573 */                   .withinDistance(0.0D, 5.0D)
/*  574 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  581 */       .addFirstBehavior(
/*  582 */         CECombatBehaviors.Behavior.builder()
/*  583 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  584 */         .withinDistance(0.0D, 3.0D)
/*  585 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  586 */         .addNextBehavior(
/*  587 */           CECombatBehaviors.Behavior.builder()
/*  588 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  589 */           .withinDistance(0.0D, 3.0D)
/*  590 */           .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  591 */           .addNextBehavior(
/*  592 */             CECombatBehaviors.Behavior.builder()
/*  593 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  594 */             .withinDistance(0.0D, 4.0D)
/*  595 */             .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/*  596 */             .addNextBehavior(
/*  597 */               CECombatBehaviors.Behavior.builder()
/*  598 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  599 */               .withinDistance(0.0D, 4.0D)
/*  600 */               .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  601 */               .addNextBehavior(
/*  602 */                 CECombatBehaviors.Behavior.builder()
/*  603 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  604 */                 .withinDistance(0.0D, 5.0D)
/*  605 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  606 */                 .addNextBehavior(
/*  607 */                   CECombatBehaviors.Behavior.builder()
/*  608 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  609 */                   .withinDistance(0.0D, 5.0D)
/*  610 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  617 */       .addFirstBehavior(
/*  618 */         CECombatBehaviors.Behavior.builder()
/*  619 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  620 */         .withinDistance(0.0D, 3.0D)
/*  621 */         .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  622 */         .addNextBehavior(
/*  623 */           CECombatBehaviors.Behavior.builder()
/*  624 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  625 */           .withinDistance(0.0D, 3.0D)
/*  626 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  627 */           .addNextBehavior(
/*  628 */             CECombatBehaviors.Behavior.builder()
/*  629 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  630 */             .withinDistance(0.0D, 4.0D)
/*  631 */             .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  632 */             .addNextBehavior(
/*  633 */               CECombatBehaviors.Behavior.builder()
/*  634 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  635 */               .withinDistance(0.0D, 4.0D)
/*  636 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/*  637 */               .addNextBehavior(
/*  638 */                 CECombatBehaviors.Behavior.builder()
/*  639 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  640 */                 .withinDistance(0.0D, 5.0D)
/*  641 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  642 */                 .addNextBehavior(
/*  643 */                   CECombatBehaviors.Behavior.builder()
/*  644 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  645 */                   .withinDistance(0.0D, 5.0D)
/*  646 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  653 */       .addFirstBehavior(
/*  654 */         CECombatBehaviors.Behavior.builder()
/*  655 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  656 */         .withinDistance(0.0D, 3.0D)
/*  657 */         .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/*  658 */         .addNextBehavior(
/*  659 */           CECombatBehaviors.Behavior.builder()
/*  660 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  661 */           .withinDistance(0.0D, 3.0D)
/*  662 */           .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  663 */           .addNextBehavior(
/*  664 */             CECombatBehaviors.Behavior.builder()
/*  665 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  666 */             .withinDistance(0.0D, 4.0D)
/*  667 */             .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/*  668 */             .addNextBehavior(
/*  669 */               CECombatBehaviors.Behavior.builder()
/*  670 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  671 */               .withinDistance(0.0D, 4.0D)
/*  672 */               .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)
/*  673 */               .addNextBehavior(
/*  674 */                 CECombatBehaviors.Behavior.builder()
/*  675 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  676 */                 .withinDistance(0.0D, 5.0D)
/*  677 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  678 */                 .addNextBehavior(
/*  679 */                   CECombatBehaviors.Behavior.builder()
/*  680 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  681 */                   .withinDistance(0.0D, 5.0D)
/*  682 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  689 */       .addFirstBehavior(
/*  690 */         CECombatBehaviors.Behavior.builder()
/*  691 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  692 */         .withinDistance(0.0D, 3.0D)
/*  693 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  694 */         .addNextBehavior(
/*  695 */           CECombatBehaviors.Behavior.builder()
/*  696 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  697 */           .withinDistance(0.0D, 3.0D)
/*  698 */           .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  699 */           .addNextBehavior(
/*  700 */             CECombatBehaviors.Behavior.builder()
/*  701 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  702 */             .withinDistance(0.0D, 4.0D)
/*  703 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  704 */             .addNextBehavior(
/*  705 */               CECombatBehaviors.Behavior.builder()
/*  706 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  707 */               .withinDistance(0.0D, 4.0D)
/*  708 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  709 */               .addNextBehavior(
/*  710 */                 CECombatBehaviors.Behavior.builder()
/*  711 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  712 */                 .withinDistance(0.0D, 5.0D)
/*  713 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  714 */                 .addNextBehavior(
/*  715 */                   CECombatBehaviors.Behavior.builder()
/*  716 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  717 */                   .withinDistance(0.0D, 5.0D)
/*  718 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  725 */       .addFirstBehavior(
/*  726 */         CECombatBehaviors.Behavior.builder()
/*  727 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  728 */         .withinDistance(0.0D, 3.0D)
/*  729 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  730 */         .addNextBehavior(
/*  731 */           CECombatBehaviors.Behavior.builder()
/*  732 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  733 */           .withinDistance(0.0D, 3.0D)
/*  734 */           .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/*  735 */           .addNextBehavior(
/*  736 */             CECombatBehaviors.Behavior.builder()
/*  737 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  738 */             .withinDistance(0.0D, 4.0D)
/*  739 */             .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  740 */             .addNextBehavior(
/*  741 */               CECombatBehaviors.Behavior.builder()
/*  742 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  743 */               .withinDistance(0.0D, 4.0D)
/*  744 */               .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  745 */               .addNextBehavior(
/*  746 */                 CECombatBehaviors.Behavior.builder()
/*  747 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  748 */                 .withinDistance(0.0D, 5.0D)
/*  749 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  750 */                 .addNextBehavior(
/*  751 */                   CECombatBehaviors.Behavior.builder()
/*  752 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  753 */                   .withinDistance(0.0D, 5.0D)
/*  754 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  761 */       .addFirstBehavior(
/*  762 */         CECombatBehaviors.Behavior.builder()
/*  763 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  764 */         .withinDistance(0.0D, 3.0D)
/*  765 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  766 */         .addNextBehavior(
/*  767 */           CECombatBehaviors.Behavior.builder()
/*  768 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  769 */           .withinDistance(0.0D, 3.0D)
/*  770 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  771 */           .addNextBehavior(
/*  772 */             CECombatBehaviors.Behavior.builder()
/*  773 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  774 */             .withinDistance(0.0D, 4.0D)
/*  775 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  776 */             .addNextBehavior(
/*  777 */               CECombatBehaviors.Behavior.builder()
/*  778 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  779 */               .withinDistance(0.0D, 4.0D)
/*  780 */               .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  781 */               .addNextBehavior(
/*  782 */                 CECombatBehaviors.Behavior.builder()
/*  783 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  784 */                 .withinDistance(0.0D, 5.0D)
/*  785 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  786 */                 .addNextBehavior(
/*  787 */                   CECombatBehaviors.Behavior.builder()
/*  788 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  789 */                   .withinDistance(0.0D, 5.0D)
/*  790 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  797 */       .addFirstBehavior(
/*  798 */         CECombatBehaviors.Behavior.builder()
/*  799 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  800 */         .withinDistance(0.0D, 3.0D)
/*  801 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  802 */         .addNextBehavior(
/*  803 */           CECombatBehaviors.Behavior.builder()
/*  804 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  805 */           .withinDistance(0.0D, 3.0D)
/*  806 */           .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  807 */           .addNextBehavior(
/*  808 */             CECombatBehaviors.Behavior.builder()
/*  809 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  810 */             .withinDistance(0.0D, 4.0D)
/*  811 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  812 */             .addNextBehavior(
/*  813 */               CECombatBehaviors.Behavior.builder()
/*  814 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  815 */               .withinDistance(0.0D, 4.0D)
/*  816 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/*  817 */               .addNextBehavior(
/*  818 */                 CECombatBehaviors.Behavior.builder()
/*  819 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  820 */                 .withinDistance(0.0D, 5.0D)
/*  821 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  822 */                 .addNextBehavior(
/*  823 */                   CECombatBehaviors.Behavior.builder()
/*  824 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  825 */                   .withinDistance(0.0D, 5.0D)
/*  826 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  833 */       .addFirstBehavior(
/*  834 */         CECombatBehaviors.Behavior.builder()
/*  835 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  836 */         .withinDistance(0.0D, 3.0D)
/*  837 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  838 */         .addNextBehavior(
/*  839 */           CECombatBehaviors.Behavior.builder()
/*  840 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  841 */           .withinDistance(0.0D, 3.0D)
/*  842 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  843 */           .addNextBehavior(
/*  844 */             CECombatBehaviors.Behavior.builder()
/*  845 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  846 */             .withinDistance(0.0D, 4.0D)
/*  847 */             .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  848 */             .addNextBehavior(
/*  849 */               CECombatBehaviors.Behavior.builder()
/*  850 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  851 */               .withinDistance(0.0D, 4.0D)
/*  852 */               .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)
/*  853 */               .addNextBehavior(
/*  854 */                 CECombatBehaviors.Behavior.builder()
/*  855 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  856 */                 .withinDistance(0.0D, 5.0D)
/*  857 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  858 */                 .addNextBehavior(
/*  859 */                   CECombatBehaviors.Behavior.builder()
/*  860 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  861 */                   .withinDistance(0.0D, 5.0D)
/*  862 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  870 */     .newBehaviorRoot(
/*  871 */       CECombatBehaviors.BehaviorRoot.builder()
/*  872 */       .priority(1.0D)
/*  873 */       .weight(30.0D)
/*  874 */       .maxCooldown(100)
/*  875 */       .addFirstBehavior(
/*  876 */         CECombatBehaviors.Behavior.builder()
/*  877 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  878 */         .withinDistance(0.0D, 5.0D)
/*  879 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F))
/*      */       
/*  881 */       .addFirstBehavior(
/*  882 */         CECombatBehaviors.Behavior.builder()
/*  883 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  884 */         .withinDistance(0.0D, 5.0D)
/*  885 */         .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F))
/*      */       
/*  887 */       .addFirstBehavior(
/*  888 */         CECombatBehaviors.Behavior.builder()
/*  889 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  890 */         .withinDistance(0.0D, 5.0D)
/*  891 */         .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/*  892 */         .addExBehavior(SteveLegendarySword::legendarySwordSpecialAttack)))
/*      */ 
/*      */     
/*  895 */     .newBehaviorRoot(
/*  896 */       CECombatBehaviors.BehaviorRoot.builder()
/*  897 */       .priority(1.0D)
/*  898 */       .weight(20.0D)
/*  899 */       .maxCooldown(200)
/*  900 */       .addFirstBehavior(
/*  901 */         CECombatBehaviors.Behavior.builder()
/*  902 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  903 */         .withinDistance(0.0D, 5.0D)
/*  904 */         .animationBehavior(AnimsAgony.AGONY_RISING_EAGLE, 0.0F)
/*  905 */         .addExBehavior(SteveLegendarySword::legendarySwordHeavyAttack)))
/*      */ 
/*      */     
/*  908 */     .newBehaviorRoot(
/*  909 */       CECombatBehaviors.BehaviorRoot.builder()
/*  910 */       .priority(1.0D)
/*  911 */       .weight(10.0D)
/*  912 */       .maxCooldown(400)
/*  913 */       .addFirstBehavior(
/*  914 */         CECombatBehaviors.Behavior.builder()
/*  915 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  916 */         .withinDistance(5.0D, 10.0D)
/*  917 */         .animationBehavior(AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F)))
/*      */ 
/*      */     
/*  920 */     .newBehaviorRoot(
/*  921 */       CECombatBehaviors.BehaviorRoot.builder()
/*  922 */       .priority(1.0D)
/*  923 */       .weight(10.0D)
/*  924 */       .maxCooldown(40)
/*  925 */       .addFirstBehavior(
/*  926 */         CECombatBehaviors.Behavior.builder()
/*  927 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  928 */         .withinDistance(0.0D, 3.0D)
/*  929 */         .custom(CombatCommon::canThrowEnderPearl)
/*  930 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  931 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  932 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  935 */     .newBehaviorRoot(
/*  936 */       CECombatBehaviors.BehaviorRoot.builder()
/*  937 */       .priority(1.0D)
/*  938 */       .weight(2.0D)
/*  939 */       .maxCooldown(100)
/*  940 */       .addFirstBehavior(
/*  941 */         CECombatBehaviors.Behavior.builder()
/*  942 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  943 */         .withinDistance(0.0D, 3.0D)
/*  944 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  946 */       .addFirstBehavior(
/*  947 */         CECombatBehaviors.Behavior.builder()
/*  948 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  949 */         .withinDistance(0.0D, 3.0D)
/*  950 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  952 */       .addFirstBehavior(
/*  953 */         CECombatBehaviors.Behavior.builder()
/*  954 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  955 */         .withinDistance(0.0D, 3.0D)
/*  956 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  958 */       .addFirstBehavior(
/*  959 */         CECombatBehaviors.Behavior.builder()
/*  960 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  961 */         .withinDistance(0.0D, 3.0D)
/*  962 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  964 */       .addFirstBehavior(
/*  965 */         CECombatBehaviors.Behavior.builder()
/*  966 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  967 */         .withinDistance(0.0D, 3.0D)
/*  968 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  970 */       .addFirstBehavior(
/*  971 */         CECombatBehaviors.Behavior.builder()
/*  972 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  973 */         .withinDistance(0.0D, 3.0D)
/*  974 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  976 */       .addFirstBehavior(
/*  977 */         CECombatBehaviors.Behavior.builder()
/*  978 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  979 */         .withinDistance(0.0D, 3.0D)
/*  980 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  983 */     .newBehaviorRoot(
/*  984 */       CECombatBehaviors.BehaviorRoot.builder()
/*  985 */       .priority(1.0D)
/*  986 */       .weight(15.0D)
/*  987 */       .addFirstBehavior(
/*  988 */         CECombatBehaviors.Behavior.builder()
/*  989 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  990 */         .withinDistance(0.0D, 3.0D)
/*  991 */         .custom(CombatCommon::canPerformGuarding)
/*  992 */         .guard(40)))
/*      */ 
/*      */     
/*  995 */     .newBehaviorRoot(
/*  996 */       CECombatBehaviors.BehaviorRoot.builder()
/*  997 */       .priority(1.0D)
/*  998 */       .weight(10.0D)
/*  999 */       .addFirstBehavior(
/* 1000 */         CECombatBehaviors.Behavior.builder()
/* 1001 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1002 */         .withinDistance(0.0D, 3.0D)
/* 1003 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1005 */       .addFirstBehavior(
/* 1006 */         CECombatBehaviors.Behavior.builder()
/* 1007 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1008 */         .withinDistance(0.0D, 3.0D)
/* 1009 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1011 */       .addFirstBehavior(
/* 1012 */         CECombatBehaviors.Behavior.builder()
/* 1013 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1014 */         .withinDistance(0.0D, 3.0D)
/* 1015 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1017 */       .addFirstBehavior(
/* 1018 */         CECombatBehaviors.Behavior.builder()
/* 1019 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1020 */         .withinDistance(0.0D, 3.0D)
/* 1021 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1024 */     .newBehaviorRoot(
/* 1025 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1026 */       .priority(1.0D)
/* 1027 */       .weight(40.0D)
/* 1028 */       .maxCooldown(160)
/* 1029 */       .addFirstBehavior(
/* 1030 */         CECombatBehaviors.Behavior.builder()
/* 1031 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1032 */         .custom(CombatCommon::canJump)
/* 1033 */         .withinDistance(5.0D, 14.0D)
/* 1034 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1035 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveLegendarySword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */