/*     */ package com.pla.annoyingvillagers.client.model;
/*     */ import com.mojang.blaze3d.vertex.PoseStack;
/*     */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*     */ import net.minecraft.client.model.geom.ModelLayerLocation;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.client.model.geom.PartPose;
/*     */ import net.minecraft.client.model.geom.builders.CubeDeformation;
/*     */ import net.minecraft.client.model.geom.builders.CubeListBuilder;
/*     */ import net.minecraft.client.model.geom.builders.LayerDefinition;
/*     */ import net.minecraft.client.model.geom.builders.MeshDefinition;
/*     */ import net.minecraft.client.model.geom.builders.PartDefinition;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class ModelSnakeBlade<T extends Entity> extends EntityModel<T> {
/*  16 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "modelsnakeblade"), "main");
/*     */   private final ModelPart bb_main;
/*     */   
/*     */   public ModelSnakeBlade(ModelPart root) {
/*  20 */     this.bb_main = root.m_171324_("bb_main");
/*     */   }
/*     */   
/*     */   public static LayerDefinition createBodyLayer() {
/*  24 */     MeshDefinition meshdefinition = new MeshDefinition();
/*  25 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*     */     
/*  27 */     PartDefinition bb_main = partdefinition.m_171599_("bb_main", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/*     */     
/*  29 */     PartDefinition cube_r1 = bb_main.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(10, 0).m_171488_(-8.5F, -11.0F, 18.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  30 */         .m_171514_(10, 0).m_171488_(-8.5F, -11.0F, 17.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  31 */         .m_171514_(10, 0).m_171488_(-8.5F, -11.0F, 16.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  32 */         .m_171514_(10, 0).m_171488_(-8.5F, -11.0F, 15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  33 */         .m_171514_(10, 0).m_171488_(-8.5F, -11.0F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  34 */         .m_171514_(10, 0).m_171488_(-8.5F, -11.0F, 13.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  35 */         .m_171514_(5, 0).m_171488_(-8.5F, -11.0F, 12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  36 */         .m_171514_(5, 0).m_171488_(-8.5F, -11.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  37 */         .m_171514_(0, 0).m_171488_(-8.5F, -11.0F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  38 */         .m_171514_(10, 0).m_171488_(-8.5F, -10.0F, 18.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  39 */         .m_171514_(10, 0).m_171488_(-8.5F, -10.0F, 17.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  40 */         .m_171514_(10, 0).m_171488_(-8.5F, -10.0F, 16.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  41 */         .m_171514_(10, 0).m_171488_(-8.6F, -10.0F, 15.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  42 */         .m_171514_(0, 2).m_171488_(-8.6F, -10.0F, 14.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  43 */         .m_171514_(10, 0).m_171488_(-8.6F, -10.0F, 13.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  44 */         .m_171514_(20, 0).m_171488_(-8.8F, -10.0F, 12.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  45 */         .m_171514_(26, 0).m_171488_(-8.8F, -10.0F, 11.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  46 */         .m_171514_(20, 0).m_171488_(-8.8F, -10.0F, 10.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  47 */         .m_171514_(10, 0).m_171488_(-8.5F, -9.0F, 17.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  48 */         .m_171514_(10, 0).m_171488_(-8.5F, -9.0F, 16.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  49 */         .m_171514_(10, 0).m_171488_(-8.6F, -9.0F, 15.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  50 */         .m_171514_(10, 0).m_171488_(-8.6F, -9.0F, 14.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  51 */         .m_171514_(10, 0).m_171488_(-8.6F, -9.0F, 13.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  52 */         .m_171514_(21, 2).m_171488_(-8.7F, -9.0F, 12.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  53 */         .m_171514_(15, 0).m_171488_(-8.7F, -9.0F, 11.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  54 */         .m_171514_(15, 2).m_171488_(-8.8F, -9.0F, 10.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  55 */         .m_171514_(10, 0).m_171488_(-8.5F, -8.0F, 16.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  56 */         .m_171514_(10, 0).m_171488_(-8.5F, -8.0F, 15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  57 */         .m_171514_(21, 4).m_171488_(-8.7F, -8.0F, 14.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  58 */         .m_171514_(16, 4).m_171488_(-8.7F, -8.0F, 13.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  59 */         .m_171514_(10, 0).m_171488_(-8.5F, -8.0F, 12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  60 */         .m_171514_(11, 4).m_171488_(-8.7F, -8.0F, 11.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  61 */         .m_171514_(5, 4).m_171488_(-8.8F, -8.0F, 10.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  62 */         .m_171514_(10, 0).m_171488_(-8.5F, -7.0F, 15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  63 */         .m_171514_(10, 0).m_171488_(-8.6F, -7.0F, 14.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  64 */         .m_171514_(5, 6).m_171488_(-8.7F, -7.0F, 13.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  65 */         .m_171514_(0, 6).m_171488_(-8.7F, -7.0F, 12.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  66 */         .m_171514_(10, 0).m_171488_(-8.7F, -7.0F, 11.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  67 */         .m_171514_(10, 0).m_171488_(-8.7F, -7.0F, 10.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  68 */         .m_171514_(5, 8).m_171488_(-8.5F, -6.0F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  69 */         .m_171514_(16, 4).m_171488_(-8.7F, -6.0F, 13.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  70 */         .m_171514_(0, 10).m_171488_(-8.8F, -6.0F, 12.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  71 */         .m_171514_(10, 6).m_171488_(-8.7F, -6.0F, 11.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  72 */         .m_171514_(10, 6).m_171488_(-8.7F, -6.0F, 10.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  73 */         .m_171514_(10, 0).m_171488_(-8.5F, -5.0F, 13.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  74 */         .m_171514_(15, 8).m_171488_(-8.5F, -5.0F, 12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  75 */         .m_171514_(10, 0).m_171488_(-8.5F, -5.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  76 */         .m_171514_(15, 8).m_171488_(-8.8F, -5.0F, 10.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  77 */         .m_171514_(10, 0).m_171488_(-8.5F, -4.0F, 12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  78 */         .m_171514_(5, 8).m_171488_(-8.5F, -4.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  79 */         .m_171514_(10, 0).m_171488_(-8.5F, -4.0F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  80 */         .m_171514_(10, 0).m_171488_(-8.5F, -3.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  81 */         .m_171514_(10, 0).m_171488_(-8.5F, -3.0F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  82 */         .m_171514_(10, 0).m_171488_(-8.5F, -2.0F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  83 */         .m_171514_(10, 0).m_171488_(-8.5F, -10.0F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  84 */         .m_171514_(15, 2).m_171488_(-8.8F, -9.0F, 9.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  85 */         .m_171514_(20, 0).m_171488_(-8.8F, -8.0F, 9.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  86 */         .m_171514_(10, 0).m_171488_(-8.7F, -7.0F, 9.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  87 */         .m_171514_(25, 6).m_171488_(-8.7F, -6.0F, 9.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  88 */         .m_171514_(10, 8).m_171488_(-8.7F, -5.0F, 9.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  89 */         .m_171514_(26, 8).m_171488_(-8.8F, -4.0F, 9.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  90 */         .m_171514_(0, 2).m_171488_(-8.5F, -3.0F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  91 */         .m_171514_(5, 0).m_171488_(-8.5F, -1.0F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  92 */         .m_171514_(10, 0).m_171488_(-8.5F, -2.0F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  93 */         .m_171514_(15, 0).m_171488_(-8.5F, -10.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  94 */         .m_171514_(10, 2).m_171488_(-8.7F, -9.0F, 8.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  95 */         .m_171514_(26, 2).m_171488_(-8.5F, -8.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  96 */         .m_171514_(5, 2).m_171488_(-8.5F, -9.0F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  97 */         .m_171514_(0, 4).m_171488_(-8.7F, -8.0F, 6.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  98 */         .m_171514_(15, 0).m_171488_(-8.5F, -9.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/*  99 */         .m_171514_(15, 2).m_171488_(-8.8F, -8.0F, 7.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 100 */         .m_171514_(20, 0).m_171488_(-8.8F, -8.0F, 8.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 101 */         .m_171514_(26, 4).m_171488_(-8.5F, -7.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 102 */         .m_171514_(10, 0).m_171488_(-8.5F, -7.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 103 */         .m_171514_(15, 2).m_171488_(-8.8F, -7.0F, 5.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 104 */         .m_171514_(15, 2).m_171488_(-8.8F, -7.0F, 6.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 105 */         .m_171514_(10, 0).m_171488_(-8.8F, -7.0F, 7.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 106 */         .m_171514_(10, 0).m_171488_(-8.7F, -7.0F, 8.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 107 */         .m_171514_(10, 6).m_171488_(-8.5F, -6.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 108 */         .m_171514_(15, 6).m_171488_(-8.7F, -6.0F, 3.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 109 */         .m_171514_(15, 2).m_171488_(-8.8F, -6.0F, 4.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 110 */         .m_171514_(15, 2).m_171488_(-8.8F, -6.0F, 5.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 111 */         .m_171514_(20, 0).m_171488_(-8.7F, -6.0F, 6.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 112 */         .m_171514_(20, 6).m_171488_(-8.7F, -6.0F, 7.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 113 */         .m_171514_(25, 6).m_171488_(-8.7F, -6.0F, 8.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 114 */         .m_171514_(20, 0).m_171488_(-8.8F, -5.0F, 3.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 115 */         .m_171514_(15, 2).m_171488_(-8.8F, -5.0F, 4.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 116 */         .m_171514_(20, 0).m_171488_(-8.7F, -5.0F, 5.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 117 */         .m_171514_(25, 6).m_171488_(-8.7F, -5.0F, 6.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 118 */         .m_171514_(25, 6).m_171488_(-8.7F, -5.0F, 7.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 119 */         .m_171514_(20, 6).m_171488_(-8.7F, -5.0F, 8.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 120 */         .m_171514_(5, 4).m_171488_(-8.7F, -4.0F, 4.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 121 */         .m_171514_(21, 8).m_171488_(-8.7F, -4.0F, 5.0F, 1.4F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 122 */         .m_171514_(20, 0).m_171488_(-8.8F, -4.0F, 6.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 123 */         .m_171514_(10, 0).m_171488_(-8.5F, -4.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 124 */         .m_171514_(0, 10).m_171488_(-8.8F, -4.0F, 8.0F, 1.6F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 125 */         .m_171514_(10, 0).m_171488_(-8.6F, -3.0F, 5.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 126 */         .m_171514_(10, 0).m_171488_(-8.6F, -2.0F, 6.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 127 */         .m_171514_(10, 0).m_171488_(-8.6F, -3.0F, 6.0F, 1.2F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 128 */         .m_171514_(0, 0).m_171488_(-8.5F, -1.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 129 */         .m_171514_(0, 0).m_171488_(-8.5F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 130 */         .m_171514_(10, 0).m_171488_(-8.5F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 131 */         .m_171514_(10, 0).m_171488_(-8.5F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 132 */         .m_171514_(10, 0).m_171488_(-8.5F, -1.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
/* 133 */         .m_171514_(10, 0).m_171488_(-8.5F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(8.0F, -7.0F, -13.0F, -0.7854F, 0.0F, 0.0F));
/*     */     
/* 135 */     return LayerDefinition.m_171565_(meshdefinition, 32, 32);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_6973_(@NotNull Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_7695_(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
/* 145 */     this.bb_main.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\model\ModelSnakeBlade.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */