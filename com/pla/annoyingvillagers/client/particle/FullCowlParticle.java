/*    */ package com.pla.annoyingvillagers.client.particle;
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.Particle;
/*    */ import net.minecraft.client.particle.ParticleRenderType;
/*    */ import net.minecraft.client.particle.SpriteSet;
/*    */ import net.minecraft.client.particle.TextureSheetParticle;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.api.distmarker.OnlyIn;
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class FullCowlParticle extends TextureSheetParticle {
/*    */   public static FullCowlProvider provider(SpriteSet spriteset) {
/* 15 */     return new FullCowlProvider(spriteset);
/*    */   }
/*    */   private final SpriteSet spriteSet;
/*    */   protected FullCowlParticle(ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5, SpriteSet spriteset) {
/* 19 */     super(clientlevel, d0, d1, d2);
/* 20 */     this.spriteSet = spriteset;
/* 21 */     m_107250_(0.3F, 0.3F);
/* 22 */     this.f_107663_ *= 2.5F;
/* 23 */     this.f_107225_ = 20 + this.f_107223_.m_188503_(21);
/* 24 */     this.f_107226_ = 0.0F;
/* 25 */     this.f_107219_ = false;
/* 26 */     this.f_107215_ = d3 * 0.0D;
/* 27 */     this.f_107216_ = d4 * 0.0D;
/* 28 */     this.f_107217_ = d5 * 0.0D;
/* 29 */     m_108339_(spriteset);
/*    */   }
/*    */   
/*    */   public int m_6355_(float f) {
/* 33 */     return 15728880;
/*    */   }
/*    */   
/*    */   public ParticleRenderType m_7556_() {
/* 37 */     return ParticleRenderType.f_107432_;
/*    */   }
/*    */   
/*    */   public void m_5989_() {
/* 41 */     super.m_5989_();
/* 42 */     if (!this.f_107220_) {
/* 43 */       m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 1 % 27 + 1, 27));
/*    */     }
/*    */   }
/*    */   
/*    */   public static class FullCowlProvider
/*    */     implements ParticleProvider<SimpleParticleType>
/*    */   {
/*    */     private final SpriteSet spriteSet;
/*    */     
/*    */     public FullCowlProvider(SpriteSet spriteset) {
/* 53 */       this.spriteSet = spriteset;
/*    */     }
/*    */     
/*    */     public Particle createParticle(SimpleParticleType simpleparticletype, ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5) {
/* 57 */       return (Particle)new FullCowlParticle(clientlevel, d0, d1, d2, d3, d4, d5, this.spriteSet);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\FullCowlParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */