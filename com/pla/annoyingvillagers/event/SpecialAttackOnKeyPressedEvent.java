/*     */ package com.pla.annoyingvillagers.event;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.item.HerobrineEnderEyeItem;
/*     */ import com.pla.annoyingvillagers.skill.EnderGlaiveSkill;
/*     */ import com.pla.annoyingvillagers.skill.LegendarySwordSkill;
/*     */ import com.pla.annoyingvillagers.skill.ObsidianWeaponSkill;
/*     */ import com.pla.annoyingvillagers.skill.ShadowObsidianPillarSkill;
/*     */ import com.pla.annoyingvillagers.skill.TridentFestivalSkill;
/*     */ import com.pla.annoyingvillagers.skill.WoopieTheSwordSkill;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemCooldowns;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.skill.Skill;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ 
/*     */ public class SpecialAttackOnKeyPressedEvent {
/*     */   public static void execute(LevelAccessor world, Entity entity) {
/*  43 */     if (entity == null)
/*     */       return; 
/*  45 */     PlayerPatch<?> playerpatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch(entity, PlayerPatch.class);
/*  46 */     final LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/*  47 */     if (livingEntityPatch == null)
/*  48 */       return;  AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*  49 */     if (EpicfightUtil.isLongHitAnimation(dynamicAnimation, livingEntityPatch)) {
/*     */       return;
/*     */     }
/*     */     
/*  53 */     if (entity.m_9236_() instanceof ServerLevel && 
/*  54 */       dynamicAnimation != Animations.EMPTY_ANIMATION) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  59 */     if (entity instanceof Player) { Player player = (Player)entity; if (!player.m_9236_().m_5776_() && 
/*  60 */         !player.m_21205_().m_41720_().equals(AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get()) && 
/*  61 */         !player.m_21206_().m_41720_().equals(AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get())) {
/*  62 */         (player.m_150109_()).f_35974_.stream()
/*  63 */           .filter(s -> (!s.m_41619_() && s.m_150930_((Item)AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get())))
/*  64 */           .findFirst()
/*  65 */           .map(stack -> {
/*     */               Item patt3451$temp = stack.m_41720_();
/*     */               if (patt3451$temp instanceof HerobrineEnderEyeItem) {
/*     */                 HerobrineEnderEyeItem herobrineEnderEyeItem = (HerobrineEnderEyeItem)patt3451$temp;
/*     */                 ItemCooldowns cooldowns = player.m_36335_();
/*     */                 if (cooldowns.m_41519_((Item)herobrineEnderEyeItem)) {
/*     */                   return Boolean.valueOf(false);
/*     */                 }
/*     */                 HerobrineEnderEyeItem.spawnAndShootDarkObPillars((ServerLevel)player.m_9236_(), (LivingEntity)player, 10);
/*     */                 player.m_36335_().m_41524_((Item)herobrineEnderEyeItem, 40);
/*     */                 stack.m_41622_(5, (LivingEntity)player, ());
/*     */                 return Boolean.valueOf(true);
/*     */               } 
/*     */               return Boolean.valueOf(false);
/*     */             });
/*     */       } }
/*     */     
/*  82 */     if (entity instanceof Player) { Player player = (Player)entity;
/*     */       
/*  84 */       ItemStack holdingItem = player.m_21205_();
/*  85 */       ItemStack offHandItem = player.m_21206_();
/*     */       
/*  87 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get()) && 
/*  88 */         entity.m_9236_() instanceof ServerLevel) {
/*  89 */         if (offHandItem.m_41720_().equals(AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get()))
/*  90 */         { livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.CUT_ENDERBLASTER_TWOHAND_RELOAD, 0.0F);
/*  91 */           PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/*  92 */           if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/*  93 */             SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.TRIDENT_FESTIVAL);
/*  94 */             if (skillContainer != null) { Skill skill = skillContainer.getSkill(); if (skill instanceof TridentFestivalSkill) { TridentFestivalSkill tridentFestivalSkill = (TridentFestivalSkill)skill;
/*  95 */                 tridentFestivalSkill.toggleMode(skillContainer); }
/*     */                }
/*     */              }
/*     */            }
/*  99 */         else { livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_THROW_3, 0.0F); }
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/* 104 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.ENDER_AEGIS.get()) && 
/* 105 */         entity.m_9236_() instanceof ServerLevel) {
/* 106 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.ENDER_AEGIS_BULL_CHARGE, 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/* 110 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.ENDER_GLAIVE.get()) && 
/* 111 */         entity.m_9236_() instanceof ServerLevel) {
/* 112 */         boolean success = false;
/* 113 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 114 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 115 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.ENDER_GLAIVE);
/* 116 */           if (skillContainer != null) { Skill skill = skillContainer.getSkill(); if (skill instanceof EnderGlaiveSkill) { EnderGlaiveSkill enderGlaiveSkill = (EnderGlaiveSkill)skill;
/* 117 */               if (skillContainer.getStack() >= 1) {
/* 118 */                 livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.ENDER_GLAIVE_NAPOLEON_SHOOT_3, 0.0F);
/* 119 */                 (enderGlaiveSkill.getResourceType()).consumer
/* 120 */                   .consume(skillContainer, serverPlayerPatch, enderGlaiveSkill.getDefaultConsumptionAmount((PlayerPatch)serverPlayerPatch));
/* 121 */                 success = true;
/*     */               }  }
/*     */              }
/*     */            }
/* 125 */          if (!success) {
/* 126 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AnimsAgony.AGONY_RISING_EAGLE, 0.0F);
/* 127 */           new DelayedTask(10)
/*     */             {
/*     */               public void run() {
/* 130 */                 livingEntityPatch.playAnimationSynchronized((AssetAccessor)AnimsAgony.AGONY_RIPPING_FANGS, 0.0F);
/*     */               }
/*     */             };
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/* 137 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get())) {
/* 138 */         if (entity.m_9236_() instanceof ServerLevel && holdingItem
/* 139 */           .m_41783_() != null && !holdingItem.m_41783_().m_128471_("SnakeAnimation")) {
/* 140 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)WOMAnimations.TORMENT_CHARGED_ATTACK_1, 0.0F);
/*     */         }
/*     */         return;
/*     */       } 
/* 144 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.OBSIDIAN_SLEDGEHAMMER.get()) && 
/* 145 */         entity.m_9236_() instanceof ServerLevel) {
/* 146 */         boolean success = false;
/*     */         
/* 148 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 149 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 150 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.OBSIDIAN_SLEDGEHAMMER);
/* 151 */           if (skillContainer != null && skillContainer.getSkill() instanceof com.pla.annoyingvillagers.skill.ObsidianSledgeHammerSkill && 
/* 152 */             skillContainer.isActivated()) {
/* 153 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.SLEDGEHAMMER_SOLAR_AUTO_3, 0.0F);
/* 154 */             success = true;
/*     */           }  }
/*     */ 
/*     */         
/* 158 */         if (!success) {
/* 159 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)WOMAnimations.TORMENT_BERSERK_DASH, 0.0F);
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 164 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.ENDER_SLAYER_SCYTHE.get()) && 
/* 165 */         entity.m_9236_() instanceof ServerLevel) {
/* 166 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 167 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 168 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.ENDER_SLAYER_SCYTHE);
/* 169 */           if (skillContainer != null) {
/* 170 */             Level level = entity.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (entity
/* 171 */                 .m_20096_() && skillContainer
/* 172 */                 .getSkill() instanceof com.pla.annoyingvillagers.skill.EnderSlayerScytheSkill && 
/* 173 */                 entity.getPersistentData().m_128441_("DragonUUID") && !player.m_36335_().m_41519_(holdingItem.m_41720_())) {
/* 174 */                 Entity dragon = serverLevel.m_8791_(player.getPersistentData().m_128342_("DragonUUID"));
/*     */                 
/* 176 */                 if (dragon instanceof HerobrineDragonEntity) { HerobrineDragonEntity herobrineDragonEntity = (HerobrineDragonEntity)dragon; if (herobrineDragonEntity.m_20197_().isEmpty()) {
/* 177 */                     livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.POSE_UP, 0.0F);
/* 178 */                     herobrineDragonEntity.recallAndLand(true);
/* 179 */                     player.m_36335_().m_41524_(holdingItem.m_41720_(), 60);
/*     */                   }  }
/*     */               
/*     */               }  }
/*     */           
/*     */           }  }
/*     */          return;
/*     */       } 
/* 187 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.NULL_WEAPON.get()) && 
/* 188 */         entity.m_9236_() instanceof ServerLevel) {
/* 189 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 190 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 191 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.NULL_WEAPON);
/* 192 */           if (skillContainer != null && skillContainer.getSkill() instanceof com.pla.annoyingvillagers.skill.NullWeaponSkill && !skillContainer.isActivated()) {
/* 193 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.CLONE_ANTITHEUS_SHOOT, 0.0F);
/*     */           } else {
/* 195 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.NULL_SKELETON_ANTITHEUS_ASCENSION, 0.0F);
/*     */           }  }
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/* 201 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.OBSIDIAN_WEAPON.get()) && 
/* 202 */         entity.m_9236_() instanceof ServerLevel) {
/* 203 */         boolean success = false;
/* 204 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 205 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 206 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.OBSIDIAN_WEAPON);
/* 207 */           if (skillContainer != null && skillContainer.getStack() >= 1 && entity
/* 208 */             .m_9236_() instanceof ServerLevel) {
/* 209 */             Skill skill = skillContainer.getSkill(); if (skill instanceof ObsidianWeaponSkill) { ObsidianWeaponSkill obsidianWeaponSkill = (ObsidianWeaponSkill)skill;
/* 210 */               success = true;
/* 211 */               (obsidianWeaponSkill.getResourceType()).consumer
/* 212 */                 .consume(skillContainer, serverPlayerPatch, obsidianWeaponSkill.getDefaultConsumptionAmount((PlayerPatch)serverPlayerPatch)); }
/*     */           
/*     */           }  }
/* 215 */          if (success) {
/* 216 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F);
/*     */         } else {
/* 218 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_FIST_DASH, 0.0F);
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/* 223 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_WEAPON.get()) && 
/* 224 */         entity.m_9236_() instanceof ServerLevel) {
/* 225 */         boolean success = false;
/* 226 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 227 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 228 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.OBSIDIAN_WEAPON);
/* 229 */           if (skillContainer != null && skillContainer.getStack() >= 1 && entity
/* 230 */             .m_9236_() instanceof ServerLevel) {
/* 231 */             Skill skill = skillContainer.getSkill(); if (skill instanceof ObsidianWeaponSkill) { ObsidianWeaponSkill obsidianWeaponSkill = (ObsidianWeaponSkill)skill;
/* 232 */               success = true;
/* 233 */               (obsidianWeaponSkill.getResourceType()).consumer
/* 234 */                 .consume(skillContainer, serverPlayerPatch, obsidianWeaponSkill.getDefaultConsumptionAmount((PlayerPatch)serverPlayerPatch)); }
/*     */           
/*     */           }  }
/* 237 */          if (success) {
/* 238 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F);
/*     */         } else {
/* 240 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_FIST_DASH, 0.0F);
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/* 245 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.BEDROCK_WEAPON.get()) && 
/* 246 */         entity.m_9236_() instanceof ServerLevel) {
/* 247 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.SUPER_PUNCH, 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/* 251 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get()) && 
/* 252 */         entity.m_9236_() instanceof ServerLevel) {
/* 253 */         boolean success = false;
/* 254 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 255 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 256 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.SHADOW_OBSIDIAN_PILLAR);
/* 257 */           if (skillContainer != null && skillContainer.getStack() >= 1 && entity
/* 258 */             .m_9236_() instanceof ServerLevel) {
/* 259 */             Skill skill = skillContainer.getSkill(); if (skill instanceof ShadowObsidianPillarSkill) { ShadowObsidianPillarSkill shadowObsidianPillarSkill = (ShadowObsidianPillarSkill)skill;
/* 260 */               success = true;
/* 261 */               (shadowObsidianPillarSkill.getResourceType()).consumer
/* 262 */                 .consume(skillContainer, serverPlayerPatch, shadowObsidianPillarSkill.getDefaultConsumptionAmount((PlayerPatch)serverPlayerPatch)); }
/*     */           
/*     */           }  }
/* 265 */          if (success) {
/* 266 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_ANTITHEUS_ASCENDED_DEATHFALL, 0.0F);
/*     */         } else {
/* 268 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_INFERNAL_AUTO_2, 0.0F);
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/* 273 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get()) && 
/* 274 */         entity.m_9236_() instanceof ServerLevel) {
/* 275 */         if (offHandItem.m_41720_().equals(AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get())) {
/* 276 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.SHADOW_OBSIDIAN_SWORD_GESETZ_AUTO_3, 0.0F);
/*     */         } else {
/* 278 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_FIST_DASH, 0.0F);
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/* 283 */       if ((holdingItem.m_41720_().equals(AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get()) || offHandItem
/* 284 */         .m_41720_().equals(AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get())) && 
/* 285 */         entity.m_9236_() instanceof ServerLevel) {
/* 286 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.BIPED_LANDING, 0.0F);
/* 287 */         HerobrineEnderEyeItem.startShadowObsidianMachineGun((ServerLevel)player.m_9236_(), player);
/* 288 */         if (player.m_21205_().m_41720_().equals(AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get())) {
/* 289 */           player.m_21205_().m_41622_(10, (LivingEntity)player, p -> { 
/*     */               });
/* 291 */         } else if (player.m_21206_().m_41720_().equals(AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get())) {
/* 292 */           player.m_21206_().m_41622_(10, (LivingEntity)player, p -> {
/*     */               
/*     */               });
/*     */         } 
/*     */         return;
/*     */       } 
/* 298 */       if (holdingItem.m_41720_() instanceof net.minecraft.world.item.BowItem && 
/* 299 */         entity.m_9236_() instanceof ServerLevel) {
/* 300 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.BOW_AUTO_2, 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/* 304 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.LEGENDARY_SWORD.get()) && 
/* 305 */         entity.m_9236_() instanceof ServerLevel) {
/* 306 */         boolean success = false;
/* 307 */         boolean holdingTridentOffhand = offHandItem.m_41720_().equals(AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get());
/*     */         
/* 309 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 310 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 311 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.LEGENDARY_SWORD);
/* 312 */           if (skillContainer != null) { Skill skill = skillContainer.getSkill(); if (skill instanceof LegendarySwordSkill) { LegendarySwordSkill legendarySwordSkill = (LegendarySwordSkill)skill; if (player.m_9236_() instanceof ServerLevel && 
/* 313 */                 skillContainer.getStack() >= 1) {
/* 314 */                 if (holdingTridentOffhand) {
/* 315 */                   livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.ELECTRIC_FIELD, 0.0F);
/*     */                 } else {
/* 317 */                   livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.YELLOW_TORMENT_CHARGED_ATTACK_3, 0.0F);
/*     */                 } 
/* 319 */                 (legendarySwordSkill.getResourceType()).consumer
/* 320 */                   .consume(skillContainer, serverPlayerPatch, legendarySwordSkill.getDefaultConsumptionAmount((PlayerPatch)serverPlayerPatch));
/* 321 */                 success = true;
/*     */               }  }
/*     */              }
/*     */            }
/*     */         
/* 326 */         if (!success) {
/* 327 */           if (holdingTridentOffhand) {
/* 328 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_THROW_LEGENDARY, 0.0F);
/*     */           } else {
/* 330 */             player.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/* 331 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.CLONE_NAPOLEON_WATERLOW_SHOOT, 0.0F);
/*     */           } 
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 337 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get()) && 
/* 338 */         entity.m_9236_() instanceof ServerLevel) {
/* 339 */         boolean success = false;
/* 340 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 341 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 342 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.WOOPIE_THE_SWORD);
/* 343 */           if (skillContainer != null && skillContainer.getStack() == 1 && entity
/* 344 */             .m_9236_() instanceof ServerLevel) {
/* 345 */             Skill skill = skillContainer.getSkill(); if (skill instanceof WoopieTheSwordSkill) { WoopieTheSwordSkill woopieTheSwordSkill = (WoopieTheSwordSkill)skill;
/* 346 */               success = true;
/* 347 */               (woopieTheSwordSkill.getResourceType()).consumer
/* 348 */                 .consume(skillContainer, serverPlayerPatch, woopieTheSwordSkill.getDefaultConsumptionAmount((PlayerPatch)serverPlayerPatch)); }
/*     */           
/*     */           }  }
/* 351 */          if (success) {
/* 352 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.RUSH_SWORD, 0.0F);
/*     */         } else {
/* 354 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AnimsRuine.RUINE_AUTO_4, 0.0F);
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/* 359 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.GREAT_SWORD.get()) && 
/* 360 */         entity.m_9236_() instanceof ServerLevel) {
/* 361 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 366 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.WOODEN_DOOR.get()) && 
/* 367 */         entity.m_9236_() instanceof ServerLevel) {
/* 368 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)WOMAnimations.TORMENT_CHARGED_ATTACK_2, 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 373 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.CRAFTING_TABLE.get()) && 
/* 374 */         entity.m_9236_() instanceof ServerLevel) {
/* 375 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)WOMAnimations.TORMENT_AIRSLAM, 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 380 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.LADDER.get()) && 
/* 381 */         entity.m_9236_() instanceof ServerLevel) {
/* 382 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.VINDICATOR_SWING_AXE3, 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 387 */       if (holdingItem.m_41720_().equals(AnnoyingVillagersModItems.TRAPDOOR.get()) && 
/* 388 */         entity.m_9236_() instanceof ServerLevel) {
/* 389 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.VINDICATOR_SWING_AXE2, 0.0F);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 395 */       if (playerpatch == null)
/*     */         return; 
/* 397 */       ResourceLocation key = BuiltInRegistries.f_257033_.m_7981_(holdingItem.m_41720_());
/* 398 */       if (ModList.get().isLoaded("efn") && key.m_135827_().equals("efn"))
/*     */         return; 
/* 400 */       if (playerpatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.AXE && 
/* 401 */         entity.m_9236_() instanceof ServerLevel) {
/* 402 */         if (!entity.getPersistentData().m_128441_("AxeCombo")) {
/* 403 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.AXE_HEAVY_AUTO_1, 0.0F);
/* 404 */           entity.getPersistentData().m_128347_("AxeCombo", 1.0D);
/* 405 */         } else if (entity.getPersistentData().m_128459_("AxeCombo") == 1.0D) {
/* 406 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.AXE_HEAVY_AUTO_2, 0.0F);
/* 407 */           entity.getPersistentData().m_128347_("AxeCombo", 2.0D);
/* 408 */         } else if (entity.getPersistentData().m_128459_("AxeCombo") == 2.0D) {
/* 409 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.AXE_FUN_SKILL, 0.0F);
/* 410 */           entity.getPersistentData().m_128473_("AxeCombo");
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 416 */       if ((playerpatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.SWORD || playerpatch
/* 417 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.LONGSWORD || playerpatch
/* 418 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.TACHI || playerpatch
/* 419 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.DAGGER) && (playerpatch
/* 420 */         .getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.SWORD || playerpatch
/* 421 */         .getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.TACHI || playerpatch
/* 422 */         .getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.AXE) && 
/* 423 */         entity.m_9236_() instanceof ServerLevel) {
/* 424 */         if (!entity.getPersistentData().m_128441_("DualSwordCombo")) {
/* 425 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.DAGGER_DUAL_DASH, 0.0F);
/* 426 */           entity.getPersistentData().m_128347_("DualSwordCombo", 1.0D);
/* 427 */         } else if (entity.getPersistentData().m_128459_("DualSwordCombo") == 1.0D) {
/* 428 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)Animations.LONGSWORD_AUTO2, 0.0F);
/* 429 */           entity.getPersistentData().m_128347_("DualSwordCombo", 2.0D);
/* 430 */         } else if (entity.getPersistentData().m_128459_("DualSwordCombo") == 2.0D) {
/* 431 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.DUAL_DANCING_EDGE, 0.0F);
/* 432 */           entity.getPersistentData().m_128347_("DualSwordCombo", 3.0D);
/* 433 */         } else if (entity.getPersistentData().m_128459_("DualSwordCombo") == 3.0D) {
/* 434 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.DUAL_SWORD_DANCING_EDGE, 0.0F);
/* 435 */           entity.getPersistentData().m_128473_("DualSwordCombo");
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 441 */       if ((playerpatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.SWORD || playerpatch
/* 442 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.LONGSWORD || playerpatch
/* 443 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.TACHI || playerpatch
/* 444 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.DAGGER || playerpatch
/* 445 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.UCHIGATANA) && playerpatch
/* 446 */         .getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() != CapabilityItem.WeaponCategories.SWORD && playerpatch
/* 447 */         .getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() != CapabilityItem.WeaponCategories.TACHI && playerpatch
/* 448 */         .getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() != CapabilityItem.WeaponCategories.AXE && 
/* 449 */         entity.m_9236_() instanceof ServerLevel) {
/* 450 */         if (!entity.getPersistentData().m_128441_("SwordCombo")) {
/* 451 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F);
/* 452 */           entity.getPersistentData().m_128347_("SwordCombo", 1.0D);
/* 453 */         } else if (entity.getPersistentData().m_128459_("SwordCombo") == 1.0D) {
/* 454 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F);
/* 455 */           entity.getPersistentData().m_128347_("SwordCombo", 2.0D);
/* 456 */         } else if (entity.getPersistentData().m_128459_("SwordCombo") == 2.0D) {
/* 457 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F);
/* 458 */           entity.getPersistentData().m_128473_("SwordCombo");
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 464 */       if (playerpatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD && 
/* 465 */         entity.m_9236_() instanceof ServerLevel) {
/* 466 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.GIANT_WHIRLWIND, 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 471 */       if ((playerpatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.FIST || playerpatch
/* 472 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.NOT_WEAPON || playerpatch
/* 473 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.RANGED) && 
/* 474 */         entity.m_9236_() instanceof ServerLevel) {
/* 475 */         if (entity.m_20142_()) {
/* 476 */           if (entity.m_6144_()) {
/* 477 */             if (entity.m_9236_() instanceof ServerLevel) {
/* 478 */               livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.WHIRLWIND_KICK_LEFT, 0.0F);
/*     */             }
/*     */           }
/* 481 */           else if (entity.m_9236_() instanceof ServerLevel) {
/* 482 */             livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.WHIRLWIND_KICK, 0.0F);
/*     */           }
/*     */         
/*     */         }
/* 486 */         else if (!entity.getPersistentData().m_128441_("FistCombo")) {
/* 487 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.FIST_LEFT, 0.0F);
/* 488 */           entity.getPersistentData().m_128347_("FistCombo", 1.0D);
/* 489 */         } else if (entity.getPersistentData().m_128459_("FistCombo") == 1.0D) {
/* 490 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.FIST_UP, 0.0F);
/* 491 */           entity.getPersistentData().m_128347_("FistCombo", 2.0D);
/* 492 */         } else if (entity.getPersistentData().m_128459_("FistCombo") == 2.0D) {
/* 493 */           livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.FIST_DASH, 0.0F);
/* 494 */           entity.getPersistentData().m_128473_("FistCombo");
/*     */         } 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 501 */       if ((playerpatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.SPEAR || playerpatch
/* 502 */         .getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.TRIDENT) && 
/* 503 */         entity.m_9236_() instanceof ServerLevel) {
/* 504 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.SPEAR_THRUST, 0.0F);
/*     */       }
/*     */ 
/*     */       
/* 508 */       registerMoreSpecialAttackCategories(playerpatch, entity, livingEntityPatch); }
/*     */   
/*     */   }
/*     */   
/*     */   private static void registerMoreSpecialAttackCategories(PlayerPatch<?> playerpatch, Entity entity, LivingEntityPatch<?> livingEntityPatch) {}
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\SpecialAttackOnKeyPressedEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */