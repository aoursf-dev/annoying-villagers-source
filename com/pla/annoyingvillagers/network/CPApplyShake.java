/*    */ package com.pla.annoyingvillagers.network;
/*    */ 
/*    */ import com.pla.annoyingvillagers.client.engine.CameraEngine;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraftforge.network.NetworkEvent;
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
/*    */ public class CPApplyShake
/*    */ {
/*    */   private final int time;
/*    */   private final float strength;
/*    */   private final float frequency;
/*    */   private final int decay_time;
/*    */   
/*    */   public CPApplyShake(int time, float strength, float frequency, int decay_time) {
/* 34 */     this.time = time;
/* 35 */     this.strength = strength;
/* 36 */     this.frequency = frequency;
/* 37 */     this.decay_time = decay_time;
/*    */   }
/*    */   public CPApplyShake(FriendlyByteBuf buf) {
/* 40 */     this.time = buf.readInt();
/* 41 */     this.strength = buf.readFloat();
/* 42 */     this.frequency = buf.readFloat();
/* 43 */     this.decay_time = buf.readInt();
/*    */   }
/*    */   public void encode(FriendlyByteBuf buf) {
/* 46 */     buf.writeInt(this.time);
/* 47 */     buf.writeFloat(this.strength);
/* 48 */     buf.writeFloat(this.frequency);
/* 49 */     buf.writeInt(this.decay_time);
/*    */   }
/*    */   
/*    */   public void handle(Supplier<NetworkEvent.Context> context) {
/* 53 */     NetworkEvent.Context ctx = context.get();
/* 54 */     ctx.enqueueWork(() -> {
/*    */           CameraEngine engine = CameraEngine.getInstance();
/*    */           if (engine != null) {
/*    */             engine.shakeCamera(this.strength, this.time, this.frequency, this.decay_time);
/*    */           }
/*    */         });
/* 60 */     ctx.setPacketHandled(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\network\CPApplyShake.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */