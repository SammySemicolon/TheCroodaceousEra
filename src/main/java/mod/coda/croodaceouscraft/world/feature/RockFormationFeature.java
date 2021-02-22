package mod.coda.croodaceouscraft.world.feature;

import mod.coda.croodaceouscraft.init.CroodsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

/*    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        while(reader.isAirBlock(pos) && pos.getY() > 2) {
            pos = pos.down();
        }

        if (!reader.getBlockState(pos).isIn(Blocks.TERRACOTTA)) {
            return false;
        } else {
            pos = pos.up(rand.nextInt(4));
            int i = rand.nextInt(4) + 7;
            int j = i / 4 + rand.nextInt(2);
            if (j > 1) {
                pos = pos.up(10 + rand.nextInt(30));
            }

            for(int k = 0; k < i; ++k) {
                float f = (1.0F - (float)k / (float)i) * (float)j;
                int l = MathHelper.ceil(f);

                for(int i1 = -l; i1 <= l; ++i1) {
                    float f1 = (float)MathHelper.abs(i1) - 0.25F;

                    for(int j1 = -l; j1 <= l; ++j1) {
                        float f2 = (float)MathHelper.abs(j1) - 0.25F;
                        if ((i1 == 0 && j1 == 0 || !(f1 * f1 + f2 * f2 > f * f)) && (i1 != -l && i1 != l && j1 != -l && j1 != l || !(rand.nextFloat() > 0.75F))) {
                            BlockState blockstate = reader.getBlockState(pos.add(i1, k, j1));
                            Block block = blockstate.getBlock();
                            if (blockstate.isAir(reader, pos.add(i1, k, j1)) || isDirt(block) || block == Blocks.TERRACOTTA) {
                                this.setBlockState(reader, pos.add(i1, k, j1), CroodsBlocks.CROODACEOUS_STONE.get().getDefaultState());
                            }

                            if (k != 0 && l > 1) {
                                blockstate = reader.getBlockState(pos.add(i1, -k, j1));
                                block = blockstate.getBlock();
                                if (blockstate.isAir(reader, pos.add(i1, -k, j1)) || isDirt(block) || block == Blocks.TERRACOTTA) {
                                    this.setBlockState(reader, pos.add(i1, -k, j1), CroodsBlocks.CROODACEOUS_STONE.get().getDefaultState());
                                }
                            }
                        }
                    }
                }
            }

            int k1 = j - 1;
            if (k1 < 0) {
                k1 = 0;
            } else if (k1 > 1) {
                k1 = 1;
            }

            for(int l1 = -k1; l1 <= k1; ++l1) {
                for(int i2 = -k1; i2 <= k1; ++i2) {
                    BlockPos blockpos = pos.add(l1, -1, i2);
                    int j2 = 50;
                    if (Math.abs(l1) == 1 && Math.abs(i2) == 1) {
                        j2 = rand.nextInt(5);
                    }

                    while(blockpos.getY() > 50) {
                        BlockState blockstate1 = reader.getBlockState(blockpos);
                        Block block1 = blockstate1.getBlock();
                        if (!blockstate1.isAir(reader, blockpos) && !isDirt(block1) && block1 != Blocks.TERRACOTTA && block1 != CroodsBlocks.CROODACEOUS_STONE.get()) {
                            break;
                        }

                        this.setBlockState(reader, blockpos, CroodsBlocks.CROODACEOUS_STONE.get().getDefaultState());
                        blockpos = blockpos.down();
                        --j2;
                        if (j2 <= 0) {
                            blockpos = blockpos.down(rand.nextInt(5) + 1);
                            j2 = rand.nextInt(5);
                        }
                    }
                }
            }

            return true;
        }
    }*/

    @Override
    public boolean generate(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random random, BlockPos pos, NoFeatureConfig config) {
        if (seedReader.getBlockState(pos.down()).getBlock() == CroodsBlocks.CROODACEOUS_SAND.get() || seedReader.getBlockState(pos.down()).getBlock() == Blocks.TERRACOTTA) {
            int height = 3 + random.nextInt(1);
            int size = 13 + random.nextInt(3);
            Direction offsetDir = null;
            pos = pos.down(size / 2);
            for (int i = 0; i < height; i++) {
                if (offsetDir == null && random.nextInt(i + 2) == 0) offsetDir = Direction.Plane.HORIZONTAL.random(random);
                if (offsetDir != null) pos = pos.offset(offsetDir);
                int end = random.nextInt(1) + 1;
                for (int j = 0; j <= size; j++) {
                    if (i == height - 1) break;
                    double remove = end + Math.sin(j * (Math.PI / size)) * 2;
                    for (int k = -5; k <= 5; k++) {
                        for (int m = -5; m <= 5; m++) {
                            if (k * k + m * m <= remove * remove)
                                if (MathHelper.abs(k) < 4 && MathHelper.abs(m) < 4) seedReader.setBlockState(pos.add(k, j, m), CroodsBlocks.HOODOO_SHALE.get().getDefaultState(), 2);
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
