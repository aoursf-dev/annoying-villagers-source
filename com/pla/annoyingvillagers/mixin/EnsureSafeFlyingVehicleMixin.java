package com.pla.annoyingvillagers.mixin;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ServerGamePacketListenerImpl.class})
public class EnsureSafeFlyingVehicleMixin {
  @Shadow
  private boolean f_9738_;
  
  @Redirect(method = {"handleMoveVehicle(Lnet/minecraft/network/protocol/game/ServerboundMoveVehiclePacket;)V"}, at = @At(value = "FIELD", target = "Lnet/minecraft/server/network/ServerGamePacketListenerImpl;clientVehicleIsFloating:Z", opcode = 181))
  private void dragonmounts_ensureSafeFlyingVehicle(ServerGamePacketListenerImpl impl, boolean flag) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual m_142253_ : ()Lnet/minecraft/server/level/ServerPlayer;
    //   5: invokevirtual m_20201_ : ()Lnet/minecraft/world/entity/Entity;
    //   8: astore #4
    //   10: aload #4
    //   12: instanceof net/minecraft/world/entity/animal/FlyingAnimal
    //   15: ifeq -> 33
    //   18: aload #4
    //   20: checkcast net/minecraft/world/entity/animal/FlyingAnimal
    //   23: astore_3
    //   24: aload_3
    //   25: invokeinterface m_29443_ : ()Z
    //   30: ifne -> 41
    //   33: iload_2
    //   34: ifeq -> 41
    //   37: iconst_1
    //   38: goto -> 42
    //   41: iconst_0
    //   42: putfield f_9738_ : Z
    //   45: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #24	-> 0
    //   #25	-> 45
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   24	9	3	a	Lnet/minecraft/world/entity/animal/FlyingAnimal;
    //   0	46	0	this	Lcom/pla/annoyingvillagers/mixin/EnsureSafeFlyingVehicleMixin;
    //   0	46	1	impl	Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
    //   0	46	2	flag	Z
  }
}


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\EnsureSafeFlyingVehicleMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */