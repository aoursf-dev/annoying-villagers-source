/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.ArmorMaterial;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
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
/*    */   public int m_266425_(ArmorItem.Type type) {
/* 31 */     switch (PurpleVillagerGeneralArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 35 */       275;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_7366_(ArmorItem.Type type) {
/* 41 */     switch (PurpleVillagerGeneralArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 45 */       5;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_6646_() {
/* 51 */     return 10;
/*    */   }
/*    */   
/*    */   public SoundEvent m_7344_() {
/* 55 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_chain")));
/*    */   }
/*    */   
/*    */   public Ingredient m_6230_() {
/* 59 */     return Ingredient.m_151265_();
/*    */   }
/*    */   
/*    */   public String m_6082_() {
/* 63 */     return "purple_villager_general_armor";
/*    */   }
/*    */   
/*    */   public float m_6651_() {
/* 67 */     return 2.0F;
/*    */   }
/*    */   
/*    */   public float m_6649_() {
/* 71 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\PurpleVillagerGeneralArmorItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */