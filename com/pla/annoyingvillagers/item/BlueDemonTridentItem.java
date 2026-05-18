/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonThrownTridentEntity;
/*     */ import com.pla.annoyingvillagers.entity.ElectricAreaEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Vec3i;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.chat.MutableComponent;
/*     */ import net.minecraft.network.chat.Style;
/*     */ import net.minecraft.network.chat.TextColor;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.SwordItem;
/*     */ import net.minecraft.world.item.Tier;
/*     */ import net.minecraft.world.item.TooltipFlag;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ 
/*     */ public class BlueDemonTridentItem
/*     */   extends SwordItem {
/*     */   private static final double OWNER_HALF_BOX = 50.0D;
/*     */   private static final int DAMAGE_ZONE_DURATION = 100;
/*     */   private static final float DAMAGE_ZONE_DAMAGE = 4.0F;
/*     */   private static final int DAMAGE_ZONE_INTERVAL = 10;
/*     */   private static final float RELAUNCH_SPEED = 2.5F;
/*     */   public static final String TAG_STORM_ENERGY = "BlueDemonStormEnergy";
/*     */   public static final int MAX_STORM_ENERGY = 100;
/*     */   
/*     */   public BlueDemonTridentItem() {
/*  57 */     super(new Tier() {
/*     */           public int m_6609_() {
/*  59 */             return 1561;
/*     */           }
/*     */           
/*     */           public float m_6624_() {
/*  63 */             return 8.0F;
/*     */           }
/*     */           
/*     */           public float m_6631_() {
/*  67 */             return 3.5F;
/*     */           }
/*     */           
/*     */           public int m_6604_() {
/*  71 */             return 3;
/*     */           }
/*     */           
/*     */           public int m_6601_() {
/*  75 */             return 10;
/*     */           }
/*     */           @NotNull
/*     */           public Ingredient m_6282_() {
/*  79 */             return Ingredient.m_151265_();
/*     */           }
/*     */         },  3, -2.7F, new Item.Properties());
/*     */   }
/*     */   private static final int ENERGY_METER_STEPS = 18; private static final int ENERGY_COLOR = 5634047; private static final int ENERGY_DIM_COLOR = 4082253; private static final int ENERGY_TEXT_COLOR = 12450815; private static final int ENERGY_FULL_COLOR = 8191999; private static final int FESTIVAL_GATHER_SIZE = 10; private static final int FESTIVAL_GATHER_MAX_Y_DIFF = 6; private static final double FESTIVAL_GATHER_MIN_OWNER_DISTANCE_SQR = 2.25D;
/*     */   public static Vec3 getTridentThrowDirection(LivingEntity livingEntity, Vec3 startPos) {
/*  85 */     if (livingEntity instanceof Player) {
/*  86 */       return livingEntity.m_20252_(1.0F).m_82541_();
/*     */     }
/*     */     
/*  89 */     if (livingEntity instanceof Mob) { Mob mob = (Mob)livingEntity;
/*  90 */       LivingEntity target = mob.m_5448_();
/*  91 */       if (target != null && target.m_6084_()) {
/*  92 */         Vec3 targetPos = target.m_20182_().m_82520_(0.0D, target.m_20206_() * 0.7D, 0.0D);
/*  93 */         Vec3 dir = targetPos.m_82546_(startPos);
/*  94 */         if (dir.m_82556_() > 1.0E-7D) {
/*  95 */           return dir.m_82541_();
/*     */         }
/*     */       }  }
/*     */ 
/*     */     
/* 100 */     Vec3 fallback = livingEntity.m_20252_(1.0F);
/* 101 */     return (fallback.m_82556_() > 1.0E-7D) ? fallback.m_82541_() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_5812_(@NotNull ItemStack stack) {
/* 106 */     return (super.m_5812_(stack) || isFullyCharged(stack));
/*     */   }
/*     */   
/*     */   public static boolean isBlueDemonTrident(ItemStack stack) {
/* 110 */     return (!stack.m_41619_() && stack.m_41720_() instanceof BlueDemonTridentItem);
/*     */   }
/*     */   
/*     */   public static int getOnlyStormEnergy(ItemStack stack) {
/* 114 */     if (!isBlueDemonTrident(stack)) {
/* 115 */       return 0;
/*     */     }
/*     */     
/* 118 */     CompoundTag tag = stack.m_41783_();
/* 119 */     return (tag == null) ? 0 : Mth.m_14045_(tag.m_128451_("BlueDemonStormEnergy"), 0, 100);
/*     */   }
/*     */   
/*     */   public static boolean checkOnlyFullyCharged(ItemStack stack) {
/* 123 */     return (getOnlyStormEnergy(stack) >= 100);
/*     */   }
/*     */   
/*     */   public static int getStormEnergy(ItemStack stack) {
/* 127 */     if (!isBlueDemonTrident(stack)) {
/* 128 */       return 0;
/*     */     }
/*     */     
/* 131 */     CompoundTag tag = stack.m_41784_();
/* 132 */     return Mth.m_14045_(tag.m_128451_("BlueDemonStormEnergy"), 0, 100);
/*     */   }
/*     */   
/*     */   public static void setStormEnergy(ItemStack stack, int value) {
/* 136 */     if (!isBlueDemonTrident(stack)) {
/*     */       return;
/*     */     }
/*     */     
/* 140 */     stack.m_41784_().m_128405_("BlueDemonStormEnergy", Mth.m_14045_(value, 0, 100));
/*     */   }
/*     */   
/*     */   public static boolean isFullyCharged(ItemStack stack) {
/* 144 */     return (getStormEnergy(stack) >= 100);
/*     */   }
/*     */   
/*     */   public static void addStormEnergy(ItemStack stack, int amount) {
/* 148 */     if (!isBlueDemonTrident(stack) || amount <= 0) {
/*     */       return;
/*     */     }
/*     */     
/* 152 */     int current = getStormEnergy(stack);
/* 153 */     int added = Math.min(amount, 100 - current);
/*     */     
/* 155 */     if (added > 0) {
/* 156 */       setStormEnergy(stack, current + added);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void spawnDamageZones(ServerLevel serverLevel, LivingEntity owner) {
/* 165 */     ElectricAreaEntity ownerZone = new ElectricAreaEntity((Level)serverLevel, owner, owner.m_20182_(), 2.5D, 100, 4.0F, 10);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     serverLevel.m_7967_((Entity)ownerZone);
/*     */     
/* 173 */     for (BlueDemonThrownTridentEntity trident : getGroundedOwnerTridents(serverLevel, owner)) {
/*     */ 
/*     */ 
/*     */       
/* 177 */       ElectricAreaEntity tridentZone = new ElectricAreaEntity((Level)serverLevel, owner, trident.m_20182_(), 1.5D, 100, 4.0F, 10);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       serverLevel.m_7967_((Entity)tridentZone);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void relaunchGroundedTridents(ServerLevel serverLevel, LivingEntity owner) {
/* 188 */     relaunchGroundedTridents(serverLevel, owner, false);
/*     */   }
/*     */   
/*     */   public static void relaunchGroundedTridents(ServerLevel serverLevel, LivingEntity owner, boolean skipSummoned) {
/*     */     List<BlueDemonThrownTridentEntity> tridents;
/* 193 */     if (!skipSummoned) {
/* 194 */       tridents = getGroundedOwnerTridents(serverLevel, owner);
/*     */     } else {
/* 196 */       tridents = getGroundedOwnerTridentsSkipSummoned(serverLevel, owner);
/*     */     } 
/* 198 */     if (tridents.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 202 */     List<LivingEntity> targets = getNearbyTargets(serverLevel, owner);
/*     */     
/* 204 */     for (int i = 0; i < tridents.size(); i++) {
/* 205 */       BlueDemonThrownTridentEntity trident = tridents.get(i);
/*     */       
/* 207 */       LivingEntity target = targets.isEmpty() ? null : targets.get(i % targets.size());
/*     */ 
/*     */       
/* 210 */       Vec3 fallback = (target == null) ? getTridentThrowDirection(owner, trident.m_20182_()) : null;
/*     */       
/* 212 */       int extraDelay = 2 + i * 2 + serverLevel.f_46441_.m_188503_(3);
/* 213 */       trident.beginAnimatedRelaunch(target, fallback, 2.5F, 0.0F, extraDelay);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void summonLightningAtGroundedTridents(ServerLevel serverLevel, LivingEntity owner) {
/* 218 */     for (BlueDemonThrownTridentEntity trident : getAllOwnerTridents(serverLevel, owner)) {
/* 219 */       trident.summonLightningAtSelf();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void spawnMissingFestivalSupportTridents(ServerLevel serverLevel, BlueDemonEntity owner, int missingCount, List<BlueDemonThrownTridentEntity> occupiedTridents, boolean strikeWhenFinished) {
/* 230 */     if (missingCount <= 0) {
/*     */       return;
/*     */     }
/*     */     
/* 234 */     List<BlockPos> freePositions = getFreeGatherStandPositions(serverLevel, (LivingEntity)owner, occupiedTridents);
/* 235 */     int spawnCount = Math.min(missingCount, freePositions.size());
/*     */     
/* 237 */     for (int i = 0; i < spawnCount; i++) {
/* 238 */       BlueDemonThrownTridentEntity spawned = spawnFestivalSupportTrident(serverLevel, owner, freePositions
/*     */ 
/*     */           
/* 241 */           .get(i), strikeWhenFinished);
/*     */ 
/*     */       
/* 244 */       spawned.setSummonedGroundTridentFestival(true);
/* 245 */       occupiedTridents.add(spawned);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static double horizontalDistanceToOwnerSqr(BlockPos pos, LivingEntity owner) {
/* 250 */     double dx = pos.m_123341_() + 0.5D - owner.m_20185_();
/* 251 */     double dz = pos.m_123343_() + 0.5D - owner.m_20189_();
/* 252 */     return dx * dx + dz * dz;
/*     */   }
/*     */   
/*     */   private static List<BlockPos> buildRandomGatherStandPositions(ServerLevel serverLevel, LivingEntity owner) {
/* 256 */     List<BlockPos> result = new ArrayList<>();
/*     */     
/* 258 */     int half = 5;
/* 259 */     int startX = Mth.m_14107_(owner.m_20185_()) - half;
/* 260 */     int startZ = Mth.m_14107_(owner.m_20189_()) - half;
/* 261 */     int ownerY = Mth.m_14107_(owner.m_20186_());
/*     */     
/* 263 */     for (int x = 0; x < 10; x++) {
/* 264 */       for (int z = 0; z < 10; z++) {
/* 265 */         double sampleX = (startX + x) + 0.5D;
/* 266 */         double sampleZ = (startZ + z) + 0.5D;
/*     */         
/* 268 */         BlockPos candidate = findNearestStandablePosNearY(serverLevel, sampleX, sampleZ, ownerY);
/* 269 */         if (candidate != null)
/*     */         {
/*     */ 
/*     */           
/* 273 */           if (Math.abs(candidate.m_123342_() - owner.m_20183_().m_123342_()) <= 6) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 280 */             Vec3 center = new Vec3(candidate.m_123341_() + 0.5D, candidate.m_123342_() + 0.05D, candidate.m_123343_() + 0.5D);
/*     */ 
/*     */             
/* 283 */             if (center.m_82557_(owner.m_20182_()) >= 2.25D)
/*     */             {
/*     */ 
/*     */               
/* 287 */               if (!result.contains(candidate))
/* 288 */                 result.add(candidate.m_7949_());  } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 293 */     Collections.shuffle(result, new Random(serverLevel.f_46441_.m_188505_()));
/* 294 */     return result;
/*     */   }
/*     */   
/*     */   private static List<BlockPos> buildCompactGatherStandPositions(ServerLevel serverLevel, LivingEntity owner) {
/* 298 */     List<BlockPos> result = new ArrayList<>();
/*     */     
/* 300 */     int half = 5;
/* 301 */     int startX = Mth.m_14107_(owner.m_20185_()) - half;
/* 302 */     int startZ = Mth.m_14107_(owner.m_20189_()) - half;
/* 303 */     int ownerY = Mth.m_14107_(owner.m_20186_());
/*     */     
/* 305 */     for (int x = 0; x < 10; x++) {
/* 306 */       for (int z = 0; z < 10; z++) {
/* 307 */         double sampleX = (startX + x) + 0.5D;
/* 308 */         double sampleZ = (startZ + z) + 0.5D;
/*     */         
/* 310 */         BlockPos standPos = findNearestStandablePosNearY(serverLevel, sampleX, sampleZ, ownerY);
/* 311 */         if (standPos != null)
/*     */         {
/*     */ 
/*     */           
/* 315 */           if (Math.abs(standPos.m_123342_() - owner.m_20183_().m_123342_()) <= 6)
/*     */           {
/*     */ 
/*     */             
/* 319 */             if (horizontalDistanceToOwnerSqr(standPos, owner) >= 2.25D)
/*     */             {
/*     */ 
/*     */               
/* 323 */               if (!result.contains(standPos))
/* 324 */                 result.add(standPos.m_7949_());  }  } 
/*     */         }
/*     */       } 
/*     */     } 
/* 328 */     result.sort(
/* 329 */         Comparator.<BlockPos>comparingDouble(pos -> horizontalDistanceToOwnerSqr(pos, owner))
/* 330 */         .thenComparingInt(Vec3i::m_123342_)
/* 331 */         .thenComparingInt(Vec3i::m_123341_)
/* 332 */         .thenComparingInt(Vec3i::m_123343_));
/*     */ 
/*     */     
/* 335 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<BlockPos> getFreeGatherStandPositions(ServerLevel serverLevel, LivingEntity owner, List<BlueDemonThrownTridentEntity> occupiedTridents) {
/* 343 */     List<BlockPos> result = buildRandomGatherStandPositions(serverLevel, owner);
/*     */     
/* 345 */     result.removeIf(pos -> {
/*     */           Vec3 center = new Vec3(pos.m_123341_() + 0.5D, pos.m_123342_() + 0.05D, pos.m_123343_() + 0.5D);
/*     */ 
/*     */           
/*     */           for (BlueDemonThrownTridentEntity other : occupiedTridents) {
/*     */             if (!other.m_6084_()) {
/*     */               continue;
/*     */             }
/*     */ 
/*     */             
/*     */             if (other.m_20182_().m_82557_(center) < 0.25D) {
/*     */               return true;
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/*     */           return false;
/*     */         });
/*     */     
/* 364 */     return result;
/*     */   }
/*     */   
/*     */   public static void gatherGroundedTridentsAroundOwner(ServerLevel serverLevel, LivingEntity owner) {
/* 368 */     List<BlueDemonThrownTridentEntity> tridents = new ArrayList<>(getGroundedOwnerTridents(serverLevel, owner));
/* 369 */     if (tridents.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 373 */     List<BlockPos> standPositions = buildRandomGatherStandPositions(serverLevel, owner);
/* 374 */     if (standPositions.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 378 */     tridents.sort(
/* 379 */         Comparator.comparingLong(BlueDemonThrownTridentEntity::getSpawnSequence)
/* 380 */         .thenComparing(Entity::m_20148_));
/*     */ 
/*     */     
/* 383 */     int count = Math.min(tridents.size(), standPositions.size());
/* 384 */     for (int i = 0; i < count; i++) {
/* 385 */       ((BlueDemonThrownTridentEntity)tridents.get(i)).placeAsGroundedSupport(owner, standPositions.get(i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private static BlockPos findNearestStandablePosNearY(ServerLevel serverLevel, double x, double z, int originY) {
/* 396 */     int blockX = Mth.m_14107_(x);
/* 397 */     int blockZ = Mth.m_14107_(z);
/*     */     
/* 399 */     for (int offset = 0; offset <= 8; offset++) {
/* 400 */       BlockPos downPos = new BlockPos(blockX, originY - offset, blockZ);
/* 401 */       if (isValidFestivalStandPos(serverLevel, downPos)) {
/* 402 */         return downPos;
/*     */       }
/*     */       
/* 405 */       if (offset != 0) {
/* 406 */         BlockPos upPos = new BlockPos(blockX, originY + offset, blockZ);
/* 407 */         if (isValidFestivalStandPos(serverLevel, upPos)) {
/* 408 */           return upPos;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 413 */     return null;
/*     */   }
/*     */   
/*     */   private static boolean isValidFestivalStandPos(ServerLevel serverLevel, BlockPos standPos) {
/* 417 */     if (!serverLevel.m_46739_(standPos) || !serverLevel.m_46739_(standPos.m_7495_())) {
/* 418 */       return false;
/*     */     }
/*     */     
/* 421 */     if (!serverLevel.m_46859_(standPos)) {
/* 422 */       return false;
/*     */     }
/*     */     
/* 425 */     if (!serverLevel.m_6425_(standPos).m_76178_()) {
/* 426 */       return false;
/*     */     }
/*     */     
/* 429 */     if (!serverLevel.m_6425_(standPos.m_7495_()).m_76178_()) {
/* 430 */       return false;
/*     */     }
/*     */     
/* 433 */     return serverLevel.m_8055_(standPos.m_7495_()).m_280555_();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static BlueDemonThrownTridentEntity spawnFestivalSupportTrident(ServerLevel serverLevel, BlueDemonEntity owner, BlockPos standPos, boolean strikeWhenFinished) {
/* 442 */     ItemStack stack = owner.m_21205_();
/*     */     
/* 444 */     BlueDemonThrownTridentEntity trident = new BlueDemonThrownTridentEntity((Level)serverLevel, (LivingEntity)owner, stack);
/* 445 */     trident.assignSpawnSequence((LivingEntity)owner);
/* 446 */     trident.trimOldGroundedTridentsAroundOwnerOnSpawn();
/* 447 */     trident.beginFestivalGroundRise((LivingEntity)owner, standPos, strikeWhenFinished);
/*     */     
/* 449 */     serverLevel.m_7967_((Entity)trident);
/*     */     
/* 451 */     serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/* 452 */         .get(), standPos
/* 453 */         .m_123341_() + 0.5D, standPos
/* 454 */         .m_123342_() + 0.15D, standPos
/* 455 */         .m_123343_() + 0.5D, 12, 0.18D, 0.25D, 0.18D, 0.02D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 461 */     serverLevel.m_5594_(null, 
/*     */         
/* 463 */         BlockPos.m_274561_(standPos.m_123341_() + 0.5D, standPos.m_123342_(), standPos.m_123343_() + 0.5D), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY
/* 464 */         .get(), SoundSource.NEUTRAL, 0.8F, 0.9F + serverLevel.f_46441_
/*     */ 
/*     */         
/* 467 */         .m_188501_() * 0.2F);
/*     */ 
/*     */     
/* 470 */     return trident;
/*     */   }
/*     */   public static void summonMissingTridentAndAnimate(ServerLevel serverLevel, LivingEntity owner) {
/*     */     BlueDemonEntity blueDemon;
/* 474 */     if (owner instanceof BlueDemonEntity) { blueDemon = (BlueDemonEntity)owner; }
/*     */     else
/*     */     { return; }
/*     */     
/* 478 */     gatherGroundedTridentsAroundOwner(serverLevel, owner);
/*     */     
/* 480 */     List<BlueDemonThrownTridentEntity> existingTridents = new ArrayList<>(getAllOwnerTridents(serverLevel, owner));
/* 481 */     if (existingTridents.size() >= 20) {
/*     */       return;
/*     */     }
/*     */     
/* 485 */     spawnMissingFestivalSupportTridents(serverLevel, blueDemon, 20 - existingTridents
/*     */ 
/*     */         
/* 488 */         .size(), existingTridents, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void summonSuperLightningAtGroundedTridents(ServerLevel serverLevel, LivingEntity owner) {
/* 495 */     for (BlueDemonThrownTridentEntity trident : getGroundedOwnerTridents(serverLevel, owner)) {
/* 496 */       trident.summonSuperLightningAtSelf();
/*     */       
/* 498 */       if (trident.isSummonedGroundTridentFestival()) {
/* 499 */         trident.finishSummonedGroundTridentFestival();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static List<BlueDemonThrownTridentEntity> getAllOwnerTridents(ServerLevel serverLevel, LivingEntity owner) {
/* 505 */     return serverLevel.m_6443_(BlueDemonThrownTridentEntity.class, 
/*     */         
/* 507 */         makeOwnerBox((Entity)owner), trident -> 
/* 508 */         (trident.m_6084_() && trident.belongsToOwner(owner)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<BlueDemonThrownTridentEntity> getGroundedOwnerTridents(ServerLevel serverLevel, LivingEntity owner) {
/* 514 */     return serverLevel.m_6443_(BlueDemonThrownTridentEntity.class, 
/*     */         
/* 516 */         makeOwnerBox((Entity)owner), trident -> 
/* 517 */         (trident.m_6084_() && trident.isGroundedTrident() && trident.belongsToOwner(owner)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<BlueDemonThrownTridentEntity> getGroundedOwnerTridentsSkipSummoned(ServerLevel serverLevel, LivingEntity owner) {
/* 524 */     return serverLevel.m_6443_(BlueDemonThrownTridentEntity.class, 
/*     */         
/* 526 */         makeOwnerBox((Entity)owner), trident -> 
/* 527 */         (trident.m_6084_() && trident.isGroundedTrident() && !trident.isSummonedGroundTridentFestival() && trident.belongsToOwner(owner)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<LivingEntity> getNearbyTargets(ServerLevel serverLevel, LivingEntity owner) {
/* 535 */     List<LivingEntity> targets = serverLevel.m_6443_(LivingEntity.class, 
/*     */         
/* 537 */         makeOwnerBox((Entity)owner), target -> isValidTarget(owner, target));
/*     */ 
/*     */ 
/*     */     
/* 541 */     targets.sort(Comparator.comparingDouble(target -> target.m_20280_((Entity)owner)));
/* 542 */     return targets;
/*     */   }
/*     */   
/*     */   private static boolean isValidTarget(LivingEntity owner, LivingEntity target) {
/* 546 */     if (target == owner) {
/* 547 */       return false;
/*     */     }
/*     */     
/* 550 */     if (!target.m_6084_() || target.m_5833_()) {
/* 551 */       return false;
/*     */     }
/*     */     
/* 554 */     if (target instanceof Player) { Player player = (Player)target; if (player.m_7500_()) {
/* 555 */         return false;
/*     */       } }
/*     */     
/* 558 */     if (owner instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)owner; if (blueDemonEntity
/* 559 */         .getBbqEntity() != null && target == blueDemonEntity
/* 560 */         .getBbqEntity()) {
/* 561 */         return false;
/*     */       } }
/*     */     
/* 564 */     return !owner.m_7307_((Entity)target);
/*     */   }
/*     */   
/*     */   private static AABB makeOwnerBox(Entity owner) {
/* 568 */     return new AABB(owner
/* 569 */         .m_20185_() - 50.0D, owner
/* 570 */         .m_9236_().m_141937_(), owner
/* 571 */         .m_20189_() - 50.0D, owner
/* 572 */         .m_20185_() + 50.0D, owner
/* 573 */         .m_9236_().m_151558_(), owner
/* 574 */         .m_20189_() + 50.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6883_(@NotNull ItemStack itemstack, @NotNull Level level, @NotNull Entity entity, int i, boolean flag) {
/* 579 */     super.m_6883_(itemstack, level, entity, i, flag);
/* 580 */     if (flag && entity instanceof Player) { Player player = (Player)entity; Level level1 = entity.m_9236_(); if (level1 instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level1;
/* 581 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 582 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 583 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.TRIDENT_FESTIVAL);
/* 584 */           if (skillContainer != null && 
/* 585 */             skillContainer.getStack() >= 1) {
/* 586 */             double d0 = entity.m_20185_();
/* 587 */             double d1 = entity.m_20186_();
/* 588 */             double d2 = entity.m_20189_();
/* 589 */             if (Math.random() <= 0.1D) {
/* 590 */               serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/* 591 */                   .get(), entity
/* 592 */                   .m_20185_(), entity.m_20186_(), entity.m_20189_(), 1, 0.3D, 1.2D, 0.3D, 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 598 */               if (serverLevel.f_46441_.m_188500_() <= 0.8D) {
/* 599 */                 float volume = (float)Mth.m_216263_(serverLevel.f_46441_, 0.05D, 0.5D);
/* 600 */                 float pitch = (float)Mth.m_216263_(serverLevel.f_46441_, 0.8D, 1.1D);
/*     */                 
/* 602 */                 serverLevel.m_5594_(null, 
/*     */                     
/* 604 */                     BlockPos.m_274561_(d0, d1, d2), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY
/* 605 */                     .get(), SoundSource.NEUTRAL, volume, pitch);
/*     */               } 
/*     */             } 
/*     */           }  }
/*     */          }
/*     */        }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_7373_(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
/* 620 */     super.m_7373_(stack, level, tooltip, flag);
/* 621 */     int energy = getStormEnergy(stack);
/* 622 */     tooltip.add(Component.m_237115_("tooltip.annoyingvillagers.blue_demon_trident"));
/* 623 */     addStormChargeTooltip(tooltip, energy);
/*     */   }
/*     */   
/*     */   private static void addStormChargeTooltip(List<Component> tooltip, int energy) {
/* 627 */     tooltip.add(
/* 628 */         Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.blue_demon_trident_thunder_charge").getString())
/* 629 */         .m_130938_(style -> style.m_131136_(Boolean.valueOf(true)).m_131148_(TextColor.m_131266_(5634047))));
/*     */ 
/*     */     
/* 632 */     tooltip.add(
/* 633 */         Component.m_237113_("" + energy + " / 100")
/* 634 */         .m_130938_(style -> style.m_131148_(TextColor.m_131266_(12450815))));
/*     */ 
/*     */     
/* 637 */     tooltip.add(buildStormMeter(energy));
/*     */     
/* 639 */     if (energy >= 100) {
/* 640 */       tooltip.add(
/* 641 */           Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.thunder_charged").getString())
/* 642 */           .m_130938_(style -> style.m_131136_(Boolean.valueOf(true)).m_131148_(TextColor.m_131266_(8191999))));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static Component buildStormMeter(int energy) {
/* 648 */     int filledSteps = Math.round(energy / 100.0F * 18.0F);
/* 649 */     filledSteps = Mth.m_14045_(filledSteps, 0, 18);
/*     */     
/* 651 */     MutableComponent meter = Component.m_237119_();
/*     */     
/* 653 */     meter.m_7220_(
/* 654 */         (Component)Component.m_237113_("⚡ ")
/* 655 */         .m_130938_(style -> style.m_131148_(TextColor.m_131266_(5634047))));
/*     */ 
/*     */     
/* 658 */     for (int i = 0; i < 18; i++) {
/* 659 */       boolean filled = (i < filledSteps);
/*     */       
/* 661 */       meter.m_7220_(
/* 662 */           (Component)Component.m_237113_(filled ? "▰" : "▱")
/* 663 */           .m_130938_(style -> style.m_131148_(TextColor.m_131266_(filled ? 5634047 : 4082253))));
/*     */     } 
/*     */ 
/*     */     
/* 667 */     return (Component)meter;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\BlueDemonTridentItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */