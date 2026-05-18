/*    */ package com.pla.annoyingvillagers.skill;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.skill.SkillBuilder;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShadowObsidianPillarSkill
/*    */   extends WeaponInnateSkill
/*    */ {
/* 16 */   private static final UUID EVENT_UUID = UUID.fromString("b7ee1d55-ecdf-49e4-bcba-5f26cd097d35");
/*    */   
/*    */   public ShadowObsidianPillarSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/* 19 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 24 */     if (!isActivated(skillContainer)) {
/* 25 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/* 26 */       skillContainer.activate();
/* 27 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_BIPED_LANDING, 0.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 33 */     skillContainer.deactivate();
/* 34 */     super.cancelOnServer(skillContainer, friendlyByteBuf);
/*    */   }
/*    */   
/*    */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 38 */     super.executeOnClient(container, args);
/* 39 */     container.activate();
/*    */   }
/*    */   
/*    */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 43 */     super.cancelOnClient(container, args);
/* 44 */     container.deactivate();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\ShadowObsidianPillarSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */