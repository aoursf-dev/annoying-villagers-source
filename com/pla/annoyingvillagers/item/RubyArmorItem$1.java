/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.ArmorMaterial;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ArmorMaterial
/*    */ {
/*    */   public int m_266425_(ArmorItem.Type type) {
/* 22 */     switch (RubyArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 26 */       275;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_7366_(ArmorItem.Type type) {
/* 32 */     switch (RubyArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 36 */       5;
/*    */   }
/*    */ 
/*    */   
/*    */   public int m_6646_() {
/* 41 */     return 9;
/*    */   }
/*    */   
/*    */   public SoundEvent m_7344_() {
/* 45 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_diamond"));
/*    */   }
/*    */   
/*    */   public Ingredient m_6230_() {
/* 49 */     return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)AnnoyingVillagersModItems.DARK_NETHERITE.get()), new ItemStack((ItemLike)Items.f_42417_) });
/*    */   }
/*    */   
/*    */   public String m_6082_() {
/* 53 */     return "ruby_armor";
/*    */   }
/*    */   
/*    */   public float m_6651_() {
/* 57 */     return 0.0F;
/*    */   }
/*    */   
/*    */   public float m_6649_() {
/* 61 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\RubyArmorItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */