/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Rarity;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class CompressedDiamondItem
/*    */   extends Item
/*    */ {
/*    */   public CompressedDiamondItem() {
/* 16 */     super((new Item.Properties()).m_41487_(64).m_41497_(Rarity.EPIC));
/*    */   }
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemStack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
/* 20 */     super.m_7373_(itemStack, level, list, tooltipFlag);
/* 21 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.compressessed_diamond"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\CompressedDiamondItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */