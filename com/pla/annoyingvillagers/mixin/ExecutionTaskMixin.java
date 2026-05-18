/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.shelmarow.combat_evolution.execution.ExecutionHandler;
/*    */ import net.shelmarow.combat_evolution.execution.ExecutionTask;
/*    */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*    */ import net.shelmarow.combat_evolution.tickTask.TickTask;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.gameasset.Animations;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ 
/*    */ @Mixin(value = {ExecutionTask.class}, remap = false)
/*    */ public abstract class ExecutionTaskMixin
/*    */   extends TickTask
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private LivingEntity executor;
/*    */   @Shadow
/*    */   @Final
/*    */   private LivingEntity target;
/*    */   
/*    */   protected ExecutionTaskMixin(int durationTicks) {
/* 37 */     super(durationTicks); } @Shadow
/*    */   @Final
/*    */   private ExecutionTypeManager.Type executionType; @Unique
/*    */   private boolean cancelled; @Shadow
/*    */   public abstract void onFinish(); @Inject(method = {"onTick"}, at = {@At("HEAD")}, cancellable = true, remap = false)
/* 42 */   private void onTick(CallbackInfo ci) { if (this.cancelled) {
/* 43 */       ci.cancel();
/*    */       
/*    */       return;
/*    */     } 
/* 47 */     if (this.target.m_6084_()) {
/*    */       
/* 49 */       LivingEntityPatch<?> targetPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this.target, LivingEntityPatch.class);
/* 50 */       if (targetPatch == null) {
/* 51 */         annoyingVillagers$cancelExecution(false);
/* 52 */         ci.cancel();
/*    */         return;
/*    */       } 
/* 55 */       if (targetPatch.getAnimator().getPlayerFor(null) == null) {
/* 56 */         annoyingVillagers$cancelExecution(false);
/* 57 */         ci.cancel();
/*    */         
/*    */         return;
/*    */       } 
/*    */       
/* 62 */       AssetAccessor<? extends StaticAnimation> targetDynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(targetPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*    */       
/* 64 */       if (!(targetDynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionHitAnimation)) {
/* 65 */         annoyingVillagers$cancelExecution(true);
/* 66 */         ci.cancel();
/*    */       } 
/*    */     }  }
/*    */ 
/*    */   
/*    */   @Unique
/*    */   private void annoyingVillagers$cancelExecution(boolean rollExecutorBackward) {
/* 73 */     if (this.cancelled) {
/*    */       return;
/*    */     }
/*    */     
/* 77 */     this.cancelled = true;
/*    */ 
/*    */     
/* 80 */     LivingEntityPatch<?> executorPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this.executor, LivingEntityPatch.class);
/*    */     
/* 82 */     LivingEntityPatch<?> targetPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this.target, LivingEntityPatch.class);
/*    */     
/* 84 */     if (executorPatch != null) {
/* 85 */       executorPatch.stopPlaying((AssetAccessor)this.executionType.executionAnimation());
/*    */       
/* 87 */       if (rollExecutorBackward) {
/* 88 */         executorPatch.playAnimationInstantly((AssetAccessor)Animations.BIPED_ROLL_BACKWARD);
/*    */       }
/*    */     } 
/*    */     
/* 92 */     if (targetPatch != null) {
/* 93 */       targetPatch.stopPlaying((AssetAccessor)this.executionType.executedAnimation());
/*    */     }
/*    */     
/* 96 */     ExecutionHandler.removeExecutingTarget(this.target);
/* 97 */     this.tickTimer = this.maxTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\ExecutionTaskMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */