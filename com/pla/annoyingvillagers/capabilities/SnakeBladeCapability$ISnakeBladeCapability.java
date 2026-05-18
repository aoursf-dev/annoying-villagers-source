package com.pla.annoyingvillagers.capabilities;

import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface ISnakeBladeCapability extends INBTSerializable<CompoundTag> {
  void setHasSnakeBlade(boolean paramBoolean);
  
  boolean hasSnakeBlade();
  
  void setLastSnakeBladeID(int paramInt);
  
  int getLastSnakeBladeID();
  
  @Nullable
  UUID getLastSnakeBladeUUID();
  
  void setLastSnakeBladeUUID(@Nullable UUID paramUUID);
}


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\capabilities\SnakeBladeCapability$ISnakeBladeCapability.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */