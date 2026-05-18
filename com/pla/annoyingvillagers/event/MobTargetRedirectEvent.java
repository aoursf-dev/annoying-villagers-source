package com.pla.annoyingvillagers.event;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "annoyingvillagers", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MobTargetRedirectEvent {
  @SubscribeEvent
  public static void onLivingTick(LivingEvent.LivingTickEvent event) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getEntity : ()Lnet/minecraft/world/entity/LivingEntity;
    //   4: astore_1
    //   5: aload_1
    //   6: instanceof net/minecraft/world/entity/Mob
    //   9: ifeq -> 575
    //   12: aload_1
    //   13: checkcast net/minecraft/world/entity/Mob
    //   16: astore_2
    //   17: aload_2
    //   18: instanceof com/pla/annoyingvillagers/entity/BlueDemonEntity
    //   21: ifne -> 31
    //   24: aload_2
    //   25: instanceof com/pla/annoyingvillagers/entity/BbqEntity
    //   28: ifeq -> 32
    //   31: return
    //   32: aload_2
    //   33: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
    //   36: astore #4
    //   38: aload #4
    //   40: instanceof com/pla/annoyingvillagers/clazz/HerobrineMob
    //   43: ifeq -> 211
    //   46: aload #4
    //   48: checkcast com/pla/annoyingvillagers/clazz/HerobrineMob
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual isSacrificing : ()Z
    //   56: ifne -> 66
    //   59: aload_3
    //   60: invokevirtual isHealing : ()Z
    //   63: ifeq -> 211
    //   66: aload_3
    //   67: invokevirtual getFirstPossessedHerobrine : ()Lnet/minecraft/world/entity/Entity;
    //   70: ifnull -> 103
    //   73: aload_3
    //   74: invokevirtual getFirstPossessedHerobrine : ()Lnet/minecraft/world/entity/Entity;
    //   77: astore #8
    //   79: aload #8
    //   81: instanceof net/minecraft/world/entity/LivingEntity
    //   84: ifeq -> 103
    //   87: aload #8
    //   89: checkcast net/minecraft/world/entity/LivingEntity
    //   92: astore #4
    //   94: aload_2
    //   95: aload #4
    //   97: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   100: goto -> 211
    //   103: aload_3
    //   104: invokevirtual getSecondPossessedHerobrine : ()Lnet/minecraft/world/entity/Entity;
    //   107: ifnull -> 140
    //   110: aload_3
    //   111: invokevirtual getSecondPossessedHerobrine : ()Lnet/minecraft/world/entity/Entity;
    //   114: astore #8
    //   116: aload #8
    //   118: instanceof net/minecraft/world/entity/LivingEntity
    //   121: ifeq -> 140
    //   124: aload #8
    //   126: checkcast net/minecraft/world/entity/LivingEntity
    //   129: astore #5
    //   131: aload_2
    //   132: aload #5
    //   134: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   137: goto -> 211
    //   140: aload_3
    //   141: invokevirtual getThirdPossessedHerobrine : ()Lnet/minecraft/world/entity/Entity;
    //   144: ifnull -> 177
    //   147: aload_3
    //   148: invokevirtual getThirdPossessedHerobrine : ()Lnet/minecraft/world/entity/Entity;
    //   151: astore #8
    //   153: aload #8
    //   155: instanceof net/minecraft/world/entity/LivingEntity
    //   158: ifeq -> 177
    //   161: aload #8
    //   163: checkcast net/minecraft/world/entity/LivingEntity
    //   166: astore #6
    //   168: aload_2
    //   169: aload #6
    //   171: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   174: goto -> 211
    //   177: aload_3
    //   178: invokevirtual getFourthPossessedHerobrine : ()Lnet/minecraft/world/entity/Entity;
    //   181: ifnull -> 211
    //   184: aload_3
    //   185: invokevirtual getFourthPossessedHerobrine : ()Lnet/minecraft/world/entity/Entity;
    //   188: astore #8
    //   190: aload #8
    //   192: instanceof net/minecraft/world/entity/LivingEntity
    //   195: ifeq -> 211
    //   198: aload #8
    //   200: checkcast net/minecraft/world/entity/LivingEntity
    //   203: astore #7
    //   205: aload_2
    //   206: aload #7
    //   208: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   211: aload_2
    //   212: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
    //   215: astore #4
    //   217: aload #4
    //   219: instanceof com/pla/annoyingvillagers/entity/LowHerobrineCloneEntity
    //   222: ifeq -> 260
    //   225: aload #4
    //   227: checkcast com/pla/annoyingvillagers/entity/LowHerobrineCloneEntity
    //   230: astore_3
    //   231: aload_3
    //   232: invokevirtual isHealing : ()Z
    //   235: ifeq -> 260
    //   238: aload_3
    //   239: invokevirtual getPossessedByEntity : ()Lcom/pla/annoyingvillagers/clazz/HerobrineMob;
    //   242: ifnull -> 260
    //   245: aload_3
    //   246: invokevirtual m_6084_ : ()Z
    //   249: ifne -> 260
    //   252: aload_2
    //   253: aload_3
    //   254: invokevirtual getPossessedByEntity : ()Lcom/pla/annoyingvillagers/clazz/HerobrineMob;
    //   257: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   260: aload_2
    //   261: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
    //   264: astore #4
    //   266: aload #4
    //   268: instanceof com/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity
    //   271: ifeq -> 316
    //   274: aload #4
    //   276: checkcast com/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity
    //   279: astore_3
    //   280: aload_3
    //   281: invokevirtual isSacrificing : ()Z
    //   284: ifne -> 294
    //   287: aload_3
    //   288: invokevirtual isHealing : ()Z
    //   291: ifeq -> 316
    //   294: aload_3
    //   295: invokevirtual getPossessedByEntity : ()Lcom/pla/annoyingvillagers/clazz/HerobrineMob;
    //   298: ifnull -> 316
    //   301: aload_3
    //   302: invokevirtual m_6084_ : ()Z
    //   305: ifne -> 316
    //   308: aload_2
    //   309: aload_3
    //   310: invokevirtual getPossessedByEntity : ()Lcom/pla/annoyingvillagers/clazz/HerobrineMob;
    //   313: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   316: aload_2
    //   317: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
    //   320: astore #4
    //   322: aload #4
    //   324: instanceof com/pla/annoyingvillagers/entity/NullEntity
    //   327: ifeq -> 351
    //   330: aload #4
    //   332: checkcast com/pla/annoyingvillagers/entity/NullEntity
    //   335: astore_3
    //   336: aload_3
    //   337: invokevirtual getFirstWitherSkeleton : ()Lcom/pla/annoyingvillagers/entity/NullSkeletonEntity;
    //   340: ifnull -> 351
    //   343: aload_2
    //   344: aload_3
    //   345: invokevirtual getFirstWitherSkeleton : ()Lcom/pla/annoyingvillagers/entity/NullSkeletonEntity;
    //   348: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   351: aload_2
    //   352: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
    //   355: astore #4
    //   357: aload #4
    //   359: instanceof com/pla/annoyingvillagers/entity/NullEntity
    //   362: ifeq -> 386
    //   365: aload #4
    //   367: checkcast com/pla/annoyingvillagers/entity/NullEntity
    //   370: astore_3
    //   371: aload_3
    //   372: invokevirtual getSecondWitherSkeleton : ()Lcom/pla/annoyingvillagers/entity/NullSkeletonEntity;
    //   375: ifnull -> 386
    //   378: aload_2
    //   379: aload_3
    //   380: invokevirtual getSecondWitherSkeleton : ()Lcom/pla/annoyingvillagers/entity/NullSkeletonEntity;
    //   383: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   386: aload_2
    //   387: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
    //   390: astore #4
    //   392: aload #4
    //   394: instanceof com/pla/annoyingvillagers/entity/NullSkeletonEntity
    //   397: ifeq -> 428
    //   400: aload #4
    //   402: checkcast com/pla/annoyingvillagers/entity/NullSkeletonEntity
    //   405: astore_3
    //   406: aload_3
    //   407: invokevirtual getNullEntity : ()Lcom/pla/annoyingvillagers/entity/NullEntity;
    //   410: ifnull -> 428
    //   413: aload_3
    //   414: invokevirtual m_6084_ : ()Z
    //   417: ifne -> 428
    //   420: aload_2
    //   421: aload_3
    //   422: invokevirtual getNullEntity : ()Lcom/pla/annoyingvillagers/entity/NullEntity;
    //   425: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   428: aload_2
    //   429: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
    //   432: astore #5
    //   434: aload #5
    //   436: instanceof com/pla/annoyingvillagers/entity/ReaperHerobrineEntity
    //   439: ifeq -> 520
    //   442: aload #5
    //   444: checkcast com/pla/annoyingvillagers/entity/ReaperHerobrineEntity
    //   447: astore_3
    //   448: aload_3
    //   449: invokevirtual m_20159_ : ()Z
    //   452: ifeq -> 520
    //   455: aload_3
    //   456: invokevirtual m_20202_ : ()Lnet/minecraft/world/entity/Entity;
    //   459: astore #5
    //   461: aload #5
    //   463: instanceof com/pla/annoyingvillagers/entity/HerobrineDragonEntity
    //   466: ifeq -> 520
    //   469: aload #5
    //   471: checkcast com/pla/annoyingvillagers/entity/HerobrineDragonEntity
    //   474: astore #4
    //   476: aload_2
    //   477: aload #4
    //   479: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   482: aload_2
    //   483: ldc yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
    //   485: invokestatic getEntityPatch : (Lnet/minecraft/world/entity/Entity;Ljava/lang/Class;)Lyesman/epicfight/world/capabilities/entitypatch/EntityPatch;
    //   488: checkcast yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
    //   491: astore #5
    //   493: aload #5
    //   495: ifnull -> 520
    //   498: aload_2
    //   499: instanceof com/pla/annoyingvillagers/clazz/AVNpc
    //   502: ifne -> 512
    //   505: aload_2
    //   506: instanceof com/pla/annoyingvillagers/entity/PlayerNpcEntity
    //   509: ifeq -> 520
    //   512: aload #5
    //   514: checkcast yesman/epicfight/world/capabilities/entitypatch/MobPatch
    //   517: invokestatic swapToBow : (Lyesman/epicfight/world/capabilities/entitypatch/MobPatch;)V
    //   520: aload_2
    //   521: invokevirtual m_5448_ : ()Lnet/minecraft/world/entity/LivingEntity;
    //   524: astore #5
    //   526: aload #5
    //   528: instanceof com/pla/annoyingvillagers/entity/HerobrineDragonEntity
    //   531: ifeq -> 575
    //   534: aload #5
    //   536: checkcast com/pla/annoyingvillagers/entity/HerobrineDragonEntity
    //   539: astore_3
    //   540: aload_3
    //   541: invokevirtual getSummoner : ()Lnet/minecraft/world/entity/LivingEntity;
    //   544: astore #5
    //   546: aload #5
    //   548: instanceof com/pla/annoyingvillagers/entity/ReaperHerobrineEntity
    //   551: ifeq -> 575
    //   554: aload #5
    //   556: checkcast com/pla/annoyingvillagers/entity/ReaperHerobrineEntity
    //   559: astore #4
    //   561: aload #4
    //   563: invokevirtual m_20159_ : ()Z
    //   566: ifne -> 575
    //   569: aload_2
    //   570: aload #4
    //   572: invokevirtual m_6710_ : (Lnet/minecraft/world/entity/LivingEntity;)V
    //   575: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #21	-> 0
    //   #22	-> 5
    //   #23	-> 17
    //   #24	-> 32
    //   #25	-> 53
    //   #26	-> 66
    //   #27	-> 73
    //   #28	-> 94
    //   #29	-> 103
    //   #30	-> 110
    //   #31	-> 131
    //   #32	-> 140
    //   #33	-> 147
    //   #34	-> 168
    //   #35	-> 177
    //   #36	-> 184
    //   #37	-> 205
    //   #41	-> 211
    //   #42	-> 232
    //   #43	-> 239
    //   #44	-> 245
    //   #45	-> 252
    //   #49	-> 260
    //   #50	-> 281
    //   #51	-> 295
    //   #52	-> 301
    //   #53	-> 308
    //   #57	-> 316
    //   #58	-> 337
    //   #59	-> 343
    //   #62	-> 351
    //   #63	-> 372
    //   #64	-> 378
    //   #67	-> 386
    //   #68	-> 407
    //   #69	-> 413
    //   #70	-> 420
    //   #74	-> 428
    //   #75	-> 449
    //   #76	-> 476
    //   #77	-> 482
    //   #78	-> 493
    //   #79	-> 512
    //   #83	-> 520
    //   #84	-> 540
    //   #85	-> 569
    //   #88	-> 575
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   94	9	4	living	Lnet/minecraft/world/entity/LivingEntity;
    //   131	9	5	living	Lnet/minecraft/world/entity/LivingEntity;
    //   168	9	6	living	Lnet/minecraft/world/entity/LivingEntity;
    //   205	6	7	living	Lnet/minecraft/world/entity/LivingEntity;
    //   52	159	3	herobrineMob	Lcom/pla/annoyingvillagers/clazz/HerobrineMob;
    //   231	29	3	lowHerobrineCloneEntity	Lcom/pla/annoyingvillagers/entity/LowHerobrineCloneEntity;
    //   280	36	3	lowShadowHerobrineCloneEntity	Lcom/pla/annoyingvillagers/entity/LowShadowHerobrineCloneEntity;
    //   336	15	3	nullEntity	Lcom/pla/annoyingvillagers/entity/NullEntity;
    //   371	15	3	nullEntity	Lcom/pla/annoyingvillagers/entity/NullEntity;
    //   406	22	3	nullSkeletonEntity	Lcom/pla/annoyingvillagers/entity/NullSkeletonEntity;
    //   493	27	5	livingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;
    //   448	72	3	reaperHerobrineEntity	Lcom/pla/annoyingvillagers/entity/ReaperHerobrineEntity;
    //   476	44	4	herobrineDragonEntity	Lcom/pla/annoyingvillagers/entity/HerobrineDragonEntity;
    //   540	35	3	herobrineDragonEntity	Lcom/pla/annoyingvillagers/entity/HerobrineDragonEntity;
    //   561	14	4	reaperHerobrineEntity	Lcom/pla/annoyingvillagers/entity/ReaperHerobrineEntity;
    //   17	558	2	mob	Lnet/minecraft/world/entity/Mob;
    //   0	576	0	event	Lnet/minecraftforge/event/entity/living/LivingEvent$LivingTickEvent;
    //   5	571	1	livingEntity	Lnet/minecraft/world/entity/LivingEntity;
    // Local variable type table:
    //   start	length	slot	name	signature
    //   493	27	5	livingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch<*>;
  }
}


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\MobTargetRedirectEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */