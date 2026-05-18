/*     */ package com.pla.annoyingvillagers.skill;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.skill.SkillBuilder;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ import yesman.epicfight.world.entity.eventlistener.TakeDamageEvent;
/*     */ 
/*     */ public class GreatSwordSkill extends WeaponInnateSkill {
/*  32 */   private static final UUID EVENT_UUID = UUID.fromString("5a6ceb12-eacb-49c6-8030-37942b192e1d");
/*     */   
/*     */   private static final float FRONT_DOT_THRESHOLD = 0.25F;
/*     */   private static final float COUNTER_DAMAGE = 6.0F;
/*     */   private static final double KNOCKBACK_STRENGTH = 1.0D;
/*     */   
/*     */   public GreatSwordSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/*  39 */     super(builder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/*  44 */     final LivingEntity livingEntity = (LivingEntity)skillContainer.getExecutor().getOriginal();
/*  45 */     final ServerLevel serverLevel = (ServerLevel)livingEntity.m_9236_();
/*  46 */     if (skillContainer.isActivated()) {
/*  47 */       cancelOnServer(skillContainer, friendlyByteBuf);
/*     */     } else {
/*  49 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AVAnimations.HARD_GREATSWORD_GUARD_SKILL, 0.0F);
/*  50 */       livingEntity.m_7292_(new MobEffectInstance((MobEffect)EpicFightMobEffects.STUN_IMMUNITY.get(), 60, 2));
/*     */       
/*  52 */       new DelayedTask(4) {
/*     */           public void run() {
/*  54 */             serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.RED_SPARK
/*  55 */                 .get(), livingEntity
/*  56 */                 .m_20185_(), livingEntity.m_20186_() + 1.5D, livingEntity.m_20189_() + 1.0D, 35, 0.0D, 0.0D, 0.0D, 0.6D);
/*     */ 
/*     */             
/*  59 */             serverLevel.m_6263_(null, livingEntity.m_20185_(), livingEntity.m_20186_(), livingEntity.m_20189_(), (SoundEvent)AnnoyingVillagersModSounds.HARD_GREATSWORD_SKILL
/*  60 */                 .get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*     */           }
/*     */         };
/*     */       
/*  64 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/*  65 */       skillContainer.activate();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancelOnServer(SkillContainer container, FriendlyByteBuf args) {
/*  71 */     container.deactivate();
/*  72 */     super.cancelOnServer(container, args);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canExecute(SkillContainer container) {
/*  77 */     if (container.isActivated()) return true; 
/*  78 */     return super.canExecute(container);
/*     */   }
/*     */   
/*     */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/*  82 */     super.executeOnClient(container, args);
/*  83 */     container.activate();
/*     */   }
/*     */   
/*     */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/*  87 */     super.cancelOnClient(container, args);
/*  88 */     container.deactivate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInitiate(SkillContainer container) {
/*  93 */     super.onInitiate(container);
/*  94 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID, event -> { if (((ServerPlayerPatch)event.getPlayerPatch()).isLogicalClient()) return;  PlayerPatch<?> playerPatch = event.getPlayerPatch(); Player defender = (Player)playerPatch.getOriginal(); AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null))).getRealAnimation(); if (dynamicAnimation == null || dynamicAnimation != AVAnimations.HARD_GREATSWORD_GUARD_SKILL) return;  Entity attacker = event.getDamageSource().m_7639_(); if (attacker instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)attacker; if (attacker.m_6084_()) { Vec3 fwd = defender.m_20252_(1.0F).m_82541_(); Vec3 toAttacker = attacker.m_20182_().m_82546_(defender.m_20182_()).m_82541_(); if (fwd.m_82526_(toAttacker) <= 0.25D) return;  LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(attacker, LivingEntityPatch.class); if (livingEntityPatch != null) livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.GUARD_BREAK_ATTACK, 0.0F);  livingEntity.m_147240_(1.0D, defender.m_20185_() - attacker.m_20185_(), defender.m_20189_() - attacker.m_20189_()); if (container.getStack() < 1) { GreatSwordSkill greatSwordSkill = (GreatSwordSkill)container.getSkill(); float currentResource = container.getResource(); float neededResource = container.getNeededResource(); float addResource = Math.min(20.0F, neededResource); greatSwordSkill.setConsumptionSynchronize(container, currentResource + addResource); }  attacker.f_19864_ = true; attacker.m_6469_(defender.m_269291_().m_269075_(defender), 6.0F); event.setCanceled(true); event.setResult(AttackResult.ResultType.BLOCKED); return; }  }  }10);
/*     */   }
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
/*     */   public void onRemoved(SkillContainer container) {
/* 137 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID);
/* 138 */     super.onRemoved(container);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\GreatSwordSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */