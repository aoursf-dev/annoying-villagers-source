/*    */ package com.pla.annoyingvillagers.util;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HerobrineEyesUtil
/*    */ {
/* 11 */   private static final ResourceLocation DEFAULT_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/default/default.png");
/*    */   
/* 13 */   private static final ResourceLocation DEFAULT_UP_1_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/default/up_1.png");
/*    */   
/* 15 */   private static final ResourceLocation DEFAULT_DOWN_1_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/default/down_1.png");
/*    */   
/* 17 */   private static final ResourceLocation SQUARE_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/square/default.png");
/*    */   
/* 19 */   private static final ResourceLocation SQUARE_DOWN_1_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/square/down_1.png");
/*    */   
/* 21 */   private static final ResourceLocation SQUARE_UP_1_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/square/up_1.png");
/*    */   
/* 23 */   private static final ResourceLocation SQUARE_UP_2_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/square/up_2.png");
/*    */   
/* 25 */   private static final ResourceLocation VERTICAL_FAR_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/vertical/default_far.png");
/*    */   
/* 27 */   private static final ResourceLocation VERTICAL_CLOSE_TEXTURE = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/vertical/default_close.png");
/*    */   
/* 29 */   private static final Map<String, ResourceLocation> eyeTextures = new HashMap<>();
/*    */   
/*    */   static {
/* 32 */     eyeTextures.put("Gory_Moon", DEFAULT_TEXTURE);
/* 33 */     eyeTextures.put("Darkosto", ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/vertical/far_down.png"));
/* 34 */     eyeTextures.put("016Nojr", DEFAULT_UP_1_TEXTURE);
/* 35 */     eyeTextures.put("BluSunrize", SQUARE_TEXTURE);
/* 36 */     eyeTextures.put("Buuz135", VERTICAL_FAR_TEXTURE);
/* 37 */     eyeTextures.put("Darkere", SQUARE_UP_1_TEXTURE);
/* 38 */     eyeTextures.put("Darkhax", DEFAULT_TEXTURE);
/* 39 */     eyeTextures.put("Drullkus", SQUARE_UP_1_TEXTURE);
/* 40 */     eyeTextures.put("Ellpeck", DEFAULT_DOWN_1_TEXTURE);
/* 41 */     eyeTextures.put("Emberwalker", DEFAULT_TEXTURE);
/* 42 */     eyeTextures.put("Gigabit101", SQUARE_UP_1_TEXTURE);
/* 43 */     eyeTextures.put("Kamefrede", SQUARE_TEXTURE);
/* 44 */     eyeTextures.put("KnightMiner_", DEFAULT_TEXTURE);
/* 45 */     eyeTextures.put("Lat", SQUARE_UP_1_TEXTURE);
/* 46 */     eyeTextures.put("LexManos", DEFAULT_TEXTURE);
/* 47 */     eyeTextures.put("Mrbysco", SQUARE_UP_2_TEXTURE);
/* 48 */     eyeTextures.put("P3pp3rF1y", SQUARE_UP_1_TEXTURE);
/* 49 */     eyeTextures.put("Ray", DEFAULT_TEXTURE);
/* 50 */     eyeTextures.put("Ridanis", SQUARE_DOWN_1_TEXTURE);
/* 51 */     eyeTextures.put("SOTMead", DEFAULT_TEXTURE);
/* 52 */     eyeTextures.put("ShyNieke", SQUARE_DOWN_1_TEXTURE);
/* 53 */     eyeTextures.put("SkySom", DEFAULT_TEXTURE);
/* 54 */     eyeTextures.put("Soaryn", DEFAULT_TEXTURE);
/* 55 */     eyeTextures.put("TamasHenning", SQUARE_UP_1_TEXTURE);
/* 56 */     eyeTextures.put("ValkyrieofNight", DEFAULT_UP_1_TEXTURE);
/* 57 */     eyeTextures.put("XCompWiz", DEFAULT_UP_1_TEXTURE);
/* 58 */     eyeTextures.put("cpw11", DEFAULT_TEXTURE);
/* 59 */     eyeTextures.put("darkphan", DEFAULT_TEXTURE);
/* 60 */     eyeTextures.put("direwolf20", DEFAULT_TEXTURE);
/* 61 */     eyeTextures.put("dmodoomsirius", SQUARE_UP_2_TEXTURE);
/* 62 */     eyeTextures.put("malte0811", DEFAULT_TEXTURE);
/* 63 */     eyeTextures.put("nekosune", ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/entities/herobrine_eyes/single/default_far_down_1.png"));
/* 64 */     eyeTextures.put("neptunepink", SQUARE_UP_1_TEXTURE);
/* 65 */     eyeTextures.put("vadis365", VERTICAL_CLOSE_TEXTURE);
/* 66 */     eyeTextures.put("wyld", DEFAULT_TEXTURE);
/* 67 */     eyeTextures.put("paulsoaresjr", DEFAULT_UP_1_TEXTURE);
/* 68 */     eyeTextures.put("Mhykol", DEFAULT_UP_1_TEXTURE);
/* 69 */     eyeTextures.put("Vswe", DEFAULT_TEXTURE);
/* 70 */     eyeTextures.put("TurkeyDev", DEFAULT_UP_1_TEXTURE);
/* 71 */     eyeTextures.put("Gen_Deathrow", DEFAULT_UP_1_TEXTURE);
/* 72 */     eyeTextures.put("Sevadus", DEFAULT_TEXTURE);
/* 73 */     eyeTextures.put("jeb_", DEFAULT_UP_1_TEXTURE);
/* 74 */     eyeTextures.put("Dinnerbone", DEFAULT_TEXTURE);
/* 75 */     eyeTextures.put("Grumm", SQUARE_UP_2_TEXTURE);
/* 76 */     eyeTextures.put("fry_", DEFAULT_TEXTURE);
/*    */   }
/*    */   
/*    */   public static ResourceLocation getHerobrineEyesTexture(String name) {
/* 80 */     return eyeTextures.getOrDefault(name, DEFAULT_TEXTURE);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\HerobrineEyesUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */