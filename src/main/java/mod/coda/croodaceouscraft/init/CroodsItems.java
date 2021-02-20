package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.items.CroodsSpawnEggItem;
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

}