/*     */ package com.pla.annoyingvillagers.entity;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*     */ import com.pla.annoyingvillagers.util.GlintColorHelper;
/*     */ import net.minecraft.core.particles.ParticleOptions;
/*     */ import net.minecraft.core.particles.ParticleTypes;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.syncher.EntityDataAccessor;
/*     */ import net.minecraft.network.syncher.EntityDataSerializers;
/*     */ import net.minecraft.network.syncher.SynchedEntityData;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.entity.projectile.AbstractArrow;
/*     */ import net.minecraft.world.entity.projectile.Arrow;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.Level;
/*     */ import net.minecraft.world.phys.Vec3;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class EnchantedArrowEntity extends Arrow {
/*  24 */   private static final EntityDataAccessor<Integer> COLOR_GLINT = SynchedEntityData.m_135353_(EnchantedArrowEntity.class, EntityDataSerializers.f_135028_);
/*     */   
/*     */   public EnchantedArrowEntity(EntityType<? extends EnchantedArrowEntity> type, Level level) {
/*  27 */     super(type, level);
/*     */   }
/*     */   
/*     */   public EnchantedArrowEntity(@NotNull Level level, @NotNull LivingEntity shooter) {
/*  31 */     this((EntityType<? extends EnchantedArrowEntity>)AnnoyingVillagersModEntities.ENCHANTED_ARROW.get(), level);
/*  32 */     m_5602_((Entity)shooter);
/*  33 */     m_6034_(shooter.m_20185_(), shooter.m_20188_() - 0.1D, shooter.m_20189_());
/*     */     
/*  35 */     if (shooter instanceof Player) { Player player = (Player)shooter;
/*  36 */       this
/*     */         
/*  38 */         .f_36705_ = (player.m_150110_()).f_35937_ ? AbstractArrow.Pickup.CREATIVE_ONLY : AbstractArrow.Pickup.ALLOWED; }
/*     */     else
/*  40 */     { this.f_36705_ = AbstractArrow.Pickup.ALLOWED; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected void m_8097_() {
/*  46 */     super.m_8097_();
/*  47 */     this.f_19804_.m_135372_(COLOR_GLINT, Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   public void setColorGlint(int mode) {
/*  51 */     this.f_19804_.m_135381_(COLOR_GLINT, Integer.valueOf(GlintColorHelper.sanitize(mode)));
/*     */   }
/*     */   
/*     */   public int getColorGlint() {
/*  55 */     return ((Integer)this.f_19804_.m_135370_(COLOR_GLINT)).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7380_(CompoundTag tag) {
/*  60 */     super.m_7380_(tag);
/*  61 */     tag.m_128405_("ColorGlint", getColorGlint());
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_8119_() {
/*  66 */     super.m_8119_();
/*     */     
/*  68 */     if ((m_9236_()).f_46443_) {
/*  69 */       int amount = this.f_36703_ ? ((this.f_36704_ % 5 == 0) ? 1 : 0) : 2;
/*  70 */       if (amount > 0) {
/*  71 */         spawnColoredParticles(amount);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void m_7378_(@NotNull CompoundTag tag) {
/*  78 */     super.m_7378_(tag);
/*     */     
/*  80 */     if (tag.m_128425_("ColorGlint", 3)) {
/*  81 */       setColorGlint(tag.m_128451_("ColorGlint"));
/*  82 */     } else if (tag.m_128425_("ColorGlint", 8)) {
/*  83 */       setColorGlint(GlintColorHelper.fromName(tag.m_128461_("ColorGlint")));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void spawnColoredParticles(int amount) {
/*  88 */     Vec3 rgb = GlintColorHelper.getParticleColor(getColorGlint());
/*     */     
/*  90 */     for (int i = 0; i < amount; i++) {
/*  91 */       m_9236_().m_7106_((ParticleOptions)ParticleTypes.f_123811_, 
/*     */           
/*  93 */           m_20208_(0.5D), 
/*  94 */           m_20187_(), 
/*  95 */           m_20262_(0.5D), rgb.f_82479_, rgb.f_82480_, rgb.f_82481_);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public ItemStack m_7941_() {
/* 103 */     ItemStack stack = new ItemStack((ItemLike)AnnoyingVillagersModItems.ENCHANTED_ARROW.get());
/* 104 */     GlintColorHelper.setColor(stack, getColorGlint());
/* 105 */     return stack;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean m_142470_(@NotNull Player pPlayer) {
/* 110 */     ItemStack stack = m_7941_();
/* 111 */     GlintColorHelper.clearColor(stack);
/*     */     
/* 113 */     switch (this.f_36705_) { case ALLOWED: case CREATIVE_ONLY:  }  return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\EnchantedArrowEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */