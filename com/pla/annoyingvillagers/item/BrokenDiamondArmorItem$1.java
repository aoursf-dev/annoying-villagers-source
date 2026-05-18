/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import java.util.Objects;
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
/*    */ class null
/*    */   implements ArmorMaterial
/*    */ {
/*    */   public int m_266425_(ArmorItem.Type type) {
/* 22 */     switch (BrokenDiamondArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 26 */       110;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int m_7366_(ArmorItem.Type type) {
/* 32 */     switch (BrokenDiamondArmorItem.null.$SwitchMap$net$minecraft$world$item$ArmorItem$Type[type.ordinal()]) { default: throw new IncompatibleClassChangeError();case 1: case 2: case 3: case 4: break; }  return 
/*    */ 
/*    */ 
/*    */       
/* 36 */       3;
/*    */   }
/*    */ 
/*    */   
/*    */   public int m_6646_() {
/* 41 */     return 9;
/*    */   }
/*    */   @NotNull
/*    */   public SoundEvent m_7344_() {
/* 45 */     return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_diamond")));
/*    */   }
/*    */   @NotNull
/*    */   public Ingredient m_6230_() {
/* 49 */     return Ingredient.m_151265_();
/*    */   }
/*    */   @NotNull
/*    */   public String m_6082_() {
/* 53 */     return "broken_diamond_armor";
/*    */   }
/*    */   
/*    */   public float m_6651_() {
/* 57 */     return 1.0F;
/*    */   }
/*    */   
/*    */   public float m_6649_() {
/* 61 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\BrokenDiamondArmorItem$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */