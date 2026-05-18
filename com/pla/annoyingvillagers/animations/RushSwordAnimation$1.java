/*    */ package com.pla.annoyingvillagers.animations;
/*    */ 
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.phys.Vec3;
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
/* 44 */     super(waitTicks);
/*    */   } public void run() {
/* 46 */     Vec3 cur = livingEntity.m_20184_();
/* 47 */     livingEntity.m_20334_(cur.f_82479_ + dash.f_82479_, cur.f_82480_ + dash.f_82480_, cur.f_82481_ + dash.f_82481_);
/* 48 */     livingEntity.f_19812_ = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\animations\RushSwordAnimation$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */