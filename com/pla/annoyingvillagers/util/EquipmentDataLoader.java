/*     */ package com.pla.annoyingvillagers.util;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Random;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.packs.resources.ResourceManager;
/*     */ import net.minecraft.util.profiling.ProfilerFiller;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.capabilities.item.WeaponCapability;
/*     */ 
/*     */ public class EquipmentDataLoader extends SimpleJsonResourceReloadListener {
/*  23 */   private static final Gson GSON = new Gson();
/*  24 */   private static final Random RANDOM = new Random();
/*  25 */   private static final Map<String, List<String>> EQUIP_ITEMS = new HashMap<>();
/*  26 */   private static final Logger LOGGER = LogManager.getLogger();
/*     */   
/*     */   public EquipmentDataLoader() {
/*  29 */     super(GSON, "mobs_equipment");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void apply(Map<ResourceLocation, JsonElement> map, ResourceManager manager, ProfilerFiller profiler) {
/*  34 */     EQUIP_ITEMS.clear();
/*  35 */     for (Map.Entry<ResourceLocation, JsonElement> entry : map.entrySet()) {
/*  36 */       ResourceLocation fileId = entry.getKey();
/*  37 */       JsonObject root = GsonHelper.m_13918_(entry.getValue(), "equipment");
/*     */       
/*  39 */       String modId = fileId.m_135815_().replace(".json", "");
/*     */       
/*  41 */       if (!ModList.get().isLoaded(modId)) {
/*     */         continue;
/*     */       }
/*     */       
/*  45 */       for (String slot : List.of("MAINHAND", "OFFHAND", "HEAD", "CHEST", "LEGS", "FEET")) {
/*  46 */         if (!root.has(slot))
/*     */           continue; 
/*  48 */         JsonArray array = root.getAsJsonArray(slot);
/*  49 */         List<String> items = EQUIP_ITEMS.computeIfAbsent(slot, k -> new ArrayList());
/*     */         
/*  51 */         for (JsonElement el : array) {
/*  52 */           String itemName = el.getAsString();
/*  53 */           items.add(modId + ":" + modId);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean addMoreDualCap(WeaponCapability weaponCapability) {
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean addMoreShieldCap(WeaponCapability weaponCapability) {
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canUseShield(ItemStack stack) {
/*  68 */     CapabilityItem cap = EpicFightCapabilities.getItemStackCapability(stack);
/*     */     
/*  70 */     if (cap instanceof WeaponCapability) { WeaponCapability weaponCapability = (WeaponCapability)cap;
/*  71 */       return (weaponCapability.getWeaponCategory() == CapabilityItem.WeaponCategories.SWORD || weaponCapability
/*  72 */         .getWeaponCategory() == CapabilityItem.WeaponCategories.LONGSWORD || weaponCapability
/*  73 */         .getWeaponCategory() == CapabilityItem.WeaponCategories.SPEAR || 
/*  74 */         addMoreShieldCap(weaponCapability)); }
/*     */ 
/*     */     
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canTwoHand(ItemStack stack) {
/*  81 */     CapabilityItem cap = EpicFightCapabilities.getItemStackCapability(stack);
/*     */     
/*  83 */     if (cap instanceof WeaponCapability) { WeaponCapability weaponCapability = (WeaponCapability)cap;
/*  84 */       return (weaponCapability.getWeaponCategory() == CapabilityItem.WeaponCategories.SWORD || weaponCapability
/*  85 */         .getWeaponCategory() == CapabilityItem.WeaponCategories.FIST || weaponCapability
/*  86 */         .getWeaponCategory() == CapabilityItem.WeaponCategories.DAGGER || 
/*  87 */         addMoreDualCap(weaponCapability)); }
/*     */ 
/*     */     
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public static int getRandomDamage(ItemStack itemStack) {
/*  94 */     int maxDamage = itemStack.m_41776_();
/*  95 */     int min = maxDamage / 3;
/*  96 */     int max = maxDamage * 3 / 4;
/*  97 */     int damage = RANDOM.nextInt(max - min + 1) + min;
/*  98 */     return damage;
/*     */   }
/*     */   
/*     */   public static List<String> getEquipCommands(float equipChanceArmor, Entity entity) {
/* 102 */     List<String> cmds = new ArrayList<>();
/* 103 */     String oneHandWeaponInMainHand = null;
/*     */     
/* 105 */     for (String slot : List.of("MAINHAND", "OFFHAND", "HEAD", "CHEST", "LEGS", "FEET")) {
/* 106 */       String itemId; List<String> pool = EQUIP_ITEMS.getOrDefault(slot, List.of());
/* 107 */       if (pool.isEmpty())
/*     */         continue; 
/* 109 */       boolean alwaysEquip = (slot.equals("MAINHAND") || slot.equals("OFFHAND"));
/* 110 */       if (!alwaysEquip && RANDOM.nextFloat() > equipChanceArmor) {
/*     */         continue;
/*     */       }
/* 113 */       if (slot.equals("OFFHAND") && oneHandWeaponInMainHand != null) {
/* 114 */         if ((new Random()).nextFloat() < 0.25F) {
/* 115 */           itemId = oneHandWeaponInMainHand;
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */       } else {
/* 120 */         itemId = pool.get(RANDOM.nextInt(pool.size()));
/*     */       } 
/*     */       
/* 123 */       String[] parts = itemId.split(":", 2);
/* 124 */       String namespace = parts[0];
/* 125 */       String path = parts[1];
/* 126 */       Item item = (Item)ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, path));
/* 127 */       if (item == null)
/* 128 */         continue;  int damage = 0;
/* 129 */       if (item.m_41465_()) {
/* 130 */         damage = getRandomDamage(new ItemStack((ItemLike)item));
/*     */       }
/* 132 */       cmds.add(String.format("item replace entity @s %s with %s{Damage:%d}", new Object[] { mapSlot(slot), itemId, Integer.valueOf(damage) }));
/*     */       
/* 134 */       ItemStack itemStack = new ItemStack((ItemLike)item);
/* 135 */       if (slot.equals("MAINHAND")) {
/* 136 */         if ((new Random()).nextBoolean()) {
/* 137 */           if (canTwoHand(itemStack)) {
/* 138 */             oneHandWeaponInMainHand = itemId; continue;
/* 139 */           }  if (canUseShield(itemStack))
/* 140 */             oneHandWeaponInMainHand = "minecraft:shield"; 
/*     */           continue;
/*     */         } 
/* 143 */         if (canUseShield(itemStack)) {
/* 144 */           oneHandWeaponInMainHand = "minecraft:shield"; continue;
/* 145 */         }  if (canTwoHand(itemStack)) {
/* 146 */           oneHandWeaponInMainHand = itemId;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 152 */     return cmds;
/*     */   }
/*     */   
/*     */   public static Optional<String> getRandomSpecificSlot(String slot) {
/* 156 */     List<String> pool = EQUIP_ITEMS.getOrDefault(slot, List.of());
/* 157 */     if (pool.isEmpty()) return Optional.empty();
/*     */     
/* 159 */     String itemId = pool.get(RANDOM.nextInt(pool.size()));
/* 160 */     String[] parts = itemId.split(":", 2);
/* 161 */     String namespace = parts[0];
/* 162 */     String path = parts[1];
/* 163 */     Item item = (Item)ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, path));
/* 164 */     if (item == null) return Optional.empty();
/*     */     
/* 166 */     int damage = 0;
/* 167 */     if (item.m_41465_()) {
/* 168 */       int maxDamage = (new ItemStack((ItemLike)item)).m_41776_();
/* 169 */       int min = maxDamage / 3;
/* 170 */       int max = maxDamage * 3 / 4;
/* 171 */       damage = RANDOM.nextInt(max - min + 1) + min;
/*     */     } 
/*     */     
/* 174 */     String command = String.format("item replace entity @s %s with %s{Damage:%d}", new Object[] { mapSlot(slot), itemId, Integer.valueOf(damage) });
/* 175 */     return Optional.of(command);
/*     */   }
/*     */   
/*     */   private static String mapSlot(String slot) {
/* 179 */     switch (slot) { case "MAINHAND": case "OFFHAND": case "HEAD": case "CHEST": case "LEGS": case "FEET":  }  return 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       slot.toLowerCase();
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\EquipmentDataLoader.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */