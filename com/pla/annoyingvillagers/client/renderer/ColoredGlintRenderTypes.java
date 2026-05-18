/*     */ package com.pla.annoyingvillagers.client.renderer;
/*     */ 
/*     */ import com.mojang.blaze3d.vertex.BufferBuilder;
/*     */ import com.mojang.blaze3d.vertex.DefaultVertexFormat;
/*     */ import com.mojang.blaze3d.vertex.VertexFormat;
/*     */ import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
/*     */ import net.minecraft.client.renderer.RenderStateShard;
/*     */ import net.minecraft.client.renderer.RenderType;
/*     */ import net.minecraft.resources.ResourceLocation;
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
/*     */ public final class ColoredGlintRenderTypes
/*     */   extends RenderType
/*     */ {
/*     */   private ColoredGlintRenderTypes(String name, VertexFormat vf, VertexFormat.Mode mode, int bufSize, boolean affectsCrumbling, boolean sortOnUpload, Runnable setup, Runnable clean) {
/*  34 */     super(name, vf, mode, bufSize, affectsCrumbling, sortOnUpload, setup, clean);
/*  35 */     throw new UnsupportedOperationException("Don't instantiate");
/*     */   }
/*     */   
/*     */   private static RenderType glintDirect(String suffix, ResourceLocation tex) {
/*  39 */     return (RenderType)RenderType.m_173215_("glint_direct_" + suffix, DefaultVertexFormat.f_85817_, VertexFormat.Mode.QUADS, 256, false, false, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  46 */         RenderType.CompositeState.m_110628_()
/*  47 */         .m_173292_(RenderStateShard.f_173082_)
/*  48 */         .m_173290_((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(tex, true, false))
/*  49 */         .m_110687_(RenderStateShard.f_110115_)
/*  50 */         .m_110661_(RenderStateShard.f_110110_)
/*  51 */         .m_110663_(RenderStateShard.f_110112_)
/*  52 */         .m_110685_(RenderStateShard.f_110137_)
/*  53 */         .m_110683_(RenderStateShard.f_110150_)
/*  54 */         .m_110691_(false));
/*     */   }
/*     */ 
/*     */   
/*     */   private static RenderType entityGlintDirect(String suffix, ResourceLocation tex) {
/*  59 */     return (RenderType)RenderType.m_173215_("entity_glint_direct_" + suffix, DefaultVertexFormat.f_85817_, VertexFormat.Mode.QUADS, 256, false, false, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  66 */         RenderType.CompositeState.m_110628_()
/*  67 */         .m_173292_(RenderStateShard.f_173084_)
/*  68 */         .m_173290_((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(tex, true, false))
/*  69 */         .m_110687_(RenderStateShard.f_110115_)
/*  70 */         .m_110661_(RenderStateShard.f_110110_)
/*  71 */         .m_110663_(RenderStateShard.f_110112_)
/*  72 */         .m_110685_(RenderStateShard.f_110137_)
/*  73 */         .m_110683_(RenderStateShard.f_110151_)
/*  74 */         .m_110691_(false));
/*     */   }
/*     */ 
/*     */   
/*     */   private static RenderType glint(String suffix, ResourceLocation tex) {
/*  79 */     return (RenderType)RenderType.m_173215_("glint_" + suffix, DefaultVertexFormat.f_85817_, VertexFormat.Mode.QUADS, 256, false, false, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  86 */         RenderType.CompositeState.m_110628_()
/*  87 */         .m_173292_(RenderStateShard.f_173081_)
/*  88 */         .m_173290_((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(tex, true, false))
/*  89 */         .m_110687_(RenderStateShard.f_110115_)
/*  90 */         .m_110661_(RenderStateShard.f_110110_)
/*  91 */         .m_110663_(RenderStateShard.f_110112_)
/*  92 */         .m_110685_(RenderStateShard.f_110137_)
/*  93 */         .m_110675_(RenderStateShard.f_110129_)
/*  94 */         .m_110683_(RenderStateShard.f_110150_)
/*  95 */         .m_110691_(false));
/*     */   }
/*     */ 
/*     */   
/*     */   private static RenderType entityGlint(String suffix, ResourceLocation tex) {
/* 100 */     return (RenderType)RenderType.m_173215_("entity_glint_" + suffix, DefaultVertexFormat.f_85817_, VertexFormat.Mode.QUADS, 256, false, false, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 107 */         RenderType.CompositeState.m_110628_()
/* 108 */         .m_173292_(RenderStateShard.f_173083_)
/* 109 */         .m_173290_((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(tex, true, false))
/* 110 */         .m_110687_(RenderStateShard.f_110115_)
/* 111 */         .m_110661_(RenderStateShard.f_110110_)
/* 112 */         .m_110663_(RenderStateShard.f_110112_)
/* 113 */         .m_110685_(RenderStateShard.f_110137_)
/* 114 */         .m_110675_(RenderStateShard.f_110129_)
/* 115 */         .m_110683_(RenderStateShard.f_110151_)
/* 116 */         .m_110691_(false));
/*     */   }
/*     */ 
/*     */   
/*     */   private static RenderType armorEntityGlint(String suffix, ResourceLocation tex) {
/* 121 */     return (RenderType)RenderType.m_173215_("armor_entity_glint_" + suffix, DefaultVertexFormat.f_85817_, VertexFormat.Mode.QUADS, 256, false, false, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 128 */         RenderType.CompositeState.m_110628_()
/* 129 */         .m_173292_(RenderStateShard.f_173079_)
/* 130 */         .m_173290_((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(tex, true, false))
/* 131 */         .m_110687_(RenderStateShard.f_110115_)
/* 132 */         .m_110661_(RenderStateShard.f_110110_)
/* 133 */         .m_110663_(RenderStateShard.f_110112_)
/* 134 */         .m_110685_(RenderStateShard.f_110137_)
/* 135 */         .m_110683_(RenderStateShard.f_110151_)
/* 136 */         .m_110669_(RenderStateShard.f_110119_)
/* 137 */         .m_110691_(false));
/*     */   }
/*     */ 
/*     */   
/*     */   public static RenderType getGlintDirect(int mode, RenderType fallback) {
/* 142 */     switch (mode) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:  }  return 
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
/* 154 */       fallback;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RenderType getEntityGlintDirect(int mode, RenderType fallback) {
/* 159 */     switch (mode) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:  }  return 
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
/* 171 */       fallback;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RenderType getGlint(int mode, RenderType fallback) {
/* 176 */     switch (mode) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:  }  return 
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
/* 188 */       fallback;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RenderType getEntityGlint(int mode, RenderType fallback) {
/* 193 */     switch (mode) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:  }  return 
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
/* 205 */       fallback;
/*     */   }
/*     */ 
/*     */   
/*     */   public static RenderType getArmorEntityGlint(int mode, RenderType fallback) {
/* 210 */     switch (mode) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:  }  return 
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
/* 222 */       fallback;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 227 */   private static final ResourceLocation ORANGE_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_orange.png");
/*     */ 
/*     */   
/* 230 */   private static final ResourceLocation CYAN_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_cyan.png");
/*     */ 
/*     */   
/* 233 */   private static final ResourceLocation BLUE_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_blue.png");
/*     */ 
/*     */   
/* 236 */   private static final ResourceLocation GREEN_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_green.png");
/*     */ 
/*     */   
/* 239 */   private static final ResourceLocation LIGHT_BLUE_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_light_blue.png");
/*     */ 
/*     */   
/* 242 */   private static final ResourceLocation LIME_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_lime.png");
/*     */ 
/*     */   
/* 245 */   private static final ResourceLocation MAGENTA_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_magenta.png");
/*     */ 
/*     */   
/* 248 */   private static final ResourceLocation PINK_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_pink.png");
/*     */ 
/*     */   
/* 251 */   private static final ResourceLocation PURPLE_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_purple.png");
/*     */ 
/*     */   
/* 254 */   private static final ResourceLocation RED_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_red.png");
/*     */ 
/*     */   
/* 257 */   private static final ResourceLocation YELLOW_TEX = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", "textures/glint/enchanted_item_glint_yellow.png");
/*     */   
/* 259 */   public static final RenderType GLINT_DIRECT_ORANGE = glintDirect("orange", ORANGE_TEX);
/* 260 */   public static final RenderType ENTITY_GLINT_DIRECT_ORANGE = entityGlintDirect("orange", ORANGE_TEX);
/* 261 */   public static final RenderType GLINT_ORANGE = glint("orange", ORANGE_TEX);
/* 262 */   public static final RenderType ENTITY_GLINT_ORANGE = entityGlint("orange", ORANGE_TEX);
/* 263 */   public static final RenderType ARMOR_ENTITY_GLINT_ORANGE = armorEntityGlint("orange", ORANGE_TEX);
/*     */   
/* 265 */   public static final RenderType GLINT_DIRECT_CYAN = glintDirect("cyan", CYAN_TEX);
/* 266 */   public static final RenderType ENTITY_GLINT_DIRECT_CYAN = entityGlintDirect("cyan", CYAN_TEX);
/* 267 */   public static final RenderType GLINT_CYAN = glint("cyan", CYAN_TEX);
/* 268 */   public static final RenderType ENTITY_GLINT_CYAN = entityGlint("cyan", CYAN_TEX);
/* 269 */   public static final RenderType ARMOR_ENTITY_GLINT_CYAN = armorEntityGlint("cyan", CYAN_TEX);
/*     */   
/* 271 */   public static final RenderType GLINT_DIRECT_BLUE = glintDirect("blue", BLUE_TEX);
/* 272 */   public static final RenderType ENTITY_GLINT_DIRECT_BLUE = entityGlintDirect("blue", BLUE_TEX);
/* 273 */   public static final RenderType GLINT_BLUE = glint("blue", BLUE_TEX);
/* 274 */   public static final RenderType ENTITY_GLINT_BLUE = entityGlint("blue", BLUE_TEX);
/* 275 */   public static final RenderType ARMOR_ENTITY_GLINT_BLUE = armorEntityGlint("blue", BLUE_TEX);
/*     */   
/* 277 */   public static final RenderType GLINT_DIRECT_GREEN = glintDirect("green", GREEN_TEX);
/* 278 */   public static final RenderType ENTITY_GLINT_DIRECT_GREEN = entityGlintDirect("green", GREEN_TEX);
/* 279 */   public static final RenderType GLINT_GREEN = glint("green", GREEN_TEX);
/* 280 */   public static final RenderType ENTITY_GLINT_GREEN = entityGlint("green", GREEN_TEX);
/* 281 */   public static final RenderType ARMOR_ENTITY_GLINT_GREEN = armorEntityGlint("green", GREEN_TEX);
/*     */   
/* 283 */   public static final RenderType GLINT_DIRECT_LIGHT_BLUE = glintDirect("light_blue", LIGHT_BLUE_TEX);
/* 284 */   public static final RenderType ENTITY_GLINT_DIRECT_LIGHT_BLUE = entityGlintDirect("light_blue", LIGHT_BLUE_TEX);
/* 285 */   public static final RenderType GLINT_LIGHT_BLUE = glint("light_blue", LIGHT_BLUE_TEX);
/* 286 */   public static final RenderType ENTITY_GLINT_LIGHT_BLUE = entityGlint("light_blue", LIGHT_BLUE_TEX);
/* 287 */   public static final RenderType ARMOR_ENTITY_GLINT_LIGHT_BLUE = armorEntityGlint("light_blue", LIGHT_BLUE_TEX);
/*     */   
/* 289 */   public static final RenderType GLINT_DIRECT_LIME = glintDirect("lime", LIME_TEX);
/* 290 */   public static final RenderType ENTITY_GLINT_DIRECT_LIME = entityGlintDirect("lime", LIME_TEX);
/* 291 */   public static final RenderType GLINT_LIME = glint("lime", LIME_TEX);
/* 292 */   public static final RenderType ENTITY_GLINT_LIME = entityGlint("lime", LIME_TEX);
/* 293 */   public static final RenderType ARMOR_ENTITY_GLINT_LIME = armorEntityGlint("lime", LIME_TEX);
/*     */   
/* 295 */   public static final RenderType GLINT_DIRECT_MAGENTA = glintDirect("magenta", MAGENTA_TEX);
/* 296 */   public static final RenderType ENTITY_GLINT_DIRECT_MAGENTA = entityGlintDirect("magenta", MAGENTA_TEX);
/* 297 */   public static final RenderType GLINT_MAGENTA = glint("magenta", MAGENTA_TEX);
/* 298 */   public static final RenderType ENTITY_GLINT_MAGENTA = entityGlint("magenta", MAGENTA_TEX);
/* 299 */   public static final RenderType ARMOR_ENTITY_GLINT_MAGENTA = armorEntityGlint("magenta", MAGENTA_TEX);
/*     */   
/* 301 */   public static final RenderType GLINT_DIRECT_PINK = glintDirect("pink", PINK_TEX);
/* 302 */   public static final RenderType ENTITY_GLINT_DIRECT_PINK = entityGlintDirect("pink", PINK_TEX);
/* 303 */   public static final RenderType GLINT_PINK = glint("pink", PINK_TEX);
/* 304 */   public static final RenderType ENTITY_GLINT_PINK = entityGlint("pink", PINK_TEX);
/* 305 */   public static final RenderType ARMOR_ENTITY_GLINT_PINK = armorEntityGlint("pink", PINK_TEX);
/*     */   
/* 307 */   public static final RenderType GLINT_DIRECT_PURPLE = glintDirect("purple", PURPLE_TEX);
/* 308 */   public static final RenderType ENTITY_GLINT_DIRECT_PURPLE = entityGlintDirect("purple", PURPLE_TEX);
/* 309 */   public static final RenderType GLINT_PURPLE = glint("purple", PURPLE_TEX);
/* 310 */   public static final RenderType ENTITY_GLINT_PURPLE = entityGlint("purple", PURPLE_TEX);
/* 311 */   public static final RenderType ARMOR_ENTITY_GLINT_PURPLE = armorEntityGlint("purple", PURPLE_TEX);
/*     */   
/* 313 */   public static final RenderType GLINT_DIRECT_RED = glintDirect("red", RED_TEX);
/* 314 */   public static final RenderType ENTITY_GLINT_DIRECT_RED = entityGlintDirect("red", RED_TEX);
/* 315 */   public static final RenderType GLINT_RED = glint("red", RED_TEX);
/* 316 */   public static final RenderType ENTITY_GLINT_RED = entityGlint("red", RED_TEX);
/* 317 */   public static final RenderType ARMOR_ENTITY_GLINT_RED = armorEntityGlint("red", RED_TEX);
/*     */   
/* 319 */   public static final RenderType GLINT_DIRECT_YELLOW = glintDirect("yellow", YELLOW_TEX);
/* 320 */   public static final RenderType ENTITY_GLINT_DIRECT_YELLOW = entityGlintDirect("yellow", YELLOW_TEX);
/* 321 */   public static final RenderType GLINT_YELLOW = glint("yellow", YELLOW_TEX);
/* 322 */   public static final RenderType ENTITY_GLINT_YELLOW = entityGlint("yellow", YELLOW_TEX);
/* 323 */   public static final RenderType ARMOR_ENTITY_GLINT_YELLOW = armorEntityGlint("yellow", YELLOW_TEX);
/*     */   
/*     */   public static void registerIntoFixed(Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder> map) {
/* 326 */     put(map, new RenderType[] { GLINT_DIRECT_ORANGE, ENTITY_GLINT_DIRECT_ORANGE, GLINT_ORANGE, ENTITY_GLINT_ORANGE, ARMOR_ENTITY_GLINT_ORANGE, GLINT_DIRECT_CYAN, ENTITY_GLINT_DIRECT_CYAN, GLINT_CYAN, ENTITY_GLINT_CYAN, ARMOR_ENTITY_GLINT_CYAN, GLINT_DIRECT_BLUE, ENTITY_GLINT_DIRECT_BLUE, GLINT_BLUE, ENTITY_GLINT_BLUE, ARMOR_ENTITY_GLINT_BLUE, GLINT_DIRECT_GREEN, ENTITY_GLINT_DIRECT_GREEN, GLINT_GREEN, ENTITY_GLINT_GREEN, ARMOR_ENTITY_GLINT_GREEN, GLINT_DIRECT_LIGHT_BLUE, ENTITY_GLINT_DIRECT_LIGHT_BLUE, GLINT_LIGHT_BLUE, ENTITY_GLINT_LIGHT_BLUE, ARMOR_ENTITY_GLINT_LIGHT_BLUE, GLINT_DIRECT_LIME, ENTITY_GLINT_DIRECT_LIME, GLINT_LIME, ENTITY_GLINT_LIME, ARMOR_ENTITY_GLINT_LIME, GLINT_DIRECT_MAGENTA, ENTITY_GLINT_DIRECT_MAGENTA, GLINT_MAGENTA, ENTITY_GLINT_MAGENTA, ARMOR_ENTITY_GLINT_MAGENTA, GLINT_DIRECT_PINK, ENTITY_GLINT_DIRECT_PINK, GLINT_PINK, ENTITY_GLINT_PINK, ARMOR_ENTITY_GLINT_PINK, GLINT_DIRECT_PURPLE, ENTITY_GLINT_DIRECT_PURPLE, GLINT_PURPLE, ENTITY_GLINT_PURPLE, ARMOR_ENTITY_GLINT_PURPLE, GLINT_DIRECT_RED, ENTITY_GLINT_DIRECT_RED, GLINT_RED, ENTITY_GLINT_RED, ARMOR_ENTITY_GLINT_RED, GLINT_DIRECT_YELLOW, ENTITY_GLINT_DIRECT_YELLOW, GLINT_YELLOW, ENTITY_GLINT_YELLOW, ARMOR_ENTITY_GLINT_YELLOW });
/*     */   }
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
/*     */   private static void put(Object2ObjectLinkedOpenHashMap<RenderType, BufferBuilder> map, RenderType... types) {
/* 342 */     for (RenderType rt : types) {
/* 343 */       if (!map.containsKey(rt))
/* 344 */         map.put(rt, new BufferBuilder(rt.m_110507_())); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\renderer\ColoredGlintRenderTypes.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */