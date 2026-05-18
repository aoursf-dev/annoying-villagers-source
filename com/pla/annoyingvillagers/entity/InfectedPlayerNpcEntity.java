/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import com.pla.annoyingvillagers.util.TeamUtil;
/*     */ import java.util.Objects;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*     */ 
/*     */ public class InfectedPlayerNpcEntity extends PlayerMobEntity {
/*  38 */   final LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*     */   
/*     */   public InfectedPlayerNpcEntity(EntityType<? extends InfectedPlayerNpcEntity> type, Level level) {
/*  41 */     super(type, level);
/*  42 */     this.f_21364_ = 300;
/*  43 */     m_274367_(0.6F);
/*  44 */     this.f_21364_ = 7;
/*  45 */     m_21557_(true);
/*  46 */     m_20340_(true);
/*     */   }
/*     */   
/*     */   public InfectedPlayerNpcEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  50 */     this((EntityType<? extends InfectedPlayerNpcEntity>)AnnoyingVillagersModEntities.INFECTED_PLAYER_NPC.get(), level);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  54 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  58 */     this.f_21345_.m_148105_().clear();
/*  59 */     this.f_21346_.m_148105_().clear();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  63 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/*  67 */     return -0.35D;
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/*  71 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt")));
/*     */   }
/*     */   @NotNull
/*     */   public SoundEvent m_5592_() {
/*  75 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death")));
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  80 */     super.m_8119_();
/*  81 */     if (!m_9236_().m_5776_() && this.livingEntityPatch != null) {
/*  82 */       m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.HEROBRINE.get(), 2, 0, false, false));
/*  83 */       m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 2, 0, false, false));
/*  84 */       m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 2, 0, false, false));
/*  85 */       this.livingEntityPatch.playAnimationSynchronized((AssetAccessor)EFDancingAnimations.DEATH_EMOTE, 0.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/*  91 */     super.m_7472_(source, looting, recentlyHit);
/*  92 */     String possessedBy = getPersistentData().m_128461_("possessed_by");
/*  93 */     switch (possessedBy) { case "herobrine_clone":
/*  94 */         HerobrineUtil.dropHerobrineCloneLoot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_()); break;
/*  95 */       case "shadow_herobrine_clone": HerobrineUtil.dropShadowHerobrineCloneLoot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_()); break;
/*  96 */       case "low_herobrine_clone": case "low_shadow_herobrine_clone": HerobrineUtil.dropLowHerobrineCloneLoot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_()); break;
/*  97 */       case "herobrine_7": HerobrineUtil.dropHerobrine7Loot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_()); break;
/*  98 */       case "shadow_herobrine": HerobrineUtil.dropShadowHerobrineLoot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_()); break;
/*  99 */       case "null": HerobrineUtil.dropNullLoot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_()); break; }
/*     */     
/* 101 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*     */ 
/*     */ 
/*     */       
/* 105 */       ItemStack itemstack = m_6844_(EquipmentSlot.FEET);
/* 106 */       ItemEntity itementity = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_() + 1.0D, m_20189_(), itemstack);
/* 107 */       itementity.m_32010_(10);
/* 108 */       serverLevel.m_7967_((Entity)itementity);
/*     */       
/* 110 */       itemstack = m_6844_(EquipmentSlot.FEET);
/* 111 */       itementity = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_() + 1.0D, m_20189_(), itemstack);
/* 112 */       itementity.m_32010_(10);
/* 113 */       serverLevel.m_7967_((Entity)itementity);
/*     */       
/* 115 */       itemstack = m_6844_(EquipmentSlot.CHEST);
/* 116 */       itementity = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_() + 1.0D, m_20189_(), itemstack);
/* 117 */       itementity.m_32010_(10);
/* 118 */       serverLevel.m_7967_((Entity)itementity);
/*     */       
/* 120 */       itemstack = m_6844_(EquipmentSlot.HEAD);
/* 121 */       itementity = new ItemEntity((Level)serverLevel, m_20185_(), m_20186_() + 1.0D, m_20189_(), itemstack);
/* 122 */       itementity.m_32010_(10);
/* 123 */       serverLevel.m_7967_((Entity)itementity); }
/*     */     
/* 125 */     m_146870_();
/*     */   }
/*     */ 
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 130 */     if (!m_9236_().m_5776_()) {
/* 131 */       TeamUtil.addOrJoinTeam((Entity)this, "herobrine");
/*     */     }
/* 133 */     return super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/*     */   }
/*     */   
/*     */   public boolean m_6094_() {
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   protected void m_7324_(@NotNull Entity entity) {}
/*     */   
/*     */   protected void m_6138_() {}
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 145 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 147 */     builder = builder.m_22268_(Attributes.f_22279_, 0.26D);
/* 148 */     builder = builder.m_22268_(Attributes.f_22276_, 10.0D);
/* 149 */     builder = builder.m_22268_(Attributes.f_22284_, 0.0D);
/* 150 */     builder = builder.m_22268_(Attributes.f_22281_, 1.0D);
/* 151 */     builder = builder.m_22268_(Attributes.f_22277_, 32.0D);
/* 152 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\InfectedPlayerNpcEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */