/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*    */ import com.pla.annoyingvillagers.entity.ShadowHerobrineEntity;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.level.Level;
/*    */ 
/*    */ 
/*    */ public class HerobrinePortalUtil
/*    */ {
/*    */   public static final int SHINK_TIME_START = 40;
/*    */   public static final String NBT_RISING = "rising";
/*    */   public static final String NBT_TARGET_Y = "rise_target_y";
/*    */   public static final String NBT_SPEED = "rise_speed";
/*    */   public static final String NBT_TICKS = "rise_ticks";
/*    */   public static final String NBT_MAX_TICKS = "rise_max_ticks";
/*    */   public static final String NBT_SINKING = "sinking";
/*    */   public static final String NBT_SINK_TARGET_Y = "sink_target_y";
/*    */   public static final String NBT_SINK_SPEED = "sink_speed";
/*    */   public static final String NBT_SINK_TICKS = "sink_ticks";
/*    */   public static final String NBT_SINK_MAX_TICKS = "sink_max_ticks";
/*    */   
/*    */   public static void spawnHerobrine(LivingEntity livingEntity) {
/* 31 */     Level level = livingEntity.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 32 */       if (livingEntity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)livingEntity;
/* 33 */         if (herobrineMob.getGregUUID() == null) {
/* 34 */           herobrineMob.m_5496_((SoundEvent)AnnoyingVillagersModSounds.PORTAL_NATURAL.get(), 1.0F, 1.0F);
/*    */         }
/* 36 */         if (herobrineMob instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)herobrineMob;
/* 37 */           shadowHerobrineEntity.spawnDarkObEntities(); }
/*    */          }
/*    */       
/* 40 */       spawnRising(serverLevel, livingEntity, livingEntity.m_20185_(), livingEntity.m_20189_(), 0.03D); }
/*    */   
/*    */   }
/*    */   
/*    */   public static <T extends LivingEntity> void spawnRising(ServerLevel level, T entity, double x, double z, double speedPerTick) {
/* 45 */     double groundY = entity.m_20186_();
/* 46 */     double startY = groundY - 2.0D;
/* 47 */     entity.m_7678_(x, startY, z, entity.m_146908_(), entity.m_146909_());
/*    */     
/* 49 */     ((LivingEntity)entity).f_19794_ = true;
/* 50 */     entity.m_20242_(true);
/* 51 */     entity.m_20331_(true);
/*    */     
/* 53 */     CompoundTag tag = entity.getPersistentData();
/* 54 */     tag.m_128379_("rising", true);
/* 55 */     tag.m_128347_("rise_target_y", groundY + 0.02D);
/* 56 */     tag.m_128347_("rise_speed", Math.max(0.01D, speedPerTick));
/* 57 */     tag.m_128405_("rise_ticks", 0);
/* 58 */     tag.m_128405_("rise_max_ticks", 100);
/*    */     
/* 60 */     level.m_5594_(null, entity.m_20183_(), SoundEvents.f_12404_, SoundSource.HOSTILE, 0.6F, 0.8F + level.f_46441_.m_188501_() * 0.2F);
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T extends LivingEntity> void sinkIntoGround(ServerLevel level, T entity, double speedPerTick) {
/* 65 */     double groundY = entity.m_20186_();
/* 66 */     double targetY = groundY - 1.2D;
/*    */     
/* 68 */     ((LivingEntity)entity).f_19794_ = true;
/* 69 */     entity.m_20242_(true);
/* 70 */     entity.m_20331_(true);
/* 71 */     if (entity instanceof Mob) { Mob mob = (Mob)entity;
/* 72 */       mob.m_21557_(true); }
/*    */ 
/*    */     
/* 75 */     CompoundTag tag = entity.getPersistentData();
/* 76 */     tag.m_128379_("sinking", true);
/* 77 */     tag.m_128347_("sink_target_y", targetY);
/* 78 */     tag.m_128347_("sink_speed", Math.max(0.01D, speedPerTick));
/* 79 */     tag.m_128405_("sink_ticks", 0);
/* 80 */     tag.m_128405_("sink_max_ticks", 100);
/*    */     
/* 82 */     level.m_5594_(null, entity.m_20183_(), SoundEvents.f_12404_, SoundSource.HOSTILE, 0.5F, 1.2F + level.f_46441_.m_188501_() * 0.2F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\HerobrinePortalUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */