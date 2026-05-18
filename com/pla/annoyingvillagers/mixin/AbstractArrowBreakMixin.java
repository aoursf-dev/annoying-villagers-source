/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ import com.pla.annoyingvillagers.util.projectile.BreakPowerHolder;
/*    */ import com.pla.annoyingvillagers.util.projectile.ProjectileBlockBreaker;
/*    */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*    */ import net.minecraft.world.level.ClipContext;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.BlockHitResult;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({AbstractArrow.class})
/*    */ public abstract class AbstractArrowBreakMixin implements BreakPowerHolder {
/*    */   @Unique
/* 18 */   private float breakPower = 0.0F;
/*    */   @Unique
/*    */   private boolean powerInit = false;
/*    */   
/*    */   public float getBreakPower() {
/* 23 */     return this.breakPower;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setBreakPower(float power) {
/* 28 */     this.breakPower = power;
/*    */   }
/*    */   
/*    */   @Inject(method = {"tick"}, at = {@At("HEAD")})
/*    */   private void initPower(CallbackInfo ci) {
/* 33 */     AbstractArrow self = (AbstractArrow)this;
/* 34 */     if ((self.m_9236_()).f_46443_)
/*    */       return; 
/* 36 */     if (!this.powerInit) {
/* 37 */       this.breakPower = ProjectileBlockBreaker.computeInitialPower(self);
/* 38 */       this.powerInit = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Redirect(method = {"tick"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;clip(Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;"))
/*    */   private BlockHitResult redirectClip(Level level, ClipContext ctx) {
/* 47 */     AbstractArrow self = (AbstractArrow)this;
/* 48 */     return ProjectileBlockBreaker.clip(level, ctx, self);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\AbstractArrowBreakMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */