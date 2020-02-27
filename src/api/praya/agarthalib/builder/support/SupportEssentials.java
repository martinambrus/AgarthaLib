// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import org.bukkit.Location;
import java.util.Iterator;
import net.ess3.api.InvalidWorldException;
import com.earth2me.essentials.commands.WarpNotFoundException;
import java.util.ArrayList;
import org.bukkit.World;
import com.earth2me.essentials.Warps;
import org.bukkit.plugin.java.JavaPlugin;
import com.earth2me.essentials.Essentials;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportEssentials extends Support
{
    public SupportEssentials(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final Collection<String> getWarpNames() {
        final Essentials essentials = (Essentials)JavaPlugin.getPlugin((Class)Essentials.class);
        final Warps essentialWarps = essentials.getWarps();
        return (Collection<String>)essentialWarps.getList();
    }
    
    public final Collection<String> getWarpNames(final World world) {
        final Essentials essentials = (Essentials)JavaPlugin.getPlugin((Class)Essentials.class);
        final Warps essentialWarps = essentials.getWarps();
        final Collection<String> warps = new ArrayList<String>();
        if (world != null) {
            for (final String warp : this.getWarpNames()) {
                try {
                    final Location warpLocation = essentialWarps.getWarp(warp);
                    final World warpWorld = warpLocation.getWorld();
                    if (!warpWorld.equals(world)) {
                        continue;
                    }
                    warps.add(warp);
                }
                catch (WarpNotFoundException ex) {}
                catch (InvalidWorldException ex2) {}
            }
        }
        return warps;
    }
    
    public final Location getWarp(final String warp) {
        final Essentials essentials = (Essentials)JavaPlugin.getPlugin((Class)Essentials.class);
        final Warps essentialWarps = essentials.getWarps();
        try {
            return essentialWarps.getWarp(warp);
        }
        catch (WarpNotFoundException | InvalidWorldException ex2) {
            return null;
        }
    }
    
    public final Collection<Location> getWarps() {
        final Essentials essentials = (Essentials)JavaPlugin.getPlugin((Class)Essentials.class);
        final Warps essentialWarps = essentials.getWarps();
        final Collection<Location> warps = new ArrayList<Location>();
        for (final String name : this.getWarpNames()) {
            try {
                final Location warp = essentialWarps.getWarp(name);
                warps.add(warp);
            }
            catch (WarpNotFoundException ex) {}
            catch (InvalidWorldException ex2) {}
        }
        return warps;
    }
    
    public final Collection<Location> getWarps(final World world) {
        final Collection<Location> warps = new ArrayList<Location>();
        if (world != null) {
            for (final Location warp : this.getWarps()) {
                final World warpWorld = warp.getWorld();
                if (warpWorld.equals(world)) {
                    warps.add(warp);
                }
            }
        }
        return warps;
    }
}
