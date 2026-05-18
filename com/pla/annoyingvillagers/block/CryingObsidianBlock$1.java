/*    */ package com.pla.annoyingvillagers.block;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
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
/* 93 */     super(waitTicks);
/*    */   }
/*    */   public void run() {
/* 96 */     serverLevel.m_6263_(null, blockPos
/*    */         
/* 98 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.POP
/* 99 */         .get(), SoundSource.BLOCKS, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\block\CryingObsidianBlock$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */