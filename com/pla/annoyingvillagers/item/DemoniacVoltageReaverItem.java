/*    */ package com.pla.annoyingvillagers.item;
/*    */ 
/*    */ import com.pla.annoyingvillagers.gameasset.AVSkills;
/*    */ import com.pla.annoyingvillagers.init.AnnoyingVillagersModItems;
/*    */ import com.pla.annoyingvillagers.util.HerobrineUtil;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
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
/*    */ public class DemoniacVoltageReaverItem extends SwordItem {
/*    */   public DemoniacVoltageReaverItem() {
/* 26 */     super(new Tier() {
/*    */           public int m_6609_() {
/* 28 */             return 1561;
/*    */           }
/*    */           
/*    */           public float m_6624_() {
/* 32 */             return 4.0F;
/*    */           }
/*    */           
/*    */           public float m_6631_() {
/* 36 */             return 3.0F;
/*    */           }
/*    */           
/*    */           public int m_6604_() {
/* 40 */             return 1;
/*    */           }
/*    */           
/*    */           public int m_6601_() {
/* 44 */             return 4;
/*    */           }
/*    */           @NotNull
/*    */           public Ingredient m_6282_() {
/* 48 */             return Ingredient.m_43929_(new ItemLike[] { (ItemLike)AnnoyingVillagersModItems.ELITE_OBSIDIAN.get() }, );
/*    */           }
/*    */         },  3, -3.0F, new Item.Properties());
/*    */   }
/*    */   
/*    */   public void m_7373_(@NotNull ItemStack itemstack, Level level, @NotNull List<Component> list, @NotNull TooltipFlag tooltipflag) {
/* 54 */     super.m_7373_(itemstack, level, list, tooltipflag);
/* 55 */     list.add(Component.m_237113_(Component.m_237115_("tooltip.annoyingvillagers.demoniac_voltage_reaver").getString()));
/*    */   }
/*    */   
/*    */   public void m_6883_(@NotNull ItemStack itemstack, @NotNull Level level, @NotNull Entity entity, int i, boolean flag) {
/* 59 */     super.m_6883_(itemstack, level, entity, i, flag);
/* 60 */     if (flag && entity instanceof Player) { Player player = (Player)entity;
/* 61 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 62 */       if (playerPatch instanceof ServerPlayerPatch) { ServerPlayerPatch serverPlayerPatch = (ServerPlayerPatch)playerPatch;
/* 63 */         SkillContainer skillContainer = serverPlayerPatch.getSkill(AVSkills.DEMONIAC_VOLTAGE_REAVER);
/* 64 */         if (skillContainer != null) {
/* 65 */           if (skillContainer.getStack() >= 1) {
/* 66 */             HerobrineUtil.spawnEliteEffect(level, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
/* 67 */             if (itemstack.m_41783_() != null && !itemstack.m_41783_().m_128471_("SecondForm")) {
/* 68 */               itemstack.m_41783_().m_128379_("SecondForm", true);
/*    */             }
/* 70 */           } else if (skillContainer.getStack() < 1 && itemstack.m_41783_() != null && itemstack.m_41783_().m_128471_("SecondForm")) {
/* 71 */             itemstack.m_41783_().m_128473_("SecondForm");
/*    */           } 
/*    */         } }
/*    */        }
/*    */     
/* 76 */     if (!flag && itemstack.m_41783_().m_128471_("SnakeAnimation"))
/* 77 */       itemstack.m_41783_().m_128473_("SnakeAnimation"); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Aours\AppData\Roaming\PrismLauncher\instances\1.20.1 remake\minecraft\mods\AnnoyingVillagers-1.20.1-1.4.5.jar!\com\pla\annoyingvillagers\item\DemoniacVoltageReaverItem.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */