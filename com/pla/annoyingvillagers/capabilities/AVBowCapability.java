/*    */ package com.pla.annoyingvillagers.capabilities;
/*    */ 
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.UseAnim;
/*    */ import yesman.epicfight.api.animation.LivingMotion;
/*    */ import yesman.epicfight.api.animation.LivingMotions;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*    */ import yesman.epicfight.world.capabilities.item.WeaponCapability;
/*    */ 
/*    */ public class AVBowCapability extends WeaponCapability {
/*    */   public AVBowCapability(CapabilityItem.Builder builder) {
/* 14 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public UseAnim getUseAnimation(LivingEntityPatch<?> livingEntityPatch) {
/* 19 */     return UseAnim.BOW;
/*    */   }
/*    */ 
/*    */   
/*    */   public LivingMotion getLivingMotion(LivingEntityPatch<?> livingEntityPatch, InteractionHand hand) {
/* 24 */     LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/*    */     
/* 26 */     if (livingEntity.m_6117_() && livingEntity.m_21211_().m_41780_() == UseAnim.BOW) {
/* 27 */       return (LivingMotion)LivingMotions.AIM;
/*    */     }
/*    */     
/* 30 */     return super.getLivingMotion(livingEntityPatch, hand);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\capabilities\AVBowCapability.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */