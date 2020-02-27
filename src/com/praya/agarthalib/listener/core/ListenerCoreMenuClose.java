// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.core;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import com.praya.agarthalib.utility.ServerEventUtil;
import com.praya.agarthalib.event.MenuCloseEvent;
import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerCoreMenuClose extends HandlerListener implements Listener
{
    public ListenerCoreMenuClose(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void menuOpenEvent(final InventoryCloseEvent event) {
        final HumanEntity human = event.getPlayer();
        if (human instanceof Player) {
            final Player player = (Player)human;
            final Inventory inventory = event.getInventory();
            final InventoryHolder holder = inventory.getHolder();
            if (holder instanceof Menu) {
                final Menu menu = (Menu)holder;
                final MenuCloseEvent menuCloseEvent = new MenuCloseEvent(player, menu);
                ServerEventUtil.callEvent(menuCloseEvent);
            }
        }
    }
}
