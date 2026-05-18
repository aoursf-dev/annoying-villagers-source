/*    */ package com.pla.annoyingvillagers.item;
/*    */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
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
/*    */ public class EnderSlayerScytheItem extends SwordItem {
/*    */   public EnderSlayerScytheItem() {
/* 23 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 25 */             return 1561;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 29 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 33 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 37 */             return 1;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 41 */             return 2;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 45 */             return Ingredient.m_43929_(new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN.get() }, );
/*    */           }
/* 47 */         },  3, -2.3F, (new Item.Properties()).m_41486_());
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6883_(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
/* 52 */     super.m_6883_(pStack, pLevel, pEntity, pSlotId, pIsSelected);
/* 53 */     if (pIsSelected && pEntity instanceof Player) { Player player = (Player)pEntity; if (pLevel instanceof ServerLevel) { ServerLevel serverLevel = (ServerLevel)pLevel;
/* 54 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 55 */         if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 56 */           SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.ENDER_SLAYER_SCYTHE);
/* 57 */           if (skillContainer != null && skillContainer.isActivated())
/* 58 */             HerobrineUtil.spawnEliteEffect((Level)serverLevel, pEntity.m_20185_(), pEntity.m_20186_(), pEntity.m_20189_(), pEntity);  }
/*    */          }
/*    */        }
/*    */   
/*    */   }
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 65 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 66 */     list.add(Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.ender_slayer_scythe").getString()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\EnderSlayerScytheItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */