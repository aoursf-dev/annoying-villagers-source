/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.event.ShieldRendererEvent;
/*    */ import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
/*    */ import net.minecraftforge.client.extensions.common.IClientItemExtensions;
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
/*    */   implements IClientItemExtensions
/*    */ {
/*    */   public BlockEntityWithoutLevelRenderer getCustomRenderer() {
/* 23 */     return (BlockEntityWithoutLevelRenderer)ShieldRendererEvent.instance;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\GemShieldItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */