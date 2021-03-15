package mod.coda.thecroodaceousera.init;

import mod.coda.thecroodaceousera.Croods;
import mod.coda.thecroodaceousera.block.BaobabSaplingBlock;
import mod.coda.thecroodaceousera.block.BranchesBlock;
import mod.coda.thecroodaceousera.block.BranchesWallBlock;
import mod.coda.thecroodaceousera.block.CroodaceousShrubBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CroodsBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Croods.MOD_ID);

    // Croodaceous Sand
    public static final RegistryObject<Block> CROODACEOUS_SAND = register("croodaceous_sand", () -> new SandBlock(0xe7ba8a, Block.Properties.create(Material.SAND).hardnessAndResistance(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE = register("croodaceous_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> CHISELED_CROODACEOUS_SANDSTONE = register("chiseled_croodaceous_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> CUT_CROODACEOUS_SANDSTONE = register("cut_croodaceous_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE = register("smooth_croodaceous_sandstone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_STAIRS = register("croodaceous_sandstone_stairs", () -> new StairsBlock(() -> CROODACEOUS_SANDSTONE.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_SLAB = register("croodaceous_sandstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> CUT_CROODACEOUS_SANDSTONE_SLAB = register("cut_croodaceous_sandstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE_SLAB = register("smooth_croodaceous_sandstone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE_STAIRS = register("smooth_croodaceous_sandstone_stairs", () -> new StairsBlock(() -> SMOOTH_CROODACEOUS_SANDSTONE.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_WALL = register("croodaceous_sandstone_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.2f).setRequiresTool()));

    // Hoodoo Shale
    public static final RegistryObject<Block> HOODOO_SHALE = register("hoodoo_shale", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));
    public static final RegistryObject<Block> POLISHED_HOODOO_SHALE = register("polished_hoodoo_shale", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));
    public static final RegistryObject<Block> HOODOO_SHALE_TLES = register("hoodoo_shale_tiles", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));
    public static final RegistryObject<Block> CHISELED_HOODOO_SHALE = register("chiseled_hoodoo_shale", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));
    public static final RegistryObject<Block> HOODOO_SHALE_STAIRS = register("hoodoo_shale_stairs", () -> new StairsBlock(() -> HOODOO_SHALE.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));
    public static final RegistryObject<Block> POLISHED_HOODOO_SHALE_STAIRS = register("polished_hoodoo_shale_stairs", () -> new StairsBlock(() -> POLISHED_HOODOO_SHALE.get().getDefaultState(), Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));
    public static final RegistryObject<Block> HOODOO_SHALE_SLAB = register("hoodoo_shale_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));
    public static final RegistryObject<Block> POLISHED_HOODOO_SHALE_SLAB = register("polished_hoodoo_shale_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));
    public static final RegistryObject<Block> HOODOO_SHALE_WALL = register("hoodoo_shale_wall", () -> new WallBlock(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));

    // Desert Baobab
    
    public static final RegistryObject<Block> DESERT_BAOBAB_SAPLING = register("desert_baobab_sapling", () -> new BaobabSaplingBlock(Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<Block> DESERT_BAOBAB_LOG = register("desert_baobab_log", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DESERT_BAOBAB_WOOD = REGISTER.register("desert_baobab_wood", () -> new RotatedPillarBlock(Block.Properties.from(DESERT_BAOBAB_LOG.get())));
    public static final RegistryObject<Block> STRIPPED_DESERT_BAOBAB_LOG = REGISTER.register("stripped_desert_baobab_log", () -> new RotatedPillarBlock(Block.Properties.from(DESERT_BAOBAB_LOG.get())));
    public static final RegistryObject<Block> STRIPPED_DESERT_BAOBAB_WOOD = REGISTER.register("stripped_desert_baobab_wood", () -> new RotatedPillarBlock(Block.Properties.from(DESERT_BAOBAB_LOG.get())));
    public static final RegistryObject<Block> DESERT_BAOBAB_PLANKS = REGISTER.register("desert_baobab_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> DESERT_BAOBAB_STAIRS = REGISTER.register("desert_baobab_stairs", () -> new StairsBlock(() -> DESERT_BAOBAB_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> DESERT_BAOBAB_FENCE = REGISTER.register("desert_baobab_fence", () -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> DESERT_BAOBAB_SLAB = REGISTER.register("desert_baobab_slab", () -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> DESERT_BAOBAB_PRESSURE_PLATE = REGISTER.register("desert_baobab_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> DESERT_BAOBAB_BUTTON = REGISTER.register("desert_baobab_button", () -> new WoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> DESERT_BAOBAB_TRAPDOOR = REGISTER.register("desert_baobab_trapdoor", () -> new TrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<Block> DESERT_BAOBAB_DOOR = REGISTER.register("desert_baobab_door", () -> new DoorBlock(Block.Properties.from(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> DESERT_BAOBAB_FENCE_GATE = REGISTER.register("desert_baobab_fence_gate", () -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> DESERT_BAOBAB_BRANCHES = register("desert_baobab_branches", () -> new BranchesBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.BROWN).sound(SoundType.PLANT).doesNotBlockMovement().zeroHardnessAndResistance()));
    public static final RegistryObject<Block> DESERT_BAOBAB_WALL_BRANCHES = register("desert_baobab_wall_branches", () -> new BranchesWallBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.BROWN).sound(SoundType.PLANT).doesNotBlockMovement().zeroHardnessAndResistance()));

    // Other
    public static final RegistryObject<Block> CROODACEOUS_SHRUB = register("croodaceous_shrub", () -> new CroodaceousShrubBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.BROWN).doesNotBlockMovement().sound(SoundType.PLANT).hardnessAndResistance(0.0f)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> object = REGISTER.register(name, block);
        return object;
    }
}
