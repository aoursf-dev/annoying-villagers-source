/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*    */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraftforge.event.entity.living.LivingEvent;
/*    */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class MonsterHealingEvent
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onMonsterAttacked(LivingHurtEvent livingHurtEvent) {
/* 19 */     if (livingHurtEvent != null && livingHurtEvent.getEntity() != null) {
/* 20 */       LivingEntity entity = livingHurtEvent.getEntity();
/* 21 */       if (!entity.m_9236_().m_5776_() && ((Boolean)AnnoyingVillagersConfig.VANILLA_MOB_CAN_DRINK_HEALING_POTION.get()).booleanValue() && (
/* 22 */         entity instanceof net.minecraft.world.entity.monster.Zombie || entity instanceof net.minecraft.world.entity.monster.AbstractSkeleton) && 
/* 23 */         entity.m_21223_() <= 10.0F && entity.getPersistentData().m_128451_("AvHealingCooldown") == 0 && entity.m_6084_()) {
/* 24 */         CombatBehaviour.drinkingHealingPotion((Entity)entity, (LevelAccessor)entity.m_9236_(), true, livingHurtEvent.getAmount());
/* 25 */         entity.getPersistentData().m_128405_("AvHealingCooldown", (new Random()).nextInt(60, 200));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onMonsterTick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 34 */     if (livingTickEvent != null && livingTickEvent.getEntity() != null) {
/* 35 */       LivingEntity entity = livingTickEvent.getEntity();
/* 36 */       if (!entity.m_9236_().m_5776_() && ((Boolean)AnnoyingVillagersConfig.VANILLA_MOB_CAN_DRINK_HEALING_POTION.get()).booleanValue() && (
/* 37 */         entity instanceof net.minecraft.world.entity.monster.Zombie || entity instanceof net.minecraft.world.entity.monster.AbstractSkeleton))
/* 38 */         if (!entity.getPersistentData().m_128441_("AvHealingCooldown")) {
/* 39 */           entity.getPersistentData().m_128405_("AvHealingCooldown", 0);
/*    */         } else {
/* 41 */           int healingCooldown = entity.getPersistentData().m_128451_("AvHealingCooldown");
/* 42 */           if (healingCooldown > 0)
/* 43 */             entity.getPersistentData().m_128405_("AvHealingCooldown", healingCooldown - 1); 
/*    */         }  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\MonsterHealingEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */