// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.projectile;

import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import java.util.UUID;

public class ProjectileProperties
{
    private final UUID projectileId;
    private ItemStack itemMain;
    private ItemStack itemDeputy;
    
    public ProjectileProperties(final Projectile projectile) {
        this(projectile, null);
    }
    
    public ProjectileProperties(final Projectile projectile, final ItemStack itemMain) {
        this(projectile, itemMain, null);
    }
    
    public ProjectileProperties(final Projectile projectile, final ItemStack itemMain, final ItemStack itemDeputy) {
        if (projectile == null) {
            throw new IllegalArgumentException();
        }
        final UUID projectileId = projectile.getUniqueId();
        this.projectileId = projectileId;
        this.itemMain = itemMain;
        this.itemDeputy = itemDeputy;
    }
    
    public final UUID getProjectileId() {
        return this.projectileId;
    }
    
    public final ItemStack getItemMain() {
        return this.itemMain;
    }
    
    public final ItemStack getItemDeputy() {
        return this.itemDeputy;
    }
    
    public final boolean hasItemMain() {
        return this.getItemMain() != null;
    }
    
    public final boolean hasItemDeputy() {
        return this.getItemDeputy() != null;
    }
    
    public final void setItemMain(final ItemStack item) {
        this.itemMain = item;
    }
    
    public final void setItemDeputy(final ItemStack item) {
        this.itemDeputy = item;
    }
    
    public final boolean unregister() {
        final ProjectilePropertiesMemory projectilePropertiesMemory = ProjectilePropertiesMemory.getInstance();
        return projectilePropertiesMemory.unregister(this);
    }
    
    public static final ProjectileProperties getProjectileProperties(final Projectile projectile) {
        final ProjectilePropertiesMemory projectilePropertiesMemory = ProjectilePropertiesMemory.getInstance();
        final ProjectileProperties projectileProperties = projectilePropertiesMemory.getProjectileProperties(projectile);
        return projectileProperties;
    }
}
