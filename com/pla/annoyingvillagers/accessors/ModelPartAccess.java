/*    */ package com.pla.annoyingvillagers.accessors;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ModelPartAccess
/*    */ {
/*    */   float getXScale();
/*    */   
/*    */   float getYScale();
/*    */   
/*    */   float getZScale();
/*    */   
/*    */   void setXScale(float paramFloat);
/*    */   
/*    */   void setYScale(float paramFloat);
/*    */   
/*    */   void setZScale(float paramFloat);
/*    */   
/*    */   default void setRenderScale(float x, float y, float z) {
/* 37 */     setXScale(x);
/* 38 */     setYScale(y);
/* 39 */     setZScale(z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\accessors\ModelPartAccess.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */