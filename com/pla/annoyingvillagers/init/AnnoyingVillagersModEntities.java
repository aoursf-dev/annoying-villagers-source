/*     */ package com.pla.annoyingvillagers.init;
/*     */ import com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity;
/*     */ import com.pla.annoyingvillagers.entity.ChrisEntity;
/*     */ import com.pla.annoyingvillagers.entity.Herobrine7Entity;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineCloneEntity;
/*     */ import com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity;
/*     */ import com.pla.annoyingvillagers.entity.RedVillagerGeneralEntity;
/*     */ import com.pla.annoyingvillagers.entity.VillagerScoutCaptainEntity;
/*     */ import com.pla.annoyingvillagers.entity.VillagerScoutEntity;
/*     */ import java.util.function.BiFunction;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.MobCategory;
/*     */ import net.minecraft.world.entity.SpawnPlacements;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
/*     */ import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.registries.RegistryObject;
/*     */ import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
/*     */ 
/*     */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
/*     */ public class AnnoyingVillagersModEntities {
/*  25 */   public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "annoyingvillagers");
/*  26 */   public static final RegistryObject<EntityType<BlueDemonEntity>> BLUE_DEMON = register("blue_demon", EntityType.Builder.m_20704_(BlueDemonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(126).setUpdateInterval(3).setCustomClientFactory(BlueDemonEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*     */   
/*  28 */   public static final RegistryObject<EntityType<VillagerScoutCaptainEntity>> VILLAGER_SCOUT_CAPTAIN = register("villager_scout_captain", EntityType.Builder.m_20704_(VillagerScoutCaptainEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(VillagerScoutCaptainEntity::new).m_20699_(0.6F, 1.8F));
/*  29 */   public static final RegistryObject<EntityType<VillagerScoutEntity>> VILLAGER_SCOUT = register("villager_scout", EntityType.Builder.m_20704_(VillagerScoutEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VillagerScoutEntity::new).m_20699_(0.6F, 1.8F));
/*  30 */   public static final RegistryObject<EntityType<BlueVillagerGeneralEntity>> BLUE_VILLAGER_GENERAL = register("blue_villager_general", EntityType.Builder.m_20704_(BlueVillagerGeneralEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(BlueVillagerGeneralEntity::new).m_20699_(0.6F, 1.8F));
/*  31 */   public static final RegistryObject<EntityType<PurpleVillagerGeneralEntity>> GREEN_VILLAGER_GENERAL = register("green_villager_general", EntityType.Builder.m_20704_(PurpleVillagerGeneralEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(PurpleVillagerGeneralEntity::new).m_20699_(0.6F, 1.8F));
/*  32 */   public static final RegistryObject<EntityType<RedVillagerGeneralEntity>> RED_VILLAGER_GENERAL = register("red_villager_general", EntityType.Builder.m_20704_(RedVillagerGeneralEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(RedVillagerGeneralEntity::new).m_20699_(0.6F, 1.8F));
/*  33 */   public static final RegistryObject<EntityType<GreenVillagerGeneralEntity>> PURPLE_VILLAGER_GENERAL = register("purple_villager_general", EntityType.Builder.m_20704_(GreenVillagerGeneralEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(GreenVillagerGeneralEntity::new).m_20699_(0.6F, 1.8F));
/*     */   
/*  35 */   public static final RegistryObject<EntityType<AlexEntity>> ALEX = register("alex", EntityType.Builder.m_20704_(AlexEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(AlexEntity::new).m_20699_(0.6F, 1.8F));
/*  36 */   public static final RegistryObject<EntityType<JevEntity>> JEV = register("jev", EntityType.Builder.m_20704_(JevEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(JevEntity::new).m_20699_(0.6F, 1.8F));
/*  37 */   public static final RegistryObject<EntityType<BbqEntity>> BBQ = register("bbq", EntityType.Builder.m_20704_(BbqEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(BbqEntity::new).m_20699_(0.4F, 0.7F));
/*  38 */   public static final RegistryObject<EntityType<ChrisEntity>> CHRIS = register("chris", EntityType.Builder.m_20704_(ChrisEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(ChrisEntity::new).m_20699_(0.6F, 1.8F));
/*  39 */   public static final RegistryObject<EntityType<SteveEntity>> STEVE = register("steve", EntityType.Builder.m_20704_(SteveEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(SteveEntity::new).m_20699_(0.6F, 1.8F));
/*  40 */   public static final RegistryObject<EntityType<AngrySteveEntity>> ANGRY_STEVE = register("angry_steve", EntityType.Builder.m_20704_(AngrySteveEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(AngrySteveEntity::new).m_20699_(0.6F, 1.8F));
/*  41 */   public static final RegistryObject<EntityType<PlayerNpcEntity>> PLAYER_NPC = register("player_npc", EntityType.Builder.m_20704_(PlayerNpcEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(PlayerNpcEntity::new).m_20699_(0.6F, 1.8F));
/*     */   
/*  43 */   public static final RegistryObject<EntityType<InfectedTheMostMoistBurrit0Entity>> INFECTED_THEMOSTMOISTBURRIT0 = register("infected_the_most_moist_burrit0", EntityType.Builder.m_20704_(InfectedTheMostMoistBurrit0Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InfectedTheMostMoistBurrit0Entity::new).m_20699_(0.6F, 1.8F));
/*  44 */   public static final RegistryObject<EntityType<InfectedPlayerNpcEntity>> INFECTED_PLAYER_NPC = register("infected_player_npc", EntityType.Builder.m_20704_(InfectedPlayerNpcEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InfectedPlayerNpcEntity::new).m_20699_(0.6F, 1.8F));
/*  45 */   public static final RegistryObject<EntityType<InfectedChrisEntity>> INJECTED_CHRIS = register("infected_chris", EntityType.Builder.m_20704_(InfectedChrisEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InfectedChrisEntity::new).m_20699_(0.6F, 1.8F));
/*     */   
/*  47 */   public static final RegistryObject<EntityType<EnderAegisProjectile>> ENDER_AEGIS_PROJECTILE = register("ender_aegis_projectile", EntityType.Builder.m_20704_(EnderAegisProjectile::new, MobCategory.MISC).setCustomClientFactory(EnderAegisProjectile::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).m_20699_(0.5F, 0.5F));
/*  48 */   public static final RegistryObject<EntityType<EnchantedEnderPearlEntity>> ENCHANTED_ENDER_PEARL_PROJECTILE = register("projectile_enchanted_ender_pearl", EntityType.Builder.m_20704_(EnchantedEnderPearlEntity::new, MobCategory.MISC).setCustomClientFactory(EnchantedEnderPearlEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).m_20699_(0.5F, 0.5F));
/*  49 */   public static final RegistryObject<EntityType<ThrownPoisonEggEntity>> THROWN_POISON_EGG = register("thrown_poison_egg", EntityType.Builder.m_20704_(ThrownPoisonEggEntity::new, MobCategory.MISC).setCustomClientFactory(ThrownPoisonEggEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).m_20699_(0.5F, 0.5F));
/*     */   
/*  51 */   public static final RegistryObject<EntityType<HerobrineCloneEntity>> HEROBRINE_CLONE = register("herobrine_clone", EntityType.Builder.m_20704_(HerobrineCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HerobrineCloneEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  52 */   public static final RegistryObject<EntityType<ShadowHerobrineCloneEntity>> SHADOW_HEROBRINE_CLONE = register("shadow_herobrine_clone", EntityType.Builder.m_20704_(ShadowHerobrineCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShadowHerobrineCloneEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  53 */   public static final RegistryObject<EntityType<HerobrineChrisEntity>> HEROBRINE_CHRIS = register("herobrine_chris", EntityType.Builder.m_20704_(HerobrineChrisEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(HerobrineChrisEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  54 */   public static final RegistryObject<EntityType<HerobrineGregEntity>> HEROBRINE_GREG = register("herobrine_greg", EntityType.Builder.m_20704_(HerobrineGregEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(HerobrineGregEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  55 */   public static final RegistryObject<EntityType<LowHerobrineCloneEntity>> LOW_HEROBRINE_CLONE = register("low_herobrine_clone", EntityType.Builder.m_20704_(LowHerobrineCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(LowHerobrineCloneEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  56 */   public static final RegistryObject<EntityType<LowShadowHerobrineCloneEntity>> LOW_SHADOW_HEROBRINE_CLONE = register("low_shadow_herobrine_clone", EntityType.Builder.m_20704_(LowShadowHerobrineCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(LowShadowHerobrineCloneEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  57 */   public static final RegistryObject<EntityType<Herobrine7Entity>> HEROBRINE_7 = register("herobrine_7", EntityType.Builder.m_20704_(Herobrine7Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(Herobrine7Entity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  58 */   public static final RegistryObject<EntityType<ArmoredHerobrineEntity>> ARMORED_HEROBRINE = register("armored_herobrine", EntityType.Builder.m_20704_(ArmoredHerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(ArmoredHerobrineEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  59 */   public static final RegistryObject<EntityType<ShadowHerobrineEntity>> SHADOW_HEROBRINE = register("shadow_herobrine", EntityType.Builder.m_20704_(ShadowHerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(ShadowHerobrineEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  60 */   public static final RegistryObject<EntityType<GlaiveHerobrineEntity>> GLAIVE_HEROBRINE = register("glaive_herobrine", EntityType.Builder.m_20704_(GlaiveHerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(GlaiveHerobrineEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  61 */   public static final RegistryObject<EntityType<ReaperHerobrineEntity>> REAPER_HEROBRINE = register("reaper_herobrine", EntityType.Builder.m_20704_(ReaperHerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(ReaperHerobrineEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  62 */   public static final RegistryObject<EntityType<SwordsmanHerobrineEntity>> SWORDSMAN_HEROBRINE = register("swordsman_herobrine", EntityType.Builder.m_20704_(SwordsmanHerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(SwordsmanHerobrineEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  63 */   public static final RegistryObject<EntityType<SledgehammerHerobrineEntity>> SLEDGEHAMMER_HEROBRINE = register("sledgehammer_herobrine", EntityType.Builder.m_20704_(SledgehammerHerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(SledgehammerHerobrineEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  64 */   public static final RegistryObject<EntityType<AegisHerobrineEntity>> AEGIS_HEROBRINE = register("aegis_herobrine", EntityType.Builder.m_20704_(AegisHerobrineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(AegisHerobrineEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  65 */   public static final RegistryObject<EntityType<EliteHerobrineKnockedEntity>> ELITE_HEROBRINE_KNOCKED = register("elite_herobrine_knocked", EntityType.Builder.m_20704_(EliteHerobrineKnockedEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(EliteHerobrineKnockedEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  66 */   public static final RegistryObject<EntityType<NullEntity>> NULL = register("null", EntityType.Builder.m_20704_(NullEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(NullEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  67 */   public static final RegistryObject<EntityType<NullSwordEntity>> NULL_SWORD = register("null_sword", EntityType.Builder.m_20704_(NullSwordEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(NullSwordEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  68 */   public static final RegistryObject<EntityType<NullAxeEntity>> NULL_AXE = register("null_axe", EntityType.Builder.m_20704_(NullAxeEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(NullAxeEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  69 */   public static final RegistryObject<EntityType<NullPickaxeEntity>> NULL_PICKAXE = register("null_pickaxe", EntityType.Builder.m_20704_(NullPickaxeEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(NullPickaxeEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  70 */   public static final RegistryObject<EntityType<NullShovelEntity>> NULL_SHOVEL = register("null_shovel", EntityType.Builder.m_20704_(NullShovelEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(NullShovelEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  71 */   public static final RegistryObject<EntityType<NullHoeEntity>> NULL_HOE = register("null_hoe", EntityType.Builder.m_20704_(NullHoeEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(NullHoeEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*  72 */   public static final RegistryObject<EntityType<HerobrineWardenEntity>> HEROBRINE_WARDEN = register("herobrine_warden", EntityType.Builder.m_20704_(HerobrineWardenEntity::new, MobCategory.MONSTER).m_20699_(0.9F, 2.9F).m_20702_(16).m_20719_());
/*  73 */   public static final RegistryObject<EntityType<NullSkeletonEntity>> NULL_SKELETON = register("null_skeleton", EntityType.Builder.m_20704_(NullSkeletonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(NullSkeletonEntity::new).m_20719_().m_20699_(0.6F, 1.8F));
/*     */   
/*  75 */   public static final RegistryObject<EntityType<SnakeBladeEntity>> SNAKE_BLADE = register("snake_blade", EntityType.Builder.m_20704_(SnakeBladeEntity::new, MobCategory.MISC).m_20699_(0.1F, 0.1F));
/*  76 */   public static final RegistryObject<EntityType<DragonBeamEntity>> DRAGON_BEAM = register("dragon_beam", EntityType.Builder.m_20704_(DragonBeamEntity::new, MobCategory.MISC).m_20699_(0.5F, 0.5F).m_20702_(4).m_20717_(20));
/*  77 */   public static final RegistryObject<EntityType<BlockProjectileEntity>> BLOCK_PROJECTILE = register("block_projectile", EntityType.Builder.m_20704_(BlockProjectileEntity::new, MobCategory.MISC).m_20699_(0.9F, 0.9F).m_20702_(64).m_20717_(2).m_20719_());
/*  78 */   public static final RegistryObject<EntityType<HerobrineDragonEntity>> HEROBRINE_DRAGON = register("herobrine_dragon", EntityType.Builder.m_20704_(HerobrineDragonEntity::new, MobCategory.CREATURE).m_20699_(2.75F, 2.75F).m_20702_(10).m_20717_(3));
/*  79 */   public static final RegistryObject<EntityType<DragonMeteoriteEntity>> DRAGON_METEORITE = register("dragon_meteorite", EntityType.Builder.m_20704_(DragonMeteoriteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(2000).setUpdateInterval(3).setCustomClientFactory(DragonMeteoriteEntity::new).m_20719_().m_20699_(1.0F, 1.0F));
/*  80 */   public static final RegistryObject<EntityType<ObsidianSledgehammerProjectileEntity>> OBSIDIAN_SLEDGEHAMMER_PROJECTILE = register("obsidian_sledgehammer_projectile", EntityType.Builder.m_20704_(ObsidianSledgehammerProjectileEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(2000).setUpdateInterval(3).setCustomClientFactory(ObsidianSledgehammerProjectileEntity::new).m_20719_().m_20699_(1.0F, 1.0F));
/*  81 */   public static final RegistryObject<EntityType<ShockWaveBlockEntity>> SHOCKWAVE_BLOCK = register("shockwave_block", EntityType.Builder.m_20704_(ShockWaveBlockEntity::new, MobCategory.MISC).setTrackingRange(10).setUpdateInterval(20).m_20719_().m_20699_(0.98F, 0.98F));
/*  82 */   public static final RegistryObject<EntityType<BlueDemonThunderBeamEntity>> BLUE_DEMON_THUNDER_BEAM = register("blue_demon_thunder_beam", EntityType.Builder.m_20704_(BlueDemonThunderBeamEntity::new, MobCategory.MISC).m_20699_(0.5F, 0.5F).m_20702_(4).m_20717_(20));
/*  83 */   public static final RegistryObject<EntityType<TridentLightningBolt>> TRIDENT_LIGHTNING_BOLT = register("trident_lightning_bolt", EntityType.Builder.m_20704_(TridentLightningBolt::new, MobCategory.MISC).m_20716_().m_20699_(0.0F, 0.0F).m_20702_(16).m_20717_(2147483647));
/*  84 */   public static final RegistryObject<EntityType<BlueDemonThrownTridentEntity>> BLUE_DEMON_THROWN_TRIDENT = register("blue_demon_thrown_trident", EntityType.Builder.m_20704_(BlueDemonThrownTridentEntity::new, MobCategory.MISC).m_20699_(0.5F, 0.5F).m_20702_(4).m_20717_(20));
/*  85 */   public static final RegistryObject<EntityType<ElectricAreaEntity>> ELECTRIC_AREA = REGISTRY.register("electric_area", () -> EntityType.Builder.m_20704_(ElectricAreaEntity::new, MobCategory.MISC).m_20699_(0.1F, 0.1F).m_20702_(8).m_20717_(10).m_20712_("blue_demon_area_damage_zone"));
/*  86 */   public static final RegistryObject<EntityType<EnchantedArrowEntity>> ENCHANTED_ARROW = register("enchanted_arrow", EntityType.Builder.m_20704_(EnchantedArrowEntity::new, MobCategory.MISC).m_20699_(0.5F, 0.5F).m_20702_(4).m_20717_(20));
/*     */ 
/*     */   
/*     */   private static <T extends Entity> RegistryObject<EntityType<T>> register(String s, EntityType.Builder<T> builder) {
/*  90 */     return REGISTRY.register(s, () -> builder.m_20712_(s));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
/*  97 */     event.register((EntityType)HEROBRINE_CLONE
/*  98 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HerobrineCloneEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     event.register((EntityType)SHADOW_HEROBRINE_CLONE
/* 105 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShadowHerobrineCloneEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     event.register((EntityType)HEROBRINE_CHRIS
/* 112 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HerobrineChrisEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     event.register((EntityType)HEROBRINE_GREG
/* 119 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HerobrineGregEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     event.register((EntityType)LOW_SHADOW_HEROBRINE_CLONE
/* 126 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LowShadowHerobrineCloneEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     event.register((EntityType)HEROBRINE_7
/* 133 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Herobrine7Entity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     event.register((EntityType)HEROBRINE_7
/* 140 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Herobrine7Entity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     event.register((EntityType)ARMORED_HEROBRINE
/* 147 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ArmoredHerobrineEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     event.register((EntityType)BLUE_DEMON
/* 154 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlueDemonEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     event.register((EntityType)STEVE
/* 161 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SteveEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     event.register((EntityType)ALEX
/* 168 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AlexEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     event.register((EntityType)CHRIS
/* 175 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ChrisEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     event.register((EntityType)PLAYER_NPC
/* 182 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PlayerNpcEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     event.register((EntityType)VILLAGER_SCOUT
/* 189 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, VillagerScoutEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     event.register((EntityType)VILLAGER_SCOUT_CAPTAIN
/* 196 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, VillagerScoutCaptainEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     event.register((EntityType)RED_VILLAGER_GENERAL
/* 203 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, RedVillagerGeneralEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 209 */     event.register((EntityType)BLUE_VILLAGER_GENERAL
/* 210 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlueVillagerGeneralEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     event.register((EntityType)PURPLE_VILLAGER_GENERAL
/* 217 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GreenVillagerGeneralEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     event.register((EntityType)GREEN_VILLAGER_GENERAL
/* 224 */         .get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PurpleVillagerGeneralEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void setPatch(EntityPatchRegistryEvent entityPatchRegistryEvent) {
/* 234 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)PLAYER_NPC.get(), entity -> com.pla.annoyingvillagers.mobpatch.PlayerNpcPatch::new);
/* 235 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)VILLAGER_SCOUT.get(), entity -> com.pla.annoyingvillagers.mobpatch.VillagerScoutPatch::new);
/* 236 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)VILLAGER_SCOUT_CAPTAIN.get(), entity -> com.pla.annoyingvillagers.mobpatch.VillagerScoutCaptainPatch::new);
/* 237 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)RED_VILLAGER_GENERAL.get(), entity -> com.pla.annoyingvillagers.mobpatch.VillagerGeneralPatch::new);
/* 238 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)BLUE_VILLAGER_GENERAL.get(), entity -> com.pla.annoyingvillagers.mobpatch.VillagerGeneralPatch::new);
/* 239 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)GREEN_VILLAGER_GENERAL.get(), entity -> com.pla.annoyingvillagers.mobpatch.VillagerGeneralPatch::new);
/* 240 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)PURPLE_VILLAGER_GENERAL.get(), entity -> com.pla.annoyingvillagers.mobpatch.VillagerGeneralPatch::new);
/* 241 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)STEVE.get(), entity -> com.pla.annoyingvillagers.mobpatch.StevePatch::new);
/* 242 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)ANGRY_STEVE.get(), entity -> com.pla.annoyingvillagers.mobpatch.AngryStevePatch::new);
/* 243 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)ALEX.get(), entity -> com.pla.annoyingvillagers.mobpatch.AlexPatch::new);
/* 244 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)JEV.get(), entity -> com.pla.annoyingvillagers.mobpatch.JevPatch::new);
/* 245 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)CHRIS.get(), entity -> com.pla.annoyingvillagers.mobpatch.ChrisPatch::new);
/* 246 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)LOW_HEROBRINE_CLONE.get(), entity -> com.pla.annoyingvillagers.mobpatch.LowHerobrineClonePatch::new);
/* 247 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)LOW_SHADOW_HEROBRINE_CLONE.get(), entity -> com.pla.annoyingvillagers.mobpatch.LowHerobrineClonePatch::new);
/* 248 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)AEGIS_HEROBRINE.get(), entity -> com.pla.annoyingvillagers.mobpatch.AegisHerobrinePatch::new);
/* 249 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)SWORDSMAN_HEROBRINE.get(), entity -> com.pla.annoyingvillagers.mobpatch.SwordsmanHerobrinePatch::new);
/* 250 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)GLAIVE_HEROBRINE.get(), entity -> com.pla.annoyingvillagers.mobpatch.GlaiveHerobrinePatch::new);
/* 251 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)SLEDGEHAMMER_HEROBRINE.get(), entity -> com.pla.annoyingvillagers.mobpatch.SledgehammerHerobrinePatch::new);
/* 252 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)REAPER_HEROBRINE.get(), entity -> com.pla.annoyingvillagers.mobpatch.ReaperHerobrinePatch::new);
/* 253 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)NULL_SWORD.get(), entity -> com.pla.annoyingvillagers.mobpatch.NullWeaponPatch::new);
/* 254 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)NULL_AXE.get(), entity -> com.pla.annoyingvillagers.mobpatch.NullWeaponPatch::new);
/* 255 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)NULL_PICKAXE.get(), entity -> com.pla.annoyingvillagers.mobpatch.NullWeaponPatch::new);
/* 256 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)NULL_SHOVEL.get(), entity -> com.pla.annoyingvillagers.mobpatch.NullWeaponPatch::new);
/* 257 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)NULL_HOE.get(), entity -> com.pla.annoyingvillagers.mobpatch.NullWeaponPatch::new);
/* 258 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)NULL_SKELETON.get(), entity -> com.pla.annoyingvillagers.mobpatch.NullSkeletonPatch::new);
/* 259 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)NULL.get(), entity -> com.pla.annoyingvillagers.mobpatch.NullPatch::new);
/* 260 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)HEROBRINE_CLONE.get(), entity -> com.pla.annoyingvillagers.mobpatch.HerobrineClonePatch::new);
/* 261 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)SHADOW_HEROBRINE_CLONE.get(), entity -> com.pla.annoyingvillagers.mobpatch.ShadowHerobrineClonePatch::new);
/* 262 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)HEROBRINE_CHRIS.get(), entity -> com.pla.annoyingvillagers.mobpatch.HerobrineClonePatch::new);
/* 263 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)ARMORED_HEROBRINE.get(), entity -> com.pla.annoyingvillagers.mobpatch.ArmoredHerobrinePatch::new);
/* 264 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)HEROBRINE_7.get(), entity -> com.pla.annoyingvillagers.mobpatch.HerobrineClonePatch::new);
/* 265 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)SHADOW_HEROBRINE.get(), entity -> com.pla.annoyingvillagers.mobpatch.ShadowHerobrinePatch::new);
/* 266 */     entityPatchRegistryEvent.getTypeEntry().put((EntityType)BLUE_DEMON.get(), entity -> com.pla.annoyingvillagers.mobpatch.BlueDemonPatch::new);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void registerAttributes(EntityAttributeCreationEvent entityAttributeCreationEvent) {
/* 271 */     entityAttributeCreationEvent.put((EntityType)HEROBRINE_CLONE.get(), HerobrineCloneEntity.createAttributes().m_22265_());
/* 272 */     entityAttributeCreationEvent.put((EntityType)BLUE_DEMON.get(), BlueDemonEntity.createAttributes().m_22265_());
/* 273 */     entityAttributeCreationEvent.put((EntityType)SHADOW_HEROBRINE_CLONE.get(), ShadowHerobrineCloneEntity.createAttributes().m_22265_());
/* 274 */     entityAttributeCreationEvent.put((EntityType)HEROBRINE_7.get(), Herobrine7Entity.createAttributes().m_22265_());
/* 275 */     entityAttributeCreationEvent.put((EntityType)VILLAGER_SCOUT_CAPTAIN.get(), VillagerScoutCaptainEntity.createAttributes().m_22265_());
/* 276 */     entityAttributeCreationEvent.put((EntityType)VILLAGER_SCOUT.get(), VillagerScoutEntity.createAttributes().m_22265_());
/* 277 */     entityAttributeCreationEvent.put((EntityType)BLUE_VILLAGER_GENERAL.get(), BlueVillagerGeneralEntity.createAttributes().m_22265_());
/* 278 */     entityAttributeCreationEvent.put((EntityType)GREEN_VILLAGER_GENERAL.get(), PurpleVillagerGeneralEntity.createAttributes().m_22265_());
/* 279 */     entityAttributeCreationEvent.put((EntityType)RED_VILLAGER_GENERAL.get(), RedVillagerGeneralEntity.createAttributes().m_22265_());
/* 280 */     entityAttributeCreationEvent.put((EntityType)PURPLE_VILLAGER_GENERAL.get(), GreenVillagerGeneralEntity.createAttributes().m_22265_());
/* 281 */     entityAttributeCreationEvent.put((EntityType)ALEX.get(), AlexEntity.createAttributes().m_22265_());
/* 282 */     entityAttributeCreationEvent.put((EntityType)JEV.get(), JevEntity.createAttributes().m_22265_());
/* 283 */     entityAttributeCreationEvent.put((EntityType)BBQ.get(), BbqEntity.m_28263_().m_22265_());
/* 284 */     entityAttributeCreationEvent.put((EntityType)CHRIS.get(), ChrisEntity.createAttributes().m_22265_());
/* 285 */     entityAttributeCreationEvent.put((EntityType)INJECTED_CHRIS.get(), InfectedChrisEntity.createAttributes().m_22265_());
/* 286 */     entityAttributeCreationEvent.put((EntityType)HEROBRINE_CHRIS.get(), HerobrineChrisEntity.createAttributes().m_22265_());
/* 287 */     entityAttributeCreationEvent.put((EntityType)ARMORED_HEROBRINE.get(), ArmoredHerobrineEntity.createAttributes().m_22265_());
/* 288 */     entityAttributeCreationEvent.put((EntityType)STEVE.get(), SteveEntity.createAttributes().m_22265_());
/* 289 */     entityAttributeCreationEvent.put((EntityType)ANGRY_STEVE.get(), AngrySteveEntity.createAttributes().m_22265_());
/* 290 */     entityAttributeCreationEvent.put((EntityType)INFECTED_THEMOSTMOISTBURRIT0.get(), InfectedTheMostMoistBurrit0Entity.createAttributes().m_22265_());
/* 291 */     entityAttributeCreationEvent.put((EntityType)SHADOW_HEROBRINE.get(), ShadowHerobrineEntity.createAttributes().m_22265_());
/* 292 */     entityAttributeCreationEvent.put((EntityType)GLAIVE_HEROBRINE.get(), GlaiveHerobrineEntity.createAttributes().m_22265_());
/* 293 */     entityAttributeCreationEvent.put((EntityType)INFECTED_PLAYER_NPC.get(), InfectedPlayerNpcEntity.createAttributes().m_22265_());
/* 294 */     entityAttributeCreationEvent.put((EntityType)REAPER_HEROBRINE.get(), ReaperHerobrineEntity.createAttributes().m_22265_());
/* 295 */     entityAttributeCreationEvent.put((EntityType)SWORDSMAN_HEROBRINE.get(), SwordsmanHerobrineEntity.createAttributes().m_22265_());
/* 296 */     entityAttributeCreationEvent.put((EntityType)SLEDGEHAMMER_HEROBRINE.get(), SledgehammerHerobrineEntity.createAttributes().m_22265_());
/* 297 */     entityAttributeCreationEvent.put((EntityType)AEGIS_HEROBRINE.get(), AegisHerobrineEntity.createAttributes().m_22265_());
/* 298 */     entityAttributeCreationEvent.put((EntityType)ELITE_HEROBRINE_KNOCKED.get(), EliteHerobrineKnockedEntity.createAttributes().m_22265_());
/* 299 */     entityAttributeCreationEvent.put((EntityType)LOW_HEROBRINE_CLONE.get(), LowHerobrineCloneEntity.createAttributes().m_22265_());
/* 300 */     entityAttributeCreationEvent.put((EntityType)LOW_SHADOW_HEROBRINE_CLONE.get(), LowShadowHerobrineCloneEntity.createAttributes().m_22265_());
/* 301 */     entityAttributeCreationEvent.put((EntityType)NULL.get(), NullEntity.createAttributes().m_22265_());
/* 302 */     entityAttributeCreationEvent.put((EntityType)NULL_SWORD.get(), NullSwordEntity.createAttributes().m_22265_());
/* 303 */     entityAttributeCreationEvent.put((EntityType)NULL_AXE.get(), NullAxeEntity.createAttributes().m_22265_());
/* 304 */     entityAttributeCreationEvent.put((EntityType)NULL_PICKAXE.get(), NullPickaxeEntity.createAttributes().m_22265_());
/* 305 */     entityAttributeCreationEvent.put((EntityType)NULL_SHOVEL.get(), NullShovelEntity.createAttributes().m_22265_());
/* 306 */     entityAttributeCreationEvent.put((EntityType)NULL_HOE.get(), NullHoeEntity.createAttributes().m_22265_());
/* 307 */     entityAttributeCreationEvent.put((EntityType)HEROBRINE_GREG.get(), HerobrineGregEntity.createAttributes().m_22265_());
/* 308 */     entityAttributeCreationEvent.put((EntityType)PLAYER_NPC.get(), PlayerNpcEntity.createAttributes().m_22265_());
/* 309 */     entityAttributeCreationEvent.put((EntityType)HEROBRINE_WARDEN.get(), HerobrineWardenEntity.m_219463_().m_22265_());
/* 310 */     entityAttributeCreationEvent.put((EntityType)HEROBRINE_DRAGON.get(), HerobrineDragonEntity.createAttributes().m_22265_());
/* 311 */     entityAttributeCreationEvent.put((EntityType)DRAGON_METEORITE.get(), DragonMeteoriteEntity.createAttributes().m_22265_());
/* 312 */     entityAttributeCreationEvent.put((EntityType)OBSIDIAN_SLEDGEHAMMER_PROJECTILE.get(), ObsidianSledgehammerProjectileEntity.createAttributes().m_22265_());
/* 313 */     entityAttributeCreationEvent.put((EntityType)NULL_SKELETON.get(), NullSkeletonEntity.m_32166_().m_22265_());
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModEntities.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */