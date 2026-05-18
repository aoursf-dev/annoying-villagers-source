/*     */ package com.pla.annoyingvillagers.client.model;
/*     */ 
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import com.mojang.datafixers.kinds.App;
/*     */ import com.mojang.datafixers.kinds.Applicative;
/*     */ import com.mojang.datafixers.util.Function3;
/*     */ import com.mojang.serialization.Codec;
/*     */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*     */ import com.pla.annoyingvillagers.accessors.ModelPartAccess;
/*     */ import com.pla.annoyingvillagers.client.animation.DragonAnimator;
/*     */ import com.pla.annoyingvillagers.client.engine.ModelPartProxy;
/*     */ import com.pla.annoyingvillagers.entity.HerobrineDragonEntity;
/*     */ import java.util.NoSuchElementException;
/*     */ import net.minecraft.client.model.EntityModel;
/*     */ import net.minecraft.client.model.geom.ModelLayerLocation;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.client.model.geom.PartPose;
/*     */ import net.minecraft.client.model.geom.builders.CubeListBuilder;
/*     */ import net.minecraft.client.model.geom.builders.LayerDefinition;
/*     */ import net.minecraft.client.model.geom.builders.MeshDefinition;
/*     */ import net.minecraft.client.model.geom.builders.PartDefinition;
/*     */ import net.minecraft.client.renderer.RenderType;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ public class ModelHerobrineDragon
/*     */   extends EntityModel<HerobrineDragonEntity>
/*     */ {
/*  52 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
/*  53 */       ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "modelherobrinedragon"), "main");
/*     */   
/*     */   public static final int NECK_SIZE = 10;
/*     */   
/*     */   public static final int TAIL_SIZE = 10;
/*     */   
/*     */   public static final int VERTS_NECK = 7;
/*     */   
/*     */   public static final int VERTS_TAIL = 12;
/*     */   
/*     */   public static final int HEAD_OFS = -16;
/*     */   
/*     */   public final ModelPart head;
/*     */   public final ModelPart neck;
/*     */   public final ModelPart neckScale;
/*     */   public final ModelPart tail;
/*     */   public final ModelPart tailHornLeft;
/*     */   public final ModelPart tailHornRight;
/*     */   public final ModelPart jaw;
/*     */   public final ModelPart body;
/*     */   public final ModelPart back;
/*  74 */   public final ModelPart[][] legs = new ModelPart[4][4];
/*     */ 
/*     */   
/*     */   public final ModelPart[] wingArms;
/*     */   
/*     */   public final ModelPart[] wingForearms;
/*     */   
/*  81 */   public final ModelPart[][] wingFingers = new ModelPart[2][4];
/*     */ 
/*     */ 
/*     */   
/*  85 */   public final ModelPartProxy[] neckProxy = new ModelPartProxy[7];
/*  86 */   public final ModelPartProxy[] tailProxy = new ModelPartProxy[12];
/*     */   
/*     */   public float size;
/*     */ 
/*     */   
/*     */   public ModelHerobrineDragon(ModelPart root) {
/*  92 */     super(RenderType::m_110452_);
/*     */     
/*  94 */     this.body = root.m_171324_("body");
/*  95 */     this.back = this.body.m_171324_("back");
/*  96 */     this.neck = root.m_171324_("neck");
/*  97 */     this.neckScale = this.neck.m_171324_("neck_scale");
/*  98 */     this.head = root.m_171324_("head");
/*  99 */     this.jaw = this.head.m_171324_("jaw");
/* 100 */     this.tail = root.m_171324_("tail");
/* 101 */     this.tailHornRight = getNullableChild(this.tail, "right_tail_spike");
/* 102 */     this.tailHornLeft = getNullableChild(this.tail, "left_tail_spike");
/*     */     
/* 104 */     ModelPart rightWingArm = root.m_171324_("right_wing_arm");
/* 105 */     ModelPart leftWingArm = root.m_171324_("left_wing_arm");
/* 106 */     ModelPart rightWingForearm = rightWingArm.m_171324_("right_wing_forearm");
/* 107 */     ModelPart leftWingForearm = leftWingArm.m_171324_("left_wing_forearm");
/*     */     
/* 109 */     this.wingArms = new ModelPart[] { rightWingArm, leftWingArm };
/* 110 */     this.wingForearms = new ModelPart[] { rightWingForearm, leftWingForearm };
/*     */     int i;
/* 112 */     for (i = 1; i < 5; i++) {
/*     */       
/* 114 */       this.wingFingers[0][i - 1] = rightWingForearm.m_171324_("right_wing_finger_" + i);
/* 115 */       this.wingFingers[1][i - 1] = leftWingForearm.m_171324_("left_wing_finger_" + i);
/*     */     } 
/*     */     
/* 118 */     for (i = 0; i < this.legs.length; i++) {
/*     */       
/* 120 */       boolean right = (i < 2);
/* 121 */       String dirName = right ? "right_" : "left_";
/* 122 */       String type = (i % 2 == 0) ? "fore_" : "hind_";
/* 123 */       String[] parts = { "thigh", "crus", "foot", "toe" };
/* 124 */       ModelPart parent = root;
/* 125 */       for (int j = 0; j < parts.length; j++) {
/* 126 */         parent = this.legs[i][j] = parent.m_171324_(dirName + dirName + type);
/*     */       }
/*     */     } 
/*     */     
/* 130 */     for (i = 0; i < this.neckProxy.length; ) { this.neckProxy[i] = new ModelPartProxy(this.neck); i++; }
/* 131 */      for (i = 0; i < this.tailProxy.length; ) { this.tailProxy[i] = new ModelPartProxy(this.tail); i++; }
/*     */     
/* 133 */     if (this.tailHornRight != null)
/*     */     {
/* 135 */       this.tailHornLeft.f_104207_ = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static LayerDefinition createBodyLayer() {
/* 141 */     MeshDefinition mesh = new MeshDefinition();
/* 142 */     PartDefinition root = mesh.m_171576_();
/*     */     
/* 144 */     buildBody(root);
/* 145 */     buildNeck(root);
/* 146 */     buildHead(root);
/* 147 */     buildTail(root, Properties.STANDARD);
/* 148 */     buildWings(root);
/* 149 */     buildLegs(root, Properties.STANDARD);
/*     */     
/* 151 */     return LayerDefinition.m_171565_(mesh, 256, 256);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void buildBody(PartDefinition root) {
/* 156 */     PartDefinition body = root.m_171599_("body", CubeListBuilder.m_171558_()
/* 157 */         .m_171514_(0, 0).m_171481_(-12.0F, 0.0F, -16.0F, 24.0F, 24.0F, 64.0F)
/* 158 */         .m_171514_(0, 32).m_171481_(-1.0F, -6.0F, 10.0F, 2.0F, 6.0F, 12.0F).m_171481_(-1.0F, -6.0F, 30.0F, 2.0F, 6.0F, 12.0F), 
/* 159 */         PartPose.m_171419_(0.0F, 4.0F, 8.0F));
/* 160 */     body.m_171599_("back", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171481_(-1.0F, -6.0F, -10.0F, 2.0F, 6.0F, 12.0F), PartPose.f_171404_);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void buildNeck(PartDefinition root) {
/* 165 */     PartDefinition neck = root.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(112, 88).m_171481_(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F), PartPose.f_171404_);
/* 166 */     neck.m_171599_("neck_scale", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.0F, -7.0F, -3.0F, 2.0F, 4.0F, 6.0F), PartPose.f_171404_);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void buildHead(PartDefinition root) {
/* 171 */     PartDefinition head = root.m_171599_("head", CubeListBuilder.m_171558_()
/* 172 */         .m_171514_(56, 88).m_171481_(-6.0F, -1.0F, -24.0F, 12.0F, 5.0F, 16.0F)
/* 173 */         .m_171514_(0, 0).m_171481_(-8.0F, -8.0F, -10.0F, 16.0F, 16.0F, 16.0F)
/* 174 */         .m_171514_(48, 0).m_171481_(-5.0F, -3.0F, -22.0F, 2.0F, 2.0F, 4.0F)
/* 175 */         .m_171480_().m_171481_(3.0F, -3.0F, -22.0F, 2.0F, 2.0F, 4.0F), PartPose.f_171404_);
/*     */     
/* 177 */     addHorns(head);
/* 178 */     head.m_171599_("jaw", CubeListBuilder.m_171558_().m_171514_(0, 88).m_171481_(-6.0F, 0.0F, -16.0F, 12.0F, 4.0F, 16.0F), PartPose.m_171419_(0.0F, 4.0F, -8.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addHorns(PartDefinition head) {
/* 183 */     int hornThick = 3;
/* 184 */     int hornLength = 12;
/*     */     
/* 186 */     float hornOfs = -(hornThick / 2.0F);
/*     */     
/* 188 */     float hornPosX = -5.0F;
/* 189 */     float hornPosY = -8.0F;
/* 190 */     float hornPosZ = 0.0F;
/*     */     
/* 192 */     float hornRotX = 0.523599F;
/* 193 */     float hornRotY = -0.523599F;
/* 194 */     float hornRotZ = 0.0F;
/*     */     
/* 196 */     head.m_171599_("horn1", CubeListBuilder.m_171558_().m_171514_(28, 32).m_171481_(hornOfs, hornOfs, hornOfs, hornThick, hornThick, hornLength), 
/* 197 */         PartPose.m_171423_(hornPosX, hornPosY, hornPosZ, hornRotX, hornRotY, hornRotZ));
/* 198 */     head.m_171599_("horn2", CubeListBuilder.m_171558_().m_171514_(28, 32).m_171480_().m_171481_(hornOfs, hornOfs, hornOfs, hornThick, hornThick, hornLength), 
/* 199 */         PartPose.m_171423_(hornPosX * -1.0F, hornPosY, hornPosZ, hornRotX, hornRotY * -1.0F, hornRotZ));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void buildTail(PartDefinition root, Properties properties) {
/* 204 */     PartDefinition tail = root.m_171599_("tail", CubeListBuilder.m_171558_().m_171514_(152, 88).m_171481_(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F), PartPose.f_171404_);
/* 205 */     CubeListBuilder tailSpikeCube = CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.0F, -8.0F, -3.0F, 2.0F, 4.0F, 6.0F);
/* 206 */     if (properties.middleTailScales()) {
/* 207 */       tail.m_171599_("middle_tail_scale", tailSpikeCube, PartPose.f_171404_);
/*     */     } else {
/*     */       
/* 210 */       tail.m_171599_("left_tail_scale", tailSpikeCube, PartPose.m_171430_(0.0F, 0.0F, 0.785398F));
/* 211 */       tail.m_171599_("right_tail_scale", tailSpikeCube, PartPose.m_171430_(0.0F, 0.0F, -0.785398F));
/*     */     } 
/*     */     
/* 214 */     if (properties.tailHorns()) addTailSpikes(tail);
/*     */   
/*     */   }
/*     */   
/*     */   private static void addTailSpikes(PartDefinition tail) {
/* 219 */     int hornThick = 3;
/* 220 */     int hornLength = 32;
/*     */     
/* 222 */     float hornOfs = -(hornThick / 2.0F);
/*     */     
/* 224 */     float hornPosX = 0.0F;
/* 225 */     float hornPosY = hornOfs;
/* 226 */     float hornPosZ = 5.0F;
/*     */     
/* 228 */     float hornRotX = -0.261799F;
/* 229 */     float hornRotY = -2.53073F;
/* 230 */     float hornRotZ = 0.0F;
/*     */     
/* 232 */     tail.m_171599_("right_tail_spike", 
/* 233 */         CubeListBuilder.m_171558_().m_171514_(0, 117).m_171481_(hornOfs, hornOfs, hornOfs, hornThick, hornThick, hornLength), 
/* 234 */         PartPose.m_171423_(hornPosX, hornPosY, hornPosZ, hornRotX, hornRotY, hornRotZ));
/* 235 */     tail.m_171599_("left_tail_spike", 
/* 236 */         CubeListBuilder.m_171558_().m_171514_(0, 117).m_171480_().m_171481_(hornOfs, hornOfs, hornOfs, hornThick, hornThick, hornLength), 
/* 237 */         PartPose.m_171423_(hornPosX * -1.0F, hornPosY, hornPosZ, hornRotX, hornRotY * -1.0F, hornRotZ));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void buildWings(PartDefinition root) {
/* 242 */     buildWing(root, false);
/* 243 */     buildWing(root, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void buildWing(PartDefinition root, boolean mirror) {
/* 248 */     String direction = mirror ? "left_" : "right_";
/*     */     
/* 250 */     CubeListBuilder wingArmCube = CubeListBuilder.m_171558_().m_171555_(mirror);
/* 251 */     centerMirroredBox(wingArmCube.m_171514_(0, 152), mirror, -28.0F, -3.0F, -3.0F, 28.0F, 6.0F, 6.0F);
/* 252 */     centerMirroredBox(wingArmCube.m_171514_(116, 232), mirror, -28.0F, 0.0F, 2.0F, 28.0F, 0.0F, 24.0F);
/*     */     
/* 254 */     CubeListBuilder foreArmCube = centerMirroredBox(CubeListBuilder.m_171558_().m_171555_(mirror).m_171514_(0, 164), mirror, -48.0F, -2.0F, -2.0F, 48.0F, 4.0F, 4.0F);
/*     */     
/* 256 */     CubeListBuilder shortSkinCube = CubeListBuilder.m_171558_().m_171555_(mirror);
/* 257 */     centerMirroredBox(shortSkinCube.m_171514_(0, 172), mirror, -70.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F);
/* 258 */     centerMirroredBox(shortSkinCube.m_171514_(-49, 176), mirror, -70.0F, 0.0F, 1.0F, 70.0F, 0.0F, 48.0F);
/* 259 */     PartPose shortSkinPos = mirrorXPos(-47.0F, 0.0F, 0.0F, mirror);
/*     */     
/* 261 */     CubeListBuilder lastFingerCube = CubeListBuilder.m_171558_().m_171555_(mirror);
/* 262 */     centerMirroredBox(lastFingerCube.m_171514_(0, 172), mirror, -70.0F, -1.0F, -1.0F, 70.0F, 2.0F, 2.0F);
/* 263 */     centerMirroredBox(lastFingerCube.m_171514_(-32, 224), mirror, -70.0F, 0.0F, 1.0F, 70.0F, 0.0F, 32.0F);
/*     */     
/* 265 */     PartDefinition arm = root.m_171599_(direction + "wing_arm", wingArmCube, mirrorXPos(-10.0F, 5.0F, 4.0F, mirror));
/* 266 */     PartDefinition foreArm = arm.m_171599_(direction + "wing_forearm", foreArmCube, mirrorXPos(-28.0F, 0.0F, 0.0F, mirror));
/* 267 */     for (int j = 1; j < 4; ) { foreArm.m_171599_(direction + "wing_finger_" + direction, shortSkinCube, shortSkinPos); j++; }
/* 268 */      foreArm.m_171599_(direction + "wing_finger_4", lastFingerCube, shortSkinPos);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void buildLegs(PartDefinition root, Properties properties) {
/* 273 */     buildLeg(root, false, properties.thinLegs(), false);
/* 274 */     buildLeg(root, true, properties.thinLegs(), false);
/* 275 */     buildLeg(root, false, properties.thinLegs(), true);
/* 276 */     buildLeg(root, true, properties.thinLegs(), true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void buildLeg(PartDefinition root, boolean hind, boolean thin, boolean mirror) {
/* 281 */     float baseLength = 26.0F;
/* 282 */     String baseName = (mirror ? "left_" : "right_") + (mirror ? "left_" : "right_");
/*     */ 
/*     */     
/* 285 */     float thighPosX = -11.0F;
/* 286 */     float thighPosY = 18.0F;
/* 287 */     float thighPosZ = 4.0F;
/*     */     
/* 289 */     int thighThick = 9 - (thin ? 2 : 0);
/* 290 */     int thighLength = (int)(baseLength * (hind ? 0.9F : 0.77F));
/*     */     
/* 292 */     if (hind) {
/*     */       
/* 294 */       thighThick++;
/* 295 */       thighPosY -= 5.0F;
/*     */     } 
/*     */     
/* 298 */     float thighOfs = -(thighThick / 2.0F);
/*     */     
/* 300 */     PartDefinition thigh = root.m_171599_(baseName + "thigh", CubeListBuilder.m_171558_().m_171514_(112, hind ? 29 : 0).m_171481_(thighOfs, thighOfs, thighOfs, thighThick, thighLength, thighThick), mirrorXPos(thighPosX, thighPosY, thighPosZ, mirror));
/*     */ 
/*     */     
/* 303 */     float crusPosX = 0.0F;
/* 304 */     float crusPosY = thighLength + thighOfs;
/* 305 */     float crusPosZ = 0.0F;
/*     */     
/* 307 */     int crusThick = thighThick - 2;
/* 308 */     int crusLength = (int)(baseLength * (hind ? 0.7F : 0.8F));
/*     */     
/* 310 */     if (hind) {
/*     */       
/* 312 */       crusThick--;
/* 313 */       crusLength -= 2;
/*     */     } 
/*     */     
/* 316 */     float crusOfs = -(crusThick / 2.0F);
/*     */     
/* 318 */     PartDefinition crus = thigh.m_171599_(baseName + "crus", 
/* 319 */         CubeListBuilder.m_171558_().m_171514_(hind ? 152 : 148, hind ? 29 : 0).m_171481_(crusOfs, crusOfs, crusOfs, crusThick, crusLength, crusThick), 
/* 320 */         mirrorXPos(crusPosX, crusPosY, crusPosZ, mirror));
/*     */ 
/*     */     
/* 323 */     float footPosX = 0.0F;
/* 324 */     float footPosY = crusLength + crusOfs / 2.0F;
/* 325 */     float footPosZ = 0.0F;
/*     */     
/* 327 */     int footWidth = crusThick + 2 + (thin ? 2 : 0);
/* 328 */     int footHeight = 4;
/* 329 */     int footLength = (int)(baseLength * (hind ? 0.67F : 0.34F));
/*     */     
/* 331 */     float footOfsX = -(footWidth / 2.0F);
/* 332 */     float footOfsY = -(footHeight / 2.0F);
/* 333 */     float footOfsZ = footLength * -0.75F;
/*     */     
/* 335 */     PartDefinition foot = crus.m_171599_(baseName + "foot", 
/* 336 */         CubeListBuilder.m_171558_().m_171514_(hind ? 180 : 210, hind ? 29 : 0).m_171481_(footOfsX, footOfsY, footOfsZ, footWidth, footHeight, footLength), 
/* 337 */         mirrorXPos(footPosX, footPosY, footPosZ, mirror));
/*     */ 
/*     */     
/* 340 */     int toeWidth = footWidth;
/* 341 */     int toeHeight = footHeight;
/* 342 */     int toeLength = (int)(baseLength * (hind ? 0.27F : 0.33F));
/*     */     
/* 344 */     float toePosX = 0.0F;
/* 345 */     float toePosY = 0.0F;
/* 346 */     float toePosZ = footOfsZ - footOfsY / 2.0F;
/*     */     
/* 348 */     float toeOfsX = -(toeWidth / 2.0F);
/* 349 */     float toeOfsY = -(toeHeight / 2.0F);
/* 350 */     float toeOfsZ = -toeLength;
/*     */     
/* 352 */     foot.m_171599_(baseName + "toe", 
/* 353 */         CubeListBuilder.m_171558_().m_171514_(hind ? 215 : 176, hind ? 29 : 0).m_171481_(toeOfsX, toeOfsY, toeOfsZ, toeWidth, toeHeight, toeLength), 
/* 354 */         mirrorXPos(toePosX, toePosY, toePosZ, mirror));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepareMobModel(HerobrineDragonEntity dragon, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
/* 360 */     this.size = Math.min(dragon.m_6134_(), 1.0F);
/* 361 */     dragon.getAnimator().setPartialTicks(pPartialTick);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupAnim(HerobrineDragonEntity dragon, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
/* 367 */     DragonAnimator animator = dragon.getAnimator();
/* 368 */     animator.setLook(pNetHeadYaw, pHeadPitch);
/* 369 */     animator.setMovement(pLimbSwing, pLimbSwingAmount * dragon.m_6134_());
/* 370 */     dragon.getAnimator().animate(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_7695_(PoseStack ps, VertexConsumer vertices, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
/* 376 */     this.body.m_104306_(ps, vertices, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
/* 377 */     renderHead(ps, vertices, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
/* 378 */     for (ModelPartProxy proxy : this.neckProxy)
/* 379 */       proxy.render(ps, vertices, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha); 
/* 380 */     for (ModelPartProxy proxy : this.tailProxy)
/* 381 */       proxy.render(ps, vertices, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha); 
/* 382 */     renderWings(ps, vertices, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
/* 383 */     renderLegs(ps, vertices, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderHead(PoseStack ps, VertexConsumer vertices, int packedLight, int packedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
/* 388 */     float headScale = 1.4F / (this.size + 0.4F);
/*     */     
/* 390 */     ((ModelPartAccess)this.head).setRenderScale(headScale, headScale, headScale);
/* 391 */     this.head.m_104306_(ps, vertices, packedLight, packedOverlay, pRed, pGreen, pBlue, pAlpha);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderWings(PoseStack ps, VertexConsumer vertices, int packedLight, int packedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
/* 396 */     ps.m_85836_();
/* 397 */     ps.m_85841_(1.1F, 1.1F, 1.1F);
/* 398 */     this.wingArms[0].m_104306_(ps, vertices, packedLight, packedOverlay, pRed, pGreen, pBlue, pAlpha);
/* 399 */     this.wingArms[1].m_104306_(ps, vertices, packedLight, packedOverlay, pRed, pGreen, pBlue, pAlpha);
/* 400 */     ps.m_85849_();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderLegs(PoseStack ps, VertexConsumer vertices, int packedLight, int packedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
/* 405 */     for (ModelPart[] leg : this.legs) {
/* 406 */       leg[0].m_104306_(ps, vertices, packedLight, packedOverlay, pRed, pGreen, pBlue, pAlpha);
/*     */     }
/*     */   }
/*     */   
/*     */   private static CubeListBuilder centerMirroredBox(CubeListBuilder builder, boolean mirror, float pOriginX, float pOriginY, float pOriginZ, float pDimensionX, float pDimensionY, float pDimensionZ) {
/* 411 */     if (mirror) pOriginX = 0.0F; 
/* 412 */     return builder.m_171481_(pOriginX, pOriginY, pOriginZ, pDimensionX, pDimensionY, pDimensionZ);
/*     */   }
/*     */ 
/*     */   
/*     */   private static PartPose mirrorXPos(float x, float y, float z, boolean mirror) {
/* 417 */     if (mirror) x = -x; 
/* 418 */     return PartPose.m_171419_(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private static ModelPart getNullableChild(ModelPart parent, String child) {
/*     */     try {
/* 429 */       return parent.m_171324_(child);
/*     */     }
/* 431 */     catch (NoSuchElementException ignore) {
/*     */       
/* 433 */       return null;
/*     */     } 
/*     */   }
/*     */   public static final class Properties extends Record { private final boolean middleTailScales; private final boolean tailHorns; private final boolean thinLegs;
/* 437 */     public Properties(boolean middleTailScales, boolean tailHorns, boolean thinLegs) { this.middleTailScales = middleTailScales; this.tailHorns = tailHorns; this.thinLegs = thinLegs; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/client/model/ModelHerobrineDragon$Properties;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #437	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/* 437 */       //   0	7	0	this	Lcom/pla/annoyingvillagers/client/model/ModelHerobrineDragon$Properties; } public boolean middleTailScales() { return this.middleTailScales; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/client/model/ModelHerobrineDragon$Properties;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #437	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lcom/pla/annoyingvillagers/client/model/ModelHerobrineDragon$Properties; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/client/model/ModelHerobrineDragon$Properties;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #437	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lcom/pla/annoyingvillagers/client/model/ModelHerobrineDragon$Properties;
/* 437 */       //   0	8	1	o	Ljava/lang/Object; } public boolean tailHorns() { return this.tailHorns; } public boolean thinLegs() { return this.thinLegs; }
/*     */     
/* 439 */     public static final Properties STANDARD = new Properties(true, false, false); public static final Codec<Properties> CODEC;
/*     */     static {
/* 441 */       CODEC = RecordCodecBuilder.create(func -> func.group((App)Codec.BOOL.optionalFieldOf("middle_tail_scales", Boolean.valueOf(true)).forGetter(Properties::middleTailScales), (App)Codec.BOOL.optionalFieldOf("tail_horns", Boolean.valueOf(false)).forGetter(Properties::tailHorns), (App)Codec.BOOL.optionalFieldOf("thin_legs", Boolean.valueOf(false)).forGetter(Properties::thinLegs)).apply((Applicative)func, Properties::new));
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\model\ModelHerobrineDragon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */