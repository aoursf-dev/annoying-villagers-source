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
/*    */ public class BigSplashParticle
/*    */   extends TextureSheetParticle
/*    */ {
/*    */   private final SpriteSet spriteSet;
/*    */   
/*    */   public static BigSplashParticleProvider provider(SpriteSet spriteset) {
/* 39 */     return new BigSplashParticleProvider(spriteset);
/*    */   }
/*    */   
/*    */   protected BigSplashParticle(ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5, SpriteSet spriteset) {
/* 43 */     super(clientlevel, d0, d1, d2);
/* 44 */     this.spriteSet = spriteset;
/* 45 */     m_107250_(0.2F, 0.2F);
/* 46 */     this.f_107225_ = Math.max(1, 30 + this.f_107223_.m_188503_(40) - 20);
/* 47 */     this.f_107226_ = 0.7F;
/* 48 */     this.f_107219_ = false;
/* 49 */     this.f_107215_ = d3;
/* 50 */     this.f_107216_ = d4;
/* 51 */     this.f_107217_ = d5;
/* 52 */     m_108339_(spriteset);
/*    */   }
/*    */   @NotNull
/*    */   public ParticleRenderType m_7556_() {
/* 56 */     return ParticleRenderType.f_107431_;
/*    */   }
/*    */   
/*    */   public float m_5902_(float f) {
/* 60 */     return (float)((super.m_5902_(f) * 19.0F) + Math.sin(this.f_107224_ * 0.2D) * 2.0D);
/*    */   }
/*    */   
/*    */   public void m_5989_() {
/* 64 */     super.m_5989_();
/* 65 */     if (!this.f_107220_) {
/* 66 */       m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 6 % 11 + 1, 11));
/*    */     }
/*    */   }
/*    */   
/*    */   public static class BigSplashParticleProvider
/*    */     implements ParticleProvider<SimpleParticleType>
/*    */   {
/*    */     private final SpriteSet spriteSet;
/*    */     
/*    */     public BigSplashParticleProvider(SpriteSet spriteset) {
/* 76 */       this.spriteSet = spriteset;
/*    */     }
/*    */     
/*    */     public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d0, double d1, double d2, double d3, double d4, double d5) {
/* 80 */       return (Particle)new BigSplashParticle(clientLevel, d0, d1, d2, d3, d4, d5, this.spriteSet);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\BigSplashParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */