/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.CommonGoals;
/*     */ import com.pla.annoyingvillagers.util.RidingUtil;
/*     */ import com.pla.annoyingvillagers.util.VillagerUtil;
/*     */ import java.util.Random;
/*     */ import java.util.function.Consumer;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
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
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class BlueVillagerGeneralEntity extends AVNpc {
/*     */   public BlueVillagerGeneralEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  43 */     this((EntityType<BlueVillagerGeneralEntity>)AnnoyingVillagersModEntities.BLUE_VILLAGER_GENERAL.get(), level);
/*     */   }
/*     */   
/*     */   public BlueVillagerGeneralEntity(EntityType<BlueVillagerGeneralEntity> entitytype, Level level) {
/*  47 */     super(entitytype, level);
/*  48 */     m_274367_(2.0F);
/*  49 */     this.f_21364_ = 10;
/*  50 */     m_21557_(false);
/*  51 */     setPlaceBlockToParryChance(0.7D);
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
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  64 */     return MobType.f_21641_;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/*  68 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7515_() {
/*  72 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.ambient"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/*  76 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/*  80 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.death"));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  85 */     return (SoundEvent)AnnoyingVillagersModSounds.VILLAGER_GENERALS_SAY.get();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void beforeEnderPearlCounter(@NotNull DamageSource damageSource) {
/*  95 */     restoreOffhandLater(150);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 100 */     doVillagerGeneralStyleEnderPearlCounter();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBurstProtectCapRatio() {
/* 105 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/* 110 */     super.m_7472_(source, looting, recentlyHit);
/* 111 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 112 */       double x = m_20185_();
/* 113 */       double y = m_20186_() + 1.0D;
/* 114 */       double z = m_20189_();
/*     */       
/* 116 */       Consumer<ItemStack> dropStack = stack -> {
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
/* 158 */       ItemStack[] drops = { new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42410_), new ItemStack((ItemLike)Items.f_42523_), new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Blocks.f_50705_), new ItemStack((ItemLike)Blocks.f_50705_), new ItemStack((ItemLike)Items.f_42385_), new ItemStack((ItemLike)Items.f_42388_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42415_) };
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
/* 170 */       for (ItemStack stack : drops) {
/* 171 */         dropStack.accept(stack);
/*     */       } }
/*     */   
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 177 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/*     */     
/* 179 */     TeamUtil.addOrJoinTeam((Entity)this, "villagers");
/*     */     
/* 181 */     m_8061_(EquipmentSlot.MAINHAND, VillagerUtil.generateMainWeaponItem());
/* 182 */     m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)Items.f_42584_));
/* 183 */     m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_VILLAGER_GENERAL_HELMET_FIX.get()));
/* 184 */     m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)AnnoyingVillagersModItems.BLUE_VILLAGER_GENERAL_CHESTPLATE.get()));
/* 185 */     m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)AnnoyingVillagersModItems.VILLAGER_GENERAL_LEGGINGS.get()));
/* 186 */     m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)AnnoyingVillagersModItems.VILLAGER_GENERAL_BOOTS.get()));
/* 187 */     setMainWeaponItem(m_21205_().m_41777_());
/* 188 */     setOffWeaponItem(getOffWeaponItem().m_41777_());
/*     */     
/* 190 */     if ((new Random()).nextBoolean()) {
/* 191 */       setUseBow(false);
/*     */     }
/*     */     
/* 194 */     return returnSpawnGroupData;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void implementFirstTick(ServerLevel serverLevel) {
/* 199 */     super.implementFirstTick(serverLevel);
/* 200 */     if ((new Random()).nextDouble() <= 0.3D) {
/* 201 */       RidingUtil.rideRandomAnimal(serverLevel, (Entity)this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<BlueVillagerGeneralEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 206 */     return PathfinderMob.m_217057_(entityType, (LevelAccessor)level, spawnType, position, random);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 210 */     return Mob.m_21552_()
/* 211 */       .m_22268_(Attributes.f_22276_, 30.0D)
/* 212 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 213 */       .m_22268_(Attributes.f_22281_, 0.0D)
/* 214 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 215 */       .m_22268_(Attributes.f_22284_, 30.0D)
/* 216 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 217 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 218 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 2.0D)
/* 219 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 5.0D)
/* 220 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 221 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 50.0D)
/* 222 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 30.0D)
/* 223 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\BlueVillagerGeneralEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */