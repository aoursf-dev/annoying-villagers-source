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
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
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
/*     */ public class Chestplate
/*     */   extends HerobrineObsidianDiamondArmorChestplateItem
/*     */ {
/*     */   public Chestplate() {
/*  80 */     super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*     */   }
/*     */   
/*     */   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
/*  84 */     consumer.accept(new IClientItemExtensions() {
/*     */           @NotNull
/*     */           public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
/*  87 */             HumanoidModel<?> humanoidmodel1 = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).Body, "left_arm", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).LeftArm, "right_arm", (new ModelHerobrineObsidianDiamondChestplate(Minecraft.m_91087_().m_167973_().m_171103_(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION))).RightArm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
/*     */             
/*  89 */             humanoidmodel1.f_102817_ = livingEntity.m_6144_();
/*  90 */             humanoidmodel1.f_102609_ = original.f_102609_;
/*  91 */             humanoidmodel1.f_102610_ = livingEntity.m_6162_();
/*  92 */             return humanoidmodel1;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/*  98 */     return "annoyingvillagers:textures/models/armor/herobrine_obsidian_armor_layer_1.png";
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 103 */     super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/* 104 */     if (player.m_6844_(EquipmentSlot.CHEST) == stack) {
/* 105 */       ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.FEET, "Herobrine Obsidian Diamond Chestplate");
/* 106 */       ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.LEGS, "Herobrine Obsidian Diamond Chestplate");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\HerobrineObsidianDiamondArmorChestplateItem$Chestplate.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */