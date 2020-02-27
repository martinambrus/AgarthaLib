// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import com.praya.agarthalib.event.PlayerHealthMaxChangeEvent;
import org.bukkit.event.Event;
import com.praya.agarthalib.event.PlayerHealthChangeEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import com.praya.agarthalib.server.ServerPlayerMemory;
import java.util.UUID;
import org.bukkit.World;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import core.praya.agarthalib.bridge.unity.Bridge;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import java.util.List;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;

public class PlayerUtil
{
    public static final boolean isPlayer(final LivingEntity livingEntity) {
        return livingEntity != null && livingEntity instanceof Player;
    }
    
    public static final void sendMessage(final Player player, final String message) {
        sendMessage(player, message, true);
    }
    
    public static final void sendMessage(final Player player, String message, final boolean color) {
        if (player != null && message != null) {
            if (color) {
                message = TextUtil.colorful(message);
            }
            message = TextUtil.hookPlaceholderAPI(player, message);
            player.sendMessage(message);
        }
    }
    
    public static final void sendActionBarOrder(final Player player, final HashMap<Integer, List<String>> order) {
        sendActionBarOrder(player, true, order);
    }
    
    public static final void sendActionBarOrder(final Player player, final boolean color, final HashMap<Integer, List<String>> order) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        if (player != null && order != null) {
            for (final int delay : order.keySet()) {
                if (delay == 0) {
                    for (final String message : order.get(delay)) {
                        sendActionBar(player, message, color);
                    }
                }
                else {
                    new BukkitRunnable() {
                        public void run() {
                            for (final String message : order.get(delay)) {
                                PlayerUtil.sendActionBar(player, message, color);
                            }
                        }
                    }.runTaskLater(plugin, (long)delay);
                }
            }
        }
    }
    
    public static final void sendActionBarOrder(final Collection<Player> players, final HashMap<Integer, List<String>> order) {
        sendActionBarOrder(players, true, order);
    }
    
    public static final void sendActionBarOrder(final Collection<Player> players, final boolean color, final HashMap<Integer, List<String>> order) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        if (players != null && order != null) {
            for (final int delay : order.keySet()) {
                if (delay == 0) {
                    for (final String message : order.get(delay)) {
                        sendActionBar(players, message, color);
                    }
                }
                else {
                    new BukkitRunnable() {
                        public void run() {
                            for (final String message : order.get(delay)) {
                                PlayerUtil.sendActionBar(players, message, color);
                            }
                        }
                    }.runTaskLater(plugin, (long)delay);
                }
            }
        }
    }
    
    public static final void sendActionBar(final Player player, final String message) {
        sendActionBar(player, message, true);
    }
    
    public static final void sendActionBar(final Player player, String message, final boolean color) {
        if (player != null && message != null) {
            if (color) {
                message = TextUtil.colorful(message);
            }
            message = TextUtil.hookPlaceholderAPI(player, message);
            Bridge.getBridgeMessage().sendActionbar(player, message);
        }
    }
    
    public static final void sendActionBar(final Collection<Player> players, final String message) {
        sendActionBar(players, message, null, true);
    }
    
    public static final void sendActionBar(final Collection<Player> players, final String message, final Player player) {
        sendActionBar(players, message, player, true);
    }
    
    public static final void sendActionBar(final Collection<Player> players, final String message, final boolean color) {
        sendActionBar(players, message, null, color);
    }
    
    public static final void sendActionBar(final Collection<Player> players, String message, final Player player, final boolean color) {
        if (players != null && message != null) {
            message = TextUtil.hookPlaceholderAPI(player, message);
            sendActionBar(players, message, color);
        }
    }
    
    @Deprecated
    public static final void sendActionBar(final Collection<Player> players, final Player player, final String message) {
        sendActionBar(players, player, message, true);
    }
    
    @Deprecated
    public static final void sendActionBar(final Collection<Player> players, final Player player, String message, final boolean color) {
        if (players != null && message != null) {
            if (player != null) {
                message = TextUtil.hookPlaceholderAPI(player, message);
            }
            sendActionBar(players, message, color);
        }
    }
    
    public static final void sendJsonOrder(final Collection<Player> players, final HashMap<Integer, List<String>> order) {
        sendJsonOrder(players, order, null);
    }
    
    public static final void sendJsonOrder(final Collection<Player> players, final HashMap<Integer, List<String>> order, final Player player) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        if (players != null && order != null) {
            for (final int delay : order.keySet()) {
                if (delay == 0) {
                    for (final String message : order.get(delay)) {
                        sendJson(players, message, player);
                    }
                }
                else {
                    new BukkitRunnable() {
                        public void run() {
                            for (final String message : order.get(delay)) {
                                PlayerUtil.sendJson(players, message, player);
                            }
                        }
                    }.runTaskLater(plugin, (long)delay);
                }
            }
        }
    }
    
    public static final void sendJson(final Collection<Player> players, final String message) {
        sendJson(players, message, null);
    }
    
    public static final void sendJson(final Collection<Player> players, String message, final Player player) {
        if (players != null && message != null) {
            message = TextUtil.hookPlaceholderAPI(player, message);
            Bridge.getBridgeMessage().sendJson(players, message);
        }
    }
    
    public static final void sendJsonOrder(final Player player, final HashMap<Integer, List<String>> order) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        if (player != null && order != null) {
            for (final int delay : order.keySet()) {
                if (delay == 0) {
                    for (final String message : order.get(delay)) {
                        sendJson(player, message);
                    }
                }
                else {
                    new BukkitRunnable() {
                        public void run() {
                            for (final String message : order.get(delay)) {
                                PlayerUtil.sendJson(player, message);
                            }
                        }
                    }.runTaskLater(plugin, (long)delay);
                }
            }
        }
    }
    
    public static final void sendJson(final Player player, String message) {
        if (player != null && message != null) {
            message = TextUtil.hookPlaceholderAPI(player, message);
            Bridge.getBridgeMessage().sendJson(player, message);
        }
    }
    
    public static final void sendTitle(final Player player, String message, final int fadeIn, final int stay, final int fadeOut) {
        if (player != null && message != null) {
            message = TextUtil.colorful(message);
            Bridge.getBridgeMessage().sendTitle(player, message, fadeIn, stay, fadeOut);
        }
    }
    
    public static final void sendTitle(final Collection<Player> players, String message, final int fadeIn, final int stay, final int fadeOut) {
        if (players != null && message != null) {
            message = TextUtil.colorful(message);
            Bridge.getBridgeMessage().sendTitle(players, message, fadeIn, stay, fadeOut);
        }
    }
    
    public static final void sendSubtitle(final Player player, String message, final int fadeIn, final int stay, final int fadeOut) {
        if (player != null && message != null) {
            message = TextUtil.colorful(message);
            Bridge.getBridgeMessage().sendSubtitle(player, message, fadeIn, stay, fadeOut);
        }
    }
    
    public static final void sendSubtitle(final Collection<Player> players, String message, final int fadeIn, final int stay, final int fadeOut) {
        if (players != null && message != null) {
            message = TextUtil.colorful(message);
            Bridge.getBridgeMessage().sendSubtitle(players, message, fadeIn, stay, fadeOut);
        }
    }
    
    public static final Player parse(final LivingEntity entity) {
        return isPlayer(entity) ? ((Player)entity) : null;
    }
    
    public static final Player parse(final HumanEntity human) {
        return isPlayer((LivingEntity)human) ? ((Player)human) : null;
    }
    
    public static final Player parse(final CommandSender sender) {
        return (sender != null && sender instanceof Player) ? ((Player)sender) : null;
    }
    
    public static final Collection<Player> getNearbyPlayers(final Location location, final double distance) {
        final Collection<Player> players = new ArrayList<Player>();
        if (location != null) {
            final World world = location.getWorld();
            for (final Player player : getOnlinePlayers()) {
                if (player.getWorld().equals(world) && player.getLocation().distance(location) <= distance) {
                    players.add(player);
                }
            }
        }
        return players;
    }
    
    public static final Player getOnlinePlayer(final String playerName) {
        if (playerName != null) {
            for (final Player player : getOnlinePlayers()) {
                if (player.getName().equalsIgnoreCase(playerName)) {
                    return player;
                }
            }
        }
        return null;
    }
    
    public static final Player getOnlinePlayer(final UUID playerID) {
        if (playerID != null) {
            for (final Player player : getOnlinePlayers()) {
                if (player.getUniqueId().equals(playerID)) {
                    return player;
                }
            }
        }
        return null;
    }
    
    public static final boolean isOnline(final String playerName) {
        return getOnlinePlayer(playerName) != null;
    }
    
    public static final boolean isOnline(final UUID playerID) {
        return getOnlinePlayer(playerID) != null;
    }
    
    public static final boolean isOnline(final Player player) {
        return player != null && player.isOnline();
    }
    
    public static final Collection<Player> getOnlinePlayers() {
        final ServerPlayerMemory serverPlayerMemory = ServerPlayerMemory.getInstance();
        return serverPlayerMemory.getOnlinePlayers();
    }
    
    public static final OfflinePlayer getPlayer(final String playerName) {
        if (playerName != null) {
            OfflinePlayer[] offlinePlayers;
            for (int length = (offlinePlayers = Bukkit.getOfflinePlayers()).length, i = 0; i < length; ++i) {
                final OfflinePlayer player = offlinePlayers[i];
                if (player.getName().equalsIgnoreCase(playerName)) {
                    return player;
                }
            }
        }
        return null;
    }
    
    public static final OfflinePlayer getPlayer(final UUID playerID) {
        if (playerID != null) {
            OfflinePlayer[] offlinePlayers;
            for (int length = (offlinePlayers = Bukkit.getOfflinePlayers()).length, i = 0; i < length; ++i) {
                final OfflinePlayer player = offlinePlayers[i];
                if (player.getUniqueId().equals(playerID)) {
                    return player;
                }
            }
        }
        return null;
    }
    
    public static String getPlayerName(final String playerName) {
        final OfflinePlayer player = getPlayer(playerName);
        return (player != null) ? player.getName() : null;
    }
    
    public static boolean isPlayerExist(final String playerName) {
        return getPlayer(playerName) != null;
    }
    
    public static boolean isPlayerExist(final UUID playerID) {
        return getPlayer(playerID) != null;
    }
    
    public static final boolean hasItem(final Player player, final ItemStack item) {
        return hasItem(player, item, 1);
    }
    
    public static final boolean hasItem(final Player player, final ItemStack item, final int total) {
        return player != null && item != null && InventoryUtil.containsItem((Inventory)player.getInventory(), item, total);
    }
    
    public static final void addItem(final Player player, final ItemStack item) {
        if (player != null && item != null) {
            final PlayerInventory inventory = player.getInventory();
            inventory.addItem(new ItemStack[] { item });
        }
    }
    
    @Deprecated
    public static final void addItem(final Player player, final ItemStack item, final boolean natural) {
        addItem(player, item);
    }
    
    public static final void removeItem(final Player player, final ItemStack item) {
        removeItem(player, item, 1);
    }
    
    public static final void removeItem(final Player player, final ItemStack item, final int total) {
        if (player != null && item != null) {
            InventoryUtil.removeItem((Inventory)player.getInventory(), item, total);
            player.updateInventory();
        }
    }
    
    public static final Collection<Player> toCollection(final Player player) {
        final Collection<Player> collection = new ArrayList<Player>();
        if (player != null) {
            collection.add(player);
        }
        return collection;
    }
    
    public static final void setHealth(final Player player, final double health) {
        if (player != null) {
            final PlayerHealthChangeEvent playerHealthChangeEvent = new PlayerHealthChangeEvent(player, health);
            ServerEventUtil.callEvent((Event)playerHealthChangeEvent);
        }
    }
    
    public static final void setMaxHealth(final Player player) {
        setMaxHealth(player, 20.0);
    }
    
    public static final void setMaxHealth(final Player player, final double maxHealth) {
        if (player != null) {
            final PlayerHealthMaxChangeEvent eventPlayerHealthMaxChange = new PlayerHealthMaxChangeEvent(player, maxHealth);
            ServerEventUtil.callEvent((Event)eventPlayerHealthMaxChange);
            if (!eventPlayerHealthMaxChange.isCancelled()) {
                final double eventMaxHealth = eventPlayerHealthMaxChange.getMaxHealth();
                EntityUtil.setMaxHealth((LivingEntity)player, eventMaxHealth);
            }
        }
    }
    
    public static final void setHealthScale(final Player player, double healthScale) {
        if (player != null) {
            healthScale = Math.max(1.0, healthScale);
            player.setHealthScale(healthScale);
            player.setHealthScaled(true);
        }
    }
    
    public static final void resetHealthScale(final Player player) {
        if (player != null) {
            player.setHealthScale(20.0);
            player.setHealthScaled(false);
        }
    }
}
