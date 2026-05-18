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
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class SledgehammerHerobrineEntity extends HerobrineMob {
/*     */   public SledgehammerHerobrineEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  32 */     this((EntityType<SledgehammerHerobrineEntity>)AnnoyingVillagersModEntities.SLEDGEHAMMER_HEROBRINE.get(), level);
/*     */   }
/*     */   
/*     */   public SledgehammerHerobrineEntity(EntityType<SledgehammerHerobrineEntity> entitytype, Level level) {
/*  36 */     super(entitytype, level);
/*  37 */     m_274367_(2.5F);
/*  38 */     this.f_21364_ = 80;
/*  39 */     m_21557_(false);
/*  40 */     m_6593_(m_5446_());
/*  41 */     m_20340_(true);
/*  42 */     m_21530_();
/*  43 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.OBSIDIAN_SLEDGEHAMMER.get()));
/*  44 */     setChatName(m_5446_().getString());
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  49 */     return (SoundEvent)AnnoyingVillagersModSounds.ELITE_HEROBRINE_SAY.get();
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damagesource, float f) {
/*  53 */     if (damagesource.m_276093_(DamageTypes.f_268671_)) return false; 
/*  54 */     if (damagesource.m_276093_(DamageTypes.f_268585_)) return false; 
/*  55 */     if (damagesource.m_276093_(DamageTypes.f_268493_)) return false; 
/*  56 */     if (damagesource.m_276093_(DamageTypes.f_268722_)) return false; 
/*  57 */     if (damagesource.m_276093_(DamageTypes.f_268641_)) return false; 
/*  58 */     if (damagesource.m_276093_(DamageTypes.f_268482_)) return false; 
/*  59 */     if (!(damagesource.m_7640_() instanceof EnchantedArrowEntity) && damagesource
/*  60 */       .m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow && 
/*  61 */       !(damagesource.m_7640_() instanceof BlueDemonThrownTridentEntity)) return false; 
/*  62 */     return super.m_6469_(damagesource, f);
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damageSource) {
/*  66 */     super.m_6667_(damageSource);
/*  67 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  68 */       EliteHerobrineKnockedEntity eliteHerobrineKnockedEntity = new EliteHerobrineKnockedEntity((EntityType<EliteHerobrineKnockedEntity>)AnnoyingVillagersModEntities.ELITE_HEROBRINE_KNOCKED.get(), (Level)serverLevel);
/*     */       
/*  70 */       eliteHerobrineKnockedEntity.m_7678_(m_20185_(), m_20186_(), m_20189_(), serverLevel.m_213780_().m_188501_() * 360.0F, 0.0F);
/*  71 */       eliteHerobrineKnockedEntity.getPersistentData().m_128359_("FromElite", "ObsidianSledgehammer");
/*  72 */       eliteHerobrineKnockedEntity.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(eliteHerobrineKnockedEntity.m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*  73 */       m_142687_(Entity.RemovalReason.KILLED);
/*  74 */       serverLevel.m_7967_((Entity)eliteHerobrineKnockedEntity);
/*     */       
/*  76 */       if (getGregUUID() != null) {
/*  77 */         Entity entity = serverLevel.m_8791_(getGregUUID());
/*  78 */         if (entity instanceof HerobrineGregEntity) { HerobrineGregEntity herobrineGregEntity = (HerobrineGregEntity)entity; if (entity.m_6084_()) {
/*  79 */             herobrineGregEntity.requestProtect(eliteHerobrineKnockedEntity.m_20148_(), eliteHerobrineKnockedEntity);
/*     */           } }
/*     */       
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   public void m_8119_() {
/*  87 */     super.m_8119_();
/*  88 */     if (!m_9236_().m_5776_() && 
/*  89 */       this.f_19797_ % 20 == 0 && 
/*  90 */       getState() > 0) {
/*  91 */       HerobrineUtil.spawnEliteEffect(m_9236_(), m_20185_(), m_20186_(), m_20189_(), (Entity)this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/*  98 */     return Mob.m_21552_()
/*  99 */       .m_22268_(Attributes.f_22276_, 250.0D)
/* 100 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 101 */       .m_22268_(Attributes.f_22281_, 10.0D)
/* 102 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 103 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 104 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 105 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 106 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 107 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 108 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 109 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 110 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 111 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\SledgehammerHerobrineEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */