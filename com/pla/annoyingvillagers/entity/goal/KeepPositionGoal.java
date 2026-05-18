/*    */ package com.pla.annoyingvillagers.entity.goal;
/*    */ 
/*    */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*    */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*    */ import com.pla.annoyingvillagers.combatbehaviour.CombatCommon;
/*    */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*    */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.ai.goal.Goal;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*    */ 
/*    */ public class KeepPositionGoal
/*    */   extends Goal {
/*    */   private final Mob mob;
/*    */   private double anchorX;
/*    */   private double anchorY;
/*    */   private double anchorZ;
/*    */   
/*    */   public KeepPositionGoal(Mob mob) {
/* 23 */     this.mob = mob;
/* 24 */     m_7021_(EnumSet.of(Goal.Flag.MOVE));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8036_() {
/* 29 */     Mob mob = this.mob; if (mob instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)mob;
/* 30 */       return CombatCommon.canEscape((MobPatch)herobrineMob.getLivingEntityPatch()); }
/*    */     
/* 32 */     mob = this.mob; if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob;
/* 33 */       return CombatCommon.canEscape((MobPatch)playerNpcEntity.getLivingEntityPatch()); }
/*    */     
/* 35 */     mob = this.mob; if (mob instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob;
/* 36 */       return CombatCommon.canEscape((MobPatch)avNpc.getLivingEntityPatch()); }
/*    */     
/* 38 */     mob = this.mob; if (mob instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)mob;
/* 39 */       return CombatCommon.canEscape((MobPatch)blueDemonEntity.getLivingEntityPatch()); }
/*    */     
/* 41 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 46 */     Mob mob = this.mob; if (mob instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)mob;
/* 47 */       return CombatCommon.canEscape((MobPatch)herobrineMob.getLivingEntityPatch()); }
/*    */     
/* 49 */     mob = this.mob; if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob;
/* 50 */       return CombatCommon.canEscape((MobPatch)playerNpcEntity.getLivingEntityPatch()); }
/*    */     
/* 52 */     mob = this.mob; if (mob instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob;
/* 53 */       return CombatCommon.canEscape((MobPatch)avNpc.getLivingEntityPatch()); }
/*    */     
/* 55 */     mob = this.mob; if (mob instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)mob;
/* 56 */       return CombatCommon.canEscape((MobPatch)blueDemonEntity.getLivingEntityPatch()); }
/*    */     
/* 58 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 63 */     this.anchorX = this.mob.m_20185_();
/* 64 */     this.anchorY = this.mob.m_20186_();
/* 65 */     this.anchorZ = this.mob.m_20189_();
/* 66 */     this.mob.m_21573_().m_26573_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 71 */     this.mob.m_21573_().m_26573_();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_183429_() {
/* 76 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8037_() {
/* 81 */     this.mob.m_21573_().m_26573_();
/*    */     
/* 83 */     LivingEntity target = this.mob.m_5448_();
/* 84 */     if (target != null) {
/* 85 */       this.mob.m_21563_().m_24960_((Entity)target, 30.0F, 30.0F);
/*    */     }
/*    */     
/* 88 */     if (this.mob.m_20275_(this.anchorX, this.anchorY, this.anchorZ) > 0.25D)
/* 89 */       this.mob.m_21566_().m_6849_(this.anchorX, this.anchorY, this.anchorZ, 1.0D); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\goal\KeepPositionGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */