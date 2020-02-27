// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.server;

import java.util.Iterator;
import org.bukkit.entity.Player;
import java.util.UUID;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class ServerPlayerManager extends HandlerManager
{
    protected ServerPlayerManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract Collection<UUID> getOnlinePlayerIds();
    
    public abstract Collection<Player> getOnlinePlayers();
    
    public abstract Player getOnlinePlayer(final UUID p0);
    
    public Player getOnlinePlayer(final String player) {
        if (player != null) {
            for (final Player key : this.getOnlinePlayers()) {
                if (key.getName().equalsIgnoreCase(player)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public final boolean isPlayerOnline(final String player) {
        return this.getOnlinePlayer(player) != null;
    }
    
    public final boolean isPlayerOnline(final UUID playerId) {
        return this.getOnlinePlayer(playerId) != null;
    }
}
