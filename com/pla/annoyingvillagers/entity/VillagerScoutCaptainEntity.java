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
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class VillagerScoutCaptainEntity extends AVNpc {
/*     */   public VillagerScoutCaptainEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  43 */     this((EntityType<VillagerScoutCaptainEntity>)AnnoyingVillagersModEntities.VILLAGER_SCOUT_CAPTAIN.get(), level);
/*     */   }
/*     */   
/*     */   public VillagerScoutCaptainEntity(EntityType<VillagerScoutCaptainEntity> entitytype, Level level) {
/*  47 */     super(entitytype, level);
/*  48 */     m_274367_(2.5F);
/*  49 */     this.f_21364_ = 0;
/*  50 */     m_21557_(false);
/*  51 */     m_6593_(m_5446_());
/*  52 */     m_20340_(true);
/*  53 */     m_21530_();
/*  54 */     setPlaceBlockToParryChance(0.5D);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  58 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  62 */     super.m_8099_();
/*  63 */     CommonGoals.registerGoalForVillagerKnightNpc((PathfinderMob)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBurstProtectCapRatio() {
/*  68 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  73 */     return (SoundEvent)AnnoyingVillagersModSounds.VILLAGER_SCOUTS_SAY.get();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  77 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/*  85 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7515_() {
/*  89 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.ambient"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/*  93 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/*  97 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.death"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void beforeEnderPearlCounter(@NotNull DamageSource damageSource) {
/* 107 */     swapOffhandDuringEnderPearlCounter(new ItemStack((ItemLike)Items.f_42388_), 120);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ItemStack getEnderPearlCounterRestoreOffhandItem() {
/* 112 */     return new ItemStack((ItemLike)Items.f_42584_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 117 */     doSteveStyleEnderPearlCounter();
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 121 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/*     */     
/* 123 */     TeamUtil.addOrJoinTeam((Entity)this, "villagers");
/*     */     
/* 125 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42388_));
/* 126 */     if ((new Random()).nextBoolean()) {
/* 127 */       m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)Items.f_42584_));
/*     */     }
/*     */     
/* 130 */     m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)AnnoyingVillagersModItems.VILLAGER_SCOUT_HELMET_FIX.get()));
/* 131 */     m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)Items.f_42473_));
/* 132 */     m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)Items.f_42474_));
/* 133 */     m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)Items.f_42475_));
/* 134 */     setMainWeaponItem(m_21205_().m_41777_());
/* 135 */     setOffWeaponItem(getOffWeaponItem().m_41777_());
/*     */     
/* 137 */     if ((new Random()).nextBoolean()) {
/* 138 */       setUseBow(false);
/*     */     }
/*     */     
/* 141 */     return returnSpawnGroupData;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void implementFirstTick(ServerLevel serverLevel) {
/* 146 */     super.implementFirstTick(serverLevel);
/*     */     
/* 148 */     if ((new Random()).nextDouble() <= 0.3D) {
/* 149 */       RidingUtil.rideRandomAnimal(serverLevel, (Entity)this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource pDamageSource) {
/*     */     final ServerLevel serverLevel;
/* 155 */     super.m_6667_(pDamageSource);
/*     */     
/* 157 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else
/*     */     { return; }
/*     */     
/* 161 */     if (this.f_19796_.m_188500_() > 0.11D) {
/*     */       return;
/*     */     }
/*     */     
/* 165 */     final Vec3 deathPos = m_20182_();
/* 166 */     final float deathYaw = m_146908_();
/*     */     
/* 168 */     VillagerUtil.spawnBackupFirework(serverLevel, deathPos);
/*     */     
/* 170 */     new DelayedTask(400)
/*     */       {
/*     */         public void run() {
/* 173 */           BlockPos center = BlockPos.m_274446_((Position)deathPos);
/* 174 */           if (!serverLevel.m_46749_(center)) {
/*     */             return;
/*     */           }
/*     */           
/* 178 */           VillagerUtil.summonRandomVillagerSupportWave(serverLevel, deathPos, deathYaw);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/* 185 */     super.m_7472_(source, looting, recentlyHit);
/* 186 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 187 */       double x = m_20185_();
/* 188 */       double y = m_20186_() + 1.0D;
/* 189 */       double z = m_20189_();
/*     */       
/* 191 */       Consumer<ItemStack> dropStack = stack -> {
/*     */           ItemEntity drop = new ItemEntity((Level)serverLevel, x, y, z, stack);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 252 */       ItemStack[] drops = { new ItemStack((ItemLike)Blocks.f_50705_), new ItemStack((ItemLike)Blocks.f_50493_), new ItemStack((ItemLike)Blocks.f_50493_), new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Blocks.f_50092_), new ItemStack((ItemLike)Blocks.f_50092_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42385_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42410_), new ItemStack((ItemLike)Items.f_42410_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)Items.f_42410_), new ItemStack((ItemLike)Items.f_42410_) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 258 */       for (ItemStack stack : drops) {
/* 259 */         dropStack.accept(stack);
/*     */       }
/*     */       
/* 262 */       dropStack.accept(VillagerUtil.createBlackCreeperSignalFirework()); }
/*     */   
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<VillagerScoutCaptainEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 267 */     return PathfinderMob.m_217057_(entityType, (LevelAccessor)level, spawnType, position, random);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 271 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 273 */     builder = builder.m_22268_(Attributes.f_22279_, 0.45D);
/* 274 */     builder = builder.m_22268_(Attributes.f_22276_, 20.0D);
/* 275 */     builder = builder.m_22268_(Attributes.f_22284_, 6.0D);
/* 276 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 277 */     builder = builder.m_22268_(Attributes.f_22277_, 48.0D);
/* 278 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\VillagerScoutCaptainEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */