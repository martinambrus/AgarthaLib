// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.custom;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import core.praya.agarthalib.builder.menu.MenuBuilder;
import core.praya.agarthalib.builder.menu.MenuRegister;
import core.praya.agarthalib.builder.menu.MenuExecutor;
import java.util.Iterator;
import java.util.List;
import core.praya.agarthalib.builder.menu.MenuSlot;
import core.praya.agarthalib.builder.menu.MenuSlotAction;
import org.bukkit.entity.Player;
import com.praya.agarthalib.manager.core.CoreMenuManager;
import com.praya.agarthalib.manager.core.CoreManager;
import core.praya.agarthalib.builder.menu.Menu;
import com.praya.agarthalib.utility.CommandUtil;
import core.praya.agarthalib.builder.menu.MenuGUI;
import com.praya.agarthalib.event.MenuClickEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerMenuClick extends HandlerListener implements Listener
{
    public ListenerMenuClick(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void menuClickEvent(final MenuClickEvent event) {
        final CoreManager coreManager = this.plugin.getCoreManager();
        final CoreMenuManager coreMenuManager = coreManager.getCoreMenuManager();
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final Menu menu = event.getMenu();
            final MenuSlotAction.ActionType actionType = event.getActionType();
            final int slot = event.getSlot();
            if (menu instanceof MenuGUI) {
                final MenuGUI menuGUI = (MenuGUI)menu;
                final MenuSlot menuSlot = menuGUI.getMenuSlot(slot);
                if (menuSlot != null) {
                    final MenuSlotAction menuSlotAction = menuSlot.getMenuSlotAction(actionType);
                    if (menuSlotAction != null) {
                        final String[] args = menuSlotAction.getArguments();
                        final String openMenuID = menuSlotAction.getOpenMenu();
                        final boolean closed = menuSlotAction.isClosed();
                        final List<String> commandPlayer = menuSlotAction.getPlayerCommands();
                        final List<String> commandAdmin = menuSlotAction.getAdminCommands();
                        final List<String> commandConsole = menuSlotAction.getConsoleCommands();
                        if (!commandPlayer.isEmpty()) {
                            for (final String command : commandPlayer) {
                                CommandUtil.sudoCommand(player, command, false);
                            }
                        }
                        if (!commandAdmin.isEmpty()) {
                            for (final String command : commandAdmin) {
                                CommandUtil.sudoCommand(player, command, true);
                            }
                        }
                        if (!commandConsole.isEmpty()) {
                            for (final String command : commandConsole) {
                                CommandUtil.consoleCommand(command, player);
                            }
                        }
                        if (args != null) {
                            final MenuExecutor executor = menu.getExecutor();
                            if (executor != null) {
                                executor.onClick(player, menu, actionType, args);
                            }
                        }
                        if (openMenuID != null || closed) {
                            final MenuRegister openMenuRegister = coreMenuManager.getRegisteredMenu(openMenuID, Menu.MenuType.GUI);
                            player.closeInventory();
                            if (openMenuRegister != null) {
                                final MenuBuilder openMenuBuilder = openMenuRegister.getBuilder();
                                final Menu openMenu = openMenuBuilder.build();
                                if (openMenu instanceof MenuGUI) {
                                    final MenuGUI openMenuGUI = (MenuGUI)openMenu;
                                    final Inventory openMenuInventory = openMenuGUI.getInventory();
                                    player.openInventory(openMenuInventory);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
