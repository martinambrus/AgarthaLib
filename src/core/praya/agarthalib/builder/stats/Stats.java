// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.stats;

import java.util.Iterator;
import org.bukkit.plugin.Plugin;
import java.util.Collection;
import java.util.HashMap;

public class Stats
{
    private final StatsType type;
    private final HashMap<String, StatsPlugin> mapStatsPlugin;
    
    protected Stats(final StatsType type) {
        this.type = type;
        this.mapStatsPlugin = new HashMap<String, StatsPlugin>();
    }
    
    public final StatsType getType() {
        return this.type;
    }
    
    public final Collection<String> getPlugins() {
        return this.mapStatsPlugin.keySet();
    }
    
    public final Collection<StatsPlugin> getAllStatsPlugin() {
        return this.mapStatsPlugin.values();
    }
    
    public final StatsPlugin getStatsPlugin(final Plugin plugin) {
        if (plugin != null) {
            final String pluginName = plugin.getName();
            return this.getStatsPlugin(pluginName);
        }
        return null;
    }
    
    public final StatsPlugin getStatsPlugin(final String plugin) {
        if (plugin != null) {
            for (final String key : this.getPlugins()) {
                if (key.equalsIgnoreCase(plugin)) {
                    return this.mapStatsPlugin.get(key);
                }
            }
        }
        return null;
    }
    
    public final boolean isExists(final Plugin plugin) {
        return this.getStatsPlugin(plugin) != null;
    }
    
    public final boolean isExists(final String plugin) {
        return this.getStatsPlugin(plugin) != null;
    }
    
    public final double getValue(final Plugin plugin) {
        return this.getValue(plugin, null);
    }
    
    public final double getValue(final Plugin plugin, final String id) {
        if (plugin != null) {
            final String pluginName = plugin.getName();
            return this.getValue(pluginName, id);
        }
        return this.getType().getValue();
    }
    
    public final double getValue(final String plugin, final String id) {
        final StatsPlugin statsPlugin = this.getStatsPlugin(plugin);
        return (statsPlugin != null) ? statsPlugin.getValue(id) : this.getType().getValue();
    }
    
    public final double getTotalValueByPlugin(final Plugin plugin) {
        if (plugin != null) {
            final String pluginName = plugin.getName();
            return this.getTotalValueByPlugin(pluginName);
        }
        return this.getType().getValue();
    }
    
    public final double getTotalValueByPlugin(final String plugin) {
        if (plugin != null) {
            final StatsPlugin statsPlugin = this.getStatsPlugin(plugin);
            return statsPlugin.getTotalValue();
        }
        return this.getType().getValue();
    }
    
    public final double getTotalValueByID(final String id) {
        final StatsType.StatsTypeAction action = this.getType().getAction();
        double totalValue = this.getType().getValue();
        if (id != null) {
            for (final StatsPlugin statsPlugin : this.getAllStatsPlugin()) {
                final double value = statsPlugin.getValue(id);
                if (action.equals(StatsType.StatsTypeAction.ACCRETION)) {
                    totalValue += value;
                }
                else {
                    if (!action.equals(StatsType.StatsTypeAction.MULTIPLICATION)) {
                        continue;
                    }
                    totalValue *= value;
                }
            }
        }
        return totalValue;
    }
    
    public final double getTotalValue() {
        final StatsType.StatsTypeAction action = this.getType().getAction();
        double totalValue = this.getType().getValue();
        for (final StatsPlugin statsPlugin : this.getAllStatsPlugin()) {
            final double value = statsPlugin.getTotalValue();
            if (action.equals(StatsType.StatsTypeAction.ACCRETION)) {
                totalValue += value;
            }
            else {
                if (!action.equals(StatsType.StatsTypeAction.MULTIPLICATION)) {
                    continue;
                }
                totalValue *= value;
            }
        }
        return totalValue;
    }
    
    public final void setValue(final Plugin plugin, final String id, final double value) {
        if (plugin != null && id != null) {
            if (this.isExists(plugin)) {
                final StatsPlugin statsPlugin = this.getStatsPlugin(plugin);
                statsPlugin.setValue(id, value);
            }
            else {
                final StatsType type = this.getType();
                final String pluginName = plugin.getName();
                final StatsPlugin statsPlugin2 = new StatsPlugin(type, plugin);
                statsPlugin2.setValue(id, value);
                this.mapStatsPlugin.put(pluginName, statsPlugin2);
            }
        }
    }
}
