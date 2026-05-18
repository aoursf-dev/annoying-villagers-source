/*    */ package com.pla.annoyingvillagers.clazz;
/*    */ 
/*    */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*    */ import net.minecraft.tags.DamageTypeTags;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ public interface BurstProtectEntity {
/*    */   float getRecentDamageTaken();
/*    */   
/*    */   void setRecentDamageTaken(float paramFloat);
/*    */   
/*    */   default float getBurstProtectCapRatio() {
/* 21 */     return 0.2F;
/*    */   } int getRecentHitCounter();
/*    */   void setRecentHitCounter(int paramInt);
/*    */   default float getBurstProtectMinDamage() {
/* 25 */     return 0.3F;
/*    */   }
/*    */   
/*    */   default void tickBurstProtectionDecay(LivingEntity self) {
/* 29 */     if (getRecentDamageTaken() > 0.0F) {
/* 30 */       setRecentDamageTaken(Mth.m_14121_(
/* 31 */             getRecentDamageTaken(), 0.0F, self
/*    */             
/* 33 */             .m_21233_() * 0.07F / 160.0F));
/*    */     }
/*    */ 
/*    */     
/* 37 */     if (self.f_19797_ % 4 == 0 && getRecentHitCounter() > 0) {
/* 38 */       setRecentHitCounter(Mth.m_14045_(getRecentHitCounter() - 1, 0, 5));
/*    */     }
/*    */   }
/*    */   
/*    */   default boolean shouldIgnoreBurstProtection(LivingEntity self, DamageSource source) {
/* 43 */     LivingEntityPatch<?> patch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)self, LivingEntityPatch.class);
/* 44 */     if (patch == null) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     AnimationPlayer player = patch.getAnimator().getPlayerFor(null);
/* 49 */     if (player == null) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     AssetAccessor<? extends StaticAnimation> anim = player.getRealAnimation();
/* 54 */     return EpicfightUtil.isDamagableHitAnimation(anim, patch);
/*    */   }
/*    */   
/*    */   default float applyBurstProtection(LivingEntity self, DamageSource source, float damage) {
/* 58 */     if (shouldIgnoreBurstProtection(self, source)) {
/* 59 */       return damage;
/*    */     }
/*    */     
/* 62 */     if (damage <= 0.0F) {
/* 63 */       return 0.0F;
/*    */     }
/*    */     
/* 66 */     if (source.m_269533_(DamageTypeTags.f_268738_)) {
/* 67 */       return damage;
/*    */     }
/*    */     
/* 70 */     float cap = self.m_21233_() * getBurstProtectCapRatio();
/* 71 */     damage = Mth.m_14036_(damage, 0.0F, cap);
/*    */     
/* 73 */     float damageScale = 1.0F - Mth.m_14036_(
/* 74 */         getRecentDamageTaken() / self.m_21233_() * 0.07F, 0.0F, 0.9F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 79 */     float hitScale = 1.0F - Mth.m_14036_(
/* 80 */         getRecentHitCounter() / 5.0F, 0.0F, 0.9F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 85 */     damage *= damageScale;
/*    */     
/* 87 */     if (getRecentHitCounter() >= 5) {
/* 88 */       damage = getBurstProtectMinDamage();
/*    */     } else {
/* 90 */       damage *= hitScale;
/*    */     } 
/*    */     
/* 93 */     setRecentHitCounter(getRecentHitCounter() + 1);
/* 94 */     setRecentDamageTaken(getRecentDamageTaken() + damage);
/*    */     
/* 96 */     return damage;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\BurstProtectEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */