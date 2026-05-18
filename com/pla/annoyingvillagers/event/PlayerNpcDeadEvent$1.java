/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.players.PlayerList;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
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
/*     */   null(int waitTicks) {
/*  47 */     super(waitTicks);
/*     */   }
/*     */   public void run() {
/*  50 */     if (((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue())
/*  51 */       if (Math.random() <= 0.05D) {
/*  52 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  53 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> fw"), false);
/*     */         }
/*  55 */       } else if (Math.random() <= 0.05D) {
/*  56 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  57 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Is that all ?"), false);
/*     */         }
/*  59 */       } else if (Math.random() <= 0.05D) {
/*  60 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  61 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> LLLLLLLLLLLLL"), false);
/*     */         }
/*  63 */       } else if (Math.random() <= 0.05D) {
/*  64 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  65 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Hey, what happened to you?"), false);
/*     */         }
/*  67 */       } else if (Math.random() <= 0.05D) {
/*  68 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  69 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Poet's grasp"), false);
/*     */ 
/*     */         
/*     */         }
/*     */       
/*     */       }
/*  75 */       else if (Math.random() <= 0.05D) {
/*  76 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  77 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/*  78 */           String s = entity1.m_5446_().getString();
/*  79 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", is that all the strength you've got?"), false);
/*     */         } 
/*  81 */       } else if (Math.random() <= 0.1D) {
/*  82 */         if (ForgeRegistries.ENTITY_TYPES.getKey(entity.m_6095_()).toString().equals("minecraft:player") && !levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  83 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/*  84 */           String s = entity1.m_5446_().getString();
/*  85 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", that's all the Little Hajiki can do?"), false);
/*     */         } 
/*  87 */       } else if (Math.random() <= 0.05D) {
/*  88 */         if (ForgeRegistries.ENTITY_TYPES.getKey(entity.m_6095_()).toString().equals("minecraft:player") && !levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  89 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/*  90 */           String s = entity1.m_5446_().getString();
/*  91 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", you're godlike too"), false);
/*     */         } 
/*  93 */       } else if (Math.random() <= 0.05D) {
/*  94 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  95 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/*  96 */           String s = entity1.m_5446_().getString();
/*  97 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> Hahaha 😂 so funny, a " + entity.m_5446_().getString() + " is lying in bed, rhythmically chanting “Garen~ fafah”"), false);
/*     */         } 
/*  99 */       } else if (Math.random() <= 0.05D) {
/* 100 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 101 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 102 */           String s = entity1.m_5446_().getString();
/* 103 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", don't act tough if you're weak"), false);
/*     */         } 
/* 105 */       } else if (Math.random() <= 0.05D) {
/* 106 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 107 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 108 */           String s = entity1.m_5446_().getString();
/* 109 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + " plays like a bot"), false);
/*     */         } 
/* 111 */       } else if (Math.random() <= 0.05D) {
/* 112 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 113 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 114 */           String s = entity1.m_5446_().getString();
/* 115 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", I'm dying of laughter, a total 🤡"), false);
/*     */         } 
/* 117 */       } else if (Math.random() <= 0.05D) {
/* 118 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 119 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 120 */           String s = entity1.m_5446_().getString();
/* 121 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> Even giving it your all, you still can't defeat me? Haki " + entity.m_5446_().getString() + ", you bastard!"), false);
/*     */         } 
/* 123 */       } else if (Math.random() <= 0.05D) {
/* 124 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 125 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 126 */           String s = entity1.m_5446_().getString();
/* 127 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> Joke " + entity.m_5446_().getString()), false);
/*     */         } 
/* 129 */       } else if (Math.random() <= 0.05D) {
/* 130 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 131 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 132 */           String s = entity1.m_5446_().getString();
/* 133 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", weren't you acting all tough, bro?"), false);
/*     */         } 
/* 135 */       } else if (Math.random() <= 0.05D) {
/* 136 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 137 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> lol"), false);
/*     */         }
/* 139 */       } else if (Math.random() <= 0.05D) {
/* 140 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 141 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 142 */           String s = entity1.m_5446_().getString();
/* 143 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + "🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕 So weak!"), false);
/*     */         } 
/* 145 */       } else if (Math.random() <= 0.05D) {
/* 146 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 147 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 148 */           String s = entity1.m_5446_().getString();
/* 149 */           playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", if you're bad, just practice more, little bro"), false);
/*     */         } 
/* 151 */       } else if (Math.random() <= 0.05D) {
/* 152 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 153 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> It's over"), false);
/*     */         }
/* 155 */       } else if (Math.random() <= 0.05D) {
/* 156 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 157 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Haha, you're getting mad"), false);
/*     */         }
/* 159 */       } else if (Math.random() <= 0.05D) {
/* 160 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 161 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Oh really?"), false);
/*     */         }
/* 163 */       } else if (Math.random() <= 0.05D) {
/* 164 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 165 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> 🤓🤓🤓"), false);
/*     */         }
/* 167 */       } else if (Math.random() <= 0.05D) {
/* 168 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 169 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> I pinned you to the ground and beat you up, haha"), false);
/*     */         }
/* 171 */       } else if (Math.random() <= 0.05D) {
/* 172 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 173 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> So bad? Could it be that you've played too much Genshin Impact?😅"), false);
/*     */         }
/* 175 */       } else if (Math.random() <= 0.05D) {
/* 176 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 177 */           levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Desperate now?"), false);
/*     */         }
/* 179 */       } else if (Math.random() <= 0.05D && !levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 180 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + ">, all you can do is spam left-click to death🤓"), false);
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\PlayerNpcDeadEvent$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */