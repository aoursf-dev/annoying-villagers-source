/*    */ package com.pla.annoyingvillagers.world;
/*    */ 
/*    */ import com.pla.annoyingvillagers.config.AnnoyingVillagersSpawnConfig;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.level.biome.MobSpawnSettings;
/*    */ import net.minecraftforge.common.world.ModifiableBiomeInfo;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ public final class AVWorldSpawns
/*    */ {
/* 15 */   private static final Logger LOGGER = LogManager.getLogger();
/*    */ 
/*    */   
/*    */   public static void addBiomeSpawns(ModifiableBiomeInfo.BiomeInfo.Builder builder) {
/* 19 */     for (AnnoyingVillagersSpawnConfig.Entry entry : AnnoyingVillagersSpawnConfig.ENTRIES) {
/* 20 */       AnnoyingVillagersSpawnConfig.SpawnConfig spawnConfig = AnnoyingVillagersSpawnConfig.getSpawnConfig(entry.entityId());
/* 21 */       addSpawn(builder, ResourceLocation.fromNamespaceAndPath("annoyingvillagers", entry.entityId()), spawnConfig);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static void addSpawn(ModifiableBiomeInfo.BiomeInfo.Builder builder, ResourceLocation entityId, AnnoyingVillagersSpawnConfig.SpawnConfig spawnConfig) {
/* 29 */     if (spawnConfig.weight() <= 0)
/* 30 */       return;  EntityType<?> rawType = (EntityType)ForgeRegistries.ENTITY_TYPES.getValue(entityId);
/* 31 */     if (rawType == null) {
/* 32 */       LOGGER.warn("Spawn config refers to missing entity type: {}", entityId);
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 37 */     EntityType<? extends Mob> mobType = (EntityType)rawType;
/*    */     
/* 39 */     builder.getMobSpawnSettings()
/* 40 */       .getSpawner(mobType.m_20674_())
/* 41 */       .add(new MobSpawnSettings.SpawnerData(mobType, spawnConfig.weight(), spawnConfig.minCount(), spawnConfig.maxCount()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\world\AVWorldSpawns.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */