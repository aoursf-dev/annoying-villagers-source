/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraftforge.eventbus.api.IEventBus;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ public class AnnoyingVillagersModSounds
/*    */ {
/* 13 */   public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "annoyingvillagers");
/*    */   
/* 15 */   public static final RegistryObject<SoundEvent> ALEX_SAY = register("alex_say");
/* 16 */   public static final RegistryObject<SoundEvent> BBQ_SAY = register("bbq_say");
/* 17 */   public static final RegistryObject<SoundEvent> BLUE_DEMON_SAY = register("blue_demon_say");
/* 18 */   public static final RegistryObject<SoundEvent> BLUE_DEMON_SAY_TRIDENT_FESTIVAL = register("blue_demon_say_trident_festival");
/* 19 */   public static final RegistryObject<SoundEvent> BLUE_DEMON_SAY_PHASE_2_RELEASE = register("blue_demon_say_phase_2_release");
/* 20 */   public static final RegistryObject<SoundEvent> BLUE_DEMON_SAY_WHEN_RETREAT = register("blue_demon_say_retreat");
/* 21 */   public static final RegistryObject<SoundEvent> CHRIS_SAY_ON_SPAWN = register("chris_say_on_spawn");
/* 22 */   public static final RegistryObject<SoundEvent> JEV_SAY_ON_SPAWN = register("jev_say_on_spawn");
/* 23 */   public static final RegistryObject<SoundEvent> JEV_SAY_WHEN_SUPPORT_ALEX = register("jev_say_when_support_alex");
/* 24 */   public static final RegistryObject<SoundEvent> JEV_SAY_WHEN_ALEX_SECOND_PHASE = register("jev_say_when_alex_second_phase");
/* 25 */   public static final RegistryObject<SoundEvent> ARMORED_HEROBRINE_SAY_ON_DEATH = register("armored_herobrine_say_on_death");
/* 26 */   public static final RegistryObject<SoundEvent> ARMORED_HEROBRINE_SAY = register("armored_herobrine_say");
/* 27 */   public static final RegistryObject<SoundEvent> INFECTED_THE_MOSTMOISTBURRIT0_SAY_ON_SPAWN = register("infected_the_most_moisburrit0_say_on_spawn");
/* 28 */   public static final RegistryObject<SoundEvent> ELITE_HEROBRINE_SAY = register("elite_herobrine_say");
/* 29 */   public static final RegistryObject<SoundEvent> ELITE_HEROBRINE_WEAPON_SCREAMING = register("elite_herobrine_weapon_screaming");
/* 30 */   public static final RegistryObject<SoundEvent> ELITE_HEROBRINE_SAY_SECOND_FORM_RELEASE = register("elite_herobrine_say_second_form_release");
/* 31 */   public static final RegistryObject<SoundEvent> KNOCKED_ELITE_HEROBRINE_SAY_ON_SPAWN = register("knocked_elite_herobrine_say_on_spawn");
/* 32 */   public static final RegistryObject<SoundEvent> KNOCKED_ELITE_HEROBRINE_SAY_ON_BEING_EATEN = register("knocked_elite_herobrine_say_on_being_eaten");
/* 33 */   public static final RegistryObject<SoundEvent> HEROBRINE_CLONE_SAY_ON_SPAWN = register("herobrine_clone_say_on_spawn");
/* 34 */   public static final RegistryObject<SoundEvent> HEROBRINE_CLONE_SAY_ON_HURT = register("herobrine_clone_say_on_hurt");
/* 35 */   public static final RegistryObject<SoundEvent> HEROBRINE_CLONE_SAY_ON_DEATH = register("herobrine_clone_say_on_death");
/* 36 */   public static final RegistryObject<SoundEvent> HEROBRINE_CLONE_SAY = register("herobrine_clone_say");
/* 37 */   public static final RegistryObject<SoundEvent> NULL_SAY = register("null_say");
/* 38 */   public static final RegistryObject<SoundEvent> SHADOW_HEROBRINE_SAY_OBSIDIAN_MACHINE_GUN = register("shadow_herobrine_say_obsidian_machine_gun");
/* 39 */   public static final RegistryObject<SoundEvent> SHADOW_HEROBRINE_SAY_ON_PHASE_2 = register("shadow_herobrine_say_on_phase_2");
/* 40 */   public static final RegistryObject<SoundEvent> SHADOW_HEROBRINE_SAY_ON_SPAWN = register("shadow_herobrine_say_on_spawn");
/* 41 */   public static final RegistryObject<SoundEvent> STEVE_SAY_ON_SPAWN = register("steve_say_on_spawn");
/* 42 */   public static final RegistryObject<SoundEvent> ANGRY_STEVE_SAY_ON_SPAWN = register("angry_steve_say_on_spawn");
/* 43 */   public static final RegistryObject<SoundEvent> STEVE_SAY_ON_DEATH = register("steve_say_on_death");
/* 44 */   public static final RegistryObject<SoundEvent> STEVE_SAY_WHAT = register("steve_say_what");
/* 45 */   public static final RegistryObject<SoundEvent> STEVE_SAY_I_NOT_BELIEVE = register("steve_say_i_not_believe");
/* 46 */   public static final RegistryObject<SoundEvent> STEVE_SAY_ON_ATTACK = register("steve_say_on_attack");
/* 47 */   public static final RegistryObject<SoundEvent> STEVE_SAY = register("steve_say");
/* 48 */   public static final RegistryObject<SoundEvent> ANGRY_STEVE_SAY = register("angry_steve_say");
/* 49 */   public static final RegistryObject<SoundEvent> VILLAGER_GENERALS_SAY_ON_FIRE = register("villager_generals_say_on_fire");
/* 50 */   public static final RegistryObject<SoundEvent> VILLAGER_GENERALS_SAY = register("villager_generals_say");
/* 51 */   public static final RegistryObject<SoundEvent> VILLAGER_SCOUTS_SAY_ON_FIRE = register("villager_scouts_say_on_fire");
/* 52 */   public static final RegistryObject<SoundEvent> VILLAGER_SCOUTS_SAY = register("villager_scouts_say");
/* 53 */   public static final RegistryObject<SoundEvent> ZOMBIE_SAY = register("zombie_say");
/*    */   
/* 55 */   public static final RegistryObject<SoundEvent> ELECTRIFY = register("electrify");
/* 56 */   public static final RegistryObject<SoundEvent> ELECTRIC_SHOOT = register("electric_shoot");
/* 57 */   public static final RegistryObject<SoundEvent> OB_PLACE = register("ob_place");
/* 58 */   public static final RegistryObject<SoundEvent> METAL_HIT = register("metal_hit");
/* 59 */   public static final RegistryObject<SoundEvent> TARGET_BLOCK_HIT = register("target_block_hit");
/* 60 */   public static final RegistryObject<SoundEvent> HEAVY_ATTACK_LEGENDARY_SWORD = register("heavy_attack_legendary_sword");
/* 61 */   public static final RegistryObject<SoundEvent> HEAVY_ATTACK_LEGENDARY_SWORD_2 = register("heavy_attack_legendary_sword_2");
/* 62 */   public static final RegistryObject<SoundEvent> HEAVY_ATTACK_START = register("heavy_attack_start");
/* 63 */   public static final RegistryObject<SoundEvent> HARD_GREATSWORD_SKILL = register("hard_greatsword_skill");
/* 64 */   public static final RegistryObject<SoundEvent> LOST = register("lost");
/* 65 */   public static final RegistryObject<SoundEvent> SILENT = register("silent");
/* 66 */   public static final RegistryObject<SoundEvent> OBSIDIAN_PLACE = register("obsidian_place");
/* 67 */   public static final RegistryObject<SoundEvent> POP = register("pop");
/* 68 */   public static final RegistryObject<SoundEvent> OBSIDIAN_HIT = register("obsidian_hit");
/* 69 */   public static final RegistryObject<SoundEvent> HEAVY_HIT = register("heavy_hit");
/* 70 */   public static final RegistryObject<SoundEvent> WOOSH_HARD = register("woosh_hard");
/* 71 */   public static final RegistryObject<SoundEvent> WING = register("wing");
/* 72 */   public static final RegistryObject<SoundEvent> WHOOSH = register("whoosh");
/* 73 */   public static final RegistryObject<SoundEvent> COOL_DOWN = register("cooldown");
/* 74 */   public static final RegistryObject<SoundEvent> GET_OUT = register("get_out");
/* 75 */   public static final RegistryObject<SoundEvent> THROW = register("throw");
/* 76 */   public static final RegistryObject<SoundEvent> ENDER_SHOT = register("ender_shot");
/* 77 */   public static final RegistryObject<SoundEvent> BLOOM = register("bloom");
/* 78 */   public static final RegistryObject<SoundEvent> DRAGON_BREATH = register("dragon_breath");
/* 79 */   public static final RegistryObject<SoundEvent> BIG_BLOOM = register("big_boom");
/* 80 */   public static final RegistryObject<SoundEvent> DRAGON_BREATH_FINALE = register("dragon_breath_finale");
/* 81 */   public static final RegistryObject<SoundEvent> PORTAL_SUMMON = register("portal_summon");
/* 82 */   public static final RegistryObject<SoundEvent> PORTAL_NATURAL = register("portal_natural");
/* 83 */   public static final RegistryObject<SoundEvent> SELF_REQUESTING_ASSISTANCE = register("self_requesting_assistance");
/* 84 */   public static final RegistryObject<SoundEvent> GREG_REQUESTING_ASSISTANCE = register("greg_requesting_assistance");
/* 85 */   public static final RegistryObject<SoundEvent> HEROBRINE_UNDERSTOOD = register("herobrine_understood");
/* 86 */   public static final RegistryObject<SoundEvent> WOOPIE_WIND = register("woopie_wind");
/* 87 */   public static final RegistryObject<SoundEvent> KICK_GUARD_BREAK = register("kick_guard_break");
/* 88 */   public static final RegistryObject<SoundEvent> DRAGON_AMBIENT_SOUND = register("entity.dragon.ambient");
/* 89 */   public static final RegistryObject<SoundEvent> DRAGON_STEP_SOUND = register("entity.dragon.step");
/* 90 */   public static final RegistryObject<SoundEvent> DRAGON_DEATH_SOUND = register("entity.dragon.death");
/* 91 */   public static final RegistryObject<SoundEvent> DRAGON_THUNDER_SHOOT_SOUND = register("entity.dragon.thunder_shoot");
/* 92 */   public static final RegistryObject<SoundEvent> MUFFLED_BOOM = register("muffled_boom");
/*    */   
/*    */   private static RegistryObject<SoundEvent> register(String name) {
/* 95 */     return SOUNDS.register(name, () -> SoundEvent.m_262824_(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", name)));
/*    */   }
/*    */   
/*    */   public static void register(IEventBus bus) {
/* 99 */     SOUNDS.register(bus);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModSounds.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */