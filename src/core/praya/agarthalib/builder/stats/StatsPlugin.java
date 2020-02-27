// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.stats;

import java.util.Iterator;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import java.util.HashMap;

public class StatsPlugin
{
    private final StatsType type;
    private final String plugin;
    private final HashMap<String, StatsProperties> mapStatsProperties;
    
    protected StatsPlugin(final StatsType type, final Plugin plugin) {
        this.type = type;
        this.plugin = plugin.getName();
        this.mapStatsProperties = new HashMap<String, StatsProperties>();
    }
    
    public final StatsType getType() {
        return this.type;
    }
    
    public final String getPlugin() {
        return this.plugin;
    }
    
    public final Collection<String> getStatsIDs() {
        return this.mapStatsProperties.keySet();
    }
    
    public final Collection<StatsProperties> getAllStatsProperties() {
        return this.mapStatsProperties.values();
    }
    
    public final StatsProperties getStatsProperties(final String id) {
        if (id != null) {
            for (final String key : this.getStatsIDs()) {
                if (key.equalsIgnoreCase(id)) {
                    return this.mapStatsProperties.get(key);
                }
            }
        }
        return null;
    }
    
    public final boolean isExists(final String id) {
        return this.getStatsProperties(id) != null;
    }
    
    public final double getValue(final String id) {
        final StatsProperties statsProperties = this.getStatsProperties(id);
        return (statsProperties != null) ? statsProperties.getValue() : this.getType().getValue();
    }
    
    public final double getTotalValue() {
        final StatsType.StatsTypeAction action = this.getType().getAction();
        double totalValue = this.getType().getValue();
        for (final StatsProperties statsProperties : this.getAllStatsProperties()) {
            final double value = statsProperties.getValue();
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
    
    public final void setValue(final String id, final double value) {
        if (id != null) {
            if (this.isExists(id)) {
                final StatsProperties statsProperties = this.getStatsProperties(id);
                statsProperties.setValue(value);
            }
            else {
                final StatsProperties statsProperties = new StatsProperties(id, value);
                this.mapStatsProperties.put(id, statsProperties);
            }
        }
    }
    
    public final void remove(final String id) {
        final StatsProperties statsProperties = this.getStatsProperties(id);
        if (statsProperties != null) {
            final String statsID = statsProperties.getID();
            this.mapStatsProperties.remove(statsID);
        }
    }
}
