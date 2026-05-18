/*    */ package com.pla.annoyingvillagers.capabilities;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.nbt.Tag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SnakeBladeCapabilityImp
/*    */   implements SnakeBladeCapability.ISnakeBladeCapability
/*    */ {
/*    */   private boolean hasSnakeBlade;
/* 40 */   private int lastSnakeBladeId = -1;
/*    */   @Nullable
/*    */   private UUID lastSnakeBladeUuid;
/*    */   
/*    */   public void setHasSnakeBlade(boolean hasSnakeBlade) {
/* 45 */     this.hasSnakeBlade = hasSnakeBlade;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasSnakeBlade() {
/* 50 */     return this.hasSnakeBlade;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLastSnakeBladeID(int id) {
/* 55 */     this.lastSnakeBladeId = id;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLastSnakeBladeID() {
/* 60 */     return this.lastSnakeBladeId;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public UUID getLastSnakeBladeUUID() {
/* 65 */     return this.lastSnakeBladeUuid;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLastSnakeBladeUUID(@Nullable UUID uuid) {
/* 70 */     this.lastSnakeBladeUuid = uuid;
/*    */   }
/*    */ 
/*    */   
/*    */   public CompoundTag serializeNBT() {
/* 75 */     CompoundTag tag = new CompoundTag();
/* 76 */     tag.m_128379_("hasSnakeBlade", this.hasSnakeBlade);
/* 77 */     tag.m_128405_("getLastSnakeBladeID", this.lastSnakeBladeId);
/* 78 */     if (this.lastSnakeBladeUuid != null) {
/* 79 */       tag.m_128362_("getLastSnakeBladeUUID", this.lastSnakeBladeUuid);
/*    */     }
/* 81 */     return tag;
/*    */   }
/*    */ 
/*    */   
/*    */   public void deserializeNBT(CompoundTag nbt) {
/* 86 */     this.hasSnakeBlade = nbt.m_128471_("hasSnakeBlade");
/* 87 */     this.lastSnakeBladeId = nbt.m_128441_("getLastSnakeBladeID") ? nbt.m_128451_("getLastSnakeBladeID") : -1;
/* 88 */     this.lastSnakeBladeUuid = nbt.m_128403_("getLastSnakeBladeUUID") ? nbt.m_128342_("getLastSnakeBladeUUID") : null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\capabilities\SnakeBladeCapability$SnakeBladeCapabilityImp.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */