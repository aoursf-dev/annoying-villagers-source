/*    */ package com.pla.annoyingvillagers.entity.goal;
/*    */ 
/*    */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*    */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.world.entity.PathfinderMob;
/*    */ import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ public class LockedRandomStrollGoal
/*    */   extends WaterAvoidingRandomStrollGoal {
/*    */   public LockedRandomStrollGoal(PathfinderMob mob, double speed) {
/* 18 */     super(mob, speed);
/*    */   }
/*    */   
/*    */   private boolean isPlayingIdle() {
/* 22 */     PathfinderMob pathfinderMob = this.f_25725_; if (pathfinderMob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)pathfinderMob; return playerNpcEntity.isPlayingIdle(); }
/* 23 */      pathfinderMob = this.f_25725_; if (pathfinderMob instanceof AVNpc) { AVNpc avNpc = (AVNpc)pathfinderMob; return avNpc.isPlayingIdle(); }
/* 24 */      return false;
/*    */   }
/*    */   
/*    */   private void setStrolling(boolean strolling) {
/* 28 */     PathfinderMob pathfinderMob = this.f_25725_; if (pathfinderMob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)pathfinderMob; playerNpcEntity.setStrolling(strolling); }
/* 29 */      pathfinderMob = this.f_25725_; if (pathfinderMob instanceof AVNpc) { AVNpc avNpc = (AVNpc)pathfinderMob; avNpc.setStrolling(strolling); }
/*    */   
/*    */   }
/*    */   
/*    */   public boolean m_8036_() {
/* 34 */     if (this.f_25725_.m_5448_() != null) return false; 
/* 35 */     if (isPlayingIdle()) return false; 
/* 36 */     LivingEntityPatch<?> patch = null;
/* 37 */     PathfinderMob pathfinderMob = this.f_25725_; if (pathfinderMob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)pathfinderMob;
/* 38 */       patch = playerNpcEntity.getLivingEntityPatch(); }
/*    */     
/* 40 */     pathfinderMob = this.f_25725_; if (pathfinderMob instanceof AVNpc) { AVNpc avNpc = (AVNpc)pathfinderMob;
/* 41 */       patch = avNpc.getLivingEntityPatch(); }
/*    */     
/* 43 */     if (patch == null) return false; 
/* 44 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 45 */     if (EpicfightUtil.isLongHitAnimation(dynamicAnimation, patch)) return false; 
/* 46 */     return super.m_8036_();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_8045_() {
/* 51 */     if (this.f_25725_.m_5448_() != null) return false; 
/* 52 */     if (isPlayingIdle()) return false; 
/* 53 */     LivingEntityPatch<?> patch = null;
/* 54 */     PathfinderMob pathfinderMob = this.f_25725_; if (pathfinderMob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)pathfinderMob;
/* 55 */       patch = playerNpcEntity.getLivingEntityPatch(); }
/*    */     
/* 57 */     pathfinderMob = this.f_25725_; if (pathfinderMob instanceof AVNpc) { AVNpc avNpc = (AVNpc)pathfinderMob;
/* 58 */       patch = avNpc.getLivingEntityPatch(); }
/*    */     
/* 60 */     if (patch == null) return false; 
/* 61 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 62 */     if (EpicfightUtil.isLongHitAnimation(dynamicAnimation, patch)) return false; 
/* 63 */     return super.m_8045_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8056_() {
/* 68 */     setStrolling(true);
/* 69 */     LivingEntityPatch<?> patch = null;
/* 70 */     PathfinderMob pathfinderMob = this.f_25725_; if (pathfinderMob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)pathfinderMob;
/* 71 */       patch = playerNpcEntity.getLivingEntityPatch(); }
/*    */     
/* 73 */     pathfinderMob = this.f_25725_; if (pathfinderMob instanceof AVNpc) { AVNpc avNpc = (AVNpc)pathfinderMob;
/* 74 */       patch = avNpc.getLivingEntityPatch(); }
/*    */     
/* 76 */     if (patch != null) {
/* 77 */       patch.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F);
/*    */     }
/* 79 */     super.m_8056_();
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_8041_() {
/* 84 */     setStrolling(false);
/* 85 */     super.m_8041_();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\goal\LockedRandomStrollGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */