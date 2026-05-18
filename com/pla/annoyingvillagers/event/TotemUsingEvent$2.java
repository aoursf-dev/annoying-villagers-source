/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.SteveEntity;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.enchantment.Enchantments;
/*    */ import net.minecraft.world.level.ItemLike;
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
/*    */   extends DelayedTask
/*    */ {
/*    */   null(int waitTicks) {
/* 51 */     super(waitTicks);
/*    */   }
/*    */   public void run() {
/* 54 */     serverLevel.m_6263_(null, entity
/*    */         
/* 56 */         .m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_11673_, SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 61 */     ItemStack compressedDiamondHelmet = new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND_HELMET.get());
/* 62 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44965_, 5);
/* 63 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44969_, 5);
/* 64 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44966_, 5);
/* 65 */     compressedDiamondHelmet.m_41663_(Enchantments.f_44968_, 5);
/* 66 */     steveEntity.m_8061_(EquipmentSlot.HEAD, compressedDiamondHelmet);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\TotemUsingEvent$2.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */