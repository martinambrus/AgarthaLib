// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Entity;
import com.praya.agarthalib.utility.ProjectileUtil;
import org.bukkit.event.entity.ProjectileHitEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerCommand;

public class ListenerProjectileHit extends HandlerCommand implements Listener
{
    public ListenerProjectileHit(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void eventProjectileHit(final ProjectileHitEvent event) {
        final Projectile projectile = event.getEntity();
        if (projectile.hasMetadata("Projectile:Disappear")) {
            final boolean dissapear = ProjectileUtil.isDisappear((Entity)projectile);
            if (dissapear) {
                projectile.remove();
            }
        }
    }
}
