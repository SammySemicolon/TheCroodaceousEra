package mod.coda.croodaceouscraft.entity;

import mod.coda.croodaceouscraft.entity.ai.FollowLeaderGoal;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class LiyoteEntity extends CreatureEntity {
//    private static final DataParameter<Byte> LIYOTE_FLAGS = EntityDataManager.createKey(LiyoteEntity.class, DataSerializers.BYTE);
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(LiyoteEntity.class, DataSerializers.VARINT);
    private LiyoteEntity groupLeader;
    private int groupSize = 8;

    public LiyoteEntity(EntityType<? extends LiyoteEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
//        this.goalSelector.addGoal(2, new LiyoteEntity.SleepGoal());
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowLeaderGoal(this));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));

    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.25F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WOLF_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }

    protected boolean func_212800_dy() {
        return !this.hasGroupLeader();
    }

    public boolean hasGroupLeader() {
        return this.groupLeader != null && this.groupLeader.isAlive();
    }

    public LiyoteEntity func_212803_a(LiyoteEntity groupLeaderIn) {
        this.groupLeader = groupLeaderIn;
        groupLeaderIn.increaseGroupSize();
        return groupLeaderIn;
    }

    public void leaveGroup() {
        this.groupLeader.decreaseGroupSize();
        this.groupLeader = null;
    }

    private void increaseGroupSize() {
        ++this.groupSize;
    }

    private void decreaseGroupSize() {
        --this.groupSize;
    }

    public boolean canGroupGrow() {
        return this.isGroupLeader() && this.groupSize < this.getMaxGroupSize();
    }

    public void tick() {
        super.tick();
        if (this.isGroupLeader() && this.world.rand.nextInt(200) == 1) {
            List<LiyoteEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
            if (list.size() <= 1) {
                this.groupSize = 1;
            }
        }
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
    }

    public int getVariant() {
        return this.dataManager.get(VARIANT);
    }

    private void setVariant(int variant) {
        this.dataManager.set(VARIANT, variant);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Variant", getVariant());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        setVariant(compound.getInt("Variant"));
    }


//    @Override
//    public void livingTick() {
//        super.livingTick();
//        if (this.isSitting() || this.isMovementBlocked()) {
//            this.isJumping = false;
//            this.moveStrafing = 0.0F;
//            this.moveForward = 0.0F;
//        }
//    }

//    public void writeAdditional(CompoundNBT compound) {
//        super.writeAdditional(compound);
//
//        compound.putBoolean("Sitting", this.isSitting());
//    }

//    public void readAdditional(CompoundNBT compound) {
//        super.readAdditional(compound);
//
//        this.setSitting(compound.getBoolean("Sitting"));
//    }

//    public boolean isSitting() {
//        return this.getLiyoteFlag(32);
//    }

//    private void setSitting(boolean p_213485_1_) {
//        this.setLiyoteFlag(32, p_213485_1_);
//    }

//    private void setLiyoteFlag(int p_213505_1_, boolean p_213505_2_) {
//        if (p_213505_2_) {
//            this.dataManager.set(LIYOTE_FLAGS, (byte)(this.dataManager.get(LIYOTE_FLAGS) | p_213505_1_));
//        } else {
//            this.dataManager.set(LIYOTE_FLAGS, (byte)(this.dataManager.get(LIYOTE_FLAGS) & ~p_213505_1_));
//        }
//    }

//    private boolean getLiyoteFlag(int p_213507_1_) {
//        return (this.dataManager.get(LIYOTE_FLAGS) & p_213507_1_) != 0;
//    }

//    private void func_213454_em() {
//        this.setSitting(false);
//    }

//    private void func_213499_en() {
//        this.setSitting(false);
//    }

//    private boolean func_213478_eo() {
//        return !this.isSitting();
//    }

    public boolean isGroupLeader() {
        return this.groupSize > 1;
    }

    public boolean inRangeOfGroupLeader() {
        return this.getDistanceSq(this.groupLeader) <= 121.0D;
    }

    public void moveToGroupLeader() {
        if (this.hasGroupLeader()) {
            this.getNavigator().tryMoveToEntityLiving(this.groupLeader, 1.0D);
        }
    }

    public int getMaxGroupSize() {
        return groupSize;
    }

    public void func_212810_a(Stream<LiyoteEntity> p_212810_1_) {
        p_212810_1_.limit((long)(this.getMaxGroupSize() - this.groupSize)).filter((p_212801_1_) -> {
            return p_212801_1_ != this;
        }).forEach((p_212804_1_) -> {
            p_212804_1_.func_212803_a(this);
        });
    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        if (spawnDataIn == null) {
            spawnDataIn = new LiyoteEntity.GroupData(this);
            if (rand.nextDouble() > 0.9) setVariant(1);
            else {
                setVariant(0);
            }
        }
        else {
            this.func_212803_a(((LiyoteEntity.GroupData)spawnDataIn).groupLeader);
        }

        return spawnDataIn;
    }

    public static class GroupData implements ILivingEntityData {
        public final LiyoteEntity groupLeader;

        public GroupData(LiyoteEntity groupLeaderIn) {
            this.groupLeader = groupLeaderIn;
        }
    }

//    class SleepGoal extends Goal {
//        private int field_220825_c = LiyoteEntity.this.rand.nextInt(140);
//
//        public SleepGoal() {
//            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
//        }
//
//        public boolean shouldExecute() {
//            if (LiyoteEntity.this.moveStrafing == 0.0F && LiyoteEntity.this.moveVertical == 0.0F && LiyoteEntity.this.moveForward == 0.0F) {
//                return this.func_220823_j() || LiyoteEntity.this.isSitting();
//            } else {
//                return false;
//            }
//        }
//
//        public boolean shouldContinueExecuting() {
//            return this.func_220823_j();
//        }
//
//        private boolean func_220823_j() {
//            if (this.field_220825_c > 0) {
//                --this.field_220825_c;
//                return false;
//            } else {
//                return LiyoteEntity.this.world.isDaytime() && this.func_220813_g();
//            }
//        }
//
//        protected boolean func_220813_g() {
//            BlockPos blockpos = new BlockPos(LiyoteEntity.this.getPosX(), LiyoteEntity.this.getBoundingBox().maxY, LiyoteEntity.this.getPosZ());
//            return LiyoteEntity.this.world.canSeeSky(blockpos) && LiyoteEntity.this.getBlockPathWeight(blockpos) >= 0.0F;
//        }
//
//        public void resetTask() {
//            this.field_220825_c = LiyoteEntity.this.rand.nextInt(140);
//            LiyoteEntity.this.func_213499_en();
//        }
//
//        public void startExecuting() {
//            LiyoteEntity.this.setJumping(false);
//            LiyoteEntity.this.setSitting(true);
//            LiyoteEntity.this.getNavigator().clearPath();
//            LiyoteEntity.this.getMoveHelper().setMoveTo(LiyoteEntity.this.getPosX(), LiyoteEntity.this.getPosY(), LiyoteEntity.this.getPosZ(), 0.0D);
//        }
//    }
}
