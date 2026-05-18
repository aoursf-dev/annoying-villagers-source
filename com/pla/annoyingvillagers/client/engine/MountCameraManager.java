/*    */ package com.pla.annoyingvillagers.client.engine;
/*    */ 
/*    */ import net.minecraft.client.Camera;
/*    */ import net.minecraft.client.CameraType;
/*    */ import net.minecraft.client.Minecraft;
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
/*    */ public class MountCameraManager
/*    */ {
/* 28 */   private static CameraType previousPerspective = CameraType.FIRST_PERSON;
/*    */ 
/*    */   
/*    */   public static void onDragonMount() {
/* 32 */     previousPerspective = (Minecraft.m_91087_()).f_91066_.m_92176_();
/* 33 */     (Minecraft.m_91087_()).f_91066_.m_92157_(CameraType.THIRD_PERSON_BACK);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void onDragonDismount() {
/* 38 */     (Minecraft.m_91087_()).f_91066_.m_92157_(previousPerspective);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setMountCameraAngles(Camera camera) {
/* 44 */     if ((Minecraft.m_91087_()).f_91074_.m_20202_() instanceof com.pla.annoyingvillagers.entity.HerobrineDragonEntity && !(Minecraft.m_91087_()).f_91066_.m_92176_().m_90612_()) {
/*    */       
/* 46 */       camera.m_90568_(0.0D, 4.0D, 0.0D);
/* 47 */       camera.m_90568_(-camera.m_90566_(6.0D), 0.0D, 0.0D);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\engine\MountCameraManager.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */