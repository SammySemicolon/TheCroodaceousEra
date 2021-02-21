package mod.coda.croodaceouscraft.world.feature;

import mod.coda.croodaceouscraft.init.CroodsBlocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class RockFormationFeature extends Feature<NoFeatureConfig> {
    public RockFormationFeature() {
        super(NoFeatureConfig.field_236558_a_);
    }

    @Override
    public boolean generate(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random random, BlockPos pos, NoFeatureConfig config) {
        if (seedReader.getBlockState(pos.down()).getBlock() == CroodsBlocks.CROODACEOUS_SAND.get()) {
            int height = 3 + random.nextInt(1);
            int size = 3 + random.nextInt(4);
            Direction offsetDir = null;
            pos = pos.down(size / 2);
            for (int i = 0; i < height; i++) {
                if (offsetDir == null && random.nextInt(i + 2) == 0) offsetDir = Direction.Plane.HORIZONTAL.random(random);
                if (offsetDir != null) pos = pos.offset(offsetDir);
                int end = random.nextInt(1) + 2;
                for (int j = 0; j <= size; j++) {
                    if (i == height - 1) break;
                    double remove = end + Math.sin(j * (Math.PI / size)) * 2;
                    for (int k = -5; k <= 5; k++) {
                        for (int m = -5; m <= 5; m++) {
                            if (k * k + m * m <= remove * remove)
                                if (MathHelper.abs(k) < 4 && MathHelper.abs(m) < 4) seedReader.setBlockState(pos.add(k, j, m), CroodsBlocks.CROODACEOUS_STONE.get().getDefaultState(), 2);
                        }
                    }
                }
                pos = pos.up(size);
            }
            return true;
        }
        return false;
    }
}
