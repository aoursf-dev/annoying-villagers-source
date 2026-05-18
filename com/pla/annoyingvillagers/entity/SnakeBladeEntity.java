/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.skill.DemoniacVoltageReaverSkill;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import com.pla.annoyingvillagers.util.SnakeBladeHit;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.EntityDataSerializers;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ClipContext;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.HitResult;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ 
/*     */ public class SnakeBladeEntity extends Entity {
/*  52 */   private static final EntityDataAccessor<Optional<UUID>> CREATOR_ID = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135041_);
/*     */   
/*  54 */   private static final EntityDataAccessor<Integer> FROM_ID = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135028_);
/*     */   
/*  56 */   private static final EntityDataAccessor<Integer> TARGET_COUNT = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135028_);
/*     */   
/*  58 */   private static final EntityDataAccessor<Integer> CURRENT_TARGET_ID = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135028_);
/*     */   
/*  60 */   private static final EntityDataAccessor<Float> PROGRESS = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  62 */   private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  64 */   private static final EntityDataAccessor<Boolean> RETRACTING = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135035_);
/*     */   
/*  66 */   private static final EntityDataAccessor<Boolean> HAS_BLADE = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135035_);
/*     */   
/*  68 */   private static final EntityDataAccessor<Boolean> ENCHANTED = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135035_);
/*     */   
/*  70 */   private static final EntityDataAccessor<Boolean> GUARD = SynchedEntityData.m_135353_(SnakeBladeEntity.class, EntityDataSerializers.f_135035_);
/*     */   
/*     */   public static final float MAX_EXTEND_TIME = 5.0F;
/*     */   
/*  74 */   private final List<Entity> previouslyTouched = new ArrayList<>();
/*     */   
/*     */   private boolean hasChained = false;
/*  77 */   public float prevProgress = 0.0F;
/*     */   
/*  79 */   private String guardDirection = null;
/*     */   
/*     */   public SnakeBladeEntity(EntityType<?> type, Level level) {
/*  82 */     super(type, level);
/*     */   }
/*     */   
/*     */   public SnakeBladeEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  86 */     this((EntityType)AnnoyingVillagersModEntities.SNAKE_BLADE.get(), level);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  91 */     return NetworkHooks.getEntitySpawningPacket(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_8097_() {
/*  96 */     this.f_19804_.m_135372_(CREATOR_ID, Optional.empty());
/*  97 */     this.f_19804_.m_135372_(FROM_ID, Integer.valueOf(-1));
/*  98 */     this.f_19804_.m_135372_(TARGET_COUNT, Integer.valueOf(0));
/*  99 */     this.f_19804_.m_135372_(CURRENT_TARGET_ID, Integer.valueOf(-1));
/* 100 */     this.f_19804_.m_135372_(PROGRESS, Float.valueOf(0.0F));
/* 101 */     this.f_19804_.m_135372_(DAMAGE, Float.valueOf((new Random()).nextFloat(10.0F, 15.0F)));
/* 102 */     this.f_19804_.m_135372_(RETRACTING, Boolean.valueOf(false));
/* 103 */     this.f_19804_.m_135372_(HAS_BLADE, Boolean.valueOf(true));
/* 104 */     this.f_19804_.m_135372_(ENCHANTED, Boolean.valueOf(false));
/* 105 */     this.f_19804_.m_135372_(GUARD, Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */   public void setEnchanted(boolean enchanted) {
/* 109 */     this.f_19804_.m_135381_(ENCHANTED, Boolean.valueOf(enchanted));
/*     */   }
/*     */   
/*     */   public boolean isEnchanted() {
/* 113 */     return ((Boolean)this.f_19804_.m_135370_(ENCHANTED)).booleanValue();
/*     */   }
/*     */   
/*     */   private float getBaseDamage() {
/* 117 */     return ((Float)this.f_19804_.m_135370_(DAMAGE)).floatValue();
/*     */   }
/*     */   
/*     */   public void setGuard(boolean guard) {
/* 121 */     this.f_19804_.m_135381_(GUARD, Boolean.valueOf(guard));
/*     */   }
/*     */   
/*     */   public boolean isGuard() {
/* 125 */     return ((Boolean)this.f_19804_.m_135370_(GUARD)).booleanValue();
/*     */   }
/*     */   
/*     */   public void setGuardDirection(String direction) {
/* 129 */     this.guardDirection = direction;
/* 130 */     this.f_19804_.m_135381_(GUARD, Boolean.valueOf((direction != null)));
/*     */   } public void increaseSkillPoint(Entity entity, float value) {
/*     */     Player player;
/*     */     ServerPlayerPatch serverPlayerPatch;
/* 134 */     if (entity instanceof Player) { player = (Player)entity; }
/*     */     else { return; }
/* 136 */      PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 137 */     if (playerPatch instanceof ServerPlayerPatch) { serverPlayerPatch = (ServerPlayerPatch)playerPatch; }
/*     */     else { return; }
/* 139 */      SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.DEMONIAC_VOLTAGE_REAVER);
/* 140 */     if (skillContainer == null)
/*     */       return; 
/* 142 */     DemoniacVoltageReaverSkill skill = (DemoniacVoltageReaverSkill)skillContainer.getSkill();
/* 143 */     float current = skillContainer.getResource();
/* 144 */     float needed = skillContainer.getNeededResource();
/* 145 */     float add = Math.min(value, needed);
/*     */     
/* 147 */     skill.setConsumptionSynchronize(skillContainer, current + add);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 152 */     if (getCreatorEntity() != null) {
/* 153 */       Entity entity = getCreatorEntity(); if (entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity;
/* 154 */         if (!(livingEntity.m_21205_().m_41720_() instanceof com.pla.annoyingvillagers.item.DemoniacVoltageReaverItem)) {
/* 155 */           m_146870_(); return;
/*     */         }  }
/*     */     
/* 158 */     }  HerobrineUtil.spawnEliteEffect(m_9236_(), m_20185_(), m_20186_(), m_20189_(), this);
/*     */     
/* 160 */     float progressBefore = getProgress();
/* 161 */     this.prevProgress = progressBefore;
/*     */     
/* 163 */     super.m_8119_();
/*     */     
/* 165 */     Entity creator = getCreatorEntity();
/*     */     
/* 167 */     if (!m_9236_().m_5776_() && isGuard() && this.f_19797_ % 5 == 0) {
/* 168 */       tickGuardAoe(creator);
/*     */     }
/*     */     
/* 171 */     updateProgressAndHandleRemoval(creator);
/* 172 */     if (m_213877_())
/*     */       return; 
/* 174 */     updateMovementAndAttack(creator);
/*     */     
/* 176 */     if (!m_9236_().m_5776_()) {
/* 177 */       handleChaining(creator);
/*     */     }
/*     */     
/* 180 */     applyVelocity();
/*     */   }
/*     */   
/*     */   private void tickGuardAoe(Entity creator) {
/* 184 */     double size = 2.0D;
/* 185 */     double radiusSqr = 4.0D;
/* 186 */     float knockBackStrength = 1.0F;
/*     */     
/* 188 */     LivingEntity living = (LivingEntity)creator, owner = (creator instanceof LivingEntity) ? living : null;
/*     */     
/* 190 */     for (LivingEntity target : m_9236_().m_6443_(LivingEntity.class, 
/*     */         
/* 192 */         m_20191_().m_82377_(2.0D, 2.0D, 2.0D), e -> 
/* 193 */         (e.m_6084_() && !e.m_5833_()))) {
/*     */       
/* 195 */       if (target == owner || (
/* 196 */         owner != null && (owner.m_7307_((Entity)target) || target.m_7307_((Entity)owner))))
/*     */         continue; 
/* 198 */       double dx0 = target.m_20185_() - m_20185_();
/* 199 */       double dy0 = target.m_20227_(0.5D) - m_20227_(0.5D);
/* 200 */       double dz0 = target.m_20189_() - m_20189_();
/* 201 */       if (dx0 * dx0 + dy0 * dy0 + dz0 * dz0 > 4.0D)
/*     */         continue; 
/* 203 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 204 */         serverLevel.m_8767_((ParticleOptions)EpicFightParticles.HIT_BLUNT
/* 205 */             .get(), 
/* 206 */             m_20185_(), m_20186_() + 1.5D, m_20189_() + 0.8D, 1, 0.1D, 0.1D, 0.1D, 1.0D); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 213 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.OBSIDIAN_HIT.get(), 1.0F, (float)(0.5D + Math.random() * 0.5D));
/*     */       
/* 215 */       LivingEntityPatch<?> targetPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)target, LivingEntityPatch.class);
/*     */ 
/*     */ 
/*     */       
/* 219 */       DamageSource src = (owner != null) ? m_9236_().m_269111_().m_269104_(this, (Entity)owner) : m_9236_().m_269111_().m_269264_();
/* 220 */       target.m_6469_(src, getBaseDamage() / 2.0F);
/* 221 */       EpicfightUtil.dealStaminaDamage(src, 1.0F, targetPatch, false);
/*     */       
/* 223 */       if (creator != null) {
/* 224 */         increaseSkillPoint(creator, 3.0F);
/*     */       }
/* 226 */       if (targetPatch != null) {
/* 227 */         targetPatch.knockBackEntity(m_20182_(), 1.0F); continue;
/*     */       } 
/* 229 */       double kbX = m_20185_() - target.m_20185_();
/* 230 */       double kbZ = m_20189_() - target.m_20189_();
/* 231 */       target.m_147240_(1.0D, kbX, kbZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateProgressAndHandleRemoval(Entity creator) {
/* 237 */     float progress = getProgress();
/*     */     
/* 239 */     if (!isRetracting() && progress < 5.0F) {
/* 240 */       setProgress(progress + 1.0F);
/* 241 */     } else if (isRetracting() && progress > 0.0F) {
/* 242 */       setProgress(progress - 1.0F);
/*     */     } 
/*     */     
/* 245 */     if (isRetracting() && getProgress() == 0.0F) {
/* 246 */       onFullyRetracted(creator);
/*     */     }
/*     */   }
/*     */   
/*     */   private void onFullyRetracted(Entity creator) {
/* 251 */     Entity from = getFromEntity();
/*     */     
/* 253 */     if (from instanceof SnakeBladeEntity) { SnakeBladeEntity parentSnakeBladeEntity = (SnakeBladeEntity)from;
/* 254 */       parentSnakeBladeEntity.setRetracting(true);
/* 255 */       updateLastFragment(parentSnakeBladeEntity); }
/*     */     else
/* 257 */     { updateLastFragment((SnakeBladeEntity)null);
/* 258 */       clearSnakeAnimationTag(creator);
/*     */       
/* 260 */       LivingEntityPatch<?> creatorPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(creator, LivingEntityPatch.class);
/* 261 */       if (creatorPatch != null) {
/* 262 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(creatorPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 263 */         if (dynamicAnimation == AVAnimations.SNAKE_BLADE || dynamicAnimation == AVAnimations.SNAKE_BLADE_GUARD) {
/* 264 */           creatorPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F);
/*     */         }
/*     */       }  }
/*     */ 
/*     */     
/* 269 */     m_142687_(Entity.RemovalReason.DISCARDED);
/*     */   }
/*     */   
/*     */   private void clearSnakeAnimationTag(Entity creator) {
/* 273 */     if (creator instanceof Player) { Player player = (Player)creator;
/* 274 */       for (ItemStack stack : (player.m_150109_()).f_35974_) {
/* 275 */         if (stack.m_150930_((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get())) {
/* 276 */           stack.m_41749_("SnakeAnimation");
/*     */         }
/*     */       }  }
/* 279 */     else if (creator instanceof LivingEntity) { LivingEntity living = (LivingEntity)creator;
/* 280 */       living.m_21205_().m_41749_("SnakeAnimation"); }
/*     */   
/*     */   }
/*     */   private void updateMovementAndAttack(Entity creator) {
/*     */     LivingEntity livingCreator;
/* 285 */     if (creator instanceof LivingEntity) { livingCreator = (LivingEntity)creator; }
/*     */     else { return; }
/* 287 */      Entity currentTarget = getToEntity();
/* 288 */     Vec3 targetPos = null;
/*     */     
/* 290 */     if (currentTarget != null) {
/* 291 */       targetPos = new Vec3(currentTarget.m_20185_(), currentTarget.m_20227_(0.4000000059604645D), currentTarget.m_20189_());
/* 292 */     } else if (this.guardDirection != null) {
/* 293 */       targetPos = SnakeBladeHit.guardTargetFor(livingCreator, this.guardDirection);
/*     */     } 
/*     */     
/* 296 */     if (targetPos != null) {
/* 297 */       Vec3 delta = targetPos.m_82546_(m_20182_());
/* 298 */       m_20256_(delta.m_82490_(0.5D));
/*     */     } 
/*     */     
/* 301 */     if (currentTarget != null && !(m_9236_()).f_46443_ && getProgress() >= 5.0F && 
/* 302 */       this.f_19797_ % 2 == 0) {
/* 303 */       tryAttackTarget(livingCreator, currentTarget);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void tryAttackTarget(LivingEntity creator, Entity target) {
/* 309 */     if (target == creator)
/*     */       return; 
/* 311 */     if (target.m_6469_(m_9236_().m_269111_().m_269104_(this, (Entity)creator), getBaseDamage())) {
/*     */       
/* 313 */       if (!this.previouslyTouched.contains(target)) {
/* 314 */         this.previouslyTouched.add(target);
/*     */       }
/*     */       
/* 317 */       increaseSkillPoint((Entity)creator, 5.0F);
/*     */       
/* 319 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 320 */         serverLevel.m_8767_((ParticleOptions)EpicFightParticles.HIT_BLUNT
/* 321 */             .get(), 
/* 322 */             m_20185_(), m_20186_() + 1.5D, m_20189_() + 0.8D, 1, 0.1D, 0.1D, 0.1D, 1.0D); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 329 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.OBSIDIAN_HIT.get(), 1.0F, (float)(0.5D + Math.random() * 0.5D));
/* 330 */       LivingEntityPatch<?> targetPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(target, LivingEntityPatch.class);
/* 331 */       if (targetPatch != null) {
/* 332 */         EpicfightUtil.dealStaminaDamageByPercentage(
/* 333 */             m_9236_().m_269111_().m_269104_(this, (Entity)creator), targetPatch, 0.5D, true);
/*     */       }
/*     */       
/* 336 */       if (target instanceof LivingEntity) { LivingEntity livingTarget = (LivingEntity)target;
/* 337 */         float strength = 3.0F;
/* 338 */         double dx = m_20185_() - target.m_20185_();
/* 339 */         double dz = m_20189_() - target.m_20189_();
/* 340 */         livingTarget.m_147240_(strength, dx, dz); }
/*     */     
/*     */     } 
/*     */   }
/*     */   private void handleChaining(Entity creator) {
/*     */     LivingEntity livingCreator;
/* 346 */     if (this.hasChained)
/*     */       return; 
/* 348 */     if (getTargetsHit() > 5) {
/* 349 */       setRetracting(true);
/*     */       
/*     */       return;
/*     */     } 
/* 353 */     if (creator instanceof LivingEntity) { livingCreator = (LivingEntity)creator; } else { return; }
/* 354 */      if (getProgress() < 5.0F)
/*     */       return; 
/* 356 */     if (this.guardDirection != null) {
/* 357 */       String nextDirection = nextGuardDirection(this.guardDirection);
/* 358 */       createChainGuard(nextDirection);
/* 359 */       this.hasChained = true;
/*     */       
/*     */       return;
/*     */     } 
/* 363 */     Entity closestValid = null;
/* 364 */     for (Entity candidate : m_9236_().m_45976_(LivingEntity.class, m_20191_().m_82400_(12.0D))) {
/* 365 */       if (candidate.equals(creator) || 
/* 366 */         this.previouslyTouched.contains(candidate) || 
/* 367 */         !isValidTarget(livingCreator, candidate) || 
/* 368 */         !hasLineOfSightTo(candidate))
/*     */         continue; 
/* 370 */       if (closestValid == null || m_20270_(candidate) < m_20270_(closestValid)) {
/* 371 */         closestValid = candidate;
/*     */       }
/*     */     } 
/*     */     
/* 375 */     if (closestValid != null) {
/* 376 */       createChain(closestValid);
/* 377 */       this.hasChained = true;
/*     */     } else {
/* 379 */       setRetracting(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void applyVelocity() {
/* 384 */     Vec3 vel = m_20184_();
/*     */     
/* 386 */     double x = m_20185_() + vel.f_82479_;
/* 387 */     double y = m_20186_() + vel.f_82480_;
/* 388 */     double z = m_20189_() + vel.f_82481_;
/*     */     
/* 390 */     m_20256_(vel.m_82490_(0.9900000095367432D));
/* 391 */     m_6034_(x, y, z);
/*     */   }
/*     */   
/*     */   private boolean isValidTarget(LivingEntity creator, Entity entity) {
/* 395 */     if (!creator.m_7307_(entity) && !entity.m_7307_((Entity)creator) && entity instanceof net.minecraft.world.entity.Mob) {
/* 396 */       return true;
/*     */     }
/*     */     
/* 399 */     return ((creator.m_21214_() != null && creator.m_21214_().m_20148_().equals(entity.m_20148_())) || (creator
/* 400 */       .m_21188_() != null && creator.m_21188_().m_20148_().equals(entity.m_20148_())));
/*     */   }
/*     */   
/*     */   private boolean hasLineOfSightTo(Entity target) {
/* 404 */     if (target.m_9236_() != m_9236_()) return false;
/*     */     
/* 406 */     Vec3 from = new Vec3(m_20185_(), m_20188_(), m_20189_());
/* 407 */     Vec3 to = new Vec3(target.m_20185_(), target.m_20188_(), target.m_20189_());
/*     */     
/* 409 */     if (to.m_82554_(from) > 128.0D) return false;
/*     */     
/* 411 */     return 
/* 412 */       (m_9236_().m_45547_(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)).m_6662_() == HitResult.Type.MISS);
/*     */   }
/*     */   private void updateLastFragment(SnakeBladeEntity lastSnakeBladeEntity) {
/*     */     Player player;
/* 416 */     Entity creator = getCreatorEntity();
/* 417 */     if (creator == null) {
/* 418 */       UUID uuid = getCreatorEntityUUID();
/* 419 */       if (uuid != null) {
/* 420 */         player = m_9236_().m_46003_(uuid);
/*     */       }
/*     */     } 
/*     */     
/* 424 */     if (player instanceof LivingEntity) { LivingEntity livingCreator = (LivingEntity)player;
/* 425 */       SnakeBladeHit.setLastFragment(livingCreator, lastSnakeBladeEntity); }
/*     */   
/*     */   }
/*     */   
/*     */   private void createChain(Entity nextTarget) {
/* 430 */     this.f_19804_.m_135381_(HAS_BLADE, Boolean.valueOf(false));
/*     */     
/* 432 */     SnakeBladeEntity child = (SnakeBladeEntity)((EntityType)AnnoyingVillagersModEntities.SNAKE_BLADE.get()).m_20615_(m_9236_());
/* 433 */     if (child == null)
/*     */       return; 
/* 435 */     if (isEnchanted()) {
/* 436 */       child.setEnchanted(true);
/*     */     }
/*     */     
/* 439 */     child.previouslyTouched.addAll(this.previouslyTouched);
/* 440 */     if (!child.previouslyTouched.contains(nextTarget)) {
/* 441 */       child.previouslyTouched.add(nextTarget);
/*     */     }
/*     */     
/* 444 */     child.setCreatorEntityUUID(getCreatorEntityUUID());
/* 445 */     child.setFromEntityID(m_19879_());
/* 446 */     child.setToEntityID(nextTarget.m_19879_());
/* 447 */     child.m_6034_(nextTarget.m_20185_(), nextTarget.m_20227_(0.4000000059604645D), nextTarget.m_20189_());
/* 448 */     child.setTargetsHit(getTargetsHit() + 1);
/*     */     
/* 450 */     updateLastFragment(child);
/* 451 */     m_9236_().m_7967_(child);
/*     */   }
/*     */   
/*     */   private void createChainGuard(String nextDirection) {
/* 455 */     this.f_19804_.m_135381_(HAS_BLADE, Boolean.valueOf(false));
/*     */     
/* 457 */     SnakeBladeEntity child = (SnakeBladeEntity)((EntityType)AnnoyingVillagersModEntities.SNAKE_BLADE.get()).m_20615_(m_9236_());
/* 458 */     if (child == null)
/*     */       return; 
/* 460 */     if (isEnchanted()) {
/* 461 */       child.setEnchanted(true);
/*     */     }
/*     */     
/* 464 */     child.previouslyTouched.addAll(this.previouslyTouched);
/* 465 */     child.setCreatorEntityUUID(getCreatorEntityUUID());
/* 466 */     child.setFromEntityID(m_19879_());
/* 467 */     child.setToEntityID(-1);
/* 468 */     child.setTargetsHit(getTargetsHit() + 1);
/* 469 */     child.setGuardDirection(nextDirection);
/*     */     
/* 471 */     Entity creator = getCreatorEntity();
/* 472 */     if (creator instanceof LivingEntity) { LivingEntity living = (LivingEntity)creator;
/* 473 */       Vec3 p = SnakeBladeHit.guardTargetFor(living, nextDirection);
/* 474 */       child.m_6034_(p.f_82479_, p.f_82480_, p.f_82481_); }
/*     */     else
/* 476 */     { child.m_20359_(this); }
/*     */ 
/*     */     
/* 479 */     updateLastFragment(child);
/* 480 */     m_9236_().m_7967_(child);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource pSource, float amount) {
/* 485 */     if (!m_9236_().m_5776_()) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (!pSource.m_276093_(DamageTypes.f_268612_))
/* 486 */           EpicfightUtil.damageBlocked(pSource, this, serverLevel);  }
/*     */        }
/* 488 */      return false;
/*     */   }
/*     */   
/*     */   private static String nextGuardDirection(String current) {
/* 492 */     if ("forward_left".equalsIgnoreCase(current)) return "forward_right"; 
/* 493 */     if ("forward_right".equalsIgnoreCase(current)) return "backward_right"; 
/* 494 */     if ("backward_right".equalsIgnoreCase(current)) return "backward_left"; 
/* 495 */     return "forward_left";
/*     */   }
/*     */   
/*     */   public UUID getCreatorEntityUUID() {
/* 499 */     return ((Optional<UUID>)this.f_19804_.m_135370_(CREATOR_ID)).orElse(null);
/*     */   }
/*     */   
/*     */   public void setCreatorEntityUUID(UUID id) {
/* 503 */     this.f_19804_.m_135381_(CREATOR_ID, Optional.ofNullable(id));
/*     */   }
/*     */   
/*     */   public Entity getCreatorEntity() {
/* 507 */     UUID uuid = getCreatorEntityUUID();
/* 508 */     if (uuid != null && !(m_9236_()).f_46443_) { Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 509 */         return serverLevel.m_8791_(uuid); }
/*     */        }
/* 511 */      return null;
/*     */   }
/*     */   
/*     */   public int getFromEntityID() {
/* 515 */     return ((Integer)this.f_19804_.m_135370_(FROM_ID)).intValue();
/*     */   }
/*     */   
/*     */   public void setFromEntityID(int id) {
/* 519 */     this.f_19804_.m_135381_(FROM_ID, Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public Entity getFromEntity() {
/* 523 */     int id = getFromEntityID();
/* 524 */     return (id == -1) ? null : m_9236_().m_6815_(id);
/*     */   }
/*     */   
/*     */   public int getToEntityID() {
/* 528 */     return ((Integer)this.f_19804_.m_135370_(CURRENT_TARGET_ID)).intValue();
/*     */   }
/*     */   
/*     */   public void setToEntityID(int id) {
/* 532 */     this.f_19804_.m_135381_(CURRENT_TARGET_ID, Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   public Entity getToEntity() {
/* 536 */     int id = getToEntityID();
/* 537 */     return (id == -1) ? null : m_9236_().m_6815_(id);
/*     */   }
/*     */   
/*     */   public int getTargetsHit() {
/* 541 */     return ((Integer)this.f_19804_.m_135370_(TARGET_COUNT)).intValue();
/*     */   }
/*     */   
/*     */   public void setTargetsHit(int count) {
/* 545 */     this.f_19804_.m_135381_(TARGET_COUNT, Integer.valueOf(count));
/*     */   }
/*     */   
/*     */   public float getProgress() {
/* 549 */     return ((Float)this.f_19804_.m_135370_(PROGRESS)).floatValue();
/*     */   }
/*     */   
/*     */   public void setProgress(float progress) {
/* 553 */     this.f_19804_.m_135381_(PROGRESS, Float.valueOf(progress));
/*     */   }
/*     */   
/*     */   public boolean isRetracting() {
/* 557 */     return ((Boolean)this.f_19804_.m_135370_(RETRACTING)).booleanValue();
/*     */   }
/*     */   
/*     */   public void setRetracting(boolean retract) {
/* 561 */     this.f_19804_.m_135381_(RETRACTING, Boolean.valueOf(retract));
/*     */   }
/*     */   
/*     */   public boolean hasBlade() {
/* 565 */     return ((Boolean)this.f_19804_.m_135370_(HAS_BLADE)).booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7378_(@NotNull CompoundTag tag) {}
/*     */ 
/*     */   
/*     */   protected void m_7380_(@NotNull CompoundTag tag) {}
/*     */ 
/*     */   
/*     */   public boolean isCreator(Entity mob) {
/* 577 */     UUID creatorUuid = getCreatorEntityUUID();
/* 578 */     return (creatorUuid != null && mob.m_20148_().equals(creatorUuid));
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\SnakeBladeEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */