/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.client.model.ModelVillagerScoutHelmet;
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
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.ArmorMaterial;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraftforge.client.extensions.common.IClientItemExtensions;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public abstract class VillagerScoutHelmetItem
/*     */   extends ArmorItem {
/*     */   public VillagerScoutHelmetItem(ArmorItem.Type type, Item.Properties properties) {
/*  26 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(ArmorItem.Type type) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/VillagerScoutHelmetItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
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
/*     */             //   #29	-> 0
/*     */             //   #30	-> 48
/*     */             //   #31	-> 54
/*     */             //   #32	-> 60
/*     */             //   #33	-> 66
/*     */             //   #29	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/VillagerScoutHelmetItem$1;
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
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/VillagerScoutHelmetItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 56, 4 -> 61
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_2
/*     */             //   49: goto -> 62
/*     */             //   52: iconst_5
/*     */             //   53: goto -> 62
/*     */             //   56: bipush #6
/*     */             //   58: goto -> 62
/*     */             //   61: iconst_5
/*     */             //   62: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #39	-> 0
/*     */             //   #40	-> 48
/*     */             //   #41	-> 52
/*     */             //   #42	-> 56
/*     */             //   #43	-> 61
/*     */             //   #39	-> 62
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	63	0	this	Lcom/pla/annoyingvillagers/item/VillagerScoutHelmetItem$1;
/*     */             //   0	63	1	type	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  48 */             return 9;
/*     */           }
/*     */           
/*     */           public SoundEvent m_7344_() {
/*  52 */             return SoundEvents.f_11675_;
/*     */           }
/*     */           
/*     */           public Ingredient m_6230_() {
/*  56 */             return Ingredient.m_151265_();
/*     */           }
/*     */           
/*     */           public String m_6082_() {
/*  60 */             return "villager_scout_helmet";
/*     */           }
/*     */           
/*     */           public float m_6651_() {
/*  64 */             return 1.0F;
/*     */           }
/*     */           
/*     */           public float m_6649_() {
/*  68 */             return 0.0F;
/*     */           }
/*     */         },  type, properties);
/*     */   }
/*     */   
/*     */   public static class Helmet
/*     */     extends VillagerScoutHelmetItem {
/*     */     public Helmet() {
/*  76 */       super(ArmorItem.Type.HELMET, new Item.Properties());
/*     */     }
/*     */ 
/*     */     
/*     */     public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/*  81 */       consumer.accept(new IClientItemExtensions() {
/*  82 */             HumanoidModel<LivingEntity> armorModel = null;
/*     */             
/*     */             @NotNull
/*     */             public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*  86 */               if (this.armorModel == null) {
/*     */                 
/*  88 */                 ModelVillagerScoutHelmet<?> helmetModel = new ModelVillagerScoutHelmet(Minecraft.m_91087_().m_167973_().m_171103_(ModelVillagerScoutHelmet.LAYER_LOCATION));
/*     */ 
/*     */                 
/*  91 */                 ModelPart root = new ModelPart(Collections.emptyList(), Map.of("head", helmetModel.Head, "hat", new ModelPart(
/*     */                         
/*  93 */                         Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(
/*  94 */                         Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(
/*  95 */                         Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(
/*  96 */                         Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(
/*  97 */                         Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(
/*  98 */                         Collections.emptyList(), Collections.emptyMap())));
/*     */ 
/*     */                 
/* 101 */                 this.armorModel = new HumanoidModel(root);
/*     */               } 
/*     */               
/* 104 */               this.armorModel.f_102817_ = livingEntity.m_6047_();
/* 105 */               this.armorModel.f_102609_ = livingEntity.m_20159_();
/* 106 */               this.armorModel.f_102610_ = livingEntity.m_6162_();
/*     */               
/* 108 */               return this.armorModel;
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 115 */       return "annoyingvillagers:textures/models/armor/villager_scout_layer.png";
/*     */     }
/*     */   }
/*     */   
/*     */   class null implements IClientItemExtensions {
/*     */     HumanoidModel<LivingEntity> armorModel = null;
/*     */     
/*     */     @NotNull
/*     */     public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*     */       if (this.armorModel == null) {
/*     */         ModelVillagerScoutHelmet<?> helmetModel = new ModelVillagerScoutHelmet(Minecraft.m_91087_().m_167973_().m_171103_(ModelVillagerScoutHelmet.LAYER_LOCATION));
/*     */         ModelPart root = new ModelPart(Collections.emptyList(), Map.of("head", helmetModel.Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())));
/*     */         this.armorModel = new HumanoidModel(root);
/*     */       } 
/*     */       this.armorModel.f_102817_ = livingEntity.m_6047_();
/*     */       this.armorModel.f_102609_ = livingEntity.m_20159_();
/*     */       this.armorModel.f_102610_ = livingEntity.m_6162_();
/*     */       return this.armorModel;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\VillagerScoutHelmetItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */