/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.HashSet;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.HolderGetter;
/*     */ import net.minecraft.core.registries.Registries;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.nbt.NbtUtils;
/*     */ import net.minecraft.nbt.Tag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.EntityDataSerializers;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.MoverType;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class ShockWaveBlockEntity
/*     */   extends Entity {
/*     */   private static final int HARD_DESPAWN_TICKS = 300;
/*     */   private static final double MAX_VISIBLE_ABOVE_GROUND = 0.3333333333333333D;
/*     */   private static final double START_BELOW_SURFACE_EPS = 0.02D;
/*     */   private static final double GRAVITY = 0.04D;
/*     */   private static final double DRAG = 0.98D;
/*     */   private static final double TARGET_RISE = 0.35333333333333333D;
/*  50 */   private static final double INITIAL_UPWARD_VELOCITY = Math.sqrt(0.028266666666666666D);
/*     */   
/*     */   private static final double HITBOX_INFLATE = 0.05D;
/*     */   
/*     */   private static final float DAMAGE = 2.0F;
/*     */   private static final double KNOCKBACK = 0.6D;
/*     */   private static final double KNOCKUP = 0.15D;
/*     */   @Nullable
/*     */   private UUID ownerUuid;
/*  59 */   private final Set<UUID> hitOnce = new HashSet<>();
/*     */ 
/*     */   
/*  62 */   private static final EntityDataAccessor<BlockPos> SOURCE_BLOCK_POS = SynchedEntityData.m_135353_(ShockWaveBlockEntity.class, EntityDataSerializers.f_135038_);
/*     */ 
/*     */   
/*  65 */   private static final EntityDataAccessor<BlockState> RENDER_BLOCK_STATE = SynchedEntityData.m_135353_(ShockWaveBlockEntity.class, EntityDataSerializers.f_135034_);
/*     */   
/*  67 */   private int lifetimeTicks = 10;
/*     */   
/*     */   public ShockWaveBlockEntity(EntityType<? extends ShockWaveBlockEntity> entityType, Level level) {
/*  70 */     super(entityType, level);
/*  71 */     this.f_19794_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ShockWaveBlockEntity(Level level, double x, double surfaceY, double z, BlockState blockState, int lifetimeTicks) {
/*  76 */     this((EntityType<? extends ShockWaveBlockEntity>)AnnoyingVillagersModEntities.SHOCKWAVE_BLOCK.get(), level);
/*     */     
/*  78 */     setBlockState(blockState);
/*  79 */     this.lifetimeTicks = Math.max(1, lifetimeTicks);
/*     */     
/*  81 */     BlockPos sourcePos = BlockPos.m_274561_(x, surfaceY - 1.0D, z);
/*  82 */     setSourceBlockPos(sourcePos);
/*  83 */     double startBottomY = sourcePos.m_123342_() + 1.0D - 1.02D;
/*     */     
/*  85 */     m_6034_(x, startBottomY, z);
/*  86 */     m_20334_(0.0D, INITIAL_UPWARD_VELOCITY, 0.0D);
/*     */     
/*  88 */     this.f_19854_ = x;
/*  89 */     this.f_19855_ = startBottomY;
/*  90 */     this.f_19856_ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_8097_() {
/*  95 */     this.f_19804_.m_135372_(SOURCE_BLOCK_POS, BlockPos.f_121853_);
/*  96 */     this.f_19804_.m_135372_(RENDER_BLOCK_STATE, Blocks.f_50016_.m_49966_());
/*     */   }
/*     */   
/*     */   public BlockPos getSourceBlockPos() {
/* 100 */     return (BlockPos)this.f_19804_.m_135370_(SOURCE_BLOCK_POS);
/*     */   }
/*     */   
/*     */   public void setSourceBlockPos(BlockPos pos) {
/* 104 */     this.f_19804_.m_135381_(SOURCE_BLOCK_POS, pos);
/*     */   }
/*     */   
/*     */   public BlockState getBlockState() {
/* 108 */     return (BlockState)this.f_19804_.m_135370_(RENDER_BLOCK_STATE);
/*     */   }
/*     */   
/*     */   public void setBlockState(BlockState blockState) {
/* 112 */     this.f_19804_.m_135381_(RENDER_BLOCK_STATE, blockState);
/*     */   }
/*     */   
/*     */   public void setOwnerUuid(@Nullable UUID ownerUuid) {
/* 116 */     this.ownerUuid = ownerUuid;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 121 */     super.m_8119_();
/*     */     
/* 123 */     if (this.f_19797_ > this.lifetimeTicks || this.f_19797_ > 300) {
/* 124 */       m_146870_();
/*     */       
/*     */       return;
/*     */     } 
/* 128 */     if (!m_20068_()) {
/* 129 */       Vec3 motion = m_20184_();
/* 130 */       m_20334_(motion.f_82479_, motion.f_82480_ - 0.04D, motion.f_82481_);
/*     */     } 
/*     */     
/* 133 */     m_6478_(MoverType.SELF, m_20184_());
/* 134 */     m_20256_(m_20184_().m_82490_(0.98D));
/* 135 */     double maxBottomY = getSourceBlockPos().m_123342_() + 0.3333333333333333D;
/* 136 */     if (m_20186_() > maxBottomY) {
/* 137 */       m_6034_(m_20185_(), maxBottomY, m_20189_());
/*     */       
/* 139 */       Vec3 motion = m_20184_();
/* 140 */       if (motion.f_82480_ > 0.0D) {
/* 141 */         m_20334_(motion.f_82479_, 0.0D, motion.f_82481_);
/*     */       }
/*     */     } 
/*     */     
/* 145 */     if (!(m_9236_()).f_46443_) {
/* 146 */       handleEntityHits();
/*     */     }
/*     */   }
/*     */   
/*     */   private void handleEntityHits() {
/* 151 */     AABB hitBox = m_20191_().m_82377_(0.05D, 0.0D, 0.05D);
/*     */     
/* 153 */     for (LivingEntity target : m_9236_().m_6443_(LivingEntity.class, hitBox, this::canHitTarget)) {
/* 154 */       if (!this.hitOnce.add(target.m_20148_())) {
/*     */         continue;
/*     */       }
/* 157 */       onHitLivingEntity(target);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean canHitTarget(LivingEntity target) {
/* 162 */     if (!target.m_6084_()) return false; 
/* 163 */     if (target.m_5833_()) return false; 
/* 164 */     return (this.ownerUuid == null || !this.ownerUuid.equals(target.m_20148_()));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private Entity getOwnerEntity() {
/* 169 */     if (this.ownerUuid == null) return null; 
/* 170 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 171 */       return serverLevel.m_8791_(this.ownerUuid); }
/*     */     
/* 173 */     return null;
/*     */   }
/*     */   
/*     */   private DamageSource getShockwaveDamageSource() {
/* 177 */     Entity owner = getOwnerEntity();
/*     */     
/* 179 */     if (owner instanceof Player) { Player player = (Player)owner;
/* 180 */       return m_9236_().m_269111_().m_269075_(player); }
/*     */     
/* 182 */     if (owner instanceof LivingEntity) { LivingEntity living = (LivingEntity)owner;
/* 183 */       return m_9236_().m_269111_().m_269333_(living); }
/*     */     
/* 185 */     return m_9236_().m_269111_().m_269264_();
/*     */   }
/*     */   
/*     */   private void onHitLivingEntity(LivingEntity target) {
/* 189 */     DamageSource source = getShockwaveDamageSource();
/*     */     
/* 191 */     target.m_6469_(source, 2.0F);
/* 192 */     LivingEntityPatch<?> targetPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)target, LivingEntityPatch.class);
/* 193 */     if (targetPatch != null) {
/* 194 */       AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(targetPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 195 */       if (dynamicAnimation != null && !EpicfightUtil.isLongHitAnimation(dynamicAnimation, targetPatch)) {
/* 196 */         targetPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.TRIED, 0.0F);
/*     */       }
/*     */     } 
/* 199 */     Vec3 dir = target.m_20182_().m_82546_(m_20182_());
/* 200 */     Vec3 horizontal = new Vec3(dir.f_82479_, 0.0D, dir.f_82481_);
/*     */     
/* 202 */     if (horizontal.m_82556_() < 1.0E-6D) {
/* 203 */       horizontal = new Vec3(this.f_19796_.m_188583_(), 0.0D, this.f_19796_.m_188583_());
/*     */     }
/*     */     
/* 206 */     Vec3 push = horizontal.m_82541_().m_82490_(0.6D);
/* 207 */     target.m_5997_(push.f_82479_, 0.15D, push.f_82481_);
/* 208 */     target.f_19864_ = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7380_(CompoundTag tag) {
/* 213 */     tag.m_128365_("BlockState", (Tag)NbtUtils.m_129202_(getBlockState()));
/* 214 */     tag.m_128365_("SourceBlockPos", (Tag)NbtUtils.m_129224_(getSourceBlockPos()));
/* 215 */     tag.m_128405_("LifetimeTicks", this.lifetimeTicks);
/* 216 */     if (this.ownerUuid != null) {
/* 217 */       tag.m_128362_("Owner", this.ownerUuid);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7378_(CompoundTag tag) {
/* 223 */     setBlockState(NbtUtils.m_247651_((HolderGetter)
/* 224 */           m_9236_().m_246945_(Registries.f_256747_), tag
/* 225 */           .m_128469_("BlockState")));
/*     */     
/* 227 */     setSourceBlockPos(NbtUtils.m_129239_(tag.m_128469_("SourceBlockPos")));
/* 228 */     this.lifetimeTicks = Math.max(1, tag.m_128451_("LifetimeTicks"));
/* 229 */     this.ownerUuid = tag.m_128403_("Owner") ? tag.m_128342_("Owner") : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6051_() {
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 239 */     return NetworkHooks.getEntitySpawningPacket(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ShockWaveBlockEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */