/*    */ package com.pla.annoyingvillagers.client.particle;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.Particle;
/*    */ import net.minecraft.client.particle.ParticleProvider;
/*    */ import net.minecraft.client.particle.SpriteSet;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Dianhu2ParticleProvider
/*    */   implements ParticleProvider<SimpleParticleType>
/*    */ {
/*    */   private final SpriteSet spriteSet;
/*    */   
/*    */   public Dianhu2ParticleProvider(SpriteSet spriteset) {
/* 57 */     this.spriteSet = spriteset;
/*    */   }
/*    */   
/*    */   public Particle createParticle(SimpleParticleType simpleparticletype, ClientLevel clientlevel, double d0, double d1, double d2, double d3, double d4, double d5) {
/* 61 */     return (Particle)new ElectricSpark2Particle(clientlevel, d0, d1, d2, d3, d4, d5, this.spriteSet);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\ElectricSpark2Particle$Dianhu2ParticleProvider.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */