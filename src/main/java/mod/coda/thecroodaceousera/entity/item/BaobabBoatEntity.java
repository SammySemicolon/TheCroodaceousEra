package mod.coda.thecroodaceousera.entity.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.world.World;

public class BaobabBoatEntity extends BoatEntity {

    public BaobabBoatEntity(EntityType<? extends BaobabBoatEntity> type, World world) {
        super(type, world);
        this.preventEntitySpawning = true;
    }

   /* public BaobabBoatEntity(World worldIn, double x, double y, double z) {
        this(CroodsEntities.BAOBAB_BOAT.get(), worldIn);
        this.setPosition(x, y, z);
        this.setMotion(Vector3d.ZERO);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    public Item getItemBoat() {
        return CroodsItems.BAOBAB_BOAT_ITEM.get();
    }

    protected void readAdditional(CompoundNBT compound) {
        if (compound.contains("Type", 8)) {
            this.setBoatType(BoatEntity.Type.getTypeFromString(compound.getString("Type")));
        }
    }

    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        this.lastYd = this.getMotion().y;
        if (!this.isPassenger()) {
            if (onGroundIn) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != BaobabBoatEntity.Status.ON_LAND) {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.onLivingFall(this.fallDistance, 1.0F);
                    if (!this.world.isRemote && !this.removed) {
                        this.remove();
                        if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            for(int i = 0; i < 3; ++i) {
                                this.entityDropItem(this.getBoatType().asPlank());
                            }

                            for(int j = 0; j < 2; ++j) {
                                this.entityDropItem(Items.STICK);
                            }
                        }
                    }
                }

                this.fallDistance = 0.0F;
            } else if (!this.world.getFluidState(this.getPosition().down()).isTagged(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance = (float)((double)this.fallDistance - y);
            }

        }
    }*/
}
