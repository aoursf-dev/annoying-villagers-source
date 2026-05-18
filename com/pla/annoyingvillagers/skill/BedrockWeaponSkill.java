/*     */ package com.pla.annoyingvillagers.skill;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsEnderblaster;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsMoonless;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.skill.Skill;
/*     */ import yesman.epicfight.skill.SkillBuilder;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ import yesman.epicfight.world.entity.eventlistener.TakeDamageEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BedrockWeaponSkill
/*     */   extends WeaponInnateSkill
/*     */ {
/*  34 */   private static final UUID EVENT_UUID = UUID.fromString("64062d4e-095e-468b-a25a-12811e92fd73");
/*     */   
/*     */   public BedrockWeaponSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/*  37 */     super(builder);
/*     */   }
/*     */   
/*     */   public static void onParry(ServerPlayerPatch serverPlayerPatch) {
/*  41 */     SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.BEDROCK_WEAPON);
/*  42 */     if (skillContainer == null)
/*  43 */       return;  BedrockWeaponSkill bedrockWeaponSkill = (BedrockWeaponSkill)skillContainer.getSkill();
/*     */     
/*  45 */     if (!skillContainer.isActivated() && skillContainer.getStack() < 1) {
/*  46 */       float currentResource = skillContainer.getResource();
/*  47 */       float neededResource = skillContainer.getNeededResource();
/*  48 */       float addResource = Math.min(2.0F, neededResource);
/*  49 */       bedrockWeaponSkill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*  50 */     } else if (skillContainer.isActivated()) {
/*  51 */       bedrockWeaponSkill.setDurationSynchronize(skillContainer, skillContainer.getRemainDuration() + 40);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/*  57 */     if (!skillContainer.isActivated()) {
/*  58 */       skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AnimsEnderblaster.ENDERBLASTER_ONEHAND_RELOAD, 0.0F);
/*  59 */       super.executeOnServer(skillContainer, friendlyByteBuf);
/*  60 */       skillContainer.activate();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void executeOnClient(SkillContainer container, FriendlyByteBuf args) {
/*  65 */     super.executeOnClient(container, args);
/*  66 */     container.activate();
/*     */   }
/*     */   
/*     */   public void cancelOnClient(SkillContainer container, FriendlyByteBuf args) {
/*  70 */     super.cancelOnClient(container, args);
/*  71 */     container.deactivate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInitiate(SkillContainer container) {
/*  76 */     super.onInitiate(container);
/*  77 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID, pre -> {
/*     */           PlayerPatch<?> playerPatch = pre.getPlayerPatch();
/*     */           ServerPlayer serverPlayer = (ServerPlayer)((ServerPlayerPatch)pre.getPlayerPatch()).getOriginal();
/*     */           DamageSource damageSource = pre.getDamageSource();
/*     */           SkillContainer skillContainer = ((ServerPlayerPatch)pre.getPlayerPatch()).getSkill((Skill)this);
/*     */           if (skillContainer == null) {
/*     */             return;
/*     */           }
/*     */           if (!damageSource.m_276093_(DamageTypes.f_268515_) && !damageSource.m_276093_(DamageTypes.f_268565_) && !damageSource.m_276093_(DamageTypes.f_268468_) && !damageSource.m_276093_(DamageTypes.f_268631_) && !damageSource.m_276093_(DamageTypes.f_268671_) && skillContainer.isActivated()) {
/*     */             Entity entity = damageSource.m_7639_();
/*     */             if (entity != null) {
/*     */               pre.setCanceled(true);
/*     */               pre.setResult(AttackResult.ResultType.BLOCKED);
/*     */               playerPatch.playAnimationSynchronized((AssetAccessor)AnimsMoonless.MOONLESS_GUARD_HIT_1, 0.0F);
/*     */               entity.m_20256_(new Vec3((entity.m_20154_()).f_82479_ * -0.2D, 0.0D, (entity.m_20154_()).f_82481_ * -0.2D));
/*     */               serverPlayer.m_20256_(new Vec3((serverPlayer.m_20154_()).f_82479_ * -0.2D, 0.0D, (serverPlayer.m_20154_()).f_82481_ * -0.2D));
/*     */               serverPlayer.m_5634_(2.0F);
/*     */               Level patt4969$temp = serverPlayer.m_9236_();
/*     */               if (patt4969$temp instanceof ServerLevel) {
/*     */                 ServerLevel serverLevel = (ServerLevel)patt4969$temp;
/*     */                 EpicfightUtil.damageBlocked(damageSource, (Entity)serverPlayer, serverLevel);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void onRemoved(SkillContainer container) {
/* 106 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\BedrockWeaponSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */