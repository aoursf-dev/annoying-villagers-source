/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.minecraftforge.eventbus.api.Event;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class VillagerHeadSetEvent
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock rightclickblock) {
/*  25 */     if (rightclickblock.getHand() == rightclickblock.getEntity().m_7655_()) {
/*  26 */       execute((Event)rightclickblock, (LevelAccessor)rightclickblock.getLevel(), (Entity)rightclickblock.getEntity());
/*     */     }
/*     */   }
/*     */   
/*     */   public static void execute(LevelAccessor levelaccessor, Entity entity) {
/*  31 */     execute((Event)null, levelaccessor, entity);
/*     */   }
/*     */   
/*     */   private static void execute(@Nullable Event event, LevelAccessor levelaccessor, final Entity entity) {
/*  35 */     if (entity != null && 
/*  36 */       entity.m_6144_()) {
/*     */       ItemStack itemstack;
/*     */       
/*  39 */       if (entity instanceof LivingEntity) {
/*  40 */         LivingEntity livingentity = (LivingEntity)entity;
/*     */         
/*  42 */         itemstack = livingentity.m_6844_(EquipmentSlot.HEAD);
/*     */       } else {
/*  44 */         itemstack = ItemStack.f_41583_;
/*     */       } 
/*     */       
/*  47 */       if (itemstack.m_41720_() == AnnoyingVillagersModItems.VILLAGER_HEAD.get())
/*     */       {
/*     */         
/*  50 */         if (!entity.getPersistentData().m_128471_("villager_head")) {
/*  51 */           if (!entity.getPersistentData().m_128471_("villager_head_used")) {
/*  52 */             if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
/*     */               try {
/*  54 */                 entity.m_20194_().m_129892_().m_82094_().execute("team leave @s[team=villagers]", entity
/*     */                     
/*  56 */                     .m_20203_().m_81324_().m_81325_(4));
/*  57 */               } catch (CommandSyntaxException commandSyntaxException) {}
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*  62 */             if (entity instanceof Player) {
/*  63 */               Player player = (Player)entity;
/*  64 */               if (!player.m_9236_().m_5776_()) {
/*  65 */                 player.m_5661_((Component)Component.m_237113_("Switched to Attack Mode"), false);
/*     */               }
/*     */             } 
/*     */             
/*  69 */             entity.getPersistentData().m_128379_("villager_head_used", true);
/*  70 */             new DelayedTask(200)
/*     */               {
/*     */                 public void run() {
/*  73 */                   entity.getPersistentData().m_128379_("villager_head", true);
/*  74 */                   entity.getPersistentData().m_128379_("villager_head_used", false);
/*     */                 }
/*     */               };
/*  77 */           } else if (entity instanceof Player) {
/*  78 */             Player player = (Player)entity;
/*  79 */             if (!player.m_9236_().m_5776_()) {
/*  80 */               player.m_5661_((Component)Component.m_237113_("On Cooldown"), true);
/*     */             }
/*     */           } 
/*  83 */         } else if (entity.getPersistentData().m_128471_("villager_head")) {
/*  84 */           if (!entity.getPersistentData().m_128471_("villager_head_used")) {
/*  85 */             if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
/*     */               try {
/*  87 */                 entity.m_20194_().m_129892_().m_82094_().execute("team join villagers @s", entity
/*     */                     
/*  89 */                     .m_20203_().m_81324_().m_81325_(4));
/*  90 */               } catch (CommandSyntaxException commandSyntaxException) {}
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*  95 */             if (entity instanceof Player) {
/*  96 */               Player player = (Player)entity;
/*  97 */               if (!player.m_9236_().m_5776_()) {
/*  98 */                 player.m_5661_((Component)Component.m_237113_("Switched to Disguise Mode"), false);
/*     */               }
/*     */             } 
/*     */             
/* 102 */             entity.getPersistentData().m_128379_("villager_head_used", true);
/* 103 */             new DelayedTask(200)
/*     */               {
/*     */                 public void run() {
/* 106 */                   entity.getPersistentData().m_128379_("villager_head", false);
/* 107 */                   entity.getPersistentData().m_128379_("villager_head_used", false);
/*     */                 }
/*     */               };
/*     */           }
/* 111 */           else if (entity instanceof Player) {
/* 112 */             Player player = (Player)entity;
/* 113 */             if (!player.m_9236_().m_5776_())
/* 114 */               player.m_5661_((Component)Component.m_237113_("On Cooldown"), true); 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\VillagerHeadSetEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */