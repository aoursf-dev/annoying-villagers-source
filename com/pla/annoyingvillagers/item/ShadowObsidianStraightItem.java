/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Rarity;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class ShadowObsidianStraightItem
/*    */   extends Item {
/*    */   public ShadowObsidianStraightItem() {
/* 12 */     super((new Item.Properties()).m_41487_(1).m_41486_().m_41497_(Rarity.EPIC));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_5812_(@NotNull ItemStack stack) {
/* 17 */     return (stack.m_41782_() && stack.m_41783_() != null && stack.m_41783_().m_128471_("foil"));
/*    */   }
/*    */   
/*    */   public boolean m_8096_(@NotNull BlockState blockstate) {
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\ShadowObsidianStraightItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */