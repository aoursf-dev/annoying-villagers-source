/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Rarity;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.Level;
/*    */ 
/*    */ public class GreenVillagerGeneralHelmetFixItem extends Item {
/*    */   public GreenVillagerGeneralHelmetFixItem() {
/* 15 */     super((new Item.Properties()).m_41487_(1).m_41497_(Rarity.COMMON));
/*    */   }
/*    */   
/*    */   private ItemStack randomDamage(ItemStack itemStack) {
/* 19 */     int maxDamage = itemStack.m_41776_();
/* 20 */     itemStack.m_41721_((new Random()).nextInt(maxDamage / 3, maxDamage * 3 / 4));
/* 21 */     return itemStack;
/*    */   }
/*    */   public void m_6883_(ItemStack stack, Level level, Entity entity, int slotId, boolean flag) {
/*    */     Player player;
/* 25 */     if (!level.f_46443_ && entity instanceof Player) { player = (Player)entity; } else { return; }
/* 26 */      if (stack.m_41720_() != this)
/*    */       return; 
/* 28 */     ItemStack replacement = randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.PURPLE_VILLAGER_GENERAL_HELMET.get()));
/* 29 */     player.m_150109_().m_6836_(slotId, replacement);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\GreenVillagerGeneralHelmetFixItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */