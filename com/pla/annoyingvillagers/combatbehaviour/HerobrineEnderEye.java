/*    */ package com.pla.annoyingvillagers.combatbehaviour;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HerobrineEnderEye
/*    */ {
/* 14 */   public static final CECombatBehaviors.Builder<MobPatch<?>> ENDER_EYE = CECombatBehaviors.builder()
/* 15 */     .newBehaviorRoot(
/* 16 */       CECombatBehaviors.BehaviorRoot.builder()
/* 17 */       .priority(1.0D)
/* 18 */       .weight(1000.0D)
/* 19 */       .maxCooldown(0)
/* 20 */       .addFirstBehavior(
/* 21 */         CECombatBehaviors.Behavior.builder()
/* 22 */         .custom(HerobrineCommon::canPlayObsidianMachine)
/* 23 */         .animationBehavior(AVAnimations.SHADOW_HEROBRINE_BIPED_LANDING, 0.0F)));
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\HerobrineEnderEye.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */