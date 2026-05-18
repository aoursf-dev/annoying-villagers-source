/*    */ package com.pla.annoyingvillagers.clazz;
/*    */ 
/*    */ public enum SauceType {
/*  4 */   BBQ_SAUCE("entity.annoyingvillagers.bbq_sauce"),
/*  5 */   SWEET_ONION_SAUCE("entity.annoyingvillagers.sweet_onion_sauce"),
/*  6 */   HONEY_MUSTARD_SAUCE("entity.annoyingvillagers.honey_mustard_sauce"),
/*  7 */   SOY_SAUCE("entity.annoyingvillagers.soy_sauce");
/*    */   
/*    */   private final String translationKey;
/*    */   
/*    */   SauceType(String translationKey) {
/* 12 */     this.translationKey = translationKey;
/*    */   }
/*    */   
/*    */   public String getTranslationKey() {
/* 16 */     return this.translationKey;
/*    */   }
/*    */   
/*    */   public boolean isSupport() {
/* 20 */     return (this == SWEET_ONION_SAUCE);
/*    */   }
/*    */   
/*    */   public boolean isShockSauce() {
/* 24 */     return (this == HONEY_MUSTARD_SAUCE || this == SOY_SAUCE);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\SauceType.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */