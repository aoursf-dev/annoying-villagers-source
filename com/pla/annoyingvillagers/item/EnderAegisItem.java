/*     */ package com.pla.annoyingvillagers.item;
/*     */ import com.pla.annoyingvillagers.entity.EnderAegisProjectile;
/*     */ import com.pla.annoyingvillagers.gameasset.AVAnimations;
/*     */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import java.util.List;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.server.level.ServerLevel;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.sounds.SoundSource;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.Mob;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Tier;
/*     */ import net.minecraft.world.item.TooltipFlag;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import yesman.epicfight.skill.SkillContainer;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*     */ 
/*     */ public class EnderAegisItem extends SwordItem {
/*     */   public EnderAegisItem() {
/*  33 */     super(new Tier() {
/*     */           public int m_6609_() {
/*  35 */             return 1561;
/*     */           }
/*     */           
/*     */           public float m_6624_() {
/*  39 */             return 4.0F;
/*     */           }
/*     */           
/*     */           public float m_6631_() {
/*  43 */             return 2.0F;
/*     */           }
/*     */           
/*     */           public int m_6604_() {
/*  47 */             return 1;
/*     */           }
/*     */           
/*     */           public int m_6601_() {
/*  51 */             return 2;
/*     */           }
/*     */           @NotNull
/*     */           public Ingredient m_6282_() {
/*  55 */             return Ingredient.m_43929_(new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN.get() }, );
/*     */           }
/*  57 */         },  3, -2.3F, (new Item.Properties()).m_41486_());
/*     */   }
/*     */   public static void shieldShoot(Level level, Entity entity) {
/*     */     ServerLevel serverLevel;
/*  61 */     if (level instanceof ServerLevel) { serverLevel = (ServerLevel)level; }
/*     */     else { return; }
/*  63 */      Vec3 eye = entity.m_20299_(1.0F);
/*  64 */     Vec3 look = entity.m_20154_();
/*     */     
/*  66 */     if (entity instanceof Mob) { Mob mob = (Mob)entity;
/*  67 */       LivingEntity target = mob.m_5448_();
/*  68 */       if (target != null) {
/*  69 */         look = target.m_20299_(1.0F).m_82546_(eye);
/*     */       } }
/*  71 */     else if (entity instanceof Player)
/*  72 */     { look = new Vec3(look.f_82479_, 0.0D, look.f_82481_); }
/*     */ 
/*     */     
/*  75 */     if (look.m_82556_() < 1.0E-6D) {
/*  76 */       float yawRad = (float)Math.toRadians(entity.m_146908_());
/*  77 */       look = new Vec3(-Mth.m_14031_(yawRad), 0.0D, Mth.m_14089_(yawRad));
/*     */     } 
/*  79 */     Vec3 forward = look.m_82541_();
/*     */     
/*  81 */     Vec3 up = new Vec3(0.0D, 1.0D, 0.0D);
/*  82 */     Vec3 right = forward.m_82537_(up).m_82541_();
/*     */     
/*  84 */     double spawnForward = 0.0D;
/*  85 */     double spread = 0.05D;
/*  86 */     float velocity = 1.2F;
/*  87 */     float inaccuracy = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     Vec3[] offsets = { Vec3.f_82478_, up, up.m_82490_(-1.0D), right.m_82490_(-1.0D), right };
/*     */ 
/*     */ 
/*     */     
/*  97 */     for (Vec3 off : offsets) {
/*  98 */       Vec3 spawnPos = eye.m_82549_(forward.m_82490_(spawnForward)).m_82549_(off.m_82490_(0.15D));
/*  99 */       Vec3 dir = forward.m_82549_(off.m_82490_(spread)).m_82541_();
/*     */ 
/*     */       
/* 102 */       EnderAegisProjectile proj = new EnderAegisProjectile((EntityType)AnnoyingVillagersModEntities.ENDER_AEGIS_PROJECTILE.get(), level);
/*     */       
/* 104 */       proj.m_5602_(entity);
/* 105 */       proj.m_36781_(15.0D);
/* 106 */       proj.m_36735_(5);
/* 107 */       proj.m_20225_(true);
/* 108 */       proj.m_36767_((byte)5);
/*     */       
/* 110 */       proj.m_6034_(spawnPos.f_82479_, spawnPos.f_82480_, spawnPos.f_82481_);
/* 111 */       proj.m_6686_(dir.f_82479_, dir.f_82480_, dir.f_82481_, velocity, inaccuracy);
/*     */       
/* 113 */       serverLevel.m_7967_((Entity)proj);
/*     */     } 
/*     */     
/* 116 */     Vec3 tipPos = eye.m_82549_(forward.m_82490_(2.0D));
/* 117 */     serverLevel.m_8767_((ParticleOptions)AnnoyingVillagersModParticleTypes.SPARK
/* 118 */         .get(), tipPos.f_82479_, tipPos.f_82480_, tipPos.f_82481_, 300, 0.0D, 0.0D, 0.0D, 0.2D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     level.m_5594_(null, entity.m_20183_(), (SoundEvent)AnnoyingVillagersModSounds.COOL_DOWN.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/* 124 */     level.m_5594_(null, entity.m_20183_(), (SoundEvent)AnnoyingVillagersModSounds.ENDER_SHOT.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/* 125 */     level.m_5594_(null, entity.m_20183_(), (SoundEvent)AnnoyingVillagersModSounds.BLOOM.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*     */     
/* 127 */     LivingEntityPatch<?> livingentitypatch = (LivingEntityPatch)EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
/* 128 */     if (livingentitypatch != null) {
/* 129 */       livingentitypatch.playAnimationSynchronized((AssetAccessor)AVAnimations.IDLE_BREAK, 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public void m_6883_(@NotNull ItemStack itemstack, @NotNull Level level, @NotNull Entity entity, int i, boolean flag) {
/* 134 */     super.m_6883_(itemstack, level, entity, i, flag);
/* 135 */     if (flag && 
/* 136 */       itemstack.m_41783_() != null && itemstack.m_41783_().m_128471_("SecondForm")) {
/* 137 */       HerobrineUtil.spawnEliteEffect(level, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
/*     */     }
/*     */     
/* 140 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 141 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 142 */       if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 143 */         SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.ENDER_AEGIS);
/* 144 */         if (skillContainer != null && itemstack.m_41783_() != null) {
/* 145 */           if (!skillContainer.isActivated() && itemstack.m_41783_().m_128471_("SecondForm")) {
/* 146 */             itemstack.m_41783_().m_128379_("SecondForm", false);
/*     */           }
/* 148 */           if (skillContainer.isActivated() && !itemstack.m_41783_().m_128471_("SecondForm")) {
/* 149 */             itemstack.m_41783_().m_128379_("SecondForm", true);
/*     */           }
/*     */         }  }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 157 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 158 */     list.add(Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.ender_aegis").getString()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EnderAegisItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */