/*      */ package com.pla.annoyingvillagers.gameasset;
/*      */ 
/*      */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*      */ import com.pla.annoyingvillagers.animations.BowAttackAnimation;
/*      */ import com.pla.annoyingvillagers.animations.HeavyAttackAnimation;
/*      */ import com.pla.annoyingvillagers.animations.RushSwordAnimation;
/*      */ import com.pla.annoyingvillagers.block.ObsidianBlock;
/*      */ import com.pla.annoyingvillagers.block.ShadowObsidianBlock;
/*      */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*      */ import com.pla.annoyingvillagers.clazz.TridentMode;
/*      */ import com.pla.annoyingvillagers.entity.BlockProjectileEntity;
/*      */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*      */ import com.pla.annoyingvillagers.entity.BlueDemonThrownTridentEntity;
/*      */ import com.pla.annoyingvillagers.entity.BlueDemonThunderBeamEntity;
/*      */ import com.pla.annoyingvillagers.entity.NullEntity;
/*      */ import com.pla.annoyingvillagers.entity.NullSkeletonEntity;
/*      */ import com.pla.annoyingvillagers.entity.ShadowHerobrineEntity;
/*      */ import com.pla.annoyingvillagers.entity.TridentLightningBolt;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*      */ import com.pla.annoyingvillagers.item.BlueDemonChestplateItem;
/*      */ import com.pla.annoyingvillagers.item.BlueDemonTridentItem;
/*      */ import com.pla.annoyingvillagers.item.EnderAegisItem;
/*      */ import com.pla.annoyingvillagers.network.ClientboundGlaiveExplosionFx;
/*      */ import com.pla.annoyingvillagers.network.ClientboundMuteExplosionAtPos;
/*      */ import com.pla.annoyingvillagers.task.DelayedTask;
/*      */ import com.pla.annoyingvillagers.util.BowFunction;
/*      */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*      */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*      */ import com.pla.annoyingvillagers.util.ScreenShakeUtil;
/*      */ import com.pla.annoyingvillagers.util.ShockwaveUtil;
/*      */ import com.pla.annoyingvillagers.util.SnakeBladeHit;
/*      */ import java.util.List;
/*      */ import java.util.Objects;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.core.Direction;
/*      */ import net.minecraft.core.Position;
/*      */ import net.minecraft.core.Vec3i;
/*      */ import net.minecraft.core.particles.ParticleOptions;
/*      */ import net.minecraft.core.particles.ParticleTypes;
/*      */ import net.minecraft.resources.ResourceLocation;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.sounds.SoundEvent;
/*      */ import net.minecraft.sounds.SoundEvents;
/*      */ import net.minecraft.sounds.SoundSource;
/*      */ import net.minecraft.util.Mth;
/*      */ import net.minecraft.world.InteractionHand;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.entity.EntityDimensions;
/*      */ import net.minecraft.world.entity.EntityType;
/*      */ import net.minecraft.world.entity.EquipmentSlot;
/*      */ import net.minecraft.world.entity.LivingEntity;
/*      */ import net.minecraft.world.entity.Mob;
/*      */ import net.minecraft.world.entity.MobSpawnType;
/*      */ import net.minecraft.world.entity.MoverType;
/*      */ import net.minecraft.world.entity.player.Player;
/*      */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*      */ import net.minecraft.world.item.Item;
/*      */ import net.minecraft.world.item.ItemCooldowns;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.level.BlockGetter;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.level.ServerLevelAccessor;
/*      */ import net.minecraft.world.level.block.Block;
/*      */ import net.minecraft.world.level.block.Blocks;
/*      */ import net.minecraft.world.level.block.state.BlockState;
/*      */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*      */ import net.minecraft.world.level.block.state.properties.Property;
/*      */ import net.minecraft.world.phys.AABB;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*      */ import net.minecraftforge.fml.common.Mod;
/*      */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*      */ import net.minecraftforge.network.PacketDistributor;
/*      */ import net.minecraftforge.registries.ForgeRegistries;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.joml.Math;
/*      */ import reascer.wom.animation.WomAnimationProperty;
/*      */ import reascer.wom.animation.attacks.AntitheusShootAttackAnimation;
/*      */ import reascer.wom.animation.attacks.BasicMultipleAttackAnimation;
/*      */ import reascer.wom.animation.attacks.SpecialAttackAnimation;
/*      */ import reascer.wom.gameasset.WOMAnimations;
/*      */ import reascer.wom.gameasset.WOMSounds;
/*      */ import reascer.wom.gameasset.colliders.WOMWeaponColliders;
/*      */ import reascer.wom.particle.WOMParticles;
/*      */ import reascer.wom.world.damagesources.WOMExtraDamageInstance;
/*      */ import yesman.epicfight.api.animation.AnimationManager;
/*      */ import yesman.epicfight.api.animation.Joint;
/*      */ import yesman.epicfight.api.animation.Keyframe;
/*      */ import yesman.epicfight.api.animation.TransformSheet;
/*      */ import yesman.epicfight.api.animation.property.AnimationEvent;
/*      */ import yesman.epicfight.api.animation.property.AnimationParameters;
/*      */ import yesman.epicfight.api.animation.property.AnimationProperty;
/*      */ import yesman.epicfight.api.animation.property.MoveCoordFunctions;
/*      */ import yesman.epicfight.api.animation.types.ActionAnimation;
/*      */ import yesman.epicfight.api.animation.types.AirSlashAnimation;
/*      */ import yesman.epicfight.api.animation.types.AttackAnimation;
/*      */ import yesman.epicfight.api.animation.types.BasicAttackAnimation;
/*      */ import yesman.epicfight.api.animation.types.DashAttackAnimation;
/*      */ import yesman.epicfight.api.animation.types.DodgeAnimation;
/*      */ import yesman.epicfight.api.animation.types.DynamicAnimation;
/*      */ import yesman.epicfight.api.animation.types.EntityState;
/*      */ import yesman.epicfight.api.animation.types.GuardAnimation;
/*      */ import yesman.epicfight.api.animation.types.KnockdownAnimation;
/*      */ import yesman.epicfight.api.animation.types.LongHitAnimation;
/*      */ import yesman.epicfight.api.animation.types.MovementAnimation;
/*      */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*      */ import yesman.epicfight.api.asset.AssetAccessor;
/*      */ import yesman.epicfight.api.utils.HitEntityList;
/*      */ import yesman.epicfight.api.utils.LevelUtil;
/*      */ import yesman.epicfight.api.utils.TimePairList;
/*      */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*      */ import yesman.epicfight.api.utils.math.ValueModifier;
/*      */ import yesman.epicfight.api.utils.math.Vec3f;
/*      */ import yesman.epicfight.gameasset.Animations;
/*      */ import yesman.epicfight.gameasset.Armatures;
/*      */ import yesman.epicfight.gameasset.ColliderPreset;
/*      */ import yesman.epicfight.gameasset.EpicFightSounds;
/*      */ import yesman.epicfight.model.armature.HumanoidArmature;
/*      */ import yesman.epicfight.particle.EpicFightParticles;
/*      */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*      */ import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
/*      */ import yesman.epicfight.world.damagesource.ExtraDamageInstance;
/*      */ import yesman.epicfight.world.damagesource.StunType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.MOD)
/*      */ public class AVAnimations
/*      */ {
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> EAT_OFFHAND;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> DRINK_OFFHAND;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> SHIELD_MAINHAND;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> AEGIS_SHIELD_SHOOT;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> SHIELD_OFFHAND;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> OBSIDIAN_FIST_AUTO1;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> OBSIDIAN_FIST_AUTO2;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> OBSIDIAN_FIST_AUTO3;
/*      */   public static AnimationManager.AnimationAccessor<AirSlashAnimation> OBSIDIAN_FIST_AIR_SLASH;
/*      */   public static AnimationManager.AnimationAccessor<AirSlashAnimation> SHADOW_OBSIDIAN_FIST_AIR_SLASH;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> OBSIDIAN_BIPED_LANDING;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> OBSIDIAN_ZOMBIE_ATTACK3;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SHADOW_OBSIDIAN_FIST_AUTO1;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SHADOW_OBSIDIAN_FIST_AUTO3;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> SHADOW_HEROBRINE_BIPED_LANDING;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> NERF_TSUNAMI_REINFORCED;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> BLUE_DEMON_DIE_LEGENDARY_SWORD_START;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> BLUE_DEMON_DIE_LEGENDARY_SWORD_TICK;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> INFERNAL_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> INFERNAL_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> INFERNAL_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> OBSIDIAN_INFERNAL_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> OBSIDIAN_INFERNAL_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BowAttackAnimation> BOW_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BowAttackAnimation> BOW_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BowAttackAnimation> BOW_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<BowAttackAnimation> BOW_AUTO_4;
/*      */   public static AnimationManager.AnimationAccessor<BowAttackAnimation> BOW_AUTO_5;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> VALOUR_HOLD_GREATSWORD;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> VALOUR_WALK_GREATSWORD;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> VALOUR_RUN_GREATSWORD;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> VALOUR_FIST_GUARD;
/*      */   public static AnimationManager.AnimationAccessor<GuardAnimation> VALOUR_FIST_GUARD_HIT;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> CASTING_ONE_HAND_TOP;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> CASTING_ONE_HAND_INWARD;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> CASTING_ONE_HAND_BUFF;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> GREATSWORD_TWOHAND_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> GREATSWORD_TWOHAND_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> GREATSWORD_DUAL_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> GREATSWORD_DUAL_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> GREATSWORD_DUAL_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> GREATSWORD_DUAL_AUTO_4;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> GREATSWORD_DUAL_DASH;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> GREATSWORD_DUAL_AIRSLASH;
/*      */   public static AnimationManager.AnimationAccessor<SpecialAttackAnimation> GREATSWORD_DUAL_EARTHQUAKE;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH;
/*      */   public static AnimationManager.AnimationAccessor<SpecialAttackAnimation> SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE;
/*      */   public static AnimationManager.AnimationAccessor<SpecialAttackAnimation> SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE_PILLAR;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> BLUE_DEMON_STATE_TRANSFORM;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> BLUE_DEMON_STATE_TRANSFORM_END;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> BLUE_DEMON_DIE;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> TRIDENT_FESTIVAL;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> COUNTER;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> FIST_GUARD;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> FIST_DASH;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> WHIRLWIND_KICK;
/*      */   public static AnimationManager.AnimationAccessor<HeavyAttackAnimation> LEGENDARY_SWORD_HEAVY_ATTACK;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> HACKER_SWORD_SKILL;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD_AUTO1;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD_AUTO2;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> TRIDENT_DUAL_AUTO2;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD_AUTO3;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD_AUTO4;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD_AUTO5;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD1;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD2;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> FIST_UP;
/*      */   public static AnimationManager.AnimationAccessor<RushSwordAnimation> RUSH_SWORD;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> DUAL_DANCING_EDGE;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> SWEEPING_EDGE;
/*      */   public static AnimationManager.AnimationAccessor<LongHitAnimation> HIT_BACKWARD;
/*      */   public static AnimationManager.AnimationAccessor<GuardAnimation> SPEAR_GUARD_HIT;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> LEGENDARY_SWORD_GUARD;
/*      */   public static AnimationManager.AnimationAccessor<GuardAnimation> LEGENDARY_SWORD_GUARD_HIT;
/*      */   public static AnimationManager.AnimationAccessor<GuardAnimation> LEGENDARY_SWORD_GUARD_PARRY;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> POSE_UP;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DAGGER_AUTO1;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DAGGER_AUTO2;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DAGGER_AUTO3;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DAGGER_DUAL_AUTO1;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DAGGER_DUAL_AUTO2;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DAGGER_DUAL_AUTO3;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DAGGER_DUAL_AUTO4;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> CHECK;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> BIPED_RUN_ESWORD;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> KNIFE_IDLE;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> KNIFE_RUN;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> KNIFE_ATTACK;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> KNIFE_CHECK;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> CARRY;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> FIST_LEFT;
/*      */   public static AnimationManager.AnimationAccessor<KnockdownAnimation> KNOCKDOWN_FORWARD;
/*      */   public static AnimationManager.AnimationAccessor<KnockdownAnimation> KNOCKDOWN_RIGHT;
/*      */   public static AnimationManager.AnimationAccessor<KnockdownAnimation> KNOCKDOWN_LEFT;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> AXE_HEAVY_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> AXE_HEAVY_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SWORD_HEAVY_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SWORD_HEAVY_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SWORD_HEAVY_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> HARD_KICK;
/*      */   public static AnimationManager.AnimationAccessor<LongHitAnimation> HARD_KICK_HIT;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> RUN_START;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> LONGSWORD_AUTO1;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> RUN_DUAL_BIG;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> RUN_HOLD;
/*      */   public static AnimationManager.AnimationAccessor<KnockdownAnimation> LONGEST_HIT;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> HARD_GREATSWORD_GUARD;
/*      */   public static AnimationManager.AnimationAccessor<GuardAnimation> HARD_GREATSWORD_GUARD_HIT;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> HARD_GREATSWORD_GUARD_SKILL;
/*      */   public static AnimationManager.AnimationAccessor<LongHitAnimation> HIT_LEFT;
/*      */   public static AnimationManager.AnimationAccessor<LongHitAnimation> HIT_RIGHT;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> SHAKE_HAND_TRY;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> SHAKE_HAND;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> FIST_TRY;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> FISTING;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> GIANT_WHIRLWIND;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD_DANCING_EDGE;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> SPEAR_THRUST;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> DUAL_TACHI_GUARD;
/*      */   public static AnimationManager.AnimationAccessor<GuardAnimation> DUAL_TACHI_GUARD_HIT;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> WHIRLWIND_KICK_LEFT;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> SUPER_PUNCH;
/*      */   public static AnimationManager.AnimationAccessor<KnockdownAnimation> GUARD_BREAK_ATTACK;
/*      */   public static AnimationManager.AnimationAccessor<DashAttackAnimation> SWORD_DASH;
/*      */   public static AnimationManager.AnimationAccessor<DashAttackAnimation> TACHI_DASH;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_SWORD_SKILL;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> DUAL_END;
/*      */   public static AnimationManager.AnimationAccessor<KnockdownAnimation> TRIED;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> GREATSWORD_SKILL;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> LEGENDARY_SWORD_WAKE_UP_ATTACK;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> DUAL_E_END;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AXE_FUN_SKILL;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> LEGENDARY_SWORD_AUTO_4;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> OBSIDIAN_FIST_DASH;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> TRIDENT_THROW_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> TRIDENT_THROW_LEGENDARY;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> ADVANCED_LANCER_AUTO1;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> ADVANCED_LANCER_AUTO3;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> ADVANCED_DUELIST_WHIRLEDGE;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> ADVANCED_DUELIST_SHOOTING_STAR;
/*      */   public static AnimationManager.AnimationAccessor<BasicAttackAnimation> TRIDENT_THROW_1;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> TRIDENT_THROW_5;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> TRIDENT_THROW_3;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> CUT_DP_AIR_ATTACK;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> CUT_HOOK_SPIN_SLASH_AIR;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> DP_THROW_BLADE_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> DP_THROW_BLADE_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> THROW_HOOK_SLASH_AIR;
/*      */   public static AnimationManager.AnimationAccessor<LongHitAnimation> ZAP;
/*      */   public static AnimationManager.AnimationAccessor<LongHitAnimation> ZAP_LONG;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> PLAYER_HEROBRINE_POSSESSION;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> LEGENDARY_SWORD_IDLE;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> HEROBRINE_SACRIFICING;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> HEROBRINE_ASSISTANCE;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> HEROBRINE_STAGE_CHANGE;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> PORTAL_SUMMON;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> TRIDENT_ATTACK;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> KNOCKED_ELITE;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> EATING_ELITE_1;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> EATING_ELITE_2;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> EATING_ELITE_3;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> EATING_ELITE_4;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> HEROBRINE_ANIMATE;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> HEROBRINE_HEALING;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> LOW_CLONE_ESCAPE;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> SNAKE_BLADE;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> SNAKE_BLADE_GUARD;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE_BREAK;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> PLACE_BLOCK;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> CUT_ANTITHEUS_ASCENSION;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> TORMENT_BERSERK_WALK;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> TRIDENT_GUARD_HIT_1;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> TRIDENT_GUARD_HIT_2;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> ELECTRIC_FIELD;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> GLOWING_AGONY_GUARD;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_AEGIS_BULL_CHARGE;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_AEGIS_MOONLESS_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_AEGIS_MOONLESS_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> YELLOW_SOLAR_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> YELLOW_NAPOLEON_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<SpecialAttackAnimation> YELLOW_NAPOLEON_AUSTERLITZ_SHOOT;
/*      */   public static AnimationManager.AnimationAccessor<SpecialAttackAnimation> ENDER_AEGIS_NAPOLEON_RELOAD_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_GLAIVE_NAPOLEON_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_GLAIVE_NAPOLEON_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_GLAIVE_NAPOLEON_AUTO_4;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_GLAIVE_NAPOLEON_AUSTERLITZ;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> DEMONIAC_RUINE_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> DEMONIAC_RUINE_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> DEMONIAC_RUINE_AUTO_4;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> DEMONIAC_TORMENT_CHARGED_ATTACK_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> DEMONIAC_RUINE_COMET;
/*      */   public static AnimationManager.AnimationAccessor<ActionAnimation> AGONY_GUARD_HIT_1;
/*      */   public static AnimationManager.AnimationAccessor<SpecialAttackAnimation> ENDER_GLAIVE_NAPOLEON_SHOOT_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_GLAIVE_AGONY_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_AUTO_4;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_AGRESSION;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_GUILLOTINE;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> CLONE_ANTITHEUS_ASCENSION;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> CLONE_ANTITHEUS_LAPSE;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_ASCENDED_DEATHFALL;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_ASCENDED_BLINK;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ANTITHEUS_ASCENDED_BLACKHOLE;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_GLAIVE_NAPOLEON_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> ENDER_GLAIVE_NAPOLEON_WATERLOW;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> YELLOW_TORMENT_CHARGED_ATTACK_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> CLONE_ENDERBLASTER_ONEHAND_DASH;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SLEDGEHAMMER_SOLAR_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<AntitheusShootAttackAnimation> CLONE_ANTITHEUS_SHOOT;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> CLONE_ANTITHEUS_ASCENDED_IDLE;
/*      */   public static AnimationManager.AnimationAccessor<AttackAnimation> NULL_SKELETON_ANTITHEUS_ASCENSION;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> NULL_ANTITHEUS_ASCENDED_AUTO_1;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> NULL_ANTITHEUS_ASCENDED_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> NULL_ANTITHEUS_ASCENDED_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<DodgeAnimation> HEROBRINE_MOB_ENDERSTEP_OBSCURIS;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> OLD_MOONLESS_RUN;
/*      */   public static AnimationManager.AnimationAccessor<MovementAnimation> TRIDENT_TWO_HAND_RUN;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> OBSIDIAN_STRONG_PUNCH;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3;
/*      */   public static AnimationManager.AnimationAccessor<BasicMultipleAttackAnimation> SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2;
/*      */   public static AnimationManager.AnimationAccessor<SpecialAttackAnimation> CLONE_NAPOLEON_WATERLOW_SHOOT;
/*      */   public static AnimationManager.AnimationAccessor<StaticAnimation> CUT_ENDERBLASTER_TWOHAND_RELOAD;
/*      */   
/*      */   @SubscribeEvent
/*      */   public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
/*  454 */     event.newBuilder("annoyingvillagers", AVAnimations::build);
/*      */   }
/*      */   
/*      */   private static void build(AnimationManager.AnimationBuilder builder) {
/*  458 */     Armatures.ArmatureAccessor<HumanoidArmature> humanoidArmature = Armatures.BIPED;
/*      */     
/*  460 */     EAT_OFFHAND = builder.nextAccessor("biped/epicfight_clone/eat_offhand", accessor -> new StaticAnimation(0.35F, true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  462 */     DRINK_OFFHAND = builder.nextAccessor("biped/epicfight_clone/drink_offhand", accessor -> new StaticAnimation(0.35F, true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  464 */     SHIELD_MAINHAND = builder.nextAccessor("biped/epicfight_clone/shield_mainhand", accessor -> new StaticAnimation(0.35F, true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  466 */     AEGIS_SHIELD_SHOOT = builder.nextAccessor("biped/epicfight_clone/aegis_shield_shoot", accessor -> (ActionAnimation)(new ActionAnimation(0.35F, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  477 */     SHIELD_OFFHAND = builder.nextAccessor("biped/epicfight_clone/shield_offhand", accessor -> new StaticAnimation(0.35F, true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  479 */     OBSIDIAN_FIST_AUTO1 = builder.nextAccessor("biped/epicfight_clone/obsidian_fist_auto1", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.08F, 0.05F, 0.15F, 0.15F, InteractionHand.OFF_HAND, null, ((HumanoidArmature)Armatures.BIPED.get()).toolL, accessor, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(3.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.SUMMON_2_OBSIDIAN_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  486 */     OBSIDIAN_FIST_AUTO2 = builder.nextAccessor("biped/epicfight_clone/obsidian_fist_auto2", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.08F, 0.05F, 0.15F, 0.15F, null, ((HumanoidArmature)Armatures.BIPED.get()).toolR, accessor, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(3.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.SUMMON_2_OBSIDIAN_HAND_RIGHT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  493 */     OBSIDIAN_FIST_AUTO3 = builder.nextAccessor("biped/epicfight_clone/obsidian_fist_auto3", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.08F, 0.05F, 0.15F, 0.5F, InteractionHand.OFF_HAND, null, ((HumanoidArmature)Armatures.BIPED.get()).toolL, accessor, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(3.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.SUMMON_3_OBSIDIAN_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  500 */     SHADOW_OBSIDIAN_FIST_AUTO1 = builder.nextAccessor("biped/epicfight_clone/shadow_obsidian_fist_auto1", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.08F, 0.05F, 0.15F, 0.15F, InteractionHand.OFF_HAND, null, ((HumanoidArmature)Armatures.BIPED.get()).toolL, accessor, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.SUMMON_2_OBSIDIAN_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  507 */     SHADOW_OBSIDIAN_FIST_AUTO3 = builder.nextAccessor("biped/epicfight_clone/shadow_obsidian_fist_auto3", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.08F, 0.05F, 0.15F, 0.5F, InteractionHand.OFF_HAND, null, ((HumanoidArmature)Armatures.BIPED.get()).toolL, accessor, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.SUMMON_3_OBSIDIAN_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  514 */     OBSIDIAN_FIST_AIR_SLASH = builder.nextAccessor("biped/epicfight_clone/obsidian_fist_airslash", accessor -> (AirSlashAnimation)(new AirSlashAnimation(0.1F, 0.15F, 0.26F, 0.4F, null, ((HumanoidArmature)Armatures.BIPED.get()).toolR, accessor, (AssetAccessor)Armatures.BIPED)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(4.0F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.SUMMON_6_OBSIDIAN_HAND_RIGHT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  520 */     SHADOW_OBSIDIAN_FIST_AIR_SLASH = builder.nextAccessor("biped/epicfight_clone/shadow_obsidian_fist_airslash", accessor -> (AirSlashAnimation)(new AirSlashAnimation(0.1F, 0.15F, 0.26F, 0.4F, AVCollider.SHADOW_OBSIDIAN_PILLAR, ((HumanoidArmature)Armatures.BIPED.get()).toolR, accessor, (AssetAccessor)Armatures.BIPED)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(4.0F)));
/*      */ 
/*      */     
/*  523 */     OBSIDIAN_BIPED_LANDING = builder.nextAccessor("biped/epicfight_clone/obsidian_landing", accessor -> (AttackAnimation)(new AttackAnimation(0.0F, 0.0F, 0.0F, 0.0F, Float.MAX_VALUE, null, ((HumanoidArmature)Armatures.BIPED.get()).head, accessor, (AssetAccessor)Armatures.BIPED)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(2.0F)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_PILLAR, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  531 */     OBSIDIAN_ZOMBIE_ATTACK3 = builder.nextAccessor("biped/epicfight_clone/obsidian_zombie_attack3", accessor -> (AttackAnimation)(new AttackAnimation(0.1F, 0.5F, 0.5F, 0.6F, 1.15F, ColliderPreset.HEAD, ((HumanoidArmature)Armatures.BIPED.get()).head, accessor, (AssetAccessor)Armatures.BIPED)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.5F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.65F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_WALL, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  537 */     SHADOW_HEROBRINE_BIPED_LANDING = builder.nextAccessor("biped/epicfight_clone/shadow_herobrine_landing", accessor -> (AttackAnimation)(new AttackAnimation(0.0F, 0.0F, 0.0F, 0.0F, Float.MAX_VALUE, null, ((HumanoidArmature)Armatures.BIPED.get()).head, accessor, (AssetAccessor)Armatures.BIPED)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  551 */     NERF_TSUNAMI_REINFORCED = builder.nextAccessor("biped/epicfight_clone/tsunami_reinforced", accessor -> (AttackAnimation)(new AttackAnimation(0.1F, 0.2F, 0.35F, 0.45F, 0.7F, ColliderPreset.BIPED_BODY_COLLIDER, ((HumanoidArmature)Armatures.BIPED.get()).rootJoint, accessor, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(2.0F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.RAW_COORD_WITH_X_ROT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.15F, 0.85F })).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.ROOT_X_MODIFIER).addEvents(AnimationProperty.StaticAnimationProperty.ON_END_EVENTS, new AnimationEvent[] { (AnimationEvent)AnimationEvent.SimpleEvent.create((AnimationEvent.Event)Animations.ReusableSources.RESTORE_BOUNDING_BOX, AnimationEvent.Side.BOTH) }).addEvents(AnimationProperty.StaticAnimationProperty.TICK_EVENTS, new AnimationEvent[] { AnimationEvent.SimpleEvent.create((AnimationEvent.Event)Animations.ReusableSources.RESIZE_BOUNDING_BOX, AnimationEvent.Side.BOTH).params(EntityDimensions.m_20395_(0.6F, 1.0F)) }).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InPeriodEvent.create(0.35F, 1.0F, (), AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  572 */     BLUE_DEMON_DIE_LEGENDARY_SWORD_START = builder.nextAccessor("biped/epicfight_clone/blue_demon_die_legendary_sword_start", accessor -> new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  574 */     BLUE_DEMON_DIE_LEGENDARY_SWORD_TICK = builder.nextAccessor("biped/epicfight_clone/blue_demon_die_legendary_sword_tick", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */ 
/*      */ 
/*      */     
/*  578 */     INFERNAL_AUTO_1 = builder.nextAccessor("biped/epicfight_infernal_gainer/infernal_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.3F, 0.4F, 0.5F, ColliderPreset.FIST, ((HumanoidArmature)humanoidArmature.get()).toolL, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.4F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  584 */     INFERNAL_AUTO_2 = builder.nextAccessor("biped/epicfight_infernal_gainer/infernal_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.2F, 0.1F, 0.2F, 0.25F, ColliderPreset.FIST, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.4F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  591 */     INFERNAL_AUTO_3 = builder.nextAccessor("biped/epicfight_infernal_gainer/infernal_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.35F, 0.45F, 0.5F, ColliderPreset.FIST, ((HumanoidArmature)humanoidArmature.get()).legL, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.4F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  597 */     OBSIDIAN_INFERNAL_AUTO_1 = builder.nextAccessor("biped/epicfight_infernal_gainer/obsidian_infernal_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.3F, 0.4F, 0.5F, AVCollider.SHADOW_OBSIDIAN_PILLAR, ((HumanoidArmature)humanoidArmature.get()).toolL, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(5.4F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.SUMMON_6_OBSIDIAN_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  606 */     OBSIDIAN_INFERNAL_AUTO_2 = builder.nextAccessor("biped/epicfight_infernal_gainer/obsidian_infernal_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.2F, 0.1F, 0.2F, 0.25F, ColliderPreset.FIST, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(5.4F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_WALL, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  618 */     BOW_AUTO_1 = builder.nextAccessor("biped/epic_agc/bow_auto1", accessor -> (BowAttackAnimation)(new BowAttackAnimation(0.1F, 0.0F, 0.62F, 0.8333F, 1.2F, InteractionHand.MAIN_HAND, null, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (), AnimationEvent.Side.BOTH) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  625 */     BOW_AUTO_2 = builder.nextAccessor("biped/epic_agc/bow_auto2", accessor -> (BowAttackAnimation)(new BowAttackAnimation(0.1F, 0.0F, 0.7F, 0.98F, 1.2F, InteractionHand.MAIN_HAND, null, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.6F, (), AnimationEvent.Side.BOTH) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  632 */     BOW_AUTO_3 = builder.nextAccessor("biped/epic_agc/bow_auto3", accessor -> (BowAttackAnimation)(new BowAttackAnimation(0.1F, 0.0F, 0.88F, 1.03F, 1.3F, InteractionHand.MAIN_HAND, null, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.84F, (), AnimationEvent.Side.BOTH) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  639 */     BOW_AUTO_4 = builder.nextAccessor("biped/epic_agc/bow_auto4", accessor -> (BowAttackAnimation)(new BowAttackAnimation(0.05F, 0.0F, 2.12F, 2.733F, 1.2F, InteractionHand.MAIN_HAND, null, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2083F, (), AnimationEvent.Side.BOTH), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.7916F, (), AnimationEvent.Side.BOTH), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.0416F, (), AnimationEvent.Side.BOTH) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  647 */     BOW_AUTO_5 = builder.nextAccessor("biped/epic_agc/bow_auto5", accessor -> (BowAttackAnimation)(new BowAttackAnimation(0.02F, 0.0F, 0.2F, 1.51F, 1.2F, InteractionHand.MAIN_HAND, null, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.7083F, (), AnimationEvent.Side.BOTH) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  654 */     VALOUR_HOLD_GREATSWORD = builder.nextAccessor("biped/epicfight_valour_guard/valour_hold_greatsword", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)Armatures.BIPED));
/*      */     
/*  656 */     VALOUR_RUN_GREATSWORD = builder.nextAccessor("biped/epicfight_valour_guard/valour_run_greatsword", accessor -> new MovementAnimation(true, accessor, (AssetAccessor)Armatures.BIPED));
/*      */     
/*  658 */     VALOUR_WALK_GREATSWORD = builder.nextAccessor("biped/epicfight_valour_guard/valour_walk_greatsword", accessor -> new MovementAnimation(true, accessor, (AssetAccessor)Armatures.BIPED));
/*      */     
/*  660 */     VALOUR_FIST_GUARD = builder.nextAccessor("biped/epicfight_valour_guard/valour_fist_guard", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  662 */     VALOUR_FIST_GUARD_HIT = builder.nextAccessor("biped/epicfight_valour_guard/valour_fist_guard_hit", accessor -> new GuardAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature));
/*      */ 
/*      */ 
/*      */     
/*  666 */     CASTING_ONE_HAND_TOP = builder.nextAccessor("biped/epicfight_ironspell/casting_one_hand_top", accessor -> (new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)));
/*      */ 
/*      */     
/*  669 */     CASTING_ONE_HAND_INWARD = builder.nextAccessor("biped/epicfight_ironspell/casting_one_hand_inward", accessor -> (new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)));
/*      */ 
/*      */     
/*  672 */     CASTING_ONE_HAND_BUFF = builder.nextAccessor("biped/epicfight_ironspell/casting_one_hand_buff", accessor -> (new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  677 */     GREATSWORD_TWOHAND_AUTO_1 = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_twohand_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.25F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.4F, 0.45F, 0.45F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null), new AttackAnimation.Phase(0.45F, 0.5F, 0.7F, 0.8F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.55F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  684 */     GREATSWORD_TWOHAND_AUTO_2 = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_twohand_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.35F, 0.85F, 0.85F, ColliderPreset.DUAL_SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  690 */     GREATSWORD_DUAL_AUTO_1 = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_dual_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.25F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.4F, 0.45F, 0.45F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null), new AttackAnimation.Phase(0.45F, 0.5F, 0.7F, 0.8F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  697 */     GREATSWORD_DUAL_AUTO_2 = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_dual_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.35F, 0.85F, 0.85F, ColliderPreset.DUAL_SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.8F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.85F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  706 */     GREATSWORD_DUAL_AUTO_3 = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_dual_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.4F, 0.45F, 0.45F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.45F, 0.55F, 0.7F, 0.7F, Float.MAX_VALUE, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.45F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  717 */     GREATSWORD_DUAL_AUTO_4 = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_dual_auto_4", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.8F, 1.0F, 1.25F, InteractionHand.OFF_HAND, ColliderPreset.DUAL_SWORD, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.8F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(0.75F)));
/*      */ 
/*      */ 
/*      */     
/*  721 */     GREATSWORD_DUAL_DASH = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_dual_dash", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.1F, 0.4F, 0.4F, ColliderPreset.DUAL_SWORD, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  730 */     GREATSWORD_DUAL_AIRSLASH = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_dual_airslash", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.25F, 0.4F, 0.45F, InteractionHand.OFF_HAND, WOMWeaponColliders.TORMENT_AIRSLAM, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.8F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.2F })).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  739 */     GREATSWORD_DUAL_EARTHQUAKE = builder.nextAccessor("biped/epicfight_dual_greatsword/greatsword_dual_earthquake", accessor -> (SpecialAttackAnimation)(new SpecialAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 1.1F, 1.1F, 1.25F, 1.25F, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.DUAL_SWORD), new AttackAnimation.Phase(1.25F, 1.3F, 1.4F, 1.5F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, ColliderPreset.DUAL_SWORD) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.4F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.25F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  751 */     SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_1 = builder.nextAccessor("biped/epicfight_dual_greatsword/shadow_obsidian_sword_greatsword_twohand_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.25F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.4F, 0.45F, 0.45F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null), new AttackAnimation.Phase(0.45F, 0.5F, 0.7F, 0.8F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.55F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  758 */     SHADOW_OBSIDIAN_SWORD_GREATSWORD_TWOHAND_AUTO_2 = builder.nextAccessor("biped/epicfight_dual_greatsword/shadow_obsidian_sword_greatsword_twohand_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.35F, 0.85F, 0.85F, ColliderPreset.DUAL_SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  764 */     SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AUTO_3 = builder.nextAccessor("biped/epicfight_dual_greatsword/shadow_obsidian_sword_greatsword_dual_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.4F, 0.45F, 0.45F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.45F, 0.55F, 0.7F, 0.7F, Float.MAX_VALUE, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, AVCollider.SHADOW_OBSIDIAN_PILLAR) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.45F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  775 */     SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_AIRSLASH = builder.nextAccessor("biped/epicfight_dual_greatsword/shadow_obsidian_sword_greatsword_dual_airslash", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.25F, 0.4F, 0.45F, InteractionHand.OFF_HAND, AVCollider.SHADOW_OBSIDIAN_PILLAR, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.8F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.2F })).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  784 */     SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE = builder.nextAccessor("biped/epicfight_dual_greatsword/shadow_obsidian_sword_greatsword_dual_earthquake", accessor -> (SpecialAttackAnimation)(new SpecialAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 1.1F, 1.1F, 1.25F, 1.25F, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR), new AttackAnimation.Phase(1.25F, 1.3F, 1.4F, 1.5F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolL, AVCollider.SHADOW_OBSIDIAN_PILLAR) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.4F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.25F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.25F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_CIRCLE, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  798 */     SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE_PILLAR = builder.nextAccessor("biped/epicfight_dual_greatsword/shadow_obsidian_sword_greatsword_dual_earthquake_pillar", accessor -> (SpecialAttackAnimation)(new SpecialAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 1.1F, 1.1F, 1.25F, 1.25F, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR), new AttackAnimation.Phase(1.25F, 1.3F, 1.4F, 1.5F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolL, AVCollider.SHADOW_OBSIDIAN_PILLAR) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.4F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.SHORT, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(2.05F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.25F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.25F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_CIRCLE, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  813 */     BLUE_DEMON_STATE_TRANSFORM = builder.nextAccessor("biped/pugilist_steve/blue_demon_state_transform", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  815 */     BLUE_DEMON_STATE_TRANSFORM_END = builder.nextAccessor("biped/pugilist_steve/blue_demon_state_transform_end", accessor -> new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  817 */     BLUE_DEMON_DIE = builder.nextAccessor("biped/pugilist_steve/blue_demon_die", accessor -> new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  819 */     TRIDENT_FESTIVAL = builder.nextAccessor("biped/pugilist_steve/trident_festival", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { 
/*      */             (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), 
/*      */             (AnimationEvent)AnimationEvent.InTimeEvent.create(1.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.5F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), 
/*      */             (AnimationEvent)AnimationEvent.InTimeEvent.create(3.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  880 */     COUNTER = builder.nextAccessor("biped/pugilist_steve/counter", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.3F, 0.08F, 0.1F, 0.15F, 0.525F, ColliderPreset.FIST, ((HumanoidArmature)humanoidArmature.get()).legR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.COUNTER)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.5F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  891 */     FIST_GUARD = builder.nextAccessor("biped/pugilist_steve/fist_guard", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/*  893 */     FIST_DASH = builder.nextAccessor("biped/pugilist_steve/fist_dash", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.25F, 0.45F, 0.7F, 0.95F, ColliderPreset.BIPED_BODY_COLLIDER, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  901 */     WHIRLWIND_KICK = builder.nextAccessor("biped/pugilist_steve/whirlwind_kick", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.2F, 0.29F, 0.45F, 0.85F, 1.8F, ColliderPreset.BIPED_BODY_COLLIDER, ((HumanoidArmature)humanoidArmature.get()).legR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addEvents((AnimationEvent[])new AnimationEvent.InTimeEvent[] { (AnimationEvent.InTimeEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.SERVER).params(EpicFightSounds.WHOOSH.get()) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  911 */     LEGENDARY_SWORD_HEAVY_ATTACK = builder.nextAccessor("biped/pugilist_steve/legendary_sword_heavy_attack", accessor -> (HeavyAttackAnimation)(new HeavyAttackAnimation(0.05F, 0.05F, 0.5F, 0.7F, 1.2F, WOMWeaponColliders.TORMENT_BERSERK_AIRSLAM, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(1.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.3F })).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents((AnimationEvent[])new AnimationEvent.InTimeEvent[] { AnimationEvent.InTimeEvent.create(0.6F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.TORMENT_GROUNDSLAM, AnimationEvent.Side.CLIENT), AnimationEvent.InTimeEvent.create(0.6F, (AnimationEvent.Event)ReuseableEvents.SHOCK_WAVE, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  945 */     HACKER_SWORD_SKILL = builder.nextAccessor("biped/pugilist_steve/hacker_sword_skill", accessor -> (AttackAnimation)(new AttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.016F, 0.066F, 0.133F, 0.133F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, ColliderPreset.SWORD), new AttackAnimation.Phase(0.133F, 0.133F, 0.183F, 0.25F, 0.25F, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.SWORD), new AttackAnimation.Phase(0.25F, 0.25F, 0.3F, 0.366F, 0.366F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, ColliderPreset.SWORD), new AttackAnimation.Phase(0.366F, 0.366F, 0.416F, 0.483F, 0.483F, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.SWORD), new AttackAnimation.Phase(0.483F, 0.483F, 0.533F, 0.6F, 0.6F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, ColliderPreset.SWORD), new AttackAnimation.Phase(0.6F, 0.6F, 0.65F, 0.716F, 0.716F, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.SWORD), new AttackAnimation.Phase(0.716F, 0.716F, 0.766F, 0.833F, 0.833F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, ColliderPreset.SWORD), new AttackAnimation.Phase(0.833F, 0.833F, 0.883F, 1.1F, 1.1F, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.SWORD), new AttackAnimation.Phase(0.933F, 1.133F, 1.183F, 1.6F, 1.6F, ((HumanoidArmature)humanoidArmature.get()).toolL, ColliderPreset.SWORD) })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(4.0F)));
/*      */     
/*  947 */     DUAL_SWORD_AUTO1 = builder.nextAccessor("biped/pugilist_steve/dual_sword_auto1", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.63F, 0.667F, 0.667F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(2.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  952 */     DUAL_SWORD_AUTO2 = builder.nextAccessor("biped/pugilist_steve/dual_sword_auto2", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.63F, 0.667F, 0.667F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(2.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  957 */     TRIDENT_DUAL_AUTO2 = builder.nextAccessor("biped/pugilist_steve/trident_dual_auto2", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.63F, 0.667F, 0.667F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(2.5F)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  962 */     DUAL_SWORD_AUTO3 = builder.nextAccessor("biped/pugilist_steve/dual_sword_auto3", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.16F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.66F, 0.69F, 0.733F, 1.0F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(2.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  967 */     DUAL_SWORD_AUTO4 = builder.nextAccessor("biped/pugilist_steve/dual_sword_auto4", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.633F, 0.69F, 0.8F, 1.167F, 1.65F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  972 */     DUAL_SWORD_AUTO5 = builder.nextAccessor("biped/pugilist_steve/dual_sword_auto5", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.633F, 0.69F, 0.8F, 1.167F, 1.65F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)));
/*      */ 
/*      */ 
/*      */     
/*  976 */     DUAL_SWORD1 = builder.nextAccessor("biped/pugilist_steve/dual_auto1", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.05F, 0.3F, 0.4F, 1.167F, 1.65F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null), new AttackAnimation.Phase(0.1F, 0.1F, 0.4F, 0.6F, 0.6F, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(0.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  981 */     DUAL_SWORD2 = builder.nextAccessor("biped/pugilist_steve/dual_auto2", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.05F, 0.4F, 0.8F, 1.167F, 2.5F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.1F, 1.2F, 1.3F, 1.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.1F, 1.4F, 1.5F, 2.1F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(0.5F)));
/*      */ 
/*      */ 
/*      */     
/*  985 */     DUAL_SWORD3 = builder.nextAccessor("biped/pugilist_steve/dual_auto3", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.1F, 0.0F, 0.0F, 0.06F, 0.3F, ColliderPreset.SWORD, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  990 */     FIST_UP = builder.nextAccessor("biped/pugilist_steve/fist_up", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.25F, 0.45F, 0.85F, 0.95F, WOMWeaponColliders.KICK, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, AVSounds.KICK.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.5F)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1000 */     RUSH_SWORD = builder.nextAccessor("biped/pugilist_steve/rush_sword", accessor -> (RushSwordAnimation)(new RushSwordAnimation(0.15F, 0.0F, 0.1F, 0.26F, 0.75F, ColliderPreset.SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1008 */     DUAL_DANCING_EDGE = builder.nextAccessor("biped/pugilist_steve/dancing_edge", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.25F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.31F, 0.4F, 0.4F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.4F, 0.5F, 0.61F, 0.65F, 0.65F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null), new AttackAnimation.Phase(0.65F, 0.76F, 0.85F, 1.15F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.DUAL_SWORD) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 2).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.6F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1015 */     SWEEPING_EDGE = builder.nextAccessor("biped/pugilist_steve/sweeping_edge", accessor -> (AttackAnimation)(new AttackAnimation(0.2F, 0.1F, 0.35F, 0.46F, 0.79F, ColliderPreset.BIPED_BODY_COLLIDER, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.9F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLADE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.45F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1023 */     HIT_BACKWARD = builder.nextAccessor("biped/pugilist_steve/hit_backward", accessor -> new LongHitAnimation(0.08F, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1025 */     SPEAR_GUARD_HIT = builder.nextAccessor("biped/pugilist_steve/spear_guard_hit", accessor -> (GuardAnimation)(new GuardAnimation(0.05F, 0.2F, accessor, (AssetAccessor)humanoidArmature)).addEvents((AnimationEvent[])new AnimationEvent.InTimeEvent[] { AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.FAST_SPINNING, AnimationEvent.Side.CLIENT), AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.FAST_SPINNING, AnimationEvent.Side.CLIENT), AnimationEvent.InTimeEvent.create(0.3F, (AnimationEvent.Event)ReuseableEvents.FAST_SPINNING, AnimationEvent.Side.CLIENT), AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)ReuseableEvents.FAST_SPINNING, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1032 */     LEGENDARY_SWORD_GUARD = builder.nextAccessor("biped/pugilist_steve/legendary_sword_guard", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1034 */     LEGENDARY_SWORD_GUARD_HIT = builder.nextAccessor("biped/pugilist_steve/legendary_sword_guard_hit", accessor -> new GuardAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1036 */     LEGENDARY_SWORD_GUARD_PARRY = builder.nextAccessor("biped/pugilist_steve/legendary_sword_guard_parry", accessor -> new GuardAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1038 */     POSE_UP = builder.nextAccessor("biped/pugilist_steve/pose_up", accessor -> (ActionAnimation)(new ActionAnimation(0.0F, 1.85F, accessor, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)));
/*      */ 
/*      */     
/* 1041 */     DAGGER_AUTO1 = builder.nextAccessor("biped/pugilist_steve/dagger_auto1", accessor -> new BasicAttackAnimation(0.08F, 0.05F, 0.15F, 0.2F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1043 */     DAGGER_AUTO2 = builder.nextAccessor("biped/pugilist_steve/dagger_auto2", accessor -> new BasicAttackAnimation(0.08F, 0.0F, 0.1F, 0.2F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1045 */     DAGGER_AUTO3 = builder.nextAccessor("biped/pugilist_steve/dagger_auto3", accessor -> new BasicAttackAnimation(0.08F, 0.15F, 0.26F, 0.5F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1047 */     DAGGER_DUAL_AUTO1 = builder.nextAccessor("biped/pugilist_steve/dagger_dual_auto1", accessor -> new BasicAttackAnimation(0.08F, 0.05F, 0.16F, 0.25F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1049 */     DAGGER_DUAL_AUTO2 = builder.nextAccessor("biped/pugilist_steve/dagger_dual_auto2", accessor -> new BasicAttackAnimation(0.08F, 0.0F, 0.11F, 0.16F, InteractionHand.OFF_HAND, null, ((HumanoidArmature)humanoidArmature.get()).toolL, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1051 */     DAGGER_DUAL_AUTO3 = builder.nextAccessor("biped/pugilist_steve/dagger_dual_auto3", accessor -> new BasicAttackAnimation(0.08F, 0.0F, 0.11F, 0.2F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1053 */     DAGGER_DUAL_AUTO4 = builder.nextAccessor("biped/pugilist_steve/dagger_dual_auto4", accessor -> new BasicAttackAnimation(0.13F, 0.1F, 0.21F, 0.4F, ColliderPreset.DUAL_DAGGER_DASH, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1055 */     CHECK = builder.nextAccessor("biped/pugilist_steve/check", accessor -> new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1057 */     BIPED_RUN_ESWORD = builder.nextAccessor("biped/pugilist_steve/run_esword", accessor -> new MovementAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1059 */     KNIFE_IDLE = builder.nextAccessor("biped/pugilist_steve/knife_idle", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1061 */     KNIFE_RUN = builder.nextAccessor("biped/pugilist_steve/knife_run", accessor -> new MovementAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1063 */     KNIFE_ATTACK = builder.nextAccessor("biped/pugilist_steve/knife_attack", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.15F, 0.01F, 0.2F, 0.5F, 0.6F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.EVISCERATE.get()).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(false)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(false)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1072 */     KNIFE_CHECK = builder.nextAccessor("biped/pugilist_steve/knife_check", accessor -> (new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)));
/*      */ 
/*      */     
/* 1075 */     CARRY = builder.nextAccessor("biped/pugilist_steve/carry", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1077 */     FIST_LEFT = builder.nextAccessor("biped/pugilist_steve/fist_left", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.25F, 0.45F, 0.85F, 1.1F, ColliderPreset.FIST, ((HumanoidArmature)humanoidArmature.get()).toolL, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1085 */     KNOCKDOWN_FORWARD = builder.nextAccessor("biped/pugilist_steve/knockdown_forward", accessor -> (KnockdownAnimation)(new KnockdownAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false)).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1096 */     KNOCKDOWN_RIGHT = builder.nextAccessor("biped/pugilist_steve/knockdown_right", accessor -> (KnockdownAnimation)(new KnockdownAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false)).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1107 */     KNOCKDOWN_LEFT = builder.nextAccessor("biped/pugilist_steve/knockdown_left", accessor -> (KnockdownAnimation)(new KnockdownAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false)).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1118 */     AXE_HEAVY_AUTO_1 = builder.nextAccessor("biped/pugilist_steve/axe_heavy_auto1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.15F, 0.3F, 0.6F, 0.95F, ColliderPreset.SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(0.5F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1124 */     AXE_HEAVY_AUTO_2 = builder.nextAccessor("biped/pugilist_steve/axe_heavy_auto2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.15F, 0.8F, 1.2F, 1.95F, ColliderPreset.SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.4F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(0.8F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1130 */     SWORD_HEAVY_AUTO_1 = builder.nextAccessor("biped/pugilist_steve/sword_heavy_auto1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.11F, 0.27F, 0.5F, 0.95F, ColliderPreset.SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.4F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.5F)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1136 */     SWORD_HEAVY_AUTO_2 = builder.nextAccessor("biped/pugilist_steve/sword_heavy_auto2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.01F, 0.1F, 0.12F, 0.22F, 0.95F, ColliderPreset.SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.4F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.5F)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1142 */     SWORD_HEAVY_AUTO_3 = builder.nextAccessor("biped/pugilist_steve/sword_heavy_auto3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.01F, 0.1F, 0.21F, 0.32F, 1.2F, ColliderPreset.SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.5F)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1148 */     HARD_KICK = builder.nextAccessor("biped/pugilist_steve/hard_kick", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.29F, 1.1F, 1.2F, 3.1F, WOMWeaponColliders.TORMENT_BERSERK_AIRSLAM, ((HumanoidArmature)humanoidArmature.get()).legR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1159 */     HARD_KICK_HIT = builder.nextAccessor("biped/pugilist_steve/hard_kick_hit", accessor -> (LongHitAnimation)(new LongHitAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false)).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1169 */     RUN_START = builder.nextAccessor("biped/pugilist_steve/run_start", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */     
/* 1171 */     LONGSWORD_AUTO1 = builder.nextAccessor("biped/pugilist_steve/tachi_auto1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.15F, 0.2F, 0.3F, 0.75F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1176 */     RUN_HOLD = builder.nextAccessor("biped/pugilist_steve/run_hold", accessor -> new MovementAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1178 */     RUN_DUAL_BIG = builder.nextAccessor("biped/pugilist_steve/run_dual_big", accessor -> new MovementAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1180 */     LONGEST_HIT = builder.nextAccessor("biped/pugilist_steve/longest_hit", accessor -> (KnockdownAnimation)(new KnockdownAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false)).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1191 */     HARD_GREATSWORD_GUARD = builder.nextAccessor("biped/pugilist_steve/hard_greatsword", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1193 */     HARD_GREATSWORD_GUARD_HIT = builder.nextAccessor("biped/pugilist_steve/hard_greatsword_hit", accessor -> new GuardAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1195 */     HARD_GREATSWORD_GUARD_SKILL = builder.nextAccessor("biped/pugilist_steve/hard_greatsword_skill", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */     
/* 1198 */     HIT_LEFT = builder.nextAccessor("biped/pugilist_steve/hit_left", accessor -> new LongHitAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1200 */     HIT_RIGHT = builder.nextAccessor("biped/pugilist_steve/hit_right", accessor -> new LongHitAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1202 */     SHAKE_HAND_TRY = builder.nextAccessor("biped/pugilist_steve/shake_hand_try", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1209 */     SHAKE_HAND = builder.nextAccessor("biped/pugilist_steve/shake_hand", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1216 */     FIST_TRY = builder.nextAccessor("biped/pugilist_steve/fist_try", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1223 */     FISTING = builder.nextAccessor("biped/pugilist_steve/fisting", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addEvents((AnimationEvent[])new AnimationEvent.InTimeEvent[] { (AnimationEvent.InTimeEvent)AnimationEvent.InTimeEvent.create(0.15F, (AnimationEvent.Event)Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.SERVER).params(EpicFightSounds.WHOOSH.get()) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1233 */     GIANT_WHIRLWIND = builder.nextAccessor("biped/pugilist_steve/giant_whirlwind", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.41F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.3F, 0.35F, 0.55F, 0.9F, 0.9F, ((HumanoidArmature)humanoidArmature.get()).toolL, null), new AttackAnimation.Phase(0.9F, 0.95F, 1.05F, 1.2F, 1.5F, 1.5F, ((HumanoidArmature)humanoidArmature.get()).toolL, null), (new AttackAnimation.Phase(1.5F, 1.65F, 1.75F, 1.95F, 2.5F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolL, ColliderPreset.GREATSWORD)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE) })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1239 */     DUAL_SWORD_DANCING_EDGE = builder.nextAccessor("biped/pugilist_steve/dual_sword_dancing_edge", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.25F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.31F, 0.4F, 0.4F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.4F, 0.5F, 0.61F, 0.65F, 0.65F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null), new AttackAnimation.Phase(0.65F, 0.76F, 0.85F, 1.15F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.DUAL_SWORD) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG, 2).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.6F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1246 */     SPEAR_THRUST = builder.nextAccessor("biped/pugilist_steve/spear_thrust", accessor -> (AttackAnimation)(new AttackAnimation(0.11F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.3F, 0.36F, 0.5F, 0.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.SPEAR), new AttackAnimation.Phase(0.5F, 0.5F, 0.56F, 0.75F, 0.75F, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.SPEAR), new AttackAnimation.Phase(0.75F, 0.75F, 0.81F, 1.05F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.SPEAR) })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1252 */     DUAL_TACHI_GUARD = builder.nextAccessor("biped/pugilist_steve/dual_tachi_guard", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1254 */     DUAL_TACHI_GUARD_HIT = builder.nextAccessor("biped/pugilist_steve/dual_tachi_guard_hit", accessor -> new GuardAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1256 */     WHIRLWIND_KICK_LEFT = builder.nextAccessor("biped/pugilist_steve/whirlwind_kick_left", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.3F, 0.7F, 0.9F, Float.MAX_VALUE, ColliderPreset.BIPED_BODY_COLLIDER, ((HumanoidArmature)humanoidArmature.get()).legL, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(10.8F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addEvents((AnimationEvent[])new AnimationEvent.InTimeEvent[] { (AnimationEvent.InTimeEvent)AnimationEvent.InTimeEvent.create(0.23F, (AnimationEvent.Event)Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.SERVER).params(EpicFightSounds.WHOOSH.get()) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1268 */     SUPER_PUNCH = builder.nextAccessor("biped/pugilist_steve/super_punch", accessor -> (AttackAnimation)(new AttackAnimation(0.05F, 1.0F, 1.25F, 1.4F, Float.MAX_VALUE, ColliderPreset.SWORD, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1276 */     GUARD_BREAK_ATTACK = builder.nextAccessor("biped/pugilist_steve/guard_break_attack", accessor -> new KnockdownAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1278 */     SWORD_DASH = builder.nextAccessor("biped/pugilist_steve/sword_dash", accessor -> (DashAttackAnimation)(new DashAttackAnimation(0.12F, 0.1F, 0.25F, 0.4F, 0.65F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.6F)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1283 */     TACHI_DASH = builder.nextAccessor("biped/pugilist_steve/tachi_dash", accessor -> (DashAttackAnimation)(new DashAttackAnimation(0.15F, 0.1F, 0.2F, 0.45F, 0.7F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG));
/*      */ 
/*      */ 
/*      */     
/* 1287 */     DUAL_SWORD_SKILL = builder.nextAccessor("biped/pugilist_steve/dual_sword_skill", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { 
/*      */             (new AttackAnimation.Phase(0.0F, 0.15F, 0.25F, 0.25F, 0.25F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(0.25F, 0.25F, 0.4F, 0.5F, 0.5F, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(0.5F, 0.5F, 0.6F, 0.6F, 0.6F, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(0.6F, 0.6F, 0.75F, 0.75F, 0.75F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(0.75F, 0.75F, 0.8F, 0.9F, 0.9F, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(0.9F, 0.9F, 1.0F, 1.0F, 1.0F, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.0F, 1.0F, 1.1F, 1.1F, 1.1F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.1F, 1.1F, 1.22F, 1.22F, 1.22F, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.22F, 1.22F, 1.35F, 1.35F, 1.35F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.35F, 1.35F, 1.42F, 1.42F, 1.42F, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), 
/*      */             (new AttackAnimation.Phase(1.42F, 1.42F, 1.5F, 1.5F, 1.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.5F, 1.5F, 1.6F, 1.6F, 1.6F, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.6F, 1.6F, 1.7F, 1.7F, 1.7F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.7F, 1.7F, 1.8F, 1.8F, 1.8F, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.8F, 1.8F, 1.9F, 1.9F, 1.9F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)), (new AttackAnimation.Phase(1.9F, 2.0F, 2.2F, Float.MAX_VALUE, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(8.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG) })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(false)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(false)).addEvents((AnimationEvent[])new AnimationEvent.InTimeEvent[] { AnimationEvent.InTimeEvent.create(2.5F, (AnimationEvent.Event)ReuseableEvents.END_ATTACK, AnimationEvent.Side.BOTH) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1346 */     DUAL_END = builder.nextAccessor("biped/pugilist_steve/dual_back_end", accessor -> (ActionAnimation)(new ActionAnimation(0.2F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1353 */     TRIED = builder.nextAccessor("biped/pugilist_steve/tried", accessor -> (KnockdownAnimation)(new KnockdownAnimation(0.2F, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1360 */     GREATSWORD_SKILL = builder.nextAccessor("biped/pugilist_steve/greatsword_skill", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { 
/*      */             (new AttackAnimation.Phase(0.0F, 0.1F, 0.25F, 0.25F, 0.25F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.25F, 0.25F, 0.4F, 0.5F, 0.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.5F, 0.5F, 0.6F, 0.6F, 0.6F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.6F, 0.6F, 0.75F, 0.75F, 0.75F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.75F, 0.75F, 0.8F, 0.9F, 0.9F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.9F, 0.9F, 1.0F, 1.0F, 1.0F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.0F, 1.0F, 1.1F, 1.1F, 1.1F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.1F, 1.1F, 1.22F, 1.22F, 1.22F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.22F, 1.22F, 1.35F, 1.35F, 1.35F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.35F, 1.35F, 1.42F, 1.42F, 1.42F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), 
/*      */             (new AttackAnimation.Phase(1.42F, 1.42F, 1.5F, 1.5F, 1.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.5F, 1.5F, 1.6F, 1.6F, 1.6F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.6F, 1.6F, 1.7F, 1.7F, 1.7F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.7F, 1.7F, 1.8F, 1.85F, 1.85F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.85F, 1.85F, 2.2F, Float.MAX_VALUE, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG) })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(false)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1410 */     LEGENDARY_SWORD_WAKE_UP_ATTACK = builder.nextAccessor("biped/pugilist_steve/legendary_sword_wake_up_attack", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.4F, 0.45F, 0.45F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.45F, 0.5F, 0.8F, Float.MAX_VALUE, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.1F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1418 */     DUAL_E_END = builder.nextAccessor("biped/pugilist_steve/dual_e_end", accessor -> (ActionAnimation)(new ActionAnimation(0.2F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(true)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(true)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1425 */     AXE_FUN_SKILL = builder.nextAccessor("biped/pugilist_steve/axe_fun_skill", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { 
/*      */             (new AttackAnimation.Phase(0.0F, 0.1F, 0.25F, 0.25F, 0.25F, ((HumanoidArmature)humanoidArmature.get()).toolR, ColliderPreset.SWORD)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.25F, 0.25F, 0.4F, 0.5F, 0.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.5F, 0.5F, 0.6F, 0.6F, 0.6F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.6F, 0.6F, 0.75F, 0.75F, 0.75F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.75F, 0.75F, 0.8F, 0.9F, 0.9F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(0.9F, 0.9F, 1.0F, 1.0F, 1.0F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.0F, 1.0F, 1.1F, 1.1F, 1.1F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.1F, 1.1F, 1.22F, 1.22F, 1.22F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.22F, 1.22F, 1.35F, 1.35F, 1.35F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.35F, 1.35F, 1.42F, 1.42F, 1.42F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), 
/*      */             (new AttackAnimation.Phase(1.42F, 1.42F, 1.5F, 1.5F, 1.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.5F, 1.5F, 1.55F, 1.55F, 1.55F, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)), (new AttackAnimation.Phase(1.55F, 1.6F, 1.7F, Float.MAX_VALUE, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG) })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addState(EntityState.MOVEMENT_LOCKED, Boolean.valueOf(true)).addState(EntityState.TURNING_LOCKED, Boolean.valueOf(false)).addState(EntityState.LOCKON_ROTATE, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1469 */     LEGENDARY_SWORD_AUTO_4 = builder.nextAccessor("biped/pugilist_steve/legendary_sword_auto_4", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.4F, 0.45F, 0.45F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.45F, 0.55F, 0.7F, 0.7F, Float.MAX_VALUE, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.5F), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.05F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.45F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.TORMENT_GROUNDSLAM, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1484 */     OBSIDIAN_FIST_DASH = builder.nextAccessor("biped/pugilist_steve/obsidian_fist_dash", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.25F, 0.45F, 0.7F, 0.95F, ColliderPreset.BIPED_BODY_COLLIDER, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.AIR_BURST).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.6F, (AnimationEvent.Event)ReuseableEvents.THROW_OBSIDIAN, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1495 */     SHADOW_OBSIDIAN_SWORD_ONEHAND_LONG = builder.nextAccessor("biped/pugilist_steve/shadow_obsidian_sword_onehand_long", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, 0.15F, 0.2F, 0.3F, 0.75F, AVCollider.SHADOW_OBSIDIAN_PILLAR, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1500 */     SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO4 = builder.nextAccessor("biped/pugilist_steve/shadow_obsidian_sword_dual_sword_auto4", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.633F, 0.69F, 0.8F, 1.167F, 1.65F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, AVCollider.SHADOW_OBSIDIAN_PILLAR) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)));
/*      */ 
/*      */ 
/*      */     
/* 1504 */     SHADOW_OBSIDIAN_SWORD_DUAL_SWORD_AUTO5 = builder.nextAccessor("biped/pugilist_steve/shadow_obsidian_sword_dual_sword_auto5", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.633F, 0.69F, 0.8F, 1.167F, 1.65F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, AVCollider.SHADOW_OBSIDIAN_PILLAR) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)));
/*      */ 
/*      */ 
/*      */     
/* 1508 */     TRIDENT_THROW_2 = builder.nextAccessor("biped/pugilist_steve/trident_throw_2", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.63F, 0.667F, 0.667F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(2.5F)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.6F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1517 */     TRIDENT_THROW_LEGENDARY = builder.nextAccessor("biped/pugilist_steve/trident_throw_legendary", accessor -> (BasicAttackAnimation)(new BasicAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.63F, 0.667F, 0.667F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.2F, 0.7F, 0.8F, 0.9F, 1.3F, ((HumanoidArmature)humanoidArmature.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(2.5F)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1528 */     ADVANCED_LANCER_AUTO1 = builder.nextAccessor("biped/battle_style/advanced_lancer_auto1", access -> (BasicAttackAnimation)(new BasicAttackAnimation(0.2F, 0.0F, 0.2F, 0.3F, 0.5F, null, ((HumanoidArmature)Armatures.BIPED.get()).toolR, access, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()));
/*      */ 
/*      */     
/* 1531 */     ADVANCED_LANCER_AUTO3 = builder.nextAccessor("biped/battle_style/advanced_lancer_auto3", access -> (AttackAnimation)(new AttackAnimation(0.2F, 0.0F, 0.75F, 0.9F, 2.0F, null, ((HumanoidArmature)Armatures.BIPED.get()).toolR, access, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundEvents.f_12516_), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundEvents.f_12516_), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1564 */     TRIDENT_THROW_1 = builder.nextAccessor("biped/battle_style/trident_throw_1", access -> (BasicAttackAnimation)(new BasicAttackAnimation(0.2F, 0.0F, 0.2F, 0.3F, 0.5F, null, ((HumanoidArmature)Armatures.BIPED.get()).toolR, access, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.0F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_RIGHT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1570 */     TRIDENT_THROW_5 = builder.nextAccessor("biped/battle_style/trident_throw_5", access -> (AttackAnimation)(new AttackAnimation(0.2F, 0.0F, 0.75F, 0.9F, 2.0F, null, ((HumanoidArmature)Armatures.BIPED.get()).toolR, access, (AssetAccessor)Armatures.BIPED)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundEvents.f_12516_), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundEvents.f_12516_), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_RIGHT_EXPLODE, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1580 */     ADVANCED_DUELIST_WHIRLEDGE = builder.nextAccessor("biped/battle_style/advanced_duelist_whirledge", access -> (AttackAnimation)(new AttackAnimation(0.2F, access, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { (new AttackAnimation.Phase(0.0F, 0.3F, 0.3F, 0.4F, 0.4F, 0.4F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.1F)), (new AttackAnimation.Phase(0.4F, 0.0F, 0.4F, 0.5F, 0.5F, 0.5F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.15F)), (new AttackAnimation.Phase(0.5F, 0.0F, 0.5F, 0.6F, 0.6F, 0.6F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2F)), (new AttackAnimation.Phase(0.6F, 0.0F, 0.6F, 0.7F, 0.7F, 0.7F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.25F)), (new AttackAnimation.Phase(0.7F, 0.0F, 0.7F, 0.8F, 0.8F, 0.8F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, null)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.3F)), (new AttackAnimation.Phase(0.8F, 0.0F, 0.8F, 0.9F, 0.9F, 0.9F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, null)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.35F)), (new AttackAnimation.Phase(0.9F, 0.0F, 1.25F, 1.35F, 2.0F, 2.0F, InteractionHand.MAIN_HAND, ((HumanoidArmature)humanoidArmature.get()).rootJoint, ColliderPreset.BATTOJUTSU_DASH)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F)) })).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.7F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.7F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1611 */     ADVANCED_DUELIST_SHOOTING_STAR = builder.nextAccessor("biped/battle_style/advanced_duelist_shooting_star", access -> (AttackAnimation)(new AttackAnimation(0.2F, 0.6F, 0.5F, 0.6F, 1.9F, ColliderPreset.BATTOJUTSU_DASH, ((HumanoidArmature)Armatures.BIPED.get()).rootJoint, access, (AssetAccessor)Armatures.BIPED)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.5F })).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundEvents.f_12515_), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), AnimationEvent.InTimeEvent.create(0.6F, (AnimationEvent.Event)Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.SERVER).params(new Vec3f(0.0F, -0.24F, -2.0F), ((HumanoidArmature)Armatures.BIPED.get()).rootJoint, Double.valueOf(1.2D), Float.valueOf(1.0F)) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1653 */     TRIDENT_THROW_3 = builder.nextAccessor("biped/omneria/trident_throw_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.3F, 0.5F, 0.3F, 0.3F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).handR, WOMWeaponColliders.PUNCH), new AttackAnimation.Phase(0.3F, 0.5F, 0.7F, 0.8F, Float.MAX_VALUE, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolR, WOMWeaponColliders.PUNCH) })).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.f_12516_).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_WEAPON_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_WEAPON_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_WEAPON_RIGHT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1678 */     CUT_DP_AIR_ATTACK = builder.nextAccessor("biped/epicfight_awaken/cut_dp_airattack", accessor -> (AttackAnimation)(new AttackAnimation(0.05F, accessor, (AssetAccessor)Armatures.BIPED, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.167F, 0.167F, 0.38F, 1.0F, Float.MAX_VALUE, InteractionHand.MAIN_HAND, ((HumanoidArmature)Armatures.BIPED.get()).toolL, null) })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.REMOVE_DELTA_MOVEMENT, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).newTimePair(0.0F, 0.3F).addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).newTimePair(0.3F, 10.0F));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1688 */     CUT_HOOK_SPIN_SLASH_AIR = builder.nextAccessor("biped/epicfight_awaken/cut_hook_spin_slash_air", accessor -> (AttackAnimation)(new AttackAnimation(0.15F, accessor, (AssetAccessor)Armatures.BIPED, new AttackAnimation.Phase[] { (new AttackAnimation.Phase(0.0F, 0.0F, 0.8F, 0.9F, 0.9F, 0.9F, InteractionHand.MAIN_HAND, new AttackAnimation.JointColliderPair[] { AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolR, null), AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.05F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL), (new AttackAnimation.Phase(0.9F, 0.9F, 0.95F, 1.05F, 1.05F, 1.05F, InteractionHand.MAIN_HAND, new AttackAnimation.JointColliderPair[] { AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolR, null), AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.05F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL), (new AttackAnimation.Phase(1.05F, 1.05F, 1.15F, 1.25F, 10.0F, Float.MAX_VALUE, InteractionHand.MAIN_HAND, new AttackAnimation.JointColliderPair[] { AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolR, null), AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.05F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL) })).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.AFFECT_SPEED, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(false)).newTimePair(0.0F, 1.45F).addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).newTimePair(0.0F, 1.95F).addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1707 */     DP_THROW_BLADE_AUTO_1 = builder.nextAccessor("biped/epicfight_awaken/throw_blade_auto_1", accessor -> (AttackAnimation)(new AttackAnimation(0.15F, 0.33F, 0.33F, 1.33F, 1.33F, ColliderPreset.FIST, ((HumanoidArmature)Armatures.BIPED.get()).rootJoint, accessor, (AssetAccessor)Armatures.BIPED)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.15F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.15F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.23F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.23F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_RIGHT, AnimationEvent.Side.SERVER) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).newTimePair(0.0F, 0.6F).addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).newTimePair(0.0F, 0.83F).addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1717 */     DP_THROW_BLADE_AUTO_2 = builder.nextAccessor("biped/epicfight_awaken/throw_blade_auto_2", accessor -> (AttackAnimation)(new AttackAnimation(0.15F, 0.53F, 0.53F, 1.2F, 1.2F, ColliderPreset.FIST, ((HumanoidArmature)Armatures.BIPED.get()).rootJoint, accessor, (AssetAccessor)Armatures.BIPED)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.43F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.43F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_LEFT_LIGHTNING, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.43F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.43F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_RIGHT_LIGHTNING, AnimationEvent.Side.SERVER) }).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).newTimePair(0.0F, 0.76F).addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).newTimePair(0.0F, 1.0F).addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1727 */     THROW_HOOK_SLASH_AIR = builder.nextAccessor("biped/epicfight_awaken/throw_hook_slash_air", accessor -> (AttackAnimation)(new AttackAnimation(0.15F, accessor, (AssetAccessor)Armatures.BIPED, new AttackAnimation.Phase[] { (new AttackAnimation.Phase(0.0F, 0.0F, 0.33F, 0.46F, 0.46F, 0.46F, InteractionHand.MAIN_HAND, new AttackAnimation.JointColliderPair[] { AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolR, null), AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1F)), (new AttackAnimation.Phase(0.46F, 0.46F, 0.47F, 0.6F, 10.0F, Float.MAX_VALUE, InteractionHand.MAIN_HAND, new AttackAnimation.JointColliderPair[] { AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolR, null), AttackAnimation.JointColliderPair.of(((HumanoidArmature)Armatures.BIPED.get()).toolL, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1F)) })).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.AFFECT_SPEED, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(false)).newTimePair(0.0F, 0.85F).addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).newTimePair(0.0F, 1.35F).addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.THROW_TRIDENT_HAND_RIGHT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1745 */     ZAP = builder.nextAccessor("biped/tactical_imbuements/zap", accessor -> (LongHitAnimation)(new LongHitAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1750 */     ZAP_LONG = builder.nextAccessor("biped/tactical_imbuements/zap_long", accessor -> (LongHitAnimation)(new LongHitAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1757 */     PLAYER_HEROBRINE_POSSESSION = builder.nextAccessor("biped/sculk_steve/player_herobrine_possession", accessor -> new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1759 */     LEGENDARY_SWORD_IDLE = builder.nextAccessor("biped/sculk_steve/legendary_sword_idle", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1761 */     HEROBRINE_SACRIFICING = builder.nextAccessor("biped/sculk_steve/herobrine_sacrificing", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1763 */     HEROBRINE_ASSISTANCE = builder.nextAccessor("biped/sculk_steve/herobrine_assistance", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1765 */     HEROBRINE_STAGE_CHANGE = builder.nextAccessor("biped/sculk_steve/herobrine_stage_change", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1767 */     PORTAL_SUMMON = builder.nextAccessor("biped/sculk_steve/portal_summon", accessor -> new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature));
/*      */ 
/*      */ 
/*      */     
/* 1771 */     TRIDENT_ATTACK = builder.nextAccessor("biped/pla/trident_attack", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { 
/*      */             (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), 
/*      */             (AnimationEvent)AnimationEvent.InTimeEvent.create(2.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(4.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1804 */     HEROBRINE_ANIMATE = builder.nextAccessor("biped/pla/herobrine_animate", accessor -> new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1806 */     HEROBRINE_HEALING = builder.nextAccessor("biped/pla/herobrine_healing", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1808 */     LOW_CLONE_ESCAPE = builder.nextAccessor("biped/pla/low_clone_escape", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1810 */     KNOCKED_ELITE = builder.nextAccessor("biped/pla/knocked_elite", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1812 */     EATING_ELITE_1 = builder.nextAccessor("biped/pla/eating_elite_1", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1814 */     EATING_ELITE_2 = builder.nextAccessor("biped/pla/eating_elite_2", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1816 */     EATING_ELITE_3 = builder.nextAccessor("biped/pla/eating_elite_3", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1818 */     EATING_ELITE_4 = builder.nextAccessor("biped/pla/eating_elite_4", accessor -> new StaticAnimation(true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1820 */     SNAKE_BLADE = builder.nextAccessor("biped/pla/snake_blade", accessor -> (new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1829 */     SNAKE_BLADE_GUARD = builder.nextAccessor("biped/pla/snake_blade_guard", accessor -> (new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature)).addState(EntityState.CAN_BASIC_ATTACK, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1838 */     IDLE_BREAK = builder.nextAccessor("biped/pla/idle_break", accessor -> new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 1840 */     PLACE_BLOCK = builder.nextAccessor("biped/pla/place_block", accessor -> new ActionAnimation(0.0F, accessor, (AssetAccessor)humanoidArmature));
/*      */ 
/*      */ 
/*      */     
/* 1844 */     CUT_ANTITHEUS_ASCENSION = builder.nextAccessor("biped/wom_clone/cut_antitheus_ascension", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1858 */     TORMENT_BERSERK_WALK = builder.nextAccessor("biped/wom_clone/torment_berserk_walk", accessor -> new MovementAnimation(0.1F, true, accessor, (AssetAccessor)humanoidArmature));
/* 1859 */     TRIDENT_GUARD_HIT_1 = builder.nextAccessor("biped/wom_clone/trident_guard_hit1", accessor -> (new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1868 */     TRIDENT_GUARD_HIT_2 = builder.nextAccessor("biped/wom_clone/trident_guard_hit2", accessor -> (new StaticAnimation(false, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1877 */     ELECTRIC_FIELD = builder.nextAccessor("biped/wom_clone/electric_field", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, Float.MAX_VALUE, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { 
/*      */             (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), 
/*      */             (AnimationEvent)AnimationEvent.InTimeEvent.create(2.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(2.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(3.8F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1905 */     GLOWING_AGONY_GUARD = builder.nextAccessor("biped/wom_clone/glowing_agony_guard", accessor -> (new StaticAnimation(0.05F, true, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.0F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING_AGONY, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING_AGONY, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING_AGONY, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING_AGONY, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING_AGONY, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING_AGONY, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.6F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING_AGONY, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.7F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING_AGONY, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1915 */     ENDER_AEGIS_BULL_CHARGE = builder.nextAccessor("biped/wom_clone/ender_aegis_bull_charge", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.2F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.25F, 0.29F, 0.29F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.SHOULDER_BUMP), new AttackAnimation.Phase(0.29F, 0.3F, 0.35F, 0.39F, 0.39F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.SHOULDER_BUMP), new AttackAnimation.Phase(0.39F, 0.4F, 0.45F, 0.49F, 0.49F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.SHOULDER_BUMP), new AttackAnimation.Phase(0.49F, 0.5F, 0.55F, 0.59F, 0.59F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.SHOULDER_BUMP), new AttackAnimation.Phase(0.59F, 0.6F, 0.65F, 0.69F, 0.69F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.SHOULDER_BUMP), new AttackAnimation.Phase(0.69F, 0.7F, 0.75F, 0.79F, 0.79F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.SHOULDER_BUMP), new AttackAnimation.Phase(0.79F, 0.8F, 0.85F, 0.89F, 0.89F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.SHOULDER_BUMP), new AttackAnimation.Phase(0.89F, 1.0F, 1.1F, 1.3F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.SHOULDER_BUMP) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F), 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get(), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F), 2).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F), 2).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 2).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get(), 2).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 2).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F), 3).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F), 3).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F), 3).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 3).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get(), 3).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 3).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F), 4).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F), 4).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F), 4).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 4).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get(), 4).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 4).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F), 5).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F), 5).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F), 5).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 5).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get(), 5).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 5).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F), 6).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F), 6).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F), 6).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 6).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get(), 6).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 6).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(2.0F), 7).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(3.0F), 7).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F), 7).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL, 7).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get(), 7).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 7).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(0.0F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1985 */     CLONE_ANTITHEUS_AGRESSION = builder.nextAccessor("biped/wom_clone/clone_antitheus_agression", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.35F, 0.59F, 0.59F, ((HumanoidArmature)humanoidArmature.get()).toolR, WOMWeaponColliders.ANTITHEUS_AGRESSION), new AttackAnimation.Phase(0.59F, 0.6F, 0.65F, 0.85F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.ANTITHEUS_AGRESSION_REAP) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_DOWN).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.9F), 1).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(WOMExtraDamageInstance.WOM_TARGET_CURRENT_HEALTH.create(new float[] { 1.0F }, )), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL, 1).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.EVISCERATE.get(), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_UP, 1).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, Integer.valueOf(1)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2011 */     CLONE_ANTITHEUS_GUILLOTINE = builder.nextAccessor("biped/wom_clone/clone_antitheus_guillotine", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.75F, 0.79F, 0.79F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.79F, 0.8F, 1.0F, 1.1F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.4F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F), 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_REVERSE).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_REVERSE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, Integer.valueOf(6)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.3F })).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2038 */     CLONE_ANTITHEUS_AUTO_1 = builder.nextAccessor("biped/wom_clone/clone_antitheus_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.35F, 0.55F, 0.69F, 0.69F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.69F, 0.7F, 0.9F, 0.9F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.55F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.75F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT, 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, Integer.valueOf(1)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2054 */     CLONE_ANTITHEUS_AUTO_2 = builder.nextAccessor("biped/wom_clone/clone_antitheus_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.15F, 0.45F, 0.45F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_REVERSE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.7F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2069 */     CLONE_ANTITHEUS_AUTO_3 = builder.nextAccessor("biped/wom_clone/clone_antitheus_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.35F, 0.5F, 0.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.5F, 0.55F, 0.7F, 0.75F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_REVERSE).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_REVERSE, 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, Integer.valueOf(5)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2084 */     CLONE_ANTITHEUS_AUTO_4 = builder.nextAccessor("biped/wom_clone/clone_antitheus_auto_4", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, 0.5F, 0.75F, 0.9F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_REVERSE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.7F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, Integer.valueOf(2)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.2F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2100 */     CLONE_ANTITHEUS_ASCENSION = builder.nextAccessor("biped/wom_clone/clone_antitheus_ascension", accessor -> (AttackAnimation)(new AttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.6F, 0.65F, 0.65F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.PLUNDER_PERDITION), new AttackAnimation.Phase(0.65F, 1.75F, 2.05F, 2.8F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.PLUNDER_PERDITION) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(20.0F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F), 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(20.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT, 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.7F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(1.0F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2115 */     NULL_SKELETON_ANTITHEUS_ASCENSION = builder.nextAccessor("biped/wom_clone/null_skeleton_antitheus_ascension", accessor -> (AttackAnimation)(new AttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.6F, 0.65F, 0.65F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.PLUNDER_PERDITION), new AttackAnimation.Phase(0.65F, 1.75F, 2.05F, 2.8F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.PLUNDER_PERDITION) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(20.0F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F), 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(20.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT, 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.7F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(1.0F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2169 */     CLONE_ANTITHEUS_LAPSE = builder.nextAccessor("biped/wom_clone/clone_antitheus_lapse", accessor -> (AttackAnimation)(new AttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.65F, 0.75F, 0.8F, 0.8F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.PLUNDER_PERDITION), new AttackAnimation.Phase(0.8F, 1.3F, 1.4F, 1.45F, 1.45F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.PLUNDER_PERDITION), new AttackAnimation.Phase(1.45F, 1.75F, 1.85F, 2.3F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.PLUNDER_PERDITION) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(20.0F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.f_12557_).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(4.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(20.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.f_12557_, 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F), 2).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(20.0F), 2).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT, 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 2).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.7F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(1.0F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2192 */     CLONE_ANTITHEUS_ASCENDED_DEATHFALL = builder.nextAccessor("biped/wom_clone/clone_antitheus_ascended_deathfall", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.5F, 0.55F, 0.75F, WOMWeaponColliders.ANTITHEUS_ASCENDED_DEATHFALL, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.75F })).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.45F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.55F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.55F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2258 */     CLONE_ANTITHEUS_ASCENDED_BLINK = builder.nextAccessor("biped/wom_clone/clone_antitheus_ascended_blink", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.3F, 0.4F, 0.4F, WOMWeaponColliders.ANTITHEUS_ASCENDED_BLINK, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.4F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_HIT_REVERSE).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)).addProperty((AnimationProperty.StaticAnimationProperty)WomAnimationProperty.ANTI_STUN_MULTIPLYER, Float.valueOf(0.0F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2277 */     CLONE_ANTITHEUS_ASCENDED_BLACKHOLE = builder.nextAccessor("biped/wom_clone/clone_antitheus_ascended_blackhole", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 1.45F, 1.5F, 1.7F, WOMWeaponColliders.PLUNDER_PERDITION, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(30.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.5F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 1.7F })).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.05F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.45F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.45F, (), AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2341 */     ENDER_AEGIS_MOONLESS_AUTO_1 = builder.nextAccessor("biped/wom_clone/ender_aegis_moonless_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.25F, 0.45F, 0.5F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.8F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SMALL.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLADE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2351 */     ENDER_AEGIS_MOONLESS_AUTO_2 = builder.nextAccessor("biped/wom_clone/ender_aegis_moonless_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.8F, 1.0F, 1.0F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, WOMWeaponColliders.MOONLESS_BYPASS) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(0.5F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.8F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.SHARPCUT_ANGLED_DOWN_LEFT_SLASH).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.4F)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2363 */     YELLOW_SOLAR_AUTO_2 = builder.nextAccessor("biped/wom_clone/yellow_solar_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.65F, 0.8F, 1.0F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.SOLAR_HIT_UP).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_RUSH_FINISHER.get()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.SOLAR_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2376 */     YELLOW_NAPOLEON_AUTO_3 = builder.nextAccessor("biped/wom_clone/yellow_napoleon_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.35F, 0.39F, 0.39F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.39F, 0.5F, 0.7F, 0.74F, 0.74F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.74F, 0.75F, 0.85F, 1.19F, 1.19F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(1.19F, 1.2F, 2.2F, 2.25F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.1F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 2).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F), 2).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 2).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 3).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F), 3).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F), 3).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL, 3).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.15F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 1.2F, 2.25F })).addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(true)).newTimePair(0.0F, 0.85F).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(2.4F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2409 */     YELLOW_NAPOLEON_AUSTERLITZ_SHOOT = builder.nextAccessor("biped/wom_clone/yellow_napoleon_austerlitz_shoot", accessor -> (SpecialAttackAnimation)(new SpecialAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.4F, 0.41F, 0.41F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.41F, 0.85F, 1.05F, 1.15F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.4F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)WomAnimationProperty.ANTI_STUN_MULTIPLYER, Float.valueOf(1.0F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.0F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2457 */     ENDER_AEGIS_NAPOLEON_RELOAD_1 = builder.nextAccessor("biped/wom_clone/ender_aegis_napoleon_reload_1", accessor -> (SpecialAttackAnimation)(new SpecialAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.25F, 0.3F, 0.3F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.3F, 0.35F, 0.45F, 0.5F, 0.5F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.5F, 0.55F, 0.65F, 0.7F, 0.7F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.7F, 0.75F, 0.95F, 1.0F, 1.0F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(1.0F, 1.05F, 1.2F, 1.25F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2F), 2).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 2).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.3F), 3).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 3).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 3).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.3F), 4).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 4).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 4).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty((AnimationProperty.StaticAnimationProperty)WomAnimationProperty.ANTI_STUN_MULTIPLYER, Float.valueOf(1.0F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(2.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2489 */     ENDER_GLAIVE_NAPOLEON_AUTO_1 = builder.nextAccessor("biped/wom_clone/ender_glaive_napoleon_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.2F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.1F, 0.45F, 0.79F, 0.79F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.79F, 0.8F, 1.0F, 1.05F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(2.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2507 */     ENDER_GLAIVE_NAPOLEON_AUTO_2 = builder.nextAccessor("biped/wom_clone/ender_glaive_napoleon_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.6F, 0.64F, 0.64F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.64F, 0.65F, 0.95F, 1.0F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.7F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(2.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2526 */     ENDER_GLAIVE_NAPOLEON_AUTO_4 = builder.nextAccessor("biped/wom_clone/ender_glaive_napoleon_auto_4", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.6F, 1.0F, 1.9F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 1.2F })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(2.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2542 */     ENDER_GLAIVE_NAPOLEON_AUSTERLITZ = builder.nextAccessor("biped/wom_clone/ender_glaive_napoleon_austerlitz", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.05F, 0.1F, 0.14F, 0.14F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.14F, 0.15F, 0.3F, 0.35F, 0.35F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.35F, 0.45F, 0.55F, 0.59F, 0.59F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.59F, 0.6F, 0.8F, 0.9F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.3F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.5F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL, 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5F), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 2).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F), 3).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.7F), 3).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL, 3).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.4F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(2.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2566 */     DEMONIAC_RUINE_AUTO_1 = builder.nextAccessor("biped/wom_clone/demoniac_ruine_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.25F, 0.2F, 0.55F, 0.55F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.75F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2579 */     DEMONIAC_RUINE_AUTO_2 = builder.nextAccessor("biped/wom_clone/demoniac_ruine_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.2F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.55F, 0.59F, 0.59F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.59F, 0.6F, 0.85F, 0.95F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.95F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2595 */     DEMONIAC_RUINE_AUTO_4 = builder.nextAccessor("biped/wom_clone/demoniac_ruine_auto_4", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.25F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.5F, 0.6F, 0.65F, 0.65F, ((HumanoidArmature)humanoidArmature.get()).toolR, WOMWeaponColliders.RUINE_COMET), new AttackAnimation.Phase(0.65F, 0.8F, 1.05F, 1.45F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.4F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F), 1).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(WOMExtraDamageInstance.WOM_TARGET_CURRENT_HEALTH.create(new float[] { 1.0F }, )), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.4F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NEUTRALIZE, 1).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.5F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2616 */     DEMONIAC_RUINE_COMET = builder.nextAccessor("biped/wom_clone/demoniac_ruine_comet", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.25F, 0.55F, 0.75F, WOMWeaponColliders.RUINE_COMET, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(WOMExtraDamageInstance.WOM_TARGET_CURRENT_HEALTH.create(new float[] { 0.5F }))).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.8F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, Integer.valueOf(20)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.5F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.3F })).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.25F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.RUINE_COMET_AIRBURST, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.RUINE_COMET_GROUNDTHRUST, AnimationEvent.Side.CLIENT) }).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2664 */     DEMONIAC_TORMENT_CHARGED_ATTACK_2 = builder.nextAccessor("biped/wom_clone/demoniac_torment_charged_attack_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.25F, 0.4F, 1.0F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.15F, 0.65F })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2681 */     AGONY_GUARD_HIT_1 = builder.nextAccessor("biped/wom_clone/agony_guard_hit1", accessor -> (ActionAnimation)(new ActionAnimation(0.05F, 0.5F, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.FAST_SPINING, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2690 */     ENDER_GLAIVE_NAPOLEON_SHOOT_3 = builder.nextAccessor("biped/wom_clone/ender_glaive_napoleon_shoot_3", accessor -> (SpecialAttackAnimation)(new SpecialAttackAnimation(0.2F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.3F, 0.4F, 0.44F, 0.44F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.44F, 0.45F, 0.5F, 0.95F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.5F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.1F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)WomAnimationProperty.ANTI_STUN_MULTIPLYER, Float.valueOf(1.0F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2738 */     ENDER_GLAIVE_AGONY_AUTO_1 = builder.nextAccessor("biped/wom_clone/ender_glaive_agony_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.25F, 0.3F, 0.3F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.3F, 0.55F, 0.65F, 0.7F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.29F), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.6F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2809 */     ENDER_GLAIVE_NAPOLEON_AUTO_3 = builder.nextAccessor("biped/wom_clone/ender_glaive_napoleon_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.35F, 0.39F, 0.39F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.39F, 0.5F, 0.7F, 0.74F, 0.74F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.74F, 0.75F, 0.85F, 1.19F, 1.19F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(1.19F, 1.2F, 2.2F, 2.25F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.1F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 2).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F), 2).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 2).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 3).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F), 3).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F), 3).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL, 3).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.15F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 1.2F, 2.25F })).addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(true)).newTimePair(0.0F, 0.85F).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(2.0F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2842 */     ENDER_GLAIVE_NAPOLEON_WATERLOW = builder.nextAccessor("biped/wom_clone/ender_glaive_napoleon_waterlow", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.35F, 0.39F, 0.39F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.39F, 0.4F, 0.6F, 0.64F, 0.64F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.64F, 0.65F, 1.0F, 1.1F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, null) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.3F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.2F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F), 2).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.7F), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.FALL, 2).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.4F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.2F })).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.4F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2866 */     CLONE_ENDERBLASTER_TWOHAND_TOMAHAWK = builder.nextAccessor("biped/wom_clone/clone_enderblaster_twohand_dash", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.3F, 0.44F, 0.45F, 0.45F, ((HumanoidArmature)humanoidArmature.get()).legL, WOMWeaponColliders.KICK_HUGE), new AttackAnimation.Phase(0.45F, 0.5F, 0.6F, 0.65F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.TORMENT_AIRSLAM) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3F), 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(5.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(5.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 1).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get(), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.8F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.45F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.GROUND_BODYSCRAPE_LAND, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2885 */     YELLOW_TORMENT_CHARGED_ATTACK_3 = builder.nextAccessor("biped/wom_clone/yellow_torment_charged_attack_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 1.0F, 1.2F, 1.5F, WOMWeaponColliders.TORMENT_BERSERK_AIRSLAM, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.8F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(3.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.FINISHER)).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.BYPASS_DODGE)).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.GUARD_PUNCTURE)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.1F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.35F, 0.9F })).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.AIRBURST_JUMP, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.15F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.TORMENT_GROUNDSLAM, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.15F, (AnimationEvent.Event)ReuseableEvents.SHOCK_WAVE, AnimationEvent.Side.SERVER) }).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2964 */     CLONE_ENDERBLASTER_ONEHAND_DASH = builder.nextAccessor("biped/wom_clone/clone_enderblaster_onehand_dash", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.15F, 0.2F, 0.45F, 0.45F, ((HumanoidArmature)humanoidArmature.get()).legL, WOMWeaponColliders.KICK_HUGE), new AttackAnimation.Phase(0.45F, 0.45F, 0.75F, 1.0F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).legL, WOMWeaponColliders.KICK_HUGE) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT, 1).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get(), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.8F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, ()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3005 */     SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1 = builder.nextAccessor("biped/wom_clone/sledgehammer_torment_berserk_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.4F, 0.15F, 0.5F, 0.5F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(9.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_RUSH_FINISHER.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.OVERBLOOD_HIT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(0.8F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(1.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)ReuseableEvents.SLEDGEHAMMER_SHOOT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3019 */     SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2 = builder.nextAccessor("biped/wom_clone/sledgehammer_torment_berserk_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.4F, 0.15F, 0.5F, 0.5F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(9.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_RUSH_FINISHER.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.OVERBLOOD_HIT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(0.8F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(1.2F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.31F, (AnimationEvent.Event)ReuseableEvents.SLEDGEHAMMER_SHOOT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3033 */     SLEDGEHAMMER_SOLAR_AUTO_3 = builder.nextAccessor("biped/wom_clone/sledgehammer_solar_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.4F, 0.75F, 0.85F, null, ((HumanoidArmature)humanoidArmature.get()).toolR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.3F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_RUSH_FINISHER.get()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.3F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.6F, (AnimationEvent.Event)ReuseableEvents.SLEDGEHAMMER_SHOOT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.5F, (), AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3050 */     CLONE_ANTITHEUS_SHOOT = builder.nextAccessor("biped/wom_clone/clone_antitheus_shoot", accessor -> (AntitheusShootAttackAnimation)(new AntitheusShootAttackAnimation(0.05F, 0.05F, 0.1F, 0.5F, WOMWeaponColliders.ANTITHEUS_SHOOT, ((HumanoidArmature)humanoidArmature.get()).toolL, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(WOMExtraDamageInstance.WOM_SWEEPING_EDGE_ENCHANTMENT.create(new float[] { 1.0F }))).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.f_12558_).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, SoundEvents.f_12555_).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.7F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(1.0F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3063 */     CLONE_ANTITHEUS_ASCENDED_IDLE = builder.nextAccessor("biped/wom_clone/clone_antitheus_ascended_idle", accessor -> new StaticAnimation(0.1F, true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 3065 */     NULL_ANTITHEUS_ASCENDED_AUTO_1 = builder.nextAccessor("biped/wom_clone/null_antitheus_ascended_auto_1", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.3F, 0.4F, 0.4F, WOMWeaponColliders.ANTITHEUS_ASCENDED_PUNCHES, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.9F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3078 */     NULL_ANTITHEUS_ASCENDED_AUTO_2 = builder.nextAccessor("biped/wom_clone/null_antitheus_ascended_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.3F, 0.4F, 0.5F, 0.5F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.ANTITHEUS_ASCENDED_PUNCHES), new AttackAnimation.Phase(0.5F, 0.6F, 0.7F, 0.7F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.ANTITHEUS_ASCENDED_PUNCHES) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.7F), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT, 1).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get(), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3099 */     NULL_ANTITHEUS_ASCENDED_AUTO_3 = builder.nextAccessor("biped/wom_clone/null_antitheus_ascended_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.2F, 0.3F, 0.35F, 0.35F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.ANTITHEUS_ASCENDED_PUNCHES), new AttackAnimation.Phase(0.35F, 0.4F, 0.5F, 0.55F, 0.55F, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.ANTITHEUS_ASCENDED_PUNCHES), new AttackAnimation.Phase(0.55F, 0.7F, 0.8F, 0.85F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.ANTITHEUS_ASCENDED_PUNCHES) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F), 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.9F), 2).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.7F), 2).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT, 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT, 2).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get(), 1).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get(), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 0).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 2).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.9F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(true)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3122 */     HEROBRINE_MOB_ENDERSTEP_OBSCURIS = builder.nextAccessor("biped/wom_clone/herobrine_mob_ender_obscuris", accessor -> (DodgeAnimation)(new DodgeAnimation(0.05F, accessor, 0.6F, 1.65F, (AssetAccessor)humanoidArmature)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.15F })).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.ENDER_STEP, AnimationEvent.Side.BOTH), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (), AnimationEvent.Side.BOTH) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3210 */     OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL = builder.nextAccessor("biped/wom_clone/obsidian_antitheus_ascended_deathfall", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.5F, 0.55F, 0.75F, WOMWeaponColliders.ANTITHEUS_ASCENDED_DEATHFALL, ((HumanoidArmature)humanoidArmature.get()).rootJoint, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10.0F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, WOMParticles.ANTITHEUS_PUNCH_HIT).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(3.8F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.75F })).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.05F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.45F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (), AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.55F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.55F, (), AnimationEvent.Side.SERVER) }).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_CROSS, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.6F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_CROSS_FIX_DELAY_SHADOW_HEROBRINE, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3281 */     OLD_MOONLESS_RUN = builder.nextAccessor("biped/wom_clone/old_moonless_run", accessor -> new MovementAnimation(0.1F, true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 3283 */     TRIDENT_TWO_HAND_RUN = builder.nextAccessor("biped/wom_clone/trident_two_hand_run", accessor -> new MovementAnimation(0.1F, true, accessor, (AssetAccessor)humanoidArmature));
/*      */     
/* 3285 */     OBSIDIAN_STRONG_PUNCH = builder.nextAccessor("biped/wom_clone/obsidian_strong_punch", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.3F, 0.1F, 0.15F, 0.35F, WOMWeaponColliders.PUNCH, ((HumanoidArmature)humanoidArmature.get()).handL, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(5.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SMALL.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, Float.valueOf(0.0F)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(3.0F)).addProperty((AnimationProperty.StaticAnimationProperty)WomAnimationProperty.ANTI_STUN_MULTIPLYER, Float.valueOf(0.0F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.1F, (AnimationEvent.Event)ReuseableEvents.SUMMON_3_OBSIDIAN_HAND_LEFT, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3299 */     OBSIDIAN_ENDERBLASTER_TWOHAND_TISHNAW = builder.nextAccessor("biped/wom_clone/obsidian_enderblaster_twohand_tishnaw", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.05F, 0.3F, 0.5F, 0.65F, WOMWeaponColliders.KICK_HUGE, ((HumanoidArmature)humanoidArmature.get()).legR, accessor, (AssetAccessor)humanoidArmature)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.65F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(3.2F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(4.0F)).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT.get()).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, Integer.valueOf(20)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(4.0F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.3F })).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.GROUND_BODYSCRAPE_LAND, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_SMALL_CROSS, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3355 */     SHADOW_OBSIDIAN_SWORD_TORMENT_AIRSLAM = builder.nextAccessor("biped/wom_clone/shadow_obsidian_sword_torment_airslam", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.45F, 0.55F, 0.6F, 0.6F, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR), new AttackAnimation.Phase(0.6F, 0.5F, 0.65F, 0.8F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE)).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE), 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.0F })).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.55F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.TORMENT_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3386 */     SHADOW_OBSIDIAN_SWORD_TORMENT_BERSERK_DASH = builder.nextAccessor("biped/wom_clone/shadow_obsidian_sword_torment_berserk_dash", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.45F, 0.5F, 0.55F, 0.55F, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR), new AttackAnimation.Phase(0.55F, 0.8F, 0.85F, 0.9F, 0.9F, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR), new AttackAnimation.Phase(0.9F, 1.35F, 1.4F, 1.4F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).toolR, AVCollider.SHADOW_OBSIDIAN_PILLAR) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F)).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F), 1).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0])), 1).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F), 2).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0])), 2).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(3.0F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(3.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(3.0F), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD, 2).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_RUSH_FINISHER.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_RUSH_FINISHER.get(), 1).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_RUSH_FINISHER.get(), 2).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.0F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, Boolean.valueOf(false)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(false)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.TORMENT_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_WALL, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.85F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.TORMENT_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.85F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_WALL, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.4F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.TORMENT_GROUNDSLAM_SMALL, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.4F, (AnimationEvent.Event)ReuseableEvents.SUMMON_OBSIDIAN_WALL, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3417 */     SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3 = builder.nextAccessor("biped/wom_clone/shadow_obsidian_sword_gezets_auto_3", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.15F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.3F, 0.5F, 0.55F, 0.55F, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).handL, WOMWeaponColliders.PUNCH), new AttackAnimation.Phase(0.55F, 0.7F, 0.85F, 1.0F, Float.MAX_VALUE, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, WOMWeaponColliders.GESETZ) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.33F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(3.4F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.84F), 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(1.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLUNT).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get(), 1).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get(), 1).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLADE, 1).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.5F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.8F, (AnimationEvent.Event)ReuseableEvents.THROW_OBSIDIAN_OFFHAND, AnimationEvent.Side.SERVER) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3441 */     SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_2 = builder.nextAccessor("biped/wom_clone/shadow_obsidian_sword_gezets_auto_2", accessor -> (BasicMultipleAttackAnimation)(new BasicMultipleAttackAnimation(0.2F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.1F, 0.2F, 0.3F, Float.MAX_VALUE, InteractionHand.OFF_HAND, ((HumanoidArmature)humanoidArmature.get()).toolL, WOMWeaponColliders.GESETZ_INSET_LARGE) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.5F)).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get()).addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLADE).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.5F)).addProperty((AnimationProperty.StaticAnimationProperty)WomAnimationProperty.ANTI_STUN_MULTIPLYER, Float.valueOf(0.4F)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (), AnimationEvent.Side.CLIENT) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3454 */     CLONE_NAPOLEON_WATERLOW_SHOOT = builder.nextAccessor("biped/wom_clone/clone_napoleon_waterlow_shoot", accessor -> (SpecialAttackAnimation)(new SpecialAttackAnimation(0.1F, accessor, (AssetAccessor)humanoidArmature, new AttackAnimation.Phase[] { new AttackAnimation.Phase(0.0F, 0.1F, 0.3F, 0.35F, 0.35F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.35F, 0.8F, 0.9F, 0.94F, 0.94F, ((HumanoidArmature)humanoidArmature.get()).toolR, null), new AttackAnimation.Phase(0.94F, 0.95F, 1.1F, 1.1F, Float.MAX_VALUE, ((HumanoidArmature)humanoidArmature.get()).rootJoint, WOMWeaponColliders.NAPOLEON_WATERLOW_SHOOT) })).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F), 1).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(0.0F), 1).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 1).addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.multiplier(6.0F), 2).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F), 2).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.58F), 2).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NONE, 2).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, Float.valueOf(1.2F)).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, null).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(new float[] { 0.0F, 0.8F })).addProperty((AnimationProperty.StaticAnimationProperty)WomAnimationProperty.CAN_SPAM, Boolean.valueOf(true)).addProperty((AnimationProperty.StaticAnimationProperty)WomAnimationProperty.ANTI_STUN_MULTIPLYER, Float.valueOf(1.0F)).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ()).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.15F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.25F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.45F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.75F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.85F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.95F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(1.05F, (), AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InPeriodEvent.create(0.0F, 1.05F, (), AnimationEvent.Side.BOTH) }).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.9F, (AnimationEvent.Event)reascer.wom.gameasset.ReuseableEvents.BODY_BIG_GROUNDSLAM, AnimationEvent.Side.CLIENT) }).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(1.0F, (), AnimationEvent.Side.SERVER) }).addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(true)).newTimePair(0.0F, 0.35F).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)).newTimePair(0.55F, 1.1F).addState(EntityState.CAN_SKILL_EXECUTION, Boolean.valueOf(false)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3554 */     CUT_ENDERBLASTER_TWOHAND_RELOAD = builder.nextAccessor("biped/wom_clone/cut_enderblaster_twohand_reload", accessor -> (new StaticAnimation(0.1F, false, accessor, (AssetAccessor)humanoidArmature)).addEvents(new AnimationEvent[] { (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.TRIDENT_SPINNING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.2F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.25F, (AnimationEvent.Event)ReuseableEvents.TRIDENT_SPINNING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.3F, (AnimationEvent.Event)ReuseableEvents.TRIDENT_SPINNING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)ReuseableEvents.TRIDENT_SPINNING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_RIGHT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.35F, (AnimationEvent.Event)ReuseableEvents.PLAY_TRIDENT_EFFECT_HAND_LEFT, AnimationEvent.Side.SERVER), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.4F, (AnimationEvent.Event)ReuseableEvents.TRIDENT_SPINNING, AnimationEvent.Side.CLIENT), (AnimationEvent)AnimationEvent.InTimeEvent.create(0.5F, (AnimationEvent.Event)ReuseableEvents.TRIDENT_SPINNING, AnimationEvent.Side.CLIENT) }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   private static Vec3 getVec3(LivingEntity owner) {
/* 3570 */     Vec3 look = owner.m_20154_();
/* 3571 */     Vec3 forward = new Vec3(look.f_82479_, 0.0D, look.f_82481_);
/* 3572 */     if (forward.m_82556_() < 1.0E-6D) {
/* 3573 */       float yawRad = (float)Math.toRadians(owner.m_146908_());
/* 3574 */       forward = new Vec3(-Mth.m_14031_(yawRad), 0.0D, Mth.m_14089_(yawRad));
/*      */     } 
/* 3576 */     forward = forward.m_82541_();
/* 3577 */     return forward;
/*      */   }
/*      */   
/*      */   private static class ReuseableEvents { static {
/* 3581 */       FAST_SPINNING = ((livingentitypatch, staticAnimation, aobject) -> ((LivingEntity)livingentitypatch.getOriginal()).m_9236_().m_6269_((Player)livingentitypatch.getOriginal(), livingentitypatch.getOriginal(), (SoundEvent)EpicFightSounds.WHOOSH.get(), SoundSource.NEUTRAL, 0.5F, 1.1F - ((new Random()).nextFloat() - 0.5F) * 0.2F));
/*      */       
/* 3583 */       TRIDENT_SPINNING = ((livingentitypatch, staticAnimation, aobject) -> ((LivingEntity)livingentitypatch.getOriginal()).m_9236_().m_6269_((Player)livingentitypatch.getOriginal(), livingentitypatch.getOriginal(), SoundEvents.f_12516_, SoundSource.NEUTRAL, 0.5F, 1.1F - ((new Random()).nextFloat() - 0.5F) * 0.2F));
/*      */       
/* 3585 */       PLAY_TRIDENT_EFFECT_HAND_LEFT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */ 
/*      */           
/*      */           Level patt348823$temp = livingEntity.m_9236_();
/*      */ 
/*      */           
/*      */           if (patt348823$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt348823$temp;
/*      */ 
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */ 
/*      */             
/*      */             if (weapon instanceof BlueDemonTridentItem) {
/*      */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).handL, (new Random()).nextFloat(-1.0F, 1.0F), 0.0D);
/*      */ 
/*      */               
/*      */               if (jointVec == null) {
/*      */                 return;
/*      */               }
/*      */ 
/*      */               
/*      */               serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK.get(), jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_, 1, 0.0D, 0.0D, 0.0D, 0.0D);
/*      */               
/*      */               float volume = (float)Mth.m_216263_(serverLevel.f_46441_, 0.05D, 0.5D);
/*      */               
/*      */               float pitch = (float)Mth.m_216263_(serverLevel.f_46441_, 0.8D, 1.1D);
/*      */               
/*      */               serverLevel.m_5594_(null, BlockPos.m_274561_(jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY.get(), SoundSource.NEUTRAL, volume, pitch);
/*      */             } 
/*      */           } 
/*      */         });
/*      */       
/* 3619 */       PLAY_TRIDENT_EFFECT_WEAPON_RIGHT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */ 
/*      */           
/*      */           Level patt350759$temp = livingEntity.m_9236_();
/*      */ 
/*      */           
/*      */           if (patt350759$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt350759$temp;
/*      */ 
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */ 
/*      */             
/*      */             if (weapon instanceof BlueDemonTridentItem) {
/*      */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).toolR, (new Random()).nextFloat(-1.0F, 1.0F), 0.0D);
/*      */ 
/*      */               
/*      */               if (jointVec == null) {
/*      */                 return;
/*      */               }
/*      */ 
/*      */               
/*      */               serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK.get(), jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_, 1, 0.0D, 0.0D, 0.0D, 0.0D);
/*      */               
/*      */               float volume = (float)Mth.m_216263_(serverLevel.f_46441_, 0.05D, 0.5D);
/*      */               
/*      */               float pitch = (float)Mth.m_216263_(serverLevel.f_46441_, 0.8D, 1.1D);
/*      */               
/*      */               serverLevel.m_5594_(null, BlockPos.m_274561_(jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY.get(), SoundSource.NEUTRAL, volume, pitch);
/*      */             } 
/*      */           } 
/*      */         });
/*      */       
/* 3653 */       PLAY_TRIDENT_EFFECT_HAND_RIGHT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */ 
/*      */           
/*      */           Level patt352693$temp = livingEntity.m_9236_();
/*      */ 
/*      */           
/*      */           if (patt352693$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt352693$temp;
/*      */ 
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */ 
/*      */             
/*      */             if (weapon instanceof BlueDemonTridentItem) {
/*      */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).handR, (new Random()).nextFloat(-1.0F, 1.0F), 0.0D);
/*      */ 
/*      */               
/*      */               if (jointVec == null) {
/*      */                 return;
/*      */               }
/*      */ 
/*      */               
/*      */               serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK.get(), jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_, 1, 0.0D, 0.0D, 0.0D, 0.0D);
/*      */               
/*      */               float volume = (float)Mth.m_216263_(serverLevel.f_46441_, 0.05D, 0.5D);
/*      */               
/*      */               float pitch = (float)Mth.m_216263_(serverLevel.f_46441_, 0.8D, 1.1D);
/*      */               
/*      */               serverLevel.m_5594_(null, BlockPos.m_274561_(jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY.get(), SoundSource.NEUTRAL, volume, pitch);
/*      */             } 
/*      */           } 
/*      */         });
/*      */       
/* 3687 */       THROW_TRIDENT_HAND_LEFT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt354620$temp = livingEntity.m_9236_();
/*      */           if (patt354620$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt354620$temp;
/*      */             ItemStack stack = livingEntity.m_21206_();
/*      */             Item weapon = stack.m_41720_();
/*      */             if (weapon instanceof BlueDemonTridentItem) {
/*      */               if (livingEntity instanceof Player) {
/*      */                 Player player = (Player)livingEntity;
/*      */                 stack.m_41622_(1, (LivingEntity)player, ());
/*      */               } 
/*      */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).handL, 0.0F, 0.0D);
/*      */               if (jointVec == null) {
/*      */                 return;
/*      */               }
/*      */               Vec3 direction = BlueDemonTridentItem.getTridentThrowDirection(livingEntity, jointVec);
/*      */               if (direction == null || direction.m_82556_() < 1.0E-7D) {
/*      */                 return;
/*      */               }
/*      */               BlueDemonThrownTridentEntity trident = new BlueDemonThrownTridentEntity((Level)serverLevel, livingEntity, stack.m_41777_());
/*      */               trident.assignSpawnSequence(livingEntity);
/*      */               trident.trimOldGroundedTridentsAroundOwnerOnSpawn();
/*      */               trident.m_6034_(jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_);
/*      */               trident.m_146922_((float)(Mth.m_14136_(direction.f_82479_, direction.f_82481_) * 57.29577951308232D));
/*      */               trident.m_146926_((float)(Mth.m_14136_(direction.f_82480_, Math.sqrt(direction.f_82479_ * direction.f_82479_ + direction.f_82481_ * direction.f_82481_)) * 57.29577951308232D));
/*      */               float speed = 2.5F;
/*      */               float inaccuracy = 1.0F;
/*      */               trident.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */               trident.m_6686_(direction.f_82479_, direction.f_82480_, direction.f_82481_, speed, inaccuracy);
/*      */               serverLevel.m_7967_((Entity)trident);
/*      */             } 
/*      */           } 
/*      */         });
/* 3722 */       THROW_TRIDENT_HAND_RIGHT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt356969$temp = livingEntity.m_9236_();
/*      */           if (patt356969$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt356969$temp;
/*      */             ItemStack stack = livingEntity.m_21205_();
/*      */             Item weapon = stack.m_41720_();
/*      */             if (weapon instanceof BlueDemonTridentItem) {
/*      */               if (livingEntity instanceof Player) {
/*      */                 Player player = (Player)livingEntity;
/*      */                 stack.m_41622_(1, (LivingEntity)player, ());
/*      */               } 
/*      */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).handR, 0.0F, 0.0D);
/*      */               if (jointVec == null) {
/*      */                 return;
/*      */               }
/*      */               Vec3 direction = BlueDemonTridentItem.getTridentThrowDirection(livingEntity, jointVec);
/*      */               if (direction == null || direction.m_82556_() < 1.0E-7D) {
/*      */                 return;
/*      */               }
/*      */               BlueDemonThrownTridentEntity trident = new BlueDemonThrownTridentEntity((Level)serverLevel, livingEntity, stack.m_41777_());
/*      */               trident.assignSpawnSequence(livingEntity);
/*      */               trident.trimOldGroundedTridentsAroundOwnerOnSpawn();
/*      */               trident.m_6034_(jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_);
/*      */               trident.m_146922_((float)(Mth.m_14136_(direction.f_82479_, direction.f_82481_) * 57.29577951308232D));
/*      */               trident.m_146926_((float)(Mth.m_14136_(direction.f_82480_, Math.sqrt(direction.f_82479_ * direction.f_82479_ + direction.f_82481_ * direction.f_82481_)) * 57.29577951308232D));
/*      */               float speed = 2.5F;
/*      */               float inaccuracy = 1.0F;
/*      */               trident.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */               trident.m_6686_(direction.f_82479_, direction.f_82480_, direction.f_82481_, speed, inaccuracy);
/*      */               serverLevel.m_7967_((Entity)trident);
/*      */             } 
/*      */           } 
/*      */         });
/* 3757 */       THROW_TRIDENT_HAND_LEFT_LIGHTNING = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt359328$temp = livingEntity.m_9236_();
/*      */           if (patt359328$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt359328$temp;
/*      */             ItemStack stack = livingEntity.m_21206_();
/*      */             Item weapon = stack.m_41720_();
/*      */             if (weapon instanceof BlueDemonTridentItem) {
/*      */               if (livingEntity instanceof Player) {
/*      */                 Player player = (Player)livingEntity;
/*      */                 stack.m_41622_(1, (LivingEntity)player, ());
/*      */               } 
/*      */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).handL, 0.0F, 0.0D);
/*      */               if (jointVec == null) {
/*      */                 return;
/*      */               }
/*      */               Vec3 direction = BlueDemonTridentItem.getTridentThrowDirection(livingEntity, jointVec);
/*      */               if (direction == null || direction.m_82556_() < 1.0E-7D) {
/*      */                 return;
/*      */               }
/*      */               BlueDemonThrownTridentEntity trident = new BlueDemonThrownTridentEntity((Level)serverLevel, livingEntity, stack.m_41777_());
/*      */               trident.assignSpawnSequence(livingEntity);
/*      */               trident.trimOldGroundedTridentsAroundOwnerOnSpawn();
/*      */               trident.setMode(TridentMode.LIGHTNING);
/*      */               trident.m_6034_(jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_);
/*      */               trident.m_146922_((float)(Mth.m_14136_(direction.f_82479_, direction.f_82481_) * 57.29577951308232D));
/*      */               trident.m_146926_((float)(Mth.m_14136_(direction.f_82480_, Math.sqrt(direction.f_82479_ * direction.f_82479_ + direction.f_82481_ * direction.f_82481_)) * 57.29577951308232D));
/*      */               float speed = 2.5F;
/*      */               float inaccuracy = 1.0F;
/*      */               trident.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */               trident.m_6686_(direction.f_82479_, direction.f_82480_, direction.f_82481_, speed, inaccuracy);
/*      */               serverLevel.m_7967_((Entity)trident);
/*      */             } 
/*      */           } 
/*      */         });
/* 3793 */       THROW_TRIDENT_HAND_RIGHT_LIGHTNING = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt361756$temp = livingEntity.m_9236_();
/*      */           if (patt361756$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt361756$temp;
/*      */             ItemStack stack = livingEntity.m_21205_();
/*      */             Item weapon = stack.m_41720_();
/*      */             if (weapon instanceof BlueDemonTridentItem) {
/*      */               if (livingEntity instanceof Player) {
/*      */                 Player player = (Player)livingEntity;
/*      */                 stack.m_41622_(1, (LivingEntity)player, ());
/*      */               } 
/*      */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).handR, 0.0F, 0.0D);
/*      */               if (jointVec == null) {
/*      */                 return;
/*      */               }
/*      */               Vec3 direction = BlueDemonTridentItem.getTridentThrowDirection(livingEntity, jointVec);
/*      */               if (direction == null || direction.m_82556_() < 1.0E-7D) {
/*      */                 return;
/*      */               }
/*      */               BlueDemonThrownTridentEntity trident = new BlueDemonThrownTridentEntity((Level)serverLevel, livingEntity, stack.m_41777_());
/*      */               trident.assignSpawnSequence(livingEntity);
/*      */               trident.trimOldGroundedTridentsAroundOwnerOnSpawn();
/*      */               trident.setMode(TridentMode.LIGHTNING);
/*      */               trident.m_6034_(jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_);
/*      */               trident.m_146922_((float)(Mth.m_14136_(direction.f_82479_, direction.f_82481_) * 57.29577951308232D));
/*      */               trident.m_146926_((float)(Mth.m_14136_(direction.f_82480_, Math.sqrt(direction.f_82479_ * direction.f_82479_ + direction.f_82481_ * direction.f_82481_)) * 57.29577951308232D));
/*      */               float speed = 2.5F;
/*      */               float inaccuracy = 1.0F;
/*      */               trident.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */               trident.m_6686_(direction.f_82479_, direction.f_82480_, direction.f_82481_, speed, inaccuracy);
/*      */               serverLevel.m_7967_((Entity)trident);
/*      */             } 
/*      */           } 
/*      */         });
/* 3829 */       THROW_TRIDENT_HAND_RIGHT_EXPLODE = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt364183$temp = livingEntity.m_9236_();
/*      */           if (patt364183$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt364183$temp;
/*      */             ItemStack stack = livingEntity.m_21205_();
/*      */             Item weapon = stack.m_41720_();
/*      */             if (weapon instanceof BlueDemonTridentItem) {
/*      */               if (livingEntity instanceof Player) {
/*      */                 Player player = (Player)livingEntity;
/*      */                 stack.m_41622_(1, (LivingEntity)player, ());
/*      */               } 
/*      */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).handR, 0.0F, 0.0D);
/*      */               if (jointVec == null) {
/*      */                 return;
/*      */               }
/*      */               Vec3 direction = BlueDemonTridentItem.getTridentThrowDirection(livingEntity, jointVec);
/*      */               if (direction == null || direction.m_82556_() < 1.0E-7D) {
/*      */                 return;
/*      */               }
/*      */               BlueDemonThrownTridentEntity trident = new BlueDemonThrownTridentEntity((Level)serverLevel, livingEntity, stack.m_41777_());
/*      */               trident.assignSpawnSequence(livingEntity);
/*      */               trident.trimOldGroundedTridentsAroundOwnerOnSpawn();
/*      */               trident.setMode(TridentMode.EXPLOSION);
/*      */               trident.m_6034_(jointVec.f_82479_, jointVec.f_82480_, jointVec.f_82481_);
/*      */               trident.m_146922_((float)(Mth.m_14136_(direction.f_82479_, direction.f_82481_) * 57.29577951308232D));
/*      */               trident.m_146926_((float)(Mth.m_14136_(direction.f_82480_, Math.sqrt(direction.f_82479_ * direction.f_82479_ + direction.f_82481_ * direction.f_82481_)) * 57.29577951308232D));
/*      */               float speed = 2.5F;
/*      */               float inaccuracy = 1.0F;
/*      */               trident.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */               trident.m_6686_(direction.f_82479_, direction.f_82480_, direction.f_82481_, speed, inaccuracy);
/*      */               serverLevel.m_7967_((Entity)trident);
/*      */             } 
/*      */           } 
/*      */         });
/* 3865 */       SUMMON_2_OBSIDIAN_LEG_RIGHT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt366605$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt366605$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt366605$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianBlocksInfrontOf(serverLevel, livingEntity, obsidian, 2, ((HumanoidArmature)Armatures.BIPED.get()).legR);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianShortPillarShootToward(serverLevel, (Entity)livingEntity, 3, ((HumanoidArmature)Armatures.BIPED.get()).legR);
/*      */             } 
/*      */           } 
/*      */         });
/* 3887 */       SUMMON_2_OBSIDIAN_LEG_LEFT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt368290$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt368290$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt368290$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianBlocksInfrontOf(serverLevel, livingEntity, obsidian, 2, ((HumanoidArmature)Armatures.BIPED.get()).legL);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianShortPillarShootToward(serverLevel, (Entity)livingEntity, 3, ((HumanoidArmature)Armatures.BIPED.get()).legL);
/*      */             } 
/*      */           } 
/*      */         });
/* 3909 */       SUMMON_2_OBSIDIAN_HAND_RIGHT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt369977$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt369977$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt369977$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianBlocksInfrontOf(serverLevel, livingEntity, obsidian, 2, ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianShortPillarShootToward(serverLevel, (Entity)livingEntity, 3, ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/*      */             } else if (livingEntity.m_21206_().m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*      */               HerobrineUtil.summonShadowObsidianMiddlePillarShootToward(serverLevel, (Entity)livingEntity, 3, ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/*      */             } 
/*      */           } 
/*      */         });
/* 3933 */       SUMMON_2_OBSIDIAN_HAND_LEFT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt371926$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt371926$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt371926$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianBlocksInfrontOf(serverLevel, livingEntity, obsidian, 2, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } else if (livingEntity.m_21206_().m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*      */               HerobrineUtil.summonShadowObsidianMiddlePillarShootToward(serverLevel, (Entity)livingEntity, 3, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianShortPillarShootToward(serverLevel, (Entity)livingEntity, 3, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } 
/*      */           } 
/*      */         });
/* 3957 */       SUMMON_3_OBSIDIAN_HAND_LEFT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt373875$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt373875$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt373875$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianBlocksInfrontOf(serverLevel, livingEntity, obsidian, 3, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } else if (livingEntity.m_21206_().m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*      */               HerobrineUtil.summonShadowObsidianMiddlePillarShootToward(serverLevel, (Entity)livingEntity, 4, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianShortPillarShootToward(serverLevel, (Entity)livingEntity, 4, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } 
/*      */           } 
/*      */         });
/* 3981 */       SUMMON_6_OBSIDIAN_HAND_LEFT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt375824$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt375824$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt375824$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianBlocksInfrontOf(serverLevel, livingEntity, obsidian, 6, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } else if (livingEntity.m_21206_().m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*      */               HerobrineUtil.summonShadowObsidianMiddlePillarShootToward(serverLevel, (Entity)livingEntity, 7, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianShortPillarShootToward(serverLevel, (Entity)livingEntity, 7, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*      */             } 
/*      */           } 
/*      */         });
/* 4005 */       SUMMON_6_OBSIDIAN_HAND_RIGHT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt377774$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt377774$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt377774$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianBlocksInfrontOf(serverLevel, livingEntity, obsidian, 6, ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianShortPillarShootToward(serverLevel, (Entity)livingEntity, 7, ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/*      */             } else if (livingEntity.m_21206_().m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*      */               HerobrineUtil.summonShadowObsidianMiddlePillarShootToward(serverLevel, (Entity)livingEntity, 7, ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/*      */             } 
/*      */           } 
/*      */         });
/* 4029 */       SUMMON_6_OBSIDIAN_LEG_RIGHT = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt379723$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt379723$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt379723$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianBlocksInfrontOf(serverLevel, livingEntity, obsidian, 6, ((HumanoidArmature)Armatures.BIPED.get()).legR);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianShortPillarShootToward(serverLevel, (Entity)livingEntity, 7, ((HumanoidArmature)Armatures.BIPED.get()).legR);
/*      */             } 
/*      */           } 
/*      */         });
/* 4051 */       SUMMON_OBSIDIAN_PILLAR = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt381404$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt381404$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt381404$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianPillar(serverLevel, livingEntity, obsidian);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianLongPillarShootToward(serverLevel, (Entity)livingEntity);
/*      */             } 
/*      */           } 
/*      */         });
/* 4073 */       SUMMON_OBSIDIAN_WALL = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt383011$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt383011$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt383011$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianWall(serverLevel, livingEntity, obsidian);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem || weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*      */               HerobrineUtil.summonShadowObsidianLongPillarDefense(serverLevel, (Entity)livingEntity);
/*      */             } 
/*      */           } 
/*      */         });
/* 4096 */       SUMMON_OBSIDIAN_CIRCLE = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           Level patt384661$temp = livingEntity.m_9236_();
/*      */           if (patt384661$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt384661$temp;
/*      */             HerobrineUtil.summonShadowObsidianLongPillarCircle(serverLevel, (Entity)livingEntity, livingEntity.m_20097_());
/*      */             if (livingEntity.m_21205_().m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianLongPillarShootToward(serverLevel, (Entity)livingEntity);
/*      */             }
/*      */           } 
/*      */         });
/* 4107 */       SUMMON_OBSIDIAN_CROSS = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt385388$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt385388$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt385388$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem || weapon instanceof com.pla.annoyingvillagers.item.ObsidianWeaponItem) {
/*      */               BlockState obsidian;
/*      */               
/*      */               if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } else {
/*      */                 obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */               } 
/*      */               HerobrineUtil.summonObsidianCross(serverLevel, livingEntity, obsidian);
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               if (livingEntity instanceof Player) {
/*      */                 HerobrineUtil.summonShadowObsidianLongPillarDefenseWide(serverLevel, (Entity)livingEntity);
/*      */               }
/*      */             } 
/*      */           } 
/*      */         });
/* 4133 */       SUMMON_OBSIDIAN_CROSS_FIX_DELAY_SHADOW_HEROBRINE = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           Item weapon = livingEntity.m_21205_().m_41720_();
/*      */           Level patt387254$temp = livingEntity.m_9236_();
/*      */           if (patt387254$temp instanceof ServerLevel) {
/*      */             ServerLevel serverLevel = (ServerLevel)patt387254$temp;
/*      */             if (!(livingEntity instanceof Player) && weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               HerobrineUtil.summonShadowObsidianLongPillarDefenseWide(serverLevel, (Entity)livingEntity);
/*      */             }
/*      */           } 
/*      */         });
/* 4144 */       SUMMON_OBSIDIAN_SMALL_CROSS = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt387859$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt387859$temp instanceof ServerLevel) {
/*      */             BlockState obsidian;
/*      */             
/*      */             ServerLevel serverLevel = (ServerLevel)patt387859$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */               obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/*      */               obsidian = (BlockState)((BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player))).m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)livingEntity.m_6350_());
/*      */             } else {
/*      */               obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */             } 
/*      */             
/*      */             HerobrineUtil.summonObsidianSmallCross(serverLevel, livingEntity, obsidian);
/*      */           } 
/*      */         });
/*      */       
/* 4168 */       THROW_OBSIDIAN = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           
/*      */           Level patt389549$temp = livingEntity.m_9236_();
/*      */           
/*      */           if (patt389549$temp instanceof ServerLevel) {
/*      */             BlockState obsidian;
/*      */             
/*      */             ServerLevel serverLevel = (ServerLevel)patt389549$temp;
/*      */             
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */               obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*      */               obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_MIDDLE_PILLAR.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */             } else {
/*      */               obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */             } 
/*      */             LivingEntity attacker = (LivingEntity)livingEntityPatch.getOriginal();
/*      */             Vec3 to = attacker.m_146892_().m_82549_(attacker.m_20154_().m_82490_(16.0D));
/*      */             if (attacker instanceof Mob) {
/*      */               Mob mob = (Mob)attacker;
/*      */               if (mob.m_5448_() != null) {
/*      */                 to = mob.m_5448_().m_20299_(1.0F);
/*      */               }
/*      */             } 
/*      */             BlockProjectileEntity throwingObsidian = new BlockProjectileEntity(attacker.m_9236_(), attacker, obsidian);
/*      */             serverLevel.m_7967_((Entity)throwingObsidian);
/*      */             Vec3 dir = to.m_82546_(throwingObsidian.m_20182_());
/*      */             if (dir.m_82556_() < 1.0E-6D) {
/*      */               dir = attacker.m_20154_();
/*      */             }
/*      */             Vec3 vel = dir.m_82541_().m_82490_(2.0D);
/*      */             throwingObsidian.m_20256_(vel);
/*      */           } 
/*      */         });
/* 4205 */       THROW_OBSIDIAN_OFFHAND = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*      */           Level patt392023$temp = livingEntity.m_9236_();
/*      */           if (patt392023$temp instanceof ServerLevel) {
/*      */             BlockState obsidian;
/*      */             ServerLevel serverLevel = (ServerLevel)patt392023$temp;
/*      */             Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)livingEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).toolL, 2.0F, 0.0D);
/*      */             Item weapon = livingEntity.m_21205_().m_41720_();
/*      */             if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/*      */               obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */             } else if (weapon instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*      */               obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_MIDDLE_PILLAR.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */             } else {
/*      */               obsidian = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(livingEntity instanceof Player));
/*      */             } 
/*      */             LivingEntity attacker = (LivingEntity)livingEntityPatch.getOriginal();
/*      */             Vec3 to = attacker.m_146892_().m_82549_(attacker.m_20154_().m_82490_(16.0D));
/*      */             if (attacker instanceof Mob) {
/*      */               Mob mob = (Mob)attacker;
/*      */               if (mob.m_5448_() != null) {
/*      */                 to = mob.m_5448_().m_20299_(1.0F);
/*      */               }
/*      */             } 
/*      */             BlockProjectileEntity throwingObsidian = new BlockProjectileEntity(attacker.m_9236_(), attacker, obsidian);
/*      */             serverLevel.m_7967_((Entity)throwingObsidian);
/*      */             if (jointVec != null) {
/*      */               throwingObsidian.m_20219_(jointVec);
/*      */             }
/*      */             Vec3 dir = to.m_82546_(throwingObsidian.m_20182_());
/*      */             if (dir.m_82556_() < 1.0E-6D) {
/*      */               dir = attacker.m_20154_();
/*      */             }
/*      */             Vec3 vel = dir.m_82541_().m_82490_(2.0D);
/*      */             throwingObsidian.m_20256_(vel);
/*      */           } 
/*      */         });
/*      */     }
/*      */ 
/*      */     
/*      */     public static final AnimationEvent.E0 FAST_SPINNING;
/*      */     
/*      */     public static final AnimationEvent.E0 TRIDENT_SPINNING;
/*      */     
/*      */     public static final AnimationEvent.E0 PLAY_TRIDENT_EFFECT_HAND_LEFT;
/*      */     
/*      */     public static final AnimationEvent.E0 PLAY_TRIDENT_EFFECT_WEAPON_RIGHT;
/*      */     
/*      */     public static final AnimationEvent.E0 PLAY_TRIDENT_EFFECT_HAND_RIGHT;
/*      */     public static final AnimationEvent.E0 THROW_TRIDENT_HAND_LEFT;
/*      */     public static final AnimationEvent.E0 THROW_TRIDENT_HAND_RIGHT;
/*      */     public static final AnimationEvent.E0 THROW_TRIDENT_HAND_LEFT_LIGHTNING;
/*      */     public static final AnimationEvent.E0 THROW_TRIDENT_HAND_RIGHT_LIGHTNING;
/*      */     public static final AnimationEvent.E0 THROW_TRIDENT_HAND_RIGHT_EXPLODE;
/*      */     public static final AnimationEvent.E0 SUMMON_2_OBSIDIAN_LEG_RIGHT;
/*      */     public static final AnimationEvent.E0 SUMMON_2_OBSIDIAN_LEG_LEFT;
/*      */     public static final AnimationEvent.E0 SUMMON_2_OBSIDIAN_HAND_RIGHT;
/*      */     public static final AnimationEvent.E0 SUMMON_2_OBSIDIAN_HAND_LEFT;
/*      */     public static final AnimationEvent.E0 SUMMON_3_OBSIDIAN_HAND_LEFT;
/*      */     public static final AnimationEvent.E0 SUMMON_6_OBSIDIAN_HAND_LEFT;
/*      */     public static final AnimationEvent.E0 SUMMON_6_OBSIDIAN_HAND_RIGHT;
/*      */     public static final AnimationEvent.E0 SUMMON_6_OBSIDIAN_LEG_RIGHT;
/*      */     public static final AnimationEvent.E0 SUMMON_OBSIDIAN_PILLAR;
/*      */     public static final AnimationEvent.E0 SUMMON_OBSIDIAN_WALL;
/*      */     public static final AnimationEvent.E0 SUMMON_OBSIDIAN_CIRCLE;
/*      */     public static final AnimationEvent.E0 SUMMON_OBSIDIAN_CROSS;
/*      */     public static final AnimationEvent.E0 SUMMON_OBSIDIAN_CROSS_FIX_DELAY_SHADOW_HEROBRINE;
/*      */     public static final AnimationEvent.E0 SUMMON_OBSIDIAN_SMALL_CROSS;
/*      */     public static final AnimationEvent.E0 THROW_OBSIDIAN;
/*      */     public static final AnimationEvent.E0 THROW_OBSIDIAN_OFFHAND;
/*      */     public static final AnimationEvent.E0 SLEDGEHAMMER_SHOOT = (livingEntityPatch, staticAnimation, object) -> {
/*      */         // Byte code:
/*      */         //   0: aload_0
/*      */         //   1: invokevirtual getOriginal : ()Lnet/minecraft/world/entity/Entity;
/*      */         //   4: checkcast net/minecraft/world/entity/LivingEntity
/*      */         //   7: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*      */         //   10: astore #4
/*      */         //   12: aload #4
/*      */         //   14: instanceof net/minecraft/server/level/ServerLevel
/*      */         //   17: ifeq -> 284
/*      */         //   20: aload #4
/*      */         //   22: checkcast net/minecraft/server/level/ServerLevel
/*      */         //   25: astore_3
/*      */         //   26: aload_0
/*      */         //   27: invokevirtual getOriginal : ()Lnet/minecraft/world/entity/Entity;
/*      */         //   30: checkcast net/minecraft/world/entity/LivingEntity
/*      */         //   33: astore #4
/*      */         //   35: aconst_null
/*      */         //   36: astore #5
/*      */         //   38: aload #4
/*      */         //   40: instanceof net/minecraft/world/entity/Mob
/*      */         //   43: ifeq -> 75
/*      */         //   46: aload #4
/*      */         //   48: checkcast net/minecraft/world/entity/Mob
/*      */         //   51: astore #6
/*      */         //   53: aload #6
/*      */         //   55: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*      */         //   58: ifnull -> 75
/*      */         //   61: aload #6
/*      */         //   63: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*      */         //   66: fconst_1
/*      */         //   67: invokevirtual m_20299_ : (F)Lnet/minecraft/world/phys/Vec3;
/*      */         //   70: astore #5
/*      */         //   72: goto -> 124
/*      */         //   75: aload #4
/*      */         //   77: instanceof net/minecraft/world/entity/player/Player
/*      */         //   80: ifeq -> 124
/*      */         //   83: aload #4
/*      */         //   85: checkcast net/minecraft/world/entity/player/Player
/*      */         //   88: astore #7
/*      */         //   90: aload #7
/*      */         //   92: fconst_1
/*      */         //   93: invokevirtual m_20299_ : (F)Lnet/minecraft/world/phys/Vec3;
/*      */         //   96: astore #8
/*      */         //   98: aload #7
/*      */         //   100: invokevirtual m_20154_ : ()Lnet/minecraft/world/phys/Vec3;
/*      */         //   103: astore #9
/*      */         //   105: ldc2_w 64.0
/*      */         //   108: dstore #10
/*      */         //   110: aload #8
/*      */         //   112: aload #9
/*      */         //   114: dload #10
/*      */         //   116: invokevirtual m_82490_ : (D)Lnet/minecraft/world/phys/Vec3;
/*      */         //   119: invokevirtual m_82549_ : (Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;
/*      */         //   122: astore #5
/*      */         //   124: new com/pla/annoyingvillagers/entity/ObsidianSledgehammerProjectileEntity
/*      */         //   127: dup
/*      */         //   128: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModEntities.OBSIDIAN_SLEDGEHAMMER_PROJECTILE : Lnet/minecraftforge/registries/RegistryObject;
/*      */         //   131: invokevirtual get : ()Ljava/lang/Object;
/*      */         //   134: checkcast net/minecraft/world/entity/EntityType
/*      */         //   137: aload_3
/*      */         //   138: invokespecial <init> : (Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V
/*      */         //   141: astore #6
/*      */         //   143: aload_0
/*      */         //   144: invokevirtual getOriginal : ()Lnet/minecraft/world/entity/Entity;
/*      */         //   147: new yesman/epicfight/api/utils/math/Vec3f
/*      */         //   150: dup
/*      */         //   151: fconst_0
/*      */         //   152: fconst_0
/*      */         //   153: fconst_0
/*      */         //   154: invokespecial <init> : (FFF)V
/*      */         //   157: getstatic yesman/epicfight/gameasset/Armatures.BIPED : Lyesman/epicfight/gameasset/Armatures$ArmatureAccessor;
/*      */         //   160: invokevirtual get : ()Lyesman/epicfight/api/model/Armature;
/*      */         //   163: checkcast yesman/epicfight/model/armature/HumanoidArmature
/*      */         //   166: getfield toolR : Lyesman/epicfight/api/animation/Joint;
/*      */         //   169: fconst_1
/*      */         //   170: dconst_0
/*      */         //   171: invokestatic getJointWithTranslation : (Lnet/minecraft/world/entity/Entity;Lyesman/epicfight/api/utils/math/Vec3f;Lyesman/epicfight/api/animation/Joint;FD)Lnet/minecraft/world/phys/Vec3;
/*      */         //   174: astore #7
/*      */         //   176: aload #7
/*      */         //   178: ifnull -> 284
/*      */         //   181: aload #5
/*      */         //   183: ifnull -> 284
/*      */         //   186: aload #6
/*      */         //   188: aload #7
/*      */         //   190: getfield f_82479_ : D
/*      */         //   193: aload #7
/*      */         //   195: getfield f_82480_ : D
/*      */         //   198: aload #7
/*      */         //   200: getfield f_82481_ : D
/*      */         //   203: fconst_0
/*      */         //   204: fconst_0
/*      */         //   205: invokevirtual m_7678_ : (DDDFF)V
/*      */         //   208: aload #6
/*      */         //   210: new net/minecraft/world/phys/Vec3
/*      */         //   213: dup
/*      */         //   214: aload #5
/*      */         //   216: getfield f_82479_ : D
/*      */         //   219: aload #5
/*      */         //   221: getfield f_82480_ : D
/*      */         //   224: aload #5
/*      */         //   226: getfield f_82481_ : D
/*      */         //   229: invokespecial <init> : (DDD)V
/*      */         //   232: invokevirtual setPosToAim : (Lnet/minecraft/world/phys/Vec3;)V
/*      */         //   235: aload #6
/*      */         //   237: iconst_1
/*      */         //   238: invokevirtual m_20331_ : (Z)V
/*      */         //   241: aload #6
/*      */         //   243: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModSounds.METAL_HIT : Lnet/minecraftforge/registries/RegistryObject;
/*      */         //   246: invokevirtual get : ()Ljava/lang/Object;
/*      */         //   249: checkcast net/minecraft/sounds/SoundEvent
/*      */         //   252: fconst_1
/*      */         //   253: fconst_1
/*      */         //   254: invokevirtual m_5496_ : (Lnet/minecraft/sounds/SoundEvent;FF)V
/*      */         //   257: aload #6
/*      */         //   259: aload #4
/*      */         //   261: invokevirtual setOwner : (Lnet/minecraft/world/entity/LivingEntity;)V
/*      */         //   264: aload_1
/*      */         //   265: getstatic com/pla/annoyingvillagers/gameasset/AVAnimations.SLEDGEHAMMER_SOLAR_AUTO_3 : Lyesman/epicfight/api/animation/AnimationManager$AnimationAccessor;
/*      */         //   268: if_acmpne -> 277
/*      */         //   271: aload #6
/*      */         //   273: iconst_1
/*      */         //   274: invokevirtual setShouldStun : (Z)V
/*      */         //   277: aload_3
/*      */         //   278: aload #6
/*      */         //   280: invokevirtual m_7967_ : (Lnet/minecraft/world/entity/Entity;)Z
/*      */         //   283: pop
/*      */         //   284: return
/*      */         // Line number table:
/*      */         //   Java source line number -> byte code offset
/*      */         //   #4251	-> 0
/*      */         //   #4252	-> 26
/*      */         //   #4254	-> 35
/*      */         //   #4256	-> 38
/*      */         //   #4257	-> 61
/*      */         //   #4258	-> 75
/*      */         //   #4259	-> 90
/*      */         //   #4260	-> 98
/*      */         //   #4261	-> 105
/*      */         //   #4262	-> 110
/*      */         //   #4265	-> 124
/*      */         //   #4266	-> 143
/*      */         //   #4267	-> 160
/*      */         //   #4266	-> 171
/*      */         //   #4268	-> 176
/*      */         //   #4269	-> 186
/*      */         //   #4270	-> 208
/*      */         //   #4271	-> 235
/*      */         //   #4272	-> 241
/*      */         //   #4273	-> 257
/*      */         //   #4274	-> 264
/*      */         //   #4275	-> 271
/*      */         //   #4277	-> 277
/*      */         //   #4280	-> 284
/*      */         // Local variable table:
/*      */         //   start	length	slot	name	descriptor
/*      */         //   12	14	4	patt394818$temp	Lnet/minecraft/world/level/Level;
/*      */         //   53	22	6	mob	Lnet/minecraft/world/entity/Mob;
/*      */         //   98	26	8	playerEyePosition	Lnet/minecraft/world/phys/Vec3;
/*      */         //   105	19	9	playerLookDirection	Lnet/minecraft/world/phys/Vec3;
/*      */         //   110	14	10	aimDistance	D
/*      */         //   90	34	7	player	Lnet/minecraft/world/entity/player/Player;
/*      */         //   35	249	4	shooterEntity	Lnet/minecraft/world/entity/LivingEntity;
/*      */         //   38	246	5	aimPosition	Lnet/minecraft/world/phys/Vec3;
/*      */         //   143	141	6	obsidianSledgehammerProjectileEntity	Lcom/pla/annoyingvillagers/entity/ObsidianSledgehammerProjectileEntity;
/*      */         //   176	108	7	hammerPos	Lnet/minecraft/world/phys/Vec3;
/*      */         //   26	258	3	serverLevel	Lnet/minecraft/server/level/ServerLevel;
/*      */         //   0	285	0	livingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;
/*      */         //   0	285	1	staticAnimation	Lyesman/epicfight/api/asset/AssetAccessor;
/*      */         //   0	285	2	object	Lyesman/epicfight/api/animation/property/AnimationParameters;
/*      */       };
/*      */     public static final AnimationEvent.E0 SHOCK_WAVE;
/*      */     public static final AnimationEvent.E0 END_ATTACK;
/*      */     
/*      */     static {
/* 4281 */       SHOCK_WAVE = ((livingEntityPatch, staticAnimation, object) -> {
/*      */           Vec3 legendarySwordPos = EpicfightUtil.getJointWithTranslation(livingEntityPatch.getOriginal(), new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).toolR, 1.5F, 0.0D);
/*      */           int MAX_SHOCKWAVE_RADIUS = 6;
/*      */           int TICKS_BETWEEN_LAYERS = 2;
/*      */           for (int radius = 1; radius <= 6; radius++) {
/*      */             int delayTicks = (radius - 1) * 2;
/*      */             final int ringRadius = radius;
/*      */             if (legendarySwordPos == null) {
/*      */               return;
/*      */             }
/*      */             final BlockPos finalVec = BlockPos.m_274446_((Position)legendarySwordPos);
/*      */             new DelayedTask(delayTicks)
/*      */               {
/*      */                 public void run()
/*      */                 {
/* 4296 */                   ShockwaveUtil.spawnCircleRing((ServerLevel)((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), finalVec, ringRadius, (LivingEntity)livingEntityPatch.getOriginal());
/*      */                 }
/*      */               };
/*      */           } 
/*      */         });
/*      */       
/* 4302 */       END_ATTACK = ((livingentitypatch, staticAnimation, object) -> {
/*      */           if (livingentitypatch instanceof yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch) {
/*      */             livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.DUAL_END, 0.1F);
/*      */           }
/*      */         });
/*      */     }
/*      */     
/*      */     public static Vec3 getFloor(LivingEntityPatch<?> livingentitypatch, Vec3f vec3f, Joint joint) {
/* 4310 */       OpenMatrix4f openmatrix4f = livingentitypatch.getArmature().getBoundTransformFor(livingentitypatch.getAnimator().getPose(1.0F), joint);
/*      */       
/* 4312 */       openmatrix4f.translate(vec3f);
/* 4313 */       OpenMatrix4f openMatrix4f1 = (new OpenMatrix4f()).rotate(-((float)Math.toRadians((((LivingEntity)livingentitypatch.getOriginal()).f_19859_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F));
/*      */       
/* 4315 */       OpenMatrix4f.mul(openMatrix4f1, openmatrix4f, openmatrix4f);
/* 4316 */       float f = openmatrix4f.m30 + (float)((LivingEntity)livingentitypatch.getOriginal()).m_20185_();
/* 4317 */       float f1 = openmatrix4f.m31 + (float)((LivingEntity)livingentitypatch.getOriginal()).m_20186_();
/* 4318 */       float f2 = openmatrix4f.m32 + (float)((LivingEntity)livingentitypatch.getOriginal()).m_20189_();
/*      */       
/* 4320 */       for (BlockState blockstate = ((LivingEntity)livingentitypatch.getOriginal()).m_9236_().m_8055_(new BlockPos(new Vec3i((int)f, (int)f1, (int)f2))); (blockstate.m_60734_() instanceof net.minecraft.world.level.block.BushBlock || blockstate.m_60795_()) && !blockstate.m_60713_(Blocks.f_50626_); blockstate = ((LivingEntity)livingentitypatch.getOriginal()).m_9236_().m_8055_(new BlockPos(new Vec3i((int)f, (int)f1, (int)f2)))) {
/* 4321 */         f1--;
/*      */       }
/*      */       
/* 4324 */       return new Vec3(f, f1, f2);
/*      */     } }
/*      */ 
/*      */   
/*      */   class null extends DelayedTask {
/*      */     null(int waitTicks) {
/*      */       super(waitTicks);
/*      */     }
/*      */     
/*      */     public void run() {
/*      */       ShockwaveUtil.spawnCircleRing((ServerLevel)((LivingEntity)livingEntityPatch.getOriginal()).m_9236_(), finalVec, ringRadius, (LivingEntity)livingEntityPatch.getOriginal());
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\gameasset\AVAnimations.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */