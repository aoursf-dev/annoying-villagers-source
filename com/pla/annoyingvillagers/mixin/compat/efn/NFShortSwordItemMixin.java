/*    */ package com.pla.annoyingvillagers.mixin.compat.efn;
/*    */ 
/*    */ import com.hm.efn.item.custom.NFShortSwordItem;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(value = {NFShortSwordItem.class}, remap = false)
/*    */ public abstract class NFShortSwordItemMixin {
/*    */   @Inject(method = {"isDamageable"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void makeWeaponBreakable(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
/* 14 */     cir.setReturnValue(Boolean.valueOf(true));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\compat\efn\NFShortSwordItemMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */