/*    */ package com.pla.annoyingvillagers.gameasset;
/*    */ 
/*    */ import com.pla.annoyingvillagers.skill.TridentFestivalSkill;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ import yesman.epicfight.api.utils.PacketBufferCodec;
/*    */ import yesman.epicfight.skill.SkillDataKey;
/*    */ 
/*    */ public class AVSkillDataKeys
/*    */ {
/* 12 */   public static final DeferredRegister<SkillDataKey<?>> DATA_KEYS = DeferredRegister.create(ResourceLocation.fromNamespaceAndPath("epicfight", "skill_data_keys"), "annoyingvillagers");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 20 */   public static final RegistryObject<SkillDataKey<Boolean>> IS_TRIDENT_RANGED_MODE = DATA_KEYS.register("is_trident_ranged_mode", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.BOOLEAN, Boolean.valueOf(false), true, new Class[] { TridentFestivalSkill.class }));
/* 21 */   public static final RegistryObject<SkillDataKey<Integer>> TRIDENT_AMOUNT = DATA_KEYS.register("trident_amount", () -> SkillDataKey.createSkillDataKey(PacketBufferCodec.INTEGER, Integer.valueOf(0), true, new Class[] { TridentFestivalSkill.class }));
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\gameasset\AVSkillDataKeys.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */