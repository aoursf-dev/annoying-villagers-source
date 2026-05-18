/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModMobEffects;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.AAAParticlesUtil;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.EntityDataSerializers;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.ClipContext;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.material.PushReaction;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.HitResult;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.api.utils.math.Vec3f;
/*     */ import yesman.epicfight.gameasset.Armatures;
/*     */ import yesman.epicfight.model.armature.HumanoidArmature;
/*     */ 
/*     */ 
/*     */ public class BlueDemonThunderBeamEntity
/*     */   extends Entity
/*     */ {
/*     */   public LivingEntity caster;
/*     */   public double collidePosX;
/*     */   public double collidePosY;
/*     */   public double collidePosZ;
/*     */   public double prevCollidePosX;
/*     */   public double prevCollidePosY;
/*     */   public double prevCollidePosZ;
/*     */   public boolean on = true;
/*     */   public Direction blockSide;
/*     */   private int power;
/*  54 */   private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135028_);
/*     */   
/*  56 */   private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135028_);
/*     */ 
/*     */   
/*  59 */   private static final EntityDataAccessor<Float> START_X = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  61 */   private static final EntityDataAccessor<Float> START_Y = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  63 */   private static final EntityDataAccessor<Float> START_Z = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */ 
/*     */   
/*  66 */   private static final EntityDataAccessor<Float> END_X = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  68 */   private static final EntityDataAccessor<Float> END_Y = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  70 */   private static final EntityDataAccessor<Float> END_Z = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */ 
/*     */   
/*  73 */   private static final EntityDataAccessor<Float> BEAM_LEN = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */ 
/*     */   
/*  76 */   private static final EntityDataAccessor<Float> LAST_DIR_X = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  78 */   private static final EntityDataAccessor<Float> LAST_DIR_Z = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135029_);
/*     */   
/*  80 */   private static final EntityDataAccessor<Boolean> USE_NO_VFX_THUNDER = SynchedEntityData.m_135353_(BlueDemonThunderBeamEntity.class, EntityDataSerializers.f_135035_);
/*     */   
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   private Vec3[] attractorPos;
/*     */   
/*     */   private boolean renderBeam = false;
/*     */   private boolean playSound = false;
/*     */   
/*     */   public BlueDemonThunderBeamEntity(EntityType<? extends BlueDemonThunderBeamEntity> type, Level level) {
/*  89 */     super(type, level);
/*  90 */     this.f_19811_ = true;
/*  91 */     if (level.f_46443_) this.attractorPos = new Vec3[] { Vec3.f_82478_ };
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlueDemonThunderBeamEntity(EntityType<? extends BlueDemonThunderBeamEntity> type, Level level, LivingEntity caster, int duration, int power, double beamLength) {
/* 100 */     this(type, level);
/* 101 */     this.caster = caster;
/* 102 */     setDuration(duration);
/* 103 */     setPower(power);
/* 104 */     setBeamLength((float)beamLength);
/*     */     
/* 106 */     this.f_19804_.m_135381_(LAST_DIR_X, Float.valueOf(1.0F));
/* 107 */     this.f_19804_.m_135381_(LAST_DIR_Z, Float.valueOf(0.0F));
/*     */     
/* 109 */     if (!level.f_46443_ && caster != null) {
/* 110 */       setCasterID(caster.m_19879_());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_8097_() {
/* 116 */     this.f_19804_.m_135372_(DURATION, Integer.valueOf(0));
/* 117 */     this.f_19804_.m_135372_(CASTER, Integer.valueOf(-1));
/*     */     
/* 119 */     this.f_19804_.m_135372_(START_X, Float.valueOf(0.0F));
/* 120 */     this.f_19804_.m_135372_(START_Y, Float.valueOf(0.0F));
/* 121 */     this.f_19804_.m_135372_(START_Z, Float.valueOf(0.0F));
/*     */     
/* 123 */     this.f_19804_.m_135372_(END_X, Float.valueOf(0.0F));
/* 124 */     this.f_19804_.m_135372_(END_Y, Float.valueOf(0.0F));
/* 125 */     this.f_19804_.m_135372_(END_Z, Float.valueOf(0.0F));
/*     */     
/* 127 */     this.f_19804_.m_135372_(BEAM_LEN, Float.valueOf(7.5F));
/*     */     
/* 129 */     this.f_19804_.m_135372_(LAST_DIR_X, Float.valueOf(1.0F));
/* 130 */     this.f_19804_.m_135372_(LAST_DIR_Z, Float.valueOf(0.0F));
/*     */     
/* 132 */     this.f_19804_.m_135372_(USE_NO_VFX_THUNDER, Boolean.valueOf(false));
/*     */   }
/*     */   protected void m_7378_(@NotNull CompoundTag tag) {}
/*     */   
/*     */   protected void m_7380_(@NotNull CompoundTag tag) {}
/*     */   
/*     */   public void setUseNoVfxThunder(boolean noVfxThunder) {
/* 139 */     this.f_19804_.m_135381_(USE_NO_VFX_THUNDER, Boolean.valueOf(noVfxThunder));
/*     */   }
/*     */   
/*     */   public boolean isSetUseNoVfxThunder() {
/* 143 */     return ((Boolean)this.f_19804_.m_135370_(USE_NO_VFX_THUNDER)).booleanValue();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 148 */     return NetworkHooks.getEntitySpawningPacket(this);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public PushReaction m_7752_() {
/* 153 */     return PushReaction.IGNORE;
/*     */   }
/*     */   
/* 156 */   public int getDuration() { return ((Integer)this.f_19804_.m_135370_(DURATION)).intValue(); } public void setDuration(int duration) {
/* 157 */     this.f_19804_.m_135381_(DURATION, Integer.valueOf(duration));
/*     */   }
/* 159 */   public int getCasterID() { return ((Integer)this.f_19804_.m_135370_(CASTER)).intValue(); } public void setCasterID(int id) {
/* 160 */     this.f_19804_.m_135381_(CASTER, Integer.valueOf(id));
/*     */   } public void setPower(int power) {
/* 162 */     this.power = power;
/*     */   }
/* 164 */   public float getBeamLength() { return ((Float)this.f_19804_.m_135370_(BEAM_LEN)).floatValue(); } public void setBeamLength(float len) {
/* 165 */     this.f_19804_.m_135381_(BEAM_LEN, Float.valueOf(len));
/*     */   }
/*     */   public Vec3 getStartPos() {
/* 168 */     return new Vec3(((Float)this.f_19804_.m_135370_(START_X)).floatValue(), ((Float)this.f_19804_.m_135370_(START_Y)).floatValue(), ((Float)this.f_19804_.m_135370_(START_Z)).floatValue());
/*     */   }
/*     */   
/*     */   public Vec3 getEndPos() {
/* 172 */     return new Vec3(((Float)this.f_19804_.m_135370_(END_X)).floatValue(), ((Float)this.f_19804_.m_135370_(END_Y)).floatValue(), ((Float)this.f_19804_.m_135370_(END_Z)).floatValue());
/*     */   }
/*     */   
/*     */   private void setStartPos(Vec3 pos) {
/* 176 */     this.f_19804_.m_135381_(START_X, Float.valueOf((float)pos.f_82479_));
/* 177 */     this.f_19804_.m_135381_(START_Y, Float.valueOf((float)pos.f_82480_));
/* 178 */     this.f_19804_.m_135381_(START_Z, Float.valueOf((float)pos.f_82481_));
/*     */   }
/*     */   
/*     */   private void setEndPos(Vec3 pos) {
/* 182 */     this.f_19804_.m_135381_(END_X, Float.valueOf((float)pos.f_82479_));
/* 183 */     this.f_19804_.m_135381_(END_Y, Float.valueOf((float)pos.f_82480_));
/* 184 */     this.f_19804_.m_135381_(END_Z, Float.valueOf((float)pos.f_82481_));
/*     */   }
/*     */   
/*     */   private Vec3 getLastDirXZ() {
/* 188 */     Vec3 d = new Vec3(((Float)this.f_19804_.m_135370_(LAST_DIR_X)).floatValue(), 0.0D, ((Float)this.f_19804_.m_135370_(LAST_DIR_Z)).floatValue());
/* 189 */     return (d.m_82556_() < 1.0E-8D) ? new Vec3(1.0D, 0.0D, 0.0D) : d.m_82541_();
/*     */   }
/*     */   
/*     */   private void setLastDirXZ(Vec3 dir) {
/* 193 */     this.f_19804_.m_135381_(LAST_DIR_X, Float.valueOf((float)dir.f_82479_));
/* 194 */     this.f_19804_.m_135381_(LAST_DIR_Z, Float.valueOf((float)dir.f_82481_));
/*     */   }
/*     */   
/*     */   public void initSpawnState() {
/* 198 */     if (this.caster == null)
/*     */       return; 
/* 200 */     Vec3 fallbackStart = this.caster.m_20182_().m_82520_(0.0D, this.caster.m_20192_() * 0.8D, 0.0D);
/* 201 */     Vec3 fallbackEnd = fallbackStart.m_82549_(this.caster.m_20154_().m_82490_(getBeamLength()));
/*     */     
/* 203 */     setStartPos(fallbackStart);
/* 204 */     setEndPos(fallbackEnd);
/* 205 */     m_7678_(fallbackStart.f_82479_, fallbackStart.f_82480_, fallbackStart.f_82481_, this.caster.m_146908_(), this.caster.m_146909_());
/*     */   }
/*     */   
/*     */   private void updateBeamFromHands() {
/* 209 */     if (this.caster == null)
/*     */       return; 
/* 211 */     Vec3 handLeft = EpicfightUtil.getJointWithTranslation((Entity)this.caster, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED
/* 212 */         .get()).handL, 0.0F, 0.0D);
/*     */     
/* 214 */     Vec3 handRight = EpicfightUtil.getJointWithTranslation((Entity)this.caster, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED
/* 215 */         .get()).handR, 0.0F, 0.0D);
/*     */ 
/*     */     
/* 218 */     if (handLeft == null || handRight == null)
/* 219 */       return;  Vec3 horizontal = handRight.m_82546_(handLeft);
/* 220 */     horizontal = new Vec3(horizontal.f_82479_, 0.0D, horizontal.f_82481_);
/*     */     
/* 222 */     if (horizontal.m_82556_() < 1.0E-6D) {
/* 223 */       horizontal = getLastDirXZ();
/*     */     } else {
/* 225 */       horizontal = horizontal.m_82541_();
/* 226 */       setLastDirXZ(horizontal);
/*     */     } 
/*     */     
/* 229 */     double lookY = (this.caster.m_20154_()).f_82480_;
/* 230 */     Vec3 dir = (new Vec3(horizontal.f_82479_, lookY, horizontal.f_82481_)).m_82541_();
/*     */     
/* 232 */     double len = getBeamLength();
/* 233 */     Vec3 end = handRight.m_82549_(dir.m_82490_(len));
/*     */     
/* 235 */     setStartPos(handRight);
/* 236 */     setEndPos(end);
/* 237 */     m_6034_(handRight.f_82479_, handRight.f_82480_, handRight.f_82481_);
/*     */   }
/*     */   public BlueDemonThunderBeamHitResult raytraceEntities(Level world, Vec3 from, Vec3 to) {
/*     */     Vec3 actualTo;
/* 241 */     BlueDemonThunderBeamHitResult result = new BlueDemonThunderBeamHitResult();
/*     */     
/* 243 */     BlockHitResult blockHit = world.m_45547_(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
/* 244 */     result.setBlockHit((HitResult)blockHit);
/*     */ 
/*     */     
/* 247 */     if (result.blockHit != null) {
/* 248 */       actualTo = result.blockHit.m_82450_();
/* 249 */       this.blockSide = result.blockHit.m_82434_();
/*     */     } else {
/* 251 */       actualTo = to;
/* 252 */       this.blockSide = null;
/*     */     } 
/*     */     
/* 255 */     this.collidePosX = actualTo.f_82479_;
/* 256 */     this.collidePosY = actualTo.f_82480_;
/* 257 */     this.collidePosZ = actualTo.f_82481_;
/*     */     
/* 259 */     AABB beamBox = (new AABB(from, actualTo)).m_82400_(0.5D);
/* 260 */     List<LivingEntity> entities = world.m_45976_(LivingEntity.class, beamBox);
/*     */     
/* 262 */     for (LivingEntity entity : entities) {
/* 263 */       if (entity == this.caster)
/* 264 */         continue;  if (entity instanceof Player) { Player player = (Player)entity; LivingEntity livingEntity = this.caster; if (livingEntity instanceof Player) { Player casterPlayer = (Player)livingEntity; if (player.m_20148_().equals(casterPlayer.m_20148_()))
/*     */             continue;  }  }
/* 266 */        float pad = entity.m_6143_() + 0.25F;
/* 267 */       AABB aabb = entity.m_20191_().m_82400_(pad);
/* 268 */       Optional<Vec3> hit = aabb.m_82371_(from, actualTo);
/*     */       
/* 270 */       if (aabb.m_82390_(from) || hit.isPresent()) {
/* 271 */         result.addEntityHit(entity);
/*     */       }
/*     */     } 
/*     */     
/* 275 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 280 */     super.m_8119_();
/* 281 */     this.prevCollidePosX = this.collidePosX;
/* 282 */     this.prevCollidePosY = this.collidePosY;
/* 283 */     this.prevCollidePosZ = this.collidePosZ;
/*     */     
/* 285 */     if (this.f_19797_ == 1 && (m_9236_()).f_46443_) {
/* 286 */       Entity e = m_9236_().m_6815_(getCasterID());
/* 287 */       if (e instanceof LivingEntity) LivingEntity living = (LivingEntity)e;
/*     */     
/*     */     } 
/* 290 */     if (this.caster == null && getCasterID() != -1) {
/* 291 */       Entity e = m_9236_().m_6815_(getCasterID());
/* 292 */       if (e instanceof LivingEntity) LivingEntity living = (LivingEntity)e;
/*     */     
/*     */     } 
/* 295 */     if (!this.on || (this.caster != null && !this.caster.m_6084_())) {
/* 296 */       m_146870_();
/*     */       
/*     */       return;
/*     */     } 
/* 300 */     updateBeamFromHands();
/*     */     
/* 302 */     Vec3 start = getStartPos();
/* 303 */     Vec3 end = getEndPos();
/*     */     
/* 305 */     if ((m_9236_()).f_46443_ && !this.renderBeam && this.f_19797_ >= 2) {
/* 306 */       this.renderBeam = true;
/* 307 */       if (ModList.get().isLoaded("aaa_particles")) {
/* 308 */         AAAParticlesUtil.sendBlueDemonThunderBeam(m_9236_(), this);
/*     */       } else {
/* 310 */         setUseNoVfxThunder(true);
/*     */       } 
/*     */     } 
/*     */     
/* 314 */     if (!this.playSound) {
/* 315 */       this.playSound = true;
/* 316 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELECTRIC_SHOOT.get(), 1.0F, 1.0F);
/*     */     } 
/*     */     
/* 319 */     List<LivingEntity> hit = (raytraceEntities(m_9236_(), start, end)).entities;
/*     */     
/* 321 */     if (m_9236_() instanceof net.minecraft.server.level.ServerLevel) {
/* 322 */       for (LivingEntity target : hit) {
/* 323 */         if (this.caster != null) { target.m_6469_(m_269291_().m_269104_(this, (Entity)this.caster), this.power); }
/* 324 */         else { target.m_6469_(m_269291_().m_269425_(), this.power); }
/*     */         
/* 326 */         target.f_19864_ = true;
/* 327 */         target.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ELECTRIFY
/* 328 */               .get(), 60, 1));
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 335 */     if (this.f_19797_ > getDuration()) {
/* 336 */       this.on = false;
/* 337 */       m_146870_();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class BlueDemonThunderBeamHitResult {
/*     */     private BlockHitResult blockHit;
/* 343 */     private final List<LivingEntity> entities = new ArrayList<>();
/*     */     
/*     */     public void setBlockHit(HitResult rayTraceResult) {
/* 346 */       if (rayTraceResult != null && rayTraceResult.m_6662_() == HitResult.Type.BLOCK) {
/* 347 */         this.blockHit = (BlockHitResult)rayTraceResult;
/*     */       }
/*     */     }
/*     */     
/*     */     public void addEntityHit(LivingEntity entity) {
/* 352 */       this.entities.add(entity);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\BlueDemonThunderBeamEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */