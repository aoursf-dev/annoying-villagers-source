/*    */ package com.pla.annoyingvillagers.skill;
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.skill.SkillBuilder;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*    */ 
/*    */ public class ShadowObsidianPillarSwordSkill extends WeaponInnateSkill {
/*    */   public ShadowObsidianPillarSwordSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/* 11 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 16 */     if (!isActivated(skillContainer)) {
/* 17 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/* 18 */       skillContainer.activate();
/* 19 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE_PILLAR, 0.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 25 */     skillContainer.deactivate();
/* 26 */     super.cancelOnServer(skillContainer, friendlyByteBuf);
/*    */   }
/*    */   
/*    */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 30 */     super.executeOnClient(container, args);
/* 31 */     container.activate();
/*    */   }
/*    */   
/*    */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 35 */     super.cancelOnClient(container, args);
/* 36 */     container.deactivate();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\ShadowObsidianPillarSwordSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */