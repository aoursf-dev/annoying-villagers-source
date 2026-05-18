/*     */ package com.pla.annoyingvillagers.entity.goal;
/*     */ 
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import java.util.EnumSet;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraft.world.phys.AABB;
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
/*     */ public class DragonOrbitLeaderGoal
/*     */   extends Goal
/*     */ {
/*     */   private static final double TWO_PI = 6.283185307179586D;
/*     */   private static final double ORBIT_RING_INNER_FACTOR = 0.8D;
/*     */   private static final double ORBIT_RING_OUTER_FACTOR = 1.35D;
/*     */   private final HerobrineDragonEntity dragon;
/*     */   private final Level level;
/*     */   private final double baseSpeed;
/*     */   private final float orbitRadiusMin;
/*     */   private final float orbitRadiusMax;
/*     */   private final float farCatchUpDistance;
/*     */   private LivingEntity leader;
/*     */   private int updateCooldownTicks;
/*     */   private double orbitAngleRadians;
/*     */   private int orbitDirectionSign;
/*     */   private double orbitRadiusCurrent;
/*     */   private double orbitRadiusDesired;
/*     */   private double orbitAngularSpeedCurrent;
/*     */   private double orbitAngularSpeedDesired;
/*     */   private double orbitBaseHeightCurrent;
/*     */   private double orbitBaseHeightDesired;
/*     */   private double verticalWaveAmplitude;
/*     */   private double verticalWaveSpeed;
/*     */   private double verticalWavePhase;
/*     */   private int paramsTimeToLiveTicks;
/*     */   private double yJitterCurrent;
/*     */   private double yJitterDesired;
/*     */   
/*     */   public DragonOrbitLeaderGoal(HerobrineDragonEntity dragon, double baseSpeed, float orbitRadiusMin, float orbitRadiusMax, float farCatchUpDistance) {
/*  68 */     this.dragon = dragon;
/*  69 */     this.level = dragon.m_9236_();
/*  70 */     this.baseSpeed = baseSpeed;
/*  71 */     this.orbitRadiusMin = orbitRadiusMin;
/*  72 */     this.orbitRadiusMax = orbitRadiusMax;
/*  73 */     this.farCatchUpDistance = farCatchUpDistance;
/*  74 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private LivingEntity resolveOrbitCenter(HerobrineDragonEntity herobrineDragonEntity) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual getSummoner : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   4: astore_2
/*     */     //   5: aload_2
/*     */     //   6: ifnonnull -> 14
/*     */     //   9: aload_1
/*     */     //   10: invokevirtual m_269323_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   13: areturn
/*     */     //   14: aload_2
/*     */     //   15: instanceof net/minecraft/world/entity/player/Player
/*     */     //   18: ifne -> 136
/*     */     //   21: aload_1
/*     */     //   22: aload_2
/*     */     //   23: invokevirtual m_20363_ : (Lnet/minecraft/world/entity/Entity;)Z
/*     */     //   26: ifne -> 63
/*     */     //   29: aload_2
/*     */     //   30: invokevirtual m_20202_ : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   33: astore #4
/*     */     //   35: aload #4
/*     */     //   37: instanceof com/pla/annoyingvillagers/entity/HerobrineDragonEntity
/*     */     //   40: ifeq -> 136
/*     */     //   43: aload #4
/*     */     //   45: checkcast com/pla/annoyingvillagers/entity/HerobrineDragonEntity
/*     */     //   48: astore_3
/*     */     //   49: aload_3
/*     */     //   50: invokevirtual m_20148_ : ()Ljava/util/UUID;
/*     */     //   53: aload_1
/*     */     //   54: invokevirtual m_20148_ : ()Ljava/util/UUID;
/*     */     //   57: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   60: ifne -> 136
/*     */     //   63: aconst_null
/*     */     //   64: astore #4
/*     */     //   66: aload_2
/*     */     //   67: instanceof net/minecraft/world/entity/Mob
/*     */     //   70: ifeq -> 86
/*     */     //   73: aload_2
/*     */     //   74: checkcast net/minecraft/world/entity/Mob
/*     */     //   77: astore #5
/*     */     //   79: aload #5
/*     */     //   81: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   84: astore #4
/*     */     //   86: aload #4
/*     */     //   88: ifnull -> 99
/*     */     //   91: aload #4
/*     */     //   93: invokevirtual m_6084_ : ()Z
/*     */     //   96: ifne -> 105
/*     */     //   99: aload_2
/*     */     //   100: invokevirtual m_21214_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   103: astore #4
/*     */     //   105: aload #4
/*     */     //   107: ifnull -> 118
/*     */     //   110: aload #4
/*     */     //   112: invokevirtual m_6084_ : ()Z
/*     */     //   115: ifne -> 124
/*     */     //   118: aload_2
/*     */     //   119: invokevirtual m_21188_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   122: astore #4
/*     */     //   124: aload #4
/*     */     //   126: ifnonnull -> 133
/*     */     //   129: aload_2
/*     */     //   130: invokevirtual m_8127_ : ()V
/*     */     //   133: aload #4
/*     */     //   135: areturn
/*     */     //   136: aload_2
/*     */     //   137: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #152	-> 0
/*     */     //   #153	-> 5
/*     */     //   #155	-> 14
/*     */     //   #156	-> 23
/*     */     //   #157	-> 29
/*     */     //   #158	-> 50
/*     */     //   #159	-> 63
/*     */     //   #161	-> 66
/*     */     //   #162	-> 79
/*     */     //   #164	-> 86
/*     */     //   #165	-> 105
/*     */     //   #167	-> 124
/*     */     //   #168	-> 129
/*     */     //   #170	-> 133
/*     */     //   #173	-> 136
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   49	14	3	herobrineDragon	Lcom/pla/annoyingvillagers/entity/HerobrineDragonEntity;
/*     */     //   79	7	5	mob	Lnet/minecraft/world/entity/Mob;
/*     */     //   66	70	4	target	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   0	138	0	this	Lcom/pla/annoyingvillagers/entity/goal/DragonOrbitLeaderGoal;
/*     */     //   0	138	1	herobrineDragonEntity	Lcom/pla/annoyingvillagers/entity/HerobrineDragonEntity;
/*     */     //   5	133	2	livingEntity	Lnet/minecraft/world/entity/LivingEntity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean m_8036_() {
/* 178 */     LivingEntity resolved = resolveOrbitCenter(this.dragon);
/* 179 */     if (resolved == null) return false; 
/* 180 */     if (!resolved.m_6084_()) return false; 
/* 181 */     if (resolved.m_5833_()) return false;
/*     */     
/* 183 */     if (this.dragon.m_21523_()) return false; 
/* 184 */     if (this.dragon.m_20159_()) return false; 
/* 185 */     if (this.dragon.m_217005_()) return false; 
/* 186 */     if (this.dragon.m_21827_() && this.dragon.getSummoner() == null) return false; 
/* 187 */     if (this.dragon.isRecallActive()) return false;
/*     */     
/* 189 */     this.leader = resolved;
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 195 */     LivingEntity resolved = resolveOrbitCenter(this.dragon);
/* 196 */     if (resolved == null) return false; 
/* 197 */     if (!resolved.m_6084_()) return false; 
/* 198 */     if (resolved.m_5833_()) return false;
/*     */     
/* 200 */     if (this.dragon.m_21523_()) return false; 
/* 201 */     if (this.dragon.m_20159_()) return false; 
/* 202 */     if (this.dragon.m_217005_()) return false; 
/* 203 */     if (this.dragon.m_21827_() && this.dragon.getSummoner() == null) return false; 
/* 204 */     if (this.dragon.isRecallActive()) return false;
/*     */     
/* 206 */     this.leader = resolved;
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8056_() {
/* 212 */     this.updateCooldownTicks = 0;
/*     */     
/* 214 */     this.orbitAngleRadians = Mth.m_216263_(this.dragon.m_217043_(), 0.0D, 6.283185307179586D);
/* 215 */     this.orbitDirectionSign = this.dragon.m_217043_().m_188499_() ? 1 : -1;
/*     */     
/* 217 */     this.orbitRadiusCurrent = this.orbitRadiusDesired = Mth.m_216263_(this.dragon.m_217043_(), this.orbitRadiusMin, this.orbitRadiusMax);
/*     */     
/* 219 */     this.orbitAngularSpeedCurrent = this.orbitAngularSpeedDesired = Mth.m_216263_(this.dragon.m_217043_(), 0.045D, 0.11D);
/*     */     
/* 221 */     this.orbitBaseHeightCurrent = this.orbitBaseHeightDesired = 14.0D + this.dragon.m_217043_().m_188503_(14);
/*     */     
/* 223 */     this.verticalWaveAmplitude = Mth.m_216263_(this.dragon.m_217043_(), 2.0D, 7.0D);
/* 224 */     this.verticalWaveSpeed = Mth.m_216263_(this.dragon.m_217043_(), 0.018D, 0.045D);
/* 225 */     this.verticalWavePhase = Mth.m_216263_(this.dragon.m_217043_(), 0.0D, 6.283185307179586D);
/*     */     
/* 227 */     this.paramsTimeToLiveTicks = 80 + this.dragon.m_217043_().m_188503_(140);
/*     */     
/* 229 */     this.dragon.m_21573_().m_26573_();
/* 230 */     this.yJitterCurrent = this.yJitterDesired = Mth.m_216263_(this.dragon.m_217043_(), -6.0D, 6.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8041_() {
/* 235 */     this.leader = null;
/* 236 */     this.dragon.m_21573_().m_26573_();
/*     */   }
/*     */   
/*     */   public void m_8037_() {
/*     */     Vec3 targetPosition;
/* 241 */     if (this.leader == null)
/*     */       return; 
/* 243 */     this.dragon.m_21563_().m_24960_((Entity)this.leader, 10.0F, this.dragon.m_8132_());
/*     */     
/* 245 */     this.orbitAngleRadians = wrapAngle(this.orbitAngleRadians + this.orbitDirectionSign * this.orbitAngularSpeedCurrent);
/* 246 */     this.verticalWavePhase = wrapAngle(this.verticalWavePhase + this.verticalWaveSpeed);
/*     */     
/* 248 */     if (--this.paramsTimeToLiveTicks <= 0 || this.dragon.m_217043_().m_188503_(220) == 0) {
/* 249 */       rerollOrbitParameters();
/*     */     }
/*     */     
/* 252 */     this.orbitRadiusCurrent = Mth.m_14139_(0.08D, this.orbitRadiusCurrent, this.orbitRadiusDesired);
/* 253 */     this.orbitAngularSpeedCurrent = Mth.m_14139_(0.08D, this.orbitAngularSpeedCurrent, this.orbitAngularSpeedDesired);
/* 254 */     this.orbitBaseHeightCurrent = Mth.m_14139_(0.08D, this.orbitBaseHeightCurrent, this.orbitBaseHeightDesired);
/*     */     
/* 256 */     if (--this.updateCooldownTicks > 0)
/* 257 */       return;  this.updateCooldownTicks = m_183277_(2);
/*     */     
/* 259 */     Vec3 leaderPosition = this.leader.m_20182_();
/* 260 */     Vec3 dragonOffsetFromLeader = this.dragon.m_20182_().m_82546_(leaderPosition);
/*     */     
/* 262 */     double distanceToLeader = dragonOffsetFromLeader.m_82553_();
/* 263 */     double distanceToLeaderSquared = distanceToLeader * distanceToLeader;
/* 264 */     double farCatchUpDistanceSquared = this.farCatchUpDistance * this.farCatchUpDistance;
/*     */     
/* 266 */     if (distanceToLeaderSquared >= farCatchUpDistanceSquared) {
/* 267 */       if (!this.dragon.m_29443_() && this.dragon.canFly()) {
/* 268 */         this.dragon.liftOff();
/*     */       }
/*     */       
/* 271 */       double catchUpY = computeDesiredY(leaderPosition.f_82479_, leaderPosition.f_82481_, leaderPosition.f_82480_) + 6.0D;
/* 272 */       catchUpY = clampYForWorld(leaderPosition.f_82479_, leaderPosition.f_82481_, catchUpY);
/* 273 */       catchUpY = findNearestFreeY(leaderPosition.f_82479_, leaderPosition.f_82481_, catchUpY, hasCeiling(), 24);
/*     */       
/* 275 */       Vec3 catchUpTarget = new Vec3(leaderPosition.f_82479_, catchUpY, leaderPosition.f_82481_);
/* 276 */       setMoveTarget(catchUpTarget, this.baseSpeed * 1.65D);
/*     */       
/*     */       return;
/*     */     } 
/* 280 */     if (!this.dragon.m_29443_() && this.dragon.canFly() && (
/* 281 */       this.dragon.m_20096_() || this.leader.m_20186_() - this.dragon.m_20186_() > 2.0D || distanceToLeader > this.orbitRadiusMin)) {
/* 282 */       this.dragon.liftOff();
/*     */     }
/*     */ 
/*     */     
/* 286 */     double orbitRingMinDistance = this.orbitRadiusMin * 0.8D;
/* 287 */     double orbitRingMaxDistance = this.orbitRadiusMax * 1.35D;
/*     */ 
/*     */ 
/*     */     
/* 291 */     if (distanceToLeader < orbitRingMinDistance || distanceToLeader > orbitRingMaxDistance) {
/* 292 */       Vec3 outwardDirection = (distanceToLeader > 1.0E-4D) ? dragonOffsetFromLeader.m_82490_(1.0D / distanceToLeader) : new Vec3(1.0D, 0.0D, 0.0D);
/* 293 */       Vec3 ringPoint = leaderPosition.m_82549_(outwardDirection.m_82490_(this.orbitRadiusDesired));
/* 294 */       double ringY = computeDesiredY(ringPoint.f_82479_, ringPoint.f_82481_, leaderPosition.f_82480_);
/* 295 */       targetPosition = new Vec3(ringPoint.f_82479_, ringY, ringPoint.f_82481_);
/*     */     } else {
/* 297 */       double orbitX = leaderPosition.f_82479_ + Math.cos(this.orbitAngleRadians) * this.orbitRadiusCurrent;
/* 298 */       double orbitZ = leaderPosition.f_82481_ + Math.sin(this.orbitAngleRadians) * this.orbitRadiusCurrent;
/* 299 */       double orbitY = computeDesiredY(orbitX, orbitZ, leaderPosition.f_82480_);
/* 300 */       targetPosition = new Vec3(orbitX, orbitY, orbitZ);
/*     */     } 
/* 302 */     if (!canMoveTo(targetPosition)) {
/* 303 */       boolean preferDown = hasCeiling();
/*     */       
/* 305 */       double yFixed = findNearestFreeY(targetPosition.f_82479_, targetPosition.f_82481_, targetPosition.f_82480_, preferDown, 32);
/* 306 */       Vec3 fixed = new Vec3(targetPosition.f_82479_, yFixed, targetPosition.f_82481_);
/*     */       
/* 308 */       if (canMoveTo(fixed)) {
/* 309 */         targetPosition = fixed;
/*     */       }
/*     */       else {
/*     */         
/* 313 */         (new double[6])[0] = -6.0D; (new double[6])[1] = -10.0D; (new double[6])[2] = -14.0D; (new double[6])[3] = 6.0D; (new double[6])[4] = 10.0D; (new double[6])[5] = 14.0D;
/* 314 */         (new double[6])[0] = 6.0D; (new double[6])[1] = 10.0D; (new double[6])[2] = 14.0D; (new double[6])[3] = -6.0D; (new double[6])[4] = -10.0D; (new double[6])[5] = -14.0D; double[] offs = preferDown ? new double[6] : new double[6];
/*     */         
/* 316 */         boolean found = false;
/* 317 */         for (double off : offs) {
/* 318 */           double yy = clampYForWorld(targetPosition.f_82479_, targetPosition.f_82481_, targetPosition.f_82480_ + off);
/* 319 */           Vec3 t = new Vec3(targetPosition.f_82479_, yy, targetPosition.f_82481_);
/* 320 */           if (canMoveTo(t)) {
/* 321 */             targetPosition = t;
/* 322 */             found = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 327 */         if (!found) {
/* 328 */           this.orbitAngleRadians = Mth.m_216263_(this.dragon.m_217043_(), 0.0D, 6.283185307179586D);
/* 329 */           double fallbackY = clampYForWorld(leaderPosition.f_82479_, leaderPosition.f_82481_, leaderPosition.f_82480_ + this.orbitBaseHeightCurrent + 18.0D);
/* 330 */           fallbackY = findNearestFreeY(leaderPosition.f_82479_, leaderPosition.f_82481_, fallbackY, preferDown, 32);
/* 331 */           targetPosition = new Vec3(leaderPosition.f_82479_, fallbackY, leaderPosition.f_82481_);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 347 */     setMoveTarget(targetPosition, this.baseSpeed);
/* 348 */     this.yJitterCurrent = Mth.m_14139_(0.05D, this.yJitterCurrent, this.yJitterDesired);
/*     */   }
/*     */   
/*     */   private void setMoveTarget(Vec3 target, double speed) {
/* 352 */     if (this.dragon.m_29443_()) {
/* 353 */       this.dragon.m_21573_().m_26573_();
/* 354 */       this.dragon.m_21566_().m_6849_(target.f_82479_, target.f_82480_, target.f_82481_, speed);
/*     */     } else {
/* 356 */       this.dragon.m_21573_().m_26519_(target.f_82479_, target.f_82480_, target.f_82481_, speed);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void rerollOrbitParameters() {
/* 361 */     if (this.dragon.m_217043_().m_188501_() < 0.3F) {
/* 362 */       this.orbitDirectionSign *= -1;
/*     */     }
/*     */     
/* 365 */     this.orbitRadiusDesired = Mth.m_216263_(this.dragon.m_217043_(), this.orbitRadiusMin, this.orbitRadiusMax);
/* 366 */     this.orbitAngularSpeedDesired = Mth.m_216263_(this.dragon.m_217043_(), 0.04D, 0.13D);
/*     */     
/* 368 */     this.orbitBaseHeightDesired = 14.0D + this.dragon.m_217043_().m_188503_(18);
/*     */     
/* 370 */     this.verticalWaveAmplitude = Mth.m_216263_(this.dragon.m_217043_(), 2.0D, 8.0D);
/* 371 */     this.verticalWaveSpeed = Mth.m_216263_(this.dragon.m_217043_(), 0.016D, 0.05D);
/*     */     
/* 373 */     if (this.dragon.m_217043_().m_188501_() < 0.35F) {
/* 374 */       this.orbitAngleRadians = Mth.m_216263_(this.dragon.m_217043_(), 0.0D, 6.283185307179586D);
/*     */     }
/*     */     
/* 377 */     this.paramsTimeToLiveTicks = 70 + this.dragon.m_217043_().m_188503_(160);
/* 378 */     this.yJitterDesired = Mth.m_216263_(this.dragon.m_217043_(), -10.0D, 10.0D);
/*     */   }
/*     */   
/*     */   private double computeDesiredY(double x, double z, double leaderY) {
/* 382 */     double y = leaderY + this.orbitBaseHeightCurrent;
/*     */     
/* 384 */     y += Math.sin(this.verticalWavePhase) * this.verticalWaveAmplitude;
/* 385 */     y += this.yJitterCurrent;
/* 386 */     y = clampYForWorld(x, z, y);
/* 387 */     y = findNearestFreeY(x, z, y, hasCeiling(), 24);
/*     */     
/* 389 */     return y;
/*     */   }
/*     */   
/*     */   private boolean hasCeiling() {
/* 393 */     return this.level.m_6042_().f_63856_();
/*     */   }
/*     */   
/*     */   private double minY() {
/* 397 */     return this.level.m_141937_() + 6.0D;
/*     */   }
/*     */   
/*     */   private double maxY(double x, double z) {
/* 401 */     double max = this.level.m_151558_() - 6.0D;
/*     */     
/* 403 */     if (hasCeiling()) {
/* 404 */       BlockPos col = BlockPos.m_274561_(x, 0.0D, z);
/* 405 */       int roofAirY = this.level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, col).m_123342_();
/*     */       
/* 407 */       max = Math.min(max, (roofAirY - this.dragon.m_20206_()) - 2.0D);
/*     */     } 
/*     */     
/* 410 */     if (max < minY()) max = minY(); 
/* 411 */     return max;
/*     */   }
/*     */   
/*     */   private double clampYForWorld(double x, double z, double y) {
/* 415 */     return Mth.m_14008_(y, minY(), maxY(x, z));
/*     */   }
/*     */   
/*     */   private double findNearestFreeY(double x, double z, double desiredY, boolean preferDown, int maxSteps) {
/* 419 */     double yClamped = clampYForWorld(x, z, desiredY);
/*     */     
/* 421 */     int base = Mth.m_14107_(yClamped);
/* 422 */     int min = Mth.m_14107_(minY());
/* 423 */     int max = Mth.m_14107_(maxY(x, z));
/*     */     
/* 425 */     base = Mth.m_14045_(base, min, max);
/*     */     
/* 427 */     for (int step = 0; step <= maxSteps; step++) {
/* 428 */       int y1 = preferDown ? (base - step) : (base + step);
/* 429 */       int y2 = preferDown ? (base + step) : (base - step);
/*     */       
/* 431 */       if (y1 >= min && y1 <= max && canMoveTo(new Vec3(x, y1, z))) {
/* 432 */         return y1;
/*     */       }
/* 434 */       if (step != 0 && y2 >= min && y2 <= max && canMoveTo(new Vec3(x, y2, z))) {
/* 435 */         return y2;
/*     */       }
/*     */     } 
/*     */     
/* 439 */     return yClamped;
/*     */   }
/*     */   
/*     */   private boolean canMoveTo(Vec3 pos) {
/* 443 */     Vec3 delta = pos.m_82546_(this.dragon.m_20182_());
/* 444 */     AABB moved = this.dragon.m_20191_().m_82383_(delta);
/* 445 */     return (this.level.m_45756_((Entity)this.dragon, moved) && !this.level.m_46855_(moved));
/*     */   }
/*     */   
/*     */   private static double wrapAngle(double angle) {
/* 449 */     angle %= 6.283185307179586D;
/* 450 */     return (angle < 0.0D) ? (angle + 6.283185307179586D) : angle;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\goal\DragonOrbitLeaderGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */