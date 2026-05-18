/*    */ package com.pla.annoyingvillagers.event;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraftforge.event.entity.EntityJoinLevelEvent;
/*    */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.FORGE)
/*    */ public class SnakeBladeCleanupEvent {
/*    */   @SubscribeEvent
/*    */   public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
/* 17 */     if (event.getLevel().m_5776_())
/*    */       return; 
/* 19 */     if (event.loadedFromDisk() && event
/* 20 */       .getEntity().m_6095_() == AnnoyingVillagersModEntities.SNAKE_BLADE.get()) {
/* 21 */       event.setCanceled(true);
/* 22 */       event.getEntity().m_146870_();
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
/* 28 */     Player player = event.getEntity();
/* 29 */     for (ItemStack stack : (player.m_150109_()).f_35974_) {
/* 30 */       if (stack.m_150930_((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get()))
/* 31 */         stack.m_41749_("SnakeAnimation"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\SnakeBladeCleanupEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */