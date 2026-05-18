/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.ArmorMaterial;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ 
/*     */ public abstract class ClassicGoldenArmorItem extends ArmorItem {
/*     */   public ClassicGoldenArmorItem(ArmorItem.Type type, Item.Properties properties) {
/*  15 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/ClassicGoldenArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 54, 3 -> 60, 4 -> 66
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: sipush #351
/*     */             //   51: goto -> 69
/*     */             //   54: sipush #405
/*     */             //   57: goto -> 69
/*     */             //   60: sipush #432
/*     */             //   63: goto -> 69
/*     */             //   66: sipush #297
/*     */             //   69: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #18	-> 0
/*     */             //   #19	-> 48
/*     */             //   #20	-> 54
/*     */             //   #21	-> 60
/*     */             //   #22	-> 66
/*     */             //   #18	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/ClassicGoldenArmorItem$1;
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
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/ClassicGoldenArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 56, 4 -> 61
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_3
/*     */             //   49: goto -> 62
/*     */             //   52: iconst_5
/*     */             //   53: goto -> 62
/*     */             //   56: bipush #6
/*     */             //   58: goto -> 62
/*     */             //   61: iconst_3
/*     */             //   62: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #28	-> 0
/*     */             //   #29	-> 48
/*     */             //   #30	-> 52
/*     */             //   #31	-> 56
/*     */             //   #32	-> 61
/*     */             //   #28	-> 62
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	63	0	this	Lcom/pla/annoyingvillagers/item/ClassicGoldenArmorItem$1;
/*     */             //   0	63	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  37 */             return 9;
/*     */           }
/*     */           
/*     */           public SoundEvent m_7344_() {
/*  41 */             return SoundEvents.f_11675_;
/*     */           }
/*     */           
/*     */           public Ingredient m_6230_() {
/*  45 */             return Ingredient.m_151265_();
/*     */           }
/*     */           
/*     */           public String m_6082_() {
/*  49 */             return "classic_golden_armor";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  53 */             return 0.7F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  57 */             return 0.0F;
/*     */           }
/*     */         },  type, properties);
/*     */   }
/*     */   
/*     */   public static class Boots
/*     */     extends ClassicGoldenArmorItem {
/*     */     public Boots() {
/*  65 */       super(ArmorItem.Type.BOOTS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  69 */       return "annoyingvillagers:textures/models/armor/gold_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Leggings
/*     */     extends ClassicGoldenArmorItem {
/*     */     public Leggings() {
/*  76 */       super(ArmorItem.Type.LEGGINGS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  80 */       return "annoyingvillagers:textures/models/armor/gold_layer_2.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Chestplate
/*     */     extends ClassicGoldenArmorItem {
/*     */     public Chestplate() {
/*  87 */       super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  91 */       return "annoyingvillagers:textures/models/armor/gold_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Helmet
/*     */     extends ClassicGoldenArmorItem {
/*     */     public Helmet() {
/*  98 */       super(ArmorItem.Type.HELMET, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 102 */       return "annoyingvillagers:textures/models/armor/gold_layer_1.png";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\ClassicGoldenArmorItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */