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
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class GlowingEyesParticle extends TextureSheetParticle {
/*    */   private final SpriteSet spriteSet;
/*    */   private float angularVelocity;
/*    */   private float angularAcceleration;
/*    */   
/*    */   public static GlowingeyesParticleProvider provider(SpriteSet spriteset) {
/* 21 */     return new GlowingeyesParticleProvider(spriteset);
/*    */   }
/*    */   
/*    */   protected GlowingEyesParticle(ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5, SpriteSet spriteset) {
/* 25 */     super(clientlevel, d0, d1, d2);
/* 26 */     this.spriteSet = spriteset;
/* 27 */     m_107250_(0.0F, 0.0F);
/* 28 */     this.f_107663_ *= 1.7F;
/* 29 */     this.f_107225_ = 1;
/* 30 */     this.f_107226_ = 0.0F;
/* 31 */     this.f_107219_ = false;
/* 32 */     this.f_107215_ = d3 * 0.0D;
/* 33 */     this.f_107216_ = d4 * 0.0D;
/* 34 */     this.f_107217_ = d5 * 0.0D;
/* 35 */     this.angularVelocity = 0.1F;
/* 36 */     this.angularAcceleration = 0.0F;
/* 37 */     m_108335_(spriteset);
/*    */   }
/*    */   
/*    */   public int m_6355_(float f) {
/* 41 */     return 15728880;
/*    */   }
/*    */   
/*    */   public ParticleRenderType m_7556_() {
/* 45 */     return ParticleRenderType.f_107432_;
/*    */   }
/*    */   
/*    */   public void m_5989_() {
/* 49 */     super.m_5989_();
/* 50 */     this.f_107204_ = this.f_107231_;
/* 51 */     this.f_107231_ += this.angularVelocity;
/* 52 */     this.angularVelocity += this.angularAcceleration;
/*    */   }
/*    */   
/*    */   public static class GlowingeyesParticleProvider
/*    */     implements ParticleProvider<SimpleParticleType> {
/*    */     private final SpriteSet spriteSet;
/*    */     
/*    */     public GlowingeyesParticleProvider(SpriteSet spriteset) {
/* 60 */       this.spriteSet = spriteset;
/*    */     }
/*    */     
/*    */     public Particle createParticle(SimpleParticleType simpleparticletype, ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5) {
/* 64 */       return (Particle)new GlowingEyesParticle(clientlevel, d0, d1, d2, d3, d4, d5, this.spriteSet);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\GlowingEyesParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */