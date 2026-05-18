/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*    */ import com.pla.annoyingvillagers.network.SpecialAttackMessage;
/*    */ import net.minecraft.client.KeyMapping;
/*    */ import net.minecraft.client.Minecraft;
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
/*    */   private static final int HOLD_THRESHOLD_TICKS = 10;
/*    */   private boolean isDownOld;
/*    */   private int pressedAtTick;
/*    */   
/*    */   null(String pName, int pKeyCode, String pCategory) {
/* 22 */     super(pName, pKeyCode, pCategory);
/*    */ 
/*    */     
/* 25 */     this.isDownOld = false;
/* 26 */     this.pressedAtTick = -1;
/*    */   }
/*    */   
/*    */   public void m_7249_(boolean flag) {
/* 30 */     super.m_7249_(flag);
/*    */     
/* 32 */     Minecraft minecraft = Minecraft.m_91087_();
/* 33 */     if (minecraft.f_91074_ == null) {
/* 34 */       this.isDownOld = flag;
/*    */       
/*    */       return;
/*    */     } 
/* 38 */     if (!this.isDownOld && flag) {
/* 39 */       this.pressedAtTick = minecraft.f_91074_.f_19797_;
/*    */     }
/*    */     
/* 42 */     if (this.isDownOld && !flag) {
/*    */ 
/*    */       
/* 45 */       int heldTicks = (this.pressedAtTick >= 0) ? (minecraft.f_91074_.f_19797_ - this.pressedAtTick) : 0;
/*    */       
/* 47 */       int type = (heldTicks >= 10) ? 1 : 0;
/* 48 */       AnnoyingVillagers.PACKET_HANDLER.sendToServer(new SpecialAttackMessage(type, heldTicks));
/* 49 */       this.pressedAtTick = -1;
/*    */     } 
/*    */     
/* 52 */     this.isDownOld = flag;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModKeyMappings$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */