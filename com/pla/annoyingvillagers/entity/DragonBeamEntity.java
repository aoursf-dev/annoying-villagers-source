/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.block.EndFireBlock;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.AAAParticlesUtil;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.ScreenShakeUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.Position;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.EntityDataSerializers;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.ClipContext;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.material.PushReaction;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.HitResult;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.joml.Vector3f;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class DragonBeamEntity extends Entity {
/*     */   public HerobrineDragonEntity caster;
/*     */   public LivingEntity target;
/*     */   public double endPosX;
/*     */   public double endPosY;
/*     */   public double endPosZ;
/*     */   public double collidePosX;
/*     */   public double collidePosY;
/*     */   public double collidePosZ;
/*     */   public double prevCollidePosX;
/*     */   public double prevCollidePosY;
/*     */   public double prevCollidePosZ;
/*     */   public float renderYaw;
/*     */   public float renderPitch;
/*     */   public boolean on;
/*     */   public Direction blockSide;
/*     */   private int power;
/*     */   private static final EntityDataAccessor<Float> YAW;
/*     */   private static final EntityDataAccessor<Float> PITCH;
/*     */   private static final EntityDataAccessor<Integer> DURATION;
/*     */   private static final EntityDataAccessor<Integer> CASTER;
/*     */   private static final EntityDataAccessor<Integer> TARGET;
/*     */   public float prevYaw;
/*     */   public float prevPitch;
/*     */   private Vec3 targetPos;
/*     */   private boolean renderBeam = false;
/*     */   private boolean playSound = false;
/*  73 */   private static final EntityDataAccessor<Boolean> USE_NO_VFX_THUNDER = SynchedEntityData.m_135353_(DragonBeamEntity.class, EntityDataSerializers.f_135035_);
/*  74 */   private static final EntityDataAccessor<Vector3f> THUNDER_START = SynchedEntityData.m_135353_(DragonBeamEntity.class, EntityDataSerializers.f_268676_);
/*  75 */   private static final EntityDataAccessor<Vector3f> THUNDER_STOP = SynchedEntityData.m_135353_(DragonBeamEntity.class, EntityDataSerializers.f_268676_);
/*     */   
/*     */   public DragonBeamEntity(EntityType<? extends DragonBeamEntity> pEntityType, Level pLevel) {
/*  78 */     super(pEntityType, pLevel);
/*  79 */     this.on = true;
/*  80 */     this.blockSide = null;
/*  81 */     this.f_19811_ = true;
/*     */   }
/*     */   
/*     */   public DragonBeamEntity(EntityType<? extends DragonBeamEntity> type, Level world, HerobrineDragonEntity caster, LivingEntity target, double x, double y, double z, int duration, int pow) {
/*  85 */     this(type, world);
/*  86 */     this.caster = caster;
/*  87 */     this.target = target;
/*  88 */     setDuration(duration);
/*  89 */     setPower(pow);
/*  90 */     m_6034_(x, y, z);
/*     */     
/*  92 */     Vec3 from = new Vec3(x, y, z);
/*  93 */     Vec3 to = target.m_20299_(1.0F);
/*     */     
/*  95 */     float yawRad = yawTowards(from, to);
/*  96 */     float pitchRad = pitchTowards(from, to);
/*     */     
/*  98 */     setYaw(yawRad);
/*  99 */     setPitch(pitchRad);
/*     */     
/* 101 */     if (world.f_46443_) {
/* 102 */       this.renderYaw = yawRad;
/* 103 */       this.renderPitch = pitchRad;
/*     */     } 
/* 105 */     if (!world.f_46443_) {
/* 106 */       setCasterID(caster.m_19879_());
/* 107 */       setTargetID(target.m_19879_());
/*     */     } 
/*     */     
/* 110 */     calculateEndPos();
/*     */   }
/*     */   
/*     */   protected void m_8097_() {
/* 114 */     this.f_19804_.m_135372_(YAW, Float.valueOf(0.0F));
/* 115 */     this.f_19804_.m_135372_(PITCH, Float.valueOf(0.0F));
/* 116 */     this.f_19804_.m_135372_(DURATION, Integer.valueOf(0));
/* 117 */     this.f_19804_.m_135372_(CASTER, Integer.valueOf(-1));
/* 118 */     this.f_19804_.m_135372_(TARGET, Integer.valueOf(-1));
/* 119 */     this.f_19804_.m_135372_(USE_NO_VFX_THUNDER, Boolean.valueOf(false));
/* 120 */     this.f_19804_.m_135372_(THUNDER_START, new Vector3f());
/* 121 */     this.f_19804_.m_135372_(THUNDER_STOP, new Vector3f());
/*     */   }
/*     */   
/*     */   public void setTargetID(int id) {
/* 125 */     this.f_19804_.m_135381_(TARGET, Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public int getTargetID() {
/* 129 */     return ((Integer)this.f_19804_.m_135370_(TARGET)).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7378_(@NotNull CompoundTag compoundTag) {}
/*     */ 
/*     */   
/*     */   protected void m_7380_(@NotNull CompoundTag compoundTag) {}
/*     */   
/*     */   public void setUseNoVfxThunder(boolean noVfxThunder) {
/* 139 */     this.f_19804_.m_135381_(USE_NO_VFX_THUNDER, Boolean.valueOf(noVfxThunder));
/*     */   }
/*     */   
/*     */   public boolean isSetUseNoVfxThunder() {
/* 143 */     return ((Boolean)this.f_19804_.m_135370_(USE_NO_VFX_THUNDER)).booleanValue();
/*     */   }
/*     */   
/*     */   public Vec3 getThunderStartVec3() {
/* 147 */     Vector3f vector3f = (Vector3f)this.f_19804_.m_135370_(THUNDER_START);
/* 148 */     return new Vec3(vector3f.x, vector3f.y, vector3f.z);
/*     */   }
/*     */   
/*     */   public Vec3 getThunderStopVec3() {
/* 152 */     Vector3f vector3f = (Vector3f)this.f_19804_.m_135370_(THUNDER_STOP);
/* 153 */     return new Vec3(vector3f.x, vector3f.y, vector3f.z);
/*     */   }
/*     */   
/*     */   public void setThunderStartStop(Vec3 from, Vec3 to) {
/* 157 */     this.f_19804_.m_135381_(THUNDER_START, new Vector3f((float)from.f_82479_, (float)from.f_82480_, (float)from.f_82481_));
/* 158 */     this.f_19804_.m_135381_(THUNDER_STOP, new Vector3f((float)to.f_82479_, (float)to.f_82480_, (float)to.f_82481_));
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 162 */     return NetworkHooks.getEntitySpawningPacket(this);
/*     */   }
/*     */   @NotNull
/*     */   public PushReaction m_7752_() {
/* 166 */     return PushReaction.IGNORE;
/*     */   }
/*     */   
/*     */   public float getYaw() {
/* 170 */     return ((Float)m_20088_().m_135370_(YAW)).floatValue();
/*     */   }
/*     */   
/*     */   public void setYaw(float yaw) {
/* 174 */     m_20088_().m_135381_(YAW, Float.valueOf(yaw));
/*     */   }
/*     */   
/*     */   public float getPitch() {
/* 178 */     return ((Float)m_20088_().m_135370_(PITCH)).floatValue();
/*     */   }
/*     */   
/*     */   public void setPitch(float pitch) {
/* 182 */     m_20088_().m_135381_(PITCH, Float.valueOf(pitch));
/*     */   }
/*     */   
/*     */   public int getDuration() {
/* 186 */     return ((Integer)m_20088_().m_135370_(DURATION)).intValue();
/*     */   }
/*     */   
/*     */   public void setDuration(int duration) {
/* 190 */     m_20088_().m_135381_(DURATION, Integer.valueOf(duration));
/*     */   }
/*     */   
/*     */   public int getCasterID() {
/* 194 */     return ((Integer)m_20088_().m_135370_(CASTER)).intValue();
/*     */   }
/*     */   
/*     */   public void setCasterID(int id) {
/* 198 */     m_20088_().m_135381_(CASTER, Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public void setPower(int power) {
/* 202 */     this.power = power;
/*     */   }
/*     */   
/*     */   private static float yawTowards(Vec3 from, Vec3 to) {
/* 206 */     Vec3 d = to.m_82546_(from);
/* 207 */     return (float)Math.atan2(d.f_82481_, d.f_82479_);
/*     */   }
/*     */   
/*     */   private static float pitchTowards(Vec3 from, Vec3 to) {
/* 211 */     Vec3 d = to.m_82546_(from);
/* 212 */     double len = d.m_82553_();
/* 213 */     return (len == 0.0D) ? 0.0F : (float)Math.asin(d.f_82480_ / len);
/*     */   }
/*     */   
/*     */   private void calculateEndPos() {
/* 217 */     double radius = 128.0D;
/* 218 */     double yaw = getYaw();
/* 219 */     double pitch = getPitch();
/*     */     
/* 221 */     this.endPosX = m_20185_() + radius * Math.cos(yaw) * Math.cos(pitch);
/* 222 */     this.endPosZ = m_20189_() + radius * Math.sin(yaw) * Math.cos(pitch);
/* 223 */     this.endPosY = m_20186_() + radius * Math.sin(pitch);
/*     */   }
/*     */ 
/*     */   
/*     */   public DragonBeamHitResult raytraceEntities(Level world, Vec3 from, Vec3 to, boolean ignoreBlockWithoutBoundingBox) {
/* 228 */     DragonBeamHitResult result = new DragonBeamHitResult();
/* 229 */     result.setBlockHit((HitResult)world.m_45547_(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)));
/* 230 */     result.setBlockHit((HitResult)world.m_45547_(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)));
/* 231 */     if (result.blockHit != null) {
/* 232 */       Vec3 hitVec = result.blockHit.m_82450_();
/* 233 */       BlockPos hitBlock = result.blockHit.m_82425_();
/*     */       
/* 235 */       this.collidePosX = hitVec.f_82479_;
/* 236 */       this.collidePosY = hitVec.f_82480_;
/* 237 */       this.collidePosZ = hitVec.f_82481_;
/* 238 */       this.blockSide = result.blockHit.m_82434_();
/*     */       
/* 240 */       if (world.f_46443_) {
/* 241 */         if (ModList.get().isLoaded("aaa_particles")) {
/* 242 */           AAAParticlesUtil.sendDragonBeamHit(world, hitBlock);
/*     */         } else {
/* 244 */           world.m_6493_((ParticleOptions)ParticleTypes.f_123813_, true, hitBlock
/*     */ 
/*     */               
/* 247 */               .m_123341_(), hitBlock.m_123342_() + 1.0D, hitBlock.m_123343_(), 0.0D, 0.0D, 0.0D);
/*     */           
/* 249 */           world.m_6493_((ParticleOptions)AnnoyingVillagersModParticleTypes.METEORITE_TRAIL
/* 250 */               .get(), true, hitBlock
/*     */               
/* 252 */               .m_123341_(), hitBlock.m_123342_() + 1.0D, hitBlock.m_123343_(), 0.0D, 0.0D, 0.0D);
/*     */           
/* 254 */           world.m_6493_((ParticleOptions)ParticleTypes.f_123747_, true, hitBlock
/*     */ 
/*     */               
/* 257 */               .m_123341_(), hitBlock.m_123342_() + 1.0D, hitBlock.m_123343_(), 0.0D, 0.0D, 0.0D);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 262 */       if (!world.f_46443_) {
/* 263 */         boolean shouldBreak = true;
/*     */         
/* 265 */         if (this.target != null && this.target.m_6084_()) {
/* 266 */           double hitDist2 = from.m_82557_(hitVec);
/* 267 */           double targetDist2 = from.m_82557_(this.target.m_20299_(1.0F));
/* 268 */           shouldBreak = (hitDist2 + 1.0E-6D < targetDist2);
/*     */           
/* 270 */           BlockPos targetFeet = this.target.m_20183_();
/* 271 */           BlockPos targetEyes = BlockPos.m_274446_((Position)this.target.m_20299_(1.0F));
/*     */           
/* 273 */           if (hitBlock.m_123342_() >= targetFeet.m_123342_() && hitBlock.m_123342_() <= targetEyes.m_123342_()) {
/* 274 */             shouldBreak = false;
/*     */           }
/*     */         } 
/*     */         
/* 278 */         if (shouldBreak) {
/* 279 */           BlockState hitState = world.m_8055_(hitBlock);
/* 280 */           if (!hitState.m_60795_()) {
/* 281 */             if (hitState.m_60800_((BlockGetter)world, hitBlock) > 0.0F) {
/* 282 */               world.m_46953_(hitBlock, true, (Entity)this.caster);
/*     */             }
/*     */             
/* 285 */             BlockPos above = hitBlock.m_7494_();
/* 286 */             if (world.m_8055_(above).m_60795_()) {
/* 287 */               world.m_46597_(above, ((EndFireBlock)AnnoyingVillagersModBlocks.END_FIRE.get()).m_49966_());
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 292 */         if (world.m_8055_(hitBlock.m_7494_()).m_60795_() && world.m_8055_(hitBlock).m_60804_((BlockGetter)world, hitBlock)) {
/* 293 */           world.m_46597_(hitBlock.m_7494_(), ((EndFireBlock)AnnoyingVillagersModBlocks.END_FIRE.get()).m_49966_());
/*     */         }
/*     */       } 
/*     */     } else {
/* 297 */       this.collidePosX = this.endPosX;
/* 298 */       this.collidePosY = this.endPosY;
/* 299 */       this.collidePosZ = this.endPosZ;
/* 300 */       this.blockSide = null;
/*     */     } 
/*     */     
/* 303 */     List<LivingEntity> entities = world.m_45976_(LivingEntity.class, (new AABB(Math.min(m_20185_(), this.collidePosX), Math.min(m_20186_(), this.collidePosY), Math.min(m_20189_(), this.collidePosZ), Math.max(m_20185_(), this.collidePosX), Math.max(m_20186_(), this.collidePosY), Math.max(m_20189_(), this.collidePosZ))).m_82377_(1.0D, 1.0D, 1.0D));
/*     */     
/* 305 */     for (LivingEntity entity : entities) {
/* 306 */       if (entity != this.caster) {
/* 307 */         float pad = entity.m_6143_() + 0.5F;
/* 308 */         AABB aabb = entity.m_20191_().m_82377_(pad, pad, pad);
/* 309 */         Optional<Vec3> hit = aabb.m_82371_(from, to);
/* 310 */         if (aabb.m_82390_(from)) {
/* 311 */           result.addEntityHit(entity); continue;
/* 312 */         }  if (hit.isPresent()) {
/* 313 */           result.addEntityHit(entity);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 318 */     return result;
/*     */   }
/*     */   
/*     */   public boolean isRenderable() {
/* 322 */     return ((this.target != null && this.target.m_6084_()) || this.targetPos != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7334_(@NotNull Entity entityIn) {}
/*     */   
/*     */   public boolean m_6087_() {
/* 329 */     return false;
/*     */   }
/*     */   
/*     */   public boolean m_6094_() {
/* 333 */     return false;
/*     */   }
/*     */   
/*     */   public boolean m_6783_(double distance) {
/* 337 */     return true;
/*     */   }
/*     */   
/*     */   private static float wrapRad(float a) {
/* 341 */     float twoPi = 6.2831855F;
/* 342 */     a %= twoPi;
/* 343 */     if (a >= Math.PI) a -= twoPi; 
/* 344 */     if (a < -3.141592653589793D) a += twoPi; 
/* 345 */     return a;
/*     */   }
/*     */   
/*     */   private static float lerpAngleRad(float a, float b) {
/* 349 */     float diff = wrapRad(b - a);
/* 350 */     return a + diff * 0.85F;
/*     */   }
/*     */   
/*     */   public void m_8119_() {
/* 354 */     super.m_8119_();
/*     */     
/* 356 */     this.prevCollidePosX = this.collidePosX;
/* 357 */     this.prevCollidePosY = this.collidePosY;
/* 358 */     this.prevCollidePosZ = this.collidePosZ;
/* 359 */     this.f_19854_ = m_20185_();
/* 360 */     this.f_19855_ = m_20186_();
/* 361 */     this.f_19856_ = m_20189_();
/*     */     
/* 363 */     this.prevYaw = this.renderYaw;
/* 364 */     this.prevPitch = this.renderPitch;
/* 365 */     if ((m_9236_()).f_46443_) {
/* 366 */       this.renderYaw = getYaw();
/* 367 */       this.renderPitch = getPitch();
/*     */     } 
/*     */     
/* 370 */     if (this.f_19797_ == 1 && (m_9236_()).f_46443_) {
/* 371 */       this.caster = (HerobrineDragonEntity)m_9236_().m_6815_(getCasterID());
/* 372 */       this.target = (LivingEntity)m_9236_().m_6815_(getTargetID());
/*     */     } 
/*     */     
/* 375 */     if ((m_9236_()).f_46443_ && this.target == null && getTargetID() != -1) {
/* 376 */       Entity e = m_9236_().m_6815_(getTargetID());
/* 377 */       if (e instanceof LivingEntity) { LivingEntity living = (LivingEntity)e;
/* 378 */         this.target = living; }
/*     */     
/*     */     } 
/*     */     
/* 382 */     if (this.caster != null) {
/* 383 */       Vec3 mouth = this.caster.beamMouthPos(1.0F);
/* 384 */       m_6034_(mouth.f_82479_, mouth.f_82480_, mouth.f_82481_);
/*     */     } 
/*     */     
/* 387 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (this.f_19797_ >= 50) {
/*     */ 
/*     */ 
/*     */         
/* 391 */         Vec3 center = (this.blockSide != null) ? new Vec3(this.collidePosX, this.collidePosY, this.collidePosZ) : ((this.targetPos != null) ? this.targetPos : m_20182_());
/*     */         
/* 393 */         ScreenShakeUtil.applyScreenShake(serverLevel, center, 24.0D, 4, 6);
/* 394 */         if (this.caster != null && this.caster.m_20197_().contains(this.caster.getSummoner()) && this.caster.getSummoner() instanceof net.minecraft.world.entity.player.Player) {
/* 395 */           center = new Vec3(this.caster.getSummoner().m_20185_(), this.caster.getSummoner().m_20186_(), this.caster.getSummoner().m_20189_());
/* 396 */           ScreenShakeUtil.applyScreenShake(serverLevel, center, 24.0D, 4, 6);
/*     */         } 
/*     */       }  }
/*     */     
/* 400 */     if (this.target != null && this.target.m_6084_()) {
/* 401 */       Vec3 from = new Vec3(m_20185_(), m_20186_(), m_20189_());
/* 402 */       Vec3 to = this.target.m_20299_(1.0F);
/*     */       
/* 404 */       this.targetPos = to;
/*     */       
/* 406 */       float targetYaw = yawTowards(from, to);
/* 407 */       float targetPitch = pitchTowards(from, to);
/*     */       
/* 409 */       float interpolatedYaw = lerpAngleRad(getYaw(), targetYaw);
/* 410 */       float interpolatedPitch = Mth.m_14179_(0.85F, getPitch(), targetPitch);
/*     */       
/* 412 */       setYaw(interpolatedYaw);
/* 413 */       setPitch(interpolatedPitch);
/*     */       
/* 415 */       if ((m_9236_()).f_46443_) {
/* 416 */         this.renderYaw = interpolatedYaw;
/* 417 */         this.renderPitch = interpolatedPitch;
/*     */       } 
/* 419 */     } else if (this.targetPos != null) {
/* 420 */       Vec3 from = new Vec3(m_20185_(), m_20186_(), m_20189_());
/* 421 */       Vec3 to = this.targetPos;
/*     */       
/* 423 */       float targetYaw = yawTowards(from, to);
/* 424 */       float targetPitch = pitchTowards(from, to);
/*     */       
/* 426 */       float interpolatedYaw = Mth.m_14179_(0.5F, getYaw(), targetYaw);
/* 427 */       float interpolatedPitch = Mth.m_14179_(0.5F, getPitch(), targetPitch);
/*     */       
/* 429 */       setYaw(interpolatedYaw);
/* 430 */       setPitch(interpolatedPitch);
/*     */       
/* 432 */       if ((m_9236_()).f_46443_) {
/* 433 */         this.renderYaw = interpolatedYaw;
/* 434 */         this.renderPitch = interpolatedPitch;
/*     */       } 
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */     
/* 440 */     if (!this.on || (this.caster != null && !this.caster.m_6084_())) {
/* 441 */       m_146870_();
/*     */       
/*     */       return;
/*     */     } 
/* 445 */     if ((m_9236_()).f_46443_ && this.f_19797_ <= 10 && this.caster != null) {
/* 446 */       int particleCount = 8;
/*     */       
/*     */       do {
/* 449 */         particleCount--;
/* 450 */       } while (particleCount != 0);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 456 */     calculateEndPos();
/*     */     
/* 458 */     if ((m_9236_()).f_46443_ && 
/* 459 */       isRenderable() && !this.renderBeam) {
/* 460 */       if (ModList.get().isLoaded("aaa_particles")) {
/* 461 */         if (this.f_19797_ >= 3) {
/* 462 */           this.renderBeam = true;
/* 463 */           AAAParticlesUtil.sendDragonBeam(this.caster.beamMouthPos(1.0F), this.target.m_20299_(1.0F), m_9236_(), this.caster, this.target);
/*     */         } 
/*     */       } else {
/* 466 */         if (this.f_19797_ >= 3) {
/* 467 */           m_9236_().m_6493_((ParticleOptions)ParticleTypes.f_123799_, true, 
/* 468 */               (this.caster.beamMouthPos(1.0F)).f_82479_ + (new Random()).nextDouble(-1.0D, 1.0D), 
/* 469 */               (this.caster.beamMouthPos(1.0F)).f_82480_ + (new Random()).nextDouble(-1.0D, 1.0D), 
/* 470 */               (this.caster.beamMouthPos(1.0F)).f_82481_ + (new Random()).nextDouble(-1.0D, 1.0D), 0.0D, 0.0D, 0.0D);
/*     */         }
/*     */         
/* 473 */         if (this.f_19797_ >= 50) {
/* 474 */           this.renderBeam = true;
/* 475 */           setUseNoVfxThunder(true);
/* 476 */           setThunderStartStop(this.caster.beamMouthPos(1.0F), this.target.m_20097_().m_252807_());
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 482 */     if (isRenderable() && this.f_19797_ >= 50) {
/* 483 */       if (!this.playSound) {
/* 484 */         this.playSound = true;
/* 485 */         m_5496_((SoundEvent)AnnoyingVillagersModSounds.DRAGON_BREATH.get(), 5.0F, 1.0F);
/*     */       } 
/* 487 */       List<LivingEntity> hit = (raytraceEntities(m_9236_(), new Vec3(m_20185_(), m_20186_(), m_20189_()), new Vec3(this.endPosX, this.endPosY, this.endPosZ), true)).entities;
/* 488 */       if (!(m_9236_()).f_46443_) {
/* 489 */         for (LivingEntity target : hit) {
/* 490 */           target.m_6469_(m_269291_().m_269104_(this, (Entity)this.caster.getSummoner()), this.power);
/* 491 */           LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)target, LivingEntityPatch.class);
/* 492 */           EpicfightUtil.dealStaminaDamage(m_269291_().m_269104_(this, (Entity)this.caster.getSummoner()), 0.1F, livingEntityPatch, false);
/* 493 */           target.f_19864_ = true;
/* 494 */           target.m_20334_(0.0D, 0.0D, 0.0D);
/* 495 */           target.m_6001_(0.0D, 0.0D, 0.0D);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 500 */     if (this.f_19797_ > getDuration()) {
/* 501 */       this.on = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 507 */     YAW = SynchedEntityData.m_135353_(DragonBeamEntity.class, EntityDataSerializers.f_135029_);
/* 508 */     PITCH = SynchedEntityData.m_135353_(DragonBeamEntity.class, EntityDataSerializers.f_135029_);
/* 509 */     DURATION = SynchedEntityData.m_135353_(DragonBeamEntity.class, EntityDataSerializers.f_135028_);
/* 510 */     CASTER = SynchedEntityData.m_135353_(DragonBeamEntity.class, EntityDataSerializers.f_135028_);
/* 511 */     TARGET = SynchedEntityData.m_135353_(DragonBeamEntity.class, EntityDataSerializers.f_135028_);
/*     */   }
/*     */   
/*     */   public static class DragonBeamHitResult {
/*     */     private BlockHitResult blockHit;
/* 516 */     private final List<LivingEntity> entities = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BlockHitResult getBlockHit() {
/* 522 */       return this.blockHit;
/*     */     }
/*     */     
/*     */     public void setBlockHit(HitResult rayTraceResult) {
/* 526 */       if (rayTraceResult.m_6662_() == HitResult.Type.BLOCK) {
/* 527 */         this.blockHit = (BlockHitResult)rayTraceResult;
/*     */       }
/*     */     }
/*     */     
/*     */     public void addEntityHit(LivingEntity entity) {
/* 532 */       this.entities.add(entity);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\DragonBeamEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */