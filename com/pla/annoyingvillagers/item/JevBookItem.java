/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Rarity;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ 
/*    */ public class JevBookItem
/*    */   extends Item {
/*    */   public JevBookItem() {
/* 19 */     super((new Item.Properties()).m_41487_(1).m_41486_().m_41497_(Rarity.EPIC));
/*    */   }
/*    */   
/*    */   public boolean m_8096_(BlockState blockstate) {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltipflag) {
/* 27 */     super.m_7373_(itemstack, level, list, tooltipflag);
/*    */   }
/*    */   
/*    */   public InteractionResultHolder<ItemStack> m_7203_(Level level, Player player, InteractionHand interactionhand) {
/* 31 */     InteractionResultHolder<ItemStack> interactionresultholder = super.m_7203_(level, player, interactionhand);
/* 32 */     return interactionresultholder;
/*    */   }
/*    */   
/*    */   public void m_6883_(ItemStack itemstack, Level level, Entity entity, int i, boolean flag) {
/* 36 */     super.m_6883_(itemstack, level, entity, i, flag);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\JevBookItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */