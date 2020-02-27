// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.player;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public class PlayerManager extends HandlerManager
{
    private final PlayerBossBarManager playerBossBarManager;
    private final PlayerMessageManager playerMessageManager;
    private final PlayerSwingManager playerSwingManager;
    
    public PlayerManager(final AgarthaLib plugin) {
        super(plugin);
        this.playerBossBarManager = new PlayerBossBarManager(plugin);
        this.playerMessageManager = new PlayerMessageManager(plugin);
        this.playerSwingManager = new PlayerSwingManager(plugin);
    }
    
    public final PlayerBossBarManager getPlayerBossBarManager() {
        return this.playerBossBarManager;
    }
    
    public final PlayerMessageManager getPlayerMessageManager() {
        return this.playerMessageManager;
    }
    
    public final PlayerSwingManager getPlayerSwingManager() {
        return this.playerSwingManager;
    }
}
