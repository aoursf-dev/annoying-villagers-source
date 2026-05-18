/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.shelmarow.combat_evolution.execution.ExecutionHandler;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(value = {ExecutionHandler.class}, remap = false)
/*    */ public abstract class ExecutionHandlerMixin {
/*    */   @Inject(method = {"isHoldingWeapon"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void allowExecuteByFist(LivingEntity executor, CallbackInfoReturnable<Boolean> cir) {
/* 14 */     cir.setReturnValue(Boolean.valueOf(true));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\ExecutionHandlerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */