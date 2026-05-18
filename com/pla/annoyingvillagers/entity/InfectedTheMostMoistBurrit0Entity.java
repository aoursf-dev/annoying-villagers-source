/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
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
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class InfectedTheMostMoistBurrit0Entity extends PathfinderMob {
/*  35 */   final LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class); private boolean initialSpawn = false;
/*     */   
/*     */   public InfectedTheMostMoistBurrit0Entity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  38 */     this((EntityType<InfectedTheMostMoistBurrit0Entity>)AnnoyingVillagersModEntities.INFECTED_THEMOSTMOISTBURRIT0.get(), level);
/*     */   }
/*     */   
/*     */   public InfectedTheMostMoistBurrit0Entity(EntityType<InfectedTheMostMoistBurrit0Entity> entitytype, Level level) {
/*  42 */     super(entitytype, level);
/*  43 */     m_274367_(0.6F);
/*  44 */     this.f_21364_ = 0;
/*  45 */     m_21557_(true);
/*  46 */     m_6593_(m_5446_());
/*  47 */     m_20340_(true);
/*  48 */     m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_HELMET.get()));
/*  49 */     m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_CHESTPLATE.get()));
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  53 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  57 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/*  61 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/*  65 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/*  69 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  74 */     super.m_8119_();
/*  75 */     if (!(m_9236_() instanceof net.minecraft.server.level.ServerLevel))
/*  76 */       return;  if (this.f_19797_ == 1 && !this.initialSpawn) {
/*  77 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.INFECTED_THE_MOSTMOISTBURRIT0_SAY_ON_SPAWN.get(), 1.0F, 1.0F);
/*  78 */       this.initialSpawn = true;
/*     */     } 
/*  80 */     if (this.livingEntityPatch != null) {
/*  81 */       m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.HEROBRINE.get(), 2, 0, false, false));
/*  82 */       m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 2, 0, false, false));
/*  83 */       m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 2, 0, false, false));
/*  84 */       this.livingEntityPatch.playAnimationSynchronized((AssetAccessor)EFDancingAnimations.DEATH_EMOTE, 0.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/*  90 */     super.m_7472_(source, looting, recentlyHit);
/*  91 */     HerobrineUtil.dropArmoredHerobrineLoot((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_());
/*  92 */     m_146870_();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/*  97 */     super.m_7380_(tag);
/*  98 */     tag.m_128379_("InitialSpawn", this.initialSpawn);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 103 */     super.m_7378_(tag);
/* 104 */     this.initialSpawn = tag.m_128471_("InitialSpawn");
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 108 */     if (!m_9236_().m_5776_()) {
/* 109 */       TeamUtil.addOrJoinTeam((Entity)this, "herobrine");
/*     */     }
/* 111 */     return super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 115 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 117 */     builder = builder.m_22268_(Attributes.f_22279_, 0.26D);
/* 118 */     builder = builder.m_22268_(Attributes.f_22276_, 10.0D);
/* 119 */     builder = builder.m_22268_(Attributes.f_22284_, 0.0D);
/* 120 */     builder = builder.m_22268_(Attributes.f_22281_, 1.0D);
/* 121 */     builder = builder.m_22268_(Attributes.f_22277_, 32.0D);
/* 122 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\InfectedTheMostMoistBurrit0Entity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */