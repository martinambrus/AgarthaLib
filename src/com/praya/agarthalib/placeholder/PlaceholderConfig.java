// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.placeholder;

import org.bukkit.configuration.ConfigurationSection;
import java.util.Iterator;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.utility.FileUtil;
import com.praya.agarthalib.AgarthaLib;
import java.util.HashMap;
import com.praya.agarthalib.handler.HandlerConfig;

public class PlaceholderConfig extends HandlerConfig
{
    private static final String PATH_FILE = "Configuration/placeholder.yml";
    protected final HashMap<String, String> mapPlaceholder;
    
    protected PlaceholderConfig(final AgarthaLib plugin) {
        super(plugin);
        this.mapPlaceholder = new HashMap<String, String>();
        this.setup();
    }
    
    @Override
    public final void setup() {
        this.reset();
        this.loadConfig();
    }
    
    private final void reset() {
        this.mapPlaceholder.clear();
    }
    
    private final void loadConfig() {
        final File file = FileUtil.getFile(this.plugin, "Configuration/placeholder.yml");
        if (!file.exists()) {
            FileUtil.saveResource(this.plugin, "Configuration/placeholder.yml");
        }
        final FileConfiguration config = FileUtil.getFileConfiguration(file);
        for (final String key : config.getKeys(false)) {
            if (key.equalsIgnoreCase("Placeholder")) {
                final ConfigurationSection placeholderSection = config.getConfigurationSection(key);
                for (final String placeholder : placeholderSection.getKeys(false)) {
                    this.mapPlaceholder.put(placeholder, placeholderSection.getString(placeholder));
                }
            }
        }
    }
}
