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
/*    */ 
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class MeteoriteTrailParticle
/*    */   extends TextureSheetParticle
/*    */ {
/*    */   private final SpriteSet spriteSet;
/*    */   private float angularVelocity;
/*    */   private final float angularAcceleration;
/*    */   
/*    */   public static MeteoriteTrailParticleProvider provider(SpriteSet spriteset) {
/* 41 */     return new MeteoriteTrailParticleProvider(spriteset);
/*    */   }
/*    */   
/*    */   protected MeteoriteTrailParticle(ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5, SpriteSet spriteset) {
/* 45 */     super(clientlevel, d0, d1, d2);
/* 46 */     this.spriteSet = spriteset;
/* 47 */     m_107250_(0.2F, 0.2F);
/* 48 */     this.f_107663_ *= 16.0F;
/* 49 */     this.f_107225_ = 15;
/* 50 */     this.f_107226_ = 0.0F;
/* 51 */     this.f_107219_ = false;
/* 52 */     this.f_107215_ = d3;
/* 53 */     this.f_107216_ = d4;
/* 54 */     this.f_107217_ = d5;
/* 55 */     this.angularVelocity = 0.0F;
/* 56 */     this.angularAcceleration = 0.03F;
/* 57 */     m_108339_(spriteset);
/*    */   }
/*    */   
/*    */   public int m_6355_(float f) {
/* 61 */     return 15728880;
/*    */   }
/*    */   @NotNull
/*    */   public ParticleRenderType m_7556_() {
/* 65 */     return ParticleRenderType.f_107432_;
/*    */   }
/*    */   
/*    */   public void m_5989_() {
/* 69 */     super.m_5989_();
/* 70 */     this.f_107204_ = this.f_107231_;
/* 71 */     this.f_107231_ += this.angularVelocity;
/* 72 */     this.angularVelocity += this.angularAcceleration;
/* 73 */     if (!this.f_107220_)
/* 74 */       m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 2 % 8 + 1, 8)); 
/*    */   }
/*    */   
/*    */   public static class MeteoriteTrailParticleProvider
/*    */     implements ParticleProvider<SimpleParticleType>
/*    */   {
/*    */     private final SpriteSet spriteSet;
/*    */     
/*    */     public MeteoriteTrailParticleProvider(SpriteSet spriteset) {
/* 83 */       this.spriteSet = spriteset;
/*    */     }
/*    */ 
/*    */     
/*    */     public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d0, double d1, double d2, double d3, double d4, double d5) {
/* 88 */       return (Particle)new MeteoriteTrailParticle(clientLevel, d0, d1, d2, d3, d4, d5, this.spriteSet);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\MeteoriteTrailParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */