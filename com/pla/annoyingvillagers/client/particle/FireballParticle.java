/*    */ package com.pla.annoyingvillagers.client.particle;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.Particle;
/*    */ import net.minecraft.client.particle.ParticleProvider;
/*    */ import net.minecraft.client.particle.ParticleRenderType;
/*    */ import net.minecraft.client.particle.SpriteSet;
/*    */ import net.minecraft.client.particle.TextureSheetParticle;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FireballParticle
/*    */   extends TextureSheetParticle
/*    */ {
/*    */   private final SpriteSet sprites;
/*    */   boolean important;
/*    */   
/*    */   public static FireballParticleProvider provider(SpriteSet spriteset) {
/* 38 */     return new FireballParticleProvider(spriteset);
/*    */   }
/*    */   
/*    */   FireballParticle(ClientLevel world, double x, double y, double z, SpriteSet spriteProvider, double velX, double velY, double velZ) {
/* 42 */     super(world, x, y, z);
/* 43 */     this.sprites = spriteProvider;
/* 44 */     this.f_107225_ = (int)(9.0D + Math.floor(velX / 5.0D));
/* 45 */     this.f_107663_ = (float)velX;
/* 46 */     this.important = (velY == 1.0D);
/* 47 */     m_172260_(0.0D, 0.0D, 0.0D);
/* 48 */     m_108339_(spriteProvider);
/*    */   }
/*    */   
/*    */   public void m_5989_() {
/* 52 */     this.f_107209_ = this.f_107212_;
/* 53 */     this.f_107210_ = this.f_107213_;
/* 54 */     this.f_107211_ = this.f_107214_;
/* 55 */     if (this.f_107224_++ >= this.f_107225_) {
/* 56 */       m_107274_();
/*    */     } else {
/* 58 */       this.f_107216_ -= this.f_107226_;
/* 59 */       m_6257_(this.f_107215_, this.f_107216_, this.f_107217_);
/* 60 */       m_108339_(this.sprites);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected int m_6355_(float pPartialTick) {
/* 66 */     return 15728880;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public ParticleRenderType m_7556_() {
/* 72 */     return ParticleRenderType.f_107431_;
/*    */   }
/*    */   
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public static class FireballParticleProvider implements ParticleProvider<SimpleParticleType> {
/*    */     private final SpriteSet sprites;
/*    */     
/*    */     public FireballParticleProvider(SpriteSet spriteSet) {
/* 80 */       this.sprites = spriteSet;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
/* 86 */       return (Particle)new FireballParticle(level, x, y, z, this.sprites, dx, dy, dz);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\FireballParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */