// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import core.praya.agarthalib.enums.branch.BiomeEnum;
import org.bukkit.block.Biome;

public class BiomeUtil
{
    public static final Biome getBiome(final String biome) {
        if (biome != null) {
            final Biome biomePrimary = getBiomeByOriginalName(biome);
            if (biomePrimary != null) {
                return biomePrimary;
            }
            final BiomeEnum biomeEnum = BiomeEnum.getBiomeEnum(biome);
            if (biomeEnum != null) {
                return biomeEnum.getBiome();
            }
        }
        return null;
    }
    
    public static final Biome getBiomeByOriginalName(final String biome) {
        if (biome != null) {
            Biome[] values;
            for (int length = (values = Biome.values()).length, i = 0; i < length; ++i) {
                final Biome key = values[i];
                if (key.toString().equalsIgnoreCase(biome)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public static final boolean isBiomeExists(final String biome) {
        return getBiome(biome) != null;
    }
    
    @Deprecated
    public static final boolean isExists(final String biome) {
        return getBiome(biome) != null;
    }
}
