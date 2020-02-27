// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.placeholder.replacer;

import com.praya.agarthalib.manager.plugin.PlaceholderManager;
import org.bukkit.entity.Player;
import me.clip.placeholderapi.PlaceholderAPI;
import com.praya.agarthalib.AgarthaLib;
import me.clip.placeholderapi.PlaceholderHook;

public class ReplacerPlaceholderAPI extends PlaceholderHook
{
    private final String placeholder;
    private final AgarthaLib plugin;
    
    public ReplacerPlaceholderAPI(final AgarthaLib plugin, final String placeholder) {
        this.plugin = plugin;
        this.placeholder = placeholder;
    }
    
    public final String getPlaceholder() {
        return this.placeholder;
    }
    
    public final boolean hook() {
        return PlaceholderAPI.registerPlaceholderHook(this.placeholder, (PlaceholderHook)this);
    }
    
    public String onPlaceholderRequest(final Player player, final String identifier) {
        final PlaceholderManager placeholderManager = this.plugin.getPluginManager().getPlaceholderManager();
        return placeholderManager.getReplacement(player, identifier);
    }
}
