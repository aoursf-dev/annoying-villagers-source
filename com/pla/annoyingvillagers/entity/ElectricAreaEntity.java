/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModMobEffects;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModParticleTypes;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.protocol.Packet;
/*     */ import net.minecraft.network.protocol.game.ClientGamePacketListener;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.network.NetworkHooks;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class ElectricAreaEntity
/*     */   extends Entity {
/*     */   private static final String TAG_OWNER_UUID = "OwnerUUID";
/*     */   private static final String TAG_HALF_SIZE = "HalfSize";
/*     */   private static final String TAG_DURATION_TICKS = "DurationTicks";
/*     */   private static final String TAG_DAMAGE_AMOUNT = "DamageAmount";
/*     */   private static final String TAG_DAMAGE_INTERVAL = "DamageInterval";
/*     */   @Nullable
/*     */   private UUID ownerUUID;
/*  35 */   private double halfSize = 1.5D;
/*  36 */   private int durationTicks = 100;
/*  37 */   private float damageAmount = 4.0F;
/*  38 */   private int damageInterval = 10;
/*     */   
/*     */   public ElectricAreaEntity(EntityType<? extends ElectricAreaEntity> type, Level level) {
/*  41 */     super(type, level);
/*  42 */     this.f_19794_ = true;
/*  43 */     m_20242_(true);
/*     */   }
/*     */   
/*     */   public ElectricAreaEntity(Level level, LivingEntity owner, Vec3 pos, double halfSize, int durationTicks, float damageAmount, int damageInterval) {
/*  47 */     this((EntityType<? extends ElectricAreaEntity>)AnnoyingVillagersModEntities.ELECTRIC_AREA.get(), level);
/*  48 */     this.ownerUUID = owner.m_20148_();
/*  49 */     this.halfSize = halfSize;
/*  50 */     this.durationTicks = durationTicks;
/*  51 */     this.damageAmount = damageAmount;
/*  52 */     this.damageInterval = Math.max(1, damageInterval);
/*  53 */     m_6034_(pos.f_82479_, pos.f_82480_, pos.f_82481_);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public LivingEntity getOwnerLiving() {
/*  58 */     Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level; if (this.ownerUUID != null) {
/*     */ 
/*     */ 
/*     */         
/*  62 */         Entity entity = serverLevel.m_8791_(this.ownerUUID);
/*  63 */         LivingEntity living = (LivingEntity)entity; return (entity instanceof LivingEntity) ? living : null;
/*     */       }  }
/*     */     
/*     */     return null;
/*     */   }
/*     */   protected void m_8097_() {}
/*     */   
/*     */   public void m_8119_() {
/*     */     ServerLevel serverLevel;
/*  72 */     super.m_8119_();
/*     */     
/*  74 */     Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else
/*     */     { return; }
/*     */     
/*  78 */     if (this.f_19797_ % this.damageInterval == 0 || this.f_19797_ == 1) {
/*  79 */       damageEntitiesInZone();
/*     */     }
/*     */     
/*  82 */     if (this.f_19797_ % 5 == 0) {
/*  83 */       serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.ELECTRIC_SPARK
/*  84 */           .get(), 
/*  85 */           m_20185_(), 
/*  86 */           m_20186_() + 0.2D, 
/*  87 */           m_20189_(), 4, this.halfSize * 0.6D, 0.25D, this.halfSize * 0.6D, 0.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     if (this.f_19797_ >= this.durationTicks) {
/*  97 */       m_146870_();
/*     */     }
/*     */   }
/*     */   
/*     */   private void damageEntitiesInZone() {
/* 102 */     LivingEntity owner = getOwnerLiving();
/* 103 */     for (LivingEntity target : m_9236_().m_6443_(LivingEntity.class, 
/* 104 */         makeDamageBox(), living -> isValidTarget(owner, living))) {
/*     */       
/* 106 */       target.m_20334_(0.0D, 0.0D, 0.0D);
/* 107 */       target.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ELECTRIFY.get(), 12, 2));
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isValidTarget(@Nullable LivingEntity owner, LivingEntity target) {
/* 112 */     if (!target.m_6084_() || target.m_5833_()) {
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     if (owner == null) {
/* 117 */       return true;
/*     */     }
/*     */     
/* 120 */     if (target == owner) {
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     if (target instanceof Player) { Player player = (Player)target; if (player.m_7500_()) {
/* 125 */         return false;
/*     */       } }
/*     */     
/* 128 */     if (owner instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)owner; if (blueDemonEntity
/* 129 */         .getBbqEntity() != null && target == blueDemonEntity
/* 130 */         .getBbqEntity()) {
/* 131 */         return false;
/*     */       } }
/*     */     
/* 134 */     return !owner.m_7307_((Entity)target);
/*     */   }
/*     */   
/*     */   private AABB makeDamageBox() {
/* 138 */     return new AABB(
/* 139 */         m_20185_() - this.halfSize, 
/* 140 */         m_20186_() - 1.0D, 
/* 141 */         m_20189_() - this.halfSize, 
/* 142 */         m_20185_() + this.halfSize, 
/* 143 */         m_20186_() + 2.5D, 
/* 144 */         m_20189_() + this.halfSize);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7378_(@NotNull CompoundTag tag) {
/* 150 */     if (tag.m_128403_("OwnerUUID")) {
/* 151 */       this.ownerUUID = tag.m_128342_("OwnerUUID");
/*     */     }
/*     */     
/* 154 */     this.halfSize = tag.m_128459_("HalfSize");
/* 155 */     this.durationTicks = tag.m_128451_("DurationTicks");
/* 156 */     this.damageAmount = tag.m_128457_("DamageAmount");
/* 157 */     this.damageInterval = Math.max(1, tag.m_128451_("DamageInterval"));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_7380_(@NotNull CompoundTag tag) {
/* 162 */     if (this.ownerUUID != null) {
/* 163 */       tag.m_128362_("OwnerUUID", this.ownerUUID);
/*     */     }
/*     */     
/* 166 */     tag.m_128347_("HalfSize", this.halfSize);
/* 167 */     tag.m_128405_("DurationTicks", this.durationTicks);
/* 168 */     tag.m_128350_("DamageAmount", this.damageAmount);
/* 169 */     tag.m_128405_("DamageInterval", this.damageInterval);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource source, float amount) {
/* 174 */     return false;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/* 179 */     return NetworkHooks.getEntitySpawningPacket(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\ElectricAreaEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */