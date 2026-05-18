/*     */ package com.pla.annoyingvillagers.item;
/*     */ import com.pla.annoyingvillagers.entity.BlockProjectileEntity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModBlocks;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Random;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.TooltipFlag;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ 
/*     */ public class HerobrineEnderEyeItem extends Item {
/*     */   public HerobrineEnderEyeItem() {
/*  24 */     super((new Item.Properties()).m_41487_(1).m_41503_(300));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean m_5812_(ItemStack pStack) {
/*  29 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltipflag) {
/*  34 */     super.m_7373_(itemstack, level, list, tooltipflag);
/*  35 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.herobrine_ender_eye"));
/*     */   }
/*     */   
/*     */   public static void spawnAndShootDarkObPillars(ServerLevel level, final LivingEntity shooter, int delayTicks) {
/*  39 */     BlockState block = ((Block)Objects.<Block>requireNonNull((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_SHORT_PILLAR.get())).m_49966_();
/*     */     
/*  41 */     double lateral = 2.0D;
/*  42 */     double sideY = 0.0D;
/*  43 */     double upY = 2.0D;
/*     */     
/*  45 */     Vec3 eye = shooter.m_20299_(1.0F);
/*  46 */     Vec3 look = shooter.m_20252_(1.0F);
/*  47 */     Vec3 horiz = new Vec3(look.f_82479_, 0.0D, look.f_82481_);
/*     */     
/*  49 */     if (horiz.m_82556_() < 1.0E-6D) {
/*  50 */       float yaw = shooter.m_146908_() * 0.017453292F;
/*  51 */       horiz = new Vec3(-Mth.m_14031_(yaw), 0.0D, Mth.m_14089_(yaw));
/*     */     } 
/*  53 */     Vec3 upAxis = new Vec3(0.0D, 1.0D, 0.0D);
/*  54 */     Vec3 rightAxis = horiz.m_82537_(upAxis).m_82541_();
/*  55 */     Vec3 leftAxis = rightAxis.m_82490_(-1.0D);
/*     */     
/*  57 */     Vec3 upPos = eye.m_82520_(0.0D, 2.0D, 0.0D);
/*  58 */     Vec3 leftPos = eye.m_82549_(leftAxis.m_82490_(2.0D)).m_82520_(0.0D, 0.0D, 0.0D);
/*  59 */     Vec3 rightPos = eye.m_82549_(rightAxis.m_82490_(2.0D)).m_82520_(0.0D, 0.0D, 0.0D);
/*     */     
/*  61 */     final BlockProjectileEntity up = makeFloating((Level)level, shooter, block, upPos.f_82479_, upPos.f_82480_, upPos.f_82481_);
/*  62 */     final BlockProjectileEntity left = makeFloating((Level)level, shooter, block, leftPos.f_82479_, leftPos.f_82480_, leftPos.f_82481_);
/*  63 */     final BlockProjectileEntity right = makeFloating((Level)level, shooter, block, rightPos.f_82479_, rightPos.f_82480_, rightPos.f_82481_);
/*     */     
/*  65 */     new DelayedTask(delayTicks) {
/*     */         public void run() {
/*  67 */           if (!shooter.m_6084_()) {
/*  68 */             if (up != null && up.m_6084_()) up.m_146870_(); 
/*  69 */             if (left != null && left.m_6084_()) left.m_146870_(); 
/*  70 */             if (right != null && right.m_6084_()) right.m_146870_();
/*     */             
/*     */             return;
/*     */           } 
/*  74 */           Vec3 to = HerobrineEnderEyeItem.lookTarget(shooter, 16.0D);
/*  75 */           HerobrineEnderEyeItem.shootOne(up, to, 2.0D);
/*  76 */           HerobrineEnderEyeItem.shootOne(left, to, 2.0D);
/*  77 */           HerobrineEnderEyeItem.shootOne(right, to, 2.0D);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public static void startShadowObsidianMachineGun(ServerLevel level, Player player) {
/*  83 */     int[] remaining = { 20 };
/*  84 */     fireChainTick(level, player, remaining);
/*     */   }
/*     */   
/*     */   private static void fireChainTick(final ServerLevel level, final Player player, final int[] remaining) {
/*  88 */     if (remaining[0] <= 0 || !player.m_6084_())
/*     */       return; 
/*  90 */     BlockState block = ((Block)Objects.<Block>requireNonNull((Block)AnnoyingVillagersModBlocks.SHADOW_OBSIDIAN_BLOCK.get())).m_49966_();
/*  91 */     player.m_20256_(Vec3.f_82478_);
/*  92 */     shootChain((LivingEntity)player, block, 2.5F, 5);
/*     */     
/*  94 */     remaining[0] = remaining[0] - 1;
/*  95 */     new DelayedTask(1) { public void run() { HerobrineEnderEyeItem.fireChainTick(level, player, remaining); }
/*     */          }
/*     */       ;
/*     */   } private static BlockProjectileEntity makeFloating(Level level, LivingEntity owner, BlockState block, double x, double y, double z) {
/*  99 */     BlockProjectileEntity blockProjectileEntity = new BlockProjectileEntity(level, owner, block);
/* 100 */     blockProjectileEntity.m_20242_(true);
/* 101 */     blockProjectileEntity.setNotReadyForShoot(true);
/* 102 */     blockProjectileEntity.m_7678_(x, y, z, 0.0F, 0.0F);
/* 103 */     if (owner instanceof Player) { Player player = (Player)owner; blockProjectileEntity.setOwnerUUID(player.m_20148_()); }
/* 104 */      level.m_7967_((Entity)blockProjectileEntity);
/* 105 */     return blockProjectileEntity;
/*     */   }
/*     */   
/*     */   private static void shootOne(BlockProjectileEntity blockProjectileEntity, Vec3 to, double speed) {
/* 109 */     if (blockProjectileEntity == null || !blockProjectileEntity.m_6084_())
/* 110 */       return;  Vec3 dir = to.m_82546_(blockProjectileEntity.m_20182_());
/* 111 */     if (dir.m_82556_() < 1.0E-6D) dir = blockProjectileEntity.m_20154_(); 
/* 112 */     blockProjectileEntity.m_20242_(false);
/* 113 */     blockProjectileEntity.m_20256_(dir.m_82541_().m_82490_(speed));
/* 114 */     blockProjectileEntity.setNotReadyForShoot(false);
/*     */   }
/*     */   
/*     */   private static Vec3 lookTarget(LivingEntity shooter, double distance) {
/* 118 */     return shooter.m_146892_().m_82549_(shooter.m_20154_().m_82541_().m_82490_(distance));
/*     */   }
/*     */   
/*     */   private static void shootChain(LivingEntity shooter, BlockState block, float velocity, int length) {
/* 122 */     Level level = shooter.m_9236_();
/* 123 */     if (level.f_46443_)
/*     */       return; 
/* 125 */     double eyeY = shooter.m_20188_();
/* 126 */     Vec3 look = shooter.m_20154_().m_82541_();
/* 127 */     Random rand = new Random();
/*     */     
/* 129 */     for (int i = 0; i < length; i++) {
/* 130 */       BlockProjectileEntity proj = new BlockProjectileEntity(level, shooter, block);
/*     */       
/* 132 */       Vec3 forward = look.m_82490_(i * 1.0D);
/*     */       
/* 134 */       double sideX = (rand.nextDouble() - 0.5D) * 2.0D;
/* 135 */       double sideY = (rand.nextDouble() - 0.5D) * 2.0D;
/* 136 */       double sideZ = (rand.nextDouble() - 0.5D) * 2.0D;
/*     */       
/* 138 */       proj.m_6034_(shooter
/* 139 */           .m_20185_() + forward.f_82479_ + sideX, eyeY + forward.f_82480_ + sideY, shooter
/*     */           
/* 141 */           .m_20189_() + forward.f_82481_ + sideZ);
/*     */       
/* 143 */       if (shooter instanceof Player) { Player player = (Player)shooter; proj.setOwnerUUID(player.m_20148_()); }
/* 144 */        proj.m_20256_(look.m_82490_(velocity));
/*     */       
/* 146 */       level.m_7967_((Entity)proj);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\HerobrineEnderEyeItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */