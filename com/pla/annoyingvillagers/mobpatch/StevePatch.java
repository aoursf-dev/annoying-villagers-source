/*     */ package com.pla.annoyingvillagers.mobpatch;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.mojang.datafixers.util.Pair;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.SteveCraftingTable;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.SteveFist;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.SteveLegendarySword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.SteveSword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.SteveTrapdoor;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.SteveWoodenDoor;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.SteveWoopieSword;
/*     */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.util.MobPatchCommon;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.CEHumanoidPatch;
/*     */ import net.shelmarow.combat_evolution.ai.iml.CustomExecuteEntity;
/*     */ import net.shelmarow.combat_evolution.execution.ExecutionTypeManager;
/*     */ import yesman.epicfight.api.animation.Animator;
/*     */ import yesman.epicfight.api.animation.LivingMotion;
/*     */ import yesman.epicfight.api.animation.LivingMotions;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.AttackResult;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.capabilities.item.Style;
/*     */ import yesman.epicfight.world.damagesource.EpicFightDamageSource;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class StevePatch extends CEHumanoidPatch implements CustomExecuteEntity {
/*     */   public StevePatch() {
/*  50 */     super(Factions.NEUTRAL);
/*     */   }
/*     */   
/*     */   public void initAnimator(Animator animator) {
/*  54 */     super.initAnimator(animator);
/*  55 */     animator.addLivingAnimation((LivingMotion)LivingMotions.BLOCK, (AssetAccessor)Animations.BIPED_BLOCK);
/*  56 */     animator.addLivingAnimation((LivingMotion)LivingMotions.IDLE, (AssetAccessor)Animations.BIPED_IDLE);
/*  57 */     animator.addLivingAnimation((LivingMotion)LivingMotions.WALK, (AssetAccessor)Animations.BIPED_WALK);
/*  58 */     animator.addLivingAnimation((LivingMotion)LivingMotions.RUN, (AssetAccessor)Animations.BIPED_RUN);
/*  59 */     animator.addLivingAnimation((LivingMotion)LivingMotions.CHASE, (AssetAccessor)Animations.BIPED_RUN);
/*  60 */     animator.addLivingAnimation((LivingMotion)LivingMotions.DEATH, (AssetAccessor)Animations.BIPED_DEATH);
/*     */   }
/*     */   
/*     */   protected void setWeaponMotions() {
/*  64 */     this.weaponLivingMotions
/*  65 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  66 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  67 */           Set.of(
/*  68 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  69 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  70 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  71 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  72 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  74 */     this.weaponAttackMotions
/*  75 */       .put(CapabilityItem.WeaponCategories.NOT_WEAPON, 
/*  76 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, SteveFist.FIST));
/*     */     
/*  78 */     this.weaponLivingMotions
/*  79 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  80 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*  81 */           Set.of(
/*  82 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  83 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/*  84 */             Pair.of(LivingMotions.RUN, Animations.BIPED_RUN), 
/*  85 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_RUN), 
/*  86 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */     
/*  88 */     this.weaponAttackMotions
/*  89 */       .put(CapabilityItem.WeaponCategories.FIST, 
/*  90 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, SteveFist.FIST));
/*     */     
/*  92 */     this.weaponLivingMotions
/*  93 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/*  94 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/*     */           
/*  96 */           Set.of(
/*  97 */             Pair.of(LivingMotions.BLOCK, AVAnimations.SHIELD_OFFHAND), 
/*  98 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_IDLE), 
/*  99 */             Pair.of(LivingMotions.WALK, Animations.BIPED_WALK), 
/* 100 */             Pair.of(LivingMotions.RUN, AVAnimations.BIPED_RUN_ESWORD), 
/* 101 */             Pair.of(LivingMotions.CHASE, AVAnimations.BIPED_RUN_ESWORD), 
/* 102 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH)), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */           
/* 105 */           Set.of(
/* 106 */             Pair.of(LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD), 
/* 107 */             Pair.of(LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON), 
/* 108 */             Pair.of(LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON), 
/* 109 */             Pair.of(LivingMotions.RUN, AVAnimations.RUN_HOLD), 
/* 110 */             Pair.of(LivingMotions.CHASE, Animations.BIPED_HOLD_DUAL_WEAPON), 
/* 111 */             Pair.of(LivingMotions.DEATH, Animations.BIPED_DEATH))));
/*     */ 
/*     */     
/* 114 */     this.weaponAttackMotions
/* 115 */       .put(CapabilityItem.WeaponCategories.SWORD, 
/* 116 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, SteveSword.AV_SWORD, CapabilityItem.Styles.TWO_HAND, SteveSword.AV_DUAL_SWORD));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.SWORD, 
/* 122 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 123 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 128 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.AXE, 
/* 134 */         ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, 
/* 135 */           List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3), CapabilityItem.Styles.TWO_HAND, 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 140 */           List.of(Animations.SWORD_DUAL_GUARD_HIT)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     this.guardHitMotions.put(CapabilityItem.WeaponCategories.GREATSWORD, 
/* 146 */         ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, 
/* 147 */           List.of(Animations.GREATSWORD_GUARD_HIT)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CECombatBehaviors.Builder<MobPatch<?>> getCustomWeaponMotionBuilder() {
/* 156 */     CapabilityItem mainHandCap = getHoldingItemCapability(InteractionHand.MAIN_HAND);
/* 157 */     Style style = mainHandCap.getStyle((LivingEntityPatch)this);
/*     */     
/* 159 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.WOODEN_DOOR.get()).m_7968_()) && 
/* 160 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 161 */       return SteveWoodenDoor.WOODEN_DOOR;
/*     */     }
/*     */ 
/*     */     
/* 165 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.CRAFTING_TABLE.get()).m_7968_()) && 
/* 166 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 167 */       return SteveCraftingTable.CRAFTING_TABLE;
/*     */     }
/*     */ 
/*     */     
/* 171 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.LADDER.get()).m_7968_()) && 
/* 172 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 173 */       return SteveLadder.LADDER;
/*     */     }
/*     */ 
/*     */     
/* 177 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.TRAPDOOR.get()).m_7968_()) && 
/* 178 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 179 */       return SteveTrapdoor.TRAPDOOR;
/*     */     }
/*     */ 
/*     */     
/* 183 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get()).m_7968_()) && 
/* 184 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 185 */       return SteveWoopieSword.WOOPIE_THE_SWORD;
/*     */     }
/*     */ 
/*     */     
/* 189 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.LEGENDARY_SWORD.get()).m_7968_()) && 
/* 190 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 191 */       return SteveLegendarySword.LEGENDARY_SWORD;
/*     */     }
/*     */ 
/*     */     
/* 195 */     CECombatBehaviors.Builder<MobPatch<?>> customOverride = MobPatchCommon.overideBowMotionBuilderForNpc(mainHandCap, mainHandCap.getStyle((LivingEntityPatch)this));
/* 196 */     return (customOverride != null) ? customOverride : super.getCustomWeaponMotionBuilder();
/*     */   }
/*     */   
/*     */   public void playGuardBreakSound() {
/* 200 */     playSound((SoundEvent)EpicFightSounds.NEUTRALIZE_MOBS.get(), 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public AttackResult attack(EpicFightDamageSource epicFightDamageSource, Entity entity, InteractionHand interactionhand) {
/* 204 */     AttackResult attackresult = super.attack(epicFightDamageSource, entity, interactionhand);
/*     */     
/* 206 */     if (attackresult.resultType != AttackResult.ResultType.SUCCESS || entity.m_6084_());
/*     */ 
/*     */ 
/*     */     
/* 210 */     return attackresult;
/*     */   }
/*     */   
/*     */   public void tick(LivingEvent.LivingTickEvent livingTickEvent) {
/* 214 */     super.tick(livingTickEvent);
/*     */   }
/*     */   
/*     */   public void onDeath(LivingDeathEvent livingDeathEvent) {
/* 218 */     super.onDeath(livingDeathEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   public void playGuardHitAnimation(DamageSource damageSource, boolean canCounter) {
/* 223 */     if (ModList.get().isLoaded("efn")) {
/* 224 */       Entity entity = getOriginal(); if (entity instanceof AVNpc) { AVNpc avNpc = (AVNpc)entity; if (avNpc.getLivingEntityPatch() != null && (avNpc
/* 225 */           .m_21205_().m_41720_().equals(Items.f_42388_) || avNpc
/* 226 */           .m_21205_().m_41720_().equals(AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get())))
/* 227 */         { EpicFightNightFall.playEfnGuardHit(avNpc.getLivingEntityPatch(), avNpc.getEfnGuardHitState(), damageSource);
/* 228 */           avNpc.postPlayEfnGuardHit(); return; }  }
/*     */     
/* 230 */     }  super.playGuardHitAnimation(damageSource, canCounter);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dealStaminaDamage(DamageSource damageSource, float amount) {
/* 236 */     if (ModList.get().isLoaded("efn") && EpicFightNightFall.isPlayingEfnGuardHit(this)) {
/* 237 */       return false;
/*     */     }
/* 239 */     return super.dealStaminaDamage(damageSource, amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuardHit(DamageSource damageSource) {
/* 245 */     super.onGuardHit(damageSource);
/* 246 */     Level level = getOriginal().m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 247 */       ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, getOriginal(), damageSource.m_7639_()); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void playGuardHitSound() {
/* 253 */     if (ModList.get().isLoaded("efn")) {
/* 254 */       Entity entity = getOriginal(); if (entity instanceof AVNpc) { AVNpc avNpc = (AVNpc)entity; if (avNpc
/* 255 */           .m_21205_().m_41720_().equals(Items.f_42388_) || avNpc
/* 256 */           .m_21205_().m_41720_().equals(AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get()))
/*     */           return;  } 
/* 258 */     }  super.playGuardHitSound();
/*     */   }
/*     */ 
/*     */   
/*     */   public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stuntype) {
/* 263 */     switch (stuntype) { case LONG: case SHORT: case HOLD: case KNOCKDOWN: case NEUTRALIZE: return 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 268 */           (getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.GREATSWORD) ? 
/* 269 */           Animations.GREATSWORD_GUARD_BREAK : Animations.BIPED_COMMON_NEUTRALIZED;
/*     */       case FALL:
/* 271 */        }  return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeExecuted(LivingEntityPatch<?> livingEntityPatch) {
/* 277 */     return ((Boolean)AnnoyingVillagersConfig.CAN_EXECUTE_AV_MOB.get()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUseCustomType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 282 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ExecutionTypeManager.Type getExecutionType(LivingEntityPatch<?> livingEntityPatch, ExecutionTypeManager.Type type) {
/* 287 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mobpatch\StevePatch.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */