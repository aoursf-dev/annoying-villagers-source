/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.effect.MobEffects;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*    */ import net.minecraft.world.item.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.world.item.enchantment.Enchantments;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.shelmarow.combat_evolution.ai.CEHumanoidPatch;
/*    */ import net.shelmarow.combat_evolution.ai.util.CEPatchUtils;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import reascer.wom.particle.WOMParticles;
/*    */ import reascer.wom.world.damagesources.WOMExtraDamageInstance;
/*    */ import reascer.wom.world.entity.mob.EnderHand;
/*    */ import yesman.epicfight.api.utils.math.ValueModifier;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ import yesman.epicfight.world.damagesource.EpicFightDamageSource;
/*    */ 
/*    */ @Mixin(value = {EnderHand.class}, remap = true)
/*    */ public abstract class EnderHandMixin {
/*    */   @Inject(method = {"customServerAiStep"}, at = {@At("TAIL")}, cancellable = true)
/*    */   private void makeEnderHandCanDamagePlayer(CallbackInfo ci) {
/* 33 */     EnderHand self = (EnderHand)this;
/* 34 */     if (self.f_19797_ == 20 && self.m_21805_() != null) {
/* 35 */       Level level = self.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/* 36 */         Entity entity = serverLevel.m_8791_(self.m_21805_()); if (entity instanceof LivingEntity) { LivingEntity owner = (LivingEntity)entity; if (!(owner instanceof net.minecraft.world.entity.player.Player) && self
/*    */             
/* 38 */             .m_5448_() != null && self.m_5448_().m_6084_()) {
/* 39 */             LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch((Entity)owner, LivingEntityPatch.class);
/* 40 */             if (livingEntityPatch != null) {
/* 41 */               LivingEntity livingEntity = (LivingEntity)livingEntityPatch.getOriginal();
/* 42 */               LivingEntity livingEntity1 = self.m_5448_();
/* 43 */               EpicFightDamageSource damageSource = new EpicFightDamageSource((DamageSource)livingEntityPatch.getDamageSource(AnimsRuine.RUINE_PLUNDER, InteractionHand.MAIN_HAND));
/* 44 */               damageSource.setBaseImpact(4.0F);
/* 45 */               damageSource.setStunType(StunType.HOLD);
/* 46 */               damageSource.attachDamageModifier(ValueModifier.multiplier(2.6F));
/* 47 */               damageSource.addExtraDamage(WOMExtraDamageInstance.WOM_SWEEPING_EDGE_ENCHANTMENT.create(new float[] { 0.8F }));
/* 48 */               livingEntity1.m_6469_((DamageSource)damageSource, (float)livingEntity.m_21133_(Attributes.f_22281_));
/* 49 */               if (livingEntity1.m_21023_(MobEffects.f_19597_)) {
/* 50 */                 livingEntity1.m_21195_(MobEffects.f_19597_);
/* 51 */                 livingEntity1.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (12 + 4 * EnchantmentHelper.m_44836_(Enchantments.f_44983_, livingEntity)) * 20, 0, false, true));
/*    */               } else {
/* 53 */                 livingEntity1.m_7292_(new MobEffectInstance(MobEffects.f_19597_, (9 + 3 * EnchantmentHelper.m_44836_(Enchantments.f_44983_, livingEntity)) * 20, 0, false, true));
/*    */               } 
/*    */               
/* 56 */               if (livingEntity1.m_21023_(MobEffects.f_19599_)) {
/* 57 */                 livingEntity1.m_21195_(MobEffects.f_19599_);
/* 58 */                 livingEntity1.m_7292_(new MobEffectInstance(MobEffects.f_19599_, (12 + 4 * EnchantmentHelper.m_44836_(Enchantments.f_44983_, livingEntity)) * 20, 0, false, true));
/*    */               } else {
/* 60 */                 livingEntity1.m_7292_(new MobEffectInstance(MobEffects.f_19599_, (9 + 3 * EnchantmentHelper.m_44836_(Enchantments.f_44983_, livingEntity)) * 20, 0, false, true));
/*    */               } 
/*    */               
/* 63 */               if (livingEntityPatch instanceof CEHumanoidPatch) { CEHumanoidPatch<?> ceHumanoidPatch = (CEHumanoidPatch)livingEntityPatch;
/* 64 */                 CEPatchUtils.setStamina((LivingEntityPatch)ceHumanoidPatch, CEPatchUtils.getStamina((LivingEntityPatch)ceHumanoidPatch) + CEPatchUtils.getMaxStamina((LivingEntityPatch)ceHumanoidPatch) * 0.05F); }
/*    */               
/* 66 */               ((LivingEntity)livingEntityPatch.getOriginal()).m_5634_((1 + EnchantmentHelper.m_44836_(Enchantments.f_44983_, livingEntity)));
/* 67 */               serverLevel.m_8767_((ParticleOptions)WOMParticles.ENDERBLASTER_BULLET.get(), livingEntity1.m_20185_(), livingEntity1.m_20186_() + 1.2000000476837158D, livingEntity1.m_20189_(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
/* 68 */               serverLevel.m_6263_(null, livingEntity1.m_20185_(), livingEntity1.m_20186_(), livingEntity1.m_20189_(), SoundEvents.f_11897_, livingEntity.m_5720_(), 1.0F, 0.5F);
/*    */             } 
/*    */           }  }
/*    */          }
/*    */     
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\EnderHandMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */