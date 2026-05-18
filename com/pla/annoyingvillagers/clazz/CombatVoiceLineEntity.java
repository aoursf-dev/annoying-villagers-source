/*     */ package com.pla.annoyingvillagers.clazz;
/*     */ 
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.level.Level;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ public interface CombatVoiceLineEntity {
/*     */   int getVoiceCooldown();
/*     */   
/*     */   default int getMinVoiceCooldown() {
/*  18 */     return 300;
/*     */   }
/*     */   void setVoiceCooldown(int paramInt);
/*     */   default int getMaxVoiceCooldown() {
/*  22 */     return 600;
/*     */   }
/*     */   
/*     */   default void tickVoiceCooldown() {
/*  26 */     if (getVoiceCooldown() > 0) {
/*  27 */       setVoiceCooldown(getVoiceCooldown() - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   default void resetVoiceCooldown(Mob self) {
/*  32 */     int min = Math.min(getMinVoiceCooldown(), getMaxVoiceCooldown());
/*  33 */     int max = Math.max(getMinVoiceCooldown(), getMaxVoiceCooldown());
/*  34 */     setVoiceCooldown(Mth.m_216271_(self.m_217043_(), min, max));
/*     */   }
/*     */   
/*     */   default boolean hasValidVoiceTarget(Mob self) {
/*  38 */     LivingEntity target = self.m_5448_();
/*  39 */     return (target != null && target.m_6084_());
/*     */   }
/*     */   
/*     */   default boolean canPlayVoiceLine(Mob self) {
/*  43 */     return (!(self.m_9236_()).f_46443_ && self
/*  44 */       .m_6084_() && 
/*  45 */       getVoiceCooldown() <= 0 && 
/*  46 */       hasValidVoiceTarget(self));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   default SoundEvent getHurtVoiceSound() {
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   default SoundEvent getAttackVoiceSound() {
/*  56 */     return null;
/*     */   }
/*     */   
/*     */   default boolean canSayHurtSound(Mob self, DamageSource source) {
/*  60 */     return canPlayVoiceLine(self);
/*     */   }
/*     */   
/*     */   default boolean canSayAttackSound(Mob self, Entity target) {
/*  64 */     return canPlayVoiceLine(self);
/*     */   }
/*     */   default void sayHurtSound(Mob self, DamageSource source) {
/*     */     ServerLevel serverLevel;
/*  68 */     Level level = self.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else
/*     */     { return; }
/*     */     
/*  72 */     SoundEvent sound = getHurtVoiceSound();
/*  73 */     if (sound == null) {
/*     */       return;
/*     */     }
/*     */     
/*  77 */     if (!canSayHurtSound(self, source)) {
/*     */       return;
/*     */     }
/*     */     
/*  81 */     serverLevel.m_6263_(null, self
/*     */         
/*  83 */         .m_20185_(), self
/*  84 */         .m_20186_(), self
/*  85 */         .m_20189_(), sound, SoundSource.HOSTILE, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     resetVoiceCooldown(self);
/*     */   }
/*     */   default void sayAttackSound(Mob self, Entity target) {
/*     */     ServerLevel serverLevel;
/*  96 */     Level level = self.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else
/*     */     { return; }
/*     */     
/* 100 */     SoundEvent sound = getAttackVoiceSound();
/* 101 */     if (sound == null) {
/*     */       return;
/*     */     }
/*     */     
/* 105 */     if (!canSayAttackSound(self, target)) {
/*     */       return;
/*     */     }
/*     */     
/* 109 */     serverLevel.m_6263_(null, self
/*     */         
/* 111 */         .m_20185_(), self
/* 112 */         .m_20186_(), self
/* 113 */         .m_20189_(), sound, SoundSource.HOSTILE, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     resetVoiceCooldown(self);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\clazz\CombatVoiceLineEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */