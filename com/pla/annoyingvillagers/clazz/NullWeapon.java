/*     */ package com.pla.annoyingvillagers.clazz;
/*     */ 
/*     */ import com.pla.annoyingvillagers.entity.NullEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.skill.NullWeaponSkill;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.TeamUtil;
/*     */ import java.util.EnumSet;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.DifficultyInstance;
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
/*     */ import net.minecraft.world.entity.ai.control.FlyingMoveControl;
/*     */ import net.minecraft.world.entity.ai.control.MoveControl;
/*     */ import net.minecraft.world.entity.ai.goal.FloatGoal;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
/*     */ import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
/*     */ import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
/*     */ import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
/*     */ import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
/*     */ import net.minecraft.world.entity.ai.navigation.PathNavigation;
/*     */ import net.minecraft.world.entity.ai.targeting.TargetingConditions;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.capabilities.item.WeaponCapability;
/*     */ import yesman.epicfight.world.capabilities.item.WeaponCategory;
/*     */ 
/*     */ public class NullWeapon extends Monster {
/*     */   protected UUID nullUUID;
/*  73 */   private int releaseCooldown = 0; protected NullEntity nullEntity; protected UUID playerUUID; protected Player player; protected String weapon;
/*     */   private boolean spinning = false;
/*     */   protected boolean released = false;
/*     */   
/*     */   public boolean isReleased() {
/*  78 */     return this.released;
/*     */   }
/*     */   
/*     */   public void stopRelease() {
/*  82 */     this.releaseCooldown = 1;
/*     */   }
/*     */   
/*     */   public void releaseForAWhile() {
/*  86 */     this.releaseCooldown = (new Random()).nextInt(300, 600);
/*  87 */     this.released = true;
/*     */   }
/*     */   
/*     */   public void setSpinning(boolean spinning) {
/*  91 */     this.spinning = spinning;
/*     */   }
/*     */   
/*     */   public boolean isSpinning() {
/*  95 */     return this.spinning;
/*     */   }
/*     */   
/*     */   public void setReleased(boolean released) {
/*  99 */     this.released = released;
/* 100 */     if (released) {
/* 101 */       spinfor5seconds();
/*     */     }
/*     */   }
/*     */   
/*     */   public void spinfor5seconds() {
/* 106 */     final LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/* 107 */     if (livingEntityPatch != null) {
/* 108 */       livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.GLOWING_AGONY_GUARD, 0.0F);
/* 109 */       new DelayedTask(100)
/*     */         {
/*     */           public void run() {
/* 112 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F);
/*     */           }
/*     */         };
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setWeapon(String weapon) {
/* 119 */     this.weapon = weapon;
/* 120 */     switch (weapon) {
/*     */       case "sword":
/* 122 */         m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_SWORD.get()));
/*     */         return;
/*     */       case "pickaxe":
/* 125 */         m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_PICKAXE.get()));
/*     */         return;
/*     */       case "axe":
/* 128 */         m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_AXE.get()));
/*     */         return;
/*     */       case "hoe":
/* 131 */         m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_HOE.get()));
/*     */         return;
/*     */     } 
/* 134 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_SHOVEL.get()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNullUUID(UUID nullUUID) {
/* 140 */     this.nullUUID = nullUUID;
/*     */   }
/*     */   
/*     */   public void setNullEntity(NullEntity nullEntity) {
/* 144 */     this.nullEntity = nullEntity;
/*     */   }
/*     */   
/*     */   public void setPlayerUUID(UUID playerUUID) {
/* 148 */     this.playerUUID = playerUUID;
/*     */   }
/*     */   
/*     */   public void setPlayer(Player player) {
/* 152 */     this.player = player;
/*     */   }
/*     */   
/*     */   public UUID getPlayerUUID() {
/* 156 */     return this.playerUUID;
/*     */   }
/*     */   
/*     */   public UUID getNullUUID() {
/* 160 */     return this.nullUUID;
/*     */   }
/*     */   
/*     */   public NullEntity getNullEntity() {
/* 164 */     return this.nullEntity;
/*     */   }
/*     */   
/*     */   protected NullWeapon(EntityType<? extends Monster> pEntityType, Level pLevel) {
/* 168 */     super(pEntityType, pLevel);
/* 169 */     m_274367_(4.0F);
/* 170 */     this.f_21364_ = 80;
/* 171 */     m_21557_(false);
/* 172 */     m_21530_();
/* 173 */     this.f_21342_ = (MoveControl)new FlyingMoveControl((Mob)this, 10, true);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 177 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   @NotNull
/*     */   protected PathNavigation m_6037_(@NotNull Level level) {
/* 181 */     return (PathNavigation)new FlyingPathNavigation((Mob)this, level);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/* 185 */     super.m_8099_();
/* 186 */     this.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, target -> {
/*     */             if (this.player == null || !this.player.m_6084_()) {
/*     */               return false;
/*     */             }
/*     */             
/*     */             LivingEntity lastHurtBy = this.player.m_21188_();
/*     */             
/*     */             LivingEntity lastHurt = this.player.m_21214_();
/* 194 */             return ((target == lastHurtBy || target == lastHurt) && target.m_6084_() && !target.m_7307_((Entity)this.player));
/*     */           }));
/*     */ 
/*     */ 
/*     */     
/* 199 */     this.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, target -> (this.nullEntity != null && this.nullEntity.m_6084_() && target != null && this.nullEntity.m_5448_() == target)));
/*     */ 
/*     */ 
/*     */     
/* 203 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, target -> (this.nullEntity != null && this.nullEntity.m_6084_() && target != null && target.m_21214_() == this.nullEntity)));
/*     */ 
/*     */ 
/*     */     
/* 207 */     this.f_21345_.m_25352_(3, (Goal)new RandomStrollGoal((PathfinderMob)this, 0.4D, 20) {
/*     */           protected Vec3 m_7037_() {
/* 209 */             Random random = new Random();
/* 210 */             double d0 = NullWeapon.this.m_20185_() + (random.nextFloat() * 2.0F - 1.0F);
/* 211 */             double d1 = NullWeapon.this.m_20186_() + (random.nextFloat() * 2.0F - 1.0F);
/* 212 */             double d2 = NullWeapon.this.m_20189_() + (random.nextFloat() * 2.0F - 1.0F);
/*     */             
/* 214 */             return new Vec3(d0, d1, d2);
/*     */           }
/*     */         });
/* 217 */     this.f_21345_.m_25352_(4, (Goal)new LookAtPlayerGoal((Mob)this, NullEntity.class, 6.0F));
/* 218 */     this.f_21345_.m_25352_(5, (Goal)new FloatGoal((Mob)this));
/* 219 */     this.f_21346_.m_25352_(6, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
/* 220 */     this.f_21345_.m_25352_(7, new Goal()
/*     */         {
/*     */ 
/*     */           
/*     */           public boolean m_8036_()
/*     */           {
/* 226 */             return (NullWeapon.this.m_5448_() != null && !NullWeapon.this.m_21566_().m_24995_());
/*     */           }
/*     */           
/*     */           public boolean m_8045_() {
/* 230 */             return (NullWeapon.this.m_21566_().m_24995_() && NullWeapon.this.m_5448_() != null && NullWeapon.this.m_5448_().m_6084_());
/*     */           }
/*     */           
/*     */           public void m_8056_() {
/* 234 */             LivingEntity livingentity = NullWeapon.this.m_5448_();
/* 235 */             if (livingentity == null)
/* 236 */               return;  Vec3 vec3 = livingentity.m_20299_(1.0F);
/*     */             
/* 238 */             NullWeapon.this.f_21342_.m_6849_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, 2.0D);
/*     */           }
/*     */           
/*     */           public void m_8037_() {
/* 242 */             LivingEntity livingentity = NullWeapon.this.m_5448_();
/* 243 */             if (livingentity == null)
/* 244 */               return;  if (NullWeapon.this.m_20191_().m_82381_(livingentity.m_20191_())) {
/* 245 */               NullWeapon.this.m_7327_((Entity)livingentity);
/*     */             } else {
/* 247 */               double d0 = NullWeapon.this.m_20280_((Entity)livingentity);
/*     */               
/* 249 */               if (d0 < 16.0D) {
/* 250 */                 Vec3 vec3 = livingentity.m_20299_(1.0F);
/*     */                 
/* 252 */                 NullWeapon.this.f_21342_.m_6849_(vec3.f_82479_, vec3.f_82480_, vec3.f_82481_, 2.0D);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 262 */     super.m_7380_(tag);
/* 263 */     tag.m_128359_("Weapon", this.weapon);
/* 264 */     if (this.nullUUID != null) {
/* 265 */       tag.m_128362_("NullUUID", this.nullUUID);
/*     */     }
/* 267 */     if (this.playerUUID != null) {
/* 268 */       tag.m_128362_("OwnerUUID", this.playerUUID);
/*     */     }
/* 270 */     tag.m_128379_("Released", this.released);
/* 271 */     tag.m_128405_("ReleaseCooldown", this.releaseCooldown);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 276 */     super.m_7378_(tag);
/* 277 */     if (tag.m_128403_("NullUUID")) {
/* 278 */       this.nullUUID = tag.m_128342_("NullUUID");
/*     */     }
/* 280 */     if (tag.m_128403_("OwnerUUID")) {
/* 281 */       this.playerUUID = tag.m_128342_("OwnerUUID");
/*     */     }
/* 283 */     this.weapon = tag.m_128461_("Weapon");
/* 284 */     this.released = tag.m_128471_("Released");
/* 285 */     this.releaseCooldown = tag.m_128451_("ReleaseCooldown");
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 289 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 293 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 297 */     return -0.35D;
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damagesource) {
/* 301 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("", "")));
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_5592_() {
/* 305 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("", "")));
/*     */   }
/*     */   
/*     */   public boolean m_142535_(float f, float f1, @NotNull DamageSource damagesource) {
/* 309 */     return false;
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damagesource, float f) {
/* 313 */     return false;
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverlevelaccessor, @NotNull DifficultyInstance difficultyinstance, @NotNull MobSpawnType mobspawntype, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 317 */     TeamUtil.addOrJoinTeam((Entity)this, "herobrine");
/* 318 */     m_8061_(EquipmentSlot.LEGS, ItemStack.f_41583_);
/* 319 */     m_8061_(EquipmentSlot.CHEST, ItemStack.f_41583_);
/* 320 */     m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
/* 321 */     m_8061_(EquipmentSlot.FEET, ItemStack.f_41583_);
/* 322 */     m_8061_(EquipmentSlot.OFFHAND, ItemStack.f_41583_);
/* 323 */     m_20331_(true);
/* 324 */     return super.m_6518_(serverlevelaccessor, difficultyinstance, mobspawntype, spawngroupdata, compoundtag);
/*     */   }
/*     */   
/*     */   protected void m_7840_(double d0, boolean flag, @NotNull BlockState blockstate, @NotNull BlockPos blockpos) {}
/*     */   
/*     */   public void m_20242_(boolean flag) {
/* 330 */     super.m_20242_(true);
/*     */   }
/*     */   
/*     */   public void m_8107_() {
/* 334 */     super.m_8107_();
/* 335 */     m_20242_(true);
/*     */   } public void increaseSkillPoint(Entity entity, float value) {
/*     */     Player pEntity;
/*     */     ServerPlayerPatch serverPlayerPatch;
/* 339 */     if (entity instanceof Player) { pEntity = (Player)entity; }
/*     */     else { return; }
/* 341 */      PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)pEntity, PlayerPatch.class);
/* 342 */     if (playerPatch instanceof ServerPlayerPatch) { serverPlayerPatch = (ServerPlayerPatch)playerPatch; }
/*     */     else { return; }
/* 344 */      SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.NULL_WEAPON);
/* 345 */     if (skillContainer == null)
/*     */       return; 
/* 347 */     NullWeaponSkill skill = (NullWeaponSkill)skillContainer.getSkill();
/*     */     
/* 349 */     float currentResource = skillContainer.getResource();
/* 350 */     float neededResource = skillContainer.getNeededResource();
/* 351 */     float addResource = Math.min(value, neededResource);
/*     */     
/* 353 */     skill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_7327_(@NotNull Entity pEntity) {
/* 358 */     if (pEntity instanceof Player) { Player hurtPlayer = (Player)pEntity; if (this.playerUUID != null && this.playerUUID.equals(hurtPlayer.m_20148_()))
/* 359 */         return false;  }
/*     */     
/* 361 */     if (pEntity instanceof NullEntity) { NullEntity hurtNull = (NullEntity)pEntity; if (this.nullUUID != null && this.nullUUID.equals(hurtNull.m_20148_())) {
/* 362 */         return false;
/*     */       } }
/*     */     
/* 365 */     if (this.player != null) {
/* 366 */       float f = (float)m_21133_(Attributes.f_22281_);
/* 367 */       float f1 = (float)m_21133_(Attributes.f_22282_);
/* 368 */       if (pEntity instanceof LivingEntity) {
/* 369 */         f += EnchantmentHelper.m_44833_(m_21205_(), ((LivingEntity)pEntity).m_6336_());
/* 370 */         f1 += EnchantmentHelper.m_44894_((LivingEntity)this);
/*     */       } 
/*     */       
/* 373 */       int i = EnchantmentHelper.m_44914_((LivingEntity)this);
/* 374 */       if (i > 0) {
/* 375 */         pEntity.m_20254_(i * 4);
/*     */       }
/*     */       
/* 378 */       boolean flag = pEntity.m_6469_(m_269291_().m_269075_(this.player), f);
/* 379 */       increaseSkillPoint((Entity)this.player, 5.0F);
/* 380 */       if (flag) {
/* 381 */         if (f1 > 0.0F && pEntity instanceof LivingEntity) {
/* 382 */           ((LivingEntity)pEntity).m_147240_((f1 * 0.5F), Mth.m_14031_(m_146908_() * 0.017453292F), -Mth.m_14089_(m_146908_() * 0.017453292F));
/* 383 */           m_20256_(m_20184_().m_82542_(0.6D, 1.0D, 0.6D));
/*     */         } 
/* 385 */         m_19970_((LivingEntity)this, pEntity);
/* 386 */         m_21335_(pEntity);
/*     */       } 
/*     */       
/* 389 */       return flag;
/* 390 */     }  if (this.nullEntity != null) {
/* 391 */       float f = (float)m_21133_(Attributes.f_22281_);
/* 392 */       float f1 = (float)m_21133_(Attributes.f_22282_);
/* 393 */       if (pEntity instanceof LivingEntity) {
/* 394 */         f += EnchantmentHelper.m_44833_(m_21205_(), ((LivingEntity)pEntity).m_6336_());
/* 395 */         f1 += EnchantmentHelper.m_44894_((LivingEntity)this);
/*     */       } 
/*     */       
/* 398 */       int i = EnchantmentHelper.m_44914_((LivingEntity)this);
/* 399 */       if (i > 0) {
/* 400 */         pEntity.m_20254_(i * 4);
/*     */       }
/*     */       
/* 403 */       boolean flag = pEntity.m_6469_(m_269291_().m_269333_((LivingEntity)this.nullEntity), f);
/* 404 */       if (flag) {
/* 405 */         if (f1 > 0.0F && pEntity instanceof LivingEntity) {
/* 406 */           ((LivingEntity)pEntity).m_147240_((f1 * 0.5F), Mth.m_14031_(m_146908_() * 0.017453292F), -Mth.m_14089_(m_146908_() * 0.017453292F));
/* 407 */           m_20256_(m_20184_().m_82542_(0.6D, 1.0D, 0.6D));
/*     */         } 
/* 409 */         m_19970_((LivingEntity)this, pEntity);
/* 410 */         m_21335_(pEntity);
/*     */       } 
/*     */       
/* 413 */       return flag;
/*     */     } 
/* 415 */     return super.m_7327_(pEntity);
/*     */   }
/*     */   
/*     */   private static boolean isAllowedHeldCategory(Player p) {
/*     */     WeaponCapability weaponCap;
/* 420 */     ItemStack main = p.m_21205_();
/*     */     
/* 422 */     if (main.m_41720_() instanceof com.pla.annoyingvillagers.item.NullWeaponItem) return true;
/*     */     
/* 424 */     CapabilityItem cap = EpicFightCapabilities.getItemStackCapability(main);
/* 425 */     if (cap instanceof WeaponCapability) { weaponCap = (WeaponCapability)cap; } else { return true; }
/*     */     
/* 427 */     WeaponCategory cat = weaponCap.getWeaponCategory();
/* 428 */     return (cat == CapabilityItem.WeaponCategories.RANGED || cat == CapabilityItem.WeaponCategories.NOT_WEAPON);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean hasNullSword(Player p) {
/* 433 */     for (ItemStack s : (p.m_150109_()).f_35974_) {
/* 434 */       if (s.m_41720_() instanceof com.pla.annoyingvillagers.item.NullWeaponItem) return true; 
/*     */     } 
/* 436 */     for (ItemStack s : (p.m_150109_()).f_35976_) {
/* 437 */       if (s.m_41720_() instanceof com.pla.annoyingvillagers.item.NullWeaponItem) return true; 
/*     */     } 
/* 439 */     return false;
/*     */   }
/*     */   
/*     */   public void m_8119_() {
/*     */     ItemStack check;
/* 444 */     super.m_8119_();
/*     */     
/* 446 */     switch (this.weapon) {
/*     */       case "sword":
/* 448 */         check = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_SWORD.get());
/*     */         break;
/*     */       case "pickaxe":
/* 451 */         check = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_PICKAXE.get());
/*     */         break;
/*     */       case "axe":
/* 454 */         check = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_AXE.get());
/*     */         break;
/*     */       case "hoe":
/* 457 */         check = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_HOE.get());
/*     */         break;
/*     */       default:
/* 460 */         check = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_SHOVEL.get());
/*     */         break;
/*     */     } 
/* 463 */     if (m_6844_(EquipmentSlot.MAINHAND).m_41720_() != check.m_41720_()) {
/* 464 */       if (this.nullEntity == null && this.player != null) {
/* 465 */         m_146870_();
/*     */       }
/* 467 */       m_8061_(EquipmentSlot.MAINHAND, check);
/*     */     } 
/* 469 */     if (m_6844_(EquipmentSlot.OFFHAND) != ItemStack.f_41583_) {
/* 470 */       m_8061_(EquipmentSlot.OFFHAND, ItemStack.f_41583_);
/*     */     }
/* 472 */     if (m_6844_(EquipmentSlot.HEAD) != ItemStack.f_41583_) {
/* 473 */       m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
/*     */     }
/* 475 */     if (m_6844_(EquipmentSlot.CHEST) != ItemStack.f_41583_) {
/* 476 */       m_8061_(EquipmentSlot.CHEST, ItemStack.f_41583_);
/*     */     }
/* 478 */     if (m_6844_(EquipmentSlot.LEGS) != ItemStack.f_41583_) {
/* 479 */       m_8061_(EquipmentSlot.LEGS, ItemStack.f_41583_);
/*     */     }
/* 481 */     if (m_6844_(EquipmentSlot.FEET) != ItemStack.f_41583_) {
/* 482 */       m_8061_(EquipmentSlot.FEET, ItemStack.f_41583_);
/*     */     }
/* 484 */     if (!(m_9236_()).f_46443_) {
/* 485 */       if (this.nullEntity != null && !this.nullEntity.m_6084_()) {
/* 486 */         m_146870_();
/*     */         
/*     */         return;
/*     */       } 
/* 490 */       if (this.nullEntity == null && this.nullUUID == null && this.player == null && this.playerUUID == null) {
/* 491 */         m_146870_();
/*     */         
/*     */         return;
/*     */       } 
/* 495 */       ItemStack stack = m_21205_();
/* 496 */       m_21153_((stack.m_41776_() - stack.m_41773_()));
/* 497 */       if (this.nullEntity == null && this.nullUUID != null) {
/* 498 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.nullUUID);
/* 499 */         if (entity instanceof NullEntity) { NullEntity entityNull = (NullEntity)entity;
/* 500 */           this.nullEntity = entityNull; }
/*     */         else
/* 502 */         { this.nullEntity = null; }
/*     */       
/*     */       } 
/* 505 */       if (this.nullEntity != null && !this.nullEntity.m_6084_()) {
/* 506 */         this.nullEntity = null;
/* 507 */         this.nullUUID = null;
/*     */       } 
/* 509 */       if (this.player == null && this.playerUUID != null) {
/* 510 */         this.player = m_9236_().m_46003_(this.playerUUID);
/*     */       }
/* 512 */       if (this.player != null && !this.player.m_6084_()) {
/* 513 */         m_142687_(Entity.RemovalReason.KILLED);
/*     */       }
/* 515 */       if (this.player != null && this.player.m_6084_() && (
/* 516 */         !hasNullSword(this.player) || !isAllowedHeldCategory(this.player))) {
/* 517 */         m_142687_(Entity.RemovalReason.KILLED);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 522 */     if (m_5448_() == null && this.released) {
/* 523 */       this.released = false;
/*     */     }
/*     */     
/* 526 */     if (this.releaseCooldown > 0) {
/* 527 */       this.releaseCooldown--;
/*     */     }
/* 529 */     if (this.releaseCooldown == 0 && this.nullEntity != null && this.released) {
/* 530 */       this.released = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public static LivingEntity getNearestLivingEntity(Level level, Entity sourceEntity, double range) {
/* 535 */     AABB searchBox = sourceEntity.m_20191_().m_82400_(range);
/*     */     
/* 537 */     return level.m_45982_(level
/* 538 */         .m_6443_(LivingEntity.class, searchBox, e -> 
/* 539 */           (e != sourceEntity && !(e instanceof NullWeapon) && !(e instanceof reascer.wom.world.entity.mob.EnderHand) && !e.m_7307_(sourceEntity) && e.m_6084_())), TargetingConditions.f_26872_, (LivingEntity)sourceEntity, sourceEntity
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 546 */         .m_20185_(), sourceEntity.m_20186_(), sourceEntity.m_20189_());
/*     */   }
/*     */ 
/*     */   
/*     */   public void processTeleportByPlayer() {
/* 551 */     if (this.player == null)
/* 552 */       return;  if (!isReleased()) {
/* 553 */       m_6027_(this.player.m_20185_() + (new Random()).nextDouble(-4.0D, 4.0D), this.player.m_20186_() + (new Random()).nextDouble(-2.0D, 2.0D), this.player.m_20189_() + (new Random()).nextDouble(-4.0D, 4.0D));
/* 554 */     } else if (isReleased() && (this.player.m_21188_() != null || this.player.m_21214_() != null)) {
/* 555 */       LivingEntity target = (this.player.m_21188_() != null) ? this.player.m_21188_() : ((this.player.m_21214_() != null) ? this.player.m_21214_() : null);
/* 556 */       if (target == null) {
/* 557 */         target = getNearestLivingEntity(this.player.m_9236_(), (Entity)this.player, 12.0D);
/*     */       }
/* 559 */       if (target != null && target.m_6084_()) {
/* 560 */         m_6027_(target.m_20185_() + (new Random()).nextDouble(-4.0D, 4.0D), target.m_20186_() + (new Random()).nextDouble(-2.0D, 2.0D), target.m_20189_() + (new Random()).nextDouble(-4.0D, 4.0D));
/*     */       } else {
/* 562 */         this.released = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void processTeleportByNullEntity() {
/* 568 */     if (this.nullEntity == null)
/* 569 */       return;  if (!isReleased()) {
/* 570 */       m_6027_(this.nullEntity.m_20185_() + (new Random()).nextDouble(-4.0D, 4.0D), this.nullEntity.m_20186_() + (new Random()).nextDouble(-2.0D, 2.0D), this.nullEntity.m_20189_() + (new Random()).nextDouble(-4.0D, 4.0D));
/* 571 */     } else if (isReleased() && (this.nullEntity.m_21188_() != null || this.nullEntity.m_21214_() != null)) {
/* 572 */       LivingEntity target = (this.nullEntity.m_5448_() != null) ? this.nullEntity.m_5448_() : ((this.nullEntity.m_21188_() != null) ? this.nullEntity.m_21188_() : ((this.nullEntity.m_21214_() != null) ? this.nullEntity.m_21214_() : null));
/* 573 */       if (target == null) {
/* 574 */         target = getNearestLivingEntity(this.nullEntity.m_9236_(), (Entity)this.nullEntity, 12.0D);
/*     */       }
/* 576 */       if (target != null && target.m_6084_()) {
/* 577 */         m_6027_(target.m_20185_() + (new Random()).nextDouble(-4.0D, 4.0D), target.m_20186_() + (new Random()).nextDouble(-2.0D, 2.0D), target.m_20189_() + (new Random()).nextDouble(-4.0D, 4.0D));
/*     */       } else {
/* 579 */         stopRelease();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void summonNullWeaponForPlayer(String uuidNbt, ServerLevel serverLevel, Player summoner) {
/* 585 */     m_6027_(summoner.m_20185_() + (new Random()).nextDouble(-4.0D, 4.0D), summoner.m_20186_() + (new Random()).nextDouble(-2.0D, 2.0D), summoner.m_20189_() + (new Random()).nextDouble(-4.0D, 4.0D));
/* 586 */     this.playerUUID = summoner.m_20148_();
/* 587 */     this.player = summoner;
/* 588 */     m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/* 589 */     serverLevel.m_7967_((Entity)this);
/* 590 */     summoner.getPersistentData().m_128362_(uuidNbt, m_20148_());
/*     */   }
/*     */   
/*     */   public void summonNullWeaponForNullEntity(ServerLevel serverLevel, NullEntity summoner, String toolName) {
/* 594 */     m_6027_(summoner.m_20185_() + (new Random()).nextDouble(-4.0D, 4.0D), summoner.m_20186_() + (new Random()).nextDouble(-2.0D, 2.0D), summoner.m_20189_() + (new Random()).nextDouble(-4.0D, 4.0D));
/* 595 */     this.nullUUID = summoner.m_20148_();
/* 596 */     this.nullEntity = summoner;
/* 597 */     m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/* 598 */     serverLevel.m_7967_((Entity)this);
/* 599 */     summoner.setNullWeapon(toolName, this);
/* 600 */     spinfor5seconds();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_142687_(@NotNull Entity.RemovalReason pReason) {
/* 605 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 606 */       if (this.player != null) {
/* 607 */         switch (this.weapon) {
/*     */           case "sword":
/* 609 */             this.player.getPersistentData().m_128473_("NullSwordUUID");
/*     */             break;
/*     */           case "pickaxe":
/* 612 */             this.player.getPersistentData().m_128473_("NullPickaxeUUID");
/*     */             break;
/*     */           case "axe":
/* 615 */             this.player.getPersistentData().m_128473_("NullAxeUUID");
/*     */             break;
/*     */           case "hoe":
/* 618 */             this.player.getPersistentData().m_128473_("NullHoeUUID");
/*     */             break;
/*     */           default:
/* 621 */             this.player.getPersistentData().m_128473_("NullShovelUUID");
/*     */             break;
/*     */         } 
/*     */       } else {
/* 625 */         ItemEntity item = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_(), m_20189_(), m_21205_());
/* 626 */         item.m_32010_(10);
/* 627 */         serverLevel.m_7967_((Entity)item);
/*     */       }  }
/*     */     
/* 630 */     super.m_142687_(pReason);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 634 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 636 */     builder = builder.m_22268_(Attributes.f_22279_, 2.0D);
/* 637 */     builder = builder.m_22268_(Attributes.f_22276_, 100.0D);
/* 638 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 639 */     builder = builder.m_22268_(Attributes.f_22277_, 24.0D);
/* 640 */     builder = builder.m_22268_(Attributes.f_22280_, 2.0D);
/* 641 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\NullWeapon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */