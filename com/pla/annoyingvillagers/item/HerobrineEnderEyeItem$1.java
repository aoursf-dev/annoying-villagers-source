/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.BlockProjectileEntity;
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
/* 65 */     super(waitTicks);
/*    */   } public void run() {
/* 67 */     if (!shooter.m_6084_()) {
/* 68 */       if (up != null && up.m_6084_()) up.m_146870_(); 
/* 69 */       if (left != null && left.m_6084_()) left.m_146870_(); 
/* 70 */       if (right != null && right.m_6084_()) right.m_146870_();
/*    */       
/*    */       return;
/*    */     } 
/* 74 */     Vec3 to = HerobrineEnderEyeItem.lookTarget(shooter, 16.0D);
/* 75 */     HerobrineEnderEyeItem.shootOne(up, to, 2.0D);
/* 76 */     HerobrineEnderEyeItem.shootOne(left, to, 2.0D);
/* 77 */     HerobrineEnderEyeItem.shootOne(right, to, 2.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\HerobrineEnderEyeItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */