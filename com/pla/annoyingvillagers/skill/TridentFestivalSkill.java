/*     */ package com.pla.annoyingvillagers.skill;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkillDataKeys;
/*     */ import com.pla.annoyingvillagers.item.BlueDemonTridentItem;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.Projectile;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.skill.Skill;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.skill.SkillDataKey;
/*     */ import yesman.epicfight.skill.SkillDataManager;
/*     */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.entity.eventlistener.BasicAttackEvent;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ import yesman.epicfight.world.entity.eventlistener.TakeDamageEvent;
/*     */ 
/*     */ public class TridentFestivalSkill extends WeaponInnateSkill {
/*  32 */   private static final UUID EVENT_UUID = UUID.fromString("10cefa54-8fee-4627-a321-64a1a6388a25");
/*     */   
/*     */   public boolean isRangedMode(SkillContainer container) {
/*  35 */     return ((Boolean)container.getDataManager().getDataValue((SkillDataKey)AVSkillDataKeys.IS_TRIDENT_RANGED_MODE.get())).booleanValue();
/*     */   }
/*     */   
/*     */   public boolean isMeleeMode(SkillContainer container) {
/*  39 */     return !isRangedMode(container);
/*     */   }
/*     */   
/*     */   public void toggleMode(SkillContainer container) {
/*  43 */     SkillDataManager data = container.getDataManager();
/*  44 */     boolean current = ((Boolean)data.getDataValue((SkillDataKey)AVSkillDataKeys.IS_TRIDENT_RANGED_MODE.get())).booleanValue();
/*  45 */     data.setDataSync((SkillDataKey)AVSkillDataKeys.IS_TRIDENT_RANGED_MODE.get(), Boolean.valueOf(!current));
/*     */   }
/*     */   
/*     */   public TridentFestivalSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/*  49 */     super(builder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/*  54 */     if (!isActivated(skillContainer)) {
/*  55 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/*  56 */       skillContainer.activate();
/*  57 */       if (isRangedMode(skillContainer)) {
/*  58 */         Player player = (Player)skillContainer.getExecutor().getOriginal();
/*  59 */         ItemStack mainHand = player.m_21205_();
/*  60 */         ItemStack offHand = player.m_21206_();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  65 */         boolean bothFullyCharged = (BlueDemonTridentItem.isBlueDemonTrident(mainHand) && BlueDemonTridentItem.isBlueDemonTrident(offHand) && BlueDemonTridentItem.isFullyCharged(mainHand) && BlueDemonTridentItem.isFullyCharged(offHand));
/*  66 */         if (bothFullyCharged) {
/*  67 */           skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_FESTIVAL, 0.0F);
/*     */         } else {
/*  69 */           skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_ATTACK, 0.0F);
/*     */         } 
/*     */       } else {
/*  72 */         skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.ELECTRIC_FIELD, 0.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/*  79 */     skillContainer.deactivate();
/*  80 */     super.cancelOnServer(skillContainer, friendlyByteBuf);
/*     */   }
/*     */   
/*     */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/*  84 */     super.executeOnClient(container, args);
/*  85 */     container.activate();
/*     */   }
/*     */   
/*     */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/*  89 */     super.cancelOnClient(container, args);
/*  90 */     container.deactivate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateContainer(SkillContainer container) {
/*  95 */     super.updateContainer(container);
/*  96 */     Player player = (Player)container.getExecutor().getOriginal();
/*  97 */     Level level = player.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (player.f_19797_ % 20 == 0) {
/*  98 */         SkillDataManager data = container.getDataManager();
/*  99 */         data.setDataSync((SkillDataKey)AVSkillDataKeys.TRIDENT_AMOUNT.get(), Integer.valueOf(BlueDemonTridentItem.getAllOwnerTridents(serverLevel, (LivingEntity)player).size()));
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public void onInitiate(SkillContainer container) {
/* 105 */     super.onInitiate(container);
/* 106 */     container.getDataManager().setDataSync((SkillDataKey)AVSkillDataKeys.IS_TRIDENT_RANGED_MODE.get(), Boolean.valueOf(false));
/* 107 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID, event -> {
/*     */           if (((ServerPlayerPatch)event.getPlayerPatch()).isLogicalClient()) {
/*     */             return;
/*     */           }
/*     */ 
/*     */           
/*     */           SkillContainer skillContainer = ((ServerPlayerPatch)event.getPlayerPatch()).getSkill((Skill)this);
/*     */           
/*     */           if (skillContainer == null) {
/*     */             return;
/*     */           }
/*     */           
/*     */           if (isRangedMode(skillContainer)) {
/*     */             event.setCanceled(true);
/*     */             
/*     */             PlayerPatch<?> playerPatch = event.getPlayerPatch();
/*     */             
/*     */             AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*     */             
/*     */             if (dynamicAnimation != null && dynamicAnimation == AVAnimations.TRIDENT_THROW_1) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_THROW_2, 0.0F);
/*     */             } else if (dynamicAnimation != null && dynamicAnimation == AVAnimations.TRIDENT_THROW_2) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_THROW_3, 0.0F);
/*     */             } else if (dynamicAnimation != null && dynamicAnimation == AVAnimations.TRIDENT_THROW_3) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.DP_THROW_BLADE_AUTO_2, 0.0F);
/*     */             } else if (dynamicAnimation != null && dynamicAnimation == AVAnimations.DP_THROW_BLADE_AUTO_2) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_THROW_5, 0.0F);
/*     */             } else if (((Player)playerPatch.getOriginal()).m_20142_()) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.DP_THROW_BLADE_AUTO_1, 0.0F);
/*     */             } else if (!((Player)playerPatch.getOriginal()).m_20096_() && !((Player)playerPatch.getOriginal()).m_20069_()) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.THROW_HOOK_SLASH_AIR, 0.0F);
/*     */             } else {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_THROW_1, 0.0F);
/*     */             } 
/*     */           } 
/*     */         });
/*     */     
/* 144 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID, pre -> {
/*     */           if (((ServerPlayerPatch)pre.getPlayerPatch()).isLogicalClient())
/*     */             return; 
/*     */           PlayerPatch<?> playerPatch = pre.getPlayerPatch();
/*     */           AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*     */           if (dynamicAnimation == null)
/*     */             return; 
/*     */           if (dynamicAnimation == AVAnimations.TRIDENT_ATTACK || dynamicAnimation == AVAnimations.ELECTRIC_FIELD || dynamicAnimation == AVAnimations.TRIDENT_FESTIVAL) {
/*     */             pre.setCanceled(true);
/*     */             pre.setResult(AttackResult.ResultType.BLOCKED);
/*     */           } 
/*     */           if (((Player)playerPatch.getOriginal()).m_20142_()) {
/*     */             Entity patt8387$temp = pre.getDamageSource().m_7640_();
/*     */             if (patt8387$temp instanceof Projectile) {
/*     */               Projectile projectile = (Projectile)patt8387$temp;
/*     */               Vec3 entityPosition = projectile.m_20182_();
/*     */               Vec3 entityViewVector = ((ServerPlayer)((ServerPlayerPatch)pre.getPlayerPatch()).getOriginal()).m_20252_(1.0F);
/*     */               Vec3 entitySubtract = entityPosition.m_82546_(((ServerPlayer)((ServerPlayerPatch)pre.getPlayerPatch()).getOriginal()).m_146892_()).m_82541_();
/*     */               if (entitySubtract.m_82526_(entityViewVector) > 0.0D) {
/*     */                 pre.setCanceled(true);
/*     */                 pre.setResult(AttackResult.ResultType.BLOCKED);
/*     */                 Level patt8953$temp = ((Player)playerPatch.getOriginal()).m_9236_();
/*     */                 if (patt8953$temp instanceof ServerLevel) {
/*     */                   ServerLevel serverLevel = (ServerLevel)patt8953$temp;
/*     */                   EpicfightUtil.damageBlocked(pre.getDamageSource(), playerPatch.getOriginal(), serverLevel);
/*     */                 } 
/*     */                 if ((new Random()).nextBoolean()) {
/*     */                   playerPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_GUARD_HIT_1, 0.0F);
/*     */                 } else {
/*     */                   playerPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.TRIDENT_GUARD_HIT_2, 0.0F);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }); } public void onRemoved(SkillContainer container) {
/* 179 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID);
/* 180 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID);
/*     */   }
/*     */ 
/*     */   
/*     */   public ResourceLocation getSkillTexture() {
/* 185 */     return super.getSkillTexture();
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\TridentFestivalSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */