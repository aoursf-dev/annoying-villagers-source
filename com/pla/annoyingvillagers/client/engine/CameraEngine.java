/*     */ package com.pla.annoyingvillagers.client.engine;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.PriorityQueue;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.player.LocalPlayer;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.client.event.ViewportEvent;
/*     */ import net.minecraftforge.eventbus.api.EventPriority;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
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
/*     */ @OnlyIn(Dist.CLIENT)
/*     */ public class CameraEngine
/*     */ {
/*     */   private static CameraEngine instance;
/*     */   private final PriorityQueue<ShakeEntry> queue;
/*     */   private final ShakeEntry default_entry;
/*     */   
/*     */   public CameraEngine() {
/*  46 */     this
/*  47 */       .queue = new PriorityQueue<>(Comparator.comparingDouble(e -> -e.strength));
/*  48 */     this.default_entry = new ShakeEntry(1.0D, 3, 0.3D, 0);
/*     */     instance = this;
/*  50 */   } public static CameraEngine getInstance() { return instance; } public void tick(ViewportEvent.ComputeCameraAngles event, Player player) { if (Minecraft.m_91087_().m_91104_() || this.queue.isEmpty())
/*     */       return; 
/*  52 */     this.queue.removeIf(entry -> {
/*     */           entry.remainingTicks--;
/*     */           
/*     */           if (entry.remainingTicks < entry.decay_time) {
/*     */             entry.strength *= 0.97D;
/*     */             entry.frequency *= 0.97D;
/*     */           } 
/*     */           return (entry.remainingTicks <= 0);
/*     */         });
/*  61 */     if (!this.queue.isEmpty()) {
/*  62 */       ShakeEntry top = this.queue.peek();
/*  63 */       double ticksExistedDelta = player.f_19797_ + event.getPartialTick();
/*  64 */       double k = top.strength / 4.0D;
/*  65 */       double f = top.frequency;
/*  66 */       event.setPitch((float)(event.getPitch() + k * Math.cos(ticksExistedDelta * f + 2.0D)));
/*  67 */       event.setYaw((float)(event.getYaw() + k * Math.cos(ticksExistedDelta * f + 1.0D)));
/*  68 */       event.setRoll((float)(event.getRoll() + k * Math.cos(ticksExistedDelta * f)));
/*     */     }  }
/*     */    public PriorityQueue<ShakeEntry> getQueue() {
/*     */     return this.queue;
/*     */   } public void shakeCamera(ShakeEntry entry) {
/*  73 */     ShakeEntry entry1 = entry.copy();
/*  74 */     this.queue.add(entry1);
/*     */   }
/*     */   public void shakeCamera(float strength, int time, float frequency, int decay_time) {
/*  77 */     shakeCamera(new ShakeEntry(strength, time, frequency, decay_time));
/*     */   }
/*     */   public void shakeCamera(int time, float strength, int decay_time) {
/*  80 */     shakeCamera(new ShakeEntry(strength, time, 0.3D, decay_time));
/*     */   }
/*     */   
/*     */   @EventBusSubscriber(modid = "annoyingvillagers", value = {Dist.CLIENT})
/*     */   public static class Events {
/*     */     @SubscribeEvent(priority = EventPriority.LOW)
/*     */     public static void cameraSetupEvent(ViewportEvent.ComputeCameraAngles event) {
/*  87 */       LocalPlayer localPlayer = (Minecraft.m_91087_()).f_91074_;
/*  88 */       if (localPlayer == null)
/*  89 */         return;  if (CameraEngine.instance == null)
/*     */         return; 
/*  91 */       CameraEngine.instance.tick(event, (Player)localPlayer);
/*     */     } }
/*     */   
/*     */   public static class ShakeEntry {
/*     */     double strength;
/*     */     int remainingTicks;
/*     */     int decay_time;
/*     */     double frequency;
/*     */     
/*     */     public ShakeEntry(double strength, int tick, double frequency, int decay_time) {
/* 101 */       this.strength = strength;
/* 102 */       this.remainingTicks = tick;
/* 103 */       this.frequency = frequency;
/* 104 */       this.decay_time = decay_time;
/*     */     }
/*     */     public ShakeEntry(double strength, int tick, int decay_time) {
/* 107 */       this(strength, tick, 0.30000001192092896D, decay_time);
/*     */     }
/*     */     
/*     */     public ShakeEntry copy() {
/* 111 */       return new ShakeEntry(this.strength, this.remainingTicks, this.frequency, this.decay_time);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\CameraEngine.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */