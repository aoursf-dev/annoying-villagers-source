/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.PathfinderMob;
/*    */ import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
/*    */ import net.minecraft.world.entity.monster.Monster;
/*    */ import org.jetbrains.annotations.NotNull;
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
/*    */   extends MeleeAttackGoal
/*    */ {
/*    */   null(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
/* 39 */     super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
/*    */   } protected double m_6639_(@NotNull LivingEntity livingEntity) {
/* 41 */     return (monster.m_20205_() * monster.m_20205_() + livingEntity.m_20205_());
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\CommonGoals$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */