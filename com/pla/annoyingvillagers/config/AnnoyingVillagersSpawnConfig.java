/*     */ package com.pla.annoyingvillagers.config;
/*     */ public final class AnnoyingVillagersSpawnConfig { private static final int WEIGHT_MIN = 0;
/*     */   private static final int WEIGHT_MAX = 1000;
/*     */   private static final int COUNT_MIN = 1;
/*     */   private static final int COUNT_MAX = 64;
/*     */   
/*     */   public static final class SpawnConfig extends Record { private final int weight;
/*     */     private final int minCount;
/*     */     private final int maxCount;
/*     */     
/*  11 */     public SpawnConfig(int weight, int minCount, int maxCount) { this.weight = weight; this.minCount = minCount; this.maxCount = maxCount; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #11	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*  11 */       //   0	7	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig; } public int weight() { return this.weight; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #11	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #11	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$SpawnConfig;
/*  11 */       //   0	8	1	o	Ljava/lang/Object; } public int minCount() { return this.minCount; } public int maxCount() { return this.maxCount; }
/*     */      } public static final class Entry extends Record { private final String entityId; private final String configKey; private final AnnoyingVillagersSpawnConfig.SpawnConfig defaultConfig; private final boolean groupSizeConfigurable; private final String comment;
/*  13 */     public Entry(String entityId, String configKey, AnnoyingVillagersSpawnConfig.SpawnConfig defaultConfig, boolean groupSizeConfigurable, String comment) { this.entityId = entityId; this.configKey = configKey; this.defaultConfig = defaultConfig; this.groupSizeConfigurable = groupSizeConfigurable; this.comment = comment; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #13	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #13	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #13	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lcom/pla/annoyingvillagers/config/AnnoyingVillagersSpawnConfig$Entry;
/*  13 */       //   0	8	1	o	Ljava/lang/Object; } public String entityId() { return this.entityId; } public String configKey() { return this.configKey; } public AnnoyingVillagersSpawnConfig.SpawnConfig defaultConfig() { return this.defaultConfig; } public boolean groupSizeConfigurable() { return this.groupSizeConfigurable; } public String comment() { return this.comment; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  26 */   public static final List<Entry> ENTRIES = List.of((Object[])new Entry[] { 
/*  27 */         configurableGroupEntry("player_npc", 6, 2, 4, "Player NPC"), 
/*  28 */         configurableGroupEntry("villager_scout", 4, 1, 4, "Villager Scout"), 
/*  29 */         configurableGroupEntry("villager_scout_captain", 3, 1, 2, "Villager Scout Captain"), 
/*  30 */         configurableGroupEntry("purple_villager_general", 3, 1, 2, "Purple Villager General"), 
/*  31 */         configurableGroupEntry("red_villager_general", 3, 1, 2, "Red Villager General"), 
/*  32 */         configurableGroupEntry("blue_villager_general", 3, 1, 2, "Blue Villager General"), 
/*  33 */         configurableGroupEntry("green_villager_general", 3, 1, 2, "Green Villager General"), 
/*     */         
/*  35 */         fixedGroupEntry("steve", 1, "Steve"), 
/*  36 */         fixedGroupEntry("alex", 1, "Alex"), 
/*  37 */         fixedGroupEntry("chris", 1, "Chris"), 
/*  38 */         fixedGroupEntry("blue_demon", 1, "Blue Demon"), 
/*     */         
/*  40 */         fixedGroupEntry("low_shadow_herobrine_clone", 1, "Netherite Herobrine"), 
/*  41 */         fixedGroupEntry("herobrine_clone", 1, "Herobrine Clone"), 
/*  42 */         fixedGroupEntry("shadow_herobrine_clone", 1, "Shadow Herobrine Clone"), 
/*  43 */         fixedGroupEntry("armored_herobrine", 1, "Armored Herobrine"), 
/*  44 */         fixedGroupEntry("herobrine_7", 1, "Herobrine 7"), 
/*  45 */         fixedGroupEntry("herobrine_chris", 1, "Herobrine Chris"), 
/*  46 */         fixedGroupEntry("herobrine_greg", 1, "Herobrine Greg") });
/*     */ 
/*     */   
/*     */   public static final ForgeConfigSpec SPEC;
/*     */   
/*  51 */   private static final Map<String, Entry> entryByEntityId = new HashMap<>();
/*  52 */   private static final Map<String, ForgeConfigSpec.IntValue> weightValueByEntityId = new HashMap<>();
/*  53 */   private static final Map<String, ForgeConfigSpec.ConfigValue<List<? extends Number>>> tripleValueByEntityId = new HashMap<>();
/*     */   
/*     */   static {
/*  56 */     ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
/*  57 */     configBuilder.push("spawning");
/*     */     
/*  59 */     for (Entry entry : ENTRIES) {
/*  60 */       entryByEntityId.put(entry.entityId(), entry);
/*     */       
/*  62 */       if (entry.groupSizeConfigurable()) {
/*     */ 
/*     */         
/*  65 */         ForgeConfigSpec.ConfigValue<List<? extends Number>> tripleValue = configBuilder.comment(entry.comment()).defineList(entry.configKey(), toDefaultList(entry.defaultConfig()), element -> element instanceof Number);
/*     */         
/*  67 */         tripleValueByEntityId.put(entry.entityId(), tripleValue);
/*     */         
/*     */         continue;
/*     */       } 
/*  71 */       ForgeConfigSpec.IntValue weightValue = configBuilder.comment(entry.comment()).defineInRange(entry.configKey(), entry.defaultConfig().weight(), 0, 1000);
/*     */       
/*  73 */       weightValueByEntityId.put(entry.entityId(), weightValue);
/*     */     } 
/*     */ 
/*     */     
/*  77 */     configBuilder.pop();
/*  78 */     SPEC = configBuilder.build();
/*     */   }
/*     */   
/*     */   public static SpawnConfig getSpawnConfig(String entityId) {
/*  82 */     Entry entry = entryByEntityId.get(entityId);
/*  83 */     if (entry == null) {
/*  84 */       return new SpawnConfig(0, 1, 1);
/*     */     }
/*     */     
/*  87 */     if (!entry.groupSizeConfigurable()) {
/*  88 */       ForgeConfigSpec.IntValue weightValue = weightValueByEntityId.get(entityId);
/*  89 */       int weight = (weightValue != null) ? ((Integer)weightValue.get()).intValue() : entry.defaultConfig().weight();
/*  90 */       return new SpawnConfig(weight, 1, 1);
/*     */     } 
/*     */     
/*  93 */     ForgeConfigSpec.ConfigValue<List<? extends Number>> tripleValue = tripleValueByEntityId.get(entityId);
/*  94 */     if (tripleValue == null) {
/*  95 */       return entry.defaultConfig();
/*     */     }
/*     */     
/*  98 */     return parseTripleOrDefault((List<? extends Number>)tripleValue.get(), entry.defaultConfig());
/*     */   }
/*     */   
/*     */   private static SpawnConfig parseTripleOrDefault(List<? extends Number> rawValues, SpawnConfig defaultConfig) {
/* 102 */     if (rawValues == null || rawValues.size() != 3) {
/* 103 */       return defaultConfig;
/*     */     }
/*     */     
/* 106 */     Integer parsedWeight = toExactInteger(rawValues.get(0));
/* 107 */     Integer parsedMinCount = toExactInteger(rawValues.get(1));
/* 108 */     Integer parsedMaxCount = toExactInteger(rawValues.get(2));
/*     */     
/* 110 */     if (parsedWeight == null || parsedMinCount == null || parsedMaxCount == null) {
/* 111 */       return defaultConfig;
/*     */     }
/*     */     
/* 114 */     if (parsedWeight.intValue() < 0 || parsedWeight.intValue() > 1000) {
/* 115 */       return defaultConfig;
/*     */     }
/* 117 */     if (parsedMinCount.intValue() < 1 || parsedMinCount.intValue() > 64) {
/* 118 */       return defaultConfig;
/*     */     }
/* 120 */     if (parsedMaxCount.intValue() < 1 || parsedMaxCount.intValue() > 64) {
/* 121 */       return defaultConfig;
/*     */     }
/* 123 */     if (parsedMaxCount.intValue() < parsedMinCount.intValue()) {
/* 124 */       return defaultConfig;
/*     */     }
/*     */     
/* 127 */     return new SpawnConfig(parsedWeight.intValue(), parsedMinCount.intValue(), parsedMaxCount.intValue());
/*     */   }
/*     */   
/*     */   private static Integer toExactInteger(Number number) {
/* 131 */     if (number == null) return null;
/*     */     
/* 133 */     double valueAsDouble = number.doubleValue();
/* 134 */     long roundedValue = Math.round(valueAsDouble);
/*     */     
/* 136 */     if (Math.abs(valueAsDouble - roundedValue) > 1.0E-9D) return null; 
/* 137 */     if (roundedValue < -2147483648L || roundedValue > 2147483647L) return null;
/*     */     
/* 139 */     return Integer.valueOf((int)roundedValue);
/*     */   }
/*     */   
/*     */   private static List<? extends Number> toDefaultList(SpawnConfig defaultConfig) {
/* 143 */     return List.of(
/* 144 */         Integer.valueOf(defaultConfig.weight()), 
/* 145 */         Integer.valueOf(defaultConfig.minCount()), 
/* 146 */         Integer.valueOf(defaultConfig.maxCount()));
/*     */   }
/*     */ 
/*     */   
/*     */   private static Entry fixedGroupEntry(String entityId, int defaultWeight, String name) {
/* 151 */     String configKey = "spawn_" + entityId;
/*     */     
/* 153 */     String comment = String.format(Locale.ROOT, "Spawn config for %s. Format: weight (int). Weight is added to the spawn pool in each biome. Group size is fixed at 1 and is NOT configurable", new Object[] { name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     return new Entry(entityId, configKey, new SpawnConfig(defaultWeight, 1, 1), false, comment);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Entry configurableGroupEntry(String entityId, int defaultWeight, int defaultMinCount, int defaultMaxCount, String name) {
/* 169 */     String configKey = "spawn_" + entityId;
/*     */     
/* 171 */     String comment = String.format(Locale.ROOT, "Spawn config for %s. Format: [weight, minCount, maxCount]. Weight is added to the spawn pool in each biome (higher = more common, 0 = disable). minCount/maxCount control group size", new Object[] { name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     return new Entry(entityId, configKey, new SpawnConfig(defaultWeight, defaultMinCount, defaultMaxCount), true, comment);
/*     */   } }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\config\AnnoyingVillagersSpawnConfig.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */