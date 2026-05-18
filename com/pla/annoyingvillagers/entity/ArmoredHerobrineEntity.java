/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.InteractionHand;
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
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*     */ 
/*     */ public class ArmoredHerobrineEntity extends HerobrineMob {
/*     */   public ArmoredHerobrineEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  33 */     this((EntityType<ArmoredHerobrineEntity>)AnnoyingVillagersModEntities.ARMORED_HEROBRINE.get(), level);
/*     */   }
/*     */   
/*     */   public ArmoredHerobrineEntity(EntityType<ArmoredHerobrineEntity> entitytype, Level level) {
/*  37 */     super(entitytype, level);
/*  38 */     m_274367_(4.0F);
/*  39 */     this.f_21364_ = 60;
/*  40 */     m_21557_(false);
/*  41 */     m_6593_(m_5446_());
/*  42 */     m_20340_(true);
/*  43 */     m_21530_();
/*  44 */     m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)AnnoyingVillagersModItems.HEROBRINE_OBSIDIAN_DIAMOND_HELMET.get()));
/*  45 */     m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)AnnoyingVillagersModItems.HEROBRINE_OBSIDIAN_DIAMOND_CHESTPLATE.get()));
/*  46 */     m_21008_(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get()));
/*  47 */     setChatName(m_5446_().getString());
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
/*     */   public void rollItem() {
/*  65 */     super.rollItem();
/*  66 */     ItemStack offHand = m_21206_();
/*  67 */     if (offHand.m_41720_() instanceof com.pla.annoyingvillagers.item.ShadowObsidianSwordItem) {
/*  68 */       m_21008_(InteractionHand.OFF_HAND, ItemStack.f_41583_);
/*     */     } else {
/*  70 */       m_21008_(InteractionHand.OFF_HAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get()));
/*     */     } 
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getAttackVoiceSound() {
/*  76 */     if ((new Random()).nextFloat() <= 0.2F) {
/*  77 */       return (SoundEvent)AnnoyingVillagersModSounds.ARMORED_HEROBRINE_SAY.get();
/*     */     }
/*  79 */     return (SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_CLONE_SAY.get();
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public SoundEvent getHurtVoiceSound() {
/*  85 */     return (SoundEvent)AnnoyingVillagersModSounds.HEROBRINE_CLONE_SAY_ON_HURT.get();
/*     */   }
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource damagesource) {
/*  89 */     super.m_6667_(damagesource);
/*  90 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  91 */       m_5496_((SoundEvent)AnnoyingVillagersModSounds.ARMORED_HEROBRINE_SAY_ON_DEATH.get(), 1.0F, 1.0F);
/*  92 */       InfectedTheMostMoistBurrit0Entity infectedTheMostMoistBurrit0Entity = new InfectedTheMostMoistBurrit0Entity((EntityType<InfectedTheMostMoistBurrit0Entity>)AnnoyingVillagersModEntities.INFECTED_THEMOSTMOISTBURRIT0.get(), (Level)serverLevel);
/*     */       
/*  94 */       infectedTheMostMoistBurrit0Entity.m_7678_(m_20185_(), m_20186_(), m_20189_(), serverLevel.m_213780_().m_188501_() * 360.0F, 0.0F);
/*  95 */       infectedTheMostMoistBurrit0Entity.m_6518_((ServerLevelAccessor)serverLevel, serverLevel.m_6436_(infectedTheMostMoistBurrit0Entity.m_20183_()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
/*  96 */       m_6842_(true);
/*  97 */       m_142687_(Entity.RemovalReason.KILLED);
/*  98 */       serverLevel.m_7967_((Entity)infectedTheMostMoistBurrit0Entity); }
/*     */   
/*     */   }
/*     */   
/*     */   public static boolean canSpawn(EntityType<ArmoredHerobrineEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
/* 103 */     ServerLevel serverLevel = level.m_6018_();
/* 104 */     int passesDay = (int)(serverLevel.m_46467_() / 24000L);
/* 105 */     if (passesDay != 0 && passesDay % 3 != 0) {
/* 106 */       return false;
/*     */     }
/* 108 */     if (HerobrineMobData.get(serverLevel).isOccupied(serverLevel)) {
/* 109 */       return false;
/*     */     }
/* 111 */     if (!serverLevel.m_46462_()) {
/* 112 */       return false;
/*     */     }
/* 114 */     return Monster.m_219013_(entityType, level, spawnType, position, random);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 118 */     return Mob.m_21552_()
/* 119 */       .m_22268_(Attributes.f_22276_, 100.0D)
/* 120 */       .m_22268_(Attributes.f_22279_, 0.45D)
/* 121 */       .m_22268_(Attributes.f_22281_, 5.0D)
/* 122 */       .m_22268_(Attributes.f_22277_, 64.0D)
/* 123 */       .m_22268_(Attributes.f_22284_, 10.0D)
/* 124 */       .m_22268_(Attributes.f_22285_, 20.0D)
/* 125 */       .m_22268_(Attributes.f_22278_, 1.0D)
/* 126 */       .m_22268_((Attribute)EpicFightAttributes.IMPACT.get(), 4.0D)
/* 127 */       .m_22268_((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), 10.0D)
/* 128 */       .m_22268_((Attribute)EpicFightAttributes.STUN_ARMOR.get(), 20.0D)
/* 129 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STRIKES.get(), 100.0D)
/* 130 */       .m_22268_((Attribute)EpicFightAttributes.MAX_STAMINA.get(), 60.0D)
/* 131 */       .m_22268_((Attribute)EpicFightAttributes.STAMINA_REGEN.get(), 1.5D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ArmoredHerobrineEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */