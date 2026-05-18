/*    */ package com.pla.annoyingvillagers.client.engine;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModKeyMappings;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.player.LocalPlayer;
/*    */ import net.minecraft.network.chat.Component;
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
/*    */ public class MountControlsMessenger
/*    */ {
/* 35 */   private static int delay = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendControlsMessage() {
/* 42 */     delay = 60;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void tick() {
/* 48 */     if (delay > 0) {
/*    */       
/* 50 */       LocalPlayer player = (Minecraft.m_91087_()).f_91074_;
/* 51 */       if (!(player.m_20202_() instanceof com.pla.annoyingvillagers.entity.HerobrineDragonEntity)) {
/*    */         
/* 53 */         delay = 0;
/*    */         
/*    */         return;
/*    */       } 
/* 57 */       delay--;
/*    */       
/* 59 */       if (delay == 0)
/* 60 */         player.m_5661_((Component)Component.m_237110_("mount.dragon.vertical_controls", new Object[] {
/* 61 */                 (Minecraft.m_91087_()).f_91066_.f_92089_.m_90863_(), AnnoyingVillagersModKeyMappings.DRAGON_FLIGHT_DESCENT_KEY
/* 62 */                 .m_90863_()
/*    */               }), true); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\MountControlsMessenger.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */