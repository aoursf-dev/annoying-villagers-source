/*    */ package com.pla.annoyingvillagers.combatbehaviour;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.AngrySteveEntity;
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
/* 38 */     super(waitTicks);
/*    */   }
/*    */   public void run() {
/* 41 */     serverLevel.m_6263_(null, steveEntity
/*    */         
/* 43 */         .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_START
/* 44 */         .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 49 */     serverLevel.m_6263_(null, steveEntity
/*    */         
/* 51 */         .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD
/* 52 */         .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 57 */     serverLevel.m_6263_(null, steveEntity
/*    */         
/* 59 */         .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HEAVY_ATTACK_LEGENDARY_SWORD_2
/* 60 */         .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 65 */     serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, steveEntity
/*    */         
/* 67 */         .m_20185_(), steveEntity.m_20186_(), steveEntity.m_20189_(), 15, 0.0D, 0.0D, 0.0D, 0.2D);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 72 */     serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123767_, steveEntity
/*    */         
/* 74 */         .m_20185_(), steveEntity.m_20188_(), steveEntity.m_20189_(), 100, 0.0D, 0.0D, 0.0D, 0.5D);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 79 */     mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LEGENDARY_SWORD_HEAVY_ATTACK, 0.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\AngrySteveLegendarySword$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */