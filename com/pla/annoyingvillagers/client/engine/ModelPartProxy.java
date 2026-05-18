/*     */ package com.pla.annoyingvillagers.client.engine;
/*     */ 
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import com.pla.annoyingvillagers.accessors.ModelPartAccess;
/*     */ import java.util.List;
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelPartProxy
/*     */ {
/*     */   public final ModelPart part;
/*     */   private final List<ModelPartProxy> children;
/*  41 */   public float scaleX = 1.0F;
/*  42 */   public float scaleY = 1.0F;
/*  43 */   public float scaleZ = 1.0F;
/*     */ 
/*     */   
/*     */   private float x;
/*     */   
/*     */   private float y;
/*     */   
/*     */   private float z;
/*     */   
/*     */   private float xRot;
/*     */   
/*     */   private float yRot;
/*     */   
/*     */   private float zRot;
/*     */   
/*     */   private boolean visible;
/*     */ 
/*     */   
/*     */   public ModelPartProxy(ModelPart part) {
/*  62 */     this.part = part;
/*     */     
/*  64 */     this.children = part.m_171331_().skip(1L).map(ModelPartProxy::new).toList();
/*     */     
/*  66 */     update();
/*     */   }
/*     */ 
/*     */   
/*     */   public void copy(ModelPartProxy other) {
/*  71 */     other.x = this.x;
/*  72 */     other.y = this.y;
/*  73 */     other.z = this.z;
/*     */     
/*  75 */     other.xRot = this.xRot;
/*  76 */     other.yRot = this.yRot;
/*  77 */     other.zRot = this.zRot;
/*     */     
/*  79 */     other.scaleX = this.scaleX;
/*  80 */     other.scaleY = this.scaleY;
/*  81 */     other.scaleZ = this.scaleZ;
/*     */     
/*  83 */     other.visible = this.visible;
/*     */     
/*  85 */     if (this.children.size() != other.children.size())
/*  86 */       throw new IllegalArgumentException("Proxies do not share the same children."); 
/*  87 */     for (int i = 0; i < this.children.size(); ) { ((ModelPartProxy)this.children.get(i)).copy(other.children.get(i)); i++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update() {
/*  96 */     this.x = this.part.f_104200_;
/*  97 */     this.y = this.part.f_104201_;
/*  98 */     this.z = this.part.f_104202_;
/*     */     
/* 100 */     this.xRot = this.part.f_104203_;
/* 101 */     this.yRot = this.part.f_104204_;
/* 102 */     this.zRot = this.part.f_104205_;
/*     */     
/* 104 */     ModelPartAccess mixinPart = (ModelPartAccess)this.part;
/*     */     
/* 106 */     this.scaleX = mixinPart.getXScale();
/* 107 */     this.scaleY = mixinPart.getYScale();
/* 108 */     this.scaleZ = mixinPart.getZScale();
/*     */     
/* 110 */     this.visible = this.part.f_104207_;
/*     */     
/* 112 */     for (ModelPartProxy child : this.children) child.update();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void apply() {
/* 120 */     this.part.f_104200_ = this.x;
/* 121 */     this.part.f_104201_ = this.y;
/* 122 */     this.part.f_104202_ = this.z;
/*     */     
/* 124 */     this.part.f_104203_ = this.xRot;
/* 125 */     this.part.f_104204_ = this.yRot;
/* 126 */     this.part.f_104205_ = this.zRot;
/*     */     
/* 128 */     ((ModelPartAccess)this.part).setRenderScale(this.scaleX, this.scaleY, this.scaleZ);
/*     */     
/* 130 */     this.part.f_104207_ = this.visible;
/*     */     
/* 132 */     for (ModelPartProxy child : this.children) child.apply();
/*     */   
/*     */   }
/*     */   
/*     */   public void render(PoseStack ps, VertexConsumer vertices, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
/* 137 */     apply();
/* 138 */     this.part.m_104306_(ps, vertices, packedLightIn, packedOverlayIn, red, green, blue, alpha);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\ModelPartProxy.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */