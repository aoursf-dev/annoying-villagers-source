/*    */ package com.pla.annoyingvillagers.gameasset;
/*    */ 
/*    */ import java.util.function.Function;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import reascer.wom.gameasset.WOMAnimations;
/*    */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*    */ import yesman.epicfight.api.forgeevent.SkillBuildEvent;
/*    */ import yesman.epicfight.skill.Skill;
/*    */ import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
/*    */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.MOD)
/*    */ public class AVSkills
/*    */ {
/*    */   public static Skill ENDER_AEGIS;
/*    */   public static Skill ENDER_GLAIVE;
/*    */   public static Skill DEMONIAC_VOLTAGE_REAVER;
/*    */   public static Skill OBSIDIAN_SLEDGEHAMMER;
/*    */   public static Skill ENDER_SLAYER_SCYTHE;
/*    */   public static Skill NULL_WEAPON;
/*    */   public static Skill OBSIDIAN_WEAPON;
/*    */   public static Skill BEDROCK_WEAPON;
/*    */   public static Skill SHADOW_OBSIDIAN_PILLAR;
/*    */   public static Skill SHADOW_OBSIDIAN_PILLAR_SWORD;
/*    */   public static Skill SHADOW_OBSIDIAN_SWORD;
/*    */   public static Skill SHADOW_OBSIDIAN_SWORD_DUAL;
/*    */   public static Skill TRIDENT_FESTIVAL;
/*    */   public static Skill LEGENDARY_SWORD;
/*    */   public static Skill WOOPIE_THE_SWORD;
/*    */   public static Skill GREAT_SWORD;
/*    */   public static Skill CRAFTING_TABLE;
/*    */   public static Skill WOODEN_DOOR;
/*    */   public static Skill TRAPDOOR;
/*    */   public static Skill LADDER;
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void buildSkillEvent(SkillBuildEvent skillbuildevent) {
/* 41 */     SkillBuildEvent.ModRegistryWorker modRegistry = skillbuildevent.createRegistryWorker("annoyingvillagers");
/* 42 */     ENDER_AEGIS = modRegistry.build("ender_aegis", com.pla.annoyingvillagers.skill.EnderAegisSkill::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(Skill.ActivateType.DURATION));
/* 43 */     ENDER_GLAIVE = modRegistry.build("ender_glaive", com.pla.annoyingvillagers.skill.EnderGlaiveSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 44 */     DEMONIAC_VOLTAGE_REAVER = modRegistry.build("demoniac_voltage_reaver", com.pla.annoyingvillagers.skill.DemoniacVoltageReaverSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 45 */     OBSIDIAN_SLEDGEHAMMER = modRegistry.build("obsidian_sledgehammer", com.pla.annoyingvillagers.skill.ObsidianSledgeHammerSkill::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(Skill.ActivateType.DURATION));
/* 46 */     ENDER_SLAYER_SCYTHE = modRegistry.build("ender_slayer_scythe", com.pla.annoyingvillagers.skill.EnderSlayerScytheSkill::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(Skill.ActivateType.DURATION));
/* 47 */     NULL_WEAPON = modRegistry.build("null_weapon", com.pla.annoyingvillagers.skill.NullWeaponSkill::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(Skill.ActivateType.DURATION));
/* 48 */     OBSIDIAN_WEAPON = modRegistry.build("obsidian_weapon", com.pla.annoyingvillagers.skill.ObsidianWeaponSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 49 */     BEDROCK_WEAPON = modRegistry.build("bedrock_weapon", com.pla.annoyingvillagers.skill.BedrockWeaponSkill::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(Skill.ActivateType.DURATION));
/* 50 */     SHADOW_OBSIDIAN_PILLAR = modRegistry.build("shadow_obsidian_pillar", com.pla.annoyingvillagers.skill.ShadowObsidianPillarSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 51 */     SHADOW_OBSIDIAN_PILLAR_SWORD = modRegistry.build("shadow_obsidian_pillar_sword", com.pla.annoyingvillagers.skill.ShadowObsidianPillarSwordSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 52 */     SHADOW_OBSIDIAN_SWORD = modRegistry.build("shadow_obsidian_sword", com.pla.annoyingvillagers.skill.ShadowObsidianSwordSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 53 */     SHADOW_OBSIDIAN_SWORD_DUAL = modRegistry.build("shadow_obsidian_sword_dual", com.pla.annoyingvillagers.skill.ShadowObsidianSwordDualSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 54 */     LEGENDARY_SWORD = modRegistry.build("legendary_sword", com.pla.annoyingvillagers.skill.LegendarySwordSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 55 */     TRIDENT_FESTIVAL = modRegistry.build("trident_festival", com.pla.annoyingvillagers.skill.TridentFestivalSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 56 */     WOOPIE_THE_SWORD = modRegistry.build("woopie_the_sword", com.pla.annoyingvillagers.skill.WoopieTheSwordSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
/* 57 */     GREAT_SWORD = modRegistry.build("great_sword", com.pla.annoyingvillagers.skill.GreatSwordSkill::new, WeaponInnateSkill.createWeaponInnateBuilder().setActivateType(Skill.ActivateType.DURATION));
/* 58 */     CRAFTING_TABLE = (Skill)((SimpleWeaponInnateSkill)modRegistry.build("crafting_table", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(AnimsSolar.SOLAR_AUTO_2).setActivateType(Skill.ActivateType.ONE_SHOT).setResource(Skill.Resource.STAMINA))).newProperty();
/* 59 */     WOODEN_DOOR = (Skill)((SimpleWeaponInnateSkill)modRegistry.build("wooden_door", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(WOMAnimations.TORMENT_BERSERK_DASH).setActivateType(Skill.ActivateType.ONE_SHOT).setResource(Skill.Resource.STAMINA))).newProperty();
/* 60 */     TRAPDOOR = (Skill)((SimpleWeaponInnateSkill)modRegistry.build("trapdoor", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(AVAnimations.GIANT_WHIRLWIND).setActivateType(Skill.ActivateType.ONE_SHOT).setResource(Skill.Resource.STAMINA))).newProperty();
/* 61 */     LADDER = (Skill)((SimpleWeaponInnateSkill)modRegistry.build("ladder", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(AVAnimations.SWORD_HEAVY_AUTO_3).setActivateType(Skill.ActivateType.ONE_SHOT).setResource(Skill.Resource.STAMINA))).newProperty();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\gameasset\AVSkills.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */