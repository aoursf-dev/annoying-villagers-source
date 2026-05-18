/*    */ package com.pla.annoyingvillagers.entity.goal;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.BbqEntity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.PathfinderMob;
/*    */ import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public class EscapeAvoidGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
/*    */   private final BbqEntity mob;
/*    */   
/*    */   public EscapeAvoidGoal(BbqEntity mob, Class<T> avoidClass, float maxDistance, double walkSpeed, double sprintSpeed) {
/* 14 */     super((PathfinderMob)mob, avoidClass, maxDistance, walkSpeed, sprintSpeed);
/* 15 */     this.mob = mob;
/*    */   }
/*    */   
/*    */   private boolean isRealEscapeThreat(@Nullable LivingEntity target) {
/* 19 */     if (target == null || !target.m_6084_()) {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     if (target == this.mob) {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     if (target instanceof com.pla.annoyingvillagers.entity.BlueDemonEntity) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (target instanceof Player) { Player player = (Player)target; if (player.m_7500_() || player.m_5833_()) {
/* 32 */         return false;
/*    */       } }
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 40 */     if (!this.mob.isEscapeMode() || this.mob.getSauceLeader() != null) {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (!super.m_8036_()) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     return isRealEscapeThreat(this.f_25016_);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 53 */     if (!this.mob.isEscapeMode() || this.mob.getSauceLeader() != null) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     return (super.m_8045_() && isRealEscapeThreat(this.f_25016_));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\goal\EscapeAvoidGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */