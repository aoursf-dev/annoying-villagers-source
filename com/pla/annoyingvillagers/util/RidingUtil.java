/*    */ package com.pla.annoyingvillagers.util;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.effect.MobEffects;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.level.Level;
/*    */ 
/*    */ public class RidingUtil {
/*    */   public static void rideRandomAnimal(ServerLevel serverLevel, Entity entity) {
/* 15 */     List<EntityType<? extends LivingEntity>> pool = List.of(EntityType.f_20457_, EntityType.f_20560_, EntityType.f_20503_, EntityType.f_243976_, EntityType.f_20466_, EntityType.f_20555_, EntityType.f_20514_, EntityType.f_20557_, EntityType.f_20452_, EntityType.f_217012_);
/*    */ 
/*    */     
/* 18 */     Random rand = new Random();
/* 19 */     EntityType<? extends LivingEntity> type = pool.get(rand.nextInt(pool.size()));
/*    */     
/* 21 */     LivingEntity mount = (LivingEntity)type.m_20615_((Level)serverLevel);
/* 22 */     if (mount != null) {
/* 23 */       mount.m_7678_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
/* 24 */       ((Mob)mount).m_21530_();
/* 25 */       ((Mob)mount).m_6518_((ServerLevelAccessor)serverLevel, serverLevel
/*    */           
/* 27 */           .m_6436_(entity.m_20183_()), MobSpawnType.MOB_SUMMONED, null, null);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 32 */       if (entity instanceof com.pla.annoyingvillagers.entity.VillagerScoutEntity || entity instanceof com.pla.annoyingvillagers.entity.VillagerScoutCaptainEntity || entity instanceof com.pla.annoyingvillagers.entity.RedVillagerGeneralEntity || entity instanceof com.pla.annoyingvillagers.entity.BlueVillagerGeneralEntity || entity instanceof com.pla.annoyingvillagers.entity.GreenVillagerGeneralEntity || entity instanceof com.pla.annoyingvillagers.entity.PurpleVillagerGeneralEntity)
/*    */       {
/*    */         
/* 35 */         TeamUtil.addOrJoinTeam((Entity)mount, "villagers");
/*    */       }
/* 37 */       serverLevel.m_7967_((Entity)mount);
/* 38 */       entity.m_20329_((Entity)mount);
/* 39 */       mount.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 99999, (new Random()).nextInt(1, 3), false, false));
/* 40 */       mount.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 99999, 1, false, false));
/* 41 */       mount.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 99999, (new Random()).nextInt(1, 9), false, false));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\RidingUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */