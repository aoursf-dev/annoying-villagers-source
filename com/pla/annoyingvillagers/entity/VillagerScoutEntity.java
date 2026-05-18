/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.CommonGoals;
/*     */ import com.pla.annoyingvillagers.util.RidingUtil;
/*     */ import com.pla.annoyingvillagers.util.VillagerUtil;
/*     */ import java.util.Random;
/*     */ import java.util.function.Consumer;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Position;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class VillagerScoutEntity extends AVNpc {
/*     */   public VillagerScoutEntity(PlayMessages.SpawnEntity spawnentity, Level level) {
/*  42 */     this((EntityType<VillagerScoutEntity>)AnnoyingVillagersModEntities.VILLAGER_SCOUT.get(), level);
/*     */   }
/*     */   
/*     */   public VillagerScoutEntity(EntityType<VillagerScoutEntity> entitytype, Level level) {
/*  46 */     super(entitytype, level);
/*  47 */     m_274367_(2.0F);
/*  48 */     this.f_21364_ = 8;
/*  49 */     m_21557_(false);
/*  50 */     m_21530_();
/*  51 */     setPlaceBlockToParryChance(0.4D);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  55 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  59 */     super.m_8099_();
/*  60 */     CommonGoals.registerGoalForVillagerKnightNpc((PathfinderMob)this);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  65 */     return (SoundEvent)AnnoyingVillagersModSounds.VILLAGER_SCOUTS_SAY.get();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  69 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/*  73 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7515_() {
/*  77 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.ambient"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damagesource) {
/*  81 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/*  85 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.death"));
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void beforeEnderPearlCounter(@NotNull DamageSource damageSource) {
/*  99 */     swapOffhandDuringEnderPearlCounter(new ItemStack((ItemLike)Items.f_42383_), 120);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ItemStack getEnderPearlCounterRestoreOffhandItem() {
/* 104 */     return new ItemStack((ItemLike)Items.f_42584_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 109 */     doSteveStyleEnderPearlCounter();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBurstProtectCapRatio() {
/* 114 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource pDamageSource) {
/*     */     final ServerLevel serverLevel;
/* 119 */     super.m_6667_(pDamageSource);
/*     */     
/* 121 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else
/*     */     { return; }
/*     */     
/* 125 */     if (this.f_19796_.m_188500_() > 0.11D) {
/*     */       return;
/*     */     }
/*     */     
/* 129 */     final Vec3 deathPos = m_20182_();
/* 130 */     final float deathYaw = m_146908_();
/*     */     
/* 132 */     VillagerUtil.spawnBackupFirework(serverLevel, deathPos);
/*     */     
/* 134 */     new DelayedTask(400)
/*     */       {
/*     */         public void run() {
/* 137 */           BlockPos center = BlockPos.m_274446_((Position)deathPos);
/* 138 */           if (!serverLevel.m_46749_(center)) {
/*     */             return;
/*     */           }
/*     */           
/* 142 */           VillagerUtil.summonRandomVillagerSupportWave(serverLevel, deathPos, deathYaw);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/* 149 */     super.m_7472_(source, looting, recentlyHit);
/* 150 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 151 */       double x = m_20185_();
/* 152 */       double y = m_20186_() + 1.0D;
/* 153 */       double z = m_20189_();
/*     */       
/* 155 */       Consumer<ItemStack> dropStack = stack -> {
/*     */           ItemEntity drop = new ItemEntity((Level)serverLevel, x, y, z, stack);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           drop.m_32010_(10);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           serverLevel.m_7967_((Entity)drop);
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       ItemStack[] drops = { new ItemStack((ItemLike)Items.f_42410_), new ItemStack((ItemLike)Items.f_42410_), new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42383_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Blocks.f_50705_) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 193 */       for (ItemStack stack : drops) {
/* 194 */         dropStack.accept(stack);
/*     */       }
/*     */       
/* 197 */       if ((new Random()).nextDouble() <= 0.2D) {
/* 198 */         dropStack.accept(VillagerUtil.createBlackCreeperSignalFirework());
/*     */       } }
/*     */   
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 204 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/*     */     
/* 206 */     TeamUtil.addOrJoinTeam((Entity)this, "villagers");
/*     */     
/* 208 */     if ((new Random()).nextBoolean()) {
/* 209 */       m_21008_(InteractionHand.MAIN_HAND, getBowItem());
/*     */     } else {
/* 211 */       m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42383_));
/* 212 */       if ((new Random()).nextBoolean()) {
/* 213 */         m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)Items.f_42383_));
/*     */       } else {
/* 215 */         m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)Items.f_42584_));
/*     */       } 
/* 217 */       if ((new Random()).nextBoolean()) {
/* 218 */         setUseBow(false);
/*     */       }
/*     */     } 
/*     */     
/* 222 */     m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)AnnoyingVillagersModItems.VILLAGER_SCOUT_HELMET_FIX.get()));
/* 223 */     m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)AnnoyingVillagersModItems.CLASSICGOLDENA_CHESTPLATE.get()));
/* 224 */     m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)AnnoyingVillagersModItems.CLASSICGOLDENA_LEGGINGS.get()));
/* 225 */     m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)AnnoyingVillagersModItems.CLASSICGOLDENA_BOOTS.get()));
/* 226 */     setMainWeaponItem(m_21205_().m_41777_());
/* 227 */     setOffWeaponItem(getOffWeaponItem().m_41777_());
/*     */     
/* 229 */     return returnSpawnGroupData;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void implementFirstTick(ServerLevel serverLevel) {
/* 234 */     super.implementFirstTick(serverLevel);
/* 235 */     if ((new Random()).nextDouble() <= 0.3D) {
/* 236 */       RidingUtil.rideRandomAnimal(serverLevel, (Entity)this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<VillagerScoutEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 241 */     return PathfinderMob.m_217057_(entityType, (LevelAccessor)level, spawnType, position, random);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 245 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 247 */     builder = builder.m_22268_(Attributes.f_22279_, 0.45D);
/* 248 */     builder = builder.m_22268_(Attributes.f_22276_, 20.0D);
/* 249 */     builder = builder.m_22268_(Attributes.f_22284_, 5.0D);
/* 250 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 251 */     builder = builder.m_22268_(Attributes.f_22277_, 48.0D);
/* 252 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\VillagerScoutEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */