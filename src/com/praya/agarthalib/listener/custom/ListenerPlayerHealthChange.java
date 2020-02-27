// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.custom;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import com.praya.agarthalib.utility.EntityUtil;
import com.praya.agarthalib.event.PlayerHealthChangeEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerPlayerHealthChange extends HandlerListener implements Listener
{
    public ListenerPlayerHealthChange(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void eventPlayerHealthChange(final PlayerHealthChangeEvent event) {
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final double health = event.getHealth();
            EntityUtil.setHealth((LivingEntity)player, health);
        }
    }
}
