/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.pla.annoyingvillagers.item.BlueDemonTridentItem;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Vec3i;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.server.level.ServerPlayer;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LightningBolt;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.event.TickEvent;
/*     */ import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ 
/*     */ @EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.FORGE)
/*     */ public final class BlueDemonTridentOnPlayerHandEvent {
/*     */   private static final String TAG_NEXT_STORM_ROLL = "BlueDemonNextStormRoll";
/*     */   private static final String TAG_LAST_LIGHTNING_UUID = "BlueDemonLastLightningUUID";
/*     */   private static final int STORM_CHECK_INTERVAL = 20;
/*     */   private static final double STORM_STRIKE_CHANCE = 0.05D;
/*     */   private static final int STRIKE_COOLDOWN_MIN = 60;
/*     */   private static final int STRIKE_COOLDOWN_MAX = 120;
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
/*     */     ServerPlayer player;
/*  39 */     if (event.phase != TickEvent.Phase.END) {
/*     */       return;
/*     */     }
/*     */     
/*  43 */     Player player1 = event.player; if (player1 instanceof ServerPlayer) { player = (ServerPlayer)player1; }
/*     */     else
/*     */     { return; }
/*     */     
/*  47 */     ServerLevel serverLevel = player.m_284548_();
/*     */     
/*  49 */     if (!isStormAttractorActive(player, serverLevel)) {
/*     */       return;
/*     */     }
/*     */     
/*  53 */     CompoundTag data = player.getPersistentData();
/*  54 */     long gameTime = serverLevel.m_46467_();
/*  55 */     long nextAllowedRoll = data.m_128454_("BlueDemonNextStormRoll");
/*     */     
/*  57 */     if (gameTime < nextAllowedRoll) {
/*     */       return;
/*     */     }
/*     */     
/*  61 */     data.m_128356_("BlueDemonNextStormRoll", gameTime + 20L);
/*     */     
/*  63 */     if (serverLevel.f_46441_.m_188500_() > 0.05D) {
/*     */       return;
/*     */     }
/*     */     
/*  67 */     summonNaturalLightning(serverLevel, BlockPos.m_274561_(player.m_20185_(), player.m_20186_(), player.m_20189_()));
/*  68 */     data.m_128356_("BlueDemonNextStormRoll", gameTime + Mth.m_216271_(serverLevel.f_46441_, 60, 120));
/*     */   }
/*     */   @SubscribeEvent
/*     */   public static void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
/*     */     ServerPlayer player;
/*  73 */     Entity entity = event.getEntity(); if (entity instanceof ServerPlayer) { player = (ServerPlayer)entity; }
/*     */     else
/*     */     { return; }
/*     */     
/*  77 */     LightningBolt lightning = event.getLightning();
/*  78 */     if (alreadyChargedFromThisLightning(player, lightning)) {
/*     */       return;
/*     */     }
/*     */     
/*  82 */     List<ItemStack> candidates = getChargeCandidates(player);
/*  83 */     if (candidates.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  87 */     ItemStack chosen = candidates.get(player.m_217043_().m_188503_(candidates.size()));
/*  88 */     int gained = Mth.m_216271_(player.m_217043_(), 2, 4);
/*     */     
/*  90 */     BlueDemonTridentItem.addStormEnergy(chosen, gained);
/*     */   }
/*     */   
/*     */   private static boolean isStormAttractorActive(ServerPlayer player, ServerLevel serverLevel) {
/*  94 */     if (!player.m_6084_() || player.m_5833_()) {
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (!serverLevel.m_46470_()) {
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     BlockPos headPos = BlockPos.m_274561_(player.m_20185_(), player.m_20186_() + player.m_20206_() + 0.25D, player.m_20189_());
/* 103 */     if (!serverLevel.m_45527_(headPos)) {
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     return (BlueDemonTridentItem.isBlueDemonTrident(player.m_21205_()) || 
/* 108 */       BlueDemonTridentItem.isBlueDemonTrident(player.m_21206_()));
/*     */   }
/*     */   
/*     */   private static void summonNaturalLightning(ServerLevel serverLevel, BlockPos strikePos) {
/* 112 */     LightningBolt lightning = (LightningBolt)EntityType.f_20465_.m_20615_((Level)serverLevel);
/* 113 */     if (lightning == null) {
/*     */       return;
/*     */     }
/*     */     
/* 117 */     lightning.m_20219_(Vec3.m_82539_((Vec3i)strikePos));
/* 118 */     lightning.m_20874_(false);
/* 119 */     lightning.setDamage((new Random()).nextFloat(1.0F, 3.0F));
/* 120 */     serverLevel.m_7967_((Entity)lightning);
/*     */   }
/*     */   
/*     */   private static List<ItemStack> getChargeCandidates(ServerPlayer player) {
/* 124 */     List<ItemStack> candidates = new ArrayList<>(2);
/*     */     
/* 126 */     ItemStack mainHand = player.m_21205_();
/* 127 */     ItemStack offHand = player.m_21206_();
/*     */     
/* 129 */     if (BlueDemonTridentItem.isBlueDemonTrident(mainHand) && !BlueDemonTridentItem.isFullyCharged(mainHand)) {
/* 130 */       candidates.add(mainHand);
/*     */     }
/*     */     
/* 133 */     if (BlueDemonTridentItem.isBlueDemonTrident(offHand) && !BlueDemonTridentItem.isFullyCharged(offHand)) {
/* 134 */       candidates.add(offHand);
/*     */     }
/*     */     
/* 137 */     return candidates;
/*     */   }
/*     */   
/*     */   private static boolean alreadyChargedFromThisLightning(ServerPlayer player, LightningBolt lightning) {
/* 141 */     CompoundTag data = player.getPersistentData();
/* 142 */     UUID lightningUUID = lightning.m_20148_();
/*     */     
/* 144 */     if (data.m_128403_("BlueDemonLastLightningUUID") && lightningUUID.equals(data.m_128342_("BlueDemonLastLightningUUID"))) {
/* 145 */       return true;
/*     */     }
/*     */     
/* 148 */     data.m_128362_("BlueDemonLastLightningUUID", lightningUUID);
/* 149 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\BlueDemonTridentOnPlayerHandEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */