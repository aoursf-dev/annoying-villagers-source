/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import com.pla.annoyingvillagers.util.TeamUtil;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.LivingEntity;
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
/*    */ public class VillagerHeadItem
/*    */   extends Item {
/*    */   public VillagerHeadItem() {
/* 25 */     super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.COMMON));
/*    */   }
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemStack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
/* 29 */     super.m_7373_(itemStack, level, list, tooltipFlag);
/* 30 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.villager_head"));
/*    */   }
/*    */   @NotNull
/*    */   public InteractionResultHolder<ItemStack> m_7203_(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
/* 34 */     if (player.m_6844_(EquipmentSlot.HEAD).m_41720_() == Blocks.f_50016_.m_5456_()) {
/* 35 */       (player.m_150109_()).f_35975_.set(3, new ItemStack((ItemLike)AnnoyingVillagersModItems.VILLAGER_HEAD.get()));
/* 36 */       TeamUtil.addOrJoinTeam((Entity)player, "villagers");
/* 37 */       player.m_150109_().m_6596_();
/* 38 */       player.m_21008_(interactionHand, ItemStack.f_41583_);
/* 39 */       if (!player.m_9236_().m_5776_()) {
/* 40 */         player.m_5661_((Component)Component.m_237113_("You have put on the villager helmet. Villager soldiers will no longer attack you."), false);
/*    */       }
/*    */     } 
/* 43 */     return super.m_7203_(level, player, interactionHand);
/*    */   }
/*    */   
/*    */   public void m_6883_(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean flag) {
/* 47 */     super.m_6883_(itemStack, level, entity, i, flag);
/* 48 */     if (entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity; if (livingEntity
/* 49 */         .m_6844_(EquipmentSlot.HEAD).m_41720_() != AnnoyingVillagersModItems.VILLAGER_HEAD.get() && 
/* 50 */         TeamUtil.isInTeam(entity, "villagers")) {
/* 51 */         TeamUtil.leaveTeam(entity, "villagers");
/*    */         
/* 53 */         if (entity instanceof Player) { Player player = (Player)entity; if (!player.m_9236_().m_5776_()) {
/* 54 */             player.m_5661_(
/* 55 */                 (Component)Component.m_237113_("You have removed your helmet. Villager soldiers will now attack you."), false);
/*    */           } }
/*    */       
/*    */       }  }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onDroppedByPlayer(ItemStack itemstack, Player player) {
/* 64 */     if (TeamUtil.isInTeam((Entity)player, "villagers")) {
/* 65 */       TeamUtil.leaveTeam((Entity)player, "villagers");
/*    */     }
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\VillagerHeadItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */