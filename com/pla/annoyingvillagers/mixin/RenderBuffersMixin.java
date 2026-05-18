/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.BufferBuilder;
/*    */ import com.pla.annoyingvillagers.client.renderer.ColoredGlintRenderTypes;
/*    */ import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
/*    */ import net.minecraft.client.renderer.RenderBuffers;
/*    */ import net.minecraft.client.renderer.RenderType;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
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
/*    */ @Mixin({RenderBuffers.class})
/*    */ public class RenderBuffersMixin
/*    */ {
/*    */   @Inject(method = {"put"}, at = {@At("HEAD")})
/*    */   private static void addGlintTypes(Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder> mapBuildersIn, RenderType renderTypeIn, CallbackInfo callbackInfo) {
/* 39 */     ColoredGlintRenderTypes.registerIntoFixed(mapBuildersIn);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\RenderBuffersMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */