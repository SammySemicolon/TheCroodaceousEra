package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.blocks.CroodaceousShrubBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsBlocks {

    public static final DeferredRegister<Block> REGISTER = new DeferredRegister<>(ForgeRegistries.BLOCKS, Croods.MOD_ID);

    public static final RegistryObject<Block> CROODACEOUS_SAND = REGISTER.register("croodaceous_sand", () -> new SandBlock(0xe7ba8a, Block.Properties.create(Material.SAND).hardnessAndResistance(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE = REGISTER.register("croodaceous_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> CHISELED_CROODACEOUS_SANDSTONE = REGISTER.register("chiseled_croodaceous_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> CUT_CROODACEOUS_SANDSTONE = REGISTER.register("cut_croodaceous_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE = REGISTER.register("smooth_croodaceous_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_STAIRS = REGISTER.register("croodaceous_sandstone_stairs", () -> new StairsBlock(() -> CROODACEOUS_SANDSTONE.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("croodaceous_sandstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> CUT_CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("cut_croodaceous_sandstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("smooth_croodaceous_sandstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE_STAIRS = REGISTER.register("smooth_croodaceous_sandstone_stairs", () -> new StairsBlock(() -> SMOOTH_CROODACEOUS_SANDSTONE.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_WALL = REGISTER.register("croodaceous_sandstone_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f)));

    public static final RegistryObject<Block> CROODACEOUS_SHRUB = REGISTER.register("croodaceous_shrub", () -> new CroodaceousShrubBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.BROWN).doesNotBlockMovement().sound(SoundType.PLANT).hardnessAndResistance(0.0f)));
}
