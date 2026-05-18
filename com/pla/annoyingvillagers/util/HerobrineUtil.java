/*      */ package com.pla.annoyingvillagers.util;
/*      */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianBlockEntity;
/*      */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*      */ import com.pla.annoyingvillagers.clazz.HerobrineObsidianBlock;
/*      */ import com.pla.annoyingvillagers.entity.LowHerobrineCloneEntity;
/*      */ import com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity;
/*      */ import com.pla.annoyingvillagers.entity.NullAxeEntity;
/*      */ import com.pla.annoyingvillagers.entity.NullHoeEntity;
/*      */ import com.pla.annoyingvillagers.entity.NullPickaxeEntity;
/*      */ import com.pla.annoyingvillagers.entity.NullShovelEntity;
/*      */ import com.pla.annoyingvillagers.entity.NullSwordEntity;
/*      */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*      */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*      */ import com.pla.annoyingvillagers.task.DelayedTask;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.core.BlockPos;
/*      */ import net.minecraft.core.Direction;
/*      */ import net.minecraft.core.Position;
/*      */ import net.minecraft.network.chat.Component;
/*      */ import net.minecraft.server.level.ServerLevel;
/*      */ import net.minecraft.util.Mth;
/*      */ import net.minecraft.util.RandomSource;
/*      */ import net.minecraft.world.entity.Entity;
/*      */ import net.minecraft.world.entity.EquipmentSlot;
/*      */ import net.minecraft.world.entity.LivingEntity;
/*      */ import net.minecraft.world.entity.Mob;
/*      */ import net.minecraft.world.entity.item.ItemEntity;
/*      */ import net.minecraft.world.item.Item;
/*      */ import net.minecraft.world.item.ItemStack;
/*      */ import net.minecraft.world.item.Items;
/*      */ import net.minecraft.world.item.enchantment.Enchantment;
/*      */ import net.minecraft.world.level.ItemLike;
/*      */ import net.minecraft.world.level.Level;
/*      */ import net.minecraft.world.level.LevelAccessor;
/*      */ import net.minecraft.world.level.block.Block;
/*      */ import net.minecraft.world.level.block.Blocks;
/*      */ import net.minecraft.world.level.block.entity.BlockEntity;
/*      */ import net.minecraft.world.level.block.state.BlockState;
/*      */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*      */ import net.minecraft.world.level.block.state.properties.Property;
/*      */ import net.minecraft.world.phys.Vec3;
/*      */ import yesman.epicfight.api.animation.Joint;
/*      */ import yesman.epicfight.api.utils.math.Vec3f;
/*      */ 
/*      */ public class HerobrineUtil {
/*      */   public static boolean isHerobrineFaction(Entity e) {
/*   49 */     return (e instanceof HerobrineMob || e instanceof com.pla.annoyingvillagers.entity.HerobrineGregEntity || e instanceof LowHerobrineCloneEntity || e instanceof LowShadowHerobrineCloneEntity || e instanceof com.pla.annoyingvillagers.entity.InfectedPlayerNpcEntity || e instanceof com.pla.annoyingvillagers.entity.InfectedTheMostMoistBurrit0Entity || e instanceof com.pla.annoyingvillagers.entity.InfectedChrisEntity || e instanceof NullSwordEntity || e instanceof NullAxeEntity || e instanceof NullPickaxeEntity || e instanceof NullShovelEntity || e instanceof NullHoeEntity || e instanceof com.pla.annoyingvillagers.entity.BlockProjectileEntity || e instanceof com.pla.annoyingvillagers.entity.EliteHerobrineKnockedEntity);
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
/*      */   public static void placeIfReplaceable(ServerLevel level, BlockPos pos, BlockState state, Entity ownerEntity) {
/*   66 */     if (!level.m_46749_(pos))
/*      */       return; 
/*   68 */     BlockState existingState = level.m_8055_(pos);
/*   69 */     if (!existingState.m_247087_()) {
/*   70 */       ProjectileBreakableBlocks rule = ProjectileBreakableBlocks.find(existingState);
/*   71 */       if (rule == null)
/*   72 */         return;  boolean requiresTool = existingState.m_60834_();
/*   73 */       boolean destroyed = level.m_46953_(pos, true, ownerEntity);
/*   74 */       if (!destroyed)
/*   75 */         return;  if (requiresTool) {
/*   76 */         Item item = existingState.m_60734_().m_5456_();
/*   77 */         if (item != Items.f_41852_) {
/*   78 */           Block.m_49840_((Level)level, pos, new ItemStack((ItemLike)item));
/*      */         }
/*      */       } 
/*      */     } 
/*   82 */     if (!level.m_8055_(pos).m_247087_())
/*      */       return; 
/*   84 */     level.m_46597_(pos, state);
/*   85 */     BlockEntity blockEntity = level.m_7702_(pos);
/*   86 */     if (blockEntity == null)
/*      */       return; 
/*   88 */     if (blockEntity instanceof ObsidianBlockEntity) { ObsidianBlockEntity obsidianBlockEntity = (ObsidianBlockEntity)blockEntity;
/*   89 */       obsidianBlockEntity.setOwner(ownerEntity.m_20148_()); }
/*   90 */     else if (blockEntity instanceof ShadowObsidianBlockEntity) { ShadowObsidianBlockEntity shadowObsidianBlockEntity = (ShadowObsidianBlockEntity)blockEntity;
/*   91 */       shadowObsidianBlockEntity.setOwner(ownerEntity.m_20148_()); }
/*   92 */     else if (blockEntity instanceof CryingObsidianBlockEntity) { CryingObsidianBlockEntity cryingObsidianBlockEntity = (CryingObsidianBlockEntity)blockEntity;
/*   93 */       cryingObsidianBlockEntity.setOwner(ownerEntity.m_20148_()); }
/*   94 */     else if (blockEntity instanceof ShadowObsidianShortPillarBlockEntity) { ShadowObsidianShortPillarBlockEntity shadowObsidianShortPillarBlockEntity = (ShadowObsidianShortPillarBlockEntity)blockEntity;
/*   95 */       shadowObsidianShortPillarBlockEntity.setOwner(ownerEntity.m_20148_()); }
/*   96 */     else if (blockEntity instanceof ShadowObsidianMiddlePillarBlockEntity) { ShadowObsidianMiddlePillarBlockEntity shadowObsidianMiddlePillarBlockEntity = (ShadowObsidianMiddlePillarBlockEntity)blockEntity;
/*   97 */       shadowObsidianMiddlePillarBlockEntity.setOwner(ownerEntity.m_20148_()); }
/*   98 */     else if (blockEntity instanceof ShadowObsidianLongPillarBlockEntity) { ShadowObsidianLongPillarBlockEntity shadowObsidianLongPillarBlockEntity = (ShadowObsidianLongPillarBlockEntity)blockEntity;
/*   99 */       shadowObsidianLongPillarBlockEntity.setOwner(ownerEntity.m_20148_()); }
/*      */ 
/*      */     
/*  102 */     blockEntity.m_6596_();
/*  103 */     level.m_7260_(pos, state, state, 3);
/*      */   }
/*      */   
/*      */   private static Basis basisFromEntity(Entity e) {
/*  107 */     Vec3 forward = e.m_20154_().m_82541_();
/*      */     
/*  109 */     Vec3 worldUp = new Vec3(0.0D, 1.0D, 0.0D);
/*  110 */     Vec3 right = forward.m_82537_(worldUp);
/*  111 */     if (right.m_82556_() < 1.0E-6D) {
/*  112 */       right = new Vec3(1.0D, 0.0D, 0.0D);
/*      */     } else {
/*  114 */       right = right.m_82541_();
/*      */     } 
/*  116 */     Vec3 up = right.m_82537_(forward).m_82541_();
/*  117 */     return new Basis(forward, right, up);
/*      */   }
/*      */   
/*      */   public static void transformHerobrine(LevelAccessor world, double x, double y, double z, Entity entity, Entity herobrineEntity) {
/*  121 */     if (entity == null)
/*  122 */       return;  Random random = new Random();
/*  123 */     if (random.nextFloat() >= ((Double)AnnoyingVillagersConfig.HEROBRINE_POSSESS_RATE.get()).floatValue()) {
/*      */       return;
/*      */     }
/*      */     
/*  127 */     if (entity instanceof PlayerNpcEntity) { ServerLevel serverLevel; LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity; PlayerNpcEntity victim = (PlayerNpcEntity)entity;
/*  128 */       if (world instanceof ServerLevel) { serverLevel = (ServerLevel)world; } else { return; }
/*  129 */        entity.getPersistentData().m_128379_("die_by_possess", true);
/*      */       
/*  131 */       if (herobrineEntity instanceof com.pla.annoyingvillagers.entity.HerobrineCloneEntity || herobrineEntity instanceof com.pla.annoyingvillagers.entity.HerobrineChrisEntity || herobrineEntity instanceof com.pla.annoyingvillagers.entity.NullEntity || herobrineEntity instanceof NullSwordEntity || herobrineEntity instanceof NullAxeEntity || herobrineEntity instanceof NullPickaxeEntity || herobrineEntity instanceof NullShovelEntity || herobrineEntity instanceof NullHoeEntity || herobrineEntity instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity || herobrineEntity instanceof com.pla.annoyingvillagers.entity.AegisHerobrineEntity || herobrineEntity instanceof com.pla.annoyingvillagers.entity.ReaperHerobrineEntity || herobrineEntity instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity || herobrineEntity instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  137 */         LowHerobrineCloneEntity lowHerobrineCloneEntity = new LowHerobrineCloneEntity((EntityType)AnnoyingVillagersModEntities.LOW_HEROBRINE_CLONE.get(), (Level)serverLevel);
/*      */       } else {
/*  139 */         lowShadowHerobrineCloneEntity = new LowShadowHerobrineCloneEntity((EntityType)AnnoyingVillagersModEntities.LOW_SHADOW_HEROBRINE_CLONE.get(), (Level)serverLevel);
/*      */       } 
/*  141 */       lowShadowHerobrineCloneEntity.m_7678_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
/*  142 */       victim.m_7770_();
/*  143 */       lowShadowHerobrineCloneEntity.getPersistentData().m_128359_("killed_name", victim.m_7770_().getString());
/*      */       
/*  145 */       if (!victim.m_6844_(EquipmentSlot.HEAD).m_41720_().equals(Items.f_42680_)) {
/*  146 */         lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.HEAD, victim.m_6844_(EquipmentSlot.HEAD).m_41777_());
/*      */       }
/*  148 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.CHEST, victim.m_6844_(EquipmentSlot.CHEST).m_41777_());
/*  149 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.LEGS, victim.m_6844_(EquipmentSlot.LEGS).m_41777_());
/*  150 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.FEET, victim.m_6844_(EquipmentSlot.FEET).m_41777_());
/*  151 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.MAINHAND, victim.m_6844_(EquipmentSlot.MAINHAND).m_41777_());
/*  152 */       lowShadowHerobrineCloneEntity.m_8061_(EquipmentSlot.OFFHAND, victim.m_6844_(EquipmentSlot.OFFHAND).m_41777_());
/*  153 */       Mob mob = (Mob)lowShadowHerobrineCloneEntity;
/*  154 */       if (mob instanceof LowHerobrineCloneEntity) { LowHerobrineCloneEntity lowHerobrineCloneEntity = (LowHerobrineCloneEntity)mob;
/*  155 */         lowHerobrineCloneEntity.setUsername(((PlayerMobEntity)entity).getUsername());
/*  156 */         lowHerobrineCloneEntity.setProfile(((PlayerMobEntity)entity).getProfile());
/*  157 */         if (herobrineEntity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)herobrineEntity;
/*  158 */           lowHerobrineCloneEntity.setPossessedByEntity(herobrineMob);
/*  159 */           lowHerobrineCloneEntity.setPossessedByUuid(herobrineMob.m_20148_()); }
/*  160 */         else if (herobrineEntity instanceof NullSwordEntity) { NullSwordEntity nullSwordEntity = (NullSwordEntity)herobrineEntity;
/*  161 */           lowHerobrineCloneEntity.setPossessedByEntity((HerobrineMob)nullSwordEntity.getNullEntity());
/*  162 */           lowHerobrineCloneEntity.setPossessedByUuid(nullSwordEntity.getNullUUID()); }
/*  163 */         else if (herobrineEntity instanceof NullAxeEntity) { NullAxeEntity nullAxeEntity = (NullAxeEntity)herobrineEntity;
/*  164 */           lowHerobrineCloneEntity.setPossessedByEntity((HerobrineMob)nullAxeEntity.getNullEntity());
/*  165 */           lowHerobrineCloneEntity.setPossessedByUuid(nullAxeEntity.getNullUUID()); }
/*  166 */         else if (herobrineEntity instanceof NullPickaxeEntity) { NullPickaxeEntity nullPickaxeEntity = (NullPickaxeEntity)herobrineEntity;
/*  167 */           lowHerobrineCloneEntity.setPossessedByEntity((HerobrineMob)nullPickaxeEntity.getNullEntity());
/*  168 */           lowHerobrineCloneEntity.setPossessedByUuid(nullPickaxeEntity.getNullUUID()); }
/*  169 */         else if (herobrineEntity instanceof NullShovelEntity) { NullShovelEntity nullShovelEntity = (NullShovelEntity)herobrineEntity;
/*  170 */           lowHerobrineCloneEntity.setPossessedByEntity((HerobrineMob)nullShovelEntity.getNullEntity());
/*  171 */           lowHerobrineCloneEntity.setPossessedByUuid(nullShovelEntity.getNullUUID()); }
/*      */         else
/*  173 */         { NullHoeEntity nullHoeEntity = (NullHoeEntity)herobrineEntity;
/*  174 */           lowHerobrineCloneEntity.setPossessedByEntity((HerobrineMob)nullHoeEntity.getNullEntity());
/*  175 */           lowHerobrineCloneEntity.setPossessedByUuid(nullHoeEntity.getNullUUID()); }
/*      */          }
/*      */       
/*  178 */       if (mob instanceof LowShadowHerobrineCloneEntity) { LowShadowHerobrineCloneEntity lowShadowHerobrineCloneEntity1 = (LowShadowHerobrineCloneEntity)mob;
/*  179 */         if (herobrineEntity instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)herobrineEntity;
/*  180 */           lowShadowHerobrineCloneEntity1.setPossessedByEntity(herobrineMob);
/*  181 */           lowShadowHerobrineCloneEntity1.setPossessedByUuid(herobrineMob.m_20148_()); }
/*      */          }
/*      */       
/*  184 */       mob.m_6518_((ServerLevelAccessor)serverLevel, world.m_6436_(entity.m_20183_()), MobSpawnType.MOB_SUMMONED, null, null);
/*  185 */       serverLevel.m_7967_((Entity)lowShadowHerobrineCloneEntity); }
/*      */   
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
/*      */ 
/*      */   
/*      */   public static void initialSpawn(LevelAccessor levelaccessor, Entity entity, int recallTicks, MobSpawnType mobSpawnType) {
/*      */     // Byte code:
/*      */     //   0: getstatic com/pla/annoyingvillagers/config/AnnoyingVillagersConfig.HEROBRINE_RECALL_MIN_TIME : Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
/*      */     //   3: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   6: checkcast java/lang/Integer
/*      */     //   9: invokevirtual intValue : ()I
/*      */     //   12: istore #4
/*      */     //   14: getstatic com/pla/annoyingvillagers/config/AnnoyingVillagersConfig.HEROBRINE_RECALL_MAX_TIME : Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
/*      */     //   17: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   20: checkcast java/lang/Integer
/*      */     //   23: invokevirtual intValue : ()I
/*      */     //   26: istore #5
/*      */     //   28: iload #4
/*      */     //   30: iload #5
/*      */     //   32: invokestatic min : (II)I
/*      */     //   35: istore #6
/*      */     //   37: iload #4
/*      */     //   39: iload #5
/*      */     //   41: invokestatic max : (II)I
/*      */     //   44: istore #7
/*      */     //   46: aload_1
/*      */     //   47: ifnull -> 619
/*      */     //   50: aload_0
/*      */     //   51: invokeinterface m_5776_ : ()Z
/*      */     //   56: ifne -> 520
/*      */     //   59: aload_0
/*      */     //   60: invokeinterface m_7654_ : ()Lnet/minecraft/server/MinecraftServer;
/*      */     //   65: ifnull -> 520
/*      */     //   68: aload_1
/*      */     //   69: invokevirtual getPersistentData : ()Lnet/minecraft/nbt/CompoundTag;
/*      */     //   72: ldc_w 'killed_name'
/*      */     //   75: invokevirtual m_128461_ : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   78: astore #8
/*      */     //   80: aload #8
/*      */     //   82: invokevirtual isEmpty : ()Z
/*      */     //   85: ifne -> 123
/*      */     //   88: aload_0
/*      */     //   89: invokeinterface m_7654_ : ()Lnet/minecraft/server/MinecraftServer;
/*      */     //   94: invokevirtual m_6846_ : ()Lnet/minecraft/server/players/PlayerList;
/*      */     //   97: aload #8
/*      */     //   99: ldc_w 'subtitles.possessed_npc'
/*      */     //   102: invokestatic m_237115_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   105: invokevirtual getString : ()Ljava/lang/String;
/*      */     //   108: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*      */     //   113: invokestatic m_237113_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   116: iconst_0
/*      */     //   117: invokevirtual m_240416_ : (Lnet/minecraft/network/chat/Component;Z)V
/*      */     //   120: goto -> 520
/*      */     //   123: aload_1
/*      */     //   124: instanceof com/pla/annoyingvillagers/entity/LowHerobrineCloneEntity
/*      */     //   127: ifeq -> 144
/*      */     //   130: aload_1
/*      */     //   131: checkcast com/pla/annoyingvillagers/entity/LowHerobrineCloneEntity
/*      */     //   134: astore #9
/*      */     //   136: aload #9
/*      */     //   138: invokevirtual isSummoned : ()Z
/*      */     //   141: ifeq -> 165
/*      */     //   144: aload_1
/*      */     //   145: instanceof com/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity
/*      */     //   148: ifeq -> 193
/*      */     //   151: aload_1
/*      */     //   152: checkcast com/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity
/*      */     //   155: astore #10
/*      */     //   157: aload #10
/*      */     //   159: invokevirtual isSummoned : ()Z
/*      */     //   162: ifne -> 193
/*      */     //   165: aload_0
/*      */     //   166: invokeinterface m_7654_ : ()Lnet/minecraft/server/MinecraftServer;
/*      */     //   171: invokevirtual m_6846_ : ()Lnet/minecraft/server/players/PlayerList;
/*      */     //   174: ldc_w 'subtitles.possessed_random'
/*      */     //   177: invokestatic m_237115_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   180: invokevirtual getString : ()Ljava/lang/String;
/*      */     //   183: invokestatic m_237113_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   186: iconst_0
/*      */     //   187: invokevirtual m_240416_ : (Lnet/minecraft/network/chat/Component;Z)V
/*      */     //   190: goto -> 520
/*      */     //   193: iload_2
/*      */     //   194: ifne -> 243
/*      */     //   197: iload #6
/*      */     //   199: new java/util/Random
/*      */     //   202: dup
/*      */     //   203: invokespecial <init> : ()V
/*      */     //   206: iload #7
/*      */     //   208: iload #6
/*      */     //   210: isub
/*      */     //   211: iconst_1
/*      */     //   212: iadd
/*      */     //   213: invokevirtual nextInt : (I)I
/*      */     //   216: iadd
/*      */     //   217: bipush #60
/*      */     //   219: imul
/*      */     //   220: bipush #20
/*      */     //   222: imul
/*      */     //   223: istore_2
/*      */     //   224: aload_1
/*      */     //   225: instanceof com/pla/annoyingvillagers/clazz/HerobrineMob
/*      */     //   228: ifeq -> 243
/*      */     //   231: aload_1
/*      */     //   232: checkcast com/pla/annoyingvillagers/clazz/HerobrineMob
/*      */     //   235: astore #11
/*      */     //   237: aload #11
/*      */     //   239: iload_2
/*      */     //   240: invokevirtual setRecallTicks : (I)V
/*      */     //   243: aload_3
/*      */     //   244: getstatic net/minecraft/world/entity/MobSpawnType.NATURAL : Lnet/minecraft/world/entity/MobSpawnType;
/*      */     //   247: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   250: ifne -> 263
/*      */     //   253: aload_3
/*      */     //   254: getstatic net/minecraft/world/entity/MobSpawnType.CHUNK_GENERATION : Lnet/minecraft/world/entity/MobSpawnType;
/*      */     //   257: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   260: ifeq -> 420
/*      */     //   263: invokestatic random : ()D
/*      */     //   266: ldc2_w 0.5
/*      */     //   269: dcmpg
/*      */     //   270: ifgt -> 301
/*      */     //   273: aload_0
/*      */     //   274: invokeinterface m_7654_ : ()Lnet/minecraft/server/MinecraftServer;
/*      */     //   279: invokevirtual m_6846_ : ()Lnet/minecraft/server/players/PlayerList;
/*      */     //   282: ldc_w 'subtitles.possessed_random'
/*      */     //   285: invokestatic m_237115_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   288: invokevirtual getString : ()Ljava/lang/String;
/*      */     //   291: invokestatic m_237113_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   294: iconst_0
/*      */     //   295: invokevirtual m_240416_ : (Lnet/minecraft/network/chat/Component;Z)V
/*      */     //   298: goto -> 520
/*      */     //   301: aload_1
/*      */     //   302: instanceof com/pla/annoyingvillagers/clazz/HerobrineMob
/*      */     //   305: ifeq -> 363
/*      */     //   308: aload_1
/*      */     //   309: checkcast com/pla/annoyingvillagers/clazz/HerobrineMob
/*      */     //   312: astore #11
/*      */     //   314: aload #11
/*      */     //   316: iconst_1
/*      */     //   317: invokevirtual setRenderPortal : (Z)V
/*      */     //   320: aload #11
/*      */     //   322: invokestatic spawnHerobrine : (Lnet/minecraft/world/entity/LivingEntity;)V
/*      */     //   325: aload_0
/*      */     //   326: invokeinterface m_7654_ : ()Lnet/minecraft/server/MinecraftServer;
/*      */     //   331: invokevirtual m_6846_ : ()Lnet/minecraft/server/players/PlayerList;
/*      */     //   334: aload #11
/*      */     //   336: invokevirtual getChatName : ()Ljava/lang/String;
/*      */     //   339: ldc_w 'subtitles.herobrine_arrive'
/*      */     //   342: invokestatic m_237115_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   345: invokevirtual getString : ()Ljava/lang/String;
/*      */     //   348: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*      */     //   353: invokestatic m_237113_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   356: iconst_0
/*      */     //   357: invokevirtual m_240416_ : (Lnet/minecraft/network/chat/Component;Z)V
/*      */     //   360: goto -> 417
/*      */     //   363: aload_1
/*      */     //   364: instanceof com/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity
/*      */     //   367: ifeq -> 417
/*      */     //   370: aload_1
/*      */     //   371: checkcast com/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity
/*      */     //   374: astore #12
/*      */     //   376: aload #12
/*      */     //   378: iconst_1
/*      */     //   379: invokevirtual setRenderPortal : (Z)V
/*      */     //   382: aload #12
/*      */     //   384: invokestatic spawnHerobrine : (Lnet/minecraft/world/entity/LivingEntity;)V
/*      */     //   387: aload_0
/*      */     //   388: invokeinterface m_7654_ : ()Lnet/minecraft/server/MinecraftServer;
/*      */     //   393: invokevirtual m_6846_ : ()Lnet/minecraft/server/players/PlayerList;
/*      */     //   396: ldc_w 'subtitles.herobrine_arrive'
/*      */     //   399: invokestatic m_237115_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   402: invokevirtual getString : ()Ljava/lang/String;
/*      */     //   405: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   410: invokestatic m_237113_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   413: iconst_0
/*      */     //   414: invokevirtual m_240416_ : (Lnet/minecraft/network/chat/Component;Z)V
/*      */     //   417: goto -> 520
/*      */     //   420: aload_1
/*      */     //   421: instanceof com/pla/annoyingvillagers/clazz/HerobrineMob
/*      */     //   424: ifeq -> 502
/*      */     //   427: aload_1
/*      */     //   428: checkcast com/pla/annoyingvillagers/clazz/HerobrineMob
/*      */     //   431: astore #11
/*      */     //   433: aload_3
/*      */     //   434: getstatic net/minecraft/world/entity/MobSpawnType.SPAWN_EGG : Lnet/minecraft/world/entity/MobSpawnType;
/*      */     //   437: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   440: ifne -> 453
/*      */     //   443: aload_3
/*      */     //   444: getstatic net/minecraft/world/entity/MobSpawnType.COMMAND : Lnet/minecraft/world/entity/MobSpawnType;
/*      */     //   447: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   450: ifeq -> 459
/*      */     //   453: aload #11
/*      */     //   455: iconst_1
/*      */     //   456: invokevirtual setRenderPortal : (Z)V
/*      */     //   459: aload #11
/*      */     //   461: invokestatic spawnHerobrine : (Lnet/minecraft/world/entity/LivingEntity;)V
/*      */     //   464: aload_0
/*      */     //   465: invokeinterface m_7654_ : ()Lnet/minecraft/server/MinecraftServer;
/*      */     //   470: invokevirtual m_6846_ : ()Lnet/minecraft/server/players/PlayerList;
/*      */     //   473: aload #11
/*      */     //   475: invokevirtual getChatName : ()Ljava/lang/String;
/*      */     //   478: ldc_w 'subtitles.herobrine_arrive'
/*      */     //   481: invokestatic m_237115_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   484: invokevirtual getString : ()Ljava/lang/String;
/*      */     //   487: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*      */     //   492: invokestatic m_237113_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*      */     //   495: iconst_0
/*      */     //   496: invokevirtual m_240416_ : (Lnet/minecraft/network/chat/Component;Z)V
/*      */     //   499: goto -> 520
/*      */     //   502: aload_1
/*      */     //   503: instanceof net/minecraft/world/entity/LivingEntity
/*      */     //   506: ifeq -> 520
/*      */     //   509: aload_1
/*      */     //   510: checkcast net/minecraft/world/entity/LivingEntity
/*      */     //   513: astore #12
/*      */     //   515: aload #12
/*      */     //   517: invokestatic spawnHerobrine : (Lnet/minecraft/world/entity/LivingEntity;)V
/*      */     //   520: aload_1
/*      */     //   521: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*      */     //   524: instanceof net/minecraft/server/level/ServerLevel
/*      */     //   527: ifeq -> 580
/*      */     //   530: aload_1
/*      */     //   531: instanceof com/pla/annoyingvillagers/entity/HerobrineCloneEntity
/*      */     //   534: ifne -> 565
/*      */     //   537: aload_1
/*      */     //   538: instanceof com/pla/annoyingvillagers/entity/ShadowHerobrineCloneEntity
/*      */     //   541: ifne -> 565
/*      */     //   544: aload_1
/*      */     //   545: instanceof com/pla/annoyingvillagers/entity/HerobrineChrisEntity
/*      */     //   548: ifne -> 565
/*      */     //   551: aload_1
/*      */     //   552: instanceof com/pla/annoyingvillagers/entity/Herobrine7Entity
/*      */     //   555: ifne -> 565
/*      */     //   558: aload_1
/*      */     //   559: instanceof com/pla/annoyingvillagers/entity/ArmoredHerobrineEntity
/*      */     //   562: ifeq -> 580
/*      */     //   565: aload_1
/*      */     //   566: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModSounds.HEROBRINE_CLONE_SAY_ON_SPAWN : Lnet/minecraftforge/registries/RegistryObject;
/*      */     //   569: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   572: checkcast net/minecraft/sounds/SoundEvent
/*      */     //   575: fconst_1
/*      */     //   576: fconst_1
/*      */     //   577: invokevirtual m_5496_ : (Lnet/minecraft/sounds/SoundEvent;FF)V
/*      */     //   580: aload_1
/*      */     //   581: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*      */     //   584: instanceof net/minecraft/server/level/ServerLevel
/*      */     //   587: ifeq -> 612
/*      */     //   590: aload_1
/*      */     //   591: instanceof com/pla/annoyingvillagers/entity/ShadowHerobrineEntity
/*      */     //   594: ifeq -> 612
/*      */     //   597: aload_1
/*      */     //   598: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModSounds.SHADOW_HEROBRINE_SAY_ON_SPAWN : Lnet/minecraftforge/registries/RegistryObject;
/*      */     //   601: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   604: checkcast net/minecraft/sounds/SoundEvent
/*      */     //   607: fconst_1
/*      */     //   608: fconst_1
/*      */     //   609: invokevirtual m_5496_ : (Lnet/minecraft/sounds/SoundEvent;FF)V
/*      */     //   612: aload_1
/*      */     //   613: ldc_w 'herobrine'
/*      */     //   616: invokestatic addOrJoinTeam : (Lnet/minecraft/world/entity/Entity;Ljava/lang/String;)V
/*      */     //   619: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #190	-> 0
/*      */     //   #191	-> 14
/*      */     //   #192	-> 28
/*      */     //   #193	-> 37
/*      */     //   #195	-> 46
/*      */     //   #196	-> 50
/*      */     //   #197	-> 68
/*      */     //   #198	-> 80
/*      */     //   #199	-> 88
/*      */     //   #201	-> 123
/*      */     //   #202	-> 165
/*      */     //   #204	-> 193
/*      */     //   #205	-> 197
/*      */     //   #206	-> 224
/*      */     //   #207	-> 237
/*      */     //   #210	-> 243
/*      */     //   #211	-> 263
/*      */     //   #212	-> 273
/*      */     //   #214	-> 301
/*      */     //   #215	-> 314
/*      */     //   #216	-> 320
/*      */     //   #217	-> 325
/*      */     //   #218	-> 363
/*      */     //   #219	-> 376
/*      */     //   #220	-> 382
/*      */     //   #221	-> 387
/*      */     //   #225	-> 420
/*      */     //   #226	-> 433
/*      */     //   #227	-> 453
/*      */     //   #229	-> 459
/*      */     //   #230	-> 464
/*      */     //   #231	-> 502
/*      */     //   #233	-> 515
/*      */     //   #240	-> 520
/*      */     //   #246	-> 565
/*      */     //   #249	-> 580
/*      */     //   #251	-> 597
/*      */     //   #254	-> 612
/*      */     //   #256	-> 619
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   136	8	9	lowHerobrineCloneEntity	Lcom/pla/annoyingvillagers/entity/LowHerobrineCloneEntity;
/*      */     //   157	8	10	lowShadowHerobrineCloneEntity	Lcom/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity;
/*      */     //   237	6	11	herobrineMob	Lcom/pla/annoyingvillagers/clazz/HerobrineMob;
/*      */     //   314	49	11	herobrineMob	Lcom/pla/annoyingvillagers/clazz/HerobrineMob;
/*      */     //   376	41	12	lowShadowHerobrineCloneEntity	Lcom/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity;
/*      */     //   433	69	11	herobrineMob	Lcom/pla/annoyingvillagers/clazz/HerobrineMob;
/*      */     //   515	5	12	livingEntity	Lnet/minecraft/world/entity/LivingEntity;
/*      */     //   80	440	8	killedName	Ljava/lang/String;
/*      */     //   0	620	0	levelaccessor	Lnet/minecraft/world/level/LevelAccessor;
/*      */     //   0	620	1	entity	Lnet/minecraft/world/entity/Entity;
/*      */     //   0	620	2	recallTicks	I
/*      */     //   0	620	3	mobSpawnType	Lnet/minecraft/world/entity/MobSpawnType;
/*      */     //   14	606	4	min	I
/*      */     //   28	592	5	max	I
/*      */     //   37	583	6	randomMin	I
/*      */     //   46	574	7	randomMax	I
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
/*      */   
/*      */   public static void spawnEliteEffect(Level level, double x, double y, double z, Entity entity) {
/*  259 */     if (entity != null && level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  260 */       if (Math.random() <= 0.3D) {
/*  261 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.PE
/*  262 */             .get(), x, y, z, 1, 0.4D, 1.1D, 0.4D, 0.0D);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  268 */         if (Math.random() <= 0.87D) {
/*  269 */           serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.PE
/*  270 */               .get(), x, y, z, 1, 0.45D, 1.5D, 0.3D, 0.0D);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  276 */           serverLevel.m_6263_(null, x, y, z, (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY
/*      */               
/*  278 */               .get(), SoundSource.NEUTRAL, (new Random())
/*      */               
/*  280 */               .nextFloat(0.05F, 0.4F), (new Random())
/*  281 */               .nextFloat(0.5F, 1.2F));
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   private static final class Basis extends Record {
/*      */     private final Vec3 fwd; private final Vec3 right; private final Vec3 up;
/*  288 */     private Basis(Vec3 fwd, Vec3 right, Vec3 up) { this.fwd = fwd; this.right = right; this.up = up; } public final String toString() { // Byte code:
/*      */       //   0: aload_0
/*      */       //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/util/HerobrineUtil$Basis;)Ljava/lang/String;
/*      */       //   6: areturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #288	-> 0
/*      */       // Local variable table:
/*      */       //   start	length	slot	name	descriptor
/*      */       //   0	7	0	this	Lcom/pla/annoyingvillagers/util/HerobrineUtil$Basis; } public final int hashCode() { // Byte code:
/*      */       //   0: aload_0
/*      */       //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/util/HerobrineUtil$Basis;)I
/*      */       //   6: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #288	-> 0
/*      */       // Local variable table:
/*      */       //   start	length	slot	name	descriptor
/*      */       //   0	7	0	this	Lcom/pla/annoyingvillagers/util/HerobrineUtil$Basis; } public final boolean equals(Object o) { // Byte code:
/*      */       //   0: aload_0
/*      */       //   1: aload_1
/*      */       //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/util/HerobrineUtil$Basis;Ljava/lang/Object;)Z
/*      */       //   7: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #288	-> 0
/*      */       // Local variable table:
/*      */       //   start	length	slot	name	descriptor
/*      */       //   0	8	0	this	Lcom/pla/annoyingvillagers/util/HerobrineUtil$Basis;
/*  288 */       //   0	8	1	o	Ljava/lang/Object; } public Vec3 fwd() { return this.fwd; } public Vec3 right() { return this.right; } public Vec3 up() { return this.up; }
/*      */      }
/*      */   public static void spawnObsidianEyeLineStaggered(final ServerLevel level, final Entity entity, final BlockState state, int tickGap) {
/*  291 */     if (level == null || entity == null)
/*      */       return; 
/*  293 */     Basis b = basisFromEntity(entity);
/*  294 */     Vec3 eye = entity.m_20299_(1.0F);
/*      */     
/*  296 */     BlockPos[] sequence = new BlockPos[7];
/*  297 */     sequence[0] = BlockPos.m_274446_((Position)eye.m_82549_(b.fwd().m_82490_(1.0D)).m_82549_(b.up().m_82490_(-1.0D))); int i;
/*  298 */     for (i = 1; i <= 6; i++) {
/*  299 */       sequence[i] = BlockPos.m_274446_((Position)eye.m_82549_(b.fwd().m_82490_(i)));
/*      */     }
/*      */     
/*  302 */     for (i = 0; i < sequence.length; i++) {
/*  303 */       final BlockPos pos = sequence[i];
/*  304 */       new DelayedTask(i * Math.max(1, tickGap)) {
/*      */           public void run() {
/*  306 */             HerobrineUtil.placeIfReplaceable(level, pos, state, entity);
/*      */           }
/*      */         };
/*      */     } 
/*      */   }
/*      */   private static final class Pattern2D {
/*      */     final int w; final int h;
/*      */     final int[][] cells;
/*      */     
/*  315 */     Pattern2D(int w, int h, int[][] cells) { this.w = w; this.h = h; this.cells = cells; } int centerX() {
/*  316 */       return this.w / 2;
/*      */     }
/*      */   }
/*  319 */   private static final Pattern2D[] OBSIDIAN_PATTERNS = new Pattern2D[] { new Pattern2D(1, 3, new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 } }), new Pattern2D(2, 3, new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } }), new Pattern2D(2, 3, new int[][] { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 0, 1 } }), new Pattern2D(3, 3, new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 }, { 1, 2 } }), new Pattern2D(3, 3, new int[][] { { 0, 2 }, { 1, 2 }, { 2, 2 }, { 1, 1 }, { 1, 0 } }), new Pattern2D(3, 3, new int[][] { { 1, 1 }, { 1, 2 }, { 1, 0 }, { 0, 1 }, { 2, 1 } }), new Pattern2D(3, 4, new int[][] { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 0, 2 }, { 2, 2 } }), new Pattern2D(2, 2, new int[][] { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } }), new Pattern2D(3, 3, new int[][] { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 }, { 0, 2 }, { 1, 2 } }), new Pattern2D(3, 3, new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 2 } }), new Pattern2D(3, 2, new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, 1 } }) };
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
/*      */   private static boolean hasGroundWithin(ServerLevel level, Entity e, int maxDown) {
/*  334 */     Vec3 start = new Vec3(e.m_20185_(), (e.m_20191_()).f_82289_ + 0.001D, e.m_20189_());
/*  335 */     Vec3 end = start.m_82520_(0.0D, -maxDown, 0.0D);
/*      */     
/*  337 */     BlockHitResult hit = level.m_45547_(new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, e));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  343 */     return (hit.m_6662_() != HitResult.Type.MISS);
/*      */   }
/*      */   
/*      */   public static void spawnObsidianPatternAtBody(ServerLevel level, Entity entity, BlockState state) {
/*  347 */     if (level == null || entity == null)
/*  348 */       return;  if (!hasGroundWithin(level, entity, 3))
/*      */       return; 
/*  350 */     int minY = level.m_141937_();
/*  351 */     int maxY = level.m_151558_() - 1;
/*      */     
/*  353 */     BlockPos feet = BlockPos.m_274561_(entity.m_20185_(), (entity.m_20191_()).f_82289_, entity.m_20189_());
/*      */     
/*  355 */     RandomSource rand = level.m_213780_();
/*  356 */     Pattern2D pat = OBSIDIAN_PATTERNS[rand.m_188503_(OBSIDIAN_PATTERNS.length)];
/*      */     
/*  358 */     Direction face = Direction.Plane.HORIZONTAL.m_235690_(rand);
/*  359 */     boolean mirror = rand.m_188499_();
/*  360 */     BlockPos origin = feet.m_121945_(face);
/*      */     
/*  362 */     Direction side = mirror ? face.m_122428_() : face.m_122427_();
/*  363 */     int cx = pat.centerX();
/*      */     
/*  365 */     for (int[] c : pat.cells) {
/*  366 */       int localX = c[0] - cx;
/*  367 */       int localY = c[1];
/*      */       
/*  369 */       int y = origin.m_123342_() + localY;
/*  370 */       if (y >= minY && y <= maxY) {
/*      */         
/*  372 */         BlockPos p = origin.m_7918_(side
/*  373 */             .m_122429_() * localX, localY, side
/*      */             
/*  375 */             .m_122431_() * localX);
/*      */ 
/*      */         
/*  378 */         placeIfReplaceable(level, p, state, entity);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void summonObsidianBlocksInfrontOf(final ServerLevel level, final LivingEntity caster, final BlockState obsidianState, int amount, final Joint joint) {
/*  387 */     if (level == null || caster == null)
/*      */       return; 
/*  389 */     final Vec3[] lockedEye = { null };
/*  390 */     final Vec3[] lockedDir = { null };
/*  391 */     final int[] anchorY = { Integer.MIN_VALUE };
/*      */     
/*  393 */     for (int i = 1; i <= amount; i++) {
/*  394 */       final int forwardBlock = i + 1;
/*      */       
/*  396 */       new DelayedTask(i) { public void run() {
/*      */             Vec3 placeVec;
/*  398 */             if (!caster.m_6084_())
/*  399 */               return;  if (caster.m_9236_() != level)
/*      */               return; 
/*  401 */             if (lockedDir[0] == null) {
/*  402 */               lockedEye[0] = caster.m_20299_(1.0F);
/*  403 */               lockedDir[0] = caster.m_20154_().m_82541_();
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*  408 */             if (forwardBlock == 2) {
/*  409 */               Vec3 jointVec = EpicfightUtil.getJointWithTranslation((Entity)caster, new Vec3f(0.0F, 0.0F, 0.0F), joint, 0.0F, 0.0D);
/*      */ 
/*      */ 
/*      */               
/*  413 */               if (jointVec == null)
/*      */                 return; 
/*  415 */               placeVec = jointVec.m_82549_(lockedDir[0].m_82490_(1.0D));
/*  416 */               anchorY[0] = BlockPos.m_274446_((Position)placeVec).m_123342_();
/*      */             } else {
/*  418 */               if (anchorY[0] == Integer.MIN_VALUE)
/*      */                 return; 
/*  420 */               Vec3 target = lockedEye[0].m_82549_(lockedDir[0].m_82490_(forwardBlock));
/*  421 */               placeVec = new Vec3(target.f_82479_, anchorY[0] + 0.5D, target.f_82481_);
/*      */             } 
/*      */             
/*  424 */             HerobrineUtil.placeIfReplaceable(level, BlockPos.m_274446_((Position)placeVec), obsidianState, (Entity)caster);
/*      */           } }
/*      */         ;
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void summonObsidianWall(ServerLevel level, LivingEntity caster, BlockState obsidianState) {
/*  431 */     if (level == null || caster == null)
/*      */       return; 
/*  433 */     Vec3 eye = caster.m_20299_(1.0F);
/*  434 */     Vec3 fwd = caster.m_20154_().m_82541_();
/*      */     
/*  436 */     Vec3 left = new Vec3(fwd.f_82481_, 0.0D, -fwd.f_82479_);
/*  437 */     if (left.m_82556_() < 1.0E-6D) { left = new Vec3(1.0D, 0.0D, 0.0D); }
/*  438 */     else { left = left.m_82541_(); }
/*      */     
/*  440 */     Vec3 up = fwd.m_82537_(left).m_82541_();
/*  441 */     BlockPos p1 = BlockPos.m_274446_((Position)eye
/*  442 */         .m_82549_(left.m_82490_(-2.0D)).m_82549_(up.m_82490_(-1.0D)).m_82549_(fwd.m_82490_(3.0D)));
/*      */     
/*  444 */     BlockPos p2 = BlockPos.m_274446_((Position)eye
/*  445 */         .m_82549_(left.m_82490_(2.0D)).m_82549_(up.m_82490_(2.0D)).m_82549_(fwd.m_82490_(3.0D)));
/*      */ 
/*      */     
/*  448 */     if (!caster.m_6084_())
/*      */       return; 
/*  450 */     int minX = Math.min(p1.m_123341_(), p2.m_123341_());
/*  451 */     int minY = Math.min(p1.m_123342_(), p2.m_123342_());
/*  452 */     int minZ = Math.min(p1.m_123343_(), p2.m_123343_());
/*  453 */     int maxX = Math.max(p1.m_123341_(), p2.m_123341_());
/*  454 */     int maxY = Math.max(p1.m_123342_(), p2.m_123342_());
/*  455 */     int maxZ = Math.max(p1.m_123343_(), p2.m_123343_());
/*      */     
/*  457 */     BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
/*  458 */     for (int x = minX; x <= maxX; x++) {
/*  459 */       for (int y = minY; y <= maxY; y++) {
/*  460 */         for (int z = minZ; z <= maxZ; z++) {
/*  461 */           pos.m_122178_(x, y, z);
/*  462 */           placeIfReplaceable(level, (BlockPos)pos, obsidianState, (Entity)caster);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void placePillarWorldOffsets(ServerLevel level, Vec3 eye, int dx, int dz, BlockState state, LivingEntity caster) {
/*  469 */     for (int dy = -1; dy <= 1; dy++) {
/*  470 */       BlockPos pos = BlockPos.m_274561_(eye.f_82479_ + dx, eye.f_82480_ + dy, eye.f_82481_ + dz);
/*  471 */       placeIfReplaceable(level, pos, state, (Entity)caster);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void placeSingleWorldOffset(ServerLevel level, Vec3 eye, int dx, int dy, int dz, BlockState state, LivingEntity caster) {
/*  476 */     BlockPos pos = BlockPos.m_274561_(eye.f_82479_ + dx, eye.f_82480_ + dy, eye.f_82481_ + dz);
/*  477 */     placeIfReplaceable(level, pos, state, (Entity)caster);
/*      */   }
/*      */   
/*      */   public static void summonObsidianCross(final ServerLevel level, final LivingEntity caster, final BlockState obsidianState) {
/*  481 */     if (level == null || caster == null)
/*      */       return; 
/*  483 */     new DelayedTask(2) {
/*      */         public void run() {
/*  485 */           if (!caster.m_6084_())
/*  486 */             return;  Vec3 eye = caster.m_20299_(1.0F);
/*      */           
/*  488 */           HerobrineUtil.placePillarWorldOffsets(level, eye, 0, 3, obsidianState, caster);
/*  489 */           HerobrineUtil.placePillarWorldOffsets(level, eye, 0, -3, obsidianState, caster);
/*      */           
/*  491 */           HerobrineUtil.placePillarWorldOffsets(level, eye, 3, 0, obsidianState, caster);
/*  492 */           HerobrineUtil.placePillarWorldOffsets(level, eye, -3, 0, obsidianState, caster);
/*      */         }
/*      */       };
/*      */     
/*  496 */     new DelayedTask(4) {
/*      */         public void run() {
/*  498 */           if (!caster.m_6084_())
/*  499 */             return;  Vec3 eye = caster.m_20299_(1.0F);
/*      */           
/*  501 */           HerobrineUtil.placeSingleWorldOffset(level, eye, 0, 2, 3, obsidianState, caster);
/*  502 */           HerobrineUtil.placeSingleWorldOffset(level, eye, 0, 2, -3, obsidianState, caster);
/*  503 */           HerobrineUtil.placeSingleWorldOffset(level, eye, 3, 2, 0, obsidianState, caster);
/*  504 */           HerobrineUtil.placeSingleWorldOffset(level, eye, -3, 2, 0, obsidianState, caster);
/*      */         }
/*      */       };
/*      */     
/*  508 */     new DelayedTask(6) {
/*      */         public void run() {
/*  510 */           if (!caster.m_6084_())
/*  511 */             return;  Vec3 eye = caster.m_20299_(1.0F);
/*      */           
/*  513 */           int[] dist = { 5, 7 };
/*  514 */           for (int d : dist) {
/*  515 */             HerobrineUtil.placePillarWorldOffsets(level, eye, 0, d, obsidianState, caster);
/*  516 */             HerobrineUtil.placePillarWorldOffsets(level, eye, 0, -d, obsidianState, caster);
/*  517 */             HerobrineUtil.placePillarWorldOffsets(level, eye, d, 0, obsidianState, caster);
/*  518 */             HerobrineUtil.placePillarWorldOffsets(level, eye, -d, 0, obsidianState, caster);
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  523 */     new DelayedTask(8) {
/*      */         public void run() {
/*  525 */           if (!caster.m_6084_())
/*  526 */             return;  Vec3 eye = caster.m_20299_(1.0F);
/*      */           
/*  528 */           int[] dists = { 5, 7 };
/*  529 */           for (int d : dists) {
/*  530 */             HerobrineUtil.placeSingleWorldOffset(level, eye, 0, 2, d, obsidianState, caster);
/*  531 */             HerobrineUtil.placeSingleWorldOffset(level, eye, 0, 2, -d, obsidianState, caster);
/*  532 */             HerobrineUtil.placeSingleWorldOffset(level, eye, d, 2, 0, obsidianState, caster);
/*  533 */             HerobrineUtil.placeSingleWorldOffset(level, eye, -d, 2, 0, obsidianState, caster);
/*      */           } 
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void placePillarWorldOffsetsHeight(ServerLevel level, Vec3 eye, int dx, int dz, int minDy, int maxDy, BlockState state, LivingEntity caster) {
/*  543 */     for (int dy = minDy; dy <= maxDy; dy++) {
/*  544 */       BlockPos pos = BlockPos.m_274561_(eye.f_82479_ + dx, eye.f_82480_ + dy, eye.f_82481_ + dz);
/*  545 */       placeIfReplaceable(level, pos, state, (Entity)caster);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void summonObsidianSmallCross(final ServerLevel level, final LivingEntity caster, final BlockState obsidianState) {
/*  550 */     if (level == null || caster == null)
/*      */       return; 
/*  552 */     new DelayedTask(2) {
/*      */         public void run() {
/*  554 */           if (!caster.m_6084_())
/*  555 */             return;  if (caster.m_9236_() != level)
/*      */             return; 
/*  557 */           Vec3 eye = caster.m_20299_(1.0F);
/*      */           
/*  559 */           boolean isLongPillar = obsidianState.m_60713_((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR.get());
/*  560 */           int minDy = -1;
/*  561 */           int maxDy = isLongPillar ? -1 : 0;
/*  562 */           int d = 3;
/*      */           
/*  564 */           HerobrineUtil.placePillarWorldOffsetsHeight(level, eye, 0, d, minDy, maxDy, obsidianState, caster);
/*  565 */           HerobrineUtil.placePillarWorldOffsetsHeight(level, eye, 0, -d, minDy, maxDy, obsidianState, caster);
/*      */           
/*  567 */           HerobrineUtil.placePillarWorldOffsetsHeight(level, eye, d, 0, minDy, maxDy, obsidianState, caster);
/*  568 */           HerobrineUtil.placePillarWorldOffsetsHeight(level, eye, -d, 0, minDy, maxDy, obsidianState, caster);
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   public static void summonObsidianPillar(final ServerLevel level, final LivingEntity caster, final BlockState obsidianState) {
/*  574 */     if (level == null || caster == null)
/*      */       return; 
/*  576 */     Vec3 eye = caster.m_20299_(1.0F);
/*  577 */     Vec3 fwd = caster.m_20154_().m_82541_();
/*      */     
/*  579 */     Vec3 ahead = eye.m_82549_(fwd.m_82490_(2.0D));
/*  580 */     Vec3 bodyLevelAhead = new Vec3(ahead.f_82479_, caster.m_20186_(), ahead.f_82481_);
/*      */     
/*  582 */     final BlockPos base = BlockPos.m_274446_((Position)bodyLevelAhead).m_6625_(1);
/*      */     
/*  584 */     for (int delay = 1; delay <= 12; delay++) {
/*  585 */       final int yOffset = delay - 1;
/*      */       
/*  587 */       new DelayedTask(delay) {
/*      */           public void run() {
/*  589 */             if (!caster.m_6084_())
/*      */               return; 
/*  591 */             BlockPos pos = base.m_6630_(yOffset);
/*  592 */             HerobrineUtil.placeIfReplaceable(level, pos, obsidianState, (Entity)caster);
/*      */           }
/*      */         };
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void summonShadowObsidianShortPillarShootToward(ServerLevel level, Entity ownerEntity, int maxDistance, Joint joint) {
/*  599 */     if (level == null || ownerEntity == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  604 */     BlockState baseState = (BlockState)((BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_SHORT_PILLAR.get()).m_49966_().m_61124_((Property)HerobrineObsidianBlock.FROM_PLAYER, Boolean.valueOf(ownerEntity instanceof net.minecraft.world.entity.player.Player))).m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)ownerEntity.m_6350_());
/*      */     
/*  606 */     summonPillarsTowardJoint(level, ownerEntity, baseState, Math.max(2, maxDistance), joint);
/*      */   }
/*      */   
/*      */   public static void summonShadowObsidianMiddlePillarShootToward(ServerLevel level, Entity ownerEntity, int maxDistance, Joint joint) {
/*  610 */     if (level == null || ownerEntity == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  615 */     BlockState baseState = (BlockState)((BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_MIDDLE_PILLAR.get()).m_49966_().m_61124_((Property)HerobrineObsidianBlock.FROM_PLAYER, Boolean.valueOf(ownerEntity instanceof net.minecraft.world.entity.player.Player))).m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)ownerEntity.m_6350_());
/*  616 */     summonPillarsTowardJoint(level, ownerEntity, baseState, maxDistance, joint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void summonPillarsTowardJoint(final ServerLevel level, final Entity ownerEntity, final BlockState blockState, int maxDistance, final Joint joint) {
/*  624 */     final Vec3[] lockedDir = { null };
/*  625 */     final Vec3[] lockedJoint = { null };
/*  626 */     final Direction[] lockedFacing = { null };
/*  627 */     final int[] anchorY = { Integer.MIN_VALUE };
/*      */     
/*  629 */     for (int dist = 2; dist <= maxDistance + 1; dist++) {
/*  630 */       final int d = dist;
/*      */       
/*  632 */       new DelayedTask(d) {
/*      */           public void run() {
/*  634 */             if (!ownerEntity.m_6084_())
/*  635 */               return;  if (ownerEntity.m_9236_() != level)
/*  636 */               return;  if (lockedDir[0] == null) {
/*  637 */               lockedDir[0] = ownerEntity.m_20154_().m_82541_();
/*  638 */               lockedFacing[0] = ownerEntity.m_6350_();
/*      */               
/*  640 */               lockedJoint[0] = EpicfightUtil.getJointWithTranslation(ownerEntity, new Vec3f(0.0F, 0.0F, 0.0F), joint, 0.0F, 0.0D);
/*      */ 
/*      */ 
/*      */               
/*  644 */               if (lockedJoint[0] == null)
/*      */                 return; 
/*      */             } 
/*  647 */             BlockState stateNow = blockState;
/*  648 */             if (stateNow.m_61138_((Property)BlockStateProperties.f_61374_) && lockedFacing[0] != null) {
/*  649 */               stateNow = (BlockState)stateNow.m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)lockedFacing[0]);
/*      */             }
/*      */             
/*  652 */             Vec3 raw = lockedJoint[0].m_82549_(lockedDir[0].m_82490_(d));
/*      */             
/*  654 */             if (d == 2) {
/*  655 */               anchorY[0] = BlockPos.m_274446_((Position)raw).m_123342_();
/*  656 */             } else if (anchorY[0] == Integer.MIN_VALUE) {
/*      */               return;
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*  662 */             Vec3 placeVec = (d == 2) ? raw : new Vec3(raw.f_82479_, anchorY[0] + 0.5D, raw.f_82481_);
/*      */             
/*  664 */             HerobrineUtil.placeIfReplaceable(level, BlockPos.m_274446_((Position)placeVec), stateNow, ownerEntity);
/*      */           }
/*      */         };
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void summonShadowObsidianLongPillarDefense(ServerLevel level, Entity ownerEntity) {
/*  671 */     if (level == null || ownerEntity == null)
/*      */       return; 
/*  673 */     if (!ownerEntity.m_6084_())
/*  674 */       return;  if (ownerEntity.m_9236_() != level) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  679 */     BlockState longPillarState = (BlockState)((BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR.get()).m_49966_().m_61124_((Property)HerobrineObsidianBlock.FROM_PLAYER, Boolean.valueOf(ownerEntity instanceof net.minecraft.world.entity.player.Player))).m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)ownerEntity.m_6350_());
/*  680 */     Vec3 origin = ownerEntity.m_20299_(1.0F);
/*  681 */     Vec3 forward = ownerEntity.m_20154_().m_82541_();
/*  682 */     Vec3 worldUp = new Vec3(0.0D, 1.0D, 0.0D);
/*  683 */     Vec3 left = forward.m_82537_(worldUp);
/*  684 */     if (left.m_82556_() < 1.0E-6D) {
/*  685 */       Direction facing = ownerEntity.m_6350_();
/*  686 */       Direction leftDir = facing.m_122428_();
/*  687 */       left = new Vec3(leftDir.m_122429_(), 0.0D, leftDir.m_122431_());
/*      */     } else {
/*  689 */       left = left.m_82541_();
/*      */     } 
/*      */     
/*  692 */     Vec3 up = left.m_82537_(forward).m_82541_();
/*  693 */     int[][] localOffsets = { { 0, -1, 2 }, { -1, -1, 2 }, { 1, -1, 2 }, { -2, -1, 2 }, { 2, -1, 2 }, { 0, -1, 3 }, { -1, -1, 3 }, { 1, -1, 3 } };
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
/*  705 */     for (int[] o : localOffsets) {
/*  706 */       int dx = o[0];
/*  707 */       int dy = o[1];
/*  708 */       int dz = o[2];
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  713 */       Vec3 target = origin.m_82549_(left.m_82490_(dx)).m_82549_(up.m_82490_(dy)).m_82549_(forward.m_82490_(dz));
/*      */       
/*  715 */       BlockPos pos = BlockPos.m_274446_((Position)target);
/*  716 */       if (level.m_8055_(pos).m_60795_()) {
/*  717 */         placeIfReplaceable(level, pos, longPillarState, ownerEntity);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void summonShadowObsidianLongPillarDefenseWide(final ServerLevel level, final Entity ownerEntity) {
/*  723 */     int startDistance = 2;
/*  724 */     int depth = 5;
/*  725 */     int maxHalfWidth = 4;
/*  726 */     final int dy = -1;
/*  727 */     int startDelay = 2;
/*  728 */     if (level == null || ownerEntity == null)
/*  729 */       return;  if (!ownerEntity.m_6084_())
/*  730 */       return;  if (ownerEntity.m_9236_() != level) {
/*      */       return;
/*      */     }
/*      */     
/*  734 */     final BlockState longPillarState = (BlockState)((BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR.get()).m_49966_().m_61124_((Property)HerobrineObsidianBlock.FROM_PLAYER, Boolean.valueOf(ownerEntity instanceof net.minecraft.world.entity.player.Player))).m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)ownerEntity.m_6350_());
/*      */     
/*  736 */     final Vec3 origin = ownerEntity.m_20299_(1.0F);
/*  737 */     Vec3 look = ownerEntity.m_20154_();
/*  738 */     Vec3 forward = new Vec3(look.f_82479_, 0.0D, look.f_82481_);
/*  739 */     if (forward.m_82556_() < 1.0E-6D) {
/*  740 */       Direction dir = ownerEntity.m_6350_();
/*  741 */       forward = new Vec3(dir.m_122429_(), 0.0D, dir.m_122431_());
/*      */     } else {
/*  743 */       forward = forward.m_82541_();
/*      */     } 
/*      */     
/*  746 */     final Vec3 worldUp = new Vec3(0.0D, 1.0D, 0.0D);
/*  747 */     final Vec3 left = forward.m_82537_(worldUp).m_82541_();
/*  748 */     for (int dz = startDistance; dz < startDistance + depth; dz++) {
/*  749 */       final int fdz = dz;
/*  750 */       int halfWidth = Math.max(0, maxHalfWidth - fdz - startDistance);
/*      */       
/*  752 */       int rowDelay = startDelay + fdz - startDistance;
/*      */       
/*  754 */       for (int dx = -halfWidth; dx <= halfWidth; dx++) {
/*  755 */         final int fdx = dx;
/*      */         
/*  757 */         final Vec3 finalForward = forward;
/*  758 */         new DelayedTask(rowDelay)
/*      */           {
/*      */             public void run() {
/*  761 */               if (!ownerEntity.m_6084_())
/*  762 */                 return;  if (ownerEntity.m_9236_() != level) {
/*      */                 return;
/*      */               }
/*      */ 
/*      */               
/*  767 */               Vec3 target = origin.m_82549_(left.m_82490_(fdx)).m_82549_(worldUp.m_82490_(dy)).m_82549_(finalForward.m_82490_(fdz));
/*      */               
/*  769 */               BlockPos pos = BlockPos.m_274446_((Position)target);
/*  770 */               HerobrineUtil.placeIfReplaceable(level, pos, longPillarState, ownerEntity);
/*      */             }
/*      */           };
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void summonShadowObsidianLongPillarShootToward(ServerLevel level, Entity ownerEntity) {
/*  778 */     if (level == null || ownerEntity == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  783 */     BlockState baseState = (BlockState)((BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR.get()).m_49966_().m_61124_((Property)HerobrineObsidianBlock.FROM_PLAYER, Boolean.valueOf(ownerEntity instanceof net.minecraft.world.entity.player.Player))).m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)ownerEntity.m_6350_());
/*      */     
/*  785 */     Vec3[] lockedEye = { null };
/*  786 */     Basis[] lockedBasis = { null };
/*  787 */     Direction[] lockedFacing = { null };
/*      */     
/*  789 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 2, 1, 1, lockedEye, lockedBasis, lockedFacing);
/*  790 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 3, 2, 3, lockedEye, lockedBasis, lockedFacing);
/*  791 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 4, 4, 5, lockedEye, lockedBasis, lockedFacing);
/*  792 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 5, 6, 7, lockedEye, lockedBasis, lockedFacing);
/*  793 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 6, 8, 9, lockedEye, lockedBasis, lockedFacing);
/*  794 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 7, 10, 11, lockedEye, lockedBasis, lockedFacing);
/*  795 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 8, 12, 13, lockedEye, lockedBasis, lockedFacing);
/*  796 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 9, 14, 15, lockedEye, lockedBasis, lockedFacing);
/*  797 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 10, 16, 17, lockedEye, lockedBasis, lockedFacing);
/*  798 */     scheduleLocalEyesForwardLine(level, ownerEntity, baseState, 11, 18, 25, lockedEye, lockedBasis, lockedFacing);
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
/*      */   private static void scheduleLocalEyesForwardLine(final ServerLevel level, final Entity ownerEntity, final BlockState baseState, int delayTicks, final int zStart, final int zEnd, final Vec3[] lockedEye, final Basis[] lockedBasis, final Direction[] lockedFacing) {
/*  810 */     new DelayedTask(delayTicks) {
/*      */         public void run() {
/*  812 */           if (!ownerEntity.m_6084_())
/*  813 */             return;  if (ownerEntity.m_9236_() != level)
/*  814 */             return;  if (lockedEye[0] == null) {
/*  815 */             lockedEye[0] = ownerEntity.m_20299_(1.0F);
/*  816 */             lockedBasis[0] = HerobrineUtil.basisFromEntity(ownerEntity);
/*  817 */             lockedFacing[0] = ownerEntity.m_6350_();
/*      */           } 
/*      */           
/*  820 */           BlockState stateNow = baseState;
/*  821 */           if (stateNow.m_61138_((Property)BlockStateProperties.f_61374_) && lockedFacing[0] != null) {
/*  822 */             stateNow = (BlockState)stateNow.m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)lockedFacing[0]);
/*      */           }
/*      */           
/*  825 */           HerobrineUtil.Basis basis = lockedBasis[0];
/*  826 */           Vec3 eye = lockedEye[0];
/*      */           
/*  828 */           int from = Math.min(zStart, zEnd);
/*  829 */           int to = Math.max(zStart, zEnd);
/*      */           
/*  831 */           for (int z = from; z <= to; z++) {
/*      */ 
/*      */             
/*  834 */             Vec3 world = eye.m_82549_(basis.up().m_82490_(-1.0D)).m_82549_(basis.fwd().m_82490_(z));
/*      */             
/*  836 */             HerobrineUtil.placeIfReplaceable(level, BlockPos.m_274446_((Position)world), stateNow, ownerEntity);
/*      */           } 
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   public static void summonShadowObsidianLongPillarCircle(ServerLevel level, Entity ownerEntity, BlockPos centerPos) {
/*  843 */     if (level == null || ownerEntity == null || centerPos == null)
/*  844 */       return;  if (!ownerEntity.m_6084_())
/*  845 */       return;  if (ownerEntity.m_9236_() != level) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  850 */     BlockState longPillarState = (BlockState)((BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR.get()).m_49966_().m_61124_((Property)HerobrineObsidianBlock.FROM_PLAYER, Boolean.valueOf(ownerEntity instanceof net.minecraft.world.entity.player.Player))).m_61124_((Property)BlockStateProperties.f_61374_, (Comparable)ownerEntity.m_6350_());
/*      */     
/*  852 */     scheduleRing(level, ownerEntity, centerPos, longPillarState, 0, 6, 2.5D, 1.2566371F);
/*      */     
/*  854 */     scheduleRing(level, ownerEntity, centerPos, longPillarState, 2, 11, 3.5D, 0.62831855F);
/*      */     
/*  856 */     scheduleRing(level, ownerEntity, centerPos, longPillarState, 4, 14, 4.5D, 0.31415927F);
/*      */     
/*  858 */     scheduleRing(level, ownerEntity, centerPos, longPillarState, 6, 19, 5.5D, 0.25132743F);
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
/*      */   private static void scheduleRing(final ServerLevel level, final Entity ownerEntity, final BlockPos centerPos, final BlockState blockState, int delayTicks, final int points, final double radius, final float angleOffset) {
/*  871 */     new DelayedTask(delayTicks)
/*      */       {
/*      */         public void run() {
/*  874 */           if (!ownerEntity.m_6084_())
/*  875 */             return;  if (ownerEntity.m_9236_() != level)
/*      */             return; 
/*  877 */           int centerX = centerPos.m_123341_();
/*  878 */           int centerZ = centerPos.m_123343_();
/*      */           
/*  880 */           for (int k = 0; k < points; k++) {
/*  881 */             float angle = k * 6.2831855F / points + angleOffset;
/*      */             
/*  883 */             double worldX = centerX + Mth.m_14089_(angle) * radius;
/*  884 */             double worldZ = centerZ + Mth.m_14031_(angle) * radius;
/*      */             
/*  886 */             int x = Mth.m_14107_(worldX);
/*  887 */             int z = Mth.m_14107_(worldZ);
/*      */             
/*  889 */             int groundY = level.m_6924_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z) - 1;
/*      */             
/*  891 */             BlockPos placePos = new BlockPos(x, groundY, z);
/*  892 */             if (!level.m_8055_(placePos).m_247087_()) {
/*  893 */               placePos = placePos.m_7494_();
/*      */             }
/*      */             
/*  896 */             HerobrineUtil.placeIfReplaceable(level, placePos, blockState, ownerEntity);
/*      */           } 
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static ItemStack createRandomModdedEnchantedBook() {
/*  905 */     List<Enchantment> pool = BuiltInRegistries.f_256876_.m_123024_().filter(enchantment -> !enchantment.m_6589_()).toList();
/*      */     
/*  907 */     if (pool.isEmpty()) {
/*  908 */       return new ItemStack((ItemLike)Items.f_42690_);
/*      */     }
/*      */     
/*  911 */     Enchantment enchantment = pool.get((new Random()).nextInt(pool.size()));
/*  912 */     ItemStack book = new ItemStack((ItemLike)Items.f_42690_);
/*  913 */     EnchantedBookItem.m_41153_(book, new EnchantmentInstance(enchantment, (new Random()).nextInt(5, 10)));
/*  914 */     return book;
/*      */   }
/*      */   
/*      */   public static void dropNullLoot(LevelAccessor world, double x, double y, double z) {
/*  918 */     if (world instanceof Level) { Level level = (Level)world; if (!level.m_5776_()) {
/*      */         
/*  920 */         Item[] drops = { Items.f_42415_, Items.f_42415_, Items.f_42584_, Items.f_42522_, Items.f_42584_, Items.f_42584_, Items.f_42616_, Items.f_42690_, Items.f_42690_, Items.f_42690_, Items.f_42437_, Items.f_42418_, Items.f_42584_, Items.f_42437_, Items.f_42545_, Items.f_42710_ };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  930 */         for (Item item : drops) {
/*      */ 
/*      */           
/*  933 */           ItemStack stack = (item == Items.f_42690_) ? createRandomModdedEnchantedBook() : new ItemStack((ItemLike)item);
/*      */           
/*  935 */           ItemEntity entity = new ItemEntity(level, x, y, z, stack);
/*  936 */           entity.m_32010_(10);
/*  937 */           level.m_7967_((Entity)entity);
/*      */         } 
/*      */         return;
/*      */       }  }
/*      */   
/*  942 */   } public static void dropEliteHerobrineLoot(LevelAccessor world, double x, double y, double z, String fromElite) { if (world instanceof Level) { Level level = (Level)world; if (!level.m_5776_()) {
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
/*  953 */         Item[] items = { ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_5456_(), Items.f_42545_, Items.f_42545_, Items.f_42545_, ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), Items.f_42690_, Items.f_42690_, Items.f_42690_, Items.f_42413_ };
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  958 */         for (Item item : items) {
/*      */ 
/*      */           
/*  961 */           ItemStack stack = (item == Items.f_42690_) ? createRandomModdedEnchantedBook() : new ItemStack((ItemLike)item);
/*      */           
/*  963 */           ItemEntity entity = new ItemEntity(level, x, y, z, stack);
/*  964 */           entity.m_32010_(10);
/*  965 */           level.m_7967_((Entity)entity);
/*      */         } 
/*      */         
/*  968 */         ItemStack eliteDrop = ItemStack.f_41583_;
/*  969 */         switch (fromElite) { case "EnderGlaive":
/*  970 */             eliteDrop = new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_GLAIVE.get()); break;
/*  971 */           case "ObsidianSledgehammer": eliteDrop = new ItemStack((ItemLike)AnnoyingVillagersModItems.OBSIDIAN_SLEDGEHAMMER.get()); break;
/*  972 */           case "EnderSlayerScythe": eliteDrop = new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_SLAYER_SCYTHE.get()); break;
/*  973 */           case "EnderAegis": eliteDrop = new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_AEGIS.get()); break;
/*  974 */           case "DemoniacVoltageReaver": eliteDrop = new ItemStack((ItemLike)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER_HILT.get());
/*      */             break; }
/*      */         
/*  977 */         if (!eliteDrop.m_41619_()) {
/*  978 */           ItemEntity drop = new ItemEntity(level, x, y, z, eliteDrop);
/*  979 */           drop.m_32010_(10);
/*  980 */           level.m_7967_((Entity)drop);
/*      */         } 
/*      */         return;
/*      */       }  }
/*      */      }
/*  985 */   public static void dropShadowHerobrineLoot(LevelAccessor world, double x, double y, double z) { if (world instanceof Level) { Level level = (Level)world; if (!level.m_5776_()) {
/*  986 */         if (!world.m_5776_() && world.m_7654_() != null) {
/*  987 */           world.m_7654_().m_6846_().m_240416_(
/*  988 */               (Component)Component.m_237115_("subtitles.shadow_herobrine_die"), false);
/*      */         }
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
/*      */ 
/*      */         
/* 1008 */         Item[] items = { ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), Items.f_42545_, Items.f_42545_, Items.f_42545_, ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), Items.f_42690_, Items.f_42690_, Items.f_42690_, Items.f_42413_, (Item)AnnoyingVillagersModItems.ENCHANTED_ENDER_PEARL.get(), (Item)AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get() };
/*      */ 
/*      */         
/* 1011 */         for (Item item : items) {
/*      */ 
/*      */           
/* 1014 */           ItemStack stack = (item == Items.f_42690_) ? createRandomModdedEnchantedBook() : new ItemStack((ItemLike)item);
/*      */           
/* 1016 */           ItemEntity entity = new ItemEntity(level, x, y, z, stack);
/* 1017 */           entity.m_32010_(10);
/* 1018 */           level.m_7967_((Entity)entity);
/*      */         } 
/*      */         return;
/*      */       }  }
/*      */      }
/* 1023 */   public static void dropHerobrine7Loot(LevelAccessor world, double x, double y, double z) { if (world instanceof Level) { Level level = (Level)world; if (!level.m_5776_()) {
/* 1024 */         if (level.m_7654_() != null) {
/* 1025 */           level.m_7654_().m_6846_().m_240416_((Component)Component.m_237115_("subtitles.herobrine_clone_die"), false);
/*      */         }
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
/* 1038 */         Item[] items = { ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), Items.f_42545_, Items.f_42545_, Items.f_42545_, ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), Items.f_42690_, Items.f_42413_, (Item)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get(), (Item)AnnoyingVillagersModItems.ENCHANTED_ENDER_PEARL.get() };
/*      */ 
/*      */         
/* 1041 */         for (Item item : items) {
/*      */ 
/*      */           
/* 1044 */           ItemStack stack = (item == Items.f_42690_) ? createRandomModdedEnchantedBook() : new ItemStack((ItemLike)item);
/*      */           
/* 1046 */           ItemEntity entity = new ItemEntity(level, x, y, z, stack);
/* 1047 */           entity.m_32010_(10);
/* 1048 */           level.m_7967_((Entity)entity);
/*      */         } 
/*      */         return;
/*      */       }  }
/*      */      }
/* 1053 */   public static void dropLowHerobrineCloneLoot(LevelAccessor world, double x, double y, double z) { if (world instanceof Level) { Level level = (Level)world; if (!level.m_5776_()) {
/*      */         
/* 1055 */         Item[] items = { Items.f_42415_, Items.f_42415_, Items.f_42416_, Items.f_42616_, Items.f_42616_, Items.f_42616_, Items.f_42616_, Items.f_42418_, Items.f_42584_, Items.f_42436_ };
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1060 */         for (Item item : items) {
/* 1061 */           ItemEntity drop = new ItemEntity(level, x, y, z, new ItemStack((ItemLike)item));
/* 1062 */           drop.m_32010_(10);
/* 1063 */           level.m_7967_((Entity)drop);
/*      */         } 
/*      */         return;
/*      */       }  }
/*      */      }
/* 1068 */   public static void dropHerobrineCloneLoot(LevelAccessor world, double x, double y, double z) { if (world instanceof Level) { Level level = (Level)world; if (!level.m_5776_()) {
/* 1069 */         if (!world.m_5776_() && world.m_7654_() != null) {
/* 1070 */           world.m_7654_().m_6846_().m_240416_((Component)Component.m_237115_("subtitles.herobrine_clone_die"), false);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1077 */         Item[] items = { Items.f_42415_, Items.f_42415_, Items.f_42710_, Items.f_42416_, Items.f_42616_, Items.f_42616_, Items.f_42437_, Items.f_42418_, Items.f_42584_, Items.f_42437_, Items.f_42545_, Items.f_41996_, Items.f_41996_, Items.f_42690_, (Item)AnnoyingVillagersModItems.OBSIDIAN_WEAPON.get(), (Item)AnnoyingVillagersModItems.ENCHANTED_ENDER_PEARL.get() };
/*      */ 
/*      */         
/* 1080 */         for (Item item : items) {
/*      */ 
/*      */           
/* 1083 */           ItemStack stack = (item == Items.f_42690_) ? createRandomModdedEnchantedBook() : new ItemStack((ItemLike)item);
/*      */           
/* 1085 */           ItemEntity entity = new ItemEntity(level, x, y, z, stack);
/* 1086 */           entity.m_32010_(10);
/* 1087 */           level.m_7967_((Entity)entity);
/*      */         } 
/*      */         return;
/*      */       }  }
/*      */      } public static void dropHerobrineChrisLoot(LevelAccessor world, double x, double y, double z) {
/* 1092 */     if (world instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)world;
/*      */ 
/*      */       
/* 1095 */       Item[] items = { ((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_5456_(), (Item)AnnoyingVillagersModItems.BEDROCK_WEAPON.get(), ((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_5456_(), Blocks.f_50095_.m_5456_(), Blocks.f_50080_.m_5456_(), Blocks.f_50080_.m_5456_(), Items.f_42418_, Items.f_42584_, Items.f_42437_, Items.f_42545_, Items.f_42545_, (Item)AnnoyingVillagersModItems.ENCHANTED_ENDER_PEARL.get(), Items.f_42690_ };
/*      */ 
/*      */       
/* 1098 */       for (Item item : items) {
/*      */ 
/*      */         
/* 1101 */         ItemStack stack = (item == Items.f_42690_) ? createRandomModdedEnchantedBook() : new ItemStack((ItemLike)item);
/*      */         
/* 1103 */         ItemEntity entity = new ItemEntity((Level)serverLevel, x, y, z, stack);
/* 1104 */         entity.m_32010_(10);
/* 1105 */         serverLevel.m_7967_((Entity)entity);
/*      */       }  }
/*      */   
/*      */   }
/*      */   
/*      */   public static void dropArmoredHerobrineLoot(LevelAccessor world, double x, double y, double z) {
/* 1111 */     if (world instanceof Level) { Level level = (Level)world; if (!level.m_5776_()) {
/* 1112 */         if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 1113 */           serverLevel.m_7654_().m_6846_().m_240416_(
/* 1114 */               (Component)Component.m_237115_("subtitles.herobrine_clone_die"), false);
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
/*      */           
/* 1132 */           Item[] items = { ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_5456_(), Items.f_42545_, Items.f_42545_, Items.f_42736_, Items.f_42690_, Blocks.f_50090_.m_5456_(), Items.f_42383_, (Item)AnnoyingVillagersModItems.ENCHANTED_ENDER_PEARL.get(), (Item)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get(), (Item)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get() };
/*      */ 
/*      */           
/* 1135 */           for (Item item : items) {
/*      */ 
/*      */             
/* 1138 */             ItemStack stack = (item == Items.f_42690_) ? createRandomModdedEnchantedBook() : new ItemStack((ItemLike)item);
/*      */             
/* 1140 */             ItemEntity entity = new ItemEntity(level, x, y, z, stack);
/* 1141 */             entity.m_32010_(10);
/* 1142 */             serverLevel.m_7967_((Entity)entity);
/*      */           }  }
/*      */         
/*      */         return;
/*      */       }  }
/*      */      } public static void dropShadowHerobrineCloneLoot(LevelAccessor world, double x, double y, double z) {
/* 1148 */     if (world instanceof Level) { Level level = (Level)world; if (!level.m_5776_()) {
/* 1149 */         if (!world.m_5776_() && world.m_7654_() != null) {
/* 1150 */           world.m_7654_().m_6846_().m_240416_((Component)Component.m_237115_("subtitles.herobrine_clone_die"), false);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1159 */         Item[] drops = { Items.f_42415_, Items.f_42415_, Items.f_42710_, Items.f_42416_, Items.f_42616_, Items.f_42616_, Items.f_42437_, Items.f_42418_, Items.f_42584_, Items.f_42437_, Items.f_42545_, Items.f_41996_, Items.f_41996_, Items.f_42690_, (Item)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_WEAPON.get(), (Item)AnnoyingVillagersModItems.ENCHANTED_ENDER_PEARL.get() };
/*      */ 
/*      */         
/* 1162 */         for (Item item : drops) {
/*      */ 
/*      */           
/* 1165 */           ItemStack stack = (item == Items.f_42690_) ? createRandomModdedEnchantedBook() : new ItemStack((ItemLike)item);
/*      */           
/* 1167 */           ItemEntity entity = new ItemEntity(level, x, y, z, stack);
/* 1168 */           entity.m_32010_(10);
/* 1169 */           level.m_7967_((Entity)entity);
/*      */         } 
/*      */         return;
/*      */       }  }
/*      */   
/*      */   }
/*      */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\HerobrineUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */