/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ import com.pla.annoyingvillagers.block.ShadowObsidianBlock;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonThrownTridentEntity;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import com.pla.annoyingvillagers.entity.SteveEntity;
/*     */ import com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity;
/*     */ import com.pla.annoyingvillagers.entity.VillagerScoutEntity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.item.BlueDemonTridentItem;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*     */ import com.pla.annoyingvillagers.util.EscapeUtil;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.function.BiFunction;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.item.BlockItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.alchemy.PotionUtils;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.ClipContext;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionHandler;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*     */ import net.shelmarow.combat_evolution.tickTask.TickTask;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ 
/*     */ public class CombatCommon {
/*     */   public static boolean isHoldingWeapon(LivingEntity entity) {
/*  64 */     CapabilityItem capabilityItem = EpicFightCapabilities.getItemStackCapability(entity.m_21120_(InteractionHand.MAIN_HAND));
/*  65 */     return (capabilityItem.getWeaponCategory() != CapabilityItem.WeaponCategories.NOT_WEAPON && capabilityItem.getWeaponCategory() != CapabilityItem.WeaponCategories.FIST);
/*     */   }
/*     */   
/*     */   public static boolean targetIsInRange(LivingEntity attacker, LivingEntity target, double minDist, double maxDist, double maxAngleDegrees) {
/*  69 */     Vec3 targetPos = target.m_20182_();
/*  70 */     Vec3 playerPos = attacker.m_20182_();
/*     */     
/*  72 */     double distance = playerPos.m_82554_(targetPos);
/*  73 */     if (distance < minDist || distance > maxDist) return false;
/*     */     
/*  75 */     float yaw = target.m_146908_();
/*  76 */     double yawRad = Math.toRadians(yaw);
/*  77 */     Vec3 forward = (new Vec3(-Math.sin(yawRad), 0.0D, Math.cos(yawRad))).m_82541_();
/*  78 */     Vec3 toPlayer = playerPos.m_82546_(targetPos).m_82541_();
/*     */     
/*  80 */     double dot = forward.m_82526_(toPlayer);
/*  81 */     double angle = Math.toDegrees(Math.acos(dot));
/*     */     
/*  83 */     return (angle <= maxAngleDegrees);
/*     */   }
/*     */   
/*     */   public static boolean canExecute(LivingEntity attacker, LivingEntity victim, LivingEntityPatch<?> attackerEntityPatch, LivingEntityPatch<?> victimEntityPatch) {
/*  87 */     float maxDist = 4.0F;
/*  88 */     return (attacker.m_6084_() && victim.m_6084_() && ((Boolean)AnnoyingVillagersConfig.AV_MOB_CAN_EXECUTE
/*  89 */       .get()).booleanValue() && 
/*  90 */       !ExecutionHandler.isExecutingTarget(attacker, victim) && 
/*  91 */       ExecutionHandler.isTargetSupported(attackerEntityPatch, victimEntityPatch) && 
/*  92 */       isHoldingWeapon(attacker) && 
/*  93 */       targetIsInRange(attacker, victim, 0.0D, maxDist, 180.0D));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private static ExecutionHandler.ExecutionTransform calculateExecutionPosition(Level level, LivingEntity executor, LivingEntity target, Vec3 offset) {
/*  98 */     float yaw = target.m_146908_();
/*  99 */     ExecutionHandler.ExecutionTransform executionTransform = findPosAround(level, executor, target, offset, yaw, 360.0F, 0.5F);
/* 100 */     if (executionTransform == null) {
/* 101 */       Vec3 executorPos = executor.m_20182_();
/* 102 */       Vec3 targetPos = target.m_20182_();
/* 103 */       Vec3 deltaVec = executorPos.m_82546_(targetPos);
/* 104 */       float startAngle = (float)(Math.toDegrees(Mth.m_14136_(deltaVec.f_82481_, deltaVec.f_82479_)) - 90.0D);
/* 105 */       float allowedY = 0.5F;
/* 106 */       executionTransform = findPosAround(level, executor, target, offset, startAngle, 12.0F, allowedY);
/* 107 */       if (executionTransform == null) {
/* 108 */         allowedY = 0.95F;
/* 109 */         executionTransform = findPosAround(level, executor, target, offset, startAngle, 12.0F, allowedY);
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     return executionTransform;
/*     */   }
/*     */   @Nullable
/*     */   private static ExecutionHandler.ExecutionTransform findPosAround(Level level, LivingEntity executor, LivingEntity target, Vec3 offset, float startAngle, float angleStep, float allowedY) {
/*     */     float angleOffset;
/* 118 */     for (angleOffset = 0.0F; angleOffset < 360.0F; angleOffset += angleStep) {
/* 119 */       float yaw = startAngle + angleOffset;
/* 120 */       double rad = Math.toRadians(yaw);
/* 121 */       double forwardX = -Math.sin(rad);
/* 122 */       double forwardZ = Math.cos(rad);
/* 123 */       double rightX = Math.cos(rad);
/* 124 */       double rightZ = Math.sin(rad);
/* 125 */       double offsetX = forwardX * offset.f_82479_ + rightX * offset.f_82481_;
/* 126 */       double offsetY = offset.f_82480_;
/* 127 */       double offsetZ = forwardZ * offset.f_82479_ + rightZ * offset.f_82481_;
/* 128 */       Vec3 testPos = target.m_20182_().m_82520_(offsetX, offsetY, offsetZ);
/* 129 */       Vec3 executionPos = canStandHere(level, testPos, executor, target, allowedY);
/* 130 */       if (executionPos != null) {
/* 131 */         return new ExecutionHandler.ExecutionTransform(executionPos, yaw);
/*     */       }
/*     */     } 
/*     */     
/* 135 */     return null;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static Vec3 canStandHere(Level level, Vec3 pos, LivingEntity executor, LivingEntity target, float allowedY) {
/* 140 */     AABB entityBox = executor.m_20191_();
/* 141 */     double width = entityBox.m_82362_();
/* 142 */     double height = entityBox.m_82376_();
/*     */     float i;
/* 144 */     for (i = allowedY; i > -allowedY; i -= 0.05F) {
/* 145 */       BlockPos blockPosBelow = BlockPos.m_274561_(pos.f_82479_, pos.f_82480_ + i, pos.f_82481_);
/* 146 */       BlockState stateBelow = level.m_8055_(blockPosBelow);
/* 147 */       VoxelShape shapeBelow = stateBelow.m_60812_((BlockGetter)level, blockPosBelow);
/* 148 */       if (!shapeBelow.m_83281_()) {
/* 149 */         double offsetY = shapeBelow.m_83297_(Direction.Axis.Y);
/* 150 */         AABB checkBox = new AABB(pos.f_82479_ - width / 2.0D, blockPosBelow.m_123342_() + offsetY, pos.f_82481_ - width / 2.0D, pos.f_82479_ + width / 2.0D, blockPosBelow.m_123342_() + offsetY + height, pos.f_82481_ + width / 2.0D);
/* 151 */         Vec3 standPos = new Vec3(pos.f_82479_, blockPosBelow.m_123342_() + offsetY, pos.f_82481_);
/* 152 */         if (level.m_45772_(checkBox) && getEntityInView(executor, new Vec3(standPos.f_82479_, (executor.m_146892_()).f_82480_, standPos.f_82481_), (Entity)target) != null) {
/* 153 */           return standPos;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     return null;
/*     */   }
/*     */   
/*     */   private static LivingEntity getEntityInView(LivingEntity executor, Vec3 startPos, Entity target) {
/* 162 */     BlockHitResult blockHit = executor.m_9236_().m_45547_(new ClipContext(startPos, target.m_146892_(), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)executor));
/* 163 */     double blockDistanceSqr = (blockHit.m_6662_() != HitResult.Type.MISS) ? startPos.m_82557_(blockHit.m_82450_()) : Double.MAX_VALUE;
/* 164 */     double entityDistanceSqr = startPos.m_82557_(target.m_146892_());
/* 165 */     return (entityDistanceSqr < blockDistanceSqr && blockDistanceSqr - entityDistanceSqr > (target.m_20191_()).f_82288_) ? (LivingEntity)target : null;
/*     */   }
/*     */   
/*     */   public static boolean canExecute(MobPatch<?> mobPatch) {
/* 169 */     Mob attacker = (Mob)mobPatch.getOriginal();
/* 170 */     LivingEntity victim = attacker.m_5448_();
/* 171 */     if (victim == null || !victim.m_6084_()) return false;
/*     */     
/* 173 */     LivingEntityPatch<?> victimEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)victim, LivingEntityPatch.class);
/* 174 */     if (victimEntityPatch != null && (attacker instanceof PlayerNpcEntity || attacker instanceof AVNpc || attacker instanceof HerobrineMob || attacker instanceof com.pla.annoyingvillagers.entity.NullSkeletonEntity || attacker instanceof BlueDemonEntity)) {
/*     */ 
/*     */       
/* 177 */       AssetAccessor<? extends StaticAnimation> currentAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(victimEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*     */       
/* 179 */       if (ExecutionHandler.isTargetGuardBreak(currentAnimation, victimEntityPatch) && canExecute((LivingEntity)attacker, victim, (LivingEntityPatch<?>)mobPatch, victimEntityPatch)) {
/* 180 */         ExecutionTypeManager.Type executionType = ExecutionHandler.getExecutionType((LivingEntityPatch)mobPatch, victimEntityPatch);
/* 181 */         return (calculateExecutionPosition(attacker.m_9236_(), (LivingEntity)attacker, victim, executionType.offset()) != null);
/*     */       } 
/*     */     } 
/* 184 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isTargetKnockedDown(MobPatch<?> mobpatch) {
/* 188 */     LivingEntity victim = ((Mob)mobpatch.getOriginal()).m_5448_();
/* 189 */     if (victim != null) {
/* 190 */       LivingEntityPatch<?> victimPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)victim, LivingEntityPatch.class);
/* 191 */       if (victimPatch != null) {
/* 192 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(victimPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 193 */         return dynamicAnimation.get() instanceof yesman.epicfight.api.animation.types.KnockdownAnimation;
/*     */       } 
/* 195 */       return false;
/*     */     } 
/* 197 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canPerformNormalAttackLogic(MobPatch<?> mobpatch) {
/* 201 */     LivingEntity attacker = (LivingEntity)mobpatch.getOriginal();
/* 202 */     LivingEntity victim = ((Mob)mobpatch.getOriginal()).m_5448_();
/* 203 */     if (attacker instanceof SwordsmanHerobrineEntity) { SwordsmanHerobrineEntity swordsmanHerobrineEntity = (SwordsmanHerobrineEntity)attacker; if (swordsmanHerobrineEntity
/* 204 */         .m_21205_().m_41783_() != null && swordsmanHerobrineEntity
/* 205 */         .m_21205_().m_41783_().m_128441_("SnakeAnimation"))
/* 206 */         return false;  }
/*     */     
/* 208 */     if (victim != null) {
/* 209 */       if (isTargetKnockedDown(mobpatch) || canExecute(mobpatch) || canEscape(mobpatch)) {
/* 210 */         return false;
/*     */       }
/* 212 */       return !ExecutionHandler.isExecutingTarget(attacker, victim);
/*     */     } 
/*     */     
/* 215 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canJump(MobPatch<?> mobpatch) {
/* 219 */     return (((Mob)mobpatch.getOriginal()).m_20096_() && !((Mob)mobpatch.getOriginal()).m_20159_());
/*     */   }
/*     */   
/*     */   public static boolean canPerformTridentAttack(MobPatch<?> mobpatch) {
/* 223 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity; Level level = blueDemonEntity.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 224 */         List<BlueDemonThrownTridentEntity> tridents = BlueDemonTridentItem.getGroundedOwnerTridents(serverLevel, (LivingEntity)blueDemonEntity);
/* 225 */         return !tridents.isEmpty(); }
/*     */        }
/* 227 */      return false;
/*     */   }
/*     */   
/*     */   public static boolean isNotRiding(MobPatch<?> mobpatch) {
/* 231 */     return !((Mob)mobpatch.getOriginal()).m_20159_();
/*     */   }
/*     */   
/*     */   public static boolean isRiding(MobPatch<?> mobpatch) {
/* 235 */     return ((Mob)mobpatch.getOriginal()).m_20159_();
/*     */   }
/*     */   
/*     */   public static boolean canAttackWhileNotHealing(MobPatch<?> mobpatch) {
/* 239 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 240 */       return !playerNpcEntity.isHealing(); }
/*     */     
/* 242 */     entity = mobpatch.getOriginal(); if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 243 */       return !AVNpc.isHealing(); }
/*     */     
/* 245 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canEscape(MobPatch<?> mobpatch) {
/* 249 */     Mob entity = (Mob)mobpatch.getOriginal();
/* 250 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(mobpatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 251 */     if (dynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionAttackAnimation || dynamicAnimation.get() instanceof net.shelmarow.combat_evolution.gameassets.animation.ExecutionHitAnimation) {
/* 252 */       return false;
/*     */     }
/* 254 */     if (EscapeUtil.checkEscape(entity)) {
/* 255 */       if (entity instanceof HerobrineMob || entity instanceof BlueDemonEntity)
/* 256 */         return true; 
/* 257 */       AVNpc AVNpc = (AVNpc)entity; if (entity instanceof AVNpc && (new Random())
/* 258 */         .nextDouble() <= AVNpc.getPlaceBlockToParryChance())
/* 259 */         return true; 
/* 260 */       PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity; return (entity instanceof PlayerNpcEntity && (new Random())
/* 261 */         .nextDouble() <= playerNpcEntity.getPlaceBlockToParryChance());
/*     */     } 
/* 263 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isWrongWeapon(MobPatch<?> mobpatch) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual getOriginal : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   4: astore_1
/*     */     //   5: aload_0
/*     */     //   6: invokestatic canEscape : (Lyesman/epicfight/world/capabilities/entitypatch/MobPatch;)Z
/*     */     //   9: ifne -> 76
/*     */     //   12: aload_1
/*     */     //   13: instanceof net/minecraft/world/entity/LivingEntity
/*     */     //   16: ifeq -> 76
/*     */     //   19: aload_1
/*     */     //   20: checkcast net/minecraft/world/entity/LivingEntity
/*     */     //   23: astore_2
/*     */     //   24: aload_2
/*     */     //   25: getstatic net/minecraft/world/InteractionHand.MAIN_HAND : Lnet/minecraft/world/InteractionHand;
/*     */     //   28: invokevirtual m_21120_ : (Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/item/ItemStack;
/*     */     //   31: invokevirtual m_41720_ : ()Lnet/minecraft/world/item/Item;
/*     */     //   34: instanceof net/minecraft/world/item/SwordItem
/*     */     //   37: ifne -> 76
/*     */     //   40: aload_2
/*     */     //   41: getstatic net/minecraft/world/InteractionHand.MAIN_HAND : Lnet/minecraft/world/InteractionHand;
/*     */     //   44: invokevirtual m_21120_ : (Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/item/ItemStack;
/*     */     //   47: invokevirtual m_41720_ : ()Lnet/minecraft/world/item/Item;
/*     */     //   50: instanceof net/minecraft/world/item/AxeItem
/*     */     //   53: ifne -> 76
/*     */     //   56: aload_2
/*     */     //   57: getstatic net/minecraft/world/InteractionHand.MAIN_HAND : Lnet/minecraft/world/InteractionHand;
/*     */     //   60: invokevirtual m_21120_ : (Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/item/ItemStack;
/*     */     //   63: invokevirtual m_41720_ : ()Lnet/minecraft/world/item/Item;
/*     */     //   66: instanceof net/minecraft/world/item/BowItem
/*     */     //   69: ifne -> 76
/*     */     //   72: iconst_1
/*     */     //   73: goto -> 77
/*     */     //   76: iconst_0
/*     */     //   77: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #267	-> 0
/*     */     //   #269	-> 5
/*     */     //   #268	-> 6
/*     */     //   #269	-> 28
/*     */     //   #270	-> 44
/*     */     //   #271	-> 60
/*     */     //   #268	-> 77
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   24	52	2	livingEntity	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   0	78	0	mobpatch	Lyesman/epicfight/world/capabilities/entitypatch/MobPatch;
/*     */     //   5	73	1	entity	Lnet/minecraft/world/entity/Entity;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	78	0	mobpatch	Lyesman/epicfight/world/capabilities/entitypatch/MobPatch<*>;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean canBlueDemonPerformHealing(MobPatch<?> mobpatch) {
/* 275 */     if (canExecute(mobpatch)) return false; 
/* 276 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity;
/* 277 */       if (blueDemonEntity.getHealingCooldown() > 0) {
/* 278 */         return false;
/*     */       }
/* 280 */       return (blueDemonEntity.getHealingTick() == 0); }
/*     */     
/* 282 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canPerformEating(MobPatch<?> mobpatch) {
/* 286 */     if (canExecute(mobpatch)) return false; 
/* 287 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 288 */       if (playerNpcEntity.getGapCooldown() > 0) {
/* 289 */         return false;
/*     */       }
/* 291 */       return !playerNpcEntity.isHealing(); }
/*     */     
/* 293 */     entity = mobpatch.getOriginal(); if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 294 */       if (AVNpc.getGapCooldown() > 0) {
/* 295 */         return false;
/*     */       }
/* 297 */       return !AVNpc.isHealing(); }
/*     */     
/* 299 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canPerformGuarding(MobPatch<?> mobpatch) {
/* 303 */     if (canEscape(mobpatch)) return false; 
/* 304 */     Entity entity1 = mobpatch.getOriginal(); if (entity1 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity1;
/* 305 */       return !playerNpcEntity.isHealing(); }
/*     */     
/* 307 */     entity1 = mobpatch.getOriginal(); if (entity1 instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity1;
/* 308 */       return !AVNpc.isHealing(); }
/*     */     
/* 310 */     Entity entity2 = mobpatch.getOriginal(); if (entity2 instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity2; if (blueDemonEntity
/* 311 */         .getBbqEntity() != null) {
/* 312 */         LivingEntity livingEntity = blueDemonEntity.m_5448_(); if (livingEntity instanceof Mob) { Mob mob = (Mob)livingEntity;
/* 313 */           return !(mob.m_5448_() instanceof com.pla.annoyingvillagers.entity.BbqEntity); } 
/*     */       }  }
/* 315 */      return false;
/*     */   }
/*     */   
/*     */   public static boolean isTargetingHerobrineDragon(MobPatch<?> mobpatch) {
/* 319 */     return ((Mob)mobpatch.getOriginal()).m_5448_() instanceof com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */   }
/*     */   
/*     */   public static boolean canThrowEnderPearl(MobPatch<?> mobpatch) {
/* 323 */     if (((Mob)mobpatch.getOriginal()).m_20159_()) return false;
/*     */     
/* 325 */     LivingEntity target = ((Mob)mobpatch.getOriginal()).m_5448_();
/* 326 */     if (target == null || !target.m_6084_()) {
/* 327 */       return false;
/*     */     }
/*     */     
/* 330 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 331 */       if (playerNpcEntity.isHealing()) {
/* 332 */         return false;
/*     */       }
/* 334 */       return (playerNpcEntity.getEnderPearlCooldown() == 0); }
/*     */     
/* 336 */     entity = mobpatch.getOriginal(); if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 337 */       if (AVNpc.isHealing()) {
/* 338 */         return false;
/*     */       }
/* 340 */       return (AVNpc.getEnderPearlCooldown() == 0); }
/*     */     
/* 342 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canSwapToBow(MobPatch<?> mobpatch) {
/* 346 */     LivingEntity target = ((Mob)mobpatch.getOriginal()).m_5448_();
/* 347 */     if (target == null || !target.m_6084_()) {
/* 348 */       return false;
/*     */     }
/*     */     
/* 351 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 352 */       return (playerNpcEntity.isUseBow() && playerNpcEntity.getSwapToBowCooldown() == 0); }
/*     */ 
/*     */     
/* 355 */     entity = mobpatch.getOriginal(); if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 356 */       if (AVNpc instanceof SteveEntity || AVNpc instanceof com.pla.annoyingvillagers.entity.AngrySteveEntity || AVNpc instanceof com.pla.annoyingvillagers.entity.AlexEntity || AVNpc instanceof com.pla.annoyingvillagers.entity.ChrisEntity) {
/*     */         
/* 358 */         if (target instanceof HerobrineMob) {
/* 359 */           return false;
/*     */         }
/* 361 */         ResourceLocation key = BuiltInRegistries.f_256780_.m_7981_(target.m_6095_());
/* 362 */         if (key.m_135827_().equals("torchesbecomesunlight") && (key
/* 363 */           .m_135815_().equals("gun_knight_patriot") || key.m_135815_().equals("turret"))) {
/* 364 */           return false;
/*     */         }
/* 366 */         if (key.m_135827_().equals("nightfall_invade") && key
/* 367 */           .m_135815_().equals("arterius")) {
/* 368 */           return false;
/*     */         }
/* 370 */         if (AVNpc instanceof SteveEntity) { SteveEntity steveEntity = (SteveEntity)AVNpc;
/* 371 */           if (steveEntity.m_21120_(InteractionHand.OFF_HAND).m_41720_().equals(Items.f_42747_)) return false;
/*     */            }
/*     */       
/*     */       } 
/* 375 */       return (AVNpc.isUseBow() && AVNpc.getSwapToBowCooldown() == 0); }
/*     */ 
/*     */     
/* 378 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canSwitchWeapon(MobPatch<?> mobpatch) {
/* 382 */     LivingEntity target = ((Mob)mobpatch.getOriginal()).m_5448_();
/* 383 */     if (target == null || !target.m_6084_()) {
/* 384 */       return false;
/*     */     }
/*     */     
/* 387 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof SteveEntity) { SteveEntity steveEntity = (SteveEntity)entity;
/* 388 */       return ((steveEntity.getBlockDamage() == null && steveEntity.getSwapWeaponCooldown() == 0) || (steveEntity.getState() == 0 && steveEntity.m_21223_() <= 20.0F && !steveEntity.m_21205_().m_41720_().equals(Items.f_42388_))); }
/* 389 */      entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 390 */       return ((herobrineMob instanceof com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineEntity) && herobrineMob.getSwapWeaponCooldown() == 0); }
/* 391 */      entity = mobpatch.getOriginal(); if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity;
/* 392 */       return (blueDemonEntity.getState() == 3 && blueDemonEntity.getSwapWeaponCooldown() == 0); }
/*     */ 
/*     */     
/* 395 */     return false;
/*     */   }
/*     */   
/*     */   public static void performEnderPearlToTarget(MobPatch<?> mobpatch) {
/* 399 */     LivingEntity target = ((Mob)mobpatch.getOriginal()).m_5448_();
/* 400 */     if (target == null || !target.m_6084_()) {
/*     */       return;
/*     */     }
/*     */     
/* 404 */     LivingEntity entity = (LivingEntity)mobpatch.getOriginal();
/*     */     
/* 406 */     double dx = target.m_20185_() - entity.m_20185_();
/* 407 */     double dz = target.m_20189_() - entity.m_20189_();
/* 408 */     double dy = target.m_20188_() - entity.m_20188_();
/* 409 */     double horizontal = Math.sqrt(dx * dx + dz * dz);
/* 410 */     float yaw = (float)(Mth.m_14136_(dz, dx) * 57.2957763671875D) - 90.0F;
/* 411 */     float pitch = (float)-(Mth.m_14136_(dy, horizontal) * 57.2957763671875D);
/*     */     
/* 413 */     entity.m_146922_(yaw);
/* 414 */     entity.m_146926_(pitch);
/* 415 */     entity.m_5618_(yaw);
/* 416 */     entity.m_5616_(yaw);
/*     */     
/* 418 */     entity.f_19859_ = yaw;
/* 419 */     entity.f_19860_ = pitch;
/* 420 */     entity.f_20884_ = yaw;
/* 421 */     entity.f_20886_ = yaw;
/*     */     
/* 423 */     if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 424 */       playerNpcEntity.setEnderPearlCooldown(); }
/*     */ 
/*     */     
/* 427 */     if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 428 */       AVNpc.setEnderPearlCooldown(); }
/*     */ 
/*     */     
/* 431 */     CombatBehaviour.throwEnderPearl((Entity)entity, 0.0F);
/*     */   }
/*     */   
/*     */   public static void performEnderPearlAway(MobPatch<?> mobpatch) {
/* 435 */     LivingEntity target = ((Mob)mobpatch.getOriginal()).m_5448_();
/* 436 */     if (target == null || !target.m_6084_()) {
/*     */       return;
/*     */     }
/*     */     
/* 440 */     LivingEntity entity = (LivingEntity)mobpatch.getOriginal();
/*     */     
/* 442 */     double dx = entity.m_20185_() - target.m_20185_();
/* 443 */     double dz = entity.m_20189_() - target.m_20189_();
/*     */     
/* 445 */     float yaw = (float)(Mth.m_14136_(dz, dx) * 57.2957763671875D) - 90.0F;
/*     */     
/* 447 */     float basePitch = -15.0F;
/* 448 */     float randomPitchOffset = (entity.m_217043_().m_188501_() - 0.5F) * 10.0F;
/* 449 */     float randomYawOffset = (entity.m_217043_().m_188501_() - 0.5F) * 30.0F;
/*     */     
/* 451 */     float pitch = basePitch + randomPitchOffset;
/* 452 */     yaw += randomYawOffset;
/*     */     
/* 454 */     entity.m_146922_(yaw);
/* 455 */     entity.m_146926_(pitch);
/* 456 */     entity.m_5618_(yaw);
/* 457 */     entity.m_5616_(yaw);
/*     */     
/* 459 */     entity.f_19859_ = yaw;
/* 460 */     entity.f_19860_ = pitch;
/* 461 */     entity.f_20884_ = yaw;
/* 462 */     entity.f_20886_ = yaw;
/*     */     
/* 464 */     if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 465 */       playerNpcEntity.setEnderPearlCooldown(); }
/*     */     
/* 467 */     if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 468 */       AVNpc.setEnderPearlCooldown(); }
/*     */     
/* 470 */     CombatBehaviour.throwEnderPearl((Entity)entity, 0.0F);
/*     */   } public static void placeRandomFrontWall(MobPatch<?> mobpatch) {
/*     */     ServerLevel serverLevel;
/*     */     BlockState placeState;
/* 474 */     Mob mob = (Mob)mobpatch.getOriginal();
/* 475 */     Level level = mob.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else { return; }
/* 477 */      LivingEntity target = mob.m_5448_();
/*     */ 
/*     */     
/* 480 */     Direction dir = (target != null) ? Direction.m_122366_(target.m_20185_() - mob.m_20185_(), 0.0D, target.m_20189_() - mob.m_20189_()) : mob.m_6350_();
/*     */ 
/*     */     
/* 483 */     if (mob instanceof com.pla.annoyingvillagers.entity.HerobrineChrisEntity || mob instanceof com.pla.annoyingvillagers.entity.HerobrineCloneEntity) {
/* 484 */       placeState = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(false));
/* 485 */     } else if (mob instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineCloneEntity || mob instanceof com.pla.annoyingvillagers.entity.Herobrine7Entity || mob instanceof com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity || mob instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineEntity) {
/* 486 */       placeState = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(false));
/*     */     } else {
/* 488 */       ItemStack handStack = mob.m_21120_(InteractionHand.MAIN_HAND);
/* 489 */       placeState = Blocks.f_50652_.m_49966_();
/* 490 */       Item item = handStack.m_41720_(); if (item instanceof BlockItem) { BlockItem blockItem = (BlockItem)item;
/* 491 */         placeState = blockItem.m_40614_().m_49966_(); }
/*     */     
/*     */     } 
/*     */     
/* 495 */     Random random = new Random();
/* 496 */     int lanes = 1 + random.nextInt(3);
/* 497 */     float missChancePerLane = 0.25F;
/*     */     
/* 499 */     for (int dist = 1; dist <= lanes; dist++) {
/* 500 */       if (random.nextFloat() >= 0.25F) {
/*     */         
/* 502 */         int pattern = random.nextInt(11);
/* 503 */         int rot = random.nextInt(4);
/* 504 */         BiFunction<Integer, Integer, int[]> toWorld = getIntegerIntegerBiFunction((Entity)mob, rot);
/*     */         
/* 506 */         BlockPos baseXZ = mob.m_20183_().m_5484_(dir, dist);
/* 507 */         int topY = Mth.m_14107_(mob.m_20186_() + mob.m_20206_());
/*     */         
/* 509 */         int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, baseXZ).m_123342_();
/* 510 */         BlockPos projXZ = new BlockPos(baseXZ.m_123341_(), 0, baseXZ.m_123343_());
/*     */         
/* 512 */         for (int y = surfaceY; y <= topY; y++) {
/* 513 */           int layer = y - surfaceY;
/*     */           
/* 515 */           BlockPos center = new BlockPos(projXZ.m_123341_(), y, projXZ.m_123343_());
/* 516 */           if (!serverLevel.m_8055_(center).m_247087_())
/*     */             break; 
/* 518 */           placeIfReplaceable(serverLevel, center, placeState, mobpatch, mob);
/*     */           
/* 520 */           switch (pattern) { case 0:
/*     */             
/*     */             case 1:
/* 523 */               if (layer == 3) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }
/*     */             
/*     */             case 2:
/* 526 */               if (layer == 0) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[3][])[0] = new int[2]; (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[3][])[1] = new int[2]; (new int[2])[0] = 2; (new int[2])[1] = 0; (new int[3][])[2] = new int[2]; }
/* 527 */                if (layer == 1) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }
/*     */             
/*     */             
/*     */             case 3:
/* 531 */               if (layer == 1) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[2][])[0] = new int[2]; (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[2][])[1] = new int[2]; } 
/*     */             case 4:
/* 533 */               if (layer == 0) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[2][])[0] = new int[2]; (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[2][])[1] = new int[2]; } 
/*     */             case 5:
/* 535 */               (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2];
/*     */             case 6:
/* 537 */               if (layer <= 1) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; } 
/*     */             case 7:
/* 539 */               if (layer == 0) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; } 
/*     */             case 8:
/* 541 */               if (layer == 1) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; } 
/*     */             case 9:
/* 543 */               if (layer == 0) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; } 
/*     */             default:
/* 545 */               if (layer == 1) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }  break; }  int[][] extrasLocal = new int[0][];
/*     */ 
/*     */           
/* 548 */           for (int[] ab : extrasLocal) {
/* 549 */             int[] dzdx = toWorld.apply(Integer.valueOf(ab[0]), Integer.valueOf(ab[1]));
/* 550 */             int dx = dzdx[0];
/* 551 */             int dz = dzdx[1];
/*     */             
/* 553 */             BlockPos p = center.m_7918_(dx, 0, dz);
/* 554 */             placeIfReplaceable(serverLevel, p, placeState, mobpatch, mob);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   static BiFunction<Integer, Integer, int[]> getIntegerIntegerBiFunction(Entity anchor, int rot) {
/* 561 */     Direction facing = anchor.m_6350_();
/*     */     
/* 563 */     int fx = facing.m_122429_();
/* 564 */     int fz = facing.m_122431_();
/* 565 */     int rx = -fz;
/* 566 */     int rz = fx;
/*     */     
/* 568 */     for (int i = 0; i < rot; i++) {
/* 569 */       int nfx = rx, nfz = rz;
/* 570 */       int nrx = -fz, nrz = fx;
/* 571 */       fx = nfx; fz = nfz;
/* 572 */       rx = nrx; rz = nrz;
/*     */     } 
/*     */     
/* 575 */     int finalRx = rx;
/* 576 */     int finalFx = fx;
/* 577 */     int finalRz = rz;
/* 578 */     int finalFz = fz;
/*     */     
/* 580 */     return (a, b) -> new int[] { a.intValue() * finalRx + b.intValue() * finalFx, a.intValue() * finalRz + b.intValue() * finalFz };
/*     */   }
/*     */   
/*     */   private static void placeIfReplaceable(ServerLevel level, BlockPos pos, BlockState state, MobPatch<?> mobpatch, Mob mob) {
/* 584 */     if (mob instanceof HerobrineMob) {
/* 585 */       HerobrineUtil.placeIfReplaceable(level, pos, state, (Entity)mob);
/*     */     } else {
/* 587 */       if (!level.m_8055_(pos).m_247087_())
/* 588 */         return;  mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.PLACE_BLOCK, 0.0F);
/* 589 */       mob.m_5496_(SoundEvents.f_12447_, 2.0F, 1.0F);
/* 590 */       level.m_46597_(pos, state);
/*     */     } 
/*     */   }
/*     */   public static void performEscapeRunAway(final MobPatch<?> mobpatch) {
/*     */     Vec3 away;
/* 595 */     final Mob mob = (Mob)mobpatch.getOriginal();
/* 596 */     if (!(mob.m_9236_() instanceof ServerLevel))
/*     */       return; 
/* 598 */     LivingEntity target = mob.m_5448_();
/* 599 */     if (target != null) {
/* 600 */       mob.m_21563_().m_24960_((Entity)target, 30.0F, 30.0F);
/*     */     }
/*     */ 
/*     */     
/* 604 */     if (target != null) {
/* 605 */       Vec3 toTarget = new Vec3(target.m_20185_() - mob.m_20185_(), 0.0D, target.m_20189_() - mob.m_20189_());
/* 606 */       away = (toTarget.m_82556_() > 1.0E-6D) ? toTarget.m_82541_().m_82490_(-1.0D) : Vec3.f_82478_;
/*     */     } else {
/* 608 */       float yawRad = mob.f_20883_ * 0.017453292F;
/* 609 */       away = (new Vec3(-Mth.m_14031_(yawRad), 0.0D, Mth.m_14089_(yawRad))).m_82541_().m_82490_(-1.0D);
/*     */     } 
/* 611 */     if (away == Vec3.f_82478_)
/* 612 */       return;  Vec3 right = (new Vec3(-away.f_82481_, 0.0D, away.f_82479_)).m_82541_();
/*     */     
/* 614 */     mob.m_21573_().m_26573_();
/* 615 */     Random r = new Random();
/* 616 */     double backMag = 0.55D + r.nextDouble() * 0.35D;
/* 617 */     double strafeMag = (r.nextBoolean() ? true : -1) * (0.05D + r.nextDouble() * 0.15D);
/* 618 */     Vec3 impulse = away.m_82490_(backMag).m_82549_(right.m_82490_(strafeMag));
/*     */     
/* 620 */     mob.m_20256_(mob.m_20184_().m_82520_(impulse.f_82479_, 0.0D, impulse.f_82481_));
/* 621 */     mob.f_19812_ = true;
/*     */     
/* 623 */     int pulses = 2 + r.nextInt(2);
/* 624 */     for (int i = 1; i <= pulses; i++) {
/*     */       
/* 626 */       final Vec3 tail = away.m_82490_(0.16D + r.nextDouble() * 0.1D).m_82549_(right.m_82490_((r.nextDouble() - 0.5D) * 0.1D));
/* 627 */       int delay = i * 2;
/* 628 */       new DelayedTask(delay) {
/*     */           public void run() {
/* 630 */             if (!mob.m_6084_())
/* 631 */               return;  mob.m_20256_(mob.m_20184_().m_82520_(tail.f_82479_, 0.0D, tail.f_82481_));
/* 632 */             mob.f_19812_ = true;
/*     */           }
/*     */         };
/*     */     } 
/*     */     
/* 637 */     int jumpDelay = pulses * 2 + 1;
/* 638 */     new DelayedTask(jumpDelay) {
/*     */         public void run() {
/* 640 */           if (!mob.m_6084_() || !mob.m_20096_())
/*     */             return; 
/* 642 */           if (mob instanceof AVNpc) { AVNpc AVNpc = (AVNpc)mob;
/* 643 */             AVNpc.shortPillarJump(); }
/*     */           
/* 645 */           if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob;
/* 646 */             playerNpcEntity.shortPillarJump(); }
/*     */           
/* 648 */           mobpatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_JUMP, 0.0F);
/*     */         }
/*     */       };
/*     */     
/* 652 */     if (mob instanceof SteveEntity || mob instanceof com.pla.annoyingvillagers.entity.AngrySteveEntity || mob instanceof com.pla.annoyingvillagers.entity.HerobrineCloneEntity || mob instanceof com.pla.annoyingvillagers.entity.HerobrineChrisEntity || mob instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineCloneEntity || mob instanceof com.pla.annoyingvillagers.entity.Herobrine7Entity || mob instanceof com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity || mob instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineEntity)
/*     */     {
/*     */ 
/*     */       
/* 656 */       new DelayedTask(1) {
/*     */           public void run() {
/* 658 */             if (CombatCommon.isGroundWithin((Entity)mob, 3.0D)) {
/* 659 */               CombatCommon.placeRandomFrontWall(mobpatch);
/*     */             }
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean isGroundWithin(Entity e, double maxGap) {
/* 667 */     Level level = e.m_9236_();
/* 668 */     AABB bb = e.m_20191_();
/* 669 */     double feetY = bb.f_82289_;
/*     */     
/* 671 */     int x = Mth.m_14107_(e.m_20185_());
/* 672 */     int z = Mth.m_14107_(e.m_20189_());
/* 673 */     int startY = Mth.m_14107_(feetY - 1.0E-4D);
/*     */     
/* 675 */     int maxSteps = Mth.m_14165_(maxGap) + 2;
/*     */     
/* 677 */     BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, startY, z);
/*     */     
/* 679 */     for (int i = 0; i <= maxSteps; i++) {
/* 680 */       pos.m_142448_(startY - i);
/*     */       
/* 682 */       BlockState state = level.m_8055_((BlockPos)pos);
/* 683 */       if (!state.m_60795_()) {
/* 684 */         VoxelShape shape = state.m_60812_((BlockGetter)level, (BlockPos)pos);
/* 685 */         if (!shape.m_83281_()) {
/*     */           
/* 687 */           double topY = pos.m_123342_() + shape.m_83297_(Direction.Axis.Y);
/* 688 */           double gap = feetY - topY;
/*     */           
/* 690 */           if (gap >= -0.001D && gap <= maxGap + 0.001D)
/* 691 */             return true; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 695 */     return false;
/*     */   }
/*     */   public static void performEatingAnimation(MobPatch<?> mobpatch) {
/*     */     boolean isEnchanted;
/* 699 */     LivingEntity entity = (LivingEntity)mobpatch.getOriginal();
/*     */ 
/*     */     
/* 702 */     AVNpc AVNpc = (AVNpc)entity; if (entity instanceof AVNpc && (new Random())
/* 703 */       .nextDouble() <= AVNpc.getPlaceBlockToParryChance()) {
/* 704 */       entity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42437_));
/* 705 */       isEnchanted = true;
/*     */     } else {
/* 707 */       entity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42436_));
/* 708 */       isEnchanted = false;
/*     */     } 
/* 710 */     if ((new Random()).nextBoolean()) {
/* 711 */       CombatBehaviour.throwEnderPearl((Entity)entity, (new Random()).nextFloat(0.0F, 180.0F));
/* 712 */       if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 713 */         playerNpcEntity.setEnderPearlCooldown(); }
/*     */       
/* 715 */       if (entity instanceof AVNpc) { AVNpc = (AVNpc)entity;
/* 716 */         AVNpc.setEnderPearlCooldown(); }
/*     */     
/*     */     } else {
/* 719 */       performEscapeRunAway(mobpatch);
/*     */     } 
/*     */     
/* 722 */     if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 723 */       playerNpcEntity.setGapCooldown(); }
/*     */     
/* 725 */     if (entity instanceof AVNpc) { AVNpc = (AVNpc)entity;
/* 726 */       AVNpc.setGapCooldown(); }
/*     */ 
/*     */     
/* 729 */     CombatBehaviour.eatingGoldenApple((Entity)entity, (LevelAccessor)entity
/*     */         
/* 731 */         .m_9236_(), 20.0D, isEnchanted);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void performDrinkingAnimation(MobPatch<?> mobpatch) {
/* 738 */     LivingEntity entity = (LivingEntity)mobpatch.getOriginal();
/*     */     
/* 740 */     if (!(entity.m_9236_()).f_46443_) {
/* 741 */       ItemStack stack = PotionUtils.m_43549_(new ItemStack((ItemLike)Items.f_42589_), Potions.f_43581_);
/* 742 */       entity.m_21008_(InteractionHand.MAIN_HAND, stack);
/*     */     } 
/* 744 */     if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 745 */       AVNpc.setGapCooldown(); }
/*     */ 
/*     */     
/* 748 */     CombatBehaviour.drinkingHealingPotion((Entity)entity, (LevelAccessor)entity
/*     */         
/* 750 */         .m_9236_(), false, 20.0D);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void swapToBow(MobPatch<?> mobpatch) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual getOriginal : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   4: checkcast net/minecraft/world/entity/LivingEntity
/*     */     //   7: astore_1
/*     */     //   8: new net/minecraft/world/item/ItemStack
/*     */     //   11: dup
/*     */     //   12: getstatic net/minecraft/world/item/Items.f_42411_ : Lnet/minecraft/world/item/Item;
/*     */     //   15: invokespecial <init> : (Lnet/minecraft/world/level/ItemLike;)V
/*     */     //   18: astore_2
/*     */     //   19: aload_1
/*     */     //   20: instanceof com/pla/annoyingvillagers/clazz/AVNpc
/*     */     //   23: ifeq -> 36
/*     */     //   26: aload_1
/*     */     //   27: checkcast com/pla/annoyingvillagers/clazz/AVNpc
/*     */     //   30: astore_3
/*     */     //   31: aload_3
/*     */     //   32: invokevirtual getBowItem : ()Lnet/minecraft/world/item/ItemStack;
/*     */     //   35: astore_2
/*     */     //   36: aload_1
/*     */     //   37: instanceof com/pla/annoyingvillagers/entity/VillagerScoutCaptainEntity
/*     */     //   40: ifeq -> 59
/*     */     //   43: aload_2
/*     */     //   44: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44988_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   47: iconst_1
/*     */     //   48: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   51: aload_2
/*     */     //   52: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44989_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   55: iconst_1
/*     */     //   56: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   59: aload_1
/*     */     //   60: instanceof com/pla/annoyingvillagers/entity/RedVillagerGeneralEntity
/*     */     //   63: ifeq -> 74
/*     */     //   66: aload_2
/*     */     //   67: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44990_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   70: iconst_2
/*     */     //   71: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   74: aload_1
/*     */     //   75: instanceof com/pla/annoyingvillagers/entity/BlueVillagerGeneralEntity
/*     */     //   78: ifeq -> 89
/*     */     //   81: aload_2
/*     */     //   82: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44988_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   85: iconst_2
/*     */     //   86: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   89: aload_1
/*     */     //   90: instanceof com/pla/annoyingvillagers/entity/GreenVillagerGeneralEntity
/*     */     //   93: ifeq -> 112
/*     */     //   96: aload_2
/*     */     //   97: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44988_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   100: iconst_1
/*     */     //   101: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   104: aload_2
/*     */     //   105: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44990_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   108: iconst_1
/*     */     //   109: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   112: aload_1
/*     */     //   113: instanceof com/pla/annoyingvillagers/entity/PurpleVillagerGeneralEntity
/*     */     //   116: ifeq -> 127
/*     */     //   119: aload_2
/*     */     //   120: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44989_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   123: iconst_2
/*     */     //   124: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   127: aload_1
/*     */     //   128: instanceof com/pla/annoyingvillagers/entity/SteveEntity
/*     */     //   131: ifeq -> 147
/*     */     //   134: aload_1
/*     */     //   135: checkcast com/pla/annoyingvillagers/entity/SteveEntity
/*     */     //   138: astore_3
/*     */     //   139: aload_3
/*     */     //   140: invokevirtual getState : ()I
/*     */     //   143: iconst_1
/*     */     //   144: if_icmpeq -> 154
/*     */     //   147: aload_1
/*     */     //   148: instanceof com/pla/annoyingvillagers/entity/AngrySteveEntity
/*     */     //   151: ifeq -> 185
/*     */     //   154: aload_2
/*     */     //   155: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44988_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   158: iconst_2
/*     */     //   159: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   162: aload_2
/*     */     //   163: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44989_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   166: iconst_2
/*     */     //   167: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   170: aload_1
/*     */     //   171: instanceof com/pla/annoyingvillagers/entity/AngrySteveEntity
/*     */     //   174: ifeq -> 185
/*     */     //   177: aload_2
/*     */     //   178: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44990_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   181: iconst_2
/*     */     //   182: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   185: aload_1
/*     */     //   186: instanceof com/pla/annoyingvillagers/entity/AlexEntity
/*     */     //   189: ifeq -> 229
/*     */     //   192: aload_1
/*     */     //   193: checkcast com/pla/annoyingvillagers/entity/AlexEntity
/*     */     //   196: astore_3
/*     */     //   197: aload_3
/*     */     //   198: invokevirtual getState : ()I
/*     */     //   201: iconst_1
/*     */     //   202: if_icmpne -> 229
/*     */     //   205: aload_2
/*     */     //   206: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44989_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   209: iconst_2
/*     */     //   210: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   213: aload_2
/*     */     //   214: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44988_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   217: iconst_2
/*     */     //   218: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   221: aload_2
/*     */     //   222: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44990_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   225: iconst_1
/*     */     //   226: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   229: aload_1
/*     */     //   230: instanceof com/pla/annoyingvillagers/entity/ChrisEntity
/*     */     //   233: ifeq -> 265
/*     */     //   236: aload_1
/*     */     //   237: checkcast com/pla/annoyingvillagers/entity/ChrisEntity
/*     */     //   240: astore_3
/*     */     //   241: aload_3
/*     */     //   242: invokevirtual getState : ()I
/*     */     //   245: iconst_1
/*     */     //   246: if_icmpne -> 265
/*     */     //   249: aload_2
/*     */     //   250: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44988_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   253: iconst_2
/*     */     //   254: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   257: aload_2
/*     */     //   258: getstatic net/minecraft/world/item/enchantment/Enchantments.f_44989_ : Lnet/minecraft/world/item/enchantment/Enchantment;
/*     */     //   261: iconst_2
/*     */     //   262: invokevirtual m_41663_ : (Lnet/minecraft/world/item/enchantment/Enchantment;I)V
/*     */     //   265: aload_1
/*     */     //   266: getstatic net/minecraft/world/InteractionHand.MAIN_HAND : Lnet/minecraft/world/InteractionHand;
/*     */     //   269: aload_2
/*     */     //   270: invokevirtual m_41777_ : ()Lnet/minecraft/world/item/ItemStack;
/*     */     //   273: invokevirtual m_21008_ : (Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/item/ItemStack;)V
/*     */     //   276: aload_1
/*     */     //   277: getstatic net/minecraft/world/InteractionHand.OFF_HAND : Lnet/minecraft/world/InteractionHand;
/*     */     //   280: getstatic net/minecraft/world/item/ItemStack.f_41583_ : Lnet/minecraft/world/item/ItemStack;
/*     */     //   283: invokevirtual m_21008_ : (Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/item/ItemStack;)V
/*     */     //   286: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #757	-> 0
/*     */     //   #758	-> 8
/*     */     //   #759	-> 19
/*     */     //   #761	-> 36
/*     */     //   #762	-> 43
/*     */     //   #763	-> 51
/*     */     //   #765	-> 59
/*     */     //   #766	-> 66
/*     */     //   #768	-> 74
/*     */     //   #769	-> 81
/*     */     //   #771	-> 89
/*     */     //   #772	-> 96
/*     */     //   #773	-> 104
/*     */     //   #775	-> 112
/*     */     //   #776	-> 119
/*     */     //   #778	-> 127
/*     */     //   #780	-> 154
/*     */     //   #781	-> 162
/*     */     //   #782	-> 170
/*     */     //   #783	-> 177
/*     */     //   #786	-> 185
/*     */     //   #787	-> 205
/*     */     //   #788	-> 213
/*     */     //   #789	-> 221
/*     */     //   #791	-> 229
/*     */     //   #792	-> 249
/*     */     //   #793	-> 257
/*     */     //   #796	-> 265
/*     */     //   #797	-> 276
/*     */     //   #798	-> 286
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   31	5	3	avNpc	Lcom/pla/annoyingvillagers/clazz/AVNpc;
/*     */     //   139	8	3	steveEntity	Lcom/pla/annoyingvillagers/entity/SteveEntity;
/*     */     //   197	32	3	alexEntity	Lcom/pla/annoyingvillagers/entity/AlexEntity;
/*     */     //   241	24	3	chrisEntity	Lcom/pla/annoyingvillagers/entity/ChrisEntity;
/*     */     //   0	287	0	mobpatch	Lyesman/epicfight/world/capabilities/entitypatch/MobPatch;
/*     */     //   8	279	1	entity	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   19	268	2	bow	Lnet/minecraft/world/item/ItemStack;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	287	0	mobpatch	Lyesman/epicfight/world/capabilities/entitypatch/MobPatch<*>;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void switchWeapon(MobPatch<?> mobpatch) {
/* 801 */     LivingEntity entity = (LivingEntity)mobpatch.getOriginal();
/* 802 */     if (entity instanceof SteveEntity) { SteveEntity steveEntity = (SteveEntity)entity;
/* 803 */       steveEntity.rollItem(); }
/*     */     
/* 805 */     if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 806 */       herobrineMob.rollItem(); }
/*     */     
/* 808 */     if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity;
/* 809 */       blueDemonEntity.rollItem(); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void swapToMelee(MobPatch<?> mobpatch) {
/* 814 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 815 */       ItemStack mainWeaponItem = playerNpcEntity.getMainWeaponItem();
/* 816 */       ItemStack offWeaponItem = playerNpcEntity.getOffWeaponItem();
/* 817 */       if (!mainWeaponItem.m_41619_()) {
/* 818 */         playerNpcEntity.m_21008_(InteractionHand.MAIN_HAND, mainWeaponItem.m_41777_());
/*     */       }
/* 820 */       if (!offWeaponItem.m_41619_()) {
/* 821 */         playerNpcEntity.m_21008_(InteractionHand.OFF_HAND, offWeaponItem.m_41777_());
/*     */       }
/* 823 */       playerNpcEntity.setSwapToBowCooldown(); }
/*     */ 
/*     */     
/* 826 */     entity = mobpatch.getOriginal(); if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 827 */       ItemStack mainWeaponItem = AVNpc.getMainWeaponItem();
/* 828 */       ItemStack offWeaponItem = AVNpc.getOffWeaponItem();
/* 829 */       if (AVNpc instanceof SteveEntity) {
/* 830 */         if (canSwitchWeapon(mobpatch)) {
/* 831 */           switchWeapon(mobpatch);
/*     */         } else {
/* 833 */           if (!mainWeaponItem.m_41619_() && !(mainWeaponItem.m_41720_() instanceof net.minecraft.world.item.BowItem)) {
/* 834 */             AVNpc.m_21008_(InteractionHand.MAIN_HAND, mainWeaponItem.m_41777_());
/*     */           }
/* 836 */           if (!offWeaponItem.m_41619_()) {
/* 837 */             AVNpc.m_21008_(InteractionHand.OFF_HAND, offWeaponItem.m_41777_());
/*     */           }
/*     */         } 
/*     */       } else {
/* 841 */         if (!mainWeaponItem.m_41619_() && !(mainWeaponItem.m_41720_() instanceof net.minecraft.world.item.BowItem))
/* 842 */         { AVNpc.m_21008_(InteractionHand.MAIN_HAND, mainWeaponItem.m_41777_()); }
/* 843 */         else if (AVNpc instanceof VillagerScoutEntity) { VillagerScoutEntity villagerScoutEntity = (VillagerScoutEntity)AVNpc;
/* 844 */           villagerScoutEntity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42383_)); }
/*     */         
/* 846 */         if (!offWeaponItem.m_41619_()) {
/* 847 */           AVNpc.m_21008_(InteractionHand.OFF_HAND, offWeaponItem.m_41777_());
/*     */         }
/*     */       } 
/* 850 */       AVNpc.setSwapToBowCooldown(); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void jump(MobPatch<?> mobpatch) {
/* 855 */     Entity entity = mobpatch.getOriginal();
/* 856 */     if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 857 */       playerNpcEntity.jump(); }
/*     */     
/* 859 */     if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 860 */       AVNpc.jump(); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void shortPillarJump(MobPatch<?> mobpatch) {
/* 865 */     Entity entity = mobpatch.getOriginal();
/* 866 */     if (entity instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)entity;
/* 867 */       playerNpcEntity.shortPillarJump(); }
/*     */     
/* 869 */     if (entity instanceof AVNpc) { AVNpc AVNpc = (AVNpc)entity;
/* 870 */       AVNpc.shortPillarJump(); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void swapToBlockToEscape(MobPatch<?> mobpatch) {
/* 875 */     Entity entity = mobpatch.getOriginal();
/* 876 */     if (entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity;
/* 877 */       double chance = (new Random()).nextDouble(0.0D, 1.0D);
/* 878 */       if (chance <= 0.2D) {
/* 879 */         livingEntity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42594_));
/* 880 */       } else if (chance <= 0.4D) {
/* 881 */         livingEntity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_41998_));
/* 882 */       } else if (chance <= 0.6D) {
/* 883 */         livingEntity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42329_));
/* 884 */       } else if (chance <= 0.8D) {
/* 885 */         livingEntity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42796_));
/*     */       } else {
/* 887 */         livingEntity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42647_));
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public static void swapToBlock(MobPatch<?> mobpatch) {
/* 893 */     LivingEntity entity = (LivingEntity)mobpatch.getOriginal();
/* 894 */     if (entity instanceof PlayerNpcEntity || entity instanceof AVNpc) {
/* 895 */       double chance = (new Random()).nextDouble(0.0D, 1.0D);
/* 896 */       if (chance <= 0.2D) {
/* 897 */         entity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42594_));
/* 898 */       } else if (chance <= 0.4D) {
/* 899 */         entity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_41998_));
/* 900 */       } else if (chance <= 0.6D) {
/* 901 */         entity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42329_));
/* 902 */       } else if (chance <= 0.8D) {
/* 903 */         entity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42796_));
/*     */       } else {
/* 905 */         entity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)Items.f_42647_));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void performExecute(MobPatch<?> mobPatch) {
/* 911 */     Mob attacker = (Mob)mobPatch.getOriginal();
/* 912 */     LivingEntity victim = attacker.m_5448_();
/* 913 */     if (victim == null)
/* 914 */       return;  if (attacker.m_20159_()) attacker.m_8127_();
/*     */     
/* 916 */     LivingEntityPatch<?> victimPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)victim, LivingEntityPatch.class);
/* 917 */     if (victimPatch == null)
/*     */       return; 
/* 919 */     ExecutionTypeManager.Type execType = ExecutionHandler.getExecutionType((LivingEntityPatch)mobPatch, victimPatch);
/* 920 */     faceTargetHard(attacker, victim);
/* 921 */     ExecutionHandler.ExecutionTransform transform = calculateExecutionPosition(attacker.m_9236_(), (LivingEntity)attacker, victim, execType.offset());
/* 922 */     if (transform != null) {
/* 923 */       Vec3 executionPos = transform.position();
/* 924 */       attacker.m_6021_(executionPos.f_82479_, executionPos.f_82480_, executionPos.f_82481_);
/* 925 */       faceTargetHard(attacker, victim);
/* 926 */       TickTaskManager.addTask(victim.m_20148_(), (TickTask)new MobExecutionTask((LivingEntity)attacker, victim, execType, execType
/* 927 */             .totalTick()));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void faceTargetHard(Mob self, LivingEntity target) {
/* 932 */     Vec3 from = self.m_20299_(1.0F);
/* 933 */     Vec3 to = target.m_20299_(1.0F);
/* 934 */     double dx = to.f_82479_ - from.f_82479_;
/* 935 */     double dy = to.f_82480_ - from.f_82480_;
/* 936 */     double dz = to.f_82481_ - from.f_82481_;
/*     */     
/* 938 */     double horiz = Math.sqrt(dx * dx + dz * dz);
/* 939 */     if (horiz < 1.0E-6D) horiz = 1.0E-6D;
/*     */     
/* 941 */     float yaw = (float)(Mth.m_14136_(dz, dx) * 57.29577951308232D) - 90.0F;
/* 942 */     float pitch = (float)-(Mth.m_14136_(dy, horiz) * 57.29577951308232D);
/*     */     
/* 944 */     self.m_21573_().m_26573_();
/* 945 */     self.m_146922_(yaw);
/* 946 */     self.m_146926_(pitch);
/* 947 */     self.m_5618_(yaw);
/* 948 */     self.m_5616_(yaw);
/* 949 */     self.f_19859_ = yaw;
/* 950 */     self.f_19860_ = pitch;
/* 951 */     self.f_20884_ = yaw;
/* 952 */     self.f_20886_ = yaw;
/* 953 */     self.m_21563_().m_24960_((Entity)target, 90.0F, 90.0F);
/*     */   }
/*     */   
/*     */   public static void performBlueDemonHealing(MobPatch<?> mobpatch) {
/* 957 */     LivingEntity entity = (LivingEntity)mobpatch.getOriginal();
/* 958 */     if (entity instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)entity; if (blueDemonEntity.m_9236_() instanceof ServerLevel) {
/* 959 */         blueDemonEntity.setHealingCooldown();
/* 960 */         blueDemonEntity.setHealingTick(600);
/*     */       }  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\CombatCommon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */