// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.command;

import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import java.util.Iterator;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.Collection;
import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.utility.FileUtil;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.command.CommandBuild;
import java.util.HashMap;
import com.praya.agarthalib.handler.HandlerConfig;

public class CommandConfig extends HandlerConfig
{
    private static final String PATH_FILE = "Resources/command.yml";
    protected final HashMap<String, CommandBuild> mapCommandBuild;
    
    public CommandConfig(final AgarthaLib plugin) {
        super(plugin);
        this.mapCommandBuild = new HashMap<String, CommandBuild>();
        this.setup();
    }
    
    @Override
    public final void setup() {
        this.reset();
        this.loadConfig();
    }
    
    private final void reset() {
        this.mapCommandBuild.clear();
    }
    
    private final void loadConfig() {
        final FileConfiguration config = FileUtil.getFileConfigurationResource(this.plugin, "Resources/command.yml");
        for (final String key : config.getKeys(false)) {
            final ConfigurationSection keyDataSection = config.getConfigurationSection(key);
            for (final String keyData : keyDataSection.getKeys(false)) {
                if (keyDataSection.isConfigurationSection(keyData)) {
                    final ConfigurationSection mainDataSection = keyDataSection.getConfigurationSection(keyData);
                    final String id = String.valueOf(key) + "_" + keyData;
                    final List<String> aliases = new ArrayList<String>();
                    String main = null;
                    String permission = null;
                    for (final String mainData : mainDataSection.getKeys(false)) {
                        if (mainData.equalsIgnoreCase("Main")) {
                            main = mainDataSection.getString(mainData);
                        }
                        else if (mainData.equalsIgnoreCase("Permission")) {
                            permission = mainDataSection.getString(mainData);
                        }
                        else {
                            if (!mainData.equalsIgnoreCase("Aliases")) {
                                continue;
                            }
                            if (mainDataSection.isString(mainData)) {
                                aliases.add(mainDataSection.getString(mainData));
                            }
                            else {
                                if (!mainDataSection.isList(mainData)) {
                                    continue;
                                }
                                aliases.addAll(mainDataSection.getStringList(mainData));
                            }
                        }
                    }
                    if (main == null) {
                        continue;
                    }
                    final CommandBuild commandBuild = new CommandBuild(id, main, permission, aliases);
                    this.mapCommandBuild.put(id, commandBuild);
                }
            }
        }
    }
}
