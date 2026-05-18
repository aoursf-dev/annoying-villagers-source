/*    */ package com.pla.annoyingvillagers.potion;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*    */ import java.util.Random;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeMap;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class HerobrineMobEffect extends MobEffect {
/*    */   public HerobrineMobEffect() {
/* 17 */     super(MobEffectCategory.HARMFUL, -6710887);
/*    */   }
/*    */   @NotNull
/*    */   public String m_19481_() {
/* 21 */     return "effect.annoyingvillagers.herobrine";
/*    */   }
/*    */   
/*    */   public boolean m_8093_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public void m_6742_(@NotNull LivingEntity livingEntity, int i) {
/* 29 */     if (livingEntity instanceof Player) { Player player = (Player)livingEntity;
/* 30 */       player.m_36399_(0.1F); }
/*    */ 
/*    */     
/* 33 */     if (Math.random() <= 0.05D) {
/* 34 */       float damage = Math.min(livingEntity.m_21223_(), (new Random()).nextFloat(0.5F, 1.5F));
/* 35 */       if (damage == livingEntity.m_21223_()) {
/* 36 */         livingEntity.m_6074_();
/*    */       } else {
/* 38 */         livingEntity.m_6469_(livingEntity.m_9236_().m_269111_().m_269264_(), damage);
/*    */       } 
/*    */     } 
/*    */     
/* 42 */     Level level = livingEntity.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 43 */       Random random = new Random();
/*    */       
/* 45 */       double dx = random.nextInt(-3, 3);
/* 46 */       double dy = random.nextInt(-3, 3);
/* 47 */       double dz = random.nextInt(-3, 3);
/* 48 */       int count = random.nextInt(50, 200);
/* 49 */       serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.GLOWINGEYES
/* 50 */           .get(), livingEntity
/* 51 */           .m_20185_() + dx, livingEntity
/* 52 */           .m_20186_() + dy, livingEntity
/* 53 */           .m_20189_() + dz, count, 0.0D, 0.0D, 0.0D, 0.1D); }
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void m_6386_(@NotNull LivingEntity livingentity, @NotNull AttributeMap attributemap, int i) {
/* 62 */     super.m_6386_(livingentity, attributemap, i);
/*    */   }
/*    */   
/*    */   public boolean m_6584_(int i, int j) {
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\potion\HerobrineMobEffect.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */