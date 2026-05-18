/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*    */ import com.pla.annoyingvillagers.entity.HerobrineGregEntity;
/*    */ import com.pla.annoyingvillagers.entity.LowHerobrineCloneEntity;
/*    */ import com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.event.entity.living.LivingEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.FORGE)
/*    */ public class RiseFromGroundEvent {
/*    */   @SubscribeEvent
/*    */   public static void onLivingTick(LivingEvent.LivingTickEvent event) {
/* 22 */     LivingEntity entity = event.getEntity();
/* 23 */     Level level = entity.m_9236_();
/* 24 */     if (level.m_5776_())
/*    */       return; 
/* 26 */     CompoundTag tag = entity.getPersistentData();
/* 27 */     if (tag.m_128471_("rising")) {
/*    */       
/* 29 */       double targetY = tag.m_128459_("rise_target_y");
/* 30 */       double speed = tag.m_128459_("rise_speed");
/* 31 */       int ticks = tag.m_128451_("rise_ticks");
/* 32 */       int max = tag.m_128451_("rise_max_ticks");
/*    */       
/* 34 */       double ny = entity.m_20186_() + speed;
/* 35 */       if (ny >= targetY || ticks > max) {
/* 36 */         entity.m_6034_(entity.m_20185_(), targetY, entity.m_20189_());
/* 37 */         finishRise(entity);
/*    */       } else {
/* 39 */         entity.m_6034_(entity.m_20185_(), ny, entity.m_20189_());
/* 40 */         tag.m_128405_("rise_ticks", ticks + 1);
/*    */       } 
/*    */       
/*    */       return;
/*    */     } 
/* 45 */     if (tag.m_128471_("sinking")) {
/* 46 */       double speed = tag.m_128459_("sink_speed");
/* 47 */       int ticks = tag.m_128451_("sink_ticks");
/*    */       
/* 49 */       entity.m_6034_(entity.m_20185_(), entity.m_20186_() - speed, entity.m_20189_());
/* 50 */       tag.m_128405_("sink_ticks", ticks + 1);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void finishRise(LivingEntity entity) {
/* 55 */     CompoundTag tag = entity.getPersistentData();
/*    */     
/* 57 */     entity.f_19794_ = false;
/* 58 */     entity.m_20242_(false);
/* 59 */     entity.m_20331_(false);
/* 60 */     if (entity instanceof Mob) { Mob mob = (Mob)entity;
/* 61 */       mob.m_21557_(false); }
/*    */ 
/*    */     
/* 64 */     tag.m_128473_("rising");
/* 65 */     tag.m_128473_("rise_target_y");
/* 66 */     tag.m_128473_("rise_speed");
/* 67 */     tag.m_128473_("rise_ticks");
/* 68 */     tag.m_128473_("rise_max_ticks");
/*    */     
/* 70 */     if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 71 */       if (herobrineMob.getGregUUID() != null) {
/* 72 */         Entity greg = ((ServerLevel)herobrineMob.m_9236_()).m_8791_(herobrineMob.getGregUUID());
/* 73 */         if (greg instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)greg; if (herobrineGregEntity.m_6084_() && 
/* 74 */             herobrineGregEntity.isSummoning()) {
/* 75 */             herobrineGregEntity.setSummoning(false);
/* 76 */             herobrineGregEntity.m_21557_(false);
/*    */           }  }
/*    */       
/*    */       } 
/* 80 */       herobrineMob.setInitialSpawn(false); }
/*    */     
/* 82 */     if (entity instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)entity;
/* 83 */       lowHerobrineCloneEntity.setInitialSpawn(false); }
/*    */     
/* 85 */     if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/* 86 */       lowShadowHerobrineCloneEntity.setInitialSpawn(false); }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\RiseFromGroundEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */