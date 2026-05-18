/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
/*    */ 
/*    */ public final class ExplosionFxMute {
/*  6 */   private static final Long2LongOpenHashMap muteUntilTick = new Long2LongOpenHashMap();
/*    */   
/*    */   public static void mark(long key, long untilTick) {
/*  9 */     muteUntilTick.put(key, untilTick);
/*    */   }
/*    */   
/*    */   public static boolean shouldMute(long key, long currentTick) {
/* 13 */     long until = muteUntilTick.getOrDefault(key, Long.MIN_VALUE);
/* 14 */     if (until == Long.MIN_VALUE) return false; 
/* 15 */     if (currentTick <= until) return true; 
/* 16 */     muteUntilTick.remove(key);
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\ExplosionFxMute.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */