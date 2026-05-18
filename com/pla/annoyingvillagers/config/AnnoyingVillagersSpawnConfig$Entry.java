/*    */ package com.pla.annoyingvillagers.config;public final class Entry extends Record { private final String entityId; private final String configKey; private final AnnoyingVillagersSpawnConfig.SpawnConfig defaultConfig;
/*    */   private final boolean groupSizeConfigurable;
/*    */   private final String comment;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;
/*    */   }
/*    */   
/* 13 */   public Entry(String entityId, String configKey, AnnoyingVillagersSpawnConfig.SpawnConfig defaultConfig, boolean groupSizeConfigurable, String comment) { this.entityId = entityId; this.configKey = configKey; this.defaultConfig = defaultConfig; this.groupSizeConfigurable = groupSizeConfigurable; this.comment = comment; } public String entityId() { return this.entityId; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public String configKey() { return this.configKey; } public AnnoyingVillagersSpawnConfig.SpawnConfig defaultConfig() { return this.defaultConfig; } public boolean groupSizeConfigurable() { return this.groupSizeConfigurable; } public String comment() { return this.comment; }
/*    */    }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\config\AnnoyingVillagersSpawnConfig$Entry.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */