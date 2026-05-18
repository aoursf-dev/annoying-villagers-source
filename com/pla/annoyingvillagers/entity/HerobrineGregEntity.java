/*      */ package com.pla.annoyingvillagers.entity;
/*      */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*      */ import com.pla.annoyingvillagers.blockentity.CryingObsidianBlockEntity;
/*      */ import com.pla.annoyingvillagers.blockentity.ObsidianBlockEntity;
/*      */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianBlockEntity;
/*      */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*      */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*      */ import com.pla.annoyingvillagers.network.ClientboundHerobrinePortalFx;
/*      */ import com.pla.annoyingvillagers.spawnhandler.GregData;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.Objects;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import javax.annotation.Nullable;
/*      */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.nbt.CompoundTag;
/*      */ import net.minecraft.network.chat.Component;
/*      */ import net.minecraft.network.syncher.EntityDataAccessor;
/*      */ import net.minecraft.network.syncher.EntityDataSerializers;
/*      */ import net.minecraft.network.syncher.SynchedEntityData;
/*      */ import net.minecraft.resources.ResourceLocation;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.sounds.SoundEvent;
/*      */ import net.minecraft.tags.FluidTags;
/*      */ import net.minecraft.util.Mth;
/*      */ import net.minecraft.util.RandomSource;
/*      */ import net.minecraft.world.DifficultyInstance;
/*      */ import net.minecraft.world.damagesource.DamageSource;
/*      */ import net.minecraft.world.effect.MobEffect;
/*      */ import net.minecraft.world.effect.MobEffectInstance;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.entity.EntityType;
/*      */ import net.minecraft.world.entity.EquipmentSlot;
/*      */ import net.minecraft.world.entity.Mob;
/*      */ import net.minecraft.world.entity.MobSpawnType;
/*      */ import net.minecraft.world.entity.MobType;
/*      */ import net.minecraft.world.entity.PathfinderMob;
/*      */ import net.minecraft.world.entity.SpawnGroupData;
/*      */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*      */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*      */ import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
/*      */ import net.minecraft.world.entity.ai.goal.Goal;
/*      */ import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
/*      */ import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
/*      */ import net.minecraft.world.entity.ai.navigation.PathNavigation;
/*      */ import net.minecraft.world.entity.monster.Monster;
/*      */ import net.minecraft.world.item.Item;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.item.Items;
/*      */ import net.minecraft.world.level.BlockGetter;
/*      */ import net.minecraft.world.level.ItemLike;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.level.ServerLevelAccessor;
/*      */ import net.minecraft.world.level.block.Block;
/*      */ import net.minecraft.world.level.block.LiquidBlock;
/*      */ import net.minecraft.world.level.block.entity.BlockEntity;
/*      */ import net.minecraft.world.level.block.state.BlockState;
/*      */ import net.minecraft.world.level.levelgen.Heightmap;
/*      */ import net.minecraft.world.level.material.Fluid;
/*      */ import net.minecraft.world.level.material.FluidState;
/*      */ import net.minecraft.world.level.pathfinder.BlockPathTypes;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import net.minecraft.world.phys.shapes.CollisionContext;
/*      */ import net.minecraftforge.network.PacketDistributor;
/*      */ import net.minecraftforge.registries.ForgeRegistries;
/*      */ import net.shelmarow.combat_evolution.effect.CEMobEffects;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import yesman.epicfight.api.asset.AssetAccessor;
/*      */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*      */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*      */ 
/*      */ public class HerobrineGregEntity extends Monster {
/*   81 */   private static final EntityDataAccessor<Boolean> WHITE_EYE = SynchedEntityData.m_135353_(HerobrineGregEntity.class, EntityDataSerializers.f_135035_);
/*      */   
/*   83 */   private static final EntityDataAccessor<Boolean> USE_HEROBRINE_TEXTURE = SynchedEntityData.m_135353_(HerobrineGregEntity.class, EntityDataSerializers.f_135035_);
/*      */   private boolean summoning = false;
/*   85 */   private int summonTiming = -1;
/*   86 */   private int escapeTiming = -1;
/*   87 */   private int summonTimestamp = -1;
/*      */   
/*      */   private boolean combatMode = false;
/*      */   
/*      */   private int recallTime;
/*      */   
/*      */   private Entity firstSummonedHerobrine;
/*      */   private Entity secondSummonedHerobrine;
/*      */   private Entity thirdSummonedHerobrine;
/*      */   private UUID firstSummonedHerobrineUUID;
/*      */   private UUID secondSummonedHerobrineUUID;
/*      */   private UUID thirdSummonedHerobrineUUID;
/*   99 */   private BlockPos lastFeetPos = null;
/*      */   
/*      */   private String chatName;
/*  102 */   private final List<Item> listWeapons = new ArrayList<>(Arrays.asList(new Item[] { Items.f_42388_, Items.f_42391_, (Item)AnnoyingVillagersModItems.DIAMOND_ATTRACTOR_SWORD
/*      */ 
/*      */           
/*  105 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_BLASTER_SWORD
/*  106 */           .get(), (Item)AnnoyingVillagersModItems.HOOKED_DIAMOND_SWORD
/*  107 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_WARBLADE
/*  108 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_FALCHION
/*  109 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_GREAT_FALCHION
/*  110 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_SABRE
/*  111 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_LONGSWORD
/*  112 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_CHIPPED_LONGSWORD
/*  113 */           .get(), (Item)AnnoyingVillagersModItems.PALADIN_SWORD
/*  114 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_GREATAXE
/*  115 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_ARMBLADE
/*  116 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_SICKLE
/*  117 */           .get(), (Item)AnnoyingVillagersModItems.DOUBLE_DIAMOND_GLAIVE
/*  118 */           .get(), (Item)AnnoyingVillagersModItems.DIAMOND_MOON_BLADE
/*  119 */           .get() }));
/*      */ 
/*      */   
/*      */   @Nullable
/*      */   public LivingEntityPatch<?> getLivingEntityPatch() {
/*  124 */     return (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*      */   }
/*      */   
/*      */   public void setWhiteEye(boolean whiteEye) {
/*  128 */     this.f_19804_.m_135381_(WHITE_EYE, Boolean.valueOf(whiteEye));
/*      */   }
/*      */   
/*      */   public boolean isWhiteEye() {
/*  132 */     return ((Boolean)this.f_19804_.m_135370_(WHITE_EYE)).booleanValue();
/*      */   }
/*      */   
/*      */   public void setUseHerobrineTexture(boolean useHerobrineTexture) {
/*  136 */     this.f_19804_.m_135381_(USE_HEROBRINE_TEXTURE, Boolean.valueOf(useHerobrineTexture));
/*      */   }
/*      */   
/*      */   public int getEscapeTiming() {
/*  140 */     return this.escapeTiming;
/*      */   }
/*      */   
/*      */   public void setEscapeTiming(int escapeTiming) {
/*  144 */     this.escapeTiming = escapeTiming;
/*      */   }
/*      */   public boolean isUseHerobrineTexture() {
/*  147 */     return ((Boolean)this.f_19804_.m_135370_(USE_HEROBRINE_TEXTURE)).booleanValue();
/*      */   }
/*      */   
/*      */   protected void m_8097_() {
/*  151 */     super.m_8097_();
/*  152 */     this.f_19804_.m_135372_(WHITE_EYE, Boolean.valueOf(false));
/*  153 */     this.f_19804_.m_135372_(USE_HEROBRINE_TEXTURE, Boolean.valueOf(false));
/*      */   }
/*      */   
/*      */   public boolean isSummoning() {
/*  157 */     return this.summoning;
/*      */   }
/*      */   
/*      */   public void setSummoning(boolean summoning) {
/*  161 */     this.summoning = summoning;
/*      */   }
/*      */   
/*      */   public int getSummonTimestamp() {
/*  165 */     return this.summonTimestamp;
/*      */   }
/*      */   
/*      */   public HerobrineGregEntity(PlayMessages.SpawnEntity spawnentity, Level level) {
/*  169 */     this((EntityType<HerobrineGregEntity>)AnnoyingVillagersModEntities.HEROBRINE_GREG.get(), level);
/*      */   }
/*      */   
/*      */   public String getChatName() {
/*  173 */     return this.chatName;
/*      */   }
/*      */   
/*      */   public void setChatName(String chatName) {
/*  177 */     this.chatName = chatName;
/*      */   }
/*      */   
/*      */   public HerobrineGregEntity(EntityType<HerobrineGregEntity> entitytype, Level level) {
/*  181 */     super(entitytype, level);
/*  182 */     m_274367_(2.5F);
/*  183 */     this.f_21364_ = 50;
/*  184 */     m_21557_(false);
/*  185 */     m_21530_();
/*  186 */     m_6593_((Component)Component.m_237113_("Greg"));
/*  187 */     setChatName(m_5446_().getString());
/*  188 */     m_20340_(true);
/*      */     
/*  190 */     int min = ((Integer)AnnoyingVillagersConfig.HEROBRINE_RECALL_MIN_TIME.get()).intValue();
/*  191 */     int max = ((Integer)AnnoyingVillagersConfig.HEROBRINE_RECALL_MAX_TIME.get()).intValue();
/*  192 */     int randomMin = Math.min(min, max);
/*  193 */     int randomMax = Math.max(min, max);
/*  194 */     this.recallTime = (randomMin + (new Random()).nextInt(randomMax - randomMin + 1)) * 60 * 20;
/*      */     
/*  196 */     m_21441_(BlockPathTypes.WATER, 0.0F);
/*  197 */     m_21441_(BlockPathTypes.WATER_BORDER, 0.0F);
/*  198 */     m_21441_(BlockPathTypes.LAVA, 0.0F);
/*  199 */     m_21441_(BlockPathTypes.DANGER_FIRE, 0.0F);
/*  200 */     m_21441_(BlockPathTypes.DAMAGE_FIRE, 0.0F);
/*      */   }
/*      */   @NotNull
/*      */   public Packet<ClientGamePacketListener> m_5654_() {
/*  204 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*      */   }
/*      */   
/*      */   protected void m_8099_() {
/*  208 */     super.m_8099_();
/*  209 */     this.f_21345_.m_25352_(1, new Goal()
/*      */         {
/*      */           public boolean m_8036_() {
/*  212 */             return (HerobrineGregEntity.this.firstSummonedHerobrine != null && HerobrineGregEntity.this.firstSummonedHerobrine.m_6084_() && HerobrineGregEntity.this.m_20270_(HerobrineGregEntity.this.firstSummonedHerobrine) > 18.0F);
/*      */           }
/*      */ 
/*      */           
/*      */           public void m_8037_() {
/*  217 */             if (HerobrineGregEntity.this.firstSummonedHerobrine != null && HerobrineGregEntity.this.firstSummonedHerobrine.m_6084_()) {
/*  218 */               HerobrineGregEntity.this.m_21573_().m_5624_(HerobrineGregEntity.this.firstSummonedHerobrine, 2.0D);
/*  219 */               HerobrineGregEntity.this.m_21563_().m_24960_(HerobrineGregEntity.this.firstSummonedHerobrine, 30.0F, 30.0F);
/*  220 */               if (HerobrineGregEntity.this.m_20280_(HerobrineGregEntity.this.firstSummonedHerobrine) > 20.0D) {
/*  221 */                 if (HerobrineGregEntity.this.m_21573_().m_26571_()) {
/*  222 */                   HerobrineGregEntity.this.m_21573_().m_5624_(HerobrineGregEntity.this.firstSummonedHerobrine, 2.0D);
/*      */                 }
/*      */               } else {
/*  225 */                 HerobrineGregEntity.this.m_21573_().m_26573_();
/*      */               } 
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean m_8045_() {
/*  232 */             return (HerobrineGregEntity.this.firstSummonedHerobrine != null && HerobrineGregEntity.this.firstSummonedHerobrine.m_6084_() && HerobrineGregEntity.this.m_20270_(HerobrineGregEntity.this.firstSummonedHerobrine) > 50.0D);
/*      */           }
/*      */         });
/*  235 */     this.f_21345_.m_25352_(1, new Goal()
/*      */         {
/*      */           public boolean m_8036_() {
/*  238 */             return (HerobrineGregEntity.this.secondSummonedHerobrine != null && HerobrineGregEntity.this.secondSummonedHerobrine.m_6084_() && HerobrineGregEntity.this.m_20270_(HerobrineGregEntity.this.secondSummonedHerobrine) > 18.0F);
/*      */           }
/*      */ 
/*      */           
/*      */           public void m_8037_() {
/*  243 */             if (HerobrineGregEntity.this.secondSummonedHerobrine != null && HerobrineGregEntity.this.secondSummonedHerobrine.m_6084_()) {
/*  244 */               HerobrineGregEntity.this.m_21573_().m_5624_(HerobrineGregEntity.this.secondSummonedHerobrine, 2.0D);
/*  245 */               HerobrineGregEntity.this.m_21563_().m_24960_(HerobrineGregEntity.this.secondSummonedHerobrine, 30.0F, 30.0F);
/*  246 */               if (HerobrineGregEntity.this.m_20280_(HerobrineGregEntity.this.secondSummonedHerobrine) > 20.0D) {
/*  247 */                 if (HerobrineGregEntity.this.m_21573_().m_26571_()) {
/*  248 */                   HerobrineGregEntity.this.m_21573_().m_5624_(HerobrineGregEntity.this.secondSummonedHerobrine, 2.0D);
/*      */                 }
/*      */               } else {
/*  251 */                 HerobrineGregEntity.this.m_21573_().m_26573_();
/*      */               } 
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean m_8045_() {
/*  258 */             return (HerobrineGregEntity.this.secondSummonedHerobrine != null && HerobrineGregEntity.this.secondSummonedHerobrine.m_6084_() && HerobrineGregEntity.this.m_20270_(HerobrineGregEntity.this.secondSummonedHerobrine) > 50.0D);
/*      */           }
/*      */         });
/*  261 */     this.f_21345_.m_25352_(1, new Goal()
/*      */         {
/*      */           public boolean m_8036_() {
/*  264 */             return (HerobrineGregEntity.this.thirdSummonedHerobrine != null && HerobrineGregEntity.this.thirdSummonedHerobrine.m_6084_() && HerobrineGregEntity.this.m_20270_(HerobrineGregEntity.this.thirdSummonedHerobrine) > 18.0F);
/*      */           }
/*      */ 
/*      */           
/*      */           public void m_8037_() {
/*  269 */             if (HerobrineGregEntity.this.thirdSummonedHerobrine != null && HerobrineGregEntity.this.thirdSummonedHerobrine.m_6084_()) {
/*  270 */               HerobrineGregEntity.this.m_21573_().m_5624_(HerobrineGregEntity.this.thirdSummonedHerobrine, 2.0D);
/*  271 */               HerobrineGregEntity.this.m_21563_().m_24960_(HerobrineGregEntity.this.thirdSummonedHerobrine, 30.0F, 30.0F);
/*  272 */               if (HerobrineGregEntity.this.m_20280_(HerobrineGregEntity.this.thirdSummonedHerobrine) > 20.0D) {
/*  273 */                 if (HerobrineGregEntity.this.m_21573_().m_26571_()) {
/*  274 */                   HerobrineGregEntity.this.m_21573_().m_5624_(HerobrineGregEntity.this.thirdSummonedHerobrine, 2.0D);
/*      */                 }
/*      */               } else {
/*  277 */                 HerobrineGregEntity.this.m_21573_().m_26573_();
/*      */               } 
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean m_8045_() {
/*  284 */             return (HerobrineGregEntity.this.thirdSummonedHerobrine != null && HerobrineGregEntity.this.thirdSummonedHerobrine.m_6084_() && HerobrineGregEntity.this.m_20270_(HerobrineGregEntity.this.thirdSummonedHerobrine) > 50.0D);
/*      */           }
/*      */         });
/*  287 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, VillagerScoutEntity.class, 12.0F, 1.2D, 1.8D));
/*  288 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, VillagerScoutCaptainEntity.class, 12.0F, 1.2D, 1.8D));
/*  289 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, BlueVillagerGeneralEntity.class, 12.0F, 1.2D, 1.8D));
/*  290 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, GreenVillagerGeneralEntity.class, 12.0F, 1.2D, 1.8D));
/*  291 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, RedVillagerGeneralEntity.class, 12.0F, 1.2D, 1.8D));
/*  292 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, PurpleVillagerGeneralEntity.class, 12.0F, 1.2D, 1.8D));
/*      */     
/*  294 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, PlayerNpcEntity.class, 12.0F, 1.2D, 1.8D));
/*  295 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, Player.class, 12.0F, 1.2D, 1.8D));
/*  296 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, SteveEntity.class, 24.0F, 1.2D, 1.8D));
/*  297 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, AlexEntity.class, 12.0F, 1.2D, 1.8D));
/*  298 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, JevEntity.class, 12.0F, 1.2D, 1.8D));
/*  299 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, ChrisEntity.class, 12.0F, 1.2D, 1.8D));
/*  300 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, BlueDemonEntity.class, 12.0F, 1.2D, 1.8D));
/*  301 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, BbqEntity.class, 12.0F, 1.2D, 1.8D));
/*      */     
/*  303 */     this.f_21345_.m_25352_(3, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0D));
/*  304 */     this.f_21345_.m_25352_(4, (Goal)new RandomLookAroundGoal((Mob)this));
/*  305 */     this.f_21345_.m_25352_(5, (Goal)new FloatGoal((Mob)this));
/*      */   }
/*      */   @NotNull
/*      */   public MobType m_6336_() {
/*  309 */     return MobType.f_21640_;
/*      */   }
/*      */   
/*      */   public double m_6049_() {
/*  313 */     return -0.35D;
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   protected PathNavigation m_6037_(@NotNull Level level) {
/*  318 */     return (PathNavigation)new HerobrineMob.AnyFluidPathNavigation((Mob)this, level);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_20069_() {
/*  323 */     FluidState fs = m_9236_().m_6425_(m_20183_());
/*  324 */     if (!fs.m_76178_() && m_203441_(fs)) return false; 
/*  325 */     return super.m_20069_();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_203441_(FluidState state) {
/*  330 */     return !state.m_76178_();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_6063_() {
/*  335 */     return false;
/*      */   }
/*      */   
/*      */   private void assignProtect(Entity entity, UUID protectUUID, EliteHerobrineKnockedEntity protectEntity) {
/*  339 */     if (entity != null && entity.m_6084_()) {
/*  340 */       if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/*  341 */         herobrineMob.setProtectUUID(protectUUID);
/*  342 */         herobrineMob.setProtectEntity(protectEntity); }
/*  343 */       else if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/*  344 */         lowShadowHerobrineCloneEntity.setProtectUUID(protectUUID);
/*  345 */         lowShadowHerobrineCloneEntity.setProtectEntity(protectEntity); }
/*      */     
/*      */     }
/*      */   }
/*      */   
/*      */   public void requestProtect(UUID protectUUID, EliteHerobrineKnockedEntity protectEntity) {
/*  351 */     assignProtect(this.firstSummonedHerobrine, protectUUID, protectEntity);
/*  352 */     assignProtect(this.secondSummonedHerobrine, protectUUID, protectEntity);
/*  353 */     assignProtect(this.thirdSummonedHerobrine, protectUUID, protectEntity);
/*      */   }
/*      */   
/*      */   private void floatOnAnyFluid() {
/*  357 */     BlockPos pos = m_20183_();
/*  358 */     FluidState fluidState = m_9236_().m_6425_(pos);
/*  359 */     if (fluidState.m_76178_()) {
/*      */       return;
/*      */     }
/*      */     
/*  363 */     CollisionContext collisionContext = CollisionContext.m_82750_((Entity)this);
/*  364 */     Fluid typeHere = fluidState.m_76152_();
/*  365 */     FluidState above = m_9236_().m_6425_(pos.m_7494_());
/*      */     
/*  367 */     if (collisionContext.m_6513_(LiquidBlock.f_54690_, pos, true) && above.m_76152_() != typeHere) {
/*  368 */       m_6853_(true);
/*      */       
/*  370 */       double surfaceY = (pos.m_123342_() + fluidState.m_76155_((BlockGetter)m_9236_(), pos));
/*  371 */       double bottomY = (m_20191_()).f_82289_;
/*  372 */       double diff = surfaceY - bottomY - 0.001D;
/*      */       
/*  374 */       if (diff > 0.0D) {
/*  375 */         Vec3 vel = m_20184_();
/*  376 */         m_20334_(vel.f_82479_, Math.max(vel.f_82480_, Math.min(0.2D, diff * 0.2D)), vel.f_82481_);
/*      */       } 
/*      */     } else {
/*  379 */       m_20256_(m_20184_().m_82490_(0.5D).m_82520_(0.0D, 0.05D, 0.0D));
/*      */     } 
/*      */     
/*  382 */     this.f_19789_ = 0.0F;
/*      */   }
/*      */   
/*      */   private void placeObsidianBlockWhenInWater(Block block) {
/*  386 */     BlockPos feet = m_20097_();
/*  387 */     if (this.lastFeetPos == null) this.lastFeetPos = feet; 
/*  388 */     if (!feet.equals(this.lastFeetPos)) {
/*  389 */       if (!m_9236_().m_8055_(this.lastFeetPos).m_60713_(block)) {
/*  390 */         FluidState fluidState = m_9236_().m_6425_(this.lastFeetPos);
/*  391 */         if (!fluidState.m_76178_()) {
/*  392 */           int replace = fluidState.m_205070_(FluidTags.f_13131_) ? 1 : (fluidState.m_205070_(FluidTags.f_13132_) ? 2 : 0);
/*  393 */           BlockState state = (BlockState)block.m_49966_().m_61124_((Property)HerobrineObsidianBlock.REPLACE_BY_LIQUID, Integer.valueOf(replace));
/*  394 */           m_9236_().m_46597_(this.lastFeetPos, state);
/*      */ 
/*      */ 
/*      */           
/*  398 */           BlockEntity blockEntity = m_9236_().m_7702_(this.lastFeetPos);
/*  399 */           if (blockEntity instanceof ObsidianBlockEntity) { ObsidianBlockEntity obsidianBlockEntity = (ObsidianBlockEntity)blockEntity;
/*  400 */             obsidianBlockEntity.setOwner(m_20148_());
/*  401 */             obsidianBlockEntity.m_6596_();
/*  402 */             m_9236_().m_7260_(this.lastFeetPos, state, state, 3); }
/*      */           
/*  404 */           if (blockEntity instanceof ShadowObsidianBlockEntity) { ShadowObsidianBlockEntity shadowObsidianBlockEntity = (ShadowObsidianBlockEntity)blockEntity;
/*  405 */             shadowObsidianBlockEntity.setOwner(m_20148_());
/*  406 */             shadowObsidianBlockEntity.m_6596_();
/*  407 */             m_9236_().m_7260_(this.lastFeetPos, state, state, 3); }
/*      */           
/*  409 */           if (blockEntity instanceof CryingObsidianBlockEntity) { CryingObsidianBlockEntity cryingObsidianBlockEntity = (CryingObsidianBlockEntity)blockEntity;
/*  410 */             cryingObsidianBlockEntity.setOwner(m_20148_());
/*  411 */             cryingObsidianBlockEntity.m_6596_();
/*  412 */             m_9236_().m_7260_(this.lastFeetPos, state, state, 3); }
/*      */         
/*      */         } 
/*      */       } 
/*  416 */       this.lastFeetPos = feet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void m_8119_() {
/*  423 */     super.m_8119_();
/*  424 */     floatOnAnyFluid();
/*  425 */     m_20101_();
/*  426 */     if (!(m_9236_()).f_46443_) {
/*  427 */       placeObsidianBlockWhenInWater((Block)AnnoyingVillagersModBlocks.CRYING_OBSIDIAN_BLOCK.get());
/*  428 */       if (!isDay(m_9236_())) {
/*  429 */         if (!isWhiteEye()) {
/*  430 */           setWhiteEye(true);
/*      */         }
/*  432 */         if (!m_6844_(EquipmentSlot.CHEST).m_41720_().equals(AnnoyingVillagersModItems.BROKEN_DIAMOND_CHESTPLATE.get())) {
/*  433 */           m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_CHESTPLATE.get()));
/*      */         }
/*      */       } else {
/*  436 */         if (isWhiteEye() && this.summonTiming == -1) {
/*  437 */           setWhiteEye(false);
/*      */         }
/*  439 */         if (!this.combatMode && m_6844_(EquipmentSlot.CHEST).m_41720_().equals(AnnoyingVillagersModItems.BROKEN_DIAMOND_CHESTPLATE.get())) {
/*  440 */           m_8061_(EquipmentSlot.CHEST, ItemStack.f_41583_);
/*      */         }
/*      */       } 
/*      */       
/*  444 */       if (m_9236_().m_46468_() % 24000L == 13001L && this.summonTimestamp == -1) {
/*  445 */         if ((new Random()).nextBoolean()) {
/*  446 */           ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_((Component)Component.m_237113_("<" + getChatName() + "> " + 
/*  447 */                 Component.m_237115_("subtitles.herobrine_prepare_for_fight").getString()), false);
/*  448 */           this.summonTimestamp = (new Random()).nextInt(13100, 22200);
/*  449 */           AnnoyingVillagers.LOGGER.info("[AV MOD DEBUG]: Greg will summon elites at {}", Integer.valueOf(this.summonTimestamp));
/*      */         } else {
/*  451 */           ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_((Component)Component.m_237113_("<" + getChatName() + "> " + 
/*  452 */                 Component.m_237115_("subtitles.herobrine_no_fight").getString()), false);
/*      */         } 
/*      */       }
/*      */       
/*  456 */       if (m_9236_().m_46468_() % 24000L == this.summonTimestamp) {
/*  457 */         this.summonTimestamp = -2;
/*  458 */         this.combatMode = true;
/*  459 */         m_21557_(true);
/*  460 */         this.summoning = true;
/*  461 */         this.summonTiming = 20;
/*  462 */         m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 120, 3, false, false));
/*  463 */         m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 120, 3, false, false));
/*      */       } 
/*      */       
/*  466 */       if (m_21223_() <= 2.0F && this.summonTiming == -1) {
/*  467 */         if (!isDay(m_9236_())) {
/*  468 */           m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_CHESTPLATE.get()));
/*      */         }
/*  470 */         setWhiteEye(true);
/*  471 */         m_21557_(true);
/*  472 */         this.summoning = true;
/*  473 */         this.summonTiming = 20;
/*  474 */         m_21153_(1.0F);
/*  475 */         m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 120, 3, false, false));
/*  476 */         m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 120, 3, false, false));
/*      */       } 
/*      */       
/*  479 */       if (this.summonTiming > 0) {
/*  480 */         this.summonTiming--;
/*      */       }
/*  482 */       if (this.summonTiming == 10) {
/*  483 */         m_5496_((SoundEvent)AnnoyingVillagersModSounds.PORTAL_SUMMON.get(), 1.0F, 1.0F);
/*  484 */         ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_((Component)Component.m_237113_("<" + getChatName() + "> " + 
/*  485 */               Component.m_237115_("subtitles.herobrine_summon").getString()), false);
/*      */       } 
/*  487 */       if (this.summonTiming == 1) {
/*  488 */         if (this.combatMode) {
/*  489 */           summonHerobrines();
/*      */         } else {
/*  491 */           summonHerobrinesAndEscape();
/*      */         } 
/*      */       }
/*      */       
/*  495 */       if (this.escapeTiming > 0) {
/*  496 */         this.escapeTiming--;
/*      */       }
/*  498 */       if (this.escapeTiming == 60 && this.combatMode) {
/*  499 */         m_216990_((SoundEvent)AnnoyingVillagersModSounds.PORTAL_NATURAL.get());
/*  500 */         if (getLivingEntityPatch() != null) {
/*  501 */           getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.PORTAL_SUMMON, 0.0F);
/*      */         }
/*  503 */         AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY
/*  504 */             .with(() -> this), new ClientboundHerobrinePortalFx(
/*  505 */               m_20097_().m_252807_().m_82520_(0.0D, 0.5D, 0.0D)));
/*      */       } 
/*      */       
/*  508 */       if (this.escapeTiming == 40) {
/*  509 */         Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  510 */           HerobrinePortalUtil.sinkIntoGround(serverLevel, (LivingEntity)this, 0.06D); }
/*      */       
/*      */       } 
/*  513 */       if (this.escapeTiming == 1) {
/*  514 */         m_9236_().m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + getChatName() + "> " + 
/*  515 */               Component.m_237115_("subtitles.herobrine_will_be_back").getString()), false);
/*  516 */         Entity entity = this.firstSummonedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/*  517 */           lowShadowHerobrineCloneEntity.setAutoKill(true);
/*  518 */           lowShadowHerobrineCloneEntity.m_6074_(); }
/*      */         
/*  520 */         entity = this.secondSummonedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/*  521 */           lowShadowHerobrineCloneEntity.setAutoKill(true);
/*  522 */           lowShadowHerobrineCloneEntity.m_6074_(); }
/*      */         
/*  524 */         entity = this.thirdSummonedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/*  525 */           lowShadowHerobrineCloneEntity.setAutoKill(true);
/*  526 */           lowShadowHerobrineCloneEntity.m_6074_(); }
/*      */         
/*  528 */         m_146870_();
/*      */       } 
/*      */       
/*  531 */       if (this.firstSummonedHerobrine == null && this.firstSummonedHerobrineUUID != null) {
/*  532 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.firstSummonedHerobrineUUID);
/*  533 */         if (entity instanceof HerobrineMob || entity instanceof LowShadowHerobrineCloneEntity) {
/*  534 */           this.firstSummonedHerobrine = entity;
/*      */         } else {
/*  536 */           this.firstSummonedHerobrineUUID = null;
/*      */         } 
/*      */       } 
/*  539 */       if (this.firstSummonedHerobrine != null && !this.firstSummonedHerobrine.m_6084_())
/*      */       {
/*  541 */         this.firstSummonedHerobrineUUID = null;
/*      */       }
/*      */       
/*  544 */       if (this.secondSummonedHerobrine == null && this.secondSummonedHerobrineUUID != null) {
/*  545 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.secondSummonedHerobrineUUID);
/*  546 */         if (entity instanceof HerobrineMob || entity instanceof LowShadowHerobrineCloneEntity) {
/*  547 */           this.secondSummonedHerobrine = entity;
/*      */         } else {
/*  549 */           this.secondSummonedHerobrineUUID = null;
/*      */         } 
/*      */       } 
/*  552 */       if (this.secondSummonedHerobrine != null && !this.secondSummonedHerobrine.m_6084_())
/*      */       {
/*  554 */         this.secondSummonedHerobrineUUID = null;
/*      */       }
/*      */       
/*  557 */       if (this.thirdSummonedHerobrine == null && this.thirdSummonedHerobrineUUID != null) {
/*  558 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.thirdSummonedHerobrineUUID);
/*  559 */         if (entity instanceof HerobrineMob || entity instanceof LowShadowHerobrineCloneEntity) {
/*  560 */           this.thirdSummonedHerobrine = entity;
/*      */         } else {
/*  562 */           this.thirdSummonedHerobrineUUID = null;
/*      */         } 
/*      */       } 
/*  565 */       if (this.thirdSummonedHerobrine != null && !this.thirdSummonedHerobrine.m_6084_())
/*      */       {
/*  567 */         this.thirdSummonedHerobrineUUID = null;
/*      */       }
/*      */       
/*  570 */       if (this.combatMode && this.escapeTiming == -1 && this.summonTiming == -2 && this.firstSummonedHerobrineUUID == null && this.secondSummonedHerobrineUUID == null && this.thirdSummonedHerobrineUUID == null) {
/*      */ 
/*      */ 
/*      */         
/*  574 */         this.escapeTiming = 80;
/*  575 */         m_21557_(true);
/*      */       } 
/*      */       
/*  578 */       if (this.combatMode && this.escapeTiming == -1 && this.recallTime >= 0) {
/*  579 */         this.recallTime--;
/*  580 */         if (this.recallTime == 20) {
/*  581 */           m_21557_(true);
/*      */         }
/*  583 */         if (this.recallTime <= 0) {
/*  584 */           this.escapeTiming = 61;
/*      */         }
/*      */       } 
/*      */       
/*  588 */       if (this.combatMode) {
/*  589 */         m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 1, 3, false, false));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void summonHerobrine(String herobrineMobId, double spawnX, double spawnY, double spawnZ, double summonLookX, double summonLookZ, boolean renderPortal) {
/*  596 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel levelaccessor = (ServerLevel)level;
/*  597 */       String[] parts = herobrineMobId.split(":");
/*  598 */       ResourceLocation mobResourceLocation = ResourceLocation.fromNamespaceAndPath(parts[0], parts[1]);
/*  599 */       EntityType<?> type = (EntityType)ForgeRegistries.ENTITY_TYPES.getValue(mobResourceLocation);
/*  600 */       if (type != null) { Entity entity = type.m_20615_(m_9236_()); if (entity instanceof Mob) { Mob herobrine = (Mob)entity;
/*  601 */           if (herobrine instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)herobrine;
/*  602 */             herobrineMob.setGregUUID(m_20148_());
/*  603 */             herobrineMob.setRenderPortal(renderPortal);
/*  604 */             herobrineMob.setRecallTicks(this.recallTime); }
/*  605 */           else if (herobrine instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)herobrine;
/*  606 */             lowHerobrineCloneEntity.setSummoned(true);
/*  607 */             equipGearForLowHerobrineClone((Entity)lowHerobrineCloneEntity); }
/*  608 */           else if (herobrine instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)herobrine;
/*  609 */             if (renderPortal) {
/*  610 */               AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY
/*  611 */                   .with(() -> this), new ClientboundHerobrinePortalFx(new Vec3(spawnX, spawnY, spawnZ)));
/*      */             }
/*      */             else {
/*      */               
/*  615 */               equipGearForLowHerobrineClone((Entity)lowShadowHerobrineCloneEntity);
/*      */             } 
/*  617 */             lowShadowHerobrineCloneEntity.setSummoned(true); }
/*      */ 
/*      */           
/*  620 */           herobrine.m_7678_(spawnX, spawnY, spawnZ, m_146908_(), m_146909_());
/*  621 */           herobrine.m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(summonLookX, spawnY, summonLookZ));
/*  622 */           herobrine.m_6518_((ServerLevelAccessor)levelaccessor, levelaccessor.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, null, null);
/*  623 */           levelaccessor.m_7967_((Entity)herobrine);
/*      */           
/*  625 */           if (this.combatMode) {
/*  626 */             if (this.firstSummonedHerobrineUUID == null) {
/*  627 */               this.firstSummonedHerobrineUUID = herobrine.m_20148_();
/*  628 */               this.firstSummonedHerobrine = (Entity)herobrine;
/*  629 */             } else if (this.secondSummonedHerobrineUUID == null) {
/*  630 */               this.secondSummonedHerobrineUUID = herobrine.m_20148_();
/*  631 */               this.secondSummonedHerobrine = (Entity)herobrine;
/*      */             } else {
/*  633 */               this.thirdSummonedHerobrineUUID = herobrine.m_20148_();
/*  634 */               this.thirdSummonedHerobrine = (Entity)herobrine;
/*      */             } 
/*      */           } }
/*      */          }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   private void spawnHerobrineOffset(String id, double forwardDist, double lateralDist, double baseY, double fx, double fz, double lx, double lz) {
/*  644 */     double spawnX = m_20185_() + fx * forwardDist + lx * lateralDist;
/*  645 */     double spawnZ = m_20189_() + fz * forwardDist + lz * lateralDist;
/*      */     
/*  647 */     double lookX = spawnX + fx * 10.0D;
/*  648 */     double lookZ = spawnZ + fz * 10.0D;
/*      */     
/*  650 */     summonHerobrine(id, spawnX, baseY, spawnZ, lookX, lookZ, false);
/*      */   }
/*      */   private void spawnRandomHerobrinesInRadius(String id, int count) {
/*      */     ServerLevel sl;
/*  654 */     Level level = m_9236_(); if (level instanceof ServerLevel) { sl = (ServerLevel)level; }
/*      */     else { return; }
/*  656 */      int cx = Mth.m_14107_(m_20185_());
/*  657 */     int cz = Mth.m_14107_(m_20189_());
/*      */     
/*  659 */     List<BlockPos> candidates = new ArrayList<>();
/*  660 */     int r2 = 400;
/*  661 */     for (int dx = -20; dx <= 20; dx++) {
/*  662 */       for (int dz = -20; dz <= 20; dz++) {
/*  663 */         if ((dx != 0 || dz != 0) && 
/*  664 */           dx * dx + dz * dz <= r2) {
/*  665 */           int x = cx + dx;
/*  666 */           int z = cz + dz;
/*      */           
/*  668 */           int y = sl.m_6924_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
/*  669 */           candidates.add(new BlockPos(x, y, z));
/*      */         } 
/*      */       } 
/*      */     } 
/*  673 */     Collections.shuffle(candidates, new Random(m_217043_().m_188505_()));
/*  674 */     double yawRad = Math.toRadians(m_146908_());
/*  675 */     double fx = -Math.sin(yawRad);
/*  676 */     double fz = Math.cos(yawRad);
/*      */     
/*  678 */     int spawned = 0;
/*  679 */     for (BlockPos pos : candidates) {
/*  680 */       if (spawned >= count)
/*      */         break; 
/*  682 */       if (!sl.m_46749_(pos) || 
/*  683 */         !sl.m_6857_().m_61937_(pos))
/*      */         continue; 
/*  685 */       if (!sl.m_46859_(pos) || !sl.m_46859_(pos.m_7494_()) || 
/*  686 */         sl.m_46859_(pos.m_7495_()))
/*      */         continue; 
/*  688 */       double spawnX = pos.m_123341_() + 0.5D;
/*  689 */       double spawnY = pos.m_123342_();
/*  690 */       double spawnZ = pos.m_123343_() + 0.5D;
/*      */       
/*  692 */       double lookX = spawnX + fx * 10.0D;
/*  693 */       double lookZ = spawnZ + fz * 10.0D;
/*      */       
/*  695 */       summonHerobrine(id, spawnX, spawnY, spawnZ, lookX, lookZ, true);
/*  696 */       spawned++;
/*      */     } 
/*      */   }
/*      */   private void summonEscapeAtDay() {
/*      */     String leftHerobrine, rightHerobrine;
/*  701 */     this.escapeTiming = 70;
/*  702 */     AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY
/*  703 */         .with(() -> this), new ClientboundHerobrinePortalFx(
/*  704 */           m_20097_().m_252807_().m_82520_(0.0D, 0.5D, 0.0D)));
/*      */ 
/*      */     
/*  707 */     double yawRad = Math.toRadians(m_146908_());
/*      */     
/*  709 */     double fx = -Math.sin(yawRad);
/*  710 */     double fz = Math.cos(yawRad);
/*  711 */     double lx = Math.cos(yawRad);
/*  712 */     double lz = Math.sin(yawRad);
/*      */     
/*  714 */     double y = m_20186_();
/*  715 */     double front = 1.0D;
/*  716 */     double side = 1.0D;
/*      */ 
/*      */ 
/*      */     
/*  720 */     if (Math.random() <= 0.5D) {
/*  721 */       leftHerobrine = "annoyingvillagers:low_herobrine_clone";
/*      */     } else {
/*  723 */       leftHerobrine = "annoyingvillagers:low_shadow_herobrine_clone";
/*      */     } 
/*  725 */     spawnHerobrineOffset(leftHerobrine, 0.0D, side, y, fx, fz, lx, lz);
/*      */ 
/*      */     
/*  728 */     if (Math.random() <= 0.5D) {
/*  729 */       rightHerobrine = "annoyingvillagers:low_herobrine_clone";
/*      */     } else {
/*  731 */       rightHerobrine = "annoyingvillagers:low_shadow_herobrine_clone";
/*      */     } 
/*  733 */     spawnHerobrineOffset(rightHerobrine, 0.0D, -side, y, fx, fz, lx, lz);
/*      */ 
/*      */     
/*  736 */     if (Math.random() >= 0.7D) {
/*      */       String frontHerobrine;
/*  738 */       if (Math.random() <= 0.5D) {
/*  739 */         frontHerobrine = "annoyingvillagers:low_herobrine_clone";
/*      */       } else {
/*  741 */         frontHerobrine = "annoyingvillagers:low_shadow_herobrine_clone";
/*      */       } 
/*      */       
/*  744 */       spawnHerobrineOffset(frontHerobrine, front, 0.0D, y, fx, fz, lx, lz);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void summonEscapeAtNight() {
/*  749 */     this.escapeTiming = 70;
/*  750 */     AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY
/*  751 */         .with(() -> this), new ClientboundHerobrinePortalFx(
/*  752 */           m_20097_().m_252807_().m_82520_(0.0D, 0.5D, 0.0D)));
/*      */ 
/*      */     
/*  755 */     List<String> herobrines = new ArrayList<>();
/*  756 */     herobrines.add("annoyingvillagers:herobrine_clone");
/*  757 */     herobrines.add("annoyingvillagers:shadow_herobrine_clone");
/*  758 */     herobrines.add("annoyingvillagers:herobrine_chris");
/*  759 */     herobrines.add("annoyingvillagers:herobrine_7");
/*  760 */     herobrines.add("annoyingvillagers:armored_herobrine");
/*  761 */     herobrines.add("annoyingvillagers:low_shadow_herobrine_clone");
/*      */     
/*  763 */     Random random = new Random();
/*  764 */     String herobrineId = herobrines.get(random.nextInt(herobrines.size()));
/*      */ 
/*      */     
/*  767 */     if (herobrineId.equals("annoyingvillagers:low_shadow_herobrine_clone")) {
/*  768 */       spawnRandomHerobrinesInRadius(herobrineId, (new Random()).nextInt(10, 20));
/*      */     } else {
/*  770 */       double yawRad = Math.toRadians(m_146908_());
/*      */       
/*  772 */       double fx = -Math.sin(yawRad);
/*  773 */       double fz = Math.cos(yawRad);
/*  774 */       double lx = Math.cos(yawRad);
/*  775 */       double lz = Math.sin(yawRad);
/*      */       
/*  777 */       double y = m_20186_();
/*  778 */       double front = 1.0D;
/*      */       
/*  780 */       spawnHerobrineOffset(herobrineId, front, 0.0D, y, fx, fz, lx, lz);
/*      */     } 
/*      */   }
/*      */   
/*      */   private enum ElitePattern {
/*  785 */     SOLO_1E,
/*  786 */     ONEE_PLUS_1S,
/*  787 */     ONEE_PLUS_2S,
/*  788 */     TWO_E,
/*  789 */     TWOE_PLUS_1S,
/*  790 */     THREE_E;
/*      */   }
/*      */   
/*      */   private ElitePattern pickWeightedElitePattern(Random random) {
/*  794 */     double roll = random.nextDouble();
/*  795 */     if (roll <= 0.10000000149011612D)
/*  796 */       return ElitePattern.THREE_E; 
/*  797 */     if (roll <= 0.20000000298023224D)
/*  798 */       return ElitePattern.TWOE_PLUS_1S; 
/*  799 */     if (roll <= 0.30000001192092896D)
/*  800 */       return ElitePattern.TWO_E; 
/*  801 */     if (roll <= 0.4000000059604645D)
/*  802 */       return ElitePattern.ONEE_PLUS_2S; 
/*  803 */     if (roll <= 0.5D) {
/*  804 */       return ElitePattern.ONEE_PLUS_1S;
/*      */     }
/*  806 */     return ElitePattern.SOLO_1E;
/*      */   }
/*      */ 
/*      */   
/*      */   private void clearSummonSpace(ServerLevel serverLevel) {
/*  811 */     BlockPos center = m_20097_();
/*  812 */     int feetY = center.m_123342_();
/*      */     
/*  814 */     for (int dy = 1; dy <= 2; dy++) {
/*  815 */       for (int i = -2; i <= 2; i++) {
/*  816 */         for (int dz = -2; dz <= 2; dz++) {
/*  817 */           BlockPos pos = center.m_7918_(i, dy, dz);
/*      */           
/*  819 */           BlockState state = serverLevel.m_8055_(pos);
/*  820 */           if (!state.m_60795_() && 
/*  821 */             state.m_60800_((BlockGetter)serverLevel, pos) >= 0.0F)
/*      */           {
/*  823 */             serverLevel.m_46953_(pos, true, (Entity)this);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  828 */     for (int dx = -2; dx <= 2; dx++) {
/*  829 */       for (int dz = -2; dz <= 2; dz++) {
/*  830 */         BlockPos pos = new BlockPos(center.m_123341_() + dx, feetY, center.m_123343_() + dz);
/*      */         
/*  832 */         if (serverLevel.m_8055_(pos).m_60795_()) {
/*  833 */           serverLevel.m_46597_(pos, Blocks.f_50723_.m_49966_());
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static <T> T pickRandom(List<T> list, Random random) {
/*  840 */     return list.remove(random.nextInt(list.size()));
/*      */   }
/*      */   
/*      */   private void summonAtNight() {
/*  844 */     List<String> herobrines = new ArrayList<>();
/*  845 */     herobrines.add("annoyingvillagers:shadow_herobrine");
/*  846 */     herobrines.add("annoyingvillagers:elite");
/*  847 */     herobrines.add("annoyingvillagers:null");
/*  848 */     herobrines.add("annoyingvillagers:elite");
/*      */     
/*  850 */     List<String> elites = new ArrayList<>();
/*  851 */     elites.add("annoyingvillagers:swordsman_herobrine");
/*  852 */     elites.add("annoyingvillagers:aegis_herobrine");
/*  853 */     elites.add("annoyingvillagers:glaive_herobrine");
/*  854 */     elites.add("annoyingvillagers:reaper_herobrine");
/*  855 */     elites.add("annoyingvillagers:sledgehammer_herobrine");
/*      */     
/*  857 */     float yaw = m_146908_();
/*  858 */     double rad = Math.toRadians(yaw);
/*  859 */     double fx = -Math.sin(rad);
/*  860 */     double fz = Math.cos(rad);
/*  861 */     double lx = Math.cos(rad);
/*  862 */     double lz = Math.sin(rad);
/*      */     
/*  864 */     double baseY = m_20186_();
/*  865 */     double centerForward = 3.0D;
/*  866 */     double side = 1.0D;
/*  867 */     double thirdForward = 4.0D;
/*      */     
/*  869 */     double centerX = m_20185_() + fx * centerForward;
/*  870 */     double centerZ = m_20189_() + fz * centerForward;
/*  871 */     double lookX = centerX + fx * 10.0D;
/*  872 */     double lookZ = centerZ + fz * 10.0D;
/*      */     
/*  874 */     m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(centerX, baseY, centerZ));
/*      */     
/*  876 */     if (!(m_9236_() instanceof ServerLevel))
/*  877 */       return;  AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY
/*  878 */         .with(() -> this), new ClientboundHerobrinePortalFx(new Vec3(centerX, baseY, centerZ)));
/*      */ 
/*      */ 
/*      */     
/*  882 */     Random random = new Random();
/*  883 */     String pick = herobrines.get(random.nextInt(herobrines.size()));
/*      */     
/*  885 */     if (pick.equals("annoyingvillagers:shadow_herobrine") || pick.equals("annoyingvillagers:null")) {
/*  886 */       summonHerobrine(pick, centerX, baseY, centerZ, lookX, lookZ, false);
/*      */       
/*      */       return;
/*      */     } 
/*  890 */     ElitePattern pattern = pickWeightedElitePattern(random);
/*      */     
/*  892 */     switch (pattern) {
/*      */       case SOLO_1E:
/*  894 */         summonHerobrine(pickRandom(elites, random), centerX, baseY, centerZ, lookX, lookZ, false);
/*      */         break;
/*      */ 
/*      */       
/*      */       case ONEE_PLUS_1S:
/*  899 */         spawnHerobrineOffset(pickRandom(elites, random), centerForward, side, baseY, fx, fz, lx, lz);
/*      */         
/*  901 */         spawnHerobrineOffset("annoyingvillagers:low_shadow_herobrine_clone", centerForward, -side, baseY, fx, fz, lx, lz);
/*      */         break;
/*      */       
/*      */       case ONEE_PLUS_2S:
/*  905 */         spawnHerobrineOffset("annoyingvillagers:low_shadow_herobrine_clone", centerForward, side, baseY, fx, fz, lx, lz);
/*  906 */         spawnHerobrineOffset("annoyingvillagers:low_shadow_herobrine_clone", centerForward, -side, baseY, fx, fz, lx, lz);
/*  907 */         spawnHerobrineOffset(pickRandom(elites, random), thirdForward, 0.0D, baseY, fx, fz, lx, lz);
/*      */         break;
/*      */       
/*      */       case TWO_E:
/*  911 */         spawnHerobrineOffset(pickRandom(elites, random), centerForward, side, baseY, fx, fz, lx, lz);
/*  912 */         spawnHerobrineOffset(pickRandom(elites, random), centerForward, -side, baseY, fx, fz, lx, lz);
/*      */         break;
/*      */       
/*      */       case TWOE_PLUS_1S:
/*  916 */         spawnHerobrineOffset("annoyingvillagers:low_shadow_herobrine_clone", centerForward, side, baseY, fx, fz, lx, lz);
/*  917 */         spawnHerobrineOffset(pickRandom(elites, random), centerForward, -side, baseY, fx, fz, lx, lz);
/*  918 */         spawnHerobrineOffset(pickRandom(elites, random), thirdForward, 0.0D, baseY, fx, fz, lx, lz);
/*      */         break;
/*      */       
/*      */       case THREE_E:
/*  922 */         spawnHerobrineOffset(pickRandom(elites, random), centerForward, side, baseY, fx, fz, lx, lz);
/*  923 */         spawnHerobrineOffset(pickRandom(elites, random), centerForward, -side, baseY, fx, fz, lx, lz);
/*  924 */         spawnHerobrineOffset(pickRandom(elites, random), thirdForward, 0.0D, baseY, fx, fz, lx, lz);
/*      */         break;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void summonHerobrines() {
/*  930 */     if (getLivingEntityPatch() != null) {
/*  931 */       getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.PORTAL_SUMMON, 0.0F);
/*      */     }
/*  933 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  934 */       clearSummonSpace(serverLevel); }
/*      */     
/*  936 */     m_20340_(false);
/*  937 */     setUseHerobrineTexture(true);
/*  938 */     summonAtNight();
/*  939 */     this.summonTiming = -2;
/*      */   }
/*      */   
/*      */   private void summonHerobrinesAndEscape() {
/*  943 */     if (getLivingEntityPatch() != null) {
/*  944 */       getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.PORTAL_SUMMON, 0.0F);
/*      */     }
/*  946 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  947 */       clearSummonSpace(serverLevel); }
/*      */     
/*  949 */     if (isDay(m_9236_())) {
/*  950 */       summonEscapeAtDay();
/*      */     } else {
/*  952 */       summonEscapeAtNight();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean m_6785_(double d0) {
/*  957 */     return false;
/*      */   }
/*      */   @NotNull
/*      */   public SoundEvent m_7975_(@NotNull DamageSource damagesource) {
/*  961 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt")));
/*      */   }
/*      */   @NotNull
/*      */   public SoundEvent m_5592_() {
/*  965 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death")));
/*      */   }
/*      */   
/*      */   public boolean isDay(Level level) {
/*  969 */     long timeOfDay = level.m_46468_() % 24000L;
/*  970 */     return (timeOfDay >= 0L && timeOfDay < 13000L);
/*      */   }
/*      */   
/*      */   public boolean m_6469_(@NotNull DamageSource pSource, float f) {
/*  974 */     if (this.summoning || this.escapeTiming >= 0)
/*  975 */       return false; 
/*  976 */     if (m_21223_() == 1.0F || this.combatMode) {
/*  977 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  978 */         EpicfightUtil.damageBlocked(pSource, (Entity)this, serverLevel); }
/*      */       
/*  980 */       return false;
/*      */     } 
/*  982 */     if (pSource.m_276093_(DamageTypes.f_268724_)) {
/*  983 */       return super.m_6469_(pSource, f);
/*      */     }
/*  985 */     return super.m_6469_(pSource, 1.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   private ItemStack randomDamage(ItemStack itemStack) {
/*  990 */     int maxDamage = itemStack.m_41776_();
/*  991 */     itemStack.m_41721_((new Random()).nextInt(maxDamage / 3, maxDamage * 3 / 4));
/*  992 */     return itemStack;
/*      */   }
/*      */   
/*      */   private void equipGearForLowHerobrineClone(Entity entity) {
/*  996 */     if (entity instanceof LowShadowHerobrineCloneEntity && this.f_19796_.m_188501_() < 0.2F) {
/*  997 */       entity.m_8061_(EquipmentSlot.HEAD, randomDamage(new ItemStack((ItemLike)Items.f_42480_)));
/*  998 */       entity.m_8061_(EquipmentSlot.CHEST, randomDamage(new ItemStack((ItemLike)Items.f_42481_)));
/*  999 */       entity.m_8061_(EquipmentSlot.LEGS, randomDamage(new ItemStack((ItemLike)Items.f_42482_)));
/* 1000 */       entity.m_8061_(EquipmentSlot.FEET, randomDamage(new ItemStack((ItemLike)Items.f_42483_)));
/* 1001 */       entity.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42430_));
/* 1002 */       entity.m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)Items.f_42430_));
/*      */     } else {
/* 1004 */       if (this.f_19796_.m_188501_() < 0.3F) {
/* 1005 */         entity.m_8061_(EquipmentSlot.HEAD, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_HELMET.get())));
/*      */       }
/* 1007 */       if (this.f_19796_.m_188501_() < 0.3F) {
/* 1008 */         entity.m_8061_(EquipmentSlot.CHEST, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_CHESTPLATE.get())));
/*      */       }
/* 1010 */       if (this.f_19796_.m_188501_() < 0.3F) {
/* 1011 */         entity.m_8061_(EquipmentSlot.LEGS, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_LEGGINGS.get())));
/*      */       }
/* 1013 */       if (this.f_19796_.m_188501_() < 0.3F) {
/* 1014 */         entity.m_8061_(EquipmentSlot.FEET, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_BOOTS.get())));
/*      */       }
/* 1016 */       entity.m_8061_(EquipmentSlot.MAINHAND, randomDamage(new ItemStack((ItemLike)this.listWeapons.get(this.f_19796_.m_188503_(this.listWeapons.size())))));
/*      */     } 
/*      */   }
/*      */   
/*      */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverlevelaccessor, @NotNull DifficultyInstance difficultyinstance, @NotNull MobSpawnType mobspawntype, @Nullable SpawnGroupData spawngroupdata, @Nullable CompoundTag compoundtag) {
/* 1021 */     if (mobspawntype == MobSpawnType.NATURAL || mobspawntype == MobSpawnType.CHUNK_GENERATION) {
/* 1022 */       ServerLevel serverLevel = serverlevelaccessor.m_6018_();
/* 1023 */       GregData gregData = GregData.get(serverLevel);
/*      */       
/* 1025 */       if (!gregData.tryClaim(serverLevel, m_20148_())) {
/* 1026 */         m_146870_();
/* 1027 */         return null;
/*      */       } 
/*      */ 
/*      */       
/* 1031 */       BlockPos blockPos = m_20097_();
/* 1032 */       int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, blockPos).m_123342_();
/* 1033 */       BlockPos spawnPos = new BlockPos(blockPos.m_123341_(), surfaceY, blockPos.m_123343_());
/* 1034 */       m_20035_(spawnPos, m_146908_(), m_146909_());
/*      */     } 
/*      */     
/* 1037 */     ChatUtil.joinGame((Entity)this, "Greg");
/* 1038 */     return super.m_6518_(serverlevelaccessor, difficultyinstance, mobspawntype, spawngroupdata, compoundtag);
/*      */   }
/*      */   
/*      */   public void m_5993_(@NotNull Entity entity, int i, @NotNull DamageSource damagesource) {
/* 1042 */     super.m_5993_(entity, i, damagesource);
/*      */   }
/*      */   
/*      */   public void m_6075_() {
/* 1046 */     super.m_6075_();
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7378_(@NotNull CompoundTag pCompound) {
/* 1051 */     super.m_7378_(pCompound);
/* 1052 */     setWhiteEye(pCompound.m_128471_("WhiteEye"));
/* 1053 */     setUseHerobrineTexture(pCompound.m_128471_("UseHerobrineTexture"));
/* 1054 */     this.summoning = pCompound.m_128471_("Summoning");
/* 1055 */     this.summonTiming = pCompound.m_128451_("SummonTiming");
/* 1056 */     this.escapeTiming = pCompound.m_128451_("EscapeTiming");
/* 1057 */     this.summonTimestamp = pCompound.m_128451_("SummonTimestamp");
/* 1058 */     this.combatMode = pCompound.m_128471_("CombatMode");
/* 1059 */     this.recallTime = pCompound.m_128451_("RecallTime");
/* 1060 */     if (pCompound.m_128403_("FirstSummonedHerobrineUUID")) {
/* 1061 */       this.firstSummonedHerobrineUUID = pCompound.m_128342_("FirstSummonedHerobrineUUID");
/*      */     }
/* 1063 */     if (pCompound.m_128403_("SecondSummonedHerobrineUUID")) {
/* 1064 */       this.secondSummonedHerobrineUUID = pCompound.m_128342_("SecondSummonedHerobrineUUID");
/*      */     }
/* 1066 */     if (pCompound.m_128403_("ThirdSummonedHerobrineUUID")) {
/* 1067 */       this.thirdSummonedHerobrineUUID = pCompound.m_128342_("ThirdSummonedHerobrineUUID");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7380_(@NotNull CompoundTag pCompound) {
/* 1073 */     super.m_7380_(pCompound);
/* 1074 */     pCompound.m_128379_("WhiteEye", isWhiteEye());
/* 1075 */     pCompound.m_128379_("UseHerobrineTexture", isUseHerobrineTexture());
/* 1076 */     pCompound.m_128379_("Summoning", this.summoning);
/* 1077 */     pCompound.m_128405_("SummonTiming", this.summonTiming);
/* 1078 */     pCompound.m_128405_("EscapeTiming", this.escapeTiming);
/* 1079 */     pCompound.m_128405_("SummonTimestamp", this.summonTimestamp);
/* 1080 */     pCompound.m_128379_("CombatMode", this.combatMode);
/* 1081 */     pCompound.m_128405_("RecallTime", this.recallTime);
/* 1082 */     if (this.firstSummonedHerobrineUUID != null) {
/* 1083 */       pCompound.m_128362_("FirstSummonedHerobrineUUID", this.firstSummonedHerobrineUUID);
/*      */     }
/* 1085 */     if (this.secondSummonedHerobrineUUID != null) {
/* 1086 */       pCompound.m_128362_("SecondSummonedHerobrineUUID", this.secondSummonedHerobrineUUID);
/*      */     }
/* 1088 */     if (this.thirdSummonedHerobrineUUID != null) {
/* 1089 */       pCompound.m_128362_("ThirdSummonedHerobrineUUID", this.thirdSummonedHerobrineUUID);
/*      */     }
/*      */   }
/*      */   
/*      */   public static boolean canSpawn(EntityType<HerobrineGregEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 1094 */     ServerLevel serverLevel = level.m_6018_();
/* 1095 */     int passesDay = (int)(serverLevel.m_46467_() / 24000L);
/* 1096 */     if (passesDay % 5 != 0) {
/* 1097 */       return false;
/*      */     }
/* 1099 */     if (GregData.get(serverLevel).isOccupied(serverLevel)) {
/* 1100 */       return false;
/*      */     }
/* 1102 */     return Monster.m_219013_(entityType, level, spawnType, position, random);
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 1107 */     super.m_142687_(reason);
/* 1108 */     if (!(m_9236_()).f_46443_) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (reason == Entity.RemovalReason.KILLED || reason == Entity.RemovalReason.DISCARDED)
/*      */         {
/* 1110 */           GregData.get(serverLevel).releaseIfMatches(serverLevel, m_20148_()); }  }
/*      */        }
/*      */   
/*      */   }
/*      */   public static AttributeSupplier.Builder createAttributes() {
/* 1115 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*      */     
/* 1117 */     builder = builder.m_22268_(Attributes.f_22279_, 0.5D);
/* 1118 */     builder = builder.m_22268_(Attributes.f_22276_, 40.0D);
/* 1119 */     builder = builder.m_22268_(Attributes.f_22284_, 0.0D);
/* 1120 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 1121 */     builder = builder.m_22268_(Attributes.f_22277_, 48.0D);
/* 1122 */     builder = builder.m_22268_(Attributes.f_22278_, 1.0D);
/* 1123 */     return builder;
/*      */   }
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\HerobrineGregEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */