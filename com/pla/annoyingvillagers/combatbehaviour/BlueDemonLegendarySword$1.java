/*    */ package com.pla.annoyingvillagers.combatbehaviour;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.ParticleTypes;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends DelayedTask
/*    */ {
/*    */   null(int waitTicks) {
/* 32 */     super(waitTicks);
/*    */   }
/*    */   public void run() {
/* 35 */     serverLevel.m_6263_(null, blueDemonEntity
/*    */         
/* 37 */         .m_20185_(), blueDemonEntity.m_20186_(), blueDemonEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_START
/* 38 */         .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 43 */     serverLevel.m_6263_(null, blueDemonEntity
/*    */         
/* 45 */         .m_20185_(), blueDemonEntity.m_20186_(), blueDemonEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD
/* 46 */         .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 51 */     serverLevel.m_6263_(null, blueDemonEntity
/*    */         
/* 53 */         .m_20185_(), blueDemonEntity.m_20186_(), blueDemonEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD_2
/* 54 */         .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 59 */     serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, blueDemonEntity
/*    */         
/* 61 */         .m_20185_(), blueDemonEntity.m_20186_(), blueDemonEntity.m_20189_(), 15, 0.0D, 0.0D, 0.0D, 0.2D);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 66 */     serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, blueDemonEntity
/*    */         
/* 68 */         .m_20185_(), blueDemonEntity.m_20188_(), blueDemonEntity.m_20189_(), 100, 0.0D, 0.0D, 0.0D, 0.5D);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 73 */     mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_HEAVY_ATTACK, 0.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\BlueDemonLegendarySword$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */