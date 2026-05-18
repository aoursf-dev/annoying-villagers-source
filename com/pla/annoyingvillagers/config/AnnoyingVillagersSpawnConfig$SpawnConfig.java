/*    */ package com.pla.annoyingvillagers.config;public final class SpawnConfig extends Record { private final int weight; private final int minCount; private final int maxCount;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;
/*    */   }
/*    */   
/* 11 */   public SpawnConfig(int weight, int minCount, int maxCount) { this.weight = weight; this.minCount = minCount; this.maxCount = maxCount; } public int weight() { return this.weight; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public int minCount() { return this.minCount; } public int maxCount() { return this.maxCount; }
/*    */    }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\config\AnnoyingVillagersSpawnConfig$SpawnConfig.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */