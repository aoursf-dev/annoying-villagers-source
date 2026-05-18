/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.entity.EnderAegisProjectile;
/*    */ import java.util.Random;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.UseAnim;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class EnderAegisProjectileItem
/*    */   extends Item
/*    */ {
/*    */   public EnderAegisProjectileItem() {
/* 22 */     super((new Item.Properties()).m_41503_(100));
/*    */   }
/*    */   @NotNull
/*    */   public InteractionResultHolder<ItemStack> m_7203_(@NotNull Level level, Player player, @NotNull InteractionHand interactionhand) {
/* 26 */     player.m_6672_(interactionhand);
/* 27 */     return new InteractionResultHolder(InteractionResult.SUCCESS, player.m_21120_(interactionhand));
/*    */   }
/*    */   @NotNull
/*    */   public UseAnim m_6164_(@NotNull ItemStack itemstack) {
/* 31 */     return UseAnim.SPEAR;
/*    */   }
/*    */   
/*    */   public int m_8105_(@NotNull ItemStack itemstack) {
/* 35 */     return 72000;
/*    */   }
/*    */   
/*    */   public void m_5551_(@NotNull ItemStack itemstack, Level level, @NotNull LivingEntity livingentity, int i) {
/* 39 */     if (!level.m_5776_() && livingentity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingentity;
/* 40 */       if (serverPlayer.m_6084_()) {
/* 41 */         EnderAegisProjectile enderAegisProjectile = EnderAegisProjectile.shoot(level, (LivingEntity)serverPlayer, new Random(), 1.0F, 18.0D, 7);
/*    */         
/* 43 */         itemstack.m_41622_(1, (LivingEntity)serverPlayer, serverplayer1 -> serverplayer1.m_21190_(serverPlayer.m_7655_()));
/*    */ 
/*    */         
/* 46 */         enderAegisProjectile.f_36705_ = AbstractArrow.Pickup.DISALLOWED;
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EnderAegisProjectileItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */