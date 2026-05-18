/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.spawnhandler.SteveData;
/*     */ import com.pla.annoyingvillagers.util.CommonGoals;
/*     */ import com.pla.annoyingvillagers.util.EquipmentDataLoader;
/*     */ import com.pla.annoyingvillagers.util.TeamUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.function.Consumer;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
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
/*     */ public class SteveEntity extends AVNpc {
/*  50 */   private int state = 0;
/*     */   private int swapWeaponCooldown;
/*     */   private boolean sayLegendary = false;
/*     */   
/*     */   public int getState() {
/*  55 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(int state) {
/*  59 */     this.state = state;
/*     */   }
/*     */   
/*     */   public SteveEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  63 */     this((EntityType<SteveEntity>)AnnoyingVillagersModEntities.STEVE.get(), level);
/*     */   }
/*     */   
/*     */   public SteveEntity(EntityType<SteveEntity> entitytype, Level level) {
/*  67 */     super(entitytype, level);
/*  68 */     m_274367_(3.0F);
/*  69 */     this.f_21364_ = 8;
/*  70 */     m_21557_(false);
/*  71 */     m_6593_(m_5446_());
/*  72 */     m_20340_(true);
/*  73 */     m_21530_();
/*  74 */     setPlaceBlockToParryChance(0.8D);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  78 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  82 */     super.m_8099_();
/*  83 */     CommonGoals.registerGoalForNeutralNpc((PathfinderMob)this);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  88 */     return (SoundEvent)AnnoyingVillagersModSounds.STEVE_SAY.get();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  92 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 100 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public int getSwapWeaponCooldown() {
/* 104 */     return this.swapWeaponCooldown;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 108 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/* 112 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 122 */     doSteveStyleEnderPearlCounter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean afterBurstProtection(@NotNull ServerLevel serverLevel, @NotNull DamageSource source, float finalDamage) {
/* 129 */     if (this.state == 0 && 
/* 130 */       m_21223_() - finalDamage <= 1.0F && 
/* 131 */       !m_21206_().m_150930_(Items.f_42747_)) {
/* 132 */       m_21153_(1.0F);
/* 133 */       return true;
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBurstProtectCapRatio() {
/* 140 */     return 0.25F;
/*     */   }
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
/*     */   public void m_6667_(@NotNull DamageSource pDamageSource) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   4: astore_3
/*     */     //   5: aload_3
/*     */     //   6: instanceof net/minecraft/server/level/ServerLevel
/*     */     //   9: ifeq -> 265
/*     */     //   12: aload_3
/*     */     //   13: checkcast net/minecraft/server/level/ServerLevel
/*     */     //   16: astore_2
/*     */     //   17: new java/util/Random
/*     */     //   20: dup
/*     */     //   21: invokespecial <init> : ()V
/*     */     //   24: invokevirtual nextFloat : ()F
/*     */     //   27: f2d
/*     */     //   28: getstatic com/pla/annoyingvillagers/config/AnnoyingVillagersConfig.ANGRY_STEVE_CHANCE : Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
/*     */     //   31: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   34: checkcast java/lang/Double
/*     */     //   37: invokevirtual doubleValue : ()D
/*     */     //   40: dcmpg
/*     */     //   41: ifgt -> 250
/*     */     //   44: aconst_null
/*     */     //   45: astore_3
/*     */     //   46: aload_1
/*     */     //   47: invokevirtual m_7639_ : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   50: astore #5
/*     */     //   52: aload #5
/*     */     //   54: instanceof net/minecraft/world/entity/LivingEntity
/*     */     //   57: ifeq -> 81
/*     */     //   60: aload #5
/*     */     //   62: checkcast net/minecraft/world/entity/LivingEntity
/*     */     //   65: astore #4
/*     */     //   67: aload #4
/*     */     //   69: invokevirtual m_6084_ : ()Z
/*     */     //   72: ifeq -> 81
/*     */     //   75: aload #4
/*     */     //   77: astore_3
/*     */     //   78: goto -> 128
/*     */     //   81: aload_0
/*     */     //   82: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   85: ifnull -> 106
/*     */     //   88: aload_0
/*     */     //   89: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   92: invokevirtual m_6084_ : ()Z
/*     */     //   95: ifeq -> 106
/*     */     //   98: aload_0
/*     */     //   99: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   102: astore_3
/*     */     //   103: goto -> 128
/*     */     //   106: aload_0
/*     */     //   107: invokevirtual m_21188_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   110: ifnull -> 128
/*     */     //   113: aload_0
/*     */     //   114: invokevirtual m_21188_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   117: invokevirtual m_6084_ : ()Z
/*     */     //   120: ifeq -> 128
/*     */     //   123: aload_0
/*     */     //   124: invokevirtual m_21188_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   127: astore_3
/*     */     //   128: new com/pla/annoyingvillagers/entity/AngrySteveEntity
/*     */     //   131: dup
/*     */     //   132: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModEntities.ANGRY_STEVE : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   135: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   138: checkcast net/minecraft/world/entity/EntityType
/*     */     //   141: aload_2
/*     */     //   142: invokespecial <init> : (Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V
/*     */     //   145: astore #4
/*     */     //   147: aload #4
/*     */     //   149: aload_0
/*     */     //   150: invokevirtual m_20183_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   153: aload_0
/*     */     //   154: invokevirtual m_146908_ : ()F
/*     */     //   157: aload_0
/*     */     //   158: invokevirtual m_146909_ : ()F
/*     */     //   161: invokevirtual m_20035_ : (Lnet/minecraft/core/BlockPos;FF)V
/*     */     //   164: aload_0
/*     */     //   165: invokevirtual getInventory : ()Lnet/minecraft/world/SimpleContainer;
/*     */     //   168: aload #4
/*     */     //   170: invokevirtual getInventory : ()Lnet/minecraft/world/SimpleContainer;
/*     */     //   173: invokestatic transferInventory : (Lnet/minecraft/world/SimpleContainer;Lnet/minecraft/world/SimpleContainer;)V
/*     */     //   176: aload_0
/*     */     //   177: invokevirtual m_146870_ : ()V
/*     */     //   180: aload_2
/*     */     //   181: invokestatic get : (Lnet/minecraft/server/level/ServerLevel;)Lcom/pla/annoyingvillagers/spawnhandler/SteveData;
/*     */     //   184: astore #5
/*     */     //   186: aload #5
/*     */     //   188: aload_2
/*     */     //   189: aload #4
/*     */     //   191: invokevirtual m_20148_ : ()Ljava/util/UUID;
/*     */     //   194: invokevirtual forceClaim : (Lnet/minecraft/server/level/ServerLevel;Ljava/util/UUID;)V
/*     */     //   197: aload #4
/*     */     //   199: aload_2
/*     */     //   200: aload_2
/*     */     //   201: aload #4
/*     */     //   203: invokevirtual m_20183_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   206: invokevirtual m_6436_ : (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
/*     */     //   209: getstatic net/minecraft/world/entity/MobSpawnType.MOB_SUMMONED : Lnet/minecraft/world/entity/MobSpawnType;
/*     */     //   212: aconst_null
/*     */     //   213: checkcast net/minecraft/world/entity/SpawnGroupData
/*     */     //   216: aconst_null
/*     */     //   217: checkcast net/minecraft/nbt/CompoundTag
/*     */     //   220: invokevirtual m_6518_ : (Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/world/entity/SpawnGroupData;Lnet/minecraft/nbt/CompoundTag;)Lnet/minecraft/world/entity/SpawnGroupData;
/*     */     //   223: pop
/*     */     //   224: aload_2
/*     */     //   225: aload #4
/*     */     //   227: invokevirtual m_7967_ : (Lnet/minecraft/world/entity/Entity;)Z
/*     */     //   230: pop
/*     */     //   231: aload_3
/*     */     //   232: ifnull -> 247
/*     */     //   235: aload #4
/*     */     //   237: aload_3
/*     */     //   238: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
/*     */     //   241: aload #4
/*     */     //   243: aload_3
/*     */     //   244: invokevirtual m_6703_ : (Lnet/minecraft/world/entity/LivingEntity;)V
/*     */     //   247: goto -> 265
/*     */     //   250: aload_0
/*     */     //   251: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModSounds.STEVE_SAY_ON_DEATH : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   254: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   257: checkcast net/minecraft/sounds/SoundEvent
/*     */     //   260: fconst_1
/*     */     //   261: fconst_1
/*     */     //   262: invokevirtual m_5496_ : (Lnet/minecraft/sounds/SoundEvent;FF)V
/*     */     //   265: aload_0
/*     */     //   266: aload_1
/*     */     //   267: invokespecial m_6667_ : (Lnet/minecraft/world/damagesource/DamageSource;)V
/*     */     //   270: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #145	-> 0
/*     */     //   #146	-> 17
/*     */     //   #147	-> 44
/*     */     //   #148	-> 46
/*     */     //   #149	-> 75
/*     */     //   #150	-> 81
/*     */     //   #151	-> 98
/*     */     //   #152	-> 106
/*     */     //   #153	-> 123
/*     */     //   #156	-> 128
/*     */     //   #158	-> 147
/*     */     //   #159	-> 164
/*     */     //   #160	-> 176
/*     */     //   #161	-> 180
/*     */     //   #162	-> 186
/*     */     //   #164	-> 197
/*     */     //   #165	-> 224
/*     */     //   #166	-> 231
/*     */     //   #167	-> 235
/*     */     //   #168	-> 241
/*     */     //   #170	-> 247
/*     */     //   #171	-> 250
/*     */     //   #172	-> 254
/*     */     //   #171	-> 262
/*     */     //   #178	-> 265
/*     */     //   #179	-> 270
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   67	14	4	living	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   46	201	3	target	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   147	100	4	angrySteveEntity	Lcom/pla/annoyingvillagers/entity/AngrySteveEntity;
/*     */     //   186	61	5	steveData	Lcom/pla/annoyingvillagers/spawnhandler/SteveData;
/*     */     //   17	248	2	serverLevel	Lnet/minecraft/server/level/ServerLevel;
/*     */     //   0	271	0	this	Lcom/pla/annoyingvillagers/entity/SteveEntity;
/*     */     //   0	271	1	pDamageSource	Lnet/minecraft/world/damagesource/DamageSource;
/*     */   }
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
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/*     */     ServerLevel serverLevel;
/* 183 */     super.m_7472_(source, looting, recentlyHit);
/* 184 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else
/*     */     { return; }
/* 187 */      double x = m_20185_();
/* 188 */     double y = m_20186_() + 1.0D;
/* 189 */     double z = m_20189_();
/*     */     
/* 191 */     Consumer<ItemStack> dropStack = stack -> {
/*     */         ItemEntity drop = new ItemEntity((Level)serverLevel, x, y, z, stack);
/*     */         
/*     */         drop.m_32010_(10);
/*     */         serverLevel.m_7967_((Entity)drop);
/*     */       };
/* 197 */     Consumer<Integer> dropArrows = count -> {
/*     */         for (int i = 0; i < count.intValue(); i++)
/*     */           dropStack.accept(new ItemStack((ItemLike)Items.f_42412_)); 
/*     */       };
/* 201 */     List<ItemStack> damagedStacks = new ArrayList<>();
/*     */     
/* 203 */     ItemStack compressedDiamondHelmet = new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND_HELMET.get());
/* 204 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44965_, 5);
/* 205 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44969_, 5);
/* 206 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44966_, 5);
/* 207 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44968_, 5);
/* 208 */     damagedStacks.add(compressedDiamondHelmet);
/*     */     
/* 210 */     ItemStack compressedDiamondChestplate = new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND_CHESTPLATE.get());
/* 211 */     compressedDiamondChestplate.m_41663_(Enchantments.f_44965_, 5);
/* 212 */     compressedDiamondChestplate.m_41663_(Enchantments.f_44969_, 5);
/* 213 */     compressedDiamondChestplate.m_41663_(Enchantments.f_44966_, 5);
/* 214 */     compressedDiamondChestplate.m_41663_(Enchantments.f_44968_, 5);
/* 215 */     damagedStacks.add(compressedDiamondChestplate);
/*     */     
/* 217 */     ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 218 */     diamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 219 */     diamondSword.m_41663_(Enchantments.f_44978_, 5);
/* 220 */     damagedStacks.add(diamondSword);
/*     */     
/* 222 */     if ((new Random()).nextBoolean()) {
/* 223 */       damagedStacks.add(diamondSword);
/*     */     }
/*     */     
/* 226 */     ItemStack bow = getBowItem();
/* 227 */     bow.m_41663_(Enchantments.f_44988_, 5);
/* 228 */     bow.m_41663_(Enchantments.f_44989_, 5);
/* 229 */     damagedStacks.add(bow);
/*     */     
/* 231 */     double chance = (new Random()).nextDouble(0.0D, 1.0D);
/* 232 */     if (chance < 0.2D) {
/* 233 */       ItemStack woodenDoor = new ItemStack((ItemLike)AnnoyingVillagersModItems.WOODEN_DOOR.get());
/* 234 */       woodenDoor.m_41663_(Enchantments.f_44977_, 5);
/* 235 */       woodenDoor.m_41663_(Enchantments.f_44980_, 3);
/* 236 */       woodenDoor.m_41663_(Enchantments.f_44962_, 5);
/* 237 */       damagedStacks.add(woodenDoor);
/* 238 */     } else if (chance < 0.4D) {
/* 239 */       ItemStack craftingTable = new ItemStack((ItemLike)AnnoyingVillagersModItems.CRAFTING_TABLE.get());
/* 240 */       craftingTable.m_41663_(Enchantments.f_44978_, 5);
/* 241 */       craftingTable.m_41663_(Enchantments.f_44980_, 3);
/* 242 */       craftingTable.m_41663_(Enchantments.f_44962_, 5);
/* 243 */       damagedStacks.add(craftingTable);
/* 244 */     } else if (chance < 0.6D) {
/* 245 */       ItemStack ladder = new ItemStack((ItemLike)AnnoyingVillagersModItems.LADDER.get());
/* 246 */       ladder.m_41663_(Enchantments.f_44978_, 5);
/* 247 */       ladder.m_41663_(Enchantments.f_44983_, 3);
/* 248 */       ladder.m_41663_(Enchantments.f_44962_, 5);
/* 249 */       damagedStacks.add(ladder);
/* 250 */     } else if (chance < 0.8D) {
/* 251 */       ItemStack trapDoor = new ItemStack((ItemLike)AnnoyingVillagersModItems.TRAPDOOR.get());
/* 252 */       trapDoor.m_41663_(Enchantments.f_44980_, 5);
/* 253 */       trapDoor.m_41663_(Enchantments.f_44983_, 3);
/* 254 */       trapDoor.m_41663_(Enchantments.f_44962_, 5);
/* 255 */       damagedStacks.add(trapDoor);
/*     */     } else {
/* 257 */       ItemStack mendingDiamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 258 */       mendingDiamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 259 */       mendingDiamondSword.m_41663_(Enchantments.f_44978_, 5);
/* 260 */       mendingDiamondSword.m_41663_(Enchantments.f_44962_, 5);
/* 261 */       damagedStacks.add(mendingDiamondSword);
/*     */     } 
/*     */     
/* 264 */     ItemStack woopieTheSword = new ItemStack((ItemLike)AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get());
/* 265 */     woopieTheSword.m_41663_(Enchantments.f_44977_, 5);
/* 266 */     woopieTheSword.m_41663_(Enchantments.f_44978_, 5);
/* 267 */     woopieTheSword.m_41663_(Enchantments.f_44983_, 5);
/* 268 */     damagedStacks.add(woopieTheSword);
/* 269 */     damagedStacks.add(new ItemStack((ItemLike)AnnoyingVillagersModItems.JESSICA_THE_DARK_SHIELD.get()));
/*     */     
/* 271 */     for (ItemStack stack : damagedStacks) {
/* 272 */       stack.m_41721_(EquipmentDataLoader.getRandomDamage(stack));
/* 273 */       dropStack.accept(stack);
/*     */     } 
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
/* 311 */     ItemLike[] simpleDrops = { (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42437_, (ItemLike)Items.f_42437_, (ItemLike)Items.f_42437_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50077_, (ItemLike)Blocks.f_50077_, (ItemLike)Blocks.f_50090_, (ItemLike)Blocks.f_50260_, (ItemLike)Items.f_42503_, (ItemLike)Items.f_42502_, (ItemLike)Items.f_42447_, (ItemLike)Items.f_42580_, (ItemLike)Items.f_42580_, (ItemLike)Items.f_42580_, (ItemLike)Items.f_42523_, (ItemLike)Items.f_42491_, (ItemLike)Items.f_42619_, (ItemLike)Items.f_42619_, (ItemLike)Items.f_42674_, (ItemLike)Items.f_42674_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42416_, (ItemLike)Items.f_42416_, (ItemLike)Items.f_42416_, (ItemLike)Items.f_42416_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get() };
/*     */ 
/*     */     
/* 314 */     for (ItemLike itemLike : simpleDrops) {
/* 315 */       dropStack.accept(new ItemStack(itemLike));
/*     */     }
/* 317 */     dropArrows.accept(Integer.valueOf((new Random()).nextInt(10, 30)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 322 */     super.m_7380_(tag);
/* 323 */     tag.m_128405_("State", this.state);
/* 324 */     tag.m_128405_("SwapWeaponCooldown", this.swapWeaponCooldown);
/* 325 */     tag.m_128379_("SayLegendary", this.sayLegendary);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 330 */     super.m_7378_(tag);
/* 331 */     this.state = tag.m_128451_("State");
/* 332 */     this.swapWeaponCooldown = tag.m_128451_("SwapWeaponCooldown");
/* 333 */     this.sayLegendary = tag.m_128471_("SayLegendary");
/*     */   }
/*     */ 
/*     */   
/*     */   public void rollItem() {
/* 338 */     boolean setWeapon = false;
/* 339 */     if (this.state == 1) {
/* 340 */       double chance = (new Random()).nextDouble(0.0D, 1.0D);
/* 341 */       if (m_21223_() > m_21233_() / 2.0F)
/* 342 */       { if (chance <= 0.6D) {
/* 343 */           ItemStack woopieTheSword = new ItemStack((ItemLike)AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get());
/* 344 */           woopieTheSword.m_41663_(Enchantments.f_44977_, 5);
/* 345 */           woopieTheSword.m_41663_(Enchantments.f_44978_, 5);
/* 346 */           woopieTheSword.m_41663_(Enchantments.f_44983_, 5);
/* 347 */           m_21008_(InteractionHand.MAIN_HAND, woopieTheSword);
/*     */           
/* 349 */           m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.JESSICA_THE_DARK_SHIELD.get()));
/* 350 */           setOffWeaponItem(getOffWeaponItem().m_41777_());
/* 351 */           setWeapon = true;
/*     */         } else {
/* 353 */           ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 354 */           diamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 355 */           diamondSword.m_41663_(Enchantments.f_44978_, 5);
/* 356 */           m_21008_(InteractionHand.MAIN_HAND, diamondSword);
/* 357 */           m_21008_(InteractionHand.OFF_HAND, diamondSword);
/* 358 */           setWeapon = true;
/*     */         }
/*     */          }
/* 361 */       else if (chance <= 0.4D)
/* 362 */       { ItemStack woopieTheSword = new ItemStack((ItemLike)AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get());
/* 363 */         woopieTheSword.m_41663_(Enchantments.f_44977_, 5);
/* 364 */         woopieTheSword.m_41663_(Enchantments.f_44978_, 5);
/* 365 */         woopieTheSword.m_41663_(Enchantments.f_44983_, 5);
/* 366 */         m_21008_(InteractionHand.MAIN_HAND, woopieTheSword);
/*     */         
/* 368 */         m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.JESSICA_THE_DARK_SHIELD.get()));
/* 369 */         setOffWeaponItem(getOffWeaponItem().m_41777_());
/* 370 */         setWeapon = true; }
/* 371 */       else { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 372 */           if (!this.sayLegendary) {
/* 373 */             m_5496_((SoundEvent)AnnoyingVillagersModSounds.STEVE_SAY_I_NOT_BELIEVE
/* 374 */                 .get(), 1.0F, 1.0F);
/*     */ 
/*     */             
/* 377 */             this.sayLegendary = true;
/*     */           } 
/* 379 */           ItemStack legendarySword = new ItemStack((ItemLike)AnnoyingVillagersModItems.LEGENDARY_SWORD.get());
/* 380 */           m_21008_(InteractionHand.MAIN_HAND, legendarySword);
/* 381 */           setWeapon = true; }
/*     */          }
/*     */     
/* 384 */     } else if (this.state == 0 && m_21223_() <= 20.0F) {
/* 385 */       ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 386 */       diamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 387 */       diamondSword.m_41663_(Enchantments.f_44978_, 5);
/* 388 */       m_21008_(InteractionHand.MAIN_HAND, diamondSword);
/* 389 */       m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)Items.f_42747_));
/* 390 */       setWeapon = true;
/*     */     } 
/*     */     
/* 393 */     if (!setWeapon) {
/* 394 */       double chance = (new Random()).nextDouble(0.0D, 1.0D);
/* 395 */       if (chance <= 0.2D) {
/* 396 */         ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 397 */         diamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 398 */         diamondSword.m_41663_(Enchantments.f_44978_, 5);
/* 399 */         m_21008_(InteractionHand.MAIN_HAND, diamondSword);
/* 400 */       } else if (chance <= 0.4D) {
/* 401 */         ItemStack woodenDoor = new ItemStack((ItemLike)AnnoyingVillagersModItems.WOODEN_DOOR.get());
/* 402 */         woodenDoor.m_41663_(Enchantments.f_44977_, 5);
/* 403 */         woodenDoor.m_41663_(Enchantments.f_44980_, 3);
/* 404 */         m_21008_(InteractionHand.MAIN_HAND, woodenDoor);
/* 405 */       } else if (chance <= 0.6D) {
/* 406 */         ItemStack craftingTable = new ItemStack((ItemLike)AnnoyingVillagersModItems.CRAFTING_TABLE.get());
/* 407 */         craftingTable.m_41663_(Enchantments.f_44978_, 5);
/* 408 */         craftingTable.m_41663_(Enchantments.f_44980_, 3);
/* 409 */         m_21008_(InteractionHand.MAIN_HAND, craftingTable);
/* 410 */       } else if (chance <= 0.8D) {
/* 411 */         ItemStack ladder = new ItemStack((ItemLike)AnnoyingVillagersModItems.LADDER.get());
/* 412 */         ladder.m_41663_(Enchantments.f_44978_, 5);
/* 413 */         ladder.m_41663_(Enchantments.f_44983_, 3);
/* 414 */         m_21008_(InteractionHand.MAIN_HAND, ladder);
/*     */       } else {
/* 416 */         ItemStack trapDoor = new ItemStack((ItemLike)AnnoyingVillagersModItems.TRAPDOOR.get());
/* 417 */         trapDoor.m_41663_(Enchantments.f_44980_, 5);
/* 418 */         trapDoor.m_41663_(Enchantments.f_44983_, 3);
/* 419 */         m_21008_(InteractionHand.MAIN_HAND, trapDoor);
/*     */       } 
/*     */     } 
/* 422 */     setMainWeaponItem(m_21205_().m_41777_());
/* 423 */     this.swapWeaponCooldown = (new Random()).nextInt(100, 200);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void implementFirstTick(ServerLevel serverLevel) {
/* 428 */     super.implementFirstTick(serverLevel);
/* 429 */     m_5496_((SoundEvent)AnnoyingVillagersModSounds.STEVE_SAY_ON_SPAWN
/* 430 */         .get(), 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 437 */     super.m_8119_();
/* 438 */     if (m_9236_() instanceof ServerLevel) {
/* 439 */       if (m_5448_() != null && m_5448_().m_6084_() && m_21205_().m_41619_()) {
/* 440 */         rollItem();
/* 441 */         m_5496_((SoundEvent)AnnoyingVillagersModSounds.STEVE_SAY_WHAT
/* 442 */             .get(), 1.0F, 1.0F);
/*     */       } 
/*     */ 
/*     */       
/* 446 */       if (getState() != 2 && m_5448_() == null && !m_21205_().m_41619_()) {
/* 447 */         m_21008_(InteractionHand.MAIN_HAND, ItemStack.f_41583_);
/* 448 */         m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/*     */       } 
/* 450 */       if (this.state == 0 && 
/* 451 */         m_21223_() <= 20.0F && 
/* 452 */         !m_21120_(InteractionHand.OFF_HAND).m_41720_().equals(Items.f_42747_)) {
/* 453 */         m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)Items.f_42747_));
/*     */       }
/* 455 */       if (m_5448_() != null && this.state == 0 && 
/* 456 */         m_21223_() > 20.0F && 
/* 457 */         m_21120_(InteractionHand.OFF_HAND).m_41720_().equals(Items.f_42747_) && 
/* 458 */         !(m_21120_(InteractionHand.OFF_HAND).m_41720_() instanceof net.minecraft.world.item.ShieldItem)) {
/* 459 */         m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/*     */       }
/* 461 */       if (this.swapWeaponCooldown > 0) this.swapWeaponCooldown--; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 466 */     if (mobSpawnType == MobSpawnType.NATURAL || mobSpawnType == MobSpawnType.CHUNK_GENERATION) {
/* 467 */       ServerLevel serverLevel = serverLevelAccessor.m_6018_();
/* 468 */       SteveData steveData = SteveData.get(serverLevel);
/*     */       
/* 470 */       if (!steveData.tryClaim(serverLevel, m_20148_())) {
/* 471 */         m_146870_();
/* 472 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 476 */     TeamUtil.addOrJoinTeam((Entity)this, "steve");
/* 477 */     this.swapWeaponCooldown = (new Random()).nextInt(100, 200);
/* 478 */     return super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawngroupdata, compoundtag);
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<SteveEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 482 */     ServerLevel serverLevel = level.m_6018_();
/* 483 */     if (SteveData.get(serverLevel).isOccupied(serverLevel)) {
/* 484 */       return false;
/*     */     }
/* 486 */     return PathfinderMob.m_217057_(entityType, (LevelAccessor)level, spawnType, position, random);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 491 */     super.m_142687_(reason);
/* 492 */     if (!(m_9236_()).f_46443_) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (reason == Entity.RemovalReason.KILLED || reason == Entity.RemovalReason.DISCARDED)
/*     */         {
/* 494 */           SteveData.get(serverLevel).releaseIfMatches(serverLevel, m_20148_()); }  }
/*     */        }
/*     */   
/*     */   }
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 499 */     return Mob.m_21552_()
/* 500 */       .m_22268_(Attributes.f_22276_, 50.0D)
/* 501 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 502 */       .m_22268_(Attributes.f_22281_, 0.0D)
/* 503 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 504 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 505 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 506 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 507 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 2.0D)
/* 508 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 5.0D)
/* 509 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 510 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 50.0D)
/* 511 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 30.0D)
/* 512 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\SteveEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */