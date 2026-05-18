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
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class TrapdoorItem extends SwordItem {
/*    */   public TrapdoorItem() {
/* 18 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 20 */             return 400;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 24 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 28 */             return 0.5F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 32 */             return 4;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 36 */             return 4;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 40 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Blocks.f_50154_) }, );
/*    */           }
/*    */         },  3, -2.5F, new Item.Properties());
/*    */   }
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 46 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 47 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.trapdoor"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\TrapdoorItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */