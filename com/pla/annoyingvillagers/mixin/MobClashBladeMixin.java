/*     */ package com.pla.annoyingvillagers.mixin;
/*     */ 
/*     */ import com.pla.annoyingvillagers.block.ShadowObsidianBlock;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineMob;
/*     */ import com.pla.annoyingvillagers.combatbehaviour.CombatCommon;
/*     */ import com.pla.annoyingvillagers.compat.EpicFightNightFall;
/*     */ import com.pla.annoyingvillagers.entity.BlueDemonEntity;
/*     */ import com.pla.annoyingvillagers.entity.PlayerNpcEntity;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*     */ import com.pla.efclash_blade.event.MobClashBladeEvent;
/*     */ import java.util.Random;
/*     */ import java.util.function.BiFunction;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageTypes;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.item.BlockItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.levelgen.Heightmap;
/*     */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ import reascer.wom.gameasset.WOMAnimations;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsAgony;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsMoonless;
/*     */ import reascer.wom.gameasset.animations.weapons.AnimsSolar;
/*     */ import yesman.epicfight.api.animation.types.EntityState;
/*     */ import yesman.epicfight.api.animation.types.StaticAnimation;
/*     */ import yesman.epicfight.api.asset.AssetAccessor;
/*     */ import yesman.epicfight.gameasset.Animations;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin(value = {MobClashBladeEvent.class}, remap = false)
/*     */ public class MobClashBladeMixin
/*     */ {
/*     */   @Inject(method = {"customAdditionClashBladeLogic"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private static void addMoreClashBladeCondition(LivingAttackEvent livingAttackEvent, LivingEntityPatch<?> defenderLivingEntityPatch, AssetAccessor<? extends StaticAnimation> defenderDynamicAnimation, EntityState defenderEntityState, Entity attacker, Entity defender, CallbackInfoReturnable<Boolean> cir) {
/*  69 */     if (EpicfightUtil.isLongHitAnimation(defenderDynamicAnimation, defenderLivingEntityPatch)) {
/*  70 */       cir.setReturnValue(Boolean.valueOf(false));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  75 */     if (defender instanceof com.pla.annoyingvillagers.entity.AegisHerobrineEntity && defenderDynamicAnimation == AVAnimations.AEGIS_SHIELD_SHOOT && defenderEntityState
/*     */       
/*  77 */       .getLevel() == 3) {
/*  78 */       cir.setReturnValue(Boolean.valueOf(true));
/*     */       
/*     */       return;
/*     */     } 
/*  82 */     if (defender instanceof com.pla.annoyingvillagers.entity.AegisHerobrineEntity && defenderDynamicAnimation == AVAnimations.ENDER_AEGIS_NAPOLEON_RELOAD_1) {
/*     */       
/*  84 */       cir.setReturnValue(Boolean.valueOf(true));
/*     */       
/*     */       return;
/*     */     } 
/*  88 */     if (defender instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity && defenderDynamicAnimation == WOMAnimations.TORMENT_BERSERK_CONVERT) {
/*     */       
/*  90 */       cir.setReturnValue(Boolean.valueOf(true));
/*     */       
/*     */       return;
/*     */     } 
/*  94 */     if (defender instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity && defenderDynamicAnimation == AVAnimations.AGONY_GUARD_HIT_1) {
/*     */       
/*  96 */       cir.setReturnValue(Boolean.valueOf(true));
/*     */       
/*     */       return;
/*     */     } 
/* 100 */     if (defender instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity && defenderDynamicAnimation == WOMAnimations.TORMENT_BERSERK_CONVERT) {
/*     */       
/* 102 */       cir.setReturnValue(Boolean.valueOf(true));
/*     */       
/*     */       return;
/*     */     } 
/* 106 */     if (defender instanceof com.pla.annoyingvillagers.entity.HerobrineChrisEntity && defenderDynamicAnimation == AnimsMoonless.MOONLESS_GUARD_HIT_1) {
/*     */       
/* 108 */       cir.setReturnValue(Boolean.valueOf(true));
/*     */       return;
/*     */     } 
/* 111 */     if (livingAttackEvent.getSource().m_7640_() instanceof net.minecraft.world.entity.projectile.Projectile && defender
/* 112 */       .m_20096_() && 
/* 113 */       !defender.m_20159_() && defender
/* 114 */       .m_9236_() instanceof ServerLevel) {
/* 115 */       Entity projectile = livingAttackEvent.getSource().m_7640_();
/*     */       
/* 117 */       if (defender instanceof AVNpc) { AVNpc AVNpc = (AVNpc)defender; if (AVNpc
/* 118 */           .getBlockDamage() == null && (new Random())
/* 119 */           .nextDouble() <= AVNpc.getPlaceBlockToParryChance() && (AVNpc
/* 120 */           .m_21120_(InteractionHand.MAIN_HAND).m_41720_()
/* 121 */           .equals(AVNpc.getMainWeaponItem().m_41720_()) || AVNpc
/* 122 */           .m_21120_(InteractionHand.MAIN_HAND).m_41720_() instanceof net.minecraft.world.item.BowItem) && 
/* 123 */           !AVNpc.isHealing()) {
/* 124 */           AVNpc.setBlockDamage(projectile);
/* 125 */           CombatCommon.swapToBlock((MobPatch)defenderLivingEntityPatch);
/* 126 */           cir.setReturnValue(Boolean.valueOf(true));
/*     */           return;
/*     */         }  }
/*     */       
/* 130 */       if (defender instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)defender; if (playerNpcEntity
/* 131 */           .getBlockDamage() == null && (new Random())
/* 132 */           .nextDouble() <= playerNpcEntity.getPlaceBlockToParryChance() && (playerNpcEntity
/* 133 */           .m_21120_(InteractionHand.MAIN_HAND).m_41720_()
/* 134 */           .equals(playerNpcEntity.getMainWeaponItem().m_41720_()) || playerNpcEntity
/* 135 */           .m_21120_(InteractionHand.MAIN_HAND).m_41720_() instanceof net.minecraft.world.item.BowItem) && 
/* 136 */           !playerNpcEntity.isHealing()) {
/* 137 */           playerNpcEntity.setBlockDamage(projectile);
/* 138 */           CombatCommon.swapToBlock((MobPatch)defenderLivingEntityPatch);
/* 139 */           cir.setReturnValue(Boolean.valueOf(true));
/*     */           return;
/*     */         }  }
/*     */       
/* 143 */       if (defender instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)defender;
/* 144 */         if (!(projectile instanceof net.minecraft.world.entity.projectile.AbstractArrow) || projectile instanceof com.pla.annoyingvillagers.entity.EnchantedArrowEntity || projectile instanceof com.pla.annoyingvillagers.entity.BlueDemonThrownTridentEntity) {
/* 145 */           herobrineMob.setBlockDamage(projectile);
/* 146 */           cir.setReturnValue(Boolean.valueOf(true));
/*     */         }  }
/*     */ 
/*     */       
/* 150 */       if (defender instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)defender;
/* 151 */         blueDemonEntity.setBlockDamage(projectile);
/* 152 */         cir.setReturnValue(Boolean.valueOf(true));
/*     */         
/*     */         return; }
/*     */     
/* 156 */     } else if (!(livingAttackEvent.getSource().m_7640_() instanceof net.minecraft.world.entity.projectile.Projectile) && defender
/* 157 */       .m_20096_() && 
/* 158 */       !defender.m_20159_() && livingAttackEvent
/* 159 */       .getSource().m_7640_() != null && defender
/* 160 */       .m_9236_() instanceof ServerLevel) {
/*     */       
/* 162 */       ResourceLocation indirectEntity = BuiltInRegistries.f_256780_.m_7981_(livingAttackEvent.getSource().m_7640_().m_6095_());
/*     */       
/* 164 */       boolean isDamageFromGunKnight = (indirectEntity.m_135827_().equals("torchesbecomesunlight") && (indirectEntity.m_135815_().equals("gun_knight_patriot") || indirectEntity.m_135815_().equals("turret")));
/*     */ 
/*     */       
/* 167 */       boolean ignisFileBall = (indirectEntity.m_135827_().equals("cataclysm") && (indirectEntity.m_135815_().equals("ignis_abyss_fireball") || indirectEntity.m_135815_().equals("ignis_fireball") || indirectEntity.m_135815_().equals("flame_jet") || indirectEntity.m_135815_().equals("flame_strike")));
/*     */ 
/*     */ 
/*     */       
/* 171 */       boolean isMeteorite = (livingAttackEvent.getSource().m_7640_() instanceof com.pla.annoyingvillagers.entity.DragonMeteoriteEntity || livingAttackEvent.getSource().m_7639_() instanceof com.pla.annoyingvillagers.entity.DragonMeteoriteEntity || livingAttackEvent.getSource().m_7640_() instanceof com.pla.annoyingvillagers.entity.ObsidianSledgehammerProjectileEntity || livingAttackEvent.getSource().m_7639_() instanceof com.pla.annoyingvillagers.entity.ObsidianSledgehammerProjectileEntity);
/* 172 */       if (isDamageFromGunKnight || ignisFileBall || isMeteorite || livingAttackEvent.getSource().m_276093_(DamageTypes.f_268565_)) {
/* 173 */         if (defender instanceof AVNpc) { AVNpc AVNpc = (AVNpc)defender; if (AVNpc
/* 174 */             .getBlockDamage() == null && (new Random())
/* 175 */             .nextDouble() <= AVNpc.getPlaceBlockToParryChance() && (AVNpc
/* 176 */             .m_21120_(InteractionHand.MAIN_HAND).m_41720_()
/* 177 */             .equals(AVNpc.getMainWeaponItem().m_41720_()) || AVNpc
/* 178 */             .m_21120_(InteractionHand.MAIN_HAND).m_41720_() instanceof net.minecraft.world.item.BowItem)) {
/* 179 */             AVNpc.setBlockDamage(livingAttackEvent.getSource().m_7640_());
/* 180 */             CombatCommon.swapToBlock((MobPatch)defenderLivingEntityPatch);
/* 181 */             cir.setReturnValue(Boolean.valueOf(true));
/*     */             return;
/*     */           }  }
/*     */         
/* 185 */         if (defender instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)defender; if (playerNpcEntity
/* 186 */             .getBlockDamage() == null && (new Random())
/* 187 */             .nextDouble() <= playerNpcEntity.getPlaceBlockToParryChance() && (playerNpcEntity
/* 188 */             .m_21120_(InteractionHand.MAIN_HAND).m_41720_()
/* 189 */             .equals(playerNpcEntity.getMainWeaponItem().m_41720_()) || playerNpcEntity
/* 190 */             .m_21120_(InteractionHand.MAIN_HAND).m_41720_() instanceof net.minecraft.world.item.BowItem)) {
/* 191 */             playerNpcEntity.setBlockDamage(livingAttackEvent.getSource().m_7640_());
/* 192 */             CombatCommon.swapToBlock((MobPatch)defenderLivingEntityPatch);
/* 193 */             cir.setReturnValue(Boolean.valueOf(true));
/*     */             return;
/*     */           }  }
/*     */         
/* 197 */         if (defender instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)defender; if (herobrineMob
/* 198 */             .getBlockDamage() == null) {
/* 199 */             herobrineMob.setBlockDamage(livingAttackEvent.getSource().m_7640_());
/* 200 */             cir.setReturnValue(Boolean.valueOf(true));
/*     */             return;
/*     */           }  }
/*     */         
/* 204 */         if (defender instanceof BlueDemonEntity) { BlueDemonEntity blueDemonEntity = (BlueDemonEntity)defender; if (blueDemonEntity
/* 205 */             .getBlockDamage() == null) {
/* 206 */             blueDemonEntity.setBlockDamage(livingAttackEvent.getSource().m_7640_());
/* 207 */             cir.setReturnValue(Boolean.valueOf(true));
/*     */             return;
/*     */           }  }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"customPreAdditionClashBlade"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private static void customLogicBeforeClashing(LivingAttackEvent livingAttackEvent, LivingEntityPatch<?> defenderLivingEntityPatch, AssetAccessor<? extends StaticAnimation> defenderDynamicAnimation, EntityState defenderEntityState, Entity attacker, Entity defender, int clashBy, CallbackInfo ci) {
/* 221 */     if (defender instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)defender;
/* 222 */       Level level = defender.m_9236_(); if (level instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)level;
/*     */         
/* 224 */         if (clashBy != 0) {
/* 225 */           if (ModList.get().isLoaded("efn")) {
/* 226 */             if (defender instanceof com.pla.annoyingvillagers.entity.AegisHerobrineEntity || defender instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity || defender instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity || defender instanceof com.pla.annoyingvillagers.entity.ReaperHerobrineEntity || defender instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity || defender instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineEntity) {
/*     */ 
/*     */               
/* 229 */               HerobrineMob herobrineMob = (HerobrineMob)defender;
/* 230 */               if (herobrineMob.getLivingEntityPatch() != null) {
/* 231 */                 EpicFightNightFall.playEfnGuardHit(herobrineMob.getLivingEntityPatch(), herobrineMob.getEfnGuardHitState(), livingAttackEvent.getSource());
/* 232 */                 herobrineMob.postPlayEfnGuardHit();
/*     */               } 
/*     */             } 
/*     */           } else {
/* 236 */             if (defender instanceof com.pla.annoyingvillagers.entity.AegisHerobrineEntity || defender instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity || defender instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity || defender instanceof com.pla.annoyingvillagers.entity.ReaperHerobrineEntity)
/*     */             {
/* 238 */               defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)AnimsAgony.AGONY_GUARD_HIT_1, 0.0F);
/*     */             }
/* 240 */             if (defender instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity) {
/* 241 */               defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)AnimsSolar.SOLAR_GUARD_HIT, 0.0F);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 247 */         if (clashBy == 1) {
/* 248 */           Entity projectile = null;
/* 249 */           if (defender instanceof AVNpc) { AVNpc AVNpc = (AVNpc)defender;
/* 250 */             projectile = AVNpc.getBlockDamage(); }
/* 251 */           else if (defender instanceof PlayerNpcEntity) { PlayerNpcEntity playerNpcEntity = (PlayerNpcEntity)defender;
/* 252 */             projectile = playerNpcEntity.getBlockDamage(); }
/* 253 */           else if (defender instanceof HerobrineMob) { HerobrineMob herobrineMob = (HerobrineMob)defender; if (!(defender instanceof com.pla.annoyingvillagers.entity.NullEntity))
/* 254 */               projectile = herobrineMob.getBlockDamage();  }
/*     */           
/* 256 */           if (projectile != null) {
/* 257 */             BlockState placeState; BlockPos baseXZ; int topY; Random random = new Random();
/* 258 */             int pattern = random.nextInt(11);
/* 259 */             int rot = random.nextInt(4);
/*     */             
/* 261 */             BiFunction<Integer, Integer, int[]> toWorld = getIntegerIntegerBiFunction(defender, rot);
/*     */ 
/*     */             
/* 264 */             if (livingEntity instanceof com.pla.annoyingvillagers.entity.HerobrineChrisEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.HerobrineCloneEntity) {
/* 265 */               placeState = (BlockState)((Block)AnnoyingVillagersModBlocks.OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(false));
/* 266 */             } else if (livingEntity instanceof com.pla.annoyingvillagers.entity.Herobrine7Entity || livingEntity instanceof com.pla.annoyingvillagers.entity.ArmoredHerobrineEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineCloneEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.ShadowHerobrineEntity) {
/*     */ 
/*     */ 
/*     */               
/* 270 */               placeState = (BlockState)((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(false));
/* 271 */             } else if (livingEntity instanceof com.pla.annoyingvillagers.entity.AegisHerobrineEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.SwordsmanHerobrineEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.ReaperHerobrineEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.SledgehammerHerobrineEntity || livingEntity instanceof com.pla.annoyingvillagers.entity.GlaiveHerobrineEntity) {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 276 */               placeState = (BlockState)((Block)AnnoyingVillagersModBlocks.CRYING_OBSIDIAN_BLOCK.get()).m_49966_().m_61124_((Property)ShadowObsidianBlock.FROM_PLAYER, Boolean.valueOf(false));
/*     */             } else {
/* 278 */               ItemStack handStack = livingEntity.m_21120_(InteractionHand.MAIN_HAND);
/* 279 */               placeState = Blocks.f_50652_.m_49966_();
/* 280 */               Item item = handStack.m_41720_(); if (item instanceof BlockItem) { BlockItem blockItem = (BlockItem)item;
/* 281 */                 placeState = blockItem.m_40614_().m_49966_(); }
/*     */             
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 287 */             ResourceLocation key = BuiltInRegistries.f_256780_.m_7981_(projectile.m_6095_());
/* 288 */             if (key.m_135827_().equals("tacz") || (key
/* 289 */               .m_135827_().equals("torchesbecomesunlight") && (key.m_135815_().equals("gun_knight_patriot") || key.m_135815_().equals("turret")))) {
/* 290 */               Direction facing = defender.m_6350_();
/* 291 */               baseXZ = defender.m_20183_().m_5484_(facing, 1);
/* 292 */               topY = Mth.m_14107_(defender.m_20186_() + defender.m_20206_());
/*     */             } else {
/* 294 */               baseXZ = BlockPos.m_274561_(projectile.m_20185_(), 0.0D, projectile.m_20189_());
/* 295 */               topY = Mth.m_14107_(projectile.m_20186_());
/*     */             } 
/* 297 */             int surfaceY = serverLevel.m_5452_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, baseXZ).m_123342_();
/* 298 */             BlockPos projXZ = new BlockPos(baseXZ.m_123341_(), 0, baseXZ.m_123343_());
/*     */             
/* 300 */             for (int y = surfaceY; y <= topY; y++) {
/* 301 */               int layer = y - surfaceY;
/*     */               
/* 303 */               BlockPos center = new BlockPos(projXZ.m_123341_(), y, projXZ.m_123343_());
/* 304 */               if (!serverLevel.m_8055_(center).m_247087_())
/*     */                 break; 
/* 306 */               defenderLivingEntityPatch.playAnimationSynchronized((AssetAccessor)AVAnimations.PLACE_BLOCK, 0.0F);
/* 307 */               defender.m_5496_(SoundEvents.f_12447_, 2.0F, 1.0F);
/* 308 */               serverLevel.m_46597_(center, placeState);
/*     */               
/* 310 */               switch (pattern) {
/*     */                 case 0:
/*     */                 
/*     */                 case 1:
/* 314 */                   if (layer == 3) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }
/*     */                 
/*     */ 
/*     */                 
/*     */                 case 2:
/* 319 */                   if (layer == 0) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[3][])[0] = new int[2]; (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[3][])[1] = new int[2]; (new int[2])[0] = 2; (new int[2])[1] = 0; (new int[3][])[2] = new int[2]; }
/* 320 */                    if (layer == 1) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }
/*     */                 
/*     */ 
/*     */                 
/*     */                 case 3:
/* 325 */                   if (layer == 1) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[2][])[0] = new int[2]; (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[2][])[1] = new int[2]; }
/*     */                 
/*     */ 
/*     */                 
/*     */                 case 4:
/* 330 */                   if (layer == 0) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[2][])[0] = new int[2]; (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[2][])[1] = new int[2]; }
/*     */                 
/*     */                 
/*     */                 case 5:
/* 334 */                   (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2];
/*     */                 
/*     */                 case 6:
/* 337 */                   if (layer <= 1) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }
/*     */                 
/*     */ 
/*     */                 
/*     */                 case 7:
/* 342 */                   if (layer == 0) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }
/*     */                 
/*     */ 
/*     */                 
/*     */                 case 8:
/* 347 */                   if (layer == 1) { (new int[2])[0] = 1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }
/*     */                 
/*     */ 
/*     */                 
/*     */                 case 9:
/* 352 */                   if (layer == 0) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }
/*     */                 
/*     */ 
/*     */                 
/*     */                 default:
/* 357 */                   if (layer == 1) { (new int[2])[0] = -1; (new int[2])[1] = 0; (new int[1][])[0] = new int[2]; }  break;
/* 358 */               }  int[][] extrasLocal = new int[0][];
/*     */ 
/*     */ 
/*     */               
/* 362 */               for (int[] ab : extrasLocal) {
/* 363 */                 int[] dzdx = toWorld.apply(Integer.valueOf(ab[0]), Integer.valueOf(ab[1]));
/* 364 */                 int dx = dzdx[0];
/* 365 */                 int dz = dzdx[1];
/*     */                 
/* 367 */                 BlockPos p = center.m_7918_(dx, 0, dz);
/* 368 */                 if (serverLevel.m_8055_(p).m_247087_())
/* 369 */                   serverLevel.m_46597_(p, placeState); 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }  }
/*     */        }
/*     */   
/*     */   }
/*     */   @NotNull
/*     */   private static BiFunction<Integer, Integer, int[]> getIntegerIntegerBiFunction(Entity defender, int rot) {
/* 379 */     Direction facing = defender.m_6350_();
/*     */     
/* 381 */     int fx = facing.m_122429_();
/* 382 */     int fz = facing.m_122431_();
/* 383 */     int rx = -fz;
/* 384 */     int rz = fx;
/*     */     
/* 386 */     for (int i = 0; i < rot; i++) {
/* 387 */       int nfx = rx, nfz = rz;
/* 388 */       int nrx = -fz, nrz = fx;
/* 389 */       fx = nfx; fz = nfz;
/* 390 */       rx = nrx; rz = nrz;
/*     */     } 
/*     */     
/* 393 */     int finalRx = rx;
/* 394 */     int finalFx = fx;
/* 395 */     int finalRz = rz;
/* 396 */     int finalFz = fz;
/* 397 */     return (a, b) -> new int[] { a.intValue() * finalRx + b.intValue() * finalFx, a.intValue() * finalRz + b.intValue() * finalFz };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"blacklistClashBladeAnimation"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private static void rejectClashBladeFromAnimationsCondition(LivingAttackEvent livingAttackEvent, LivingEntityPatch<?> defenderLivingEntityPatch, AssetAccessor<? extends StaticAnimation> defenderDynamicAnimation, EntityState defenderEntityState, Entity attacker, Entity defender, CallbackInfoReturnable<Boolean> cir) {
/* 407 */     if (defenderDynamicAnimation.get() instanceof com.pla.annoyingvillagers.animations.BowAttackAnimation) {
/* 408 */       cir.setReturnValue(Boolean.valueOf(false));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"conditionToPlayClashSound"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private static void disableClashSoundFromProjectileBlock(LivingAttackEvent livingAttackEvent, LivingEntityPatch<?> defenderLivingEntityPatch, AssetAccessor<? extends StaticAnimation> defenderDynamicAnimation, EntityState defenderEntityState, Entity attacker, Entity defender, CallbackInfoReturnable<Boolean> cir) {
/* 418 */     if (defender instanceof AVNpc) { AVNpc AVNpc = (AVNpc)defender; if (AVNpc
/* 419 */         .getBlockDamage() != null && defender
/* 420 */         .m_9236_() instanceof ServerLevel)
/* 421 */         cir.setReturnValue(Boolean.valueOf(false));  }
/*     */   
/*     */   }
/*     */   
/*     */   @Inject(method = {"customPostAdditionClashBlade"}, at = {@At("HEAD")})
/*     */   private static void revertWeaponAfterClashing(LivingAttackEvent livingAttackEvent, LivingEntityPatch<?> defenderLivingEntityPatch, AssetAccessor<? extends StaticAnimation> defenderDynamicAnimation, EntityState defenderEntityState, Entity attacker, Entity defender, int clashBy, CallbackInfo ci) {
/*     */     // Byte code:
/*     */     //   0: aload #5
/*     */     //   2: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   5: astore #9
/*     */     //   7: aload #9
/*     */     //   9: instanceof net/minecraft/server/level/ServerLevel
/*     */     //   12: ifeq -> 25
/*     */     //   15: aload #9
/*     */     //   17: checkcast net/minecraft/server/level/ServerLevel
/*     */     //   20: astore #8
/*     */     //   22: goto -> 26
/*     */     //   25: return
/*     */     //   26: aload #4
/*     */     //   28: ldc_w yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*     */     //   31: invokestatic getEntityPatch : (Lnet/minecraft/world/entity/Entity;Ljava/lang/Class;)Lyesman/epicfight/world/capabilities/entitypatch/EntityPatch;
/*     */     //   34: checkcast yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*     */     //   37: astore #9
/*     */     //   39: iload #6
/*     */     //   41: ifne -> 326
/*     */     //   44: aload #9
/*     */     //   46: ifnull -> 326
/*     */     //   49: aload #9
/*     */     //   51: invokevirtual getAnimator : ()Lyesman/epicfight/api/animation/Animator;
/*     */     //   54: aconst_null
/*     */     //   55: invokevirtual getPlayerFor : (Lyesman/epicfight/api/asset/AssetAccessor;)Lyesman/epicfight/api/animation/AnimationPlayer;
/*     */     //   58: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   61: checkcast yesman/epicfight/api/animation/AnimationPlayer
/*     */     //   64: invokevirtual getRealAnimation : ()Lyesman/epicfight/api/asset/AssetAccessor;
/*     */     //   67: astore #10
/*     */     //   69: aload #10
/*     */     //   71: ifnull -> 326
/*     */     //   74: aload #5
/*     */     //   76: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   79: ifeq -> 244
/*     */     //   82: aload #5
/*     */     //   84: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   87: astore #11
/*     */     //   89: aload #10
/*     */     //   91: invokestatic isAnimationDangerous : (Lyesman/epicfight/api/asset/AssetAccessor;)Z
/*     */     //   94: ifeq -> 244
/*     */     //   97: aload #4
/*     */     //   99: invokestatic isAvDamageableEfnWeaponsMob : (Lnet/minecraft/world/entity/Entity;)Z
/*     */     //   102: ifeq -> 244
/*     */     //   105: iconst_0
/*     */     //   106: istore #12
/*     */     //   108: getstatic com/pla/annoyingvillagers/config/AnnoyingVillagersConfig.WEAPON_BREAKING_MECHANISM_VALUE : Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
/*     */     //   111: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   114: checkcast java/lang/Integer
/*     */     //   117: invokevirtual intValue : ()I
/*     */     //   120: istore #13
/*     */     //   122: invokestatic get : ()Lnet/minecraftforge/fml/ModList;
/*     */     //   125: ldc_w 'efn'
/*     */     //   128: invokevirtual isLoaded : (Ljava/lang/String;)Z
/*     */     //   131: ifeq -> 161
/*     */     //   134: aload #11
/*     */     //   136: invokevirtual m_21205_ : ()Lnet/minecraft/world/item/ItemStack;
/*     */     //   139: invokestatic isEfnWeapons : (Lnet/minecraft/world/item/ItemStack;)Z
/*     */     //   142: ifeq -> 161
/*     */     //   145: getstatic com/pla/annoyingvillagers/config/AnnoyingVillagersConfig.WEAPON_BREAKING_MECHANISM_VALUE : Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
/*     */     //   148: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   151: checkcast java/lang/Integer
/*     */     //   154: invokevirtual intValue : ()I
/*     */     //   157: iconst_5
/*     */     //   158: imul
/*     */     //   159: istore #13
/*     */     //   161: aload #11
/*     */     //   163: invokevirtual m_21206_ : ()Lnet/minecraft/world/item/ItemStack;
/*     */     //   166: invokevirtual m_41720_ : ()Lnet/minecraft/world/item/Item;
/*     */     //   169: instanceof net/minecraft/world/item/SwordItem
/*     */     //   172: ifne -> 189
/*     */     //   175: aload #11
/*     */     //   177: invokevirtual m_21206_ : ()Lnet/minecraft/world/item/ItemStack;
/*     */     //   180: invokevirtual m_41720_ : ()Lnet/minecraft/world/item/Item;
/*     */     //   183: instanceof net/minecraft/world/item/AxeItem
/*     */     //   186: ifeq -> 222
/*     */     //   189: new java/util/Random
/*     */     //   192: dup
/*     */     //   193: invokespecial <init> : ()V
/*     */     //   196: invokevirtual nextBoolean : ()Z
/*     */     //   199: ifeq -> 222
/*     */     //   202: iconst_1
/*     */     //   203: istore #12
/*     */     //   205: aload #11
/*     */     //   207: invokevirtual m_21206_ : ()Lnet/minecraft/world/item/ItemStack;
/*     */     //   210: iload #13
/*     */     //   212: aload #11
/*     */     //   214: <illegal opcode> accept : ()Ljava/util/function/Consumer;
/*     */     //   219: invokevirtual m_41622_ : (ILnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V
/*     */     //   222: iload #12
/*     */     //   224: ifne -> 244
/*     */     //   227: aload #11
/*     */     //   229: invokevirtual m_21205_ : ()Lnet/minecraft/world/item/ItemStack;
/*     */     //   232: iload #13
/*     */     //   234: aload #11
/*     */     //   236: <illegal opcode> accept : ()Ljava/util/function/Consumer;
/*     */     //   241: invokevirtual m_41622_ : (ILnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V
/*     */     //   244: aload #5
/*     */     //   246: instanceof com/pla/annoyingvillagers/clazz/AVNpc
/*     */     //   249: ifeq -> 267
/*     */     //   252: aload #5
/*     */     //   254: checkcast com/pla/annoyingvillagers/clazz/AVNpc
/*     */     //   257: astore #11
/*     */     //   259: aload #11
/*     */     //   261: invokevirtual getBlockDamage : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   264: ifnonnull -> 290
/*     */     //   267: aload #5
/*     */     //   269: instanceof com/pla/annoyingvillagers/entity/PlayerNpcEntity
/*     */     //   272: ifeq -> 291
/*     */     //   275: aload #5
/*     */     //   277: checkcast com/pla/annoyingvillagers/entity/PlayerNpcEntity
/*     */     //   280: astore #12
/*     */     //   282: aload #12
/*     */     //   284: invokevirtual getBlockDamage : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   287: ifnull -> 291
/*     */     //   290: return
/*     */     //   291: aload #10
/*     */     //   293: invokeinterface get : ()Ljava/lang/Object;
/*     */     //   298: instanceof com/pla/efkick/animations/KickAttackAnimation
/*     */     //   301: ifeq -> 326
/*     */     //   304: aload_0
/*     */     //   305: invokevirtual getSource : ()Lnet/minecraft/world/damagesource/DamageSource;
/*     */     //   308: aload #9
/*     */     //   310: getstatic com/pla/efkick/config/EFKickConfig.KICK_STAMINA_DECREASE_PERCENTAGE : Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;
/*     */     //   313: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   316: checkcast java/lang/Double
/*     */     //   319: invokevirtual doubleValue : ()D
/*     */     //   322: iconst_1
/*     */     //   323: invokestatic dealStaminaDamageByPercentage : (Lnet/minecraft/world/damagesource/DamageSource;Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;DZ)V
/*     */     //   326: iload #6
/*     */     //   328: iconst_1
/*     */     //   329: if_icmpne -> 391
/*     */     //   332: aload #5
/*     */     //   334: instanceof com/pla/annoyingvillagers/clazz/AVNpc
/*     */     //   337: ifeq -> 355
/*     */     //   340: aload #5
/*     */     //   342: checkcast com/pla/annoyingvillagers/clazz/AVNpc
/*     */     //   345: astore #10
/*     */     //   347: aload #10
/*     */     //   349: invokevirtual getBlockDamage : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   352: ifnonnull -> 378
/*     */     //   355: aload #5
/*     */     //   357: instanceof com/pla/annoyingvillagers/entity/PlayerNpcEntity
/*     */     //   360: ifeq -> 391
/*     */     //   363: aload #5
/*     */     //   365: checkcast com/pla/annoyingvillagers/entity/PlayerNpcEntity
/*     */     //   368: astore #11
/*     */     //   370: aload #11
/*     */     //   372: invokevirtual getBlockDamage : ()Lnet/minecraft/world/entity/Entity;
/*     */     //   375: ifnull -> 391
/*     */     //   378: new com/pla/annoyingvillagers/mixin/MobClashBladeMixin$1
/*     */     //   381: dup
/*     */     //   382: bipush #10
/*     */     //   384: aload #5
/*     */     //   386: aload_1
/*     */     //   387: invokespecial <init> : (ILnet/minecraft/world/entity/Entity;Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;)V
/*     */     //   390: pop
/*     */     //   391: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #432	-> 0
/*     */     //   #433	-> 26
/*     */     //   #436	-> 39
/*     */     //   #437	-> 44
/*     */     //   #438	-> 49
/*     */     //   #439	-> 69
/*     */     //   #440	-> 74
/*     */     //   #441	-> 105
/*     */     //   #442	-> 108
/*     */     //   #443	-> 122
/*     */     //   #444	-> 134
/*     */     //   #445	-> 145
/*     */     //   #448	-> 161
/*     */     //   #449	-> 202
/*     */     //   #450	-> 205
/*     */     //   #453	-> 222
/*     */     //   #454	-> 227
/*     */     //   #457	-> 244
/*     */     //   #458	-> 275
/*     */     //   #459	-> 290
/*     */     //   #461	-> 291
/*     */     //   #462	-> 304
/*     */     //   #464	-> 313
/*     */     //   #462	-> 323
/*     */     //   #472	-> 326
/*     */     //   #473	-> 332
/*     */     //   #474	-> 363
/*     */     //   #475	-> 378
/*     */     //   #531	-> 391
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   22	3	8	serverLevel	Lnet/minecraft/server/level/ServerLevel;
/*     */     //   108	136	12	damaged	Z
/*     */     //   122	122	13	breakValue	I
/*     */     //   89	155	11	serverPlayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   259	8	11	AVNpc	Lcom/pla/annoyingvillagers/clazz/AVNpc;
/*     */     //   282	8	12	playerNpcEntity	Lcom/pla/annoyingvillagers/entity/PlayerNpcEntity;
/*     */     //   69	257	10	attackerDynamicAnimation	Lyesman/epicfight/api/asset/AssetAccessor;
/*     */     //   347	8	10	AVNpc	Lcom/pla/annoyingvillagers/clazz/AVNpc;
/*     */     //   370	8	11	playerNpcEntity	Lcom/pla/annoyingvillagers/entity/PlayerNpcEntity;
/*     */     //   0	392	0	livingAttackEvent	Lnet/minecraftforge/event/entity/living/LivingAttackEvent;
/*     */     //   0	392	1	defenderLivingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;
/*     */     //   0	392	2	defenderDynamicAnimation	Lyesman/epicfight/api/asset/AssetAccessor;
/*     */     //   0	392	3	defenderEntityState	Lyesman/epicfight/api/animation/types/EntityState;
/*     */     //   0	392	4	attacker	Lnet/minecraft/world/entity/Entity;
/*     */     //   0	392	5	defender	Lnet/minecraft/world/entity/Entity;
/*     */     //   0	392	6	clashBy	I
/*     */     //   0	392	7	ci	Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;
/*     */     //   26	366	8	serverLevel	Lnet/minecraft/server/level/ServerLevel;
/*     */     //   39	353	9	attackerLivingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;
/*     */     // Local variable type table:
/*     */     //   start	length	slot	name	signature
/*     */     //   69	257	10	attackerDynamicAnimation	Lyesman/epicfight/api/asset/AssetAccessor<+Lyesman/epicfight/api/animation/types/StaticAnimation;>;
/*     */     //   0	392	1	defenderLivingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch<*>;
/*     */     //   0	392	2	defenderDynamicAnimation	Lyesman/epicfight/api/asset/AssetAccessor<+Lyesman/epicfight/api/animation/types/StaticAnimation;>;
/*     */     //   39	353	9	attackerLivingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch<*>;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\MobClashBladeMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */