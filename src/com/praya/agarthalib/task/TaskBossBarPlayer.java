// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.task;

import core.praya.agarthalib.builder.message.BossBar;
import java.util.Iterator;
import com.praya.agarthalib.manager.player.PlayerBossBarManager;
import com.praya.agarthalib.manager.player.PlayerManager;
import org.bukkit.entity.Player;
import com.praya.agarthalib.utility.PlayerUtil;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerTask;

public class TaskBossBarPlayer extends HandlerTask implements Runnable
{
    public TaskBossBarPlayer(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void run() {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerBossBarManager playerBossBarManager = playerManager.getPlayerBossBarManager();
        for (final Player player : PlayerUtil.getOnlinePlayers()) {
            final BossBar bar = playerBossBarManager.getBossBar(player);
            if (bar != null) {
                bar.updateMovement();
            }
        }
    }
}
