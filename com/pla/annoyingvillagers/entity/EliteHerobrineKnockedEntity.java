/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.material.FluidState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class EliteHerobrineKnockedEntity extends PathfinderMob {
/*  53 */   private int eatCount = 0; private int wardenCallingCooldown;
/*     */   private boolean initialSpawn = false;
/*  55 */   final LivingEntityPatch<?> livingentitypatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*  56 */   private final List<Item> listWeapons = new ArrayList<>(Arrays.asList(new Item[] { Items.f_42388_, Items.f_42391_, (Item)AnnoyingVillagersModItems.DIAMOND_ATTRACTOR_SWORD
/*     */ 
/*     */           
/*  59 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_BLASTER_SWORD
/*  60 */           .get(), (Item)AnnoyingVillagersModItems.HOOKED_DIAMOND_SWORD
/*  61 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_WARBLADE
/*  62 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_FALCHION
/*  63 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_GREAT_FALCHION
/*  64 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_SABRE
/*  65 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_LONGSWORD
/*  66 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_CHIPPED_LONGSWORD
/*  67 */           .get(), (Item)AnnoyingVillagersModItems.PALADIN_SWORD
/*  68 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_GREATAXE
/*  69 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_ARMBLADE
/*  70 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_SICKLE
/*  71 */           .get(), (Item)AnnoyingVillagersModItems.DOUBLE_DIAMOND_GLAIVE
/*  72 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_MOON_BLADE
/*  73 */           .get() }));
/*     */ 
/*     */   
/*     */   public EliteHerobrineKnockedEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  77 */     this((EntityType<EliteHerobrineKnockedEntity>)AnnoyingVillagersModEntities.ELITE_HEROBRINE_KNOCKED.get(), level);
/*     */   }
/*     */   
/*     */   public EliteHerobrineKnockedEntity(EntityType<EliteHerobrineKnockedEntity> entitytype, Level level) {
/*  81 */     super(entitytype, level);
/*  82 */     m_274367_(0.6F);
/*  83 */     this.f_21364_ = 0;
/*  84 */     m_21557_(true);
/*  85 */     m_20340_(false);
/*  86 */     m_21530_();
/*  87 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN_LONG.get()));
/*  88 */     m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN_BIG.get()));
/*  89 */     m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN.get()));
/*  90 */     m_21409_(EquipmentSlot.MAINHAND, 0.0F);
/*  91 */     m_21409_(EquipmentSlot.OFFHAND, 0.0F);
/*  92 */     m_21409_(EquipmentSlot.HEAD, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag pCompound) {
/*  97 */     super.m_7378_(pCompound);
/*  98 */     this.wardenCallingCooldown = pCompound.m_128451_("WardenCallingCooldown");
/*  99 */     this.eatCount = pCompound.m_128451_("EatCount");
/* 100 */     this.initialSpawn = pCompound.m_128471_("InitialSpawn");
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag pCompound) {
/* 105 */     super.m_7380_(pCompound);
/* 106 */     pCompound.m_128405_("WardenCallingCooldown", this.wardenCallingCooldown);
/* 107 */     pCompound.m_128405_("EatCount", this.eatCount);
/* 108 */     pCompound.m_128379_("InitialSpawn", this.initialSpawn);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 112 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 116 */     return MobType.f_21641_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 120 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 124 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 128 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt"));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(DamageSource pSource, float pAmount) {
/* 133 */     if (pSource.m_7639_() instanceof HerobrineWardenEntity) {
/* 134 */       this.eatCount++;
/* 135 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 136 */         if (this.eatCount == 1) {
/* 137 */           m_5496_((SoundEvent)AnnoyingVillagersModSounds.KNOCKED_ELITE_HEROBRINE_SAY_ON_BEING_EATEN.get(), 1.0F, 1.0F);
/*     */         }
/* 139 */         serverLevel.m_5594_(null, 
/*     */             
/* 141 */             BlockPos.m_274561_(m_20185_(), m_20186_(), m_20189_()), SoundEvents.f_11912_, SoundSource.NEUTRAL, 1.0F, 1.0F); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       if (this.eatCount == 10) {
/* 149 */         m_142687_(Entity.RemovalReason.DISCARDED);
/*     */       }
/* 151 */       return super.m_6469_(pSource, 0.0F);
/*     */     } 
/* 153 */     if (pSource.m_276093_(DamageTypes.f_268612_)) return false; 
/* 154 */     return super.m_6469_(pSource, 1.0F);
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/* 158 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
/*     */   }
/*     */   
/*     */   private void solidifyFeetAndStandOnTop() {
/* 162 */     if (m_9236_().m_5776_())
/*     */       return; 
/* 164 */     BlockPos feet = m_20097_();
/* 165 */     FluidState fluid = m_9236_().m_6425_(feet);
/* 166 */     if (fluid.m_76178_())
/*     */       return; 
/* 168 */     m_9236_().m_46597_(feet, Blocks.f_50723_.m_49966_());
/*     */     
/* 170 */     BlockState bs = m_9236_().m_8055_(feet);
/* 171 */     VoxelShape shape = bs.m_60742_((BlockGetter)m_9236_(), feet, CollisionContext.m_82750_((Entity)this));
/* 172 */     double top = shape.m_83281_() ? 1.0D : shape.m_83297_(Direction.Axis.Y);
/*     */     
/* 174 */     double surfaceY = feet.m_123342_() + top + 0.001D;
/* 175 */     double x = m_20185_();
/* 176 */     double z = m_20189_();
/*     */     
/* 178 */     this.f_19789_ = 0.0F;
/* 179 */     m_20334_((m_20184_()).f_82479_, 0.0D, (m_20184_()).f_82481_);
/* 180 */     m_6034_(x, surfaceY, z);
/* 181 */     m_6853_(true);
/*     */ 
/*     */ 
/*     */     
/* 185 */     for (int dx = -1; dx <= 1; dx++) {
/* 186 */       for (int dz = -1; dz <= 1; dz++) {
/* 187 */         BlockPos around = feet.m_7918_(dx, 0, dz);
/* 188 */         FluidState fs = m_9236_().m_6425_(around);
/* 189 */         if (!fs.m_76178_()) {
/* 190 */           m_9236_().m_46597_(around, Blocks.f_50723_.m_49966_());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void m_8119_() {
/* 197 */     super.m_8119_();
/* 198 */     if (!m_9236_().m_5776_()) {
/* 199 */       if (this.f_19797_ == 1 && !this.initialSpawn) {
/* 200 */         m_5496_((SoundEvent)AnnoyingVillagersModSounds.KNOCKED_ELITE_HEROBRINE_SAY_ON_SPAWN.get(), 1.0F, 1.0F);
/* 201 */         this.initialSpawn = true;
/*     */       } 
/* 203 */       solidifyFeetAndStandOnTop();
/* 204 */       if (this.wardenCallingCooldown >= 0) {
/* 205 */         this.wardenCallingCooldown--;
/*     */       }
/* 207 */       if (this.livingentitypatch != null) {
/* 208 */         if (this.eatCount == 1 || this.eatCount == 2) {
/* 209 */           this.livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.EATING_ELITE_1, 0.0F);
/* 210 */         } else if (this.eatCount == 3 || this.eatCount == 4) {
/* 211 */           this.livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.EATING_ELITE_2, 0.0F);
/* 212 */         } else if (this.eatCount == 5 || this.eatCount == 6) {
/* 213 */           this.livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.EATING_ELITE_3, 0.0F);
/* 214 */         } else if (this.eatCount > 6) {
/* 215 */           this.livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.EATING_ELITE_4, 0.0F);
/*     */         } 
/*     */       }
/* 218 */       m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 1, 3, false, false));
/* 219 */       if (this.wardenCallingCooldown == 0) {
/* 220 */         ServerLevel level = (ServerLevel)m_9236_();
/*     */         
/* 222 */         HerobrineWardenEntity warden = new HerobrineWardenEntity((EntityType<? extends Monster>)AnnoyingVillagersModEntities.HEROBRINE_WARDEN.get(), (Level)level);
/* 223 */         double dist = (m_20205_() + warden.m_20205_()) * 0.5D + 0.5D;
/* 224 */         Vec3 forward = Vec3.m_82498_(0.0F, this.f_20883_);
/*     */ 
/*     */         
/* 227 */         Vec3 spawn = m_20182_().m_82546_(forward.m_82490_(dist)).m_82520_(0.0D, 0.001D, 0.0D);
/*     */         
/* 229 */         for (int i = 0; i < 5; i++) {
/* 230 */           warden.m_6034_(spawn.f_82479_, m_20186_(), spawn.f_82481_);
/* 231 */           if (level.m_45786_((Entity)warden))
/* 232 */             break;  spawn = spawn.m_82546_(forward.m_82490_(0.3D));
/*     */         } 
/*     */         
/* 235 */         warden.m_7678_(spawn.f_82479_, m_20186_(), spawn.f_82481_, this.f_20883_, 0.0F);
/* 236 */         warden.f_20883_ = this.f_20883_;
/* 237 */         warden.m_5616_(this.f_20883_);
/*     */         
/* 239 */         warden.m_6518_((ServerLevelAccessor)level, level.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*     */ 
/*     */         
/* 242 */         warden.setEatingUUID(m_20148_());
/* 243 */         level.m_7967_((Entity)warden);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damageSource) {
/* 249 */     super.m_6667_(damageSource);
/* 250 */     if (getPersistentData().m_128441_("FromElite")) {
/* 251 */       String fromElite = getPersistentData().m_128461_("FromElite");
/* 252 */       HerobrineUtil.dropEliteHerobrineLoot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_(), fromElite);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ItemStack randomDamage(ItemStack itemStack) {
/* 257 */     int maxDamage = itemStack.m_41776_();
/* 258 */     itemStack.m_41721_((new Random()).nextInt(maxDamage / 3, maxDamage * 3 / 4));
/* 259 */     return itemStack;
/*     */   }
/*     */   
/*     */   private void equipGearForLowClone(LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity, boolean randomWeapon) {
/* 263 */     if (this.f_19796_.m_188501_() < 0.3F) {
/* 264 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.HEAD, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_HELMET.get())));
/*     */     }
/* 266 */     if (this.f_19796_.m_188501_() < 0.3F) {
/* 267 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.CHEST, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_CHESTPLATE.get())));
/*     */     }
/* 269 */     if (this.f_19796_.m_188501_() < 0.3F) {
/* 270 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.LEGS, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_LEGGINGS.get())));
/*     */     }
/* 272 */     if (this.f_19796_.m_188501_() < 0.3F) {
/* 273 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.FEET, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_BOOTS.get())));
/*     */     }
/* 275 */     if (randomWeapon) {
/* 276 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.MAINHAND, randomDamage(new ItemStack((ItemLike)this.listWeapons.get(this.f_19796_.m_188503_(this.listWeapons.size())))));
/*     */     }
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor pLevel, @NotNull DifficultyInstance pDifficulty, @NotNull MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
/* 282 */     SpawnGroupData spawnGroupData = super.m_6518_(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
/* 283 */     if (!pLevel.m_5776_()) {
/* 284 */       int d0 = (int)m_20185_();
/* 285 */       int d1 = (int)m_20186_();
/* 286 */       int d2 = (int)m_20189_();
/* 287 */       RandomSource randomSource = RandomSource.m_216327_();
/*     */       
/* 289 */       ServerLevel server = (ServerLevel)m_9236_();
/*     */       
/* 291 */       BlockPos feetPos = m_20183_();
/* 292 */       int yFeet = feetPos.m_123342_();
/* 293 */       int radius = 2;
/* 294 */       int clearHeight = 3;
/*     */       
/* 296 */       int totalProjectiles = (new Random()).nextInt(10, 20);
/* 297 */       for (int i = 0; i < totalProjectiles; i++) {
/* 298 */         double x = m_20185_() + Mth.m_216263_(randomSource, -1.5D, 1.5D);
/* 299 */         double y = m_20186_() + Mth.m_216263_(randomSource, 1.0D, 1.5D);
/* 300 */         double z = m_20189_() + Mth.m_216263_(randomSource, -1.5D, 1.5D);
/* 301 */         BlockProjectileEntity blockProjectileEntity = new BlockProjectileEntity((Level)pLevel.m_6018_(), (LivingEntity)this, Blocks.f_50723_.m_49966_());
/* 302 */         blockProjectileEntity.m_20219_(new Vec3(x, y, z));
/* 303 */         server.m_7967_((Entity)blockProjectileEntity);
/*     */       } 
/*     */       
/* 306 */       server.m_254849_((Entity)this, m_20185_(), m_20186_() + 3.0D, m_20189_(), 3.0F, Level.ExplosionInteraction.MOB);
/*     */       
/* 308 */       for (int dy = 1; dy <= 3; dy++) {
/* 309 */         int y = yFeet + dy;
/* 310 */         for (int dx = -2; dx <= 2; dx++) {
/* 311 */           for (int dz = -2; dz <= 2; dz++) {
/* 312 */             BlockPos pos = new BlockPos(feetPos.m_123341_() + dx, y, feetPos.m_123343_() + dz);
/* 313 */             BlockState state = server.m_8055_(pos);
/* 314 */             if (!state.m_60795_() && state.m_60800_((BlockGetter)server, pos) != -1.0F) {
/* 315 */               server.m_7731_(pos, Blocks.f_50016_.m_49966_(), 3);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 321 */       double forwardDist = Math.max(1.5D, m_20205_() * 1.5D);
/* 322 */       double sideDist = Math.max(1.2D, m_20205_() * 1.2D);
/*     */       
/* 324 */       float yaw = m_146908_();
/* 325 */       Vec3 forward = Vec3.m_82498_(0.0F, yaw).m_82541_();
/* 326 */       Vec3 right = new Vec3(-forward.f_82481_, 0.0D, forward.f_82479_);
/* 327 */       Vec3 base = m_20182_().m_82549_(forward.m_82490_(forwardDist));
/*     */       
/* 329 */       LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntityLeft = new LowShadowHerobrineCloneEntity((EntityType<LowShadowHerobrineCloneEntity>)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (Level)pLevel.m_6018_());
/* 330 */       lowShadowHerobrineCloneEntityLeft.m_20219_(base.m_82546_(right.m_82490_(sideDist)));
/* 331 */       equipGearForLowClone(lowShadowHerobrineCloneEntityLeft, true);
/* 332 */       lowShadowHerobrineCloneEntityLeft.setProtectUUID(m_20148_());
/* 333 */       lowShadowHerobrineCloneEntityLeft.setProtectEntity(this);
/* 334 */       pLevel.m_6018_().m_7967_((Entity)lowShadowHerobrineCloneEntityLeft);
/*     */       
/* 336 */       LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntityMiddle = new LowShadowHerobrineCloneEntity((EntityType<LowShadowHerobrineCloneEntity>)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (Level)pLevel.m_6018_());
/* 337 */       lowShadowHerobrineCloneEntityMiddle.m_20219_(base);
/* 338 */       equipGearForLowClone(lowShadowHerobrineCloneEntityMiddle, false);
/* 339 */       lowShadowHerobrineCloneEntityMiddle.setProtectUUID(m_20148_());
/* 340 */       lowShadowHerobrineCloneEntityMiddle.setProtectEntity(this);
/* 341 */       lowShadowHerobrineCloneEntityMiddle.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.DIAMOND_SHEAR.get()));
/* 342 */       lowShadowHerobrineCloneEntityMiddle.m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN.get()));
/* 343 */       pLevel.m_6018_().m_7967_((Entity)lowShadowHerobrineCloneEntityMiddle);
/*     */       
/* 345 */       LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntityRight = new LowShadowHerobrineCloneEntity((EntityType<LowShadowHerobrineCloneEntity>)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (Level)pLevel.m_6018_());
/* 346 */       lowShadowHerobrineCloneEntityRight.m_20219_(base.m_82549_(right.m_82490_(sideDist)));
/* 347 */       equipGearForLowClone(lowShadowHerobrineCloneEntityRight, true);
/* 348 */       lowShadowHerobrineCloneEntityRight.setProtectUUID(m_20148_());
/* 349 */       lowShadowHerobrineCloneEntityRight.setProtectEntity(this);
/* 350 */       pLevel.m_6018_().m_7967_((Entity)lowShadowHerobrineCloneEntityRight);
/*     */       
/* 352 */       if (getPersistentData().m_128441_("FromElite") && getPersistentData().m_128461_("FromElite").equals("DemoniacVoltageReaver")) {
/* 353 */         ItemEntity itemEntity = new ItemEntity(m_9236_(), d0 + Mth.m_216263_(randomSource, -5.0D, 5.0D), d1, d2 + Mth.m_216263_(randomSource, -5.0D, 5.0D), new ItemStack((ItemLike)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER_FRAGMENT.get()));
/* 354 */         itemEntity.m_32010_(10);
/* 355 */         pLevel.m_7967_((Entity)itemEntity);
/*     */         
/* 357 */         ItemEntity itemEntity1 = new ItemEntity(m_9236_(), d0 + Mth.m_216263_(randomSource, -5.0D, 5.0D), d1, d2 + Mth.m_216263_(randomSource, -5.0D, 5.0D), new ItemStack((ItemLike)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER_FRAGMENT.get()));
/* 358 */         itemEntity1.m_32010_(10);
/* 359 */         pLevel.m_7967_((Entity)itemEntity1);
/*     */         
/* 361 */         ItemEntity itemEntity2 = new ItemEntity(m_9236_(), d0 + Mth.m_216263_(randomSource, -5.0D, 5.0D), d1, d2 + Mth.m_216263_(randomSource, -5.0D, 5.0D), new ItemStack((ItemLike)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER_FRAGMENT.get()));
/* 362 */         itemEntity2.m_32010_(10);
/* 363 */         pLevel.m_7967_((Entity)itemEntity2);
/*     */         
/* 365 */         ItemEntity itemEntity3 = new ItemEntity(m_9236_(), d0 + Mth.m_216263_(randomSource, -5.0D, 5.0D), d1, d2 + Mth.m_216263_(randomSource, -5.0D, 5.0D), new ItemStack((ItemLike)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER_BLADE.get()));
/* 366 */         itemEntity3.m_32010_(10);
/* 367 */         pLevel.m_7967_((Entity)itemEntity3);
/*     */       } 
/*     */       
/* 370 */       this.wardenCallingCooldown = 1200;
/*     */     } 
/* 372 */     return spawnGroupData;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6075_() {
/* 377 */     super.m_6075_();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6094_() {
/* 382 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7324_(@NotNull Entity other) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_7334_(@NotNull Entity other) {}
/*     */ 
/*     */   
/*     */   public void m_147240_(double strength, double x, double z) {}
/*     */ 
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 398 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 400 */     builder = builder.m_22268_(Attributes.f_22279_, 0.06D);
/* 401 */     builder = builder.m_22268_(Attributes.f_22276_, 20.0D);
/* 402 */     builder = builder.m_22268_(Attributes.f_22284_, 0.0D);
/* 403 */     builder = builder.m_22268_(Attributes.f_22281_, 1.0D);
/* 404 */     builder = builder.m_22268_(Attributes.f_22277_, 24.0D);
/* 405 */     builder = builder.m_22268_(Attributes.f_22278_, 1.0D);
/* 406 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\EliteHerobrineKnockedEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */