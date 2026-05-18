/*     */ package com.pla.annoyingvillagers.skill;
/*     */ import com.pla.annoyingvillagers.clazz.NullWeapon;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*     */ import yesman.epicfight.api.utils.math.Vec3f;
/*     */ import yesman.epicfight.gameasset.Armatures;
/*     */ import yesman.epicfight.model.armature.HumanoidArmature;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.skill.Skill;
/*     */ import yesman.epicfight.skill.SkillBuilder;
/*     */ import yesman.epicfight.skill.SkillCategories;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.entity.eventlistener.BasicAttackEvent;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ import yesman.epicfight.world.entity.eventlistener.SkillCastEvent;
/*     */ import yesman.epicfight.world.entity.eventlistener.TakeDamageEvent;
/*     */ 
/*     */ public class NullWeaponSkill extends WeaponInnateSkill {
/*  47 */   private static final UUID EVENT_UUID = UUID.fromString("08b6bf0d-2fbe-4b7a-87da-ad4c4ebb9597");
/*     */   private static final String NBT_SPENT_STACKS = "AV_NullWeaponSpentStacks";
/*  49 */   public static final List<String> NULL_WEAPON_KEYS = List.of("NullSwordUUID", "NullAxeUUID", "NullPickaxeUUID", "NullHoeUUID", "NullShovelUUID");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NullWeapon pickRandomNullWeapon(ServerLevel serverLevel, CompoundTag data, RandomSource rand) {
/*  58 */     List<NullWeapon> candidates = new ArrayList<>();
/*     */     
/*  60 */     for (String key : NULL_WEAPON_KEYS) {
/*  61 */       if (!data.m_128403_(key))
/*     */         continue; 
/*  63 */       Entity entity = serverLevel.m_8791_(data.m_128342_(key));
/*  64 */       if (entity instanceof NullWeapon) { NullWeapon nullWeapon = (NullWeapon)entity; if (nullWeapon.m_6084_() && !nullWeapon.m_213877_()) {
/*  65 */           candidates.add(nullWeapon);
/*     */         } }
/*     */     
/*     */     } 
/*  69 */     if (candidates.isEmpty()) return null; 
/*  70 */     return candidates.get(rand.m_188503_(candidates.size()));
/*     */   }
/*     */   
/*     */   public NullWeaponSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/*  74 */     super(builder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/*  79 */     if (!skillContainer.isActivated()) {
/*  80 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_TOP, 0.0F);
/*  81 */       Player player = (Player)skillContainer.getExecutor().getOriginal();
/*     */       
/*  83 */       int stack = player.getPersistentData().m_128451_("AV_NullWeaponSpentStacks");
/*  84 */       player.getPersistentData().m_128473_("AV_NullWeaponSpentStacks");
/*     */       
/*  86 */       Level level = player.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  87 */         List<String> weaponKeys = List.of("NullAxeUUID", "NullPickaxeUUID", "NullShovelUUID", "NullHoeUUID", "NullSwordUUID");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  94 */         List<String> shuffledKeys = new ArrayList<>(weaponKeys);
/*  95 */         Collections.shuffle(shuffledKeys, new Random());
/*     */         
/*  97 */         for (int i = 0; i < stack; i++) {
/*  98 */           String key = shuffledKeys.get(i);
/*     */           
/* 100 */           if (player.getPersistentData().m_128403_(key)) {
/* 101 */             UUID uuid = player.getPersistentData().m_128342_(key);
/* 102 */             Entity entity = serverLevel.m_8791_(uuid);
/*     */             
/* 104 */             if (entity instanceof NullWeapon) { NullWeapon nullWeapon = (NullWeapon)entity;
/* 105 */               nullWeapon.setReleased(true); }
/*     */           
/*     */           } 
/*     */         }  }
/*     */       
/* 110 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/* 111 */       skillContainer.activate();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean resourcePredicate(PlayerPatch<?> playerPatch, SkillCastEvent event) {
/*     */     ServerPlayerPatch serverPatch;
/* 117 */     if (playerPatch instanceof ServerPlayerPatch) { serverPatch = (ServerPlayerPatch)playerPatch; }
/* 118 */     else { return true; }
/*     */ 
/*     */     
/* 121 */     SkillContainer container = serverPatch.getSkill(AVSkills.NULL_WEAPON);
/* 122 */     if (container == null || container.getSkill() != this) {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     Player player = (Player)serverPatch.getOriginal();
/* 127 */     if (player.m_7500_()) {
/* 128 */       return true;
/*     */     }
/*     */     
/* 131 */     int available = container.getStack();
/* 132 */     if (available <= 0) {
/* 133 */       return false;
/*     */     }
/* 135 */     player.getPersistentData().m_128405_("AV_NullWeaponSpentStacks", available);
/*     */     
/* 137 */     Skill.setSkillStackSynchronize(container, 0);
/* 138 */     Skill.setSkillConsumptionSynchronize(container, 0.0F);
/* 139 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInitiate(SkillContainer container) {
/* 144 */     super.onInitiate(container);
/* 145 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID, event -> {
/*     */           if (((ServerPlayerPatch)event.getPlayerPatch()).isLogicalClient())
/*     */             return; 
/*     */           SkillContainer skillContainer = ((ServerPlayerPatch)event.getPlayerPatch()).getSkill((Skill)this);
/*     */           if (!skillContainer.isActivated()) {
/*     */             event.setCanceled(true);
/*     */             PlayerPatch<?> playerPatch = event.getPlayerPatch();
/*     */             AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*     */             if (dynamicAnimation != null && dynamicAnimation == WOMAnimations.ANTITHEUS_ASCENDED_AUTO_2) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)WOMAnimations.ANTITHEUS_ASCENDED_AUTO_3, 0.0F);
/*     */             } else if (dynamicAnimation != null && dynamicAnimation == WOMAnimations.ANTITHEUS_ASCENDED_AUTO_1) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)WOMAnimations.ANTITHEUS_ASCENDED_AUTO_2, 0.0F);
/*     */             } else {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)WOMAnimations.ANTITHEUS_ASCENDED_AUTO_1, 0.0F);
/*     */             } 
/*     */           } 
/*     */         });
/* 162 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID, pre -> {
/*     */           DamageSource damageSource = pre.getDamageSource();
/*     */           
/*     */           if (!damageSource.m_276093_(DamageTypes.f_268515_) && !damageSource.m_276093_(DamageTypes.f_268565_) && !damageSource.m_276093_(DamageTypes.f_268468_) && !damageSource.m_276093_(DamageTypes.f_268631_) && !damageSource.m_276093_(DamageTypes.f_268671_) && !damageSource.m_276093_(DamageTypes.f_268724_) && !damageSource.m_276093_(DamageTypes.f_268722_)) {
/*     */             Player player = (Player)((ServerPlayerPatch)pre.getPlayerPatch()).getOriginal();
/*     */             
/*     */             Level patt8300$temp = player.m_9236_();
/*     */             
/*     */             if (patt8300$temp instanceof ServerLevel) {
/*     */               ServerLevel serverLevel = (ServerLevel)patt8300$temp;
/*     */               
/*     */               CompoundTag data = player.getPersistentData();
/*     */               
/*     */               if ((new Random()).nextFloat() > (container.isActivated() ? 0.5F : 0.25F)) {
/*     */                 return;
/*     */               }
/*     */               
/*     */               NullWeapon nullWeapon = pickRandomNullWeapon(serverLevel, data, player.m_217043_());
/*     */               
/*     */               if (nullWeapon != null) {
/*     */                 nullWeapon.m_7678_(player.m_20185_(), player.m_20186_(), player.m_20189_(), nullWeapon.m_146908_(), nullWeapon.m_146909_());
/*     */                 
/*     */                 pre.setCanceled(true);
/*     */                 
/*     */                 pre.setResult(AttackResult.ResultType.BLOCKED);
/*     */                 
/*     */                 EpicfightUtil.damageBlocked(pre.getDamageSource(), (Entity)player, serverLevel);
/*     */                 
/*     */                 nullWeapon.spinfor5seconds();
/*     */                 
/*     */                 ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, (Entity)player, pre.getDamageSource().m_7639_());
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         });
/* 197 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.SKILL_CAST_EVENT, EVENT_UUID, event -> {
/*     */           Player player = (Player)container.getExecutor().getOriginal();
/*     */           Skill skill = event.getSkillContainer().getSkill();
/*     */           if (skill.getCategory() == SkillCategories.GUARD) {
/*     */             List<String> weaponKeys = List.of("NullAxeUUID", "NullPickaxeUUID", "NullShovelUUID", "NullHoeUUID", "NullSwordUUID");
/*     */             for (String key : weaponKeys) {
/*     */               if (player.getPersistentData().m_128403_(key)) {
/*     */                 Level patt10425$temp = player.m_9236_();
/*     */                 if (patt10425$temp instanceof ServerLevel) {
/*     */                   ServerLevel serverLevel = (ServerLevel)patt10425$temp;
/*     */                   UUID uuid = player.getPersistentData().m_128342_(key);
/*     */                   Entity entity = serverLevel.m_8791_(uuid);
/*     */                   if (entity instanceof NullWeapon) {
/*     */                     NullWeapon nullWeapon = (NullWeapon)entity;
/*     */                     if (!nullWeapon.isReleased()) {
/*     */                       nullWeapon.setSpinning(true);
/*     */                     }
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onRemoved(SkillContainer container) {
/* 228 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID);
/* 229 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.SKILL_CAST_EVENT, EVENT_UUID);
/* 230 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelOnServer(SkillContainer container, FriendlyByteBuf args) {
/* 235 */     container.deactivate();
/* 236 */     Player player = (Player)container.getExecutor().getOriginal();
/* 237 */     List<String> weaponKeys = List.of("NullAxeUUID", "NullPickaxeUUID", "NullShovelUUID", "NullHoeUUID", "NullSwordUUID");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 245 */     for (String key : weaponKeys) {
/* 246 */       if (player.getPersistentData().m_128403_(key)) { Level level = player.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 247 */           UUID uuid = player.getPersistentData().m_128342_(key);
/* 248 */           Entity entity = serverLevel.m_8791_(uuid);
/*     */           
/* 250 */           if (entity instanceof NullWeapon) { NullWeapon nullWeapon = (NullWeapon)entity;
/* 251 */             nullWeapon.setReleased(false); }
/*     */            }
/*     */          }
/*     */     
/* 255 */     }  super.cancelOnServer(container, args);
/*     */   }
/*     */   
/*     */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 259 */     super.executeOnClient(container, args);
/* 260 */     container.activate();
/*     */   }
/*     */   
/*     */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 264 */     super.cancelOnClient(container, args);
/* 265 */     container.deactivate();
/*     */   }
/*     */   
/*     */   private static void removeTrackedEntityIfWrongType(ServerLevel serverLevel, CompoundTag persistentData, String uuidKey, Class<? extends Entity> expectedClass) {
/* 269 */     if (!persistentData.m_128403_(uuidKey)) {
/*     */       return;
/*     */     }
/*     */     
/* 273 */     Entity trackedEntity = serverLevel.m_8791_(persistentData.m_128342_(uuidKey));
/* 274 */     if (trackedEntity != null && (!expectedClass.isInstance(trackedEntity) || !trackedEntity.m_6084_())) {
/* 275 */       persistentData.m_128473_(uuidKey);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateContainer(SkillContainer container) {
/* 281 */     super.updateContainer(container);
/* 282 */     if (container.getExecutor().getValidItemInHand(InteractionHand.MAIN_HAND) != null) {
/* 283 */       PlayerPatch playerPatch = container.getExecutor();
/* 284 */       if (playerPatch == null)
/* 285 */         return;  if (playerPatch.getAnimator() == null)
/* 286 */         return;  if (playerPatch.getArmature() == null)
/* 287 */         return;  if (Armatures.BIPED.get() == null || ((HumanoidArmature)Armatures.BIPED.get()).toolL == null)
/* 288 */         return;  if (playerPatch.getOriginal() == null)
/*     */         return; 
/* 290 */       byte poseSampleCount = 3;
/* 291 */       float poseStep = 1.0F / (poseSampleCount - 1);
/* 292 */       float poseProgress = 0.0F;
/*     */ 
/*     */ 
/*     */       
/*     */       int poseSampleIndex;
/*     */ 
/*     */       
/* 299 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 300 */         OpenMatrix4f toolLeftTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 301 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 302 */             .get()).toolL);
/*     */         
/* 304 */         toolLeftTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 305 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 306 */             .rotate(
/* 307 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), toolLeftTransform, toolLeftTransform);
/*     */ 
/*     */ 
/*     */         
/*     */         int i;
/*     */ 
/*     */         
/* 314 */         for (i = 0; i < 1; i++) {
/* 315 */           ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 316 */               .get(), toolLeftTransform.m30 + ((LivingEntity)playerPatch
/* 317 */               .getOriginal()).m_20185_(), toolLeftTransform.m31 + ((Player)playerPatch
/* 318 */               .getOriginal()).m_20186_(), toolLeftTransform.m32 + ((Player)playerPatch
/* 319 */               .getOriginal()).m_20189_(), (((new Random())
/* 320 */               .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 321 */               .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 322 */               .nextFloat() - 0.5F) * 0.15F));
/*     */         }
/*     */ 
/*     */         
/* 326 */         for (i = 0; i < 1; i++) {
/* 327 */           ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 328 */               .get(), toolLeftTransform.m30 + ((LivingEntity)playerPatch
/* 329 */               .getOriginal()).m_20185_(), toolLeftTransform.m31 + ((Player)playerPatch
/* 330 */               .getOriginal()).m_20186_(), toolLeftTransform.m32 + ((Player)playerPatch
/* 331 */               .getOriginal()).m_20189_(), 0.0D, 0.0D, 0.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 336 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 339 */       poseProgress = 0.0F;
/*     */       
/* 341 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 342 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 343 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 344 */             .get()).toolR);
/*     */         
/* 346 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 1.8F));
/* 347 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 348 */             .rotate(
/* 349 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 355 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, -((new Random()).nextFloat() * 4.0F)));
/*     */         
/* 357 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 358 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 359 */             .getOriginal()).m_20185_(), jointTransform.m31 + ((Player)playerPatch
/* 360 */             .getOriginal()).m_20186_(), jointTransform.m32 + ((Player)playerPatch
/* 361 */             .getOriginal()).m_20189_(), (((new Random())
/* 362 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 363 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 364 */             .nextFloat() - 0.5F) * 0.15F));
/*     */         
/* 366 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 367 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 368 */             .getOriginal()).m_20185_(), jointTransform.m31 + ((Player)playerPatch
/* 369 */             .getOriginal()).m_20186_(), jointTransform.m32 + ((Player)playerPatch
/* 370 */             .getOriginal()).m_20189_(), 0.0D, 0.0D, 0.0D);
/*     */ 
/*     */ 
/*     */         
/* 374 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 377 */       for (int particleIndex = 0; particleIndex < 14; particleIndex++) {
/* 378 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 379 */             .get(), ((LivingEntity)playerPatch
/* 380 */             .getOriginal()).m_20185_(), ((LivingEntity)playerPatch
/* 381 */             .getOriginal()).m_20186_() + 0.029999999329447746D, ((LivingEntity)playerPatch
/* 382 */             .getOriginal()).m_20189_(), (((new Random())
/* 383 */             .nextFloat() - 0.5F) * 0.65F), (((new Random())
/* 384 */             .nextFloat() - 0.5F) * 0.05F), (((new Random())
/* 385 */             .nextFloat() - 0.5F) * 0.65F));
/*     */       }
/*     */ 
/*     */       
/* 389 */       poseStep = 1.0F;
/* 390 */       poseProgress = 0.0F;
/*     */       
/* 392 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 393 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 394 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 395 */             .get()).head);
/*     */         
/* 397 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 398 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 399 */             .rotate(
/* 400 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 407 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 408 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 409 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 410 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() + 0.1F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 411 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 412 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 413 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 414 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 417 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 420 */       poseProgress = 0.0F;
/*     */       
/* 422 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 423 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 424 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 425 */             .get()).chest);
/*     */         
/* 427 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 428 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 429 */             .rotate(
/* 430 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 437 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 438 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 439 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 440 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 441 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 442 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 443 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 444 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 447 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 450 */       poseProgress = 0.0F;
/*     */       
/* 452 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 453 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 454 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 455 */             .get()).armL);
/*     */         
/* 457 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 458 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 459 */             .rotate(
/* 460 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 467 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 468 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 469 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 470 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 471 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 472 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 473 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 474 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 477 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 480 */       poseProgress = 0.0F;
/*     */       
/* 482 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 483 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 484 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 485 */             .get()).armR);
/*     */         
/* 487 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 488 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 489 */             .rotate(
/* 490 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 497 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 498 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 499 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 500 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 501 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 502 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 503 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 504 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 507 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 510 */       poseProgress = 0.0F;
/*     */       
/* 512 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 513 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 514 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 515 */             .get()).torso);
/*     */         
/* 517 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 518 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 519 */             .rotate(
/* 520 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 527 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 528 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 529 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 530 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 531 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 532 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 533 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 534 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 537 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 540 */       poseProgress = 0.0F;
/*     */       
/* 542 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 543 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 544 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 545 */             .get()).thighL);
/*     */         
/* 547 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 548 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 549 */             .rotate(
/* 550 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 557 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 558 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 559 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 560 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 561 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 562 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 563 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 564 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 567 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 570 */       poseProgress = 0.0F;
/*     */       
/* 572 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 573 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 574 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 575 */             .get()).thighR);
/*     */         
/* 577 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 578 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 579 */             .rotate(
/* 580 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 587 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 588 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 589 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 590 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 591 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 592 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 593 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 594 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 597 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 600 */       poseProgress = 0.0F;
/*     */       
/* 602 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 603 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 604 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 605 */             .get()).legL);
/*     */         
/* 607 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 608 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 609 */             .rotate(
/* 610 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 617 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 618 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 619 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 620 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 621 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 622 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 623 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 624 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 627 */         poseProgress += poseStep;
/*     */       } 
/*     */       
/* 630 */       poseProgress = 0.0F;
/*     */       
/* 632 */       for (poseSampleIndex = 0; poseSampleIndex < poseSampleCount; poseSampleIndex++) {
/* 633 */         OpenMatrix4f jointTransform = playerPatch.getArmature().getBoundTransformFor(playerPatch
/* 634 */             .getAnimator().getPose(poseProgress), ((HumanoidArmature)Armatures.BIPED
/* 635 */             .get()).legR);
/*     */         
/* 637 */         jointTransform.translate(new Vec3f(0.0F, 0.0F, 0.0F));
/* 638 */         OpenMatrix4f.mul((new OpenMatrix4f())
/* 639 */             .rotate(
/* 640 */               -((float)Math.toRadians((((LivingEntity)playerPatch.getOriginal()).f_20884_ + 180.0F))), new Vec3f(0.0F, 1.0F, 0.0F)), jointTransform, jointTransform);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 647 */         ((LivingEntity)playerPatch.getOriginal()).m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.NULL
/* 648 */             .get(), jointTransform.m30 + ((LivingEntity)playerPatch
/* 649 */             .getOriginal()).m_20185_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m31 + ((LivingEntity)playerPatch
/* 650 */             .getOriginal()).m_20186_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), jointTransform.m32 + ((LivingEntity)playerPatch
/* 651 */             .getOriginal()).m_20189_() + (((new Random()).nextFloat() - 0.5F) * 0.55F), (((new Random())
/* 652 */             .nextFloat() - 0.5F) * 0.15F), (((new Random())
/* 653 */             .nextFloat() - 1.0F) * 0.55F), (((new Random())
/* 654 */             .nextFloat() - 0.5F) * 0.15F));
/*     */ 
/*     */         
/* 657 */         poseProgress += poseStep;
/*     */       } 
/*     */     } 
/*     */     
/* 661 */     if (container.getExecutor().isLogicalClient())
/*     */       return; 
/* 663 */     ServerPlayerPatch serverPlayerPatch = container.getServerExecutor();
/* 664 */     Player player = (Player)serverPlayerPatch.getOriginal();
/* 665 */     ServerLevel serverLevel = (ServerLevel)player.m_9236_();
/* 666 */     CompoundTag data = player.getPersistentData();
/*     */     
/* 668 */     if (player.f_19797_ >= 40 && player.f_19797_ % 10 == 0) {
/* 669 */       if (((Player)container.getExecutor().getOriginal()).m_21205_().m_41720_() instanceof com.pla.annoyingvillagers.item.NullWeaponItem) {
/* 670 */         ensureWeapon(serverLevel, player, data, "NullSwordUUID", (EntityType<? extends NullWeapon>)AnnoyingVillagersModEntities.NULL_SWORD.get(), (Class)NullSwordEntity.class);
/* 671 */         ensureWeapon(serverLevel, player, data, "NullAxeUUID", (EntityType<? extends NullWeapon>)AnnoyingVillagersModEntities.NULL_AXE.get(), (Class)NullAxeEntity.class);
/* 672 */         ensureWeapon(serverLevel, player, data, "NullPickaxeUUID", (EntityType<? extends NullWeapon>)AnnoyingVillagersModEntities.NULL_PICKAXE.get(), (Class)NullPickaxeEntity.class);
/* 673 */         ensureWeapon(serverLevel, player, data, "NullShovelUUID", (EntityType<? extends NullWeapon>)AnnoyingVillagersModEntities.NULL_SHOVEL.get(), (Class)NullShovelEntity.class);
/* 674 */         ensureWeapon(serverLevel, player, data, "NullHoeUUID", (EntityType<? extends NullWeapon>)AnnoyingVillagersModEntities.NULL_HOE.get(), (Class)NullHoeEntity.class);
/*     */       } 
/*     */       
/* 677 */       teleportWeapon("NullSwordUUID", serverLevel, data);
/* 678 */       teleportWeapon("NullAxeUUID", serverLevel, data);
/* 679 */       teleportWeapon("NullPickaxeUUID", serverLevel, data);
/* 680 */       teleportWeapon("NullHoeUUID", serverLevel, data);
/* 681 */       teleportWeapon("NullShovelUUID", serverLevel, data);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void ensureWeapon(ServerLevel level, Player player, CompoundTag data, String key, EntityType<? extends NullWeapon> type, Class<? extends Entity> expectedClass) {
/* 689 */     removeTrackedEntityIfWrongType(level, data, key, expectedClass);
/* 690 */     if (data.m_128403_(key))
/* 691 */       return;  NullWeapon nullWeapon = (NullWeapon)type.m_20615_((Level)level);
/* 692 */     if (nullWeapon == null)
/*     */       return; 
/* 694 */     nullWeapon.summonNullWeaponForPlayer(key, level, player);
/*     */   }
/*     */   
/*     */   private void teleportWeapon(String uuidNbt, ServerLevel serverLevel, CompoundTag compoundTag) {
/* 698 */     if (compoundTag.m_128403_(uuidNbt)) {
/* 699 */       Entity entity = serverLevel.m_8791_(compoundTag.m_128342_(uuidNbt));
/* 700 */       if (entity instanceof NullWeapon) { NullWeapon nullWeapon = (NullWeapon)entity;
/* 701 */         nullWeapon.processTeleportByPlayer(); }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\NullWeaponSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */