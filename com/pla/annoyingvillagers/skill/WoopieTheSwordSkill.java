/*     */ package com.pla.annoyingvillagers.skill;
/*     */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.network.ClientboundMuteExplosionAtPos;
/*     */ import com.pla.annoyingvillagers.network.ClientboundWoopieSwordWindFx;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Position;
/*     */ import net.minecraft.network.FriendlyByteBuf;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.PacketDistributor;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.math.Vec3f;
/*     */ import yesman.epicfight.gameasset.Armatures;
/*     */ import yesman.epicfight.model.armature.HumanoidArmature;
/*     */ import yesman.epicfight.skill.SkillBuilder;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.entity.eventlistener.DealDamageEvent;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ 
/*     */ public class WoopieTheSwordSkill extends WeaponInnateSkill {
/*  34 */   private static final UUID EVENT_UUID = UUID.fromString("5a6ceb12-eacb-49c6-8030-37942b192e1d");
/*     */   public WoopieTheSwordSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
/*  36 */     super(builder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf friendlyByteBuf) {
/*  41 */     skillContainer.getExecutor().playAnimationSynchronized((AssetAccessor)AnimsHerrscher.HERRSCHER_AUTO_2, 0.0F);
/*     */     
/*  43 */     final Player player = (Player)skillContainer.getExecutor().getOriginal();
/*  44 */     ItemStack itemStack = player.m_21205_();
/*  45 */     if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.WoopieTheSwordItem) {
/*  46 */       new DelayedTask(6)
/*     */         {
/*     */           public void run() {
/*  49 */             Vec3 windPos = EpicfightUtil.getJointWithTranslation((Entity)player, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED
/*     */ 
/*     */                 
/*  52 */                 .get()).toolR, 5.3F, 0.5D);
/*     */ 
/*     */ 
/*     */             
/*  56 */             if (windPos != null) {
/*  57 */               BlockPos mutePos = BlockPos.m_274446_((Position)windPos);
/*  58 */               AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/*  59 */                   .with(() -> player), new ClientboundMuteExplosionAtPos(mutePos, 4));
/*     */ 
/*     */               
/*  62 */               player.m_9236_().m_255391_((Entity)player, windPos.f_82479_, windPos.f_82480_, windPos.f_82481_, 2.0F, false, Level.ExplosionInteraction.NONE);
/*     */               
/*  64 */               AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/*  65 */                   .with(() -> player), new ClientboundWoopieSwordWindFx(windPos));
/*     */             } 
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onInitiate(SkillContainer container) {
/*  76 */     super.onInitiate(container);
/*  77 */     container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_DAMAGE, EVENT_UUID, event -> { if (((ServerPlayerPatch)event.getPlayerPatch()).isLogicalClient()) return;  PlayerPatch<?> playerPatch = event.getPlayerPatch(); AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(playerPatch.getAnimator().getPlayerFor(null))).getRealAnimation(); if (dynamicAnimation == null) return;  if (dynamicAnimation == AVAnimations.RUSH_SWORD && container.getStack() < 1) { WoopieTheSwordSkill woopieTheSwordSkill = (WoopieTheSwordSkill)container.getSkill(); float currentResource = container.getResource(); float neededResource = container.getNeededResource(); woopieTheSwordSkill.setConsumptionSynchronize(container, currentResource + neededResource); }  }10);
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
/*     */   public void onRemoved(SkillContainer container) {
/*  99 */     container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_DAMAGE, EVENT_UUID);
/* 100 */     super.onRemoved(container);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\WoopieTheSwordSkill.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */