/*      */ package com.pla.annoyingvillagers.entity;
/*      */ import com.pla.annoyingvillagers.clazz.TridentMode;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*      */ import com.pla.annoyingvillagers.item.BlueDemonChestplateItem;
/*      */ import com.pla.annoyingvillagers.item.BlueDemonTridentItem;
/*      */ import java.util.Comparator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import javax.annotation.Nullable;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.core.Direction;
/*      */ import net.minecraft.core.Position;
/*      */ import net.minecraft.core.Vec3i;
/*      */ import net.minecraft.core.particles.ParticleOptions;
/*      */ import net.minecraft.nbt.CompoundTag;
/*      */ import net.minecraft.network.syncher.EntityDataAccessor;
/*      */ import net.minecraft.network.syncher.EntityDataSerializers;
/*      */ import net.minecraft.network.syncher.SynchedEntityData;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.sounds.SoundEvent;
/*      */ import net.minecraft.sounds.SoundEvents;
/*      */ import net.minecraft.sounds.SoundSource;
/*      */ import net.minecraft.tags.DamageTypeTags;
/*      */ import net.minecraft.util.Mth;
/*      */ import net.minecraft.world.damagesource.DamageSource;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.entity.EntityType;
/*      */ import net.minecraft.world.entity.LightningBolt;
/*      */ import net.minecraft.world.entity.LivingEntity;
/*      */ import net.minecraft.world.entity.player.Player;
/*      */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*      */ import net.minecraft.world.entity.projectile.ThrownTrident;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.phys.AABB;
/*      */ import net.minecraft.world.phys.BlockHitResult;
/*      */ import net.minecraft.world.phys.EntityHitResult;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import net.minecraftforge.network.PlayMessages;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ 
/*      */ public class BlueDemonThrownTridentEntity extends ThrownTrident {
/*   46 */   private TridentMode mode = TridentMode.DEFAULT;
/*      */   
/*      */   private static final int MAX_GROUNDED_TRIDENTS_PER_OWNER = 20;
/*      */   
/*      */   private static final double OWNER_BOX_HALF_SIZE = 50.0D;
/*      */   
/*      */   private static final String TAG_SPAWN_SEQUENCE = "BlueDemonSpawnSequence";
/*      */   private static final String TAG_OWNER_SHOT_COUNTER = "BlueDemonOwnerShotCounter";
/*      */   private static final int RELAUNCH_ANIMATION_DURATION = 20;
/*      */   private boolean relaunchAnimationActive = false;
/*   56 */   private int relaunchAnimationTick = 0;
/*   57 */   private Vec3 relaunchAnimationStart = Vec3.f_82478_;
/*   58 */   private Vec3 relaunchAnimationEnd = Vec3.f_82478_;
/*      */   private boolean relaunchDelayActive = false;
/*   60 */   private int relaunchDelayTicks = 0;
/*   61 */   private int relaunchDelayTick = 0;
/*      */   
/*      */   private boolean festivalGroundRiseActive = false;
/*      */   private boolean summonedGroundTridentFestival = false;
/*   65 */   private int festivalGroundRiseTick = 0;
/*   66 */   private Vec3 festivalGroundRiseStart = Vec3.f_82478_;
/*   67 */   private Vec3 festivalGroundRiseEnd = Vec3.f_82478_;
/*      */   private static final int FESTIVAL_GROUND_RISE_DURATION = 6;
/*      */   private static final double FESTIVAL_RISE_START_DEPTH = 1.0D;
/*      */   private static final double FESTIVAL_RISE_END_OFFSET = 0.0D;
/*   71 */   private float festivalPoseXRot = 90.0F;
/*   72 */   private float festivalPoseYRot = 0.0F;
/*   73 */   private double festivalPoseYOffset = 0.0D;
/*      */   @Nullable
/*   75 */   private UUID queuedTargetUUID = null;
/*      */   @Nullable
/*   77 */   private Vec3 queuedFallbackDirection = null;
/*      */   
/*   79 */   private float queuedLaunchSpeed = 0.0F;
/*      */   
/*      */   private long spawnSequence;
/*      */   
/*      */   private static final float ABSORB_HEAL_AMOUNT = 2.0F;
/*      */   private static final double ABSORB_FINISH_DISTANCE_SQR = 1.0D;
/*      */   private boolean absorbToWearerActive = false;
/*      */   @Nullable
/*   87 */   private UUID absorbWearerUUID = null;
/*      */ 
/*      */   
/*   90 */   private Vec3 absorbStartGroundPos = Vec3.f_82478_;
/*      */   @Nullable
/*   92 */   private Direction absorbReturnFace = null;
/*      */ 
/*      */   
/*      */   private boolean isRelaunchLocked() {
/*   96 */     return (this.festivalGroundRiseActive || this.relaunchAnimationActive || this.relaunchDelayActive || this.absorbToWearerActive);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSummonedGroundTridentFestival() {
/*  103 */     return this.summonedGroundTridentFestival;
/*      */   }
/*      */   
/*      */   public void setSummonedGroundTridentFestival(boolean summonedGroundTridentFestival) {
/*  107 */     this.summonedGroundTridentFestival = summonedGroundTridentFestival;
/*      */   }
/*      */   
/*      */   public boolean isAbsorbingToWearer() {
/*  111 */     return this.absorbToWearerActive;
/*      */   }
/*      */   
/*      */   public TridentMode getMode() {
/*  115 */     return this.mode;
/*      */   }
/*      */   
/*      */   public void placeAsGroundedSupport(@NotNull LivingEntity owner, @NotNull BlockPos standPos) {
/*  119 */     m_5602_((Entity)owner);
/*  120 */     this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*  121 */     this.specialImpactTriggered = true;
/*  122 */     this.f_37556_ = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  127 */     Vec3 pos = new Vec3(standPos.m_123341_() + 0.5D, standPos.m_123342_() + 0.05D, standPos.m_123343_() + 0.5D);
/*      */ 
/*      */     
/*  130 */     m_6034_(pos.f_82479_, pos.f_82480_, pos.f_82481_);
/*  131 */     m_20256_(Vec3.f_82478_);
/*  132 */     m_36790_(false);
/*  133 */     m_20242_(false);
/*  134 */     this.f_19812_ = false;
/*  135 */     m_146915_(false);
/*      */     
/*  137 */     m_8060_(new BlockHitResult(pos, Direction.UP, standPos.m_7495_(), false));
/*      */   }
/*      */   
/*      */   public void beginAbsorbToWearer(@NotNull LivingEntity entity) {
/*  141 */     if (this.absorbToWearerActive || this.relaunchAnimationActive || this.relaunchDelayActive) {
/*      */       return;
/*      */     }
/*      */     
/*  145 */     if (!this.f_36703_ || !belongsToOwner(entity)) {
/*      */       return;
/*      */     }
/*  148 */     this.absorbToWearerActive = true;
/*  149 */     this.absorbWearerUUID = entity.m_20148_();
/*  150 */     this.absorbStartGroundPos = m_20182_();
/*  151 */     this.absorbReturnFace = getStuckFace();
/*      */     
/*  153 */     this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */     
/*  155 */     setStuckFace((Direction)null);
/*  156 */     this.f_36703_ = false;
/*  157 */     this.f_36704_ = 0;
/*  158 */     this.f_36706_ = 0;
/*      */     
/*  160 */     m_36790_(true);
/*  161 */     m_20242_(true);
/*  162 */     m_20256_(Vec3.f_82478_);
/*  163 */     this.f_19812_ = false;
/*  164 */     m_146915_(true);
/*      */   }
/*      */   @Nullable
/*      */   private LivingEntity getAbsorbWearer() {
/*      */     ServerLevel serverLevel;
/*  169 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; if (this.absorbWearerUUID == null)
/*  170 */         return null;  } else { return null; }
/*      */ 
/*      */     
/*  173 */     Entity entity = serverLevel.m_8791_(this.absorbWearerUUID);
/*  174 */     if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_()); }  return null;
/*      */   }
/*      */   
/*      */   private boolean canContinueAbsorbToWearer(@NotNull LivingEntity entity) {
/*  178 */     if (!belongsToOwner(entity)) {
/*  179 */       return false;
/*      */     }
/*      */     
/*  182 */     if (entity instanceof Player) { Player player = (Player)entity;
/*  183 */       ItemStack chest = player.m_6844_(EquipmentSlot.CHEST);
/*  184 */       return (BlueDemonChestplateItem.isBlueDemonChestplate(chest) && 
/*  185 */         BlueDemonChestplateItem.isBuffActive(chest)); }
/*      */ 
/*      */     
/*  188 */     if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity;
/*  189 */       return (blueDemonEntity.getHealingTick() != 0); }
/*      */ 
/*      */     
/*  192 */     return false;
/*      */   }
/*      */   
/*      */   private void cancelAbsorbToWearer() {
/*  196 */     this.absorbToWearerActive = false;
/*  197 */     this.absorbWearerUUID = null;
/*      */     
/*  199 */     m_36790_(false);
/*  200 */     m_20242_(false);
/*  201 */     this.f_19812_ = false;
/*  202 */     this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */     
/*  204 */     m_6034_(this.absorbStartGroundPos.f_82479_, this.absorbStartGroundPos.f_82480_, this.absorbStartGroundPos.f_82481_);
/*  205 */     m_20256_(Vec3.f_82478_);
/*      */     
/*  207 */     this.f_36703_ = true;
/*  208 */     this.f_36704_ = 0;
/*  209 */     this.f_36706_ = 0;
/*  210 */     setStuckFace(this.absorbReturnFace);
/*  211 */     m_146915_(false);
/*      */   }
/*      */   
/*      */   private void finishAbsorbToWearer(@NotNull LivingEntity entity) {
/*  215 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  216 */       entity.m_5634_(2.0F);
/*      */       
/*  218 */       serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/*  219 */           .get(), 
/*  220 */           m_20185_(), m_20186_(), m_20189_(), 6, 0.15D, 0.15D, 0.15D, 0.02D);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  226 */       serverLevel.m_5594_(null, 
/*      */           
/*  228 */           BlockPos.m_274561_(m_20185_(), m_20186_(), m_20189_()), SoundEvents.f_12516_, SoundSource.PLAYERS, 0.8F, 1.35F); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  236 */     m_146870_();
/*      */   }
/*      */   
/*      */   private void tickAbsorbToWearer() {
/*  240 */     LivingEntity entity = getAbsorbWearer();
/*  241 */     if (entity == null || !canContinueAbsorbToWearer(entity)) {
/*  242 */       cancelAbsorbToWearer();
/*      */       
/*      */       return;
/*      */     } 
/*  246 */     Vec3 targetPos = entity.m_20182_().m_82520_(0.0D, entity.m_20206_() * 0.55D, 0.0D);
/*  247 */     Vec3 toTarget = targetPos.m_82546_(m_20182_());
/*  248 */     double distanceSqr = toTarget.m_82556_();
/*      */     
/*  250 */     if (distanceSqr <= 1.0D) {
/*  251 */       finishAbsorbToWearer(entity);
/*      */       
/*      */       return;
/*      */     } 
/*  255 */     double distance = Math.sqrt(distanceSqr);
/*  256 */     Vec3 move = toTarget.m_82541_().m_82490_(Math.min(0.85D, 0.18D + distance * 0.12D));
/*      */     
/*  258 */     m_6034_(m_20185_() + move.f_82479_, m_20186_() + move.f_82480_, m_20189_() + move.f_82481_);
/*  259 */     m_20256_(Vec3.f_82478_);
/*  260 */     updateRotationFromMovement(move);
/*      */     
/*  262 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (serverLevel.f_46441_.m_188500_() <= 0.25D) {
/*  263 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/*  264 */             .get(), 
/*  265 */             m_20185_(), m_20186_(), m_20189_(), 1, 0.05D, 0.05D, 0.05D, 0.0D);
/*      */       } }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void m_6123_(@NotNull Player player) {
/*  275 */     if (isRelaunchLocked()) {
/*      */       return;
/*      */     }
/*  278 */     super.m_6123_(player);
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean m_142470_(@NotNull Player player) {
/*  283 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean festivalGroundedPoseActive = false;
/*      */   private static final double FESTIVAL_FORCE_HITBLOCK_REMAINING_Y = 0.65D;
/*  289 */   private static final EntityDataAccessor<Boolean> DATA_FESTIVAL_GROUNDED_POSE = SynchedEntityData.m_135353_(BlueDemonThrownTridentEntity.class, EntityDataSerializers.f_135035_);
/*      */   
/*  291 */   private static final EntityDataAccessor<Float> DATA_FESTIVAL_POSE_XROT = SynchedEntityData.m_135353_(BlueDemonThrownTridentEntity.class, EntityDataSerializers.f_135029_);
/*      */   
/*  293 */   private static final EntityDataAccessor<Float> DATA_FESTIVAL_POSE_YROT = SynchedEntityData.m_135353_(BlueDemonThrownTridentEntity.class, EntityDataSerializers.f_135029_);
/*      */   
/*      */   private boolean specialImpactTriggered = false;
/*  296 */   private static final EntityDataAccessor<Byte> DATA_STUCK_FACE = SynchedEntityData.m_135353_(BlueDemonThrownTridentEntity.class, EntityDataSerializers.f_135027_);
/*      */   
/*  298 */   private static final EntityDataAccessor<Boolean> DATA_FESTIVAL_RISE_ACTIVE = SynchedEntityData.m_135353_(BlueDemonThrownTridentEntity.class, EntityDataSerializers.f_135035_);
/*      */   
/*  300 */   private static final EntityDataAccessor<Float> DATA_FESTIVAL_START_Y = SynchedEntityData.m_135353_(BlueDemonThrownTridentEntity.class, EntityDataSerializers.f_135029_);
/*      */   
/*  302 */   private static final EntityDataAccessor<Float> DATA_FESTIVAL_END_Y = SynchedEntityData.m_135353_(BlueDemonThrownTridentEntity.class, EntityDataSerializers.f_135029_);
/*      */   
/*      */   @Nullable
/*      */   public Direction getStuckFace() {
/*  306 */     byte value = ((Byte)this.f_19804_.m_135370_(DATA_STUCK_FACE)).byteValue();
/*  307 */     return (value == -1) ? null : Direction.m_122376_(value);
/*      */   }
/*      */   
/*      */   public void setStuckFace(@Nullable Direction direction) {
/*  311 */     this.f_19804_.m_135381_(DATA_STUCK_FACE, Byte.valueOf((direction == null) ? -1 : (byte)direction.m_122411_()));
/*      */   }
/*      */   
/*      */   public void beginFestivalGroundRise(@NotNull LivingEntity owner, @NotNull BlockPos standPos, boolean strikeWhenFinished) {
/*  315 */     if (this.festivalGroundRiseActive || this.relaunchAnimationActive || this.relaunchDelayActive || this.absorbToWearerActive) {
/*      */       return;
/*      */     }
/*  318 */     clearFestivalGroundedPose();
/*  319 */     m_5602_((Entity)owner);
/*  320 */     this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*  321 */     this.specialImpactTriggered = true;
/*  322 */     this.f_37556_ = false;
/*      */     
/*  324 */     this.f_19804_.m_135381_(DATA_FESTIVAL_RISE_ACTIVE, Boolean.valueOf(true));
/*  325 */     this.summonedGroundTridentFestival = true;
/*  326 */     this.festivalGroundRiseActive = true;
/*  327 */     this.festivalGroundRiseTick = 0;
/*  328 */     rollFestivalPose();
/*      */     
/*  330 */     double endX = standPos.m_123341_() + 0.5D;
/*  331 */     double endY = standPos.m_123342_() + 0.0D + this.festivalPoseYOffset;
/*  332 */     double endZ = standPos.m_123343_() + 0.5D;
/*      */     
/*  334 */     this.festivalGroundRiseEnd = new Vec3(endX, endY, endZ);
/*  335 */     this.festivalGroundRiseStart = new Vec3(endX, endY - 1.0D, endZ);
/*  336 */     this.f_19804_.m_135381_(DATA_FESTIVAL_START_Y, Float.valueOf((float)this.festivalGroundRiseStart.f_82480_));
/*  337 */     this.f_19804_.m_135381_(DATA_FESTIVAL_END_Y, Float.valueOf((float)this.festivalGroundRiseEnd.f_82480_));
/*      */     
/*  339 */     this.f_36703_ = false;
/*  340 */     this.f_36704_ = 0;
/*  341 */     this.f_36706_ = 0;
/*  342 */     setStuckFace((Direction)null);
/*      */     
/*  344 */     m_6034_(this.festivalGroundRiseStart.f_82479_, this.festivalGroundRiseStart.f_82480_, this.festivalGroundRiseStart.f_82481_);
/*  345 */     m_20256_(Vec3.f_82478_);
/*      */     
/*  347 */     m_36790_(true);
/*  348 */     m_20242_(true);
/*  349 */     this.f_19812_ = false;
/*      */     
/*  351 */     m_146915_(true);
/*  352 */     applyFestivalVerticalPose();
/*      */   }
/*      */   
/*      */   private void tickFestivalGroundRise() {
/*  356 */     this.festivalGroundRiseTick++;
/*      */     
/*  358 */     float t = Math.min(1.0F, this.festivalGroundRiseTick / 6.0F);
/*  359 */     double nextY = Mth.m_14139_(t, this.festivalGroundRiseStart.f_82480_, this.festivalGroundRiseEnd.f_82480_);
/*      */     
/*  361 */     if (this.festivalGroundRiseEnd.f_82480_ - nextY <= 0.65D) {
/*  362 */       finishFestivalGroundRise();
/*      */       
/*      */       return;
/*      */     } 
/*  366 */     this.f_19854_ = m_20185_();
/*  367 */     this.f_19855_ = m_20186_();
/*  368 */     this.f_19856_ = m_20189_();
/*      */     
/*  370 */     m_6034_(this.festivalGroundRiseStart.f_82479_, nextY, this.festivalGroundRiseStart.f_82481_);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  375 */     m_20256_(Vec3.f_82478_);
/*  376 */     applyFestivalVerticalPose();
/*  377 */     m_146915_(true);
/*      */     
/*  379 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  380 */       serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/*  381 */           .get(), 
/*  382 */           m_20185_(), m_20186_(), m_20189_(), 2, 0.08D, 0.1D, 0.08D, 0.01D); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  389 */     if (this.festivalGroundRiseTick >= 6) {
/*  390 */       finishFestivalGroundRise();
/*      */     }
/*      */   }
/*      */   
/*      */   private void finishFestivalGroundRise() {
/*  395 */     if (!(m_9236_()).f_46443_) {
/*  396 */       this.f_19804_.m_135381_(DATA_FESTIVAL_RISE_ACTIVE, Boolean.valueOf(false));
/*      */     }
/*      */     
/*  399 */     this.festivalGroundRiseActive = false;
/*  400 */     this.festivalGroundRiseTick = 0;
/*      */     
/*  402 */     releaseFestivalGroundedPose(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_142391_() {
/*  407 */     return (this.f_36703_ && !this.festivalGroundRiseActive && !this.relaunchAnimationActive && !this.relaunchDelayActive && !this.absorbToWearerActive);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BlueDemonThrownTridentEntity(EntityType<? extends ThrownTrident> type, Level level) {
/*  415 */     super(type, level);
/*      */   }
/*      */   
/*      */   public BlueDemonThrownTridentEntity(PlayMessages.SpawnEntity packet, Level level) {
/*  419 */     this((EntityType<? extends ThrownTrident>)AnnoyingVillagersModEntities.BLUE_DEMON_THROWN_TRIDENT.get(), level);
/*      */   }
/*      */   
/*      */   public BlueDemonThrownTridentEntity(Level level, LivingEntity shooter, ItemStack stack) {
/*  423 */     super((EntityType)AnnoyingVillagersModEntities.BLUE_DEMON_THROWN_TRIDENT.get(), level);
/*  424 */     m_5602_((Entity)shooter);
/*  425 */     this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void m_8097_() {
/*  430 */     super.m_8097_();
/*  431 */     this.f_19804_.m_135372_(DATA_STUCK_FACE, Byte.valueOf((byte)-1));
/*  432 */     this.f_19804_.m_135372_(DATA_FESTIVAL_RISE_ACTIVE, Boolean.valueOf(false));
/*  433 */     this.f_19804_.m_135372_(DATA_FESTIVAL_GROUNDED_POSE, Boolean.valueOf(false));
/*  434 */     this.f_19804_.m_135372_(DATA_FESTIVAL_POSE_XROT, Float.valueOf(90.0F));
/*  435 */     this.f_19804_.m_135372_(DATA_FESTIVAL_POSE_YROT, Float.valueOf(0.0F));
/*  436 */     this.f_19804_.m_135372_(DATA_FESTIVAL_START_Y, Float.valueOf(0.0F));
/*  437 */     this.f_19804_.m_135372_(DATA_FESTIVAL_END_Y, Float.valueOf(0.0F));
/*      */   }
/*      */   
/*      */   private void syncFestivalPoseFromData() {
/*  441 */     this.festivalPoseXRot = ((Float)this.f_19804_.m_135370_(DATA_FESTIVAL_POSE_XROT)).floatValue();
/*  442 */     this.festivalPoseYRot = ((Float)this.f_19804_.m_135370_(DATA_FESTIVAL_POSE_YROT)).floatValue();
/*      */   }
/*      */   
/*      */   private void clearFestivalGroundedPose() {
/*  446 */     this.festivalGroundedPoseActive = false;
/*      */     
/*  448 */     if (!(m_9236_()).f_46443_) {
/*  449 */       this.f_19804_.m_135381_(DATA_FESTIVAL_GROUNDED_POSE, Boolean.valueOf(false));
/*      */     }
/*      */     
/*  452 */     m_20256_(Vec3.f_82478_);
/*  453 */     this.f_19812_ = false;
/*  454 */     m_36790_(false);
/*  455 */     m_20242_(false);
/*      */   }
/*      */   
/*      */   public void setMode(TridentMode mode) {
/*  459 */     this.mode = (mode == null) ? TridentMode.DEFAULT : mode;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public LivingEntity getOwnerLiving() {
/*  464 */     Entity entity = m_19749_(); LivingEntity living = (LivingEntity)entity; return (entity instanceof LivingEntity) ? living : null;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void m_5790_(EntityHitResult result) {
/*  469 */     Entity target = result.m_82443_();
/*  470 */     Entity owner = m_19749_();
/*      */     
/*  472 */     float damage = 8.0F;
/*  473 */     DamageSource damageSource = m_269291_().m_269525_((Entity)this, (owner == null) ? (Entity)this : owner);
/*      */     
/*  475 */     this.f_37556_ = true;
/*  476 */     SoundEvent sound = SoundEvents.f_12514_;
/*      */     
/*  478 */     boolean hurtSuccess = target.m_6469_(damageSource, damage);
/*      */     
/*  480 */     if (hurtSuccess) {
/*  481 */       LivingEntity livingTarget = (LivingEntity)target; if (target instanceof LivingEntity && (new Random()).nextFloat() <= 0.15F) {
/*  482 */         livingTarget.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ELECTRIFY
/*  483 */               .get(), 20, 1));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  489 */       if (!(m_9236_()).f_46443_ && !this.specialImpactTriggered) {
/*  490 */         this.specialImpactTriggered = true;
/*  491 */         handleModeImpact(target.m_20183_(), target);
/*      */       } 
/*      */     } 
/*      */     
/*  495 */     m_20256_(m_20184_().m_82542_(-0.01D, -0.1D, -0.01D));
/*  496 */     m_5496_(sound, 1.0F, 1.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_8119_() {
/*  501 */     if ((m_9236_()).f_46443_) {
/*  502 */       boolean riseActive = ((Boolean)this.f_19804_.m_135370_(DATA_FESTIVAL_RISE_ACTIVE)).booleanValue();
/*  503 */       boolean groundedPoseActive = ((Boolean)this.f_19804_.m_135370_(DATA_FESTIVAL_GROUNDED_POSE)).booleanValue();
/*      */       
/*  505 */       if (riseActive) {
/*  506 */         if (!this.festivalGroundRiseActive) {
/*  507 */           startFestivalGroundRiseClient();
/*      */         }
/*  509 */       } else if (groundedPoseActive) {
/*  510 */         if (!this.festivalGroundedPoseActive) {
/*  511 */           startFestivalGroundedPoseClient();
/*      */         }
/*  513 */       } else if (this.festivalGroundedPoseActive) {
/*  514 */         clearFestivalGroundedPose();
/*      */       } 
/*      */     } 
/*      */     
/*  518 */     if (this.festivalGroundRiseActive) {
/*  519 */       m_6075_();
/*  520 */       this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*  521 */       tickFestivalGroundRise();
/*  522 */       tickElectricEffects();
/*      */       
/*      */       return;
/*      */     } 
/*  526 */     if (this.festivalGroundedPoseActive) {
/*  527 */       m_6075_();
/*  528 */       this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */       
/*  530 */       m_20256_(Vec3.f_82478_);
/*  531 */       this.f_19812_ = false;
/*      */       
/*  533 */       this.f_36703_ = true;
/*  534 */       this.f_36704_ = 0;
/*  535 */       this.f_36706_ = 0;
/*  536 */       setStuckFace(Direction.UP);
/*      */       
/*  538 */       m_36790_(true);
/*  539 */       m_20242_(true);
/*  540 */       applyFestivalVerticalPose();
/*      */       
/*  542 */       if (!(m_9236_()).f_46443_ && this.f_19797_ % 10 == 0) {
/*  543 */         discardIfGroundedAndFarFromOwner();
/*  544 */         if (!m_6084_()) {
/*      */           return;
/*      */         }
/*      */       } 
/*      */       
/*  549 */       tickElectricEffects();
/*      */       
/*      */       return;
/*      */     } 
/*  553 */     if (!(m_9236_()).f_46443_ && this.absorbToWearerActive) {
/*  554 */       m_6075_();
/*  555 */       this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*  556 */       tickAbsorbToWearer();
/*  557 */       tickElectricEffects();
/*      */       
/*      */       return;
/*      */     } 
/*  561 */     if (!(m_9236_()).f_46443_ && (this.relaunchAnimationActive || this.relaunchDelayActive)) {
/*  562 */       m_6075_();
/*  563 */       this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */       
/*  565 */       if (this.relaunchAnimationActive) {
/*  566 */         tickAnimatedRelaunch();
/*      */       } else {
/*  568 */         tickRelaunchDelay();
/*      */       } 
/*      */       
/*  571 */       tickElectricEffects();
/*      */       
/*      */       return;
/*      */     } 
/*  575 */     super.m_8119_();
/*      */     
/*  577 */     if (!(m_9236_()).f_46443_ && this.f_36703_ && this.f_19797_ % 10 == 0) {
/*  578 */       discardIfGroundedAndFarFromOwner();
/*  579 */       if (!m_6084_()) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */     
/*  584 */     tickElectricEffects();
/*      */   }
/*      */   protected void handleModeImpact(BlockPos pos, @Nullable Entity hitTarget) {
/*      */     ServerLevel serverLevel;
/*  588 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*      */     else
/*      */     { return; }
/*      */     
/*  592 */     switch (this.mode) {
/*      */ 
/*      */       
/*      */       case LIGHTNING:
/*  596 */         spawnTridentLightning(serverLevel, pos, hitTarget);
/*      */         break;
/*      */       case EXPLOSION:
/*  599 */         spawnTridentExplosion(serverLevel, pos, hitTarget);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void spawnTridentLightning(ServerLevel serverLevel, BlockPos pos, Entity hitTarget) {
/*  606 */     TridentLightningBolt lightning = new TridentLightningBolt((EntityType<? extends LightningBolt>)AnnoyingVillagersModEntities.TRIDENT_LIGHTNING_BOLT.get(), (Level)serverLevel);
/*      */ 
/*      */ 
/*      */     
/*  610 */     lightning.m_20219_(Vec3.m_82539_((Vec3i)pos));
/*  611 */     lightning.setDamage(5.0F);
/*  612 */     m_146915_(false);
/*      */     
/*  614 */     LivingEntity owner = getOwnerLiving();
/*  615 */     if (owner != null) {
/*  616 */       lightning.setOwner(owner);
/*      */     }
/*      */     
/*  619 */     serverLevel.m_7967_((Entity)lightning);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void spawnSuperTridentLightning(ServerLevel serverLevel, BlockPos pos, Entity hitTarget) {
/*  624 */     TridentLightningBolt lightning = new TridentLightningBolt((EntityType<? extends LightningBolt>)AnnoyingVillagersModEntities.TRIDENT_LIGHTNING_BOLT.get(), (Level)serverLevel);
/*      */ 
/*      */ 
/*      */     
/*  628 */     m_146915_(false);
/*  629 */     lightning.m_20219_(Vec3.m_82539_((Vec3i)pos));
/*  630 */     lightning.setSuperLightning(true);
/*  631 */     lightning.setDamage(15.0F);
/*      */     
/*  633 */     LivingEntity owner = getOwnerLiving();
/*  634 */     if (owner != null) {
/*  635 */       lightning.setOwner(owner);
/*      */     }
/*      */     
/*  638 */     serverLevel.m_7967_((Entity)lightning);
/*      */   }
/*      */   
/*      */   protected void spawnTridentExplosion(ServerLevel serverLevel, BlockPos pos, Entity hitTarget) {
/*  642 */     Entity owner = m_19749_();
/*      */     
/*  644 */     serverLevel.m_254849_(owner, 
/*      */         
/*  646 */         m_20185_(), 
/*  647 */         m_20186_(), 
/*  648 */         m_20189_(), 2.5F, Level.ExplosionInteraction.TNT);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void assignSpawnSequence(@NotNull LivingEntity owner) {
/*      */     ServerLevel serverLevel;
/*  655 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*      */     else
/*      */     { return; }
/*      */     
/*  659 */     CompoundTag ownerData = owner.getPersistentData();
/*  660 */     int shotCounter = ownerData.m_128451_("BlueDemonOwnerShotCounter") + 1 & 0xFFFF;
/*  661 */     ownerData.m_128405_("BlueDemonOwnerShotCounter", shotCounter);
/*      */     
/*  663 */     this.spawnSequence = serverLevel.m_46467_() << 16L | shotCounter & 0xFFFFL;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_6128_() {
/*  668 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_6673_(@NotNull DamageSource source) {
/*  673 */     return (source.m_269533_(DamageTypeTags.f_268415_) || super.m_6673_(source));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_6469_(@NotNull DamageSource source, float amount) {
/*  678 */     if (source.m_269533_(DamageTypeTags.f_268415_)) {
/*  679 */       return false;
/*      */     }
/*  681 */     return super.m_6469_(source, amount);
/*      */   }
/*      */   
/*      */   public long getSpawnSequence() {
/*  685 */     return this.spawnSequence;
/*      */   }
/*      */   
/*      */   private static AABB makeOwnerGroundBox(Entity owner) {
/*  689 */     Level level = owner.m_9236_();
/*  690 */     return new AABB(owner
/*  691 */         .m_20185_() - 50.0D, level
/*  692 */         .m_141937_(), owner
/*  693 */         .m_20189_() - 50.0D, owner
/*  694 */         .m_20185_() + 50.0D, level
/*  695 */         .m_151558_(), owner
/*  696 */         .m_20189_() + 50.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean isGroundedForLimit() {
/*  701 */     return this.f_36703_;
/*      */   }
/*      */   
/*      */   private boolean hasSameOwner(UUID ownerUuid) {
/*  705 */     Entity owner = m_19749_();
/*  706 */     return (owner != null && owner.m_20148_().equals(ownerUuid));
/*      */   }
/*      */   
/*      */   private boolean isOutsideOwnerGroundBox(Entity owner) {
/*  710 */     return (Math.abs(m_20185_() - owner.m_20185_()) > 50.0D || 
/*  711 */       Math.abs(m_20189_() - owner.m_20189_()) > 50.0D);
/*      */   }
/*      */   
/*      */   private void startFestivalGroundRiseClient() {
/*  715 */     this.festivalGroundedPoseActive = false;
/*  716 */     this.festivalGroundRiseActive = true;
/*  717 */     this.festivalGroundRiseTick = 0;
/*      */     
/*  719 */     syncFestivalPoseFromData();
/*      */     
/*  721 */     double x = m_20185_();
/*  722 */     double z = m_20189_();
/*  723 */     double startY = ((Float)this.f_19804_.m_135370_(DATA_FESTIVAL_START_Y)).floatValue();
/*  724 */     double endY = ((Float)this.f_19804_.m_135370_(DATA_FESTIVAL_END_Y)).floatValue();
/*      */     
/*  726 */     this.festivalGroundRiseStart = new Vec3(x, startY, z);
/*  727 */     this.festivalGroundRiseEnd = new Vec3(x, endY, z);
/*      */     
/*  729 */     m_6034_(x, startY, z);
/*  730 */     this.f_19854_ = x;
/*  731 */     this.f_19855_ = startY;
/*  732 */     this.f_19856_ = z;
/*      */     
/*  734 */     this.f_36703_ = false;
/*  735 */     this.f_36704_ = 0;
/*  736 */     this.f_36706_ = 0;
/*  737 */     setStuckFace((Direction)null);
/*      */     
/*  739 */     m_36790_(true);
/*  740 */     m_20242_(true);
/*  741 */     m_20256_(Vec3.f_82478_);
/*  742 */     this.f_19812_ = false;
/*      */     
/*  744 */     m_146915_(true);
/*  745 */     applyFestivalVerticalPose();
/*      */   }
/*      */   
/*      */   private void startFestivalGroundedPoseClient() {
/*  749 */     this.festivalGroundedPoseActive = true;
/*  750 */     syncFestivalPoseFromData();
/*      */     
/*  752 */     m_20256_(Vec3.f_82478_);
/*  753 */     this.f_19812_ = false;
/*      */     
/*  755 */     this.f_36703_ = true;
/*  756 */     this.f_36704_ = 0;
/*  757 */     this.f_36706_ = 0;
/*  758 */     setStuckFace(Direction.UP);
/*      */     
/*  760 */     m_36790_(true);
/*  761 */     m_20242_(true);
/*      */     
/*  763 */     applyFestivalVerticalPose();
/*      */   }
/*      */   
/*      */   private void releaseFestivalGroundedPose(boolean glowing) {
/*  767 */     releaseFestivalGroundedPose(glowing, true);
/*      */   }
/*      */   
/*      */   private void releaseFestivalGroundedPose(boolean glowing, boolean noPhysicGravity) {
/*  771 */     Vec3 finalPos = this.festivalGroundRiseEnd;
/*      */     
/*  773 */     this.festivalGroundedPoseActive = true;
/*  774 */     if (!(m_9236_()).f_46443_) {
/*  775 */       this.f_19804_.m_135381_(DATA_FESTIVAL_GROUNDED_POSE, Boolean.valueOf(true));
/*      */     }
/*      */     
/*  778 */     m_6034_(finalPos.f_82479_, finalPos.f_82480_, finalPos.f_82481_);
/*  779 */     this.f_19854_ = finalPos.f_82479_;
/*  780 */     this.f_19855_ = finalPos.f_82480_;
/*  781 */     this.f_19856_ = finalPos.f_82481_;
/*      */     
/*  783 */     m_20256_(Vec3.f_82478_);
/*  784 */     this.f_19812_ = false;
/*      */     
/*  786 */     this.f_36703_ = true;
/*  787 */     this.f_36704_ = 0;
/*  788 */     this.f_36706_ = 0;
/*  789 */     setStuckFace(Direction.UP);
/*      */     
/*  791 */     m_36790_(noPhysicGravity);
/*  792 */     m_20242_(noPhysicGravity);
/*      */     
/*  794 */     m_146915_(glowing);
/*  795 */     applyFestivalVerticalPose();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void rollFestivalPose() {
/*  808 */     this.festivalPoseXRot = 90.0F + (this.f_19796_.m_188501_() - 0.5F) * 12.0F;
/*  809 */     this.festivalPoseYRot = this.f_19796_.m_188501_() * 360.0F;
/*  810 */     this.festivalPoseYOffset = 0.05D + this.f_19796_.m_188500_() * 0.14D;
/*      */     
/*  812 */     this.f_19804_.m_135381_(DATA_FESTIVAL_POSE_XROT, Float.valueOf(this.festivalPoseXRot));
/*  813 */     this.f_19804_.m_135381_(DATA_FESTIVAL_POSE_YROT, Float.valueOf(this.festivalPoseYRot));
/*      */   }
/*      */   
/*      */   private void applyFestivalVerticalPose() {
/*  817 */     if ((m_9236_()).f_46443_) {
/*  818 */       syncFestivalPoseFromData();
/*      */     }
/*      */     
/*  821 */     m_146926_(this.festivalPoseXRot);
/*  822 */     this.f_19860_ = this.festivalPoseXRot;
/*      */     
/*  824 */     m_146922_(this.festivalPoseYRot);
/*  825 */     this.f_19859_ = this.festivalPoseYRot;
/*      */   }
/*      */   
/*      */   public void finishSummonedGroundTridentFestival() {
/*  829 */     if (!this.summonedGroundTridentFestival) {
/*      */       return;
/*      */     }
/*      */     
/*  833 */     this.summonedGroundTridentFestival = false;
/*  834 */     clearFestivalGroundedPose();
/*  835 */     m_146915_(false);
/*      */     
/*  837 */     this.f_36703_ = false;
/*  838 */     this.f_36704_ = 0;
/*  839 */     this.f_36706_ = 0;
/*  840 */     setStuckFace((Direction)null);
/*      */     
/*  842 */     m_36790_(false);
/*  843 */     m_20242_(false);
/*  844 */     this.f_19812_ = true;
/*      */     
/*  846 */     m_6034_(m_20185_(), m_20186_() + 0.25D, m_20189_());
/*  847 */     this.f_19854_ = m_20185_();
/*  848 */     this.f_19855_ = m_20186_();
/*  849 */     this.f_19856_ = m_20189_();
/*      */     
/*  851 */     m_20334_(0.0D, -0.12D, 0.0D);
/*      */   }
/*      */   public void trimOldGroundedTridentsAroundOwnerOnSpawn() {
/*      */     ServerLevel serverLevel;
/*  855 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*      */     else
/*      */     { return; }
/*      */     
/*  859 */     LivingEntity owner = getOwnerLiving();
/*  860 */     if (owner == null) {
/*      */       return;
/*      */     }
/*      */     
/*  864 */     UUID ownerUuid = owner.m_20148_();
/*      */     
/*  866 */     List<BlueDemonThrownTridentEntity> grounded = serverLevel.m_6443_(BlueDemonThrownTridentEntity.class, 
/*      */         
/*  868 */         makeOwnerGroundBox((Entity)owner), trident -> 
/*  869 */         (trident != this && trident.m_6084_() && trident.isGroundedForLimit() && trident.hasSameOwner(ownerUuid)));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  875 */     int removeCount = grounded.size() - 20 + 1;
/*  876 */     if (removeCount <= 0) {
/*      */       return;
/*      */     }
/*      */     
/*  880 */     grounded.sort(
/*  881 */         Comparator.comparingLong(BlueDemonThrownTridentEntity::getSpawnSequence)
/*  882 */         .thenComparing(Entity::m_20148_));
/*      */ 
/*      */     
/*  885 */     for (int i = 0; i < removeCount; i++) {
/*  886 */       ((BlueDemonThrownTridentEntity)grounded.get(i)).m_146870_();
/*      */     }
/*      */   }
/*      */   
/*      */   private void discardIfGroundedAndFarFromOwner() {
/*  891 */     if (!this.f_36703_) {
/*      */       return;
/*      */     }
/*      */     
/*  895 */     LivingEntity owner = getOwnerLiving();
/*  896 */     if (owner != null && isOutsideOwnerGroundBox((Entity)owner)) {
/*  897 */       m_146870_();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected void m_8060_(@NotNull BlockHitResult result) {
/*  903 */     if ((m_9236_()).f_46443_) {
/*  904 */       super.m_8060_(result);
/*      */       
/*      */       return;
/*      */     } 
/*  908 */     if (this.summonedGroundTridentFestival) {
/*  909 */       releaseFestivalGroundedPose(true);
/*  910 */       discardIfGroundedAndFarFromOwner();
/*      */       
/*      */       return;
/*      */     } 
/*  914 */     super.m_8060_(result);
/*      */     
/*  916 */     setStuckFace(result.m_82434_());
/*      */     
/*  918 */     if (result.m_82434_() == Direction.UP) {
/*  919 */       float[] pitchChoices = { -90.0F, -60.0F, -45.0F, -30.0F };
/*  920 */       float[] yawChoices = { -90.0F, -60.0F, -45.0F, -30.0F, 0.0F, 30.0F, 45.0F, 60.0F, 90.0F };
/*      */       
/*  922 */       float pitch = pitchChoices[this.f_19796_.m_188503_(pitchChoices.length)];
/*  923 */       float yawOffset = yawChoices[this.f_19796_.m_188503_(yawChoices.length)];
/*      */       
/*  925 */       m_146926_(pitch);
/*  926 */       this.f_19860_ = m_146909_();
/*      */       
/*  928 */       m_146922_(m_146908_() + yawOffset);
/*  929 */       this.f_19859_ = m_146908_();
/*      */     } 
/*      */     
/*  932 */     if (!this.specialImpactTriggered) {
/*  933 */       this.specialImpactTriggered = true;
/*  934 */       handleModeImpact(result.m_82425_(), (Entity)null);
/*      */     } 
/*      */     
/*  937 */     discardIfGroundedAndFarFromOwner();
/*      */   }
/*      */   
/*      */   public boolean isGroundedTrident() {
/*  941 */     return this.f_36703_;
/*      */   }
/*      */   
/*      */   public boolean belongsToOwner(@NotNull LivingEntity owner) {
/*  945 */     Entity projectileOwner = m_19749_();
/*  946 */     return (projectileOwner != null && projectileOwner.m_20148_().equals(owner.m_20148_()));
/*      */   }
/*      */   
/*      */   public void relaunchTowards(@NotNull Vec3 direction, float speed, float inaccuracy) {
/*  950 */     if (direction.m_82556_() < 1.0E-7D) {
/*      */       return;
/*      */     }
/*      */     
/*  954 */     this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */     
/*  956 */     Vec3 normalized = direction.m_82541_();
/*      */     
/*  958 */     setStuckFace((Direction)null);
/*  959 */     this.f_36703_ = false;
/*  960 */     this.f_36704_ = 0;
/*  961 */     this.f_36706_ = 0;
/*  962 */     this.f_37556_ = false;
/*  963 */     this.specialImpactTriggered = false;
/*      */     
/*  965 */     m_36790_(false);
/*  966 */     m_20242_(false);
/*  967 */     this.f_19812_ = true;
/*      */     
/*  969 */     m_146915_(true);
/*      */     
/*  971 */     m_20256_(Vec3.f_82478_);
/*      */     
/*  973 */     m_146922_((float)(Mth.m_14136_(normalized.f_82479_, normalized.f_82481_) * 57.29577951308232D));
/*  974 */     m_146926_((float)(Mth.m_14136_(normalized.f_82480_, Math.sqrt(normalized.f_82479_ * normalized.f_82479_ + normalized.f_82481_ * normalized.f_82481_)) * 57.29577951308232D));
/*  975 */     this.f_19859_ = m_146908_();
/*  976 */     this.f_19860_ = m_146909_();
/*      */     
/*  978 */     m_6686_(normalized.f_82479_, normalized.f_82480_, normalized.f_82481_, speed, inaccuracy);
/*  979 */     m_5496_(SoundEvents.f_12520_, 1.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public void summonSuperLightningAtSelf() {
/*  983 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  984 */       spawnSuperTridentLightning(serverLevel, BlockPos.m_274446_((Position)m_20182_()), (Entity)null); }
/*      */   
/*      */   }
/*      */   
/*      */   public void summonLightningAtSelf() {
/*  989 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  990 */       spawnTridentLightning(serverLevel, BlockPos.m_274446_((Position)m_20182_()), (Entity)null); }
/*      */   
/*      */   }
/*      */   
/*      */   public void beginAnimatedRelaunch(@Nullable LivingEntity target, @Nullable Vec3 fallbackDirection, float speed, float inaccuracy, int launchDelayTicks) {
/*  995 */     if (this.relaunchAnimationActive || this.relaunchDelayActive) {
/*      */       return;
/*      */     }
/*  998 */     int offsetX = this.f_19796_.m_188503_(3) - 1;
/*  999 */     int offsetZ = this.f_19796_.m_188503_(3) - 1;
/*      */     
/* 1001 */     if (offsetX == 0 && offsetZ == 0) {
/* 1002 */       if (this.f_19796_.m_188499_()) {
/* 1003 */         offsetX = this.f_19796_.m_188499_() ? 1 : -1;
/*      */       } else {
/* 1005 */         offsetZ = this.f_19796_.m_188499_() ? 1 : -1;
/*      */       } 
/*      */     }
/*      */     
/* 1009 */     double riseY = 1.0D + this.f_19796_.m_188500_() * 2.0D;
/*      */     
/* 1011 */     this.relaunchAnimationStart = m_20182_();
/* 1012 */     this.relaunchAnimationEnd = this.relaunchAnimationStart.m_82520_(offsetX, riseY, offsetZ);
/*      */     
/* 1014 */     this.queuedTargetUUID = (target != null) ? target.m_20148_() : null;
/* 1015 */     this
/*      */       
/* 1017 */       .queuedFallbackDirection = (fallbackDirection != null && fallbackDirection.m_82556_() > 1.0E-7D) ? fallbackDirection.m_82541_() : null;
/*      */     
/* 1019 */     this.queuedLaunchSpeed = speed;
/*      */     
/* 1021 */     this.relaunchAnimationTick = 0;
/* 1022 */     this.relaunchAnimationActive = true;
/*      */     
/* 1024 */     this.relaunchDelayActive = false;
/* 1025 */     this.relaunchDelayTicks = Math.max(0, launchDelayTicks);
/* 1026 */     this.relaunchDelayTick = 0;
/*      */     
/* 1028 */     this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */     
/* 1030 */     setStuckFace((Direction)null);
/* 1031 */     this.f_36703_ = false;
/* 1032 */     this.f_36704_ = 0;
/* 1033 */     this.f_36706_ = 0;
/* 1034 */     this.f_37556_ = false;
/* 1035 */     this.specialImpactTriggered = false;
/*      */     
/* 1037 */     m_36790_(true);
/* 1038 */     m_20242_(true);
/* 1039 */     m_20256_(Vec3.f_82478_);
/* 1040 */     this.f_19812_ = false;
/* 1041 */     m_146915_(true);
/*      */   }
/*      */   
/*      */   private void tickRelaunchDelay() {
/* 1045 */     this.relaunchDelayTick++;
/*      */     
/* 1047 */     m_20256_(Vec3.f_82478_);
/*      */     
/* 1049 */     Vec3 direction = resolveQueuedLaunchDirection();
/* 1050 */     if (direction != null) {
/* 1051 */       updateRotationFromMovement(direction);
/*      */     }
/*      */     
/* 1054 */     if (this.relaunchDelayTick >= this.relaunchDelayTicks) {
/* 1055 */       this.relaunchDelayActive = false;
/* 1056 */       launchQueuedRelaunch();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void launchQueuedRelaunch() {
/* 1061 */     float speed = this.queuedLaunchSpeed;
/* 1062 */     Vec3 direction = resolveQueuedLaunchDirection();
/*      */     
/* 1064 */     this.queuedTargetUUID = null;
/* 1065 */     this.queuedFallbackDirection = null;
/*      */     
/* 1067 */     m_36790_(false);
/* 1068 */     m_20242_(false);
/* 1069 */     this.f_19812_ = true;
/* 1070 */     this.specialImpactTriggered = false;
/* 1071 */     this.f_36703_ = false;
/* 1072 */     this.f_36704_ = 0;
/* 1073 */     this.f_36706_ = 0;
/* 1074 */     this.f_37556_ = false;
/* 1075 */     this.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*      */     
/* 1077 */     if (direction != null && direction.m_82556_() > 1.0E-7D)
/* 1078 */       relaunchTowards(direction, speed, 0.0F); 
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   private LivingEntity getQueuedTargetLiving() {
/*      */     ServerLevel serverLevel;
/* 1084 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; if (this.queuedTargetUUID == null)
/* 1085 */         return null;  } else { return null; }
/*      */ 
/*      */     
/* 1088 */     Entity entity = serverLevel.m_8791_(this.queuedTargetUUID);
/* 1089 */     if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (living.m_6084_()); }  return null;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   private Vec3 resolveQueuedLaunchDirection() {
/* 1094 */     LivingEntity target = getQueuedTargetLiving();
/* 1095 */     if (target != null) {
/* 1096 */       Vec3 computed = computeLaunchDirectionTo(target, this.queuedLaunchSpeed);
/* 1097 */       if (computed != null) {
/* 1098 */         return computed;
/*      */       }
/*      */     } 
/*      */     
/* 1102 */     if (this.queuedFallbackDirection != null && this.queuedFallbackDirection.m_82556_() > 1.0E-7D) {
/* 1103 */       return this.queuedFallbackDirection.m_82541_();
/*      */     }
/*      */     
/* 1106 */     LivingEntity owner = getOwnerLiving();
/* 1107 */     return (owner != null) ? BlueDemonTridentItem.getTridentThrowDirection(owner, m_20182_()) : null;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   private Vec3 computeLaunchDirectionTo(@NotNull LivingEntity target, float speed) {
/* 1112 */     Vec3 start = m_20182_();
/* 1113 */     Vec3 targetPos = target.m_20182_().m_82520_(0.0D, target.m_20206_() * 0.72D, 0.0D);
/*      */     
/* 1115 */     double dx = targetPos.f_82479_ - start.f_82479_;
/* 1116 */     double dz = targetPos.f_82481_ - start.f_82481_;
/* 1117 */     double horizontal = Math.sqrt(dx * dx + dz * dz);
/* 1118 */     double dy = targetPos.f_82480_ - start.f_82480_ + horizontal * 0.065D;
/*      */     
/* 1120 */     Vec3 direction = new Vec3(dx, dy, dz);
/* 1121 */     return (direction.m_82556_() > 1.0E-7D) ? direction.m_82541_() : null;
/*      */   }
/*      */   
/*      */   private void tickAnimatedRelaunch() {
/* 1125 */     this.relaunchAnimationTick++;
/*      */     
/* 1127 */     float t = Math.min(1.0F, this.relaunchAnimationTick / 20.0F);
/* 1128 */     float eased = t * t * (3.0F - 2.0F * t);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1133 */     Vec3 nextPos = new Vec3(Mth.m_14139_(eased, this.relaunchAnimationStart.f_82479_, this.relaunchAnimationEnd.f_82479_), Mth.m_14139_(eased, this.relaunchAnimationStart.f_82480_, this.relaunchAnimationEnd.f_82480_), Mth.m_14139_(eased, this.relaunchAnimationStart.f_82481_, this.relaunchAnimationEnd.f_82481_));
/*      */ 
/*      */     
/* 1136 */     Vec3 moveDelta = nextPos.m_82546_(m_20182_());
/*      */     
/* 1138 */     m_6034_(nextPos.f_82479_, nextPos.f_82480_, nextPos.f_82481_);
/* 1139 */     m_20256_(Vec3.f_82478_);
/* 1140 */     updateRotationFromMovement(moveDelta);
/*      */     
/* 1142 */     if (this.relaunchAnimationTick >= 20) {
/* 1143 */       this.relaunchAnimationActive = false;
/* 1144 */       this.relaunchAnimationTick = 0;
/*      */       
/* 1146 */       if (this.relaunchDelayTicks > 0) {
/* 1147 */         this.relaunchDelayActive = true;
/* 1148 */         this.relaunchDelayTick = 0;
/*      */       } else {
/* 1150 */         launchQueuedRelaunch();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void updateRotationFromMovement(Vec3 delta) {
/* 1156 */     if (delta.m_82556_() < 1.0E-7D) {
/*      */       return;
/*      */     }
/*      */     
/* 1160 */     double horizontal = Math.sqrt(delta.f_82479_ * delta.f_82479_ + delta.f_82481_ * delta.f_82481_);
/*      */     
/* 1162 */     m_146922_((float)(Mth.m_14136_(delta.f_82479_, delta.f_82481_) * 57.29577951308232D));
/* 1163 */     m_146926_((float)(Mth.m_14136_(delta.f_82480_, horizontal) * 57.29577951308232D));
/* 1164 */     this.f_19859_ = m_146908_();
/* 1165 */     this.f_19860_ = m_146909_();
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean m_5603_(@NotNull Entity target) {
/* 1170 */     if (target == this) {
/* 1171 */       return false;
/*      */     }
/*      */     
/* 1174 */     if (target instanceof BlueDemonThrownTridentEntity) {
/* 1175 */       return false;
/*      */     }
/*      */     
/* 1178 */     if (target instanceof TridentLightningBolt) {
/* 1179 */       return false;
/*      */     }
/*      */     
/* 1182 */     if (target == m_19749_()) {
/* 1183 */       return false;
/*      */     }
/*      */     
/* 1186 */     return super.m_5603_(target);
/*      */   }
/*      */   
/*      */   private void tickElectricEffects() {
/* 1190 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (this.f_19797_ % 5 == 0 && 
/* 1191 */         Math.random() <= 0.1D) {
/* 1192 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/* 1193 */             .get(), 
/* 1194 */             m_20185_(), m_20186_(), m_20189_(), 1, 0.3D, 1.2D, 0.3D, 0.0D);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1200 */         if (serverLevel.f_46441_.m_188500_() <= 0.8D) {
/* 1201 */           float volume = (float)Mth.m_216263_(serverLevel.f_46441_, 0.05D, 0.5D);
/* 1202 */           float pitch = (float)Mth.m_216263_(serverLevel.f_46441_, 0.8D, 1.1D);
/*      */           
/* 1204 */           serverLevel.m_5594_(null, 
/*      */               
/* 1206 */               BlockPos.m_274561_(m_20185_(), m_20186_(), m_20189_()), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY
/* 1207 */               .get(), SoundSource.NEUTRAL, volume, pitch);
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void m_7380_(@NotNull CompoundTag tag) {
/* 1219 */     super.m_7380_(tag);
/* 1220 */     tag.m_128359_("BlueDemonMode", this.mode.name());
/* 1221 */     tag.m_128379_("SpecialImpactTriggered", this.specialImpactTriggered);
/* 1222 */     tag.m_128356_("BlueDemonSpawnSequence", this.spawnSequence);
/* 1223 */     tag.m_128379_("SummonedGroundTridentFestival", this.summonedGroundTridentFestival);
/*      */     
/* 1225 */     Direction face = getStuckFace();
/* 1226 */     if (face != null) {
/* 1227 */       tag.m_128344_("StuckFace", (byte)face.m_122411_());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7378_(@NotNull CompoundTag tag) {
/* 1233 */     super.m_7378_(tag);
/*      */     
/* 1235 */     if (tag.m_128441_("BlueDemonMode")) {
/*      */       try {
/* 1237 */         this.mode = TridentMode.valueOf(tag.m_128461_("BlueDemonMode"));
/* 1238 */       } catch (IllegalArgumentException ignored) {
/* 1239 */         this.mode = TridentMode.DEFAULT;
/*      */       } 
/*      */     } else {
/* 1242 */       this.mode = TridentMode.DEFAULT;
/*      */     } 
/*      */     
/* 1245 */     this.specialImpactTriggered = tag.m_128471_("SpecialImpactTriggered");
/* 1246 */     this.spawnSequence = tag.m_128454_("BlueDemonSpawnSequence");
/* 1247 */     this.summonedGroundTridentFestival = tag.m_128471_("SummonedGroundTridentFestival");
/*      */     
/* 1249 */     if (tag.m_128441_("StuckFace")) {
/* 1250 */       setStuckFace(Direction.m_122376_(tag.m_128445_("StuckFace")));
/*      */     } else {
/* 1252 */       setStuckFace((Direction)null);
/*      */     } 
/*      */     
/* 1255 */     this.relaunchAnimationActive = false;
/* 1256 */     this.relaunchAnimationTick = 0;
/* 1257 */     this.relaunchAnimationStart = Vec3.f_82478_;
/* 1258 */     this.relaunchAnimationEnd = Vec3.f_82478_;
/*      */     
/* 1260 */     this.relaunchDelayActive = false;
/* 1261 */     this.relaunchDelayTicks = 0;
/* 1262 */     this.relaunchDelayTick = 0;
/*      */     
/* 1264 */     this.queuedTargetUUID = null;
/* 1265 */     this.queuedFallbackDirection = null;
/* 1266 */     this.queuedLaunchSpeed = 0.0F;
/*      */     
/* 1268 */     this.absorbToWearerActive = false;
/* 1269 */     this.absorbWearerUUID = null;
/* 1270 */     this.absorbStartGroundPos = Vec3.f_82478_;
/* 1271 */     this.absorbReturnFace = null;
/*      */     
/* 1273 */     m_36790_(false);
/* 1274 */     m_20242_(false);
/* 1275 */     this.f_19812_ = false;
/* 1276 */     m_146915_(false);
/* 1277 */     this.festivalGroundRiseActive = false;
/* 1278 */     this.festivalGroundRiseTick = 0;
/* 1279 */     this.festivalGroundRiseStart = Vec3.f_82478_;
/* 1280 */     this.festivalGroundRiseEnd = Vec3.f_82478_;
/*      */   }
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\BlueDemonThrownTridentEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */