/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ 
/*    */ import com.pla.annoyingvillagers.client.model.ModelDragonMeteorite;
/*    */ import com.pla.annoyingvillagers.entity.DragonMeteoriteEntity;
/*    */ import net.minecraft.client.model.EntityModel;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.MobRenderer;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
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
/*    */ public class DragonMeteoriteRenderer
/*    */   extends MobRenderer<DragonMeteoriteEntity, ModelDragonMeteorite<DragonMeteoriteEntity>>
/*    */ {
/*    */   public DragonMeteoriteRenderer(EntityRendererProvider.Context context) {
/* 33 */     super(context, (EntityModel)new ModelDragonMeteorite(context.m_174023_(ModelDragonMeteorite.LAYER_LOCATION)), 0.0F);
/*    */   }
/*    */   @NotNull
/*    */   public ResourceLocation getTextureLocation(@NotNull DragonMeteoriteEntity dragonMeteoriteEntity) {
/* 37 */     return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/dragon_meteorite.png");
/*    */   }
/*    */   
/*    */   protected boolean isShaking(@NotNull DragonMeteoriteEntity dragonMeteoriteEntity) {
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\DragonMeteoriteRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */