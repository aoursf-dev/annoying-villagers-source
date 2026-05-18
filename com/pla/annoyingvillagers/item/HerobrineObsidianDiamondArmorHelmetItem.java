/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.client.model.ModelHerobrineObsidianDiamondHelmet;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class HerobrineObsidianDiamondArmorHelmetItem
/*     */   extends ArmorItem
/*     */ {
/*     */   public HerobrineObsidianDiamondArmorHelmetItem(ArmorItem.Type type, Item.Properties properties) {
/*  33 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type pType) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/HerobrineObsidianDiamondArmorHelmetItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
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
/*     */             //   66: sipush #500
/*     */             //   69: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #35	-> 0
/*     */             //   #36	-> 48
/*     */             //   #37	-> 54
/*     */             //   #38	-> 60
/*     */             //   #39	-> 66
/*     */             //   #35	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/HerobrineObsidianDiamondArmorHelmetItem$1;
/*     */             //   0	70	1	pType	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_7366_(ArmorItem.Type pType) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/HerobrineObsidianDiamondArmorHelmetItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 56, 4 -> 60
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_0
/*     */             //   49: goto -> 62
/*     */             //   52: iconst_0
/*     */             //   53: goto -> 62
/*     */             //   56: iconst_0
/*     */             //   57: goto -> 62
/*     */             //   60: bipush #16
/*     */             //   62: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #45	-> 0
/*     */             //   #46	-> 48
/*     */             //   #47	-> 52
/*     */             //   #48	-> 56
/*     */             //   #49	-> 60
/*     */             //   #45	-> 62
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	63	0	this	Lcom/pla/annoyingvillagers/item/HerobrineObsidianDiamondArmorHelmetItem$1;
/*     */             //   0	63	1	pType	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  54 */             return 0;
/*     */           }
/*     */           
/*     */           public SoundEvent m_7344_() {
/*  58 */             return SoundEvents.f_11675_;
/*     */           }
/*     */           
/*     */           public Ingredient m_6230_() {
/*  62 */             return Ingredient.m_151265_();
/*     */           }
/*     */           
/*     */           public String m_6082_() {
/*  66 */             return "herobrine_obsidian_diamond_armor";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  70 */             return 2.0F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  74 */             return 0.0F;
/*     */           }
/*     */         },  type, properties);
/*     */   }
/*     */   
/*     */   public static class Helmet
/*     */     extends HerobrineObsidianDiamondArmorHelmetItem {
/*     */     public Helmet() {
/*  82 */       super(ArmorItem.Type.HELMET, new Item.Properties());
/*     */     }
/*     */     
/*     */     public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/*  86 */       consumer.accept(new IClientItemExtensions() {
/*     */             @NotNull
/*     */             public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*  89 */               HumanoidModel<?> humanoidmodel1 = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new ModelHerobrineObsidianDiamondHelmet(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondHelmet.LAYER_LOCATION))).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*     */               
/*  91 */               humanoidmodel1.f_102817_ = livingEntity.m_6144_();
/*  92 */               humanoidmodel1.f_102609_ = original.f_102609_;
/*  93 */               humanoidmodel1.f_102610_ = livingEntity.m_6162_();
/*  94 */               return humanoidmodel1;
/*     */             }
/*     */           });
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 100 */       return "annoyingvillagers:textures/models/armor/herobrine_obsidian_armor_layer_2.png";
/*     */     }
/*     */ 
/*     */     
/*     */     public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 105 */       super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/* 106 */       if (player.m_6844_(EquipmentSlot.HEAD) == stack) {
/* 107 */         ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.FEET, "Herobrine Obsidian Diamond Chestplate");
/* 108 */         ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.LEGS, "Herobrine Obsidian Diamond Chestplate");
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   class null implements IClientItemExtensions {
/*     */     @NotNull
/*     */     public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*     */       HumanoidModel<?> humanoidmodel1 = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new ModelHerobrineObsidianDiamondHelmet(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondHelmet.LAYER_LOCATION))).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*     */       humanoidmodel1.f_102817_ = livingEntity.m_6144_();
/*     */       humanoidmodel1.f_102609_ = original.f_102609_;
/*     */       humanoidmodel1.f_102610_ = livingEntity.m_6162_();
/*     */       return humanoidmodel1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\HerobrineObsidianDiamondArmorHelmetItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */