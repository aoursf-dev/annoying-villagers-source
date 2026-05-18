/*     */ package com.pla.annoyingvillagers.block;
/*     */ import com.pla.annoyingvillagers.blockentity.CryingObsidianBlockEntity;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineObsidianBlock;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.task.DelayedTask;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundEvents;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.TooltipFlag;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.block.EntityBlock;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import net.minecraftforge.common.util.ForgeSoundType;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class CryingObsidianBlock extends HerobrineObsidianBlock implements EntityBlock {
/*     */   public CryingObsidianBlock() {
/*  39 */     super(BlockBehaviour.Properties.m_284310_()
/*  40 */         .m_60918_((SoundType)new ForgeSoundType(1.0F, 1.0F, (Supplier)AnnoyingVillagersModSounds.LOST, () -> SoundEvents.f_12450_, () -> SoundEvents.f_12447_, () -> SoundEvents.f_12446_, (Supplier)AnnoyingVillagersModSounds.SILENT))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  47 */         .m_60913_(60.0F, 40.0F)
/*  48 */         .m_60953_(blockstate -> 4)
/*  49 */         .m_60955_()
/*  50 */         .m_60982_((blockstate, blockgetter, blockpos) -> true)
/*  51 */         .m_60991_((blockstate, blockgetter, blockpos) -> true)
/*  52 */         .m_60924_((blockstate, blockgetter, blockpos) -> false));
/*     */   }
/*     */   
/*     */   public void m_5871_(@NotNull ItemStack itemstack, BlockGetter blockgetter, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/*  56 */     super.m_5871_(itemstack, blockgetter, list, tooltipflag);
/*  57 */     list.add(Component.m_237113_("Obsidian Fired by Elite Herobrine"));
/*     */   }
/*     */   @NotNull
/*     */   public VoxelShape m_5940_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos, @NotNull CollisionContext collisioncontext) {
/*  61 */     return m_49796_(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 17.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customTickSound(ServerLevel serverLevel, BlockPos blockPos) {
/*  66 */     super.customTickSound(serverLevel, blockPos);
/*  67 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  69 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), SoundEvents.f_12442_, SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void customPlaceSound(final ServerLevel serverLevel, final BlockPos blockPos) {
/*  78 */     super.customPlaceSound(serverLevel, blockPos);
/*  79 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  81 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), SoundEvents.f_12447_, SoundSource.BLOCKS, (new Random())
/*     */ 
/*     */         
/*  84 */         .nextFloat(0.0F, 0.7F), 1.0F);
/*     */     
/*  86 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  88 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OB_PLACE
/*  89 */         .get(), SoundSource.BLOCKS, (new Random())
/*     */         
/*  91 */         .nextFloat(0.2F, 0.6F), 1.0F);
/*     */     
/*  93 */     new DelayedTask((new Random()).nextInt(5, 15))
/*     */       {
/*     */         public void run() {
/*  96 */           serverLevel.m_6263_(null, blockPos
/*     */               
/*  98 */               .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.POP
/*  99 */               .get(), SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean conditionEveryTickEntityInside(Entity entity) {
/* 109 */     return (entity.f_19797_ % 5 == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customHurtLogic(final Entity entity, Entity owner, ServerLevel serverLevel, BlockPos blockPos) {
/* 114 */     super.customHurtLogic(entity, owner, serverLevel, blockPos);
/* 115 */     ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, entity, entity);
/* 116 */     serverLevel.m_6263_(null, blockPos
/*     */         
/* 118 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OBSIDIAN_HIT
/* 119 */         .get(), SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */     
/* 123 */     if (owner != null) {
/* 124 */       if (owner instanceof Player) { Player player = (Player)owner;
/* 125 */         entity.m_6469_(entity.m_9236_().m_269111_().m_269075_(player), 1.0F); }
/*     */       else
/* 127 */       { entity.m_6469_(entity.m_9236_().m_269111_().m_269333_((LivingEntity)owner), 1.0F); }
/*     */     
/*     */     } else {
/* 130 */       entity.m_6469_(entity.m_9236_().m_269111_().m_269264_(), 1.0F);
/*     */     } 
/* 132 */     entity.m_20256_(new Vec3((entity.m_20154_()).f_82479_ * -2.0D, 0.4D, (entity.m_20154_()).f_82481_ * -2.0D));
/* 133 */     if (Math.random() <= 0.5D) {
/* 134 */       new DelayedTask(1)
/*     */         {
/*     */           public void run() {
/* 137 */             if (entity.m_9236_() instanceof ServerLevel && entity instanceof Mob) { Mob mob = (Mob)entity;
/* 138 */               LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 139 */               if (livingEntityPatch != null && !livingEntityPatch.isStunned()) {
/* 140 */                 livingEntityPatch.applyStun(StunType.LONG, 10.0F);
/*     */               } }
/*     */           
/*     */           }
/*     */         };
/*     */       
/* 146 */       if (Math.random() <= 0.3D) {
/* 147 */         new DelayedTask(1)
/*     */           {
/*     */             public void run() {
/* 150 */               if (entity.m_9236_() instanceof ServerLevel && entity instanceof Mob) { Mob mob = (Mob)entity;
/* 151 */                 LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 152 */                 if (livingEntityPatch != null && !livingEntityPatch.isStunned()) {
/* 153 */                   livingEntityPatch.applyStun(StunType.KNOCKDOWN, 10.0F);
/*     */                 } }
/*     */             
/*     */             }
/*     */           };
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public BlockEntity m_142194_(@NotNull BlockPos pPos, @NotNull BlockState pState) {
/* 164 */     return (BlockEntity)new CryingObsidianBlockEntity(pPos, pState);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\block\CryingObsidianBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */