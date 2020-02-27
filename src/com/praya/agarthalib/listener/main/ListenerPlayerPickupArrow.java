// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerCommand;
import com.praya.agarthalib.utility.ProjectileUtil;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;

public class ListenerPlayerPickupArrow extends HandlerCommand implements Listener
{
    public ListenerPlayerPickupArrow(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void eventPlayerPickupArrow(final PlayerPickupArrowEvent event) {
        final AbstractArrow arrow = (AbstractArrow) event.getArrow();
        if (arrow.hasMetadata("Projectile:Pickable")) {
            final boolean pickable = ProjectileUtil.isPickable((Entity)arrow);
            event.setCancelled(!pickable);
        }
    }
}
