/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ import com.pla.annoyingvillagers.util.CommonGoals;
/*    */ import net.minecraft.world.entity.monster.AbstractIllager;
/*    */ import net.minecraft.world.entity.monster.Monster;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {AbstractIllager.class}, remap = true)
/*    */ public class IllagerMixin {
/*    */   @Inject(method = {"registerGoals"}, at = {@At("HEAD")})
/*    */   private void monsterTargetNpc(CallbackInfo ci) {
/* 14 */     AbstractIllager self = (AbstractIllager)this;
/* 15 */     CommonGoals.registerGoalForHostileNpc((Monster)self);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\IllagerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */