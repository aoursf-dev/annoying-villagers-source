/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.EnchantedEnderPearlEntity;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.item.UseAnim;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class EnchantedEnderPearlItem
/*    */   extends Item
/*    */ {
/*    */   public EnchantedEnderPearlItem() {
/* 27 */     super((new Item.Properties()).m_41487_(1).m_41503_(100));
/*    */   }
/*    */   @NotNull
/*    */   public InteractionResultHolder<ItemStack> m_7203_(@NotNull Level level, Player player, @NotNull InteractionHand interactionhand) {
/* 31 */     player.m_6672_(interactionhand);
/* 32 */     return new InteractionResultHolder(InteractionResult.SUCCESS, player.m_21120_(interactionhand));
/*    */   }
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 36 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 37 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.enchanted_ender_pearl"));
/*    */   }
/*    */   @NotNull
/*    */   public UseAnim m_6164_(@NotNull ItemStack itemstack) {
/* 41 */     return UseAnim.BOW;
/*    */   }
/*    */   
/*    */   public int m_8105_(@NotNull ItemStack itemstack) {
/* 45 */     return 72000;
/*    */   }
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public boolean m_5812_(@NotNull ItemStack itemstack) {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public void m_5551_(@NotNull ItemStack itemstack, Level level, @NotNull LivingEntity livingentity, int i) {
/* 54 */     if (!level.m_5776_() && livingentity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingentity;
/* 55 */       EnchantedEnderPearlEntity enchantedEnderPearl = EnchantedEnderPearlEntity.shoot(level, (LivingEntity)serverPlayer, RandomSource.m_216327_(), 1.3F, 0.0D, 0);
/* 56 */       itemstack.m_41622_(1, (LivingEntity)serverPlayer, serverplayer1 -> serverplayer1.m_21190_(serverPlayer.m_7655_()));
/*    */ 
/*    */       
/* 59 */       enchantedEnderPearl.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/* 60 */       serverPlayer.m_36335_().m_41524_(itemstack.m_41720_(), 20); }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EnchantedEnderPearlItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */