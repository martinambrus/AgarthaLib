// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.support.skillapi;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.utility.PlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import com.sucy.skill.api.event.PlayerLevelUpEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerSkillAPILevelUp extends HandlerListener implements Listener
{
    public ListenerSkillAPILevelUp(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void eventPlayerLevelUp(final PlayerLevelUpEvent event) {
        final PlayerData playerData = event.getPlayerData();
        if (playerData != null) {
            final Player player = playerData.getPlayer();
            new BukkitRunnable() {
                public void run() {
                    PlayerUtil.setMaxHealth(player);
                }
            }.runTaskLater((Plugin)this.plugin, 1L);
        }
    }
}
