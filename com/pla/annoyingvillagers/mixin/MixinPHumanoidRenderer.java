/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.pla.annoyingvillagers.client.overlaylayer.PlayerMobEpicFightOverlayLayer;
/*    */ import net.minecraft.client.renderer.entity.EntityRendererProvider;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.client.renderer.patched.entity.PHumanoidRenderer;
/*    */ import yesman.epicfight.client.renderer.patched.entity.PatchedLivingEntityRenderer;
/*    */ import yesman.epicfight.client.renderer.patched.layer.PatchedLayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {PHumanoidRenderer.class}, remap = false)
/*    */ public abstract class MixinPHumanoidRenderer
/*    */ {
/*    */   @Inject(method = {"<init>"}, at = {@At("TAIL")})
/*    */   private void addHerobrineEye(AssetAccessor<?> mesh, EntityRendererProvider.Context ctx, EntityType<?> type, CallbackInfo ci) {
/* 22 */     PatchedLivingEntityRenderer<?, ?, ?, ?, ?> self = (PatchedLivingEntityRenderer<?, ?, ?, ?, ?>)this;
/*    */     
/* 24 */     self.addCustomLayer((PatchedLayer)new PlayerMobEpicFightOverlayLayer(mesh));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\MixinPHumanoidRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */