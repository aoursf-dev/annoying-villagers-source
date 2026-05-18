/*     */ package com.pla.annoyingvillagers.task;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraftforge.event.TickEvent;
/*     */ import net.minecraftforge.event.server.ServerStoppedEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Scheduler
/*     */ {
/*  94 */   private final List<DelayedTask> activeTasks = new ArrayList<>();
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onServerTick(TickEvent.ServerTickEvent event) {
/*  98 */     if (event.phase != TickEvent.Phase.END) {
/*     */       return;
/*     */     }
/*     */     
/*     */     DelayedTask pendingTask;
/* 103 */     while ((pendingTask = DelayedTask.PENDING_ADD.poll()) != null) {
/* 104 */       this.activeTasks.add(pendingTask);
/*     */     }
/*     */     
/* 107 */     Iterator<DelayedTask> iterator = this.activeTasks.iterator();
/* 108 */     while (iterator.hasNext()) {
/* 109 */       DelayedTask task = iterator.next();
/* 110 */       if (task.tickInternal()) {
/* 111 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onServerStopped(ServerStoppedEvent event) {
/* 118 */     this.activeTasks.clear();
/* 119 */     DelayedTask.PENDING_ADD.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\task\DelayedTask$Scheduler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */