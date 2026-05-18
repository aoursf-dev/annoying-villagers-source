/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.client.model.ModelHerobrineObsidianDiamondChestplate;
/*     */ import com.pla.annoyingvillagers.util.ArmorUtil;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.function.Consumer;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.HumanoidModel;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.ArmorMaterial;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.client.extensions.common.IClientItemExtensions;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public abstract class HerobrineObsidianDiamondArmorChestplateItem
/*     */   extends ArmorItem
/*     */ {
/*     */   public HerobrineObsidianDiamondArmorChestplateItem(ArmorItem.Type type, Item.Properties properties) {
/*  30 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type pType) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/HerobrineObsidianDiamondArmorChestplateItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
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
/*     */             //   60: sipush #600
/*     */             //   63: goto -> 69
/*     */             //   66: sipush #275
/*     */             //   69: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #33	-> 0
/*     */             //   #34	-> 48
/*     */             //   #35	-> 54
/*     */             //   #36	-> 60
/*     */             //   #37	-> 66
/*     */             //   #33	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/HerobrineObsidianDiamondArmorChestplateItem$1;
/*     */             //   0	70	1	pType	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_7366_(ArmorItem.Type pType) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/HerobrineObsidianDiamondArmorChestplateItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 56, 4 -> 61
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_0
/*     */             //   49: goto -> 62
/*     */             //   52: iconst_0
/*     */             //   53: goto -> 62
/*     */             //   56: bipush #24
/*     */             //   58: goto -> 62
/*     */             //   61: iconst_0
/*     */             //   62: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #43	-> 0
/*     */             //   #44	-> 48
/*     */             //   #45	-> 52
/*     */             //   #46	-> 56
/*     */             //   #47	-> 61
/*     */             //   #43	-> 62
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	63	0	this	Lcom/pla/annoyingvillagers/item/HerobrineObsidianDiamondArmorChestplateItem$1;
/*     */             //   0	63	1	pType	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  52 */             return 0;
/*     */           }
/*     */           
/*     */           public SoundEvent m_7344_() {
/*  56 */             return SoundEvents.f_11675_;
/*     */           }
/*     */           
/*     */           public Ingredient m_6230_() {
/*  60 */             return Ingredient.m_151265_();
/*     */           }
/*     */           
/*     */           public String m_6082_() {
/*  64 */             return "herobrine_obsidian_diamond_armor";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  68 */             return 2.0F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  72 */             return 0.0F;
/*     */           }
/*     */         },  type, properties);
/*     */   }
/*     */   
/*     */   public static class Chestplate
/*     */     extends HerobrineObsidianDiamondArmorChestplateItem {
/*     */     public Chestplate() {
/*  80 */       super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*     */     }
/*     */     
/*     */     public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/*  84 */       consumer.accept(new IClientItemExtensions() {
/*     */             @NotNull
/*     */             public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*  87 */               HumanoidModel<?> humanoidmodel1 = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).Body, "left_arm", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).LeftArm, "right_arm", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).RightArm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*     */               
/*  89 */               humanoidmodel1.f_102817_ = livingEntity.m_6144_();
/*  90 */               humanoidmodel1.f_102609_ = original.f_102609_;
/*  91 */               humanoidmodel1.f_102610_ = livingEntity.m_6162_();
/*  92 */               return humanoidmodel1;
/*     */             }
/*     */           });
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  98 */       return "annoyingvillagers:textures/models/armor/herobrine_obsidian_armor_layer_1.png";
/*     */     }
/*     */ 
/*     */     
/*     */     public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 103 */       super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/* 104 */       if (player.m_6844_(EquipmentSlot.CHEST) == stack) {
/* 105 */         ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.FEET, "Herobrine Obsidian Diamond Chestplate");
/* 106 */         ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.LEGS, "Herobrine Obsidian Diamond Chestplate");
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   class null implements IClientItemExtensions {
/*     */     @NotNull
/*     */     public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*     */       HumanoidModel<?> humanoidmodel1 = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).Body, "left_arm", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).LeftArm, "right_arm", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).RightArm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*     */       humanoidmodel1.f_102817_ = livingEntity.m_6144_();
/*     */       humanoidmodel1.f_102609_ = original.f_102609_;
/*     */       humanoidmodel1.f_102610_ = livingEntity.m_6162_();
/*     */       return humanoidmodel1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\HerobrineObsidianDiamondArmorChestplateItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */