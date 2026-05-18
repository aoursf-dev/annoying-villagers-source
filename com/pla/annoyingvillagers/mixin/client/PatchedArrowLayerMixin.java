/*    */ package com.pla.annoyingvillagers.mixin.client;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.pla.annoyingvillagers.entity.EnchantedArrowEntity;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*    */ import net.minecraft.client.model.PlayerModel;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import yesman.epicfight.client.renderer.patched.layer.PatchedArrowLayer;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {PatchedArrowLayer.class}, remap = false)
/*    */ public abstract class PatchedArrowLayerMixin<E extends LivingEntity, T extends LivingEntityPatch<E>, M extends PlayerModel<E>>
/*    */ {
/*    */   @Final
/*    */   @Shadow
/*    */   private EntityRenderDispatcher dispatcher;
/*    */   
/*    */   @Inject(method = {"renderStuckItem"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void av$renderColoredStuckArrow(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Entity entity, float f1, float f2, float f3, float partialTick, CallbackInfo ci) {
/* 39 */     if (entity instanceof com.pla.annoyingvillagers.clazz.HerobrineMob) {
/* 40 */       float f = Mth.m_14116_(f1 * f1 + f3 * f3);
/*    */ 
/*    */       
/* 43 */       EnchantedArrowEntity arrow = new EnchantedArrowEntity((EntityType)AnnoyingVillagersModEntities.ENCHANTED_ARROW.get(), entity.m_9236_());
/*    */       
/* 45 */       arrow.m_6034_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
/* 46 */       arrow.m_146922_((float)(Math.atan2(f1, f3) * 57.2957763671875D));
/* 47 */       arrow.m_146926_((float)(Math.atan2(f2, f) * 57.2957763671875D));
/* 48 */       arrow.f_19859_ = arrow.m_146908_();
/* 49 */       arrow.f_19860_ = arrow.m_146909_();
/*    */       
/* 51 */       arrow.setColorGlint(annoyingVillagers$pickMode(entity, f1, f2, f3));
/*    */       
/* 53 */       this.dispatcher.m_114384_((Entity)arrow, 0.0D, 0.0D, 0.0D, 0.0F, partialTick, poseStack, buffer, packedLight);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 63 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */   
/*    */   @Unique
/*    */   private static int annoyingVillagers$pickMode(Entity entity, float x, float y, float z) {
/* 69 */     int seed = entity.m_19879_();
/* 70 */     seed = 31 * seed + Float.floatToIntBits(x);
/* 71 */     seed = 31 * seed + Float.floatToIntBits(y);
/* 72 */     seed = 31 * seed + Float.floatToIntBits(z);
/*    */     
/* 74 */     switch (Math.floorMod(seed, 11)) { case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:  }  return 
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
/* 85 */       11;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\client\PatchedArrowLayerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */