/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.ArmorMaterial;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
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
/*    */   public int m_266425_(ArmorItem.Type pType) {
/* 31 */     switch (BlueVillagerGeneralArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[pType.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 35 */       275;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_7366_(ArmorItem.Type pType) {
/* 41 */     switch (BlueVillagerGeneralArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[pType.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 45 */       4;
/*    */   }
/*    */ 
/*    */   
/*    */   public int m_6646_() {
/* 50 */     return 10;
/*    */   }
/*    */   @NotNull
/*    */   public SoundEvent m_7344_() {
/* 54 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_chain"));
/*    */   }
/*    */   @NotNull
/*    */   public Ingredient m_6230_() {
/* 58 */     return Ingredient.m_151265_();
/*    */   }
/*    */   @NotNull
/*    */   public String m_6082_() {
/* 62 */     return "blue_villager_general_armor";
/*    */   }
/*    */   
/*    */   public float m_6651_() {
/* 66 */     return 2.0F;
/*    */   }
/*    */   
/*    */   public float m_6649_() {
/* 70 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\BlueVillagerGeneralArmorItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */