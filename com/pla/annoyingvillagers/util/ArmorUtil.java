/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ 
/*    */ public class ArmorUtil {
/*    */   public static void dropArmorSlot(LivingEntity living, EquipmentSlot slot, String preventArmor) {
/* 13 */     ItemStack stack = living.m_6844_(slot);
/* 14 */     if (stack.m_41619_())
/*    */       return; 
/* 16 */     if (!(living.m_9236_()).f_46443_) {
/* 17 */       living.m_19983_(stack.m_41777_());
/*    */     }
/*    */     
/* 20 */     living.m_8061_(slot, ItemStack.f_41583_);
/* 21 */     if (living instanceof Player) { Player p = (Player)living;
/* 22 */       p.m_150109_().m_6596_();
/* 23 */       if (!p.m_9236_().m_5776_()) {
/* 24 */         p.m_5661_((Component)Component.m_237113_("§eThe " + preventArmor + " rejects this piece!"), true);
/*    */       } }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public static void damageArmor(LivingEntity target, int durabilityDamagePerPiece) {
/* 31 */     RandomSource random = target.m_217043_();
/* 32 */     ServerPlayer serverPlayer = (ServerPlayer)target, serverAttacker = (target instanceof ServerPlayer) ? serverPlayer : null;
/*    */     
/* 34 */     for (EquipmentSlot slot : new EquipmentSlot[] { EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.CHEST, EquipmentSlot.HEAD }) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 40 */       ItemStack armor = target.m_6844_(slot);
/*    */       
/* 42 */       if (!armor.m_41619_() && armor.m_41763_())
/*    */       {
/*    */ 
/*    */         
/* 46 */         if (armor.m_220157_(durabilityDamagePerPiece, random, serverAttacker)) {
/* 47 */           armor.m_41774_(1);
/* 48 */           armor.m_41721_(0);
/* 49 */           target.m_8061_(slot, ItemStack.f_41583_);
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\ArmorUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */