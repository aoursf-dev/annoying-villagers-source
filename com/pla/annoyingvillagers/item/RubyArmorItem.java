/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
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
/*     */ 
/*     */ public abstract class RubyArmorItem extends ArmorItem {
/*     */   public RubyArmorItem(ArmorItem.Type type, Item.Properties properties) {
/*  19 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/RubyArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 54, 3 -> 60, 4 -> 66
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: sipush #325
/*     */             //   51: goto -> 69
/*     */             //   54: sipush #375
/*     */             //   57: goto -> 69
/*     */             //   60: sipush #400
/*     */             //   63: goto -> 69
/*     */             //   66: sipush #275
/*     */             //   69: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #22	-> 0
/*     */             //   #23	-> 48
/*     */             //   #24	-> 54
/*     */             //   #25	-> 60
/*     */             //   #26	-> 66
/*     */             //   #22	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/RubyArmorItem$1;
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
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/RubyArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 57, 4 -> 62
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_5
/*     */             //   49: goto -> 63
/*     */             //   52: bipush #6
/*     */             //   54: goto -> 63
/*     */             //   57: bipush #9
/*     */             //   59: goto -> 63
/*     */             //   62: iconst_5
/*     */             //   63: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #32	-> 0
/*     */             //   #33	-> 48
/*     */             //   #34	-> 52
/*     */             //   #35	-> 57
/*     */             //   #36	-> 62
/*     */             //   #32	-> 63
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	64	0	this	Lcom/pla/annoyingvillagers/item/RubyArmorItem$1;
/*     */             //   0	64	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  41 */             return 9;
/*     */           }
/*     */           
/*     */           public SoundEvent m_7344_() {
/*  45 */             return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_diamond"));
/*     */           }
/*     */           
/*     */           public Ingredient m_6230_() {
/*  49 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)AnnoyingVillagersModItems.DARK_NETHERITE.get()), new ItemStack((ItemLike)Items.f_42417_) });
/*     */           }
/*     */           
/*     */           public String m_6082_() {
/*  53 */             return "ruby_armor";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  57 */             return 0.0F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  61 */             return 0.0F;
/*     */           }
/*     */         }type, properties);
/*     */   }
/*     */   
/*     */   public static class Boots
/*     */     extends RubyArmorItem {
/*     */     public Boots() {
/*  69 */       super(ArmorItem.Type.BOOTS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  73 */       return "annoyingvillagers:textures/models/armor/ruby_armor_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Leggings
/*     */     extends RubyArmorItem {
/*     */     public Leggings() {
/*  80 */       super(ArmorItem.Type.LEGGINGS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  84 */       return "annoyingvillagers:textures/models/armor/ruby_armor_layer_2.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Chestplate
/*     */     extends RubyArmorItem {
/*     */     public Chestplate() {
/*  91 */       super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  95 */       return "annoyingvillagers:textures/models/armor/ruby_armor_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Helmet
/*     */     extends RubyArmorItem {
/*     */     public Helmet() {
/* 102 */       super(ArmorItem.Type.HELMET, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 106 */       return "annoyingvillagers:textures/models/armor/ruby_armor_layer_1.png";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\RubyArmorItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */