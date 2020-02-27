// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.task;

import java.util.Iterator;
import com.praya.agarthalib.manager.player.PlayerSwingManager;
import com.praya.agarthalib.manager.player.PlayerManager;
import org.bukkit.entity.Player;
import com.praya.agarthalib.utility.PlayerUtil;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerTask;

public class TaskPlayerSwing extends HandlerTask implements Runnable
{
    public TaskPlayerSwing(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void run() {
        final PlayerManager playerManager = this.plugin.getPlayerManager();
        final PlayerSwingManager playerSwingManager = playerManager.getPlayerSwingManager();
        for (final Player player : PlayerUtil.getOnlinePlayers()) {
            playerSwingManager.updatePlayerSwing(player);
        }
    }
}
