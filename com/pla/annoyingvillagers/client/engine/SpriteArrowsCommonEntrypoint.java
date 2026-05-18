/*    */ package com.pla.annoyingvillagers.client.engine;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderers;
/*    */ import net.minecraft.world.entity.EntityType;
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
/*    */ 
/*    */ public class SpriteArrowsCommonEntrypoint
/*    */ {
/*    */   public static void replace() {
/* 31 */     Map<EntityType<?>, EntityRendererProvider<?>> providers = EntityRenderers.f_174031_;
/* 32 */     replaceForArrow(providers, EntityType.f_20548_);
/* 33 */     replaceForArrow(providers, EntityType.f_20478_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static <T extends net.minecraft.world.entity.projectile.AbstractArrow> void replaceForArrow(Map<EntityType<?>, EntityRendererProvider<?>> providers, EntityType<T> type) {
/* 40 */     if (!providers.containsKey(type)) {
/*    */       return;
/*    */     }
/* 43 */     providers.put(type, com.pla.annoyingvillagers.client.renderer.SpriteArrowRenderer::new);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\SpriteArrowsCommonEntrypoint.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */