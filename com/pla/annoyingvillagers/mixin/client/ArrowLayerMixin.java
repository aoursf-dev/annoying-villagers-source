/*    */ package com.pla.annoyingvillagers.mixin.client;
/*    */ 
/*    */ import com.mojang.blaze3d.vertex.PoseStack;
/*    */ import com.pla.annoyingvillagers.entity.EnchantedArrowEntity;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*    */ import net.minecraft.client.model.PlayerModel;
/*    */ import net.minecraft.client.renderer.MultiBufferSource;
/*    */ import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
/*    */ import net.minecraft.client.renderer.entity.layers.ArrowLayer;
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
/*    */ @Mixin({ArrowLayer.class})
/*    */ public abstract class ArrowLayerMixin<T extends LivingEntity, M extends PlayerModel<T>>
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private EntityRenderDispatcher f_116562_;
/*    */   
/*    */   @Inject(method = {"renderStuckItem"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void av$renderColoredStuckArrow(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Entity entity, float x, float y, float z, float partialTick, CallbackInfo ci) {
/* 40 */     if (entity instanceof com.pla.annoyingvillagers.clazz.HerobrineMob) {
/* 41 */       float f = Mth.m_14116_(x * x + z * z);
/*    */ 
/*    */       
/* 44 */       EnchantedArrowEntity arrow = new EnchantedArrowEntity((EntityType)AnnoyingVillagersModEntities.ENCHANTED_ARROW.get(), entity.m_9236_());
/*    */       
/* 46 */       arrow.m_6034_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
/* 47 */       arrow.m_146922_((float)(Math.atan2(x, z) * 57.29577951308232D));
/* 48 */       arrow.m_146926_((float)(Math.atan2(y, f) * 57.29577951308232D));
/* 49 */       arrow.f_19859_ = arrow.m_146908_();
/* 50 */       arrow.f_19860_ = arrow.m_146909_();
/*    */       
/* 52 */       arrow.setColorGlint(annoyingVillagers$pickMode(entity, x, y, z));
/*    */       
/* 54 */       this.f_116562_.m_114384_((Entity)arrow, 0.0D, 0.0D, 0.0D, 0.0F, partialTick, poseStack, buffer, packedLight);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 64 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */   
/*    */   @Unique
/*    */   private static int annoyingVillagers$pickMode(Entity entity, float x, float y, float z) {
/* 70 */     int seed = entity.m_19879_();
/* 71 */     seed = 31 * seed + Float.floatToIntBits(x);
/* 72 */     seed = 31 * seed + Float.floatToIntBits(y);
/* 73 */     seed = 31 * seed + Float.floatToIntBits(z);
/*    */     
/* 75 */     switch (Math.floorMod(seed, 11)) { case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:  }  return 
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
/* 86 */       11;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\client\ArrowLayerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */