/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ import yesman.epicfight.world.damagesource.StunType;
/*    */ 
/*    */ @Mixin(value = {LivingEntityPatch.class}, remap = false)
/*    */ public abstract class LivingEntityPatchMixin
/*    */ {
/*    */   @Inject(method = {"applyStun"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void preventStunOveride(StunType stunType, float stunTime, CallbackInfoReturnable<Boolean> cir) {
/* 21 */     LivingEntityPatch<?> self = (LivingEntityPatch)this;
/* 22 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(self.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 23 */     if ((stunType == StunType.SHORT || stunType == StunType.LONG || stunType == StunType.HOLD) && (dynamicAnimation == AVAnimations.HIT_BACKWARD || dynamicAnimation == AVAnimations.HIT_LEFT || dynamicAnimation == AVAnimations.HIT_RIGHT)) {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 29 */       ((LivingEntity)self.getOriginal()).f_20900_ = 0.0F;
/* 30 */       ((LivingEntity)self.getOriginal()).f_20901_ = 0.0F;
/* 31 */       ((LivingEntity)self.getOriginal()).f_20902_ = 0.0F;
/* 32 */       ((LivingEntity)self.getOriginal()).m_20334_(0.0D, 0.0D, 0.0D);
/* 33 */       cir.setReturnValue(Boolean.valueOf(true));
/* 34 */       cir.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\LivingEntityPatchMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */