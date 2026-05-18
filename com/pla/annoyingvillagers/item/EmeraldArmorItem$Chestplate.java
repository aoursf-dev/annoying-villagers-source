/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
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
/*     */   extends EmeraldArmorItem
/*     */ {
/*     */   public Chestplate() {
/* 116 */     super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
/*     */   }
/*     */   
/*     */   public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 120 */     return "annoyingvillagers:textures/models/armor/emerald_armor_layer_1.png";
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 125 */     super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/* 126 */     if (player.m_6844_(EquipmentSlot.CHEST) == stack && 
/* 127 */       !player.m_9236_().m_5776_())
/* 128 */       player.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 100, 1)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EmeraldArmorItem$Chestplate.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */