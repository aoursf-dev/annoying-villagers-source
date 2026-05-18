/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.block.CryingObsidianBlock;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.skill.ObsidianSledgeHammerSkill;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import com.pla.annoyingvillagers.util.ScreenShakeUtil;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.Registry;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.core.registries.Registries;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.tags.BlockTags;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageType;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.item.FallingBlockEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.ProjectileUtil;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.EntityHitResult;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObsidianSledgehammerProjectileEntity
/*     */   extends PathfinderMob
/*     */ {
/*     */   private Vec3 posToAim;
/*     */   private LivingEntity owner;
/*     */   private boolean motionInited = false;
/*  77 */   private double xd = 0.0D;
/*  78 */   private double yd = 0.0D;
/*  79 */   private double zd = 0.0D;
/*     */   
/*     */   private boolean shouldStun = false;
/*     */   
/*     */   private boolean meteoriteTrailEnabled = false;
/*     */   private static final double meteoriteTrailStartDistanceSquared = 4.0D;
/*     */   
/*     */   public void setPosToAim(@Nullable Vec3 pos) {
/*  87 */     this.posToAim = pos;
/*  88 */     this.motionInited = false;
/*     */   }
/*     */   
/*     */   public LivingEntity getOwner() {
/*  92 */     return this.owner;
/*     */   }
/*     */   
/*     */   public void setOwner(LivingEntity owner) {
/*  96 */     this.owner = owner;
/*     */   }
/*     */   
/*     */   public void setShouldStun(boolean shouldStun) {
/* 100 */     this.shouldStun = shouldStun;
/*     */   }
/*     */   
/*     */   public ObsidianSledgehammerProjectileEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/* 104 */     this((EntityType<ObsidianSledgehammerProjectileEntity>)AnnoyingVillagersModEntities.OBSIDIAN_SLEDGEHAMMER_PROJECTILE.get(), level);
/*     */   }
/*     */   
/*     */   public ObsidianSledgehammerProjectileEntity(EntityType<ObsidianSledgehammerProjectileEntity> entitytype, Level level) {
/* 108 */     super(entitytype, level);
/* 109 */     m_274367_(0.6F);
/* 110 */     this.f_21364_ = 0;
/* 111 */     m_21557_(false);
/* 112 */     m_21530_();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 117 */     super.m_7380_(tag);
/* 118 */     if (this.posToAim != null) {
/* 119 */       tag.m_128347_("AimX", this.posToAim.f_82479_);
/* 120 */       tag.m_128347_("AimY", this.posToAim.f_82480_);
/* 121 */       tag.m_128347_("AimZ", this.posToAim.f_82481_);
/*     */     } 
/* 123 */     tag.m_128379_("ShouldStun", this.shouldStun);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 128 */     super.m_7378_(tag);
/* 129 */     if (tag.m_128441_("AimX") && tag.m_128441_("AimY") && tag.m_128441_("AimZ")) {
/* 130 */       this.posToAim = new Vec3(tag.m_128459_("AimX"), tag.m_128459_("AimY"), tag.m_128459_("AimZ"));
/*     */     } else {
/* 132 */       this.posToAim = null;
/*     */     } 
/* 134 */     this.motionInited = false;
/* 135 */     this.shouldStun = tag.m_128471_("ShouldStun");
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 139 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/* 143 */     super.m_8099_();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 147 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 151 */     return false;
/*     */   }
/*     */   
/*     */   public boolean m_6469_(DamageSource damagesource, float f) {
/* 155 */     return (!damagesource.m_276093_(DamageTypes.f_268631_) && 
/* 156 */       !(damagesource.m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow) && 
/* 157 */       !(damagesource.m_7640_() instanceof Player) && 
/* 158 */       !(damagesource.m_7640_() instanceof net.minecraft.world.entity.projectile.ThrownPotion) && 
/* 159 */       !(damagesource.m_7640_() instanceof net.minecraft.world.entity.AreaEffectCloud) && 
/* 160 */       !damagesource.m_276093_(DamageTypes.f_268671_) && 
/* 161 */       !damagesource.m_276093_(DamageTypes.f_268585_) && 
/* 162 */       !damagesource.m_276093_(DamageTypes.f_268722_) && 
/* 163 */       !damagesource.m_276093_(DamageTypes.f_268450_) && 
/* 164 */       !damagesource.m_276093_(DamageTypes.f_268565_) && 
/* 165 */       !damagesource.m_276093_(DamageTypes.f_268448_) && 
/* 166 */       !damagesource.m_276093_(DamageTypes.f_268714_) && 
/* 167 */       !damagesource.m_276093_(DamageTypes.f_268526_) && 
/* 168 */       !damagesource.m_276093_(DamageTypes.f_268482_) && 
/* 169 */       !damagesource.m_276093_(DamageTypes.f_268493_) && 
/* 170 */       !damagesource.m_276093_(DamageTypes.f_268641_) && super
/* 171 */       .m_6469_(damagesource, f));
/*     */   }
/*     */   
/*     */   public boolean m_6128_() {
/* 175 */     return true;
/*     */   }
/*     */   
/*     */   public boolean m_5825_() {
/* 179 */     return true;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor pLevel, @NotNull DifficultyInstance pDifficulty, @NotNull MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
/* 184 */     m_20331_(true);
/* 185 */     m_5496_((SoundEvent)AnnoyingVillagersModSounds.MUFFLED_BOOM.get(), (new Random()).nextFloat(34.0F, 42.0F), (new Random()).nextFloat(0.0F, 0.2F));
/* 186 */     return super.m_6518_(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
/*     */   }
/*     */   
/*     */   private boolean shouldEnableMeteoriteTrail() {
/* 190 */     if (this.owner == null) return true;
/*     */     
/* 192 */     double deltaX = m_20185_() - this.owner.m_20185_();
/* 193 */     double deltaZ = m_20189_() - this.owner.m_20189_();
/* 194 */     return (deltaX * deltaX + deltaZ * deltaZ >= 4.0D);
/*     */   }
/*     */   @Nullable
/*     */   private EntityHitResult findEntityHit(ServerLevel serverLevel, Vec3 start, Vec3 end) {
/* 198 */     Vec3 motion = end.m_82546_(start);
/* 199 */     AABB inflate = m_20191_().m_82369_(motion).m_82400_(0.3D);
/*     */     
/* 201 */     return ProjectileUtil.m_37304_((Level)serverLevel, (Entity)this, start, end, inflate, e -> {
/*     */           // Byte code:
/*     */           //   0: aload_1
/*     */           //   1: instanceof net/minecraft/world/entity/LivingEntity
/*     */           //   4: ifeq -> 43
/*     */           //   7: aload_1
/*     */           //   8: checkcast net/minecraft/world/entity/LivingEntity
/*     */           //   11: astore_2
/*     */           //   12: aload_2
/*     */           //   13: invokevirtual m_6084_ : ()Z
/*     */           //   16: ifeq -> 43
/*     */           //   19: aload_2
/*     */           //   20: aload_0
/*     */           //   21: if_acmpeq -> 43
/*     */           //   24: aload_2
/*     */           //   25: aload_0
/*     */           //   26: getfield owner : Lnet/minecraft/world/entity/LivingEntity;
/*     */           //   29: if_acmpeq -> 43
/*     */           //   32: aload_2
/*     */           //   33: instanceof com/pla/annoyingvillagers/entity/DragonMeteoriteEntity
/*     */           //   36: ifne -> 43
/*     */           //   39: iconst_1
/*     */           //   40: goto -> 44
/*     */           //   43: iconst_0
/*     */           //   44: ireturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #211	-> 0
/*     */           //   #207	-> 7
/*     */           //   #208	-> 13
/*     */           //   #211	-> 44
/*     */           // Local variable table:
/*     */           //   start	length	slot	name	descriptor
/*     */           //   12	31	2	livingEntity	Lnet/minecraft/world/entity/LivingEntity;
/*     */           //   0	45	0	this	Lcom/pla/annoyingvillagers/entity/ObsidianSledgehammerProjectileEntity;
/*     */           //   0	45	1	e	Lnet/minecraft/world/entity/Entity;
/*     */         });
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
/*     */   private void explode(ServerLevel serverLevel, double d0, double d1, double d2) {
/* 216 */     serverLevel.m_254849_(null, d0, d1, d2, (new Random()).nextFloat(2.0F, 4.0F), Level.ExplosionInteraction.NONE);
/* 217 */     ScreenShakeUtil.applyScreenShake(serverLevel, m_20182_(), 24.0D, 20, 6);
/*     */ 
/*     */ 
/*     */     
/* 221 */     BlockState cryingObsidianBlock = (BlockState)((Block)AnnoyingVillagersModBlocks.CRYING_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)CryingObsidianBlock.FROM_PLAYER, Boolean.valueOf(getOwner() instanceof Player));
/*     */     
/* 223 */     FallingBlockEntity falling = FallingBlockEntity.m_201971_((Level)serverLevel, BlockPos.m_274561_(d0, d1, d2), cryingObsidianBlock);
/* 224 */     LivingEntity livingEntity = getOwner();
/* 225 */     if (livingEntity != null) {
/* 226 */       CompoundTag tileData = new CompoundTag();
/* 227 */       tileData.m_128362_("Owner", livingEntity.m_20148_());
/* 228 */       falling.f_31944_ = tileData;
/*     */     } 
/* 230 */     serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123812_, d0, d1, d2, 1, 0.0D, 0.0D, 0.0D, 0.0D);
/*     */     
/* 232 */     Vec3 center = new Vec3(d0, d1, d2);
/* 233 */     AABB box = (new AABB(center, center)).m_82400_(10.0D);
/*     */     
/* 235 */     Registry<DamageType> damageTypeReg = serverLevel.m_9598_().m_175515_(Registries.f_268580_);
/* 236 */     DamageSource damageSource = new DamageSource((Holder)damageTypeReg.m_246971_(DamageTypes.f_268565_), (Entity)this);
/*     */     
/* 238 */     for (LivingEntity entity : serverLevel.m_6443_(LivingEntity.class, box, livingEntity -> 
/* 239 */         (livingEntity.m_6084_() && !(livingEntity instanceof DragonMeteoriteEntity) && !(livingEntity instanceof HerobrineDragonEntity) && livingEntity != getOwner()))) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 244 */       Vec3 dir = entity.m_20182_().m_82546_(center);
/* 245 */       double dist = Math.max(0.001D, dir.m_82553_());
/* 246 */       double falloff = 1.0D - Math.min(dist / 10.0D, 1.0D);
/*     */ 
/*     */ 
/*     */       
/* 250 */       Vec3 push = dir.m_82490_(1.0D / dist).m_82490_(1.2D * falloff).m_82520_(0.0D, 0.35D * falloff, 0.0D);
/*     */       
/* 252 */       entity.m_20256_(entity.m_20184_().m_82549_(push));
/* 253 */       float damage = this.shouldStun ? 8.0F : 4.0F;
/* 254 */       if (this.owner != null) {
/* 255 */         entity.m_6469_(m_269291_().m_269104_((Entity)this, (Entity)this.owner), damage);
/*     */       } else {
/* 257 */         entity.m_6469_(damageSource, damage);
/*     */       } 
/* 259 */       entity.f_19812_ = true;
/* 260 */       if (this.shouldStun) {
/* 261 */         LivingEntityPatch<?> patch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)entity, LivingEntityPatch.class);
/* 262 */         if (patch != null) {
/* 263 */           patch.applyStun(StunType.LONG, 20.0F);
/*     */         }
/*     */       } 
/* 266 */       increaseSkillPoint((Entity)getOwner(), 5.0F);
/*     */     } 
/*     */     
/* 269 */     m_5496_(SoundEvents.f_11913_, 5.0F, 0.0F);
/* 270 */     m_5496_(SoundEvents.f_11935_, 6.0F, 0.0F);
/* 271 */     m_5496_(SoundEvents.f_12090_, 10.0F, 0.0F);
/* 272 */     m_146870_();
/*     */   }
/*     */   
/*     */   public void m_6075_() {
/* 276 */     super.m_6075_();
/* 277 */     Level level = m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/* 278 */       final double d0 = m_20185_();
/* 279 */       final double d1 = m_20186_();
/* 280 */       final double d2 = m_20189_();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 286 */       m_20331_(true);
/* 287 */       if (!this.motionInited) {
/* 288 */         if (this.posToAim != null) {
/* 289 */           Vec3 from = m_20182_();
/* 290 */           Vec3 dir = this.posToAim.m_82546_(from);
/*     */           
/* 292 */           double dist = dir.m_82553_();
/* 293 */           if (dist > 1.0E-4D) {
/* 294 */             double speed = 1.8D;
/*     */             
/* 296 */             Vec3 vel = dir.m_82490_(speed / dist);
/* 297 */             this.xd = vel.f_82479_;
/* 298 */             this.yd = vel.f_82480_;
/* 299 */             this.zd = vel.f_82481_;
/*     */           } else {
/* 301 */             this.xd = this.yd = this.zd = 0.0D;
/*     */           } 
/*     */         } else {
/* 304 */           RandomSource r = serverLevel.m_213780_();
/* 305 */           this.xd = Mth.m_216263_(r, -0.7D, 0.7D);
/* 306 */           this.yd = -1.8D;
/* 307 */           this.zd = Mth.m_216263_(r, -0.7D, 0.7D);
/*     */         } 
/* 309 */         this.motionInited = true;
/*     */       } 
/*     */       
/* 312 */       Vec3 start = m_20182_();
/* 313 */       Vec3 end = start.m_82520_(this.xd, this.yd, this.zd);
/*     */       
/* 315 */       EntityHitResult entityHitResult = findEntityHit(serverLevel, start, end);
/* 316 */       if (entityHitResult != null) {
/* 317 */         Vec3 hitPos = entityHitResult.m_82450_();
/* 318 */         m_6034_(hitPos.f_82479_, hitPos.f_82480_, hitPos.f_82481_);
/* 319 */         explode(serverLevel, hitPos.f_82479_, hitPos.f_82480_, hitPos.f_82481_);
/*     */         
/*     */         return;
/*     */       } 
/* 323 */       if (m_20096_() || m_5830_() || (this.posToAim != null && m_20182_().m_82557_(this.posToAim) < 1.0D)) {
/* 324 */         explode(serverLevel, d0, d1, d2);
/*     */       }
/*     */       
/* 327 */       m_20242_(true);
/* 328 */       m_20334_(this.xd, this.yd, this.zd);
/* 329 */       this.f_19812_ = true;
/*     */       
/* 331 */       if (this.posToAim != null) {
/* 332 */         Vec3 fromEye = m_146892_();
/* 333 */         Vec3 toEye = this.posToAim;
/*     */         
/* 335 */         double dx = toEye.f_82479_ - fromEye.f_82479_;
/* 336 */         double dz = toEye.f_82481_ - fromEye.f_82481_;
/* 337 */         double dy = toEye.f_82480_ - fromEye.f_82480_;
/* 338 */         double distXZ = Math.sqrt(dx * dx + dz * dz);
/*     */         
/* 340 */         float yaw = (float)(Mth.m_14136_(dz, dx) * 57.29577951308232D) - 90.0F;
/* 341 */         float pitch = (float)-(Mth.m_14136_(dy, distXZ) * 57.29577951308232D);
/*     */         
/* 343 */         m_146922_(yaw);
/* 344 */         m_5616_(yaw);
/* 345 */         m_5618_(yaw);
/* 346 */         m_146926_(pitch);
/*     */       } 
/*     */       
/* 349 */       double d3 = -5.0D; int i;
/* 350 */       for (i = 0; i < 10; i++) {
/* 351 */         double d4 = -5.0D;
/*     */         
/* 353 */         for (int j = 0; j < 10; j++) {
/* 354 */           double d5 = -5.0D;
/*     */           
/* 356 */           for (int k = 0; k < 10; k++) {
/* 357 */             if (serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60800_((BlockGetter)serverLevel, BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)) < 0.4D && serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60800_((BlockGetter)serverLevel, BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)) >= 0.0F) {
/* 358 */               serverLevel.m_46961_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), false);
/* 359 */               serverLevel.m_46672_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60734_());
/* 360 */               serverLevel.m_186460_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60734_(), 1);
/*     */             } 
/*     */             
/* 363 */             if (serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_204336_(BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "logs")))) {
/* 364 */               serverLevel.m_46961_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), false);
/* 365 */               serverLevel.m_46672_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60734_());
/* 366 */               serverLevel.m_186460_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60734_(), 1);
/*     */             } 
/* 368 */             d5++;
/*     */           } 
/* 370 */           d4++;
/*     */         } 
/* 372 */         d3++;
/*     */       } 
/*     */       
/* 375 */       if (this.shouldStun) {
/* 376 */         HerobrineUtil.spawnEliteEffect(m_9236_(), m_20185_(), m_20186_(), m_20189_(), (Entity)this);
/*     */       }
/*     */       
/* 379 */       if (m_20072_()) {
/* 380 */         for (i = 0; i < 10; i++) {
/* 381 */           serverLevel.m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.BIG_SPLASH.get(), d0 + Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), d1 + 2.0D, d2 + Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), 0.0D, 1.0D, 0.0D);
/*     */         }
/*     */       }
/*     */       
/* 385 */       if (!m_20072_()) {
/* 386 */         final ObsidianSledgehammerProjectileEntity entity = this;
/* 387 */         new DelayedTask(2)
/*     */           {
/*     */             public void run() {
/* 390 */               if (entity.m_20072_()) {
/* 391 */                 serverLevel.m_5594_(null, BlockPos.m_274561_(d0, d1, d2), SoundEvents.f_12278_, SoundSource.NEUTRAL, 6.0F, 0.0F);
/*     */               }
/*     */             }
/*     */           };
/*     */       } 
/*     */       
/* 397 */       if (!this.meteoriteTrailEnabled && shouldEnableMeteoriteTrail()) {
/* 398 */         this.meteoriteTrailEnabled = true;
/*     */       }
/*     */       
/* 401 */       if (this.meteoriteTrailEnabled) {
/* 402 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.METEORITE_TRAIL
/* 403 */             .get(), d0, d1 + 0.5D, d2, 0, 0.0D, 0.01D, 0.0D, 0.0D);
/*     */       } }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void increaseSkillPoint(Entity entity, float value) {
/*     */     Player player;
/*     */     ServerPlayerPatch serverPlayerPatch;
/* 414 */     if (entity instanceof Player) { player = (Player)entity; }
/*     */     else { return; }
/* 416 */      PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 417 */     if (playerPatch instanceof ServerPlayerPatch) { serverPlayerPatch = (ServerPlayerPatch)playerPatch; }
/*     */     else { return; }
/* 419 */      SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.OBSIDIAN_SLEDGEHAMMER);
/* 420 */     if (skillContainer == null)
/*     */       return; 
/* 422 */     ObsidianSledgeHammerSkill skill = (ObsidianSledgeHammerSkill)skillContainer.getSkill();
/*     */     
/* 424 */     float currentResource = skillContainer.getResource();
/* 425 */     float neededResource = skillContainer.getNeededResource();
/* 426 */     float addResource = Math.min(value, neededResource);
/*     */     
/* 428 */     skill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*     */   }
/*     */   
/*     */   public static void init() {}
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 434 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 436 */     builder = builder.m_22268_(Attributes.f_22279_, 0.3D);
/* 437 */     builder = builder.m_22268_(Attributes.f_22276_, 10.0D);
/* 438 */     builder = builder.m_22268_(Attributes.f_22284_, 0.0D);
/* 439 */     builder = builder.m_22268_(Attributes.f_22281_, 3.0D);
/* 440 */     builder = builder.m_22268_(Attributes.f_22277_, 200.0D);
/* 441 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ObsidianSledgehammerProjectileEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */