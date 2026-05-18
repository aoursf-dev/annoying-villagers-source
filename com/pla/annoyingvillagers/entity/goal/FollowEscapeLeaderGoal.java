/*    */ package com.pla.annoyingvillagers.entity.goal;
/*    */ import com.pla.annoyingvillagers.clazz.SauceType;
/*    */ import com.pla.annoyingvillagers.entity.BbqEntity;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ 
/*    */ public class FollowEscapeLeaderGoal extends Goal {
/*    */   private final BbqEntity mob;
/*    */   
/*    */   public FollowEscapeLeaderGoal(BbqEntity mob) {
/* 14 */     this.mob = mob;
/* 15 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 20 */     return (this.mob.isEscapeMode() && this.mob.getSauceLeader() != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 25 */     return (this.mob.isEscapeMode() && this.mob.getSauceLeader() != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 30 */     BbqEntity leader = this.mob.getSauceLeader();
/* 31 */     if (leader == null) {
/*    */       return;
/*    */     }
/*    */     
/* 35 */     if (this.mob.m_20280_((Entity)leader) > 324.0D) {
/* 36 */       this.mob.m_6021_(leader.m_20185_(), leader.m_20186_(), leader.m_20189_());
/*    */       
/*    */       return;
/*    */     } 
/* 40 */     Vec3 forward = leader.m_20184_();
/* 41 */     forward = new Vec3(forward.f_82479_, 0.0D, forward.f_82481_);
/*    */     
/* 43 */     if (forward.m_82556_() < 1.0E-4D) {
/* 44 */       float yawRad = leader.m_146908_() * 0.017453292F;
/* 45 */       forward = new Vec3(-Mth.m_14031_(yawRad), 0.0D, Mth.m_14089_(yawRad));
/*    */     } else {
/* 47 */       forward = forward.m_82541_();
/*    */     } 
/*    */     
/* 50 */     switch (this.mob.getSauceType()) { case HONEY_MUSTARD_SAUCE: 
/*    */       case SOY_SAUCE: 
/*    */       case SWEET_ONION_SAUCE: 
/*    */       default:
/* 54 */         break; }  double followDistance = 1.2D;
/*    */ 
/*    */     
/* 57 */     Vec3 desired = leader.m_20182_().m_82546_(forward.m_82490_(followDistance));
/* 58 */     this.mob.m_21563_().m_24960_((Entity)leader, 30.0F, 30.0F);
/*    */     
/* 60 */     if (this.mob.isEscapeFlying()) {
/* 61 */       double y = leader.m_20186_() + this.mob.getEscapeFlightHeight();
/*    */       
/* 63 */       if (this.mob.getSauceType() == SauceType.SWEET_ONION_SAUCE) {
/* 64 */         y += 0.35D;
/*    */       }
/*    */       
/* 67 */       this.mob.m_21573_().m_26573_();
/* 68 */       this.mob.m_20242_(true);
/* 69 */       this.mob.f_19789_ = 0.0F;
/* 70 */       this.mob.moveEscapeAerialTowards(desired.f_82479_, y, desired.f_82481_, 0.2D, 0.88D);
/*    */     } else {
/* 72 */       this.mob.m_20242_(false);
/* 73 */       this.mob.f_19789_ = 0.0F;
/*    */       
/* 75 */       if (this.mob.m_20275_(desired.f_82479_, leader.m_20186_(), desired.f_82481_) > 1.0D) {
/* 76 */         this.mob.m_21573_().m_26519_(desired.f_82479_, leader.m_20186_(), desired.f_82481_, 2.0D);
/*    */       } else {
/* 78 */         this.mob.m_21573_().m_26573_();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 85 */     this.mob.m_21573_().m_26573_();
/* 86 */     this.mob.m_20242_(false);
/* 87 */     this.mob.f_19789_ = 0.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\goal\FollowEscapeLeaderGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */