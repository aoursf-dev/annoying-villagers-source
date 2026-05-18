/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ import se.gory_moon.player_mobs.entity.PlayerMobEntity;
/*    */ 
/*    */ @Mixin(value = {PlayerMobEntity.class}, remap = true)
/*    */ public class PlayerMobMixin {
/*    */   @Inject(method = {"isBaby"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void forceIsNotBaby(CallbackInfoReturnable<Boolean> cir) {
/* 14 */     cir.setReturnValue(Boolean.valueOf(false));
/*    */   }
/*    */   
/*    */   @Inject(method = {"setBaby"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void blockSetBaby(boolean isChild, CallbackInfo ci) {
/* 19 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\PlayerMobMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */