package mod.coda.croodaceouscraft.world.feature;

import mod.coda.croodaceouscraft.init.CroodsBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class DesertBaobabFeature extends Feature<NoFeatureConfig> {
    private final BlockState trunk = CroodsBlocks.DESERT_BAOBAB_LOG.get().getDefaultState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y);
    private final BlockState leaves = CroodsBlocks.DESERT_BAOBAB_WALL_BRANCHES.get().getDefaultState().with(AbstractCoralPlantBlock.WATERLOGGED, false);
    private final BlockState leavesTop = CroodsBlocks.DESERT_BAOBAB_BRANCHES.get().getDefaultState().with(AbstractCoralPlantBlock.WATERLOGGED, false);

    public DesertBaobabFeature() {
        super(NoFeatureConfig.field_236558_a_);
    }

    @Override
    public boolean generate(ISeedReader iSeedReader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, NoFeatureConfig noFeatureConfig) {
        if (iSeedReader.getBlockState(blockPos.down()).getBlock() == CroodsBlocks.CROODACEOUS_SAND.get() && iSeedReader.getBlockState(blockPos.down().south()).getBlock() == CroodsBlocks.CROODACEOUS_SAND.get() && iSeedReader.getBlockState(blockPos.down().west()).getBlock() == CroodsBlocks.CROODACEOUS_SAND.get() && iSeedReader.getBlockState(blockPos.down().south().west()).getBlock() == CroodsBlocks.CROODACEOUS_SAND.get()
        ) {
            for (int i = 0; i < 7; i++) {
                setBlockState(iSeedReader, blockPos.up(i), trunk);
                setBlockState(iSeedReader, blockPos.add(1, i, 0), trunk);
                setBlockState(iSeedReader, blockPos.add(0, i, 1), trunk);
                setBlockState(iSeedReader, blockPos.add(1, i, 1), trunk);
                if (i > 0 && i <= 4) {
                    addLeavesSide(iSeedReader, blockPos.up(i), direction -> trunk);
                }
            }

            addLeaves(iSeedReader, blockPos.add(-2, 5, 0));
            addLeaves(iSeedReader, blockPos.add(1, 5, -2));
            addLeaves(iSeedReader, blockPos.add(3, 5, 1));
            addLeaves(iSeedReader, blockPos.add(0, 5, 3));

            addLeavesSide(iSeedReader, blockPos.up(6), direction -> leaves.with(CoralWallFanBlock.FACING, direction));

            setBlockState(iSeedReader, blockPos.add(1, 7, 0), leavesTop);
            setBlockState(iSeedReader, blockPos.add(1, 7, 1), leavesTop);
            setBlockState(iSeedReader, blockPos.add(0, 7, 1), leavesTop);
            setBlockState(iSeedReader, blockPos.add(0, 7, 0), leavesTop);
            return true;
        }
        return false;
    }

    public void addLeavesSide(IWorldWriter world, BlockPos pos, Function<Direction, BlockState> directionSetter) {
        setBlockState(world, pos.add(2, 0, 0), directionSetter.apply(Direction.EAST));
        setBlockState(world, pos.add(2, 0, 1), directionSetter.apply(Direction.EAST));
        setBlockState(world, pos.add(-1, 0, 0), directionSetter.apply(Direction.WEST));
        setBlockState(world, pos.add(-1, 0, 1), directionSetter.apply(Direction.WEST));
        setBlockState(world, pos.add(0, 0, 2), directionSetter.apply(Direction.SOUTH));
        setBlockState(world, pos.add(1, 0, 2), directionSetter.apply(Direction.SOUTH));
        setBlockState(world, pos.add(0, 0, -1), directionSetter.apply(Direction.NORTH));
        setBlockState(world, pos.add(1, 0, -1), directionSetter.apply(Direction.NORTH));
    }

    public void addLeaves(IWorldWriter world, BlockPos pos) {
        setBlockState(world, pos, trunk);
        setBlockState(world, pos.up(), leavesTop);

        for (int i = 0; i <= 4; i++) {
            Direction direction = Direction.byHorizontalIndex(i);
            setBlockState(world, pos.offset(direction), leaves.with(CoralWallFanBlock.FACING, direction));
        }
    }
}
