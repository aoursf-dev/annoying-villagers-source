/*     */ package com.pla.annoyingvillagers.block;
/*     */ import com.pla.annoyingvillagers.blockentity.ObsidianBlockEntity;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineObsidianBlock;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.skill.ObsidianWeaponSkill;
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
/*     */ import net.minecraft.world.level.block.SoundType;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import net.minecraftforge.common.util.ForgeSoundType;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ import yesman.epicfight.world.damagesource.StunType;
/*     */ 
/*     */ public class ObsidianBlock extends HerobrineObsidianBlock implements EntityBlock {
/*     */   public ObsidianBlock() {
/*  46 */     super(BlockBehaviour.Properties.m_284310_()
/*  47 */         .m_60918_((SoundType)new ForgeSoundType(1.0F, 1.0F, (Supplier)AnnoyingVillagersModSounds.LOST, () -> SoundEvents.f_12450_, () -> SoundEvents.f_12447_, () -> SoundEvents.f_12446_, (Supplier)AnnoyingVillagersModSounds.SILENT))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  54 */         .m_60913_(60.0F, 40.0F)
/*  55 */         .m_60953_(blockstate -> 4)
/*  56 */         .m_60955_()
/*  57 */         .m_60982_((blockstate, blockgetter, blockpos) -> true)
/*  58 */         .m_60991_((blockstate, blockgetter, blockpos) -> true)
/*  59 */         .m_60924_((blockstate, blockgetter, blockpos) -> false));
/*     */   }
/*     */   
/*     */   public void m_5871_(@NotNull ItemStack itemstack, BlockGetter blockgetter, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/*  63 */     super.m_5871_(itemstack, blockgetter, list, tooltipflag);
/*  64 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.obsidian"));
/*     */   }
/*     */   @NotNull
/*     */   public VoxelShape m_5940_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos, @NotNull CollisionContext collisioncontext) {
/*  68 */     return m_49796_(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 17.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customTickSound(ServerLevel serverLevel, BlockPos blockPos) {
/*  73 */     super.customTickSound(serverLevel, blockPos);
/*  74 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  76 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), SoundEvents.f_12442_, SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void customPlaceSound(final ServerLevel serverLevel, final BlockPos blockPos) {
/*  85 */     super.customPlaceSound(serverLevel, blockPos);
/*  86 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  88 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), SoundEvents.f_12447_, SoundSource.BLOCKS, (new Random())
/*     */ 
/*     */         
/*  91 */         .nextFloat(0.0F, 0.7F), 1.0F);
/*     */     
/*  93 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  95 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OB_PLACE
/*  96 */         .get(), SoundSource.BLOCKS, (new Random())
/*     */         
/*  98 */         .nextFloat(0.2F, 0.6F), 1.0F);
/*     */     
/* 100 */     new DelayedTask((new Random()).nextInt(5, 15))
/*     */       {
/*     */         public void run() {
/* 103 */           serverLevel.m_6263_(null, blockPos
/*     */               
/* 105 */               .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.POP
/* 106 */               .get(), SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void increaseSkillPoint(Entity entity, float value) {
/*     */     Player pEntity;
/*     */     ServerPlayerPatch serverPlayerPatch;
/* 115 */     if (entity instanceof Player) { pEntity = (Player)entity; }
/*     */     else { return; }
/* 117 */      PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)pEntity, PlayerPatch.class);
/* 118 */     if (playerPatch instanceof ServerPlayerPatch) { serverPlayerPatch = (ServerPlayerPatch)playerPatch; }
/*     */     else { return; }
/* 120 */      SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.OBSIDIAN_WEAPON);
/* 121 */     if (skillContainer == null)
/*     */       return; 
/* 123 */     ObsidianWeaponSkill skill = (ObsidianWeaponSkill)skillContainer.getSkill();
/*     */     
/* 125 */     float currentResource = skillContainer.getResource();
/* 126 */     float neededResource = skillContainer.getNeededResource();
/* 127 */     float addResource = Math.min(value, neededResource);
/*     */     
/* 129 */     skill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean conditionEveryTickEntityInside(Entity entity) {
/* 134 */     return (entity.f_19797_ % 5 == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customHurtLogic(final Entity entity, Entity owner, ServerLevel serverLevel, BlockPos blockPos) {
/* 139 */     super.customHurtLogic(entity, owner, serverLevel, blockPos);
/* 140 */     ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, entity, entity);
/* 141 */     serverLevel.m_6263_(null, blockPos
/*     */         
/* 143 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OBSIDIAN_HIT
/* 144 */         .get(), SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */     
/* 148 */     if (owner != null) {
/* 149 */       if (owner instanceof Player) { Player player = (Player)owner;
/* 150 */         entity.m_6469_(entity.m_9236_().m_269111_().m_269075_(player), 1.0F);
/* 151 */         increaseSkillPoint((Entity)player, 1.0F); }
/*     */       else
/* 153 */       { entity.m_6469_(entity.m_9236_().m_269111_().m_269333_((LivingEntity)owner), 1.0F); }
/*     */     
/*     */     } else {
/* 156 */       entity.m_6469_(entity.m_9236_().m_269111_().m_269264_(), 1.0F);
/*     */     } 
/* 158 */     entity.m_20256_(new Vec3((entity.m_20154_()).f_82479_ * -2.0D, 0.4D, (entity.m_20154_()).f_82481_ * -2.0D));
/* 159 */     if (Math.random() <= 0.5D) {
/* 160 */       new DelayedTask(1)
/*     */         {
/*     */           public void run() {
/* 163 */             if (entity.m_9236_() instanceof ServerLevel && entity instanceof Mob) { Mob mob = (Mob)entity;
/* 164 */               LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 165 */               if (livingEntityPatch != null && !livingEntityPatch.isStunned()) {
/* 166 */                 livingEntityPatch.applyStun(StunType.LONG, 10.0F);
/*     */               } }
/*     */           
/*     */           }
/*     */         };
/*     */       
/* 172 */       if (Math.random() <= 0.3D) {
/* 173 */         new DelayedTask(1)
/*     */           {
/*     */             public void run() {
/* 176 */               if (entity.m_9236_() instanceof ServerLevel && entity instanceof Mob) { Mob mob = (Mob)entity;
/* 177 */                 LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 178 */                 if (livingEntityPatch != null && !livingEntityPatch.isStunned()) {
/* 179 */                   livingEntityPatch.applyStun(StunType.KNOCKDOWN, 10.0F);
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
/* 190 */     return (BlockEntity)new ObsidianBlockEntity(pPos, pState);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\block\ObsidianBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */