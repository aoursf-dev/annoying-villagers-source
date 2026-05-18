/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.RandomSource;
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
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import se.gory_moon.player_mobs.utils.NameManager;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class ShadowHerobrineCloneEntity extends HerobrineMob {
/*     */   public ShadowHerobrineCloneEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  31 */     this((EntityType<ShadowHerobrineCloneEntity>)AnnoyingVillagersModEntities.SHADOW_HEROBRINE_CLONE.get(), level);
/*     */   }
/*     */   
/*     */   public ShadowHerobrineCloneEntity(EntityType<ShadowHerobrineCloneEntity> entitytype, Level level) {
/*  35 */     super(entitytype, level);
/*  36 */     m_274367_(0.7F);
/*  37 */     this.f_21364_ = 300;
/*  38 */     m_21557_(false);
/*  39 */     setChatName(m_5446_().getString());
/*  40 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get()));
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damagesource, float f) {
/*  44 */     if (damagesource.m_276093_(DamageTypes.f_268671_)) return false; 
/*  45 */     if (damagesource.m_276093_(DamageTypes.f_268585_)) return false; 
/*  46 */     if (damagesource.m_276093_(DamageTypes.f_268493_)) return false; 
/*  47 */     if (damagesource.m_276093_(DamageTypes.f_268722_)) return false; 
/*  48 */     if (damagesource.m_276093_(DamageTypes.f_268641_)) return false; 
/*  49 */     if (damagesource.m_276093_(DamageTypes.f_268482_)) return false; 
/*  50 */     if (!(damagesource.m_7640_() instanceof EnchantedArrowEntity) && damagesource
/*  51 */       .m_7640_() instanceof net.minecraft.world.entity.projectile.AbstractArrow && 
/*  52 */       !(damagesource.m_7640_() instanceof BlueDemonThrownTridentEntity)) return false; 
/*  53 */     return super.m_6469_(damagesource, f);
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
/*     */   public void m_6667_(@NotNull DamageSource damagesource) {
/*  77 */     super.m_6667_(damagesource);
/*  78 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  79 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_CLONE_SAY_ON_DEATH.get(), 1.0F, 1.0F);
/*  80 */       InfectedPlayerNpcEntity corpse = new InfectedPlayerNpcEntity((EntityType<? extends InfectedPlayerNpcEntity>)AnnoyingVillagersModEntities.INFECTED_PLAYER_NPC.get(), (Level)serverLevel);
/*  81 */       corpse.m_7678_(m_20185_(), m_20186_(), m_20189_(), m_146908_(), m_146909_());
/*  82 */       String killedName = getPersistentData().m_128461_("killed_name");
/*  83 */       corpse.getPersistentData().m_128359_("possessed_by", "shadow_herobrine_clone");
/*  84 */       if (killedName.isEmpty()) {
/*  85 */         killedName = String.valueOf(NameManager.INSTANCE.getRandomName());
/*     */       }
/*  87 */       corpse.setUsername(killedName);
/*  88 */       corpse.m_6593_((Component)Component.m_237113_(killedName));
/*  89 */       corpse.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*     */       
/*  91 */       m_6842_(true);
/*  92 */       m_142687_(Entity.RemovalReason.KILLED);
/*  93 */       corpse.m_8061_(EquipmentSlot.HEAD, m_6844_(EquipmentSlot.HEAD).m_41777_());
/*  94 */       corpse.m_8061_(EquipmentSlot.CHEST, m_6844_(EquipmentSlot.CHEST).m_41777_());
/*  95 */       corpse.m_8061_(EquipmentSlot.LEGS, m_6844_(EquipmentSlot.LEGS).m_41777_());
/*  96 */       corpse.m_8061_(EquipmentSlot.FEET, m_6844_(EquipmentSlot.FEET).m_41777_());
/*  97 */       serverLevel.m_7967_((Entity)corpse); }
/*     */   
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<ShadowHerobrineCloneEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 102 */     ServerLevel serverLevel = level.m_6018_();
/* 103 */     int passesDay = (int)(serverLevel.m_46467_() / 24000L);
/* 104 */     if (passesDay != 0 && passesDay % 3 != 0) {
/* 105 */       return false;
/*     */     }
/* 107 */     if (HerobrineMobData.get(serverLevel).isOccupied(serverLevel)) {
/* 108 */       return false;
/*     */     }
/* 110 */     if (!serverLevel.m_46462_()) {
/* 111 */       return false;
/*     */     }
/* 113 */     return Monster.m_219013_(entityType, level, spawnType, position, random);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 117 */     return Mob.m_21552_()
/* 118 */       .m_22268_(Attributes.f_22276_, 100.0D)
/* 119 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 120 */       .m_22268_(Attributes.f_22281_, 5.0D)
/* 121 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 122 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 123 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 124 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 125 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 126 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 127 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 128 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 129 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 130 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ShadowHerobrineCloneEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */