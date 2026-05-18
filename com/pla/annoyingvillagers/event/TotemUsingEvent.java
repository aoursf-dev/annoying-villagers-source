/*     */ package com.pla.annoyingvillagers.event;
/*     */ import com.pla.annoyingvillagers.entity.AlexEntity;
/*     */ import com.pla.annoyingvillagers.entity.ChrisEntity;
/*     */ import com.pla.annoyingvillagers.entity.SteveEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.event.entity.living.LivingUseTotemEvent;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class TotemUsingEvent {
/*     */   @SubscribeEvent
/*     */   public static void onLivingUseTotem(LivingUseTotemEvent event) {
/*  29 */     final LivingEntity entity = event.getEntity();
/*  30 */     ItemStack totem = event.getTotem();
/*     */     
/*  32 */     if (totem.m_150930_(Items.f_42747_)) {
/*  33 */       if (entity instanceof SteveEntity) { final SteveEntity steveEntity = (SteveEntity)entity; Level level = entity.m_9236_(); if (level instanceof ServerLevel) { final ServerLevel serverLevel = (ServerLevel)level;
/*  34 */           new DelayedTask(1)
/*     */             {
/*     */               public void run() {
/*  37 */                 steveEntity.m_21153_(steveEntity.m_21233_());
/*  38 */                 ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/*  39 */                 diamondSword.m_41663_(Enchantments.f_44977_, 5);
/*  40 */                 diamondSword.m_41663_(Enchantments.f_44978_, 5);
/*  41 */                 steveEntity.m_21008_(InteractionHand.OFF_HAND, diamondSword);
/*  42 */                 steveEntity.setOffWeaponItem(diamondSword);
/*  43 */                 steveEntity.setState(1);
/*  44 */                 LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)entity, LivingEntityPatch.class);
/*  45 */                 if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && livingEntityPatch != null) {
/*  46 */                   livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.GUARD_BREAK_ATTACK, 0.0F);
/*     */                 }
/*     */               }
/*     */             };
/*     */           
/*  51 */           new DelayedTask(10)
/*     */             {
/*     */               public void run() {
/*  54 */                 serverLevel.m_6263_(null, entity
/*     */                     
/*  56 */                     .m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_11673_, SoundSource.NEUTRAL, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*  61 */                 ItemStack compressedDiamondHelmet = new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND_HELMET.get());
/*  62 */                 compressedDiamondHelmet.m_41663_(Enchantments.f_44965_, 5);
/*  63 */                 compressedDiamondHelmet.m_41663_(Enchantments.f_44969_, 5);
/*  64 */                 compressedDiamondHelmet.m_41663_(Enchantments.f_44966_, 5);
/*  65 */                 compressedDiamondHelmet.m_41663_(Enchantments.f_44968_, 5);
/*  66 */                 steveEntity.m_8061_(EquipmentSlot.HEAD, compressedDiamondHelmet);
/*     */               }
/*     */             };
/*     */           
/*  70 */           new DelayedTask(20)
/*     */             {
/*     */               public void run() {
/*  73 */                 serverLevel.m_6263_(null, entity
/*     */                     
/*  75 */                     .m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_11673_, SoundSource.NEUTRAL, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*  80 */                 ItemStack compressedDiamondChestplate = new ItemStack((ItemLike)AnnoyingVillagersModItems.COMPRESSED_DIAMOND_CHESTPLATE.get());
/*  81 */                 compressedDiamondChestplate.m_41663_(Enchantments.f_44965_, 5);
/*  82 */                 compressedDiamondChestplate.m_41663_(Enchantments.f_44969_, 5);
/*  83 */                 compressedDiamondChestplate.m_41663_(Enchantments.f_44966_, 5);
/*  84 */                 compressedDiamondChestplate.m_41663_(Enchantments.f_44968_, 5);
/*  85 */                 steveEntity.m_8061_(EquipmentSlot.CHEST, compressedDiamondChestplate);
/*     */               }
/*     */             }; }
/*     */          }
/*     */       
/*  90 */       if (entity instanceof AlexEntity) { final AlexEntity alexEntity = (AlexEntity)entity; if (entity.m_9236_() instanceof ServerLevel) {
/*  91 */           new DelayedTask(1)
/*     */             {
/*     */               public void run() {
/*  94 */                 alexEntity.m_21153_(alexEntity.m_21233_());
/*  95 */                 ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/*  96 */                 diamondSword.m_41663_(Enchantments.f_44977_, 5);
/*  97 */                 diamondSword.m_41663_(Enchantments.f_44981_, 2);
/*  98 */                 diamondSword.m_41663_(Enchantments.f_44980_, 2);
/*  99 */                 diamondSword.m_41663_(Enchantments.f_44986_, 5);
/* 100 */                 alexEntity.m_21008_(InteractionHand.OFF_HAND, diamondSword);
/* 101 */                 alexEntity.m_21008_(InteractionHand.MAIN_HAND, diamondSword);
/* 102 */                 alexEntity.setOffWeaponItem(diamondSword);
/* 103 */                 alexEntity.setMainWeaponItem(diamondSword);
/* 104 */                 alexEntity.setState(1);
/* 105 */                 LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)entity, LivingEntityPatch.class);
/* 106 */                 if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && livingEntityPatch != null) {
/* 107 */                   livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.GUARD_BREAK_ATTACK, 0.0F);
/*     */                 }
/*     */               }
/*     */             };
/*     */         } }
/*     */       
/* 113 */       if (entity instanceof ChrisEntity) { final ChrisEntity chrisEntity = (ChrisEntity)entity; if (entity.m_9236_() instanceof ServerLevel)
/* 114 */           new DelayedTask(1)
/*     */             {
/*     */               public void run() {
/* 117 */                 chrisEntity.m_21153_(chrisEntity.m_21233_());
/* 118 */                 ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 119 */                 diamondSword.m_41663_(Enchantments.f_44980_, 5);
/* 120 */                 diamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 121 */                 diamondSword.m_41663_(Enchantments.f_44986_, 5);
/* 122 */                 chrisEntity.m_21008_(InteractionHand.OFF_HAND, diamondSword);
/* 123 */                 chrisEntity.setOffWeaponItem(diamondSword);
/* 124 */                 chrisEntity.setState(1);
/* 125 */                 LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)entity, LivingEntityPatch.class);
/* 126 */                 if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && livingEntityPatch != null)
/* 127 */                   livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.GUARD_BREAK_ATTACK, 0.0F); 
/*     */               }
/*     */             };  }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\TotemUsingEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */