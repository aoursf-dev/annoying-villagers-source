/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*     */ import net.minecraft.world.entity.projectile.ItemSupplier;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.phys.EntityHitResult;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.api.utils.LevelUtil;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ @OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
/*     */ public class EnderAegisProjectile extends AbstractArrow implements ItemSupplier {
/*     */   public EnderAegisProjectile(PlayMessages.SpawnEntity spawnentity, Level level) {
/*  40 */     super((EntityType)AnnoyingVillagersModEntities.ENDER_AEGIS_PROJECTILE.get(), level);
/*     */   }
/*     */   
/*     */   public EnderAegisProjectile(EntityType<? extends EnderAegisProjectile> entitytype, Level level) {
/*  44 */     super(entitytype, level);
/*     */   }
/*     */   
/*     */   public EnderAegisProjectile(EntityType<? extends EnderAegisProjectile> entitytype, double d0, double d1, double d2, Level level) {
/*  48 */     super(entitytype, d0, d1, d2, level);
/*     */   }
/*     */   
/*     */   public EnderAegisProjectile(EntityType<? extends EnderAegisProjectile> entitytype, LivingEntity livingentity, Level level) {
/*  52 */     super(entitytype, livingentity, level);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  56 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   @OnlyIn(Dist.CLIENT)
/*     */   @NotNull
/*     */   public ItemStack m_7846_() {
/*  61 */     return new ItemStack((ItemLike)Blocks.f_50016_);
/*     */   }
/*     */   @NotNull
/*     */   public ItemStack m_7941_() {
/*  65 */     return ItemStack.f_41583_;
/*     */   }
/*     */   
/*     */   public void m_8119_() {
/*  69 */     super.m_8119_();
/*  70 */     if (this.f_36703_) {
/*  71 */       m_146870_();
/*     */     }
/*  73 */     if (!m_9236_().m_5776_()) {
/*  74 */       HerobrineUtil.spawnEliteEffect(m_9236_(), m_20185_(), m_20186_(), m_20189_(), (Entity)this);
/*  75 */       doGroundSlamAtSelf();
/*     */     } 
/*     */   }
/*     */   private void doGroundSlamAtSelf() {
/*     */     ServerLevel serverLevel;
/*  80 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else { return; }
/*  82 */      BlockPos floor = BlockPos.m_274561_((m_20182_()).f_82479_, (m_20182_()).f_82480_ - 1.0D, (m_20182_()).f_82481_);
/*  83 */     Vec3 center = new Vec3(m_20185_(), floor.m_123342_(), m_20189_());
/*  84 */     Entity src = (m_19749_() != null) ? m_19749_() : (Entity)this;
/*  85 */     if (src instanceof LivingEntity) { LivingEntity livingSrc = (LivingEntity)src;
/*  86 */       LevelUtil.circleSlamFracture(livingSrc, (Level)serverLevel, center, 3.5D, true, true, true); }
/*     */   
/*     */   }
/*     */   
/*     */   public static EnderAegisProjectile shoot(Level level, LivingEntity livingentity, Random random, float f, double d0, int i) {
/*  91 */     EnderAegisProjectile enderAegisProjectile = new EnderAegisProjectile((EntityType<? extends EnderAegisProjectile>)AnnoyingVillagersModEntities.ENDER_AEGIS_PROJECTILE.get(), livingentity, level);
/*     */     
/*  93 */     enderAegisProjectile.m_6686_((livingentity.m_20252_(1.0F)).f_82479_, (livingentity.m_20252_(1.0F)).f_82480_, (livingentity.m_20252_(1.0F)).f_82481_, f * 2.0F, 0.0F);
/*  94 */     enderAegisProjectile.m_20225_(true);
/*  95 */     enderAegisProjectile.m_36762_(false);
/*  96 */     enderAegisProjectile.m_36781_(d0);
/*  97 */     enderAegisProjectile.m_36735_(i);
/*  98 */     level.m_7967_((Entity)enderAegisProjectile);
/*  99 */     level.m_6263_(null, livingentity.m_20185_(), livingentity.m_20186_(), livingentity.m_20189_(), Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.arrow.shoot"))), SoundSource.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.5F + 1.0F) + f / 2.0F);
/* 100 */     return enderAegisProjectile;
/*     */   }
/*     */   
/*     */   public static EnderAegisProjectile shoot(LivingEntity livingentity, LivingEntity livingentity1) {
/* 104 */     EnderAegisProjectile enderAegisProjectile = new EnderAegisProjectile((EntityType<? extends EnderAegisProjectile>)AnnoyingVillagersModEntities.ENDER_AEGIS_PROJECTILE.get(), livingentity, livingentity.m_9236_());
/* 105 */     double d0 = livingentity1.m_20185_() - livingentity.m_20185_();
/* 106 */     double d1 = livingentity1.m_20186_() + livingentity1.m_20192_() - 1.1D;
/* 107 */     double d2 = livingentity1.m_20189_() - livingentity.m_20189_();
/*     */     
/* 109 */     enderAegisProjectile.m_6686_(d0, d1 - enderAegisProjectile.m_20186_() + Math.hypot(d0, d2) * 0.20000000298023224D, d2, 2.0F, 12.0F);
/* 110 */     enderAegisProjectile.m_20225_(true);
/* 111 */     enderAegisProjectile.m_36781_(18.0D);
/* 112 */     enderAegisProjectile.m_36735_(7);
/* 113 */     enderAegisProjectile.m_36762_(false);
/* 114 */     livingentity.m_9236_().m_7967_((Entity)enderAegisProjectile);
/* 115 */     livingentity.m_9236_().m_6263_(null, livingentity.m_20185_(), livingentity.m_20186_(), livingentity.m_20189_(), Objects.<SoundEvent>requireNonNull((SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.arrow.shoot"))), SoundSource.PLAYERS, 1.0F, 1.0F / ((new Random()).nextFloat() * 0.5F + 1.0F));
/* 116 */     return enderAegisProjectile;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean m_5603_(@NotNull Entity entity) {
/* 121 */     Entity owner = m_19749_();
/* 122 */     if (entity == owner) return false; 
/* 123 */     if (owner instanceof LivingEntity) { LivingEntity livingOwner = (LivingEntity)owner; if (entity instanceof LivingEntity) { LivingEntity livingTarget = (LivingEntity)entity; if (livingOwner.m_7307_((Entity)livingTarget)) return false;  }  }
/* 124 */      return super.m_5603_(entity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_5790_(EntityHitResult pResult) {
/* 129 */     Entity vicTim = pResult.m_82443_();
/* 130 */     Entity owner = m_19749_();
/* 131 */     if (vicTim == owner)
/* 132 */       return;  Level level = vicTim.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 133 */       serverLevel.m_8767_((ParticleOptions)EpicFightParticles.HIT_BLUNT.get(), vicTim
/* 134 */           .m_20185_(), vicTim.m_20186_() + 1.5D, vicTim.m_20189_() + 0.8D, 1, 0.1D, 0.1D, 0.1D, 1.0D);
/*     */ 
/*     */ 
/*     */       
/* 138 */       serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.SPARK.get(), vicTim
/* 139 */           .m_20185_(), vicTim.m_20186_() + 1.5D, vicTim.m_20189_() + 0.8D, 5, 0.0D, 0.0D, 0.0D, 0.1D);
/*     */ 
/*     */ 
/*     */       
/* 143 */       LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(vicTim, LivingEntityPatch.class);
/* 144 */       if (livingEntityPatch != null) {
/* 145 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.LONGEST_HIT, 0.0F);
/*     */       } }
/*     */     
/* 148 */     super.m_5790_(pResult);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\EnderAegisProjectile.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */