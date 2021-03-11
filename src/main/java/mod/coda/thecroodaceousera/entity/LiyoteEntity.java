package mod.coda.thecroodaceousera.entity;

import mod.coda.thecroodaceousera.init.CroodsItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class LiyoteEntity extends TameableEntity {
    private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(LiyoteEntity.class, DataSerializers.VARINT);
    private static final Predicate<ItemEntity> TRUSTED_TARGET_SELECTOR = (p_213489_0_) -> {
        return !p_213489_0_.cannotPickup() && p_213489_0_.isAlive();
    };
    private int groupSize = 8;
    private float interestedAngle;

    public LiyoteEntity(EntityType<? extends LiyoteEntity> type, World worldIn) {
        super(type, worldIn);
        this.setCanPickUpLoot(true);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new SitGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PlayerEntity.class, 10.0F, 1.8D, 1.6D, EntityPredicates.NOT_SPECTATING::test));
        this.goalSelector.addGoal(4, new LiyoteEntity.FindItemsGoal());
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
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

    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(16.0D);
            this.setHealth(16.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0D);
        }
    }

    @Override
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        Item item = stack.getItem();
        if (item == CroodsItems.RAMU_EGG.get() && !this.isTamed()) {
            if (!player.abilities.isCreativeMode) {
                stack.shrink(1);
            }
            if (!ForgeEventFactory.onAnimalTame(this, player)) {
                this.setTamedBy(player);
                this.navigator.clearPath();
                this.func_233687_w_(true);
                this.world.setEntityState(this, (byte) 7);
            } else {
                this.world.setEntityState(this, (byte) 6);
            }
            return ActionResultType.SUCCESS;
        }

        if (this.isOwner(player)) {
            func_233687_w_(!isEntitySleeping());
            this.isJumping = false;
            this.navigator.clearPath();
            }
        return super.func_230254_b_(player, hand);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 45) {
            ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (!itemstack.isEmpty()) {
                for(int i = 0; i < 8; ++i) {
                    Vector3d vector3d = (new Vector3d(((double)this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).rotatePitch(-this.rotationPitch * ((float)Math.PI / 180F)).rotateYaw(-this.rotationYaw * ((float)Math.PI / 180F));
                    this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, itemstack), this.getPosX() + this.getLookVec().x / 2.0D, this.getPosY(), this.getPosZ() + this.getLookVec().z / 2.0D, vector3d.x, vector3d.y + 0.05D, vector3d.z);
                }
            }
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
    }

    public boolean canPickUpItem(ItemStack itemstackIn) {
        EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstackIn);
        if (!this.getItemStackFromSlot(equipmentslottype).isEmpty() && this.isTamed()) {
            return false;
        } else {
            return equipmentslottype == EquipmentSlotType.MAINHAND && super.canPickUpItem(itemstackIn);
        }
    }

    public boolean canEquipItem(ItemStack stack) {
        Item item = stack.getItem();
        ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
        return itemstack.isEmpty();
    }

    private void spitOutItem(ItemStack stackIn) {
        if (!stackIn.isEmpty() && !this.world.isRemote) {
            ItemEntity itementity = new ItemEntity(this.world, this.getPosX() + this.getLookVec().x, this.getPosY() + 1.0D, this.getPosZ() + this.getLookVec().z, stackIn);
            itementity.setPickupDelay(40);
            itementity.setThrowerId(this.getUniqueID());
            this.playSound(SoundEvents.ENTITY_FOX_SPIT, 1.0F, 1.0F);
            this.world.addEntity(itementity);
        }
        else if (!stackIn.isEmpty() && !this.world.isRemote && this.getAttackingEntity() instanceof PlayerEntity) { //TODO
            ItemEntity itementity = new ItemEntity(this.world, this.getPosX() + this.getLookVec().x, this.getPosY() + 1.0D, this.getPosZ() + this.getLookVec().z, stackIn);
            itementity.setPickupDelay(40);
            itementity.setThrowerId(this.getUniqueID());
            this.playSound(SoundEvents.ENTITY_FOX_SPIT, 1.0F, 1.0F);
            this.world.addEntity(itementity);
        }
    }

    private void spawnItem(ItemStack stackIn) {
        ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), stackIn);
        this.world.addEntity(itementity);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(CroodsItems.LIYOTE_SPAWN_EGG.get());
    }

    protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
        ItemStack itemstack = itemEntity.getItem();
        if (this.canEquipItem(itemstack)) {
            int i = itemstack.getCount();
            if (i > 1) {
                this.spawnItem(itemstack.split(i - 1));
            }

            this.spitOutItem(this.getItemStackFromSlot(EquipmentSlotType.MAINHAND));
            this.triggerItemPickupTrigger(itemEntity);
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack.split(1));
            this.inventoryHandsDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
            this.onItemPickup(itemEntity, itemstack.getCount());
            itemEntity.remove();
        }

    }

    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        if (spawnDataIn == null) {
            if (rand.nextDouble() > 0.95) setVariant(1);
            else {
                setVariant(0);
            }
        }

        return spawnDataIn;
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }


    class FindItemsGoal extends Goal {
        public FindItemsGoal() {
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean shouldExecute() {
            if (!LiyoteEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
                return false;
            }
            else if (LiyoteEntity.this.getAttackTarget() == null && LiyoteEntity.this.getRevengeTarget() == null && !LiyoteEntity.this.isTamed()) {
                if (LiyoteEntity.this.getRNG().nextInt(10) != 0) {
                    return false;
                } else {
                    List<ItemEntity> list = LiyoteEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, LiyoteEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), LiyoteEntity.TRUSTED_TARGET_SELECTOR);
                    return !list.isEmpty() && LiyoteEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
                }
            } else {
                return false;
            }
        }

        public void tick() {
            List<ItemEntity> list = LiyoteEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, LiyoteEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), LiyoteEntity.TRUSTED_TARGET_SELECTOR);
            ItemStack itemstack = LiyoteEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (itemstack.isEmpty() && !list.isEmpty()) {
                LiyoteEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
            }

        }

        public void startExecuting() {
            List<ItemEntity> list = LiyoteEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, LiyoteEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), LiyoteEntity.TRUSTED_TARGET_SELECTOR);
            if (!list.isEmpty()) {
                LiyoteEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
            }

        }
    }
}
