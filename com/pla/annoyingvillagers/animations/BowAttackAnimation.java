/*    */ package com.pla.annoyingvillagers.animations;
/*    */ 
/*    */ import com.pla.annoyingvillagers.util.BowFunction;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import yesman.epicfight.api.animation.AnimationManager;
/*    */ import yesman.epicfight.api.animation.Joint;
/*    */ import yesman.epicfight.api.animation.property.AnimationProperty;
/*    */ import yesman.epicfight.api.animation.types.AttackAnimation;
/*    */ import yesman.epicfight.api.animation.types.DynamicAnimation;
/*    */ import yesman.epicfight.api.animation.types.EntityState;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.api.collider.Collider;
/*    */ import yesman.epicfight.api.model.Armature;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BowAttackAnimation
/*    */   extends AttackAnimation
/*    */ {
/*    */   public BowAttackAnimation(float convertTime, float antic, float preDelay, float contact, float recovery, InteractionHand hand, @Nullable Collider collider, Joint colliderJoint, AnimationManager.AnimationAccessor<? extends BowAttackAnimation> accessor, AssetAccessor<? extends Armature> armature) {
/* 32 */     super(convertTime, antic, preDelay, contact, recovery, hand, collider, colliderJoint, accessor, armature);
/* 33 */     addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false));
/* 34 */     addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true));
/* 35 */     addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void bindPhaseState(AttackAnimation.Phase phase) {
/* 40 */     float start = phase.start;
/* 41 */     float end = phase.end;
/*    */     
/* 43 */     this.stateSpectrumBlueprint
/* 44 */       .newTimePair(start, end)
/* 45 */       .addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true))
/* 46 */       .addState(EntityState.UPDATE_LIVING_MOTION, Boolean.valueOf(false))
/* 47 */       .addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false))
/* 48 */       .addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false))
/* 49 */       .addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true))
/* 50 */       .addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true))
/* 51 */       .addState(EntityState.INACTION, Boolean.valueOf(true));
/*    */   }
/*    */ 
/*    */   
/*    */   public void begin(LivingEntityPatch<?> livingEntityPatch) {
/* 56 */     super.begin(livingEntityPatch);
/* 57 */     LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/* 58 */     ItemStack stack = livingEntity.m_21120_(InteractionHand.MAIN_HAND);
/* 59 */     if (!livingEntity.m_9236_().m_5776_() && 
/* 60 */       !stack.m_41619_() && stack.m_41783_() != null && stack.m_41720_() instanceof net.minecraft.world.item.BowItem && 
/* 61 */       BowFunction.hasArrowOrInfinity(livingEntity, stack)) {
/* 62 */       stack.m_41783_().m_128350_("Pulling", 0.1F);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void end(LivingEntityPatch<?> livingEntityPatch, AssetAccessor<? extends DynamicAnimation> nextAnimation, boolean isEnd) {
/* 68 */     LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/* 69 */     ItemStack stack = livingEntity.m_21120_(InteractionHand.MAIN_HAND);
/* 70 */     if (!livingEntity.m_9236_().m_5776_() && 
/* 71 */       !stack.m_41619_() && stack.m_41783_() != null && stack.m_41720_() instanceof net.minecraft.world.item.BowItem) {
/* 72 */       stack.m_41783_().m_128473_("Pulling");
/*    */     }
/* 74 */     super.end(livingEntityPatch, nextAnimation, isEnd);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\animations\BowAttackAnimation.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */