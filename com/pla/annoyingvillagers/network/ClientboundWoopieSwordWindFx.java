/*    */ package com.pla.annoyingvillagers.network;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ 
/*    */ public final class ClientboundWoopieSwordWindFx extends Record {
/*    */   private final Vec3 from;
/*    */   
/* 12 */   public ClientboundWoopieSwordWindFx(Vec3 from) { this.from = from; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/network/ClientboundWoopieSwordWindFx;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Lcom/pla/annoyingvillagers/network/ClientboundWoopieSwordWindFx; } public Vec3 from() { return this.from; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/network/ClientboundWoopieSwordWindFx;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/pla/annoyingvillagers/network/ClientboundWoopieSwordWindFx; }
/*    */   public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/network/ClientboundWoopieSwordWindFx;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lcom/pla/annoyingvillagers/network/ClientboundWoopieSwordWindFx;
/*    */     //   0	8	1	o	Ljava/lang/Object; } public static void encode(ClientboundWoopieSwordWindFx msg, FriendlyByteBuf buf) {
/* 15 */     buf.writeDouble(msg.from.f_82479_);
/* 16 */     buf.writeDouble(msg.from.f_82480_);
/* 17 */     buf.writeDouble(msg.from.f_82481_);
/*    */   }
/*    */   
/*    */   public static ClientboundWoopieSwordWindFx decode(FriendlyByteBuf buf) {
/* 21 */     Vec3 f = new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
/* 22 */     return new ClientboundWoopieSwordWindFx(f);
/*    */   }
/*    */   
/*    */   public static void handle(ClientboundWoopieSwordWindFx msg, Supplier<NetworkEvent.Context> ctx) {
/* 26 */     NetworkEvent.Context c = ctx.get();
/* 27 */     c.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, ()));
/*    */ 
/*    */     
/* 30 */     c.setPacketHandled(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\network\ClientboundWoopieSwordWindFx.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */