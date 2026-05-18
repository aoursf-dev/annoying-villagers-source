/*     */ package com.pla.annoyingvillagers.task;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.shelmarow.combat_evolution.effect.CEMobEffects;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionHandler;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*     */ import net.shelmarow.combat_evolution.tickTask.TickTask;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class MobExecutionTask extends TickTask {
/*     */   private final LivingEntity executor;
/*     */   private final LivingEntity target;
/*     */   private final ExecutionTypeManager.Type executionType;
/*     */   private boolean cancelled = false;
/*     */   
/*     */   public MobExecutionTask(LivingEntity executor, LivingEntity target, ExecutionTypeManager.Type executionType, int durationTicks) {
/*  28 */     super(durationTicks);
/*  29 */     this.executor = executor;
/*  30 */     this.target = target;
/*  31 */     this.executionType = executionType;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onStart() {
/*  36 */     ExecutionHandler.addExecutingTarget(this.target, this.executor);
/*     */     
/*  38 */     LivingEntityPatch<?> executorPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this.executor, LivingEntityPatch.class);
/*  39 */     LivingEntityPatch<?> targetPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this.target, LivingEntityPatch.class);
/*     */     
/*  41 */     this.executor.m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 100, 1, true, false));
/*  42 */     this.target.m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 100, 1, true, false));
/*  43 */     this.executor.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 100, 4));
/*     */     
/*  45 */     if (executorPatch != null && targetPatch != null) {
/*  46 */       executorPatch.playAnimationSynchronized((AssetAccessor)this.executionType.executionAnimation(), 0.0F);
/*  47 */       targetPatch.playAnimationSynchronized((AssetAccessor)this.executionType.executedAnimation(), 0.0F);
/*     */       
/*  49 */       Vec3 from = this.executor.m_146892_();
/*  50 */       Vec3 to = this.target.m_146892_();
/*  51 */       double dx = to.f_82479_ - from.f_82479_;
/*  52 */       double dz = to.f_82481_ - from.f_82481_;
/*  53 */       float yaw = (float)(Math.toDegrees(Math.atan2(dz, dx)) - 90.0D) + this.executionType.rotationOffset();
/*  54 */       executorPatch.setYRot(yaw);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onTick() {
/*  60 */     if (this.cancelled) {
/*     */       return;
/*     */     }
/*     */     
/*  64 */     if (this.target.m_6084_()) {
/*  65 */       LivingEntityPatch<?> targetPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this.target, LivingEntityPatch.class);
/*     */       
/*  67 */       if (targetPatch == null) {
/*  68 */         cancelExecution(false);
/*     */         
/*     */         return;
/*     */       } 
/*  72 */       if (targetPatch.getAnimator().getPlayerFor(null) == null) {
/*  73 */         cancelExecution(false);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/*  78 */       AssetAccessor<? extends StaticAnimation> targetDynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(targetPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*     */       
/*  80 */       if (!(targetDynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionHitAnimation)) {
/*  81 */         cancelExecution(true);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void cancelExecution(boolean rollExecutorBackward) {
/*  87 */     if (this.cancelled) {
/*     */       return;
/*     */     }
/*  90 */     this.cancelled = true;
/*     */     
/*  92 */     LivingEntityPatch<?> executorPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this.executor, LivingEntityPatch.class);
/*  93 */     LivingEntityPatch<?> targetPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this.target, LivingEntityPatch.class);
/*     */     
/*  95 */     if (executorPatch != null) {
/*  96 */       executorPatch.stopPlaying((AssetAccessor)this.executionType.executionAnimation());
/*     */       
/*  98 */       if (rollExecutorBackward) {
/*  99 */         executorPatch.playAnimationInstantly((AssetAccessor)Animations.BIPED_ROLL_BACKWARD);
/*     */       }
/*     */     } 
/*     */     
/* 103 */     if (targetPatch != null) {
/* 104 */       targetPatch.stopPlaying((AssetAccessor)this.executionType.executedAnimation());
/*     */     }
/*     */     
/* 107 */     onFinish();
/* 108 */     this.tickTimer = this.maxTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onFinish() {
/* 113 */     ExecutionHandler.removeExecutingTarget(this.target);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\task\MobExecutionTask.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */