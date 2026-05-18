/*    */ package com.pla.annoyingvillagers.skill;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.skill.SkillBuilder;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*    */ 
/*    */ public class EnderGlaiveSkill extends WeaponInnateSkill {
/* 16 */   private static final UUID EVENT_UUID = UUID.fromString("f79be742-fddd-454d-bd28-4d030613b284");
/*    */   
/*    */   public EnderGlaiveSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/* 19 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 24 */     if (!isActivated(skillContainer)) {
/* 25 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/* 26 */       skillContainer.activate();
/* 27 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.ENDER_GLAIVE_AGONY_AUTO_1, 0.0F);
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
/*    */ 
/*    */   
/*    */   public void updateContainer(SkillContainer container) {
/* 49 */     super.updateContainer(container);
/* 50 */     Player player = (Player)container.getExecutor().getOriginal();
/* 51 */     ItemStack itemStack = player.m_21205_();
/* 52 */     if (container.getStack() == 1 && itemStack.m_41783_() != null && itemStack
/* 53 */       .m_41720_() instanceof com.pla.annoyingvillagers.item.EnderGlaiveItem && !itemStack.m_41783_().m_128471_("PlaySound")) {
/* 54 */       ((Player)container.getExecutor().getOriginal()).m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_WEAPON_SCREAMING.get(), 0.8F, 1.0F);
/* 55 */       itemStack.m_41783_().m_128379_("PlaySound", true);
/* 56 */     } else if (container.getStack() < 1 && itemStack.m_41783_() != null && itemStack
/* 57 */       .m_41720_() instanceof com.pla.annoyingvillagers.item.EnderGlaiveItem && itemStack.m_41783_().m_128471_("PlaySound")) {
/* 58 */       itemStack.m_41783_().m_128473_("PlaySound");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\EnderGlaiveSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */