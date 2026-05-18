/*    */ package com.pla.annoyingvillagers.network;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ 
/*    */ public final class ClientboundMuteExplosionAtPos extends Record {
/*    */   private final BlockPos pos;
/*    */   private final int lifetimeTicks;
/*    */   
/* 12 */   public ClientboundMuteExplosionAtPos(BlockPos pos, int lifetimeTicks) { this.pos = pos; this.lifetimeTicks = lifetimeTicks; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/network/ClientboundMuteExplosionAtPos;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Lcom/pla/annoyingvillagers/network/ClientboundMuteExplosionAtPos; } public BlockPos pos() { return this.pos; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/network/ClientboundMuteExplosionAtPos;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lcom/pla/annoyingvillagers/network/ClientboundMuteExplosionAtPos; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/network/ClientboundMuteExplosionAtPos;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lcom/pla/annoyingvillagers/network/ClientboundMuteExplosionAtPos;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public int lifetimeTicks() { return this.lifetimeTicks; }
/*    */   
/*    */   public static void encode(ClientboundMuteExplosionAtPos msg, FriendlyByteBuf buf) {
/* 15 */     buf.m_130064_(msg.pos);
/* 16 */     buf.m_130130_(msg.lifetimeTicks);
/*    */   }
/*    */   
/*    */   public static ClientboundMuteExplosionAtPos decode(FriendlyByteBuf buf) {
/* 20 */     return new ClientboundMuteExplosionAtPos(buf.m_130135_(), buf.m_130242_());
/*    */   }
/*    */   
/*    */   public static void handle(ClientboundMuteExplosionAtPos msg, Supplier<NetworkEvent.Context> ctx) {
/* 24 */     NetworkEvent.Context c = ctx.get();
/* 25 */     c.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, ()));
/*    */ 
/*    */     
/* 28 */     c.setPacketHandled(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\network\ClientboundMuteExplosionAtPos.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */