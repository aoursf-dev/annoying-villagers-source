/*    */ package com.pla.annoyingvillagers.network;
/*    */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*    */ import com.pla.annoyingvillagers.event.SpecialAttackOnKeyHeldEvent;
/*    */ import com.pla.annoyingvillagers.event.SpecialAttackOnKeyPressedEvent;
/*    */ import java.util.Objects;
/*    */ import java.util.function.Function;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ 
/*    */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
/*    */ public class SpecialAttackMessage {
/*    */   int type;
/*    */   
/*    */   public SpecialAttackMessage(int type, int presses) {
/* 24 */     this.type = type;
/* 25 */     this.presses = presses;
/*    */   }
/*    */   int presses;
/*    */   public SpecialAttackMessage(FriendlyByteBuf friendlybytebuf) {
/* 29 */     this.type = friendlybytebuf.readInt();
/* 30 */     this.presses = friendlybytebuf.readInt();
/*    */   }
/*    */   
/*    */   public static void buffer(SpecialAttackMessage specialAttackMessage, FriendlyByteBuf friendlybytebuf) {
/* 34 */     friendlybytebuf.writeInt(specialAttackMessage.type);
/* 35 */     friendlybytebuf.writeInt(specialAttackMessage.presses);
/*    */   }
/*    */   
/*    */   public static void handler(SpecialAttackMessage specialAttackMessage, Supplier<NetworkEvent.Context> supplier) {
/* 39 */     NetworkEvent.Context context = supplier.get();
/*    */     
/* 41 */     context.enqueueWork(() -> pressAction((Player)Objects.requireNonNull(context.getSender()), specialAttackMessage.type, specialAttackMessage.presses));
/*    */ 
/*    */     
/* 44 */     context.setPacketHandled(true);
/*    */   }
/*    */   
/*    */   public static void pressAction(Player player, int type, int presses) {
/* 48 */     Level level = player.m_9236_();
/* 49 */     if (type == 0) {
/* 50 */       SpecialAttackOnKeyPressedEvent.execute((LevelAccessor)level, (Entity)player);
/* 51 */     } else if (type == 1) {
/* 52 */       SpecialAttackOnKeyHeldEvent.execute((LevelAccessor)level, (Entity)player);
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerMessage(FMLCommonSetupEvent fmlcommonsetupevent) {
/* 58 */     AnnoyingVillagers.addNetworkMessage(SpecialAttackMessage.class, SpecialAttackMessage::buffer, SpecialAttackMessage::new, SpecialAttackMessage::handler);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\network\SpecialAttackMessage.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */