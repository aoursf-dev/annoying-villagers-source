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
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ public class ModelVillagerGeneralArmor<T extends Entity>
/*    */   extends EntityModel<T>
/*    */ {
/* 20 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "modelvillagergeneralarmor"), "main");
/*    */   public final ModelPart Head;
/*    */   
/*    */   public ModelVillagerGeneralArmor(ModelPart modelpart) {
/* 24 */     this.Head = modelpart.m_171324_("Head");
/*    */   }
/*    */   
/*    */   public static LayerDefinition createBodyLayer() {
/* 28 */     MeshDefinition meshdefinition = new MeshDefinition();
/* 29 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*    */     
/* 31 */     partdefinition.m_171599_("Head", CubeListBuilder.m_171558_().m_171514_(26, 14).m_171488_(-5.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(28, 0).m_171488_(-5.0F, -10.0F, -5.0F, 10.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(11, 12).m_171488_(-4.0F, -11.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(11, 9).m_171488_(-5.0F, -6.0F, -5.5F, 10.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)).m_171514_(0, 1).m_171488_(-5.0F, -5.0F, -5.5F, 1.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)).m_171514_(5, 11).m_171488_(-1.0F, -4.0F, -6.0F, 2.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(4.0F, -5.0F, -5.5F, 1.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)).m_171514_(11, 14).m_171488_(-4.0F, -4.0F, -5.5F, 8.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)).m_171514_(22, 24).m_171488_(-1.0F, -11.7F, -5.0F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.0F, -11.0F, -4.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(11, 10).m_171488_(-4.0F, -11.0F, 4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 29).m_171488_(-5.0F, -3.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(33, 12).m_171488_(-5.0F, -3.0F, -4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(33, 8).m_171488_(-5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(22, 15).m_171488_(-5.0F, -2.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(15, 15).m_171488_(-5.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(5, 25).m_171488_(3.0F, -3.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(32, 34).m_171488_(-5.0F, -2.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(22, 9).m_171488_(-0.5F, -13.0F, -6.0F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(33, 8).m_171488_(-0.5F, -14.0F, -6.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(0, 25).m_171488_(-0.5F, -15.0F, -6.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(7, 28).m_171488_(4.0F, -2.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(11, 16).m_171488_(-5.0F, -10.0F, -4.0F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(5, 13).m_171488_(4.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(11, 15).m_171488_(4.0F, -2.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 13).m_171488_(4.0F, -3.0F, 1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 9).m_171488_(4.0F, -10.0F, -4.0F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).m_171514_(0, 32).m_171488_(-4.0F, -10.0F, 4.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(18, 34).m_171488_(-3.0F, -2.0F, 4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 6).m_171488_(-1.0F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 9).m_171488_(4.0F, -3.0F, -4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(5, 9).m_171488_(4.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -3.0F, -6.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
/* 32 */     return LayerDefinition.m_171565_(meshdefinition, 64, 64);
/*    */   }
/*    */   
/*    */   public void m_7695_(PoseStack posestack, VertexConsumer vertexconsumer, int i, int j, float f, float f1, float f2, float f3) {
/* 36 */     this.Head.m_104306_(posestack, vertexconsumer, i, j, f, f1, f2, f3);
/*    */   }
/*    */   
/*    */   public void m_6973_(T t0, float f, float f1, float f2, float f3, float f4) {
/* 40 */     this.Head.f_104204_ = f3 / 57.295776F;
/* 41 */     this.Head.f_104203_ = f4 / 57.295776F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\model\ModelVillagerGeneralArmor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */