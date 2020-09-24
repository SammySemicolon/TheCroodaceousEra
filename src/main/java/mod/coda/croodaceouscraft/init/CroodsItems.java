package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsItems {

    public static final DeferredRegister<Item> REGISTER = new DeferredRegister<>(ForgeRegistries.ITEMS, Croods.MOD_ID);

    public static final RegistryObject<BlockItem> CROODACEOUS_SAND = REGISTER.register("croodaceous_sand", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SAND.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE = REGISTER.register("croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> CHISELED_CROODACEOUS_SANDSTONE = REGISTER.register("chiseled_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CHISELED_CROODACEOUS_SANDSTONE.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> CUT_CROODACEOUS_SANDSTONE = REGISTER.register("cut_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CUT_CROODACEOUS_SANDSTONE.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> CUT_CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("cut_croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.CUT_CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE = REGISTER.register("smooth_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_STAIRS = REGISTER.register("croodaceous_sandstone_stairs", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_STAIRS.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("smooth_croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE_STAIRS = REGISTER.register("smooth_croodaceous_sandstone_stairs", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE_STAIRS.get(), new Item.Properties().group(Croods.GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_WALL = REGISTER.register("croodaceous_sandstone_wall", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_WALL.get(), new Item.Properties().group(Croods.GROUP)));

    public static final RegistryObject<BlockItem> CROODACEOUS_SHRUB = REGISTER.register("croodaceous_shrub", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SHRUB.get(), new Item.Properties().group(Croods.GROUP)));

    //public static final Item CROODACEOUS_SHRUB = register(CroodsBlocks.CROODACEOUS_SHRUB.get(), Croods.GROUP);

    private static Item register(Block block, ItemGroup group) {
        return register(new BlockItem(block, (new Item.Properties()).group(group)));
    }

    private static Item register(BlockItem blockItem) {
        return register(blockItem.getBlock(), blockItem);
    }

    protected static Item register(Block block, Item item) {
        return register(Registry.BLOCK.getKey(block), item);
    }

    private static Item register(ResourceLocation key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).addToBlockToItemMap(Item.BLOCK_TO_ITEM, item);
        }

        return Registry.register(Registry.ITEM, key, item);
    }
}
