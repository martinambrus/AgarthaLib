// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import java.util.Set;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.Inventory;
import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.event.inventory.InventoryDragEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerInventoryDrag extends HandlerListener implements Listener
{
    public ListenerInventoryDrag(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void inventoryDragEvent(final InventoryDragEvent event) {
        if (!event.isCancelled()) {
            final Inventory inventory = event.getInventory();
            final InventoryHolder holder = inventory.getHolder();
            if (holder != null && holder instanceof Menu) {
                final Set<Integer> slots = (Set<Integer>)event.getRawSlots();
                final int size = inventory.getSize();
                for (final int slot : slots) {
                    if (slot < size) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
