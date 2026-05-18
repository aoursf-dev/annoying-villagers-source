/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.spawnhandler.AlexData;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import java.util.function.Consumer;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
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
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class AlexEntity extends AVNpc {
/*     */   private JevEntity jevToProtect;
/*  46 */   private int state = 0; private UUID jevUUID; private boolean spawnJev = false;
/*     */   
/*     */   public void setProtectingJev(JevEntity jev) {
/*  49 */     this.jevToProtect = jev;
/*     */   }
/*     */   
/*     */   public void setJevUUID(UUID jevUUID) {
/*  53 */     this.jevUUID = jevUUID;
/*     */   }
/*     */   
/*     */   public AlexEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  57 */     this((EntityType<AlexEntity>)AnnoyingVillagersModEntities.ALEX.get(), level);
/*     */   }
/*     */   
/*     */   public int getState() {
/*  61 */     return this.state;
/*     */   }
/*     */   
/*     */   public AlexEntity(EntityType<AlexEntity> entitytype, Level level) {
/*  65 */     super(entitytype, level);
/*  66 */     m_274367_(2.8F);
/*  67 */     this.f_21364_ = 60;
/*  68 */     m_21557_(false);
/*  69 */     m_6593_((Component)Component.m_237115_(m_6095_().m_20675_()));
/*  70 */     m_20340_(true);
/*  71 */     m_21530_();
/*  72 */     setPlaceBlockToParryChance(0.7D);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  76 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  80 */     super.m_8099_();
/*  81 */     this.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 10, true, false, target -> (this.jevToProtect != null && this.jevToProtect.m_6084_() && target != null && target.m_21214_() == this.jevToProtect)));
/*     */ 
/*     */ 
/*     */     
/*  85 */     CommonGoals.registerGoalForNeutralNpc((PathfinderMob)this);
/*     */   }
/*     */   
/*     */   public void setState(int state) {
/*  89 */     this.state = state;
/*  90 */     if (state == 1 && this.jevToProtect != null && m_9236_() instanceof ServerLevel) {
/*  91 */       this.jevToProtect.m_5496_((SoundEvent)AnnoyingVillagersModSounds.JEV_SAY_WHEN_ALEX_SECOND_PHASE.get(), 1.0F, 1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/*  98 */     super.m_7380_(tag);
/*  99 */     if (this.jevUUID != null) {
/* 100 */       tag.m_128362_("JevUUID", this.jevUUID);
/*     */     }
/* 102 */     tag.m_128405_("State", this.state);
/* 103 */     tag.m_128379_("SpawnJev", this.spawnJev);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 108 */     super.m_7378_(tag);
/* 109 */     if (tag.m_128403_("JevUUID")) {
/* 110 */       this.jevUUID = tag.m_128342_("JevUUID");
/*     */     }
/* 112 */     this.state = tag.m_128451_("State");
/* 113 */     this.spawnJev = tag.m_128471_("SpawnJev");
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundEvent getAttackVoiceSound() {
/* 118 */     return (SoundEvent)AnnoyingVillagersModSounds.ALEX_SAY.get();
/*     */   }
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 122 */     return MobType.f_21640_;
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 130 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 134 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/* 138 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hasEnderPearlCounter() {
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void beforeEnderPearlCounter(@NotNull DamageSource damageSource) {
/* 148 */     if (this.f_19796_.m_188500_() > 0.2D || m_20194_() != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doEnderPearlCounterPattern(@NotNull DamageSource damageSource) {
/* 155 */     doChrisStyleEnderPearlCounter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean afterBurstProtection(@NotNull ServerLevel serverLevel, @NotNull DamageSource source, float finalDamage) {
/* 162 */     if (this.state == 0 && 
/* 163 */       m_21223_() - finalDamage <= 1.0F && 
/* 164 */       !m_21206_().m_150930_(Items.f_42747_)) {
/* 165 */       m_21153_(1.0F);
/* 166 */       return true;
/*     */     } 
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBurstProtectCapRatio() {
/* 173 */     return 0.25F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7472_(@NotNull DamageSource source, int looting, boolean recentlyHit) {
/* 178 */     super.m_7472_(source, looting, recentlyHit);
/* 179 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 180 */       double x = m_20185_();
/* 181 */       double y = m_20186_() + 1.0D;
/* 182 */       double z = m_20189_();
/*     */       
/* 184 */       Consumer<ItemStack> dropStack = stack -> {
/*     */           ItemEntity drop = new ItemEntity((Level)serverLevel, x, y, z, stack);
/*     */           
/*     */           drop.m_32010_(10);
/*     */           serverLevel.m_7967_((Entity)drop);
/*     */         };
/* 190 */       Consumer<Integer> dropArrows = count -> {
/*     */           for (int i = 0; i < count.intValue(); i++)
/*     */             dropStack.accept(new ItemStack((ItemLike)Items.f_42412_)); 
/*     */         };
/* 194 */       List<ItemStack> damagedStacks = new ArrayList<>();
/*     */       
/* 196 */       ItemStack sword = new ItemStack((ItemLike)Items.f_42388_);
/* 197 */       sword.m_41663_(Enchantments.f_44977_, 5);
/* 198 */       sword.m_41663_(Enchantments.f_44981_, 2);
/* 199 */       sword.m_41663_(Enchantments.f_44980_, 2);
/* 200 */       sword.m_41663_(Enchantments.f_44986_, 5);
/* 201 */       damagedStacks.add(sword);
/*     */       
/* 203 */       ItemStack bow = getBowItem();
/* 204 */       bow.m_41663_(Enchantments.f_44989_, 3);
/* 205 */       bow.m_41663_(Enchantments.f_44988_, 3);
/* 206 */       bow.m_41663_(Enchantments.f_44990_, 2);
/* 207 */       damagedStacks.add(bow);
/*     */       
/* 209 */       for (ItemStack stack : damagedStacks) {
/* 210 */         stack.m_41721_(EquipmentDataLoader.getRandomDamage(stack));
/* 211 */         dropStack.accept(stack);
/*     */       } 
/*     */       
/* 214 */       ItemStack[] simpleDrops = { new ItemStack((ItemLike)Items.f_42406_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42405_), new ItemStack((ItemLike)Items.f_42675_), new ItemStack((ItemLike)Items.f_42417_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42416_), new ItemStack((ItemLike)Items.f_42437_), new ItemStack((ItemLike)Items.f_42436_), new ItemStack((ItemLike)Items.f_42503_), new ItemStack((ItemLike)Items.f_42502_) };
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
/* 236 */       for (ItemStack stack : simpleDrops) {
/* 237 */         dropStack.accept(stack);
/*     */       }
/* 239 */       dropArrows.accept(Integer.valueOf((new Random()).nextInt(10, 20))); }
/*     */   
/*     */   }
/*     */   
/*     */   private void spawnJev() {
/* 244 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 245 */       JevEntity jevEntity = new JevEntity((EntityType<JevEntity>)AnnoyingVillagersModEntities.JEV.get(), (Level)serverLevel);
/* 246 */       jevEntity.m_7678_(m_20185_() + (new Random()).nextDouble(1.0D, 10.0D), m_20186_() + (new Random()).nextDouble(1.0D, 10.0D), m_20189_() + (new Random()).nextDouble(1.0D, 10.0D), serverLevel.m_213780_().m_188501_() * 360.0F, 0.0F);
/* 247 */       jevEntity.setFollowTarget(this);
/* 248 */       jevEntity.setFollowTargetUUID(m_20148_());
/* 249 */       jevEntity.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/* 250 */       serverLevel.m_7967_((Entity)jevEntity);
/*     */       
/* 252 */       setJevUUID(jevEntity.m_20148_());
/* 253 */       setProtectingJev(jevEntity); }
/*     */   
/*     */   }
/*     */   
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 258 */     if (mobSpawnType == MobSpawnType.NATURAL || mobSpawnType == MobSpawnType.CHUNK_GENERATION) {
/* 259 */       ServerLevel serverLevel = serverLevelAccessor.m_6018_();
/* 260 */       AlexData alexData = AlexData.get(serverLevel);
/*     */       
/* 262 */       if (!alexData.tryClaim(serverLevel, m_20148_())) {
/* 263 */         m_146870_();
/* 264 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 268 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawngroupdata, compoundtag);
/* 269 */     TeamUtil.addOrJoinTeam((Entity)this, "alex");
/*     */     
/* 271 */     ItemStack sword = new ItemStack((ItemLike)Items.f_42388_);
/* 272 */     sword.m_41663_(Enchantments.f_44977_, 5);
/* 273 */     sword.m_41663_(Enchantments.f_44981_, 2);
/* 274 */     sword.m_41663_(Enchantments.f_44980_, 2);
/* 275 */     sword.m_41663_(Enchantments.f_44986_, 5);
/* 276 */     m_8061_(EquipmentSlot.MAINHAND, sword);
/* 277 */     m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)Items.f_42584_));
/* 278 */     setMainWeaponItem(sword);
/* 279 */     setOffWeaponItem(new ItemStack((ItemLike)Items.f_42584_));
/* 280 */     return returnSpawnGroupData;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 285 */     super.m_8119_();
/* 286 */     if (!(m_9236_()).f_46443_) {
/* 287 */       if (!this.spawnJev) {
/* 288 */         this.spawnJev = true;
/* 289 */         spawnJev();
/*     */       } 
/* 291 */       if (this.jevToProtect == null && this.jevUUID != null) {
/* 292 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.jevUUID);
/* 293 */         if (entity instanceof JevEntity) { JevEntity jev = (JevEntity)entity;
/* 294 */           this.jevToProtect = jev; }
/*     */         else
/* 296 */         { this.jevUUID = null; }
/*     */       
/*     */       } 
/* 299 */       if (this.jevToProtect != null && !this.jevToProtect.m_6084_()) {
/* 300 */         this.jevToProtect = null;
/* 301 */         this.jevUUID = null;
/*     */       } 
/* 303 */       if (this.state == 0 && 
/* 304 */         m_21223_() <= 20.0F && 
/* 305 */         !m_21120_(InteractionHand.OFF_HAND).m_41720_().equals(Items.f_42747_)) {
/* 306 */         m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)Items.f_42747_));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<AlexEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 312 */     ServerLevel serverLevel = level.m_6018_();
/* 313 */     if (AlexData.get(serverLevel).isOccupied(serverLevel)) {
/* 314 */       return false;
/*     */     }
/* 316 */     return PathfinderMob.m_217057_(entityType, (LevelAccessor)level, spawnType, position, random);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 321 */     super.m_142687_(reason);
/* 322 */     if (!(m_9236_()).f_46443_) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (reason == Entity.RemovalReason.KILLED || reason == Entity.RemovalReason.DISCARDED)
/*     */         {
/* 324 */           AlexData.get(serverLevel).releaseIfMatches(serverLevel, m_20148_()); }  }
/*     */        }
/*     */   
/*     */   }
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 329 */     return Mob.m_21552_()
/* 330 */       .m_22268_(Attributes.f_22276_, 50.0D)
/* 331 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 332 */       .m_22268_(Attributes.f_22281_, 0.0D)
/* 333 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 334 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 335 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 336 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 337 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 2.0D)
/* 338 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 5.0D)
/* 339 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 340 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 50.0D)
/* 341 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 30.0D)
/* 342 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\AlexEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */