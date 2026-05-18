/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import com.pla.annoyingvillagers.blockentity.CryingObsidianBlockEntity;
/*    */ import com.pla.annoyingvillagers.blockentity.ObsidianBlockEntity;
/*    */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianBlockEntity;
/*    */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianLongPillarBlockEntity;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    */ import net.minecraftforge.eventbus.api.IEventBus;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ public final class AnnoyingVillagersModBlockEntities
/*    */ {
/* 17 */   public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "annoyingvillagers");
/*    */   
/* 19 */   public static final RegistryObject<BlockEntityType<ShadowObsidianLongPillarBlockEntity>> SHADOW_OBSIDIAN_SHORT_PILLAR = REGISTRY
/* 20 */     .register("shadow_obsidian_short_pillar", () -> BlockEntityType.Builder.m_155273_(ShadowObsidianLongPillarBlockEntity::new, new Block[] { (Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_SHORT_PILLAR.get() }).m_58966_(null));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   public static final RegistryObject<BlockEntityType<ShadowObsidianLongPillarBlockEntity>> SHADOW_OBSIDIAN_MIDDLE_PILLAR = REGISTRY
/* 26 */     .register("shadow_obsidian_middle_pillar", () -> BlockEntityType.Builder.m_155273_(ShadowObsidianLongPillarBlockEntity::new, new Block[] { (Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_MIDDLE_PILLAR.get() }).m_58966_(null));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 31 */   public static final RegistryObject<BlockEntityType<ShadowObsidianLongPillarBlockEntity>> SHADOW_OBSIDIAN_LONG_PILLAR = REGISTRY
/* 32 */     .register("shadow_obsidian_long_pillar", () -> BlockEntityType.Builder.m_155273_(ShadowObsidianLongPillarBlockEntity::new, new Block[] { (Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR.get() }).m_58966_(null));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 37 */   public static final RegistryObject<BlockEntityType<ShadowObsidianBlockEntity>> SHADOW_OBSIDIAN_BLOCK = REGISTRY
/* 38 */     .register("shadow_obsidian", () -> BlockEntityType.Builder.m_155273_(ShadowObsidianBlockEntity::new, new Block[] { (Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get() }).m_58966_(null));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 43 */   public static final RegistryObject<BlockEntityType<ObsidianBlockEntity>> OBSIDIAN_BLOCK = REGISTRY
/* 44 */     .register("obsidian", () -> BlockEntityType.Builder.m_155273_(ObsidianBlockEntity::new, new Block[] { (Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get() }).m_58966_(null));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   public static final RegistryObject<BlockEntityType<CryingObsidianBlockEntity>> CRYING_OBSIDIAN_BLOCK = REGISTRY
/* 50 */     .register("crying_obsidian", () -> BlockEntityType.Builder.m_155273_(CryingObsidianBlockEntity::new, new Block[] { (Block)AnnoyingVillagersModBlocks.CRYING_OBSIDIAN_BLOCK.get() }).m_58966_(null));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void register(IEventBus modEventBus) {
/* 57 */     REGISTRY.register(modEventBus);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModBlockEntities.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */