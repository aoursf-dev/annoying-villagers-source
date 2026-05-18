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
/*    */ public class ObsidianWeaponSkill extends WeaponInnateSkill {
/* 12 */   private static final UUID EVENT_UUID = UUID.fromString("085ad71d-197e-4793-87da-21afa91e916b");
/*    */   
/*    */   public ObsidianWeaponSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/* 15 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 20 */     if (!isActivated(skillContainer)) {
/* 21 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/* 22 */       skillContainer.activate();
/* 23 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.OBSIDIAN_ZOMBIE_ATTACK3, 0.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancelOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 29 */     skillContainer.deactivate();
/* 30 */     super.cancelOnServer(skillContainer, friendlyByteBuf);
/*    */   }
/*    */   
/*    */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 34 */     super.executeOnClient(container, args);
/* 35 */     container.activate();
/*    */   }
/*    */   
/*    */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 39 */     super.cancelOnClient(container, args);
/* 40 */     container.deactivate();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\ObsidianWeaponSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */