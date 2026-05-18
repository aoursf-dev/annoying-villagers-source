/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import com.pla.annoyingvillagers.util.ChatUtil;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.players.PlayerList;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.util.RandomSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.level.LevelAccessor;
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
/*     */   null(int waitTicks) {
/* 418 */     super(waitTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/* 423 */     if (Math.random() <= 0.05D) {
/* 424 */       Entity entity2 = entity;
/* 425 */       if (!entity2.m_9236_().m_5776_() && entity2.m_20194_() != null) {
/*     */         try {
/* 427 */           entity2.m_20194_().m_129892_().m_82094_().execute("tellraw @a [{\"text\":\"<\"},{\"selector\":\"@s\"},{\"text\":\"> " + entity1
/* 428 */               .m_5446_().getString() + " Bro, I'll remember you for this😡\"}]", entity2
/* 429 */               .m_20203_().m_81324_().m_81325_(4));
/* 430 */         } catch (CommandSyntaxException commandSyntaxException) {}
/*     */       
/*     */       }
/*     */     }
/* 434 */     else if (Math.random() <= 0.05D) {
/* 435 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 436 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> I'm breaking down😭"), false);
/*     */ 
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 442 */     else if (Math.random() <= 0.05D) {
/* 443 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 444 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 445 */         String s1 = entity.m_5446_().getString();
/* 446 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", f** you"), false);
/*     */       } 
/* 448 */     } else if (Math.random() <= 0.05D) {
/* 449 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 450 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> So speechless😅"), false);
/*     */       }
/* 452 */     } else if (Math.random() <= 0.05D) {
/* 453 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 454 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> 666 this guy is a boss"), false);
/*     */       }
/* 456 */     } else if (Math.random() <= 0.05D) {
/* 457 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 458 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> That was tough😅"), false);
/*     */       }
/* 460 */     } else if (Math.random() <= 0.05D) {
/* 461 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 462 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> I really give up😭"), false);
/*     */       }
/* 464 */     } else if (Math.random() <= 0.05D) {
/* 465 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 466 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 467 */         String s1 = entity.m_5446_().getString();
/* 468 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + " , your should die. F**"), false);
/*     */       } 
/* 470 */     } else if (Math.random() <= 0.05D) {
/* 471 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 472 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 473 */         String s1 = entity.m_5446_().getString();
/* 474 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + " bro, be honest, are you hacking?😅"), false);
/*     */       } 
/* 476 */     } else if (Math.random() <= 0.05D) {
/* 477 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 478 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> Played as Bull Demon, lost all my gear😅"), false);
/*     */       }
/* 480 */     } else if (Math.random() <= 0.05D) {
/* 481 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 482 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 483 */         String s1 = entity.m_5446_().getString();
/* 484 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", I'll get you later😡"), false);
/*     */       } 
/* 486 */     } else if (Math.random() <= 0.05D) {
/* 487 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 488 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 489 */         String s1 = entity.m_5446_().getString();
/* 490 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", I will take revenge on you soon😡"), false);
/*     */       } 
/* 492 */     } else if (Math.random() <= 0.05D) {
/* 493 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 494 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 495 */         String s1 = entity.m_5446_().getString();
/* 496 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", f*** you! Dare to fight fair with proper gear?😡"), false);
/*     */       } 
/* 498 */     } else if (Math.random() <= 0.05D) {
/* 499 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 500 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 501 */         String s1 = entity.m_5446_().getString();
/* 502 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", you're dead for sure"), false);
/*     */       } 
/* 504 */     } else if (Math.random() <= 0.05D) {
/* 505 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 506 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 507 */         String s1 = entity.m_5446_().getString();
/* 508 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", you just killed me like that. Are you happy now?😅"), false);
/*     */       } 
/* 510 */     } else if (Math.random() <= 0.05D) {
/* 511 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 512 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 513 */         String s1 = entity.m_5446_().getString();
/* 514 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> Please, " + entity1.m_5446_().getString() + ", don't burnt my items !!!!"), false);
/*     */       } 
/* 516 */     } else if (Math.random() <= 0.05D) {
/* 517 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 518 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> ????????????????????????????????"), false);
/*     */       }
/* 520 */     } else if (Math.random() <= 0.05D) {
/* 521 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 522 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> I haven't even gotten serious yet"), false);
/*     */       }
/* 524 */     } else if (Math.random() <= 0.05D) {
/* 525 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 526 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 527 */         String s1 = entity.m_5446_().getString();
/* 528 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", I'll get you next time😡"), false);
/*     */       } 
/* 530 */     } else if (Math.random() <= 0.05D) {
/* 531 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 532 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 533 */         String s1 = entity.m_5446_().getString();
/* 534 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", you are really a 🐶"), false);
/*     */       } 
/* 536 */     } else if (Math.random() <= 0.05D) {
/* 537 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 538 */         PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 539 */         String s1 = entity.m_5446_().getString();
/* 540 */         playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + " , ambushing an ordinary player like me, is this okay? No, it's not👎"), false);
/*     */       } 
/* 542 */     } else if (Math.random() <= 0.05D) {
/* 543 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 544 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> ......"), false);
/*     */       }
/* 546 */     } else if (Math.random() <= 0.05D) {
/* 547 */       if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 548 */         levelaccessor.m_7654_().m_6846_().m_240416_((Component)Component.m_237113_("<" + entity.m_5446_().getString() + "> Idiot, f** you 🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕🖕"), false);
/*     */       }
/* 550 */     } else if (Math.random() <= 0.05D) {
/* 551 */       Entity entity2 = entity;
/* 552 */       if (!entity2.m_9236_().m_5776_() && entity2.m_20194_() != null) {
/*     */         try {
/* 554 */           entity2.m_20194_().m_129892_().m_82094_().execute("tellraw @a [{\"text\":\"<\"},{\"selector\":\"@s\"},{\"text\":\"> Don't leave, I'm calling some people😡😡😡\"}]", entity2
/*     */               
/* 556 */               .m_20203_().m_81324_().m_81325_(4));
/* 557 */         } catch (CommandSyntaxException commandSyntaxException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 562 */       new DelayedTask(50)
/*     */         {
/*     */           public void run() {
/*     */             try {
/* 566 */               entity.m_20194_().m_129892_().m_82094_().execute("summon annoyingvillagers:player_npc", entity
/*     */                   
/* 568 */                   .m_20203_().m_81324_().m_81325_(4));
/*     */             }
/* 570 */             catch (CommandSyntaxException commandSyntaxException) {}
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 576 */       new DelayedTask(20)
/*     */         {
/*     */           public void run() {
/*     */             try {
/* 580 */               entity.m_20194_().m_129892_().m_82094_().execute("summon annoyingvillagers:player_npc", entity
/*     */                   
/* 582 */                   .m_20203_().m_81324_().m_81325_(4));
/*     */             }
/* 584 */             catch (CommandSyntaxException commandSyntaxException) {}
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 590 */       new DelayedTask(20)
/*     */         {
/*     */           public void run() {
/*     */             try {
/* 594 */               entity.m_20194_().m_129892_().m_82094_().execute("summon annoyingvillagers:player_npc", entity
/*     */                   
/* 596 */                   .m_20203_().m_81324_().m_81325_(4));
/*     */             }
/* 598 */             catch (CommandSyntaxException commandSyntaxException) {}
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 604 */       new DelayedTask(20)
/*     */         {
/*     */           public void run() {
/*     */             try {
/* 608 */               entity.m_20194_().m_129892_().m_82094_().execute("tellraw @a [{\"text\":\"<\"},{\"selector\":\"@s\"},{\"text\":\"> Hmmm, you're here… bro.🤓\"}]", entity
/*     */                   
/* 610 */                   .m_20203_().m_81324_().m_81325_(4));
/*     */             }
/* 612 */             catch (CommandSyntaxException commandSyntaxException) {}
/*     */           }
/*     */         };
/*     */     
/*     */     }
/* 617 */     else if (Math.random() <= 0.05D && !levelaccessor.m_5776_() && levelaccessor.m_7654_() != null) {
/* 618 */       PlayerList playerlist1 = levelaccessor.m_7654_().m_6846_();
/* 619 */       String s1 = entity.m_5446_().getString();
/* 620 */       playerlist1.m_240416_((Component)Component.m_237113_("<" + s1 + "> " + entity1.m_5446_().getString() + ", using your OP weapon, is that fun for you?😅"), false);
/*     */     } 
/*     */ 
/*     */     
/* 624 */     new DelayedTask(Mth.m_216271_(RandomSource.m_216327_(), 25, 100))
/*     */       {
/*     */         public void run() {
/* 627 */           if (!levelaccessor.m_5776_() && levelaccessor.m_7654_() != null)
/* 628 */             ChatUtil.leaveGame(entity); 
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\PlayerNpcDeadEvent$3.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */