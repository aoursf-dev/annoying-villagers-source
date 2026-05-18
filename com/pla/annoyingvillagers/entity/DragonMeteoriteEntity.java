/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.block.EndFireBlock;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
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
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DragonMeteoriteEntity
/*     */   extends PathfinderMob
/*     */ {
/*     */   private Vec3 posToAim;
/*     */   private HerobrineDragonEntity owner;
/*     */   private boolean motionInited = false;
/*  66 */   private double xd = 0.0D;
/*  67 */   private double yd = 0.0D;
/*  68 */   private double zd = 0.0D;
/*     */   
/*     */   public void setPosToAim(@Nullable Vec3 pos) {
/*  71 */     this.posToAim = pos;
/*  72 */     this.motionInited = false;
/*     */   }
/*     */   
/*     */   public HerobrineDragonEntity getOwner() {
/*  76 */     return this.owner;
/*     */   }
/*     */   
/*     */   public void setOwner(HerobrineDragonEntity owner) {
/*  80 */     this.owner = owner;
/*     */   }
/*     */   
/*     */   public DragonMeteoriteEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  84 */     this((EntityType<DragonMeteoriteEntity>)AnnoyingVillagersModEntities.DRAGON_METEORITE.get(), level);
/*     */   }
/*     */   
/*     */   public DragonMeteoriteEntity(EntityType<DragonMeteoriteEntity> entitytype, Level level) {
/*  88 */     super(entitytype, level);
/*  89 */     m_274367_(0.6F);
/*  90 */     this.f_21364_ = 0;
/*  91 */     m_21557_(false);
/*  92 */     m_21530_();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/*  97 */     super.m_7380_(tag);
/*  98 */     if (this.posToAim != null) {
/*  99 */       tag.m_128347_("AimX", this.posToAim.f_82479_);
/* 100 */       tag.m_128347_("AimY", this.posToAim.f_82480_);
/* 101 */       tag.m_128347_("AimZ", this.posToAim.f_82481_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 107 */     super.m_7378_(tag);
/* 108 */     if (tag.m_128441_("AimX") && tag.m_128441_("AimY") && tag.m_128441_("AimZ")) {
/* 109 */       this.posToAim = new Vec3(tag.m_128459_("AimX"), tag.m_128459_("AimY"), tag.m_128459_("AimZ"));
/*     */     } else {
/* 111 */       this.posToAim = null;
/*     */     } 
/* 113 */     this.motionInited = false;
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 117 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/* 121 */     super.m_8099_();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 125 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 129 */     return false;
/*     */   }
/*     */   
/*     */   public boolean m_6469_(DamageSource damagesource, float f) {
/* 133 */     return (!damagesource.m_276093_(DamageTypes.f_268631_) && 
/* 134 */       !(damagesource.m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow) && 
/* 135 */       !(damagesource.m_7640_() instanceof net.minecraft.world.entity.player.Player) && 
/* 136 */       !(damagesource.m_7640_() instanceof net.minecraft.world.entity.projectile.ThrownPotion) && 
/* 137 */       !(damagesource.m_7640_() instanceof net.minecraft.world.entity.AreaEffectCloud) && 
/* 138 */       !damagesource.m_276093_(DamageTypes.f_268671_) && 
/* 139 */       !damagesource.m_276093_(DamageTypes.f_268585_) && 
/* 140 */       !damagesource.m_276093_(DamageTypes.f_268722_) && 
/* 141 */       !damagesource.m_276093_(DamageTypes.f_268450_) && 
/* 142 */       !damagesource.m_276093_(DamageTypes.f_268565_) && 
/* 143 */       !damagesource.m_276093_(DamageTypes.f_268448_) && 
/* 144 */       !damagesource.m_276093_(DamageTypes.f_268714_) && 
/* 145 */       !damagesource.m_276093_(DamageTypes.f_268526_) && 
/* 146 */       !damagesource.m_276093_(DamageTypes.f_268482_) && 
/* 147 */       !damagesource.m_276093_(DamageTypes.f_268493_) && 
/* 148 */       !damagesource.m_276093_(DamageTypes.f_268641_) && super
/* 149 */       .m_6469_(damagesource, f));
/*     */   }
/*     */   
/*     */   public boolean m_6128_() {
/* 153 */     return true;
/*     */   }
/*     */   
/*     */   public boolean m_5825_() {
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor pLevel, @NotNull DifficultyInstance pDifficulty, @NotNull MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
/* 162 */     m_20331_(true);
/* 163 */     m_5496_((SoundEvent)AnnoyingVillagersModSounds.MUFFLED_BOOM.get(), (new Random()).nextFloat(34.0F, 42.0F), (new Random()).nextFloat(0.0F, 0.2F));
/* 164 */     return super.m_6518_(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
/*     */   }
/*     */   
/*     */   public void m_6075_() {
/* 168 */     super.m_6075_();
/* 169 */     Level level = m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/* 170 */       final double d0 = m_20185_();
/* 171 */       final double d1 = m_20186_();
/* 172 */       final double d2 = m_20189_();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       m_20331_(true);
/* 179 */       if (!this.motionInited) {
/* 180 */         if (this.posToAim != null) {
/* 181 */           Vec3 from = m_20182_();
/* 182 */           Vec3 dir = this.posToAim.m_82546_(from);
/*     */           
/* 184 */           double dist = dir.m_82553_();
/* 185 */           if (dist > 1.0E-4D) {
/*     */             
/* 187 */             double speed = 1.8D;
/*     */             
/* 189 */             Vec3 vel = dir.m_82490_(speed / dist);
/* 190 */             this.xd = vel.f_82479_;
/* 191 */             this.yd = vel.f_82480_;
/* 192 */             this.zd = vel.f_82481_;
/*     */           } else {
/* 194 */             this.xd = this.yd = this.zd = 0.0D;
/*     */           } 
/*     */         } else {
/* 197 */           RandomSource r = serverLevel.m_213780_();
/* 198 */           this.xd = Mth.m_216263_(r, -0.7D, 0.7D);
/* 199 */           this.yd = -1.8D;
/* 200 */           this.zd = Mth.m_216263_(r, -0.7D, 0.7D);
/*     */         } 
/* 202 */         this.motionInited = true;
/*     */       } 
/*     */       
/* 205 */       if (m_20096_() || m_5830_() || (this.posToAim != null && m_20182_().m_82557_(this.posToAim) < 1.0D)) {
/* 206 */         serverLevel.m_254849_(null, d0, d1, d2, (new Random()).nextFloat(2.0F, 4.0F), Level.ExplosionInteraction.MOB);
/* 207 */         ScreenShakeUtil.applyScreenShake(serverLevel, m_20182_(), 24.0D, 20, 6);
/*     */         
/* 209 */         RandomSource randomSource = serverLevel.m_213780_();
/* 210 */         BlockState endfireState = ((EndFireBlock)AnnoyingVillagersModBlocks.END_FIRE.get()).m_49966_();
/*     */         
/* 212 */         for (int j = 0; j < 25; j++) {
/* 213 */           BlockPos pos = BlockPos.m_274561_(d0, d1, d2);
/* 214 */           serverLevel.m_7731_(pos, endfireState, 3);
/* 215 */           FallingBlockEntity fallingBlockEntity = FallingBlockEntity.m_201971_((Level)serverLevel, pos, endfireState);
/* 216 */           fallingBlockEntity.f_31942_ = 1;
/* 217 */           fallingBlockEntity.f_31943_ = false;
/*     */           
/* 219 */           double vx = Mth.m_216263_(randomSource, -0.15D, 0.15D);
/* 220 */           double vy = Mth.m_216263_(randomSource, 0.2D, 0.5D);
/* 221 */           double vz = Mth.m_216263_(randomSource, -0.15D, 0.15D);
/*     */           
/* 223 */           fallingBlockEntity.m_20334_(vx, vy, vz);
/* 224 */           fallingBlockEntity.f_19812_ = true;
/*     */         } 
/*     */         
/* 227 */         FallingBlockEntity.m_201971_((Level)serverLevel, BlockPos.m_274561_(d0, d1, d2), Blocks.f_50723_.m_49966_());
/* 228 */         serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123812_, d0, d1, d2, 1, 0.0D, 0.0D, 0.0D, 0.0D);
/*     */         
/* 230 */         Vec3 center = new Vec3(d0, d1, d2);
/* 231 */         AABB box = (new AABB(center, center)).m_82400_(10.0D);
/*     */         
/* 233 */         Registry<DamageType> damageTypeReg = serverLevel.m_9598_().m_175515_(Registries.f_268580_);
/* 234 */         DamageSource damageSource = new DamageSource((Holder)damageTypeReg.m_246971_(DamageTypes.f_268565_), (Entity)this);
/*     */         
/* 236 */         for (LivingEntity entity : serverLevel.m_6443_(LivingEntity.class, box, livingEntity -> 
/* 237 */             (livingEntity.m_6084_() && !(livingEntity instanceof DragonMeteoriteEntity) && !(livingEntity instanceof HerobrineDragonEntity) && livingEntity != getOwner().getSummoner()))) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 242 */           Vec3 dir = entity.m_20182_().m_82546_(center);
/* 243 */           double dist = Math.max(0.001D, dir.m_82553_());
/* 244 */           double falloff = 1.0D - Math.min(dist / 10.0D, 1.0D);
/*     */ 
/*     */ 
/*     */           
/* 248 */           Vec3 push = dir.m_82490_(1.0D / dist).m_82490_(1.2D * falloff).m_82520_(0.0D, 0.35D * falloff, 0.0D);
/*     */           
/* 250 */           entity.m_20256_(entity.m_20184_().m_82549_(push));
/* 251 */           if (this.owner != null && this.owner.getSummoner() != null) {
/* 252 */             entity.m_6469_(m_269291_().m_269104_((Entity)this, (Entity)this.owner.getSummoner()), 12.0F);
/*     */           } else {
/* 254 */             entity.m_6469_(damageSource, 12.0F);
/*     */           } 
/* 256 */           entity.f_19812_ = true;
/*     */         } 
/*     */         
/* 259 */         m_5496_(SoundEvents.f_11913_, 5.0F, 0.0F);
/* 260 */         m_5496_(SoundEvents.f_11935_, 6.0F, 0.0F);
/* 261 */         m_5496_(SoundEvents.f_12090_, 10.0F, 0.0F);
/* 262 */         m_146870_();
/*     */       } 
/*     */       
/* 265 */       m_20242_(true);
/* 266 */       m_20334_(this.xd, this.yd, this.zd);
/* 267 */       this.f_19812_ = true;
/*     */       
/* 269 */       if (this.posToAim != null) {
/* 270 */         Vec3 fromEye = m_146892_();
/* 271 */         Vec3 toEye = this.posToAim;
/*     */         
/* 273 */         double dx = toEye.f_82479_ - fromEye.f_82479_;
/* 274 */         double dz = toEye.f_82481_ - fromEye.f_82481_;
/* 275 */         double dy = toEye.f_82480_ - fromEye.f_82480_;
/* 276 */         double distXZ = Math.sqrt(dx * dx + dz * dz);
/*     */         
/* 278 */         float yaw = (float)(Mth.m_14136_(dz, dx) * 57.29577951308232D) - 90.0F;
/* 279 */         float pitch = (float)-(Mth.m_14136_(dy, distXZ) * 57.29577951308232D);
/*     */         
/* 281 */         m_146922_(yaw);
/* 282 */         m_5616_(yaw);
/* 283 */         m_5618_(yaw);
/* 284 */         m_146926_(pitch);
/*     */       } 
/*     */       
/* 287 */       double d3 = -5.0D; int i;
/* 288 */       for (i = 0; i < 10; i++) {
/* 289 */         double d4 = -5.0D;
/*     */         
/* 291 */         for (int j = 0; j < 10; j++) {
/* 292 */           double d5 = -5.0D;
/*     */           
/* 294 */           for (int k = 0; k < 10; k++) {
/* 295 */             if (serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60800_((BlockGetter)serverLevel, BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)) < 0.4D && serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60800_((BlockGetter)serverLevel, BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)) >= 0.0F) {
/* 296 */               serverLevel.m_46961_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), false);
/* 297 */               serverLevel.m_46672_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60734_());
/* 298 */               serverLevel.m_186460_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60734_(), 1);
/*     */             } 
/*     */             
/* 301 */             if (serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_204336_(BlockTags.create(ResourceLocation.fromNamespaceAndPath("minecraft", "logs")))) {
/* 302 */               serverLevel.m_46961_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), false);
/* 303 */               serverLevel.m_46672_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60734_());
/* 304 */               serverLevel.m_186460_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5), serverLevel.m_8055_(BlockPos.m_274561_(d0 + d3, d1 + d4, d2 + d5)).m_60734_(), 1);
/*     */             } 
/* 306 */             d5++;
/*     */           } 
/* 308 */           d4++;
/*     */         } 
/* 310 */         d3++;
/*     */       } 
/*     */       
/* 313 */       if (m_20072_()) {
/* 314 */         for (i = 0; i < 10; i++) {
/* 315 */           serverLevel.m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.BIG_SPLASH.get(), d0 + Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), d1 + 2.0D, d2 + Mth.m_216263_(RandomSource.m_216327_(), -1.0D, 1.0D), 0.0D, 1.0D, 0.0D);
/*     */         }
/*     */       }
/*     */       
/* 319 */       if (!m_20072_()) {
/* 320 */         final DragonMeteoriteEntity entity = this;
/* 321 */         new DelayedTask(2)
/*     */           {
/*     */             public void run() {
/* 324 */               if (entity.m_20072_()) {
/* 325 */                 serverLevel.m_5594_(null, BlockPos.m_274561_(d0, d1, d2), SoundEvents.f_12278_, SoundSource.NEUTRAL, 6.0F, 0.0F);
/*     */               }
/*     */             }
/*     */           };
/*     */       } 
/*     */       
/* 331 */       serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123813_, d0, d1 + 0.5D, d2, 0, 0.0D, 1.0D, 0.0D, 0.0D);
/* 332 */       serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123747_, d0, d1 + 0.5D, d2, 0, 0.0D, 1.0D, 0.0D, 0.0D);
/* 333 */       serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.METEORITE_TRAIL.get(), d0, d1 + 0.5D, d2, 0, 0.0D, 0.01D, 0.0D, 0.0D);
/*     */       
/* 335 */       for (i = 0; i < 20; i++) {
/* 336 */         serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123777_, d0 + 
/*     */             
/* 338 */             Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), d1 + 
/* 339 */             Mth.m_216263_(RandomSource.m_216327_(), -1.5D, 2.5D), d2 + 
/* 340 */             Mth.m_216263_(RandomSource.m_216327_(), -2.0D, 2.0D), 0, 0.0D, 0.01D, 0.0D, 0.0D);
/*     */       } }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public static void init() {}
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 349 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 351 */     builder = builder.m_22268_(Attributes.f_22279_, 0.3D);
/* 352 */     builder = builder.m_22268_(Attributes.f_22276_, 10.0D);
/* 353 */     builder = builder.m_22268_(Attributes.f_22284_, 0.0D);
/* 354 */     builder = builder.m_22268_(Attributes.f_22281_, 3.0D);
/* 355 */     builder = builder.m_22268_(Attributes.f_22277_, 200.0D);
/* 356 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\DragonMeteoriteEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */