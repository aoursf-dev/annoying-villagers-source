/*      */ package com.pla.annoyingvillagers.combatbehaviour;
/*      */ 
/*      */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*      */ import com.pla.annoyingvillagers.entity.SteveEntity;
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.annoyingvillagers.network.ClientboundMuteExplosionAtPos;
/*      */ import com.pla.annoyingvillagers.network.ClientboundWoopieSwordWindFx;
/*      */ import com.pla.annoyingvillagers.task.DelayedTask;
/*      */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*      */ import com.pla.efkick.gameasset.EFKickAnimations;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.core.Position;
/*      */ import net.minecraft.world.effect.MobEffect;
/*      */ import net.minecraft.world.effect.MobEffectInstance;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import net.minecraftforge.network.PacketDistributor;
/*      */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*      */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsHerrscher;
/*      */ import reascer.wom.gameasset.animations.weapons.AnimsSatsujin;
/*      */ import yesman.epicfight.api.utils.math.Vec3f;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.gameasset.Armatures;
/*      */ import yesman.epicfight.model.armature.HumanoidArmature;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*      */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SteveWoopieSword
/*      */ {
/*      */   static void woopieWindup(MobPatch<?> mobpatch) {
/*   36 */     final SteveEntity steveEntity = (SteveEntity)mobpatch.getOriginal();
/*   37 */     ItemStack itemStack = steveEntity.m_21205_();
/*   38 */     steveEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/*   39 */     if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.WoopieTheSwordItem && steveEntity.m_9236_() instanceof net.minecraft.server.level.ServerLevel) {
/*   40 */       new DelayedTask(10)
/*      */         {
/*      */           public void run() {
/*   43 */             Vec3 windPos = EpicfightUtil.getJointWithTranslation((Entity)steveEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED
/*      */ 
/*      */                 
/*   46 */                 .get()).toolR, 5.3F, 0.5D);
/*      */ 
/*      */ 
/*      */             
/*   50 */             if (windPos != null) {
/*   51 */               BlockPos mutePos = BlockPos.m_274446_((Position)windPos);
/*   52 */               AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/*   53 */                   .with(() -> steveEntity), new ClientboundMuteExplosionAtPos(mutePos, 4));
/*      */ 
/*      */               
/*   56 */               steveEntity.m_9236_().m_255391_((Entity)steveEntity, windPos.f_82479_, windPos.f_82480_, windPos.f_82481_, 2.0F, false, Level.ExplosionInteraction.NONE);
/*      */               
/*   58 */               AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/*   59 */                   .with(() -> steveEntity), new ClientboundWoopieSwordWindFx(windPos));
/*      */             } 
/*      */           }
/*      */         };
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*   68 */   public static final CECombatBehaviors.Builder<MobPatch<?>> WOOPIE_THE_SWORD = CECombatBehaviors.builder()
/*   69 */     .newBehaviorRoot(
/*   70 */       CECombatBehaviors.BehaviorRoot.builder()
/*   71 */       .priority(5.0D)
/*   72 */       .weight(1000.0D)
/*   73 */       .maxCooldown(0)
/*   74 */       .addFirstBehavior(
/*   75 */         CECombatBehaviors.Behavior.builder()
/*   76 */         .custom(CombatCommon::canExecute)
/*   77 */         .withinDistance(0.0D, 5.0D)
/*   78 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*   79 */         .addExBehavior(CombatCommon::performExecute)))
/*      */ 
/*      */     
/*   82 */     .newBehaviorRoot(
/*   83 */       CECombatBehaviors.BehaviorRoot.builder()
/*   84 */       .priority(4.0D)
/*   85 */       .weight(1000.0D)
/*   86 */       .maxCooldown(0)
/*   87 */       .addFirstBehavior(
/*   88 */         CECombatBehaviors.Behavior.builder()
/*   89 */         .custom(CombatCommon::canEscape)
/*   90 */         .withinDistance(0.0D, 8.0D)
/*   91 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*   92 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*      */       
/*   94 */       .addFirstBehavior(
/*   95 */         CECombatBehaviors.Behavior.builder()
/*   96 */         .custom(CombatCommon::canEscape)
/*   97 */         .withinDistance(0.0D, 48.0D)
/*   98 */         .guard(40)))
/*      */ 
/*      */     
/*  101 */     .newBehaviorRoot(
/*  102 */       CECombatBehaviors.BehaviorRoot.builder()
/*  103 */       .priority(3.0D)
/*  104 */       .weight(100.0D)
/*  105 */       .maxCooldown(120)
/*  106 */       .addFirstBehavior(
/*  107 */         CECombatBehaviors.Behavior.builder()
/*  108 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  109 */         .custom(CombatCommon::canSwitchWeapon)
/*  110 */         .withinDistance(1.0D, 14.0D)
/*  111 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  112 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  114 */       .addFirstBehavior(
/*  115 */         CECombatBehaviors.Behavior.builder()
/*  116 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  117 */         .custom(CombatCommon::canSwitchWeapon)
/*  118 */         .withinDistance(1.0D, 14.0D)
/*  119 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  120 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  122 */       .addFirstBehavior(
/*  123 */         CECombatBehaviors.Behavior.builder()
/*  124 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  125 */         .custom(CombatCommon::canSwitchWeapon)
/*  126 */         .withinDistance(1.0D, 14.0D)
/*  127 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  128 */         .addExBehavior(CombatCommon::switchWeapon))
/*      */       
/*  130 */       .addFirstBehavior(
/*  131 */         CECombatBehaviors.Behavior.builder()
/*  132 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  133 */         .custom(CombatCommon::canSwitchWeapon)
/*  134 */         .withinDistance(1.0D, 14.0D)
/*  135 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  136 */         .addExBehavior(CombatCommon::switchWeapon)))
/*      */ 
/*      */     
/*  139 */     .newBehaviorRoot(
/*  140 */       CECombatBehaviors.BehaviorRoot.builder()
/*  141 */       .priority(2.0D)
/*  142 */       .weight(70.0D)
/*  143 */       .maxCooldown(0)
/*  144 */       .addFirstBehavior(
/*  145 */         CECombatBehaviors.Behavior.builder()
/*  146 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  147 */         .custom(CombatCommon::canPerformEating)
/*  148 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  149 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*      */ 
/*      */     
/*  152 */     .newBehaviorRoot(
/*  153 */       CECombatBehaviors.BehaviorRoot.builder()
/*  154 */       .priority(2.0D)
/*  155 */       .weight(100.0D)
/*  156 */       .maxCooldown(120)
/*  157 */       .addFirstBehavior(
/*  158 */         CECombatBehaviors.Behavior.builder()
/*  159 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  160 */         .custom(CombatCommon::canSwapToBow)
/*  161 */         .withinDistance(7.0D, 14.0D)
/*  162 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  163 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  165 */       .addFirstBehavior(
/*  166 */         CECombatBehaviors.Behavior.builder()
/*  167 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  168 */         .custom(CombatCommon::canSwapToBow)
/*  169 */         .withinDistance(7.0D, 14.0D)
/*  170 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  171 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  173 */       .addFirstBehavior(
/*  174 */         CECombatBehaviors.Behavior.builder()
/*  175 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  176 */         .custom(CombatCommon::canSwapToBow)
/*  177 */         .withinDistance(7.0D, 14.0D)
/*  178 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  179 */         .addExBehavior(CombatCommon::swapToBow))
/*      */       
/*  181 */       .addFirstBehavior(
/*  182 */         CECombatBehaviors.Behavior.builder()
/*  183 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  184 */         .custom(CombatCommon::canSwapToBow)
/*  185 */         .withinDistance(7.0D, 14.0D)
/*  186 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  187 */         .addExBehavior(CombatCommon::swapToBow)))
/*      */ 
/*      */     
/*  190 */     .newBehaviorRoot(
/*  191 */       CECombatBehaviors.BehaviorRoot.builder()
/*  192 */       .priority(2.0D)
/*  193 */       .weight(80.0D)
/*  194 */       .maxCooldown(120)
/*  195 */       .addFirstBehavior(
/*  196 */         CECombatBehaviors.Behavior.builder()
/*  197 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  198 */         .custom(CombatCommon::canThrowEnderPearl)
/*  199 */         .withinDistance(7.0D, 48.0D)
/*  200 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  201 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*      */ 
/*      */     
/*  204 */     .newBehaviorRoot(
/*  205 */       CECombatBehaviors.BehaviorRoot.builder()
/*  206 */       .priority(1.0D)
/*  207 */       .weight(40.0D)
/*  208 */       .maxCooldown(20)
/*  209 */       .addFirstBehavior(
/*  210 */         CECombatBehaviors.Behavior.builder()
/*  211 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  212 */         .withinDistance(0.0D, 3.0D)
/*  213 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  214 */         .addNextBehavior(
/*  215 */           CECombatBehaviors.Behavior.builder()
/*  216 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  217 */           .withinDistance(0.0D, 3.0D)
/*  218 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  219 */           .addNextBehavior(
/*  220 */             CECombatBehaviors.Behavior.builder()
/*  221 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  222 */             .withinDistance(0.0D, 3.0D)
/*  223 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  224 */             .addNextBehavior(
/*  225 */               CECombatBehaviors.Behavior.builder()
/*  226 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  227 */               .withinDistance(0.0D, 3.0D)
/*  228 */               .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F).addNextBehavior(
/*  229 */                 CECombatBehaviors.Behavior.builder()
/*  230 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  231 */                 .withinDistance(0.0D, 3.0D)
/*  232 */                 .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_2, 0.0F))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  238 */       .addFirstBehavior(
/*  239 */         CECombatBehaviors.Behavior.builder()
/*  240 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  241 */         .withinDistance(0.0D, 3.0D)
/*  242 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  243 */         .addNextBehavior(
/*  244 */           CECombatBehaviors.Behavior.builder()
/*  245 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  246 */           .withinDistance(0.0D, 3.0D)
/*  247 */           .animationBehavior(AVAnimations.RUSH_SWORD, 0.0F)
/*  248 */           .addNextBehavior(
/*  249 */             CECombatBehaviors.Behavior.builder()
/*  250 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  251 */             .withinDistance(0.0D, 4.0D)
/*  252 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  253 */             .addNextBehavior(
/*  254 */               CECombatBehaviors.Behavior.builder()
/*  255 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  256 */               .withinDistance(0.0D, 4.0D)
/*  257 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  258 */               .addNextBehavior(
/*  259 */                 CECombatBehaviors.Behavior.builder()
/*  260 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  261 */                 .withinDistance(0.0D, 5.0D)
/*  262 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  263 */                 .addNextBehavior(
/*  264 */                   CECombatBehaviors.Behavior.builder()
/*  265 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  266 */                   .withinDistance(0.0D, 5.0D)
/*  267 */                   .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  268 */                   .addNextBehavior(
/*  269 */                     CECombatBehaviors.Behavior.builder()
/*  270 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  271 */                     .withinDistance(0.0D, 5.0D)
/*  272 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
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
/*  284 */         .withinDistance(0.0D, 3.0D)
/*  285 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  286 */         .addNextBehavior(
/*  287 */           CECombatBehaviors.Behavior.builder()
/*  288 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  289 */           .withinDistance(0.0D, 3.0D)
/*  290 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  291 */           .addNextBehavior(
/*  292 */             CECombatBehaviors.Behavior.builder()
/*  293 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  294 */             .withinDistance(0.0D, 4.0D)
/*  295 */             .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/*  296 */             .addNextBehavior(
/*  297 */               CECombatBehaviors.Behavior.builder()
/*  298 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  299 */               .withinDistance(0.0D, 4.0D)
/*  300 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  301 */               .addNextBehavior(
/*  302 */                 CECombatBehaviors.Behavior.builder()
/*  303 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  304 */                 .withinDistance(0.0D, 5.0D)
/*  305 */                 .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  306 */                 .addNextBehavior(
/*  307 */                   CECombatBehaviors.Behavior.builder()
/*  308 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  309 */                   .withinDistance(0.0D, 5.0D)
/*  310 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  318 */       .addFirstBehavior(
/*  319 */         CECombatBehaviors.Behavior.builder()
/*  320 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  321 */         .withinDistance(0.0D, 3.0D)
/*  322 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  323 */         .addNextBehavior(
/*  324 */           CECombatBehaviors.Behavior.builder()
/*  325 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  326 */           .withinDistance(0.0D, 3.0D)
/*  327 */           .animationBehavior(AVAnimations.RUSH_SWORD, 0.0F)
/*  328 */           .addNextBehavior(
/*  329 */             CECombatBehaviors.Behavior.builder()
/*  330 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  331 */             .withinDistance(0.0D, 4.0D)
/*  332 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  333 */             .addNextBehavior(
/*  334 */               CECombatBehaviors.Behavior.builder()
/*  335 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  336 */               .withinDistance(0.0D, 4.0D)
/*  337 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  338 */               .addNextBehavior(
/*  339 */                 CECombatBehaviors.Behavior.builder()
/*  340 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  341 */                 .withinDistance(0.0D, 5.0D)
/*  342 */                 .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  343 */                 .addNextBehavior(
/*  344 */                   CECombatBehaviors.Behavior.builder()
/*  345 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  346 */                   .withinDistance(0.0D, 5.0D)
/*  347 */                   .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  348 */                   .addNextBehavior(
/*  349 */                     CECombatBehaviors.Behavior.builder()
/*  350 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  351 */                     .withinDistance(0.0D, 5.0D)
/*  352 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  361 */       .addFirstBehavior(
/*  362 */         CECombatBehaviors.Behavior.builder()
/*  363 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  364 */         .withinDistance(0.0D, 3.0D)
/*  365 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  366 */         .addNextBehavior(
/*  367 */           CECombatBehaviors.Behavior.builder()
/*  368 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  369 */           .withinDistance(0.0D, 3.0D)
/*  370 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/*  371 */           .addNextBehavior(
/*  372 */             CECombatBehaviors.Behavior.builder()
/*  373 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  374 */             .withinDistance(0.0D, 4.0D)
/*  375 */             .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  376 */             .addNextBehavior(
/*  377 */               CECombatBehaviors.Behavior.builder()
/*  378 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  379 */               .withinDistance(0.0D, 4.0D)
/*  380 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  381 */               .addNextBehavior(
/*  382 */                 CECombatBehaviors.Behavior.builder()
/*  383 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  384 */                 .withinDistance(0.0D, 5.0D)
/*  385 */                 .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  386 */                 .addNextBehavior(
/*  387 */                   CECombatBehaviors.Behavior.builder()
/*  388 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  389 */                   .withinDistance(0.0D, 5.0D)
/*  390 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  398 */       .addFirstBehavior(
/*  399 */         CECombatBehaviors.Behavior.builder()
/*  400 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  401 */         .withinDistance(0.0D, 3.0D)
/*  402 */         .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  403 */         .addNextBehavior(
/*  404 */           CECombatBehaviors.Behavior.builder()
/*  405 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  406 */           .withinDistance(0.0D, 3.0D)
/*  407 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  408 */           .addNextBehavior(
/*  409 */             CECombatBehaviors.Behavior.builder()
/*  410 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  411 */             .withinDistance(0.0D, 4.0D)
/*  412 */             .animationBehavior(AnimsSatsujin.SATSUJIN_TSUKUYOMI, 0.0F)
/*  413 */             .addNextBehavior(
/*  414 */               CECombatBehaviors.Behavior.builder()
/*  415 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  416 */               .withinDistance(0.0D, 4.0D)
/*  417 */               .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_2, 0.0F)
/*  418 */               .addNextBehavior(
/*  419 */                 CECombatBehaviors.Behavior.builder()
/*  420 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  421 */                 .withinDistance(0.0D, 5.0D)
/*  422 */                 .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  423 */                 .addNextBehavior(
/*  424 */                   CECombatBehaviors.Behavior.builder()
/*  425 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  426 */                   .withinDistance(0.0D, 5.0D)
/*  427 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  435 */       .addFirstBehavior(
/*  436 */         CECombatBehaviors.Behavior.builder()
/*  437 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  438 */         .withinDistance(0.0D, 3.0D)
/*  439 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  440 */         .addNextBehavior(
/*  441 */           CECombatBehaviors.Behavior.builder()
/*  442 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  443 */           .withinDistance(0.0D, 3.0D)
/*  444 */           .animationBehavior(AnimsSatsujin.SATSUJIN_TSUKUYOMI, 0.0F)
/*  445 */           .addNextBehavior(
/*  446 */             CECombatBehaviors.Behavior.builder()
/*  447 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  448 */             .withinDistance(0.0D, 4.0D)
/*  449 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  450 */             .addNextBehavior(
/*  451 */               CECombatBehaviors.Behavior.builder()
/*  452 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  453 */               .withinDistance(0.0D, 4.0D)
/*  454 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  455 */               .addNextBehavior(
/*  456 */                 CECombatBehaviors.Behavior.builder()
/*  457 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  458 */                 .withinDistance(0.0D, 5.0D)
/*  459 */                 .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  460 */                 .addNextBehavior(
/*  461 */                   CECombatBehaviors.Behavior.builder()
/*  462 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  463 */                   .withinDistance(0.0D, 5.0D)
/*  464 */                   .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  465 */                   .addNextBehavior(
/*  466 */                     CECombatBehaviors.Behavior.builder()
/*  467 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  468 */                     .withinDistance(0.0D, 5.0D)
/*  469 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  478 */       .addFirstBehavior(
/*  479 */         CECombatBehaviors.Behavior.builder()
/*  480 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  481 */         .withinDistance(0.0D, 3.0D)
/*  482 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  483 */         .addNextBehavior(
/*  484 */           CECombatBehaviors.Behavior.builder()
/*  485 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  486 */           .withinDistance(0.0D, 3.0D)
/*  487 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/*  488 */           .addNextBehavior(
/*  489 */             CECombatBehaviors.Behavior.builder()
/*  490 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  491 */             .withinDistance(0.0D, 4.0D)
/*  492 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  493 */             .addNextBehavior(
/*  494 */               CECombatBehaviors.Behavior.builder()
/*  495 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  496 */               .withinDistance(0.0D, 4.0D)
/*  497 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  498 */               .addNextBehavior(
/*  499 */                 CECombatBehaviors.Behavior.builder()
/*  500 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  501 */                 .withinDistance(0.0D, 5.0D)
/*  502 */                 .animationBehavior(EFKickAnimations.KICK_3, 0.0F)
/*  503 */                 .addNextBehavior(
/*  504 */                   CECombatBehaviors.Behavior.builder()
/*  505 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  506 */                   .withinDistance(0.0D, 5.0D)
/*  507 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  515 */       .addFirstBehavior(
/*  516 */         CECombatBehaviors.Behavior.builder()
/*  517 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  518 */         .withinDistance(0.0D, 3.0D)
/*  519 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  520 */         .addNextBehavior(
/*  521 */           CECombatBehaviors.Behavior.builder()
/*  522 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  523 */           .withinDistance(0.0D, 3.0D)
/*  524 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  525 */           .addNextBehavior(
/*  526 */             CECombatBehaviors.Behavior.builder()
/*  527 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  528 */             .withinDistance(0.0D, 4.0D)
/*  529 */             .animationBehavior(AVAnimations.RUSH_SWORD, 0.0F)
/*  530 */             .addNextBehavior(
/*  531 */               CECombatBehaviors.Behavior.builder()
/*  532 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  533 */               .withinDistance(0.0D, 4.0D)
/*  534 */               .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  535 */               .addNextBehavior(
/*  536 */                 CECombatBehaviors.Behavior.builder()
/*  537 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  538 */                 .withinDistance(0.0D, 5.0D)
/*  539 */                 .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  540 */                 .addNextBehavior(
/*  541 */                   CECombatBehaviors.Behavior.builder()
/*  542 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  543 */                   .withinDistance(0.0D, 5.0D)
/*  544 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  545 */                   .addNextBehavior(
/*  546 */                     CECombatBehaviors.Behavior.builder()
/*  547 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  548 */                     .withinDistance(0.0D, 5.0D)
/*  549 */                     .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  558 */       .addFirstBehavior(
/*  559 */         CECombatBehaviors.Behavior.builder()
/*  560 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  561 */         .withinDistance(0.0D, 3.0D)
/*  562 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  563 */         .addNextBehavior(
/*  564 */           CECombatBehaviors.Behavior.builder()
/*  565 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  566 */           .withinDistance(0.0D, 3.0D)
/*  567 */           .animationBehavior(AVAnimations.RUSH_SWORD, 0.0F)
/*  568 */           .addNextBehavior(
/*  569 */             CECombatBehaviors.Behavior.builder()
/*  570 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  571 */             .withinDistance(0.0D, 4.0D)
/*  572 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  573 */             .addNextBehavior(
/*  574 */               CECombatBehaviors.Behavior.builder()
/*  575 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  576 */               .withinDistance(0.0D, 4.0D)
/*  577 */               .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  578 */               .addNextBehavior(
/*  579 */                 CECombatBehaviors.Behavior.builder()
/*  580 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  581 */                 .withinDistance(0.0D, 5.0D)
/*  582 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  583 */                 .addNextBehavior(
/*  584 */                   CECombatBehaviors.Behavior.builder()
/*  585 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  586 */                   .withinDistance(0.0D, 5.0D)
/*  587 */                   .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  595 */       .addFirstBehavior(
/*  596 */         CECombatBehaviors.Behavior.builder()
/*  597 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  598 */         .withinDistance(0.0D, 3.0D)
/*  599 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  600 */         .addNextBehavior(
/*  601 */           CECombatBehaviors.Behavior.builder()
/*  602 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  603 */           .withinDistance(0.0D, 3.0D)
/*  604 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  605 */           .addNextBehavior(
/*  606 */             CECombatBehaviors.Behavior.builder()
/*  607 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  608 */             .withinDistance(0.0D, 4.0D)
/*  609 */             .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  610 */             .addNextBehavior(
/*  611 */               CECombatBehaviors.Behavior.builder()
/*  612 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  613 */               .withinDistance(0.0D, 4.0D)
/*  614 */               .animationBehavior(AnimsSatsujin.SATSUJIN_TSUKUYOMI, 0.0F)
/*  615 */               .addNextBehavior(
/*  616 */                 CECombatBehaviors.Behavior.builder()
/*  617 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  618 */                 .withinDistance(0.0D, 5.0D)
/*  619 */                 .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  620 */                 .addNextBehavior(
/*  621 */                   CECombatBehaviors.Behavior.builder()
/*  622 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  623 */                   .withinDistance(0.0D, 5.0D)
/*  624 */                   .animationBehavior(EFKickAnimations.KICK_4, 0.0F)
/*  625 */                   .addNextBehavior(
/*  626 */                     CECombatBehaviors.Behavior.builder()
/*  627 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  628 */                     .withinDistance(0.0D, 5.0D)
/*  629 */                     .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F))))))))
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
/*  640 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  641 */         .withinDistance(0.0D, 3.0D)
/*  642 */         .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/*  643 */         .addNextBehavior(
/*  644 */           CECombatBehaviors.Behavior.builder()
/*  645 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  646 */           .withinDistance(0.0D, 3.0D)
/*  647 */           .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/*  648 */           .addNextBehavior(
/*  649 */             CECombatBehaviors.Behavior.builder()
/*  650 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  651 */             .withinDistance(0.0D, 4.0D)
/*  652 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  653 */             .addNextBehavior(
/*  654 */               CECombatBehaviors.Behavior.builder()
/*  655 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  656 */               .withinDistance(0.0D, 4.0D)
/*  657 */               .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  658 */               .addNextBehavior(
/*  659 */                 CECombatBehaviors.Behavior.builder()
/*  660 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  661 */                 .withinDistance(0.0D, 5.0D)
/*  662 */                 .animationBehavior(EFKickAnimations.KICK_1, 0.0F)
/*  663 */                 .addNextBehavior(
/*  664 */                   CECombatBehaviors.Behavior.builder()
/*  665 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  666 */                   .withinDistance(0.0D, 5.0D)
/*  667 */                   .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  675 */       .addFirstBehavior(
/*  676 */         CECombatBehaviors.Behavior.builder()
/*  677 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  678 */         .withinDistance(0.0D, 3.0D)
/*  679 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  680 */         .addNextBehavior(
/*  681 */           CECombatBehaviors.Behavior.builder()
/*  682 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  683 */           .withinDistance(0.0D, 3.0D)
/*  684 */           .animationBehavior(AnimsSatsujin.SATSUJIN_TSUKUYOMI, 0.0F)
/*  685 */           .addNextBehavior(
/*  686 */             CECombatBehaviors.Behavior.builder()
/*  687 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  688 */             .withinDistance(0.0D, 4.0D)
/*  689 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  690 */             .addNextBehavior(
/*  691 */               CECombatBehaviors.Behavior.builder()
/*  692 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  693 */               .withinDistance(0.0D, 4.0D)
/*  694 */               .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  695 */               .addNextBehavior(
/*  696 */                 CECombatBehaviors.Behavior.builder()
/*  697 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  698 */                 .withinDistance(0.0D, 5.0D)
/*  699 */                 .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_2, 0.0F)
/*  700 */                 .addNextBehavior(
/*  701 */                   CECombatBehaviors.Behavior.builder()
/*  702 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  703 */                   .withinDistance(0.0D, 5.0D)
/*  704 */                   .animationBehavior(EFKickAnimations.KICK_H, 0.0F)
/*  705 */                   .addNextBehavior(
/*  706 */                     CECombatBehaviors.Behavior.builder()
/*  707 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  708 */                     .withinDistance(0.0D, 5.0D)
/*  709 */                     .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  718 */       .addFirstBehavior(
/*  719 */         CECombatBehaviors.Behavior.builder()
/*  720 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  721 */         .withinDistance(0.0D, 3.0D)
/*  722 */         .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  723 */         .addNextBehavior(
/*  724 */           CECombatBehaviors.Behavior.builder()
/*  725 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  726 */           .withinDistance(0.0D, 3.0D)
/*  727 */           .animationBehavior(AVAnimations.RUSH_SWORD, 0.0F)
/*  728 */           .addNextBehavior(
/*  729 */             CECombatBehaviors.Behavior.builder()
/*  730 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  731 */             .withinDistance(0.0D, 4.0D)
/*  732 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  733 */             .addNextBehavior(
/*  734 */               CECombatBehaviors.Behavior.builder()
/*  735 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  736 */               .withinDistance(0.0D, 4.0D)
/*  737 */               .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_2, 0.0F)
/*  738 */               .addNextBehavior(
/*  739 */                 CECombatBehaviors.Behavior.builder()
/*  740 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  741 */                 .withinDistance(0.0D, 5.0D)
/*  742 */                 .animationBehavior(EFKickAnimations.KICK_2, 0.0F)
/*  743 */                 .addNextBehavior(
/*  744 */                   CECombatBehaviors.Behavior.builder()
/*  745 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  746 */                   .withinDistance(0.0D, 5.0D)
/*  747 */                   .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)))))))
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
/*  759 */         .animationBehavior(Animations.SWORD_AUTO3, 0.0F)
/*  760 */         .addNextBehavior(
/*  761 */           CECombatBehaviors.Behavior.builder()
/*  762 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  763 */           .withinDistance(0.0D, 3.0D)
/*  764 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  765 */           .addNextBehavior(
/*  766 */             CECombatBehaviors.Behavior.builder()
/*  767 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  768 */             .withinDistance(0.0D, 4.0D)
/*  769 */             .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  770 */             .addNextBehavior(
/*  771 */               CECombatBehaviors.Behavior.builder()
/*  772 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  773 */               .withinDistance(0.0D, 4.0D)
/*  774 */               .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F)
/*  775 */               .addNextBehavior(
/*  776 */                 CECombatBehaviors.Behavior.builder()
/*  777 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  778 */                 .withinDistance(0.0D, 5.0D)
/*  779 */                 .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_2, 0.0F)
/*  780 */                 .addNextBehavior(
/*  781 */                   CECombatBehaviors.Behavior.builder()
/*  782 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  783 */                   .withinDistance(0.0D, 5.0D)
/*  784 */                   .animationBehavior(EFKickAnimations.KICK_C, 0.0F)
/*  785 */                   .addNextBehavior(
/*  786 */                     CECombatBehaviors.Behavior.builder()
/*  787 */                     .custom(CombatCommon::canPerformNormalAttackLogic)
/*  788 */                     .withinDistance(0.0D, 5.0D)
/*  789 */                     .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  798 */       .addFirstBehavior(
/*  799 */         CECombatBehaviors.Behavior.builder()
/*  800 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  801 */         .withinDistance(0.0D, 3.0D)
/*  802 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/*  803 */         .addNextBehavior(
/*  804 */           CECombatBehaviors.Behavior.builder()
/*  805 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  806 */           .withinDistance(0.0D, 3.0D)
/*  807 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)
/*  808 */           .addNextBehavior(
/*  809 */             CECombatBehaviors.Behavior.builder()
/*  810 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  811 */             .withinDistance(0.0D, 4.0D)
/*  812 */             .animationBehavior(AVAnimations.RUSH_SWORD, 0.0F)
/*  813 */             .addNextBehavior(
/*  814 */               CECombatBehaviors.Behavior.builder()
/*  815 */               .custom(CombatCommon::canPerformNormalAttackLogic)
/*  816 */               .withinDistance(0.0D, 4.0D)
/*  817 */               .animationBehavior(AnimsSatsujin.SATSUJIN_AUTO_1, 0.0F)
/*  818 */               .addNextBehavior(
/*  819 */                 CECombatBehaviors.Behavior.builder()
/*  820 */                 .custom(CombatCommon::canPerformNormalAttackLogic)
/*  821 */                 .withinDistance(0.0D, 5.0D)
/*  822 */                 .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F)
/*  823 */                 .addNextBehavior(
/*  824 */                   CECombatBehaviors.Behavior.builder()
/*  825 */                   .custom(CombatCommon::canPerformNormalAttackLogic)
/*  826 */                   .withinDistance(0.0D, 5.0D)
/*  827 */                   .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))))))))
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  835 */     .newBehaviorRoot(
/*  836 */       CECombatBehaviors.BehaviorRoot.builder()
/*  837 */       .priority(1.0D)
/*  838 */       .weight(20.0D)
/*  839 */       .maxCooldown(100)
/*  840 */       .addFirstBehavior(
/*  841 */         CECombatBehaviors.Behavior.builder()
/*  842 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  843 */         .withinDistance(0.0D, 3.0D)
/*  844 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/*  845 */         .addNextBehavior(
/*  846 */           CECombatBehaviors.Behavior.builder()
/*  847 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/*  848 */           .withinDistance(0.0D, 3.0D)
/*  849 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/*  850 */           .addNextBehavior(
/*  851 */             CECombatBehaviors.Behavior.builder()
/*  852 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/*  853 */             .withinDistance(0.0D, 3.0D)
/*  854 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  859 */     .newBehaviorRoot(
/*  860 */       CECombatBehaviors.BehaviorRoot.builder()
/*  861 */       .priority(1.0D)
/*  862 */       .weight(40.0D)
/*  863 */       .maxCooldown(20)
/*  864 */       .addFirstBehavior(
/*  865 */         CECombatBehaviors.Behavior.builder()
/*  866 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  867 */         .withinDistance(2.0D, 14.0D)
/*  868 */         .animationBehavior(AVAnimations.RUSH_SWORD, 0.0F)))
/*      */ 
/*      */     
/*  871 */     .newBehaviorRoot(
/*  872 */       CECombatBehaviors.BehaviorRoot.builder()
/*  873 */       .priority(1.0D)
/*  874 */       .weight(30.0D)
/*  875 */       .maxCooldown(20)
/*  876 */       .addFirstBehavior(
/*  877 */         CECombatBehaviors.Behavior.builder()
/*  878 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  879 */         .withinDistance(0.0D, 3.0D)
/*  880 */         .animationBehavior(AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F)
/*  881 */         .addExBehavior(SteveWoopieSword::woopieWindup)))
/*      */ 
/*      */     
/*  884 */     .newBehaviorRoot(
/*  885 */       CECombatBehaviors.BehaviorRoot.builder()
/*  886 */       .priority(1.0D)
/*  887 */       .weight(10.0D)
/*  888 */       .maxCooldown(100)
/*  889 */       .addFirstBehavior(
/*  890 */         CECombatBehaviors.Behavior.builder()
/*  891 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  892 */         .withinDistance(0.0D, 3.0D)
/*  893 */         .animationBehavior(AnimsHerrscher.HERRSCHER_VERDAMMNIS, 0.0F))
/*      */       
/*  895 */       .addFirstBehavior(
/*  896 */         CECombatBehaviors.Behavior.builder()
/*  897 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  898 */         .withinDistance(0.0D, 3.0D)
/*  899 */         .animationBehavior(AnimsSatsujin.SATSUJIN_TSUKUYOMI, 0.0F)))
/*      */ 
/*      */     
/*  902 */     .newBehaviorRoot(
/*  903 */       CECombatBehaviors.BehaviorRoot.builder()
/*  904 */       .priority(1.0D)
/*  905 */       .weight(10.0D)
/*  906 */       .maxCooldown(40)
/*  907 */       .addFirstBehavior(
/*  908 */         CECombatBehaviors.Behavior.builder()
/*  909 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  910 */         .withinDistance(0.0D, 3.0D)
/*  911 */         .custom(CombatCommon::canThrowEnderPearl)
/*  912 */         .custom(CombatCommon::canAttackWhileNotHealing)
/*  913 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/*  914 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*      */ 
/*      */     
/*  917 */     .newBehaviorRoot(
/*  918 */       CECombatBehaviors.BehaviorRoot.builder()
/*  919 */       .priority(1.0D)
/*  920 */       .weight(2.0D)
/*  921 */       .maxCooldown(100)
/*  922 */       .addFirstBehavior(
/*  923 */         CECombatBehaviors.Behavior.builder()
/*  924 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  925 */         .withinDistance(0.0D, 3.0D)
/*  926 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*      */       
/*  928 */       .addFirstBehavior(
/*  929 */         CECombatBehaviors.Behavior.builder()
/*  930 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  931 */         .withinDistance(0.0D, 3.0D)
/*  932 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*      */       
/*  934 */       .addFirstBehavior(
/*  935 */         CECombatBehaviors.Behavior.builder()
/*  936 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  937 */         .withinDistance(0.0D, 3.0D)
/*  938 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*      */       
/*  940 */       .addFirstBehavior(
/*  941 */         CECombatBehaviors.Behavior.builder()
/*  942 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  943 */         .withinDistance(0.0D, 3.0D)
/*  944 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*      */       
/*  946 */       .addFirstBehavior(
/*  947 */         CECombatBehaviors.Behavior.builder()
/*  948 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  949 */         .withinDistance(0.0D, 3.0D)
/*  950 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*      */       
/*  952 */       .addFirstBehavior(
/*  953 */         CECombatBehaviors.Behavior.builder()
/*  954 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  955 */         .withinDistance(0.0D, 3.0D)
/*  956 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*      */       
/*  958 */       .addFirstBehavior(
/*  959 */         CECombatBehaviors.Behavior.builder()
/*  960 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  961 */         .withinDistance(0.0D, 3.0D)
/*  962 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*      */ 
/*      */     
/*  965 */     .newBehaviorRoot(
/*  966 */       CECombatBehaviors.BehaviorRoot.builder()
/*  967 */       .priority(1.0D)
/*  968 */       .weight(15.0D)
/*  969 */       .addFirstBehavior(
/*  970 */         CECombatBehaviors.Behavior.builder()
/*  971 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  972 */         .withinDistance(0.0D, 3.0D)
/*  973 */         .custom(CombatCommon::canPerformGuarding)
/*  974 */         .guard(40)))
/*      */ 
/*      */     
/*  977 */     .newBehaviorRoot(
/*  978 */       CECombatBehaviors.BehaviorRoot.builder()
/*  979 */       .priority(1.0D)
/*  980 */       .weight(10.0D)
/*  981 */       .addFirstBehavior(
/*  982 */         CECombatBehaviors.Behavior.builder()
/*  983 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  984 */         .withinDistance(0.0D, 3.0D)
/*  985 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*      */       
/*  987 */       .addFirstBehavior(
/*  988 */         CECombatBehaviors.Behavior.builder()
/*  989 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  990 */         .withinDistance(0.0D, 3.0D)
/*  991 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*      */       
/*  993 */       .addFirstBehavior(
/*  994 */         CECombatBehaviors.Behavior.builder()
/*  995 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  996 */         .withinDistance(0.0D, 3.0D)
/*  997 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*      */       
/*  999 */       .addFirstBehavior(
/* 1000 */         CECombatBehaviors.Behavior.builder()
/* 1001 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1002 */         .withinDistance(0.0D, 3.0D)
/* 1003 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*      */ 
/*      */     
/* 1006 */     .newBehaviorRoot(
/* 1007 */       CECombatBehaviors.BehaviorRoot.builder()
/* 1008 */       .priority(1.0D)
/* 1009 */       .weight(40.0D)
/* 1010 */       .maxCooldown(160)
/* 1011 */       .addFirstBehavior(
/* 1012 */         CECombatBehaviors.Behavior.builder()
/* 1013 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 1014 */         .custom(CombatCommon::canJump)
/* 1015 */         .withinDistance(5.0D, 14.0D)
/* 1016 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 1017 */         .addExBehavior(CombatCommon::jump)));
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveWoopieSword.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */