package com.pla.annoyingvillagers.entity.goal;

import com.pla.annoyingvillagers.entity.PatrolVillagerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.ai.goal.Goal;
import java.util.ArrayList;
import java.util.List;

public class PatrolRouteGoal extends Goal {
    private final PatrolVillagerEntity villager;
    private List<BlockPos> waypoints = new ArrayList<>();
    private int currentIndex = 0;
    private int waitTicks = 0;

    public PatrolRouteGoal(PatrolVillagerEntity villager) {
        this.villager = villager;
        loadWaypoints();
    }

    private void loadWaypoints() {
        waypoints.clear();
        ListTag list = villager.getPatrolRoute();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                CompoundTag tag = list.getCompound(i);
                int x = tag.getInt("X");
                int y = tag.getInt("Y");
                int z = tag.getInt("Z");
                waypoints.add(new BlockPos(x, y, z));
            }
        }
        currentIndex = 0;
        waitTicks = 0;
    }

    @Override
    public boolean canUse() {
        return !villager.isPanicking() && !villager.isInCombat() && waypoints.size() > 1;
    }

    @Override
    public void tick() {
        if (waitTicks > 0) {
            waitTicks--;
            return;
        }
        if (waypoints.isEmpty()) return;

        BlockPos target = waypoints.get(currentIndex);
        double distanceSq = villager.blockPosition().distSqr(target);

        if (distanceSq < 4.0) {
            waitTicks = 20; // dừng 1 giây
            currentIndex = (currentIndex + 1) % waypoints.size();
            villager.getNavigation().stop();
        } else {
            villager.getNavigation().moveTo(target.getX(), target.getY(), target.getZ(), 1.0);
        }
    }
}