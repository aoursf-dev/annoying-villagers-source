/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.pla.annoyingvillagers.entity.ChrisEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.Enchantments;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends DelayedTask
/*     */ {
/*     */   null(int waitTicks) {
/* 114 */     super(waitTicks);
/*     */   }
/*     */   public void run() {
/* 117 */     chrisEntity.m_21153_(chrisEntity.m_21233_());
/* 118 */     ItemStack diamondSword = new ItemStack((ItemLike)Items.f_42388_);
/* 119 */     diamondSword.m_41663_(Enchantments.f_44980_, 5);
/* 120 */     diamondSword.m_41663_(Enchantments.f_44977_, 5);
/* 121 */     diamondSword.m_41663_(Enchantments.f_44986_, 5);
/* 122 */     chrisEntity.m_21008_(InteractionHand.OFF_HAND, diamondSword);
/* 123 */     chrisEntity.setOffWeaponItem(diamondSword);
/* 124 */     chrisEntity.setState(1);
/* 125 */     LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)entity, LivingEntityPatch.class);
/* 126 */     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null && livingEntityPatch != null)
/* 127 */       livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.GUARD_BREAK_ATTACK, 0.0F); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\TotemUsingEvent$5.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */