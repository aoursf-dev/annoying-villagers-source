/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*     */ import net.minecraft.world.entity.projectile.ItemSupplier;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.EntityHitResult;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
/*     */ public class EnchantedEnderPearlEntity
/*     */   extends AbstractArrow
/*     */   implements ItemSupplier {
/*     */   public EnchantedEnderPearlEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  43 */     super((EntityType)AnnoyingVillagersModEntities.ENCHANTED_ENDER_PEARL_PROJECTILE.get(), level);
/*     */   }
/*     */   
/*     */   public EnchantedEnderPearlEntity(EntityType<? extends EnchantedEnderPearlEntity> entitytype, Level level) {
/*  47 */     super(entitytype, level);
/*     */   }
/*     */   
/*     */   public EnchantedEnderPearlEntity(EntityType<? extends EnchantedEnderPearlEntity> entitytype, double d0, double d1, double d2, Level level) {
/*  51 */     super(entitytype, d0, d1, d2, level);
/*     */   }
/*     */   
/*     */   public EnchantedEnderPearlEntity(EntityType<? extends EnchantedEnderPearlEntity> entitytype, LivingEntity livingentity, Level level) {
/*  55 */     super(entitytype, livingentity, level);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  59 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   @NotNull
/*     */   public ItemStack m_7846_() {
/*  64 */     return new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ENDER_PEARL.get());
/*     */   }
/*     */   @NotNull
/*     */   public ItemStack m_7941_() {
/*  68 */     return ItemStack.f_41583_;
/*     */   }
/*     */   
/*     */   protected void m_7761_(@NotNull LivingEntity livingentity) {
/*  72 */     super.m_7761_(livingentity);
/*  73 */     livingentity.m_21317_(livingentity.m_21234_() - 1);
/*     */   }
/*     */   
/*     */   public void m_5790_(@NotNull EntityHitResult entityHitResult) {
/*  77 */     super.m_5790_(entityHitResult);
/*  78 */     if (!m_9236_().m_5776_()) {
/*  79 */       m_9236_().m_5594_(null, new BlockPos(entityHitResult.m_82443_().m_146903_(), entityHitResult.m_82443_().m_146904_(), entityHitResult.m_82443_().m_146907_()), SoundEvents.f_11852_, SoundSource.NEUTRAL, 1.0F, 1.0F);
/*     */     } else {
/*  81 */       m_9236_().m_7785_(entityHitResult.m_82443_().m_146903_(), entityHitResult.m_82443_().m_146904_(), entityHitResult.m_82443_().m_146907_(), SoundEvents.f_11852_, SoundSource.NEUTRAL, 1.0F, 1.0F, false);
/*     */     } 
/*     */     
/*  84 */     if (m_19749_() != null) {
/*  85 */       m_19749_().m_6021_(entityHitResult.m_82443_().m_146903_(), entityHitResult.m_82443_().m_146904_() + 1.0D, entityHitResult.m_82443_().m_146907_());
/*  86 */       Entity entity = m_19749_(); if (entity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)entity;
/*  87 */         serverPlayer.f_8906_.m_9774_(entityHitResult.m_82443_().m_146903_(), entityHitResult.m_82443_().m_146904_() + 1.0D, entityHitResult.m_82443_().m_146907_(), serverPlayer.m_146908_(), serverPlayer.m_146909_()); }
/*     */ 
/*     */       
/*  90 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*  91 */         serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123760_, entityHitResult.m_82443_().m_146903_(), entityHitResult.m_82443_().m_146904_(), entityHitResult.m_82443_().m_146907_(), 50, 4.0D, 4.0D, 4.0D, 1.0D);
/*  92 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ENDER
/*  93 */             .get(), 
/*  94 */             m_19749_().m_20185_(), m_19749_().m_20186_() + 1.0D, m_19749_().m_20189_(), 16, 0.0D, 0.0D, 0.0D, 0.5D); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8060_(@NotNull BlockHitResult blockHitResult) {
/* 101 */     super.m_8060_(blockHitResult);
/* 102 */     if (!m_9236_().m_5776_()) {
/* 103 */       m_9236_().m_5594_(null, new BlockPos(blockHitResult.m_82425_().m_123341_(), blockHitResult.m_82425_().m_123342_(), blockHitResult.m_82425_().m_123343_()), SoundEvents.f_11852_, SoundSource.NEUTRAL, 1.0F, 1.0F);
/*     */     } else {
/* 105 */       m_9236_().m_7785_(blockHitResult.m_82425_().m_123341_(), blockHitResult.m_82425_().m_123342_(), blockHitResult.m_82425_().m_123343_(), SoundEvents.f_11852_, SoundSource.NEUTRAL, 1.0F, 1.0F, false);
/*     */     } 
/*     */     
/* 108 */     if (m_19749_() != null) {
/* 109 */       m_19749_().m_6021_(blockHitResult.m_82425_().m_123341_(), blockHitResult.m_82425_().m_123342_() + 1.0D, blockHitResult.m_82425_().m_123343_());
/* 110 */       Entity entity = m_19749_(); if (entity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)entity;
/* 111 */         serverPlayer.f_8906_.m_9774_(blockHitResult.m_82425_().m_123341_(), blockHitResult.m_82425_().m_123342_() + 1.0D, blockHitResult.m_82425_().m_123343_(), serverPlayer.m_146908_(), serverPlayer.m_146909_()); }
/*     */ 
/*     */       
/* 114 */       Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 115 */         serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123760_, blockHitResult.m_82425_().m_123341_(), blockHitResult.m_82425_().m_123342_(), blockHitResult.m_82425_().m_123343_(), 50, 4.0D, 4.0D, 4.0D, 1.0D);
/* 116 */         serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ENDER
/* 117 */             .get(), 
/* 118 */             m_19749_().m_20185_(), m_19749_().m_20186_() + 1.0D, m_19749_().m_20189_(), 16, 0.0D, 0.0D, 0.0D, 0.5D); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   protected SoundEvent m_7239_() {
/* 126 */     return SoundEvents.f_11852_;
/*     */   }
/*     */   
/*     */   public void m_8119_() {
/* 130 */     super.m_8119_();
/* 131 */     if (m_9236_().m_5776_()) {
/* 132 */       m_9236_().m_7106_((ParticleOptions)AnnoyingVillagersModParticleTypes.ENDER.get(), m_20185_(), m_20186_(), m_20189_(), 0.0D, 0.0D, 0.0D);
/*     */     }
/* 134 */     if (this.f_36703_) {
/* 135 */       m_146870_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static EnchantedEnderPearlEntity shoot(Level level, LivingEntity livingentity, RandomSource random, float f, double d0, int i) {
/* 141 */     EnchantedEnderPearlEntity enchantedEnderPearl = new EnchantedEnderPearlEntity((EntityType<? extends EnchantedEnderPearlEntity>)AnnoyingVillagersModEntities.ENCHANTED_ENDER_PEARL_PROJECTILE.get(), livingentity, level);
/*     */     
/* 143 */     enchantedEnderPearl.m_6686_((livingentity.m_20252_(1.0F)).f_82479_, (livingentity.m_20252_(1.0F)).f_82480_, (livingentity.m_20252_(1.0F)).f_82481_, f * 2.0F, 0.0F);
/* 144 */     enchantedEnderPearl.m_20225_(true);
/* 145 */     enchantedEnderPearl.m_36762_(false);
/* 146 */     enchantedEnderPearl.m_36781_(d0);
/* 147 */     enchantedEnderPearl.m_36735_(i);
/* 148 */     level.m_7967_((Entity)enchantedEnderPearl);
/* 149 */     level.m_6263_((Player)null, livingentity.m_20185_(), livingentity.m_20186_(), livingentity.m_20189_(), Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "throw"))), SoundSource.PLAYERS, 1.0F, 1.0F / (random.m_188501_() * 0.5F + 1.0F) + f / 2.0F);
/* 150 */     return enchantedEnderPearl;
/*     */   }
/*     */   
/*     */   public static EnchantedEnderPearlEntity shoot(LivingEntity livingentity, LivingEntity livingentity1) {
/* 154 */     EnchantedEnderPearlEntity enchantedEnderPearl = new EnchantedEnderPearlEntity((EntityType<? extends EnchantedEnderPearlEntity>)AnnoyingVillagersModEntities.ENCHANTED_ENDER_PEARL_PROJECTILE.get(), livingentity, livingentity.m_9236_());
/* 155 */     double d0 = livingentity1.m_20185_() - livingentity.m_20185_();
/* 156 */     double d1 = livingentity1.m_20186_() + livingentity1.m_20192_() - 1.1D;
/* 157 */     double d2 = livingentity1.m_20189_() - livingentity.m_20189_();
/*     */     
/* 159 */     enchantedEnderPearl.m_6686_(d0, d1 - enchantedEnderPearl.m_20186_() + Math.hypot(d0, d2) * 0.20000000298023224D, d2, 2.6F, 12.0F);
/* 160 */     enchantedEnderPearl.m_20225_(true);
/* 161 */     enchantedEnderPearl.m_36781_(0.0D);
/* 162 */     enchantedEnderPearl.m_36735_(0);
/* 163 */     enchantedEnderPearl.m_36762_(false);
/* 164 */     livingentity.m_9236_().m_7967_((Entity)enchantedEnderPearl);
/* 165 */     livingentity.m_9236_().m_6263_((Player)null, livingentity.m_20185_(), livingentity.m_20186_(), livingentity.m_20189_(), Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "throw"))), SoundSource.PLAYERS, 1.0F, 1.0F / ((new Random()).nextFloat() * 0.5F + 1.0F));
/* 166 */     return enchantedEnderPearl;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\EnchantedEnderPearlEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */