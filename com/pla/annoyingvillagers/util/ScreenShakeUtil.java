/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*    */ import com.pla.annoyingvillagers.network.CPApplyShake;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.phys.AABB;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.network.PacketDistributor;
/*    */ 
/*    */ public class ScreenShakeUtil {
/*    */   public static void applyScreenShake(ServerLevel level, Vec3 center, double range, int durationTicks, int amplifier) {
/* 14 */     double rangeSq = range * range;
/* 15 */     AABB box = (new AABB(center, center)).m_82400_(range);
/*    */     
/* 17 */     for (Player player : level.m_6443_(Player.class, box, player -> 
/* 18 */         (player.m_6084_() && !player.m_5833_()))) {
/*    */       
/* 20 */       double distSq = player.m_20275_(center.f_82479_, center.f_82480_, center.f_82481_);
/* 21 */       if (distSq > rangeSq)
/*    */         continue; 
/* 23 */       AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 24 */           .with(() -> player), new CPApplyShake(durationTicks, amplifier, durationTicks / 10.0F, 1));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\ScreenShakeUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */