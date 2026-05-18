/*     */ package com.pla.annoyingvillagers.mixin;
/*     */ 
/*     */ import com.pla.annoyingvillagers.block.EndFireBlock;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.util.ExplosionFxMute;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Explosion;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.ModifyArg;
/*     */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*     */ import org.spongepowered.asm.mixin.injection.Redirect;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin(value = {Explosion.class}, remap = true)
/*     */ public abstract class ExplosionMixin
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   private Level f_46012_;
/*     */   
/*     */   @Unique
/*     */   private boolean muteAtThisPos() {
/*  40 */     if (!this.f_46012_.m_5776_()) return false;
/*     */     
/*  42 */     Vec3 pos = ((Explosion)this).getPosition();
/*  43 */     long key = BlockPos.m_121882_(Mth.m_14107_(pos.f_82479_), Mth.m_14107_(pos.f_82480_), Mth.m_14107_(pos.f_82481_));
/*     */     
/*  45 */     return ExplosionFxMute.shouldMute(key, this.f_46012_.m_46467_());
/*     */   }
/*     */   @Shadow
/*     */   @Final
/*     */   @Nullable
/*     */   private Entity f_46016_;
/*     */   @Shadow
/*     */   @Nullable
/*     */   public abstract LivingEntity m_252906_();
/*     */   
/*     */   @ModifyArg(method = {"finalizeExplosion(Z)V"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"), index = 5)
/*     */   private float muteExplosionSound(float vol) {
/*  57 */     return muteAtThisPos() ? 0.0F : vol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ModifyVariable(method = {"finalizeExplosion(Z)V"}, at = @At("HEAD"), argsOnly = true)
/*     */   private boolean disableParticlesWhenMuted(boolean spawnParticles) {
/*  66 */     return muteAtThisPos() ? false : spawnParticles;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ModifyArg(method = {"finalizeExplosion(Z)V"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z"), index = 1)
/*     */   private BlockState replaceVanillaFire(BlockState originalState) {
/*  78 */     if (!(originalState.m_60734_() instanceof net.minecraft.world.level.block.BaseFireBlock)) return originalState;
/*     */     
/*  80 */     LivingEntity owner = m_252906_();
/*  81 */     if (owner != null && owner.m_6084_()) {
/*  82 */       ItemStack stack = owner.m_21205_();
/*  83 */       if (stack.m_41720_() instanceof com.pla.annoyingvillagers.item.EnderGlaiveItem) {
/*  84 */         return ((EndFireBlock)AnnoyingVillagersModBlocks.END_FIRE.get()).m_49966_();
/*     */       }
/*     */     } 
/*  87 */     return originalState;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Redirect(method = {"explode"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"))
/*     */   private void noKnockbackFromTridentLightning(Entity instance, Vec3 pDeltaMovement) {
/*  98 */     if (this.f_46016_ instanceof com.pla.annoyingvillagers.entity.TridentLightningBolt) {
/*     */       return;
/*     */     }
/* 101 */     instance.m_20256_(pDeltaMovement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Redirect(method = {"explode"}, at = @At(value = "INVOKE", target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"))
/*     */   private Object noPlayerExplosionVector(Map<?, ?> map, Object key, Object value) {
/* 112 */     if (this.f_46016_ instanceof com.pla.annoyingvillagers.entity.TridentLightningBolt) {
/* 113 */       return null;
/*     */     }
/* 115 */     return map.put(key, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\ExplosionMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */