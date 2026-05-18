/*     */ package com.pla.annoyingvillagers.config;
/*     */ 
/*     */ import net.minecraftforge.common.ForgeConfigSpec;
/*     */ 
/*     */ public class AnnoyingVillagersConfig {
/*   6 */   public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
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
/*     */   public static final ForgeConfigSpec SPEC;
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
/*  37 */   public static ForgeConfigSpec.ConfigValue<Double> HEROBRINE_POSSESS_RATE = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Chance for Herobrine possess another player npc into Herobrine #5 and Herobrine #6")
/*     */     
/*  39 */     .defineInRange("herobrinePossessRate", 0.5D, 0.0D, 1.0D);
/*     */   
/*  41 */   public static ForgeConfigSpec.ConfigValue<Integer> HEROBRINE_RECALL_MIN_TIME = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("The minimum value (in minutes) for Herobrine's random recall time. This value should be lower than or equal the maximum. After a random time between min and max, Herobrine will vanish and return to the Herobrine dimension.")
/*     */ 
/*     */     
/*  44 */     .defineInRange("herobrineRecallMinTime", 60, 1, 10080);
/*     */   
/*  46 */   public static ForgeConfigSpec.ConfigValue<Integer> HEROBRINE_RECALL_MAX_TIME = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("The maximum value (in minutes) for Herobrine's random recall time. This value should be greater than or equal to the minimum. After a random time between min and max, Herobrine will vanish and return to the Herobrine dimension.")
/*     */ 
/*     */     
/*  49 */     .defineInRange("herobrineRecallMaxTime", 300, 1, 10080);
/*     */   
/*  51 */   public static ForgeConfigSpec.ConfigValue<Double> ANGRY_STEVE_CHANCE = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Chance for Steve to be Angry after getting killed")
/*     */     
/*  53 */     .defineInRange("angrySteveChance", 0.2D, 0.0D, 1.0D);
/*     */   
/*  55 */   public static ForgeConfigSpec.ConfigValue<Integer> ANGRY_STEVE_LEAVE_MIN_TIME = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("The minimum value (in minutes) for Angry Steve's random leave time. This value should be lower than or equal the maximum. After a random time between min and max, Angry Steve will feel exhausted and leave the game.")
/*     */ 
/*     */     
/*  58 */     .defineInRange("angrySteveLeaveMinTime", 60, 1, 10080);
/*     */   
/*  60 */   public static ForgeConfigSpec.ConfigValue<Integer> ANGRY_STEVE_LEAVE_MAX_TIME = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("The maximum value (in minutes) for Angry Steve's random leave time. This value should be greater than or equal to the minimum. After a random time between min and max, Angry Steve will feel exhausted and leave the game.")
/*     */ 
/*     */     
/*  63 */     .defineInRange("angrySteveLeaveMaxTime", 300, 1, 10080);
/*     */   
/*  65 */   public static ForgeConfigSpec.ConfigValue<Integer> BLUE_DEMON_LEAVE_MIN_TIME = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("The minimum value (in minutes) for Blue Demon's random leave time. This value should be lower than or equal the maximum. After a random time between min and max, Blue Demon will feel bored and go away.\"")
/*     */ 
/*     */     
/*  68 */     .defineInRange("blueDemonLeaveMinTime", 60, 1, 10080);
/*     */   
/*  70 */   public static ForgeConfigSpec.ConfigValue<Integer> BLUE_DEMON_LEAVE_MAX_TIME = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("The maximum value (in minutes) for Blue Demon's random leave time. This value should be greater than or equal to the minimum. After a random time between min and max, Blue Demon will feel bored and go away.")
/*     */ 
/*     */     
/*  73 */     .defineInRange("blueDemonLeaveMaxTime", 300, 1, 10080);
/*     */   
/*  75 */   public static ForgeConfigSpec.ConfigValue<Boolean> TRIDENT_FESTIVAL_CAN_BREAK_BLOCK = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.comment("Make Trident Festival can break block")
/*     */     
/*  77 */     .define("tridentFestivalCanBreakBlock", true);
/*     */   
/*  79 */   public static ForgeConfigSpec.ConfigValue<Double> MOB_GUARD_BREAK_WAKE_UP_MIN_CHANCE = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Min chance for mob can wake up automatically on guard break")
/*     */     
/*  81 */     .defineInRange("mobGuardBreakWakeUpMinChance", 0.05D, 0.0D, 1.0D);
/*     */   
/*  83 */   public static ForgeConfigSpec.ConfigValue<Double> MOB_GUARD_BREAK_WAKE_UP_MAX_CHANCE = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Max chance for mob can wake up automatically on guard break")
/*     */     
/*  85 */     .defineInRange("mobGuardBreakWakeUpMaxChance", 0.4D, 0.0D, 1.0D);
/*     */   
/*  87 */   public static ForgeConfigSpec.ConfigValue<Boolean> TURN_ON_NPC_CHAT = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.comment("Turn on all chatting for NPC")
/*     */     
/*  89 */     .define("turnOnNpcChat", true);
/*     */   
/*  91 */   public static ForgeConfigSpec.ConfigValue<Boolean> ARROW_CAN_BREAK_BLOCK = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.comment("Make arrow can break block")
/*     */     
/*  93 */     .define("arrowCanBreakBlock", true);
/*     */   
/*  95 */   public static ForgeConfigSpec.ConfigValue<Boolean> CAN_EXECUTE_AV_MOB = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.comment("Make all of AV NPCs and Mobs can be executed")
/*     */     
/*  97 */     .define("canExecuteAvMob", true);
/*  98 */   public static ForgeConfigSpec.ConfigValue<Boolean> AV_MOB_CAN_EXECUTE = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.comment("Enable execute ability for all of Av NPCs and Mobs")
/*     */     
/* 100 */     .define("AvMobCanExecute", true);
/* 101 */   public static ForgeConfigSpec.ConfigValue<Boolean> AV_MOB_CAN_BURN_ITEM = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.comment("Enable burning items ability for all of Av NPCs and Mobs")
/*     */     
/* 103 */     .define("AvMobCanBurnItem", true);
/* 104 */   public static ForgeConfigSpec.ConfigValue<Boolean> VANILLA_MOB_CAN_DRINK_HEALING_POTION = (ForgeConfigSpec.ConfigValue<Boolean>)BUILDER.comment("Enable drinking healing potion ability for Zombie and Skeleton")
/*     */     
/* 106 */     .define("VanillaMobCanDrinkHealingPotion", true);
/* 107 */   public static ForgeConfigSpec.ConfigValue<Integer> WEAPON_BREAKING_MECHANISM_VALUE = (ForgeConfigSpec.ConfigValue<Integer>)BUILDER.comment("The value of durability lose of a weapon when Av Bosses blocking or clashing a dangerous animation or when Player clashing a dangerous animation by Av Bosses")
/*     */     
/* 109 */     .defineInRange("weaponBreakingMechanismValue", 10, 0, 10000);
/*     */   
/*     */   static {
/* 112 */     BUILDER.comment("==== NPC Behaviour ====")
/*     */       
/* 114 */       .push("npcBehaviour");
/*     */   }
/* 116 */   public static ForgeConfigSpec.ConfigValue<Double> NPC_TARGET_WEIGHT_MONSTER_HUNTER = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Weight for Player NPC to target and attack all monsters in the world")
/*     */     
/* 118 */     .defineInRange("npcTargetWeightMonsterHunter", 1.0D, 0.0D, 10.0D);
/*     */   
/* 120 */   public static ForgeConfigSpec.ConfigValue<Double> NPC_TARGET_WEIGHT_VILLAGER_HUNTER = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Weight for Player NPC to target and attack all villagers in the world")
/*     */     
/* 122 */     .defineInRange("npcTargetWeightVillagerHunter", 1.0D, 0.0D, 10.0D);
/*     */   
/* 124 */   public static ForgeConfigSpec.ConfigValue<Double> NPC_TARGET_WEIGHT_PLAYER_HUNTER = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Weight for Player NPC to target and attack players and other Player NPCs")
/*     */     
/* 126 */     .defineInRange("npcTargetWeightPlayerHunter", 1.0D, 0.0D, 10.0D);
/*     */   
/* 128 */   public static ForgeConfigSpec.ConfigValue<Double> NPC_TARGET_WEIGHT_HOSTILE_HUNTER = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Weight for Player NPC to target and attack everything in the world")
/*     */     
/* 130 */     .defineInRange("npcTargetWeightHostileHunter", 1.0D, 0.0D, 10.0D);
/*     */   
/* 132 */   public static ForgeConfigSpec.ConfigValue<Double> NPC_TARGET_WEIGHT_PASSIVE_HUNTER = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Weight for Player NPC to run away from everything in the world")
/*     */     
/* 134 */     .defineInRange("npcTargetWeightPassiveHunter", 1.0D, 0.0D, 10.0D);
/*     */   
/* 136 */   public static ForgeConfigSpec.ConfigValue<Double> NPC_TARGET_WEIGHT_ANIMAL_HUNTER = (ForgeConfigSpec.ConfigValue<Double>)BUILDER.comment("Weight for Player NPC to target and attack all animals in the world")
/*     */     
/* 138 */     .defineInRange("npcTargetWeightAnimalHunter", 1.0D, 0.0D, 10.0D); static {
/* 139 */     BUILDER.pop();
/*     */     
/* 141 */     SPEC = BUILDER.build();
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\config\AnnoyingVillagersConfig.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */