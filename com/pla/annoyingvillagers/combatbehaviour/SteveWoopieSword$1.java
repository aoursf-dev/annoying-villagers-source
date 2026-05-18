/*    */ package com.pla.annoyingvillagers.combatbehaviour;
/*    */ 
/*    */ import com.pla.annoyingvillagers.AnnoyingVillagers;
/*    */ import com.pla.annoyingvillagers.entity.SteveEntity;
/*    */ import com.pla.annoyingvillagers.network.ClientboundMuteExplosionAtPos;
/*    */ import com.pla.annoyingvillagers.network.ClientboundWoopieSwordWindFx;
/*    */ import com.pla.annoyingvillagers.task.DelayedTask;
/*    */ import com.pla.annoyingvillagers.util.EpicfightUtil;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Position;
/*    */ import net.minecraft.world.entity.Entity;
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
/*    */ class null
/*    */   extends DelayedTask
/*    */ {
/*    */   null(int waitTicks) {
/* 40 */     super(waitTicks);
/*    */   }
/*    */   public void run() {
/* 43 */     Vec3 windPos = EpicfightUtil.getJointWithTranslation((Entity)steveEntity, new Vec3f(0.0F, 0.0F, 0.0F), ((HumanoidArmature)Armatures.BIPED
/*    */ 
/*    */         
/* 46 */         .get()).toolR, 5.3F, 0.5D);
/*    */ 
/*    */ 
/*    */     
/* 50 */     if (windPos != null) {
/* 51 */       BlockPos mutePos = BlockPos.m_274446_((Position)windPos);
/* 52 */       AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 53 */           .with(() -> steveEntity), new ClientboundMuteExplosionAtPos(mutePos, 4));
/*    */ 
/*    */       
/* 56 */       steveEntity.m_9236_().m_255391_((Entity)steveEntity, windPos.f_82479_, windPos.f_82480_, windPos.f_82481_, 2.0F, false, Level.ExplosionInteraction.NONE);
/*    */       
/* 58 */       AnnoyingVillagers.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF
/* 59 */           .with(() -> steveEntity), new ClientboundWoopieSwordWindFx(windPos));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\combatbehaviour\SteveWoopieSword$1.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */