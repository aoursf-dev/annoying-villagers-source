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
/*    */ @OnlyIn(Dist.CLIENT)
/*    */ public class EnderParticle extends TextureSheetParticle {
/*    */   private final SpriteSet spriteSet;
/*    */   
/*    */   public static EnderParticleProvider provider(SpriteSet spriteset) {
/* 20 */     return new EnderParticleProvider(spriteset);
/*    */   }
/*    */   
/*    */   protected EnderParticle(ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5, SpriteSet spriteset) {
/* 24 */     super(clientlevel, d0, d1, d2);
/* 25 */     this.spriteSet = spriteset;
/* 26 */     m_107250_(0.4F, 0.4F);
/* 27 */     this.f_107663_ *= 0.7F;
/* 28 */     this.f_107225_ = Math.max(1, 20 + this.f_107223_.m_188503_(12) - 6);
/* 29 */     this.f_107226_ = -0.1F;
/* 30 */     this.f_107219_ = false;
/* 31 */     this.f_107215_ = d3;
/* 32 */     this.f_107216_ = d4;
/* 33 */     this.f_107217_ = d5;
/* 34 */     m_108339_(spriteset);
/*    */   }
/*    */   
/*    */   public int m_6355_(float f) {
/* 38 */     return 15728880;
/*    */   }
/*    */   @NotNull
/*    */   public ParticleRenderType m_7556_() {
/* 42 */     return ParticleRenderType.f_107432_;
/*    */   }
/*    */   
/*    */   public void m_5989_() {
/* 46 */     super.m_5989_();
/* 47 */     if (!this.f_107220_) {
/* 48 */       m_108337_(this.spriteSet.m_5819_(this.f_107224_ % 8 + 1, 8));
/*    */     }
/*    */   }
/*    */   
/*    */   public static class EnderParticleProvider
/*    */     implements ParticleProvider<SimpleParticleType>
/*    */   {
/*    */     private final SpriteSet spriteSet;
/*    */     
/*    */     public EnderParticleProvider(SpriteSet spriteset) {
/* 58 */       this.spriteSet = spriteset;
/*    */     }
/*    */     
/*    */     public Particle createParticle(@NotNull SimpleParticleType simpleparticletype, @NotNull ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5) {
/* 62 */       return (Particle)new EnderParticle(clientlevel, d0, d1, d2, d3, d4, d5, this.spriteSet);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\EnderParticle.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */