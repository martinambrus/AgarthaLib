// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.plugin;

import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import java.util.Iterator;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.Collection;
import core.praya.agarthalib.builder.plugin.PluginTypePropertiesBuild;
import java.util.ArrayList;
import com.praya.agarthalib.utility.FileUtil;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.plugin.PluginPropertiesStreamBuild;
import java.util.HashMap;
import com.praya.agarthalib.handler.HandlerConfig;

public class PluginPropertiesConfig extends HandlerConfig
{
    private static final String URL_PROPERTIES = "https://pastebin.com/raw/8xp3SRnF";
    protected final HashMap<String, PluginPropertiesStreamBuild> mapPluginProperties;
    
    protected PluginPropertiesConfig(final AgarthaLib plugin) {
        super(plugin);
        this.mapPluginProperties = new HashMap<String, PluginPropertiesStreamBuild>();
        this.setup();
    }
    
    @Override
    public final void setup() {
        this.reset();
        this.loadConfig();
    }
    
    private final void reset() {
        this.mapPluginProperties.clear();
    }
    
    private final void loadConfig() {
        final FileConfiguration config = FileUtil.getFileConfigurationURL("https://pastebin.com/raw/8xp3SRnF");
        if (config != null) {
            String author = null;
            String owner = null;
            String company = null;
            String website = null;
            for (final String key : config.getKeys(false)) {
                if (key.equalsIgnoreCase("Configuration")) {
                    final ConfigurationSection dataSection = config.getConfigurationSection(key);
                    for (final String data : dataSection.getKeys(false)) {
                        if (data.equalsIgnoreCase("Author")) {
                            author = dataSection.getString(data);
                        }
                        else if (data.equalsIgnoreCase("Owner")) {
                            owner = dataSection.getString(data);
                        }
                        else if (data.equalsIgnoreCase("Company")) {
                            company = dataSection.getString(data);
                        }
                        else {
                            if (!data.equalsIgnoreCase("Website")) {
                                continue;
                            }
                            website = dataSection.getString(data);
                        }
                    }
                }
            }
            for (final String key : config.getKeys(false)) {
                if (key.equalsIgnoreCase("Configuration")) {
                    final ConfigurationSection dataSection = config.getConfigurationSection(key);
                    for (final String data : dataSection.getKeys(false)) {
                        if (data.equalsIgnoreCase("Plugins")) {
                            final ConfigurationSection pluginNameSection = dataSection.getConfigurationSection(data);
                            for (final String pluginName : pluginNameSection.getKeys(false)) {
                                final ConfigurationSection pluginDataSection = pluginNameSection.getConfigurationSection(pluginName);
                                final List<String> developer = new ArrayList<String>();
                                final HashMap<String, PluginTypePropertiesBuild> mapPluginTypeProperties = new HashMap<String, PluginTypePropertiesBuild>();
                                boolean activated = true;
                                for (final String pluginData : pluginDataSection.getKeys(false)) {
                                    if (pluginData.equalsIgnoreCase("Activated")) {
                                        activated = pluginDataSection.getBoolean(pluginData);
                                    }
                                    else if (pluginData.equalsIgnoreCase("Developer")) {
                                        final List<String> pluginDeveloper = (List<String>)pluginDataSection.getStringList(pluginData);
                                        developer.addAll(pluginDeveloper);
                                    }
                                    else {
                                        if (!pluginData.equalsIgnoreCase("Type")) {
                                            continue;
                                        }
                                        final ConfigurationSection pluginTypeSection = pluginDataSection.getConfigurationSection(pluginData);
                                        for (final String pluginType : pluginTypeSection.getKeys(false)) {
                                            final ConfigurationSection pluginTypeDataSection = pluginTypeSection.getConfigurationSection(pluginType);
                                            String pluginVersion = null;
                                            String pluginWebsite = website;
                                            String pluginPriceSymbol = "Euro";
                                            double pluginPriceValue = 0.0;
                                            for (final String pluginTypeData : pluginTypeDataSection.getKeys(false)) {
                                                if (pluginTypeData.equalsIgnoreCase("Version")) {
                                                    pluginVersion = pluginTypeDataSection.getString(pluginTypeData);
                                                }
                                                else if (pluginTypeData.equalsIgnoreCase("Website")) {
                                                    pluginWebsite = pluginTypeDataSection.getString(pluginTypeData);
                                                }
                                                else if (pluginTypeData.equalsIgnoreCase("Price_Symbol")) {
                                                    pluginPriceSymbol = pluginTypeDataSection.getString(pluginTypeData);
                                                }
                                                else {
                                                    if (!pluginTypeData.equalsIgnoreCase("Price_Value")) {
                                                        continue;
                                                    }
                                                    pluginPriceValue = pluginTypeDataSection.getDouble(pluginTypeData);
                                                }
                                            }
                                            final PluginTypePropertiesBuild pluginTypeProperties = new PluginTypePropertiesBuild(pluginType, pluginVersion, pluginWebsite, pluginPriceSymbol, pluginPriceValue);
                                            mapPluginTypeProperties.put(pluginType, pluginTypeProperties);
                                        }
                                    }
                                }
                                final PluginPropertiesStreamBuild pluginPropertiesStream = new PluginPropertiesStreamBuild(activated, pluginName, company, author, owner, website, developer, mapPluginTypeProperties);
                                this.mapPluginProperties.put(pluginName, pluginPropertiesStream);
                            }
                        }
                    }
                }
            }
        }
    }
}
