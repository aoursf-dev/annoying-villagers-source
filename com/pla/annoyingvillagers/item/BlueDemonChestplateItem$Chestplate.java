/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.util.ArmorUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.chat.MutableComponent;
/*     */ import net.minecraft.network.chat.Style;
/*     */ import net.minecraft.network.chat.TextColor;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.TooltipFlag;
/*     */ import net.minecraft.world.level.Level;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BlueDemonChestplateItem
/*     */ {
/*     */   public Chestplate() {
/* 330 */     super(ArmorItem.Type.CHESTPLATE, (new Item.Properties()).m_41486_());
/*     */   }
/*     */   
/*     */   public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 334 */     return "annoyingvillagers:textures/models/armor/blue_demon_chestplate_layer.png";
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 339 */     super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/*     */     
/* 341 */     if (player.m_6844_(EquipmentSlot.CHEST) != stack) {
/* 342 */       if (isBuffActive(stack)) {
/* 343 */         stopBuff(stack);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 348 */     ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.FEET, "Blue Demon Chestplate");
/* 349 */     ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.LEGS, "Blue Demon Chestplate");
/* 350 */     ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.HEAD, "Blue Demon Chestplate");
/*     */     
/* 352 */     tickActiveBuff(stack, player);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7373_(@NotNull ItemStack stack, Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
/* 357 */     super.m_7373_(stack, level, tooltip, flag);
/*     */     
/* 359 */     int charge = getStoredCharge(stack);
/*     */     
/* 361 */     tooltip.add(Component.m_237115_("tooltip.annoyingvillagers.blue_demon_chestplate"));
/* 362 */     addChestChargeTooltip(tooltip, charge);
/*     */   }
/*     */   
/*     */   private static void addChestChargeTooltip(List<Component> tooltip, int charge) {
/* 366 */     tooltip.add(
/* 367 */         Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.blue_demon_chestplate_thunder_charge").getString())
/* 368 */         .m_130938_(style -> style.m_131136_(Boolean.valueOf(true)).m_131148_(TextColor.m_131266_(5634047))));
/*     */ 
/*     */     
/* 371 */     tooltip.add(
/* 372 */         Component.m_237113_("" + charge + " / 100")
/* 373 */         .m_130938_(style -> style.m_131148_(TextColor.m_131266_(12450815))));
/*     */ 
/*     */     
/* 376 */     tooltip.add(buildChestChargeMeter(charge));
/*     */     
/* 378 */     if (charge >= 100) {
/* 379 */       tooltip.add(
/* 380 */           Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.thunder_charged").getString())
/* 381 */           .m_130938_(style -> style.m_131136_(Boolean.valueOf(true)).m_131148_(TextColor.m_131266_(8191999))));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static Component buildChestChargeMeter(int charge) {
/* 387 */     int filledSteps = Math.round(charge / 100.0F * 10.0F);
/* 388 */     filledSteps = Mth.m_14045_(filledSteps, 0, 10);
/*     */     
/* 390 */     MutableComponent meter = Component.m_237119_();
/*     */     
/* 392 */     meter.m_7220_(
/* 393 */         (Component)Component.m_237113_("⛨ ")
/* 394 */         .m_130938_(style -> style.m_131148_(TextColor.m_131266_(5634047))));
/*     */ 
/*     */     
/* 397 */     for (int i = 0; i < 10; i++) {
/* 398 */       boolean filled = (i < filledSteps);
/*     */       
/* 400 */       meter.m_7220_(
/* 401 */           (Component)Component.m_237113_(filled ? "▰" : "▱")
/* 402 */           .m_130938_(style -> style.m_131148_(TextColor.m_131266_(filled ? 5634047 : 2306872))));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 408 */     return (Component)meter;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\BlueDemonChestplateItem$Chestplate.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */