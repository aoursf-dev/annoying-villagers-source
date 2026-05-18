/*    */ package com.pla.annoyingvillagers.item;
/*    */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import com.pla.annoyingvillagers.skill.EnderGlaiveSkill;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.SwordItem;
/*    */ import net.minecraft.world.item.Tier;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import yesman.epicfight.skill.SkillContainer;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
/*    */ 
/*    */ public class EnderGlaiveItem extends SwordItem {
/*    */   public EnderGlaiveItem() {
/* 25 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 27 */             return 1561;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 31 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 35 */             return 5.0F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 39 */             return 1;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 43 */             return 2;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 47 */             return Ingredient.m_43929_(new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN.get() }, );
/*    */           }
/* 49 */         },  3, -2.5F, (new Item.Properties()).m_41486_());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_7579_(@NotNull ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
/* 54 */     if (pAttacker instanceof Player) { Player player = (Player)pAttacker;
/* 55 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 56 */       if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 57 */         SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.ENDER_GLAIVE);
/* 58 */         if (skillContainer == null) return super.m_7579_(pStack, pTarget, pAttacker); 
/* 59 */         EnderGlaiveSkill enderGlaiveSkill = (EnderGlaiveSkill)skillContainer.getSkill();
/*    */         
/* 61 */         float currentResource = skillContainer.getResource();
/* 62 */         float neededResource = skillContainer.getNeededResource();
/* 63 */         float addResource = Math.min(2.0F, neededResource);
/* 64 */         enderGlaiveSkill.setConsumptionSynchronize(skillContainer, currentResource + addResource); }
/*    */        }
/*    */     
/* 67 */     return super.m_7579_(pStack, pTarget, pAttacker);
/*    */   }
/*    */   
/*    */   public void m_6883_(@NotNull ItemStack itemstack, @NotNull Level level, @NotNull Entity entity, int i, boolean flag) {
/* 71 */     super.m_6883_(itemstack, level, entity, i, flag);
/* 72 */     if (flag && entity instanceof Player) { Player player = (Player)entity;
/* 73 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 74 */       if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 75 */         SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.ENDER_GLAIVE);
/* 76 */         if (skillContainer != null && 
/* 77 */           skillContainer.getStack() >= 1) {
/* 78 */           HerobrineUtil.spawnEliteEffect(level, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
/*    */         } }
/*    */        }
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltipflag) {
/* 87 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 88 */     list.add(Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.ender_glaive").getString()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EnderGlaiveItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */