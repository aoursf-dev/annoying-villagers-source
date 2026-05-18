/*    */ package com.pla.annoyingvillagers.block;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.BlockGetter;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraft.world.level.LevelReader;
/*    */ import net.minecraft.world.level.block.BaseFireBlock;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.StateDefinition;
/*    */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*    */ import net.minecraft.world.level.block.state.properties.IntegerProperty;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ 
/*    */ public class EndFireBlock extends BaseFireBlock {
/* 21 */   public static final IntegerProperty AGE = BlockStateProperties.f_61410_;
/*    */   
/*    */   public EndFireBlock(BlockBehaviour.Properties properties) {
/* 24 */     super(properties, 3.0F);
/* 25 */     m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)AGE, Integer.valueOf(0)));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
/* 30 */     super.m_7926_(builder);
/* 31 */     builder.m_61104_(new Property[] { (Property)AGE });
/*    */   }
/*    */   
/*    */   public ItemStack m_7397_(BlockGetter g, BlockPos p, BlockState s) {
/* 35 */     return ItemStack.f_41583_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BlockState m_7417_(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
/* 41 */     return state.m_60710_((LevelReader)level, currentPos) ? state : Blocks.f_50016_.m_49966_();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean m_7599_(BlockState pState) {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   private static int getEndFireTickDelay(RandomSource random) {
/* 50 */     return 40 + random.m_188503_(20);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6807_(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
/* 55 */     super.m_6807_(state, level, pos, oldState, isMoving);
/* 56 */     if (!level.f_46443_) {
/* 57 */       level.m_186460_(pos, (Block)this, getEndFireTickDelay(level.f_46441_));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_213897_(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
/* 63 */     level.m_186460_(pos, (Block)this, getEndFireTickDelay(random));
/*    */     
/* 65 */     if (!state.m_60710_((LevelReader)level, pos)) {
/* 66 */       level.m_7471_(pos, false);
/*    */       
/*    */       return;
/*    */     } 
/* 70 */     int age = ((Integer)state.m_61143_((Property)AGE)).intValue();
/* 71 */     int newAge = Math.min(15, age + 1 + random.m_188503_(2));
/* 72 */     if (newAge != age) {
/* 73 */       level.m_7731_(pos, (BlockState)state.m_61124_((Property)AGE, Integer.valueOf(newAge)), 4);
/* 74 */       state = level.m_8055_(pos);
/* 75 */       age = newAge;
/*    */     } 
/*    */     
/* 78 */     if (level.m_46758_(pos) && random.m_188501_() < 0.05F + age * 0.01F) {
/* 79 */       level.m_7471_(pos, false);
/*    */       
/*    */       return;
/*    */     } 
/* 83 */     if (age >= 15 && 
/* 84 */       random.m_188503_(6) == 0)
/* 85 */       level.m_7471_(pos, false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\block\EndFireBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */