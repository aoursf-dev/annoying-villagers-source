/*    */ package com.pla.annoyingvillagers.mixin.compat.efn;
/*    */ 
/*    */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*    */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*    */ import com.pla.annoyingvillagers.util.CommonUtil;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(value = {SwordItem.class}, remap = false)
/*    */ public abstract class SwordItemMixin {
/*    */   @Inject(method = {"hurtEnemy"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void damageEfnWeapons(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker, CallbackInfoReturnable<Boolean> cir) {
/* 20 */     if (pAttacker instanceof net.minecraft.world.entity.player.Player && 
/* 21 */       EpicFightNightFall.isEfnWeapons(pStack)) {
/* 22 */       if (CommonUtil.isAvDamageableEfnWeaponsMob((Entity)pTarget)) {
/* 23 */         pStack.m_41622_(((Integer)AnnoyingVillagersConfig.WEAPON_BREAKING_MECHANISM_VALUE.get()).intValue(), pAttacker, livingEntity -> livingEntity.m_21166_(EquipmentSlot.MAINHAND));
/*    */       }
/*    */ 
/*    */       
/* 27 */       cir.setReturnValue(Boolean.valueOf(true));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\compat\efn\SwordItemMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */