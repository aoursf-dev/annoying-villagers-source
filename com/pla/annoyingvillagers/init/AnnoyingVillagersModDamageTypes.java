/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.RegistryAccess;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.damagesource.DamageType;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class AnnoyingVillagersModDamageTypes
/*    */ {
/* 15 */   public static final ResourceKey<DamageType> IMPACT_EXPLOSION = ResourceKey.m_135785_(Registries.f_268580_, 
/*    */       
/* 17 */       ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "impact_explosion"));
/*    */   
/*    */   public static class Sources
/*    */   {
/*    */     private static Holder.Reference<DamageType> getHolder(RegistryAccess access, ResourceKey<DamageType> key) {
/* 22 */       return access.m_175515_(Registries.f_268580_).m_246971_(key);
/*    */     }
/*    */     
/*    */     public static DamageSource impactExplosion(RegistryAccess access, Entity directEntity) {
/* 26 */       return new DamageSource((Holder)getHolder(access, AnnoyingVillagersModDamageTypes.IMPACT_EXPLOSION), directEntity, null);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModDamageTypes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */