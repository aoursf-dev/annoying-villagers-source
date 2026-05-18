/*     */ package com.pla.annoyingvillagers.item;
/*     */ 
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonThrownTridentEntity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.ArmorUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.network.chat.MutableComponent;
/*     */ import net.minecraft.network.chat.Style;
/*     */ import net.minecraft.network.chat.TextColor;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.ArmorMaterial;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.TooltipFlag;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BlueDemonChestplateItem
/*     */   extends ArmorItem
/*     */ {
/*     */   private static final String TAG_CHEST_CHARGE = "BlueDemonChestCharge";
/*     */   public static final int MAX_CHEST_CHARGE = 100;
/*     */   private static final int CHEST_CHARGE_METER_STEPS = 10;
/*     */   private static final int CHEST_CHARGE_COLOR = 5634047;
/*     */   private static final int CHEST_CHARGE_DIM_COLOR = 2306872;
/*     */   
/*     */   public BlueDemonChestplateItem(ArmorItem.Type type, Item.Properties properties) {
/*  50 */     super(new ArmorMaterial()
/*     */         {
/*     */           public int m_266425_(@NotNull ArmorItem.Type pType) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/BlueDemonChestplateItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 54, 3 -> 60, 4 -> 66
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: sipush #403
/*     */             //   51: goto -> 69
/*     */             //   54: sipush #465
/*     */             //   57: goto -> 69
/*     */             //   60: sipush #775
/*     */             //   63: goto -> 69
/*     */             //   66: sipush #341
/*     */             //   69: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #53	-> 0
/*     */             //   #54	-> 48
/*     */             //   #55	-> 54
/*     */             //   #56	-> 60
/*     */             //   #57	-> 66
/*     */             //   #53	-> 69
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	70	0	this	Lcom/pla/annoyingvillagers/item/BlueDemonChestplateItem$1;
/*     */             //   0	70	1	pType	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_7366_(@NotNull ArmorItem.Type pType) {
/*     */             // Byte code:
/*     */             //   0: getstatic com/pla/annoyingvillagers/item/BlueDemonChestplateItem$2.$SwitchMap$net$minecraft$world$item$ArmorItem$Type : [I
/*     */             //   3: aload_1
/*     */             //   4: invokevirtual ordinal : ()I
/*     */             //   7: iaload
/*     */             //   8: tableswitch default -> 40, 1 -> 48, 2 -> 52, 3 -> 56, 4 -> 61
/*     */             //   40: new java/lang/IncompatibleClassChangeError
/*     */             //   43: dup
/*     */             //   44: invokespecial <init> : ()V
/*     */             //   47: athrow
/*     */             //   48: iconst_2
/*     */             //   49: goto -> 62
/*     */             //   52: iconst_5
/*     */             //   53: goto -> 62
/*     */             //   56: bipush #30
/*     */             //   58: goto -> 62
/*     */             //   61: iconst_2
/*     */             //   62: ireturn
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #63	-> 0
/*     */             //   #64	-> 48
/*     */             //   #65	-> 52
/*     */             //   #66	-> 56
/*     */             //   #67	-> 61
/*     */             //   #63	-> 62
/*     */             // Local variable table:
/*     */             //   start	length	slot	name	descriptor
/*     */             //   0	63	0	this	Lcom/pla/annoyingvillagers/item/BlueDemonChestplateItem$1;
/*     */             //   0	63	1	pType	Lnet/minecraft/world/item/ArmorItem$Type;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int m_6646_() {
/*  73 */             return 9;
/*     */           }
/*     */           
/*     */           @NotNull
/*     */           public SoundEvent m_7344_() {
/*  78 */             return SoundEvents.f_11675_;
/*     */           }
/*     */           
/*     */           @NotNull
/*     */           public Ingredient m_6230_() {
/*  83 */             return Ingredient.m_43927_(new ItemStack[] { new ItemStack((ItemLike)Items.f_42695_), new ItemStack((ItemLike)Items.f_42696_) }, );
/*     */           }
/*     */           
/*     */           @NotNull
/*     */           public String m_6082_() {
/*  88 */             return "blue_demon_chestplate";
/*     */           }
/*     */ 
/*     */           
/*     */           public float m_6651_() {
/*  93 */             return 2.0F;
/*     */           }
/*     */ 
/*     */           
/*     */           public float m_6649_() {
/*  98 */             return 0.0F;
/*     */           }
/*     */         },  type, properties);
/*     */   }
/*     */   private static final int CHEST_CHARGE_TEXT_COLOR = 12450815; private static final int CHEST_CHARGE_FULL_COLOR = 8191999; private static final String TAG_CHEST_BUFF_TICKS = "BlueDemonChestBuffTicks"; public static final int CHEST_BUFF_DURATION_TICKS = 600; public static final double CHEST_TRIDENT_ABSORB_BOX_HALF = 2.5D; private static final String TAG_BLUE_DEMON_HEALING_FOIL = "BlueDemonHealingFoil";
/*     */   public static boolean isBlueDemonChestplate(ItemStack stack) {
/* 104 */     return (!stack.m_41619_() && stack.m_41720_() instanceof BlueDemonChestplateItem);
/*     */   }
/*     */   
/*     */   public static int getStoredCharge(ItemStack stack) {
/* 108 */     if (!isBlueDemonChestplate(stack)) {
/* 109 */       return 0;
/*     */     }
/*     */     
/* 112 */     CompoundTag tag = stack.m_41783_();
/* 113 */     return (tag == null) ? 0 : Mth.m_14045_(tag.m_128451_("BlueDemonChestCharge"), 0, 100);
/*     */   }
/*     */   
/*     */   public static void setStoredCharge(ItemStack stack, int amount) {
/* 117 */     if (!isBlueDemonChestplate(stack)) {
/*     */       return;
/*     */     }
/*     */     
/* 121 */     stack.m_41784_().m_128405_("BlueDemonChestCharge", Mth.m_14045_(amount, 0, 100));
/*     */   }
/*     */   
/*     */   public static void addStoredCharge(ItemStack stack, int amount) {
/* 125 */     if (!isBlueDemonChestplate(stack) || amount <= 0) {
/*     */       return;
/*     */     }
/*     */     
/* 129 */     int current = getStoredCharge(stack);
/* 130 */     int added = Math.min(amount, 100 - current);
/*     */     
/* 132 */     if (added > 0) {
/* 133 */       setStoredCharge(stack, current + added);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isFullyCharged(ItemStack stack) {
/* 139 */     return (getStoredCharge(stack) >= 100);
/*     */   }
/*     */   
/*     */   public static boolean hasBlueDemonHealingFoil(ItemStack stack) {
/* 143 */     if (!isBlueDemonChestplate(stack)) {
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     CompoundTag tag = stack.m_41783_();
/* 148 */     return (tag != null && tag.m_128471_("BlueDemonHealingFoil"));
/*     */   }
/*     */   
/*     */   public static void setBlueDemonHealingFoil(ItemStack stack, boolean foil) {
/* 152 */     if (!isBlueDemonChestplate(stack)) {
/*     */       return;
/*     */     }
/*     */     
/* 156 */     if (foil) {
/* 157 */       stack.m_41784_().m_128379_("BlueDemonHealingFoil", true);
/*     */     } else {
/* 159 */       CompoundTag tag = stack.m_41783_();
/* 160 */       if (tag != null) {
/* 161 */         tag.m_128473_("BlueDemonHealingFoil");
/* 162 */         if (tag.m_128456_()) {
/* 163 */           stack.m_41751_(null);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_5812_(@NotNull ItemStack stack) {
/* 171 */     return (super.m_5812_(stack) || 
/* 172 */       isFullyCharged(stack) || 
/* 173 */       isBuffActive(stack) || 
/* 174 */       hasBlueDemonHealingFoil(stack));
/*     */   }
/*     */   
/*     */   public static int getBuffTicks(ItemStack stack) {
/* 178 */     if (!isBlueDemonChestplate(stack)) {
/* 179 */       return 0;
/*     */     }
/*     */     
/* 182 */     CompoundTag tag = stack.m_41783_();
/* 183 */     return (tag == null) ? 0 : Math.max(0, tag.m_128451_("BlueDemonChestBuffTicks"));
/*     */   }
/*     */   
/*     */   public static void setBuffTicks(ItemStack stack, int ticks) {
/* 187 */     if (!isBlueDemonChestplate(stack)) {
/*     */       return;
/*     */     }
/*     */     
/* 191 */     int clamped = Math.max(0, ticks);
/* 192 */     CompoundTag tag = stack.m_41783_();
/*     */     
/* 194 */     if (clamped == 0) {
/* 195 */       if (tag != null) {
/* 196 */         tag.m_128473_("BlueDemonChestBuffTicks");
/*     */         
/* 198 */         if (tag.m_128456_()) {
/* 199 */           stack.m_41751_(null);
/*     */         }
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 205 */     stack.m_41784_().m_128405_("BlueDemonChestBuffTicks", clamped);
/*     */   }
/*     */   
/*     */   public static void stopBuff(ItemStack stack) {
/* 209 */     if (!isBlueDemonChestplate(stack)) {
/*     */       return;
/*     */     }
/*     */     
/* 213 */     setBuffTicks(stack, 0);
/*     */   }
/*     */   
/*     */   public static void activateBuff(ItemStack stack) {
/* 217 */     if (!isBlueDemonChestplate(stack)) {
/*     */       return;
/*     */     }
/*     */     
/* 221 */     if (!isFullyCharged(stack)) {
/*     */       return;
/*     */     }
/* 224 */     stopBuff(stack);
/*     */     
/* 226 */     setBuffTicks(stack, 600);
/* 227 */     setStoredCharge(stack, 0);
/*     */   }
/*     */   
/*     */   public static boolean isBuffActive(ItemStack stack) {
/* 231 */     return (getBuffTicks(stack) > 0);
/*     */   }
/*     */   
/*     */   public static void tickActiveBuff(ItemStack stack, Player player) {
/* 235 */     if (!isBlueDemonChestplate(stack)) {
/*     */       return;
/*     */     }
/*     */     
/* 239 */     int ticks = getBuffTicks(stack);
/* 240 */     if (ticks <= 0) {
/*     */       return;
/*     */     }
/*     */     
/* 244 */     Level level = player.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 245 */       player.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 1, 1, false, false, false));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 254 */       player.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 1, 1, false, false, false));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 263 */       player.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 1, 2, false, false, false));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 272 */       if (serverLevel.f_46441_.m_188500_() <= 0.1D) {
/* 273 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/* 274 */             .get(), player
/* 275 */             .m_20185_(), player.m_20186_(), player.m_20189_(), 1, 0.3D, 1.2D, 0.3D, 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 281 */         if (serverLevel.f_46441_.m_188500_() <= 0.8D) {
/* 282 */           float volume = (float)Mth.m_216263_(serverLevel.f_46441_, 0.05D, 0.5D);
/* 283 */           float pitch = (float)Mth.m_216263_(serverLevel.f_46441_, 0.8D, 1.1D);
/*     */           
/* 285 */           serverLevel.m_5594_(null, 
/*     */               
/* 287 */               BlockPos.m_274561_(player.m_20185_(), player.m_20186_(), player.m_20189_()), (SoundEvent)AnnoyingVillagersModSounds.ELECTRIFY
/* 288 */               .get(), SoundSource.NEUTRAL, volume, pitch);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 296 */       if (player.f_19797_ % 2 == 0) {
/* 297 */         absorbNearbyGroundedOwnerTridents(serverLevel, player);
/*     */       } }
/*     */ 
/*     */     
/* 301 */     setBuffTicks(stack, ticks - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void absorbNearbyGroundedOwnerTridents(ServerLevel serverLevel, Player player) {
/* 311 */     AABB box = new AABB(player.m_20185_() - 2.5D, player.m_20186_() - 2.5D, player.m_20189_() - 2.5D, player.m_20185_() + 2.5D, player.m_20186_() + 2.5D, player.m_20189_() + 2.5D);
/*     */ 
/*     */     
/* 314 */     List<BlueDemonThrownTridentEntity> tridents = serverLevel.m_6443_(BlueDemonThrownTridentEntity.class, box, trident -> 
/*     */ 
/*     */         
/* 317 */         (trident.m_6084_() && trident.isGroundedTrident() && trident.belongsToOwner((LivingEntity)player) && !trident.isAbsorbingToWearer()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 323 */     for (BlueDemonThrownTridentEntity trident : tridents)
/* 324 */       trident.beginAbsorbToWearer((LivingEntity)player); 
/*     */   }
/*     */   
/*     */   public static class Chestplate
/*     */     extends BlueDemonChestplateItem {
/*     */     public Chestplate() {
/* 330 */       super(ArmorItem.Type.CHESTPLATE, (new Item.Properties()).m_41486_());
/*     */     }
/*     */     
/*     */     public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot equipmentslot, String s) {
/* 334 */       return "annoyingvillagers:textures/models/armor/blue_demon_chestplate_layer.png";
/*     */     }
/*     */ 
/*     */     
/*     */     public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
/* 339 */       super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);
/*     */       
/* 341 */       if (player.m_6844_(EquipmentSlot.CHEST) != stack) {
/* 342 */         if (isBuffActive(stack)) {
/* 343 */           stopBuff(stack);
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 348 */       ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.FEET, "Blue Demon Chestplate");
/* 349 */       ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.LEGS, "Blue Demon Chestplate");
/* 350 */       ArmorUtil.dropArmorSlot((LivingEntity)player, EquipmentSlot.HEAD, "Blue Demon Chestplate");
/*     */       
/* 352 */       tickActiveBuff(stack, player);
/*     */     }
/*     */ 
/*     */     
/*     */     public void m_7373_(@NotNull ItemStack stack, Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
/* 357 */       super.m_7373_(stack, level, tooltip, flag);
/*     */       
/* 359 */       int charge = getStoredCharge(stack);
/*     */       
/* 361 */       tooltip.add(Component.m_237115_("tooltip.annoyingvillagers.blue_demon_chestplate"));
/* 362 */       addChestChargeTooltip(tooltip, charge);
/*     */     }
/*     */     
/*     */     private static void addChestChargeTooltip(List<Component> tooltip, int charge) {
/* 366 */       tooltip.add(
/* 367 */           Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.blue_demon_chestplate_thunder_charge").getString())
/* 368 */           .m_130938_(style -> style.m_131136_(Boolean.valueOf(true)).m_131148_(TextColor.m_131266_(5634047))));
/*     */ 
/*     */       
/* 371 */       tooltip.add(
/* 372 */           Component.m_237113_("" + charge + " / 100")
/* 373 */           .m_130938_(style -> style.m_131148_(TextColor.m_131266_(12450815))));
/*     */ 
/*     */       
/* 376 */       tooltip.add(buildChestChargeMeter(charge));
/*     */       
/* 378 */       if (charge >= 100) {
/* 379 */         tooltip.add(
/* 380 */             Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.thunder_charged").getString())
/* 381 */             .m_130938_(style -> style.m_131136_(Boolean.valueOf(true)).m_131148_(TextColor.m_131266_(8191999))));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private static Component buildChestChargeMeter(int charge) {
/* 387 */       int filledSteps = Math.round(charge / 100.0F * 10.0F);
/* 388 */       filledSteps = Mth.m_14045_(filledSteps, 0, 10);
/*     */       
/* 390 */       MutableComponent meter = Component.m_237119_();
/*     */       
/* 392 */       meter.m_7220_(
/* 393 */           (Component)Component.m_237113_("⛨ ")
/* 394 */           .m_130938_(style -> style.m_131148_(TextColor.m_131266_(5634047))));
/*     */ 
/*     */       
/* 397 */       for (int i = 0; i < 10; i++) {
/* 398 */         boolean filled = (i < filledSteps);
/*     */         
/* 400 */         meter.m_7220_(
/* 401 */             (Component)Component.m_237113_(filled ? "▰" : "▱")
/* 402 */             .m_130938_(style -> style.m_131148_(TextColor.m_131266_(filled ? 5634047 : 2306872))));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 408 */       return (Component)meter;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\BlueDemonChestplateItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */