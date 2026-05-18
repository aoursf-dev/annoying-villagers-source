/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import reascer.wom.world.entity.mob.EnderHand;
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
/*    */ class null
/*    */   extends DelayedTask
/*    */ {
/*    */   null(int waitTicks) {
/* 61 */     super(waitTicks);
/*    */   }
/*    */   public void run() {
/* 64 */     EnderHand enderHand = new EnderHand(serverLevel, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), livingEntity, livingExploded);
/* 65 */     serverLevel.m_7967_((Entity)enderHand);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\ExplosionDamageEvent$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */