/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.clazz.NullWeapon;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumSet;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.control.FlyingMoveControl;
/*     */ import net.minecraft.world.entity.ai.control.MoveControl;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
/*     */ import net.minecraft.world.entity.ai.navigation.PathNavigation;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import se.gory_moon.player_mobs.utils.NameManager;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.Pose;
/*     */ import yesman.epicfight.api.animation.types.DirectStaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*     */ import yesman.epicfight.api.utils.math.Vec3f;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.gameasset.Armatures;
/*     */ import yesman.epicfight.model.armature.HumanoidArmature;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ 
/*     */ public class NullEntity
/*     */   extends HerobrineMob
/*     */ {
/*     */   private NullWeapon nullSwordEntity;
/*     */   private UUID nullSwordUUID;
/*     */   private NullWeapon nullAxeEntity;
/*     */   private UUID nullAxeUUID;
/*     */   private NullWeapon nullPickaxeEntity;
/*     */   private UUID nullPickaxeUUID;
/*     */   private NullWeapon nullShovelEntity;
/*     */   
/*     */   public boolean isAvailableWitherSkeletonSlot() {
/*  75 */     return (this.firstWitherSkeletonUuid == null || this.secondWitherSkeletonUuid == null);
/*     */   }
/*     */   private UUID nullShovelUUID; private NullWeapon nullHoeEntity; private UUID nullHoeUUID; private NullSkeletonEntity firstWitherSkeleton; private UUID firstWitherSkeletonUuid; private NullSkeletonEntity secondWitherSkeleton; private UUID secondWitherSkeletonUuid;
/*     */   public NullSkeletonEntity getFirstWitherSkeleton() {
/*  79 */     return this.firstWitherSkeleton;
/*     */   }
/*     */   
/*     */   public NullSkeletonEntity getSecondWitherSkeleton() {
/*  83 */     return this.secondWitherSkeleton;
/*     */   }
/*     */   
/*     */   public void claimWitherSkeletonSlot(NullSkeletonEntity witherSkeleton) {
/*  87 */     if (this.firstWitherSkeletonUuid == null) {
/*  88 */       this.firstWitherSkeletonUuid = witherSkeleton.m_20148_();
/*  89 */       this.firstWitherSkeleton = witherSkeleton;
/*     */     } else {
/*  91 */       this.secondWitherSkeletonUuid = witherSkeleton.m_20148_();
/*  92 */       this.secondWitherSkeleton = witherSkeleton;
/*     */     } 
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  98 */     return (SoundEvent)AnnoyingVillagersModSounds.NULL_SAY.get();
/*     */   }
/*     */   
/*     */   private boolean spawnNullWeapon = false;
/*     */   
/*     */   public NullWeapon getNullSwordEntity() {
/* 104 */     return this.nullSwordEntity;
/*     */   }
/*     */   
/*     */   public NullWeapon getNullAxeEntity() {
/* 108 */     return this.nullAxeEntity;
/*     */   }
/*     */   
/*     */   public NullWeapon getNullPickaxeEntity() {
/* 112 */     return this.nullPickaxeEntity;
/*     */   }
/*     */   
/*     */   public NullWeapon getNullShovelEntity() {
/* 116 */     return this.nullShovelEntity;
/*     */   }
/*     */   
/*     */   public NullWeapon getNullHoeEntity() {
/* 120 */     return this.nullHoeEntity;
/*     */   }
/*     */   
/*     */   public void setNullWeapon(String slot, NullWeapon nullWeapon) {
/* 124 */     switch (slot) {
/*     */       case "sword":
/* 126 */         this.nullSwordUUID = nullWeapon.m_20148_();
/* 127 */         this.nullSwordEntity = nullWeapon;
/*     */         return;
/*     */       case "pickaxe":
/* 130 */         this.nullPickaxeUUID = nullWeapon.m_20148_();
/* 131 */         this.nullPickaxeEntity = nullWeapon;
/*     */         return;
/*     */       case "axe":
/* 134 */         this.nullAxeUUID = nullWeapon.m_20148_();
/* 135 */         this.nullAxeEntity = nullWeapon;
/*     */         return;
/*     */       case "hoe":
/* 138 */         this.nullHoeUUID = nullWeapon.m_20148_();
/* 139 */         this.nullHoeEntity = nullWeapon;
/*     */         return;
/*     */     } 
/* 142 */     this.nullShovelUUID = nullWeapon.m_20148_();
/* 143 */     this.nullShovelEntity = nullWeapon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NullEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/* 149 */     this((EntityType<NullEntity>)AnnoyingVillagersModEntities.NULL.get(), level);
/*     */   }
/*     */   
/*     */   public NullEntity(EntityType<NullEntity> entitytype, Level level) {
/* 153 */     super(entitytype, level);
/* 154 */     m_274367_(3.0F);
/* 155 */     this.f_21364_ = 80;
/* 156 */     m_21557_(false);
/* 157 */     m_21530_();
/* 158 */     this.f_21342_ = (MoveControl)new FlyingMoveControl((Mob)this, 10, true);
/* 159 */     setChatName("§5Null§r");
/* 160 */     m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_WEAPON.get()));
/*     */   }
/*     */   @NotNull
/*     */   protected PathNavigation m_6037_(@NotNull Level level) {
/* 164 */     return (PathNavigation)new FlyingPathNavigation((Mob)this, level);
/*     */   }
/*     */   
/*     */   public void releaseRandomWeapons(int stack) {
/* 168 */     if (stack <= 0)
/* 169 */       return;  List<NullWeapon> weapons = new ArrayList<>(5);
/*     */     
/* 171 */     if (this.nullSwordEntity != null) weapons.add(this.nullSwordEntity); 
/* 172 */     if (this.nullAxeEntity != null) weapons.add(this.nullAxeEntity); 
/* 173 */     if (this.nullPickaxeEntity != null) weapons.add(this.nullPickaxeEntity); 
/* 174 */     if (this.nullShovelEntity != null) weapons.add(this.nullShovelEntity); 
/* 175 */     if (this.nullHoeEntity != null) weapons.add(this.nullHoeEntity);
/*     */     
/* 177 */     if (weapons.isEmpty())
/* 178 */       return;  Collections.shuffle(weapons, new Random());
/* 179 */     for (int i = 0; i < Math.min(stack, weapons.size()); i++) {
/* 180 */       ((NullWeapon)weapons.get(i)).releaseForAWhile();
/*     */     }
/*     */   }
/*     */   
/*     */   public void randomlyParryWithWeapon(ServerLevel serverLevel, Entity attacker) {
/* 185 */     List<NullWeapon> weapons = new ArrayList<>(5);
/* 186 */     if (this.nullSwordEntity != null && !this.nullSwordEntity.isReleased()) weapons.add(this.nullSwordEntity); 
/* 187 */     if (this.nullAxeEntity != null && !this.nullAxeEntity.isReleased()) weapons.add(this.nullAxeEntity); 
/* 188 */     if (this.nullPickaxeEntity != null && !this.nullPickaxeEntity.isReleased()) weapons.add(this.nullPickaxeEntity); 
/* 189 */     if (this.nullShovelEntity != null && !this.nullShovelEntity.isReleased()) weapons.add(this.nullShovelEntity); 
/* 190 */     if (this.nullHoeEntity != null && !this.nullHoeEntity.isReleased()) weapons.add(this.nullHoeEntity);
/*     */     
/* 192 */     if (weapons.isEmpty())
/* 193 */       return;  NullWeapon chosen = weapons.get(m_217043_().m_188503_(weapons.size()));
/* 194 */     EpicfightUtil.damageBlockedForce((Entity)chosen, attacker, serverLevel);
/* 195 */     chosen.m_6027_(m_20185_(), m_20186_(), m_20189_());
/* 196 */     chosen.spinfor5seconds();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSpinningToAllWeaponsAvailable(boolean spinning) {
/* 201 */     setSpinningIfAvailable(this.nullSwordEntity, spinning);
/* 202 */     setSpinningIfAvailable(this.nullAxeEntity, spinning);
/* 203 */     setSpinningIfAvailable(this.nullPickaxeEntity, spinning);
/* 204 */     setSpinningIfAvailable(this.nullShovelEntity, spinning);
/* 205 */     setSpinningIfAvailable(this.nullHoeEntity, spinning);
/*     */   }
/*     */   
/*     */   public void setSpinningToAllWeaponsAvailableFor5seconds() {
/* 209 */     setSpinningFor5SecondsIfAvailable(this.nullSwordEntity);
/* 210 */     setSpinningFor5SecondsIfAvailable(this.nullAxeEntity);
/* 211 */     setSpinningFor5SecondsIfAvailable(this.nullPickaxeEntity);
/* 212 */     setSpinningFor5SecondsIfAvailable(this.nullShovelEntity);
/* 213 */     setSpinningFor5SecondsIfAvailable(this.nullHoeEntity);
/*     */   }
/*     */   
/*     */   private static void setSpinningIfAvailable(NullWeapon weapon, boolean spinning) {
/* 217 */     if (weapon == null)
/* 218 */       return;  if (weapon.isReleased())
/* 219 */       return;  weapon.setSpinning(spinning);
/*     */   }
/*     */   
/*     */   private static void setSpinningFor5SecondsIfAvailable(NullWeapon weapon) {
/* 223 */     if (weapon == null)
/* 224 */       return;  if (weapon.isReleased()) weapon.stopRelease(); 
/* 225 */     weapon.spinfor5seconds();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 230 */     super.m_7380_(tag);
/* 231 */     if (this.nullSwordUUID != null) {
/* 232 */       tag.m_128362_("NullSwordUUID", this.nullSwordUUID);
/*     */     }
/* 234 */     if (this.nullAxeUUID != null) {
/* 235 */       tag.m_128362_("NullAxeUUID", this.nullAxeUUID);
/*     */     }
/* 237 */     if (this.nullPickaxeUUID != null) {
/* 238 */       tag.m_128362_("NullPickaxeUUID", this.nullPickaxeUUID);
/*     */     }
/* 240 */     if (this.nullShovelUUID != null) {
/* 241 */       tag.m_128362_("NullShovelUUID", this.nullShovelUUID);
/*     */     }
/* 243 */     if (this.nullHoeUUID != null) {
/* 244 */       tag.m_128362_("NullHoeUUID", this.nullHoeUUID);
/*     */     }
/* 246 */     if (this.firstWitherSkeletonUuid != null) {
/* 247 */       tag.m_128362_("FirstWitherSkeletonUuid", this.firstWitherSkeletonUuid);
/*     */     }
/* 249 */     if (this.secondWitherSkeletonUuid != null) {
/* 250 */       tag.m_128362_("SecondWitherSkeletonUuid", this.secondWitherSkeletonUuid);
/*     */     }
/* 252 */     tag.m_128379_("SpawnNullWeapon", this.spawnNullWeapon);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 257 */     super.m_7378_(tag);
/* 258 */     if (tag.m_128403_("NullSwordUUID")) {
/* 259 */       this.nullSwordUUID = tag.m_128342_("NullSwordUUID");
/*     */     }
/* 261 */     if (tag.m_128403_("NullAxeUUID")) {
/* 262 */       this.nullAxeUUID = tag.m_128342_("NullAxeUUID");
/*     */     }
/* 264 */     if (tag.m_128403_("NullPickaxeUUID")) {
/* 265 */       this.nullPickaxeUUID = tag.m_128342_("NullPickaxeUUID");
/*     */     }
/* 267 */     if (tag.m_128403_("NullShovelUUID")) {
/* 268 */       this.nullShovelUUID = tag.m_128342_("NullShovelUUID");
/*     */     }
/* 270 */     if (tag.m_128403_("NullHoeUUID")) {
/* 271 */       this.nullHoeUUID = tag.m_128342_("NullHoeUUID");
/*     */     }
/* 273 */     if (tag.m_128403_("FirstWitherSkeletonUuid")) {
/* 274 */       this.firstWitherSkeletonUuid = tag.m_128342_("FirstWitherSkeletonUuid");
/*     */     }
/* 276 */     if (tag.m_128403_("SecondWitherSkeletonUuid")) {
/* 277 */       this.secondWitherSkeletonUuid = tag.m_128342_("SecondWitherSkeletonUuid");
/*     */     }
/* 279 */     this.spawnNullWeapon = tag.m_128471_("SpawnNullWeapon");
/*     */   }
/*     */   
/*     */   private void initialSpawn() {
/* 283 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 284 */       NullWeapon nullSwordEntity = new NullSwordEntity((EntityType<NullSwordEntity>)AnnoyingVillagersModEntities.NULL_SWORD.get(), (Level)serverLevel);
/* 285 */       nullSwordEntity.summonNullWeaponForNullEntity(serverLevel, this, "sword");
/*     */       
/* 287 */       NullWeapon nullAxeEntity = new NullAxeEntity((EntityType<NullAxeEntity>)AnnoyingVillagersModEntities.NULL_AXE.get(), (Level)serverLevel);
/* 288 */       nullAxeEntity.summonNullWeaponForNullEntity(serverLevel, this, "axe");
/*     */       
/* 290 */       NullWeapon nullPickaxeEntity = new NullPickaxeEntity((EntityType<NullPickaxeEntity>)AnnoyingVillagersModEntities.NULL_PICKAXE.get(), (Level)serverLevel);
/* 291 */       nullPickaxeEntity.summonNullWeaponForNullEntity(serverLevel, this, "pickaxe");
/*     */       
/* 293 */       NullWeapon nullShovelEntity = new NullShovelEntity((EntityType<NullShovelEntity>)AnnoyingVillagersModEntities.NULL_SHOVEL.get(), (Level)serverLevel);
/* 294 */       nullShovelEntity.summonNullWeaponForNullEntity(serverLevel, this, "shovel");
/*     */       
/* 296 */       NullWeapon nullHoeEntity = new NullHoeEntity((EntityType<NullHoeEntity>)AnnoyingVillagersModEntities.NULL_HOE.get(), (Level)serverLevel);
/* 297 */       nullHoeEntity.summonNullWeaponForNullEntity(serverLevel, this, "hoe"); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 303 */     super.m_8119_();
/*     */     
/* 305 */     if (!m_9236_().m_5776_()) {
/* 306 */       if (!this.spawnNullWeapon) {
/* 307 */         this.spawnNullWeapon = true;
/* 308 */         initialSpawn();
/* 309 */       } else if (this.f_19797_ == 20 && getLivingEntityPatch() != null) {
/* 310 */         getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.CLONE_ANTITHEUS_ASCENSION, 0.0F);
/*     */       } 
/*     */       
/* 313 */       if (this.nullSwordEntity == null && this.nullSwordUUID != null) {
/* 314 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.nullSwordUUID);
/* 315 */         if (entity instanceof NullWeapon) { NullWeapon nullSword = (NullWeapon)entity;
/* 316 */           this.nullSwordEntity = nullSword; }
/*     */         else
/* 318 */         { this.nullSwordUUID = null; }
/*     */       
/*     */       } 
/* 321 */       if (this.nullAxeEntity == null && this.nullAxeUUID != null) {
/* 322 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.nullAxeUUID);
/* 323 */         if (entity instanceof NullWeapon) { NullWeapon nullAxe = (NullWeapon)entity;
/* 324 */           this.nullAxeEntity = nullAxe; }
/*     */         else
/* 326 */         { this.nullAxeUUID = null; }
/*     */       
/*     */       } 
/* 329 */       if (this.nullPickaxeEntity == null && this.nullPickaxeUUID != null) {
/* 330 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.nullPickaxeUUID);
/* 331 */         if (entity instanceof NullWeapon) { NullWeapon nullPickaxe = (NullWeapon)entity;
/* 332 */           this.nullPickaxeEntity = nullPickaxe; }
/*     */         else
/* 334 */         { this.nullPickaxeUUID = null; }
/*     */       
/*     */       } 
/* 337 */       if (this.nullShovelEntity == null && this.nullShovelUUID != null) {
/* 338 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.nullShovelUUID);
/* 339 */         if (entity instanceof NullWeapon) { NullWeapon nullShovel = (NullWeapon)entity;
/* 340 */           this.nullShovelEntity = nullShovel; }
/*     */         else
/* 342 */         { this.nullShovelUUID = null; }
/*     */       
/*     */       } 
/* 345 */       if (this.nullHoeEntity == null && this.nullHoeUUID != null) {
/* 346 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.nullHoeUUID);
/* 347 */         if (entity instanceof NullWeapon) { NullWeapon nullHoe = (NullWeapon)entity;
/* 348 */           this.nullHoeEntity = nullHoe; }
/*     */         else
/* 350 */         { this.nullHoeUUID = null; }
/*     */       
/*     */       } 
/*     */       
/* 354 */       if (this.firstWitherSkeleton == null && this.firstWitherSkeletonUuid != null) {
/* 355 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.firstWitherSkeletonUuid);
/* 356 */         if (entity instanceof NullSkeletonEntity) { NullSkeletonEntity witherSkeleton = (NullSkeletonEntity)entity;
/* 357 */           this.firstWitherSkeleton = witherSkeleton; }
/*     */         else
/* 359 */         { this.firstWitherSkeletonUuid = null; }
/*     */       
/*     */       } 
/* 362 */       if (this.secondWitherSkeleton == null && this.secondWitherSkeletonUuid != null) {
/* 363 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.secondWitherSkeletonUuid);
/* 364 */         if (entity instanceof NullSkeletonEntity) { NullSkeletonEntity witherSkeleton = (NullSkeletonEntity)entity;
/* 365 */           this.secondWitherSkeleton = witherSkeleton; }
/*     */         else
/* 367 */         { this.secondWitherSkeletonUuid = null; }
/*     */       
/*     */       } 
/*     */       
/* 371 */       if (this.firstWitherSkeleton != null && !this.firstWitherSkeleton.m_6084_()) {
/* 372 */         this.firstWitherSkeleton = null;
/* 373 */         this.firstWitherSkeletonUuid = null;
/*     */       } 
/* 375 */       if (this.secondWitherSkeleton != null && !this.secondWitherSkeleton.m_6084_()) {
/* 376 */         this.secondWitherSkeleton = null;
/* 377 */         this.secondWitherSkeletonUuid = null;
/*     */       } 
/*     */       
/* 380 */       if (this.f_19797_ % 10 == 0 && this.f_19797_ >= 20) {
/* 381 */         if (this.nullSwordEntity != null) {
/* 382 */           this.nullSwordEntity.processTeleportByNullEntity();
/*     */         }
/* 384 */         if (this.nullAxeEntity != null) {
/* 385 */           this.nullAxeEntity.processTeleportByNullEntity();
/*     */         }
/* 387 */         if (this.nullPickaxeEntity != null) {
/* 388 */           this.nullPickaxeEntity.processTeleportByNullEntity();
/*     */         }
/* 390 */         if (this.nullHoeEntity != null) {
/* 391 */           this.nullHoeEntity.processTeleportByNullEntity();
/*     */         }
/* 393 */         if (this.nullShovelEntity != null) {
/* 394 */           this.nullShovelEntity.processTeleportByNullEntity();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/* 401 */     super.m_8099_();
/* 402 */     this.f_21345_.m_25352_(24, new Goal()
/*     */         {
/*     */ 
/*     */           
/*     */           public boolean m_8036_()
/*     */           {
/* 408 */             return (NullEntity.this.m_5448_() != null && !NullEntity.this.m_21566_().m_24995_());
/*     */           }
/*     */           
/*     */           public boolean m_8045_() {
/* 412 */             return (NullEntity.this.m_21566_().m_24995_() && NullEntity.this.m_5448_() != null && NullEntity.this.m_5448_().m_6084_());
/*     */           }
/*     */           
/*     */           public void m_8056_() {
/* 416 */             LivingEntity livingEntity = NullEntity.this.m_5448_();
/* 417 */             if (livingEntity != null) {
/* 418 */               Vec3 vec3 = livingEntity.m_20299_(1.0F);
/* 419 */               NullEntity.this.f_21342_.m_6849_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, 1.0D);
/*     */             } 
/*     */           }
/*     */           
/*     */           public void m_8037_() {
/* 424 */             LivingEntity livingEntity = NullEntity.this.m_5448_();
/*     */             
/* 426 */             if (livingEntity != null) {
/* 427 */               if (NullEntity.this.m_20191_().m_82381_(livingEntity.m_20191_())) {
/* 428 */                 NullEntity.this.m_7327_((Entity)livingEntity);
/*     */               } else {
/* 430 */                 double d0 = NullEntity.this.m_20280_((Entity)livingEntity);
/* 431 */                 if (d0 < 16.0D) {
/* 432 */                   Vec3 vec3 = livingEntity.m_20299_(1.0F);
/* 433 */                   NullEntity.this.f_21342_.m_6849_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, 5.0D);
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public boolean m_142535_(float f, float f1, @NotNull DamageSource damagesource) {
/* 442 */     return false;
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/* 446 */     if (damageSource.m_276093_(DamageTypes.f_268671_)) return false; 
/* 447 */     if (damageSource.m_276093_(DamageTypes.f_268585_)) return false; 
/* 448 */     if (damageSource.m_276093_(DamageTypes.f_268493_)) return false; 
/* 449 */     if (damageSource.m_276093_(DamageTypes.f_268722_)) return false; 
/* 450 */     if (damageSource.m_276093_(DamageTypes.f_268641_)) return false; 
/* 451 */     if (damageSource.m_276093_(DamageTypes.f_268482_)) return false; 
/* 452 */     if (damageSource.m_276093_(DamageTypes.f_268468_)) return false; 
/* 453 */     if (damageSource.m_276093_(DamageTypes.f_268631_)) return false; 
/* 454 */     if (!(damageSource.m_7640_() instanceof EnchantedArrowEntity) && damageSource
/* 455 */       .m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow && 
/* 456 */       !(damageSource.m_7640_() instanceof BlueDemonThrownTridentEntity)) return false; 
/* 457 */     if ((new Random()).nextFloat() <= ((getState() == 2) ? 0.5F : 0.25F)) {
/* 458 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 459 */         randomlyParryWithWeapon(serverLevel, damageSource.m_7639_()); }
/*     */       
/* 461 */       return false;
/*     */     } 
/* 463 */     return super.m_6469_(damageSource, f);
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damagesource) {
/* 467 */     super.m_6667_(damagesource);
/* 468 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 469 */       if (this.nullSwordEntity != null) {
/* 470 */         this.nullSwordEntity.m_142687_(Entity.RemovalReason.KILLED);
/*     */       }
/* 472 */       if (this.nullAxeEntity != null) {
/* 473 */         this.nullAxeEntity.m_142687_(Entity.RemovalReason.KILLED);
/*     */       }
/* 475 */       if (this.nullHoeEntity != null) {
/* 476 */         this.nullHoeEntity.m_142687_(Entity.RemovalReason.KILLED);
/*     */       }
/* 478 */       if (this.nullShovelEntity != null) {
/* 479 */         this.nullShovelEntity.m_142687_(Entity.RemovalReason.KILLED);
/*     */       }
/* 481 */       if (this.nullPickaxeEntity != null) {
/* 482 */         this.nullPickaxeEntity.m_142687_(Entity.RemovalReason.KILLED);
/*     */       }
/*     */       
/* 485 */       InfectedPlayerNpcEntity corpse = new InfectedPlayerNpcEntity((EntityType<? extends InfectedPlayerNpcEntity>)AnnoyingVillagersModEntities.INFECTED_PLAYER_NPC.get(), (Level)serverLevel);
/* 486 */       corpse.m_7678_(m_20185_(), m_20186_(), m_20189_(), m_146908_(), m_146909_());
/* 487 */       String killedName = getPersistentData().m_128461_("killed_name");
/* 488 */       corpse.getPersistentData().m_128359_("possessed_by", "null");
/* 489 */       if (killedName.isEmpty()) {
/* 490 */         killedName = String.valueOf(NameManager.INSTANCE.getRandomName());
/*     */       }
/* 492 */       corpse.setUsername(killedName);
/* 493 */       corpse.m_6593_((Component)Component.m_237113_(killedName));
/* 494 */       corpse.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*     */       
/* 496 */       m_6842_(true);
/* 497 */       m_142687_(Entity.RemovalReason.KILLED);
/* 498 */       serverLevel.m_7967_((Entity)corpse); }
/*     */   
/*     */   }
/*     */   
/*     */   public void m_6075_() {
/* 503 */     super.m_6075_();
/* 504 */     if (m_9236_() instanceof ServerLevel) {
/* 505 */       AssetAccessor assetAccessor; LivingEntityPatch<?> livingEntityPatch = getLivingEntityPatch();
/* 506 */       DirectStaticAnimation directStaticAnimation = Animations.EMPTY_ANIMATION;
/* 507 */       if (livingEntityPatch != null) {
/* 508 */         AnimationPlayer animationPlayer = livingEntityPatch.getAnimator().getPlayerFor(null);
/* 509 */         if (animationPlayer != null) {
/* 510 */           assetAccessor = animationPlayer.getRealAnimation();
/*     */         }
/*     */       } 
/*     */       
/* 514 */       if (m_5448_() == null || EpicfightUtil.isLongHitAnimation(assetAccessor, getLivingEntityPatch()) || getLivingEntityPatch().isStunned() || assetAccessor.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation) {
/* 515 */         m_21573_().m_26573_();
/* 516 */         m_20256_(Vec3.f_82478_);
/*     */       } else {
/* 518 */         m_20256_(new Vec3((m_20154_()).f_82479_ * 0.2D, (m_20154_()).f_82480_ * 0.2D, (m_20154_()).f_82481_ * 0.2D));
/*     */       } 
/*     */     } else {
/* 521 */       if (getLivingEntityPatch() == null)
/* 522 */         return;  if (getLivingEntityPatch().getAnimator() == null)
/* 523 */         return;  if (getLivingEntityPatch().getArmature() == null)
/* 524 */         return;  if (Armatures.BIPED.get() == null || ((HumanoidArmature)Armatures.BIPED.get()).toolL == null)
/* 525 */         return;  if (getLivingEntityPatch().getOriginal() == null)
/*     */         return; 
/* 527 */       byte poseSampleCount = 3;
/* 528 */       float poseStep = 1.0F / (poseSampleCount - 1);
/* 529 */       float poseProgress = 0.0F;
/*     */ 
/*     */ 
/*     */       
/*     */       int poseSampleIndex;
/*     */ 
/*     */       
/* 536 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/*     */         Pose pose;
/*     */         try {
/* 539 */           pose = getLivingEntityPatch().getAnimator().getPose(poseProgress);
/* 540 */         } catch (Throwable t) {
/*     */           return;
/*     */         } 
/* 543 */         if (pose == null) {
/*     */           return;
/*     */         }
/* 546 */         OpenMatrix4f toolLeftTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(pose, ((HumanoidArmature)Armatures.BIPED.get()).toolL);
/*     */         
/* 548 */         if (toolLeftTransform == null) {
/* 549 */           poseProgress += poseStep;
/*     */         }
/*     */         else {
/*     */           
/* 553 */           toolLeftTransform = new OpenMatrix4f(toolLeftTransform);
/* 554 */           toolLeftTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 555 */           OpenMatrix4f.mul((new OpenMatrix4f())
/* 556 */               .rotate(
/* 557 */                 -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), toolLeftTransform, toolLeftTransform);
/*     */ 
/*     */ 
/*     */           
/*     */           int i;
/*     */ 
/*     */           
/* 564 */           for (i = 0; i < 1; i++) {
/* 565 */             ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 566 */                 .get(), toolLeftTransform.m30 + ((LivingEntity)
/* 567 */                 getLivingEntityPatch().getOriginal()).m_20185_(), toolLeftTransform.m31 + ((LivingEntity)
/* 568 */                 getLivingEntityPatch().getOriginal()).m_20186_(), toolLeftTransform.m32 + ((LivingEntity)
/* 569 */                 getLivingEntityPatch().getOriginal()).m_20189_(), (((new Random())
/* 570 */                 .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 571 */                 .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 572 */                 .nextFloat() - 0.5F) * 0.15F));
/*     */           }
/*     */ 
/*     */           
/* 576 */           for (i = 0; i < 1; i++) {
/* 577 */             ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 578 */                 .get(), toolLeftTransform.m30 + ((LivingEntity)
/* 579 */                 getLivingEntityPatch().getOriginal()).m_20185_(), toolLeftTransform.m31 + ((LivingEntity)
/* 580 */                 getLivingEntityPatch().getOriginal()).m_20186_(), toolLeftTransform.m32 + ((LivingEntity)
/* 581 */                 getLivingEntityPatch().getOriginal()).m_20189_(), 0.0D, 0.0D, 0.0D);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 586 */           poseProgress += poseStep;
/*     */         } 
/*     */       } 
/* 589 */       poseProgress = 0.0F;
/*     */       
/* 591 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 592 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 593 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 594 */             .get()).toolR);
/*     */         
/* 596 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 1.8F));
/* 597 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 598 */             .rotate(
/* 599 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 605 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, -((new Random()).nextFloat() * 4.0F)));
/*     */         
/* 607 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 608 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 609 */             getLivingEntityPatch().getOriginal()).m_20185_(), jointTransform.m31 + ((LivingEntity)
/* 610 */             getLivingEntityPatch().getOriginal()).m_20186_(), jointTransform.m32 + ((LivingEntity)
/* 611 */             getLivingEntityPatch().getOriginal()).m_20189_(), (((new Random())
/* 612 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 613 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 614 */             .nextFloat() - 0.5F) * 0.15F));
/*     */         
/* 616 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 617 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 618 */             getLivingEntityPatch().getOriginal()).m_20185_(), jointTransform.m31 + ((LivingEntity)
/* 619 */             getLivingEntityPatch().getOriginal()).m_20186_(), jointTransform.m32 + ((LivingEntity)
/* 620 */             getLivingEntityPatch().getOriginal()).m_20189_(), 0.0D, 0.0D, 0.0D);
/*     */ 
/*     */ 
/*     */         
/* 624 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 627 */       for (int particleIndex = 0; particleIndex < 14; particleIndex++) {
/* 628 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 629 */             .get(), ((LivingEntity)
/* 630 */             getLivingEntityPatch().getOriginal()).m_20185_(), ((LivingEntity)
/* 631 */             getLivingEntityPatch().getOriginal()).m_20186_() + 0.029999999329447746D, ((LivingEntity)
/* 632 */             getLivingEntityPatch().getOriginal()).m_20189_(), (((new Random())
/* 633 */             .nextFloat() - 0.5F) * 0.65F), (((new Random())
/* 634 */             .nextFloat() - 0.5F) * 0.05F), (((new Random())
/* 635 */             .nextFloat() - 0.5F) * 0.65F));
/*     */       }
/*     */ 
/*     */       
/* 639 */       poseStep = 1.0F;
/* 640 */       poseProgress = 0.0F;
/*     */       
/* 642 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 643 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 644 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 645 */             .get()).head);
/*     */         
/* 647 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 648 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 649 */             .rotate(
/* 650 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 657 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 658 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 659 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 660 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() + 0.1F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 661 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 662 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 663 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 664 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 667 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 670 */       poseProgress = 0.0F;
/*     */       
/* 672 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 673 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 674 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 675 */             .get()).chest);
/*     */         
/* 677 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 678 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 679 */             .rotate(
/* 680 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 687 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 688 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 689 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 690 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 691 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 692 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 693 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 694 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 697 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 700 */       poseProgress = 0.0F;
/*     */       
/* 702 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 703 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 704 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 705 */             .get()).armL);
/*     */         
/* 707 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 708 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 709 */             .rotate(
/* 710 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 717 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 718 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 719 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 720 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 721 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 722 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 723 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 724 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 727 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 730 */       poseProgress = 0.0F;
/*     */       
/* 732 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 733 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 734 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 735 */             .get()).armR);
/*     */         
/* 737 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 738 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 739 */             .rotate(
/* 740 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 747 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 748 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 749 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 750 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 751 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 752 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 753 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 754 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 757 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 760 */       poseProgress = 0.0F;
/*     */       
/* 762 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 763 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 764 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 765 */             .get()).torso);
/*     */         
/* 767 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 768 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 769 */             .rotate(
/* 770 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 777 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 778 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 779 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 780 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 781 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 782 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 783 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 784 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 787 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 790 */       poseProgress = 0.0F;
/*     */       
/* 792 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 793 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 794 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 795 */             .get()).thighL);
/*     */         
/* 797 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 798 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 799 */             .rotate(
/* 800 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 807 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 808 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 809 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 810 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 811 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 812 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 813 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 814 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 817 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 820 */       poseProgress = 0.0F;
/*     */       
/* 822 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 823 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 824 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 825 */             .get()).thighR);
/*     */         
/* 827 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 828 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 829 */             .rotate(
/* 830 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 837 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 838 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 839 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 840 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 841 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 842 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 843 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 844 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 847 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 850 */       poseProgress = 0.0F;
/*     */       
/* 852 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 853 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 854 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 855 */             .get()).legL);
/*     */         
/* 857 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 858 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 859 */             .rotate(
/* 860 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 867 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 868 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 869 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 870 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 871 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 872 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 873 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 874 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 877 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 880 */       poseProgress = 0.0F;
/*     */       
/* 882 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 883 */         OpenMatrix4f jointTransform = getLivingEntityPatch().getArmature().getBoundTransformFor(
/* 884 */             getLivingEntityPatch().getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 885 */             .get()).legR);
/*     */         
/* 887 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 888 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 889 */             .rotate(
/* 890 */               -((float)Math.toRadians((((LivingEntity)getLivingEntityPatch().getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 897 */         ((LivingEntity)getLivingEntityPatch().getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 898 */             .get(), jointTransform.m30 + ((LivingEntity)
/* 899 */             getLivingEntityPatch().getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)
/* 900 */             getLivingEntityPatch().getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)
/* 901 */             getLivingEntityPatch().getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 902 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 903 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 904 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 907 */         poseProgress += poseStep;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void m_7840_(double d0, boolean flag, @NotNull BlockState blockstate, @NotNull BlockPos blockpos) {}
/*     */   
/*     */   public void m_20242_(boolean flag) {
/* 915 */     super.m_20242_(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_142687_(@NotNull Entity.RemovalReason pReason) {
/* 920 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (pReason.equals(Entity.RemovalReason.DISCARDED)) {
/* 921 */         if (this.nullSwordEntity != null) {
/* 922 */           this.nullSwordEntity.m_142687_(Entity.RemovalReason.DISCARDED);
/*     */         }
/* 924 */         if (this.nullAxeEntity != null) {
/* 925 */           this.nullAxeEntity.m_142687_(Entity.RemovalReason.DISCARDED);
/*     */         }
/* 927 */         if (this.nullHoeEntity != null) {
/* 928 */           this.nullHoeEntity.m_142687_(Entity.RemovalReason.DISCARDED);
/*     */         }
/* 930 */         if (this.nullShovelEntity != null) {
/* 931 */           this.nullShovelEntity.m_142687_(Entity.RemovalReason.DISCARDED);
/*     */         }
/* 933 */         if (this.nullPickaxeEntity != null)
/* 934 */           this.nullPickaxeEntity.m_142687_(Entity.RemovalReason.DISCARDED); 
/*     */       }  }
/*     */     
/* 937 */     super.m_142687_(pReason);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 941 */     return Mob.m_21552_()
/* 942 */       .m_22268_(Attributes.f_22276_, 250.0D)
/* 943 */       .m_22268_(Attributes.f_22279_, 3.0D)
/* 944 */       .m_22268_(Attributes.f_22280_, 3.0D)
/* 945 */       .m_22268_(Attributes.f_22281_, 10.0D)
/* 946 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 947 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 948 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 949 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 950 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 951 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 952 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 953 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 954 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 955 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\NullEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */