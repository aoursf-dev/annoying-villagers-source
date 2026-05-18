/*     */ package com.pla.annoyingvillagers.client.engine;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ import org.joml.Vector4f;
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
/*     */ 
/*     */ public class ThunderData
/*     */ {
/* 150 */   private final Random random = new Random();
/*     */   
/*     */   private final ThunderRenderInfo renderInfo;
/*     */   
/*     */   private final Vec3 start;
/*     */   
/*     */   private final Vec3 end;
/*     */   
/*     */   private final int segments;
/* 159 */   private int count = 1;
/* 160 */   private float size = 0.1F;
/* 161 */   private int lifespan = 30;
/*     */   
/* 163 */   private SpawnFunction spawnFunction = SpawnFunction.delay(60.0F);
/* 164 */   private FadeFunction fadeFunction = FadeFunction.fade(0.5F);
/*     */   
/*     */   public ThunderData(Vec3 start, Vec3 end) {
/* 167 */     this(ThunderRenderInfo.DEFAULT, start, end, (int)Math.sqrt(start.m_82554_(end) * 100.0D));
/*     */   }
/*     */   
/*     */   public ThunderData(ThunderRenderInfo info, Vec3 start, Vec3 end, int segments) {
/* 171 */     this.renderInfo = info;
/* 172 */     this.start = start;
/* 173 */     this.end = end;
/* 174 */     this.segments = segments;
/*     */   }
/*     */   
/*     */   public ThunderData count(int count) {
/* 178 */     this.count = count;
/* 179 */     return this;
/*     */   }
/*     */   
/*     */   public ThunderData size(float size) {
/* 183 */     this.size = size;
/* 184 */     return this;
/*     */   }
/*     */   
/*     */   public ThunderData spawn(SpawnFunction spawnFunction) {
/* 188 */     this.spawnFunction = spawnFunction;
/* 189 */     return this;
/*     */   }
/*     */   
/*     */   public ThunderData fade(FadeFunction fadeFunction) {
/* 193 */     this.fadeFunction = fadeFunction;
/* 194 */     return this;
/*     */   }
/*     */   
/*     */   public ThunderData lifespan(int lifespan) {
/* 198 */     this.lifespan = lifespan;
/* 199 */     return this;
/*     */   }
/*     */   
/*     */   public int getLifespan() {
/* 203 */     return this.lifespan;
/*     */   }
/*     */   
/*     */   public SpawnFunction getSpawnFunction() {
/* 207 */     return this.spawnFunction;
/*     */   }
/*     */   
/*     */   public FadeFunction getFadeFunction() {
/* 211 */     return this.fadeFunction;
/*     */   }
/*     */   
/*     */   public Vector4f getColor() {
/* 215 */     return this.renderInfo.color;
/*     */   }
/*     */   
/*     */   public List<BoltQuads> generate() {
/* 219 */     List<BoltQuads> quads = new ArrayList<>();
/* 220 */     Vec3 diff = this.end.m_82546_(this.start);
/* 221 */     float totalDistance = (float)diff.m_82553_();
/* 222 */     for (int i = 0; i < this.count; i++) {
/* 223 */       LinkedList<BoltInstructions> drawQueue = new LinkedList<>();
/* 224 */       drawQueue.add(new BoltInstructions(this.start, 0.0F, new Vec3(0.0D, 0.0D, 0.0D), null, false));
/* 225 */       while (!drawQueue.isEmpty()) {
/* 226 */         Vec3 segmentEnd; BoltInstructions data = drawQueue.poll();
/* 227 */         Vec3 perpendicularDist = data.perpendicularDist;
/* 228 */         float progress = data.progress + 1.0F / this.segments * (1.0F - this.renderInfo.parallelNoise + this.random.nextFloat() * this.renderInfo.parallelNoise * 2.0F);
/*     */         
/* 230 */         if (progress >= 1.0F) {
/* 231 */           segmentEnd = this.end;
/*     */         } else {
/* 233 */           float segmentDiffScale = this.renderInfo.spreadFunction.getMaxSpread(progress);
/* 234 */           float maxDiff = this.renderInfo.spreadFactor * segmentDiffScale * totalDistance * this.renderInfo.randomFunction.getRandom(this.random);
/* 235 */           Vec3 randVec = findRandomOrthogonalVector(diff, this.random);
/* 236 */           perpendicularDist = this.renderInfo.segmentSpreader.getSegmentAdd(perpendicularDist, randVec, maxDiff, segmentDiffScale, progress);
/* 237 */           if (this.renderInfo.spreadFactor <= 1.0E-4F) {
/* 238 */             perpendicularDist = Vec3.f_82478_;
/*     */           }
/* 240 */           segmentEnd = this.start.m_82549_(diff.m_82490_(progress)).m_82549_(perpendicularDist);
/*     */         } 
/* 242 */         float boltSize = this.size * (0.5F + (1.0F - progress) * 0.5F);
/* 243 */         Pair<BoltQuads, QuadCache> quadData = createQuads(data.cache, data.start, segmentEnd, boltSize);
/* 244 */         quads.add((BoltQuads)quadData.getLeft());
/*     */         
/* 246 */         if (segmentEnd == this.end)
/*     */           break; 
/* 248 */         if (!data.isBranch) {
/* 249 */           drawQueue.add(new BoltInstructions(segmentEnd, progress, perpendicularDist, (QuadCache)quadData.getRight(), false));
/* 250 */         } else if (this.random.nextFloat() < this.renderInfo.branchContinuationFactor) {
/* 251 */           drawQueue.add(new BoltInstructions(segmentEnd, progress, perpendicularDist, (QuadCache)quadData.getRight(), true));
/*     */         } 
/*     */         
/* 254 */         while (this.random.nextFloat() < this.renderInfo.branchInitiationFactor * (1.0F - progress)) {
/* 255 */           drawQueue.add(new BoltInstructions(segmentEnd, progress, perpendicularDist, (QuadCache)quadData.getRight(), true));
/*     */         }
/*     */       } 
/*     */     } 
/* 259 */     return quads;
/*     */   }
/*     */   
/*     */   private static Vec3 findRandomOrthogonalVector(Vec3 vec, Random rand) {
/* 263 */     Vec3 newVec = new Vec3(-0.5D + rand.nextDouble(), -0.5D + rand.nextDouble(), -0.5D + rand.nextDouble());
/* 264 */     return vec.m_82537_(newVec).m_82541_();
/*     */   }
/*     */   
/*     */   private Pair<BoltQuads, QuadCache> createQuads(QuadCache cache, Vec3 startPos, Vec3 end, float size) {
/* 268 */     Vec3 diff = end.m_82546_(startPos);
/* 269 */     Vec3 rightAdd = diff.m_82537_(new Vec3(0.5D, 0.5D, 0.5D)).m_82541_().m_82490_(size);
/* 270 */     Vec3 backAdd = diff.m_82537_(rightAdd).m_82541_().m_82490_(size), rightAddSplit = rightAdd.m_82490_(0.5D);
/*     */     
/* 272 */     Vec3 start = (cache != null) ? cache.prevEnd : startPos;
/* 273 */     Vec3 startRight = (cache != null) ? cache.prevEndRight : start.m_82549_(rightAdd);
/* 274 */     Vec3 startBack = (cache != null) ? cache.prevEndBack : start.m_82549_(rightAddSplit).m_82549_(backAdd);
/* 275 */     Vec3 endRight = end.m_82549_(rightAdd), endBack = end.m_82549_(rightAddSplit).m_82549_(backAdd);
/*     */     
/* 277 */     BoltQuads quads = new BoltQuads();
/* 278 */     quads.addQuad(new Vec3[] { start, end, endRight, startRight });
/* 279 */     quads.addQuad(new Vec3[] { startRight, endRight, end, start });
/*     */     
/* 281 */     quads.addQuad(new Vec3[] { startRight, endRight, endBack, startBack });
/* 282 */     quads.addQuad(new Vec3[] { startBack, endBack, endRight, startRight });
/*     */     
/* 284 */     return Pair.of(quads, new QuadCache(end, endRight, endBack));
/*     */   }
/*     */   private static final class QuadCache extends Record { private final Vec3 prevEnd; private final Vec3 prevEndRight; private final Vec3 prevEndBack;
/* 287 */     private QuadCache(Vec3 prevEnd, Vec3 prevEndRight, Vec3 prevEndBack) { this.prevEnd = prevEnd; this.prevEndRight = prevEndRight; this.prevEndBack = prevEndBack; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #287	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/* 287 */       //   0	7	0	this	Lcom/pla/annoyingvillagers/client/engine/ThunderRender$ThunderData$QuadCache; } public Vec3 prevEnd() { return this.prevEnd; } public final int hashCode() { // Byte code:
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
/* 287 */       //   0	8	1	o	Ljava/lang/Object; } public Vec3 prevEndRight() { return this.prevEndRight; } public Vec3 prevEndBack() { return this.prevEndBack; }
/*     */      }
/*     */ 
/*     */   
/*     */   protected static class BoltInstructions
/*     */   {
/*     */     private final Vec3 start;
/*     */     private final Vec3 perpendicularDist;
/*     */     private final ThunderRender.ThunderData.QuadCache cache;
/*     */     private final float progress;
/*     */     private final boolean isBranch;
/*     */     
/*     */     private BoltInstructions(Vec3 start, float progress, Vec3 perpendicularDist, ThunderRender.ThunderData.QuadCache cache, boolean isBranch) {
/* 300 */       this.start = start;
/* 301 */       this.perpendicularDist = perpendicularDist;
/* 302 */       this.progress = progress;
/* 303 */       this.cache = cache;
/* 304 */       this.isBranch = isBranch;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BoltQuads
/*     */   {
/* 310 */     private final List<Vec3> vecs = new ArrayList<>();
/*     */     
/*     */     protected void addQuad(Vec3... quadVecs) {
/* 313 */       this.vecs.addAll(Arrays.asList(quadVecs));
/*     */     }
/*     */     
/*     */     public List<Vec3> getVecs() {
/* 317 */       return this.vecs;
/*     */     } }
/*     */   public static interface SpreadFunction { public static final SpreadFunction DEFAULT = progress -> 1.0F;
/*     */     
/*     */     float getMaxSpread(float param2Float); }
/*     */   
/*     */   public static interface RandomFunction { public static final RandomFunction DEFAULT;
/*     */     
/*     */     float getRandom(Random param2Random);
/*     */     
/*     */     static {
/* 328 */       DEFAULT = (rand -> (float)rand.nextGaussian());
/*     */     } }
/*     */   
/*     */   public static interface SegmentSpreader { public static final SegmentSpreader DEFAULT;
/*     */     
/*     */     static {
/* 334 */       DEFAULT = ((perpendicularDist, randVec, maxDiff, scale, progress) -> randVec.m_82490_(maxDiff));
/*     */     } static SegmentSpreader memory(float memoryFactor) {
/* 336 */       return (perpendicularDist, randVec, maxDiff, spreadScale, progress) -> {
/*     */           float nextDiff = maxDiff * (1.0F - memoryFactor);
/*     */           Vec3 cur = randVec.m_82490_(nextDiff);
/*     */           if (progress > 0.5F) {
/*     */             float pull = (1.0F - spreadScale) * (1.0F - memoryFactor) * 0.35F;
/*     */             cur = cur.m_82549_(perpendicularDist.m_82490_(-pull));
/*     */           } 
/*     */           return perpendicularDist.m_82549_(cur);
/*     */         };
/*     */     }
/*     */     
/*     */     Vec3 getSegmentAdd(Vec3 param2Vec31, Vec3 param2Vec32, float param2Float1, float param2Float2, float param2Float3); }
/*     */ 
/*     */   
/*     */   public static interface SpawnFunction
/*     */   {
/*     */     public static final SpawnFunction DEFAULT = rand -> Pair.of(Float.valueOf(0.0F), Float.valueOf(0.0F));
/*     */     
/*     */     static SpawnFunction delay(float delay) {
/* 355 */       return rand -> Pair.of(Float.valueOf(delay), Float.valueOf(delay));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     default float getSpawnDelay(Random rand) {
/* 361 */       Pair<Float, Float> bounds = getSpawnDelayBounds(rand);
/* 362 */       return ((Float)bounds.getLeft()).floatValue() + (((Float)bounds.getRight()).floatValue() - ((Float)bounds.getLeft()).floatValue()) * rand.nextFloat();
/*     */     }
/*     */     
/*     */     default boolean isConsecutive() {
/* 366 */       return false;
/*     */     }
/*     */     Pair<Float, Float> getSpawnDelayBounds(Random param2Random); }
/*     */   public static interface FadeFunction { public static final FadeFunction NONE;
/*     */     static {
/* 371 */       NONE = ((totalBolts, lifeScale) -> Pair.of(Integer.valueOf(0), Integer.valueOf(totalBolts)));
/*     */     } static FadeFunction fade(float fade) {
/* 373 */       return (totalBolts, lifeScale) -> {
/*     */           int start = (lifeScale > 1.0F - fade) ? (int)(totalBolts * (lifeScale - 1.0F - fade) / fade) : 0;
/*     */           int end = (lifeScale < fade) ? (int)(totalBolts * lifeScale / fade) : totalBolts;
/*     */           return Pair.of(Integer.valueOf(start), Integer.valueOf(end));
/*     */         };
/*     */     }
/*     */     
/*     */     Pair<Integer, Integer> getRenderBounds(int param2Int, float param2Float); }
/*     */ 
/*     */   
/*     */   public static class ThunderRenderInfo
/*     */   {
/* 385 */     public static final ThunderRenderInfo DEFAULT = new ThunderRenderInfo();
/* 386 */     public static final ThunderRenderInfo DRAGON_THUNDER = dragonThunder();
/* 387 */     public static final ThunderRenderInfo BLUE_DEMON_THUNDER = blueDemonThunder();
/* 388 */     private float parallelNoise = 0.1F;
/* 389 */     private float spreadFactor = 0.0F;
/* 390 */     private float branchInitiationFactor = 0.0F;
/* 391 */     private float branchContinuationFactor = 0.0F;
/*     */     
/* 393 */     private Vector4f color = new Vector4f(0.45F, 0.45F, 0.5F, 0.8F);
/*     */     
/* 395 */     private final ThunderRender.ThunderData.RandomFunction randomFunction = ThunderRender.ThunderData.RandomFunction.DEFAULT;
/* 396 */     private final ThunderRender.ThunderData.SpreadFunction spreadFunction = ThunderRender.ThunderData.SpreadFunction.DEFAULT;
/* 397 */     private ThunderRender.ThunderData.SegmentSpreader segmentSpreader = ThunderRender.ThunderData.SegmentSpreader.DEFAULT;
/*     */     
/*     */     public static ThunderRenderInfo dragonThunder() {
/* 400 */       return new ThunderRenderInfo(0.15F, 0.025F, 0.0F, 0.0F, new Vector4f(0.85F, 0.55F, 1.0F, 0.85F), 0.8F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ThunderRenderInfo blueDemonThunder() {
/* 411 */       return new ThunderRenderInfo(0.15F, 0.025F, 0.0F, 0.0F, new Vector4f(0.65F, 1.0F, 1.0F, 0.9F), 0.8F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ThunderRenderInfo() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ThunderRenderInfo(float parallelNoise, float spreadFactor, float branchInitiationFactor, float branchContinuationFactor, Vector4f color, float closeness) {
/* 425 */       this.parallelNoise = parallelNoise;
/* 426 */       this.spreadFactor = spreadFactor;
/* 427 */       this.branchInitiationFactor = branchInitiationFactor;
/* 428 */       this.branchContinuationFactor = branchContinuationFactor;
/* 429 */       this.color = color;
/* 430 */       this.segmentSpreader = ThunderRender.ThunderData.SegmentSpreader.memory(closeness);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\ThunderRender$ThunderData.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */