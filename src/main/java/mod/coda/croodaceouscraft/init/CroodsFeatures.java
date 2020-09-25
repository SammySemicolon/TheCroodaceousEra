package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.features.RockFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, Croods.MOD_ID);

    public static final RegistryObject<RockFeature> ROCKS = REGISTER.register("rocks", RockFeature::new);
}
