/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.renderer.texture.TextureAtlas;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraftforge.client.event.TextureStitchEvent;
/*    */ import org.jetbrains.annotations.ApiStatus.Internal;
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
/*    */ public class Pre
/*    */   extends TextureStitchEvent
/*    */ {
/*    */   private final Set<ResourceLocation> sprites;
/*    */   
/*    */   @Internal
/*    */   public Pre(TextureAtlas map, Set<ResourceLocation> sprites) {
/* 71 */     super(map);
/* 72 */     this.sprites = sprites;
/*    */   }
/*    */   
/*    */   public boolean addSprite(ResourceLocation sprite) {
/* 76 */     return this.sprites.add(sprite);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\ModModelPredicateProvider$Pre.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */