/*     */ package com.pla.annoyingvillagers.entity.goal;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import java.util.EnumSet;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ public class RecallLandGoal extends Goal {
/*     */   private final HerobrineDragonEntity dragon;
/*  18 */   private int stage = 0;
/*     */   
/*     */   public RecallLandGoal(HerobrineDragonEntity dragon) {
/*  21 */     this.dragon = dragon;
/*  22 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8036_() {
/*  27 */     return (this.dragon.isRecallActive() && this.dragon
/*  28 */       .getSummoner() != null && this.dragon
/*  29 */       .getSummoner().m_6084_() && 
/*  30 */       !this.dragon.m_20159_() && 
/*  31 */       !this.dragon.m_217005_());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/*  36 */     return m_8036_();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8056_() {
/*  41 */     this.stage = 0;
/*     */     
/*  43 */     Level level = this.dragon.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  44 */       this.dragon.setRecallLandPos(findLandingPosNearSummoner(serverLevel, this.dragon.getSummoner())); }
/*     */ 
/*     */     
/*  47 */     if (!this.dragon.m_29443_() && this.dragon.canFly()) this.dragon.liftOff(); 
/*  48 */     this.dragon.setFlying(true);
/*  49 */     this.dragon.setNavigation(true);
/*  50 */     this.dragon.m_21573_().m_26573_();
/*  51 */     this.dragon.m_20242_(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8041_() {
/*  56 */     this.dragon.setRecallActive(false);
/*  57 */     this.dragon.setRecallLandPos(null);
/*  58 */     this.dragon.m_20242_(false);
/*  59 */     this.stage = 0;
/*     */   }
/*     */   
/*     */   public void m_8037_() {
/*     */     ServerLevel serverLevel;
/*  64 */     Level level = this.dragon.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*  65 */     else { m_8041_();
/*     */       
/*     */       return; }
/*     */     
/*  69 */     LivingEntity owner = this.dragon.getSummoner();
/*  70 */     if (owner == null || !owner.m_6084_()) {
/*  71 */       m_8041_();
/*     */       
/*     */       return;
/*     */     } 
/*  75 */     if (this.dragon.getRecallLandPos() == null) {
/*  76 */       this.dragon.setRecallLandPos(findLandingPosNearSummoner(serverLevel, owner));
/*     */     }
/*     */     
/*  79 */     Vec3 land = this.dragon.getRecallLandPos();
/*     */     
/*  81 */     this.dragon.m_21573_().m_26573_();
/*  82 */     this.dragon.m_20242_(true);
/*  83 */     if (!this.dragon.m_29443_() && this.dragon.canFly()) this.dragon.liftOff(); 
/*  84 */     this.dragon.setFlying(true);
/*  85 */     this.dragon.setNavigation(true);
/*     */     
/*  87 */     double aboveY = Math.max(owner.m_20186_() + 10.0D, land.f_82480_ + 10.0D);
/*  88 */     aboveY = clampYForWorld(serverLevel, land.f_82479_, land.f_82481_, aboveY);
/*  89 */     aboveY = findNearestFreeY(serverLevel, land.f_82479_, land.f_82481_, aboveY, serverLevel.m_6042_().f_63856_());
/*  90 */     Vec3 above = new Vec3(land.f_82479_, aboveY, land.f_82481_);
/*     */     
/*  92 */     if (this.stage == 0) {
/*  93 */       this.dragon.m_21566_().m_6849_(above.f_82479_, above.f_82480_, above.f_82481_, 1.8D);
/*  94 */       this.dragon.aimBodyAndHeadAt(above, 25.0F, 18.0F);
/*     */       
/*  96 */       if (this.dragon.m_20238_(above) < 16.0D) {
/*  97 */         this.stage = 1;
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 103 */     double landY = clampYForWorld(serverLevel, land.f_82479_, land.f_82481_, land.f_82480_);
/* 104 */     Vec3 landFixed = new Vec3(land.f_82479_, landY, land.f_82481_);
/*     */     
/* 106 */     this.dragon.m_21566_().m_6849_(landFixed.f_82479_, landFixed.f_82480_, landFixed.f_82481_, 1.2D);
/* 107 */     this.dragon.aimBodyAndHeadAt(landFixed, 18.0F, 12.0F);
/*     */     
/* 109 */     if (this.dragon.m_20238_(landFixed) < 9.0D) {
/* 110 */       this.dragon.m_20242_(false);
/* 111 */       this.dragon.m_20256_(Vec3.f_82478_);
/*     */       
/* 113 */       if (this.dragon.isRecallAutoMount()) {
/* 114 */         owner.m_7998_((Entity)this.dragon, true);
/*     */       }
/*     */       
/* 117 */       m_8041_();
/*     */     } 
/*     */   }
/*     */   
/*     */   private Vec3 findLandingPosNearSummoner(ServerLevel level, LivingEntity owner) {
/* 122 */     BlockPos base = owner.m_20183_();
/* 123 */     boolean hasCeiling = level.m_6042_().f_63856_();
/*     */     
/* 125 */     for (int r = 0; r <= 3; r++) {
/* 126 */       for (int dx = -r; dx <= r; dx++) {
/* 127 */         for (int dz = -r; dz <= r; dz++) {
/* 128 */           BlockPos blockPos = base.m_7918_(dx, 0, dz);
/* 129 */           double x = blockPos.m_123341_() + 0.5D;
/* 130 */           double z = blockPos.m_123343_() + 0.5D;
/*     */           
/* 132 */           if (!hasCeiling) {
/* 133 */             int i = level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, blockPos).m_123342_();
/* 134 */             double y = i + 1.0D;
/*     */             
/* 136 */             if (canFitAt(level, x, y, z)) {
/* 137 */               return new Vec3(x, y, z);
/*     */             }
/*     */           } else {
/* 140 */             Vec3 found = findCeilingLandingAtColumn(level, owner, x, z);
/* 141 */             if (found != null) return found;
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 147 */     if (hasCeiling) {
/* 148 */       Vec3 found = findCeilingLandingAtColumn(level, owner, owner.m_20185_(), owner.m_20189_());
/* 149 */       if (found != null) return found;
/*     */       
/* 151 */       double y = clampYForWorld(level, owner.m_20185_(), owner.m_20189_(), owner.m_20186_() + 1.0D);
/* 152 */       y = findNearestFreeY(level, owner.m_20185_(), owner.m_20189_(), y, true);
/* 153 */       return new Vec3(owner.m_20185_(), y, owner.m_20189_());
/*     */     } 
/* 155 */     BlockPos col = BlockPos.m_274561_(owner.m_20185_(), 0.0D, owner.m_20189_());
/* 156 */     int groundY = level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, col).m_123342_();
/* 157 */     return new Vec3(owner.m_20185_(), groundY + 1.0D, owner.m_20189_());
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private Vec3 findCeilingLandingAtColumn(ServerLevel level, LivingEntity owner, double x, double z) {
/* 163 */     double minY = level.m_141937_() + 6.0D;
/* 164 */     int yStart = Mth.m_14107_(owner.m_20186_()) + 8;
/*     */     
/* 166 */     BlockPos col = BlockPos.m_274561_(x, 0.0D, z);
/* 167 */     int roofAirY = level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, col).m_123342_();
/*     */     
/* 169 */     double maxY = Math.min(level.m_151558_() - 2.0D, (roofAirY - this.dragon.m_20206_()) - 2.0D);
/* 170 */     if (maxY < minY) maxY = minY;
/*     */     
/* 172 */     yStart = Math.min(yStart, Mth.m_14107_(maxY));
/* 173 */     yStart = Math.max(yStart, Mth.m_14107_(minY));
/*     */     
/* 175 */     int yMin = Mth.m_14107_(minY);
/*     */     
/* 177 */     for (int y = yStart; y >= yMin && yStart - y <= 96; ) {
/*     */       
/* 179 */       if (!canFitAt(level, x, y, z) || 
/* 180 */         !hasGroundBelow(level, x, y, z)) {
/*     */         y--; continue;
/* 182 */       }  return new Vec3(x, y, z);
/*     */     } 
/*     */     
/* 185 */     return null;
/*     */   }
/*     */   
/*     */   private double clampYForWorld(ServerLevel level, double x, double z, double y) {
/* 189 */     double min = level.m_141937_() + 6.0D;
/* 190 */     double max = level.m_151558_() - 6.0D;
/*     */     
/* 192 */     if (level.m_6042_().f_63856_()) {
/* 193 */       BlockPos col = BlockPos.m_274561_(x, 0.0D, z);
/* 194 */       int roofAirY = level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, col).m_123342_();
/* 195 */       max = Math.min(max, (roofAirY - this.dragon.m_20206_()) - 2.0D);
/*     */     } 
/*     */     
/* 198 */     if (max < min) max = min; 
/* 199 */     return Mth.m_14008_(y, min, max);
/*     */   }
/*     */   
/*     */   private boolean canFitAt(ServerLevel level, double x, double y, double z) {
/* 203 */     AABB movedBox = this.dragon.m_20191_().m_82386_(x - this.dragon
/* 204 */         .m_20185_(), y - this.dragon
/* 205 */         .m_20186_(), z - this.dragon
/* 206 */         .m_20189_());
/*     */     
/* 208 */     return (level.m_45756_((Entity)this.dragon, movedBox) && !level.m_46855_(movedBox));
/*     */   }
/*     */   
/*     */   private boolean hasGroundBelow(ServerLevel level, double x, double y, double z) {
/* 212 */     AABB box = this.dragon.m_20191_().m_82386_(x - this.dragon
/* 213 */         .m_20185_(), y - this.dragon
/* 214 */         .m_20186_(), z - this.dragon
/* 215 */         .m_20189_());
/*     */ 
/*     */     
/* 218 */     AABB below = box.m_82386_(0.0D, -0.25D, 0.0D);
/* 219 */     return !level.m_45756_((Entity)this.dragon, below);
/*     */   }
/*     */   
/*     */   private double findNearestFreeY(ServerLevel level, double x, double z, double desiredY, boolean preferDown) {
/* 223 */     double yClamped = clampYForWorld(level, x, z, desiredY);
/*     */     
/* 225 */     int base = Mth.m_14107_(yClamped);
/* 226 */     int min = Mth.m_14107_(level.m_141937_() + 6.0D);
/* 227 */     int max = Mth.m_14107_(level.m_151558_() - 2.0D);
/*     */     
/* 229 */     if (level.m_6042_().f_63856_()) {
/* 230 */       BlockPos col = BlockPos.m_274561_(x, 0.0D, z);
/* 231 */       int roofAirY = level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, col).m_123342_();
/* 232 */       max = Math.min(max, Mth.m_14107_(roofAirY - 2.0D));
/*     */     } 
/*     */     
/* 235 */     base = Mth.m_14045_(base, min, max);
/*     */     
/* 237 */     for (int step = 0; step <= 64; step++) {
/* 238 */       int y1 = preferDown ? (base - step) : (base + step);
/* 239 */       int y2 = preferDown ? (base + step) : (base - step);
/*     */       
/* 241 */       if (y1 >= min && y1 <= max && canFitAt(level, x, y1, z)) {
/* 242 */         return y1;
/*     */       }
/* 244 */       if (step != 0 && y2 >= min && y2 <= max && canFitAt(level, x, y2, z)) {
/* 245 */         return y2;
/*     */       }
/*     */     } 
/*     */     
/* 249 */     return yClamped;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\goal\RecallLandGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */