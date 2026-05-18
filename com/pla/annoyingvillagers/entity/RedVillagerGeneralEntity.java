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
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
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
/*     */ public class RedVillagerGeneralEntity extends AVNpc {
/*     */   public RedVillagerGeneralEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  44 */     this((EntityType<RedVillagerGeneralEntity>)AnnoyingVillagersModEntities.RED_VILLAGER_GENERAL.get(), level);
/*     */   }
/*     */   
/*     */   public RedVillagerGeneralEntity(EntityType<RedVillagerGeneralEntity> entitytype, Level level) {
/*  48 */     super(entitytype, level);
/*  49 */     m_274367_(3.0F);
/*  50 */     this.f_21364_ = 8;
/*  51 */     m_21557_(false);
/*  52 */     setPlaceBlockToParryChance(0.7D);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  56 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  60 */     super.m_8099_();
/*  61 */     CommonGoals.registerGoalForVillagerKnightNpc((PathfinderMob)this);
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  65 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/*  69 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7515_() {
/*  73 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.ambient"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/*  77 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/*  81 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.death"));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  86 */     return (SoundEvent)AnnoyingVillagersModSounds.VILLAGER_GENERALS_SAY.get();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void beforeEnderPearlCounter(@NotNull DamageSource damageSource) {
/*  96 */     restoreOffhandLater(150);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ItemStack getEnderPearlCounterRestoreOffhandItem() {
/* 101 */     return new ItemStack((ItemLike)Items.f_42584_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 106 */     doVillagerGeneralStyleEnderPearlCounter();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBurstProtectCapRatio() {
/* 111 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/* 116 */     super.m_7472_(source, looting, recentlyHit);
/* 117 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 118 */       double x = m_20185_();
/* 119 */       double y = m_20186_() + 1.0D;
/* 120 */       double z = m_20189_();
/*     */       
/* 122 */       Consumer<ItemStack> dropStack = stack -> {
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
/* 175 */       ItemStack[] drops = { new ItemStack((ItemLike)AnnoyingVillagersModItems.HOOKED_DIAMOND_SWORD.get()), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42405_), new ItemStack((ItemLike)Items.f_42405_), new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get()), new ItemStack((ItemLike)Blocks.f_50705_), new ItemStack((ItemLike)Blocks.f_50705_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)Items.f_42412_), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get()), new ItemStack((ItemLike)Items.f_42385_), new ItemStack((ItemLike)Items.f_42410_), new ItemStack((ItemLike)Items.f_42410_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42398_), new ItemStack((ItemLike)Items.f_42398_), new ItemStack((ItemLike)Items.f_42688_), new ItemStack((ItemLike)Items.f_42688_), new ItemStack((ItemLike)Items.f_42675_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42616_) };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 200 */       for (ItemStack stack : drops) {
/* 201 */         dropStack.accept(stack);
/*     */       } }
/*     */   
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 207 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/*     */     
/* 209 */     TeamUtil.addOrJoinTeam((Entity)this, "villagers");
/*     */     
/* 211 */     m_8061_(EquipmentSlot.MAINHAND, VillagerUtil.generateMainWeaponItem());
/* 212 */     if (m_21205_().m_41720_() instanceof com.pla.annoyingvillagers.item.WoopieTheSwordItem || 
/* 213 */       m_21205_().m_41720_() instanceof com.pla.annoyingvillagers.item.HookedDiamondSwordItem) {
/* 214 */       m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.HEATER_SHIELD.get()));
/*     */     } else {
/* 216 */       m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)Items.f_42584_));
/*     */     } 
/* 218 */     m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)AnnoyingVillagersModItems.RED_VILLAGER_GENERAL_HELMET_FIX.get()));
/* 219 */     m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)AnnoyingVillagersModItems.RED_VILLAGER_GENERAL_CHESTPLATE.get()));
/* 220 */     m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)AnnoyingVillagersModItems.VILLAGER_GENERAL_LEGGINGS.get()));
/* 221 */     m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)AnnoyingVillagersModItems.VILLAGER_GENERAL_BOOTS.get()));
/* 222 */     setMainWeaponItem(m_21205_().m_41777_());
/* 223 */     setOffWeaponItem(getOffWeaponItem().m_41777_());
/*     */     
/* 225 */     if ((new Random()).nextBoolean()) {
/* 226 */       setUseBow(false);
/*     */     }
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
/*     */   public static boolean canSpawn(EntityType<RedVillagerGeneralEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 241 */     return PathfinderMob.m_217057_(entityType, (LevelAccessor)level, spawnType, position, random);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 245 */     return Mob.m_21552_()
/* 246 */       .m_22268_(Attributes.f_22276_, 30.0D)
/* 247 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 248 */       .m_22268_(Attributes.f_22281_, 0.0D)
/* 249 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 250 */       .m_22268_(Attributes.f_22284_, 30.0D)
/* 251 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 252 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 253 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 2.0D)
/* 254 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 5.0D)
/* 255 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 256 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 50.0D)
/* 257 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 30.0D)
/* 258 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\RedVillagerGeneralEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */