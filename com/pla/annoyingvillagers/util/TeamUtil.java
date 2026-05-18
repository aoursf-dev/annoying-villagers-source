/*    */ package com.pla.annoyingvillagers.util;
/*    */ import net.minecraft.server.ServerScoreboard;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.scores.PlayerTeam;
/*    */ 
/*    */ public class TeamUtil {
/*    */   public static boolean isInTeam(Entity entity, String teamName) {
/*    */     ServerLevel serverLevel;
/* 10 */     if (entity == null) return false; 
/* 11 */     Level level = entity.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; } else { return false; }
/*    */     
/* 13 */     ServerScoreboard serverScoreboard = serverLevel.m_6188_();
/* 14 */     PlayerTeam team = serverScoreboard.m_83489_(teamName);
/* 15 */     if (team == null) return false;
/*    */     
/* 17 */     String entry = entity.m_6302_();
/* 18 */     PlayerTeam current = serverScoreboard.m_83500_(entry);
/* 19 */     return (current != null && current == team);
/*    */   }
/*    */   public static void addOrJoinTeam(Entity entity, String teamName) {
/*    */     ServerLevel serverLevel;
/* 23 */     if (entity == null)
/* 24 */       return;  Level level = entity.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*    */     else { return; }
/* 26 */      ServerScoreboard serverScoreboard = serverLevel.m_6188_();
/*    */     
/* 28 */     PlayerTeam team = serverScoreboard.m_83489_(teamName);
/* 29 */     if (team == null) {
/* 30 */       team = serverScoreboard.m_83492_(teamName);
/*    */     }
/* 32 */     team.m_83355_(false);
/*    */     
/* 34 */     String entry = entity.m_6302_();
/*    */     
/* 36 */     PlayerTeam current = serverScoreboard.m_83500_(entry);
/* 37 */     if (current == team)
/*    */       return; 
/* 39 */     if (current != null) {
/* 40 */       serverScoreboard.m_6519_(entry, current);
/*    */     }
/*    */     
/* 43 */     serverScoreboard.m_6546_(entry, team);
/*    */   }
/*    */   public static void leaveTeam(Entity entity, String teamName) {
/*    */     ServerLevel serverLevel;
/* 47 */     if (entity == null)
/* 48 */       return;  Level level = entity.m_9236_(); if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*    */     else { return; }
/* 50 */      ServerScoreboard serverScoreboard = serverLevel.m_6188_();
/* 51 */     PlayerTeam team = serverScoreboard.m_83489_(teamName);
/* 52 */     if (team == null)
/*    */       return; 
/* 54 */     String entry = entity.m_6302_();
/*    */     
/* 56 */     PlayerTeam current = serverScoreboard.m_83500_(entry);
/* 57 */     if (current == team)
/* 58 */       serverScoreboard.m_6519_(entry, team); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\TeamUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */