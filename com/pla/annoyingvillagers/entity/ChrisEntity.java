/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.spawnhandler.ChrisData;
/*     */ import com.pla.annoyingvillagers.util.CommonGoals;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ import net.minecraft.world.InteractionHand;
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
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class ChrisEntity extends AVNpc {
/*  44 */   private int state = 0;
/*     */   
/*     */   public ChrisEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  47 */     this((EntityType<ChrisEntity>)AnnoyingVillagersModEntities.CHRIS.get(), level);
/*     */   }
/*     */   
/*     */   public ChrisEntity(EntityType<ChrisEntity> entitytype, Level level) {
/*  51 */     super(entitytype, level);
/*  52 */     m_274367_(2.6F);
/*  53 */     this.f_21364_ = 50;
/*  54 */     m_21557_(false);
/*  55 */     m_6593_(m_5446_());
/*  56 */     m_20340_(true);
/*  57 */     m_21530_();
/*  58 */     setPlaceBlockToParryChance(0.6D);
/*     */   }
/*     */   
/*     */   public int getState() {
/*  62 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(int state) {
/*  66 */     this.state = state;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/*  71 */     super.m_7380_(tag);
/*  72 */     tag.m_128405_("State", this.state);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/*  77 */     super.m_7378_(tag);
/*  78 */     this.state = tag.m_128451_("State");
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  82 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  86 */     super.m_8099_();
/*  87 */     CommonGoals.registerGoalForNeutralNpc((PathfinderMob)this);
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/*  91 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/*  99 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 103 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/* 107 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 117 */     doChrisStyleEnderPearlCounter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean afterBurstProtection(@NotNull ServerLevel serverLevel, @NotNull DamageSource source, float finalDamage) {
/* 124 */     if (this.state == 0 && 
/* 125 */       m_21223_() - finalDamage <= 1.0F && 
/* 126 */       !m_21206_().m_150930_(Items.f_42747_)) {
/* 127 */       m_21153_(1.0F);
/* 128 */       return true;
/*     */     } 
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBurstProtectCapRatio() {
/* 135 */     return 0.25F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/* 140 */     super.m_7472_(source, looting, recentlyHit);
/* 141 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 142 */       double x = m_20185_();
/* 143 */       double y = m_20186_() + 1.0D;
/* 144 */       double z = m_20189_();
/*     */       
/* 146 */       Consumer<ItemStack> dropStack = stack -> {
/*     */           ItemEntity drop = new ItemEntity((Level)serverLevel, x, y, z, stack);
/*     */           
/*     */           drop.m_32010_(10);
/*     */           serverLevel.m_7967_((Entity)drop);
/*     */         };
/* 152 */       Consumer<Integer> dropArrows = count -> {
/*     */           for (int i = 0; i < count.intValue(); i++)
/*     */             dropStack.accept(new ItemStack((ItemLike)Items.f_42412_)); 
/*     */         };
/* 156 */       List<ItemStack> damagedStacks = new ArrayList<>();
/*     */       
/* 158 */       ItemStack sword = new ItemStack((ItemLike)Items.f_42388_);
/* 159 */       sword.m_41663_(Enchantments.f_44980_, 5);
/* 160 */       sword.m_41663_(Enchantments.f_44977_, 5);
/* 161 */       sword.m_41663_(Enchantments.f_44986_, 5);
/* 162 */       damagedStacks.add(sword);
/*     */       
/* 164 */       ItemStack diamondHelmet = new ItemStack((ItemLike)Items.f_42472_);
/* 165 */       diamondHelmet.m_41663_(Enchantments.f_44965_, 5);
/* 166 */       diamondHelmet.m_41663_(Enchantments.f_44986_, 5);
/* 167 */       damagedStacks.add(diamondHelmet);
/*     */       
/* 169 */       ItemStack diamondChestplate = new ItemStack((ItemLike)Items.f_42473_);
/* 170 */       diamondChestplate.m_41663_(Enchantments.f_44965_, 5);
/* 171 */       diamondChestplate.m_41663_(Enchantments.f_44986_, 5);
/* 172 */       damagedStacks.add(diamondChestplate);
/*     */       
/* 174 */       ItemStack diamondBoots = new ItemStack((ItemLike)Items.f_42475_);
/* 175 */       diamondBoots.m_41663_(Enchantments.f_44965_, 5);
/* 176 */       diamondBoots.m_41663_(Enchantments.f_44974_, 2);
/* 177 */       diamondBoots.m_41663_(Enchantments.f_44986_, 5);
/* 178 */       damagedStacks.add(diamondBoots);
/*     */       
/* 180 */       ItemStack bow = getBowItem();
/* 181 */       bow.m_41663_(Enchantments.f_44988_, 2);
/* 182 */       bow.m_41663_(Enchantments.f_44989_, 2);
/* 183 */       damagedStacks.add(bow);
/*     */       
/* 185 */       ItemStack ironPickaxe = new ItemStack((ItemLike)Items.f_42385_);
/* 186 */       ironPickaxe.m_41663_(Enchantments.f_44986_, 3);
/* 187 */       damagedStacks.add(ironPickaxe);
/*     */       
/* 189 */       ItemStack ironAxe = new ItemStack((ItemLike)Items.f_42386_);
/* 190 */       ironAxe.m_41663_(Enchantments.f_44986_, 3);
/* 191 */       damagedStacks.add(ironAxe);
/*     */       
/* 193 */       for (ItemStack stack : damagedStacks) {
/* 194 */         stack.m_41721_(EquipmentDataLoader.getRandomDamage(stack));
/* 195 */         dropStack.accept(stack);
/*     */       } 
/*     */       
/* 198 */       ItemStack[] simpleDrops = { new ItemStack((ItemLike)Items.f_42747_), new ItemStack((ItemLike)Items.f_42740_), new ItemStack((ItemLike)Items.f_151059_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42584_), new ItemStack((ItemLike)Items.f_42453_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_41960_), new ItemStack((ItemLike)Items.f_41960_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42616_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42503_) };
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
/* 249 */       for (ItemStack stack : simpleDrops) {
/* 250 */         dropStack.accept(stack);
/*     */       }
/*     */       
/* 253 */       dropArrows.accept(Integer.valueOf((new Random()).nextInt(10, 20))); }
/*     */   
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 258 */     if (mobSpawnType == MobSpawnType.NATURAL || mobSpawnType == MobSpawnType.CHUNK_GENERATION) {
/* 259 */       ServerLevel serverLevel = serverLevelAccessor.m_6018_();
/* 260 */       ChrisData chrisData = ChrisData.get(serverLevel);
/*     */       
/* 262 */       if (!chrisData.tryClaim(serverLevel, m_20148_())) {
/* 263 */         m_146870_();
/* 264 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 268 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawngroupdata, compoundtag);
/*     */     
/* 270 */     ItemStack sword = new ItemStack((ItemLike)Items.f_42388_);
/* 271 */     sword.m_41663_(Enchantments.f_44980_, 5);
/* 272 */     sword.m_41663_(Enchantments.f_44977_, 5);
/* 273 */     sword.m_41663_(Enchantments.f_44986_, 5);
/* 274 */     m_8061_(EquipmentSlot.MAINHAND, sword);
/*     */     
/* 276 */     m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)Items.f_42584_));
/*     */     
/* 278 */     ItemStack diamondHelmet = new ItemStack((ItemLike)Items.f_42472_);
/* 279 */     diamondHelmet.m_41663_(Enchantments.f_44965_, 5);
/* 280 */     diamondHelmet.m_41663_(Enchantments.f_44986_, 5);
/* 281 */     m_8061_(EquipmentSlot.HEAD, diamondHelmet);
/*     */     
/* 283 */     ItemStack diamondChestplate = new ItemStack((ItemLike)Items.f_42473_);
/* 284 */     diamondChestplate.m_41663_(Enchantments.f_44965_, 5);
/* 285 */     diamondChestplate.m_41663_(Enchantments.f_44986_, 5);
/* 286 */     m_8061_(EquipmentSlot.CHEST, diamondChestplate);
/*     */     
/* 288 */     ItemStack diamondBoots = new ItemStack((ItemLike)Items.f_42475_);
/* 289 */     diamondBoots.m_41663_(Enchantments.f_44965_, 5);
/* 290 */     diamondBoots.m_41663_(Enchantments.f_44974_, 2);
/* 291 */     diamondBoots.m_41663_(Enchantments.f_44986_, 5);
/* 292 */     m_8061_(EquipmentSlot.FEET, diamondBoots);
/*     */     
/* 294 */     TeamUtil.addOrJoinTeam((Entity)this, "steve");
/* 295 */     return returnSpawnGroupData;
/*     */   }
/*     */   
/*     */   public void m_5993_(@NotNull Entity entity, int i, @NotNull DamageSource damagesource) {
/* 299 */     super.m_5993_(entity, i, damagesource);
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<ChrisEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 303 */     ServerLevel serverLevel = level.m_6018_();
/* 304 */     if (ChrisData.get(serverLevel).isOccupied(serverLevel)) {
/* 305 */       return false;
/*     */     }
/* 307 */     return PathfinderMob.m_217057_(entityType, (LevelAccessor)level, spawnType, position, random);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void implementFirstTick(ServerLevel serverLevel) {
/* 312 */     super.implementFirstTick(serverLevel);
/* 313 */     m_5496_((SoundEvent)AnnoyingVillagersModSounds.CHRIS_SAY_ON_SPAWN
/* 314 */         .get(), 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 321 */     super.m_8119_();
/* 322 */     if (!(m_9236_()).f_46443_ && 
/* 323 */       this.state == 0 && 
/* 324 */       m_21223_() <= 20.0F && 
/* 325 */       !m_21120_(InteractionHand.OFF_HAND).m_41720_().equals(Items.f_42747_)) {
/* 326 */       m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)Items.f_42747_));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 333 */     super.m_142687_(reason);
/* 334 */     if (!(m_9236_()).f_46443_) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (reason == Entity.RemovalReason.KILLED || reason == Entity.RemovalReason.DISCARDED)
/*     */         {
/* 336 */           ChrisData.get(serverLevel).releaseIfMatches(serverLevel, m_20148_()); }  }
/*     */        }
/*     */   
/*     */   }
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 341 */     return Mob.m_21552_()
/* 342 */       .m_22268_(Attributes.f_22276_, 50.0D)
/* 343 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 344 */       .m_22268_(Attributes.f_22281_, 0.0D)
/* 345 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 346 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 347 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 348 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 349 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 2.0D)
/* 350 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 5.0D)
/* 351 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 352 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 50.0D)
/* 353 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 30.0D)
/* 354 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ChrisEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */