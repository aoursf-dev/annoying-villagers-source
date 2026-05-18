/*     */ package com.pla.annoyingvillagers.combatbehaviour;
/*     */ 
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.efkick.gameasset.EFKickAnimations;
/*     */ import net.shelmarow.combat_evolution.ai.CECombatBehaviors;
/*     */ import net.shelmarow.combat_evolution.ai.condition.HealthCheck;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TEMPLATE
/*     */ {
/*  16 */   public static final CECombatBehaviors.Builder<MobPatch<?>> SWORD = CECombatBehaviors.builder()
/*  17 */     .newBehaviorRoot(
/*  18 */       CECombatBehaviors.BehaviorRoot.builder()
/*  19 */       .priority(4.0D)
/*  20 */       .weight(1000.0D)
/*  21 */       .maxCooldown(0)
/*  22 */       .addFirstBehavior(
/*  23 */         CECombatBehaviors.Behavior.builder()
/*  24 */         .custom(CombatCommon::canExecute)
/*  25 */         .withinDistance(0.0D, 5.0D)
/*  26 */         .animationBehavior(Animations.BIPED_SNEAK, 0.0F)
/*  27 */         .addExBehavior(CombatCommon::performExecute)))
/*     */ 
/*     */     
/*  30 */     .newBehaviorRoot(
/*  31 */       CECombatBehaviors.BehaviorRoot.builder()
/*  32 */       .priority(3.0D)
/*  33 */       .weight(1000.0D)
/*  34 */       .maxCooldown(0)
/*  35 */       .addFirstBehavior(
/*  36 */         CECombatBehaviors.Behavior.builder()
/*  37 */         .custom(CombatCommon::canEscape)
/*  38 */         .withinDistance(0.0D, 8.0D)
/*  39 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  40 */         .addExBehavior(CombatCommon::swapToBlockToEscape))
/*     */       
/*  42 */       .addFirstBehavior(
/*  43 */         CECombatBehaviors.Behavior.builder()
/*  44 */         .custom(CombatCommon::canEscape)
/*  45 */         .withinDistance(0.0D, 48.0D)
/*  46 */         .guard(40)))
/*     */ 
/*     */     
/*  49 */     .newBehaviorRoot(
/*  50 */       CECombatBehaviors.BehaviorRoot.builder()
/*  51 */       .priority(2.0D)
/*  52 */       .weight(70.0D)
/*  53 */       .maxCooldown(0)
/*  54 */       .addFirstBehavior(
/*  55 */         CECombatBehaviors.Behavior.builder()
/*  56 */         .health(0.6666667F, HealthCheck.Comparator.LESS_RATIO_CONTAIN)
/*  57 */         .custom(CombatCommon::canPerformEating)
/*  58 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  59 */         .addExBehavior(CombatCommon::performEatingAnimation)))
/*     */ 
/*     */     
/*  62 */     .newBehaviorRoot(
/*  63 */       CECombatBehaviors.BehaviorRoot.builder()
/*  64 */       .priority(2.0D)
/*  65 */       .weight(100.0D)
/*  66 */       .maxCooldown(120)
/*  67 */       .addFirstBehavior(
/*  68 */         CECombatBehaviors.Behavior.builder()
/*  69 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  70 */         .custom(CombatCommon::canSwapToBow)
/*  71 */         .withinDistance(7.0D, 14.0D)
/*  72 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F)
/*  73 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  75 */       .addFirstBehavior(
/*  76 */         CECombatBehaviors.Behavior.builder()
/*  77 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  78 */         .custom(CombatCommon::canSwapToBow)
/*  79 */         .withinDistance(7.0D, 14.0D)
/*  80 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F)
/*  81 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  83 */       .addFirstBehavior(
/*  84 */         CECombatBehaviors.Behavior.builder()
/*  85 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  86 */         .custom(CombatCommon::canSwapToBow)
/*  87 */         .withinDistance(7.0D, 14.0D)
/*  88 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F)
/*  89 */         .addExBehavior(CombatCommon::swapToBow))
/*     */       
/*  91 */       .addFirstBehavior(
/*  92 */         CECombatBehaviors.Behavior.builder()
/*  93 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/*  94 */         .custom(CombatCommon::canSwapToBow)
/*  95 */         .withinDistance(7.0D, 14.0D)
/*  96 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)
/*  97 */         .addExBehavior(CombatCommon::swapToBow)))
/*     */ 
/*     */     
/* 100 */     .newBehaviorRoot(
/* 101 */       CECombatBehaviors.BehaviorRoot.builder()
/* 102 */       .priority(2.0D)
/* 103 */       .weight(80.0D)
/* 104 */       .maxCooldown(120)
/* 105 */       .addFirstBehavior(
/* 106 */         CECombatBehaviors.Behavior.builder()
/* 107 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 108 */         .custom(CombatCommon::canThrowEnderPearl)
/* 109 */         .withinDistance(7.0D, 48.0D)
/* 110 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 111 */         .addExBehavior(CombatCommon::performEnderPearlToTarget)))
/*     */ 
/*     */     
/* 114 */     .newBehaviorRoot(
/* 115 */       CECombatBehaviors.BehaviorRoot.builder()
/* 116 */       .priority(1.0D)
/* 117 */       .weight(40.0D)
/* 118 */       .maxCooldown(20)
/* 119 */       .addFirstBehavior(
/* 120 */         CECombatBehaviors.Behavior.builder()
/* 121 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 122 */         .withinDistance(0.0D, 3.0D)
/* 123 */         .animationBehavior(Animations.SWORD_AUTO1, 0.0F)
/* 124 */         .addNextBehavior(
/* 125 */           CECombatBehaviors.Behavior.builder()
/* 126 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 127 */           .withinDistance(0.0D, 3.0D)
/* 128 */           .animationBehavior(Animations.SWORD_AUTO2, 0.0F)
/* 129 */           .addNextBehavior(
/* 130 */             CECombatBehaviors.Behavior.builder()
/* 131 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 132 */             .withinDistance(0.0D, 3.0D)
/* 133 */             .animationBehavior(Animations.SWORD_AUTO3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     .newBehaviorRoot(
/* 139 */       CECombatBehaviors.BehaviorRoot.builder()
/* 140 */       .priority(1.0D)
/* 141 */       .weight(20.0D)
/* 142 */       .maxCooldown(80)
/* 143 */       .addFirstBehavior(
/* 144 */         CECombatBehaviors.Behavior.builder()
/* 145 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 146 */         .withinDistance(0.0D, 3.0D)
/* 147 */         .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_1, 0.0F)
/* 148 */         .addNextBehavior(
/* 149 */           CECombatBehaviors.Behavior.builder()
/* 150 */           .withinDistance(0.0D, 3.0D)
/* 151 */           .custom(CombatCommon::canPerformNormalAttackLogic)
/* 152 */           .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_2, 0.0F)
/* 153 */           .addNextBehavior(
/* 154 */             CECombatBehaviors.Behavior.builder()
/* 155 */             .withinDistance(0.0D, 3.0D)
/* 156 */             .custom(CombatCommon::canPerformNormalAttackLogic)
/* 157 */             .animationBehavior(AVAnimations.SWORD_HEAVY_AUTO_3, 0.0F)))))
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     .newBehaviorRoot(
/* 163 */       CECombatBehaviors.BehaviorRoot.builder()
/* 164 */       .priority(1.0D)
/* 165 */       .weight(10.0D)
/* 166 */       .maxCooldown(80)
/* 167 */       .addFirstBehavior(
/* 168 */         CECombatBehaviors.Behavior.builder()
/* 169 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 170 */         .withinDistance(0.0D, 3.0D)
/* 171 */         .animationBehavior(Animations.SWORD_DASH, 0.0F))
/*     */       
/* 173 */       .addFirstBehavior(
/* 174 */         CECombatBehaviors.Behavior.builder()
/* 175 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 176 */         .withinDistance(0.0D, 3.0D)
/* 177 */         .animationBehavior(Animations.SWORD_AIR_SLASH, 0.0F))
/*     */       
/* 179 */       .addFirstBehavior(
/* 180 */         CECombatBehaviors.Behavior.builder()
/* 181 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 182 */         .withinDistance(0.0D, 3.0D)
/* 183 */         .animationBehavior(Animations.SWEEPING_EDGE, 0.0F)))
/*     */ 
/*     */     
/* 186 */     .newBehaviorRoot(
/* 187 */       CECombatBehaviors.BehaviorRoot.builder()
/* 188 */       .priority(1.0D)
/* 189 */       .weight(10.0D)
/* 190 */       .maxCooldown(40)
/* 191 */       .addFirstBehavior(
/* 192 */         CECombatBehaviors.Behavior.builder()
/* 193 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 194 */         .withinDistance(0.0D, 3.0D)
/* 195 */         .custom(CombatCommon::canThrowEnderPearl)
/* 196 */         .custom(CombatCommon::canAttackWhileNotHealing)
/* 197 */         .animationBehavior(AVAnimations.CASTING_ONE_HAND_TOP, 0.0F)
/* 198 */         .addExBehavior(CombatCommon::performEnderPearlAway)))
/*     */ 
/*     */     
/* 201 */     .newBehaviorRoot(
/* 202 */       CECombatBehaviors.BehaviorRoot.builder()
/* 203 */       .priority(1.0D)
/* 204 */       .weight(2.0D)
/* 205 */       .maxCooldown(100)
/* 206 */       .addFirstBehavior(
/* 207 */         CECombatBehaviors.Behavior.builder()
/* 208 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 209 */         .withinDistance(0.0D, 3.0D)
/* 210 */         .animationBehavior(EFKickAnimations.KICK_1, 0.0F))
/*     */       
/* 212 */       .addFirstBehavior(
/* 213 */         CECombatBehaviors.Behavior.builder()
/* 214 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 215 */         .withinDistance(0.0D, 3.0D)
/* 216 */         .animationBehavior(EFKickAnimations.KICK_2, 0.0F))
/*     */       
/* 218 */       .addFirstBehavior(
/* 219 */         CECombatBehaviors.Behavior.builder()
/* 220 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 221 */         .withinDistance(0.0D, 3.0D)
/* 222 */         .animationBehavior(EFKickAnimations.KICK_3, 0.0F))
/*     */       
/* 224 */       .addFirstBehavior(
/* 225 */         CECombatBehaviors.Behavior.builder()
/* 226 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 227 */         .withinDistance(0.0D, 3.0D)
/* 228 */         .animationBehavior(EFKickAnimations.KICK_4, 0.0F))
/*     */       
/* 230 */       .addFirstBehavior(
/* 231 */         CECombatBehaviors.Behavior.builder()
/* 232 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 233 */         .withinDistance(0.0D, 3.0D)
/* 234 */         .animationBehavior(EFKickAnimations.KICK_C, 0.0F))
/*     */       
/* 236 */       .addFirstBehavior(
/* 237 */         CECombatBehaviors.Behavior.builder()
/* 238 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 239 */         .withinDistance(0.0D, 3.0D)
/* 240 */         .animationBehavior(EFKickAnimations.KICK_RUSH, 0.0F))
/*     */       
/* 242 */       .addFirstBehavior(
/* 243 */         CECombatBehaviors.Behavior.builder()
/* 244 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 245 */         .withinDistance(0.0D, 3.0D)
/* 246 */         .animationBehavior(EFKickAnimations.KICK_H, 0.0F)))
/*     */ 
/*     */     
/* 249 */     .newBehaviorRoot(
/* 250 */       CECombatBehaviors.BehaviorRoot.builder()
/* 251 */       .priority(1.0D)
/* 252 */       .weight(15.0D)
/* 253 */       .addFirstBehavior(
/* 254 */         CECombatBehaviors.Behavior.builder()
/* 255 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 256 */         .withinDistance(0.5D, 3.0D)
/* 257 */         .custom(CombatCommon::canPerformGuarding)
/* 258 */         .guard(40)))
/*     */ 
/*     */     
/* 261 */     .newBehaviorRoot(
/* 262 */       CECombatBehaviors.BehaviorRoot.builder()
/* 263 */       .priority(1.0D)
/* 264 */       .weight(10.0D)
/* 265 */       .addFirstBehavior(
/* 266 */         CECombatBehaviors.Behavior.builder()
/* 267 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 268 */         .withinDistance(0.0D, 3.0D)
/* 269 */         .animationBehavior(Animations.BIPED_STEP_BACKWARD, 0.0F))
/*     */       
/* 271 */       .addFirstBehavior(
/* 272 */         CECombatBehaviors.Behavior.builder()
/* 273 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 274 */         .withinDistance(0.0D, 3.0D)
/* 275 */         .animationBehavior(Animations.BIPED_STEP_FORWARD, 0.0F))
/*     */       
/* 277 */       .addFirstBehavior(
/* 278 */         CECombatBehaviors.Behavior.builder()
/* 279 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 280 */         .withinDistance(0.0D, 3.0D)
/* 281 */         .animationBehavior(Animations.BIPED_STEP_LEFT, 0.0F))
/*     */       
/* 283 */       .addFirstBehavior(
/* 284 */         CECombatBehaviors.Behavior.builder()
/* 285 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 286 */         .withinDistance(0.0D, 3.0D)
/* 287 */         .animationBehavior(Animations.BIPED_STEP_RIGHT, 0.0F)))
/*     */ 
/*     */     
/* 290 */     .newBehaviorRoot(
/* 291 */       CECombatBehaviors.BehaviorRoot.builder()
/* 292 */       .priority(1.0D)
/* 293 */       .weight(40.0D)
/* 294 */       .maxCooldown(160)
/* 295 */       .addFirstBehavior(
/* 296 */         CECombatBehaviors.Behavior.builder()
/* 297 */         .custom(CombatCommon::canPerformNormalAttackLogic)
/* 298 */         .custom(CombatCommon::canJump)
/* 299 */         .withinDistance(5.0D, 14.0D)
/* 300 */         .animationBehavior(Animations.BIPED_JUMP, 0.0F)
/* 301 */         .addExBehavior(CombatCommon::jump)));
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\TEMPLATE.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */