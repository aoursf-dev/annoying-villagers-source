/*     */ package com.pla.annoyingvillagers.util;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import java.util.Random;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.ListTag;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.projectile.FireworkRocketEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ public class VillagerUtil {
/*     */   public static ItemStack generateMainWeaponItem() {
/*     */     ItemStack itemStack;
/*  28 */     float chance = (new Random()).nextFloat();
/*     */     
/*  30 */     if (chance <= 0.2F) {
/*  31 */       itemStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.DIAMOND_DAGGER.get());
/*  32 */     } else if (chance <= 0.4F) {
/*  33 */       itemStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.DIAMOND_FALCHION.get());
/*  34 */     } else if (chance <= 0.6F) {
/*  35 */       itemStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.HOOKED_DIAMOND_SWORD.get());
/*     */     } else {
/*  37 */       itemStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get());
/*     */     } 
/*     */     
/*  40 */     float enchantChance = (new Random()).nextFloat();
/*  41 */     if (enchantChance <= 0.2D) {
/*  42 */       itemStack.m_41663_(Enchantments.f_44981_, (new Random()).nextInt(1, 3));
/*     */     }
/*  44 */     if (enchantChance <= 0.4D) {
/*  45 */       itemStack.m_41663_(Enchantments.f_44983_, (new Random()).nextInt(1, 3));
/*     */     }
/*  47 */     if (enchantChance <= 0.6D) {
/*  48 */       itemStack.m_41663_(Enchantments.f_44978_, (new Random()).nextInt(1, 3));
/*     */     }
/*  50 */     if (enchantChance <= 0.8D) {
/*  51 */       itemStack.m_41663_(Enchantments.f_44980_, (new Random()).nextInt(1, 3));
/*     */     }
/*  53 */     itemStack.m_41663_(Enchantments.f_44977_, (new Random()).nextInt(1, 3));
/*  54 */     return itemStack;
/*     */   }
/*     */   
/*     */   private static Vec3 localCommandOffset(Vec3 origin, float yaw, double localX, double localY, double localZ) {
/*  58 */     Vec3 forward = Vec3.m_82498_(0.0F, yaw).m_82541_();
/*  59 */     Vec3 left = (new Vec3(forward.f_82481_, 0.0D, -forward.f_82479_)).m_82541_();
/*     */     
/*  61 */     return origin.m_82549_(left.m_82490_(localX))
/*  62 */       .m_82520_(0.0D, localY, 0.0D)
/*  63 */       .m_82549_(forward.m_82490_(localZ));
/*     */   }
/*     */   
/*     */   private static boolean isValidGroundSpawn(ServerLevel level, Mob probe, BlockPos feetPos, float yaw) {
/*  67 */     BlockPos floorPos = feetPos.m_7495_();
/*  68 */     BlockPos headPos = feetPos.m_7494_();
/*     */     
/*  70 */     BlockState floorState = level.m_8055_(floorPos);
/*  71 */     BlockState feetState = level.m_8055_(feetPos);
/*  72 */     BlockState headState = level.m_8055_(headPos);
/*     */     
/*  74 */     if (floorState.m_60795_()) return false; 
/*  75 */     if (floorState.m_60812_((BlockGetter)level, floorPos).m_83281_()) return false; 
/*  76 */     if (!level.m_6425_(floorPos).m_76178_()) return false;
/*     */     
/*  78 */     if (!feetState.m_60812_((BlockGetter)level, feetPos).m_83281_()) return false; 
/*  79 */     if (!headState.m_60812_((BlockGetter)level, headPos).m_83281_()) return false;
/*     */     
/*  81 */     if (!level.m_6425_(feetPos).m_76178_()) return false; 
/*  82 */     if (!level.m_6425_(headPos).m_76178_()) return false;
/*     */     
/*  84 */     probe.m_7678_(feetPos.m_123341_() + 0.5D, feetPos.m_123342_(), feetPos.m_123343_() + 0.5D, yaw, 0.0F);
/*  85 */     return (level.m_45786_((Entity)probe) && !level.m_46855_(probe.m_20191_()));
/*     */   }
/*     */   @Nullable
/*     */   private static Vec3 findSurfaceNearDeathY(ServerLevel level, Mob probe, BlockPos columnBase, float yaw, int maxDown, int maxUp) {
/*  89 */     int startY = columnBase.m_123342_();
/*  90 */     int minY = Math.max(level.m_141937_() + 1, startY - maxDown);
/*  91 */     int maxY = Math.min(level.m_151558_() - 2, startY + maxUp);
/*     */     int y;
/*  93 */     for (y = startY; y >= minY; y--) {
/*  94 */       BlockPos feetPos = new BlockPos(columnBase.m_123341_(), y, columnBase.m_123343_());
/*  95 */       if (isValidGroundSpawn(level, probe, feetPos, yaw)) {
/*  96 */         return Vec3.m_82539_((Vec3i)feetPos);
/*     */       }
/*     */     } 
/*     */     
/* 100 */     for (y = startY + 1; y <= maxY; y++) {
/* 101 */       BlockPos feetPos = new BlockPos(columnBase.m_123341_(), y, columnBase.m_123343_());
/* 102 */       if (isValidGroundSpawn(level, probe, feetPos, yaw)) {
/* 103 */         return Vec3.m_82539_((Vec3i)feetPos);
/*     */       }
/*     */     } 
/*     */     
/* 107 */     return null;
/*     */   }
/*     */   @Nullable
/*     */   private static Vec3 findSafeSpawnNearLocalOffset(ServerLevel level, Vec3 origin, float yaw, Mob probe, double localX, double localY, double localZ) {
/* 111 */     Vec3 wanted = localCommandOffset(origin, yaw, localX, localY, localZ);
/*     */     
/* 113 */     int baseX = Mth.m_14107_(wanted.f_82479_);
/* 114 */     int baseY = Mth.m_14107_(origin.f_82480_ + localY);
/* 115 */     int baseZ = Mth.m_14107_(wanted.f_82481_);
/*     */     
/* 117 */     for (int radius = 0; radius <= 2; radius++) {
/* 118 */       for (int dx = -radius; dx <= radius; dx++) {
/* 119 */         for (int dz = -radius; dz <= radius; dz++) {
/* 120 */           if (radius == 0 || Math.abs(dx) == radius || Math.abs(dz) == radius) {
/*     */ 
/*     */ 
/*     */             
/* 124 */             BlockPos column = new BlockPos(baseX + dx, baseY, baseZ + dz);
/* 125 */             Vec3 found = findSurfaceNearDeathY(level, probe, column, yaw, 16, 4);
/* 126 */             if (found != null) {
/* 127 */               return found;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 133 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static <T extends Mob> T spawnMobAtLocalOffset(ServerLevel level, Vec3 origin, float yaw, EntityType<T> type, double localX, double localY, double localZ) {
/* 145 */     Mob mob = (Mob)type.m_20615_((Level)level);
/* 146 */     if (mob == null) {
/* 147 */       return null;
/*     */     }
/*     */     
/* 150 */     Vec3 spawnPos = findSafeSpawnNearLocalOffset(level, origin, yaw, mob, localX, localY, localZ);
/* 151 */     if (spawnPos == null) {
/* 152 */       mob.m_146870_();
/* 153 */       return null;
/*     */     } 
/*     */     
/* 156 */     mob.m_7678_(spawnPos.f_82479_, spawnPos.f_82480_, spawnPos.f_82481_, yaw, 0.0F);
/* 157 */     mob.m_6518_((ServerLevelAccessor)level, level
/*     */         
/* 159 */         .m_6436_(BlockPos.m_274446_((Position)spawnPos)), MobSpawnType.MOB_SUMMONED, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     level.m_7967_((Entity)mob);
/* 165 */     return (T)mob;
/*     */   }
/*     */   
/*     */   public static void spawnBackupFirework(ServerLevel level, Vec3 origin) {
/* 169 */     ItemStack rocketStack = new ItemStack((ItemLike)Items.f_42688_);
/*     */     
/* 171 */     CompoundTag fireworksTag = rocketStack.m_41698_("Fireworks");
/* 172 */     fireworksTag.m_128344_("Flight", (byte)1);
/*     */     
/* 174 */     CompoundTag explosion = new CompoundTag();
/* 175 */     explosion.m_128344_("Type", (byte)3);
/* 176 */     explosion.m_128385_("Colors", new int[] { 0 });
/* 177 */     explosion.m_128379_("Flicker", true);
/*     */     
/* 179 */     ListTag explosions = new ListTag();
/* 180 */     explosions.add(explosion);
/* 181 */     fireworksTag.m_128365_("Explosions", (Tag)explosions);
/*     */     
/* 183 */     FireworkRocketEntity rocket = new FireworkRocketEntity((Level)level, origin.f_82479_, origin.f_82480_ + 10.0D, origin.f_82481_, rocketStack);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     level.m_7967_((Entity)rocket);
/*     */   }
/*     */   
/*     */   public static ItemStack createBlackCreeperSignalFirework() {
/* 194 */     ItemStack stack = new ItemStack((ItemLike)Items.f_42688_);
/* 195 */     CompoundTag tag = stack.m_41784_();
/* 196 */     CompoundTag fireworksTag = new CompoundTag();
/* 197 */     fireworksTag.m_128344_("Flight", (byte)1);
/*     */     
/* 199 */     ListTag explosions = new ListTag();
/* 200 */     CompoundTag explosion = new CompoundTag();
/* 201 */     explosion.m_128344_("Type", (byte)3);
/* 202 */     explosion.m_128385_("Colors", new int[] { 0 });
/* 203 */     explosion.m_128379_("Flicker", true);
/* 204 */     explosions.add(explosion);
/*     */     
/* 206 */     fireworksTag.m_128365_("Explosions", (Tag)explosions);
/* 207 */     tag.m_128365_("Fireworks", (Tag)fireworksTag);
/*     */     
/* 209 */     stack.m_41714_((Component)Component.m_237113_("Black Creeper Firework"));
/* 210 */     return stack;
/*     */   }
/*     */   
/*     */   public static boolean isBlackCreeperSignalFirework(ItemStack stack) {
/* 214 */     if (stack.m_41619_() || !stack.m_150930_(Items.f_42688_) || !stack.m_41782_()) {
/* 215 */       return false;
/*     */     }
/*     */     
/* 218 */     CompoundTag tag = stack.m_41783_();
/* 219 */     if (tag == null) {
/* 220 */       return false;
/*     */     }
/*     */     
/* 223 */     if (!tag.m_128425_("Fireworks", 10)) {
/* 224 */       return false;
/*     */     }
/*     */     
/* 227 */     CompoundTag fireworksTag = tag.m_128469_("Fireworks");
/* 228 */     if (!fireworksTag.m_128425_("Explosions", 9)) {
/* 229 */       return false;
/*     */     }
/*     */     
/* 232 */     ListTag explosions = fireworksTag.m_128437_("Explosions", 10);
/* 233 */     if (explosions.size() != 1) {
/* 234 */       return false;
/*     */     }
/*     */     
/* 237 */     CompoundTag explosion = explosions.m_128728_(0);
/* 238 */     if (explosion.m_128445_("Type") != 3) {
/* 239 */       return false;
/*     */     }
/*     */     
/* 242 */     int[] colors = explosion.m_128465_("Colors");
/* 243 */     return (colors.length == 1 && colors[0] == 0);
/*     */   }
/*     */   
/*     */   public static void launchBlackCreeperSignalFirework(ServerLevel serverLevel, double x, double y, double z) {
/* 247 */     ItemStack rocketStack = createBlackCreeperSignalFirework();
/* 248 */     FireworkRocketEntity rocket = new FireworkRocketEntity((Level)serverLevel, x, y, z, rocketStack);
/* 249 */     serverLevel.m_7967_((Entity)rocket);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Mob> void summonSupportAt(ServerLevel serverLevel, EntityType<T> entityType, double baseX, double baseY, double baseZ) {
/* 255 */     BlockPos spawnPos = findSafeSupportSpawn(serverLevel, baseX + (new Random()).nextDouble(-10.0D, 10.0D), baseY, baseZ + (new Random()).nextDouble(-10.0D, 10.0D));
/* 256 */     if (spawnPos == null) {
/*     */       return;
/*     */     }
/*     */     
/* 260 */     Mob mob = (Mob)entityType.m_20615_((Level)serverLevel);
/* 261 */     if (mob == null) {
/*     */       return;
/*     */     }
/*     */     
/* 265 */     mob.m_7678_(spawnPos
/* 266 */         .m_123341_() + 0.5D, spawnPos
/* 267 */         .m_123342_(), spawnPos
/* 268 */         .m_123343_() + 0.5D, serverLevel.f_46441_
/* 269 */         .m_188501_() * 360.0F, 0.0F);
/*     */ 
/*     */ 
/*     */     
/* 273 */     if (!serverLevel.m_45786_((Entity)mob) || !serverLevel.m_45784_((Entity)mob)) {
/*     */       return;
/*     */     }
/*     */     
/* 277 */     mob.m_6518_((ServerLevelAccessor)serverLevel, serverLevel
/*     */         
/* 279 */         .m_6436_(spawnPos), MobSpawnType.MOB_SUMMONED, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     serverLevel.m_7967_((Entity)mob);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static BlockPos findSafeSupportSpawn(ServerLevel serverLevel, double x, double y, double z) {
/* 290 */     int baseX = Mth.m_14107_(x);
/* 291 */     int baseZ = Mth.m_14107_(z);
/* 292 */     int refY = Mth.m_14045_(Mth.m_14107_(y), serverLevel.m_141937_() + 1, serverLevel.m_151558_() - 2);
/* 293 */     for (int radius = 0; radius <= 2; radius++) {
/* 294 */       for (int dx = -radius; dx <= radius; dx++) {
/* 295 */         for (int dz = -radius; dz <= radius; dz++) {
/* 296 */           BlockPos found = findSafeSupportSpawnInColumn(serverLevel, baseX + dx, refY, baseZ + dz);
/* 297 */           if (found != null) {
/* 298 */             return found;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 304 */     return null;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private static BlockPos findSafeSupportSpawnInColumn(ServerLevel serverLevel, int x, int refY, int z) {
/* 309 */     int minY = serverLevel.m_141937_() + 1;
/* 310 */     int maxUpY = Math.min(serverLevel.m_151558_() - 2, refY + 3);
/*     */     int y;
/* 312 */     for (y = refY; y >= minY; y--) {
/* 313 */       BlockPos feetPos = new BlockPos(x, y, z);
/* 314 */       if (isSafeSupportSpawn(serverLevel, feetPos)) {
/* 315 */         return feetPos;
/*     */       }
/*     */     } 
/* 318 */     for (y = refY + 1; y <= maxUpY; y++) {
/* 319 */       BlockPos feetPos = new BlockPos(x, y, z);
/* 320 */       if (isSafeSupportSpawn(serverLevel, feetPos)) {
/* 321 */         return feetPos;
/*     */       }
/*     */     } 
/*     */     
/* 325 */     return null;
/*     */   }
/*     */   
/*     */   private static boolean isSafeSupportSpawn(ServerLevel serverLevel, BlockPos feetPos) {
/* 329 */     BlockPos belowPos = feetPos.m_7495_();
/*     */     
/* 331 */     return (serverLevel.m_8055_(belowPos).m_60783_((BlockGetter)serverLevel, belowPos, Direction.UP) && serverLevel
/* 332 */       .m_6425_(feetPos).m_76178_() && serverLevel
/* 333 */       .m_6425_(feetPos.m_7494_()).m_76178_() && serverLevel
/* 334 */       .m_8055_(feetPos).m_247087_() && serverLevel
/* 335 */       .m_8055_(feetPos.m_7494_()).m_247087_());
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
/*     */   public static void summonSupportAtLocalOffset(ServerLevel level, Vec3 origin, float yaw, EntityType<? extends Mob> type, double localX, double localY, double localZ) {
/* 347 */     Mob mob = (Mob)type.m_20615_((Level)level);
/* 348 */     if (mob == null) {
/*     */       return;
/*     */     }
/*     */     
/* 352 */     Vec3 spawnPos = findSafeSpawnNearLocalOffset(level, origin, yaw, mob, localX, localY, localZ);
/* 353 */     if (spawnPos == null) {
/* 354 */       mob.m_146870_();
/*     */       
/*     */       return;
/*     */     } 
/* 358 */     mob.m_7678_(spawnPos.f_82479_, spawnPos.f_82480_, spawnPos.f_82481_, yaw, 0.0F);
/*     */     
/* 360 */     if (!level.m_45786_((Entity)mob) || level.m_46855_(mob.m_20191_())) {
/* 361 */       mob.m_146870_();
/*     */       
/*     */       return;
/*     */     } 
/* 365 */     mob.m_6518_((ServerLevelAccessor)level, level
/*     */         
/* 367 */         .m_6436_(BlockPos.m_274446_((Position)spawnPos)), MobSpawnType.MOB_SUMMONED, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     level.m_7967_((Entity)mob);
/*     */   }
/*     */   
/*     */   private static EntityType<? extends Mob> rollRandomVillagerReinforcementType() {
/* 377 */     double roll = (new Random()).nextDouble();
/*     */     
/* 379 */     if (roll < 0.2D)
/* 380 */       return (EntityType<? extends Mob>)AnnoyingVillagersModEntities.PURPLE_VILLAGER_GENERAL.get(); 
/* 381 */     if (roll < 0.4D)
/* 382 */       return (EntityType<? extends Mob>)AnnoyingVillagersModEntities.RED_VILLAGER_GENERAL.get(); 
/* 383 */     if (roll < 0.6D)
/* 384 */       return (EntityType<? extends Mob>)AnnoyingVillagersModEntities.GREEN_VILLAGER_GENERAL.get(); 
/* 385 */     if (roll < 0.8D) {
/* 386 */       return (EntityType<? extends Mob>)AnnoyingVillagersModEntities.BLUE_VILLAGER_GENERAL.get();
/*     */     }
/* 388 */     return (EntityType<? extends Mob>)AnnoyingVillagersModEntities.VILLAGER_SCOUT_CAPTAIN.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void summonRandomVillagerSupportWave(ServerLevel level, Vec3 origin, float yaw) {
/* 393 */     Random random = new Random();
/*     */     
/* 395 */     summonSupportAtLocalOffset(level, origin, yaw, (EntityType<? extends Mob>)AnnoyingVillagersModEntities.VILLAGER_SCOUT
/* 396 */         .get(), 0.0D, 0.0D, 10.0D);
/*     */ 
/*     */     
/* 399 */     summonSupportAtLocalOffset(level, origin, yaw, (EntityType<? extends Mob>)AnnoyingVillagersModEntities.VILLAGER_SCOUT
/* 400 */         .get(), -5.0D, 0.0D, 12.0D);
/*     */ 
/*     */     
/* 403 */     summonSupportAtLocalOffset(level, origin, yaw, (EntityType<? extends Mob>)AnnoyingVillagersModEntities.VILLAGER_SCOUT
/* 404 */         .get(), 5.0D, 0.0D, 12.0D);
/*     */ 
/*     */     
/* 407 */     if (random.nextBoolean()) {
/* 408 */       summonSupportAtLocalOffset(level, origin, yaw, (EntityType<? extends Mob>)AnnoyingVillagersModEntities.VILLAGER_SCOUT
/* 409 */           .get(), -10.0D, 0.0D, 18.0D);
/*     */ 
/*     */       
/* 412 */       summonSupportAtLocalOffset(level, origin, yaw, (EntityType<? extends Mob>)AnnoyingVillagersModEntities.VILLAGER_SCOUT
/* 413 */           .get(), 10.0D, 0.0D, 18.0D);
/*     */     } 
/*     */ 
/*     */     
/* 417 */     summonSupportAtLocalOffset(level, origin, yaw, 
/* 418 */         rollRandomVillagerReinforcementType(), 0.0D, 0.0D, 22.0D);
/*     */ 
/*     */     
/* 421 */     if (random.nextBoolean()) {
/* 422 */       summonSupportAtLocalOffset(level, origin, yaw, (EntityType<? extends Mob>)AnnoyingVillagersModEntities.VILLAGER_SCOUT_CAPTAIN
/* 423 */           .get(), 10.0D, 0.0D, 24.0D);
/*     */     }
/*     */ 
/*     */     
/* 427 */     if (random.nextBoolean())
/* 428 */       summonSupportAtLocalOffset(level, origin, yaw, 
/* 429 */           rollRandomVillagerReinforcementType(), -10.0D, 0.0D, 24.0D); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\VillagerUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */