/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.MobSpawnType;
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
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class GlaiveHerobrineEntity extends HerobrineMob {
/*     */   public GlaiveHerobrineEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  30 */     this((EntityType<GlaiveHerobrineEntity>)AnnoyingVillagersModEntities.GLAIVE_HEROBRINE.get(), level);
/*     */   }
/*     */   
/*     */   public GlaiveHerobrineEntity(EntityType<GlaiveHerobrineEntity> entitytype, Level level) {
/*  34 */     super(entitytype, level);
/*  35 */     m_274367_(2.9F);
/*  36 */     this.f_21364_ = 300;
/*  37 */     m_21557_(false);
/*  38 */     m_6593_(m_5446_());
/*  39 */     m_20340_(true);
/*  40 */     m_21530_();
/*  41 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.ENDER_GLAIVE.get()));
/*  42 */     setChatName(m_5446_().getString());
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  47 */     return (SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY.get();
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damagesource, float f) {
/*  51 */     if (damagesource.m_276093_(DamageTypes.f_268671_)) return false; 
/*  52 */     if (damagesource.m_276093_(DamageTypes.f_268585_)) return false; 
/*  53 */     if (damagesource.m_276093_(DamageTypes.f_268493_)) return false; 
/*  54 */     if (damagesource.m_276093_(DamageTypes.f_268722_)) return false; 
/*  55 */     if (damagesource.m_276093_(DamageTypes.f_268641_)) return false; 
/*  56 */     if (damagesource.m_276093_(DamageTypes.f_268482_)) return false; 
/*  57 */     if (!(damagesource.m_7640_() instanceof EnchantedArrowEntity) && damagesource
/*  58 */       .m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow && 
/*  59 */       !(damagesource.m_7640_() instanceof BlueDemonThrownTridentEntity)) return false; 
/*  60 */     return super.m_6469_(damagesource, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  65 */     super.m_8119_();
/*  66 */     if (!m_9236_().m_5776_() && 
/*  67 */       this.f_19797_ % 20 == 0 && 
/*  68 */       getState() > 0) {
/*  69 */       HerobrineUtil.spawnEliteEffect(m_9236_(), m_20185_(), m_20186_(), m_20189_(), (Entity)this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damageSource) {
/*  76 */     super.m_6667_(damageSource);
/*  77 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  78 */       EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = new EliteHerobrineKnockedEntity((EntityType<EliteHerobrineKnockedEntity>)AnnoyingVillagersModEntities.ELITE_HEROBRINE_KNOCKED.get(), (Level)serverLevel);
/*     */       
/*  80 */       eliteHerobrineKnockedEntity.m_7678_(m_20185_(), m_20186_(), m_20189_(), serverLevel.m_213780_().m_188501_() * 360.0F, 0.0F);
/*  81 */       eliteHerobrineKnockedEntity.getPersistentData().m_128359_("FromElite", "EnderGlaive");
/*  82 */       eliteHerobrineKnockedEntity.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(eliteHerobrineKnockedEntity.m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*  83 */       m_142687_(Entity.RemovalReason.KILLED);
/*  84 */       serverLevel.m_7967_((Entity)eliteHerobrineKnockedEntity);
/*     */       
/*  86 */       if (getGregUUID() != null) {
/*  87 */         Entity entity = serverLevel.m_8791_(getGregUUID());
/*  88 */         if (entity instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)entity; if (entity.m_6084_())
/*  89 */             herobrineGregEntity.requestProtect(eliteHerobrineKnockedEntity.m_20148_(), eliteHerobrineKnockedEntity);  }
/*     */       
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/*  96 */     return Mob.m_21552_()
/*  97 */       .m_22268_(Attributes.f_22276_, 250.0D)
/*  98 */       .m_22268_(Attributes.f_22279_, 0.45D)
/*  99 */       .m_22268_(Attributes.f_22281_, 10.0D)
/* 100 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 101 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 102 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 103 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 104 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 105 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 106 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 107 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 108 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 109 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\GlaiveHerobrineEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */