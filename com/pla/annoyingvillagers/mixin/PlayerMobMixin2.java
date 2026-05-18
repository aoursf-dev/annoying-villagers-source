/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import se.gory_moon.player_mobs.entity.PlayerMobEntity;
/*    */ 
/*    */ @Mixin(value = {PlayerMobEntity.class}, remap = false)
/*    */ public class PlayerMobMixin2
/*    */ {
/*    */   @Inject(method = {"setCombatTask"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void cancelCombatTaskForPlayerNpc(CallbackInfo ci) {
/* 14 */     if (this instanceof com.pla.annoyingvillagers.entity.PlayerNpcEntity)
/* 15 */       ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\PlayerMobMixin2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */