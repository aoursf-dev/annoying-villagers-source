/*     */ package com.pla.annoyingvillagers.client.renderer;
/*     */ 
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import com.mojang.math.Axis;
/*     */ import com.pla.annoyingvillagers.client.model.ModelSnakeBlade;
/*     */ import com.pla.annoyingvillagers.client.model.ModelSnakeBladeFragment;
/*     */ import com.pla.annoyingvillagers.entity.SnakeBladeEntity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.util.SnakeBladeHit;
/*     */ import java.util.function.DoubleFunction;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.client.renderer.LevelRenderer;
/*     */ import net.minecraft.client.renderer.MultiBufferSource;
/*     */ import net.minecraft.client.renderer.RenderType;
/*     */ import net.minecraft.client.renderer.culling.Frustum;
/*     */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*     */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*     */ import net.minecraft.client.renderer.entity.ItemRenderer;
/*     */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Vec3i;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.HumanoidArm;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.BlockAndTintGetter;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class SnakeBladeRenderer
/*     */   extends EntityRenderer<SnakeBladeEntity> {
/*  38 */   private static final ResourceLocation SNAKE_BLADE_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/snake_blade.png");
/*     */   
/*  40 */   private static final ResourceLocation FRAGMENT_CHAIN_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/fragment_chain.png");
/*     */   
/*     */   public static final int MAX_NECK_SEGMENTS = 128;
/*     */   
/*     */   private static final float FRAGMENT_LENGTH = 0.45F;
/*     */   private static final float HEAD_CLEAR = 0.35F;
/*     */   private final ModelSnakeBlade<SnakeBladeEntity> snakeBladeModel;
/*     */   private final ModelSnakeBladeFragment<SnakeBladeEntity> fragmentModel;
/*     */   
/*     */   public SnakeBladeRenderer(EntityRendererProvider.Context context) {
/*  50 */     super(context);
/*     */     
/*  52 */     ModelPart fragmentRoot = context.m_174023_(ModelSnakeBladeFragment.LAYER_LOCATION);
/*  53 */     this.fragmentModel = new ModelSnakeBladeFragment(fragmentRoot);
/*     */     
/*  55 */     ModelPart bladeRoot = context.m_174023_(ModelSnakeBlade.LAYER_LOCATION);
/*  56 */     this.snakeBladeModel = new ModelSnakeBlade(bladeRoot);
/*     */   }
/*     */   
/*     */   private static float tipClear(SnakeBladeEntity snakeBladeEntity) {
/*  60 */     return (snakeBladeEntity.hasBlade() || snakeBladeEntity.isRetracting()) ? 0.35F : 0.0F;
/*     */   }
/*     */   
/*     */   private static VertexConsumer getEntityConsumer(MultiBufferSource buffer, ResourceLocation texture, boolean enchanted) {
/*  64 */     RenderType renderType = RenderType.m_110458_(texture);
/*  65 */     return enchanted ? 
/*  66 */       ItemRenderer.m_115211_(buffer, renderType, true, true) : 
/*  67 */       buffer.m_6299_(renderType);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldRender(SnakeBladeEntity snakeBladeEntity, @NotNull Frustum frustum, double x, double y, double z) {
/*  72 */     Entity fromEntity = snakeBladeEntity.getFromEntity();
/*  73 */     if (fromEntity != null && frustum.m_113029_(snakeBladeEntity.m_20191_().m_82367_(fromEntity.m_20191_()))) {
/*  74 */       return true;
/*     */     }
/*  76 */     return super.m_5523_((Entity)snakeBladeEntity, frustum, x, y, z);
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
/*     */   public void render(@NotNull SnakeBladeEntity snakeBladeEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
/*  88 */     super.m_7392_((Entity)snakeBladeEntity, entityYaw, partialTicks, poseStack, buffer, packedLight);
/*     */     
/*  90 */     poseStack.m_85836_();
/*     */     try {
/*  92 */       Entity fromEntity = snakeBladeEntity.getFromEntity();
/*  93 */       if (fromEntity == null)
/*     */         return; 
/*  95 */       double x = Mth.m_14139_(partialTicks, snakeBladeEntity.f_19854_, snakeBladeEntity.m_20185_());
/*  96 */       double y = Mth.m_14139_(partialTicks, snakeBladeEntity.f_19855_, snakeBladeEntity.m_20186_());
/*  97 */       double z = Mth.m_14139_(partialTicks, snakeBladeEntity.f_19856_, snakeBladeEntity.m_20189_());
/*     */ 
/*     */       
/* 100 */       float progress = (snakeBladeEntity.prevProgress + (snakeBladeEntity.getProgress() - snakeBladeEntity.prevProgress) * partialTicks) / 5.0F;
/*     */ 
/*     */       
/* 103 */       float tipOffset = snakeBladeEntity.isGuard() ? 1.8F : 2.2F;
/* 104 */       Vec3 swordPos = SnakeBladeHit.getToolTipPos(fromEntity, partialTicks, tipOffset);
/*     */ 
/*     */ 
/*     */       
/* 108 */       Vec3 distVec = (swordPos != null) ? swordPos.m_82492_(x, y + 1.2000000476837158D, z) : getPositionOfPriorMob(snakeBladeEntity, fromEntity, partialTicks).m_82492_(x, y, z);
/*     */       
/* 110 */       Vec3 to = distVec.m_82490_((1.0F - progress));
/*     */       
/* 112 */       VertexConsumer fragmentConsumer = getEntityConsumer(buffer, FRAGMENT_CHAIN_TEXTURE, snakeBladeEntity.isEnchanted());
/*     */       
/* 114 */       int segmentCount = 0;
/* 115 */       Vec3 currentNeckButt = distVec;
/*     */       
/* 117 */       if (snakeBladeEntity.isGuard()) {
/* 118 */         double distanceLeft = distVec.m_82554_(to);
/* 119 */         double buildUpTo = Math.max(0.0D, distanceLeft - tipClear(snakeBladeEntity));
/*     */         
/* 121 */         while (segmentCount < 128 && buildUpTo > 0.001D) {
/* 122 */           double step = Math.min(buildUpTo, 0.44999998807907104D);
/*     */           
/* 124 */           Vec3 dir = to.m_82546_(currentNeckButt);
/* 125 */           Vec3 next = dir.m_82541_().m_82490_(step).m_82549_(currentNeckButt);
/*     */           
/* 127 */           int neckLight = getLightColor((Entity)snakeBladeEntity, next.m_82520_(x, y, z));
/* 128 */           renderNeckCube(currentNeckButt, next, poseStack, fragmentConsumer, neckLight, 0.0F);
/*     */           
/* 130 */           currentNeckButt = next;
/* 131 */           buildUpTo -= step;
/* 132 */           segmentCount++;
/*     */         } 
/*     */       } else {
/* 135 */         double distanceLeft = distVec.m_82554_(to);
/* 136 */         double buildUpTo = Math.max(0.0D, distanceLeft - tipClear(snakeBladeEntity));
/*     */         
/* 138 */         if (distanceLeft > 1.0E-4D) {
/* 139 */           Vec3 fromW = (new Vec3(x, y, z)).m_82549_(distVec);
/* 140 */           Vec3 toW = (new Vec3(x, y, z)).m_82549_(to);
/*     */           
/* 142 */           Vec3 fwd = toW.m_82546_(fromW).m_82541_();
/* 143 */           Vec3 right = new Vec3(fwd.f_82481_, 0.0D, -fwd.f_82479_);
/* 144 */           if (right.m_82556_() < 1.0E-6D) right = new Vec3(1.0D, 0.0D, 0.0D); 
/* 145 */           right = right.m_82541_();
/*     */           
/* 147 */           double ampSide = Mth.m_14008_(distanceLeft * 0.18D, 0.25D, 2.0D);
/* 148 */           double ampUp = Mth.m_14008_(distanceLeft * 0.1D, 0.0D, 1.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 153 */           long seed = snakeBladeEntity.m_19879_() << 32L ^ snakeBladeEntity.getFromEntityID() << 16L ^ snakeBladeEntity.getToEntityID() ^ 0x9E3779B97F4A7C15L;
/*     */ 
/*     */           
/* 156 */           RandomSource rand = RandomSource.m_216335_(seed);
/* 157 */           double sideSign = rand.m_188499_() ? 1.0D : -1.0D;
/*     */           
/* 159 */           double time = snakeBladeEntity.f_19797_ + partialTicks;
/* 160 */           double phase1 = rand.m_188500_() * Math.PI * 2.0D;
/* 161 */           double phase2 = rand.m_188500_() * Math.PI * 2.0D;
/* 162 */           double phaseYaw = rand.m_188500_() * Math.PI * 2.0D;
/*     */           
/* 164 */           double jitterSideBase = 0.05D;
/* 165 */           double jitterUpBase = 0.03D;
/*     */           
/* 167 */           Vec3 finalRight = right;
/*     */           
/* 169 */           DoubleFunction<Vec3> wavePoint = s -> {
/*     */               double u = s / distanceLeft;
/*     */ 
/*     */               
/*     */               double sin = Math.sin(Math.PI * u);
/*     */               
/*     */               Vec3 base = fromW.m_82549_(fwd.m_82490_(s)).m_82549_(finalRight.m_82490_(ampSide * sideSign * sin)).m_82520_(0.0D, ampUp * sin, 0.0D);
/*     */               
/*     */               double w1 = 20.0D;
/*     */               
/*     */               double w2 = 17.0D;
/*     */               
/*     */               double headBias = Math.pow(sin, 0.8D);
/*     */               
/*     */               double jitterSide = jitterSideBase * (0.6D + 0.8D * headBias) * Math.sin(w1 * time + 28.0D * u + phase1);
/*     */               
/*     */               double jitterUp = jitterUpBase * (0.5D + 0.7D * headBias) * Math.sin(w2 * time + 19.0D * u + phase2);
/*     */               
/*     */               return base.m_82549_(finalRight.m_82490_(jitterSide)).m_82520_(0.0D, jitterUp, 0.0D);
/*     */             };
/*     */           
/* 190 */           double s = 0.0D;
/* 191 */           Vec3 prevW = wavePoint.apply(s);
/*     */           
/* 193 */           while (segmentCount < 128 && buildUpTo > 0.001D) {
/* 194 */             double step = Math.min(buildUpTo, 0.44999998807907104D);
/* 195 */             s += step;
/*     */             
/* 197 */             Vec3 nextW = wavePoint.apply(Math.min(s, distanceLeft - 0.3499999940395355D));
/*     */             
/* 199 */             Vec3 prevLocal = prevW.m_82492_(x, y, z);
/* 200 */             Vec3 nextLocal = nextW.m_82492_(x, y, z);
/*     */             
/* 202 */             int neckLight = getLightColor((Entity)snakeBladeEntity, nextW);
/*     */             
/* 204 */             float yawShake = (float)(4.0D * Math.sin(18.0D * time + 0.9D * segmentCount + phaseYaw));
/* 205 */             renderNeckCube(prevLocal, nextLocal, poseStack, fragmentConsumer, neckLight, yawShake);
/*     */             
/* 207 */             prevW = nextW;
/* 208 */             buildUpTo -= step;
/* 209 */             segmentCount++;
/*     */           } 
/*     */           
/* 212 */           currentNeckButt = prevW.m_82492_(x, y, z);
/*     */         } else {
/* 214 */           double time = snakeBladeEntity.f_19797_ + partialTicks;
/*     */           
/* 216 */           while (segmentCount < 128 && buildUpTo > 0.001D) {
/* 217 */             double step = Math.min(buildUpTo, 0.44999998807907104D);
/*     */             
/* 219 */             Vec3 dir = to.m_82546_(currentNeckButt);
/* 220 */             Vec3 next = dir.m_82541_().m_82490_(step).m_82549_(currentNeckButt);
/*     */             
/* 222 */             int neckLight = getLightColor((Entity)snakeBladeEntity, next.m_82520_(x, y, z));
/* 223 */             float yawShake = (float)(3.0D * Math.sin(16.0D * time + 0.7D * segmentCount));
/*     */             
/* 225 */             renderNeckCube(currentNeckButt, next, poseStack, fragmentConsumer, neckLight, yawShake);
/*     */             
/* 227 */             currentNeckButt = next;
/* 228 */             buildUpTo -= step;
/* 229 */             segmentCount++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 234 */       VertexConsumer bladeConsumer = getEntityConsumer(buffer, SNAKE_BLADE_TEXTURE, snakeBladeEntity.isEnchanted());
/*     */       
/* 236 */       if (snakeBladeEntity.hasBlade() || snakeBladeEntity.isRetracting()) {
/* 237 */         poseStack.m_85836_();
/* 238 */         poseStack.m_85837_(to.f_82479_, to.f_82480_, to.f_82481_);
/*     */         
/* 240 */         Vec3 headDir = to.m_82546_(currentNeckButt);
/* 241 */         float rotY = (float)(Mth.m_14136_(headDir.f_82479_, headDir.f_82481_) * 180.0D / Math.PI);
/* 242 */         float rotX = (float)(-Mth.m_14136_(headDir.f_82480_, headDir.m_165924_()) * 180.0D / Math.PI);
/*     */         
/* 244 */         poseStack.m_252781_(Axis.f_252436_.m_252977_(rotY));
/* 245 */         poseStack.m_252781_(Axis.f_252529_.m_252977_(rotX));
/*     */         
/* 247 */         double time = snakeBladeEntity.f_19797_ + partialTicks;
/* 248 */         float headYawWobble = (float)(1.6D * Math.sin(22.0D * time + 0.5D));
/* 249 */         float headPitchWobble = (float)Math.sin(27.0D * time + 1.2D);
/* 250 */         poseStack.m_252781_(Axis.f_252436_.m_252977_(headYawWobble));
/* 251 */         poseStack.m_252781_(Axis.f_252529_.m_252977_(headPitchWobble));
/*     */         
/* 253 */         int headLight = getLightColor((Entity)snakeBladeEntity, to.m_82520_(x, y, z));
/* 254 */         this.snakeBladeModel.m_7695_(poseStack, bladeConsumer, headLight, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/* 256 */         poseStack.m_85849_();
/*     */       } 
/*     */     } finally {
/* 259 */       poseStack.m_85849_();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderNeckCube(Vec3 from, Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, float additionalYaw) {
/* 265 */     Vec3 dir = to.m_82546_(from);
/*     */     
/* 267 */     float yaw = (float)(Mth.m_14136_(dir.f_82479_, dir.f_82481_) * 57.29577951308232D);
/* 268 */     float pitch = (float)(-Mth.m_14136_(dir.f_82480_, dir.m_165924_()) * 57.29577951308232D);
/*     */     
/* 270 */     poseStack.m_85836_();
/* 271 */     poseStack.m_85837_(from.f_82479_, from.f_82480_, from.f_82481_);
/* 272 */     poseStack.m_252781_(Axis.f_252436_.m_252977_(yaw + additionalYaw));
/* 273 */     poseStack.m_252781_(Axis.f_252529_.m_252977_(pitch));
/*     */     
/* 275 */     this.fragmentModel.m_7695_(poseStack, buffer, packedLightIn, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
/* 276 */     poseStack.m_85849_();
/*     */   }
/*     */   
/*     */   private Vec3 getPositionOfPriorMob(SnakeBladeEntity snakeBladeEntity, Entity fromEntity, float partialTicks) {
/* 280 */     double x = Mth.m_14139_(partialTicks, fromEntity.f_19854_, fromEntity.m_20185_());
/* 281 */     double y = Mth.m_14139_(partialTicks, fromEntity.f_19855_, fromEntity.m_20186_());
/* 282 */     double z = Mth.m_14139_(partialTicks, fromEntity.f_19856_, fromEntity.m_20189_());
/*     */     
/* 284 */     float yOffset = 0.0F;
/*     */     
/* 286 */     if (fromEntity instanceof Player) { Player player = (Player)fromEntity; if (snakeBladeEntity.isCreator(fromEntity)) {
/* 287 */         float swing = player.m_21324_(partialTicks);
/* 288 */         float swingSin = Mth.m_14031_(Mth.m_14116_(swing) * 3.1415927F);
/* 289 */         float bodyYaw = Mth.m_14179_(partialTicks, player.f_20884_, player.f_20883_) * 0.017453292F;
/*     */         
/* 291 */         int armSign = (player.m_5737_() == HumanoidArm.RIGHT) ? 1 : -1;
/*     */         
/* 293 */         ItemStack mainHand = player.m_21205_();
/* 294 */         if (!mainHand.m_150930_((Item)AnnoyingVillagersModItems.DEMONIAC_VOLTAGE_REAVER.get())) {
/* 295 */           armSign = -armSign;
/*     */         }
/*     */         
/* 298 */         double sin = Mth.m_14031_(bodyYaw);
/* 299 */         double cos = Mth.m_14089_(bodyYaw);
/* 300 */         double armOffset = armSign * 0.35D;
/*     */         
/* 302 */         if (this.f_114476_.f_114360_.m_92176_().m_90612_() && player == (Minecraft.m_91087_()).f_91074_) {
/* 303 */           double fovScale = 960.0D / ((Integer)this.f_114476_.f_114360_.m_231837_().m_231551_()).intValue();
/*     */           
/* 305 */           Vec3 nearPlane = this.f_114476_.f_114358_.m_167684_().m_167695_(armSign * 0.6F, -1.0F);
/* 306 */           nearPlane = nearPlane.m_82490_(fovScale);
/* 307 */           nearPlane = nearPlane.m_82524_(swingSin * 0.25F);
/* 308 */           nearPlane = nearPlane.m_82496_(-swingSin * 0.35F);
/*     */           
/* 310 */           x = Mth.m_14139_(partialTicks, player.f_19854_, player.m_20185_()) + nearPlane.f_82479_;
/* 311 */           y = Mth.m_14139_(partialTicks, player.f_19855_, player.m_20186_()) + nearPlane.f_82480_;
/* 312 */           z = Mth.m_14139_(partialTicks, player.f_19856_, player.m_20189_()) + nearPlane.f_82481_;
/* 313 */           yOffset = player.m_20192_() * 0.5F;
/*     */         } else {
/* 315 */           x = Mth.m_14139_(partialTicks, player.f_19854_, player.m_20185_()) - cos * armOffset - sin * 0.2D;
/* 316 */           y = player.f_19855_ + player.m_20192_() + (player.m_20186_() - player.f_19855_) * partialTicks - 1.0D;
/* 317 */           z = Mth.m_14139_(partialTicks, player.f_19856_, player.m_20189_()) - sin * armOffset + cos * 0.2D;
/* 318 */           yOffset = (player.m_6047_() ? -0.1875F : 0.0F) - player.m_20192_() * 0.4F;
/*     */         } 
/*     */       }  }
/*     */     
/* 322 */     return new Vec3(x, y + yOffset, z);
/*     */   }
/*     */   
/*     */   private int getLightColor(Entity entity, Vec3 pos) {
/* 326 */     Vec3i blockPosInt = new Vec3i(Mth.m_14107_(pos.f_82479_), Mth.m_14107_(pos.f_82480_), Mth.m_14107_(pos.f_82481_));
/* 327 */     BlockPos blockPos = new BlockPos(blockPosInt);
/*     */     
/* 329 */     if (!entity.m_9236_().m_46805_(blockPos)) return 0;
/*     */     
/* 331 */     int packedBelow = LevelRenderer.m_109541_((BlockAndTintGetter)entity.m_9236_(), blockPos);
/* 332 */     int packedAbove = LevelRenderer.m_109541_((BlockAndTintGetter)entity.m_9236_(), blockPos.m_7494_());
/*     */     
/* 334 */     int block = Math.max(packedBelow & 0xFF, packedAbove & 0xFF);
/* 335 */     int sky = Math.max(packedBelow >> 16 & 0xFF, packedAbove >> 16 & 0xFF);
/*     */     
/* 337 */     return block | sky << 16;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public ResourceLocation getTextureLocation(@NotNull SnakeBladeEntity snakeBladeEntity) {
/* 342 */     return SNAKE_BLADE_TEXTURE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\SnakeBladeRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */