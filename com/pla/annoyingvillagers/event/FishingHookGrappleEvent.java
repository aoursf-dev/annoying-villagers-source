/*     */ package com.pla.annoyingvillagers.event;
/*     */ 
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.tags.FluidTags;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.InteractionResult;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.FishingHook;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraftforge.event.TickEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.minecraftforge.eventbus.api.Event;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ 
/*     */ @EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
/*     */ public class FishingHookGrappleEvent {
/*     */   private static final String KEY_LATCHED = "avLatched";
/*     */   private static final String KEY_AX = "avAX";
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
/*  29 */     if (event.phase != TickEvent.Phase.END)
/*  30 */       return;  Player player = event.player;
/*  31 */     if (player.m_9236_().m_5776_())
/*     */       return; 
/*  33 */     FishingHook hook = player.f_36083_;
/*  34 */     if (hook == null || !hook.m_6084_())
/*     */       return; 
/*  36 */     CompoundTag tag = hook.getPersistentData();
/*  37 */     if (tag.m_128471_("avLatched"))
/*     */       return; 
/*  39 */     boolean inWater = hook.m_9236_().m_6425_(hook.m_20183_()).m_205070_(FluidTags.f_13131_);
/*  40 */     if (inWater)
/*     */       return; 
/*  42 */     boolean nearlyStopped = (hook.m_20184_().m_82556_() < 0.001D);
/*  43 */     if (hook.m_20096_() || nearlyStopped) {
/*  44 */       Vec3 anchor = hook.m_20182_();
/*  45 */       tag.m_128379_("avLatched", true);
/*  46 */       tag.m_128347_("avAX", anchor.f_82479_);
/*  47 */       tag.m_128347_("avAY", anchor.f_82480_);
/*  48 */       tag.m_128347_("avAZ", anchor.f_82481_);
/*     */     } 
/*     */   }
/*     */   private static final String KEY_AY = "avAY"; private static final String KEY_AZ = "avAZ";
/*     */   private static boolean tryPlunge(Player player) {
/*  53 */     FishingHook hook = player.f_36083_;
/*  54 */     if (hook == null || !hook.m_6084_()) return false;
/*     */     
/*  56 */     CompoundTag tag = hook.getPersistentData();
/*  57 */     if (!tag.m_128471_("avLatched")) return false;
/*     */     
/*  59 */     if (player.m_36335_().m_41519_(Items.f_42523_)) return false;
/*     */     
/*  61 */     Vec3 anchor = new Vec3(tag.m_128459_("avAX"), tag.m_128459_("avAY"), tag.m_128459_("avAZ"));
/*  62 */     Vec3 eye = player.m_20182_().m_82520_(0.0D, player.m_20192_(), 0.0D);
/*  63 */     Vec3 dir = anchor.m_82546_(eye);
/*  64 */     if (dir.m_82556_() < 1.0E-6D) return false;
/*     */     
/*  66 */     dir = dir.m_82541_();
/*     */     
/*  68 */     boolean grounded = player.m_20096_();
/*     */     
/*  70 */     double maxY = grounded ? 1.0D : 0.7D;
/*  71 */     dir = new Vec3(dir.f_82479_, Math.max(-maxY, Math.min(maxY, dir.f_82480_)), dir.f_82481_);
/*  72 */     Vec3 vel = player.m_20184_();
/*  73 */     if (grounded) {
/*  74 */       vel = vel.m_82520_(0.0D, 0.42D, 0.0D);
/*     */     }
/*     */     
/*  77 */     if (!player.m_9236_().m_5776_()) {
/*  78 */       player.m_7292_(new MobEffectInstance(MobEffects.f_19620_, 5, 1, false, false));
/*     */     }
/*  80 */     double power = grounded ? 4.1D : 3.1D;
/*  81 */     vel = vel.m_82549_(dir.m_82490_(power));
/*     */     
/*  83 */     player.m_20256_(vel);
/*  84 */     player.f_19864_ = true;
/*  85 */     player.f_19789_ = 0.0F;
/*  86 */     player.m_36335_().m_41524_(Items.f_42523_, 20);
/*  87 */     tag.m_128379_("avLatched", false);
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   private static ItemStack getRodInHand(Player p, InteractionHand preferred) {
/*  92 */     ItemStack s = p.m_21120_(preferred);
/*  93 */     if (s.m_150930_(Items.f_42523_)) return s; 
/*  94 */     return p.m_21205_().m_150930_(Items.f_42523_) ? p.m_21205_() : p.m_21206_();
/*     */   }
/*     */   
/*     */   private static void retrieveNow(Player player, InteractionHand hand) {
/*  98 */     FishingHook hook = player.f_36083_;
/*  99 */     if (hook == null || !hook.m_6084_())
/*     */       return; 
/* 101 */     ItemStack rod = getRodInHand(player, hand);
/* 102 */     if (!rod.m_150930_(Items.f_42523_))
/*     */       return; 
/* 104 */     int damage = hook.m_37156_(rod);
/* 105 */     if (damage > 0) {
/* 106 */       rod.m_41622_(damage, (LivingEntity)player, pl -> pl.m_21190_(hand));
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
/* 112 */     Player player = event.getEntity();
/* 113 */     if (player.m_9236_().m_5776_())
/* 114 */       return;  boolean holdingRod = (player.m_21205_().m_150930_(Items.f_42523_) || player.m_21206_().m_150930_(Items.f_42523_));
/* 115 */     if (!holdingRod || player.f_36083_ == null)
/* 116 */       return;  if (tryPlunge(player)) {
/* 117 */       retrieveNow(player, event.getHand());
/* 118 */       event.setCanceled(true);
/* 119 */       event.setCancellationResult(InteractionResult.SUCCESS);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
/* 125 */     Player player = event.getEntity();
/* 126 */     if (player.m_9236_().m_5776_())
/*     */       return; 
/* 128 */     boolean holdingRod = (player.m_21205_().m_150930_(Items.f_42523_) || player.m_21206_().m_150930_(Items.f_42523_));
/* 129 */     if (!holdingRod || player.f_36083_ == null)
/*     */       return; 
/* 131 */     if (tryPlunge(player)) {
/* 132 */       retrieveNow(player, event.getHand());
/* 133 */       event.setUseItem(Event.Result.DENY);
/* 134 */       event.setCancellationResult(InteractionResult.SUCCESS);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onRightClickEmpty(PlayerInteractEvent.RightClickEmpty event) {
/* 140 */     Player player = event.getEntity();
/* 141 */     if (player.m_9236_().m_5776_())
/*     */       return; 
/* 143 */     boolean holdingRod = (player.m_21205_().m_150930_(Items.f_42523_) || player.m_21206_().m_150930_(Items.f_42523_));
/* 144 */     if (!holdingRod || player.f_36083_ == null)
/*     */       return; 
/* 146 */     if (tryPlunge(player)) {
/* 147 */       retrieveNow(player, event.getHand());
/* 148 */       event.setCanceled(true);
/* 149 */       event.setCancellationResult(InteractionResult.SUCCESS);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\event\FishingHookGrappleEvent.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */