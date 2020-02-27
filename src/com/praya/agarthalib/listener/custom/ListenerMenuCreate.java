// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.custom;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import core.praya.agarthalib.builder.item.Item;
import java.util.Iterator;
import core.praya.agarthalib.builder.text.Text;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import core.praya.agarthalib.builder.menu.MenuProperties;
import org.bukkit.inventory.ItemStack;
import core.praya.agarthalib.builder.item.ItemList;
import com.praya.agarthalib.utility.EquipmentUtil;
import core.praya.agarthalib.builder.item.ItemSingle;
import org.bukkit.plugin.Plugin;
import core.praya.agarthalib.builder.menu.Menu;
import com.praya.agarthalib.task.TaskMenuTitle;
import core.praya.agarthalib.builder.text.TextList;
import com.praya.agarthalib.task.TaskMenuItem;
import java.util.Collection;
import core.praya.agarthalib.builder.menu.MenuSlot;
import java.util.ArrayList;
import core.praya.agarthalib.builder.menu.MenuGUI;
import com.praya.agarthalib.event.MenuCreateEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerMenuCreate extends HandlerListener implements Listener
{
    public ListenerMenuCreate(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void menuCreateEvent(final MenuCreateEvent event) {
        final Menu menu = event.getMenu();
        final MenuProperties properties = menu.getProperties();
        final Inventory inventory = menu.getInventory();
        final Player owner = menu.getOwner();
        if (menu instanceof MenuGUI) {
            final MenuGUI menuGUI = (MenuGUI)menu;
            final Text title = properties.getTitle();
            final Collection<MenuSlot> menuSlots = new ArrayList<MenuSlot>(menuGUI.getMenuSlots());
            final TaskMenuItem taskMenuItem = new TaskMenuItem(menuGUI);
            if (title instanceof TextList) {
                final TextList titleList = (TextList)title;
                final TaskMenuTitle taskMenuTitle = new TaskMenuTitle(menuGUI, titleList);
                taskMenuTitle.runTaskTimer((Plugin)this.plugin, 0L, 1L);
            }
            for (final MenuSlot menuSlot : menuSlots) {
                final Item item = menuSlot.getItem();
                if (item != null) {
                    final int slot = menuSlot.getSlot();
                    if (item instanceof ItemSingle) {
                        final ItemStack itemStack = item.getItemStack();
                        EquipmentUtil.hookPlaceholderAPI(itemStack, owner);
                        inventory.setItem(slot, itemStack);
                    }
                    else {
                        if (!(item instanceof ItemList)) {
                            continue;
                        }
                        final ItemList itemList = (ItemList)item;
                        for (final ItemStack itemStack2 : itemList.getItemList()) {
                            EquipmentUtil.hookPlaceholderAPI(itemStack2, owner);
                        }
                    }
                }
            }
            taskMenuItem.runTaskTimer((Plugin)this.plugin, 0L, 2L);
        }
    }
}
