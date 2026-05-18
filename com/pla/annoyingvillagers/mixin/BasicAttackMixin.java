/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ import yesman.epicfight.skill.BasicAttack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({BasicAttack.class})
/*    */ public abstract class BasicAttackMixin
/*    */ {
/*    */   @Redirect(method = {"executeOnServer"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;isPassenger()Z"))
/*    */   private boolean annoyingvillagers$dragonTreatAsNotPassenger(ServerPlayer player) {
/* 21 */     Entity vehicle = player.m_20202_();
/* 22 */     if (vehicle instanceof com.pla.annoyingvillagers.entity.HerobrineDragonEntity) {
/* 23 */       return false;
/*    */     }
/* 25 */     return player.m_20159_();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\BasicAttackMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */