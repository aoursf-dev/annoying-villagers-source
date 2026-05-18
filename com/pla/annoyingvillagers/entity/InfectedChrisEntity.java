/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModMobEffects;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class InfectedChrisEntity extends PathfinderMob {
/*  32 */   final LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*     */   
/*     */   public InfectedChrisEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  35 */     this((EntityType<InfectedChrisEntity>)AnnoyingVillagersModEntities.INJECTED_CHRIS.get(), level);
/*     */   }
/*     */   
/*     */   public InfectedChrisEntity(EntityType<InfectedChrisEntity> entitytype, Level level) {
/*  39 */     super(entitytype, level);
/*  40 */     m_274367_(0.6F);
/*  41 */     this.f_21364_ = 7;
/*  42 */     m_21557_(true);
/*  43 */     m_6593_(m_5446_());
/*  44 */     m_20340_(true);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  48 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  52 */     super.m_8099_();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  56 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/*  60 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/*  64 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/*  68 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/*  73 */     super.m_7472_(source, looting, recentlyHit);
/*  74 */     HerobrineUtil.dropHerobrineChrisLoot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_());
/*  75 */     m_146870_();
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/*  79 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawngroupdata, compoundtag);
/*     */     
/*  81 */     if (!m_9236_().m_5776_()) {
/*  82 */       m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.HEROBRINE.get(), 3000, 1));
/*     */     }
/*  84 */     return returnSpawnGroupData;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  89 */     super.m_8119_();
/*  90 */     if (!m_9236_().m_5776_() && this.livingEntityPatch != null) {
/*  91 */       m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.HEROBRINE.get(), 2, 0, false, false));
/*  92 */       m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 2, 0, false, false));
/*  93 */       m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 2, 0, false, false));
/*  94 */       this.livingEntityPatch.playAnimationSynchronized((AssetAccessor)EFDancingAnimations.DEATH_EMOTE, 0.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean m_6094_() {
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   protected void m_7324_(@NotNull Entity entity) {}
/*     */   
/*     */   protected void m_6138_() {}
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 107 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 109 */     builder = builder.m_22268_(Attributes.f_22279_, 0.26D);
/* 110 */     builder = builder.m_22268_(Attributes.f_22276_, 10.0D);
/* 111 */     builder = builder.m_22268_(Attributes.f_22284_, 0.0D);
/* 112 */     builder = builder.m_22268_(Attributes.f_22281_, 1.0D);
/* 113 */     builder = builder.m_22268_(Attributes.f_22277_, 32.0D);
/* 114 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\InfectedChrisEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */