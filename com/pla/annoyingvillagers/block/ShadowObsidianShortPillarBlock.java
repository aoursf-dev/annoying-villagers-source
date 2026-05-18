/*     */ package com.pla.annoyingvillagers.block;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineObsidianBlock;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.skill.ShadowObsidianPillarSkill;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.context.BlockPlaceContext;
/*     */ import net.minecraft.world.level.BlockGetter;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.Mirror;
/*     */ import net.minecraft.world.level.block.Rotation;
/*     */ import net.minecraft.world.level.block.entity.BlockEntity;
/*     */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.StateDefinition;
/*     */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.particle.EpicFightParticles;
/*     */ import yesman.epicfight.particle.HitParticleType;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ 
/*     */ public class ShadowObsidianShortPillarBlock extends HerobrineObsidianBlock implements EntityBlock {
/*  39 */   public static final DirectionProperty FACING = BlockStateProperties.f_61374_;
/*     */   
/*     */   public ShadowObsidianShortPillarBlock() {
/*  42 */     super(BlockBehaviour.Properties.m_284310_()
/*  43 */         .m_222979_(BlockBehaviour.OffsetType.XYZ)
/*  44 */         .m_60918_(SoundType.f_56742_)
/*  45 */         .m_60913_(3.0F, 50.0F)
/*  46 */         .m_60955_()
/*  47 */         .m_60982_((state, getter, pos) -> true)
/*  48 */         .m_60991_((state, getter, pos) -> true)
/*  49 */         .m_60924_((state, getter, pos) -> false)
/*  50 */         .m_60988_());
/*     */     
/*  52 */     m_49959_((BlockState)((BlockState)
/*  53 */         m_49965_().m_61090_()).m_61124_((Property)FACING, (Comparable)Direction.NORTH));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
/*  59 */     super.m_7926_(builder);
/*  60 */     builder.m_61104_(new Property[] { (Property)FACING });
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockState m_6843_(BlockState state, Rotation rotation) {
/*  65 */     return (BlockState)state.m_61124_((Property)FACING, (Comparable)rotation.m_55954_((Direction)state.m_61143_((Property)FACING)));
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockState m_6943_(BlockState state, Mirror mirror) {
/*  70 */     return state.m_60717_(mirror.m_54846_((Direction)state.m_61143_((Property)FACING)));
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockState m_5573_(@NotNull BlockPlaceContext blockPlaceContext) {
/*  75 */     BlockState state = super.m_5573_(blockPlaceContext);
/*  76 */     if (state == null) state = m_49966_(); 
/*  77 */     return (BlockState)state.m_61124_((Property)FACING, (Comparable)blockPlaceContext.m_8125_().m_122424_());
/*     */   }
/*     */   @NotNull
/*     */   public VoxelShape m_5940_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos, @NotNull CollisionContext collisioncontext) {
/*  81 */     return m_49796_(5.0D, 6.0D, 0.0D, 9.0D, 10.0D, 16.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customPlaceSound(ServerLevel serverLevel, BlockPos blockPos) {
/*  86 */     super.customPlaceSound(serverLevel, blockPos);
/*  87 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  89 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OB_PLACE
/*  90 */         .get(), SoundSource.BLOCKS, (new Random())
/*     */         
/*  92 */         .nextFloat(0.2F, 0.6F), 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void customTickSound(ServerLevel serverLevel, BlockPos blockPos) {
/*  98 */     super.customTickSound(serverLevel, blockPos);
/*  99 */     serverLevel.m_6263_(null, blockPos
/*     */         
/* 101 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OB_PLACE
/* 102 */         .get(), SoundSource.BLOCKS, (new Random())
/*     */         
/* 104 */         .nextFloat(0.2F, 0.6F), 1.0F);
/*     */   }
/*     */   public void increaseSkillPoint(Entity entity, float value) {
/*     */     Player pEntity;
/*     */     ServerPlayerPatch serverPlayerPatch;
/* 109 */     if (entity instanceof Player) { pEntity = (Player)entity; }
/*     */     else { return; }
/* 111 */      PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)pEntity, PlayerPatch.class);
/* 112 */     if (playerPatch instanceof ServerPlayerPatch) { serverPlayerPatch = (ServerPlayerPatch)playerPatch; }
/*     */     else { return; }
/* 114 */      SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.SHADOW_OBSIDIAN_PILLAR);
/* 115 */     if (skillContainer == null)
/*     */       return; 
/* 117 */     ShadowObsidianPillarSkill skill = (ShadowObsidianPillarSkill)skillContainer.getSkill();
/*     */     
/* 119 */     float currentResource = skillContainer.getResource();
/* 120 */     float neededResource = skillContainer.getNeededResource();
/* 121 */     float addResource = Math.min(value, neededResource);
/*     */     
/* 123 */     skill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customHurtLogic(Entity entity, Entity owner, ServerLevel serverLevel, BlockPos blockPos) {
/* 128 */     super.customHurtLogic(entity, owner, serverLevel, blockPos);
/* 129 */     ((HitParticleType)EpicFightParticles.HIT_BLUNT.get()).spawnParticleWithArgument(serverLevel, HitParticleType.FRONT_OF_EYES, HitParticleType.ZERO, entity, entity);
/* 130 */     serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.SPARK
/* 131 */         .get(), entity
/* 132 */         .m_20185_(), entity.m_20186_() + 1.5D, entity.m_20189_() + 0.8D, 5, 0.0D, 0.0D, 0.0D, 0.1D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     serverLevel.m_6263_(null, blockPos
/*     */         
/* 139 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OB_PLACE
/* 140 */         .get(), SoundSource.BLOCKS, 1.0F, 1.0F);
/*     */ 
/*     */ 
/*     */     
/* 144 */     if (owner != null) {
/* 145 */       if (owner instanceof Player) { Player player = (Player)owner;
/* 146 */         entity.m_6469_(entity.m_9236_().m_269111_().m_269075_(player), 1.0F);
/* 147 */         increaseSkillPoint((Entity)player, 0.2F); }
/*     */       else
/* 149 */       { entity.m_6469_(entity.m_9236_().m_269111_().m_269333_((LivingEntity)owner), 1.0F); }
/*     */     
/*     */     } else {
/* 152 */       entity.m_6469_(entity.m_9236_().m_269111_().m_269264_(), 1.0F);
/*     */     } 
/* 154 */     entity.m_20256_(new Vec3((-6.0D + Math.random() * 5.0D) * (entity.m_20154_()).f_82479_, 0.0D, (-6.0D + Math.random() * 5.0D) * (entity.m_20154_()).f_82481_));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public BlockEntity m_142194_(@NotNull BlockPos pPos, @NotNull BlockState pState) {
/* 159 */     return (BlockEntity)new ShadowObsidianShortPillarBlockEntity(pPos, pState);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\block\ShadowObsidianShortPillarBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */