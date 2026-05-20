package com.pla.annoyingvillagers.item;

import com.pla.annoyingvillagers.entity.PatrolVillagerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class PathRecorderItem extends Item {
    public PathRecorderItem(Properties p) {
        super(p);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        if (!player.getPersistentData().contains("RecordingPath")) {
            // Bắt đầu ghi
            player.getPersistentData().putBoolean("RecordingPath", true);
            player.getPersistentData().putLong("PathLastTick", level.getGameTime());
            player.getPersistentData().put("PathPoints", new ListTag());
            player.displayClientMessage(net.minecraft.network.chat.Component.literal("§aBắt đầu ghi lộ trình!"), true);
        } else {
            // Kết thúc ghi
            player.getPersistentData().remove("RecordingPath");
            ListTag points = player.getPersistentData().getList("PathPoints", 10);
            // Tìm villager đang nhìn
            PatrolVillagerEntity target = getTargetVillager(player);
            if (target != null) {
                target.setPatrolRoute(points);
                player.displayClientMessage(net.minecraft.network.chat.Component.literal("§aĐã lưu lộ trình cho villager!"), true);
            } else {
                player.displayClientMessage(net.minecraft.network.chat.Component.literal("§cKhông tìm thấy villager tuần tra trong tầm nhìn!"), true);
            }
            player.getPersistentData().remove("PathPoints");
        }
        return InteractionResultHolder.success(stack);
    }

    private PatrolVillagerEntity getTargetVillager(Player player) {
        double range = 10;
        Vec3 eye = player.getEyePosition();
        Vec3 look = player.getLookAngle();
        Vec3 end = eye.add(look.scale(range));
        AABB aabb = player.getBoundingBox().expandTowards(look.scale(range)).inflate(1);
        for (Entity e : player.level().getEntities(player, aabb)) {
            if (e instanceof PatrolVillagerEntity && e.getBoundingBox().clip(eye, end).isPresent()) {
                return (PatrolVillagerEntity) e;
            }
        }
        return null;
    }
}