/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonUtil
/*    */ {
/*    */   public static boolean isAvDamageableEfnWeaponsMob(Entity livingEntity) {
/* 11 */     return (livingEntity instanceof com.pla.annoyingvillagers.entity.BlueDemonEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.AngrySteveEntity || livingEntity instanceof com.pla.annoyingvillagers.clazz.HerobrineMob || livingEntity instanceof com.pla.annoyingvillagers.entity.HerobrineGregEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.LowHerobrineCloneEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isAvRunawayJudgementCutEndMob(Entity livingEntity) {
/* 20 */     return (livingEntity instanceof com.pla.annoyingvillagers.entity.BlueDemonEntity || livingEntity instanceof com.pla.annoyingvillagers.clazz.AVNpc || livingEntity instanceof com.pla.annoyingvillagers.clazz.HerobrineMob || livingEntity instanceof com.pla.annoyingvillagers.entity.HerobrineGregEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.LowHerobrineCloneEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.LowShadowHerobrineCloneEntity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\CommonUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */