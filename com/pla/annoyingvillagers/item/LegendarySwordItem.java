/*    */ package com.pla.annoyingvillagers.item;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class LegendarySwordItem extends SwordItem {
/*    */   public LegendarySwordItem() {
/* 18 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 20 */             return 1561;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 24 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 28 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 32 */             return 1;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 36 */             return 2;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 40 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get()) }, );
/*    */           }
/* 42 */         },  3, -2.32F, (new Item.Properties()).m_41486_());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_7579_(@NotNull ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
/* 47 */     if (!pAttacker.m_9236_().m_5776_()) {
/* 48 */       ArmorUtil.damageArmor(pTarget, (new Random()).nextInt(1, 5));
/*    */     }
/* 50 */     return super.m_7579_(pStack, pTarget, pAttacker);
/*    */   }
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemStack, Level level, @NotNull List<Component> componentList, @NotNull TooltipFlag tooltipFlag) {
/* 54 */     super.m_7373_(itemStack, level, componentList, tooltipFlag);
/* 55 */     componentList.add(Component.m_237115_("tooltip.annoyingvillagers.legendary_sword"));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\LegendarySwordItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */