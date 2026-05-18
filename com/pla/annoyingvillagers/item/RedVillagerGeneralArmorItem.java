/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.client.model.ModelVillagerGeneralArmor;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Consumer;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.HumanoidModel;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.ArmorMaterial;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraftforge.client.extensions.common.IClientItemExtensions;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public abstract class RedVillagerGeneralArmorItem
/*     */   extends ArmorItem {
/*     */   public RedVillagerGeneralArmorItem(ArmorItem.Type type, Item.Properties properties) {
/*  28 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/RedVillagerGeneralArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
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
/*     */             //   #31	-> 0
/*     */             //   #32	-> 48
/*     */             //   #33	-> 54
/*     */             //   #34	-> 60
/*     */             //   #35	-> 66
/*     */             //   #31	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/RedVillagerGeneralArmorItem$1;
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
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/RedVillagerGeneralArmorItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 56, 4 -> 61
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_4
/*     */             //   49: goto -> 63
/*     */             //   52: iconst_5
/*     */             //   53: goto -> 63
/*     */             //   56: bipush #7
/*     */             //   58: goto -> 63
/*     */             //   61: bipush #6
/*     */             //   63: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #41	-> 0
/*     */             //   #42	-> 48
/*     */             //   #43	-> 52
/*     */             //   #44	-> 56
/*     */             //   #45	-> 61
/*     */             //   #41	-> 63
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	64	0	this	Lcom/pla/annoyingvillagers/item/RedVillagerGeneralArmorItem$1;
/*     */             //   0	64	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  50 */             return 10;
/*     */           }
/*     */           @NotNull
/*     */           public SoundEvent m_7344_() {
/*  54 */             return Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "item.armor.equip_chain")));
/*     */           }
/*     */           @NotNull
/*     */           public Ingredient m_6230_() {
/*  58 */             return Ingredient.m_151265_();
/*     */           }
/*     */           @NotNull
/*     */           public String m_6082_() {
/*  62 */             return "red_villager_general_armor";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  66 */             return 2.0F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  70 */             return 0.0F;
/*     */           }
/*     */         }type, properties);
/*     */   }
/*     */   
/*     */   public static class Boots
/*     */     extends RedVillagerGeneralArmorItem {
/*     */     public Boots() {
/*  78 */       super(ArmorItem.Type.BOOTS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  82 */       return "annoyingvillagers:textures/models/armor/red_villager_general_armor_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Leggings
/*     */     extends RedVillagerGeneralArmorItem {
/*     */     public Leggings() {
/*  89 */       super(ArmorItem.Type.LEGGINGS, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  93 */       return "annoyingvillagers:textures/models/armor/red_villager_general_armor_layer_2.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Chestplate
/*     */     extends RedVillagerGeneralArmorItem {
/*     */     public Chestplate() {
/* 100 */       super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 104 */       return "annoyingvillagers:textures/models/armor/red_villager_general_armor_layer_1.png";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Armor
/*     */     extends RedVillagerGeneralArmorItem {
/*     */     public Armor() {
/* 111 */       super(ArmorItem.Type.HELMET, new Item.Properties());
/*     */     }
/*     */     
/*     */     public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/* 115 */       consumer.accept(new IClientItemExtensions() {
/*     */             @NotNull
/*     */             public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/* 118 */               HumanoidModel<?> humanoidmodel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new ModelVillagerGeneralArmor(Minecraft.m_91087_().m_167973_().m_171103_(ModelVillagerGeneralArmor.LAYER_LOCATION))).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*     */               
/* 120 */               humanoidmodel.f_102817_ = livingEntity.m_6144_();
/* 121 */               humanoidmodel.f_102609_ = original.f_102609_;
/* 122 */               humanoidmodel.f_102610_ = livingEntity.m_6162_();
/* 123 */               return humanoidmodel;
/*     */             }
/*     */           });
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 129 */       return "annoyingvillagers:textures/entities/red.png";
/*     */     }
/*     */   }
/*     */   
/*     */   class null implements IClientItemExtensions {
/*     */     @NotNull
/*     */     public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*     */       HumanoidModel<?> humanoidmodel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new ModelVillagerGeneralArmor(Minecraft.m_91087_().m_167973_().m_171103_(ModelVillagerGeneralArmor.LAYER_LOCATION))).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*     */       humanoidmodel.f_102817_ = livingEntity.m_6144_();
/*     */       humanoidmodel.f_102609_ = original.f_102609_;
/*     */       humanoidmodel.f_102610_ = livingEntity.m_6162_();
/*     */       return humanoidmodel;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\RedVillagerGeneralArmorItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */