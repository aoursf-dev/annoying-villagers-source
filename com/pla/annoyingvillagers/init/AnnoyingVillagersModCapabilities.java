/*    */ package com.pla.annoyingvillagers.init;
/*    */ 
/*    */ import com.pla.annoyingvillagers.capabilities.SnakeBladeCapability;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraftforge.common.capabilities.Capability;
/*    */ import net.minecraftforge.common.capabilities.CapabilityManager;
/*    */ import net.minecraftforge.common.capabilities.CapabilityToken;
/*    */ import net.minecraftforge.common.capabilities.ICapabilityProvider;
/*    */ import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
/*    */ import net.minecraftforge.event.AttachCapabilitiesEvent;
/*    */ 
/*    */ 
/*    */ public final class AnnoyingVillagersModCapabilities
/*    */ {
/* 16 */   public static final Capability<SnakeBladeCapability.ISnakeBladeCapability> SNAKE_BLADE_CAPABILITY = CapabilityManager.get(new CapabilityToken<SnakeBladeCapability.ISnakeBladeCapability>() {
/*    */       
/*    */       });
/*    */   
/*    */   public static void registerCapabilities(RegisterCapabilitiesEvent event) {
/* 21 */     event.register(SnakeBladeCapability.ISnakeBladeCapability.class);
/*    */   }
/*    */   
/*    */   public static void attachEntityCapability(AttachCapabilitiesEvent<Entity> event) {
/* 25 */     if (event.getObject() instanceof net.minecraft.world.entity.LivingEntity) {
/* 26 */       event.addCapability(SnakeBladeCapability.ID, (ICapabilityProvider)new SnakeBladeCapability.SnakeBladeProvider());
/*    */     }
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static <T> T getCapability(@Nullable Entity entity, Capability<T> capability) {
/* 32 */     if (entity == null || !entity.m_6084_()) return null; 
/* 33 */     return (T)entity.getCapability(capability).orElse(null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModCapabilities.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */