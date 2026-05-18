/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModDamageTypes;
/*    */ import net.minecraft.tags.DamageTypeTags;
/*    */ import net.minecraft.tags.TagKey;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.damagesource.DamageType;
/*    */ import net.minecraft.world.entity.player.Player;
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
/*    */ @Mixin({Player.class})
/*    */ public abstract class PlayerMixin
/*    */ {
/*    */   @Redirect(method = {"hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/damagesource/DamageSource;is(Lnet/minecraft/tags/TagKey;)Z", ordinal = 0))
/*    */   private boolean customBypassInvulnerability(DamageSource source, TagKey<DamageType> tag) {
/* 26 */     Player self = (Player)this;
/* 27 */     boolean original = source.m_269533_(tag);
/*    */     
/* 29 */     if (DamageTypeTags.f_268738_.equals(tag) && 
/* 30 */       (self.m_150110_()).f_35934_ && source
/* 31 */       .m_276093_(AnnoyingVillagersModDamageTypes.IMPACT_EXPLOSION) && source
/* 32 */       .m_7640_() instanceof com.pla.annoyingvillagers.entity.TridentLightningBolt) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     return original;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\PlayerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */