/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*    */ import com.pla.annoyingvillagers.network.ThrowingEnderPearlMessage;
/*    */ import net.minecraft.client.KeyMapping;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.world.entity.player.Player;
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
/*    */ class null
/*    */   extends KeyMapping
/*    */ {
/*    */   private boolean isDownOld;
/*    */   
/*    */   null(String pName, int pKeyCode, String pCategory) {
/* 59 */     super(pName, pKeyCode, pCategory);
/* 60 */     this.isDownOld = false;
/*    */   }
/*    */   
/*    */   public void m_7249_(boolean flag) {
/* 64 */     super.m_7249_(flag);
/* 65 */     if (this.isDownOld != flag && flag && (Minecraft.m_91087_()).f_91074_ != null) {
/* 66 */       AnnoyingVillagers.PACKET_HANDLER.sendToServer(new ThrowingEnderPearlMessage(0, 0));
/* 67 */       ThrowingEnderPearlMessage.pressAction((Player)(Minecraft.m_91087_()).f_91074_, 0, 0);
/*    */     } 
/*    */     
/* 70 */     this.isDownOld = flag;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModKeyMappings$2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */