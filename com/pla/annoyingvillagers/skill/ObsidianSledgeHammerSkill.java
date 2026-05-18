/*    */ package com.pla.annoyingvillagers.skill;
/*    */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*    */ import java.util.Objects;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import yesman.epicfight.api.animation.AnimationPlayer;
/*    */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*    */ import yesman.epicfight.api.asset.AssetAccessor;
/*    */ import yesman.epicfight.skill.Skill;
/*    */ import yesman.epicfight.skill.SkillBuilder;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*    */ import yesman.epicfight.world.entity.eventlistener.BasicAttackEvent;
/*    */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*    */ 
/*    */ public class ObsidianSledgeHammerSkill extends WeaponInnateSkill {
/* 19 */   private static final UUID EVENT_UUID = UUID.fromString("f79be742-fddd-454d-bd28-4d030613b284");
/*    */   public ObsidianSledgeHammerSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/* 21 */     super(builder);
/*    */   }
/*    */ 
/*    */   
/*    */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 26 */     if (!skillContainer.isActivated()) {
/* 27 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.POSE_UP, 0.0F);
/* 28 */       ((Player)skillContainer.getExecutor().getOriginal()).m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_WEAPON_SCREAMING.get(), 0.8F, 1.0F);
/* 29 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/* 30 */       skillContainer.activate();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void onInitiate(SkillContainer container) {
/* 36 */     super.onInitiate(container);
/* 37 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID, event -> {
/*    */           if (((ServerPlayerPatch)event.getPlayerPatch()).isLogicalClient()) {
/*    */             return;
/*    */           }
/*    */           SkillContainer skillContainer = ((ServerPlayerPatch)event.getPlayerPatch()).getSkill((Skill)this);
/*    */           if (skillContainer.isActivated()) {
/*    */             event.setCanceled(true);
/*    */             PlayerPatch<?> playerPatch = event.getPlayerPatch();
/*    */             AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*    */             if (dynamicAnimation != null && dynamicAnimation == AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1) {
/*    */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_2, 0.0F);
/*    */             } else {
/*    */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.SLEDGEHAMMER_TORMENT_BERSERK_AUTO_1, 0.0F);
/*    */             } 
/*    */           } 
/*    */         });
/*    */   }
/*    */   
/*    */   public void cancelOnServer(SkillContainer container, FriendlyByteBuf args) {
/* 56 */     container.deactivate();
/* 57 */     super.cancelOnServer(container, args);
/*    */   }
/*    */   
/*    */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 61 */     super.executeOnClient(container, args);
/* 62 */     container.activate();
/*    */   }
/*    */   
/*    */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 66 */     super.cancelOnClient(container, args);
/* 67 */     container.deactivate();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onRemoved(SkillContainer container) {
/* 72 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\ObsidianSledgeHammerSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */