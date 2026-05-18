/*    */ package com.pla.annoyingvillagers.client.overlaylayer;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.pla.annoyingvillagers.entity.HerobrineGregEntity;
/*    */ import com.pla.annoyingvillagers.util.HerobrineEyesUtil;
/*    */ import net.minecraft.client.model.HumanoidModel;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*    */ import yesman.epicfight.client.mesh.HumanoidMesh;
/*    */ import yesman.epicfight.client.renderer.patched.layer.ModelRenderLayer;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ 
/*    */ public class PlayerMobEpicFightOverlayLayer<E extends LivingEntity, AM extends HumanoidMesh>
/*    */   extends ModelRenderLayer<E, LivingEntityPatch<E>, HumanoidModel<E>, RenderLayer<E, HumanoidModel<E>>, AM>
/*    */ {
/* 25 */   private final ResourceLocation BLOOD_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/player_mob_blood.png");
/* 26 */   private final ResourceLocation DEFAULT_EYE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/default/default.png");
/*    */   public PlayerMobEpicFightOverlayLayer(AssetAccessor<AM> mesh) {
/* 28 */     super(mesh);
/*    */   }
/*    */   private ResourceLocation pickTexture(E e) {
/* 31 */     if (e instanceof com.pla.annoyingvillagers.entity.LowHerobrineCloneEntity) {
/* 32 */       String name = e.m_8077_() ? e.m_7770_().getString() : e.m_7755_().getString();
/* 33 */       return HerobrineEyesUtil.getHerobrineEyesTexture(name);
/* 34 */     }  if (EntityType.m_20613_(e.m_6095_()).equals(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "infected_player_mob")))
/* 35 */       return this.BLOOD_TEXTURE; 
/* 36 */     if (!(e instanceof com.pla.annoyingvillagers.clazz.HerobrineMob) && !(e instanceof com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity)) { if (e instanceof HerobrineGregEntity)
/* 37 */       { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)e; if (herobrineGregEntity.isWhiteEye())
/* 38 */           return this.DEFAULT_EYE;  }  } else { return this.DEFAULT_EYE; }
/*    */     
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderLayer(LivingEntityPatch<E> eLivingEntityPatch, E e, @Nullable RenderLayer<E, HumanoidModel<E>> eHumanoidModelRenderLayer, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, OpenMatrix4f[] openMatrix4fs, float v, float v1, float v2, float v3) {
/* 45 */     ResourceLocation tex = pickTexture(e);
/* 46 */     if (tex == null)
/* 47 */       return;  if (tex == this.BLOOD_TEXTURE) {
/* 48 */       ((HumanoidMesh)this.mesh.get()).draw(poseStack, multiBufferSource, 
/* 49 */           RenderType.m_110458_(tex), i, 1.0F, 1.0F, 1.0F, 1.0F, OverlayTexture.f_118083_, eLivingEntityPatch
/*    */ 
/*    */           
/* 52 */           .getArmature(), openMatrix4fs);
/*    */     } else {
/*    */       
/* 55 */       ((HumanoidMesh)this.mesh.get()).draw(poseStack, multiBufferSource, 
/* 56 */           RenderType.m_110488_(tex), i, 1.0F, 1.0F, 1.0F, 1.0F, OverlayTexture.f_118083_, eLivingEntityPatch
/*    */ 
/*    */           
/* 59 */           .getArmature(), openMatrix4fs);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\overlaylayer\PlayerMobEpicFightOverlayLayer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */