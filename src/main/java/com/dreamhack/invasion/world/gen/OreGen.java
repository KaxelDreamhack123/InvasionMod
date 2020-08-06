package com.dreamhack.invasion.world.gen;

import com.dreamhack.invasion.blocks.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException;

public class OreGen {

    public static void generateOre() {
        for(Biome biome : ForgeRegistries.BIOMES) {
            if(biome == Biomes.PLAINS) {
                ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 2, 1, 20));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                ModBlocks.URU_ORE.getDefaultState(), 3)).withPlacement(customConfig));
            }
        }
    }

}
