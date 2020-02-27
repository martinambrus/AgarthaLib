// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.manager.player;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public class PlayerManagerAPI extends HandlerManager
{
    private final PlayerActionbarManagerAPI playerActionbarManager;
    
    public PlayerManagerAPI(final AgarthaLib plugin) {
        super(plugin);
        this.playerActionbarManager = new PlayerActionbarManagerAPI(plugin);
    }
    
    public final PlayerActionbarManagerAPI getPlayerActionbarManager() {
        return this.playerActionbarManager;
    }
}
