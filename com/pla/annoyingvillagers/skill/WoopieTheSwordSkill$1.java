/*    */ package com.pla.annoyingvillagers.skill;
/*    */ 
/*    */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*    */ import com.pla.annoyingvillagers.network.ClientboundMuteExplosionAtPos;
/*    */ import com.pla.annoyingvillagers.network.ClientboundWoopieSwordWindFx;
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Position;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.phys.Vec3;
/*    */ import net.minecraftforge.network.PacketDistributor;
/*    */ import yesman.epicfight.api.utils.math.Vec3f;
/*    */ import yesman.epicfight.gameasset.Armatures;
/*    */ import yesman.epicfight.model.armature.HumanoidArmature;
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
/*    */ class null
/*    */   extends DelayedTask
/*    */ {
/*    */   null(int waitTicks) {
/* 46 */     super(waitTicks);
/*    */   }
/*    */   public void run() {
/* 49 */     Vec3 windPos = EpicfightUtil.getJointWithTranslation((Entity)player, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED
/*    */ 
/*    */         
/* 52 */         .get()).toolR, 5.3F, 0.5D);
/*    */ 
/*    */ 
/*    */     
/* 56 */     if (windPos != null) {
/* 57 */       BlockPos mutePos = BlockPos.m_274446_((Position)windPos);
/* 58 */       AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 59 */           .with(() -> player), new ClientboundMuteExplosionAtPos(mutePos, 4));
/*    */ 
/*    */       
/* 62 */       player.m_9236_().m_255391_((Entity)player, windPos.f_82479_, windPos.f_82480_, windPos.f_82481_, 2.0F, false, Level.ExplosionInteraction.NONE);
/*    */       
/* 64 */       AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 65 */           .with(() -> player), new ClientboundWoopieSwordWindFx(windPos));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\skill\WoopieTheSwordSkill$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */