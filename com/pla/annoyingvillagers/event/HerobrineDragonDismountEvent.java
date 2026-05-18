/*    */ package com.pla.annoyingvillagers.event;
/*    */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.effect.MobEffects;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraftforge.event.entity.EntityMountEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.FORGE)
/*    */ public final class HerobrineDragonDismountEvent {
/*    */   @SubscribeEvent
/*    */   public static void onMount(EntityMountEvent event) {
/*    */     HerobrineDragonEntity dragon;
/* 17 */     if (!event.isDismounting())
/* 18 */       return;  Entity entity = event.getEntityBeingMounted(); if (entity instanceof HerobrineDragonEntity) { dragon = (HerobrineDragonEntity)entity; } else { return; }
/* 19 */      if ((dragon.m_9236_()).f_46443_)
/*    */       return; 
/* 21 */     if (!dragon.m_20096_() && !dragon.isNearGround()) { Entity entity1 = event.getEntityMounting(); if (entity1 instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity1;
/* 22 */         livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 200, 2)); }
/*    */        }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\HerobrineDragonDismountEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */