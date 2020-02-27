// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib;

import org.bukkit.configuration.ConfigurationSection;
import java.util.Iterator;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.utility.FileUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import com.praya.agarthalib.handler.HandlerConfig;

public final class AgarthaLibConfig extends HandlerConfig
{
    private static final String PATH_FILE = "Configuration/config.yml";
    private final FileConfiguration config;
    
    protected AgarthaLibConfig(final AgarthaLib plugin) {
        super(plugin);
        this.config = (FileConfiguration)new YamlConfiguration();
        this.setup();
    }
    
    public final String getGeneralVersion() {
        return this.config.getString("Configuration.General.Version");
    }
    
    public final String getGeneralLocale() {
        return this.config.getString("Configuration.General.Locale");
    }
    
    public final boolean isMetricsMessage() {
        return this.config.getBoolean("Configuration.Metrics.Message");
    }
    
    public final boolean isHookMessage() {
        return this.config.getBoolean("Configuration.Hook.Message");
    }
    
    public final boolean updaterMessage() {
        return this.config.getBoolean("Configuration.Updater.Message");
    }
    
    public final String getPatternSpecial() {
        return this.config.getString("Configuration.Pattern.Special");
    }
    
    public final String getUtilityTooltip() {
        return this.config.getString("Configuration.Utility.Tooltip");
    }
    
    public final String getUtilityCurrency() {
        return this.config.getString("Configuration.Utility.Currency");
    }
    
    public final int getBarLength() {
        return this.config.getInt("Configuration.Bar.Length");
    }
    
    public final String getBarSymbol() {
        return this.config.getString("Configuration.Bar.Symbol");
    }
    
    public final String getBarFill() {
        return this.config.getString("Configuration.Bar.Fill");
    }
    
    public final String getBarEmpty() {
        return this.config.getString("Configuration.Bar.Empty");
    }
    
    public final double getEffectRange() {
        return this.config.getDouble("Configuration.Effect.Range");
    }
    
    public final int getListContent() {
        return this.config.getInt("Configuration.List.Content");
    }
    
    public final boolean isEventEnableRegion() {
        return this.config.getBoolean("Configuration.Event.Enable_Region");
    }
    
    public final boolean isDamageEnableFormula() {
        return this.config.getBoolean("Configuration.Damage.Enable_Formula");
    }
    
    public final double getDamageMinValue() {
        return this.config.getDouble("Configuration.Damage.Min_Value");
    }
    
    public final double getDamageScaleDefense() {
        return this.config.getDouble("Configuration.Damage.Scale_Defense");
    }
    
    @Override
    public final void setup() {
        final File file = FileUtil.getFile(this.plugin, "Configuration/config.yml");
        if (!file.exists()) {
            FileUtil.saveResource(this.plugin, "Configuration/config.yml");
        }
        final FileConfiguration configurationResource = FileUtil.getFileConfigurationResource(this.plugin, "Configuration/config.yml");
        final FileConfiguration configurationFile = FileUtil.getFileConfiguration(file);
        this.loadConfig(this.config, configurationResource);
        this.loadConfig(this.config, configurationFile);
    }
    
    private final void loadConfig(final FileConfiguration config, final FileConfiguration source) {
        for (final String key : source.getKeys(false)) {
            if (key.equalsIgnoreCase("Configuration") || key.equalsIgnoreCase("Config")) {
                final ConfigurationSection dataSection = source.getConfigurationSection(key);
                for (final String data : dataSection.getKeys(false)) {
                    if (data.equalsIgnoreCase("General")) {
                        final ConfigurationSection generalDataSection = dataSection.getConfigurationSection(data);
                        for (final String generalData : generalDataSection.getKeys(false)) {
                            if (generalData.equalsIgnoreCase("Version")) {
                                final String path = "Configuration.General.Version";
                                final String generalVersion = generalDataSection.getString(generalData);
                                config.set("Configuration.General.Version", (Object)generalVersion);
                            }
                            else {
                                if (!generalData.equalsIgnoreCase("Locale")) {
                                    continue;
                                }
                                final String path = "Configuration.General.Locale";
                                final String generalLocale = generalDataSection.getString(generalData);
                                config.set("Configuration.General.Locale", (Object)generalLocale);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("Metrics")) {
                        final ConfigurationSection metricsDataSection = dataSection.getConfigurationSection(data);
                        for (final String metricsData : metricsDataSection.getKeys(false)) {
                            if (metricsData.equalsIgnoreCase("Message")) {
                                final String path = "Configuration.Metrics.Message";
                                final boolean metricsMessage = metricsDataSection.getBoolean(metricsData);
                                config.set("Configuration.Metrics.Message", (Object)metricsMessage);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("Hook")) {
                        final ConfigurationSection hookDataSection = dataSection.getConfigurationSection(data);
                        for (final String hookData : hookDataSection.getKeys(false)) {
                            if (hookData.equalsIgnoreCase("Message")) {
                                final String path = "Configuration.Hook.Message";
                                final boolean hookMessage = hookDataSection.getBoolean(hookData);
                                config.set("Configuration.Hook.Message", (Object)hookMessage);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("Updater")) {
                        final ConfigurationSection updaterDataSection = dataSection.getConfigurationSection(data);
                        for (final String updaterData : updaterDataSection.getKeys(false)) {
                            if (updaterData.equalsIgnoreCase("Message")) {
                                final String path = "Configuration.Updater.Message";
                                final boolean updaterMessage = updaterDataSection.getBoolean(updaterData);
                                config.set("Configuration.Updater.Message", (Object)updaterMessage);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("Pattern")) {
                        final ConfigurationSection patternDataSection = dataSection.getConfigurationSection(data);
                        for (final String patternData : patternDataSection.getKeys(false)) {
                            if (patternData.equalsIgnoreCase("Special")) {
                                final String path = "Configuration.Pattern.Special";
                                final String patternSpecial = patternDataSection.getString(patternData);
                                config.set("Configuration.Pattern.Special", (Object)patternSpecial);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("Utility")) {
                        final ConfigurationSection utilityDataSection = dataSection.getConfigurationSection(data);
                        for (final String utilityData : utilityDataSection.getKeys(false)) {
                            if (utilityData.equalsIgnoreCase("Tooltip")) {
                                final String path = "Configuration.Utility.Tooltip";
                                final String utilityTooltip = utilityDataSection.getString(utilityData);
                                config.set("Configuration.Utility.Tooltip", (Object)utilityTooltip);
                            }
                            else {
                                if (!utilityData.equalsIgnoreCase("Currency")) {
                                    continue;
                                }
                                final String path = "Configuration.Utility.Currency";
                                final String utilityCurrency = utilityDataSection.getString(utilityData);
                                config.set("Configuration.Utility.Currency", (Object)utilityCurrency);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("Bar")) {
                        final ConfigurationSection barDataSection = dataSection.getConfigurationSection(data);
                        for (final String barData : barDataSection.getKeys(false)) {
                            if (barData.equalsIgnoreCase("Length")) {
                                final String path = "Configuration.Bar.Length";
                                final int barLength = barDataSection.getInt(barData);
                                config.set("Configuration.Bar.Length", (Object)barLength);
                            }
                            else if (barData.equalsIgnoreCase("Symbol")) {
                                final String path = "Configuration.Bar.Symbol";
                                final String barSymbol = barDataSection.getString(barData);
                                config.set("Configuration.Bar.Symbol", (Object)barSymbol);
                            }
                            else if (barData.equalsIgnoreCase("Fill")) {
                                final String path = "Configuration.Bar.Fill";
                                final String barFill = barDataSection.getString(barData);
                                config.set("Configuration.Bar.Fill", (Object)barFill);
                            }
                            else {
                                if (!barData.equalsIgnoreCase("Empty")) {
                                    continue;
                                }
                                final String path = "Configuration.Bar.Empty";
                                final String barEmpty = barDataSection.getString(barData);
                                config.set("Configuration.Bar.Empty", (Object)barEmpty);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("Effect")) {
                        final ConfigurationSection effectDataSection = dataSection.getConfigurationSection(data);
                        for (final String effectData : effectDataSection.getKeys(false)) {
                            if (effectData.equalsIgnoreCase("Range")) {
                                final String path = "Configuration.Effect.Range";
                                final double effectRange = effectDataSection.getDouble(effectData);
                                config.set("Configuration.Effect.Range", (Object)effectRange);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("List")) {
                        final ConfigurationSection listDataSection = dataSection.getConfigurationSection(data);
                        for (final String listData : listDataSection.getKeys(false)) {
                            if (listData.equalsIgnoreCase("Content")) {
                                final String path = "Configuration.List.Content";
                                final int listContent = listDataSection.getInt(listData);
                                config.set("Configuration.List.Content", (Object)listContent);
                            }
                        }
                    }
                    else if (data.equalsIgnoreCase("Event")) {
                        final ConfigurationSection eventDataSection = dataSection.getConfigurationSection(data);
                        for (final String eventData : eventDataSection.getKeys(false)) {
                            if (eventData.equalsIgnoreCase("Enable_Region")) {
                                final String path = "Configuration.Event.Enable_Region";
                                final boolean eventEnableRegion = eventDataSection.getBoolean(eventData);
                                config.set("Configuration.Event.Enable_Region", (Object)eventEnableRegion);
                            }
                        }
                    }
                    else {
                        if (!data.equalsIgnoreCase("Damage")) {
                            continue;
                        }
                        final ConfigurationSection damageDataSection = dataSection.getConfigurationSection(data);
                        for (final String damageData : damageDataSection.getKeys(false)) {
                            if (damageData.equalsIgnoreCase("Enable_Formula")) {
                                final String path = "Configuration.Damage.Enable_Formula";
                                final boolean damageEnableFormula = damageDataSection.getBoolean(damageData);
                                config.set("Configuration.Damage.Enable_Formula", (Object)damageEnableFormula);
                            }
                            else if (damageData.equalsIgnoreCase("Min_Value")) {
                                final String path = "Configuration.Damage.Min_Value";
                                final double damageMinValue = damageDataSection.getDouble(damageData);
                                config.set("Configuration.Damage.Min_Value", (Object)damageMinValue);
                            }
                            else {
                                if (!damageData.equalsIgnoreCase("Scale_Defense")) {
                                    continue;
                                }
                                final String path = "Configuration.Damage.Scale_Defense";
                                final double damageScaleDefense = damageDataSection.getDouble(damageData);
                                config.set("Configuration.Damage.Scale_Defense", (Object)damageScaleDefense);
                            }
                        }
                    }
                }
            }
        }
    }
}
