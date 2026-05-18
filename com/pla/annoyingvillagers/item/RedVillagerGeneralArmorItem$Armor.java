/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.client.model.ModelVillagerGeneralArmor;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.function.Consumer;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.HumanoidModel;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraftforge.client.extensions.common.IClientItemExtensions;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Armor
/*     */   extends RedVillagerGeneralArmorItem
/*     */ {
/*     */   public Armor() {
/* 111 */     super(ArmorItem.Type.HELMET, new Item.Properties());
/*     */   }
/*     */   
/*     */   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/* 115 */     consumer.accept(new IClientItemExtensions() {
/*     */           @NotNull
/*     */           public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/* 118 */             HumanoidModel<?> humanoidmodel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("head", (new ModelVillagerGeneralArmor(Minecraft.m_91087_().m_167973_().m_171103_(ModelVillagerGeneralArmor.LAYER_LOCATION))).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*     */             
/* 120 */             humanoidmodel.f_102817_ = livingEntity.m_6144_();
/* 121 */             humanoidmodel.f_102609_ = original.f_102609_;
/* 122 */             humanoidmodel.f_102610_ = livingEntity.m_6162_();
/* 123 */             return humanoidmodel;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 129 */     return "annoyingvillagers:textures/entities/red.png";
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\RedVillagerGeneralArmorItem$Armor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */