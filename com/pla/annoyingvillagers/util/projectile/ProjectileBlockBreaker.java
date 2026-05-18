/*     */ package com.pla.annoyingvillagers.util.projectile;
/*     */ 
/*     */ import com.pla.annoyingvillagers.clazz.ProjectileBreakableBlocks;
/*     */ import com.pla.annoyingvillagers.config.AnnoyingVillagersConfig;
/*     */ import java.util.function.BiFunction;
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.Position;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.ClipContext;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.BlockHitResult;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.level.BlockEvent;
/*     */ import net.minecraftforge.eventbus.api.Event;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ProjectileBlockBreaker
/*     */ {
/*     */   private static final float FULL_ARROW_SPEED = 3.0F;
/*     */   private static final float FULL_TRIDENT_SPEED = 2.5F;
/*     */   
/*     */   public static float computeInitialPower(AbstractArrow proj) {
/*  34 */     float speed = (float)proj.m_20184_().m_82553_();
/*  35 */     float full = (proj instanceof net.minecraft.world.entity.projectile.ThrownTrident) ? 2.5F : 3.0F;
/*  36 */     return Mth.m_14036_(speed / full, 0.0F, 1.0F);
/*     */   }
/*     */   public static BlockHitResult clip(Level level, ClipContext ctx, AbstractArrow proj) {
/*     */     BreakPowerHolder holder;
/*  40 */     if (!((Boolean)AnnoyingVillagersConfig.ARROW_CAN_BREAK_BLOCK.get()).booleanValue()) {
/*  41 */       return level.m_45547_(ctx);
/*     */     }
/*     */     
/*  44 */     if (!(proj instanceof net.minecraft.world.entity.projectile.Arrow) && !(proj instanceof net.minecraft.world.entity.projectile.ThrownTrident)) {
/*  45 */       return level.m_45547_(ctx);
/*     */     }
/*  47 */     if (proj instanceof BreakPowerHolder) { holder = (BreakPowerHolder)proj; }
/*  48 */     else { return level.m_45547_(ctx); }
/*     */     
/*  50 */     if (level.f_46443_) {
/*  51 */       return level.m_45547_(ctx);
/*     */     }
/*     */     
/*  54 */     float power = holder.getBreakPower();
/*  55 */     if (power <= 0.0F) {
/*  56 */       return level.m_45547_(ctx);
/*     */     }
/*     */     
/*  59 */     Vec3 from = ctx.m_45702_();
/*  60 */     Vec3 to = ctx.m_45693_();
/*  61 */     CollisionContext collision = CollisionContext.m_82750_((Entity)proj);
/*     */     
/*  63 */     BiFunction<ClipContext, BlockPos, BlockHitResult> hitTest = (c, pos) -> {
/*     */         BlockState state = level.m_8055_(pos);
/*     */         
/*     */         ProjectileBreakableBlocks rule = ProjectileBreakableBlocks.find(state);
/*     */         
/*     */         VoxelShape shape = state.m_60742_((BlockGetter)level, pos, collision);
/*     */         
/*     */         if (rule != null && shape.m_83281_()) {
/*     */           shape = state.m_60651_((BlockGetter)level, pos, collision);
/*     */         }
/*     */         
/*     */         BlockHitResult bhr = level.m_45558_(from, to, pos, shape, state);
/*     */         
/*     */         if (bhr == null) {
/*     */           return null;
/*     */         }
/*     */         
/*     */         if (state.m_60800_((BlockGetter)level, pos) < 0.0F) {
/*     */           holder.setBreakPower(0.0F);
/*     */           return bhr;
/*     */         } 
/*     */         if (rule == null) {
/*     */           holder.setBreakPower(0.0F);
/*     */           return bhr;
/*     */         } 
/*     */         float currentPower = holder.getBreakPower();
/*     */         if (currentPower < rule.requiredPower) {
/*     */           holder.setBreakPower(0.0F);
/*     */           return bhr;
/*     */         } 
/*     */         Entity breaker = proj.m_19749_();
/*     */         if (!canBreak(level, breaker, pos, state)) {
/*     */           holder.setBreakPower(0.0F);
/*     */           return bhr;
/*     */         } 
/*     */         level.m_46953_(pos, true, breaker);
/*     */         holder.setBreakPower(currentPower - rule.powerCost);
/*     */         return null;
/*     */       };
/* 102 */     Function<ClipContext, BlockHitResult> miss = c -> {
/*     */         Vec3 d = from.m_82546_(to);
/*     */         
/*     */         return BlockHitResult.m_82426_(to, Direction.m_122366_(d.f_82479_, d.f_82480_, d.f_82481_), BlockPos.m_274446_((Position)to));
/*     */       };
/* 107 */     return (BlockHitResult)BlockGetter.m_151361_(from, to, ctx, hitTest, miss);
/*     */   }
/*     */   
/*     */   private static boolean canBreak(Level level, Entity breaker, BlockPos pos, BlockState state) {
/* 111 */     if (breaker instanceof Player) { Player player = (Player)breaker; return 
/* 112 */         !MinecraftForge.EVENT_BUS.post((Event)new BlockEvent.BreakEvent(level, pos, state, player)); }
/*     */ 
/*     */     
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillager\\util\projectile\ProjectileBlockBreaker.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */