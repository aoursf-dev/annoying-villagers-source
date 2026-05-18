/*    */ package com.pla.annoyingvillagers.event;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import reascer.wom.skill.weaponinnate.DemonicAscensionSkill;
/*    */ import reascer.wom.world.item.WOMItems;
/*    */ import yesman.epicfight.skill.Skill;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class WomFixEvent {
/*    */   @SubscribeEvent
/*    */   public static void fixAntitheusCrash(TickEvent.PlayerTickEvent playerTickEvent) {
/*    */     ServerPlayerPatch serverPlayerPatch;
/*    */     DemonicAscensionSkill demonicAscensionSkill;
/* 18 */     if (!playerTickEvent.side.isServer())
/*    */       return; 
/* 20 */     PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)playerTickEvent.player, PlayerPatch.class);
/* 21 */     if (playerPatch instanceof ServerPlayerPatch) { serverPlayerPatch = (ServerPlayerPatch)playerPatch; }
/*    */     else { return; }
/* 23 */      SkillContainer skillContainer = serverPlayerPatch.getSkill(WOMSkills.DEMONIC_ASCENSION);
/* 24 */     if (skillContainer != null) { Skill skill = skillContainer.getSkill(); if (skill instanceof DemonicAscensionSkill) { demonicAscensionSkill = (DemonicAscensionSkill)skill; } else { return; }  }
/*    */     else { return; }
/* 26 */      if (!skillContainer.isActivated())
/*    */       return; 
/* 28 */     boolean holdingAntitheus = playerTickEvent.player.m_21205_().m_150930_(WOMItems.ANTITHEUS.get());
/* 29 */     if (holdingAntitheus)
/* 30 */       return;  demonicAscensionSkill.cancelOnServer(skillContainer, null);
/* 31 */     skillContainer.deactivate();
/* 32 */     if (serverPlayerPatch.getAnimator() != null)
/* 33 */       serverPlayerPatch.getAnimator().stopPlaying(null); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\WomFixEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */