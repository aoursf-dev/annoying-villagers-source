/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.Random;
/*     */ import java.util.function.BiFunction;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
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
/* 361 */     super(waitTicks);
/*     */   }
/*     */   public void run() {
/* 364 */     if (!mob.m_6084_())
/*     */       return; 
/* 366 */     mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_INWARD, 0.0F);
/*     */     
/* 368 */     LivingEntity target = mob.m_5448_();
/*     */ 
/*     */     
/* 371 */     Direction dir = (target != null) ? Direction.m_122366_(target.m_20185_() - mob.m_20185_(), 0.0D, target.m_20189_() - mob.m_20189_()) : mob.m_6350_();
/*     */     
/* 373 */     Random random = new Random();
/* 374 */     int dist = 1 + random.nextInt(3);
/*     */     
/* 376 */     int rot = random.nextInt(4);
/* 377 */     BiFunction<Integer, Integer, int[]> toWorld = CombatCommon.getIntegerIntegerBiFunction((Entity)mob, rot);
/* 378 */     int lateral = random.nextInt(3) - 1;
/* 379 */     int[] dxz = toWorld.apply(Integer.valueOf(lateral), Integer.valueOf(0));
/*     */     
/* 381 */     BlockPos baseXZ = mob.m_20183_().m_5484_(dir, dist).m_7918_(dxz[0], 0, dxz[1]);
/* 382 */     int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, baseXZ).m_123342_();
/* 383 */     BlockPos spawnPos = new BlockPos(baseXZ.m_123341_(), surfaceY, baseXZ.m_123343_());
/*     */ 
/*     */     
/* 386 */     LowShadowHerobrineCloneEntity clone = new LowShadowHerobrineCloneEntity((EntityType)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (Level)serverLevel);
/*     */     
/* 388 */     float yaw = dir.m_122435_();
/* 389 */     clone.m_7678_(spawnPos.m_123341_() + 0.5D, spawnPos.m_123342_(), spawnPos.m_123343_() + 0.5D, yaw, 0.0F);
/* 390 */     clone.setRenderPortal(false);
/*     */     
/* 392 */     clone.setForEscaping(true);
/* 393 */     clone.m_21557_(true);
/* 394 */     if (mob instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)mob;
/* 395 */       clone.setPossessedByEntity(herobrineMob);
/* 396 */       clone.setPossessedByUuid(herobrineMob.m_20148_()); }
/*     */ 
/*     */     
/* 399 */     serverLevel.m_7967_((Entity)clone);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineCommon$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */