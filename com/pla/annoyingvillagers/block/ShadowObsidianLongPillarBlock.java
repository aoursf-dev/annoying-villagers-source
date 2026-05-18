/*     */ package com.pla.annoyingvillagers.block;
/*     */ import com.pla.annoyingvillagers.blockentity.ShadowObsidianLongPillarBlockEntity;
/*     */ import com.pla.annoyingvillagers.clazz.HerobrineObsidianBlock;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.skill.ShadowObsidianPillarSkill;
/*     */ import com.pla.annoyingvillagers.skill.ShadowObsidianSwordSkill;
/*     */ import java.util.Random;
/*     */ import net.minecraft.core.BlockPos;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.world.effect.MobEffects;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
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
/*     */ import net.minecraft.world.level.block.state.properties.DirectionProperty;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import net.minecraft.world.phys.shapes.CollisionContext;
/*     */ import net.minecraft.world.phys.shapes.Shapes;
/*     */ import net.minecraft.world.phys.shapes.VoxelShape;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ 
/*     */ public class ShadowObsidianLongPillarBlock extends HerobrineObsidianBlock implements EntityBlock {
/*  45 */   public static final DirectionProperty FACING = BlockStateProperties.f_61374_;
/*     */   
/*     */   public ShadowObsidianLongPillarBlock() {
/*  48 */     super(BlockBehaviour.Properties.m_284310_()
/*  49 */         .m_60918_(SoundType.f_56742_)
/*  50 */         .m_222979_(BlockBehaviour.OffsetType.XYZ)
/*  51 */         .m_60913_(3.0F, 50.0F)
/*  52 */         .m_60955_()
/*  53 */         .m_60982_((blockstate, blockgetter, blockpos) -> true)
/*  54 */         .m_60991_((blockstate, blockgetter, blockpos) -> true)
/*  55 */         .m_60924_((blockstate, blockgetter, blockpos) -> false)
/*  56 */         .m_60988_());
/*  57 */     m_49959_((BlockState)((BlockState)
/*  58 */         m_49965_().m_61090_()).m_61124_((Property)FACING, (Comparable)Direction.NORTH));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
/*  64 */     super.m_7926_(builder);
/*  65 */     builder.m_61104_(new Property[] { (Property)FACING });
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockState m_6843_(BlockState state, Rotation rotation) {
/*  70 */     return (BlockState)state.m_61124_((Property)FACING, (Comparable)rotation.m_55954_((Direction)state.m_61143_((Property)FACING)));
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockState m_6943_(BlockState state, Mirror mirror) {
/*  75 */     return state.m_60717_(mirror.m_54846_((Direction)state.m_61143_((Property)FACING)));
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockState m_5573_(@NotNull BlockPlaceContext blockPlaceContext) {
/*  80 */     BlockState state = super.m_5573_(blockPlaceContext);
/*  81 */     if (state == null) state = m_49966_(); 
/*  82 */     return (BlockState)state.m_61124_((Property)FACING, (Comparable)blockPlaceContext.m_8125_().m_122424_());
/*     */   }
/*     */   @NotNull
/*     */   public VoxelShape m_5940_(@NotNull BlockState blockstate, @NotNull BlockGetter blockgetter, @NotNull BlockPos blockpos, @NotNull CollisionContext collisioncontext) {
/*  86 */     return Shapes.m_83124_(m_49796_(6.0D, 0.0D, 12.0D, 10.0D, 16.0D, 16.0D), new VoxelShape[] { m_49796_(6.0D, 16.0D, 12.0D, 10.0D, 32.0D, 16.0D), m_49796_(6.0D, -16.0D, 12.0D, 10.0D, 0.0D, 16.0D) });
/*     */   }
/*     */ 
/*     */   
/*     */   public void customPlaceSound(ServerLevel serverLevel, BlockPos blockPos) {
/*  91 */     super.customPlaceSound(serverLevel, blockPos);
/*  92 */     serverLevel.m_6263_(null, blockPos
/*     */         
/*  94 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OB_PLACE
/*  95 */         .get(), SoundSource.BLOCKS, (new Random())
/*     */         
/*  97 */         .nextFloat(0.2F, 0.6F), 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void customTickSound(ServerLevel serverLevel, BlockPos blockPos) {
/* 103 */     super.customTickSound(serverLevel, blockPos);
/* 104 */     serverLevel.m_6263_(null, blockPos
/*     */         
/* 106 */         .m_123341_(), blockPos.m_123342_(), blockPos.m_123343_(), (SoundEvent)AnnoyingVillagersModSounds.OB_PLACE
/* 107 */         .get(), SoundSource.BLOCKS, (new Random())
/*     */         
/* 109 */         .nextFloat(0.2F, 0.6F), 1.0F);
/*     */   } public void increaseSkillPoint(Entity entity, float value) {
/*     */     Player pEntity;
/*     */     ServerPlayerPatch serverPlayerPatch;
/*     */     ShadowObsidianSwordSkill shadowObsidianSwordSkill;
/* 114 */     if (entity instanceof Player) { pEntity = (Player)entity; }
/*     */     else { return; }
/* 116 */      PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)pEntity, PlayerPatch.class);
/* 117 */     if (playerPatch instanceof ServerPlayerPatch) { serverPlayerPatch = (ServerPlayerPatch)playerPatch; }
/*     */     else { return; }
/* 119 */      SkillContainer skillContainer = null;
/* 120 */     WeaponInnateSkill skill = null;
/* 121 */     if (serverPlayerPatch.getSkill(AVSkills.SHADOW_OBSIDIAN_PILLAR) != null) {
/* 122 */       skillContainer = serverPlayerPatch.getSkill(AVSkills.SHADOW_OBSIDIAN_PILLAR);
/* 123 */       if (skillContainer == null)
/* 124 */         return;  ShadowObsidianPillarSkill shadowObsidianPillarSkill = (ShadowObsidianPillarSkill)skillContainer.getSkill();
/* 125 */     } else if (serverPlayerPatch.getSkill(AVSkills.SHADOW_OBSIDIAN_SWORD) != null) {
/* 126 */       skillContainer = serverPlayerPatch.getSkill(AVSkills.SHADOW_OBSIDIAN_SWORD);
/* 127 */       if (skillContainer == null)
/* 128 */         return;  shadowObsidianSwordSkill = (ShadowObsidianSwordSkill)skillContainer.getSkill();
/*     */     } 
/*     */     
/* 131 */     if (skillContainer == null || shadowObsidianSwordSkill == null)
/* 132 */       return;  float currentResource = skillContainer.getResource();
/* 133 */     float neededResource = skillContainer.getNeededResource();
/* 134 */     float addResource = Math.min(value, neededResource);
/*     */     
/* 136 */     shadowObsidianSwordSkill.setConsumptionSynchronize(skillContainer, currentResource + addResource);
/*     */   }
/*     */ 
/*     */   
/*     */   public void customHurtLogic(Entity entity, Entity owner, ServerLevel serverLevel, BlockPos blockPos) {
/* 141 */     super.customHurtLogic(entity, owner, serverLevel, blockPos);
/* 142 */     serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.SPARK
/* 143 */         .get(), entity
/* 144 */         .m_20185_(), entity.m_20186_() + 1.5D, entity.m_20189_() + 0.8D, 5, 0.0D, 0.0D, 0.0D, 0.1D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     if (entity instanceof Mob) { Mob mob = (Mob)entity;
/* 150 */       LivingEntityPatch<?> livingEntityPatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 151 */       mob.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 8, false, false));
/* 152 */       if (livingEntityPatch != null && !livingEntityPatch.isStunned()) {
/* 153 */         livingEntityPatch.applyStun(StunType.SHORT, 1.0F);
/*     */       } }
/*     */     
/* 156 */     if (owner != null) {
/* 157 */       if (owner instanceof Player) { Player player = (Player)owner;
/* 158 */         entity.m_6469_(entity.m_9236_().m_269111_().m_269075_(player), 1.0F);
/* 159 */         increaseSkillPoint((Entity)player, 0.2F); }
/*     */       else
/* 161 */       { entity.m_6469_(entity.m_9236_().m_269111_().m_269333_((LivingEntity)owner), 1.0F); }
/*     */     
/*     */     } else {
/* 164 */       entity.m_6469_(entity.m_9236_().m_269111_().m_269264_(), 1.0F);
/*     */     } 
/* 166 */     entity.m_20256_(new Vec3(0.0D, 0.0D, 0.0D));
/* 167 */     if (Math.random() <= 0.2D && entity.f_19797_ % 10 == 0 && 
/* 168 */       entity instanceof LivingEntity) { LivingEntity livingEntity = (LivingEntity)entity;
/* 169 */       float strength = 1.0F;
/* 170 */       double dx = blockPos.m_123341_() - entity.m_20185_();
/* 171 */       double dz = blockPos.m_123343_() - entity.m_20189_();
/* 172 */       livingEntity.m_147240_(strength, dx, dz); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public BlockEntity m_142194_(@NotNull BlockPos pPos, @NotNull BlockState pState) {
/* 179 */     return (BlockEntity)new ShadowObsidianLongPillarBlockEntity(pPos, pState);
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\block\ShadowObsidianLongPillarBlock.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */