/*     */ package com.pla.annoyingvillagers.init;
/*     */ 
/*     */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.client.event.EntityRenderersEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
/*     */ import yesman.epicfight.api.client.model.Meshes;
/*     */ import yesman.epicfight.client.renderer.patched.entity.PHumanoidRenderer;
/*     */ import yesman.epicfight.client.renderer.patched.entity.PIllagerRenderer;
/*     */ import yesman.epicfight.client.renderer.patched.entity.PatchedEntityRenderer;
/*     */ 
/*     */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*     */ public class AnnoyingVillagersModEntityRenderers {
/*     */   @SubscribeEvent
/*     */   public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers registerrenderers) {
/*  21 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_CLONE.get(), com.pla.annoyingvillagers.client.renderer.HerobrineCloneRenderer::new);
/*  22 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.BLUE_DEMON.get(), com.pla.annoyingvillagers.client.renderer.BlueDemonRenderer::new);
/*  23 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.SHADOW_HEROBRINE_CLONE.get(), com.pla.annoyingvillagers.client.renderer.ShadowHerobrineRenderer::new);
/*  24 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.VILLAGER_SCOUT.get(), com.pla.annoyingvillagers.client.renderer.VillagerScoutRenderer::new);
/*  25 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.VILLAGER_SCOUT_CAPTAIN.get(), com.pla.annoyingvillagers.client.renderer.VillagerScoutCaptainRenderer::new);
/*  26 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.BLUE_VILLAGER_GENERAL.get(), com.pla.annoyingvillagers.client.renderer.BlueVillagerGeneralRenderer::new);
/*  27 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.GREEN_VILLAGER_GENERAL.get(), com.pla.annoyingvillagers.client.renderer.PurpleVillagerGeneralRenderer::new);
/*  28 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.RED_VILLAGER_GENERAL.get(), com.pla.annoyingvillagers.client.renderer.RedVillagerGeneralRenderer::new);
/*  29 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.PURPLE_VILLAGER_GENERAL.get(), com.pla.annoyingvillagers.client.renderer.GreenVillagerGeneralRenderer::new);
/*  30 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.PATROL_VILLAGER.get(), com.pla.annoyingvillagers.client.renderer.BlueVillagerGeneralRenderer::new);
/*  31 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.ENCHANTED_ENDER_PEARL_PROJECTILE.get(), net.minecraft.client.renderer.entity.ThrownItemRenderer::new);
/*  32 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.ENDER_AEGIS_PROJECTILE.get(), net.minecraft.client.renderer.entity.ThrownItemRenderer::new);
/*  33 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.ALEX.get(), com.pla.annoyingvillagers.client.renderer.AlexRenderer::new);
/*  34 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.JEV.get(), com.pla.annoyingvillagers.client.renderer.JevRenderer::new);
/*  35 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.BBQ.get(), com.pla.annoyingvillagers.client.renderer.BbqRenderer::new);
/*  36 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.CHRIS.get(), com.pla.annoyingvillagers.client.renderer.ChrisRenderer::new);
/*  37 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.INJECTED_CHRIS.get(), com.pla.annoyingvillagers.client.renderer.InfectedChrisRenderer::new);
/*  38 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_CHRIS.get(), com.pla.annoyingvillagers.client.renderer.HerobrineChrisRenderer::new);
/*  39 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_7.get(), com.pla.annoyingvillagers.client.renderer.ShadowHerobrineRenderer::new);
/*  40 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.ARMORED_HEROBRINE.get(), com.pla.annoyingvillagers.client.renderer.ArmoredHerobrineRenderer::new);
/*  41 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.STEVE.get(), com.pla.annoyingvillagers.client.renderer.SteveRenderer::new);
/*  42 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.ANGRY_STEVE.get(), com.pla.annoyingvillagers.client.renderer.AngrySteveRenderer::new);
/*  43 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.INFECTED_PLAYER_NPC.get(), se.gory_moon.player_mobs.client.render.PlayerMobRenderer::new);
/*  44 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.INFECTED_THEMOSTMOISTBURRIT0.get(), com.pla.annoyingvillagers.client.renderer.InfectedTheMostMoistBurrit0Renderer::new);
/*  45 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.SHADOW_HEROBRINE.get(), com.pla.annoyingvillagers.client.renderer.ShadowHerobrineRenderer::new);
/*  46 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.GLAIVE_HEROBRINE.get(), com.pla.annoyingvillagers.client.renderer.EliteHerobrineRenderer::new);
/*  47 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.REAPER_HEROBRINE.get(), com.pla.annoyingvillagers.client.renderer.EliteHerobrineRenderer::new);
/*  48 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.SNAKE_BLADE.get(), com.pla.annoyingvillagers.client.renderer.SnakeBladeRenderer::new);
/*  49 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.SWORDSMAN_HEROBRINE.get(), com.pla.annoyingvillagers.client.renderer.EliteHerobrineRenderer::new);
/*  50 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.SLEDGEHAMMER_HEROBRINE.get(), com.pla.annoyingvillagers.client.renderer.EliteHerobrineRenderer::new);
/*  51 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.AEGIS_HEROBRINE.get(), com.pla.annoyingvillagers.client.renderer.EliteHerobrineRenderer::new);
/*  52 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.DRAGON_BEAM.get(), com.pla.annoyingvillagers.client.renderer.DragonBeamRenderer::new);
/*  53 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.ELITE_HEROBRINE_KNOCKED.get(), com.pla.annoyingvillagers.client.renderer.EliteHerobrineKnockedRenderer::new);
/*  54 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.LOW_HEROBRINE_CLONE.get(), se.gory_moon.player_mobs.client.render.PlayerMobRenderer::new);
/*  55 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), com.pla.annoyingvillagers.client.renderer.LowShadowHerobrineCloneRenderer::new);
/*  56 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL.get(), com.pla.annoyingvillagers.client.renderer.NullRenderer::new);
/*  57 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_SWORD.get(), com.pla.annoyingvillagers.client.renderer.NullWeaponRenderer::new);
/*  58 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_AXE.get(), com.pla.annoyingvillagers.client.renderer.NullWeaponRenderer::new);
/*  59 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_PICKAXE.get(), com.pla.annoyingvillagers.client.renderer.NullWeaponRenderer::new);
/*  60 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_SHOVEL.get(), com.pla.annoyingvillagers.client.renderer.NullWeaponRenderer::new);
/*  61 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_HOE.get(), com.pla.annoyingvillagers.client.renderer.NullWeaponRenderer::new);
/*  62 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.BLOCK_PROJECTILE.get(), com.pla.annoyingvillagers.client.renderer.BlockProjectileRenderer::new);
/*  63 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_GREG.get(), com.pla.annoyingvillagers.client.renderer.HerobrineGregRenderer::new);
/*  64 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.PLAYER_NPC.get(), se.gory_moon.player_mobs.client.render.PlayerMobRenderer::new);
/*  65 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_WARDEN.get(), com.pla.annoyingvillagers.client.renderer.HerobrineWardenRenderer::new);
/*  66 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_DRAGON.get(), com.pla.annoyingvillagers.client.renderer.HerobrineDragonRenderer::new);
/*  67 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.DRAGON_METEORITE.get(), com.pla.annoyingvillagers.client.renderer.DragonMeteoriteRenderer::new);
/*  68 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.OBSIDIAN_SLEDGEHAMMER_PROJECTILE.get(), com.pla.annoyingvillagers.client.renderer.ObsidianSledgehammerProjectileRenderer::new);
/*  69 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.SHOCKWAVE_BLOCK.get(), com.pla.annoyingvillagers.client.renderer.ShockWaveBlockRenderer::new);
/*  70 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_SKELETON.get(), net.minecraft.client.renderer.entity.WitherSkeletonRenderer::new);
/*  71 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.BLUE_DEMON_THUNDER_BEAM.get(), com.pla.annoyingvillagers.client.renderer.BlueDemonThunderBeamRenderer::new);
/*  72 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.TRIDENT_LIGHTNING_BOLT.get(), net.minecraft.client.renderer.entity.LightningBoltRenderer::new);
/*  73 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.BLUE_DEMON_THROWN_TRIDENT.get(), net.minecraft.client.renderer.entity.ThrownTridentRenderer::new);
/*  74 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.ELECTRIC_AREA.get(), com.pla.annoyingvillagers.client.renderer.ElectricAreaRenderer::new);
/*  75 */     registerrenderers.registerEntityRenderer((EntityType)AnnoyingVillagersModEntities.ENCHANTED_ARROW.get(), com.pla.annoyingvillagers.client.renderer.SpriteArrowRenderer::new);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPatchedRenderer(PatchedRenderersEvent.Add add) {
/*  80 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.PLAYER_NPC.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/*  83 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.VILLAGER_SCOUT.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/*  86 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.VILLAGER_SCOUT_CAPTAIN.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/*  89 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.RED_VILLAGER_GENERAL.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/*  92 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.BLUE_VILLAGER_GENERAL.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/*  95 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.GREEN_VILLAGER_GENERAL.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/*  98 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.PURPLE_VILLAGER_GENERAL.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.PATROL_VILLAGER.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/* 101 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.STEVE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 104 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.ANGRY_STEVE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 107 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.ALEX.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.ALEX, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 110 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.JEV.get(), entitytype -> (new PIllagerRenderer(add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 113 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.CHRIS.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 116 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.LOW_HEROBRINE_CLONE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 119 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 122 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.AEGIS_HEROBRINE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 125 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.SWORDSMAN_HEROBRINE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 128 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.GLAIVE_HEROBRINE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 131 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.SLEDGEHAMMER_HEROBRINE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 134 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.REAPER_HEROBRINE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 137 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_SWORD.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 140 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_AXE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 143 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_PICKAXE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 146 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_SHOVEL.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 149 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_HOE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 152 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL_SKELETON.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.SKELETON, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 155 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.NULL.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 158 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_CLONE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 161 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.SHADOW_HEROBRINE_CLONE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 164 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_CHRIS.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 167 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.ARMORED_HEROBRINE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 170 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.HEROBRINE_7.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 173 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.SHADOW_HEROBRINE.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */ 
/*     */     
/* 176 */     add.addPatchedEntityRenderer((EntityType)AnnoyingVillagersModEntities.BLUE_DEMON.get(), entitytype -> (new PHumanoidRenderer((AssetAccessor)Meshes.BIPED, add.getContext(), entitytype)).initLayerLast(add.getContext(), entitytype));
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModEntityRenderers.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */