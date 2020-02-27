// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.plugin;

import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.utility.SystemUtil;
import java.util.Iterator;
import core.praya.agarthalib.builder.plugin.PluginTypePropertiesBuild;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import core.praya.agarthalib.builder.plugin.PluginPropertiesStreamBuild;
import core.praya.agarthalib.builder.plugin.PluginPropertiesResourceBuild;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class PluginPropertiesManager extends HandlerManager
{
    protected PluginPropertiesManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    protected abstract PluginPropertiesResourceBuild getPluginPropertiesResource();
    
    protected abstract PluginPropertiesStreamBuild getPluginPropertiesStream();
    
    public abstract Collection<String> getPluginIds();
    
    public abstract Collection<PluginPropertiesStreamBuild> getAllPluginProperties();
    
    public abstract PluginPropertiesStreamBuild getPluginProperties(final String p0);
    
    public final List<String> getAllPluginType() {
        final PluginPropertiesStreamBuild pluginPropertiesStream = this.getPluginPropertiesStream();
        final List<String> listType = new ArrayList<String>(pluginPropertiesStream.getTypeIDs());
        return listType;
    }
    
    public final PluginTypePropertiesBuild getPluginTypeProperties(final String type) {
        if (type != null) {
            for (final String key : this.getAllPluginType()) {
                if (key.equalsIgnoreCase(type)) {
                    return this.getPluginPropertiesStream().getTypeProperties(type);
                }
            }
        }
        return null;
    }
    
    public final boolean isPluginTypeExists(final String type) {
        return this.getPluginTypeProperties(type) != null;
    }
    
    public final String getPluginName() {
        return this.getPluginPropertiesStream().getName();
    }
    
    public final String getPluginVersion() {
        final String pluginType = this.plugin.getPluginType();
        return this.getPluginVersion(pluginType);
    }
    
    public final String getPluginVersion(final String type) {
        final PluginTypePropertiesBuild pluginTypeProperties = this.getPluginTypeProperties(type);
        return (pluginTypeProperties != null) ? pluginTypeProperties.getVersion() : this.getPluginPropertiesResource().getVersion();
    }
    
    public final String getPluginCompany() {
        return this.getPluginPropertiesStream().getCompany();
    }
    
    public final String getPluginAuthor() {
        return this.getPluginPropertiesStream().getAuthor();
    }
    
    public final String getPluginWebsite() {
        final String pluginType = this.plugin.getPluginType();
        return this.getPluginWebsite(pluginType);
    }
    
    public final String getPluginWebsite(final String type) {
        final PluginTypePropertiesBuild pluginTypeProperties = this.getPluginTypeProperties(type);
        return (pluginTypeProperties != null) ? pluginTypeProperties.getWebsite() : this.getPluginPropertiesResource().getWebsite();
    }
    
    public final List<String> getPluginDevelopers() {
        return this.getPluginPropertiesStream().getDevelopers();
    }
    
    public final boolean isLatestVersion() {
        final String type = this.plugin.getPluginType();
        final String versionLatest = this.getPluginVersion(type);
        final String versionCurrent = this.plugin.getPluginVersion();
        return versionLatest.equalsIgnoreCase(versionCurrent);
    }
    
    public final boolean isActivated() {
        return this.getPluginPropertiesStream().isActivated();
    }
    
    public final void check() {
        final PluginManager pluginManager = this.plugin.getPluginManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        if (!this.isActivated()) {
            final String message = lang.getText("Plugin_Deactivated");
            this.disable(message);
            return;
        }
        if (!this.checkPluginName() || !this.checkPluginAuthor()) {
            final String message = lang.getText("Plugin_Information_Not_Match");
            this.disable(message);
        }
    }
    
    private final boolean checkPluginName() {
        final String pluginName = this.getPluginName();
        if (pluginName != null) {
            final String pluginNameResource = this.getPluginPropertiesResource().getName();
            if (!pluginName.equals(pluginNameResource)) {
                return false;
            }
        }
        return true;
    }
    
    private final boolean checkPluginAuthor() {
        final String pluginAuthor = this.getPluginAuthor();
        if (pluginAuthor != null) {
            final String pluginAuthorResource = this.getPluginPropertiesResource().getAuthor();
            if (!pluginAuthor.equals(pluginAuthorResource)) {
                return false;
            }
        }
        return true;
    }
    
    private final void disable(final String message) {
        final PluginLoader pluginLoader = this.plugin.getPluginLoader();
        if (message != null) {
            SystemUtil.sendMessage(message);
        }
        pluginLoader.disablePlugin((Plugin)this.plugin);
    }
}
