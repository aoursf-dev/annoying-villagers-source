/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.ArmorMaterial;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ArmorMaterial
/*    */ {
/*    */   public int m_266425_(@NotNull ArmorItem.Type pType) {
/* 53 */     switch (BlueDemonChestplateItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[pType.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 57 */       341;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_7366_(@NotNull ArmorItem.Type pType) {
/* 63 */     switch (BlueDemonChestplateItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[pType.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 67 */       2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_6646_() {
/* 73 */     return 9;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public SoundEvent m_7344_() {
/* 78 */     return SoundEvents.f_11675_;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public Ingredient m_6230_() {
/* 83 */     return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Items.f_42695_), new ItemStack((ItemLike)Items.f_42696_) });
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String m_6082_() {
/* 88 */     return "blue_demon_chestplate";
/*    */   }
/*    */ 
/*    */   
/*    */   public float m_6651_() {
/* 93 */     return 2.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public float m_6649_() {
/* 98 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\BlueDemonChestplateItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */