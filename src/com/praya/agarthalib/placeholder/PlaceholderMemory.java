// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.placeholder;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.manager.plugin.PlaceholderManager;

public class PlaceholderMemory extends PlaceholderManager
{
    private final PlaceholderConfig placeholderConfig;
    
    private PlaceholderMemory(final AgarthaLib plugin) {
        super(plugin);
        this.placeholderConfig = new PlaceholderConfig(plugin);
    }
    
    public static final PlaceholderMemory getInstance() {
        return PlaceholderMemorySingleton.instance;
    }
    
    public final PlaceholderConfig getPlaceholderConfig() {
        return this.placeholderConfig;
    }
    
    @Override
    protected final HashMap<String, String> getMapPlaceholder() {
        return this.getPlaceholderConfig().mapPlaceholder;
    }
    
    @Override
    public final Collection<String> getPlaceholderIds() {
        return this.getPlaceholderConfig().mapPlaceholder.keySet();
    }
    
    @Override
    public final Collection<String> getPlaceholders() {
        return this.getPlaceholderConfig().mapPlaceholder.values();
    }
    
    @Override
    public final String getPlaceholder(final String id) {
        for (final String key : this.getPlaceholderIds()) {
            if (key.equalsIgnoreCase(id)) {
                return this.getPlaceholderConfig().mapPlaceholder.get(id);
            }
        }
        return null;
    }
    
    private static class PlaceholderMemorySingleton
    {
        private static final PlaceholderMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new PlaceholderMemory(plugin);
        }
    }
}
