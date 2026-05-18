/*    */ package com.pla.annoyingvillagers.item;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.Level;
/*    */ 
/*    */ public class WoopieTheSwordItem extends SwordItem {
/*    */   public WoopieTheSwordItem() {
/* 16 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 18 */             return 1850;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 22 */             return 8.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 26 */             return 3.5F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 30 */             return 3;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 34 */             return 10;
/*    */           }
/*    */           
/*    */           public Ingredient m_6282_() {
/* 38 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Items.f_42415_) }, );
/*    */           }
/* 40 */         },  3, -2.8F, (new Item.Properties()).m_41486_());
/*    */   }
/*    */   
/*    */   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltipflag) {
/* 44 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 45 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.woopie_the_sword"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\WoopieTheSwordItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */