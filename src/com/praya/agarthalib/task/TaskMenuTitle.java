// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.task;

import org.bukkit.inventory.Inventory;
import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.builder.text.TextList;
import core.praya.agarthalib.builder.menu.Menu;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskMenuTitle extends BukkitRunnable
{
    private final Menu menu;
    private final TextList titles;
    
    public TaskMenuTitle(final Menu menu, final TextList titles) {
        this.menu = menu;
        this.titles = titles;
    }
    
    public void run() {
        if (!this.menu.hasViewer()) {
            this.cancel();
        }
        else {
            final Inventory inventory = this.menu.getInventory();
            final String title = this.titles.next();
            Bridge.getBridgeInventory().setWindowTitle(inventory, title);
        }
    }
}
