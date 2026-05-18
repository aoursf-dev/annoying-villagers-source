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
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelDragonMeteorite<T extends Entity>
/*    */   extends EntityModel<T>
/*    */ {
/* 40 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "modeldragonmeteorite"), "main");
/*    */   public final ModelPart bone;
/*    */   
/*    */   public ModelDragonMeteorite(ModelPart modelpart) {
/* 44 */     this.bone = modelpart.m_171324_("bone");
/*    */   }
/*    */   
/*    */   public static LayerDefinition createBodyLayer() {
/* 48 */     MeshDefinition meshdefinition = new MeshDefinition();
/* 49 */     PartDefinition partdefinition = meshdefinition.m_171576_();
/*    */     
/* 51 */     partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 16.0F, 0.0F));
/* 52 */     return LayerDefinition.m_171565_(meshdefinition, 64, 64);
/*    */   }
/*    */   
/*    */   public void m_7695_(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int i, int j, float f, float f1, float f2, float f3) {
/* 56 */     this.bone.m_104306_(poseStack, vertexConsumer, i, j, f, f1, f2, f3);
/*    */   }
/*    */   
/*    */   public void m_6973_(@NotNull T t0, float f, float f1, float f2, float f3, float f4) {
/* 60 */     this.bone.f_104204_ = f2 / 20.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\model\ModelDragonMeteorite.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */