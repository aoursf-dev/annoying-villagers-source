/*    */ package com.pla.annoyingvillagers.client.particle;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.particle.Particle;
/*    */ import net.minecraft.client.particle.ParticleProvider;
/*    */ import net.minecraft.client.particle.SpriteSet;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MeteoriteTrailParticleProvider
/*    */   implements ParticleProvider<SimpleParticleType>
/*    */ {
/*    */   private final SpriteSet spriteSet;
/*    */   
/*    */   public MeteoriteTrailParticleProvider(SpriteSet spriteset) {
/* 83 */     this.spriteSet = spriteset;
/*    */   }
/*    */ 
/*    */   
/*    */   public Particle createParticle(@NotNull SimpleParticleType simpleParticleType, @NotNull ClientLevel clientLevel, double d0, double d1, double d2, double d3, double d4, double d5) {
/* 88 */     return (Particle)new MeteoriteTrailParticle(clientLevel, d0, d1, d2, d3, d4, d5, this.spriteSet);
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\particle\MeteoriteTrailParticle$MeteoriteTrailParticleProvider.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */