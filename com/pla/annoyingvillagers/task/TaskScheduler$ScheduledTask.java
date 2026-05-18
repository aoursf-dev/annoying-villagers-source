/*    */ package com.pla.annoyingvillagers.task;
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
/*    */ class ScheduledTask
/*    */ {
/*    */   Runnable task;
/*    */   int ticksRemaining;
/*    */   
/*    */   ScheduledTask(Runnable task, int ticks) {
/* 51 */     this.task = task;
/* 52 */     this.ticksRemaining = ticks;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\task\TaskScheduler$ScheduledTask.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */