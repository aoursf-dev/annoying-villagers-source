/*    */ package com.pla.annoyingvillagers.util;
/*    */ import com.pla.annoyingvillagers.entity.ShockWaveBlockEntity;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.RenderShape;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ 
/*    */ public class ShockwaveUtil {
/*    */   public static void spawnCircleRing(ServerLevel level, BlockPos centerPos, int radius, LivingEntity owner) {
/* 12 */     double inner = (radius - 0.5D) * (radius - 0.5D);
/* 13 */     double outer = (radius + 0.5D) * (radius + 0.5D);
/*    */     
/* 15 */     for (int dx = -radius; dx <= radius; dx++) {
/* 16 */       for (int dz = -radius; dz <= radius; dz++) {
/* 17 */         double dist2 = dx * dx + dz * dz;
/* 18 */         if (dist2 >= inner && dist2 <= outer) {
/* 19 */           spawnShockWaveBlock(level, centerPos.m_7918_(dx, 0, dz), owner);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void spawnShockWaveBlock(ServerLevel level, BlockPos startPos, LivingEntity owner) {
/* 26 */     int BLOCK_SEARCH_DEPTH = 256;
/* 27 */     int ENTITY_GROUND_LIFETIME = 10;
/*    */     
/* 29 */     BlockPos pos = startPos;
/* 30 */     BlockState state = level.m_8055_(pos);
/*    */     
/* 32 */     int minY = level.m_141937_();
/*    */     
/* 34 */     for (int i = 0; i < 256 && pos.m_123342_() > minY && state.m_60799_() != RenderShape.MODEL; i++) {
/* 35 */       pos = pos.m_7495_();
/* 36 */       state = level.m_8055_(pos);
/*    */     } 
/*    */     
/* 39 */     if (state.m_60799_() != RenderShape.MODEL) {
/*    */       return;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 45 */     ShockWaveBlockEntity blockEntity = new ShockWaveBlockEntity((Level)level, pos.m_123341_() + 0.5D, pos.m_123342_() + 1.0D, pos.m_123343_() + 0.5D, state, 10);
/*    */ 
/*    */ 
/*    */     
/* 49 */     blockEntity.setOwnerUuid(owner.m_20148_());
/* 50 */     level.m_7967_((Entity)blockEntity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\ShockwaveUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */