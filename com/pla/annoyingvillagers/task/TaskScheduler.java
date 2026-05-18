/*    */ package com.pla.annoyingvillagers.task;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class TaskScheduler
/*    */ {
/* 13 */   private static final List<ScheduledTask> tasks = new LinkedList<>();
/* 14 */   private static final List<ScheduledTask> pendingTasks = new LinkedList<>();
/*    */   
/*    */   public static void schedule(Runnable task, int delayTicks) {
/* 17 */     synchronized (pendingTasks) {
/* 18 */       pendingTasks.add(new ScheduledTask(task, delayTicks));
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onServerTick(TickEvent.ServerTickEvent event) {
/* 24 */     if (event.phase != TickEvent.Phase.END)
/*    */       return; 
/* 26 */     synchronized (pendingTasks) {
/* 27 */       tasks.addAll(pendingTasks);
/* 28 */       pendingTasks.clear();
/*    */     } 
/*    */     
/* 31 */     Iterator<ScheduledTask> iterator = tasks.iterator();
/* 32 */     while (iterator.hasNext()) {
/* 33 */       ScheduledTask task = iterator.next();
/* 34 */       task.ticksRemaining--;
/* 35 */       if (task.ticksRemaining <= 0) {
/*    */         try {
/* 37 */           task.task.run();
/* 38 */         } catch (Exception e) {
/* 39 */           e.printStackTrace();
/*    */         } 
/* 41 */         iterator.remove();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static class ScheduledTask {
/*    */     Runnable task;
/*    */     int ticksRemaining;
/*    */     
/*    */     ScheduledTask(Runnable task, int ticks) {
/* 51 */       this.task = task;
/* 52 */       this.ticksRemaining = ticks;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\task\TaskScheduler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */