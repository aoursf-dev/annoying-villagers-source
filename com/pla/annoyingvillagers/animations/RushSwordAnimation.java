/*    */ package com.pla.annoyingvillagers.animations;
/*    */ 
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import reascer.wom.animation.attacks.BasicMultipleAttackAnimation;
/*    */ import yesman.epicfight.api.animation.AnimationManager;
/*    */ import yesman.epicfight.api.animation.Joint;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.api.collider.Collider;
/*    */ import yesman.epicfight.api.model.Armature;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RushSwordAnimation
/*    */   extends BasicMultipleAttackAnimation
/*    */ {
/*    */   public RushSwordAnimation(float convertTime, float antic, float preDelay, float contact, float recovery, @Nullable Collider collider, Joint colliderJoint, AnimationManager.AnimationAccessor<? extends BasicMultipleAttackAnimation> accessor, AssetAccessor<? extends Armature> armature) {
/* 25 */     super(convertTime, antic, preDelay, contact, recovery, collider, colliderJoint, accessor, armature);
/*    */   }
/*    */ 
/*    */   
/*    */   public void begin(LivingEntityPatch<?> entitypatch) {
/* 30 */     super.begin(entitypatch);
/* 31 */     final LivingEntity livingEntity = (LivingEntity)entitypatch.getOriginal();
/* 32 */     Vec3 dashDir = livingEntity.m_20154_();
/*    */     
/* 34 */     if (livingEntity instanceof Mob) { Mob mob = (Mob)livingEntity;
/* 35 */       LivingEntity target = mob.m_5448_();
/* 36 */       if (target != null && target.m_6084_()) {
/* 37 */         Vec3 toTarget = target.m_20182_().m_82546_(mob.m_20182_());
/* 38 */         dashDir = new Vec3(toTarget.f_82479_, 0.0D, toTarget.f_82481_);
/*    */       }  }
/*    */ 
/*    */     
/* 42 */     final Vec3 dash = dashDir.m_82541_().m_82490_(2.2D);
/* 43 */     livingEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2, false, false));
/* 44 */     new DelayedTask(1) {
/*    */         public void run() {
/* 46 */           Vec3 cur = livingEntity.m_20184_();
/* 47 */           livingEntity.m_20334_(cur.f_82479_ + dash.f_82479_, cur.f_82480_ + dash.f_82480_, cur.f_82481_ + dash.f_82481_);
/* 48 */           livingEntity.f_19812_ = true;
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\animations\RushSwordAnimation.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */