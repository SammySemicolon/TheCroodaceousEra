package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
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

    public static final RegistryObject<Item> RAMU_EGG = REGISTER.register("ramu_egg", () -> new Item(new Item.Properties().group(GROUP).maxStackSize(1).food(new Food.Builder().hunger(8).saturation(0.3f).build())));
}
