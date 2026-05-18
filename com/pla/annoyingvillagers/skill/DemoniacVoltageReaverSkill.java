/*     */ package com.pla.annoyingvillagers.skill;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.SnakeBladeHit;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.skill.Skill;
/*     */ import yesman.epicfight.skill.SkillBuilder;
/*     */ import yesman.epicfight.skill.SkillCategories;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ import yesman.epicfight.world.entity.eventlistener.SkillCastEvent;
/*     */ import yesman.epicfight.world.entity.eventlistener.TakeDamageEvent;
/*     */ 
/*     */ public class DemoniacVoltageReaverSkill extends WeaponInnateSkill {
/*  27 */   private static final UUID EVENT_UUID = UUID.fromString("a86b0713-5f98-4e04-9930-fee81f157780");
/*     */   
/*     */   public DemoniacVoltageReaverSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/*  30 */     super(builder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/*  35 */     Player player = (Player)skillContainer.getExecutor().getOriginal();
/*  36 */     if (SnakeBladeHit.checkNearbyTarget((LivingEntity)player)) {
/*  37 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.SNAKE_BLADE, 0.0F);
/*  38 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canExecute(SkillContainer container) {
/*  44 */     Player player = (Player)container.getExecutor().getOriginal();
/*  45 */     ItemStack stack = player.m_21205_();
/*     */     
/*  47 */     boolean isCorrectItem = stack.m_41720_() instanceof com.pla.annoyingvillagers.item.DemoniacVoltageReaverItem;
/*  48 */     boolean isSnaking = (stack.m_41782_() && stack.m_41783_() != null && stack.m_41783_().m_128471_("SnakeAnimation"));
/*  49 */     boolean isActivated = container.isActivated();
/*     */     
/*  51 */     return (isCorrectItem && !isSnaking && !isActivated && super.canExecute(container));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInitiate(SkillContainer container) {
/*  56 */     super.onInitiate(container);
/*  57 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.SKILL_CAST_EVENT, EVENT_UUID, event -> {
/*     */           Player player = (Player)container.getExecutor().getOriginal();
/*     */           
/*     */           ItemStack item = player.m_21205_();
/*     */           
/*     */           Skill skill = event.getSkillContainer().getSkill();
/*     */           
/*     */           if (skill.getCategory() == SkillCategories.GUARD) {
/*     */             PlayerPatch patt3033$temp = container.getExecutor();
/*     */             
/*     */             if (patt3033$temp instanceof ServerPlayerPatch) {
/*     */               ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)patt3033$temp;
/*     */               
/*     */               if (container.getStack() >= 1 && item.m_41720_() instanceof com.pla.annoyingvillagers.item.DemoniacVoltageReaverItem && item.m_41783_() != null) {
/*     */                 event.setCanceled(true);
/*     */                 if (!item.m_41783_().m_128471_("SnakeAnimation")) {
/*     */                   container.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.SNAKE_BLADE_GUARD, 0.0F);
/*     */                   (getResourceType()).consumer.consume(container, serverPlayerPatch, getDefaultConsumptionAmount((PlayerPatch)serverPlayerPatch));
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } else if (skill.getCategory() == SkillCategories.BASIC_ATTACK && item.m_41720_() instanceof com.pla.annoyingvillagers.item.DemoniacVoltageReaverItem && item.m_41783_() != null && item.m_41783_().m_128471_("SnakeAnimation")) {
/*     */             event.setCanceled(true);
/*     */           } 
/*     */         });
/*  82 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID, pre -> {
/*     */           if (((ServerPlayerPatch)pre.getPlayerPatch()).isLogicalClient()) {
/*     */             return;
/*     */           }
/*     */           PlayerPatch<?> playerPatch = pre.getPlayerPatch();
/*     */           AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*     */           if (dynamicAnimation == null)
/*     */             return; 
/*     */           if (dynamicAnimation == AVAnimations.SNAKE_BLADE_GUARD) {
/*     */             pre.setCanceled(true);
/*     */             pre.setResult(AttackResult.ResultType.BLOCKED);
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public void onRemoved(SkillContainer container) {
/*  98 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.SKILL_CAST_EVENT, EVENT_UUID);
/*  99 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/* 104 */     skillContainer.deactivate();
/* 105 */     super.cancelOnServer(skillContainer, friendlyByteBuf);
/*     */   }
/*     */   
/*     */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 109 */     super.executeOnClient(container, args);
/* 110 */     container.activate();
/*     */   }
/*     */   
/*     */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/* 114 */     super.cancelOnClient(container, args);
/* 115 */     container.deactivate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateContainer(SkillContainer container) {
/* 120 */     super.updateContainer(container);
/* 121 */     Player player = (Player)container.getExecutor().getOriginal();
/* 122 */     ItemStack itemStack = player.m_21205_();
/* 123 */     if (container.getStack() == 1 && itemStack.m_41783_() != null && itemStack
/* 124 */       .m_41720_() instanceof com.pla.annoyingvillagers.item.DemoniacVoltageReaverItem && 
/* 125 */       !itemStack.m_41783_().m_128471_("SnakeAnimation") && 
/* 126 */       !itemStack.m_41783_().m_128471_("PlaySound")) {
/* 127 */       ((Player)container.getExecutor().getOriginal()).m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_WEAPON_SCREAMING.get(), 0.8F, 1.0F);
/* 128 */       itemStack.m_41783_().m_128379_("PlaySound", true);
/* 129 */     } else if (container.getStack() < 1 && itemStack.m_41783_() != null && itemStack
/* 130 */       .m_41720_() instanceof com.pla.annoyingvillagers.item.DemoniacVoltageReaverItem && itemStack.m_41783_().m_128471_("PlaySound")) {
/* 131 */       itemStack.m_41783_().m_128473_("PlaySound");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\DemoniacVoltageReaverSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */