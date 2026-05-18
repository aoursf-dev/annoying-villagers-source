/*     */ package com.pla.annoyingvillagers.block;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModMobEffects;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.TooltipFlag;
/*     */ import net.minecraft.world.item.context.BlockPlaceContext;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.HorizontalDirectionalBlock;
/*     */ import net.minecraft.world.level.block.Mirror;
/*     */ import net.minecraft.world.level.block.Rotation;
/*     */ import net.minecraft.world.level.block.SoundType;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.StateDefinition;
/*     */ import net.minecraft.world.level.block.state.properties.DirectionProperty;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.storage.loot.LootParams;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.Shapes;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class EnchantBedBlock extends Block {
/*  38 */   public static final DirectionProperty FACING = HorizontalDirectionalBlock.f_54117_;
/*     */   
/*     */   public EnchantBedBlock() {
/*  41 */     super(BlockBehaviour.Properties.m_284310_()
/*  42 */         .m_60918_(SoundType.f_56736_)
/*  43 */         .m_60913_(1.25F, 10.0F)
/*  44 */         .m_60953_(blockstate -> 2)
/*  45 */         .m_60967_(5.0F)
/*  46 */         .m_60955_()
/*  47 */         .m_60982_((blockstate, blockgetter, blockpos) -> true)
/*  48 */         .m_60991_((blockstate, blockgetter, blockpos) -> true)
/*  49 */         .m_60924_((blockstate, blockgetter, blockpos) -> false));
/*  50 */     m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)FACING, (Comparable)Direction.NORTH));
/*     */   }
/*     */   
/*     */   public void m_5871_(@NotNull ItemStack itemstack, BlockGetter blockgetter, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/*  54 */     super.m_5871_(itemstack, blockgetter, list, tooltipflag);
/*  55 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.enchanted_bed"));
/*     */   }
/*     */   
/*     */   public boolean m_7420_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos) {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public int m_7753_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos) {
/*  63 */     return 0;
/*     */   }
/*     */   @NotNull
/*     */   public VoxelShape m_5909_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos, @NotNull CollisionContext collisioncontext) {
/*  67 */     return Shapes.m_83040_();
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public VoxelShape m_5940_(BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos, @NotNull CollisionContext collisioncontext) {
/*  73 */     switch ((Direction)blockstate.m_61143_((Property)FACING))
/*     */     { case NORTH:
/*  75 */         voxelshape = Shapes.m_83124_(m_49796_(0.0D, 0.0D, 29.0D, 3.0D, 3.0D, 32.0D), new VoxelShape[] { m_49796_(13.0D, 0.0D, 29.0D, 16.0D, 3.0D, 32.0D), m_49796_(0.0D, 3.0D, 16.0D, 16.0D, 9.0D, 32.0D), m_49796_(0.0D, 3.0D, 0.0D, 16.0D, 9.0D, 16.0D), m_49796_(13.0D, 0.0D, 0.0D, 16.0D, 3.0D, 3.0D), m_49796_(0.0D, 0.0D, 0.0D, 3.0D, 3.0D, 3.0D) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  87 */         return voxelshape;case EAST: voxelshape = Shapes.m_83124_(m_49796_(-16.0D, 0.0D, 0.0D, -13.0D, 3.0D, 3.0D), new VoxelShape[] { m_49796_(-16.0D, 0.0D, 13.0D, -13.0D, 3.0D, 16.0D), m_49796_(-16.0D, 3.0D, 0.0D, 0.0D, 9.0D, 16.0D), m_49796_(0.0D, 3.0D, 0.0D, 16.0D, 9.0D, 16.0D), m_49796_(13.0D, 0.0D, 13.0D, 16.0D, 3.0D, 16.0D), m_49796_(13.0D, 0.0D, 0.0D, 16.0D, 3.0D, 3.0D) }); return voxelshape;case WEST: voxelshape = Shapes.m_83124_(m_49796_(29.0D, 0.0D, 13.0D, 32.0D, 3.0D, 16.0D), new VoxelShape[] { m_49796_(29.0D, 0.0D, 0.0D, 32.0D, 3.0D, 3.0D), m_49796_(16.0D, 3.0D, 0.0D, 32.0D, 9.0D, 16.0D), m_49796_(0.0D, 3.0D, 0.0D, 16.0D, 9.0D, 16.0D), m_49796_(0.0D, 0.0D, 0.0D, 3.0D, 3.0D, 3.0D), m_49796_(0.0D, 0.0D, 13.0D, 3.0D, 3.0D, 16.0D) }); return voxelshape; }  VoxelShape voxelshape = Shapes.m_83124_(m_49796_(13.0D, 0.0D, -16.0D, 16.0D, 3.0D, -13.0D), new VoxelShape[] { m_49796_(0.0D, 0.0D, -16.0D, 3.0D, 3.0D, -13.0D), m_49796_(0.0D, 3.0D, -16.0D, 16.0D, 9.0D, 0.0D), m_49796_(0.0D, 3.0D, 0.0D, 16.0D, 9.0D, 16.0D), m_49796_(0.0D, 0.0D, 13.0D, 3.0D, 3.0D, 16.0D), m_49796_(13.0D, 0.0D, 13.0D, 16.0D, 3.0D, 16.0D) }); return voxelshape;
/*     */   }
/*     */   
/*     */   protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
/*  91 */     builder.m_61104_(new Property[] { (Property)FACING });
/*     */   }
/*     */   
/*     */   public BlockState m_5573_(BlockPlaceContext blockplacecontext) {
/*  95 */     return (BlockState)m_49966_().m_61124_((Property)FACING, (Comparable)blockplacecontext.m_8125_().m_122424_());
/*     */   }
/*     */   @NotNull
/*     */   public BlockState m_6843_(BlockState blockstate, Rotation rotation) {
/*  99 */     return (BlockState)blockstate.m_61124_((Property)FACING, (Comparable)rotation.m_55954_((Direction)blockstate.m_61143_((Property)FACING)));
/*     */   }
/*     */   @NotNull
/*     */   public BlockState m_6943_(BlockState blockstate, Mirror mirror) {
/* 103 */     return blockstate.m_60717_(mirror.m_54846_((Direction)blockstate.m_61143_((Property)FACING)));
/*     */   }
/*     */   @NotNull
/*     */   public List<ItemStack> m_49635_(@NotNull BlockState blockstate, LootParams.Builder pParams) {
/* 107 */     List<ItemStack> list = super.m_49635_(blockstate, pParams);
/*     */     
/* 109 */     return !list.isEmpty() ? list : Collections.<ItemStack>singletonList(new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANT_BED_ITEM.get()));
/*     */   }
/*     */   @NotNull
/*     */   public InteractionResult m_6227_(@NotNull BlockState blockstate, @NotNull Level level, @NotNull BlockPos blockpos, @NotNull Player player, @NotNull InteractionHand interactionhand, @NotNull BlockHitResult blockHitResult) {
/* 113 */     super.m_6227_(blockstate, level, blockpos, player, interactionhand, blockHitResult);
/* 114 */     if (player.m_21023_((MobEffect)AnnoyingVillagersModMobEffects.ENCHANT_BED_EFFECT.get()) && 
/* 115 */       !player.m_9236_().m_5776_()) {
/* 116 */       player.m_5661_((Component)Component.m_237113_("You have already used the Enchant Bed!"), true);
/*     */     }
/*     */     
/* 119 */     if (player instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)player;
/* 120 */       if (player.f_36078_ >= 2) {
/* 121 */         player.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ENCHANT_BED_EFFECT.get(), 2147483647, 0, false, false));
/* 122 */         player.m_5661_((Component)Component.m_237113_("You used the Enchant Bed once. Experience level -1."), true);
/* 123 */         player.m_5661_((Component)Component.m_237113_("Respawn point has been reset."), false);
/* 124 */         player.m_6749_(-1);
/* 125 */         serverPlayer.m_9158_(player.m_9236_().m_46472_(), new BlockPos((int)(blockHitResult.m_82450_()).f_82479_, (int)(blockHitResult.m_82450_()).f_82480_, (int)(blockHitResult.m_82450_()).f_82481_), serverPlayer.m_146908_(), true, false);
/*     */       } else {
/* 127 */         player.m_5661_((Component)Component.m_237113_("Your experience level is too low. You must be above level 2 to use this!"), true);
/*     */       }  }
/*     */     
/* 130 */     return InteractionResult.SUCCESS;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\block\EnchantBedBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */