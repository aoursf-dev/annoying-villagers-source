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
/*    */ public class RedSparkParticle extends TextureSheetParticle {
/*    */   private final SpriteSet spriteSet;
/*    */   
/*    */   public static RedSparkParticleProvider provider(SpriteSet spriteset) {
/* 19 */     return new RedSparkParticleProvider(spriteset);
/*    */   }
/*    */   
/*    */   protected RedSparkParticle(ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5, SpriteSet spriteset) {
/* 23 */     super(clientlevel, d0, d1, d2);
/* 24 */     this.spriteSet = spriteset;
/* 25 */     m_107250_(0.2F, 0.2F);
/* 26 */     this.f_107663_ *= 0.12F;
/* 27 */     this.f_107225_ = Math.max(1, 16 + this.f_107223_.m_188503_(20) - 10);
/* 28 */     this.f_107226_ = 0.4F;
/* 29 */     this.f_107219_ = false;
/* 30 */     this.f_107215_ = d3 * 1.0D;
/* 31 */     this.f_107216_ = d4 * 1.0D;
/* 32 */     this.f_107217_ = d5 * 1.0D;
/* 33 */     m_108335_(spriteset);
/*    */   }
/*    */   
/*    */   public int m_6355_(float f) {
/* 37 */     return 15728880;
/*    */   }
/*    */   
/*    */   public ParticleRenderType m_7556_() {
/* 41 */     return ParticleRenderType.f_107432_;
/*    */   }
/*    */   
/*    */   public void m_5989_() {
/* 45 */     super.m_5989_();
/*    */   }
/*    */   
/*    */   public static class RedSparkParticleProvider
/*    */     implements ParticleProvider<SimpleParticleType> {
/*    */     private final SpriteSet spriteSet;
/*    */     
/*    */     public RedSparkParticleProvider(SpriteSet spriteset) {
/* 53 */       this.spriteSet = spriteset;
/*    */     }
/*    */     
/*    */     public Particle createParticle(SimpleParticleType simpleparticletype, ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5) {
/* 57 */       return (Particle)new RedSparkParticle(clientlevel, d0, d1, d2, d3, d4, d5, this.spriteSet);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\RedSparkParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */