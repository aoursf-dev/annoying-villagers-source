/*    */ package com.pla.annoyingvillagers.blockentity;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlockEntities;
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.world.level.block.entity.BlockEntity;
/*    */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class ShadowObsidianLongPillarBlockEntity
/*    */   extends BlockEntity
/*    */ {
/*    */   public ShadowObsidianLongPillarBlockEntity(BlockPos pos, BlockState state) {
/* 17 */     super((BlockEntityType)AnnoyingVillagersModBlockEntities.SHADOW_OBSIDIAN_LONG_PILLAR.get(), pos, state);
/*    */   } @Nullable
/*    */   private UUID owner;
/*    */   public void setOwner(@Nullable UUID id) {
/* 21 */     this.owner = id;
/* 22 */     m_6596_();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public UUID getOwner() {
/* 27 */     return this.owner;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void m_183515_(@NotNull CompoundTag tag) {
/* 32 */     super.m_183515_(tag);
/* 33 */     if (this.owner != null) tag.m_128362_("Owner", this.owner);
/*    */   
/*    */   }
/*    */   
/*    */   public void m_142466_(@NotNull CompoundTag tag) {
/* 38 */     super.m_142466_(tag);
/* 39 */     this.owner = tag.m_128403_("Owner") ? tag.m_128342_("Owner") : null;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public CompoundTag m_5995_() {
/* 44 */     CompoundTag tag = super.m_5995_();
/* 45 */     if (this.owner != null) tag.m_128362_("Owner", this.owner); 
/* 46 */     return tag;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\blockentity\ShadowObsidianLongPillarBlockEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */