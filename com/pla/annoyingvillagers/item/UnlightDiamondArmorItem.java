/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
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
/*     */ public abstract class UnlightDiamondArmorItem
/*     */   extends ArmorItem {
/*     */   public UnlightDiamondArmorItem(ArmorItem.Type type, Item.Properties properties) {
/*  21 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/UnlightDiamondArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 54, 3 -> 60, 4 -> 66
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: sipush #598
/*     */             //   51: goto -> 69
/*     */             //   54: sipush #690
/*     */             //   57: goto -> 69
/*     */             //   60: sipush #736
/*     */             //   63: goto -> 69
/*     */             //   66: sipush #506
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
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/UnlightDiamondArmorItem$1;
/*     */             //   0	70	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_7366_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/UnlightDiamondArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 56, 4 -> 61
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_4
/*     */             //   49: goto -> 62
/*     */             //   52: iconst_5
/*     */             //   53: goto -> 62
/*     */             //   56: bipush #8
/*     */             //   58: goto -> 62
/*     */             //   61: iconst_5
/*     */             //   62: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #34	-> 0
/*     */             //   #35	-> 48
/*     */             //   #36	-> 52
/*     */             //   #37	-> 56
/*     */             //   #38	-> 61
/*     */             //   #34	-> 62
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	63	0	this	Lcom/pla/annoyingvillagers/item/UnlightDiamondArmorItem$1;
/*     */             //   0	63	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  42 */             return 10;
/*     */           }
/*     */           @NotNull
/*     */           public SoundEvent m_7344_() {
/*  46 */             return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_diamond")));
/*     */           }
/*     */           @NotNull
/*     */           public Ingredient m_6230_() {
/*  50 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Items.f_42415_) });
/*     */           }
/*     */           @NotNull
/*     */           public String m_6082_() {
/*  54 */             return "unlight_diamond_armor";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  58 */             return 2.1F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  62 */             return 0.0F;
/*     */           }
/*     */         }type, properties);
/*     */   }
/*     */   
/*     */   public static class Boots
/*     */     extends UnlightDiamondArmorItem {
/*     */     public Boots() {
/*  70 */       super(ArmorItem.Type.BOOTS, (new Item.Properties()).m_41486_());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  74 */       return "annoyingvillagers:textures/models/armor/unlight_diamond_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Leggings
/*     */     extends UnlightDiamondArmorItem {
/*     */     public Leggings() {
/*  81 */       super(ArmorItem.Type.LEGGINGS, (new Item.Properties()).m_41486_());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  85 */       return "annoyingvillagers:textures/models/armor/unlight_diamond_layer_2.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Chestplate
/*     */     extends UnlightDiamondArmorItem {
/*     */     public Chestplate() {
/*  92 */       super(ArmorItem.Type.CHESTPLATE, (new Item.Properties()).m_41486_());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  96 */       return "annoyingvillagers:textures/models/armor/unlight_diamond_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Helmet
/*     */     extends UnlightDiamondArmorItem {
/*     */     public Helmet() {
/* 103 */       super(ArmorItem.Type.HELMET, (new Item.Properties()).m_41486_());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 107 */       return "annoyingvillagers:textures/models/armor/unlight_diamond_layer_1.png";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\UnlightDiamondArmorItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */