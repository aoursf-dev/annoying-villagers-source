/*     */ package com.pla.annoyingvillagers.init;
/*     */ 
/*     */ import com.pla.annoyingvillagers.item.EnchantedArrowItem;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.world.item.BlockItem;
/*     */ import net.minecraft.world.item.CreativeModeTab;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraftforge.common.ForgeSpawnEggItem;
/*     */ import net.minecraftforge.registries.DeferredRegister;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import net.minecraftforge.registries.RegistryObject;
/*     */ 
/*     */ public class AnnoyingVillagersModItems
/*     */ {
/*  16 */   public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "annoyingvillagers");
/*     */ 
/*     */   
/*  19 */   public static final RegistryObject<Item> BLUE_DEMON_SPAWN_EGG = REGISTRY.register("blue_demon_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.BLUE_DEMON, -16737895, -16777216, new Item.Properties()));
/*  20 */   public static final RegistryObject<Item> HEROBRINE_CLONE_SPAWN_EGG = REGISTRY.register("herobrine_clone_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.HEROBRINE_CLONE, -10066330, -13421773, new Item.Properties()));
/*  21 */   public static final RegistryObject<Item> SHADOW_HEROBRINE_CLONE_SPAWN_EGG = REGISTRY.register("shadow_herobrine_clone_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.SHADOW_HEROBRINE_CLONE, -10066330, -13421773, new Item.Properties()));
/*  22 */   public static final RegistryObject<Item> HEROBRINE_CHRIS_SPAWN_EGG = REGISTRY.register("herobrine_chris_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.HEROBRINE_CHRIS, -10066330, -13421773, new Item.Properties()));
/*  23 */   public static final RegistryObject<Item> HEROBRINE_GREG_SPAWN_EGG = REGISTRY.register("herobrine_greg_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.HEROBRINE_GREG, -3355648, -103, new Item.Properties()));
/*  24 */   public static final RegistryObject<Item> LOW_HEROBRINE_CLONE_SPAWN_EGG = REGISTRY.register("low_herobrine_clone_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.LOW_HEROBRINE_CLONE, -10066330, -13421773, new Item.Properties()));
/*  25 */   public static final RegistryObject<Item> LOW_SHADOW_HEROBRINE_CLONE_SPAWN_EGG = REGISTRY.register("low_shadow_herobrine_clone_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE, -10066330, -13421773, new Item.Properties()));
/*  26 */   public static final RegistryObject<Item> HEROBRINE_7_SPAWN_EGG = REGISTRY.register("herobrine_7_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.HEROBRINE_7, -1, -1, new Item.Properties()));
/*  27 */   public static final RegistryObject<Item> NULL_SPAWN_EGG = REGISTRY.register("null_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.NULL, -16777216, -10066330, new Item.Properties()));
/*  28 */   public static final RegistryObject<Item> ARMORED_HEROBRINE_SPAWN_EGG = REGISTRY.register("armored_herobrine_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.ARMORED_HEROBRINE, -16777216, -1, new Item.Properties()));
/*  29 */   public static final RegistryObject<Item> DARK_HEROBRINE_SPAWN_EGG = REGISTRY.register("shadow_herobrine_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.SHADOW_HEROBRINE, -1, -1, new Item.Properties()));
/*  30 */   public static final RegistryObject<Item> GLAIVE_HEROBRINE_SPAWN_EGG = REGISTRY.register("glaive_herobrine_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.GLAIVE_HEROBRINE, -1, -1, new Item.Properties()));
/*  31 */   public static final RegistryObject<Item> REAPER_HEROBRINE_SPAWN_EGG = REGISTRY.register("reaper_herobrine_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.REAPER_HEROBRINE, -13434727, -1, new Item.Properties()));
/*  32 */   public static final RegistryObject<Item> SWORDSMAN_HEROBRINE_SPAWN_EGG = REGISTRY.register("swordsman_herobrine_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.SWORDSMAN_HEROBRINE, -1, -1, new Item.Properties()));
/*  33 */   public static final RegistryObject<Item> AEGIS_HEROBRINE_SPAWN_EGG = REGISTRY.register("aegis_herobrine_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.AEGIS_HEROBRINE, -13434727, -1, new Item.Properties()));
/*  34 */   public static final RegistryObject<Item> SLEDGEHAMMER_HEROBRINE_SPAWN_EGG = REGISTRY.register("sledgehammer_herobrine_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.SLEDGEHAMMER_HEROBRINE, -1, -1, new Item.Properties()));
/*  35 */   public static final RegistryObject<Item> VILLAGER_SCOUT_SPAWN_EGG = REGISTRY.register("villager_scout_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.VILLAGER_SCOUT, -205, -26317, new Item.Properties()));
/*  36 */   public static final RegistryObject<Item> VILLAGER_SPAWN_EGG = REGISTRY.register("villager_scout_captain_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.VILLAGER_SCOUT_CAPTAIN, -1, -1, new Item.Properties()));
/*  37 */   public static final RegistryObject<Item> BLUE_VILLAGER_GENERAL_SPAWN_EGG = REGISTRY.register("blue_villager_general_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.BLUE_VILLAGER_GENERAL, -16711681, -6710887, new Item.Properties()));
/*  38 */   public static final RegistryObject<Item> GREEN_VILLAGER_GENERAL_SPAWN_EGG = REGISTRY.register("green_villager_general_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.GREEN_VILLAGER_GENERAL, -16724992, -1, new Item.Properties()));
/*  39 */   public static final RegistryObject<Item> RED_VILLAGER_GENERAL_SPAWN_EGG = REGISTRY.register("red_villager_general_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.RED_VILLAGER_GENERAL, -3407821, -13421773, new Item.Properties()));
/*  40 */   public static final RegistryObject<Item> PURPLE_VILLAGER_GENERAL_SPAWN_EGG = REGISTRY.register("purple_villager_general_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.PURPLE_VILLAGER_GENERAL, -3407668, -6710887, new Item.Properties()));
/*  41 */   public static final RegistryObject<Item> STEVE_SPAWN_EGG = REGISTRY.register("steve_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.STEVE, -16724788, -13421569, new Item.Properties()));
/*  42 */   public static final RegistryObject<Item> ANGRY_STEVE_SPAWN_EGG = REGISTRY.register("angry_steve_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.ANGRY_STEVE, -16724788, -13421569, new Item.Properties()));
/*  43 */   public static final RegistryObject<Item> ALEX_SPAWN_EGG = REGISTRY.register("alex_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.ALEX, -3342439, -1, new Item.Properties()));
/*  44 */   public static final RegistryObject<Item> JEV_SPAWN_EGG = REGISTRY.register("jev_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.JEV, -3342439, -1, new Item.Properties()));
/*  45 */   public static final RegistryObject<Item> CHRIS_SPAWN_EGG = REGISTRY.register("chris_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.CHRIS, -16737997, -6711040, new Item.Properties()));
/*  46 */   public static final RegistryObject<Item> PLAYER_NPC_SPAWN_EGG = REGISTRY.register("player_npc_spawn_egg", () -> new ForgeSpawnEggItem((Supplier)AnnoyingVillagersModEntities.PLAYER_NPC, -16737895, -16777216, new Item.Properties()));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   public static final RegistryObject<Item> ENCHANT_BED_ITEM = REGISTRY.register("enchant_bed_item", com.pla.annoyingvillagers.item.EnchantBedItem::new);
/*  52 */   public static final RegistryObject<Item> ENCHANTED_ARROW = REGISTRY.register("enchanted_arrow", () -> new EnchantedArrowItem(new Item.Properties()));
/*  53 */   public static final RegistryObject<Item> VILLAGER_HEAD = REGISTRY.register("villager_head", com.pla.annoyingvillagers.item.VillagerHeadItem::new);
/*  54 */   public static final RegistryObject<Item> JEV_GLASSES = REGISTRY.register("jev_glasses", com.pla.annoyingvillagers.item.JevGlassesItem::new);
/*  55 */   public static final RegistryObject<Item> ENCHANTED_ENDER_PEARL = REGISTRY.register("enchanted_ender_pearl", com.pla.annoyingvillagers.item.EnchantedEnderPearlItem::new);
/*  56 */   public static final RegistryObject<Item> JEV_BOOK = REGISTRY.register("jev_book", com.pla.annoyingvillagers.item.JevBookItem::new);
/*  57 */   public static final RegistryObject<Item> JEV_PENCIL = REGISTRY.register("jev_pencil", com.pla.annoyingvillagers.item.JevPencilItem::new);
/*  58 */   public static final RegistryObject<Item> POISON_EGG_ITEM = REGISTRY.register("poison_egg", com.pla.annoyingvillagers.item.PoisonEggItem::new);
/*  59 */   public static final RegistryObject<Item> ENDER_AEGIS_PROJECTILE = REGISTRY.register("ender_aegis_projectile", com.pla.annoyingvillagers.item.EnderAegisProjectileItem::new);
/*  60 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_BURST = REGISTRY.register("shadow_obsidian_burst", com.pla.annoyingvillagers.item.ShadowObsidianBurstItem::new);
/*  61 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_STRAIGHT = REGISTRY.register("shadow_obsidian_straight", com.pla.annoyingvillagers.item.ShadowObsidianStraightItem::new);
/*  62 */   public static final RegistryObject<Item> DEMONIAC_VOLTAGE_REAVER_BLADE = REGISTRY.register("demoniac_voltage_reaver_blade", com.pla.annoyingvillagers.item.DemoniacVoltageReaverBladeItem::new);
/*  63 */   public static final RegistryObject<Item> DEMONIAC_VOLTAGE_REAVER_FRAGMENT = REGISTRY.register("demoniac_voltage_reaver_fragment", com.pla.annoyingvillagers.item.DemoniacVoltageReaverFragmentItem::new);
/*  64 */   public static final RegistryObject<Item> DEMONIAC_VOLTAGE_REAVER_HILT = REGISTRY.register("demoniac_voltage_reaver_hilt", com.pla.annoyingvillagers.item.DemoniacVoltageReaverHiltItem::new);
/*  65 */   public static final RegistryObject<Item> ELITE_OBSIDIAN = REGISTRY.register("elite_obsidian", com.pla.annoyingvillagers.item.EliteObsidianItem::new);
/*  66 */   public static final RegistryObject<Item> ELITE_OBSIDIAN_LONG = REGISTRY.register("elite_obsidian_long", com.pla.annoyingvillagers.item.EliteObsidianLongItem::new);
/*  67 */   public static final RegistryObject<Item> ELITE_OBSIDIAN_BIG = REGISTRY.register("elite_obsidian_big", com.pla.annoyingvillagers.item.EliteObsidianBigItem::new);
/*  68 */   public static final RegistryObject<Item> VILLAGER_SCOUT_HELMET_FIX = REGISTRY.register("villager_scout_helmet_fix", com.pla.annoyingvillagers.item.VillagerScoutHelmetFixItem::new);
/*  69 */   public static final RegistryObject<Item> RED_VILLAGER_GENERAL_HELMET_FIX = REGISTRY.register("red_villager_general_helmet_fix", com.pla.annoyingvillagers.item.RedVillagerGeneralHelmetFixItem::new);
/*  70 */   public static final RegistryObject<Item> BLUE_VILLAGER_GENERAL_HELMET_FIX = REGISTRY.register("blue_villager_general_helmet_fix", com.pla.annoyingvillagers.item.BlueVillagerGeneralHelmetFixItem::new);
/*  71 */   public static final RegistryObject<Item> GREEN_VILLAGER_GENERAL_HELMET_FIX = REGISTRY.register("purple_villager_general_helmet_fix", com.pla.annoyingvillagers.item.GreenVillagerGeneralHelmetFixItem::new);
/*  72 */   public static final RegistryObject<Item> PURPLE_VILLAGER_GENERAL_HELMET_FIX = REGISTRY.register("green_villager_general_helmet_fix", com.pla.annoyingvillagers.item.PurpleVillagerGeneralHelmetFixItem::new);
/*     */ 
/*     */ 
/*     */   
/*  76 */   public static final RegistryObject<Item> COMPRESSED_DIAMOND = REGISTRY.register("compressed_diamond", com.pla.annoyingvillagers.item.CompressedDiamondItem::new);
/*  77 */   public static final RegistryObject<Item> RUBY = REGISTRY.register("ruby", com.pla.annoyingvillagers.item.RubyItem::new);
/*  78 */   public static final RegistryObject<Item> DARK_NETHERITE = REGISTRY.register("dark_netherite", com.pla.annoyingvillagers.item.DarkNetheriteItem::new);
/*  79 */   public static final RegistryObject<Item> PURPLE_GEM = REGISTRY.register("purple_gem", com.pla.annoyingvillagers.item.PurpleGemItem::new);
/*     */ 
/*     */ 
/*     */   
/*  83 */   public static final RegistryObject<Item> LEGENDARY_SWORD = REGISTRY.register("legendary_sword", com.pla.annoyingvillagers.item.LegendarySwordItem::new);
/*  84 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_WEAPON = REGISTRY.register("shadow_obsidian_weapon", com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem::new);
/*  85 */   public static final RegistryObject<Item> OBSIDIAN_WEAPON = REGISTRY.register("obsidian_weapon", com.pla.annoyingvillagers.item.ObsidianWeaponItem::new);
/*  86 */   public static final RegistryObject<Item> BEDROCK_WEAPON = REGISTRY.register("bedrock_weapon", com.pla.annoyingvillagers.item.BedrockWeaponItem::new);
/*  87 */   public static final RegistryObject<Item> CRAFTING_TABLE = REGISTRY.register("crafting_table", com.pla.annoyingvillagers.item.CraftingTableItem::new);
/*  88 */   public static final RegistryObject<Item> WOODEN_DOOR = REGISTRY.register("wooden_door", com.pla.annoyingvillagers.item.WoodenDoorItem::new);
/*  89 */   public static final RegistryObject<Item> LADDER = REGISTRY.register("ladder", com.pla.annoyingvillagers.item.LadderItem::new);
/*  90 */   public static final RegistryObject<Item> TRAPDOOR = REGISTRY.register("trapdoor", com.pla.annoyingvillagers.item.TrapdoorItem::new);
/*  91 */   public static final RegistryObject<Item> NULL_WEAPON = REGISTRY.register("null_weapon", com.pla.annoyingvillagers.item.NullWeaponItem::new);
/*  92 */   public static final RegistryObject<Item> NULL_SWORD = REGISTRY.register("null_sword", com.pla.annoyingvillagers.item.NullSwordItem::new);
/*  93 */   public static final RegistryObject<Item> NULL_AXE = REGISTRY.register("null_axe", com.pla.annoyingvillagers.item.NullAxeItem::new);
/*  94 */   public static final RegistryObject<Item> NULL_PICKAXE = REGISTRY.register("null_pickaxe", com.pla.annoyingvillagers.item.NullPickaxeItem::new);
/*  95 */   public static final RegistryObject<Item> NULL_SHOVEL = REGISTRY.register("null_shovel", com.pla.annoyingvillagers.item.NullShovelItem::new);
/*  96 */   public static final RegistryObject<Item> NULL_HOE = REGISTRY.register("null_hoe", com.pla.annoyingvillagers.item.NullHoeItem::new);
/*  97 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_PILLAR = REGISTRY.register("shadow_obsidian_pillar", com.pla.annoyingvillagers.item.ShadowObsidianPillarItem::new);
/*  98 */   public static final RegistryObject<Item> ENDER_GLAIVE = REGISTRY.register("ender_glaive", com.pla.annoyingvillagers.item.EnderGlaiveItem::new);
/*  99 */   public static final RegistryObject<Item> ENDER_SLAYER_SCYTHE = REGISTRY.register("ender_slayer_scythe", com.pla.annoyingvillagers.item.EnderSlayerScytheItem::new);
/* 100 */   public static final RegistryObject<Item> DEMONIAC_VOLTAGE_REAVER = REGISTRY.register("demoniac_voltage_reaver", com.pla.annoyingvillagers.item.DemoniacVoltageReaverItem::new);
/* 101 */   public static final RegistryObject<Item> OBSIDIAN_SLEDGEHAMMER = REGISTRY.register("obsidian_sledgehammer", com.pla.annoyingvillagers.item.ObsidianSledgehammerItem::new);
/* 102 */   public static final RegistryObject<Item> ENDER_AEGIS = REGISTRY.register("ender_aegis", com.pla.annoyingvillagers.item.EnderAegisItem::new);
/* 103 */   public static final RegistryObject<Item> HEROBRINE_ENDER_EYE = REGISTRY.register("herobrine_ender_eye", com.pla.annoyingvillagers.item.HerobrineEnderEyeItem::new);
/* 104 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_SWORD = REGISTRY.register("shadow_obsidian_sword", com.pla.annoyingvillagers.item.ShadowObsidianSwordItem::new);
/* 105 */   public static final RegistryObject<Item> DIAMOND_SHEAR = REGISTRY.register("diamond_shear", com.pla.annoyingvillagers.item.DiamondShearItem::new);
/* 106 */   public static final RegistryObject<Item> WARDEN_AXE = REGISTRY.register("warden_axe", com.pla.annoyingvillagers.item.WardenAxeItem::new);
/* 107 */   public static final RegistryObject<Item> BLUE_DEMON_TRIDENT = REGISTRY.register("blue_demon_trident", com.pla.annoyingvillagers.item.BlueDemonTridentItem::new);
/* 108 */   public static final RegistryObject<Item> DARKNESS_SWORD = REGISTRY.register("darkness_sword", com.pla.annoyingvillagers.item.DarknessSwordItem::new);
/* 109 */   public static final RegistryObject<Item> RED_STEEL_AXE = REGISTRY.register("red_steel_axe", com.pla.annoyingvillagers.item.RedSteelAxeItem::new);
/* 110 */   public static final RegistryObject<Item> RED_STEEL_AXE_FORKED = REGISTRY.register("red_steel_axe_forked", com.pla.annoyingvillagers.item.RedSteelAxeForkedItem::new);
/* 111 */   public static final RegistryObject<Item> RED_STEEL_AXE_SPEAR_SHORT = REGISTRY.register("red_steel_axe_spear_short", com.pla.annoyingvillagers.item.RedSteelAxeSpearShortItem::new);
/* 112 */   public static final RegistryObject<Item> RED_STEEL_AXE_SPEAR_MIDDLE = REGISTRY.register("red_steel_axe_spear_middle", com.pla.annoyingvillagers.item.RedSteelAxeSpearMiddleItem::new);
/* 113 */   public static final RegistryObject<Item> RED_STEEL_AXE_SPEAR_LONG = REGISTRY.register("red_steel_axe_spear_long", com.pla.annoyingvillagers.item.RedSteelAxeSpearLongItem::new);
/* 114 */   public static final RegistryObject<Item> HOLY_LLAMA_HAMMER = REGISTRY.register("holy_llama_hammer", com.pla.annoyingvillagers.item.HolyLlamaHammerItem::new);
/* 115 */   public static final RegistryObject<Item> BLACK_FIRE_SWORD = REGISTRY.register("black_fire_sword", com.pla.annoyingvillagers.item.BlackFireSwordItem::new);
/* 116 */   public static final RegistryObject<Item> BLUE_FLAME_SWORD = REGISTRY.register("blue_flame_sword", com.pla.annoyingvillagers.item.BlueFlameSwordItem::new);
/* 117 */   public static final RegistryObject<Item> CENTRANOS_SWORD = REGISTRY.register("centranos_sword", com.pla.annoyingvillagers.item.CentranosSwordItem::new);
/* 118 */   public static final RegistryObject<Item> CLOW_SWORD = REGISTRY.register("clow_sword", com.pla.annoyingvillagers.item.ClowSwordItem::new);
/* 119 */   public static final RegistryObject<Item> DIAMOND_ATTRACTOR_SWORD = REGISTRY.register("diamond_attractor_sword", com.pla.annoyingvillagers.item.DiamondAttractorSwordItem::new);
/* 120 */   public static final RegistryObject<Item> DIAMOND_BLASTER_SWORD = REGISTRY.register("diamond_blaster_sword", com.pla.annoyingvillagers.item.DiamondBlasterSwordItem::new);
/* 121 */   public static final RegistryObject<Item> DIAMOND_DURANDAL = REGISTRY.register("diamond_durandal", com.pla.annoyingvillagers.item.DiamondDurandalItem::new);
/* 122 */   public static final RegistryObject<Item> DIAMOND_WARBLADE = REGISTRY.register("diamond_warblade", com.pla.annoyingvillagers.item.DiamondWarbladeItem::new);
/* 123 */   public static final RegistryObject<Item> DIAMOND_FALCHION = REGISTRY.register("diamond_falchion", com.pla.annoyingvillagers.item.DiamondBladeItem::new);
/* 124 */   public static final RegistryObject<Item> DIAMOND_GREAT_FALCHION = REGISTRY.register("diamond_great_falchion", com.pla.annoyingvillagers.item.DiamondGreatFalchionItem::new);
/* 125 */   public static final RegistryObject<Item> DIAMOND_SABRE = REGISTRY.register("diamond_sabre", com.pla.annoyingvillagers.item.DiamondSabreItem::new);
/* 126 */   public static final RegistryObject<Item> HOOKED_DIAMOND_SWORD = REGISTRY.register("hooked_diamond_sword", com.pla.annoyingvillagers.item.HookedDiamondSwordItem::new);
/* 127 */   public static final RegistryObject<Item> HOOKED_IRON_SWORD = REGISTRY.register("hooked_iron_sword", com.pla.annoyingvillagers.item.HookedIronSwordItem::new);
/* 128 */   public static final RegistryObject<Item> HOOKED_GOLDEN_SWORD = REGISTRY.register("hooked_golden_sword", com.pla.annoyingvillagers.item.HookedGoldenSwordItem::new);
/* 129 */   public static final RegistryObject<Item> IRON_CLEAVER = REGISTRY.register("iron_cleaver", com.pla.annoyingvillagers.item.IronCleaverItem::new);
/* 130 */   public static final RegistryObject<Item> DIAMOND_LAEVATEINN = REGISTRY.register("diamond_laevateinn", com.pla.annoyingvillagers.item.DiamondLaevateinnItem::new);
/* 131 */   public static final RegistryObject<Item> DIAMOND_LONGSWORD = REGISTRY.register("diamond_longsword", com.pla.annoyingvillagers.item.DiamondLongSwordItem::new);
/* 132 */   public static final RegistryObject<Item> GOLDEN_LONGSWORD = REGISTRY.register("golden_longsword", com.pla.annoyingvillagers.item.GoldenLongSwordItem::new);
/* 133 */   public static final RegistryObject<Item> IRON_LONGSWORD = REGISTRY.register("iron_longsword", com.pla.annoyingvillagers.item.IronLongSwordItem::new);
/* 134 */   public static final RegistryObject<Item> DIAMOND_CHIPPED_LONGSWORD = REGISTRY.register("diamond_chipped_longsword", com.pla.annoyingvillagers.item.DiamondChippedLongswordItem::new);
/* 135 */   public static final RegistryObject<Item> DIAMOND_GREATSWORD = REGISTRY.register("diamond_greatsword", com.pla.annoyingvillagers.item.DiamondGreatswordItem::new);
/* 136 */   public static final RegistryObject<Item> DNAX_HOOKED_SWORD = REGISTRY.register("dnax_hooked_sword", com.pla.annoyingvillagers.item.DNAxHookedSwordItem::new);
/* 137 */   public static final RegistryObject<Item> DNAX_HOOKED_SWORD_ABILITY = REGISTRY.register("dnax_hooked_sword_ability", com.pla.annoyingvillagers.item.DNAxHookedSwordAbilityItem::new);
/* 138 */   public static final RegistryObject<Item> FLANKER_HOOKED_SWORD = REGISTRY.register("flanker_hooked_sword", com.pla.annoyingvillagers.item.FlankerHookedSwordItem::new);
/* 139 */   public static final RegistryObject<Item> GREAT_SWORD = REGISTRY.register("great_sword", com.pla.annoyingvillagers.item.GreatSwordItem::new);
/* 140 */   public static final RegistryObject<Item> GREAT_SWORD_SKILL = REGISTRY.register("great_sword_skill", com.pla.annoyingvillagers.item.GreatSwordSkillItem::new);
/* 141 */   public static final RegistryObject<Item> IRON_TWIN_BLADE_KATANA = REGISTRY.register("iron_twin_blade_katana", com.pla.annoyingvillagers.item.IronTwinBladeKatanaItem::new);
/* 142 */   public static final RegistryObject<Item> PALADIN_SWORD = REGISTRY.register("paladin_sword", com.pla.annoyingvillagers.item.PaladinSwordItem::new);
/* 143 */   public static final RegistryObject<Item> RUBY_GREATSWORD = REGISTRY.register("ruby_greatsword", com.pla.annoyingvillagers.item.RubyGreatswordItem::new);
/* 144 */   public static final RegistryObject<Item> RUBY_LONGSWORD = REGISTRY.register("ruby_longsword", com.pla.annoyingvillagers.item.PurpleGemLongSwordItem::new);
/* 145 */   public static final RegistryObject<Item> RUBY_KNIGHT_SWORD = REGISTRY.register("ruby_knight_sword", com.pla.annoyingvillagers.item.RubyKnightSwordItem::new);
/* 146 */   public static final RegistryObject<Item> RUBY_SWORD = REGISTRY.register("ruby_sword", com.pla.annoyingvillagers.item.RubySwordItem::new);
/* 147 */   public static final RegistryObject<Item> THUNDER_DIAMOND_BLADE = REGISTRY.register("thunder_diamond_blade", com.pla.annoyingvillagers.item.ThunderDiamondBladeItem::new);
/* 148 */   public static final RegistryObject<Item> JADE_SWORD = REGISTRY.register("jade_sword", com.pla.annoyingvillagers.item.JadeSwordItem::new);
/* 149 */   public static final RegistryObject<Item> RED_DIAMOND_SWORD = REGISTRY.register("red_diamond_sword", com.pla.annoyingvillagers.item.RedDiamondSwordItem::new);
/* 150 */   public static final RegistryObject<Item> WOOPIE_THE_SWORD = REGISTRY.register("woopie_the_sword", com.pla.annoyingvillagers.item.WoopieTheSwordItem::new);
/* 151 */   public static final RegistryObject<Item> NETHERITE_GREATBLADE = REGISTRY.register("netherite_greatblade", com.pla.annoyingvillagers.item.NetheriteGreatbladeItem::new);
/* 152 */   public static final RegistryObject<Item> NETHERITE_FALCHION = REGISTRY.register("netherite_falchion", com.pla.annoyingvillagers.item.NetheriteFalchionItem::new);
/* 153 */   public static final RegistryObject<Item> DIAMOND_HALBERD = REGISTRY.register("diamond_halberd", com.pla.annoyingvillagers.item.DiamondHalberdItem::new);
/* 154 */   public static final RegistryObject<Item> DIAMOND_GREATAXE = REGISTRY.register("diamond_greataxe", com.pla.annoyingvillagers.item.DiamondGreataxeItem::new);
/* 155 */   public static final RegistryObject<Item> DIAMOND_BATTLEAXE = REGISTRY.register("diamond_battleaxe", com.pla.annoyingvillagers.item.DiamondBattleaxeItem::new);
/* 156 */   public static final RegistryObject<Item> EARTH_AXE = REGISTRY.register("earth_axe", com.pla.annoyingvillagers.item.EarthAxeItem::new);
/* 157 */   public static final RegistryObject<Item> EXTERMINATOR_BATTLEAXE = REGISTRY.register("exterminator_battleaxe", com.pla.annoyingvillagers.item.ExterminatorBattleaxeItem::new);
/* 158 */   public static final RegistryObject<Item> GIANT_NETHERITE_AXE = REGISTRY.register("giant_netherite_axe", com.pla.annoyingvillagers.item.GiantNetheriteAxeItem::new);
/* 159 */   public static final RegistryObject<Item> RED_AXE = REGISTRY.register("red_axe", com.pla.annoyingvillagers.item.RedAxeItem::new);
/* 160 */   public static final RegistryObject<Item> GIANT_RED_AXE = REGISTRY.register("giant_red_axe", com.pla.annoyingvillagers.item.GiantRedAxeItem::new);
/* 161 */   public static final RegistryObject<Item> IRON_DOUBLE_BLADED_HALBERD = REGISTRY.register("iron_double_bladed_halberd", com.pla.annoyingvillagers.item.IronDoubleBladedHalberdItem::new);
/* 162 */   public static final RegistryObject<Item> IRON_GREATAXE = REGISTRY.register("iron_greataxe", com.pla.annoyingvillagers.item.IronGreataxeItem::new);
/* 163 */   public static final RegistryObject<Item> IRON_HALBERD = REGISTRY.register("iron_halberd", com.pla.annoyingvillagers.item.IronHalberdItem::new);
/* 164 */   public static final RegistryObject<Item> NETHERITE_GREATAXE = REGISTRY.register("netherite_greataxe", com.pla.annoyingvillagers.item.NetheriteGreataxeItem::new);
/* 165 */   public static final RegistryObject<Item> SAMANTHA_THE_KILLER_AXE = REGISTRY.register("samantha_the_killer_axe", com.pla.annoyingvillagers.item.SamanthaTheKillerAxeItem::new);
/* 166 */   public static final RegistryObject<Item> SPEAR_AXE = REGISTRY.register("spear_axe", com.pla.annoyingvillagers.item.SpearAxeItem::new);
/* 167 */   public static final RegistryObject<Item> DIAMOND_ARMBLADE = REGISTRY.register("diamond_armblade", com.pla.annoyingvillagers.item.DiamondArmbladeItem::new);
/* 168 */   public static final RegistryObject<Item> DIAMOND_DAGGER = REGISTRY.register("diamond_dagger", com.pla.annoyingvillagers.item.DiamondDaggerItem::new);
/* 169 */   public static final RegistryObject<Item> KNIFE = REGISTRY.register("knife", com.pla.annoyingvillagers.item.KnifeItem::new);
/* 170 */   public static final RegistryObject<Item> GOLDEN_MOON_BLADE = REGISTRY.register("golden_moon_blade", com.pla.annoyingvillagers.item.GoldenMoonBladeItem::new);
/* 171 */   public static final RegistryObject<Item> DIAMOND_MOON_BLADE = REGISTRY.register("diamond_moon_blade", com.pla.annoyingvillagers.item.DiamondMoonBladeItem::new);
/* 172 */   public static final RegistryObject<Item> NETHERITE_KNIFE = REGISTRY.register("netherite_knife", com.pla.annoyingvillagers.item.NetheriteKnifeItem::new);
/* 173 */   public static final RegistryObject<Item> GEM_SHIELD = REGISTRY.register("gem_shield", com.pla.annoyingvillagers.item.GemShieldItem::new);
/* 174 */   public static final RegistryObject<Item> HEATER_SHIELD = REGISTRY.register("heater_shield", com.pla.annoyingvillagers.item.HeaterShield::new);
/* 175 */   public static final RegistryObject<Item> JESSICA_THE_DARK_SHIELD = REGISTRY.register("jessica_the_dark_shield", com.pla.annoyingvillagers.item.JessicaTheDarkShieldItem::new);
/* 176 */   public static final RegistryObject<Item> NETHERITE_SHIELD = REGISTRY.register("netherite_shield", com.pla.annoyingvillagers.item.NetheriteShield::new);
/* 177 */   public static final RegistryObject<Item> BLACKSCRATCHER = REGISTRY.register("blackscratcher", com.pla.annoyingvillagers.item.BlackscratcherItem::new);
/* 178 */   public static final RegistryObject<Item> DIAMOND_BOLT = REGISTRY.register("diamond_bolt", com.pla.annoyingvillagers.item.DiamondBoltItem::new);
/* 179 */   public static final RegistryObject<Item> DIAMOND_SICKLE = REGISTRY.register("diamond_sickle", com.pla.annoyingvillagers.item.DiamondSickleItem::new);
/* 180 */   public static final RegistryObject<Item> DIAMOND_SPEAR = REGISTRY.register("diamond_spear", com.pla.annoyingvillagers.item.DiamondSpearItem::new);
/* 181 */   public static final RegistryObject<Item> DOUBLE_DIAMOND_GLAIVE = REGISTRY.register("double_diamond_glaive", com.pla.annoyingvillagers.item.DoubleDiamondGlaiveItem::new);
/* 182 */   public static final RegistryObject<Item> IRON_SICKLE = REGISTRY.register("iron_sickle", com.pla.annoyingvillagers.item.IronSickleItem::new);
/* 183 */   public static final RegistryObject<Item> NETHERITE_SPEAR = REGISTRY.register("netherite_spear", com.pla.annoyingvillagers.item.NetheriteSpearItem::new);
/* 184 */   public static final RegistryObject<Item> TWIN_DIAMOND_SPEAR = REGISTRY.register("twin_diamond_spear", com.pla.annoyingvillagers.item.TwinDiamondSpearItem::new);
/* 185 */   public static final RegistryObject<Item> DUAL_TWIN_DIAMOND_SPEAR = REGISTRY.register("dual_twin_diamond_spear", com.pla.annoyingvillagers.item.DualTwinDiamondSpearItem::new);
/* 186 */   public static final RegistryObject<Item> GOLDEN_MACE = REGISTRY.register("golden_mace", com.pla.annoyingvillagers.item.GoldenMaceItem::new);
/* 187 */   public static final RegistryObject<Item> DIAMOND_MACE = REGISTRY.register("diamond_mace", com.pla.annoyingvillagers.item.DiamondMaceItem::new);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 192 */   public static final RegistryObject<Item> ENCHANT_BED = block(AnnoyingVillagersModBlocks.ENCHANT_BED, null);
/* 193 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_SHORT_PILLAR = block(AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_SHORT_PILLAR, null);
/* 194 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_MIDDLE_PILLAR = block(AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_MIDDLE_PILLAR, null);
/* 195 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_LONG_PILLAR = block(AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR, null);
/* 196 */   public static final RegistryObject<Item> HEAVY_ATTACK_LEGENDARY_SWORD = REGISTRY.register("heavy_attack_legendary_sword", com.pla.annoyingvillagers.item.HeavyAttackLegendarySwordItem::new);
/*     */   
/* 198 */   public static final RegistryObject<Item> SHADOW_OBSIDIAN_ITEM = block(AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK, null);
/* 199 */   public static final RegistryObject<Item> OBSIDIAN_ITEM = block(AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK, null);
/*     */ 
/*     */ 
/*     */   
/* 203 */   public static final RegistryObject<Item> BLUE_DEMON_CHESTPLATE = REGISTRY.register("blue_demon_chestplate", com.pla.annoyingvillagers.item.BlueDemonChestplateItem.Chestplate::new);
/* 204 */   public static final RegistryObject<Item> COMPRESSED_DIAMOND_HELMET = REGISTRY.register("compressed_diamond_helmet", com.pla.annoyingvillagers.item.CompressedDiamondArmorItem.Helmet::new);
/* 205 */   public static final RegistryObject<Item> COMPRESSED_DIAMOND_CHESTPLATE = REGISTRY.register("compressed_diamond_chestplate", com.pla.annoyingvillagers.item.CompressedDiamondArmorItem.Chestplate::new);
/* 206 */   public static final RegistryObject<Item> COMPRESSED_DIAMOND_LEGGINGS = REGISTRY.register("compressed_diamond_leggings", com.pla.annoyingvillagers.item.CompressedDiamondArmorItem.Leggings::new);
/* 207 */   public static final RegistryObject<Item> COMPRESSED_DIAMOND_BOOTS = REGISTRY.register("compressed_diamond_boots", com.pla.annoyingvillagers.item.CompressedDiamondArmorItem.Boots::new);
/* 208 */   public static final RegistryObject<Item> RUBY_HELMET = REGISTRY.register("ruby_helmet", com.pla.annoyingvillagers.item.RubyArmorItem.Helmet::new);
/* 209 */   public static final RegistryObject<Item> RUBY_CHESTPLATE = REGISTRY.register("ruby_chestplate", com.pla.annoyingvillagers.item.RubyArmorItem.Chestplate::new);
/* 210 */   public static final RegistryObject<Item> RUBY_LEGGINGS = REGISTRY.register("ruby_leggings", com.pla.annoyingvillagers.item.RubyArmorItem.Leggings::new);
/* 211 */   public static final RegistryObject<Item> RUBY_BOOTS = REGISTRY.register("ruby_boots", com.pla.annoyingvillagers.item.RubyArmorItem.Boots::new);
/* 212 */   public static final RegistryObject<Item> EMERALD_HELMET = REGISTRY.register("emerald_helmet", com.pla.annoyingvillagers.item.EmeraldArmorItem.Helmet::new);
/* 213 */   public static final RegistryObject<Item> EMERALD_CHESTPLATE = REGISTRY.register("emerald_chestplate", com.pla.annoyingvillagers.item.EmeraldArmorItem.Chestplate::new);
/* 214 */   public static final RegistryObject<Item> EMERALD_LEGGINGS = REGISTRY.register("emerald_leggings", com.pla.annoyingvillagers.item.EmeraldArmorItem.Leggings::new);
/* 215 */   public static final RegistryObject<Item> EMERALD_BOOTS = REGISTRY.register("emerald_boots", com.pla.annoyingvillagers.item.EmeraldArmorItem.Boots::new);
/* 216 */   public static final RegistryObject<Item> VILLAGER_SCOUT_HELMET = REGISTRY.register("villager_scout_helmet", com.pla.annoyingvillagers.item.VillagerScoutHelmetItem.Helmet::new);
/* 217 */   public static final RegistryObject<Item> CLASSICGOLDENA_CHESTPLATE = REGISTRY.register("classicgoldena_chestplate", com.pla.annoyingvillagers.item.ClassicGoldenArmorItem.Chestplate::new);
/* 218 */   public static final RegistryObject<Item> CLASSICGOLDENA_LEGGINGS = REGISTRY.register("classicgoldena_leggings", com.pla.annoyingvillagers.item.ClassicGoldenArmorItem.Leggings::new);
/* 219 */   public static final RegistryObject<Item> CLASSICGOLDENA_BOOTS = REGISTRY.register("classicgoldena_boots", com.pla.annoyingvillagers.item.ClassicGoldenArmorItem.Boots::new);
/* 220 */   public static final RegistryObject<Item> RED_VILLAGER_GENERAL_HELMET = REGISTRY.register("red_villager_general_helmet", com.pla.annoyingvillagers.item.RedVillagerGeneralArmorItem.Armor::new);
/* 221 */   public static final RegistryObject<Item> RED_VILLAGER_GENERAL_CHESTPLATE = REGISTRY.register("red_villager_general_chestplate", com.pla.annoyingvillagers.item.RedVillagerGeneralArmorItem.Chestplate::new);
/* 222 */   public static final RegistryObject<Item> VILLAGER_GENERAL_LEGGINGS = REGISTRY.register("villager_general_leggings", com.pla.annoyingvillagers.item.RedVillagerGeneralArmorItem.Leggings::new);
/* 223 */   public static final RegistryObject<Item> VILLAGER_GENERAL_BOOTS = REGISTRY.register("villager_general_boots", com.pla.annoyingvillagers.item.RedVillagerGeneralArmorItem.Boots::new);
/* 224 */   public static final RegistryObject<Item> BLUE_VILLAGER_GENERAL_HELMET = REGISTRY.register("blue_villager_general_helmet", com.pla.annoyingvillagers.item.BlueVillagerGeneralArmorItem.Helmet::new);
/* 225 */   public static final RegistryObject<Item> BLUE_VILLAGER_GENERAL_CHESTPLATE = REGISTRY.register("blue_villager_general_chestplate", com.pla.annoyingvillagers.item.BlueVillagerGeneralArmorItem.Chestplate::new);
/* 226 */   public static final RegistryObject<Item> GREEN_VILLAGER_GENERAL_HELMET = REGISTRY.register("green_villager_general_helmet", com.pla.annoyingvillagers.item.GreenVillagerGeneralArmorItem.Helmet::new);
/* 227 */   public static final RegistryObject<Item> GREEN_VILLAGER_GENERAL_CHESTPLATE = REGISTRY.register("green_villager_general_chestplate", com.pla.annoyingvillagers.item.GreenVillagerGeneralArmorItem.Chestplate::new);
/* 228 */   public static final RegistryObject<Item> PURPLE_VILLAGER_GENERAL_HELMET = REGISTRY.register("purple_villager_general_helmet", com.pla.annoyingvillagers.item.PurpleVillagerGeneralArmorItem.Helmet::new);
/* 229 */   public static final RegistryObject<Item> PURPLE_VILLAGER_GENERAL_CHESTPLATE = REGISTRY.register("purple_villager_general_chestplate", com.pla.annoyingvillagers.item.PurpleVillagerGeneralArmorItem.Chestplate::new);
/* 230 */   public static final RegistryObject<Item> UNLIGHT_DIAMOND_HELMET = REGISTRY.register("unlight_diamond_helmet", com.pla.annoyingvillagers.item.UnlightDiamondArmorItem.Helmet::new);
/* 231 */   public static final RegistryObject<Item> UNLIGHT_DIAMOND_CHESTPLATE = REGISTRY.register("unlight_diamond_chestplate", com.pla.annoyingvillagers.item.UnlightDiamondArmorItem.Chestplate::new);
/* 232 */   public static final RegistryObject<Item> UNLIGHT_DIAMOND_LEGGINGS = REGISTRY.register("unlight_diamond_leggings", com.pla.annoyingvillagers.item.UnlightDiamondArmorItem.Leggings::new);
/* 233 */   public static final RegistryObject<Item> UNLIGHT_DIAMOND_BOOTS = REGISTRY.register("unlight_diamond_boots", com.pla.annoyingvillagers.item.UnlightDiamondArmorItem.Boots::new);
/* 234 */   public static final RegistryObject<Item> HEROBRINE_OBSIDIAN_DIAMOND_HELMET = REGISTRY.register("herobrine_obsidian_diamond_helmet", com.pla.annoyingvillagers.item.HerobrineObsidianDiamondArmorHelmetItem.Helmet::new);
/* 235 */   public static final RegistryObject<Item> HEROBRINE_OBSIDIAN_DIAMOND_CHESTPLATE = REGISTRY.register("herobrine_obsidian_diamond_chestplate", com.pla.annoyingvillagers.item.HerobrineObsidianDiamondArmorChestplateItem.Chestplate::new);
/* 236 */   public static final RegistryObject<Item> BROKEN_DIAMOND_HELMET = REGISTRY.register("broken_diamond_helmet", com.pla.annoyingvillagers.item.BrokenDiamondArmorItem.Helmet::new);
/* 237 */   public static final RegistryObject<Item> BROKEN_DIAMOND_CHESTPLATE = REGISTRY.register("broken_diamond_chestplate", com.pla.annoyingvillagers.item.BrokenDiamondArmorItem.Chestplate::new);
/* 238 */   public static final RegistryObject<Item> BROKEN_DIAMOND_LEGGINGS = REGISTRY.register("broken_diamond_leggings", com.pla.annoyingvillagers.item.BrokenDiamondArmorItem.Leggings::new);
/* 239 */   public static final RegistryObject<Item> BROKEN_DIAMOND_BOOTS = REGISTRY.register("broken_diamond_boots", com.pla.annoyingvillagers.item.BrokenDiamondArmorItem.Boots::new);
/*     */   
/*     */   private static RegistryObject<Item> block(RegistryObject<Block> registryobject, CreativeModeTab creativemodetab) {
/* 242 */     return REGISTRY.register(registryobject.getId().m_135815_(), () -> new BlockItem((Block)registryobject.get(), new Item.Properties()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModItems.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */