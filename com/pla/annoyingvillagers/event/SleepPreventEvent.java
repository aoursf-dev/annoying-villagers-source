/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.HerobrineGregEntity;
/*    */ import com.pla.annoyingvillagers.spawnhandler.GregData;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.ChatFormatting;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.server.ServerLifecycleHooks;
/*    */ 
/*    */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.FORGE)
/*    */ public class SleepPreventEvent
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerSleep(PlayerSleepInBedEvent event) {
/* 24 */     MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
/* 25 */     if (server == null)
/*    */       return; 
/* 27 */     ServerLevel serverLevel = server.m_129880_(Level.f_46428_);
/* 28 */     if (serverLevel == null || !serverLevel.m_46472_().equals(Level.f_46428_))
/*    */       return; 
/* 30 */     GregData gregData = GregData.get(serverLevel);
/* 31 */     UUID gregUUID = gregData.getActiveId();
/*    */     
/* 33 */     if (gregUUID != null) {
/* 34 */       Entity entity = serverLevel.m_8791_(gregUUID);
/* 35 */       if (entity instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)entity; if (herobrineGregEntity
/* 36 */           .m_6084_() && herobrineGregEntity.getSummonTimestamp() >= 0) {
/* 37 */           event.setResult(Player.BedSleepingProblem.OTHER_PROBLEM);
/* 38 */           event.getEntity().m_5661_(
/* 39 */               (Component)Component.m_237113_("Herobrine is preparing to invade near x: " + herobrineGregEntity.m_20097_().m_123341_() + " y: " + herobrineGregEntity
/* 40 */                 .m_20097_().m_123342_() + " z: " + herobrineGregEntity.m_20097_().m_123343_() + ". You cannot sleep now!").m_130940_(ChatFormatting.RED), false);
/*    */         }  }
/*    */     
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\SleepPreventEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */