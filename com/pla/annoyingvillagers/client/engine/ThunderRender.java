/*     */ package com.pla.annoyingvillagers.client.engine;
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.MultiBufferSource;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ import org.joml.Matrix4f;
/*     */ import org.joml.Vector4f;
/*     */ 
/*     */ public class ThunderRender {
/*     */   private static final float REFRESH_TIME = 3.0F;
/*     */   private static final double MAX_OWNER_TRACK_TIME = 100.0D;
/*  22 */   private Timestamp refreshTimestamp = new Timestamp();
/*     */   
/*  24 */   private final Random random = new Random();
/*  25 */   private final Minecraft minecraft = Minecraft.m_91087_();
/*     */   
/*  27 */   private final Map<Object, BoltOwnerData> boltOwners = (Map<Object, BoltOwnerData>)new Object2ObjectOpenHashMap();
/*     */   
/*     */   public void render(float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn) {
/*  30 */     VertexConsumer buffer = bufferIn.m_6299_(RenderType.m_110502_());
/*  31 */     Matrix4f matrix = matrixStackIn.m_85850_().m_252922_();
/*  32 */     assert this.minecraft.f_91073_ != null;
/*  33 */     Timestamp timestamp = new Timestamp(this.minecraft.f_91073_.m_46467_(), partialTicks);
/*  34 */     boolean refresh = timestamp.isPassed(this.refreshTimestamp, 0.3333333432674408D);
/*  35 */     if (refresh) {
/*  36 */       this.refreshTimestamp = timestamp;
/*     */     }
/*  38 */     for (Iterator<Map.Entry<Object, BoltOwnerData>> iter = this.boltOwners.entrySet().iterator(); iter.hasNext(); ) {
/*  39 */       Map.Entry<Object, BoltOwnerData> entry = iter.next();
/*  40 */       BoltOwnerData data = entry.getValue();
/*  41 */       if (refresh) {
/*  42 */         data.bolts.removeIf(bolt -> bolt.tick(timestamp));
/*     */       }
/*  44 */       if (data.bolts.isEmpty() && data.lastBolt != null && data.lastBolt.getSpawnFunction().isConsecutive()) {
/*  45 */         data.addBolt(new ThunderInstance(data.lastBolt, timestamp), timestamp);
/*     */       }
/*  47 */       data.bolts.forEach(bolt -> bolt.render(matrix, buffer, timestamp));
/*     */       
/*  49 */       if (data.bolts.isEmpty() && timestamp.isPassed(data.lastUpdateTimestamp, 100.0D)) {
/*  50 */         iter.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void update(Object owner, ThunderData newBoltData, float partialTicks) {
/*  56 */     if (this.minecraft.f_91073_ == null) {
/*     */       return;
/*     */     }
/*  59 */     BoltOwnerData data = this.boltOwners.computeIfAbsent(owner, o -> new BoltOwnerData());
/*  60 */     data.lastBolt = newBoltData;
/*  61 */     Timestamp timestamp = new Timestamp(this.minecraft.f_91073_.m_46467_(), partialTicks);
/*  62 */     if ((!data.lastBolt.getSpawnFunction().isConsecutive() || data.bolts.isEmpty()) && timestamp.isPassed(data.lastBoltTimestamp, data.lastBoltDelay)) {
/*  63 */       data.addBolt(new ThunderInstance(newBoltData, timestamp), timestamp);
/*     */     }
/*  65 */     data.lastUpdateTimestamp = timestamp;
/*     */   }
/*     */   
/*     */   public class BoltOwnerData
/*     */   {
/*  70 */     private final Set<ThunderRender.ThunderInstance> bolts = (Set<ThunderRender.ThunderInstance>)new ObjectOpenHashSet();
/*     */     private ThunderRender.ThunderData lastBolt;
/*  72 */     private ThunderRender.Timestamp lastBoltTimestamp = new ThunderRender.Timestamp();
/*  73 */     private ThunderRender.Timestamp lastUpdateTimestamp = new ThunderRender.Timestamp();
/*     */     private double lastBoltDelay;
/*     */     
/*     */     private void addBolt(ThunderRender.ThunderInstance instance, ThunderRender.Timestamp timestamp) {
/*  77 */       this.bolts.add(instance);
/*  78 */       this.lastBoltDelay = instance.bolt.getSpawnFunction().getSpawnDelay(ThunderRender.this.random);
/*  79 */       this.lastBoltTimestamp = timestamp;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ThunderInstance {
/*     */     private final ThunderRender.ThunderData bolt;
/*     */     private final List<ThunderRender.ThunderData.BoltQuads> renderQuads;
/*     */     private final ThunderRender.Timestamp createdTimestamp;
/*     */     
/*     */     public ThunderInstance(ThunderRender.ThunderData bolt, ThunderRender.Timestamp timestamp) {
/*  89 */       this.bolt = bolt;
/*  90 */       this.renderQuads = bolt.generate();
/*  91 */       this.createdTimestamp = timestamp;
/*     */     }
/*     */     
/*     */     public void render(Matrix4f matrix, VertexConsumer buffer, ThunderRender.Timestamp timestamp) {
/*  95 */       float lifeScale = timestamp.subtract(this.createdTimestamp).value() / this.bolt.getLifespan();
/*  96 */       Pair<Integer, Integer> bounds = this.bolt.getFadeFunction().getRenderBounds(this.renderQuads.size(), lifeScale);
/*  97 */       for (int i = ((Integer)bounds.getLeft()).intValue(); i < ((Integer)bounds.getRight()).intValue(); i++) {
/*  98 */         ((ThunderRender.ThunderData.BoltQuads)this.renderQuads.get(i)).getVecs().forEach(v -> buffer.m_252986_(matrix, (float)v.f_82479_, (float)v.f_82480_, (float)v.f_82481_).m_85950_(this.bolt.getColor().x(), this.bolt.getColor().y(), this.bolt.getColor().z(), this.bolt.getColor().w()).m_5752_());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean tick(ThunderRender.Timestamp timestamp) {
/* 105 */       return timestamp.isPassed(this.createdTimestamp, this.bolt.getLifespan());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Timestamp
/*     */   {
/*     */     private final long ticks;
/*     */     private final float partial;
/*     */     
/*     */     public Timestamp() {
/* 115 */       this(0L, 0.0F);
/*     */     }
/*     */     
/*     */     public Timestamp(long ticks, float partial) {
/* 119 */       this.ticks = ticks;
/* 120 */       this.partial = partial;
/*     */     }
/*     */     
/*     */     public Timestamp subtract(Timestamp other) {
/* 124 */       long newTicks = this.ticks - other.ticks;
/* 125 */       float newPartial = this.partial - other.partial;
/* 126 */       if (newPartial < 0.0F) {
/* 127 */         newPartial++;
/* 128 */         newTicks--;
/*     */       } 
/* 130 */       return new Timestamp(newTicks, newPartial);
/*     */     }
/*     */     
/*     */     public float value() {
/* 134 */       return (float)this.ticks + this.partial;
/*     */     }
/*     */     
/*     */     public boolean isPassed(Timestamp prev, double duration) {
/* 138 */       long ticksPassed = this.ticks - prev.ticks;
/* 139 */       if (ticksPassed > duration)
/* 140 */         return true; 
/* 141 */       duration -= ticksPassed;
/* 142 */       if (duration >= 1.0D)
/* 143 */         return false; 
/* 144 */       return ((this.partial - prev.partial) >= duration);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ThunderData
/*     */   {
/* 150 */     private final Random random = new Random();
/*     */     
/*     */     private final ThunderRenderInfo renderInfo;
/*     */     
/*     */     private final Vec3 start;
/*     */     
/*     */     private final Vec3 end;
/*     */     
/*     */     private final int segments;
/* 159 */     private int count = 1;
/* 160 */     private float size = 0.1F;
/* 161 */     private int lifespan = 30;
/*     */     
/* 163 */     private SpawnFunction spawnFunction = SpawnFunction.delay(60.0F);
/* 164 */     private FadeFunction fadeFunction = FadeFunction.fade(0.5F);
/*     */     
/*     */     public ThunderData(Vec3 start, Vec3 end) {
/* 167 */       this(ThunderRenderInfo.DEFAULT, start, end, (int)Math.sqrt(start.m_82554_(end) * 100.0D));
/*     */     }
/*     */     
/*     */     public ThunderData(ThunderRenderInfo info, Vec3 start, Vec3 end, int segments) {
/* 171 */       this.renderInfo = info;
/* 172 */       this.start = start;
/* 173 */       this.end = end;
/* 174 */       this.segments = segments;
/*     */     }
/*     */     
/*     */     public ThunderData count(int count) {
/* 178 */       this.count = count;
/* 179 */       return this;
/*     */     }
/*     */     
/*     */     public ThunderData size(float size) {
/* 183 */       this.size = size;
/* 184 */       return this;
/*     */     }
/*     */     
/*     */     public ThunderData spawn(SpawnFunction spawnFunction) {
/* 188 */       this.spawnFunction = spawnFunction;
/* 189 */       return this;
/*     */     }
/*     */     
/*     */     public ThunderData fade(FadeFunction fadeFunction) {
/* 193 */       this.fadeFunction = fadeFunction;
/* 194 */       return this;
/*     */     }
/*     */     
/*     */     public ThunderData lifespan(int lifespan) {
/* 198 */       this.lifespan = lifespan;
/* 199 */       return this;
/*     */     }
/*     */     
/*     */     public int getLifespan() {
/* 203 */       return this.lifespan;
/*     */     }
/*     */     
/*     */     public SpawnFunction getSpawnFunction() {
/* 207 */       return this.spawnFunction;
/*     */     }
/*     */     
/*     */     public FadeFunction getFadeFunction() {
/* 211 */       return this.fadeFunction;
/*     */     }
/*     */     
/*     */     public Vector4f getColor() {
/* 215 */       return this.renderInfo.color;
/*     */     }
/*     */     
/*     */     public List<BoltQuads> generate() {
/* 219 */       List<BoltQuads> quads = new ArrayList<>();
/* 220 */       Vec3 diff = this.end.m_82546_(this.start);
/* 221 */       float totalDistance = (float)diff.m_82553_();
/* 222 */       for (int i = 0; i < this.count; i++) {
/* 223 */         LinkedList<BoltInstructions> drawQueue = new LinkedList<>();
/* 224 */         drawQueue.add(new BoltInstructions(this.start, 0.0F, new Vec3(0.0D, 0.0D, 0.0D), null, false));
/* 225 */         while (!drawQueue.isEmpty()) {
/* 226 */           Vec3 segmentEnd; BoltInstructions data = drawQueue.poll();
/* 227 */           Vec3 perpendicularDist = data.perpendicularDist;
/* 228 */           float progress = data.progress + 1.0F / this.segments * (1.0F - this.renderInfo.parallelNoise + this.random.nextFloat() * this.renderInfo.parallelNoise * 2.0F);
/*     */           
/* 230 */           if (progress >= 1.0F) {
/* 231 */             segmentEnd = this.end;
/*     */           } else {
/* 233 */             float segmentDiffScale = this.renderInfo.spreadFunction.getMaxSpread(progress);
/* 234 */             float maxDiff = this.renderInfo.spreadFactor * segmentDiffScale * totalDistance * this.renderInfo.randomFunction.getRandom(this.random);
/* 235 */             Vec3 randVec = findRandomOrthogonalVector(diff, this.random);
/* 236 */             perpendicularDist = this.renderInfo.segmentSpreader.getSegmentAdd(perpendicularDist, randVec, maxDiff, segmentDiffScale, progress);
/* 237 */             if (this.renderInfo.spreadFactor <= 1.0E-4F) {
/* 238 */               perpendicularDist = Vec3.f_82478_;
/*     */             }
/* 240 */             segmentEnd = this.start.m_82549_(diff.m_82490_(progress)).m_82549_(perpendicularDist);
/*     */           } 
/* 242 */           float boltSize = this.size * (0.5F + (1.0F - progress) * 0.5F);
/* 243 */           Pair<BoltQuads, QuadCache> quadData = createQuads(data.cache, data.start, segmentEnd, boltSize);
/* 244 */           quads.add((BoltQuads)quadData.getLeft());
/*     */           
/* 246 */           if (segmentEnd == this.end)
/*     */             break; 
/* 248 */           if (!data.isBranch) {
/* 249 */             drawQueue.add(new BoltInstructions(segmentEnd, progress, perpendicularDist, (QuadCache)quadData.getRight(), false));
/* 250 */           } else if (this.random.nextFloat() < this.renderInfo.branchContinuationFactor) {
/* 251 */             drawQueue.add(new BoltInstructions(segmentEnd, progress, perpendicularDist, (QuadCache)quadData.getRight(), true));
/*     */           } 
/*     */           
/* 254 */           while (this.random.nextFloat() < this.renderInfo.branchInitiationFactor * (1.0F - progress)) {
/* 255 */             drawQueue.add(new BoltInstructions(segmentEnd, progress, perpendicularDist, (QuadCache)quadData.getRight(), true));
/*     */           }
/*     */         } 
/*     */       } 
/* 259 */       return quads;
/*     */     }
/*     */     
/*     */     private static Vec3 findRandomOrthogonalVector(Vec3 vec, Random rand) {
/* 263 */       Vec3 newVec = new Vec3(-0.5D + rand.nextDouble(), -0.5D + rand.nextDouble(), -0.5D + rand.nextDouble());
/* 264 */       return vec.m_82537_(newVec).m_82541_();
/*     */     }
/*     */     
/*     */     private Pair<BoltQuads, QuadCache> createQuads(QuadCache cache, Vec3 startPos, Vec3 end, float size) {
/* 268 */       Vec3 diff = end.m_82546_(startPos);
/* 269 */       Vec3 rightAdd = diff.m_82537_(new Vec3(0.5D, 0.5D, 0.5D)).m_82541_().m_82490_(size);
/* 270 */       Vec3 backAdd = diff.m_82537_(rightAdd).m_82541_().m_82490_(size), rightAddSplit = rightAdd.m_82490_(0.5D);
/*     */       
/* 272 */       Vec3 start = (cache != null) ? cache.prevEnd : startPos;
/* 273 */       Vec3 startRight = (cache != null) ? cache.prevEndRight : start.m_82549_(rightAdd);
/* 274 */       Vec3 startBack = (cache != null) ? cache.prevEndBack : start.m_82549_(rightAddSplit).m_82549_(backAdd);
/* 275 */       Vec3 endRight = end.m_82549_(rightAdd), endBack = end.m_82549_(rightAddSplit).m_82549_(backAdd);
/*     */       
/* 277 */       BoltQuads quads = new BoltQuads();
/* 278 */       quads.addQuad(new Vec3[] { start, end, endRight, startRight });
/* 279 */       quads.addQuad(new Vec3[] { startRight, endRight, end, start });
/*     */       
/* 281 */       quads.addQuad(new Vec3[] { startRight, endRight, endBack, startBack });
/* 282 */       quads.addQuad(new Vec3[] { startBack, endBack, endRight, startRight });
/*     */       
/* 284 */       return Pair.of(quads, new QuadCache(end, endRight, endBack));
/*     */     }
/*     */     private static final class QuadCache extends Record { private final Vec3 prevEnd; private final Vec3 prevEndRight; private final Vec3 prevEndBack;
/* 287 */       private QuadCache(Vec3 prevEnd, Vec3 prevEndRight, Vec3 prevEndBack) { this.prevEnd = prevEnd; this.prevEndRight = prevEndRight; this.prevEndBack = prevEndBack; } public final String toString() { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;)Ljava/lang/String;
/*     */         //   6: areturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #287	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	7	0	this	Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache; } public final int hashCode() { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;)I
/*     */         //   6: ireturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #287	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	7	0	this	Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache; } public final boolean equals(Object o) { // Byte code:
/*     */         //   0: aload_0
/*     */         //   1: aload_1
/*     */         //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;Ljava/lang/Object;)Z
/*     */         //   7: ireturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #287	-> 0
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   0	8	0	this	Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;
/* 287 */         //   0	8	1	o	Ljava/lang/Object; } public Vec3 prevEnd() { return this.prevEnd; } public Vec3 prevEndRight() { return this.prevEndRight; } public Vec3 prevEndBack() { return this.prevEndBack; }
/*     */        }
/*     */ 
/*     */     
/*     */     protected static class BoltInstructions
/*     */     {
/*     */       private final Vec3 start;
/*     */       private final Vec3 perpendicularDist;
/*     */       private final ThunderRender.ThunderData.QuadCache cache;
/*     */       private final float progress;
/*     */       private final boolean isBranch;
/*     */       
/*     */       private BoltInstructions(Vec3 start, float progress, Vec3 perpendicularDist, ThunderRender.ThunderData.QuadCache cache, boolean isBranch) {
/* 300 */         this.start = start;
/* 301 */         this.perpendicularDist = perpendicularDist;
/* 302 */         this.progress = progress;
/* 303 */         this.cache = cache;
/* 304 */         this.isBranch = isBranch;
/*     */       }
/*     */     }
/*     */     
/*     */     public static class BoltQuads
/*     */     {
/* 310 */       private final List<Vec3> vecs = new ArrayList<>();
/*     */       
/*     */       protected void addQuad(Vec3... quadVecs) {
/* 313 */         this.vecs.addAll(Arrays.asList(quadVecs));
/*     */       }
/*     */       
/*     */       public List<Vec3> getVecs() {
/* 317 */         return this.vecs;
/*     */       } }
/*     */     public static interface SpreadFunction { public static final SpreadFunction DEFAULT = progress -> 1.0F;
/*     */       
/*     */       float getMaxSpread(float param2Float); }
/*     */     
/*     */     public static interface RandomFunction { public static final RandomFunction DEFAULT;
/*     */       
/*     */       float getRandom(Random param2Random);
/*     */       
/*     */       static {
/* 328 */         DEFAULT = (rand -> (float)rand.nextGaussian());
/*     */       } }
/*     */     
/*     */     public static interface SegmentSpreader { public static final SegmentSpreader DEFAULT;
/*     */       
/*     */       static {
/* 334 */         DEFAULT = ((perpendicularDist, randVec, maxDiff, scale, progress) -> randVec.m_82490_(maxDiff));
/*     */       } static SegmentSpreader memory(float memoryFactor) {
/* 336 */         return (perpendicularDist, randVec, maxDiff, spreadScale, progress) -> {
/*     */             float nextDiff = maxDiff * (1.0F - memoryFactor);
/*     */             Vec3 cur = randVec.m_82490_(nextDiff);
/*     */             if (progress > 0.5F) {
/*     */               float pull = (1.0F - spreadScale) * (1.0F - memoryFactor) * 0.35F;
/*     */               cur = cur.m_82549_(perpendicularDist.m_82490_(-pull));
/*     */             } 
/*     */             return perpendicularDist.m_82549_(cur);
/*     */           };
/*     */       }
/*     */       
/*     */       Vec3 getSegmentAdd(Vec3 param2Vec31, Vec3 param2Vec32, float param2Float1, float param2Float2, float param2Float3); }
/*     */ 
/*     */     
/*     */     public static interface SpawnFunction
/*     */     {
/*     */       public static final SpawnFunction DEFAULT = rand -> Pair.of(Float.valueOf(0.0F), Float.valueOf(0.0F));
/*     */       
/*     */       static SpawnFunction delay(float delay) {
/* 355 */         return rand -> Pair.of(Float.valueOf(delay), Float.valueOf(delay));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       default float getSpawnDelay(Random rand) {
/* 361 */         Pair<Float, Float> bounds = getSpawnDelayBounds(rand);
/* 362 */         return ((Float)bounds.getLeft()).floatValue() + (((Float)bounds.getRight()).floatValue() - ((Float)bounds.getLeft()).floatValue()) * rand.nextFloat();
/*     */       }
/*     */       
/*     */       default boolean isConsecutive() {
/* 366 */         return false;
/*     */       }
/*     */       Pair<Float, Float> getSpawnDelayBounds(Random param2Random); }
/*     */     public static interface FadeFunction { public static final FadeFunction NONE;
/*     */       static {
/* 371 */         NONE = ((totalBolts, lifeScale) -> Pair.of(Integer.valueOf(0), Integer.valueOf(totalBolts)));
/*     */       } static FadeFunction fade(float fade) {
/* 373 */         return (totalBolts, lifeScale) -> {
/*     */             int start = (lifeScale > 1.0F - fade) ? (int)(totalBolts * (lifeScale - 1.0F - fade) / fade) : 0;
/*     */             int end = (lifeScale < fade) ? (int)(totalBolts * lifeScale / fade) : totalBolts;
/*     */             return Pair.of(Integer.valueOf(start), Integer.valueOf(end));
/*     */           };
/*     */       }
/*     */       
/*     */       Pair<Integer, Integer> getRenderBounds(int param2Int, float param2Float); }
/*     */ 
/*     */     
/*     */     public static class ThunderRenderInfo
/*     */     {
/* 385 */       public static final ThunderRenderInfo DEFAULT = new ThunderRenderInfo();
/* 386 */       public static final ThunderRenderInfo DRAGON_THUNDER = dragonThunder();
/* 387 */       public static final ThunderRenderInfo BLUE_DEMON_THUNDER = blueDemonThunder();
/* 388 */       private float parallelNoise = 0.1F;
/* 389 */       private float spreadFactor = 0.0F;
/* 390 */       private float branchInitiationFactor = 0.0F;
/* 391 */       private float branchContinuationFactor = 0.0F;
/*     */       
/* 393 */       private Vector4f color = new Vector4f(0.45F, 0.45F, 0.5F, 0.8F);
/*     */       
/* 395 */       private final ThunderRender.ThunderData.RandomFunction randomFunction = ThunderRender.ThunderData.RandomFunction.DEFAULT;
/* 396 */       private final ThunderRender.ThunderData.SpreadFunction spreadFunction = ThunderRender.ThunderData.SpreadFunction.DEFAULT;
/* 397 */       private ThunderRender.ThunderData.SegmentSpreader segmentSpreader = ThunderRender.ThunderData.SegmentSpreader.DEFAULT;
/*     */       
/*     */       public static ThunderRenderInfo dragonThunder() {
/* 400 */         return new ThunderRenderInfo(0.15F, 0.025F, 0.0F, 0.0F, new Vector4f(0.85F, 0.55F, 1.0F, 0.85F), 0.8F);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public static ThunderRenderInfo blueDemonThunder() {
/* 411 */         return new ThunderRenderInfo(0.15F, 0.025F, 0.0F, 0.0F, new Vector4f(0.65F, 1.0F, 1.0F, 0.9F), 0.8F);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ThunderRenderInfo() {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public ThunderRenderInfo(float parallelNoise, float spreadFactor, float branchInitiationFactor, float branchContinuationFactor, Vector4f color, float closeness)
/*     */       {
/* 425 */         this.parallelNoise = parallelNoise;
/* 426 */         this.spreadFactor = spreadFactor;
/* 427 */         this.branchInitiationFactor = branchInitiationFactor;
/* 428 */         this.branchContinuationFactor = branchContinuationFactor;
/* 429 */         this.color = color;
/* 430 */         this.segmentSpreader = ThunderRender.ThunderData.SegmentSpreader.memory(closeness); } } } private static final class QuadCache extends Record { private final Vec3 prevEnd; private final Vec3 prevEndRight; private final Vec3 prevEndBack; private QuadCache(Vec3 prevEnd, Vec3 prevEndRight, Vec3 prevEndBack) { this.prevEnd = prevEnd; this.prevEndRight = prevEndRight; this.prevEndBack = prevEndBack; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #287	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #287	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #287	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;
/* 430 */       //   0	8	1	o	Ljava/lang/Object; } public Vec3 prevEnd() { return this.prevEnd; } public Vec3 prevEndRight() { return this.prevEndRight; } public Vec3 prevEndBack() { return this.prevEndBack; } } protected static class BoltInstructions { private final Vec3 start; private final Vec3 perpendicularDist; private final ThunderRender.ThunderData.QuadCache cache; private final float progress; private final boolean isBranch; private BoltInstructions(Vec3 start, float progress, Vec3 perpendicularDist, ThunderRender.ThunderData.QuadCache cache, boolean isBranch) { this.start = start; this.perpendicularDist = perpendicularDist; this.progress = progress; this.cache = cache; this.isBranch = isBranch; } } public static class BoltQuads { private final List<Vec3> vecs = new ArrayList<>(); protected void addQuad(Vec3... quadVecs) { this.vecs.addAll(Arrays.asList(quadVecs)); } public List<Vec3> getVecs() { return this.vecs; } } public static interface SpreadFunction { public static final SpreadFunction DEFAULT = progress -> 1.0F; float getMaxSpread(float param1Float); } public static interface RandomFunction { public static final RandomFunction DEFAULT; float getRandom(Random param1Random); static { DEFAULT = (rand -> (float)rand.nextGaussian()); } } public static interface SegmentSpreader { public static final SegmentSpreader DEFAULT; static { DEFAULT = ((perpendicularDist, randVec, maxDiff, scale, progress) -> randVec.m_82490_(maxDiff)); } static SegmentSpreader memory(float memoryFactor) { return (perpendicularDist, randVec, maxDiff, spreadScale, progress) -> { float nextDiff = maxDiff * (1.0F - memoryFactor); Vec3 cur = randVec.m_82490_(nextDiff); if (progress > 0.5F) { float pull = (1.0F - spreadScale) * (1.0F - memoryFactor) * 0.35F; cur = cur.m_82549_(perpendicularDist.m_82490_(-pull)); }  return perpendicularDist.m_82549_(cur); }; } Vec3 getSegmentAdd(Vec3 param1Vec31, Vec3 param1Vec32, float param1Float1, float param1Float2, float param1Float3); } public static interface SpawnFunction { public static final SpawnFunction DEFAULT = rand -> Pair.of(Float.valueOf(0.0F), Float.valueOf(0.0F)); static SpawnFunction delay(float delay) { return rand -> Pair.of(Float.valueOf(delay), Float.valueOf(delay)); } default float getSpawnDelay(Random rand) { Pair<Float, Float> bounds = getSpawnDelayBounds(rand); return ((Float)bounds.getLeft()).floatValue() + (((Float)bounds.getRight()).floatValue() - ((Float)bounds.getLeft()).floatValue()) * rand.nextFloat(); } default boolean isConsecutive() { return false; } Pair<Float, Float> getSpawnDelayBounds(Random param1Random); } public static interface FadeFunction { public static final FadeFunction NONE; static { NONE = ((totalBolts, lifeScale) -> Pair.of(Integer.valueOf(0), Integer.valueOf(totalBolts))); } static FadeFunction fade(float fade) { return (totalBolts, lifeScale) -> { int start = (lifeScale > 1.0F - fade) ? (int)(totalBolts * (lifeScale - 1.0F - fade) / fade) : 0; int end = (lifeScale < fade) ? (int)(totalBolts * lifeScale / fade) : totalBolts; return Pair.of(Integer.valueOf(start), Integer.valueOf(end)); }; } Pair<Integer, Integer> getRenderBounds(int param1Int, float param1Float); } public static class ThunderRenderInfo { public ThunderRenderInfo(float parallelNoise, float spreadFactor, float branchInitiationFactor, float branchContinuationFactor, Vector4f color, float closeness) { this.parallelNoise = parallelNoise; this.spreadFactor = spreadFactor; this.branchInitiationFactor = branchInitiationFactor; this.branchContinuationFactor = branchContinuationFactor; this.color = color; this.segmentSpreader = ThunderRender.ThunderData.SegmentSpreader.memory(closeness); }
/*     */ 
/*     */     
/*     */     public static final ThunderRenderInfo DEFAULT = new ThunderRenderInfo();
/*     */     public static final ThunderRenderInfo DRAGON_THUNDER = dragonThunder();
/*     */     public static final ThunderRenderInfo BLUE_DEMON_THUNDER = blueDemonThunder();
/*     */     private float parallelNoise = 0.1F;
/*     */     private float spreadFactor = 0.0F;
/*     */     private float branchInitiationFactor = 0.0F;
/*     */     private float branchContinuationFactor = 0.0F;
/*     */     private Vector4f color = new Vector4f(0.45F, 0.45F, 0.5F, 0.8F);
/*     */     private final ThunderRender.ThunderData.RandomFunction randomFunction = ThunderRender.ThunderData.RandomFunction.DEFAULT;
/*     */     private final ThunderRender.ThunderData.SpreadFunction spreadFunction = ThunderRender.ThunderData.SpreadFunction.DEFAULT;
/*     */     private ThunderRender.ThunderData.SegmentSpreader segmentSpreader = ThunderRender.ThunderData.SegmentSpreader.DEFAULT;
/*     */     
/*     */     public static ThunderRenderInfo dragonThunder() {
/*     */       return new ThunderRenderInfo(0.15F, 0.025F, 0.0F, 0.0F, new Vector4f(0.85F, 0.55F, 1.0F, 0.85F), 0.8F);
/*     */     }
/*     */     
/*     */     public static ThunderRenderInfo blueDemonThunder() {
/*     */       return new ThunderRenderInfo(0.15F, 0.025F, 0.0F, 0.0F, new Vector4f(0.65F, 1.0F, 1.0F, 0.9F), 0.8F);
/*     */     }
/*     */     
/*     */     public ThunderRenderInfo() {} }
/*     */ 
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\ThunderRender.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */