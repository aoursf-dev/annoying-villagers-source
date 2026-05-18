/*      */ package com.pla.annoyingvillagers.entity;
/*      */ import com.pla.annoyingvillagers.clazz.BbqCombatMode;
/*      */ import com.pla.annoyingvillagers.clazz.BurstProtectEntity;
/*      */ import com.pla.annoyingvillagers.clazz.CombatVoiceLineEntity;
/*      */ import com.pla.annoyingvillagers.clazz.SauceType;
/*      */ import com.pla.annoyingvillagers.clazz.TridentMode;
/*      */ import com.pla.annoyingvillagers.entity.goal.EscapeAvoidGoal;
/*      */ import com.pla.annoyingvillagers.entity.goal.FollowEscapeLeaderGoal;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModMobEffects;
/*      */ import com.pla.annoyingvillagers.util.TeamUtil;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.nbt.CompoundTag;
/*      */ import net.minecraft.network.chat.Component;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.sounds.SoundEvent;
/*      */ import net.minecraft.sounds.SoundEvents;
/*      */ import net.minecraft.util.Mth;
/*      */ import net.minecraft.world.DifficultyInstance;
/*      */ import net.minecraft.world.InteractionHand;
/*      */ import net.minecraft.world.damagesource.DamageSource;
/*      */ import net.minecraft.world.damagesource.DamageTypes;
/*      */ import net.minecraft.world.effect.MobEffectInstance;
/*      */ import net.minecraft.world.effect.MobEffects;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.entity.EntityType;
/*      */ import net.minecraft.world.entity.EquipmentSlot;
/*      */ import net.minecraft.world.entity.LivingEntity;
/*      */ import net.minecraft.world.entity.Mob;
/*      */ import net.minecraft.world.entity.MobSpawnType;
/*      */ import net.minecraft.world.entity.SpawnGroupData;
/*      */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*      */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*      */ import net.minecraft.world.entity.ai.goal.Goal;
/*      */ import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
/*      */ import net.minecraft.world.entity.animal.Chicken;
/*      */ import net.minecraft.world.entity.player.Player;
/*      */ import net.minecraft.world.entity.projectile.ThrownTrident;
/*      */ import net.minecraft.world.item.Item;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.level.ItemLike;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.level.ServerLevelAccessor;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import net.minecraftforge.common.ForgeHooks;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ 
/*      */ public class BbqEntity extends Chicken implements BurstProtectEntity, CombatVoiceLineEntity {
/*      */   @Nullable
/*      */   private BlueDemonEntity leader;
/*   55 */   private BbqCombatMode combatMode = BbqCombatMode.IDLE; @Nullable private UUID leaderUUID; @Nullable
/*   56 */   private UUID combatTargetUUID; private int formationSide = 1;
/*      */   private int chainShotsRemaining;
/*      */   private int chainShotInterval;
/*      */   private int chainShotCooldown;
/*      */   private int combatModeTicks;
/*      */   private int meleeCooldown;
/*      */   private float orbitAngle;
/*   63 */   private float orbitRadius = 5.0F;
/*   64 */   private SauceType sauceType = SauceType.BBQ_SAUCE;
/*      */   private int retreatTicks;
/*      */   @Nullable
/*      */   private BbqEntity sauceLeader;
/*      */   @Nullable
/*      */   private UUID sauceLeaderUUID;
/*      */   private boolean escapeMode;
/*      */   private boolean escapeFlying;
/*      */   private int escapeLocomotionTicks;
/*   73 */   private float escapeFlightHeight = 1.5F;
/*      */   
/*      */   private boolean deathAssemblyMode;
/*      */   private int deathAssemblyTicks;
/*      */   private double deathAssemblyX;
/*      */   private double deathAssemblyY;
/*      */   private double deathAssemblyZ;
/*      */   private boolean pendingDeathMainhandTrident;
/*      */   private boolean pendingDeathOffhandChestplate;
/*      */   @Nullable
/*      */   private UUID pendingDeathEscapeLeaderUUID;
/*      */   private boolean deathWatchMode;
/*      */   private boolean selfKill = false;
/*   86 */   private int voiceCooldown = 0;
/*      */ 
/*      */   
/*      */   public int getVoiceCooldown() {
/*   90 */     return this.voiceCooldown;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setVoiceCooldown(int cooldown) {
/*   95 */     this.voiceCooldown = cooldown;
/*      */   }
/*      */   
/*   98 */   protected float recentDamageTaken = 0.0F;
/*   99 */   protected int recentHitCounter = 0;
/*      */   
/*      */   public float getRecentDamageTaken() {
/*  102 */     return this.recentDamageTaken;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRecentDamageTaken(float value) {
/*  107 */     this.recentDamageTaken = value;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getRecentHitCounter() {
/*  112 */     return this.recentHitCounter;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRecentHitCounter(int value) {
/*  117 */     this.recentHitCounter = value;
/*      */   }
/*      */   
/*      */   public boolean isEscapeFlying() {
/*  121 */     return (this.escapeMode && this.escapeFlying);
/*      */   }
/*      */   
/*      */   public double getEscapeFlightHeight() {
/*  125 */     return this.escapeFlightHeight;
/*      */   }
/*      */   public void tickEscapeLocomotionMode() {
/*      */     float airChance;
/*  129 */     if (!this.escapeMode) {
/*  130 */       this.escapeFlying = false;
/*  131 */       this.escapeLocomotionTicks = 0;
/*  132 */       this.escapeFlightHeight = 1.5F;
/*  133 */       m_20242_(false);
/*      */       
/*      */       return;
/*      */     } 
/*  137 */     if (this.escapeLocomotionTicks > 0) {
/*  138 */       this.escapeLocomotionTicks--;
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  144 */     if (getSauceLeader() != null) {
/*  145 */       airChance = 0.45F;
/*      */     } else {
/*  147 */       airChance = 0.3F;
/*      */     } 
/*      */     
/*  150 */     if (this.sauceType == SauceType.SWEET_ONION_SAUCE) {
/*  151 */       airChance += 0.2F;
/*      */     }
/*      */     
/*  154 */     this.escapeFlying = (this.f_19796_.m_188501_() < airChance);
/*  155 */     this.escapeLocomotionTicks = this.f_19796_.m_216339_(25, 60);
/*  156 */     this.escapeFlightHeight = 1.0F + this.f_19796_.m_188501_() * 4.0F;
/*      */     
/*  158 */     if (!this.escapeFlying) {
/*  159 */       m_20242_(false);
/*  160 */       this.f_19789_ = 0.0F;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void moveEscapeAerialTowards(double x, double y, double z, double accel, double drag) {
/*  165 */     moveAerialTowards(x, y, z, accel, drag);
/*      */   }
/*      */   
/*      */   public BbqEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  169 */     this((EntityType<? extends BbqEntity>)AnnoyingVillagersModEntities.BBQ.get(), level);
/*      */   }
/*      */   
/*      */   public BbqEntity(EntityType<? extends BbqEntity> type, Level level) {
/*  173 */     super(type, level);
/*  174 */     m_274367_(0.6F);
/*  175 */     this.f_21364_ = 0;
/*  176 */     m_21557_(false);
/*  177 */     m_20340_(true);
/*  178 */     m_21530_();
/*  179 */     m_21409_(EquipmentSlot.MAINHAND, 0.0F);
/*  180 */     m_21409_(EquipmentSlot.OFFHAND, 0.0F);
/*      */   }
/*      */   
/*      */   public void startLeaderDeathWatch(@Nullable BlueDemonEntity leader) {
/*  184 */     if (leader == null || !leader.m_6084_()) {
/*      */       return;
/*      */     }
/*      */     
/*  188 */     this.deathWatchMode = true;
/*  189 */     this.deathAssemblyMode = false;
/*  190 */     this.escapeMode = false;
/*  191 */     this.retreatTicks = 0;
/*  192 */     clearCombat();
/*      */     
/*  194 */     setLeader(leader);
/*  195 */     this.sauceLeader = null;
/*  196 */     this.sauceLeaderUUID = null;
/*      */     
/*  198 */     this.escapeFlying = false;
/*  199 */     this.escapeLocomotionTicks = 0;
/*      */     
/*  201 */     m_21573_().m_26573_();
/*  202 */     m_20256_(Vec3.f_82478_);
/*  203 */     m_20242_(false);
/*  204 */     this.f_19789_ = 0.0F;
/*      */   }
/*      */   
/*      */   private void tickLeaderDeathWatch() {
/*  208 */     BlueDemonEntity leader = getLeader();
/*  209 */     if (leader == null || !leader.m_6084_() || !leader.isInFinalDeathSequence()) {
/*  210 */       this.deathWatchMode = false;
/*      */       
/*      */       return;
/*      */     } 
/*  214 */     clearCombat();
/*  215 */     m_20242_(false);
/*  216 */     this.f_19789_ = 0.0F;
/*  217 */     m_21563_().m_24960_((Entity)leader, 45.0F, 45.0F);
/*      */     
/*  219 */     switch (this.sauceType) { default: throw new IncompatibleClassChangeError();
/*      */       case HEAD_ATTACK: 
/*      */       case ORBIT: 
/*      */       case GROUND_ORBIT: 
/*  223 */       case PARALLEL: break; }  float baseOffset = 4.712389F;
/*      */ 
/*      */     
/*  226 */     switch (this.sauceType) { default: throw new IncompatibleClassChangeError();
/*      */       case HEAD_ATTACK: 
/*      */       case ORBIT: 
/*      */       case GROUND_ORBIT: 
/*  230 */       case PARALLEL: break; }  double radius = 1.8D;
/*      */ 
/*      */     
/*  233 */     float angle = leader.f_19797_ * 0.18F + baseOffset;
/*  234 */     double x = leader.m_20185_() + Mth.m_14089_(angle) * radius;
/*  235 */     double z = leader.m_20189_() + Mth.m_14031_(angle) * radius;
/*      */     
/*  237 */     if (m_20280_((Entity)leader) > 16.0D) {
/*  238 */       m_21573_().m_5624_((Entity)leader, 1.8D);
/*      */     } else {
/*  240 */       m_21573_().m_26519_(x, leader.m_20186_(), z, 1.35D);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void m_8099_() {
/*  246 */     this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
/*      */     
/*  248 */     this.f_21345_.m_25352_(1, (Goal)new EscapeAvoidGoal(this, Player.class, 12.0F, 2.0D, 2.0D));
/*  249 */     this.f_21345_.m_25352_(1, (Goal)new EscapeAvoidGoal(this, HerobrineMob.class, 12.0F, 2.0D, 2.0D));
/*  250 */     this.f_21345_.m_25352_(1, (Goal)new EscapeAvoidGoal(this, Monster.class, 12.0F, 2.0D, 2.0D));
/*  251 */     this.f_21345_.m_25352_(1, (Goal)new EscapeAvoidGoal(this, PlayerNpcEntity.class, 12.0F, 2.0D, 2.0D));
/*  252 */     this.f_21345_.m_25352_(1, (Goal)new EscapeAvoidGoal(this, AVNpc.class, 12.0F, 2.0D, 2.0D));
/*      */     
/*  254 */     this.f_21345_.m_25352_(2, (Goal)new FollowEscapeLeaderGoal(this));
/*  255 */     this.f_21345_.m_25352_(3, (Goal)new RandomLookAroundGoal((Mob)this));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_7301_(MobEffectInstance effect) {
/*  260 */     if (effect.m_19544_() == MobEffects.f_19614_) {
/*  261 */       if (!(m_9236_()).f_46443_ && m_6084_()) {
/*  262 */         m_5634_(4.0F);
/*      */       }
/*  264 */       return false;
/*      */     } 
/*  266 */     return super.m_7301_(effect);
/*      */   }
/*      */   
/*      */   public void setLeader(@Nullable BlueDemonEntity leader) {
/*  270 */     this.leader = leader;
/*  271 */     this.leaderUUID = (leader == null) ? null : leader.m_20148_();
/*      */   }
/*      */   
/*      */   public boolean isEscapeMode() {
/*  275 */     return this.escapeMode;
/*      */   }
/*      */   
/*      */   public void enterEscapeMode(@Nullable BbqEntity sauceLeader) {
/*  279 */     this.escapeMode = true;
/*  280 */     this.deathWatchMode = false;
/*  281 */     this.retreatTicks = 0;
/*  282 */     clearCombat();
/*      */     
/*  284 */     this.leader = null;
/*  285 */     this.leaderUUID = null;
/*      */     
/*  287 */     if (sauceLeader != null && sauceLeader.m_6084_() && sauceLeader != this) {
/*  288 */       this.sauceLeader = sauceLeader;
/*  289 */       this.sauceLeaderUUID = sauceLeader.m_20148_();
/*      */     } else {
/*  291 */       this.sauceLeader = null;
/*  292 */       this.sauceLeaderUUID = null;
/*      */     } 
/*      */     
/*  295 */     this.escapeFlying = false;
/*  296 */     this.escapeLocomotionTicks = 0;
/*  297 */     this.escapeFlightHeight = 1.5F;
/*      */     
/*  299 */     m_21573_().m_26573_();
/*  300 */     m_20256_(Vec3.f_82478_);
/*  301 */     m_20242_(false);
/*  302 */     this.f_19789_ = 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void startDeathAssembly(double x, double y, double z, boolean giveMainhandTrident, boolean giveOffhandChestplate, @Nullable BbqEntity escapeLeader) {
/*  309 */     this.escapeMode = false;
/*  310 */     clearCombat();
/*  311 */     this.retreatTicks = 0;
/*  312 */     this.deathWatchMode = false;
/*      */     
/*  314 */     this.deathAssemblyMode = true;
/*  315 */     this.deathAssemblyTicks = 1;
/*  316 */     this.deathAssemblyX = x;
/*  317 */     this.deathAssemblyY = y;
/*  318 */     this.deathAssemblyZ = z;
/*      */     
/*  320 */     this.pendingDeathMainhandTrident = giveMainhandTrident;
/*  321 */     this.pendingDeathOffhandChestplate = giveOffhandChestplate;
/*  322 */     this
/*      */ 
/*      */       
/*  325 */       .pendingDeathEscapeLeaderUUID = (escapeLeader != null && escapeLeader != this && escapeLeader.m_6084_()) ? escapeLeader.m_20148_() : null;
/*      */     
/*  327 */     this.leader = null;
/*  328 */     this.leaderUUID = null;
/*  329 */     this.sauceLeader = null;
/*  330 */     this.sauceLeaderUUID = null;
/*      */     
/*  332 */     this.escapeFlying = false;
/*  333 */     this.escapeLocomotionTicks = 0;
/*      */     
/*  335 */     m_21573_().m_26573_();
/*  336 */     m_20256_(Vec3.f_82478_);
/*      */     
/*  338 */     double offsetX = 0.0D;
/*  339 */     double offsetZ = 0.0D;
/*      */     
/*  341 */     switch (this.sauceType) {
/*      */       case HEAD_ATTACK:
/*  343 */         offsetX = 0.0D;
/*  344 */         offsetZ = 0.0D;
/*      */         break;
/*      */       case ORBIT:
/*  347 */         offsetX = 0.9D;
/*  348 */         offsetZ = 0.0D;
/*      */         break;
/*      */       case GROUND_ORBIT:
/*  351 */         offsetX = -0.9D;
/*  352 */         offsetZ = 0.0D;
/*      */         break;
/*      */       case PARALLEL:
/*  355 */         offsetX = 0.0D;
/*  356 */         offsetZ = 0.9D;
/*      */         break;
/*      */     } 
/*      */     
/*  360 */     m_6027_(x + offsetX, y, z + offsetZ);
/*  361 */     m_20242_(false);
/*  362 */     this.f_19789_ = 0.0F;
/*      */   }
/*      */   
/*      */   private void tickDeathAssembly() {
/*  366 */     clearCombat();
/*  367 */     m_21573_().m_26573_();
/*  368 */     m_20256_(Vec3.f_82478_);
/*  369 */     m_20242_(false);
/*  370 */     this.f_19789_ = 0.0F;
/*  371 */     m_21563_().m_24946_(this.deathAssemblyX, this.deathAssemblyY + 0.5D, this.deathAssemblyZ);
/*      */     
/*  373 */     if (this.deathAssemblyTicks > 0) {
/*  374 */       this.deathAssemblyTicks--;
/*      */     }
/*      */     
/*  377 */     if (this.deathAssemblyTicks > 0) {
/*      */       return;
/*      */     }
/*      */     
/*  381 */     this.deathAssemblyMode = false;
/*      */     
/*  383 */     if (this.pendingDeathMainhandTrident) {
/*  384 */       m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT
/*  385 */             .get()));
/*      */     }
/*      */     
/*  388 */     if (this.pendingDeathOffhandChestplate) {
/*  389 */       m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_CHESTPLATE
/*  390 */             .get()));
/*      */     }
/*      */     
/*  393 */     BbqEntity escapeLeader = null;
/*  394 */     if (this.pendingDeathEscapeLeaderUUID != null) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  395 */         Entity entity = serverLevel.m_8791_(this.pendingDeathEscapeLeaderUUID);
/*  396 */         if (entity instanceof BbqEntity) { BbqEntity bbq = (BbqEntity)entity; if (bbq.m_6084_())
/*  397 */             escapeLeader = bbq;  }
/*      */          }
/*      */        }
/*      */     
/*  401 */     this.pendingDeathMainhandTrident = false;
/*  402 */     this.pendingDeathOffhandChestplate = false;
/*  403 */     this.pendingDeathEscapeLeaderUUID = null;
/*      */     
/*  405 */     enterEscapeMode(escapeLeader);
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public BbqEntity getSauceLeader() {
/*  410 */     if (this.sauceLeader != null && this.sauceLeader.m_6084_()) {
/*  411 */       return this.sauceLeader;
/*      */     }
/*      */     
/*  414 */     if (!(m_9236_()).f_46443_ && this.sauceLeaderUUID != null) {
/*  415 */       Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.sauceLeaderUUID);
/*  416 */       if (entity instanceof BbqEntity) { BbqEntity bbq = (BbqEntity)entity; if (bbq.m_6084_()) {
/*  417 */           this.sauceLeader = bbq;
/*  418 */           return bbq;
/*      */         }  }
/*      */     
/*      */     } 
/*  422 */     this.sauceLeader = null;
/*  423 */     this.sauceLeaderUUID = null;
/*  424 */     return null;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public BlueDemonEntity getLeader() {
/*  429 */     if (this.leader != null && this.leader.m_6084_()) {
/*  430 */       return this.leader;
/*      */     }
/*      */     
/*  433 */     if (!(m_9236_()).f_46443_ && this.leaderUUID != null) {
/*  434 */       Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.leaderUUID);
/*  435 */       if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemon = (BlueDemonEntity)entity; if (blueDemon.m_6084_()) {
/*  436 */           this.leader = blueDemon;
/*  437 */           return blueDemon;
/*      */         }  }
/*      */     
/*      */     } 
/*  441 */     return null;
/*      */   }
/*      */   
/*      */   public SauceType getSauceType() {
/*  445 */     return this.sauceType;
/*      */   }
/*      */   
/*      */   public void setSauceType(SauceType sauceType) {
/*  449 */     this.sauceType = (sauceType == null) ? SauceType.BBQ_SAUCE : sauceType;
/*  450 */     m_6593_((Component)Component.m_237115_(this.sauceType.getTranslationKey()));
/*      */     
/*  452 */     if (this.sauceType.isShockSauce() && m_21205_().m_41619_()) {
/*  453 */       m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get()));
/*      */     }
/*      */   }
/*      */   
/*      */   public BbqCombatMode getCombatMode() {
/*  458 */     return this.combatMode;
/*      */   }
/*      */   
/*      */   public void setCombatTarget(@Nullable LivingEntity target) {
/*  462 */     this.combatTargetUUID = (target == null) ? null : target.m_20148_();
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public LivingEntity getCombatTarget() {
/*  467 */     if (this.escapeMode) {
/*  468 */       return null;
/*      */     }
/*      */     
/*  471 */     if (!(m_9236_()).f_46443_ && this.combatTargetUUID != null) {
/*  472 */       Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.combatTargetUUID);
/*  473 */       if (entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity; if (livingEntity.m_6084_())
/*  474 */           return livingEntity;  }
/*      */       
/*  476 */       this.combatTargetUUID = null;
/*      */     } 
/*      */     
/*  479 */     BlueDemonEntity leader = getLeader();
/*  480 */     if (leader != null) {
/*  481 */       LivingEntity target = leader.m_5448_();
/*  482 */       if (target != null && target.m_6084_()) {
/*  483 */         return target;
/*      */       }
/*      */     } 
/*      */     
/*  487 */     return null;
/*      */   }
/*      */   
/*      */   public void startRetreat() {
/*  491 */     if (!m_6084_()) {
/*      */       return;
/*      */     }
/*      */     
/*  495 */     clearCombat();
/*  496 */     this.retreatTicks = 60 + this.f_19796_.m_188503_(20);
/*      */     
/*  498 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  499 */       serverLevel.m_7654_().m_6846_().m_240416_(
/*  500 */           (Component)Component.m_237113_("<" + m_7755_().getString() + "> " + Component.m_237115_("subtitles.bbq_retreat").getString()), false); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void tickRetreat() {
/*  507 */     BlueDemonEntity leader = getLeader();
/*  508 */     if (leader == null || !leader.m_6084_()) {
/*  509 */       m_146870_();
/*      */       
/*      */       return;
/*      */     } 
/*  513 */     Vec3 away = m_20182_().m_82546_(leader.m_20182_());
/*  514 */     away = new Vec3(away.f_82479_, 0.0D, away.f_82481_);
/*      */     
/*  516 */     if (away.m_82556_() < 1.0E-4D) {
/*  517 */       away = new Vec3(this.f_19796_.m_188500_() - 0.5D, 0.0D, this.f_19796_.m_188500_() - 0.5D);
/*      */     }
/*      */     
/*  520 */     away = away.m_82541_();
/*      */     
/*  522 */     double x = m_20185_() + away.f_82479_ * 10.0D;
/*  523 */     double z = m_20189_() + away.f_82481_ * 10.0D;
/*      */     
/*  525 */     if (this.sauceType == SauceType.SWEET_ONION_SAUCE) {
/*  526 */       m_20242_(true);
/*  527 */       m_21573_().m_26573_();
/*  528 */       moveAerialTowards(x, m_20186_() + 1.5D, z, 0.22D, 0.88D);
/*      */     } else {
/*  530 */       m_20242_(false);
/*  531 */       m_21573_().m_26519_(x, m_20186_(), z, 1.45D);
/*      */     } 
/*      */     
/*  534 */     this.retreatTicks--;
/*  535 */     if (this.retreatTicks <= 0) {
/*  536 */       m_146870_();
/*      */     }
/*      */   }
/*      */   
/*      */   public void startOrbit(@Nullable LivingEntity target, int ticks) {
/*  541 */     if (target == null) {
/*  542 */       clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/*  546 */     setCombatTarget(target);
/*  547 */     this.combatMode = BbqCombatMode.ORBIT;
/*  548 */     this.combatModeTicks = Math.max(this.combatModeTicks, ticks);
/*      */     
/*  550 */     if (this.f_19796_.m_188503_(4) == 0) {
/*  551 */       this.orbitRadius = (new Random()).nextFloat(3.5F, 6.5F);
/*      */     }
/*      */     
/*  554 */     if (this.f_19796_.m_188503_(6) == 0) {
/*  555 */       this.formationSide = -this.formationSide;
/*      */     }
/*      */   }
/*      */   
/*      */   public void startHeadAttack(@Nullable LivingEntity target, int ticks) {
/*  560 */     if (target == null) {
/*  561 */       clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/*  565 */     setCombatTarget(target);
/*  566 */     this.combatMode = BbqCombatMode.HEAD_ATTACK;
/*  567 */     this.combatModeTicks = ticks;
/*  568 */     this.chainShotsRemaining = 0;
/*  569 */     this.chainShotCooldown = 0;
/*  570 */     this.orbitAngle = this.f_19796_.m_188501_() * 6.2831855F;
/*  571 */     m_21573_().m_26573_();
/*      */   }
/*      */   
/*      */   public boolean isHeadAttacking() {
/*  575 */     return (this.combatMode == BbqCombatMode.HEAD_ATTACK && this.combatModeTicks > 0);
/*      */   }
/*      */   
/*      */   public void clearCombat() {
/*  579 */     this.combatMode = BbqCombatMode.IDLE;
/*  580 */     this.combatModeTicks = 0;
/*  581 */     this.combatTargetUUID = null;
/*  582 */     this.chainShotsRemaining = 0;
/*  583 */     this.chainShotCooldown = 0;
/*  584 */     m_20242_(false);
/*      */   }
/*      */   
/*      */   public void shootChain(LivingEntity target, int shots, int intervalTicks) {
/*  588 */     if (target == null || this.chainShotsRemaining > 0 || this.chainShotCooldown > 0) {
/*      */       return;
/*      */     }
/*      */     
/*  592 */     setCombatTarget(target);
/*  593 */     this.chainShotsRemaining = Math.max(0, shots);
/*  594 */     this.chainShotInterval = Math.max(1, intervalTicks);
/*  595 */     this.chainShotCooldown = this.chainShotInterval;
/*      */   }
/*      */   
/*      */   public void shootCluster(LivingEntity target, int eggCount, float power, float inaccuracy) {
/*  599 */     if (target == null || this.chainShotsRemaining > 0 || this.chainShotCooldown > 0) {
/*      */       return;
/*      */     }
/*      */     
/*  603 */     setCombatTarget(target);
/*      */     
/*  605 */     for (int i = 0; i < eggCount; i++) {
/*  606 */       firePoisonEgg(target, power, inaccuracy);
/*      */     }
/*      */     
/*  609 */     this.chainShotCooldown = 45;
/*      */   }
/*      */   
/*      */   private void tickManualAttacks() {
/*  613 */     if (this.chainShotsRemaining <= 0) {
/*      */       return;
/*      */     }
/*      */     
/*  617 */     LivingEntity target = getCombatTarget();
/*  618 */     if (target == null) {
/*  619 */       this.chainShotsRemaining = 0;
/*      */       
/*      */       return;
/*      */     } 
/*  623 */     if (this.chainShotCooldown > 0) {
/*      */       return;
/*      */     }
/*      */     
/*  627 */     firePoisonEgg(target, 1.45F, 6.0F);
/*  628 */     this.chainShotsRemaining--;
/*      */     
/*  630 */     if (this.chainShotsRemaining > 0) {
/*  631 */       this.chainShotCooldown = this.chainShotInterval;
/*      */     } else {
/*  633 */       this.chainShotCooldown = 35;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void tickShockTouch(LivingEntity target) {
/*  638 */     if (!this.sauceType.isShockSauce()) {
/*      */       return;
/*      */     }
/*      */     
/*  642 */     if (this.meleeCooldown > 0) {
/*      */       return;
/*      */     }
/*      */     
/*  646 */     if (m_20275_(target.m_20185_(), target.m_20188_(), target.m_20189_()) > 2.25D) {
/*      */       return;
/*      */     }
/*      */     
/*  650 */     target.m_6469_(m_269291_().m_269333_((LivingEntity)this), (float)m_21133_(Attributes.f_22281_));
/*      */     
/*  652 */     if (this.f_19796_.m_188501_() < 0.35F) {
/*  653 */       target.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ELECTRIFY.get(), 20, 1));
/*      */     }
/*      */     
/*  656 */     m_5496_(SoundEvents.f_12514_, 1.0F, 1.0F + this.f_19796_.m_188501_() * 0.2F);
/*  657 */     this.meleeCooldown = 12;
/*      */   }
/*      */   
/*      */   private void tickSweetOnionSupport() {
/*  661 */     BlueDemonEntity leader = getLeader();
/*  662 */     LivingEntity enemy = getCombatTarget();
/*      */     
/*  664 */     m_20242_(false);
/*  665 */     this.f_19789_ = 0.0F;
/*      */     
/*  667 */     if (leader == null || !leader.m_6084_()) {
/*  668 */       tickLeaderFollow();
/*      */       
/*      */       return;
/*      */     } 
/*  672 */     if (m_21205_().m_41619_()) {
/*  673 */       BlueDemonThrownTridentEntity trident = leader.getNearestGroundedOwnedTrident(12.0D);
/*      */       
/*  675 */       if (trident != null) {
/*  676 */         if (m_20280_((Entity)trident) > 2.25D) {
/*  677 */           m_21573_().m_26519_(trident.m_20185_(), trident.m_20186_(), trident.m_20189_(), 1.35D);
/*      */         } else {
/*  679 */           ItemStack carried = new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get());
/*  680 */           carried.m_41784_().m_128359_("CarriedTridentMode", trident.getMode().name());
/*      */           
/*  682 */           trident.m_146870_();
/*  683 */           m_8061_(EquipmentSlot.MAINHAND, carried);
/*  684 */           m_21573_().m_26573_();
/*      */         } 
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*  690 */     if (m_21205_().m_150930_((Item)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get())) {
/*  691 */       if (m_20270_((Entity)leader) > 2.5D)
/*  692 */       { m_21573_().m_5624_((Entity)leader, 1.35D); }
/*  693 */       else { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  694 */           TridentMode mode = TridentMode.DEFAULT;
/*  695 */           CompoundTag tag = m_21205_().m_41783_();
/*      */           
/*  697 */           if (tag != null && tag.m_128441_("CarriedTridentMode")) {
/*      */             try {
/*  699 */               mode = TridentMode.valueOf(tag.m_128461_("CarriedTridentMode"));
/*  700 */             } catch (IllegalArgumentException illegalArgumentException) {}
/*      */           }
/*      */ 
/*      */           
/*  704 */           BlockPos standPos = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 
/*      */               
/*  706 */               BlockPos.m_274561_(leader
/*  707 */                 .m_20185_() + (this.f_19796_.m_188500_() - 0.5D) * 2.0D, leader
/*  708 */                 .m_20186_(), leader
/*  709 */                 .m_20189_() + (this.f_19796_.m_188500_() - 0.5D) * 2.0D));
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  714 */           BlueDemonThrownTridentEntity placed = new BlueDemonThrownTridentEntity((EntityType<? extends ThrownTrident>)AnnoyingVillagersModEntities.BLUE_DEMON_THROWN_TRIDENT.get(), (Level)serverLevel);
/*      */ 
/*      */           
/*  717 */           placed.setMode(mode);
/*  718 */           placed.assignSpawnSequence((LivingEntity)leader);
/*      */           
/*  720 */           serverLevel.m_7967_((Entity)placed);
/*  721 */           placed.placeAsGroundedSupport((LivingEntity)leader, standPos);
/*  722 */           placed.trimOldGroundedTridentsAroundOwnerOnSpawn();
/*      */           
/*  724 */           m_8061_(EquipmentSlot.MAINHAND, ItemStack.f_41583_);
/*  725 */           m_21573_().m_26573_(); }
/*      */          }
/*      */       
/*      */       return;
/*      */     } 
/*  730 */     if (enemy != null && enemy.m_6084_()) {
/*  731 */       Vec3 away = leader.m_20182_().m_82546_(enemy.m_20182_());
/*  732 */       away = new Vec3(away.f_82479_, 0.0D, away.f_82481_);
/*      */       
/*  734 */       if (away.m_82556_() < 1.0E-4D) {
/*  735 */         away = m_20182_().m_82546_(enemy.m_20182_());
/*  736 */         away = new Vec3(away.f_82479_, 0.0D, away.f_82481_);
/*      */       } 
/*      */       
/*  739 */       if (away.m_82556_() < 1.0E-4D) {
/*  740 */         away = new Vec3(1.0D, 0.0D, 0.0D);
/*      */       }
/*      */       
/*  743 */       away = away.m_82541_().m_82490_(8.0D + this.f_19796_.m_188500_() * 3.0D);
/*  744 */       Vec3 desired = leader.m_20182_().m_82549_(away);
/*      */       
/*  746 */       m_21573_().m_26519_(desired.f_82479_, leader.m_20186_(), desired.f_82481_, 1.4D);
/*  747 */       m_21563_().m_24960_((Entity)enemy, 30.0F, 30.0F);
/*      */       
/*      */       return;
/*      */     } 
/*  751 */     tickLeaderFollow();
/*      */   }
/*      */   
/*      */   private void firePoisonEgg(LivingEntity target, float power, float inaccuracy) {
/*  755 */     if ((m_9236_()).f_46443_) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  762 */     ThrownPoisonEggEntity projectile = new ThrownPoisonEggEntity((EntityType<? extends ThrownPoisonEggEntity>)AnnoyingVillagersModEntities.THROWN_POISON_EGG.get(), (LivingEntity)this, m_9236_());
/*      */ 
/*      */     
/*  765 */     double dX = target.m_20185_() - m_20185_();
/*  766 */     double dY = target.m_20188_() - projectile.m_20186_();
/*  767 */     double dZ = target.m_20189_() - m_20189_();
/*      */     
/*  769 */     projectile.m_5602_((Entity)this);
/*  770 */     projectile.m_6034_(m_20185_(), m_20188_() - 0.1D, m_20189_());
/*  771 */     projectile.m_6686_(dX, dY, dZ, power, inaccuracy);
/*  772 */     m_9236_().m_7967_((Entity)projectile);
/*      */   }
/*      */   
/*      */   private void moveAerialTowards(double x, double y, double z, double accel, double drag) {
/*  776 */     Vec3 wanted = new Vec3(x - m_20185_(), y - m_20186_(), z - m_20189_());
/*  777 */     double len = wanted.m_82553_();
/*      */     
/*  779 */     if (len < 0.05D) {
/*  780 */       m_20256_(m_20184_().m_82490_(drag));
/*      */       
/*      */       return;
/*      */     } 
/*  784 */     Vec3 desired = wanted.m_82541_().m_82490_(accel);
/*  785 */     Vec3 next = m_20184_().m_82490_(drag).m_82549_(desired);
/*  786 */     m_20256_(next);
/*  787 */     this.f_19812_ = true;
/*      */     
/*  789 */     float yaw = (float)(Mth.m_14136_(next.f_82481_, next.f_82479_) * 57.2957763671875D) - 90.0F;
/*  790 */     m_146922_(Mth.m_14189_(0.3F, m_146908_(), yaw));
/*  791 */     this.f_20883_ = m_146908_();
/*  792 */     this.f_20885_ = m_146908_();
/*      */   }
/*      */   
/*      */   public void startGroundOrbit(@Nullable LivingEntity target, int ticks) {
/*  796 */     if (target == null) {
/*  797 */       clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/*  801 */     setCombatTarget(target);
/*  802 */     this.combatMode = BbqCombatMode.GROUND_ORBIT;
/*  803 */     this.combatModeTicks = Math.max(this.combatModeTicks, ticks);
/*  804 */     m_20242_(false);
/*      */     
/*  806 */     if (this.f_19796_.m_188503_(4) == 0) {
/*  807 */       this.orbitRadius = (new Random()).nextFloat(3.5F, 6.5F);
/*      */     }
/*      */     
/*  810 */     if (this.f_19796_.m_188503_(6) == 0) {
/*  811 */       this.formationSide = -this.formationSide;
/*      */     }
/*      */   }
/*      */   
/*      */   private void tickGroundOrbit(LivingEntity target) {
/*  816 */     m_20242_(false);
/*  817 */     this.f_19789_ = 0.0F;
/*      */     
/*  819 */     if (this.f_19796_.m_188503_(70) == 0) {
/*  820 */       this.formationSide = -this.formationSide;
/*      */     }
/*      */     
/*  823 */     if (this.f_19796_.m_188503_(50) == 0) {
/*  824 */       this.orbitRadius = (new Random()).nextFloat(3.5F, 6.5F);
/*      */     }
/*      */     
/*  827 */     this.orbitAngle += 0.12F * this.formationSide;
/*      */     
/*  829 */     double x = target.m_20185_() + (Mth.m_14089_(this.orbitAngle) * this.orbitRadius);
/*  830 */     double z = target.m_20189_() + (Mth.m_14031_(this.orbitAngle) * this.orbitRadius);
/*      */     
/*  832 */     if (m_20270_((Entity)target) < 2.5D) {
/*  833 */       Vec3 away = m_20182_().m_82546_(target.m_20182_());
/*  834 */       away = new Vec3(away.f_82479_, 0.0D, away.f_82481_);
/*  835 */       if (away.m_82556_() > 1.0E-4D) {
/*  836 */         Vec3 desired = m_20182_().m_82549_(away.m_82541_().m_82490_(1.75D));
/*  837 */         m_21573_().m_26519_(desired.f_82479_, m_20186_(), desired.f_82481_, 1.35D);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*  842 */     m_21573_().m_26519_(x, target.m_20186_(), z, 1.25D);
/*      */   }
/*      */   
/*      */   private void tickOrbit(LivingEntity target) {
/*  846 */     m_20242_(true);
/*  847 */     this.f_19789_ = 0.0F;
/*  848 */     m_21573_().m_26573_();
/*      */     
/*  850 */     if (m_20096_()) {
/*  851 */       m_20256_(m_20184_().m_82520_(0.0D, 0.32D, 0.0D));
/*      */     }
/*      */     
/*  854 */     if (this.f_19796_.m_188503_(70) == 0) {
/*  855 */       this.formationSide = -this.formationSide;
/*      */     }
/*      */     
/*  858 */     if (this.f_19796_.m_188503_(50) == 0) {
/*  859 */       this.orbitRadius = (new Random()).nextFloat(3.5F, 6.5F);
/*      */     }
/*      */     
/*  862 */     this.orbitAngle += 0.16F * this.formationSide;
/*      */     
/*  864 */     double x = target.m_20185_() + (Mth.m_14089_(this.orbitAngle) * this.orbitRadius);
/*  865 */     double z = target.m_20189_() + (Mth.m_14031_(this.orbitAngle) * this.orbitRadius);
/*  866 */     double y = target.m_20188_() + 0.4D + Mth.m_14031_((this.f_19797_ + m_19879_()) * 0.25F) * 0.9D;
/*      */     
/*  868 */     moveAerialTowards(x, y, z, 0.18D, 0.86D);
/*      */   }
/*      */   
/*      */   private void dropSpecialHeldItemsBeforeDeath() {
/*  872 */     if (!this.escapeMode && !this.deathAssemblyMode) {
/*      */       return;
/*      */     }
/*      */     
/*  876 */     ItemStack main = m_21205_();
/*  877 */     if (main.m_150930_((Item)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get())) {
/*  878 */       m_19983_(new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get()));
/*  879 */       m_21008_(InteractionHand.MAIN_HAND, ItemStack.f_41583_);
/*      */     } 
/*      */     
/*  882 */     ItemStack off = m_21206_();
/*  883 */     if (off.m_150930_((Item)AnnoyingVillagersModItems.BLUE_DEMON_CHESTPLATE.get())) {
/*  884 */       m_19983_(new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_DEMON_CHESTPLATE.get()));
/*  885 */       m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_6667_(@NotNull DamageSource source) {
/*  891 */     if (!(m_9236_()).f_46443_) {
/*  892 */       dropSpecialHeldItemsBeforeDeath();
/*      */     }
/*      */     
/*  895 */     super.m_6667_(source);
/*      */   }
/*      */   
/*      */   private void tickHeadAttack(LivingEntity target) {
/*  899 */     if (this.combatModeTicks <= 0) {
/*  900 */       startOrbit(target, 20);
/*      */       
/*      */       return;
/*      */     } 
/*  904 */     m_20242_(true);
/*  905 */     this.f_19789_ = 0.0F;
/*  906 */     m_21573_().m_26573_();
/*      */     
/*  908 */     if (m_20096_()) {
/*  909 */       m_20256_(m_20184_().m_82520_(0.0D, 0.38D, 0.0D));
/*      */     }
/*      */     
/*  912 */     this.orbitAngle += 0.42F * this.formationSide;
/*      */     
/*  914 */     double x = target.m_20185_() + Mth.m_14089_(this.orbitAngle) * 0.85D;
/*  915 */     double z = target.m_20189_() + Mth.m_14031_(this.orbitAngle) * 0.85D;
/*  916 */     double y = target.m_20188_() + 0.15D + Mth.m_14031_((this.f_19797_ + m_19879_()) * 0.55F) * 0.35D;
/*      */     
/*  918 */     moveAerialTowards(x, y, z, 0.26D, 0.82D);
/*      */     
/*  920 */     if (this.meleeCooldown <= 0 && m_20275_(target.m_20185_(), target.m_20188_(), target.m_20189_()) < 2.25D) {
/*  921 */       target.m_6469_(m_269291_().m_269333_((LivingEntity)this), (float)m_21133_(Attributes.f_22281_));
/*  922 */       m_19970_((LivingEntity)this, (Entity)target);
/*  923 */       m_5496_(SoundEvents.f_11753_, 1.0F, 1.1F + this.f_19796_.m_188501_() * 0.2F);
/*  924 */       m_5496_(SoundEvents.f_11750_, 0.75F, 1.2F + this.f_19796_.m_188501_() * 0.3F);
/*  925 */       this.meleeCooldown = 8;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void tickLeaderFollow() {
/*  930 */     BlueDemonEntity leader = getLeader();
/*  931 */     m_20242_(false);
/*      */     
/*  933 */     if (leader == null || !leader.m_6084_()) {
/*  934 */       m_21573_().m_26573_();
/*      */       
/*      */       return;
/*      */     } 
/*  938 */     if (m_20270_((Entity)leader) > 5.0D) {
/*  939 */       m_21573_().m_5624_((Entity)leader, 1.35D);
/*      */     } else {
/*  941 */       m_21573_().m_26573_();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void startParallelPursuit(@Nullable LivingEntity target, int ticks) {
/*  946 */     if (target == null) {
/*  947 */       clearCombat();
/*      */       
/*      */       return;
/*      */     } 
/*  951 */     setCombatTarget(target);
/*  952 */     this.combatMode = BbqCombatMode.PARALLEL;
/*  953 */     this.combatModeTicks = Math.max(this.combatModeTicks, ticks);
/*  954 */     m_20242_(false);
/*      */     
/*  956 */     if (this.f_19796_.m_188503_(8) == 0) {
/*  957 */       this.formationSide = -this.formationSide;
/*      */     }
/*      */   }
/*      */   
/*      */   private void tickParallelPursuit(LivingEntity target) {
/*  962 */     BlueDemonEntity leader = getLeader();
/*  963 */     m_20242_(false);
/*      */     
/*  965 */     if (leader == null || !leader.m_6084_()) {
/*  966 */       tickLeaderFollow();
/*      */       
/*      */       return;
/*      */     } 
/*  970 */     if (this.f_19796_.m_188503_(80) == 0) {
/*  971 */       this.formationSide = -this.formationSide;
/*      */     }
/*      */     
/*  974 */     Vec3 forward = target.m_20182_().m_82546_(leader.m_20182_());
/*  975 */     forward = new Vec3(forward.f_82479_, 0.0D, forward.f_82481_);
/*      */     
/*  977 */     if (forward.m_82556_() < 1.0E-4D) {
/*  978 */       forward = new Vec3((leader.m_20154_()).f_82479_, 0.0D, (leader.m_20154_()).f_82481_);
/*      */     }
/*      */     
/*  981 */     if (forward.m_82556_() < 1.0E-4D) {
/*  982 */       forward = new Vec3(1.0D, 0.0D, 0.0D);
/*      */     }
/*      */     
/*  985 */     forward = forward.m_82541_();
/*      */     
/*  987 */     Vec3 side = (new Vec3(-forward.f_82481_, 0.0D, forward.f_82479_)).m_82490_(2.2D * this.formationSide);
/*  988 */     Vec3 back = forward.m_82490_(-0.75D);
/*  989 */     Vec3 desired = leader.m_20182_().m_82549_(side).m_82549_(back);
/*      */     
/*  991 */     m_21563_().m_24960_((Entity)target, 45.0F, 45.0F);
/*      */     
/*  993 */     if (m_20275_(desired.f_82479_, leader.m_20186_(), desired.f_82481_) > 2.25D) {
/*  994 */       m_21573_().m_26519_(desired.f_82479_, leader.m_20186_(), desired.f_82481_, 1.45D);
/*      */     } else {
/*  996 */       m_21573_().m_26573_();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_8119_() {
/* 1002 */     super.m_8119_();
/*      */     
/* 1004 */     if ((m_9236_()).f_46443_) {
/*      */       return;
/*      */     }
/*      */     
/* 1008 */     if (this.selfKill) {
/* 1009 */       m_6074_();
/*      */       
/*      */       return;
/*      */     } 
/* 1013 */     tickVoiceCooldown();
/* 1014 */     tickBurstProtectionDecay((LivingEntity)this);
/*      */     
/* 1016 */     if (this.deathWatchMode) {
/* 1017 */       tickLeaderDeathWatch();
/*      */       
/*      */       return;
/*      */     } 
/* 1021 */     if (this.deathAssemblyMode) {
/* 1022 */       tickDeathAssembly();
/*      */       
/*      */       return;
/*      */     } 
/* 1026 */     if (this.escapeMode) {
/* 1027 */       tickEscapeLocomotionMode();
/*      */       
/* 1029 */       if (this.sauceLeaderUUID != null && getSauceLeader() == null) {
/* 1030 */         this.sauceLeaderUUID = null;
/* 1031 */         this.sauceLeader = null;
/* 1032 */         this.escapeLocomotionTicks = 0;
/*      */       } 
/*      */       
/* 1035 */       if (!this.escapeFlying) {
/* 1036 */         m_20242_(false);
/* 1037 */         this.f_19789_ = 0.0F;
/*      */       } 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1043 */     if (this.retreatTicks > 0) {
/* 1044 */       tickRetreat();
/*      */       
/*      */       return;
/*      */     } 
/* 1048 */     teleportNearLeaderIfTooFar();
/* 1049 */     BlueDemonEntity leader = getLeader();
/*      */     
/* 1051 */     if (this.combatModeTicks > 0) {
/* 1052 */       this.combatModeTicks--;
/*      */     }
/*      */     
/* 1055 */     if (this.meleeCooldown > 0) {
/* 1056 */       this.meleeCooldown--;
/*      */     }
/*      */     
/* 1059 */     if (this.chainShotCooldown > 0) {
/* 1060 */       this.chainShotCooldown--;
/*      */     }
/*      */     
/* 1063 */     if (this.sauceType.isSupport()) {
/* 1064 */       tickSweetOnionSupport();
/*      */       
/*      */       return;
/*      */     } 
/* 1068 */     LivingEntity target = getCombatTarget();
/*      */     
/* 1070 */     if (target != null && target.m_6084_()) {
/* 1071 */       if (leader != null && leader.m_6084_() && leader.m_5448_() != null && leader.m_20270_((Entity)leader.m_5448_()) > 10.0D && this.combatMode != BbqCombatMode.PARALLEL) {
/* 1072 */         startParallelPursuit(target, 20);
/*      */       }
/*      */       
/* 1075 */       m_21563_().m_24960_((Entity)target, 45.0F, 45.0F);
/*      */       
/* 1077 */       if (this.sauceType == SauceType.BBQ_SAUCE) {
/* 1078 */         tickManualAttacks();
/*      */       }
/*      */       
/* 1081 */       switch (this.combatMode) {
/*      */         case HEAD_ATTACK:
/* 1083 */           if (this.combatModeTicks > 0) {
/* 1084 */             tickHeadAttack(target); break;
/*      */           } 
/* 1086 */           startGroundOrbit(target, 20);
/* 1087 */           tickGroundOrbit(target);
/*      */           break;
/*      */         case ORBIT:
/* 1090 */           tickOrbit(target); break;
/* 1091 */         case GROUND_ORBIT: tickGroundOrbit(target); break;
/* 1092 */         case PARALLEL: tickParallelPursuit(target); break;
/*      */         default:
/* 1094 */           if (leader != null && leader.m_6084_() && leader.m_20270_((Entity)target) > 10.0D) {
/* 1095 */             startParallelPursuit(target, 20);
/* 1096 */             tickParallelPursuit(target); break;
/*      */           } 
/* 1098 */           startGroundOrbit(target, 20);
/* 1099 */           tickGroundOrbit(target);
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/* 1104 */       tickShockTouch(target);
/*      */       
/*      */       return;
/*      */     } 
/* 1108 */     clearCombat();
/* 1109 */     tickLeaderFollow();
/*      */   }
/*      */   
/*      */   public void teleportNearLeaderIfTooFar() {
/* 1113 */     if ((m_9236_()).f_46443_ || this.retreatTicks > 0 || this.escapeMode) {
/*      */       return;
/*      */     }
/*      */     
/* 1117 */     BlueDemonEntity leader = getLeader();
/* 1118 */     if (leader == null || !leader.m_6084_() || leader.isSauceArrivalPending()) {
/*      */       return;
/*      */     }
/*      */     
/* 1122 */     if (m_20280_((Entity)leader) <= 400.0D) {
/*      */       return;
/*      */     }
/*      */     
/* 1126 */     float angle = leader.getSauceSquadAngle();
/* 1127 */     switch (getSauceType()) { default: throw new IncompatibleClassChangeError();
/*      */       case HEAD_ATTACK: 
/*      */       case ORBIT: 
/*      */       case GROUND_ORBIT: 
/* 1131 */       case PARALLEL: break; }  double laneOffset = 2.25D;
/*      */ 
/*      */     
/* 1134 */     double forwardX = Mth.m_14089_(angle);
/* 1135 */     double forwardZ = Mth.m_14031_(angle);
/* 1136 */     double sideX = -forwardZ;
/* 1137 */     double sideZ = forwardX;
/*      */     
/* 1139 */     double radius = 1.8D;
/* 1140 */     double x = leader.m_20185_() - forwardX * radius + sideX * laneOffset;
/* 1141 */     double z = leader.m_20189_() - forwardZ * radius + sideZ * laneOffset;
/* 1142 */     double y = leader.m_20186_();
/*      */     
/* 1144 */     m_6021_(x, y, z);
/* 1145 */     m_21573_().m_26573_();
/* 1146 */     m_20256_(Vec3.f_82478_);
/* 1147 */     m_20242_(false);
/* 1148 */     this.f_19789_ = 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_6469_(@NotNull DamageSource damageSource, float amount) {
/* 1153 */     if (damageSource.m_276093_(DamageTypes.f_268450_)) return false; 
/* 1154 */     if (damageSource.m_276093_(DamageTypes.f_268565_)) return false; 
/* 1155 */     if (damageSource.m_276093_(DamageTypes.f_268724_) || damageSource
/* 1156 */       .m_276093_(DamageTypes.f_286979_)) {
/* 1157 */       boolean bool = super.m_6469_(damageSource, amount);
/* 1158 */       if (bool) {
/* 1159 */         sayHurtSound((Mob)this, damageSource);
/*      */       }
/* 1161 */       return bool;
/*      */     } 
/* 1163 */     if (m_21223_() <= 1.0F && !this.selfKill) {
/* 1164 */       this.selfKill = true;
/* 1165 */       return false;
/*      */     } 
/* 1167 */     boolean result = super.m_6469_(damageSource, amount);
/*      */     
/* 1169 */     if (result && !(m_9236_()).f_46443_) { Entity entity = damageSource.m_7639_(); if (entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity;
/* 1170 */         if (this.deathAssemblyMode || this.deathWatchMode) {
/* 1171 */           return false;
/*      */         }
/*      */         
/* 1174 */         if (this.escapeMode) {
/* 1175 */           return true;
/*      */         }
/*      */         
/* 1178 */         BlueDemonEntity leader = getLeader();
/* 1179 */         startOrbit(livingEntity, 40);
/* 1180 */         if (leader != null)
/* 1181 */           leader.m_6710_(livingEntity);  }
/*      */        }
/*      */     
/* 1184 */     if (result) {
/* 1185 */       sayHurtSound((Mob)this, damageSource);
/*      */     }
/* 1187 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void m_6475_(@NotNull DamageSource pDamageSource, float pDamageAmount) {
/* 1192 */     if (pDamageSource.m_276093_(DamageTypes.f_268724_)) {
/* 1193 */       super.m_6475_(pDamageSource, pDamageAmount);
/*      */       
/*      */       return;
/*      */     } 
/* 1197 */     if (m_6673_(pDamageSource)) {
/*      */       return;
/*      */     }
/*      */     
/* 1201 */     pDamageAmount = ForgeHooks.onLivingHurt((LivingEntity)this, pDamageSource, pDamageAmount);
/* 1202 */     if (pDamageAmount <= 0.0F) {
/*      */       return;
/*      */     }
/*      */     
/* 1206 */     pDamageAmount = m_21161_(pDamageSource, pDamageAmount);
/* 1207 */     pDamageAmount = m_6515_(pDamageSource, pDamageAmount);
/*      */     
/* 1209 */     float f1 = Math.max(pDamageAmount - m_6103_(), 0.0F);
/* 1210 */     float absorbed = pDamageAmount - f1;
/* 1211 */     if (absorbed > 0.0F) {
/* 1212 */       m_7911_(m_6103_() - absorbed);
/* 1213 */       if (m_6103_() < 0.0F) m_7911_(0.0F); 
/*      */     } 
/* 1215 */     f1 = ForgeHooks.onLivingDamage((LivingEntity)this, pDamageSource, f1);
/* 1216 */     if (!pDamageSource.m_269533_(DamageTypeTags.f_268738_)) {
/* 1217 */       float cap = m_21233_() * 0.025F;
/* 1218 */       f1 = Mth.m_14036_(f1, 0.0F, cap);
/*      */       
/* 1220 */       float damageScale = 1.0F - Mth.m_14036_(this.recentDamageTaken / m_21233_() * 0.07F, 0.0F, 0.9F);
/* 1221 */       float hitScale = 1.0F - Mth.m_14036_(this.recentHitCounter / 5.0F, 0.0F, 0.9F);
/*      */       
/* 1223 */       f1 *= damageScale;
/*      */       
/* 1225 */       if (this.recentHitCounter >= 5) {
/* 1226 */         f1 = 0.1F;
/*      */       } else {
/* 1228 */         f1 *= hitScale;
/*      */       } 
/*      */       
/* 1231 */       this.recentHitCounter++;
/* 1232 */       this.recentDamageTaken += f1;
/*      */     } 
/* 1234 */     if (f1 <= 0.0F) {
/*      */       return;
/*      */     }
/* 1237 */     m_21231_().m_289194_(pDamageSource, f1);
/* 1238 */     m_21153_(m_21223_() - f1);
/* 1239 */     m_146850_(GameEvent.f_223706_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotNull
/*      */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
/* 1248 */     SpawnGroupData data = super.m_6518_(level, difficulty, reason, spawnData, dataTag);
/*      */     
/* 1250 */     if (!m_9236_().m_5776_()) {
/* 1251 */       TeamUtil.addOrJoinTeam((Entity)this, "blue_demon");
/*      */     }
/*      */     
/* 1254 */     return data;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public SoundEvent getHurtVoiceSound() {
/* 1259 */     return (SoundEvent)AnnoyingVillagersModSounds.BBQ_SAY.get();
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7380_(@NotNull CompoundTag tag) {
/* 1264 */     super.m_7380_(tag);
/*      */     
/* 1266 */     if (this.leaderUUID != null) {
/* 1267 */       tag.m_128362_("LeaderUUID", this.leaderUUID);
/*      */     }
/*      */     
/* 1270 */     tag.m_128359_("SauceType", this.sauceType.name());
/* 1271 */     tag.m_128379_("EscapeMode", this.escapeMode);
/*      */     
/* 1273 */     if (this.sauceLeaderUUID != null) {
/* 1274 */       tag.m_128362_("SauceLeaderUUID", this.sauceLeaderUUID);
/*      */     }
/* 1276 */     tag.m_128405_("VoiceCooldown", this.voiceCooldown);
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7378_(@NotNull CompoundTag tag) {
/* 1281 */     super.m_7378_(tag);
/*      */     
/* 1283 */     if (tag.m_128403_("LeaderUUID")) {
/* 1284 */       this.leaderUUID = tag.m_128342_("LeaderUUID");
/*      */     }
/*      */     
/* 1287 */     if (tag.m_128441_("SauceType")) {
/*      */       try {
/* 1289 */         setSauceType(SauceType.valueOf(tag.m_128461_("SauceType")));
/* 1290 */       } catch (IllegalArgumentException ignored) {
/* 1291 */         setSauceType(SauceType.BBQ_SAUCE);
/*      */       } 
/*      */     } else {
/* 1294 */       setSauceType(SauceType.BBQ_SAUCE);
/*      */     } 
/* 1296 */     this.escapeMode = tag.m_128471_("EscapeMode");
/*      */     
/* 1298 */     if (tag.m_128403_("SauceLeaderUUID")) {
/* 1299 */       this.sauceLeaderUUID = tag.m_128342_("SauceLeaderUUID");
/*      */     } else {
/* 1301 */       this.sauceLeaderUUID = null;
/*      */     } 
/* 1303 */     this.sauceLeader = null;
/* 1304 */     this.voiceCooldown = tag.m_128451_("VoiceCooldown");
/*      */   }
/*      */   @NotNull
/*      */   public static AttributeSupplier.Builder m_28263_() {
/* 1308 */     return Mob.m_21552_()
/* 1309 */       .m_22268_(Attributes.f_22279_, 0.27D)
/* 1310 */       .m_22268_(Attributes.f_22276_, 75.0D)
/* 1311 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 1312 */       .m_22268_(Attributes.f_22281_, 7.0D)
/* 1313 */       .m_22268_(Attributes.f_22277_, 24.0D)
/* 1314 */       .m_22268_(Attributes.f_22282_, 1.0D);
/*      */   }
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\BbqEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */