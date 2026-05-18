/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.ChatFormatting;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ public class ChatUtil {
/*    */   public static void joinGame(Entity entity) {
/* 12 */     if (((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue() && entity.m_9236_().m_7654_() != null) {
/* 13 */       ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(entity.m_9236_().m_7654_())).m_6846_()
/* 14 */         .m_240416_((Component)Component.m_237113_(entity.m_5446_().getString() + " has joined the game")
/* 15 */           .m_130940_(ChatFormatting.YELLOW), false);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void joinGame(Entity entity, String string) {
/* 20 */     if (((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue() && entity.m_9236_().m_7654_() != null) {
/* 21 */       ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(entity.m_9236_().m_7654_())).m_6846_()
/* 22 */         .m_240416_((Component)Component.m_237113_(string + " has joined the game")
/* 23 */           .m_130940_(ChatFormatting.YELLOW), false);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void leaveGame(Entity entity) {
/* 28 */     if (((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue() && entity.m_9236_().m_7654_() != null)
/* 29 */       ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(entity.m_9236_().m_7654_())).m_6846_()
/* 30 */         .m_240416_((Component)Component.m_237113_(entity.m_5446_().getString() + " has left the game")
/* 31 */           .m_130940_(ChatFormatting.YELLOW), false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\ChatUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */