// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.manager.plugin;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public class PluginManagerAPI extends HandlerManager
{
    private final SupportManagerAPI supportManager;
    
    public PluginManagerAPI(final AgarthaLib plugin) {
        super(plugin);
        this.supportManager = new SupportManagerAPI(plugin);
    }
    
    public final SupportManagerAPI getSupportManager() {
        return this.supportManager;
    }
}
