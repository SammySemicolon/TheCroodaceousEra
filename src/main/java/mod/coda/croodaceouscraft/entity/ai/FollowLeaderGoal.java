package mod.coda.croodaceouscraft.entity.ai;

import mod.coda.croodaceouscraft.entity.LiyoteEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class FollowLeaderGoal extends Goal {
    private final LiyoteEntity taskOwner;
    private int navigateTimer;
    private int cooldown;

    public FollowLeaderGoal(LiyoteEntity taskOwnerIn) {
        this.taskOwner = taskOwnerIn;
        this.cooldown = this.getNewCooldown(taskOwnerIn);
    }

    protected int getNewCooldown(LiyoteEntity taskOwnerIn) {
        return 200 + taskOwnerIn.getRNG().nextInt(200) % 20;
    }

    public boolean shouldExecute() {
        if (this.taskOwner.isGroupLeader()) {
            return false;
        } else if (this.taskOwner.hasGroupLeader()) {
            return true;
        } else if (this.cooldown > 0) {
            --this.cooldown;
            return false;
        } else {
            this.cooldown = this.getNewCooldown(this.taskOwner);
            Predicate<LiyoteEntity> predicate = (liyote) -> {
                return liyote.canGroupGrow() || !liyote.hasGroupLeader();
            };
            List<LiyoteEntity> list = this.taskOwner.world.getEntitiesWithinAABB(this.taskOwner.getClass(), this.taskOwner.getBoundingBox().grow(8.0D, 8.0D, 8.0D), predicate);
            LiyoteEntity liyoteEntity = list.stream().filter(LiyoteEntity::canGroupGrow).findAny().orElse(this.taskOwner);
            liyoteEntity.func_212810_a(list.stream().filter((liyote) -> {
                return !liyote.hasGroupLeader();
            }));
            return this.taskOwner.hasGroupLeader();
        }
    }

    public boolean shouldContinueExecuting() {
        return this.taskOwner.hasGroupLeader() && this.taskOwner.inRangeOfGroupLeader();
    }

    public void startExecuting() {
        this.navigateTimer = 0;
    }

    public void resetTask() {
        this.taskOwner.leaveGroup();
    }

    public void tick() {
        if (--this.navigateTimer <= 0) {
            this.navigateTimer = 10;
            this.taskOwner.moveToGroupLeader();
        }
    }
}
