/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.network.ClientboundLitePortalFx;
/*     */ import com.pla.annoyingvillagers.spawnhandler.HerobrineMobData;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*     */ import com.pla.annoyingvillagers.util.CommonGoals;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.PacketDistributor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import se.gory_moon.player_mobs.utils.NameManager;
/*     */ import yesman.epicfight.api.animation.Joint;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*     */ import yesman.epicfight.api.utils.math.Vec3f;
/*     */ import yesman.epicfight.gameasset.Armatures;
/*     */ import yesman.epicfight.model.armature.HumanoidArmature;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*     */ 
/*     */ public class LowShadowHerobrineCloneEntity extends Monster {
/*     */   private boolean summoned = false;
/*     */   private boolean initialSpawn = true;
/*     */   private EliteHerobrineKnockedEntity protectEntity;
/*     */   private UUID protectUUID;
/*     */   private boolean autoKill = false;
/*  79 */   private final LivingEntityPatch<?> livingentitypatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class); private HerobrineMob possessedByEntity; private UUID possessedByUuid; private boolean bound = false; private boolean sacrificing = false; private boolean healing = false; private boolean forEscaping = false;
/*     */   
/*     */   public boolean isHealing() {
/*  82 */     return this.healing;
/*     */   }
/*     */   
/*     */   public boolean isSacrificing() {
/*  86 */     return this.sacrificing;
/*     */   }
/*     */   
/*     */   public void setForEscaping(boolean forEscaping) {
/*  90 */     this.forEscaping = forEscaping;
/*     */   }
/*     */   
/*     */   public HerobrineMob getPossessedByEntity() {
/*  94 */     return this.possessedByEntity;
/*     */   }
/*     */   
/*     */   public void setProtectUUID(UUID protectUUID) {
/*  98 */     this.protectUUID = protectUUID;
/*     */   }
/*     */   
/*     */   public void setProtectEntity(EliteHerobrineKnockedEntity protectEntity) {
/* 102 */     this.protectEntity = protectEntity;
/*     */   }
/*     */   
/*     */   public void setAutoKill(boolean autoKill) {
/* 106 */     this.autoKill = autoKill;
/*     */   }
/*     */   
/*     */   public void setPossessedByUuid(UUID possessedByUuid) {
/* 110 */     this.possessedByUuid = possessedByUuid;
/*     */   }
/*     */   
/*     */   public void setPossessedByEntity(HerobrineMob possessedByEntity) {
/* 114 */     this.possessedByEntity = possessedByEntity;
/*     */   }
/*     */   
/*     */   public void setSacrificing(boolean sacrificing) {
/* 118 */     this.sacrificing = sacrificing;
/*     */   }
/*     */   
/*     */   public void setHealing(boolean healing) {
/* 122 */     this.healing = healing;
/*     */   }
/*     */   
/*     */   public boolean isSummoned() {
/* 126 */     return this.summoned;
/*     */   }
/*     */   
/*     */   public void setSummoned(boolean summoned) {
/* 130 */     this.summoned = summoned;
/*     */   }
/*     */   
/*     */   boolean renderPortal = false;
/*     */   
/*     */   public void setRenderPortal(boolean renderPortal) {
/* 136 */     this.renderPortal = renderPortal;
/*     */   }
/*     */   
/*     */   public void setInitialSpawn(boolean initialSpawn) {
/* 140 */     this.initialSpawn = initialSpawn;
/*     */   }
/*     */   
/*     */   public LowShadowHerobrineCloneEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/* 144 */     this((EntityType<LowShadowHerobrineCloneEntity>)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), level);
/*     */   }
/*     */   
/*     */   public LowShadowHerobrineCloneEntity(EntityType<LowShadowHerobrineCloneEntity> entitytype, Level level) {
/* 148 */     super(entitytype, level);
/* 149 */     m_274367_(2.0F);
/* 150 */     this.f_21364_ = 50;
/* 151 */     m_21557_(false);
/* 152 */     m_20340_(false);
/* 153 */     m_21530_();
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 157 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/* 161 */     super.m_8099_();
/* 162 */     this.f_21345_.m_25352_(1, new Goal()
/*     */         {
/*     */           public boolean m_8036_() {
/* 165 */             return (LowShadowHerobrineCloneEntity.this.protectEntity != null && LowShadowHerobrineCloneEntity.this.protectEntity.m_6084_() && LowShadowHerobrineCloneEntity.this.m_20270_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity) > 9.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           public void m_8037_() {
/* 170 */             if (LowShadowHerobrineCloneEntity.this.protectEntity != null && LowShadowHerobrineCloneEntity.this.protectEntity.m_6084_()) {
/* 171 */               LowShadowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity, 2.0D);
/* 172 */               LowShadowHerobrineCloneEntity.this.m_21563_().m_24960_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity, 30.0F, 30.0F);
/* 173 */               if (LowShadowHerobrineCloneEntity.this.m_20280_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity) > 10.0D) {
/* 174 */                 if (LowShadowHerobrineCloneEntity.this.m_21573_().m_26571_()) {
/* 175 */                   LowShadowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity, 2.0D);
/*     */                 }
/*     */               } else {
/* 178 */                 LowShadowHerobrineCloneEntity.this.m_21573_().m_26573_();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean m_8045_() {
/* 185 */             return (LowShadowHerobrineCloneEntity.this.protectEntity != null && LowShadowHerobrineCloneEntity.this.protectEntity.m_6084_() && LowShadowHerobrineCloneEntity.this.m_20270_((Entity)LowShadowHerobrineCloneEntity.this.protectEntity) > 50.0D);
/*     */           }
/*     */         });
/* 188 */     this.f_21345_.m_25352_(1, new Goal()
/*     */         {
/*     */           public boolean m_8036_() {
/* 191 */             return (LowShadowHerobrineCloneEntity.this.possessedByEntity != null && LowShadowHerobrineCloneEntity.this.possessedByEntity.m_6084_() && LowShadowHerobrineCloneEntity.this.m_20270_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity) > 18.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           public void m_8037_() {
/* 196 */             if (LowShadowHerobrineCloneEntity.this.possessedByEntity != null && LowShadowHerobrineCloneEntity.this.possessedByEntity.m_6084_()) {
/* 197 */               LowShadowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity, 2.0D);
/* 198 */               LowShadowHerobrineCloneEntity.this.m_21563_().m_24960_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity, 30.0F, 30.0F);
/* 199 */               if (LowShadowHerobrineCloneEntity.this.m_20280_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity) > 20.0D) {
/* 200 */                 if (LowShadowHerobrineCloneEntity.this.m_21573_().m_26571_()) {
/* 201 */                   LowShadowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity, 2.0D);
/*     */                 }
/*     */               } else {
/* 204 */                 LowShadowHerobrineCloneEntity.this.m_21573_().m_26573_();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean m_8045_() {
/* 211 */             return (LowShadowHerobrineCloneEntity.this.possessedByEntity != null && LowShadowHerobrineCloneEntity.this.possessedByEntity.m_6084_() && LowShadowHerobrineCloneEntity.this.m_20270_((Entity)LowShadowHerobrineCloneEntity.this.possessedByEntity) > 50.0D);
/*     */           }
/*     */         });
/* 214 */     CommonGoals.registerGoalForHostileNpc(this);
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 218 */     return MobType.f_21641_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 222 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 226 */     return -0.35D;
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 230 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt")));
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_5592_() {
/* 234 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death")));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_7327_(@NotNull Entity pEntity) {
/* 239 */     if (!m_9236_().m_5776_() && pEntity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)pEntity;
/* 240 */       if (getPersistentData().m_128441_("DiamondShearHit")) {
/* 241 */         int hitCount = getPersistentData().m_128451_("DiamondShearHit");
/* 242 */         m_9236_().m_5594_(null, pEntity.m_20183_(), SoundEvents.f_12344_, SoundSource.NEUTRAL, 1.0F, 1.0F);
/* 243 */         if (hitCount == 10) {
/* 244 */           livingEntity.m_21219_();
/* 245 */           getPersistentData().m_128405_("DiamondShearHit", 0);
/*     */         } else {
/* 247 */           getPersistentData().m_128405_("DiamondShearHit", hitCount + 1);
/*     */         } 
/*     */       } else {
/* 250 */         getPersistentData().m_128405_("DiamondShearHit", 1);
/*     */       }  }
/*     */     
/* 253 */     return super.m_7327_(pEntity);
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/* 257 */     if (this.sacrificing || this.healing) {
/* 258 */       if ((new Random()).nextBoolean()) {
/* 259 */         Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 260 */           EpicfightUtil.damageBlocked(damageSource, (Entity)this, serverLevel);
/* 261 */           return false; }
/*     */       
/* 263 */       }  float f1 = m_21223_();
/* 264 */       if (f1 - f <= 5.0F && (this.healing || this.sacrificing)) {
/* 265 */         this.protectEntity = null;
/* 266 */         this.protectUUID = null;
/* 267 */         this.autoKill = true;
/* 268 */         m_6074_();
/* 269 */         return false;
/*     */       } 
/* 271 */       return super.m_6469_(damageSource, f / 2.0F);
/*     */     } 
/*     */ 
/*     */     
/* 275 */     if (Math.random() <= 0.5D && 
/* 276 */       !damageSource.m_276093_(DamageTypes.f_268612_) && 
/* 277 */       !damageSource.m_276093_(DamageTypes.f_268631_) && 
/* 278 */       !damageSource.m_276093_(DamageTypes.f_268468_) && !this.forEscaping) {
/*     */       
/* 280 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 281 */         serverLevel.m_5594_(null, m_20183_(), (SoundEvent)AnnoyingVillagersModSounds.OBSIDIAN_PLACE.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/* 282 */         HerobrineUtil.spawnObsidianEyeLineStaggered(serverLevel, (Entity)this, ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_(), 1); }
/*     */     
/*     */     } 
/*     */     
/* 286 */     if (damageSource.m_276093_(DamageTypes.f_268671_)) return false; 
/* 287 */     if (damageSource.m_276093_(DamageTypes.f_268585_)) return false; 
/* 288 */     if (damageSource.m_276093_(DamageTypes.f_268493_)) return false; 
/* 289 */     if (damageSource.m_276093_(DamageTypes.f_268722_)) return false; 
/* 290 */     if (damageSource.m_276093_(DamageTypes.f_268641_)) return false; 
/* 291 */     if (damageSource.m_276093_(DamageTypes.f_268482_)) return false; 
/* 292 */     float health = m_21223_();
/* 293 */     if (health - f <= 5.0F && (this.healing || this.sacrificing || this.forEscaping)) {
/* 294 */       this.protectEntity = null;
/* 295 */       this.protectUUID = null;
/* 296 */       this.autoKill = true;
/* 297 */       this.healing = false;
/* 298 */       this.sacrificing = false;
/* 299 */       this.forEscaping = false;
/* 300 */       m_6074_();
/* 301 */       return false;
/*     */     } 
/* 303 */     return super.m_6469_(damageSource, f / 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damagesource) {
/* 308 */     super.m_6667_(damagesource);
/* 309 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 310 */       if (!this.autoKill) {
/* 311 */         InfectedPlayerNpcEntity corpse = new InfectedPlayerNpcEntity((EntityType<? extends InfectedPlayerNpcEntity>)AnnoyingVillagersModEntities.INFECTED_PLAYER_NPC.get(), (Level)serverLevel);
/* 312 */         corpse.m_7678_(m_20185_(), m_20186_(), m_20189_(), m_146908_(), m_146909_());
/* 313 */         String killedName = getPersistentData().m_128461_("killed_name");
/* 314 */         corpse.getPersistentData().m_128359_("possessed_by", "low_shadow_herobrine_clone");
/* 315 */         if (killedName.isEmpty()) {
/* 316 */           killedName = String.valueOf(NameManager.INSTANCE.getRandomName());
/*     */         }
/* 318 */         corpse.setUsername(killedName);
/* 319 */         corpse.m_6593_((Component)Component.m_237113_(killedName));
/* 320 */         corpse.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*     */         
/* 322 */         m_6842_(true);
/* 323 */         m_142687_(Entity.RemovalReason.KILLED);
/* 324 */         corpse.m_8061_(EquipmentSlot.HEAD, m_6844_(EquipmentSlot.HEAD).m_41777_());
/* 325 */         corpse.m_8061_(EquipmentSlot.CHEST, m_6844_(EquipmentSlot.CHEST).m_41777_());
/* 326 */         corpse.m_8061_(EquipmentSlot.LEGS, m_6844_(EquipmentSlot.LEGS).m_41777_());
/* 327 */         corpse.m_8061_(EquipmentSlot.FEET, m_6844_(EquipmentSlot.FEET).m_41777_());
/* 328 */         serverLevel.m_7967_((Entity)corpse);
/*     */       }
/* 330 */       else if (this.healing || this.sacrificing) {
/* 331 */         m_6074_();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 338 */       ItemStack itemstack = m_21205_();
/* 339 */       ItemEntity itemEntity = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_() + 1.0D, m_20189_(), itemstack);
/* 340 */       itemEntity.m_32010_(10);
/* 341 */       serverLevel.m_7967_((Entity)itemEntity);
/*     */       
/* 343 */       itemstack = m_21206_();
/* 344 */       itemEntity = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_() + 1.0D, m_20189_(), itemstack);
/* 345 */       itemEntity.m_32010_(10);
/* 346 */       serverLevel.m_7967_((Entity)itemEntity); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 352 */     if (mobSpawnType == MobSpawnType.NATURAL || mobSpawnType == MobSpawnType.CHUNK_GENERATION) {
/* 353 */       ServerLevel serverLevel = serverLevelAccessor.m_6018_();
/* 354 */       HerobrineMobData herobrineMobData = HerobrineMobData.get(serverLevel);
/*     */       
/* 356 */       if (!herobrineMobData.tryClaim(serverLevel, m_20148_())) {
/* 357 */         m_146870_();
/* 358 */         return null;
/*     */       } 
/*     */       
/* 361 */       BlockPos blockPos = m_20097_();
/* 362 */       int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, blockPos).m_123342_();
/* 363 */       BlockPos spawnPos = new BlockPos(blockPos.m_123341_(), surfaceY, blockPos.m_123343_());
/* 364 */       m_20035_(spawnPos, m_146908_(), m_146909_());
/*     */     } 
/* 366 */     HerobrineUtil.initialSpawn((LevelAccessor)serverLevelAccessor, (Entity)this, 0, mobSpawnType);
/* 367 */     return super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 372 */     super.m_8119_();
/* 373 */     if (!(m_9236_()).f_46443_) {
/* 374 */       if (this.f_19797_ == 1) {
/* 375 */         if (this.renderPortal) {
/* 376 */           AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY
/* 377 */               .with(() -> this), new ClientboundHerobrinePortalFx(
/* 378 */                 m_20097_().m_252807_().m_82520_(0.0D, 1.5D, 0.0D)));
/*     */           
/* 380 */           this.renderPortal = false;
/*     */         } 
/* 382 */         if (this.initialSpawn) {
/* 383 */           if (this.summoned) {
/* 384 */             m_21557_(true);
/*     */           }
/* 386 */           LivingEntityPatch<?> livingentitypatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/* 387 */           if (livingentitypatch != null && !m_9236_().m_5776_()) {
/* 388 */             livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.PLAYER_HEROBRINE_POSSESSION, 0.0F);
/*     */           }
/* 390 */           this.initialSpawn = false;
/*     */         } 
/* 392 */         if (this.forEscaping) { Level level = m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/* 393 */             m_21557_(false);
/* 394 */             final LowShadowHerobrineCloneEntity entity = this;
/* 395 */             new DelayedTask(10)
/*     */               {
/*     */                 public void run() {
/* 398 */                   HerobrineUtil.spawnObsidianPatternAtBody(serverLevel, entity, ((Block)AnnoyingVillagersModBlocks.CRYING_OBSIDIAN_BLOCK.get()).m_49966_());
/* 399 */                   entity.m_146870_();
/*     */                 }
/*     */               }; }
/*     */            }
/*     */       
/*     */       } 
/* 405 */       if (this.protectEntity == null && this.protectUUID != null) {
/* 406 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.protectUUID);
/* 407 */         if (entity instanceof EliteHerobrineKnockedEntity) { EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = (EliteHerobrineKnockedEntity)entity;
/* 408 */           this.protectEntity = eliteHerobrineKnockedEntity; }
/*     */         else
/* 410 */         { this.protectEntity = null; }
/*     */       
/*     */       } 
/* 413 */       if (this.protectEntity != null && !this.protectEntity.m_6084_()) {
/* 414 */         this.protectEntity = null;
/* 415 */         this.protectUUID = null;
/* 416 */         this.autoKill = true;
/* 417 */         m_6074_();
/*     */       } 
/*     */       
/* 420 */       if (this.possessedByEntity == null && this.possessedByUuid != null) {
/* 421 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.possessedByUuid);
/* 422 */         if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 423 */           this.possessedByEntity = herobrineMob; }
/*     */         else
/* 425 */         { this.possessedByEntity = null; }
/*     */       
/*     */       } 
/* 428 */       if (!this.forEscaping && !this.bound && this.possessedByEntity != null && this.possessedByEntity
/* 429 */         .m_6084_() && (
/* 430 */         !this.possessedByEntity.isSacrificing() || !this.possessedByEntity.isHealing()) && this.possessedByEntity
/* 431 */         .getSacrificingAnimationCooldown() == 0 && 
/* 432 */         this.possessedByEntity.isAvailableSlot() && 
/* 433 */         this.possessedByEntity.boundPossessed((Entity)this)) {
/* 434 */         this.bound = true;
/*     */       }
/*     */ 
/*     */       
/* 438 */       if (this.possessedByEntity != null && !this.possessedByEntity.m_6084_()) {
/* 439 */         AABB area = (new AABB(m_20183_())).m_82400_(60.0D);
/* 440 */         List<Entity> nearby = m_9236_().m_6249_((Entity)this, area, entity -> entity instanceof EliteHerobrineKnockedEntity);
/*     */ 
/*     */         
/* 443 */         if (!nearby.isEmpty()) {
/* 444 */           Entity entity = nearby.get(0);
/* 445 */           if (entity instanceof EliteHerobrineKnockedEntity) { EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = (EliteHerobrineKnockedEntity)entity;
/* 446 */             this.protectEntity = eliteHerobrineKnockedEntity;
/* 447 */             this.protectUUID = eliteHerobrineKnockedEntity.m_20148_(); }
/*     */           else
/* 449 */           { this.possessedByEntity = null;
/* 450 */             this.possessedByUuid = null;
/* 451 */             this.autoKill = true;
/* 452 */             m_6074_(); }
/*     */         
/*     */         } else {
/* 455 */           this.possessedByEntity = null;
/* 456 */           this.possessedByUuid = null;
/* 457 */           this.autoKill = true;
/* 458 */           m_6074_();
/*     */         } 
/*     */       } 
/* 461 */       if (this.sacrificing || this.healing) {
/* 462 */         if (m_21223_() <= 2.0F) {
/* 463 */           this.sacrificing = false;
/* 464 */           this.healing = false;
/* 465 */           this.autoKill = true;
/* 466 */           m_6074_();
/*     */         } 
/* 468 */         m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 1, 3, false, false));
/* 469 */         if (this.livingentitypatch != null && !m_21224_() && m_6084_()) {
/* 470 */           if (this.sacrificing) {
/* 471 */             this.livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.HEROBRINE_ASSISTANCE, 0.0F);
/* 472 */           } else if (this.healing) {
/* 473 */             this.livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.HEROBRINE_SACRIFICING, 0.0F);
/*     */           } 
/*     */         }
/* 476 */         if (this.f_19797_ % 140 == 0 && this.possessedByEntity.m_21223_() < this.possessedByEntity.m_21233_() * 0.8D) {
/* 477 */           m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_UNDERSTOOD.get(), 1.0F, 1.0F);
/*     */         }
/* 479 */         if (this.f_19797_ % 20 == 0 && this.possessedByEntity != null) {
/* 480 */           if (this.possessedByEntity.m_21233_() == this.possessedByEntity.m_21223_()) {
/* 481 */             this.sacrificing = false;
/* 482 */             this.healing = false;
/* 483 */             this.autoKill = true;
/* 484 */             m_6074_();
/*     */           } 
/* 486 */           if (m_21223_() <= 4.0F) {
/* 487 */             this.sacrificing = false;
/* 488 */             this.healing = false;
/* 489 */             this.autoKill = true;
/* 490 */             m_6074_();
/*     */           } else {
/* 492 */             m_21153_(m_21223_() - 2.0F);
/*     */           } 
/* 494 */           this.possessedByEntity.m_5634_(this.possessedByEntity.m_21233_() * 0.01F);
/* 495 */           if (this.healing) {
/* 496 */             AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 497 */                 .with(() -> this), new ClientboundLitePortalFx(new Vec3(
/* 498 */                     m_20185_(), m_20186_(), m_20189_())));
/*     */             
/* 500 */             CombatBehaviour.forceLookAt((Entity)this, (Entity)this.possessedByEntity, 60.0F, 60.0F);
/*     */           } 
/*     */         } 
/* 503 */         if (this.possessedByEntity != null && this.possessedByEntity.m_6084_()) {
/* 504 */           ServerLevel server = (ServerLevel)m_9236_();
/* 505 */           Vec3 from = null;
/* 506 */           if (this.sacrificing) {
/* 507 */             from = getSacrificingArmPosition((Entity)this, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/* 508 */           } else if (this.healing) {
/* 509 */             from = getHealingArmPosition((Entity)this, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/*     */           } 
/* 511 */           if (from == null) {
/*     */             return;
/*     */           }
/* 514 */           Vec3 to = this.possessedByEntity.m_146892_();
/*     */           
/* 516 */           AABB box = this.possessedByEntity.m_20191_().m_82400_(0.05D);
/* 517 */           Vec3 end = box.m_82371_(from, to).orElse(to);
/*     */           
/* 519 */           Vec3 d = end.m_82546_(from);
/* 520 */           double len = d.m_82553_();
/* 521 */           if (len <= 1.0E-4D)
/*     */             return; 
/* 523 */           Vec3 dir = d.m_82490_(1.0D / len);
/*     */           
/* 525 */           Vec3 any = (Math.abs(dir.f_82480_) < 0.99D) ? new Vec3(0.0D, 1.0D, 0.0D) : new Vec3(1.0D, 0.0D, 0.0D);
/* 526 */           Vec3 u = dir.m_82537_(any).m_82541_();
/* 527 */           Vec3 v = dir.m_82537_(u).m_82541_();
/*     */           
/* 529 */           int steps = Mth.m_14045_((int)(len * 6.0D), 6, 72);
/* 530 */           double step = len / steps;
/*     */           
/* 532 */           int stride = 4;
/* 533 */           int phase = (this.f_19797_ >> 1) % 4;
/* 534 */           RandomSource r = m_217043_();
/*     */           
/* 536 */           for (int i = phase; i <= steps; i += 4) {
/* 537 */             if (r.m_188501_() >= 0.7F)
/*     */             {
/* 539 */               double t = i * step / len;
/* 540 */               double R = 0.05D + 0.2D * t;
/* 541 */               double ang = r.m_188500_() * 6.283185307179586D;
/* 542 */               double rad = R * Math.sqrt(r.m_188500_());
/* 543 */               Vec3 off = u.m_82490_(Math.cos(ang) * rad).m_82549_(v.m_82490_(Math.sin(ang) * rad));
/*     */               
/* 545 */               Vec3 p = from.m_82549_(dir.m_82490_(i * step)).m_82549_(off);
/*     */               
/* 547 */               double vx = dir.f_82479_ * 0.02D + off.f_82479_ * 0.1D;
/* 548 */               double vy = dir.f_82480_ * 0.02D + off.f_82480_ * 0.1D;
/* 549 */               double vz = dir.f_82481_ * 0.02D + off.f_82481_ * 0.1D;
/*     */               
/* 551 */               server.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.LIGHT.get(), p.f_82479_, p.f_82480_, p.f_82481_, 1, vx, vy, vz, 0.0D);
/*     */             }
/*     */           
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 558 */           this.sacrificing = false;
/* 559 */           this.healing = false;
/* 560 */           this.autoKill = true;
/* 561 */           m_6074_();
/*     */         } 
/*     */       } 
/* 564 */       if (this.forEscaping) {
/* 565 */         if (m_21223_() <= 2.0F) {
/* 566 */           this.forEscaping = false;
/* 567 */           this.autoKill = true;
/* 568 */           m_6074_();
/*     */         } 
/*     */         
/* 571 */         m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 1, 3, false, false));
/* 572 */         if (this.livingentitypatch != null) {
/* 573 */           this.livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LOW_CLONE_ESCAPE, 0.0F);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Vec3 getSacrificingArmPosition(Entity entity, Vec3f translation, Joint joint) {
/* 580 */     float handToTip = 0.6F;
/* 581 */     float yOffset = 0.6F;
/* 582 */     LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 583 */     if (livingEntityPatch == null) return null;
/*     */     
/* 585 */     float interpolation = 0.0F;
/*     */     
/* 587 */     OpenMatrix4f m = livingEntityPatch.getArmature().getBoundTransformFor(livingEntityPatch.getAnimator().getPose(interpolation), joint);
/*     */     
/* 589 */     if (translation != null) {
/* 590 */       OpenMatrix4f tLocal = (new OpenMatrix4f()).translate(translation);
/* 591 */       OpenMatrix4f.mul(m, tLocal, m);
/*     */     } 
/*     */     
/* 594 */     OpenMatrix4f tipOffset = (new OpenMatrix4f()).translate(new Vec3f(0.0F, 0.0F, -handToTip));
/* 595 */     OpenMatrix4f.mul(m, tipOffset, m);
/*     */     
/* 597 */     float yawRad = (float)-Math.toRadians((((LivingEntity)livingEntityPatch.getOriginal()).f_20884_ + 180.0F));
/* 598 */     OpenMatrix4f worldYaw = (new OpenMatrix4f()).rotate(yawRad, new Vec3f(0.0F, 1.0F, 0.0F));
/* 599 */     OpenMatrix4f.mul(worldYaw, m, m);
/*     */     
/* 601 */     LivingEntity base = (LivingEntity)livingEntityPatch.getOriginal();
/* 602 */     return new Vec3(m.m30 + base
/* 603 */         .m_20185_(), m.m31 + base
/* 604 */         .m_20186_() + entity.m_20206_() / 1.8D - 1.0D + yOffset, m.m32 + base
/* 605 */         .m_20189_());
/*     */   }
/*     */ 
/*     */   
/*     */   private static Vec3 getHealingArmPosition(Entity entity, Vec3f translation, Joint joint) {
/* 610 */     float handToTip = 1.2F;
/* 611 */     float yOffset = 0.0F;
/* 612 */     LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 613 */     if (livingEntityPatch == null) return null;
/*     */     
/* 615 */     float interpolation = 0.0F;
/*     */     
/* 617 */     OpenMatrix4f m = livingEntityPatch.getArmature().getBoundTransformFor(livingEntityPatch.getAnimator().getPose(interpolation), joint);
/*     */     
/* 619 */     if (translation != null) {
/* 620 */       OpenMatrix4f tLocal = (new OpenMatrix4f()).translate(translation);
/* 621 */       OpenMatrix4f.mul(m, tLocal, m);
/*     */     } 
/*     */     
/* 624 */     OpenMatrix4f tipOffset = (new OpenMatrix4f()).translate(new Vec3f(0.0F, 0.0F, -handToTip));
/* 625 */     OpenMatrix4f.mul(m, tipOffset, m);
/*     */     
/* 627 */     float yawRad = (float)-Math.toRadians((((LivingEntity)livingEntityPatch.getOriginal()).f_20884_ + 180.0F));
/* 628 */     OpenMatrix4f worldYaw = (new OpenMatrix4f()).rotate(yawRad, new Vec3f(0.0F, 1.0F, 0.0F));
/* 629 */     OpenMatrix4f.mul(worldYaw, m, m);
/*     */     
/* 631 */     LivingEntity base = (LivingEntity)livingEntityPatch.getOriginal();
/* 632 */     return new Vec3(m.m30 + base
/* 633 */         .m_20185_(), m.m31 + base
/* 634 */         .m_20186_() + entity.m_20206_() / 1.8D - 1.0D + yOffset, m.m32 + base
/* 635 */         .m_20189_());
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6075_() {
/* 640 */     super.m_6075_();
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<LowShadowHerobrineCloneEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 644 */     ServerLevel serverLevel = level.m_6018_();
/* 645 */     int passesDay = (int)(serverLevel.m_46467_() / 24000L);
/* 646 */     if (passesDay % 3 != 0) {
/* 647 */       return false;
/*     */     }
/* 649 */     if (HerobrineMobData.get(serverLevel).isOccupied(serverLevel)) {
/* 650 */       return false;
/*     */     }
/* 652 */     if (!serverLevel.m_46462_()) {
/* 653 */       return false;
/*     */     }
/* 655 */     return Monster.m_219013_(entityType, level, spawnType, position, random);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag pCompound) {
/* 660 */     super.m_7378_(pCompound);
/* 661 */     this.summoned = pCompound.m_128471_("Summoned");
/* 662 */     this.renderPortal = pCompound.m_128471_("RenderPortal");
/* 663 */     this.initialSpawn = pCompound.m_128471_("InitialSpawn");
/* 664 */     this.autoKill = pCompound.m_128471_("AutoKill");
/* 665 */     if (pCompound.m_128403_("ProtectUUID")) {
/* 666 */       this.protectUUID = pCompound.m_128342_("ProtectUUID");
/*     */     }
/* 668 */     if (pCompound.m_128403_("PossessedByUuid")) {
/* 669 */       this.possessedByUuid = pCompound.m_128342_("PossessedByUuid");
/*     */     }
/* 671 */     this.bound = pCompound.m_128471_("Bound");
/* 672 */     this.sacrificing = pCompound.m_128471_("Sacrificing");
/* 673 */     this.healing = pCompound.m_128471_("Healing");
/* 674 */     this.forEscaping = pCompound.m_128471_("ForEscaping");
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag pCompound) {
/* 679 */     super.m_7380_(pCompound);
/* 680 */     pCompound.m_128379_("Summoned", this.summoned);
/* 681 */     pCompound.m_128379_("RenderPortal", this.renderPortal);
/* 682 */     pCompound.m_128379_("InitialSpawn", this.initialSpawn);
/* 683 */     pCompound.m_128379_("AutoKill", this.autoKill);
/* 684 */     if (this.protectUUID != null) {
/* 685 */       pCompound.m_128362_("ProtectUUID", this.protectUUID);
/*     */     }
/* 687 */     if (this.possessedByUuid != null) {
/* 688 */       pCompound.m_128362_("PossessedByUuid", this.possessedByUuid);
/*     */     }
/* 690 */     pCompound.m_128379_("Bound", this.bound);
/* 691 */     pCompound.m_128379_("Sacrificing", this.sacrificing);
/* 692 */     pCompound.m_128379_("Healing", this.healing);
/* 693 */     pCompound.m_128379_("ForEscaping", this.forEscaping);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 697 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 699 */     builder = builder.m_22268_(Attributes.f_22279_, 0.3D);
/* 700 */     builder = builder.m_22268_(Attributes.f_22276_, 40.0D);
/* 701 */     builder = builder.m_22268_(Attributes.f_22284_, 25.0D);
/* 702 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 703 */     builder = builder.m_22268_(Attributes.f_22277_, 24.0D);
/* 704 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\LowShadowHerobrineCloneEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */