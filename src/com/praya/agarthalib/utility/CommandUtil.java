// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.entity.Entity;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.HashMap;

public class CommandUtil
{
    private static final String metadataByPass = "Command_Cooldown:ByPass";
    
    public static final String getMetadataByPass() {
        return "Command_Cooldown:ByPass";
    }
    
    public static final void consoleCommandOrder(final HashMap<Integer, List<String>> order) {
        consoleCommandOrder(order, null);
    }
    
    public static final void consoleCommandOrder(final HashMap<Integer, List<String>> order, final Player player) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        if (order != null) {
            for (final int delay : order.keySet()) {
                if (delay == 0) {
                    for (final String command : order.get(delay)) {
                        consoleCommand(command, player);
                    }
                }
                else {
                    new BukkitRunnable() {
                        public void run() {
                            for (final String command : order.get(delay)) {
                                CommandUtil.consoleCommand(command, player);
                            }
                        }
                    }.runTaskLater(plugin, (long)delay);
                }
            }
        }
    }
    
    public static final void consoleCommand(final String command) {
        consoleCommand(command, null);
    }
    
    public static final void consoleCommand(String command, final Player player) {
        if (command != null) {
            final ConsoleCommandSender console = Bukkit.getConsoleSender();
            if (player != null) {
                command = TextUtil.hookPlaceholderAPI(player, command);
            }
            Bukkit.dispatchCommand((CommandSender)console, command);
        }
    }
    
    public static final void sudoCommand(final Player player, final String command, final boolean bypass) {
        if (player != null) {
            if (!player.isOp()) {
                if (bypass) {
                    setByPass(player);
                    player.setOp(true);
                    player.performCommand(command);
                    player.setOp(false);
                }
                else {
                    player.performCommand(command);
                }
            }
            else {
                player.performCommand(command);
            }
        }
    }
    
    public static final void setByPass(final Player player) {
        if (player != null) {
            MetadataUtil.setCooldown((Entity)player, getMetadataByPass(), 50L);
        }
    }
    
    public static final boolean isByPass(final Player player) {
        return player != null && MetadataUtil.hasMetadata((Entity)player, getMetadataByPass()) && MetadataUtil.isCooldown((Entity)player, getMetadataByPass());
    }
    
    @Deprecated
    public static final boolean isByPass(final Entity entity) {
        return entity != null && MetadataUtil.hasMetadata(entity, getMetadataByPass()) && MetadataUtil.isCooldown(entity, getMetadataByPass());
    }
}
