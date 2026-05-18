/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.ArmorMaterial;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public abstract class EmeraldArmorItem extends ArmorItem {
/*     */   public EmeraldArmorItem(ArmorItem.Type type, Item.Properties properties) {
/*  24 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/EmeraldArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 54, 3 -> 60, 4 -> 66
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: sipush #624
/*     */             //   51: goto -> 69
/*     */             //   54: sipush #720
/*     */             //   57: goto -> 69
/*     */             //   60: sipush #768
/*     */             //   63: goto -> 69
/*     */             //   66: sipush #528
/*     */             //   69: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #27	-> 0
/*     */             //   #28	-> 48
/*     */             //   #29	-> 54
/*     */             //   #30	-> 60
/*     */             //   #31	-> 66
/*     */             //   #27	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/EmeraldArmorItem$1;
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
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/EmeraldArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
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
/*     */             //   #37	-> 0
/*     */             //   #38	-> 48
/*     */             //   #39	-> 52
/*     */             //   #40	-> 56
/*     */             //   #41	-> 61
/*     */             //   #37	-> 62
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	63	0	this	Lcom/pla/annoyingvillagers/item/EmeraldArmorItem$1;
/*     */             //   0	63	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  46 */             return 10;
/*     */           }
/*     */           @NotNull
/*     */           public SoundEvent m_7344_() {
/*  50 */             return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_diamond")));
/*     */           }
/*     */           @NotNull
/*     */           public Ingredient m_6230_() {
/*  54 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Items.f_42616_) });
/*     */           }
/*     */           @NotNull
/*     */           public String m_6082_() {
/*  58 */             return "emerald_armor";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  62 */             return 2.0F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  66 */             return 0.2F;
/*     */           }
/*     */         }type, properties);
/*     */   }
/*     */   
/*     */   public static class Boots
/*     */     extends EmeraldArmorItem {
/*     */     public Boots() {
/*  74 */       super(ArmorItem.Type.BOOTS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  78 */       return "annoyingvillagers:textures/models/armor/emerald_armor_layer_1.png";
/*     */     }
/*     */ 
/*     */     
/*     */     public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/*  83 */       super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/*  84 */       if (player.m_6844_(EquipmentSlot.FEET) == stack && 
/*  85 */         !player.m_9236_().m_5776_()) {
/*  86 */         player.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 100, 1));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Leggings
/*     */     extends EmeraldArmorItem
/*     */   {
/*     */     public Leggings() {
/*  95 */       super(ArmorItem.Type.LEGGINGS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  99 */       return "annoyingvillagers:textures/models/armor/emerald_armor_layer_2.png";
/*     */     }
/*     */ 
/*     */     
/*     */     public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 104 */       super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/* 105 */       if (player.m_6844_(EquipmentSlot.LEGS) == stack && 
/* 106 */         !player.m_9236_().m_5776_()) {
/* 107 */         player.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 100, 1));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Chestplate
/*     */     extends EmeraldArmorItem
/*     */   {
/*     */     public Chestplate() {
/* 116 */       super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 120 */       return "annoyingvillagers:textures/models/armor/emerald_armor_layer_1.png";
/*     */     }
/*     */ 
/*     */     
/*     */     public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 125 */       super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/* 126 */       if (player.m_6844_(EquipmentSlot.CHEST) == stack && 
/* 127 */         !player.m_9236_().m_5776_()) {
/* 128 */         player.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 100, 1));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Helmet
/*     */     extends EmeraldArmorItem
/*     */   {
/*     */     public Helmet() {
/* 137 */       super(ArmorItem.Type.HELMET, (new Item.Properties()).m_41486_());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 141 */       return "annoyingvillagers:textures/models/armor/emerald_armor_layer_1.png";
/*     */     }
/*     */ 
/*     */     
/*     */     public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 146 */       super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/* 147 */       if (player.m_6844_(EquipmentSlot.HEAD) == stack && 
/* 148 */         !player.m_9236_().m_5776_())
/* 149 */         player.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 100, 1)); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EmeraldArmorItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */