/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Rarity;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.level.Level;
/*    */ 
/*    */ public class DemoniacVoltageReaverHiltItem
/*    */   extends Item {
/*    */   public DemoniacVoltageReaverHiltItem() {
/* 14 */     super((new Item.Properties()).m_41487_(64).m_41497_(Rarity.COMMON));
/*    */   }
/*    */   
/*    */   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltipflag) {
/* 18 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 19 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.demoniac_voltage_reaver_hilt"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\DemoniacVoltageReaverHiltItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */