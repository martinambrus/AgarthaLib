// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.effect;

import java.util.Iterator;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import java.util.HashMap;

public class EffectPlugin
{
    private final String plugin;
    private final HashMap<String, EffectProperties> mapEffectProperties;
    
    protected EffectPlugin(final Plugin plugin) {
        this(plugin, null);
    }
    
    protected EffectPlugin(final Plugin plugin, final HashMap<String, EffectProperties> mapEffectProperties) {
        if (plugin == null) {
            throw new IllegalArgumentException();
        }
        this.plugin = plugin.getName();
        this.mapEffectProperties = ((mapEffectProperties != null) ? mapEffectProperties : new HashMap<String, EffectProperties>());
    }
    
    public String getPlugin() {
        return this.plugin;
    }
    
    public final Collection<String> getKeys() {
        return this.mapEffectProperties.keySet();
    }
    
    public final Collection<EffectProperties> getAllEffectProperties() {
        return this.mapEffectProperties.values();
    }
    
    public final EffectProperties getEffectProperties(final String key) {
        if (key != null) {
            for (final String propertiesKey : this.getKeys()) {
                if (propertiesKey.equalsIgnoreCase(key)) {
                    return this.mapEffectProperties.get(propertiesKey);
                }
            }
        }
        return null;
    }
    
    public final boolean isExists(final String key) {
        return this.getEffectProperties(key) != null;
    }
    
    public final boolean isEmpty() {
        return this.getAllEffectProperties().isEmpty();
    }
    
    public final double getTotalValue() {
        double totalValue = 0.0;
        for (final EffectProperties effectProperties : this.getAllEffectProperties()) {
            final double value = effectProperties.getValue();
            totalValue += value;
        }
        return totalValue;
    }
    
    public final void setEffect(final String key, final Double value) {
        this.setEffect(key, value, null);
    }
    
    public final void setEffect(final String key, final Double value, final Integer duration) {
        if (key != null) {
            if (this.isExists(key)) {
                final EffectProperties effectProperties = this.getEffectProperties(key);
                effectProperties.setValue(value);
                effectProperties.setDuration(duration);
            }
            else {
                final EffectProperties effectProperties = new EffectProperties(key, value, duration);
                this.mapEffectProperties.put(key, effectProperties);
            }
        }
    }
    
    public final void removeEffect(final String key) {
        this.mapEffectProperties.remove(key);
    }
}
