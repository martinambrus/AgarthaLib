// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.custom;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import api.praya.agarthalib.builder.support.SupportHeroes;
import api.praya.agarthalib.builder.support.SupportSkillAPI;
import api.praya.agarthalib.builder.support.SupportBattleLevels;
import api.praya.agarthalib.manager.plugin.SupportManagerAPI;
import api.praya.agarthalib.manager.plugin.PluginManagerAPI;
import org.bukkit.OfflinePlayer;
import api.praya.agarthalib.main.AgarthaLibAPI;
import com.praya.agarthalib.event.PlayerHealthMaxChangeEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerCommand;

public class ListenerPlayerHealthMaxChange extends HandlerCommand implements Listener
{
    public ListenerPlayerHealthMaxChange(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void eventPlayerHealthMaxChange(final PlayerHealthMaxChangeEvent event) {
        final PluginManagerAPI pluginManagerAPI = AgarthaLibAPI.getInstance().getPluginManagerAPI();
        final SupportManagerAPI supportManagerAPI = pluginManagerAPI.getSupportManager();
        final SupportBattleLevels supportBattleLevels = supportManagerAPI.getSupportBattleLevels();
        final SupportSkillAPI supportSkillAPI = supportManagerAPI.getSupportSkillAPI();
        final SupportHeroes supportHeroes = supportManagerAPI.getSupportHeroes();
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            double maxHealth = event.getMaxHealth();
            if (supportBattleLevels != null) {
                final boolean isExtraHealthEnabled = supportBattleLevels.isExtraHealthEnabled();
                if (isExtraHealthEnabled) {
                    final double healthBattleLevels = supportBattleLevels.getExtraHealth((OfflinePlayer)player);
                    maxHealth += healthBattleLevels;
                }
            }
            if (supportSkillAPI != null) {
                final double healthSkillAPI = supportSkillAPI.getBonusStats(player, "health", maxHealth);
                maxHealth += healthSkillAPI;
            }
            if (supportHeroes != null) {
                final double healthHeroes = supportHeroes.getBonusMaxHealth(player);
                maxHealth += healthHeroes;
            }
            event.setMaxHealth(maxHealth);
        }
    }
}
