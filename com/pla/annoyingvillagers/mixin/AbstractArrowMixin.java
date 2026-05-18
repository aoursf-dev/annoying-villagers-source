/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.damagesource.DamageSources;
/*    */ import net.minecraft.world.damagesource.DamageType;
/*    */ import net.minecraft.world.damagesource.DamageTypes;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({AbstractArrow.class})
/*    */ public abstract class AbstractArrowMixin
/*    */ {
/*    */   @Redirect(method = {"onHitEntity(Lnet/minecraft/world/phys/EntityHitResult;)V"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/damagesource/DamageSources;arrow(Lnet/minecraft/world/entity/projectile/AbstractArrow;Lnet/minecraft/world/entity/Entity;)Lnet/minecraft/world/damagesource/DamageSource;"))
/*    */   private DamageSource redirectArrowDamage(DamageSources sources, AbstractArrow arrow, @Nullable Entity shooter) {
/* 32 */     if (arrow instanceof com.pla.annoyingvillagers.entity.EnderAegisProjectile) {
/*    */ 
/*    */ 
/*    */       
/* 36 */       ResourceKey<DamageType> key = (shooter instanceof net.minecraft.world.entity.player.Player) ? DamageTypes.f_268464_ : ((shooter instanceof net.minecraft.world.entity.LivingEntity) ? DamageTypes.f_268566_ : DamageTypes.f_268433_);
/*    */       
/* 38 */       Registry<DamageType> reg = arrow.m_9236_().m_9598_().m_175515_(Registries.f_268580_);
/* 39 */       Holder.Reference reference = reg.m_246971_(key);
/* 40 */       return new DamageSource((Holder)reference, shooter, (Entity)arrow);
/*    */     } 
/* 42 */     return sources.m_269418_(arrow, shooter);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\AbstractArrowMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */