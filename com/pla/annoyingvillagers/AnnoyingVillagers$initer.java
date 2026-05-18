/*     */ package com.pla.annoyingvillagers;
/*     */ 
/*     */ import com.pla.annoyingvillagers.network.CPApplyShake;
/*     */ import com.pla.annoyingvillagers.network.ClientboundGlaiveExplosionFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundHerobrinePortalFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundLitePortalFx;
/*     */ import com.pla.annoyingvillagers.network.ClientboundMuteExplosionAtPos;
/*     */ import com.pla.annoyingvillagers.network.ClientboundWoopieSwordWindFx;
/*     */ import java.util.function.Function;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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
/*     */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
/*     */ public class initer
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void init(FMLCommonSetupEvent fmlCommonSetupEvent) {
/* 105 */     AnnoyingVillagers.addNetworkMessage(ClientboundGlaiveExplosionFx.class, ClientboundGlaiveExplosionFx::encode, ClientboundGlaiveExplosionFx::decode, ClientboundGlaiveExplosionFx::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     AnnoyingVillagers.addNetworkMessage(ClientboundMuteExplosionAtPos.class, ClientboundMuteExplosionAtPos::encode, ClientboundMuteExplosionAtPos::decode, ClientboundMuteExplosionAtPos::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     AnnoyingVillagers.addNetworkMessage(ClientboundHerobrinePortalFx.class, ClientboundHerobrinePortalFx::encode, ClientboundHerobrinePortalFx::decode, ClientboundHerobrinePortalFx::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     AnnoyingVillagers.addNetworkMessage(ClientboundWoopieSwordWindFx.class, ClientboundWoopieSwordWindFx::encode, ClientboundWoopieSwordWindFx::decode, ClientboundWoopieSwordWindFx::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     AnnoyingVillagers.addNetworkMessage(ClientboundLitePortalFx.class, ClientboundLitePortalFx::encode, ClientboundLitePortalFx::decode, ClientboundLitePortalFx::handle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     AnnoyingVillagers.addNetworkMessage(CPApplyShake.class, CPApplyShake::encode, CPApplyShake::new, CPApplyShake::handle);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\AnnoyingVillagers$initer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */