package mod.coda.croodaceouscraft.entity;

import mod.coda.croodaceouscraft.init.CroodsEntities;
import mod.coda.croodaceouscraft.init.CroodsItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.UUID;
import java.util.function.Predicate;

public class BearOwlEntity extends AnimalEntity implements IAngerable {
    private static final RangedInteger field_234286_bz_ = TickRangeConverter.convertRange(20, 39);
    private UUID angerTarget;
    private int angerTime;
    private int targetChangeTime;

    public BearOwlEntity(EntityType<? extends BearOwlEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BearOwlEntity.StareGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 40));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(6, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false, false));
        this.targetSelector.addGoal(1, new BearOwlEntity.FindPlayerGoal(this, this::func_233680_b_));

    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 60.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.26D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 1024).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.8);
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

    protected float getSoundVolume() {
        return 0.4F;
    }

    public BearOwlEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return CroodsEntities.BEAR_OWL.get().create(p_241840_1_);
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();
            if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.7F;
    }

    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        return item.isFood() && item.getFood().isMeat();
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(CroodsItems.BEAR_OWL_SPAWN_EGG.get());
    }

    private boolean shouldAttackPlayer(PlayerEntity player) {
        Vector3d vector3d = player.getLook(1.0F).normalize();
        Vector3d vector3d1 = new Vector3d(this.getPosX() - player.getPosX(), this.getPosYEye() - player.getPosYEye(), this.getPosZ() - player.getPosZ());
        double d0 = vector3d1.length();
        vector3d1 = vector3d1.normalize();
        double d1 = vector3d.dotProduct(vector3d1);
        return d1 > 1.0D - 0.025D / d0 && player.canEntityBeSeen(this);
    }

    public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
        ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (entitylivingbaseIn == null) {
            this.targetChangeTime = 0;
        } else {
            this.targetChangeTime = this.ticksExisted;
        }

        super.setAttackTarget(entitylivingbaseIn);
    }

    protected void updateAITasks() {
        if (this.world.isDaytime() && this.ticksExisted >= this.targetChangeTime + 600) {
            float f = this.getBrightness();
            if (f > 0.5F && this.world.canSeeSky(this.getPosition()) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
                this.setAttackTarget((LivingEntity)null);
            }
        }

        super.updateAITasks();
    }

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setAngerTime(int time) {
        this.setAngerTime(field_234286_bz_.getRandomWithinRange(this.rand));
    }

    @Nullable
    @Override
    public UUID getAngerTarget() {
        return this.angerTarget;
    }


    public void setAngerTarget(@Nullable UUID target) {
        this.angerTarget = target;
    }

    @Override
    public void func_230258_H__() {
        this.setAngerTime(field_234286_bz_.getRandomWithinRange(this.rand));
    }

    static class StareGoal extends Goal {
        private final BearOwlEntity bearowl;
        private LivingEntity targetPlayer;

        public StareGoal(BearOwlEntity bearowlIn) {
            this.bearowl = bearowlIn;
            this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        public boolean shouldExecute() {
            this.targetPlayer = this.bearowl.getAttackTarget();
            if (!(this.targetPlayer instanceof PlayerEntity)) {
                return false;
            } else {
                double d0 = this.targetPlayer.getDistanceSq(this.bearowl);
                return !(d0 > 256.0D) && this.bearowl.shouldAttackPlayer((PlayerEntity) this.targetPlayer);
            }
        }

        public void startExecuting() {
            this.bearowl.getNavigator().clearPath();
        }

        public void tick() {
            this.bearowl.getLookController().setLookPosition(this.targetPlayer.getPosX(), this.targetPlayer.getPosYEye(), this.targetPlayer.getPosZ());
        }
    }

    static class FindPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        private final BearOwlEntity bearowl;
        private PlayerEntity player;
        private int aggroTime;
        private final EntityPredicate field_220791_m;
        private final EntityPredicate field_220792_n = (new EntityPredicate()).setLineOfSiteRequired();

        public FindPlayerGoal(BearOwlEntity p_i241912_1_, @Nullable Predicate<LivingEntity> p_i241912_2_) {
            super(p_i241912_1_, PlayerEntity.class, 10, false, false, p_i241912_2_);
            this.bearowl = p_i241912_1_;
            this.field_220791_m = (new EntityPredicate()).setDistance(this.getTargetDistance()).setCustomPredicate((p_220790_1_) -> {
                return p_i241912_1_.shouldAttackPlayer((PlayerEntity)p_220790_1_);
            });
        }

        public boolean shouldExecute() {
            this.player = this.bearowl.world.getClosestPlayer(this.field_220791_m, this.bearowl);
            return this.player != null;
        }

        public void startExecuting() {
            this.aggroTime = 100;
        }

        public void resetTask() {
            this.player = null;
            super.resetTask();
        }

        public boolean shouldContinueExecuting() {
            if (this.player != null) {
                if (!this.bearowl.shouldAttackPlayer(this.player)) {
                    return false;
                } else {
                    this.bearowl.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.nearestTarget != null && this.field_220792_n.canTarget(this.bearowl, this.nearestTarget) || super.shouldContinueExecuting();
            }
        }

        public void tick() {
            if (this.bearowl.getAttackTarget() == null) {
                super.setNearestTarget((LivingEntity)null);
            }

            if (this.player != null) {
                if (--this.aggroTime <= 0) {
                    this.nearestTarget = this.player;
                    this.player = null;
                    super.startExecuting();
                }
            }
            super.tick();
        }
    }
}
