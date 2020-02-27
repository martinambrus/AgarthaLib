// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.main;

import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.manager.player.PlayerManagerAPI;
import api.praya.agarthalib.manager.plugin.PluginManagerAPI;

public class AgarthaLibAPI
{
    private final PluginManagerAPI pluginManagerAPI;
    private final PlayerManagerAPI playerManagerAPI;
    
    private AgarthaLibAPI(final AgarthaLib plugin) {
        this.pluginManagerAPI = new PluginManagerAPI(plugin);
        this.playerManagerAPI = new PlayerManagerAPI(plugin);
    }
    
    public static final AgarthaLibAPI getInstance() {
        return AgarthaLibAPIHelper.instance;
    }
    
    public final PluginManagerAPI getPluginManagerAPI() {
        return this.pluginManagerAPI;
    }
    
    public final PlayerManagerAPI getPlayerManagerAPI() {
        return this.playerManagerAPI;
    }
    
    private static class AgarthaLibAPIHelper
    {
        private static final AgarthaLibAPI instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new AgarthaLibAPI(plugin);
        }
    }
}
