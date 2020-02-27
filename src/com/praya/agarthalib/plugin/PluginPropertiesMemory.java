// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.plugin;

import java.util.Iterator;
import java.util.Collection;
import org.bukkit.plugin.java.JavaPlugin;
import core.praya.agarthalib.builder.plugin.PluginPropertiesBuild;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.plugin.PluginPropertiesStreamBuild;
import core.praya.agarthalib.builder.plugin.PluginPropertiesResourceBuild;
import com.praya.agarthalib.manager.plugin.PluginPropertiesManager;

public class PluginPropertiesMemory extends PluginPropertiesManager
{
    private final PluginPropertiesConfig pluginPropertiesConfig;
    private final PluginPropertiesResourceBuild pluginPropertiesResource;
    private final PluginPropertiesStreamBuild pluginPropertiesStream;
    
    private PluginPropertiesMemory(final AgarthaLib plugin) {
        super(plugin);
        final String name = plugin.getName();
        final PluginPropertiesConfig pluginPropertiesConfig = new PluginPropertiesConfig(plugin);
        final PluginPropertiesResourceBuild pluginPropertiesResource = PluginPropertiesBuild.getPluginPropertiesResource(plugin, plugin.getPluginType(), plugin.getPluginVersion());
        final PluginPropertiesStreamBuild pluginPropertiesStream = pluginPropertiesConfig.mapPluginProperties.get(name);
        this.pluginPropertiesConfig = pluginPropertiesConfig;
        this.pluginPropertiesResource = pluginPropertiesResource;
        this.pluginPropertiesStream = ((pluginPropertiesStream != null) ? pluginPropertiesStream : new PluginPropertiesStreamBuild());
    }
    
    public static final PluginPropertiesMemory getInstance() {
        return PluginPropertiesMemorySingleton.instance;
    }
    
    public final PluginPropertiesConfig getPluginPropertiesConfig() {
        return this.pluginPropertiesConfig;
    }
    
    public final PluginPropertiesResourceBuild getPluginPropertiesResource() {
        return this.pluginPropertiesResource;
    }
    
    public final PluginPropertiesStreamBuild getPluginPropertiesStream() {
        return this.pluginPropertiesStream;
    }
    
    @Override
    public final Collection<String> getPluginIds() {
        return this.getPluginPropertiesConfig().mapPluginProperties.keySet();
    }
    
    @Override
    public final Collection<PluginPropertiesStreamBuild> getAllPluginProperties() {
        return this.getPluginPropertiesConfig().mapPluginProperties.values();
    }
    
    @Override
    public final PluginPropertiesStreamBuild getPluginProperties(final String id) {
        if (id != null) {
            for (final String key : this.getPluginIds()) {
                if (key.equalsIgnoreCase(id)) {
                    return this.getPluginPropertiesConfig().mapPluginProperties.get(key);
                }
            }
        }
        return null;
    }
    
    private static class PluginPropertiesMemorySingleton
    {
        private static final PluginPropertiesMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new PluginPropertiesMemory(plugin);
        }
    }
}
