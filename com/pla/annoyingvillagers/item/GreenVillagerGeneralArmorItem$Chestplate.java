/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.client.model.ModelGreenVillagerGeneralArmor;
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.HumanoidModel;
/*    */ import net.minecraft.client.model.geom.ModelPart;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraftforge.client.extensions.common.IClientItemExtensions;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Chestplate
/*    */   extends GreenVillagerGeneralArmorItem
/*    */ {
/*    */   public Chestplate() {
/* 80 */     super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*    */   }
/*    */   
/*    */   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/* 84 */     consumer.accept(new IClientItemExtensions() {
/*    */           @NotNull
/*    */           public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/* 87 */             HumanoidModel<?> humanoidmodel1 = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new ModelGreenVillagerGeneralArmor(Minecraft.m_91087_().m_167973_().m_171103_(ModelGreenVillagerGeneralArmor.LAYER_LOCATION))).Body, "left_arm", (new ModelGreenVillagerGeneralArmor(Minecraft.m_91087_().m_167973_().m_171103_(ModelGreenVillagerGeneralArmor.LAYER_LOCATION))).LeftArm, "right_arm", (new ModelGreenVillagerGeneralArmor(Minecraft.m_91087_().m_167973_().m_171103_(ModelGreenVillagerGeneralArmor.LAYER_LOCATION))).RightArm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*    */             
/* 89 */             humanoidmodel1.f_102817_ = livingEntity.m_6144_();
/* 90 */             humanoidmodel1.f_102609_ = original.f_102609_;
/* 91 */             humanoidmodel1.f_102610_ = livingEntity.m_6162_();
/* 92 */             return humanoidmodel1;
/*    */           }
/*    */         });
/*    */   }
/*    */   
/*    */   public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 98 */     return "annoyingvillagers:textures/models/armor/green_villager_general_armor_layer.png";
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\GreenVillagerGeneralArmorItem$Chestplate.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */