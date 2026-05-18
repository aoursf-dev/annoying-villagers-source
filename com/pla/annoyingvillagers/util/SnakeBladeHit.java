/*     */ package com.pla.annoyingvillagers.util;
/*     */ import com.pla.annoyingvillagers.capabilities.SnakeBladeCapability;
/*     */ import com.pla.annoyingvillagers.entity.SnakeBladeEntity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModCapabilities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ClipContext;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import yesman.epicfight.api.utils.math.OpenMatrix4f;
/*     */ import yesman.epicfight.api.utils.math.Vec3f;
/*     */ import yesman.epicfight.gameasset.Armatures;
/*     */ import yesman.epicfight.model.armature.HumanoidArmature;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ public class SnakeBladeHit {
/*     */   public static boolean checkNearbyTarget(LivingEntity attacker) {
/*  28 */     Level level = attacker.m_9236_();
/*  29 */     Entity closestValid = null;
/*     */     
/*  31 */     Vec3 attackerEyes = attacker.m_20299_(1.0F);
/*  32 */     level.m_45547_(new ClipContext(attackerEyes, attackerEyes
/*     */           
/*  34 */           .m_82549_(attacker.m_20154_().m_82490_(16.0D)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, (Entity)attacker));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     Iterator<Entity> iterator = level.m_45976_(LivingEntity.class, attacker.m_20191_().m_82400_(16.0D)).iterator(); label23: while (true) { Entity entity; while (true) { if (iterator.hasNext()) { entity = iterator.next();
/*  41 */           if (!entity.equals(attacker) && 
/*  42 */             !attacker.m_7307_(entity) && 
/*  43 */             !entity.m_7307_((Entity)attacker) && 
/*  44 */             !entity.m_5833_()) { if (entity instanceof Player)
/*  45 */             { Player player = (Player)entity; if (!player.m_7500_()) break;  continue; }  break; }  continue; }  break label23; }  if ((entity instanceof net.minecraft.world.entity.Mob || entity instanceof Player) && attacker
/*     */         
/*  47 */         .m_142582_(entity) && (
/*  48 */         closestValid == null || attacker.m_20270_(entity) < attacker.m_20270_(closestValid))) {
/*  49 */         closestValid = entity;
/*     */       } }
/*     */ 
/*     */     
/*  53 */     return (closestValid != null);
/*     */   }
/*     */   
/*     */   public static void process(ItemStack stack, LivingEntity attacker) {
/*  57 */     Level level = attacker.m_9236_();
/*  58 */     Entity closestValid = null;
/*     */     
/*  60 */     Vec3 attackerEyes = attacker.m_20299_(1.0F);
/*  61 */     level.m_45547_(new ClipContext(attackerEyes, attackerEyes
/*     */           
/*  63 */           .m_82549_(attacker.m_20154_().m_82490_(16.0D)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, (Entity)attacker));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     Iterator<Entity> iterator = level.m_45976_(LivingEntity.class, attacker.m_20191_().m_82400_(16.0D)).iterator(); label21: while (true) { Entity entity; while (true) { if (iterator.hasNext()) { entity = iterator.next();
/*  70 */           if (!entity.equals(attacker) && 
/*  71 */             !attacker.m_7307_(entity) && 
/*  72 */             !entity.m_7307_((Entity)attacker) && 
/*  73 */             !entity.m_5833_()) { if (entity instanceof Player)
/*  74 */             { Player player = (Player)entity; if (!player.m_7500_()) break;  continue; }  break; }  continue; }  break label21; }  if ((entity instanceof net.minecraft.world.entity.Mob || entity instanceof Player) && attacker
/*     */         
/*  76 */         .m_142582_(entity) && (
/*  77 */         closestValid == null || attacker.m_20270_(entity) < attacker.m_20270_(closestValid))) {
/*  78 */         closestValid = entity;
/*     */       } }
/*     */ 
/*     */     
/*  82 */     launchSnakeBladeAt(attacker, closestValid, stack);
/*     */   }
/*     */   
/*     */   public static void processGuard(ItemStack stack, LivingEntity entityToGuard) {
/*  86 */     Level level = entityToGuard.m_9236_();
/*     */     
/*  88 */     SnakeBladeCapability.ISnakeBladeCapability snakeBladeCapability = (SnakeBladeCapability.ISnakeBladeCapability)AnnoyingVillagersModCapabilities.getCapability((Entity)entityToGuard, AnnoyingVillagersModCapabilities.SNAKE_BLADE_CAPABILITY);
/*     */     
/*  90 */     if (snakeBladeCapability != null && 
/*  91 */       canLaunchSnakeBlades(level, entityToGuard)) {
/*  92 */       retractFarFragments(level, entityToGuard);
/*  93 */       if (!level.f_46443_) {
/*  94 */         launchSnakeBladeAt(entityToGuard, stack);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void launchSnakeBladeAt(LivingEntity attacker, Entity closestValid, ItemStack stack) {
/* 101 */     Level level = attacker.m_9236_();
/*     */     
/* 103 */     SnakeBladeCapability.ISnakeBladeCapability snakeBladeCapability = (SnakeBladeCapability.ISnakeBladeCapability)AnnoyingVillagersModCapabilities.getCapability((Entity)attacker, AnnoyingVillagersModCapabilities.SNAKE_BLADE_CAPABILITY);
/*     */     
/* 105 */     if (snakeBladeCapability != null && 
/* 106 */       canLaunchSnakeBlades(level, attacker)) {
/* 107 */       retractFarFragments(level, attacker);
/* 108 */       if (!level.f_46443_ && 
/* 109 */         closestValid != null) {
/* 110 */         SnakeBladeEntity snakeBladeEntity = (SnakeBladeEntity)((EntityType)AnnoyingVillagersModEntities.SNAKE_BLADE.get()).m_20615_(level);
/* 111 */         if (snakeBladeEntity != null) {
/* 112 */           if (stack.m_41790_()) {
/* 113 */             snakeBladeEntity.setEnchanted(true);
/*     */           }
/* 115 */           snakeBladeEntity.m_20359_((Entity)attacker);
/* 116 */           level.m_7967_((Entity)snakeBladeEntity);
/* 117 */           snakeBladeEntity.setCreatorEntityUUID(attacker.m_20148_());
/* 118 */           snakeBladeEntity.setFromEntityID(attacker.m_19879_());
/* 119 */           snakeBladeEntity.setToEntityID(closestValid.m_19879_());
/* 120 */           snakeBladeEntity.m_20359_((Entity)attacker);
/* 121 */           snakeBladeEntity.setProgress(0.0F);
/* 122 */           setLastFragment(attacker, snakeBladeEntity);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean launchSnakeBladeAt(LivingEntity attacker, ItemStack stack) {
/* 131 */     Level level = attacker.m_9236_();
/* 132 */     SnakeBladeEntity snakeBladeEntity = (SnakeBladeEntity)((EntityType)AnnoyingVillagersModEntities.SNAKE_BLADE.get()).m_20615_(level);
/* 133 */     if (snakeBladeEntity == null) return false;
/*     */     
/* 135 */     if (stack.m_41790_()) {
/* 136 */       snakeBladeEntity.setEnchanted(true);
/*     */     }
/*     */     
/* 139 */     snakeBladeEntity.setCreatorEntityUUID(attacker.m_20148_());
/* 140 */     snakeBladeEntity.setFromEntityID(attacker.m_19879_());
/* 141 */     snakeBladeEntity.setToEntityID(-1);
/* 142 */     snakeBladeEntity.setProgress(0.0F);
/* 143 */     snakeBladeEntity.setGuardDirection("forward_left");
/*     */     
/* 145 */     Vec3 spawn = guardTargetFor(attacker, "forward_left");
/* 146 */     snakeBladeEntity.m_6034_(spawn.f_82479_, spawn.f_82480_, spawn.f_82481_);
/*     */     
/* 148 */     level.m_7967_((Entity)snakeBladeEntity);
/* 149 */     setLastFragment(attacker, snakeBladeEntity);
/* 150 */     return true;
/*     */   }
/*     */   
/*     */   public static final class LocalSpace {
/* 154 */     private static final Vec3 UP = new Vec3(0.0D, 1.0D, 0.0D);
/*     */     
/*     */     public static Vec3 forward(LivingEntity e) {
/* 157 */       float yawRad = e.f_20883_ * 0.017453292F;
/* 158 */       return (new Vec3(-Mth.m_14031_(yawRad), 0.0D, Mth.m_14089_(yawRad))).m_82541_();
/*     */     }
/*     */     
/*     */     public static Vec3 right(LivingEntity e) {
/* 162 */       Vec3 f = forward(e);
/* 163 */       return UP.m_82537_(f).m_82541_();
/*     */     }
/*     */     
/*     */     public static Vec3 left(LivingEntity e) {
/* 167 */       return right(e).m_82490_(-1.0D);
/*     */     }
/*     */     
/*     */     public static Vec3 back(LivingEntity e) {
/* 171 */       return forward(e).m_82490_(-1.0D);
/*     */     }
/*     */     
/*     */     public static Vec3 localOffsetPos(LivingEntity e, double leftU, double upU, double forwardU) {
/* 175 */       Vec3 base = e.m_20182_();
/*     */ 
/*     */       
/* 178 */       Vec3 off = left(e).m_82490_(leftU).m_82549_(UP.m_82490_(upU)).m_82549_(forward(e).m_82490_(forwardU));
/* 179 */       return base.m_82549_(off);
/*     */     }
/*     */   }
/*     */   
/*     */   public static Vec3 guardTargetFor(LivingEntity ent, String direction) {
/* 184 */     Random random = new Random();
/* 185 */     if ("forward_left".equalsIgnoreCase(direction))
/* 186 */       return LocalSpace.localOffsetPos(ent, 1.0D, 0.0D, -1.0D); 
/* 187 */     if ("forward_right".equalsIgnoreCase(direction))
/* 188 */       return LocalSpace.localOffsetPos(ent, 2.0D, 1.0D, 1.0D); 
/* 189 */     if ("backward_right".equalsIgnoreCase(direction)) {
/* 190 */       return LocalSpace.localOffsetPos(ent, -1.0D, 0.0D, 2.0D);
/*     */     }
/* 192 */     return LocalSpace.localOffsetPos(ent, -1.0D, 2.0D, -1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setLastFragment(LivingEntity entity, SnakeBladeEntity snakeBladeEntity) {
/* 198 */     SnakeBladeCapability.ISnakeBladeCapability snakeBladeCapability = (SnakeBladeCapability.ISnakeBladeCapability)AnnoyingVillagersModCapabilities.getCapability((Entity)entity, AnnoyingVillagersModCapabilities.SNAKE_BLADE_CAPABILITY);
/*     */     
/* 200 */     if (snakeBladeCapability != null) {
/* 201 */       snakeBladeCapability.setHasSnakeBlade((snakeBladeEntity != null));
/*     */       
/* 203 */       if (snakeBladeEntity != null) {
/* 204 */         snakeBladeCapability.setLastSnakeBladeID(snakeBladeEntity.m_19879_());
/* 205 */         snakeBladeCapability.setLastSnakeBladeUUID(snakeBladeEntity.m_20148_());
/*     */       } else {
/* 207 */         snakeBladeCapability.setLastSnakeBladeID(-1);
/* 208 */         snakeBladeCapability.setLastSnakeBladeUUID(null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void retractFarFragments(Level level, LivingEntity livingEntity) {
/* 214 */     SnakeBladeEntity last = getLastFragment(livingEntity);
/* 215 */     if (last != null) {
/* 216 */       last.m_142687_(Entity.RemovalReason.DISCARDED);
/* 217 */       setLastFragment(livingEntity, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean canLaunchSnakeBlades(Level level, LivingEntity livingEntity) {
/* 222 */     SnakeBladeEntity last = getLastFragment(livingEntity);
/* 223 */     if (last != null) {
/* 224 */       return last.m_213877_();
/*     */     }
/* 226 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SnakeBladeEntity getLastFragment(LivingEntity livingEntity) {
/* 231 */     SnakeBladeCapability.ISnakeBladeCapability snakeBladeCapability = (SnakeBladeCapability.ISnakeBladeCapability)AnnoyingVillagersModCapabilities.getCapability((Entity)livingEntity, AnnoyingVillagersModCapabilities.SNAKE_BLADE_CAPABILITY);
/*     */     
/* 233 */     if (snakeBladeCapability == null) return null;
/*     */     
/* 235 */     UUID uuid = snakeBladeCapability.getLastSnakeBladeUUID();
/* 236 */     int id = snakeBladeCapability.getLastSnakeBladeID();
/* 237 */     Level level = livingEntity.m_9236_();
/*     */     
/* 239 */     Entity found = null;
/*     */     
/* 241 */     if (!level.f_46443_) {
/* 242 */       if (uuid != null && level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 243 */         found = serverLevel.m_8791_(uuid); }
/*     */       
/* 245 */       if (found == null && id != -1) {
/* 246 */         found = level.m_6815_(id);
/*     */       }
/*     */     }
/* 249 */     else if (id != -1) {
/* 250 */       found = level.m_6815_(id);
/*     */     } 
/*     */ 
/*     */     
/* 254 */     if (found instanceof SnakeBladeEntity) { SnakeBladeEntity snakeBladeEntity = (SnakeBladeEntity)found; if (found.m_6084_())
/*     */       {
/*     */         
/* 257 */         return snakeBladeEntity; }  }
/*     */     
/*     */     return null;
/*     */   } public static Vec3 getToolTipPos(Entity ent, float partialTicks, float handToTip) {
/* 261 */     LivingEntityPatch<?> patch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(ent, LivingEntityPatch.class);
/* 262 */     if (patch == null) return null;
/*     */ 
/*     */     
/* 265 */     OpenMatrix4f joint = patch.getArmature().getBoundTransformFor(patch.getAnimator().getPose(partialTicks), ((HumanoidArmature)Armatures.BIPED.get()).toolR);
/*     */     
/* 267 */     OpenMatrix4f localOffset = (new OpenMatrix4f()).translate(new Vec3f(0.0F, 0.0F, -handToTip));
/* 268 */     OpenMatrix4f.mul(joint, localOffset, joint);
/*     */     
/* 270 */     float yawRad = (float)-Math.toRadians((((LivingEntity)ent).f_20884_ + 180.0F));
/* 271 */     OpenMatrix4f worldYaw = (new OpenMatrix4f()).rotate(yawRad, new Vec3f(0.0F, 1.0F, 0.0F));
/* 272 */     OpenMatrix4f.mul(worldYaw, joint, joint);
/*     */     
/* 274 */     return new Vec3(joint.m30 + ent
/* 275 */         .m_20185_(), joint.m31 + ent
/* 276 */         .m_20186_() + (ent.m_20206_() / 1.8F) - 1.0D, joint.m32 + ent
/* 277 */         .m_20189_());
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\SnakeBladeHit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */