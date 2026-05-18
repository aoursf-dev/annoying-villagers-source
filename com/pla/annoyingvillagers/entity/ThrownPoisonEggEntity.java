/*    */ package com.pla.annoyingvillagers.entity;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import net.minecraft.core.particles.ItemParticleOption;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.ParticleTypes;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.effect.MobEffects;
/*    */ import net.minecraft.world.entity.AreaEffectCloud;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.EntityHitResult;
/*    */ import net.minecraft.world.phys.HitResult;
/*    */ import net.minecraftforge.network.PlayMessages;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class ThrownPoisonEggEntity extends ThrowableItemProjectile {
/*    */   public ThrownPoisonEggEntity(PlayMessages.SpawnEntity spawnentity, Level level) {
/* 23 */     super((EntityType)AnnoyingVillagersModEntities.THROWN_POISON_EGG.get(), level);
/*    */   }
/*    */   
/*    */   public ThrownPoisonEggEntity(EntityType<? extends ThrownPoisonEggEntity> entitytype, Level level) {
/* 27 */     super(entitytype, level);
/*    */   }
/*    */   
/*    */   public ThrownPoisonEggEntity(EntityType<? extends ThrownPoisonEggEntity> entitytype, double d0, double d1, double d2, Level level) {
/* 31 */     super(entitytype, d0, d1, d2, level);
/*    */   }
/*    */   
/*    */   public ThrownPoisonEggEntity(EntityType<? extends ThrownPoisonEggEntity> entitytype, LivingEntity livingentity, Level level) {
/* 35 */     super(entitytype, livingentity, level);
/*    */   }
/*    */   
/*    */   public void m_7822_(byte pId) {
/* 39 */     if (pId == 3) {
/* 40 */       double d0 = 0.08D;
/*    */       
/* 42 */       for (int i = 0; i < 8; i++) {
/* 43 */         m_9236_().m_7106_((ParticleOptions)new ItemParticleOption(ParticleTypes.f_123752_, m_7846_()), m_20185_(), m_20186_(), m_20189_(), (this.f_19796_.m_188501_() - 0.5D) * 0.08D, (this.f_19796_.m_188501_() - 0.5D) * 0.08D, (this.f_19796_.m_188501_() - 0.5D) * 0.08D);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void spawnPoisonCloud(Level level, double x, double y, double z) {
/* 50 */     AreaEffectCloud cloud = new AreaEffectCloud(level, x, y, z);
/* 51 */     cloud.m_19712_(3.0F);
/* 52 */     cloud.m_19738_(-0.05F);
/* 53 */     cloud.m_19734_(20);
/* 54 */     cloud.m_19740_(0);
/* 55 */     cloud.m_19714_(5149489);
/* 56 */     cloud.m_19724_((ParticleOptions)ParticleTypes.f_123811_);
/* 57 */     cloud.m_19716_(new MobEffectInstance(MobEffects.f_19614_, 20, 0));
/* 58 */     level.m_7967_((Entity)cloud);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void m_5790_(@NotNull EntityHitResult pResult) {
/* 63 */     super.m_5790_(pResult);
/* 64 */     if (!(pResult.m_82443_() instanceof BbqEntity)) {
/* 65 */       pResult.m_82443_().m_6469_(m_269291_().m_269390_((Entity)this, m_19749_()), 0.5F);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void m_6532_(@NotNull HitResult pResult) {
/* 70 */     super.m_6532_(pResult);
/* 71 */     if (!(m_9236_()).f_46443_) {
/* 72 */       if (this.f_19796_.m_188501_() < 0.5F) {
/* 73 */         spawnPoisonCloud(m_9236_(), m_20185_(), m_20186_(), m_20189_());
/*    */       }
/* 75 */       m_9236_().m_7605_((Entity)this, (byte)3);
/* 76 */       m_146870_();
/*    */     } 
/*    */   }
/*    */   @NotNull
/*    */   protected Item m_7881_() {
/* 81 */     return (Item)AnnoyingVillagersModItems.POISON_EGG_ITEM.get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ThrownPoisonEggEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */