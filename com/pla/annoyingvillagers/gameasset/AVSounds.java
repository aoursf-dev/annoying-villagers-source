/*    */ package com.pla.annoyingvillagers.gameasset;
/*    */ 
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AVSounds
/*    */ {
/*    */   private static RegistryObject<SoundEvent> registerSound(String name) {
/* 19 */     ResourceLocation res = ResourceLocation.fromNamespaceAndPath("annoyingvillagers", name);
/* 20 */     return SOUNDS.register(name, () -> SoundEvent.m_262824_(res));
/*    */   }
/*    */ 
/*    */   
/* 24 */   public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "epicfight");
/* 25 */   public static final RegistryObject<SoundEvent> SWORD_WHOOSH = registerSound("entity.weapon.sword_whoosh");
/* 26 */   public static final RegistryObject<SoundEvent> KICK = registerSound("entity.weapon.kick");
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\gameasset\AVSounds.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */