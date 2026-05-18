/*     */ package com.pla.annoyingvillagers.skill;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemCooldowns;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.skill.Skill;
/*     */ import yesman.epicfight.skill.SkillCategories;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.entity.eventlistener.BasicAttackEvent;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ import yesman.epicfight.world.entity.eventlistener.SkillCastEvent;
/*     */ 
/*     */ public class EnderSlayerScytheSkill extends WeaponInnateSkill {
/*  34 */   private static final UUID EVENT_UUID = UUID.fromString("f79be742-fddd-454d-bd28-4d030613b284");
/*     */   
/*     */   public EnderSlayerScytheSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/*  37 */     super(builder);
/*     */   }
/*     */   
/*     */   private static Vec3 findOrbitSpawnPos(ServerLevel level, Player player, HerobrineDragonEntity dragon) {
/*  41 */     RandomSource rng = level.m_213780_();
/*  42 */     boolean hasCeiling = level.m_6042_().f_63856_();
/*     */     
/*  44 */     for (int i = 0; i < 32; i++) {
/*  45 */       double ang = rng.m_188500_() * 6.283185307179586D;
/*  46 */       double r = Mth.m_216263_(rng, 20.0D, 50.0D);
/*     */       
/*  48 */       double x = player.m_20185_() + Math.cos(ang) * r;
/*  49 */       double z = player.m_20189_() + Math.sin(ang) * r;
/*     */       
/*  51 */       if (!hasCeiling) {
/*  52 */         BlockPos col = BlockPos.m_274561_(x, 0.0D, z);
/*  53 */         int groundY = level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, col).m_123342_();
/*     */         
/*  55 */         double d = Math.max(player.m_20186_() + 12.0D, groundY + 18.0D);
/*  56 */         d += Mth.m_216263_(rng, -2.0D, 6.0D);
/*     */         
/*  58 */         d = Mth.m_14008_(d, level.m_141937_() + 6.0D, level.m_151558_() - 6.0D);
/*     */         
/*  60 */         dragon.m_7678_(x, d, z, rng.m_188501_() * 360.0F, 0.0F);
/*  61 */         AABB box = dragon.m_20191_();
/*     */         
/*  63 */         if (level.m_45756_((Entity)dragon, box) && !level.m_46855_(box)) {
/*  64 */           return new Vec3(x, d, z);
/*     */         }
/*     */       } else {
/*  67 */         BlockPos col = BlockPos.m_274561_(x, 0.0D, z);
/*  68 */         int roofAirY = level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, col).m_123342_();
/*     */         
/*  70 */         double yWanted = player.m_20186_() + 12.0D + Mth.m_216263_(rng, -2.0D, 6.0D);
/*     */         
/*  72 */         double minY = level.m_141937_() + 6.0D;
/*  73 */         double maxY = Math.min(level.m_151558_() - 2.0D, roofAirY - 2.0D);
/*     */         
/*  75 */         int yStart = Mth.m_14107_(Mth.m_14008_(yWanted, minY, maxY));
/*  76 */         int yMin = Mth.m_14107_(minY);
/*     */         
/*  78 */         for (int j = yStart; j >= yMin && yStart - j <= 96; j--) {
/*  79 */           dragon.m_7678_(x, j, z, rng.m_188501_() * 360.0F, 0.0F);
/*  80 */           AABB box = dragon.m_20191_();
/*     */           
/*  82 */           if (level.m_45756_((Entity)dragon, box) && !level.m_46855_(box)) {
/*  83 */             return new Vec3(x, j, z);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     double fx = player.m_20185_();
/*  90 */     double fz = player.m_20189_();
/*  91 */     double fy = player.m_20186_() + 16.0D;
/*     */     
/*  93 */     if (hasCeiling) {
/*  94 */       BlockPos col = BlockPos.m_274561_(fx, 0.0D, fz);
/*  95 */       int roofAirY = level.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, col).m_123342_();
/*  96 */       fy = Math.min(fy, roofAirY - 8.0D);
/*     */     } 
/*     */     
/*  99 */     fy = Mth.m_14008_(fy, level.m_141937_() + 6.0D, level.m_151558_() - 6.0D);
/*     */     
/* 101 */     int start = Mth.m_14107_(fy);
/* 102 */     for (int y = start; y >= level.m_141937_() + 6 && start - y <= 64; y--) {
/* 103 */       dragon.m_7678_(fx, y, fz, rng.m_188501_() * 360.0F, 0.0F);
/* 104 */       AABB box = dragon.m_20191_();
/*     */       
/* 106 */       if (level.m_45756_((Entity)dragon, box) && !level.m_46855_(box)) {
/* 107 */         return new Vec3(fx, y, fz);
/*     */       }
/*     */     } 
/*     */     
/* 111 */     return player.m_20182_().m_82520_(0.0D, 8.0D, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 116 */     if (!skillContainer.isActivated()) {
/* 117 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.AGONY_GUARD_HIT_1, 0.0F);
/* 118 */       ((Player)skillContainer.getExecutor().getOriginal()).m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_WEAPON_SCREAMING.get(), 0.8F, 1.0F);
/* 119 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/* 120 */       skillContainer.activate();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInitiate(SkillContainer container) {
/* 126 */     super.onInitiate(container);
/* 127 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID, event -> {
/*     */           if (((ServerPlayerPatch)event.getPlayerPatch()).isLogicalClient()) {
/*     */             return;
/*     */           }
/*     */           SkillContainer skillContainer = ((ServerPlayerPatch)event.getPlayerPatch()).getSkill((Skill)this);
/*     */           final ItemStack itemStack = ((ServerPlayer)((ServerPlayerPatch)event.getPlayerPatch()).getOriginal()).m_21205_();
/*     */           ServerPlayerPatch serverPlayerPatch = skillContainer.getServerExecutor();
/*     */           Player player = (Player)serverPlayerPatch.getOriginal();
/*     */           if (skillContainer.isActivated()) {
/*     */             event.setCanceled(true);
/*     */             if (((ServerPlayer)((ServerPlayerPatch)event.getPlayerPatch()).getOriginal()).m_36335_().m_41521_(itemStack.m_41720_(), 0.0F) == 0.0F && itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderSlayerScytheItem) {
/*     */               Level patt6545$temp = player.m_9236_();
/*     */               if (patt6545$temp instanceof ServerLevel) {
/*     */                 ServerLevel serverLevel = (ServerLevel)patt6545$temp;
/*     */                 if (player.getPersistentData().m_128441_("DragonUUID")) {
/*     */                   UUID dragonId = player.getPersistentData().m_128342_("DragonUUID");
/*     */                   Entity entity = serverLevel.m_8791_(dragonId);
/*     */                   if (entity == null) {
/*     */                     player.getPersistentData().m_128473_("DragonUUID");
/*     */                     return;
/*     */                   } 
/*     */                   LivingEntity target = player.m_21214_();
/*     */                   if (target == null || !target.m_6084_() || target == player)
/*     */                     target = player.m_21188_(); 
/*     */                   if (target == null || !target.m_6084_() || target == player)
/*     */                     target = HerobrineDragonEntity.getNearestLivingEntity(player.m_9236_(), (Entity)player, 48.0D); 
/*     */                   if (entity instanceof HerobrineDragonEntity) {
/*     */                     final HerobrineDragonEntity herobrineDragonEntity = (HerobrineDragonEntity)entity;
/*     */                     if (target != null && target.m_6084_()) {
/*     */                       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_TOP, 0.0F);
/*     */                       final LivingEntity finalTarget = target;
/*     */                       new DelayedTask(10)
/*     */                         {
/*     */                           public void run() {
/* 161 */                             herobrineDragonEntity.shootThunderBreathAtTarget(finalTarget);
/* 162 */                             ItemCooldowns cooldowns = ((ServerPlayer)((ServerPlayerPatch)event.getPlayerPatch()).getOriginal()).m_36335_();
/* 163 */                             cooldowns.m_41524_(itemStack.m_41720_(), 120);
/*     */                           }
/*     */                         };
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } else if (!skillContainer.isActivated() && player.m_20159_() && player.m_20202_() != null && player.m_20202_() instanceof HerobrineDragonEntity) {
/*     */             event.setCanceled(true);
/*     */             
/*     */             if (player.m_21205_().m_41720_() instanceof net.minecraft.world.item.BowItem) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.BOW_AUTO_1, 0.0F);
/*     */             } else {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AnimsAgony.AGONY_AUTO_1, 0.0F);
/*     */             } 
/*     */           } 
/*     */         });
/* 181 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.SKILL_CAST_EVENT, EVENT_UUID, event -> {
/*     */           if (event.getPlayerPatch().isLogicalClient()) {
/*     */             return;
/*     */           }
/*     */           SkillContainer skillContainer = event.getPlayerPatch().getSkill((Skill)this);
/*     */           final ItemStack itemStack = ((Player)event.getPlayerPatch().getOriginal()).m_21205_();
/*     */           ServerPlayerPatch serverPlayerPatch = skillContainer.getServerExecutor();
/*     */           Player player = (Player)serverPlayerPatch.getOriginal();
/*     */           Skill skill = event.getSkillContainer().getSkill();
/*     */           if (skillContainer.isActivated() && itemStack.m_41783_() != null && skill.getCategory() == SkillCategories.GUARD) {
/*     */             event.setCanceled(true);
/*     */             if (((Player)event.getPlayerPatch().getOriginal()).m_36335_().m_41521_(itemStack.m_41720_(), 0.0F) == 0.0F && itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderSlayerScytheItem) {
/*     */               Level patt10336$temp = player.m_9236_();
/*     */               if (patt10336$temp instanceof ServerLevel) {
/*     */                 ServerLevel serverLevel = (ServerLevel)patt10336$temp;
/*     */                 if (player.getPersistentData().m_128441_("DragonUUID")) {
/*     */                   UUID dragonId = player.getPersistentData().m_128342_("DragonUUID");
/*     */                   Entity entity = serverLevel.m_8791_(dragonId);
/*     */                   if (entity == null) {
/*     */                     player.getPersistentData().m_128473_("DragonUUID");
/*     */                     return;
/*     */                   } 
/*     */                   LivingEntity target = player.m_21214_();
/*     */                   if (target == null || !target.m_6084_() || target == player) {
/*     */                     target = player.m_21188_();
/*     */                   }
/*     */                   if (target == null || !target.m_6084_() || target == player)
/*     */                     target = HerobrineDragonEntity.getNearestLivingEntity(player.m_9236_(), (Entity)player, 40.0D); 
/*     */                   ItemCooldowns cooldowns = ((Player)event.getPlayerPatch().getOriginal()).m_36335_();
/*     */                   cooldowns.m_41524_(itemStack.m_41720_(), 20);
/*     */                   if (entity instanceof HerobrineDragonEntity) {
/*     */                     final HerobrineDragonEntity herobrineDragonEntity = (HerobrineDragonEntity)entity;
/*     */                     if (target != null && target.m_6084_()) {
/*     */                       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_BUFF, 0.0F);
/*     */                       final LivingEntity finalTarget = target;
/*     */                       new DelayedTask(10)
/*     */                         {
/*     */                           public void run() {
/* 219 */                             herobrineDragonEntity.shootMeteoriteAtTarget(finalTarget); } };
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         });
/* 227 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DODGE_SUCCESS_EVENT, EVENT_UUID, event -> {
/*     */           SkillContainer skillContainer = container.getExecutor().getSkill(AVSkills.ENDER_SLAYER_SCYTHE);
/*     */           if (skillContainer == null) {
/*     */             return;
/*     */           }
/*     */           EnderSlayerScytheSkill enderSlayerScytheSkill = (EnderSlayerScytheSkill)skillContainer.getSkill();
/*     */           if (!skillContainer.isActivated() && skillContainer.getStack() < 1) {
/*     */             float currentResource = skillContainer.getResource();
/*     */             float neededResource = skillContainer.getNeededResource();
/*     */             float addResource = Math.min(10.0F, neededResource);
/*     */             enderSlayerScytheSkill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*     */           } else if (skillContainer.isActivated()) {
/*     */             enderSlayerScytheSkill.setDurationSynchronize(skillContainer, skillContainer.getRemainDuration() + 80);
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public void cancelOnServer(SkillContainer container, FriendlyByteBuf args) {
/* 245 */     container.deactivate();
/* 246 */     super.cancelOnServer(container, args);
/*     */   }
/*     */   
/*     */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 250 */     super.executeOnClient(container, args);
/* 251 */     container.activate();
/*     */   }
/*     */   
/*     */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 255 */     super.cancelOnClient(container, args);
/* 256 */     container.deactivate();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canExecute(SkillContainer container) {
/* 261 */     ItemStack itemstack = ((Player)container.getExecutor().getOriginal()).m_21205_();
/*     */     
/* 263 */     return (EpicFightCapabilities.getItemStackCapability(itemstack).getInnateSkill(container.getExecutor(), itemstack) == this && (((Player)container
/* 264 */       .getExecutor().getOriginal()).m_20202_() == null || (((Player)container
/* 265 */       .getExecutor().getOriginal()).m_20202_() != null && ((Player)container.getExecutor().getOriginal()).m_20202_() instanceof HerobrineDragonEntity)) && (
/* 266 */       !isActivated(container) || this.activateType == Skill.ActivateType.TOGGLE));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onRemoved(SkillContainer container) {
/* 271 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID);
/* 272 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.SKILL_CAST_EVENT, EVENT_UUID);
/* 273 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DODGE_SUCCESS_EVENT, EVENT_UUID);
/*     */   }
/*     */   
/*     */   public void updateContainer(SkillContainer container) {
/*     */     ServerLevel serverLevel;
/* 278 */     super.updateContainer(container);
/* 279 */     if (container.getExecutor().isLogicalClient())
/*     */       return; 
/* 281 */     ServerPlayerPatch serverPlayerPatch = container.getServerExecutor();
/* 282 */     Player player = (Player)serverPlayerPatch.getOriginal();
/* 283 */     Level level = player.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else { return; }
/* 285 */      if (player.f_19797_ % 5 != 0)
/*     */       return; 
/* 287 */     ItemStack main = player.m_21205_();
/* 288 */     if (!(main.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderSlayerScytheItem)) {
/*     */       return;
/*     */     }
/*     */     
/* 292 */     if (player.getPersistentData().m_128441_("DragonUUID")) {
/* 293 */       UUID id = player.getPersistentData().m_128342_("DragonUUID");
/* 294 */       Entity entity = serverLevel.m_8791_(id);
/* 295 */       if (!(entity instanceof HerobrineDragonEntity) || entity.m_213877_()) {
/* 296 */         player.getPersistentData().m_128473_("DragonUUID");
/*     */       }
/*     */     } 
/*     */     
/* 300 */     if (!player.getPersistentData().m_128441_("DragonUUID")) {
/* 301 */       HerobrineDragonEntity herobrineDragonEntity = spawnEnderDragon(player, serverLevel);
/* 302 */       if (herobrineDragonEntity != null)
/* 303 */         player.getPersistentData().m_128362_("DragonUUID", herobrineDragonEntity.m_20148_()); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private HerobrineDragonEntity spawnEnderDragon(Player player, ServerLevel serverLevel) {
/* 308 */     if (!player.m_6084_()) return null; 
/* 309 */     HerobrineDragonEntity herobrineDragonEntity = new HerobrineDragonEntity((EntityType)AnnoyingVillagersModEntities.HEROBRINE_DRAGON.get(), (Level)serverLevel);
/* 310 */     Vec3 spawnPos = findOrbitSpawnPos(serverLevel, player, herobrineDragonEntity);
/* 311 */     herobrineDragonEntity.m_7678_(spawnPos.f_82479_, spawnPos.f_82480_, spawnPos.f_82481_, serverLevel.m_213780_().m_188501_() * 360.0F, 0.0F);
/* 312 */     herobrineDragonEntity.setSummoner((LivingEntity)player);
/* 313 */     herobrineDragonEntity.setSummonerUUID(player.m_20148_());
/* 314 */     serverLevel.m_7967_((Entity)herobrineDragonEntity);
/* 315 */     return herobrineDragonEntity;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\EnderSlayerScytheSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */