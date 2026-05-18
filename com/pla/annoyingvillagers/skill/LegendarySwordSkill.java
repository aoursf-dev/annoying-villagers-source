/*    */ package com.pla.annoyingvillagers.skill;
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.ParticleTypes;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.skill.SkillBuilder;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*    */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*    */ 
/*    */ public class LegendarySwordSkill extends WeaponInnateSkill {
/*    */   public LegendarySwordSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/* 20 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void executeOnServer(final SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 25 */     final LivingEntity entity = (LivingEntity)skillContainer.getExecutor().getOriginal();
/* 26 */     final ServerLevel serverLevel = (ServerLevel)entity.m_9236_();
/*    */     
/* 28 */     skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AnimsAgony.AGONY_RISING_EAGLE, 0.0F);
/* 29 */     entity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/* 30 */     new DelayedTask(10)
/*    */       {
/*    */         public void run() {
/* 33 */           serverLevel.m_6263_(null, entity
/*    */               
/* 35 */               .m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_START
/* 36 */               .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 41 */           serverLevel.m_6263_(null, entity
/*    */               
/* 43 */               .m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD
/* 44 */               .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 49 */           serverLevel.m_6263_(null, entity
/*    */               
/* 51 */               .m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD_2
/* 52 */               .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 57 */           serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, entity
/*    */               
/* 59 */               .m_20185_(), entity.m_20186_(), entity.m_20189_(), 15, 0.0D, 0.0D, 0.0D, 0.2D);
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 64 */           serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, entity
/*    */               
/* 66 */               .m_20185_(), entity.m_20188_(), entity.m_20189_(), 100, 0.0D, 0.0D, 0.0D, 0.5D);
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 71 */           skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_HEAVY_ATTACK, 0.0F);
/*    */         }
/*    */       };
/* 74 */     super.executeOnServer(skillContainer, friendlyByteBuf);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\LegendarySwordSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */