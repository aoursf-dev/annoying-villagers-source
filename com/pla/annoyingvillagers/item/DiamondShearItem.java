/*    */ package com.pla.annoyingvillagers.item;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.ShearsItem;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ 
/*    */ public class DiamondShearItem extends ShearsItem {
/*    */   public DiamondShearItem() {
/* 20 */     super((new Item.Properties()).m_41503_(100));
/*    */   }
/*    */   
/*    */   public int m_6473_() {
/* 24 */     return 12;
/*    */   }
/*    */   
/*    */   public float m_8102_(ItemStack itemstack, BlockState blockstate) {
/* 28 */     return 8.0F;
/*    */   }
/*    */   
/*    */   public InteractionResult m_6880_(ItemStack stack, Player playerIn, LivingEntity entity, InteractionHand hand) {
/* 32 */     InteractionResult interactionResult = super.m_6880_(stack, playerIn, entity, hand);
/* 33 */     if (!playerIn.m_9236_().m_5776_() && !entity.m_21220_().isEmpty()) {
/* 34 */       ServerPlayer serverPlayer = (ServerPlayer)playerIn;
/* 35 */       entity.m_21219_();
/* 36 */       playerIn.m_9236_().m_5594_(null, entity.m_20183_(), SoundEvents.f_12344_, SoundSource.NEUTRAL, 1.0F, 1.0F);
/* 37 */       stack.m_41622_(1, (LivingEntity)serverPlayer, serverPlayer1 -> serverPlayer1.m_21190_(hand));
/*    */     } 
/*    */ 
/*    */     
/* 41 */     return interactionResult;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltipflag) {
/* 46 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 47 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.diamond_shear"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\DiamondShearItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */