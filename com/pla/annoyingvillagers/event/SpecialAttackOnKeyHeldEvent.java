/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import com.pla.annoyingvillagers.item.BlueDemonChestplateItem;
/*    */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*    */ import java.util.Objects;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EquipmentSlot;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.gameasset.Animations;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
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
/*    */ public class SpecialAttackOnKeyHeldEvent
/*    */ {
/*    */   public static void execute(LevelAccessor world, Entity entity) {
/* 43 */     if (entity == null)
/*    */       return; 
/* 45 */     PlayerPatch<?> playerpatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch(entity, PlayerPatch.class);
/* 46 */     LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 47 */     if (livingEntityPatch == null)
/* 48 */       return;  AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 49 */     if (EpicfightUtil.isLongHitAnimation(dynamicAnimation, livingEntityPatch)) {
/*    */       return;
/*    */     }
/*    */     
/* 53 */     if (entity.m_9236_() instanceof net.minecraft.server.level.ServerLevel && 
/* 54 */       dynamicAnimation != Animations.EMPTY_ANIMATION) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 59 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 60 */       if (player.m_6844_(EquipmentSlot.CHEST).m_41720_() instanceof BlueDemonChestplateItem && BlueDemonChestplateItem.isBlueDemonChestplate(player.m_6844_(EquipmentSlot.CHEST)) && 
/* 61 */         entity.m_9236_() instanceof net.minecraft.server.level.ServerLevel) {
/* 62 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.CUT_ANTITHEUS_ASCENSION, 0.0F);
/*    */         return;
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\SpecialAttackOnKeyHeldEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */