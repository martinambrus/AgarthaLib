// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.player;

import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.entity.Player;
import java.util.HashMap;
import com.praya.agarthalib.AgarthaLib;
import java.util.UUID;
import java.util.Map;
import com.praya.agarthalib.handler.HandlerManager;

public class PlayerSwingManager extends HandlerManager
{
    private final Map<UUID, Float> mapPlayerSwing;
    
    public PlayerSwingManager(final AgarthaLib plugin) {
        super(plugin);
        this.mapPlayerSwing = new HashMap<UUID, Float>();
    }
    
    public final float getPlayerSwing(final Player player) {
        if (player != null) {
            final UUID playerID = player.getUniqueId();
            return this.mapPlayerSwing.containsKey(playerID) ? this.mapPlayerSwing.get(playerID) : 1.0f;
        }
        return 1.0f;
    }
    
    public final void updatePlayerSwing(final Player player) {
        if (player != null) {
            final UUID playerID = player.getUniqueId();
            final float swing = Bridge.getBridgePlayer().getSwingProgress(player);
            this.mapPlayerSwing.put(playerID, swing);
        }
    }
}
