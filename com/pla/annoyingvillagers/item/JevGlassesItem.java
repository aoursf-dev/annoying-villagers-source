/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Rarity;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class JevGlassesItem
/*    */   extends Item {
/*    */   public JevGlassesItem() {
/* 22 */     super((new Item.Properties()).m_41487_(64).m_41497_(Rarity.COMMON));
/*    */   }
/*    */   
/*    */   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltipflag) {
/* 26 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 27 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.jev_glasses"));
/*    */   }
/*    */   @NotNull
/*    */   public InteractionResultHolder<ItemStack> m_7203_(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
/* 31 */     if (player.m_6844_(EquipmentSlot.HEAD).m_41720_() == Blocks.f_50016_.m_5456_()) {
/* 32 */       (player.m_150109_()).f_35975_.set(3, new ItemStack((ItemLike)AnnoyingVillagersModItems.JEV_GLASSES.get()));
/* 33 */       player.m_150109_().m_6596_();
/* 34 */       player.m_21008_(interactionHand, ItemStack.f_41583_);
/*    */     } 
/* 36 */     return super.m_7203_(level, player, interactionHand);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\JevGlassesItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */