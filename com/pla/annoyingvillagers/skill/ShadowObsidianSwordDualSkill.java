/*    */ package com.pla.annoyingvillagers.skill;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.skill.SkillBuilder;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*    */ 
/*    */ public class ShadowObsidianSwordDualSkill
/*    */   extends WeaponInnateSkill {
/*    */   public ShadowObsidianSwordDualSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/* 13 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 18 */     if (!isActivated(skillContainer)) {
/* 19 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/* 20 */       skillContainer.activate();
/* 21 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.SHADOW_OBSIDIAN_SWORD_GREATSWORD_DUAL_EARTHQUAKE, 0.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 27 */     skillContainer.deactivate();
/* 28 */     super.cancelOnServer(skillContainer, friendlyByteBuf);
/*    */   }
/*    */   
/*    */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 32 */     super.executeOnClient(container, args);
/* 33 */     container.activate();
/*    */   }
/*    */   
/*    */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 37 */     super.cancelOnClient(container, args);
/* 38 */     container.deactivate();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\ShadowObsidianSwordDualSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */