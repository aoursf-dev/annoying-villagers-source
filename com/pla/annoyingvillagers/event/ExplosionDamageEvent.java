/*    */ package com.pla.annoyingvillagers.event;
/*    */ 
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.event.level.ExplosionEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import reascer.wom.world.entity.mob.EnderHand;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class ExplosionDamageEvent {
/*    */   @SubscribeEvent
/*    */   public static void onExplode(ExplosionEvent.Detonate detonate) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual getExplosion : ()Lnet/minecraft/world/level/Explosion;
/*    */     //   4: invokevirtual m_253049_ : ()Lnet/minecraft/world/entity/Entity;
/*    */     //   7: instanceof com/pla/annoyingvillagers/entity/TridentLightningBolt
/*    */     //   10: ifeq -> 28
/*    */     //   13: aload_0
/*    */     //   14: invokevirtual getAffectedEntities : ()Ljava/util/List;
/*    */     //   17: <illegal opcode> test : ()Ljava/util/function/Predicate;
/*    */     //   22: invokeinterface removeIf : (Ljava/util/function/Predicate;)Z
/*    */     //   27: pop
/*    */     //   28: aload_0
/*    */     //   29: invokevirtual getExplosion : ()Lnet/minecraft/world/level/Explosion;
/*    */     //   32: invokevirtual m_252906_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   35: astore_1
/*    */     //   36: aload_0
/*    */     //   37: invokevirtual getExplosion : ()Lnet/minecraft/world/level/Explosion;
/*    */     //   40: invokevirtual getPosition : ()Lnet/minecraft/world/phys/Vec3;
/*    */     //   43: astore_2
/*    */     //   44: aload_1
/*    */     //   45: ifnull -> 733
/*    */     //   48: aload_1
/*    */     //   49: invokevirtual m_6084_ : ()Z
/*    */     //   52: ifeq -> 733
/*    */     //   55: aload_1
/*    */     //   56: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*    */     //   59: astore #4
/*    */     //   61: aload #4
/*    */     //   63: instanceof net/minecraft/server/level/ServerLevel
/*    */     //   66: ifeq -> 733
/*    */     //   69: aload #4
/*    */     //   71: checkcast net/minecraft/server/level/ServerLevel
/*    */     //   74: astore_3
/*    */     //   75: aload_1
/*    */     //   76: ldc yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*    */     //   78: invokestatic getEntityPatch : (Lnet/minecraft/world/entity/Entity;Ljava/lang/Class;)Lyesman/epicfight/world/capabilities/entitypatch/EntityPatch;
/*    */     //   81: checkcast yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*    */     //   84: astore #4
/*    */     //   86: aload #4
/*    */     //   88: ifnonnull -> 92
/*    */     //   91: return
/*    */     //   92: aload #4
/*    */     //   94: invokevirtual getAnimator : ()Lyesman/epicfight/api/animation/Animator;
/*    */     //   97: aconst_null
/*    */     //   98: invokevirtual getPlayerFor : (Lyesman/epicfight/api/asset/AssetAccessor;)Lyesman/epicfight/api/animation/AnimationPlayer;
/*    */     //   101: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   104: checkcast yesman/epicfight/api/animation/AnimationPlayer
/*    */     //   107: invokevirtual getRealAnimation : ()Lyesman/epicfight/api/asset/AssetAccessor;
/*    */     //   110: astore #5
/*    */     //   112: aload_1
/*    */     //   113: invokevirtual m_21205_ : ()Lnet/minecraft/world/item/ItemStack;
/*    */     //   116: invokevirtual m_41720_ : ()Lnet/minecraft/world/item/Item;
/*    */     //   119: instanceof com/pla/annoyingvillagers/item/EnderGlaiveItem
/*    */     //   122: ifeq -> 394
/*    */     //   125: aload #5
/*    */     //   127: getstatic com/pla/annoyingvillagers/gameasset/AVAnimations.ENDER_GLAIVE_AGONY_AUTO_1 : Lyesman/epicfight/api/animation/AnimationManager$AnimationAccessor;
/*    */     //   130: if_acmpeq -> 141
/*    */     //   133: aload #5
/*    */     //   135: getstatic com/pla/annoyingvillagers/gameasset/AVAnimations.ENDER_GLAIVE_NAPOLEON_SHOOT_3 : Lyesman/epicfight/api/animation/AnimationManager$AnimationAccessor;
/*    */     //   138: if_acmpne -> 394
/*    */     //   141: aconst_null
/*    */     //   142: astore #6
/*    */     //   144: aload #4
/*    */     //   146: instanceof yesman/epicfight/world/capabilities/entitypatch/player/ServerPlayerPatch
/*    */     //   149: ifeq -> 169
/*    */     //   152: aload #4
/*    */     //   154: checkcast yesman/epicfight/world/capabilities/entitypatch/player/ServerPlayerPatch
/*    */     //   157: astore #7
/*    */     //   159: aload #7
/*    */     //   161: getstatic com/pla/annoyingvillagers/gameasset/AVSkills.ENDER_GLAIVE : Lyesman/epicfight/skill/Skill;
/*    */     //   164: invokevirtual getSkill : (Lyesman/epicfight/skill/Skill;)Lyesman/epicfight/skill/SkillContainer;
/*    */     //   167: astore #6
/*    */     //   169: aload_0
/*    */     //   170: invokevirtual getAffectedEntities : ()Ljava/util/List;
/*    */     //   173: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   178: astore #7
/*    */     //   180: aload #7
/*    */     //   182: invokeinterface hasNext : ()Z
/*    */     //   187: ifeq -> 394
/*    */     //   190: aload #7
/*    */     //   192: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   197: checkcast net/minecraft/world/entity/Entity
/*    */     //   200: astore #8
/*    */     //   202: aload #8
/*    */     //   204: invokevirtual m_6084_ : ()Z
/*    */     //   207: ifeq -> 391
/*    */     //   210: aload #8
/*    */     //   212: aload_0
/*    */     //   213: invokevirtual getExplosion : ()Lnet/minecraft/world/level/Explosion;
/*    */     //   216: invokevirtual m_252906_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   219: if_acmpeq -> 391
/*    */     //   222: aload #8
/*    */     //   224: instanceof net/minecraft/world/entity/LivingEntity
/*    */     //   227: ifeq -> 391
/*    */     //   230: aload #8
/*    */     //   232: checkcast net/minecraft/world/entity/LivingEntity
/*    */     //   235: astore #9
/*    */     //   237: aload #8
/*    */     //   239: instanceof reascer/wom/world/entity/mob/EnderHand
/*    */     //   242: ifne -> 391
/*    */     //   245: aload #8
/*    */     //   247: instanceof net/minecraft/world/entity/player/Player
/*    */     //   250: ifeq -> 268
/*    */     //   253: aload #8
/*    */     //   255: checkcast net/minecraft/world/entity/player/Player
/*    */     //   258: astore #10
/*    */     //   260: aload #10
/*    */     //   262: invokevirtual m_7500_ : ()Z
/*    */     //   265: ifne -> 391
/*    */     //   268: aload #8
/*    */     //   270: ldc yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*    */     //   272: invokestatic getEntityPatch : (Lnet/minecraft/world/entity/Entity;Ljava/lang/Class;)Lyesman/epicfight/world/capabilities/entitypatch/EntityPatch;
/*    */     //   275: checkcast yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*    */     //   278: astore #11
/*    */     //   280: new com/pla/annoyingvillagers/event/ExplosionDamageEvent$1
/*    */     //   283: dup
/*    */     //   284: bipush #10
/*    */     //   286: aload_3
/*    */     //   287: aload #8
/*    */     //   289: aload_1
/*    */     //   290: aload #9
/*    */     //   292: invokespecial <init> : (ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/LivingEntity;)V
/*    */     //   295: pop
/*    */     //   296: aload #6
/*    */     //   298: ifnull -> 355
/*    */     //   301: aload #6
/*    */     //   303: invokevirtual getStack : ()I
/*    */     //   306: iconst_3
/*    */     //   307: if_icmpge -> 355
/*    */     //   310: aload #6
/*    */     //   312: invokevirtual getSkill : ()Lyesman/epicfight/skill/Skill;
/*    */     //   315: checkcast com/pla/annoyingvillagers/skill/EnderGlaiveSkill
/*    */     //   318: astore #12
/*    */     //   320: aload #6
/*    */     //   322: invokevirtual getResource : ()F
/*    */     //   325: fstore #13
/*    */     //   327: aload #6
/*    */     //   329: invokevirtual getNeededResource : ()F
/*    */     //   332: fstore #14
/*    */     //   334: ldc 50.0
/*    */     //   336: fload #14
/*    */     //   338: invokestatic min : (FF)F
/*    */     //   341: fstore #15
/*    */     //   343: aload #12
/*    */     //   345: aload #6
/*    */     //   347: fload #13
/*    */     //   349: fload #15
/*    */     //   351: fadd
/*    */     //   352: invokevirtual setConsumptionSynchronize : (Lyesman/epicfight/skill/SkillContainer;F)V
/*    */     //   355: aload #8
/*    */     //   357: aload #8
/*    */     //   359: invokevirtual m_9236_ : ()Lnet/minecraft/world/level/Level;
/*    */     //   362: invokevirtual m_269111_ : ()Lnet/minecraft/world/damagesource/DamageSources;
/*    */     //   365: aload_1
/*    */     //   366: invokevirtual m_269333_ : (Lnet/minecraft/world/entity/LivingEntity;)Lnet/minecraft/world/damagesource/DamageSource;
/*    */     //   369: ldc 12.0
/*    */     //   371: invokevirtual m_6469_ : (Lnet/minecraft/world/damagesource/DamageSource;F)Z
/*    */     //   374: pop
/*    */     //   375: aload_0
/*    */     //   376: invokevirtual getExplosion : ()Lnet/minecraft/world/level/Explosion;
/*    */     //   379: invokevirtual m_46077_ : ()Lnet/minecraft/world/damagesource/DamageSource;
/*    */     //   382: aload #11
/*    */     //   384: ldc2_w 0.20000000298023224
/*    */     //   387: iconst_0
/*    */     //   388: invokestatic dealStaminaDamageByPercentage : (Lnet/minecraft/world/damagesource/DamageSource;Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;DZ)V
/*    */     //   391: goto -> 180
/*    */     //   394: aload_1
/*    */     //   395: invokevirtual m_21205_ : ()Lnet/minecraft/world/item/ItemStack;
/*    */     //   398: invokevirtual m_41720_ : ()Lnet/minecraft/world/item/Item;
/*    */     //   401: instanceof com/pla/annoyingvillagers/item/WoopieTheSwordItem
/*    */     //   404: ifeq -> 733
/*    */     //   407: aload #5
/*    */     //   409: getstatic reascer/wom/gameasset/animations/weapons/AnimsHerrscher.HERRSCHER_AUTO_2 : Lyesman/epicfight/api/animation/AnimationManager$AnimationAccessor;
/*    */     //   412: if_acmpne -> 733
/*    */     //   415: aconst_null
/*    */     //   416: astore #6
/*    */     //   418: aload #4
/*    */     //   420: instanceof yesman/epicfight/world/capabilities/entitypatch/player/ServerPlayerPatch
/*    */     //   423: ifeq -> 443
/*    */     //   426: aload #4
/*    */     //   428: checkcast yesman/epicfight/world/capabilities/entitypatch/player/ServerPlayerPatch
/*    */     //   431: astore #7
/*    */     //   433: aload #7
/*    */     //   435: getstatic com/pla/annoyingvillagers/gameasset/AVSkills.WOOPIE_THE_SWORD : Lyesman/epicfight/skill/Skill;
/*    */     //   438: invokevirtual getSkill : (Lyesman/epicfight/skill/Skill;)Lyesman/epicfight/skill/SkillContainer;
/*    */     //   441: astore #6
/*    */     //   443: aload_0
/*    */     //   444: invokevirtual getAffectedEntities : ()Ljava/util/List;
/*    */     //   447: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   452: astore #7
/*    */     //   454: aload #7
/*    */     //   456: invokeinterface hasNext : ()Z
/*    */     //   461: ifeq -> 733
/*    */     //   464: aload #7
/*    */     //   466: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   471: checkcast net/minecraft/world/entity/Entity
/*    */     //   474: astore #8
/*    */     //   476: aload #8
/*    */     //   478: invokevirtual m_6084_ : ()Z
/*    */     //   481: ifeq -> 730
/*    */     //   484: aload #8
/*    */     //   486: aload_0
/*    */     //   487: invokevirtual getExplosion : ()Lnet/minecraft/world/level/Explosion;
/*    */     //   490: invokevirtual m_252906_ : ()Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   493: if_acmpeq -> 730
/*    */     //   496: aload #8
/*    */     //   498: instanceof net/minecraft/world/entity/LivingEntity
/*    */     //   501: ifeq -> 730
/*    */     //   504: aload #8
/*    */     //   506: checkcast net/minecraft/world/entity/LivingEntity
/*    */     //   509: astore #9
/*    */     //   511: aload #8
/*    */     //   513: instanceof reascer/wom/world/entity/mob/EnderHand
/*    */     //   516: ifne -> 730
/*    */     //   519: aload #8
/*    */     //   521: instanceof net/minecraft/world/entity/player/Player
/*    */     //   524: ifeq -> 542
/*    */     //   527: aload #8
/*    */     //   529: checkcast net/minecraft/world/entity/player/Player
/*    */     //   532: astore #10
/*    */     //   534: aload #10
/*    */     //   536: invokevirtual m_7500_ : ()Z
/*    */     //   539: ifne -> 730
/*    */     //   542: aload #8
/*    */     //   544: ldc yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*    */     //   546: invokestatic getEntityPatch : (Lnet/minecraft/world/entity/Entity;Ljava/lang/Class;)Lyesman/epicfight/world/capabilities/entitypatch/EntityPatch;
/*    */     //   549: checkcast yesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch
/*    */     //   552: astore #11
/*    */     //   554: aload #11
/*    */     //   556: ifnull -> 568
/*    */     //   559: aload #11
/*    */     //   561: getstatic com/pla/annoyingvillagers/gameasset/AVAnimations.LONGEST_HIT : Lyesman/epicfight/api/animation/AnimationManager$AnimationAccessor;
/*    */     //   564: fconst_0
/*    */     //   565: invokevirtual playAnimationSynchronized : (Lyesman/epicfight/api/asset/AssetAccessor;F)V
/*    */     //   568: aload #8
/*    */     //   570: invokevirtual m_6084_ : ()Z
/*    */     //   573: ifne -> 579
/*    */     //   576: goto -> 454
/*    */     //   579: aload_2
/*    */     //   580: getfield f_82479_ : D
/*    */     //   583: aload #8
/*    */     //   585: invokevirtual m_20185_ : ()D
/*    */     //   588: dsub
/*    */     //   589: dstore #12
/*    */     //   591: aload_2
/*    */     //   592: getfield f_82481_ : D
/*    */     //   595: aload #8
/*    */     //   597: invokevirtual m_20189_ : ()D
/*    */     //   600: dsub
/*    */     //   601: dstore #14
/*    */     //   603: aload #8
/*    */     //   605: invokevirtual m_20182_ : ()Lnet/minecraft/world/phys/Vec3;
/*    */     //   608: aload_2
/*    */     //   609: invokevirtual m_82554_ : (Lnet/minecraft/world/phys/Vec3;)D
/*    */     //   612: dstore #16
/*    */     //   614: dconst_1
/*    */     //   615: dload #16
/*    */     //   617: ldc2_w 8.0
/*    */     //   620: ddiv
/*    */     //   621: dsub
/*    */     //   622: dconst_0
/*    */     //   623: dconst_1
/*    */     //   624: invokestatic m_14008_ : (DDD)D
/*    */     //   627: dstore #18
/*    */     //   629: ldc2_w 6.0
/*    */     //   632: dload #18
/*    */     //   634: dmul
/*    */     //   635: dstore #20
/*    */     //   637: ldc2_w 2.6
/*    */     //   640: dload #18
/*    */     //   642: dmul
/*    */     //   643: dstore #22
/*    */     //   645: aload #9
/*    */     //   647: dload #20
/*    */     //   649: dload #12
/*    */     //   651: dload #14
/*    */     //   653: invokevirtual m_147240_ : (DDD)V
/*    */     //   656: aload #9
/*    */     //   658: dconst_0
/*    */     //   659: dload #22
/*    */     //   661: dconst_0
/*    */     //   662: invokevirtual m_5997_ : (DDD)V
/*    */     //   665: aload #9
/*    */     //   667: iconst_1
/*    */     //   668: putfield f_19864_ : Z
/*    */     //   671: aload #6
/*    */     //   673: ifnull -> 730
/*    */     //   676: aload #6
/*    */     //   678: invokevirtual getStack : ()I
/*    */     //   681: iconst_1
/*    */     //   682: if_icmpge -> 730
/*    */     //   685: aload #6
/*    */     //   687: invokevirtual getSkill : ()Lyesman/epicfight/skill/Skill;
/*    */     //   690: checkcast com/pla/annoyingvillagers/skill/WoopieTheSwordSkill
/*    */     //   693: astore #24
/*    */     //   695: aload #6
/*    */     //   697: invokevirtual getResource : ()F
/*    */     //   700: fstore #25
/*    */     //   702: aload #6
/*    */     //   704: invokevirtual getNeededResource : ()F
/*    */     //   707: fstore #26
/*    */     //   709: ldc 50.0
/*    */     //   711: fload #26
/*    */     //   713: invokestatic min : (FF)F
/*    */     //   716: fstore #27
/*    */     //   718: aload #24
/*    */     //   720: aload #6
/*    */     //   722: fload #25
/*    */     //   724: fload #27
/*    */     //   726: fadd
/*    */     //   727: invokevirtual setConsumptionSynchronize : (Lyesman/epicfight/skill/SkillContainer;F)V
/*    */     //   730: goto -> 454
/*    */     //   733: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #39	-> 0
/*    */     //   #40	-> 13
/*    */     //   #43	-> 28
/*    */     //   #44	-> 36
/*    */     //   #46	-> 44
/*    */     //   #47	-> 75
/*    */     //   #48	-> 86
/*    */     //   #49	-> 92
/*    */     //   #50	-> 112
/*    */     //   #52	-> 141
/*    */     //   #53	-> 144
/*    */     //   #54	-> 159
/*    */     //   #56	-> 169
/*    */     //   #57	-> 202
/*    */     //   #58	-> 230
/*    */     //   #59	-> 253
/*    */     //   #60	-> 268
/*    */     //   #61	-> 280
/*    */     //   #69	-> 296
/*    */     //   #70	-> 310
/*    */     //   #71	-> 320
/*    */     //   #72	-> 327
/*    */     //   #73	-> 334
/*    */     //   #74	-> 343
/*    */     //   #77	-> 355
/*    */     //   #78	-> 375
/*    */     //   #80	-> 391
/*    */     //   #83	-> 394
/*    */     //   #84	-> 415
/*    */     //   #85	-> 418
/*    */     //   #86	-> 433
/*    */     //   #88	-> 443
/*    */     //   #89	-> 476
/*    */     //   #90	-> 504
/*    */     //   #91	-> 527
/*    */     //   #92	-> 542
/*    */     //   #93	-> 554
/*    */     //   #94	-> 559
/*    */     //   #96	-> 568
/*    */     //   #97	-> 579
/*    */     //   #98	-> 591
/*    */     //   #99	-> 603
/*    */     //   #100	-> 614
/*    */     //   #102	-> 629
/*    */     //   #103	-> 637
/*    */     //   #105	-> 645
/*    */     //   #106	-> 656
/*    */     //   #107	-> 665
/*    */     //   #109	-> 671
/*    */     //   #110	-> 685
/*    */     //   #111	-> 695
/*    */     //   #112	-> 702
/*    */     //   #113	-> 709
/*    */     //   #114	-> 718
/*    */     //   #117	-> 730
/*    */     //   #120	-> 733
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   159	10	7	serverPlayerPatch	Lyesman/epicfight/world/capabilities/entitypatch/player/ServerPlayerPatch;
/*    */     //   260	8	10	player	Lnet/minecraft/world/entity/player/Player;
/*    */     //   320	35	12	enderGlaiveSkill	Lcom/pla/annoyingvillagers/skill/EnderGlaiveSkill;
/*    */     //   327	28	13	currentResource	F
/*    */     //   334	21	14	neededResource	F
/*    */     //   343	12	15	addResource	F
/*    */     //   280	111	11	explodedPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;
/*    */     //   237	154	9	livingExploded	Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   202	189	8	entity	Lnet/minecraft/world/entity/Entity;
/*    */     //   144	250	6	skillContainer	Lyesman/epicfight/skill/SkillContainer;
/*    */     //   433	10	7	serverPlayerPatch	Lyesman/epicfight/world/capabilities/entitypatch/player/ServerPlayerPatch;
/*    */     //   534	8	10	player	Lnet/minecraft/world/entity/player/Player;
/*    */     //   695	35	24	woopieTheSwordSkill	Lcom/pla/annoyingvillagers/skill/WoopieTheSwordSkill;
/*    */     //   702	28	25	currentResource	F
/*    */     //   709	21	26	neededResource	F
/*    */     //   718	12	27	addResource	F
/*    */     //   554	176	11	explodedPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;
/*    */     //   591	139	12	dx	D
/*    */     //   603	127	14	dz	D
/*    */     //   614	116	16	dist	D
/*    */     //   629	101	18	falloff	D
/*    */     //   637	93	20	horizontal	D
/*    */     //   645	85	22	up	D
/*    */     //   511	219	9	livingExploded	Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   476	254	8	entity	Lnet/minecraft/world/entity/Entity;
/*    */     //   418	315	6	skillContainer	Lyesman/epicfight/skill/SkillContainer;
/*    */     //   86	647	4	livingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch;
/*    */     //   112	621	5	dynamicAnimation	Lyesman/epicfight/api/asset/AssetAccessor;
/*    */     //   75	658	3	serverLevel	Lnet/minecraft/server/level/ServerLevel;
/*    */     //   0	734	0	detonate	Lnet/minecraftforge/event/level/ExplosionEvent$Detonate;
/*    */     //   36	698	1	livingEntity	Lnet/minecraft/world/entity/LivingEntity;
/*    */     //   44	690	2	center	Lnet/minecraft/world/phys/Vec3;
/*    */     // Local variable type table:
/*    */     //   start	length	slot	name	signature
/*    */     //   280	111	11	explodedPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch<*>;
/*    */     //   554	176	11	explodedPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch<*>;
/*    */     //   86	647	4	livingEntityPatch	Lyesman/epicfight/world/capabilities/entitypatch/LivingEntityPatch<*>;
/*    */     //   112	621	5	dynamicAnimation	Lyesman/epicfight/api/asset/AssetAccessor<+Lyesman/epicfight/api/animation/types/StaticAnimation;>;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\ExplosionDamageEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */