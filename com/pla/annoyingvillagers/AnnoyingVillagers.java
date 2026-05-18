/*     */ package com.pla.annoyingvillagers;
/*     */ import com.mojang.serialization.Codec;
/*     */ import com.pla.annoyingvillagers.capabilities.AVWeaponCapabilityPresets;
/*     */ import com.pla.annoyingvillagers.client.engine.SpriteArrowsCommonEntrypoint;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersSpawnConfig;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModCapabilities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.network.CPApplyShake;
/*     */ import com.pla.annoyingvillagers.network.ClientboundGlaiveExplosionFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundHerobrinePortalFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundLitePortalFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundMuteExplosionAtPos;
/*     */ import com.pla.annoyingvillagers.network.ClientboundWoopieSwordWindFx;
/*     */ import com.pla.annoyingvillagers.world.AVMobSpawnBiomeModifier;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.client.multiplayer.ClientLevel;
/*     */ import net.minecraft.client.renderer.item.ItemProperties;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.common.world.BiomeModifier;
/*     */ import net.minecraftforge.eventbus.api.EventPriority;
/*     */ import net.minecraftforge.eventbus.api.IEventBus;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import net.minecraftforge.fml.config.IConfigSpec;
/*     */ import net.minecraftforge.fml.config.ModConfig;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*     */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*     */ import net.minecraftforge.network.NetworkEvent;
/*     */ import net.minecraftforge.registries.DeferredRegister;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Armatures;
/*     */ 
/*     */ @Mod("annoyingvillagers")
/*     */ public class AnnoyingVillagers {
/*  49 */   public static final Logger LOGGER = LogManager.getLogger(AnnoyingVillagers.class);
/*     */   
/*     */   public static final String MODID = "annoyingvillagers";
/*  52 */   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "main"), () -> "1", "1"::equals, "1"::equals);
/*  53 */   private static int messageID = 0;
/*     */   
/*     */   public AnnoyingVillagers(FMLJavaModLoadingContext context) {
/*  56 */     IEventBus modEventBus = context.getModEventBus();
/*  57 */     modEventBus.addListener(this::commonSetup);
/*     */     
/*  59 */     AnnoyingVillagersModBlocks.REGISTRY.register(modEventBus);
/*  60 */     AnnoyingVillagersModBlockEntities.REGISTRY.register(modEventBus);
/*  61 */     AnnoyingVillagersModItems.REGISTRY.register(modEventBus);
/*  62 */     modEventBus.addListener(AVWeaponCapabilityPresets::register);
/*  63 */     AnnoyingVillagersModEntities.REGISTRY.register(modEventBus);
/*  64 */     AnnoyingVillagersModMobEffects.REGISTRY.register(modEventBus);
/*  65 */     AnnoyingVillagersModParticleTypes.REGISTRY.register(modEventBus);
/*  66 */     MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, AnnoyingVillagersModCapabilities::attachEntityCapability);
/*  67 */     modEventBus.addListener(AnnoyingVillagersModCapabilities::registerCapabilities);
/*  68 */     AnnoyingVillagersModCreativeTabs.register(modEventBus);
/*  69 */     AnnoyingVillagersModSounds.register(modEventBus);
/*  70 */     AVSounds.SOUNDS.register(modEventBus);
/*  71 */     MinecraftForge.EVENT_BUS.register(new NpcGearLoadEvent());
/*  72 */     context.registerConfig(ModConfig.Type.COMMON, (IConfigSpec)AnnoyingVillagersConfig.SPEC, "annoyingvillagers-server.toml");
/*     */     
/*  74 */     DeferredRegister<Codec<? extends BiomeModifier>> biomeModifiers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, "annoyingvillagers");
/*  75 */     biomeModifiers.register(modEventBus);
/*  76 */     biomeModifiers.register("av_mob_spawns", AVMobSpawnBiomeModifier::makeCodec);
/*  77 */     context.registerConfig(ModConfig.Type.COMMON, (IConfigSpec)AnnoyingVillagersSpawnConfig.SPEC, "annoyingvillagers-spawns.toml");
/*  78 */     AVSkillDataKeys.DATA_KEYS.register(modEventBus);
/*     */     
/*  80 */     if (FMLEnvironment.dist.isClient()) {
/*  81 */       modEventBus.addListener(this::clientSetup);
/*  82 */       modEventBus.addListener(EventPriority.LOWEST, ClassLoadingProtection::listen);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class ClassLoadingProtection {
/*     */     private static void listen(FMLClientSetupEvent event) {
/*  88 */       event.enqueueWork(SpriteArrowsCommonEntrypoint::replace);
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> void addNetworkMessage(Class<T> oclass, BiConsumer<T, FriendlyByteBuf> biconsumer, Function<FriendlyByteBuf, T> function, BiConsumer<T, Supplier<NetworkEvent.Context>> biconsumer1) {
/*  93 */     PACKET_HANDLER.registerMessage(messageID, oclass, biconsumer, function, biconsumer1);
/*  94 */     messageID++;
/*     */   }
/*     */   
/*     */   private void clientSetup(FMLClientSetupEvent event) {
/*  98 */     new CameraEngine();
/*     */   }
/*     */   
/*     */   @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
/*     */   public static class initer {
/*     */     @SubscribeEvent
/*     */     public static void init(FMLCommonSetupEvent fmlCommonSetupEvent) {
/* 105 */       AnnoyingVillagers.addNetworkMessage(ClientboundGlaiveExplosionFx.class, ClientboundGlaiveExplosionFx::encode, ClientboundGlaiveExplosionFx::decode, ClientboundGlaiveExplosionFx::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 111 */       AnnoyingVillagers.addNetworkMessage(ClientboundMuteExplosionAtPos.class, ClientboundMuteExplosionAtPos::encode, ClientboundMuteExplosionAtPos::decode, ClientboundMuteExplosionAtPos::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 117 */       AnnoyingVillagers.addNetworkMessage(ClientboundHerobrinePortalFx.class, ClientboundHerobrinePortalFx::encode, ClientboundHerobrinePortalFx::decode, ClientboundHerobrinePortalFx::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 123 */       AnnoyingVillagers.addNetworkMessage(ClientboundWoopieSwordWindFx.class, ClientboundWoopieSwordWindFx::encode, ClientboundWoopieSwordWindFx::decode, ClientboundWoopieSwordWindFx::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 129 */       AnnoyingVillagers.addNetworkMessage(ClientboundLitePortalFx.class, ClientboundLitePortalFx::encode, ClientboundLitePortalFx::decode, ClientboundLitePortalFx::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 135 */       AnnoyingVillagers.addNetworkMessage(CPApplyShake.class, CPApplyShake::encode, CPApplyShake::new, CPApplyShake::handle);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void commonSetup(FMLCommonSetupEvent event) {
/* 145 */     event.enqueueWork(AnnoyingVillagers::registerArmatures);
/*     */   }
/*     */   
/*     */   public static void registerArmatures() {
/* 149 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.PLAYER_NPC.get(), (AssetAccessor)Armatures.BIPED);
/* 150 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.VILLAGER_SCOUT.get(), (AssetAccessor)Armatures.BIPED);
/* 151 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.VILLAGER_SCOUT_CAPTAIN.get(), (AssetAccessor)Armatures.BIPED);
/* 152 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.RED_VILLAGER_GENERAL.get(), (AssetAccessor)Armatures.BIPED);
/* 153 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.BLUE_VILLAGER_GENERAL.get(), (AssetAccessor)Armatures.BIPED);
/* 154 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.GREEN_VILLAGER_GENERAL.get(), (AssetAccessor)Armatures.BIPED);
/* 155 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.PURPLE_VILLAGER_GENERAL.get(), (AssetAccessor)Armatures.BIPED);
/* 156 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.STEVE.get(), (AssetAccessor)Armatures.BIPED);
/* 157 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.ANGRY_STEVE.get(), (AssetAccessor)Armatures.BIPED);
/* 158 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.ALEX.get(), (AssetAccessor)Armatures.BIPED);
/* 159 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.JEV.get(), (AssetAccessor)Armatures.BIPED);
/* 160 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.CHRIS.get(), (AssetAccessor)Armatures.BIPED);
/* 161 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.LOW_HEROBRINE_CLONE.get(), (AssetAccessor)Armatures.BIPED);
/* 162 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (AssetAccessor)Armatures.BIPED);
/* 163 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.AEGIS_HEROBRINE.get(), (AssetAccessor)Armatures.BIPED);
/* 164 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.SWORDSMAN_HEROBRINE.get(), (AssetAccessor)Armatures.BIPED);
/* 165 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.GLAIVE_HEROBRINE.get(), (AssetAccessor)Armatures.BIPED);
/* 166 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.SLEDGEHAMMER_HEROBRINE.get(), (AssetAccessor)Armatures.BIPED);
/* 167 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.REAPER_HEROBRINE.get(), (AssetAccessor)Armatures.BIPED);
/* 168 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.NULL_SWORD.get(), (AssetAccessor)Armatures.BIPED);
/* 169 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.NULL_SHOVEL.get(), (AssetAccessor)Armatures.BIPED);
/* 170 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.NULL_AXE.get(), (AssetAccessor)Armatures.BIPED);
/* 171 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.NULL_PICKAXE.get(), (AssetAccessor)Armatures.BIPED);
/* 172 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.NULL_HOE.get(), (AssetAccessor)Armatures.BIPED);
/* 173 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.NULL_SKELETON.get(), (AssetAccessor)Armatures.SKELETON);
/* 174 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.NULL.get(), (AssetAccessor)Armatures.BIPED);
/* 175 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.HEROBRINE_CLONE.get(), (AssetAccessor)Armatures.BIPED);
/* 176 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.SHADOW_HEROBRINE_CLONE.get(), (AssetAccessor)Armatures.BIPED);
/* 177 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.HEROBRINE_CHRIS.get(), (AssetAccessor)Armatures.BIPED);
/* 178 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.ARMORED_HEROBRINE.get(), (AssetAccessor)Armatures.BIPED);
/* 179 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.HEROBRINE_7.get(), (AssetAccessor)Armatures.BIPED);
/* 180 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.SHADOW_HEROBRINE.get(), (AssetAccessor)Armatures.BIPED);
/* 181 */     Armatures.registerEntityTypeArmature((EntityType)AnnoyingVillagersModEntities.BLUE_DEMON.get(), (AssetAccessor)Armatures.BIPED);
/*     */   }
/*     */   
/*     */   @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*     */   public static class ClientModEvents {
/*     */     @SubscribeEvent
/*     */     public static void onClientSetup(FMLClientSetupEvent event) {
/* 188 */       event.enqueueWork(() -> {
/*     */             ItemProperties.register((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get(), ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "second_form"), ());
/*     */             ItemProperties.register((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get(), ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "snake_animation"), ());
/*     */             ItemProperties.register((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get(), ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "snake_animation_ready"), ());
/*     */             ItemProperties.register((Item)AnnoyingVillagersModItems.ENDER_AEGIS.get(), ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "second_form"), ());
/*     */             for (Item item : ForgeRegistries.ITEMS.getValues()) {
/*     */               if (item instanceof net.minecraft.world.item.BowItem) {
/*     */                 ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath("minecraft", "pulling"), ());
/*     */                 ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath("minecraft", "pull"), ());
/*     */               } 
/*     */             } 
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\AnnoyingVillagers.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */