/*     */ package com.pla.annoyingvillagers.util;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GlintColorHelper
/*     */ {
/*     */   public static final String TAG_COLOR_GLINT = "ColorGlint";
/*     */   public static final int NONE = 0;
/*     */   public static final int ORANGE = 1;
/*     */   public static final int CYAN = 2;
/*     */   public static final int BLUE = 3;
/*     */   public static final int GREEN = 4;
/*     */   public static final int LIGHT_BLUE = 5;
/*     */   public static final int LIME = 6;
/*     */   public static final int MAGENTA = 7;
/*     */   public static final int PINK = 8;
/*     */   public static final int PURPLE = 9;
/*     */   public static final int RED = 10;
/*     */   public static final int YELLOW = 11;
/*     */   
/*     */   public static int getRandomColor() {
/*  31 */     switch ((new Random()).nextInt(11)) { case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:  }  return 
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
/*  42 */       11;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vec3 getParticleColor(int mode) {
/*  47 */     switch (mode) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:  }  return 
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
/*  59 */       new Vec3(0.5D, 0.5D, 0.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setColor(ItemStack stack, int mode) {
/*  64 */     if (stack.m_41619_()) {
/*     */       return;
/*     */     }
/*     */     
/*  68 */     if (mode == 0) {
/*  69 */       CompoundTag tag = stack.m_41783_();
/*  70 */       if (tag != null) {
/*  71 */         tag.m_128473_("ColorGlint");
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*  76 */     stack.m_41784_().m_128359_("ColorGlint", toName(mode));
/*     */   }
/*     */   
/*     */   public static void clearColor(ItemStack stack) {
/*  80 */     if (!stack.m_41782_()) {
/*     */       return;
/*     */     }
/*     */     
/*  84 */     stack.m_41783_().m_128473_("ColorGlint");
/*     */     
/*  86 */     if (stack.m_41783_().m_128456_()) {
/*  87 */       stack.m_41751_(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public static int getColor(ItemStack stack) {
/*  92 */     CompoundTag tag = stack.m_41783_();
/*  93 */     if (tag == null) {
/*  94 */       return 0;
/*     */     }
/*     */     
/*  97 */     if (tag.m_128425_("ColorGlint", 3)) {
/*  98 */       return sanitize(tag.m_128451_("ColorGlint"));
/*     */     }
/*     */     
/* 101 */     if (tag.m_128425_("ColorGlint", 8)) {
/* 102 */       return fromName(tag.m_128461_("ColorGlint"));
/*     */     }
/*     */     
/* 105 */     return 0;
/*     */   }
/*     */   
/*     */   public static boolean hasColor(ItemStack stack) {
/* 109 */     return (getColor(stack) != 0);
/*     */   }
/*     */   
/*     */   public static int sanitize(int mode) {
/* 113 */     return (mode >= 0 && mode <= 11) ? mode : 0;
/*     */   }
/*     */   
/*     */   public static int fromName(String name) {
/* 117 */     switch (name) { case "orange": case "cyan": case "blue": case "green": case "light_blue": case "lime": case "magenta": case "pink": case "purple": case "red": case "yellow":  }  return 
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
/* 129 */       0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String toName(int mode) {
/* 134 */     switch (mode) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:  }  return 
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
/* 146 */       "";
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\GlintColorHelper.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */