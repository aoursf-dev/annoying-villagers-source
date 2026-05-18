/*    */ package com.pla.annoyingvillagers.mixin.client;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVSkillDataKeys;
/*    */ import com.pla.annoyingvillagers.item.BlueDemonTridentItem;
/*    */ import net.minecraft.client.gui.GuiGraphics;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import yesman.epicfight.client.gui.BattleModeGui;
/*    */ import yesman.epicfight.skill.Skill;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.skill.SkillDataKey;
/*    */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {WeaponInnateSkill.class}, remap = false)
/*    */ public class WeaponInnateSkillMixin
/*    */ {
/*    */   @Redirect(method = {"drawOnGui"}, at = @At(value = "INVOKE", target = "Lyesman/epicfight/skill/Skill;getSkillTexture()Lnet/minecraft/resources/ResourceLocation;"))
/*    */   private ResourceLocation dynamicSkillTextureForTridentFestival(Skill skill, BattleModeGui gui, SkillContainer container, GuiGraphics guiGraphics, float x, float y, float partialTick) {
/* 31 */     if (skill instanceof com.pla.annoyingvillagers.skill.TridentFestivalSkill) {
/* 32 */       boolean ranged = ((Boolean)container.getDataManager().getDataValue((SkillDataKey)AVSkillDataKeys.IS_TRIDENT_RANGED_MODE.get())).booleanValue();
/* 33 */       Player player = (Player)container.getExecutor().getOriginal();
/* 34 */       ItemStack mainHand = player.m_21205_();
/* 35 */       ItemStack offHand = player.m_21206_();
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 40 */       boolean bothFullyCharged = (BlueDemonTridentItem.isBlueDemonTrident(mainHand) && BlueDemonTridentItem.isBlueDemonTrident(offHand) && BlueDemonTridentItem.checkOnlyFullyCharged(mainHand) && BlueDemonTridentItem.checkOnlyFullyCharged(offHand));
/* 41 */       if (ranged && bothFullyCharged) {
/* 42 */         return ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/gui/skills/weapon_innate/trident_festival.png");
/*    */       }
/*    */ 
/*    */ 
/*    */       
/* 47 */       return ranged ? 
/* 48 */         ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/gui/skills/weapon_innate/blue_demon_trident_ranged.png") : 
/* 49 */         ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/gui/skills/weapon_innate/blue_demon_trident_melee.png");
/*    */     } 
/*    */     
/* 52 */     return skill.getSkillTexture();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"drawOnGui"}, at = {@At("TAIL")}, remap = false)
/*    */   private void drawTridentFestivalStack(BattleModeGui gui, SkillContainer container, GuiGraphics guiGraphics, float x, float y, float partialTick, CallbackInfo ci) {
/* 65 */     Skill skill = container.getSkill();
/* 66 */     if (!(skill instanceof com.pla.annoyingvillagers.skill.TridentFestivalSkill) || skill.getMaxStack() > 1) {
/*    */       return;
/*    */     }
/*    */     
/* 70 */     guiGraphics.m_280168_().m_85836_();
/* 71 */     guiGraphics.m_280168_().m_252880_(0.0F, gui.getSlidingProgression(), 0.0F);
/*    */     
/* 73 */     String s = String.valueOf(container.getDataManager().getDataValue((SkillDataKey)AVSkillDataKeys.TRIDENT_AMOUNT.get()));
/* 74 */     int stringWidth = (gui.getFont().m_92895_(s) - 6) / 3;
/* 75 */     guiGraphics.drawString(gui.getFont(), s, x + 25.0F - stringWidth, y + 22.0F, 16777215, true);
/*    */     
/* 77 */     guiGraphics.m_280168_().m_85849_();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\client\WeaponInnateSkillMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */