/*     */ package com.pla.annoyingvillagers.capabilities;
/*     */ 
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModCapabilities;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nonnull;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.common.capabilities.ICapabilitySerializable;
/*     */ import net.minecraftforge.common.util.INBTSerializable;
/*     */ import net.minecraftforge.common.util.LazyOptional;
/*     */ 
/*     */ 
/*     */ public final class SnakeBladeCapability
/*     */ {
/*  19 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "snake_blade_cap");
/*     */   private static final String NBT_HAS_SNAKE_BLADE = "hasSnakeBlade";
/*     */   private static final String NBT_LAST_ID = "getLastSnakeBladeID";
/*     */   private static final String NBT_LAST_UUID = "getLastSnakeBladeUUID";
/*     */   
/*     */   public static interface ISnakeBladeCapability extends INBTSerializable<CompoundTag> {
/*     */     void setHasSnakeBlade(boolean param1Boolean);
/*     */     
/*     */     boolean hasSnakeBlade();
/*     */     
/*     */     void setLastSnakeBladeID(int param1Int);
/*     */     
/*     */     int getLastSnakeBladeID();
/*     */     
/*     */     @Nullable
/*     */     UUID getLastSnakeBladeUUID();
/*     */     
/*     */     void setLastSnakeBladeUUID(@Nullable UUID param1UUID); }
/*     */   
/*     */   public static final class SnakeBladeCapabilityImp implements ISnakeBladeCapability {
/*     */     private boolean hasSnakeBlade;
/*  40 */     private int lastSnakeBladeId = -1;
/*     */     @Nullable
/*     */     private UUID lastSnakeBladeUuid;
/*     */     
/*     */     public void setHasSnakeBlade(boolean hasSnakeBlade) {
/*  45 */       this.hasSnakeBlade = hasSnakeBlade;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasSnakeBlade() {
/*  50 */       return this.hasSnakeBlade;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setLastSnakeBladeID(int id) {
/*  55 */       this.lastSnakeBladeId = id;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getLastSnakeBladeID() {
/*  60 */       return this.lastSnakeBladeId;
/*     */     }
/*     */     
/*     */     @Nullable
/*     */     public UUID getLastSnakeBladeUUID() {
/*  65 */       return this.lastSnakeBladeUuid;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setLastSnakeBladeUUID(@Nullable UUID uuid) {
/*  70 */       this.lastSnakeBladeUuid = uuid;
/*     */     }
/*     */ 
/*     */     
/*     */     public CompoundTag serializeNBT() {
/*  75 */       CompoundTag tag = new CompoundTag();
/*  76 */       tag.m_128379_("hasSnakeBlade", this.hasSnakeBlade);
/*  77 */       tag.m_128405_("getLastSnakeBladeID", this.lastSnakeBladeId);
/*  78 */       if (this.lastSnakeBladeUuid != null) {
/*  79 */         tag.m_128362_("getLastSnakeBladeUUID", this.lastSnakeBladeUuid);
/*     */       }
/*  81 */       return tag;
/*     */     }
/*     */ 
/*     */     
/*     */     public void deserializeNBT(CompoundTag nbt) {
/*  86 */       this.hasSnakeBlade = nbt.m_128471_("hasSnakeBlade");
/*  87 */       this.lastSnakeBladeId = nbt.m_128441_("getLastSnakeBladeID") ? nbt.m_128451_("getLastSnakeBladeID") : -1;
/*  88 */       this.lastSnakeBladeUuid = nbt.m_128403_("getLastSnakeBladeUUID") ? nbt.m_128342_("getLastSnakeBladeUUID") : null;
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class SnakeBladeProvider implements ICapabilitySerializable<CompoundTag> {
/*  93 */     private final SnakeBladeCapability.SnakeBladeCapabilityImp impl = new SnakeBladeCapability.SnakeBladeCapabilityImp();
/*  94 */     private final LazyOptional<SnakeBladeCapability.ISnakeBladeCapability> optional = LazyOptional.of(() -> this.impl);
/*     */ 
/*     */     
/*     */     public CompoundTag serializeNBT() {
/*  98 */       return this.impl.serializeNBT();
/*     */     }
/*     */ 
/*     */     
/*     */     public void deserializeNBT(CompoundTag nbt) {
/* 103 */       this.impl.deserializeNBT(nbt);
/*     */     }
/*     */ 
/*     */     
/*     */     @Nonnull
/*     */     public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
/* 109 */       return (cap == AnnoyingVillagersModCapabilities.SNAKE_BLADE_CAPABILITY) ? 
/* 110 */         this.optional.cast() : 
/* 111 */         LazyOptional.empty();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\capabilities\SnakeBladeCapability.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */