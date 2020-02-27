// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.HashMap;

public class SystemUtil
{
    public static final void sendMessageOrder(final HashMap<Integer, List<String>> order) {
        sendMessageOrder(order, null);
    }
    
    public static final void sendMessageOrder(final HashMap<Integer, List<String>> order, final Player player) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        if (order != null) {
            for (final int delay : order.keySet()) {
                if (delay == 0) {
                    for (final String message : order.get(delay)) {
                        sendMessage(message, player);
                    }
                }
                else {
                    new BukkitRunnable() {
                        public void run() {
                            for (final String message : order.get(delay)) {
                                SystemUtil.sendMessage(message, player);
                            }
                        }
                    }.runTaskLater(plugin, (long)delay);
                }
            }
        }
    }
    
    public static final void sendMessage(final String message) {
        sendMessage(message, null);
    }
    
    public static final void sendMessage(String message, final Player player) {
        if (message != null) {
            final ConsoleCommandSender console = Bukkit.getConsoleSender();
            message = TextUtil.hookPlaceholderAPI(player, message);
            message = JsonUtil.clearJson(message);
            message = TextUtil.colorful(message);
            console.sendMessage(message);
        }
    }
}
