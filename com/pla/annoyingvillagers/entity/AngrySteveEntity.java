/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.CombatCommon;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.entity.goal.KeepPositionGoal;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.ArmorUtil;
/*     */ import com.pla.annoyingvillagers.util.EquipmentDataLoader;
/*     */ import com.pla.annoyingvillagers.util.TeamUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.function.Consumer;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import net.shelmarow.combat_evolution.effect.CEMobEffects;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class AngrySteveEntity extends AVNpc {
/*  57 */   private int leaveTicks = 0; private boolean neverLeave = false;
/*     */   
/*     */   public void setLeaveTicks(int leaveTicks) {
/*  60 */     this.leaveTicks = leaveTicks;
/*     */   }
/*     */   
/*     */   public int getLeaveTicks() {
/*  64 */     return this.leaveTicks;
/*     */   }
/*     */   
/*     */   public void setNeverLeave(boolean neverLeave) {
/*  68 */     this.neverLeave = neverLeave;
/*     */   }
/*     */   
/*     */   public AngrySteveEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  72 */     this((EntityType<AngrySteveEntity>)AnnoyingVillagersModEntities.ANGRY_STEVE.get(), level);
/*     */   }
/*     */   
/*     */   public AngrySteveEntity(EntityType<AngrySteveEntity> entitytype, Level level) {
/*  76 */     super(entitytype, level);
/*  77 */     m_274367_(3.0F);
/*  78 */     this.f_21364_ = 8;
/*  79 */     m_21557_(false);
/*  80 */     m_6593_(m_5446_());
/*  81 */     m_20340_(true);
/*  82 */     m_21530_();
/*  83 */     setPlaceBlockToParryChance(1.0D);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  87 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  91 */     super.m_8099_();
/*  92 */     this.f_21345_.m_25352_(1, (Goal)new KeepPositionGoal((Mob)this));
/*  93 */     CommonGoals.registerGoalForCrazyNpc((PathfinderMob)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag pCompound) {
/*  98 */     super.m_7378_(pCompound);
/*  99 */     this.leaveTicks = pCompound.m_128451_("LeaveTicks");
/* 100 */     this.neverLeave = pCompound.m_128471_("NeverLeave");
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag pCompound) {
/* 105 */     super.m_7380_(pCompound);
/* 106 */     pCompound.m_128405_("LeaveTicks", this.leaveTicks);
/* 107 */     pCompound.m_128379_("NeverLeave", this.neverLeave);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/* 112 */     return (SoundEvent)AnnoyingVillagersModSounds.ANGRY_STEVE_SAY.get();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 116 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 120 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 124 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 128 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/* 132 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 142 */     doSteveStyleEnderPearlCounter();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBurstProtectCapRatio() {
/* 147 */     return 0.05F;
/*     */   }
/*     */   
/*     */   public boolean m_7301_(MobEffectInstance mobeffectinstance) {
/* 151 */     return ((mobeffectinstance.m_19544_().m_19483_() == MobEffectCategory.BENEFICIAL || mobeffectinstance.m_19544_() == MobEffects.f_19619_) && super.m_7301_(mobeffectinstance));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_7327_(@NotNull Entity pEntity) {
/* 156 */     if (!m_9236_().m_5776_() && pEntity instanceof LivingEntity) { LivingEntity living = (LivingEntity)pEntity;
/* 157 */       ArmorUtil.damageArmor(living, (new Random()).nextInt(1, 5)); }
/*     */     
/* 159 */     return super.m_7327_(pEntity);
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damageSource) {
/* 163 */     super.m_6667_(damageSource);
/* 164 */     if (m_9236_() instanceof ServerLevel) {
/* 165 */       m_216990_((SoundEvent)AnnoyingVillagersModSounds.STEVE_SAY_ON_DEATH.get());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/*     */     ServerLevel serverLevel;
/* 171 */     super.m_7472_(source, looting, recentlyHit);
/* 172 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else
/*     */     { return; }
/* 175 */      double x = m_20185_();
/* 176 */     double y = m_20186_() + 1.0D;
/* 177 */     double z = m_20189_();
/*     */     
/* 179 */     Consumer<ItemStack> dropStack = stack -> {
/*     */         ItemEntity drop = new ItemEntity((Level)serverLevel, x, y, z, stack);
/*     */         
/*     */         drop.m_32010_(10);
/*     */         serverLevel.m_7967_((Entity)drop);
/*     */       };
/* 185 */     Consumer<Integer> dropArrows = count -> {
/*     */         for (int i = 0; i < count.intValue(); i++)
/*     */           dropStack.accept(new ItemStack((ItemLike)Items.f_42412_)); 
/*     */       };
/* 189 */     List<ItemStack> damagedStacks = new ArrayList<>();
/*     */     
/* 191 */     ItemStack compressedDiamondHelmet = new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND_HELMET.get());
/* 192 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44965_, 5);
/* 193 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44969_, 5);
/* 194 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44966_, 5);
/* 195 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44968_, 5);
/* 196 */     damagedStacks.add(compressedDiamondHelmet);
/*     */     
/* 198 */     ItemStack compressedDiamondChestplate = new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND_CHESTPLATE.get());
/* 199 */     compressedDiamondChestplate.m_41663_(Enchantments.f_44965_, 5);
/* 200 */     compressedDiamondChestplate.m_41663_(Enchantments.f_44969_, 5);
/* 201 */     compressedDiamondChestplate.m_41663_(Enchantments.f_44966_, 5);
/* 202 */     compressedDiamondChestplate.m_41663_(Enchantments.f_44968_, 5);
/* 203 */     damagedStacks.add(compressedDiamondChestplate);
/*     */     
/* 205 */     ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 206 */     diamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 207 */     diamondSword.m_41663_(Enchantments.f_44978_, 5);
/* 208 */     damagedStacks.add(diamondSword);
/*     */     
/* 210 */     if ((new Random()).nextBoolean()) {
/* 211 */       damagedStacks.add(diamondSword);
/*     */     }
/*     */     
/* 214 */     ItemStack bow = getBowItem();
/* 215 */     bow.m_41663_(Enchantments.f_44988_, 5);
/* 216 */     bow.m_41663_(Enchantments.f_44989_, 5);
/* 217 */     damagedStacks.add(bow);
/*     */     
/* 219 */     double chance = (new Random()).nextDouble(0.0D, 1.0D);
/* 220 */     if (chance < 0.2D) {
/* 221 */       ItemStack woodenDoor = new ItemStack((ItemLike)AnnoyingVillagersModItems.WOODEN_DOOR.get());
/* 222 */       woodenDoor.m_41663_(Enchantments.f_44977_, 5);
/* 223 */       woodenDoor.m_41663_(Enchantments.f_44980_, 3);
/* 224 */       woodenDoor.m_41663_(Enchantments.f_44962_, 5);
/* 225 */       damagedStacks.add(woodenDoor);
/* 226 */     } else if (chance < 0.4D) {
/* 227 */       ItemStack craftingTable = new ItemStack((ItemLike)AnnoyingVillagersModItems.CRAFTING_TABLE.get());
/* 228 */       craftingTable.m_41663_(Enchantments.f_44978_, 5);
/* 229 */       craftingTable.m_41663_(Enchantments.f_44980_, 3);
/* 230 */       craftingTable.m_41663_(Enchantments.f_44962_, 5);
/* 231 */       damagedStacks.add(craftingTable);
/* 232 */     } else if (chance < 0.6D) {
/* 233 */       ItemStack ladder = new ItemStack((ItemLike)AnnoyingVillagersModItems.LADDER.get());
/* 234 */       ladder.m_41663_(Enchantments.f_44978_, 5);
/* 235 */       ladder.m_41663_(Enchantments.f_44983_, 3);
/* 236 */       ladder.m_41663_(Enchantments.f_44962_, 5);
/* 237 */       damagedStacks.add(ladder);
/* 238 */     } else if (chance < 0.8D) {
/* 239 */       ItemStack trapDoor = new ItemStack((ItemLike)AnnoyingVillagersModItems.TRAPDOOR.get());
/* 240 */       trapDoor.m_41663_(Enchantments.f_44980_, 5);
/* 241 */       trapDoor.m_41663_(Enchantments.f_44983_, 3);
/* 242 */       trapDoor.m_41663_(Enchantments.f_44962_, 5);
/* 243 */       damagedStacks.add(trapDoor);
/*     */     } else {
/* 245 */       ItemStack mendingDiamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 246 */       mendingDiamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 247 */       mendingDiamondSword.m_41663_(Enchantments.f_44978_, 5);
/* 248 */       mendingDiamondSword.m_41663_(Enchantments.f_44962_, 5);
/* 249 */       damagedStacks.add(mendingDiamondSword);
/*     */     } 
/*     */     
/* 252 */     ItemStack legendarySword = new ItemStack((ItemLike)AnnoyingVillagersModItems.LEGENDARY_SWORD.get());
/* 253 */     legendarySword.m_41663_(Enchantments.f_44977_, 5);
/* 254 */     legendarySword.m_41663_(Enchantments.f_44978_, 5);
/* 255 */     legendarySword.m_41663_(Enchantments.f_44983_, 5);
/* 256 */     damagedStacks.add(legendarySword);
/*     */     
/* 258 */     for (ItemStack stack : damagedStacks) {
/* 259 */       stack.m_41721_(EquipmentDataLoader.getRandomDamage(stack));
/* 260 */       dropStack.accept(stack);
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
/* 298 */     ItemLike[] simpleDrops = { (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42436_, (ItemLike)Items.f_42437_, (ItemLike)Items.f_42437_, (ItemLike)Items.f_42437_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Items.f_42584_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50493_, (ItemLike)Blocks.f_50077_, (ItemLike)Blocks.f_50077_, (ItemLike)Blocks.f_50090_, (ItemLike)Blocks.f_50260_, (ItemLike)Items.f_42503_, (ItemLike)Items.f_42502_, (ItemLike)Items.f_42447_, (ItemLike)Items.f_42580_, (ItemLike)Items.f_42580_, (ItemLike)Items.f_42580_, (ItemLike)Items.f_42523_, (ItemLike)Items.f_42491_, (ItemLike)Items.f_42619_, (ItemLike)Items.f_42619_, (ItemLike)Items.f_42674_, (ItemLike)Items.f_42674_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42398_, (ItemLike)Items.f_42416_, (ItemLike)Items.f_42416_, (ItemLike)Items.f_42416_, (ItemLike)Items.f_42416_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)Items.f_42415_, (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get(), (ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get() };
/*     */ 
/*     */     
/* 301 */     for (ItemLike itemLike : simpleDrops) {
/* 302 */       dropStack.accept(new ItemStack(itemLike));
/*     */     }
/* 304 */     dropArrows.accept(Integer.valueOf((new Random()).nextInt(10, 30)));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void implementFirstTick(ServerLevel serverLevel) {
/* 309 */     super.implementFirstTick(serverLevel);
/* 310 */     m_5496_((SoundEvent)AnnoyingVillagersModSounds.ANGRY_STEVE_SAY_ON_SPAWN
/* 311 */         .get(), 1.0F, 1.0F);
/*     */ 
/*     */     
/* 314 */     if (getLivingEntityPatch() != null) {
/* 315 */       getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.GUARD_BREAK_ATTACK, 0.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 321 */     super.m_8119_();
/* 322 */     if (m_9236_() instanceof ServerLevel) {
/* 323 */       if (getLivingEntityPatch() != null && CombatCommon.canEscape((MobPatch)getLivingEntityPatch())) {
/* 324 */         this.f_21345_.m_25355_(Goal.Flag.MOVE);
/* 325 */         m_21573_().m_26573_();
/*     */         
/* 327 */         LivingEntity target = m_5448_();
/* 328 */         if (target != null) {
/* 329 */           m_21563_().m_24960_((Entity)target, 30.0F, 30.0F);
/*     */         }
/*     */       } else {
/* 332 */         this.f_21345_.m_25374_(Goal.Flag.MOVE);
/*     */       } 
/* 334 */       m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 3, 3));
/* 335 */       m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 3, 3));
/* 336 */       if (!this.neverLeave) {
/*     */         
/* 338 */         int remaining = --this.leaveTicks;
/*     */         
/* 340 */         if (remaining == 40) {
/* 341 */           m_21557_(true);
/* 342 */           ((LivingEntityPatch)Objects.<LivingEntityPatch>requireNonNull(getLivingEntityPatch())).playAnimationSynchronized((AssetAccessor)AVAnimations.TRIED, 0.0F);
/*     */         } 
/* 344 */         if (remaining <= 0) {
/* 345 */           ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_((Component)Component.m_237113_("<Steve> " + String.valueOf(Component.m_237115_("subtitles.angry_steve_retreat"))), false);
/* 346 */           m_146870_();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 353 */     ItemStack legendarySword = new ItemStack((ItemLike)AnnoyingVillagersModItems.LEGENDARY_SWORD.get());
/* 354 */     legendarySword.m_41663_(Enchantments.f_44977_, 5);
/* 355 */     legendarySword.m_41663_(Enchantments.f_44978_, 5);
/* 356 */     legendarySword.m_41663_(Enchantments.f_44983_, 5);
/* 357 */     m_21008_(InteractionHand.MAIN_HAND, legendarySword);
/* 358 */     m_8061_(EquipmentSlot.MAINHAND, legendarySword);
/* 359 */     setMainWeaponItem(legendarySword);
/* 360 */     TeamUtil.addOrJoinTeam((Entity)this, "steve");
/* 361 */     int min = ((Integer)AnnoyingVillagersConfig.ANGRY_STEVE_LEAVE_MIN_TIME.get()).intValue();
/* 362 */     int max = ((Integer)AnnoyingVillagersConfig.ANGRY_STEVE_LEAVE_MAX_TIME.get()).intValue();
/* 363 */     int randomMin = Math.min(min, max);
/* 364 */     int randomMax = Math.max(min, max);
/* 365 */     this.leaveTicks = (randomMin + (new Random()).nextInt(randomMax - randomMin + 1)) * 60 * 20;
/* 366 */     return super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawngroupdata, compoundtag);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 371 */     super.m_142687_(reason);
/* 372 */     if (!(m_9236_()).f_46443_) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (reason == Entity.RemovalReason.KILLED || reason == Entity.RemovalReason.DISCARDED)
/*     */         {
/* 374 */           SteveData.get(serverLevel).releaseIfMatches(serverLevel, m_20148_()); }  }
/*     */        }
/*     */   
/*     */   }
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 379 */     return Mob.m_21552_()
/* 380 */       .m_22268_(Attributes.f_22276_, 250.0D)
/* 381 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 382 */       .m_22268_(Attributes.f_22281_, 10.0D)
/* 383 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 384 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 385 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 386 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 387 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 388 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 389 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 390 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 391 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 392 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\AngrySteveEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */