// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import core.praya.agarthalib.builder.stats.StatsEntity;
import com.praya.agarthalib.manager.game.StatsEntityManager;
import com.praya.agarthalib.manager.game.GameManager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import com.praya.agarthalib.server.ServerPlayerMemory;
import org.bukkit.event.player.PlayerQuitEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerCommand;

public class ListenerPlayerQuit extends HandlerCommand implements Listener
{
    public ListenerPlayerQuit(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler
    public void unregisterPlayer(final PlayerQuitEvent event) {
        final ServerPlayerMemory serverPlayerMemory = ServerPlayerMemory.getInstance();
        final Player player = event.getPlayer();
        serverPlayerMemory.unregister(player);
    }
    
    @EventHandler
    public void unregisterStatsEntity(final PlayerQuitEvent event) {
        final GameManager gameManager = this.plugin.getGameManager();
        final StatsEntityManager statsEntityManager = gameManager.getStatsEntityManager();
        final Player player = event.getPlayer();
        final StatsEntity statsEntity = statsEntityManager.getStatsEntity((LivingEntity)player);
        if (statsEntity != null) {
            statsEntity.unregister();
        }
    }
}
