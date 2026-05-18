/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.ChatUtil;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.players.PlayerList;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.item.ItemEntity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.block.Blocks;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.eventbus.api.Event;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class PlayerNpcDeadEvent
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onEntityDeath(LivingDeathEvent livingdeathevent) {
/*  34 */     if (livingdeathevent != null && livingdeathevent.getEntity() != null) {
/*  35 */       execute((Event)livingdeathevent, (LevelAccessor)livingdeathevent.getEntity().m_9236_(), livingdeathevent.getEntity().m_20185_(), livingdeathevent.getEntity().m_20186_(), livingdeathevent.getEntity().m_20189_(), (Entity)livingdeathevent.getEntity(), livingdeathevent.getSource().m_7639_());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void execute(LevelAccessor levelaccessor, double d0, double d1, double d2, Entity entity, Entity entity1) {
/*  41 */     execute((Event)null, levelaccessor, d0, d1, d2, entity, entity1);
/*     */   }
/*     */   
/*     */   private static void execute(@Nullable Event event, final LevelAccessor levelaccessor, final double d0, final double d1, final double d2, final Entity entity, final Entity entity1) {
/*  45 */     if (entity != null && entity1 != null) {
/*  46 */       if (entity1 instanceof com.pla.annoyingvillagers.entity.PlayerNpcEntity) {
/*  47 */         new DelayedTask(Mth.m_216271_(RandomSource.m_216327_(), 70, 100))
/*     */           {
/*     */             public void run() {
/*  50 */               if (((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue()) {
/*  51 */                 if (Math.random() <= 0.05D) {
/*  52 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  53 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> fw"), false);
/*     */                   }
/*  55 */                 } else if (Math.random() <= 0.05D) {
/*  56 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  57 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Is that all ?"), false);
/*     */                   }
/*  59 */                 } else if (Math.random() <= 0.05D) {
/*  60 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  61 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> LLLLLLLLLLLLL"), false);
/*     */                   }
/*  63 */                 } else if (Math.random() <= 0.05D) {
/*  64 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  65 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Hey, what happened to you?"), false);
/*     */                   }
/*  67 */                 } else if (Math.random() <= 0.05D) {
/*  68 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  69 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Poet's grasp"), false);
/*     */ 
/*     */                   
/*     */                   }
/*     */                 
/*     */                 }
/*  75 */                 else if (Math.random() <= 0.05D) {
/*  76 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  77 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/*  78 */                     String s = entity1.m_5446_().getString();
/*  79 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", is that all the strength you've got?"), false);
/*     */                   } 
/*  81 */                 } else if (Math.random() <= 0.1D) {
/*  82 */                   if (ForgeRegistries.ENTITY_TYPES.getKey(entity.m_6095_()).toString().equals("minecraft:player") && !levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  83 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/*  84 */                     String s = entity1.m_5446_().getString();
/*  85 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", that's all the Little Hajiki can do?"), false);
/*     */                   } 
/*  87 */                 } else if (Math.random() <= 0.05D) {
/*  88 */                   if (ForgeRegistries.ENTITY_TYPES.getKey(entity.m_6095_()).toString().equals("minecraft:player") && !levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  89 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/*  90 */                     String s = entity1.m_5446_().getString();
/*  91 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", you're godlike too"), false);
/*     */                   } 
/*  93 */                 } else if (Math.random() <= 0.05D) {
/*  94 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/*  95 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/*  96 */                     String s = entity1.m_5446_().getString();
/*  97 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> Hahaha 😂 so funny, a " + entity.m_5446_().getString() + " is lying in bed, rhythmically chanting “Garen~ fafah”"), false);
/*     */                   } 
/*  99 */                 } else if (Math.random() <= 0.05D) {
/* 100 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 101 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 102 */                     String s = entity1.m_5446_().getString();
/* 103 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", don't act tough if you're weak"), false);
/*     */                   } 
/* 105 */                 } else if (Math.random() <= 0.05D) {
/* 106 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 107 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 108 */                     String s = entity1.m_5446_().getString();
/* 109 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + " plays like a bot"), false);
/*     */                   } 
/* 111 */                 } else if (Math.random() <= 0.05D) {
/* 112 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 113 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 114 */                     String s = entity1.m_5446_().getString();
/* 115 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", I'm dying of laughter, a total 🤡"), false);
/*     */                   } 
/* 117 */                 } else if (Math.random() <= 0.05D) {
/* 118 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 119 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 120 */                     String s = entity1.m_5446_().getString();
/* 121 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> Even giving it your all, you still can't defeat me? Haki " + entity.m_5446_().getString() + ", you bastard!"), false);
/*     */                   } 
/* 123 */                 } else if (Math.random() <= 0.05D) {
/* 124 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 125 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 126 */                     String s = entity1.m_5446_().getString();
/* 127 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> Joke " + entity.m_5446_().getString()), false);
/*     */                   } 
/* 129 */                 } else if (Math.random() <= 0.05D) {
/* 130 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 131 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 132 */                     String s = entity1.m_5446_().getString();
/* 133 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", weren't you acting all tough, bro?"), false);
/*     */                   } 
/* 135 */                 } else if (Math.random() <= 0.05D) {
/* 136 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 137 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> lol"), false);
/*     */                   }
/* 139 */                 } else if (Math.random() <= 0.05D) {
/* 140 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 141 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 142 */                     String s = entity1.m_5446_().getString();
/* 143 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + "🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕 So weak!"), false);
/*     */                   } 
/* 145 */                 } else if (Math.random() <= 0.05D) {
/* 146 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 147 */                     PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 148 */                     String s = entity1.m_5446_().getString();
/* 149 */                     playerlist.m_240416_((Component)Component.m_237113_("<" + s + "> " + entity.m_5446_().getString() + ", if you're bad, just practice more, little bro"), false);
/*     */                   } 
/* 151 */                 } else if (Math.random() <= 0.05D) {
/* 152 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 153 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> It's over"), false);
/*     */                   }
/* 155 */                 } else if (Math.random() <= 0.05D) {
/* 156 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 157 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Haha, you're getting mad"), false);
/*     */                   }
/* 159 */                 } else if (Math.random() <= 0.05D) {
/* 160 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 161 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Oh really?"), false);
/*     */                   }
/* 163 */                 } else if (Math.random() <= 0.05D) {
/* 164 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 165 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> 🤓🤓🤓"), false);
/*     */                   }
/* 167 */                 } else if (Math.random() <= 0.05D) {
/* 168 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 169 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> I pinned you to the ground and beat you up, haha"), false);
/*     */                   }
/* 171 */                 } else if (Math.random() <= 0.05D) {
/* 172 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 173 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> So bad? Could it be that you've played too much Genshin Impact?😅"), false);
/*     */                   }
/* 175 */                 } else if (Math.random() <= 0.05D) {
/* 176 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 177 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + "> Desperate now?"), false);
/*     */                   }
/* 179 */                 } else if (Math.random() <= 0.05D && !levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 180 */                   levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity1.m_5446_().getString() + ">, all you can do is spam left-click to death🤓"), false);
/*     */                 } 
/*     */               }
/*     */             }
/*     */           };
/*     */       }
/*     */ 
/*     */       
/* 188 */       if (entity instanceof com.pla.annoyingvillagers.entity.PlayerNpcEntity) {
/* 189 */         if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 190 */           PlayerList playerlist = levelaccessor.m_7654_().m_6846_();
/* 191 */           String s = entity.m_5446_().getString();
/*     */           
/* 193 */           if (((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue()) {
/* 194 */             playerlist.m_240416_((Component)Component.m_237113_(s + " was killed by " + s), false);
/*     */           }
/*     */         } 
/*     */         
/* 198 */         new DelayedTask(5)
/*     */           {
/*     */ 
/*     */ 
/*     */             
/*     */             public void run()
/*     */             {
/* 205 */               if (!entity.getPersistentData().m_128471_("die_by_possess")) {
/* 206 */                 LevelAccessor levelAccessor = levelaccessor;
/* 207 */                 LivingEntity livingentity = (LivingEntity)entity;
/*     */ 
/*     */                 
/* 210 */                 if (levelAccessor instanceof Level) {
/* 211 */                   Level level = (Level)levelAccessor;
/* 212 */                   if (!level.m_5776_()) {
/* 213 */                     ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 214 */                       itemstack = livingentity.m_6844_(EquipmentSlot.FEET);
/*     */                     } else {
/* 216 */                       itemstack = ItemStack.f_41583_;
/*     */                     } 
/*     */                     
/* 219 */                     ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 220 */                     itementity.m_32010_(10);
/* 221 */                     level.m_7967_((Entity)itementity);
/*     */                   } 
/*     */                 } 
/*     */                 
/* 225 */                 levelAccessor = levelaccessor;
/* 226 */                 if (levelAccessor instanceof Level) {
/* 227 */                   Level level = (Level)levelAccessor;
/* 228 */                   if (!level.m_5776_()) {
/* 229 */                     ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 230 */                       itemstack = livingentity.m_6844_(EquipmentSlot.LEGS);
/*     */                     } else {
/* 232 */                       itemstack = ItemStack.f_41583_;
/*     */                     } 
/*     */                     
/* 235 */                     ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 236 */                     itementity.m_32010_(10);
/* 237 */                     level.m_7967_((Entity)itementity);
/*     */                   } 
/*     */                 } 
/*     */                 
/* 241 */                 levelAccessor = levelaccessor;
/* 242 */                 if (levelAccessor instanceof Level) {
/* 243 */                   Level level = (Level)levelAccessor;
/* 244 */                   if (!level.m_5776_()) {
/* 245 */                     ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 246 */                       itemstack = livingentity.m_6844_(EquipmentSlot.CHEST);
/*     */                     } else {
/* 248 */                       itemstack = ItemStack.f_41583_;
/*     */                     } 
/*     */                     
/* 251 */                     ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 252 */                     itementity.m_32010_(10);
/* 253 */                     level.m_7967_((Entity)itementity);
/*     */                   } 
/*     */                 } 
/*     */                 
/* 257 */                 levelAccessor = levelaccessor;
/* 258 */                 if (levelAccessor instanceof Level) {
/* 259 */                   Level level = (Level)levelAccessor;
/* 260 */                   if (!level.m_5776_()) {
/* 261 */                     ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 262 */                       itemstack = livingentity.m_6844_(EquipmentSlot.HEAD);
/*     */                     } else {
/* 264 */                       itemstack = ItemStack.f_41583_;
/*     */                     } 
/*     */                     
/* 267 */                     ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 268 */                     itementity.m_32010_(10);
/* 269 */                     level.m_7967_((Entity)itementity);
/*     */                   } 
/*     */                 } 
/*     */                 
/* 273 */                 levelAccessor = levelaccessor;
/* 274 */                 if (levelAccessor instanceof Level) {
/* 275 */                   Level level = (Level)levelAccessor;
/* 276 */                   if (!level.m_5776_()) {
/* 277 */                     ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 278 */                       itemstack = livingentity.m_21205_();
/*     */                     } else {
/* 280 */                       itemstack = ItemStack.f_41583_;
/*     */                     } 
/*     */                     
/* 283 */                     ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 284 */                     itementity.m_32010_(10);
/* 285 */                     level.m_7967_((Entity)itementity);
/*     */                   } 
/*     */                 } 
/*     */                 
/* 289 */                 levelAccessor = levelaccessor;
/* 290 */                 if (levelAccessor instanceof Level) {
/* 291 */                   Level level = (Level)levelAccessor;
/* 292 */                   if (!level.m_5776_()) {
/* 293 */                     ItemStack itemstack; if (entity instanceof LivingEntity) {
/* 294 */                       itemstack = livingentity.m_21206_();
/*     */                     } else {
/* 296 */                       itemstack = ItemStack.f_41583_;
/*     */                     } 
/*     */                     
/* 299 */                     ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, itemstack);
/* 300 */                     itementity.m_32010_(10);
/* 301 */                     level.m_7967_((Entity)itementity);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */               
/* 306 */               LevelAccessor levelaccessor1 = levelaccessor;
/* 307 */               if (levelaccessor1 instanceof Level) {
/* 308 */                 Level level = (Level)levelaccessor1;
/* 309 */                 if (!level.m_5776_()) {
/* 310 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Blocks.f_50705_));
/* 311 */                   itementity.m_32010_(10);
/* 312 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 316 */               levelaccessor1 = levelaccessor;
/* 317 */               if (levelaccessor1 instanceof Level) {
/* 318 */                 Level level = (Level)levelaccessor1;
/* 319 */                 if (!level.m_5776_()) {
/* 320 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Blocks.f_50705_));
/* 321 */                   itementity.m_32010_(10);
/* 322 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 326 */               levelaccessor1 = levelaccessor;
/* 327 */               if (levelaccessor1 instanceof Level) {
/* 328 */                 Level level = (Level)levelaccessor1;
/* 329 */                 if (!level.m_5776_()) {
/* 330 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42411_));
/* 331 */                   itementity.m_32010_(10);
/* 332 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 336 */               levelaccessor1 = levelaccessor;
/* 337 */               if (levelaccessor1 instanceof Level) {
/* 338 */                 Level level = (Level)levelaccessor1;
/* 339 */                 if (!level.m_5776_()) {
/* 340 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42412_));
/* 341 */                   itementity.m_32010_(10);
/* 342 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 346 */               levelaccessor1 = levelaccessor;
/* 347 */               if (levelaccessor1 instanceof Level) {
/* 348 */                 Level level = (Level)levelaccessor1;
/* 349 */                 if (!level.m_5776_()) {
/* 350 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42412_));
/* 351 */                   itementity.m_32010_(10);
/* 352 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 356 */               levelaccessor1 = levelaccessor;
/* 357 */               if (levelaccessor1 instanceof Level) {
/* 358 */                 Level level = (Level)levelaccessor1;
/* 359 */                 if (!level.m_5776_()) {
/* 360 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42412_));
/* 361 */                   itementity.m_32010_(10);
/* 362 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 366 */               levelaccessor1 = levelaccessor;
/* 367 */               if (levelaccessor1 instanceof Level) {
/* 368 */                 Level level = (Level)levelaccessor1;
/* 369 */                 if (!level.m_5776_()) {
/* 370 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42412_));
/* 371 */                   itementity.m_32010_(10);
/* 372 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 376 */               levelaccessor1 = levelaccessor;
/* 377 */               if (levelaccessor1 instanceof Level) {
/* 378 */                 Level level = (Level)levelaccessor1;
/* 379 */                 if (!level.m_5776_()) {
/* 380 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42584_));
/* 381 */                   itementity.m_32010_(10);
/* 382 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 386 */               levelaccessor1 = levelaccessor;
/* 387 */               if (levelaccessor1 instanceof Level) {
/* 388 */                 Level level = (Level)levelaccessor1;
/* 389 */                 if (!level.m_5776_()) {
/* 390 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42584_));
/* 391 */                   itementity.m_32010_(10);
/* 392 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 396 */               levelaccessor1 = levelaccessor;
/* 397 */               if (levelaccessor1 instanceof Level) {
/* 398 */                 Level level = (Level)levelaccessor1;
/* 399 */                 if (!level.m_5776_()) {
/* 400 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42436_));
/* 401 */                   itementity.m_32010_(10);
/* 402 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */               
/* 406 */               levelaccessor1 = levelaccessor;
/* 407 */               if (levelaccessor1 instanceof Level) {
/* 408 */                 Level level = (Level)levelaccessor1;
/* 409 */                 if (!level.m_5776_()) {
/* 410 */                   ItemEntity itementity = new ItemEntity(level, d0, d1 + 1.0D, d2, new ItemStack((ItemLike)Items.f_42436_));
/* 411 */                   itementity.m_32010_(10);
/* 412 */                   level.m_7967_((Entity)itementity);
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           };
/* 417 */         if (((Boolean)AnnoyingVillagersConfig.TURN_ON_NPC_CHAT.get()).booleanValue())
/* 418 */           new DelayedTask(Mth.m_216271_(RandomSource.m_216327_(), 40, 80))
/*     */             {
/*     */               
/*     */               public void run()
/*     */               {
/* 423 */                 if (Math.random() <= 0.05D) {
/* 424 */                   Entity entity2 = entity;
/* 425 */                   if (!entity2.m_9236_().m_5776_() && entity2.m_20194_() != null) {
/*     */                     try {
/* 427 */                       entity2.m_20194_().m_129892_().m_82094_().execute("tellraw @a [{\"text\":\"<\"},{\"selector\":\"@s\"},{\"text\":\"> " + entity1
/* 428 */                           .m_5446_().getString() + " Bro, I'll remember you for this😡\"}]", entity2
/* 429 */                           .m_20203_().m_81324_().m_81325_(4));
/* 430 */                     } catch (CommandSyntaxException commandSyntaxException) {}
/*     */                   
/*     */                   }
/*     */                 }
/* 434 */                 else if (Math.random() <= 0.05D) {
/* 435 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 436 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> I'm breaking down😭"), false);
/*     */ 
/*     */                   
/*     */                   }
/*     */                 
/*     */                 }
/* 442 */                 else if (Math.random() <= 0.05D) {
/* 443 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 444 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 445 */                     String s1 = entity.m_5446_().getString();
/* 446 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", f** you"), false);
/*     */                   } 
/* 448 */                 } else if (Math.random() <= 0.05D) {
/* 449 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 450 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> So speechless😅"), false);
/*     */                   }
/* 452 */                 } else if (Math.random() <= 0.05D) {
/* 453 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 454 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> 666 this guy is a boss"), false);
/*     */                   }
/* 456 */                 } else if (Math.random() <= 0.05D) {
/* 457 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 458 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> That was tough😅"), false);
/*     */                   }
/* 460 */                 } else if (Math.random() <= 0.05D) {
/* 461 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 462 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> I really give up😭"), false);
/*     */                   }
/* 464 */                 } else if (Math.random() <= 0.05D) {
/* 465 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 466 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 467 */                     String s1 = entity.m_5446_().getString();
/* 468 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + " , your should die. F**"), false);
/*     */                   } 
/* 470 */                 } else if (Math.random() <= 0.05D) {
/* 471 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 472 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 473 */                     String s1 = entity.m_5446_().getString();
/* 474 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + " bro, be honest, are you hacking?😅"), false);
/*     */                   } 
/* 476 */                 } else if (Math.random() <= 0.05D) {
/* 477 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 478 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> Played as Bull Demon, lost all my gear😅"), false);
/*     */                   }
/* 480 */                 } else if (Math.random() <= 0.05D) {
/* 481 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 482 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 483 */                     String s1 = entity.m_5446_().getString();
/* 484 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", I'll get you later😡"), false);
/*     */                   } 
/* 486 */                 } else if (Math.random() <= 0.05D) {
/* 487 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 488 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 489 */                     String s1 = entity.m_5446_().getString();
/* 490 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", I will take revenge on you soon😡"), false);
/*     */                   } 
/* 492 */                 } else if (Math.random() <= 0.05D) {
/* 493 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 494 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 495 */                     String s1 = entity.m_5446_().getString();
/* 496 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", f*** you! Dare to fight fair with proper gear?😡"), false);
/*     */                   } 
/* 498 */                 } else if (Math.random() <= 0.05D) {
/* 499 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 500 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 501 */                     String s1 = entity.m_5446_().getString();
/* 502 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", you're dead for sure"), false);
/*     */                   } 
/* 504 */                 } else if (Math.random() <= 0.05D) {
/* 505 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 506 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 507 */                     String s1 = entity.m_5446_().getString();
/* 508 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", you just killed me like that. Are you happy now?😅"), false);
/*     */                   } 
/* 510 */                 } else if (Math.random() <= 0.05D) {
/* 511 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 512 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 513 */                     String s1 = entity.m_5446_().getString();
/* 514 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> Please, " + entity1.m_5446_().getString() + ", don't burnt my items !!!!"), false);
/*     */                   } 
/* 516 */                 } else if (Math.random() <= 0.05D) {
/* 517 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 518 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> ????????????????????????????????"), false);
/*     */                   }
/* 520 */                 } else if (Math.random() <= 0.05D) {
/* 521 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 522 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> I haven't even gotten serious yet"), false);
/*     */                   }
/* 524 */                 } else if (Math.random() <= 0.05D) {
/* 525 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 526 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 527 */                     String s1 = entity.m_5446_().getString();
/* 528 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", I'll get you next time😡"), false);
/*     */                   } 
/* 530 */                 } else if (Math.random() <= 0.05D) {
/* 531 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 532 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 533 */                     String s1 = entity.m_5446_().getString();
/* 534 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", you are really a 🐶"), false);
/*     */                   } 
/* 536 */                 } else if (Math.random() <= 0.05D) {
/* 537 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 538 */                     PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 539 */                     String s1 = entity.m_5446_().getString();
/* 540 */                     playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + " , ambushing an ordinary player like me, is this okay? No, it's not👎"), false);
/*     */                   } 
/* 542 */                 } else if (Math.random() <= 0.05D) {
/* 543 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 544 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> ......"), false);
/*     */                   }
/* 546 */                 } else if (Math.random() <= 0.05D) {
/* 547 */                   if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 548 */                     levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> Idiot, f** you 🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕"), false);
/*     */                   }
/* 550 */                 } else if (Math.random() <= 0.05D) {
/* 551 */                   Entity entity2 = entity;
/* 552 */                   if (!entity2.m_9236_().m_5776_() && entity2.m_20194_() != null) {
/*     */                     try {
/* 554 */                       entity2.m_20194_().m_129892_().m_82094_().execute("tellraw @a [{\"text\":\"<\"},{\"selector\":\"@s\"},{\"text\":\"> Don't leave, I'm calling some people😡😡😡\"}]", entity2
/*     */                           
/* 556 */                           .m_20203_().m_81324_().m_81325_(4));
/* 557 */                     } catch (CommandSyntaxException commandSyntaxException) {}
/*     */                   }
/*     */ 
/*     */ 
/*     */                   
/* 562 */                   new DelayedTask(50)
/*     */                     {
/*     */                       public void run() {
/*     */                         try {
/* 566 */                           entity.m_20194_().m_129892_().m_82094_().execute("summon annoyingvillagers:player_npc", entity
/*     */                               
/* 568 */                               .m_20203_().m_81324_().m_81325_(4));
/*     */                         }
/* 570 */                         catch (CommandSyntaxException commandSyntaxException) {}
/*     */                       }
/*     */                     };
/*     */ 
/*     */ 
/*     */                   
/* 576 */                   new DelayedTask(20)
/*     */                     {
/*     */                       public void run() {
/*     */                         try {
/* 580 */                           entity.m_20194_().m_129892_().m_82094_().execute("summon annoyingvillagers:player_npc", entity
/*     */                               
/* 582 */                               .m_20203_().m_81324_().m_81325_(4));
/*     */                         }
/* 584 */                         catch (CommandSyntaxException commandSyntaxException) {}
/*     */                       }
/*     */                     };
/*     */ 
/*     */ 
/*     */                   
/* 590 */                   new DelayedTask(20)
/*     */                     {
/*     */                       public void run() {
/*     */                         try {
/* 594 */                           entity.m_20194_().m_129892_().m_82094_().execute("summon annoyingvillagers:player_npc", entity
/*     */                               
/* 596 */                               .m_20203_().m_81324_().m_81325_(4));
/*     */                         }
/* 598 */                         catch (CommandSyntaxException commandSyntaxException) {}
/*     */                       }
/*     */                     };
/*     */ 
/*     */ 
/*     */                   
/* 604 */                   new DelayedTask(20)
/*     */                     {
/*     */                       public void run() {
/*     */                         try {
/* 608 */                           entity.m_20194_().m_129892_().m_82094_().execute("tellraw @a [{\"text\":\"<\"},{\"selector\":\"@s\"},{\"text\":\"> Hmmm, you're here… bro.🤓\"}]", entity
/*     */                               
/* 610 */                               .m_20203_().m_81324_().m_81325_(4));
/*     */                         }
/* 612 */                         catch (CommandSyntaxException commandSyntaxException) {}
/*     */                       }
/*     */                     };
/*     */                 
/*     */                 }
/* 617 */                 else if (Math.random() <= 0.05D && !levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 618 */                   PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 619 */                   String s1 = entity.m_5446_().getString();
/* 620 */                   playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", using your OP weapon, is that fun for you?😅"), false);
/*     */                 } 
/*     */ 
/*     */                 
/* 624 */                 new DelayedTask(Mth.m_216271_(RandomSource.m_216327_(), 25, 100))
/*     */                   {
/*     */                     public void run() {
/* 627 */                       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null)
/* 628 */                         ChatUtil.leaveGame(entity); 
/*     */                     }
/*     */                   };
/*     */               }
/*     */             }; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\PlayerNpcDeadEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */