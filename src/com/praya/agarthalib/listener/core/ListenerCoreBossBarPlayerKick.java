// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.core;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import com.praya.agarthalib.manager.player.PlayerBossBarManager;
import com.praya.agarthalib.manager.player.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerKickEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerCoreBossBarPlayerKick extends HandlerListener implements Listener
{
    public ListenerCoreBossBarPlayerKick(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void bossBarKickEvent(final PlayerKickEvent event) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final PlayerManager playerManager = plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        final Player player = event.getPlayer();
        playerBossBarManager.removeBar(player);
    }
}
