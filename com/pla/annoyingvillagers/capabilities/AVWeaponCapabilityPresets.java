/*     */ package com.pla.annoyingvillagers.capabilities;
/*     */ 
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSounds;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.TieredItem;
/*     */ import net.minecraft.world.item.Tiers;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsHerrscher;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsMoonless;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsRuine;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsSatsujin;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*     */ import reascer.wom.gameasset.colliders.WOMWeaponColliders;
/*     */ import yesman.epicfight.api.animation.AnimationManager;
/*     */ import yesman.epicfight.api.animation.LivingMotion;
/*     */ import yesman.epicfight.api.animation.LivingMotions;
/*     */ import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.gameasset.ColliderPreset;
/*     */ import yesman.epicfight.gameasset.EpicFightSkills;
/*     */ import yesman.epicfight.gameasset.EpicFightSounds;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.skill.Skill;
/*     */ import yesman.epicfight.skill.SkillSlot;
/*     */ import yesman.epicfight.skill.SkillSlots;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.capabilities.item.Style;
/*     */ import yesman.epicfight.world.capabilities.item.WeaponCapability;
/*     */ import yesman.epicfight.world.capabilities.item.WeaponCategory;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AVWeaponCapabilityPresets
/*     */ {
/*     */   public static final Function<Item, CapabilityItem.Builder> ENDER_AEGIS = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).styleProvider(()).canBePlacedOffhand(false).collider(ColliderPreset.SWORD).swingSound((SoundEvent)AVSounds.SWORD_WHOOSH.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AnimsHerrscher.HERRSCHER_AUTO_1, AnimsHerrscher.HERRSCHER_AUTO_2, AnimsHerrscher.HERRSCHER_AUTO_3, AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_1, AVAnimations.ENDER_AEGIS_MOONLESS_AUTO_2, AnimsSolar.SOLAR_QUEMADURA, AnimsSolar.SOLAR_OBSCURIDAD_IMPACTO, AnimsSolar.SOLAR_HORNO }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, Animations.BIPED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.BIPED_BLOCK).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> ENDER_GLAIVE = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SPEAR).styleProvider(()).collider(WOMWeaponColliders.AGONY).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_1, AVAnimations.ENDER_GLAIVE_NAPOLEON_AUTO_2, AnimsAgony.AGONY_AUTO_4, AnimsAgony.AGONY_AUTO_2, AnimsAgony.AGONY_AUTO_3, AVAnimations.ENDER_GLAIVE_NAPOLEON_AUSTERLITZ, AnimsAgony.AGONY_AIR_ATTACK_4 }).newStyleCombo((Style)CapabilityItem.Styles.MOUNT, new AnimationManager.AnimationAccessor[] { Animations.SPEAR_MOUNT_ATTACK }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, AVAnimations.VALOUR_HOLD_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, AVAnimations.VALOUR_WALK_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.VALOUR_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.VALOUR_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD);
/*     */   public static final Function<Item, CapabilityItem.Builder> DEMONIAC_VOLTAGE_REAVER = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.GREATSWORD).styleProvider(()).collider(ColliderPreset.GREATSWORD).swingSound((SoundEvent)EpicFightSounds.WHOOSH_BIG.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.DEMONIAC_RUINE_AUTO_1, WOMAnimations.TORMENT_BERSERK_AUTO_2, WOMAnimations.TORMENT_BERSERK_AUTO_1, AVAnimations.DEMONIAC_RUINE_AUTO_2, AVAnimations.DEMONIAC_RUINE_AUTO_4, AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, AVAnimations.DEMONIAC_RUINE_COMET }).newStyleCombo((Style)CapabilityItem.Styles.MOUNT, new AnimationManager.AnimationAccessor[] { Animations.SWORD_MOUNT_ATTACK }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, AVAnimations.VALOUR_HOLD_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, AVAnimations.VALOUR_WALK_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.VALOUR_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.VALOUR_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AnimsSolar.SOLAR_GUARD).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> OBSIDIAN_SLEDGEHAMMER = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.GREATSWORD).styleProvider(()).collider(ColliderPreset.GREATSWORD).swingSound((SoundEvent)EpicFightSounds.WHOOSH_BIG.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.DEMONIAC_RUINE_AUTO_1, AVAnimations.DEMONIAC_RUINE_AUTO_2, WOMAnimations.TORMENT_AUTO_4, AnimsSolar.SOLAR_AUTO_4, AnimsSolar.SOLAR_AUTO_2, AnimsSolar.SOLAR_OBSCURIDAD_AUTO_4, AnimsEnderblaster.ENDERBLASTER_TWOHAND_TISHNAW }).newStyleCombo((Style)CapabilityItem.Styles.MOUNT, new AnimationManager.AnimationAccessor[] { Animations.SWORD_MOUNT_ATTACK }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, AVAnimations.VALOUR_HOLD_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, AVAnimations.VALOUR_WALK_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.VALOUR_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.VALOUR_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AnimsRuine.RUINE_GUARD).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> ENDER_SLAYER_SCYTHE = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SPEAR).styleProvider(()).collider(WOMWeaponColliders.ANTITHEUS).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).swingSound((SoundEvent)EpicFightSounds.WHOOSH.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_3, WOMAnimations.KICK_AUTO_3, AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_2, WOMAnimations.KICK_AUTO_1, AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_4, AnimsEnderblaster.ENDERBLASTER_TWOHAND_AUTO_1, AVAnimations.CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).innateSkill((Style)CapabilityItem.Styles.MOUNT, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AnimsEnderblaster.ENDERBLASTER_TWOHAND_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.MOUNT, Animations.BIPED_MOUNT).livingMotionModifier((Style)CapabilityItem.Styles.MOUNT, (LivingMotion)LivingMotions.MOUNT, Animations.BIPED_MOUNT).livingMotionModifier((Style)CapabilityItem.Styles.MOUNT, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_MOUNT).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD);
/*     */   public static final Function<Item, CapabilityItem.Builder> NULL_WEAPON = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).styleProvider(()).collider(ColliderPreset.FIST).hitSound((SoundEvent)EpicFightSounds.BLUNT_HIT_HARD.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AnimsAgony.AGONY_AIR_ATTACK_1, WOMAnimations.ANTITHEUS_ASCENDED_AUTO_1, WOMAnimations.ANTITHEUS_ASCENDED_AUTO_2, WOMAnimations.ANTITHEUS_ASCENDED_AUTO_3, AVAnimations.CLONE_ANTITHEUS_ASCENDED_BLACKHOLE, AnimsAgony.AGONY_AIR_ATTACK_4, AnimsAgony.AGONY_AIR_ATTACK_3, AVAnimations.CLONE_ANTITHEUS_ASCENDED_DEATHFALL }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, AVAnimations.CLONE_ANTITHEUS_ASCENDED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, WOMAnimations.ANTITHEUS_ASCENDED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, WOMAnimations.ANTITHEUS_ASCENDED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, WOMAnimations.ANTITHEUS_ASCENDED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.FIST_GUARD);
/*     */   public static final Function<Item, CapabilityItem.Builder> OBSIDIAN_WEAPON = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).styleProvider(()).collider(ColliderPreset.FIST).hitSound((SoundEvent)EpicFightSounds.BLUNT_HIT_HARD.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.OBSIDIAN_FIST_AUTO1, AVAnimations.OBSIDIAN_FIST_AUTO2, AVAnimations.OBSIDIAN_FIST_AUTO3, AVAnimations.OBSIDIAN_FIST_AIR_SLASH, AVAnimations.OBSIDIAN_BIPED_LANDING, AVAnimations.OBSIDIAN_STRONG_PUNCH, AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.FIST_GUARD);
/*     */   public static final Function<Item, CapabilityItem.Builder> BEDROCK_WEAPON = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).styleProvider(()).collider(ColliderPreset.FIST).hitSound((SoundEvent)EpicFightSounds.BLUNT_HIT_HARD.get()).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { Animations.FIST_AUTO1, Animations.FIST_AUTO2, Animations.FIST_AUTO3, Animations.FIST_AIR_SLASH, WOMAnimations.STRONG_PUNCH, Animations.FIST_DASH, WOMAnimations.STRONG_KICK }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.BLOCK, AnimsMoonless.MOONLESS_GUARD);
/*     */   public static final Function<Item, CapabilityItem.Builder> SHADOW_OBSIDIAN_PILLAR = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).styleProvider(()).collider(ColliderPreset.FIST).hitSound((SoundEvent)EpicFightSounds.BLUNT_HIT_HARD.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.OBSIDIAN_FIST_AUTO1, AVAnimations.OBSIDIAN_FIST_AUTO2, AVAnimations.OBSIDIAN_FIST_AUTO3, AVAnimations.OBSIDIAN_FIST_AIR_SLASH, AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, AVAnimations.OBSIDIAN_STRONG_PUNCH, AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW }).newStyleCombo((Style)CapabilityItem.Styles.OCHS, new AnimationManager.AnimationAccessor[] { AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO1, AVAnimations.OBSIDIAN_FIST_AUTO2, AVAnimations.SHADOW_OBSIDIAN_FIST_AUTO3, AVAnimations.OBSIDIAN_FIST_AIR_SLASH, AVAnimations.OBSIDIAN_INFERNAL_AUTO_1, AVAnimations.OBSIDIAN_STRONG_PUNCH, AVAnimations.OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).innateSkill((Style)CapabilityItem.Styles.OCHS, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.FIST_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.BLOCK, AVAnimations.FIST_GUARD).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> SHADOW_OBSIDIAN_SWORD = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).canBePlacedOffhand(true).collider(ColliderPreset.SWORD).swingSound((SoundEvent)AnnoyingVillagersModSounds.OB_PLACE.get()).hitSound((SoundEvent)EpicFightSounds.BLUNT_HIT_HARD.get()).styleProvider(()).collider(ColliderPreset.SWORD).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1, AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2, AVAnimations.SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG, AVAnimations.SHADOW_OBSIDIAN_FIST_AIR_SLASH, AVAnimations.SWORD_HEAVY_AUTO_1, AVAnimations.SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM }).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2, AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4, AVAnimations.SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5, AVAnimations.GREATSWORD_DUAL_AUTO_2, AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3, WOMAnimations.TORMENT_DASH, AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.BLOCK, AnimsMoonless.MOONLESS_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.OLD_MOONLESS_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> LEGENDARY_SWORD = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.GREATSWORD).styleProvider(()).collider(ColliderPreset.GREATSWORD).swingSound((SoundEvent)EpicFightSounds.WHOOSH_BIG.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { WOMAnimations.TORMENT_AUTO_1, WOMAnimations.TORMENT_AUTO_2, AnimsSolar.SOLAR_AUTO_1, AVAnimations.LEGENDARY_SWORD_AUTO_4, AVAnimations.LEGENDARY_SWORD_WAKE_UP_ATTACK, AVAnimations.YELLOW_SOLAR_AUTO_2, AVAnimations.YELLOW_NAPOLEON_AUTO_3, AVAnimations.DEMONIAC_TORMENT_CHARGED_ATTACK_2, AVAnimations.YELLOW_NAPOLEON_AUSTERLITZ_SHOOT, WOMAnimations.TORMENT_BERSERK_DASH }).newStyleCombo((Style)CapabilityItem.Styles.MOUNT, new AnimationManager.AnimationAccessor[] { Animations.SWORD_MOUNT_ATTACK }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, AVAnimations.LEGENDARY_SWORD_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, AVAnimations.TORMENT_BERSERK_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.RUN_DUAL_BIG).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.RUN_DUAL_BIG).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.LEGENDARY_SWORD_GUARD).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> BLUE_DEMON_TRIDENT = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SPEAR).canBePlacedOffhand(true).collider(ColliderPreset.SPEAR).swingSound(SoundEvents.f_12520_).hitSound(SoundEvents.f_12516_).styleProvider(()).collider(ColliderPreset.SPEAR).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.ADVANCED_LANCER_AUTO1, AVAnimations.NERF_TSUNAMI_REINFORCED, AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR }).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.ADVANCED_LANCER_AUTO1, AVAnimations.TRIDENT_DUAL_AUTO2, AVAnimations.ADVANCED_DUELIST_SHOOTING_STAR, AVAnimations.CUT_DP_AIR_ATTACK, AVAnimations.ADVANCED_LANCER_AUTO3, AVAnimations.ADVANCED_DUELIST_WHIRLEDGE, AVAnimations.NERF_TSUNAMI_REINFORCED, AVAnimations.CUT_HOOK_SPIN_SLASH_AIR }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.TRIDENT_TWO_HAND_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.TRIDENT_TWO_HAND_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> WOOPIE_THE_SWORD = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).styleProvider(()).collider(ColliderPreset.SWORD).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).swingSound((SoundEvent)AVSounds.SWORD_WHOOSH.get()).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { Animations.SWORD_AUTO1, Animations.SWORD_AUTO2, Animations.SWORD_AUTO3, AnimsSatsujin.SATSUJIN_AUTO_1, AnimsSatsujin.SATSUJIN_AUTO_2, AnimsHerrscher.HERRSCHER_VERDAMMNIS, AnimsSatsujin.SATSUJIN_TSUKUYOMI }).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.SWORD_DUAL_AUTO1, Animations.SWORD_DUAL_AUTO2, Animations.SWORD_DUAL_AUTO3, AnimsSatsujin.SATSUJIN_AUTO_1, AnimsSatsujin.SATSUJIN_AUTO_2, AnimsHerrscher.HERRSCHER_VERDAMMNIS, AnimsSatsujin.SATSUJIN_TSUKUYOMI }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.RUN_HOLD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.RUN_HOLD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> GREAT_SWORD = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).styleProvider(()).collider(ColliderPreset.SWORD).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).swingSound((SoundEvent)AVSounds.SWORD_WHOOSH.get()).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { Animations.SWORD_AUTO1, Animations.SWORD_AUTO2, Animations.SWORD_AUTO3, AnimsHerrscher.HERRSCHER_AUTO_3, AnimsSatsujin.SATSUJIN_AUTO_3, AnimsSatsujin.SATSUJIN_HARUSAKI, AnimsHerrscher.HERRSCHER_AUSROTTUNG }).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.SWORD_DUAL_AUTO1, Animations.SWORD_DUAL_AUTO2, Animations.SWORD_DUAL_AUTO3, AnimsHerrscher.HERRSCHER_AUTO_3, AnimsSatsujin.SATSUJIN_AUTO_3, AnimsSatsujin.SATSUJIN_HARUSAKI, AnimsHerrscher.HERRSCHER_AUSROTTUNG }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.RUN_HOLD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.RUN_HOLD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON).weaponCombinationPredicator(());
/*     */   public static final Function<Item, CapabilityItem.Builder> AV_SWORD;
/*     */   
/*     */   static {
/* 481 */     AV_SWORD = (item -> {
/*     */         WeaponCapability.Builder builder = WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SWORD).swingSound((SoundEvent)AVSounds.SWORD_WHOOSH.get()).styleProvider(()).collider(ColliderPreset.SWORD).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { Animations.SWORD_AUTO1, Animations.SWORD_AUTO2, Animations.SWORD_AUTO3, AnimsHerrscher.HERRSCHER_AUTO_1, AnimsHerrscher.HERRSCHER_AUTO_2, Animations.SWORD_DASH, Animations.SWORD_AIR_SLASH }).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.SWORD_DUAL_AUTO1, Animations.SWORD_DUAL_AUTO2, Animations.SWORD_DUAL_AUTO3, AVAnimations.DUAL_SWORD1, AVAnimations.DUAL_SWORD2, AVAnimations.DUAL_SWORD3, Animations.SWORD_DUAL_DASH, Animations.SWORD_DUAL_AIR_SLASH }).newStyleCombo((Style)CapabilityItem.Styles.MOUNT, new AnimationManager.AnimationAccessor[] { Animations.SWORD_DUAL_AUTO1, Animations.SWORD_DUAL_AUTO2, Animations.SWORD_DUAL_AUTO3, Animations.SWORD_MOUNT_ATTACK }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.RUN_HOLD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.RUN_HOLD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON).weaponCombinationPredicator(());
/*     */         if (item instanceof TieredItem) {
/*     */           TieredItem tieredItem = (TieredItem)item;
/*     */           builder.addStyleAttibutes((Style)CapabilityItem.Styles.COMMON, Pair.of(EpicFightAttributes.IMPACT.get(), EpicFightAttributes.getImpactModifier(0.5D + 0.2D * tieredItem.m_43314_().m_6604_())));
/*     */           builder.addStyleAttibutes((Style)CapabilityItem.Styles.COMMON, Pair.of(EpicFightAttributes.MAX_STRIKES.get(), EpicFightAttributes.getMaxStrikesModifier(1)));
/*     */           builder.hitSound((tieredItem.m_43314_() == Tiers.WOOD) ? (SoundEvent)EpicFightSounds.BLUNT_HIT.get() : (SoundEvent)EpicFightSounds.BLADE_HIT.get());
/*     */           builder.hitParticle((tieredItem.m_43314_() == Tiers.WOOD) ? (HitParticleType)EpicFightParticles.HIT_BLUNT.get() : (HitParticleType)EpicFightParticles.HIT_BLADE.get());
/*     */         } 
/*     */         return (CapabilityItem.Builder)builder;
/*     */       });
/*     */   }
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
/*     */   
/*     */   public static final Function<Item, CapabilityItem.Builder> AV_AXE = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.AXE).collider(ColliderPreset.TOOLS).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { Animations.AXE_AUTO1, Animations.AXE_AUTO2, Animations.SWORD_AUTO1, Animations.SWORD_AUTO2, Animations.SWORD_AUTO3, Animations.AXE_DASH, Animations.AXE_AIRSLASH }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.CHASE, Animations.BIPED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.BIPED_BLOCK).collider(ColliderPreset.TOOLS);
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
/*     */   public static final Function<Item, CapabilityItem.Builder> AV_SPEAR = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.SPEAR).styleProvider(()).collider(ColliderPreset.SPEAR).swingSound((SoundEvent)AVSounds.SWORD_WHOOSH.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { Animations.SPEAR_ONEHAND_AUTO, AnimsAgony.AGONY_AUTO_4, Animations.SPEAR_DASH, WOMAnimations.STAFF_KINKONG }).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.SPEAR_TWOHAND_AUTO1, Animations.SPEAR_TWOHAND_AUTO2, AnimsAgony.AGONY_AUTO_4, WOMAnimations.STAFF_AUTO_2, WOMAnimations.STAFF_AUTO_3, Animations.SPEAR_DASH, Animations.SPEAR_TWOHAND_AIR_SLASH }).newStyleCombo((Style)CapabilityItem.Styles.MOUNT, new AnimationManager.AnimationAccessor[] { Animations.SPEAR_MOUNT_ATTACK, Animations.SPEAR_TWOHAND_AUTO1, Animations.SPEAR_TWOHAND_AUTO2, WOMAnimations.STAFF_AUTO_2 }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN_SPEAR).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_SPEAR).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN_SPEAR).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, Animations.BIPED_RUN_SPEAR).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK_SPEAR).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.GLOWING_AGONY_GUARD);
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
/*     */   public static final Function<Item, CapabilityItem.Builder> AV_TACHI = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.TACHI).collider(ColliderPreset.TACHI).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).swingSound((SoundEvent)AVSounds.SWORD_WHOOSH.get()).styleProvider(()).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.TACHI_AUTO1, Animations.TACHI_AUTO2, AnimsRuine.RUINE_AUTO_1, Animations.TACHI_AUTO3, AnimsRuine.RUINE_CHATIMENT, AVAnimations.TACHI_DASH, Animations.LONGSWORD_AIR_SLASH }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).newStyleCombo((Style)CapabilityItem.Styles.OCHS, new AnimationManager.AnimationAccessor[] { Animations.SWORD_DUAL_AUTO1, Animations.SWORD_DUAL_AUTO2, AVAnimations.DUAL_SWORD_AUTO3, AVAnimations.DUAL_SWORD_AUTO4, AVAnimations.DUAL_SWORD_AUTO5, Animations.SWORD_DUAL_DASH, Animations.SWORD_DUAL_AIR_SLASH }).newStyleCombo((Style)CapabilityItem.Styles.MOUNT, new AnimationManager.AnimationAccessor[] { Animations.SWORD_MOUNT_ATTACK }).innateSkill((Style)CapabilityItem.Styles.OCHS, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_TACHI).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_TACHI).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_HOLD_TACHI).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, Animations.BIPED_HOLD_TACHI).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.LONGSWORD_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_TACHI).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_TACHI).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.RUN, AVAnimations.RUN_DUAL_BIG).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.CHASE, AVAnimations.RUN_DUAL_BIG).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.BLOCK, AVAnimations.DUAL_TACHI_GUARD).innateSkill((Style)CapabilityItem.Styles.OCHS, ()).weaponCombinationPredicator(());
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
/*     */   public static final Function<Item, CapabilityItem.Builder> AV_LONGSWORD = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.LONGSWORD).styleProvider(()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).collider(ColliderPreset.LONGSWORD).swingSound((SoundEvent)AVSounds.SWORD_WHOOSH.get()).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { Animations.LONGSWORD_AUTO1, Animations.LONGSWORD_AUTO2, Animations.LONGSWORD_AUTO3, Animations.LONGSWORD_DASH, Animations.LONGSWORD_AIR_SLASH }).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.LONGSWORD_AUTO1, Animations.LONGSWORD_AUTO1, Animations.LONGSWORD_AUTO2, Animations.LONGSWORD_AUTO3, AVAnimations.DUAL_SWORD_AUTO1, AVAnimations.DUAL_SWORD_AUTO2, Animations.LONGSWORD_DASH, Animations.LONGSWORD_AIR_SLASH }).newStyleCombo((Style)CapabilityItem.Styles.OCHS, new AnimationManager.AnimationAccessor[] { AnimsRuine.RUINE_AUTO_1, AnimsRuine.RUINE_AUTO_2, AnimsRuine.RUINE_AUTO_3, AnimsRuine.RUINE_CHATIMENT, Animations.LONGSWORD_DASH, Animations.LONGSWORD_AIR_SLASH }).innateSkill((Style)CapabilityItem.Styles.ONE_HAND, ()).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).innateSkill((Style)CapabilityItem.Styles.OCHS, ()).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN_LONGSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.RUN_DUAL_BIG).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.IDLE, AnimsRuine.RUINE_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.WALK, AnimsRuine.RUINE_WALK).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.RUN, AnimsRuine.RUINE_RUN).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.LONGSWORD_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, Animations.LONGSWORD_GUARD).livingMotionModifier((Style)CapabilityItem.Styles.OCHS, (LivingMotion)LivingMotions.BLOCK, AnimsRuine.RUINE_GUARD);
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
/*     */   public static final Function<Item, CapabilityItem.Builder> AV_GREATSWORD = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.GREATSWORD).styleProvider(()).collider(ColliderPreset.GREATSWORD).swingSound((SoundEvent)EpicFightSounds.WHOOSH_BIG.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.GREATSWORD_AUTO1, Animations.GREATSWORD_AUTO2, WOMAnimations.TORMENT_AUTO_2, WOMAnimations.TORMENT_AUTO_3, AnimsSolar.SOLAR_HORNO, Animations.GREATSWORD_DASH, Animations.GREATSWORD_AIR_SLASH }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, Animations.BIPED_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AnimsSolar.SOLAR_GUARD);
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
/*     */   public static final Function<Item, CapabilityItem.Builder> WOODEN_DOOR = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.GREATSWORD).styleProvider(()).collider(ColliderPreset.GREATSWORD).swingSound(SoundEvents.f_12627_).hitSound(SoundEvents.f_12626_).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.GREATSWORD_AUTO1, Animations.GREATSWORD_AUTO2, WOMAnimations.TORMENT_AUTO_2, WOMAnimations.TORMENT_AUTO_3, Animations.GREATSWORD_DASH, WOMAnimations.TORMENT_AIRSLAM }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_HOLD_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, Animations.BIPED_RUN_GREATSWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AnimsSolar.SOLAR_GUARD);
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
/*     */   public static final Function<Item, CapabilityItem.Builder> TRAPDOOR = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.AXE).styleProvider(()).collider(ColliderPreset.SWORD).swingSound(SoundEvents.f_12629_).hitSound(SoundEvents.f_12628_).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.SWORD_AUTO1, Animations.SWORD_AUTO3, Animations.SWORD_AUTO2, AnimsHerrscher.HERRSCHER_AUTO_3, AnimsHerrscher.HERRSCHER_VERDAMMNIS, Animations.SWORD_AIR_SLASH }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.SHIELD_MAINHAND);
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
/*     */   public static final Function<Item, CapabilityItem.Builder> CRAFTING_TABLE = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.GREATSWORD).styleProvider(()).collider(ColliderPreset.GREATSWORD).swingSound((SoundEvent)EpicFightSounds.WHOOSH_BIG.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.TACHI_AUTO2, Animations.TACHI_AUTO3, AnimsRuine.RUINE_AUTO_1, AnimsRuine.RUINE_AUTO_2, AnimsRuine.RUINE_CHATIMENT, Animations.LONGSWORD_AIR_SLASH }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, AVAnimations.CARRY).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, AVAnimations.CARRY).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, AVAnimations.CARRY).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, AVAnimations.CARRY).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AVAnimations.CARRY);
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
/*     */   public static final Function<Item, CapabilityItem.Builder> LADDER = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.AXE).styleProvider(()).collider(ColliderPreset.SWORD).swingSound(SoundEvents.f_12024_).hitSound(SoundEvents.f_12022_).newStyleCombo((Style)CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[] { Animations.SWORD_AUTO1, Animations.SWORD_AUTO3, AVAnimations.SWORD_HEAVY_AUTO_1, Animations.TACHI_AUTO3, Animations.SWORD_DASH, Animations.SWORD_AIR_SLASH }).innateSkill((Style)CapabilityItem.Styles.TWO_HAND, ()).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.CHASE, Animations.BIPED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.TWO_HAND, (LivingMotion)LivingMotions.BLOCK, AnimsMoonless.MOONLESS_GUARD);
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
/*     */   public static final Function<Item, CapabilityItem.Builder> BOW = item -> WeaponCapability.builder().category((WeaponCategory)CapabilityItem.WeaponCategories.RANGED).styleProvider(()).zoomInType(CapabilityItem.ZoomInType.USE_TICK).swingSound(SoundEvents.f_11687_).hitSound(SoundEvents.f_11685_).canBePlacedOffhand(false).newStyleCombo((Style)CapabilityItem.Styles.ONE_HAND, new AnimationManager.AnimationAccessor[] { AVAnimations.BOW_AUTO_1, AVAnimations.BOW_AUTO_3, AVAnimations.BOW_AUTO_5 }).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.IDLE, Animations.BIPED_IDLE).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.WALK, Animations.BIPED_WALK).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.RUN, Animations.BIPED_RUN).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.AIM, Animations.BIPED_BOW_AIM).livingMotionModifier((Style)CapabilityItem.Styles.ONE_HAND, (LivingMotion)LivingMotions.SHOT, Animations.BIPED_BOW_SHOT).constructor(AVBowCapability::new);
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
/*     */   public static void register(WeaponCapabilityPresetRegistryEvent weaponcapabilitypresetregistryevent) {
/* 832 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "ender_aegis"), ENDER_AEGIS);
/* 833 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "ender_glaive"), ENDER_GLAIVE);
/* 834 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "demoniac_voltage_reaver"), DEMONIAC_VOLTAGE_REAVER);
/* 835 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "obsidian_sledgehammer"), OBSIDIAN_SLEDGEHAMMER);
/* 836 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "ender_slayer_scythe"), ENDER_SLAYER_SCYTHE);
/* 837 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "null_weapon"), NULL_WEAPON);
/* 838 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "obsidian_weapon"), OBSIDIAN_WEAPON);
/* 839 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "bedrock_weapon"), BEDROCK_WEAPON);
/* 840 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "shadow_obsidian_pillar"), SHADOW_OBSIDIAN_PILLAR);
/* 841 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "shadow_obsidian_sword"), SHADOW_OBSIDIAN_SWORD);
/* 842 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "legendary_sword"), LEGENDARY_SWORD);
/* 843 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "blue_demon_trident"), BLUE_DEMON_TRIDENT);
/* 844 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "woopie_the_sword"), WOOPIE_THE_SWORD);
/* 845 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "great_sword"), GREAT_SWORD);
/* 846 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "av_sword"), AV_SWORD);
/* 847 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "av_axe"), AV_AXE);
/* 848 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "av_spear"), AV_SPEAR);
/* 849 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "av_tachi"), AV_TACHI);
/* 850 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "av_longsword"), AV_LONGSWORD);
/* 851 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "av_greatsword"), AV_GREATSWORD);
/* 852 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "av_bow"), BOW);
/* 853 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "wooden_door"), WOODEN_DOOR);
/* 854 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "crafting_table"), CRAFTING_TABLE);
/* 855 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "trapdoor"), TRAPDOOR);
/* 856 */     weaponcapabilitypresetregistryevent.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "ladder"), LADDER);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\capabilities\AVWeaponCapabilityPresets.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */