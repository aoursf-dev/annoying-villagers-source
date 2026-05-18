/*    */ package com.pla.annoyingvillagers.item;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class DiamondBlasterSwordItem extends SwordItem {
/*    */   public DiamondBlasterSwordItem() {
/* 14 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 16 */             return 1561;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 20 */             return 6.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 24 */             return 2.4F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 28 */             return 5;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 32 */             return 21;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 36 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Items.f_42415_) }, );
/*    */           }
/*    */         },  3, -1.5F, new Item.Properties());
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 43 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 44 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.beta_update"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\DiamondBlasterSwordItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */