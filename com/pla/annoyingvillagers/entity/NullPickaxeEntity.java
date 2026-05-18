/*    */ package com.pla.annoyingvillagers.entity;
/*    */ 
/*    */ import com.pla.annoyingvillagers.clazz.NullWeapon;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModEntities;
/*    */ import net.minecraft.world.entity.EntityType;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraftforge.network.PlayMessages;
/*    */ 
/*    */ public class NullPickaxeEntity extends NullWeapon {
/*    */   public NullPickaxeEntity(PlayMessages.SpawnEntity spawnEntity, Level level) {
/* 12 */     this((EntityType<NullPickaxeEntity>)AnnoyingVillagersModEntities.NULL_PICKAXE.get(), level);
/*    */   }
/*    */   
/*    */   public NullPickaxeEntity(EntityType<NullPickaxeEntity> entitytype, Level level) {
/* 16 */     super(entitytype, level);
/* 17 */     setWeapon("pickaxe");
/*    */   }
/*    */   
/*    */   public static AttributeSupplier.Builder createAttributes() {
/* 21 */     return NullWeapon.createAttributes();
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\entity\NullPickaxeEntity.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */