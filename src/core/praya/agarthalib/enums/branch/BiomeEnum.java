// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.branch;

import java.util.Iterator;
import com.praya.agarthalib.utility.BiomeUtil;
import org.bukkit.block.Biome;
import com.praya.agarthalib.utility.TextUtil;
import java.util.Arrays;
import java.util.List;

public enum BiomeEnum
{
    BEACHES(Arrays.asList("Beach", "Beaches")), 
    BIRCH_FOREST(Arrays.asList("Birch Forest", "Birch_Forest", "BirchForest")), 
    BIRCH_FOREST_HILLS(Arrays.asList("Birch Forest Hills", "Birch_Forest_Hills", "BirchForestHills")), 
    COLD_BEACH(Arrays.asList("Cold Beach", "Cold_Beach", "ColdBeach", "Cold Beaches", "Cold_Beaches", "ColdBeaches")), 
    DEEP_OCEAN(Arrays.asList("Deep Ocean", "Deep_Ocean", "DeepOcean")), 
    DESERT(Arrays.asList("Desert", "Sand Sea", "Sand_Sea", "SandSea")), 
    DESERT_HILLS(Arrays.asList("Desert Hills", "Desert_Hills", "DesertHills")), 
    EXTREME_HILLS(Arrays.asList("Extreme Hills", "Extreme_Hills", "ExtremeHills")), 
    EXTREME_HILLS_WITH_TREES(Arrays.asList("Extreme Hills With Trees", "Extreme_Hills_With_Trees", "ExtremeHillsWithTrees")), 
    FOREST(Arrays.asList("Forest")), 
    FOREST_HILLS(Arrays.asList("Forest Hills", "Forest_Hills", "ForestHills")), 
    FROZEN_OCEAN(Arrays.asList("Frozen Ocean", "Frozen_Ocean", "FrozenOcean")), 
    FROZEN_RIVER(Arrays.asList("Frozen River", "Frozen_River", "FrozenRiver")), 
    HELL(Arrays.asList("Hell")), 
    ICE_FLATS(Arrays.asList("Ice Flats", "Ice_Flats", "IceFlats", "Ice Flat", "Ice_Flat", "IceFlat")), 
    ICE_MOUNTAINS(Arrays.asList("Ice Mountains", "Ice_Mountains", "IceMountains", "Ice Mountain", "Ice_Mountain", "IceMountain")), 
    JUNGLE(Arrays.asList("Jungle")), 
    JUNGLE_EDGE(Arrays.asList("Jungle Edge", "Jungle_Edge", "JungleEdge")), 
    JUNGLE_HILLS(Arrays.asList("Jungle Hills", "Jungle_Hills", "JungleHills", "Jungle Hill", "Jungle_Hill", "JungleHill")), 
    MESA(Arrays.asList("Mesa")), 
    MESA_CLEAR_ROCK(Arrays.asList("Mesa Clear Rock", "Mesa_Clear_Rock", "MesaClearRock")), 
    MESA_ROCK(Arrays.asList("Mesa Rock", "Mesa_Rock", "MesaRock")), 
    MUSHROOM_ISLAND(Arrays.asList("Mushroom Island", "Mushroom_Island", "MushroomIsland")), 
    MUSHROOM_ISLAND_SHORE(Arrays.asList("Mushroom Island Shore", "Mushroom_Island_Shore", "MushroomIslandShore")), 
    MUTATED_BIRCH_FOREST(Arrays.asList("Mutated Birch Forest", "Mutated_Birch_Forest", "MutatedBirchForest")), 
    MUTATED_BIRCH_FOREST_HILLS(Arrays.asList("Mutated Birch Forest Hills", "Mutated_Birch_Forest_Hills", "MutatedBirchForestHills")), 
    MUTATED_DESERT(Arrays.asList("Mutated Desert", "Mutated_Desert", "MutatedDesert")), 
    MUTATED_EXTREME_HILLS(Arrays.asList("Mutated Extreme Hills", "Mutated_Extreme_Hills", "MutatedExtremeHills")), 
    MUTATED_EXTREME_HILLS_WITH_TREES(Arrays.asList("Mutated Extreme Hills With Trees", "Mutated_Extreme_Hills_With_Trees", "MutatedExtremeHillsWithTrees")), 
    MUTATED_FOREST(Arrays.asList("Mutated Forest", "Mutated_Forest", "MutatedForest")), 
    MUTATED_ICE_FLATS(Arrays.asList("Mutated Ice Flats", "Mutated_Ice_Flats", "MutatedIceFlats")), 
    MUTATED_JUNGLE(Arrays.asList("Mutated Jungle", "Mutated_Jungle", "MutatedJungle")), 
    MUTATED_JUNGLE_EDGE(Arrays.asList("Mutated Jungle Edge", "Mutated_Jungle_Edge", "MutatedJungleEdge")), 
    MUTATED_MESA(Arrays.asList("Mutated Mesa", "Mutated_Mesa", "MutatedMesa")), 
    MUTATED_MESA_CLEAR_ROCK(Arrays.asList("Mutated Mesa Clear Rock", "Mutated_Mesa_Clear_Rock", "MutatedMesaClearRock")), 
    MUTATED_MESA_ROCK(Arrays.asList("Mutated Mesa Rock", "Mutated_Mesa_Rock")), 
    MUTATED_PLAINS(Arrays.asList("Mutated Plains", "Mutated_Plains", "MutatedPlains", "Mutated Plain", "Mutated_Plain", "MutatedPlain")), 
    MUTATED_REDWOOD_TAIGA(Arrays.asList("Mutated Redwood Taiga", "Mutated_Redwood_Taiga", "MutatedRedwoodTaiga")), 
    MUTATED_REDWOOD_TAIGA_HILLS(Arrays.asList("Mutated Redwood Taiga Hills", "Mutated_Redwood_Taiga_Hills", "MutatedRedwoodTaigaHills")), 
    MUTATED_ROOFED_FOREST(Arrays.asList("Mutated Roofed Forest", "Mutated_Roofed_Forest", "MutatedRoofedForest")), 
    MUTATED_SAVANNA(Arrays.asList("Mutated Savanna", "Mutated_Savanna", "MutatedSavanna")), 
    MUTATED_SAVANNA_ROCK(Arrays.asList("Mutated Savanna Rock", "Mutated_Savanna_Rock", "MutatedSavannaRock")), 
    MUTATED_SWAMPLAND(Arrays.asList("Mutated Swampland", "Mutated_Swampland", "MutatedSwampland")), 
    MUTATED_TAIGA(Arrays.asList("Mutated Taiga", "Mutated_Taiga", "MutatedTaiga")), 
    MUTATED_TAIGA_COLD(Arrays.asList("Mutated Taiga Cold", "Mutated_Taiga_Cold", "MutatedTaigaCold")), 
    OCEAN(Arrays.asList("Ocean", "Sea")), 
    PLAINS(Arrays.asList("Plains", "Plain")), 
    REDWOOD_TAIGA(Arrays.asList("Redwood Taiga", "Redwood_Taiga", "RedwoodTaiga")), 
    REDWOOD_TAIGA_HILLS(Arrays.asList("Redwood Taiga Hills", "Redwood_Taiga_Hills", "RedwoodTaigaHills")), 
    RIVER(Arrays.asList("River", "Stream")), 
    ROOFED_FOREST(Arrays.asList("Roofed Forest", "Roofed_Forest", "RoofedForest")), 
    SAVANNA(Arrays.asList("Savanna")), 
    SAVANNA_ROCK(Arrays.asList("Savanna Rock", "Savanna_Rock", "SavannaRock")), 
    SKY(Arrays.asList("Sky", "Heaven")), 
    SMALLER_EXTREME_HILLS(Arrays.asList("Smaller Extreme Hills", "Smaller_Extreme_Hills", "SmallerExtremeHills")), 
    STONE_BEACH(Arrays.asList("Stone Beach", "Stone_Beach", "StoneBeach")), 
    SWAMPLAND(Arrays.asList("Swampland", "Swamp")), 
    TAIGA(Arrays.asList("Taiga")), 
    TAIGA_COLD(Arrays.asList("Taiga Cold", "Taiga_Cold", "TaigaCold")), 
    TAIGA_COLD_HILLS(Arrays.asList("Taiga Cold Hills", "Taiga_Cold_Hills", "TaigaColdHills")), 
    TAIGA_HILLS(Arrays.asList("Taiga Hills", "Taiga_Hills", "TaigaHills")), 
    VOID(Arrays.asList("Void"));
    
    private final List<String> aliases;
    
    private BiomeEnum(final List<String> aliases) {
        this.aliases = aliases;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final String getName() {
        return TextUtil.toTitleCase(this.name().replaceAll("_", " "));
    }
    
    public final Biome getBiome() {
        return BiomeUtil.getBiomeByOriginalName(this.name());
    }
    
    @Deprecated
    public final boolean isExists() {
        return this.getBiome() != null;
    }
    
    public static final BiomeEnum getBiomeEnum(final String biome) {
        if (biome != null) {
            BiomeEnum[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final BiomeEnum key = values[i];
                for (final String aliase : key.getAliases()) {
                    if (aliase.equalsIgnoreCase(biome)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
    
    public static final boolean isBiomeEnumExists(final String biome) {
        return getBiomeEnum(biome) != null;
    }
}
