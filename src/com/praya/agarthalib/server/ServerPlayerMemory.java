// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.server;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.entity.Player;
import java.util.UUID;
import java.util.HashMap;
import com.praya.agarthalib.manager.server.ServerPlayerManager;

public final class ServerPlayerMemory extends ServerPlayerManager
{
    private final HashMap<UUID, Player> mapOnlinePlayers;
    
    private ServerPlayerMemory(final AgarthaLib plugin) {
        super(plugin);
        this.mapOnlinePlayers = new HashMap<UUID, Player>();
    }
    
    public static final ServerPlayerMemory getInstance() {
        return ServerPlayerMemorySingleton.INSTANCE;
    }
    
    @Override
    public final Collection<UUID> getOnlinePlayerIds() {
        return new ArrayList<UUID>(this.mapOnlinePlayers.keySet());
    }
    
    @Override
    public Collection<Player> getOnlinePlayers() {
        return new ArrayList<Player>(this.mapOnlinePlayers.values());
    }
    
    @Override
    public Player getOnlinePlayer(final UUID playerId) {
        return this.mapOnlinePlayers.get(playerId);
    }
    
    public final boolean register(final Player player) {
        if (player != null) {
            final UUID playerId = player.getUniqueId();
            this.mapOnlinePlayers.put(playerId, player);
            return true;
        }
        return false;
    }
    
    public final boolean unregister(final Player player) {
        if (player != null) {
            final UUID playerId = player.getUniqueId();
            return this.mapOnlinePlayers.remove(playerId, player);
        }
        return false;
    }
    
    private static class ServerPlayerMemorySingleton
    {
        private static final ServerPlayerMemory INSTANCE;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            INSTANCE = new ServerPlayerMemory(plugin);
        }
    }
}
