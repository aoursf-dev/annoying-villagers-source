/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModMobEffects;
/*    */ import com.pla.annoyingvillagers.item.BlueDemonChestplateItem;
/*    */ import java.util.Random;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
/*    */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.FORGE)
/*    */ public final class BlueDemonChestplateEvent
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
/* 24 */     if (event.getSlot() != EquipmentSlot.CHEST) {
/*    */       return;
/*    */     }
/*    */     
/* 28 */     ItemStack oldStack = event.getFrom();
/* 29 */     if (BlueDemonChestplateItem.isBlueDemonChestplate(oldStack)) {
/* 30 */       BlueDemonChestplateItem.stopBuff(oldStack);
/*    */     }
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onLivingDamage(LivingHurtEvent event) {
/* 36 */     LivingEntity wearer = event.getEntity();
/* 37 */     if (!(wearer instanceof net.minecraft.world.entity.player.Player))
/* 38 */       return;  if (!wearer.m_6084_()) {
/*    */       return;
/*    */     }
/*    */     
/* 42 */     ItemStack chest = wearer.m_6844_(EquipmentSlot.CHEST);
/* 43 */     if (!BlueDemonChestplateItem.isBlueDemonChestplate(chest)) {
/*    */       return;
/*    */     }
/*    */     
/* 47 */     float finalDamage = event.getAmount();
/* 48 */     if (finalDamage <= 0.0F) {
/*    */       return;
/*    */     }
/*    */     
/* 52 */     if (BlueDemonChestplateItem.isBuffActive(chest)) {
/* 53 */       Entity sourceEntity = event.getSource().m_7639_();
/* 54 */       if (sourceEntity instanceof LivingEntity) { LivingEntity attacker = (LivingEntity)sourceEntity; if (attacker != wearer) {
/* 55 */           float chance = (new Random()).nextFloat();
/* 56 */           if (chance <= 0.2F) {
/* 57 */             attacker.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ELECTRIFY
/* 58 */                   .get(), 20, 2));
/*    */ 
/*    */           
/*    */           }
/* 62 */           else if (chance <= 0.6F) {
/* 63 */             attacker.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ELECTRIFY
/* 64 */                   .get(), 20, 1));
/*    */           }
/*    */         
/*    */         }
/*    */          }
/*    */ 
/*    */     
/* 71 */     } else if (!BlueDemonChestplateItem.isFullyCharged(chest)) {
/* 72 */       int gainedCharge = Math.max(1, Mth.m_14167_(finalDamage));
/* 73 */       BlueDemonChestplateItem.addStoredCharge(chest, gainedCharge);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\BlueDemonChestplateEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */