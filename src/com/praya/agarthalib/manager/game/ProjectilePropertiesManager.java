// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.game;

import org.bukkit.entity.Projectile;
import com.praya.agarthalib.projectile.ProjectileProperties;
import java.util.UUID;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class ProjectilePropertiesManager extends HandlerManager
{
    protected ProjectilePropertiesManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract Collection<UUID> getProjectileIds();
    
    public abstract Collection<ProjectileProperties> getAllProjectileProperties();
    
    public abstract ProjectileProperties getProjectileProperties(final Projectile p0);
    
    public abstract ProjectileProperties getProjectileProperties(final Projectile p0, final boolean p1);
}
