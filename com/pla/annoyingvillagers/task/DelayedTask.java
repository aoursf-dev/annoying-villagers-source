/*     */ package com.pla.annoyingvillagers.task;
/*     */ 
/*     */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.TickEvent;
/*     */ import net.minecraftforge.event.server.ServerStoppedEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ 
/*     */ public abstract class DelayedTask
/*     */ {
/*  16 */   private static final Scheduler SCHEDULER = new Scheduler();
/*  17 */   private static final Queue<DelayedTask> PENDING_ADD = new ConcurrentLinkedQueue<>();
/*     */   
/*     */   private static boolean schedulerRegistered = false;
/*     */   private int remainingTicks;
/*     */   private boolean cancelled = false;
/*     */   private boolean finished = false;
/*     */   
/*     */   public DelayedTask(int waitTicks) {
/*  25 */     if (waitTicks < 0) {
/*  26 */       throw new IllegalArgumentException("waitTicks must be >= 0");
/*     */     }
/*     */     
/*  29 */     this.remainingTicks = waitTicks;
/*  30 */     ensureSchedulerRegistered();
/*  31 */     PENDING_ADD.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract void run();
/*     */   
/*     */   protected void onCancel() {}
/*     */   
/*     */   public final void cancel() {
/*  40 */     this.cancelled = true;
/*     */   }
/*     */   
/*     */   public final boolean isCancelled() {
/*  44 */     return this.cancelled;
/*     */   }
/*     */   
/*     */   public final boolean isFinished() {
/*  48 */     return this.finished;
/*     */   }
/*     */   
/*     */   public final int getRemainingTicks() {
/*  52 */     return Math.max(this.remainingTicks, 0);
/*     */   }
/*     */   
/*     */   private boolean tickInternal() {
/*  56 */     if (this.finished) {
/*  57 */       return true;
/*     */     }
/*     */     
/*  60 */     if (this.cancelled) {
/*  61 */       this.finished = true;
/*  62 */       safeRun(this::onCancel, "DelayedTask onCancel");
/*  63 */       return true;
/*     */     } 
/*     */     
/*  66 */     if (this.remainingTicks > 0) {
/*  67 */       this.remainingTicks--;
/*  68 */       if (this.remainingTicks > 0) {
/*  69 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  73 */     this.finished = true;
/*  74 */     safeRun(this::run, "DelayedTask run");
/*  75 */     return true;
/*     */   }
/*     */   
/*     */   private static synchronized void ensureSchedulerRegistered() {
/*  79 */     if (!schedulerRegistered) {
/*  80 */       MinecraftForge.EVENT_BUS.register(SCHEDULER);
/*  81 */       schedulerRegistered = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void safeRun(Runnable action, String label) {
/*     */     try {
/*  87 */       action.run();
/*  88 */     } catch (Exception e) {
/*  89 */       AnnoyingVillagers.LOGGER.error("[AV MOD DEBUG] {} failed", label, e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final class Scheduler {
/*  94 */     private final List<DelayedTask> activeTasks = new ArrayList<>();
/*     */     
/*     */     @SubscribeEvent
/*     */     public void onServerTick(TickEvent.ServerTickEvent event) {
/*  98 */       if (event.phase != TickEvent.Phase.END) {
/*     */         return;
/*     */       }
/*     */       
/*     */       DelayedTask pendingTask;
/* 103 */       while ((pendingTask = DelayedTask.PENDING_ADD.poll()) != null) {
/* 104 */         this.activeTasks.add(pendingTask);
/*     */       }
/*     */       
/* 107 */       Iterator<DelayedTask> iterator = this.activeTasks.iterator();
/* 108 */       while (iterator.hasNext()) {
/* 109 */         DelayedTask task = iterator.next();
/* 110 */         if (task.tickInternal()) {
/* 111 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     @SubscribeEvent
/*     */     public void onServerStopped(ServerStoppedEvent event) {
/* 118 */       this.activeTasks.clear();
/* 119 */       DelayedTask.PENDING_ADD.clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\task\DelayedTask.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */