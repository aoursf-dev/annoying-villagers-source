/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.vehicle.Boat;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({Boat.class})
/*    */ public abstract class BoatMixin
/*    */ {
/*    */   @Inject(method = {"canAddPassenger"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void blockSpecificMobsFromBoat(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
/* 18 */     if (annoyingVillagers$shouldIgnoreBoat(passenger)) {
/* 19 */       cir.setReturnValue(Boolean.valueOf(false));
/*    */     }
/*    */   }
/*    */   
/*    */   @Unique
/*    */   private static boolean annoyingVillagers$shouldIgnoreBoat(Entity entity) {
/* 25 */     return (entity instanceof com.pla.annoyingvillagers.entity.BlueDemonEntity || entity instanceof com.pla.annoyingvillagers.clazz.HerobrineMob || entity instanceof com.pla.annoyingvillagers.clazz.AVNpc || entity instanceof com.pla.annoyingvillagers.entity.PlayerNpcEntity || entity instanceof com.pla.annoyingvillagers.entity.LowHerobrineCloneEntity || entity instanceof com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity || entity instanceof com.pla.annoyingvillagers.entity.BbqEntity || entity instanceof com.pla.annoyingvillagers.entity.HerobrineGregEntity || entity instanceof com.pla.annoyingvillagers.entity.NullSkeletonEntity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\BoatMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */