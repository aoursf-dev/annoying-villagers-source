/*     */ package com.pla.annoyingvillagers.entity.goal;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.clazz.IdleAnimation;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.level.Level;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class PlayIdleAnimationGoal extends Goal {
/*     */   private final Mob mob;
/*     */   private final int minDurationTicks;
/*     */   private int ticksLeft;
/*     */   
/*     */   private static List<String> keys(String prefix) {
/*  29 */     List<String> list = new ArrayList<>(20);
/*  30 */     for (int i = 1; i <= 20; i++) {
/*  31 */       list.add(prefix + "." + prefix);
/*     */     }
/*  33 */     return List.copyOf(list);
/*     */   }
/*     */   
/*  36 */   private static final Map<IdleAnimation, List<String>> idleMessageKeys = Map.ofEntries(new Map.Entry[] { 
/*  37 */         Map.entry(IdleAnimation.LAY, keys("idle.annoyingvillagers.lay")), 
/*  38 */         Map.entry(IdleAnimation.SLEEP, keys("idle.annoyingvillagers.sleep")), 
/*  39 */         Map.entry(IdleAnimation.SIT, keys("idle.annoyingvillagers.sit")), 
/*  40 */         Map.entry(IdleAnimation.FUN_SIT, keys("idle.annoyingvillagers.fun_sit")), 
/*  41 */         Map.entry(IdleAnimation.SLIGHT, keys("idle.annoyingvillagers.slight")), 
/*  42 */         Map.entry(IdleAnimation.PUSH_UP, keys("idle.annoyingvillagers.push_up")), 
/*  43 */         Map.entry(IdleAnimation.LAY_RELAX_EMOTE, keys("idle.annoyingvillagers.lay_relax_emote")), 
/*  44 */         Map.entry(IdleAnimation.ONE_ARM_LAY_EMOTE, keys("idle.annoyingvillagers.one_arm_lay_emote")), 
/*  45 */         Map.entry(IdleAnimation.SALUTE_LEFT_HAND_EMOTE, keys("idle.annoyingvillagers.salute_left_hand_emote")), 
/*  46 */         Map.entry(IdleAnimation.SIT_NO_WEAPON_EMOTE, keys("idle.annoyingvillagers.sit_no_weapon_emote")), 
/*  47 */         Map.entry(IdleAnimation.SORROW_EMOTE, keys("idle.annoyingvillagers.sorrow_emote")), 
/*  48 */         Map.entry(IdleAnimation.SURRENDER_EMOTE, keys("idle.annoyingvillagers.surrender_emote")), 
/*  49 */         Map.entry(IdleAnimation.ATTENTION_EMOTE, keys("idle.annoyingvillagers.attention_emote")), 
/*  50 */         Map.entry(IdleAnimation.FLAPPING_EMOTE, keys("idle.annoyingvillagers.flapping_emote")), 
/*  51 */         Map.entry(IdleAnimation.FUN_JUMP_EMOTE, keys("idle.annoyingvillagers.fun_jump_emote")), 
/*  52 */         Map.entry(IdleAnimation.JUMP_EMOTE, keys("idle.annoyingvillagers.jump_emote")), 
/*  53 */         Map.entry(IdleAnimation.PRONE_EMOTE, keys("idle.annoyingvillagers.prone_emote")), 
/*  54 */         Map.entry(IdleAnimation.SALUTE_EMOTE, keys("idle.annoyingvillagers.salute_emote")) });
/*     */ 
/*     */   
/*     */   public PlayIdleAnimationGoal(Mob mob, int minDurationTicks) {
/*  58 */     this.mob = mob;
/*  59 */     this.minDurationTicks = minDurationTicks;
/*  60 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8036_() {
/*  65 */     if ((this.mob.m_9236_()).f_46443_) return false; 
/*  66 */     if (this.mob instanceof com.pla.annoyingvillagers.entity.JevEntity) return false; 
/*  67 */     if (this.mob.f_19797_ <= 30) return false; 
/*  68 */     if (!this.mob.m_6084_() || this.mob.m_213877_() || this.mob.m_21224_()) return false; 
/*  69 */     if (this.mob.m_20159_()) return false; 
/*  70 */     if (this.mob.m_5448_() != null) return false; 
/*  71 */     if (this.mob.m_21573_().m_26572_()) return false; 
/*  72 */     if (!this.mob.m_20096_()) return false; 
/*  73 */     Mob mob1 = this.mob; if (mob1 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob1; if (playerNpcEntity
/*  74 */         .isHealing() || playerNpcEntity
/*  75 */         .getPlayingIdleCooldown() != 0 || playerNpcEntity
/*  76 */         .isStrolling())
/*  77 */         return false;  }
/*     */     
/*  79 */     mob1 = this.mob; if (mob1 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob1; if (avNpc
/*  80 */         .isHealing() || avNpc
/*  81 */         .getPlayingIdleCooldown() != 0 || avNpc
/*  82 */         .isStrolling())
/*  83 */         return false;  }
/*     */     
/*  85 */     LivingEntityPatch<?> patch = null;
/*  86 */     Mob mob2 = this.mob; if (mob2 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob2;
/*  87 */       patch = playerNpcEntity.getLivingEntityPatch(); }
/*     */     
/*  89 */     mob2 = this.mob; if (mob2 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob2;
/*  90 */       patch = avNpc.getLivingEntityPatch(); }
/*     */     
/*  92 */     if (patch == null) return false; 
/*  93 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*  94 */     if (EpicfightUtil.isLongHitAnimation(dynamicAnimation, patch)) return false; 
/*  95 */     return (dynamicAnimation == Animations.EMPTY_ANIMATION);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/* 100 */     if ((this.mob.m_9236_()).f_46443_) return false; 
/* 101 */     if (this.mob instanceof com.pla.annoyingvillagers.entity.JevEntity) return false; 
/* 102 */     if (this.mob.f_19797_ <= 30) return false; 
/* 103 */     if (!this.mob.m_6084_() || this.mob.m_213877_() || this.mob.m_21224_()) return false; 
/* 104 */     if (this.mob.m_20159_()) return false; 
/* 105 */     if (!this.mob.m_20096_()) return false; 
/* 106 */     if (this.mob.m_5448_() != null) return false; 
/* 107 */     if (this.mob.m_21573_().m_26572_()) return false; 
/* 108 */     Mob mob1 = this.mob; if (mob1 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob1; if (playerNpcEntity
/* 109 */         .isHealing() || playerNpcEntity
/* 110 */         .getPlayingIdleCooldown() != 0 || playerNpcEntity
/* 111 */         .isStrolling())
/* 112 */         return false;  }
/*     */     
/* 114 */     mob1 = this.mob; if (mob1 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob1; if (avNpc
/* 115 */         .isHealing() || avNpc
/* 116 */         .getPlayingIdleCooldown() != 0 || avNpc
/* 117 */         .isStrolling())
/* 118 */         return false;  }
/*     */     
/* 120 */     LivingEntityPatch<?> patch = null;
/* 121 */     Mob mob2 = this.mob; if (mob2 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob2;
/* 122 */       patch = playerNpcEntity.getLivingEntityPatch(); }
/*     */     
/* 124 */     mob2 = this.mob; if (mob2 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob2;
/* 125 */       patch = avNpc.getLivingEntityPatch(); }
/*     */     
/* 127 */     if (patch == null) return false; 
/* 128 */     AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 129 */     if (EpicfightUtil.isLongHitAnimation(dynamicAnimation, patch)) return false; 
/* 130 */     return (this.ticksLeft > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8056_() {
/* 135 */     if (!this.mob.m_6084_() || this.mob.m_213877_() || this.mob.m_21224_())
/* 136 */       return;  this.ticksLeft = this.minDurationTicks;
/*     */     
/* 138 */     this.mob.m_21573_().m_26573_();
/* 139 */     this.mob.m_20334_(0.0D, 0.0D, 0.0D);
/* 140 */     IdleAnimation choice = null;
/* 141 */     Mob mob1 = this.mob; if (mob1 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob1;
/* 142 */       choice = playerNpcEntity.getIdleAnimationChoice(); }
/*     */     
/* 144 */     mob1 = this.mob; if (mob1 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob1;
/* 145 */       choice = avNpc.getIdleAnimationChoice(); }
/*     */     
/* 147 */     if (choice == null) {
/* 148 */       choice = pickIdleAnimation();
/* 149 */       mob1 = this.mob; if (mob1 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob1;
/* 150 */         playerNpcEntity.setIdleAnimationChoice(choice); }
/*     */       
/* 152 */       mob1 = this.mob; if (mob1 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob1;
/* 153 */         avNpc.setIdleAnimationChoice(choice); }
/*     */     
/*     */     } 
/*     */     
/* 157 */     final AssetAccessor<? extends StaticAnimation> anim = resolveAnimation(choice);
/* 158 */     Mob mob2 = this.mob; if (mob2 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob2;
/* 159 */       playerNpcEntity.setIdleAnimation(anim); }
/*     */     
/* 161 */     mob2 = this.mob; if (mob2 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob2;
/* 162 */       avNpc.setIdleAnimation(anim); }
/*     */ 
/*     */     
/* 165 */     mob2 = this.mob; if (mob2 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob2;
/* 166 */       playerNpcEntity.setPlayingIdle(true); }
/*     */     
/* 168 */     mob2 = this.mob; if (mob2 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob2;
/* 169 */       avNpc.setPlayingIdle(true); }
/*     */ 
/*     */     
/* 172 */     final IdleAnimation finalChoice = choice;
/* 173 */     new DelayedTask(30)
/*     */       {
/*     */         public void run() {
/* 176 */           if (PlayIdleAnimationGoal.this.mob.m_5448_() != null)
/* 177 */             return;  if (!PlayIdleAnimationGoal.this.mob.m_6084_() || PlayIdleAnimationGoal.this.mob.m_213877_() || PlayIdleAnimationGoal.this.mob.m_21224_())
/* 178 */             return;  PlayIdleAnimationGoal.this.playIdleAnimation(anim);
/* 179 */           PlayIdleAnimationGoal.this.tryBroadcastIdleMessage(finalChoice);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8037_() {
/* 186 */     if (this.mob.m_5448_() != null || this.mob.m_21573_().m_26572_() || !this.mob.m_20096_()) {
/* 187 */       this.ticksLeft = 0;
/*     */       
/*     */       return;
/*     */     } 
/* 191 */     if (!(this.mob.m_9236_() instanceof ServerLevel))
/*     */       return; 
/* 193 */     this.mob.m_21573_().m_26573_();
/* 194 */     this.mob.m_20334_(0.0D, 0.0D, 0.0D);
/*     */     
/* 196 */     LivingEntityPatch<?> patch = null;
/* 197 */     Mob mob1 = this.mob; if (mob1 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob1;
/* 198 */       patch = playerNpcEntity.getLivingEntityPatch(); }
/*     */     
/* 200 */     mob1 = this.mob; if (mob1 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob1;
/* 201 */       patch = avNpc.getLivingEntityPatch(); }
/*     */     
/* 203 */     AssetAccessor<? extends StaticAnimation> idleAnimation = null;
/* 204 */     Mob mob2 = this.mob; if (mob2 instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob2;
/* 205 */       idleAnimation = playerNpcEntity.getIdleAnimation(); }
/*     */     
/* 207 */     mob2 = this.mob; if (mob2 instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob2;
/* 208 */       idleAnimation = avNpc.getIdleAnimation(); }
/*     */     
/* 210 */     if (patch != null && idleAnimation != null) {
/*     */       
/* 212 */       AssetAccessor<? extends StaticAnimation> staticAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(patch.getAnimator().getPlayerFor(null))).getRealAnimation();
/* 213 */       if (staticAnimation != idleAnimation) {
/*     */ 
/*     */         
/* 216 */         Mob mob = this.mob; if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob;
/* 217 */           playIdleAnimation(playerNpcEntity.getIdleAnimation()); }
/*     */         
/* 219 */         mob = this.mob; if (mob instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob;
/* 220 */           playIdleAnimation(avNpc.getIdleAnimation()); }
/*     */       
/*     */       } 
/*     */     } 
/* 224 */     this.ticksLeft--;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8041_() {
/* 229 */     Mob mob = this.mob; if (mob instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob;
/* 230 */       avNpc.clearIdleAnimationState();
/* 231 */       LivingEntityPatch<?> patch = avNpc.getLivingEntityPatch();
/* 232 */       if (patch != null) patch.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F); 
/* 233 */       avNpc.setPlayingIdle(false);
/* 234 */       avNpc.setPlayingIdleCooldown((new Random()).nextInt(400, 1200)); }
/* 235 */     else { mob = this.mob; if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob;
/* 236 */         playerNpcEntity.clearIdleAnimationState();
/* 237 */         LivingEntityPatch<?> patch = playerNpcEntity.getLivingEntityPatch();
/* 238 */         if (patch != null) patch.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F); 
/* 239 */         playerNpcEntity.setPlayingIdle(false);
/* 240 */         playerNpcEntity.setPlayingIdleCooldown((new Random()).nextInt(400, 1200)); }
/*     */        }
/*     */   
/*     */   }
/*     */   private void playIdleAnimation(AssetAccessor<? extends StaticAnimation> anim) {
/* 245 */     if (!this.mob.m_6084_() || this.mob.m_213877_() || this.mob.m_21224_())
/* 246 */       return;  LivingEntityPatch<?> patch = null;
/* 247 */     Mob mob = this.mob; if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob;
/* 248 */       patch = playerNpcEntity.getLivingEntityPatch(); }
/*     */     
/* 250 */     mob = this.mob; if (mob instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob;
/* 251 */       patch = avNpc.getLivingEntityPatch(); }
/*     */     
/* 253 */     if (patch != null) {
/* 254 */       patch.playAnimationSynchronized(anim, 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   private IdleAnimation pickIdleAnimation() {
/* 259 */     IdleAnimation[] all = IdleAnimation.values();
/* 260 */     return all[this.mob.m_217043_().m_188503_(all.length)];
/*     */   }
/*     */   
/*     */   private AssetAccessor<? extends StaticAnimation> resolveAnimation(IdleAnimation idle) {
/* 264 */     switch (idle) { default: throw new IncompatibleClassChangeError();case PUSH_UP: case LAY: case SLEEP: case SIT: case FUN_SIT: case SLIGHT: case LAY_RELAX_EMOTE: case ONE_ARM_LAY_EMOTE: case SALUTE_LEFT_HAND_EMOTE: case SIT_NO_WEAPON_EMOTE: case SORROW_EMOTE: case SURRENDER_EMOTE: case ATTENTION_EMOTE: case FLAPPING_EMOTE: case FUN_JUMP_EMOTE: case JUMP_EMOTE: case PRONE_EMOTE: case SALUTE_EMOTE: break; }  return 
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
/* 282 */       (AssetAccessor<? extends StaticAnimation>)EFDancingAnimations.SALUTE_EMOTE;
/*     */   }
/*     */   
/*     */   private void tryBroadcastIdleMessage(IdleAnimation idle) {
/*     */     ServerLevel serverLevel;
/* 287 */     Level level = this.mob.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; } else { return; }
/* 288 */      if (!((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue())
/*     */       return; 
/* 290 */     Mob mob = this.mob; if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob; if (!playerNpcEntity.isIdleMessageBroadcast()) {
/* 291 */         List<String> pool = idleMessageKeys.get(idle);
/* 292 */         if (pool == null || pool.isEmpty())
/*     */           return; 
/* 294 */         String key = pool.get(this.mob.m_217043_().m_188503_(pool.size()));
/*     */         
/* 296 */         serverLevel.m_7654_().m_6846_().m_240416_(
/* 297 */             (Component)Component.m_237119_()
/* 298 */             .m_7220_((Component)Component.m_237113_("<"))
/* 299 */             .m_7220_(this.mob.m_5446_())
/* 300 */             .m_7220_((Component)Component.m_237113_("> "))
/* 301 */             .m_7220_((Component)Component.m_237115_(key)), false);
/*     */ 
/*     */ 
/*     */         
/* 305 */         playerNpcEntity.setIdleMessageBroadcast(true);
/*     */       }  }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\goal\PlayIdleAnimationGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */