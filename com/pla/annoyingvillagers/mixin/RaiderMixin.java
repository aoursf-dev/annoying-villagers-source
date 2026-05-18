/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ import com.pla.annoyingvillagers.util.CommonGoals;
/*    */ import net.minecraft.world.entity.monster.Monster;
/*    */ import net.minecraft.world.entity.monster.Zombie;
/*    */ import net.minecraft.world.entity.raid.Raider;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {Raider.class}, remap = true)
/*    */ public class RaiderMixin {
/*    */   @Inject(method = {"registerGoals"}, at = {@At("HEAD")})
/*    */   private void monsterTargetNpc(CallbackInfo ci) {
/* 15 */     RaiderMixin raiderMixin = this; if (raiderMixin instanceof Zombie) { Zombie monster = (Zombie)raiderMixin;
/* 16 */       CommonGoals.registerGoalForHostileNpc((Monster)monster); }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\RaiderMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */