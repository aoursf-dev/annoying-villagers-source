/*     */ package com.pla.annoyingvillagers.client.engine;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShakeEntry
/*     */ {
/*     */   double strength;
/*     */   int remainingTicks;
/*     */   int decay_time;
/*     */   double frequency;
/*     */   
/*     */   public ShakeEntry(double strength, int tick, double frequency, int decay_time) {
/* 101 */     this.strength = strength;
/* 102 */     this.remainingTicks = tick;
/* 103 */     this.frequency = frequency;
/* 104 */     this.decay_time = decay_time;
/*     */   }
/*     */   public ShakeEntry(double strength, int tick, int decay_time) {
/* 107 */     this(strength, tick, 0.30000001192092896D, decay_time);
/*     */   }
/*     */   
/*     */   public ShakeEntry copy() {
/* 111 */     return new ShakeEntry(this.strength, this.remainingTicks, this.frequency, this.decay_time);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\CameraEngine$ShakeEntry.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */