/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.client.model.ModelHerobrineObsidianDiamondChestplate;
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.HumanoidModel;
/*    */ import net.minecraft.client.model.geom.ModelPart;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.LivingEntity;
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
/*    */ class null
/*    */   implements IClientItemExtensions
/*    */ {
/*    */   @NotNull
/*    */   public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/* 87 */     HumanoidModel<?> humanoidmodel1 = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).Body, "left_arm", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).LeftArm, "right_arm", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).RightArm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*    */     
/* 89 */     humanoidmodel1.f_102817_ = livingEntity.m_6144_();
/* 90 */     humanoidmodel1.f_102609_ = original.f_102609_;
/* 91 */     humanoidmodel1.f_102610_ = livingEntity.m_6162_();
/* 92 */     return humanoidmodel1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\HerobrineObsidianDiamondArmorChestplateItem$Chestplate$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */