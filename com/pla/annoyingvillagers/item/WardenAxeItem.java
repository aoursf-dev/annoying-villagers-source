/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class WardenAxeItem extends SwordItem {
/*    */   public WardenAxeItem() {
/* 16 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 18 */             return 1680;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 22 */             return 6.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 26 */             return 3.4F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 30 */             return 5;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 34 */             return 21;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 38 */             return Ingredient.m_151265_();
/*    */           }
/*    */         },  3, -2.5F, new Item.Properties());
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 45 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 46 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.future_update"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\WardenAxeItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */