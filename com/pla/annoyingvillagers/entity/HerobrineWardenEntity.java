/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.util.Unit;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.AnimationState;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.Brain;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.memory.MemoryModuleType;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.entity.monster.warden.Warden;
/*     */ import net.minecraft.world.entity.monster.warden.WardenAi;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ public class HerobrineWardenEntity extends Warden {
/*  40 */   public final AnimationState idleAnimationState = new AnimationState();
/*  41 */   public final AnimationState eatingAnimationState = new AnimationState();
/*  42 */   private int idleAnimationTimeout = 0;
/*  43 */   private int eatingAnimationTimeout = 0;
/*     */   private EliteHerobrineKnockedEntity eatingHerobrine;
/*     */   private UUID eatingUUID;
/*     */   private boolean burrowStarted = false;
/*  47 */   private int burrowRemoveAt = -1;
/*     */   
/*     */   private static final int DIG_TICKS = 100;
/*  50 */   private static final EntityDataAccessor<Boolean> DATA_BONE_OPEN = SynchedEntityData.m_135353_(HerobrineWardenEntity.class, EntityDataSerializers.f_135035_);
/*     */   
/*     */   private boolean infectedSculk = false;
/*     */   
/*     */   protected void m_8097_() {
/*  55 */     super.m_8097_();
/*  56 */     this.f_19804_.m_135372_(DATA_BONE_OPEN, Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */   private boolean isBoneOpen() {
/*  60 */     return ((Boolean)this.f_19804_.m_135370_(DATA_BONE_OPEN)).booleanValue();
/*     */   }
/*     */   
/*     */   private void setBoneOpen(boolean open) {
/*  64 */     if (!m_9236_().m_5776_()) {
/*  65 */       this.f_19804_.m_135381_(DATA_BONE_OPEN, Boolean.valueOf(open));
/*     */     }
/*     */   }
/*     */   
/*     */   public void setEatingUUID(UUID eatingUUID) {
/*  70 */     this.eatingUUID = eatingUUID;
/*     */   }
/*     */   
/*     */   public HerobrineWardenEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
/*  74 */     super(pEntityType, pLevel);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  78 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   private void setupIdleAnimationStates() {
/*  82 */     if (this.idleAnimationTimeout <= 0) {
/*  83 */       this.idleAnimationTimeout = 40;
/*  84 */       this.idleAnimationState.m_216977_(this.f_19797_);
/*     */     } else {
/*  86 */       this.idleAnimationTimeout--;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setupEatingAnimationStates() {
/*  91 */     if (this.eatingAnimationTimeout <= 0) {
/*  92 */       this.eatingAnimationTimeout = 40;
/*  93 */       this.eatingAnimationState.m_216977_(this.f_19797_);
/*     */     } else {
/*  95 */       this.eatingAnimationTimeout--;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void burrowThenDespawn() {
/* 100 */     if (m_9236_().m_5776_() || this.burrowStarted)
/* 101 */       return;  this.burrowStarted = true;
/* 102 */     m_21573_().m_26573_();
/* 103 */     m_20256_(Vec3.f_82478_);
/*     */     
/* 105 */     Brain<Warden> brain = m_6274_();
/* 106 */     brain.m_21936_(MemoryModuleType.f_26372_);
/* 107 */     brain.m_21936_(MemoryModuleType.f_217782_);
/* 108 */     brain.m_21936_(MemoryModuleType.f_26370_);
/* 109 */     brain.m_21936_(MemoryModuleType.f_217783_);
/* 110 */     brain.m_21936_(MemoryModuleType.f_217772_);
/* 111 */     brain.m_21936_(MemoryModuleType.f_217770_);
/*     */     
/* 113 */     m_20124_(Pose.DIGGING);
/* 114 */     this.burrowRemoveAt = this.f_19797_ + 100 + 1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_8024_() {
/* 119 */     super.m_8024_();
/* 120 */     if (m_9236_().m_5776_())
/*     */       return; 
/* 122 */     if (this.eatingHerobrine == null && this.eatingUUID != null) {
/* 123 */       Entity e = ((ServerLevel)m_9236_()).m_8791_(this.eatingUUID);
/* 124 */       if (e instanceof EliteHerobrineKnockedEntity) { EliteHerobrineKnockedEntity herobrine = (EliteHerobrineKnockedEntity)e; if (herobrine.m_6084_()) {
/* 125 */           this.eatingHerobrine = herobrine;
/*     */         } }
/*     */     
/*     */     } 
/* 129 */     if (this.eatingUUID == null || this.eatingHerobrine == null || !this.eatingHerobrine.m_6084_()) {
/*     */       return;
/*     */     }
/*     */     
/* 133 */     LivingEntity brainTarget = m_5448_();
/* 134 */     if (brainTarget == null || !this.eatingUUID.equals(brainTarget.m_20148_())) {
/* 135 */       m_219459_((LivingEntity)this.eatingHerobrine);
/*     */     }
/*     */     
/* 138 */     int bump = AngerLevel.ANGRY.m_219226_() + 20;
/* 139 */     m_219387_((Entity)this.eatingHerobrine, bump, false);
/*     */     
/* 141 */     m_219448_().ifPresent(angry -> {
/*     */           if (!this.eatingUUID.equals(angry.m_20148_())) {
/*     */             m_219428_((Entity)angry);
/*     */           }
/*     */         });
/*     */     
/* 147 */     Brain<Warden> brain = m_6274_();
/* 148 */     brain.m_21936_(MemoryModuleType.f_26381_);
/* 149 */     brain.m_21936_(MemoryModuleType.f_26382_);
/* 150 */     brain.m_21936_(MemoryModuleType.f_217784_);
/*     */     
/* 152 */     WardenAi.m_219512_(this);
/* 153 */     brain.m_21952_(MemoryModuleType.f_26372_);
/* 154 */     m_219448_().map(Entity::m_20148_);
/*     */   }
/*     */   
/*     */   public boolean m_219385_(@Nullable Entity e) {
/*     */     LivingEntity living;
/* 159 */     if (e instanceof LivingEntity) { living = (LivingEntity)e; } else { return false; }
/* 160 */      if (this.eatingUUID == null) return false; 
/* 161 */     return (this.eatingUUID.equals(living.m_20148_()) && super.m_219385_(e));
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_219459_(@NotNull LivingEntity target) {
/* 166 */     if (this.eatingUUID != null && !this.eatingUUID.equals(target.m_20148_())) {
/*     */       return;
/*     */     }
/* 169 */     super.m_219459_(target);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 174 */     super.m_8119_();
/* 175 */     if (this.f_19797_ == 1 && !m_9236_().m_5776_() && !this.infectedSculk) {
/* 176 */       RandomSource randomSource = m_217043_();
/*     */       
/* 178 */       int attempts = (new Random()).nextInt(25, 50);
/* 179 */       for (int i = 0; i < attempts; i++) {
/* 180 */         int dx = Mth.m_216271_(randomSource, -5, 5);
/* 181 */         int dz = Mth.m_216271_(randomSource, -5, 5);
/*     */         
/* 183 */         BlockPos pos = new BlockPos((int)(m_20185_() + dx), m_20097_().m_123342_(), (int)(m_20189_() + dz));
/* 184 */         BlockState current = m_9236_().m_8055_(pos);
/*     */         
/* 186 */         if (!current.m_60795_() && 
/* 187 */           current.m_60819_().m_76178_() && 
/* 188 */           current.m_60800_((BlockGetter)m_9236_(), pos) != -1.0F && 
/* 189 */           !current.m_155947_()) {
/*     */ 
/*     */ 
/*     */           
/* 193 */           BlockState newState = (randomSource.m_188501_() < 0.2F) ? Blocks.f_220857_.m_49966_() : Blocks.f_220855_.m_49966_();
/*     */           
/* 195 */           m_9236_().m_7731_(pos, newState, 3);
/*     */         } 
/* 197 */       }  this.infectedSculk = true;
/*     */     } 
/* 199 */     if ((m_9236_()).f_46443_) {
/* 200 */       setupIdleAnimationStates();
/* 201 */       if (isBoneOpen()) {
/* 202 */         setupEatingAnimationStates();
/*     */       }
/*     */     } 
/* 205 */     if (this.burrowStarted && this.f_19797_ >= this.burrowRemoveAt) {
/* 206 */       m_142687_(Entity.RemovalReason.DISCARDED);
/*     */     }
/* 208 */     if (this.eatingHerobrine != null && !this.eatingHerobrine.m_6084_()) {
/* 209 */       this.eatingHerobrine = null;
/* 210 */       this.eatingUUID = null;
/* 211 */       if (isBoneOpen()) setBoneOpen(false); 
/* 212 */       burrowThenDespawn();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_7327_(@NotNull Entity pEntity) {
/* 218 */     if (!m_9236_().m_5776_() && !isBoneOpen()) {
/* 219 */       setBoneOpen(true);
/*     */     }
/* 221 */     return super.m_7327_(pEntity);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 226 */     super.m_7380_(tag);
/* 227 */     if (this.eatingUUID != null) {
/* 228 */       tag.m_128362_("EatingUUID", this.eatingUUID);
/*     */     }
/* 230 */     tag.m_128379_("BurrowStarted", this.burrowStarted);
/* 231 */     tag.m_128405_("BurrowRemoveAt", this.burrowRemoveAt);
/* 232 */     tag.m_128379_("InfectedSculk", this.infectedSculk);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 237 */     super.m_7378_(tag);
/* 238 */     if (tag.m_128403_("EatingUUID")) {
/* 239 */       this.eatingUUID = tag.m_128342_("EatingUUID");
/*     */     }
/* 241 */     this.burrowStarted = tag.m_128471_("BurrowStarted");
/* 242 */     this.burrowRemoveAt = tag.m_128451_("BurrowRemoveAt");
/* 243 */     this.infectedSculk = tag.m_128471_("InfectedSculk");
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7350_(@NotNull EntityDataAccessor<?> key) {
/* 248 */     super.m_7350_(key);
/* 249 */     if (f_19806_.equals(key) && 
/* 250 */       m_217003_(Pose.DIGGING)) {
/* 251 */       this.f_219347_.m_216977_(this.f_19797_);
/*     */     }
/*     */ 
/*     */     
/* 255 */     if (m_9236_().m_5776_() && DATA_BONE_OPEN.equals(key)) {
/* 256 */       if (isBoneOpen()) {
/* 257 */         this.eatingAnimationTimeout = 0;
/* 258 */         setupEatingAnimationStates();
/*     */       } else {
/* 260 */         this.eatingAnimationState.m_216973_();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor pLevel, @NotNull DifficultyInstance pDifficulty, @NotNull MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
/* 267 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
/* 268 */     m_6274_().m_21882_(MemoryModuleType.f_217770_, Unit.INSTANCE, 1200L);
/*     */     
/* 270 */     m_20124_(Pose.EMERGING);
/* 271 */     m_6274_().m_21882_(MemoryModuleType.f_217786_, Unit.INSTANCE, WardenAi.f_219490_);
/*     */     
/* 273 */     return returnSpawnGroupData;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource pSource, float pAmount) {
/* 278 */     if (pSource.m_276093_(DamageTypes.f_268724_) || pSource
/* 279 */       .m_276093_(DamageTypes.f_286979_)) {
/* 280 */       return super.m_6469_(pSource, pAmount);
/*     */     }
/* 282 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 283 */       EpicfightUtil.damageBlocked(pSource, (Entity)this, serverLevel); }
/*     */     
/* 285 */     return false;
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder m_219463_() {
/* 289 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 291 */     builder = builder.m_22268_(Attributes.f_22279_, 0.26D);
/* 292 */     builder = builder.m_22268_(Attributes.f_22276_, 500.0D);
/* 293 */     builder = builder.m_22268_(Attributes.f_22284_, 20.0D);
/* 294 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 295 */     builder = builder.m_22268_(Attributes.f_22277_, 24.0D);
/* 296 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\HerobrineWardenEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */