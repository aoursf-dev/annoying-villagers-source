/*     */ package com.pla.annoyingvillagers.client.animation;
/*     */ 
/*     */ import com.pla.annoyingvillagers.accessors.ModelPartAccess;
/*     */ import com.pla.annoyingvillagers.client.model.ModelHerobrineDragon;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import java.util.Arrays;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.util.Mth;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DragonAnimator
/*     */ {
/*     */   private static final int JAW_OPENING_TIME_FOR_ATTACK = 5;
/*     */   private final HerobrineDragonEntity dragon;
/*     */   private float partialTicks;
/*     */   private float moveTime;
/*     */   private float moveSpeed;
/*     */   private float lookYaw;
/*     */   private float lookPitch;
/*     */   private double prevRenderYawOffset;
/*     */   private double yawAbs;
/*     */   private float animBase;
/*     */   private float cycleOfs;
/*     */   private float anim;
/*     */   private float ground;
/*     */   private float flutter;
/*     */   private float walk;
/*     */   private float sit;
/*     */   private float jaw;
/*     */   private float speed;
/*  63 */   private final LerpedFloat animTimer = new LerpedFloat();
/*  64 */   private final LerpedFloat groundTimer = new LerpedFloat.Clamped(1.0F, 0.0F, 1.0F);
/*  65 */   private final LerpedFloat flutterTimer = LerpedFloat.unit();
/*  66 */   private final LerpedFloat walkTimer = LerpedFloat.unit();
/*  67 */   private final LerpedFloat sitTimer = LerpedFloat.unit();
/*  68 */   private final LerpedFloat jawTimer = LerpedFloat.unit();
/*  69 */   private final LerpedFloat speedTimer = new LerpedFloat.Clamped(1.0F, 0.0F, 1.0F);
/*     */   
/*     */   private boolean initTrails = false;
/*     */   
/*  73 */   private final CircularBuffer yTrail = new CircularBuffer(8);
/*  74 */   private final CircularBuffer yawTrail = new CircularBuffer(16);
/*  75 */   private final CircularBuffer pitchTrail = new CircularBuffer(16);
/*     */   
/*     */   private boolean onGround;
/*     */   
/*     */   private boolean openJaw;
/*     */   
/*     */   private boolean wingsDown;
/*     */   
/*  83 */   private final float[] wingArm = new float[3];
/*  84 */   private final float[] wingForearm = new float[3];
/*  85 */   private final float[] wingArmFlutter = new float[3];
/*  86 */   private final float[] wingForearmFlutter = new float[3];
/*  87 */   private final float[] wingArmGlide = new float[3];
/*  88 */   private final float[] wingForearmGlide = new float[3];
/*  89 */   private final float[] wingArmGround = new float[3];
/*  90 */   private final float[] wingForearmGround = new float[3];
/*     */ 
/*     */   
/*  93 */   private final float[] xGround = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   private final float[][] xGroundStand = new float[][] { { 0.8F, -1.5F, 1.3F, 0.0F }, { -0.3F, 1.5F, -0.2F, 0.0F } };
/*     */ 
/*     */ 
/*     */   
/* 102 */   private final float[][] xGroundSit = new float[][] { { 0.3F, -1.8F, 1.8F, 0.0F }, { -0.8F, 1.8F, -0.9F, 0.0F } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   private final float[][][] xGroundWalk = new float[][][] { { { 0.4F, -1.4F, 1.3F, 0.0F }, { 0.1F, 1.2F, -0.5F, 0.0F } }, { { 1.2F, -1.6F, 1.3F, 0.0F }, { -0.3F, 2.1F, -0.9F, 0.6F } }, { { 0.9F, -2.1F, 1.8F, 0.6F }, { -0.7F, 1.4F, -0.2F, 0.0F } } };
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
/* 123 */   private final float[] xGroundWalk2 = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
/*     */ 
/*     */   
/* 126 */   private final float[] yGroundStand = new float[] { -0.25F, 0.25F };
/* 127 */   private final float[] yGroundSit = new float[] { 0.1F, 0.35F };
/* 128 */   private final float[] yGroundWalk = new float[] { -0.1F, 0.1F };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   private final float[][] xAirAll = new float[][] { { 0.0F, 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F, 0.0F } };
/*     */ 
/*     */   
/* 136 */   private final float[] yAirAll = new float[] { -0.1F, 0.1F };
/*     */ 
/*     */   
/*     */   public DragonAnimator(HerobrineDragonEntity dragon) {
/* 140 */     this.dragon = dragon;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPartialTicks(float partialTicks) {
/* 145 */     this.partialTicks = partialTicks;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMovement(float moveTime, float moveSpeed) {
/* 150 */     this.moveTime = moveTime;
/* 151 */     this.moveSpeed = moveSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLook(float lookYaw, float lookPitch) {
/* 157 */     this.lookYaw = Mth.m_14036_(lookYaw, -120.0F, 120.0F);
/* 158 */     this.lookPitch = Mth.m_14036_(lookPitch, -90.0F, 90.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void animate(ModelHerobrineDragon model) {
/* 169 */     this.anim = this.animTimer.get(this.partialTicks);
/* 170 */     this.ground = this.groundTimer.get(this.partialTicks);
/* 171 */     this.flutter = this.flutterTimer.get(this.partialTicks);
/* 172 */     this.walk = this.walkTimer.get(this.partialTicks);
/* 173 */     this.sit = this.sitTimer.get(this.partialTicks);
/* 174 */     this.jaw = this.jawTimer.get(this.partialTicks);
/* 175 */     this.speed = this.speedTimer.get(this.partialTicks);
/*     */     
/* 177 */     this.animBase = this.anim * 3.1415927F * 2.0F;
/* 178 */     this.cycleOfs = Mth.m_14031_(this.animBase - 1.0F) + 1.0F;
/*     */ 
/*     */     
/* 181 */     boolean newWingsDown = (this.cycleOfs > 1.0F);
/* 182 */     if (newWingsDown && !this.wingsDown && this.flutter != 0.0F) this.dragon.onWingsDown(this.speed); 
/* 183 */     this.wingsDown = newWingsDown;
/*     */ 
/*     */     
/* 186 */     model.back.f_104207_ = true;
/*     */     
/* 188 */     this.cycleOfs = (this.cycleOfs * this.cycleOfs + this.cycleOfs * 2.0F) * 0.05F;
/*     */ 
/*     */     
/* 191 */     this.cycleOfs *= Mth.m_144920_(0.5F, 1.0F, this.flutter);
/* 192 */     this.cycleOfs *= Mth.m_144920_(1.0F, 0.5F, this.ground);
/*     */ 
/*     */     
/* 195 */     animHeadAndNeck(model);
/* 196 */     animTail(model);
/* 197 */     animWings(model);
/* 198 */     animLegs(model);
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick() {
/* 203 */     setOnGround(!this.dragon.m_29443_());
/*     */ 
/*     */     
/* 206 */     if (!this.initTrails) {
/*     */       
/* 208 */       this.yTrail.fill((float)this.dragon.m_20186_());
/* 209 */       this.yawTrail.fill(this.dragon.f_20883_);
/* 210 */       this.pitchTrail.fill(getModelPitch());
/* 211 */       this.initTrails = true;
/*     */     } 
/*     */ 
/*     */     
/* 215 */     if (this.dragon.m_21223_() <= 0.0F) {
/*     */       
/* 217 */       this.animTimer.sync();
/* 218 */       this.groundTimer.sync();
/* 219 */       this.flutterTimer.sync();
/* 220 */       this.walkTimer.sync();
/* 221 */       this.sitTimer.sync();
/* 222 */       this.jawTimer.sync();
/*     */       
/*     */       return;
/*     */     } 
/* 226 */     float speedMax = 0.05F;
/* 227 */     float xD = (float)this.dragon.m_20185_() - (float)this.dragon.f_19854_;
/* 228 */     float yD = (float)this.dragon.m_20186_() - (float)this.dragon.f_19855_;
/* 229 */     float zD = (float)this.dragon.m_20189_() - (float)this.dragon.f_19856_;
/* 230 */     float speedEnt = xD * xD + zD * zD;
/* 231 */     float speedMulti = Mth.m_14036_(speedEnt / speedMax, 0.0F, 1.0F);
/*     */ 
/*     */     
/* 234 */     float animAdd = 0.035F;
/*     */ 
/*     */     
/* 237 */     if (!this.onGround)
/*     */     {
/* 239 */       animAdd += (1.0F - speedMulti) * animAdd;
/*     */     }
/*     */     
/* 242 */     this.animTimer.add(animAdd);
/*     */ 
/*     */     
/* 245 */     float groundVal = this.groundTimer.get();
/* 246 */     if (this.onGround) {
/*     */       
/* 248 */       groundVal *= 0.95F;
/* 249 */       groundVal += 0.08F;
/*     */     }
/*     */     else {
/*     */       
/* 253 */       groundVal -= 0.1F;
/*     */     } 
/* 255 */     this.groundTimer.set(groundVal);
/*     */ 
/*     */     
/* 258 */     boolean flutterFlag = (!this.onGround && (this.dragon.f_19862_ || yD > -0.1D || speedEnt < speedMax));
/* 259 */     this.flutterTimer.add(flutterFlag ? 0.1F : -0.1F);
/*     */ 
/*     */     
/* 262 */     boolean walkFlag = (this.moveSpeed > 0.1D && !this.dragon.m_21825_());
/* 263 */     float walkVal = 0.1F;
/* 264 */     this.walkTimer.add(walkFlag ? walkVal : -walkVal);
/*     */ 
/*     */     
/* 267 */     float sitVal = this.sitTimer.get();
/* 268 */     sitVal += this.dragon.m_21825_() ? 0.1F : -0.1F;
/* 269 */     sitVal *= 0.95F;
/* 270 */     this.sitTimer.set(sitVal);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     boolean speedFlag = (speedEnt > speedMax || this.dragon.isNearGround());
/* 280 */     float speedValue = 0.05F;
/* 281 */     this.speedTimer.add(speedFlag ? speedValue : -speedValue);
/*     */ 
/*     */     
/* 284 */     double yawDiff = this.dragon.f_20883_ - this.prevRenderYawOffset;
/* 285 */     this.prevRenderYawOffset = this.dragon.f_20883_;
/*     */ 
/*     */     
/* 288 */     if (yawDiff < 180.0D && yawDiff > -180.0D) this.yawAbs += yawDiff;
/*     */     
/* 290 */     this.yTrail.update((float)this.dragon.m_20186_());
/* 291 */     this.yawTrail.update((float)-this.yawAbs);
/* 292 */     this.pitchTrail.update(getModelPitch());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void animHeadAndNeck(ModelHerobrineDragon model) {
/* 297 */     model.neck.m_104227_(0.0F, 14.0F, -8.0F);
/* 298 */     model.neck.m_171327_(0.0F, 0.0F, 0.0F);
/*     */     
/* 300 */     float health = this.dragon.getHealthFraction();
/*     */ 
/*     */     
/* 303 */     for (int i = 0; i < model.neckProxy.length; i++) {
/*     */       
/* 305 */       float vertMulti = (i + 1) / model.neckProxy.length;
/*     */       
/* 307 */       float baseRotX = Mth.m_14089_(i * 0.45F + this.animBase) * 0.15F;
/* 308 */       baseRotX *= Mth.m_144920_(0.2F, 1.0F, this.flutter);
/* 309 */       baseRotX *= Mth.m_144920_(1.0F, 0.2F, this.sit);
/* 310 */       float ofsRotX = Mth.m_14031_(vertMulti * 3.1415927F * 0.9F) * 0.75F;
/*     */ 
/*     */       
/* 313 */       model.neck.f_104203_ = baseRotX;
/*     */       
/* 315 */       model.neck.f_104203_ *= terpSmoothStep(1.0F, 0.5F, this.walk);
/*     */       
/* 317 */       model.neck.f_104203_ += (1.0F - this.speed) * vertMulti;
/*     */       
/* 319 */       model.neck.f_104203_ -= Mth.m_144920_(0.0F, ofsRotX, this.ground * health);
/*     */       
/* 321 */       model.neck.f_104204_ = (float)Math.toRadians(this.lookYaw) * vertMulti * this.speed;
/*     */ 
/*     */       
/* 324 */       float v = Mth.m_144920_(1.6F, 1.0F, vertMulti);
/* 325 */       ((ModelPartAccess)model.neck).setRenderScale(v, v, 0.6F);
/*     */ 
/*     */       
/* 328 */       model.neckScale.f_104207_ = (i % 2 != 0 || i == 0);
/*     */ 
/*     */       
/* 331 */       model.neckProxy[i].update();
/*     */ 
/*     */       
/* 334 */       float neckSize = 10.0F * ((ModelPartAccess)model.neck).getZScale() - 1.4F;
/* 335 */       model.neck.f_104200_ -= Mth.m_14031_(model.neck.f_104204_) * Mth.m_14089_(model.neck.f_104203_) * neckSize;
/* 336 */       model.neck.f_104201_ += Mth.m_14031_(model.neck.f_104203_) * neckSize;
/* 337 */       model.neck.f_104202_ -= Mth.m_14089_(model.neck.f_104204_) * Mth.m_14089_(model.neck.f_104203_) * neckSize;
/*     */     } 
/*     */     
/* 340 */     model.head.f_104203_ = (float)Math.toRadians(this.lookPitch) + 1.0F - this.speed;
/* 341 */     model.head.f_104204_ = model.neck.f_104204_;
/* 342 */     model.neck.f_104205_ *= 0.2F;
/*     */     
/* 344 */     model.head.f_104200_ = model.neck.f_104200_;
/* 345 */     model.head.f_104201_ = model.neck.f_104201_;
/* 346 */     model.head.f_104202_ = model.neck.f_104202_;
/*     */     
/* 348 */     model.jaw.f_104203_ = this.jaw * 0.75F;
/* 349 */     model.jaw.f_104203_ += (1.0F - Mth.m_14031_(this.animBase)) * 0.1F * this.flutter;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void animWings(ModelHerobrineDragon model) {
/* 355 */     float aSpeed = (this.sit > 0.0F) ? 0.6F : 1.0F;
/*     */ 
/*     */     
/* 358 */     float a1 = this.animBase * aSpeed * 0.35F;
/* 359 */     float a2 = this.animBase * aSpeed * 0.5F;
/* 360 */     float a3 = this.animBase * aSpeed * 0.75F;
/*     */     
/* 362 */     if (this.ground < 1.0F) {
/*     */ 
/*     */       
/* 365 */       this.wingArmFlutter[0] = 0.125F - Mth.m_14089_(this.animBase) * 0.2F;
/* 366 */       this.wingArmFlutter[1] = 0.25F;
/* 367 */       this.wingArmFlutter[2] = (Mth.m_14031_(this.animBase) + 0.125F) * 0.8F;
/*     */       
/* 369 */       this.wingForearmFlutter[0] = 0.0F;
/* 370 */       this.wingForearmFlutter[1] = -this.wingArmFlutter[1] * 2.0F;
/* 371 */       this.wingForearmFlutter[2] = -(Mth.m_14031_(this.animBase + 2.0F) + 0.5F) * 0.75F;
/*     */ 
/*     */       
/* 374 */       this.wingArmGlide[0] = -0.25F - Mth.m_14089_(this.animBase * 2.0F) * Mth.m_14089_(this.animBase * 1.5F) * 0.04F;
/* 375 */       this.wingArmGlide[1] = 0.25F;
/* 376 */       this.wingArmGlide[2] = 0.35F + Mth.m_14031_(this.animBase) * 0.05F;
/*     */       
/* 378 */       this.wingForearmGlide[0] = 0.0F;
/* 379 */       this.wingForearmGlide[1] = -this.wingArmGlide[1] * 2.0F;
/* 380 */       this.wingForearmGlide[2] = -0.25F + (Mth.m_14031_(this.animBase + 2.0F) + 0.5F) * 0.05F;
/*     */     } 
/*     */     
/* 383 */     if (this.ground > 0.0F) {
/*     */ 
/*     */       
/* 386 */       this.wingArmGround[0] = 0.0F;
/* 387 */       this.wingArmGround[1] = 1.4F - Mth.m_14031_(a1) * Mth.m_14031_(a2) * 0.02F;
/* 388 */       this.wingArmGround[2] = 0.8F + Mth.m_14031_(a2) * Mth.m_14031_(a3) * 0.05F;
/*     */ 
/*     */       
/* 391 */       this.wingArmGround[1] = this.wingArmGround[1] + Mth.m_14031_(this.moveTime * 0.5F) * 0.02F * this.walk;
/* 392 */       this.wingArmGround[2] = this.wingArmGround[2] + Mth.m_14089_(this.moveTime * 0.5F) * 0.05F * this.walk;
/*     */       
/* 394 */       this.wingForearmGround[0] = 0.0F;
/* 395 */       this.wingForearmGround[1] = -this.wingArmGround[1] * 2.0F;
/* 396 */       this.wingForearmGround[2] = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 400 */     slerpArrays(this.wingArmGlide, this.wingArmFlutter, this.wingArm, this.flutter);
/* 401 */     slerpArrays(this.wingForearmGlide, this.wingForearmFlutter, this.wingForearm, this.flutter);
/*     */ 
/*     */     
/* 404 */     slerpArrays(this.wingArm, this.wingArmGround, this.wingArm, this.ground);
/* 405 */     slerpArrays(this.wingForearm, this.wingForearmGround, this.wingForearm, this.ground);
/*     */ 
/*     */     
/* 408 */     mirrorRotate(model.wingArms[0], model.wingArms[1], this.wingArm[0], this.wingArm[1], this.wingArm[2]);
/*     */ 
/*     */     
/* 411 */     mirrorRotate(model.wingForearms[0], model.wingForearms[1], this.wingForearm[0], this.wingForearm[1], this.wingForearm[2]);
/*     */ 
/*     */ 
/*     */     
/* 415 */     float[] yFold = { 2.7F, 2.8F, 2.9F, 3.0F };
/* 416 */     float[] yUnfold = { 0.1F, 0.9F, 1.7F, 2.5F };
/*     */ 
/*     */     
/* 419 */     float rotX = 0.0F;
/* 420 */     float rotYOfs = Mth.m_14031_(a1) * Mth.m_14031_(a2) * 0.03F;
/* 421 */     float rotYMulti = 1.0F;
/*     */     
/* 423 */     for (int i = 0; i < (model.wingFingers[0]).length; i++) {
/*     */       
/* 425 */       mirrorRotate(model.wingFingers[0][i], model.wingFingers[1][i], rotX += 0.005F, 
/*     */ 
/*     */           
/* 428 */           terpSmoothStep(yUnfold[i], yFold[i] + rotYOfs * rotYMulti, this.ground), 0.0F);
/*     */ 
/*     */       
/* 431 */       rotYMulti -= 0.2F;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void animTail(ModelHerobrineDragon model) {
/* 438 */     model.tail.f_104200_ = 0.0F;
/* 439 */     model.tail.f_104201_ = 16.0F;
/* 440 */     model.tail.f_104202_ = 62.0F;
/*     */     
/* 442 */     model.tail.f_104203_ = 0.0F;
/* 443 */     model.tail.f_104204_ = 0.0F;
/* 444 */     model.tail.f_104205_ = 0.0F;
/*     */     
/* 446 */     float rotXStand = 0.0F;
/* 447 */     float rotYStand = 0.0F;
/* 448 */     float rotXSit = 0.0F;
/* 449 */     float rotYSit = 0.0F;
/* 450 */     float rotXAir = 0.0F;
/* 451 */     float rotYAir = 0.0F;
/*     */     
/* 453 */     for (int i = 0; i < model.tailProxy.length; i++) {
/*     */       
/* 455 */       float vertMulti = (i + 1) / model.tailProxy.length;
/*     */ 
/*     */       
/* 458 */       float amp = 0.1F + i / model.tailProxy.length * 2.0F;
/*     */       
/* 460 */       rotXStand = (i - model.tailProxy.length * 0.6F) * -amp * 0.4F;
/* 461 */       rotXStand += (Mth.m_14031_(this.animBase * 0.2F) * Mth.m_14031_(this.animBase * 0.37F) * 0.4F * amp - 0.1F) * (1.0F - this.sit);
/* 462 */       rotXSit = rotXStand * 0.8F;
/*     */       
/* 464 */       rotYStand = (rotYStand + Mth.m_14031_(i * 0.45F + this.animBase * 0.5F)) * amp * 0.4F;
/* 465 */       rotYSit = Mth.m_14031_(vertMulti * 3.1415927F) * 3.1415927F * 1.2F - 0.5F;
/*     */       
/* 467 */       rotXAir -= Mth.m_14031_(i * 0.45F + this.animBase) * 0.04F * Mth.m_144920_(0.3F, 1.0F, this.flutter);
/*     */ 
/*     */       
/* 470 */       model.tail.f_104203_ = Mth.m_144920_(rotXStand, rotXSit, this.sit);
/* 471 */       model.tail.f_104204_ = Mth.m_144920_(rotYStand, rotYSit, this.sit);
/*     */ 
/*     */       
/* 474 */       model.tail.f_104203_ = Mth.m_144920_(rotXAir, model.tail.f_104203_, this.ground);
/* 475 */       model.tail.f_104204_ = Mth.m_144920_(rotYAir, model.tail.f_104204_, this.ground);
/*     */ 
/*     */       
/* 478 */       float angleLimit = 160.0F * vertMulti;
/* 479 */       float yawOfs = Mth.m_14036_(this.yawTrail.get(this.partialTicks, 0, i + 1) * 2.0F, -angleLimit, angleLimit);
/* 480 */       float pitchOfs = Mth.m_14036_(this.pitchTrail.get(this.partialTicks, 0, i + 1) * 2.0F, -angleLimit, angleLimit);
/*     */       
/* 482 */       model.tail.f_104203_ += (float)Math.toRadians(pitchOfs);
/* 483 */       model.tail.f_104203_ -= (1.0F - this.speed) * vertMulti * 2.0F;
/* 484 */       model.tail.f_104204_ += (float)Math.toRadians((180.0F - yawOfs));
/*     */       
/* 486 */       if (model.tailHornRight != null) {
/*     */ 
/*     */         
/* 489 */         boolean atIndex = (i > model.tailProxy.length - 7 && i < model.tailProxy.length - 3);
/* 490 */         model.tailHornRight.f_104207_ = atIndex;
/*     */       } 
/*     */ 
/*     */       
/* 494 */       float neckScale = Mth.m_144920_(1.5F, 0.3F, vertMulti);
/* 495 */       ((ModelPartAccess)model.tail).setRenderScale(neckScale, neckScale, neckScale);
/*     */ 
/*     */       
/* 498 */       model.tailProxy[i].update();
/*     */ 
/*     */       
/* 501 */       float tailSize = 10.0F * ((ModelPartAccess)model.tail).getZScale() - 0.7F;
/* 502 */       model.tail.f_104201_ += Mth.m_14031_(model.tail.f_104203_) * tailSize;
/* 503 */       model.tail.f_104202_ -= Mth.m_14089_(model.tail.f_104204_) * Mth.m_14089_(model.tail.f_104203_) * tailSize;
/* 504 */       model.tail.f_104200_ -= Mth.m_14031_(model.tail.f_104204_) * Mth.m_14089_(model.tail.f_104203_) * tailSize;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void animLegs(ModelHerobrineDragon model) {
/* 511 */     if (this.ground < 1.0F) {
/*     */       
/* 513 */       float footAirOfs = this.cycleOfs * 0.1F;
/* 514 */       float footAirX = 0.75F + this.cycleOfs * 0.1F;
/*     */       
/* 516 */       this.xAirAll[0][0] = 1.3F + footAirOfs;
/* 517 */       this.xAirAll[0][1] = -(0.7F * this.speed + 0.1F + footAirOfs);
/* 518 */       this.xAirAll[0][2] = footAirX;
/* 519 */       this.xAirAll[0][3] = footAirX * 0.5F;
/*     */       
/* 521 */       this.xAirAll[1][0] = footAirOfs + 0.6F;
/* 522 */       this.xAirAll[1][1] = footAirOfs + 0.8F;
/* 523 */       this.xAirAll[1][2] = footAirX;
/* 524 */       this.xAirAll[1][3] = footAirX * 0.5F;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 531 */     for (int i = 0; i < model.legs.length; i++) {
/*     */       
/* 533 */       ModelPart thigh = model.legs[i][0];
/* 534 */       ModelPart crus = model.legs[i][1];
/* 535 */       ModelPart foot = model.legs[i][2];
/* 536 */       ModelPart toe = model.legs[i][3];
/*     */       
/* 538 */       thigh.f_104202_ = (i % 2 == 0) ? 4.0F : 46.0F;
/*     */ 
/*     */       
/* 541 */       float[] xAir = this.xAirAll[i % 2];
/*     */ 
/*     */       
/* 544 */       slerpArrays(this.xGroundStand[i % 2], this.xGroundSit[i % 2], this.xGround, this.sit);
/*     */ 
/*     */       
/* 547 */       this.xGround[3] = -(this.xGround[0] + this.xGround[1] + this.xGround[2]);
/*     */ 
/*     */       
/* 550 */       if (this.walk > 0.0F) {
/*     */ 
/*     */         
/* 553 */         splineArrays(this.moveTime * 0.2F, (i > 1), this.xGroundWalk2, new float[][] { this.xGroundWalk[0][i % 2], this.xGroundWalk[1][i % 2], this.xGroundWalk[2][i % 2] });
/*     */ 
/*     */         
/* 556 */         this.xGroundWalk2[3] = this.xGroundWalk2[3] - this.xGroundWalk2[0] + this.xGroundWalk2[1] + this.xGroundWalk2[2];
/*     */         
/* 558 */         slerpArrays(this.xGround, this.xGroundWalk2, this.xGround, this.walk);
/*     */       } 
/*     */       
/* 561 */       float yAir = this.yAirAll[i % 2];
/*     */ 
/*     */ 
/*     */       
/* 565 */       float yGround = terpSmoothStep(this.yGroundStand[i % 2], this.yGroundSit[i % 2], this.sit);
/*     */ 
/*     */       
/* 568 */       yGround = terpSmoothStep(yGround, this.yGroundWalk[i % 2], this.walk);
/*     */ 
/*     */       
/* 571 */       thigh.f_104204_ = terpSmoothStep(yAir, yGround, this.ground);
/* 572 */       thigh.f_104203_ = terpSmoothStep(xAir[0], this.xGround[0], this.ground);
/* 573 */       crus.f_104203_ = terpSmoothStep(xAir[1], this.xGround[1], this.ground);
/* 574 */       foot.f_104203_ = terpSmoothStep(xAir[2], this.xGround[2], this.ground);
/* 575 */       toe.f_104203_ = terpSmoothStep(xAir[3], this.xGround[3], this.ground);
/*     */       
/* 577 */       if (i > 1) thigh.f_104204_ *= -1.0F;
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getModelPitch() {
/* 583 */     return getModelPitch(this.partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getModelPitch(float pt) {
/* 588 */     float pitchMovingMax = 90.0F;
/* 589 */     float pitchMoving = Mth.m_14036_(this.yTrail.get(pt, 5, 0) * 10.0F, -pitchMovingMax, pitchMovingMax);
/* 590 */     float pitchHover = 60.0F;
/* 591 */     return terpSmoothStep(pitchHover, pitchMoving, this.speed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getModelOffsetX() {
/* 597 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getModelOffsetY() {
/* 602 */     return 1.5F + -this.sit * 0.6F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getModelOffsetZ() {
/* 607 */     return -1.5F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOnGround(boolean onGround) {
/* 612 */     this.onGround = onGround;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOpenJaw(boolean openJaw) {
/* 617 */     this.openJaw = openJaw;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void mirrorRotate(ModelPart rightLimb, ModelPart leftLimb, float xRot, float yRot, float zRot) {
/* 622 */     rightLimb.f_104203_ = xRot;
/* 623 */     rightLimb.f_104204_ = yRot;
/* 624 */     rightLimb.f_104205_ = zRot;
/* 625 */     leftLimb.f_104203_ = xRot;
/* 626 */     leftLimb.f_104204_ = -yRot;
/* 627 */     leftLimb.f_104205_ = -zRot;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void slerpArrays(float[] a, float[] b, float[] c, float x) {
/* 632 */     if (a.length != b.length || b.length != c.length)
/*     */     {
/* 634 */       throw new IllegalArgumentException();
/*     */     }
/*     */     
/* 637 */     if (x <= 0.0F) {
/*     */       
/* 639 */       System.arraycopy(a, 0, c, 0, a.length);
/*     */       return;
/*     */     } 
/* 642 */     if (x >= 1.0F) {
/*     */       
/* 644 */       System.arraycopy(b, 0, c, 0, a.length);
/*     */       
/*     */       return;
/*     */     } 
/* 648 */     for (int i = 0; i < c.length; i++)
/*     */     {
/* 650 */       c[i] = terpSmoothStep(a[i], b[i], x);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static float terpSmoothStep(float a, float b, float x) {
/* 656 */     if (x <= 0.0F)
/*     */     {
/* 658 */       return a;
/*     */     }
/* 660 */     if (x >= 1.0F)
/*     */     {
/* 662 */       return b;
/*     */     }
/* 664 */     x = x * x * (3.0F - 2.0F * x);
/* 665 */     return a * (1.0F - x) + b * x;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void splineArrays(float x, boolean shift, float[] result, float[]... nodes) {
/* 670 */     int i1 = (int)x % nodes.length;
/* 671 */     int i2 = (i1 + 1) % nodes.length;
/* 672 */     int i3 = (i1 + 2) % nodes.length;
/*     */     
/* 674 */     float[] a1 = nodes[i1];
/* 675 */     float[] a2 = nodes[i2];
/* 676 */     float[] a3 = nodes[i3];
/*     */     
/* 678 */     float xn = x % nodes.length - i1;
/*     */     
/* 680 */     if (shift) { terpCatmullRomSpline(xn, result, new float[][] { a2, a3, a1, a2 }); }
/* 681 */     else { terpCatmullRomSpline(xn, result, new float[][] { a1, a2, a3, a1 }); }
/*     */   
/*     */   }
/* 684 */   private static final float[][] CR = new float[][] { { -0.5F, 1.5F, -1.5F, 0.5F }, { 1.0F, -2.5F, 2.0F, -0.5F }, { -0.5F, 0.0F, 0.5F, 0.0F }, { 0.0F, 1.0F, 0.0F, 0.0F } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void terpCatmullRomSpline(float x, float[] result, float[]... knots) {
/* 694 */     int nknots = knots.length;
/* 695 */     int nspans = nknots - 3;
/* 696 */     int knot = 0;
/* 697 */     if (nspans < 1)
/*     */     {
/* 699 */       throw new IllegalArgumentException("Spline has too few knots");
/*     */     }
/* 701 */     x = Mth.m_14036_(x, 0.0F, 0.9999F) * nspans;
/*     */     
/* 703 */     int span = (int)x;
/* 704 */     if (span >= nknots - 3)
/*     */     {
/* 706 */       span = nknots - 3;
/*     */     }
/*     */     
/* 709 */     x -= span;
/* 710 */     knot += span;
/*     */     
/* 712 */     int dimension = result.length;
/* 713 */     for (int i = 0; i < dimension; i++) {
/*     */       
/* 715 */       float knot0 = knots[knot][i];
/* 716 */       float knot1 = knots[knot + 1][i];
/* 717 */       float knot2 = knots[knot + 2][i];
/* 718 */       float knot3 = knots[knot + 3][i];
/*     */       
/* 720 */       float c3 = CR[0][0] * knot0 + CR[0][1] * knot1 + CR[0][2] * knot2 + CR[0][3] * knot3;
/* 721 */       float c2 = CR[1][0] * knot0 + CR[1][1] * knot1 + CR[1][2] * knot2 + CR[1][3] * knot3;
/* 722 */       float c1 = CR[2][0] * knot0 + CR[2][1] * knot1 + CR[2][2] * knot2 + CR[2][3] * knot3;
/* 723 */       float c0 = CR[3][0] * knot0 + CR[3][1] * knot1 + CR[3][2] * knot2 + CR[3][3] * knot3;
/*     */       
/* 725 */       result[i] = ((c3 * x + c2) * x + c1) * x + c0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class LerpedFloat
/*     */   {
/*     */     protected float current;
/*     */     protected float previous;
/*     */     
/*     */     public LerpedFloat() {
/* 736 */       this.current = this.previous = 0.0F;
/*     */     }
/*     */ 
/*     */     
/*     */     public LerpedFloat(float start) {
/* 741 */       this.current = this.previous = start;
/*     */     }
/*     */ 
/*     */     
/*     */     public float get(float x) {
/* 746 */       return Mth.m_144920_(this.previous, this.current, x);
/*     */     }
/*     */ 
/*     */     
/*     */     public float get() {
/* 751 */       return this.current;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(float value) {
/* 756 */       sync();
/* 757 */       this.current = value;
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(float value) {
/* 762 */       sync();
/* 763 */       this.current += value;
/*     */     }
/*     */ 
/*     */     
/*     */     public void sync() {
/* 768 */       this.previous = this.current;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getPrevious() {
/* 773 */       return this.previous;
/*     */     }
/*     */ 
/*     */     
/*     */     public static Clamped unit() {
/* 778 */       return new Clamped(0.0F, 1.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public static class Clamped
/*     */       extends LerpedFloat
/*     */     {
/*     */       private final float min;
/*     */       
/*     */       private final float max;
/*     */ 
/*     */       
/*     */       public Clamped(float start, float min, float max) {
/* 792 */         super(Mth.m_14036_(start, min, max));
/* 793 */         this.min = min;
/* 794 */         this.max = max;
/*     */       }
/*     */ 
/*     */       
/*     */       public Clamped(float min, float max) {
/* 799 */         this(0.0F, min, max);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void set(float value) {
/* 805 */         super.set(Mth.m_14036_(value, this.min, this.max));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void add(float value) {
/* 811 */         super.add(value);
/* 812 */         this.current = Mth.m_14036_(this.current, this.min, this.max);
/*     */       }
/*     */ 
/*     */       
/*     */       public float getMin() {
/* 817 */         return this.min;
/*     */       }
/*     */       
/*     */       public float getMax()
/*     */       {
/* 822 */         return this.max; } } } public static class Clamped extends LerpedFloat { private final float min; public float getMax() { return this.max; } private final float max; public Clamped(float start, float min, float max) {
/*     */       super(Mth.m_14036_(start, min, max));
/*     */       this.min = min;
/*     */       this.max = max;
/*     */     } public Clamped(float min, float max) {
/*     */       this(0.0F, min, max);
/*     */     } public void set(float value) {
/*     */       super.set(Mth.m_14036_(value, this.min, this.max));
/*     */     } public void add(float value) {
/*     */       super.add(value);
/*     */       this.current = Mth.m_14036_(this.current, this.min, this.max);
/*     */     } public float getMin() {
/*     */       return this.min;
/* 835 */     } } public static class CircularBuffer { private final float[] buffer; private int index = 0;
/*     */ 
/*     */     
/*     */     public CircularBuffer(int size) {
/* 839 */       this.buffer = new float[size];
/*     */     }
/*     */ 
/*     */     
/*     */     public void fill(float value) {
/* 844 */       Arrays.fill(this.buffer, value);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(float value) {
/* 850 */       this.index++;
/*     */ 
/*     */       
/* 853 */       this.index %= this.buffer.length;
/*     */       
/* 855 */       this.buffer[this.index] = value;
/*     */     }
/*     */ 
/*     */     
/*     */     public float get(float x, int offset) {
/* 860 */       int i = this.index - offset;
/* 861 */       int len = this.buffer.length - 1;
/* 862 */       return Mth.m_144920_(this.buffer[i - 1 & len], this.buffer[i & len], x);
/*     */     }
/*     */ 
/*     */     
/*     */     public float get(float x, int offset1, int offset2) {
/* 867 */       return get(x, offset2) - get(x, offset1);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\animation\DragonAnimator.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */