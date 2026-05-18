/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ import com.pla.annoyingvillagers.item.EnderAegisItem;
/*    */ import com.pla.annoyingvillagers.skill.BedrockWeaponSkill;
/*    */ import com.pla.annoyingvillagers.skill.EnderAegisSkill;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import yesman.epicfight.skill.guard.GuardSkill;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*    */ import yesman.epicfight.world.entity.eventlistener.TakeDamageEvent;
/*    */ 
/*    */ @Mixin(value = {GuardSkill.class}, remap = false)
/*    */ public abstract class GuardSkillMixin {
/*    */   @Inject(method = {"dealEvent"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void playerOnGuard(PlayerPatch<?> playerpatch, TakeDamageEvent.Attack event, boolean advanced, CallbackInfo ci) {
/*    */     ServerPlayer serverPlayer;
/* 25 */     Player player = (Player)playerpatch.getOriginal();
/* 26 */     if (player instanceof ServerPlayer) { serverPlayer = (ServerPlayer)player; }
/*    */     else { return; }
/* 28 */      ItemStack main = serverPlayer.m_21205_();
/* 29 */     if (main.m_41720_() instanceof EnderAegisItem) {
/* 30 */       if (main.m_41782_() && ((CompoundTag)Objects.<CompoundTag>requireNonNull(main.m_41783_())).m_128471_("SecondForm")) {
/* 31 */         EnderAegisItem.shieldShoot(serverPlayer.m_9236_(), (Entity)serverPlayer);
/*    */       } else {
/* 33 */         EnderAegisSkill.onParry((ServerPlayerPatch)playerpatch);
/*    */       } 
/*    */     }
/* 36 */     if (main.m_41720_() instanceof com.pla.annoyingvillagers.item.BedrockWeaponItem)
/* 37 */       BedrockWeaponSkill.onParry((ServerPlayerPatch)playerpatch); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\GuardSkillMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */