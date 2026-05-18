/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*      */ import com.pla.annoyingvillagers.task.DelayedTask;
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
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsRuine;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*      */ import yesman.epicfight.api.asset.AssetAccessor;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*      */ 
/*      */ public class BlueDemonLegendarySword {
/*      */   static void legendarySwordHeavyAttack(final MobPatch<?> mobpatch) {
/*   28 */     final BlueDemonEntity blueDemonEntity = (BlueDemonEntity)mobpatch.getOriginal();
/*   29 */     ItemStack itemStack = blueDemonEntity.m_21205_();
/*   30 */     if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.LegendarySwordItem) { Level level = blueDemonEntity.m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/*   31 */         blueDemonEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/*   32 */         new DelayedTask(10)
/*      */           {
/*      */             public void run() {
/*   35 */               serverLevel.m_6263_(null, blueDemonEntity
/*      */                   
/*   37 */                   .m_20185_(), blueDemonEntity.m_20186_(), blueDemonEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_START
/*   38 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   43 */               serverLevel.m_6263_(null, blueDemonEntity
/*      */                   
/*   45 */                   .m_20185_(), blueDemonEntity.m_20186_(), blueDemonEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD
/*   46 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   51 */               serverLevel.m_6263_(null, blueDemonEntity
/*      */                   
/*   53 */                   .m_20185_(), blueDemonEntity.m_20186_(), blueDemonEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD_2
/*   54 */                   .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   59 */               serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, blueDemonEntity
/*      */                   
/*   61 */                   .m_20185_(), blueDemonEntity.m_20186_(), blueDemonEntity.m_20189_(), 15, 0.0D, 0.0D, 0.0D, 0.2D);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   66 */               serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, blueDemonEntity
/*      */                   
/*   68 */                   .m_20185_(), blueDemonEntity.m_20188_(), blueDemonEntity.m_20189_(), 100, 0.0D, 0.0D, 0.0D, 0.5D);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*   73 */               mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_HEAVY_ATTACK, 0.0F);
/*      */             }
/*      */           }; }
/*      */        }
/*      */   
/*      */   }
/*      */   static void legendarySwordSpecialAttack(final MobPatch<?> mobpatch) {
/*   80 */     BlueDemonEntity blueDemonEntity = (BlueDemonEntity)mobpatch.getOriginal();
/*   81 */     ItemStack itemStack = blueDemonEntity.m_21205_();
/*   82 */     if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.LegendarySwordItem && blueDemonEntity.m_9236_() instanceof ServerLevel) {
/*   83 */       blueDemonEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/*   84 */       new DelayedTask(20)
/*      */         {
/*      */           public void run() {
/*   87 */             mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F);
/*      */           }
/*      */         };
/*      */     } 
/*      */   }
/*      */   
/*   93 */   public static final CECombatBehaviors.Builder<MobPatch<?>> LEGENDARY_SWORD = CECombatBehaviors.builder()
/*   94 */     .newBehaviorRoot(
/*   95 */       CECombatBehaviors.BehaviorRoot.builder()
/*   96 */       .priority(4.0D)
/*   97 */       .weight(1000.0D)
/*   98 */       .maxCooldown(0)
/*   99 */       .addFirstBehavior(
/*  100 */         CECombatBehaviors.Behavior.builder()
/*  101 */         .custom(CombatCommon::canExecute)
/*  102 */         .withinDistance(0.0D, 5.0D)
/*  103 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  104 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*  107 */     .newBehaviorRoot(
/*  108 */       CECombatBehaviors.BehaviorRoot.builder()
/*  109 */       .priority(3.0D)
/*  110 */       .weight(1000.0D)
/*  111 */       .maxCooldown(0)
/*  112 */       .addFirstBehavior(
/*  113 */         CECombatBehaviors.Behavior.builder()
/*  114 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  115 */         .custom(CombatCommon::canEscape)
/*  116 */         .withinDistance(0.0D, 8.0D)
/*  117 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  118 */         .addExBehavior(CombatCommon::performEscapeRunAway))
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
/*  136 */         .animationBehavior(Animations.BIPED_ROLL_BACKWARD, 0.0F)
/*  137 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  139 */       .addFirstBehavior(
/*  140 */         CECombatBehaviors.Behavior.builder()
/*  141 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  142 */         .custom(CombatCommon::canSwitchWeapon)
/*  143 */         .animationBehavior(Animations.BIPED_ROLL_FORWARD, 0.0F)
/*  144 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  146 */       .addFirstBehavior(
/*  147 */         CECombatBehaviors.Behavior.builder()
/*  148 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  149 */         .custom(CombatCommon::canSwitchWeapon)
/*  150 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  151 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  153 */       .addFirstBehavior(
/*  154 */         CECombatBehaviors.Behavior.builder()
/*  155 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  156 */         .custom(CombatCommon::canSwitchWeapon)
/*  157 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  158 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  160 */       .addFirstBehavior(
/*  161 */         CECombatBehaviors.Behavior.builder()
/*  162 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  163 */         .custom(CombatCommon::canSwitchWeapon)
/*  164 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  165 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  167 */       .addFirstBehavior(
/*  168 */         CECombatBehaviors.Behavior.builder()
/*  169 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  170 */         .custom(CombatCommon::canSwitchWeapon)
/*  171 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  172 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*  175 */     .newBehaviorRoot(
/*  176 */       CECombatBehaviors.BehaviorRoot.builder()
/*  177 */       .priority(1.0D)
/*  178 */       .weight(40.0D)
/*  179 */       .maxCooldown(20)
/*  180 */       .addFirstBehavior(
/*  181 */         CECombatBehaviors.Behavior.builder()
/*  182 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  183 */         .withinDistance(0.0D, 5.0D)
/*  184 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  185 */         .addNextBehavior(
/*  186 */           CECombatBehaviors.Behavior.builder()
/*  187 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  188 */           .withinDistance(0.0D, 6.0D)
/*  189 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  190 */           .addNextBehavior(
/*  191 */             CECombatBehaviors.Behavior.builder()
/*  192 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  193 */             .withinDistance(0.0D, 6.0D)
/*  194 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  195 */             .addNextBehavior(
/*  196 */               CECombatBehaviors.Behavior.builder()
/*  197 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  198 */               .withinDistance(0.0D, 6.0D)
/*  199 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  200 */               .addNextBehavior(
/*  201 */                 CECombatBehaviors.Behavior.builder()
/*  202 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  203 */                 .withinDistance(0.0D, 7.0D)
/*  204 */                 .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  205 */                 .addNextBehavior(
/*  206 */                   CECombatBehaviors.Behavior.builder()
/*  207 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  208 */                   .withinDistance(0.0D, 7.0D)
/*  209 */                   .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  210 */                   .addNextBehavior(
/*  211 */                     CECombatBehaviors.Behavior.builder()
/*  212 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  213 */                     .withinDistance(0.0D, 7.0D)
/*  214 */                     .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/*  215 */                     .addNextBehavior(
/*  216 */                       CECombatBehaviors.Behavior.builder()
/*  217 */                       .custom(CombatCommon::canPerformNormalAttackLogic)
/*  218 */                       .withinDistance(0.0D, 7.0D)
/*  219 */                       .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  229 */       .addFirstBehavior(
/*  230 */         CECombatBehaviors.Behavior.builder()
/*  231 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  232 */         .withinDistance(0.0D, 5.0D)
/*  233 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  234 */         .addNextBehavior(
/*  235 */           CECombatBehaviors.Behavior.builder()
/*  236 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  237 */           .withinDistance(0.0D, 6.0D)
/*  238 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  239 */           .addNextBehavior(
/*  240 */             CECombatBehaviors.Behavior.builder()
/*  241 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  242 */             .withinDistance(0.0D, 6.0D)
/*  243 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  244 */             .addNextBehavior(
/*  245 */               CECombatBehaviors.Behavior.builder()
/*  246 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  247 */               .withinDistance(0.0D, 7.0D)
/*  248 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  254 */       .addFirstBehavior(
/*  255 */         CECombatBehaviors.Behavior.builder()
/*  256 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  257 */         .withinDistance(0.0D, 5.0D)
/*  258 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  259 */         .addNextBehavior(
/*  260 */           CECombatBehaviors.Behavior.builder()
/*  261 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  262 */           .withinDistance(0.0D, 5.0D)
/*  263 */           .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  264 */           .addNextBehavior(
/*  265 */             CECombatBehaviors.Behavior.builder()
/*  266 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  267 */             .withinDistance(0.0D, 5.0D)
/*  268 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F).addNextBehavior(
/*  269 */               CECombatBehaviors.Behavior.builder()
/*  270 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  271 */               .withinDistance(0.0D, 5.0D)
/*  272 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  277 */       .addFirstBehavior(
/*  278 */         CECombatBehaviors.Behavior.builder()
/*  279 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  280 */         .withinDistance(0.0D, 5.0D)
/*  281 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  282 */         .addNextBehavior(
/*  283 */           CECombatBehaviors.Behavior.builder()
/*  284 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  285 */           .withinDistance(0.0D, 6.0D)
/*  286 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  287 */           .addNextBehavior(
/*  288 */             CECombatBehaviors.Behavior.builder()
/*  289 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  290 */             .withinDistance(0.0D, 6.0D)
/*  291 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  292 */             .addNextBehavior(
/*  293 */               CECombatBehaviors.Behavior.builder()
/*  294 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  295 */               .withinDistance(0.0D, 6.0D)
/*  296 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  297 */               .addNextBehavior(
/*  298 */                 CECombatBehaviors.Behavior.builder()
/*  299 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  300 */                 .withinDistance(0.0D, 8.0D)
/*  301 */                 .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  307 */       .addFirstBehavior(
/*  308 */         CECombatBehaviors.Behavior.builder()
/*  309 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  310 */         .withinDistance(0.0D, 5.0D)
/*  311 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  312 */         .addNextBehavior(
/*  313 */           CECombatBehaviors.Behavior.builder()
/*  314 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  315 */           .withinDistance(0.0D, 6.0D)
/*  316 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/*  317 */           .addNextBehavior(
/*  318 */             CECombatBehaviors.Behavior.builder()
/*  319 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  320 */             .withinDistance(0.0D, 6.0D)
/*  321 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  322 */             .addNextBehavior(
/*  323 */               CECombatBehaviors.Behavior.builder()
/*  324 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  325 */               .withinDistance(0.0D, 6.0D)
/*  326 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  327 */               .addNextBehavior(
/*  328 */                 CECombatBehaviors.Behavior.builder()
/*  329 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  330 */                 .withinDistance(0.0D, 8.0D)
/*  331 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  337 */       .addFirstBehavior(
/*  338 */         CECombatBehaviors.Behavior.builder()
/*  339 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  340 */         .withinDistance(0.0D, 5.0D)
/*  341 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  342 */         .addNextBehavior(
/*  343 */           CECombatBehaviors.Behavior.builder()
/*  344 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  345 */           .withinDistance(0.0D, 6.0D)
/*  346 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  347 */           .addNextBehavior(
/*  348 */             CECombatBehaviors.Behavior.builder()
/*  349 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  350 */             .withinDistance(0.0D, 6.0D)
/*  351 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  352 */             .addNextBehavior(
/*  353 */               CECombatBehaviors.Behavior.builder()
/*  354 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  355 */               .withinDistance(0.0D, 6.0D)
/*  356 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  362 */       .addFirstBehavior(
/*  363 */         CECombatBehaviors.Behavior.builder()
/*  364 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  365 */         .withinDistance(0.0D, 5.0D)
/*  366 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  367 */         .addNextBehavior(
/*  368 */           CECombatBehaviors.Behavior.builder()
/*  369 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  370 */           .withinDistance(0.0D, 6.0D)
/*  371 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  372 */           .addNextBehavior(
/*  373 */             CECombatBehaviors.Behavior.builder()
/*  374 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  375 */             .withinDistance(0.0D, 6.0D)
/*  376 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  377 */             .addNextBehavior(
/*  378 */               CECombatBehaviors.Behavior.builder()
/*  379 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  380 */               .withinDistance(0.0D, 6.0D)
/*  381 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  387 */       .addFirstBehavior(
/*  388 */         CECombatBehaviors.Behavior.builder()
/*  389 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  390 */         .withinDistance(0.0D, 5.0D)
/*  391 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  392 */         .addNextBehavior(
/*  393 */           CECombatBehaviors.Behavior.builder()
/*  394 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  395 */           .withinDistance(0.0D, 6.0D)
/*  396 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  397 */           .addNextBehavior(
/*  398 */             CECombatBehaviors.Behavior.builder()
/*  399 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  400 */             .withinDistance(0.0D, 6.0D)
/*  401 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  402 */             .addNextBehavior(
/*  403 */               CECombatBehaviors.Behavior.builder()
/*  404 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  405 */               .withinDistance(0.0D, 6.0D)
/*  406 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  412 */       .addFirstBehavior(
/*  413 */         CECombatBehaviors.Behavior.builder()
/*  414 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  415 */         .withinDistance(0.0D, 5.0D)
/*  416 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  417 */         .addNextBehavior(
/*  418 */           CECombatBehaviors.Behavior.builder()
/*  419 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  420 */           .withinDistance(0.0D, 6.0D)
/*  421 */           .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  422 */           .addNextBehavior(
/*  423 */             CECombatBehaviors.Behavior.builder()
/*  424 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  425 */             .withinDistance(0.0D, 6.0D)
/*  426 */             .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  427 */             .addNextBehavior(
/*  428 */               CECombatBehaviors.Behavior.builder()
/*  429 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  430 */               .withinDistance(0.0D, 6.0D)
/*  431 */               .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  437 */       .addFirstBehavior(
/*  438 */         CECombatBehaviors.Behavior.builder()
/*  439 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  440 */         .withinDistance(0.0D, 5.0D)
/*  441 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  442 */         .addNextBehavior(
/*  443 */           CECombatBehaviors.Behavior.builder()
/*  444 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  445 */           .withinDistance(0.0D, 6.0D)
/*  446 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  447 */           .addNextBehavior(
/*  448 */             CECombatBehaviors.Behavior.builder()
/*  449 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  450 */             .withinDistance(0.0D, 6.0D)
/*  451 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/*  452 */             .addNextBehavior(
/*  453 */               CECombatBehaviors.Behavior.builder()
/*  454 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  455 */               .withinDistance(0.0D, 6.0D)
/*  456 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  462 */       .addFirstBehavior(
/*  463 */         CECombatBehaviors.Behavior.builder()
/*  464 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  465 */         .withinDistance(0.0D, 5.0D)
/*  466 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  467 */         .addNextBehavior(
/*  468 */           CECombatBehaviors.Behavior.builder()
/*  469 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  470 */           .withinDistance(0.0D, 6.0D)
/*  471 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  472 */           .addNextBehavior(
/*  473 */             CECombatBehaviors.Behavior.builder()
/*  474 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  475 */             .withinDistance(0.0D, 6.0D)
/*  476 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  477 */             .addNextBehavior(
/*  478 */               CECombatBehaviors.Behavior.builder()
/*  479 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  480 */               .withinDistance(0.0D, 6.0D)
/*  481 */               .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  487 */       .addFirstBehavior(
/*  488 */         CECombatBehaviors.Behavior.builder()
/*  489 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  490 */         .withinDistance(0.0D, 5.0D)
/*  491 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  492 */         .addNextBehavior(
/*  493 */           CECombatBehaviors.Behavior.builder()
/*  494 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  495 */           .withinDistance(0.0D, 6.0D)
/*  496 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*  497 */           .addNextBehavior(
/*  498 */             CECombatBehaviors.Behavior.builder()
/*  499 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  500 */             .withinDistance(0.0D, 6.0D)
/*  501 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  502 */             .addNextBehavior(
/*  503 */               CECombatBehaviors.Behavior.builder()
/*  504 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  505 */               .withinDistance(0.0D, 6.0D)
/*  506 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  512 */       .addFirstBehavior(
/*  513 */         CECombatBehaviors.Behavior.builder()
/*  514 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  515 */         .withinDistance(0.0D, 5.0D)
/*  516 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  517 */         .addNextBehavior(
/*  518 */           CECombatBehaviors.Behavior.builder()
/*  519 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  520 */           .withinDistance(0.0D, 6.0D)
/*  521 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  522 */           .addNextBehavior(
/*  523 */             CECombatBehaviors.Behavior.builder()
/*  524 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  525 */             .withinDistance(0.0D, 6.0D)
/*  526 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  531 */       .addFirstBehavior(
/*  532 */         CECombatBehaviors.Behavior.builder()
/*  533 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  534 */         .withinDistance(0.0D, 5.0D)
/*  535 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  536 */         .addNextBehavior(
/*  537 */           CECombatBehaviors.Behavior.builder()
/*  538 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  539 */           .withinDistance(0.0D, 6.0D)
/*  540 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/*  541 */           .addNextBehavior(
/*  542 */             CECombatBehaviors.Behavior.builder()
/*  543 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  544 */             .withinDistance(0.0D, 6.0D)
/*  545 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F))))
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  550 */       .addFirstBehavior(
/*  551 */         CECombatBehaviors.Behavior.builder()
/*  552 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  553 */         .withinDistance(0.0D, 5.0D)
/*  554 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  555 */         .addNextBehavior(
/*  556 */           CECombatBehaviors.Behavior.builder()
/*  557 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  558 */           .withinDistance(0.0D, 6.0D)
/*  559 */           .animationBehavior(AnimsAgony.AGONY_RIPPING_FANGS, 0.0F)
/*  560 */           .addNextBehavior(
/*  561 */             CECombatBehaviors.Behavior.builder()
/*  562 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  563 */             .withinDistance(0.0D, 6.0D)
/*  564 */             .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/*  565 */             .addNextBehavior(
/*  566 */               CECombatBehaviors.Behavior.builder()
/*  567 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  568 */               .withinDistance(0.0D, 6.0D)
/*  569 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  575 */       .addFirstBehavior(
/*  576 */         CECombatBehaviors.Behavior.builder()
/*  577 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  578 */         .withinDistance(0.0D, 5.0D)
/*  579 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  580 */         .addNextBehavior(
/*  581 */           CECombatBehaviors.Behavior.builder()
/*  582 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  583 */           .withinDistance(0.0D, 6.0D)
/*  584 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  585 */           .addNextBehavior(
/*  586 */             CECombatBehaviors.Behavior.builder()
/*  587 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  588 */             .withinDistance(0.0D, 6.0D)
/*  589 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  590 */             .addNextBehavior(
/*  591 */               CECombatBehaviors.Behavior.builder()
/*  592 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  593 */               .withinDistance(0.0D, 7.0D)
/*  594 */               .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  595 */               .addNextBehavior(
/*  596 */                 CECombatBehaviors.Behavior.builder()
/*  597 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  598 */                 .withinDistance(0.0D, 8.0D)
/*  599 */                 .animationBehavior(AVAnimations.ELECTRIC_FIELD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  605 */       .addFirstBehavior(
/*  606 */         CECombatBehaviors.Behavior.builder()
/*  607 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  608 */         .withinDistance(0.0D, 5.0D)
/*  609 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  610 */         .addNextBehavior(
/*  611 */           CECombatBehaviors.Behavior.builder()
/*  612 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  613 */           .withinDistance(0.0D, 6.0D)
/*  614 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  615 */           .addNextBehavior(
/*  616 */             CECombatBehaviors.Behavior.builder()
/*  617 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  618 */             .withinDistance(0.0D, 6.0D)
/*  619 */             .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  620 */             .addNextBehavior(
/*  621 */               CECombatBehaviors.Behavior.builder()
/*  622 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  623 */               .withinDistance(0.0D, 8.0D)
/*  624 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/*  625 */               .addNextBehavior(
/*  626 */                 CECombatBehaviors.Behavior.builder()
/*  627 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  628 */                 .withinDistance(0.0D, 8.0D)
/*  629 */                 .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  635 */       .addFirstBehavior(
/*  636 */         CECombatBehaviors.Behavior.builder()
/*  637 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  638 */         .withinDistance(0.0D, 5.0D)
/*  639 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  640 */         .addNextBehavior(
/*  641 */           CECombatBehaviors.Behavior.builder()
/*  642 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  643 */           .withinDistance(0.0D, 6.0D)
/*  644 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  645 */           .addNextBehavior(
/*  646 */             CECombatBehaviors.Behavior.builder()
/*  647 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  648 */             .withinDistance(0.0D, 8.0D)
/*  649 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  650 */             .addNextBehavior(
/*  651 */               CECombatBehaviors.Behavior.builder()
/*  652 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  653 */               .withinDistance(0.0D, 6.0D)
/*  654 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  655 */               .addNextBehavior(
/*  656 */                 CECombatBehaviors.Behavior.builder()
/*  657 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  658 */                 .withinDistance(0.0D, 8.0D)
/*  659 */                 .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  665 */       .addFirstBehavior(
/*  666 */         CECombatBehaviors.Behavior.builder()
/*  667 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  668 */         .withinDistance(0.0D, 7.0D)
/*  669 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  670 */         .addNextBehavior(
/*  671 */           CECombatBehaviors.Behavior.builder()
/*  672 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  673 */           .withinDistance(0.0D, 8.0D)
/*  674 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/*  675 */           .addNextBehavior(
/*  676 */             CECombatBehaviors.Behavior.builder()
/*  677 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  678 */             .withinDistance(0.0D, 10.0D)
/*  679 */             .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/*  680 */             .addNextBehavior(
/*  681 */               CECombatBehaviors.Behavior.builder()
/*  682 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  683 */               .withinDistance(0.0D, 8.0D)
/*  684 */               .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/*  685 */               .addNextBehavior(
/*  686 */                 CECombatBehaviors.Behavior.builder()
/*  687 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  688 */                 .withinDistance(0.0D, 15.0D)
/*  689 */                 .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  695 */       .addFirstBehavior(
/*  696 */         CECombatBehaviors.Behavior.builder()
/*  697 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  698 */         .withinDistance(0.0D, 6.0D)
/*  699 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/*  700 */         .addNextBehavior(
/*  701 */           CECombatBehaviors.Behavior.builder()
/*  702 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  703 */           .withinDistance(0.0D, 6.0D)
/*  704 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/*  705 */           .addNextBehavior(
/*  706 */             CECombatBehaviors.Behavior.builder()
/*  707 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  708 */             .withinDistance(0.0D, 6.0D)
/*  709 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  710 */             .addNextBehavior(
/*  711 */               CECombatBehaviors.Behavior.builder()
/*  712 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  713 */               .withinDistance(0.0D, 6.0D)
/*  714 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  715 */               .addNextBehavior(
/*  716 */                 CECombatBehaviors.Behavior.builder()
/*  717 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  718 */                 .withinDistance(0.0D, 8.0D)
/*  719 */                 .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  725 */       .addFirstBehavior(
/*  726 */         CECombatBehaviors.Behavior.builder()
/*  727 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  728 */         .withinDistance(0.0D, 5.0D)
/*  729 */         .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/*  730 */         .addNextBehavior(
/*  731 */           CECombatBehaviors.Behavior.builder()
/*  732 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  733 */           .withinDistance(0.0D, 6.0D)
/*  734 */           .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/*  735 */           .addNextBehavior(
/*  736 */             CECombatBehaviors.Behavior.builder()
/*  737 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  738 */             .withinDistance(0.0D, 6.0D)
/*  739 */             .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/*  740 */             .addNextBehavior(
/*  741 */               CECombatBehaviors.Behavior.builder()
/*  742 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  743 */               .withinDistance(0.0D, 8.0D)
/*  744 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  745 */               .addNextBehavior(
/*  746 */                 CECombatBehaviors.Behavior.builder()
/*  747 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  748 */                 .withinDistance(0.0D, 7.0D)
/*  749 */                 .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  755 */       .addFirstBehavior(
/*  756 */         CECombatBehaviors.Behavior.builder()
/*  757 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  758 */         .withinDistance(0.0D, 5.0D)
/*  759 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  760 */         .addNextBehavior(
/*  761 */           CECombatBehaviors.Behavior.builder()
/*  762 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  763 */           .withinDistance(0.0D, 8.0D)
/*  764 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/*  765 */           .addNextBehavior(
/*  766 */             CECombatBehaviors.Behavior.builder()
/*  767 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  768 */             .withinDistance(0.0D, 6.0D)
/*  769 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  770 */             .addNextBehavior(
/*  771 */               CECombatBehaviors.Behavior.builder()
/*  772 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  773 */               .withinDistance(0.0D, 8.0D)
/*  774 */               .animationBehavior(AVAnimations.ELECTRIC_FIELD, 0.0F)
/*  775 */               .addNextBehavior(
/*  776 */                 CECombatBehaviors.Behavior.builder()
/*  777 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  778 */                 .withinDistance(0.0D, 15.0D)
/*  779 */                 .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  785 */       .addFirstBehavior(
/*  786 */         CECombatBehaviors.Behavior.builder()
/*  787 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  788 */         .withinDistance(0.0D, 5.0D)
/*  789 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/*  790 */         .addNextBehavior(
/*  791 */           CECombatBehaviors.Behavior.builder()
/*  792 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  793 */           .withinDistance(0.0D, 7.0D)
/*  794 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  795 */           .addNextBehavior(
/*  796 */             CECombatBehaviors.Behavior.builder()
/*  797 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  798 */             .withinDistance(0.0D, 6.0D)
/*  799 */             .animationBehavior(AnimsAgony.AGONY_RIPPING_FANGS, 0.0F)
/*  800 */             .addNextBehavior(
/*  801 */               CECombatBehaviors.Behavior.builder()
/*  802 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  803 */               .withinDistance(0.0D, 6.0D)
/*  804 */               .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/*  805 */               .addNextBehavior(
/*  806 */                 CECombatBehaviors.Behavior.builder()
/*  807 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  808 */                 .withinDistance(0.0D, 8.0D)
/*  809 */                 .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  815 */       .addFirstBehavior(
/*  816 */         CECombatBehaviors.Behavior.builder()
/*  817 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  818 */         .withinDistance(0.0D, 6.0D)
/*  819 */         .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  820 */         .addNextBehavior(
/*  821 */           CECombatBehaviors.Behavior.builder()
/*  822 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  823 */           .withinDistance(0.0D, 6.0D)
/*  824 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/*  825 */           .addNextBehavior(
/*  826 */             CECombatBehaviors.Behavior.builder()
/*  827 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  828 */             .withinDistance(0.0D, 7.0D)
/*  829 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/*  830 */             .addNextBehavior(
/*  831 */               CECombatBehaviors.Behavior.builder()
/*  832 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  833 */               .withinDistance(0.0D, 7.0D)
/*  834 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/*  835 */               .addNextBehavior(
/*  836 */                 CECombatBehaviors.Behavior.builder()
/*  837 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  838 */                 .withinDistance(0.0D, 8.0D)
/*  839 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  845 */       .addFirstBehavior(
/*  846 */         CECombatBehaviors.Behavior.builder()
/*  847 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  848 */         .withinDistance(0.0D, 6.0D)
/*  849 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/*  850 */         .addNextBehavior(
/*  851 */           CECombatBehaviors.Behavior.builder()
/*  852 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  853 */           .withinDistance(0.0D, 6.0D)
/*  854 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*  855 */           .addNextBehavior(
/*  856 */             CECombatBehaviors.Behavior.builder()
/*  857 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  858 */             .withinDistance(0.0D, 6.0D)
/*  859 */             .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/*  860 */             .addNextBehavior(
/*  861 */               CECombatBehaviors.Behavior.builder()
/*  862 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  863 */               .withinDistance(0.0D, 8.0D)
/*  864 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/*  865 */               .addNextBehavior(
/*  866 */                 CECombatBehaviors.Behavior.builder()
/*  867 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  868 */                 .withinDistance(0.0D, 6.0D)
/*  869 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  875 */       .addFirstBehavior(
/*  876 */         CECombatBehaviors.Behavior.builder()
/*  877 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  878 */         .withinDistance(0.0D, 5.0D)
/*  879 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/*  880 */         .addNextBehavior(
/*  881 */           CECombatBehaviors.Behavior.builder()
/*  882 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  883 */           .withinDistance(0.0D, 6.0D)
/*  884 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/*  885 */           .addNextBehavior(
/*  886 */             CECombatBehaviors.Behavior.builder()
/*  887 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  888 */             .withinDistance(0.0D, 6.0D)
/*  889 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/*  890 */             .addNextBehavior(
/*  891 */               CECombatBehaviors.Behavior.builder()
/*  892 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  893 */               .withinDistance(0.0D, 6.0D)
/*  894 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/*  895 */               .addNextBehavior(
/*  896 */                 CECombatBehaviors.Behavior.builder()
/*  897 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  898 */                 .withinDistance(0.0D, 8.0D)
/*  899 */                 .animationBehavior(AVAnimations.ELECTRIC_FIELD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  905 */       .addFirstBehavior(
/*  906 */         CECombatBehaviors.Behavior.builder()
/*  907 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  908 */         .withinDistance(0.0D, 6.0D)
/*  909 */         .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/*  910 */         .addNextBehavior(
/*  911 */           CECombatBehaviors.Behavior.builder()
/*  912 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  913 */           .withinDistance(0.0D, 8.0D)
/*  914 */           .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F)
/*  915 */           .addNextBehavior(
/*  916 */             CECombatBehaviors.Behavior.builder()
/*  917 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  918 */             .withinDistance(0.0D, 6.0D)
/*  919 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/*  920 */             .addNextBehavior(
/*  921 */               CECombatBehaviors.Behavior.builder()
/*  922 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  923 */               .withinDistance(0.0D, 8.0D)
/*  924 */               .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F)
/*  925 */               .addNextBehavior(
/*  926 */                 CECombatBehaviors.Behavior.builder()
/*  927 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  928 */                 .withinDistance(0.0D, 10.0D)
/*  929 */                 .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  935 */       .addFirstBehavior(
/*  936 */         CECombatBehaviors.Behavior.builder()
/*  937 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  938 */         .withinDistance(0.0D, 6.0D)
/*  939 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/*  940 */         .addNextBehavior(
/*  941 */           CECombatBehaviors.Behavior.builder()
/*  942 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  943 */           .withinDistance(0.0D, 7.0D)
/*  944 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/*  945 */           .addNextBehavior(
/*  946 */             CECombatBehaviors.Behavior.builder()
/*  947 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  948 */             .withinDistance(0.0D, 7.0D)
/*  949 */             .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/*  950 */             .addNextBehavior(
/*  951 */               CECombatBehaviors.Behavior.builder()
/*  952 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  953 */               .withinDistance(0.0D, 6.0D)
/*  954 */               .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/*  955 */               .addNextBehavior(
/*  956 */                 CECombatBehaviors.Behavior.builder()
/*  957 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  958 */                 .withinDistance(0.0D, 15.0D)
/*  959 */                 .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  965 */       .addFirstBehavior(
/*  966 */         CECombatBehaviors.Behavior.builder()
/*  967 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  968 */         .withinDistance(0.0D, 6.0D)
/*  969 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_2, 0.0F)
/*  970 */         .addNextBehavior(
/*  971 */           CECombatBehaviors.Behavior.builder()
/*  972 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  973 */           .withinDistance(0.0D, 6.0D)
/*  974 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/*  975 */           .addNextBehavior(
/*  976 */             CECombatBehaviors.Behavior.builder()
/*  977 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  978 */             .withinDistance(0.0D, 8.0D)
/*  979 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/*  980 */             .addNextBehavior(
/*  981 */               CECombatBehaviors.Behavior.builder()
/*  982 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  983 */               .withinDistance(0.0D, 8.0D)
/*  984 */               .animationBehavior(AVAnimations.ELECTRIC_FIELD, 0.0F)
/*  985 */               .addNextBehavior(
/*  986 */                 CECombatBehaviors.Behavior.builder()
/*  987 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  988 */                 .withinDistance(0.0D, 8.0D)
/*  989 */                 .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  995 */       .addFirstBehavior(
/*  996 */         CECombatBehaviors.Behavior.builder()
/*  997 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  998 */         .withinDistance(0.0D, 6.0D)
/*  999 */         .animationBehavior(AnimsAgony.AGONY_AUTO_3, 0.0F)
/* 1000 */         .addNextBehavior(
/* 1001 */           CECombatBehaviors.Behavior.builder()
/* 1002 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1003 */           .withinDistance(0.0D, 6.0D)
/* 1004 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_2, 0.0F)
/* 1005 */           .addNextBehavior(
/* 1006 */             CECombatBehaviors.Behavior.builder()
/* 1007 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1008 */             .withinDistance(0.0D, 8.0D)
/* 1009 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1010 */             .addNextBehavior(
/* 1011 */               CECombatBehaviors.Behavior.builder()
/* 1012 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1013 */               .withinDistance(0.0D, 8.0D)
/* 1014 */               .animationBehavior(WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F)
/* 1015 */               .addNextBehavior(
/* 1016 */                 CECombatBehaviors.Behavior.builder()
/* 1017 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1018 */                 .withinDistance(0.0D, 15.0D)
/* 1019 */                 .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1025 */       .addFirstBehavior(
/* 1026 */         CECombatBehaviors.Behavior.builder()
/* 1027 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1028 */         .withinDistance(0.0D, 5.0D)
/* 1029 */         .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 1030 */         .addNextBehavior(
/* 1031 */           CECombatBehaviors.Behavior.builder()
/* 1032 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1033 */           .withinDistance(0.0D, 6.0D)
/* 1034 */           .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 1035 */           .addNextBehavior(
/* 1036 */             CECombatBehaviors.Behavior.builder()
/* 1037 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1038 */             .withinDistance(0.0D, 6.0D)
/* 1039 */             .animationBehavior(WOMAnimations.TORMENT_AUTO_2, 0.0F)
/* 1040 */             .addNextBehavior(
/* 1041 */               CECombatBehaviors.Behavior.builder()
/* 1042 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1043 */               .withinDistance(0.0D, 6.0D)
/* 1044 */               .animationBehavior(WOMAnimations.TORMENT_AUTO_3, 0.0F)
/* 1045 */               .addNextBehavior(
/* 1046 */                 CECombatBehaviors.Behavior.builder()
/* 1047 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1048 */                 .withinDistance(0.0D, 8.0D)
/* 1049 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1055 */       .addFirstBehavior(
/* 1056 */         CECombatBehaviors.Behavior.builder()
/* 1057 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1058 */         .withinDistance(0.0D, 7.0D)
/* 1059 */         .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/* 1060 */         .addNextBehavior(
/* 1061 */           CECombatBehaviors.Behavior.builder()
/* 1062 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1063 */           .withinDistance(0.0D, 7.0D)
/* 1064 */           .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/* 1065 */           .addNextBehavior(
/* 1066 */             CECombatBehaviors.Behavior.builder()
/* 1067 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1068 */             .withinDistance(0.0D, 15.0D)
/* 1069 */             .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/* 1070 */             .addNextBehavior(
/* 1071 */               CECombatBehaviors.Behavior.builder()
/* 1072 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1073 */               .withinDistance(0.0D, 8.0D)
/* 1074 */               .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1075 */               .addNextBehavior(
/* 1076 */                 CECombatBehaviors.Behavior.builder()
/* 1077 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1078 */                 .withinDistance(0.0D, 6.0D)
/* 1079 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1085 */       .addFirstBehavior(
/* 1086 */         CECombatBehaviors.Behavior.builder()
/* 1087 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1088 */         .withinDistance(0.0D, 5.0D)
/* 1089 */         .animationBehavior(Animations.GREATSWORD_AUTO2, 0.0F)
/* 1090 */         .addNextBehavior(
/* 1091 */           CECombatBehaviors.Behavior.builder()
/* 1092 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1093 */           .withinDistance(0.0D, 6.0D)
/* 1094 */           .animationBehavior(Animations.GREATSWORD_AUTO1, 0.0F)
/* 1095 */           .addNextBehavior(
/* 1096 */             CECombatBehaviors.Behavior.builder()
/* 1097 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1098 */             .withinDistance(0.0D, 6.0D)
/* 1099 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/* 1100 */             .addNextBehavior(
/* 1101 */               CECombatBehaviors.Behavior.builder()
/* 1102 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1103 */               .withinDistance(0.0D, 6.0D)
/* 1104 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 1105 */               .addNextBehavior(
/* 1106 */                 CECombatBehaviors.Behavior.builder()
/* 1107 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1108 */                 .withinDistance(0.0D, 6.0D)
/* 1109 */                 .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1115 */       .addFirstBehavior(
/* 1116 */         CECombatBehaviors.Behavior.builder()
/* 1117 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1118 */         .withinDistance(0.0D, 5.0D)
/* 1119 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_1, 0.0F)
/* 1120 */         .addNextBehavior(
/* 1121 */           CECombatBehaviors.Behavior.builder()
/* 1122 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1123 */           .withinDistance(0.0D, 6.0D)
/* 1124 */           .animationBehavior(AnimsSolar.SOLAR_AUTO_1, 0.0F)
/* 1125 */           .addNextBehavior(
/* 1126 */             CECombatBehaviors.Behavior.builder()
/* 1127 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1128 */             .withinDistance(0.0D, 6.0D)
/* 1129 */             .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/* 1130 */             .addNextBehavior(
/* 1131 */               CECombatBehaviors.Behavior.builder()
/* 1132 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1133 */               .withinDistance(0.0D, 7.0D)
/* 1134 */               .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/* 1135 */               .addNextBehavior(
/* 1136 */                 CECombatBehaviors.Behavior.builder()
/* 1137 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1138 */                 .withinDistance(0.0D, 8.0D)
/* 1139 */                 .animationBehavior(AVAnimations.ELECTRIC_FIELD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1145 */       .addFirstBehavior(
/* 1146 */         CECombatBehaviors.Behavior.builder()
/* 1147 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1148 */         .withinDistance(0.0D, 10.0D)
/* 1149 */         .animationBehavior(AVAnimations.CLONE_ENDERBLASTER_ONEHAND_DASH, 0.0F)
/* 1150 */         .addNextBehavior(
/* 1151 */           CECombatBehaviors.Behavior.builder()
/* 1152 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1153 */           .withinDistance(0.0D, 8.0D)
/* 1154 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1155 */           .addNextBehavior(
/* 1156 */             CECombatBehaviors.Behavior.builder()
/* 1157 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1158 */             .withinDistance(0.0D, 8.0D)
/* 1159 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1160 */             .addNextBehavior(
/* 1161 */               CECombatBehaviors.Behavior.builder()
/* 1162 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1163 */               .withinDistance(0.0D, 6.0D)
/* 1164 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_AIRSLAM, 0.0F)
/* 1165 */               .addNextBehavior(
/* 1166 */                 CECombatBehaviors.Behavior.builder()
/* 1167 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1168 */                 .withinDistance(0.0D, 8.0D)
/* 1169 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1175 */       .addFirstBehavior(
/* 1176 */         CECombatBehaviors.Behavior.builder()
/* 1177 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1178 */         .withinDistance(0.0D, 6.0D)
/* 1179 */         .animationBehavior(AnimsSolar.SOLAR_AUTO_4, 0.0F)
/* 1180 */         .addNextBehavior(
/* 1181 */           CECombatBehaviors.Behavior.builder()
/* 1182 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1183 */           .withinDistance(0.0D, 7.0D)
/* 1184 */           .animationBehavior(AVAnimations.LEGENDARY_SWORD_AUTO_4, 0.0F)
/* 1185 */           .addNextBehavior(
/* 1186 */             CECombatBehaviors.Behavior.builder()
/* 1187 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1188 */             .withinDistance(0.0D, 8.0D)
/* 1189 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1190 */             .addNextBehavior(
/* 1191 */               CECombatBehaviors.Behavior.builder()
/* 1192 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1193 */               .withinDistance(0.0D, 8.0D)
/* 1194 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_COMET, 0.0F)
/* 1195 */               .addNextBehavior(
/* 1196 */                 CECombatBehaviors.Behavior.builder()
/* 1197 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1198 */                 .withinDistance(0.0D, 8.0D)
/* 1199 */                 .animationBehavior(AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1205 */       .addFirstBehavior(
/* 1206 */         CECombatBehaviors.Behavior.builder()
/* 1207 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1208 */         .withinDistance(0.0D, 6.0D)
/* 1209 */         .animationBehavior(WOMAnimations.TORMENT_AUTO_4, 0.0F)
/* 1210 */         .addNextBehavior(
/* 1211 */           CECombatBehaviors.Behavior.builder()
/* 1212 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1213 */           .withinDistance(0.0D, 6.0D)
/* 1214 */           .animationBehavior(Animations.THE_GUILLOTINE, 0.0F)
/* 1215 */           .addNextBehavior(
/* 1216 */             CECombatBehaviors.Behavior.builder()
/* 1217 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1218 */             .withinDistance(0.0D, 8.0D)
/* 1219 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1220 */             .addNextBehavior(
/* 1221 */               CECombatBehaviors.Behavior.builder()
/* 1222 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1223 */               .withinDistance(0.0D, 7.0D)
/* 1224 */               .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUTO_3, 0.0F)
/* 1225 */               .addNextBehavior(
/* 1226 */                 CECombatBehaviors.Behavior.builder()
/* 1227 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1228 */                 .withinDistance(0.0D, 15.0D)
/* 1229 */                 .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1235 */       .addFirstBehavior(
/* 1236 */         CECombatBehaviors.Behavior.builder()
/* 1237 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1238 */         .withinDistance(0.0D, 5.0D)
/* 1239 */         .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_2, 0.0F)
/* 1240 */         .addNextBehavior(
/* 1241 */           CECombatBehaviors.Behavior.builder()
/* 1242 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1243 */           .withinDistance(0.0D, 6.0D)
/* 1244 */           .animationBehavior(WOMAnimations.TORMENT_AIRSLAM, 0.0F)
/* 1245 */           .addNextBehavior(
/* 1246 */             CECombatBehaviors.Behavior.builder()
/* 1247 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1248 */             .withinDistance(0.0D, 8.0D)
/* 1249 */             .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1250 */             .addNextBehavior(
/* 1251 */               CECombatBehaviors.Behavior.builder()
/* 1252 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1253 */               .withinDistance(0.0D, 8.0D)
/* 1254 */               .animationBehavior(AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW, 0.0F)
/* 1255 */               .addNextBehavior(
/* 1256 */                 CECombatBehaviors.Behavior.builder()
/* 1257 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1258 */                 .withinDistance(0.0D, 8.0D)
/* 1259 */                 .animationBehavior(AVAnimations.ELECTRIC_FIELD, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1265 */       .addFirstBehavior(
/* 1266 */         CECombatBehaviors.Behavior.builder()
/* 1267 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1268 */         .withinDistance(0.0D, 6.0D)
/* 1269 */         .animationBehavior(AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, 0.0F)
/* 1270 */         .addNextBehavior(
/* 1271 */           CECombatBehaviors.Behavior.builder()
/* 1272 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1273 */           .withinDistance(0.0D, 6.0D)
/* 1274 */           .animationBehavior(AnimsRuine.RUINE_CHATIMENT, 0.0F)
/* 1275 */           .addNextBehavior(
/* 1276 */             CECombatBehaviors.Behavior.builder()
/* 1277 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1278 */             .withinDistance(0.0D, 7.0D)
/* 1279 */             .animationBehavior(AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, 0.0F)
/* 1280 */             .addNextBehavior(
/* 1281 */               CECombatBehaviors.Behavior.builder()
/* 1282 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1283 */               .withinDistance(0.0D, 7.0D)
/* 1284 */               .animationBehavior(AVAnimations.YELLOW_SOLAR_AUTO_2, 0.0F)
/* 1285 */               .addNextBehavior(
/* 1286 */                 CECombatBehaviors.Behavior.builder()
/* 1287 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1288 */                 .withinDistance(0.0D, 6.0D)
/* 1289 */                 .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1295 */       .addFirstBehavior(
/* 1296 */         CECombatBehaviors.Behavior.builder()
/* 1297 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1298 */         .withinDistance(0.0D, 6.0D)
/* 1299 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_AUTO_1, 0.0F)
/* 1300 */         .addNextBehavior(
/* 1301 */           CECombatBehaviors.Behavior.builder()
/* 1302 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1303 */           .withinDistance(0.0D, 8.0D)
/* 1304 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1305 */           .addNextBehavior(
/* 1306 */             CECombatBehaviors.Behavior.builder()
/* 1307 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1308 */             .withinDistance(0.0D, 6.0D)
/* 1309 */             .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_1, 0.0F)
/* 1310 */             .addNextBehavior(
/* 1311 */               CECombatBehaviors.Behavior.builder()
/* 1312 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1313 */               .withinDistance(0.0D, 8.0D)
/* 1314 */               .animationBehavior(AVAnimations.DEMONIAC_RUINE_AUTO_4, 0.0F)
/* 1315 */               .addNextBehavior(
/* 1316 */                 CECombatBehaviors.Behavior.builder()
/* 1317 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1318 */                 .withinDistance(0.0D, 15.0D)
/* 1319 */                 .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1327 */     .newBehaviorRoot(
/* 1328 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1329 */       .priority(1.0D)
/* 1330 */       .weight(30.0D)
/* 1331 */       .maxCooldown(40)
/* 1332 */       .addFirstBehavior(
/* 1333 */         CECombatBehaviors.Behavior.builder()
/* 1334 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1335 */         .withinDistance(0.0D, 5.0D)
/* 1336 */         .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1337 */         .addNextBehavior(
/* 1338 */           CECombatBehaviors.Behavior.builder()
/* 1339 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1340 */           .withinDistance(0.0D, 5.0D)
/* 1341 */           .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1342 */           .addNextBehavior(
/* 1343 */             CECombatBehaviors.Behavior.builder()
/* 1344 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1345 */             .withinDistance(0.0D, 5.0D)
/* 1346 */             .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F)
/* 1347 */             .addNextBehavior(
/* 1348 */               CECombatBehaviors.Behavior.builder()
/* 1349 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1350 */               .withinDistance(0.0D, 5.0D)
/* 1351 */               .animationBehavior(WOMAnimations.TORMENT_BERSERK_DASH, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1357 */     .newBehaviorRoot(
/* 1358 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1359 */       .priority(1.0D)
/* 1360 */       .weight(30.0D)
/* 1361 */       .maxCooldown(40)
/* 1362 */       .addFirstBehavior(
/* 1363 */         CECombatBehaviors.Behavior.builder()
/* 1364 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1365 */         .withinDistance(0.0D, 5.0D)
/* 1366 */         .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F)
/* 1367 */         .addNextBehavior(
/* 1368 */           CECombatBehaviors.Behavior.builder()
/* 1369 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1370 */           .withinDistance(0.0D, 5.0D)
/* 1371 */           .animationBehavior(WOMAnimations.TORMENT_DASH, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/* 1375 */     .newBehaviorRoot(
/* 1376 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1377 */       .priority(1.0D)
/* 1378 */       .weight(30.0D)
/* 1379 */       .maxCooldown(40)
/* 1380 */       .addFirstBehavior(
/* 1381 */         CECombatBehaviors.Behavior.builder()
/* 1382 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1383 */         .withinDistance(0.0D, 5.0D)
/* 1384 */         .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F)
/* 1385 */         .addNextBehavior(
/* 1386 */           CECombatBehaviors.Behavior.builder()
/* 1387 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1388 */           .withinDistance(0.0D, 5.0D)
/* 1389 */           .animationBehavior(AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, 0.0F))))
/*      */ 
/*      */ 
/*      */     
/* 1393 */     .newBehaviorRoot(
/* 1394 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1395 */       .priority(1.0D)
/* 1396 */       .weight(30.0D)
/* 1397 */       .maxCooldown(100)
/* 1398 */       .addFirstBehavior(
/* 1399 */         CECombatBehaviors.Behavior.builder()
/* 1400 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1401 */         .withinDistance(0.0D, 5.0D)
/* 1402 */         .animationBehavior(AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F)
/* 1403 */         .addExBehavior(BlueDemonLegendarySword::legendarySwordSpecialAttack)))
/*      */ 
/*      */     
/* 1406 */     .newBehaviorRoot(
/* 1407 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1408 */       .priority(1.0D)
/* 1409 */       .weight(20.0D)
/* 1410 */       .maxCooldown(200)
/* 1411 */       .addFirstBehavior(
/* 1412 */         CECombatBehaviors.Behavior.builder()
/* 1413 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1414 */         .withinDistance(0.0D, 5.0D)
/* 1415 */         .animationBehavior(AnimsAgony.AGONY_RISING_EAGLE, 0.0F)
/* 1416 */         .addExBehavior(BlueDemonLegendarySword::legendarySwordHeavyAttack)))
/*      */ 
/*      */     
/* 1419 */     .newBehaviorRoot(
/* 1420 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1421 */       .priority(1.0D)
/* 1422 */       .weight(10.0D)
/* 1423 */       .maxCooldown(400)
/* 1424 */       .addFirstBehavior(
/* 1425 */         CECombatBehaviors.Behavior.builder()
/* 1426 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1427 */         .withinDistance(5.0D, 10.0D)
/* 1428 */         .animationBehavior(AVAnimations.ELECTRIC_FIELD, 0.0F)))
/*      */ 
/*      */     
/* 1431 */     .newBehaviorRoot(
/* 1432 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1433 */       .priority(1.0D)
/* 1434 */       .weight(15.0D)
/* 1435 */       .addFirstBehavior(
/* 1436 */         CECombatBehaviors.Behavior.builder()
/* 1437 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1438 */         .withinDistance(0.0D, 3.0D)
/* 1439 */         .custom(CombatCommon::canPerformGuarding)
/* 1440 */         .guard(40)))
/*      */ 
/*      */     
/* 1443 */     .newBehaviorRoot(
/* 1444 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1445 */       .priority(1.0D)
/* 1446 */       .weight(10.0D)
/* 1447 */       .addFirstBehavior(
/* 1448 */         CECombatBehaviors.Behavior.builder()
/* 1449 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1450 */         .withinDistance(0.0D, 3.0D)
/* 1451 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/* 1453 */       .addFirstBehavior(
/* 1454 */         CECombatBehaviors.Behavior.builder()
/* 1455 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1456 */         .withinDistance(0.0D, 3.0D)
/* 1457 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/* 1459 */       .addFirstBehavior(
/* 1460 */         CECombatBehaviors.Behavior.builder()
/* 1461 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1462 */         .withinDistance(0.0D, 3.0D)
/* 1463 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/* 1465 */       .addFirstBehavior(
/* 1466 */         CECombatBehaviors.Behavior.builder()
/* 1467 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1468 */         .withinDistance(0.0D, 3.0D)
/* 1469 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1472 */     .newBehaviorRoot(
/* 1473 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1474 */       .priority(1.0D)
/* 1475 */       .weight(40.0D)
/* 1476 */       .maxCooldown(160)
/* 1477 */       .addFirstBehavior(
/* 1478 */         CECombatBehaviors.Behavior.builder()
/* 1479 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1480 */         .custom(CombatCommon::canJump)
/* 1481 */         .withinDistance(5.0D, 14.0D)
/* 1482 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1483 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\BlueDemonLegendarySword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */