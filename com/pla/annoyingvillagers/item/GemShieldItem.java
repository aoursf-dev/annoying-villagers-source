/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.event.ShieldRendererEvent;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ShieldItem;
/*    */ import net.minecraftforge.client.extensions.common.IClientItemExtensions;
/*    */ 
/*    */ public class GemShieldItem extends ShieldItem {
/*    */   public GemShieldItem() {
/* 12 */     super((new Item.Properties())
/* 13 */         .m_41487_(1)
/* 14 */         .m_41503_(1561));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/* 20 */     consumer.accept(new IClientItemExtensions()
/*    */         {
/*    */           public BlockEntityWithoutLevelRenderer getCustomRenderer() {
/* 23 */             return (BlockEntityWithoutLevelRenderer)ShieldRendererEvent.instance;
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\GemShieldItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */