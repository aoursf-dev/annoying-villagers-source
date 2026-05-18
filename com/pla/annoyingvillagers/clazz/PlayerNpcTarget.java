/*    */ package com.pla.annoyingvillagers.clazz;
/*    */ 
/*    */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*    */ import net.minecraft.util.RandomSource;
/*    */ 
/*    */ public enum PlayerNpcTarget
/*    */ {
/*  8 */   MONSTER_HUNTER(((Double)AnnoyingVillagersConfig.NPC_TARGET_WEIGHT_MONSTER_HUNTER.get()).doubleValue()),
/*  9 */   VILLAGER_HUNTER(((Double)AnnoyingVillagersConfig.NPC_TARGET_WEIGHT_VILLAGER_HUNTER.get()).doubleValue()),
/* 10 */   PLAYER_HUNTER(((Double)AnnoyingVillagersConfig.NPC_TARGET_WEIGHT_PLAYER_HUNTER.get()).doubleValue()),
/* 11 */   HOSTILE_HUNTER(((Double)AnnoyingVillagersConfig.NPC_TARGET_WEIGHT_HOSTILE_HUNTER.get()).doubleValue()),
/* 12 */   PASSIVE_HUNTER(((Double)AnnoyingVillagersConfig.NPC_TARGET_WEIGHT_PASSIVE_HUNTER.get()).doubleValue()),
/* 13 */   ANIMAL_HUNTER(((Double)AnnoyingVillagersConfig.NPC_TARGET_WEIGHT_ANIMAL_HUNTER.get()).doubleValue());
/*    */ 
/*    */   
/*    */   private final double weight;
/*    */ 
/*    */   
/*    */   PlayerNpcTarget(double weight) {
/* 20 */     if (weight < 0.0D) throw new IllegalArgumentException("weight must be >= 0"); 
/* 21 */     this.weight = weight;
/*    */   }
/*    */   
/*    */   public double getWeight() {
/* 25 */     return this.weight;
/*    */   }
/*    */   
/*    */   public static PlayerNpcTarget randomByWeight(RandomSource randomSource) {
/* 29 */     double total = 0.0D;
/* 30 */     for (PlayerNpcTarget playerNpcTarget : values()) total += playerNpcTarget.weight; 
/* 31 */     if (total <= 0.0D) {
/* 32 */       PlayerNpcTarget[] value = values();
/* 33 */       return value[randomSource.m_188503_(value.length)];
/*    */     } 
/*    */     
/* 36 */     double random = randomSource.m_188500_() * total;
/* 37 */     for (PlayerNpcTarget playerNpcTarget : values()) {
/* 38 */       random -= playerNpcTarget.weight;
/* 39 */       if (random < 0.0D) return playerNpcTarget; 
/*    */     } 
/* 41 */     return values()[(values()).length - 1];
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\PlayerNpcTarget.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */