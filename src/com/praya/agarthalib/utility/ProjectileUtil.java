// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Entity;

public class ProjectileUtil
{
    private static final String METADATA_PICKABLE = "Projectile:Pickable";
    private static final String METADATA_DISAPPEAR = "Projectile:Disappear";
    
    public static final boolean isProjectile(final Entity entity) {
        return entity != null && entity instanceof Projectile;
    }
    
    public static final boolean isArrow(final Entity entity) {
        return entity != null && entity instanceof Arrow;
    }
    
    public static final Projectile parseProjectile(final Entity entity) {
        return (entity != null) ? ((Projectile)entity) : null;
    }
    
    public static final Arrow parseArrow(final Entity entity) {
        return (entity != null) ? ((Arrow)entity) : null;
    }
    
    public static final Location getDirectLocation(final Entity entity) {
        if (entity == null) {
            return null;
        }
        final Location loc = entity.getLocation();
        if (isProjectile(entity)) {
            loc.setYaw(0.0f - loc.getYaw());
            loc.setPitch(0.0f - loc.getPitch());
        }
        return loc;
    }
    
    public static final void setPickable(final Entity entity, final boolean pickable) {
        if (entity != null) {
            entity.setMetadata("Projectile:Pickable", MetadataUtil.createMetadata(pickable));
        }
    }
    
    public static final void setDisappear(final Entity entity, final boolean disappear) {
        if (entity != null) {
            entity.setMetadata("Projectile:Disappear", MetadataUtil.createMetadata(disappear));
        }
    }
    
    public static final boolean isPickable(final Entity entity) {
        return entity != null && entity.hasMetadata("Projectile:Pickable") && MetadataUtil.getMetadata(entity, "Projectile:Pickable").asBoolean();
    }
    
    public static final boolean isDisappear(final Entity entity) {
        return entity != null && entity.hasMetadata("Projectile:Disappear") && MetadataUtil.getMetadata(entity, "Projectile:Disappear").asBoolean();
    }
}
