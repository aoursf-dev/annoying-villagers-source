/*    */ package com.pla.annoyingvillagers.network;
/*    */ 
/*    */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*    */ import com.pla.annoyingvillagers.event.ThrowingPearlKeyPressedEvent;
/*    */ import java.util.function.Function;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ 
/*    */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
/*    */ public class ThrowingEnderPearlMessage {
/*    */   int type;
/*    */   int pressedms;
/*    */   
/*    */   public ThrowingEnderPearlMessage(int i, int j) {
/* 23 */     this.type = i;
/* 24 */     this.pressedms = j;
/*    */   }
/*    */   
/*    */   public ThrowingEnderPearlMessage(FriendlyByteBuf friendlybytebuf) {
/* 28 */     this.type = friendlybytebuf.readInt();
/* 29 */     this.pressedms = friendlybytebuf.readInt();
/*    */   }
/*    */   
/*    */   public static void buffer(ThrowingEnderPearlMessage throwingEnderPearlMessage, FriendlyByteBuf friendlybytebuf) {
/* 33 */     friendlybytebuf.writeInt(throwingEnderPearlMessage.type);
/* 34 */     friendlybytebuf.writeInt(throwingEnderPearlMessage.pressedms);
/*    */   }
/*    */   
/*    */   public static void handler(ThrowingEnderPearlMessage throwingEnderPearlMessage, Supplier<NetworkEvent.Context> supplier) {
/* 38 */     NetworkEvent.Context context = supplier.get();
/*    */     
/* 40 */     context.enqueueWork(() -> pressAction((Player)context.getSender(), throwingEnderPearlMessage.type, throwingEnderPearlMessage.pressedms));
/*    */ 
/*    */     
/* 43 */     context.setPacketHandled(true);
/*    */   }
/*    */   
/*    */   public static void pressAction(Player player, int i, int j) {
/* 47 */     Level level = player.m_9236_();
/*    */     
/* 49 */     if (level.m_46805_(player.m_20183_()) && !level.m_5776_() && 
/* 50 */       i == 0) {
/* 51 */       ThrowingPearlKeyPressedEvent.execute((Entity)player);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerMessage(FMLCommonSetupEvent fmlcommonsetupevent) {
/* 58 */     AnnoyingVillagers.addNetworkMessage(ThrowingEnderPearlMessage.class, ThrowingEnderPearlMessage::buffer, ThrowingEnderPearlMessage::new, ThrowingEnderPearlMessage::handler);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\network\ThrowingEnderPearlMessage.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */