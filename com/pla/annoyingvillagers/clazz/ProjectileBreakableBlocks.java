/*     */ package com.pla.annoyingvillagers.clazz;
/*     */ 
/*     */ import java.util.function.Predicate;
/*     */ import net.minecraft.tags.BlockTags;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ 
/*     */ public enum ProjectileBreakableBlocks {
/*     */   GLASS_LIKE, STONE_LIKE, WOOD_LIKE, SOFT_GROUND, PLANTS;
/*     */   
/*     */   static {
/*  12 */     GLASS_LIKE = new ProjectileBreakableBlocks("GLASS_LIKE", 0, s -> 
/*  13 */         (neverBreak(s) && (s.m_60734_() instanceof net.minecraft.world.level.block.AbstractGlassBlock || s.m_60734_() instanceof net.minecraft.world.level.block.StainedGlassPaneBlock)), 0.1F, 0.2F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  20 */     STONE_LIKE = new ProjectileBreakableBlocks("STONE_LIKE", 1, s -> 
/*  21 */         (neverBreak(s) && s.m_204336_(BlockTags.f_144282_) && !isOre(s) && !s.m_204336_(BlockTags.f_13069_) && !s.m_204336_(BlockTags.f_13070_)), 0.85F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  29 */     WOOD_LIKE = new ProjectileBreakableBlocks("WOOD_LIKE", 2, s -> 
/*  30 */         (neverBreak(s) && (s.m_204336_(BlockTags.f_13106_) || s.m_204336_(BlockTags.f_13105_) || s.m_204336_(BlockTags.f_13090_) || s.m_204336_(BlockTags.f_13095_) || s.m_204336_(BlockTags.f_13102_) || s.m_204336_(BlockTags.f_13098_) || s.m_204336_(BlockTags.f_13055_) || s.m_204336_(BlockTags.f_13096_) || s.m_204336_(BlockTags.f_13097_) || s.m_204336_(BlockTags.f_13092_) || s.m_204336_(BlockTags.f_13100_) || s.m_204336_(BlockTags.f_260523_) || s.m_204336_(BlockTags.f_244320_) || s.m_60713_(Blocks.f_50091_))), 0.55F, 0.5F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     SOFT_GROUND = new ProjectileBreakableBlocks("SOFT_GROUND", 3, s -> 
/*  46 */         (neverBreak(s) && (s.m_204336_(BlockTags.f_144274_) || s.m_204336_(BlockTags.f_13029_) || s.m_204336_(BlockTags.f_144279_) || s.m_60713_(Blocks.f_49994_) || s.m_204336_(BlockTags.f_144276_) || s.m_204336_(BlockTags.f_144277_))), 0.85F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     PLANTS = new ProjectileBreakableBlocks("PLANTS", 4, s -> 
/*  56 */         (neverBreak(s) && (s.m_204336_(BlockTags.f_13035_) || s.m_204336_(BlockTags.f_13041_) || s.m_204336_(BlockTags.f_13037_) || s.m_204336_(BlockTags.f_13040_) || s.m_204336_(BlockTags.f_13073_) || s.m_204336_(BlockTags.f_13104_) || s.m_204336_(BlockTags.f_144275_) || s.m_60713_(Blocks.f_50191_) || s.m_60713_(Blocks.f_50128_))), 0.05F, 0.08F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Predicate<BlockState> matcher;
/*     */ 
/*     */   
/*     */   public final float requiredPower;
/*     */ 
/*     */   
/*     */   public final float powerCost;
/*     */ 
/*     */   
/*     */   ProjectileBreakableBlocks(Predicate<BlockState> matcher, float requiredPower, float powerCost) {
/*  71 */     this.matcher = matcher;
/*  72 */     this.requiredPower = requiredPower;
/*  73 */     this.powerCost = powerCost;
/*     */   }
/*     */   
/*     */   public static ProjectileBreakableBlocks find(BlockState state) {
/*  77 */     for (ProjectileBreakableBlocks rule : values()) {
/*  78 */       if (rule.matcher.test(state)) return rule; 
/*     */     } 
/*  80 */     return null;
/*     */   }
/*     */   
/*     */   private static boolean isOre(BlockState s) {
/*  84 */     return (s.m_204336_(BlockTags.f_144262_) || s
/*  85 */       .m_204336_(BlockTags.f_144258_) || s
/*  86 */       .m_204336_(BlockTags.f_13043_) || s
/*  87 */       .m_204336_(BlockTags.f_144259_) || s
/*  88 */       .m_204336_(BlockTags.f_144260_) || s
/*  89 */       .m_204336_(BlockTags.f_144261_) || s
/*  90 */       .m_204336_(BlockTags.f_144263_) || s
/*  91 */       .m_204336_(BlockTags.f_144264_));
/*     */   }
/*     */   
/*     */   private static boolean neverBreak(BlockState s) {
/*  95 */     return (!s.m_60713_(Blocks.f_50752_) && 
/*  96 */       !s.m_60713_(Blocks.f_50080_) && 
/*  97 */       !s.m_60713_(Blocks.f_50723_) && 
/*  98 */       !isSurfaceGrassLike(s));
/*     */   }
/*     */   
/*     */   private static boolean isSurfaceGrassLike(BlockState s) {
/* 102 */     return (s.m_60713_(Blocks.f_50440_) || s
/* 103 */       .m_60713_(Blocks.f_50599_) || s
/* 104 */       .m_60713_(Blocks.f_50195_) || s
/* 105 */       .m_60713_(Blocks.f_152481_) || s
/* 106 */       .m_60713_(Blocks.f_49992_));
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\ProjectileBreakableBlocks.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */