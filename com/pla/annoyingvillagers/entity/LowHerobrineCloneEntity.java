/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.network.ClientboundLitePortalFx;
/*     */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*     */ import com.pla.annoyingvillagers.util.CommonGoals;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
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
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.PacketDistributor;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import se.gory_moon.player_mobs.entity.PlayerMobEntity;
/*     */ import yesman.epicfight.api.animation.Joint;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*     */ import yesman.epicfight.api.utils.math.Vec3f;
/*     */ import yesman.epicfight.gameasset.Armatures;
/*     */ import yesman.epicfight.model.armature.HumanoidArmature;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class LowHerobrineCloneEntity extends PlayerMobEntity {
/*     */   private boolean summoned = false;
/*     */   private boolean initialSpawn = true;
/*     */   private boolean autoKill = false;
/*  68 */   private final LivingEntityPatch<?> livingentitypatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class); private HerobrineMob possessedByEntity; private UUID possessedByUuid; private boolean bound = false; private boolean healing = false;
/*     */   private EliteHerobrineKnockedEntity protectEntity;
/*     */   private UUID protectUUID;
/*     */   boolean renderPortal = false;
/*     */   
/*     */   public boolean isHealing() {
/*  74 */     return this.healing;
/*     */   }
/*     */   
/*     */   public HerobrineMob getPossessedByEntity() {
/*  78 */     return this.possessedByEntity;
/*     */   }
/*     */   
/*     */   public void setRenderPortal(boolean renderPortal) {
/*  82 */     this.renderPortal = renderPortal;
/*     */   }
/*     */   
/*     */   public boolean isSummoned() {
/*  86 */     return this.summoned;
/*     */   }
/*     */   
/*     */   public void setSummoned(boolean summoned) {
/*  90 */     this.summoned = summoned;
/*     */   }
/*     */   
/*     */   public void setInitialSpawn(boolean initialSpawn) {
/*  94 */     this.initialSpawn = initialSpawn;
/*     */   }
/*     */   
/*     */   public void setPossessedByUuid(UUID possessedByUuid) {
/*  98 */     this.possessedByUuid = possessedByUuid;
/*     */   }
/*     */   
/*     */   public void setPossessedByEntity(HerobrineMob possessedByEntity) {
/* 102 */     this.possessedByEntity = possessedByEntity;
/*     */   }
/*     */   
/*     */   public void setHealing(boolean healing) {
/* 106 */     this.healing = healing;
/*     */   }
/*     */   
/*     */   public LowHerobrineCloneEntity(EntityType<? extends LowHerobrineCloneEntity> type, Level level) {
/* 110 */     super(type, level);
/* 111 */     m_274367_(3.0F);
/* 112 */     this.f_21364_ = 50;
/* 113 */     m_21530_();
/* 114 */     m_20340_(false);
/*     */   }
/*     */   
/*     */   public LowHerobrineCloneEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/* 118 */     this((EntityType<? extends LowHerobrineCloneEntity>)AnnoyingVillagersModEntities.LOW_HEROBRINE_CLONE.get(), level);
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/* 122 */     if (this.healing) {
/* 123 */       if ((new Random()).nextBoolean()) {
/* 124 */         Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 125 */           EpicfightUtil.damageBlocked(damageSource, (Entity)this, serverLevel);
/* 126 */           return false; }
/*     */       
/* 128 */       }  float f1 = m_21223_();
/* 129 */       if (f1 - f <= 5.0F && this.healing) {
/* 130 */         this.protectEntity = null;
/* 131 */         this.protectUUID = null;
/* 132 */         this.autoKill = true;
/* 133 */         m_6074_();
/* 134 */         return false;
/*     */       } 
/* 136 */       return super.m_6469_(damageSource, f / 2.0F);
/*     */     } 
/*     */ 
/*     */     
/* 140 */     if (Math.random() <= 0.5D && 
/* 141 */       !damageSource.m_276093_(DamageTypes.f_268612_) && 
/* 142 */       !damageSource.m_276093_(DamageTypes.f_268631_) && 
/* 143 */       !damageSource.m_276093_(DamageTypes.f_268468_)) {
/* 144 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 145 */         serverLevel.m_5594_(null, m_20183_(), (SoundEvent)AnnoyingVillagersModSounds.OBSIDIAN_PLACE.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/* 146 */         HerobrineUtil.spawnObsidianEyeLineStaggered(serverLevel, (Entity)this, ((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_(), 1); }
/*     */     
/*     */     } 
/*     */     
/* 150 */     if (damageSource.m_276093_(DamageTypes.f_268671_)) return false; 
/* 151 */     if (damageSource.m_276093_(DamageTypes.f_268585_)) return false; 
/* 152 */     if (damageSource.m_276093_(DamageTypes.f_268493_)) return false; 
/* 153 */     if (damageSource.m_276093_(DamageTypes.f_268722_)) return false; 
/* 154 */     if (damageSource.m_276093_(DamageTypes.f_268641_)) return false; 
/* 155 */     if (damageSource.m_276093_(DamageTypes.f_268482_)) return false; 
/* 156 */     float health = m_21223_();
/* 157 */     if (health - f <= 5.0F && this.healing) {
/* 158 */       this.protectEntity = null;
/* 159 */       this.protectUUID = null;
/* 160 */       this.autoKill = true;
/* 161 */       this.healing = false;
/* 162 */       m_6074_();
/* 163 */       return false;
/*     */     } 
/* 165 */     return super.m_6469_(damageSource, f / 2.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean m_8077_() {
/* 171 */     return false;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Component m_5446_() {
/* 176 */     return (Component)Component.m_237113_("§5Low Herobrine Clone§r");
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 180 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/* 184 */     this.f_21345_.m_148105_().clear();
/* 185 */     this.f_21346_.m_148105_().clear();
/* 186 */     this.f_21345_.m_25352_(1, new Goal()
/*     */         {
/*     */           public boolean m_8036_() {
/* 189 */             return (LowHerobrineCloneEntity.this.protectEntity != null && LowHerobrineCloneEntity.this.protectEntity.m_6084_() && LowHerobrineCloneEntity.this.m_20270_((Entity)LowHerobrineCloneEntity.this.protectEntity) > 9.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           public void m_8037_() {
/* 194 */             if (LowHerobrineCloneEntity.this.protectEntity != null && LowHerobrineCloneEntity.this.protectEntity.m_6084_()) {
/* 195 */               LowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowHerobrineCloneEntity.this.protectEntity, 2.0D);
/* 196 */               LowHerobrineCloneEntity.this.m_21563_().m_24960_((Entity)LowHerobrineCloneEntity.this.protectEntity, 30.0F, 30.0F);
/* 197 */               if (LowHerobrineCloneEntity.this.m_20280_((Entity)LowHerobrineCloneEntity.this.protectEntity) > 10.0D) {
/* 198 */                 if (LowHerobrineCloneEntity.this.m_21573_().m_26571_()) {
/* 199 */                   LowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowHerobrineCloneEntity.this.protectEntity, 2.0D);
/*     */                 }
/*     */               } else {
/* 202 */                 LowHerobrineCloneEntity.this.m_21573_().m_26573_();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean m_8045_() {
/* 209 */             return (LowHerobrineCloneEntity.this.protectEntity != null && LowHerobrineCloneEntity.this.protectEntity.m_6084_() && LowHerobrineCloneEntity.this.m_20270_((Entity)LowHerobrineCloneEntity.this.protectEntity) > 50.0D);
/*     */           }
/*     */         });
/* 212 */     this.f_21345_.m_25352_(1, new Goal()
/*     */         {
/*     */           public boolean m_8036_() {
/* 215 */             return (LowHerobrineCloneEntity.this.possessedByEntity != null && LowHerobrineCloneEntity.this.possessedByEntity.m_6084_() && LowHerobrineCloneEntity.this.m_20270_((Entity)LowHerobrineCloneEntity.this.possessedByEntity) > 18.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           public void m_8037_() {
/* 220 */             if (LowHerobrineCloneEntity.this.possessedByEntity != null && LowHerobrineCloneEntity.this.possessedByEntity.m_6084_()) {
/* 221 */               LowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowHerobrineCloneEntity.this.possessedByEntity, 2.0D);
/* 222 */               LowHerobrineCloneEntity.this.m_21563_().m_24960_((Entity)LowHerobrineCloneEntity.this.possessedByEntity, 30.0F, 30.0F);
/* 223 */               if (LowHerobrineCloneEntity.this.m_20280_((Entity)LowHerobrineCloneEntity.this.possessedByEntity) > 20.0D) {
/* 224 */                 if (LowHerobrineCloneEntity.this.m_21573_().m_26571_()) {
/* 225 */                   LowHerobrineCloneEntity.this.m_21573_().m_5624_((Entity)LowHerobrineCloneEntity.this.possessedByEntity, 2.0D);
/*     */                 }
/*     */               } else {
/* 228 */                 LowHerobrineCloneEntity.this.m_21573_().m_26573_();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean m_8045_() {
/* 235 */             return (LowHerobrineCloneEntity.this.possessedByEntity != null && LowHerobrineCloneEntity.this.possessedByEntity.m_6084_() && LowHerobrineCloneEntity.this.m_20270_((Entity)LowHerobrineCloneEntity.this.possessedByEntity) > 50.0D);
/*     */           }
/*     */         });
/* 238 */     CommonGoals.registerGoalForHostileNpc((Monster)this);
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 242 */     return MobType.f_21641_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 246 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 250 */     return -0.35D;
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 254 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt")));
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_5592_() {
/* 258 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death")));
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damageSource) {
/* 263 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 264 */       if (!this.autoKill) {
/* 265 */         InfectedPlayerNpcEntity corpse = new InfectedPlayerNpcEntity((EntityType<? extends InfectedPlayerNpcEntity>)AnnoyingVillagersModEntities.INFECTED_PLAYER_NPC.get(), (Level)serverLevel);
/* 266 */         corpse.m_7678_(m_20185_(), m_20186_(), m_20189_(), m_146908_(), m_146909_());
/* 267 */         String killedName = m_7770_().getString();
/* 268 */         corpse.getPersistentData().m_128359_("possessed_by", "low_herobrine_clone");
/* 269 */         corpse.setUsername(killedName);
/* 270 */         corpse.m_6593_((Component)Component.m_237113_(killedName));
/* 271 */         corpse.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*     */         
/* 273 */         m_6842_(true);
/* 274 */         m_142687_(Entity.RemovalReason.KILLED);
/* 275 */         corpse.m_8061_(EquipmentSlot.HEAD, m_6844_(EquipmentSlot.HEAD).m_41777_());
/* 276 */         corpse.m_8061_(EquipmentSlot.CHEST, m_6844_(EquipmentSlot.CHEST).m_41777_());
/* 277 */         corpse.m_8061_(EquipmentSlot.LEGS, m_6844_(EquipmentSlot.LEGS).m_41777_());
/* 278 */         corpse.m_8061_(EquipmentSlot.FEET, m_6844_(EquipmentSlot.FEET).m_41777_());
/* 279 */         serverLevel.m_7967_((Entity)corpse);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 285 */       ItemStack itemstack = m_21205_();
/* 286 */       ItemEntity itemEntity = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_() + 1.0D, m_20189_(), itemstack);
/* 287 */       itemEntity.m_32010_(10);
/* 288 */       serverLevel.m_7967_((Entity)itemEntity);
/*     */       
/* 290 */       itemstack = m_21206_();
/* 291 */       itemEntity = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_() + 1.0D, m_20189_(), itemstack);
/* 292 */       itemEntity.m_32010_(10);
/* 293 */       serverLevel.m_7967_((Entity)itemEntity); }
/*     */     
/* 295 */     super.m_6667_(damageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 300 */     HerobrineUtil.initialSpawn((LevelAccessor)serverLevelAccessor, (Entity)this, 0, mobSpawnType);
/* 301 */     return super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag pCompound) {
/* 306 */     super.m_7378_(pCompound);
/* 307 */     this.summoned = pCompound.m_128471_("Summoned");
/* 308 */     this.renderPortal = pCompound.m_128471_("RenderPortal");
/* 309 */     this.initialSpawn = pCompound.m_128471_("InitialSpawn");
/* 310 */     this.autoKill = pCompound.m_128471_("AutoKill");
/* 311 */     if (pCompound.m_128403_("ProtectUUID")) {
/* 312 */       this.protectUUID = pCompound.m_128342_("ProtectUUID");
/*     */     }
/* 314 */     if (pCompound.m_128403_("PossessedByUuid")) {
/* 315 */       this.possessedByUuid = pCompound.m_128342_("PossessedByUuid");
/*     */     }
/* 317 */     this.bound = pCompound.m_128471_("Bound");
/* 318 */     this.healing = pCompound.m_128471_("Healing");
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag pCompound) {
/* 323 */     super.m_7380_(pCompound);
/* 324 */     pCompound.m_128379_("Summoned", this.summoned);
/* 325 */     pCompound.m_128379_("InitialSpawn", this.initialSpawn);
/* 326 */     pCompound.m_128379_("RenderPortal", this.renderPortal);
/* 327 */     pCompound.m_128379_("AutoKill", this.autoKill);
/* 328 */     if (this.protectUUID != null) {
/* 329 */       pCompound.m_128362_("ProtectUUID", this.protectUUID);
/*     */     }
/* 331 */     if (this.possessedByUuid != null) {
/* 332 */       pCompound.m_128362_("PossessedByUuid", this.possessedByUuid);
/*     */     }
/* 334 */     pCompound.m_128379_("Bound", this.bound);
/* 335 */     pCompound.m_128379_("Healing", this.healing);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 340 */     super.m_8119_();
/* 341 */     if (!(m_9236_()).f_46443_) {
/* 342 */       if (this.f_19797_ == 1 && 
/* 343 */         this.initialSpawn) {
/* 344 */         if (this.renderPortal) {
/* 345 */           AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY
/* 346 */               .with(() -> this), new ClientboundHerobrinePortalFx(
/* 347 */                 m_20097_().m_252807_().m_82520_(0.0D, 1.5D, 0.0D)));
/*     */           
/* 349 */           this.renderPortal = false;
/*     */         } 
/* 351 */         if (this.summoned) {
/* 352 */           m_21557_(true);
/*     */         }
/* 354 */         LivingEntityPatch<?> livingentitypatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/* 355 */         if (livingentitypatch != null && !m_9236_().m_5776_()) {
/* 356 */           livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.PLAYER_HEROBRINE_POSSESSION, 0.0F);
/*     */         }
/* 358 */         this.initialSpawn = false;
/*     */       } 
/*     */ 
/*     */       
/* 362 */       if (this.protectEntity == null && this.protectUUID != null) {
/* 363 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.protectUUID);
/* 364 */         if (entity instanceof EliteHerobrineKnockedEntity) { EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = (EliteHerobrineKnockedEntity)entity;
/* 365 */           this.protectEntity = eliteHerobrineKnockedEntity; }
/*     */         else
/* 367 */         { this.protectEntity = null; }
/*     */       
/*     */       } 
/* 370 */       if (this.protectEntity != null && !this.protectEntity.m_6084_()) {
/* 371 */         this.protectEntity = null;
/* 372 */         this.protectUUID = null;
/* 373 */         this.autoKill = true;
/* 374 */         m_6074_();
/*     */       } 
/*     */       
/* 377 */       if (this.possessedByEntity == null && this.possessedByUuid != null) {
/* 378 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.possessedByUuid);
/* 379 */         if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 380 */           this.possessedByEntity = herobrineMob; }
/*     */         else
/* 382 */         { this.possessedByEntity = null; }
/*     */       
/*     */       } 
/* 385 */       if (!this.bound && this.possessedByEntity != null && this.possessedByEntity
/* 386 */         .m_6084_() && (
/* 387 */         !this.possessedByEntity.isSacrificing() || !this.possessedByEntity.isHealing()) && this.possessedByEntity
/* 388 */         .getSacrificingAnimationCooldown() == 0 && 
/* 389 */         this.possessedByEntity.isAvailableSlot() && 
/* 390 */         this.possessedByEntity.boundPossessed((Entity)this)) {
/* 391 */         this.bound = true;
/*     */       }
/*     */ 
/*     */       
/* 395 */       if (this.possessedByEntity != null && !this.possessedByEntity.m_6084_()) {
/* 396 */         AABB area = (new AABB(m_20183_())).m_82400_(60.0D);
/* 397 */         List<Entity> nearby = m_9236_().m_6249_((Entity)this, area, entity -> entity instanceof EliteHerobrineKnockedEntity);
/*     */ 
/*     */         
/* 400 */         if (!nearby.isEmpty()) {
/* 401 */           Entity entity = nearby.get(0);
/* 402 */           if (entity instanceof EliteHerobrineKnockedEntity) { EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = (EliteHerobrineKnockedEntity)entity;
/* 403 */             this.protectEntity = eliteHerobrineKnockedEntity;
/* 404 */             this.protectUUID = eliteHerobrineKnockedEntity.m_20148_(); }
/*     */           else
/* 406 */           { this.possessedByEntity = null;
/* 407 */             this.possessedByUuid = null;
/* 408 */             this.autoKill = true;
/* 409 */             m_6074_(); }
/*     */         
/*     */         } else {
/* 412 */           this.possessedByEntity = null;
/* 413 */           this.possessedByUuid = null;
/* 414 */           this.autoKill = true;
/* 415 */           m_6074_();
/*     */         } 
/*     */       } 
/* 418 */       if (this.healing) {
/* 419 */         if (m_21223_() <= 2.0F) {
/* 420 */           this.healing = false;
/* 421 */           this.autoKill = true;
/* 422 */           m_6074_();
/*     */         } 
/* 424 */         m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 1, 3, false, false));
/* 425 */         if (this.livingentitypatch != null && !m_21224_() && m_6084_()) {
/* 426 */           this.livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.HEROBRINE_SACRIFICING, 0.0F);
/*     */         }
/* 428 */         if (this.f_19797_ % 140 == 0 && this.possessedByEntity.m_21223_() < this.possessedByEntity.m_21233_() * 0.8D) {
/* 429 */           m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_UNDERSTOOD.get(), 1.0F, 1.0F);
/*     */         }
/* 431 */         if (this.f_19797_ % 20 == 0 && this.possessedByEntity != null) {
/* 432 */           if (this.possessedByEntity.m_21233_() == this.possessedByEntity.m_21223_()) {
/* 433 */             this.healing = false;
/* 434 */             this.autoKill = true;
/* 435 */             m_6074_();
/*     */           } 
/* 437 */           if (m_21223_() <= 4.0F) {
/* 438 */             this.healing = false;
/* 439 */             this.autoKill = true;
/* 440 */             m_6074_();
/*     */           } else {
/* 442 */             m_21153_(m_21223_() - 2.0F);
/*     */           } 
/* 444 */           this.possessedByEntity.m_5634_(this.possessedByEntity.m_21233_() * 0.01F);
/* 445 */           AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 446 */               .with(() -> this), new ClientboundLitePortalFx(new Vec3(
/* 447 */                   m_20185_(), m_20186_(), m_20189_())));
/*     */           
/* 449 */           CombatBehaviour.forceLookAt((Entity)this, (Entity)this.possessedByEntity, 60.0F, 60.0F);
/*     */         } 
/* 451 */         if (this.possessedByEntity != null && this.possessedByEntity.m_6084_()) {
/* 452 */           ServerLevel server = (ServerLevel)m_9236_();
/* 453 */           Vec3 from = getHealingArmPosition((Entity)this, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/* 454 */           if (from == null) {
/*     */             return;
/*     */           }
/* 457 */           Vec3 to = this.possessedByEntity.m_146892_();
/*     */           
/* 459 */           AABB box = this.possessedByEntity.m_20191_().m_82400_(0.05D);
/* 460 */           Vec3 end = box.m_82371_(from, to).orElse(to);
/*     */           
/* 462 */           Vec3 d = end.m_82546_(from);
/* 463 */           double len = d.m_82553_();
/* 464 */           if (len <= 1.0E-4D)
/*     */             return; 
/* 466 */           Vec3 dir = d.m_82490_(1.0D / len);
/*     */           
/* 468 */           Vec3 any = (Math.abs(dir.f_82480_) < 0.99D) ? new Vec3(0.0D, 1.0D, 0.0D) : new Vec3(1.0D, 0.0D, 0.0D);
/* 469 */           Vec3 u = dir.m_82537_(any).m_82541_();
/* 470 */           Vec3 v = dir.m_82537_(u).m_82541_();
/*     */           
/* 472 */           int steps = Mth.m_14045_((int)(len * 6.0D), 6, 72);
/* 473 */           double step = len / steps;
/*     */           
/* 475 */           int stride = 4;
/* 476 */           int phase = (this.f_19797_ >> 1) % 4;
/* 477 */           RandomSource r = m_217043_();
/*     */           
/* 479 */           for (int i = phase; i <= steps; i += 4) {
/* 480 */             if (r.m_188501_() >= 0.7F)
/*     */             {
/* 482 */               double t = i * step / len;
/* 483 */               double R = 0.05D + 0.2D * t;
/* 484 */               double ang = r.m_188500_() * 6.283185307179586D;
/* 485 */               double rad = R * Math.sqrt(r.m_188500_());
/* 486 */               Vec3 off = u.m_82490_(Math.cos(ang) * rad).m_82549_(v.m_82490_(Math.sin(ang) * rad));
/*     */               
/* 488 */               Vec3 p = from.m_82549_(dir.m_82490_(i * step)).m_82549_(off);
/*     */               
/* 490 */               double vx = dir.f_82479_ * 0.02D + off.f_82479_ * 0.1D;
/* 491 */               double vy = dir.f_82480_ * 0.02D + off.f_82480_ * 0.1D;
/* 492 */               double vz = dir.f_82481_ * 0.02D + off.f_82481_ * 0.1D;
/*     */               
/* 494 */               server.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.LIGHT.get(), p.f_82479_, p.f_82480_, p.f_82481_, 1, vx, vy, vz, 0.0D);
/*     */             }
/*     */           
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 501 */           this.healing = false;
/* 502 */           this.autoKill = true;
/* 503 */           m_6074_();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Vec3 getHealingArmPosition(Entity entity, Vec3f translation, Joint joint) {
/* 510 */     float handToTip = 1.2F;
/* 511 */     float yOffset = 0.0F;
/* 512 */     LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 513 */     if (livingEntityPatch == null) return null;
/*     */     
/* 515 */     float interpolation = 0.0F;
/*     */     
/* 517 */     OpenMatrix4f m = livingEntityPatch.getArmature().getBoundTransformFor(livingEntityPatch.getAnimator().getPose(interpolation), joint);
/*     */     
/* 519 */     if (translation != null) {
/* 520 */       OpenMatrix4f tLocal = (new OpenMatrix4f()).translate(translation);
/* 521 */       OpenMatrix4f.mul(m, tLocal, m);
/*     */     } 
/*     */     
/* 524 */     OpenMatrix4f tipOffset = (new OpenMatrix4f()).translate(new Vec3f(0.0F, 0.0F, -handToTip));
/* 525 */     OpenMatrix4f.mul(m, tipOffset, m);
/*     */     
/* 527 */     float yawRad = (float)-Math.toRadians((((LivingEntity)livingEntityPatch.getOriginal()).f_20884_ + 180.0F));
/* 528 */     OpenMatrix4f worldYaw = (new OpenMatrix4f()).rotate(yawRad, new Vec3f(0.0F, 1.0F, 0.0F));
/* 529 */     OpenMatrix4f.mul(worldYaw, m, m);
/*     */     
/* 531 */     LivingEntity base = (LivingEntity)livingEntityPatch.getOriginal();
/* 532 */     return new Vec3(m.m30 + base
/* 533 */         .m_20185_(), m.m31 + base
/* 534 */         .m_20186_() + entity.m_20206_() / 1.8D - 1.0D + yOffset, m.m32 + base
/* 535 */         .m_20189_());
/*     */   }
/*     */ 
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 540 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 542 */     builder = builder.m_22268_(Attributes.f_22279_, 0.45D);
/* 543 */     builder = builder.m_22268_(Attributes.f_22276_, 40.0D);
/* 544 */     builder = builder.m_22268_(Attributes.f_22284_, 25.0D);
/* 545 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 546 */     builder = builder.m_22268_(Attributes.f_22277_, 48.0D);
/* 547 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\LowHerobrineCloneEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */