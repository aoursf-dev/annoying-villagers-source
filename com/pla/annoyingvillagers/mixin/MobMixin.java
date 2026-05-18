/*    */ package com.pla.annoyingvillagers.mixin;
/*    */ 
/*    */ import com.pla.annoyingvillagers.util.TeamUtil;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.world.DifficultyInstance;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.Mob;
/*    */ import net.minecraft.world.entity.MobSpawnType;
/*    */ import net.minecraft.world.entity.SpawnGroupData;
/*    */ import net.minecraft.world.level.ServerLevelAccessor;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(value = {Mob.class}, remap = true)
/*    */ public class MobMixin
/*    */ {
/*    */   @Inject(method = {"finalizeSpawn"}, at = {@At("RETURN")})
/*    */   private void villagerTeamJoin(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag, CallbackInfoReturnable<SpawnGroupData> cir) {
/* 24 */     Mob self = (Mob)this;
/* 25 */     if (self instanceof net.minecraft.world.entity.animal.AbstractGolem && self.m_9236_() instanceof net.minecraft.server.level.ServerLevel)
/* 26 */       TeamUtil.addOrJoinTeam((Entity)self, "villagers"); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\mixin\MobMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */