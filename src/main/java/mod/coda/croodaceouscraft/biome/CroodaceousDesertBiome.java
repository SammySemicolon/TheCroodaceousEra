package mod.coda.croodaceouscraft.biome;

import mod.coda.croodaceouscraft.init.CroodsFeatures;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

public class CroodaceousDesertBiome {
    public static Biome make() {
        MobSpawnInfo.Builder spawnBuilder = new MobSpawnInfo.Builder();
        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder().withSurfaceBuilder(ConfiguredSurfaceBuilders.field_244172_d);
        DefaultBiomeFeatures.withDesertMobs(spawnBuilder);
        DefaultBiomeFeatures.withFossils(generationBuilder);
        DefaultBiomeFeatures.withStrongholdAndMineshaft(generationBuilder);
        DefaultBiomeFeatures.withCavesAndCanyons(generationBuilder);
        DefaultBiomeFeatures.withLavaLakes(generationBuilder);
        DefaultBiomeFeatures.withMonsterRoom(generationBuilder);
        DefaultBiomeFeatures.withCommonOverworldBlocks(generationBuilder);
        DefaultBiomeFeatures.withOverworldOres(generationBuilder);
        DefaultBiomeFeatures.withDisks(generationBuilder);
        DefaultBiomeFeatures.withDefaultFlowers(generationBuilder);
        DefaultBiomeFeatures.withBadlandsGrass(generationBuilder);
        DefaultBiomeFeatures.withDesertDeadBushes(generationBuilder);
        DefaultBiomeFeatures.withNormalMushroomGeneration(generationBuilder);
        DefaultBiomeFeatures.withLavaAndWaterSprings(generationBuilder);
        DefaultBiomeFeatures.withFrozenTopLayer(generationBuilder);
        generationBuilder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, CroodsFeatures.ROCKS.withConfiguration(NoFeatureConfig.field_236559_b_).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242729_a(10));
        return new Biome.Builder().precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(0.125F).scale(0.05F).temperature(2.0F).downfall(0.0F).setEffects(new BiomeAmbience.Builder().setWaterColor(0x3F76E4).setWaterFogColor(0x50533).setFogColor(0xC0D8FF).withSkyColor(0x6EB1FF).setMoodSound(MoodSoundAmbience.DEFAULT_CAVE).build()).withMobSpawnSettings(spawnBuilder.copy()).withGenerationSettings(generationBuilder.build()).build();
    }
}
