/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.eventbus.api.Event;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class EnchantBedDeathEvent
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onEntityDeath(LivingDeathEvent livingdeathevent) {
/*  26 */     if (livingdeathevent != null && livingdeathevent.getEntity() != null) {
/*  27 */       execute((Event)livingdeathevent, (LevelAccessor)livingdeathevent.getEntity().m_9236_(), (Entity)livingdeathevent.getEntity(), livingdeathevent.getSource().m_7639_());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void execute(LevelAccessor levelaccessor, Entity entity, Entity entity1) {
/*  33 */     execute((Event)null, levelaccessor, entity, entity1);
/*     */   }
/*     */   
/*     */   private static void execute(@Nullable Event event, LevelAccessor levelaccessor, Entity entity, Entity entity1) {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: ifnull -> 798
/*     */     //   4: aload_3
/*     */     //   5: ifnull -> 798
/*     */     //   8: aload_2
/*     */     //   9: instanceof net/minecraft/world/entity/LivingEntity
/*     */     //   12: ifeq -> 720
/*     */     //   15: aload_2
/*     */     //   16: checkcast net/minecraft/world/entity/LivingEntity
/*     */     //   19: astore #4
/*     */     //   21: aload #4
/*     */     //   23: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModMobEffects.ENCHANT_BED_EFFECT : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   26: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   29: checkcast net/minecraft/world/effect/MobEffect
/*     */     //   32: invokevirtual m_21023_ : (Lnet/minecraft/world/effect/MobEffect;)Z
/*     */     //   35: ifeq -> 720
/*     */     //   38: aload_2
/*     */     //   39: instanceof net/minecraft/world/entity/LivingEntity
/*     */     //   42: ifeq -> 58
/*     */     //   45: aload_2
/*     */     //   46: checkcast net/minecraft/world/entity/LivingEntity
/*     */     //   49: astore #8
/*     */     //   51: aload #8
/*     */     //   53: ldc 20.0
/*     */     //   55: invokevirtual m_21153_ : (F)V
/*     */     //   58: aload_0
/*     */     //   59: ifnull -> 74
/*     */     //   62: aload_0
/*     */     //   63: invokevirtual isCancelable : ()Z
/*     */     //   66: ifeq -> 74
/*     */     //   69: aload_0
/*     */     //   70: iconst_1
/*     */     //   71: invokevirtual setCanceled : (Z)V
/*     */     //   74: aload_2
/*     */     //   75: instanceof net/minecraft/world/entity/player/Player
/*     */     //   78: ifeq -> 92
/*     */     //   81: aload_2
/*     */     //   82: checkcast net/minecraft/world/entity/player/Player
/*     */     //   85: astore #7
/*     */     //   87: aload #7
/*     */     //   89: invokevirtual m_6915_ : ()V
/*     */     //   92: aload_2
/*     */     //   93: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   96: ifeq -> 173
/*     */     //   99: aload_2
/*     */     //   100: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   103: astore #9
/*     */     //   105: aload #9
/*     */     //   107: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   110: invokevirtual m_5776_ : ()Z
/*     */     //   113: ifne -> 173
/*     */     //   116: aload #9
/*     */     //   118: invokevirtual m_8963_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   121: aload #9
/*     */     //   123: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   126: invokevirtual m_46472_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   129: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   132: ifeq -> 154
/*     */     //   135: aload #9
/*     */     //   137: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   140: ifnull -> 154
/*     */     //   143: aload #9
/*     */     //   145: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   148: invokevirtual m_123341_ : ()I
/*     */     //   151: goto -> 167
/*     */     //   154: aload #9
/*     */     //   156: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   159: invokevirtual m_6106_ : ()Lnet/minecraft/world/level/storage/LevelData;
/*     */     //   162: invokeinterface m_6789_ : ()I
/*     */     //   167: i2d
/*     */     //   168: dstore #10
/*     */     //   170: goto -> 176
/*     */     //   173: dconst_0
/*     */     //   174: dstore #10
/*     */     //   176: aload_2
/*     */     //   177: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   180: ifeq -> 256
/*     */     //   183: aload_2
/*     */     //   184: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   187: astore #9
/*     */     //   189: aload #9
/*     */     //   191: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   194: invokevirtual m_5776_ : ()Z
/*     */     //   197: ifne -> 256
/*     */     //   200: aload #9
/*     */     //   202: invokevirtual m_8963_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   205: aload #9
/*     */     //   207: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   210: invokevirtual m_46472_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   213: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   216: ifeq -> 238
/*     */     //   219: aload #9
/*     */     //   221: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   224: ifnull -> 238
/*     */     //   227: aload #9
/*     */     //   229: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   232: invokevirtual m_123342_ : ()I
/*     */     //   235: goto -> 251
/*     */     //   238: aload #9
/*     */     //   240: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   243: invokevirtual m_6106_ : ()Lnet/minecraft/world/level/storage/LevelData;
/*     */     //   246: invokeinterface m_6527_ : ()I
/*     */     //   251: istore #12
/*     */     //   253: goto -> 259
/*     */     //   256: iconst_0
/*     */     //   257: istore #12
/*     */     //   259: iload #12
/*     */     //   261: iconst_1
/*     */     //   262: iadd
/*     */     //   263: i2d
/*     */     //   264: dstore #13
/*     */     //   266: aload_2
/*     */     //   267: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   270: ifeq -> 347
/*     */     //   273: aload_2
/*     */     //   274: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   277: astore #9
/*     */     //   279: aload #9
/*     */     //   281: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   284: invokevirtual m_5776_ : ()Z
/*     */     //   287: ifne -> 347
/*     */     //   290: aload #9
/*     */     //   292: invokevirtual m_8963_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   295: aload #9
/*     */     //   297: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   300: invokevirtual m_46472_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   303: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   306: ifeq -> 328
/*     */     //   309: aload #9
/*     */     //   311: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   314: ifnull -> 328
/*     */     //   317: aload #9
/*     */     //   319: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   322: invokevirtual m_123343_ : ()I
/*     */     //   325: goto -> 341
/*     */     //   328: aload #9
/*     */     //   330: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   333: invokevirtual m_6106_ : ()Lnet/minecraft/world/level/storage/LevelData;
/*     */     //   336: invokeinterface m_6526_ : ()I
/*     */     //   341: i2d
/*     */     //   342: dstore #15
/*     */     //   344: goto -> 350
/*     */     //   347: dconst_0
/*     */     //   348: dstore #15
/*     */     //   350: aload_2
/*     */     //   351: dload #10
/*     */     //   353: dload #13
/*     */     //   355: dload #15
/*     */     //   357: invokevirtual m_6021_ : (DDD)V
/*     */     //   360: aload_2
/*     */     //   361: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   364: ifeq -> 657
/*     */     //   367: aload_2
/*     */     //   368: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   371: astore #9
/*     */     //   373: aload #9
/*     */     //   375: getfield f_8906_ : Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
/*     */     //   378: astore #17
/*     */     //   380: aload_2
/*     */     //   381: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   384: ifeq -> 461
/*     */     //   387: aload_2
/*     */     //   388: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   391: astore #18
/*     */     //   393: aload #18
/*     */     //   395: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   398: invokevirtual m_5776_ : ()Z
/*     */     //   401: ifne -> 461
/*     */     //   404: aload #18
/*     */     //   406: invokevirtual m_8963_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   409: aload #18
/*     */     //   411: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   414: invokevirtual m_46472_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   417: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   420: ifeq -> 442
/*     */     //   423: aload #18
/*     */     //   425: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   428: ifnull -> 442
/*     */     //   431: aload #18
/*     */     //   433: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   436: invokevirtual m_123341_ : ()I
/*     */     //   439: goto -> 455
/*     */     //   442: aload #18
/*     */     //   444: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   447: invokevirtual m_6106_ : ()Lnet/minecraft/world/level/storage/LevelData;
/*     */     //   450: invokeinterface m_6789_ : ()I
/*     */     //   455: i2d
/*     */     //   456: dstore #10
/*     */     //   458: goto -> 464
/*     */     //   461: dconst_0
/*     */     //   462: dstore #10
/*     */     //   464: aload_2
/*     */     //   465: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   468: ifeq -> 544
/*     */     //   471: aload_2
/*     */     //   472: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   475: astore #18
/*     */     //   477: aload #18
/*     */     //   479: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   482: invokevirtual m_5776_ : ()Z
/*     */     //   485: ifne -> 544
/*     */     //   488: aload #18
/*     */     //   490: invokevirtual m_8963_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   493: aload #18
/*     */     //   495: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   498: invokevirtual m_46472_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   501: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   504: ifeq -> 526
/*     */     //   507: aload #18
/*     */     //   509: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   512: ifnull -> 526
/*     */     //   515: aload #18
/*     */     //   517: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   520: invokevirtual m_123342_ : ()I
/*     */     //   523: goto -> 539
/*     */     //   526: aload #18
/*     */     //   528: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   531: invokevirtual m_6106_ : ()Lnet/minecraft/world/level/storage/LevelData;
/*     */     //   534: invokeinterface m_6527_ : ()I
/*     */     //   539: istore #12
/*     */     //   541: goto -> 547
/*     */     //   544: iconst_0
/*     */     //   545: istore #12
/*     */     //   547: iload #12
/*     */     //   549: iconst_1
/*     */     //   550: iadd
/*     */     //   551: i2d
/*     */     //   552: dstore #13
/*     */     //   554: aload_2
/*     */     //   555: instanceof net/minecraft/server/level/ServerPlayer
/*     */     //   558: ifeq -> 635
/*     */     //   561: aload_2
/*     */     //   562: checkcast net/minecraft/server/level/ServerPlayer
/*     */     //   565: astore #18
/*     */     //   567: aload #18
/*     */     //   569: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   572: invokevirtual m_5776_ : ()Z
/*     */     //   575: ifne -> 635
/*     */     //   578: aload #18
/*     */     //   580: invokevirtual m_8963_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   583: aload #18
/*     */     //   585: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   588: invokevirtual m_46472_ : ()Lnet/minecraft/resources/ResourceKey;
/*     */     //   591: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   594: ifeq -> 616
/*     */     //   597: aload #18
/*     */     //   599: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   602: ifnull -> 616
/*     */     //   605: aload #18
/*     */     //   607: invokevirtual m_8961_ : ()Lnet/minecraft/core/BlockPos;
/*     */     //   610: invokevirtual m_123343_ : ()I
/*     */     //   613: goto -> 629
/*     */     //   616: aload #18
/*     */     //   618: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   621: invokevirtual m_6106_ : ()Lnet/minecraft/world/level/storage/LevelData;
/*     */     //   624: invokeinterface m_6526_ : ()I
/*     */     //   629: i2d
/*     */     //   630: dstore #15
/*     */     //   632: goto -> 638
/*     */     //   635: dconst_0
/*     */     //   636: dstore #15
/*     */     //   638: aload #17
/*     */     //   640: dload #10
/*     */     //   642: dload #13
/*     */     //   644: dload #15
/*     */     //   646: aload_2
/*     */     //   647: invokevirtual m_146908_ : ()F
/*     */     //   650: aload_2
/*     */     //   651: invokevirtual m_146909_ : ()F
/*     */     //   654: invokevirtual m_9774_ : (DDDFF)V
/*     */     //   657: aload_2
/*     */     //   658: instanceof net/minecraft/world/entity/LivingEntity
/*     */     //   661: ifeq -> 685
/*     */     //   664: aload_2
/*     */     //   665: checkcast net/minecraft/world/entity/LivingEntity
/*     */     //   668: astore #8
/*     */     //   670: aload #8
/*     */     //   672: getstatic com/pla/annoyingvillagers/init/AnnoyingVillagersModMobEffects.ENCHANT_BED_EFFECT : Lnet/minecraftforge/registries/RegistryObject;
/*     */     //   675: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   678: checkcast net/minecraft/world/effect/MobEffect
/*     */     //   681: invokevirtual m_21195_ : (Lnet/minecraft/world/effect/MobEffect;)Z
/*     */     //   684: pop
/*     */     //   685: aload_2
/*     */     //   686: instanceof net/minecraft/world/entity/player/Player
/*     */     //   689: ifeq -> 720
/*     */     //   692: aload_2
/*     */     //   693: checkcast net/minecraft/world/entity/player/Player
/*     */     //   696: astore #7
/*     */     //   698: aload #7
/*     */     //   700: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*     */     //   703: invokevirtual m_5776_ : ()Z
/*     */     //   706: ifne -> 720
/*     */     //   709: aload #7
/*     */     //   711: ldc 'Your enchanted bed has saved you once. Right-click again to use it again!'
/*     */     //   713: invokestatic m_237113_ : (Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;
/*     */     //   716: iconst_1
/*     */     //   717: invokevirtual m_5661_ : (Lnet/minecraft/network/chat/Component;Z)V
/*     */     //   720: aload_2
/*     */     //   721: instanceof net/minecraft/world/entity/LivingEntity
/*     */     //   724: ifeq -> 798
/*     */     //   727: aload_2
/*     */     //   728: checkcast net/minecraft/world/entity/LivingEntity
/*     */     //   731: astore #4
/*     */     //   733: aload #4
/*     */     //   735: getstatic net/minecraft/world/item/Items.f_42747_ : Lnet/minecraft/world/item/Item;
/*     */     //   738: invokevirtual m_21055_ : (Lnet/minecraft/world/item/Item;)Z
/*     */     //   741: ifeq -> 798
/*     */     //   744: aload_2
/*     */     //   745: invokevirtual m_6074_ : ()V
/*     */     //   748: aload_2
/*     */     //   749: instanceof net/minecraft/world/entity/player/Player
/*     */     //   752: ifeq -> 798
/*     */     //   755: aload_2
/*     */     //   756: checkcast net/minecraft/world/entity/player/Player
/*     */     //   759: astore #7
/*     */     //   761: new net/minecraft/world/item/ItemStack
/*     */     //   764: dup
/*     */     //   765: getstatic net/minecraft/world/item/Items.f_42747_ : Lnet/minecraft/world/item/Item;
/*     */     //   768: invokespecial <init> : (Lnet/minecraft/world/level/ItemLike;)V
/*     */     //   771: astore #8
/*     */     //   773: aload #7
/*     */     //   775: invokevirtual m_150109_ : ()Lnet/minecraft/world/entity/player/Inventory;
/*     */     //   778: aload #8
/*     */     //   780: <illegal opcode> test : (Lnet/minecraft/world/item/ItemStack;)Ljava/util/function/Predicate;
/*     */     //   785: iconst_1
/*     */     //   786: aload #7
/*     */     //   788: getfield f_36095_ : Lnet/minecraft/world/inventory/InventoryMenu;
/*     */     //   791: invokevirtual m_39730_ : ()Lnet/minecraft/world/inventory/CraftingContainer;
/*     */     //   794: invokevirtual m_36022_ : (Ljava/util/function/Predicate;ILnet/minecraft/world/Container;)I
/*     */     //   797: pop
/*     */     //   798: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #37	-> 0
/*     */     //   #43	-> 8
/*     */     //   #44	-> 15
/*     */     //   #45	-> 21
/*     */     //   #47	-> 38
/*     */     //   #48	-> 45
/*     */     //   #49	-> 51
/*     */     //   #52	-> 58
/*     */     //   #53	-> 69
/*     */     //   #56	-> 74
/*     */     //   #57	-> 81
/*     */     //   #58	-> 87
/*     */     //   #64	-> 92
/*     */     //   #65	-> 99
/*     */     //   #66	-> 105
/*     */     //   #67	-> 116
/*     */     //   #68	-> 170
/*     */     //   #72	-> 173
/*     */     //   #77	-> 176
/*     */     //   #78	-> 183
/*     */     //   #79	-> 189
/*     */     //   #80	-> 200
/*     */     //   #81	-> 253
/*     */     //   #85	-> 256
/*     */     //   #91	-> 259
/*     */     //   #92	-> 266
/*     */     //   #93	-> 273
/*     */     //   #94	-> 279
/*     */     //   #95	-> 290
/*     */     //   #96	-> 344
/*     */     //   #100	-> 347
/*     */     //   #103	-> 350
/*     */     //   #104	-> 360
/*     */     //   #107	-> 367
/*     */     //   #108	-> 373
/*     */     //   #109	-> 380
/*     */     //   #110	-> 387
/*     */     //   #112	-> 393
/*     */     //   #113	-> 404
/*     */     //   #114	-> 458
/*     */     //   #118	-> 461
/*     */     //   #122	-> 464
/*     */     //   #123	-> 471
/*     */     //   #125	-> 477
/*     */     //   #126	-> 488
/*     */     //   #127	-> 541
/*     */     //   #131	-> 544
/*     */     //   #135	-> 547
/*     */     //   #136	-> 554
/*     */     //   #137	-> 561
/*     */     //   #139	-> 567
/*     */     //   #140	-> 578
/*     */     //   #141	-> 632
/*     */     //   #145	-> 635
/*     */     //   #148	-> 638
/*     */     //   #151	-> 657
/*     */     //   #152	-> 664
/*     */     //   #153	-> 670
/*     */     //   #156	-> 685
/*     */     //   #157	-> 692
/*     */     //   #158	-> 698
/*     */     //   #159	-> 709
/*     */     //   #165	-> 720
/*     */     //   #166	-> 727
/*     */     //   #167	-> 733
/*     */     //   #168	-> 744
/*     */     //   #169	-> 748
/*     */     //   #170	-> 755
/*     */     //   #171	-> 761
/*     */     //   #173	-> 773
/*     */     //   #175	-> 791
/*     */     //   #173	-> 794
/*     */     //   #180	-> 798
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   51	7	8	livingentity2	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   87	5	7	player	Lnet/minecraft/world/entity/player/Player;
/*     */     //   105	68	9	serverplayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   170	3	10	d0	D
/*     */     //   189	67	9	serverplayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   253	3	12	i	I
/*     */     //   279	68	9	serverplayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   344	3	15	d2	D
/*     */     //   393	68	18	serverplayer1	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   477	67	18	serverplayer2	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   567	68	18	serverplayer3	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   380	277	17	servergamepacketlistenerimpl	Lnet/minecraft/server/network/ServerGamePacketListenerImpl;
/*     */     //   373	284	9	serverplayer	Lnet/minecraft/server/level/ServerPlayer;
/*     */     //   670	15	8	livingentity2	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   698	22	7	player	Lnet/minecraft/world/entity/player/Player;
/*     */     //   176	544	10	d0	D
/*     */     //   259	461	12	i	I
/*     */     //   266	454	13	d1	D
/*     */     //   350	370	15	d2	D
/*     */     //   21	699	4	livingentity	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   773	25	8	itemstack	Lnet/minecraft/world/item/ItemStack;
/*     */     //   733	65	4	livingentity	Lnet/minecraft/world/entity/LivingEntity;
/*     */     //   761	37	7	player	Lnet/minecraft/world/entity/player/Player;
/*     */     //   0	799	0	event	Lnet/minecraftforge/eventbus/api/Event;
/*     */     //   0	799	1	levelaccessor	Lnet/minecraft/world/level/LevelAccessor;
/*     */     //   0	799	2	entity	Lnet/minecraft/world/entity/Entity;
/*     */     //   0	799	3	entity1	Lnet/minecraft/world/entity/Entity;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\EnchantBedDeathEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */