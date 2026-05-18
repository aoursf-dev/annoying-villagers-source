/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.clazz.NullWeapon;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import com.pla.annoyingvillagers.entity.LowHerobrineCloneEntity;
/*     */ import com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity;
/*     */ import com.pla.annoyingvillagers.entity.NullEntity;
/*     */ import com.pla.annoyingvillagers.entity.ReaperHerobrineEntity;
/*     */ import com.pla.annoyingvillagers.entity.ShadowHerobrineEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.TeamUtil;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.function.BiFunction;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ public class HerobrineCommon {
/*     */   public static boolean canJump(MobPatch<?> mobpatch) {
/*  38 */     return (((Mob)mobpatch.getOriginal()).m_20096_() && !((Mob)mobpatch.getOriginal()).m_20159_());
/*     */   }
/*     */   
/*     */   public static boolean canPerformHealing(MobPatch<?> mobpatch) {
/*  42 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/*  43 */       if (herobrineMob instanceof com.pla.annoyingvillagers.entity.HerobrineCloneEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineCloneEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.HerobrineChrisEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.Herobrine7Entity)
/*     */       {
/*     */         
/*  46 */         if (getEntities(herobrineMob).isEmpty()) {
/*  47 */           return false;
/*     */         }
/*     */       }
/*  50 */       return (!herobrineMob.isSacrificing() && !herobrineMob.isHealing() && herobrineMob.getHealingCooldown() == 0); }
/*     */     
/*  52 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canSpinning(MobPatch<?> mobpatch) {
/*  56 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof NullWeapon) { NullWeapon nullWeapon = (NullWeapon)entity;
/*  57 */       return nullWeapon.isSpinning(); }
/*     */     
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canSummonDarkOb(MobPatch<?> mobpatch) {
/*  63 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)entity;
/*  64 */       return (!shadowHerobrineEntity.isDarkObReady() && shadowHerobrineEntity.getSummonDarkObCooldown() == 0); }
/*     */     
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canShootDarkOb(MobPatch<?> mobpatch) {
/*  70 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)entity;
/*  71 */       return shadowHerobrineEntity.isDarkObReady(); }
/*     */     
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canPlayObsidianMachine(MobPatch<?> mobpatch) {
/*  77 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)entity;
/*  78 */       return (shadowHerobrineEntity.getState() == 2 && shadowHerobrineEntity.getObsidianMachineGunCooldown() == 0 && shadowHerobrineEntity.getObsidianMachineGunTick() == 0); }
/*     */     
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canMountOrDismountDragon(MobPatch<?> mobpatch) {
/*  84 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)entity;
/*  85 */       return (reaperHerobrineEntity.getHealingHerobrineDragon() != null || reaperHerobrineEntity
/*  86 */         .getThunderHerobrineDragon() != null || reaperHerobrineEntity
/*  87 */         .getMeteoriteHerobrineDragon() != null); }
/*     */     
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canChangeToSecondForm(MobPatch<?> mobpatch) {
/*  93 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/*  94 */       ItemStack item = herobrineMob.m_21205_();
/*  95 */       if (herobrineMob instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity && item
/*  96 */         .m_41783_() != null && item.m_41783_().m_128441_("SnakeAnimation")) {
/*  97 */         return false;
/*     */       }
/*  99 */       if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob; if (reaperHerobrineEntity
/* 100 */           .getThunderHerobrineDragon() == null)
/* 101 */           return false;  }
/*     */       
/* 103 */       if (herobrineMob instanceof com.pla.annoyingvillagers.entity.HerobrineCloneEntity || herobrineMob instanceof ShadowHerobrineEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.Herobrine7Entity || herobrineMob instanceof com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity)
/*     */       {
/* 105 */         return false;
/*     */       }
/* 107 */       return (herobrineMob.getState() == 0); }
/*     */     
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canPlaySecondFormAnimation(MobPatch<?> mobpatch) {
/* 113 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 114 */       ItemStack item = herobrineMob.m_21205_();
/* 115 */       if (herobrineMob instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity && item
/* 116 */         .m_41783_() != null && item.m_41783_().m_128441_("SnakeAnimation")) {
/* 117 */         return false;
/*     */       }
/* 119 */       return (herobrineMob.getState() != 0); }
/*     */     
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canCastMeteorite(MobPatch<?> mobpatch) {
/* 125 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 126 */       if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob; if (reaperHerobrineEntity
/* 127 */           .getMeteoriteHerobrineDragon() == null || reaperHerobrineEntity.getMeteoriteHerobrineDragon().isRecallActive())
/* 128 */           return false;  }
/*     */       
/* 130 */       return (herobrineMob.getState() != 0); }
/*     */     
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canSummonNullSkeleton(MobPatch<?> mobpatch) {
/* 136 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof NullEntity) { NullEntity nullEntity = (NullEntity)entity;
/* 137 */       return nullEntity.isAvailableWitherSkeletonSlot(); }
/*     */     
/* 139 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canRespawnCrystal(MobPatch<?> mobpatch) {
/* 143 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 144 */       if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob; if (reaperHerobrineEntity
/* 145 */           .getHealingHerobrineDragon() == null || 
/* 146 */           !reaperHerobrineEntity.getHealingHerobrineDragon().m_20197_().isEmpty())
/* 147 */           return false;  }
/*     */       
/* 149 */       return (herobrineMob.getState() != 0); }
/*     */     
/* 151 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canCastThunder(MobPatch<?> mobpatch) {
/* 155 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 156 */       if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob; if (reaperHerobrineEntity
/* 157 */           .getThunderHerobrineDragon() == null || reaperHerobrineEntity.getThunderHerobrineDragon().isRecallActive())
/* 158 */           return false;  }
/*     */       
/* 160 */       return (herobrineMob.getState() != 0); }
/*     */     
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canPerformGuarding(MobPatch<?> mobpatch) {
/* 166 */     Entity entity = mobpatch.getOriginal();
/* 167 */     return (!(entity instanceof com.pla.annoyingvillagers.entity.HerobrineCloneEntity) && !(entity instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineCloneEntity) && !(entity instanceof com.pla.annoyingvillagers.entity.HerobrineChrisEntity) && !(entity instanceof com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity) && !(entity instanceof com.pla.annoyingvillagers.entity.Herobrine7Entity));
/*     */   } public static void performHealingAnimation(MobPatch<?> mobpatch) {
/*     */     ServerLevel serverLevel;
/*     */     HerobrineMob herobrineMob;
/*     */     Entity chosen;
/* 172 */     LivingEntity entity = (LivingEntity)mobpatch.getOriginal();
/* 173 */     Level level = entity.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; } else { return; }
/* 174 */      if (entity instanceof HerobrineMob) { herobrineMob = (HerobrineMob)entity; }
/*     */     else { return; }
/* 176 */      herobrineMob.setHealing(true);
/* 177 */     List<Entity> bound = getEntities(herobrineMob);
/*     */     
/* 179 */     Random random = new Random();
/*     */     
/* 181 */     if (bound.isEmpty()) {
/* 182 */       LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity2; double radius = 3.0D + random.nextDouble() * 3.0D;
/* 183 */       double angle = random.nextDouble() * 6.283185307179586D;
/*     */       
/* 185 */       double dx = Math.cos(angle) * radius;
/* 186 */       double dz = Math.sin(angle) * radius;
/*     */       
/* 188 */       Vec3 rawPos = new Vec3(entity.m_20185_() + dx, entity.m_20186_(), entity.m_20189_() + dz);
/* 189 */       BlockPos xz = BlockPos.m_274561_(rawPos.f_82479_, 0.0D, rawPos.f_82481_);
/* 190 */       int y = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, xz).m_123342_();
/* 191 */       Vec3 spawnPos = new Vec3(rawPos.f_82479_, y, rawPos.f_82481_);
/*     */ 
/*     */       
/* 194 */       if (random.nextBoolean()) {
/*     */         
/* 196 */         LowHerobrineCloneEntity low = new LowHerobrineCloneEntity((EntityType)AnnoyingVillagersModEntities.LOW_HEROBRINE_CLONE.get(), (Level)serverLevel);
/*     */         
/* 198 */         low.m_7678_(spawnPos.f_82479_, spawnPos.f_82480_, spawnPos.f_82481_, herobrineMob.m_146908_(), herobrineMob.m_146909_());
/* 199 */         low.setPossessedByEntity(herobrineMob);
/* 200 */         low.setRenderPortal(false);
/* 201 */         low.setPossessedByUuid(herobrineMob.m_20148_());
/* 202 */         low.m_21557_(true);
/* 203 */         TeamUtil.addOrJoinTeam((Entity)low, "herobrine");
/* 204 */         serverLevel.m_7967_((Entity)low);
/* 205 */         LowHerobrineCloneEntity lowHerobrineCloneEntity1 = low;
/*     */       } else {
/*     */         
/* 208 */         LowShadowHerobrineCloneEntity low = new LowShadowHerobrineCloneEntity((EntityType)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (Level)serverLevel);
/*     */         
/* 210 */         low.m_7678_(spawnPos.f_82479_, spawnPos.f_82480_, spawnPos.f_82481_, herobrineMob.m_146908_(), herobrineMob.m_146909_());
/* 211 */         low.setPossessedByEntity(herobrineMob);
/* 212 */         low.setRenderPortal(false);
/* 213 */         low.setPossessedByUuid(herobrineMob.m_20148_());
/* 214 */         low.m_21557_(true);
/* 215 */         TeamUtil.addOrJoinTeam((Entity)low, "herobrine");
/* 216 */         serverLevel.m_7967_((Entity)low);
/* 217 */         lowShadowHerobrineCloneEntity2 = low;
/*     */       } 
/*     */       
/* 220 */       herobrineMob.boundPossessed((Entity)lowShadowHerobrineCloneEntity2);
/* 221 */       LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity1 = lowShadowHerobrineCloneEntity2;
/*     */     } else {
/* 223 */       chosen = bound.get(random.nextInt(bound.size()));
/*     */     } 
/*     */     
/* 226 */     if (chosen instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadow = (LowShadowHerobrineCloneEntity)chosen;
/* 227 */       if (lowShadow.isHealing())
/* 228 */         return;  lowShadow.setPossessedByEntity(herobrineMob);
/* 229 */       lowShadow.setPossessedByUuid(herobrineMob.m_20148_());
/* 230 */       lowShadow.setSacrificing(false);
/* 231 */       lowShadow.setHealing(true);
/* 232 */       lowShadow.m_21557_(true);
/*     */       
/*     */       return; }
/*     */     
/* 236 */     if (chosen instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity low = (LowHerobrineCloneEntity)chosen;
/* 237 */       if (low.isHealing())
/* 238 */         return;  low.setPossessedByEntity(herobrineMob);
/* 239 */       low.setPossessedByUuid(herobrineMob.m_20148_());
/* 240 */       low.setHealing(true);
/* 241 */       low.m_21557_(true); }
/*     */ 
/*     */     
/* 244 */     chosen.m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_UNDERSTOOD.get(), 1.0F, 1.0F);
/*     */   }
/*     */   @NotNull
/*     */   public static List<Entity> getEntities(HerobrineMob herobrineMob) {
/* 248 */     List<Entity> bound = new ArrayList<>(4);
/* 249 */     Entity c1 = herobrineMob.getFirstPossessedHerobrine();
/* 250 */     Entity c2 = herobrineMob.getSecondPossessedHerobrine();
/* 251 */     Entity c3 = herobrineMob.getThirdPossessedHerobrine();
/* 252 */     Entity c4 = herobrineMob.getFourthPossessedHerobrine();
/*     */     
/* 254 */     if (c1 != null && c1.m_6084_()) bound.add(c1); 
/* 255 */     if (c2 != null && c2.m_6084_()) bound.add(c2); 
/* 256 */     if (c3 != null && c3.m_6084_()) bound.add(c3); 
/* 257 */     if (c4 != null && c4.m_6084_()) bound.add(c4); 
/* 258 */     return bound;
/*     */   }
/*     */   
/*     */   public static void changeToSecondForm(MobPatch<?> mobpatch) {
/* 262 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 263 */       herobrineMob.setState(1);
/* 264 */       herobrineMob.setSecondFormHitLeft((new Random()).nextInt(2, 3));
/* 265 */       if (herobrineMob instanceof com.pla.annoyingvillagers.entity.AegisHerobrineEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity || herobrineMob instanceof ReaperHerobrineEntity || herobrineMob instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity)
/*     */       {
/*     */         
/* 268 */         herobrineMob.m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_WEAPON_SCREAMING.get(), 0.8F, 1.0F);
/*     */       } }
/*     */   
/*     */   }
/*     */   
/*     */   public static void releaseWeapon(MobPatch<?> mobpatch) {
/* 274 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof NullEntity) { NullEntity nullEntity = (NullEntity)entity;
/* 275 */       nullEntity.releaseRandomWeapons((nullEntity.getState() < 2) ? (
/* 276 */           new Random()).nextInt(1, 3) : (
/* 277 */           new Random()).nextInt(3, 5)); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void playSecondFormAnimation(MobPatch<?> mobpatch) {
/* 282 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 283 */       ItemStack item = herobrineMob.m_21205_();
/* 284 */       if (herobrineMob.getState() < 2) {
/* 285 */         herobrineMob.setSecondFormHitLeft(herobrineMob.getSecondFormHitLeft() - 1);
/*     */       }
/* 287 */       if (herobrineMob instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity && herobrineMob.m_9236_() instanceof ServerLevel)
/* 288 */       { SnakeBladeHit.process(item, (LivingEntity)herobrineMob);
/* 289 */         item.m_41784_().m_128379_("SnakeAnimation", true); }
/* 290 */       else if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob; if (herobrineMob.m_9236_() instanceof ServerLevel) {
/* 291 */           HerobrineDragonEntity herobrineDragonEntity = reaperHerobrineEntity.getThunderHerobrineDragon();
/* 292 */           if (herobrineDragonEntity != null)
/* 293 */             herobrineDragonEntity.shootThunderBreathAtTarget(herobrineMob.m_5448_()); 
/*     */         }  }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   public static void playSecondFormSpecialAnimation(MobPatch<?> mobpatch) {
/* 300 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 301 */       if (herobrineMob.getState() < 2) {
/* 302 */         herobrineMob.setSecondFormHitLeft(herobrineMob.getSecondFormHitLeft() - 1);
/*     */       }
/* 304 */       if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob; if (herobrineMob.m_9236_() instanceof ServerLevel) {
/* 305 */           HerobrineDragonEntity herobrineDragonEntity = reaperHerobrineEntity.getMeteoriteHerobrineDragon();
/* 306 */           if (herobrineDragonEntity != null)
/* 307 */             herobrineDragonEntity.shootMeteoriteAtTarget(herobrineMob.m_5448_()); 
/*     */         }  }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   public static void playSecondFormGuardAnimation(MobPatch<?> mobpatch) {
/* 314 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 315 */       ItemStack item = herobrineMob.m_21205_();
/* 316 */       if (herobrineMob.getState() < 2) {
/* 317 */         herobrineMob.setSecondFormHitLeft(herobrineMob.getSecondFormHitLeft() - 1);
/*     */       }
/* 319 */       if (herobrineMob instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity && herobrineMob.m_9236_() instanceof ServerLevel) {
/* 320 */         SnakeBladeHit.processGuard(item, (LivingEntity)herobrineMob);
/* 321 */         item.m_41784_().m_128379_("SnakeAnimation", true);
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public static void respawnCrystal(MobPatch<?> mobpatch) {
/* 327 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 328 */       if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob; Level level = herobrineMob.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 329 */           if (reaperHerobrineEntity.getHealingHerobrineDragon() != null && reaperHerobrineEntity
/* 330 */             .getHealingHerobrineDragon().m_6084_() && reaperHerobrineEntity
/* 331 */             .getHealingHerobrineDragon().m_20197_().isEmpty()) {
/* 332 */             EndCrystal endCrystal = new EndCrystal(EntityType.f_20564_, (Level)serverLevel);
/* 333 */             endCrystal.m_6027_(reaperHerobrineEntity.getHealingHerobrineDragon().m_20185_(), reaperHerobrineEntity.getHealingHerobrineDragon().m_20186_(), reaperHerobrineEntity.getHealingHerobrineDragon().m_20189_());
/* 334 */             serverLevel.m_7967_((Entity)endCrystal);
/* 335 */             endCrystal.m_7998_((Entity)reaperHerobrineEntity.getHealingHerobrineDragon(), true);
/*     */           }  }
/*     */          }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   public static void jump(MobPatch<?> mobpatch) {
/* 343 */     Entity entity = mobpatch.getOriginal();
/* 344 */     if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 345 */       herobrineMob.jump(); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void giveSlowFalling(MobPatch<?> mobpatch) {
/* 350 */     Entity entity = mobpatch.getOriginal();
/* 351 */     if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity;
/* 352 */       herobrineMob.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 60, 1)); }
/*     */   
/*     */   }
/*     */   public static void performEscapeRunAwayWithLowClone(final MobPatch<?> mobpatch) {
/*     */     final ServerLevel serverLevel;
/* 357 */     final Mob mob = (Mob)mobpatch.getOriginal();
/* 358 */     Level level = mob.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; } else { return; }
/* 359 */      CombatCommon.performEscapeRunAway(mobpatch);
/* 360 */     if (mob.f_19797_ % 10 == 0) {
/* 361 */       new DelayedTask(1)
/*     */         {
/*     */           public void run() {
/* 364 */             if (!mob.m_6084_())
/*     */               return; 
/* 366 */             mobpatch.playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_INWARD, 0.0F);
/*     */             
/* 368 */             LivingEntity target = mob.m_5448_();
/*     */ 
/*     */             
/* 371 */             Direction dir = (target != null) ? Direction.m_122366_(target.m_20185_() - mob.m_20185_(), 0.0D, target.m_20189_() - mob.m_20189_()) : mob.m_6350_();
/*     */             
/* 373 */             Random random = new Random();
/* 374 */             int dist = 1 + random.nextInt(3);
/*     */             
/* 376 */             int rot = random.nextInt(4);
/* 377 */             BiFunction<Integer, Integer, int[]> toWorld = CombatCommon.getIntegerIntegerBiFunction((Entity)mob, rot);
/* 378 */             int lateral = random.nextInt(3) - 1;
/* 379 */             int[] dxz = toWorld.apply(Integer.valueOf(lateral), Integer.valueOf(0));
/*     */             
/* 381 */             BlockPos baseXZ = mob.m_20183_().m_5484_(dir, dist).m_7918_(dxz[0], 0, dxz[1]);
/* 382 */             int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, baseXZ).m_123342_();
/* 383 */             BlockPos spawnPos = new BlockPos(baseXZ.m_123341_(), surfaceY, baseXZ.m_123343_());
/*     */ 
/*     */             
/* 386 */             LowShadowHerobrineCloneEntity clone = new LowShadowHerobrineCloneEntity((EntityType)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (Level)serverLevel);
/*     */             
/* 388 */             float yaw = dir.m_122435_();
/* 389 */             clone.m_7678_(spawnPos.m_123341_() + 0.5D, spawnPos.m_123342_(), spawnPos.m_123343_() + 0.5D, yaw, 0.0F);
/* 390 */             clone.setRenderPortal(false);
/*     */             
/* 392 */             clone.setForEscaping(true);
/* 393 */             clone.m_21557_(true);
/* 394 */             if (mob instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)mob;
/* 395 */               clone.setPossessedByEntity(herobrineMob);
/* 396 */               clone.setPossessedByUuid(herobrineMob.m_20148_()); }
/*     */ 
/*     */             
/* 399 */             serverLevel.m_7967_((Entity)clone);
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */   
/*     */   public static void performAgonySpecialAttack(final MobPatch<?> mobpatch) {
/* 406 */     Entity entity = mobpatch.getOriginal();
/* 407 */     if (entity instanceof HerobrineMob) {
/* 408 */       new DelayedTask(10)
/*     */         {
/*     */           public void run() {
/* 411 */             mobpatch.playAnimationSynchronized((AssetAccessor)AnimsAgony.AGONY_RIPPING_FANGS, 0.0F);
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */   
/*     */   public static void performSpinning(MobPatch<?> mobpatch) {
/* 418 */     Entity entity = mobpatch.getOriginal();
/* 419 */     if (entity instanceof NullWeapon) { NullWeapon nullWeapon = (NullWeapon)entity;
/* 420 */       nullWeapon.setSpinning(false); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void performGuardWeaponSpinning(MobPatch<?> mobpatch) {
/* 425 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof NullEntity) { NullEntity nullEntity = (NullEntity)entity;
/* 426 */       nullEntity.setSpinningToAllWeaponsAvailable(true); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void mountOrDismountDragon(MobPatch<?> mobpatch) {
/* 431 */     Entity entity = mobpatch.getOriginal();
/* 432 */     if (entity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)entity; if (herobrineMob instanceof ReaperHerobrineEntity) { ReaperHerobrineEntity reaperHerobrineEntity = (ReaperHerobrineEntity)herobrineMob;
/* 433 */         if (reaperHerobrineEntity.m_20159_()) {
/* 434 */           reaperHerobrineEntity.m_8127_();
/*     */         }
/* 436 */         else if (reaperHerobrineEntity.getThunderHerobrineDragon() != null) {
/* 437 */           reaperHerobrineEntity.getThunderHerobrineDragon().recallAndLand(true);
/* 438 */         } else if (reaperHerobrineEntity.getMeteoriteHerobrineDragon() != null) {
/* 439 */           reaperHerobrineEntity.getMeteoriteHerobrineDragon().recallAndLand(true);
/*     */         }  }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   public static void performSummonDarkOb(MobPatch<?> mobpatch) {
/* 446 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)entity;
/* 447 */       shadowHerobrineEntity.spawnDarkObEntities(); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void performShootDarkOb(MobPatch<?> mobpatch) {
/* 452 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)entity;
/* 453 */       shadowHerobrineEntity.shootDarkObsAtTarget(2.0D); }
/*     */   
/*     */   }
/*     */   
/*     */   public static void performObsidianMachine(MobPatch<?> mobpatch) {
/* 458 */     Entity entity = mobpatch.getOriginal(); if (entity instanceof ShadowHerobrineEntity) { ShadowHerobrineEntity shadowHerobrineEntity = (ShadowHerobrineEntity)entity;
/* 459 */       shadowHerobrineEntity.m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/* 460 */       shadowHerobrineEntity.m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get()));
/* 461 */       if (shadowHerobrineEntity.m_9236_() instanceof ServerLevel)
/* 462 */         shadowHerobrineEntity.m_5496_((SoundEvent)AnnoyingVillagersModSounds.SHADOW_HEROBRINE_SAY_OBSIDIAN_MACHINE_GUN.get(), 1.0F, 1.0F);  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineCommon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */