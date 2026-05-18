/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ 
/*    */ public class GreatSwordItem extends SwordItem {
/*    */   public GreatSwordItem() {
/* 10 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 12 */             return 1650;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 16 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 20 */             return 3.0F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 24 */             return 4;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 28 */             return 5;
/*    */           }
/*    */           
/*    */           public Ingredient m_6282_() {
/* 32 */             return Ingredient.m_151265_();
/*    */           }
/* 34 */         },  3, -2.5F, (new Item.Properties()).m_41486_());
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\GreatSwordItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */