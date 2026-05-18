/*     */ package com.pla.annoyingvillagers.clazz;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.CombatCommon;
/*     */ import com.pla.annoyingvillagers.entity.goal.LockedRandomStrollGoal;
/*     */ import com.pla.annoyingvillagers.entity.goal.PlayIdleAnimationGoal;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.SimpleContainer;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*     */ import net.minecraft.world.entity.projectile.ProjectileUtil;
/*     */ import net.minecraft.world.item.BowItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.ProjectileWeaponItem;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ public class AVNpc extends PathfinderMob implements RangedAttackMob, BurstProtectEntity, CombatVoiceLineEntity {
/*  48 */   private final SimpleContainer inventory = new SimpleContainer(27);
/*     */   private int gapCooldown;
/*     */   private int enderPearlCooldown;
/*  51 */   private int swapToBowCooldown = 0;
/*  52 */   private ItemStack mainWeaponItem = ItemStack.f_41583_;
/*  53 */   private ItemStack offWeaponItem = ItemStack.f_41583_;
/*     */   private boolean healing = false;
/*     */   private boolean initialSpawn = false;
/*     */   private boolean useBow = true;
/*  57 */   private Entity blockDamage = null;
/*     */   private double placeBlockToParryChance;
/*     */   private boolean swapBackToBow = false;
/*  60 */   private int stunEscapeCooldown = 0; @Nullable
/*     */   private IdleAnimation idleAnimationChoice;
/*     */   @Nullable
/*     */   private AssetAccessor<? extends StaticAnimation> idleAnimationAsset;
/*     */   private boolean idleMessageBroadcast = false;
/*     */   private boolean playingIdle;
/*  66 */   private int playingIdleCooldown = 1200;
/*     */   private boolean isStrolling;
/*  68 */   private int efnGuardHitState = 0;
/*  69 */   private int efnGuardHitCooldown = 0;
/*     */   
/*  71 */   protected float recentDamageTaken = 0.0F;
/*  72 */   protected int recentHitCounter = 0;
/*     */   
/*     */   public float getRecentDamageTaken() {
/*  75 */     return this.recentDamageTaken;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRecentDamageTaken(float value) {
/*  80 */     this.recentDamageTaken = value;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecentHitCounter() {
/*  85 */     return this.recentHitCounter;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRecentHitCounter(int value) {
/*  90 */     this.recentHitCounter = value;
/*     */   }
/*     */   
/*     */   public int getEfnGuardHitState() {
/*  94 */     return this.efnGuardHitState;
/*     */   }
/*     */   
/*  97 */   private int voiceCooldown = 0;
/*     */ 
/*     */   
/*     */   public int getVoiceCooldown() {
/* 101 */     return this.voiceCooldown;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVoiceCooldown(int cooldown) {
/* 106 */     this.voiceCooldown = cooldown;
/*     */   }
/*     */   
/*     */   public void postPlayEfnGuardHit() {
/* 110 */     if (this.efnGuardHitState == 2) {
/* 111 */       this.efnGuardHitState = 0;
/*     */     } else {
/* 113 */       this.efnGuardHitState++;
/*     */     } 
/* 115 */     this.efnGuardHitCooldown = 100;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStrolling() {
/* 120 */     return this.isStrolling;
/*     */   }
/*     */   
/*     */   public void setStrolling(boolean strolling) {
/* 124 */     this.isStrolling = strolling;
/*     */   }
/*     */   
/*     */   public boolean isPlayingIdle() {
/* 128 */     return this.playingIdle;
/*     */   }
/*     */   
/*     */   public void setPlayingIdle(boolean playingIdle) {
/* 132 */     this.playingIdle = playingIdle;
/*     */   }
/*     */   
/*     */   public int getPlayingIdleCooldown() {
/* 136 */     return this.playingIdleCooldown;
/*     */   }
/*     */   
/*     */   public void setPlayingIdleCooldown(int playingIdleCooldown) {
/* 140 */     this.playingIdleCooldown = playingIdleCooldown;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public IdleAnimation getIdleAnimationChoice() {
/* 145 */     return this.idleAnimationChoice;
/*     */   }
/*     */   
/*     */   public void setIdleAnimationChoice(@Nullable IdleAnimation choice) {
/* 149 */     this.idleAnimationChoice = choice;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public AssetAccessor<? extends StaticAnimation> getIdleAnimation() {
/* 154 */     return this.idleAnimationAsset;
/*     */   }
/*     */   
/*     */   public void setIdleAnimation(@Nullable AssetAccessor<? extends StaticAnimation> anim) {
/* 158 */     this.idleAnimationAsset = anim;
/*     */   }
/*     */   
/*     */   public boolean isIdleMessageBroadcast() {
/* 162 */     return this.idleMessageBroadcast;
/*     */   }
/*     */   
/*     */   public void setIdleMessageBroadcast(boolean idleMessageBroadcast) {
/* 166 */     this.idleMessageBroadcast = idleMessageBroadcast;
/*     */   }
/*     */   
/*     */   public void clearIdleAnimationState() {
/* 170 */     this.idleAnimationChoice = null;
/* 171 */     this.idleAnimationAsset = null;
/* 172 */     this.idleMessageBroadcast = false;
/*     */   }
/*     */   
/*     */   public int getStunEscapeCooldown() {
/* 176 */     return this.stunEscapeCooldown;
/*     */   }
/*     */   
/*     */   public void setStunEscapeCooldown(int stunEscapeCooldown) {
/* 180 */     this.stunEscapeCooldown = stunEscapeCooldown;
/*     */   }
/*     */   
/*     */   public Entity getBlockDamage() {
/* 184 */     return this.blockDamage;
/*     */   }
/*     */   
/*     */   public void setSwapBackToBow(boolean swapBackToBow) {
/* 188 */     this.swapBackToBow = swapBackToBow;
/*     */   }
/*     */   
/*     */   public boolean isSwapBackToBow() {
/* 192 */     return this.swapBackToBow;
/*     */   }
/*     */   
/*     */   public double getPlaceBlockToParryChance() {
/* 196 */     return this.placeBlockToParryChance;
/*     */   }
/*     */   
/*     */   public void setPlaceBlockToParryChance(double placeBlockToParryChance) {
/* 200 */     this.placeBlockToParryChance = placeBlockToParryChance;
/*     */   }
/*     */   
/*     */   public void setBlockDamage(Entity blockDamage) {
/* 204 */     this.blockDamage = blockDamage;
/*     */   }
/*     */   
/*     */   public boolean isHealing() {
/* 208 */     return this.healing;
/*     */   }
/*     */   
/*     */   public void setHealing(boolean healing) {
/* 212 */     this.healing = healing;
/*     */   }
/*     */   
/*     */   public int getSwapToBowCooldown() {
/* 216 */     return this.swapToBowCooldown;
/*     */   }
/*     */   
/*     */   public void setSwapToBowCooldown() {
/* 220 */     this.swapToBowCooldown = this.f_19796_.m_216339_(100, 300);
/*     */   }
/*     */   
/*     */   public ItemStack getBowItem() {
/* 224 */     return new ItemStack((ItemLike)Items.f_42411_);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public LivingEntityPatch<?> getLivingEntityPatch() {
/* 229 */     return (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*     */   }
/*     */   
/*     */   public int getGapCooldown() {
/* 233 */     return this.gapCooldown;
/*     */   }
/*     */   
/*     */   public int getEnderPearlCooldown() {
/* 237 */     return this.enderPearlCooldown;
/*     */   }
/*     */   
/*     */   public void setGapCooldown() {
/* 241 */     this.gapCooldown = this.f_19796_.m_216339_(100, 300);
/*     */   }
/*     */   public void resetGapCooldown() {
/* 244 */     this.gapCooldown = 0;
/*     */   }
/*     */   public void setEnderPearlCooldown() {
/* 247 */     this.enderPearlCooldown = this.f_19796_.m_216339_(100, 300);
/*     */   }
/*     */   
/*     */   public ItemStack getMainWeaponItem() {
/* 251 */     return this.mainWeaponItem;
/*     */   }
/*     */   
/*     */   public void setMainWeaponItem(ItemStack mainWeaponItem) {
/* 255 */     this.mainWeaponItem = mainWeaponItem;
/*     */   }
/*     */   public ItemStack getOffWeaponItem() {
/* 258 */     return this.offWeaponItem;
/*     */   }
/*     */   public void setOffWeaponItem(ItemStack offWeaponItem) {
/* 261 */     this.offWeaponItem = offWeaponItem;
/*     */   }
/*     */   
/*     */   public SimpleContainer getInventory() {
/* 265 */     return this.inventory;
/*     */   }
/*     */   
/*     */   public void setUseBow(boolean useBow) {
/* 269 */     this.useBow = useBow;
/*     */   }
/*     */   
/*     */   public boolean isUseBow() {
/* 273 */     return this.useBow;
/*     */   }
/*     */   
/*     */   protected AVNpc(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
/* 277 */     super(pEntityType, pLevel);
/* 278 */     m_21409_(EquipmentSlot.MAINHAND, 0.0F);
/* 279 */     m_21409_(EquipmentSlot.OFFHAND, 0.0F);
/* 280 */     m_21409_(EquipmentSlot.CHEST, 0.0F);
/* 281 */     m_21409_(EquipmentSlot.HEAD, 0.0F);
/* 282 */     m_21409_(EquipmentSlot.LEGS, 0.0F);
/* 283 */     m_21409_(EquipmentSlot.FEET, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 288 */     super.m_7380_(tag);
/* 289 */     tag.m_128365_("Inventory", (Tag)this.inventory.m_7927_());
/* 290 */     tag.m_128405_("GapCooldown", this.gapCooldown);
/* 291 */     tag.m_128405_("EnderPearlCooldown", this.enderPearlCooldown);
/* 292 */     tag.m_128405_("SwapToBowCooldown", this.swapToBowCooldown);
/* 293 */     tag.m_128379_("InitialSpawn", this.initialSpawn);
/* 294 */     tag.m_128379_("UseBow", this.useBow);
/* 295 */     tag.m_128347_("BlockProjectileChance", this.placeBlockToParryChance);
/* 296 */     if (!this.mainWeaponItem.m_41619_()) {
/* 297 */       CompoundTag itemTag = new CompoundTag();
/* 298 */       this.mainWeaponItem.m_41739_(itemTag);
/* 299 */       tag.m_128365_("MainHandItem", (Tag)itemTag);
/*     */     } 
/* 301 */     if (!this.offWeaponItem.m_41619_()) {
/* 302 */       CompoundTag itemTag = new CompoundTag();
/* 303 */       this.offWeaponItem.m_41739_(itemTag);
/* 304 */       tag.m_128365_("OffHandItem", (Tag)itemTag);
/*     */     } 
/* 306 */     tag.m_128405_("VoiceCooldown", this.voiceCooldown);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_238392_(@NotNull EquipmentSlot pSlot, @NotNull ItemStack pOldItem, @NotNull ItemStack pNewItem) {
/* 311 */     if (pSlot == EquipmentSlot.MAINHAND && (pNewItem
/* 312 */       .m_41720_() instanceof net.minecraft.world.item.SwordItem || pNewItem.m_41720_() instanceof net.minecraft.world.item.AxeItem || pNewItem.m_41720_() instanceof net.minecraft.world.item.ShieldItem)) {
/* 313 */       this.mainWeaponItem = pNewItem.m_41777_();
/*     */     }
/* 315 */     if (pSlot == EquipmentSlot.OFFHAND && (pNewItem
/* 316 */       .m_41720_() instanceof net.minecraft.world.item.SwordItem || pNewItem.m_41720_() instanceof net.minecraft.world.item.AxeItem || pNewItem.m_41720_() instanceof net.minecraft.world.item.ShieldItem)) {
/* 317 */       this.offWeaponItem = pNewItem.m_41777_();
/*     */     }
/* 319 */     super.m_238392_(pSlot, pOldItem, pNewItem);
/* 320 */     if ((m_9236_()).f_46443_)
/* 321 */       return;  if (!m_6084_() || m_21224_() || m_21223_() <= 0.0F)
/*     */       return; 
/* 323 */     if (isPlayingIdle() && getLivingEntityPatch() != null && this.idleAnimationAsset != null) {
/* 324 */       getLivingEntityPatch().playAnimationSynchronized(this.idleAnimationAsset, 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 330 */     super.m_7378_(tag);
/* 331 */     if (tag.m_128425_("Inventory", 10)) {
/* 332 */       this.inventory.m_7797_(tag.m_128437_("Inventory", 10));
/*     */     }
/* 334 */     this.gapCooldown = tag.m_128451_("GapCooldown");
/* 335 */     this.enderPearlCooldown = tag.m_128451_("EnderPearlCooldown");
/* 336 */     this.swapToBowCooldown = tag.m_128451_("SwapToBowCooldown");
/* 337 */     this.initialSpawn = tag.m_128471_("InitialSpawn");
/* 338 */     this.useBow = tag.m_128471_("UseBow");
/* 339 */     this.placeBlockToParryChance = tag.m_128459_("BlockProjectileChance");
/* 340 */     if (tag.m_128425_("MainHandItem", 10)) {
/* 341 */       this.mainWeaponItem = ItemStack.m_41712_(tag.m_128469_("MainHandItem"));
/*     */     } else {
/* 343 */       this.mainWeaponItem = ItemStack.f_41583_;
/*     */     } 
/* 345 */     if (tag.m_128425_("OffHandItem", 10)) {
/* 346 */       this.offWeaponItem = ItemStack.m_41712_(tag.m_128469_("OffHandItem"));
/*     */     } else {
/* 348 */       this.offWeaponItem = ItemStack.f_41583_;
/*     */     } 
/* 350 */     this.voiceCooldown = tag.m_128451_("VoiceCooldown");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/* 355 */     super.m_7472_(source, looting, recentlyHit);
/*     */     
/* 357 */     for (int i = 0; i < this.inventory.m_6643_(); i++) {
/* 358 */       ItemStack stack = this.inventory.m_8020_(i);
/* 359 */       if (!stack.m_41619_()) {
/* 360 */         m_19983_(stack);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_8099_() {
/* 367 */     super.m_8099_();
/* 368 */     this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
/* 369 */     if (m_21205_().m_41720_() instanceof BowItem) {
/* 370 */       this.f_21345_.m_25352_(4, (Goal)new RangedBowAttackGoal((Mob)this, 1.0D, 20, 10.0F));
/*     */     }
/* 372 */     this.f_21345_.m_25352_(5, (Goal)new BurnNearbyItemGoal((Mob)this, 1.0D, 10.0D));
/* 373 */     this.f_21345_.m_25352_(6, (Goal)new PlayIdleAnimationGoal((Mob)this, (new Random()).nextInt(3000, 6000)));
/* 374 */     this.f_21345_.m_25352_(7, (Goal)new LockedRandomStrollGoal(this, 1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_5886_(@NotNull ProjectileWeaponItem item) {
/* 379 */     return item instanceof BowItem;
/*     */   }
/*     */   
/*     */   public boolean canFireProjectileWeapon(@NotNull Item item) {
/* 383 */     if (item instanceof ProjectileWeaponItem) { ProjectileWeaponItem weaponItem = (ProjectileWeaponItem)item;
/* 384 */       return m_5886_(weaponItem); }
/*     */     
/* 386 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6504_(@NotNull LivingEntity pTarget, float pVelocity) {
/* 391 */     ItemStack weaponStack = m_21120_(ProjectileUtil.getWeaponHoldingHand((LivingEntity)this, this::canFireProjectileWeapon));
/* 392 */     ItemStack itemstack = m_6298_(weaponStack);
/* 393 */     AbstractArrow mobArrow = ProjectileUtil.m_37300_((LivingEntity)this, itemstack, pVelocity);
/* 394 */     if (m_21205_().m_41720_() instanceof BowItem) {
/* 395 */       mobArrow = ((BowItem)m_21205_().m_41720_()).customArrow(mobArrow);
/*     */     }
/*     */     
/* 398 */     double x = pTarget.m_20185_() - m_20185_();
/* 399 */     double y = pTarget.m_20227_(0.3333333333333333D) - mobArrow.m_20186_();
/* 400 */     double z = pTarget.m_20189_() - m_20189_();
/* 401 */     double d3 = Math.sqrt(x * x + z * z);
/* 402 */     mobArrow.m_5602_((Entity)this);
/* 403 */     mobArrow.m_6686_(x, y + d3 * 0.20000000298023224D, z, 1.6F, (14 - m_9236_().m_46791_().m_19028_() * 4));
/* 404 */     m_5496_(SoundEvents.f_11687_, 1.0F, 1.0F / (m_217043_().m_188501_() * 0.4F + 0.8F));
/* 405 */     m_9236_().m_7967_((Entity)mobArrow);
/*     */   }
/*     */   
/*     */   private boolean isInventoryFull() {
/* 409 */     for (int i = 0; i < this.inventory.m_6643_(); i++) {
/* 410 */       ItemStack s = this.inventory.m_8020_(i);
/* 411 */       if (s.m_41619_() || s.m_41613_() < s.m_41741_()) {
/* 412 */         return false;
/*     */       }
/*     */     } 
/* 415 */     return true;
/*     */   }
/*     */   
/*     */   private void pickupNearbyItems() {
/* 419 */     if (!m_6084_() || m_213877_() || m_21224_())
/*     */       return; 
/* 421 */     AABB box = m_20191_().m_82400_(1.5D);
/* 422 */     List<ItemEntity> items = m_9236_().m_6443_(ItemEntity.class, box, e -> 
/*     */ 
/*     */         
/* 425 */         (!e.m_213877_() && !e.m_32063_()));
/*     */ 
/*     */     
/* 428 */     for (ItemEntity itemEntity : items) {
/* 429 */       tryPickup(itemEntity);
/*     */     }
/*     */   }
/*     */   
/*     */   private void tryPickup(final ItemEntity itemEntity) {
/* 434 */     ItemStack remaining = itemEntity.m_32055_().m_41777_();
/*     */     
/* 436 */     for (int i = 0; i < this.inventory.m_6643_() && !remaining.m_41619_() && 
/* 437 */       !remaining.m_41619_(); i++) {
/* 438 */       ItemStack slotStack = this.inventory.m_8020_(i);
/*     */       
/* 440 */       if (slotStack.m_41619_()) {
/* 441 */         this.inventory.m_6836_(i, remaining);
/* 442 */         remaining = ItemStack.f_41583_; break;
/*     */       } 
/* 444 */       if (ItemStack.m_150942_(slotStack, remaining) && slotStack
/* 445 */         .m_41613_() < slotStack.m_41741_()) {
/* 446 */         int transferable = Math.min(remaining
/* 447 */             .m_41613_(), slotStack
/* 448 */             .m_41741_() - slotStack.m_41613_());
/*     */         
/* 450 */         slotStack.m_41769_(transferable);
/* 451 */         remaining.m_41774_(transferable);
/*     */       } 
/*     */     } 
/*     */     
/* 455 */     if (remaining.m_41619_()) {
/* 456 */       itemEntity.m_20334_((
/* 457 */           m_20185_() - itemEntity.m_20185_()) * 0.25D, (
/* 458 */           m_20186_() + 1.0D - itemEntity.m_20186_()) * 0.25D, (
/* 459 */           m_20189_() - itemEntity.m_20189_()) * 0.25D);
/*     */       
/* 461 */       itemEntity.m_32010_(0);
/* 462 */       final AVNpc entity = this;
/* 463 */       new DelayedTask(5)
/*     */         {
/*     */           public void run() {
/* 466 */             if (!entity.m_6084_() || entity.m_213877_() || entity.m_21224_())
/* 467 */               return;  itemEntity.m_146870_();
/* 468 */             entity.m_9236_().m_5594_(null, entity.m_20183_(), SoundEvents.f_12019_, SoundSource.HOSTILE, 0.2F, 1.0F);
/*     */           }
/*     */         };
/*     */     } else {
/* 472 */       itemEntity.m_32045_(remaining);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void implementFirstTick(ServerLevel serverLevel) {}
/*     */   
/*     */   public void jump() {
/* 479 */     m_6135_();
/* 480 */     Vec3 motion = m_20184_();
/* 481 */     Vec3 forward = m_20156_();
/* 482 */     double strength = (new Random()).nextDouble(0.2D, 0.4D);
/* 483 */     m_20334_(motion.f_82479_ + forward.f_82479_ * strength, motion.f_82480_, motion.f_82481_ + forward.f_82481_ * strength);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 488 */     this.f_19812_ = true;
/*     */   }
/*     */   
/*     */   public void shortPillarJump() {
/* 492 */     if (!m_20096_())
/* 493 */       return;  Vec3 v = m_20184_();
/* 494 */     double keepH = 0.02D;
/* 495 */     m_20334_(v.f_82479_ * keepH, 0.42D, v.f_82481_ * keepH);
/* 496 */     this.f_19812_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/* 501 */     if (hasEnderPearlCounter()) {
/* 502 */       tryTriggerEnderPearlCounter(damageSource);
/*     */     }
/* 504 */     boolean result = super.m_6469_(damageSource, f);
/* 505 */     if (result) {
/* 506 */       sayHurtSound((Mob)this, damageSource);
/*     */     }
/* 508 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_7327_(@NotNull Entity target) {
/* 513 */     boolean result = super.m_7327_(target);
/* 514 */     if (result) {
/* 515 */       sayAttackSound((Mob)this, target);
/*     */     }
/* 517 */     return result;
/*     */   }
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/* 521 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void beforeEnderPearlCounter(@NotNull DamageSource damageSource) {}
/*     */ 
/*     */   
/*     */   protected void afterEnderPearlCounter(@NotNull DamageSource damageSource) {}
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 531 */     throwEnderPearlNow(180.0F);
/*     */   }
/*     */   
/*     */   protected void playEnderPearlCounterAnimation() {
/* 535 */     if (getLivingEntityPatch() != null) {
/* 536 */       getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void throwEnderPearlNow(float angle) {
/* 541 */     CombatBehaviour.throwEnderPearl((Entity)this, angle);
/*     */   }
/*     */   
/*     */   protected void throwEnderPearlLater(int delayTicks, final float angle) {
/* 545 */     final AVNpc entity = this;
/* 546 */     new DelayedTask(delayTicks)
/*     */       {
/*     */         public void run() {
/* 549 */           if (!entity.m_6084_())
/* 550 */             return;  entity.playEnderPearlCounterAnimation();
/* 551 */           entity.throwEnderPearlNow(angle);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void throwEnderPearlLater(int delayTicks, double chance, float angle) {
/* 557 */     if (this.f_19796_.m_188500_() <= chance) {
/* 558 */       throwEnderPearlLater(delayTicks, angle);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void doChrisStyleEnderPearlCounter() {
/* 563 */     throwEnderPearlNow(180.0F);
/* 564 */     throwEnderPearlLater(20, 0.2D, 90.0F);
/*     */   }
/*     */   
/*     */   protected void doSteveStyleEnderPearlCounter() {
/* 568 */     throwEnderPearlNow((new Random()).nextFloat(90.0F, 180.0F));
/* 569 */     throwEnderPearlLater(20, 0.5D, 180.0F);
/* 570 */     throwEnderPearlLater(20, 0.3D, 90.0F);
/*     */   }
/*     */   
/*     */   protected void doVillagerGeneralStyleEnderPearlCounter() {
/* 574 */     throwEnderPearlNow((new Random()).nextFloat(90.0F, 180.0F));
/* 575 */     throwEnderPearlLater(40, 0.5D, 0.0F);
/* 576 */     throwEnderPearlLater(20, 0.2D, 180.0F);
/* 577 */     throwEnderPearlLater(20, 0.1D, 90.0F);
/*     */   }
/*     */   
/*     */   protected AssetAccessor<? extends StaticAnimation> getCurrentAnimationOrEmpty() {
/* 581 */     LivingEntityPatch<?> patch = getLivingEntityPatch();
/* 582 */     if (patch == null) {
/* 583 */       return (AssetAccessor<? extends StaticAnimation>)Animations.EMPTY_ANIMATION;
/*     */     }
/*     */     
/* 586 */     AnimationPlayer player = patch.getAnimator().getPlayerFor(null);
/* 587 */     return (player != null) ? player.getRealAnimation() : (AssetAccessor<? extends StaticAnimation>)Animations.EMPTY_ANIMATION;
/*     */   }
/*     */   protected void tryTriggerEnderPearlCounter(@NotNull DamageSource damageSource) {
/*     */     MobPatch<?> mobPatch;
/* 591 */     LivingEntityPatch<?> patch = getLivingEntityPatch();
/* 592 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = getCurrentAnimationOrEmpty();
/*     */     
/* 594 */     if (damageSource.m_7639_() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 598 */     if (getEnderPearlCooldown() != 0) {
/*     */       return;
/*     */     }
/*     */     
/* 602 */     if (EpicfightUtil.isLongHitAnimation(dynamicAnimation, patch)) {
/*     */       return;
/*     */     }
/*     */     
/* 606 */     if (!(m_9236_() instanceof ServerLevel)) {
/*     */       return;
/*     */     }
/*     */     
/* 610 */     if (dynamicAnimation != Animations.EMPTY_ANIMATION) {
/*     */       return;
/*     */     }
/*     */     
/* 614 */     if (patch instanceof MobPatch) { mobPatch = (MobPatch)patch; }
/*     */     else
/*     */     { return; }
/*     */     
/* 618 */     if (!CombatCommon.canPerformNormalAttackLogic(mobPatch)) {
/*     */       return;
/*     */     }
/*     */     
/* 622 */     beforeEnderPearlCounter(damageSource);
/* 623 */     playEnderPearlCounterAnimation();
/* 624 */     doEnderPearlCounterPattern(damageSource);
/* 625 */     afterEnderPearlCounter(damageSource);
/* 626 */     setEnderPearlCooldown();
/*     */   }
/*     */   
/*     */   protected ItemStack getEnderPearlCounterRestoreOffhandItem() {
/* 630 */     return getOffWeaponItem().m_41777_();
/*     */   }
/*     */   
/*     */   protected void restoreOffhandLater(int delayTicks) {
/* 634 */     final AVNpc entity = this;
/* 635 */     final ItemStack restore = getEnderPearlCounterRestoreOffhandItem().m_41777_();
/*     */     
/* 637 */     new DelayedTask(delayTicks)
/*     */       {
/*     */         public void run() {
/* 640 */           if (!entity.m_6084_())
/* 641 */             return;  entity.m_21008_(InteractionHand.OFF_HAND, restore.m_41777_());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void swapOffhandDuringEnderPearlCounter(ItemStack temporaryOffhand, int restoreDelayTicks) {
/* 647 */     m_21008_(InteractionHand.OFF_HAND, temporaryOffhand.m_41777_());
/* 648 */     restoreOffhandLater(restoreDelayTicks);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean afterBurstProtection(@NotNull ServerLevel serverLevel, @NotNull DamageSource source, float finalDamage) {
/* 654 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_6475_(@NotNull DamageSource pDamageSource, float pDamageAmount) {
/* 659 */     if (pDamageSource.m_276093_(DamageTypes.f_268724_)) {
/* 660 */       super.m_6475_(pDamageSource, pDamageAmount);
/*     */       
/*     */       return;
/*     */     } 
/* 664 */     if (m_6673_(pDamageSource)) {
/*     */       return;
/*     */     }
/*     */     
/* 668 */     pDamageAmount = ForgeHooks.onLivingHurt((LivingEntity)this, pDamageSource, pDamageAmount);
/* 669 */     if (pDamageAmount <= 0.0F) {
/*     */       return;
/*     */     }
/*     */     
/* 673 */     pDamageAmount = m_21161_(pDamageSource, pDamageAmount);
/* 674 */     pDamageAmount = m_6515_(pDamageSource, pDamageAmount);
/*     */     
/* 676 */     float finalDamage = Math.max(pDamageAmount - m_6103_(), 0.0F);
/* 677 */     float absorbed = pDamageAmount - finalDamage;
/* 678 */     if (absorbed > 0.0F) {
/* 679 */       m_7911_(m_6103_() - absorbed);
/* 680 */       if (m_6103_() < 0.0F) {
/* 681 */         m_7911_(0.0F);
/*     */       }
/*     */     } 
/*     */     
/* 685 */     finalDamage = ForgeHooks.onLivingDamage((LivingEntity)this, pDamageSource, finalDamage);
/* 686 */     finalDamage = applyBurstProtection((LivingEntity)this, pDamageSource, finalDamage);
/*     */     
/* 688 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 689 */       if (afterBurstProtection(serverLevel, pDamageSource, finalDamage)) {
/*     */         return;
/*     */       } }
/*     */     
/* 693 */     if (finalDamage <= 0.0F) {
/*     */       return;
/*     */     }
/*     */     
/* 697 */     m_21231_().m_289194_(pDamageSource, finalDamage);
/* 698 */     m_21153_(m_21223_() - finalDamage);
/* 699 */     m_146850_(GameEvent.f_223706_);
/*     */   }
/*     */   
/*     */   public void m_8119_() {
/*     */     final ServerLevel serverLevel;
/* 704 */     super.m_8119_();
/* 705 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; } else { return; }
/* 706 */      tickVoiceCooldown();
/*     */     
/* 708 */     if (this.f_19797_ == 1 && !this.initialSpawn) {
/* 709 */       implementFirstTick((ServerLevel)m_9236_());
/* 710 */       this.initialSpawn = true;
/*     */     } 
/*     */     
/* 713 */     tickBurstProtectionDecay((LivingEntity)this);
/*     */     
/* 715 */     if (this.stunEscapeCooldown == 0 && m_9236_() instanceof ServerLevel && 
/* 716 */       getLivingEntityPatch() != null) {
/* 717 */       final AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getLivingEntityPatch().getAnimator().getPlayerFor(null))).getRealAnimation();
/* 718 */       if (EpicfightUtil.isLongHitAnimationNotExecutedAnimation(dynamicAnimation, getLivingEntityPatch()) && m_6084_() && 
/* 719 */         m_217043_().m_188501_() < CombatBehaviour.calculateGuardBreakWakeUpChance((LivingEntity)this)) {
/* 720 */         if (this instanceof com.pla.annoyingvillagers.entity.AngrySteveEntity) {
/* 721 */           this.stunEscapeCooldown = 60;
/*     */         } else {
/* 723 */           this.stunEscapeCooldown = 100;
/*     */         } 
/* 725 */         final AVNpc entity = this;
/* 726 */         new DelayedTask((new Random()).nextInt(5, 10))
/*     */           {
/*     */             public void run() {
/* 729 */               if (AVNpc.this.getLivingEntityPatch() != null && EpicfightUtil.isLongHitAnimationNotExecutedAnimation(dynamicAnimation, AVNpc.this.getLivingEntityPatch()) && entity.m_6084_()) {
/* 730 */                 CombatBehaviour.postGuardBreakWakeUp((LivingEntity)entity, AVNpc.this.getLivingEntityPatch(), serverLevel);
/*     */               } else {
/* 732 */                 entity.stunEscapeCooldown = 1;
/*     */               } 
/*     */             }
/*     */           };
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 741 */     if (this.gapCooldown > 0) this.gapCooldown--; 
/* 742 */     if (this.enderPearlCooldown > 0) this.enderPearlCooldown--; 
/* 743 */     if (this.swapToBowCooldown > 0) this.swapToBowCooldown--; 
/* 744 */     if (this.stunEscapeCooldown > 0) this.stunEscapeCooldown--; 
/* 745 */     if (this.playingIdleCooldown > 0) this.playingIdleCooldown--; 
/* 746 */     if (this.efnGuardHitCooldown > 0) this.efnGuardHitCooldown--;
/*     */     
/* 748 */     if (this.efnGuardHitCooldown == 0 && this.efnGuardHitState != 0) {
/* 749 */       this.efnGuardHitState = 0;
/*     */     }
/*     */ 
/*     */     
/* 753 */     if ((this.f_19797_ + m_19879_()) % 20 == 0 && 
/* 754 */       !isInventoryFull())
/* 755 */       pickupNearbyItems(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\AVNpc.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */