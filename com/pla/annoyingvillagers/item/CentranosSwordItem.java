/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
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
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class CentranosSwordItem extends SwordItem {
/*    */   public CentranosSwordItem() {
/* 18 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 20 */             return 2031;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 24 */             return 8.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 28 */             return 8.0F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 32 */             return 3;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 36 */             return 20;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 40 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)AnnoyingVillagersModItems.DARK_NETHERITE.get()) }, );
/*    */           }
/*    */         },  3, -1.4F, new Item.Properties());
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 47 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 48 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.beta_update"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\CentranosSwordItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */