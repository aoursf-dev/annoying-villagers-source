/*    */ package com.pla.annoyingvillagers.compat;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import net.corruptdog.cdm.api.animation.types.InvincibleAttackAnimation;
/*    */ import net.corruptdog.cdm.api.animation.types.PowerAnimation;
/*    */ import net.corruptdog.cdm.gameasset.CorruptAnimations;
/*    */ 
/*    */ public class EpicFightResurrection {
/*  9 */   private static final Set<String> DANGEROUS_ANIMATIONS = new HashSet<>();
/*    */   
/*    */   static {
/* 12 */     DANGEROUS_ANIMATIONS.addAll(Set.of(((InvincibleAttackAnimation)CorruptAnimations.YAMATO_JUDGEMENT_CUT
/* 13 */           .get()).getRegistryName().toString(), ((YamatoSkillAnimation)CorruptAnimations.YAMATO_JUDGEMENT_CUT_JUST
/* 14 */           .get()).getRegistryName().toString(), ((PowerAnimation)CorruptAnimations.YAMATO_JUDGEMENT_CUT_END
/* 15 */           .get()).getRegistryName().toString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static Set<String> getDangerousAnimations() {
/* 20 */     return DANGEROUS_ANIMATIONS;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\compat\EpicFightResurrection.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */