/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends DelayedTask
/*     */ {
/*     */   null(int waitTicks) {
/*  51 */     super(waitTicks);
/*     */   } private void summonFirework(Entity entity) {
/*  53 */     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
/*     */       try {
/*  55 */         entity.m_20194_().m_129892_().m_82094_().execute("summon firework_rocket ~ ~10 ~ {LifeTime:10,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:3,Colors:[0],Flicker:1}]}},display:{Name:\"Black Creeper Firework\"}}}", entity
/*     */             
/*  57 */             .m_20203_().m_81324_().m_81325_(4));
/*     */       }
/*  59 */       catch (CommandSyntaxException commandSyntaxException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  64 */     playSound(levelaccessor, d0, d1, d2, "minecraft:entity.firework_rocket.launch");
/*     */   }
/*     */   
/*     */   private void playSound(LevelAccessor level, double x, double y, double z, String soundId) {
/*  68 */     if (level instanceof Level) { Level lvl = (Level)level;
/*  69 */       String[] parts = soundId.split(":", 2);
/*  70 */       String namespace = parts[0];
/*  71 */       String path = parts[1];
/*  72 */       SoundEvent sound = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, path));
/*  73 */       if (!lvl.m_5776_()) {
/*  74 */         lvl.m_5594_(null, new BlockPos((int)x, (int)y, (int)z), sound, SoundSource.NEUTRAL, 1.0F, 2.0F);
/*     */       } else {
/*  76 */         lvl.m_7785_(x, y, z, sound, SoundSource.NEUTRAL, 1.0F, 2.0F, false);
/*     */       }  }
/*     */   
/*     */   }
/*     */   
/*     */   private void broadcast(String speaker, String message) {
/*  82 */     if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  83 */       levelaccessor.m_7654_().m_6846_().m_240416_(
/*  84 */           (Component)Component.m_237113_("<" + speaker + "> " + message), false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void summon(Entity entity, String type, double dx, double dy, double dz) {
/*  91 */     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
/*     */       try {
/*  93 */         entity.m_20194_().m_129892_().m_82094_().execute(
/*  94 */             String.format("summon annoyingvillagers:%s ~%.1f ~%.1f ~%.1f", new Object[] { type, Double.valueOf(dx), Double.valueOf(dy), Double.valueOf(dz) }), entity
/*  95 */             .m_20203_().m_81324_().m_81325_(4));
/*     */       }
/*  97 */       catch (CommandSyntaxException commandSyntaxException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 104 */     if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity;
/* 105 */       if (living.m_21023_(MobEffects.f_19596_)) {
/* 106 */         broadcast("Villager", "Help me!");
/*     */         
/*     */         return;
/*     */       }  }
/*     */     
/* 111 */     if (entity instanceof LivingEntity) { LivingEntity living = (LivingEntity)entity; if (!living.m_9236_().m_5776_()) {
/* 112 */         living.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 60, 1, false, false));
/*     */       } }
/*     */     
/* 115 */     if (entity.m_6084_() && levelaccessor instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)levelaccessor;
/* 116 */       serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123815_, d0, d1, d2, 40, 0.0D, 3.0D, 0.0D, 1.0D);
/*     */       
/* 118 */       summonFirework(entity);
/*     */       
/* 120 */       new DelayedTask(50)
/*     */         {
/*     */           public void run() {
/* 123 */             VillagersAssistanceEvent.null.this.playSound(levelaccessor, d0, d1, d2, "minecraft:entity.experience_orb.pickup");
/*     */             
/* 125 */             if (Math.random() <= 0.6D) {
/* 126 */               VillagersAssistanceEvent.null.this.broadcast("Villager Scout", "What the matter?");
/* 127 */               VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 0.0D, 5.0D, 10.0D);
/* 128 */               VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 10.0D, 5.0D, -5.0D);
/* 129 */               VillagersAssistanceEvent.null.this.summon(entity, "blue_villager_general", -10.0D, 5.0D, 20.0D);
/* 130 */             } else if (Math.random() <= 0.1D) {
/* 131 */               VillagersAssistanceEvent.null.this.broadcast("Villager Blue General", "What the matter?");
/* 132 */               VillagersAssistanceEvent.null.this.summon(entity, "blue_villager_general", 10.0D, 5.0D, -20.0D);
/* 133 */               VillagersAssistanceEvent.null.this.summon(entity, "blue_villager_general", -5.0D, 5.0D, 20.0D);
/* 134 */               VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 0.0D, 5.0D, 10.0D);
/* 135 */             } else if (Math.random() <= 0.1D) {
/* 136 */               VillagersAssistanceEvent.null.this.broadcast("Villager Purple General", "What the matter?");
/* 137 */               VillagersAssistanceEvent.null.this.summon(entity, "purple_villager_general", -5.0D, 5.0D, 20.0D);
/* 138 */               VillagersAssistanceEvent.null.this.summon(entity, "purple_villager_general", 10.0D, 5.0D, -20.0D);
/* 139 */             } else if (Math.random() <= 0.1D) {
/* 140 */               VillagersAssistanceEvent.null.this.broadcast("Villager Red General", "What the matter?");
/* 141 */               VillagersAssistanceEvent.null.this.summon(entity, "red_villager_general", 10.0D, 5.0D, 20.0D);
/* 142 */               VillagersAssistanceEvent.null.this.summon(entity, "red_villager_general", 5.0D, 5.0D, -20.0D);
/* 143 */               VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 0.0D, 5.0D, -10.0D);
/*     */             } else {
/* 145 */               VillagersAssistanceEvent.null.this.broadcast("Villager Green General", "What the matter?");
/* 146 */               VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 0.0D, 5.0D, -10.0D);
/* 147 */               VillagersAssistanceEvent.null.this.summon(entity, "green_villager_general", 10.0D, 5.0D, 20.0D);
/* 148 */               VillagersAssistanceEvent.null.this.summon(entity, "green_villager_general", -5.0D, 5.0D, 20.0D);
/*     */             } 
/*     */           }
/*     */         }; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\VillagersAssistanceEvent$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */