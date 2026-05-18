/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import se.gory_moon.player_mobs.utils.NameManager;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class ShadowHerobrineEntity
/*     */   extends HerobrineMob {
/*     */   private BlockProjectileEntity darkObUp;
/*     */   private UUID darkObUpUUID;
/*     */   private BlockProjectileEntity darkObLeft;
/*     */   private UUID darkObLeftUUID;
/*     */   private BlockProjectileEntity darkObRight;
/*     */   private UUID darkObRightUUID;
/*  53 */   private int summonDarkObCooldown = 0;
/*  54 */   private int obsidianMachineGunCooldown = 0;
/*  55 */   private int darkObParryCooldown = 0;
/*  56 */   private int obsidianMachineGunTick = 0;
/*     */   
/*     */   public void clearDarkOb() {
/*  59 */     if (this.darkObUp != null) {
/*  60 */       this.darkObUp.m_146870_();
/*  61 */       this.darkObUpUUID = null;
/*  62 */       this.darkObUp = null;
/*     */     } 
/*  64 */     if (this.darkObRight != null) {
/*  65 */       this.darkObRight.m_146870_();
/*  66 */       this.darkObRightUUID = null;
/*  67 */       this.darkObRight = null;
/*     */     } 
/*  69 */     if (this.darkObLeft != null) {
/*  70 */       this.darkObLeft.m_146870_();
/*  71 */       this.darkObLeftUUID = null;
/*  72 */       this.darkObLeft = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setObsidianMachineGunTick() {
/*  77 */     this.obsidianMachineGunTick = 20;
/*     */   }
/*     */   
/*     */   public int getObsidianMachineGunTick() {
/*  81 */     return this.obsidianMachineGunTick;
/*     */   }
/*     */   
/*     */   public boolean isDarkObReady() {
/*  85 */     return (this.darkObUp != null || this.darkObLeft != null || this.darkObRight != null);
/*     */   }
/*     */   
/*     */   public int getSummonDarkObCooldown() {
/*  89 */     return this.summonDarkObCooldown;
/*     */   }
/*     */   
/*     */   public void setSummonDarkObCooldown(int summonDarkObCooldown) {
/*  93 */     this.summonDarkObCooldown = summonDarkObCooldown;
/*     */   }
/*     */   
/*     */   public int getObsidianMachineGunCooldown() {
/*  97 */     return this.obsidianMachineGunCooldown;
/*     */   }
/*     */   
/*     */   public ShadowHerobrineEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/* 101 */     this((EntityType<ShadowHerobrineEntity>)AnnoyingVillagersModEntities.SHADOW_HEROBRINE.get(), level);
/*     */   }
/*     */   
/*     */   public ShadowHerobrineEntity(EntityType<ShadowHerobrineEntity> entitytype, Level level) {
/* 105 */     super(entitytype, level);
/* 106 */     m_274367_(2.8F);
/* 107 */     this.f_21364_ = 60;
/* 108 */     m_21557_(false);
/* 109 */     m_6593_(m_5446_());
/* 110 */     m_20340_(true);
/* 111 */     m_21530_();
/* 112 */     setChatName(m_5446_().getString());
/* 113 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get()));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/* 118 */     if (!isSacrificing()) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 119 */         if (Math.random() <= 0.5D && 
/* 120 */           !damageSource.m_276093_(DamageTypes.f_268612_) && 
/* 121 */           !damageSource.m_276093_(DamageTypes.f_268631_) && 
/* 122 */           !damageSource.m_276093_(DamageTypes.f_268468_)) {
/* 123 */           serverLevel.m_5594_(null, m_20183_(), (SoundEvent)AnnoyingVillagersModSounds.OBSIDIAN_PLACE.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/* 124 */           HerobrineUtil.spawnObsidianEyeLineStaggered(serverLevel, (Entity)this, ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_(), 1);
/* 125 */         } else if (getState() == 2) {
/* 126 */           Entity entity = damageSource.m_7639_(); if (entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity; if (this.darkObParryCooldown == 0)
/*     */             
/* 128 */             { if (this.darkObUp != null) {
/* 129 */                 this.darkObUp.m_20219_(livingEntity.m_20183_().m_252807_());
/* 130 */                 shootOne(this.darkObUp, livingEntity.m_20097_().m_252807_(), 2.0D, "up", this);
/* 131 */                 this.darkObParryCooldown = 40;
/* 132 */                 EpicfightUtil.damageBlocked(damageSource, (Entity)this.darkObUp, serverLevel);
/* 133 */                 if (!isDarkObReady()) {
/* 134 */                   this.summonDarkObCooldown = (new Random()).nextInt(200, 600);
/*     */                 }
/* 136 */                 return false;
/* 137 */               }  if (this.darkObRight != null) {
/* 138 */                 this.darkObRight.m_20219_(livingEntity.m_20183_().m_252807_());
/* 139 */                 shootOne(this.darkObRight, livingEntity.m_20097_().m_252807_(), 2.0D, "right", this);
/* 140 */                 this.darkObParryCooldown = 40;
/* 141 */                 EpicfightUtil.damageBlocked(damageSource, (Entity)this.darkObRight, serverLevel);
/* 142 */                 if (!isDarkObReady()) {
/* 143 */                   this.summonDarkObCooldown = (new Random()).nextInt(200, 600);
/*     */                 }
/* 145 */                 return false;
/* 146 */               }  if (this.darkObLeft != null)
/* 147 */               { this.darkObLeft.m_20219_(livingEntity.m_20183_().m_252807_());
/* 148 */                 shootOne(this.darkObLeft, livingEntity.m_20097_().m_252807_(), 2.0D, "left", this);
/* 149 */                 this.darkObParryCooldown = 40;
/* 150 */                 EpicfightUtil.damageBlocked(damageSource, (Entity)this.darkObLeft, serverLevel);
/* 151 */                 if (!isDarkObReady()) {
/* 152 */                   this.summonDarkObCooldown = (new Random()).nextInt(200, 600);
/*     */                 }
/* 154 */                 return false; }  }  }
/*     */         
/*     */         }  }
/*     */        }
/* 158 */      if (damageSource.m_276093_(DamageTypes.f_268671_)) return false; 
/* 159 */     if (damageSource.m_276093_(DamageTypes.f_268585_)) return false; 
/* 160 */     if (damageSource.m_276093_(DamageTypes.f_268493_)) return false; 
/* 161 */     if (damageSource.m_276093_(DamageTypes.f_268722_)) return false; 
/* 162 */     if (damageSource.m_276093_(DamageTypes.f_268641_)) return false; 
/* 163 */     if (damageSource.m_276093_(DamageTypes.f_268482_)) return false; 
/* 164 */     if (!(damageSource.m_7640_() instanceof EnchantedArrowEntity) && damageSource
/* 165 */       .m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow && 
/* 166 */       !(damageSource.m_7640_() instanceof BlueDemonThrownTridentEntity)) return false; 
/* 167 */     return super.m_6469_(damageSource, f);
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damagesource) {
/* 171 */     super.m_6667_(damagesource);
/* 172 */     if (this.darkObUp != null) {
/* 173 */       this.darkObUp.m_146870_();
/*     */     }
/* 175 */     if (this.darkObRight != null) {
/* 176 */       this.darkObRight.m_146870_();
/*     */     }
/* 178 */     if (this.darkObLeft != null) {
/* 179 */       this.darkObLeft.m_146870_();
/*     */     }
/* 181 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 182 */       InfectedPlayerNpcEntity corpse = new InfectedPlayerNpcEntity((EntityType<? extends InfectedPlayerNpcEntity>)AnnoyingVillagersModEntities.INFECTED_PLAYER_NPC.get(), (Level)serverLevel);
/* 183 */       corpse.m_7678_(m_20185_(), m_20186_(), m_20189_(), m_146908_(), m_146909_());
/* 184 */       String killedName = getPersistentData().m_128461_("killed_name");
/* 185 */       corpse.getPersistentData().m_128359_("possessed_by", "shadow_herobrine");
/* 186 */       if (killedName.isEmpty()) {
/* 187 */         killedName = String.valueOf(NameManager.INSTANCE.getRandomName());
/*     */       }
/* 189 */       corpse.setUsername(killedName);
/* 190 */       corpse.m_6593_((Component)Component.m_237113_(killedName));
/* 191 */       corpse.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*     */       
/* 193 */       m_6842_(true);
/* 194 */       m_142687_(Entity.RemovalReason.KILLED);
/* 195 */       serverLevel.m_7967_((Entity)corpse); }
/*     */   
/*     */   }
/*     */   
/*     */   private void enchantGear(ItemStack itemStack) {
/* 200 */     itemStack.m_41663_(Enchantments.f_44977_, 5);
/* 201 */     itemStack.m_41663_(Enchantments.f_44983_, 5);
/* 202 */     itemStack.m_41663_(Enchantments.f_44980_, 3);
/*     */   }
/*     */   
/*     */   public void rollItem() {
/*     */     ItemStack mainHandWeapon;
/* 207 */     super.rollItem();
/* 208 */     ItemStack mainHand = m_21205_();
/*     */     
/* 210 */     ItemStack offHandWeapon = ItemStack.f_41583_;
/* 211 */     if (mainHand.m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianWeaponItem) {
/* 212 */       if ((new Random()).nextBoolean()) {
/* 213 */         mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get());
/* 214 */         if (getState() == 2) {
/* 215 */           enchantGear(mainHandWeapon);
/*     */         }
/* 217 */         if ((new Random()).nextBoolean()) {
/* 218 */           offHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 219 */           if (getState() == 2) {
/* 220 */             enchantGear(offHandWeapon);
/*     */           }
/*     */         } 
/*     */       } else {
/* 224 */         mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 225 */         if (getState() == 2) {
/* 226 */           enchantGear(mainHandWeapon);
/*     */         }
/* 228 */         if ((new Random()).nextBoolean()) {
/* 229 */           offHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 230 */           if (getState() == 2) {
/* 231 */             enchantGear(offHandWeapon);
/*     */           }
/*     */         } 
/*     */       } 
/* 235 */     } else if (mainHand.m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianPillarItem) {
/* 236 */       if ((new Random()).nextBoolean()) {
/* 237 */         mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_WEAPON.get());
/* 238 */         if (getState() == 2) {
/* 239 */           enchantGear(mainHandWeapon);
/*     */         }
/*     */       } else {
/* 242 */         mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 243 */         if (getState() == 2) {
/* 244 */           enchantGear(mainHandWeapon);
/*     */         }
/* 246 */         if ((new Random()).nextBoolean()) {
/* 247 */           offHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 248 */           if (getState() == 2) {
/* 249 */             enchantGear(offHandWeapon);
/*     */           }
/*     */         } 
/*     */       } 
/* 253 */     } else if (mainHand.m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/* 254 */       if ((new Random()).nextBoolean()) {
/* 255 */         mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_WEAPON.get());
/* 256 */         if (getState() == 2) {
/* 257 */           enchantGear(mainHandWeapon);
/*     */         }
/*     */       } else {
/* 260 */         mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get());
/* 261 */         if (getState() == 2) {
/* 262 */           enchantGear(mainHandWeapon);
/*     */         }
/* 264 */         if ((new Random()).nextBoolean()) {
/* 265 */           offHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 266 */           if (getState() == 2) {
/* 267 */             enchantGear(offHandWeapon);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } else {
/* 272 */       float chance = (new Random()).nextFloat();
/* 273 */       if (chance <= 0.3F) {
/* 274 */         if ((new Random()).nextBoolean()) {
/* 275 */           mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get());
/* 276 */           if (getState() == 2) {
/* 277 */             enchantGear(mainHandWeapon);
/*     */           }
/* 279 */           if ((new Random()).nextBoolean()) {
/* 280 */             offHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 281 */             if (getState() == 2) {
/* 282 */               enchantGear(offHandWeapon);
/*     */             }
/*     */           } 
/*     */         } else {
/* 286 */           mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 287 */           if (getState() == 2) {
/* 288 */             enchantGear(mainHandWeapon);
/*     */           }
/* 290 */           if ((new Random()).nextBoolean()) {
/* 291 */             offHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 292 */             if (getState() == 2) {
/* 293 */               enchantGear(offHandWeapon);
/*     */             }
/*     */           } 
/*     */         } 
/* 297 */       } else if (chance <= 0.6F) {
/* 298 */         if ((new Random()).nextBoolean()) {
/* 299 */           mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_WEAPON.get());
/* 300 */           if (getState() == 2) {
/* 301 */             enchantGear(mainHandWeapon);
/*     */           }
/*     */         } else {
/* 304 */           mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 305 */           if (getState() == 2) {
/* 306 */             enchantGear(mainHandWeapon);
/*     */           }
/* 308 */           if ((new Random()).nextBoolean()) {
/* 309 */             offHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 310 */             if (getState() == 2) {
/* 311 */               enchantGear(offHandWeapon);
/*     */             }
/*     */           }
/*     */         
/*     */         } 
/* 316 */       } else if ((new Random()).nextBoolean()) {
/* 317 */         mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_WEAPON.get());
/* 318 */         if (getState() == 2) {
/* 319 */           enchantGear(mainHandWeapon);
/*     */         }
/*     */       } else {
/* 322 */         mainHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get());
/* 323 */         if (getState() == 2) {
/* 324 */           enchantGear(mainHandWeapon);
/*     */         }
/* 326 */         if ((new Random()).nextBoolean()) {
/* 327 */           offHandWeapon = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get());
/* 328 */           if (getState() == 2) {
/* 329 */             enchantGear(offHandWeapon);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 335 */     m_21008_(InteractionHand.MAIN_HAND, mainHandWeapon);
/* 336 */     m_21008_(InteractionHand.OFF_HAND, offHandWeapon);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 341 */     super.m_7380_(tag);
/* 342 */     if (getPersistentData().m_128441_("Shooting")) {
/* 343 */       tag.m_128405_("Shooting", getPersistentData().m_128451_("Shooting"));
/*     */     }
/* 345 */     if (this.darkObUpUUID != null) {
/* 346 */       tag.m_128362_("DarkObUpUUID", this.darkObUpUUID);
/*     */     }
/* 348 */     if (this.darkObLeftUUID != null) {
/* 349 */       tag.m_128362_("DarkObLeftUUID", this.darkObLeftUUID);
/*     */     }
/* 351 */     if (this.darkObRightUUID != null) {
/* 352 */       tag.m_128362_("DarkObRightUUID", this.darkObRightUUID);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 358 */     super.m_7378_(tag);
/* 359 */     if (tag.m_128441_("Shooting")) {
/* 360 */       getPersistentData().m_128405_("Shooting", tag.m_128451_("Shooting"));
/*     */     }
/* 362 */     if (tag.m_128403_("DarkObUpUUID")) {
/* 363 */       this.darkObUpUUID = tag.m_128342_("DarkObUpUUID");
/*     */     }
/* 365 */     if (tag.m_128403_("DarkObLeftUUID")) {
/* 366 */       this.darkObLeftUUID = tag.m_128342_("DarkObLeftUUID");
/*     */     }
/* 368 */     if (tag.m_128403_("DarkObRightUUID")) {
/* 369 */       this.darkObRightUUID = tag.m_128342_("DarkObRightUUID");
/*     */     }
/*     */   }
/*     */   
/*     */   private Vec3 getUpBlockPos() {
/* 374 */     double upY = 2.0D;
/* 375 */     Vec3 eye = m_20299_(1.0F);
/* 376 */     return eye.m_82520_(0.0D, 2.0D, 0.0D);
/*     */   }
/*     */   
/*     */   private Vec3 getRightBlockPos() {
/* 380 */     double lateral = 2.0D;
/* 381 */     double sideY = 0.0D;
/*     */     
/* 383 */     Vec3 eye = m_20299_(1.0F);
/* 384 */     Vec3 look = m_20252_(1.0F);
/* 385 */     Vec3 horiz = new Vec3(look.f_82479_, 0.0D, look.f_82481_);
/*     */     
/* 387 */     if (horiz.m_82556_() < 1.0E-6D) {
/* 388 */       float yaw = m_146908_() * 0.017453292F;
/* 389 */       horiz = new Vec3(-Mth.m_14031_(yaw), 0.0D, Mth.m_14089_(yaw));
/*     */     } 
/* 391 */     Vec3 upAxis = new Vec3(0.0D, 1.0D, 0.0D);
/* 392 */     Vec3 rightAxis = horiz.m_82537_(upAxis).m_82541_();
/*     */     
/* 394 */     return eye.m_82549_(rightAxis.m_82490_(2.0D)).m_82520_(0.0D, 0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   private Vec3 getLeftBlockPos() {
/* 398 */     double lateral = 2.0D;
/* 399 */     double sideY = 0.0D;
/*     */     
/* 401 */     Vec3 eye = m_20299_(1.0F);
/* 402 */     Vec3 look = m_20252_(1.0F);
/* 403 */     Vec3 horiz = new Vec3(look.f_82479_, 0.0D, look.f_82481_);
/*     */     
/* 405 */     if (horiz.m_82556_() < 1.0E-6D) {
/* 406 */       float yaw = m_146908_() * 0.017453292F;
/* 407 */       horiz = new Vec3(-Mth.m_14031_(yaw), 0.0D, Mth.m_14089_(yaw));
/*     */     } 
/* 409 */     Vec3 upAxis = new Vec3(0.0D, 1.0D, 0.0D);
/* 410 */     Vec3 rightAxis = horiz.m_82537_(upAxis).m_82541_();
/* 411 */     Vec3 leftAxis = rightAxis.m_82490_(-1.0D);
/*     */     
/* 413 */     return eye.m_82549_(leftAxis.m_82490_(2.0D)).m_82520_(0.0D, 0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   public void spawnDarkObEntities() {
/* 417 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 418 */       BlockState block = ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_SHORT_PILLAR.get()).m_49966_();
/*     */       
/* 420 */       if (this.darkObUp == null) {
/*     */         
/* 422 */         BlockProjectileEntity darkObbyUp = new BlockProjectileEntity(m_9236_(), (LivingEntity)this, block);
/*     */ 
/*     */ 
/*     */         
/* 426 */         darkObbyUp.m_20242_(true);
/* 427 */         darkObbyUp.setNotReadyForShoot(true);
/* 428 */         darkObbyUp.m_20219_(getUpBlockPos());
/* 429 */         darkObbyUp.setOwnerUUID(m_20148_());
/* 430 */         serverLevel.m_7967_((Entity)darkObbyUp);
/* 431 */         this.darkObUpUUID = darkObbyUp.m_20148_();
/* 432 */         this.darkObUp = darkObbyUp;
/*     */       } 
/*     */       
/* 435 */       if (this.darkObRight == null) {
/*     */         
/* 437 */         BlockProjectileEntity darkObbyRight = new BlockProjectileEntity(m_9236_(), (LivingEntity)this, block);
/*     */ 
/*     */ 
/*     */         
/* 441 */         darkObbyRight.m_20242_(true);
/* 442 */         darkObbyRight.setNotReadyForShoot(true);
/* 443 */         darkObbyRight.setOwnerUUID(m_20148_());
/* 444 */         darkObbyRight.m_20219_(getRightBlockPos());
/* 445 */         serverLevel.m_7967_((Entity)darkObbyRight);
/* 446 */         this.darkObRightUUID = darkObbyRight.m_20148_();
/* 447 */         this.darkObRight = darkObbyRight;
/*     */       } 
/*     */       
/* 450 */       if (this.darkObLeft == null) {
/*     */         
/* 452 */         BlockProjectileEntity darkObbyLeft = new BlockProjectileEntity(m_9236_(), (LivingEntity)this, block);
/*     */ 
/*     */ 
/*     */         
/* 456 */         darkObbyLeft.m_20242_(true);
/* 457 */         darkObbyLeft.setNotReadyForShoot(true);
/* 458 */         darkObbyLeft.setOwnerUUID(m_20148_());
/* 459 */         darkObbyLeft.m_20219_(getLeftBlockPos());
/* 460 */         serverLevel.m_7967_((Entity)darkObbyLeft);
/* 461 */         this.darkObLeftUUID = darkObbyLeft.m_20148_();
/* 462 */         this.darkObLeft = darkObbyLeft;
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public void shootChain(BlockState block, float velocity, int length) {
/* 468 */     ShadowHerobrineEntity shadowHerobrineEntity = this;
/* 469 */     Level level = shadowHerobrineEntity.m_9236_();
/* 470 */     if (level.f_46443_)
/*     */       return; 
/* 472 */     double eyeY = shadowHerobrineEntity.m_20188_();
/* 473 */     Vec3 look = shadowHerobrineEntity.m_20154_().m_82541_();
/* 474 */     RandomSource rand = level.m_213780_();
/*     */     
/* 476 */     for (int i = 0; i < length; i++) {
/*     */ 
/*     */       
/* 479 */       BlockProjectileEntity proj = new BlockProjectileEntity(level, (shadowHerobrineEntity instanceof LivingEntity) ? (LivingEntity)shadowHerobrineEntity : null, block);
/*     */ 
/*     */ 
/*     */       
/* 483 */       Vec3 forward = look.m_82490_(i * 1.0D);
/*     */       
/* 485 */       double sideX = (rand.m_188500_() - 0.5D) * 2.0D;
/* 486 */       double sideY = (rand.m_188500_() - 0.5D) * 2.0D;
/* 487 */       double sideZ = (rand.m_188500_() - 0.5D) * 2.0D;
/*     */       
/* 489 */       proj.m_6034_(shadowHerobrineEntity
/* 490 */           .m_20185_() + forward.f_82479_ + sideX, eyeY + forward.f_82480_ + sideY, shadowHerobrineEntity
/*     */           
/* 492 */           .m_20189_() + forward.f_82481_ + sideZ);
/*     */       
/* 494 */       proj.m_20256_(look.m_82490_(velocity));
/*     */       
/* 496 */       level.m_7967_((Entity)proj);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void shootOne(BlockProjectileEntity ob, Vec3 to, double speed, String position, ShadowHerobrineEntity shadowHerobrineEntity) {
/* 501 */     if (ob == null || !ob.m_6084_())
/* 502 */       return;  Vec3 dir = to.m_82546_(ob.m_20182_());
/* 503 */     if (dir.m_82556_() < 1.0E-6D) dir = m_20154_(); 
/* 504 */     ob.m_20242_(false);
/* 505 */     Vec3 vel = dir.m_82541_().m_82490_(speed);
/* 506 */     ob.m_20256_(vel);
/* 507 */     ob.setNotReadyForShoot(false);
/* 508 */     if (position.equals("up")) {
/* 509 */       shadowHerobrineEntity.darkObUpUUID = null;
/* 510 */       shadowHerobrineEntity.darkObUp = null;
/* 511 */     } else if (position.equals("left")) {
/* 512 */       shadowHerobrineEntity.darkObLeftUUID = null;
/* 513 */       shadowHerobrineEntity.darkObLeft = null;
/* 514 */     } else if (position.equals("right")) {
/* 515 */       shadowHerobrineEntity.darkObRightUUID = null;
/* 516 */       shadowHerobrineEntity.darkObRight = null;
/*     */     } 
/*     */   }
/*     */   public void shootDarkObsAtTarget(double speed) {
/*     */     Vec3 to;
/* 521 */     ShadowHerobrineEntity shadowHerobrineEntity = this;
/* 522 */     if ((shadowHerobrineEntity.m_9236_()).f_46443_) {
/*     */       return;
/*     */     }
/* 525 */     LivingEntity target = shadowHerobrineEntity.m_5448_();
/* 526 */     if (target != null && target.m_6084_()) {
/* 527 */       to = target.m_20299_(1.0F);
/*     */     } else {
/* 529 */       to = shadowHerobrineEntity.m_146892_().m_82549_(shadowHerobrineEntity.m_20154_().m_82490_(16.0D));
/*     */     } 
/*     */     
/* 532 */     if (shadowHerobrineEntity.darkObUp != null) {
/* 533 */       shootOne(shadowHerobrineEntity.darkObUp, to, speed, "up", shadowHerobrineEntity);
/*     */     }
/* 535 */     if (shadowHerobrineEntity.darkObLeft != null) {
/* 536 */       shootOne(shadowHerobrineEntity.darkObLeft, to, speed, "left", shadowHerobrineEntity);
/*     */     }
/* 538 */     if (shadowHerobrineEntity.darkObRight != null) {
/* 539 */       shootOne(shadowHerobrineEntity.darkObRight, to, speed, "right", shadowHerobrineEntity);
/*     */     }
/*     */     
/* 542 */     this.summonDarkObCooldown = (new Random()).nextInt(200, 600);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 547 */     super.m_8119_();
/* 548 */     if (m_9236_() instanceof ServerLevel) {
/* 549 */       if (this.summonDarkObCooldown > 0) this.summonDarkObCooldown--; 
/* 550 */       if (this.darkObParryCooldown > 0) this.darkObParryCooldown--; 
/* 551 */       if (this.obsidianMachineGunCooldown > 0) this.obsidianMachineGunCooldown--; 
/* 552 */       if (this.obsidianMachineGunTick > 0) {
/* 553 */         if (this.obsidianMachineGunTick == 1) {
/* 554 */           this.obsidianMachineGunCooldown = (new Random()).nextInt(200, 300);
/* 555 */           rollItem();
/*     */         } 
/* 557 */         this.obsidianMachineGunTick--;
/* 558 */         BlockState block = ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_();
/* 559 */         m_20256_(Vec3.f_82478_);
/* 560 */         shootChain(block, 2.5F, 5);
/*     */       } 
/*     */       
/* 563 */       if (this.darkObUp == null && this.darkObUpUUID != null) {
/* 564 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.darkObUpUUID);
/* 565 */         if (entity instanceof BlockProjectileEntity) { BlockProjectileEntity blockProjectileEntity = (BlockProjectileEntity)entity;
/* 566 */           this.darkObUp = blockProjectileEntity; }
/*     */         else
/* 568 */         { this.darkObUpUUID = null; }
/*     */       
/*     */       } 
/* 571 */       if (this.darkObLeft == null && this.darkObLeftUUID != null) {
/* 572 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.darkObLeftUUID);
/* 573 */         if (entity instanceof BlockProjectileEntity) { BlockProjectileEntity blockProjectileEntity = (BlockProjectileEntity)entity;
/* 574 */           this.darkObLeft = blockProjectileEntity; }
/*     */         else
/* 576 */         { this.darkObLeftUUID = null; }
/*     */       
/*     */       } 
/* 579 */       if (this.darkObRight == null && this.darkObRightUUID != null) {
/* 580 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.darkObRightUUID);
/* 581 */         if (entity instanceof BlockProjectileEntity) { BlockProjectileEntity blockProjectileEntity = (BlockProjectileEntity)entity;
/* 582 */           this.darkObRight = blockProjectileEntity; }
/*     */         else
/* 584 */         { this.darkObRightUUID = null; }
/*     */       
/*     */       } 
/* 587 */       if (this.darkObUp != null) {
/* 588 */         this.darkObUp.m_20219_(getUpBlockPos());
/*     */       }
/* 590 */       if (this.darkObRight != null) {
/* 591 */         this.darkObRight.m_20219_(getRightBlockPos());
/*     */       }
/* 593 */       if (this.darkObLeft != null) {
/* 594 */         this.darkObLeft.m_20219_(getLeftBlockPos());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 601 */     super.m_142687_(reason);
/* 602 */     if (this.darkObUp != null) {
/* 603 */       this.darkObUp.m_146870_();
/*     */     }
/* 605 */     if (this.darkObLeft != null) {
/* 606 */       this.darkObLeft.m_146870_();
/*     */     }
/* 608 */     if (this.darkObRight != null) {
/* 609 */       this.darkObRight.m_146870_();
/*     */     }
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 614 */     return Mob.m_21552_()
/* 615 */       .m_22268_(Attributes.f_22276_, 250.0D)
/* 616 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 617 */       .m_22268_(Attributes.f_22281_, 10.0D)
/* 618 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 619 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 620 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 621 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 622 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 623 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 624 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 625 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 626 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 627 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ShadowHerobrineEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */