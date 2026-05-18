/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*    */ import com.pla.annoyingvillagers.network.SpecialAttackMessage;
/*    */ import com.pla.annoyingvillagers.network.ThrowingEnderPearlMessage;
/*    */ import net.minecraft.client.KeyMapping;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*    */ public class AnnoyingVillagersModKeyMappings
/*    */ {
/* 19 */   public static final KeyMapping SPECIAL_ATTACK = new KeyMapping("key.annoyingvillagers.special_attack", 67, "key.categories.annoyingvillagers")
/*    */     {
/*    */       private static final int HOLD_THRESHOLD_TICKS = 10;
/*    */ 
/*    */       
/*    */       private boolean isDownOld = false;
/*    */       
/* 26 */       private int pressedAtTick = -1;
/*    */ 
/*    */       
/*    */       public void m_7249_(boolean flag) {
/* 30 */         super.m_7249_(flag);
/*    */         
/* 32 */         Minecraft minecraft = Minecraft.m_91087_();
/* 33 */         if (minecraft.f_91074_ == null) {
/* 34 */           this.isDownOld = flag;
/*    */           
/*    */           return;
/*    */         } 
/* 38 */         if (!this.isDownOld && flag) {
/* 39 */           this.pressedAtTick = minecraft.f_91074_.f_19797_;
/*    */         }
/*    */         
/* 42 */         if (this.isDownOld && !flag) {
/*    */ 
/*    */           
/* 45 */           int heldTicks = (this.pressedAtTick >= 0) ? (minecraft.f_91074_.f_19797_ - this.pressedAtTick) : 0;
/*    */           
/* 47 */           int type = (heldTicks >= 10) ? 1 : 0;
/* 48 */           AnnoyingVillagers.PACKET_HANDLER.sendToServer(new SpecialAttackMessage(type, heldTicks));
/* 49 */           this.pressedAtTick = -1;
/*    */         } 
/*    */         
/* 52 */         this.isDownOld = flag;
/*    */       }
/*    */     };
/*    */   
/* 56 */   public static final KeyMapping THROW_ENDER_PEARL = new KeyMapping("key.annoyingvillagers.throw_ender_pearl", 70, "key.categories.annoyingvillagers")
/*    */     {
/*    */       private boolean isDownOld = false;
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public void m_7249_(boolean flag) {
/* 64 */         super.m_7249_(flag);
/* 65 */         if (this.isDownOld != flag && flag && (Minecraft.m_91087_()).f_91074_ != null) {
/* 66 */           AnnoyingVillagers.PACKET_HANDLER.sendToServer(new ThrowingEnderPearlMessage(0, 0));
/* 67 */           ThrowingEnderPearlMessage.pressAction((Player)(Minecraft.m_91087_()).f_91074_, 0, 0);
/*    */         } 
/*    */         
/* 70 */         this.isDownOld = flag;
/*    */       }
/*    */     };
/*    */   
/* 74 */   public static final KeyMapping DRAGON_FLIGHT_DESCENT_KEY = new KeyMapping("key.annoyingvillagers.dragon_flight_descent", 90, "key.categories.annoyingvillagers");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
/* 82 */     event.register(SPECIAL_ATTACK);
/* 83 */     event.register(THROW_ENDER_PEARL);
/* 84 */     event.register(DRAGON_FLIGHT_DESCENT_KEY);
/*    */   }
/*    */   
/*    */   @EventBusSubscriber({Dist.CLIENT})
/*    */   public static class KeyEventListener {
/*    */     @SubscribeEvent
/*    */     public static void onClientTick(TickEvent.ClientTickEvent event) {
/* 91 */       if (event.phase != TickEvent.Phase.END) {
/*    */         return;
/*    */       }
/*    */       
/* 95 */       Minecraft mc = Minecraft.m_91087_();
/*    */       
/* 97 */       if (mc.f_91080_ == null) {
/* 98 */         AnnoyingVillagersModKeyMappings.SPECIAL_ATTACK.m_90859_();
/* 99 */         AnnoyingVillagersModKeyMappings.THROW_ENDER_PEARL.m_90859_();
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModKeyMappings.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */