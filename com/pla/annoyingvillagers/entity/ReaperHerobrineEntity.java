/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import com.pla.annoyingvillagers.util.TeamUtil;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
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
/*     */ import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class ReaperHerobrineEntity
/*     */   extends HerobrineMob {
/*     */   private HerobrineDragonEntity thunderHerobrineDragon;
/*     */   private UUID thunderHerobrineDragonUUID;
/*     */   private HerobrineDragonEntity meteoriteHerobrineDragon;
/*  44 */   private int dragonSummonCooldown = 0; private UUID meteoriteHerobrineDragonUUID; private HerobrineDragonEntity healingHerobrineDragon; private UUID healingHerobrineDragonUUID; private boolean spawnDragonInit = false;
/*     */   
/*     */   public ReaperHerobrineEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  47 */     this((EntityType<ReaperHerobrineEntity>)AnnoyingVillagersModEntities.REAPER_HEROBRINE.get(), level);
/*     */   }
/*     */   
/*     */   public ReaperHerobrineEntity(EntityType<ReaperHerobrineEntity> entitytype, Level level) {
/*  51 */     super(entitytype, level);
/*  52 */     m_274367_(2.9F);
/*  53 */     this.f_21364_ = 300;
/*  54 */     m_21557_(false);
/*  55 */     m_6593_(m_5446_());
/*  56 */     m_20340_(true);
/*  57 */     m_21530_();
/*  58 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_SLAYER_SCYTHE.get()));
/*  59 */     setChatName(m_5446_().getString());
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  64 */     return (SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY.get();
/*     */   }
/*     */   
/*     */   public HerobrineDragonEntity getThunderHerobrineDragon() {
/*  68 */     return this.thunderHerobrineDragon;
/*     */   }
/*     */   
/*     */   public UUID getThunderHerobrineDragonUUID() {
/*  72 */     return this.thunderHerobrineDragonUUID;
/*     */   }
/*     */   
/*     */   public HerobrineDragonEntity getMeteoriteHerobrineDragon() {
/*  76 */     return this.meteoriteHerobrineDragon;
/*     */   }
/*     */   
/*     */   public UUID getMeteoriteHerobrineDragonUUID() {
/*  80 */     return this.meteoriteHerobrineDragonUUID;
/*     */   }
/*     */   
/*     */   public HerobrineDragonEntity getHealingHerobrineDragon() {
/*  84 */     return this.healingHerobrineDragon;
/*     */   }
/*     */   
/*     */   public UUID getHealingHerobrineDragonUUID() {
/*  88 */     return this.healingHerobrineDragonUUID;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/*  93 */     super.m_7380_(tag);
/*  94 */     if (this.thunderHerobrineDragonUUID != null) {
/*  95 */       tag.m_128362_("ThunderHerobrineDragonUUID", this.thunderHerobrineDragonUUID);
/*     */     }
/*  97 */     if (this.meteoriteHerobrineDragonUUID != null) {
/*  98 */       tag.m_128362_("MeteoriteHerobrineDragonUUID", this.meteoriteHerobrineDragonUUID);
/*     */     }
/* 100 */     if (this.healingHerobrineDragonUUID != null) {
/* 101 */       tag.m_128362_("HealingHerobrineDragonUUID", this.healingHerobrineDragonUUID);
/*     */     }
/* 103 */     tag.m_128379_("SpawnDragonInit", this.spawnDragonInit);
/* 104 */     tag.m_128405_("DragonSummonCooldown", this.dragonSummonCooldown);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 109 */     super.m_7378_(tag);
/* 110 */     if (tag.m_128403_("ThunderHerobrineDragonUUID")) {
/* 111 */       this.thunderHerobrineDragonUUID = tag.m_128342_("ThunderHerobrineDragonUUID");
/*     */     }
/* 113 */     if (tag.m_128403_("MeteoriteHerobrineDragonUUID")) {
/* 114 */       this.meteoriteHerobrineDragonUUID = tag.m_128342_("MeteoriteHerobrineDragonUUID");
/*     */     }
/* 116 */     if (tag.m_128403_("HealingHerobrineDragonUUID")) {
/* 117 */       this.healingHerobrineDragonUUID = tag.m_128342_("HealingHerobrineDragonUUID");
/*     */     }
/* 119 */     this.spawnDragonInit = tag.m_128471_("SpawnDragonInit");
/* 120 */     this.dragonSummonCooldown = tag.m_128441_("DragonSummonCooldown") ? tag.m_128451_("DragonSummonCooldown") : this.dragonSummonCooldown;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void summonEnderDragon(int type) {
/* 127 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 128 */       HerobrineDragonEntity dragon = new HerobrineDragonEntity((EntityType<? extends HerobrineDragonEntity>)AnnoyingVillagersModEntities.HEROBRINE_DRAGON.get(), (Level)serverLevel);
/* 129 */       dragon.m_7678_(m_20185_(), m_20186_() + 20.0D, m_20189_(), m_217043_().m_188501_() * 360.0F, 0.0F);
/* 130 */       dragon.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(dragon.m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*     */       
/* 132 */       dragon.m_21530_();
/*     */       
/* 134 */       dragon.setSummoner((LivingEntity)this);
/* 135 */       dragon.setSummonerUUID(m_20148_());
/*     */       
/* 137 */       serverLevel.m_7967_((Entity)dragon);
/* 138 */       TeamUtil.addOrJoinTeam((Entity)dragon, "herobrine");
/*     */       
/* 140 */       if (type == 0) {
/* 141 */         this.thunderHerobrineDragonUUID = dragon.m_20148_();
/* 142 */         this.thunderHerobrineDragon = dragon;
/* 143 */       } else if (type == 1) {
/* 144 */         this.meteoriteHerobrineDragonUUID = dragon.m_20148_();
/* 145 */         this.meteoriteHerobrineDragon = dragon;
/*     */       } else {
/* 147 */         this.healingHerobrineDragonUUID = dragon.m_20148_();
/* 148 */         this.healingHerobrineDragon = dragon;
/* 149 */         EndCrystal endCrystal = new EndCrystal(EntityType.f_20564_, (Level)serverLevel);
/* 150 */         endCrystal.m_6027_(dragon.m_20185_(), dragon.m_20186_(), dragon.m_20189_());
/* 151 */         serverLevel.m_7967_((Entity)endCrystal);
/* 152 */         endCrystal.m_7998_((Entity)dragon, true);
/*     */       } 
/*     */       
/* 155 */       if (m_9236_().m_7654_() != null) {
/* 156 */         ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_(
/* 157 */             (Component)Component.m_237113_("<" + getChatName() + "> " + 
/* 158 */               Component.m_237115_("subtitles.herobrine_summon").getString()), false);
/*     */       } }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean m_6072_() {
/* 167 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 172 */     super.m_8119_();
/* 173 */     if (!(m_9236_()).f_46443_) {
/* 174 */       if (!this.spawnDragonInit) {
/* 175 */         this.spawnDragonInit = true;
/* 176 */         summonEnderDragon(0);
/*     */       } 
/*     */       
/* 179 */       if (this.dragonSummonCooldown <= 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 185 */         if (getState() < 2) {
/* 186 */           if (m_21223_() > m_21233_() / 2.0F && this.thunderHerobrineDragon == null && this.thunderHerobrineDragonUUID == null) {
/* 187 */             summonEnderDragon(0);
/* 188 */           } else if (m_21223_() <= m_21233_() / 2.0F && this.meteoriteHerobrineDragon == null && this.meteoriteHerobrineDragonUUID == null) {
/* 189 */             summonEnderDragon(1);
/*     */           } 
/* 191 */         } else if (getState() == 2) {
/* 192 */           if (this.thunderHerobrineDragon == null && this.thunderHerobrineDragonUUID == null) {
/* 193 */             summonEnderDragon(0);
/* 194 */           } else if (this.meteoriteHerobrineDragon == null && this.meteoriteHerobrineDragonUUID == null) {
/* 195 */             summonEnderDragon(1);
/* 196 */           } else if (this.healingHerobrineDragon == null && this.healingHerobrineDragonUUID == null) {
/* 197 */             summonEnderDragon(2);
/*     */           } 
/*     */         } 
/*     */       } else {
/* 201 */         this.dragonSummonCooldown--;
/*     */       } 
/*     */       
/* 204 */       if (this.thunderHerobrineDragon == null && this.thunderHerobrineDragonUUID != null) {
/* 205 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.thunderHerobrineDragonUUID);
/* 206 */         if (entity instanceof HerobrineDragonEntity) { HerobrineDragonEntity dragon = (HerobrineDragonEntity)entity;
/* 207 */           this.thunderHerobrineDragon = dragon; }
/*     */         else
/* 209 */         { this.thunderHerobrineDragon = null; }
/*     */       
/*     */       } 
/*     */       
/* 213 */       if (this.meteoriteHerobrineDragon == null && this.meteoriteHerobrineDragonUUID != null) {
/* 214 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.meteoriteHerobrineDragonUUID);
/* 215 */         if (entity instanceof HerobrineDragonEntity) { HerobrineDragonEntity dragon = (HerobrineDragonEntity)entity;
/* 216 */           this.meteoriteHerobrineDragon = dragon; }
/*     */         else
/* 218 */         { this.meteoriteHerobrineDragon = null; }
/*     */       
/*     */       } 
/*     */       
/* 222 */       if (this.healingHerobrineDragon == null && this.healingHerobrineDragonUUID != null) {
/* 223 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.healingHerobrineDragonUUID);
/* 224 */         if (entity instanceof HerobrineDragonEntity) { HerobrineDragonEntity dragon = (HerobrineDragonEntity)entity;
/* 225 */           this.healingHerobrineDragon = dragon; }
/*     */         else
/* 227 */         { this.healingHerobrineDragon = null; }
/*     */       
/*     */       } 
/*     */       
/* 231 */       if (this.thunderHerobrineDragon != null && !this.thunderHerobrineDragon.m_6084_()) {
/* 232 */         this.thunderHerobrineDragon = null;
/* 233 */         this.thunderHerobrineDragonUUID = null;
/*     */         
/* 235 */         if (m_9236_().m_7654_() != null) {
/* 236 */           ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_(
/* 237 */               (Component)Component.m_237113_("<" + getChatName() + ">  " + 
/* 238 */                 Component.m_237115_("subtitles.reaper_herobrine_return_dragon").getString()), false);
/*     */         }
/*     */ 
/*     */         
/* 242 */         if (this.dragonSummonCooldown == 0) {
/* 243 */           if (getState() < 2) {
/* 244 */             this.dragonSummonCooldown = (new Random()).nextInt(4800, 7200);
/* 245 */           } else if (getState() == 2) {
/* 246 */             this.dragonSummonCooldown = (new Random()).nextInt(2400, 4800);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 251 */       if (this.meteoriteHerobrineDragon != null && !this.meteoriteHerobrineDragon.m_6084_()) {
/* 252 */         this.meteoriteHerobrineDragon = null;
/* 253 */         this.meteoriteHerobrineDragonUUID = null;
/*     */         
/* 255 */         if (m_9236_().m_7654_() != null) {
/* 256 */           ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_(
/* 257 */               (Component)Component.m_237113_("<" + getChatName() + ">  " + 
/* 258 */                 Component.m_237115_("subtitles.reaper_herobrine_return_dragon").getString()), false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 263 */         if (this.dragonSummonCooldown == 0) {
/* 264 */           if (getState() < 2) {
/* 265 */             this.dragonSummonCooldown = (new Random()).nextInt(4800, 7200);
/* 266 */           } else if (getState() == 2) {
/* 267 */             this.dragonSummonCooldown = (new Random()).nextInt(2400, 4800);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 272 */       if (this.healingHerobrineDragon != null && !this.healingHerobrineDragon.m_6084_()) {
/* 273 */         this.healingHerobrineDragon = null;
/* 274 */         this.healingHerobrineDragonUUID = null;
/*     */         
/* 276 */         if (m_9236_().m_7654_() != null) {
/* 277 */           ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_(
/* 278 */               (Component)Component.m_237113_("<" + getChatName() + ">  " + 
/* 279 */                 Component.m_237115_("subtitles.reaper_herobrine_return_dragon").getString()), false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 284 */         if (this.dragonSummonCooldown == 0) {
/* 285 */           if (getState() < 2) {
/* 286 */             this.dragonSummonCooldown = (new Random()).nextInt(4800, 7200);
/* 287 */           } else if (getState() == 2) {
/* 288 */             this.dragonSummonCooldown = (new Random()).nextInt(2400, 4800);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 293 */       if (this.f_19797_ % 20 == 0 && 
/* 294 */         getState() > 0) {
/* 295 */         HerobrineUtil.spawnEliteEffect(m_9236_(), m_20185_(), m_20186_(), m_20189_(), (Entity)this);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damagesource, float f) {
/* 302 */     if (damagesource.m_276093_(DamageTypes.f_268671_)) return false; 
/* 303 */     if (damagesource.m_276093_(DamageTypes.f_268585_)) return false; 
/* 304 */     if (damagesource.m_276093_(DamageTypes.f_268493_)) return false; 
/* 305 */     if (damagesource.m_276093_(DamageTypes.f_268722_)) return false; 
/* 306 */     if (damagesource.m_276093_(DamageTypes.f_268641_)) return false; 
/* 307 */     if (damagesource.m_276093_(DamageTypes.f_268482_)) return false; 
/* 308 */     if (!(damagesource.m_7640_() instanceof EnchantedArrowEntity) && damagesource
/* 309 */       .m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow && 
/* 310 */       !(damagesource.m_7640_() instanceof BlueDemonThrownTridentEntity)) return false; 
/* 311 */     return super.m_6469_(damagesource, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 316 */     if (this.thunderHerobrineDragon != null) {
/* 317 */       this.thunderHerobrineDragon.m_6074_();
/* 318 */       this.thunderHerobrineDragon = null;
/* 319 */       this.thunderHerobrineDragonUUID = null;
/*     */     } 
/* 321 */     if (this.meteoriteHerobrineDragon != null) {
/* 322 */       this.meteoriteHerobrineDragon.m_6074_();
/* 323 */       this.meteoriteHerobrineDragon = null;
/* 324 */       this.meteoriteHerobrineDragonUUID = null;
/*     */     } 
/* 326 */     if (this.healingHerobrineDragon != null) {
/* 327 */       this.healingHerobrineDragon.m_6074_();
/* 328 */       this.healingHerobrineDragon = null;
/* 329 */       this.healingHerobrineDragonUUID = null;
/*     */     } 
/* 331 */     super.m_142687_(reason);
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damageSource) {
/* 335 */     super.m_6667_(damageSource);
/* 336 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 337 */       EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = new EliteHerobrineKnockedEntity((EntityType<EliteHerobrineKnockedEntity>)AnnoyingVillagersModEntities.ELITE_HEROBRINE_KNOCKED.get(), (Level)serverLevel);
/*     */       
/* 339 */       eliteHerobrineKnockedEntity.m_7678_(m_20185_(), m_20186_(), m_20189_(), serverLevel.m_213780_().m_188501_() * 360.0F, 0.0F);
/* 340 */       eliteHerobrineKnockedEntity.getPersistentData().m_128359_("FromElite", "EnderSlayerScythe");
/* 341 */       eliteHerobrineKnockedEntity.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(eliteHerobrineKnockedEntity.m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/* 342 */       m_142687_(Entity.RemovalReason.KILLED);
/* 343 */       serverLevel.m_7967_((Entity)eliteHerobrineKnockedEntity);
/*     */       
/* 345 */       if (getGregUUID() != null) {
/* 346 */         Entity entity = serverLevel.m_8791_(getGregUUID());
/* 347 */         if (entity instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)entity; if (entity.m_6084_())
/* 348 */             herobrineGregEntity.requestProtect(eliteHerobrineKnockedEntity.m_20148_(), eliteHerobrineKnockedEntity);  }
/*     */       
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 355 */     return Mob.m_21552_()
/* 356 */       .m_22268_(Attributes.f_22276_, 250.0D)
/* 357 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 358 */       .m_22268_(Attributes.f_22281_, 10.0D)
/* 359 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 360 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 361 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 362 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 363 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 364 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 365 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 366 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 367 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 368 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ReaperHerobrineEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */