/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import com.pla.annoyingvillagers.util.CommonGoals;
/*    */ import com.pla.annoyingvillagers.util.TeamUtil;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.world.DifficultyInstance;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.MobSpawnType;
/*    */ import net.minecraft.world.entity.SpawnGroupData;
/*    */ import net.minecraft.world.entity.monster.AbstractSkeleton;
/*    */ import net.minecraft.world.entity.monster.Monster;
/*    */ import net.minecraft.world.level.ServerLevelAccessor;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin(value = {AbstractSkeleton.class}, remap = true)
/*    */ public class SkeletonMixin {
/*    */   @Inject(method = {"registerGoals"}, at = {@At("HEAD")})
/*    */   private void monsterTargetNpc(CallbackInfo ci) {
/* 25 */     AbstractSkeleton self = (AbstractSkeleton)this;
/* 26 */     if (!(self instanceof net.minecraft.world.entity.monster.WitherSkeleton)) {
/* 27 */       CommonGoals.registerGoalForHostileNpc((Monster)self);
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"finalizeSpawn"}, at = {@At("RETURN")})
/*    */   private void monsterJoinHerobrineTeam(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag, CallbackInfoReturnable<SpawnGroupData> cir) {
/* 33 */     AbstractSkeleton self = (AbstractSkeleton)this;
/* 34 */     if (!self.m_9236_().m_5776_() && self.m_20194_() != null) {
/* 35 */       TeamUtil.addOrJoinTeam((Entity)self, "herobrine");
/*    */       try {
/* 37 */         self.m_20194_().m_129892_().m_82094_().execute("data merge entity @s {CanPickUpLoot: 1b}", self
/*    */             
/* 39 */             .m_20203_().m_81324_().m_81325_(4));
/* 40 */       } catch (CommandSyntaxException commandSyntaxException) {}
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\SkeletonMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */