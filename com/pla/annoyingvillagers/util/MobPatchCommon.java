/*     */ package com.pla.annoyingvillagers.util;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcAxe;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcDagger;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcLongsword;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcSpear;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.PlayerNpcSword;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import net.minecraft.world.item.Item;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.capabilities.item.Style;
/*     */ 
/*     */ public class MobPatchCommon {
/*     */   public static CECombatBehaviors.Builder<MobPatch<?>> overideCustomWeaponMotionBuilderForPlayerNpc(CapabilityItem mainHandCap, Style style) {
/*  15 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)WOMItems.DIAMOND_STAFF.get()).m_7968_()) && 
/*  16 */       style == CapabilityItem.Styles.TWO_HAND) {
/*  17 */       return PlayerNpcStaff.STAFF;
/*     */     }
/*     */ 
/*     */     
/*  21 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)WOMItems.GOLDEN_STAFF.get()).m_7968_()) && 
/*  22 */       style == CapabilityItem.Styles.TWO_HAND) {
/*  23 */       return PlayerNpcStaff.STAFF;
/*     */     }
/*     */ 
/*     */     
/*  27 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)WOMItems.IRON_STAFF.get()).m_7968_()) && 
/*  28 */       style == CapabilityItem.Styles.TWO_HAND) {
/*  29 */       return PlayerNpcStaff.STAFF;
/*     */     }
/*     */ 
/*     */     
/*  33 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)WOMItems.STONE_STAFF.get()).m_7968_()) && 
/*  34 */       style == CapabilityItem.Styles.TWO_HAND) {
/*  35 */       return PlayerNpcStaff.STAFF;
/*     */     }
/*     */ 
/*     */     
/*  39 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)WOMItems.WOODEN_STAFF.get()).m_7968_()) && 
/*  40 */       style == CapabilityItem.Styles.TWO_HAND) {
/*  41 */       return PlayerNpcStaff.STAFF;
/*     */     }
/*     */ 
/*     */     
/*  45 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.BLACK_FIRE_SWORD.get()).m_7968_())) {
/*  46 */       if (style == CapabilityItem.Styles.ONE_HAND)
/*  47 */         return PlayerNpcSword.AV_SWORD; 
/*  48 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/*  49 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/*  53 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.BLUE_FLAME_SWORD.get()).m_7968_())) {
/*  54 */       if (style == CapabilityItem.Styles.ONE_HAND)
/*  55 */         return PlayerNpcSword.AV_SWORD; 
/*  56 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/*  57 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/*  61 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.CENTRANOS_SWORD.get()).m_7968_()) && 
/*  62 */       style == CapabilityItem.Styles.TWO_HAND) {
/*  63 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/*  67 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.CLOW_SWORD.get()).m_7968_())) {
/*  68 */       if (style == CapabilityItem.Styles.ONE_HAND)
/*  69 */         return PlayerNpcSword.AV_SWORD; 
/*  70 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/*  71 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/*  75 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_ATTRACTOR_SWORD.get()).m_7968_())) {
/*  76 */       if (style == CapabilityItem.Styles.ONE_HAND)
/*  77 */         return PlayerNpcSword.AV_SWORD; 
/*  78 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/*  79 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/*  83 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_BLASTER_SWORD.get()).m_7968_())) {
/*  84 */       if (style == CapabilityItem.Styles.ONE_HAND)
/*  85 */         return PlayerNpcSword.AV_SWORD; 
/*  86 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/*  87 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/*  91 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_DURANDAL.get()).m_7968_()) && 
/*  92 */       style == CapabilityItem.Styles.TWO_HAND) {
/*  93 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/*  97 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_WARBLADE.get()).m_7968_())) {
/*  98 */       return PlayerNpcTachi.AV_TACHI;
/*     */     }
/*     */     
/* 101 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_FALCHION.get()).m_7968_())) {
/* 102 */       return PlayerNpcTachi.AV_TACHI;
/*     */     }
/*     */     
/* 105 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_GREAT_FALCHION.get()).m_7968_())) {
/* 106 */       return PlayerNpcTachi.AV_TACHI;
/*     */     }
/*     */     
/* 109 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_SABRE.get()).m_7968_())) {
/* 110 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 111 */         return PlayerNpcSword.AV_SWORD; 
/* 112 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 113 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 117 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.HOOKED_IRON_SWORD.get()).m_7968_())) {
/* 118 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 119 */         return PlayerNpcDagger.DAGGER; 
/* 120 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 121 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 125 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.HOOKED_GOLDEN_SWORD.get()).m_7968_())) {
/* 126 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 127 */         return PlayerNpcDagger.DAGGER; 
/* 128 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 129 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 133 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.HOOKED_IRON_SWORD.get()).m_7968_())) {
/* 134 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 135 */         return PlayerNpcDagger.DAGGER; 
/* 136 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 137 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 141 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.IRON_CLEAVER.get()).m_7968_()) && 
/* 142 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 143 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/* 147 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_LAEVATEINN.get()).m_7968_())) {
/* 148 */       return PlayerNpcTachi.AV_TACHI;
/*     */     }
/*     */     
/* 151 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_LONGSWORD.get()).m_7968_())) {
/* 152 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 153 */         return PlayerNpcLongsword.AV_LONGSWORD_SHIELD; 
/* 154 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 155 */         return PlayerNpcLongsword.AV_LONGSWORD;
/*     */       }
/*     */     } 
/*     */     
/* 159 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.GOLDEN_LONGSWORD.get()).m_7968_())) {
/* 160 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 161 */         return PlayerNpcLongsword.AV_LONGSWORD_SHIELD; 
/* 162 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 163 */         return PlayerNpcLongsword.AV_LONGSWORD;
/*     */       }
/*     */     } 
/*     */     
/* 167 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.IRON_LONGSWORD.get()).m_7968_())) {
/* 168 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 169 */         return PlayerNpcLongsword.AV_LONGSWORD_SHIELD; 
/* 170 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 171 */         return PlayerNpcLongsword.AV_LONGSWORD;
/*     */       }
/*     */     } 
/*     */     
/* 175 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_CHIPPED_LONGSWORD.get()).m_7968_())) {
/* 176 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 177 */         return PlayerNpcLongsword.AV_LONGSWORD_SHIELD; 
/* 178 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 179 */         return PlayerNpcLongsword.AV_LONGSWORD;
/*     */       }
/*     */     } 
/*     */     
/* 183 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_GREATSWORD.get()).m_7968_()) && 
/* 184 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 185 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/* 189 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DNAX_HOOKED_SWORD.get()).m_7968_())) {
/* 190 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 191 */         return PlayerNpcSword.AV_SWORD; 
/* 192 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 193 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 197 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.FLANKER_HOOKED_SWORD.get()).m_7968_())) {
/* 198 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 199 */         return PlayerNpcSword.AV_SWORD; 
/* 200 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 201 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 205 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.IRON_TWIN_BLADE_KATANA.get()).m_7968_()) && 
/* 206 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 207 */       return PlayerNpcStaff.STAFF;
/*     */     }
/*     */ 
/*     */     
/* 211 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.PALADIN_SWORD.get()).m_7968_())) {
/* 212 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 213 */         return PlayerNpcSword.AV_SWORD; 
/* 214 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 215 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 219 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.RUBY_GREATSWORD.get()).m_7968_()) && 
/* 220 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 221 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/* 225 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.RUBY_LONGSWORD.get()).m_7968_())) {
/* 226 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 227 */         return PlayerNpcLongsword.AV_LONGSWORD_SHIELD; 
/* 228 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 229 */         return PlayerNpcLongsword.AV_LONGSWORD;
/*     */       }
/*     */     } 
/*     */     
/* 233 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.RUBY_KNIGHT_SWORD.get()).m_7968_())) {
/* 234 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 235 */         return PlayerNpcSword.AV_SWORD; 
/* 236 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 237 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 241 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.RUBY_SWORD.get()).m_7968_())) {
/* 242 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 243 */         return PlayerNpcSword.AV_SWORD; 
/* 244 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 245 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 249 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.THUNDER_DIAMOND_BLADE.get()).m_7968_())) {
/* 250 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 251 */         return PlayerNpcSword.AV_SWORD; 
/* 252 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 253 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 257 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.JADE_SWORD.get()).m_7968_())) {
/* 258 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 259 */         return PlayerNpcSword.AV_SWORD; 
/* 260 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 261 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 265 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.RED_DIAMOND_SWORD.get()).m_7968_())) {
/* 266 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 267 */         return PlayerNpcSword.AV_SWORD; 
/* 268 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 269 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 273 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.WOOPIE_THE_SWORD.get()).m_7968_())) {
/* 274 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 275 */         return PlayerNpcSword.AV_SWORD; 
/* 276 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 277 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 281 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.NETHERITE_GREATBLADE.get()).m_7968_())) {
/* 282 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 283 */         return PlayerNpcSword.AV_SWORD; 
/* 284 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 285 */         return PlayerNpcSword.AV_DUAL_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 289 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.NETHERITE_FALCHION.get()).m_7968_())) {
/* 290 */       return PlayerNpcTachi.AV_TACHI;
/*     */     }
/*     */     
/* 293 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_HALBERD.get()).m_7968_()) && 
/* 294 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 295 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 299 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_GREATAXE.get()).m_7968_()) && 
/* 300 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 301 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/* 305 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_BATTLEAXE.get()).m_7968_()) && 
/* 306 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 307 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/* 311 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.EARTH_AXE.get()).m_7968_()) && 
/* 312 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 313 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 317 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.EXTERMINATOR_BATTLEAXE.get()).m_7968_()) && 
/* 318 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 319 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 323 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.GIANT_NETHERITE_AXE.get()).m_7968_()) && 
/* 324 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 325 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/* 329 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.RED_AXE.get()).m_7968_()) && 
/* 330 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 331 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 335 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.IRON_DOUBLE_BLADED_HALBERD.get()).m_7968_())) {
/* 336 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 337 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 338 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 339 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 343 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.IRON_GREATAXE.get()).m_7968_()) && 
/* 344 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 345 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 349 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.IRON_HALBERD.get()).m_7968_()) && 
/* 350 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 351 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 355 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.NETHERITE_GREATAXE.get()).m_7968_()) && 
/* 356 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 357 */       return PlayerNpcGreatsword.AV_GREATSWORD;
/*     */     }
/*     */ 
/*     */     
/* 361 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.SAMANTHA_THE_KILLER_AXE.get()).m_7968_()) && 
/* 362 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 363 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 367 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.SPEAR_AXE.get()).m_7968_())) {
/* 368 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 369 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 370 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 371 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 375 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_ARMBLADE.get()).m_7968_())) {
/* 376 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 377 */         return PlayerNpcDagger.DAGGER; 
/* 378 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 379 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 383 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_DAGGER.get()).m_7968_())) {
/* 384 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 385 */         return PlayerNpcDagger.DAGGER; 
/* 386 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 387 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 391 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.KNIFE.get()).m_7968_())) {
/* 392 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 393 */         return PlayerNpcDagger.DAGGER; 
/* 394 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 395 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 399 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.GOLDEN_MOON_BLADE.get()).m_7968_())) {
/* 400 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 401 */         return PlayerNpcDagger.DAGGER; 
/* 402 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 403 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 407 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_MOON_BLADE.get()).m_7968_())) {
/* 408 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 409 */         return PlayerNpcDagger.DAGGER; 
/* 410 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 411 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 415 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.NETHERITE_KNIFE.get()).m_7968_())) {
/* 416 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 417 */         return PlayerNpcDagger.DAGGER; 
/* 418 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 419 */         return PlayerNpcDagger.DUAL_DAGGER;
/*     */       }
/*     */     } 
/*     */     
/* 423 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.BLACKSCRATCHER.get()).m_7968_())) {
/* 424 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 425 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 426 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 427 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 431 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_BOLT.get()).m_7968_())) {
/* 432 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 433 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 434 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 435 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 439 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_SICKLE.get()).m_7968_())) {
/* 440 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 441 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 442 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 443 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 447 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_SPEAR.get()).m_7968_())) {
/* 448 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 449 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 450 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 451 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 455 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DOUBLE_DIAMOND_GLAIVE.get()).m_7968_())) {
/* 456 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 457 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 458 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 459 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 463 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.IRON_SICKLE.get()).m_7968_())) {
/* 464 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 465 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 466 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 467 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 471 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.NETHERITE_SPEAR.get()).m_7968_())) {
/* 472 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 473 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 474 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 475 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 479 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.TWIN_DIAMOND_SPEAR.get()).m_7968_())) {
/* 480 */       if (style == CapabilityItem.Styles.ONE_HAND)
/* 481 */         return PlayerNpcSpear.AV_SPEAR_SHIELD; 
/* 482 */       if (style == CapabilityItem.Styles.TWO_HAND) {
/* 483 */         return PlayerNpcSpear.AV_SPEAR;
/*     */       }
/*     */     } 
/*     */     
/* 487 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.GOLDEN_MACE.get()).m_7968_()) && 
/* 488 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 489 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 493 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.DIAMOND_MACE.get()).m_7968_()) && 
/* 494 */       style == CapabilityItem.Styles.ONE_HAND) {
/* 495 */       return PlayerNpcAxe.AV_AXE;
/*     */     }
/*     */ 
/*     */     
/* 499 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.WOODEN_DOOR.get()).m_7968_()) && 
/* 500 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 501 */       return PlayerNpcWoodenDoor.WOODEN_DOOR;
/*     */     }
/*     */ 
/*     */     
/* 505 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.CRAFTING_TABLE.get()).m_7968_()) && 
/* 506 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 507 */       return PlayerNpcCraftingTable.CRAFTING_TABLE;
/*     */     }
/*     */ 
/*     */     
/* 511 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.LADDER.get()).m_7968_()) && 
/* 512 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 513 */       return PlayerNpcLadder.LADDER;
/*     */     }
/*     */ 
/*     */     
/* 517 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.TRAPDOOR.get()).m_7968_()) && 
/* 518 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 519 */       return PlayerNpcTrapdoor.TRAPDOOR;
/*     */     }
/*     */ 
/*     */     
/* 523 */     return null;
/*     */   }
/*     */   
/*     */   public static CECombatBehaviors.Builder<MobPatch<?>> overideCustomWeaponMotionBuilderForShadowHerobrine(CapabilityItem mainHandCap, Style style) {
/* 527 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_WEAPON.get()).m_7968_()) && 
/* 528 */       style == CapabilityItem.Styles.TWO_HAND) {
/* 529 */       return HerobrineObsidianWeapon.OBSIDIAN_WEAPON;
/*     */     }
/*     */ 
/*     */     
/* 533 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_PILLAR.get()).m_7968_())) {
/* 534 */       if (style == CapabilityItem.Styles.TWO_HAND)
/* 535 */         return HerobrineShadowObsidianPillar.SHADOW_OBSIDIAN_PILLAR_WEAPON; 
/* 536 */       if (style == CapabilityItem.Styles.OCHS) {
/* 537 */         return HerobrineShadowObsidianPillar.SHADOW_OBSIDIAN_PILLAR_SWORD_WEAPON;
/*     */       }
/*     */     } 
/*     */     
/* 541 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(((Item)AnnoyingVillagersModItems.SHADOW_OBSIDIAN_SWORD.get()).m_7968_())) {
/* 542 */       if (style == CapabilityItem.Styles.TWO_HAND)
/* 543 */         return HerobrineShadowObsidianSword.SHADOW_OBSIDIAN_DUAL_SWORD; 
/* 544 */       if (style == CapabilityItem.Styles.ONE_HAND) {
/* 545 */         return HerobrineShadowObsidianSword.SHADOW_OBSIDIAN_SWORD;
/*     */       }
/*     */     } 
/*     */     
/* 549 */     return null;
/*     */   }
/*     */   
/*     */   public static CECombatBehaviors.Builder<MobPatch<?>> overideBowMotionBuilderForNpc(CapabilityItem mainHandCap, Style style) {
/* 553 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(Items.f_42411_.m_7968_())) {
/* 554 */       return NpcBow.BOW;
/*     */     }
/*     */     
/* 557 */     return null;
/*     */   }
/*     */   
/*     */   public static CECombatBehaviors.Builder<MobPatch<?>> overideBowMotionBuilderForPlayerNpc(CapabilityItem mainHandCap, Style style) {
/* 561 */     if (mainHandCap == EpicFightCapabilities.getItemStackCapability(Items.f_42411_.m_7968_())) {
/* 562 */       return PlayerNpcBow.BOW;
/*     */     }
/*     */     
/* 565 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\MobPatchCommon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */