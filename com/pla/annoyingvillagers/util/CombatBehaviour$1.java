/*     */ package com.pla.annoyingvillagers.util;
/*     */ 
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.Random;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.projectile.ThrownEnderpearl;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends DelayedTask
/*     */ {
/*     */   null(int waitTicks) {
/*  94 */     super(waitTicks);
/*     */   }
/*     */   public void run() {
/*  97 */     Vec3 handPos = CombatBehaviour.getFrontLeftPos(entity);
/*  98 */     ThrownEnderpearl thrownEnderpearl = new ThrownEnderpearl(EntityType.f_20484_, (Level)serverLevel);
/*  99 */     thrownEnderpearl.m_5602_(entity);
/* 100 */     thrownEnderpearl.m_6034_(handPos.f_82479_, handPos.f_82480_, handPos.f_82481_);
/* 101 */     thrownEnderpearl.m_6686_((entity.m_20154_()).f_82479_, (entity.m_20154_()).f_82480_, (entity.m_20154_()).f_82481_, (new Random()).nextBoolean() ? 1.0F : 2.0F, 0.0F);
/* 102 */     serverLevel.m_7967_((Entity)thrownEnderpearl);
/* 103 */     entity.m_9236_().m_6263_(null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_11857_, SoundSource.NEUTRAL, 0.5F, 0.4F / (entity.m_9236_().m_213780_().m_188501_() * 0.4F + 0.8F));
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\CombatBehaviour$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */