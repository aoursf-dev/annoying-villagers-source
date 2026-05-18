/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*    */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*    */ import com.pla.annoyingvillagers.util.CommonUtil;
/*    */ import com.pla.annoyingvillagers.util.EscapeUtil;
/*    */ import com.pla.efclash_blade.skill.ClashBladeSkill;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraftforge.fml.ModList;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ import yesman.epicfight.api.animation.types.EntityState;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {ClashBladeSkill.class}, remap = false)
/*    */ public class ClashBladeMixin
/*    */ {
/*    */   @Inject(method = {"blacklistClashBladeAnimation"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void rejectClashBladeFromAnimationsCondition(AssetAccessor<? extends StaticAnimation> dynamicAnimation, EntityState entityState, ServerPlayer serverPlayer, CallbackInfoReturnable<Boolean> cir) {
/* 29 */     if (dynamicAnimation.get() instanceof com.pla.annoyingvillagers.animations.BowAttackAnimation) {
/* 30 */       cir.setReturnValue(Boolean.valueOf(false));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"getWeaponDestroyValueOnClash"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void forceDestroyWeaponValueOnClash(AssetAccessor<? extends StaticAnimation> dynamicAnimation, DamageSource damageSource, PlayerPatch<?> playerPatch, ServerLevel serverLevel, CallbackInfoReturnable<Integer> cir) {
/* 40 */     if (ModList.get().isLoaded("efn") && 
/* 41 */       EpicFightNightFall.isEfnWeapons(((Player)playerPatch.getOriginal()).m_21205_())) {
/* 42 */       if (CommonUtil.isAvDamageableEfnWeaponsMob(damageSource.m_7639_())) {
/* 43 */         if (EscapeUtil.isAnimationDangerous(dynamicAnimation)) {
/* 44 */           cir.setReturnValue(Integer.valueOf(((Integer)AnnoyingVillagersConfig.WEAPON_BREAKING_MECHANISM_VALUE.get()).intValue() * 5));
/*    */         } else {
/* 46 */           cir.setReturnValue(AnnoyingVillagersConfig.WEAPON_BREAKING_MECHANISM_VALUE.get());
/*    */         } 
/*    */       }
/* 49 */       cir.setReturnValue(Integer.valueOf(0));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\ClashBladeMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */