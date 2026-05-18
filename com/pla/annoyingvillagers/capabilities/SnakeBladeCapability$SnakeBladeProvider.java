/*     */ package com.pla.annoyingvillagers.capabilities;
/*     */ 
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModCapabilities;
/*     */ import javax.annotation.Nonnull;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.common.capabilities.ICapabilitySerializable;
/*     */ import net.minecraftforge.common.util.LazyOptional;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SnakeBladeProvider
/*     */   implements ICapabilitySerializable<CompoundTag>
/*     */ {
/*  93 */   private final SnakeBladeCapability.SnakeBladeCapabilityImp impl = new SnakeBladeCapability.SnakeBladeCapabilityImp();
/*  94 */   private final LazyOptional<SnakeBladeCapability.ISnakeBladeCapability> optional = LazyOptional.of(() -> this.impl);
/*     */ 
/*     */   
/*     */   public CompoundTag serializeNBT() {
/*  98 */     return this.impl.serializeNBT();
/*     */   }
/*     */ 
/*     */   
/*     */   public void deserializeNBT(CompoundTag nbt) {
/* 103 */     this.impl.deserializeNBT(nbt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
/* 109 */     return (cap == AnnoyingVillagersModCapabilities.SNAKE_BLADE_CAPABILITY) ? 
/* 110 */       this.optional.cast() : 
/* 111 */       LazyOptional.empty();
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\capabilities\SnakeBladeCapability$SnakeBladeProvider.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */