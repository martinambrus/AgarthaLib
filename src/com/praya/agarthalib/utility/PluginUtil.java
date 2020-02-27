// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.Iterator;
import java.util.List;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class PluginUtil
{
    public static final Plugin getPlugin(final String pluginName) {
        return getPlugin(pluginName, null);
    }
    
    public static final Plugin getPlugin(final String pluginName, final String pluginAuthor) {
        return getPlugin(pluginName, pluginAuthor, null);
    }
    
    public static final Plugin getPlugin(final String pluginName, final String pluginAuthor, final String pluginMain) {
        Plugin[] plugins;
        for (int length = (plugins = Bukkit.getPluginManager().getPlugins()).length, i = 0; i < length; ++i) {
            final Plugin plugin = plugins[i];
            final boolean isMatchPluginName = pluginName == null || matchPluginName(plugin, pluginName);
            final boolean isMatchPluginAuthor = pluginAuthor == null || matchPluginAuthor(plugin, pluginAuthor);
            final boolean isMatchPluginMain = pluginMain == null || matchPluginMain(plugin, pluginMain);
            if (isMatchPluginName && isMatchPluginAuthor && isMatchPluginMain) {
                return plugin;
            }
        }
        return null;
    }
    
    public static final boolean isPluginInstalled(final String pluginName) {
        return isPluginInstalled(pluginName, null);
    }
    
    public static final boolean isPluginInstalled(final String pluginName, final String pluginAuthor) {
        return isPluginInstalled(pluginName, pluginAuthor, null);
    }
    
    public static final boolean isPluginInstalled(final String pluginName, final String pluginAuthor, final String pluginMain) {
        return getPlugin(pluginName, pluginAuthor, pluginMain) != null;
    }
    
    private static final boolean matchPluginName(final Plugin plugin, final String pluginName) {
        return plugin != null && pluginName != null && plugin.getName().equalsIgnoreCase(pluginName);
    }
    
    private static final boolean matchPluginMain(final Plugin plugin, final String pluginMain) {
        if (plugin != null && pluginMain != null) {
            final PluginDescriptionFile pluginDescritionFile = plugin.getDescription();
            return pluginDescritionFile.getMain().equalsIgnoreCase(pluginMain);
        }
        return false;
    }
    
    private static final boolean matchPluginAuthor(final Plugin plugin, final String pluginAuthor) {
        if (plugin != null && pluginAuthor != null) {
            final PluginDescriptionFile pluginDescritionFile = plugin.getDescription();
            final List<String> authors = (List<String>)pluginDescritionFile.getAuthors();
            for (final String author : authors) {
                if (author.equalsIgnoreCase(pluginAuthor)) {
                    return true;
                }
            }
        }
        return false;
    }
}
