/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.effect.MobEffects;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ArmorItem;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
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
/*    */ public class Boots
/*    */   extends EmeraldArmorItem
/*    */ {
/*    */   public Boots() {
/* 74 */     super(ArmorItem.Type.BOOTS, new Item.Properties());
/*    */   }
/*    */   
/*    */   public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 78 */     return "annoyingvillagers:textures/models/armor/emerald_armor_layer_1.png";
/*    */   }
/*    */ 
/*    */   
/*    */   public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 83 */     super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/* 84 */     if (player.m_6844_(EquipmentSlot.FEET) == stack && 
/* 85 */       !player.m_9236_().m_5776_())
/* 86 */       player.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 100, 1)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EmeraldArmorItem$Boots.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */