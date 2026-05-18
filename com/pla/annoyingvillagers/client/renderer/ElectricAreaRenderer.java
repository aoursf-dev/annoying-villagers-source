/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.ElectricAreaEntity;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class ElectricAreaRenderer extends EntityRenderer<ElectricAreaEntity> {
/* 14 */   private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/empty.png");
/*    */   
/*    */   public ElectricAreaRenderer(EntityRendererProvider.Context pContext) {
/* 17 */     super(pContext);
/*    */   }
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull ElectricAreaEntity dragonBeam) {
/* 21 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\ElectricAreaRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */