// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.support.skillapi;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import com.sucy.skill.api.player.PlayerAccounts;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.utility.PlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import com.sucy.skill.api.event.PlayerAccountChangeEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerSkillAPIAccountChange extends HandlerListener implements Listener
{
    public ListenerSkillAPIAccountChange(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void eventPlayerAccountChange(final PlayerAccountChangeEvent event) {
        if (!event.isCancelled()) {
            final PlayerAccounts playerAccount = event.getAccountData();
            if (playerAccount != null) {
                final Player player = playerAccount.getPlayer();
                new BukkitRunnable() {
                    public void run() {
                        PlayerUtil.setMaxHealth(player);
                    }
                }.runTaskLater((Plugin)this.plugin, 1L);
            }
        }
    }
}
