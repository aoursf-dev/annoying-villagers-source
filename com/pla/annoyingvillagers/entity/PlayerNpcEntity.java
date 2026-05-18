/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.pla.annoyingvillagers.clazz.IdleAnimation;
/*     */ import com.pla.annoyingvillagers.clazz.PlayerNpcTarget;
/*     */ import com.pla.annoyingvillagers.entity.goal.LockedRandomStrollGoal;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*     */ import com.pla.annoyingvillagers.util.CommonGoals;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.SimpleContainer;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
/*     */ import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
/*     */ import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*     */ import net.minecraft.world.entity.projectile.ProjectileUtil;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.ProjectileWeaponItem;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import se.gory_moon.player_mobs.entity.PlayerMobEntity;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class PlayerNpcEntity extends PlayerMobEntity {
/*  68 */   private final SimpleContainer inventory = new SimpleContainer(27);
/*  69 */   private int gapCooldown = 0;
/*  70 */   private int enderPearlCooldown = 0;
/*  71 */   private int swapToBowCooldown = 0;
/*     */   private PlayerNpcTarget target;
/*  73 */   private ItemStack mainWeaponItem = ItemStack.f_41583_;
/*  74 */   private ItemStack offWeaponItem = ItemStack.f_41583_;
/*     */   private boolean healing = false;
/*     */   private boolean useBow = true;
/*  77 */   private Entity blockDamage = null;
/*     */   private double placeBlockToParryChance;
/*  79 */   private int stunEscapeCooldown = 0; @Nullable
/*     */   private IdleAnimation idleAnimationChoice; @Nullable
/*     */   private AssetAccessor<? extends StaticAnimation> idleAnimationAsset;
/*     */   private boolean idleMessageBroadcast = false;
/*     */   private boolean playingIdle;
/*  84 */   private int playingIdleCooldown = (new Random()).nextInt(600, 1200);
/*     */   private boolean isStrolling;
/*     */   
/*     */   public boolean isStrolling() {
/*  88 */     return this.isStrolling;
/*     */   }
/*     */   
/*     */   public void setStrolling(boolean strolling) {
/*  92 */     this.isStrolling = strolling;
/*     */   }
/*     */   
/*     */   public boolean isPlayingIdle() {
/*  96 */     return this.playingIdle;
/*     */   }
/*     */   
/*     */   public void setPlayingIdle(boolean playingIdle) {
/* 100 */     this.playingIdle = playingIdle;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public IdleAnimation getIdleAnimationChoice() {
/* 105 */     return this.idleAnimationChoice;
/*     */   }
/*     */   
/*     */   public void setIdleAnimationChoice(@Nullable IdleAnimation choice) {
/* 109 */     this.idleAnimationChoice = choice;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public AssetAccessor<? extends StaticAnimation> getIdleAnimation() {
/* 114 */     return this.idleAnimationAsset;
/*     */   }
/*     */   
/*     */   public void setIdleAnimation(@Nullable AssetAccessor<? extends StaticAnimation> anim) {
/* 118 */     this.idleAnimationAsset = anim;
/*     */   }
/*     */   
/*     */   public boolean isIdleMessageBroadcast() {
/* 122 */     return this.idleMessageBroadcast;
/*     */   }
/*     */   
/*     */   public void setIdleMessageBroadcast(boolean idleMessageBroadcast) {
/* 126 */     this.idleMessageBroadcast = idleMessageBroadcast;
/*     */   }
/*     */   
/*     */   public int getPlayingIdleCooldown() {
/* 130 */     return this.playingIdleCooldown;
/*     */   }
/*     */   
/*     */   public void setPlayingIdleCooldown(int playingIdleCooldown) {
/* 134 */     this.playingIdleCooldown = playingIdleCooldown;
/*     */   }
/*     */   
/*     */   public void clearIdleAnimationState() {
/* 138 */     this.idleAnimationChoice = null;
/* 139 */     this.idleAnimationAsset = null;
/* 140 */     this.idleMessageBroadcast = false;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public LivingEntityPatch<?> getLivingEntityPatch() {
/* 145 */     return (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*     */   }
/*     */   
/*     */   public int getStunEscapeCooldown() {
/* 149 */     return this.stunEscapeCooldown;
/*     */   }
/*     */   
/*     */   public void setStunEscapeCooldown(int stunEscapeCooldown) {
/* 153 */     this.stunEscapeCooldown = stunEscapeCooldown;
/*     */   }
/*     */   
/*     */   public double getPlaceBlockToParryChance() {
/* 157 */     return this.placeBlockToParryChance;
/*     */   }
/*     */   
/*     */   public Entity getBlockDamage() {
/* 161 */     return this.blockDamage;
/*     */   }
/*     */   
/*     */   public void setBlockDamage(Entity blockDamage) {
/* 165 */     this.blockDamage = blockDamage;
/*     */   }
/*     */   
/*     */   public boolean isHealing() {
/* 169 */     return this.healing;
/*     */   }
/*     */   
/*     */   public void setHealing(boolean healing) {
/* 173 */     this.healing = healing;
/*     */   }
/*     */   
/*     */   public int getGapCooldown() {
/* 177 */     return this.gapCooldown;
/*     */   }
/*     */   
/*     */   public int getEnderPearlCooldown() {
/* 181 */     return this.enderPearlCooldown;
/*     */   }
/*     */   
/*     */   public int getSwapToBowCooldown() {
/* 185 */     return this.swapToBowCooldown;
/*     */   }
/*     */   
/*     */   public void setGapCooldown() {
/* 189 */     this.gapCooldown = this.f_19796_.m_216339_(100, 300);
/*     */   }
/*     */   public void resetGapCooldown() {
/* 192 */     this.gapCooldown = 0;
/*     */   }
/*     */   public void setEnderPearlCooldown() {
/* 195 */     this.enderPearlCooldown = this.f_19796_.m_216339_(100, 300);
/*     */   }
/*     */   
/*     */   public void setSwapToBowCooldown() {
/* 199 */     this.swapToBowCooldown = this.f_19796_.m_216339_(100, 300);
/*     */   }
/*     */   
/*     */   public SimpleContainer getInventory() {
/* 203 */     return this.inventory;
/*     */   }
/*     */   
/*     */   public PlayerNpcEntity(PlayMessages.SpawnEntity spawnentity, Level level) {
/* 207 */     this((EntityType<? extends PlayerNpcEntity>)AnnoyingVillagersModEntities.PLAYER_NPC.get(), level);
/*     */   }
/*     */   
/*     */   public ItemStack getMainWeaponItem() {
/* 211 */     return this.mainWeaponItem;
/*     */   }
/*     */   public ItemStack getOffWeaponItem() {
/* 214 */     return this.offWeaponItem;
/*     */   }
/*     */   public void setUseBow(boolean useBow) {
/* 217 */     this.useBow = useBow;
/*     */   }
/*     */   
/*     */   public boolean isUseBow() {
/* 221 */     return this.useBow;
/*     */   }
/*     */   
/*     */   public PlayerNpcEntity(EntityType<? extends PlayerNpcEntity> entitytype, Level level) {
/* 225 */     super(entitytype, level);
/* 226 */     m_274367_(2.6F);
/* 227 */     this.f_21364_ = 50;
/* 228 */     m_21557_(false);
/* 229 */     m_20340_(true);
/* 230 */     m_21530_();
/* 231 */     this.placeBlockToParryChance = (new Random()).nextDouble(0.2D, 0.4D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 236 */     super.m_7380_(tag);
/* 237 */     tag.m_128365_("Inventory", (Tag)this.inventory.m_7927_());
/* 238 */     tag.m_128405_("GapCooldown", this.gapCooldown);
/* 239 */     tag.m_128405_("EnderPearlCooldown", this.enderPearlCooldown);
/* 240 */     tag.m_128405_("SwapToBowCooldown", this.swapToBowCooldown);
/* 241 */     tag.m_128379_("UseBow", this.useBow);
/* 242 */     tag.m_128347_("BlockProjectileChance", this.placeBlockToParryChance);
/* 243 */     if (this.target != null) {
/* 244 */       tag.m_128359_("PlayerNpcTarget", this.target.name());
/*     */     }
/* 246 */     if (!this.mainWeaponItem.m_41619_()) {
/* 247 */       CompoundTag itemTag = new CompoundTag();
/* 248 */       this.mainWeaponItem.m_41739_(itemTag);
/* 249 */       tag.m_128365_("MainHandItem", (Tag)itemTag);
/*     */     } 
/* 251 */     if (!this.offWeaponItem.m_41619_()) {
/* 252 */       CompoundTag itemTag = new CompoundTag();
/* 253 */       this.offWeaponItem.m_41739_(itemTag);
/* 254 */       tag.m_128365_("OffHandItem", (Tag)itemTag);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 260 */     super.m_7378_(tag);
/* 261 */     if (tag.m_128425_("Inventory", 10)) {
/* 262 */       this.inventory.m_7797_(tag.m_128437_("Inventory", 10));
/*     */     }
/* 264 */     this.gapCooldown = tag.m_128451_("GapCooldown");
/* 265 */     this.enderPearlCooldown = tag.m_128451_("EnderPearlCooldown");
/* 266 */     this.swapToBowCooldown = tag.m_128451_("SwapToBowCooldown");
/* 267 */     this.useBow = tag.m_128471_("UseBow");
/* 268 */     this.placeBlockToParryChance = tag.m_128459_("BlockProjectileChance");
/* 269 */     if (tag.m_128425_("PlayerNpcTarget", 8)) {
/* 270 */       String name = tag.m_128461_("PlayerNpcTarget");
/*     */       try {
/* 272 */         this.target = PlayerNpcTarget.valueOf(name);
/* 273 */       } catch (IllegalArgumentException e) {
/* 274 */         this.target = PlayerNpcTarget.MONSTER_HUNTER;
/*     */       } 
/*     */     } 
/* 277 */     if (tag.m_128425_("MainHandItem", 10)) {
/* 278 */       this.mainWeaponItem = ItemStack.m_41712_(tag.m_128469_("MainHandItem"));
/*     */     } else {
/* 280 */       this.mainWeaponItem = ItemStack.f_41583_;
/*     */     } 
/* 282 */     if (tag.m_128425_("OffHandItem", 10)) {
/* 283 */       this.offWeaponItem = ItemStack.m_41712_(tag.m_128469_("OffHandItem"));
/*     */     } else {
/* 285 */       this.offWeaponItem = ItemStack.f_41583_;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/* 291 */     super.m_7472_(source, looting, recentlyHit);
/*     */     
/* 293 */     for (int i = 0; i < this.inventory.m_6643_(); i++) {
/* 294 */       ItemStack stack = this.inventory.m_8020_(i);
/* 295 */       if (!stack.m_41619_())
/* 296 */         m_19983_(stack); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 302 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   private void hostileHunterPlayerMob() {
/* 306 */     this.f_21345_.m_25352_(2, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2D, false));
/* 307 */     this.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
/* 308 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, PlayerMobEntity.class, true));
/* 309 */     CommonGoals.attackAllMonstersGoals(this);
/* 310 */     CommonGoals.attackAllNpcGoals((Mob)this);
/*     */   }
/*     */   
/*     */   private void villagerHunterPlayerMob() {
/* 314 */     CommonGoals.runAwayFromHerobrineGoals((PathfinderMob)this, 20.0F);
/* 315 */     if (!(m_5448_() instanceof PlayerNpcEntity)) {
/* 316 */       this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, PlayerNpcEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 318 */     if (!(m_5448_() instanceof Player)) {
/* 319 */       this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, Player.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 321 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Villager.class, true));
/* 322 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, JevEntity.class, true));
/* 323 */     this.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, true));
/* 324 */     CommonGoals.attackAllVillagerArmyGoal((Mob)this);
/* 325 */     this.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2D, false));
/*     */   }
/*     */   
/*     */   private void monsterHunterPlayerMob() {
/* 329 */     CommonGoals.attackAllMonstersGoals(this);
/* 330 */     CommonGoals.runAwayFromVillagerArmyGoals(this);
/*     */   }
/*     */   
/*     */   private void playerHunterPlayerMob() {
/* 334 */     CommonGoals.runAwayFromHerobrineGoals((PathfinderMob)this, 20.0F);
/* 335 */     CommonGoals.runAwayFromVillagerArmyGoals(this);
/* 336 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
/* 337 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, PlayerNpcEntity.class, true));
/* 338 */     CommonGoals.attackAllNpcGoals((Mob)this);
/*     */   }
/*     */   
/*     */   private void animalHunterPlayerMob() {
/* 342 */     CommonGoals.runAwayFromHerobrineGoals((PathfinderMob)this, 20.0F);
/* 343 */     CommonGoals.runAwayFromVillagerArmyGoals(this);
/* 344 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Animal.class, true));
/* 345 */     if (!(m_5448_() instanceof PlayerNpcEntity)) {
/* 346 */       this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, PlayerNpcEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/*     */     
/* 349 */     if (!(m_5448_() instanceof Player)) {
/* 350 */       this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, Player.class, 12.0F, 1.2D, 1.8D));
/*     */     }
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/* 355 */     this.f_21345_.m_25352_(0, (Goal)new FloatGoal((Mob)this));
/* 356 */     this.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
/* 357 */     this.f_21345_.m_25352_(5, (Goal)new BurnNearbyItemGoal((Mob)this, 1.0D, 10.0D));
/* 358 */     this.f_21345_.m_25352_(6, (Goal)new PlayIdleAnimationGoal((Mob)this, (new Random()).nextInt(3000, 6000)));
/* 359 */     this.f_21345_.m_25352_(7, (Goal)new LockedRandomStrollGoal((PathfinderMob)this, 1.0D));
/* 360 */     this.f_21345_.m_25352_(5, (Goal)new OpenDoorGoal((Mob)this, true));
/* 361 */     if (m_21205_().m_41720_() instanceof BowItem) {
/* 362 */       this.f_21345_.m_25352_(4, (Goal)new RangedBowAttackGoal((Monster)this, 1.0D, 20, 48.0F));
/*     */     }
/* 364 */     ((GroundPathNavigation)m_21573_()).m_26477_(true);
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 368 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 372 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 376 */     return -0.35D;
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 380 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt")));
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_5592_() {
/* 384 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death")));
/*     */   }
/*     */   
/*     */   public void jump() {
/* 388 */     m_6135_();
/* 389 */     Vec3 motion = m_20184_();
/* 390 */     Vec3 forward = m_20156_();
/* 391 */     double strength = (new Random()).nextDouble(0.2D, 0.4D);
/* 392 */     m_20334_(motion.f_82479_ + forward.f_82479_ * strength, motion.f_82480_, motion.f_82481_ + forward.f_82481_ * strength);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 397 */     this.f_19812_ = true;
/*     */   }
/*     */   
/*     */   public void shortPillarJump() {
/* 401 */     if (!m_20096_())
/* 402 */       return;  Vec3 v = m_20184_();
/* 403 */     double keepH = 0.02D;
/* 404 */     m_20334_(v.f_82479_ * keepH, 0.42D, v.f_82481_ * keepH);
/* 405 */     this.f_19812_ = true;
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/* 409 */     if (getLivingEntityPatch() == null) return super.m_6469_(damageSource, f); 
/* 410 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getLivingEntityPatch().getAnimator().getPlayerFor(null))).getRealAnimation();
/*     */     
/* 412 */     if (damageSource.m_7639_() != null && getEnderPearlCooldown() == 0 && 
/* 413 */       !EpicfightUtil.isLongHitAnimation(dynamicAnimation, getLivingEntityPatch()) && 
/* 414 */       m_9236_() instanceof ServerLevel && dynamicAnimation == Animations.EMPTY_ANIMATION && 
/* 415 */       CombatCommon.canPerformNormalAttackLogic((MobPatch)getLivingEntityPatch())) {
/* 416 */       getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F);
/* 417 */       CombatBehaviour.throwEnderPearl((Entity)this, 180.0F);
/* 418 */       final PlayerNpcEntity entity = this;
/*     */       
/* 420 */       if (Math.random() <= 0.5D) {
/* 421 */         new DelayedTask(20)
/*     */           {
/*     */             public void run() {
/* 424 */               if (entity.m_6084_()) {
/* 425 */                 PlayerNpcEntity.this.getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F);
/* 426 */                 CombatBehaviour.throwEnderPearl(entity, 90.0F);
/*     */               } 
/*     */             }
/*     */           };
/*     */       }
/*     */       
/* 432 */       setEnderPearlCooldown();
/*     */     } 
/* 434 */     return super.m_6469_(damageSource, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_5886_(@NotNull ProjectileWeaponItem item) {
/* 439 */     return item instanceof BowItem;
/*     */   }
/*     */   
/*     */   public boolean canFireProjectileWeapon(@NotNull Item item) {
/* 443 */     if (item instanceof ProjectileWeaponItem) { ProjectileWeaponItem weaponItem = (ProjectileWeaponItem)item;
/* 444 */       return m_5886_(weaponItem); }
/*     */     
/* 446 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6504_(@NotNull LivingEntity pTarget, float pVelocity) {
/* 451 */     ItemStack weaponStack = m_21120_(ProjectileUtil.getWeaponHoldingHand((LivingEntity)this, this::canFireProjectileWeapon));
/* 452 */     ItemStack itemstack = m_6298_(weaponStack);
/* 453 */     AbstractArrow mobArrow = ProjectileUtil.m_37300_((LivingEntity)this, itemstack, pVelocity);
/* 454 */     if (m_21205_().m_41720_() instanceof BowItem) {
/* 455 */       mobArrow = ((BowItem)m_21205_().m_41720_()).customArrow(mobArrow);
/*     */     }
/*     */     
/* 458 */     double x = pTarget.m_20185_() - m_20185_();
/* 459 */     double y = pTarget.m_20227_(0.3333333333333333D) - mobArrow.m_20186_();
/* 460 */     double z = pTarget.m_20189_() - m_20189_();
/* 461 */     double d3 = Math.sqrt(x * x + z * z);
/* 462 */     mobArrow.m_5602_((Entity)this);
/* 463 */     mobArrow.m_6686_(x, y + d3 * 0.20000000298023224D, z, 1.6F, (14 - m_9236_().m_46791_().m_19028_() * 4));
/* 464 */     m_5496_(SoundEvents.f_11687_, 1.0F, 1.0F / (m_217043_().m_188501_() * 0.4F + 0.8F));
/* 465 */     m_9236_().m_7967_((Entity)mobArrow);
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damageSource) {
/* 469 */     super.m_6667_(damageSource);
/* 470 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 471 */       if (getPersistentData().m_128471_("die_by_possess")) {
/* 472 */         m_142687_(Entity.RemovalReason.KILLED);
/*     */       } }
/*     */   
/*     */   }
/*     */   
/*     */   private boolean isInventoryFull() {
/* 478 */     for (int i = 0; i < this.inventory.m_6643_(); i++) {
/* 479 */       ItemStack s = this.inventory.m_8020_(i);
/* 480 */       if (s.m_41619_() || s.m_41613_() < s.m_41741_()) {
/* 481 */         return false;
/*     */       }
/*     */     } 
/* 484 */     return true;
/*     */   }
/*     */   
/*     */   private void pickupNearbyItems() {
/* 488 */     if (!m_6084_() || m_213877_() || m_21224_())
/*     */       return; 
/* 490 */     AABB box = m_20191_().m_82400_(1.5D);
/* 491 */     List<ItemEntity> items = m_9236_().m_6443_(ItemEntity.class, box, e -> 
/*     */ 
/*     */         
/* 494 */         (!e.m_213877_() && !e.m_32063_()));
/*     */ 
/*     */     
/* 497 */     for (ItemEntity itemEntity : items) {
/* 498 */       tryPickup(itemEntity);
/*     */     }
/*     */   }
/*     */   
/*     */   private void tryPickup(final ItemEntity itemEntity) {
/* 503 */     ItemStack remaining = itemEntity.m_32055_().m_41777_();
/*     */     
/* 505 */     for (int i = 0; i < this.inventory.m_6643_() && !remaining.m_41619_() && 
/* 506 */       !remaining.m_41619_(); i++) {
/* 507 */       ItemStack slotStack = this.inventory.m_8020_(i);
/*     */       
/* 509 */       if (slotStack.m_41619_()) {
/* 510 */         this.inventory.m_6836_(i, remaining);
/* 511 */         remaining = ItemStack.f_41583_; break;
/*     */       } 
/* 513 */       if (ItemStack.m_150942_(slotStack, remaining) && slotStack
/* 514 */         .m_41613_() < slotStack.m_41741_()) {
/* 515 */         int transferable = Math.min(remaining
/* 516 */             .m_41613_(), slotStack
/* 517 */             .m_41741_() - slotStack.m_41613_());
/*     */         
/* 519 */         slotStack.m_41769_(transferable);
/* 520 */         remaining.m_41774_(transferable);
/*     */       } 
/*     */     } 
/*     */     
/* 524 */     if (remaining.m_41619_()) {
/* 525 */       itemEntity.m_20334_((
/* 526 */           m_20185_() - itemEntity.m_20185_()) * 0.25D, (
/* 527 */           m_20186_() + 1.0D - itemEntity.m_20186_()) * 0.25D, (
/* 528 */           m_20189_() - itemEntity.m_20189_()) * 0.25D);
/*     */       
/* 530 */       itemEntity.m_32010_(0);
/* 531 */       final PlayerNpcEntity entity = this;
/* 532 */       new DelayedTask(5)
/*     */         {
/*     */           public void run() {
/* 535 */             if (!entity.m_6084_() || entity.m_213877_() || entity.m_21224_()) {
/*     */               return;
/*     */             }
/* 538 */             entity.m_9236_();
/*     */             
/* 540 */             itemEntity.m_146870_();
/* 541 */             entity.m_9236_().m_5594_(null, entity.m_20183_(), SoundEvents.f_12019_, SoundSource.HOSTILE, 0.2F, 1.0F);
/*     */           }
/*     */         };
/*     */     } else {
/* 545 */       itemEntity.m_32045_(remaining);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void m_8119_() {
/*     */     final ServerLevel serverLevel;
/* 551 */     super.m_8119_();
/* 552 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else { return; }
/* 554 */      if (this.stunEscapeCooldown == 0 && m_9236_() instanceof ServerLevel && 
/* 555 */       getLivingEntityPatch() != null) {
/* 556 */       final AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getLivingEntityPatch().getAnimator().getPlayerFor(null))).getRealAnimation();
/* 557 */       if (EpicfightUtil.isLongHitAnimationNotExecutedAnimation(dynamicAnimation, getLivingEntityPatch()) && m_6084_() && 
/* 558 */         m_217043_().m_188501_() < CombatBehaviour.calculateGuardBreakWakeUpChance((LivingEntity)this)) {
/* 559 */         this.stunEscapeCooldown = 100;
/* 560 */         this.playingIdleCooldown += 100;
/* 561 */         final PlayerNpcEntity entity = this;
/* 562 */         new DelayedTask((new Random()).nextInt(5, 10))
/*     */           {
/*     */             public void run() {
/* 565 */               if (PlayerNpcEntity.this.getLivingEntityPatch() != null && EpicfightUtil.isLongHitAnimationNotExecutedAnimation(dynamicAnimation, PlayerNpcEntity.this.getLivingEntityPatch()) && entity.m_6084_()) {
/* 566 */                 CombatBehaviour.postGuardBreakWakeUp((LivingEntity)entity, PlayerNpcEntity.this.getLivingEntityPatch(), serverLevel);
/*     */               } else {
/* 568 */                 entity.stunEscapeCooldown = 1;
/*     */               } 
/*     */             }
/*     */           };
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 577 */     if (this.gapCooldown > 0) this.gapCooldown--; 
/* 578 */     if (this.enderPearlCooldown > 0) this.enderPearlCooldown--; 
/* 579 */     if (this.swapToBowCooldown > 0) this.swapToBowCooldown--; 
/* 580 */     if (this.stunEscapeCooldown > 0) this.stunEscapeCooldown--; 
/* 581 */     if (this.playingIdleCooldown > 0) this.playingIdleCooldown--;
/*     */     
/* 583 */     if ((this.f_19797_ + m_19879_()) % 20 != 0) {
/*     */       return;
/*     */     }
/*     */     
/* 587 */     if (isInventoryFull())
/*     */       return; 
/* 589 */     pickupNearbyItems();
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 593 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawngroupdata, compoundtag);
/*     */     
/* 595 */     ServerLevel serverLevel = serverLevelAccessor.m_6018_();
/*     */     
/* 597 */     if ((mobSpawnType == MobSpawnType.CHUNK_GENERATION || mobSpawnType == MobSpawnType.NATURAL) && serverLevel.m_46461_() && Math.random() <= 0.8D) {
/* 598 */       BlockPos blockPos = m_20097_();
/* 599 */       int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, blockPos).m_123342_();
/* 600 */       BlockPos spawnPos = new BlockPos(blockPos.m_123341_(), surfaceY, blockPos.m_123343_());
/* 601 */       if (serverLevel.m_6425_(spawnPos).m_76178_()) {
/* 602 */         m_20035_(spawnPos, m_146908_(), m_146909_());
/*     */       }
/*     */     } 
/*     */     
/* 606 */     this.target = PlayerNpcTarget.randomByWeight(m_217043_());
/* 607 */     if (this.target != null) {
/* 608 */       switch (this.target) {
/*     */         case HOSTILE_HUNTER:
/* 610 */           hostileHunterPlayerMob();
/*     */           break;
/*     */         case VILLAGER_HUNTER:
/* 613 */           villagerHunterPlayerMob();
/*     */           break;
/*     */         case MONSTER_HUNTER:
/* 616 */           monsterHunterPlayerMob();
/*     */           break;
/*     */         case PLAYER_HUNTER:
/* 619 */           playerHunterPlayerMob();
/*     */           break;
/*     */         case ANIMAL_HUNTER:
/* 622 */           animalHunterPlayerMob();
/*     */           break;
/*     */         default:
/* 625 */           CommonGoals.runAwayFromHerobrineGoals((PathfinderMob)this, 20.0F);
/* 626 */           CommonGoals.runAwayFromVillagerArmyGoals(this);
/* 627 */           if (!(m_5448_() instanceof Player)) {
/* 628 */             this.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal((PathfinderMob)this, Player.class, 20.0F, 1.2D, 1.8D));
/*     */           }
/*     */           break;
/*     */       } 
/*     */     
/*     */     }
/* 634 */     List<String> commands = EquipmentDataLoader.getEquipCommands(0.85F, (Entity)this);
/* 635 */     for (String cmd : commands) {
/*     */       try {
/* 637 */         ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_20194_())).m_129892_().m_82094_().execute(cmd, 
/*     */             
/* 639 */             m_20203_().m_81324_().m_81325_(4));
/*     */       }
/* 641 */       catch (CommandSyntaxException commandSyntaxException) {}
/*     */     } 
/*     */ 
/*     */     
/* 645 */     this.mainWeaponItem = m_21205_().m_41777_();
/* 646 */     this.offWeaponItem = getOffWeaponItem().m_41777_();
/*     */     
/* 648 */     ChatUtil.joinGame((Entity)this);
/*     */     
/*     */     try {
/* 651 */       ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_20194_())).m_129892_().m_82094_().execute("data merge entity @s {CanPickUpLoot: 1b}", 
/*     */           
/* 653 */           m_20203_().m_81324_().m_81325_(4));
/* 654 */     } catch (CommandSyntaxException commandSyntaxException) {}
/*     */ 
/*     */     
/* 657 */     if (Math.random() <= 0.05D) {
/* 658 */       TeamUtil.addOrJoinTeam((Entity)this, "player");
/*     */     }
/*     */     
/* 661 */     if ((new Random()).nextBoolean()) {
/* 662 */       setUseBow(false);
/*     */     }
/*     */     
/* 665 */     return returnSpawnGroupData;
/*     */   }
/*     */   
/*     */   public void m_5993_(@NotNull Entity entity, int i, @NotNull DamageSource damageSource) {
/* 669 */     super.m_5993_(entity, i, damageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_238392_(@NotNull EquipmentSlot pSlot, @NotNull ItemStack pOldItem, @NotNull ItemStack pNewItem) {
/* 674 */     if (pSlot == EquipmentSlot.MAINHAND && (pNewItem
/* 675 */       .m_41720_() instanceof net.minecraft.world.item.SwordItem || pNewItem.m_41720_() instanceof net.minecraft.world.item.AxeItem)) {
/* 676 */       this.mainWeaponItem = pNewItem.m_41777_();
/*     */     }
/* 678 */     if (pSlot == EquipmentSlot.OFFHAND && (pNewItem
/* 679 */       .m_41720_() instanceof net.minecraft.world.item.SwordItem || pNewItem.m_41720_() instanceof net.minecraft.world.item.AxeItem || pNewItem.m_41720_() instanceof net.minecraft.world.item.ShieldItem)) {
/* 680 */       this.offWeaponItem = pNewItem.m_41777_();
/*     */     }
/* 682 */     super.m_238392_(pSlot, pOldItem, pNewItem);
/* 683 */     if ((m_9236_()).f_46443_)
/* 684 */       return;  if (!m_6084_() || m_21224_() || m_21223_() <= 0.0F)
/*     */       return; 
/* 686 */     if (isPlayingIdle() && getLivingEntityPatch() != null && this.idleAnimationAsset != null) {
/* 687 */       getLivingEntityPatch().playAnimationSynchronized(this.idleAnimationAsset, 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<PlayerNpcEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 692 */     ServerLevel serverLevel = level.m_6018_();
/* 693 */     if (serverLevel.m_46462_())
/*     */     {
/* 695 */       return false;
/*     */     }
/* 697 */     return Monster.m_219019_(entityType, (LevelAccessor)level, spawnType, position, random);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 701 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 703 */     builder = builder.m_22268_(Attributes.f_22279_, 0.45D);
/* 704 */     builder = builder.m_22268_(Attributes.f_22276_, 30.0D);
/* 705 */     builder = builder.m_22268_(Attributes.f_22284_, 0.0D);
/* 706 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 707 */     builder = builder.m_22268_(Attributes.f_22277_, 48.0D);
/* 708 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\PlayerNpcEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */