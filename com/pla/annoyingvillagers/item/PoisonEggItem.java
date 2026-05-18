/*    */ package com.pla.annoyingvillagers.item;
/*    */ import com.pla.annoyingvillagers.entity.ThrownPoisonEggEntity;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.stats.Stats;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.level.Level;
/*    */ 
/*    */ public class PoisonEggItem extends Item {
/*    */   public PoisonEggItem() {
/* 21 */     super((new Item.Properties()).m_41487_(16));
/*    */   }
/*    */   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltipflag) {
/* 24 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 25 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.poison_egg"));
/*    */   }
/*    */   public InteractionResultHolder<ItemStack> m_7203_(Level pLevel, Player pPlayer, InteractionHand pHand) {
/* 28 */     ItemStack itemstack = pPlayer.m_21120_(pHand);
/* 29 */     pLevel.m_6263_((Player)null, pPlayer.m_20185_(), pPlayer.m_20186_(), pPlayer.m_20189_(), SoundEvents.f_11877_, SoundSource.PLAYERS, 0.5F, 0.4F / (pLevel.m_213780_().m_188501_() * 0.4F + 0.8F));
/* 30 */     if (!pLevel.f_46443_) {
/*    */       
/* 32 */       ThrownPoisonEggEntity thrownegg = new ThrownPoisonEggEntity((EntityType)AnnoyingVillagersModEntities.THROWN_POISON_EGG.get(), (LivingEntity)pPlayer, pLevel);
/*    */       
/* 34 */       thrownegg.m_37446_(itemstack);
/* 35 */       thrownegg.m_37251_((Entity)pPlayer, pPlayer.m_146909_(), pPlayer.m_146908_(), 0.0F, 1.5F, 1.0F);
/* 36 */       pLevel.m_7967_((Entity)thrownegg);
/*    */     } 
/*    */     
/* 39 */     pPlayer.m_36246_(Stats.f_12982_.m_12902_(this));
/* 40 */     if (!(pPlayer.m_150110_()).f_35937_) {
/* 41 */       itemstack.m_41774_(1);
/*    */     }
/*    */     
/* 44 */     return InteractionResultHolder.m_19092_(itemstack, pLevel.m_5776_());
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\PoisonEggItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */