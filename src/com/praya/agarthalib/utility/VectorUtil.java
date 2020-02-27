// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.util.Vector;
import org.bukkit.Location;

public class VectorUtil
{
    public static final Vector getVector(final Location loc, final float addYaw, final float addPitch) {
        return getVector(loc, addYaw, addPitch, 1.0);
    }
    
    public static final Vector getVector(final Location loc, final float addYaw, final float addPitch, final double multiple) {
        final Location vectorLoc = new Location(loc.getWorld(), 0.0, 0.0, 0.0, loc.getYaw() + addYaw, loc.getPitch() + addPitch);
        final Vector vector = vectorLoc.getDirection().multiply(multiple);
        return vector;
    }
    
    public static final Vector getRelative(final Location base, final Location target) {
        return getRelative(base, target, true);
    }
    
    public static final Vector getRelative(final Location base, final Location target, final boolean normalize) {
        final Vector relative = new Location(base.getWorld(), target.getX() - base.getX(), target.getY() - base.getY(), target.getZ() - base.getZ()).toVector();
        if (normalize) {
            return relative.normalize();
        }
        return relative;
    }
    
    public static final Vector getRelativeHorizontal(final Location base, final Location target) {
        return getRelativeHorizontal(base, target, true);
    }
    
    public static final Vector getRelativeHorizontal(final Location base, final Location target, final boolean normalize) {
        final Location newBase = new Location(base.getWorld(), base.getX(), 0.0, base.getZ());
        final Location newTarget = new Location(target.getWorld(), target.getX(), 0.0, target.getZ());
        return getRelative(newBase, newTarget, normalize);
    }
    
    public static final Vector getLeft(final Location loc) {
        return getVector(loc, 90.0f, 0.0f);
    }
    
    public static final Vector getRight(final Location loc) {
        return getVector(loc, -90.0f, 0.0f);
    }
    
    public static final Vector getUp(final Location loc) {
        return getVector(loc, 0.0f, 90.0f);
    }
    
    public static final Vector getDown(final Location loc) {
        return getVector(loc, 0.0f, -90.0f);
    }
    
    public static final double getVelocity(final double speed) {
        if (speed <= 1.0 && speed >= -1.0) {
            return 0.2 * speed;
        }
        if (speed > 1.0) {
            return 0.2 + (speed - 1.0) * 0.09;
        }
        return -0.2 + (speed + 1.0) * 0.09;
    }
}
