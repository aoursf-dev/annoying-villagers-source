/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
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
/*     */ class null
/*     */   extends DelayedTask
/*     */ {
/*     */   public void run() {
/* 123 */     VillagersAssistanceEvent.null.this.playSound(levelaccessor, d0, d1, d2, "minecraft:entity.experience_orb.pickup");
/*     */     
/* 125 */     if (Math.random() <= 0.6D) {
/* 126 */       VillagersAssistanceEvent.null.this.broadcast("Villager Scout", "What the matter?");
/* 127 */       VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 0.0D, 5.0D, 10.0D);
/* 128 */       VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 10.0D, 5.0D, -5.0D);
/* 129 */       VillagersAssistanceEvent.null.this.summon(entity, "blue_villager_general", -10.0D, 5.0D, 20.0D);
/* 130 */     } else if (Math.random() <= 0.1D) {
/* 131 */       VillagersAssistanceEvent.null.this.broadcast("Villager Blue General", "What the matter?");
/* 132 */       VillagersAssistanceEvent.null.this.summon(entity, "blue_villager_general", 10.0D, 5.0D, -20.0D);
/* 133 */       VillagersAssistanceEvent.null.this.summon(entity, "blue_villager_general", -5.0D, 5.0D, 20.0D);
/* 134 */       VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 0.0D, 5.0D, 10.0D);
/* 135 */     } else if (Math.random() <= 0.1D) {
/* 136 */       VillagersAssistanceEvent.null.this.broadcast("Villager Purple General", "What the matter?");
/* 137 */       VillagersAssistanceEvent.null.this.summon(entity, "purple_villager_general", -5.0D, 5.0D, 20.0D);
/* 138 */       VillagersAssistanceEvent.null.this.summon(entity, "purple_villager_general", 10.0D, 5.0D, -20.0D);
/* 139 */     } else if (Math.random() <= 0.1D) {
/* 140 */       VillagersAssistanceEvent.null.this.broadcast("Villager Red General", "What the matter?");
/* 141 */       VillagersAssistanceEvent.null.this.summon(entity, "red_villager_general", 10.0D, 5.0D, 20.0D);
/* 142 */       VillagersAssistanceEvent.null.this.summon(entity, "red_villager_general", 5.0D, 5.0D, -20.0D);
/* 143 */       VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 0.0D, 5.0D, -10.0D);
/*     */     } else {
/* 145 */       VillagersAssistanceEvent.null.this.broadcast("Villager Green General", "What the matter?");
/* 146 */       VillagersAssistanceEvent.null.this.summon(entity, "villager_scout", 0.0D, 5.0D, -10.0D);
/* 147 */       VillagersAssistanceEvent.null.this.summon(entity, "green_villager_general", 10.0D, 5.0D, 20.0D);
/* 148 */       VillagersAssistanceEvent.null.this.summon(entity, "green_villager_general", -5.0D, 5.0D, 20.0D);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\VillagersAssistanceEvent$1$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */