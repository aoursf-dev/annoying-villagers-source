/*     */ package com.pla.annoyingvillagers.clazz;
/*     */ import com.pla.annoyingvillagers.blockentity.CryingObsidianBlockEntity;
/*     */ import com.pla.annoyingvillagers.blockentity.ObsidianBlockEntity;
/*     */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianBlockEntity;
/*     */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianLongPillarBlockEntity;
/*     */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianMiddlePillarBlockEntity;
/*     */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianShortPillarBlockEntity;
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.context.BlockPlaceContext;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.StateDefinition;
/*     */ import net.minecraft.world.level.block.state.properties.BooleanProperty;
/*     */ import net.minecraft.world.level.block.state.properties.IntegerProperty;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.storage.loot.LootParams;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class HerobrineObsidianBlock extends Block {
/*  36 */   public static final BooleanProperty FROM_PLAYER = BooleanProperty.m_61465_("from_player");
/*  37 */   public static final IntegerProperty REPLACE_BY_LIQUID = IntegerProperty.m_61631_("replace_by_liquid", 0, 2);
/*     */   
/*     */   private static final String NBT_LIFE = "life";
/*     */   private static final int LIFE_TICKS = 25;
/*     */   
/*     */   public HerobrineObsidianBlock(BlockBehaviour.Properties pProperties) {
/*  43 */     super(pProperties);
/*  44 */     m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_
/*  45 */         .m_61090_())
/*  46 */         .m_61124_((Property)FROM_PLAYER, Boolean.FALSE))
/*  47 */         .m_61124_((Property)REPLACE_BY_LIQUID, Integer.valueOf(0)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
/*  53 */     builder.m_61104_(new Property[] { (Property)FROM_PLAYER, (Property)REPLACE_BY_LIQUID });
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockState m_5573_(@NotNull BlockPlaceContext blockPlaceContext) {
/*  58 */     BlockState base = super.m_5573_(blockPlaceContext);
/*  59 */     if (base == null) base = m_49966_(); 
/*  60 */     return (BlockState)base.m_61124_((Property)FROM_PLAYER, Boolean.valueOf((blockPlaceContext.m_43723_() != null)));
/*     */   }
/*     */   
/*     */   public int m_7753_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos) {
/*  64 */     return 15;
/*     */   }
/*     */   @NotNull
/*     */   public VoxelShape m_5909_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos, @NotNull CollisionContext collisioncontext) {
/*  68 */     return Shapes.m_83040_();
/*     */   }
/*     */   @NotNull
/*     */   public List<ItemStack> m_49635_(@NotNull BlockState blockstate, LootParams.Builder builder) {
/*  72 */     List<ItemStack> list = super.m_49635_(blockstate, builder);
/*  73 */     return !list.isEmpty() ? list : Collections.<ItemStack>singletonList(new ItemStack((ItemLike)this, 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void customTickSound(ServerLevel serverLevel, BlockPos blockPos) {}
/*     */ 
/*     */   
/*     */   public void customPlaceSound(ServerLevel serverLevel, BlockPos blockPos) {}
/*     */ 
/*     */   
/*     */   public void m_6807_(@NotNull BlockState blockstate, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull BlockState oldState, boolean flag) {
/*  85 */     super.m_6807_(blockstate, level, blockPos, oldState, flag);
/*     */     
/*  87 */     if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  88 */       customPlaceSound(serverLevel, blockPos);
/*     */       
/*  90 */       BlockEntity blockEntity = serverLevel.m_7702_(blockPos);
/*  91 */       if (blockEntity != null) {
/*  92 */         CompoundTag data = blockEntity.getPersistentData();
/*  93 */         if (!data.m_128441_("life")) {
/*  94 */           data.m_128405_("life", 25);
/*  95 */           blockEntity.m_6596_();
/*     */         } 
/*     */       }  }
/*     */     
/*  99 */     level.m_186460_(blockPos, this, 1);
/*     */   }
/*     */   
/*     */   public boolean conditionEveryTickEntityInside(Entity entity) {
/* 103 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void customHurtLogic(Entity entity, Entity owner, ServerLevel serverLevel, BlockPos blockPos) {}
/*     */ 
/*     */   
/*     */   public void m_213897_(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
/* 112 */     super.m_213897_(blockState, serverLevel, blockPos, randomSource);
/* 113 */     customTickSound(serverLevel, blockPos);
/*     */     
/* 115 */     for (Entity entity : serverLevel.m_45933_(null, new AABB(blockPos))) {
/* 116 */       runEntityInsideLogic(blockState, serverLevel, blockPos, entity);
/*     */     }
/*     */     
/* 119 */     BlockEntity blockEntity = serverLevel.m_7702_(blockPos);
/* 120 */     if (blockEntity != null) {
/* 121 */       CompoundTag data = blockEntity.getPersistentData();
/* 122 */       int life = data.m_128441_("life") ? data.m_128451_("life") : 25;
/*     */       
/* 124 */       if (life > 0) {
/* 125 */         data.m_128405_("life", life - 1);
/* 126 */         blockEntity.m_6596_();
/* 127 */         serverLevel.m_186460_(blockPos, this, 1);
/*     */         return;
/*     */       } 
/*     */     } else {
/* 131 */       serverLevel.m_186460_(blockPos, this, 1);
/*     */       
/*     */       return;
/*     */     } 
/* 135 */     BlockState current = serverLevel.m_8055_(blockPos);
/* 136 */     int replace = 0;
/* 137 */     if (current.m_60734_() instanceof HerobrineObsidianBlock && current.m_61138_((Property)REPLACE_BY_LIQUID)) {
/* 138 */       replace = ((Integer)current.m_61143_((Property)REPLACE_BY_LIQUID)).intValue();
/*     */     }
/*     */     
/* 141 */     switch (replace) { case 1: 
/*     */       case 2: 
/*     */       default:
/* 144 */         break; }  BlockState replacement = Blocks.f_50016_.m_49966_();
/*     */ 
/*     */     
/* 147 */     serverLevel.m_7731_(blockPos, replacement, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   private void runEntityInsideLogic(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull Entity entity) {
/* 152 */     if (!conditionEveryTickEntityInside(entity)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 157 */     boolean fromPlayer = (blockState.m_60734_() instanceof HerobrineObsidianBlock && blockState.m_61138_((Property)FROM_PLAYER) && ((Boolean)blockState.m_61143_((Property)FROM_PLAYER)).booleanValue());
/*     */     
/* 159 */     if (!fromPlayer && HerobrineUtil.isHerobrineFaction(entity)) {
/*     */       return;
/*     */     }
/* 162 */     if (entity instanceof Player && fromPlayer && !serverLevel.m_7654_().m_129799_()) {
/*     */       return;
/*     */     }
/*     */     
/* 166 */     Entity owner = null;
/*     */     
/* 168 */     BlockEntity blockEntity = serverLevel.m_7702_(blockPos);
/* 169 */     if (blockEntity instanceof ObsidianBlockEntity) { ObsidianBlockEntity obsidianBlockEntity = (ObsidianBlockEntity)blockEntity;
/* 170 */       UUID ownerUuid = obsidianBlockEntity.getOwner();
/* 171 */       if (ownerUuid != null) {
/* 172 */         if (ownerUuid.equals(entity.m_20148_()))
/* 173 */           return;  owner = fromPlayer ? (Entity)serverLevel.m_46003_(ownerUuid) : serverLevel.m_8791_(ownerUuid);
/*     */       }  }
/* 175 */     else if (blockEntity instanceof ShadowObsidianBlockEntity) { ShadowObsidianBlockEntity shadowObsidianBlockEntity = (ShadowObsidianBlockEntity)blockEntity;
/* 176 */       UUID ownerUuid = shadowObsidianBlockEntity.getOwner();
/* 177 */       if (ownerUuid != null) {
/* 178 */         if (ownerUuid.equals(entity.m_20148_()))
/* 179 */           return;  owner = fromPlayer ? (Entity)serverLevel.m_46003_(ownerUuid) : serverLevel.m_8791_(ownerUuid);
/*     */       }  }
/* 181 */     else if (blockEntity instanceof CryingObsidianBlockEntity) { CryingObsidianBlockEntity cryingObsidianBlockEntity = (CryingObsidianBlockEntity)blockEntity;
/* 182 */       UUID ownerUuid = cryingObsidianBlockEntity.getOwner();
/* 183 */       if (ownerUuid != null) {
/* 184 */         if (ownerUuid.equals(entity.m_20148_()))
/* 185 */           return;  owner = fromPlayer ? (Entity)serverLevel.m_46003_(ownerUuid) : serverLevel.m_8791_(ownerUuid);
/*     */       }  }
/* 187 */     else if (blockEntity instanceof ShadowObsidianShortPillarBlockEntity) { ShadowObsidianShortPillarBlockEntity shadowObsidianShortPillarBlockEntity = (ShadowObsidianShortPillarBlockEntity)blockEntity;
/* 188 */       UUID ownerUuid = shadowObsidianShortPillarBlockEntity.getOwner();
/* 189 */       if (ownerUuid != null) {
/* 190 */         if (ownerUuid.equals(entity.m_20148_()))
/* 191 */           return;  owner = fromPlayer ? (Entity)serverLevel.m_46003_(ownerUuid) : serverLevel.m_8791_(ownerUuid);
/*     */       }  }
/* 193 */     else if (blockEntity instanceof ShadowObsidianMiddlePillarBlockEntity) { ShadowObsidianMiddlePillarBlockEntity shadowObsidianMiddlePillarBlockEntity = (ShadowObsidianMiddlePillarBlockEntity)blockEntity;
/* 194 */       UUID ownerUuid = shadowObsidianMiddlePillarBlockEntity.getOwner();
/* 195 */       if (ownerUuid != null) {
/* 196 */         if (ownerUuid.equals(entity.m_20148_()))
/* 197 */           return;  owner = fromPlayer ? (Entity)serverLevel.m_46003_(ownerUuid) : serverLevel.m_8791_(ownerUuid);
/*     */       }  }
/* 199 */     else if (blockEntity instanceof ShadowObsidianLongPillarBlockEntity) { ShadowObsidianLongPillarBlockEntity shadowObsidianLongPillarBlockEntity = (ShadowObsidianLongPillarBlockEntity)blockEntity;
/* 200 */       UUID ownerUuid = shadowObsidianLongPillarBlockEntity.getOwner();
/* 201 */       if (ownerUuid != null) {
/* 202 */         if (ownerUuid.equals(entity.m_20148_()))
/* 203 */           return;  owner = fromPlayer ? (Entity)serverLevel.m_46003_(ownerUuid) : serverLevel.m_8791_(ownerUuid);
/*     */       }  }
/*     */ 
/*     */     
/* 207 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 208 */       CompoundTag data = player.getPersistentData();
/* 209 */       if (data.m_128441_("StunEscapeCooldown")) {
/* 210 */         int coolDownValue = data.m_128451_("StunEscapeCooldown");
/* 211 */         if (coolDownValue < 5) {
/* 212 */           data.m_128405_("StunEscapeCooldown", coolDownValue + 1);
/*     */         }
/*     */       }  }
/*     */ 
/*     */     
/* 217 */     if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 218 */       int currentValue = playerNpcEntity.getStunEscapeCooldown();
/* 219 */       if (currentValue < 100) {
/* 220 */         playerNpcEntity.setStunEscapeCooldown(currentValue + 20);
/*     */       } }
/*     */ 
/*     */     
/* 224 */     if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 225 */       int currentValue = herobrineMob.getStunEscapeCooldown();
/* 226 */       if (currentValue < 100) {
/* 227 */         herobrineMob.setStunEscapeCooldown(currentValue + 20);
/*     */       } }
/*     */ 
/*     */     
/* 231 */     if (entity instanceof AVNpc) { AVNpc avNpc = (AVNpc)entity;
/* 232 */       int currentValue = avNpc.getStunEscapeCooldown();
/* 233 */       if (currentValue < 100) {
/* 234 */         avNpc.setStunEscapeCooldown(currentValue + 20);
/*     */       } }
/*     */ 
/*     */     
/* 238 */     if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity;
/* 239 */       int currentValue = blueDemonEntity.getStunEscapeCooldown();
/* 240 */       if (currentValue < 100) {
/* 241 */         blueDemonEntity.setStunEscapeCooldown(currentValue + 20);
/*     */       } }
/*     */ 
/*     */     
/* 245 */     customHurtLogic(entity, owner, serverLevel, blockPos);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_6402_(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, LivingEntity placer, @NotNull ItemStack stack) {
/* 251 */     super.m_6402_(level, pos, state, placer, stack);
/*     */     
/* 253 */     if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 254 */       BlockEntity blockEntity = level.m_7702_(pos);
/* 255 */       if (blockEntity != null) {
/* 256 */         if (blockEntity instanceof ObsidianBlockEntity) { ObsidianBlockEntity obsidianBlockEntity = (ObsidianBlockEntity)blockEntity;
/* 257 */           obsidianBlockEntity.setOwner(placer.m_20148_()); }
/* 258 */         else if (blockEntity instanceof ShadowObsidianBlockEntity) { ShadowObsidianBlockEntity shadowObsidianBlockEntity = (ShadowObsidianBlockEntity)blockEntity;
/* 259 */           shadowObsidianBlockEntity.setOwner(placer.m_20148_()); }
/* 260 */         else if (blockEntity instanceof CryingObsidianBlockEntity) { CryingObsidianBlockEntity cryingObsidianBlockEntity = (CryingObsidianBlockEntity)blockEntity;
/* 261 */           cryingObsidianBlockEntity.setOwner(placer.m_20148_()); }
/* 262 */         else if (blockEntity instanceof ShadowObsidianShortPillarBlockEntity) { ShadowObsidianShortPillarBlockEntity shadowObsidianShortPillarBlockEntity = (ShadowObsidianShortPillarBlockEntity)blockEntity;
/* 263 */           shadowObsidianShortPillarBlockEntity.setOwner(placer.m_20148_()); }
/* 264 */         else if (blockEntity instanceof ShadowObsidianMiddlePillarBlockEntity) { ShadowObsidianMiddlePillarBlockEntity shadowObsidianMiddlePillarBlockEntity = (ShadowObsidianMiddlePillarBlockEntity)blockEntity;
/* 265 */           shadowObsidianMiddlePillarBlockEntity.setOwner(placer.m_20148_()); }
/* 266 */         else if (blockEntity instanceof ShadowObsidianLongPillarBlockEntity) { ShadowObsidianLongPillarBlockEntity shadowObsidianLongPillarBlockEntity = (ShadowObsidianLongPillarBlockEntity)blockEntity;
/* 267 */           shadowObsidianLongPillarBlockEntity.setOwner(placer.m_20148_()); }
/*     */ 
/*     */         
/* 270 */         CompoundTag data = blockEntity.getPersistentData();
/* 271 */         if (!data.m_128441_("life")) {
/* 272 */           data.m_128405_("life", 25);
/*     */         }
/*     */         
/* 275 */         blockEntity.m_6596_();
/* 276 */         serverLevel.m_7260_(pos, state, state, 3);
/*     */       }  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\HerobrineObsidianBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */