/*    */ package com.pla.annoyingvillagers.client.model;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import net.minecraft.client.model.EntityModel;
/*    */ import net.minecraft.client.model.geom.ModelLayerLocation;
/*    */ import net.minecraft.client.model.geom.ModelPart;
/*    */ import net.minecraft.client.model.geom.PartPose;
/*    */ import net.minecraft.client.model.geom.builders.CubeDeformation;
/*    */ import net.minecraft.client.model.geom.builders.CubeListBuilder;
/*    */ import net.minecraft.client.model.geom.builders.LayerDefinition;
/*    */ import net.minecraft.client.model.geom.builders.MeshDefinition;
/*    */ import net.minecraft.client.model.geom.builders.PartDefinition;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ public class ModelGreenVillagerGeneralArmor<T extends Entity>
/*    */   extends EntityModel<T>
/*    */ {
/* 21 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "modelgreenvillagergeneralarmor"), "main");
/*    */   public final ModelPart Body;
/*    */   public final ModelPart RightArm;
/*    */   public final ModelPart LeftArm;
/*    */   public final ModelPart RightLeg;
/*    */   public final ModelPart LeftLeg;
/*    */   
/*    */   public ModelGreenVillagerGeneralArmor(ModelPart modelpart) {
/* 29 */     this.Body = modelpart.m_171324_("Body");
/* 30 */     this.RightArm = modelpart.m_171324_("RightArm");
/* 31 */     this.LeftArm = modelpart.m_171324_("LeftArm");
/* 32 */     this.RightLeg = modelpart.m_171324_("RightLeg");
/* 33 */     this.LeftLeg = modelpart.m_171324_("LeftLeg");
/*    */   }
/*    */   
/*    */   public static LayerDefinition createBodyLayer() {
/* 37 */     MeshDefinition meshdefinition = new MeshDefinition();
/* 38 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/* 39 */     PartDefinition partdefinition1 = partdefinition.m_171599_("Body", CubeListBuilder.m_171558_().m_171514_(18, 16).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
/*    */     
/* 41 */     partdefinition1.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, 0.2F, 3.0F, 10.0F, 19.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
/* 42 */     partdefinition.m_171599_("RightArm", CubeListBuilder.m_171558_().m_171514_(28, 32).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(-5.0F, 2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
/* 43 */     partdefinition.m_171599_("LeftArm", CubeListBuilder.m_171558_().m_171514_(12, 32).m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(5.0F, 2.0F, 0.0F, 0.2094F, 0.0F, 0.0F));
/* 44 */     partdefinition.m_171599_("RightLeg", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(-1.9F, 12.0F, 0.0F, 0.192F, 0.0F, 0.0349F));
/* 45 */     partdefinition.m_171599_("LeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.m_171423_(1.9F, 12.0F, 0.0F, -0.1745F, 0.0F, -0.0349F));
/* 46 */     return LayerDefinition.m_171565_(meshdefinition, 64, 64);
/*    */   }
/*    */   
/*    */   public void m_7695_(PoseStack posestack, VertexConsumer vertexconsumer, int i, int j, float f, float f1, float f2, float f3) {
/* 50 */     this.Body.m_104306_(posestack, vertexconsumer, i, j, f, f1, f2, f3);
/* 51 */     this.RightArm.m_104306_(posestack, vertexconsumer, i, j, f, f1, f2, f3);
/* 52 */     this.LeftArm.m_104306_(posestack, vertexconsumer, i, j, f, f1, f2, f3);
/* 53 */     this.RightLeg.m_104306_(posestack, vertexconsumer, i, j, f, f1, f2, f3);
/* 54 */     this.LeftLeg.m_104306_(posestack, vertexconsumer, i, j, f, f1, f2, f3);
/*    */   }
/*    */   
/*    */   public void m_6973_(T t0, float f, float f1, float f2, float f3, float f4) {
/* 58 */     this.RightArm.f_104203_ = Mth.m_14089_(f * 0.6662F + 3.1415927F) * f1;
/* 59 */     this.LeftLeg.f_104203_ = Mth.m_14089_(f * 1.0F) * -1.0F * f1;
/* 60 */     this.LeftArm.f_104203_ = Mth.m_14089_(f * 0.6662F) * f1;
/* 61 */     this.RightLeg.f_104203_ = Mth.m_14089_(f * 1.0F) * 1.0F * f1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\model\ModelGreenVillagerGeneralArmor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */