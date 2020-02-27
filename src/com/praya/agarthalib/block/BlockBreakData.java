// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.block;

import org.bukkit.Location;

public class BlockBreakData extends core.praya.agarthalib.builder.block.BlockBreakData
{
    public BlockBreakData(final int id, final Location location) {
        this(id, location, 200);
    }
    
    public BlockBreakData(final int id, final Location location, final int cooldown) {
        super(id, location, cooldown);
    }
}
