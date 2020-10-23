package mod.coda.croodaceouscraft;

import mod.coda.croodaceouscraft.init.CroodsBiomes;
import mod.coda.croodaceouscraft.init.CroodsBlocks;
import mod.coda.croodaceouscraft.init.CroodsFeatures;
import mod.coda.croodaceouscraft.init.CroodsItems;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Croods.MOD_ID)
public class Croods {
    public static final String MOD_ID = "croodaceouscraft";

    public Croods() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CroodsItems.REGISTER.register(bus);
        CroodsBlocks.REGISTER.register(bus);
        CroodsFeatures.REGISTER.register(bus);
        CroodsBiomes.REGISTER.register(bus);
    }
}
