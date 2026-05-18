/*      */ package com.pla.annoyingvillagers.entity;
/*      */ 
/*      */ import com.pla.annoyingvillagers.client.animation.DragonAnimator;
/*      */ import com.pla.annoyingvillagers.client.engine.MountCameraManager;
/*      */ import com.pla.annoyingvillagers.client.engine.MountControlsMessenger;
/*      */ import com.pla.annoyingvillagers.entity.goal.DragonOrbitLeaderGoal;
/*      */ import com.pla.annoyingvillagers.entity.goal.RecallLandGoal;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModKeyMappings;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*      */ import java.util.List;
/*      */ import java.util.UUID;
/*      */ import javax.annotation.Nullable;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.nbt.CompoundTag;
/*      */ import net.minecraft.network.protocol.Packet;
/*      */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*      */ import net.minecraft.network.syncher.EntityDataAccessor;
/*      */ import net.minecraft.network.syncher.EntityDataSerializers;
/*      */ import net.minecraft.network.syncher.SynchedEntityData;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.sounds.SoundEvent;
/*      */ import net.minecraft.sounds.SoundEvents;
/*      */ import net.minecraft.sounds.SoundSource;
/*      */ import net.minecraft.util.Mth;
/*      */ import net.minecraft.world.DifficultyInstance;
/*      */ import net.minecraft.world.damagesource.DamageSource;
/*      */ import net.minecraft.world.entity.AgeableMob;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.entity.EntityDimensions;
/*      */ import net.minecraft.world.entity.EntityType;
/*      */ import net.minecraft.world.entity.LivingEntity;
/*      */ import net.minecraft.world.entity.Mob;
/*      */ import net.minecraft.world.entity.MobSpawnType;
/*      */ import net.minecraft.world.entity.MoverType;
/*      */ import net.minecraft.world.entity.PathfinderMob;
/*      */ import net.minecraft.world.entity.PlayerRideable;
/*      */ import net.minecraft.world.entity.Pose;
/*      */ import net.minecraft.world.entity.SpawnGroupData;
/*      */ import net.minecraft.world.entity.TamableAnimal;
/*      */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*      */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*      */ import net.minecraft.world.entity.ai.control.BodyRotationControl;
/*      */ import net.minecraft.world.entity.ai.control.MoveControl;
/*      */ import net.minecraft.world.entity.ai.goal.FloatGoal;
/*      */ import net.minecraft.world.entity.ai.goal.Goal;
/*      */ import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
/*      */ import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
/*      */ import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
/*      */ import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
/*      */ import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
/*      */ import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
/*      */ import net.minecraft.world.entity.ai.navigation.PathNavigation;
/*      */ import net.minecraft.world.entity.ai.targeting.TargetingConditions;
/*      */ import net.minecraft.world.entity.animal.Animal;
/*      */ import net.minecraft.world.entity.animal.FlyingAnimal;
/*      */ import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
/*      */ import net.minecraft.world.entity.player.Player;
/*      */ import net.minecraft.world.item.Item;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.level.BlockGetter;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.level.LevelReader;
/*      */ import net.minecraft.world.level.ServerLevelAccessor;
/*      */ import net.minecraft.world.level.block.Blocks;
/*      */ import net.minecraft.world.level.block.SoundType;
/*      */ import net.minecraft.world.level.block.state.BlockState;
/*      */ import net.minecraft.world.phys.AABB;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import net.minecraft.world.phys.shapes.BooleanOp;
/*      */ import net.minecraft.world.phys.shapes.Shapes;
/*      */ import net.minecraftforge.network.NetworkHooks;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*      */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*      */ import yesman.epicfight.world.capabilities.item.WeaponCapability;
/*      */ import yesman.epicfight.world.capabilities.item.WeaponCategory;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class HerobrineDragonEntity
/*      */   extends TamableAnimal
/*      */   implements FlyingAnimal, PlayerRideable
/*      */ {
/*      */   public static final double BASE_SPEED_GROUND = 0.3D;
/*      */   public static final double BASE_SPEED_FLYING = 0.32D;
/*      */   public static final double BASE_DAMAGE = 8.0D;
/*      */   public static final double BASE_HEALTH = 150.0D;
/*      */   public static final double BASE_FOLLOW_RANGE = 16.0D;
/*      */   public static final int BASE_KB_RESISTANCE = 1;
/*      */   public static final float BASE_WIDTH = 2.75F;
/*      */   public static final float BASE_HEIGHT = 2.75F;
/*      */   public static final int GROUND_CLEARENCE_THRESHOLD = 3;
/*      */   private final DragonAnimator animator;
/*      */   private boolean flying;
/*      */   private boolean nearGround;
/*      */   private UUID summonerUUID;
/*      */   private LivingEntity summoner;
/*      */   private final GroundPathNavigation groundNavigation;
/*      */   private final FlyingPathNavigation flyingNavigation;
/*      */   private LivingEntity breathHoverTarget;
/*      */   private Vec3 breathHoverPos;
/*      */   private int breathHoverTimeToLiveTicks;
/*      */   private boolean recallActive = false;
/*      */   private boolean recallAutoMount = false;
/*  119 */   private Vec3 recallLandPos = null; @Nullable
/*      */   public EndCrystal nearestCrystal;
/*      */   public boolean isRecallAutoMount() {
/*  122 */     return this.recallAutoMount;
/*      */   }
/*      */   
/*      */   public void setRecallLandPos(Vec3 recallLandPos) {
/*  126 */     this.recallLandPos = recallLandPos;
/*      */   }
/*      */   
/*      */   public Vec3 getRecallLandPos() {
/*  130 */     return this.recallLandPos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  136 */   private static final EntityDataAccessor<Boolean> DATA_CONTROL_LOCKED = SynchedEntityData.m_135353_(HerobrineDragonEntity.class, EntityDataSerializers.f_135035_);
/*      */   
/*      */   public boolean isRecallActive() {
/*  139 */     return this.recallActive;
/*      */   }
/*      */   
/*      */   public void setRecallActive(boolean recallActive) {
/*  143 */     this.recallActive = recallActive;
/*      */   }
/*      */ 
/*      */   
/*      */   public HerobrineDragonEntity(EntityType<? extends HerobrineDragonEntity> type, Level level) {
/*  148 */     super(type, level);
/*      */     
/*  150 */     this.f_19811_ = true;
/*      */     
/*  152 */     this.f_21342_ = new DragonMoveController(this);
/*  153 */     this.animator = level.f_46443_ ? new DragonAnimator(this) : null;
/*      */     
/*  155 */     this.flyingNavigation = new FlyingPathNavigation((Mob)this, level);
/*  156 */     this.groundNavigation = new GroundPathNavigation((Mob)this, level);
/*      */     
/*  158 */     this.flyingNavigation.m_7008_(true);
/*  159 */     this.groundNavigation.m_7008_(true);
/*      */     
/*  161 */     this.f_21344_ = (PathNavigation)this.groundNavigation;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public BodyRotationControl m_7560_() {
/*  168 */     return new DragonBodyController(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_8099_() {
/*  174 */     this.f_21345_.m_25352_(1, (Goal)new FloatGoal((Mob)this));
/*  175 */     this.f_21345_.m_25352_(1, (Goal)new RecallLandGoal(this));
/*  176 */     this.f_21345_.m_25352_(2, (Goal)new SitWhenOrderedToGoal(this));
/*  177 */     this.f_21345_.m_25352_(3, (Goal)new DragonOrbitLeaderGoal(this, 1.15D, 20.0F, 50.0F, 180.0F));
/*  178 */     this.f_21345_.m_25352_(4, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 0.8500000238418579D));
/*  179 */     this.f_21345_.m_25352_(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 16.0F));
/*  180 */     this.f_21345_.m_25352_(6, (Goal)new RandomLookAroundGoal((Mob)this));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_8097_() {
/*  186 */     super.m_8097_();
/*  187 */     this.f_19804_.m_135372_(DATA_CONTROL_LOCKED, Boolean.valueOf(false));
/*      */   }
/*      */   
/*      */   private boolean isControlLocked() {
/*  191 */     return ((Boolean)this.f_19804_.m_135370_(DATA_CONTROL_LOCKED)).booleanValue();
/*      */   }
/*      */   
/*      */   private void setControlLocked(boolean locked) {
/*  195 */     this.f_19804_.m_135381_(DATA_CONTROL_LOCKED, Boolean.valueOf(locked));
/*      */   }
/*      */   
/*      */   private boolean shouldApplyControlLocked() {
/*  199 */     return this.summoner instanceof Player;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void m_7350_(@NotNull EntityDataAccessor<?> data) {
/*  205 */     if (f_21798_.equals(data)) { m_6210_(); }
/*  206 */     else { super.m_7350_(data); }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7380_(@NotNull CompoundTag compound) {
/*  212 */     super.m_7380_(compound);
/*  213 */     if (this.summonerUUID != null) {
/*  214 */       compound.m_128362_("SummonerUUID", this.summonerUUID);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void m_7378_(@NotNull CompoundTag compound) {
/*  221 */     super.m_7378_(compound);
/*  222 */     m_146762_(0);
/*  223 */     if (compound.m_128403_("SummonerUUID")) {
/*  224 */       this.summonerUUID = compound.m_128342_("SummonerUUID");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_6072_() {
/*  230 */     return false;
/*      */   }
/*      */   
/*      */   public void setSummonerUUID(UUID summonerUUID) {
/*  234 */     this.summonerUUID = summonerUUID;
/*      */   }
/*      */   
/*      */   public UUID getSummonerUUID() {
/*  238 */     return this.summonerUUID;
/*      */   }
/*      */   
/*      */   public void setSummoner(LivingEntity summoner) {
/*  242 */     this.summoner = summoner;
/*      */   }
/*      */   
/*      */   public LivingEntity getSummoner() {
/*  246 */     return this.summoner;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canFly() {
/*  251 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean shouldFly() {
/*  256 */     if (m_29443_()) return !m_20096_(); 
/*  257 */     return (canFly() && !m_20069_() && !isNearGround());
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_29443_() {
/*  262 */     return this.flying;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setFlying(boolean flying) {
/*  267 */     this.flying = flying;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isNearGround() {
/*  272 */     return this.nearGround;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setNavigation(boolean flying) {
/*  277 */     this
/*      */       
/*  279 */       .f_21344_ = flying ? (PathNavigation)this.flyingNavigation : (PathNavigation)this.groundNavigation;
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor pLevel, @NotNull DifficultyInstance pDifficulty, @NotNull MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
/*  284 */     m_146762_(0);
/*      */     
/*  286 */     return super.m_6518_(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
/*      */   }
/*      */   
/*      */   public static LivingEntity getNearestLivingEntity(Level level, Entity sourceEntity, double range) {
/*  290 */     AABB searchBox = sourceEntity.m_20191_().m_82400_(range);
/*      */     
/*  292 */     return level.m_45982_(level
/*  293 */         .m_6443_(LivingEntity.class, searchBox, e -> 
/*  294 */           (e != sourceEntity && !(e instanceof HerobrineDragonEntity) && !(e instanceof reascer.wom.world.entity.mob.EnderHand) && !e.m_7307_(sourceEntity) && e.m_6084_())), TargetingConditions.f_26872_, (LivingEntity)sourceEntity, sourceEntity
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  301 */         .m_20185_(), sourceEntity.m_20186_(), sourceEntity.m_20189_());
/*      */   }
/*      */ 
/*      */   
/*      */   private void aimBodyAndHeadAt(LivingEntity target) {
/*  306 */     Vec3 from = m_20299_(1.0F);
/*  307 */     Vec3 to = target.m_20299_(1.0F);
/*      */     
/*  309 */     double dx = to.f_82479_ - from.f_82479_;
/*  310 */     double dz = to.f_82481_ - from.f_82481_;
/*  311 */     double dy = to.f_82480_ - from.f_82480_;
/*  312 */     double distXZ = Math.sqrt(dx * dx + dz * dz);
/*      */     
/*  314 */     float wantYaw = (float)(Mth.m_14136_(dz, dx) * 57.29577951308232D) - 90.0F;
/*  315 */     float wantPitch = (float)-(Mth.m_14136_(dy, distXZ) * 57.29577951308232D);
/*      */     
/*  317 */     float yaw = Mth.m_14148_(m_146908_(), wantYaw, 10.0F);
/*  318 */     float pitch = Mth.m_14148_(m_146909_(), wantPitch, 6.0F);
/*      */     
/*  320 */     m_146922_(yaw);
/*  321 */     m_146926_(pitch);
/*      */     
/*  323 */     m_5616_(yaw);
/*  324 */     m_5618_(yaw);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Vec3 beamMouthPos(float partial) {
/*  331 */     Vec3 eye = new Vec3(Mth.m_14139_(partial, this.f_19790_, m_20185_()), Mth.m_14139_(partial, this.f_19791_, m_20186_()) + m_20192_(), Mth.m_14139_(partial, this.f_19792_, m_20189_()));
/*      */ 
/*      */     
/*  334 */     float headYaw = Mth.m_14189_(partial, this.f_20886_, this.f_20885_);
/*  335 */     float headPitch = Mth.m_14179_(partial, this.f_19860_, m_146909_());
/*  336 */     Vec3 look = Vec3.m_82498_(headPitch, headYaw);
/*      */     
/*  338 */     double baseForward = Math.max(1.0D, m_20205_() * 0.7D);
/*      */     
/*  340 */     boolean hasPlayerRider = m_146895_() instanceof Player;
/*  341 */     double extraUp = (hasPlayerRider ? 1.0D : 4.0D) * m_6134_();
/*  342 */     double extraForward = 5.2D * m_6134_();
/*      */     
/*  344 */     double forward = baseForward + extraForward;
/*      */     
/*  346 */     return eye.m_82549_(look.m_82490_(forward))
/*  347 */       .m_82520_(0.0D, extraUp, 0.0D);
/*      */   }
/*      */   public void shootThunderBreathAtTarget(LivingEntity target) {
/*      */     ServerLevel serverLevel;
/*  351 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; } else { return; }
/*  352 */      if (target == null || !target.m_6084_())
/*      */       return; 
/*  354 */     this.breathHoverTarget = target;
/*      */     
/*  356 */     Vec3 position = m_20182_();
/*  357 */     if (m_20096_()) position = position.m_82520_(0.0D, 10.0D, 0.0D); 
/*  358 */     this.breathHoverPos = position;
/*      */     
/*  360 */     this.breathHoverTimeToLiveTicks = 110;
/*      */     
/*  362 */     m_21573_().m_26573_();
/*      */     
/*  364 */     if (!m_29443_() && canFly()) liftOff(); 
/*  365 */     setFlying(true);
/*  366 */     setNavigation(true);
/*      */ 
/*      */     
/*  369 */     Vec3 mouth = m_146892_().m_82549_(m_20154_().m_82490_(Math.max(1.0D, m_20205_() * 0.6D)));
/*      */ 
/*      */     
/*  372 */     DragonBeamEntity beam = new DragonBeamEntity((EntityType<? extends DragonBeamEntity>)AnnoyingVillagersModEntities.DRAGON_BEAM.get(), (Level)serverLevel, this, target, mouth.f_82479_, mouth.f_82480_, mouth.f_82481_, 100, 2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  380 */     serverLevel.m_7967_(beam);
/*  381 */     m_5496_((SoundEvent)AnnoyingVillagersModSounds.DRAGON_THUNDER_SHOOT_SOUND.get(), 2.0F, 1.0F);
/*      */   }
/*      */   public void shootMeteoriteAtTarget(LivingEntity target) {
/*      */     ServerLevel serverLevel;
/*  385 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; } else { return; }
/*  386 */      if (target == null || !target.m_6084_())
/*      */       return; 
/*  388 */     this.breathHoverTarget = target;
/*      */     
/*  390 */     Vec3 position = m_20182_();
/*  391 */     if (m_20096_()) position = position.m_82520_(0.0D, 10.0D, 0.0D); 
/*  392 */     this.breathHoverPos = position;
/*      */     
/*  394 */     this.breathHoverTimeToLiveTicks = 20;
/*      */     
/*  396 */     m_21573_().m_26573_();
/*      */     
/*  398 */     if (!m_29443_() && canFly()) liftOff(); 
/*  399 */     setFlying(true);
/*  400 */     setNavigation(true);
/*      */     
/*  402 */     Vec3 look = m_20154_();
/*  403 */     double baseForward = Math.max(1.0D, m_20205_() * 0.6D);
/*  404 */     double extraForward = 7.5D * m_6134_();
/*  405 */     double heightOffset = -1.0D * m_6134_();
/*      */ 
/*      */     
/*  408 */     Vec3 spawnPos = m_146892_().m_82549_(look.m_82490_(baseForward + extraForward)).m_82520_(0.0D, heightOffset, 0.0D);
/*      */     
/*  410 */     DragonMeteoriteEntity dragonMeteoriteEntity = new DragonMeteoriteEntity((EntityType<DragonMeteoriteEntity>)AnnoyingVillagersModEntities.DRAGON_METEORITE.get(), (Level)serverLevel);
/*  411 */     dragonMeteoriteEntity.m_7678_(spawnPos.f_82479_, spawnPos.f_82480_, spawnPos.f_82481_, 0.0F, 0.0F);
/*  412 */     dragonMeteoriteEntity.setPosToAim(new Vec3(target.m_20185_(), target.m_20227_(0.5D), target.m_20189_()));
/*  413 */     dragonMeteoriteEntity.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*  414 */     dragonMeteoriteEntity.setOwner(this);
/*  415 */     serverLevel.m_7967_((Entity)dragonMeteoriteEntity);
/*      */     
/*  417 */     m_5496_(SoundEvents.f_11896_, 2.0F, 1.0F);
/*      */   }
/*      */   
/*      */   public void recallAndLand(boolean autoMount) {
/*  421 */     if (m_9236_().m_5776_())
/*  422 */       return;  if (this.summoner == null || !this.summoner.m_6084_())
/*      */       return; 
/*  424 */     this.recallActive = true;
/*  425 */     this.recallAutoMount = autoMount;
/*  426 */     this.recallLandPos = null;
/*      */     
/*  428 */     this.breathHoverTimeToLiveTicks = 0;
/*  429 */     this.breathHoverTarget = null;
/*  430 */     this.breathHoverPos = null;
/*      */   }
/*      */   
/*      */   private static boolean hasEnderSlayerScythe(Player p) {
/*  434 */     for (ItemStack s : (p.m_150109_()).f_35974_) {
/*  435 */       if (s.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderSlayerScytheItem) return true; 
/*      */     } 
/*  437 */     for (ItemStack s : (p.m_150109_()).f_35976_) {
/*  438 */       if (s.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderSlayerScytheItem) return true; 
/*      */     } 
/*  440 */     return false;
/*      */   }
/*      */   private static boolean isAllowedHeldCategory(Player p) {
/*      */     WeaponCapability weaponCap;
/*  444 */     ItemStack main = p.m_21205_();
/*      */     
/*  446 */     if (main.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderSlayerScytheItem) return true;
/*      */     
/*  448 */     CapabilityItem cap = EpicFightCapabilities.getItemStackCapability(main);
/*  449 */     if (cap instanceof WeaponCapability) { weaponCap = (WeaponCapability)cap; } else { return true; }
/*      */     
/*  451 */     WeaponCategory cat = weaponCap.getWeaponCategory();
/*  452 */     return (cat == CapabilityItem.WeaponCategories.RANGED || cat == CapabilityItem.WeaponCategories.NOT_WEAPON);
/*      */   }
/*      */ 
/*      */   
/*      */   private void checkCrystals() {
/*  457 */     if (m_146895_() != null && m_146895_() instanceof EndCrystal) {
/*      */       return;
/*      */     }
/*  460 */     if (this.nearestCrystal != null) {
/*  461 */       if (this.nearestCrystal.m_213877_()) {
/*  462 */         this.nearestCrystal = null;
/*  463 */       } else if (this.f_19797_ % 10 == 0 && m_21223_() < m_21233_()) {
/*  464 */         m_21153_(m_21223_() + 1.0F);
/*      */       } 
/*      */     }
/*      */     
/*  468 */     if (this.f_19796_.m_188503_(10) == 0) {
/*  469 */       List<EndCrystal> list = m_9236_().m_45976_(EndCrystal.class, m_20191_().m_82400_(32.0D));
/*  470 */       EndCrystal endcrystalTemp = null;
/*  471 */       double d0 = Double.MAX_VALUE;
/*      */       
/*  473 */       for (EndCrystal endCrystal : list) {
/*  474 */         double d1 = endCrystal.m_20280_((Entity)this);
/*  475 */         if (d1 < d0) {
/*  476 */           d0 = d1;
/*  477 */           endcrystalTemp = endCrystal;
/*      */         } 
/*      */       } 
/*      */       
/*  481 */       if (endcrystalTemp == null && this.nearestCrystal != null) {
/*  482 */         this.nearestCrystal.m_31052_(null);
/*      */       }
/*  484 */       this.nearestCrystal = endcrystalTemp;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void m_8119_() {
/*  491 */     super.m_8119_();
/*  492 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*      */       
/*  494 */       checkCrystals();
/*  495 */       if (this.nearestCrystal != null && !this.nearestCrystal.m_213877_()) {
/*  496 */         this.nearestCrystal.m_31052_(m_20183_());
/*      */       }
/*      */       
/*  499 */       if (this.breathHoverTimeToLiveTicks > 0) {
/*  500 */         if (shouldApplyControlLocked())
/*  501 */         { if (!isControlLocked()) setControlLocked(true);
/*      */            }
/*  503 */         else if (isControlLocked()) { setControlLocked(false); }
/*      */         
/*  505 */         this.breathHoverTimeToLiveTicks--;
/*      */         
/*  507 */         if (this.breathHoverPos == null) this.breathHoverPos = m_20182_();
/*      */         
/*  509 */         if (!m_29443_() && canFly()) liftOff(); 
/*  510 */         setFlying(true);
/*  511 */         setNavigation(true);
/*      */         
/*  513 */         m_21573_().m_26573_();
/*  514 */         m_20242_(true);
/*      */         
/*  516 */         if (this.breathHoverTarget != null) {
/*  517 */           aimBodyAndHeadAt(this.breathHoverTarget);
/*      */         }
/*      */         
/*  520 */         double y = this.breathHoverPos.f_82480_ + Math.sin(this.f_19797_ * 0.25D) * 0.25D;
/*  521 */         m_21566_().m_6849_(this.breathHoverPos.f_82479_, y, this.breathHoverPos.f_82481_, 0.12D);
/*      */         
/*  523 */         Vec3 dv = m_20184_();
/*  524 */         m_20334_(dv.f_82479_ * 0.2D, dv.f_82480_ * 0.6D, dv.f_82481_ * 0.2D);
/*      */         
/*  526 */         if (this.breathHoverTimeToLiveTicks <= 0) {
/*  527 */           m_20242_(false);
/*  528 */           this.breathHoverTarget = null;
/*  529 */           this.breathHoverPos = null;
/*      */         } 
/*      */       } else {
/*  532 */         if (m_20068_()) m_20242_(false); 
/*  533 */         if (isControlLocked()) {
/*  534 */           setControlLocked(false);
/*      */         }
/*      */       } 
/*      */       
/*  538 */       if (this.summoner == null && this.summonerUUID != null) {
/*  539 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.summonerUUID);
/*  540 */         if (!(entity instanceof Player) && entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity;
/*  541 */           this.summoner = livingEntity; }
/*      */         else
/*  543 */         { Player player = serverLevel.m_46003_(this.summonerUUID);
/*      */           
/*  545 */           if (player != null) {
/*  546 */             this.summoner = (LivingEntity)player;
/*      */           } }
/*      */       
/*      */       } 
/*      */       
/*  551 */       if (this.summoner != null && !this.summoner.m_6084_()) {
/*  552 */         this.summoner = null;
/*  553 */         this.summonerUUID = null;
/*  554 */         m_146870_();
/*      */       } 
/*      */       
/*  557 */       if (this.summoner != null && this.summoner.m_6084_()) { LivingEntity livingEntity = this.summoner; if (livingEntity instanceof Player) { Player player = (Player)livingEntity;
/*  558 */           if (this.summoner.getPersistentData().m_128441_("DragonUUID") && 
/*  559 */             !m_20148_().equals(this.summoner.getPersistentData().m_128342_("DragonUUID"))) {
/*  560 */             m_146870_(); return;
/*      */           } 
/*  562 */           if (!this.summoner.getPersistentData().m_128441_("DragonUUID")) {
/*  563 */             m_146870_();
/*      */             
/*      */             return;
/*      */           } 
/*  567 */           if (!hasEnderSlayerScythe(player) || !isAllowedHeldCategory(player)) {
/*  568 */             player.getPersistentData().m_128473_("DragonUUID");
/*  569 */             m_146870_();
/*      */             return;
/*      */           }  }
/*      */          }
/*      */       
/*  574 */       if (this.summoner != null && this.summoner.m_6084_() && !m_21523_() && !m_20159_() && !m_217005_()) {
/*  575 */         double distSqr = m_20280_((Entity)this.summoner);
/*  576 */         double farDist = 320.0D;
/*      */         
/*  578 */         if (distSqr > farDist * farDist) {
/*  579 */           if (!m_29443_() && canFly()) liftOff(); 
/*  580 */           m_21573_().m_26573_();
/*      */           
/*  582 */           double toY = Mth.m_14008_(this.summoner
/*  583 */               .m_20186_() + 18.0D, 
/*  584 */               m_9236_().m_141937_() + 6.0D, 
/*  585 */               m_9236_().m_151558_() - 6.0D);
/*      */ 
/*      */           
/*  588 */           m_21566_().m_6849_(this.summoner.m_20185_(), toY, this.summoner.m_20189_(), 1.8D);
/*      */         } 
/*      */       }  }
/*      */     else
/*      */     
/*  593 */     { this.animator.tick(); }
/*      */ 
/*      */     
/*  596 */     this.nearGround = (m_20096_() || !m_9236_().m_45756_((Entity)this, new AABB(m_20185_(), m_20186_(), m_20189_(), m_20185_(), m_20186_() - (3.0F * m_6134_()), m_20189_())));
/*  597 */     boolean flying = shouldFly();
/*  598 */     if (flying != m_29443_()) {
/*      */       
/*  600 */       setFlying(flying);
/*  601 */       if (!m_9236_().m_5776_()) setNavigation(flying);
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7023_(@NotNull Vec3 vec3) {
/*  608 */     if (m_29443_()) {
/*      */       
/*  610 */       if (m_6109_()) {
/*      */         
/*  612 */         m_19920_(m_6113_(), vec3);
/*  613 */         m_6478_(MoverType.SELF, m_20184_());
/*  614 */         if (m_20184_().m_82556_() < 0.1D)
/*  615 */           m_20256_(m_20184_().m_82520_(0.0D, Math.sin((this.f_19797_ / 4.0F)) * 0.03D, 0.0D)); 
/*  616 */         m_20256_(m_20184_().m_82490_(0.8999999761581421D));
/*      */       } 
/*      */       
/*  619 */       m_267651_(true);
/*      */     } else {
/*  621 */       super.m_7023_(vec3);
/*      */     } 
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   protected Vec3 m_274312_(@NotNull Player driver, @NotNull Vec3 move) {
/*  627 */     if (isControlLocked()) {
/*  628 */       return Vec3.f_82478_;
/*      */     }
/*  630 */     double moveSideways = move.f_82479_;
/*  631 */     double moveY = move.f_82480_;
/*  632 */     double moveForward = Math.min(Math.abs(driver.f_20902_) + Math.abs(driver.f_20900_), 1.0F);
/*      */     
/*  634 */     if (m_29443_() && hasLocalDriver()) {
/*      */       
/*  636 */       moveForward = (moveForward > 0.0D) ? moveForward : 0.0D;
/*  637 */       if (driver.f_20899_) { moveY = 1.0D; }
/*  638 */       else if (AnnoyingVillagersModKeyMappings.DRAGON_FLIGHT_DESCENT_KEY.m_90857_()) { moveY = -1.0D; }
/*  639 */       else if (moveForward > 0.0D) { moveY = (-driver.m_146909_() / 90.0F); }
/*      */     
/*      */     } 
/*  642 */     float speed = m_245547_(driver);
/*  643 */     return new Vec3(moveSideways * speed, moveY * speed, moveForward * speed);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_274498_(@NotNull Player driver, @NotNull Vec3 move) {
/*  649 */     if (isControlLocked()) {
/*      */       return;
/*      */     }
/*      */     
/*  653 */     float yaw = driver.f_20885_;
/*  654 */     if (move.f_82481_ > 0.0D)
/*  655 */       yaw += (float)Mth.m_14136_(driver.f_20902_, driver.f_20900_) * 57.295776F - 90.0F; 
/*  656 */     this.f_20885_ = yaw;
/*  657 */     m_146926_(driver.m_146909_() * 0.68F);
/*      */     
/*  659 */     m_146922_(Mth.m_14094_(this.f_20885_, m_146908_(), 4.0F));
/*      */     
/*  661 */     if (m_6109_())
/*      */     {
/*  663 */       if (!m_29443_() && canFly() && driver.f_20899_) liftOff();
/*      */     
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean m_6109_() {
/*  669 */     if (isControlLocked()) {
/*  670 */       return false;
/*      */     }
/*  672 */     return super.m_6109_();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected float m_245547_(@NotNull Player driver) {
/*  678 */     return (float)m_21133_(m_29443_() ? Attributes.f_22280_ : Attributes.f_22279_);
/*      */   }
/*      */ 
/*      */   
/*      */   public void liftOff() {
/*  683 */     if (!canFly() || m_20069_())
/*      */       return; 
/*  685 */     Vec3 dv = m_20184_();
/*  686 */     if (m_20096_() || dv.f_82480_ < 0.15D) {
/*  687 */       m_20334_(dv.f_82479_, 0.42D, dv.f_82481_);
/*      */     }
/*      */     
/*  690 */     setFlying(true);
/*  691 */     if (!m_9236_().m_5776_()) {
/*  692 */       setNavigation(true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected float m_6118_() {
/*  699 */     return super.m_6118_() * (canFly() ? 3 : true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_142535_(float pFallDistance, float pMultiplier, @NotNull DamageSource pSource) {
/*  705 */     return (!canFly() && super.m_142535_(pFallDistance, pMultiplier, pSource));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_6153_() {
/*  711 */     m_20153_();
/*      */     
/*  713 */     m_20256_(Vec3.f_82478_);
/*  714 */     m_146922_(this.f_19859_);
/*  715 */     m_5616_(this.f_20886_);
/*      */     
/*  717 */     if (this.f_20919_ >= getMaxDeathTime()) m_142687_(Entity.RemovalReason.KILLED);
/*      */     
/*  719 */     this.f_20919_++;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected SoundEvent m_7515_() {
/*  725 */     return SoundEvents.f_11890_;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   protected SoundEvent m_7975_(@NotNull DamageSource damageSourceIn) {
/*  732 */     return SoundEvents.f_11895_;
/*      */   }
/*      */ 
/*      */   
/*      */   public SoundEvent getStepSound() {
/*  737 */     return (SoundEvent)AnnoyingVillagersModSounds.DRAGON_STEP_SOUND.get();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected SoundEvent m_5592_() {
/*  746 */     return (SoundEvent)AnnoyingVillagersModSounds.DRAGON_DEATH_SOUND.get();
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public SoundEvent m_7866_(@NotNull ItemStack itemStackIn) {
/*  752 */     return SoundEvents.f_11912_;
/*      */   }
/*      */ 
/*      */   
/*      */   public SoundEvent getWingsSound() {
/*  757 */     return SoundEvents.f_11893_;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_7355_(@NotNull BlockPos entityPos, @NotNull BlockState state) {
/*  766 */     if (m_20069_())
/*      */       return; 
/*  768 */     SoundType soundType = state.m_60827_();
/*  769 */     if (m_9236_().m_8055_(entityPos.m_7494_()).m_60734_() == Blocks.f_50125_) {
/*  770 */       soundType = Blocks.f_50125_.getSoundType(state, (LevelReader)m_9236_(), entityPos, (Entity)this);
/*      */     }
/*  772 */     m_5496_(getStepSound(), soundType.m_56773_(), soundType.m_56774_() * m_6100_());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int m_8100_() {
/*  778 */     return 240;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected float m_6121_() {
/*  784 */     return m_6134_();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float m_6100_() {
/*  790 */     return 2.0F - m_6134_();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isTamedFor(Player player) {
/*  795 */     return (m_21824_() && m_21830_((LivingEntity)player));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float m_6431_(@NotNull Pose poseIn, EntityDimensions sizeIn) {
/*  804 */     return sizeIn.f_20378_ * 1.2F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double m_6048_() {
/*  813 */     return m_20206_() - 0.175D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_6785_(double distanceToClosestPlayer) {
/*  822 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_6147_() {
/*  831 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onWingsDown(float speed) {
/*  836 */     if (!m_20069_()) {
/*      */       
/*  838 */       float pitch = 1.0F - speed;
/*  839 */       float volume = 0.3F + (1.0F - speed) * 0.2F;
/*  840 */       float loudMul = 5.0F;
/*  841 */       pitch *= m_6100_();
/*  842 */       volume *= m_6121_();
/*  843 */       volume *= loudMul;
/*  844 */       m_9236_().m_7785_(m_20185_(), m_20186_(), m_20189_(), getWingsSound(), SoundSource.HOSTILE, volume, pitch, true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_6469_(@NotNull DamageSource src, float par2) {
/*  851 */     if (m_6673_(src)) return false; 
/*  852 */     if (src.m_7639_() == this.summoner) return false; 
/*  853 */     if (src.m_7639_() instanceof net.minecraft.world.entity.projectile.Projectile) return super.m_6469_(src, par2 * 0.1F); 
/*  854 */     return super.m_6469_(src, par2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_7848_(@NotNull Animal mate) {
/*  860 */     if (mate == this) return false; 
/*  861 */     if (!(mate instanceof HerobrineDragonEntity)) return false; 
/*  862 */     return (m_27593_() && mate.m_27593_());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AgeableMob m_142606_(@NotNull ServerLevel level, @NotNull AgeableMob mob) {
/*  870 */     return (AgeableMob)((EntityType)AnnoyingVillagersModEntities.HEROBRINE_DRAGON.get()).m_20615_((Level)level);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_7757_(@NotNull LivingEntity target, @NotNull LivingEntity owner) {
/*  876 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_6779_(@NotNull LivingEntity target) {
/*  882 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LivingEntity m_6688_() {
/*  888 */     Entity rider = m_146895_();
/*  889 */     Player player = (Player)rider; return (rider instanceof Player) ? (LivingEntity)player : null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_20348_(@NotNull Entity passenger) {
/*  895 */     super.m_20348_(passenger);
/*      */     
/*  897 */     if (passenger instanceof Player) {
/*      */       
/*  899 */       passenger.m_146922_(m_146908_());
/*  900 */       passenger.m_146926_(m_146909_());
/*      */     } 
/*      */     
/*  903 */     if (hasLocalDriver()) {
/*      */       
/*  905 */       MountControlsMessenger.sendControlsMessage();
/*  906 */       MountCameraManager.onDragonMount();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_20351_(@NotNull Entity passenger) {
/*  913 */     if (hasLocalDriver()) MountCameraManager.onDragonDismount(); 
/*  914 */     super.m_20351_(passenger);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_19956_(@NotNull Entity ridden, @NotNull Entity.MoveFunction pCallback) {
/*  920 */     if (m_20363_(ridden)) {
/*      */ 
/*      */ 
/*      */       
/*  924 */       Vec3 rePos = (new Vec3(0.0D, m_6048_() + ridden.m_6049_(), m_6134_())).m_82524_((float)Math.toRadians(-this.f_20883_)).m_82549_(m_20182_());
/*  925 */       pCallback.m_20372_(ridden, rePos.f_82479_, rePos.f_82480_, rePos.f_82481_);
/*      */       
/*  927 */       if (m_146895_() instanceof LivingEntity) {
/*      */         
/*  929 */         ridden.f_19860_ = ridden.m_146909_();
/*  930 */         ridden.f_19859_ = ridden.m_146908_();
/*  931 */         ridden.m_5618_(this.f_20883_);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_6673_(DamageSource src) {
/*  939 */     Entity srcEnt = src.m_7639_();
/*  940 */     if (srcEnt != null && (srcEnt == this || m_20363_(srcEnt))) return true;
/*      */     
/*  942 */     return super.m_6673_(src);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getHealthFraction() {
/*  947 */     return m_21223_() / m_21233_();
/*      */   }
/*      */ 
/*      */   
/*      */   public int getMaxDeathTime() {
/*  952 */     return 120;
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_142687_(@NotNull Entity.RemovalReason pReason) {
/*  957 */     Entity entity = m_146895_(); if (entity instanceof EndCrystal) { EndCrystal endCrystal = (EndCrystal)entity;
/*  958 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  959 */         endCrystal.m_6469_(serverLevel.m_269111_().m_269264_(), 1.0F); }
/*      */        }
/*  961 */      if (m_146895_() != null && m_146895_() instanceof EndCrystal) {
/*      */       return;
/*      */     }
/*  964 */     if (this.nearestCrystal != null) {
/*  965 */       this.nearestCrystal.m_31052_(null);
/*      */     }
/*      */     
/*  968 */     super.m_142687_(pReason);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void m_6210_() {
/*  974 */     double posXTmp = m_20185_();
/*  975 */     double posYTmp = m_20186_();
/*  976 */     double posZTmp = m_20189_();
/*  977 */     boolean onGroundTmp = m_20096_();
/*      */     
/*  979 */     super.m_6210_();
/*  980 */     m_6034_(posXTmp, posYTmp, posZTmp);
/*  981 */     m_6853_(onGroundTmp);
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public EntityDimensions m_6972_(@NotNull Pose poseIn) {
/*  987 */     float height = m_21825_() ? 2.15F : 2.75F;
/*  988 */     float scale = m_6134_();
/*  989 */     return new EntityDimensions(2.75F * scale, height * scale, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_6162_() {
/*  995 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public DragonAnimator getAnimator() {
/* 1000 */     return this.animator;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_6040_() {
/* 1006 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_5825_() {
/* 1012 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean m_5830_() {
/* 1018 */     if (this.f_19794_) return false;
/*      */ 
/*      */     
/* 1021 */     AABB collider = m_20191_().m_82406_((m_20205_() * 0.2F));
/* 1022 */     return BlockPos.m_121921_(collider).anyMatch(pos -> {
/*      */           BlockState state = m_9236_().m_8055_(pos);
/*      */           
/* 1025 */           return (!state.m_60795_() && state.m_60828_((BlockGetter)m_9236_(), pos) && Shapes.m_83157_(state.m_60812_((BlockGetter)m_9236_(), pos).m_83216_(pos.m_123341_(), pos.m_123342_(), pos.m_123343_()), Shapes.m_83064_(collider), BooleanOp.f_82689_));
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public Vec3 m_7371_(float p_20309_) {
/* 1033 */     return new Vec3(m_20185_(), m_20186_() + m_20206_(), m_20189_());
/*      */   }
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public Packet<ClientGamePacketListener> m_5654_() {
/* 1039 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasLocalDriver() {
/* 1044 */     Entity entity = m_146895_(); if (entity instanceof Player) { Player p = (Player)entity; if (p.m_7578_()); }  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static AttributeSupplier.Builder createAttributes() {
/* 1049 */     return Mob.m_21552_()
/* 1050 */       .m_22268_(Attributes.f_22279_, 0.3D)
/* 1051 */       .m_22268_(Attributes.f_22276_, 150.0D)
/* 1052 */       .m_22268_(Attributes.f_22277_, 16.0D)
/* 1053 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 1054 */       .m_22268_(Attributes.f_22281_, 8.0D)
/* 1055 */       .m_22268_(Attributes.f_22280_, 0.32D);
/*      */   }
/*      */   
/*      */   public void aimBodyAndHeadAt(Vec3 to, float maxYawStep, float maxPitchStep) {
/* 1059 */     Vec3 from = m_20299_(1.0F);
/*      */     
/* 1061 */     double dx = to.f_82479_ - from.f_82479_;
/* 1062 */     double dz = to.f_82481_ - from.f_82481_;
/* 1063 */     double dy = to.f_82480_ - from.f_82480_;
/* 1064 */     double distXZ = Math.sqrt(dx * dx + dz * dz);
/*      */     
/* 1066 */     float wantYaw = (float)(Mth.m_14136_(dz, dx) * 57.29577951308232D) - 90.0F;
/* 1067 */     float wantPitch = (float)-(Mth.m_14136_(dy, distXZ) * 57.29577951308232D);
/*      */     
/* 1069 */     float yaw = Mth.m_14148_(m_146908_(), wantYaw, maxYawStep);
/* 1070 */     float pitch = Mth.m_14148_(m_146909_(), wantPitch, maxPitchStep);
/*      */     
/* 1072 */     m_146922_(yaw);
/* 1073 */     m_146926_(pitch);
/* 1074 */     m_5616_(yaw);
/* 1075 */     m_5618_(yaw);
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_6667_(@NotNull DamageSource source) {
/* 1080 */     if (m_9236_() instanceof ServerLevel && 
/* 1081 */       this.summoner != null) { LivingEntity livingEntity = this.summoner; if (livingEntity instanceof Player) { Player player = (Player)livingEntity; if (player.m_6084_()) {
/* 1082 */           player.m_36335_().m_41524_((Item)AnnoyingVillagersModItems.ENDER_SLAYER_SCYTHE.get(), 3600);
/* 1083 */           if (player.getPersistentData().m_128441_("DragonUUID") && 
/* 1084 */             m_20148_().equals(player.getPersistentData().m_128342_("DragonUUID")))
/* 1085 */             player.getPersistentData().m_128473_("DragonUUID"); 
/*      */         }  }
/*      */        }
/*      */     
/* 1089 */     super.m_6667_(source);
/*      */   }
/*      */   
/*      */   public static class DragonMoveController
/*      */     extends MoveControl
/*      */   {
/*      */     private final HerobrineDragonEntity dragon;
/*      */     
/*      */     public DragonMoveController(HerobrineDragonEntity dragon) {
/* 1098 */       super((Mob)dragon);
/* 1099 */       this.dragon = dragon;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void m_8126_() {
/* 1105 */       if (!this.dragon.m_29443_()) {
/*      */         
/* 1107 */         super.m_8126_();
/*      */         
/*      */         return;
/*      */       } 
/* 1111 */       if (this.f_24981_ == MoveControl.Operation.MOVE_TO) {
/*      */         
/* 1113 */         this.f_24981_ = MoveControl.Operation.WAIT;
/* 1114 */         double xDif = this.f_24975_ - this.f_24974_.m_20185_();
/* 1115 */         double yDif = this.f_24976_ - this.f_24974_.m_20186_();
/* 1116 */         double zDif = this.f_24977_ - this.f_24974_.m_20189_();
/* 1117 */         double sq = xDif * xDif + yDif * yDif + zDif * zDif;
/* 1118 */         if (sq < 2.500000277905201E-7D) {
/*      */           
/* 1120 */           this.f_24974_.m_21567_(0.0F);
/* 1121 */           this.f_24974_.m_21564_(0.0F);
/*      */           
/*      */           return;
/*      */         } 
/* 1125 */         float speed = (float)(this.f_24978_ * this.f_24974_.m_21133_(Attributes.f_22280_));
/* 1126 */         double distSq = Math.sqrt(xDif * xDif + zDif * zDif);
/* 1127 */         this.f_24974_.m_7910_(speed);
/* 1128 */         if (Math.abs(yDif) > 9.999999747378752E-6D || Math.abs(distSq) > 9.999999747378752E-6D) {
/* 1129 */           this.f_24974_.m_21567_((float)yDif * speed);
/*      */         }
/* 1131 */         float yaw = (float)(Mth.m_14136_(zDif, xDif) * 57.2957763671875D) - 90.0F;
/* 1132 */         this.f_24974_.m_146922_(m_24991_(this.f_24974_.m_146908_(), yaw, 6.0F));
/*      */       }
/*      */       else {
/*      */         
/* 1136 */         this.f_24974_.m_21567_(0.0F);
/* 1137 */         this.f_24974_.m_21564_(0.0F);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public static class DragonBodyController
/*      */     extends BodyRotationControl
/*      */   {
/*      */     private final HerobrineDragonEntity dragon;
/*      */     
/*      */     public DragonBodyController(HerobrineDragonEntity dragon) {
/* 1148 */       super((Mob)dragon);
/* 1149 */       this.dragon = dragon;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void m_8121_() {
/* 1155 */       this.dragon.f_20883_ = this.dragon.m_146908_();
/* 1156 */       this.dragon.f_20885_ = Mth.m_14094_(this.dragon.f_20885_, this.dragon.f_20883_, this.dragon.m_8085_());
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\HerobrineDragonEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */