/*    */ package com.pla.annoyingvillagers.skill;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.entity.LivingEntity;
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
/* 52 */     super(waitTicks);
/*    */   } public void run() {
/* 54 */     serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.RED_SPARK
/* 55 */         .get(), livingEntity
/* 56 */         .m_20185_(), livingEntity.m_20186_() + 1.5D, livingEntity.m_20189_() + 1.0D, 35, 0.0D, 0.0D, 0.0D, 0.6D);
/*    */ 
/*    */     
/* 59 */     serverLevel.m_6263_(null, livingEntity.m_20185_(), livingEntity.m_20186_(), livingEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HARD_GREATSWORD_SKILL
/* 60 */         .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\GreatSwordSkill$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */