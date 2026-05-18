/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class AegisHerobrineEntity extends HerobrineMob {
/*     */   public AegisHerobrineEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  29 */     this((EntityType<AegisHerobrineEntity>)AnnoyingVillagersModEntities.AEGIS_HEROBRINE.get(), level);
/*     */   }
/*     */   
/*     */   public AegisHerobrineEntity(EntityType<AegisHerobrineEntity> entitytype, Level level) {
/*  33 */     super(entitytype, level);
/*  34 */     m_274367_(2.5F);
/*  35 */     this.f_21364_ = 80;
/*  36 */     m_21557_(false);
/*  37 */     m_6593_(m_5446_());
/*  38 */     m_20340_(true);
/*  39 */     m_21530_();
/*  40 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_AEGIS.get()));
/*  41 */     setChatName(m_5446_().getString());
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  46 */     return (SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  51 */     super.m_8119_();
/*  52 */     if (!m_9236_().m_5776_()) {
/*  53 */       if (this.f_19797_ == 5 && getPersistentData().m_128471_("init_animation")) {
/*  54 */         LivingEntityPatch<?> livingentitypatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)this, LivingEntityPatch.class);
/*  55 */         if (livingentitypatch != null) {
/*  56 */           livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.SHIELD_MAINHAND, 0.0F);
/*     */         }
/*     */       } 
/*  59 */       if (this.f_19797_ % 20 == 0) {
/*  60 */         ItemStack itemStack = m_21205_();
/*  61 */         if (getState() > 0) {
/*  62 */           HerobrineUtil.spawnEliteEffect(m_9236_(), m_20185_(), m_20186_(), m_20189_(), (Entity)this);
/*  63 */           if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderAegisItem && itemStack
/*  64 */             .m_41783_() != null && !itemStack.m_41783_().m_128471_("SecondForm")) {
/*  65 */             itemStack.m_41783_().m_128379_("SecondForm", true);
/*     */           }
/*     */         }
/*  68 */         else if (itemStack.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderAegisItem && itemStack
/*  69 */           .m_41783_() != null && itemStack.m_41783_().m_128441_("SecondForm")) {
/*  70 */           itemStack.m_41783_().m_128473_("SecondForm");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/*  78 */     if (damageSource.m_276093_(DamageTypes.f_268671_)) return false; 
/*  79 */     if (damageSource.m_276093_(DamageTypes.f_268585_)) return false; 
/*  80 */     if (damageSource.m_276093_(DamageTypes.f_268493_)) return false; 
/*  81 */     if (damageSource.m_276093_(DamageTypes.f_268722_)) return false; 
/*  82 */     if (damageSource.m_276093_(DamageTypes.f_268641_)) return false; 
/*  83 */     if (damageSource.m_276093_(DamageTypes.f_268482_)) return false; 
/*  84 */     if (!(damageSource.m_7640_() instanceof EnchantedArrowEntity) && damageSource
/*  85 */       .m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow && 
/*  86 */       !(damageSource.m_7640_() instanceof BlueDemonThrownTridentEntity)) return false; 
/*  87 */     return super.m_6469_(damageSource, f);
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damageSource) {
/*  91 */     super.m_6667_(damageSource);
/*  92 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  93 */       EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = new EliteHerobrineKnockedEntity((EntityType<EliteHerobrineKnockedEntity>)AnnoyingVillagersModEntities.ELITE_HEROBRINE_KNOCKED.get(), (Level)serverLevel);
/*     */       
/*  95 */       eliteHerobrineKnockedEntity.m_7678_(m_20185_(), m_20186_(), m_20189_(), serverLevel.m_213780_().m_188501_() * 360.0F, 0.0F);
/*  96 */       eliteHerobrineKnockedEntity.getPersistentData().m_128359_("FromElite", "EnderAegis");
/*  97 */       eliteHerobrineKnockedEntity.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(eliteHerobrineKnockedEntity.m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*  98 */       m_142687_(Entity.RemovalReason.KILLED);
/*  99 */       serverLevel.m_7967_((Entity)eliteHerobrineKnockedEntity);
/*     */       
/* 101 */       if (getGregUUID() != null) {
/* 102 */         Entity entity = serverLevel.m_8791_(getGregUUID());
/* 103 */         if (entity instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)entity; if (entity.m_6084_())
/* 104 */             herobrineGregEntity.requestProtect(eliteHerobrineKnockedEntity.m_20148_(), eliteHerobrineKnockedEntity);  }
/*     */       
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 111 */     return Mob.m_21552_()
/* 112 */       .m_22268_(Attributes.f_22276_, 250.0D)
/* 113 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 114 */       .m_22268_(Attributes.f_22281_, 10.0D)
/* 115 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 116 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 117 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 118 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 119 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 120 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 121 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 122 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 123 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 124 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\AegisHerobrineEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */