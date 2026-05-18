/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import com.pla.annoyingvillagers.util.VillagerUtil;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.phys.Vec3;
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
/*    */   extends DelayedTask
/*    */ {
/*    */   null(int waitTicks) {
/* 69 */     super(waitTicks);
/*    */   }
/*    */   public void run() {
/* 72 */     BlockPos signalPos = BlockPos.m_274561_(x, y, z);
/* 73 */     if (!serverLevel.m_46749_(signalPos)) {
/*    */       return;
/*    */     }
/*    */     
/* 77 */     serverLevel.m_5594_(null, signalPos, SoundEvents.f_11871_, SoundSource.NEUTRAL, 1.0F, 2.0F);
/* 78 */     VillagerUtil.summonRandomVillagerSupportWave(serverLevel, new Vec3(x, y, z), yaw);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\FireworkUseEvent$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */