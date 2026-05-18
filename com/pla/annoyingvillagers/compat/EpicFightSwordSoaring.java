/*    */ package com.pla.annoyingvillagers.compat;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import net.p1nero.ss.gameassets.animations.BabylonAnimations;
/*    */ import net.p1nero.ss.gameassets.animations.ScreenSwordAnimations;
/*    */ import net.p1nero.ss.gameassets.animations.WanAnimations;
/*    */ import yesman.epicfight.api.animation.types.ActionAnimation;
/*    */ 
/*    */ public class EpicFightSwordSoaring {
/* 11 */   private static final Set<String> DANGEROUS_ANIMATIONS = new HashSet<>();
/*    */   
/*    */   static {
/* 14 */     DANGEROUS_ANIMATIONS.addAll(Set.of(((ActionAnimation)ScreenSwordAnimations.PLAYER_SUMMON_KILL_AURA_1
/* 15 */           .get()).getRegistryName().toString(), ((ActionAnimation)ScreenSwordAnimations.PLAYER_SUMMON_KILL_AURA_2
/* 16 */           .get()).getRegistryName().toString(), ((ActionAnimation)ScreenSwordAnimations.PLAYER_SUMMON_SCREEN_SWORD
/* 17 */           .get()).getRegistryName().toString(), ((ActionAnimation)ScreenSwordAnimations.PLAYER_SUMMON_RAIN_SWORD
/* 18 */           .get()).getRegistryName().toString(), ((ActionAnimation)BabylonAnimations.BABYLON_SUMMON_PLAYER
/* 19 */           .get()).getRegistryName().toString(), ((ActionAnimation)WanAnimations.WAN1_PLAYER
/* 20 */           .get()).getRegistryName().toString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static Set<String> getDangerousAnimations() {
/* 25 */     return DANGEROUS_ANIMATIONS;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\compat\EpicFightSwordSoaring.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */