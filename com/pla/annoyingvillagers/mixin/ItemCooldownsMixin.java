/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemCooldowns;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({ItemCooldowns.class})
/*    */ public class ItemCooldownsMixin {
/*    */   @Inject(method = {"isOnCooldown"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void ignoreCooldownForAegis(Item item, CallbackInfoReturnable<Boolean> cir) {
/* 15 */     if (item == AnnoyingVillagersModItems.ENDER_AEGIS.get())
/* 16 */       cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\ItemCooldownsMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */