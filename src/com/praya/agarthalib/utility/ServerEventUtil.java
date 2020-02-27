// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.plugin.PluginManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class ServerEventUtil
{
    public static final void registerEvent(final Plugin plugin, final Listener listener) {
        if (plugin != null && listener != null) {
            final PluginManager pluginManager = Bukkit.getServer().getPluginManager();
            pluginManager.registerEvents(listener, plugin);
        }
    }
    
    @Deprecated
    public static final void registerEvent(final Listener listener) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        registerEvent(plugin, listener);
    }
    
    public static final void callEvent(final Event event) {
        if (event != null) {
            final PluginManager pluginManager = Bukkit.getServer().getPluginManager();
            pluginManager.callEvent(event);
        }
    }
}
