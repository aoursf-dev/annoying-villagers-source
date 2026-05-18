/*    */ package com.pla.annoyingvillagers.client.overlaylayer;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.mojang.blaze3d.vertex.VertexConsumer;
/*    */ import net.minecraft.client.model.PlayerModel;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import net.minecraft.client.renderer.entity.RenderLayerParent;
/*    */ import net.minecraft.client.renderer.entity.layers.RenderLayer;
/*    */ import net.minecraft.client.renderer.texture.OverlayTexture;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import se.gory_moon.player_mobs.entity.PlayerMobEntity;
/*    */ 
/*    */ public class PlayerMobBloodOverlayLayer extends RenderLayer<PlayerMobEntity, PlayerModel<PlayerMobEntity>> {
/* 16 */   private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/player_mob_blood.png");
/*    */   
/*    */   public PlayerMobBloodOverlayLayer(RenderLayerParent<PlayerMobEntity, PlayerModel<PlayerMobEntity>> parent) {
/* 19 */     super(parent);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(PoseStack pose, MultiBufferSource buf, int light, PlayerMobEntity e, float limbSwing, float limbSwingAmount, float partialTick, float age, float headYaw, float headPitch) {
/* 27 */     PlayerModel<PlayerMobEntity> model = (PlayerModel<PlayerMobEntity>)m_117386_();
/* 28 */     VertexConsumer vc = buf.m_6299_(RenderType.m_110458_(TEX));
/* 29 */     model.m_7695_(pose, vc, light, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\overlaylayer\PlayerMobBloodOverlayLayer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */