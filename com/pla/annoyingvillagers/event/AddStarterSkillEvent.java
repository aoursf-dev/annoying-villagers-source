/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.nbt.Tag;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.LevelAccessor;
/*    */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*    */ import net.minecraftforge.eventbus.api.Event;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import yesman.epicfight.gameasset.EpicFightSkills;
/*    */ import yesman.epicfight.network.EpicFightNetworkManager;
/*    */ import yesman.epicfight.skill.Skill;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.skill.SkillSlot;
/*    */ import yesman.epicfight.skill.SkillSlots;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class AddStarterSkillEvent {
/*    */   private static final String KEY = "annoyingvillagers:has_joined_before";
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent playerloggedinevent) {
/* 29 */     execute((Event)playerloggedinevent, (LevelAccessor)playerloggedinevent.getEntity().m_9236_(), playerloggedinevent.getEntity().m_20185_(), playerloggedinevent.getEntity().m_20186_(), playerloggedinevent.getEntity().m_20189_(), (Entity)playerloggedinevent.getEntity());
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onClone(PlayerEvent.Clone event) {
/* 34 */     if (!event.isWasDeath())
/*    */       return; 
/* 36 */     Player oldPlayer = event.getOriginal();
/* 37 */     Player newPlayer = event.getEntity();
/*    */     
/* 39 */     CompoundTag oldData = oldPlayer.getPersistentData().m_128469_("PlayerPersisted");
/* 40 */     CompoundTag newRoot = newPlayer.getPersistentData();
/* 41 */     CompoundTag newData = newRoot.m_128469_("PlayerPersisted");
/*    */     
/* 43 */     newData.m_128391_(oldData);
/* 44 */     newRoot.m_128365_("PlayerPersisted", (Tag)newData);
/*    */   }
/*    */   
/*    */   public static void execute(LevelAccessor levelaccessor, double d0, double d1, double d2, Entity entity) {
/* 48 */     execute(null, levelaccessor, d0, d1, d2, entity);
/*    */   }
/*    */   
/*    */   private static CompoundTag persisted(Player p) {
/* 52 */     CompoundTag root = p.getPersistentData();
/* 53 */     CompoundTag data = root.m_128469_("PlayerPersisted");
/* 54 */     root.m_128365_("PlayerPersisted", (Tag)data);
/* 55 */     return data;
/*    */   }
/*    */   public static boolean hasJoinedBefore(Player p) {
/* 58 */     return persisted(p).m_128471_("annoyingvillagers:has_joined_before");
/*    */   }
/*    */   public static void markJoined(Player p) {
/* 61 */     persisted(p).m_128379_("annoyingvillagers:has_joined_before", true);
/*    */   }
/*    */   
/*    */   private static void giveSkill(ServerPlayer player, ServerPlayerPatch patch, SkillSlot slot, Skill skill) {
/* 65 */     if (skill == null)
/*    */       return; 
/* 67 */     SkillContainer container = patch.getSkillCapability().getSkillContainerFor(slot);
/* 68 */     if (container == null)
/*    */       return; 
/* 70 */     if (container.setSkill(skill)) {
/* 71 */       if (skill.getCategory().learnable()) {
/* 72 */         patch.getSkillCapability().addLearnedSkill(skill);
/*    */       }
/*    */       
/* 75 */       EpicFightNetworkManager.sendToPlayer(container.createSyncPacketToLocalPlayer(), player, new Object[0]);
/* 76 */       EpicFightNetworkManager.sendToAllPlayerTrackingThisEntity(container.createSyncPacketToRemotePlayer(), (Entity)player, new Object[0]);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void execute(@Nullable Event event, LevelAccessor levelaccessor, double d0, double d1, double d2, Entity entity) {
/* 81 */     if (entity != null && 
/* 82 */       entity instanceof ServerPlayer) { ServerPlayer serverPlayer = (ServerPlayer)entity; if (!hasJoinedBefore((Player)serverPlayer) && 
/* 83 */         !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
/* 84 */         ServerPlayerPatch playerPatch = (ServerPlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)serverPlayer, ServerPlayerPatch.class);
/* 85 */         if (playerPatch == null)
/*    */           return; 
/* 87 */         giveSkill(serverPlayer, playerPatch, (SkillSlot)SkillSlots.GUARD, EpicFightSkills.GUARD);
/* 88 */         giveSkill(serverPlayer, playerPatch, (SkillSlot)SkillSlots.GUARD, EpicFightSkills.PARRYING);
/* 89 */         giveSkill(serverPlayer, playerPatch, (SkillSlot)SkillSlots.DODGE, EpicFightSkills.ROLL);
/*    */         
/* 91 */         markJoined((Player)entity);
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\AddStarterSkillEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */