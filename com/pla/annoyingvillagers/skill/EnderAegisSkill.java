/*     */ package com.pla.annoyingvillagers.skill;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.EntityState;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.skill.Skill;
/*     */ import yesman.epicfight.skill.SkillBuilder;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.entity.eventlistener.BasicAttackEvent;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ import yesman.epicfight.world.entity.eventlistener.TakeDamageEvent;
/*     */ 
/*     */ public class EnderAegisSkill
/*     */   extends WeaponInnateSkill {
/*  38 */   private static final UUID EVENT_UUID = UUID.fromString("348aa19d-7c78-4959-9639-00c467ed258d");
/*     */   
/*     */   public EnderAegisSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/*  41 */     super(builder);
/*     */   }
/*     */   
/*     */   public static void onParry(ServerPlayerPatch serverPlayerPatch) {
/*  45 */     SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.ENDER_AEGIS);
/*  46 */     if (skillContainer == null)
/*  47 */       return;  EnderAegisSkill enderAegisSkill = (EnderAegisSkill)skillContainer.getSkill();
/*     */     
/*  49 */     if (!skillContainer.isActivated() && skillContainer.getStack() < 1) {
/*  50 */       float currentResource = skillContainer.getResource();
/*  51 */       float neededResource = skillContainer.getNeededResource();
/*  52 */       float addResource = Math.min(5.0F, neededResource);
/*  53 */       enderAegisSkill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*  54 */     } else if (skillContainer.isActivated()) {
/*  55 */       enderAegisSkill.setDurationSynchronize(skillContainer, skillContainer.getRemainDuration() + 40);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/*  61 */     if (!skillContainer.isActivated()) {
/*  62 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.ENDER_AEGIS_NAPOLEON_RELOAD_1, 0.0F);
/*  63 */       ((Player)skillContainer.getExecutor().getOriginal()).m_5496_((SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_WEAPON_SCREAMING.get(), 0.8F, 1.0F);
/*  64 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/*  65 */       skillContainer.activate();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/*  70 */     super.executeOnClient(container, args);
/*  71 */     container.activate();
/*     */   }
/*     */   
/*     */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/*  75 */     super.cancelOnClient(container, args);
/*  76 */     container.deactivate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInitiate(SkillContainer container) {
/*  81 */     super.onInitiate(container);
/*  82 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID, event -> {
/*     */           SkillContainer skillContainer = ((ServerPlayerPatch)event.getPlayerPatch()).getSkill((Skill)this);
/*     */           
/*     */           ItemStack itemStack = ((ServerPlayer)((ServerPlayerPatch)event.getPlayerPatch()).getOriginal()).m_21205_();
/*     */           
/*     */           if (skillContainer == null) {
/*     */             return;
/*     */           }
/*     */           
/*     */           if (skillContainer.isActivated() && itemStack.m_41783_() != null) {
/*     */             event.setCanceled(true);
/*     */             if (((ServerPlayer)((ServerPlayerPatch)event.getPlayerPatch()).getOriginal()).m_36335_().m_41521_(itemStack.m_41720_(), 0.0F) == 0.0F) {
/*     */               skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.AEGIS_SHIELD_SHOOT, 0.0F);
/*     */             }
/*     */           } 
/*     */         });
/*  98 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID, pre -> {
/*     */           PlayerPatch<?> playerPatch = pre.getPlayerPatch();
/*     */           ServerPlayer serverPlayer = (ServerPlayer)((ServerPlayerPatch)pre.getPlayerPatch()).getOriginal();
/*     */           DamageSource damageSource = pre.getDamageSource();
/*     */           SkillContainer skillContainer = ((ServerPlayerPatch)pre.getPlayerPatch()).getSkill((Skill)this);
/*     */           if (skillContainer == null) {
/*     */             return;
/*     */           }
/*     */           EnderAegisSkill enderAegisSkill = (EnderAegisSkill)skillContainer.getSkill();
/*     */           AnimationPlayer animationPlayer = Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null));
/*     */           AssetAccessor<? extends StaticAnimation> dynamicAnimation = animationPlayer.getRealAnimation();
/*     */           float elapsedTimeFloat = animationPlayer.getElapsedTime();
/*     */           EntityState entityState = ((StaticAnimation)dynamicAnimation.get()).getState((LivingEntityPatch)playerPatch, elapsedTimeFloat);
/*     */           if (!damageSource.m_276093_(DamageTypes.f_268515_) && !damageSource.m_276093_(DamageTypes.f_268565_) && !damageSource.m_276093_(DamageTypes.f_268468_) && !damageSource.m_276093_(DamageTypes.f_268631_) && !damageSource.m_276093_(DamageTypes.f_268671_) && skillContainer.isActivated() && dynamicAnimation == AVAnimations.AEGIS_SHIELD_SHOOT && entityState.getLevel() < 3) {
/*     */             Entity entity = damageSource.m_7639_();
/*     */             if (entity != null) {
/*     */               Vec3 entityPosition = entity.m_20182_();
/*     */               Vec3 entityViewVector = ((ServerPlayer)((ServerPlayerPatch)pre.getPlayerPatch()).getOriginal()).m_20252_(1.0F);
/*     */               Vec3 entitySubtract = entityPosition.m_82546_(((ServerPlayer)((ServerPlayerPatch)pre.getPlayerPatch()).getOriginal()).m_146892_()).m_82541_();
/*     */               if (entitySubtract.m_82526_(entityViewVector) > 0.0D) {
/*     */                 pre.setCanceled(true);
/*     */                 pre.setResult(AttackResult.ResultType.BLOCKED);
/*     */                 entity.m_20256_(new Vec3((entity.m_20154_()).f_82479_ * -0.2D, 0.0D, (entity.m_20154_()).f_82481_ * -0.2D));
/*     */                 serverPlayer.m_20256_(new Vec3((serverPlayer.m_20154_()).f_82479_ * -0.2D, 0.0D, (serverPlayer.m_20154_()).f_82481_ * -0.2D));
/*     */                 Level patt7059$temp = serverPlayer.m_9236_();
/*     */                 if (patt7059$temp instanceof ServerLevel) {
/*     */                   ServerLevel serverLevel = (ServerLevel)patt7059$temp;
/*     */                   EpicfightUtil.damageBlocked(damageSource, (Entity)serverPlayer, serverLevel);
/*     */                 } 
/*     */                 enderAegisSkill.setDurationSynchronize(skillContainer, skillContainer.getRemainDuration() + 40);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void onRemoved(SkillContainer container) {
/* 136 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, EVENT_UUID);
/* 137 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\EnderAegisSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */