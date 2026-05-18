/*     */ package com.pla.annoyingvillagers.util;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*     */ import net.minecraft.world.item.ArrowItem;
/*     */ import net.minecraft.world.item.BowItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.Level;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class BowFunction {
/*     */   public static void bowShoot(LivingEntityPatch<?> livingEntityPatch) {
/*     */     BowItem bowItem;
/*     */     ItemStack arrowStack;
/*     */     boolean creativeOrInfinity;
/*     */     float xRot, yRot;
/*  25 */     LivingEntity shooter = (LivingEntity)livingEntityPatch.getOriginal();
/*  26 */     Level level = shooter.m_9236_();
/*     */     
/*  28 */     if (level.f_46443_)
/*     */       return; 
/*  30 */     ItemStack bowStack = shooter.m_21120_(InteractionHand.MAIN_HAND);
/*  31 */     Item item1 = bowStack.m_41720_(); if (item1 instanceof BowItem) { bowItem = (BowItem)item1; }
/*     */     else
/*     */     { return; }
/*     */     
/*  35 */     if (shooter instanceof Player && !hasArrowOrInfinity(shooter, bowStack)) {
/*     */       return;
/*     */     }
/*     */     
/*  39 */     if (!bowStack.m_41619_() && bowStack.m_41783_() != null) {
/*  40 */       bowStack.m_41783_().m_128350_("Pulling", 0.65F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     if (shooter instanceof Player) { Player player = (Player)shooter;
/*  47 */       arrowStack = player.m_6298_(bowStack);
/*     */       
/*  49 */       creativeOrInfinity = ((player.m_150110_()).f_35937_ || EnchantmentHelper.m_44843_(Enchantments.f_44952_, bowStack) > 0); }
/*     */     else
/*  51 */     { if ((shooter instanceof com.pla.annoyingvillagers.entity.VillagerScoutEntity || shooter instanceof com.pla.annoyingvillagers.entity.RedVillagerGeneralEntity || shooter instanceof com.pla.annoyingvillagers.entity.BlueVillagerGeneralEntity || shooter instanceof com.pla.annoyingvillagers.entity.GreenVillagerGeneralEntity || shooter instanceof com.pla.annoyingvillagers.entity.PurpleVillagerGeneralEntity || shooter instanceof com.pla.annoyingvillagers.entity.VillagerScoutCaptainEntity) && ((AVNpc)shooter)
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  56 */         .m_5448_() instanceof com.pla.annoyingvillagers.clazz.HerobrineMob) {
/*  57 */         arrowStack = new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get());
/*     */       } else {
/*  59 */         arrowStack = new ItemStack((ItemLike)Items.f_42412_);
/*     */       } 
/*  61 */       creativeOrInfinity = true; }
/*     */ 
/*     */     
/*  64 */     if (arrowStack.m_41619_() && !creativeOrInfinity) {
/*     */       return;
/*     */     }
/*     */     
/*  68 */     if (arrowStack.m_41619_()) {
/*  69 */       arrowStack = new ItemStack((ItemLike)Items.f_42412_);
/*     */     }
/*     */     
/*  72 */     int charge = 20;
/*  73 */     float power = BowItem.m_40661_(charge);
/*  74 */     if (power < 0.1F) {
/*     */       return;
/*     */     }
/*     */     
/*  78 */     Item item2 = arrowStack.m_41720_(); ArrowItem ai = (ArrowItem)item2, arrowItem = (item2 instanceof ArrowItem) ? ai : (ArrowItem)Items.f_42412_;
/*  79 */     AbstractArrow abstractArrow = arrowItem.m_6394_(level, arrowStack, shooter);
/*  80 */     abstractArrow = bowItem.customArrow(abstractArrow);
/*     */ 
/*     */ 
/*     */     
/*  84 */     float arrowInaccuracy = 1.0F;
/*     */     
/*  86 */     if (!(shooter instanceof Player)) {
/*  87 */       LivingEntity target = livingEntityPatch.getTarget();
/*     */       
/*  89 */       if (target != null && target.m_6084_()) {
/*  90 */         double distance = shooter.m_20270_((Entity)target);
/*     */         
/*  92 */         double horizontalSpread = 0.15D + distance * 0.03D;
/*  93 */         double verticalSpread = 0.05D + distance * 0.02D;
/*     */         
/*  95 */         double aimX = target.m_20185_() + (level.m_213780_().m_188500_() - 0.5D) * 2.0D * horizontalSpread;
/*  96 */         double aimY = target.m_20188_() + (level.m_213780_().m_188500_() - 0.5D) * 2.0D * verticalSpread;
/*  97 */         double aimZ = target.m_20189_() + (level.m_213780_().m_188500_() - 0.5D) * 2.0D * horizontalSpread;
/*     */         
/*  99 */         double dx = aimX - shooter.m_20185_();
/* 100 */         double dz = aimZ - shooter.m_20189_();
/* 101 */         double dy = aimY - shooter.m_20188_();
/* 102 */         double horiz = Math.sqrt(dx * dx + dz * dz);
/*     */         
/* 104 */         yRot = (float)(Mth.m_14136_(dz, dx) * 57.29577951308232D) - 90.0F;
/* 105 */         xRot = (float)-(Mth.m_14136_(dy, horiz) * 57.29577951308232D);
/* 106 */         xRot = Mth.m_14036_(xRot, -89.9F, 89.9F);
/*     */         
/* 108 */         shooter.m_146922_(yRot);
/* 109 */         shooter.m_146926_(xRot);
/* 110 */         shooter.m_5618_(yRot);
/* 111 */         shooter.m_5616_(yRot);
/*     */         
/* 113 */         arrowInaccuracy = 2.0F;
/*     */       } else {
/* 115 */         xRot = shooter.m_146909_();
/* 116 */         yRot = shooter.m_146908_();
/* 117 */         arrowInaccuracy = 2.0F;
/*     */       } 
/*     */     } else {
/* 120 */       xRot = shooter.m_146909_();
/* 121 */       yRot = shooter.m_146908_();
/*     */     } 
/*     */     
/* 124 */     abstractArrow.m_5602_((Entity)shooter);
/* 125 */     abstractArrow.m_37251_((Entity)shooter, xRot, yRot, 0.0F, power * 3.0F, arrowInaccuracy);
/*     */     
/* 127 */     if (!bowStack.m_41619_() && bowStack.m_41783_() != null) {
/* 128 */       bowStack.m_41783_().m_128473_("Pulling");
/*     */     }
/*     */ 
/*     */     
/* 132 */     if (power == 1.0F) {
/* 133 */       abstractArrow.m_36762_(true);
/*     */     }
/*     */     
/* 136 */     int powerLevel = EnchantmentHelper.m_44843_(Enchantments.f_44988_, bowStack);
/* 137 */     if (powerLevel > 0) {
/* 138 */       abstractArrow.m_36781_(abstractArrow
/* 139 */           .m_36789_() + powerLevel * 0.5D + 0.5D);
/*     */     }
/*     */ 
/*     */     
/* 143 */     int punchLevel = EnchantmentHelper.m_44843_(Enchantments.f_44989_, bowStack);
/* 144 */     if (punchLevel > 0) {
/* 145 */       abstractArrow.m_36735_(punchLevel);
/*     */     }
/*     */     
/* 148 */     if (EnchantmentHelper.m_44843_(Enchantments.f_44990_, bowStack) > 0) {
/* 149 */       abstractArrow.m_20254_(100);
/*     */     }
/*     */     
/* 152 */     level.m_7967_((Entity)abstractArrow);
/* 153 */     if ((shooter instanceof com.pla.annoyingvillagers.entity.VillagerScoutEntity || shooter instanceof com.pla.annoyingvillagers.entity.VillagerScoutCaptainEntity) && ((AVNpc)shooter)
/* 154 */       .getVoiceCooldown() == 0) {
/* 155 */       shooter.m_5496_((SoundEvent)AnnoyingVillagersModSounds.VILLAGER_SCOUTS_SAY_ON_FIRE.get(), 1.0F, 1.0F);
/* 156 */       ((AVNpc)shooter).resetVoiceCooldown((Mob)shooter);
/*     */     } 
/* 158 */     if ((shooter instanceof com.pla.annoyingvillagers.entity.RedVillagerGeneralEntity || shooter instanceof com.pla.annoyingvillagers.entity.BlueVillagerGeneralEntity || shooter instanceof com.pla.annoyingvillagers.entity.GreenVillagerGeneralEntity || shooter instanceof com.pla.annoyingvillagers.entity.PurpleVillagerGeneralEntity) && ((AVNpc)shooter)
/*     */ 
/*     */       
/* 161 */       .getVoiceCooldown() == 0) {
/* 162 */       shooter.m_5496_((SoundEvent)AnnoyingVillagersModSounds.VILLAGER_GENERALS_SAY_ON_FIRE.get(), 1.0F, 1.0F);
/* 163 */       ((AVNpc)shooter).resetVoiceCooldown((Mob)shooter);
/*     */     } 
/* 165 */     level.m_6263_(null, shooter
/*     */         
/* 167 */         .m_20185_(), shooter.m_20186_(), shooter.m_20189_(), SoundEvents.f_11687_, SoundSource.PLAYERS, 1.0F, 1.0F / (level
/*     */ 
/*     */ 
/*     */         
/* 171 */         .m_213780_().m_188501_() * 0.4F + 1.2F) + power * 0.5F);
/*     */ 
/*     */     
/* 174 */     if (shooter instanceof Player) { Player player = (Player)shooter; if (!(player.m_150110_()).f_35937_) {
/*     */ 
/*     */         
/* 177 */         boolean infiniteArrow = (creativeOrInfinity || (arrowItem.isInfinite(arrowStack, bowStack, player) && arrowStack.m_150930_(Items.f_42412_)));
/*     */         
/* 179 */         if (!infiniteArrow) {
/* 180 */           arrowStack.m_41774_(1);
/* 181 */           if (arrowStack.m_41619_()) {
/* 182 */             player.m_150109_().m_36057_(arrowStack);
/*     */           }
/*     */         } 
/*     */         
/* 186 */         bowStack.m_41622_(1, (LivingEntity)player, p -> p.m_21190_(InteractionHand.MAIN_HAND));
/* 187 */         player.m_36246_(Stats.f_12982_.m_12902_(bowItem));
/*     */       }  }
/*     */   
/*     */   } public static boolean hasArrowOrInfinity(LivingEntity entity, ItemStack bowStack) {
/*     */     Player player;
/* 192 */     if (entity instanceof Player) { player = (Player)entity; }
/* 193 */     else { return true; }
/* 194 */      if ((player.m_150110_()).f_35937_) {
/* 195 */       return true;
/*     */     }
/*     */     
/* 198 */     if (!(bowStack.m_41720_() instanceof BowItem)) {
/* 199 */       return false;
/*     */     }
/* 201 */     int infinityLevel = EnchantmentHelper.getTagEnchantmentLevel(Enchantments.f_44952_, bowStack);
/* 202 */     boolean hasInfinity = (infinityLevel > 0);
/*     */     
/* 204 */     ItemStack projectile = player.m_6298_(bowStack);
/* 205 */     boolean hasArrow = !projectile.m_41619_();
/*     */     
/* 207 */     return (hasArrow || hasInfinity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\BowFunction.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */