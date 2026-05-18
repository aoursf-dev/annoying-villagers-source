/*    */ package com.pla.annoyingvillagers.client.engine;
/*    */ 
/*    */ import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
/*    */ import java.util.Set;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BoltOwnerData
/*    */ {
/* 70 */   private final Set<ThunderRender.ThunderInstance> bolts = (Set<ThunderRender.ThunderInstance>)new ObjectOpenHashSet();
/*    */   private ThunderRender.ThunderData lastBolt;
/* 72 */   private ThunderRender.Timestamp lastBoltTimestamp = new ThunderRender.Timestamp();
/* 73 */   private ThunderRender.Timestamp lastUpdateTimestamp = new ThunderRender.Timestamp();
/*    */   private double lastBoltDelay;
/*    */   
/*    */   private void addBolt(ThunderRender.ThunderInstance instance, ThunderRender.Timestamp timestamp) {
/* 77 */     this.bolts.add(instance);
/* 78 */     this.lastBoltDelay = instance.bolt.getSpawnFunction().getSpawnDelay(ThunderRender.this.random);
/* 79 */     this.lastBoltTimestamp = timestamp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\ThunderRender$BoltOwnerData.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */