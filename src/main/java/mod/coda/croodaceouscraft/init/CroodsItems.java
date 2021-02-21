package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.item.CroodsSpawnEggItem;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Croods.MOD_ID);

    public final static ItemGroup GROUP = new ItemGroup("croods_item_group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CroodsBlocks.CROODACEOUS_SAND.get());
        }
    };

    public static final RegistryObject<Item> RAMU_EGG = REGISTER.register("ramu_egg", () -> new Item(new Item.Properties().group(GROUP).maxStackSize(1).food(new Food.Builder().hunger(8).saturation(0.5f).build())));
    public static final RegistryObject<Item> JACKROBAT_SPAWN_EGG = REGISTER.register("jackrobat_spawn_egg", () -> new CroodsSpawnEggItem(CroodsEntities.JACKROBAT, 0x653941, 0x993e30, new Item.Properties().group(GROUP)));
    public static final RegistryObject<Item> LIYOTE_SPAWN_EGG = REGISTER.register("liyote_spawn_egg", () -> new CroodsSpawnEggItem(CroodsEntities.LIYOTE, 0xd67924, 0x8990d7, new Item.Properties().group(GROUP)));

    public static final RegistryObject<BlockItem> CROODACEOUS_SHRUB = REGISTER.register("croodaceous_shrub", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SHRUB.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SAND = REGISTER.register("croodaceous_sand", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SAND.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE = REGISTER.register("croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CHISELED_CROODACEOUS_SANDSTONE = REGISTER.register("chiseled_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CHISELED_CROODACEOUS_SANDSTONE.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CUT_CROODACEOUS_SANDSTONE = REGISTER.register("cut_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CUT_CROODACEOUS_SANDSTONE.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE = REGISTER.register("smooth_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_STAIRS = REGISTER.register("croodaceous_sandstone_stairs", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_STAIRS.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CUT_CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("cut_croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.CUT_CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("smooth_croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE_STAIRS = REGISTER.register("smooth_croodaceous_sandstone_stairs", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE_STAIRS.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_WALL = REGISTER.register("croodaceous_sandstone_wall", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_WALL.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_STONE = REGISTER.register("croodaceous_stone", () -> new BlockItem(CroodsBlocks.CROODACEOUS_STONE.get(), new Item.Properties().group(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_BRANCHES = REGISTER.register("desert_baobab_branches", () -> new WallOrFloorItem(CroodsBlocks.DESERT_BAOBAB_BRANCHES.get(), CroodsBlocks.DESERT_BAOBAB_WALL_BRANCHES.get(), (new Item.Properties().group(GROUP))));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_LOG = REGISTER.register("desert_baobab_log", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_LOG.get(), new Item.Properties().group(GROUP)));

}