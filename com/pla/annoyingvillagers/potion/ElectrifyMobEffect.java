/*    */ package com.pla.annoyingvillagers.potion;
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.shelmarow.combat_evolution.execution.ExecutionHandler;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ public class ElectrifyMobEffect extends MobEffect {
/*    */   public ElectrifyMobEffect() {
/* 27 */     super(MobEffectCategory.BENEFICIAL, -16711681);
/*    */   }
/*    */   @NotNull
/*    */   public String m_19481_() {
/* 31 */     return "effect.annoyingvillagers.electrify";
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6742_(@NotNull LivingEntity pLivingEntity, int pAmplifier) {
/* 36 */     super.m_6742_(pLivingEntity, pAmplifier);
/* 37 */     double d0 = pLivingEntity.m_20185_();
/* 38 */     double d1 = pLivingEntity.m_20186_();
/* 39 */     double d2 = pLivingEntity.m_20189_();
/*    */     
/* 41 */     if (pLivingEntity.f_19797_ % 20 == 0) {
/* 42 */       LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)pLivingEntity, LivingEntityPatch.class);
/*    */       
/* 44 */       if (livingEntityPatch != null) {
/* 45 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 46 */         if (dynamicAnimation != null && 
/* 47 */           !livingEntityPatch.isStunned() && 
/* 48 */           !ExecutionHandler.isTargetGuardBreak(dynamicAnimation, livingEntityPatch) && 
/* 49 */           !(dynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation) && 
/* 50 */           !(dynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionHitAnimation)) {
/* 51 */           if (pAmplifier > 1) {
/* 52 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.ZAP_LONG, 0.0F);
/*    */           } else {
/* 54 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.ZAP, 0.0F);
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 60 */     if (Math.random() <= 0.1D) {
/* 61 */       Level level = pLivingEntity.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 62 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/* 63 */             .get(), pLivingEntity
/* 64 */             .m_20185_(), pLivingEntity.m_20186_(), pLivingEntity.m_20189_(), 1, 0.3D, 1.2D, 0.3D, 0.0D);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 70 */         if (serverLevel.f_46441_.m_188500_() <= 0.8D) {
/* 71 */           float volume = (float)Mth.m_216263_(serverLevel.f_46441_, 0.05D, 0.5D);
/* 72 */           float pitch = (float)Mth.m_216263_(serverLevel.f_46441_, 0.8D, 1.1D);
/*    */           
/* 74 */           serverLevel.m_5594_(null, 
/*    */               
/* 76 */               BlockPos.m_274561_(d0, d1, d2), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY
/* 77 */               .get(), SoundSource.NEUTRAL, volume, pitch);
/*    */         }  }
/*    */     
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 86 */     if (Math.random() <= ((pAmplifier > 1) ? 1.0D : 0.1D)) {
/* 87 */       pLivingEntity.m_6469_(pLivingEntity.m_9236_().m_269111_().m_269264_(), (pAmplifier > 1) ? 5.0F : 0.2F);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean m_6584_(int i, int j) {
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\potion\ElectrifyMobEffect.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */