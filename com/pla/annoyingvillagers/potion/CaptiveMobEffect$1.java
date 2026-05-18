/*    */ package com.pla.annoyingvillagers.potion;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraftforge.client.event.RenderGuiOverlayEvent;
/*    */ import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;
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
/*    */ class null
/*    */   implements IClientMobEffectExtensions
/*    */ {
/*    */   public boolean shouldRender(MobEffectInstance mobeffectinstance) {
/* 29 */     return false;
/*    */   }
/*    */   
/*    */   public boolean shouldRenderInvText(MobEffectInstance mobeffectinstance) {
/* 33 */     return false;
/*    */   }
/*    */   
/*    */   public boolean shouldRenderHUD(MobEffectInstance mobeffectinstance) {
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public void renderInventoryEffect(MobEffectInstance mobeffectinstance, EffectRenderingInventoryScreen<?> effectrenderinginventoryscreen, PoseStack posestack, int i, int j, float f) {}
/*    */   
/*    */   public void renderHUDEffect(MobEffectInstance mobeffectinstance, RenderGuiOverlayEvent renderGuiOverlayEvent, PoseStack posestack, int i, int j, float f, float f1) {}
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\potion\CaptiveMobEffect$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */