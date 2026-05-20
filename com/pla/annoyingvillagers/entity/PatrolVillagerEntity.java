package com.pla.annoyingvillagers.entity;

import com.pla.annoyingvillagers.entity.goal.PatrolRouteGoal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class PatrolVillagerEntity extends BlueVillagerGeneralEntity {
    private PatrolRouteGoal patrolGoal;

    public PatrolVillagerEntity(EntityType<? extends PatrolVillagerEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // Không thêm goal ngay, sẽ thêm sau khi có dữ liệu
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        updatePatrolGoal();
    }

    public void updatePatrolGoal() {
        if (patrolGoal != null) {
            this.goalSelector.removeGoal(patrolGoal);
        }
        patrolGoal = new PatrolRouteGoal(this);
        this.goalSelector.addGoal(5, patrolGoal);
    }

    public ListTag getPatrolRoute() {
        return this.getPersistentData().getList("PatrolRoute", 10);
    }

    public void setPatrolRoute(ListTag route) {
        this.getPersistentData().put("PatrolRoute", route);
        updatePatrolGoal();
    }
}