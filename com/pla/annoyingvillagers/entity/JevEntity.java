/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.clazz.AVNpc;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.CombatBehaviour;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.damagesource.DamageSource;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.MobType;
/*     */ import net.minecraft.world.entity.PathfinderMob;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
/*     */ import net.minecraft.world.entity.ai.goal.Goal;
/*     */ import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
/*     */ import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.level.LevelAccessor;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import net.minecraftforge.network.PlayMessages;
/*     */ import net.minecraftforge.registries.ForgeRegistries;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ public class JevEntity extends AVNpc {
/*     */   private UUID followTargetUUID;
/*     */   
/*     */   public void setFollowTarget(AlexEntity followTarget) {
/*  44 */     this.followTarget = followTarget;
/*     */   }
/*     */   private AlexEntity followTarget;
/*     */   public void setFollowTargetUUID(UUID followTargetUUID) {
/*  48 */     this.followTargetUUID = followTargetUUID;
/*     */   }
/*     */   
/*     */   public JevEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/*  52 */     this((EntityType<JevEntity>)AnnoyingVillagersModEntities.JEV.get(), level);
/*     */   }
/*     */   
/*     */   public JevEntity(EntityType<JevEntity> entitytype, Level level) {
/*  56 */     super(entitytype, level);
/*  57 */     m_274367_(0.6F);
/*  58 */     this.f_21364_ = 10;
/*  59 */     m_21557_(false);
/*  60 */     m_6593_(m_5446_());
/*  61 */     m_21530_();
/*  62 */     m_8061_(EquipmentSlot.OFFHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.JEV_BOOK.get()));
/*  63 */     m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)AnnoyingVillagersModItems.JEV_PENCIL.get()));
/*  64 */     m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)AnnoyingVillagersModItems.JEV_GLASSES.get()));
/*  65 */     setPlaceBlockToParryChance(0.0D);
/*     */   }
/*     */   @NotNull
/*     */   public Packet<ClientGamePacketListener> m_5654_() {
/*  69 */     return NetworkHooks.getEntitySpawningPacket((Entity)this);
/*     */   }
/*     */   
/*     */   protected void m_8099_() {
/*  73 */     super.m_8099_();
/*  74 */     this.f_21345_.m_25352_(1, (Goal)new LookAtPlayerGoal((Mob)this, AlexEntity.class, 12.0F));
/*  75 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, Monster.class, 5.0F, 1.2D, 1.8D));
/*  76 */     this.f_21345_.m_25352_(2, (Goal)new AvoidEntityGoal((PathfinderMob)this, Player.class, 5.0F, 1.2D, 1.8D));
/*  77 */     this.f_21345_.m_25352_(2, new Goal()
/*     */         {
/*     */           public boolean m_8036_() {
/*  80 */             return (JevEntity.this.followTarget != null && JevEntity.this.followTarget.m_6084_() && JevEntity.this.m_20270_((Entity)JevEntity.this.followTarget) > 18.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           public void m_8037_() {
/*  85 */             if (JevEntity.this.followTarget != null && JevEntity.this.followTarget.m_6084_()) {
/*  86 */               JevEntity.this.m_21573_().m_5624_((Entity)JevEntity.this.followTarget, 2.0D);
/*  87 */               JevEntity.this.m_21563_().m_24960_((Entity)JevEntity.this.followTarget, 30.0F, 30.0F);
/*  88 */               if (JevEntity.this.m_20280_((Entity)JevEntity.this.followTarget) > 20.0D) {
/*  89 */                 if (JevEntity.this.m_21573_().m_26571_()) {
/*  90 */                   JevEntity.this.m_21573_().m_5624_((Entity)JevEntity.this.followTarget, 2.0D);
/*     */                 }
/*     */               } else {
/*  93 */                 JevEntity.this.m_21573_().m_26573_();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean m_8045_() {
/* 100 */             return (JevEntity.this.followTarget != null && JevEntity.this.followTarget.m_6084_() && JevEntity.this.m_20270_((Entity)JevEntity.this.followTarget) > 50.0D);
/*     */           }
/*     */         });
/* 103 */     this.f_21345_.m_25352_(3, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0D));
/* 104 */     this.f_21345_.m_25352_(4, (Goal)new RandomLookAroundGoal((Mob)this));
/* 105 */     this.f_21345_.m_25352_(5, (Goal)new FloatGoal((Mob)this));
/* 106 */     this.f_21345_.m_25352_(6, (Goal)new FollowMobGoal((Mob)this, 1.0D, 10.0F, 5.0F));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SpawnGroupData m_6518_(@NotNull ServerLevelAccessor pLevel, @NotNull DifficultyInstance pDifficulty, @NotNull MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
/* 111 */     SpawnGroupData returnSpawnGroupData = super.m_6518_(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
/* 112 */     TeamUtil.addOrJoinTeam((Entity)this, "alex");
/* 113 */     setMainWeaponItem(new ItemStack((ItemLike)AnnoyingVillagersModItems.JEV_PENCIL.get()));
/* 114 */     setOffWeaponItem(new ItemStack((ItemLike)AnnoyingVillagersModItems.JEV_BOOK.get()));
/* 115 */     return returnSpawnGroupData;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_6667_(@NotNull DamageSource pDamageSource) {
/* 120 */     super.m_6667_(pDamageSource);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void implementFirstTick(ServerLevel serverLevel) {
/* 125 */     super.implementFirstTick(serverLevel);
/* 126 */     m_5496_((SoundEvent)AnnoyingVillagersModSounds.JEV_SAY_ON_SPAWN
/* 127 */         .get(), 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/* 134 */     super.m_8119_();
/* 135 */     if (!(m_9236_()).f_46443_) {
/* 136 */       if (this.followTarget == null && this.followTargetUUID != null) {
/* 137 */         Entity entity = ((ServerLevel)m_9236_()).m_8791_(this.followTargetUUID);
/* 138 */         if (entity instanceof AlexEntity) { AlexEntity alex = (AlexEntity)entity;
/* 139 */           this.followTarget = alex; }
/*     */         else
/* 141 */         { this.followTargetUUID = null; }
/*     */       
/*     */       } 
/* 144 */       if (this.followTarget != null && !this.followTarget.m_6084_()) {
/* 145 */         this.followTarget = null;
/* 146 */         this.followTargetUUID = null;
/*     */       } 
/* 148 */       if (this.followTarget != null && this.followTarget.m_6084_()) {
/* 149 */         double distanceSq = m_20280_((Entity)this.followTarget);
/*     */         
/* 151 */         if (distanceSq > 600.0D) {
/* 152 */           m_6021_(this.followTarget
/* 153 */               .m_20185_(), this.followTarget
/* 154 */               .m_20186_(), this.followTarget
/* 155 */               .m_20189_());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public MobType m_6336_() {
/* 163 */     return MobType.f_21640_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(@NotNull CompoundTag tag) {
/* 168 */     super.m_7380_(tag);
/* 169 */     if (this.followTargetUUID != null) {
/* 170 */       tag.m_128362_("FollowTarget", this.followTargetUUID);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/* 176 */     super.m_7378_(tag);
/* 177 */     if (tag.m_128403_("FollowTarget")) {
/* 178 */       this.followTargetUUID = tag.m_128342_("FollowTarget");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean m_6785_(double d0) {
/* 183 */     return false;
/*     */   }
/*     */   
/*     */   public double m_6049_() {
/* 187 */     return -0.35D;
/*     */   }
/*     */   
/*     */   public SoundEvent m_7515_() {
/* 191 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.ambient"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_7975_(@NotNull DamageSource damageSource) {
/* 195 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.hurt"));
/*     */   }
/*     */   
/*     */   public SoundEvent m_5592_() {
/* 199 */     return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.fromNamespaceAndPath("minecraft", "entity.villager.death"));
/*     */   }
/*     */   
/*     */   public boolean m_6469_(@NotNull DamageSource damageSource, float f) {
/* 203 */     if (getGapCooldown() == 0 && m_21223_() <= 0.6666667F * m_21233_()) {
/* 204 */       if (!(m_9236_()).f_46443_) {
/* 205 */         ItemStack stack = PotionUtils.m_43549_(new ItemStack((ItemLike)Items.f_42589_), Potions.f_43581_);
/* 206 */         m_21008_(InteractionHand.MAIN_HAND, stack);
/*     */       } 
/* 208 */       CombatBehaviour.drinkingHealingPotion((Entity)this, (LevelAccessor)m_9236_(), false, f);
/* 209 */       setGapCooldown();
/*     */     } 
/* 211 */     return super.m_6469_(damageSource, f);
/*     */   }
/*     */   
/*     */   public static AttributeSupplier.Builder createAttributes() {
/* 215 */     AttributeSupplier.Builder builder = Mob.m_21552_();
/*     */     
/* 217 */     builder = builder.m_22268_(Attributes.f_22279_, 0.45D);
/* 218 */     builder = builder.m_22268_(Attributes.f_22276_, 50.0D);
/* 219 */     builder = builder.m_22268_(Attributes.f_22284_, 20.0D);
/* 220 */     builder = builder.m_22268_(Attributes.f_22281_, 0.0D);
/* 221 */     builder = builder.m_22268_(Attributes.f_22277_, 48.0D);
/* 222 */     builder = builder.m_22268_(Attributes.f_22278_, 5.0D);
/* 223 */     return builder;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\JevEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */