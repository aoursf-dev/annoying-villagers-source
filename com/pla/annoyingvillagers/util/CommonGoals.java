/*     */ package com.pla.annoyingvillagers.util;
/*     */ import com.pla.annoyingvillagers.entity.GreenVillagerGeneralEntity;
/*     */ import com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import com.pla.annoyingvillagers.entity.VillagerScoutCaptainEntity;
/*     */ import com.pla.annoyingvillagers.entity.VillagerScoutEntity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
/*     */ import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
/*     */ import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import se.gory_moon.player_mobs.entity.PlayerMobEntity;
/*     */ 
/*     */ public class CommonGoals {
/*     */   public static void registerGoalForHostileNpc(final Monster monster) {
/*  21 */     monster.m_21573_().m_26575_().m_77355_(true);
/*  22 */     monster.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)monster, new Class[0]));
/*  23 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, Player.class, true, false));
/*  24 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, PlayerNpcEntity.class, true, false));
/*  25 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, SteveEntity.class, true, false));
/*  26 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, AngrySteveEntity.class, true, false));
/*  27 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, ChrisEntity.class, true, false));
/*  28 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, AlexEntity.class, true, false));
/*  29 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, JevEntity.class, true, false));
/*  30 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, Villager.class, true, false));
/*  31 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, IronGolem.class, true, false));
/*  32 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, BlueDemonEntity.class, true, false));
/*  33 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, VillagerScoutEntity.class, true, false));
/*  34 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, VillagerScoutCaptainEntity.class, true, false));
/*  35 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, RedVillagerGeneralEntity.class, true, false));
/*  36 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, BlueVillagerGeneralEntity.class, true, false));
/*  37 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, GreenVillagerGeneralEntity.class, true, false));
/*  38 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, PurpleVillagerGeneralEntity.class, true, false));
/*  39 */     monster.f_21345_.m_25352_(2, (Goal)new MeleeAttackGoal((PathfinderMob)monster, 1.2D, false) {
/*     */           protected double m_6639_(@NotNull LivingEntity livingEntity) {
/*  41 */             return (monster.m_20205_() * monster.m_20205_() + livingEntity.m_20205_());
/*     */           }
/*     */         });
/*  44 */     monster.f_21345_.m_25352_(3, (Goal)new RandomStrollGoal((PathfinderMob)monster, 1.0D));
/*  45 */     monster.f_21345_.m_25352_(4, (Goal)new RandomLookAroundGoal((Mob)monster));
/*  46 */     monster.f_21345_.m_25352_(5, (Goal)new FloatGoal((Mob)monster));
/*     */   }
/*     */   
/*     */   public static void registerGoalForBlueDemonNpc(final Monster monster) {
/*  50 */     monster.m_21573_().m_26575_().m_77355_(true);
/*  51 */     monster.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal((PathfinderMob)monster, new Class[0]));
/*  52 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, HerobrineMob.class, true, false));
/*  53 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, LowHerobrineCloneEntity.class, true, false));
/*  54 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, LowShadowHerobrineCloneEntity.class, true, false));
/*  55 */     monster.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)monster, EliteHerobrineKnockedEntity.class, true, false));
/*  56 */     monster.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)monster, Player.class, true, false));
/*  57 */     monster.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)monster, PlayerNpcEntity.class, true, false));
/*  58 */     monster.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)monster, AngrySteveEntity.class, true, false));
/*  59 */     monster.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)monster, Villager.class, true, false));
/*  60 */     monster.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)monster, VillagerScoutEntity.class, true, false));
/*  61 */     monster.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)monster, VillagerScoutCaptainEntity.class, true, false));
/*  62 */     monster.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)monster, RedVillagerGeneralEntity.class, true, false));
/*  63 */     monster.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)monster, BlueVillagerGeneralEntity.class, true, false));
/*  64 */     monster.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)monster, GreenVillagerGeneralEntity.class, true, false));
/*  65 */     monster.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)monster, PurpleVillagerGeneralEntity.class, true, false));
/*  66 */     monster.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)monster, AbstractIllager.class, true, false));
/*  67 */     monster.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal((PathfinderMob)monster, 1.2D, false) {
/*     */           protected double m_6639_(@NotNull LivingEntity livingEntity) {
/*  69 */             return (monster.m_20205_() * monster.m_20205_() + livingEntity.m_20205_());
/*     */           }
/*     */         });
/*  72 */     monster.f_21345_.m_25352_(4, (Goal)new RandomStrollGoal((PathfinderMob)monster, 1.0D));
/*  73 */     monster.f_21345_.m_25352_(5, (Goal)new RandomLookAroundGoal((Mob)monster));
/*  74 */     monster.f_21345_.m_25352_(6, (Goal)new FloatGoal((Mob)monster));
/*     */   }
/*     */   
/*     */   public static void registerGoalForVillagerKnightNpc(PathfinderMob mob) {
/*  78 */     mob.m_21573_().m_26575_().m_77355_(true);
/*  79 */     mob.f_21346_.m_25352_(1, (Goal)(new HurtByTargetGoal(mob, new Class[0])).m_26044_(new Class[0]));
/*     */     
/*  81 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, HerobrineMob.class, true, false));
/*  82 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, LowHerobrineCloneEntity.class, true, false));
/*  83 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, LowShadowHerobrineCloneEntity.class, true, false));
/*     */     
/*  85 */     mob.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)mob, PlayerNpcEntity.class, true, false));
/*  86 */     mob.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)mob, Player.class, true, false));
/*  87 */     mob.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)mob, Monster.class, true, false));
/*  88 */     mob.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)mob, AbstractIllager.class, true, false));
/*  89 */     mob.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)mob, BlueDemonEntity.class, true, false));
/*     */     
/*  91 */     mob.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)mob, SteveEntity.class, true, false));
/*  92 */     mob.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)mob, AngrySteveEntity.class, true, false));
/*  93 */     mob.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)mob, AlexEntity.class, true, false));
/*  94 */     mob.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)mob, ChrisEntity.class, true, false));
/*  95 */     mob.f_21345_.m_25352_(5, (Goal)new MeleeAttackGoal(mob, 1.5D, false) {
/*     */           protected double m_6639_(@NotNull LivingEntity livingentity) {
/*  97 */             return (this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + livingentity.m_20205_());
/*     */           }
/*     */         });
/* 100 */     mob.f_21345_.m_25352_(6, (Goal)new RandomStrollGoal(mob, 1.0D));
/* 101 */     mob.f_21345_.m_25352_(7, (Goal)new FollowMobGoal((Mob)mob, 1.3D, 20.0F, 15.0F));
/* 102 */     mob.f_21345_.m_25352_(8, (Goal)new OpenDoorGoal((Mob)mob, true));
/* 103 */     mob.f_21345_.m_25352_(9, (Goal)new OpenDoorGoal((Mob)mob, false));
/* 104 */     mob.f_21345_.m_25352_(10, (Goal)new RandomLookAroundGoal((Mob)mob));
/* 105 */     mob.f_21345_.m_25352_(11, (Goal)new FloatGoal((Mob)mob));
/*     */   }
/*     */   
/*     */   public static void registerGoalForNeutralNpc(PathfinderMob mob) {
/* 109 */     mob.m_21573_().m_26575_().m_77355_(true);
/*     */     
/* 111 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, HerobrineMob.class, true, false));
/* 112 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, LowHerobrineCloneEntity.class, true, false));
/* 113 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, LowShadowHerobrineCloneEntity.class, true, false));
/* 114 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, EliteHerobrineKnockedEntity.class, true, false));
/* 115 */     mob.f_21346_.m_25352_(2, (Goal)new HurtByTargetGoal(mob, new Class[0]));
/* 116 */     mob.f_21345_.m_25352_(2, (Goal)new MeleeAttackGoal(mob, 1.2D, false) {
/*     */           protected double m_6639_(@NotNull LivingEntity livingentity) {
/* 118 */             return (this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + livingentity.m_20205_());
/*     */           }
/*     */         });
/*     */     
/* 122 */     if (!(mob.m_5448_() instanceof VillagerScoutEntity)) {
/* 123 */       mob.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal(mob, VillagerScoutEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 125 */     if (!(mob.m_5448_() instanceof VillagerScoutCaptainEntity)) {
/* 126 */       mob.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal(mob, VillagerScoutCaptainEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 128 */     if (!(mob.m_5448_() instanceof BlueVillagerGeneralEntity)) {
/* 129 */       mob.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal(mob, BlueVillagerGeneralEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 131 */     if (!(mob.m_5448_() instanceof GreenVillagerGeneralEntity)) {
/* 132 */       mob.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal(mob, GreenVillagerGeneralEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 134 */     if (!(mob.m_5448_() instanceof RedVillagerGeneralEntity)) {
/* 135 */       mob.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal(mob, RedVillagerGeneralEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 137 */     if (!(mob.m_5448_() instanceof PurpleVillagerGeneralEntity)) {
/* 138 */       mob.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal(mob, PurpleVillagerGeneralEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 140 */     mob.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)mob, Monster.class, false, target -> (!(target instanceof PlayerMobEntity) && !(target instanceof BlueDemonEntity))));
/* 141 */     mob.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)mob, AbstractIllager.class, true, false));
/* 142 */     mob.f_21345_.m_25352_(3, (Goal)new MeleeAttackGoal(mob, 1.5D, false) {
/*     */           protected double m_6639_(@NotNull LivingEntity livingEntity) {
/* 144 */             return (this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + livingEntity.m_20205_());
/*     */           }
/*     */         });
/* 147 */     mob.f_21345_.m_25352_(4, (Goal)new RandomStrollGoal(mob, 1.0D));
/* 148 */     mob.f_21345_.m_25352_(5, (Goal)new OpenDoorGoal((Mob)mob, true));
/* 149 */     mob.f_21346_.m_25352_(6, (Goal)new HurtByTargetGoal(mob, new Class[0]));
/* 150 */     mob.f_21345_.m_25352_(7, (Goal)new OpenDoorGoal((Mob)mob, false));
/* 151 */     mob.f_21345_.m_25352_(8, (Goal)new RandomLookAroundGoal((Mob)mob));
/* 152 */     mob.f_21345_.m_25352_(9, (Goal)new FloatGoal((Mob)mob));
/*     */   }
/*     */   
/*     */   public static void registerGoalForCrazyNpc(PathfinderMob mob) {
/* 156 */     mob.m_21573_().m_26575_().m_77355_(true);
/* 157 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, Monster.class, false, false));
/* 158 */     mob.f_21346_.m_25352_(1, (Goal)new HurtByTargetGoal(mob, new Class[0]));
/* 159 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, HerobrineMob.class, true, false));
/* 160 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, LowHerobrineCloneEntity.class, true, false));
/* 161 */     mob.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)mob, LowShadowHerobrineCloneEntity.class, true, false));
/* 162 */     mob.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)mob, PlayerNpcEntity.class, true, false));
/* 163 */     mob.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)mob, VillagerScoutEntity.class, false, false));
/* 164 */     mob.f_21346_.m_25352_(4, (Goal)new NearestAttackableTargetGoal((Mob)mob, VillagerScoutCaptainEntity.class, false, false));
/* 165 */     mob.f_21346_.m_25352_(5, (Goal)new NearestAttackableTargetGoal((Mob)mob, RedVillagerGeneralEntity.class, false, false));
/* 166 */     mob.f_21346_.m_25352_(6, (Goal)new NearestAttackableTargetGoal((Mob)mob, BlueVillagerGeneralEntity.class, false, false));
/* 167 */     mob.f_21346_.m_25352_(7, (Goal)new NearestAttackableTargetGoal((Mob)mob, GreenVillagerGeneralEntity.class, false, false));
/* 168 */     mob.f_21346_.m_25352_(8, (Goal)new NearestAttackableTargetGoal((Mob)mob, PurpleVillagerGeneralEntity.class, false, false));
/* 169 */     mob.f_21346_.m_25352_(6, (Goal)new NearestAttackableTargetGoal((Mob)mob, BlueDemonEntity.class, false, false));
/* 170 */     mob.f_21346_.m_25352_(8, (Goal)new NearestAttackableTargetGoal((Mob)mob, EliteHerobrineKnockedEntity.class, true, false));
/* 171 */     mob.f_21346_.m_25352_(20, (Goal)new NearestAttackableTargetGoal((Mob)mob, AlexEntity.class, false, false));
/* 172 */     mob.f_21346_.m_25352_(20, (Goal)new NearestAttackableTargetGoal((Mob)mob, ChrisEntity.class, false, false));
/* 173 */     mob.f_21346_.m_25352_(21, (Goal)new NearestAttackableTargetGoal((Mob)mob, Player.class, true, true));
/* 174 */     mob.f_21345_.m_25352_(22, (Goal)new MeleeAttackGoal(mob, 1.5D, false) {
/*     */           protected double m_6639_(@NotNull LivingEntity livingEntity) {
/* 176 */             return (this.f_25540_.m_20205_() * this.f_25540_.m_20205_() + livingEntity.m_20205_());
/*     */           }
/*     */         });
/* 179 */     mob.f_21345_.m_25352_(23, (Goal)new RandomStrollGoal(mob, 1.0D));
/* 180 */     mob.f_21345_.m_25352_(24, (Goal)new RandomLookAroundGoal((Mob)mob));
/* 181 */     mob.f_21345_.m_25352_(25, (Goal)new FloatGoal((Mob)mob));
/*     */   }
/*     */   
/*     */   public static void attackAllMonstersGoals(PlayerNpcEntity playerMobEntity) {
/* 185 */     playerMobEntity.f_21346_.m_25352_(1, (Goal)new NearestAttackableTargetGoal((Mob)playerMobEntity, HerobrineMob.class, true, false));
/* 186 */     playerMobEntity.f_21346_.m_25352_(4, (Goal)new NearestAttackableTargetGoal((Mob)playerMobEntity, Monster.class, true, target -> !(target instanceof PlayerMobEntity)));
/* 187 */     playerMobEntity.f_21346_.m_25352_(4, (Goal)new NearestAttackableTargetGoal((Mob)playerMobEntity, AbstractIllager.class, true, false));
/* 188 */     playerMobEntity.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)playerMobEntity, LowHerobrineCloneEntity.class, true, false));
/* 189 */     playerMobEntity.f_21346_.m_25352_(2, (Goal)new NearestAttackableTargetGoal((Mob)playerMobEntity, LowShadowHerobrineCloneEntity.class, true, false));
/* 190 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)playerMobEntity, BlueDemonEntity.class, true));
/* 191 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal((Mob)playerMobEntity, EliteHerobrineKnockedEntity.class, true));
/*     */   }
/*     */   
/*     */   public static void runAwayFromHerobrineGoals(PathfinderMob playerMobEntity, float distance) {
/* 195 */     if (!(playerMobEntity.m_5448_() instanceof HerobrineMob)) {
/* 196 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal(playerMobEntity, HerobrineMob.class, distance, 1.2D, 1.4D));
/*     */     }
/* 198 */     if (!(playerMobEntity.m_5448_() instanceof HerobrineGregEntity)) {
/* 199 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal(playerMobEntity, HerobrineGregEntity.class, distance, 1.2D, 1.4D));
/*     */     }
/* 201 */     if (!(playerMobEntity.m_5448_() instanceof LowHerobrineCloneEntity)) {
/* 202 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal(playerMobEntity, LowHerobrineCloneEntity.class, distance, 1.2D, 1.4D));
/*     */     }
/* 204 */     if (!(playerMobEntity.m_5448_() instanceof LowShadowHerobrineCloneEntity)) {
/* 205 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal(playerMobEntity, LowShadowHerobrineCloneEntity.class, distance, 1.2D, 1.4D));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void runAwayFromVillagerArmyGoals(PlayerMobEntity playerMobEntity) {
/* 210 */     if (!(playerMobEntity.m_5448_() instanceof VillagerScoutEntity)) {
/* 211 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal((PathfinderMob)playerMobEntity, VillagerScoutEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 213 */     if (!(playerMobEntity.m_5448_() instanceof VillagerScoutCaptainEntity)) {
/* 214 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal((PathfinderMob)playerMobEntity, VillagerScoutCaptainEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 216 */     if (!(playerMobEntity.m_5448_() instanceof BlueVillagerGeneralEntity)) {
/* 217 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal((PathfinderMob)playerMobEntity, BlueVillagerGeneralEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 219 */     if (!(playerMobEntity.m_5448_() instanceof GreenVillagerGeneralEntity)) {
/* 220 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal((PathfinderMob)playerMobEntity, GreenVillagerGeneralEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 222 */     if (!(playerMobEntity.m_5448_() instanceof RedVillagerGeneralEntity)) {
/* 223 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal((PathfinderMob)playerMobEntity, RedVillagerGeneralEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/* 225 */     if (!(playerMobEntity.m_5448_() instanceof PurpleVillagerGeneralEntity)) {
/* 226 */       playerMobEntity.f_21345_.m_25352_(1, (Goal)new AvoidEntityGoal((PathfinderMob)playerMobEntity, PurpleVillagerGeneralEntity.class, 12.0F, 1.2D, 1.4D));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void attackAllNpcGoals(Mob playerMobEntity) {
/* 231 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, AlexEntity.class, true));
/* 232 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, JevEntity.class, true));
/* 233 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, ChrisEntity.class, true));
/* 234 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, SteveEntity.class, true));
/* 235 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, AngrySteveEntity.class, true));
/*     */   }
/*     */   
/*     */   public static void attackAllVillagerArmyGoal(Mob playerMobEntity) {
/* 239 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, VillagerScoutEntity.class, true));
/* 240 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, VillagerScoutCaptainEntity.class, true));
/* 241 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, RedVillagerGeneralEntity.class, true));
/* 242 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, BlueVillagerGeneralEntity.class, true));
/* 243 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, GreenVillagerGeneralEntity.class, true));
/* 244 */     playerMobEntity.f_21346_.m_25352_(3, (Goal)new NearestAttackableTargetGoal(playerMobEntity, PurpleVillagerGeneralEntity.class, true));
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\CommonGoals.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */