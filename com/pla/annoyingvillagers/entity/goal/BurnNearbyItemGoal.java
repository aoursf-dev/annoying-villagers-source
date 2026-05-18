/*     */ package com.pla.annoyingvillagers.entity.goal;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumSet;
/*     */ import java.util.List;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.pathfinder.Path;
/*     */ 
/*     */ public class BurnNearbyItemGoal extends Goal {
/*     */   private final Mob mob;
/*     */   private final double speed;
/*     */   
/*     */   private static List<String> keys(String prefix, int count) {
/*  30 */     List<String> list = new ArrayList<>(count);
/*  31 */     for (int i = 1; i <= count; i++) {
/*  32 */       list.add(prefix + "." + prefix);
/*     */     }
/*  34 */     return List.copyOf(list);
/*     */   }
/*     */   private final double searchRadius; private ItemEntity targetItem;
/*  37 */   private static final List<String> burnMessageKeys = keys("burn_item.annoyingvillagers", 56);
/*     */   
/*     */   public BurnNearbyItemGoal(Mob mob, double speed, double searchRadius) {
/*  40 */     this.mob = mob;
/*  41 */     this.speed = speed;
/*  42 */     this.searchRadius = searchRadius;
/*  43 */     m_7021_(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8036_() {
/*  48 */     if ((this.mob.m_9236_()).f_46443_) return false; 
/*  49 */     if (!this.mob.m_6084_() || this.mob.m_213877_() || this.mob.m_21224_()) return false; 
/*  50 */     if (this.mob.m_20159_()) return false; 
/*  51 */     if (this.mob.m_5448_() != null) return false; 
/*  52 */     if (this.mob.m_21525_()) return false; 
/*  53 */     if (!((Boolean)AnnoyingVillagersConfig.AV_MOB_CAN_BURN_ITEM.get()).booleanValue()) return false; 
/*  54 */     Mob mob = this.mob; if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob; if (playerNpcEntity.isHealing())
/*  55 */         return false;  }
/*     */     
/*  57 */     mob = this.mob; if (mob instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob; if (avNpc.isHealing())
/*  58 */         return false;  }
/*     */     
/*  60 */     this.targetItem = findTargetItem();
/*  61 */     return (this.targetItem != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_8045_() {
/*  66 */     if ((this.mob.m_9236_()).f_46443_) return false; 
/*  67 */     if (!this.mob.m_6084_() || this.mob.m_213877_() || this.mob.m_21224_()) return false; 
/*  68 */     if (this.mob.m_20159_()) return false; 
/*  69 */     if (this.mob.m_5448_() != null) return false; 
/*  70 */     if (this.mob.m_21525_()) return false; 
/*  71 */     if (!((Boolean)AnnoyingVillagersConfig.AV_MOB_CAN_BURN_ITEM.get()).booleanValue()) return false;
/*     */     
/*  73 */     return (this.targetItem != null && this.targetItem.m_6084_() && !this.targetItem.m_32055_().m_41619_());
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8056_() {
/*  78 */     if (this.mob.m_21205_().m_41720_() != Items.f_42409_) {
/*  79 */       this.mob.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42409_));
/*     */     }
/*  81 */     this.mob.m_21573_().m_5624_((Entity)this.targetItem, this.speed);
/*     */   }
/*     */   
/*     */   public void m_8037_() {
/*     */     ServerLevel serverLevel;
/*  86 */     if (!this.mob.m_6084_() || this.mob.m_213877_() || this.mob.m_21224_())
/*  87 */       return;  Level level = this.mob.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; } else { return; }
/*  88 */      if (this.targetItem == null || !this.targetItem.m_6084_() || this.targetItem.m_32055_().m_41619_()) {
/*     */       return;
/*     */     }
/*     */     
/*  92 */     if (this.mob.m_21573_().m_26571_()) {
/*  93 */       if (this.mob.m_21205_().m_41720_() != Items.f_42409_) {
/*  94 */         this.mob.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42409_));
/*     */       }
/*  96 */       Path path = this.mob.m_21573_().m_6570_((Entity)this.targetItem, 0);
/*  97 */       if (path == null) {
/*     */         return;
/*     */       }
/* 100 */       this.mob.m_21573_().m_5624_((Entity)this.targetItem, this.speed);
/*     */     } 
/*     */     
/* 103 */     this.mob.m_21563_().m_24950_(this.targetItem
/* 104 */         .m_20185_(), this.targetItem
/* 105 */         .m_20186_() + this.targetItem.m_20206_() / 2.0D, this.targetItem
/* 106 */         .m_20189_(), 30.0F, 30.0F);
/*     */ 
/*     */ 
/*     */     
/* 110 */     double dist = this.mob.m_20270_((Entity)this.targetItem);
/* 111 */     if (dist <= 1.5D) {
/* 112 */       ItemStack burnedStack = this.targetItem.m_32055_().m_41777_();
/*     */       
/* 114 */       this.mob.m_6674_(InteractionHand.MAIN_HAND);
/* 115 */       this.targetItem.m_6074_();
/*     */       
/* 117 */       serverLevel.m_8767_((ParticleOptions)ParticleTypes.f_123744_, this.targetItem
/*     */           
/* 119 */           .m_20185_(), this.targetItem.m_20186_(), this.targetItem.m_20189_(), 8, 0.2D, 0.2D, 0.2D, 0.01D);
/*     */ 
/*     */ 
/*     */       
/* 123 */       this.mob.m_9236_().m_5594_(null, this.mob
/*     */           
/* 125 */           .m_20183_(), SoundEvents.f_11942_, SoundSource.HOSTILE, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 132 */       tryBroadcastBurnMessage(serverLevel, burnedStack);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8041_() {
/* 138 */     this.targetItem = null;
/* 139 */     this.mob.m_21573_().m_26573_();
/* 140 */     if (findTargetItem() == null) {
/* 141 */       restoreMainWeapon();
/*     */     }
/*     */   }
/*     */   
/*     */   private void tryBroadcastBurnMessage(ServerLevel serverLevel, ItemStack burnedStack) {
/* 146 */     if (!((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue())
/* 147 */       return;  if (!(this.mob instanceof PlayerNpcEntity))
/* 148 */       return;  if (this.mob.m_217043_().m_188501_() >= 0.05F)
/*     */       return; 
/* 150 */     String key = burnMessageKeys.get(this.mob.m_217043_().m_188503_(burnMessageKeys.size()));
/*     */     
/* 152 */     serverLevel.m_7654_().m_6846_().m_240416_(
/* 153 */         (Component)Component.m_237119_()
/* 154 */         .m_7220_((Component)Component.m_237113_("<"))
/* 155 */         .m_7220_(this.mob.m_5446_())
/* 156 */         .m_7220_((Component)Component.m_237113_("> "))
/* 157 */         .m_7220_((Component)Component.m_237110_(key, new Object[] { burnedStack.m_41786_() })), false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void restoreMainWeapon() {
/* 163 */     ItemStack weapon = null;
/* 164 */     Mob mob = this.mob; if (mob instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)mob;
/* 165 */       weapon = playerNpcEntity.getMainWeaponItem();
/* 166 */       playerNpcEntity.setPlayingIdleCooldown(playerNpcEntity.getPlayingIdleCooldown() + 40); }
/*     */     
/* 168 */     mob = this.mob; if (mob instanceof AVNpc) { AVNpc avNpc = (AVNpc)mob;
/* 169 */       weapon = avNpc.getMainWeaponItem();
/* 170 */       avNpc.setPlayingIdleCooldown(avNpc.getPlayingIdleCooldown() + 40); }
/*     */     
/* 172 */     if (weapon != null && !weapon.m_41619_()) {
/* 173 */       this.mob.m_8061_(EquipmentSlot.MAINHAND, weapon.m_41777_());
/*     */     } else {
/* 175 */       this.mob.m_8061_(EquipmentSlot.MAINHAND, ItemStack.f_41583_);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ItemEntity findTargetItem() {
/* 180 */     List<ItemEntity> items = this.mob.m_9236_().m_6443_(ItemEntity.class, this.mob
/*     */         
/* 182 */         .m_20191_().m_82400_(this.searchRadius), e -> 
/* 183 */         (e.m_6084_() && !e.m_32055_().m_41619_()));
/*     */ 
/*     */     
/* 186 */     if (items.isEmpty()) return null; 
/* 187 */     ItemEntity best = null;
/* 188 */     double bestDist = Double.MAX_VALUE;
/* 189 */     for (ItemEntity it : items) {
/* 190 */       double d = this.mob.m_20280_((Entity)it);
/* 191 */       if (d < bestDist) {
/* 192 */         bestDist = d;
/* 193 */         best = it;
/*     */       } 
/*     */     } 
/* 196 */     return best;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\goal\BurnNearbyItemGoal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */