/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import net.minecraft.world.SimpleContainer;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ 
/*    */ public class InventoryUtils {
/*    */   public static void transferInventory(SimpleContainer from, SimpleContainer to) {
/*  8 */     int size = Math.min(from.m_6643_(), to.m_6643_());
/*  9 */     for (int i = 0; i < size; i++) {
/* 10 */       ItemStack stack = from.m_8020_(i);
/* 11 */       if (!stack.m_41619_()) {
/* 12 */         to.m_6836_(i, stack.m_41777_());
/* 13 */         from.m_6836_(i, ItemStack.f_41583_);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\InventoryUtils.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */