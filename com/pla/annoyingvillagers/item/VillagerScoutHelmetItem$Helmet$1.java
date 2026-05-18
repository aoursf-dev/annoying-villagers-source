/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.client.model.ModelVillagerScoutHelmet;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.HumanoidModel;
/*     */ import net.minecraft.client.model.geom.ModelPart;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
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
/*     */ class null
/*     */   implements IClientItemExtensions
/*     */ {
/*  82 */   HumanoidModel<LivingEntity> armorModel = null;
/*     */   
/*     */   @NotNull
/*     */   public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*  86 */     if (this.armorModel == null) {
/*     */       
/*  88 */       ModelVillagerScoutHelmet<?> helmetModel = new ModelVillagerScoutHelmet(Minecraft.m_91087_().m_167973_().m_171103_(ModelVillagerScoutHelmet.LAYER_LOCATION));
/*     */ 
/*     */       
/*  91 */       ModelPart root = new ModelPart(Collections.emptyList(), Map.of("head", helmetModel.Head, "hat", new ModelPart(
/*     */               
/*  93 */               Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(
/*  94 */               Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(
/*  95 */               Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(
/*  96 */               Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(
/*  97 */               Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(
/*  98 */               Collections.emptyList(), Collections.emptyMap())));
/*     */ 
/*     */       
/* 101 */       this.armorModel = new HumanoidModel(root);
/*     */     } 
/*     */     
/* 104 */     this.armorModel.f_102817_ = livingEntity.m_6047_();
/* 105 */     this.armorModel.f_102609_ = livingEntity.m_20159_();
/* 106 */     this.armorModel.f_102610_ = livingEntity.m_6162_();
/*     */     
/* 108 */     return this.armorModel;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\VillagerScoutHelmetItem$Helmet$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */