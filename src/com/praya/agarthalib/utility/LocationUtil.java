// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.Iterator;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import java.util.HashMap;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtil
{
    public static final Location createLocation(final World world, final double x, final double y, final double z) {
        return new Location(world, x, y, z);
    }
    
    public static final Location getLocation(final Location loc, final double addX, final double addY, final double addZ) {
        return getLocation(loc, addX, addY, addZ, 0.0f, 0.0f);
    }
    
    public static final Location getLocation(final Location loc, final double addX, final double addY, final double addZ, final float addYaw, final float addPitch) {
        return new Location(loc.getWorld(), loc.getX() + addX, loc.getY() + addY, loc.getZ() + addZ, loc.getYaw() + addYaw, loc.getPitch() + addPitch);
    }
    
    public static final Location getNewLocation(final Location loc) {
        return new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
    }
    
    public static final String getCoordinate(final Location loc) {
        final AgarthaLib agarthaLib = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final PluginManager pluginManager = agarthaLib.getPluginManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        final HashMap<String, String> map = new HashMap<String, String>();
        String message = lang.getText("Location_Coordinate");
        map.put("world", loc.getWorld().getName());
        map.put("x", String.valueOf(MathUtil.roundNumber(loc.getX(), 2)));
        map.put("y", String.valueOf(MathUtil.roundNumber(loc.getY(), 2)));
        map.put("z", String.valueOf(MathUtil.roundNumber(loc.getZ(), 2)));
        map.put("yaw", String.valueOf(MathUtil.roundNumber(loc.getYaw(), 2)));
        map.put("pitch", String.valueOf(MathUtil.roundNumber(loc.getPitch(), 2)));
        message = TextUtil.placeholder(map, message);
        return message;
    }
    
    public static final Location getLineBlock(final Location location, final int loop, final double range) {
        final Vector vector = location.getDirection().normalize().multiply(range / loop);
        for (int i = 0; i < loop; ++i) {
            final Block block = location.getBlock();
            final Material material = block.getType();
            final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(material);
            if (materialEnum != null && materialEnum.isSolid()) {
                break;
            }
            location.add(vector);
        }
        return location;
    }
    
    public static final Location getLineLocation(final Entity entity, Location location, final double height, final double radius, final int loop, final double range, final boolean through) {
        final Vector vector = location.getDirection().normalize().multiply(range / loop);
        for (int i = 0; i < loop; ++i) {
            if (!through) {
                final Block block = location.getBlock();
                final Material material = block.getType();
                final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(material);
                if (materialEnum != null && materialEnum.isSolid()) {
                    break;
                }
            }
            location.add(vector);
            for (final LivingEntity unit : CombatUtil.getNearbyUnits(location, radius)) {
                if (!unit.equals(entity)) {
                    location = unit.getLocation().add(0.0, height, 0.0);
                    break;
                }
            }
        }
        return location;
    }
}
