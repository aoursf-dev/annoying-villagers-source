/*    */ package com.pla.annoyingvillagers.entity;
/*    */ 
/*    */ import com.pla.annoyingvillagers.clazz.NullWeapon;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.network.PlayMessages;
/*    */ 
/*    */ public class NullAxeEntity extends NullWeapon {
/*    */   public NullAxeEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/* 12 */     this((EntityType<NullAxeEntity>)AnnoyingVillagersModEntities.NULL_AXE.get(), level);
/*    */   }
/*    */   
/*    */   public NullAxeEntity(EntityType<NullAxeEntity> entitytype, Level level) {
/* 16 */     super(entitytype, level);
/* 17 */     setWeapon("axe");
/*    */   }
/*    */   
/*    */   public static AttributeSupplier.Builder createAttributes() {
/* 21 */     return NullWeapon.createAttributes();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\NullAxeEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */