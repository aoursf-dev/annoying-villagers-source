/*    */ package com.pla.annoyingvillagers.init;
/*    */ import com.pla.annoyingvillagers.client.model.ModelBlueDemonTrident;
/*    */ import com.pla.annoyingvillagers.client.model.ModelGreenVillagerGeneralArmor;
/*    */ import com.pla.annoyingvillagers.client.model.ModelHerobrineWarden;
/*    */ import com.pla.annoyingvillagers.client.model.ModelSnakeBlade;
/*    */ import com.pla.annoyingvillagers.client.model.ModelSnakeBladeFragment;
/*    */ import net.minecraftforge.client.event.EntityRenderersEvent;
/*    */ 
/*    */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
/*    */ public class AnnoyingVillagersModModels {
/*    */   @SubscribeEvent
/*    */   public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions registerlayerdefinitions) {
/* 13 */     registerlayerdefinitions.registerLayerDefinition(ModelVillagerScoutHelmet.LAYER_LOCATION, ModelVillagerScoutHelmet::createBodyLayer);
/* 14 */     registerlayerdefinitions.registerLayerDefinition(ModelBlueDemonTrident.LAYER_LOCATION, ModelBlueDemonTrident::createBodyLayer);
/* 15 */     registerlayerdefinitions.registerLayerDefinition(ModelGreenVillagerGeneralArmor.LAYER_LOCATION, ModelGreenVillagerGeneralArmor::createBodyLayer);
/* 16 */     registerlayerdefinitions.registerLayerDefinition(ModelVillagerGeneralArmor.LAYER_LOCATION, ModelVillagerGeneralArmor::createBodyLayer);
/* 17 */     registerlayerdefinitions.registerLayerDefinition(ModelHerobrineObsidianDiamondHelmet.LAYER_LOCATION, ModelHerobrineObsidianDiamondHelmet::createBodyLayer);
/* 18 */     registerlayerdefinitions.registerLayerDefinition(ModelHerobrineObsidianDiamondChestplate.LAYER_LOCATION, ModelHerobrineObsidianDiamondChestplate::createBodyLayer);
/* 19 */     registerlayerdefinitions.registerLayerDefinition(ModelSnakeBladeFragment.LAYER_LOCATION, ModelSnakeBladeFragment::createBodyLayer);
/* 20 */     registerlayerdefinitions.registerLayerDefinition(ModelSnakeBlade.LAYER_LOCATION, ModelSnakeBlade::createBodyLayer);
/* 21 */     registerlayerdefinitions.registerLayerDefinition(ModelHerobrineWarden.LAYER_LOCATION, ModelHerobrineWarden::m_233537_);
/* 22 */     registerlayerdefinitions.registerLayerDefinition(ModelHerobrineDragon.LAYER_LOCATION, ModelHerobrineDragon::createBodyLayer);
/* 23 */     registerlayerdefinitions.registerLayerDefinition(ModelDragonMeteorite.LAYER_LOCATION, ModelDragonMeteorite::createBodyLayer);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\init\AnnoyingVillagersModModels.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */