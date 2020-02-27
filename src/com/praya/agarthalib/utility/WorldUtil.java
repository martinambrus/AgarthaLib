// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import com.praya.agarthalib.server.ServerWorldMemory;
import org.bukkit.World;
import java.util.Collection;

public class WorldUtil
{
    public static final Collection<World> getWorlds() {
        final ServerWorldMemory serverWorldMemory = ServerWorldMemory.getInstance();
        return serverWorldMemory.getAllWorld();
    }
    
    public static final World getWorld(final String world) {
        if (world != null) {
            for (final World key : getWorlds()) {
                if (key.getName().equalsIgnoreCase(world)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public static final List<World> getWorlds(final List<String> list) {
        final List<World> worlds = new ArrayList<World>();
        if (list != null) {
            for (final String key : list) {
                final World world = getWorld(key);
                if (world != null) {
                    worlds.add(world);
                }
            }
        }
        return worlds;
    }
    
    public static final boolean isWorldExists(final String world) {
        return getWorld(world) != null;
    }
    
    public static final void createExplosion(final Location location, final float power) {
        createExplosion(location, power, false, true);
    }
    
    public static final void createExplosion(final Location location, final float power, final boolean blocationkBreak) {
        createExplosion(location, power, false, blocationkBreak);
    }
    
    public static final void createExplosion(final Location location, final float power, final boolean setFire, final boolean blocationkBreak) {
        if (location != null) {
            location.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), power, setFire, blocationkBreak);
        }
    }
}
