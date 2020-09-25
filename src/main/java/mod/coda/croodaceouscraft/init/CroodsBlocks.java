package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.blocks.CroodaceousShrubBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CroodsBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Croods.MOD_ID);

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

    public static final RegistryObject<Block> CROODACEOUS_STONE = register("croodaceous_stone", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.5f, 6.0f).setRequiresTool()));

    public static final RegistryObject<Block> CROODACEOUS_SHRUB = register("croodaceous_shrub", () -> new CroodaceousShrubBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.BROWN).doesNotBlockMovement().sound(SoundType.PLANT).hardnessAndResistance(0.0f)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> object = REGISTER.register(name, block);
        CroodsItems.REGISTER.register(name, () -> new BlockItem(object.get(), new Item.Properties().group(CroodsItems.GROUP)));
        return object;
    }
}
