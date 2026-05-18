/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.pla.annoyingvillagers.entity.EnchantedEnderPearlEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import java.util.Objects;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.Container;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.ThrownEnderpearl;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import yesman.epicfight.api.animation.AnimationPlayer;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ 
/*     */ 
/*     */ public class ThrowingPearlKeyPressedEvent
/*     */ {
/*     */   private static Vec3 getFrontLeftPos(Entity entity) {
/*  34 */     LivingEntity le = (LivingEntity)entity;
/*     */     
/*  36 */     Vec3 base = (entity instanceof LivingEntity) ? le.m_20299_(1.0F) : entity.m_20182_().m_82520_(0.0D, entity.m_20206_() * 0.85D, 0.0D);
/*     */     
/*  38 */     base = base.m_82520_(0.0D, -0.1D, 0.0D);
/*     */     
/*  40 */     Vec3 forward = entity.m_20154_();
/*  41 */     Vec3 forwardH = new Vec3(forward.f_82479_, 0.0D, forward.f_82481_);
/*  42 */     if (forwardH.m_82556_() < 1.0E-6D) {
/*  43 */       forwardH = entity.m_20156_();
/*  44 */       forwardH = new Vec3(forwardH.f_82479_, 0.0D, forwardH.f_82481_);
/*     */     } 
/*  46 */     forwardH = forwardH.m_82541_();
/*     */     
/*  48 */     Vec3 left = (new Vec3(0.0D, 1.0D, 0.0D)).m_82537_(forwardH);
/*  49 */     if (left.m_82556_() < 1.0E-6D) {
/*  50 */       left = new Vec3(1.0D, 0.0D, 0.0D);
/*     */     } else {
/*  52 */       left = left.m_82541_();
/*     */     } 
/*     */     
/*  55 */     return base.m_82549_(forwardH.m_82490_(0.35D)).m_82549_(left.m_82490_(0.25D));
/*     */   }
/*     */   
/*     */   public static void execute(Entity entity) {
/*  59 */     if (entity != null) {
/*  60 */       if (!(entity.m_9236_() instanceof net.minecraft.server.level.ServerLevel))
/*     */         return; 
/*  62 */       LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/*  63 */       if (livingEntityPatch == null)
/*  64 */         return;  AssetAccessor<? extends StaticAnimation> dynamicAnimation = ((AnimationPlayer)Objects.<AnimationPlayer>requireNonNull(livingEntityPatch.getAnimator().getPlayerFor(null))).getRealAnimation();
/*  65 */       if (EpicfightUtil.isLongHitAnimation(dynamicAnimation, livingEntityPatch)) {
/*     */         return;
/*     */       }
/*  68 */       if (dynamicAnimation != Animations.EMPTY_ANIMATION) {
/*     */         return;
/*     */       }
/*     */       
/*  72 */       if (entity instanceof Player) { Player player1 = (Player)entity;
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
/*  91 */         boolean used = ((Boolean)(player1.m_150109_()).f_35974_.stream().filter(s -> (!s.m_41619_() && s.m_150930_((Item)AnnoyingVillagersModItems.ENCHANTED_ENDER_PEARL.get()))).findFirst().map(stack -> { livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_TOP, 0.0F); Level level = entity.m_9236_(); EnchantedEnderPearlEntity projectile = new EnchantedEnderPearlEntity((EntityType)AnnoyingVillagersModEntities.ENCHANTED_ENDER_PEARL_PROJECTILE.get(), level); projectile.m_5602_(entity); Vec3 handPos = getFrontLeftPos(entity); projectile.m_6034_(handPos.f_82479_, handPos.f_82480_, handPos.f_82481_); projectile.m_6686_((entity.m_20154_()).f_82479_, (entity.m_20154_()).f_82480_, (entity.m_20154_()).f_82481_, 1.5F, 0.0F); level.m_7967_((Entity)projectile); entity.m_9236_().m_6263_(null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_11857_, SoundSource.NEUTRAL, 0.5F, 0.4F / (entity.m_9236_().m_213780_().m_188501_() * 0.4F + 0.8F)); stack.m_41622_(1, (LivingEntity)player, ()); return Boolean.valueOf(true); }).orElse(Boolean.valueOf(false))).booleanValue();
/*     */         
/*  93 */         if (used) {
/*     */           return;
/*     */         } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       Player player = (Player)entity; if (entity instanceof Player && 
/*     */         
/* 103 */         player.m_150109_().m_36063_(new ItemStack((ItemLike)Items.f_42584_))) {
/* 104 */         livingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.CASTING_ONE_HAND_TOP, 0.0F);
/* 105 */         Level level = entity.m_9236_();
/* 106 */         ThrownEnderpearl thrownEnderpearl = new ThrownEnderpearl(EntityType.f_20484_, level);
/* 107 */         thrownEnderpearl.m_5602_(entity);
/*     */         
/* 109 */         Vec3 handPos = getFrontLeftPos(entity);
/* 110 */         thrownEnderpearl.m_6034_(handPos.f_82479_, handPos.f_82480_, handPos.f_82481_);
/* 111 */         thrownEnderpearl.m_6686_((entity.m_20154_()).f_82479_, (entity.m_20154_()).f_82480_, (entity.m_20154_()).f_82481_, 1.5F, 0.0F);
/* 112 */         level.m_7967_((Entity)thrownEnderpearl);
/*     */         
/* 114 */         entity.m_9236_().m_6263_(null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_11857_, SoundSource.NEUTRAL, 0.5F, 0.4F / (entity.m_9236_().m_213780_().m_188501_() * 0.4F + 0.8F));
/* 115 */         Player player2 = (Player)entity;
/* 116 */         ItemStack itemStack = new ItemStack((ItemLike)Items.f_42584_);
/*     */         
/* 118 */         player2.m_150109_().m_36022_(stack -> (itemStack.m_41720_() == stack.m_41720_()), 1, (Container)player2.f_36095_.m_39730_());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\ThrowingPearlKeyPressedEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */