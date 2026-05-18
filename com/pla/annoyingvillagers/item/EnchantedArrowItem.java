/*    */ package com.pla.annoyingvillagers.item;
/*    */ import com.pla.annoyingvillagers.entity.EnchantedArrowEntity;
/*    */ import com.pla.annoyingvillagers.util.GlintColorHelper;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*    */ import net.minecraft.world.item.ArrowItem;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class EnchantedArrowItem extends ArrowItem {
/*    */   public EnchantedArrowItem(Item.Properties properties) {
/* 14 */     super(properties);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_5812_(@NotNull ItemStack stack) {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public AbstractArrow m_6394_(@NotNull Level level, @NotNull ItemStack ammoStack, @NotNull LivingEntity shooter) {
/* 24 */     EnchantedArrowEntity arrow = new EnchantedArrowEntity(level, shooter);
/* 25 */     arrow.setColorGlint(GlintColorHelper.getRandomColor());
/* 26 */     return (AbstractArrow)arrow;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EnchantedArrowItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */