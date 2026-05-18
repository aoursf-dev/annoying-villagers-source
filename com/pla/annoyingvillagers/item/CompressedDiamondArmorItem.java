/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.ArmorMaterial;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public abstract class CompressedDiamondArmorItem extends ArmorItem {
/*     */   public CompressedDiamondArmorItem(ArmorItem.Type type, Item.Properties properties) {
/*  21 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/CompressedDiamondArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 54, 3 -> 60, 4 -> 66
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: sipush #923
/*     */             //   51: goto -> 69
/*     */             //   54: sipush #1065
/*     */             //   57: goto -> 69
/*     */             //   60: sipush #1136
/*     */             //   63: goto -> 69
/*     */             //   66: sipush #781
/*     */             //   69: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #24	-> 0
/*     */             //   #25	-> 48
/*     */             //   #26	-> 54
/*     */             //   #27	-> 60
/*     */             //   #28	-> 66
/*     */             //   #24	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/CompressedDiamondArmorItem$1;
/*     */             //   0	70	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_7366_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/CompressedDiamondArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 57, 4 -> 62
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_5
/*     */             //   49: goto -> 64
/*     */             //   52: bipush #8
/*     */             //   54: goto -> 64
/*     */             //   57: bipush #9
/*     */             //   59: goto -> 64
/*     */             //   62: bipush #7
/*     */             //   64: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #34	-> 0
/*     */             //   #35	-> 48
/*     */             //   #36	-> 52
/*     */             //   #37	-> 57
/*     */             //   #38	-> 62
/*     */             //   #34	-> 64
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	65	0	this	Lcom/pla/annoyingvillagers/item/CompressedDiamondArmorItem$1;
/*     */             //   0	65	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  43 */             return 10;
/*     */           }
/*     */           @NotNull
/*     */           public SoundEvent m_7344_() {
/*  47 */             return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_diamond")));
/*     */           }
/*     */           @NotNull
/*     */           public Ingredient m_6230_() {
/*  51 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND.get()), new ItemStack((ItemLike)Items.f_42472_), new ItemStack((ItemLike)Items.f_42415_) });
/*     */           }
/*     */           @NotNull
/*     */           public String m_6082_() {
/*  55 */             return "compressed_diamond_armor";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  59 */             return 1.8F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  63 */             return 0.0F;
/*     */           }
/*     */         }type, properties);
/*     */   }
/*     */   
/*     */   public static class Boots
/*     */     extends CompressedDiamondArmorItem {
/*     */     public Boots() {
/*  71 */       super(ArmorItem.Type.BOOTS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  75 */       return "annoyingvillagers:textures/models/armor/compressed_diamond_armor_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Leggings
/*     */     extends CompressedDiamondArmorItem {
/*     */     public Leggings() {
/*  82 */       super(ArmorItem.Type.LEGGINGS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  86 */       return "annoyingvillagers:textures/models/armor/compressed_diamond_armor_layer_2.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Chestplate
/*     */     extends CompressedDiamondArmorItem {
/*     */     public Chestplate() {
/*  93 */       super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  97 */       return "annoyingvillagers:textures/models/armor/compressed_diamond_armor_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Helmet
/*     */     extends CompressedDiamondArmorItem {
/*     */     public Helmet() {
/* 104 */       super(ArmorItem.Type.HELMET, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 108 */       return "annoyingvillagers:textures/models/armor/compressed_diamond_armor_layer_1.png";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\CompressedDiamondArmorItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */