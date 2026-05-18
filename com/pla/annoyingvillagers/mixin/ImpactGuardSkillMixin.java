/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.pla.annoyingvillagers.item.EnderAegisItem;
/*    */ import com.pla.annoyingvillagers.skill.BedrockWeaponSkill;
/*    */ import com.pla.annoyingvillagers.skill.EnderAegisSkill;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.tags.DamageTypeTags;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.damagesource.DamageTypes;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import yesman.epicfight.skill.guard.ImpactGuardSkill;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*    */ import yesman.epicfight.world.entity.eventlistener.TakeDamageEvent;
/*    */ 
/*    */ @Mixin(value = {ImpactGuardSkill.class}, remap = false)
/*    */ public abstract class ImpactGuardSkillMixin {
/*    */   private static boolean isAdvancedBlockableDamageSource(DamageSource damageSource) {
/* 27 */     return (damageSource.m_269533_(DamageTypeTags.f_268415_) || damageSource.m_276093_(DamageTypes.f_268515_) || damageSource.m_269533_(DamageTypeTags.f_268745_) || damageSource.m_269533_(DamageTypeTags.f_268524_) || damageSource.m_269533_(DamageTypeTags.f_268490_));
/*    */   }
/*    */   
/*    */   @Inject(method = {"dealEvent"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void playerOnGuard(PlayerPatch<?> playerpatch, TakeDamageEvent.Attack event, boolean advanced, CallbackInfo ci) {
/* 32 */     boolean isSpecialSource = isAdvancedBlockableDamageSource(event.getDamageSource());
/* 33 */     if (!isSpecialSource) {
/* 34 */       ServerPlayer serverPlayer; Player player = (Player)playerpatch.getOriginal();
/* 35 */       if (player instanceof ServerPlayer) { serverPlayer = (ServerPlayer)player; }
/*    */       else { return; }
/* 37 */        ItemStack main = serverPlayer.m_21205_();
/* 38 */       if (main.m_41720_() instanceof EnderAegisItem) {
/* 39 */         if (main.m_41782_() && ((CompoundTag)Objects.<CompoundTag>requireNonNull(main.m_41783_())).m_128471_("SecondForm")) {
/* 40 */           EnderAegisItem.shieldShoot(serverPlayer.m_9236_(), (Entity)serverPlayer);
/*    */         } else {
/* 42 */           EnderAegisSkill.onParry((ServerPlayerPatch)playerpatch);
/*    */         } 
/*    */       }
/* 45 */       if (main.m_41720_() instanceof com.pla.annoyingvillagers.item.BedrockWeaponItem)
/* 46 */         BedrockWeaponSkill.onParry((ServerPlayerPatch)playerpatch); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\ImpactGuardSkillMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */