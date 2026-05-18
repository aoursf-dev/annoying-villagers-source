/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraftforge.common.BasicItemListing;
/*    */ import net.minecraftforge.event.village.WandererTradesEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
/*    */ public class AnnoyingVillagersModTrades
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void registerWanderingTrades(WandererTradesEvent wanderertradesevent) {
/* 18 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42737_), 10, 5, 0.05F));
/* 19 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42678_), new ItemStack((ItemLike)Items.f_42417_, 10), new ItemStack((ItemLike)Items.f_42747_), 10, 5, 0.05F));
/* 20 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42690_), new ItemStack((ItemLike)Items.f_42707_), 10, 5, 0.05F));
/* 21 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42690_), new ItemStack((ItemLike)Items.f_42708_), 10, 5, 0.05F));
/* 22 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42690_), new ItemStack((ItemLike)Items.f_42709_), 10, 5, 0.05F));
/* 23 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42690_), new ItemStack((ItemLike)Items.f_42710_), 10, 5, 0.05F));
/* 24 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42415_, 30), new ItemStack((ItemLike)Items.f_42587_, 20), new ItemStack((ItemLike)Items.f_42616_, 64), 10, 5, 0.05F));
/* 25 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42393_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42713_), 10, 5, 0.05F));
/* 26 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42747_), new ItemStack((ItemLike)Items.f_42612_, 64), 10, 5, 0.05F));
/* 27 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42616_, 2), new ItemStack((ItemLike)Items.f_42455_), 10, 5, 0.05F));
/* 28 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42656_), 10, 5, 0.05F));
/* 29 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42484_), new ItemStack((ItemLike)Blocks.f_50077_), 10, 5, 0.05F));
/* 30 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42616_, 10), new ItemStack((ItemLike)Items.f_42418_), 10, 5, 0.05F));
/* 31 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42411_), new ItemStack((ItemLike)Items.f_42450_), 10, 5, 0.05F));
/* 32 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42616_, 40), new ItemStack((ItemLike)Items.f_151049_, 60), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANT_BED_ITEM.get()), 10, 5, 0.05F));
/* 33 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Blocks.f_50201_), new ItemStack((ItemLike)Items.f_42686_), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANT_BED_ITEM.get()), 10, 5, 1.0F));
/* 34 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42690_), new ItemStack((ItemLike)Items.f_42747_), new ItemStack((ItemLike)Blocks.f_50313_), 10, 5, 0.9F));
/* 35 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42729_, 5), new ItemStack((ItemLike)Blocks.f_50273_, 50), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANT_BED_ITEM.get()), 10, 5, 1.0F));
/* 36 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42710_), new ItemStack((ItemLike)Items.f_42716_), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANT_BED_ITEM.get()), 10, 5, 1.0F));
/* 37 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Blocks.f_50314_), new ItemStack((ItemLike)Items.f_42586_), 10, 5, 0.05F));
/* 38 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANT_BED_ITEM.get()), new ItemStack((ItemLike)Items.f_42588_, 50), 10, 5, 0.5F));
/* 39 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42710_), new ItemStack((ItemLike)Items.f_42586_, 30), 10, 5, 0.9F));
/* 40 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42616_, 2), new ItemStack((ItemLike)Items.f_42588_), 10, 5, 1.0F));
/* 41 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Blocks.f_50074_), new ItemStack((ItemLike)Items.f_42585_), 10, 5, 1.0F));
/* 42 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42584_, 30), new ItemStack((ItemLike)Items.f_42585_, 20), 10, 5, 1.0F));
/* 43 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Blocks.f_50144_), new ItemStack((ItemLike)Items.f_42542_), 10, 5, 0.05F));
/* 44 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42448_), new ItemStack((ItemLike)Blocks.f_50141_), 10, 5, 0.05F));
/* 45 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Blocks.f_50087_, 55), new ItemStack((ItemLike)Items.f_42545_, 20), new ItemStack((ItemLike)Items.f_42748_, 8), 10, 5, 1.0F));
/* 46 */     wanderertradesevent.getGenericTrades().add(new BasicItemListing(new ItemStack((ItemLike)Items.f_42715_, 50), new ItemStack((ItemLike)Items.f_42710_), new ItemStack((ItemLike)Items.f_42729_), 10, 5, 1.0F));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModTrades.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */