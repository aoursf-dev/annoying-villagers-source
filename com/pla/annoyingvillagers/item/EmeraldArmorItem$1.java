/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ArmorMaterial
/*    */ {
/*    */   public int m_266425_(ArmorItem.Type type) {
/* 27 */     switch (EmeraldArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 31 */       528;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_7366_(ArmorItem.Type type) {
/* 37 */     switch (EmeraldArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 41 */       5;
/*    */   }
/*    */ 
/*    */   
/*    */   public int m_6646_() {
/* 46 */     return 10;
/*    */   }
/*    */   @NotNull
/*    */   public SoundEvent m_7344_() {
/* 50 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_diamond")));
/*    */   }
/*    */   @NotNull
/*    */   public Ingredient m_6230_() {
/* 54 */     return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Items.f_42616_) });
/*    */   }
/*    */   @NotNull
/*    */   public String m_6082_() {
/* 58 */     return "emerald_armor";
/*    */   }
/*    */   
/*    */   public float m_6651_() {
/* 62 */     return 2.0F;
/*    */   }
/*    */   
/*    */   public float m_6649_() {
/* 66 */     return 0.2F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EmeraldArmorItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */