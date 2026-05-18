/*    */ package com.pla.annoyingvillagers.item;
/*    */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
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
/*    */ public class ObsidianSledgehammerItem extends AxeItem {
/*    */   public ObsidianSledgehammerItem() {
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
/* 33 */             return 5.0F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 37 */             return 1;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 41 */             return 32;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 45 */             return Ingredient.m_43929_(new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN.get() }, );
/*    */           }
/* 47 */         },  1.0F, -2.6F, (new Item.Properties()).m_41486_());
/*    */   }
/*    */   
/*    */   public void m_6883_(@NotNull ItemStack itemstack, @NotNull Level level, @NotNull Entity entity, int i, boolean flag) {
/* 51 */     super.m_6883_(itemstack, level, entity, i, flag);
/* 52 */     if (flag && entity instanceof Player) { Player player = (Player)entity;
/* 53 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 54 */       if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 55 */         SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.OBSIDIAN_SLEDGEHAMMER);
/* 56 */         if (skillContainer.isActivated()) {
/* 57 */           HerobrineUtil.spawnEliteEffect(level, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
/*    */         } }
/*    */        }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 65 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 66 */     list.add(Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.obsidian_sledgehammer").getString()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\ObsidianSledgehammerItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */