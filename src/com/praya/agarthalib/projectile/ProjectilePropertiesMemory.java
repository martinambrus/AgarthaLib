// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.projectile;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Projectile;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import java.util.UUID;
import java.util.HashMap;
import com.praya.agarthalib.manager.game.ProjectilePropertiesManager;

public class ProjectilePropertiesMemory extends ProjectilePropertiesManager
{
    private final HashMap<UUID, ProjectileProperties> mapProjectileProperties;
    
    private ProjectilePropertiesMemory(final AgarthaLib plugin) {
        super(plugin);
        this.mapProjectileProperties = new HashMap<UUID, ProjectileProperties>();
    }
    
    public static final ProjectilePropertiesMemory getInstance() {
        return ProjectilePropertiesMemorySingleton.instance;
    }
    
    @Override
    public final Collection<UUID> getProjectileIds() {
        return this.mapProjectileProperties.keySet();
    }
    
    @Override
    public final Collection<ProjectileProperties> getAllProjectileProperties() {
        return this.mapProjectileProperties.values();
    }
    
    @Override
    public final ProjectileProperties getProjectileProperties(final Projectile projectile) {
        return this.getProjectileProperties(projectile, false);
    }
    
    @Override
    public final ProjectileProperties getProjectileProperties(final Projectile projectile, final boolean generate) {
        if (projectile != null) {
            final UUID projectileId = projectile.getUniqueId();
            if (!this.getProjectileIds().contains(projectileId) && generate) {
                final ProjectileProperties projectileProperties = new ProjectileProperties(projectile);
                this.mapProjectileProperties.put(projectileId, projectileProperties);
            }
            return this.mapProjectileProperties.get(projectileId);
        }
        return null;
    }
    
    protected final boolean unregister(final ProjectileProperties projectileProperties) {
        if (projectileProperties != null && this.getAllProjectileProperties().contains(projectileProperties)) {
            final UUID projectileId = projectileProperties.getProjectileId();
            this.mapProjectileProperties.remove(projectileId);
            return true;
        }
        return false;
    }
    
    private static class ProjectilePropertiesMemorySingleton
    {
        private static final ProjectilePropertiesMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new ProjectilePropertiesMemory(plugin);
        }
    }
}
