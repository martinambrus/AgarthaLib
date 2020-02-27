// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.task;

import org.bukkit.inventory.ItemStack;
import core.praya.agarthalib.builder.item.Item;
import java.util.Iterator;
import org.bukkit.inventory.Inventory;
import core.praya.agarthalib.builder.item.ItemList;
import java.util.Collection;
import core.praya.agarthalib.builder.menu.MenuSlot;
import java.util.ArrayList;
import core.praya.agarthalib.builder.menu.MenuGUI;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskMenuItem extends BukkitRunnable
{
    private final MenuGUI menu;
    
    public TaskMenuItem(final MenuGUI menu) {
        this.menu = menu;
    }
    
    public void run() {
        if (!this.menu.hasViewer()) {
            this.cancel();
        }
        else {
            final Inventory inventory = this.menu.getInventory();
            final int size = inventory.getSize();
            final Collection<MenuSlot> menuSlots = new ArrayList<MenuSlot>(this.menu.getMenuSlots());
            for (final MenuSlot menuSlot : menuSlots) {
                final Item item = menuSlot.getItem();
                if (item instanceof ItemList) {
                    final int slot = menuSlot.getSlot();
                    final ItemList itemList = (ItemList)item;
                    final ItemStack itemStack = itemList.next();
                    if (slot >= size) {
                        continue;
                    }
                    inventory.setItem(slot, itemStack);
                }
            }
        }
    }
}
