// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import api.praya.agarthalib.builder.support.main.Support;
import com.praya.agarthalib.AgarthaLib;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collection;

public class SupportWorldGuard extends Support
{
    public SupportWorldGuard(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final RegionManager getRegionManager(final World world) {
        final WorldGuard worldGuardPlugin = WorldGuard.getInstance();
        return (world != null) ? worldGuardPlugin.getPlatform().getRegionContainer().get(BukkitAdapter.adapt(world)) : null;
    }
    
    public final boolean isRegionManagerExists(final World world) {
        return this.getRegionManager(world) != null;
    }
    
    public final Collection<String> getRegionIDs(final World world) {
        final RegionManager regionManager = this.getRegionManager(world);
        return (Collection<String>)((regionManager != null) ? regionManager.getRegions().keySet() : new ArrayList<String>());
    }
    
    public final Collection<ProtectedRegion> getRegions(final World world) {
        final RegionManager regionManager = this.getRegionManager(world);
        return (regionManager != null) ? regionManager.getRegions().values() : new ArrayList<ProtectedRegion>();
    }
    
    public final ProtectedRegion getRegion(final World world, final String id) {
        final RegionManager regionManager = this.getRegionManager(world);
        if (regionManager != null && id != null) {
            for (final String key : regionManager.getRegions().keySet()) {
                if (key.equalsIgnoreCase(id)) {
                    return regionManager.getRegion(key);
                }
            }
        }
        return null;
    }
    
    public final boolean isRegionExists(final World world, final String id) {
        return this.getRegion(world, id) != null;
    }
    
    public final boolean isPlayerInsideRegion(final World world, final String id, final Player player) {
        final ProtectedRegion region = this.getRegion(world, id);
        return region != null && this.isPlayerInsideRegion(region, player);
    }
    
    public final boolean isPlayerInsideRegion(final ProtectedRegion region, final Player player) {
        if (player != null) {
            final Location location = player.getLocation();
            return this.isLocationInsideRegion(region, location);
        }
        return false;
    }
    
    public final boolean isLocationInsideRegion(final World world, final String id, final Location location) {
        if (world != null && id != null && location != null) {
            final ProtectedRegion region = this.getRegion(world, id);
            return region != null && this.isLocationInsideRegion(region, location);
        }
        return false;
    }
    
    public final boolean isLocationInsideRegion(final ProtectedRegion region, final Location location) {
        if (region != null && location != null) {
            final int blockX = location.getBlockX();
            final int blockY = location.getBlockY();
            final int blockZ = location.getBlockZ();
            return region.contains(blockX, blockY, blockZ);
        }
        return false;
    }
}
