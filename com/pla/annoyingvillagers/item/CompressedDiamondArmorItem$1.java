/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.ArmorMaterial;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ArmorMaterial
/*    */ {
/*    */   public int m_266425_(ArmorItem.Type type) {
/* 24 */     switch (CompressedDiamondArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 28 */       781;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_7366_(ArmorItem.Type type) {
/* 34 */     switch (CompressedDiamondArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 38 */       7;
/*    */   }
/*    */ 
/*    */   
/*    */   public int m_6646_() {
/* 43 */     return 10;
/*    */   }
/*    */   @NotNull
/*    */   public SoundEvent m_7344_() {
/* 47 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_diamond")));
/*    */   }
/*    */   @NotNull
/*    */   public Ingredient m_6230_() {
/* 51 */     return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get()), new ItemStack((ItemLike)Items.f_42472_), new ItemStack((ItemLike)Items.f_42415_) });
/*    */   }
/*    */   @NotNull
/*    */   public String m_6082_() {
/* 55 */     return "compressed_diamond_armor";
/*    */   }
/*    */   
/*    */   public float m_6651_() {
/* 59 */     return 1.8F;
/*    */   }
/*    */   
/*    */   public float m_6649_() {
/* 63 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\CompressedDiamondArmorItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */