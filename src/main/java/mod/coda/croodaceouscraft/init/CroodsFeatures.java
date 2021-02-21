package mod.coda.croodaceouscraft.init;

import mod.coda.croodaceouscraft.Croods;
import mod.coda.croodaceouscraft.world.feature.DesertBaobabFeature;
import mod.coda.croodaceouscraft.world.feature.RockFormationFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, Croods.MOD_ID);

    public static final RegistryObject<RockFormationFeature> ROCK_FORMATION = REGISTER.register("rock_formation", RockFormationFeature::new);
    public static final RegistryObject<DesertBaobabFeature> DESERT_BAOBAB = REGISTER.register("desert_baobab", DesertBaobabFeature::new);

}
