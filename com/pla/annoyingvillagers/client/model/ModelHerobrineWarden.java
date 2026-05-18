/*    */ package com.pla.annoyingvillagers.client.model;
/*    */ import com.pla.annoyingvillagers.entity.HerobrineWardenEntity;
/*    */ import net.minecraft.client.model.geom.ModelLayerLocation;
/*    */ import net.minecraft.client.model.geom.ModelPart;
/*    */ import net.minecraft.client.model.geom.PartPose;
/*    */ import net.minecraft.client.model.geom.builders.CubeDeformation;
/*    */ import net.minecraft.client.model.geom.builders.CubeListBuilder;
/*    */ import net.minecraft.client.model.geom.builders.LayerDefinition;
/*    */ import net.minecraft.client.model.geom.builders.MeshDefinition;
/*    */ import net.minecraft.client.model.geom.builders.PartDefinition;
/*    */ import net.minecraft.world.entity.monster.warden.Warden;
/*    */ 
/*    */ public class ModelHerobrineWarden extends WardenModel<HerobrineWardenEntity> {
/* 14 */   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
/* 15 */       ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "modelherobrinewarden"), "main");
/*    */   
/*    */   private final ModelPart left_ribcage_extra;
/*    */   private final ModelPart right_ribcage_extra;
/*    */   
/*    */   public ModelHerobrineWarden(ModelPart root) {
/* 21 */     super(root);
/* 22 */     ModelPart body = root.m_171324_("bone").m_171324_("body");
/* 23 */     this.left_ribcage_extra = body.m_171324_("left_ribcage").m_171324_("left_ribs_extra");
/* 24 */     this.right_ribcage_extra = body.m_171324_("right_ribcage").m_171324_("right_ribs_extra");
/*    */   }
/*    */   
/*    */   public static LayerDefinition m_233537_() {
/* 28 */     MeshDefinition mesh = new MeshDefinition();
/* 29 */     PartDefinition root = mesh.m_171576_();
/*    */     
/* 31 */     PartDefinition bone = root.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, 0.0F));
/* 32 */     PartDefinition body = bone.m_171599_("body", 
/* 33 */         CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-9.0F, -13.0F, -4.0F, 18.0F, 21.0F, 11.0F), 
/* 34 */         PartPose.m_171419_(0.0F, -21.0F, 0.0F));
/*    */     
/* 36 */     PartDefinition right_ribcage = body.m_171599_("right_ribcage", 
/* 37 */         CubeListBuilder.m_171558_().m_171514_(90, 11).m_171481_(-2.0F, -11.0F, -0.1F, 9.0F, 21.0F, 0.0F), 
/* 38 */         PartPose.m_171419_(-7.0F, -2.0F, -4.0F));
/*    */     
/* 40 */     PartDefinition left_ribcage = body.m_171599_("left_ribcage", 
/* 41 */         CubeListBuilder.m_171558_().m_171514_(90, 11).m_171480_().m_171481_(-7.0F, -11.0F, -0.1F, 9.0F, 21.0F, 0.0F).m_171555_(false), 
/* 42 */         PartPose.m_171419_(7.0F, -2.0F, -4.0F));
/*    */     
/* 44 */     PartDefinition head = body.m_171599_("head", 
/* 45 */         CubeListBuilder.m_171558_().m_171514_(0, 32).m_171481_(-8.0F, -16.0F, -5.0F, 16.0F, 16.0F, 10.0F), 
/* 46 */         PartPose.m_171419_(0.0F, -13.0F, 0.0F));
/* 47 */     head.m_171599_("right_tendril", 
/* 48 */         CubeListBuilder.m_171558_().m_171514_(52, 32).m_171481_(-16.0F, -13.0F, 0.0F, 16.0F, 16.0F, 0.0F), 
/* 49 */         PartPose.m_171419_(-8.0F, -12.0F, 0.0F));
/* 50 */     head.m_171599_("left_tendril", 
/* 51 */         CubeListBuilder.m_171558_().m_171514_(58, 0).m_171481_(0.0F, -13.0F, 0.0F, 16.0F, 16.0F, 0.0F), 
/* 52 */         PartPose.m_171419_(8.0F, -12.0F, 0.0F));
/*    */     
/* 54 */     body.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(44, 50).m_171481_(-4.0F, 0.0F, -4.0F, 8.0F, 28.0F, 8.0F), 
/* 55 */         PartPose.m_171419_(-13.0F, -13.0F, 1.0F));
/* 56 */     body.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(0, 58).m_171481_(-4.0F, 0.0F, -4.0F, 8.0F, 28.0F, 8.0F), 
/* 57 */         PartPose.m_171419_(13.0F, -13.0F, 1.0F));
/*    */     
/* 59 */     bone.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(76, 48).m_171481_(-3.1F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F), 
/* 60 */         PartPose.m_171419_(-5.9F, -13.0F, 0.0F));
/* 61 */     bone.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(76, 76).m_171481_(-2.9F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F), 
/* 62 */         PartPose.m_171419_(5.9F, -13.0F, 0.0F));
/*    */     
/* 64 */     left_ribcage.m_171599_("left_ribs_extra", CubeListBuilder.m_171558_().m_171514_(11, 71).m_171488_(-7.0F, -15.0F, -5.1F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
/* 65 */         .m_171514_(11, 71).m_171488_(-7.0F, -19.0F, -5.1F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
/* 66 */         .m_171514_(11, 71).m_171488_(-7.0F, -23.0F, -5.1F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
/* 67 */         .m_171514_(11, 71).m_171488_(-7.0F, -27.0F, -5.1F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 21.0F, 3.0F, 0.0F, -0.3491F, 0.0F));
/*    */     
/* 69 */     right_ribcage.m_171599_("right_ribs_extra", CubeListBuilder.m_171558_().m_171514_(11, 71).m_171488_(-7.0F, -15.0F, -5.1F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
/* 70 */         .m_171514_(11, 71).m_171488_(-7.0F, -19.0F, -5.1F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
/* 71 */         .m_171514_(11, 71).m_171488_(-7.0F, -23.0F, -5.1F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
/* 72 */         .m_171514_(11, 71).m_171488_(-7.0F, -27.0F, -5.1F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(7.0F, 21.0F, 1.0F, 0.0F, 0.3491F, 0.0F));
/*    */     
/* 74 */     return LayerDefinition.m_171565_(mesh, 128, 128);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setupAnim(HerobrineWardenEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
/* 79 */     super.m_6973_((Warden)pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
/* 80 */     m_233381_(pEntity.idleAnimationState, HerobrineWardenAnimations.HEROBRINE_WARDEN_IDLE, pAgeInTicks);
/* 81 */     m_233381_(pEntity.eatingAnimationState, HerobrineWardenAnimations.HEROBRINE_WARDEN_EATING, pAgeInTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\model\ModelHerobrineWarden.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */