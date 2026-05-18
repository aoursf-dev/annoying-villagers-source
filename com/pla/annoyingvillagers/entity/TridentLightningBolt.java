/*     */ package com.pla.annoyingvillagers.entity;
/*     */ 
/*     */ import com.google.common.collect.Sets;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModDamageTypes;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModMobEffects;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.advancements.CriteriaTriggers;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.effect.MobEffect;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LightningBolt;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.gameevent.GameEvent;
/*     */ import net.minecraft.world.phys.AABB;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TridentLightningBolt
/*     */   extends LightningBolt
/*     */ {
/*  35 */   private int tridentLife = 2;
/*     */   private int tridentFlashes;
/*  37 */   private final Set<Entity> tridentHitEntities = Sets.newHashSet();
/*     */   boolean superLightning = false;
/*     */   
/*     */   public void setSuperLightning(boolean superLightning) {
/*  41 */     this.superLightning = superLightning;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   private LivingEntity owner;
/*     */   private boolean tridentVisualOnly = false;
/*     */   
/*     */   public TridentLightningBolt(EntityType<? extends LightningBolt> pEntityType, Level pLevel) {
/*  50 */     super(pEntityType, pLevel);
/*  51 */     this.f_19811_ = true;
/*  52 */     this.tridentLife = 2;
/*  53 */     this.tridentFlashes = this.f_19796_.m_188503_(3) + 1;
/*     */   }
/*     */   
/*     */   public TridentLightningBolt(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  57 */     this((EntityType<? extends LightningBolt>)AnnoyingVillagersModEntities.TRIDENT_LIGHTNING_BOLT.get(), level);
/*     */   }
/*     */   
/*     */   public void setOwner(@Nullable LivingEntity owner) {
/*  61 */     this.owner = owner;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public LivingEntity getOwner() {
/*  66 */     return this.owner;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  71 */     m_6075_();
/*     */     
/*  73 */     if (this.tridentLife == 2) {
/*  74 */       if (m_9236_().m_5776_()) {
/*  75 */         m_9236_().m_7785_(
/*  76 */             m_20185_(), m_20186_(), m_20189_(), SoundEvents.f_12090_, SoundSource.WEATHER, 10000.0F, 0.8F + this.f_19796_
/*     */ 
/*     */ 
/*     */             
/*  80 */             .m_188501_() * 0.2F, false);
/*     */ 
/*     */         
/*  83 */         m_9236_().m_7785_(
/*  84 */             m_20185_(), m_20186_(), m_20189_(), SoundEvents.f_12089_, SoundSource.WEATHER, 2.0F, 0.5F + this.f_19796_
/*     */ 
/*     */ 
/*     */             
/*  88 */             .m_188501_() * 0.2F, false);
/*     */       }
/*     */       else {
/*     */         
/*  92 */         m_146850_(GameEvent.f_157772_);
/*  93 */         LivingEntity livingEntity = this.owner; if (livingEntity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingEntity;
/*  94 */           m_20879_(serverPlayer); }
/*     */       
/*     */       } 
/*     */     }
/*     */     
/*  99 */     this.tridentLife--;
/*     */     
/* 101 */     if (this.tridentLife < 0) {
/* 102 */       if (this.tridentFlashes == 0) {
/* 103 */         Level level = m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 104 */           List<Entity> list = m_9236_().m_6249_((Entity)this, new AABB(
/*     */ 
/*     */                 
/* 107 */                 m_20185_() - 15.0D, m_20186_() - 15.0D, m_20189_() - 15.0D, 
/* 108 */                 m_20185_() + 15.0D, m_20186_() + 21.0D, m_20189_() + 15.0D), entity -> 
/*     */               
/* 110 */               (entity.m_6084_() && !this.tridentHitEntities.contains(entity)));
/*     */ 
/*     */           
/* 113 */           for (ServerPlayer serverPlayer : serverLevel.m_8795_(p -> (p.m_20270_((Entity)this) < 256.0F))) {
/* 114 */             CriteriaTriggers.f_145089_.m_153391_(serverPlayer, this, list);
/*     */           } }
/*     */ 
/*     */         
/* 118 */         m_146870_();
/* 119 */       } else if (this.tridentLife < -this.f_19796_.m_188503_(10)) {
/* 120 */         this.tridentFlashes--;
/* 121 */         this.tridentLife = 1;
/*     */       } 
/*     */     }
/*     */     
/* 125 */     if (this.tridentLife >= 0) {
/* 126 */       ServerLevel serverLevel; Level level = m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/* 127 */       else { m_9236_().m_6580_(2); return; }
/* 128 */        if (!this.tridentVisualOnly) {
/* 129 */         List<Entity> list = m_9236_().m_6249_((Entity)this, new AABB(
/*     */ 
/*     */               
/* 132 */               m_20185_() - 3.0D, m_20186_() - 3.0D, m_20189_() - 3.0D, 
/* 133 */               m_20185_() + 3.0D, m_20186_() + 9.0D, m_20189_() + 3.0D), entity -> {
/*     */               // Byte code:
/*     */               //   0: aload_1
/*     */               //   1: instanceof net/minecraft/world/entity/LivingEntity
/*     */               //   4: ifeq -> 59
/*     */               //   7: aload_1
/*     */               //   8: invokevirtual m_6084_ : ()Z
/*     */               //   11: ifeq -> 59
/*     */               //   14: aload_1
/*     */               //   15: aload_0
/*     */               //   16: getfield owner : Lnet/minecraft/world/entity/LivingEntity;
/*     */               //   19: if_acmpeq -> 59
/*     */               //   22: aload_1
/*     */               //   23: instanceof com/pla/annoyingvillagers/entity/BbqEntity
/*     */               //   26: ifne -> 59
/*     */               //   29: aload_1
/*     */               //   30: invokevirtual m_5833_ : ()Z
/*     */               //   33: ifne -> 59
/*     */               //   36: aload_1
/*     */               //   37: instanceof net/minecraft/world/entity/player/Player
/*     */               //   40: ifeq -> 55
/*     */               //   43: aload_1
/*     */               //   44: checkcast net/minecraft/world/entity/player/Player
/*     */               //   47: astore_2
/*     */               //   48: aload_2
/*     */               //   49: invokevirtual m_7500_ : ()Z
/*     */               //   52: ifne -> 59
/*     */               //   55: iconst_1
/*     */               //   56: goto -> 60
/*     */               //   59: iconst_0
/*     */               //   60: ireturn
/*     */               // Line number table:
/*     */               //   Java source line number -> byte code offset
/*     */               //   #135	-> 0
/*     */               // Local variable table:
/*     */               //   start	length	slot	name	descriptor
/*     */               //   48	7	2	player	Lnet/minecraft/world/entity/player/Player;
/*     */               //   0	61	0	this	Lcom/pla/annoyingvillagers/entity/TridentLightningBolt;
/*     */               //   0	61	1	entity	Lnet/minecraft/world/entity/Entity;
/*     */             });
/*     */ 
/*     */         
/* 138 */         if (this.superLightning) {
/*     */           
/* 140 */           DamageSource explosionDamage = AnnoyingVillagersModDamageTypes.Sources.impactExplosion(serverLevel.m_9598_(), (Entity)this);
/*     */           
/* 142 */           serverLevel.m_254877_((Entity)this, explosionDamage, null, 
/*     */ 
/*     */ 
/*     */               
/* 146 */               m_20185_(), 
/* 147 */               m_20186_(), 
/* 148 */               m_20189_(), serverLevel.f_46441_
/* 149 */               .m_188501_() * 5.0F + 5.0F, false, 
/*     */               
/* 151 */               ((Boolean)AnnoyingVillagersConfig.TRIDENT_FESTIVAL_CAN_BREAK_BLOCK.get()).booleanValue() ? Level.ExplosionInteraction.BLOCK : Level.ExplosionInteraction.NONE);
/*     */         } 
/*     */ 
/*     */         
/* 155 */         for (Entity entity : list) {
/* 156 */           if (!ForgeEventFactory.onEntityStruckByLightning(entity, this)) {
/* 157 */             if (entity instanceof LivingEntity) { LivingEntity livingEntity1 = (LivingEntity)entity;
/* 158 */               if (this.superLightning) {
/* 159 */                 livingEntity1.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ELECTRIFY
/* 160 */                       .get(), 100, 2));
/*     */               
/*     */               }
/*     */               else {
/*     */                 
/* 165 */                 livingEntity1.m_7292_(new MobEffectInstance((MobEffect)AnnoyingVillagersModMobEffects.ELECTRIFY
/* 166 */                       .get(), 60, 1));
/*     */               }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 173 */             if (this.superLightning) {
/* 174 */               entity.m_6469_(m_9236_().m_269111_().m_269104_((Entity)this, (Entity)this.owner), 50.0F); continue;
/*     */             } 
/* 176 */             entity.m_6469_(m_9236_().m_269111_().m_269104_((Entity)this, (Entity)this.owner), 5.0F);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 181 */         this.tridentHitEntities.addAll(list);
/*     */         
/* 183 */         LivingEntity livingEntity = this.owner; if (livingEntity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)livingEntity;
/* 184 */           CriteriaTriggers.f_10554_.m_21721_(serverPlayer, list); }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\TridentLightningBolt.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */