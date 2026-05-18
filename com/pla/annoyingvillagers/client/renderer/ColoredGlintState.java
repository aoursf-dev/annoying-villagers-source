/*    */ package com.pla.annoyingvillagers.client.renderer;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import com.pla.annoyingvillagers.item.BlueDemonChestplateItem;
/*    */ import com.pla.annoyingvillagers.item.BlueDemonTridentItem;
/*    */ import com.pla.annoyingvillagers.util.GlintColorHelper;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ 
/*    */ public final class ColoredGlintState {
/*    */   public static final int NONE = 0;
/*    */   public static final int ORANGE = 1;
/*    */   public static final int CYAN = 2;
/*    */   public static final int BLUE = 3;
/*    */   public static final int GREEN = 4;
/*    */   public static final int LIGHT_BLUE = 5;
/*    */   public static final int LIME = 6;
/*    */   public static final int MAGENTA = 7;
/*    */   public static final int PINK = 8;
/*    */   public static final int PURPLE = 9;
/*    */   public static final int RED = 10;
/*    */   public static final int YELLOW = 11;
/* 23 */   private static final ThreadLocal<Integer> MODE = ThreadLocal.withInitial(() -> Integer.valueOf(0));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setTargetStack(ItemStack stack) {
/* 29 */     int mode = GlintColorHelper.getColor(stack);
/*    */     
/* 31 */     if (mode == 0) {
/* 32 */       if (stack.m_150930_((Item)AnnoyingVillagersModItems.HEROBRINE_ENDER_EYE.get())) {
/* 33 */         mode = 1;
/* 34 */       } else if ((stack
/* 35 */         .m_150930_((Item)AnnoyingVillagersModItems.BLUE_DEMON_TRIDENT.get()) && BlueDemonTridentItem.isFullyCharged(stack)) || (stack
/* 36 */         .m_150930_((Item)AnnoyingVillagersModItems.BLUE_DEMON_CHESTPLATE.get()) && (
/* 37 */         BlueDemonChestplateItem.isFullyCharged(stack) || 
/* 38 */         BlueDemonChestplateItem.isBuffActive(stack) || 
/* 39 */         BlueDemonChestplateItem.hasBlueDemonHealingFoil(stack)))) {
/*    */         
/* 41 */         mode = 2;
/*    */       } 
/*    */     }
/*    */     
/* 45 */     MODE.set(Integer.valueOf(mode));
/*    */   }
/*    */   
/*    */   public static int getMode() {
/* 49 */     return ((Integer)MODE.get()).intValue();
/*    */   }
/*    */   
/*    */   public static void clear() {
/* 53 */     MODE.remove();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\ColoredGlintState.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */