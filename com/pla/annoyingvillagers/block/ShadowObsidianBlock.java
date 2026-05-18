/*     */ package com.pla.annoyingvillagers.block;
/*     */ 
/*     */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianBlockEntity;
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
/*     */ public class ShadowObsidianBlock
/*     */   extends HerobrineObsidianBlock implements EntityBlock {
/*     */   public ShadowObsidianBlock() {
/*  48 */     super(BlockBehaviour.Properties.m_284310_()
/*  49 */         .m_60918_((SoundType)new ForgeSoundType(1.0F, 1.0F, (Supplier)AnnoyingVillagersModSounds.LOST, () -> SoundEvents.f_144112_, () -> SoundEvents.f_144111_, () -> SoundEvents.f_12446_, (Supplier)AnnoyingVillagersModSounds.SILENT))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  56 */         .m_60913_(30.0F, 40.0F)
/*  57 */         .m_60953_(blockstate -> 4)
/*  58 */         .m_60955_()
/*  59 */         .m_60982_((blockstate, blockgetter, blockpos) -> true)
/*  60 */         .m_60991_((blockstate, blockgetter, blockpos) -> true)
/*  61 */         .m_60924_((blockstate, blockgetter, blockpos) -> false));
/*     */   }
/*     */   
/*     */   public void m_5871_(@NotNull ItemStack itemstack, BlockGetter blockgetter, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/*  65 */     super.m_5871_(itemstack, blockgetter, list, tooltipflag);
/*  66 */     list.add(Component.m_237115_("tooltip.annoyingvillagers.shadow_obsidian"));
/*     */   }
/*     */   @NotNull
/*     */   public VoxelShape m_5940_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos, @NotNull CollisionContext collisioncontext) {
/*  70 */     return m_49796_(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 17.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customTickSound(ServerLevel serverLevel, BlockPos blockPos) {
/*  75 */     super.customTickSound(serverLevel, blockPos);
/*  76 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  78 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), SoundEvents.f_144108_, SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void customPlaceSound(final ServerLevel serverLevel, final BlockPos blockPos) {
/*  87 */     super.customPlaceSound(serverLevel, blockPos);
/*  88 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  90 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), SoundEvents.f_144111_, SoundSource.BLOCKS, (new Random())
/*     */ 
/*     */         
/*  93 */         .nextFloat(0.0F, 0.7F), 1.0F);
/*     */     
/*  95 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  97 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OB_PLACE
/*  98 */         .get(), SoundSource.BLOCKS, (new Random())
/*     */         
/* 100 */         .nextFloat(0.2F, 0.6F), 1.0F);
/*     */     
/* 102 */     new DelayedTask((new Random()).nextInt(5, 15))
/*     */       {
/*     */         public void run() {
/* 105 */           serverLevel.m_6263_(null, blockPos
/*     */               
/* 107 */               .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.POP
/* 108 */               .get(), SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void increaseSkillPoint(Entity entity, float value) {
/*     */     Player pEntity;
/*     */     ServerPlayerPatch serverPlayerPatch;
/* 117 */     if (entity instanceof Player) { pEntity = (Player)entity; }
/*     */     else { return; }
/* 119 */      PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)pEntity, PlayerPatch.class);
/* 120 */     if (playerPatch instanceof ServerPlayerPatch) { serverPlayerPatch = (ServerPlayerPatch)playerPatch; }
/*     */     else { return; }
/* 122 */      SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.OBSIDIAN_WEAPON);
/* 123 */     if (skillContainer == null)
/*     */       return; 
/* 125 */     ObsidianWeaponSkill skill = (ObsidianWeaponSkill)skillContainer.getSkill();
/*     */     
/* 127 */     float currentResource = skillContainer.getResource();
/* 128 */     float neededResource = skillContainer.getNeededResource();
/* 129 */     float addResource = Math.min(value, neededResource);
/*     */     
/* 131 */     skill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean conditionEveryTickEntityInside(Entity entity) {
/* 136 */     return (entity.f_19797_ % 5 == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customHurtLogic(final Entity entity, Entity owner, ServerLevel serverLevel, BlockPos blockPos) {
/* 141 */     super.customHurtLogic(entity, owner, serverLevel, blockPos);
/* 142 */     ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, entity, entity);
/* 143 */     serverLevel.m_6263_(null, blockPos
/*     */         
/* 145 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OBSIDIAN_HIT
/* 146 */         .get(), SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */     
/* 150 */     if (owner != null) {
/* 151 */       if (owner instanceof Player) { Player player = (Player)owner;
/* 152 */         entity.m_6469_(entity.m_9236_().m_269111_().m_269075_(player), 1.0F);
/* 153 */         increaseSkillPoint((Entity)player, 1.0F); }
/*     */       else
/* 155 */       { entity.m_6469_(entity.m_9236_().m_269111_().m_269333_((LivingEntity)owner), 1.0F); }
/*     */     
/*     */     } else {
/* 158 */       entity.m_6469_(entity.m_9236_().m_269111_().m_269264_(), 1.0F);
/*     */     } 
/* 160 */     entity.m_20256_(new Vec3((entity.m_20154_()).f_82479_ * -2.0D, 0.4D, (entity.m_20154_()).f_82481_ * -2.0D));
/* 161 */     if (Math.random() <= 0.5D) {
/* 162 */       new DelayedTask(1)
/*     */         {
/*     */           public void run() {
/* 165 */             if (entity.m_9236_() instanceof ServerLevel && entity instanceof Mob) { Mob mob = (Mob)entity;
/* 166 */               LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 167 */               if (livingEntityPatch != null && !livingEntityPatch.isStunned()) {
/* 168 */                 livingEntityPatch.applyStun(StunType.LONG, 10.0F);
/*     */               } }
/*     */           
/*     */           }
/*     */         };
/*     */       
/* 174 */       if (Math.random() <= 0.3D) {
/* 175 */         new DelayedTask(1)
/*     */           {
/*     */             public void run() {
/* 178 */               if (entity.m_9236_() instanceof ServerLevel && entity instanceof Mob) { Mob mob = (Mob)entity;
/* 179 */                 LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 180 */                 if (livingEntityPatch != null && !livingEntityPatch.isStunned()) {
/* 181 */                   livingEntityPatch.applyStun(StunType.KNOCKDOWN, 10.0F);
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
/* 192 */     return (BlockEntity)new ShadowObsidianBlockEntity(pPos, pState);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\block\ShadowObsidianBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */