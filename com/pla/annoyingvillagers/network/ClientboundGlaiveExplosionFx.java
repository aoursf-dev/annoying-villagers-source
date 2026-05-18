/*    */ package com.pla.annoyingvillagers.network;
/*    */ 
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ 
/*    */ public final class ClientboundGlaiveExplosionFx extends Record {
/*    */   private final Vec3 from;
/*    */   private final Vec3 to;
/*    */   
/* 12 */   public ClientboundGlaiveExplosionFx(Vec3 from, Vec3 to) { this.from = from; this.to = to; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/network/ClientboundGlaiveExplosionFx;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Lcom/pla/annoyingvillagers/network/ClientboundGlaiveExplosionFx; } public Vec3 from() { return this.from; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/network/ClientboundGlaiveExplosionFx;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/pla/annoyingvillagers/network/ClientboundGlaiveExplosionFx; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/network/ClientboundGlaiveExplosionFx;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lcom/pla/annoyingvillagers/network/ClientboundGlaiveExplosionFx;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public Vec3 to() { return this.to; }
/*    */   
/*    */   public static void encode(ClientboundGlaiveExplosionFx msg, FriendlyByteBuf buf) {
/* 15 */     buf.writeDouble(msg.from.f_82479_);
/* 16 */     buf.writeDouble(msg.from.f_82480_);
/* 17 */     buf.writeDouble(msg.from.f_82481_);
/* 18 */     buf.writeDouble(msg.to.f_82479_);
/* 19 */     buf.writeDouble(msg.to.f_82480_);
/* 20 */     buf.writeDouble(msg.to.f_82481_);
/*    */   }
/*    */   
/*    */   public static ClientboundGlaiveExplosionFx decode(FriendlyByteBuf buf) {
/* 24 */     Vec3 f = new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
/* 25 */     Vec3 t = new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
/* 26 */     return new ClientboundGlaiveExplosionFx(f, t);
/*    */   }
/*    */   
/*    */   public static void handle(ClientboundGlaiveExplosionFx msg, Supplier<NetworkEvent.Context> ctx) {
/* 30 */     NetworkEvent.Context c = ctx.get();
/* 31 */     c.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, ()));
/*    */ 
/*    */     
/* 34 */     c.setPacketHandled(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\network\ClientboundGlaiveExplosionFx.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */