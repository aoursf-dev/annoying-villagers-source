/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.util.TeamUtil;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
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
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
/*     */ import net.minecraft.world.entity.monster.AbstractSkeleton;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ 
/*     */ public class NullSkeletonEntity extends AbstractSkeleton {
/*     */   protected UUID nullUUID;
/*     */   protected NullEntity nullEntity;
/*     */   
/*     */   public NullSkeletonEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  50 */     this((EntityType<NullSkeletonEntity>)AnnoyingVillagersModEntities.NULL_SKELETON.get(), level);
/*     */   }
/*     */   protected UUID playerUUID; protected Player player;
/*     */   public void setPlayer(Player player) {
/*  54 */     this.playerUUID = player.m_20148_();
/*  55 */     this.player = player;
/*     */   }
/*     */   
/*     */   public NullEntity getNullEntity() {
/*  59 */     return this.nullEntity;
/*     */   }
/*     */   
/*     */   public void setNullEntity(NullEntity nullEntity) {
/*  63 */     this.nullUUID = nullEntity.m_20148_();
/*  64 */     this.nullEntity = nullEntity;
/*     */   }
/*     */   
/*     */   public NullSkeletonEntity(EntityType<NullSkeletonEntity> entitytype, Level level) {
/*  68 */     super(entitytype, level);
/*  69 */     m_274367_(2.0F);
/*  70 */     this.f_21364_ = 2;
/*  71 */     m_21409_(EquipmentSlot.MAINHAND, 0.0F);
/*  72 */     m_21409_(EquipmentSlot.OFFHAND, 0.0F);
/*  73 */     m_21409_(EquipmentSlot.CHEST, 0.0F);
/*  74 */     m_21409_(EquipmentSlot.HEAD, 0.0F);
/*  75 */     m_21409_(EquipmentSlot.LEGS, 0.0F);
/*  76 */     m_21409_(EquipmentSlot.FEET, 0.0F);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  80 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   private boolean isOwner(LivingEntity livingEntity) {
/*  84 */     if (livingEntity instanceof Player) { Player playerEntity = (Player)livingEntity; if (this.playerUUID != null && this.playerUUID.equals(playerEntity.m_20148_())); }  return false;
/*     */   }
/*     */   
/*     */   private boolean validTarget(LivingEntity livingEntity) {
/*  88 */     return (livingEntity != null && livingEntity.m_6084_() && !isOwner(livingEntity));
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  92 */     this.f_21345_.m_25352_(1, new Goal()
/*     */         {
/*     */           public boolean m_8036_() {
/*  95 */             return (NullSkeletonEntity.this.nullEntity != null && NullSkeletonEntity.this.nullEntity.m_6084_() && NullSkeletonEntity.this.m_20270_((Entity)NullSkeletonEntity.this.nullEntity) > 18.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           public void m_8037_() {
/* 100 */             if (NullSkeletonEntity.this.nullEntity != null && NullSkeletonEntity.this.nullEntity.m_6084_()) {
/* 101 */               NullSkeletonEntity.this.m_21573_().m_5624_((Entity)NullSkeletonEntity.this.nullEntity, 2.0D);
/* 102 */               NullSkeletonEntity.this.m_21563_().m_24960_((Entity)NullSkeletonEntity.this.nullEntity, 30.0F, 30.0F);
/* 103 */               if (NullSkeletonEntity.this.m_20280_((Entity)NullSkeletonEntity.this.nullEntity) > 20.0D) {
/* 104 */                 if (NullSkeletonEntity.this.m_21573_().m_26571_()) {
/* 105 */                   NullSkeletonEntity.this.m_21573_().m_5624_((Entity)NullSkeletonEntity.this.nullEntity, 2.0D);
/*     */                 }
/*     */               } else {
/* 108 */                 NullSkeletonEntity.this.m_21573_().m_26573_();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean m_8045_() {
/* 115 */             return (NullSkeletonEntity.this.nullEntity != null && NullSkeletonEntity.this.nullEntity.m_6084_() && NullSkeletonEntity.this.m_20270_((Entity)NullSkeletonEntity.this.nullEntity) > 50.0D);
/*     */           }
/*     */         });
/* 118 */     this.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, livingEntity -> 
/* 119 */           (validTarget(livingEntity) && this.player != null && this.player.m_6084_() && this.player.m_21188_() == livingEntity)));
/*     */ 
/*     */ 
/*     */     
/* 123 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, livingEntity -> 
/* 124 */           (validTarget(livingEntity) && this.player != null && this.player.m_6084_() && this.player.m_21214_() == livingEntity)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     this.f_21345_.m_25352_(1, new Goal()
/*     */         {
/*     */           public boolean m_8036_() {
/* 132 */             return (NullSkeletonEntity.this.player != null && NullSkeletonEntity.this.player.m_6084_() && NullSkeletonEntity.this.m_20270_((Entity)NullSkeletonEntity.this.player) > 18.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           public void m_8037_() {
/* 137 */             if (NullSkeletonEntity.this.player != null && NullSkeletonEntity.this.player.m_6084_()) {
/* 138 */               NullSkeletonEntity.this.m_21573_().m_5624_((Entity)NullSkeletonEntity.this.player, 2.0D);
/* 139 */               NullSkeletonEntity.this.m_21563_().m_24960_((Entity)NullSkeletonEntity.this.player, 30.0F, 30.0F);
/* 140 */               if (NullSkeletonEntity.this.m_20280_((Entity)NullSkeletonEntity.this.player) > 20.0D) {
/* 141 */                 if (NullSkeletonEntity.this.m_21573_().m_26571_()) {
/* 142 */                   NullSkeletonEntity.this.m_21573_().m_5624_((Entity)NullSkeletonEntity.this.player, 2.0D);
/*     */                 }
/*     */               } else {
/* 145 */                 NullSkeletonEntity.this.m_21573_().m_26573_();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean m_8045_() {
/* 152 */             return (NullSkeletonEntity.this.player != null && NullSkeletonEntity.this.player.m_6084_() && NullSkeletonEntity.this.m_20270_((Entity)NullSkeletonEntity.this.player) > 50.0D);
/*     */           }
/*     */         });
/* 155 */     this.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, livingEntity -> 
/* 156 */           (validTarget(livingEntity) && this.nullEntity != null && this.nullEntity.m_6084_() && this.nullEntity.m_5448_() == livingEntity)));
/*     */ 
/*     */ 
/*     */     
/* 160 */     this.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, livingEntity -> 
/* 161 */           (validTarget(livingEntity) && this.nullEntity != null && this.nullEntity.m_6084_() && this.nullEntity.m_21188_() == livingEntity)));
/*     */ 
/*     */ 
/*     */     
/* 165 */     this.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, livingEntity -> 
/* 166 */           (validTarget(livingEntity) && this.nullEntity != null && this.nullEntity.m_6084_() && this.nullEntity.m_21214_() == livingEntity)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 173 */     return MobType.f_21641_;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 177 */     return -0.35D;
/*     */   }
/*     */   
/*     */   protected SoundEvent m_7515_() {
/* 181 */     return SoundEvents.f_12559_;
/*     */   }
/*     */   @NotNull
/*     */   protected SoundEvent m_7975_(@NotNull DamageSource pDamageSource) {
/* 185 */     return SoundEvents.f_12561_;
/*     */   }
/*     */   @NotNull
/*     */   protected SoundEvent m_5592_() {
/* 189 */     return SoundEvents.f_12560_;
/*     */   }
/*     */   @NotNull
/*     */   protected SoundEvent m_7878_() {
/* 193 */     return SoundEvents.f_12562_;
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 197 */     if (this.nullEntity != null) {
/* 198 */       TeamUtil.addOrJoinTeam((Entity)this, "herobrine");
/*     */     }
/*     */     try {
/* 201 */       ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_20194_())).m_129892_().m_82094_().execute("data merge entity @s {CanPickUpLoot: 1b}", 
/*     */           
/* 203 */           m_20203_().m_81324_().m_81325_(4));
/* 204 */     } catch (CommandSyntaxException commandSyntaxException) {}
/*     */     
/* 206 */     return super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawngroupdata, compoundtag);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_7327_(@NotNull Entity pEntity) {
/* 211 */     if (pEntity instanceof Player) { Player hurtPlayer = (Player)pEntity; if (this.playerUUID != null && this.playerUUID.equals(hurtPlayer.m_20148_()))
/* 212 */         return false;  }
/*     */     
/* 214 */     if (pEntity instanceof NullEntity) { NullEntity hurtNull = (NullEntity)pEntity; if (this.nullUUID != null && this.nullUUID.equals(hurtNull.m_20148_())) {
/* 215 */         return false;
/*     */       } }
/*     */     
/* 218 */     if (this.player != null) {
/* 219 */       float f = (float)m_21133_(Attributes.f_22281_);
/* 220 */       float f1 = (float)m_21133_(Attributes.f_22282_);
/* 221 */       if (pEntity instanceof LivingEntity) {
/* 222 */         f += EnchantmentHelper.m_44833_(m_21205_(), ((LivingEntity)pEntity).m_6336_());
/* 223 */         f1 += EnchantmentHelper.m_44894_((LivingEntity)this);
/*     */       } 
/*     */       
/* 226 */       int i = EnchantmentHelper.m_44914_((LivingEntity)this);
/* 227 */       if (i > 0) {
/* 228 */         pEntity.m_20254_(i * 4);
/*     */       }
/*     */       
/* 231 */       boolean flag = pEntity.m_6469_(m_269291_().m_269075_(this.player), f);
/* 232 */       if (flag) {
/* 233 */         if (f1 > 0.0F && pEntity instanceof LivingEntity) {
/* 234 */           ((LivingEntity)pEntity).m_147240_((f1 * 0.5F), Mth.m_14031_(m_146908_() * 0.017453292F), -Mth.m_14089_(m_146908_() * 0.017453292F));
/* 235 */           m_20256_(m_20184_().m_82542_(0.6D, 1.0D, 0.6D));
/*     */         } 
/* 237 */         m_19970_((LivingEntity)this, pEntity);
/* 238 */         m_21335_(pEntity);
/*     */       } 
/*     */       
/* 241 */       return flag;
/*     */     } 
/* 243 */     return super.m_7327_(pEntity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 249 */     super.m_8119_();
/* 250 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 251 */       if (this.f_19797_ == 1) {
/* 252 */         ItemStack sword = new ItemStack((ItemLike)Items.f_42388_);
/* 253 */         sword.m_41663_(Enchantments.f_44981_, 1);
/* 254 */         sword.m_41663_(Enchantments.f_44986_, 1);
/* 255 */         sword.m_41663_(Enchantments.f_44980_, 1);
/* 256 */         sword.m_41663_(Enchantments.f_44977_, 1);
/* 257 */         m_8061_(EquipmentSlot.MAINHAND, sword);
/* 258 */         ItemStack helmet = new ItemStack((ItemLike)Items.f_42472_);
/* 259 */         helmet.m_41663_(Enchantments.f_44972_, 1);
/* 260 */         helmet.m_41663_(Enchantments.f_44986_, 1);
/* 261 */         helmet.m_41663_(Enchantments.f_44965_, 1);
/* 262 */         m_8061_(EquipmentSlot.HEAD, helmet);
/*     */       } 
/* 264 */       if (this.nullEntity == null && this.nullUUID != null) {
/* 265 */         Entity entity = serverLevel.m_8791_(this.nullUUID);
/* 266 */         if (entity instanceof NullEntity) { NullEntity entityNull = (NullEntity)entity;
/* 267 */           this.nullEntity = entityNull; }
/*     */         else
/* 269 */         { this.nullEntity = null; }
/*     */       
/*     */       } 
/* 272 */       if (this.nullEntity != null && !this.nullEntity.m_6084_()) {
/* 273 */         this.nullEntity = null;
/* 274 */         this.nullUUID = null;
/* 275 */         m_6074_();
/*     */       } 
/* 277 */       if (this.nullEntity != null && this.nullEntity.m_6084_()) {
/* 278 */         double distanceSq = m_20280_((Entity)this.nullEntity);
/*     */         
/* 280 */         if (distanceSq > 600.0D) {
/* 281 */           m_6021_(this.nullEntity
/* 282 */               .m_20185_(), this.nullEntity
/* 283 */               .m_20186_(), this.nullEntity
/* 284 */               .m_20189_());
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 289 */       if (this.player == null && this.playerUUID != null) {
/* 290 */         this.player = serverLevel.m_46003_(this.playerUUID);
/*     */       }
/* 292 */       if (this.player != null && !this.player.m_6084_()) {
/* 293 */         this.player = null;
/* 294 */         this.playerUUID = null;
/* 295 */         m_6074_();
/*     */       } 
/* 297 */       if (this.player != null && this.player.m_6084_()) {
/* 298 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)this.player, PlayerPatch.class);
/* 299 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 300 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.NULL_WEAPON);
/* 301 */           if (skillContainer != null && !skillContainer.isActivated()) {
/* 302 */             m_6074_();
/*     */           } }
/*     */ 
/*     */         
/* 306 */         double distanceSq = m_20280_((Entity)this.player);
/*     */         
/* 308 */         if (distanceSq > 600.0D) {
/* 309 */           m_6021_(this.player
/* 310 */               .m_20185_(), this.player
/* 311 */               .m_20186_(), this.player
/* 312 */               .m_20189_());
/*     */         }
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource pSource, float pAmount) {
/* 321 */     if (this.player != null && pSource.m_7639_() == this.player) return false; 
/* 322 */     if (this.nullEntity != null && pSource.m_7639_() == this.nullEntity) return false; 
/* 323 */     if (!pSource.m_276093_(DamageTypes.f_268724_)) {
/* 324 */       float health = m_21223_();
/* 325 */       if (health - pAmount <= 5.0F) {
/* 326 */         m_21153_(0.0F);
/* 327 */         m_6667_(m_269291_().m_269341_());
/* 328 */         return true;
/*     */       } 
/*     */     } 
/* 331 */     return super.m_6469_(pSource, pAmount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 336 */     super.m_7380_(tag);
/* 337 */     if (this.nullUUID != null) {
/* 338 */       tag.m_128362_("NullUUID", this.nullUUID);
/*     */     }
/* 340 */     if (this.playerUUID != null) {
/* 341 */       tag.m_128362_("PlayerUUID", this.playerUUID);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 347 */     super.m_7378_(tag);
/* 348 */     if (tag.m_128403_("NullUUID")) {
/* 349 */       this.nullUUID = tag.m_128342_("NullUUID");
/*     */     }
/* 351 */     if (tag.m_128403_("PlayerUUID")) {
/* 352 */       this.playerUUID = tag.m_128342_("PlayerUUID");
/*     */     }
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder m_32166_() {
/* 357 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 359 */     builder = builder.m_22268_(Attributes.f_22279_, 0.45D);
/* 360 */     builder = builder.m_22268_(Attributes.f_22276_, 30.0D);
/* 361 */     builder = builder.m_22268_(Attributes.f_22284_, 10.0D);
/* 362 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 363 */     builder = builder.m_22268_(Attributes.f_22277_, 24.0D);
/* 364 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\NullSkeletonEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */