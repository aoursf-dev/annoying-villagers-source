/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.HerobrineCommon;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsMoonless;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class HerobrineChrisEntity extends HerobrineMob {
/*     */   public HerobrineChrisEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  43 */     this((EntityType<HerobrineChrisEntity>)AnnoyingVillagersModEntities.HEROBRINE_CHRIS.get(), level);
/*     */   }
/*     */   
/*     */   public HerobrineChrisEntity(EntityType<HerobrineChrisEntity> entitytype, Level level) {
/*  47 */     super(entitytype, level);
/*  48 */     m_274367_(3.0F);
/*  49 */     this.f_21364_ = 50;
/*  50 */     m_21557_(false);
/*  51 */     m_21530_();
/*  52 */     setChatName(m_5446_().getString());
/*  53 */     m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.OBSIDIAN_WEAPON.get()));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMinVoiceCooldown() {
/*  58 */     return 60;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxVoiceCooldown() {
/*  63 */     return 200;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  68 */     return (SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_CLONE_SAY.get();
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getHurtVoiceSound() {
/*  73 */     return (SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_CLONE_SAY_ON_HURT.get();
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damagesource, float f) {
/*  77 */     if (damagesource.m_276093_(DamageTypes.f_268671_)) return false; 
/*  78 */     if (damagesource.m_276093_(DamageTypes.f_268585_)) return false; 
/*  79 */     if (damagesource.m_276093_(DamageTypes.f_268493_)) return false; 
/*  80 */     if (damagesource.m_276093_(DamageTypes.f_268722_)) return false; 
/*  81 */     if (damagesource.m_276093_(DamageTypes.f_268641_)) return false; 
/*  82 */     if (damagesource.m_276093_(DamageTypes.f_268482_)) return false; 
/*  83 */     if (!(damagesource.m_7640_() instanceof EnchantedArrowEntity) && damagesource
/*  84 */       .m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow && 
/*  85 */       !(damagesource.m_7640_() instanceof BlueDemonThrownTridentEntity)) return false; 
/*  86 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (HerobrineCommon.canPlaySecondFormAnimation((MobPatch)Objects.requireNonNull(getLivingEntityPatch()))) {
/*  87 */         AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(getLivingEntityPatch().getAnimator().getPlayerFor(null))).getRealAnimation();
/*  88 */         if (!EpicfightUtil.isLongHitAnimation(dynamicAnimation, getLivingEntityPatch()) && 
/*  89 */           m_9236_() instanceof ServerLevel && dynamicAnimation == Animations.EMPTY_ANIMATION) {
/*  90 */           ((LivingEntityPatch)Objects.<LivingEntityPatch>requireNonNull(getLivingEntityPatch())).playAnimationSynchronized((AssetAccessor)AnimsMoonless.MOONLESS_GUARD_HIT_1, 0.0F);
/*  91 */           HerobrineCommon.playSecondFormAnimation((MobPatch)Objects.requireNonNull(getLivingEntityPatch()));
/*  92 */           m_5634_(4.0F);
/*  93 */           EpicfightUtil.damageBlocked(damagesource, (Entity)this, serverLevel);
/*  94 */           return false;
/*     */         } 
/*     */       }  }
/*  97 */      return super.m_6469_(damagesource, f);
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damagesource) {
/* 101 */     super.m_6667_(damagesource);
/* 102 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 103 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_CLONE_SAY_ON_DEATH.get(), 1.0F, 1.0F);
/* 104 */       serverLevel.m_7654_().m_6846_().m_240416_((Component)Component.m_237115_("subtitles.herobrine_clone_die"), false);
/* 105 */       InfectedChrisEntity corpse = new InfectedChrisEntity((EntityType<InfectedChrisEntity>)AnnoyingVillagersModEntities.INJECTED_CHRIS.get(), (Level)serverLevel);
/* 106 */       corpse.m_7678_(m_20185_(), m_20186_(), m_20189_(), m_146908_(), m_146909_());
/* 107 */       corpse.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*     */       
/* 109 */       m_6842_(true);
/* 110 */       m_142687_(Entity.RemovalReason.KILLED);
/* 111 */       serverLevel.m_7967_((Entity)corpse); }
/*     */   
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<HerobrineChrisEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 116 */     ServerLevel serverLevel = level.m_6018_();
/* 117 */     int passesDay = (int)(serverLevel.m_46467_() / 24000L);
/* 118 */     if (passesDay != 0 && passesDay % 3 != 0) {
/* 119 */       return false;
/*     */     }
/* 121 */     if (HerobrineMobData.get(serverLevel).isOccupied(serverLevel)) {
/* 122 */       return false;
/*     */     }
/* 124 */     if (!serverLevel.m_46462_()) {
/* 125 */       return false;
/*     */     }
/* 127 */     return Monster.m_219013_(entityType, level, spawnType, position, random);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 131 */     return Mob.m_21552_()
/* 132 */       .m_22268_(Attributes.f_22276_, 100.0D)
/* 133 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 134 */       .m_22268_(Attributes.f_22281_, 1.0D)
/* 135 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 136 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 137 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 138 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 139 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 140 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 141 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 142 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 143 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 144 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\HerobrineChrisEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */