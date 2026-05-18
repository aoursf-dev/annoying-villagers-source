/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.util.EquipmentDataLoader;
/*    */ import net.minecraft.server.packs.resources.PreparableReloadListener;
/*    */ import net.minecraftforge.event.AddReloadListenerEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(modid = "annoyingvillagers")
/*    */ public class NpcGearLoadEvent {
/*    */   @SubscribeEvent
/*    */   public void onAddReloadListeners(AddReloadListenerEvent event) {
/* 13 */     event.addListener((PreparableReloadListener)new EquipmentDataLoader());
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\NpcGearLoadEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */