/*    */ package com.pla.annoyingvillagers.event;
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import com.pla.annoyingvillagers.util.VillagerUtil;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.ParticleTypes;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class FireworkUseEvent {
/*    */   @SubscribeEvent
/*    */   public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
/*    */     ServerLevel serverLevel;
/* 24 */     if (event.getHand() != event.getEntity().m_7655_()) {
/*    */       return;
/*    */     }
/*    */     
/* 28 */     Level level = event.getLevel(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*    */     else
/*    */     { return; }
/*    */     
/* 32 */     if (!tryUseVillagerSignalFirework(serverLevel, event.getPos(), event.getEntity(), event.getHand())) {
/*    */       return;
/*    */     }
/*    */     
/* 36 */     event.setCanceled(true);
/* 37 */     event.setCancellationResult(InteractionResult.SUCCESS);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean tryUseVillagerSignalFirework(final ServerLevel serverLevel, BlockPos clickedPos, Player player, InteractionHand hand) {
/* 44 */     ItemStack usedStack = player.m_21120_(hand);
/* 45 */     if (!VillagerUtil.isBlackCreeperSignalFirework(usedStack)) {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     if (player.f_36078_ < 5) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     player.m_36335_().m_41524_(usedStack.m_41720_(), 250);
/* 54 */     player.m_6749_(-5);
/*    */     
/* 56 */     if (!(player.m_150110_()).f_35937_) {
/* 57 */       usedStack.m_41774_(1);
/*    */     }
/*    */     
/* 60 */     final double x = clickedPos.m_123341_() + 0.5D;
/* 61 */     final double y = clickedPos.m_123342_() + 1.0D;
/* 62 */     final double z = clickedPos.m_123343_() + 0.5D;
/* 63 */     final float yaw = player.m_146908_();
/*    */     
/* 65 */     serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123815_, x, y, z, 40, 0.0D, 3.0D, 0.0D, 1.0D);
/* 66 */     serverLevel.m_5594_(null, clickedPos, SoundEvents.f_11932_, SoundSource.NEUTRAL, 1.0F, 2.0F);
/* 67 */     VillagerUtil.launchBlackCreeperSignalFirework(serverLevel, x, y, z);
/*    */     
/* 69 */     new DelayedTask(50)
/*    */       {
/*    */         public void run() {
/* 72 */           BlockPos signalPos = BlockPos.m_274561_(x, y, z);
/* 73 */           if (!serverLevel.m_46749_(signalPos)) {
/*    */             return;
/*    */           }
/*    */           
/* 77 */           serverLevel.m_5594_(null, signalPos, SoundEvents.f_11871_, SoundSource.NEUTRAL, 1.0F, 2.0F);
/* 78 */           VillagerUtil.summonRandomVillagerSupportWave(serverLevel, new Vec3(x, y, z), yaw);
/*    */         }
/*    */       };
/*    */     
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\FireworkUseEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */