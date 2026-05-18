/*     */ package com.pla.annoyingvillagers.client.engine;
/*     */ 
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import java.util.List;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ import org.joml.Matrix4f;
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
/*     */ public class ThunderInstance
/*     */ {
/*     */   private final ThunderRender.ThunderData bolt;
/*     */   private final List<ThunderRender.ThunderData.BoltQuads> renderQuads;
/*     */   private final ThunderRender.Timestamp createdTimestamp;
/*     */   
/*     */   public ThunderInstance(ThunderRender.ThunderData bolt, ThunderRender.Timestamp timestamp) {
/*  89 */     this.bolt = bolt;
/*  90 */     this.renderQuads = bolt.generate();
/*  91 */     this.createdTimestamp = timestamp;
/*     */   }
/*     */   
/*     */   public void render(Matrix4f matrix, VertexConsumer buffer, ThunderRender.Timestamp timestamp) {
/*  95 */     float lifeScale = timestamp.subtract(this.createdTimestamp).value() / this.bolt.getLifespan();
/*  96 */     Pair<Integer, Integer> bounds = this.bolt.getFadeFunction().getRenderBounds(this.renderQuads.size(), lifeScale);
/*  97 */     for (int i = ((Integer)bounds.getLeft()).intValue(); i < ((Integer)bounds.getRight()).intValue(); i++) {
/*  98 */       ((ThunderRender.ThunderData.BoltQuads)this.renderQuads.get(i)).getVecs().forEach(v -> buffer.m_252986_(matrix, (float)v.f_82479_, (float)v.f_82480_, (float)v.f_82481_).m_85950_(this.bolt.getColor().x(), this.bolt.getColor().y(), this.bolt.getColor().z(), this.bolt.getColor().w()).m_5752_());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean tick(ThunderRender.Timestamp timestamp) {
/* 105 */     return timestamp.isPassed(this.createdTimestamp, this.bolt.getLifespan());
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\ThunderRender$ThunderInstance.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */