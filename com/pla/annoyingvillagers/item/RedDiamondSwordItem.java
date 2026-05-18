/*    */ package com.pla.annoyingvillagers.item;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class RedDiamondSwordItem extends SwordItem {
/*    */   public RedDiamondSwordItem() {
/* 15 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 17 */             return 1890;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 21 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 25 */             return 4.5F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 29 */             return 1;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 33 */             return 14;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 37 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Items.f_42415_), new ItemStack((ItemLike)Items.f_42451_) }, );
/*    */           }
/*    */         },  3, -2.1F, new Item.Properties());
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 44 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 45 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.beta_update"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\RedDiamondSwordItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */