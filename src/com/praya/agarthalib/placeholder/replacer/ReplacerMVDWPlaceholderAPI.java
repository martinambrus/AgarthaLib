// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.placeholder.replacer;

import org.bukkit.entity.Player;
import com.praya.agarthalib.manager.plugin.PlaceholderManager;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import org.bukkit.plugin.Plugin;
import be.maximvdw.placeholderapi.PlaceholderAPI;
import com.praya.agarthalib.AgarthaLib;

public class ReplacerMVDWPlaceholderAPI
{
    private final AgarthaLib plugin;
    private final String placeholder;
    
    public ReplacerMVDWPlaceholderAPI(final AgarthaLib plugin, final String placeholder) {
        this.plugin = plugin;
        this.placeholder = placeholder;
    }
    
    public final String getPlaceholder() {
        return this.placeholder;
    }
    
    public final void register() {
        final String identifier = String.valueOf(this.getPlaceholder()) + "_*";
        final PlaceholderReplacer placeholderReplacer = (PlaceholderReplacer)new PlaceholderReplacerMVDW();
        PlaceholderAPI.registerPlaceholder((Plugin)this.plugin, identifier, placeholderReplacer);
    }
    
    private class PlaceholderReplacerMVDW implements PlaceholderReplacer
    {
        public String onPlaceholderReplace(final PlaceholderReplaceEvent event) {
            final PlaceholderManager placeholderManager = ReplacerMVDWPlaceholderAPI.this.plugin.getPluginManager().getPlaceholderManager();
            final Player player = event.getPlayer();
            final String placeholder = event.getPlaceholder();
            final String identifier = placeholder.split(String.valueOf(ReplacerMVDWPlaceholderAPI.this.getPlaceholder()) + "_")[1];
            return placeholderManager.getReplacement(player, identifier);
        }
    }
}
