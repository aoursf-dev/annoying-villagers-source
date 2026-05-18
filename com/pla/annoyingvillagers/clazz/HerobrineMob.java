/*      */ package com.pla.annoyingvillagers.clazz;
/*      */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*      */ import com.pla.annoyingvillagers.blockentity.CryingObsidianBlockEntity;
/*      */ import com.pla.annoyingvillagers.blockentity.ObsidianBlockEntity;
/*      */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianBlockEntity;
/*      */ import com.pla.annoyingvillagers.entity.AegisHerobrineEntity;
/*      */ import com.pla.annoyingvillagers.entity.EliteHerobrineKnockedEntity;
/*      */ import com.pla.annoyingvillagers.entity.HerobrineGregEntity;
/*      */ import com.pla.annoyingvillagers.entity.LowHerobrineCloneEntity;
/*      */ import com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity;
/*      */ import com.pla.annoyingvillagers.entity.NullEntity;
/*      */ import com.pla.annoyingvillagers.entity.ReaperHerobrineEntity;
/*      */ import com.pla.annoyingvillagers.entity.ShadowHerobrineEntity;
/*      */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*      */ import com.pla.annoyingvillagers.network.ClientboundHerobrinePortalFx;
/*      */ import com.pla.annoyingvillagers.spawnhandler.HerobrineMobData;
/*      */ import com.pla.annoyingvillagers.task.DelayedTask;
/*      */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*      */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*      */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*      */ import java.util.Objects;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import javax.annotation.Nullable;
/*      */ import net.minecraft.commands.arguments.EntityAnchorArgument;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.core.particles.ParticleOptions;
/*      */ import net.minecraft.nbt.CompoundTag;
/*      */ import net.minecraft.network.chat.Component;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.sounds.SoundEvent;
/*      */ import net.minecraft.tags.FluidTags;
/*      */ import net.minecraft.world.DifficultyInstance;
/*      */ import net.minecraft.world.InteractionHand;
/*      */ import net.minecraft.world.damagesource.DamageSource;
/*      */ import net.minecraft.world.effect.MobEffect;
/*      */ import net.minecraft.world.effect.MobEffectInstance;
/*      */ import net.minecraft.world.effect.MobEffects;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.entity.EntityType;
/*      */ import net.minecraft.world.entity.EquipmentSlot;
/*      */ import net.minecraft.world.entity.LivingEntity;
/*      */ import net.minecraft.world.entity.Mob;
/*      */ import net.minecraft.world.entity.MobSpawnType;
/*      */ import net.minecraft.world.entity.MobType;
/*      */ import net.minecraft.world.entity.SpawnGroupData;
/*      */ import net.minecraft.world.entity.ai.goal.Goal;
/*      */ import net.minecraft.world.entity.ai.navigation.PathNavigation;
/*      */ import net.minecraft.world.entity.item.ItemEntity;
/*      */ import net.minecraft.world.entity.monster.Monster;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.item.enchantment.Enchantments;
/*      */ import net.minecraft.world.level.ItemLike;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.level.LevelAccessor;
/*      */ import net.minecraft.world.level.ServerLevelAccessor;
/*      */ import net.minecraft.world.level.block.Block;
/*      */ import net.minecraft.world.level.block.entity.BlockEntity;
/*      */ import net.minecraft.world.level.block.state.BlockState;
/*      */ import net.minecraft.world.level.levelgen.Heightmap;
/*      */ import net.minecraft.world.level.material.FluidState;
/*      */ import net.minecraft.world.level.pathfinder.BlockPathTypes;
/*      */ import net.minecraft.world.level.pathfinder.PathFinder;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import net.minecraft.world.phys.shapes.CollisionContext;
/*      */ import net.minecraftforge.common.ForgeHooks;
/*      */ import net.minecraftforge.network.PacketDistributor;
/*      */ import net.minecraftforge.registries.ForgeRegistries;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import yesman.epicfight.api.animation.AnimationPlayer;
/*      */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*      */ import yesman.epicfight.api.asset.AssetAccessor;
/*      */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*      */ import yesman.epicfight.world.effect.EpicFightMobEffects;
/*      */ 
/*      */ public class HerobrineMob extends Monster implements BurstProtectEntity, CombatVoiceLineEntity {
/*   82 */   private int recallTicks = 0; private boolean renderPortal = false;
/*      */   private String chatName;
/*      */   private boolean neverRecall = false;
/*   85 */   private UUID gregUUID = null;
/*      */   private boolean initialSpawn = true;
/*   87 */   private BlockPos lastFeetPos = null;
/*      */   private EliteHerobrineKnockedEntity protectEntity;
/*      */   private UUID protectUUID;
/*   90 */   private int sacrificingAnimationCooldown = 0;
/*      */   private boolean sacrificing = false;
/*      */   private boolean healing = false;
/*      */   private int healingCooldown;
/*   94 */   private int stunEscapeCooldown = 0;
/*   95 */   private Entity blockDamage = null;
/*      */   private int swapWeaponCooldown;
/*   97 */   private int efnGuardHitState = 0;
/*   98 */   private int efnGuardHitCooldown = 0;
/*   99 */   protected float recentDamageTaken = 0.0F;
/*  100 */   protected int recentHitCounter = 0;
/*  101 */   private int voiceCooldown = 0; private Entity firstPossessedHerobrine; private UUID firstPossessedHerobrineUuid; private Entity secondPossessedHerobrine; private UUID secondPossessedHerobrineUuid; private Entity thirdPossessedHerobrine; private UUID thirdPossessedHerobrineUuid; private Entity fourthPossessedHerobrine;
/*      */   private UUID fourthPossessedHerobrineUuid;
/*      */   
/*      */   public int getVoiceCooldown() {
/*  105 */     return this.voiceCooldown;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setVoiceCooldown(int cooldown) {
/*  110 */     this.voiceCooldown = cooldown;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getRecentDamageTaken() {
/*  115 */     return this.recentDamageTaken;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRecentDamageTaken(float value) {
/*  120 */     this.recentDamageTaken = value;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getRecentHitCounter() {
/*  125 */     return this.recentHitCounter;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRecentHitCounter(int value) {
/*  130 */     this.recentHitCounter = value;
/*      */   }
/*      */   
/*      */   public int getEfnGuardHitState() {
/*  134 */     return this.efnGuardHitState;
/*      */   }
/*      */   
/*      */   public void postPlayEfnGuardHit() {
/*  138 */     if (this.efnGuardHitState == 2) {
/*  139 */       this.efnGuardHitState = 0;
/*      */     } else {
/*  141 */       this.efnGuardHitState++;
/*      */     } 
/*  143 */     this.efnGuardHitCooldown = 100;
/*      */   }
/*      */   
/*      */   public int getStunEscapeCooldown() {
/*  147 */     return this.stunEscapeCooldown;
/*      */   }
/*      */   
/*      */   public void setStunEscapeCooldown(int stunEscapeCooldown) {
/*  151 */     this.stunEscapeCooldown = stunEscapeCooldown;
/*      */   }
/*      */   
/*      */   public void setBlockDamage(Entity blockDamage) {
/*  155 */     this.blockDamage = blockDamage;
/*      */   }
/*      */   
/*      */   public Entity getBlockDamage() {
/*  159 */     return this.blockDamage;
/*      */   }
/*      */   
/*      */   public int getSwapWeaponCooldown() {
/*  163 */     return this.swapWeaponCooldown;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  181 */   private int state = 0;
/*      */   private int secondFormHitLeft;
/*      */   
/*      */   public int getState() {
/*  185 */     return this.state;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public LivingEntityPatch<?> getLivingEntityPatch() {
/*  190 */     return (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*      */   }
/*      */   
/*      */   public void setState(int state) {
/*  194 */     this.state = state;
/*      */   }
/*      */   
/*      */   public void setSecondFormHitLeft(int secondFormHitLeft) {
/*  198 */     this.secondFormHitLeft = secondFormHitLeft;
/*      */   }
/*      */   
/*      */   public int getSecondFormHitLeft() {
/*  202 */     return this.secondFormHitLeft;
/*      */   }
/*      */   
/*      */   public void setHealingCooldown() {
/*  206 */     this.healingCooldown = this.f_19796_.m_216339_(300, 600);
/*      */   }
/*      */   
/*      */   public int getHealingCooldown() {
/*  210 */     return this.healingCooldown;
/*      */   }
/*      */   
/*      */   public Entity getFirstPossessedHerobrine() {
/*  214 */     return this.firstPossessedHerobrine;
/*      */   }
/*      */   
/*      */   public Entity getSecondPossessedHerobrine() {
/*  218 */     return this.secondPossessedHerobrine;
/*      */   }
/*      */   
/*      */   public Entity getThirdPossessedHerobrine() {
/*  222 */     return this.thirdPossessedHerobrine;
/*      */   }
/*      */   
/*      */   public Entity getFourthPossessedHerobrine() {
/*  226 */     return this.fourthPossessedHerobrine;
/*      */   }
/*      */   
/*      */   public int getSacrificingAnimationCooldown() {
/*  230 */     return this.sacrificingAnimationCooldown;
/*      */   }
/*      */   
/*      */   public void rollItem() {
/*  234 */     this.swapWeaponCooldown = (new Random()).nextInt(100, 200);
/*      */   }
/*      */   
/*      */   public boolean isAvailableSlot() {
/*  238 */     return (this.firstPossessedHerobrineUuid == null || this.secondPossessedHerobrineUuid == null || this.thirdPossessedHerobrineUuid == null || this.fourthPossessedHerobrineUuid == null);
/*      */   }
/*      */   
/*      */   private int getEmptyBoundClone() {
/*  242 */     int returnValue = 0;
/*  243 */     if (this.firstPossessedHerobrineUuid == null) returnValue++; 
/*  244 */     if (this.secondPossessedHerobrineUuid == null) returnValue++; 
/*  245 */     if (this.thirdPossessedHerobrineUuid == null) returnValue++; 
/*  246 */     if (this.fourthPossessedHerobrineUuid == null) returnValue++; 
/*  247 */     return returnValue;
/*      */   }
/*      */   
/*      */   public boolean boundPossessed(Entity entity) {
/*  251 */     if (this.firstPossessedHerobrineUuid == null) {
/*  252 */       this.firstPossessedHerobrineUuid = entity.m_20148_();
/*  253 */       this.firstPossessedHerobrine = entity;
/*  254 */       return true;
/*  255 */     }  if (this.secondPossessedHerobrineUuid == null) {
/*  256 */       this.secondPossessedHerobrineUuid = entity.m_20148_();
/*  257 */       this.secondPossessedHerobrine = entity;
/*  258 */       return true;
/*  259 */     }  if (this.thirdPossessedHerobrineUuid == null) {
/*  260 */       this.thirdPossessedHerobrineUuid = entity.m_20148_();
/*  261 */       this.thirdPossessedHerobrine = entity;
/*  262 */       return true;
/*  263 */     }  if (this.fourthPossessedHerobrineUuid == null) {
/*  264 */       this.fourthPossessedHerobrineUuid = entity.m_20148_();
/*  265 */       this.fourthPossessedHerobrine = entity;
/*  266 */       return true;
/*      */     } 
/*  268 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setProtectUUID(UUID protectUUID) {
/*  273 */     this.protectUUID = protectUUID;
/*      */   }
/*      */   
/*      */   public void setProtectEntity(EliteHerobrineKnockedEntity protectEntity) {
/*  277 */     this.protectEntity = protectEntity;
/*      */   }
/*      */   
/*      */   public void setGregUUID(UUID gregUUID) {
/*  281 */     this.gregUUID = gregUUID;
/*      */   }
/*      */   
/*      */   public UUID getGregUUID() {
/*  285 */     return this.gregUUID;
/*      */   }
/*      */   
/*      */   public void setRecallTicks(int recallTicks) {
/*  289 */     this.recallTicks = recallTicks;
/*      */   }
/*      */   
/*      */   public int getRecallTicks() {
/*  293 */     return this.recallTicks;
/*      */   }
/*      */   
/*      */   public void setRenderPortal(boolean renderPortal) {
/*  297 */     this.renderPortal = renderPortal;
/*      */   }
/*      */   
/*      */   public String getChatName() {
/*  301 */     return this.chatName;
/*      */   }
/*      */   
/*      */   public void setChatName(String chatName) {
/*  305 */     this.chatName = chatName;
/*      */   }
/*      */   
/*      */   public void setNeverRecall(boolean neverRecall) {
/*  309 */     this.neverRecall = neverRecall;
/*      */   }
/*      */   
/*      */   public void setInitialSpawn(boolean initialSpawn) {
/*  313 */     this.initialSpawn = initialSpawn;
/*      */   }
/*      */   
/*      */   public boolean isSacrificing() {
/*  317 */     return this.sacrificing;
/*      */   }
/*      */   
/*      */   public boolean isHealing() {
/*  321 */     return this.healing;
/*      */   }
/*      */   
/*      */   public void setHealing(boolean healing) {
/*  325 */     this.healing = healing;
/*      */   }
/*      */   
/*      */   protected HerobrineMob(EntityType<? extends Monster> pEntityType, Level pLevel) {
/*  329 */     super(pEntityType, pLevel);
/*  330 */     m_21409_(EquipmentSlot.MAINHAND, 0.0F);
/*  331 */     m_21409_(EquipmentSlot.CHEST, 0.0F);
/*  332 */     m_21409_(EquipmentSlot.HEAD, 0.0F);
/*  333 */     m_21441_(BlockPathTypes.WATER, 0.0F);
/*  334 */     m_21441_(BlockPathTypes.WATER_BORDER, 0.0F);
/*  335 */     m_21441_(BlockPathTypes.LAVA, 0.0F);
/*  336 */     m_21441_(BlockPathTypes.DANGER_FIRE, 0.0F);
/*  337 */     m_21441_(BlockPathTypes.DAMAGE_FIRE, 0.0F);
/*      */   }
/*      */   
/*      */   public static class AnyFluidPathNavigation extends GroundPathNavigation {
/*      */     public AnyFluidPathNavigation(Mob mob, Level level) {
/*  342 */       super(mob, level);
/*      */     }
/*      */     
/*      */     @NotNull
/*      */     protected PathFinder m_5532_(int maxVisitedNodes) {
/*  347 */       this.f_26508_ = (NodeEvaluator)new WalkNodeEvaluator();
/*  348 */       this.f_26508_.m_77351_(true);
/*  349 */       return new PathFinder(this.f_26508_, maxVisitedNodes);
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean m_7367_(@NotNull BlockPathTypes type) {
/*  354 */       if (type == BlockPathTypes.WATER || type == BlockPathTypes.WATER_BORDER || type == BlockPathTypes.LAVA || type == BlockPathTypes.DANGER_FIRE || type == BlockPathTypes.DAMAGE_FIRE)
/*      */       {
/*      */ 
/*      */ 
/*      */         
/*  359 */         return true;
/*      */       }
/*  361 */       return super.m_7367_(type);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean m_6342_(@NotNull BlockPos blockPos) {
/*  366 */       return (this.f_26495_.m_6425_(blockPos).m_76152_() != Fluids.f_76191_ || super.m_6342_(blockPos));
/*      */     } }
/*      */   
/*      */   @NotNull
/*      */   public Packet<ClientGamePacketListener> m_5654_() {
/*  371 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*      */   }
/*      */   
/*      */   private Entity getHealingHerobrine() {
/*  375 */     if (isHealing()) {
/*  376 */       if (this.firstPossessedHerobrine != null) {
/*  377 */         Entity entity = this.firstPossessedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity; if (lowShadowHerobrineCloneEntity.isHealing())
/*  378 */             return (Entity)lowShadowHerobrineCloneEntity;  }
/*      */         
/*  380 */         entity = this.firstPossessedHerobrine; if (entity instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)entity; if (lowHerobrineCloneEntity.isHealing())
/*  381 */             return (Entity)lowHerobrineCloneEntity;  }
/*      */       
/*      */       } 
/*  384 */       if (this.secondPossessedHerobrine != null) {
/*  385 */         Entity entity = this.secondPossessedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity; if (lowShadowHerobrineCloneEntity.isHealing())
/*  386 */             return (Entity)lowShadowHerobrineCloneEntity;  }
/*      */         
/*  388 */         entity = this.secondPossessedHerobrine; if (entity instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)entity; if (lowHerobrineCloneEntity.isHealing())
/*  389 */             return (Entity)lowHerobrineCloneEntity;  }
/*      */       
/*      */       } 
/*  392 */       if (this.thirdPossessedHerobrine != null) {
/*  393 */         Entity entity = this.thirdPossessedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity; if (lowShadowHerobrineCloneEntity.isHealing())
/*  394 */             return (Entity)lowShadowHerobrineCloneEntity;  }
/*      */         
/*  396 */         entity = this.thirdPossessedHerobrine; if (entity instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)entity; if (lowHerobrineCloneEntity.isHealing())
/*  397 */             return (Entity)lowHerobrineCloneEntity;  }
/*      */       
/*      */       } 
/*  400 */       if (this.fourthPossessedHerobrine != null) {
/*  401 */         Entity entity = this.fourthPossessedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity; if (lowShadowHerobrineCloneEntity.isHealing())
/*  402 */             return (Entity)lowShadowHerobrineCloneEntity;  }
/*      */         
/*  404 */         entity = this.fourthPossessedHerobrine; if (entity instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)entity; if (lowHerobrineCloneEntity.isHealing())
/*  405 */             return (Entity)lowHerobrineCloneEntity;  }
/*      */       
/*      */       } 
/*      */     } 
/*  409 */     return null;
/*      */   }
/*      */   
/*      */   protected void m_8099_() {
/*  413 */     super.m_8099_();
/*  414 */     this.f_21345_.m_25352_(1, (Goal)new KeepPositionGoal((Mob)this));
/*  415 */     this.f_21345_.m_25352_(1, new Goal()
/*      */         {
/*      */           public boolean m_8036_() {
/*  418 */             return (HerobrineMob.this.protectEntity != null && HerobrineMob.this.protectEntity.m_6084_() && HerobrineMob.this.m_20270_((Entity)HerobrineMob.this.protectEntity) > 9.0F);
/*      */           }
/*      */ 
/*      */           
/*      */           public void m_8037_() {
/*  423 */             if (HerobrineMob.this.protectEntity != null && HerobrineMob.this.protectEntity.m_6084_()) {
/*  424 */               HerobrineMob.this.m_21573_().m_5624_((Entity)HerobrineMob.this.protectEntity, 2.0D);
/*  425 */               HerobrineMob.this.m_21563_().m_24960_((Entity)HerobrineMob.this.protectEntity, 30.0F, 30.0F);
/*  426 */               if (HerobrineMob.this.m_20280_((Entity)HerobrineMob.this.protectEntity) > 10.0D) {
/*  427 */                 if (HerobrineMob.this.m_21573_().m_26571_()) {
/*  428 */                   HerobrineMob.this.m_21573_().m_5624_((Entity)HerobrineMob.this.protectEntity, 2.0D);
/*      */                 }
/*      */               } else {
/*  431 */                 HerobrineMob.this.m_21573_().m_26573_();
/*      */               } 
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean m_8045_() {
/*  438 */             return (HerobrineMob.this.protectEntity != null && HerobrineMob.this.protectEntity.m_6084_() && HerobrineMob.this.m_20270_((Entity)HerobrineMob.this.protectEntity) > 50.0D);
/*      */           }
/*      */         });
/*  441 */     this.f_21345_.m_25352_(1, new Goal()
/*      */         {
/*      */           public boolean m_8036_() {
/*  444 */             return (HerobrineMob.this.protectEntity != null && HerobrineMob.this.getHealingHerobrine() != null && HerobrineMob.this.getHealingHerobrine().m_6084_() && HerobrineMob.this.m_20270_(HerobrineMob.this.getHealingHerobrine()) > 9.0F);
/*      */           }
/*      */ 
/*      */           
/*      */           public void m_8037_() {
/*  449 */             if (HerobrineMob.this.getHealingHerobrine() != null && HerobrineMob.this.getHealingHerobrine().m_6084_()) {
/*  450 */               HerobrineMob.this.m_21573_().m_5624_(HerobrineMob.this.getHealingHerobrine(), 2.0D);
/*  451 */               if (HerobrineMob.this.m_20280_(HerobrineMob.this.getHealingHerobrine()) > 10.0D) {
/*  452 */                 if (HerobrineMob.this.m_21573_().m_26571_()) {
/*  453 */                   HerobrineMob.this.m_21573_().m_5624_(HerobrineMob.this.getHealingHerobrine(), 2.0D);
/*      */                 }
/*      */               } else {
/*  456 */                 HerobrineMob.this.m_21573_().m_26573_();
/*      */               } 
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean m_8045_() {
/*  463 */             return (HerobrineMob.this.isHealing() && HerobrineMob.this.getHealingHerobrine() != null && HerobrineMob.this.getHealingHerobrine().m_6084_() && HerobrineMob.this.m_20270_(HerobrineMob.this.getHealingHerobrine()) > 50.0D);
/*      */           }
/*      */         });
/*  466 */     CommonGoals.registerGoalForHostileNpc(this);
/*  467 */     this.f_21345_.m_25352_(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 1.0D));
/*      */   }
/*      */   @NotNull
/*      */   public MobType m_6336_() {
/*  471 */     return MobType.f_21641_;
/*      */   }
/*      */   
/*      */   public boolean m_6785_(double d0) {
/*  475 */     return false;
/*      */   }
/*      */   
/*      */   public double m_6049_() {
/*  479 */     return -0.35D;
/*      */   }
/*      */   
/*      */   protected void m_7472_(@NotNull DamageSource damagesource, int i, boolean flag) {
/*  483 */     super.m_7472_(damagesource, i, flag);
/*  484 */     m_19983_(new ItemStack((ItemLike)Blocks.f_50080_));
/*      */   }
/*      */   @NotNull
/*      */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/*  488 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.hurt")));
/*      */   }
/*      */   @NotNull
/*      */   public SoundEvent m_5592_() {
/*  492 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.generic.death")));
/*      */   }
/*      */   
/*      */   public boolean m_142535_(float f, float f1, @NotNull DamageSource damagesource) {
/*  496 */     return super.m_142535_(f, f1, damagesource);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getBurstProtectCapRatio() {
/*  501 */     return 0.05F;
/*      */   }
/*      */   
/*      */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/*  505 */     if (getPersistentData().m_128471_("rising") || getPersistentData().m_128471_("sinking") || this.sacrificing) {
/*  506 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  507 */         EpicfightUtil.damageBlocked(damageSource, (Entity)this, serverLevel); }
/*      */       
/*  509 */       return false;
/*      */     } 
/*  511 */     boolean result = super.m_6469_(damageSource, f);
/*  512 */     if (result) {
/*  513 */       sayHurtSound((Mob)this, damageSource);
/*      */     }
/*  515 */     return result;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_7327_(@NotNull Entity target) {
/*  520 */     boolean result = super.m_7327_(target);
/*  521 */     if (result) {
/*  522 */       sayAttackSound((Mob)this, target);
/*      */     }
/*  524 */     return result;
/*      */   }
/*      */   
/*      */   private void triggerSecondForm(ServerLevel serverLevel) {
/*  528 */     if (this.sacrificingAnimationCooldown != 0)
/*      */       return; 
/*  530 */     this.sacrificingAnimationCooldown = 80;
/*  531 */     m_21557_(true);
/*  532 */     if (!(this instanceof NullEntity)) {
/*  533 */       m_21008_(InteractionHand.MAIN_HAND, ItemStack.f_41583_);
/*  534 */       m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/*      */     } 
/*  536 */     HerobrineMob herobrineMob = this; if (herobrineMob instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)herobrineMob;
/*  537 */       shadowHerobrineEntity.clearDarkOb(); }
/*      */     
/*  539 */     m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 80, 2));
/*      */     
/*  541 */     if (this.gregUUID != null) {
/*  542 */       Entity entity = serverLevel.m_8791_(this.gregUUID);
/*  543 */       if (entity instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)entity; if (entity.m_6084_()) {
/*  544 */           if (this instanceof ShadowHerobrineEntity) {
/*  545 */             m_5496_((SoundEvent)AnnoyingVillagersModSounds.SHADOW_HEROBRINE_SAY_ON_PHASE_2.get(), 1.0F, 1.0F);
/*      */           } else {
/*  547 */             herobrineGregEntity.m_5496_((SoundEvent)AnnoyingVillagersModSounds.GREG_REQUESTING_ASSISTANCE.get(), 1.0F, 1.0F);
/*      */           } 
/*  549 */           ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(herobrineGregEntity.m_9236_().m_7654_())).m_6846_().m_240416_(
/*  550 */               (Component)Component.m_237113_("<" + Component.m_237115_("entity.annoyingvillagers.herobrine_greg").getString() + "> " + 
/*  551 */                 Component.m_237115_("subtitles.herobrine_request").getString()), false);
/*  552 */           herobrineGregEntity.m_21557_(true);
/*      */           return;
/*      */         }  }
/*      */     
/*      */     } 
/*  557 */     if (this instanceof ShadowHerobrineEntity) {
/*  558 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.SHADOW_HEROBRINE_SAY_ON_PHASE_2.get(), 1.0F, 1.0F);
/*      */     } else {
/*  560 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.SELF_REQUESTING_ASSISTANCE.get(), 1.0F, 1.0F);
/*      */     } 
/*  562 */     ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_(
/*  563 */         (Component)Component.m_237113_("<" + getChatName() + "> " + Component.m_237115_("subtitles.herobrine_request").getString()), false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void m_6475_(@NotNull DamageSource pDamageSource, float pDamageAmount) {
/*  569 */     if (pDamageSource.m_276093_(DamageTypes.f_268724_)) {
/*  570 */       super.m_6475_(pDamageSource, pDamageAmount);
/*      */       
/*      */       return;
/*      */     } 
/*  574 */     if (m_6673_(pDamageSource)) {
/*      */       return;
/*      */     }
/*      */     
/*  578 */     pDamageAmount = ForgeHooks.onLivingHurt((LivingEntity)this, pDamageSource, pDamageAmount);
/*  579 */     if (pDamageAmount <= 0.0F) {
/*      */       return;
/*      */     }
/*      */     
/*  583 */     pDamageAmount = m_21161_(pDamageSource, pDamageAmount);
/*  584 */     pDamageAmount = m_6515_(pDamageSource, pDamageAmount);
/*      */     
/*  586 */     float f1 = Math.max(pDamageAmount - m_6103_(), 0.0F);
/*  587 */     float absorbed = pDamageAmount - f1;
/*  588 */     if (absorbed > 0.0F) {
/*  589 */       m_7911_(m_6103_() - absorbed);
/*  590 */       if (m_6103_() < 0.0F) m_7911_(0.0F); 
/*      */     } 
/*  592 */     f1 = ForgeHooks.onLivingDamage((LivingEntity)this, pDamageSource, f1);
/*  593 */     f1 = applyBurstProtection((LivingEntity)this, pDamageSource, f1);
/*  594 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  595 */       if (getState() < 2 && (this instanceof AegisHerobrineEntity || this instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity || this instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity || this instanceof ReaperHerobrineEntity || this instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity || this instanceof NullEntity || this instanceof ShadowHerobrineEntity) && 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  603 */         m_21223_() - f1 <= 1.0F) {
/*  604 */         m_21153_(1.0F);
/*  605 */         this.sacrificing = true;
/*  606 */         triggerSecondForm(serverLevel); return;
/*      */       }  }
/*      */     
/*  609 */     if (f1 <= 0.0F) {
/*      */       return;
/*      */     }
/*  612 */     m_21231_().m_289194_(pDamageSource, f1);
/*  613 */     m_21153_(m_21223_() - f1);
/*  614 */     m_146850_(GameEvent.f_223706_);
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7378_(@NotNull CompoundTag pCompound) {
/*  619 */     super.m_7378_(pCompound);
/*  620 */     this.swapWeaponCooldown = pCompound.m_128451_("SwapWeaponCooldown");
/*  621 */     this.recallTicks = pCompound.m_128451_("RecallTicks");
/*  622 */     this.renderPortal = pCompound.m_128471_("RenderPortal");
/*  623 */     this.neverRecall = pCompound.m_128471_("NeverRecall");
/*  624 */     if (pCompound.m_128441_("GregUUID")) {
/*  625 */       this.gregUUID = pCompound.m_128342_("GregUUID");
/*      */     }
/*  627 */     this.initialSpawn = pCompound.m_128471_("InitialSpawn");
/*  628 */     if (pCompound.m_128403_("ProtectUUID")) {
/*  629 */       this.protectUUID = pCompound.m_128342_("ProtectUUID");
/*      */     }
/*  631 */     if (pCompound.m_128403_("FirstPossessedHerobrineUuid")) {
/*  632 */       this.firstPossessedHerobrineUuid = pCompound.m_128342_("FirstPossessedHerobrineUuid");
/*      */     }
/*  634 */     if (pCompound.m_128403_("SecondPossessedHerobrineUuid")) {
/*  635 */       this.secondPossessedHerobrineUuid = pCompound.m_128342_("SecondPossessedHerobrineUuid");
/*      */     }
/*  637 */     if (pCompound.m_128403_("ThirdPossessedHerobrineUuid")) {
/*  638 */       this.thirdPossessedHerobrineUuid = pCompound.m_128342_("ThirdPossessedHerobrineUuid");
/*      */     }
/*  640 */     if (pCompound.m_128403_("FourthPossessedHerobrineUuid")) {
/*  641 */       this.fourthPossessedHerobrineUuid = pCompound.m_128342_("FourthPossessedHerobrineUuid");
/*      */     }
/*  643 */     this.sacrificing = pCompound.m_128471_("Sacrificing");
/*  644 */     this.healing = pCompound.m_128471_("Healing");
/*  645 */     this.sacrificingAnimationCooldown = pCompound.m_128451_("SacrificingAnimationCooldown");
/*  646 */     this.state = pCompound.m_128451_("State");
/*  647 */     this.secondFormHitLeft = pCompound.m_128451_("SecondFormHitLeft");
/*  648 */     this.healingCooldown = pCompound.m_128451_("HealingCooldown");
/*  649 */     this.voiceCooldown = pCompound.m_128451_("VoiceCooldown");
/*      */   }
/*      */   
/*      */   public void jump() {
/*  653 */     m_6135_();
/*  654 */     Vec3 motion = m_20184_();
/*  655 */     Vec3 forward = m_20156_();
/*  656 */     double strength = (new Random()).nextDouble(0.2D, 0.4D);
/*  657 */     m_20334_(motion.f_82479_ + forward.f_82479_ * strength, motion.f_82480_, motion.f_82481_ + forward.f_82481_ * strength);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  662 */     this.f_19812_ = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_7380_(@NotNull CompoundTag pCompound) {
/*  667 */     super.m_7380_(pCompound);
/*  668 */     pCompound.m_128405_("SwapWeaponCooldown", this.swapWeaponCooldown);
/*  669 */     pCompound.m_128405_("RecallTicks", this.recallTicks);
/*  670 */     pCompound.m_128379_("RenderPortal", this.renderPortal);
/*  671 */     pCompound.m_128379_("NeverRecall", this.neverRecall);
/*  672 */     if (this.gregUUID != null) {
/*  673 */       pCompound.m_128362_("GregUUID", this.gregUUID);
/*      */     }
/*  675 */     pCompound.m_128379_("InitialSpawn", this.initialSpawn);
/*  676 */     if (this.protectUUID != null) {
/*  677 */       pCompound.m_128362_("ProtectUUID", this.protectUUID);
/*      */     }
/*  679 */     if (this.firstPossessedHerobrineUuid != null) {
/*  680 */       pCompound.m_128362_("FirstPossessedHerobrineUuid", this.firstPossessedHerobrineUuid);
/*      */     }
/*  682 */     if (this.secondPossessedHerobrineUuid != null) {
/*  683 */       pCompound.m_128362_("SecondPossessedHerobrineUuid", this.secondPossessedHerobrineUuid);
/*      */     }
/*  685 */     if (this.thirdPossessedHerobrineUuid != null) {
/*  686 */       pCompound.m_128362_("ThirdPossessedHerobrineUuid", this.thirdPossessedHerobrineUuid);
/*      */     }
/*  688 */     if (this.fourthPossessedHerobrineUuid != null) {
/*  689 */       pCompound.m_128362_("FourthPossessedHerobrineUuid", this.fourthPossessedHerobrineUuid);
/*      */     }
/*  691 */     pCompound.m_128379_("Sacrificing", this.sacrificing);
/*  692 */     pCompound.m_128379_("Healing", this.healing);
/*  693 */     pCompound.m_128405_("SacrificingAnimationCooldown", this.sacrificingAnimationCooldown);
/*  694 */     pCompound.m_128405_("State", this.state);
/*  695 */     pCompound.m_128405_("SecondFormHitLeft", this.secondFormHitLeft);
/*  696 */     pCompound.m_128405_("HealingCooldown", this.healingCooldown);
/*  697 */     pCompound.m_128405_("VoiceCooldown", this.voiceCooldown);
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   protected PathNavigation m_6037_(@NotNull Level level) {
/*  702 */     return (PathNavigation)new AnyFluidPathNavigation((Mob)this, level);
/*      */   }
/*      */   
/*      */   private void floatOnAnyFluid() {
/*  706 */     BlockPos pos = m_20183_();
/*  707 */     FluidState fluidState = m_9236_().m_6425_(pos);
/*  708 */     if (fluidState.m_76178_()) {
/*      */       return;
/*      */     }
/*      */     
/*  712 */     CollisionContext collisionContext = CollisionContext.m_82750_((Entity)this);
/*  713 */     Fluid typeHere = fluidState.m_76152_();
/*  714 */     FluidState above = m_9236_().m_6425_(pos.m_7494_());
/*      */     
/*  716 */     if (collisionContext.m_6513_(LiquidBlock.f_54690_, pos, true) && above.m_76152_() != typeHere) {
/*  717 */       m_6853_(true);
/*      */       
/*  719 */       double surfaceY = (pos.m_123342_() + fluidState.m_76155_((BlockGetter)m_9236_(), pos));
/*  720 */       double bottomY = (m_20191_()).f_82289_;
/*  721 */       double diff = surfaceY - bottomY - 0.001D;
/*      */       
/*  723 */       if (diff > 0.0D) {
/*  724 */         Vec3 vel = m_20184_();
/*  725 */         m_20334_(vel.f_82479_, Math.max(vel.f_82480_, Math.min(0.2D, diff * 0.2D)), vel.f_82481_);
/*      */       } 
/*      */     } else {
/*  728 */       m_20256_(m_20184_().m_82490_(0.5D).m_82520_(0.0D, 0.05D, 0.0D));
/*      */     } 
/*      */     
/*  731 */     this.f_19789_ = 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_20069_() {
/*  736 */     FluidState fs = m_9236_().m_6425_(m_20183_());
/*  737 */     if (!fs.m_76178_() && m_203441_(fs)) return false; 
/*  738 */     return super.m_20069_();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_203441_(FluidState state) {
/*  743 */     return !state.m_76178_();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean m_6063_() {
/*  748 */     return false;
/*      */   }
/*      */   
/*      */   private void placeObsidianBlockWhenInWater(Block block) {
/*  752 */     BlockPos feet = m_20097_();
/*  753 */     if (this.lastFeetPos == null) this.lastFeetPos = feet; 
/*  754 */     if (!feet.equals(this.lastFeetPos)) {
/*  755 */       if (!m_9236_().m_8055_(this.lastFeetPos).m_60713_(block)) {
/*  756 */         FluidState fluidState = m_9236_().m_6425_(this.lastFeetPos);
/*  757 */         if (!fluidState.m_76178_()) {
/*  758 */           int replace = fluidState.m_205070_(FluidTags.f_13131_) ? 1 : (fluidState.m_205070_(FluidTags.f_13132_) ? 2 : 0);
/*  759 */           BlockState state = (BlockState)block.m_49966_().m_61124_((Property)HerobrineObsidianBlock.REPLACE_BY_LIQUID, Integer.valueOf(replace));
/*  760 */           m_9236_().m_46597_(this.lastFeetPos, state);
/*      */ 
/*      */ 
/*      */           
/*  764 */           BlockEntity blockEntity = m_9236_().m_7702_(this.lastFeetPos);
/*  765 */           if (blockEntity instanceof ObsidianBlockEntity) { ObsidianBlockEntity obsidianBlockEntity = (ObsidianBlockEntity)blockEntity;
/*  766 */             obsidianBlockEntity.setOwner(m_20148_());
/*  767 */             obsidianBlockEntity.m_6596_();
/*  768 */             m_9236_().m_7260_(this.lastFeetPos, state, state, 3); }
/*      */           
/*  770 */           if (blockEntity instanceof ShadowObsidianBlockEntity) { ShadowObsidianBlockEntity shadowObsidianBlockEntity = (ShadowObsidianBlockEntity)blockEntity;
/*  771 */             shadowObsidianBlockEntity.setOwner(m_20148_());
/*  772 */             shadowObsidianBlockEntity.m_6596_();
/*  773 */             m_9236_().m_7260_(this.lastFeetPos, state, state, 3); }
/*      */           
/*  775 */           if (blockEntity instanceof CryingObsidianBlockEntity) { CryingObsidianBlockEntity cryingObsidianBlockEntity = (CryingObsidianBlockEntity)blockEntity;
/*  776 */             cryingObsidianBlockEntity.setOwner(m_20148_());
/*  777 */             cryingObsidianBlockEntity.m_6596_();
/*  778 */             m_9236_().m_7260_(this.lastFeetPos, state, state, 3); }
/*      */         
/*      */         } 
/*      */       } 
/*  782 */       this.lastFeetPos = feet;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void recoverAfterSacrificing() {
/*  787 */     this.sacrificing = false;
/*  788 */     m_21557_(false);
/*  789 */     m_21219_();
/*  790 */     if (getLivingEntityPatch() != null) {
/*  791 */       getLivingEntityPatch().applyStun(StunType.FALL, 0.0F);
/*      */     }
/*  793 */     if (this instanceof AegisHerobrineEntity) {
/*  794 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY_SECOND_FORM_RELEASE.get(), 1.0F, 1.0F);
/*  795 */       ItemStack enderAegis = new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_AEGIS.get());
/*  796 */       enderAegis.m_41663_(Enchantments.f_44977_, 3);
/*  797 */       enderAegis.m_41663_(Enchantments.f_44983_, 3);
/*  798 */       enderAegis.m_41663_(Enchantments.f_44980_, 3);
/*  799 */       m_21008_(InteractionHand.MAIN_HAND, enderAegis);
/*      */     } 
/*  801 */     if (this instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity) {
/*  802 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY_SECOND_FORM_RELEASE.get(), 1.0F, 1.0F);
/*  803 */       ItemStack demoniacVoltageReaver = new ItemStack((ItemLike)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get());
/*  804 */       demoniacVoltageReaver.m_41663_(Enchantments.f_44977_, 3);
/*  805 */       demoniacVoltageReaver.m_41663_(Enchantments.f_44983_, 3);
/*  806 */       demoniacVoltageReaver.m_41663_(Enchantments.f_44980_, 3);
/*  807 */       m_21008_(InteractionHand.MAIN_HAND, demoniacVoltageReaver);
/*      */     } 
/*  809 */     if (this instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity) {
/*  810 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY_SECOND_FORM_RELEASE.get(), 1.0F, 1.0F);
/*  811 */       ItemStack obsidianSledgehammer = new ItemStack((ItemLike)AnnoyingVillagersModItems.OBSIDIAN_SLEDGEHAMMER.get());
/*  812 */       obsidianSledgehammer.m_41663_(Enchantments.f_44977_, 3);
/*  813 */       obsidianSledgehammer.m_41663_(Enchantments.f_44983_, 3);
/*  814 */       obsidianSledgehammer.m_41663_(Enchantments.f_44980_, 3);
/*  815 */       m_21008_(InteractionHand.MAIN_HAND, obsidianSledgehammer);
/*      */     } 
/*  817 */     if (this instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity) {
/*  818 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY_SECOND_FORM_RELEASE.get(), 1.0F, 1.0F);
/*  819 */       ItemStack enderGlaive = new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_GLAIVE.get());
/*  820 */       enderGlaive.m_41663_(Enchantments.f_44977_, 3);
/*  821 */       enderGlaive.m_41663_(Enchantments.f_44983_, 3);
/*  822 */       enderGlaive.m_41663_(Enchantments.f_44980_, 3);
/*  823 */       m_21008_(InteractionHand.MAIN_HAND, enderGlaive);
/*      */     } 
/*  825 */     HerobrineMob herobrineMob = this; if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob;
/*  826 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY_SECOND_FORM_RELEASE.get(), 1.0F, 1.0F);
/*  827 */       ItemStack enderSlayerScythe = new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_SLAYER_SCYTHE.get());
/*  828 */       enderSlayerScythe.m_41663_(Enchantments.f_44977_, 3);
/*  829 */       enderSlayerScythe.m_41663_(Enchantments.f_44983_, 3);
/*  830 */       enderSlayerScythe.m_41663_(Enchantments.f_44980_, 3);
/*  831 */       m_21008_(InteractionHand.MAIN_HAND, enderSlayerScythe);
/*      */       
/*  833 */       if (reaperHerobrineEntity.getThunderHerobrineDragon() == null && reaperHerobrineEntity.getThunderHerobrineDragonUUID() == null) {
/*  834 */         reaperHerobrineEntity.summonEnderDragon(0);
/*      */       }
/*      */       
/*  837 */       if (reaperHerobrineEntity.getMeteoriteHerobrineDragon() == null && reaperHerobrineEntity.getMeteoriteHerobrineDragonUUID() == null) {
/*  838 */         reaperHerobrineEntity.summonEnderDragon(1);
/*      */       }
/*      */       
/*  841 */       if (reaperHerobrineEntity.getHealingHerobrineDragon() == null && reaperHerobrineEntity.getHealingHerobrineDragonUUID() == null) {
/*  842 */         reaperHerobrineEntity.summonEnderDragon(2);
/*      */       } }
/*      */     
/*  845 */     herobrineMob = this; if (herobrineMob instanceof NullEntity) { NullEntity nullEntity = (NullEntity)herobrineMob;
/*  846 */       if (nullEntity.getNullSwordEntity() != null) {
/*  847 */         ItemStack nullSword = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_SWORD.get());
/*  848 */         nullSword.m_41663_(Enchantments.f_44977_, 5);
/*  849 */         nullSword.m_41663_(Enchantments.f_44983_, 5);
/*  850 */         nullEntity.getNullSwordEntity().m_21008_(InteractionHand.MAIN_HAND, nullSword);
/*      */       } 
/*  852 */       if (nullEntity.getNullAxeEntity() != null) {
/*  853 */         ItemStack nullAxe = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_AXE.get());
/*  854 */         nullAxe.m_41663_(Enchantments.f_44978_, 5);
/*  855 */         nullAxe.m_41663_(Enchantments.f_44981_, 2);
/*  856 */         nullEntity.getNullAxeEntity().m_21008_(InteractionHand.MAIN_HAND, nullAxe);
/*      */       } 
/*  858 */       if (nullEntity.getNullPickaxeEntity() != null) {
/*  859 */         ItemStack nullPickaxe = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_PICKAXE.get());
/*  860 */         nullPickaxe.m_41663_(Enchantments.f_44984_, 5);
/*  861 */         nullPickaxe.m_41663_(Enchantments.f_44986_, 3);
/*  862 */         nullEntity.getNullPickaxeEntity().m_21008_(InteractionHand.MAIN_HAND, nullPickaxe);
/*      */       } 
/*  864 */       if (nullEntity.getNullShovelEntity() != null) {
/*  865 */         ItemStack nullShovel = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_SHOVEL.get());
/*  866 */         nullShovel.m_41663_(Enchantments.f_44986_, 5);
/*  867 */         nullShovel.m_41663_(Enchantments.f_44962_, 1);
/*  868 */         nullEntity.getNullShovelEntity().m_21008_(InteractionHand.MAIN_HAND, nullShovel);
/*      */       } 
/*  870 */       if (nullEntity.getNullHoeEntity() != null) {
/*  871 */         ItemStack nullHoe = new ItemStack((ItemLike)AnnoyingVillagersModItems.NULL_HOE.get());
/*  872 */         nullHoe.m_41663_(Enchantments.f_44980_, 5);
/*  873 */         nullHoe.m_41663_(Enchantments.f_44984_, 1);
/*  874 */         nullEntity.getNullHoeEntity().m_21008_(InteractionHand.MAIN_HAND, nullHoe);
/*      */       }  }
/*      */     
/*  877 */     herobrineMob = this; if (herobrineMob instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)herobrineMob;
/*  878 */       ItemStack shadowObsidianPillar = new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get());
/*  879 */       shadowObsidianPillar.m_41663_(Enchantments.f_44977_, 5);
/*  880 */       shadowObsidianPillar.m_41663_(Enchantments.f_44983_, 5);
/*  881 */       shadowObsidianPillar.m_41663_(Enchantments.f_44980_, 3);
/*  882 */       m_21008_(InteractionHand.MAIN_HAND, shadowObsidianPillar);
/*  883 */       shadowHerobrineEntity.setSummonDarkObCooldown(0); }
/*      */     
/*  885 */     this.state = 2;
/*      */   }
/*      */   
/*      */   private void recoverAfterHealing() {
/*  889 */     setHealingCooldown();
/*  890 */     this.healing = false;
/*      */   }
/*      */   
/*      */   public boolean m_7301_(MobEffectInstance mobeffectinstance) {
/*  894 */     return ((mobeffectinstance.m_19544_().m_19483_() == MobEffectCategory.BENEFICIAL || mobeffectinstance.m_19544_() == MobEffects.f_19619_) && super.m_7301_(mobeffectinstance));
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_8119_() {
/*  899 */     super.m_8119_();
/*  900 */     floatOnAnyFluid();
/*  901 */     m_20101_();
/*  902 */     Level level = m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/*  903 */       tickVoiceCooldown();
/*  904 */       tickBurstProtectionDecay((LivingEntity)this);
/*      */       
/*  906 */       if (this.stunEscapeCooldown > 0) this.stunEscapeCooldown--; 
/*  907 */       if (this.swapWeaponCooldown > 0) this.swapWeaponCooldown--; 
/*  908 */       if (this.efnGuardHitCooldown > 0) this.efnGuardHitCooldown--;
/*      */       
/*  910 */       if (this.efnGuardHitCooldown == 0 && this.efnGuardHitState != 0) {
/*  911 */         this.efnGuardHitState = 0;
/*      */       }
/*      */       
/*  914 */       if (getLivingEntityPatch() != null && CombatCommon.canEscape((MobPatch)getLivingEntityPatch())) {
/*  915 */         this.f_21345_.m_25355_(Goal.Flag.MOVE);
/*  916 */         m_21573_().m_26573_();
/*      */         
/*  918 */         LivingEntity target = m_5448_();
/*  919 */         if (target != null) {
/*  920 */           m_21563_().m_24960_((Entity)target, 30.0F, 30.0F);
/*      */         }
/*      */       } else {
/*  923 */         this.f_21345_.m_25374_(Goal.Flag.MOVE);
/*      */       } 
/*      */       
/*  926 */       if (this.stunEscapeCooldown == 0 && m_9236_() instanceof ServerLevel && 
/*  927 */         getLivingEntityPatch() != null) {
/*  928 */         final AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getLivingEntityPatch().getAnimator().getPlayerFor(null))).getRealAnimation();
/*  929 */         if (EpicfightUtil.isLongHitAnimationNotExecutedAnimation(dynamicAnimation, getLivingEntityPatch()) && m_6084_() && 
/*  930 */           m_217043_().m_188501_() < CombatBehaviour.calculateGuardBreakWakeUpChance((LivingEntity)this)) {
/*  931 */           this.stunEscapeCooldown = 60;
/*  932 */           final HerobrineMob entity = this;
/*  933 */           new DelayedTask((new Random()).nextInt(5, 10))
/*      */             {
/*      */               public void run() {
/*  936 */                 if (HerobrineMob.this.getLivingEntityPatch() != null && EpicfightUtil.isLongHitAnimationNotExecutedAnimation(dynamicAnimation, HerobrineMob.this.getLivingEntityPatch()) && entity.m_6084_()) {
/*  937 */                   CombatBehaviour.postGuardBreakWakeUp((LivingEntity)entity, HerobrineMob.this.getLivingEntityPatch(), serverLevel);
/*      */                 } else {
/*  939 */                   entity.stunEscapeCooldown = 1;
/*      */                 } 
/*      */               }
/*      */             };
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  948 */       if (this.state == 2 && (this instanceof AegisHerobrineEntity || this instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity || this instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity || this instanceof ReaperHerobrineEntity || this instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity || this instanceof NullEntity || this instanceof ShadowHerobrineEntity)) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  955 */         m_7292_(new MobEffectInstance((MobEffect)CEMobEffects.FULL_STUN_IMMUNITY.get(), 3, 3));
/*  956 */         m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 3, 3));
/*  957 */         if ((this instanceof NullEntity || this instanceof ShadowHerobrineEntity) && (
/*  958 */           new Random()).nextBoolean()) {
/*  959 */           serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.FULL_COWL
/*  960 */               .get(), 
/*  961 */               m_20185_(), m_20186_(), m_20189_(), 1, 0.3D, 1.2D, 0.3D, 0.0D);
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  967 */       if (this.healingCooldown > 0) this.healingCooldown--;
/*      */       
/*  969 */       if (this instanceof com.pla.annoyingvillagers.entity.HerobrineCloneEntity || this instanceof com.pla.annoyingvillagers.entity.HerobrineChrisEntity) {
/*  970 */         placeObsidianBlockWhenInWater((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get());
/*  971 */       } else if (this instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineCloneEntity || this instanceof com.pla.annoyingvillagers.entity.Herobrine7Entity || this instanceof com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity || this instanceof ShadowHerobrineEntity) {
/*      */         
/*  973 */         placeObsidianBlockWhenInWater((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get());
/*  974 */       } else if (!(this instanceof NullEntity)) {
/*  975 */         placeObsidianBlockWhenInWater((Block)AnnoyingVillagersModBlocks.CRYING_OBSIDIAN_BLOCK.get());
/*      */       } 
/*      */       
/*  978 */       if (m_21023_(MobEffects.f_19600_) && m_21023_(MobEffects.f_19596_) && 
/*  979 */         m_21023_(MobEffects.f_19603_) && m_21023_(MobEffects.f_19606_) && (
/*  980 */         new Random()).nextBoolean()) {
/*  981 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.FULL_COWL
/*  982 */             .get(), 
/*  983 */             m_20185_(), m_20186_(), m_20189_(), 1, 0.3D, 1.2D, 0.3D, 0.0D);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  991 */       if (this.f_19797_ == 1) {
/*  992 */         if (this.renderPortal) {
/*  993 */           AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY
/*  994 */               .with(() -> this), new ClientboundHerobrinePortalFx(
/*  995 */                 m_20097_().m_252807_().m_82520_(0.0D, 1.5D, 0.0D)));
/*      */           
/*  997 */           this.renderPortal = false;
/*      */         } 
/*  999 */         if (this.initialSpawn) {
/* 1000 */           m_21557_(true);
/* 1001 */           if (getLivingEntityPatch() != null && !m_9236_().m_5776_())
/* 1002 */             if (this instanceof ReaperHerobrineEntity || this instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity)
/* 1003 */             { getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.GLOWING_AGONY_GUARD, 0.0F); }
/* 1004 */             else { HerobrineMob herobrineMob = this; if (herobrineMob instanceof AegisHerobrineEntity) { AegisHerobrineEntity aegisHerobrineEntity = (AegisHerobrineEntity)herobrineMob;
/*      */                 
/* 1006 */                 aegisHerobrineEntity.getPersistentData().m_128379_("init_animation", true); }
/* 1007 */               else if (!(this instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity) && !(this instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity))
/* 1008 */               { getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.HEROBRINE_ANIMATE, 0.0F); }
/*      */                }
/*      */              
/* 1011 */           this.initialSpawn = false;
/*      */         } 
/*      */       } 
/*      */       
/* 1015 */       if (!this.neverRecall) {
/*      */         
/* 1017 */         int remaining = --this.recallTicks;
/*      */         
/* 1019 */         if (remaining == 40) {
/* 1020 */           AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 1021 */               .with(() -> this), new ClientboundHerobrinePortalFx(new Vec3(
/* 1022 */                   m_20185_(), m_20186_(), m_20189_())));
/*      */           
/* 1024 */           m_5496_((SoundEvent)AnnoyingVillagersModSounds.PORTAL_NATURAL.get(), 1.0F, 1.0F);
/* 1025 */           HerobrinePortalUtil.sinkIntoGround(serverLevel, (LivingEntity)this, 0.06D);
/*      */         } 
/* 1027 */         if (remaining <= 0) {
/* 1028 */           ((MinecraftServer)Objects.<MinecraftServer>requireNonNull(m_9236_().m_7654_())).m_6846_().m_240416_((Component)Component.m_237113_(getChatName() + " " + getChatName()), false);
/* 1029 */           m_146870_();
/*      */         } 
/*      */       } 
/*      */       
/* 1033 */       if (this.protectEntity == null && this.protectUUID != null) {
/* 1034 */         final Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.protectUUID);
/* 1035 */         if (entity instanceof EliteHerobrineKnockedEntity) { EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = (EliteHerobrineKnockedEntity)entity;
/* 1036 */           this.protectEntity = eliteHerobrineKnockedEntity; }
/*      */         else
/* 1038 */         { this.protectEntity = null; }
/*      */       
/*      */       } 
/* 1041 */       if (this.protectEntity != null && !this.protectEntity.m_6084_()) {
/* 1042 */         this.protectEntity = null;
/* 1043 */         this.protectUUID = null;
/* 1044 */         this.recallTicks = 41;
/*      */       } 
/*      */       
/* 1047 */       if (this.firstPossessedHerobrine == null && this.firstPossessedHerobrineUuid != null) {
/* 1048 */         this.firstPossessedHerobrine = ((ServerLevel)m_9236_()).m_8791_(this.firstPossessedHerobrineUuid);
/*      */       }
/* 1050 */       if (this.secondPossessedHerobrine == null && this.secondPossessedHerobrineUuid != null) {
/* 1051 */         this.secondPossessedHerobrine = ((ServerLevel)m_9236_()).m_8791_(this.secondPossessedHerobrineUuid);
/*      */       }
/* 1053 */       if (this.thirdPossessedHerobrine == null && this.thirdPossessedHerobrineUuid != null) {
/* 1054 */         this.thirdPossessedHerobrine = ((ServerLevel)m_9236_()).m_8791_(this.thirdPossessedHerobrineUuid);
/*      */       }
/* 1056 */       if (this.fourthPossessedHerobrine == null && this.fourthPossessedHerobrineUuid != null) {
/* 1057 */         this.fourthPossessedHerobrine = ((ServerLevel)m_9236_()).m_8791_(this.fourthPossessedHerobrineUuid);
/*      */       }
/*      */       
/* 1060 */       if (this.firstPossessedHerobrine != null && !this.firstPossessedHerobrine.m_6084_()) {
/* 1061 */         this.firstPossessedHerobrine = null;
/* 1062 */         this.firstPossessedHerobrineUuid = null;
/* 1063 */         if (this.sacrificing && getEmptyBoundClone() == 4) {
/* 1064 */           recoverAfterSacrificing();
/*      */         }
/* 1066 */         if (this.healing && getHealingHerobrine() == null) {
/* 1067 */           recoverAfterHealing();
/*      */         }
/*      */       } 
/* 1070 */       if (this.secondPossessedHerobrine != null && !this.secondPossessedHerobrine.m_6084_()) {
/* 1071 */         this.secondPossessedHerobrine = null;
/* 1072 */         this.secondPossessedHerobrineUuid = null;
/* 1073 */         if (this.sacrificing && getEmptyBoundClone() == 4) {
/* 1074 */           recoverAfterSacrificing();
/*      */         }
/* 1076 */         if (this.healing && getHealingHerobrine() == null) {
/* 1077 */           recoverAfterHealing();
/*      */         }
/*      */       } 
/* 1080 */       if (this.thirdPossessedHerobrine != null && !this.thirdPossessedHerobrine.m_6084_()) {
/* 1081 */         this.thirdPossessedHerobrine = null;
/* 1082 */         this.thirdPossessedHerobrineUuid = null;
/* 1083 */         if (this.sacrificing && getEmptyBoundClone() == 4) {
/* 1084 */           recoverAfterSacrificing();
/*      */         }
/* 1086 */         if (this.healing && getHealingHerobrine() == null) {
/* 1087 */           recoverAfterHealing();
/*      */         }
/*      */       } 
/* 1090 */       if (this.fourthPossessedHerobrine != null && !this.fourthPossessedHerobrine.m_6084_()) {
/* 1091 */         this.fourthPossessedHerobrine = null;
/* 1092 */         this.fourthPossessedHerobrineUuid = null;
/* 1093 */         if (this.sacrificing && getEmptyBoundClone() >= 4) {
/* 1094 */           recoverAfterSacrificing();
/*      */         }
/* 1096 */         if (this.healing && getHealingHerobrine() == null) {
/* 1097 */           recoverAfterHealing();
/*      */         }
/*      */       } 
/*      */       
/* 1101 */       if (this.sacrificingAnimationCooldown > 0) {
/* 1102 */         this.sacrificingAnimationCooldown--;
/*      */       }
/* 1104 */       if (this.sacrificingAnimationCooldown == 60) {
/* 1105 */         HerobrineMob herobrineMob = this; if (herobrineMob instanceof NullEntity) { NullEntity nullEntity = (NullEntity)herobrineMob;
/* 1106 */           nullEntity.setSpinningToAllWeaponsAvailableFor5seconds(); }
/*      */         else
/* 1108 */         { m_21008_(InteractionHand.MAIN_HAND, ItemStack.f_41583_);
/* 1109 */           m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_); }
/*      */         
/* 1111 */         if (getLivingEntityPatch() != null) {
/* 1112 */           getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.HEROBRINE_STAGE_CHANGE, 0.0F);
/*      */         }
/* 1114 */         AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 1115 */             .with(() -> this), new ClientboundHerobrinePortalFx(new Vec3(
/* 1116 */                 m_20185_(), m_20186_(), m_20189_())));
/*      */         
/* 1118 */         if (m_9236_() instanceof ServerLevel) {
/* 1119 */           m_5496_((SoundEvent)AnnoyingVillagersModSounds.PORTAL_NATURAL.get(), 1.0F, 1.0F);
/*      */         }
/* 1121 */         summonClonesForNextStage();
/*      */       } 
/* 1123 */       if (this.sacrificingAnimationCooldown == 50) {
/* 1124 */         this.sacrificing = true;
/* 1125 */         if (this.gregUUID != null) {
/* 1126 */           final Entity entity = serverLevel.m_8791_(this.gregUUID);
/* 1127 */           if (entity instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)entity; if (entity.m_6084_() && 
/* 1128 */               herobrineGregEntity.getLivingEntityPatch() != null) {
/* 1129 */               herobrineGregEntity.getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.PORTAL_SUMMON, 0.0F);
/*      */             } }
/*      */         
/*      */         } 
/*      */       } 
/* 1134 */       if (this.sacrificingAnimationCooldown == 10) {
/* 1135 */         this.sacrificing = true;
/* 1136 */         m_21557_(true);
/* 1137 */         if (this.gregUUID != null) {
/* 1138 */           final Entity entity = serverLevel.m_8791_(this.gregUUID);
/* 1139 */           if (entity instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)entity; if (entity.m_6084_())
/* 1140 */               herobrineGregEntity.m_21557_(false);  }
/*      */         
/*      */         } 
/* 1143 */         if (this.firstPossessedHerobrine != null) {
/* 1144 */           ((Mob)this.firstPossessedHerobrine).m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 30, 3, false, false));
/* 1145 */           clearHandAndDropItem(this.firstPossessedHerobrine);
/* 1146 */           final Entity entity = this.firstPossessedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/* 1147 */             lowShadowHerobrineCloneEntity.setSacrificing(true); }
/*      */           
/* 1149 */           this.firstPossessedHerobrine.m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(m_20185_(), m_20186_(), m_20189_()));
/* 1150 */           this.firstPossessedHerobrine.m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_UNDERSTOOD.get(), 1.0F, 1.0F);
/*      */         } 
/* 1152 */         if (this.secondPossessedHerobrine != null) {
/* 1153 */           ((Mob)this.secondPossessedHerobrine).m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 10, 3, false, false));
/* 1154 */           clearHandAndDropItem(this.secondPossessedHerobrine);
/* 1155 */           final Entity entity = this.secondPossessedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/* 1156 */             lowShadowHerobrineCloneEntity.setSacrificing(true); }
/*      */           
/* 1158 */           this.secondPossessedHerobrine.m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(m_20185_(), m_20186_(), m_20189_()));
/* 1159 */           this.secondPossessedHerobrine.m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_UNDERSTOOD.get(), 1.0F, 1.0F);
/*      */         } 
/* 1161 */         if (this.thirdPossessedHerobrine != null) {
/* 1162 */           ((Mob)this.thirdPossessedHerobrine).m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 10, 3, false, false));
/* 1163 */           clearHandAndDropItem(this.thirdPossessedHerobrine);
/* 1164 */           final Entity entity = this.thirdPossessedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/* 1165 */             lowShadowHerobrineCloneEntity.setSacrificing(true); }
/*      */           
/* 1167 */           this.thirdPossessedHerobrine.m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(m_20185_(), m_20186_(), m_20189_()));
/* 1168 */           this.thirdPossessedHerobrine.m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(m_20185_(), m_20186_(), m_20189_()));
/* 1169 */           this.thirdPossessedHerobrine.m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_UNDERSTOOD.get(), 1.0F, 1.0F);
/*      */         } 
/* 1171 */         if (this.fourthPossessedHerobrine != null) {
/* 1172 */           ((Mob)this.fourthPossessedHerobrine).m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 10, 3, false, false));
/* 1173 */           clearHandAndDropItem(this.fourthPossessedHerobrine);
/* 1174 */           final Entity entity = this.fourthPossessedHerobrine; if (entity instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = (LowShadowHerobrineCloneEntity)entity;
/* 1175 */             lowShadowHerobrineCloneEntity.setSacrificing(true); }
/*      */           
/* 1177 */           this.fourthPossessedHerobrine.m_7618_(EntityAnchorArgument.Anchor.EYES, new Vec3(m_20185_(), m_20186_(), m_20189_()));
/* 1178 */           this.fourthPossessedHerobrine.m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_UNDERSTOOD.get(), 1.0F, 1.0F);
/*      */         } 
/*      */       } 
/* 1181 */       if (this.sacrificing && this.sacrificingAnimationCooldown == 0) {
/* 1182 */         if (getEmptyBoundClone() == 4) {
/* 1183 */           m_21557_(false);
/*      */           return;
/*      */         } 
/* 1186 */         m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 5, 3, false, false));
/* 1187 */         if (getLivingEntityPatch() != null) {
/* 1188 */           getLivingEntityPatch().playAnimationSynchronized((AssetAccessor)AVAnimations.HEROBRINE_STAGE_CHANGE, 0.0F);
/*      */         }
/* 1190 */         HerobrineMob herobrineMob = this; if (herobrineMob instanceof NullEntity) { NullEntity nullEntity = (NullEntity)herobrineMob; if (this.f_19797_ % 100 == 0)
/* 1191 */             nullEntity.setSpinningToAllWeaponsAvailableFor5seconds();  }
/*      */       
/*      */       } 
/* 1194 */       if (this.secondFormHitLeft == 0 && this.state == 1) {
/* 1195 */         this.state = 0;
/*      */       }
/* 1197 */       if (this.f_19797_ % 20 == 0 && this.sacrificing && this.sacrificingAnimationCooldown == 0) {
/* 1198 */         AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 1199 */             .with(() -> this), new ClientboundLitePortalFx(new Vec3(
/* 1200 */                 m_20185_(), m_20186_(), m_20189_())));
/*      */       } }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void clearHandAndDropItem(Entity entity) {
/* 1208 */     LivingEntity livingentity = (LivingEntity)entity;
/*      */ 
/*      */     
/* 1211 */     if (!m_9236_().m_5776_()) {
/* 1212 */       ItemStack itemstack = livingentity.m_21205_();
/* 1213 */       ItemEntity itementity = new ItemEntity(m_9236_(), entity.m_20185_(), entity.m_20186_() + 1.0D, entity.m_20189_(), itemstack);
/* 1214 */       itementity.m_32010_(10);
/* 1215 */       m_9236_().m_7967_((Entity)itementity);
/* 1216 */       ((LivingEntity)entity).m_21008_(InteractionHand.MAIN_HAND, ItemStack.f_41583_);
/*      */       
/* 1218 */       itemstack = livingentity.m_21206_();
/* 1219 */       itementity = new ItemEntity(m_9236_(), entity.m_20185_(), entity.m_20186_() + 1.0D, entity.m_20189_(), itemstack);
/* 1220 */       itementity.m_32010_(10);
/* 1221 */       m_9236_().m_7967_((Entity)itementity);
/* 1222 */       ((LivingEntity)entity).m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/*      */     } 
/*      */   }
/*      */   public void summonClonesForNextStage() {
/*      */     ServerLevel server;
/* 1227 */     Level level = m_9236_(); if (level instanceof ServerLevel) { server = (ServerLevel)level; }
/*      */     else { return; }
/* 1229 */      float yaw = m_146908_();
/* 1230 */     Vec3 forward = Vec3.m_82498_(0.0F, yaw).m_82541_();
/* 1231 */     Vec3 right = (new Vec3(-forward.f_82481_, 0.0D, forward.f_82479_)).m_82541_();
/*      */     
/* 1233 */     double fwdDist = Math.max(3.0D, m_20205_() * 3.0D);
/* 1234 */     double sideDist = Math.max(3.0D, m_20205_() * 3.0D);
/*      */     
/* 1236 */     double y = m_20186_() + 0.01D;
/*      */     
/* 1238 */     Vec3 posFront = m_20182_().m_82549_(forward.m_82490_(fwdDist));
/* 1239 */     Vec3 posBack = m_20182_().m_82546_(forward.m_82490_(fwdDist));
/* 1240 */     Vec3 posLeft = m_20182_().m_82546_(right.m_82490_(sideDist));
/* 1241 */     Vec3 posRight = m_20182_().m_82549_(right.m_82490_(sideDist));
/*      */     
/* 1243 */     summonLowCloneAt(server, new Vec3(posFront.f_82479_, y, posFront.f_82481_), 1);
/* 1244 */     summonLowCloneAt(server, new Vec3(posLeft.f_82479_, y, posLeft.f_82481_), 2);
/* 1245 */     summonLowCloneAt(server, new Vec3(posRight.f_82479_, y, posRight.f_82481_), 3);
/* 1246 */     summonLowCloneAt(server, new Vec3(posBack.f_82479_, y, posBack.f_82481_), 4);
/*      */   }
/*      */   
/*      */   private ItemStack randomDamage(ItemStack itemStack) {
/* 1250 */     int maxDamage = itemStack.m_41776_();
/* 1251 */     itemStack.m_41721_((new Random()).nextInt(maxDamage / 3, maxDamage * 3 / 4));
/* 1252 */     return itemStack;
/*      */   }
/*      */   
/*      */   private void equipGearForLowClone(Mob mob) {
/* 1256 */     if (this.f_19796_.m_188501_() < 0.3F) {
/* 1257 */       mob.m_8061_(EquipmentSlot.HEAD, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_HELMET.get())));
/*      */     }
/* 1259 */     if (this.f_19796_.m_188501_() < 0.3F) {
/* 1260 */       mob.m_8061_(EquipmentSlot.CHEST, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_CHESTPLATE.get())));
/*      */     }
/* 1262 */     if (this.f_19796_.m_188501_() < 0.3F) {
/* 1263 */       mob.m_8061_(EquipmentSlot.LEGS, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_LEGGINGS.get())));
/*      */     }
/* 1265 */     if (this.f_19796_.m_188501_() < 0.3F) {
/* 1266 */       mob.m_8061_(EquipmentSlot.FEET, randomDamage(new ItemStack((ItemLike)AnnoyingVillagersModItems.BROKEN_DIAMOND_BOOTS.get())));
/*      */     }
/*      */   }
/*      */   
/*      */   private void summonLowCloneAt(ServerLevel server, Vec3 pos, int bindSlot) {
/* 1271 */     LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity = new LowShadowHerobrineCloneEntity((EntityType)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (Level)server);
/* 1272 */     int surfaceY = server.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlockPos.m_274446_((Position)pos)).m_123342_();
/* 1273 */     lowShadowHerobrineCloneEntity.m_7678_(pos.f_82479_, surfaceY, pos.f_82481_, m_146908_(), m_146909_());
/* 1274 */     lowShadowHerobrineCloneEntity.setRenderPortal(false);
/* 1275 */     lowShadowHerobrineCloneEntity.setPossessedByEntity(this);
/* 1276 */     lowShadowHerobrineCloneEntity.setPossessedByUuid(m_20148_());
/* 1277 */     equipGearForLowClone((Mob)lowShadowHerobrineCloneEntity);
/* 1278 */     server.m_7967_((Entity)lowShadowHerobrineCloneEntity);
/* 1279 */     lowShadowHerobrineCloneEntity.m_21557_(true);
/* 1280 */     m_5496_((SoundEvent)AnnoyingVillagersModSounds.PORTAL_NATURAL.get(), 1.0F, 1.0F);
/* 1281 */     if (bindSlot == 1) {
/* 1282 */       this.firstPossessedHerobrine = (Entity)lowShadowHerobrineCloneEntity;
/* 1283 */       this.firstPossessedHerobrineUuid = lowShadowHerobrineCloneEntity.m_20148_();
/* 1284 */     } else if (bindSlot == 2) {
/* 1285 */       this.secondPossessedHerobrine = (Entity)lowShadowHerobrineCloneEntity;
/* 1286 */       this.secondPossessedHerobrineUuid = lowShadowHerobrineCloneEntity.m_20148_();
/* 1287 */     } else if (bindSlot == 3) {
/* 1288 */       this.thirdPossessedHerobrine = (Entity)lowShadowHerobrineCloneEntity;
/* 1289 */       this.thirdPossessedHerobrineUuid = lowShadowHerobrineCloneEntity.m_20148_();
/*      */     } else {
/* 1291 */       this.fourthPossessedHerobrine = (Entity)lowShadowHerobrineCloneEntity;
/* 1292 */       this.fourthPossessedHerobrineUuid = lowShadowHerobrineCloneEntity.m_20148_();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void m_142687_(@NotNull Entity.RemovalReason reason) {
/* 1298 */     super.m_142687_(reason);
/* 1299 */     if (!(m_9236_()).f_46443_) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (reason == Entity.RemovalReason.KILLED || reason == Entity.RemovalReason.DISCARDED)
/*      */         {
/* 1301 */           HerobrineMobData.get(serverLevel).releaseIfMatches(serverLevel, m_20148_()); }  }
/*      */        }
/*      */   
/*      */   }
/*      */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance, @NotNull MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
/* 1306 */     if (mobSpawnType == MobSpawnType.NATURAL || mobSpawnType == MobSpawnType.CHUNK_GENERATION) {
/* 1307 */       ServerLevel serverLevel = serverLevelAccessor.m_6018_();
/* 1308 */       HerobrineMobData herobrineMobData = HerobrineMobData.get(serverLevel);
/*      */       
/* 1310 */       if (!herobrineMobData.tryClaim(serverLevel, m_20148_())) {
/* 1311 */         m_146870_();
/* 1312 */         return null;
/*      */       } 
/*      */       
/* 1315 */       BlockPos blockPos = m_20097_();
/* 1316 */       int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, blockPos).m_123342_();
/* 1317 */       BlockPos spawnPos = new BlockPos(blockPos.m_123341_(), surfaceY, blockPos.m_123343_());
/* 1318 */       m_20035_(spawnPos, m_146908_(), m_146909_());
/* 1319 */       this.initialSpawn = false;
/*      */     } 
/*      */     
/* 1322 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
/* 1323 */     HerobrineUtil.initialSpawn((LevelAccessor)serverLevelAccessor, (Entity)this, this.recallTicks, mobSpawnType);
/* 1324 */     return returnSpawnGroupData;
/*      */   }
/*      */   
/*      */   public void m_5993_(@NotNull Entity entity, int i, @NotNull DamageSource damagesource) {
/* 1328 */     super.m_5993_(entity, i, damagesource);
/* 1329 */     HerobrineUtil.transformHerobrine((LevelAccessor)m_9236_(), m_20185_(), m_20186_(), m_20189_(), entity, (Entity)this);
/* 1330 */     m_5634_(m_21233_() / 10.0F);
/*      */   }
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\HerobrineMob.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */