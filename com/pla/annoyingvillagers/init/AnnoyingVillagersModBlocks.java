/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import com.pla.annoyingvillagers.block.EndFireBlock;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.SoundType;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.material.MapColor;
/*    */ import net.minecraft.world.level.material.PushReaction;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ public class AnnoyingVillagersModBlocks {
/* 16 */   public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "annoyingvillagers");
/* 17 */   public static final RegistryObject<Block> ENCHANT_BED = REGISTRY.register("enchant_bed", com.pla.annoyingvillagers.block.EnchantBedBlock::new);
/* 18 */   public static final RegistryObject<Block> SHADOW_OBSIDIAN_SHORT_PILLAR = REGISTRY.register("shadow_obsidian_short_pillar", com.pla.annoyingvillagers.block.ShadowObsidianShortPillarBlock::new);
/* 19 */   public static final RegistryObject<Block> SHADOW_OBSIDIAN_MIDDLE_PILLAR = REGISTRY.register("shadow_obsidian_middle_pillar", com.pla.annoyingvillagers.block.ShadowObsidianMiddlePillarBlock::new);
/* 20 */   public static final RegistryObject<Block> SHADOW_OBSIDIAN_LONG_PILLAR = REGISTRY.register("shadow_obsidian_long_pillar", com.pla.annoyingvillagers.block.ShadowObsidianLongPillarBlock::new);
/* 21 */   public static final RegistryObject<Block> SHADOW_OBSIDIAN_BLOCK = REGISTRY.register("shadow_obsidian", com.pla.annoyingvillagers.block.ShadowObsidianBlock::new);
/* 22 */   public static final RegistryObject<Block> OBSIDIAN_BLOCK = REGISTRY.register("obsidian", com.pla.annoyingvillagers.block.ObsidianBlock::new);
/* 23 */   public static final RegistryObject<Block> CRYING_OBSIDIAN_BLOCK = REGISTRY.register("crying_obsidian", com.pla.annoyingvillagers.block.CryingObsidianBlock::new);
/* 24 */   public static final RegistryObject<EndFireBlock> END_FIRE = REGISTRY.register("end_fire", () -> new EndFireBlock(BlockBehaviour.Properties.m_284310_().m_284180_(MapColor.f_283889_).m_280170_().m_60910_().m_60966_().m_60953_(()).m_60918_(SoundType.f_56745_).m_278166_(PushReaction.DESTROY)));
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModBlocks.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */