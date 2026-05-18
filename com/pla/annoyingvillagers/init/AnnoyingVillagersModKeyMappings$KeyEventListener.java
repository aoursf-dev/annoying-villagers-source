/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber({Dist.CLIENT})
/*    */ public class KeyEventListener
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onClientTick(TickEvent.ClientTickEvent event) {
/* 91 */     if (event.phase != TickEvent.Phase.END) {
/*    */       return;
/*    */     }
/*    */     
/* 95 */     Minecraft mc = Minecraft.m_91087_();
/*    */     
/* 97 */     if (mc.f_91080_ == null) {
/* 98 */       AnnoyingVillagersModKeyMappings.SPECIAL_ATTACK.m_90859_();
/* 99 */       AnnoyingVillagersModKeyMappings.THROW_ENDER_PEARL.m_90859_();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModKeyMappings$KeyEventListener.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */