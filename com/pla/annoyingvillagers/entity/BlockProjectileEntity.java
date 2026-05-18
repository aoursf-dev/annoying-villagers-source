/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.block.ObsidianBlock;
/*     */ import com.pla.annoyingvillagers.block.ShadowObsidianBlock;
/*     */ import com.pla.annoyingvillagers.block.ShadowObsidianLongPillarBlock;
/*     */ import com.pla.annoyingvillagers.blockentity.ObsidianBlockEntity;
/*     */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianBlockEntity;
/*     */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianLongPillarBlockEntity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.HolderGetter;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.NbtUtils;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.EntityDataSerializers;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.EntityDimensions;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Pose;
/*     */ import net.minecraft.world.entity.projectile.ThrowableProjectile;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.EntityHitResult;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockProjectileEntity
/*     */   extends ThrowableProjectile
/*     */ {
/*  42 */   private static final EntityDataAccessor<BlockState> DATA_BLOCK = SynchedEntityData.m_135353_(BlockProjectileEntity.class, EntityDataSerializers.f_135034_);
/*     */   
/*  44 */   private static final EntityDataAccessor<Float> ROT_X = SynchedEntityData.m_135353_(BlockProjectileEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  46 */   private static final EntityDataAccessor<Float> ROT_Y = SynchedEntityData.m_135353_(BlockProjectileEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  48 */   private static final EntityDataAccessor<Float> ROT_Z = SynchedEntityData.m_135353_(BlockProjectileEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*     */   private boolean notReadyForShoot = false;
/*     */   private UUID ownerUUID;
/*     */   
/*     */   public void setOwnerUUID(UUID ownerUUID) {
/*  54 */     this.ownerUUID = ownerUUID;
/*     */   }
/*     */   
/*     */   public void setNotReadyForShoot(boolean notReadyForShoot) {
/*  58 */     this.notReadyForShoot = notReadyForShoot;
/*     */   }
/*     */   
/*     */   public BlockProjectileEntity(EntityType<? extends BlockProjectileEntity> type, Level level) {
/*  62 */     super(type, level);
/*  63 */     initRandomRotation();
/*     */   }
/*     */   
/*     */   public BlockProjectileEntity(Level level, LivingEntity shooter, BlockState block) {
/*  67 */     super((EntityType)AnnoyingVillagersModEntities.BLOCK_PROJECTILE.get(), shooter, level);
/*  68 */     setCarriedBlock(block);
/*  69 */     initRandomRotation();
/*     */   }
/*     */   
/*  72 */   public void setRotX(float v) { this.f_19804_.m_135381_(ROT_X, Float.valueOf(v)); }
/*  73 */   public void setRotY(float v) { this.f_19804_.m_135381_(ROT_Y, Float.valueOf(v)); }
/*  74 */   public void setRotZ(float v) { this.f_19804_.m_135381_(ROT_Z, Float.valueOf(v)); }
/*  75 */   public float getRotX() { return ((Float)this.f_19804_.m_135370_(ROT_X)).floatValue(); }
/*  76 */   public float getRotY() { return ((Float)this.f_19804_.m_135370_(ROT_Y)).floatValue(); } public float getRotZ() {
/*  77 */     return ((Float)this.f_19804_.m_135370_(ROT_Z)).floatValue();
/*     */   }
/*     */   private void initRandomRotation() {
/*  80 */     if (!(m_9236_()).f_46443_) {
/*  81 */       RandomSource r = this.f_19796_;
/*  82 */       setRotX((r.m_188501_() - 0.5F) * 10.0F);
/*  83 */       setRotY((r.m_188501_() - 0.5F) * 10.0F);
/*  84 */       setRotZ((r.m_188501_() - 0.5F) * 10.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_8097_() {
/*  90 */     this.f_19804_.m_135372_(DATA_BLOCK, Blocks.f_50069_.m_49966_());
/*  91 */     this.f_19804_.m_135372_(ROT_X, Float.valueOf(0.0F));
/*  92 */     this.f_19804_.m_135372_(ROT_Y, Float.valueOf(0.0F));
/*  93 */     this.f_19804_.m_135372_(ROT_Z, Float.valueOf(0.0F));
/*     */   }
/*     */   
/*     */   public void setCarriedBlock(BlockState state) {
/*  97 */     this.f_19804_.m_135381_(DATA_BLOCK, state);
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
/*     */ 
/*     */   
/*     */   protected void m_5790_(@NotNull EntityHitResult result) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: invokespecial m_5790_ : (Lnet/minecraft/world/phys/EntityHitResult;)V
/*     */     //   5: aload_0
/*     */     //   6: getfield notReadyForShoot : Z
/*     */     //   9: ifeq -> 13
/*     */     //   12: return
/*     */     //   13: aload_1
/*     */     //   14: invokevirtual m_82443_ : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   17: astore_2
/*     */     //   18: aload_0
/*     */     //   19: getfield ownerUUID : Ljava/util/UUID;
/*     */     //   22: astore_3
/*     */     //   23: aload_2
/*     */     //   24: invokestatic isHerobrineFaction : (Lnet/minecraft/world/entity/Entity;)Z
/*     */     //   27: istore #4
/*     */     //   29: aload_3
/*     */     //   30: ifnonnull -> 38
/*     */     //   33: iload #4
/*     */     //   35: ifne -> 67
/*     */     //   38: aload_3
/*     */     //   39: ifnull -> 71
/*     */     //   42: aload_2
/*     */     //   43: instanceof net/minecraft/world/entity/player/Player
/*     */     //   46: ifeq -> 71
/*     */     //   49: aload_2
/*     */     //   50: checkcast net/minecraft/world/entity/player/Player
/*     */     //   53: astore #6
/*     */     //   55: aload #6
/*     */     //   57: invokevirtual m_20148_ : ()Ljava/util/UUID;
/*     */     //   60: aload_3
/*     */     //   61: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   64: ifeq -> 71
/*     */     //   67: iconst_1
/*     */     //   68: goto -> 72
/*     */     //   71: iconst_0
/*     */     //   72: istore #5
/*     */     //   74: iload #5
/*     */     //   76: ifeq -> 80
/*     */     //   79: return
/*     */     //   80: aload_2
/*     */     //   81: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   84: astore #7
/*     */     //   86: aload #7
/*     */     //   88: instanceof net/minecraft/server/level/ServerLevel
/*     */     //   91: ifeq -> 347
/*     */     //   94: aload #7
/*     */     //   96: checkcast net/minecraft/server/level/ServerLevel
/*     */     //   99: astore #6
/*     */     //   101: getstatic yesman/epicfight/particle/EpicFightParticles.HIT_BLUNT : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   104: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   107: checkcast yesman/epicfight/particle/HitParticleType
/*     */     //   110: aload #6
/*     */     //   112: getstatic yesman/epicfight/particle/HitParticleType.FRONT_OF_EYES : Ljava/util/function/BiFunction;
/*     */     //   115: getstatic yesman/epicfight/particle/HitParticleType.ZERO : Ljava/util/function/BiFunction;
/*     */     //   118: aload_0
/*     */     //   119: aload_2
/*     */     //   120: invokevirtual spawnParticleWithArgument : (Lnet/minecraft/server/level/ServerLevel;Ljava/util/function/BiFunction;Ljava/util/function/BiFunction;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;)V
/*     */     //   123: aload #6
/*     */     //   125: aconst_null
/*     */     //   126: aload_0
/*     */     //   127: invokevirtual m_20185_ : ()D
/*     */     //   130: aload_0
/*     */     //   131: invokevirtual m_20186_ : ()D
/*     */     //   134: aload_0
/*     */     //   135: invokevirtual m_20189_ : ()D
/*     */     //   138: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModSounds.OBSIDIAN_HIT : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   141: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   144: checkcast net/minecraft/sounds/SoundEvent
/*     */     //   147: getstatic net/minecraft/sounds/SoundSource.BLOCKS : Lnet/minecraft/sounds/SoundSource;
/*     */     //   150: fconst_1
/*     */     //   151: fconst_1
/*     */     //   152: invokevirtual m_6263_ : (Lnet/minecraft/world/entity/player/Player;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V
/*     */     //   155: fconst_2
/*     */     //   156: fstore #7
/*     */     //   158: aload_0
/*     */     //   159: invokevirtual getCarriedBlock : ()Lnet/minecraft/world/level/block/state/BlockState;
/*     */     //   162: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_SHORT_PILLAR : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   165: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   168: checkcast net/minecraft/world/level/block/Block
/*     */     //   171: invokevirtual m_60713_ : (Lnet/minecraft/world/level/block/Block;)Z
/*     */     //   174: ifne -> 215
/*     */     //   177: aload_0
/*     */     //   178: invokevirtual getCarriedBlock : ()Lnet/minecraft/world/level/block/state/BlockState;
/*     */     //   181: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   184: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   187: checkcast net/minecraft/world/level/block/Block
/*     */     //   190: invokevirtual m_60713_ : (Lnet/minecraft/world/level/block/Block;)Z
/*     */     //   193: ifne -> 215
/*     */     //   196: aload_0
/*     */     //   197: invokevirtual getCarriedBlock : ()Lnet/minecraft/world/level/block/state/BlockState;
/*     */     //   200: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   203: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   206: checkcast net/minecraft/world/level/block/Block
/*     */     //   209: invokevirtual m_60713_ : (Lnet/minecraft/world/level/block/Block;)Z
/*     */     //   212: ifeq -> 219
/*     */     //   215: ldc 10.0
/*     */     //   217: fstore #7
/*     */     //   219: aload_0
/*     */     //   220: invokevirtual m_19749_ : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   223: ifnonnull -> 246
/*     */     //   226: aload_2
/*     */     //   227: aload_2
/*     */     //   228: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   231: invokevirtual m_269111_ : ()Lnet/minecraft/world/damagesource/DamageSources;
/*     */     //   234: invokevirtual m_269264_ : ()Lnet/minecraft/world/damagesource/DamageSource;
/*     */     //   237: fload #7
/*     */     //   239: invokevirtual m_6469_ : (Lnet/minecraft/world/damagesource/DamageSource;F)Z
/*     */     //   242: pop
/*     */     //   243: goto -> 268
/*     */     //   246: aload_2
/*     */     //   247: aload_2
/*     */     //   248: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   251: invokevirtual m_269111_ : ()Lnet/minecraft/world/damagesource/DamageSources;
/*     */     //   254: aload_0
/*     */     //   255: aload_0
/*     */     //   256: invokevirtual m_19749_ : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   259: invokevirtual m_269104_ : (Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;)Lnet/minecraft/world/damagesource/DamageSource;
/*     */     //   262: fload #7
/*     */     //   264: invokevirtual m_6469_ : (Lnet/minecraft/world/damagesource/DamageSource;F)Z
/*     */     //   267: pop
/*     */     //   268: aload_2
/*     */     //   269: ldc_w yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*     */     //   272: invokestatic getEntityPatch : (Lnet/minecraft/world/entity/Entity;Ljava/lang/Class;)Lyesman/epicfight/world/capabilities/entitypatch/EntityPatch;
/*     */     //   275: checkcast yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*     */     //   278: astore #8
/*     */     //   280: aload #8
/*     */     //   282: ifnull -> 297
/*     */     //   285: aload #8
/*     */     //   287: getstatic yesman/epicfight/world/damagesource/StunType.LONG : Lyesman/epicfight/world/damagesource/StunType;
/*     */     //   290: ldc_w 20.0
/*     */     //   293: invokevirtual applyStun : (Lyesman/epicfight/world/damagesource/StunType;F)Z
/*     */     //   296: pop
/*     */     //   297: aload_2
/*     */     //   298: instanceof net/minecraft/world/entity/LivingEntity
/*     */     //   301: ifeq -> 347
/*     */     //   304: aload_2
/*     */     //   305: checkcast net/minecraft/world/entity/LivingEntity
/*     */     //   308: astore #9
/*     */     //   310: fconst_1
/*     */     //   311: fstore #10
/*     */     //   313: aload_0
/*     */     //   314: invokevirtual m_20185_ : ()D
/*     */     //   317: aload_2
/*     */     //   318: invokevirtual m_20185_ : ()D
/*     */     //   321: dsub
/*     */     //   322: dstore #11
/*     */     //   324: aload_0
/*     */     //   325: invokevirtual m_20189_ : ()D
/*     */     //   328: aload_2
/*     */     //   329: invokevirtual m_20189_ : ()D
/*     */     //   332: dsub
/*     */     //   333: dstore #13
/*     */     //   335: aload #9
/*     */     //   337: fload #10
/*     */     //   339: f2d
/*     */     //   340: dload #11
/*     */     //   342: dload #13
/*     */     //   344: invokevirtual m_147240_ : (DDD)V
/*     */     //   347: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #102	-> 0
/*     */     //   #103	-> 5
/*     */     //   #104	-> 13
/*     */     //   #105	-> 18
/*     */     //   #106	-> 23
/*     */     //   #110	-> 29
/*     */     //   #111	-> 57
/*     */     //   #113	-> 74
/*     */     //   #115	-> 80
/*     */     //   #116	-> 101
/*     */     //   #117	-> 123
/*     */     //   #119	-> 127
/*     */     //   #120	-> 141
/*     */     //   #117	-> 152
/*     */     //   #125	-> 155
/*     */     //   #126	-> 158
/*     */     //   #127	-> 178
/*     */     //   #128	-> 197
/*     */     //   #129	-> 215
/*     */     //   #131	-> 219
/*     */     //   #132	-> 226
/*     */     //   #134	-> 246
/*     */     //   #137	-> 268
/*     */     //   #138	-> 280
/*     */     //   #139	-> 285
/*     */     //   #142	-> 297
/*     */     //   #143	-> 310
/*     */     //   #144	-> 313
/*     */     //   #145	-> 324
/*     */     //   #146	-> 335
/*     */     //   #149	-> 347
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   55	12	6	p	Lnet/minecraft/world/entity/player/Player;
/*     */     //   313	34	10	strength	F
/*     */     //   324	23	11	dx	D
/*     */     //   335	12	13	dz	D
/*     */     //   310	37	9	livingEntity	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   158	189	7	damage	F
/*     */     //   280	67	8	livingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;
/*     */     //   101	246	6	serverLevel	Lnet/minecraft/server/level/ServerLevel;
/*     */     //   0	348	0	this	Lcom/pla/annoyingvillagers/entity/BlockProjectileEntity;
/*     */     //   0	348	1	result	Lnet/minecraft/world/phys/EntityHitResult;
/*     */     //   18	330	2	target	Lnet/minecraft/world/entity/Entity;
/*     */     //   23	325	3	ownerId	Ljava/util/UUID;
/*     */     //   29	319	4	isHerobrine	Z
/*     */     //   74	274	5	blockDamage	Z
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   280	67	8	livingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch<*>;
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
/*     */ 
/*     */   
/*     */   protected void m_8060_(@NotNull BlockHitResult result) {
/* 153 */     if (this.notReadyForShoot)
/* 154 */       return;  BlockPos pos = result.m_82425_();
/* 155 */     BlockState hitState = m_9236_().m_8055_(pos);
/*     */     
/* 157 */     if (!(m_9236_()).f_46443_) {
/* 158 */       if (!hitState.m_60819_().m_76178_()) {
/*     */         return;
/*     */       }
/*     */       
/* 162 */       if (hitState.m_247087_()) {
/*     */         return;
/*     */       }
/*     */       
/* 166 */       BlockPos placePos = pos.m_121945_(result.m_82434_());
/* 167 */       if (m_9236_().m_8055_(placePos).m_60795_() || 
/* 168 */         !m_9236_().m_6425_(placePos).m_76178_() || 
/* 169 */         m_9236_().m_8055_(placePos).m_247087_()) {
/* 170 */         BlockState placeState; UUID owner = this.ownerUUID;
/*     */ 
/*     */         
/* 173 */         if (getCarriedBlock().m_60713_((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_SHORT_PILLAR.get()) || 
/* 174 */           getCarriedBlock().m_60713_((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_MIDDLE_PILLAR.get())) {
/* 175 */           placeState = ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_LONG_PILLAR.get()).m_49966_();
/* 176 */           if (owner != null && placeState.m_61138_((Property)ShadowObsidianLongPillarBlock.FROM_PLAYER)) {
/* 177 */             placeState = (BlockState)placeState.m_61124_((Property)ShadowObsidianLongPillarBlock.FROM_PLAYER, Boolean.valueOf(true));
/*     */           }
/* 179 */         } else if (getCarriedBlock().m_60713_((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get())) {
/* 180 */           placeState = ((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_();
/* 181 */           if (owner != null && placeState.m_61138_((Property)ShadowObsidianBlock.FROM_PLAYER)) {
/* 182 */             placeState = (BlockState)placeState.m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(true));
/*     */           }
/* 184 */         } else if (getCarriedBlock().m_60713_((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get())) {
/* 185 */           placeState = ((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_();
/* 186 */           if (owner != null && placeState.m_61138_((Property)ObsidianBlock.FROM_PLAYER)) {
/* 187 */             placeState = (BlockState)placeState.m_61124_((Property)ObsidianBlock.FROM_PLAYER, Boolean.valueOf(true));
/*     */           }
/*     */         } else {
/* 190 */           placeState = getCarriedBlock();
/*     */         } 
/*     */         
/* 193 */         m_9236_().m_46597_(placePos, placeState);
/* 194 */         BlockEntity blockEntity = m_9236_().m_7702_(placePos);
/* 195 */         if (owner != null) {
/* 196 */           if (blockEntity instanceof ObsidianBlockEntity) { ObsidianBlockEntity obsidianBlockEntity = (ObsidianBlockEntity)blockEntity;
/* 197 */             obsidianBlockEntity.setOwner(owner);
/* 198 */             blockEntity.m_6596_(); }
/* 199 */           else if (blockEntity instanceof ShadowObsidianBlockEntity) { ShadowObsidianBlockEntity shadowObsidianBlockEntity = (ShadowObsidianBlockEntity)blockEntity;
/* 200 */             shadowObsidianBlockEntity.setOwner(owner);
/* 201 */             blockEntity.m_6596_(); }
/* 202 */           else if (blockEntity instanceof ShadowObsidianLongPillarBlockEntity) { ShadowObsidianLongPillarBlockEntity shadowObsidianLongPillarBlockEntity = (ShadowObsidianLongPillarBlockEntity)blockEntity;
/* 203 */             shadowObsidianLongPillarBlockEntity.setOwner(owner);
/* 204 */             blockEntity.m_6596_(); }
/*     */         
/*     */         }
/*     */       } 
/* 208 */       m_146870_();
/*     */     } 
/*     */   }
/*     */   
/*     */   public BlockState getCarriedBlock() {
/* 213 */     return (BlockState)this.f_19804_.m_135370_(DATA_BLOCK);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7380_(CompoundTag tag) {
/* 218 */     tag.m_128365_("Block", (Tag)NbtUtils.m_129202_(getCarriedBlock()));
/* 219 */     tag.m_128350_("RotX", getRotX());
/* 220 */     tag.m_128350_("RotY", getRotY());
/* 221 */     tag.m_128350_("RotZ", getRotZ());
/* 222 */     tag.m_128379_("NotReadyForShoot", this.notReadyForShoot);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7378_(CompoundTag tag) {
/* 227 */     if (tag.m_128441_("Block")) {
/* 228 */       setCarriedBlock(NbtUtils.m_247651_((HolderGetter)BuiltInRegistries.f_256975_.m_255303_(), tag.m_128469_("Block")));
/*     */     }
/* 230 */     setRotX(tag.m_128441_("RotX") ? tag.m_128457_("RotX") : 0.0F);
/* 231 */     setRotY(tag.m_128441_("RotY") ? tag.m_128457_("RotY") : 0.0F);
/* 232 */     setRotZ(tag.m_128441_("RotZ") ? tag.m_128457_("RotZ") : 0.0F);
/* 233 */     this.notReadyForShoot = tag.m_128471_("NotReadyForShoot");
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public EntityDimensions m_6972_(@NotNull Pose pose) {
/* 238 */     return EntityDimensions.m_20398_(0.9F, 0.9F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float m_7139_() {
/* 243 */     return 0.005F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\BlockProjectileEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */