package mod.coda.thecroodaceousera.world.feature;

import com.ibm.icu.impl.Pair;
import mod.coda.thecroodaceousera.block.BranchesWallBlock;
import mod.coda.thecroodaceousera.init.CroodsBlocks;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class DesertBaobabFeature extends Feature<NoFeatureConfig>
{
    private final BlockState trunk = CroodsBlocks.DESERT_BAOBAB_LOG.get().getDefaultState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y);
    private final BlockState leaves = CroodsBlocks.DESERT_BAOBAB_WALL_BRANCHES.get().getDefaultState();
    private final BlockState leavesTop = CroodsBlocks.DESERT_BAOBAB_BRANCHES.get().getDefaultState();
    
    public static final Direction[] DIRECTIONS = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
    
    //NOTE all random values below have 1 added to them when randomizing, the values determine the maximum possible output, not number of outputs
    
    //trunk placement
    public static int minimumTrunkHeight = 5;
    public static int trunkHeightExtra = 2;
    public DesertBaobabFeature()
    {
        super(NoFeatureConfig.field_236558_a_);
    }
    
    @Override
    public boolean generate(ISeedReader iSeedReader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, NoFeatureConfig noFeatureConfig)
    {
        ArrayList<Pair<BlockPos, BlockState>> filler = new ArrayList<>();
        int trunkHeight = minimumTrunkHeight + random.nextInt(trunkHeightExtra+1);
        for (int i = 0; i < trunkHeight; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                int xOffset = j % 2;
                int zOffset = j / 2;
                BlockPos somePosIDunnoWhatToCallThisOneTBH = blockPos.add(xOffset, i, zOffset);
                if (i == 0 && !canGrowTree(iSeedReader, somePosIDunnoWhatToCallThisOneTBH))
                {
                    return false;
                }
                makeSlice(filler, trunk, somePosIDunnoWhatToCallThisOneTBH, 1);
            }
        }
        fill(iSeedReader, filler);
        return false;
    }
    
    public static void makeSlice(ArrayList<Pair<BlockPos, BlockState>> filler, BlockState state, BlockPos pos, int sliceSize)
    {
        for (int x = -sliceSize; x <= sliceSize; x++)
        {
            for (int z = -sliceSize; z <= sliceSize; z++)
            {
                if (Math.abs(x) == sliceSize && Math.abs(z) == sliceSize)
                {
                    continue;
                }
                BlockPos slicePos = new BlockPos(pos).add(x, 0, z);
                filler.add(Pair.of(slicePos, state));
            }
        }
    }
    
    public static void fill(ISeedReader reader, ArrayList<Pair<BlockPos, BlockState>> filler)
    {
        for (Pair<BlockPos, BlockState> pair : filler)
        {
            reader.setBlockState(pair.first, pair.second, 3);
        }
    }
    
    public static boolean canGrowTree(ISeedReader reader, BlockPos pos)
    {
        if (!reader.getBlockState(pos.down()).getBlock().equals(CroodsBlocks.CROODACEOUS_SAND.get()))
        {
            return false;
        }
        for (Direction direction : DIRECTIONS)
        {
            BlockPos sandPos = pos.down().offset(direction);
            if (!reader.getBlockState(sandPos).getBlock().equals(CroodsBlocks.CROODACEOUS_SAND.get()))
            {
                return false;
            }
        }
        return canPlace(reader, pos);
    }
    
    public static boolean canPlace(ISeedReader reader, BlockPos pos)
    {
        //todo implement some more proper 'is outside of world' check, mekanism has one
        if (pos.getY() > reader.getHeight() || pos.getY() < 0)
        {
            return false;
        }
        return reader.getBlockState(pos).getBlock().equals(CroodsBlocks.DESERT_BAOBAB_SAPLING.get()) || reader.isAirBlock(pos) || reader.getBlockState(pos).getMaterial().isReplaceable();
    }
}