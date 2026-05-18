/*    */ package com.pla.annoyingvillagers.mixin.compat.efn;
/*    */ import com.hm.efn.mobeffects.StopEffect;
/*    */ import com.hm.efn.registries.EFNMobEffectRegistry;
/*    */ import com.pla.annoyingvillagers.util.CommonUtil;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin(value = {StopEffect.class}, remap = false)
/*    */ public abstract class StopEffectMixin {
/*    */   @Inject(method = {"applyEffectTick"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void makeAvMobUnstoppable(LivingEntity owner, int lv, CallbackInfo ci) {
/* 16 */     if (CommonUtil.isAvRunawayJudgementCutEndMob((Entity)owner)) {
/* 17 */       if (!owner.m_9236_().m_5776_()) {
/* 18 */         owner.m_21195_((MobEffect)EFNMobEffectRegistry.STOP.get());
/*    */       }
/* 20 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\compat\efn\StopEffectMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */