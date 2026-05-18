/*     */ package com.pla.annoyingvillagers.mixin;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModSounds;
/*     */ import com.pla.annoyingvillagers.util.CommonGoals;
/*     */ import com.pla.annoyingvillagers.util.TeamUtil;
/*     */ import java.util.Random;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.sounds.SoundEvent;
/*     */ import net.minecraft.util.Mth;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.EntityType;
/*     */ import net.minecraft.world.entity.EquipmentSlot;
/*     */ import net.minecraft.world.entity.MobSpawnType;
/*     */ import net.minecraft.world.entity.SpawnGroupData;
/*     */ import net.minecraft.world.entity.monster.Monster;
/*     */ import net.minecraft.world.entity.monster.Zombie;
/*     */ import net.minecraft.world.item.DyeableLeatherItem;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.level.ServerLevelAccessor;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ @Mixin(value = {Zombie.class}, remap = true)
/*     */ public class ZombieMixin {
/*     */   @Unique
/*  34 */   private int annoyingvillagers$voiceCooldown = 0;
/*     */ 
/*     */   
/*     */   @Inject(method = {"registerGoals"}, at = {@At("HEAD")})
/*     */   private void monsterTargetNpc(CallbackInfo ci) {
/*  39 */     Zombie self = (Zombie)this;
/*  40 */     if (!(self instanceof net.minecraft.world.entity.monster.Drowned)) {
/*  41 */       CommonGoals.registerGoalForHostileNpc((Monster)self);
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"finalizeSpawn"}, at = {@At("RETURN")})
/*     */   private void monsterJoinHerobrineTeam(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag, CallbackInfoReturnable<SpawnGroupData> cir) {
/*  47 */     Zombie self = (Zombie)this;
/*  48 */     if (!self.m_9236_().m_5776_() && self.m_20194_() != null) {
/*  49 */       TeamUtil.addOrJoinTeam((Entity)self, "herobrine");
/*     */       
/*     */       try {
/*  52 */         self.m_20194_().m_129892_().m_82094_().execute("data merge entity @s {CanPickUpLoot: 1b}", self
/*     */             
/*  54 */             .m_20203_().m_81324_().m_81325_(4));
/*  55 */       } catch (CommandSyntaxException commandSyntaxException) {}
/*     */ 
/*     */       
/*  58 */       Random random = new Random();
/*     */       
/*  60 */       if (random.nextFloat() < 0.2F) {
/*  61 */         self.m_8061_(EquipmentSlot.HEAD, createDyedArmor(Items.f_42407_, random));
/*     */       }
/*  63 */       if (random.nextFloat() < 0.2F) {
/*  64 */         self.m_8061_(EquipmentSlot.CHEST, createDyedArmor(Items.f_42408_, random));
/*     */       }
/*  66 */       if (random.nextFloat() < 0.2F) {
/*  67 */         self.m_8061_(EquipmentSlot.LEGS, createDyedArmor(Items.f_42462_, random));
/*     */       }
/*  69 */       if (random.nextFloat() < 0.2F) {
/*  70 */         self.m_8061_(EquipmentSlot.FEET, createDyedArmor(Items.f_42463_, random));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static ItemStack createDyedArmor(Item item, Random random) {
/*  76 */     ItemStack stack = new ItemStack((ItemLike)item);
/*  77 */     Item item1 = stack.m_41720_(); if (item1 instanceof DyeableLeatherItem) { DyeableLeatherItem dyeable = (DyeableLeatherItem)item1;
/*  78 */       int red = random.nextInt(256);
/*  79 */       int green = random.nextInt(256);
/*  80 */       int blue = random.nextInt(256);
/*  81 */       int color = red << 16 | green << 8 | blue;
/*  82 */       dyeable.m_41115_(stack, color); }
/*     */     
/*  84 */     return stack;
/*     */   }
/*     */   
/*     */   @Inject(method = {"tick"}, at = {@At("TAIL")})
/*     */   private void annoyingvillagers$tickVoiceCooldown(CallbackInfo ci) {
/*  89 */     Zombie self = (Zombie)this;
/*  90 */     if (self.m_6095_() != EntityType.f_20501_) {
/*     */       return;
/*     */     }
/*     */     
/*  94 */     if (this.annoyingvillagers$voiceCooldown > 0) {
/*  95 */       this.annoyingvillagers$voiceCooldown--;
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"getAmbientSound"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void annoyingvillagers$replaceAmbientSound(CallbackInfoReturnable<SoundEvent> cir) {
/* 101 */     Zombie self = (Zombie)this;
/*     */     
/* 103 */     if (self.m_6095_() != EntityType.f_20501_) {
/*     */       return;
/*     */     }
/*     */     
/* 107 */     if (this.annoyingvillagers$voiceCooldown <= 0) {
/* 108 */       this.annoyingvillagers$voiceCooldown = Mth.m_216271_(self.m_217043_(), 300, 600);
/* 109 */       cir.setReturnValue(AnnoyingVillagersModSounds.ZOMBIE_SAY.get());
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"addAdditionalSaveData"}, at = {@At("TAIL")})
/*     */   private void annoyingvillagers$saveVoiceCooldown(CompoundTag tag, CallbackInfo ci) {
/* 115 */     Zombie self = (Zombie)this;
/* 116 */     if (self.m_6095_() == EntityType.f_20501_) {
/* 117 */       tag.m_128405_("AVZombieVoiceCooldown", this.annoyingvillagers$voiceCooldown);
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"readAdditionalSaveData"}, at = {@At("TAIL")})
/*     */   private void annoyingvillagers$loadVoiceCooldown(CompoundTag tag, CallbackInfo ci) {
/* 123 */     Zombie self = (Zombie)this;
/* 124 */     if (self.m_6095_() == EntityType.f_20501_)
/* 125 */       this.annoyingvillagers$voiceCooldown = tag.m_128451_("AVZombieVoiceCooldown"); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\ZombieMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */