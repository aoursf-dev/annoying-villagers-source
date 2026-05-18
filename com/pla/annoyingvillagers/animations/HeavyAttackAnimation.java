/*     */ package com.pla.annoyingvillagers.animations;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.client.player.LocalPlayer;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.GameRules;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.fml.loading.FMLEnvironment;
/*     */ import yesman.epicfight.api.animation.AnimationManager;
/*     */ import yesman.epicfight.api.animation.Joint;
/*     */ import yesman.epicfight.api.animation.property.AnimationProperty;
/*     */ import yesman.epicfight.api.animation.types.AttackAnimation;
/*     */ import yesman.epicfight.api.animation.types.DynamicAnimation;
/*     */ import yesman.epicfight.api.animation.types.EntityState;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.client.animation.Layer;
/*     */ import yesman.epicfight.api.client.animation.property.ClientAnimationProperties;
/*     */ import yesman.epicfight.api.client.animation.property.JointMask;
/*     */ import yesman.epicfight.api.client.animation.property.JointMaskEntry;
/*     */ import yesman.epicfight.api.collider.Collider;
/*     */ import yesman.epicfight.api.model.Armature;
/*     */ import yesman.epicfight.api.utils.datastruct.TypeFlexibleHashMap;
/*     */ import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.gamerule.EpicFightGameRules;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeavyAttackAnimation
/*     */   extends AttackAnimation
/*     */ {
/*     */   void init() {
/*  40 */     if (!this.properties.containsKey(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED)) {
/*  41 */       float mfloat = Float.parseFloat(String.format(Locale.US, "%.2f", new Object[] { Float.valueOf(1.0F / getTotalTime()) }));
/*  42 */       addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(mfloat));
/*     */     } 
/*  44 */     if (FMLEnvironment.dist == Dist.CLIENT) {
/*  45 */       Set<JointMask> jointMaskSet = new HashSet<>();
/*  46 */       jointMaskSet.add(JointMask.of("Root", JointMask.KEEP_CHILD_LOCROT));
/*  47 */       jointMaskSet.add(JointMask.of("Torso"));
/*  48 */       jointMaskSet.add(JointMask.of("Chest"));
/*  49 */       jointMaskSet.add(JointMask.of("Head"));
/*  50 */       jointMaskSet.add(JointMask.of("Shoulder_R"));
/*  51 */       jointMaskSet.add(JointMask.of("Arm_R"));
/*  52 */       jointMaskSet.add(JointMask.of("Hand_R"));
/*  53 */       jointMaskSet.add(JointMask.of("Elbow_R"));
/*  54 */       jointMaskSet.add(JointMask.of("Tool_R"));
/*  55 */       jointMaskSet.add(JointMask.of("Shoulder_L"));
/*  56 */       jointMaskSet.add(JointMask.of("Arm_L"));
/*  57 */       jointMaskSet.add(JointMask.of("Hand_L"));
/*  58 */       jointMaskSet.add(JointMask.of("Elbow_L"));
/*  59 */       jointMaskSet.add(JointMask.of("Tool_L"));
/*  60 */       jointMaskSet.add(JointMask.of("Thigh_R"));
/*  61 */       jointMaskSet.add(JointMask.of("Leg_R"));
/*  62 */       jointMaskSet.add(JointMask.of("Knee_R"));
/*  63 */       jointMaskSet.add(JointMask.of("Thigh_L"));
/*  64 */       jointMaskSet.add(JointMask.of("Leg_L"));
/*  65 */       jointMaskSet.add(JointMask.of("Knee_L"));
/*     */ 
/*     */       
/*  68 */       JointMaskEntry jointMaskEntry = JointMaskEntry.builder().defaultMask(JointMask.JointMaskSet.of(jointMaskSet)).create();
/*     */       
/*  70 */       addProperty(ClientAnimationProperties.JOINT_MASK, jointMaskEntry);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeavyAttackAnimation(float convertTime, float antic, float preDelay, float contact, float recovery, @Nullable Collider collider, Joint colliderJoint, AnimationManager.AnimationAccessor<? extends HeavyAttackAnimation> accessor, AssetAccessor<? extends Armature> armature) {
/*  79 */     this(convertTime, accessor, armature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, antic, preDelay, contact, recovery, Float.MAX_VALUE, colliderJoint, collider) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeavyAttackAnimation(float convertTime, AnimationManager.AnimationAccessor<? extends HeavyAttackAnimation> accessor, AssetAccessor<? extends Armature> armature, AttackAnimation.Phase... phases) {
/*  87 */     super(convertTime, accessor, armature, phases);
/*  88 */     init();
/*  89 */     addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true));
/*  90 */     addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false));
/*  91 */     addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.COMBO_ATTACK_DIRECTION_MODIFIER);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void bindPhaseState(AttackAnimation.Phase phase) {
/*  96 */     float f = phase.preDelay;
/*     */     
/*  98 */     if (f == 0.0F) {
/*  99 */       f += 0.01F;
/*     */     }
/*     */     
/* 102 */     this.stateSpectrumBlueprint.newTimePair(phase.start, f).addState(EntityState.PHASE_LEVEL, Integer.valueOf(1)).newTimePair(phase.start, phase.contact + 0.01F).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).newTimePair(phase.start, phase.recovery).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.UPDATE_LIVING_MOTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).newTimePair(phase.start, phase.end).addState(EntityState.INACTION, Boolean.valueOf(true)).newTimePair(f, phase.contact + 0.01F).addState(EntityState.ATTACKING, Boolean.valueOf(true)).addState(EntityState.PHASE_LEVEL, Integer.valueOf(2)).newTimePair(phase.contact + 0.01F, phase.end).addState(EntityState.PHASE_LEVEL, Integer.valueOf(3)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true));
/*     */   }
/*     */   
/*     */   public void end(LivingEntityPatch<?> livingentitypatch, AssetAccessor<? extends DynamicAnimation> nextAnimation, boolean flag) {
/* 106 */     super.end(livingentitypatch, nextAnimation, flag);
/* 107 */     boolean flag1 = ((GameRules.BooleanValue)((LivingEntity)livingentitypatch.getOriginal()).m_9236_().m_46469_().m_46170_(EpicFightGameRules.STIFF_COMBO_ATTACKS.getRuleKey())).m_46223_();
/*     */     
/* 109 */     if (!flag && !((DynamicAnimation)nextAnimation.get()).isMainFrameAnimation() && livingentitypatch.isLogicalClient() && !flag1) {
/* 110 */       float f = 0.05F * getPlaySpeed(livingentitypatch, (DynamicAnimation)nextAnimation.get());
/*     */       
/* 112 */       (livingentitypatch.getClientAnimator()).baseLayer.copyLayerTo((livingentitypatch.getClientAnimator()).baseLayer.getLayer(Layer.Priority.HIGHEST), f);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public TypeFlexibleHashMap<EntityState.StateFactor<?>> getStatesMap(LivingEntityPatch<?> livingentitypatch, float f) {
/* 118 */     TypeFlexibleHashMap<EntityState.StateFactor<?>> typeflexiblehashmap = super.getStatesMap(livingentitypatch, f);
/*     */     
/* 120 */     if (!((GameRules.BooleanValue)((LivingEntity)livingentitypatch.getOriginal()).m_9236_().m_46469_().m_46170_(EpicFightGameRules.STIFF_COMBO_ATTACKS.getRuleKey())).m_46223_()) {
/* 121 */       typeflexiblehashmap.put(EntityState.MOVEMENT_LOCKED, Boolean.FALSE);
/* 122 */       typeflexiblehashmap.put(EntityState.UPDATE_LIVING_MOTION, Boolean.TRUE);
/*     */     } 
/*     */     
/* 125 */     return typeflexiblehashmap;
/*     */   }
/*     */   
/*     */   protected Vec3 getCoordVector(LivingEntityPatch<?> livingentitypatch, AssetAccessor<? extends DynamicAnimation> nextAnimation) {
/* 129 */     Vec3 vec3 = super.getCoordVector(livingentitypatch, nextAnimation);
/*     */     
/* 131 */     if (livingentitypatch.shouldBlockMoving() && ((Boolean)getProperty((AnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE).orElse(Boolean.valueOf(false))).booleanValue()) {
/* 132 */       vec3 = vec3.m_82490_(0.0D);
/*     */     }
/*     */     
/* 135 */     return vec3;
/*     */   }
/*     */   
/*     */   public boolean isBasicAttackAnimation() {
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   public boolean shouldPlayerMove(LocalPlayerPatch localplayerpatch) {
/* 143 */     return (!localplayerpatch.isLogicalClient() || ((GameRules.BooleanValue)((LocalPlayer)localplayerpatch.getOriginal()).m_9236_().m_46469_().m_46170_(EpicFightGameRules.STIFF_COMBO_ATTACKS.getRuleKey())).m_46223_() || (((LocalPlayer)localplayerpatch.getOriginal()).f_108618_.f_108567_ == 0.0F && ((LocalPlayer)localplayerpatch.getOriginal()).f_108618_.f_108566_ == 0.0F));
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\animations\HeavyAttackAnimation.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */