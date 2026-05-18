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
/*     */ public class Timestamp
/*     */ {
/*     */   private final long ticks;
/*     */   private final float partial;
/*     */   
/*     */   public Timestamp() {
/* 115 */     this(0L, 0.0F);
/*     */   }
/*     */   
/*     */   public Timestamp(long ticks, float partial) {
/* 119 */     this.ticks = ticks;
/* 120 */     this.partial = partial;
/*     */   }
/*     */   
/*     */   public Timestamp subtract(Timestamp other) {
/* 124 */     long newTicks = this.ticks - other.ticks;
/* 125 */     float newPartial = this.partial - other.partial;
/* 126 */     if (newPartial < 0.0F) {
/* 127 */       newPartial++;
/* 128 */       newTicks--;
/*     */     } 
/* 130 */     return new Timestamp(newTicks, newPartial);
/*     */   }
/*     */   
/*     */   public float value() {
/* 134 */     return (float)this.ticks + this.partial;
/*     */   }
/*     */   
/*     */   public boolean isPassed(Timestamp prev, double duration) {
/* 138 */     long ticksPassed = this.ticks - prev.ticks;
/* 139 */     if (ticksPassed > duration)
/* 140 */       return true; 
/* 141 */     duration -= ticksPassed;
/* 142 */     if (duration >= 1.0D)
/* 143 */       return false; 
/* 144 */     return ((this.partial - prev.partial) >= duration);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\ThunderRender$Timestamp.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */