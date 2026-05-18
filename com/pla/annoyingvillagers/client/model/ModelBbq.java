/*    */ package com.pla.annoyingvillagers.client.model;
/*    */ 
/*    */ import net.minecraft.client.model.ChickenModel;
/*    */ import net.minecraft.client.model.geom.ModelPart;
/*    */ import net.minecraft.world.entity.animal.Chicken;
/*    */ 
/*    */ public class ModelBbq<T extends Chicken> extends ChickenModel<T> {
/*    */   private final ModelPart beak;
/*    */   
/*    */   public ModelBbq(ModelPart root) {
/* 11 */     super(root);
/* 12 */     this.beak = root.m_171324_("beak");
/*    */   }
/*    */   
/*    */   public ModelPart getBeak() {
/* 16 */     return this.beak;
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\client\model\ModelBbq.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */